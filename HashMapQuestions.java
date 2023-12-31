import java.util.*;
import java.util.HashMap;
import java.util.Collections;
public class HashMapQuestions {
    private static void majorityElement(int a[]) { //O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = a.length;
        //iterate through array and store frequency for each key 
        for(int i=0; i<a.length; i++) {
            if(map.containsKey(a[i])) {
                //map.get(a[i]) --> value
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
            //map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        //iterate through hashmap
        for (Integer key : map.keySet()) {
            if(map.get(key) > n/3) {
                System.out.print(key + " ");
            }
        }
    }

    //Anagram = its a word or phrase formed by rearranging the letters of a 
    //          different words or phrase, typically using all the 
    //          original letters exactly once.
    //           s = "race" t = "care" -> True
    //           s = "tulip" t = "lipid" -> False

    private static boolean isAnagram(String a, String b) { //O(n)
        HashMap<Character, Integer> map = new HashMap<>();
        // entring each char and their frequency in the map from String a
        for(int i=0; i<a.length(); i++) {
            char currChar = a.charAt(i);
            if(map.get(currChar) == null) {
                map.put(currChar, 1);
            } else {
                map.put(currChar, map.get(currChar) + 1);
            }
        }
        //loop on b string and checking if char present in map or not
        for(int i=0; i<b.length(); i++) {
            char currChar = b.charAt(i);
            if(map.get(currChar) != null) {
                if(map.get(currChar) == 1) {
                    map.remove(currChar);
                } else {
                    map.put(currChar, map.get(currChar) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    private static String getStart(HashMap<String, String> tickets) {  // O(n)
        HashMap<String, String> reverse = new HashMap<>();
        for(String key : tickets.keySet()) {
            reverse.put(tickets.get(key), key);
        }
        for(String key : tickets.keySet()) {
            if(reverse.containsKey(key) == false) {
                return key;
            }
        }
        return null;
    }

    private static void sumZero(int a[]) {  // O(n)
        // map<sum, index>
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        int i = -1;
        map.put(sum, i);
        while(i < a.length-1) {
            i++;
            sum = sum + a[i];
            if(map.containsKey(sum) == false) {
                // sum first time occured
                map.put(sum, i);
            } else {
                int length = i - map.get(sum);
                if(length > maxLength) {
                    maxLength = length;
                }
            }
        }
        System.out.println("length of largest subarray having sum zero = " + maxLength);
    }

    private static void sumEqualtoK(int a[], int k) {
        HashMap<Integer,Integer> map = new HashMap<>(); // O(n)
        // map<sum, freq>
        int n = a.length;
        int sum = 0;
        int count = 0;
        map.put(0, 1);

        for(int i=0; i<n; i++) {
            sum = sum + a[i];
            if(map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            } 
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("number of subarrays of sum k = " + count);
    }

    private static int[] twoSum(int a[], int target) {
        // map<compliment, index>
        // compliment = target - a[i]
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = a.length;
        for(int i=0; i<n; i++) {
            int compliment = target - a[i];
            if(map.containsKey(compliment)) {
                return new int[] {map.get(compliment), i};
            } 
            map.put(a[i], i);
        }
        return a;
    }

    private static int missingNumber(int a[]) {
        HashSet<Integer> set = new HashSet<>();
        int n = a.length;
        for(int i=0; i<=n; i++) { 
            set.add(i);
        }
        for(int i=0; i<n; i++) {
        if(set.contains(a[i])) {
            set.remove(a[i]);
        } 
    }
    int ans = -1;
    for(Integer e : set) {
        ans = e;
    } 
    return ans;
}
    public static void main(String[] args) {
        
    }
}