import java.util.*;

public class Tasks {

    public static String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static String changeСase(String string) {
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                newString.append(Character.toLowerCase(string.charAt(i)));
            } else {
                newString.append(Character.toUpperCase(string.charAt(i)));
            }
        }
        return newString.toString();
    }

    public static List<Integer> getDuplicates(List<Integer> input) {
        HashSet<Integer> numbersSet = new HashSet<>();
        HashSet<Integer> duplicateNumbersList = new HashSet<>();

        for (Integer num : input) {
            if (numbersSet.contains(num)) {
                duplicateNumbersList.add(num);
            } else {
                numbersSet.add(num);
            }
        }
        return new ArrayList<>(duplicateNumbersList);
    }

    public static boolean isMultiplied(List<Integer> list, int num) {
        if (checkNumber(num)) {
            return false;
        } else if (isUnitInList(list, num)) {
            return true;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (num % list.get(i) == 0) {
                    int divResult = num / list.get(i);
                    for (int j = i + 1; j < list.size(); j++) {
                        if (divResult == list.get(j))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkNumber(int num) {
        return (num == 0 && num == 1);
    }

    private static boolean isUnitInList(List<Integer> list, int num) {
        if (list.get(0) == 1) {
            for (int n : list) {
                if (n == num)
                    return true;
            }
        }
        return false;
    }

    public static int gcd(int a, int b) {
        if (a != 0 && b != 0) {
            while (a != 0 && b != 0) {
                if (a > b)
                    a = a % b;
                else b = b % a;
            }
            return a + b;
        }
        return -1;
    }

    static double getSquareSum(int a, int b) {
        // (a+b)^2 = a^2 + 2ab + b^2
        return getSquareNumber(a) + getDoubled(a, b) + getSquareNumber(b);
    }

    // 2 a b
    private static double getDoubled(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        return sum += sum;
    }


    public static double getSquareNumber(int num) {
        return Math.pow(num, 2);
    }
}
