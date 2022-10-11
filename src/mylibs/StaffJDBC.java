package mylibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Database.Database;

public class StaffJDBC extends Database {
	// global variable
	Connection conn;
	PreparedStatement pstat;
	ResultSet rs;
	// ArrayList<StaffClass> book= new ArrayList<StaffClass>();

	// to get pending list of customers in receiptionist window
	public ArrayList<StaffClass> getPending() {

		ArrayList<StaffClass> arrayBooking = new ArrayList<StaffClass>();
		String sql = "select b.Booking_ID, b.Start_Date, b.End_Date, b.Prefered_Room,b.Booking_Status, c.Name, c.Email, c.Credit_Card_Information,b.room_Id\r\n"
				+ "from booking as b\r\n" + "inner join customer as c\r\n" + "on b.Customer_ID = c.Customer_ID\r\n"
				+ "Where b.Booking_Status= 'Pending'";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			while (rs.next()) {
				StaffClass st = new StaffClass(rs.getInt("Booking_ID"), rs.getString("Name"), rs.getString("Email"),
						rs.getString("Credit_Card_Information"), rs.getString("Start_Date"), rs.getString("End_Date"),
						rs.getString("Prefered_Room"), rs.getString("Booking_Status"), rs.getInt("room_Id"));
				arrayBooking.add(st);
			}

		} catch (Exception ex) {
			System.out.println("ERROR : " + ex.getMessage());
		}
		return arrayBooking;
	}

	public ArrayList getroom(StaffClass staff) {
		ArrayList row = new ArrayList();
		String Sql = "select room_Id from room where Room_Status = 'Available' AND room_Type=?";
		try {
			conn = connect();
			pstat = conn.prepareStatement(Sql);
			pstat.setString(1, staff.getRoomtype());
			rs = pstat.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				int roomno = rs.getInt("room_Id");
				row.add(roomno);
			}

		} catch (Exception ex) {
			System.out.println("ERROR;" + ex.getMessage());
		}
		return row;
	}

	public boolean updateBooking(StaffClass staff) {
		boolean result = false;
		String sql = "Update booking SET Booking_Status='Booked' , room_Id=? WHERE Booking_ID=?";
		String sql1 = "Update room SET room_Status='Booked' WHERE room_Id=?";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, staff.getRoom_ID());
			pstat.setInt(2, staff.getBookingID());
			pstat.executeUpdate();
			pstat.close();
			conn.close();

			conn = connect();
			pstat = conn.prepareStatement(sql1);
			pstat.setInt(1, staff.getRoom_ID());
			pstat.executeUpdate();
			pstat.close();
			conn.close();

			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}

		return result;
	}

	// to get booked list of customers in receiptionist window
	public ArrayList<StaffClass> getBooked() {

		ArrayList<StaffClass> arrayBooking = new ArrayList<StaffClass>();
		String sql = "select b.Booking_ID, b.Start_Date, b.End_Date, b.Prefered_Room,b.Booking_Status, c.Name, c.Email, c.Credit_Card_Information,b.room_Id\r\n"
				+ "from booking as b\r\n" + "inner join customer as c\r\n" + "on b.Customer_ID = c.Customer_ID\r\n"
				+ "Where b.Booking_Status= 'Booked'";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			while (rs.next()) {
				StaffClass st = new StaffClass(rs.getInt("Booking_ID"), rs.getString("Name"), rs.getString("Email"),
						rs.getString("Credit_Card_Information"), rs.getString("Start_Date"), rs.getString("End_Date"),
						rs.getString("Prefered_Room"), rs.getString("Booking_Status"), rs.getInt("room_Id"));
				arrayBooking.add(st);
			}

		} catch (Exception ex) {
			System.out.println("ERROR : " + ex.getMessage());
		}
		return arrayBooking;
	}

	// to get checkedin list of customers in receiptionist window
	public ArrayList<StaffClass> getCheckIn() {

		ArrayList<StaffClass> arrayBooking = new ArrayList<StaffClass>();
		String sql = "select b.Booking_ID, b.Start_Date, b.End_Date, b.Prefered_Room,b.Booking_Status, c.Name, c.Email, c.Credit_Card_Information,b.room_Id\r\n"
				+ "from booking as b\r\n" + "inner join customer as c\r\n" + "on b.Customer_ID = c.Customer_ID\r\n"
				+ "Where b.Booking_Status= 'CheckedIn'";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			while (rs.next()) {
				StaffClass st = new StaffClass(rs.getInt("Booking_ID"), rs.getString("Name"), rs.getString("Email"),
						rs.getString("Credit_Card_Information"), rs.getString("Start_Date"), rs.getString("End_Date"),
						rs.getString("Prefered_Room"), rs.getString("Booking_Status"), rs.getInt("room_Id"));
				arrayBooking.add(st);
			}

		} catch (Exception ex) {
			System.out.println("ERROR : " + ex.getMessage());
		}
		return arrayBooking;
	}
}
