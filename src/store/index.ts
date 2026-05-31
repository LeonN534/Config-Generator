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

type Store = NamesSlice & WeaponsSlice & SlotsSlice & ScriptsSlice & TeamBindsSlice

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
}))
