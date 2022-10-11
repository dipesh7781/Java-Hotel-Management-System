package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import mylibs.StaffClass;
import mylibs.StaffJDBC;

public class staffBooking extends JFrame implements ActionListener {
	JPanel pnltitle, pnlmain, pnlBody;
	JLabel lblfirstimg, lblscndimg, lblconfirm, lblbid, lblcheckind, lblroomtype, lblcreditcard, lblbookingdate,
			lblcheckoutdate, lblroomno, lblback;
	JButton btnclose, btnview, btncancel, btnbook;
	JTextField txtbid, txtcheckindate, txtroomtype, txtcreditcard, txtbookingdate, txtcheckoutdate;
	JComboBox comboroomno;

	DefaultTableModel dtm = new DefaultTableModel();
	Object obj[];

	ArrayList<StaffClass> book = new ArrayList<StaffClass>();
	ArrayList roomNumber = new ArrayList();
	StaffClass lib = new StaffClass();

	JTable table;
	JScrollPane scrollPane;

	public staffBooking() {

		// setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 650);
		setLayout(null);

		// Title panel
		pnltitle = new JPanel();
		pnltitle.setBounds(0, 0, 884, 350);
		getContentPane().add(pnltitle);
		pnltitle.setLayout(null);

		lblfirstimg = new JLabel("");
		lblfirstimg.setIcon(new ImageIcon(getClass().getResource("logofirst.jpg")));
		lblfirstimg.setBounds(0, 0, 289, 85);
		pnltitle.add(lblfirstimg);

		btnclose = new JButton("CLOSE");
		btnclose.setForeground(Color.CYAN);
		btnclose.setBackground(Color.GRAY);
		btnclose.setBounds(790, 11, 84, 46);
		btnclose.addActionListener(this);
		pnltitle.add(btnclose);

		lblscndimg = new JLabel("");
		lblscndimg.setIcon(new ImageIcon(getClass().getResource("whitebackground.jpg ")));
		lblscndimg.setBounds(288, 0, 596, 85);
		pnltitle.add(lblscndimg);

		// booking button
		btnbook = new JButton("BOOK");
		btnbook.addActionListener(this);
		btnbook.setForeground(Color.CYAN);
		btnbook.setBackground(Color.GRAY);
		btnbook.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnbook.setBounds(785, 245, 89, 46);
		pnltitle.add(btnbook);



		// view booking button
		btnview = new JButton("VIEW BOOKING");
		btnview.addActionListener(this);
		btnview.setForeground(Color.CYAN);
		btnview.setBackground(Color.GRAY);
		btnview.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnview.setBounds(691, 207, 183, 31);

		pnltitle.add(btnview);

		// BOOKING CONFIRMATION PAGE TEXT TITLE
		lblconfirm = new JLabel("BOOKING CONFIRMATION PAGE");
		lblconfirm.setForeground(Color.GREEN);
		lblconfirm.setBounds(20, 84, 336, 24);
		lblconfirm.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		pnltitle.add(lblconfirm);

		// booking id text
		lblbid = new JLabel("Booking ID:");
		lblbid.setBounds(21, 160, 84, 14);
		pnltitle.add(lblbid);

		// Check in date text title
		lblcheckind = new JLabel("CheckIn Date:");
		lblcheckind.setBounds(21, 198, 84, 14);
		pnltitle.add(lblcheckind);

		// Room Type Text title
		lblroomtype = new JLabel("Room Type:");
		lblroomtype.setBounds(21, 237, 84, 14);
		pnltitle.add(lblroomtype);

		// credit card text title
		lblcreditcard = new JLabel("Credit Card:");
		lblcreditcard.setBounds(21, 277, 84, 14);
		pnltitle.add(lblcreditcard);

//		// Booking date text title
//		lblbookingdate = new JLabel("Booking Date:");
//		lblbookingdate.setBounds(357, 160, 84, 14);
//		pnltitle.add(lblbookingdate);

		// check out date text title
		lblcheckoutdate = new JLabel("Check Out Date:");
		lblcheckoutdate.setBounds(357, 198, 97, 14);
		pnltitle.add(lblcheckoutdate);

		// room number text title
		lblroomno = new JLabel("Room Number:");
		lblroomno.setBounds(357, 237, 97, 14);
		pnltitle.add(lblroomno);

		// text field for booking id
		txtbid = new JTextField();
		txtbid.setBounds(124, 157, 151, 20);
		pnltitle.add(txtbid);
		txtbid.setColumns(10);

		// textfield checkin date
		txtcheckindate = new JTextField();
		txtcheckindate.setColumns(10);
		txtcheckindate.setBounds(124, 195, 151, 20);
		pnltitle.add(txtcheckindate);

		// txt field for room type
		txtroomtype = new JTextField();
		txtroomtype.setColumns(10);
		txtroomtype.setBounds(124, 234, 151, 20);
		pnltitle.add(txtroomtype);

		// txt field for credit card
		txtcreditcard = new JTextField();
		txtcreditcard.setColumns(10);
		txtcreditcard.setBounds(124, 274, 151, 20);
		pnltitle.add(txtcreditcard);

//		// text field for booking date
//	txtbookingdate = new JTextField();
//	txtbookingdate.setColumns(10);
//	txtbookingdate.setBounds(484, 157, 151, 20);
//	pnltitle.add(txtbookingdate);

		// text feild for checkoutdate
		txtcheckoutdate = new JTextField();
		txtcheckoutdate.setColumns(10);
		txtcheckoutdate.setBounds(484, 195, 151, 20);
		pnltitle.add(txtcheckoutdate);

		// combo box for room number
		comboroomno = new JComboBox();
		comboroomno.setBounds(494, 233, 141, 22);
		pnltitle.add(comboroomno);

		lblback = new JLabel("");
		lblback.setIcon(new ImageIcon(getClass().getResource("ConfirmBooking.jpg")));
		lblback.setBackground(Color.WHITE);
		lblback.setBounds(0, 84, 884, 238);
		pnltitle.add(lblback);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 350, 880, 260);
		add(scrollPane);

		table = new JTable(dtm);
		Table();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				txtbid.setText(model.getValueAt(i, 0).toString());
				txtcheckindate.setText(model.getValueAt(i, 4).toString());
				txtroomtype.setText(model.getValueAt(i, 6).toString());
				txtcreditcard.setText(model.getValueAt(i, 3).toString());
				txtcheckoutdate.setText(model.getValueAt(i, 5).toString());
				lib.setRoomtype(model.getValueAt(i, 6).toString());
				displayRoom();
			}
		});

		setVisible(true);

	}

	public void Table() {

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
		book = new StaffJDBC().getPending();
		dtm.setRowCount(0);
		for (StaffClass bok : book) {
			Object tmpRow[] = { bok.getBookingID(), bok.getName(), bok.getEmail(), bok.getCardDetails(),
					bok.getStartDate(), bok.getEndDate(), bok.getRoomtype(), bok.getBookingstatus(), bok.getRoom_ID() };
			dtm.addRow(tmpRow);
		}
	}

	public void displayRoom() {
		comboroomno.removeAllItems();
		ArrayList Ar = new ArrayList();
		StaffJDBC mystaff = new StaffJDBC();
		Ar = mystaff.getroom(lib);
		for (int i = 0; i < Ar.size(); i++) {
			comboroomno.addItem(Ar.get(i));
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnbook) {
			lib.setBookingID(Integer.parseInt(txtbid.getText()));
			lib.setRoom_ID(Integer.parseInt(comboroomno.getSelectedItem().toString()));
			StaffJDBC jdbc = new StaffJDBC();
			boolean result = jdbc.updateBooking(lib);
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Successfully Booked the room.");
				showData();
			} else {
				JOptionPane.showMessageDialog(null, "Failed to book the room.");
			}
		} else if (e.getSource() == btnview) {
			new displayBooking();
		} else if (e.getSource()==btnclose) {
			dispose();
		}
	
	}
	
}
