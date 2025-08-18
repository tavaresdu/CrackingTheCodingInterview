package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.palindromePermutation;

import java.util.BitSet;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class PalindromePermutationBitSetSolution implements PalindromePermutationSolution {
    private static final char FIRST_CHAR = 'a';
    private static final char LAST_CHAR = 'z';

    @Override
    public boolean isPalindromePermutation(String s) {
        BitSet bitset = new BitSet(26);
        s.chars().forEach(character -> {
            if (character >= FIRST_CHAR && character <= LAST_CHAR) {
                bitset.flip(character - FIRST_CHAR);
            }
        });
        int nextSetBit = bitset.nextSetBit(0);
        return nextSetBit == -1 || nextSetBit == bitset.previousSetBit(25);
    }
}
