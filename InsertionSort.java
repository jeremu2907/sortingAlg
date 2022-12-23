
public class InsertionSort {
	/**The method for sorting the numbers */
	public static int[] insertionSort(Integer[] list) {
		int[] data = {0,0};	//comparison, movement
		for (int i = 1; i < list.length; i++) {
			/** Insert list[i] into a sorted sublist list[0..i-1] so that 
			 * 	list[0..i] is sorted
			 */
			int currentElement = list[i];
			int k;
			data[0]++;
			for (k = i-1; k>= 0 && list[k] > currentElement; k--) {
				list[k+1] = list[k];
				data[1]++;
			}
			
			//insert the current element into list[k + 1]
			list[k + 1] = currentElement;
			
		}
		return data;
	}
}
