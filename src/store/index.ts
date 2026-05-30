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

export const useStore = create<NamesSlice>((set) => ({
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
}))
