class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        # first initialise both res and the subset
        res = []
        subset = []
        seen = set()
        candidates.sort()


        #next we create the dfs which just takes an index
        def dfs(index):
            if sum(subset) == target:
                res.append(subset.copy())
                return 
            
            if index == len(candidates):
                return
            
            subset.append(candidates[index])

            if sum(subset) > target:
                subset.pop()
                dfs(index + 1)
            else:
                dfs(index+1) # inclusion branch
                subset.pop() # backtrack
                while index + 1 < len(candidates) and candidates[index] == candidates[index+1]:
                    index += 1
                dfs(index+1) # inclusion branch

        dfs(0)
        return res
