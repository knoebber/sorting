package sorting;

public class BubbleSort extends Sorter {

	public BubbleSort(int[] vals) {
		super(vals);
	}

	public void sort() {
		boolean swapped;
		while (true) {
			swapped = false;
			for (int i = 0; i < this.values.length - 1; i++) {
				if (this.values[i] > this.values[i + 1]) {
					swap(i, i + 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}
}
