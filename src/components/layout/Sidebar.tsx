import { User, Crosshair, ScrollText, Users, Settings2, Cpu } from 'lucide-react'
import { useI18n } from '@/i18n'
import type { TabId } from './AppShell'

interface Props {
  activeTab: TabId
  onTabChange: (tab: TabId) => void
}

const tabs: { id: TabId; labelKey: string; icon: React.ReactNode }[] = [
  { id: 'names', labelKey: 'tab.names', icon: <User className="w-4 h-4" /> },
  { id: 'weapons', labelKey: 'tab.weapons', icon: <Crosshair className="w-4 h-4" /> },
  { id: 'scripts', labelKey: 'tab.scripts', icon: <ScrollText className="w-4 h-4" /> },
  { id: 'teambinds', labelKey: 'tab.teambinds', icon: <Users className="w-4 h-4" /> },
  { id: 'hlconfig', labelKey: 'tab.hlconfig', icon: <Settings2 className="w-4 h-4" /> },
  { id: 'agconfig', labelKey: 'tab.agconfig', icon: <Cpu className="w-4 h-4" /> },
]

export default function Sidebar({ activeTab, onTabChange }: Props) {
  const { t } = useI18n()

  return (
    <aside className="fixed left-0 top-14 bottom-0 w-52 bg-[#0c0c0c] border-r border-white/[0.04] z-40 flex flex-col pt-4">
      <div className="px-5 mb-4">
        <div className="w-8 h-px bg-[#f37b22]/30" />
      </div>
      <nav className="flex flex-col gap-1 px-3">
        {tabs.map((tab) => (
          <button
            key={tab.id}
            onClick={() => onTabChange(tab.id)}
            className={`flex items-center gap-3 px-3 py-2.5 rounded-lg text-sm font-body transition-all duration-150 cursor-pointer
              ${activeTab === tab.id
                ? 'bg-[#f37b22]/10 text-[#f37b22] shadow-[inset_0_0_0_1px_rgba(243,123,34,0.25)]'
                : 'text-white/40 hover:text-white/70 hover:bg-white/[0.04]'
              }`}
          >
            <span className={activeTab === tab.id ? 'text-[#f37b22]' : 'text-white/30 group-hover:text-white/50'}>
              {tab.icon}
            </span>
            <span>{t(tab.labelKey)}</span>
          </button>
        ))}
      </nav>
      <div className="mt-auto px-5 py-4">
        <div className="w-full h-px bg-white/[0.04]" />
      </div>
    </aside>
  )
}
