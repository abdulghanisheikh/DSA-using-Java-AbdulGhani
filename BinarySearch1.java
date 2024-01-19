public class BinarySearch1 {
    // Binary Search is applicable on sorted array (ascending/descending order).
    // time complexity = O(logn)
    private static int binarySearchIterative(int a[], int k) { // O(logn)
        int n = a.length;
        int low = 0;
        int high = n-1;
        while(low < high) {
            int mid = low + (high-low)/2;
            if(a[mid] == k) {
                return mid;
            }
            else if(a[mid] < k) {
                low = mid+1; // search in the right half
            } else {
                high = mid-1; // search in the left half
            }
        }
        return -1; 
    }

    private static int binarySearchRecursive(int a[], int low, int high, int k) {
        if(low > high) {
            return -1;
        }
        int mid = low + (high-low)/2;
        if(a[mid] == k) {
            return mid;
        } else if (a[mid] < k) {
            return binarySearchRecursive(a, mid+1, high, k);
        } else {
            return binarySearchRecursive(a, low, mid-1, k);
        }
    }

    // Reverse Binary Search = applied on descending order sorted array.
    private static int reverseBS(int a[], int k) {
        int low = 0;
        int high = a.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(a[mid] == k) {
                return mid;
            } else if(a[mid] < k) {
                high = mid-1;
            } else {
                low = mid+1;    
            }
        }
        return -1;
    }
    // target -> present = return index
    // target -> not present = return insert index
    private static int findInsertPosition(int a[], int target) {
        int low = 0;
        int high = a.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(a[mid] == target) {
                return mid;
            } else if(a[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
    //   Problem Statement = Given a sorted array arr[] and a number x, 
    //                       write a function that counts the occurrences of x in arr[]. 
    //                       Expected time complexity is O(Logn) 
    private static int countOccurance(int a[], int target) { // O(logn)
        int first = firstOccurance(a, target);
        int last = lastOccurance(a, target);
        if(first == -1 && last == -1) {
            return 0;
        }
        return last - first + 1;
    }

    private static int lastOccurance(int a[], int k) { // O(logn)
        int last = -1;
        int low = 0; 
        int high = a.length-1;
         
        while (low < high) {
            int mid = low + (high-low)/2;
            if(a[mid] == k) {
                last = mid;
                low = mid+1;
            } else if(a[mid] < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return last;
    }

    private static int firstOccurance(int a[], int k) {  // O(logn)
        int first = -1;
        int low = 0;
        int high = a.length-1;

        while (low < high) {
            int mid = low + (high-low)/2;
            if(a[mid] == k) {
                first = mid;
                high = mid-1;
            } else if(a[mid] < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return first;
    }
    public static void main(String[] args) {
        int a[] = {1,3,3,4,4,4,5,6};
        System.out.println(countOccurance(a, 4));
    }
}