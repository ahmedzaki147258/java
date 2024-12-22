package converttemperature;

import java.util.function.Function;

public class ConvertTemperatureToCentigrade implements Function<Double, Double> {
    @Override
    public Double apply(Double val){
        return (val-32) * 5/9;
    }
}
