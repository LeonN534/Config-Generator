import { useRef, useState, useCallback } from 'react'
import { HelpCircle, ScrollText } from 'lucide-react'
import { useI18n } from '@/i18n'
import { useStore } from '@/store'
import SpecialKeyButtons from '@/components/shared/SpecialKeyButtons'
import { Button } from '@/components/ui/button'

interface Props {
  onGenerate: () => void
}

const SCRIPTS: { id: string; nameKey: string }[] = [
  { id: 'autobunnyhop', nameKey: 'scripts.autobunnyhop' },
  { id: 'decentjump', nameKey: 'scripts.decentjump' },
  { id: 'quickbow', nameKey: 'scripts.quickbow' },
  { id: 'climbing', nameKey: 'scripts.climbing' },
  { id: 'ducktap', nameKey: 'scripts.ducktap' },
  { id: 'duckroll', nameKey: 'scripts.duckroll' },
  { id: 'impulsegauss', nameKey: 'scripts.impulsegauss' },
  { id: 'longjump', nameKey: 'scripts.longjump' },
  { id: 'silentlongjump', nameKey: 'scripts.silentlongjump' },
  { id: 'sneaking', nameKey: 'scripts.sneaking' },
  { id: 'realnames', nameKey: 'scripts.realnames' },
  { id: 'demorecorder', nameKey: 'scripts.demorecorder' },
  { id: 'lowsensitivity', nameKey: 'scripts.lowsensitivity' },
  { id: 'quickuse', nameKey: 'scripts.quickuse' },
]

export default function ScriptsTab({ onGenerate }: Props) {
  const { t } = useI18n()
  const scriptBinds = useStore((s) => s.scriptBinds)
  const setScriptBind = useStore((s) => s.setScriptBind)
  const focusedScript = useStore((s) => s.focusedScript)
  const setFocusedScript = useStore((s) => s.setFocusedScript)
  const autobunnyhopMode = useStore((s) => s.autobunnyhopMode)
  const setAutobunnyhopMode = useStore((s) => s.setAutobunnyhopMode)
  const lowSensitivityValue = useStore((s) => s.lowSensitivityValue)
  const setLowSensitivityValue = useStore((s) => s.setLowSensitivityValue)
  const [focusedLocal, setFocusedLocal] = useState(false)
  const [showQuTooltip, setShowQuTooltip] = useState(false)
  const [quTooltipPos, setQuTooltipPos] = useState({ x: 0, y: 0 })
  const inputRefs = useRef<Record<number, HTMLInputElement | null>>({})
  const lsSensRef = useRef<HTMLInputElement | null>(null)
  const quIconRef = useRef<HTMLSpanElement>(null)

  const handleSpecialKey = useCallback((key: string) => {
    if (focusedScript === null) return
    setScriptBind(focusedScript, key)
    inputRefs.current[focusedScript]?.focus()
  }, [focusedScript, setScriptBind])

  const handleRowClick = useCallback((index: number) => {
    inputRefs.current[index]?.focus()
  }, [])

  return (
    <div className="flex justify-center gap-8 h-full">
      <div className="w-full max-w-xl flex flex-col min-h-0">
        <div className="flex items-center gap-3 mb-4 flex-shrink-0">
          <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
          <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
            {t('scripts.title')}
          </h2>
        </div>

        <div className="flex-1 overflow-y-auto min-h-0 pr-1 space-y-1 scrollbar-thin">
          {SCRIPTS.map((script, index) => (
            <div
              key={script.id}
              role="button"
              tabIndex={-1}
              onClick={() => handleRowClick(index)}
              onKeyDown={() => {}}
              className={`flex items-center gap-3 px-3 py-2 rounded-lg border transition-all cursor-pointer ${
                focusedScript === index
                  ? 'bg-[#f37b22]/5 border-[#f37b22]/25'
                  : 'bg-white/[0.03] border-white/[0.06] hover:bg-white/[0.06] hover:border-white/[0.12]'
              }`}
            >
              <div className="w-9 h-9 flex items-center justify-center flex-shrink-0 bg-white/[0.04] rounded">
                <ScrollText className="w-4 h-4 text-white/20" />
              </div>
              <div className="flex items-center gap-1.5 flex-1 min-w-0">
                <span className="text-sm text-white/70 font-body truncate">
                  {t(script.nameKey)}
                </span>
                {index === 13 && (
                  <span
                    ref={quIconRef}
                    className="flex-shrink-0"
                    onMouseEnter={() => {
                      if (quIconRef.current) {
                        const r = quIconRef.current.getBoundingClientRect()
                        setQuTooltipPos({ x: r.right + 8, y: r.top + r.height / 2 })
                        setShowQuTooltip(true)
                      }
                    }}
                    onMouseLeave={() => setShowQuTooltip(false)}
                  >
                    <HelpCircle className="w-3.5 h-3.5 text-white/30 hover:text-[#f37b22] transition-colors cursor-help" />
                  </span>
                )}
              </div>
              {index === 0 && (
                <div className="flex items-center bg-white/[0.04] border border-white/[0.08] rounded-lg overflow-hidden flex-shrink-0">
                   <button
                    onClick={(e) => { e.stopPropagation(); setAutobunnyhopMode('steam') }}
                    className={`px-2.5 py-1 text-[11px] font-body font-semibold uppercase tracking-wider transition-colors cursor-pointer ${
                      autobunnyhopMode === 'steam'
                        ? 'bg-[#f37b22] text-white'
                        : 'text-white/40 hover:text-white/70'
                    }`}
                  >
                    Steam
                  </button>
                  <button
                    onClick={(e) => { e.stopPropagation(); setAutobunnyhopMode('nosteam') }}
                    className={`px-2.5 py-1 text-[11px] font-body font-semibold uppercase tracking-wider transition-colors cursor-pointer ${
                      autobunnyhopMode === 'nosteam'
                        ? 'bg-[#f37b22] text-white'
                        : 'text-white/40 hover:text-white/70'
                    }`}
                  >
                    No Steam
                  </button>
                </div>
              )}
              {index === 12 && (
                <div className="flex items-center gap-2 flex-shrink-0">
                  <span className="text-[10px] text-white/30 font-body uppercase tracking-wider">
                    {t('scripts.sensitivity')}
                  </span>
                  <input
                    ref={lsSensRef}
                    type="text"
                    value={lowSensitivityValue}
                    onChange={(e) => {
                      const val = e.target.value
                      if (/^-?\d*\.?\d{0,2}$/.test(val) || val === '')
                        setLowSensitivityValue(val)
                    }}
                    className="w-16 bg-white/[0.04] border border-white/[0.08] rounded-lg px-2.5 py-1.5 text-sm text-white font-body text-center
                               placeholder:text-white/[0.15] focus:outline-none focus:border-[#f37b22]/40 focus:bg-[#f37b22]/[0.03]
                               focus:shadow-[0_0_12px_rgba(243,123,34,0.08)] transition-all"
                    placeholder="0.50"
                    onClick={(e) => e.stopPropagation()}
                  />
                </div>
              )}
              <div className="flex items-center gap-2 flex-shrink-0">
                <span className="text-[10px] text-white/30 font-body uppercase tracking-wider">
                  {t('scripts.bindLabel')}
                </span>
                <input
                  ref={(el) => { inputRefs.current[index] = el }}
                  type="text"
                  value={scriptBinds[index]}
                  onChange={(e) => {
                    const val = e.target.value.toUpperCase()
                    if (val.length <= 1) setScriptBind(index, val)
                  }}
                  onFocus={() => { setFocusedScript(index); setFocusedLocal(true) }}
                  onBlur={() => { setFocusedScript(null); setFocusedLocal(false) }}
                  maxLength={1}
                  className="w-24 bg-white/[0.04] border border-white/[0.08] rounded-lg px-2.5 py-1.5 text-sm text-white font-body text-center
                             placeholder:text-white/[0.15] focus:outline-none focus:border-[#f37b22]/40 focus:bg-[#f37b22]/[0.03]
                             focus:shadow-[0_0_12px_rgba(243,123,34,0.08)] transition-all uppercase"
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
                  {t('scripts.preview')}
                </h2>
              </div>
              <div className="h-44 flex items-center justify-center bg-white/[0.02] border border-white/[0.06] rounded-lg">
                <p className="text-xs text-white/20 font-body text-center px-4 leading-relaxed">
                  {t('scripts.comingSoon')}
                </p>
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
                disabled={!focusedLocal}
              />
              <p className="text-[10px] text-white/15 font-body mt-2 leading-relaxed">
                {focusedLocal
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
                <ScrollText className="w-4 h-4 mr-2" />
                {t('generate.button')}
              </Button>
            </div>
          </div>
        </div>
      </div>
      {showQuTooltip && (
        <div
          className="fixed bg-[#1a1a1a] border border-white/[0.08] rounded-lg px-3 py-1.5 text-[11px] text-white/70 font-body whitespace-nowrap shadow-lg z-50 pointer-events-none"
          style={{ left: quTooltipPos.x, top: quTooltipPos.y, transform: 'translateY(-50%)' }}
        >
          This key replaces the default +use command. It cannot be used
          together with the Using team communication bind.
        </div>
      )}
    </div>
  )
}
