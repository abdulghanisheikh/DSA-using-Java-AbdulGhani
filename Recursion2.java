import java.util.Scanner;
public class Recursion2 {
    static void reachHome(int src, int dest) {
        System.out.println("Source " + src + " Destination " + dest);
        // Base Case
        if(src == dest) {
           System.out.println("Reached!");
           return;
        }
        // Recursive Relation
        reachHome(src+1, dest);
    }
    static int fibonacciNo(int n) {
        // Base Case
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        // Recursive Relation
        int ans = fibonacciNo(n-1) + fibonacciNo(n-2);
        return ans;
    }
    static void printFibonacci(int n) {
        long first = 0;
        long second = 1;
        long next;
        System.out.print(first + " ");
        System.out.print(second + " ");
        for(int i=1; i<=n-2; i++) {
            next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
    }
    static long nStairs(int n) {
        // base case
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        // recursive relation
        long ans = nStairs(n-1) + nStairs(n-2);
        return ans;
    }
    static void sayDigits(int n, String []a) {
        // base case
        if(n == 0) {
            return;
        }
        // processing
        int digit = n % 10;
        n = n / 10;
        // recursive relation
        sayDigits(n, a);
        System.out.print(a[digit] + " ");
    }
    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        String arr[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        int num = f.nextInt();
        sayDigits(num, arr);
        
    }
}
