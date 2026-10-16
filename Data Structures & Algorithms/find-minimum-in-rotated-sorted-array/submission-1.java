class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int smallest = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            smallest = Math.min(smallest, nums[mid]);

            if (nums[mid] >= nums[left]) {
                smallest = Math.min(smallest, nums[left]);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return smallest;
    }
}
