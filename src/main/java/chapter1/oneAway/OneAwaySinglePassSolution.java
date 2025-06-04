package chapter1.oneAway;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class OneAwaySinglePassSolution implements OneAwaySolution {

    @Override
    public boolean oneAway(String str1, String str2) {
        int i1 = 0, i2 = 0;
        boolean foundOneEdit = false;
        while (i1 < str1.length() && i2 < str2.length()) {
            if (str1.charAt(i1) != str2.charAt(i2)) {
                if (foundOneEdit) {
                    return false;
                }
                foundOneEdit = true;
                if (str1.length() > str2.length()) {
                    i2--;
                } else if (str1.length() < str2.length()) {
                    i1--;
                }
            }
            i1++;
            i2++;
        }
        return true;
    }
}
