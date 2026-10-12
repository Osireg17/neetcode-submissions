class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        
        - The array starts with none overlapping intervals
        - Intervals are in ascending order
        - Overlapping intervals may be merged
        
        intervals = [[1, 3], [4, 6]]
        new interval = [2, 5]


        get the first interval
        [1, 3]

        check if the last value is greater than the new intervals first value 
        if that's the case they overlap, so take the first value from the current interval and the last value from the new interval 

        temp = [1, 5]

        get the second interval

        check if the last value in temp is greater than the first value in current 
        then we get the first value in temp and the last value in current


        res = []
        
        
        
        
        
        */

        List<int[]> res = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals that come before newInterval (no overlap)
        //    Handles the situation where res is empty automatically
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // 2. Merge all overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // 3. Add the merged newInterval
        res.add(newInterval);

        // 4. Add all remaining intervals that come after
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Convert List<int[]> back to int[][]
        return res.toArray(new int[res.size()][]);
    }
}
