public class Sorting {
    public static void bubbleSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; i++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp; 
                } else {
                    break;
                }
            }
        }
    }
    public static void selectionSort(int arr[]) {
       for(int i=0; i<arr.length-1; i++) {
        int smallest = i;
        for(int j=i+1; j<arr.length; j++) {
            if(arr[smallest] > arr[j]) {
                smallest = j;
            }
        }
        int temp = arr[i];
        arr[i] = arr[smallest];
        arr[smallest] = temp; 
       }
    }

    public static void insertionSort(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int curr = arr[i];
            int j = i-1;
            while(j >= 0 && curr < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
    }
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        selectionSort(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}