import { useRef, useState } from 'react'
import { HelpCircle, Settings2 } from 'lucide-react'
import { useI18n } from '@/i18n'
import { useStore } from '@/store'
import { Button } from '@/components/ui/button'

function rgbToHex(r: number, g: number, b: number): string {
  return '#' + [r, g, b].map((x) => Math.max(0, Math.min(255, Math.round(x))).toString(16).padStart(2, '0')).join('')
}

function hexToRgb(hex: string): { r: number; g: number; b: number } | null {
  const m = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex)
  return m ? { r: parseInt(m[1], 16), g: parseInt(m[2], 16), b: parseInt(m[3], 16) } : null
}

interface Props {
  onGenerate: () => void
}

function Toggle({ value, onChange, label, onLabel, offLabel }: {
  value: boolean
  onChange: (v: boolean) => void
  label: string
  onLabel: string
  offLabel: string
}) {
  return (
    <div className="flex items-center justify-between gap-3 py-2">
      <span className="text-sm text-white/70 font-body">{label}</span>
      <div className="flex items-center bg-white/[0.04] border border-white/[0.08] rounded-lg overflow-hidden flex-shrink-0">
        <button
          onClick={(e) => { e.stopPropagation(); onChange(true) }}
          className={`px-2.5 py-1 text-[11px] font-body font-semibold uppercase tracking-wider transition-colors cursor-pointer ${
            value
              ? 'bg-[#f37b22] text-white'
              : 'text-white/40 hover:text-white/70'
          }`}
        >
          {onLabel}
        </button>
        <button
          onClick={(e) => { e.stopPropagation(); onChange(false) }}
          className={`px-2.5 py-1 text-[11px] font-body font-semibold uppercase tracking-wider transition-colors cursor-pointer ${
            !value
              ? 'bg-[#f37b22] text-white'
              : 'text-white/40 hover:text-white/70'
          }`}
        >
          {offLabel}
        </button>
      </div>
    </div>
  )
}

function NumberInput({ value, onChange, placeholder, disabled, className }: {
  value: string
  onChange: (v: string) => void
  placeholder?: string
  disabled?: boolean
  className?: string
}) {
  return (
    <input
      type="text"
      value={value}
      onChange={(e) => onChange(e.target.value)}
      placeholder={placeholder}
      disabled={disabled}
      className={`w-20 bg-white/[0.04] border border-white/[0.08] rounded-lg px-2.5 py-1.5 text-sm text-white font-body text-center
        placeholder:text-white/[0.15] focus:outline-none focus:border-[#f37b22]/40 focus:bg-[#f37b22]/[0.03]
        focus:shadow-[0_0_12px_rgba(243,123,34,0.08)] transition-all
        disabled:opacity-30 disabled:cursor-not-allowed ${className ?? ''}`}
    />
  )
}

function RadioGroup<T extends string>({ options, value, onChange }: {
  options: { value: T; label: string }[]
  value: T
  onChange: (v: T) => void
}) {
  return (
    <div className="flex items-center bg-white/[0.04] border border-white/[0.08] rounded-lg overflow-hidden">
      {options.map((opt) => (
        <button
          key={opt.value}
          onClick={() => onChange(opt.value)}
          className={`px-2.5 py-1 text-[11px] font-body font-semibold uppercase tracking-wider transition-colors cursor-pointer ${
            value === opt.value
              ? 'bg-[#f37b22] text-white'
              : 'text-white/40 hover:text-white/70'
          }`}
        >
          {opt.label}
        </button>
      ))}
    </div>
  )
}

export default function HlConfigTab({ onGenerate }: Props) {
  const { t } = useI18n()

  const sensitivity = useStore((s) => s.sensitivity)
  const setSensitivity = useStore((s) => s.setSensitivity)
  const zoomSensitivityRatio = useStore((s) => s.zoomSensitivityRatio)
  const setZoomSensitivityRatio = useStore((s) => s.setZoomSensitivityRatio)
  const mouseFilter = useStore((s) => s.mouseFilter)
  const setMouseFilter = useStore((s) => s.setMouseFilter)
  const rawInput = useStore((s) => s.rawInput)
  const setRawInput = useStore((s) => s.setRawInput)

  const showWeaponImage = useStore((s) => s.showWeaponImage)
  const setShowWeaponImage = useStore((s) => s.setShowWeaponImage)
  const enableChatSounds = useStore((s) => s.enableChatSounds)
  const setEnableChatSounds = useStore((s) => s.setEnableChatSounds)
  const showOldScoreboard = useStore((s) => s.showOldScoreboard)
  const setShowOldScoreboard = useStore((s) => s.setShowOldScoreboard)
  const showSpeedometer = useStore((s) => s.showSpeedometer)
  const setShowSpeedometer = useStore((s) => s.setShowSpeedometer)
  const speedometerUnderCrosshair = useStore((s) => s.speedometerUnderCrosshair)
  const setSpeedometerUnderCrosshair = useStore((s) => s.setSpeedometerUnderCrosshair)
  const teamScoresSummary = useStore((s) => s.teamScoresSummary)
  const setTeamScoresSummary = useStore((s) => s.setTeamScoresSummary)
  const clockMode = useStore((s) => s.clockMode)
  const setClockMode = useStore((s) => s.setClockMode)
  const rainbowHud = useStore((s) => s.rainbowHud)
  const setRainbowHud = useStore((s) => s.setRainbowHud)
  const hudColorR = useStore((s) => s.hudColorR)
  const setHudColorR = useStore((s) => s.setHudColorR)
  const hudColorG = useStore((s) => s.hudColorG)
  const setHudColorG = useStore((s) => s.setHudColorG)
  const hudColorB = useStore((s) => s.hudColorB)
  const setHudColorB = useStore((s) => s.setHudColorB)
  const pov = useStore((s) => s.pov)
  const setPov = useStore((s) => s.setPov)
  const mp5Speed = useStore((s) => s.mp5Speed)
  const setMp5Speed = useStore((s) => s.setMp5Speed)
  const mp5Length = useStore((s) => s.mp5Length)
  const setMp5Length = useStore((s) => s.setMp5Length)
  const mp5Transparency = useStore((s) => s.mp5Transparency)
  const setMp5Transparency = useStore((s) => s.setMp5Transparency)
  const mp5Offset = useStore((s) => s.mp5Offset)
  const setMp5Offset = useStore((s) => s.setMp5Offset)
  const mp5ColorR = useStore((s) => s.mp5ColorR)
  const setMp5ColorR = useStore((s) => s.setMp5ColorR)
  const mp5ColorG = useStore((s) => s.mp5ColorG)
  const setMp5ColorG = useStore((s) => s.setMp5ColorG)
  const mp5ColorB = useStore((s) => s.mp5ColorB)
  const setMp5ColorB = useStore((s) => s.setMp5ColorB)
  const showFps = useStore((s) => s.showFps)
  const setShowFps = useStore((s) => s.setShowFps)
  const vsync = useStore((s) => s.vsync)
  const setVsync = useStore((s) => s.setVsync)
  const maxFps = useStore((s) => s.maxFps)
  const setMaxFps = useStore((s) => s.setMaxFps)
  const [showFpsTooltip, setShowFpsTooltip] = useState(false)
  const [fpsTooltipPos, setFpsTooltipPos] = useState({ x: 0, y: 0 })
  const fpsIconRef = useRef<HTMLSpanElement>(null)

  const handleDecimal = (setter: (v: string) => void) => (val: string) => {
    if (/^-?\d*\.?\d{0,4}$/.test(val) || val === '' || val === '-') setter(val)
  }

  const handlePositiveInt = (setter: (v: string) => void) => (val: string) => {
    if (/^\d*$/.test(val)) setter(val)
  }

  const handleColorChannel = (setter: (v: string) => void) => (val: string) => {
    if (/^\d{0,3}$/.test(val)) {
      const n = parseInt(val, 10)
      if (val === '' || (n >= 0 && n <= 255)) setter(val)
    }
  }

  const clockOptions = [
    { value: 'off' as const, label: t('hlconfig.clockOff') },
    { value: 'time_remaining' as const, label: t('hlconfig.clockTimeRemaining') },
    { value: 'elapsed_time' as const, label: t('hlconfig.clockElapsedTime') },
  ]

  return (
    <div className="flex justify-center gap-8 h-full">
      <div className="w-full max-w-xl flex flex-col min-h-0">
        <div className="flex items-center gap-3 mb-4 flex-shrink-0">
          <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
          <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
            {t('hlconfig.title')}
          </h2>
        </div>

        <div className="flex-1 overflow-y-auto min-h-0 pr-1 space-y-5 scrollbar-thin">
          {/* Mouse */}
          <div className="bg-white/[0.03] border border-white/[0.06] rounded-xl p-5 space-y-3">
            <div className="flex items-center gap-3 mb-1">
              <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
              <h3 className="text-xs uppercase tracking-widest text-white/40 font-body">
                {t('hlconfig.mouse')}
              </h3>
            </div>
            <div className="space-y-0 divide-y divide-white/[0.04]">
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.sensitivity')}</span>
                <NumberInput
                  value={sensitivity}
                  onChange={handleDecimal(setSensitivity)}
                  placeholder="2.50"
                />
              </div>
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.zoomSensitivityRatio')}</span>
                <NumberInput
                  value={zoomSensitivityRatio}
                  onChange={handleDecimal(setZoomSensitivityRatio)}
                  placeholder="1.0"
                />
              </div>
              <Toggle value={mouseFilter} onChange={setMouseFilter} label={t('hlconfig.mouseFilter')} onLabel={t('hlconfig.on')} offLabel={t('hlconfig.off')} />
              <Toggle value={rawInput} onChange={setRawInput} label={t('hlconfig.rawInput')} onLabel={t('hlconfig.on')} offLabel={t('hlconfig.off')} />
            </div>
          </div>

          {/* HUD */}
          <div className="bg-white/[0.03] border border-white/[0.06] rounded-xl p-5 space-y-3">
            <div className="flex items-center gap-3 mb-1">
              <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
              <h3 className="text-xs uppercase tracking-widest text-white/40 font-body">
                {t('hlconfig.hud')}
              </h3>
            </div>
            <div className="space-y-0 divide-y divide-white/[0.04]">
              <Toggle value={showWeaponImage} onChange={setShowWeaponImage} label={t('hlconfig.showWeaponImage')} onLabel={t('hlconfig.on')} offLabel={t('hlconfig.off')} />
              <Toggle value={enableChatSounds} onChange={setEnableChatSounds} label={t('hlconfig.enableChatSounds')} onLabel={t('hlconfig.on')} offLabel={t('hlconfig.off')} />
              <Toggle value={showOldScoreboard} onChange={setShowOldScoreboard} label={t('hlconfig.showOldScoreboard')} onLabel={t('hlconfig.on')} offLabel={t('hlconfig.off')} />
              <Toggle value={showSpeedometer} onChange={setShowSpeedometer} label={t('hlconfig.showSpeedometer')} onLabel={t('hlconfig.on')} offLabel={t('hlconfig.off')} />
              <Toggle value={speedometerUnderCrosshair} onChange={setSpeedometerUnderCrosshair} label={t('hlconfig.speedometerUnderCrosshair')} onLabel={t('hlconfig.on')} offLabel={t('hlconfig.off')} />
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.teamScoresSummary')}</span>
                <NumberInput
                  value={teamScoresSummary}
                  onChange={handlePositiveInt(setTeamScoresSummary)}
                  placeholder="0"
                />
              </div>
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.showClock')}</span>
                <RadioGroup options={clockOptions} value={clockMode} onChange={setClockMode} />
              </div>
              <Toggle value={rainbowHud} onChange={setRainbowHud} label={t('hlconfig.rainbowHud')} onLabel={t('hlconfig.on')} offLabel={t('hlconfig.off')} />
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.hudColor')}</span>
                <div className="flex items-center gap-2">
                  <input
                    type="color"
                    value={rainbowHud ? '#000000' : rgbToHex(Number(hudColorR) || 0, Number(hudColorG) || 0, Number(hudColorB) || 0)}
                    onChange={(e) => {
                      const c = hexToRgb(e.target.value)
                      if (c) {
                        setHudColorR(String(c.r))
                        setHudColorG(String(c.g))
                        setHudColorB(String(c.b))
                      }
                    }}
                    disabled={rainbowHud}
                    className="w-8 h-8 rounded-lg border border-white/[0.08] bg-transparent cursor-pointer p-0.5 disabled:opacity-30 disabled:cursor-not-allowed"
                  />
                  <div className="flex items-center gap-1.5">
                    <NumberInput value={hudColorR} onChange={handleColorChannel(setHudColorR)} placeholder="0" disabled={rainbowHud} className="w-14" />
                    <span className="text-white/20 text-xs">{t('hlconfig.colorR')}</span>
                    <NumberInput value={hudColorG} onChange={handleColorChannel(setHudColorG)} placeholder="0" disabled={rainbowHud} className="w-14" />
                    <span className="text-white/20 text-xs">{t('hlconfig.colorG')}</span>
                    <NumberInput value={hudColorB} onChange={handleColorChannel(setHudColorB)} placeholder="0" disabled={rainbowHud} className="w-14" />
                    <span className="text-white/20 text-xs">{t('hlconfig.colorB')}</span>
                  </div>
                </div>
              </div>
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.pov')}</span>
                <NumberInput
                  value={pov}
                  onChange={handlePositiveInt(setPov)}
                  placeholder="90"
                />
              </div>
            </div>
          </div>

          {/* MP5 Bullets */}
          <div className="bg-white/[0.03] border border-white/[0.06] rounded-xl p-5 space-y-3">
            <div className="flex items-center gap-3 mb-1">
              <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
              <h3 className="text-xs uppercase tracking-widest text-white/40 font-body">
                {t('hlconfig.mp5')}
              </h3>
            </div>
            <div className="space-y-0 divide-y divide-white/[0.04]">
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.mp5Speed')}</span>
                <NumberInput value={mp5Speed} onChange={handlePositiveInt(setMp5Speed)} placeholder="10" />
              </div>
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.mp5Length')}</span>
                <NumberInput value={mp5Length} onChange={handlePositiveInt(setMp5Length)} placeholder="10" />
              </div>
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.mp5Transparency')}</span>
                <NumberInput value={mp5Transparency} onChange={handlePositiveInt(setMp5Transparency)} placeholder="10" />
              </div>
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.mp5Offset')}</span>
                <NumberInput value={mp5Offset} onChange={handlePositiveInt(setMp5Offset)} placeholder="10" />
              </div>
              <div className="flex items-center justify-between gap-3 py-2">
                <span className="text-sm text-white/70 font-body">{t('hlconfig.mp5Color')}</span>
                <div className="flex items-center gap-2">
                  <input
                    type="color"
                    value={rgbToHex(Number(mp5ColorR) || 0, Number(mp5ColorG) || 0, Number(mp5ColorB) || 0)}
                    onChange={(e) => {
                      const c = hexToRgb(e.target.value)
                      if (c) {
                        setMp5ColorR(String(c.r))
                        setMp5ColorG(String(c.g))
                        setMp5ColorB(String(c.b))
                      }
                    }}
                    className="w-8 h-8 rounded-lg border border-white/[0.08] bg-transparent cursor-pointer p-0.5"
                  />
                  <div className="flex items-center gap-1.5">
                    <NumberInput value={mp5ColorR} onChange={handleColorChannel(setMp5ColorR)} placeholder="0" className="w-14" />
                    <span className="text-white/20 text-xs">{t('hlconfig.colorR')}</span>
                    <NumberInput value={mp5ColorG} onChange={handleColorChannel(setMp5ColorG)} placeholder="0" className="w-14" />
                    <span className="text-white/20 text-xs">{t('hlconfig.colorG')}</span>
                    <NumberInput value={mp5ColorB} onChange={handleColorChannel(setMp5ColorB)} placeholder="0" className="w-14" />
                    <span className="text-white/20 text-xs">{t('hlconfig.colorB')}</span>
                  </div>
                </div>
              </div>
            </div>
          </div>

          {/* FPS */}
          <div className="bg-white/[0.03] border border-white/[0.06] rounded-xl p-5 space-y-3">
            <div className="flex items-center gap-3 mb-1">
              <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
              <h3 className="text-xs uppercase tracking-widest text-white/40 font-body">
                {t('hlconfig.fps')}
              </h3>
            </div>
            <div className="space-y-0 divide-y divide-white/[0.04]">
              <Toggle value={showFps} onChange={setShowFps} label={t('hlconfig.showFps')} onLabel={t('hlconfig.on')} offLabel={t('hlconfig.off')} />
              <Toggle value={vsync} onChange={setVsync} label={t('hlconfig.vsync')} onLabel={t('hlconfig.on')} offLabel={t('hlconfig.off')} />
              <div className="flex items-center justify-between gap-3 py-2">
                <div className="flex items-center gap-1.5">
                  <span className="text-sm text-white/70 font-body">{t('hlconfig.maxFps')}</span>
                  <span
                    ref={fpsIconRef}
                    className="flex-shrink-0"
                    onMouseEnter={() => {
                      if (fpsIconRef.current) {
                        const r = fpsIconRef.current.getBoundingClientRect()
                        setFpsTooltipPos({ x: r.right + 8, y: r.top + r.height / 2 })
                        setShowFpsTooltip(true)
                      }
                    }}
                    onMouseLeave={() => setShowFpsTooltip(false)}
                  >
                    <HelpCircle className="w-3.5 h-3.5 text-white/30 hover:text-[#f37b22] transition-colors cursor-help" />
                  </span>
                </div>
                <NumberInput value={maxFps} onChange={handlePositiveInt(setMaxFps)} placeholder="120" />
              </div>
            </div>
          </div>
        </div>
      </div>

      <div className="w-72 flex-shrink-0">
        <div className="sticky top-0 bg-white/[0.03] border border-white/[0.06] rounded-xl overflow-hidden">
          <div className="h-1 bg-gradient-to-r from-[#f37b22]/60 to-[#f37b22]/10" />
          <div className="p-5 space-y-5">
            <div>
              <div className="flex items-center gap-3 mb-3">
                <div className="w-1 h-4 bg-[#f37b22]/60 rounded-full" />
                <h2 className="text-xs uppercase tracking-widest text-white/40 font-body">
                  {t('hlconfig.title')}
                </h2>
              </div>
              <div className="h-44 flex items-center justify-center bg-white/[0.02] border border-white/[0.06] rounded-lg">
                <Settings2 className="w-8 h-8 text-white/15" />
              </div>
            </div>

            <div className="pt-2 border-t border-white/[0.06]">
              <Button
                onClick={onGenerate}
                className="w-full bg-[#f37b22] hover:bg-[#d46612] text-white font-body font-semibold
                           shadow-[0_0_16px_rgba(243,123,34,0.25)] hover:shadow-[0_0_24px_rgba(243,123,34,0.4)]
                           transition-all duration-200 cursor-pointer py-3"
              >
                <Settings2 className="w-4 h-4 mr-2" />
                {t('generate.button')}
              </Button>
            </div>
          </div>
        </div>
      </div>

      {showFpsTooltip && (
        <div
          className="fixed bg-[#1a1a1a] border border-white/[0.08] rounded-lg px-3 py-1.5 text-[11px] text-white/70 font-body leading-relaxed shadow-lg z-50 pointer-events-none max-w-72"
          style={{ left: fpsTooltipPos.x, top: fpsTooltipPos.y, transform: 'translateY(-50%)' }}
        >
          {t('hlconfig.maxFpsTooltip')}
        </div>
      )}
    </div>
  )
}
