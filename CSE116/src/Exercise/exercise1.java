import java.util.*;

public class exercise1 {

	static Scanner input = new Scanner(System.in);
	static double sideA = 0, sideB = 0, sideC = 0;

	public static double optionA() {
		sideA = input.nextDouble();
		try {
			if (sideA <= 0)
				throw new InputMismatchException();
		} catch (InputMismatchException ex) {
			System.out.println("Invalid Input");
		}
		return sideA;
	}

	public static double optionB() {
		sideB = input.nextDouble();
		try {
			if (sideB <= 0)
				throw new InputMismatchException();
		} catch (InputMismatchException ex) {
			System.out.println("Invalid Input");
		}
		return sideB;
	}

	public static double optionC(double sideA, double sideB) {
		try {
			if ((sideB <= 0) || (sideA <= 0))
				throw new InputMismatchException();
		} catch (InputMismatchException ex) {
			System.out.println("Invalid Input");
		}
		sideC = Math.hypot(sideA, sideB);
		return sideC;
	}

	public static void main(String[] args) {

		int i = 0;

		while (i >= 0) {

			System.out.println("A – enter value for side A");
			System.out.println("B – enter value for side B");
			System.out.println("C – calculate");
			System.out.println("Q – quit the program");
			String option = input.next();

			if (option.equalsIgnoreCase("a")) {
				System.out.println("Please enter a positive numeric value");
				optionA();
			}

			else if (option.equalsIgnoreCase("b")) {
				System.out.println("Please enter a positive numeric value");
				optionB();
			}

			else if (option.equalsIgnoreCase("c")) {
				System.out.println("The hypotenuse of the triangle is "
						+ optionC(sideA, sideB));
				System.out.println("Try again? (y/n)");
				String yn = input.next();
				if (yn.equalsIgnoreCase("y")) {
					sideA = 0;
					sideB = 0;
					sideC = 0;
					continue;
				} else if (yn.equalsIgnoreCase("n")) {
					break;
				} else {
					System.out.println("Please enter a valid value");
					
				}

			}

			else if (option.equalsIgnoreCase("q")) {
				break;
			}

			else {
				System.out.println("Please enter a valid value");
			}
		}
	}

}
