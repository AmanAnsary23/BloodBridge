# 🩸 BloodConnect — Blood Donation Emergency Notification System

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?style=for-the-badge&logo=springboot)
![React](https://img.shields.io/badge/React-18-blue?style=for-the-badge&logo=react)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql)
![JWT](https://img.shields.io/badge/JWT-Auth-red?style=for-the-badge&logo=jsonwebtokens)

> A full-stack web application that connects hospitals with blood donors during emergencies. When a hospital needs urgent blood, it posts a request and **all registered donors in that city instantly receive an email notification.**

---

## 📸 Screenshots

### 🏠 Home Page
![Home Page](home.png)

### 🏥 Doctor Register
![Doctor Register](doctor-register.png)

### 🩸 Donor Register
![Donor Register](donor-register.png)

### 🔐 Login Page
![Login Page](home.png)

### 🩺 Doctor Dashboard (Empty)
![Doctor Dashboard](doctor-dashboard.png)

### 🚨 Doctor Dashboard (Filled — Sending Request)
![Doctor Dashboard Filled](doctor-dashboard-filled.png)

### 💗 Donor Dashboard
![Donor Dashboard](donor-dashboard.png)

### 📧 Email Notification (Received by Donor)
![Email Notification](email.png)

---

## ✨ Features

- ✅ Doctor/Hospital Registration & Login
- ✅ Donor Registration & Login
- ✅ JWT Authentication with role-based access (DOCTOR / DONOR)
- ✅ Doctor can post urgent blood requests
- ✅ Automatic email notification to **all donors in the same city**
- ✅ Password encryption using BCrypt
- ✅ Clean React frontend with Tailwind CSS
- ✅ CORS configured for frontend-backend communication

---

## 🛠️ Tech Stack

### Backend
| Technology | Usage |
|-----------|-------|
| Java 17 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT (jjwt 0.11.5) | Token-based Auth |
| Spring Data JPA | ORM |
| Hibernate | Database Mapping |
| MySQL | Database |
| Spring Mail | Email Notifications (Gmail SMTP) |
| Lombok | Boilerplate Reduction |

### Frontend
| Technology | Usage |
|-----------|-------|
| React 18 | UI Framework |
| Tailwind CSS | Styling |
| Axios | HTTP Client |
| React Router DOM | Client-side Routing |

---

## 📁 Project Structure

### Backend
```
src/main/java/com/Blood/Donation/
│
├── Config/
│   ├── AppConfig.java          # PasswordEncoder + CORS Bean
│   ├── JwtUtil.java            # JWT generate/validate/extract
│   └── SecurityConfig.java     # Spring Security filter chain
│
├── Filter/
│   └── JwtFilter.java          # JWT request filter
│
├── Entity/
│   ├── Doctor.java
│   ├── Donor.java
│   └── BloodRequest.java
│
├── Repository/
│   ├── DoctorRepository.java
│   ├── DonorRepository.java
│   └── BloodRequestRepository.java
│
├── DTO/
│   ├── DoctorRegisterDTO.java
│   ├── DoctorResponseDTO.java
│   ├── DonorRegisterDTO.java
│   ├── DonorResponseDTO.java
│   ├── BloodRequestDTO.java
│   ├── BloodRequestResponseDTO.java
│   └── LoginDTO.java
│
├── Service/
│   ├── DoctorService.java
│   ├── DonorService.java
│   ├── BloodRequestService.java
│   └── AuthService.java
│
└── Controller/
    ├── DoctorController.java
    ├── DonorController.java
    ├── BloodRequestController.java
    └── AuthController.java
```

### Frontend
```
src/
├── components/
│   └── Navbar.jsx
├── pages/
│   ├── Home.jsx
│   ├── DoctorRegister.jsx
│   ├── DonorRegister.jsx
│   ├── Login.jsx
│   ├── DoctorDashboard.jsx
│   └── DonorDashboard.jsx
├── App.jsx
└── main.jsx
```

---

## ⚙️ Setup & Installation

### Prerequisites
- Java 17+
- Node.js 18+
- MySQL 8.0
- Maven

---

### Backend Setup

#### 1. Clone the repository
```bash
git clone https://github.com/yourusername/bloodconnect-backend.git
cd bloodconnect-backend
```

#### 2. Create MySQL Database
```sql
CREATE DATABASE BloodDonation;
```

#### 3. Configure application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/BloodDonation
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=mySecretKey123456789012345678901234567890
jwt.expiration=86400000

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_GMAIL
spring.mail.password=YOUR_GMAIL_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

> **Note:** For Gmail, use an **App Password** (not your regular Gmail password). Enable 2-Step Verification → App Passwords → Generate.

#### 4. Run the backend
```bash
mvn spring-boot:run
```
Backend runs on: `http://localhost:8080`

---

### Frontend Setup

#### 1. Clone the repository
```bash
git clone https://github.com/yourusername/bloodconnect-frontend.git
cd bloodconnect-frontend
```

#### 2. Install dependencies
```bash
npm install
```

#### 3. Run the frontend
```bash
npm run dev
```
Frontend runs on: `http://localhost:5173`

---

## 📡 API Endpoints

### Public APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/doctors/register` | Register a new Doctor |
| POST | `/api/donors/register` | Register a new Donor |
| POST | `/api/auth/doctor/login` | Doctor Login → returns JWT |
| POST | `/api/auth/donor/login` | Donor Login → returns JWT |

### Protected APIs (Requires JWT)

| Method | Endpoint | Role | Description |
|--------|----------|------|-------------|
| POST | `/api/blood-requests` | DOCTOR | Create blood request + notify donors |

---

## 📝 API Request Examples

### Register Doctor
```json
POST /api/doctors/register
{
  "name": "Dr. Sharma",
  "hospitalName": "Apollo Hospital",
  "city": "Noida",
  "email": "sharma@gmail.com",
  "password": "test123",
  "phoneNumber": "9999999999",
  "licenseNumber": "LIC123"
}
```

### Register Donor
```json
POST /api/donors/register
{
  "fullName": "Aman Kumar",
  "email": "aman@gmail.com",
  "password": "test123",
  "phoneNumber": "8888888888",
  "city": "Noida",
  "bloodGroup": "B+"
}
```

### Doctor Login
```json
POST /api/auth/doctor/login
{
  "email": "sharma@gmail.com",
  "password": "test123"
}
// Response: JWT Token string
```

### Create Blood Request
```
POST /api/blood-requests
Authorization: Bearer <JWT_TOKEN>

{
  "patientName": "Rahul Kumar",
  "bloodGroup": "B+",
  "hospitalAddress": "Sector 62, Noida",
  "city": "Noida",
  "message": "Urgent blood needed!"
}
```

---

## 🔐 Authentication Flow

```
1. Register → POST /api/doctors/register or /api/donors/register
2. Login    → POST /api/auth/doctor/login or /api/auth/donor/login
3. Get JWT  → Store in localStorage
4. Use JWT  → Pass in Authorization: Bearer <token> header
5. Access   → Protected routes verify token automatically
```

---

## 📧 Email Notification Flow

```
1. Doctor logs in with JWT token
2. Doctor fills blood request form
3. System extracts doctor info from JWT
4. Blood request saved to database
5. System fetches ALL donors in that city
6. Each donor receives an email with full request details
7. Donors contact the hospital directly
```

---

## 👨‍💻 Developer

**Aman Kumar**
- 🎓 B.Tech CSE | University of Engineering & Management, Jaipur
- 💼 Associate Software Engineer Intern @ Yuja Finserv Technologies
- 🛠️ Backend Developer | Spring Boot | Django | Node.js | React
- 📍 Noida/Delhi NCR
