import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(5, 10));
        shapes.add(new Circle(10));
        shapes.add(new Rectangle(10, 20));
        shapes.add(new Circle(15));
        shapes.add(new Rectangle(15, 30));
        Picture.drawShapes(shapes);
    }
}
