import { generateTitle, normalizeBindKey } from './titleHelper'

export function generateScripts(
  scriptBinds: string[],
  autobunnyhopMode: 'steam' | 'nosteam',
  lowSensitivityValue: string,
): string {
  const blocks: string[] = []

  // BunnyHop
  const bhKey = scriptBinds[0]?.trim()
  if (bhKey) {
    const key = normalizeBindKey(bhKey)
    blocks.push(
      '//\tBunnyHop\n'
      + '//\t********\n\n'
      + (autobunnyhopMode === 'steam'
        ? `cl_autojump\t"1"\nbind\t"${key}"\t\t"+jump"`
        : `alias\t"+bunnyhop"\t\t"alias _special @bunnyhop;@bunnyhop"\nalias\t"-bunnyhop"\t\t"alias _special"\nalias\t"@bunnyhop"\t\t"special;wait;+jump;wait;-jump"\nbind\t"${key}"\t\t"+bunnyhop"`),
    )
  }

  // Decent Jump
  const djKey = scriptBinds[1]?.trim()
  if (djKey) {
    const key = normalizeBindKey(djKey)
    blocks.push(
      '//\tDecent Jump\n'
      + '//\t***********\n\n'
      + `alias\t"+decentjump"\t\t"+jump;wait;-jump;wait;+jump;wait;-jump;wait;+jump;wait;-jump;wait;+jump;wait;-jump"\nalias\t"-decentjump"\t\t"-jump"\nbind\t"${key}"\t\t"+decentjump"`,
    )
  }

  // Quick Bow
  const qbKey = scriptBinds[2]?.trim()
  if (qbKey) {
    const key = normalizeBindKey(qbKey)
    blocks.push(
      '//\tQuick Bow\n'
      + '//\t*********\n\n'
      + `alias\t"att"\t\t"+attack2; +attack"\nalias\t"wait2"\t"wait; wait"\nalias\t"noatt"\t"-attack; -attack2"\nalias\t"lastt"\t"lastinv; lastinv"\nalias\t"CF2"\t"att; wait; +reload; wait2; -reload; noatt; lastt"\nbind\t"${key}"\t\t"CF2"`,
    )
  }

  // Climbing
  const clKey = scriptBinds[3]?.trim()
  if (clKey) {
    const key = normalizeBindKey(clKey)
    blocks.push(
      '//\tClimbing\n'
      + '//\t********\n\n'
      + `alias\t"+box"\t\t"+duck;wait;-duck;wait;+duck"\nalias\t"-box"\t\t"-duck"\nbind\t"${key}"\t\t"+box"`,
    )
  }

  // Ducktap
  const dtKey = scriptBinds[4]?.trim()
  if (dtKey) {
    const key = normalizeBindKey(dtKey)
    blocks.push(
      '//\tDucktap\n'
      + '//\t*******\n\n'
      + `bind\t"${key}"\t\t"+ducktap"`,
    )
  }

  // Duckroll
  const drKey = scriptBinds[5]?.trim()
  if (drKey) {
    const key = normalizeBindKey(drKey)
    blocks.push(
      '//\tDuckroll\n'
      + '//\t********\n\n'
      + `alias\t"+duckroll"\t\t"alias _special duckroll;duckroll"\nalias\t"-duckroll"\t\t"alias _special"\nalias\t"duckroll"\t\t"+duck;wait;-duck;wait;special"\nbind\t"${key}"\t\t"+duckroll"`,
    )
  }

  // Impulse Gauss
  const igKey = scriptBinds[6]?.trim()
  if (igKey) {
    const key = normalizeBindKey(igKey)
    blocks.push(
      '//\tImpulse Gauss\n'
      + '//\t*************\n\n'
      + `alias\t"+gauss_jump"\t\t"weapon_gauss;wait;+attack2"\nalias\t"-gauss_jump"\t\t"cl_pitchup 270;cl_pitchspeed 21500;wait;+lookup;wait;-lookup;-attack2;wait;+lookdown;wait;-lookdown;cl_pitchup 89.999"\nbind\t"${key}"\t\t"+gauss_jump"`,
    )
  }

  // Quick Use
  const quKey = scriptBinds[13]?.trim()
  if (quKey) {
    const key = normalizeBindKey(quKey)
    blocks.push(
      '//\tQuick Use\n'
      + '//\t*********\n\n'
      + `alias\t"quse"\t\t"-use;wait;+use;wait;-use"\nbind\t"${key}"\t\t"quse"`,
    )
  }

  // Long Jump
  const ljKey = scriptBinds[7]?.trim()
  if (ljKey) {
    const key = normalizeBindKey(ljKey)
    blocks.push(
      '//\tLong Jump\n'
      + '//\t*********\n\n'
      + `alias\t"+longjump"\t\t"+duck;wait;+jump"\nalias\t"-longjump"\t\t"-jump;-duck"\nbind\t"${key}"\t\t"+longjump"`,
    )
  }

  // Silent Long Jump
  const sljKey = scriptBinds[8]?.trim()
  if (sljKey) {
    const key = normalizeBindKey(sljKey)
    blocks.push(
      '//\tSilent Long Jump\n'
      + '//\t****************\n\n'
      + `alias\t"+silent_lj"\t\t"+forward;wait;+duck;wait;+jump;wait4;-forward"\nalias\t"-silent_lj"\t\t"-jump;-duck;wait;+back;wait8;wait2;-back"\nbind\t"${key}"\t\t"+silent_lj"`,
    )
  }

  // Sneaking
  const snKey = scriptBinds[9]?.trim()
  if (snKey) {
    const key = normalizeBindKey(snKey)
    blocks.push(
      '//\tSneaking\n'
      + '//\t********\n\n'
      + `alias\t"+walk"\t\t"+speed;cl_forwardspeed 400;cl_sidespeed 400;cl_backspeed 400"\nalias\t"-walk"\t\t"-speed;cl_forwardspeed 500;cl_sidespeed 500;cl_backspeed 500"\nalias\t"gaitchange"\t\t"gait_walk"\nalias\t"gait_walk"\t\t"alias gaitchange gait_run;wait;+walk"\nalias\t"gait_run"\t\t"alias gaitchange gait_walk;wait;-Walk"\nbind\t"${key}"\t\t"+walk"`,
    )
  }

  // Realnames
  const rnKey = scriptBinds[10]?.trim()
  if (rnKey) {
    const key = normalizeBindKey(rnKey)
    blocks.push(
      '//\tRealnames\n'
      + '//\t*********\n\n'
      + `alias\t"+realnames"\t\t"loadauthid;+showscores"\nalias\t"-realnames"\t\t"unloadauthid;-showscores"\nbind\t"${key}"\t\t"+realnames"`,
    )
  }

  // Demo Recorder
  const dr2Key = scriptBinds[11]?.trim()
  if (dr2Key) {
    const key = normalizeBindKey(dr2Key)
    blocks.push(
      '//\tDemo Recorder\n'
      + '//\t*************\n\n'
      + `alias\t"rec"\t"demo_record"\nalias\t"demo_record"\t\t"agrecord AGdemo; alias rec demo_stop"\nalias\t"demo_stop"\t\t"stop;+showscores;wait;snapshot;wait;-showscores; alias rec demo_record"\nbind\t"${key}"\t\t"rec"`,
    )
  }

  // Low Sensitivity
  const lsKey = scriptBinds[12]?.trim()
  const lsVal = lowSensitivityValue?.trim()
  if (lsKey && lsVal) {
    const key = normalizeBindKey(lsKey)
    blocks.push(
      '//\tLow Sensitivity\n'
      + '//\t***************\n\n'
      + `bind\t"${key}"\t\t"sensitivity ${lsVal}"`,
    )
  }

  if (blocks.length === 0) return ''

  const header = generateTitle('SCRIPTS')

  const waits = '//\tWaits\n'
    + '//\t*****\n\n'
    + 'alias\t"wait2"\t\t"wait;wait"\n'
    + 'alias\t"wait4"\t\t"wait2;wait2"\n'
    + 'alias\t"wait8"\t\t"wait4;wait4"\n'
    + 'alias\t"wait16"\t"wait8;wait8"\n'
    + 'alias\t"wait32"\t"wait16;wait16"\n'
    + 'alias\t"wait64"\t"wait32;wait32"\n'
    + 'alias\t"wait128"\t"wait64;wait64"'

  return `${header}\n\n${waits}\n\n${blocks.join('\n\n')}\n`
}
