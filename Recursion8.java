import java.util.*;
public class Recursion8 {
    public static int first = -1;
    public static int last = -1;
    public static void findOccurance(String str, int index, char element) {
        if(index == str.length()-1) {
            System.out.println("First = " + first);
            System.out.println("Last = " + last);
            return;
        }
        char currChar = str.charAt(index);
        if(currChar == element) {
            if(first == -1) {
                first = index;
            }
            else {
                last = index;
            }
        }
        findOccurance(str, index+1, element);
    }   
    public static boolean isSorted(int arr[], int index) {
        if(index == arr.length-1) {
            return true;
        }
        if(arr[index] >= arr[index+1]) {
            return false;
        }
        else {
            return isSorted(arr, index+1);
        }
    }
    public static void moveAllX(String str, int index, int count, String newString) {
        
        if(index == str.length()) {
            for(int i=0; i<count; i++) {
                newString = newString + 'x';
            }
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(index);
        if(currChar == 'x') {
            count++;
            moveAllX(str, index+1, count, newString);
        }
        else {
            newString = newString + currChar;
            moveAllX(str, index+1, count, newString);
        }
    }
    public static boolean mapping[] = new boolean[26];
    public static void removeDuplicates(String str, int index, String newStr) {
        if(index == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(index);
        if(mapping[currChar - 'a']) {
            removeDuplicates(str, index+1, newStr);
        }
        else {
            newStr = newStr + currChar;
            mapping[currChar - 'a'] = true;
            removeDuplicates(str, index+1, newStr);
        }
    }

    public static void subSequences(String str, int index, String newString) {
        if(index == str.length()) {
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(index);
        // include
        subSequences(str, index+1, newString + currChar);
        // exclude
        subSequences(str, index+1, newString);
    }

    public static void uniqueSubSequence(String str, int index, String newString, HashSet<String> set) {
        if(index == str.length()) {
            if(set.contains(newString)) {
                return;
            }
            else {
                set.add(newString);
                System.out.println(newString);
                return;
            }
        }
        char currChar = str.charAt(index);
        uniqueSubSequence(str, index+1, newString+currChar, set);
        uniqueSubSequence(str, index+1, newString, set);
    }

    public static String keypad[] = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void printComb(String str, int index, String combination) {
        if(index == str.length()) {
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(index);
        String mapping = keypad[currChar - '0'];   //string
        for(int i=0; i<mapping.length(); i++) {
            printComb(str, index+1, combination + mapping.charAt(i));
        }
    }
public static void main(String[] args) {
    String str = "12";
    printComb(str, 0, "");
}
    
}