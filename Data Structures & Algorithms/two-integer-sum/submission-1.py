class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen_map = {}
        for index, value in enumerate(nums):
            seen = target - value
            if seen in seen_map:
                return [seen_map[seen], index]
            seen_map[value] = index
        return []