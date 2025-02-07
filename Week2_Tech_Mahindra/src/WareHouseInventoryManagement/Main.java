package WareHouseInventoryManagement;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();
        inventory.loadInventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWarehouse Management Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Place Order");
            System.out.println("3. Process Orders");
            System.out.println("4. Save and Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    String productID = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter aisle, shelf, bin: ");
                    int aisle = scanner.nextInt(), shelf = scanner.nextInt(), bin = scanner.nextInt();
                    inventory.addProduct(new Product(productID, name, quantity, new Location(aisle, shelf, bin)));
                    break;

                case 2:
                    System.out.print("Enter order ID: ");
                    String orderID = scanner.nextLine();
                    System.out.print("Enter number of products: ");
                    int numProducts = scanner.nextInt();
                    scanner.nextLine();
                    List<String> productIDs = new ArrayList<>();
                    for (int i = 0; i < numProducts; i++) {
                        System.out.print("Enter product ID: ");
                        productIDs.add(scanner.nextLine());
                    }
                    System.out.print("Enter priority (1-Standard, 2-Expedited): ");
                    int priorityInput = scanner.nextInt();
                    Order.Priority priority = (priorityInput == 2) ? Order.Priority.EXPEDITED : Order.Priority.STANDARD;
                    inventory.placeOrder(new Order(orderID, productIDs, priority));
                    break;

                case 3:
                    inventory.processOrders();
                    break;

                case 4:
                    inventory.saveInventory();
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
