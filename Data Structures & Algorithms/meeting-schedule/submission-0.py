"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        # check if the intervals are empty
        if not intervals:
            return True
        
        # first you have to arrange it
        intervals.sort(key=lambda x: x.start)

        # I need to range(len(intervals)) not i in intervals that what was causing me issues
        # I need the actual index not the element
        for i in range(len(intervals)-1):
            curr_interval = intervals[i]
            next_interval = intervals[i+1]

            if curr_interval.end > next_interval.start:
                return False
            
        return True