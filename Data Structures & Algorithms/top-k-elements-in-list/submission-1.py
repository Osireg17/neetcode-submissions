from collections import Counter
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        nums_counter = Counter(nums)
        print(nums_counter)

        res = []

        for key, value in enumerate(nums_counter.most_common(k)):
            res.append(value[0])


        print(res)

        return res