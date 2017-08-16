package lab05_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XML_DATA {
	private String filename;
	private Node rootNode;
	private ArrayList<String> pre;

	public XML_DATA() {

	}

	public XML_DATA(String filename) throws FileNotFoundException {
		this.filename = filename;
		File inputFile = new File(this.filename);
		Scanner fin = new Scanner(inputFile);
		String data = "";
		while (fin.hasNextLine()) {
			data += fin.nextLine();
		}
		// System.out.println(data);
		fin.close();
		rootNode = new Node();
		pre = new ArrayList<>();
		this.BuildTree(data, rootNode, 0);
	}

	public String getPref(String fXML) {
		int pos = fXML.indexOf('>');
		String pref = fXML.substring(1, pos);
		return pref;
	}

	public ArrayList<String> getXML(String fXML) {
		ArrayList<String> ret = new ArrayList<>();
		int pos = fXML.indexOf('>');
		String pref = fXML.substring(1, pos);
		String subfXML = fXML.substring(pos + 1, fXML.length() - pos - 2);
		// System.out.println(subfXML);
		pos = subfXML.indexOf('>');
		String subpref = subfXML.substring(1, pos);
		while ((pos = subfXML.indexOf("</" + subpref + ">")) != -1) {
			ret.add(subfXML.substring(0, pos + 3 + subpref.length()));
			subfXML = subfXML.substring(pos + 3 + subpref.length());
		}
		return ret;
	}

	public String getData(String XML) {
		String ret = "";
		Pattern p = Pattern.compile(">([^`]+)</");
		Matcher m = p.matcher(XML);
		m.find();
		// System.out.println("233"+ XML);
		ret = m.group(1);
		return ret;
	}

	public ArrayList<String> getLastXML(String fXML) {
		ArrayList<String> ret = new ArrayList<>();
		int pos = fXML.indexOf('>');
		String pref = fXML.substring(1, pos);
		String subfXML = fXML.substring(pos + 1, fXML.length() - pos - 2);
		// System.out.println(subfXML);
		pos = subfXML.indexOf('>');
		String subpref = subfXML.substring(1, pos);
		while ((pos = subfXML.indexOf("</")) != -1) {
			int next = subfXML.indexOf(">", pos + 1);
			ret.add(subfXML.substring(0, next + 1));
			subfXML = subfXML.substring(next + 1);
		}
		return ret;
	}

	public void BuildTree(String data, Node root, int deep) {
		if (deep == 2) {
			int pos;
			while ((pos = data.indexOf(">")) != -1) {
				root.pref = data.substring(1, pos);
				int last = data.indexOf(">", pos + 1);
				root.value = this.getData(data.substring(0, last + 1));
				data = data.substring(last + 1);
			}
			return;
		}

		String pref = this.getPref(data);
		root.pref = pref;
		ArrayList<String> children = new ArrayList<>();
		if (deep == 1) {
			children = getLastXML(data);
		} else {
			children = getXML(data);
		}

		for (String string : children) {
			Node node = new Node();
			root.next.add(node);
			BuildTree(string, node, deep + 1);
		}

	}

	public String findPath(String query) {
		String ret = "";
		String paths[] = query.split("\\.");
		if (paths.length == 3) {
			int pos = paths[1].indexOf("[");
			int last = paths[1].indexOf("]");
			int num = Integer.parseInt(paths[1].substring(pos + 1, last));
			Node tmp = rootNode.next.get(num);
			for (Node node : tmp.next) {
				if (node.pref.equals(paths[2])) {
					ret = "<" + node.pref + ">" + node.value + "</" + node.pref + ">";
					break;
				}
			}
		}
		if (paths.length == 2) {
			int pos = paths[1].indexOf("[");
			int last = paths[1].indexOf("]");
			int num = Integer.parseInt(paths[1].substring(pos + 1, last));
			Node tmp = rootNode.next.get(num);
			ret = "<" + tmp.pref + ">\n";
			for (Node node : tmp.next) {
				ret += "\t<" + node.pref + ">" + node.value + "</" + node.pref + ">\n";
			}
			ret += "</" + tmp.pref + ">";
		}
		return ret;
	}

	public int findNums(String query) {
		int ret = 0;
		String paths[] = query.split("\\.");
		if (paths.length == 1) {
			return rootNode.next.size();
		}
		if (paths.length == 2) {
			return rootNode.next.get(0).next.size();
		}
		return ret;
	}

}
