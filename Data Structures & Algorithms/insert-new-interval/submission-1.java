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

        ArrayList<int[]> resList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                // if the current intervals last value is smaller than the new interval first value
                resList.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                //if the current intervals first value is larger than the new intervals last value
                resList.add(newInterval);
                newInterval = intervals[i];
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        resList.add(newInterval);
        return resList.toArray(new int[0][]);
    }
}
