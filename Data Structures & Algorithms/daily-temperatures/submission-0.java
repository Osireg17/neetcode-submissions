class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // [30, 38, 30, 36, 35, 40, 28]

        ArrayList<int[]> stack = new ArrayList<>();
        int[] res = new int[temperatures.length];
        for (int index = 0; index < temperatures.length; index++){
            while(!stack.isEmpty() && stack.getLast()[0] < temperatures[index]){
                int[] lastTemp = stack.removeLast();
                res[lastTemp[1]] = index - lastTemp[1];
            }
            stack.add(new int[]{temperatures[index], index});
        }

        return res;
    }
}
