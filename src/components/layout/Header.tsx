import { Home, Keyboard, Volume2, VolumeX } from 'lucide-react'
import { Button } from '@/components/ui/button'
import {
  Dialog,
  DialogContent,
  DialogTitle,
  DialogTrigger,
} from '@/components/ui/dialog'
import { useAudio } from '@/hooks/useAudio'
import { useI18n } from '@/i18n'
import { Link, useLocation } from 'react-router-dom'

const GitHubIcon = () => (
  <svg viewBox="0 0 24 24" className="w-5 h-5 fill-current" aria-hidden="true">
    <path d="M12 0C5.374 0 0 5.373 0 12c0 5.302 3.438 9.8 8.207 11.387.599.111.793-.261.793-.577v-2.234c-3.338.726-4.033-1.416-4.033-1.416-.546-1.387-1.333-1.756-1.333-1.756-1.089-.745.083-.729.083-.729 1.205.084 1.839 1.237 1.839 1.237 1.07 1.834 2.807 1.304 3.492.997.107-.775.418-1.305.762-1.604-2.665-.305-5.467-1.334-5.467-5.931 0-1.311.469-2.381 1.236-3.221-.124-.303-.535-1.524.117-3.176 0 0 1.008-.322 3.301 1.23A11.509 11.509 0 0112 5.803c1.02.005 2.047.138 3.006.404 2.291-1.552 3.297-1.23 3.297-1.23.653 1.653.242 2.874.118 3.176.77.84 1.235 1.911 1.235 3.221 0 4.609-2.807 5.624-5.479 5.921.43.372.823 1.102.823 2.222v3.293c0 .319.192.694.801.576C20.566 21.797 24 17.3 24 12c0-6.627-5.373-12-12-12z" />
  </svg>
)

export default function Header() {
  const { playing, toggle: toggleMusic } = useAudio('/assets/TriageAtDawn.mp3')
  const { t, lang, toggleLang } = useI18n()
  const { pathname } = useLocation()
  const isHome = pathname === '/'

  return (
    <header className="fixed top-0 left-0 right-0 z-50 flex items-center justify-between px-4 md:px-8 h-14 bg-black/60 backdrop-blur-sm border-b border-white/5">
      {!isHome && (
        <Link
          to="/"
          className="text-white/50 hover:text-white transition-colors"
        >
          <Home className="w-5 h-5" />
          <span className="sr-only">{t('header.home')}</span>
        </Link>
      )}
      {isHome && <div />}

      <div className="flex items-center gap-1">
        <Dialog>
          <DialogTrigger asChild>
            <Button
              variant="ghost"
              size="sm"
              className="text-white/60 hover:text-[#f37b22] hover:bg-[#f37b22]/[0.08] font-body text-xs font-medium gap-1.5 border border-white/[0.06] hover:border-[#f37b22]/20"
            >
              <Keyboard className="w-3.5 h-3.5" />
              {t('header.keyboard')}
            </Button>
          </DialogTrigger>
          <DialogContent className="bg-[#0d0d0d] border-white/[0.06] max-w-[98vw] w-[98vw] max-h-[95vh] p-4
            [&>button]:absolute [&>button]:right-6 [&>button]:top-6
            [&>button]:bg-black/50 [&>button]:backdrop-blur-sm
            [&>button]:w-9 [&>button]:h-9 [&>button]:rounded-full
            [&>button]:flex [&>button]:items-center [&>button]:justify-center
            [&>button]:text-white [&>button]:opacity-100
            [&>button]:hover:bg-black/70 [&>button]:hover:text-white
            [&>button>svg]:w-5 [&>button>svg]:h-5">
            <DialogTitle className="sr-only">Key names</DialogTitle>
            <img
              src={lang === 'es' ? '/assets/key-names-es.png' : '/assets/key-names.png'}
              alt="Keyboard key names reference"
              className="w-full h-auto rounded-lg max-h-[88vh] object-contain"
            />
          </DialogContent>
        </Dialog>
        <a
          href="https://github.com/LeonN534/Config-Generator"
          target="_blank"
          rel="noopener noreferrer"
          className="text-white/50 hover:text-white transition-colors mr-2"
        >
          <GitHubIcon />
          <span className="sr-only">{t('header.github')}</span>
        </a>
        <Button
          variant="ghost"
          size="icon"
          onClick={toggleMusic}
          className="text-white/50 hover:text-white hover:bg-white/5"
        >
          {playing ? <Volume2 className="w-5 h-5" /> : <VolumeX className="w-5 h-5" />}
          <span className="sr-only">{t('header.music')}</span>
        </Button>
        <Button
          variant="ghost"
          size="icon"
          onClick={toggleLang}
          className="text-white/50 hover:text-white hover:bg-white/5 font-body text-xs font-semibold w-9"
        >
          {lang === 'en' ? 'EN' : 'ES'}
          <span className="sr-only">{t('header.language')}</span>
        </Button>
      </div>
    </header>
  )
}
