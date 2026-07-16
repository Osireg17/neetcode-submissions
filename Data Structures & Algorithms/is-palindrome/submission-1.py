class Solution:
    def isPalindrome(self, s: str) -> bool:
        s1 = re.sub(r'[^a-zA-Z0-9]', '', s)

        print(s1.lower())

        print(list(s1.lower()))

        print(list(s1.lower())[::-1])

        return list(s1.lower())[::-1] == list(s1.lower())