import java.util.Scanner;
class Student {
    private int rollNumber;
    private String name;
    Student() {}
    public void setData() {
        Scanner obj = new Scanner(System.in);
        System.out.println();
    }
    public void getData() {
        System.out.println("Name : " + name + "\nRoll no. : " + rollNumber);
    }
}

public class MyClass {
    public static void main(String[] args) {
    Student s1 = new Student();
    s1.getData();

}
}