class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        path = []
        visited = set()

        def dfs(index):
            if index == len(nums):
                result.append(path.copy())
                return

            for i in range(len(nums)):
                if nums[i] in visited:
                    continue
                visited.add(nums[i])
                path.append(nums[i])
                dfs(index+1)
                path.pop()
                visited.remove(nums[i])


        dfs(0)
        return result