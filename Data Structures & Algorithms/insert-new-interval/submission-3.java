class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> result = new ArrayList<>();
        int index = 0;


        // we loop through the intervals index adding intervals that are smaller, to determine they are smaller we compare the first values
        while(index < n && intervals[index][1] < newInterval[0]){
            result.add(intervals[index]);
            index++;
        }

        // we loop through the intervals index merging the values checking if the first value of the current index is smaller than the last value of the new interval
        while(index < n && intervals[index][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }
        
        // once we have merged we just add thew new interval
        result.add(newInterval);

        // we just keep going unttil we reach the end
        while(index < n){
            result.add(intervals[index]);
            index++;
        }

        // I need to remember this that we use .toArray and create a new int[size of array]
        return result.toArray(new int[result.size()][]);
    }
}
