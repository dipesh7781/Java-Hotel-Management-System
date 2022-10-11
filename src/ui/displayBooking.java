package ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mylibs.StaffClass;
import mylibs.StaffJDBC;

public class displayBooking extends JFrame {

	JPanel contentPane;
	
	DefaultTableModel dtm = new DefaultTableModel();
	Object obj[];

	ArrayList<StaffClass> book = new ArrayList<StaffClass>();
	ArrayList roomNumber = new ArrayList();
	StaffClass lib = new StaffClass();

	JTable table = new JTable(dtm);
	JScrollPane scrollPane;
	
	/**
	 * Create the frame.
	 */
	public displayBooking() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setTitle("BookingDisplay");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1166, 643);
		contentPane.add(scrollPane);
		showTable();
		scrollPane.setViewportView(table);

		setVisible(true);
	}
	
	public void showTable() {
		obj = new Object[9];
		obj[0] = "Booking ID";
		obj[1] = "Name";
		obj[2] = "Email";
		obj[3] = "Credit Details";
		obj[4] = "StartDate";
		obj[5] = "End Date";
		obj[6] = "Room Type";
		obj[7] = "Booking Status";
		obj[8] = "Room Number";
		dtm.setColumnIdentifiers(obj);
		showData();
	}

	// Method to retrieve data from database
	public void showData() {
		book = new StaffJDBC().getBooked();
		dtm.setRowCount(0);
		for (StaffClass bok : book) {
			Object tmpRow[] = { bok.getBookingID(), bok.getName(), bok.getEmail(), bok.getCardDetails(),
					bok.getStartDate(), bok.getEndDate(), bok.getRoomtype(), bok.getBookingstatus(), bok.getRoom_ID() };
			dtm.addRow(tmpRow);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new displayBooking();
	}
}
