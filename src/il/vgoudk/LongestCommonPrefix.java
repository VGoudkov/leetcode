package il.vgoudk;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        final int stringCount = strs.length;
        for (int i = 0; i < stringCount; i++) {
            String str = strs[i];
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }
        int lastSameLetterAt = -1;
        for (int curChar = 0; curChar < minLen; curChar++) {
            char curLetter = strs[0].charAt(curChar);
            boolean isSameLetter = true;
            for (int curString = 1; curString < stringCount; curString++) {
                if (strs[curString].charAt(curChar) != curLetter) {
                    isSameLetter = false;
                    break;
                }
            }
            if (isSameLetter == false) {
                break;
            }
            lastSameLetterAt = curChar;
        }
        if (lastSameLetterAt < 0) {
            return "";
        } else {
            return strs[0].substring(0, lastSameLetterAt + 1);
        }
    }
}