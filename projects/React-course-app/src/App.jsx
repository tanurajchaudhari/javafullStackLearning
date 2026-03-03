import { Route, Routes } from "react-router-dom";
import "./App.css";
import Home from "./pages/Home";
import Auth from "./pages/Auth";
import Checkout from "./pages/ProductsDetails";
import Navbar from "./component/Navbar";
import AuthProvider from "./conetext/AuthContext";
import ProductDetails from "./pages/ProductsDetails";
import CardProvider from "./conetext/CardContext";
import CheckOutPage from "./pages/CheckOutPage";


export default function App() {
  return (
    <AuthProvider>
      <CardProvider>
    <div className="app">
      <Navbar/>

      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="/auth" element={<Auth />}/>
        <Route path="/checkout" element={<CheckOutPage/>}/>
        <Route path="/products/:id" element={<ProductDetails />}/>
      </Routes>
    </div>
    </CardProvider>
    </AuthProvider>
  );
}
