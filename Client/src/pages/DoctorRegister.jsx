import { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

function DoctorRegister() {
  const [form, setForm] = useState({
    name: '',
    hospitalName: '',
    city: '',
    email: '',
    password: '',
    phoneNumber: '',
    licenseNumber: ''
  })
  const [error, setError] = useState('')
  const [success, setSuccess] = useState('')
  const navigate = useNavigate()

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value })
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    setError('')
    try {
      await axios.post('http://localhost:8080/api/doctors/register', form)
      setSuccess('Registration successful! Redirecting to login...')
      setTimeout(() => navigate('/login'), 2000)
    } catch (err) {
      setError('Email already registered or something went wrong!')
    }
  }

  return (
    <div className="min-h-screen bg-red-50 flex items-center justify-center px-4 py-10">
      <div className="bg-white p-8 rounded-2xl shadow-lg w-full max-w-md">
        <h2 className="text-3xl font-bold text-red-600 text-center mb-6">Doctor Register</h2>

        <form onSubmit={handleSubmit} className="flex flex-col gap-4">
          <input type="text" name="name" placeholder="Full Name"
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          <input type="text" name="hospitalName" placeholder="Hospital Name"
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          <input type="text" name="city" placeholder="City"
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          <input type="email" name="email" placeholder="Email"
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          <input type="password" name="password" placeholder="Password"
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          <input type="text" name="phoneNumber" placeholder="Phone Number"
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          <input type="text" name="licenseNumber" placeholder="License Number"
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          {error && <p className="text-red-500 text-sm">{error}</p>}
          {success && <p className="text-green-500 text-sm">{success}</p>}

          <button type="submit"
            className="bg-red-600 text-white py-3 rounded-lg font-semibold hover:bg-red-700">
            Register
          </button>
        </form>
      </div>
    </div>
  )
}

export default DoctorRegister