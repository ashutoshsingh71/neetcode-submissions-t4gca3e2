class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();

        for(String s : tokens){
            if(s.equals("+")){
                numStack.push(numStack.pop() + numStack.pop());
            }else if(s.equals("-")){
                int a = numStack.pop();
                int b = numStack.pop();
                numStack.push(b-a);
            }else if(s.equals("*")){
                numStack.push(numStack.pop() * numStack.pop());
            }else if(s.equals("/")){
                int a = numStack.pop();
                int b = numStack.pop();
                numStack.push(b/a);
            }else{
                numStack.push(Integer.valueOf(s));
            }
        }
        return numStack.pop();
    }
}
