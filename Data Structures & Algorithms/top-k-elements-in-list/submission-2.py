from collections import Counter
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        nums_counter = Counter(nums)
        res = []
        print(nums_counter.most_common(k))
        for key, value in nums_counter.most_common(k):
            res.append(key)

        return res
