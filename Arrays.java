class Arrays {
    static int binarySearch(int a[], int k) {
        int low = 0;
        int high = a.length-1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(a[mid] == k) {
                return mid;
            } else if(a[mid] > k) {  
                high = mid-1;    // too high
            } else {
                low = mid+1;     // too low
            }
        }
        return -1;
    }

    static void insertionSort(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int currElement = arr[i];
            int j = i-1;
            while(j >= 0 && currElement < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = currElement;
        }
    }

    static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static int findUniqueElement(int arr[]) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }

    static int findDuplicate(int arr[]) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            ans = ans ^ i;
        }

        return ans;
    }

    static int findMyElement(int a[], int k) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                return i;
            }
        }
        return 0;
    }

    static int secondMaxElement(int a[]) {
        sortArray(a);
        System.out.print("second max element: ");
        return a[a.length - 2];
    }

    static void secondMinElement(int a[]) {

        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }

        System.out.println("second min element: " + a[1]);
    }

    static void reverseArray(int a[]) {
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    static void intersectionOfTwoArrays(int a[], int b[]) {
        int i = 0;
        int j = 0;
        int ans[] = new int[b.length];

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                ans[j] = a[i];
                System.out.print(ans[j] + " ");
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
    }

    static void selectionSort(int arr[]) {
        for(int i = 0; i < arr.length-1; i++) {
            int smallest = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    private static void printPairs(int a[]) {
        int totalPairs = 0;
        for(int i=0; i<a.length-1; i++) {
            for(int j=i+1; j<a.length; j++) {
                System.out.print("(" + a[i] + "," + a[j] + ")");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("total pairs = " + totalPairs); //total pairs = n(n-1)/2
    }

    private static void printSubArrays(int a[]) {  //time complexity = O(n^3)
        int totalSubArrays = 0;
        for(int i=0; i<a.length; i++) {
            for(int j=i; j<a.length; j++) {
                for(int k=i; k<=j; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println();
                totalSubArrays++;
            }
            System.out.println();
        }
        System.out.println("total sub arrays = " + totalSubArrays); //total subarrays = n(n+1)/2; 
    }

    private static void maxSubArraySum(int a[]) {  
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++) {
            int start = i; 
            for(int j=i; j<a.length; j++) {
                int end = j;
                for(int k=start; k<=end; k++) {
                    sum = sum + a[k];
                }
                System.out.println(sum);
                if(sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("maximum sum = " + maxSum);
    }
    public static void main(String[] args) {
        int numbers[] = {1, -2, 6, -1, 3};
        maxSubArraySum(numbers);
    }
}
// 1  sum = 1
// 1 -2 sum = -1
// 1 -2 6 sum = 5
// 1 -2 6 -1 sum = 4
// 1 -2 6 -1 3 sum = 7

// -2 sum = -2
// -2 6 sum = 4
// -2 6 -1 sum = 3
// -2 6 -1 3 sum = 6

// 6 sum = 6
// 6 -1 sum = 5
// 6 -1 3 sum = 8

// -1 sum = -1
// -1 3 sum = 2

// 3 sum = 3

// maximum sum = 8