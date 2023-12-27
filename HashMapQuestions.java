import java.util.*;
public class HashMapQuestions {
    private static void majorityElement(int a[]) { //O(n)
        HashMap<Integer, Integer> track = new HashMap<>();
        int n = a.length;
        //iterate through array and store frequency for each key 
        for(int i=0; i<a.length; i++) {
            if(track.containsKey(a[i])) {
                //track.get(a[i]) --> value
                track.put(a[i], track.get(a[i]) + 1);
            } else {
                track.put(a[i], 1);
            }
            //track.put(a[i], track.getOrDefault(a[i], 0) + 1);
        }
        //iterate through hashmap
        for (Integer key : track.keySet()) {
            if(track.get(key) > n/3) {
                System.out.print(key + " ");
            }
        }
    }

    //Anagram->its a word or phrase formed by rearranging the letters of a different words or phrase, typically using all the original letters exactly once.
    //s = "race" t = "care" -> True
    //s = "tulip" t = "lipid" -> False
    private static boolean isAnagram(String a, String b) { //O(n)
        HashMap<Character, Integer> map = new HashMap<>();
        //entring key-value pair in the map from String a
        for(int i=0; i<a.length(); i++) {
            char currChar = a.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }
        //loop on b string and checking if char present in map or not
        for(int i=0; i<b.length(); i++) {
            char currChar = b.charAt(i);
            if(map.get(currChar) != null) {
                if(map.get(currChar) == 1) {
                    map.remove(currChar);
                } else {
                    map.put(currChar, map.get(currChar)-1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
    String a = "tulip", b = "lipid";
    boolean ans = isAnagram(a, b);
    System.out.println(ans);
    }
}