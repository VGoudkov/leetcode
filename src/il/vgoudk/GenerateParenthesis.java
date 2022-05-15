package il.vgoudk;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        char[] data = new char[n*2];
        data[0] = '(';
        final ArrayList<String> out = new ArrayList<>();
        generate(data, 1, 1, out);
        return out;
    }

    void generate(char[] current, int atPos, int currentBalance, List<String> out) {

        if( currentBalance < 0) return;

        if (atPos == current.length) {
            if (currentBalance == 0) out.add(String.valueOf(current));
            return;
        }
        //1-st - (
        current[atPos] = '(';
        generate(current, atPos + 1, currentBalance + 1, out);
        //2-st - )
        current[atPos] = ')';
        generate(current, atPos + 1, currentBalance - 1, out);
    }
}