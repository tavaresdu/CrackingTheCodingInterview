package chapter1.checkPermutation;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class CheckPermutationHashMapSolution implements CheckPermutationSolution {

    @Override
    public boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        fillMap(map1, str1);
        fillMap(map2, str2);
        return map1.equals(map2);
    }

    private void fillMap(Map<Character, Integer> map, String str) {
        for (Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }
}
