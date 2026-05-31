import { useCallback, useRef, useState } from 'react'
import { Download } from 'lucide-react'
import { type DragEndEvent } from '@dnd-kit/core'
import { arrayMove } from '@dnd-kit/sortable'
import { useI18n } from '@/i18n'
import { useStore } from '@/store'
import ColorPicker from '@/components/shared/ColorPicker'
import ColorInput, { type ColorInputHandle } from '@/components/shared/ColorInput'
import DraggableNickList from '@/components/shared/DraggableNickList'
import SpecialKeyButtons from '@/components/shared/SpecialKeyButtons'
import { Button } from '@/components/ui/button'

interface Props {
  onGenerate: () => void
}

const COLORS = [
  { hex: '#ffb300', key: 'color.default', code: '^0' },
  { hex: '#ff0000', key: 'color.red', code: '^1' },
  { hex: '#00ff00', key: 'color.green', code: '^2' },
  { hex: '#ffff00', key: 'color.yellow', code: '^3' },
  { hex: '#0000ff', key: 'color.blue', code: '^4' },
  { hex: '#00ffff', key: 'color.lightBlue', code: '^5' },
  { hex: '#ff00ff', key: 'color.purple', code: '^6' },
  { hex: '#898993', key: 'color.gray', code: '^7' },
  { hex: '#ffffff', key: 'color.white', code: '^8' },
]

export default function NamesTab({ onGenerate }: Props) {
  const { t, lang } = useI18n()
  const mainNick = useStore((s) => s.mainNick)
  const setMainNick = useStore((s) => s.setMainNick)
  const bindKey = useStore((s) => s.bindKey)
  const setBindKey = useStore((s) => s.setBindKey)
  const nickItems = useStore((s) => s.nickItems)
  const reorderNickItems = useStore((s) => s.reorderNickItems)
  const addNickItem = useStore((s) => s.addNickItem)
  const removeNickItem = useStore((s) => s.removeNickItem)
  const updateNickItem = useStore((s) => s.updateNickItem)
  const [bindFocused, setBindFocused] = useState(false)
  const bindInputRef = useRef<HTMLInputElement>(null)
  const mainNickRef = useRef<ColorInputHandle>(null)
  const quickNickRefs = useRef<Record<string, ColorInputHandle | null>>({})
  const focusedInputRef = useRef<string | null>(null)

  const handleColorSelect = useCallback(
    (code: string) => {
      const id = focusedInputRef.current
      if (id === 'main') {
        mainNickRef.current?.applyColor(code)
      } else if (id && id.startsWith('nick-')) {
        quickNickRefs.current[id]?.applyColor(code)
      }
    },
    [],
  )

  const handleDragEnd = useCallback(
    (event: DragEndEvent) => {
      const { active, over } = event
      if (!over || active.id === over.id) return
      const oldIndex = nickItems.findIndex((i) => i.id === active.id)
      const newIndex = nickItems.findIndex((i) => i.id === over.id)
      reorderNickItems(arrayMove(nickItems, oldIndex, newIndex))
    },
    [nickItems, reorderNickItems],
  )

  return (
    <div className="flex justify-center gap-8 h-full">
      {/* Left panel */}
      <div className="w-full max-w-xl flex flex-col min-h-0">
        <section className="flex-shrink-0">
          <div className="flex items-center gap-3 mb-3">
            <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
            <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
              {t('names.mainNick')}
            </h2>
          </div>
          <div className="w-full bg-white/[0.04] border border-white/[0.08] rounded-lg px-4 py-3 text-base
                          focus-within:border-[#f37b22]/40 focus-within:bg-[#f37b22]/[0.03]
                          focus-within:shadow-[0_0_12px_rgba(243,123,34,0.08)] transition-all">
            <ColorInput
              ref={mainNickRef}
              value={mainNick}
              onChange={setMainNick}
              inputId="main"
              onFocus={() => { focusedInputRef.current = 'main' }}
              onBlur={() => { focusedInputRef.current = null }}
              placeholder={t('names.mainNickPlaceholder')}
              className="w-full"
            />
          </div>
        </section>

        <section className="flex flex-col flex-1 min-h-0 mt-10">
          <div className="flex items-center gap-3 mb-4 flex-shrink-0">
            <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
            <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
              {t('names.quickNick')}
            </h2>
          </div>

          <div className="flex items-center gap-3 mb-3 flex-shrink-0">
            <label className="text-xs text-white/40 font-body">{t('names.bindKey')}</label>
            <input
              ref={bindInputRef}
              type="text"
              value={bindKey}
              onChange={(e) => {
                const val = e.target.value.toUpperCase()
                if (val.length <= 1) setBindKey(val)
              }}
              onFocus={() => setBindFocused(true)}
              onBlur={() => setBindFocused(false)}
              placeholder="F1"
              className="w-36 bg-white/[0.04] border border-white/[0.08] rounded-lg px-3 py-2 text-sm text-white font-body text-center
                         placeholder:text-white/[0.15] focus:outline-none focus:border-[#f37b22]/40 focus:bg-[#f37b22]/[0.03]
                         focus:shadow-[0_0_12px_rgba(243,123,34,0.08)] transition-all uppercase"
            />
          </div>

          <div className="flex-1 overflow-y-auto min-h-0 pr-1 scrollbar-thin">
            <DraggableNickList
              items={nickItems}
              onUpdate={updateNickItem}
              onRemove={removeNickItem}
              onAdd={addNickItem}
              onDragEnd={handleDragEnd}
              nickRefs={quickNickRefs}
              onNickFocus={(id) => { focusedInputRef.current = id }}
              onNickBlur={() => { focusedInputRef.current = null }}
            />
          </div>
        </section>
      </div>

      {/* Right panel — color card + special keys */}
      <div className="w-72 flex-shrink-0">
        <div className="sticky top-0 bg-white/[0.03] border border-white/[0.06] rounded-xl overflow-hidden">
          <div className="h-1 bg-gradient-to-r from-[#f37b22]/60 to-[#f37b22]/10" />
          <div className="p-5 space-y-5">
            <div>
              <div className="flex items-center gap-3 mb-3">
                <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
                <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
                  {t('names.colorPicker')}
                </h2>
              </div>
              <ColorPicker colors={COLORS} onSelect={handleColorSelect} />
            </div>

            <div className="pt-2 border-t border-white/[0.06]">
              <img
                src={lang === 'es' ? '/assets/text-colors-es.png' : '/assets/text-colors.png'}
                alt="Text color examples"
                className="w-full h-auto rounded-lg"
              />
            </div>

            <div className="pt-2 border-t border-white/[0.06]">
              <div className="flex items-center gap-3 mb-3 mt-1">
                <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
                <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
                  {t('names.specialKeys')}
                </h2>
                {!bindFocused && (
                  <span className="text-[10px] text-white/20 font-body ml-auto">
                    focus input
                  </span>
                )}
              </div>
              <SpecialKeyButtons
                onSelect={(key) => {
                  setBindKey(key)
                  bindInputRef.current?.focus()
                }}
                disabled={!bindFocused}
              />
              <p className="text-[10px] text-white/15 font-body mt-2 leading-relaxed">
                {bindFocused
                  ? t('names.specialKeysHint')
                  : t('names.specialKeysFocusHint')}
              </p>
            </div>

            <div className="pt-2 border-t border-white/[0.06]">
              <Button
                onClick={onGenerate}
                className="w-full bg-[#f37b22] hover:bg-[#d46612] text-white font-body font-semibold
                           shadow-[0_0_16px_rgba(243,123,34,0.25)] hover:shadow-[0_0_24px_rgba(243,123,34,0.4)]
                           transition-all duration-200 cursor-pointer py-3"
              >
                <Download className="w-4 h-4 mr-2" />
                {t('generate.button')}
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}
