import type { WeaponBinding } from '@/store'
import { generateTitle, normalizeBindKey } from './titleHelper'

const OUTPUT_ORDER: { id: string; cmd: string }[] = [
  { id: 'crowbar', cmd: 'weapon_crowbar' },
  { id: 'handgun', cmd: 'weapon_9mmhandgun' },
  { id: 'magnum', cmd: 'weapon_357' },
  { id: '9mmAR', cmd: 'weapon_9mmAR' },
  { id: 'shotgun', cmd: 'weapon_shotgun' },
  { id: 'crossbow', cmd: 'weapon_crossbow' },
  { id: 'rpg', cmd: 'weapon_rpg' },
  { id: 'gauss', cmd: 'weapon_gauss' },
  { id: 'egon', cmd: 'weapon_egon' },
  { id: 'hornetgun', cmd: 'weapon_hornetgun' },
  { id: 'handgrenade', cmd: 'weapon_handgrenade' },
  { id: 'satchel', cmd: 'weapon_satchel' },
  { id: 'tripmine', cmd: 'weapon_tripmine' },
  { id: 'snarks', cmd: 'weapon_snarks' },
]

export function generateWeapons(weapons: WeaponBinding[]): string {
  const bindMap = new Map(
    weapons
      .filter((w) => w.bindKey.trim() !== '')
      .map((w) => [w.weaponId, w.bindKey]),
  )
  if (bindMap.size === 0) return ''

  const lines: string[] = [
    generateTitle('WEAPONS'),
    '',
  ]

  for (const { id, cmd } of OUTPUT_ORDER) {
    const key = bindMap.get(id)
    if (key) {
      const norm = normalizeBindKey(key)
      const sep = `"${norm}"`.length > 7 ? '\t' : '\t\t'
      lines.push(`bind\t"${norm}"${sep}"${cmd}"`)
    }
  }

  return lines.join('\n')
}
