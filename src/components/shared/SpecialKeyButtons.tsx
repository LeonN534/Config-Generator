interface Props {
  onSelect: (key: string) => void
  disabled?: boolean
  className?: string
}

const rows = [
  ['MOUSE1', 'MOUSE2', 'MOUSE3', 'MOUSE4', 'MOUSE5'],
  ['MWHEELDOWN', 'MWHEELUP', 'CTRL', 'SHIFT', 'TAB'],
  ['ALT', 'SPACE', 'CAPSLOCK'],
]

export default function SpecialKeyButtons({ onSelect, disabled, className = '' }: Props) {
  return (
    <div className={`space-y-1.5 ${className}`}>
      {rows.map((row, ri) => (
        <div key={ri} className="flex flex-wrap gap-1.5">
          {row.map((key) => (
            <button
              key={key}
              onMouseDown={(e) => {
                e.preventDefault()
                if (!disabled) onSelect(key)
              }}
              aria-disabled={disabled}
              className="px-2.5 py-1 text-[11px] font-body font-medium uppercase tracking-wide
                         bg-white/[0.04] border border-white/[0.08] rounded-md
                         text-white/50 hover:text-[#f37b22] hover:border-[#f37b22]/30 hover:bg-[#f37b22]/[0.04]
                         transition-all duration-150 cursor-pointer
                         aria-disabled:opacity-30 aria-disabled:pointer-events-auto aria-disabled:cursor-default
                         aria-disabled:hover:text-white/50 aria-disabled:hover:border-white/[0.08] aria-disabled:hover:bg-transparent"
            >
              {key}
            </button>
          ))}
        </div>
      ))}
    </div>
  )
}
