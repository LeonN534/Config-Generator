import { Cpu } from 'lucide-react'
import { useI18n } from '@/i18n'
import { useStore } from '@/store'
import { Button } from '@/components/ui/button'

interface Props {
  onGenerate: () => void
}

function Toggle({ value, onChange, label }: {
  value: boolean
  onChange: (v: boolean) => void
  label: string
}) {
  return (
    <div className="flex items-center justify-between gap-3 py-2">
      <span className="text-sm text-white/70 font-body">{label}</span>
      <div className="flex items-center bg-white/[0.04] border border-white/[0.08] rounded-lg overflow-hidden flex-shrink-0">
        <button
          onClick={(e) => { e.stopPropagation(); onChange(true) }}
          className={`px-2.5 py-1 text-[11px] font-body font-semibold uppercase tracking-wider transition-colors cursor-pointer ${
            value
              ? 'bg-[#f37b22] text-white'
              : 'text-white/40 hover:text-white/70'
          }`}
        >
          ON
        </button>
        <button
          onClick={(e) => { e.stopPropagation(); onChange(false) }}
          className={`px-2.5 py-1 text-[11px] font-body font-semibold uppercase tracking-wider transition-colors cursor-pointer ${
            !value
              ? 'bg-[#f37b22] text-white'
              : 'text-white/40 hover:text-white/70'
          }`}
        >
          OFF
        </button>
      </div>
    </div>
  )
}

function TextInput({ value, onChange, placeholder }: {
  value: string
  onChange: (v: string) => void
  placeholder?: string
}) {
  return (
    <input
      type="text"
      value={value}
      onChange={(e) => onChange(e.target.value)}
      placeholder={placeholder}
      className="w-44 bg-white/[0.04] border border-white/[0.08] rounded-lg px-2.5 py-1.5 text-sm text-white font-body
        placeholder:text-white/[0.15] focus:outline-none focus:border-[#f37b22]/40 focus:bg-[#f37b22]/[0.03]
        focus:shadow-[0_0_12px_rgba(243,123,34,0.08)] transition-all"
    />
  )
}

export default function GameplayTab({ onGenerate }: Props) {
  const { t } = useI18n()

  const optimizedVideo = useStore((s) => s.optimizedVideo)
  const setOptimizedVideo = useStore((s) => s.setOptimizedVideo)
  const optimizedSound = useStore((s) => s.optimizedSound)
  const setOptimizedSound = useStore((s) => s.setOptimizedSound)
  const optimizedConnection = useStore((s) => s.optimizedConnection)
  const setOptimizedConnection = useStore((s) => s.setOptimizedConnection)
  const customTextures = useStore((s) => s.customTextures)
  const setCustomTextures = useStore((s) => s.setCustomTextures)
  const autoSwitchBetter = useStore((s) => s.autoSwitchBetter)
  const setAutoSwitchBetter = useStore((s) => s.setAutoSwitchBetter)
  const hideCorpses = useStore((s) => s.hideCorpses)
  const setHideCorpses = useStore((s) => s.setHideCorpses)
  const hideExplosionMarks = useStore((s) => s.hideExplosionMarks)
  const setHideExplosionMarks = useStore((s) => s.setHideExplosionMarks)
  const showWeaponModel = useStore((s) => s.showWeaponModel)
  const setShowWeaponModel = useStore((s) => s.setShowWeaponModel)
  const includeChangeMapAliases = useStore((s) => s.includeChangeMapAliases)
  const setIncludeChangeMapAliases = useStore((s) => s.setIncludeChangeMapAliases)
  const includeChangeModelAliases = useStore((s) => s.includeChangeModelAliases)
  const setIncludeChangeModelAliases = useStore((s) => s.setIncludeChangeModelAliases)
  const includeSmilesAliases = useStore((s) => s.includeSmilesAliases)
  const setIncludeSmilesAliases = useStore((s) => s.setIncludeSmilesAliases)
  const includeSoundFix = useStore((s) => s.includeSoundFix)
  const setIncludeSoundFix = useStore((s) => s.setIncludeSoundFix)
  const includeSpectateAlias = useStore((s) => s.includeSpectateAlias)
  const setIncludeSpectateAlias = useStore((s) => s.setIncludeSpectateAlias)
  const forceEnemyModel = useStore((s) => s.forceEnemyModel)
  const setForceEnemyModel = useStore((s) => s.setForceEnemyModel)
  const forceTeammateModel = useStore((s) => s.forceTeammateModel)
  const setForceTeammateModel = useStore((s) => s.setForceTeammateModel)

  return (
    <div className="flex justify-center gap-8 h-full">
      <div className="w-full max-w-xl flex flex-col min-h-0">
        <div className="flex items-center gap-3 mb-4 flex-shrink-0">
          <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
          <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
            {t('gameplay.title')}
          </h2>
        </div>

        <div className="flex-1 overflow-y-auto min-h-0 pr-1 space-y-5 scrollbar-thin">
          <div className="bg-white/[0.03] border border-white/[0.06] rounded-xl p-5 space-y-3">
            <div className="space-y-0 divide-y divide-white/[0.04]">
              <Toggle value={optimizedVideo} onChange={setOptimizedVideo} label={t('gameplay.optimizedVideo')} />
              <Toggle value={optimizedSound} onChange={setOptimizedSound} label={t('gameplay.optimizedSound')} />
              <Toggle value={optimizedConnection} onChange={setOptimizedConnection} label={t('gameplay.optimizedConnection')} />
              <Toggle value={customTextures} onChange={setCustomTextures} label={t('gameplay.customTextures')} />
              <Toggle value={autoSwitchBetter} onChange={setAutoSwitchBetter} label={t('gameplay.autoSwitchBetter')} />
              <Toggle value={hideCorpses} onChange={setHideCorpses} label={t('gameplay.hideCorpses')} />
              <Toggle value={hideExplosionMarks} onChange={setHideExplosionMarks} label={t('gameplay.hideExplosionMarks')} />
              <Toggle value={showWeaponModel} onChange={setShowWeaponModel} label={t('gameplay.showWeaponModel')} />
              <Toggle value={includeChangeMapAliases} onChange={setIncludeChangeMapAliases} label={t('gameplay.includeChangeMapAliases')} />
              <Toggle value={includeChangeModelAliases} onChange={setIncludeChangeModelAliases} label={t('gameplay.includeChangeModelAliases')} />
              <Toggle value={includeSmilesAliases} onChange={setIncludeSmilesAliases} label={t('gameplay.includeSmilesAliases')} />
              <Toggle value={includeSoundFix} onChange={setIncludeSoundFix} label={t('gameplay.includeSoundFix')} />
              <Toggle value={includeSpectateAlias} onChange={setIncludeSpectateAlias} label={t('gameplay.includeSpectateAlias')} />
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('gameplay.forceEnemyModel')}</span>
                <TextInput value={forceEnemyModel} onChange={setForceEnemyModel} placeholder="red" />
              </div>
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('gameplay.forceTeammateModel')}</span>
                <TextInput value={forceTeammateModel} onChange={setForceTeammateModel} placeholder="blue" />
              </div>
            </div>
          </div>
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
                  {t('gameplay.title')}
                </h2>
              </div>
              <div className="h-44 flex items-center justify-center bg-white/[0.02] border border-white/[0.06] rounded-lg">
                <Cpu className="w-8 h-8 text-white/15" />
              </div>
            </div>

            <div className="pt-2 border-t border-white/[0.06]">
              <Button
                onClick={onGenerate}
                className="w-full bg-[#f37b22] hover:bg-[#d46612] text-white font-body font-semibold
                           shadow-[0_0_16px_rgba(243,123,34,0.25)] hover:shadow-[0_0_24px_rgba(243,123,34,0.4)]
                           transition-all duration-200 cursor-pointer py-3"
              >
                <Cpu className="w-4 h-4 mr-2" />
                {t('generate.button')}
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}
