class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefix = [0] * n
        suffix = [0] * n


        # this is needed because 0 x 0 will just give an prefixes of 0
        prefix[0] = 1
        suffix[-1] = 1
        
        # Need this or else where we gonna store our products
        res = [0] * n

        for i in range(1, n):
            # we need to do i - 1 because we need to find the product of everything except self so need to do
            prefix[i] = prefix[i-1] * nums[i-1]

        for i in range(n - 2, -1, -1):
            suffix[i] = suffix[i + 1] * nums[i+1]
        

        for i in range(n):
            res[i] = suffix[i] * prefix[i]


        print(res)

        return res