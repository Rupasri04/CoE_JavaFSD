package LibraryManagementSystem;
import java.io.*;
import java.util.*;

public class LibraryManager {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private static final int MAX_BOOKS_ALLOWED = 3;

    public void addBook(String title, String author, String ISBN) {
        books.add(new Book(title, author, ISBN));
        System.out.println("Book added: " + title);
    }

    public void addUser(String name, String userID) {
        users.add(new User(name, userID));
        System.out.println("User added: " + userID);
    }

    private User findUser(String userID) {
        return users.stream().filter(u -> u.getUserID().equals(userID)).findFirst().orElse(null);
    }

    private Book findBook(String ISBN) {
        return books.stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElse(null);
    }

    public void borrowBook(String ISBN, String userID) {
        User user = findUser(userID);
        Book book = findBook(ISBN);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
            return;
        }
        if (user.getBorrowedBooks().size() >= MAX_BOOKS_ALLOWED) {
            System.out.println("User has reached the maximum limit of borrowed books.");
            return;
        }

        book.borrow();
        user.borrowBook(book);
        System.out.println(userID + " borrowed " + book.getTitle());
    }

    public void returnBook(String ISBN, String userID) {
        User user = findUser(userID);
        Book book = findBook(ISBN);

        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return;
        }
        if (!user.getBorrowedBooks().contains(book)) {
            System.out.println("User did not borrow this book.");
            return;
        }

        book.returnBook();
        user.returnBook(book);
        System.out.println(userID + " returned " + book.getTitle());
    }

    public void reserveBook(String ISBN, String userID) {
        User user = findUser(userID);
        Book book = findBook(ISBN);

        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println(userID + " has reserved " + book.getTitle());
        } else {
            System.out.println("Book is available. " + userID + " can borrow it directly.");
        }
    }

    public void saveLibrary() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library_data.dat"))) {
            oos.writeObject(books);
            oos.writeObject(users);
            System.out.println("Library saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving library.");
        }
    }

    public void loadLibrary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library_data.dat"))) {
            books = (List<Book>) ois.readObject();
            users = (List<User>) ois.readObject();
            System.out.println("Library data loaded.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous library data found.");
        }
    }
}
