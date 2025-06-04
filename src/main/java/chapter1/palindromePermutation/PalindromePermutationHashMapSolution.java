package chapter1.palindromePermutation;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class PalindromePermutationHashMapSolution implements PalindromePermutationSolution {
    private static final char FIRST_CHAR = 'a';
    private static final char LAST_CHAR = 'z';

    @Override
    public boolean isPalindromePermutation(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        s.chars().forEach(character -> {
            if (character >= FIRST_CHAR && character <= LAST_CHAR) {
                map.put(character, map.getOrDefault(character, 0) + 1);
            }
        });
        boolean foundSoloLetter = false;
        for (Integer key : map.keySet()) {
            if ((map.get(key) % 2) != 0) {
                if (map.get(key) == 1) {
                    if (foundSoloLetter) {
                        return false;
                    }
                    foundSoloLetter = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
