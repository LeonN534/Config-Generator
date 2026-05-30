import type { NickItem } from '@/store'

function stripDefault(code: string): string {
  return code.replace(/^\^0/, '')
}

interface NamesState {
  mainNick: string
  nickItems: NickItem[]
  bindKey: string
}

export function generateNames(state: NamesState): string {
  const mainNick = stripDefault(state.mainNick)
  const nickItems = state.nickItems.map((i) => ({ ...i, value: stripDefault(i.value) }))

  const hasMainNick = mainNick.trim() !== ''
  const hasQuickNicks = nickItems.some((i) => i.value.trim() !== '')

  if (!hasMainNick && !hasQuickNicks) return ''

  const lines: string[] = [
    '//',
    '//    N A M E S',
    '//    *********',
    '//',
    '',
  ]

  if (hasMainNick) {
    lines.push(`name\t"${mainNick}"`)
  }

  if (hasQuickNicks) {
    lines.push('')

    const N = nickItems.length
    lines.push(`alias\t"names"\t\t"nick1"`)
    for (let i = 0; i < N; i++) {
      const val = nickItems[i].value || '""'
      lines.push(`alias\t"nick${i + 1}"\t\t"alias names nick${i + 2}; name ${val}"`)
    }
    const closingCmd = mainNick
      ? `alias names nick1; name ${mainNick}`
      : 'alias names nick1'
    lines.push(`alias\t"nick${N + 1}"\t\t"${closingCmd}"`)

    lines.push('')
    lines.push(`bind\t"${state.bindKey}"\t\t"names"`)
  }

  return lines.join('\n')
}
