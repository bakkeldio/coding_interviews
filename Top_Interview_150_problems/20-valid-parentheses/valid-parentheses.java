class Solution{
HashMap<Character, Character> mapping;

    public Solution(){
        this.mapping = new HashMap<>();
        this.mapping.put(')', '(');
        this.mapping.put(']', '[');
        this.mapping.put('}', '{');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if (this.mapping.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();

                if (top != this.mapping.get(c)) {
                    return false;
                }
            }
                else {
                    stack.push(c);
                }

            }
            return stack.isEmpty();
        }
}