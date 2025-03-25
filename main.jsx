import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './HomePage.jsx';
import Signin from './Signin.jsx';
import { BrowserRouter, Routes,Route } from 'react-router-dom';
import Welcome from './Welcome.jsx';

createRoot(document.getElementById('root')).render(
    
    
   <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/Signin" element={<Signin />} />
        <Route path="/Welcome" element={<Welcome/>} />
      </Routes>
   
   </BrowserRouter>

  )
