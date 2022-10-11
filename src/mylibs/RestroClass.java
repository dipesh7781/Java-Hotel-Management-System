package mylibs;

public class RestroClass {
	int RestroId;
	String Food_Type;
	int Price;
	int BookingId;
	
	public RestroClass() {
		
		this.RestroId = 0;
		this.Food_Type ="";
		this.Price = 0;
		this.BookingId = 0;
	}
	
	public RestroClass(int RestroId, String Food_Type, int price, int bookingId) {
		
		this.RestroId = RestroId;
		this.Food_Type = Food_Type;
		this.Price = price;
		this.BookingId = bookingId;
	}

	public int getRestroId() {
		return RestroId;
	}

	public void setRestroId(int RestroId) {
		this.RestroId = RestroId;
	}

	public String getFood_Type() {
		return Food_Type;
	}

	public void setFood_Type(String restroType) {
		Food_Type = restroType;
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
		return "RestroClass [RestroId=" + RestroId + ", RestroType=" + Food_Type + ", Price=" + Price
				+ ", BookingId=" + BookingId + "]";
	}
	
}
