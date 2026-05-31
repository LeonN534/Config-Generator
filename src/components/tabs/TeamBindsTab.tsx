import { useRef, useState, useCallback } from 'react'
import { HelpCircle, MessageCircle } from 'lucide-react'
import { useI18n } from '@/i18n'
import { useStore } from '@/store'
import SpecialKeyButtons from '@/components/shared/SpecialKeyButtons'
import { Button } from '@/components/ui/button'

interface Props {
  onGenerate: () => void
}

const TEAM_BIND_LIST: { id: string; nameKey: string }[] = [
  { id: 'drop', nameKey: 'teambinds.drop' },
  { id: 'location', nameKey: 'teambinds.location' },
  { id: 'attack', nameKey: 'teambinds.attack' },
  { id: 'using', nameKey: 'teambinds.using' },
  { id: 'dont-shoot', nameKey: 'teambinds.dontshoot' },
  { id: 'need-weapon', nameKey: 'teambinds.needweapon' },
  { id: 'in-position', nameKey: 'teambinds.inposition' },
  { id: 'need-backup', nameKey: 'teambinds.needbackup' },
  { id: 'affirmative', nameKey: 'teambinds.affirmative' },
  { id: 'negative', nameKey: 'teambinds.negative' },
  { id: 'go', nameKey: 'teambinds.gogogo' },
  { id: 'sector-clear', nameKey: 'teambinds.sectorclear' },
  { id: 'regroup', nameKey: 'teambinds.regroup' },
  { id: 'cover-me', nameKey: 'teambinds.coverme' },
]

export default function TeamBindsTab({ onGenerate }: Props) {
  const { t } = useI18n()
  const teamBinds = useStore((s) => s.teamBinds)
  const setTeamBind = useStore((s) => s.setTeamBind)
  const focusedTeamBind = useStore((s) => s.focusedTeamBind)
  const setFocusedTeamBind = useStore((s) => s.setFocusedTeamBind)
  const [focusedLocal, setFocusedLocal] = useState(false)
  const [showDropTooltip, setShowDropTooltip] = useState(false)
  const [dropTooltipPos, setDropTooltipPos] = useState({ x: 0, y: 0 })
  const [showUsingTooltip, setShowUsingTooltip] = useState(false)
  const [usingTooltipPos, setUsingTooltipPos] = useState({ x: 0, y: 0 })
  const inputRefs = useRef<Record<number, HTMLInputElement | null>>({})
  const dropIconRef = useRef<HTMLSpanElement>(null)
  const usingIconRef = useRef<HTMLSpanElement>(null)

  const handleSpecialKey = useCallback((key: string) => {
    if (focusedTeamBind === null) return
    setTeamBind(focusedTeamBind, key)
    inputRefs.current[focusedTeamBind]?.focus()
  }, [focusedTeamBind, setTeamBind])

  const handleRowClick = useCallback((index: number) => {
    inputRefs.current[index]?.focus()
  }, [])

  const focusedImage = focusedTeamBind !== null ? TEAM_BIND_LIST[focusedTeamBind]?.id : null

  return (
    <div className="flex justify-center gap-8 h-full">
      <div className="w-full max-w-xl flex flex-col min-h-0">
        <div className="flex items-center gap-3 mb-4 flex-shrink-0">
          <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
          <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
            {t('teambinds.title')}
          </h2>
        </div>

        <div className="flex-1 overflow-y-auto min-h-0 pr-1 space-y-1 scrollbar-thin">
          {TEAM_BIND_LIST.map((bind, index) => (
            <div
              key={bind.id}
              role="button"
              tabIndex={-1}
              onClick={() => handleRowClick(index)}
              onKeyDown={() => {}}
              className={`flex items-center gap-3 px-3 py-2 rounded-lg border transition-all cursor-pointer ${
                focusedTeamBind === index
                  ? 'bg-[#f37b22]/5 border-[#f37b22]/25'
                  : 'bg-white/[0.03] border-white/[0.06] hover:bg-white/[0.06] hover:border-white/[0.12]'
              }`}
            >
              <div className="w-9 h-9 flex items-center justify-center flex-shrink-0 bg-white/[0.04] rounded overflow-hidden">
                <img
                  src={`/assets/team-binds/${bind.id}.png`}
                  alt=""
                  className="w-7 h-7 object-contain"
                />
              </div>
              <div className="flex items-center gap-1.5 flex-1 min-w-0">
                <span className="text-sm text-white/70 font-body truncate">
                  {t(bind.nameKey)}
                </span>
                {(index === 0 || index === 3) && (
                  <span
                    ref={index === 0 ? dropIconRef : usingIconRef}
                    className="flex-shrink-0"
                    onMouseEnter={() => {
                      const el = index === 0 ? dropIconRef.current : usingIconRef.current
                      if (el) {
                        const r = el.getBoundingClientRect()
                        const pos = { x: r.right + 8, y: r.top + r.height / 2 }
                        if (index === 0) {
                          setDropTooltipPos(pos)
                          setShowDropTooltip(true)
                        } else {
                          setUsingTooltipPos(pos)
                          setShowUsingTooltip(true)
                        }
                      }
                    }}
                    onMouseLeave={() => {
                      if (index === 0) setShowDropTooltip(false)
                      else setShowUsingTooltip(false)
                    }}
                  >
                    <HelpCircle className="w-3.5 h-3.5 text-white/30 hover:text-[#f37b22] transition-colors cursor-help" />
                  </span>
                )}
              </div>
              <div className="flex items-center gap-2 flex-shrink-0">
                <span className="text-[10px] text-white/30 font-body uppercase tracking-wider">
                  {t('teambinds.bindLabel')}
                </span>
                <input
                  ref={(el) => { inputRefs.current[index] = el }}
                  type="text"
                  value={teamBinds[index]}
                  onChange={(e) => {
                    const val = e.target.value.toUpperCase()
                    if (val.length <= 1) setTeamBind(index, val)
                  }}
                  onFocus={() => { setFocusedTeamBind(index); setFocusedLocal(true) }}
                  onBlur={() => { setFocusedTeamBind(null); setFocusedLocal(false) }}
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
                  {t('teambinds.preview')}
                </h2>
              </div>
              <div className="h-44 flex items-center justify-center bg-white/[0.02] border border-white/[0.06] rounded-lg overflow-hidden">
                {focusedImage ? (
                  <img
                    src={`/assets/team-binds/${focusedImage}.png`}
                    alt=""
                    className="max-h-full max-w-full object-contain p-2"
                  />
                ) : (
                  <p className="text-xs text-white/20 font-body text-center px-2">
                    {t('teambinds.previewHint')}
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
                <MessageCircle className="w-4 h-4 mr-2" />
                {t('generate.button')}
              </Button>
            </div>
          </div>
        </div>
      </div>

      {showDropTooltip && (
        <div
          className="fixed bg-[#1a1a1a] border border-white/[0.08] rounded-lg px-3 py-1.5 text-[11px] text-white/70 font-body whitespace-nowrap shadow-lg z-50 pointer-events-none"
          style={{ left: dropTooltipPos.x, top: dropTooltipPos.y, transform: 'translateY(-50%)' }}
        >
          <div className="absolute right-full top-1/2 -translate-y-1/2 w-2 h-2 bg-[#1a1a1a] border-l border-t border-white/[0.08] rotate-45 -ml-1" />
          {t('teambinds.dropTooltip')}
        </div>
      )}
      {showUsingTooltip && (
        <div
          className="fixed bg-[#1a1a1a] border border-white/[0.08] rounded-lg px-3 py-1.5 text-[11px] text-white/70 font-body whitespace-nowrap shadow-lg z-50 pointer-events-none"
          style={{ left: usingTooltipPos.x, top: usingTooltipPos.y, transform: 'translateY(-50%)' }}
        >
          <div className="absolute right-full top-1/2 -translate-y-1/2 w-2 h-2 bg-[#1a1a1a] border-l border-t border-white/[0.08] rotate-45 -ml-1" />
          {t('teambinds.usingTooltip')}
        </div>
      )}
    </div>
  )
}
