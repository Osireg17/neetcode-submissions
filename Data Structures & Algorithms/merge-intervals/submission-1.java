class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        [[1, 3], [1, 5], [6, 7]]
        
        prev interval = Math.min()
        curr interval = Math.max()


        - loop through intervals from index 1
            - prev interval startTime 
            - prev interval endTime

            current[0] = Math.min(currentStartTime, prevIntervalStartTime)
            current[1] = Math.max(currentEndTime, prevIntervalEndTime)
        
        return intervals
        */

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> resList = new ArrayList<>();

        resList.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            int[] firstInterval = resList.getLast();
            int prevStartTime = firstInterval[0];
            int prevEndTime = firstInterval[1];

            int currentStartTime = intervals[i][0];
            int currentEndTime = intervals[i][1];

            if (currentStartTime <= prevEndTime) {
                firstInterval[0] = Math.min(currentStartTime, prevStartTime);
                firstInterval[1] = Math.max(currentEndTime, prevEndTime);

            } else {
                resList.add(new int[]{currentStartTime, currentEndTime});
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }
}
