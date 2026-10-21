class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int res = Integer.MAX_VALUE;
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentTimeTaken = 0;

            for (int index = 0; index < piles.length; index++) {
                int timeTaken = (int) Math.ceil((double) piles[index] / mid);
                currentTimeTaken += timeTaken;
            }

            if (currentTimeTaken <= h) {
                right = mid - 1;
                res = Math.min(res, mid);
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
