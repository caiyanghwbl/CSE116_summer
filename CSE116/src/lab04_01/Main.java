package lab04_01;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		BetterArray ba = new BetterArray(10);
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			ba.put(random.nextInt(10), i);
		}
		for (int i = 0; i < 20; i++) {
			System.out.print(ba.get(i) + " ");
		}
		System.out.println("");

		for (int i = 0; i < 20; i++) {
			ba.put(random.nextInt(10), i);
		}
		for (int i = 0; i < 20; i++) {
			System.out.print(ba.get(i) + " ");
		}
		System.out.println("");

		ba.insert(999, 14);
		for (int i = 0; i < 21; i++) {
			System.out.print(ba.get(i) + " ");
		}
		System.out.println("");

		ba.delete(15);
		for (int i = 0; i < 20; i++) {
			System.out.print(ba.get(i) + " ");
		}
		System.out.println("");

		for (int i = 0; i < 1000; i++) {
			ba.put(random.nextInt(100), i);
		}
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000 - 1; j++) {
				if (ba.get(j) > ba.get(j + 1)) {
					ba.put(ba.get(j) + ba.get(j + 1), j);
					ba.put(ba.get(j) - ba.get(j + 1), (j + 1));
					ba.put(ba.get(j) - ba.get(j + 1), j);
				}
			}
		}
		for (int i = 0; i < 1000; i++) {
			System.out.print(ba.get(i) + " ");
		}
	}
}
