package il.vgoudk;

import java.util.ArrayList;
import java.util.List;

public class AllDivisionWithHighScore2 {
    public static void main(String[] args) {
        AllDivisionWithHighScore2 obj = new AllDivisionWithHighScore2();
        //final List<Integer> answers = obj.maxScoreIndices(new int[]{0, 0, 1, 0});
        //final List<Integer> answers = obj.maxScoreIndices(new int[]{1,1});
        final List<Integer> answers = obj.maxScoreIndices(new int[]{0, 0, 0});
        System.out.println(answers);
    }

    public List<Integer> maxScoreIndices(int[] nums) {
        final int len = nums.length;

        final int resLen = len + 1;
        int[] zeroSum = new int[resLen];

        zeroSum[0] = 0;
        for (int i = 0; i < len; i++) {
            zeroSum[i + 1] = nums[i] == 0 ? zeroSum[i] + 1 : zeroSum[i];
        }

        int[] oneSum = new int[resLen];
        oneSum[len] = 0;
        for (int i = len - 1; i >= 0; i--) {
            oneSum[i] = nums[i] == 1 ? oneSum[i + 1] + 1 : oneSum[i + 1];
        }

        int max = 0;
        for (int i = 0; i < resLen; i++) {
            final int sum = zeroSum[i] + oneSum[i];
            if (sum > max) {
                max = sum;
            }
        }
        List<Integer> ret = new ArrayList<>(resLen);
        for (int i = 0; i < resLen; i++) {
            final int sum = zeroSum[i] + oneSum[i];
            if (sum == max) {
                ret.add(i);
            }
        }
        return ret;

    }


}