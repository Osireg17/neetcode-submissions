class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        diff = {}

        for key, value in enumerate(nums):
            curr = target - value
            if curr in diff:
                return [diff[curr], key]
            diff[value] = key
        return []

        