import java.util.Stack;

/**
 * Created by mming on 12/23/17.
 */
public class MaxStack {
    private Stack<Integer> max;
    private Stack<Integer> stack;
    public MaxStack(){
        max = new Stack<>();
        stack = new Stack<>();
    }
    void push(int x){
        stack.push(x);
        x = x > max.peek() ? x : max.peek();
        max.push(x);
    }
    int pop(){
        max.pop();
        return stack.pop();
    }
    int top(){
        return stack.peek();
    }
    int peekMax(){
        return max.peek();
    }
    int popMax(){
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty() && stack.peek() < max.peek()){
            temp.push(stack.pop());
            max.pop();
        }
        int maxNum = stack.pop();
        max.pop();
        while(!temp.isEmpty()){
            push(temp.pop());
        }
        return maxNum;
    }
}
