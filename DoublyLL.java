public class DoublyLL {
    Node head;
    Node tail;
    int size;

    public DoublyLL() {
        head = tail = null; size = 0;
    }

    public int getSize() {
        return size;
    }

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        } 
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }

        else {
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }

        else {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        }
        size++;
    }

    public void printList() {
        if(head == null) {
            System.out.println("empty list");
        }

        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    public void removeNode(Node node) {
        if(node != null || node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
            node.next.next.prev = node;
        }
        size--;
    }

    public void reverseDoubly() {
        if(head == null) {
            System.out.println("empty list");
            return;
        }
        Node curr = head;
        Node lastNode = null;
        while(curr != null) {
            lastNode = curr;
            curr = curr.next;
        }

        while(lastNode != null) {
            System.out.print(lastNode.data + " -> ");
            lastNode = lastNode.prev;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.printList();
        System.out.println(list.getSize());
    }
}