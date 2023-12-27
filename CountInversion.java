public class CountInversion {
    static int countInversion(int arr[], int size) {
        int count = 0;
        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {
                if(arr[j] < arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void printArr(int arr[], int index ,int len) {
        if(index == arr.length) {
            return;
        }
        System.out.print(arr[index] + " ");
        printArr(arr, index+1, len);
    }
    public static void reverseArray(int arr[], int len) {
        if(len == 0) {
            return;
        }
        System.out.print(arr[len-1] + " ");
        reverseArray(arr, len-1);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        printArr(arr, 0, arr.length-1);
    }
    
}