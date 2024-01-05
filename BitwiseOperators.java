import java.util.Scanner;
public class BitwiseOperators {
    // Bitwise operators = Bitwise operators works on Indivisual bits.
    // for example OR, AND, XOR, NOT etc
    // Bits        OR    AND   XOR    Bits   NOT
    // 0 0         0      0     0      0      1
    // 0 1         1      0     1      1      0
    // 1 0         1      0     1
    // 1 1         1      1     0

    // OR = |
    // AND = &
    // XOR = ^
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter value of a ");
        int a = sc.nextInt();
        System.out.print("enter value of b ");
        int b = sc.nextInt();
        System.out.println(a + " | " + b + " = " + (a|b));
        System.out.println(a + " & " + b + " = "  + (a&b));
        System.out.println(a + " ^ " + b + " = " + (a^b));
    }
}