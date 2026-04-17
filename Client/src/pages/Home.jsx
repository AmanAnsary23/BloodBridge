import { Link } from 'react-router-dom'

function Home() {
  return (
    <div>
      {/* Hero Section */}
      <div className="bg-red-50 min-h-screen flex flex-col items-center justify-center text-center px-4">
        <h1 className="text-5xl font-bold text-red-600 mb-4">🩸 BloodConnect</h1>
        <p className="text-xl text-gray-600 mb-8 max-w-2xl">
          Connecting hospitals with blood donors in emergency situations. 
          Every second counts — we make sure help reaches on time.
        </p>
        <div className="flex gap-4">
          <Link to="/donor-register" 
            className="bg-red-600 text-white px-8 py-3 rounded-lg text-lg font-semibold hover:bg-red-700">
            Register as Donor
          </Link>
          <Link to="/doctor-register" 
            className="border-2 border-red-600 text-red-600 px-8 py-3 rounded-lg text-lg font-semibold hover:bg-red-50">
            Register as Doctor
          </Link>
        </div>
      </div>

      {/* Features Section */}
      <div className="py-16 px-8 bg-white">
        <h2 className="text-3xl font-bold text-center text-gray-800 mb-12">How It Works</h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8 max-w-5xl mx-auto">
          <div className="text-center p-6 rounded-xl shadow-md">
            <div className="text-5xl mb-4">🏥</div>
            <h3 className="text-xl font-bold text-gray-800 mb-2">Hospital Registers</h3>
            <p className="text-gray-500">Doctor registers their hospital on our platform</p>
          </div>
          <div className="text-center p-6 rounded-xl shadow-md">
            <div className="text-5xl mb-4">🚨</div>
            <h3 className="text-xl font-bold text-gray-800 mb-2">Emergency Request</h3>
            <p className="text-gray-500">Doctor fills blood request form with patient details</p>
          </div>
          <div className="text-center p-6 rounded-xl shadow-md">
            <div className="text-5xl mb-4">📧</div>
            <h3 className="text-xl font-bold text-gray-800 mb-2">Donors Notified</h3>
            <p className="text-gray-500">All donors in that city receive instant email notification</p>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Home