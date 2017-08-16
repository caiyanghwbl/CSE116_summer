package lab06;

public class MergeSort {
	public static void sort(double[] ArrayToBeSorted) {
		sort(ArrayToBeSorted, 0, ArrayToBeSorted.length - 1);
	}
	
	public static void sort(double[] ArrayToBeSorted, int left, int right) {
		int center = (left + right) / 2;
		if (left < right) {
			sort(ArrayToBeSorted, left, center);// left
			sort(ArrayToBeSorted, center + 1, right);// right
			merge(ArrayToBeSorted, left, center, right);// merge
		}
	}

	private static void merge(double[] ArrayToBeSorted, int left, int center, int right) {
		double[] array = new double[ArrayToBeSorted.length];
		int mid = center + 1;
		int temp = left;
		int low = left;

		while (left <= center && mid <= right) {
			if (ArrayToBeSorted[left] <= ArrayToBeSorted[mid]) {
				array[low++] = ArrayToBeSorted[left++];
			} else {
				array[low++] = ArrayToBeSorted[mid++];
			}
		}

		while (left <= center) {
			array[low++] = ArrayToBeSorted[left++];
		}

		while (mid <= right) {
			array[low++] = ArrayToBeSorted[mid++];
		}

		while(temp <= right) {
			array[temp] = array[temp++];
		}

	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		double ArrayToBeSorted[] = new double[10000000];
		for (int i = 0; i < 10000000; ++i) {
			ArrayToBeSorted[i] = Math.random();
		}
		int length = ArrayToBeSorted.length;
		MergeSort ms = new MergeSort();
		long time1 = System.nanoTime();
		ms.sort(ArrayToBeSorted, 1, length - 1);
		long elapsed = System.nanoTime() - time1;
		long result = elapsed / 1000000;
		System.out.println("Elapsed time: " + result + " milliseconds");

	}
}
