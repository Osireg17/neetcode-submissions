class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff) + 1, i + 1};
            }

            prevMap.put(num, i);
        }

        return new int[] {};

    }
}
