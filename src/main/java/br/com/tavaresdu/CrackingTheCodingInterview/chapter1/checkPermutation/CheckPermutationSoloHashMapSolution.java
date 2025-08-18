package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.checkPermutation;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class CheckPermutationSoloHashMapSolution implements CheckPermutationSolution {

    @Override
    public boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Character c : str2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
