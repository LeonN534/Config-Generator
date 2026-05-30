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

type Store = NamesSlice & WeaponsSlice

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
}))
