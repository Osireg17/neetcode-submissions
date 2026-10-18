class Solution {

    public record DistanceIndex(double distance, int index){}

    public int[][] kClosest(int[][] points, int k) {
        int x1 = 0;
        int y1 = 0;
        List<DistanceIndex> distanceIndexes = new ArrayList<>();
        List<int[]> result = new ArrayList<>();

        for(int index = 0; index < points.length; index++){
            int x2 = points[index][0];
            int y2 = points[index][1];

            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            distanceIndexes.add(new DistanceIndex(distance, index));
        }

        distanceIndexes.sort(Comparator.comparingDouble(DistanceIndex::distance));

        // [[2.82842, 0],[distance, 1], ...]
        for (int i = 0; i < k; i++) {
            int index = distanceIndexes.get(i).index();
            result.add(points[index]);
        }

        return result.toArray(new int[0][]);
        
    }
}
