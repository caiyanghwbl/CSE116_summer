package lab05_01;

public class QuicksortMult extends Thread{
	double ArrayToBeSorted[];
	int low;
	int high;
	public void run() {
		sort(ArrayToBeSorted, low, high);
	}
	
	public QuicksortMult(double[] ArrayToBeSorted, int low, int high) {
		this.ArrayToBeSorted = ArrayToBeSorted;
		this.low = low;
		this.high = high;
	}
	
	public static int partition(double[] ArrayToBeSorted, int low, int high) {
		double pivot = ArrayToBeSorted[high];
		while(low < high && low > ArrayToBeSorted[high]) {
			high--;
			ArrayToBeSorted[high] = ArrayToBeSorted[low];
		}
		while(low < high && low <= ArrayToBeSorted[low]) {
			low--;
			ArrayToBeSorted[low] = ArrayToBeSorted[high];
		}
		ArrayToBeSorted[low] = pivot;
		return low;
	}

	public static void sort(double[] ArrayToBeSorted, int low, int high) {
		int loc = 1;
		if(low < high) {
			loc = partition(ArrayToBeSorted, low, high);
			sort(ArrayToBeSorted, low, loc - 1);
			sort(ArrayToBeSorted, loc+1, high);
		}
	}
	
	public static void main(String[] args) {
		double ArrayToBeSorted[] = new double[10000];
		for (int i = 0; i < 10000; ++i)
		{
			ArrayToBeSorted[i] = Math.random( );
		}
		int length = ArrayToBeSorted.length;
		Quicksort qs = new Quicksort();

		long time1 = System.nanoTime();
		
		QuicksortMult low = new QuicksortMult(ArrayToBeSorted, 1, length/2-1);
		low.start();
		QuicksortMult high = new QuicksortMult(ArrayToBeSorted, length/2+1, length-1);
		high.start();
		
		
		long elapsed = System.nanoTime() - time1;
		long result = elapsed/1000000;
		System.out.println("Elapsed time: "+ result + " milliseconds");
	}
}
