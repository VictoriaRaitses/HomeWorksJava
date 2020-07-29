import java.util.*;

public class MapSetHW {

    public static List<String> removeDuplicates(List<String> input) {
        return new ArrayList<>(new HashSet<>(input));
    }

    public static List<String> getDuplicates(List<String> input) {
        HashSet<String> namesSet = new HashSet<>();
        List<String> duplicateNamesList = new ArrayList<>();

        for (String name : input) {
            if (namesSet.contains(name)) {
                duplicateNamesList.add(name);
            } else {
                namesSet.add(name);
            }
        }
        return duplicateNamesList;
    }

    public static Map<String, String> getSumValues(Map<String, String> text) {
        if (text.keySet().size() == 1)
            return text;

        StringBuilder newKey = new StringBuilder();
        StringBuilder newValue = new StringBuilder();

        for (Map.Entry entry : text.entrySet()) {
            newKey.append(entry.getKey());
            newValue.append(entry.getValue());
        }

        text.put(newKey.toString(), newValue.toString());
        return text;
    }

    public static Map<String, Boolean> isDuplicate(String[] letters) {
        Map<String, Boolean> map = new HashMap<>();
        for (String s : letters)
            if (map.containsKey(s))
                map.put(s, true);
            else
                map.put(s, false);
        return map;
    }

    public static List<String> getAnagrams(List<String> lib, String name) {
        List<String> arr = new ArrayList<>();
        for (String str : lib) {
            if (isAnagramString(name, str) && !str.equals(name))
                arr.add(str);
        }
        return arr;
    }

    private static boolean isAnagramString(String name, String str) {
        char[] chars1 = str.toCharArray();
        char[] chars2 = name.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    public static int getNumberOfRepetitionsByName(List<String> lib, String name) {
        Map<String, Integer> wordToCount = new HashMap<>();
        for (String word : lib) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 1);
            } else {
                wordToCount.put(word, wordToCount.get(word) + 1);
            }
        }

        return wordToCount.containsKey(name) ? wordToCount.get(name) : 0;
    }

    public static String getMostRepeatedWord(String text, Set<String> prepositions) {
        List<String> words = getSplittedWords(text, prepositions);

        Map<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word.toLowerCase(), 1);
            } else {
                wordToCount.put(word.toLowerCase(), wordToCount.get(word) + 1);
            }
        }
        return getFrequentWord(wordToCount);
    }

    private static String getFrequentWord(Map<String, Integer> wordToCount) {
        int maximumFriquentNumber = 0;
        String word = "";
        for (Map.Entry<String, Integer> entry : wordToCount.entrySet()) {
            if (entry.getValue() > maximumFriquentNumber) {
                maximumFriquentNumber = entry.getValue();
                word = entry.getKey();
            }
        }
        return word;
    }

    private static List<String> getSplittedWords(String text, Set<String> prepositions) {
      String[] textArray  = text
                .replace(",", " ")
                .replace(".", " ")
              .split("\\s+");
        List<String> words = new ArrayList<>(Arrays.asList(textArray));
        words.removeAll(prepositions);
        return words;
    }

}