package day4.LibrarySystem.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String email;
    private static int nextId = 1;
    private List<LibraryItem> borrowedItems = new ArrayList<LibraryItem>();

    public Client() {}
    public Client(String name, String email) {
        this.id = nextId;
        this.name = name;
        this.email = email;
        nextId++;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public List<LibraryItem> getBorrowedItems() { return borrowedItems; }

    public void addBorrowedItem(LibraryItem item) throws ItemNotFoundException {
        if (borrowedItems.contains(item)) {
            System.out.println("Item already borrowed.");
            return;
        }
        item.decrementStock();
        borrowedItems.add(item);
        System.out.println("Item borrowed successfully.");
    }

    public void returnBorrowedItem(LibraryItem item) {
        if (!borrowedItems.contains(item)) {
            System.out.println("Item not borrowed.");
            return;
        }
        borrowedItems.remove(item);
        item.incrementStock();
        System.out.println("Item returned successfully.");
    }

    public void getClientDetails() {
        System.out.println("Client: [ID=" + id + ", Name=" + name + ", Email=" + email + "]");
        for (LibraryItem item : this.borrowedItems) {
            System.out.println("Borrowed item: " + item.getItemDetails());
        }
        System.out.println();
    }
}
