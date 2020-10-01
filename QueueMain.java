class Node {
  public int data;
  public Node next;

  public Node(int data) {
    this.data = data;
    next = null;
  }
}

class Queue {
  public Node head;
  public Node tail;

  public Queue() {
    head = null;
    tail = null;
  }

  public void traversal() {
    Node temp = this.head; //temporary pointer to point to head

    while(temp != null) { //iterating over queue
      System.out.print(temp.data+"\t");
      temp = temp.next;
    }

    System.out.println("");
  }

  public boolean isEmpty() {
    if(this.head == null)
      return true;
    return false;
  }

  public void enqueue(Node n) {
    if(isEmpty()) {
      this.head = n;
      this.tail = n;
    }
    else {
      this.tail.next = n;
      this.tail = n;
    }
  }

  public int dequeue() {
    if(this.isEmpty()) {
      System.out.println("Queue Underflow\n");
      return -1000;
    }
    else {
      int x = this.head.data;
      Node temp = this.head;
      this.head = this.head.next;
      return x;
    }
  }
}

public class QueueMain {
  public static void main(String[] args) {
    Queue q = new Queue();

    Node a, b, c;
    a = new Node(10);
    b = new Node(20);
    c = new Node(30);

    q.dequeue();
    q.enqueue(a);
    q.enqueue(b);
    q.enqueue(c);

    q.traversal();
    q.dequeue();
    q.traversal();
  }
}