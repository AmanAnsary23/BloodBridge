import { Link, useNavigate } from 'react-router-dom'

function Navbar() {
  const navigate = useNavigate()
  const token = localStorage.getItem('token')
  const role = localStorage.getItem('role')

  const handleLogout = () => {
    localStorage.removeItem('token')
    localStorage.removeItem('role')
    navigate('/')
  }

  return (
    <nav className="bg-red-600 text-white px-8 py-4 flex justify-between items-center">
      <Link to="/" className="text-2xl font-bold">🩸 BloodConnect</Link>
      <div className="flex gap-6 items-center">
        {!token ? (
          <>
            <Link to="/login" className="hover:underline">Login</Link>
            <Link to="/doctor-register" className="hover:underline">Doctor Register</Link>
            <Link to="/donor-register" className="hover:underline">Donor Register</Link>
          </>
        ) : (
          <>
            <Link to={role === 'DOCTOR' ? '/doctor-dashboard' : '/donor-dashboard'} 
              className="hover:underline">Dashboard</Link>
            <button onClick={handleLogout} 
              className="bg-white text-red-600 px-4 py-1 rounded font-semibold hover:bg-red-100">
              Logout
            </button>
          </>
        )}
      </div>
    </nav>
  )
}

export default Navbar