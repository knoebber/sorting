package sorting;

public class BubbleSort extends Sorter {

	public BubbleSort(int[] vals) {
		super(vals);
	}

	public boolean oneMove() {
		boolean swapped = false;
		for (int i = 0; i < this.values.length - 1; i++) {
			if (this.values[i] > this.values[i + 1]) {
				swap(i, i + 1);
				swapA = i;
				swapB = i+i;
				swapped = true;
			}
		}
		this.moves ++;
		return swapped;
	}
}
