public class MergeSort {
    private static void mergeSort(int a[], int low, int high) {
        if(low < high) {
        int mid = low + (high-low)/2;
        //splits the array from low to mid
        mergeSort(a, low, mid);
        //splits the array from mid+1 to high
        mergeSort(a, mid+1, high);
        //merging the splitted array into one sorted array
        merge(a, low, high); 
        }
    }

    private static void merge(int a[], int low, int high) {
        int mid = low + (high-low)/2;
        //declaring two temporary arrays
        int a1[] = new int[mid-low+1];
        int a2[] = new int[high-mid];

        int k = low;
        //copying values in a1 array
        for(int i=0; i<a1.length; i++) {
            a1[i] = a[k++];
        }

        k = mid+1;
        //copying values in a2 array
        for(int i=0; i<a2.length; i++) {
            a2[i] = a[k++];
        }

        //merging two sorted arrays
        int index1 = 0, index2 = 0;
        k = low;
        while(index1 < a1.length && index2 < a2.length) {
            if(a1[index1] <= a2[index2]) {
                a[k++] = a1[index1++];
            }
            else {
                a[k++] = a2[index2++];
            }
        }
        while(index1 < a1.length) {
            a[k++] = a1[index1++];
        }
        while(index2 < a2.length) {
            a[k++] = a2[index2++];
        }
    }
    public static void main(String[] args) {
        int a[] = {2, 5, 1, 6, 9};
        mergeSort(a, 0, a.length-1);

        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}