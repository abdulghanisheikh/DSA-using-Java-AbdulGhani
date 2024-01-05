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
                low = mid+1;
            } else {
                high = mid-1;
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
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 8, 8, 11, 13};
        int ans[] = {firstOccurance(arr, 8), lastOccurance(arr, 8)};
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}