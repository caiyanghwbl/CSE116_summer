package lab06;

public class BubbleSort {

	public static void sort(double[] arrayToBeSorted) {
		double temp = 0;
		int position = 0;
		for (int i = 0; i < arrayToBeSorted.length; i++) {
			position = i;
			temp = arrayToBeSorted[i];
			
			for (int j = i + 1; j < arrayToBeSorted.length; j++) {
				if (temp > arrayToBeSorted[j]){//交换两个数位置
					temp = arrayToBeSorted[j];
					position = j;
				}
			}
			arrayToBeSorted[position] = arrayToBeSorted[i];
			arrayToBeSorted[i] = temp;
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		double ArrayToBeSorted[] = new double[1000000];
		for (int i = 0; i < 1000000; ++i) {
			ArrayToBeSorted[i] = Math.random();
		}
		BubbleSort bs = new BubbleSort();
		long time1 = System.nanoTime();
		bs.sort(ArrayToBeSorted);
		long elapsed = System.nanoTime() - time1;
		long result = elapsed / 1000000;
		System.out.println("Elapsed time: " + result + " milliseconds");
	}
}
