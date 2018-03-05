package sorting;

public class BubbleSort extends Sorter {

	public BubbleSort(int[] vals) {
		super(vals);
	}
	public BubbleSort(int[] vals,SortingVisualizer vis) {
		super(vals,vis);
	}
	
	public int[] sortVals(int vals[]) {
		boolean swapped = true;
		while(swapped) {
			swapped = false;
			for (int i = 0; i < vals.length - 1; i++) {
				if (vals[i] > vals[i + 1]) {
					swap(vals,i, i + 1);
					swapped = true;
				}
			}
		}
		return vals;
	}
}
