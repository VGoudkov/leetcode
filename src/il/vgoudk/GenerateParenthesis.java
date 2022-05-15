package il.vgoudk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        Set<String> results = new HashSet<>();
        final String baseBlock = getBaseBlock(n);
        results.add( baseBlock);
        doAllSwaps(baseBlock, results, baseBlock.length() - 1);
        return new ArrayList<>( results);
    }


    void doAllSwaps(String source, Set<String> accumulator, int distance) {
        if (distance == 0) return;
        String changed = source;
        for (int i = 0; i < source.length() - distance; i++) {
            doAllSwaps(changed, accumulator, distance - 1);
            if (source.charAt(i) == source.charAt(i + distance)) continue;
            changed = change(source, i, distance);
            if (!isValid(changed.toCharArray())) continue;
            accumulator.add(changed);
        }
    }

    String change(String source, int fromIndex, int atDistance) {
        char[] chars = source.toCharArray();
        final int left = fromIndex;
        final int right = fromIndex + atDistance;
        if (right >= chars.length) return source; //TODO: should not occure...
        final char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
        return String.valueOf(chars);
    }

    String getBaseBlock(int n) {
        return "(".repeat(n) + ")".repeat(n);
    }

    boolean isValid(char[] data) {
        int balance = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == '(') balance++;
            else if (data[i] == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

}