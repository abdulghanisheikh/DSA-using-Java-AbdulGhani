public class Recursion5 {
    public static void divide(int arr[], int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = low + (high-low)/2;
        divide(arr, low, mid);
        divide(arr, mid+1, high);
        conquer(arr, low, mid, high);
    }
    public static void conquer(int arr[], int low, int mid, int high) {
        int merged[] = new int[high-low+1];
        int idx1 = low;
        int idx2 = mid+1;
        int x = 0;
        while(idx1 <= mid && idx2 <= high) {
            if(arr[idx1] <= arr[idx2]) {
                merged[x] = arr[idx1];
                x++;
                idx1++;
            }
            else {
                merged[x] = arr[idx2];
                x++;
                idx2++;
            }
        }
        while(idx1 <= mid) {
            merged[x] = arr[idx1];
            x++;
            idx1++;
        }
        while(idx2 <= high) {
            merged[x] = arr[idx2];
            x++;
            idx2++;
        }
        for(int i=0, j=low; i<merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        divide(arr, 0, n-1);

        System.out.print("sorted array: ");
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
