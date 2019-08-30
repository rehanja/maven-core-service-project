package hms.intern;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		getInput(args);

	}
//method that get input
	public static void getInput(String[] args) {
		int[] array = new int[args.length]; 
		
		System.out.println("Elements of the array you entered");
		for (int i = 0; i < args.length; i++){
			array[i] = Integer.parseInt(args[i]); 
			System.out.println(array[i]);
 
	}

	process(array);
	
	}

	public static void process(int[] array) {
		SortProcess object = new SortProcess();

//selection sort
		long startTime = System.nanoTime();
		System.out.println("selection sort");
		object.selectionSort(Arrays.copyOf(array, array.length));

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;

		System.out.println("Selection Execution time in nanoseconds  : " + timeElapsed);
		System.out.println("");

//bubble sort
		startTime = System.nanoTime();
		System.out.println("bubble sort");
		object.bubbleSort(Arrays.copyOf(array, array.length));
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("bubble Execution time in nanoseconds  : " + timeElapsed);
		System.out.println("");

//insertion sort
		startTime = System.nanoTime();
		System.out.println("insertion sort");
		object.insertionSort(Arrays.copyOf(array, array.length));
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("insertion Sort time in nanoseconds  : " + timeElapsed);
		System.out.println("");
		

	}

}
//the interface 

interface SortInterface {
	public void selectionSort(int[] array); // interface method (does not have a body)
	public void insertionSort(int[] array);
	public void bubbleSort(int[] array); // interface method (does not have a body)
	public void getOutput(int[] array);
  }


// class that containt logic of sort processes
class SortProcess implements SortInterface {

	public  void selectionSort(int[] arr) {
		// one by one move boundary of unsorted sub array
		for (int i = 0; i < arr.length - 1; i++) {

			// this is the pivot index
			// if unsorted sub array has minimum value than value represented
			// by this index, the values get swapped
			int minIndex = i;

			// find the minimum element in unsorted sub array
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			if (i != minIndex) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}

		}

		getOutput(arr);
		

	}

	public  void bubbleSort(int[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - j - 1; i++) {
				// if i'th element is larger than (i + 1)'th element, swap them
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
		getOutput(arr);
		

	}

	public  void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			// get first element of unsorted part
			int key = arr[i];

			// iterate through sorted list from top to botton
			// iterate until it finds lesser element than key
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				// shift elements to right
				arr[j + 1] = arr[j];
				// decrement counter
				j--;
			}
			arr[j + 1] = key;
		}
		getOutput(arr);
		
	}
//method that print output
	public  void getOutput(int[] array) {

		for (int f = 0; f < array.length; f++) {
			System.out.print(array[f] + "-");
		}
	}

}


