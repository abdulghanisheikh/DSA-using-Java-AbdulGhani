public class BinarySearch1 {
    // Binary Search is applicable on sorted array (ascending/descending order).
    // time complexity = O(logn)
    private static int binarySearchIterative(int a[], int k) {
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
    public static void main(String[] args) {
        //   index = 0  1  2  3  4
        int arr[] = {2, 4, 6, 8, 9};
        int target = 6;
        int index = binarySearchRecursive(arr, 0, arr.length-1, target);
        System.out.println(target + " is at index: " + index);
    }
}