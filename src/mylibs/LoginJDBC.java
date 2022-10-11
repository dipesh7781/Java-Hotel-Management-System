package mylibs;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylibs.Loginclass;

public class LoginJDBC {
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/Assignment";
	final String USER = "root";
	final String PASS = "";
	boolean b = false;

	public boolean select(Loginclass log) {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM customer WHERE Email= ? and  Password=?";
	//	Loginclass tmpLogin = new Loginclass();
		

		try {
			Class.forName(DRIVER); // load driver
			conn = DriverManager.getConnection(URL, USER, PASS); // connect driver
			pstat = conn.prepareStatement(sql);// creating jdbc statement initialize
			pstat.setString(1, log.getEmail());
			pstat.setString(2, log.getPassword());
			rs = pstat.executeQuery();
			//System.out.println("Deepesh");
			while (rs.next()) {
				log.setId(rs.getInt("Customer_ID"));
				log.setName(rs.getString("Name"));
				log.setEmail(rs.getString("Email"));
				log.setPassword(rs.getString("Password"));
				log.setUserType((rs.getString("Customer_Type")));
				System.out.println(log.toString());
				//System.out.println("log.getEmail, log.getPassword");
			//	System.out.println("Login successful!!!");
				b=true;
				
				
			}
			//System.out.println(rs);
			rs.close();
			pstat.close();
			conn.close();
		}

		catch (Exception ex) {
			System.out.println("Inside error.");
			//System.out.println("Error:" + ex.getMessage());
			b=false;
		}

		return b;
	}
}
