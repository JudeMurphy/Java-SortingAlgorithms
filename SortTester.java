import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class SortTester 
{
	public static int[] getArray()
	{
		Random r = new Random();

		int [] newArray = new int[200000];
		for(int i = 0; i < newArray.length; i++)
		{
			int negOrPos = r.nextInt() % 2;
			if(negOrPos == 0)
			{
				newArray[i] = r.nextInt() % 10000;
			}
			else
			{
				newArray[i] = (r.nextInt() % 10000) - 10000;
			}
		}
		
		return newArray;
	}
	
	public static int[] BubbleSort(int[] num)
	{
	     for(int i = 0; i < num.length-1; i++)
	     {
	            for(int j = i + 1;  j < num.length;  j++)
	            {
	                   if (num[i] > num[j]) 
	                   {
	                	   int temp = num[i];
	                	   num[i] = num[j];
	                	   num[j] = temp;
	                  } 
	            } 
	      }
		return num; 
	} 

	public static int[] SelectionSort (int [] num)
	{
         int first = 0;   
	     int temp = 0; 
         
	     for (int i = 0; i < num.length; i++)  
	     {
	          for(int j = 1; j <= i; j ++)   
	          {
	               if(num[j] < num[first])      
	               {
	                 first = j;
	               }
	          }
	          
	          temp = num[first];  
	          num[first] = num[i];
	          num[i] = temp; 
	      }           
	     return num;
	}
	
	public static int[] InsertionSort(int [] num)
	{
	     for (int i = 0; i < num.length; i++)
	    {
	          for(int j = i; (j>0) && (num[j] < num[j-1]); j--) 
	          {
		          int temp = num[j];
		          num[j] = num[j-1];
		          num[j-1] = temp; 
	          }
	    }
		return num;
	}
	
	public static int[] HeapSort(int [] num)
	{
		PriorityQueue<Integer> MyQueue = new PriorityQueue<Integer>();
		
		int numLength = num.length-1;
		int totalLength = (num.length * 2) - 1;
		int index = 0;
		
		for(int i = 0; i < totalLength; i++)
		{
			if(i < (totalLength - numLength))
			{
				MyQueue.add(num[i]);
			}
			else
			{
				num[index] = MyQueue.remove();
				index = index + 1;
			}
		}
		return num;
	}
	
	public static int[] mergeSort(int[] A) 
	{
        if (A.length > 1) 
        {
            int q = A.length/2;

            int[] leftArray = Arrays.copyOfRange(A, 0, q);
            int[] rightArray = Arrays.copyOfRange(A, q, A.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(A,leftArray,rightArray);
        }
		return A;
    }

    public static void merge(int[] a, int[] l, int[] r) 
    {
        int totElem = l.length + r.length;
        int i, li, ri;
        i = li = ri = 0;
        while ( i < totElem) 
        {
            if ((li < l.length) && (ri<r.length)) 
            {
                if (l[li] < r[ri]) 
                {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else 
                {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) 
                {
                    while (ri < r.length) 
                    {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) 
                {
                    while (li < l.length)
                    {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
    }
}
