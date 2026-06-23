import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, Navigate, RouterProvider } from 'react-router-dom';
import { PerformanceHomePage } from './views/PerformanceHomePage';
import './styles.css';

const router = createBrowserRouter([
  { path: '/', element: <Navigate to="/performance" replace /> },
  { path: '/performance', element: <PerformanceHomePage /> },
  { path: '*', element: <Navigate to="/performance" replace /> },
], {
  basename: '/h5',
});

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
);
