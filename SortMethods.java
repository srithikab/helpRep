import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;  
import java.util.Scanner;		// for testing purposes

/**
 *	SortMethods - Sorts an ArrayList of Strings in ascending order.
 *
 *	Requires FileUtils class to compile.
 *	Requires file randomWords.txt to execute a test run.
 *
 *	@author	Srithika Barakam
 *	@since	1/15/2025
 */
public class SortMethods {
	
	/**
	 *	Merge Sort algorithm - in ascending order
	 *	@param arr		List of String objects to sort
	 */
	public void mergeSort(List<String> arr) {
		String[] list = new String[arr.size()];
		for(int i = 0; i<arr.size(); i++)
			list[i] = arr.get(i);
		mergeSortRecurse(list, 0, arr.size() - 1);
		
		for(int i = 0; i<arr.size(); i++){
			arr.set(i, list[i]);
		}
	}
	
	/**
	 *	Recursive mergeSort method.
	 *	@param arr		List of String objects to sort
	 *	@param first	first index of arr to sort
	 *	@param last		last index of arr to sort
	 */
	public void mergeSortRecurse(String[] arraY, int first, int last) {
		if (first < last) {
          
            int m = (first + last) / 2;

            // Sort first and second halves
            mergeSortRecurse(arraY, first, m);
            mergeSortRecurse(arraY, m + 1, last);

            // Merge the sorted halves
            merge(arraY, first, m, last);
        }
	}
	
	/**
	 *	Merge two lists that are consecutive elements in array.
	 *	@param arr		List of String objects to merge
	 *	@param first	first index of first list
	 *	@param mid		the last index of the first list;
	 *					mid + 1 is first index of second list
	 *	@param last		last index of second list
	 */
	public void merge(String[] arr, int first, int mid, int last)
    {

        int n1 = mid - first + 1;
        int n2 = last - mid;

        String[] First = new String[n1];
        String[] Last = new String[n2];

        for (int i = 0; i < n1; ++i)
            First[i] = arr[first + i];

        for (int j = 0; j < n2; ++j)
			Last[j] = arr[mid + 1 + j];

        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        int k = first;
        while (i < n1 && j < n2) {
            if (First[i].compareTo(Last[j])<=0) {
                arr[k] = First[i];
                i++;
            }
            else {
                arr[k] = Last[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = First[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = Last[j];
            j++;
            k++;
        }
    }

	
	/**
	 *	Print an List of Strings to the screen
	 *	@param arr		the List of Strings
	 */
	public void printArray(List<String> arr) {
		if (arr.size() == 0) System.out.print("(");
		else System.out.printf("( %-15s", arr.get(0));
		for (int a = 1; a < arr.size(); a++) {
			if (a % 5 == 0) System.out.printf(",\n  %-15s", arr.get(a));
			else System.out.printf(", %-15s", arr.get(a));
		}
		System.out.println(" )");
	}
	
	/*************************************************************/
	/********************** Test program *************************/
	/*************************************************************/
	private final String FILE_NAME = "randomWords.txt";
	
	public static void main(String[] args) {
		SortMethods se = new SortMethods();
		se.run();
	}
	
	public void run() {
		List<String> arr = new ArrayList<String>();
		// Fill List with random words from file		
		fillArray(arr);
		
		System.out.println("\nMerge Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		mergeSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();
	}
	
	// Fill String array with words
	public void fillArray(List<String> arr) {
		Scanner inFile = FileUtils.openToRead(FILE_NAME);
		while (inFile.hasNext())
			arr.add(inFile.next());
		inFile.close();
	}
}
