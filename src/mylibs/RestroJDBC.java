package mylibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RestroJDBC {

	public boolean insert(RestroClass Rest) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO Restro (Booking_ID,Food_Type,Food_Price) VALUES (?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");

			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1,Rest.getBookingId());
			pstat.setString(2,Rest.getFood_Type());//  set values
			pstat.setInt(3, Rest.getPrice());
			

			
			pstat.executeUpdate();

			conn.close();
			pstat.close();
			result = true;
		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	
	public ArrayList select_all() {
		String sql = "SELECT * FROM Restro ";
		ArrayList<RestroClass> Rest = new ArrayList();// collection
		try {
			// 1.Connect with database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");// connect
																												// Driver
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				RestroClass res = new RestroClass
						(rs.getInt("Restro_Id"),
						 rs.getString("Food_Type"),
						 rs.getInt("Food_Price"),
						 rs.getInt("Booking_ID"));
				Rest.add(res);
						
			}
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return Rest;
	}

}
