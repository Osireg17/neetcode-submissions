class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> combination = Map.of(
        '}', '{',
        ']', '[',
        ')', '('
            );

        List<Character> stack = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if (combination.containsKey(current)){
                if (!stack.isEmpty() && stack.getLast() == combination.get(current)){
                    stack.removeLast();
                } else{
                    return false;
                }
            } else{
                stack.add(current);
            }
        }
        return stack.isEmpty();
    }
}
