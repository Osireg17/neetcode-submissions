class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxprofit = 0

        left, right = 0, 1

        while right < len(prices):
            if prices[left] > prices[right]:
                left = right
            current_max = prices[right] - prices[left]
            maxprofit = max(maxprofit, current_max)

            right += 1

        return maxprofit