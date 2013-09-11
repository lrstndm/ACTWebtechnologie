import java.util.ArrayList;


public class Persons {
	ArrayList<User> users;
	
	public Persons()
	{
		users = new ArrayList<User>();
	}
	
	public void addUser(User user)
	{
		users.add(user);
	}

	public ArrayList<User> getUsers() {
		return users;
	}
}
