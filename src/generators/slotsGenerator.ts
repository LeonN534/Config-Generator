import { generateTitle, normalizeBindKey } from './titleHelper'

const NUMPAD_KEYS = [
  'KP_END', 'KP_DOWNARROW', 'KP_PGDN', 'KP_LEFTARROW', 'KP_5',
  'KP_RIGHTARROW', 'KP_HOME', 'KP_UPARROW', 'KP_PGUP', 'KP_INS',
]

export function generateSlots(state: {
  slotMode: string
  slotBinds: string[]
}): string {
  const lines: string[] = [
    generateTitle('SLOTS'),
    '',
  ]

  if (state.slotMode === 'numpad') {
    for (let i = 0; i < 10; i++) {
      const key = NUMPAD_KEYS[i]
      const sep = `"${key}"`.length > 7 ? '\t' : '\t\t'
      lines.push(`bind\t"${key}"${sep}"slot${i + 1}"`)
    }
  } else {
    const filtered: { key: string; slot: string }[] = []
    for (let i = 0; i < 10; i++) {
      const k = state.slotBinds[i]?.trim()
      if (k) filtered.push({ key: normalizeBindKey(k), slot: `slot${i + 1}` })
    }
    if (filtered.length === 0) return ''
    for (const { key, slot } of filtered) {
      const sep = `"${key}"`.length > 7 ? '\t' : '\t\t'
      lines.push(`bind\t"${key}"${sep}"${slot}"`)
    }
  }

  return lines.join('\n')
}
