package mylibs;

public class CheckInlibs {
	int booking_id, room_Id;
	String arrival_Date, departure_Date, room_Type, booking_Status;
	double room_Price;

	public CheckInlibs() {
		this.booking_id = 0;
		this.room_Id = 0;
		this.arrival_Date = "";
		this.departure_Date = "";
		this.room_Type = "";
		this.booking_Status = "";
		this.room_Price = 0.0;
	}

	public CheckInlibs(int booking_id, int room_Id, String arrival_Date, String departure_Date, String room_Type,
			String booking_Status, double room_Price) {
		this.booking_id = booking_id;
		this.room_Id = room_Id;
		this.arrival_Date = arrival_Date;
		this.departure_Date = departure_Date;
		this.room_Type = room_Type;
		this.booking_Status = booking_Status;
		this.room_Price = room_Price;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getRoom_Id() {
		return room_Id;
	}

	public void setRoom_Id(int room_Id) {
		this.room_Id = room_Id;
	}

	public String getArrival_Date() {
		return arrival_Date;
	}

	public void setArrival_Date(String arrival_Date) {
		this.arrival_Date = arrival_Date;
	}

	public String getDeparture_Date() {
		return departure_Date;
	}

	public void setDeparture_Date(String departure_Date) {
		this.departure_Date = departure_Date;
	}

	public String getRoom_Type() {
		return room_Type;
	}

	public void setRoom_Type(String room_Type) {
		this.room_Type = room_Type;
	}

	public String getBooking_Status() {
		return booking_Status;
	}

	public void setBooking_Status(String booking_Status) {
		this.booking_Status = booking_Status;
	}

	public double getRoom_Price() {
		return room_Price;
	}

	public void setRoom_Price(double room_Price) {
		this.room_Price = room_Price;
	}

	@Override
	public String toString() {
		return "CheckInlibs [booking_id=" + booking_id + ", room_Id=" + room_Id + ", arrival_Date=" + arrival_Date
				+ ", departure_Date=" + departure_Date + ", room_Type=" + room_Type + ", booking_Status="
				+ booking_Status + ", room_Price=" + room_Price + "]";
	}

}
