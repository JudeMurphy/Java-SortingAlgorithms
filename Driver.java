public class Driver
{
	public static void main(String[] args) 
	{		
		
		int executionTimes = 0;
		double bubbleSortTime = 0;
		double selectionSortTime = 0;
		double insertionSortTime = 0;
		double heapSortTime = 0;
		double mergeSortTime = 0;
		
		while(executionTimes != 5)
		{
			double time1 = 0;
			double time2 = 0;
		
			int[] Array = SortTester.getArray();
			time1 = System.currentTimeMillis();
			Array = SortTester.BubbleSort(Array);
			time2 = System.currentTimeMillis();
			System.out.println("BUBBLESORT DONE IN: " + (time2 - time1)/1000 + " seconds.");
			
			bubbleSortTime = (time2 - time1)/1000 + bubbleSortTime;
			
			System.out.println("************");
			
			int[] Array2 = SortTester.getArray();
			time1 = System.currentTimeMillis();
			Array2 = SortTester.SelectionSort(Array2);
			time2 = System.currentTimeMillis();
			System.out.println("SELECTIONSORT DONE IN: " + (time2 - time1)/1000 + " seconds.");
			
			selectionSortTime = (time2 - time1)/1000 + selectionSortTime;
			
			System.out.println("************");
			
			int[] Array3 = SortTester.getArray();
			time1 = System.currentTimeMillis();
			Array3 = SortTester.InsertionSort(Array3);	
			time2 = System.currentTimeMillis();
			System.out.println("INSERTIONSORT DONE IN: " + (time2 - time1)/1000 + " seconds.");
			
			insertionSortTime = (time2 - time1)/1000 + insertionSortTime;
			
			System.out.println("************");
			
			int[] Array4 = SortTester.getArray();
			time1 = System.currentTimeMillis();
			Array4 = SortTester.HeapSort(Array4);
			time2 = System.currentTimeMillis();
			System.out.println("HEAPSORT DONE: " + (time2 - time1)/1000 + " seconds.");
			
			heapSortTime = (time2 - time1)/1000 + heapSortTime;
			
			System.out.println("************");
			
			int[] Array5 = SortTester.getArray();
			time1 = System.currentTimeMillis();
			Array5 = SortTester.mergeSort(Array5);
			time2 = System.currentTimeMillis();
			System.out.println("MERGESORT DONE: " + (time2 - time1)/1000 + " seconds.");
			
			mergeSortTime = (time2 - time1)/1000 + mergeSortTime;
			
			executionTimes++;
			System.out.println("\n");
			System.out.println("*** END OF ITERATION ***");
			System.out.println("\n");
		}
		
		System.out.println("BubbleSort Average: " + bubbleSortTime/executionTimes);
		System.out.println("SelectionSort Average: " + selectionSortTime/executionTimes);
		System.out.println("InsertionSort Average: " + insertionSortTime/executionTimes);
		System.out.println("HeapSort Average: " + heapSortTime/executionTimes);
		System.out.println("MergeSort Average: " + mergeSortTime/executionTimes);
	}
}
