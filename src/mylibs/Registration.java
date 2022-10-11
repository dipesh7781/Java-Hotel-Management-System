package mylibs;

public class Registration {
	String Name;
	String Email;
	String Gender;
	long Contact_No;
	String Credit_Card_Information;
	String Customer_Type;
	String Password;
	String Company_Name;
	String Date_Of_Birth;
	String Company_Registration_No;
	
	public Registration() { ;
		this.Name = "";
		this.Email = "";
		this.Gender = "";
		this.Contact_No = 0;
		this.Credit_Card_Information = "";
		this.Customer_Type ="";
		this.Password = "";
		this.Company_Name = "";
		this.Date_Of_Birth = ""; 
		this.Company_Registration_No = "";
	}
	
		
	public Registration(int customer_ID, String name, String email, String gender, int contact_No,
			String credit_Card_Information, String customer_Type, String password, String company_Name,
			String date_Of_Birth, String company_Registration_No) { ;
			
			this.Name = name;
			this.Email = email;
			this.Gender = gender;
			this.Contact_No = contact_No;
			this.Credit_Card_Information = credit_Card_Information;
			this.Customer_Type = customer_Type;
			this.Password = password;
			this.Company_Name = company_Name;
			this.Date_Of_Birth = date_Of_Birth;
			this.Company_Registration_No = company_Registration_No;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getGender() {
		return this.Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public long getContact_No() {
		return this.Contact_No;
	}

	public void setContact_No(long Contact_No) {
		this.Contact_No = Contact_No;
	}

	public String getCredit_Card_Information() {
		return this.Credit_Card_Information;
	}

	public void setCredit_Card_Information(String credit_Card_Information) {
		this.Credit_Card_Information = credit_Card_Information;
	}

	public String getCustomer_Type() {
		return this.Customer_Type;
	}

	public void setCustomer_Type(String customer_Type) {
		this.Customer_Type = customer_Type;
	}

	public String getPassword() {
		return this.Password;
	}
	
	public void setPassword(String password) {
		this.Password = password;
	}

	public String getCompany_Name() {
		return this.Company_Name;
	}

	public void setCompany_Name(String company_Name) {
		System.out.println(company_Name);
		this.Company_Name = company_Name;
	}

	public String getDate_Of_Birth() {
		return this.Date_Of_Birth;
	}
 
	public void setDate_Of_Birth(String date_Of_Birth) {
		this.Date_Of_Birth = date_Of_Birth;
	}

	public String getCompany_Registration_No() {
		return this.Company_Registration_No;
	}

	public void setCompany_Registration_No(String Company_Registration_No) {
		System.out.println(Company_Registration_No);
		this.Company_Registration_No = Company_Registration_No;
	}

	@Override
	public String toString() {
		return "Registration [Name=" + Name + ", Email=" + Email + ", Gender=" + Gender
				+ ", Contact_No=" + Contact_No + ", Credit_Card_Information=" + Credit_Card_Information
				+ ", Customer_Type=" + Customer_Type + ", Password=" + Password + ", Company_Name=" + Company_Name
				+ ", Date_Of_Birth=" + Date_Of_Birth + ", Company_Registration_No=" + Company_Registration_No + "]";
	}
	
	
	
 }
