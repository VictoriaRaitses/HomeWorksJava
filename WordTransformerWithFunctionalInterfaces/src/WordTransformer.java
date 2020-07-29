
import java.util.function.Function;
import java.util.function.Predicate;

public class WordTransformer {

    public static String wordTransform(String str) {

        String[] strings = str.split(" ");

        for (int i = 0; i < strings.length; i++) {
            String word = strings[i];
            Predicate<Integer> predicate = wordSize -> wordSize == 3;

            if (predicate.test(word.length())) {
                Function<String, String> function = text -> text.toUpperCase();
                strings[i] = function.apply(word);
            }
        }
        return str.join(" ", strings);
    }
}
