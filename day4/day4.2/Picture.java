import java.util.List;

public class Picture {
    public static void drawShapes(List<? extends Shape> listOfShapes){
        for(Shape s: listOfShapes){
            s.draw();
            System.out.println("Area of shape:" + Math.round(s.calcArea()*100.0)/100.0);
        }
    }
}
