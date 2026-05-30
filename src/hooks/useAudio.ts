import { useRef, useCallback, useEffect, useState } from 'react'

export function useAudio(src: string) {
  const audioRef = useRef<HTMLAudioElement | null>(null)
  const timerRef = useRef<ReturnType<typeof setTimeout> | undefined>(undefined)
  const [playing, setPlaying] = useState(false)

  useEffect(() => {
    const audio = new Audio(src)
    audio.volume = 0.5
    audioRef.current = audio

    const onEnded = () => {
      timerRef.current = setTimeout(() => {
        if (audioRef.current) {
          audioRef.current.currentTime = 0
          audioRef.current.play()
        }
      }, 5000)
    }

    audio.addEventListener('ended', onEnded)

    audio.play().then(() => {
      setPlaying(true)
    }).catch(() => {
      // autoplay blocked by browser — user can click toggle
    })

    return () => {
      clearTimeout(timerRef.current)
      audio.removeEventListener('ended', onEnded)
      audio.pause()
      audio.src = ''
    }
  }, [src])

  const toggle = useCallback(() => {
    const audio = audioRef.current
    if (!audio) return

    if (audio.paused) {
      audio.play()
      setPlaying(true)
    } else {
      audio.pause()
      setPlaying(false)
      clearTimeout(timerRef.current)
    }
  }, [])

  const stop = useCallback(() => {
    const audio = audioRef.current
    if (audio) {
      audio.pause()
      audio.currentTime = 0
    }
    setPlaying(false)
    clearTimeout(timerRef.current)
  }, [])

  return { playing, toggle, stop }
}
