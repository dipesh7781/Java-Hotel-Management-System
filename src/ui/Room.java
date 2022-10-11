package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
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

import mylibs.RoomJDBC;
import mylibs.Roomclass;



public class Room extends JFrame implements ActionListener {
	JFrame frame;
	JLabel lblRoom, lblRoom_no, lblRoomStatus, lblRoom_Type, lblRoomCost,lblbackground1,lblbackground2;
	JLabel HotelRoom;
	JComboBox txtRoomStatus;
	JTextField txtRoomCost;
	JTextField txtRoom_no;
	JComboBox txtRoom_Type;
	JButton btnBook;
	JPanel Room;
	JPanel center;
	JPanel panel;
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table;
	JScrollPane scrollpane;
	JButton btnupdate;
	JButton btnsearch;

	public Room() {

		setSize(1200, 600);
		setTitle("Room");
        setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());

		setResizable(false);

		JPanel north = new JPanel();
		north.setBackground(new Color(106, 101, 101));
		north.setPreferredSize(new Dimension(10, 80));
		north.setLayout(null);
		add(north, BorderLayout.NORTH);

//LabelRoom

		lblRoom = new JLabel("ROOM");
		lblRoom.setFont(new Font("Serif", Font.BOLD, 35));
		lblRoom.setForeground(Color.CYAN);
		lblRoom.setBounds(550, 0, 250, 100);
		north.add(lblRoom);

		JPanel west = new JPanel();
		west.setBackground(new Color(106, 101, 101));
		west.setPreferredSize(new Dimension(350, 80));
		west.setLayout(null);
		add(west, BorderLayout.WEST);

		lblRoomStatus = new JLabel("RoomStatus");
		lblRoomStatus.setForeground(Color.CYAN);
		lblRoomStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRoomStatus.setBounds(10, 50, 100, 30);
		west.add(lblRoomStatus);
		
		txtRoomStatus = new JComboBox();
		txtRoomStatus.setModel(new DefaultComboBoxModel(new String[] { "Available", "Booked" }));
		txtRoomStatus.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtRoomStatus.setBounds(180, 50, 150, 30);
		west.add(txtRoomStatus);


		lblRoom_Type = new JLabel("Room_Type");
		lblRoom_Type.setForeground(Color.CYAN);
		lblRoom_Type.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRoom_Type.setBounds(10, 100, 150, 30);
		west.add(lblRoom_Type);
		
		txtRoom_Type = new JComboBox();
		txtRoom_Type.setModel(new DefaultComboBoxModel(new String[] { "Single", "Double",  "Twin" }));
		txtRoom_Type.setFont(new Font("Arial", Font.PLAIN, 14));
		txtRoom_Type.setBounds(180, 100, 150, 30);
		west.add(txtRoom_Type);


		lblRoomCost = new JLabel("RoomPrice");
		lblRoomCost.setForeground(Color.CYAN);
		lblRoomCost.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRoomCost.setBounds(10, 150, 200, 30);
		west.add(lblRoomCost);
		
		txtRoomCost = new JTextField();
		txtRoomCost.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtRoomCost.setBounds(180, 150, 150, 30);
		west.add(txtRoomCost);

		lblRoom_no = new JLabel("Room_No");
		lblRoom_no.setForeground(Color.CYAN);
		lblRoom_no.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRoom_no.setBounds(10, 200, 200, 30);
		west.add(lblRoom_no);
		
		txtRoom_no = new JTextField();
		txtRoom_no.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtRoom_no.setBounds(180, 200, 150, 30);
		west.add(txtRoom_no);

		// table

		center = new JPanel();
		center.setLayout(null);
		add(center);



		// Button
		btnBook = new JButton("Add");
		btnBook.setForeground(Color.CYAN);
		btnBook.setBackground(Color.DARK_GRAY);
		btnBook.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnBook.setBounds(200, 250, 90, 30);
		west.add(btnBook);
		btnBook.addActionListener(this);
		
		lblbackground1 = new JLabel();
		lblbackground1.setIcon(new ImageIcon(getClass().getResource("room background1.jpg")));
		lblbackground1.setBounds(0, 0, 1200, 340);
		north.add(lblbackground1);
	
		lblbackground2 = new JLabel();
		lblbackground2.setIcon(new ImageIcon(getClass().getResource("back ground image for room 2.jpg")));
		lblbackground2.setBounds(0, 0, 884, 500);
		west.add(lblbackground2);

		display();

		setVisible(true);

	}

	private void display() {

		table = new JTable(dtm);

		table.setPreferredScrollableViewportSize(new Dimension(820, 500));
		table.setFillsViewportHeight(true);

		dtm.addColumn("Id");
		dtm.addColumn("Type");
		dtm.addColumn("Price");
		dtm.addColumn("Status");

		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(10, 0, 820, 400);
		center.add(scrollpane);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment", "root", "");

			PreparedStatement pstat = conn.prepareStatement("select * from room");

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				int id;
				String Room_type;
				String price;
				String Room_status;

				id = rs.getInt("room_Id");
				Room_type = rs.getString("room_Type");
				price = rs.getString("room_Type");
				Room_status = rs.getString("room_Status");

				dtm.addRow(new Object[] { id, Room_type, price, Room_status });

			}

		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}

	}

	public static void main(String[] args) {
		new Room();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBook) {

			Roomclass room = new Roomclass();

			room.setRoom_no(Integer.parseInt(txtRoom_no.getText()));
			String combo = txtRoom_Type.getSelectedItem().toString();
			room.setRoom_Type(combo);
			double room1 = Double.parseDouble(txtRoomCost.getText());
			room.setRoom_Price((int) room1);
			String combo2 = txtRoomStatus.getSelectedItem().toString();
			room.setRoom_Status(combo2);

			RoomJDBC jdbc = new RoomJDBC();
			boolean result = jdbc.insert(room);
			if (result == true) {
				//display();
			
				JOptionPane.showMessageDialog(null, " Room Added sucessfully");

			} else {
				JOptionPane.showMessageDialog(null, "The room is not Added");

			}
		}

	}
}