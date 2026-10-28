class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        
        # first initialise both res and the subset
        res = []
        subset = []


        #next we create the dfs which just takes an index
        def dfs(index):
            if sum(subset) == target:
                res.append(subset.copy())
                return
            
            if index == len(nums):
                return
            
            subset.append(nums[index])

            if sum(subset) > target:
                subset.pop()
                dfs(index + 1)
            else:
                dfs(index)
                subset.pop()
                dfs(index + 1)

        dfs(0)
        return res