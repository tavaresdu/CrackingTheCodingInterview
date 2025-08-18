package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.isUnique;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class IsUniqueHashSetSolution implements IsUniqueSolution {

    @Override
    public boolean isUnique(String str) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (chars.contains(str.charAt(i))) {
                return false;
            }
            chars.add(str.charAt(i));
        }
        return true;
    }
}
