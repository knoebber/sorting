package sorting;

public class InsertionSort extends Sorter {
	public InsertionSort(int[] vals) {
		super(vals);
	}
	public InsertionSort(int[] vals,SortingVisualizer vis) {
		super(vals,vis);
	}
	protected int[] sortVals(int[] vals) {
		int sortedUntil = 1;
		this.lastMoves.add(0);
		while(sortedUntil!=getSize()) {
			int i = sortedUntil;
			while(i>0 && vals[i-1]>vals[i]) 
				swap(vals,i,--i);
			this.lastMoves.add(i);
			moves++;
			sortedUntil ++;
		}
		return vals; 
	}
}
