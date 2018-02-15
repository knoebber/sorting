package sorting;

import java.util.Arrays;

public abstract class Sorter {
	protected int[] values;
	protected int moves;
	//the last two indexes that were swapped
	protected int swapA;
	protected int swapB;
	
	public Sorter(int[] vals) {
		this.values = vals;
		this.moves = 0;
		this.swapA = -1;
		this.swapB = -1;
	}
	public int getMoves() {
		return this.moves;
	}
	public int[] getValues() {
		return values;
	}
	/**
	 * determines whether the index was swapped on the last move
	 */
	public boolean indexWasSwapped(int index) {
		return index == swapA || index == swapB;
	}
	/**
	 * returns the length of values
	 */
	public int getSize() {
		return this.values.length;
	}
	/**
	 * prints values
	 */
	public void printValues() {
		System.out.println(Arrays.toString(this.values));
	}
	/**
	 * sorts values
	 */
	public void sort() {
		while(oneMove());
	}
	/**
	 * does one swap on values
	 * returns true if there are still moves left to be made
	 * returns false if values is sorted
	 */
	public abstract boolean oneMove();
		
	/**
	 * swaps values at a for values at b
	 */
	protected void swap(int a,int b) {
		int temp = this.values[a];
		this.values[a] = this.values[b];
		this.values[b] = temp;
	}
	
}
