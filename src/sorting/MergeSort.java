package sorting;

public class MergeSort extends Sorter {
	public MergeSort(int[] vals) {
		super(vals);
	}
	protected int[] sortVals(int vals[]) {
		if(vals.length<=1)
			return vals;
		int mid = vals.length/2;
		int left[]  = new int[mid];
		int right[] = new int[vals.length%2==0?mid:mid+1];
		int leftIndex  = 0;
		int rightIndex = 0;
		
		for (int i =0; i<vals.length;i++) {
			if(i<mid)
				left[leftIndex++]=vals[i];
			else {
				right[rightIndex++]=vals[i];
			}
		}
		left  = sortVals(left);
		right = sortVals(right);
		return merge(left,right);
	}
	public int[] merge(int left[],int right[]) {
		int result[] = new int[left.length+right.length];
		int leftIndex   = 0;
		int rightIndex  = 0;
		int resultIndex = 0;
		while(leftIndex<left.length && rightIndex<right.length) {
			if(left[leftIndex]<=right[rightIndex]) 
				result[resultIndex++] = left[leftIndex++];
			else
				result[resultIndex++] = right[rightIndex++];
		}
		while(leftIndex<left.length) 
			result[resultIndex++] = left[leftIndex++];
		while(rightIndex<right.length) 
			result[resultIndex++] = right[rightIndex++];
		return result;
	}
}
