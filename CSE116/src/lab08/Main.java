package lab08;

import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
		
		boolean quit = false;
		while(quit ==false){

		System.out.println("Please input the first value:");
		Scanner scanner = new Scanner(System.in);
		String a1 = scanner.next();
		intValue intValue1 = new intValue(a1);

		System.out.println("Please input the second value:");
		String a2 = scanner.next();
		intValue intValue2 = new intValue(a2);

		System.out.println("Please choose the operation:");
		System.out.println("1. add");
		System.out.println("2. multiply");
		System.out.println("3. exponentiation");

		
		String choice = scanner.nextLine();
		if (choice.equals("1")) {
			System.out.println(intValue1.add(intValue2));

		} else if (choice.equals("2")) {

			System.out.println(intValue1.multiply(intValue2));

		} else if (choice.equals("3")) {

			System.out.println(intValue1.exponentiation(intValue2));
		} else if(choice.equals("")) {
			
		}
		}
	}
}
