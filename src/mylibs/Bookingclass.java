
package mylibs;

public class Bookingclass {

	int booking_Id,customer_Id,room_Id;
	String Start_Date,End_Date,Room_Type,Room_Status;
	double Room_Price;
	
	public Bookingclass() {
		
		this.booking_Id = 0;
		this.customer_Id = 0;
		this.room_Id = 0;
		Start_Date = "";
		End_Date = "";
		Room_Type = "";
		Room_Status = "Pending";
		Room_Price = 0.0;
	}
	
	
	public Bookingclass(int booking_Id, int customer_Id, int room_Id, String start_Date, String end_Date,
			String room_Type, String room_Status, double room_Price) {
		
		this.booking_Id = booking_Id;
		this.customer_Id = customer_Id;
		this.room_Id = room_Id;
		Start_Date = start_Date;
		End_Date = end_Date;
		Room_Type = room_Type;
		Room_Status = room_Status;
		Room_Price = room_Price;
	}


	public int getBooking_Id() {
		return booking_Id;
	}


	public void setBooking_Id(int booking_Id) {
		this.booking_Id = booking_Id;
	}


	public int getCustomer_Id() {
		return customer_Id;
	}


	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}


	public int getRoom_Id() {
		return room_Id;
	}


	public void setRoom_Id(int room_Id) {
		this.room_Id = room_Id;
	}


	public String getStart_Date() {
		return Start_Date;
	}


	public void setStart_Date(String start_Date) {
		Start_Date = start_Date;
	}


	public String getEnd_Date() {
		return End_Date;
	}


	public void setEnd_Date(String end_Date) {
		End_Date = end_Date;
	}


	public String getRoom_Type() {
		return Room_Type;
	}


	public void setRoom_Type(String room_Type) {
		Room_Type = room_Type;
	}


	public String getRoom_Status() {
		return Room_Status;
	}


	public void setRoom_Status(String room_Status) {
		Room_Status = room_Status;
	}


	public double getRoom_Price() {
		return Room_Price;
	}


	public void setRoom_Price(double room_Price) {
		Room_Price = room_Price;
	}


	@Override
	public String toString() {
		return "Bookingclass [booking_Id=" + booking_Id + ", customer_Id=" + customer_Id + ", room_Id=" + room_Id
				+ ", Start_Date=" + Start_Date + ", End_Date=" + End_Date + ", Room_Type=" + Room_Type
				+ ", Room_Status=" + Room_Status + ", Room_Price=" + Room_Price + "]";
	}
	
	
}
	
	
	