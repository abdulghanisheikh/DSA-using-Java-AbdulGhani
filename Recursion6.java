public class Recursion6 {
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for(int j=low; j<high; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;
        return i+1;
    }
    public static void quickSort(int arr[], int low, int high) {
        if(low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 6, 2, 5, 7, 9, 1 ,3};
        System.out.println("before quicksort ");
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        quickSort(arr, 0, arr.length-1);
        System.out.println("\nafter quicksort ");
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}