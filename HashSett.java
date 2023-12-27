//  HASH SET = collection of unique elements
//             no duplicates
//             unordered
//             null allowed
//             HashSet is implemented by HashMap only 
//             where key=element, value=any random value.

//  operations:-
//             add(key)       O(1)
//             remove(key)    O(1)
//             constains(key) O(1)

// Implementation:-
//  HashaMap is used to implement HashSet.
//  LinkedHashMap is used to implement LinkedHasSet.
//  TreeHashMap is used to implement TreeHashSet.

// Perfomance = LinkedHashMap < HashMap 
//              LinkedHashSet < HashSet 
import java.util.*;
public class HashSett {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(5);
        set.add(2);
        set.add(2);
        set.add(1);
        set.add(4);
        set.add(3);

        // // iterating on set using Iterator
        // Iterator i = set.iterator();
        // while(i.hasNext()) {
        //     System.out.print(i.next() + " ");
        // } 
        // System.out.println();
        // //using enhanced for loop
        // for (Integer e : set) {
        //     System.out.print(e + " ");
        // }

        // LINKED HASH SET = same as LinkedHashMap and elements are ordered.
        //                   ordered using a Doubly LinkedList.
        // time complexity = O(1)

        // LinkedHashSet<String> cities = new LinkedHashSet<>();
        // cities.add("Delhi");
        // cities.add("Mumbai");
        // cities.add("Bangluru");
        // cities.add("Noida");
        // System.out.println(cities);
        // cities.remove("Delhi");
        // System.out.println(cities);

        // TREE SET = sorted in ascending order.
        //            NULL values are not allowed.
        //            implemented using red black trees.
        //            Red Black Trees are self balancing BST(Binary Search Trees).
        // time complexity = O(logn) (due to internal sorting).

        // TreeSet<Integer> treeSet = new TreeSet<>();
        // treeSet.add(3);
        // treeSet.add(2);
        // treeSet.add(5);
        // treeSet.add(4);
        // treeSet.add(1);

        // System.out.println(treeSet); // sorted ascending order
    }
}