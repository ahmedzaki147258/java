package converttemperature;

import java.util.function.Function;

public class ConvertTemperatureToFahrenheit implements Function<Double, Double> {
    @Override
    public Double apply(Double val){
        return (val*9/5) + 32;
    }
}
