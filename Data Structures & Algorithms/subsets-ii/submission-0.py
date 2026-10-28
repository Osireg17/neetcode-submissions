class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        seen = set()

        def dfs(index):
            if index == len(nums):
                if tuple(sorted(subset)) not in seen:
                    res.append(subset.copy())
                    seen.add(tuple(sorted(subset)))
                return

            subset.append(nums[index])

            dfs(index + 1)
            subset.pop()
            dfs(index + 1)

        dfs(0)

        return res
