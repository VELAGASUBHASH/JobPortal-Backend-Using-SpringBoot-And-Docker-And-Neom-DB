# 🚀 RisePath - Job Portal (Frontend)

A premium, high-performance job portal frontend built with React, Vite, and Tailwind CSS. It features a modern dark-mode aesthetic with interactive 3D animations, particle effects, and role-based dashboards for Users and Administrators.

### 🔗 Live Links
* **Frontend (Vercel):** [https://risepath-one.vercel.app/](https://risepath-one.vercel.app/)
* **Backend API (Render):** [https://jobportalbackend-celm.onrender.com](https://jobportalbackend-celm.onrender.com)

---

## ✨ Features

* **Role-Based Routing:** Secure protected routes dynamically rendering User or Admin dashboards based on decoded JWTs.
* **Premium UI/UX:** Glassmorphism, 3D hover effects, particle canvas backgrounds, and smooth CSS animations.
* **Admin Dashboard:** Full CRUD functionality to post, edit, and delete jobs. Dedicated modal to view applicants and update their statuses.
* **User Dashboard:** Job search & filtering, 1-click applications with success animations (confetti/rocket), and application tracking.
* **Authentication:** Seamless JWT-based login/registration with custom context state management and toast notifications.

## 🛠️ Tech Stack
* **Core:** React 18, Vite
* **Styling:** Tailwind CSS, Custom Keyframe Animations
* **Routing:** React Router v6
* **Network & State:** Axios, React Context API
* **UI Utilities:** React Hot Toast

## 🚀 Getting Started

### Prerequisites
* Node.js (v16 or higher)
* npm or yarn

### Installation
 Clone the repository:
   ```bash
   git clone [https://github.com/VELAGASUBHASH/JobPortal-Frontend-With-React-Vite-And-Tailwind-CSS.git](https://github.com/VELAGASUBHASH/JobPortal-Frontend-With-React-Vite-And-Tailwind-CSS.git)
   cd JobPortal-Frontend-With-React-Vite-And-Tailwind-CSS
Install dependencies:

Bash
npm install
Configure Environment Variables:

Navigate to src/Services/api.js and ensure the base URL points to your backend:

JavaScript
baseURL: '[https://jobportalbackend-celm.onrender.com](https://jobportalbackend-celm.onrender.com)'
Start the development server:

Bash
npm run dev
📂 Folder Structure
Plaintext
src/
├── Component/       # Shared UI components (Hero, Navbar)
├── Context/         # AuthContext for global JWT and Role state management
├── Pages/           # Application views (Home, Login, AdminDashboard, etc.)
├── Services/        # Axios interceptors and API configuration
├── App.jsx          # Core routing and ProtectedRoute logic
└── main.jsx         # Application entry point

   
