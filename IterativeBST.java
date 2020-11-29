import java.util.*;
public class IterativeBST<Key extends Comparable, Val> {

    private Node root;          // root of BST

    private class Node {
        private Key key;              // sorted by key
        private Val val;              // associated data
        private Node left, right;     // left and right subtrees

        public Node(Key key, Val val) {
            this.key = key;
            this.val = val;
        }
    }


   /***************************************************************************
    *  Insert item into BST, nonrecursive version
    ***************************************************************************/
    public void put(Key key, Val val) {
        Node z = new Node(key, val);
        if (root == null) {
            root = z;
            return;
        }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int res = key.compareTo(x.key);
            if      (res < 0) x = x.left;
            else if (res > 0) x = x.right;
            else {
                x.val = val;
                return;
            }   // overwrite duplicate
        }
        int res = key.compareTo(parent.key);
        if (res < 0) parent.left  = z;
        else         parent.right = z;
    }
   

   /***************************************************************************
    *  Search BST for given key, nonrecursive version
    ***************************************************************************/
    public Val get(Key key) {
        Node x = root;
        while (x != null) {
            int res = key.compareTo(x.key);
            if      (res < 0) x = x.left;
            else if (res > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    // is the given key in the symbol table?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // return size of tree (linear time operation)
    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }


    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

     public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) throw new NoSuchElementException("argument to floor() is too small");
        else return x.key;
    } 

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key); 
        if (t != null) return t;
        else return x; 
    } 

     public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        return select(root, k);
    }

    // Return key in BST rooted at x of given rank.
    // Precondition: rank is in legal range.
    private Key select(Node x, int k) {
        if (x == null) return null;
        int leftSize = size(x.left);
        if      (leftSize > k) return select(x.left,  k);
        else if (leftSize < k) return select(x.right, k - leftSize - 1); 
        else                      return x.key;
    }

     public Iterable<Key> keys() {
        Stack<Node> stack = new Stack<Node>();
        ArrayList<Key> queue = new ArrayList<Key>();
        Node x = root;
        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            }
            else {
                x = stack.pop();
                queue.add(x.key);
                x = x.right;
            }
        }
        return queue;
    }
    



   /***************************************************************************
    *  Test client.
    ***************************************************************************/
    public static void main(String[] args) { 
       
        IterativeBST<String, Integer> st = new IterativeBST<String, Integer>();

        st.put("Abdul", 1);
        int a = st.get("Abdul");
        System.out.println(a);
        st.put("Hrithik", 2);
        st.put("Sai",3);
        st.put("Samal",6);
        int b = st.get("Sai");
        System.out.println(b);
        st.put("Tashi",4);
        int size = st.size();
        System.out.println(size);
        String min = st.min();
        System.out.println(min);
        String f1 = st.floor("Hrithik");
        System.out.println(f1);
        String f2 = st.floor("Haha");
        System.out.println(f2);
        String s1 = st.select(2);
        System.out.println(s1);
        
        for (String s : st.keys()) 
            System.out.print(s+ " "); 

        st.put("Chimi", 5);
        st.put("Samal",4);
        int c = st.get("Samal");
        System.out.println("\n"+c);
        st.put("Nima",7);
        int size1 = st.size();
        System.out.println(size1);
        int d = st.get("Chimi");
        System.out.println(d);
        String f3 = st.floor("Chima");
        System.out.println(f3);
        st.put("Sonam",8);
        st.put("Tashi",9);

        for (String s : st.keys()) 
            System.out.print(s+ " ");


        
    }

}
