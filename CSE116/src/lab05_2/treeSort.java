package lab05_2;

public class treeSort {
	node root;
	node currentIndex;
	node parent;
	long compareIndex;
	int _size;
	public treeSort() {
		root = null;
	}
	
	public boolean insert(long value) {
		compareIndex = root.getValue();
		if(root == null) {
			root = new node(value);
			_size = _size + 1;
			return true;
		}
		else {
			return false;
		}
	}
	
	public long[] retrieve(){
		
		return null;
		
	}
	
	public boolean isPresent(long value) {
		return false;
		
	}
	
	public int getCount() {
		return 0;
		
	}
}