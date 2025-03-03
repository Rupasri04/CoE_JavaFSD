import { useContext } from "react";
import { CartContext } from "../context/CartContext";

const ProductCard = ({ product }) => {
  const { addToCart } = useContext(CartContext);

  return (
    <div className="border p-4 rounded-lg shadow-md">
      <h2 className="text-lg font-bold">{product.name}</h2>
      <p>₹{product.price}</p>
      <button
        onClick={() => addToCart(product)}
        className="bg-purple-500 hover:bg-purple-700 text-white p-2 mt-2 rounded"
      >
        Add to Cart
      </button>
    </div>
  );
};

export default ProductCard;
