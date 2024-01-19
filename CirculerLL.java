public class CirculerLL {
    Node head;
    Node tail;
    int size;

    public CirculerLL() {
        head = null;
        tail = null;
        size = 0;
    }
    
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public void printList() {
        if(head == null) {
            System.out.println("empty list");
        }
        else {
            Node curr = head;
            do {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            } while(curr != head);
            System.out.println("head");
        }
        size++;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public void removeNode(int val) {
        Node curr = head;
        if(curr == null) {
            System.out.println("empty list");
            return;
        }
        if(curr.data == val) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node nextNode = curr.next;
            if(nextNode.data == val) {
                curr.next = nextNode.next;
                break;
            }
            else {
                curr = curr.next;
            }
        } while(curr != head);
    }
public static void main(String[] args) {
    CirculerLL list = new CirculerLL();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.printList();
    }
}