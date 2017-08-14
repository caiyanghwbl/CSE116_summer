package lab02;

import java.io.*;
import javax.swing.JOptionPane;

public class Home_made_Database {
	final private static int MAX_RECORD_NUMBER = 20;
	final private static int RECORD_LENGTH = 71;
	static String idinput;
	static String player_name;
	static String team_name;
	static String skill_level_input;
	static String date;
	static int idnum;
	static int skill_level;
	static String skill_level1;
	static String idnum1;
	static String record;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String file;
		file = JOptionPane.showInputDialog(null, "Please enter a file name(ex: DataFile.txt)");
		File loc = new File("H:\\" + file + ".txt");
		@SuppressWarnings("resource")
		RandomAccessFile store = new RandomAccessFile(loc, "rw");
		String Dummy = "abcdefghijklmnop";
		for (int i = 0; i < MAX_RECORD_NUMBER; ++i) {
			store.writeUTF(Dummy); // Fill file with dummy records.
		}
		String cmd = "start";

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
					} else {
						idnum1 = String.format("%5s", idnum);
						break;
					}
				}

				player_name = JOptionPane.showInputDialog(null, "Please enter player's name: ");
				if (player_name == null || player_name == "") {
					JOptionPane.showMessageDialog(null, "Player's name cannot be null");
				}
				if (player_name.length() > 26) {
					player_name = player_name.substring(0, 26);
				}
				String player_name1 = String.format("%26s", player_name);

				team_name = JOptionPane.showInputDialog(null, "Please enter a team name: ");
				if (team_name.length() > 26) {
					team_name = team_name.substring(0, 26);
				}
				String team_name1 = String.format("%26s", team_name);

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
						skill_level1 = String.format("%5s", skill_level);
						break;
					}
				}

				date = JOptionPane.showInputDialog(null, "Please enter today's date(ex: 01Aug2017): ");
				if (date.length() > 26) {
					date = date.substring(0, 9);
				}
				String date1 = String.format("%9s", date);

				if (idnum == 0) {
					idnum = 1;
				}
				record = idnum1 + player_name1 + team_name1 + skill_level1 + date1;
				store.seek((RECORD_LENGTH + 2) * (idnum - 1));
				store.writeUTF(record);
			}

			if (cmd.compareToIgnoreCase("old") == 0) {
				while (true) {
					idinput = JOptionPane.showInputDialog(null, "Enter a record number:");
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
				if (idnum == 0) {
					idnum = 1;
				}
				while (true) {
					try {
						store.seek((RECORD_LENGTH + 2) * (idnum - 1));
						record = store.readUTF();
					} catch (EOFException ex) {
						record = null;
					}
					if (record == null) {
						JOptionPane.showMessageDialog(null, "Record not found!");
						break;
					} else {
						JOptionPane.showMessageDialog(null, record);
						break;
					}
				}
			}

			if (cmd.compareToIgnoreCase("end") == 0) {
				JOptionPane.showMessageDialog(null, "Exit successfully!");
				System.exit(-1);
			}

		}
	}
}
