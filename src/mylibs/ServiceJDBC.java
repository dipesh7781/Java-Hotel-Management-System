package mylibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServiceJDBC {

	public boolean insert(ServiceClass service) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO service (Booking_ID,service_Type,service_price) VALUES (?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");

			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, service.getBookinId());
			pstat.setString(2,service.getServiceType());//  set values
			pstat.setInt(3, service.getServicePrice());
			

			
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
		String sql = "SELECT * FROM service ";
		ArrayList<ServiceClass> serv = new ArrayList();// collection
		try {
			// 1.Connect with database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");// connect
																												// Driver
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				ServiceClass res = new ServiceClass
						(rs.getInt("service_Id"),
						 rs.getString("service_Type"),
						 rs.getInt("service_price"),
						 rs.getInt("Booking_ID"));
				serv.add(res);
						
			}
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return serv;
	}

}