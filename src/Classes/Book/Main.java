package Classes.Book;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the information of the first book");

        System.out.println("Title");
        String title1 = in.nextLine();

        System.out.println("Author");
        String author1 = in.nextLine();

        System.out.println("Page number");
        int pageNumber1 = in.nextInt();

        System.out.println("Did you read the book?");
        boolean read1 = in.nextBoolean();
        in.nextLine();

        System.out.println();
        System.out.println("Enter the information of the second book");

        System.out.println("Title");
        String title2 = in.nextLine();

        System.out.println("Author");
        String author2 = in.nextLine();

        System.out.println("Page number");
        int pageNumber2 = in.nextInt();

        System.out.println("Did you read the book?");
        boolean read2 = in.nextBoolean();

        Book book1 = new Book(title1, author1, pageNumber1, read1);
        IO.println("FIRST BOOK INFORMATION");
        book1.printInfo();

        Book book2 = new Book(title2, author2, pageNumber2, read2);
        IO.println();
        IO.println("SECOND BOOK INFORMATION");
        book2.printInfo();

        book1.setRead(false);
        IO.println("New read status for the first book");
        IO.println(book1.isRead());

        IO.println();
        book2.setRead(true);
        IO.println("New read status for the second book");
        IO.println(book2.isRead());

    }
}
