package mylibs;

public class ServiceClass {
	int serviceId;
	String ServiceType;
	int ServicePrice;
	int BookinId;
	
	public ServiceClass() {
		this.serviceId = 0;
		ServiceType = "";
		ServicePrice = 0;
		BookinId = 0;
		
	}
	public ServiceClass(int serviceId, String serviceType, int servicePrice, int bookinId) {
		
		this.serviceId = serviceId;
		ServiceType = serviceType;
		ServicePrice = servicePrice;
		BookinId = bookinId;
		
	
		
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceType() {
		return ServiceType;
	}
	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}
	public int getServicePrice() {
		return ServicePrice;
	}
	public void setServicePrice(int servicePrice) {
		ServicePrice = servicePrice;
	}
	public int getBookinId() {
		return BookinId;
	}
	public void setBookinId(int bookinId) {
		BookinId = bookinId;
	}
	@Override
	public String toString() {
		return "ServiceClass [serviceId=" + serviceId + ", ServiceType=" + ServiceType + ", ServicePrice="
				+ ServicePrice + ", BookinId=" + BookinId + "]";
	}
	
	
}
