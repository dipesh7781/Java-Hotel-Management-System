package mylibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset; 

import Database.Database;

public class CheckInJDBC extends Database {
	Connection conn;
	PreparedStatement pstat;
	ResultSet rs;

	public ArrayList<CheckInlibs> getCheckIn() {
		ArrayList<CheckInlibs> check = new ArrayList<CheckInlibs>();
		String sql = "SELECT * FROM booking WHERE Booking_Status='Booked'";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			while (rs.next()) {
				CheckInlibs checkIn = new CheckInlibs(rs.getInt("Booking_ID"), rs.getInt("room_Id"),
						rs.getString("Start_Date"), rs.getString("End_Date"), rs.getString("Prefered_Room"),
						rs.getString("Booking_Status"), rs.getDouble("Room_Price"));
				check.add(checkIn);
			}
		} catch (Exception ex) {

		}
		return check;
	}

	public boolean updateCheckIn(CheckInlibs checkin) {
		boolean result = true;
		String sql = "update booking set Booking_Status= 'CheckedIn' where Booking_ID=?";
		String sql1 = " update room set rom_Status='Occupied' where room_Id=?";
		try {
			conn= connect();
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, checkin.getBooking_id());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			
			conn=connect();
			pstat=conn.prepareStatement(sql1);
			pstat.setInt(1, checkin.getRoom_Id());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			
			result= true;
			
			
		} catch (Exception e) {
			System.out.println("Error:"+ e.getMessage());
		}
		return result;

	}
	
	public ArrayList<Bookingclass> getCustomerData(int id) {
		ArrayList<Bookingclass> booking = new ArrayList<Bookingclass>();
		try {
			Database db = new Database();
			Connection conn;
			conn = db.connect();
			String sql = "SELECT* FROM Booking WHERE Customer_Id=?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Bookingclass book = new Bookingclass(rs.getInt("Booking_ID"),rs.getInt("Customer_ID"),rs.getInt("room_Id"),rs.getString("Start_Date"),rs.getString("End_Date"),
						rs.getString("Prefered_Room"),rs.getString("Booking_Status"),rs.getDouble("Room_Price"));
				booking.add(book);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage());
		}
		return booking;
	}
}
