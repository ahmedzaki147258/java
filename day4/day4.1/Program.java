import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            int number = getValidIntegerInput(sc, "Enter a number: ");
            MyOwnClass.validateNumber(number);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Enter role: ");
            String role = sc.next();
            MyOwnClass.accessRestricted(role);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Enter file path: ");
            String filePath = sc.next();
            MyOwnClass.openFile(filePath);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static int getValidIntegerInput(Scanner sc, String title) {
        do {
            System.out.print(title);
            if (sc.hasNextInt()) return sc.nextInt();
            else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        } while(true);
    }
}
