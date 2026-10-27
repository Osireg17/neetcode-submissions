class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def backTrack(currentIndex, path):
            if currentIndex == len(nums):
                result.append(path[:])
                return

            path.append(nums[currentIndex])
            backTrack(currentIndex+1, path)
            path.pop()
            backTrack(currentIndex+1, path)

        backTrack(0, [])

        return result