package telran;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        //первое задание
        Predicate<UniqueNumbers> p = uniqueNumbers -> uniqueNumbers.test(1, 6, 4);
        System.out.println(p.test(new UniqueNumbers()));


        //второе задание
        Function<Integer, Integer> x = num -> num * 2;
        Function<Integer, Integer> f = x;
        System.out.println(f.compose(x).apply(4));

        Function<Integer, Integer> y = num -> num + 3;
        Function<Integer, Integer> g = y;
        System.out.println(g.compose(y).apply(4));

    }
}
