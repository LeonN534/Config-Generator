import { forwardRef, useEffect, useImperativeHandle, useRef, useCallback } from 'react'

const COLOR_MAP: Record<string, string> = {
  '^0': '#ffb300',
  '^1': '#ff0000',
  '^2': '#00ff00',
  '^3': '#ffff00',
  '^4': '#0000ff',
  '^5': '#00ffff',
  '^6': '#ff00ff',
  '^7': '#898993',
  '^8': '#ffffff',
}

const HEX_TO_CODE: Record<string, string> = {}
for (const [code, hex] of Object.entries(COLOR_MAP)) {
  HEX_TO_CODE[hex.toLowerCase()] = code
}

interface Seg {
  code: string
  text: string
}

function parseSegments(value: string): Seg[] {
  const segs: Seg[] = []
  let i = 0
  let currentCode = '^0'
  while (i < value.length) {
    if (value[i] === '^' && i + 1 < value.length && value[i + 1] >= '0' && value[i + 1] <= '9') {
      currentCode = value.substring(i, i + 2)
      i += 2
    } else {
      let text = ''
      while (i < value.length && !(value[i] === '^' && i + 1 < value.length && value[i + 1] >= '0' && value[i + 1] <= '9')) {
        text += value[i]
        i++
      }
      if (text) segs.push({ code: currentCode, text })
    }
  }
  return segs
}

function escapeHtml(s: string): string {
  return s.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;')
}

function toHtml(value: string): string {
  if (!value) return ''
  return parseSegments(value)
    .map((s) => `<span style="color:${COLOR_MAP[s.code]}">${escapeHtml(s.text)}</span>`)
    .join('')
}

function serialize(el: HTMLElement): string {
  let result = ''
  for (const node of el.childNodes) {
    if (node instanceof Text) {
      result += '^0' + node.textContent
    } else if (node instanceof HTMLElement && node.tagName === 'SPAN') {
      const color = node.style.color?.toLowerCase()
      const code = color ? (HEX_TO_CODE[color] || '^0') : '^0'
      result += code + (node.textContent || '')
    }
  }
  return result
}

function insertColorCode(value: string, selStart: number, selEnd: number, code: string): string {
  const segs = parseSegments(value)
  const parts: string[] = []
  let pos = 0
  let inSelection = false

  for (const seg of segs) {
    const segStart = pos
    const segEnd = pos + seg.text.length

    if (segEnd <= selStart) {
      parts.push(seg.code + seg.text)
    } else if (segStart >= selEnd) {
      parts.push(seg.code + seg.text)
    } else {
      const beforeSel = Math.max(0, selStart - segStart)
      const afterSel = Math.max(0, segEnd - selEnd)
      const selLen = seg.text.length - beforeSel - afterSel

      if (beforeSel > 0) {
        parts.push(seg.code + seg.text.slice(0, beforeSel))
      }

      if (selLen > 0) {
        if (!inSelection) {
          parts.push(code)
          inSelection = true
        }
        parts.push(seg.text.slice(beforeSel, beforeSel + selLen))
      }

      if (afterSel > 0) {
        parts.push(seg.code + seg.text.slice(beforeSel + selLen))
      }
    }

    pos = segEnd
  }

  return parts.join('')
}

function getPlainTextOffsets(el: HTMLElement): { start: number; end: number } | null {
  const sel = window.getSelection()
  if (!sel || !sel.rangeCount) return null
  const range = sel.getRangeAt(0)
  if (!el.contains(range.commonAncestorContainer)) return null
  const preRange = document.createRange()
  preRange.selectNodeContents(el)
  preRange.setEnd(range.startContainer, range.startOffset)
  const start = preRange.toString().length
  const end = start + range.toString().length
  return { start, end }
}

export interface ColorInputHandle {
  applyColor: (code: string) => void
}

interface Props {
  value: string
  onChange: (value: string) => void
  maxLength?: number
  placeholder?: string
  className?: string
  inputId?: string
  onFocus?: () => void
  onBlur?: () => void
}

const ColorInput = forwardRef<ColorInputHandle, Props>(
  ({ value, onChange, maxLength = 32, placeholder, className = '', inputId, onFocus, onBlur }, ref) => {
    const divRef = useRef<HTMLDivElement>(null)
    const lastValue = useRef(value)

    useEffect(() => {
      if (!divRef.current) return
      try {
        const currentSerialized = serialize(divRef.current)
        if (currentSerialized === value) return
      } catch {
        // fall through to update
      }
      lastValue.current = value
      divRef.current.innerHTML = toHtml(value) || ''
    }, [value])

    const handleInput = useCallback(() => {
      if (!divRef.current) return
      const text = divRef.current.textContent || ''
      if (text.length > maxLength) {
        divRef.current.innerHTML = toHtml(lastValue.current) || ''
        const range = document.createRange()
        range.selectNodeContents(divRef.current)
        range.collapse(false)
        const sel = window.getSelection()
        if (sel) {
          sel.removeAllRanges()
          sel.addRange(range)
        }
        return
      }
      const newValue = serialize(divRef.current)
      lastValue.current = newValue
      onChange(newValue)
    }, [onChange, maxLength])

    const handleKeyDown = useCallback(
      (e: React.KeyboardEvent) => {
        if (e.key === 'Enter') {
          e.preventDefault()
        }
      },
      [],
    )

    useImperativeHandle(
      ref,
      () => ({
        applyColor(code: string) {
          const el = divRef.current
          if (!el) return
          const offsets = getPlainTextOffsets(el)
          if (!offsets || offsets.start === offsets.end) return
          const newValue = insertColorCode(value, offsets.start, offsets.end, code)
          if (newValue !== value) {
            lastValue.current = newValue
            onChange(newValue)
          }
        },
      }),
      [value, onChange],
    )

    return (
      <div
        ref={divRef}
        contentEditable
        suppressContentEditableWarning
        onInput={handleInput}
        onKeyDown={handleKeyDown}
        onFocus={onFocus}
        onBlur={onBlur}
        data-color-input
        data-color-input-id={inputId || ''}
        className={`text-sm text-[#ffb300] font-body whitespace-nowrap overflow-hidden
                     focus:outline-none cursor-text
                     [&:empty:before]:content-[attr(data-placeholder)]
                     [&:empty:before]:text-white/[0.15]
                     [&:empty:before]:pointer-events-none ${className}`}
        data-placeholder={placeholder || ''}
        {...(value ? {} : {})}
      />
    )
  },
)

ColorInput.displayName = 'ColorInput'

export default ColorInput
