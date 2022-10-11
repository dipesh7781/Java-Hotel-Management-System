package mylibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import mylibs.Person;

public class RegistrationJDBC {

	public boolean insert(Registration reg) {
		// declare
		PreparedStatement pstat;
		boolean res = false;
		String sql = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");

			System.out.println("Customertype: " + reg.getCustomer_Type());
			if (reg.getCustomer_Type().equals("Manager") || reg.getCustomer_Type() == "Customer"
					|| reg.getCustomer_Type() == "Staff") {
				sql = "INSERT INTO Customer(Name,Email,Gender,Contact_No,Credit_Card_Information,Customer_Type, Password,Company_Name,Date_Of_Birth,Company_Registration_No) VALUES(?,?,?,?,?,?,?,?,?,?)";

				pstat = conn.prepareStatement(sql);
				pstat.setString(1, reg.getName());
				pstat.setString(2, reg.getEmail());
				pstat.setString(3, reg.getGender());
				pstat.setLong(4, reg.getContact_No());
				pstat.setString(5, reg.getCredit_Card_Information());
				pstat.setString(6, reg.getCustomer_Type());
				pstat.setString(7, reg.getPassword());
				pstat.setString(9, reg.getDate_Of_Birth());
				pstat.setString(8, reg.getCompany_Name().trim());
				pstat.setString(10, reg.getCompany_Registration_No().trim());
			} else {
				sql = "INSERT INTO Customer(Name,Email,Gender,Contact_No,Credit_Card_Information,Customer_Type, Password,Company_Name,Date_Of_Birth,Company_Registration_No) VALUES(?,?,?,?,?,?,?,?,?,?)";

				pstat = conn.prepareStatement(sql);
				pstat.setString(1, reg.getName());
				pstat.setString(2, reg.getEmail());
				pstat.setString(3, reg.getGender());
				pstat.setLong(4, reg.getContact_No());
				pstat.setString(5, reg.getCredit_Card_Information());
				pstat.setString(6, reg.getCustomer_Type());
				pstat.setString(7, reg.getPassword());
				pstat.setString(8, reg.getCompany_Name().trim());
				pstat.setString(9, reg.getDate_Of_Birth());
				pstat.setString(10, reg.getCompany_Registration_No().trim());
			}
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			res = true;

		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());

		}
		return res;

	}

	public ArrayList<Registration> selectAll() {
		String sql = "SELECT*FROM customer";
		Registration res = null;
		ArrayList<Registration> persons = new ArrayList<Registration>();

		try {
			// connect with database server
			Class.forName("com.mysql.cj.jdbc.Driver"); // LOAD DRIVER
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", ""); // connect
																													// driver
			PreparedStatement pstat = conn.prepareStatement(sql);
			// creating jdbc statement
			ResultSet rs = pstat.executeQuery();
			// pstat.setString(1, sql);
			while (rs.next()) {

				
				res = new Registration();
				res.setName(rs.getString("Name"));
				res.setEmail(rs.getString("Email"));

				persons.add(res);
			}
			rs.close();
			pstat.close();
			conn.close();

		} catch (Exception ex) {
			System.out.println("Error:" + ex.getMessage());
		}
		return persons;
	}

}
