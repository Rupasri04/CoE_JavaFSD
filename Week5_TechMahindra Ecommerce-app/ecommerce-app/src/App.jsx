
import './App.css'

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./ui-components/Navbar";
import Home from "./pages/Home";
import CartPage from "./pages/CartPage";

import { CartProvider } from "./context/CartContext";

const App = () => {
  return (
    <CartProvider>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/cart" element={<CartPage />} />
        </Routes>
      </Router>
    </CartProvider>
  );
};

export default App;
