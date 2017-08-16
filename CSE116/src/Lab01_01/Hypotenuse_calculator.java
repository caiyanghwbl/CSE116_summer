package Lab01;

import java.util.*;

public class Hypotenuse_calculator {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		boolean quit = false;
		int A = 0;
		int B = 0;
		while (quit == false) {
			System.out.println("A – Enter value for side A");
			System.out.println("B – Enter value for side B");
			System.out.println("C – Calculate");
			System.out.println("Q – Exit");
			System.out.println("Please Enter a Command: ");
			String cmd = scanner.next();

			if (cmd.equalsIgnoreCase("a")) {
				try {
					System.out.println("Please enter a POSITIVE number");
					A = scanner.nextInt();
				} catch (InputMismatchException ex) {
					System.out.println("Please enter a VALID number!");
				}
				if (A < 0) {
					System.out.println("Please enter a POSITIVE number!");
				}
			}

			if (cmd.equalsIgnoreCase("b")) {
				try {
					System.out.println("Please enter a POSITIVE number");
					B = scanner.nextInt();
				} catch (Exception ex) {
					System.out.println("Please enter a VALID number!");
				}
				if (B < 0) {
					System.out.println("Please enter a POSITIVE number!");
				}
			}

			else if (cmd.equalsIgnoreCase("C")) {
				if (A == 0 || B == 0) {
					System.out.println("Invalid Result!");
				} else {
					double ans = hypo(A, B);
					System.out.println(ans);
				}
				A = 0;
				B = 0;
			}

			else if (cmd.equalsIgnoreCase("q")) {
				System.out.println("Terminated!");
				quit = true;
				System.exit(-1);
			}

		}
	}

	public static double hypo(double A, double B) {
		double ans = 0;
		ans = Math.sqrt(A * A + B * B);
		return ans;
	}
}
