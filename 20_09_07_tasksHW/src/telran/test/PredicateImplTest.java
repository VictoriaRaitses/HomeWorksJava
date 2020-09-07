package telran.test;

import org.junit.jupiter.api.Test;
import telran.PredicateImpl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class PredicateImplTest {
    PredicateImpl predicate = new PredicateImpl();

    @Test
    public void testGetPredicate_true() {
        Predicate<String> pr1 = str -> str.startsWith("A");
        Predicate<String> pr2 = str -> str.length() < 5;

        List<Predicate> predicates = Arrays.asList(pr1, pr2);

        assertTrue(predicate.getPredicate(predicates).test("Alf"));
    }

    @Test
    public void testGetPredicate_wrongInput_false() {
        Predicate<String> predicate1 = str -> str.startsWith("A");
        Predicate<String> predicate2 = str -> str.length() < 5;

        List<Predicate> predicates = Arrays.asList(predicate1, predicate2);

        assertFalse(predicate.getPredicate(predicates).test("alf"));
    }

    @Test
    public void testGetPredicate_wrongLength_false() {
        Predicate<String> predicate1 = str -> str.startsWith("A");
        Predicate<String> predicate2 = str -> str.length() < 5;

        List<Predicate> predicates = Arrays.asList(predicate1, predicate2);

        assertFalse(predicate.getPredicate(predicates).test("Alfred"));
    }

    @Test
    public void testGetPredicate_mixPredicates_true() {
        Predicate<String> predicate1 = str -> str.startsWith("A");
        Predicate<String> predicate2 = str -> str.length() < 7;
        Predicate<String> predicate3 = str -> str.contains("r");
        Predicate<String> predicate4 = str -> str.endsWith("d");

        List<Predicate> predicates = Arrays.asList(predicate1, predicate2, predicate3, predicate4);

        assertTrue(predicate.getPredicate(predicates).test("Alfred"));
    }

    @Test
    public void testGetPredicate_mixPredicates_false() {
        Predicate<String> predicate1 = str -> str.startsWith("A");
        Predicate<String> predicate2 = str -> str.length() < 7;
        Predicate<String> predicate3 = str -> str.contains("K");
        Predicate<String> predicate4 = str -> str.endsWith("d");

        List<Predicate> predicates = Arrays.asList(predicate1, predicate2, predicate3, predicate4);

        assertFalse(predicate.getPredicate(predicates).test("Alfred"));
    }
}