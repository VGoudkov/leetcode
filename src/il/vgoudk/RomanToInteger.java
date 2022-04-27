package il.vgoudk;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> convertor = new HashMap<>();
        convertor.put("IV", 4);
        convertor.put("IX", 9);
        convertor.put("CD", 400);
        convertor.put("CM", 900);
        convertor.put("XL", 40);
        convertor.put("XC", 90);
        convertor.put("M", 1000);
        convertor.put("D", 500);
        convertor.put("C", 100);
        convertor.put("L", 50);
        convertor.put("X", 10);
        convertor.put("V", 5);
        convertor.put("I", 1);

        if (s.length() == 1) return convertor.get(s);

        //len 2.. 3999 at this point
        int acc = 0;
        int i = 0;
        while (i < s.length()) {
            Integer current;
            String token;
            if (s.length() - i >= 2) {
                token = s.substring(i, i + 2);
                current = convertor.get(token);
                if (current != null) {
                    acc += current;
                    i += 2;
                    continue;
                }
            }
            token = s.substring(i, i + 1);
            current = convertor.get(token);
            if (current == null) throw new IllegalStateException("Found unknown letter: " + current);
            acc += current;
            i += 1;
        }

        return acc;
    }
}