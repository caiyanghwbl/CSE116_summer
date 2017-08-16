package lab05_03;

import java.util.ArrayList;


public class Node {
	public String value;
	public String pref;
	public ArrayList<Node> next;
	
	public Node(){
		next = new ArrayList<>();
	}
}
