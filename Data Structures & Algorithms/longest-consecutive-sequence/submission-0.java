class Solution {
    public int longestConsecutive(int[] nums) {
        /*

        [2,20,4,10,3,4,5]

        [0,3,2,5,4,6,1,1]


        */

        HashSet<Integer> seen = new HashSet<>();
        int longest = 0;

        for (int index = 0; index < nums.length; index++){
            seen.add(nums[index]);
        }

        for (int index = 0; index < nums.length; index++) {
            seen.add(nums[index]);
            // need to check if If num - 1 exists in the HashSet, skip it.
            if (seen.contains(nums[index] - 1)) {
                continue;
            }

            int currentNum = nums[index];
            int currentSeq = 1;

            while (seen.contains(currentNum + 1)) {
                currentNum += 1;
                currentSeq += 1;
            }

            longest = Math.max(longest, currentSeq);
        }

        return longest;
    }
}
