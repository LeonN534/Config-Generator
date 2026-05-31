import { useRef, useState, useCallback } from 'react'
import { Download } from 'lucide-react'
import { useI18n } from '@/i18n'
import { useStore, type WeaponBinding } from '@/store'
import SpecialKeyButtons from '@/components/shared/SpecialKeyButtons'
import { Button } from '@/components/ui/button'

interface Props {
  onGenerate: () => void
}

const WEAPON_LIST: { id: string; name: string }[] = [
  { id: '9mmAR', name: '9mm Assault Rifle' },
  { id: 'crossbow', name: 'Crossbow' },
  { id: 'crowbar', name: 'Crowbar' },
  { id: 'egon', name: 'Egon' },
  { id: 'gauss', name: 'Gauss' },
  { id: 'handgrenade', name: 'Hand Grenade' },
  { id: 'handgun', name: 'Handgun' },
  { id: 'hornetgun', name: 'Hornet Gun' },
  { id: 'magnum', name: 'Magnum' },
  { id: 'rpg', name: 'RPG' },
  { id: 'satchel', name: 'Satchel' },
  { id: 'shotgun', name: 'Shotgun' },
  { id: 'snarks', name: 'Snarks' },
  { id: 'tripmine', name: 'Tripmine' },
]

export default function WeaponsTab({ onGenerate }: Props) {
  const { t } = useI18n()
  const weapons = useStore((s) => s.weapons)
  const setWeaponBind = useStore((s) => s.setWeaponBind)
  const focusedWeapon = useStore((s) => s.focusedWeapon)
  const setFocusedWeapon = useStore((s) => s.setFocusedWeapon)
  const [focusedLocal, setFocusedLocal] = useState(false)
  const inputRefs = useRef<Record<string, HTMLInputElement | null>>({})

  const handleSpecialKey = useCallback((key: string) => {
    if (!focusedWeapon) return
    setWeaponBind(focusedWeapon, key)
    inputRefs.current[focusedWeapon]?.focus()
  }, [focusedWeapon, setWeaponBind])

  const handleRowClick = useCallback((id: string) => {
    inputRefs.current[id]?.focus()
  }, [])

  const getBindValue = (id: string) =>
    weapons.find((w: WeaponBinding) => w.weaponId === id)?.bindKey ?? ''

  return (
    <div className="flex justify-center gap-8 h-full">
      <div className="w-full max-w-xl flex flex-col min-h-0">
        <div className="flex items-center gap-3 mb-4 flex-shrink-0">
          <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
          <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
            {t('weapons.title')}
          </h2>
        </div>

        <div className="flex-1 overflow-y-auto min-h-0 pr-1 space-y-1 scrollbar-thin">
          {WEAPON_LIST.map((wp) => (
            <div
              key={wp.id}
              role="button"
              tabIndex={-1}
              onClick={() => handleRowClick(wp.id)}
              onKeyDown={() => {}}
              className={`flex items-center gap-3 px-3 py-2 rounded-lg border transition-all cursor-pointer ${
                focusedWeapon === wp.id
                  ? 'bg-[#f37b22]/5 border-[#f37b22]/25'
                  : 'bg-white/[0.03] border-white/[0.06] hover:bg-white/[0.06] hover:border-white/[0.12]'
              }`}
            >
              <img
                src={`/assets/weapons/${wp.id}.png`}
                alt={wp.name}
                className="w-9 h-9 object-contain flex-shrink-0"
              />
              <span className="text-sm text-white/70 font-body flex-1 min-w-0 truncate">
                {wp.name}
              </span>
              <div className="flex items-center gap-2 flex-shrink-0">
                <span className="text-[10px] text-white/30 font-body uppercase tracking-wider">
                  {t('weapons.bindLabel')}
                </span>
                <input
                  ref={(el) => { inputRefs.current[wp.id] = el }}
                  type="text"
                  value={getBindValue(wp.id)}
                  onChange={(e) => {
                    const val = e.target.value.toUpperCase()
                    if (val.length <= 1) setWeaponBind(wp.id, val)
                  }}
                  onFocus={() => { setFocusedWeapon(wp.id); setFocusedLocal(true) }}
                  onBlur={() => { setFocusedWeapon(null); setFocusedLocal(false) }}
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
                  {t('weapons.preview')}
                </h2>
              </div>
              <div className="h-44 flex items-center justify-center bg-white/[0.02] border border-white/[0.06] rounded-lg overflow-hidden">
                {focusedWeapon ? (
                  <img
                    src={`/assets/weapons/${focusedWeapon}.png`}
                    alt=""
                    className="max-h-full max-w-full object-contain p-2"
                  />
                ) : (
                  <p className="text-xs text-white/20 font-body text-center px-2">
                    {t('weapons.previewHint')}
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
