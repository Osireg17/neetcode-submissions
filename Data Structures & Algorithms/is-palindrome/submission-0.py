import re
class Solution:
    def isPalindrome(self, s: str) -> bool:
        str1 = re.sub(r'\W+', '', s).lower()
        
        return str1 == str1[::-1]

        