package sorting;

import java.util.Arrays;
import java.util.Random;

public class Main {
	static final int MAX_SIZE = 10;//the maximum random number 
	
	public static void main(String args[]) {
		int[] test = getRandomArray(10);
		BubbleSort bubbleSorter = new BubbleSort(test);
		bubbleSorter.printValues();
		bubbleSorter.sort();
		bubbleSorter.printValues();
	}
	
	public static int[] getRandomArray(int size) {
		int[] arr = new int[size];
		Random rand = new Random();
		for(int i=0;i<size;i++) {
			int val = rand.nextInt(MAX_SIZE+1);
			arr[i] = val;
		}
		return arr;
	}
}
