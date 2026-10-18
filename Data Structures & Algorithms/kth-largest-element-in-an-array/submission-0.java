class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> sortedNums = Arrays.stream(nums)
                                       .boxed()
                                       .sorted(Comparator.reverseOrder())
                                       .collect(Collectors.toList());

        return sortedNums.get(k-1);
    }
}
