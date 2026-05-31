const SPECIAL_KEYS = new Set([
  'MOUSE1', 'MOUSE2', 'MOUSE3', 'MOUSE4', 'MOUSE5',
  'MWHEELDOWN', 'MWHEELUP', 'CTRL', 'SHIFT', 'TAB',
  'ALT', 'SPACE', 'CAPSLOCK',
])

export function generateTitle(word: string): string {
  const spaced = word.split('').join(' ')
  const stars = '*'.repeat(spaced.length)
  return [
    '//',
    '//',
    `//\t${spaced}`,
    `//\t${stars}`,
    '//',
    '//',
  ].join('\n')
}

export function normalizeBindKey(key: string): string {
  return SPECIAL_KEYS.has(key) ? key : key.toLowerCase()
}
