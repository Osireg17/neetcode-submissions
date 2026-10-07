class Solution:
    def isPalindrome(self, s: str) -> bool:
        joined_string = ''.join(char for char in s if char.isalnum()).lower()

        return list(joined_string) == list(joined_string)[::-1]