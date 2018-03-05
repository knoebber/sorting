package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Sorter {
	protected int[] values;
	protected int moves = 0;
	//contains the last indexes that were moved
	protected ArrayList<Integer> lastMoves = new ArrayList<Integer>();
	private long startTime;//measure the start time and stop of the program
	private long stopTime;
	protected SortingVisualizer vis;
	
	public Sorter(int[] vals) {
		this.values = vals;
	}
	public Sorter(int[] vals, SortingVisualizer vis) {
		this.values = vals;
		this.vis = vis;
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
		return lastMoves.contains(index);
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
		this.values = this.sortVals(this.values);
		stopTime = System.nanoTime();
	}
	/**
	 * does the work for sort()
	 */
	protected abstract int[] sortVals(int vals[]);
	/**
	 * swaps vals at a for vals at b
	 */
	protected void swap(int vals[],int a,int b) {
		
		int temp = vals[a];
		vals[a] = vals[b];
		vals[b] = temp;
		if(vis!=null) 
			vis.refresh();

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