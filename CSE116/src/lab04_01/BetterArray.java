package lab04;
import lab04.Node;
public class BetterArray {

	private int _size;
	private Node _head;
	private Node _tail;
	public Node next;	
	public Node prev;
	
	public BetterArray(int n) {
		_size = n;
		if(n < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			_head = new Node();
			next = _head;
			for(int i=0; i < _size; i++) {
				prev = next;
				next.set(i);
			}
		}
		
	}
	
	public BetterArray() {
	}
	
	public int get(int index) {
		return index;
	}
	
	public void put(int value , int index) {
	}
	
	public void insert (int value , int index) {
	}
	
	public void delete(int index) {
	}
}
