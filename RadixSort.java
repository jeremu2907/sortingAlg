import java.util.*;

class RadixSort {
	public static int[] data = {0,0}; //Comparisons, movement
	static int getMax(Integer arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++){
			data[0]++;
			if (arr[i] > mx)
				mx = arr[i];
		}
		return mx;
	}

	static void countSort(Integer arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;
		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++){
			count[i] += count[i - 1];
			data[1]++;
		}
		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
			data[1]++;
		}
		for (i = 0; i < n; i++){
			arr[i] = output[i];
			data[1]++;
		}
	}

	static int[] radixsort(Integer arr[], int n) { // Find the maximum number to know number of digits
		int m = getMax(arr, n);
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
		int[] t = data;
		data = new int[] {0,0};
		return t;
	}

	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
	/**
	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;
		radixsort(arr, n);
		print(arr, n);
	}
	*/
}