package zeba;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int ISBN;

    public Book(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int ISBN) {
        books.removeIf(book -> book.getISBN() == ISBN);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
            System.out.println("------------");
        }
    }
}

public class LibraryManagementSystem {
	 public static void main(String[] args) {
	        Library library = new Library();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Library Management System");
	            System.out.println("1. Add Book");
	            System.out.println("2. Remove Book");
	            System.out.println("3. Display All Books");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter title: ");
	                    String title = scanner.nextLine();
	                    System.out.print("Enter author: ");
	                    String author = scanner.nextLine();
	                    System.out.print("Enter ISBN: ");
	                    int isbn = scanner.nextInt();
	                    scanner.nextLine(); // Consume the newline character
	                    Book newBook = new Book(title, author, isbn);
	                    library.addBook(newBook);
	                    break;

	                case 2:
	                    System.out.print("Enter ISBN to remove: ");
	                    int isbnToRemove = scanner.nextInt();
	                    scanner.nextLine(); // Consume the newline character
	                    library.removeBook(isbnToRemove);
	                    break;

	                case 3:
	                    library.displayBooks();
	                    break;

	                case 4:
	                    System.out.println("Exiting Library Management System.");
	                    scanner.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

}
