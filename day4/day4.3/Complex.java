public class Complex<T extends Number> {
    private T real;
    private T img;

    public Complex(T real, T img) {
        this.real = real;
        this.img = img;
    }

    public Complex<Double> sum(Complex<? extends Number> c) {
        return new Complex<Double>(this.real.doubleValue() + c.real.doubleValue(), this.img.doubleValue() + c.img.doubleValue());
    }

    public Complex<Double> sub(Complex<? extends Number> c) {
        return new Complex<>(this.real.doubleValue() - c.real.doubleValue(), this.img.doubleValue()- c.img.doubleValue());
    }

    public void display(){
        double realValue = real.doubleValue();
        double imgValue = img.doubleValue();

        if (realValue == 0 && imgValue == 0) {
            System.out.println(0);
        } else if (realValue == 0) {
            System.out.println(imgValue + "i");
        } else if (imgValue == 0) {
            System.out.println(realValue);
        } else {
            System.out.print(realValue);
            if (imgValue > 0) {
                System.out.print("+");
            }
            System.out.println(imgValue + "i");
        }
    }
}
