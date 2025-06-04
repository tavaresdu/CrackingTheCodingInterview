package chapter1.isUnique;

import java.util.BitSet;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class IsUniqueBitSetSolution implements IsUniqueSolution {
    private static final char FIRST_LETTER = 'a';

    @Override
    public boolean isUnique(String str) {
        BitSet chars = new BitSet(26); //Assuming only lowercase letters
        for (int i = 0; i < str.length(); i++) {
            if (chars.get(charId(str, i))) {
                return false;
            }
            chars.set(charId(str, i));
        }
        return true;
    }

    private int charId(String str, int i) {
        return str.charAt(i) - FIRST_LETTER;
    }
}
