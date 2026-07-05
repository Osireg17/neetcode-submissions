class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def recursive(current_string, opened, closed):
            if opened == 0 and closed == 0:
                res.append(current_string)
                return

            if opened > 0:
                recursive(current_string + "(", opened-1, closed)
            if closed > opened:
                recursive(current_string + ")", opened, closed-1)
        recursive("", n, n)

        return res
    
    