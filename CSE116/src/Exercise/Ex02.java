package Exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		boolean continueInput = true;
		Scanner scanner = new Scanner(System.in);
		do {
			try {

				System.out.print("Enter an value for a:");
				double a = scanner.nextInt();
				if (a == 0) {
					throw new InputMismatchException("a cannot be 0");
				}
				System.out.print("Enter an value for b:");
				double b = scanner.nextInt();
				
				System.out.print("Enter an value for c:");
				double c = scanner.nextInt();
				
				double tem1 = -1*b + Math.sqrt(b*b-4*a*c);
				double tem2 = -1*b - Math.sqrt(b*b-4*a*c);
				
				System.out.println("The first answer is: " + tem1);
				System.out.println("The second answer is: " + tem2);
				continueInput = false;
				
			}
			catch(InputMismatchException ex) {
			System.out.println("Please enter a valid number!");
			}
		}
		while (continueInput);
		System.out.println("Do you wish to continue? Or enter Q to exit");
		String Q = scanner.next();
		if(Q.equals("Q")){
			System.exit(-1);
	}

	}
}
