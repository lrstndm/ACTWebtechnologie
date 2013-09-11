import java.util.ArrayList;


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
		ArrayList<Room> foundRooms = getRooms();
		
		int i = 0;
		for (Room room : foundRooms) {
			if (room.getSquareMeters() != squaremeter && squaremeter != 0) {
				foundRooms.remove(i);	
			} else if (room.getRentPrice() > maxPrice && squaremeter != 0) {
				foundRooms.remove(i);
			} else if (room.getCity().equals(city) && !city.isEmpty()) {
				foundRooms.remove(i);
			}
			i++;
		}
		
		return foundRooms;
	}
}
