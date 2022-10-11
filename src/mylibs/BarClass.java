package mylibs;

public class BarClass {
	
	int BarId;
	String DrinkType;
	int Price;
	int BookingId;
	
	public BarClass(){
		//Default constructor
		BarId = 0;
		DrinkType = "";
		Price = 0;
		BookingId = 0;
	}

	public BarClass(int barId, String drinkType, int price, int bookingId) {
		//paramitarized constructor
		BarId = barId;
		DrinkType = drinkType;
		Price = price;
		BookingId = bookingId;
	}

	//getter and setter
	public int getBarId() {
		return BarId;
	}


	public void setBarId(int barId) {
		BarId = barId;
	}


	public String getDrinkType() {
		return DrinkType;
	}


	public void setDrinkType(String drinkType) {
		DrinkType = drinkType;
	}


	public int getPrice() {
		return Price;
	}


	public void setPrice(int price) {
		Price = price;
	}


	public int getBookingId() {
		return BookingId;
	}


	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}


	@Override
	public String toString() {
		return "BarClass [BarId=" + BarId + ", DrinkType=" + DrinkType + ", Price=" + Price + ", BookingId=" + BookingId
				+ "]";
	}

	
}
