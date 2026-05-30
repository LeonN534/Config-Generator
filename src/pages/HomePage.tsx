import { useState } from 'react'
import Header from '@/components/layout/Header'
import { Button } from '@/components/ui/button'
import { useI18n } from '@/i18n'
import RecommendationModal from '@/components/modals/RecommendationModal'

export default function HomePage() {
  const { t } = useI18n()
  const [showModal, setShowModal] = useState(false)
  return (
    <div className="relative min-h-screen flex flex-col bg-[#0a0a0a] overflow-hidden">

      {/* Background layers */}
      <div className="absolute inset-0 bg-gradient-to-b from-transparent via-transparent to-[#f37b22]/10" />
      <div className="absolute inset-0 bg-[radial-gradient(ellipse_at_bottom_center,#f37b22/8,transparent_70%)]" />

      {/* Grid pattern */}
      <div
        className="absolute inset-0 opacity-15"
        style={{
          backgroundImage: `linear-gradient(rgba(243,123,34,0.12) 1px, transparent 1px),
            linear-gradient(90deg, rgba(243,123,34,0.12) 1px, transparent 1px)`,
          backgroundSize: '60px 60px',
        }}
      />

      {/* Bottom decorative lines */}
      <div className="absolute bottom-0 left-0 right-0 flex flex-col items-center gap-1 pb-8">
        <div className="w-32 h-px bg-gradient-to-r from-transparent via-[#f37b22]/40 to-transparent" />
        <div className="w-20 h-px bg-gradient-to-r from-transparent via-[#f37b22]/20 to-transparent" />
      </div>

      <Header />

      <main className="relative flex-1 flex flex-col items-center justify-center px-4">
        <div className="flex flex-col md:flex-row items-center gap-4 md:gap-6">
          <img
            src="/logo.png"
            alt={t('main.hero.alt')}
            className="w-20 sm:w-24 md:w-32"
          />
          <h1 className="hidden md:block text-4xl sm:text-5xl lg:text-7xl font-display text-[#f37b22] tracking-tight leading-none">
            {t('app.title')}
          </h1>
        </div>

        <p className="mt-6 text-muted-foreground text-sm sm:text-base font-body text-center max-w-md">
          {t('app.subtitle')}
        </p>

        <Button
          size="lg"
          className="mt-8 px-10 py-6 text-base font-body font-semibold uppercase tracking-wider
                     bg-[#f37b22] hover:bg-[#d46612] text-white
                     shadow-[0_0_20px_rgba(243,123,34,0.3)] hover:shadow-[0_0_30px_rgba(243,123,34,0.5)]
                     transition-all duration-200 cursor-pointer"
          onClick={() => setShowModal(true)}
        >
          {t('main.start')}
        </Button>
      </main>

      <RecommendationModal
        open={showModal}
        onContinue={() => setShowModal(false)}
      />
    </div>
  )
}
