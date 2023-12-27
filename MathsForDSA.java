import java.util.*;
class MathsForDSA {
    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        System.out.println(greatestCommonFactor(24, 89));
    }

    static boolean isPrime(int n) {
        if(n<=1) {
            return false;
        }

        for(int i=2; i<n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    static int greatestCommonFactor(int a, int b) {
        if(a == 0) {
            return b;
        }
        if(b == 0) {
            return a;
        }
        while(a != b) {
            if(a>b) {
                a = a-b;
            }
            else {
                b = b-a;
            }
        }
        return a;
    }

    static int countPrime(int n) {
        // Sieve Entratosthenes
        boolean ans[] = new boolean[n+1];
        int count = 0;

        Arrays.fill(ans, true);
        ans[0] = false;
        ans[1] = false;

        for(int i=2; i<n; i++) {
            if(ans[i]) {
                count++; 
            }
            for(int j=2*i; j<n; j++) {
                ans[j] = false;
            }
        }
        return count;
    }
}