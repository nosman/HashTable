/**
 * Created by stephanostsoucas on 3/15/14.
 */
public class HashTable<Key, Value> {
    //Array that stores the data
    Node<Key, Value>[] table;

    //Number of elements in the hashtable
    private int size = 0;


    //Adds the value v corresponding with key k. If k already exists in the hashtable,
    //v overwrites k's previously stored value
    
    public void put(Key k, Value v){

    }

    //Returns the value associated with key k, or null if k isn't in the hashtable
    
    public Value get(Key k){
        return null;
    }

    //Returns true if the hashtable has key k in it, else false
    
    public boolean containsKey(Key k){
        return false;
    }

    //Doubles the size of table, and re-inserts all key-value pairs
    private void rehash(){
        Node<Key, Value> temp[] = table;
        table = new Node[(2*size)];
        for (Node n : temp){
            put(n.k, n.v);
        }
    }

    //probing method
    private int nextFreeIndex(int start){
        int temp = start;
        while (table[temp] != null){
            temp++;
            if (temp >= table.length) temp = 0;
        }
        return temp;
    }

    //If load factor exceeds 0.5, return true, else false
    
    private boolean shouldRehash(){
        return true;
    }

    //Stores a single key-value pair
    private class Node<Key, Value> {
        Key k;
        Value v;

        public Node(Key k, Value v){
            this.k = k;
            this.v = v;
        }
    }
}
