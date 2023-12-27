import java.util.*;
public class LL {
    Node head, tail;
    int size;
    public LL() {
        head = tail = null;
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
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
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
        }
    }

    public void printList() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }
        else {
            Node currNode = head;
            while(currNode != null) {
                System.out.print(currNode.data + " -> ");
                currNode = currNode.next;
            }
            System.out.println("null");
        }
    }

    public int getSize() {
        return size;
    }

    public Node reverseIterate(Node head) {
        if(head == null && head.next == null) {
            return head;
        }

        Node prev = head;
        Node curr = prev.next;
        while(curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }
        head.next = null;
        head = prev;

        return head;
    } 

    public Node reverseRecursive(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public boolean isLoop(Node head, HashSet<Node> set) {
        for(Node current = head; current != null; current = current.next) {
            if(set.contains(current)) {
                return true;
            }
            else {
                set.add(current);
            }
        }
        return false;
    }

    public boolean isCycle(Node head) {
        Node slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public void findMiddle(Node head) {
        if(head == null) {
            return;
        }
        int count = 0;
        Node curr;
        for(curr = head; curr != null; curr = curr.next) {
            count++;
        }
        curr = head;
        for(int i=0; i<count/2; i++) {
            curr = curr.next;
        }
        System.out.println(curr.data);
    }

    public Node findMiddle2(Node head) {
        if(head == null) {
            return null;
        }
        Node fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public boolean isPalindrome(Node head) {
        if(head.next == null) {
            return true;
        }

        Node mid = findMiddle2(head);
        Node first = head;
        Node second = reverseIterate(mid.next);

        while(second != null) {
            if(second.data != first.data) {
                return false;
            }
            else {
                first = first.next;
                second = second.next;
            }
        }
        return true;
    }

    public void removeNode(Node node) {
        if(node != null && node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }

    public void removeLast() {
        if(head == null) {
            return;
        }
        else {
            Node currNode = head;
            while(currNode.next != tail) {
                currNode = currNode.next;
            }
            currNode.next = null;
            tail = currNode;
        }
    }

    public Node removeMiddle() {
        if(head == null || head.next == null) {
            return head;
        }
        Node first = head, slow = head, prev = null;
        while(first != null && first.next != null) {
            prev = slow;
            first = first.next.next;
            slow = slow.next; 
        }
        prev.next = prev.next.next;
        return head;
    }

    public Node removeNthFromLast(Node head, int k) {
        int size = getSize();
        if(k > size || k == 0) {
            System.out.println("invalid input");
            return null;
        }
        if(k == size) {
            head = head.next;
            return head;
        }
        int indexFromStart = size - k;
        Node prev = head;
        int i = 1;
        while(i != indexFromStart) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }

    public void findNthFromLast(Node head, int k) {
        int size = getSize();
        if(k == size) {
            System.out.println(head.data);
            return;
        }
        if(k > size || k == 0) {
            System.out.println("invalid input");
            return;
        }
        int indexFromStart = size - k + 1;
        Node currNode = head;
        int i = 1;
        while(i != indexFromStart) {
            currNode = currNode.next;
            i++;
        }
        System.out.println(currNode.data);
    }

    public Node mergeTwoSortedList(Node h1, Node h2) {
        Node a = h1, b = h2;
        Node head = null, tail = null;
        if(a.data < b.data) {
            head = a;
            tail = a;
            a = a.next;
        }
        if(a.data > b.data) {
            head = b;
            tail = b;
            b = b.next;
        }
        while(a != null && b != null) {
            if(a.data < b.data) {
                tail.next = a;
                tail = a;
                a = a.next;
            }
            else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        if(a == null) {
            tail.next = b;
            tail = b;
            b = b.next;
        }
        if(b == null) {
            tail.next = a;
            tail = a;
            a = a.next;
        }
        return head;
    }

    public void removeDuplicate() {
        if(head == null) {
            System.out.println("empty list");
            return;
        }
        Node curr = head;
        while(curr != null) {
            if((curr.next != null) && curr.data == curr.next.data) {
                curr.next = curr.next.next;
                curr = curr.next;
            }
            else {
                curr = curr.next;
            }
        }
    }
public static void main(String[] args) {
    LL list = new LL();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(3);
    list.addLast(4);
    list.addLast(4);

    list.printList();
    list.removeDuplicate();
    list.printList();
   }
}