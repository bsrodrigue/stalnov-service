import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import './App.css';
import { RegisterPage } from './pages';

const queryClient = new QueryClient();

function App() {


  return (
    <QueryClientProvider client={queryClient} >
      <RegisterPage />
    </QueryClientProvider>
  )
}

export default App
