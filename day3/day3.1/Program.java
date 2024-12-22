import java.util.Scanner;
import converttemperature.ConvertTemperatureToCentigrade;
import converttemperature.ConvertTemperatureToFahrenheit;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            double temperatureInFahrenheit = getValidDoubleInput(sc, "Enter temperature in Fahrenheit: ");
            ConvertTemperatureToCentigrade c = new ConvertTemperatureToCentigrade();
            System.out.println("Temperature in Centigrade: " + Math.round(c.apply(temperatureInFahrenheit) * 100.0) / 100.0 + "°C");

            double temperatureInCentigrade = getValidDoubleInput(sc, "Enter temperature in Centigrade: ");
            ConvertTemperatureToFahrenheit f = new ConvertTemperatureToFahrenheit();
            System.out.println("Temperature in Fahrenheit: " + Math.round(f.apply(temperatureInCentigrade) * 100.0) / 100.0 + "°F");
        } finally {
            if (sc != null) sc.close();
        }
    }

    private static double getValidDoubleInput(Scanner sc, String title) {
        do {
            System.out.print(title);
            if (sc.hasNextDouble()) return sc.nextDouble();
            else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        } while(true);
    }
}
