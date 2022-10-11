package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Database.Database;
import mylibs.BookingJDBC;
import mylibs.Bookingclass;
import mylibs.Global;

public class Booking extends JFrame implements ActionListener, ItemListener, MouseListener {

	JPanel panel1;
	JTextField txtprice;
	JButton btnsave, btnupdate, btnpay, btndelete, btnclose;
	JLabel lblarv, lbldep, lblroom, lblprice, lblno, lblbook, lblname;
	JComboBox cmbroomtype, cmbno;

	JScrollPane scroll;
	JScrollPane scrollPane;
	JDateChooser arrivaldate, departuredate;
	BookingJDBC bjdbc;
	String selroomtype = "";

	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm);
	Object[] obj;
//	ArrayList<CheckInLibs> checkIn;
	ArrayList roomNumber;
	// CheckInLibs check = new CheckInLibs()

	// global variable
	int id;
	String email, name;
	Bookingclass bok = new Bookingclass();

	public Booking(int id, String email, String name) {
		// store value
		this.id = id;
		this.email = email;
		this.name = name;

		// Initialize and memory allocation
		bjdbc = new BookingJDBC();
		getContentPane().setBackground(Color.YELLOW);
		setTitle("Booking Form");
		setBounds(100, 100, 750, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		panel1 = new JPanel();
		panel1.setBounds(0, 210, 734, 290);
		add(panel1);

		lblarv = new JLabel("Arrival Date");
		lblarv.setBounds(31, 50, 97, 14);
		getContentPane().setLayout(null);
		getContentPane().add(lblarv);

		lblroom = new JLabel("Departure Date");
		lblroom.setBounds(31, 79, 97, 14);
		getContentPane().add(lblroom);

		btnsave = new JButton("Save");
		btnsave.setBackground(Color.GREEN);
		btnsave.setBounds(239, 162, 89, 23);
		getContentPane().add(btnsave);
		btnsave.addActionListener(this);

		btnpay = new JButton("Pay");
		btnpay.setBackground(Color.YELLOW);
		btnpay.setBounds(338, 162, 89, 23);
		getContentPane().add(btnpay);
		btnpay.addActionListener(this);

		btnupdate = new JButton("Update");
		btnupdate.setBackground(Color.MAGENTA);
		btnupdate.setBounds(437, 162, 89, 23);
		getContentPane().add(btnupdate);
		btnupdate.addActionListener(this);

		btndelete = new JButton("Cancel");
		btndelete.setBackground(Color.RED);
		btndelete.setBounds(536, 162, 89, 23);
		getContentPane().add(btndelete);
		btndelete.addActionListener(this);

		btnclose = new JButton("Close");
		btnclose.setBackground(Color.PINK);
		btnclose.setBounds(635, 162, 89, 23);
		getContentPane().add(btnclose);
		btnclose.addActionListener(this);

		cmbroomtype = new JComboBox();
		for (int i = 0; i < Global.ROOM_TYPE.length; i++) {
			cmbroomtype.addItem(Global.ROOM_TYPE[i]);
		}
		cmbroomtype.addItemListener(this);
		cmbroomtype.setBounds(555, 63, 131, 22);
		getContentPane().add(cmbroomtype);

		
		
		Date date = new Date();

		
		arrivaldate = new JDateChooser();
		arrivaldate.setBounds(151, 46, 108, 22);
		arrivaldate.setDateFormatString("yyyy-MM-dd");
		add(arrivaldate);
		arrivaldate.setMinSelectableDate(date);

		departuredate = new JDateChooser();
		departuredate.setBounds(151, 75, 108, 22);
		departuredate.setMinSelectableDate(date);

		departuredate.setDateFormatString("yyyy-MM-dd");
		add(departuredate);

		lbldep = new JLabel("RoomType");
		lbldep.setBounds(409, 67, 136, 14);
		getContentPane().add(lbldep);

		lblroom = new JLabel("Room Price");
		lblroom.setBounds(409, 111, 89, 14);
		getContentPane().add(lblroom);

		txtprice = new JTextField();
		txtprice.setBounds(555, 108, 86, 20);
		txtprice.setEditable(false);
		getContentPane().add(txtprice);
		txtprice.setColumns(10);

		lblbook = new JLabel("BOOKING FORM");
		lblbook.setForeground(Color.RED);
		lblbook.setBackground(Color.WHITE);
		lblbook.setFont(new Font("Corbel", Font.BOLD, 26));
		lblbook.setBounds(262, 11, 236, 32);
		getContentPane().add(lblbook);

		table = new JTable(dtm);
		table.setPreferredScrollableViewportSize(new Dimension(730, 290));
		table.setFillsViewportHeight(true);
		displayTable();
		panel1.add(new JScrollPane(table));

		table.addMouseListener(this);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnclose) {
			// Corporate corp = new Corporate(id, email, name);
			setVisible(false);
		}

		if (ae.getSource() == btnsave) {

			Bookingclass bok = new Bookingclass();
			bok.setCustomer_Id(this.id);
			String arrDate = ((JTextField) arrivaldate.getDateEditor().getUiComponent()).getText();

			String depDate = ((JTextField) departuredate.getDateEditor().getUiComponent()).getText();
			bok.setStart_Date(arrDate);
			bok.setEnd_Date(depDate);

			bok.setRoom_Type(cmbroomtype.getSelectedItem().toString());
			bok.setRoom_Price(Double.parseDouble(txtprice.getText().toString()));

			BookingJDBC jdbc = new BookingJDBC();
			boolean result = jdbc.insert(bok);
			if (result == true) {
				// to display message in dialog box
				JOptionPane.showMessageDialog(null, "Saved Succesfully");
				displayTable();
			} else {
				JOptionPane.showMessageDialog(null, "Error");
			}
			result = false;

		} else if (ae.getSource() == btnupdate) {

			if (bok.getRoom_Status().equals("CheckedIn")) {
				JOptionPane.showMessageDialog(null, "Cannot Update Room ");

			}

			else {

				String arrDate = ((JTextField) arrivaldate.getDateEditor().getUiComponent()).getText();

				String depDate = ((JTextField) departuredate.getDateEditor().getUiComponent()).getText();
				bok.setStart_Date(arrDate);
				bok.setEnd_Date(depDate);

				bok.setRoom_Type(cmbroomtype.getSelectedItem().toString());
				bok.setRoom_Price(Double.parseDouble(txtprice.getText().toString()));

				BookingJDBC jdbc = new BookingJDBC();
				boolean result = jdbc.update(bok);
				if (result == true) {
					JOptionPane.showMessageDialog(null, "Update booking successfully !!");
					displayTable();
				} else {
					JOptionPane.showMessageDialog(null, "Failed to Update booking !!");
				}

			}
//			
//			String arrDate = ((JTextField) arrivaldate.getDateEditor().getUiComponent()).getText();
//
//			String depDate = ((JTextField) departuredate.getDateEditor().getUiComponent()).getText();
//			bok.setStart_Date(arrDate);
//			bok.setEnd_Date(depDate);
//
//			bok.setRoom_Type(cmbroomtype.getSelectedItem().toString());
//			bok.setRoom_Price(Double.parseDouble(txtprice.getText().toString()));
//
//			BookingJDBC jdbc = new BookingJDBC();
//			boolean result = jdbc.update(bok);
//			if (result == true) {
//				JOptionPane.showMessageDialog(null, "Update booking successfully !!");
//				displayTable();
//			} else {
//				JOptionPane.showMessageDialog(null, "Failed to Update booking !!");
//			}
		} else if (ae.getSource() == btndelete) {
			BookingJDBC jdbc = new BookingJDBC();
			boolean result = jdbc.delete(bok);
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Booking Cancelled");
				displayTable();

			} else {
				JOptionPane.showMessageDialog(null, " Failed to  Cancel Booking");

			}

		}

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbroomtype) {
			int result = cmbroomtype.getSelectedIndex();
			txtprice.setText(Double.toString(Global.ROOM_PRICE[result]));
		}
	}

	// Method display Table set
	public void displayTable() {
		obj = new Object[7];
		obj[0] = "Booking ID";
		obj[1] = "Arrival_Date";
		obj[2] = "Departure_Date";
		obj[3] = "RoomType";
		obj[4] = "Room Price";
		obj[5] = "BookingStatus";
		obj[6] = "RoomNumber";
		dtm.setColumnIdentifiers(obj);

		 refreshTable();
		// Calling refresh Table to show the database data into the table
	}

	// Method which retrieve data from database
	public void refreshTable() {
		ArrayList<Bookingclass> book = new BookingJDBC().getCustomerData(id);
		dtm.setRowCount(0);
		for (Bookingclass booking : book) {
			Object tmpRow[] = { booking.getBooking_Id(), booking.getStart_Date(), booking.getEnd_Date(),
					booking.getRoom_Type(), booking.getRoom_Price(), booking.getRoom_Status(), booking.getRoom_Id() };
			dtm.addRow(tmpRow);
		}
	}

	// Mouse Event While clicking in table
	@Override
	public void mouseClicked(MouseEvent ae) {
		if (ae.getSource() == table) {
			try {
				int row = table.getSelectedRow();
				System.out.println(row);
				String bId = (table.getModel().getValueAt(row, 0)).toString();

				bok.setRoom_Status(table.getModel().getValueAt(row, 5).toString());
				System.out.println(bok.getRoom_Status());

				String sql = "SELECT * FROM Booking WHERE Booking_ID='" + bId + "'";
				Database db = new Database();
				Connection conn = db.connect();
				PreparedStatement pstat = conn.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();

				while (rs.next()) {
					bok.setBooking_Id(rs.getInt("Booking_ID"));
					arrivaldate.setDate(rs.getDate("Start_Date"));
					departuredate.setDate(rs.getDate("End_Date"));

					String roomType = rs.getString("Prefered_Room");
					if (roomType.equals("Single")) {
						cmbroomtype.setSelectedIndex(0);
					} else if (roomType.equals("Double")) {
						cmbroomtype.setSelectedIndex(1);
					} else if (roomType.equals("Twin")) {

						cmbroomtype.setSelectedIndex(2);

					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage());
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
