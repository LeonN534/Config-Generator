<div align="center">
  <br/>
  <img src="public/logo.png" alt="Config Generator Logo" width="120"/>
  <br/>
  <br/>
  <h1 style="font-family: 'Russo One', sans-serif; font-size: 3rem; color: #f37b22; margin: 0; letter-spacing: -0.02em; line-height: 1.1;">
    Config Generator
  </h1>
  <p style="font-family: 'Chakra Petch', sans-serif; font-size: 1.1rem; color: #9ca3af; margin-top: 0.5rem; max-width: 480px;">
    Generate your Half-Life <code>userconfig.cfg</code> with ease.
  </p>
  <br/>
</div>

A web application designed to create Half-Life configuration files quickly and intuitively. It brings together dozens of scripts, binds, and gameplay settings in one place — no more hunting through scattered config snippets.

## Features

- **Names** — Main nickname, alternate nick list with bind key and color preview.
- **Weapons** — Per-weapon key bindings for quick weapon switching.
- **Slots** — Weapon slot binds with numpad, custom, or no-priority modes.
- **Scripts** — Auto bunnyhop, quick use, using, and low sensitivity aliases.
- **Team Communication** — Pre-built bind keys for team chat and callouts.
- **Basic Config** — Mouse sensitivity & raw input, HUD tweaks (weapon image, speedometer, clock, rainbow HUD, RGB color), MP5 bullet visual customization, FPS limiter and VSync.
- **Gameplay** — Optimized video/sound/connection settings, custom textures, map & model aliases, cycling smile aliases, sound fix, spectate alias, and force model commands.

## Tech Stack

[![React](https://img.shields.io/badge/React-19-61DAFB?logo=react&logoColor=white)](https://react.dev)
[![TypeScript](https://img.shields.io/badge/TypeScript-6-3178C6?logo=typescript&logoColor=white)](https://www.typescriptlang.org)
[![Vite](https://img.shields.io/badge/Vite-8-646CFF?logo=vite&logoColor=white)](https://vite.dev)
[![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-4-06B6D4?logo=tailwindcss&logoColor=white)](https://tailwindcss.com)
[![Zustand](https://img.shields.io/badge/Zustand-5-433E38?logo=react&logoColor=white)](https://zustand-demo.pmnd.rs)
[![shadcn/ui](https://img.shields.io/badge/shadcn%2Fui-latest-000000?logo=shadcnui&logoColor=white)](https://ui.shadcn.com)

- **React 19** + **React Router 7** — Component-based UI with client-side routing.
- **TypeScript 6** — Full type safety across the codebase.
- **Vite 8** — Fast development server and optimized production builds.
- **Tailwind CSS 4** — Utility-first styling with `@theme` custom properties.
- **Zustand 5** — Lightweight global state management (7 store slices).
- **shadcn/ui** + **Radix UI** — Accessible, composable UI primitives (dialog, tooltip, switch, slider, tabs, scroll area, etc.).
- **@dnd-kit** — Drag-and-drop reordering for the nick list.
- **lucide-react** — Consistent icon set.

## Project Structure

```
config-generator/
├── public/                  # Static assets (logo, images, audio, base.cfg)
│   ├── assets/
│   │   ├── base.cfg         # Base Half-Life config template
│   │   ├── slots/           # Slot reference images
│   │   ├── team-binds/      # Team bind reference images
│   │   ├── weapons/         # Weapon icon images
│   │   ├── key-names.png    # Keyboard layout reference
│   │   ├── text-colors.png  # Color code reference
│   │   └── TriageAtDawn.mp3 # Background music
│   └── logo.png
├── src/
│   ├── components/
│   │   ├── layout/          # AppShell, Sidebar, Header
│   │   ├── tabs/            # 7 tab components (Names, Weapons, Slots, etc.)
│   │   ├── modals/          # Generate modal, Recommendation modal
│   │   ├── shared/          # ColorPicker, DraggableNickList, SpecialKeyButtons
│   │   └── ui/              # shadcn/ui primitives (button, dialog)
│   ├── generators/          # Config output generators (one per tab)
│   ├── hooks/               # Custom hooks (useAudio)
│   ├── i18n/                # Internationalization (en, es)
│   ├── pages/               # HomePage (landing), AppShell routed as /app
│   └── store/               # Global Zustand store with all slices
├── index.html
├── vite.config.ts
├── tsconfig.json
└── package.json
```

## Getting Started

### Prerequisites

- **Node.js** >= 20
- **npm** (or **pnpm** / **yarn**)

### Development

```bash
# Clone the repository
git clone https://github.com/your-username/config-generator.git
cd config-generator

# Install dependencies
npm install

# Start the development server
npm run dev
```

Open [http://localhost:5173](http://localhost:5173) in your browser. The app will reload on file changes.

### Production Build

```bash
npm run build
npm run preview
```

The build output is written to the `dist/` directory.

## How to Contribute

1. **Fork** the repository.
2. **Create a branch** for your feature or bug fix:
   ```bash
   git checkout -b feat/my-feature
   ```
3. **Commit your changes** with a clear message:
   ```bash
   git commit -m "feat: add new weapon bind preset"
   ```
4. **Push** to your fork and open a **Pull Request**.

Please keep pull requests focused on a single concern. If you're adding a new feature, consider adding or updating the corresponding generator.

## Donations

If you find this project useful, consider supporting its development:

<p align="center">
  <a href="https://ko-fi.com/T5B120EBPE" target="_blank">
    <img height="48" src="https://storage.ko-fi.com/cdn/kofi2.png?v=6" alt="Buy Me a Coffee at ko-fi.com" />
  </a>
  &nbsp;&nbsp;&nbsp;
  <a href="https://liberapay.com/LeonN534/donate" target="_blank">
    <img height="48" src="https://liberapay.com/assets/widgets/donate.svg" alt="Donate using Liberapay" />
  </a>
</p>

## License

This project is licensed under the **GNU General Public License v3.0**. See the [LICENSE](./LICENSE) file for details.

You are free to fork, modify, and distribute this software, provided that all derivative works are distributed under the same license and give credit to the original project.
