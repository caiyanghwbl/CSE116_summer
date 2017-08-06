package lab02;

import java.io.*;
import javax.swing.JOptionPane;

public class Lab02_demo {
	// Number of records in the file.
	final private static int MAX_RECORD_NUMBER = 10;
	// Size of record.
	final private static int RECORD_LENGTH = 16;

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
		while (cmd.compareToIgnoreCase("end") != 0) {
			cmd = JOptionPane.showInputDialog(null, "Please input a command:");
			if (cmd.compareToIgnoreCase("new") == 0) {
				// Command is "new" - user wants to make a new record
				Description = JOptionPane.showInputDialog(null, "Please input a description: ");
				assert Description.length() == RECORD_LENGTH;

				if (recLocation == 0) {
					recLocation = 1;
				}
				// find the correct location in the file
				store.seek((RECORD_LENGTH + 2) * (recLocation - 1));
				store.writeUTF(Description);
			}

			if (cmd.compareToIgnoreCase("old") == 0) {
				// Command is "old" - user wants to see an existing record
				where = JOptionPane.showInputDialog(null, "Input rec number:");
				recLocation = Integer.parseInt(where);

				store.seek((RECORD_LENGTH + 2) * (recLocation - 1));
				Description = store.readUTF();
				JOptionPane.showMessageDialog(null, Description);
			}
		}
	}
}
