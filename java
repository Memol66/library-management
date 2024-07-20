import java.util.ArrayList;
import java.util.Scanner;
class Book {
    String title;
    String author;
    int year;
    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
class Library {
    private ArrayList<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    void removeBook(String title) {
        for (int i = 00; i < books.size(); i++) {
            if (books.get(i).title.equalsIgnoreCase(title)) {
                books.remove(i);
                System.out.println("Book removed successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void searchBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found:");
                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Year: " + book.year);
                return;
            }
        }
        System.out.println("Book not found!");
    }
    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("Title: " + book.title + ", Author: " + book.author + ", Year: " + book.year);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for a book");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline.3

            switch (choice) {
                case 1: {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    library.addBook(new Book(title, author, year));
                    break;
                }
                case 2: {
                    System.out.print("Enter the title of the book to remove: ");
                    String title = scanner.nextLine();
                    library.removeBook(title);
                    break;
                }
                case 3: {
                    System.out.print("Enter the title of the book to search for: ");
                    String title = scanner.nextLine();
                    library.searchBook(title);
                    break;
                }
                case 4: {
                    library.displayBooks();
                    break;
                }
                case 5: {
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                }
                default: {
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                    break;
                }
            }
        }
    }
}
