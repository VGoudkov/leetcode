package il.vgoudk;

public class StrStr {
    public int strStr(String haystack, String needle) {

        if ( needle.length() ==0) return 0;
        if( haystack.length() == 0 || haystack.length() < needle.length()) return  -1;

        char[] base = haystack.toCharArray();
        char[] pattern = needle.toCharArray();


        int ret = -1;
        final int lastIndexToCheck = base.length - pattern.length + 1;
        for (int i = 0; i <= lastIndexToCheck; i++) {
            boolean found = true;
            int baseIndex = i;
            for (int patternIndex = 0; patternIndex < pattern.length; patternIndex++) {
                if (baseIndex >= base.length || base[baseIndex] != pattern[patternIndex]) {
                    found = false;
                    break;
                }
                baseIndex++;
            }
            if (found) {
                ret = i;
                break;
            }
        }
        return ret;
    }
}