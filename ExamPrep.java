import java.util.*;
public class ExamPrep {
    private static int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        int fact = n * factorial(n-1);
        return fact;
    }

    static int n1 = 0, n2 = 1, n3 = 0;
    private static void fibonacci(int n) {
        if(n > 0) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
            fibonacci(n-1);
        }
    }
    
    public static int middleOfThree(int a, int b, int c)
    {
        // Checking for b
        if ((a < b && b < c) || (c < b && b < a))
            return b;
 
        // Checking for a
        else if ((b < a && a < c) || (c < a && a < b))
        return a;
 
        else
        return c;
    }
    static int first = -1, last = -1; 
    private static void findOcc(String str, int index, char e) {
        if(index == str.length()) {
            System.out.println("first occurance of " + e + " : " + first);
            System.out.println("last occurance of " + e + " : " + last);
            return;
        }
        char currChar = str.charAt(index);
        if(currChar == e) {
            if(first == -1) {
                first = index;
            } else {
                last = index;
            }
        }
        findOcc(str, index+1, e);
    }

    private static void towerOfHanoi(int n, String source, String helper, String destination) {
        if(n == 1) {
            System.out.println("Transfer disk " + n + " from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n-1, source, destination, helper);
        System.out.println("Transfer disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n-1, helper, source, destination);
    }

    // Indirect recursion to find factorial of a number.
    // func1() -> func2() -> func1()
    private static int func1(int n) {
        if(n <= 1) {
            return 1;
        } 
        return n * func2(n-1);
    }

    private static int func2(int n) {
        if(n <= 1) {
            return 1;
        }
        return n * func1(n-1);
    }

    private static void print(int n) {
        if(n < 1) {
            return;
        }
        print(n-1);   // Non-tail recursion
        System.out.print(n + " ");
    }

    private static void print2(int n) {
        if(n < 1) {
            return;
        }
        System.out.print(n + " ");
        print2(n-1);      // Tail recursion
    }

    private static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int insertInArray(int arr[], int size, int capacity, int index, int element) {
        if(size >= capacity) {
            return -1;
        } else {
          for(int i=size-1; i>=index; i--) {
            arr[i+1] = arr[i];
          }  
          arr[index] = element;
          return 1;
        }
    }

    private static void deleteInArray(int arr[], int size, int index) {   //delete element from ith index
        for(int i=index; i<size; i++) {
            arr[i] = arr[i+1];
        }
    }

    private static void sparseMatrix(int arr[][], int m, int n) {  //column major form
        int nonZero = 0, zero = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 0) {
                    zero++;
                } else {
                    nonZero++;
                }
            }
        }
        if(nonZero > zero) {
            System.out.println("not a sparse matrix");
        } else {
            int sparse[][] = new int[nonZero][3];
            int k = 0;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][j] != 0) {
                        sparse[k][0] = i;
                        sparse[k][1] = j;
                        sparse[k][2] = arr[i][j];
                        k++;
                    }
                }
            }
            for(int i=0; i<nonZero; i++) {
                    for(int j=0; j<3; j++) {
                        System.out.print(sparse[i][j] + " ");
                    }
                    System.out.println();
                }
        }
    }

    private static void sparseMatrixRowMajor(int arr[][], int m, int n) {
         int nonZero = 0, zero = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 0) {
                    zero++;
                } else {
                    nonZero++;
                }
            }
        }
        if(nonZero > zero) {
            System.out.println("not a sparse matrix");
        } else {
            int sparse[][] = new int[3][nonZero];
            int k = 0;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][j] != 0) {
                        sparse[0][k] = i;
                        sparse[1][k] = j;
                        sparse[2][k] = arr[i][j];
                        k++;
                    }
                }
            }
            for(int i=0; i<3; i++) {
                for(int j=0; j<nonZero; j++) {
                    System.out.print(sparse[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void moveAllN(int arr[], int n) {
        int result[] = new int[arr.length];
        int k = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == n) {
                result[k++] = arr[i];
            }
        }
         for(int i=0; i<arr.length; i++) {
            if(arr[i] != n) {
                result[k++] = arr[i];
            }
        }

        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static void bubbleSortPrint(int a[]) {
    int count = 0;
    for(int i=0; i<a.length-1; i++) {
        for(int j=i+1; j<a.length; j++) {
            if(a[i] > a[j]) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                count++;
                for(int k=0; k<a.length; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println();
            }
        }
    }
    System.out.println("number of swaps are: " + count);
    }
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        bubbleSortPrint(arr);
        
    }
}