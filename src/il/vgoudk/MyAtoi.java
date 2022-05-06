package il.vgoudk;

public class MyAtoi {
    public int myAtoi(String s) {

        char[] digits = new char[s.length()];
        int curDigit = 0;
        int curLetter = 0;
        boolean isPositive = true;

        int len = s.length();

        while (curLetter < len && s.charAt(curLetter) == ' ') {
            curLetter++;
        }
        if (curLetter < len && s.charAt(curLetter) == '+') {
            curLetter++;
        } else if (curLetter < len && s.charAt(curLetter) == '-') {
            isPositive = false;
            curLetter++;
        }

        while (curLetter < len && (s.charAt(curLetter) >= '0' && s.charAt(curLetter) <= '9')) {
            digits[curDigit] = s.charAt(curLetter);
            curLetter++;
            curDigit++;
        }

        int firstNonZero = 0;
        while (firstNonZero < digits.length && digits[firstNonZero] == '0') firstNonZero++;

        int result = 0;
        int multiplier = 1;
        final int MAX_MULTIPLIER = 1000000000;
        for (int i = digits.length - 1; i >= firstNonZero; i--) {
            if (digits[i] == 0) continue;
            final int digit = digits[i] - '0';

            if( multiplier == MAX_MULTIPLIER && digit > 2) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            final int nextAddition = digit * multiplier;

            if (isPositive) {
                if (Integer.MAX_VALUE - result < nextAddition) {
                    return Integer.MAX_VALUE;
                }
                result += nextAddition;
            } else {
                if (result != 0 && Math.abs(Integer.MIN_VALUE - result) < nextAddition) {
                    return Integer.MIN_VALUE;
                }
                result -= nextAddition;
            }
            if (multiplier == MAX_MULTIPLIER) {
                if (i == firstNonZero) {
                    return result;
                } else {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            multiplier *= 10;
        }
        return result;
    }
}