public class Array_List
{
	double full_1by4 = 0.25;
	double full_3by4 = 0.75;
	int size_limit = 4;
	static int a;
	int remove;
	int top = 0;
	static double length;
	static int Array[];
	public Array_List()
	{
		Array = new int[size_limit];
	}
	public void add(int e)
	{
		Array[top] = e;
		top++;
	}
	public void pop()
	{
		top--;
		remove = Array[top];
		Array[top] = 0;
		int count = 0;
		for(int i = 0; i < Array[i]; i++) {
			count++;
		}
		a = count;
		length = (double)a/size_limit;
		System.out.println("Removing Element " +remove);
	}
	
	public void resize()
	{
		if(length == full_1by4 ) {
			int newArray[] = new int[(size_limit/2)*2];  //resizing by 1/4
			for(int i = 0; i < Array.length; i++) {
				newArray[i] = Array[i];
			}
			Array = newArray;
			size_limit = size_limit/2;
			for(int n : newArray) {
				System.out.print(n + " ");
				}	
		}
		else if(length == full_3by4) {                 //resizing by 3/4
			int newArray[] = new int[size_limit*2];   
			for(int i = 0; i < Array.length; i++) {
				newArray[i] = Array[i];
			}
			size_limit = size_limit * 2;
			Array = newArray;
			for(int j : newArray) {
			System.out.print(j + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("ArrayIndexOutOfBoundRange");
		}
	}
	public int size()
	{
		return size_limit;
	}
	public String toString()
	{
		String s = Integer.toString(size_limit);
		return s;
	}




	public static void main(String[] args) {
		ArrayList s = new ArrayList();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.pop();
		s.resize();
		System.out.println("toString "+s.toString());
		s.pop();
		s.resize();
		System.out.println("");
		System.out.println("The number of elements in the new Array is "+a);
		System.out.println("The Size of new Array is "+s.size());
	}
}