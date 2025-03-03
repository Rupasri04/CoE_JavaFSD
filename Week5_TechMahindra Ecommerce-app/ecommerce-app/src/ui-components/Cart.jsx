import { useContext } from "react";
import { CartContext } from "../context/CartContext";

const Cart = () => {
  const { cart, removeFromCart } = useContext(CartContext);

  return (
    <div className="p-4">
      {cart.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        <>
          {cart.map((item) => (
            <div key={item.id} className="flex justify-between border p-2 mb-2">
              <span>{item.name} - ₹{item.price}</span>  {/* ✅ Changed to ₹ */}
              <button
                onClick={() => removeFromCart(item.id)}
                className="bg-red-500 text-white p-1 rounded"
              >
                Remove
              </button>
            </div>
          ))}
          <h2 className="text-lg font-bold mt-4">
            Total: ₹{cart.reduce((total, item) => total + item.price, 0)}  {/* ✅ Changed to ₹ */}
          </h2>
        </>
      )}
    </div>
  );
};

export default Cart;
