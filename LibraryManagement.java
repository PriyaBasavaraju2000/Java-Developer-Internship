import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void issueBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.issueBook();
                System.out.println(user.getName() + " issued " + title);
                return;
            }
        }
        System.out.println("Book not available or already issued!");
    }

    public void returnBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println(user.getName() + " returned " + title);
                return;
            }
        }
        System.out.println("This book was not issued!");
    }

    public void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        boolean found = false;
        for (Book book : books) {
            if (!book.isIssued()) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books right now.");
        }
    }

    public void showAllBooks() {
        System.out.println("\nAll Books in Library:");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Add some default books
        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Python Guide", "Guido van Rossum"));
        library.addBook(new Book("C++ Primer", "Bjarne Stroustrup"));

        System.out.print("Enter your name: ");
        User currentUser = new User(scanner.nextLine());

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show all books");
            System.out.println("2. Show available books");
            System.out.println("3. Add a book");
            System.out.println("4. Issue a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    library.showAllBooks();
                    break;

                case 2:
                    library.showAvailableBooks();
                    break;

                case 3:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                case 4:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = scanner.nextLine();
                    library.issueBook(issueTitle, currentUser);
                    break;

                case 5:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle, currentUser);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye " + currentUser.getName() + "!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, try again!");
            }
        }
    }
}
