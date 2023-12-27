import java.util.Comparator;
import java.util.PriorityQueue;
public class Priorityqueue {

    static class Student implements Comparable<Student> { 
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        public int compareTo(Student s2) { //overriding compareTo() method of Comparable Interface
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Aman", 2)); //O(logn)
        pq.add(new Student("Umar", 1));
        pq.add(new Student("Abdul", 4));
        pq.add(new Student("Zaid",3));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank); //O(1)
            pq.remove(); //O(logn)
        }
    }
}