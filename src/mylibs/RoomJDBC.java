package mylibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class RoomJDBC{
	public boolean insert(Roomclass row) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String SQL = "INSERT INTO room(room_Id,room_Type,room_Price,room_Status) VALUES (?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");

			pstat = conn.prepareStatement(SQL);
			
			pstat.setInt(1, row.getRoom_no());
			pstat.setString(2, row.getRoom_Type());
			pstat.setDouble(3, row.getRoom_Price());
			pstat.setString(4, row.getRoom_Status());

			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}

		public boolean update(Roomclass row) {

			Connection conn;
			PreparedStatement pstat;
			boolean result = false;
			String SQL = "UPDATE INTO room(room_Id,room_Type,room_Price,room_Status) VALUES (?,?,?,?)";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");

				pstat = conn.prepareStatement(SQL);
				
				pstat.setInt(1, row.getRoom_no());
				pstat.setString(2, row.getRoom_Type());
				pstat.setDouble(3, row.getRoom_Price());
				pstat.setString(4, row.getRoom_Status());

				pstat.executeUpdate();
				pstat.close();
				conn.close();
				result = true;
			} catch (Exception ex) {
				System.out.println("Error" + ex.getMessage());
			}
			return result;

		}
		

//		//Available room
//		public ArrayList searchAvailableRoom() {
//			Connection con;
//			PreparedStatement pstat;
//			ResultSet rs;
//			String sql = "SELECT * FROM room WHERE room_Status = 'Available'";
//			ArrayList<Roomclass>tmpPerson = new ArrayList();
//
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");
//				pstat = conn.prepareStatement(sql);
//				
//				rs = pstat.executeQuery();
//				while (rs.next()) {
//					Roomclass room = new Roomclass
//							(rs.getInt("room_no"),
//							rs.getString("room_Type"), 
//							rs.getInt("room_Price"),
//							rs.getString("room_Status "));
//					
//					tmpPerson.add(room);
//				}
//				
//				
//				rs.close();
//				pstat.close();
//				conn.close();
//
//			} catch (Exception ex) {
//				System.out.println("Error : " + ex.getMessage());
//				
//			}
//			return tmpPerson;
//		}

	}