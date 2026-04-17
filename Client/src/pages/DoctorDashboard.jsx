import { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

function DoctorDashboard() {
  const [form, setForm] = useState({
    patientName: '',
    bloodGroup: '',
    hospitalAddress: '',
    city: '',
    message: ''
  })
  const [success, setSuccess] = useState('')
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)
  const navigate = useNavigate()
  const token = localStorage.getItem('token')

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value })
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    setError('')
    setSuccess('')
    setLoading(true)
    try {
      await axios.post('http://localhost:8080/api/blood-requests', form, {
        headers: {
          Authorization: `Bearer ${token}`
        }
      })
      setSuccess('Blood request sent! All donors in the city have been notified via email.')
      setForm({
        patientName: '',
        bloodGroup: '',
        hospitalAddress: '',
        city: '',
        message: ''
      })
    } catch (err) {
      setError('Something went wrong. Please try again!')
    } finally {
      setLoading(false)
    }
  }

  if (!token) {
    navigate('/login')
    return null
  }

  return (
    <div className="min-h-screen bg-red-50 flex items-center justify-center px-4 py-10">
      <div className="bg-white p-8 rounded-2xl shadow-lg w-full max-w-md">
        <h2 className="text-3xl font-bold text-red-600 text-center mb-2">Doctor Dashboard</h2>
        <p className="text-center text-gray-500 mb-6">Create an urgent blood request</p>

        <form onSubmit={handleSubmit} className="flex flex-col gap-4">
          <input type="text" name="patientName" placeholder="Patient Name"
            value={form.patientName}
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          <select name="bloodGroup" value={form.bloodGroup}
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500">
            <option value="">Select Blood Group</option>
            <option value="A+">A+</option>
            <option value="A-">A-</option>
            <option value="B+">B+</option>
            <option value="B-">B-</option>
            <option value="O+">O+</option>
            <option value="O-">O-</option>
            <option value="AB+">AB+</option>
            <option value="AB-">AB-</option>
          </select>

          <input type="text" name="hospitalAddress" placeholder="Hospital Address"
            value={form.hospitalAddress}
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          <input type="text" name="city" placeholder="City"
            value={form.city}
            onChange={handleChange} required
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          <textarea name="message" placeholder="Message (optional)"
            value={form.message}
            onChange={handleChange} rows={3}
            className="border border-gray-300 rounded-lg px-4 py-3 focus:outline-none focus:border-red-500" />

          {error && <p className="text-red-500 text-sm">{error}</p>}
          {success && <p className="text-green-500 text-sm">{success}</p>}

          <button type="submit" disabled={loading}
            className="bg-red-600 text-white py-3 rounded-lg font-semibold hover:bg-red-700 disabled:opacity-50">
            {loading ? 'Sending...' : '🚨 Send Blood Request'}
          </button>
        </form>
      </div>
    </div>
  )
}

export default DoctorDashboard