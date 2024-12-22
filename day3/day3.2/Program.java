import java.util.Scanner;
import quadraticequation.Pair;
import quadraticequation.QuadraticEquation;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            double a = getValidDoubleInput(sc, "Enter a: ");
            double b = getValidDoubleInput(sc, "Enter b: ");
            double c = getValidDoubleInput(sc, "Enter c: ");

            QuadraticEquation qe = new QuadraticEquation();
            Pair<Double, Double> result = qe.solveQuadraticEquation(a, b, c);
            System.out.println("Root1: " + Math.round(result.getR1()*100.0)/100.0);
            System.out.println("Root2: " + Math.round(result.getR2()*100.0)/100.0);
		} catch (Exception e){
			System.out.println(e.getMessage());
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
