
public class User {
	String username;
	String password;
	String soort;
	public User(String username, String password, String soort) {
		this.username = username;
		this.password = password;
		this.soort = soort;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSoort() {
		return this.soort;
	}
	
	public void setSoort() {
		this.soort = soort;
	}
	
}
