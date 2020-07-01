import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import jdk.internal.util.xml.impl.Pair;

import javax.swing.plaf.metal.MetalTheme;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.function.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Given an integer, return a power of integer: 5 -> 25
        UnaryOperator<Integer> pow = num -> num * num;
        System.out.println(pow.apply(5));

        //Given a string, return modulo 2 of string length: "abcde" -> 1
        Function<String, Integer> modulo = str -> str.length() % 2;
        System.out.println(modulo.apply("abcde"));

        //Given a string, return its in upper case: "ivan" -> "IVAN"
        Function<String, String> upper = str -> str.toUpperCase();
        System.out.println(upper.apply("ivan"));

        //Given 2 strings, return a sum of their lengths: "abc", "de" -> 5
        BiFunction<String, String, Integer> sum = (str1, str2) -> str1.length() + str2.length();
        System.out.println(sum.apply("abc", "de"));

        //Given 2 strings, print a sum of their lengths.
        BiConsumer<String, String> print = (str1, str2) -> System.out.println(str1.length() + str2.length());
        print.accept("abc", "de");

        //Return a date of one week prior to today: "2020-05-30"
        Supplier<LocalDate> date = () -> LocalDate.of(2020, 05, 30).minusWeeks(1);
        System.out.println(date.get());

        //Given a string, return a string, which consists of a first half of its character
        // , if length is even, returns an empty string otherwise: "abcde" -> "ab", "abcde" -> "".
        Function<String, String> evenStr = (str) -> str.length() % 2 == 0 ? "" : str.substring(0, str.length() / 2);
        System.out.println(evenStr.apply("abcde"));

        // Return a random number
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        //Given a string, return a reversed string: "abc" ->"cba"
        Function<String, String> reversStr = str -> new StringBuilder(str).reverse().toString();
        System.out.println(reversStr.apply("abc"));

        //Given a number, return a reversed number: 12345 -> 54321
        Function<Integer, Integer> reversNumber = number -> Integer.parseInt(reversStr.apply(number.toString()));
        System.out.println(reversNumber.apply(1125557));

        //Given a number, return true if it is even, false otherwise: 6 -> true, 25 -> false
        Predicate<Integer> evenNumber = number -> number % 2 == 0;
        System.out.println(evenNumber.test(25));

        //Given a string, return true, if its length is more than 3, false otherwise: "ab" -> false, "abc" -> true
        Predicate<String> stingLenghtMorethan3 = str -> str.length() > 3;
        System.out.println(stingLenghtMorethan3.test("ab"));

        //Given a string and a number x. Return true, if length of string is more than x
        // , false otherwise. Hint: BiPredicate.
        BiPredicate<String, Integer> stringLengthvalidation = (str, length) -> str.length() > length;
        System.out.println(stringLengthvalidation.test("dgh",5));

        //Print a given string
        Consumer<String> printString = System.out::println;
        printString.accept("hallo");

        //Given a string, return a lower case string
        Function<String, String> lowerCaseStr = str -> str.toLowerCase();
        System.out.println(lowerCaseStr.apply("HI"));

        //Given a number, return a square root from the number
        Function<Double, Double> getSqrt = num -> Math.sqrt(num);
        System.out.println(getSqrt.apply(3.9));

        //Implement solution 7 from above as a method reference
        Function<Double, Double> getSqrtMethod = Math::sqrt;
        System.out.println(getSqrtMethod.apply(5.0));

        //Given a class Employee with name and salary. Return an employee salary using 1. Supplier, 2. Function.
        Function<Employee, Integer> getSalary = Employee::getSalary;
        System.out.println(getSalary.apply(new Employee("Vova",3000)));

        Supplier<Integer> getSupplierSalary = ()-> getSalary.apply(new Employee("Gri", 100));

        System.out.println(getSupplierSalary.get());
    }
}
