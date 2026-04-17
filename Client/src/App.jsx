import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Navbar from './components/Navbar'
import Home from './pages/Home'
import DoctorRegister from './pages/DoctorRegister'
import DonorRegister from './pages/DonorRegister'
import Login from './pages/Login'
import DoctorDashboard from './pages/DoctorDashboard'
import DonorDashboard from './pages/DonorDashboard'

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/doctor-register" element={<DoctorRegister />} />
        <Route path="/donor-register" element={<DonorRegister />} />
        <Route path="/login" element={<Login />} />
        <Route path="/doctor-dashboard" element={<DoctorDashboard />} />
        <Route path="/donor-dashboard" element={<DonorDashboard />} />
      </Routes>
    </Router>
  )
}

export default App