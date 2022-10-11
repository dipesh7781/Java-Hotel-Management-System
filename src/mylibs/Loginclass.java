package mylibs;

public class Loginclass {
	String Email;
	String Password;
	String name;
	int id;
	String UserType;

	public Loginclass() {
		super();
		Email = "";
		Password = "";
		this.name = "";
		this.id = 0;
		UserType = "";
	}

	public Loginclass(String email, String password, String name, int id, String userType) {
		super();
		Email = email;
		Password = password;
		this.name = name;
		this.id = id;
		UserType = userType;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	@Override
	public String toString() {
		return "Loginclass [Email=" + Email + ", Password=" + Password + ", name=" + name + ", id=" + id + ", UserType="
				+ UserType + "]";
	}

}