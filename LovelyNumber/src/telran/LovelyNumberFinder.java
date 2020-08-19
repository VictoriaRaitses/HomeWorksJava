package telran;

import java.util.HashMap;
import java.util.Map;

public class LovelyNumberFinder {

    public boolean isLovelyNumber(int number) {
        String str = String.valueOf(number);
        Map<Character, Integer> numToCount = new HashMap<>();

        for (char num : str.toCharArray()) {
            if (!numToCount.containsKey(num)) {
                numToCount.put(num, 1);
            } else {
                numToCount.put(num, numToCount.get(num) + 1);
            }
        }

        for (int n : numToCount.values()) {
            if (n > 2)
                return false;
        }
        return true;
    }
}
