package il.vgoudk;

public class ReverseInteger {
    public int reverse(int x) {
        if( x == 0) return 0;
        final char[] digits = String.valueOf(x).toCharArray();
        boolean isNegative = false;
        int startFrom = 0;
        if (digits[0] == '-') {
            isNegative = true;
            startFrom = 1;
        }
        int maxNonZero = digits.length - 1;
        while (digits[maxNonZero] == '0') {
            maxNonZero--;
        }
        int ret = 0;
        for (int j = maxNonZero; j >= startFrom; j--) {
            ret = mul10(ret);
            if (ret == -1) return 0;
            ret = add( ret, Integer.parseInt(String.valueOf(digits[j])));
            if( ret == -1) return 0;
        }
        return isNegative ? ret * -1 : ret;
    }

    int mul10(int x) {
        int ret = 0;
        for (int i = 0; i < 10; i++) {
            ret = add(ret, x);
            if( ret == -1) return ret;
        }
        return ret;
    }

    int add(int current, int x) {
        if (Integer.MAX_VALUE - current < x) {
            return -1;
        }
        return current + x;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);


        System.out.println(Integer.MAX_VALUE);
    }
}