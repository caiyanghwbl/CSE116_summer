package lab05;

public class Quicksort {
	public static int partition(double[] unsorted, int low, int high) {
		double pivot = unsorted[high];
		while(low < high && low > unsorted[high]) {
			high--;
			unsorted[high] = unsorted[low];
		}
		while(low < high && low <= unsorted[low]) {
			low--;
			unsorted[low] = unsorted[high];
		}
		unsorted[low] = pivot;
		return low;
		
	}
}
