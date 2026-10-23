class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = 0;
        int hare = 0;

        do{
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(tortoise != hare);

        tortoise = 0;
        while(true){
            tortoise = nums[tortoise];
            hare = nums[hare];

            if(hare == tortoise){
                return tortoise;
            }
        }
        
    }
}
