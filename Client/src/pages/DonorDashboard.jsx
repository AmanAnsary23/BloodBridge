import { useNavigate } from 'react-router-dom'

function DonorDashboard() {
  const navigate = useNavigate()
  const token = localStorage.getItem('token')

  if (!token) {
    navigate('/login')
    return null
  }

  return (
    <div className="min-h-screen bg-red-50 flex items-center justify-center px-4">
      <div className="bg-white p-8 rounded-2xl shadow-lg w-full max-w-md text-center">
        <div className="text-6xl mb-4">🩸</div>
        <h2 className="text-3xl font-bold text-red-600 mb-2">Donor Dashboard</h2>
        <p className="text-gray-500 mb-6">
          Thank you for registering as a donor! You will receive email notifications
          whenever there is an urgent blood requirement in your city.
        </p>

        <div className="bg-red-50 rounded-xl p-6 mb-6">
          <h3 className="text-lg font-semibold text-gray-700 mb-2">How it works?</h3>
          <ul className="text-gray-500 text-sm text-left list-disc list-inside space-y-2">
            <li>A hospital in your city posts an urgent blood request</li>
            <li>You will instantly receive an email notification</li>
            <li>Contact the hospital directly to donate blood</li>
            <li>Save a life! 💗</li>
          </ul>
        </div>

        <button
          onClick={() => {
            localStorage.removeItem('token')
            localStorage.removeItem('role')
            navigate('/')
          }}
          className="bg-red-600 text-white px-8 py-3 rounded-lg font-semibold hover:bg-red-700">
          Logout
        </button>
      </div>
    </div>
  )
}

export default DonorDashboard