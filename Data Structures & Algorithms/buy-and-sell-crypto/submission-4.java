class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int res = 0;

        while(right < prices.length){
            if (prices[left] <= prices[right]){
                int diff = prices[right] - prices[left];
                res = Math.max(res, diff);
            } else {
                left = right;
            }
            right ++;
        }

        return res;
    }
}
