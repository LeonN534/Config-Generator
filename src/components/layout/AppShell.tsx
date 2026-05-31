import { useState } from 'react'
import Sidebar from '@/components/layout/Sidebar'
import NamesTab from '@/components/tabs/NamesTab'
import WeaponsTab from '@/components/tabs/WeaponsTab'
import SlotsTab from '@/components/tabs/SlotsTab'
import ScriptsTab from '@/components/tabs/ScriptsTab'
import TeamBindsTab from '@/components/tabs/TeamBindsTab'
import HlConfigTab from '@/components/tabs/HlConfigTab'
import GameplayTab from '@/components/tabs/GameplayTab'
import GenerateModal from '@/components/modals/GenerateModal'

const tabs = ['hlconfig', 'names', 'weapons', 'slots', 'scripts', 'teambinds', 'agconfig'] as const

export type TabId = (typeof tabs)[number]

export default function AppShell() {
  const [activeTab, setActiveTab] = useState<TabId>('hlconfig')
  const [showGenerate, setShowGenerate] = useState(false)

  return (
    <div className="h-screen flex bg-[#0a0a0a] relative overflow-hidden">
      <div className="absolute inset-0 bg-gradient-to-b from-transparent via-transparent to-[#f37b22]/5" />
      <div className="absolute inset-0 bg-[radial-gradient(ellipse_at_bottom_center,#f37b22/5,transparent_70%)]" />
      <div
        className="absolute inset-0 opacity-10 pointer-events-none"
        style={{
          backgroundImage: `linear-gradient(rgba(243,123,34,0.10) 1px, transparent 1px),
            linear-gradient(90deg, rgba(243,123,34,0.10) 1px, transparent 1px)`,
          backgroundSize: '60px 60px',
        }}
      />

      <Sidebar activeTab={activeTab} onTabChange={setActiveTab} />

      <main className="flex-1 pt-14 ml-52 flex flex-col min-h-0 relative z-10">
        <div className="flex-1 p-6 md:p-8 lg:p-10 min-h-0">
          {activeTab === 'names' && <NamesTab onGenerate={() => setShowGenerate(true)} />}
          {activeTab === 'weapons' && <WeaponsTab onGenerate={() => setShowGenerate(true)} />}
          {activeTab === 'slots' && <SlotsTab onGenerate={() => setShowGenerate(true)} />}
          {activeTab === 'hlconfig' && <HlConfigTab onGenerate={() => setShowGenerate(true)} />}
          {activeTab === 'scripts' && <ScriptsTab onGenerate={() => setShowGenerate(true)} />}
          {activeTab === 'teambinds' && <TeamBindsTab onGenerate={() => setShowGenerate(true)} />}
          {activeTab === 'agconfig' && <GameplayTab onGenerate={() => setShowGenerate(true)} />}
        </div>
      </main>

      <GenerateModal open={showGenerate} onOpenChange={setShowGenerate} />
    </div>
  )
}
