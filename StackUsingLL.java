public class StackUsingLL {
    Node head;
    int size;
    public StackUsingLL() {
        head = null;
        size = 0;
    }
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
    private void push(int data) {
        // add first
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    private int pop() {
        int top = head.data;
        head = head.next;
        return top;
    }
    private int peek() {
        int top = head.data;
        return top;
    }
    private boolean isEmpty() {
        return head == null;
    }
    public static void main(String[] args) {
        StackUsingLL stack = new StackUsingLL();
        stack.push(1);
        stack.push(3);
        stack.push(6);
        stack.push(2);
        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}