package telran;

import java.util.function.Function;

public class MyFunction implements Function<Double, Double> {

    @Override
    public Double apply(Double x) {
        return Math.sqrt(x);
    }

   /* Function<Double, Double> sqrt = a -> Math.sqrt(a);
    Function<Double, Double> sqrt = Math::sqrt;*/
}
