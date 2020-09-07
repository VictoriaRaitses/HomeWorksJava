package telran;

import java.util.List;
import java.util.function.Predicate;

public class PredicateImpl {

    public Predicate getPredicate(List<Predicate> predicates) {
        return predicates.stream().reduce(Predicate::and).get();
    }
}
