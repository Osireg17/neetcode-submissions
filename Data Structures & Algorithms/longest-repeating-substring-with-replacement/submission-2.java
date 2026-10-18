class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int longest = 0;
        Map<Character, Integer> seenFrequency = new HashMap<>();

        while (right < s.length()) {
            int window = right - left + 1;
            seenFrequency.put(s.charAt(right), seenFrequency.getOrDefault(s.charAt(right), 0) + 1);
            int maxFrequency = Collections.max(seenFrequency.values());
            int flips = window - maxFrequency;

            if (flips > k) {
                seenFrequency.put(s.charAt(left), seenFrequency.get(s.charAt(left)) - 1);
                left++;
            }

            longest = Math.max(longest, right - left + 1);
            right++;
        }

        return longest;
    }
}
