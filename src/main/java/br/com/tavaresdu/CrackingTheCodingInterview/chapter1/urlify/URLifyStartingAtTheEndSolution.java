package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.urlify;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class URLifyStartingAtTheEndSolution implements URLifySolution {

    @Override
    public String urlify(char[] text, int length) {
        int spacesCount = (text.length - length) / 2;
        for (int i = length - 1; i >= 0; i--) {
            if (spacesCount == 0) {
                break;
            }
            int newIndex = i + (spacesCount * 2);
            if (text[i] == ' ') {
                spacesCount--;
                newIndex -= 2;
                text[newIndex] = '%';
                text[newIndex + 1] = '2';
                text[newIndex + 2] = '0';
            } else {
                text[newIndex] = text[i];
            }
        }
        return new String(text);
    }
}
