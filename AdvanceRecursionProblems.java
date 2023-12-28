import java.util.*;
import java.util.ArrayList;
public class AdvanceRecursionProblems {
    public static void printPermutation(String str, String permutation) {
        if(str.isEmpty()) {
            System.out.println(permutation);
            return;
        }
        for(int i=0; i<str.length(); i++) {
            char currChar = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i+1);
            printPermutation(newString, permutation + currChar); 
        }
    }

    public static int countPath(int i, int j, int n, int m) {
        if(i == n || j == m) {
            return 0;
        }
        if(i == n-1 && j == m-1) {
            return 1;
        }
        // move downwards
        int downPaths = countPath(i+1, j, n, m);
        // move right
        int rightPaths = countPath(i, j+1, n, m);
        return downPaths + rightPaths;
    }

    public static int placeTiles(int n, int m) {
        if(n == m) {
            return 2;
        }
        if(n < m) {
            return 1;
        }
        //vertically
        int verticalPlacement = placeTiles(n-m, m);
        //horizontally
        int horizontalPlacement = placeTiles(n-1, m);

        return verticalPlacement + horizontalPlacement;
    }

    public static int callGuest(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int singleCount = callGuest(n-1);
        int pairCount = (n-1) * callGuest(n-2);
        return singleCount + pairCount;
    }

    public static void printSubsets(int n, ArrayList<Integer> subset) {
        if(n == 0) {
            for(int i=0; i<subset.size(); i++) {
                System.out.print(subset.get(i) + " ");
            }
            System.out.println();
            return;
        }
        //coming in the subset
        // subset.add(n);
        printSubsets(n-1, subset);
        //not coming in the subset
        subset.remove(subset.size()-1);
        printSubsets(n-1, subset);
    }
    public static void main(String[] args) {
        ArrayList<Integer> subset = new ArrayList<>();
        printSubsets(3, subset);
    }
}