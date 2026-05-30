import { create } from 'zustand'
import { en } from './en'
import { es } from './es'

type Lang = 'en' | 'es'
type TranslationMap = Record<string, string>

const translations: Record<Lang, TranslationMap> = { en, es }

interface LangStore {
  lang: Lang
  toggleLang: () => void
}

export const useLangStore = create<LangStore>((set) => ({
  lang: 'en',
  toggleLang: () => set((s) => ({ lang: s.lang === 'en' ? 'es' : 'en' })),
}))

export function useI18n() {
  const lang = useLangStore((s) => s.lang)
  const toggleLang = useLangStore((s) => s.toggleLang)

  function t(key: string): string {
    return translations[lang][key] ?? translations['en'][key] ?? key
  }

  return { t, lang, toggleLang }
}
