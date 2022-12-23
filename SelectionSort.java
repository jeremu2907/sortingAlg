
public class SelectionSort {
	/** The method for sorting the numbers */
	public static int[] selectionSort(Integer[] list) { //int[] list?
		int[] data = {0,0};	//comparison, movement
		for (int i = 0; i < list.length -1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for (int j = i+1; j < list.length; j++) {
				data[0]++;
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			
			//	Swap list[i] wiht list[currentMinIndex[ if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
				data[1]++;
				// System.out.printf("%d   %d\n", list[currentMinIndex], list[i]);
			}
		}
		return data;
	}
}
