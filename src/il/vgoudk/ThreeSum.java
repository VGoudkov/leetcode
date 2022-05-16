package il.vgoudk;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        K = value
        V = index

         */
        Map<Integer, Integer> data = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            data.put(nums[i], i);
        }

        List<Triplet> out = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                final int a = nums[i];
                final int b = nums[j];
                int c = (a + b) * -1;
                Integer k = data.get(c);
                if (k == null || k == i || k == j) continue;
                final Triplet triplet = new Triplet(a, b, c);
                if (!out.contains(triplet)) out.add(triplet);
            }
        }
        return out.stream().map(t -> Arrays.asList(t.i, t.j, t.k)).collect(Collectors.toList());
    }


    class Triplet {
        int i, j, k;

        public Triplet(int a, int b, int c) {
            if (a > b) {
                if (b > c) {
                    i = c;
                    j = b;
                    k = a;
                } else if (a > c) {
                    i = b;
                    j = c;
                    k = a;
                } else {
                    i = b;
                    j = a;
                    k = c;
                }
            } else {
                if (c > b) {
                    i = a;
                    j = b;
                    k = c;
                } else if (a > c) {
                    i = c;
                    j = a;
                    k = b;
                } else {
                    i = a;
                    j = c;
                    k = b;
                }
            }
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triplet)) return false;

            Triplet triplet = (Triplet) o;

            if (i != triplet.i) return false;
            if (j != triplet.j) return false;
            return k == triplet.k;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            result = 31 * result + k;
            return result;
        }
    }

}