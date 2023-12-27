import java.util.*;
public class SetQuestions {
    private static int countDistinct(int a[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<a.length; i++) {
            set.add(a[i]);
        }
        return set.size();
    }

    private static void unionOfArrays(int a[], int b[]) {  //O(n)
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<a.length; i++) {
            set.add(a[i]);
        }
        for(int i=0; i<b.length; i++) {
            set.add(b[i]);
        }
        System.out.println(set);
    }

    private static void intersectionOfArrays(int a[], int b[]) {  //O(n)
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i=0; i<a.length; i++) {
            set.add(a[i]);
        }
        for(int i=0; i<b.length; i++) {
            if(set.contains(b[i])) {
                System.out.print(b[i] + " ");
                set.remove(b[i]);
            }
        }
        
    }
     public static void main(String[] args) {
        int a[] = {7, 3, 9};
        int b[] = {6, 3, 9, 2, 9, 4};
        intersectionOfArrays(a, b); //3, 9
    }
}