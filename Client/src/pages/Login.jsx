import { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

function Login() {
  const [role, setRole] = useState('DOCTOR')
  const [form, setForm] = useState({ email: '', password: '' })
  const [error, setError] = useState('')
  const navigate = useNavigate()

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value })
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    setError('')
    try {
      const url = role === 'DOCTOR'
        ? 'http://localhost:8080/api/auth/doctor/login'
        : 'http://localhost:8080/api/auth/donor/login'

      const res = await axios.post(url, form)
      localStorage.setItem('token', res.data)
      localStorage.setItem('role', role)

      if (role === 'DOCTOR') {
        navigate('/doctor-dashboard')
      } else {
        navigate('/donor-dashboard')
      }
    } catch (err) {
      setError('Invalid email or password!')
    }
  }

  return (
    <div className="min-h-screen bg-red-50 flex items-center justify-center px-4">
      <div className="bg-white p-8 rounded-2xl shadow-lg w-full max-w-md">
        <h2 className="text-3xl font-bold text-red-600 text-center mb-6">Login</h2>

        {/* Role Toggle */}
        <div className="flex mb-6 bg-gray-100 rounded-lg p-1">
          <button
            onClick={() => setRole('DOCTOR')}
            className={`flex-1 py-2 rounded-lg font-semibold transition ${
              role === 'DOCTOR' ? 'bg-red-600 text-white' : 'text-gray-500'
            }`}>
            Doctor
          </button>
          <button
            onClick={() => setRole('DONOR')}
            className={`flex-1 py-2 rounded-lg font-semibold transition ${
              role === 'DONOR' ? 'bg-red-600 text-white' : 'text-gray-500'
            }`}>
            Donor
          </button>
        </div>

        <form onSubmit={handleSubmit} className="flex flex-col gap-4">
          <input
            type="email"
            name="email"
            placeholder="Email"
            onChange={handleChange}
            required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500"
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            onChange={handleChange}
            required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500"
          />
          {error && <p className="text-red-500 text-sm">{error}</p>}
          <button
            type="submit"
            className="bg-red-600 text-white py-3 rounded-lg font-semibold hover:bg-red-700">
            Login
          </button>
        </form>
      </div>
    </div>
  )
}

export default Login