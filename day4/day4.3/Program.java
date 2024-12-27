
public class Program {
    public static void main(String[] args) {
        Complex<Integer> c1 = new Complex<Integer>(3, -4);
        Complex<Double> c2 = new Complex<Double>(1.5, 2.5);
        Complex<Double> sumResult = c1.sum(c2);
        System.out.print("Sum: ");
        sumResult.display();

        Complex<Double> subResult = c1.sub(c2);
        System.out.print("Sub: ");
        subResult.display();
    }
}
