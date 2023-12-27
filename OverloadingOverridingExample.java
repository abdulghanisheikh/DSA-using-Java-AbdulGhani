import java.util.*;

class Parent {
    private int value;
    Parent() {
        System.out.println("parent default constructor");
    }
    Parent(int value) {
        this.value = value;
        System.out.println("parent parameterized constructor " + value);
    }
    public void display() {
        System.out.println("parent method");
    } 
}
class Child extends Parent {
    Child() {
        System.out.println("child default constructor");
    }
    Child(int val) {
        super(val);
        System.out.println("child parameterized constructor " + val);
    }
    public void display() {
        System.out.println("child method");
    }
}
public class OverloadingOverridingExample {
    public static void main(String[] args) {
        Parent obj = new Parent(10);
        obj.display();
    }
}