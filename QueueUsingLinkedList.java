import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingLinkedList 
{
    static class Node {
        int data;
        Node next;
        
        Node(int data) 
        {
            this.data = data;
            this.next = null;
        }
    }

    static class queue 
    {
        static Node head = null;
        static Node tail = null;
        static int size = 0;

        public static boolean isEmpty()
        {
            return head == null && tail == null;
        }

        public static void enQueue(int data)  // O(1) 
        {
            Node newNode = new Node(data);
            if(head == null) 
            {
                head = tail = newNode;
            }
            else
            {
            tail.next = newNode;
            tail = newNode;
            }
            size++;
        }

        public static int deQueue()  // O(1)
        {
            if(isEmpty()) 
            {
                System.out.println("queue is empty");
                return -1;
            } 
            int remove = head.data;
            if(head == tail)
            {
                head = tail = null;
            } else 
            {
                head = head.next;
            }
            size--;
            return remove;
        }

        public static int frontElement() 
        {
            if(isEmpty()) 
            {
                System.out.println("queue is empty");
                return -1;
            }
            return head.data;
        }

        public static void displayqueue() 
        {
            while(!isEmpty()) 
            {
                System.out.println(frontElement());
                dequeue();
            }
        }
    }
    public static void main(String[] args) 
    {
        
    }    
}