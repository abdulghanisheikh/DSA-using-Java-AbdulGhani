//HashMap is implemented in the form of Array of LinkedList.
//each node of the linkedlist stores the key-value pair.
//Rehashing->It is a technique which dynamically expands the size of the array/map to mantain the put() and get() operations time complexity->O(1)
import java.util.*;
public class HashMapImplementation {
    static class HashMap<K,V> {
        public class Node {
            K key;
            V value;

            //constructor of Node class
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        //n->number of nodes
        private int n;
        //N->buckets.length (no. of buckets)
        private int N;
        //syntax of array having the data-type of linkedlist which is further of data-type Node.
        public LinkedList<Node> buckets[]; //N->buckets.length
        
        //constructor of HashMap class
        public HashMap() {
            this.N = 4;

            //initializing buckets array of size 4
            this.buckets = new LinkedList[4]; //datatype is linkedlist

            //declaring the linkedlist at each index of the bucket array
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>();
            } 
        }

        //this method will return the bucketIndex for the key-value pair
        private int hashFuntion(K key) {
            //key->hashCode()->value
            int hc = key.hashCode();
            //abs()-> this method return the absolute value of any integer
            return Math.abs(hc) % N;
        }

        //this method will return the index of the node whose key if present in the Linkedlist else return -1
        private int searchInLL(K key, int bucketIndex) {
            LinkedList<Node> list = buckets[bucketIndex];
            int dataIndex = 0;
            for(int i=0; i<list.size(); i++) {
                Node node = list.get(i);
                if(node.key == key) {
                    return dataIndex;
                }
                dataIndex++;
            }
            return -1;
        }

        //k -> threshold capacity constant 
        private double k = 2.0;

        private void rehashing() {
            //copying all values of bucket array into oldBucket array
            LinkedList<Node> oldBucket = buckets;
            //initializes bucket array with double size
            buckets = new LinkedList[N*2];
            //size doubled
            N = N*2;

            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            //traversing the oldBucket array 
            for(int i=0; i<oldBucket.length; i++) {
                LinkedList<Node> list = new oldBucket[i];
                //traversing linkedlist and adding each node into the expanded buckets array
                for(int j=0; j<list.size(); j++) {
                    Node node = list.get(j);
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value) {
            int bucketIndex = hashFuntion(key); //return a apropriate index for key-value pair
            int dataIndex = searchInLL(key, bucketIndex); //return whether the key is present or not
            if(dataIndex != -1) {
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }
            else { 
                Node newNode = new Node(key, value);
                buckets[bucketIndex].add(newNode);
                n++;
            }

            //Load factor -> lambda
            double lambda = (double)n/N; //(number of nodes)/(number of buckets)
            if(lambda > k) 
            {
            rehashing();
            }                   
        }
        public boolean containsKey(K key) {
            int bucketIndex = hashFuntion(key);
            int dataIndex = searchInLL(key, bucketIndex);
            if(dataIndex == -1) {
                return false;
            } else {
                return true;
            }
        }
        public V get(K key) {
            int bucketIndex = hashFuntion(key);
            int dataIndex = searchInLL(key, bucketIndex);
            if(dataIndex == -1) {
                return null;
            } else {
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }
        }
        public V remove(K key) {
            int bucketIndex = hashFuntion(key);
            int dataIndex = searchInLL(key, bucketIndex);
            if(dataIndex == -1) {
                return null;
            } else {
                Node node = buckets[bucketIndex].remove(dataIndex);
                return node.value;
            }
        }
}
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 120);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);    
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
    }
}
