import java.io.File;

public class MyOwnClass {
    public static void validateNumber(int number) throws MyOwnException {
        if (number <= 0) {
            throw new MyOwnException("Number must be greater than 0.");
        }
        System.out.println("valid number.");
    }

    public static void accessRestricted(String role) throws MyOwnException {
        if (!role.equals("admin")) {
            throw new MyOwnException("User must be only admin.");
        }
        System.out.println("valid access");
    }

    public static void openFile(String filePath) throws MyOwnException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new MyOwnException("File not found");
        }
        System.out.println("File open successfully.");
    }
}