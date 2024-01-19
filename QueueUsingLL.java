public class QueueUsingLL {
    private Node front;
    private Node rear;
    public QueueUsingLL() {
        front = null;
        rear = null;
    }
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private boolean isEmpty() {
        return front == null;
    }
    private void enQueue(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    private int deQueue() {
        if(isEmpty()) {
            System.out.println("underflow");
            return -1;
        } else {
            int val = front.data;
            front = front.next;
            return val;
        }
    }
    private int peek() {
        if(isEmpty()) {
            System.out.println("underflow");
            return -1;
        } else {
            return front.data;
        }
    }
    public static void main(String[] args) {
        QueueUsingLL q = new QueueUsingLL();
        System.out.println(q.deQueue());
    }
}
