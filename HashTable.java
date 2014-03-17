/**
 * Created by stephanostsoucas on 3/15/14.
 */
public class HashTable<Key, Value> {
    Node<Key, Value>[] table;
    private int size = 0;
    private double loadFactor = 0.5;

    public void put(Key k, Value v){

    }

    public Value get(Key k){
        return null;
    }

    public boolean containsKey(Key k){
        return false;
    }

    private void rehash(){
        Node[] newTable = new Node[(2*size)];
        for (Node n : table){
            
        }
    }

    private int nextFreeIndex(int start){
        int temp = start;
        while (table[temp] != null){
            temp++;
            if (temp >= table.length) temp = 0;
        }
        return temp;
    }

    private boolean shouldRehash(){
        return true;
    }

    private class Node<Key, Value> {
        Key k;
        Value v;

        public Node(Key k, Value v){
            this.k = k;
            this.v = v;
        }
    }
}
