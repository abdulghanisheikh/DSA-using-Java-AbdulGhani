import java.util.*;
//      LINKED HASH MAP --> Keys are insertion order
//      -->array of DOUBLY LINKEDLIST is used in Implementation of LinkedHashMap 
//      LinkedHashMap<String, Integer> linkedhm = new LinkedHashMap<>();
//      linkedhm.put("India", 150);
//      linkedhm.put("China", 170);
//      linkedhm.put("Russia", 80);
//      System.out.println(linkedhm);

//     TREEMAP --> keys are sorted
//     -->TreeMaps are implemented using RED BLACK TREES
//     (special type of BST->Binary Search Tree).
//     -->Red Black Trees are self balancing
//     put(key, value) -> O(logn)
//     get(key)        -> O(logn)
//     remove(key)     -> O(logn)
public class Hashing {   
    public static void main(String[] args) {
        // Hashtable = A data structure that stores the unique key to value pair
        //             for example: <String, Value>.
        //             suitable for large data sets. 

        // Hashing = takes the key and compute an integer
        //           In hashtable we use the hash code to calculate the index for
        //           key to value pair.
        //           key.hashCode() % capacity = bucketIndex

        // bucket = an indexed storage location for more than one Entries.
        
        // Collision = when two or more keys are stored in the same bucket index then
        //             it is said to be as Collision.
        //             In case of collision the key-value pairs are stored
        //             in the form of LinkedList.
        //             less collision = more efficiency

        // runtime complexity: Best Case = O(1)
        //                     Worst Case = O(n)
        
        Hashtable<String, Integer> t = new Hashtable<>();
        t.put("physics", 80);
        t.put("chemistry", 90);
        t.put("english", 84);
        t.put("maths", 95);
        t.put("computer science", 84);
        t.remove("english");
        t.remove("computer science");
        System.out.println(t);
    }
}
