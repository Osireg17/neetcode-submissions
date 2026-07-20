class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        visited = {}

        
        def backtrack(step, path, total):
            if total == target:
                res.append(path)
                return
            if total > target:
                return

            for i in range(step, len(nums)):
                num = nums[i]
                backtrack(i, path + [num], total + num)

        backtrack(0, [], 0)
        return res