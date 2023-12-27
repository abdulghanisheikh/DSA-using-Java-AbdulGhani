import java.util.*;
class TwoDimensionalArray {
    public static void main(String[] args) {

        // Scanner f = new Scanner(System.in);
        // int row = 3, col = 3;
        // int a[][] = new int[row][col];
        // System.out.println("Enter elements: ");

        // for(int i=0; i<row; i++) {
        //     for(int j=0; j<col; j++) {
        //         a[i][j] = f.nextInt();
        //     }
        // }
        // for(int i=0; i<row; i++) {
        //     for(int j=0; j<col; j++) {
        //         System.out.print(a[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int a[][] = {{16, 28, 60, 64},
        {22, 41, 63, 91},
        {27, 50, 87, 93},
        {36, 78, 87, 94 }};
        System.out.println(kthSmallestInMatrix(a, 3));
    }

    static int kthSmallestInMatrix(int a[][], int k) {
        int r = a.length;
        int c = a[0].length;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                ans.add(a[i][j]);
            }
        }
        Collections.sort(ans);
        int e = ans.get(k-1);
        return e;
    }


    static void dispMatrix(int matrix[][], int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void sortMatrix(int Mat[][], int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        int a[][] = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                ans.add(Mat[i][j]);
            }
        }
        Collections.sort(ans);
        int k = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                a[i][j] = ans.get(k++);
            }
        }
        dispMatrix(a, N);
    }

    static int max1sInRows(int a[][]) {
        int r = a.length;
        int c = a[0].length;
        int max = 0;
        int row = -1;

        for(int i=0; i<r; i++) {
            int count = binarySearch2(a, i);
            if(count > max) {
                max = count;
                row = i;
            }
        }
        return row;
    }


    static int binarySearch2(int a[][], int r) {
       int s = 0;
       int e = a[0].length-1;
       int f1Index = a[0].length;

        while(s <= e) {
            int mid = s + (e-s)/2;
            if(a[r][mid] == 1) {
                f1Index = mid;
                e = mid-1;
            }
            else {
                s = mid+1;
            }
        }
        int count = a[0].length - f1Index;
        return count;
    }

    static void findMedian(int a[][], int r, int c) {
        int sum = 0;
        int total = r*c;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                sum = sum + a[i][j];
            }
        }
        float ans = sum/total;
        System.out.println("Median = " + ans);

    }
    static void transpose(int a[][]) {
        int row = a.length;
        for(int i=0; i<row; i++) {
            for(int j=0; j<i; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
    }

    static void rotateBy90(int a[][]) {
        transpose(a);
        // swapping rows
        int row = a.length;
        int col = a[0].length;
        for(int i=0; i<row/2; i++) {
            for(int j=0; j<row; j++) {
                int temp = a[i][j];
                a[i][j] = a[row-1-i][j];
                a[row-1-i][j] = temp;
            }
        }
        // printing matrix
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static boolean SearchInArray2(int a[][], int k) {
        int row = a.length;
        int col = a[0].length;
        int rowIndex = 0;
        int colIndex = col-1;
        
        while(rowIndex < row && colIndex >= 0) {
            int e = a[rowIndex][colIndex];
            if(e == k) {
                return true;
            }
            else if(e < k) {
                rowIndex++;
            }
            else {
                colIndex--;
            }
        }
        return false;
    }
    
    static boolean binarySearch(int a[][], int row, int col, int k) {
        int start = 0;
        int end = row*col-1;
        int mid = start + (end-start)/2;

        while(start <= end) {
            int element = a[mid/col][mid%col];
            if(element == k) {
                return true;
            }
            else if(element > k) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
            mid = start + (end-start)/2;
        }
        return false;
    }

    static void spiralPrint(int a[][], int row, int col) {
        // index
        int left = 0;
        int right = col-1;
        int top = 0;
        int bottom = row-1;

        while(left <= right && top <= bottom) {
            // traversing row
            for(int i=left; i<=right; i++) {
                System.out.print(a[top][i] + " ");
            }
            top++;
            // traversing column
            for(int i=top; i<=bottom; i++) {
                System.out.print(a[i][right] + " ");
            }
            right--;
            if(top <= bottom) {
            // traversing row
            for(int i=right; i>=left; i--) {
            System.out.print(a[bottom][i] + " ");
            }
            bottom--;
            if(left <= right) {
            // traversing column
            for(int i=bottom; i>=top; i--) {
            System.out.print(a[i][left] + " ");
            }
            left++;
        }

    }
}
}

    static void wavePrint(int arr[][], int nRows, int mCols) {
        
        for(int i=0; i<mCols; i++) {
            if(i%2 != 0) {
                // odd index
                for(int j=nRows-1; j>=0; j--) {
                    System.out.print(arr[j][i] + " ");
                }
            }
            else {
                // even index
                for(int j=0; j<nRows; j++) {
                    System.out.print(arr[j][i] + " ");
                }
            }
        }
    }

    static void maxSumRowWise(int a[][], int row, int col) {
        int max = Integer.MIN_VALUE;
        int rowIndex = -1;
        for(int i=0; i<row; i++) {
            int sum = 0;
            for(int j=0; j<col; j++) {
                sum = sum + a[i][j];
            }
            if(sum > max) {
                max = sum;
                rowIndex = i;
            }
        }
        System.out.println("Max sum is " + max + " of row of index " + rowIndex);
    }

    static void rowWiseSum(int a[][], int row, int col) {
        for(int i=0; i<row; i++) {
            int sum = 0;
            for(int j=0; j<col; j++) {
                sum = sum + a[i][j];
            }
            System.out.println("Sum of " + i + " row = " + sum);
        }
    }

    static void columnWiseSum(int a[][], int row, int col) {
        
        for(int i=0; i<col; i++) {
            int sum = 0;
            for(int j=0; j<row; j++) {
                sum = sum + a[j][i];
            }
            System.out.println("Sum of " + i + " column = " + sum);
            
        }
    }
        
    static boolean isPresent(int a[][], int target) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<4; j++) {
                if(a[i][j] == target) 
                    return true;
                }
        }
        return false;
    }
}
