package LibraryManagementSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        library.loadLibrary();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Reserve Book");
            System.out.println("6. Save and Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    library.addBook(title, author, ISBN);
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String userID = scanner.nextLine();
                    library.addUser(name, userID);
                    break;

                case 3:
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowISBN = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String borrowUserID = scanner.nextLine();
                    library.borrowBook(borrowISBN, borrowUserID);
                    break;

                case 4:
                    System.out.print("Enter ISBN to return: ");
                    String returnISBN = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String returnUserID = scanner.nextLine();
                    library.returnBook(returnISBN, returnUserID);
                    break;

                case 5:
                    System.out.print("Enter ISBN to reserve: ");
                    String reserveISBN = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String reserveUserID = scanner.nextLine();
                    library.reserveBook(reserveISBN, reserveUserID);
                    break;

                case 6:
                    library.saveLibrary();
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
