package WareHouseInventoryManagement;
import java.io.Serializable;

public class Product implements Serializable {
    private String productID;
    private String name;
    private int quantity;
    private Location location;

    public Product(String productID, String name, int quantity, Location location) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }

    public String getProductID() { return productID; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public Location getLocation() { return location; }

    public void reduceQuantity(int amount) { quantity -= amount; }
    public void increaseQuantity(int amount) { quantity += amount; }

    @Override
    public String toString() {
        return name + " (ID: " + productID + ", Qty: " + quantity + ", Location: " + location + ")";
    }
}
