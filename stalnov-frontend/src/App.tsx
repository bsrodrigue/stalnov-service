import { ThemeProvider } from '@mui/material/styles';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './App.css';
import { HomePage, LoginPage, RegisterPage, ForgotPasswordPage, WelcomePage, ResetPasswordPage } from './pages';
import { theme } from './theme';

const queryClient = new QueryClient();

const router = createBrowserRouter([
  {
    path: "/",
    element: <WelcomePage />
  },
  {
    path: "/auth/register",
    element: <RegisterPage />
  },
  {
    path: "/auth/login",
    element: <LoginPage />
  },
  {
    path: "/auth/forgot-password",
    element: <ForgotPasswordPage />
  },
  {
    path: "/auth/reset-password",
    element: <ResetPasswordPage />
  },
  {
    path: "/home",
    element: <HomePage />
  },
]);


function App() {
  return (
    <QueryClientProvider client={queryClient} >
      <ThemeProvider theme={theme}>
        <RouterProvider router={router} />
        <ToastContainer />
      </ThemeProvider>
    </QueryClientProvider>
  )
}

export default App
