package sorting;

import java.util.Arrays;
import java.util.Random;

public class Main {
	static final int MAX_SIZE = 500; // 500;// the maximum random number

	public static void main(String args[]) throws Exception {
		/*
		Sorter i = new InsertionSort(getRandomArray(200),vis);
		vis.setVisible(true);
		vis.setSorter(i);
		i.sort();
		int test = 1000;
		int size = 300;
		System.out.println(test/size);
		System.out.println(test%size);
		mip.sort();
		mip.printValues();
		SortingVisualizer vis = new SortingVisualizer();
		Sorter mip = new MergeSortInPlace(getRandomArray(300),vis);
		vis.setVisible(true);
		vis.setSorter(mip);
		mip.sort();
		*/
		visualizeSuite();
		
	}
	public static void visualizeSuite() throws Exception {
		int size = 100;
		SortingVisualizer vis = new SortingVisualizer();
		int[][] sortingArrays = { getRandomArray(size), getReverseOrderArray(size), getMostlySortedArray(size) };
		String[] sortingNames = { "Random Array", "Reverse Order Array", "Mostly Sorted Array" };
		int nameIndex = 0;
		vis.setVisible(true);
		for (int[] arr : sortingArrays) {
			System.out.println("--- "+sortingNames[nameIndex++]+" ---");
			Sorter sorts[] = { 
				new BubbleSort(arr.clone(),vis),
				new InsertionSort(arr.clone(),vis),
				new MergeSortInPlace(arr.clone(),vis)
			};
			for (Sorter s : sorts) {
				System.out.println(s.getClass().getName());
				vis.setSorter(s);
				s.sort();
			}
		}

		
	}
	public static void testSuite() {
		int size = 100000;
		// set up arrays for testing
		int[][] sortingArrays = { getRandomArray(size), getReverseOrderArray(size), getMostlySortedArray(size) };
		String[] sortingNames = { "Random Array", "Reverse Order Array", "Mostly Sorted Array" };
		int nameIndex = 0;
		for (int[] arr : sortingArrays) {
			System.out.println("--- "+sortingNames[nameIndex++]+" ---");
			Sorter sorts[] = { 
				new MergeSortInPlace(arr.clone()),
				new MergeSort(arr.clone()),
				new InsertionSort(arr.clone()),
				new BubbleSort(arr.clone())
			};
			for (Sorter s : sorts) {
				s.sort();
				s.printStats();
			}
		}
	}
	/**
	 * generate array with random values
	 */
	public static int[] getRandomArray(int size) {
		int[] arr = new int[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			int val = rand.nextInt(MAX_SIZE + 1);
			arr[i] = val;
		}
		return arr;
	}

	/**
	 * generate array reversed sorted
	 */
	public static int[] getReverseOrderArray(int size) {
		int[] arr = new int[size];
		int index = 0;
		for (int i = size - 1; i >= 0; i--) {
			arr[index++] = i;
		}
		return arr;
	}

	/**
	 * gets array that has a few random numbers but is otherwise sorted 
	 */
	public static int[] getMostlySortedArray(int size) {
		if (size < 5)
			return new int[5];
		int mid = size / 2;
		int arr[] = new int[size];
		Random rand = new Random();
		int insertions = 3;
		for (int i = 0; i < size; i++)
			arr[i] = i;
		for(int j = 0; j<insertions;j++)
			arr[rand.nextInt(arr.length)] = rand.nextInt(size);
		
		return arr;

	}

}
