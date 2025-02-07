package WareHouseInventoryManagement;
import java.io.Serializable;
import java.util.List;

public class Order implements Serializable, Comparable<Order> {
    private String orderID;
    private List<String> productIDs;
    private Priority priority;

    public enum Priority {
        STANDARD, EXPEDITED
    }

    public Order(String orderID, List<String> productIDs, Priority priority) {
        this.orderID = orderID;
        this.productIDs = productIDs;
        this.priority = priority;
    }

    public String getOrderID() { return orderID; }
    public List<String> getProductIDs() { return productIDs; }
    public Priority getPriority() { return priority; }

    @Override
    public int compareTo(Order other) {
        return this.priority.compareTo(other.priority);
    }
}
