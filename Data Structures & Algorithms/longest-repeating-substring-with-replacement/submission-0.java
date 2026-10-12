class Solution {
    public int characterReplacement(String s, int k) {
        /*
        
        AAABABB, k = 2
        

        A A A B A B B
        L R
        
        - Have a sliding window with left and right
        - We keep extending the sliding window until we find a value that isn't equal the value before
        - A A A B
          L     R
        - if we find a value that's not the same as the one before we switch it to the one before and then do K-1
        - We'd need a variable to keep track of the longest length we've seen to date
        
        */
        int left = 0;
        int right = 0;
        int longest = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> seen_frequency = new HashMap<>();

        while(right < s.length()){
            int windowLength = right - left + 1;
            seen_frequency.put(s.charAt(right), seen_frequency.getOrDefault(s.charAt(right), 0) + 1);

            maxFreq = Math.max(maxFreq, seen_frequency.get(s.charAt(right)));

            int flips = windowLength - maxFreq;


            if (flips > k){
                seen_frequency.put(s.charAt(left), seen_frequency.get(s.charAt(left)) - 1);
                left ++;
            }


            // We should use the new window not the old window for the longest value, hmm
            longest = Math.max(longest, right - left + 1);
            
            right ++;
        }

        return longest;


        
    }
}
