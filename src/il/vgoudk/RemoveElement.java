package il.vgoudk;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        final int len = nums.length;
        int removePos = 0;
        while (removePos < len) {
            if (nums[removePos] == val) {
                for (int takeFromPos = removePos + 1; takeFromPos < len; takeFromPos++) {
                    if (nums[takeFromPos] != val) {
                        nums[removePos] = nums[takeFromPos];
                        nums[takeFromPos] = val;
                        break;
                    }
                }
            }
            removePos++;
        }

        //printArray(nums);

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) count++;
        }

        return count;
    }

    void printArray( int[] arr){
        for( int v: arr){
            System.out.print(" "+v);
        }
    }
}