package sorting;

import java.util.Arrays;

public abstract class Sorter {
	protected int[] values;
	protected int moves;
	
	public Sorter(int[] vals) {
		this.values = vals;
		this.moves = 0;
	}
	public int getMoves() {
		return this.moves;
	}
	public int[] getValues() {
		return this.getValues();
	}
	public void printValues() {
		System.out.println(Arrays.toString(this.values));
	}
	public abstract void sort();
		
	/**
	 * swaps values at a for values at b
	 */
	protected void swap(int a,int b) {
		int temp = this.values[a];
		this.values[a] = this.values[b];
		this.values[b] = temp;
	}
	
}
