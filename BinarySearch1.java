public class BinarySearch1 {
    static boolean binarySearch(int arr[], int n, int k) {
        int s = 0;
        int e = n-1;
        while(s <= e) {
            int mid = s + (e - s)/2;
            if(arr[mid] == k) {
                return true;
            }
            else if(arr[mid] > k) {
                e = mid -1;
            }
            else {
                s = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 9};
        int n = arr.length;
        System.out.println(binarySearch(arr, n, 2));
    }
}