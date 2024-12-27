package day4.LibrarySystem;
import java.util.Scanner;
import day4.LibrarySystem.LibraryManagementSystem.*;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Client client = new Client();
        Library<LibraryItem> library = new Library<>();
        
        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println(" 1. Add Library Item");
            System.out.println(" 2. Retrieve Library Item");
            System.out.println(" 3. Display All Library Items");
            System.out.println(" 4. Display All Book");
            System.out.println(" 5. Display All Magazine");
            System.out.println(" 6. Delete Library Item");
            System.out.println(" 7. Add Client");
            System.out.println(" 8. Retrieve Client");
            System.out.println(" 9. Display All Clients");
            System.out.println("10. Delete Client");
            System.out.println("11. Borrow Item");
            System.out.println("12. Return Item");
            System.out.println("13. Exit");
            int choice = getValidIntegerInput(sc, "Choose an option: ");
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        String type = getValidStringInput(sc, "Enter item type (book/magazine): ");
                        String title = getValidStringInput(sc, "Enter title: ");

                        if (type.equalsIgnoreCase("book")) {
                            int stock = getValidIntegerInput(sc, "Enter stock: ");
                            sc.nextLine();
                            String author = getValidStringInput(sc, "Enter author: ");
                            library.addItem(new Book(title, stock, author));
                        } else if (type.equalsIgnoreCase("magazine")) {
                            int stock = getValidIntegerInput(sc, "Enter stock: ");
                            sc.nextLine();
                            int edition = getValidIntegerInput(sc, "Enter edition number: ");
                            library.addItem(new Magazine(title, stock, edition));
                        } else {
                            System.out.println("Invalid item type.");
                        }
                        break;

                    case 2:
                        int id = getValidIntegerInput(sc, "Enter itemID to retrieve: ");
                        LibraryItem item = library.getItemById(id);
                        System.out.println("Item details: " + item.getItemDetails());
                        break;

                    case 3:
                        library.displayItems("");
                        break;

                    case 4:
                        library.displayItems("Book");
                        break;

                    case 5:
                        library.displayItems("Magazine");
                        break;

                    case 6:
                        id = getValidIntegerInput(sc, "Enter itemID to delete: ");
                        library.removeItemById(id);
                        System.out.println("Item deleted.");
                        break;

                    case 7:
                        String name = getValidStringInput(sc, "Enter client name: ");
                        String email = getValidStringInput(sc, "Enter client email: ");
                        library.addClient(new Client(name, email));
                        break;

                    case 8:
                        int clientId = getValidIntegerInput(sc, "Enter clientID to retrieve: ");
                        client = library.getClientById(clientId);
                        System.out.print("Client details: ");
                        client.getClientDetails();
                        break;

                    case 9:
                    library.displayClients();
                        break;

                    case 10:
                        clientId = getValidIntegerInput(sc, "Enter clientID to delete: ");
                        library.removeClientById(clientId);
                        break;

                    case 11:
                        clientId = getValidIntegerInput(sc, "Enter clientID to add library item: ");
                        client = library.getClientById(clientId);
                        id = getValidIntegerInput(sc, "Enter itemID to borrow: ");
                        item = library.getItemById(id);
                        client.addBorrowedItem(item);
                        break;

                    case 12:
                        clientId = getValidIntegerInput(sc, "Enter clientID to return library item: ");
                        client = library.getClientById(clientId);
                        id = getValidIntegerInput(sc, "Enter itemID to return: ");
                        item = library.getItemById(id);
                        client.returnBorrowedItem(item);
                        break;

                    case 13:
                        System.out.println("Exiting");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid option Try again.");
                }
            } catch (ItemNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static int getValidIntegerInput(Scanner sc, String title) {
        int number;
        do {
            System.out.print(title);
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number > 0) return number;
                else System.out.println("Invalid input. Please enter number greater than 0.");
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        } while (true);
    }

    private static String getValidStringInput(Scanner sc, String title) {
        String input;
        do {
            System.out.print(title);
            input = sc.nextLine().trim();
            if (input.length() > 0) return input;
            else System.out.println("Invalid input. Please enter a non-empty string.");
        } while (true);
    }
}
