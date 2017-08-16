package lab04_01;

import lab04_01.Node;

public class BetterArray {

	private int _size;
	private Node _head;
	private Node _tail;

	public BetterArray(int n) {
		_size = n;
		if (n < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			for (int i = 0; i < n; i++) {
				append(0);
			}
		}
	}

	public BetterArray() {
		_head = null;
		_tail = null;
		_size = 0;
	}

	public int get(int index) {
		Node temp = _head;
		int count = 0;
		while (temp != null) {
			if (count == index) {
				return temp.value;
			}
			count++;
			temp = temp.next;
		}
		return 0;
	}

	public void put(int value, int index) {
		Node temp = _head;
		index++;
		if (index > _size) {
			while (_size < index + 1) {
				append(0);
				_size++;
			}
		}
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		temp.set(value);
	}

	public void insert(int value, int index) {
		Node newNode = new Node(value);
		Node temp = _head;
		if (index < _size) {
			while (_size < index + 1) {
				append(0);
				_size++;
			}
		}
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	public void delete(int index) {
		Node temp = _head;
		if (index == 0) {
			_head = temp.next;
			return;
		}
		for (int i = 0; temp != null && i < index - 1; i++) {
			temp = temp.next;
		}
		if (temp == null || temp.next == null) {
			return;
		}
		if (_head == null) {
			return;
		}
		Node next = temp.next.next;
		temp.next = next;
	}

	public void append(int value) {
		Node temp = new Node(value);
		if (_head == null) {
			_head = temp;
			return;
		}
		temp.next = _tail;
		Node temp1 = _head;
		while (temp1.next != null) {
			temp1 = temp1.next;
		}
		temp1.next = temp;
	}
}
