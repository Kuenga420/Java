class Queue {
  public int head;
  public int tail;
  public int size;
  public int[] Q;

  public Queue(int size) {
    this.head = 1;
    this.tail = 1;
    this.Q = new int[size];
  }

  public boolean isEmpty() {
    if(this.tail == this.head)
      return true;
    return false;
  }

  public boolean isFull() {
    if(this.head == this.tail+1)
      return true;
    return false;
  }

  public void enqueue(int x) {
    if(isFull()) {
      System.out.println("Queue Overflow");
    }
    else {
      this.Q[this.tail] = x;
      if(this.tail == this.size)
        this.tail = 1;
      else
        this.tail = this.tail+1;
    }
  }

  public int dequeue() {
    if(isEmpty()) {
      System.out.println("Underflow");
      return -1000;
    }
    else {
      int x = this.Q[this.head];
      if(this.head == this.size) {
        this.head = 1;
      }
      else {
        this.head = this.head+1;
      }
      return x;
    }
  }

  public void display() {
    int i;
    for(i=this.head; i<this.tail; i++) {
      System.out.println(this.Q[i]);
      if(i == this.size) {
        i = 0;
      }
    }
  }

  public static void main(String[] args) {
    Queue q = new Queue(10);
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.enqueue(40);
    q.enqueue(50);
    q.display();

    System.out.println("");

    q.dequeue();
    q.dequeue();
    q.display();

    System.out.println("");

    q.enqueue(60);
    q.enqueue(70);
    q.display();
  }
}