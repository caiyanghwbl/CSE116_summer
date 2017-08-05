package lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Home_made_Database {
	final private static int MAX_RECORD_NUMBER = 20;
	final private static int RECORD_LENGTH = 73;
	static String idinput;
	static String player_name;
	static String team_name = "";
	static String skill_level_input;
	static String date = "";
	static int idnum;
	static int skill_level;

	public static boolean isInteger(String idint) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(idint).matches();
	}

	public void idException() {

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File loc = new File("H:\\DataFile.txt");
		RandomAccessFile store = new RandomAccessFile(loc, "rw");
		String Dummy = "abcdefghijklmnop";
		for (int i = 0; i < MAX_RECORD_NUMBER; ++i) {
			store.writeUTF(Dummy); // Fill file with dummy records.
		}
		String Description = "";
		int recLocation = 0;
		String where = "0";
		String cmd = "start";
		boolean quit = false;

		while (cmd.compareToIgnoreCase("end") != 0) {
			cmd = JOptionPane.showInputDialog(null, "Please enter a command:");
			if (cmd.compareToIgnoreCase("new") == 0) {
				while (true) {
					idinput = JOptionPane.showInputDialog(null, "Please enter ID number(1-20): ");
					//
					try {
						idnum = Integer.parseInt(idinput);
					} catch (NumberFormatException ex) {
						idnum = 0;
						JOptionPane.showMessageDialog(null, "Please enter an INTEGER!");
					}

					if (idnum < 1 || idnum > 20) {
						JOptionPane.showMessageDialog(null, "Please enter a value between 1 and 20!");
						// idinput = JOptionPane.showInputDialog(null, "Please enter ID number(1-20):
						// ");
					} else {
						break;
					}
				}
				// assert Description.length() == RECORD_LENGTH;

				player_name = JOptionPane.showInputDialog(null, "Please enter player's name: ");
				if (player_name == null || player_name == "") {
					JOptionPane.showMessageDialog(null, "Player's name cannot be null");
				}
				if (player_name.length() > 26) {
					player_name = player_name.substring(0, 26);
				}

				team_name = JOptionPane.showInputDialog(null, "Please enter a team name: ");
				if (team_name.length() > 26) {
					team_name = team_name.substring(0, 26);
				}
				while (true) {
					skill_level_input = JOptionPane.showInputDialog(null, "Please enter skill level(0-99): ");
					try {
						skill_level = Integer.parseInt(skill_level_input);
					} catch (NumberFormatException ex) {
						skill_level = -1;
						JOptionPane.showMessageDialog(null, "Please enter an INTEGER!");
					}
					if (skill_level < 0 || skill_level > 99) {
						JOptionPane.showMessageDialog(null, "Invaild input");
					} else {
						break;
					}
				}

				date = JOptionPane.showInputDialog(null, "Please enter today's date(ex: 01Aug2017): ");
				if (date.length() > 26) {
					date = date.substring(0, 9);
				}

				if (recLocation == 0) {
					recLocation = 1;
				}

				// String record = String.format("%1$"+5+"s", idnum, player_name, team_name,
				// skill_level, date);
				String record = idnum + player_name + team_name + skill_level + date;
				store.seek((RECORD_LENGTH + 2) * (recLocation - 1));
				store.writeUTF(record);
			}

			if (cmd.compareToIgnoreCase("old") == 0) {

				while (true) {
					where = JOptionPane.showInputDialog(null, "Enter a record number:");

					try {
						idnum = Integer.parseInt(idinput);
					} catch (NumberFormatException ex) {
						idnum = 0;
					}
					if (idnum < 1 || idnum > 20) {
						JOptionPane.showMessageDialog(null, "The input must between 1 and 20!");
					} else {
						break;
					}
				}

				store.seek((RECORD_LENGTH + 2) * (idnum - 1));
				Description = store.readUTF();
				JOptionPane.showMessageDialog(null, Description);

			}
			if (cmd.compareToIgnoreCase("end") == 0) {
				JOptionPane.showMessageDialog(null, "Exit successfully!");
				System.exit(-1);
			}

		}
	}
}
