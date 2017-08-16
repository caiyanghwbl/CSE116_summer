package lab01_02;

public class InvalidException extends Exception {
	public InvalidException() {

	}
	public void error() {
		System.out.println("Invalid input!");
	}
}
