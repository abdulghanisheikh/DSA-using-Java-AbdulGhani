import java.util.*;
public class DequeMain {
    static class StackUsingDeque {
        Deque<Integer> deque = new LinkedList<>();
        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }
    static class QueueUsingDeque {
        Deque<Integer> deque = new LinkedList<>();
        public void add(int data) {
            deque.addLast(data);
        }

        public int remove() {
            return deque.removeFirst();
        }

        public int peek() {
            return deque.peekFirst();
        }
    }
    public static void main(String[] args) {
        QueueUsingDeque queue = new QueueUsingDeque();
    }
}