import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { RegisterPage } from './pages';
import './App.css';

const queryClient = new QueryClient();

function App() {


  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <QueryClientProvider client={queryClient} >
        <main>
          <RegisterPage />
        </main>
      </QueryClientProvider>
    </LocalizationProvider>
  )
}

export default App
