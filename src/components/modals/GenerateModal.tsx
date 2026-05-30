import { useState, type KeyboardEvent } from 'react'
import { Download } from 'lucide-react'
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogDescription,
} from '@/components/ui/dialog'
import { Button } from '@/components/ui/button'
import { useI18n } from '@/i18n'
import { useStore } from '@/store'
import { generateNames } from '@/generators/namesGenerator'
import { generateWeapons } from '@/generators/weaponsGenerator'
import { generateSlots } from '@/generators/slotsGenerator'

const INVALID_CHARS = /[\\/:*?"<>|]/g

interface Props {
  open: boolean
  onOpenChange: (open: boolean) => void
}

export default function GenerateModal({ open, onOpenChange }: Props) {
  const { t } = useI18n()
  const [name, setName] = useState('')

  const handleNameChange = (value: string) => {
    setName(value.replace(INVALID_CHARS, ''))
  }

  const handleDownload = async () => {
    const trimmed = name.trim()
    if (!trimmed) {
      window.alert(t('generate.emptyName'))
      return
    }

    try {
      const state = useStore.getState()
      const namesSection = generateNames(state)
      const weaponsSection = generateWeapons(state.weapons)
      const slotsSection = generateSlots(state)

      const res = await fetch('/assets/base.cfg')
      if (!res.ok) throw new Error(`HTTP ${res.status}`)
      const base = await res.text()

      const sections = [namesSection, weaponsSection, slotsSection].filter(Boolean)
      const content = sections.length > 0 ? `${base}\n${sections.join('\n\n')}\n` : base
      const blob = new Blob([content], { type: 'text/plain' })
      const url = URL.createObjectURL(blob)
      const a = document.createElement('a')
      a.href = url
      a.download = `${trimmed}.cfg`
      a.click()
      URL.revokeObjectURL(url)
      onOpenChange(false)
      setName('')
    } catch {
      window.alert(t('generate.error'))
    }
  }

  const handleKeyDown = (e: KeyboardEvent) => {
    if (e.key === 'Enter') handleDownload()
  }

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="bg-[#0d0d0d] border-white/[0.06] max-w-md">
        <DialogHeader>
          <DialogTitle className="text-white/90 font-display text-lg">
            {t('generate.title')}
          </DialogTitle>
          <DialogDescription className="text-white/30 font-body text-sm">
            {t('generate.description')}
          </DialogDescription>
        </DialogHeader>

        <div className="space-y-4 pt-2">
          <label className="text-xs text-white/40 font-body">{t('generate.filename')}</label>
          <div className="flex items-center bg-white/[0.04] border border-white/[0.08] rounded-lg overflow-hidden focus-within:border-[#f37b22]/40 focus-within:shadow-[0_0_12px_rgba(243,123,34,0.08)] transition-all">
            <input
              type="text"
              value={name}
              onChange={(e) => handleNameChange(e.target.value)}
              onKeyDown={handleKeyDown}
              placeholder={t('generate.filenamePlaceholder')}
              autoFocus
              className="flex-1 bg-transparent border-none px-4 py-3 text-sm text-white/80 font-body
                         placeholder:text-white/[0.15] focus:outline-none"
            />
            <span className="px-4 py-3 text-sm text-white/30 font-body border-l border-white/[0.08] select-none">
              .cfg
            </span>
          </div>

          <div className="flex justify-end pt-2">
            <Button
              onClick={handleDownload}
              className="bg-[#f37b22] hover:bg-[#d46612] text-white font-body font-semibold
                         shadow-[0_0_16px_rgba(243,123,34,0.25)] hover:shadow-[0_0_24px_rgba(243,123,34,0.4)]
                         transition-all duration-200 cursor-pointer"
            >
              <Download className="w-4 h-4 mr-2" />
              {t('generate.download')}
            </Button>
          </div>
        </div>
      </DialogContent>
    </Dialog>
  )
}
