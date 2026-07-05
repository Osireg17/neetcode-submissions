from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hashmap = defaultdict(list)
        for word in strs:
            if tuple(sorted(word)) not in hashmap:
                hashmap[tuple(sorted(word))].append(word)
            else:
                hashmap[tuple(sorted(word))].append(word)

        result = []

        for key, value in hashmap.items():
            result.append(value)

        return result