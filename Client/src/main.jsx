import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import Layout from './Layout'
import 'bootstrap/dist/css/bootstrap.min.css';
import { createRoutesFromElements, createBrowserRouter, Route, RouterProvider } from 'react-router-dom'
import Home from './components/Home/Home';
import Login from './components/Login/Login';
import { UserProvider } from './components/Context/UserContext';
import Payments from './components/Payments/Payments';

const router =createBrowserRouter(
  createRoutesFromElements(
    <Route path='/' element={<Layout />}>
      <Route path='/home' element={<Home />} />
      <Route path='/' element={<Login />} />
      <Route path='/payments/:billId' element={<Payments />} />
    </Route>
  )
)

ReactDOM.createRoot(document.getElementById('root')).render(
  <UserProvider>
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
  </UserProvider>
)
