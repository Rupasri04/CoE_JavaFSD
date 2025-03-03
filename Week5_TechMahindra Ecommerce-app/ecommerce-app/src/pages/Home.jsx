import ProductCard from "../ui-components/ProductCard";

const products = [
  { id: 1, name: "Laptop", price: 50000 },
  { id: 2, name: "Phone", price: 10000 },
  { id: 3, name: "Headphones", price: 1000 },
];

const Home = () => {
  return (
    <div className="grid grid-cols-3 gap-4 p-4">
      {products.map((product) => (
        <ProductCard key={product.id} product={product} />
      ))}
    </div>
  );
};

export default Home;
