package lab04_02;

public class Controller {
	private Aircraft head;
	private Aircraft tail;
	private int size;
	
	public Controller(){
		head = new Aircraft();
		tail = new Aircraft();
		size = 0;
	}
	
	public int getACCount(){
		return size;
	}
	
	public int getAC(String name){
		Aircraft tmp = head.next;
		int num = 0;
		while(tmp !=  tail){
			if(tmp.getName().equals(name)){
				return num;
			}
			num++;
			tmp = tmp.next;
		}
		return -1;
	}
	
	public boolean addAC(int id, int altitude, int speed, String name){
		Aircraft tmp = tail.prev;
		Aircraft air = new Aircraft(id, altitude, speed, name, null, null);
		if(tmp == null){
			air.prev = head;
			air.next = tail;
			head.next = air;
			tail.prev = air;
		} else {
			while(tmp.getAltitude() < air.getAltitude()){
				tmp = tmp.prev;
				if(tmp == head){
					break;
				}
			}
			Aircraft tmp2 = tmp.next;
			tmp.next = air;
			air.prev = tmp;
			tmp2.prev = air;
			air.next = tmp2;
		}
		size++;
		return true;
	}
	
	public boolean deleteAC(String name){
		Aircraft tmp = head.next;
		while(tmp != tail){
			if(tmp.getName().equals(name)){
				Aircraft p = tmp.prev;
				Aircraft n = tmp.next;
				p.next = n;
				n.prev = p;
				size--;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	public void showACbyNumber(int num){
		Aircraft tmp = head.next;
		for(int i=0;i<num;++i){
			tmp = tmp.next;
		}
		System.out.println(tmp.toString());
	}
	
	public void showAll(){
		Aircraft tmp = head.next;
		while(tmp != tail){
			System.out.println(tmp.toString());
			tmp = tmp.next;
		}
	}
	
	public void deleteAll(){
		size = 0;
		head = null;
		tail = null;
	}
	
}
