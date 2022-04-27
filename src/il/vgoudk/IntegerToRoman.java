package il.vgoudk;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        int current = num;

        while (current >= 1000) {
            sb.append("M");
            current -= 1000;
        }

        final String[][] rules = {
                {"CM", "XC", "IX"},
                {"D", "L", "V"},
                {"CD", "XL", "IV"},
                {"C", "X", "I"}
        };

        final int NINE = 0;
        final int FIVE = 1;
        final int FOUR = 2;
        final int ONE = 3;


        for (int pow = 3; pow >= 1; pow--) {
            int x = getNumber( current, pow);
            if( x == 0) continue;
            if( x == 9){
                sb.append( getRoman(rules, NINE,pow));
            }else if( x>=5){
                sb.append( getRoman(rules, FIVE,pow));
                sb.append(getRoman(rules, ONE,pow).repeat(x-5));
            }else if( x==4){
                sb.append( getRoman(rules, FOUR,pow));
            }else {
                sb.append(getRoman(rules, ONE,pow).repeat(x));
            }
        }

        return sb.toString();
    }

    String getRoman( String[][] rules, int baseNumber, int pow){
        return rules[baseNumber][3 - pow];
    }


    int getNumber(int num, int pow) {
        switch (pow) {
            case 3:
                return num / 100;
            case 2:
                return (num % 100) / 10;
            case 1:
                return num % 10;
            default:
                throw new IllegalArgumentException(String.valueOf(pow));
        }
    }
}