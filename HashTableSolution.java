/**
 * Created by stephanostsoucas on 3/15/14.
 * Worked on by leomehr, 3/18/14
 */
public class HashTableSolution<Key, Value> {
    //Array that stores the data
    Node<Key, Value>[] table;

    //Number of elements in the hashtable
    private int size = 0;
    private static final int INIT_SIZE = 2;

    public HashTableSolution() {
        table = new Node[INIT_SIZE];
    }


    //Adds the value v corresponding with key k. If k already exists in the hashtable,
    //v overwrites k's previously stored value
    public void put(Key k, Value v){
        int index = nextFreeIndex(k.hashCode() % table.length);
        table[index] = new Node(k, v);
        size++;
        if (shouldRehash())
            rehash();
    }

    //Returns the value associated with key k, or null if k isn't in the hashtable
    public Value get(Key k){
        int index = k.hashCode() % table.length;
        while (table[index] != null) {
            Node n = table[index];
            if (n.k.equals(k))
                return (Value) n.v;
            index = (index + 1) % table.length;
        }
        return null;
    }

    //Returns true if the hashtable has key k in it, else false
    public boolean containsKey(Key k) {
        int index = k.hashCode() % table.length;
        while (table[index] != null) {
            Node n = table[index];
            if (n.k.equals(k))
                return true;
            index = (index + 1) % table.length;
        }
        return false;
    }

    //Doubles the size of table, and re-inserts all key-value pairs
    private void rehash(){
        Node<Key, Value> temp[] = table;
        table = new Node[(2*table.length)];
        for (Node n : temp){
            if (n != null)
                put((Key) n.k, (Value) n.v);
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
        return (double) size / table.length > 0.5;
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
