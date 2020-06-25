import java.lang.reflect.Array;
import java.util.*;

public class Collection {

    public static List<String> getNamesLongerThanFour(List<String> names) {
        List<String> longerNames = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 4) {
                longerNames.add(name);
            }
        }
        return longerNames;
    }

    public static List<String> compareLists(List<Integer> first, List<Integer> second) {
        List<String> comparedList = new ArrayList<>();
        if (first.size() == second.size()) {
            for (int i = 0; i < first.size(); i++) {
                if (first.get(i).equals(second.get(i))) {
                    comparedList.add("yes");
                } else comparedList.add("no");
            }
        } else {
            return comparedList;
        }
        return comparedList;
    }

    // 3 4 | 1 2 3 4 | 1 2 -> 1 2 3 4
    public static boolean isCycle(List<String> first, List<String> second) {
        if (first.size() != second.size())
            return false;
        List<String> s = new ArrayList<>(second);
        s.addAll(second);
        return Collections.indexOfSubList(s, first) != -1;
    }

    public static List<String> getReverseList(List<String> oldList) {
        List<String> newList = new ArrayList<>();
        for (int i = oldList.size() - 1; i >= 0; i--) {
            newList.add(oldList.get(i));
        }
        return newList;
    }

    public static List<String> combineTwoLists(List<String> first, List<String> second) {
        List<String> newList = new ArrayList<>(first);
        newList.addAll(second);
        return newList;
    }

    public static List<Integer> getSmallerNumbers(List<Integer> numbers, int number) {
        List<Integer> newList = new ArrayList<>();
        for (int num : numbers) {
            if (num <= number)
                newList.add(num);
        }
        return newList;
    }
}
