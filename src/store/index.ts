import { create } from 'zustand'

export interface NickItem {
  id: string
  value: string
}

interface NamesSlice {
  mainNick: string
  nickItems: NickItem[]
  bindKey: string
  setMainNick: (value: string) => void
  addNickItem: () => void
  removeNickItem: (id: string) => void
  updateNickItem: (id: string, value: string) => void
  reorderNickItems: (items: NickItem[]) => void
  setBindKey: (key: string) => void
}

export interface WeaponBinding {
  weaponId: string
  bindKey: string
}

interface WeaponsSlice {
  weapons: WeaponBinding[]
  focusedWeapon: string | null
  setWeaponBind: (weaponId: string, key: string) => void
  setFocusedWeapon: (id: string | null) => void
}

interface SlotsSlice {
  slotMode: 'numpad' | 'custom' | 'none'
  slotBinds: string[]
  focusedSlot: number | null
  setSlotMode: (mode: 'numpad' | 'custom' | 'none') => void
  setSlotBind: (index: number, key: string) => void
  setFocusedSlot: (index: number | null) => void
}

interface ScriptsSlice {
  scriptBinds: string[]
  focusedScript: number | null
  autobunnyhopMode: 'steam' | 'nosteam'
  lowSensitivityValue: string
  setScriptBind: (index: number, key: string) => void
  setFocusedScript: (index: number | null) => void
  setAutobunnyhopMode: (mode: 'steam' | 'nosteam') => void
  setLowSensitivityValue: (value: string) => void
}

interface TeamBindsSlice {
  teamBinds: string[]
  focusedTeamBind: number | null
  setTeamBind: (index: number, key: string) => void
  setFocusedTeamBind: (index: number | null) => void
}

interface BasicConfigSlice {
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
  setSensitivity: (value: string) => void
  setZoomSensitivityRatio: (value: string) => void
  setMouseFilter: (value: boolean) => void
  setRawInput: (value: boolean) => void
  setShowWeaponImage: (value: boolean) => void
  setEnableChatSounds: (value: boolean) => void
  setShowOldScoreboard: (value: boolean) => void
  setShowSpeedometer: (value: boolean) => void
  setSpeedometerUnderCrosshair: (value: boolean) => void
  setTeamScoresSummary: (value: string) => void
  setClockMode: (mode: 'off' | 'time_remaining' | 'elapsed_time') => void
  setRainbowHud: (value: boolean) => void
  setHudColorR: (value: string) => void
  setHudColorG: (value: string) => void
  setHudColorB: (value: string) => void
  setPov: (value: string) => void
  setMp5Speed: (value: string) => void
  setMp5Length: (value: string) => void
  setMp5Transparency: (value: string) => void
  setMp5Offset: (value: string) => void
  setMp5ColorR: (value: string) => void
  setMp5ColorG: (value: string) => void
  setMp5ColorB: (value: string) => void
  setShowFps: (value: boolean) => void
  setVsync: (value: boolean) => void
  setMaxFps: (value: string) => void
}

interface GameplaySlice {
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
  setOptimizedVideo: (value: boolean) => void
  setOptimizedSound: (value: boolean) => void
  setOptimizedConnection: (value: boolean) => void
  setCustomTextures: (value: boolean) => void
  setAutoSwitchBetter: (value: boolean) => void
  setHideCorpses: (value: boolean) => void
  setHideExplosionMarks: (value: boolean) => void
  setShowWeaponModel: (value: boolean) => void
  setIncludeChangeMapAliases: (value: boolean) => void
  setIncludeChangeModelAliases: (value: boolean) => void
  setIncludeSmilesAliases: (value: boolean) => void
  setIncludeSoundFix: (value: boolean) => void
  setIncludeSpectateAlias: (value: boolean) => void
  setForceEnemyModel: (value: string) => void
  setForceTeammateModel: (value: string) => void
}

type Store = NamesSlice & WeaponsSlice & SlotsSlice & ScriptsSlice & TeamBindsSlice & BasicConfigSlice & GameplaySlice

const WEAPON_IDS = [
  '9mmAR', 'crossbow', 'crowbar', 'egon', 'gauss',
  'handgrenade', 'handgun', 'hornetgun', 'magnum', 'rpg',
  'satchel', 'shotgun', 'snarks', 'tripmine',
]

export const useStore = create<Store>((set) => ({
  mainNick: '',
  nickItems: [{ id: 'nick-0', value: '' }],
  bindKey: '',
  setMainNick: (value) => set({ mainNick: value }),
  addNickItem: () =>
    set((state) => ({
      nickItems: [...state.nickItems, { id: `nick-${Date.now()}`, value: '' }],
    })),
  removeNickItem: (id) =>
    set((state) => ({
      nickItems: state.nickItems.filter((i) => i.id !== id),
    })),
  updateNickItem: (id, value) =>
    set((state) => ({
      nickItems: state.nickItems.map((i) => (i.id === id ? { ...i, value } : i)),
    })),
  reorderNickItems: (items) => set({ nickItems: items }),
  setBindKey: (key) => set({ bindKey: key }),

  weapons: WEAPON_IDS.map((id) => ({ weaponId: id, bindKey: '' })),
  focusedWeapon: null,
  setWeaponBind: (weaponId, key) =>
    set((state) => ({
      weapons: state.weapons.map((w) =>
        w.weaponId === weaponId ? { ...w, bindKey: key } : w,
      ),
    })),
  setFocusedWeapon: (id) => set({ focusedWeapon: id }),

  slotMode: 'none',
  slotBinds: Array(10).fill(''),
  focusedSlot: null,
  setSlotMode: (mode) => set({ slotMode: mode }),
  setSlotBind: (index, key) =>
    set((state) => {
      const slotBinds = [...state.slotBinds]
      slotBinds[index] = key
      return { slotBinds }
    }),
  setFocusedSlot: (index) => set({ focusedSlot: index }),

  scriptBinds: Array(14).fill(''),
  focusedScript: null,
  autobunnyhopMode: 'steam',
  setScriptBind: (index, key) =>
    set((state) => {
      const scriptBinds = [...state.scriptBinds]
      scriptBinds[index] = key
      return { scriptBinds }
    }),
  setFocusedScript: (index) => set({ focusedScript: index }),
  setAutobunnyhopMode: (mode) => set({ autobunnyhopMode: mode }),
  lowSensitivityValue: '',
  setLowSensitivityValue: (value) => set({ lowSensitivityValue: value }),

  teamBinds: Array(14).fill(''),
  focusedTeamBind: null,
  setTeamBind: (index, key) =>
    set((state) => {
      const teamBinds = [...state.teamBinds]
      teamBinds[index] = key
      return { teamBinds }
    }),
  setFocusedTeamBind: (index) => set({ focusedTeamBind: index }),

  sensitivity: '',
  zoomSensitivityRatio: '',
  mouseFilter: false,
  rawInput: true,
  showWeaponImage: true,
  enableChatSounds: false,
  showOldScoreboard: false,
  showSpeedometer: false,
  speedometerUnderCrosshair: false,
  teamScoresSummary: '0',
  clockMode: 'elapsed_time',
  rainbowHud: false,
  hudColorR: '0',
  hudColorG: '0',
  hudColorB: '0',
  pov: '',
  mp5Speed: '',
  mp5Length: '',
  mp5Transparency: '',
  mp5Offset: '',
  mp5ColorR: '0',
  mp5ColorG: '0',
  mp5ColorB: '0',
  showFps: false,
  vsync: false,
  maxFps: '',
  setSensitivity: (value) => set({ sensitivity: value }),
  setZoomSensitivityRatio: (value) => set({ zoomSensitivityRatio: value }),
  setMouseFilter: (value) => set({ mouseFilter: value }),
  setRawInput: (value) => set({ rawInput: value }),
  setShowWeaponImage: (value) => set({ showWeaponImage: value }),
  setEnableChatSounds: (value) => set({ enableChatSounds: value }),
  setShowOldScoreboard: (value) => set({ showOldScoreboard: value }),
  setShowSpeedometer: (value) => set({ showSpeedometer: value }),
  setSpeedometerUnderCrosshair: (value) => set({ speedometerUnderCrosshair: value }),
  setTeamScoresSummary: (value) => set({ teamScoresSummary: value }),
  setClockMode: (mode) => set({ clockMode: mode }),
  setRainbowHud: (value) => set({ rainbowHud: value }),
  setHudColorR: (value) => set({ hudColorR: value }),
  setHudColorG: (value) => set({ hudColorG: value }),
  setHudColorB: (value) => set({ hudColorB: value }),
  setPov: (value) => set({ pov: value }),
  setMp5Speed: (value) => set({ mp5Speed: value }),
  setMp5Length: (value) => set({ mp5Length: value }),
  setMp5Transparency: (value) => set({ mp5Transparency: value }),
  setMp5Offset: (value) => set({ mp5Offset: value }),
  setMp5ColorR: (value) => set({ mp5ColorR: value }),
  setMp5ColorG: (value) => set({ mp5ColorG: value }),
  setMp5ColorB: (value) => set({ mp5ColorB: value }),
  setShowFps: (value) => set({ showFps: value }),
  setVsync: (value) => set({ vsync: value }),
  setMaxFps: (value) => set({ maxFps: value }),

  optimizedVideo: false,
  optimizedSound: false,
  optimizedConnection: false,
  customTextures: false,
  autoSwitchBetter: true,
  hideCorpses: false,
  hideExplosionMarks: false,
  showWeaponModel: true,
  includeChangeMapAliases: false,
  includeChangeModelAliases: false,
  includeSmilesAliases: false,
  includeSoundFix: false,
  includeSpectateAlias: false,
  forceEnemyModel: '',
  forceTeammateModel: '',
  setOptimizedVideo: (value) => set({ optimizedVideo: value }),
  setOptimizedSound: (value) => set({ optimizedSound: value }),
  setOptimizedConnection: (value) => set({ optimizedConnection: value }),
  setCustomTextures: (value) => set({ customTextures: value }),
  setAutoSwitchBetter: (value) => set({ autoSwitchBetter: value }),
  setHideCorpses: (value) => set({ hideCorpses: value }),
  setHideExplosionMarks: (value) => set({ hideExplosionMarks: value }),
  setShowWeaponModel: (value) => set({ showWeaponModel: value }),
  setIncludeChangeMapAliases: (value) => set({ includeChangeMapAliases: value }),
  setIncludeChangeModelAliases: (value) => set({ includeChangeModelAliases: value }),
  setIncludeSmilesAliases: (value) => set({ includeSmilesAliases: value }),
  setIncludeSoundFix: (value) => set({ includeSoundFix: value }),
  setIncludeSpectateAlias: (value) => set({ includeSpectateAlias: value }),
  setForceEnemyModel: (value) => set({ forceEnemyModel: value }),
  setForceTeammateModel: (value) => set({ forceTeammateModel: value }),
}))
