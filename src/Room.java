
public class Room {
	int squareMeters;
	int rentPrice;
	String city;
	public Room(int squaremeter, int price, String city) {
		this.squareMeters = squaremeter;
		this.rentPrice = price;
		this.city = city;
	}
	public int getSquareMeters() {
		return squareMeters;
	}
	public void setSquareMeters(int squareMeters) {
		this.squareMeters = squareMeters;
	}
	public int getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
