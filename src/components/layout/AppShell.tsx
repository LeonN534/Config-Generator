import { useState } from 'react'
import Sidebar from '@/components/layout/Sidebar'
import NamesTab from '@/components/tabs/NamesTab'

const tabs = ['names', 'weapons', 'scripts', 'teambinds', 'hlconfig', 'agconfig'] as const

export type TabId = (typeof tabs)[number]

export default function AppShell() {
  const [activeTab, setActiveTab] = useState<TabId>('names')

  return (
    <div className="h-screen flex bg-[#0a0a0a]">
      <Sidebar activeTab={activeTab} onTabChange={setActiveTab} />

      <main className="flex-1 pt-14 ml-52 flex flex-col min-h-0">
        <div className="flex-1 p-6 md:p-8 lg:p-10 min-h-0">
          {activeTab === 'names' && <NamesTab />}
        </div>
      </main>
    </div>
  )
}
