package mylibs;

public class Roomclass {
	int room_no;
	String room_Type;
	int room_Price;
	String room_Status;
	
	public Roomclass() {
		
		this.room_no = 0;
		this.room_Type = "";
		this.room_Price = 0;
		this.room_Status = "";
	}

	
	public Roomclass(int room_no, String room_Type, int room_Price, String room_Status) {
		super();
		this.room_no = room_no;
		this.room_Type = room_Type;
		this.room_Price = room_Price;
		this.room_Status = room_Status;
	}


	public int getRoom_no() {
		return room_no;
	}


	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}


	public String getRoom_Type() {
		return room_Type;
	}


	public void setRoom_Type(String room_Type) {
		this.room_Type = room_Type;
	}


	public int getRoom_Price() {
		return room_Price;
	}


	public void setRoom_Price(int room_Price) {
		this.room_Price = room_Price;
	}


	public String getRoom_Status() {
		return room_Status;
	}


	public void setRoom_Status(String room_Status) {
		this.room_Status = room_Status;
	}


	@Override
	public String toString() {
		return "Roomclass [room_no=" + room_no + ", room_Type=" + room_Type + ", room_Price=" + room_Price
				+ ", room_Status=" + room_Status + "]";
	}
	
	
	
}