package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import mylibs.CheckoutClass;
import mylibs.CheckoutClass2;
import mylibs.CheckoutJDBC;

public class Checkout extends JFrame implements ActionListener { // extends inheritance
	JPanel pnltitle, pnlmain, pnlX;
	JLabel lblfirstimg, lblscndimg, lblsearch, lblbackground1, lblbackground2, lblbackground3, lblbackgroundmain,
			lblname, lblarrivaldate, lbldeparturedate, lblnoofdays, lblroomrate, lbldrinkamount, lblserviceamount,
			lblfoodprice, lblroomprice, lblvat, lblservicecharge, lbldiscount, lbltotalamount, lbltotalpaid,
			lblreturnamount, lblbillingstatus;
	JButton btnexit, btnpay, btnclear;
	JTextField txtsearch, txtname, txtnoofdays, txtroomrate, txtdrinkamount, txtserviceamount, txtfoodprice,
			txtroomprice, txtvat, txtservicecharge, txtdiscount, txttotalamount, txttotalpaid, txtreturnamount, txtdisc;
	JComboBox combobillingstatus;
	DefaultTableModel dtm = new DefaultTableModel();
	Object obj[];
	JTable table = new JTable(dtm);
	JScrollPane scrollPane;
	JDateChooser c1, c2;

	public Checkout() {

		setTitle("CHECKOUT PAGE");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 650);
		getContentPane().setLayout(null);
		pnlX = new JPanel();
		pnlX.setBounds(0, 0, 900, 650);
		pnlX.setLayout(null);
		add(pnlX);
		pnltitle = new JPanel();
		pnltitle.setBounds(0, 0, 884, 86);
		getContentPane().add(pnltitle);
		pnltitle.setLayout(null);
		pnlX.add(pnltitle);

		// lbl logo part 1
		lblfirstimg = new JLabel("");
		lblfirstimg.setIcon(new ImageIcon(getClass().getResource("logofirst.jpg")));
		lblfirstimg.setBounds(0, 0, 289, 85);
		pnltitle.add(lblfirstimg);

		// exitbutton
		btnexit = new JButton("PRINT");
		btnexit.setBackground(Color.GRAY);
		btnexit.setForeground(Color.CYAN);
		btnexit.setBounds(784, 25, 100, 36);

		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				PrinterJob job = PrinterJob.getPrinterJob();
				job.setJobName("Print Data");

				job.setPrintable(new Printable() {
					public int print(Graphics pg, PageFormat pf, int pageNum) {
						pf.setOrientation(PageFormat.LANDSCAPE);
						if (pageNum > 0) {
							return Printable.NO_SUCH_PAGE;
						}

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						g2.scale(0.47, 0.47);

						pnlX.print(g2);

						return Printable.PAGE_EXISTS;

					}
				});
				boolean ok = job.printDialog();
				if (ok) {
					try {

						job.print();
					} catch (PrinterException ex) {
						ex.printStackTrace();
					}
				}

			}

		});

		pnltitle.add(btnexit);

		// search label
		lblsearch = new JLabel("Search");
		lblsearch.setBounds(347, 36, 46, 14);
		pnltitle.add(lblsearch);

		// search text field
		txtsearch = new JTextField();
		txtsearch.setBounds(412, 33, 86, 20);
		pnltitle.add(txtsearch);
		txtsearch.setColumns(10);

		// logo image second part
		lblscndimg = new JLabel("");
		lblscndimg.setIcon(new ImageIcon(getClass().getResource("ConfirmBooking.jpg")));
		lblscndimg.setBounds(288, 0, 596, 85);
		pnltitle.add(lblscndimg);

		// main panel
		pnlmain = new JPanel();
		pnlmain.setBounds(0, 86, 884, 340);
		getContentPane().add(pnlmain);
		pnlmain.setLayout(null);
		pnlX.add(pnlmain);

		// name label
		lblname = new JLabel("Name:");
		lblname.setForeground(Color.WHITE);
		lblname.setBounds(28, 35, 46, 14);
		pnlmain.add(lblname);

		// arrival date label
		lblarrivaldate = new JLabel("Arrival Date:");
		lblarrivaldate.setForeground(Color.WHITE);
		lblarrivaldate.setBounds(28, 72, 75, 14);
		pnlmain.add(lblarrivaldate);

		c1 = new JDateChooser();
		c1.setDateFormatString("yyyy-MM-dd");
		c1.setBounds(130, 70, 110, 20);
		c1.setFont(new Font("Verdana", Font.PLAIN, 15));
		pnlmain.add(c1);

		// departure date label
		lbldeparturedate = new JLabel("Departure Date:");
		lbldeparturedate.setForeground(Color.WHITE);
		lbldeparturedate.setBounds(28, 112, 98, 14);
		pnlmain.add(lbldeparturedate);

		c2 = new JDateChooser();
		c2.setDateFormatString("yyyy-MM-dd");
		c2.setBounds(130, 110, 110, 20);
		c2.setFont(new Font("Verdana", Font.PLAIN, 15));
		pnlmain.add(c2);

		// no of days label
		lblnoofdays = new JLabel("No of Days");
		lblnoofdays.setForeground(Color.WHITE);
		lblnoofdays.setBounds(28, 151, 98, 14);
		pnlmain.add(lblnoofdays);

		// room rate label;
		lblroomrate = new JLabel("Room Rate:");
		lblroomrate.setForeground(Color.WHITE);
		lblroomrate.setBounds(28, 191, 98, 14);
		pnlmain.add(lblroomrate);

		// drink amount label
		lbldrinkamount = new JLabel("Drink Amount:");
		lbldrinkamount.setForeground(Color.WHITE);
		lbldrinkamount.setBounds(28, 229, 98, 14);
		pnlmain.add(lbldrinkamount);

		// service amount label
		lblserviceamount = new JLabel("Service Amount:");
		lblserviceamount.setForeground(Color.WHITE);
		lblserviceamount.setBounds(28, 267, 98, 14);
		pnlmain.add(lblserviceamount);

		// textfield for name
		txtname = new JTextField();
		txtname.setBounds(141, 32, 86, 20);
		pnlmain.add(txtname);
		txtname.setEditable(false);
		txtname.setColumns(10);

		// text field for no of days
		txtnoofdays = new JTextField();
		txtnoofdays.setBounds(141, 148, 86, 20);
		pnlmain.add(txtnoofdays);
		txtnoofdays.setColumns(10);
		txtnoofdays.setEditable(false);

		// text field for room rate
		txtroomrate = new JTextField();
		txtroomrate.setBounds(141, 188, 86, 20);
		pnlmain.add(txtroomrate);
		txtroomrate.setColumns(10);
		txtroomrate.setEditable(false);

		// text field for drink amount
		txtdrinkamount = new JTextField();
		txtdrinkamount.setBounds(141, 226, 86, 20);
		pnlmain.add(txtdrinkamount);
		txtdrinkamount.setEditable(false);
		txtdrinkamount.setColumns(10);

		// text field for service amount
		txtserviceamount = new JTextField();
		txtserviceamount.setBounds(141, 264, 86, 20);
		pnlmain.add(txtserviceamount);
		txtserviceamount.setEditable(false);
		txtserviceamount.setColumns(10);

		// food price label
		lblfoodprice = new JLabel("Food Price:");
		lblfoodprice.setForeground(Color.WHITE);
		lblfoodprice.setBounds(328, 35, 98, 14);
		pnlmain.add(lblfoodprice);

		// room price label
		lblroomprice = new JLabel("Room Price:");
		lblroomprice.setForeground(Color.WHITE);
		lblroomprice.setBounds(328, 72, 98, 14);
		pnlmain.add(lblroomprice);

		// vat label
		lblvat = new JLabel("VAT:");
		lblvat.setForeground(Color.WHITE);
		lblvat.setBounds(328, 112, 46, 14);
		pnlmain.add(lblvat);

		// service charge label
		lblservicecharge = new JLabel("Service Charge:");
		lblservicecharge.setForeground(Color.WHITE);
		lblservicecharge.setBounds(328, 151, 98, 14);
		pnlmain.add(lblservicecharge);

		// discount label
		lbldiscount = new JLabel("Discount:");
		lbldiscount.setForeground(Color.WHITE);
		lbldiscount.setBounds(328, 191, 86, 14);
		pnlmain.add(lbldiscount);

		// text field for food price
		txtfoodprice = new JTextField();
		txtfoodprice.setBounds(448, 32, 86, 20);
		pnlmain.add(txtfoodprice);
		txtfoodprice.setEditable(false);
		txtfoodprice.setColumns(10);

		// text field for room price
		txtroomprice = new JTextField();
		txtroomprice.setBounds(448, 69, 86, 20);
		pnlmain.add(txtroomprice);
		txtroomprice.setColumns(10);
		txtroomprice.setEditable(false);

		// text field for vat
		txtvat = new JTextField();
		txtvat.setBounds(448, 109, 86, 20);
		pnlmain.add(txtvat);
		txtvat.setEditable(false);
		txtvat.setColumns(10);

		// text field for service charge
		txtservicecharge = new JTextField();
		txtservicecharge.setBounds(448, 148, 86, 20);
		pnlmain.add(txtservicecharge);
		txtservicecharge.setEditable(false);
		txtservicecharge.setColumns(10);

		// text field for discount
		txtdiscount = new JTextField();
		txtdiscount.setBounds(448, 188, 86, 20);
		pnlmain.add(txtdiscount);
		txtdiscount.setEditable(false);
		txtdiscount.setColumns(10);

		// textfield for 10% discount
		txtdisc = new JTextField();
		txtdisc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					calculation();
				}
			}
		});
		txtdisc.setBounds(400, 188, 33, 20);
		pnlmain.add(txtdisc);
		txtdisc.setColumns(10);

		// total amount label
		lbltotalamount = new JLabel("Total Amount:");
		lbltotalamount.setForeground(Color.WHITE);
		lbltotalamount.setBounds(641, 35, 86, 14);
		pnlmain.add(lbltotalamount);

		// total paid label
		lbltotalpaid = new JLabel("Total Paid:");
		lbltotalpaid.setForeground(Color.WHITE);
		lbltotalpaid.setBounds(641, 72, 86, 14);
		pnlmain.add(lbltotalpaid);

		// return amount label
		lblreturnamount = new JLabel("Return Amount:");
		lblreturnamount.setForeground(Color.WHITE);
		lblreturnamount.setBounds(641, 112, 114, 14);
		pnlmain.add(lblreturnamount);

		// billing status label
		lblbillingstatus = new JLabel("Billing Status:");
		lblbillingstatus.setForeground(Color.WHITE);
		lblbillingstatus.setBounds(641, 151, 86, 14);
		pnlmain.add(lblbillingstatus);

		// text feild for total amount
		txttotalamount = new JTextField();
		txttotalamount.setBounds(765, 32, 86, 20);
		pnlmain.add(txttotalamount);
		txttotalamount.setColumns(10);
		txttotalamount.setEditable(false);

		// text field for total paid
		txttotalpaid = new JTextField();
		txttotalpaid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					calculateTotalAmt();
				}
			}
		});
		txttotalpaid.setBounds(765, 69, 86, 20);
		pnlmain.add(txttotalpaid);
		txttotalpaid.setColumns(10);

		// text field for return amount
		txtreturnamount = new JTextField();
		txtreturnamount.setBounds(765, 109, 86, 20);
		pnlmain.add(txtreturnamount);
		txtreturnamount.setColumns(10);
		txtreturnamount.setEditable(false);

		// pay button
		btnpay = new JButton("Pay");
		btnpay.addActionListener(this);
		btnpay.setForeground(Color.CYAN);
		btnpay.setBackground(Color.GRAY);
		btnpay.setBounds(635, 271, 89, 46);
		pnlmain.add(btnpay);

		// clear button
		btnclear = new JButton("Clear");
		btnclear.setForeground(Color.CYAN);
		btnclear.setBackground(Color.GRAY);
		btnclear.setBounds(734, 271, 89, 46);
		pnlmain.add(btnclear);

		// combo box for billing status
		combobillingstatus = new JComboBox();
		Object obj[] = { "Paid", "Pending" };
		for (int i = 0; i < obj.length; i++) {
			combobillingstatus.addItem(obj[i]);
		}
		combobillingstatus.setBounds(737, 147, 86, 22);
		pnlmain.add(combobillingstatus);

		// background image 1
		lblbackground1 = new JLabel();
		lblbackground1.setIcon(new ImageIcon(getClass().getResource("room background1.jpg")));
		lblbackground1.setBounds(20, 21, 224, 280);
		pnlmain.add(lblbackground1);

		// background image 2
		lblbackground2 = new JLabel();
		lblbackground2.setIcon(new ImageIcon(getClass().getResource("back ground image for room 2.jpg")));
		lblbackground2.setBounds(316, 22, 235, 198);
		pnlmain.add(lblbackground2);

		// background image 3
		lblbackground3 = new JLabel();
		lblbackground3.setIcon(new ImageIcon(getClass().getResource("room background1.jpg")));
		lblbackground3.setBounds(635, 23, 224, 162);
		pnlmain.add(lblbackground3);

		// main background image
		lblbackgroundmain = new JLabel();
		lblbackgroundmain.setIcon(new ImageIcon(getClass().getResource("room background1.jpg")));
		lblbackgroundmain.setBounds(0, 0, 884, 340);
		pnlmain.add(lblbackgroundmain);

		// for table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 430, 890, 200);
		pnlX.add(scrollPane);
		showTable();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				txtname.setText(model.getValueAt(i, 1).toString());
				String dateIn = model.getValueAt(i, 2).toString();
				String dateOut = model.getValueAt(i, 3).toString();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

				// Convert string into date
				Date d1 = null;
				Date d2 = null;
				long difference = 0, differenceDates = 0;
				try {
					d1 = format.parse(dateIn);
					d2 = format.parse(dateOut);

					// Convert date into number of days
					difference = Math.abs(d1.getTime() - d2.getTime());
					differenceDates = difference / (24 * 60 * 60 * 1000);

				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Failed to convert string into date");
				}

				c1.setDate(d1);
				c2.setDate(d2);
				String noDate = Long.toString(differenceDates);
				txtnoofdays.setText(noDate);
				String roomRate = model.getValueAt(i, 5).toString();
				txtroomrate.setText(roomRate);
				int numDate = Integer.parseInt(noDate);
				int roomAmt = Integer.parseInt(roomRate);
				int total = numDate * roomAmt;
				txtroomprice.setText(Integer.toString(total));
				txtdrinkamount.setText(model.getValueAt(i, 7).toString());
				txtserviceamount.setText(model.getValueAt(i, 8).toString());
				txtfoodprice.setText(model.getValueAt(i, 6).toString());
			}
		});

		setVisible(true);
	}

	public void showTable() {
		obj = new Object[9];
		obj[0] = "Booking ID";
		obj[1] = "Name";
		obj[2] = "ArrivalDate";
		obj[3] = " DepartureDate";
		obj[4] = "RoomNo";
		obj[5] = "RoomPrice";
		obj[6] = "FoodPrice";
		obj[7] = "BarPrice";
		obj[8] = "ServicePrice";
		dtm.setColumnIdentifiers(obj);
		// showData();
		showData();
	}

	private void showData() {
		CheckoutJDBC cData = new CheckoutJDBC();
		ArrayList<CheckoutClass2> check = new ArrayList<CheckoutClass2>();
		check = cData.billing();
		dtm.setRowCount(0);
		for (CheckoutClass2 customerData : check) {
			Object tmpRow[] = { customerData.getBooking_Id(), customerData.getName(), customerData.getArrivalDate(),
					customerData.getDepartureDate(), customerData.getRoom_ID(), customerData.getRoom_Price(),
					customerData.getRestro_Price(), customerData.getBar_Price(), customerData.getService_price() };
			dtm.addRow(tmpRow);
		}
	}

	public static void main(String[] args) {
		new Checkout();
	}

	public void calculation() {
		int discountpercent = Integer.parseInt(txtdisc.getText());
		int drinkAmt = Integer.parseInt(txtdrinkamount.getText());
		int serviceAmt = Integer.parseInt(txtserviceamount.getText());
		int foodAmt = Integer.parseInt(txtfoodprice.getText());
		int roomAmt = Integer.parseInt(txtroomprice.getText());
		int sumb = drinkAmt + serviceAmt + foodAmt + roomAmt;
		int discountAmt = sumb * discountpercent / 100;
		txtdiscount.setText(Integer.toString(discountAmt));
		int totalafterdis = sumb - discountAmt;
		int serviceCharge = totalafterdis * 10 / 100;
		int amtAfterSC = totalafterdis + serviceCharge;
		txtservicecharge.setText(Integer.toString(serviceCharge));
		int vatAmt = amtAfterSC * 13 / 100;
		int amtaftervat = amtAfterSC + vatAmt;
		txtvat.setText(Integer.toString(vatAmt));
		txttotalamount.setText(Integer.toString(amtaftervat));
	}

	public void calculateTotalAmt() {
		int receivedAmt = Integer.parseInt(txttotalpaid.getText());
		int totalAmt = Integer.parseInt(txttotalamount.getText());
		int returnAmt = receivedAmt - totalAmt;
		txtreturnamount.setText(Integer.toString(returnAmt));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnpay) {
			CheckoutClass checkout = new CheckoutClass();
			checkout.setName(txtname.getText());
			checkout.setBar_Price(Integer.parseInt(txtdrinkamount.getText()));
			checkout.setService_price(Integer.parseInt(txtservicecharge.getText()));
			checkout.setRestro_Price(Integer.parseInt(txtfoodprice.getText()));
			checkout.setRoom_Price(Integer.parseInt(txtroomprice.getText()));
			checkout.setReturn_Amt(Double.parseDouble(txtreturnamount.getText()));
			checkout.setDiscount(Integer.parseInt(txtdiscount.getText()));
			checkout.setBilling_Status(combobillingstatus.getSelectedItem().toString());
			
			CheckoutJDBC jdbc = new CheckoutJDBC();
			boolean result = jdbc.insertBill(checkout);
			if(result==true) {
				JOptionPane.showMessageDialog(null, "Successfully pay the bill.");
			}else {
				JOptionPane.showMessageDialog(null, "Failed to pay the bill.");
			}
		}
	}

}