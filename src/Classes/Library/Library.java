package Classes.Library;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public boolean searchBook(Book book){
        return books.contains(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println("Titolo: " + book.getTitle());
            System.out.println("Autore: " + book.getAuthor());
            System.out.println("Disponibile: " + book.isAvailable());
            System.out.println();
        }
    }

    public boolean searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("The title is present.");
                return true;
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    public boolean searchBookByAuthor(String author){
        for(Book book : books){
            if(book.getAuthor().equalsIgnoreCase(author)){
                System.out.println("The author is present");
                return true;
            }
        }

        System.out.println("Author not found.");
        return false;
    }

    public boolean removeBookByTitle(String title){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getTitle().equalsIgnoreCase(title)){
                books.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return true;
                }
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    public boolean returnBook(String title){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                if(!book.isAvailable()){
                    book.setAvailable(true);
                    return true;
                }else{
                    System.out.println("The book is already available");
                    return false;
                }
            }
        }

        System.out.println("Book not found.");
        return false;
    }

    public int countAvailableBooks(){
        int count = 0;
        for(Book book : books){
            if(book.isAvailable()){
                count++;
            }
        }

        return count;
    }

    public int countBooksByAuthor(String author){
        int count = 0;
        for(Book book : books){
            if(book.getAuthor().equalsIgnoreCase(author)){
                count++;
            }
        }

        return count;
    }

    public int countTotalBooks() {
        return books.size();
    }

    public int countBorrowedBooks() {
        return books.size() - countAvailableBooks();
    }


}
