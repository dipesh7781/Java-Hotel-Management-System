package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import mylibs.BarClass;
import mylibs.BarJDBC;
import mylibs.RestroClass;
import mylibs.RestroJDBC;

public class Bar extends JFrame implements ActionListener {
	JPanel pnltitle, pnlmain;
	JLabel lblfirstimg, lblscndimg, lblbackground2, lblbackground1, lblbookingid, lblfooditem, lblprice;
	JButton btnexit, btnadd;
	JTextField txtbookingid, txtprice;
	JComboBox combofooditem;
	DefaultTableModel dtm = new DefaultTableModel();
	Object obj[];
	JTable table;
	JScrollPane scrollPane;
	ArrayList<BarClass> br;

	public Bar() {

		setTitle("Bar PAGE");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 650);
		getContentPane().setLayout(null);

		// title panel
		pnltitle = new JPanel();
		pnltitle.setBounds(0, 0, 884, 87);
		getContentPane().add(pnltitle);
		pnltitle.setLayout(null);

		// image part 1 label
		lblfirstimg = new JLabel();
		lblfirstimg.setIcon(new ImageIcon(getClass().getResource("logofirst.jpg")));
		lblfirstimg.setBounds(0, 0, 291, 85);
		pnltitle.add(lblfirstimg);

		// Exit button
		btnexit = new JButton("EXIT");
		btnexit.addActionListener(this);
		btnexit.setForeground(Color.CYAN);
		btnexit.setBackground(Color.DARK_GRAY);
		btnexit.setBounds(798, 21, 76, 43);
		pnltitle.add(btnexit);

		// title image part2
		lblscndimg = new JLabel();
		lblscndimg.setIcon(new ImageIcon(getClass().getResource("ConfirmBooking.jpg")));
		lblscndimg.setBounds(288, 0, 596, 85);
		pnltitle.add(lblscndimg);

		// panel main
		pnlmain = new JPanel();
		pnlmain.setBounds(0, 86, 884, 309);
		getContentPane().add(pnlmain);
		pnlmain.setLayout(null);

		// booking id label
		lblbookingid = new JLabel("Booking ID:");
		lblbookingid.setBounds(294, 106, 78, 14);
		lblbookingid.setForeground(Color.BLACK);
		pnlmain.add(lblbookingid);

		// fooditem label
		lblfooditem = new JLabel("DrinkType:");
		lblfooditem.setForeground(Color.BLACK);
		lblfooditem.setBounds(294, 169, 78, 14);
		pnlmain.add(lblfooditem);

		// price label
		lblprice = new JLabel("Price:");
		lblprice.setBounds(294, 217, 46, 14);
		lblprice.setForeground(Color.BLACK);
		pnlmain.add(lblprice);

		// button add
		btnadd = new JButton("ADD");
		btnadd.setForeground(Color.CYAN);
		btnadd.setBackground(Color.GRAY);
		btnadd.setBounds(509, 198, 60, 52);
		btnadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BarClass re = new BarClass();

				int bookingid = Integer.parseInt(txtbookingid.getText());
				String item = combofooditem.getSelectedItem().toString();
				int price = Integer.parseInt(txtprice.getText());

				re.setBookingId(bookingid);
				re.setDrinkType(item);
				re.setPrice(price);

				BarJDBC jdbc = new BarJDBC();
				boolean result = jdbc.insert(re);
				if (result == true) {
					Table();
					JOptionPane.showMessageDialog(null, "Order Succesfully");

				} else {
					JOptionPane.showMessageDialog(null, "Order Not Completed");
				}

			}
		});

		pnlmain.add(btnadd);

		// text feild for bookinid
		txtbookingid = new JTextField();
		txtbookingid.setBounds(382, 103, 112, 20);
		pnlmain.add(txtbookingid);
		txtbookingid.setColumns(10);

		// combo box for Fooditem
		Object[] a1 = { "Cold Drink", "Soft Drink", "Hard Drink" };
		combofooditem = new JComboBox(a1);
		combofooditem.setBounds(382, 165, 112, 22);
		pnlmain.add(combofooditem);

		// text feild for Price
		txtprice = new JTextField();
		txtprice.setBounds(373, 214, 86, 20);
		pnlmain.add(txtprice);
		txtprice.setColumns(10);

		// j label for item background
		lblbackground2 = new JLabel("");
		lblbackground2.setIcon(new ImageIcon(getClass().getResource("background 1 image for restrop.jpg")));
		lblbackground2.setBounds(273, 79, 366, 182);
		pnlmain.add(lblbackground2);

		// j label for main background
		lblbackground1 = new JLabel();
		lblbackground1.setIcon(new ImageIcon(getClass().getResource("back 2 for restro.jpg")));
		lblbackground1.setBounds(0, 0, 884, 309);
		pnlmain.add(lblbackground1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 397, 875, 260);
		add(scrollPane);

		table = new JTable(dtm);
		Table();
		scrollPane.setViewportView(table);

		setVisible(true);
	}

	public void Table() {

		obj = new Object[3];
		obj[0] = "Booking ID";
		obj[1] = "DrinkType";
		obj[2] = "price";
		dtm.setColumnIdentifiers(obj);
		// showData();
		br = new BarJDBC().select_all();
		dtm.setRowCount(0);

		for (BarClass bb : br) {
			Object tmpbar[] = { bb.getBookingId(), bb.getDrinkType(), bb.getPrice() };
			dtm.addRow(tmpbar);
		}
		table = new JTable(dtm);

	}

	public static void main(String[] args) {
		new Bar();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnexit) {
			int i = JOptionPane.showConfirmDialog(null, "Are you sure ?", "EXIT", JOptionPane.YES_NO_OPTION);
			if (i == JOptionPane.YES_OPTION) {
				dispose();
			}
		}

	}

}