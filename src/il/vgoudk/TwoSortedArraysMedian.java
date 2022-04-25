package il.vgoudk;

public class TwoSortedArraysMedian {
    static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int sumLen = nums1.length + nums2.length;
        final int semiCenter = sumLen / 2;
        final boolean isOdd = sumLen % 2 == 0;
        int curIndex = 0;
        int index1 = 0;
        int index2 = 0;
        int lastElement;
        int curElement = Integer.MAX_VALUE;
        //System.out.println("\n\n============");
        //printArray(nums1);
        //System.out.println("============");
        //printArray(nums2);
        //System.out.println("============");
        do {
            lastElement = curElement;

            int num1;
            int num2;

            if (index1 >= nums1.length) {
                num1 = Integer.MAX_VALUE;
            } else {
                num1 = nums1[index1];
            }

            if (index2 >= nums2.length) {
                num2 = Integer.MAX_VALUE;
            }else {
                num2 = nums2[index2];
            }

            if (num1 <= num2) {
                curElement = num1;
                index1++;
            } else {
                curElement = num2;
                index2++;
            }
            //System.out.println(curElement);
            curIndex++;
        } while (curIndex <= semiCenter);
        if (isOdd) {
            return (lastElement + curElement) / 2.0;
        } else {
            return curElement;
        }
    }
}