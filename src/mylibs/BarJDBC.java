package mylibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mylibs.BarClass;

public class BarJDBC {
	
	public boolean insert(BarClass bar) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO Bar (Booking_ID,Bar_Type,Bar_Price) VALUES (?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");

			pstat = conn.prepareStatement(sql);

			pstat.setInt(1, bar.getBookingId());
			pstat.setString(2, bar.getDrinkType());// set values
			pstat.setInt(3, bar.getPrice());

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
		String sql = "SELECT * FROM Bar ";
		ArrayList<BarClass>  bb = new ArrayList();// collection
		try {
			// 1.Connect with database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");// connect
																												// Driver
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				BarClass res = new BarClass
						(rs.getInt("bar_Id"),
						 rs.getString("Bar_Type"),
						 rs.getInt("Bar_Price"),
						 rs.getInt("Booking_ID"));
				bb.add(res);
						
			}
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return bb;
	}

}
