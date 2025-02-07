package WareHouseInventoryManagement;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class InventoryManager {
    private ConcurrentHashMap<String, Product> products;
    private PriorityBlockingQueue<Order> orderQueue;
    
    public InventoryManager() {
        products = new ConcurrentHashMap<>();
        orderQueue = new PriorityBlockingQueue<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductID(), product);
        System.out.println("Product added: " + product);
    }

    public void placeOrder(Order order) {
        orderQueue.offer(order);
        System.out.println("Order placed: " + order.getOrderID() + " with priority " + order.getPriority());
    }

    public void processOrders() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            executor.submit(() -> fulfillOrder(order));
        }
        executor.shutdown();
    }

    private void fulfillOrder(Order order) {
        System.out.println("Processing order: " + order.getOrderID());
        for (String productID : order.getProductIDs()) {
            Product product = products.get(productID);
            if (product != null && product.getQuantity() > 0) {
                product.reduceQuantity(1);
                System.out.println("Picked: " + product.getName() + " for Order: " + order.getOrderID());
            } else {
                System.out.println("Out of Stock: " + productID);
            }
        }
    }

    public void saveInventory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("inventory_data.dat"))) {
            oos.writeObject(products);
            System.out.println("Inventory saved.");
        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    public void loadInventory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("inventory_data.dat"))) {
            products = (ConcurrentHashMap<String, Product>) ois.readObject();
            System.out.println("Inventory loaded.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous inventory found.");
        }
    }
}
