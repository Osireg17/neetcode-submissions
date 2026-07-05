class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left, right = 0, 0
        sliding_window = set()
        longest = 0
        while right < len(s):
            if s[right] in sliding_window:
                sliding_window.remove(s[left])
                left += 1
            else:
                sliding_window.add(s[right])
                right += 1
                longest = max(longest, len(sliding_window))
        return longest

        