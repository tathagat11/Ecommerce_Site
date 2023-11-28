import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import Layout from './Layout'
import 'bootstrap/dist/css/bootstrap.min.css';
import { createRoutesFromElements, createBrowserRouter, Route, RouterProvider } from 'react-router-dom'
import Home from './components/Home/Home';
import Login from './components/Login/Login';

const router =createBrowserRouter(
  createRoutesFromElements(
    <Route path='/' element={<Layout />}>
      <Route path='/home' element={<Home />} />
      <Route path='/' element={<Login />} />
    </Route>
  )
)

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
)
