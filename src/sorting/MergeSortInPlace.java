package sorting;

public class MergeSortInPlace extends Sorter {
	public MergeSortInPlace(int vals[]) {
		super(vals);
	}
	public MergeSortInPlace(int[] vals,SortingVisualizer vis) {
		super(vals,vis);
	}
	void wmerge(int vals[], int i, int m, int j, int n, int w) {
	    while (i < m && j < n)
	        swap(vals, w++, vals[i] < vals[j] ? i++ : j++);
	    while (i < m)
	        swap(vals, w++, i++);
	    while (j < n)
	        swap(vals, w++, j++);
	}  
	/* 
	 * sort vals[l, u), and put result to working area w. 
	 * constraint, len(w) == u - l
	 */
	public void wsort(int[] vals, int l, int u, int w) {
	    int m;
	    if (u - l > 1) {
	        m = l + (u - l) / 2;
	        imsort(vals, l, m);
	        imsort(vals, m, u);
	        wmerge(vals, l, m, m, u, w);
	    }
	    else
	        while (l < u)
	            swap(vals, l++, w++);
	}

	public void imsort(int[] vals, int l, int u) {
	    int m, n, w;
	    if (u - l > 1) {
	        m = l + (u - l) / 2;
	        w = l + u - m;
	        wsort(vals, l, m, w); /* the last half contains sorted elements */
	        while (w - l > 2) {
	            n = w;
	            w = l + (n - l + 1) / 2;
	            wsort(vals, w, n, l);  /* the first half of the previous working area contains sorted elements */
	            wmerge(vals, l, l + n - w, n, u, w);
	        }
	        for (n = w; n > l; --n) /*switch to insertion sort*/
	            for (m = n; m < u && vals[m] < vals[m-1]; ++m)
	                swap(vals, m, m - 1);
	    }
	}
	@Override
	protected int[] sortVals(int[] vals) {
		imsort(vals,0,vals.length);
		return vals;
	}
}
