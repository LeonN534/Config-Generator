import { useState } from 'react'
import { Download } from 'lucide-react'
import Sidebar from '@/components/layout/Sidebar'
import NamesTab from '@/components/tabs/NamesTab'
import GenerateModal from '@/components/modals/GenerateModal'
import { Button } from '@/components/ui/button'
import { useI18n } from '@/i18n'

const tabs = ['names', 'weapons', 'scripts', 'teambinds', 'hlconfig', 'agconfig'] as const

export type TabId = (typeof tabs)[number]

export default function AppShell() {
  const [activeTab, setActiveTab] = useState<TabId>('names')
  const [showGenerate, setShowGenerate] = useState(false)
  const { t } = useI18n()

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
          {activeTab === 'names' && <NamesTab />}
        </div>
      </main>

      <Button
        onClick={() => setShowGenerate(true)}
        className="fixed bottom-8 right-8 z-50
                   bg-[#f37b22] hover:bg-[#d46612] text-white
                   font-body font-semibold text-sm uppercase tracking-wider
                   px-6 py-6 rounded-xl
                   shadow-[0_0_24px_rgba(243,123,34,0.35)] hover:shadow-[0_0_36px_rgba(243,123,34,0.5)]
                   transition-all duration-200 cursor-pointer"
      >
        <Download className="w-5 h-5 mr-2.5" />
        {t('generate.button')}
      </Button>

      <GenerateModal open={showGenerate} onOpenChange={setShowGenerate} />
    </div>
  )
}
