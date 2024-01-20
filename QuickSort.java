public class QuickSort {
    // Quick Sort = In quick sort an element is said to be sorted if all the elements
    //              on its left side are smaller than it and all the elements on its
    //              right side are greater than it.(and that element is called as Pivot)

    // Time complexity:-
    // best and average case = O(nlog(n))
    // worst case = O(n^2) (when list is already sorted)

    // Space complexity = O(log(n)) (due to recursion)

    private static int partition(int a[], int start, int end) {
        int pivot = a[end];
        int i = start-1;
        for(int j=start; j<end; j++) {
            if(a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++;
        int temp = a[i];
        a[i] = a[end];
        a[end] = temp;
        return i;
    }
    private static void quickSort(int a[], int start, int end) {
        if(start < end) {
        int pivot = partition(a, start, end);
        quickSort(a, start, pivot-1); // sort left subarray
        quickSort(a, pivot+1, end); // sort right subarray
        }
    }
    public static void main(String[] args) {
        int a[] = {3,5,2,12,13};
        quickSort(a, 0, a.length-1);
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
