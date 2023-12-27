import java.util.*;
public class QueueDS 
{
    // static class CirculerQueue
    // {
    //     static int arr[];
    //     static int size;
    //     static int rear;
    //     static int front;

    //     CirculerQueue(int size) 
    //     {
    //         arr = new int[size];
    //         this.size = size;
    //         rear = -1;
    //         front = -1;
    //     }        

    //     public static boolean isEmpty()
    //     {
    //         return front == -1 && rear == -1;
    //     }

    //     public static boolean isFull() 
    //     {
    //         return (rear+1) % size == front;
    //     }

    //     public static void enQueue(int data)  // O(1)
    //     {
    //         if(isFull()) 
    //         {
    //             System.out.println("queue is full");
    //             return;
    //         }
    //         if(front == -1) 
    //         {
    //             front = 0;
    //         }  
    //         rear = (rear+1) % size;
    //         arr[rear] = data;
    //         size++;
    //     }

    //     public static int deQueue()  // O(1)
    //     {
    //         if(isEmpty()) 
    //         {
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         int remove = arr[front];
    //         if(rear == front) 
    //         {
    //             front = rear = -1;
    //         } else 
    //         {
    //             front = (front+1) % size;
    //         }
    //         size--;
    //         return remove;
    //     }

    //     public static int frontElement()
    //     {
    //         if(isEmpty()) 
    //         {
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         return arr[front];
    //     }

    //     public static void displayQueue() 
    //     {
    //         while(!isEmpty()) 
    //         {
    //             System.out.println(frontElement());
    //             deQueue();
    //         }
    //     }

    //     public static int size()
    //     {
    //         return size;
    //     }
    // }

    public static void firstNonRepeating(String str) 
    {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for(int i=0; i<str.length(); i++) 
        {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1)
            {
                q.remove();
            }
            if(q.isEmpty())
            {
                System.out.print(-1 + " ");
            } else 
            {
                System.out.print(q.peek() + " ");
            }
        }
    }   

    public static void interLeave(Queue<Integer> q1)
    {
        int size = q1.size();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<size/2; i++)
        {
            q2.add(q1.remove());
        }

        while (!q2.isEmpty()) 
        {
            q1.add(q2.remove());
            q1.add(q1.remove());    
        }
    }

    public static void reverseQueue(Queue<Integer> q)  // Time Complexity  -> O(n)
    {                                                  // Space Complexity -> O(n)
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty())
        {
            s.push(q.remove());
        }
        while(!s.isEmpty())
        {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) 
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverseQueue(q);
        while(!q.isEmpty())
        {
            System.out.print(q.remove() + " ");
        }
    }
}