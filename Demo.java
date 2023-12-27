import java.util.*;
public class Demo {
    private static boolean checkVowel(String input) {
        String vowel = "aeious";
        String check = input.toLowerCase();

        for(int i=0; i<check.length(); i++) {
            char currChar = check.charAt(i);
            if(vowel.indexOf(currChar) == -1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkVowel("hello"));
    }
}