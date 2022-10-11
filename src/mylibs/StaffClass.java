 package mylibs;

public class StaffClass {
	int BookingID;
	String Name;
	String Email;
	String CardDetails;
	String StartDate;
	String EndDate;
	String Roomtype;
	String Bookingstatus;
	int Room_ID;
	
	public StaffClass() {
		
		BookingID =0;
		Name = "";
		Email = "";
		CardDetails = "";
		StartDate = "";
		EndDate = "";
		Roomtype = "";
		Bookingstatus = "";
		Room_ID = 0;
	}
	
	public StaffClass(int bookingID, String name, String email, String cardDetails, String startDate, String endDate,
			String roomtype, String bookingstatus, int room_ID) {
		
		BookingID = bookingID;
		Name = name;
		Email = email;
		CardDetails = cardDetails;
		StartDate = startDate;
		EndDate = endDate;
		Roomtype = roomtype;
		Bookingstatus = bookingstatus;
		Room_ID = room_ID;
	}

	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCardDetails() {
		return CardDetails;
	}

	public void setCardDetails(String cardDetails) {
		CardDetails = cardDetails;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getRoomtype() {
		return Roomtype;
	}

	public void setRoomtype(String roomtype) {
		Roomtype = roomtype;
	}

	public String getBookingstatus() {
		return Bookingstatus;
	}

	public void setBookingstatus(String bookingstatus) {
		Bookingstatus = bookingstatus;
	}

	public int getRoom_ID() {
		return Room_ID;
	}

	public void setRoom_ID(int room_ID) {
		Room_ID = room_ID;
	}

	@Override
	public String toString() {
		return "StaffClass [BookingID=" + BookingID + ", Name=" + Name + ", Email=" + Email + ", CardDetails="
				+ CardDetails + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", Roomtype=" + Roomtype
				+ ", Bookingstatus=" + Bookingstatus + ", Room_ID=" + Room_ID + "]";
	}
	
	
}