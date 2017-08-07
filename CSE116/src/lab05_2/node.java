package lab05_2;

public class node {
	node left, right;
	int value;
	
	public node() {
		left = null;
		right = null;
		value = 0;
	}
	
	public node(int value) {
		left = null;
		right = null;
		this.value = value;
	}
	
	public void setLeftNode(node leftValue) {
		left = leftValue;
	}
	
	public void setRightNode(node rightValue) {
		right = rightValue;
	}
	
	public node getLeftNode() {
		return left;
	}
	
	public node getRightNode() {
		return right;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
