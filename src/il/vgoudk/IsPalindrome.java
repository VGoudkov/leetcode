package il.vgoudk;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        char[] letters = String.valueOf(x).toCharArray();
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            if (letters[left] != letters[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}