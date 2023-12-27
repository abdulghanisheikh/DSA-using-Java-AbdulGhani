import java.util.*;
public class RecursionBestProblems {
    public static void reverseStr(String str, int index) {
        if(index == 0) {
            System.out.println(str.charAt(index));
            return;
        }
        System.out.print(str.charAt(index));
        reverseStr(str, index-1);
    }

    public static int first = -1;
    public static int last = -1;
    public static void findOcc(String str, int index, char element) {
        if(index == str.length()) {
            System.out.print("first occurance = ");
            System.out.println(first);
            System.out.print("last occurance = ");
            System.out.println(last);
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
        findOcc(str, index+1, element);
    }
    public static boolean isSorted(int arr[], int index) {
        if(index == arr.length-1) {
            return true;
        }
        if(arr[index] < arr[index+1]) {
           return isSorted(arr, index+1);
        }
        return false;
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
    public static boolean map[] = new boolean[26];
    public static void removeDuplicate(String str, int index, String newString) {
        if(index == str.length()) {
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(index);
        if(map[currChar - 'a'] == true) {
            removeDuplicate(str, index+1, newString);
        }
        else {
            newString = newString + currChar;
            map[currChar - 'a'] = true;
            removeDuplicate(str, index+1, newString);
        }
    }
    public static void subsequence(String str, int index, String newString) {
        if(index == str.length()) {
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(index);
        subsequence(str, index+1, newString + currChar);
        subsequence(str, index+1, newString);
    }
    public static void uniqueSubsequence(String str, int index, String newString, HashSet<String> set) {
        if(index == str.length()) {
            if(set.contains(newString)) {
                return;
            }
            else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char currChar = str.charAt(index);
        uniqueSubsequence(str, index+1, newString + currChar, set);
        uniqueSubsequence(str, index+1, newString, set);
    }

    public static String keypad[] = {"." ,"abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void keypadComb(String str, int index, String combination) {
        if(index == str.length()) {
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(index);
        String mapping = keypad[currChar - '0'];
        for(int i=0; i<mapping.length(); i++) {
            keypadComb(str, index+1, combination + mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        String str = "4";
        keypadComb(str, 0, "");
    }
}