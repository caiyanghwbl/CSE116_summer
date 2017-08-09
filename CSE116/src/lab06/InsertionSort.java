package lab06;

public class InsertionSort {
	public static void sort(double ArrayToBeSorted[]) {
		double temp = 0;
		for (int i = 0; i < ArrayToBeSorted.length; i++) {
			int j = i - 1;
			temp = ArrayToBeSorted[i];
			while (j > 0 && temp < ArrayToBeSorted[j]) {
				ArrayToBeSorted[j + 1] = ArrayToBeSorted[j];
				j--;
			}
			ArrayToBeSorted[j + 1] = temp;
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		double ArrayToBeSorted[] = new double[100000];
		for (int i = 0; i < 100000; ++i) {
			ArrayToBeSorted[i] = Math.random();
		}
		InsertionSort is = new InsertionSort();
		long time1 = System.nanoTime();
		is.sort(ArrayToBeSorted);
		long elapsed = System.nanoTime() - time1;
		long result = elapsed / 1000000;
		System.out.println("Elapsed time: " + result + " milliseconds");
	}
}
