class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        Set<Character> seen = new HashSet<>();
        for (int right = 0; right < chars.length; right++) {
            while (seen.contains(chars[right])){
                seen.remove(chars[left]);
                left++;
            }
            seen.add(chars[right]);
            res = Math.max(res, seen.size());
        }

        return res;   
    }
}
