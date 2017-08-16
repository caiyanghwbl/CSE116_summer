package lab04_02;

public class Aircraft {
	public int id;
	public int altitude;
	public int speed;
	public String name;
	public Aircraft prev;
	public Aircraft next;
	
	public Aircraft(){
		prev = null;
		next = null;
	}
	
	public Aircraft(int id, int altitude, int speed, String name, Aircraft prev, Aircraft next){
		this.id = id;
		this.altitude = altitude;
		this.speed = speed;
		this.name = name;
		this.prev = prev;
		this.next = next;
	}
	
	public String toString(){
		return "ID: " + id 
				+ "\nAltitude: " + altitude
				+ "\nSpeed: " + speed
				+"\nName: " + name
				+"\n ";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
