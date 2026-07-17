class Solution:
    def isValid(self, s: str) -> bool:
        brackets = {"}":"{","]":"[",")":"("}
        stack = []

        for i in s:
            if i in brackets:
                if stack and stack[-1] == brackets[i]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(i)

        if not stack:
            return True
        else:
            return False