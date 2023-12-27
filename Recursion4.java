import java.util.function.IntPredicate;
public class Recursion4 {
    public static void reverseStr(String str, int index) {
        if(index == 0) {
            System.out.println(str.charAt(index));
            return;
        }
        System.out.print(str.charAt(index));
        reverseStr(str, index-1);
    }

    static boolean checkPalindrome(String s, int i) {
        // base case
        if (i > s.length() - i - 1) {
            return true;
        }
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }

        else {
            return checkPalindrome(s, i + 1);
        }
    }

    static boolean isPalindrome(String s, int i, int j) {
        // base case
        if (i > j) {
            return true;
        }
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        } else {
            return isPalindrome(s, i + 1, j - 1);
        }
    }

    static int power(int a, int b) {
        // base case
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        // when b is even
        if (b % 2 == 0) {
            return power(a, b / 2) * power(a, b / 2);
        }
        // when b is odd
        else {
            return a * power(a, b / 2) * power(a, b / 2);
        }
    }

    static void bubbleSort(int a[], int size) {
        // base case
        if (size == 1 || size == 0) {
            return;
        }
        // one case solved
        for (int i = 0; i < size - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                i++;
            }
        }
        // recursive call
        bubbleSort(a, size - 1);
    }

    static void selectionSort(int arr[], int index, int size) {
        // base case
        if (index >= size - 1) {
            return;
        }
        int smallest = index;
        for (int i = index; i < size; i++) {
            if (arr[i] < arr[smallest]) {
                smallest = i;
            }
        }
        int temp = arr[smallest];
        arr[smallest] = arr[index];
        arr[index] = temp;

        // recursive call
        selectionSort(arr, index + 1, size);
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        String str = "my name is xyz";
        reverseStr(str, str.length()-1);
    }
}
