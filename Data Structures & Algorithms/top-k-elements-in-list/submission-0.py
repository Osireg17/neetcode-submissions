from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequency_map = Counter(nums)
        freq_tuple = frequency_map.most_common(k)
        most_common = []
        for key, value in enumerate(freq_tuple):
            most_common.append(value[0])

        

        return most_common