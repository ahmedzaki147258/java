public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.print("Drawing a rectangle. ");
    }

    @Override
    public double calcArea() {
        return length * width;
    }
}
