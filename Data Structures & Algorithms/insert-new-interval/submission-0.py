class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        # if interval[i-1][1] < newInterval[0] and interval[i+1][0] > newInterval[1]:
            # cannot merge them as they aren't overlapping
        # if not the case then they are overlapping
            # res = [interval[i-1][0], interval[i+1][1]]

        res = []
        n = len(intervals)
        i = 0

        while i < n and intervals[i][1] < newInterval[0]:
            res.append(intervals[i])
            i += 1

        while i < n and newInterval[1] >= intervals[i][0]:
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i += 1
        res.append(newInterval)

        while i < n:
            res.append(intervals[i])
            i += 1

        return res