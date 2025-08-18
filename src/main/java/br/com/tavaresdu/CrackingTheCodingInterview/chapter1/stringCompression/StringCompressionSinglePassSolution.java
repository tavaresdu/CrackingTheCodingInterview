package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.stringCompression;

public class StringCompressionSinglePassSolution implements StringCompressionSolution {

    @Override
    public String compressString(String str) {
        if (str.length() <= 2) return str;
        char lastChar = str.charAt(0);
        int ocurrences = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            char actualChar =  str.charAt(i);
            if (actualChar == lastChar) {
                ocurrences++;
            } else {
                stringBuilder.append(lastChar).append(ocurrences);
                lastChar = actualChar;
                ocurrences = 1;
                if (stringBuilder.length() + 2 >= str.length()) {
                    return str;
                }
            }
        }
        return stringBuilder.append(lastChar).append(ocurrences).toString();
    }
}
