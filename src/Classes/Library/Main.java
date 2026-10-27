package Classes.Library;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Library library = new Library();
            int value = -1;
            boolean availability;

            do{

                System.out.println("\n===== LIBRARY MENU =====");
                System.out.println("1. Add a book");
                System.out.println("2. Print all books");
                System.out.println("3. Count available books");
                System.out.println("4. Search book by title");
                System.out.println("5. Borrow a book");
                System.out.println("6. Return a book");
                System.out.println("0. Exit");
                System.out.println("Choose an option:");

                if (!in.hasNextInt()) {
                    System.out.println("Incorrect input...");
                    in.nextLine();
                    continue;
                }

                value = in.nextInt();
                in.nextLine();



                if(value == 0){
                    System.out.println("EXIT...");
                    break;
                }

                if (value < 0 || value > 6) {
                    System.out.println("Incorrect value");
                    continue;
                }


                switch (value){
                    case 1:
                        System.out.println("Enter a new book");
                        System.out.println("Enter the title");
                        String title = in.nextLine();
                        System.out.println("Enter the author");
                        String author = in.nextLine();
                        System.out.println("Enter the availability (true or false)");
                        while (!in.hasNextBoolean()) {
                            System.out.println("Incorrect input...");
                            in.nextLine();
                            System.out.println("Enter true or false:");
                        }
                        availability = in.nextBoolean();
                        in.nextLine();
                        library.addBook(new Book(title, author, availability));
                        break;

                    case 2:
                        library.printBooks();
                        break;

                    case 3:
                        System.out.println(
                                "Available books: " + library.countAvailableBooks()
                        );
                        break;

                    case 4:
                        System.out.println("Enter the title you want to find");
                        library.searchBookByTitle(in.nextLine());
                        break;

                    case 5:
                        System.out.println("Which book do you want borrow?");
                        boolean success = library.borrowBook(in.nextLine());
                        if(success){
                            System.out.println("Book borrowed successfully!");
                        }else {
                            System.out.println("Borrowing failed.");
                        }
                        break;

                    case 6:
                        System.out.println("Which book do you want to return?");
                        boolean result = library.returnBook(in.nextLine());
                        if(result){
                            System.out.println("Book returned successfully!");
                        }else{
                            System.out.println("Returning failed.");
                        }
                        break;

                    default:
                        System.out.println("ERROR...");

                }

            }while (value != 0);


            in.close();
        }

}
