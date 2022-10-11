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

import mylibs.ServiceClass;
import mylibs.ServiceJDBC;

public class Servicess extends JFrame {
	JPanel pnltitle, pnlmain;
	JLabel lblfirstimg, lblscndimg, lblbookingid, lblservicetype, lblprice, lblbackground1;
	JTextField txtbookingid, txtprice;
	JComboBox comboservicetype;
	JButton btnadd;

	DefaultTableModel dtm = new DefaultTableModel();
	Object obj[];
	JTable table;
	JScrollPane scrollPane;
	ArrayList<ServiceClass> serv ;

	public Servicess() {
		setTitle("SERVICES");
		setSize(750, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		pnltitle = new JPanel();
		pnltitle.setBounds(0, 0, 884, 86);
		getContentPane().add(pnltitle);
		pnltitle.setLayout(null);

		lblfirstimg = new JLabel();
		lblfirstimg.setIcon(new ImageIcon(getClass().getResource("logofirst.jpg")));
		lblfirstimg.setBounds(0, 0, 289, 85);
		pnltitle.add(lblfirstimg);

		lblscndimg = new JLabel();
		lblscndimg.setIcon(new ImageIcon(getClass().getResource("ConfirmBooking.jpg")));
		lblscndimg.setBounds(286, 0, 598, 85);
		pnltitle.add(lblscndimg);

		// main panel 1
		pnlmain = new JPanel();
		pnlmain.setBounds(0, 85, 884, 152);
		getContentPane().add(pnlmain);
		pnlmain.setLayout(null);

		// booking Id label
		lblbookingid = new JLabel("Booking ID:");
		lblbookingid.setBounds(66, 30, 76, 14);
		pnlmain.add(lblbookingid);

		// text feild for booking id
		txtbookingid = new JTextField();
		txtbookingid.setBounds(150, 26, 110, 22);
		pnlmain.add(txtbookingid);

		// service type
		lblservicetype = new JLabel("Service Type:");
		lblservicetype.setBounds(430, 30, 86, 14);
		pnlmain.add(lblservicetype);

		// jcombo box for service type
		Object[]a1= {"Swimming","Laundry","Games","Gym","Massage"};
		comboservicetype = new JComboBox(a1);
		comboservicetype.setBounds(530, 29, 112, 22);
		pnlmain.add(comboservicetype);

		// service price
		lblprice = new JLabel("Service Price:");
		lblprice.setBounds(66, 110, 86, 14);
		pnlmain.add(lblprice);

		txtprice = new JTextField();
		txtprice.setBounds(165, 110, 120, 22);
		pnlmain.add(txtprice);

		// add button on panel
		btnadd = new JButton("ADD");
		btnadd.setBackground(Color.GRAY);
		btnadd.setForeground(Color.CYAN);
		btnadd.setBounds(530, 100, 86, 34);
		pnlmain.add(btnadd);
		btnadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServiceClass hi= new ServiceClass();
				String item =comboservicetype.getSelectedItem().toString();
				int price= Integer.parseInt(txtprice.getText());
				int bookingid= Integer.parseInt(txtbookingid.getText());
				
				hi.setBookinId(bookingid);
				hi.setServiceType(item);
				hi.setServicePrice(price);
				
				ServiceJDBC jdbc = new ServiceJDBC();
				boolean result = jdbc.insert(hi);
				if(result==true) {
					Table();
					JOptionPane.showMessageDialog(null, "Service Added");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Service Not Added");
				}
				
			}
		});
		
		// label for background panel main 1
		lblbackground1 = new JLabel();
		lblbackground1.setIcon(new ImageIcon(getClass().getResource("Pink Image.jpg")));
		lblbackground1.setBounds(0, 0, 884, 153);
		pnlmain.add(lblbackground1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 240, 725, 260);
		add(scrollPane);

		table = new JTable(dtm);
		Table();
		scrollPane.setViewportView(table);
		
		setVisible(true);

	}

	public void Table() {

		obj = new Object[3];
		obj[0] = "Booking ID";
		obj[1] = "Service Type";
		obj[2] = "price";
		dtm.setColumnIdentifiers(obj);
		//showData();
		serv= new ServiceJDBC().select_all();
		dtm.setRowCount(0);
		
		for(ServiceClass se: serv) {
			Object tmpserv[]= { se.getBookinId(),
					se.getServiceType(),
					se.getServicePrice()
			};
			dtm.addRow(tmpserv);
		}
		table= new JTable(dtm);
		
	}
	

	public static void main(String[] args) {
		new Servicess();
	}

}
