package chapter1.isUnique;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class IsUniqueHashMapSolution implements IsUniqueSolution {

    @Override
    public boolean isUnique(String str) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (chars.containsKey(str.charAt(i))) {
                return false;
            }
            chars.put(str.charAt(i), i);
        }
        return true;
    }
}
