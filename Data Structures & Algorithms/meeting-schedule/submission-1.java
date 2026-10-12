/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        /*
        - Meetings are provided in anyorder
        - Find whether someone can attend all ther=ir meetings

        Example

        [(0,30),(5,10),(15,20)]

        - First thought is to sort the array by start time
        - If you there is one conflict you fail right away

        - Pseudocode

        1. Sort the array by start time
        2. Loop through the array from index 1 not index 0
            - check if index 0 last value is greater than index 1 first value
            - if no return false

            - if yes return true, however we'd only do this once we've gone through every meeting
        
        */

        intervals.sort(Comparator.comparingInt(s -> s.start));

        for(int index = 1; index < intervals.size(); index ++){
            Interval currentInterval = intervals.get(index);
            Interval previousInterval = intervals.get(index-1);

            if(previousInterval.end > currentInterval.start){
                return false;
            }
        }

        return true;
    }
}
