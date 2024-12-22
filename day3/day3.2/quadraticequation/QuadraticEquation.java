package quadraticequation;

public class QuadraticEquation implements IQuadratic<Double, Double, Double, Double, Double> {
    private double calcDiscriminant(Double a, Double b, Double c){
        if(a == null || b == null || c == null) throw new RuntimeException("Input cannot be null");
        if(a==0) throw new RuntimeException("a cannot be zero");
        double discriminant = b*b - 4*a*c;
        if(discriminant < 0) throw new RuntimeException("No real roots exist");
        return discriminant;
    }

    @Override
    public Pair<Double, Double> solveQuadraticEquation(Double a, Double b, Double c) {
        double discriminant = calcDiscriminant(a, b, c);
        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        return new Pair<Double, Double>(root1, root2);
    }
}
