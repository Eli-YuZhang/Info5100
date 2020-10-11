package Assignment4;

//Assumptions: 1. array is not null; 2. 1 <= k <= array.length

public class KthLargestElement {
	public int kthLargest(int[] array, int k) {
		// corner case
		if (array.length < 1) {
			return 0;
		}
		// selection sort
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
		// return kth largest
		return array[array.length - k];
	}

	public void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
