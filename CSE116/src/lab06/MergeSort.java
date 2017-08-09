package lab06;

public class MergeSort {
	public static double[] sort(double[] ArrayToBeSorted, int left, int right) {
		int center = (left + right) / 2;
		if (left < right) {
			sort(ArrayToBeSorted, left, center);// left
			sort(ArrayToBeSorted, center + 1, right);// right
			merge(ArrayToBeSorted, left, center, right);// merge
		}
		return ArrayToBeSorted;
	}

	private static void merge(double[] ArrayToBeSorted, int left, int center, int right) {
		// TODO Auto-generated method stub
		double[] array = new double[ArrayToBeSorted.length];
		int low = left;
		int mid = center + 1;
		int temp = 0;

		while (low <= mid && mid <= right) {
			if (ArrayToBeSorted[low] < ArrayToBeSorted[mid]) {
				array[temp++] = ArrayToBeSorted[low++];
			} else {
				array[temp++] = ArrayToBeSorted[mid++];
			}
		}

		while (low <= mid) {
			array[temp++] = ArrayToBeSorted[low++];
		}

		while (mid <= right) {
			array[temp++] = ArrayToBeSorted[mid++];
		}

		for (int i = 0; i < array.length; i++) {
			ArrayToBeSorted[(i + low)] = array[i];
		}

	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		double ArrayToBeSorted[] = new double[10000];
		for (int i = 0; i < 10000; ++i) {
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
