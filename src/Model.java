import java.util.ArrayList;
import java.util.Iterator;


public class Model {
	ArrayList<User> users;
	ArrayList<Room> rooms;
	
	public Model()
	{
		users = new ArrayList<User>();
		rooms = new ArrayList<Room>();
	}
	
	public void addRoom(Room room)
	{
		rooms.add(room);
	}
	
	public ArrayList<Room> getRooms()
	{
		return rooms;
	}
	
	public void addUser(User user)
	{
		users.add(user);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Room> search(int squaremeter, int maxPrice, String city) {
		System.out.println("Searched: " + squaremeter + " - " + maxPrice + " - " + city);
		ArrayList<Room> rooms = getRooms();
		ArrayList<Room> matchedRooms = new ArrayList<Room>();
		
		int i = 0;

		for (Iterator<Room> iter = rooms.iterator(); iter.hasNext(); ) {
			boolean matched = true;
			Room room = iter.next();
			
			System.out.println("Checking room: " + room.getSquareMeters() + " - " + room.getRentPrice() + " - " + room.getCity());
//			
//		  	if (room.getSquareMeters() != squaremeter && (room.getSquareMeters() > 0)) {
//		  		System.out.println("squareMeter not matched");
//				matched = false;
//			} else if (room.getRentPrice() > maxPrice && (room.getRentPrice() > 0)) {
//				System.out.println("rentprice not matched");
//				matched = false;
//			} else if (!room.getCity().equals(city) && (!room.getCity().isEmpty() || room.getCity().equals(""))) {
//				System.out.println("city not matched");
//				matched = false;
//			}
		  	if(room.getSquareMeters() != squaremeter) { continue; }
		  	if(room.getRentPrice() > maxPrice){ continue; }
		  	if(!room.getCity().toLowerCase().equals(city.toLowerCase()) || (room.getCity().toLowerCase().equals(""))){ continue; }
			
		  	//if (matched) {
		  		System.out.println("Room added: " + room.getSquareMeters() + " - " + room.getRentPrice() + " - " + room.getCity());
		  		matchedRooms.add(room);
		  	//}
		}
		
		return matchedRooms;
	}
}
