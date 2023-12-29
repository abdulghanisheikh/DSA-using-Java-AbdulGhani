import java.util.*;
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

    private static void sortArray(int a[]) {
        for(int i=0; i<a.length-1; i++) {
            int smallest = i;
            for(int j=i+1; j<a.length; j++) {
                if(a[smallest] > a[j]) {
                    smallest = j;
                }
            }
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
        }
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
        System.out.println("total pairs = " + totalPairs); // total pairs = n(n-1)/2
    }

    private static void printSubArray(int a[]) {
        for(int i=0; i<a.length; i++) {
            for(int j=i; j<a.length; j++) {
                for(int k=i; k<=j; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println();
            }
        }
    }
    private static void maxSumOfSubArray(int a[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        // int prefix[] = new int[a.length];
        // prefix[0] = a[0];
        // // calculating prefix array
        // for(int i=1; i<prefix.length; i++) {
        //     prefix[i] = prefix[i-1] + a[i];
        // }
        // for(int i=0; i<a.length; i++) {
        //     int start = i;
        //     for(int j=i; j<a.length; j++) {
        //         int end = j;
        //         sum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
        //         if(sum > maxSum) {
        //             maxSum = sum;
        //         }
        //     }
        // }
        for(int i=0; i<a.length; i++) {
            for(int j=i; j<a.length; j++) {
                sum = 0;
                for(int k=i; k<=j; k++) {
                    sum = sum + a[k];
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        System.out.println(maxSum);
    }

    private static int kadanes(int a[]) { // O(n)
        int sum = 0;
        int maxSum = a[0];
        for(int i=0; i<a.length; i++) {
            sum = sum + a[i];
            // max(a,b) = returns greatest of two numbers.
            maxSum = Math.max(maxSum, sum);
            // if sum is negative re-assign sum = 0.
            if(sum < 0) {
                sum = 0;
            } 
        }
        return maxSum;
    }

    private static int trappedRainwater(int height[]) { // O(n)
        int n = height.length;
        // calculate left max array
        int leftMax[] = new int[n];
        // corner case
        leftMax[0] = height[0];
        for(int i=1; i<n ; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        // calculate right max array
        int rightMax[] = new int[n];
        // corner case
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        // calculating trapped water for each bar
        int trappedWater = 0;
        for(int i=0; i<height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // trapped water = (water level - height) * width
            trappedWater = trappedWater + (waterLevel - height[i])*1;
        }
        return trappedWater;
    }

    private static int buySellStocks(int price[]) {
        int n = price.length;
        int maxProfit = 0;
        int profit;
        int buyPrice = price[0];
        for(int i=0; i<n; i++) {
            int sellPrice = price[i];
            if(buyPrice < sellPrice) {
                profit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = sellPrice;
            }
        }
        return maxProfit;
    }
    private static int[] prefixSumArray(int a[]) {  // O(n)
        int n = a.length;
        int prefixSum[] = new int[n];
        for(int i=0; i<n; i++) {
            if(i == 0) {
                prefixSum[i] = a[0];
            } else {
                prefixSum[i] = prefixSum[i-1] + a[i];
            }
        }
        return prefixSum;
    }
    public static void main(String[] args) {
        int a[] = {10, 20, 30, 15, 10};
        int prefixSum[] = prefixSumArray(a);
        for(int i=0; i<prefixSum.length; i++) {
            System.out.print(prefixSum[i] + " ");
        }
    }
}