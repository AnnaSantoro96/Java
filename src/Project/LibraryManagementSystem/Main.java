package Project.LibraryManagementSystem;

import java.util.Scanner;
public class Main {
    private static String readNonBlankString(Scanner in, String message, String errorMessage){
        System.out.println(message);
        String value = in.nextLine();

        while(value.isBlank()){
            IO.println(errorMessage);
            IO.println(message);
            value = in.nextLine();
        }

        return value.trim();
    }

    private static boolean readBoolean(Scanner in, String message, String errorMessage){
        while (true){
            IO.println(message);

            if(!in.hasNextBoolean()){
                IO.println(errorMessage);
                in.nextLine();
                continue;
            }
            boolean available = in.nextBoolean();
            in.nextLine();

            return available;
        }

    }

    private static int readInt(Scanner in, String message, String errorMessage, int min, int max) {
        while (true) {
            System.out.println(message);

            if (!in.hasNextInt()) {
                System.out.println(errorMessage);
                in.nextLine();
                continue;
            }

            int value = in.nextInt();
            in.nextLine();

            if (value < min || value > max) {
                System.out.println(errorMessage);
                continue;
            }

            return value;
        }
    }

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

             value = readInt(in, "Choose an option", "Invalid value",0, 11);

            if(value == 0){
                IO.println("BYE BYE...");
                break;
            }

            switch (value){
                case 1:
                    IO.println("ADD A NEW BOOK");
                    String isbn = readNonBlankString(in, "Enter the ISBN", "Invalid ISBN");
                    String title = readNonBlankString(in, "Enter the title", "Invalid title");
                    String author = readNonBlankString(in, "Enter the author", "Invalid author");
                    String category = readNonBlankString(in, "Enter the category", "Invalid category");
                    boolean available = readBoolean(in, "Is the book available? (true or false)", "Invalid input");

                    try {
                        library.addBook(new Book(isbn, title, author, category, available));
                        System.out.println("Book added successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 2:
                    IO.println("ADD A MEMBER");
                    String id = readNonBlankString(in, "Enter the ID", "Invalid ID");
                    String name = readNonBlankString(in, "Enter the name", "Invalid name");
                    String lastName = readNonBlankString(in, "Enter the last name", "Invalid last name");

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
                    String isbn1 = readNonBlankString(in, "Enter the ISBN of the book you want to search for", "Invalid ISBN");

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
                    String isbn2 = readNonBlankString(in, "Enter the ISBN of the book you want remove", "Invalid ISBN");

                    try {
                        library.removeBook(isbn2);
                        System.out.println("Book removed successfully!");
                    }catch (IllegalArgumentException e){
                        IO.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                String isbn3 = readNonBlankString(in, "Enter the ISBN of the book you want borrow", "Invalid ISBN");
                String memberId = readNonBlankString(in, "Enter the ID of the member", "Invalid ID");

                try {
                    library.borrowBook(isbn3, memberId);
                    System.out.println("Book borrowed successfully!");
                }catch (IllegalArgumentException e){
                    IO.println("Error: " + e.getMessage());
                }
                break;

                case 7:
                    String isbn4 = readNonBlankString(in, "Enter the ISBN of the book you want return", "Invalid ISBN");

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
                    String memberId2 = readNonBlankString(in, "Enter the member ID", "Invalid ID");

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
