from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        seen_map = defaultdict(list)
        for string in strs:
            sorted_string = ''.join(sorted(string))
            if sorted_string in seen_map:
                seen_map[sorted_string].append(string)
            else:
                seen_map[sorted_string].append(string)

        res = []
        for key, value in seen_map.items():
            res.append(value)

        return res