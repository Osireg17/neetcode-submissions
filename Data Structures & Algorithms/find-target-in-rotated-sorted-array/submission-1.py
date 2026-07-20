class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid

                # this comparison suggests that from mid to low we are storted
            if nums[low] <= nums[mid]:
                # check if the target is between low and mid
                if target > nums[mid] or target < nums[low]:
                    low = mid + 1
                else:
                    high = mid - 1
            # the opposite suggests mid to high are storted
            else:
                # check if the target is between mid and high
                if target < nums[mid] or target > nums[high]:
                    high = mid - 1
                else:
                    low = mid + 1

        return -1

            