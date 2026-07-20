class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums)-1

        # in rotated arrays, min elements will be the first element of the rotated part

        while low < high:
            mid = low + (high - low) // 2

            if nums[mid] < nums[high]:
                high = mid
            else:
                low = mid + 1

        return nums[low]
