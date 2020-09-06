package telran;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) {

        Predicate<String> predicate1 = str -> str.startsWith("A");
        Predicate<String> predicate2 = str -> str.length() < 5;

        List<Predicate> predicates = Arrays.asList(predicate1, predicate2);
        Predicate<String> pr = getNewPredicate(predicates);

        System.out.println(pr.test("Adf"));
        System.out.println(pr.test("adf"));
        System.out.println(pr.test("Adfffff"));
    }

    public static Predicate getNewPredicate(List<Predicate> predicates) {
        Predicate predicate = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            predicate = predicate.and(predicates.get(i));
        }
        return predicate;
    }


}
