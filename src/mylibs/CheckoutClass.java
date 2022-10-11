package mylibs;

//for inner join
public class CheckoutClass {

	int Booking_Id;
	String ArrivalDate;
	String DepartureDate;
	String Name;
	int Room_ID;
	int Room_Price;
	int Restro_Price;
	int Bar_Price;
	int Service_price;
	int discount;
	int vat_Amt;
	double total_Bill;
	double return_Amt;
	String billing_Status;

	public CheckoutClass() {
		Booking_Id = 0;
		ArrivalDate = "";
		DepartureDate = "";
		Name = "";
		Room_ID = 0;
		Room_Price = 0;
		Restro_Price = 0;
		Bar_Price = 0;
		Service_price = 0;
		this.discount = 0;
		this.vat_Amt = 0;
		this.total_Bill = 0.0;
		this.return_Amt = 0.0;
		this.billing_Status = "";
	}

	public CheckoutClass(int booking_Id, String arrivalDate, String departureDate, String name, int room_ID,
			int room_Price, int restro_Price, int bar_Price, int service_price, int discount, int vat_Amt,
			double total_Bill, double return_Amt, String billing_Status) {
		Booking_Id = booking_Id;
		ArrivalDate = arrivalDate;
		DepartureDate = departureDate;
		Name = name;
		Room_ID = room_ID;
		Room_Price = room_Price;
		Restro_Price = restro_Price;
		Bar_Price = bar_Price;
		Service_price = service_price;
		this.discount = discount;
		this.vat_Amt = vat_Amt;
		this.total_Bill = total_Bill;
		this.return_Amt = return_Amt;
		this.billing_Status = billing_Status;
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

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getVat_Amt() {
		return vat_Amt;
	}

	public void setVat_Amt(int vat_Amt) {
		this.vat_Amt = vat_Amt;
	}

	public double getTotal_Bill() {
		return total_Bill;
	}

	public void setTotal_Bill(double total_Bill) {
		this.total_Bill = total_Bill;
	}

	public double getReturn_Amt() {
		return return_Amt;
	}

	public void setReturn_Amt(double return_Amt) {
		this.return_Amt = return_Amt;
	}

	public String getBilling_Status() {
		return billing_Status;
	}

	public void setBilling_Status(String billing_Status) {
		this.billing_Status = billing_Status;
	}

	@Override
	public String toString() {
		return "CheckoutClass2 [Booking_Id=" + Booking_Id + ", ArrivalDate=" + ArrivalDate + ", DepartureDate="
				+ DepartureDate + ", Name=" + Name + ", Room_ID=" + Room_ID + ", Room_Price=" + Room_Price
				+ ", Restro_Price=" + Restro_Price + ", Bar_Price=" + Bar_Price + ", Service_price=" + Service_price
				+ ", discount=" + discount + ", vat_Amt=" + vat_Amt + ", total_Bill=" + total_Bill + ", return_Amt="
				+ return_Amt + ", billing_Status=" + billing_Status + "]";
	}

}
