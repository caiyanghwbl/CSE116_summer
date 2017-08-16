package lab06;


public class QuickSort {

	public static int partition(double[] ArrayToBeSorted, int low, int high) {
		double pivot = ArrayToBeSorted[high];
		while (low < high && low > ArrayToBeSorted[high]) {
			high--;
			ArrayToBeSorted[high] = ArrayToBeSorted[low];
		}
		while (low < high && low <= ArrayToBeSorted[low]) {
			low--;
			ArrayToBeSorted[low] = ArrayToBeSorted[high];
		}
		ArrayToBeSorted[low] = pivot;
		return low;
	}

	public static void sort(double[] ArrayToBeSorted, int low, int high) {
		int loc = 1;
		if (low < high) {
			loc = partition(ArrayToBeSorted, low, high);
			sort(ArrayToBeSorted, low, loc - 1);
			sort(ArrayToBeSorted, loc + 1, high);
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		double ArrayToBeSorted[] = new double[10000000];
		for (int i = 0; i < 10000000; ++i) {
			ArrayToBeSorted[i] = Math.random();
		}
		int length = ArrayToBeSorted.length;
		QuickSort qs = new QuickSort();
		long time1 = System.nanoTime();
		qs.sort(ArrayToBeSorted, 1, length - 1);
		long elapsed = System.nanoTime() - time1;
		long result = elapsed / 1000000;
		System.out.println("Elapsed time: " + result + " milliseconds");
	}
}

