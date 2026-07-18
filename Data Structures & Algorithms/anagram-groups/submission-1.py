class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = defaultdict(list)
        # {sorted_word: word}

        # loop through strs
        for i in strs:
            sorted_sring = ''.join(sorted(i))
        # if the sorted current value is a value in the map we add it to the list
            result[sorted_sring].append(i) 
            # no need for a check for when we don't have the value as the defaultdict does that already

        res = []

        for key, value in result.items():
            res.append(value)

        return res