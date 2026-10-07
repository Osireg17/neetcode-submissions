from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        seen_map = defaultdict(list)
        for string in strs:
            sorted_string = ''.join(sorted(string))
            seen_map[sorted_string].append(string)
        return list(seen_map.values())