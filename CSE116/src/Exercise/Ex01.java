package Exercise;

import java.util.*;

public class Ex01 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		int A = 0;
		int B = 0;
		while (quit == false) {
			System.out.println("A – Enter value for side A");
			System.out.println("B – Enter value for side B");
			System.out.println("C – Calculate");
			System.out.println("Q – Exit");
			System.out.println("Please enter a command: ");
			String cmd = scanner.next();
			
			if(cmd.equalsIgnoreCase("a")) {
				try {
					System.out.println("Please enter a positive number");
					A = scanner.nextInt();
				}
				catch(NumberFormatException ex){
					throw new Exception("Invalid Input",ex);
				}
			}
			
			else if(cmd.equalsIgnoreCase("b")) {
				try {
					System.out.println("Please enter a positive number");
					B = scanner.nextInt();
				}
				catch(Exception ex){
					System.out.println("Please enter a valid number!");
				}
			}
			
			else if(cmd.equalsIgnoreCase("C")) {
				double ans = hypo(A,B);
				System.out.println(ans);
				A = 0;
				B = 0;
			}
			
			else if(cmd.equalsIgnoreCase("q")) {
				quit = true;
				System.exit(-1);
				System.out.println("Terminated!");
			}
			
		}
	}
	public static double hypo(double A, double B) {
		double ans = 0;
		ans = Math.sqrt(A*A + B*B);
		return ans;
	}
}
