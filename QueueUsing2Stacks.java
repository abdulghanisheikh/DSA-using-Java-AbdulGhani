import java.util.Stack;
public class QueueUsing2Stacks 
{
    static class Queue 
    {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() 
        {
            return s2.isEmpty();
        }

        public static void enQueue(int data) 
        {
            s1.push(data);
        }

        public static int deQueue() 
        {
            if(s1.isEmpty()) 
            {
                System.out.println("queue is empty");
                return -1;
            }
            if(s2.isEmpty()) 
            {
                while(!s1.isEmpty()) 
                {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
    }
    public static void main(String[] args) 
    {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());  // O(n)
        System.out.println(q.deQueue());  // O(1)
        System.out.println(q.deQueue());  // O(1)
    }
}