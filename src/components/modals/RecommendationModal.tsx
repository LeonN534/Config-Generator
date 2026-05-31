import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog'
import { Button } from '@/components/ui/button'
import { useI18n } from '@/i18n'

interface Props {
  open: boolean
  onContinue: () => void
}

export default function RecommendationModal({ open, onContinue }: Props) {
  const { t } = useI18n()

  return (
    <Dialog open={open} onOpenChange={(v) => { if (!v) onContinue() }}>
      <DialogContent className="sm:max-w-lg border-white/10 bg-[#111] text-white">
        <DialogHeader>
          <DialogTitle className="text-xl font-display text-[#f37b22]">
            {t('modal.recommendation.title')}
          </DialogTitle>

          <div className="mt-4 space-y-4 text-sm text-white/80 font-body leading-relaxed">
            <p
              dangerouslySetInnerHTML={{
                __html: t('modal.recommendation.body1'),
              }}
            />

            <ul className="space-y-2">
              <li>
                <a
                  href="https://github.com/tmp64/BugfixedHL-Rebased"
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-[#f37b22] hover:underline"
                >
                  BugfixedHL-Rebased
                </a>
              </li>
              <li>
                <a
                  href="https://openag.pro/"
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-[#f37b22] hover:underline"
                >
                  OpenAG
                </a>
              </li>
            </ul>

            <p>{t('modal.recommendation.body2')}</p>

            <ul>
              <li>
                <a
                  href="https://www.facebook.com/peruhl/videos/275157843764349"
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-[#f37b22] hover:underline"
                >
                  {t('modal.recommendation.installerLink')}
                </a>
              </li>
            </ul>
          </div>
        </DialogHeader>

        <div className="flex justify-end mt-2">
          <Button
            onClick={onContinue}
            className="bg-[#f37b22] hover:bg-[#d46612] text-white font-body font-semibold px-6 cursor-pointer"
          >
            {t('modal.recommendation.continue')}
          </Button>
        </div>
      </DialogContent>
    </Dialog>
  )
}
