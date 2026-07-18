class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # no duplicates, so we need to have a sliding window

        # if we find values that are not in the current window we add them

        # We have one set, which is for the window, two pointers which is used to add and remove values

        res = 0
        current_window = set()
        left = 0

        for right in range(len(s)):
            # If duplicate found, shrink window from left until it's gone
            while s[right] in current_window:
                current_window.remove(s[left])
                left += 1

            current_window.add(s[right])
            res = max(res, right - left + 1)


        return res