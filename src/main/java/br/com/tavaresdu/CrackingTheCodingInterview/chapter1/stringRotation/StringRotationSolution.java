package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.stringRotation;

public interface StringRotationSolution {
    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    default boolean isSubstring(String str1, String str2) {
        return str1 != null && str2 != null && str1.contains(str2);
    }
    boolean isRotation(String str1, String str2);
}
