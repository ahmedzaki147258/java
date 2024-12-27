package day4.LibrarySystem.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Library<T extends LibraryItem> {
    private List<T> items;
    private List<Client> clients;

    public Library() {
        items = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public void addItem(T item) {
        for (T i : items) {
            if (i.getId() == item.getId()) {
                System.out.println("Item already exists in library.");
                return;
            }
        }

        items.add(item);
        System.out.println("Item added successfully to library.");
    }

    public T getItemById(int id) throws ItemNotFoundException {
        for (T item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new ItemNotFoundException("Item#" + id + " not found.");
    }

    public void removeItemById(int id) throws ItemNotFoundException {
        T item = getItemById(id);
        items.remove(item);
        System.out.println("Item removed successfully from library.");
    }

    public List<T> getItems() {
        return items;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void displayItems(String type) {
        if (items.isEmpty()) {
            System.out.println("No items in library.");
        } else {
            if (type.equals("Book")) {
                items.stream().filter(item -> item.getType().equals("Book"))
                        .forEach(item -> System.out.println(item.getItemDetails()));
            } else if (type.equals("Magazine")) {
                items.stream().filter(item -> item.getType().equals("Magazine"))
                        .forEach(item -> System.out.println(item.getItemDetails()));
            } else {
                items.forEach(item -> System.out.println(item.getItemDetails()));
            }
        }
    }

    public void addClient(Client client) {
        for (Client c : clients) {
            if (c.getId() == client.getId()) {
                System.out.println("Client already exists in library.");
                return;
            }
        }

        clients.add(client);
        System.out.println("Client#" + client.getId() + " added successfully to library.");
    }

    public Client getClientById(int id) throws ItemNotFoundException {
        return clients.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Client#" + id + " not found."));
    }

    public void removeClientById(int id) throws ItemNotFoundException {
        Client client = getClientById(id);
        if(client.getBorrowedItems().size() > 0) {
            System.out.println("Client has borrowed items. Cannot remove client.");
            return;
        }
        clients.remove(client);
        System.out.println("Client#" + id + " removed successfully from library.");
    }

    public void displayClients() {
        if (clients.isEmpty())
            System.out.println("No clients in the library.");
        else {
            System.out.println("ClientsData:");
            clients.forEach((c) -> {
                c.getClientDetails();
            });
        }
    }
}
