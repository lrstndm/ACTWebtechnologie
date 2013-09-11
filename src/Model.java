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
}
