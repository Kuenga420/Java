 class stack {
  public static int limit_size = 10;
  public static int top = 0;
   public static int size = 0;

  public static int[] s = new int[limit_size];

  public static boolean isEmpty() {
    if(size == 0)
      return true;
    return false;
  }

  public static int top(){
    if (top==-1){
      return 0;
    }

      return s[top];
    }


  public static void push(int x) {
    if(size==0){
      s[0]=x;
      top=0;
    }
    else{
      s[top+1]=x;
      top++;

    }
    size=size+1;
  }

  public static int pop() {
    if(size==0){
      System.out.println("The stack is empty");
    }
    else{
      top=s[top-1];
      size=size-1;
    }
    return s[top+1];
      

  }
  

  public static int size(){
  	return size;
  	
  }

  
  public static void main(String[] args) {
    pop();
    push(10);
    push(20);
    push(30);
    push(40);
    push(50);
    push(60);
    push(70);
    push(80);
    push(90);
    
    

    for(int i=1; i<=size; i++) {
      System.out.println(s[i]);
    }
    System.out.println("this is the size: "+size()+" and the top: "+ top()+ isEmpty());
  }
}