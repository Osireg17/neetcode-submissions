from collections import Counter
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        hashmap = Counter(nums)
        res = hashmap.most_common(1)
        return res[0][0]
        