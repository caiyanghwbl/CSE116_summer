package lab05_03;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		String filename = "/Users/caiyang/git/CSE116/src/lab05_03/plants.txt";
		
		XML_DATA xml_DATA = new XML_DATA(filename);
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("Please select function:\n1.Find path\n2.Find num\n");
			int sel = input.nextInt();
			System.out.println("Please input the path: ");
			if(input.nextLine()!="\n"){
				
			}
			String query = input.nextLine();
			switch (sel) {
			case 1:
				System.out.println(xml_DATA.findPath(query));
				break;
			case 2:
				System.out.println(xml_DATA.findNums(query));
				break;
			default:
				break;
			}
			
			
		}
	}
}
