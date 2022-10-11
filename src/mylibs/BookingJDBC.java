
package mylibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import Database.Database;

public class BookingJDBC {

	public boolean insert(Bookingclass bok) {
		// declare
		PreparedStatement pstat;
		boolean res = false;
		String sql = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");
			{
				sql = "INSERT INTO Booking(Start_Date, End_Date,Prefered_Room,Booking_Status,Customer_ID,Room_Price) VALUES(?,?,?,?,?,?)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, bok.getStart_Date());
				pstat.setString(2, bok.getEnd_Date());
				pstat.setString(3, bok.getRoom_Type());
				pstat.setString(4, bok.getRoom_Status());
				pstat.setInt(5, bok.getCustomer_Id());
				pstat.setDouble(6, bok.getRoom_Price());
				// pstat.setInt(5, bok.getRoom_no());

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

	public boolean update(Bookingclass bok) {

		// declare
		Connection conn;
		boolean res = false;

		String sql = "UPDATE Booking SET Start_Date=?,End_Date=?,Prefered_Room=?,Room_Price=? WHERE Booking_ID=?";
		PreparedStatement pstat; // create jdbc statement
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// 1.loading driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", ""); // connect
			pstat = conn.prepareStatement(sql);// create jdbc statement
			pstat.setString(1, bok.getStart_Date());
			pstat.setString(2, bok.getEnd_Date());
			pstat.setString(3, bok.getRoom_Type());
			pstat.setDouble(4, bok.getRoom_Price()); 
			pstat.setInt(5, bok.getBooking_Id());
			// setvalues
			pstat.executeUpdate();// running sql statement
			conn.close();// Close connection
			res = true;
			// input, process, output

		} catch (Exception ex) {
			res = false;
			// error message
			JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage());
//		System.out.println("Error:" + ex.getMessage());
		}

		return res;
	}

	public boolean delete(Bookingclass bok) {
		boolean result = false;
		Connection conn;
		PreparedStatement pstat;
		Resultset rs;
		String sql = "Delete FROM Booking WHERE Booking_ID=?";

		try {
			Database db = new Database();
			conn = db.connect();// method calling
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, bok.getBooking_Id());
			pstat.executeUpdate();
			result = true;

		} catch (Exception ae) {
			JOptionPane.showMessageDialog(null, "Error:" + ae.getMessage());

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
