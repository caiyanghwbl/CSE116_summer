package lab03;

import java.io.*;

import javax.swing.JOptionPane;

public class Main {

	final private static int MAX_RECORD_NUMBER = 20;
	final private static int RECORD_LENGTH = 71;
	static String blankstring = " ";
	static String fill = "      ";
	static String idinput;
	static String skill_level_input;
	static int skill_level = 0;
	static int idnum;
	static String player_name;
	static String team_name;
	static boolean pause = true;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

		MTqueue queue = new MTqueue();
		Display thread = new Display(queue);

		String cmd = "start";

		while (cmd.compareToIgnoreCase("end") != 0) {
			cmd = JOptionPane.showInputDialog(null, "Please enter a command: ");

			if (cmd.compareToIgnoreCase("new") == 0) {
				// thread.start();//Thread started
				while (true) {
					idinput = JOptionPane.showInputDialog(null, "Please enter the ID number(1-20): ");
					try {
						idnum = Integer.parseInt(idinput);
						if (idnum < 1 || idnum > 20) {
							System.out.println("Invalid input!");
						} else {
							break;
						}

					} catch (NumberFormatException ex) {
						System.out.println("Invalid input!");
					}
				}

				player_name = JOptionPane.showInputDialog(null, "Please enter player's name: ");
				team_name = JOptionPane.showInputDialog(null, "Please enter team's name: ");

				while (true) {
					skill_level_input = JOptionPane.showInputDialog(null, "Please enter skill level(0-99): ");
					try {
						skill_level = Integer.parseInt(skill_level_input);
						if (skill_level < 0 || skill_level > 99) {
							System.out.println("Invalid input!");
						} else {
							break;
						}

					} catch (NumberFormatException ex) {
						System.out.println("Invalid input!");
					}
				}

				String date = JOptionPane.showInputDialog(null, "Please enter today's date(ex: 01Aug2017): ");

				if (idinput.length() < 2) {
					idinput = idinput + blankstring;
				}
				if (player_name.length() > 26) {
					player_name = player_name.substring(0, 26);
				} else {
					while (player_name.length() < 26) {
						player_name = player_name + blankstring;
					}
				}

				if (team_name.length() > 26) {
					team_name = team_name.substring(0, 26);
				} else {
					while (team_name.length() < 26) {
						team_name = team_name + blankstring;
					}
				}
				if (date.length() > 9) {
					date = date.substring(0, 9);
				} else {
					while (date.length() < 9) {
						date = date + blankstring;
					}
				}
				if (skill_level_input.length() < 2) {
					skill_level_input = skill_level_input + blankstring;
				}
				String record = idinput + player_name + team_name + skill_level_input + date + fill;

				queue.MTPut(record);
				if (pause == true) {
					thread.start();
					pause = false;
				}
			}
			if (cmd.compareToIgnoreCase("end") == 0) {
				System.out.print("Exit successfully!");
				thread.stop();
			}
		}

	}
}