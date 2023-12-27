import java.io.*;

public class Strings3 {
        // indexOf() method
        // System.out.println(s.indexOf("ep")); 
        // System.out.println(s.lastIndexOf('e')); 
         
        // charAt() method
        // System.out.println(s.charAt(4));
 
        // contains() method
        // System.out.println(name.contains("_"));

        // startsWith() method
        // System.out.println(name.startsWith("Ab"));

        // endsWith() method
        // System.out.println(name.endsWith(rollNo));

    static boolean isPalindrome(String str) {
        boolean ans = true;
        int i = 0;
        int j = str.length()-1;

        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        return ans;
    }

    static void maxOccCharacter(String str) {
        int a[] = new int[256];

        for(int i=0; i<str.length(); i++) {
        a[str.charAt(i)] = a[str.charAt(i)] + 1;
        }

        int max = Integer.MAX_VALUE;
        char c = ' ';
        for(int i=0; i<str.length(); i++) {
            if(max < a[str.charAt(i)]) {
                max = a[str.charAt(i)];
                c = str.charAt(i);
            }
        }
        System.out.println("max occ character = " + c);
    }

    static void reverseWord(String s) {
    String reverse = "";
    int i = s.length()-1;
    while(i >= 0) {
        if(s.charAt(i) == ' ') {
            continue;
        }
        else {
            reverse = reverse + s.charAt(i);
            i--;
        }
    }
    System.out.println(reverse);
}
        

    static void replaceAllSpaces(String s) {
        System.out.println(s.replaceAll(" ", "@"));
    }
    
    static void removeOccOfSubString(String s, String part) {
    for(int i=0; i<s.length(); i++) {
        if(s.contains(part)) {
            s = s.replace(part, "");
        }
    }
    System.out.println(s);
    }

    public static void main(String[] args) {

    String s = "aaabbcccddaeef";
    reverseWord(s);
    } 
}