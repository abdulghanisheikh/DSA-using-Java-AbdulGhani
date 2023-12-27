public class SlideWindowMax {
    private static void slideWindowMax(int a[], int k) {
        int n = a.length;
        for(int i=0; i<=n-k; i++) {
            int max = a[i];
            for(int j=1; j<k; j++) {
                if(a[j+i] > max) {
                    max = a[j+i];
                }
            }
            System.out.print("max = " + max + " ");
        }
    }
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        slideWindowMax(a, k);
    }
}