public class StackUsingArray {
    private int top;
    private int size;
    private int stack[];
    public StackUsingArray(int size) {
        this.size = size;
        int stack[] = new int[size];
        top = -1;
    }
    private void push(int data) {
        if(top == size-1) {
            System.out.println("overflow");
            return;
        }
        top++;
        stack[top] = data;
    }
    private int pop() {
        if(isEmpty()) {
            System.out.println("underflow");
            return -1;
        } else {
            int val = stack[top];
            top--;
            return val;
        }
    }
    private int peek() {
        if(isEmpty()) {
            System.out.println("underflow");
            return -1;
        } else {
            return stack[top];
        }
    }
    private boolean isEmpty() {
        return top == -1;
    }
    public static void main(String[] args) {
        StackUsingArray st = new StackUsingArray();
        System.out.println(st.pop());
    }
}
