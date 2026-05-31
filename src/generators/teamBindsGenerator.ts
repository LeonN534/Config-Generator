import { generateTitle, normalizeBindKey } from './titleHelper'

interface Entry {
  alias: string
  header: string
  stars: string
  cmd: string
}

const ENTRIES: Entry[] = [
  { alias: 'dropsound', header: 'Drop', stars: '****', cmd: 'say_close ^5-- ^2Dropped %w ^5-- ^2%L^5 --; drop; play_close fvox/beep.wav' },
  { alias: 'loc', header: 'Location', stars: '********', cmd: 'say_team At ^2%L ^1(^5%H^1/^5%A^1)^0' },
  { alias: 'at5', header: 'Attack', stars: '******', cmd: 'say_team Attacking in ^15 ^0seconds; play_team hgrunt/go!.wav;customtimer 5' },
  { alias: '+use2', header: 'Using', stars: '**********', cmd: '+use;say_team ^8Recharging at ^7[^5%l^7]^0 ^7[^5%h^7|^5%a^7]^0' },
  { alias: 'donts', header: 'Dont Shoot', stars: '**********', cmd: "say_close ^4(--^8Dont shot me^4--)^0; play_close scientist/c1a3_sci_team.wav" },
  { alias: 'needw', header: 'Need Weapon', stars: '***********', cmd: 'say_team ^3-- ^8Need a weapoN ^3-- ^3[^1%l^3] --; play_team scientist/gottogetout.wav' },
  { alias: 'inpos', header: 'In Position', stars: '***********', cmd: "say_team ^3(^5RADIO^3) ^2I'm in position ^6[^8%L^6] ^2and need a weapon;play_team radio/ct_inpos.wav" },
  { alias: 'backup', header: 'Need Backup', stars: '***********', cmd: 'say_team ^3(^5RADIO^3) ^2Need backup ^6[^8%L^6]; play_team hgrunt/backup!.wav' },
  { alias: 'affirm', header: 'Affirmative', stars: '***********', cmd: 'say ^3(^5RADIO^3) ^2Affirmative; yes; play radio/ct_affirm.wav' },
  { alias: 'negative', header: 'Negative', stars: '********', cmd: 'say ^3(^5RADIO^3) ^2Negative; no; play radio/negative.wav' },
  { alias: 'go', header: 'Go go go!', stars: '*********', cmd: 'say_close ^3(^5RADIO^3) ^2Go go go^6!!!; play_close radio/com_go.wav' },
  { alias: 'sclear', header: 'Sector Clear', stars: '************', cmd: 'say_team ^3(^5RADIO^3) ^2Sector Clear ^6[^8%L^6]; play_team hgrunt/clear!.wav' },
  { alias: 'regroup', header: 'Regroup Team', stars: '************', cmd: 'say_team ^3(^5RADIO^3) ^2Regroup Team ^6[^8%L^6]; play_team radio/regroup.wav' },
  { alias: 'coverme', header: 'Cover me', stars: '********', cmd: 'say_close ^3(^5RADIO^3) ^2Cover Me^6!!!; play_close hgrunt/cover!.wav' },
]

export function generateTeamBinds(teamBinds: string[]): string {
  const sections: string[] = []

  for (let i = 0; i < ENTRIES.length; i++) {
    const rawKey = teamBinds[i]?.trim()
    if (!rawKey) continue

    const key = normalizeBindKey(rawKey)
    const e = ENTRIES[i]

    if (i === 3) {
      sections.push(
        `//\t${e.header}\n`
        + `//\t${e.stars}\n\n`
        + `alias\t"${e.alias}"\t\t"${e.cmd}"\n`
        + `alias\t"-use2"\t\t"-use"\n`
        + `bind\t"${key}"\t\t"${e.alias}"`,
      )
    } else {
      sections.push(
        `//\t${e.header}\n`
        + `//\t${e.stars}\n\n`
        + `alias\t"${e.alias}"\t\t"${e.cmd}"\n`
        + `bind\t"${key}"\t\t"${e.alias}"`,
      )
    }
  }

  if (sections.length === 0) return ''

  return `${generateTitle('TEAM COMMUNICATION')}\n\n${sections.join('\n\n')}`
}
