package chapter1.urlify;

/**
 * Time Complexity: O(N²)
 * Space Complexity: O(1)
 */
public class URLifyBruteForceSolution implements URLifySolution {

    @Override
    public String urlify(char[] text, int length) {
        for (int i = 0; i < text.length; i++) {
            if (text[i] == ' ') {
                for (int j = text.length - 1; j > i && j > 1; j--) {
                    text[j] = text[j - 2];
                }
                text[i] = '%';
                text[i + 1] = '2';
                text[i + 2] = '0';
            }
        }
        return new String(text);
    }
}
