package lab04_02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a command: ");
		String cmd = input.nextLine().toString().trim();
		while (!cmd.equalsIgnoreCase("quit")) {
			if (cmd.equalsIgnoreCase("Entering")) {
				System.out.print("Please input ID: ");
				int id = input.nextInt();
				System.out.print("Please input Altitude: ");
				int altitude = input.nextInt();
				System.out.print("Please input Speed: ");
				int speed = input.nextInt();
				System.out.print("Please input the AC name: ");
				if (input.nextLine() != "\n") {
				}
				String name = input.nextLine().toString().trim();
				controller.addAC(id, altitude, speed, name);
			} else if (cmd.equalsIgnoreCase("Leaving")) {
				System.out.print("Please input the  name: ");
				String name = input.nextLine().toString().trim();
				controller.deleteAC(name);
			} else if (cmd.equalsIgnoreCase("Display")) {
				int count = 0;
				for (int i = 0; i < count; ++i) {
					controller.showACbyNumber(i);
				}
				controller.showAll();
			} else if (cmd.equalsIgnoreCase("Show")) {
				System.out.print("Please input name: ");
				String name = input.nextLine().toString().trim();
				int air = controller.getAC(name);
				if (air != -1) {
					controller.showACbyNumber(air);
				} else {
					System.out.println("Aircraft does not exist!");
				}
			}
			System.out.print("Please enter a command: ");
			cmd = input.nextLine().toString().trim();
		}
		controller.deleteAll();
	}

}
