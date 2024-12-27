package day4.LibrarySystem.LibraryManagementSystem;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, int stock, String author) { super(title, stock, "Book"); this.author = author; }

    public String getAuthor() { return author; }

    @Override
    public String getItemDetails() {
        return "BookData [ID=" + getId() + ", Title=" + getTitle() + ", Stock=" + getStock() + ", Author=" + author + "]";
    }
}
