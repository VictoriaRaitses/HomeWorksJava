package telran;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        MyFunction function = new MyFunction();
        double res = function.apply(2.0);
        System.out.println(res);

        Function<List<String>, Set<String>> unrepeatable = new Function<List<String>, Set<String>>() {
            @Override
            public Set<String> apply(List<String> strings) {
                return new HashSet<>(strings);
            }
        };

        List<String> list = Arrays.asList("hello", "hello", "by", "by");
        System.out.println(unrepeatable.apply(list));

 /*       Function<List<String>, Set<String>> unrepeatable1 = strings -> new HashSet<String>(strings);
        Function<List<String>, Set<String>> unrepeatable2 = HashSet::new;
        System.out.println(unrepeatable1.apply(list));
        System.out.println(unrepeatable2.apply(list));*/

        double a = 1;
        double b = 2;
        double c = 3;

        Function<Double, Double> closureFunction = new Function<Double, Double>() {
            @Override
            public Double apply(Double x) {
                return Math.pow(a * x, 2) + (b * x) + c;
            }
        };

          /*Function<Double, Double> closureFunction1 = x -> Math.pow(a * x, 2) + (b * x) + c;
        System.out.println(closureFunction1.apply(4.2));*/

        System.out.println(closureFunction.apply(4.2));

    }
}
