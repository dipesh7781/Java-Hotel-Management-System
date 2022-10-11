package mylibs;
	//for inner join
public class CheckoutClass2 {

	int Booking_Id;
	String ArrivalDate;
	String DepartureDate;
	String Name;
	int Room_ID; 
	int Room_Price;
	int Restro_Price;
	int Bar_Price;
	int Service_price;

	public CheckoutClass2() {

		Booking_Id = 0;
		ArrivalDate = "";
		DepartureDate = "";
		Name = "";
		Room_ID = 0;
		Room_Price = 0;
		Restro_Price = 0;
		Bar_Price = 0;
		Service_price = 0;
	}

	public CheckoutClass2(int booking_Id, String arrivalDate, String departureDate, String name, int room_ID,
			int room_Price, int restro_Price, int bar_Price, int service_price) {

		Booking_Id = booking_Id;
		ArrivalDate = arrivalDate;
		DepartureDate = departureDate;
		Name = name;
		Room_ID = room_ID;
		Room_Price = room_Price;
		Restro_Price = restro_Price;
		Bar_Price = bar_Price;
		Service_price = service_price;
	}

	public int getBooking_Id() {
		return Booking_Id;
	}

	public void setBooking_Id(int booking_Id) {
		Booking_Id = booking_Id;
	}

	public String getArrivalDate() {
		return ArrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		ArrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return DepartureDate;
	}

	public void setDepartureDate(String departureDate) {
		DepartureDate = departureDate;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getRoom_ID() {
		return Room_ID;
	}

	public void setRoom_ID(int room_ID) {
		Room_ID = room_ID;
	}

	public int getRoom_Price() {
		return Room_Price;
	}

	public void setRoom_Price(int room_Price) {
		Room_Price = room_Price;
	}

	public int getRestro_Price() {
		return Restro_Price;
	}

	public void setRestro_Price(int restro_Price) {
		Restro_Price = restro_Price;
	}

	public int getBar_Price() {
		return Bar_Price;
	}

	public void setBar_Price(int bar_Price) {
		Bar_Price = bar_Price;
	}

	public int getService_price() {
		return Service_price;
	}

	public void setService_price(int service_price) {
		Service_price = service_price;
	}

	@Override
	public String toString() {
		return "CheckoutClass2 [Booking_Id=" + Booking_Id + ", ArrivalDate=" + ArrivalDate + ", DepartureDate="
				+ DepartureDate + ", Name=" + Name + ", Room_ID=" + Room_ID + ", Room_Price=" + Room_Price
				+ ", Restro_Price=" + Restro_Price + ", Bar_Price=" + Bar_Price + ", Service_price=" + Service_price
				+ "]";
	}

}
