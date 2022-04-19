package il.vgoudk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllDivisionWithHighScore {
    public static void main(String[] args) {
        AllDivisionWithHighScore obj = new AllDivisionWithHighScore();
        //obj.maxScoreIndices(new int[]{0, 0, 1, 0});
        obj.maxScoreIndices(new int[]{1,1});
    }

    public List<Integer> maxScoreIndices(int[] nums) {

        /*
          k - score
          v - list of indexes with this score
         */
        Map<Integer, List<Integer>> allScores = new HashMap<>();

        int maxScore = 0;

        for (int i = 0; i <= nums.length; i++) {
            int zeros = countInclusive(nums, 0, i, CountType.ZERO);
            int ones = countInclusive(nums, i, nums.length, CountType.ONE);
            int score = zeros + ones;
            if (score > maxScore) {
                maxScore = score;
            }
            List<Integer> scoreIndices = allScores.get(score);
            if (scoreIndices == null) {
                scoreIndices = new ArrayList<>();
                allScores.put(score, scoreIndices);
            }
            scoreIndices.add(i);
        }
        return allScores.get(maxScore);
    }

    private int countInclusive(int[] source, int from, int to, CountType countType) {
        int sum = 0;
        for (int i = from; i < to; i++) {
            switch (countType) {
                case ZERO:
                    sum += source[i] == 0 ? 1 : 0;
                    break;
                case ONE:
                    sum += source[i] == 1 ? 1 : 0;
                    break;
            }
        }
        return sum;
    }


    private enum CountType {
        ZERO, ONE
    }

}