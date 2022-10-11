package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import mylibs.CheckInJDBC;
import mylibs.CheckInlibs;

public class CheckInn extends JFrame implements ActionListener {
	private static Object add;
	JPanel pnltitle, pnlmain;
	JLabel lblfirstimg, lblscndimg, lbltitle, lblbackground, lblroomn, lblBookingID, lblcreditcard, lblcheckindate;
	JButton btnexit, btnview, btncheckin, btnclear;
	JTextField txtBookingID, txtcreditcard;
	JComboBox comboroomno;
	JScrollPane scrollPane;
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm);
	Object[] obj;

	ArrayList roomNumber;

	CheckInlibs checkLibrary = new CheckInlibs();

	public CheckInn() {

		setTitle("CUSTOMER CHECKIN");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 650);
		getContentPane().setLayout(null);

		pnltitle = new JPanel();
		pnltitle.setBounds(0, 0, 884, 83);
		pnltitle.setBackground(Color.WHITE);
		getContentPane().add(pnltitle);
		pnltitle.setLayout(null);

		lblfirstimg = new JLabel("");
		lblfirstimg.setIcon(new ImageIcon(getClass().getResource("/logofirst.jpg")));
		lblfirstimg.setBounds(0, 0, 289, 82);
		pnltitle.add(lblfirstimg);

		btnexit = new JButton("EXIT");
		btnexit.addActionListener(this);
		btnexit.setBackground(Color.GRAY);
		btnexit.setForeground(Color.GREEN);
		btnexit.setBounds(786, 22, 74, 36);
		pnltitle.add(btnexit);

		lblscndimg = new JLabel("");

		lblscndimg.setBounds(289, 0, 595, 82);
		pnltitle.add(lblscndimg);

		pnlmain = new JPanel();
		pnlmain.setBounds(0, 83, 884, 253);
		getContentPane().add(pnlmain);
		pnlmain.setLayout(null);

		lbltitle = new JLabel("CUSTOMER CHECKIN");
		lbltitle.setForeground(Color.GREEN);
		lbltitle.setBounds(10, 0, 269, 25);
		lbltitle.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		pnlmain.add(lbltitle);

		lblroomn = new JLabel("Room Number:");
		lblroomn.setBounds(30, 126, 96, 14);
		pnlmain.add(lblroomn);

		lblBookingID = new JLabel("BookingID:");
		lblBookingID.setBounds(30, 81, 78, 14);
		pnlmain.add(lblBookingID);


		// Text Box set for room number display
		txtBookingID = new JTextField();
		txtBookingID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtBookingID.setBounds(163, 164, 86, 20);
		txtBookingID.setEditable(false);
		add(txtBookingID);
		txtBookingID.setColumns(10);

		comboroomno = new JComboBox();
		comboroomno.setBounds(163, 119, 86, 22);
		pnlmain.add(comboroomno);

		btnview = new JButton("View CheckIn");
		btnview.addActionListener(this);
		btnview.setForeground(Color.CYAN);
		btnview.setBackground(Color.GRAY);
		btnview.setBounds(573, 104, 191, 36);
		pnlmain.add(btnview);

		btncheckin = new JButton("CheckIn");
		btncheckin.addActionListener(this);
		btncheckin.setBackground(Color.GRAY);
		btncheckin.setForeground(Color.CYAN);
		btncheckin.setBounds(665, 144, 96, 52);
		pnlmain.add(btncheckin);

		btnclear = new JButton("Clear");
		btnclear.setBackground(Color.GRAY);
		btnclear.setForeground(Color.CYAN);
		btnclear.setBounds(573, 144, 89, 52);
		pnlmain.add(btnclear);

		lblbackground = new JLabel();
		lblbackground.setIcon(new ImageIcon(getClass().getResource("ConfirmBooking.jpg")));
		lblbackground.setBounds(0, 0, 884, 254);
		pnlmain.add(lblbackground);

		// ScrollPane set to scroll the table set
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 345, 875, 390);
		add(scrollPane);
		// Call display Table method to display the table row and column data
		displayTable();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboroomno.removeAllItems();
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				comboroomno.addItem(model.getValueAt(i, 6).toString());
				txtBookingID.setText(model.getValueAt(i, 0).toString());
				checkLibrary.setBooking_id(Integer.parseInt(model.getValueAt(i, 6).toString()));
				checkLibrary.setRoom_Id(Integer.parseInt(comboroomno.getSelectedItem().toString()));
			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new CheckInn();

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

		// Calling refresh Table to show the database data into the table
		refreshTable();
	}

	// Method which retrieve data from database
	public void refreshTable() {
		ArrayList<CheckInlibs> checkIn = new ArrayList<CheckInlibs>();
		dtm.setRowCount(0);
		CheckInJDBC jdbc = new CheckInJDBC();
		checkIn = jdbc.getCheckIn();
		for (CheckInlibs check : checkIn) {
			Object tmpRow[] = { check.getBooking_id(), check.getArrival_Date(), check.getDeparture_Date(),
					check.getRoom_Type(), check.getRoom_Price(), check.getBooking_Status(), check.getRoom_Id() };
			dtm.addRow(tmpRow);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btncheckin) {
			checkLibrary.setBooking_id(Integer.parseInt(txtBookingID.getText()));
			checkLibrary.setRoom_Id(Integer.parseInt(comboroomno.getSelectedItem().toString()));
			CheckInJDBC jdbc = new CheckInJDBC();
			boolean result = jdbc.updateCheckIn(checkLibrary);
			if (result = true) {
				JOptionPane.showMessageDialog(null, "Succesfully Updated");
				refreshTable();
			} else {
				JOptionPane.showMessageDialog(null, " Failed to  Update");
			}
		} else if (e.getSource() == btnview) {
			new displayCheckIn();
		} else if (e.getSource() == btnexit) {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?", "EXIT", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				dispose();
			}
		}
	}

}