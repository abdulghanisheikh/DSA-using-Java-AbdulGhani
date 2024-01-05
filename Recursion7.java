import java.util.*;
public class Recursion7 {
    
    // public static List<List<Integer>> subSets(int arr[]) {

    //     List<List<Integer>> ans = new ArrayList<Integer>();
    //     List<Integer> output = new ArrayList<Integer>();
    //     int index = 0;
    //     solve(arr, ans, output, index);
    //     return ans;
    // } 
    
    static void solve(String str, ArrayList<String> ans, ArrayList<String> output, int index) {
        if(index >= str.length()) {
            if(output.size() > 0) {
                ans.add(output);
            }
            return;
        }
        // exclude
        solve(str, output, output, index+1);
        // include
        char element = str.charAt(index);
        output.add(element);
        solve(str, output, output, index+1);
    }
    public static ArrayList<String> subSequences(String str) {
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        int index = 0;
        solve(str, ans, output, index);
        return ans;
    }

    public static void main(String[] args) {
        String str = "abc";
             
    }
}