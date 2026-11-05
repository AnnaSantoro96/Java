package Project.LibraryManagementSystem;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library library = new Library();
        int value = -1;

        do {
            System.out.println("\n===== CLIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1.Add book");
            System.out.println("2.Add member");
            System.out.println("3.Print all books");
            System.out.println("4.Find book");
            System.out.println("5.Remove book");
            System.out.println("6.Borrow book");
            System.out.println("7.Return book");
            System.out.println("8.Print all loans");
            System.out.println("9.Print loans by member");
            System.out.println("10.Print overdue loans");
            System.out.println("11.Print loans due soon");
            System.out.println("0. Exit");
            System.out.println("Choose an option:");

            if(!in.hasNextInt()){
                System.out.println("Incorrect input...");
                in.nextLine();
                continue;
            }

            value = in.nextInt();
            in.nextLine();

            if(value == 0){
                IO.println("BYE BYE...");
                break;
            }

            if(value < 0 || value > 11){
                IO.println("Incorrect value");
                continue;
            }

            switch (value){
                case 1:
                    IO.println("ADD A NEW BOOK");
                    IO.println("Enter the ISBN");
                    String isbn = in.nextLine();

                    while(isbn.isBlank()){
                        IO.println("Invalid ISBN");
                        IO.println("Enter the ISBN");
                        isbn = in.nextLine();
                    }

                    IO.println("Enter the title");
                    String title = in.nextLine();

                    while(title.isBlank()){
                        IO.println("Invalid title");
                        IO.println("Enter the title");
                        title = in.nextLine();
                    }

                    IO.println("Enter the author");
                    String author = in.nextLine();

                    while (author.isBlank()){
                        IO.println("Invalid author");
                        IO.println("Enter the author");
                        author = in.nextLine();
                    }

                    IO.println("Enter the category");
                    String category = in.nextLine();

                    while (category.isBlank()){
                        IO.println("Invalid category");
                        IO.println("Enter the category");
                        category = in.nextLine();
                    }

                    IO.println("Is the book available? (true or false)");

                    while (!in.hasNextBoolean()){
                        IO.println("Invalid input");
                        in.nextLine();
                    }

                    boolean available = in.nextBoolean();
                    in.nextLine();

                    try {
                        library.addBook(new Book(isbn, title, author, category, available));
                        System.out.println("Book added successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 2:
                    IO.println("ADD A MEMBER");
                    IO.println("Enter the id");
                    String id = in.nextLine();

                    while (id.isBlank()){
                        IO.println("Invalid id");
                        IO.println("Enter the id");
                        id = in.nextLine();
                    }

                    IO.println("Enter the name");
                    String name = in.nextLine();

                    while (name.isBlank()){
                        IO.println("Invalid name");
                        IO.println("Enter the name");
                        name = in.nextLine();
                    }

                    IO.println("Enter the last name");
                    String lastName = in.nextLine();

                    while (lastName.isBlank()){
                        IO.println("Invalid last name");
                        IO.println("Enter the last name");
                        lastName = in.nextLine();
                    }

                    try {
                        library.addMember(new Member(id, name, lastName));
                        System.out.println("Member added successfully!");
                    }catch (IllegalArgumentException e){
                        IO.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 3:
                    IO.println("All Books");
                    library.printAllBooks();
                    break;

                case 4:
                    IO.println("Enter the ISBN of the book you want to search for");
                    String isbn1 = in.nextLine();

                    while (isbn1.isBlank()){
                        IO.println("Invalid ISBN");
                        IO.println("Enter the ISBN");
                        isbn1 = in.nextLine();
                    }

                    try {
                        Book book = library.findBookByIsbn(isbn1);
                        if (book == null) {
                            System.out.println("Book not found");
                        } else {
                            System.out.println(book);
                        }
                    }catch (IllegalArgumentException e){
                        IO.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    IO.println("Enter the ISBN of the book you want remove");
                    String isbn2 = in.nextLine();

                    while (isbn2.isBlank()){
                        IO.println("Invalid ISBN");
                        IO.println("Enter the ISBN");
                        isbn2 = in.nextLine();
                    }

                    try {
                        library.removeBook(isbn2);
                        System.out.println("Book removed successfully!");
                    }catch (IllegalArgumentException e){
                        IO.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                IO.println("Enter the ISBN of the book you want borrow");
                String isbn3 = in.nextLine();

                    while (isbn3.isBlank()){
                        IO.println("Invalid ISBN");
                        IO.println("Enter the ISBN");
                        isbn3 = in.nextLine();
                    }

                IO.println("Enter the ID of the member");
                String memberId = in.nextLine();

                while(memberId.isBlank()){
                    IO.println("Invalid member id");
                    IO.println("Enter the ID of the member");
                    memberId = in.nextLine();
                }

                try {
                    library.borrowBook(isbn3, memberId);
                    System.out.println("Book borrowed successfully!");
                }catch (IllegalArgumentException e){
                    IO.println("Error: " + e.getMessage());
                }
                break;

                case 7:
                    IO.println("Enter the ISBN of the book you want return");
                    String isbn4 = in.nextLine();

                    while (isbn4.isBlank()){
                        IO.println("Invalid ISBN");
                        IO.println("Enter the ISBN");
                        isbn4 = in.nextLine();
                    }

                    try {
                        library.returnBook(isbn4);
                        System.out.println("Book returned successfully!");
                    }catch (IllegalArgumentException e){
                        IO.println("Error: " + e.getMessage());
                    }
                    break;

                case 8:
                IO.println("All Loans");
                library.printAllLoans();
                break;

                case 9:
                    IO.println("Enter the member ID");
                    String memberId2 = in.nextLine();

                    while (memberId2.isBlank()){
                        IO.println("Invalid member id");
                        IO.println("Enter member ID");
                        memberId2 = in.nextLine();
                    }

                    try {
                        library.printLoansByMember(memberId2);
                    }catch (IllegalArgumentException e){
                        IO.println("Error: " + e.getMessage());
                    }
                    break;

                case 10:
                    IO.println("Overdue Loans");
                    library.printOverdueLoans();
                    break;

                case 11:
                    IO.println("Loans Due Soon");
                    library.printLoansDueSoon();
                    break;

                default:
                    IO.println("ERROR...");

            }

        }while(value != 0);
    }
}
