package sorting;

import java.util.Arrays;

public abstract class Sorter {
	protected int[] values;
	protected int moves;
	//the last two indexes that were swapped
	protected int swapA;
	protected int swapB;
	protected long startTime;//measure the start time and stop of the program
	protected long stopTime;
	
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
		startTime = System.nanoTime();
		while(oneMove());
		stopTime = System.nanoTime();
	}
	/**
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
	 /** 
	  * print sorting stats
	  * 
	  * number of moves//TODO
	  * time elapsed
	 */
	public void printStats() {
		System.out.println("Sorters name: "+this.getClass().getName());
		System.out.println("Sorted "+this.getValues().length+" values");
		System.out.println(((double)(stopTime-startTime)/1000000000)+" seconds elapsed");
		System.out.println("");
	}
	
}
