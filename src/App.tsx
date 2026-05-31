import { Routes, Route } from 'react-router-dom'
import Header from '@/components/layout/Header'
import HomePage from '@/pages/HomePage'
import AppShell from '@/components/layout/AppShell'

function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/app" element={<AppShell />} />
      </Routes>
    </>
  )
}

export default App
