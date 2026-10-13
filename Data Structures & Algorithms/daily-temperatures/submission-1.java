class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        - create an array of zeros
        - create an empty Stack (value, index)
        - for loop through temperatues but from index 0
            -  while the stack is not null and the current value > last value in the Stack
                - Find the difference in the index between them
                - Assign the value to the index from the array of zeros
            add values to the stack
        - return the array
        */

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
