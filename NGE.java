import java.util.*;
public class NGE {
    public static void nextSmallerElement(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int nextSmaller[] = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nextSmaller[i] = -1;
            } else {
                nextSmaller[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        for(int i=0; i<nextSmaller.length; i++) {
            System.out.print(nextSmaller[i] + " ");
        }
    }
    public static void nextGreaterElement(int a[]) {
        Stack<Integer> stack = new Stack<>();
        int nextGreater[] = new int[a.length];
        
        for(int i=a.length-1; i>=0; i--) {
            while(!stack.isEmpty() && a[stack.peek()] <= a[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = stocks[stack.peek()];
            }
            stack.push(i);
        }

        for(int i=0; i<nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);

        for(int i=1; i<stocks.length; i++) {
            int currPrice = stocks[i];
            
            while(!stack.isEmpty() && currPrice > stocks[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                span[i] = i+1;
            } 
            else {
                int prevHigh = stack.peek();
                span[i] = i - prevHigh;
            }
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 8, 5, 2, 25};
        nextSmallerElement(arr);
    }
}