public class InsertionSort
{
   
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
            
            
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
    
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println("Sorted");
    }
  
    public static void main(String args[])
    {
        int arr[] = {1,4,5,6,7,3,10,8,9,2};
        InsertionSort s = new InsertionSort();
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println("Unsorted");

        s.sort(arr);
     
        printArray(arr);
    }
}