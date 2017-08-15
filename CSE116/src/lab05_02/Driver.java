package lab05_02;

import java.util.Arrays;

public class Driver {
	public static void main(String[] args) {
		treeSort ts = new treeSort();
		ts.insert(8);
		ts.insert(3);
		ts.insert(9);
		ts.insert(999);
		ts.insert(3);
		ts.insert(4);
		ts.insert(5);
		ts.insert(8);
		System.out.println("The size of the tree is: " + ts.getCount());
		System.out.println(ts.isPresent(3));
		System.out.println(ts.isPresent(999));
		System.out.println(ts.isPresent(2));
		long[] temp = ts.retrieve();
		System.out.println(Arrays.toString(temp));//retrieve方法有问题

	}
}
