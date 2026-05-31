function sectionHeader(title: string, stars: string): string {
  return `//\n//\n//\t\t${title}\n//\t\t${stars}\n//\n//\n//\n`
}

function tabs(name: string): string {
  if (name.length <= 12) return '\t\t\t'
  if (name.length <= 20) return '\t\t'
  return '\t'
}

interface State {
  sensitivity: string
  zoomSensitivityRatio: string
  mouseFilter: boolean
  rawInput: boolean
  showWeaponImage: boolean
  enableChatSounds: boolean
  showOldScoreboard: boolean
  showSpeedometer: boolean
  speedometerUnderCrosshair: boolean
  teamScoresSummary: string
  clockMode: 'off' | 'time_remaining' | 'elapsed_time'
  rainbowHud: boolean
  hudColorR: string
  hudColorG: string
  hudColorB: string
  pov: string
  mp5Speed: string
  mp5Length: string
  mp5Transparency: string
  mp5Offset: string
  mp5ColorR: string
  mp5ColorG: string
  mp5ColorB: string
  showFps: boolean
  vsync: boolean
  maxFps: string
}

export function generateBasicConfig(state: State): string {
  const lines: string[] = []

  // MOUSE
  lines.push(sectionHeader('M O U S E', '*********'))
  if (state.sensitivity) {
    lines.push(`sensitivity${tabs('sensitivity')}"${state.sensitivity}"`)
  }
  if (state.zoomSensitivityRatio) {
    lines.push(`zoom_sensitivity_ratio${tabs('zoom_sensitivity_ratio')}"${state.zoomSensitivityRatio}"`)
  }
  if (state.mouseFilter) {
    lines.push(`m_filter${tabs('m_filter')}"1"`)
  }
  lines.push(`m_rawinput${tabs('m_rawinput')}"1"`)

  // HUD
  lines.push('')
  lines.push(sectionHeader('H U D', '*****'))
  lines.push(`hud_weapon${tabs('hud_weapon')}"1"`)
  if (state.enableChatSounds) {
    lines.push(`hud_saytext_sound${tabs('hud_saytext_sound')}"1"`)
  }
  if (state.clockMode === 'off') {
    lines.push(`hud_timer${tabs('hud_timer')}"0"`)
  } else if (state.clockMode === 'time_remaining') {
    lines.push(`hud_timer${tabs('hud_timer')}"1"`)
  } else {
    lines.push(`hud_timer${tabs('hud_timer')}"2"`)
  }
  if (state.rainbowHud) {
    lines.push(`hud_rainbow${tabs('hud_rainbow')}"1"`)
  }
  if (state.showOldScoreboard) {
    lines.push(`cl_old_scoreboard${tabs('cl_old_scoreboard')}"1"`)
  }
  if (state.showSpeedometer) {
    lines.push(`hud_speedometer${tabs('hud_speedometer')}"1"`)
  }
  if (state.speedometerUnderCrosshair) {
    lines.push(`hud_speedometer_below_cross${tabs('hud_speedometer_below_cross')}"1"`)
  }
  if (state.teamScoresSummary && state.teamScoresSummary !== '0') {
    lines.push(`cl_scores${tabs('cl_scores')}"${state.teamScoresSummary}"`)
  }
  if (state.pov) {
    lines.push(`default_fov${tabs('default_fov')}"${state.pov}"`)
  }
  if (!state.rainbowHud) {
    const r = parseInt(state.hudColorR, 10) || 0
    const g = parseInt(state.hudColorG, 10) || 0
    const b = parseInt(state.hudColorB, 10) || 0
    if (r || g || b) {
      lines.push(`hud_color${tabs('hud_color')}"${r} ${g} ${b}"`)
    }
  }

  // MP5
  const mp5NonEmpty = state.mp5Speed || state.mp5Length || state.mp5Transparency || state.mp5Offset
  const mr = parseInt(state.mp5ColorR, 10) || 0
  const mg = parseInt(state.mp5ColorG, 10) || 0
  const mb = parseInt(state.mp5ColorB, 10) || 0
  if (mp5NonEmpty || mr || mg || mb) {
    lines.push('')
    lines.push(sectionHeader('M P 5    B U L L E T S', '**********************'))
    if (state.mp5Speed) {
      lines.push(`tracerspeed${tabs('tracerspeed')}"${state.mp5Speed}"`)
    }
    if (state.mp5Length) {
      lines.push(`tracerlength${tabs('tracerlength')}"${state.mp5Length}"`)
    }
    if (state.mp5Transparency) {
      lines.push(`traceralpha${tabs('traceralpha')}"${state.mp5Transparency}"`)
    }
    if (state.mp5Offset) {
      lines.push(`traceroffset${tabs('traceroffset')}"${state.mp5Offset}"`)
    }
    if (mr || mg || mb) {
      lines.push(`tracerred${tabs('tracerred')}"${mr}"`)
      lines.push(`tracergreen${tabs('tracergreen')}"${mg}"`)
      lines.push(`tracerblue${tabs('tracerblue')}"${mb}"`)
    }
  }

  // FPS
  lines.push('')
  lines.push(sectionHeader('F P S', '*****'))
  lines.push(`fps_override${tabs('fps_override')}"1"`)
  if (state.showFps) {
    lines.push(`cl_showfps${tabs('cl_showfps')}"1"`)
  }
  if (state.vsync) {
    lines.push(`gl_vsync${tabs('gl_vsync')}"1"`)
  }
  if (state.maxFps) {
    lines.push(`fps_max${tabs('fps_max')}"${state.maxFps}"`)
  }

  return lines.join('\n')
}
