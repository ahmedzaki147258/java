package day4.LibrarySystem.LibraryManagementSystem;

public abstract class LibraryItem {
    private int id;
    private String title;
    private int stock;
    private String type;
    private static int nextId = 1;

    public LibraryItem(String title, int stock, String type) {
        this.id = nextId;
        this.title = title;
        this.stock = stock;
        this.type = type;
        nextId++;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public int getStock() { return stock; }

    public String getType() { return type; }

    public void incrementStock() { this.stock++; }

    public void decrementStock() throws ItemNotFoundException {
        if(this.stock == 0) throw new ItemNotFoundException("Item out of stock.");
        else this.stock--; 
    }

    public abstract String getItemDetails();
}
