import java.util.*;
public class StackDS {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        } 
    }

    public static String reverseStringUsingStack(String str, Stack<Character> s) {
        for(int i=0; i<str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder reverse = new StringBuilder();
        while(!s.isEmpty()) {
            char curr = s.pop();
            reverse.append(curr);
        }
        return reverse.toString();
    }

    public static boolean isParValid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            }
            else if(str.charAt(i) == '}' && !s.isEmpty() && s.peek() == '{') {
                s.pop();
            }
            else if(str.charAt(i) == ')' && !s.isEmpty() && s.peek() == '(') {
                s.pop();
            }
            else if(str.charAt(i) == ']' && !s.isEmpty() && s.peek() == '[') {
                s.pop();
            }
            else {
                return false;
            }
        }
        return s.isEmpty();
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ')') {
                int count = 0;
                while(s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(str.charAt(i));
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "(a+b)";
        System.out.println(isDuplicate(str));
    }
}