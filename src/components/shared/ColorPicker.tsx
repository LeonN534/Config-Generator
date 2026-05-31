import { useI18n } from '@/i18n'

interface ColorOption {
  hex: string
  key: string
  code: string
}

interface Props {
  colors: ColorOption[]
  onSelect?: (code: string) => void
}

export default function ColorPicker({ colors, onSelect }: Props) {
  const { t } = useI18n()

  return (
    <div className="flex flex-wrap gap-2.5">
      {colors.map((c) => (
        <button
          key={c.hex}
          title={t(c.key)}
          onPointerDown={(e) => {
            e.preventDefault()
            onSelect?.(c.code)
          }}
          className="w-10 h-10 rounded-lg border border-white/10 hover:scale-110 hover:border-white/30 transition-all duration-150 cursor-pointer shadow-sm"
          style={{ backgroundColor: c.hex }}
        />
      ))}
    </div>
  )
}
