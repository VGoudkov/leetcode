package il.vgoudk;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> foundCharacters = new HashSet<>();
        final char[] chars = s.toCharArray();
        int right = 0;
        int maxLength = 0;
        int left = 0;
        while (right < chars.length) {
            final char currentLetter = chars[right];
            if (foundCharacters.contains(currentLetter)) {
                maxLength = Math.max(maxLength, foundCharacters.size());
                do {
                    foundCharacters.remove(chars[left]);
                    left++;
                } while (foundCharacters.contains(currentLetter));

            } else {
                foundCharacters.add(currentLetter);
                right++;
            }
        }
        return Math.max(maxLength, foundCharacters.size());
    }
}