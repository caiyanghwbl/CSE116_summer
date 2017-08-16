package lab01_02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InvalidException {
		double a = 0;
		double b = 0;
		double c = 0;
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		while (quit == false) {
			System.out.println("Please enter a: ");
			a = sc.nextDouble();
			System.out.println("Please enter b: ");
			b = sc.nextDouble();
			System.out.println("Please enter c: ");
			c = sc.nextDouble();
			double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
			double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
			System.out.println("Value for x1 is: " + x1 + "\nvalue for x2 is: " + x2);
			System.out.println("Do you want to continue?(Y/N)");
			String str = sc.next();
			if (str.equalsIgnoreCase("y")) {
				quit = false;
			} else if (str.equalsIgnoreCase("n")) {
				quit = true;
			}

		}
		while (quit != false) {
			System.out.println("Exit successfully!");
			System.exit(-1);
		}

	}
}
