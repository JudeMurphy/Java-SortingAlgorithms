import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class SortTester 
{
	/**
     * Returns an array of 200000 elements, with half of the elements being negative numbers between -10000 and 0, 
     * and the other half being positive numbers between 0 and 10000
     */
    public static int[] getArray() {
        Random r = new Random();
        int[] newArray = new int[200000];
        for (int i = 0; i < newArray.length; i++) {
            int negOrPos = r.nextInt() % 2;
            newArray[i] = (negOrPos == 0) ? (r.nextInt() % 10000) : ((r.nextInt() % 10000) - 10000);
        }
        return newArray;
    }

    /**
     * Sorts the input array using the Bubble sort algorithm
     */
    public static int[] bubbleSort(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        return num;
    }

    /**
     * Sorts the input array using the Selection sort algorithm
     */
    public static int[] selectionSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            int first = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[first]) {
                    first = j;
                }
            }
            int temp = num[first];
            num[first] = num[i];
            num[i] = temp;
        }
        return num;
    }

    /**
     * Sorts the input array using the Insertion sort algorithm
     */
    public static int[] insertionSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int key = num[i];
            int j = i - 1;
            while (j >= 0 && num[j] > key) {
                num[j + 1] = num[j];
                j = j - 1;
            }
            num[j + 1] = key;
        }
        return num;
    }

    /**
     * Sorts the input array using the Heap sort algorithm
     */
    public static int[] heapSort(int[] num) {
        PriorityQueue<Integer> MyQueue = new PriorityQueue<>();
        int numLength = num.length - 1;
        int totalLength = (num.length * 2) - 1;
        int index = 0;
        for (int i = 0; i < totalLength; i++) {
            if (i < (totalLength - numLength)) {
                MyQueue.add(num[i]);
            } else {
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

    public static int[] mergeSort(int[] A) {
  // Base case: if the array has only one element, return it
  if (A.length > 1) {
    // Divide the array into two halves
    int q = A.length / 2;
    int[] leftArray = Arrays.copyOfRange(A, 0, q);
    int[] rightArray = Arrays.copyOfRange(A, q, A.length);

    // Recursively sort both halves
    mergeSort(leftArray);
    mergeSort(rightArray);

    // Merge the sorted halves
    merge(A, leftArray, rightArray);
  }
  // Return the sorted array
  return A;
}

public static void merge(int[] a, int[] l, int[] r) {
  // Initialize variables to keep track of the indices in the left and right arrays, and the total number of elements
  int totElem = l.length + r.length;
  int i = 0, li = 0, ri = 0;

  // Merge the two arrays
  while (i < totElem) {
    if (li < l.length && ri < r.length) {
      // If the current element in the left array is smaller than the current element in the right array, add the element from the left array to the final array
      if (l[li] < r[ri]) {
        a[i] = l[li];
        i++;
        li++;
      } else {
        // If the current element in the right array is smaller than the current element in the left array, add the element from the right array to the final array
        a[i] = r[ri];
        i++;
        ri++;
      }
    } else {
      if (li >= l.length) {
        // If we have reached the end of the left array, add the remaining elements from the right array to the final array
        while (ri < r.length) {
          a[i] = r[ri];
          i++;
          ri++;
        }
      }
      if (ri >= r.length) {
        // If we have reached the end of the right array, add the remaining elements from the left array to the final array
        while (li < l.length) {
          a[i] = l[li];
          i++;
          li++;
        }
      }
    }
  }
}
