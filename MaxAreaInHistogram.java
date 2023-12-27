import java.util.*;
public class MaxAreaInHistogram {

public static int[] nextSmallerElement(int heights[]) {
    Stack<Integer> stack = new Stack<>();
    int ans[] = new int[heights.length];
    for(int i=heights.length-1; i>=0; i--) {
        while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
            stack.pop();
        }
        if(stack.isEmpty()) {
            ans[i] = heights.length;
        } else {
            ans[i] = stack.peek();
        }
        stack.push(i);
    }
    return ans;
}

public static int[] prevSmallerElement(int heights[]) {
    Stack<Integer> stack = new Stack<>();
    int ans[] = new int[heights.length];
    for(int i=0; i<heights.length; i++) {
        while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
            stack.pop();
        }
        if(stack.isEmpty()) {
            ans[i] = -1;
        } else {
            ans[i] = stack.peek();
        }
        stack.push(i);
    }
    return ans;
}

public static int maxAreaInHistogram(int heights[]) {
    int ns[] = nextSmallerElement(heights);
    int ps[] = prevSmallerElement(heights);

    int maxArea = Integer.MIN_VALUE;
    for(int i=0; i<heights.length; i++) {
        int width = ns[i] - ps[i] - 1;
        int area = heights[i] * width;
        if(area > maxArea) {
            maxArea = area;
        }
    }
    return maxArea;
}
public static void main(String[] args) {
    int heights[] = {2, 1, 5, 6, 2, 3};
    int maxArea = maxAreaInHistogram(heights);
    System.out.println(maxArea);
    }
}