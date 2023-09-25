import './App.css';
import { Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Nav from './components/Nav';
import ProductDetail from './pages/ProductDetail';


function App() {
  return (
    <div className='App'>
      <Nav />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/productDetail/:productId' element={<ProductDetail />} />
      </Routes>
    </div>
  );
}

export default App;
