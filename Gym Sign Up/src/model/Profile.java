package model;

public class Profile {
	private String username = "";
	private String password = "";
	private String type = "";
	private String fName = "";
	private String lName = "";
	private String sex = "";
	private String birthdate = "";
	private String maddress = "";
	private String city = "";
	private String state = "";
	private int zipcode = 0;
	private String telephone="";
	private String email="";
	private String application;

	public Profile() {
		super();
	}
	
	public Profile(String userName, String userPassword, String userType) {
		super();
		this.username = userName;
		this.password = userPassword;
		this.type = userType;
	}
	
	public Profile(String userName, String userPassword,
			String userType, String fName, String lName, String sex,
			String birthdate, String maddress, String city, String state, int zipcode, String telephone, String email) {
		super();
		this.username = userName;
		this.password = userPassword;
		this.type = userType;
		this.fName = fName;
		this.lName = lName;
		this.sex = sex;
		this.birthdate = birthdate;
		this.maddress = maddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.telephone = telephone;
		this.email = email;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String userPassword) {
		this.password = userPassword;
	}

	public String getType() {
		return type;
	}

	public void setType(String userType) {
		this.type = userType;
	}

	public String getFirstName() {
		return fName;
	}

	public void setFirstName(String fName) {
		this.fName = fName;
	}

	public String getLastName() {
		return lName;
	}

	public void setLastName(String lName) {
		this.lName = lName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDate() {
		return birthdate;
	}

	public void setBirthDate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getMAddress() {
		return maddress;
	}

	public void setMAddress(String maddress) {
		this.maddress = maddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipcode;
	}

	public void setZipCode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "Profile [userName=" + username
				+ ", userPassword=" + password + ", userType=" + type
				+ ", fName=" + fName + ", lName=" + lName + ", birthdate=" + birthdate
				+ ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", telephone=" + telephone + ", email=" + email + ",application="+application+"]";
	}

}
	
	
	
	