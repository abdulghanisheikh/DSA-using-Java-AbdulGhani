public class Recursion3 {
    static boolean isSorted(int a[], int index, int size) {
        // base case
        if(size == 1 && size == 0) {
            return true;
        }
        // processing
        if(a[index] > a[index+1]) {
            return false;
        }
        else {
            // recursive relation
            boolean ans = isSorted(a, index+1, size-1);
            return ans;
        }
    }
    static void sumOfArr(int a[], int index) {
        // base case
        if(a.length == 0) {
            System.out.println(0);
            return;
        }
        if(a.length == 1) {
            System.out.println(a[0]);
            return;
        }
        if(index == a.length-1) {
            return;
        }
        int sum = 0;
        sum = sumOfArr(a, index+1);
        System.out.print(sum);
    }

    static boolean linearSearch(int a[], int key, int index, int size) {
        // base case
        if(index == size) {
            return false;
        }
        if(a[index] == key) {
            return true;
        }
        else {
            boolean ans = linearSearch(a, key, index + 1, size);
            return ans;
        }
    }
    static void print(int a[], int index) {
        // base case
        if(index == a.length) {
            return;
        }
        System.out.print(a[index] + " ");
        // recursive call
        print(a, index+1);
    }
    static boolean binarySearch(int a[], int l, int h, int k) {
    // base case
    if(l > h) {
        return false;
    }
    int mid = l + (h-l)/2;
    if(a[mid] == k) {
        return true;
    }
    // recursive relation
    if(a[mid] > k) {
        return binarySearch(a, l, mid-1, k);
    }
    else {
        return binarySearch(a, mid+1, h, k);
    }
}

static int firstOccurance(int a[], int index, int k) {
    // base case
    if(index == a.length) {
        return -1;
    }
    int mid = low + (high - low)/2;
    if(a[index] == k) {
        return index;
    }
    // recursive relation
    else {
        return firstOccurance(a, index+1, k);
    }
}
public static int peakElement(int a[], int low, int high) {
    int mid = low + (high-low)/2;
    // base case
    if(low == high) {
        return a[mid];
    }
    if(a[mid] < a[mid+1]) {
        return peakElement(a, mid+1, high);
    }
    else {
        return peakElement(a, low, mid);
    }
}
static int lastOccurance(int a[], int index, int k) {
    // base case
    if(index == a.length) {
        return -1;
    }
    int rest = lastOccurance(a, index+1, k);
    if(rest == -1) {
        if(a[index] == k) {
            return index;
        }
        else {
            return -1;
        }
    }
    else {
        return rest;
    }
}
static int pivotElement(int []a, int low, int high) {
    int mid = low + (high-low)/2;
    // base case
    if(a[mid] > a[mid-1] && a[mid] > a[mid+1]) {
        return mid;
    }
    if(low == high) {
        return mid;
    }
    if(a[mid] > a[0]) {
        return pivotElement(a, mid+1, high);
    }
    else {
        return pivotElement(a, low, mid);
    }
}
static boolean searchInRotatedArr(int a[], int k) {
    int pivot = pivotElement(a, 0, a.length-1);
    if(k >= a[0] && k <= a[pivot]) {
        return binarySearch(a, 0, pivot-1, k);
    }
    else {
        return binarySearch(a, pivot, a.length-1, k);
    }
}
public static void main(String[] args) {
        int arr[] = {9, 13, 14, 15, 5, 6, 7};
        System.out.println("Pivot is at index " + pivotElement(arr, 0, arr.length-1));
        System.out.println(searchInRotatedArr(arr, 7));
    }
}