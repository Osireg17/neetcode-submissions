class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        seen = set(nums)
        if len(seen) != len(nums):
            return True
        return False
         