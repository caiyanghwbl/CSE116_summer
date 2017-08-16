package lab03;

import java.io.*;

public class Display extends Thread {

	final private static int MAX_RECORD_NUMBER = 20;
	final private static int RECORD_LENGTH = 71;
	static String idinput;
	static int idnum;
	static String player_name;
	static String team_name;
	static String skill_level_input;
	static String date;
	static int skill_level;
	static String skill_level1;
	static String idnum1;
	String record = "";
	RandomAccessFile store;
	MTqueue Display;

	public Display(MTqueue queue) {
		Display = queue;
	}

	public void run() {

		File loc = new File("H:\\DataFile.txt");
		try {
			store = new RandomAccessFile(loc, "rw");
		} catch (FileNotFoundException ex) {
			System.out.println("File not found!");
		}
		for (int i = 0; i < MAX_RECORD_NUMBER; i++) {
			try {
				store.seek(0);
				String Dummy = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrs";
				store.writeUTF(Dummy);
			} catch (IOException ex) {
				System.out.println("I/O Exception!");
			}
		}

		while (true) {
			record = Display.MTGet();
			if (record != null) {
				try {
					idinput = record.substring(0, 2);
					idnum = Integer.parseInt(idinput);
				} catch (NumberFormatException ex) {
					try {
						idinput = record.substring(0, 1);
						idnum = Integer.parseInt(idinput);
					} catch (NumberFormatException f) {
						System.out.println("NFE Exception ");
						ex.printStackTrace();
					}
				}

				try {
					store.seek((RECORD_LENGTH + 2) * (idnum - 1));
					store.writeUTF(record);
					store.seek((RECORD_LENGTH + 2) * (idnum - 1));
					String record1 = store.readUTF();

					idnum1 = record1.substring(0, 5);
					String player_name1 = record1.substring(5, 31);
					String team_name1 = record1.substring(31, 57);
					skill_level1 = record1.substring(57, 62);
					String date1 = record1.substring(62, 71);
					System.out.println(idnum1 + player_name1 + team_name1 + skill_level1 + date1);
				} catch (IOException ex) {
					System.out.println("IO Exception");
					ex.printStackTrace();
					
				}
				record = null;
			}
		}

	}
}
