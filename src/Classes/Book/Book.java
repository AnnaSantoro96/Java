package Classes.Book;

public class Book {

    private String title;
    private String author;
    private int pageNumber;
    private boolean read;

    public Book(String title, String author, int pageNumber, boolean read){
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
        this.read = read;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        if (pageNumber > 0) {
            this.pageNumber = pageNumber;
        } else {
            System.out.println(
                    "ERROR: the value must be greater than zero"
            );
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void printInfo(){
        IO.println("Title: " + title + "\nAuthor: " + author + "\nPage number: " + pageNumber + "\nRead: " + read);
    }
}
