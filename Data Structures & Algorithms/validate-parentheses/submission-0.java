class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);

            if((!stack.isEmpty()) && ((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '['))){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
