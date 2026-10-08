class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int solution = 0;

        while (left <= right){
            int area = Math.min(heights[left], heights[right]) * (right - left);
            solution = Math.max(solution, area);

            if (heights[right] <= heights[left]){
                right -= 1;
            } else {
                left += 1;
            }
        }
        return solution;
    }
}
