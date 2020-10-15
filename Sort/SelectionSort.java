public class SelectionSort{
	 void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_index = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_index]) 
                    min_index = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_index]; 
            arr[min_index] = arr[i]; 
            arr[i] = temp; 
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
        int arr[] = {10, 11, 31, 43, 23, 32, 12, 13};
        SelectionSort ob = new SelectionSort();
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println("Unsorted");

        ob.sort(arr);
        printArray(arr);
    }



}