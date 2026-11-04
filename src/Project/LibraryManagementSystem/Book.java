package Project.LibraryManagementSystem;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private boolean available;

    public Book(String isbn, String title, String author, String category, boolean available){
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setCategory(category);
        setAvailable(available);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("Invalid ISBN");
        }
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Invalid title");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author == null || author.isBlank()){
            throw new IllegalArgumentException("Invalid author");
        }
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if(category == null || category.isBlank()){
            throw new IllegalArgumentException("Invalid category");
        }
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "\nISBN: " + getIsbn() + "\nTitle: " + getTitle() + "\nAutore: " + getAuthor() + "\nCategory: " + getCategory() + "\nAvailable: " + isAvailable();

    }
}
