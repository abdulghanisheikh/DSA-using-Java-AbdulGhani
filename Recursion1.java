import java.util.*;
public class Recursion1 {
    static int findFactorial(int n) {
        // Base Case
        if(n == 0) {
            return 1;
        }
        // Recursive Relation
        return n * findFactorial(n-1);
    }
    
    static int twoExpo(int n) {
        // Base Case
        if(n == 0) {
            return 1;
        }
        // Recursive Relation
        return 2 * twoExpo(n-1);
    }
    
    static void printCounting(int n) {
        // Base Case
        if(n == 0) {
            return;
        }
        printCounting(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        // printCounting(10);
        System.out.println(findFactorial(5));
        
    }
}

