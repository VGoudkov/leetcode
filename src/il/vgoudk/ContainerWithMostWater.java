package il.vgoudk;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int leftIndex = 0; leftIndex < height.length - 1; leftIndex++) {
            for (int rightIndex = leftIndex + 1; rightIndex < height.length; rightIndex++) {
                final int curWidth = rightIndex - leftIndex;
                final int curHeight = Math.min(height[leftIndex], height[rightIndex]);
                final int area = curWidth * curHeight;
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }
}