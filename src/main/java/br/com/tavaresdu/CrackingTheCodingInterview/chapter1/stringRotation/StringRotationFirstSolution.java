package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.stringRotation;

/**
 * Time complexity: O(N)
 * Space complexity: O(2N)
 */
public class StringRotationFirstSolution implements StringRotationSolution {
    @Override
    public boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length() || str1.isEmpty()) return false;
        return isSubstring(str1+str1, str2);
    }
}
