import { useRef, useState, useCallback } from 'react'
import { Layers } from 'lucide-react'
import { useI18n } from '@/i18n'
import { useStore } from '@/store'
import SpecialKeyButtons from '@/components/shared/SpecialKeyButtons'
import { Button } from '@/components/ui/button'

interface Props {
  onGenerate: () => void
}

const SLOT_COUNT = 10

export default function SlotsTab({ onGenerate }: Props) {
  const { t } = useI18n()
  const slotMode = useStore((s) => s.slotMode)
  const setSlotMode = useStore((s) => s.setSlotMode)
  const slotBinds = useStore((s) => s.slotBinds)
  const setSlotBind = useStore((s) => s.setSlotBind)
  const focusedSlot = useStore((s) => s.focusedSlot)
  const setFocusedSlot = useStore((s) => s.setFocusedSlot)
  const [focusedLocal, setFocusedLocal] = useState(false)
  const inputRefs = useRef<Record<number, HTMLInputElement | null>>({})

  const handleSpecialKey = useCallback((key: string) => {
    if (focusedSlot === null) return
    setSlotBind(focusedSlot, key)
    inputRefs.current[focusedSlot]?.focus()
  }, [focusedSlot, setSlotBind])

  const handleRowClick = useCallback((index: number) => {
    inputRefs.current[index]?.focus()
  }, [])

  const hasImage = (index: number) => index < 5

  return (
    <div className="flex justify-center gap-8 h-full">
      <div className="w-full max-w-xl flex flex-col min-h-0">
        <div className="flex items-center gap-3 mb-4 flex-shrink-0">
          <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
          <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
            {t('slots.title')}
          </h2>
        </div>

        <div className="flex-shrink-0 space-y-2 mb-5">
          <label className="flex items-start gap-3 cursor-pointer group">
            <input
              type="radio"
              name="slotMode"
              checked={slotMode === 'none'}
              onChange={() => setSlotMode('none')}
              className="mt-0.5 accent-[#f37b22] cursor-pointer"
            />
            <div>
              <span className="text-sm text-white/80 font-body group-hover:text-white transition-colors">
                {t('slots.none')}
              </span>
            </div>
          </label>
          <label className="flex items-start gap-3 cursor-pointer group">
            <input
              type="radio"
              name="slotMode"
              checked={slotMode === 'numpad'}
              onChange={() => setSlotMode('numpad')}
              className="mt-0.5 accent-[#f37b22] cursor-pointer"
            />
            <div>
              <span className="text-sm text-white/80 font-body group-hover:text-white transition-colors">
                {t('slots.numpad')}
              </span>
              <p className="text-[11px] text-white/30 font-body mt-0.5 leading-relaxed">
                {t('slots.numpadDesc')}
              </p>
            </div>
          </label>
          <label className="flex items-start gap-3 cursor-pointer group">
            <input
              type="radio"
              name="slotMode"
              checked={slotMode === 'custom'}
              onChange={() => setSlotMode('custom')}
              className="mt-0.5 accent-[#f37b22] cursor-pointer"
            />
            <div>
              <span className="text-sm text-white/80 font-body group-hover:text-white transition-colors">
                {t('slots.custom')}
              </span>
            </div>
          </label>
        </div>

        <div className="flex-1 overflow-y-auto min-h-0 pr-1 space-y-1 scrollbar-thin">
          {Array.from({ length: SLOT_COUNT }, (_, i) => i).map((index) => (
            <div
              key={index}
              role="button"
              tabIndex={-1}
              onClick={() => slotMode !== 'none' && handleRowClick(index)}
              onKeyDown={() => {}}
              className={`flex items-center gap-3 px-3 py-2 rounded-lg border transition-all ${
                slotMode !== 'none' && 'cursor-pointer'
              } ${
                focusedSlot === index
                  ? 'bg-[#f37b22]/5 border-[#f37b22]/25'
                  : slotMode !== 'none'
                  ? 'bg-white/[0.03] border-white/[0.06] hover:bg-white/[0.06] hover:border-white/[0.12]'
                  : 'bg-white/[0.03] border-white/[0.06] opacity-50'
              }`}
            >
              <div className="w-9 h-9 flex items-center justify-center flex-shrink-0 bg-white/[0.04] rounded">
                {hasImage(index) ? (
                  <img
                    src={`/assets/slots/slot${index + 1}.png`}
                    alt={`Slot ${index + 1}`}
                    className="w-8 h-8 object-contain"
                  />
                ) : (
                  <Layers className="w-4 h-4 text-white/20" />
                )}
              </div>
              <span className="text-sm text-white/70 font-body flex-1 min-w-0 truncate">
                {t('slots.slotPrefix')} {index + 1}
              </span>
              <div className="flex items-center gap-2 flex-shrink-0">
                <span className="text-[10px] text-white/30 font-body uppercase tracking-wider">
                  {t('slots.bindLabel')}
                </span>
                <input
                  ref={(el) => { inputRefs.current[index] = el }}
                  type="text"
                  value={slotMode === 'numpad' ? NUMPAD_DISPLAY[index] : slotBinds[index]}
                  readOnly={slotMode !== 'custom'}
                  onChange={(e) => {
                    if (slotMode === 'custom') {
                      const val = e.target.value.toUpperCase()
                      if (val.length <= 1) setSlotBind(index, val)
                    }
                  }}
                  onFocus={() => {
                    if (slotMode === 'none') return
                    setFocusedSlot(index); setFocusedLocal(true)
                  }}
                  onBlur={() => { setFocusedSlot(null); setFocusedLocal(false) }}
                  maxLength={1}
                  className={`w-24 bg-white/[0.04] border border-white/[0.08] rounded-lg px-2.5 py-1.5 text-sm text-white font-body text-center
                             focus:outline-none focus:border-[#f37b22]/40 focus:bg-[#f37b22]/[0.03]
                             focus:shadow-[0_0_12px_rgba(243,123,34,0.08)] transition-all uppercase
                             ${slotMode !== 'custom' ? 'text-white/20 cursor-default' : ''}`}
                />
              </div>
            </div>
          ))}
        </div>
      </div>

      <div className="w-72 flex-shrink-0">
        <div className="sticky top-0 bg-white/[0.03] border border-white/[0.06] rounded-xl overflow-hidden">
          <div className="h-1 bg-gradient-to-r from-[#f37b22]/60 to-[#f37b22]/10" />
          <div className="p-5 space-y-5">
            <div>
              <div className="flex items-center gap-3 mb-3">
                <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
                <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
                  {t('slots.preview')}
                </h2>
              </div>
              <div className="h-44 flex items-center justify-center bg-white/[0.02] border border-white/[0.06] rounded-lg overflow-hidden">
                {focusedSlot !== null ? (
                  hasImage(focusedSlot) ? (
                    <img
                      src={`/assets/slots/slot${focusedSlot + 1}.png`}
                      alt=""
                      className="max-h-full max-w-full object-contain p-2"
                    />
                  ) : (
                    <p className="text-xs text-white/20 font-body text-center px-2">
                      {t('slots.noImage')}
                    </p>
                  )
                ) : (
                  <p className="text-xs text-white/20 font-body text-center px-2">
                    {t('slots.previewHint')}
                  </p>
                )}
              </div>
            </div>

            <div className="pt-2 border-t border-white/[0.06]">
              <div className="flex items-center gap-3 mb-3 mt-1">
                <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
                <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
                  {t('names.specialKeys')}
                </h2>
                {!focusedLocal && (
                  <span className="text-[10px] text-white/20 font-body ml-auto">
                    focus input
                  </span>
                )}
              </div>
              <SpecialKeyButtons
                onSelect={handleSpecialKey}
                disabled={!focusedLocal || slotMode !== 'custom'}
              />
              <p className="text-[10px] text-white/15 font-body mt-2 leading-relaxed">
                {focusedLocal && slotMode === 'custom'
                  ? t('names.specialKeysHint')
                  : slotMode === 'none'
                  ? t('slots.noneHint')
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
                <Layers className="w-4 h-4 mr-2" />
                {t('generate.button')}
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

const NUMPAD_DISPLAY = [
  'KP_END', 'KP_DOWNARROW', 'KP_PGDN', 'KP_LEFTARROW', 'KP_5',
  'KP_RIGHTARROW', 'KP_HOME', 'KP_UPARROW', 'KP_PGUP', 'KP_INS',
]
