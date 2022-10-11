package mylibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Database.Database;

public class CheckoutJDBC extends Database {

	Connection conn;
	PreparedStatement pstat;
	ResultSet rs;

	SimpleDateFormat dateformate = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String currentDate = dateformate.format(date);

	public ArrayList<CheckoutClass2> billing() {

		ArrayList<CheckoutClass2> Bill = new ArrayList<CheckoutClass2>();

		String sql = "SELECT b.Booking_ID,b.Start_Date,b.End_Date,c.Name,b.room_Id,b.Room_Price,s.service_price,ba.Bar_Price,r.Food_Price\r\n"
				+ "from booking as b\r\n" + "inner join customer as c \r\n" + "on b.Customer_ID = c.Customer_ID\r\n"
				+ "inner join restro as r\r\n" + "on b.Booking_ID = r.Booking_ID\r\n" + "inner join bar as ba\r\n"
				+ "on b.Booking_ID = ba.Booking_ID\r\n" + "inner join service as s\r\n"
				+ "on b.Booking_ID = s.Booking_ID\r\n";
		try {
			conn = connect();

			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			while (rs.next()) {
				CheckoutClass2 bill = new CheckoutClass2(rs.getInt("Booking_ID"), rs.getString("Start_Date"),
						rs.getString("End_Date"), rs.getString("Name"), rs.getInt("room_Id"), rs.getInt("Room_Price"),
						rs.getInt("service_price"), rs.getInt("Bar_Price"), rs.getInt("Food_Price"));

				Bill.add(bill);
			}

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return Bill;

	}

	public boolean insertBill(CheckoutClass check) {
		boolean result = false;
		String sql = "INSERT INTO billing(Name,Drink_Price,Service_price,Food_Price,Room_Price,Total_Bill,Return_Amount,Discount,Billing_Status)\r\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?\r\n" + ")";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, check.getName());
			pstat.setInt(2, check.getBar_Price());
			pstat.setInt(3, check.getService_price());
			pstat.setInt(4, check.getRestro_Price());
			pstat.setInt(5, check.getRoom_Price());
			pstat.setDouble(6, check.getTotal_Bill());
			pstat.setDouble(7, check.getReturn_Amt());
			pstat.setInt(8, check.getDiscount());
			pstat.setString(9, check.getBilling_Status());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error : "+e.getMessage());
		}
		return result;
	}

}