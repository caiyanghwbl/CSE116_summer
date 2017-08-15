package lab05_02;

public class treeSort {
	static Node root;
	int _size;
	Node current;
	Node parent;

	public boolean insert(long value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			_size++;
			return true;
		}
		current = root;
		parent = null;
		while (true) {
			parent = current;
			if (value <= current.value) {
				if (value == current.value) {
//					System.out.println("Duplicate!");
					return false;
				}
				current = current.left;
				if (current == null) {
					parent.left = newNode;// left
					_size++;
					return true;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					_size++;
					return true;
				}
			}
		}
	}

	public long[] retrieve() {
		final long[] array = new long[_size];
		final int[] index = new int[_size];
		inOrder(root, array, index);
		return array;

	}

	public boolean isPresent(long value) {
		if (root == null) {
			return false;
		}
		current = root;
		parent = null;
		while (true) {
			parent = current;
			if (value <= current.value) {
				if (value == current.value) {
					return true;
				}
				current = current.left;
				if (current == null) {
					return false;
				}
			} else {
				current = current.right;
				if (current == null) {
					return false;
				}
			}
		}
	}

	public static void inOrder(Node node, long[] array, int[] index) {
		if (node != null) {
			inOrder(node.left, array, index);
//			System.out.print(node.value + " "); //临时print测试
			array[index[0]++] = node.value;
			inOrder(node.right, array, index);
		}
	}

	public static void inOrder() {
		inOrder(root, null, null);
	}

	public int getCount() {
		return _size;

	}
}
