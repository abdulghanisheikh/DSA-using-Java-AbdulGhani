import java.util.*;
public class Dequeue
{
    public static void main(String[] args)
    {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(2);
        dq.addLast(3);
        dq.addFirst(1);

        int first = dq.peekFirst();
        int last = dq.peekLast();

        System.out.println("first: " + first + " last: " + last);
    }
}