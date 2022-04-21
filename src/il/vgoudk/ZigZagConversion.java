package il.vgoudk;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        char[] input = s.toCharArray();
        final int inputLength = s.length();
        char[][] output = new char[numRows][inputLength];
        int globalPos = 0;
        int inRowPos = 0;
        while (true) {
            //downstream
            for (int i = 0; i < numRows; i++) {
                output[i][inRowPos] = input[globalPos];
                globalPos++;
                if (globalPos > inputLength - 1) {
                    break;
                }
            }

            if (!(globalPos > inputLength - 1)) {
                //upstream
                for (int i = numRows - 2; i > 0; i--) {
                    inRowPos++;
                    output[i][inRowPos] = input[globalPos];
                    globalPos++;
                    if (globalPos > inputLength - 1) {
                        break;
                    }
                }
            }
            inRowPos++;
            if (globalPos > inputLength - 1) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < inputLength; j++) {
                if (output[i][j] != 0) sb.append(output[i][j]);
            }

        }
        return sb.toString();
    }
}