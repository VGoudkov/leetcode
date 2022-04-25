package il.vgoudk;

import java.util.Arrays;

public class PalindromicSubstring {
    public static void main(String[] args) {
        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();
        palindromicSubstring.longestPalindrome("babad");
        palindromicSubstring.longestPalindrome("sabbad");
    }

    public String longestPalindrome(String s) {

        if (s.length() == 1) return s;
        char[] data = s.toCharArray();
        char[] maxPalindrom = new char[0];
        //System.out.println(s + " ===================");
        for (int i = 1; i < data.length - 1; i++) {
            final char[] palindrom = getPalindrom(data, i);
            //  System.out.println(i + " " + String.valueOf(palindrom));
            if (maxPalindrom.length < palindrom.length) {
                maxPalindrom = palindrom;
            }
        }
        final String s1;
        if (maxPalindrom.length == 0) {
            return s.substring(0, 1);
        } else {
            return String.valueOf(maxPalindrom);
        }
        //System.out.println("max: " + s1);
    }

    private char[] getPalindrom(char[] data, int centerIndex) {
        int delta = 1;
        int l = centerIndex;
        int r = centerIndex;

        int similarCount = 0;
        while (centerIndex + 1 + similarCount < data.length && data[centerIndex] == data[centerIndex + 1 + similarCount]) {
            similarCount++;
        }

        while (true) {
            final int lCandidate = centerIndex - delta;
            if (lCandidate < 0) break;
            final int rCandidate = centerIndex + similarCount + delta;
            if (rCandidate > data.length - 1) break;
            if (data[lCandidate] == data[rCandidate]) {
                l = lCandidate;
                r = rCandidate;
                delta++;
            } else {
                break;
            }
        }
        //System.out.print(centerIndex + ": ");
        if (l == r) {
            //  System.out.print("---");
            if (similarCount > 0) {
                char[] ret = new char[similarCount + 1];
                for (int i = 0; i < similarCount + 1; i++) {
                    ret[i] = data[centerIndex];
                }
                return ret;
            } else {
                return new char[0];
            }
        } else {
//        for (int i = l; i <= r; i++) {
//            System.out.print(data[i]);
//        }
//        System.out.println();
            char[] ret = new char[r - l + 1];
            return Arrays.copyOfRange(data, l, r + 1);
        }
    }
}