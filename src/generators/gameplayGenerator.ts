function sectionHeader(title: string, stars: string): string {
  return `\n\n//\n//\n//\t\t${title}\n//\t\t${stars}\n//\n//\n//\n\n`
}

function subtitleLine(title: string): string {
  const stars = '*'.repeat(title.length)
  return `\n\n//\n//\n//\t\t${title}\n//\t\t${stars}\n//\n//\n//\n\n`
}

interface State {
  optimizedVideo: boolean
  optimizedSound: boolean
  optimizedConnection: boolean
  customTextures: boolean
  autoSwitchBetter: boolean
  hideCorpses: boolean
  hideExplosionMarks: boolean
  showWeaponModel: boolean
  includeChangeMapAliases: boolean
  includeChangeModelAliases: boolean
  includeSmilesAliases: boolean
  includeSoundFix: boolean
  includeSpectateAlias: boolean
  forceEnemyModel: string
  forceTeammateModel: string
}

export function generateGameplay(state: State): string {
  const lines: string[] = []

  const hasAny = state.optimizedVideo || state.optimizedSound || state.optimizedConnection ||
    state.customTextures || state.hideCorpses || !state.showWeaponModel ||
    state.hideExplosionMarks || state.includeChangeMapAliases ||
    state.includeChangeModelAliases || state.includeSmilesAliases ||
    state.includeSoundFix || state.includeSpectateAlias ||
    !!state.forceEnemyModel || !!state.forceTeammateModel

  if (!hasAny) return ''

  lines.push(sectionHeader('G A M E P L A Y', '* * * * * * * * *'))

  if (state.customTextures) {
    lines.push('r_wadtextures\t\t"1"')
  }

  if (!state.showWeaponModel) {
    lines.push('r_drawviewmodels\t"0"')
  }

  if (state.hideCorpses) {
    lines.push('cl_hidecorpses\t\t"1"')
  }

  if (state.hideExplosionMarks) {
    lines.push('r_decals\t\t"0"')
    lines.push('mp_decals\t\t"0"')
  }

  if (state.forceEnemyModel) {
    lines.push(`cl_forceenemymodel\t"${state.forceEnemyModel}"`)
  }

  if (state.forceTeammateModel) {
    lines.push(`cl_forceteammatemodel\t"${state.forceTeammateModel}"`)
  }

  if (state.includeSoundFix) {
    lines.push('')
    lines.push('// Sound Fix')
    lines.push('alias "soundfix" "stopsound"')
  }

  if (state.includeSpectateAlias) {
    lines.push('')
    lines.push('// Spectate')
    lines.push('alias "spec" "spec1"')
    lines.push('alias "spec1" "spectate; say ^3spectate mode ^2ON^1|^3OFF; alias spec spec2"')
    lines.push('alias "spec2" "spectate; say ^3spectate mode ON^1|^2OFF; alias spec spec1"')
  }

  if (state.optimizedVideo) {
    lines.push(subtitleLine('V I D E O'))
    lines.push('r_bmodelhighfrac\t"5.0"')
    lines.push('r_detailtextures\t"0"')
    lines.push('r_mmx\t\t\t"1"')
    lines.push('r_dynamic\t\t"1"')
    lines.push('r_lightmap\t\t"-1"')
    lines.push('r_mirroralpha\t\t"1"')
    lines.push('gl_wateramp\t\t"1"')
    lines.push('gl_ztrick\t\t"0"')
    lines.push('gl_smoothmodels\t\t"1"')
    lines.push('gl_clear\t\t"1"')
    lines.push('gl_picmip\t\t"0"')
    lines.push('gl_playermip\t\t"0"')
    lines.push('gl_cull\t\t\t"1"')
    lines.push('gl_keeptjunctions\t"1"')
    lines.push('gl_lightholes\t\t"1"')
    lines.push('gl_dither\t\t"0"')
    lines.push('gl_flipmatrix\t\t"0"')
    lines.push('gl_fog\t\t\t"0"')
    lines.push('gl_monolights\t\t"0"')
    lines.push('gl_overbright\t\t"1"')
    lines.push('gl_polyoffset\t\t"0.1"')
    lines.push('gl_max_size\t\t"512"')
    lines.push('gl_texturmode\t\t"GL_LINEAR_MIPMAP_LINEAR"')
    lines.push('brightness\t\t"30"')
    lines.push('gamma\t\t\t"30"')
    lines.push('violence_hblood\t\t"1"')
    lines.push('violence_hgibs\t\t"1"')
    lines.push('violence_ablood\t\t"1"')
    lines.push('violence_agibs\t\t"1"')
    lines.push('lightgamma\t\t"1.9"')
    lines.push('lambert\t\t\t"1.5"')
    lines.push('net_graph\t\t"0"')
    lines.push('net_graphpos\t\t"1"')
    lines.push('net_scale\t\t"5"')
    lines.push('viewsize\t\t"110"')
    lines.push('texgamma\t\t"1.1"')
    lines.push('fastsprites\t\t"0"')
    lines.push('vid_wait\t\t"0"')
    lines.push('s_doppler\t\t"1"')
    lines.push('d_spriteskip\t\t"0"')
  }

  if (state.optimizedSound) {
    lines.push(subtitleLine('S O U N D'))
    lines.push('s_geometry\t\t"0"')
    lines.push('s_numpolys\t\t"0"')
    lines.push('s_occlude\t\t"0.00"')
    lines.push('bgmvolume\t\t"0"')
    lines.push('hisound\t\t\t"1"')
    lines.push('suitvolume\t\t"0"')
    lines.push('s_rolloff\t\t"10"')
    lines.push('s_doppler\t\t"0.0"')
    lines.push('s_distance\t\t"10"')
    lines.push('s_automin_distance\t"2.0"')
    lines.push('s_automax_distance\t"30.0"')
    lines.push('s_min_distance\t\t"8.0"')
    lines.push('s_max_distance\t\t"1000.0"')
    lines.push('s_leafnum\t\t"0"')
    lines.push('s_refgain\t\t"0.4"')
    lines.push('s_refdelay\t\t"4"')
    lines.push('s_polykeep\t\t"1000000000"')
    lines.push('s_polysize\t\t"10000000"')
    lines.push('s_bloat\t\t\t"2.0"')
    lines.push('s_verbwet\t\t"0.25"')
    lines.push('s_a3d\t\t\t"0"')
    lines.push('s_eax\t\t\t"0.000000"')
    lines.push('_snd_mixahead\t\t"0.1"')
    lines.push('ambient_level\t\t"0.2"')
    lines.push('s_2dvolume\t\t"0.66"')
    lines.push('volume\t\t\t"0.9"')
    lines.push('voice_loopback\t\t"0"')
    lines.push('voice_maxgain\t\t"5"')
    lines.push('voice_avggain\t\t"0.5"')
    lines.push('voice_scale\t\t"1"')
    lines.push('voice_fadeouttime\t"0.1"')
    lines.push('voice_profile\t\t"0"')
    lines.push('voice_showchannels\t"0"')
    lines.push('voice_showincoming\t"0"')
    lines.push('voice_enable\t\t"1"')
    lines.push('voice_eax\t\t"1"')
    lines.push('voice_dsound\t\t"1"')
    lines.push('voice_overdrive\t\t"2"')
    lines.push('voice_overdrivefadetime\t"0.4"')
    lines.push('voice_recordtofile\t"0"')
    lines.push('voice_inputfromfile\t"0"')
  }

  if (state.optimizedConnection) {
    lines.push(subtitleLine('C O N N E C T I O N'))
    lines.push('rate\t\t\t"99999"')
    lines.push('cl_rate\t\t\t"9999"')
    lines.push('cl_allowdownload\t"1"')
    lines.push('cl_allowupload\t\t"1"')
    lines.push('cl_cmdbackup\t\t"16"')
    lines.push('cl_cmdrate\t\t"80"')
    lines.push('cl_dlmax\t\t"800"')
    lines.push('cl_download_ingame\t"1"')
    lines.push('cl_himodels\t\t"0"')
    lines.push('cl_idealpitchscale\t"0.8"')
    lines.push('cl_lc\t\t\t"1"')
    lines.push('cl_lw\t\t\t"1"')
    lines.push('cl_timeout\t\t"305"')
    lines.push('cl_updaterate\t\t"80"')
    lines.push('cl_vsmoothing\t\t"0.05"')
  }

  if (state.includeChangeMapAliases) {
    lines.push(subtitleLine('M A P S'))
    lines.push('alias\t"cross"\t\t"agmap crossfire; say ^8Vote ^1[^2Crossfire^1]^0"')
    lines.push('alias\t"stkx"\t\t"agmap stalkx; say ^8Vote ^1[^2Stalkx^1]^0"')
    lines.push('alias\t"dust"\t\t"agmap dm_dust2; say ^8Vote ^1[^2Dust 2^1]^0"')
    lines.push('alias\t"bootx"\t\t"agmap bootbox; say ^8Vote ^1[^2Bootbox^1]^0"')
    lines.push('alias\t"stlky"\t\t"agmap stalkyard; say ^8Vote ^1[^2Stalkyard^1]^0"')
    lines.push('alias\t"vgc"\t\t"agmap vengeance; say ^8Vote ^1[^2Vengeance^1]^0"')
    lines.push('alias\t"lv"\t\t"agmap lost_village; say ^8Vote ^1[^2Lost_Village^1]^0"')
    lines.push('alias\t"lv2"\t\t"agmap lost_village2; say ^8Vote ^1[^2Lost_Village 2^1]^0"')
    lines.push('alias\t"btc"\t\t"agmap bootcamp; say ^8Vote ^1[^2Bootcamp^1]^0"')
    lines.push('alias\t"cold"\t\t"agmap cold_faces; say ^8Vote ^1[^2Cold_faces^1]^0"')
    lines.push('alias\t"echo"\t\t"agmap echo; say ^8Vote ^1[^2Echo^1]^0"')
    lines.push('alias\t"end"\t\t"agmap endcamp; say ^8Vote ^1[^2Endcamp^1]^0"')
    lines.push('alias\t"iso"\t\t"agmap isotonic; say ^8Vote ^1[^2Isotonic^1]^0"')
  }

  if (state.includeChangeModelAliases) {
    lines.push(subtitleLine('M O D E L S'))
    lines.push('alias\t"bar"\t\t"model barney"')
    lines.push('alias\t"gin"\t\t"model gina"')
    lines.push('alias\t"gma"\t\t"model gman"')
    lines.push('alias\t"gor"\t\t"model gordon"')
    lines.push('alias\t"hel"\t\t"model helmet"')
    lines.push('alias\t"hgr"\t\t"model hgrunt"')
    lines.push('alias\t"rec"\t\t"model recon"')
    lines.push('alias\t"rob"\t\t"model robo"')
    lines.push('alias\t"sci"\t\t"model scientist"')
    lines.push('alias\t"zom"\t\t"model zombie"')
    lines.push('alias\t"blu"\t\t"model blue"')
    lines.push('alias\t"red"\t\t"model red"')
  }

  if (state.includeSmilesAliases) {
    lines.push(subtitleLine('S M I L E S'))
    lines.push('alias\t"smile"\t\t\t"smile1"')
    lines.push('alias\t"smile1"\t\t"say ^8:^5); alias smile smile2"')
    lines.push('alias\t"smile2"\t\t"say ^8:^3-^1); alias smile smile3"')
    lines.push('alias\t"smile3"\t\t"say ^8:^1-^2-^3-^4-^5-^6-^7-^5-); alias smile smile4"')
    lines.push('alias\t"smile4"\t\t"say ^8:^5-^4>; alias smile smile5"')
    lines.push('alias\t"smile5"\t\t"say ^8:^3--^4]; alias smile smile6"')
    lines.push('alias\t"smile6"\t\t"say ^7(^3-^8:; alias smile smile7"')
    lines.push('alias\t"smile7"\t\t"say ^6|^8:^5-^6); alias smile smile8"')
    lines.push('alias\t"smile8"\t\t"say ^8:^6-^2-^6-^2); alias smile smile9"')
    lines.push('alias\t"smile9"\t\t"say ^8:^5-^1|); alias smile smile10"')
    lines.push('alias\t"smile10"\t\t"say ^3[^8:^4-^6); alias smile smile11"')
    lines.push('alias\t"smile11"\t\t"say ^1}^8:^2-^4]; alias smile smile12"')
    lines.push('alias\t"smile12"\t\t"say ^4(^8:^5<; alias smile smile13"')
    lines.push('alias\t"smile13"\t\t"say ^4<|^8:^6-^7); alias smile smile1"')
  }

  return lines.join('\n')
}
