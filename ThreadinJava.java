import java.util.*;
/* 
Thread -> Thread allows the program to operate efficiently by doing multiple task at the same time.
       -> we can create thread in two ways:
          1) by extending the Thread class.
          2) by implementing the Runnable interface.
       -> if there is an exception in one thread it do not effect the execution of the other threads despite them sharing the same memory.  
*/
class Bus implements Runnable {
    int available = 1, passenger;
    Bus(int passenger) {
        this.passenger = passenger;
    }
    public synchronized void run() {
        if(available >= passenger) {
            System.out.println(Thread.currentThread().getName() + " reserved seat");
            available = available - passenger;
        }
        else {
            System.out.println("no seat available");
        }
    }
}
public class ThreadinJava {
    public static void main(String[] args) {
        Bus bus = new Bus(1);
        
        Thread t1 = new Thread(bus);
        Thread t2 = new Thread(bus);
        Thread t3 = new Thread(bus);

        t1.setName("shyam");
        t2.setName("varun");
        t3.setName("amit");

        t1.start();
        t2.start();
        t3.start();
    }
}