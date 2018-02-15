package sorting;

import java.util.Arrays;
import java.util.Random;

public class Main {
	static final int MAX_SIZE = 500;// the maximum random number

	public static void main(String args[]) {
		int[] arr = getRandomArray(100);
		Sorter bubbleSorter = new BubbleSort(arr);
		Sorter insertionSorter = new InsertionSort(arr);
		visualize(bubbleSorter);
	}

	public static void visualize(Sorter sort) {
		SortingVisualizer vis = new SortingVisualizer(sort);
		vis.setVisible(true);
		vis.visualize();

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
}
