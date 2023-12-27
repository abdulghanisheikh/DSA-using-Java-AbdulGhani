public class MergeTwoSortedArray {
    private static void merge2SortedArray(int a[], int b[], int n, int m) {
        int merged[] = new int[n+m];
        int i = 0, j = 0, k = 0;

        while(i < n && j < m) {
            if(a[i] < b[j]) {
                merged[k++] = a[i++];
            }
            else {
                merged[k++] = b[j++];
            }
        }
        while(i < n) {
            merged[k++] = a[i++];
        }
        while(j < m) {
            merged[k++] = a[j++];
        }

        //printing the merged array
        for(i=0; i<merged.length; i++) {
            System.out.print(merged[i] + " ");
        }
    }
    public static void main(String[] args) {
        int a[] = {2, 4, 6, 8, 10};
        int b[] = {1, 3, 5, 7, 9};
        int n = a.length;
        int m = b.length;
        merge2SortedArray(a, b, n, m);
    }
}