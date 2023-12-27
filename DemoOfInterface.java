import java.util.*;
// interface Client {
//     abstract public void input(); 
//     abstract public void output(); 
// }

// class Developer implements Client {
//     String name;
//     double sal;
    
//     public void input() {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("enter username: ");
//         name = sc.nextLine();

//         System.out.print("enter salary: ");
//         sal = sc.nextDouble();
//     }
//     public void output() {
//         System.out.println("Name = " + name + " Sal = " + sal);
//     }
// }
class A {
    void m1() {
        System.out.println("m1");
    }
    void m2() {
        System.out.println("m2");
    }
}

class B extends A {
    void m3() {
        System.out.println("m3");
    }
}
public class DemoOfInterface {
    public static void main(String[] args) {
        A obj = new B(); //this object will only able to invoke the parent class methods.
        B obj1 = new B(); //this object can invoke both parent class and child class methods.
    }
}