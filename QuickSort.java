public class QuickSort {
	public static int[] data = {0,0};	//comparison, movement
	public static int[] quickSort(Integer[] list) {
		quickSort(list, 0, list.length-1);
		int[] t = data;
		data = new int[]{0,0};
		return t;
	}
	
	public static void quickSort(Integer[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex -1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	/** Partition the array list[first..last] */
	public static int partition(Integer[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		while (high > low) {
			// Search forward from left
			while (low <= high && list[low] <= pivot){
				low++;
				data[0]++;
			}
			
			// Search backward from right
			while (low <= high && list[high] > pivot){
				high--;
				data[0]++;
			}
			
			//	Swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
				data[1]++;
			}
		}
		
		while (high > first && list[high] >= pivot){
			high--;
			data[0]++;
		}
		
		//	Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot; 
			data[1]++;
			data[0]++;
			return high;
		}
		else {
			return first;
		}
	}
}
