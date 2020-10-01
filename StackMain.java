class StackMain {
  public static void main(String[] args) {
    stack s = new stack();
 
    Node a, b, c;
    a = new Node(10);
    b = new Node(20);
    c = new Node(30);
 
    s.pop();
    s.push(a);
    s.push(b);
    s.push(c);
 
    s.traversal();
    s.pop();
    s.traversal();
  }
}