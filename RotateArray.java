public class RotateArray {
    // To Do = rotate array k times to the right side
    // input array = [1,2,3,4,5,6,7],  k = 3
    // step 1 = [7,1,2,3,4,5,6]
    // step 2 = [6,7,1,2,3,4,5]
    // step 3 = [5,6,7,1,2,3,4] = output array
    private static void rotateArray(int a[], int k) { // time complexity = O(n)
        k = k % a.length;                             // space complexity = O(1)
        // reverse array                      
        reverseArray(a, 0, a.length-1);
        // reverse array again from 0 to k-1
        reverseArray(a, 0, k-1);
        //reverse array again from k to end
        reverseArray(a, k, a.length-1);

        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    private static void reverseArray(int a[], int i, int j) {
        while(i <= j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++; j--; 
        }
    }
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(a, 3);
    }
}
