class MinStack {
    Stack<Integer> stack;
    Stack<Integer> s;
    public MinStack() {
        stack = new Stack<>();
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(val);
        }else{
            if(s.peek() >= val){
                s.push(val);
            }
        }
        stack.push(val);
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int ele = stack.pop();
            if(!s.isEmpty() && s.peek() == ele){
                s.pop();
            }   
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return s.peek();
    }
}
