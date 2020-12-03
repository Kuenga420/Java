import java.util.*;
public class SequentialSearchST<Key, Value> {
    private int n;           //number of key-value pairs
    private Node first;      // the linked list ofkey-value pairs

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key,Value val, Node next) {
           this.key = key;
           this.val = val;
           this.next = next;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public SequentialSearchST() {
    }

    /**
     * Returns the number of key-value pairs inthis symbol table.
     * @return the number of key-value pairs inthis symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Is this symbol table empty?
     * @return {@code true} if this symboltable is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() ==0;
    }

    /**
     * Does this symbol table contain the givenkey?
     * @param key the key
     * @return {@code true} if this symboltable contains {@code key} and
     *     {@code false}otherwise
     */
    public boolean contains(Key key) {
        return get(key) !=null;
    }

    /**
     * Returns the value associated with thegiven key.
     * @param key the key
     * @return the value associated with thegiven key if the key is in the symbol table
     *     and {@code null}if the key is not in the symbol table
     */
    public Value get(Key key) {
        for (Node x = first; x!= null; x = x.next) {
           if (key.equals(x.key))
               return x.val;
        }
        return null;
    }

    /**
     * Inserts the key-value pair into thesymbol table, overwriting the old value
     * with the new value if the key is alreadyin the symbol table.
     * If the value is {@code null}, thiseffectively deletes the key from the symbol table.
     * @param key the key
     * @param val the value
     */
    public void put(Key key, Value val) {
        if (val == null) {
           delete(key);
           return;
        }

        for (Node x = first;x != null; x = x.next) {
           if (key.equals(x.key)) {
               x.val = val;
               return;
           }
        }
        first = new Node(key,val, first);
        n++;
    }

    /**
     * Removes the key and associated valuefrom the symbol table
     * (if the key is in the symboltable).
     * @param key the key
     */
    public void delete(Key key) {
        first = delete(first,key);
    }

    // delete key in linked list beginning atNode x
    // warning: function call stack too large iftable is large
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)){
           n--;
           return x.next;
        }
        x.next = delete(x.next,key);
        return x;
    }


    /**
     * Returns all keys in the symbol table asan {@code Iterable}.
     * To iterate over all of the keys in thesymbol table named {@code st},
     * use the foreach notation: {@code for(Key key : st.keys())}.
     * @return all keys in the symbol table asan {@code Iterable}
     */
    public Iterable<Key> keys() {
        LinkedList<Key> queue = new LinkedList<Key>();
        for (Node x = first; x!= null; x = x.next)
           queue.add(x.key);
        return queue;
    }

}