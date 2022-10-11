package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import mylibs.Global;
import mylibs.Registration;
import mylibs.RegistrationJDBC;

public class Register extends JFrame implements ActionListener {
	//declaration
	JPanel pnltitle;
	JLabel lblfirstimg, lblscndimg, lblName, lblEmail, lblPassword, lbldate, lblgender, lblcontact, lblcard, lblcompany,
			lblcustomer, lblregno, lblimg;
	JPasswordField pass1;
	JTextField txtName, txtEmail, txtgender, txtcontact, txtcard, txtcustomer, txtcompany, txtregno;
	JRadioButton radiomale, radiofemale;
	JButton btnregister, btnlogin, btnexit;
	JDateChooser date1;
	JComboBox cmbcustomer;
	ButtonGroup gender;
	String gen;

	public Register() {
		//frame
		setTitle("Registerwindow");
		setSize(900, 650);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setForeground(new Color(173, 255, 47));
		getContentPane().setBackground(new Color(0, 0, 0));
		
		//adding title panel
		pnltitle = new JPanel();
		pnltitle.setBounds(0, 0, 1370, 86);
		pnltitle.setBackground(Color.WHITE);
		getContentPane().add(pnltitle);
		pnltitle.setLayout(null);
		
		//exit button
		btnexit = new JButton("EXIT");
		btnexit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnexit.setBackground(Color.GRAY);
		btnexit.setForeground(Color.CYAN);
		btnexit.setBounds(767, 11, 89, 50);
		pnltitle.add(btnexit);
		
		//logo part 1
		lblfirstimg = new JLabel();
		lblfirstimg.setIcon(new ImageIcon(getClass().getResource("logofirst.jpg")));
		lblfirstimg.setBounds(0, 0, 289, 85);
		pnltitle.add(lblfirstimg);

		//logo part 2
		lblscndimg = new JLabel("");
		lblscndimg.setIcon(new ImageIcon(getClass().getResource("ConfirmBooking.jpg")));
		lblscndimg.setBounds(531, 0, 839, 86);
		pnltitle.add(lblscndimg);

		//Name label
		lblName = new JLabel("Name");
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(17, 130, 83, 22);
		add(lblName);

		//name text field
		txtName = new JTextField();
		txtName.setBounds(177, 121, 154, 31);
		add(txtName);

		//Email label
		lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(17, 186, 83, 22);
		lblEmail.setForeground(Color.YELLOW);
		add(lblEmail);

		//email text feild
		txtEmail = new JTextField();
		txtEmail.setBounds(177, 177, 154, 31);
		add(txtEmail);
		txtEmail.setColumns(10);

		//password label
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(17, 245, 90, 31);
		lblPassword.setForeground(Color.YELLOW);
		add(lblPassword);

		//password feild
		pass1 = new JPasswordField();
		pass1.setBounds(177, 247, 155, 31);
		add(pass1);

		//customer type label
		lblcustomer = new JLabel("CustomerType");
		lblcustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcustomer.setBounds(17, 315, 120, 31);
		lblcustomer.setForeground(Color.YELLOW);
		add(lblcustomer);

		//combo box for customer type
		cmbcustomer = new JComboBox();
		// additems
		for (int i = 0; i < Global.ROLES.length; i++) {
			cmbcustomer.addItem(Global.ROLES[i]);
		}
		cmbcustomer.setBounds(182, 315, 150, 31);
		add(cmbcustomer);

		//label Date of birth
		lbldate = new JLabel("Date of Birth");
		lbldate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbldate.setBounds(515, 119, 120, 31);
		lbldate.setForeground(Color.YELLOW);
		add(lbldate);

		//date chooser for date feild
		date1 = new JDateChooser();
		date1.setBounds(692, 125, 140, 31);
		add(date1);

		//gender label
		lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblgender.setForeground(Color.YELLOW);
		lblgender.setBounds(515, 175, 66, 31);
		add(lblgender);

		//radio option for gender
		radiomale = new JRadioButton("Male");
		radiomale.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radiomale.setSelected(true);
		radiomale.setBounds(630, 176, 90, 30);
		add(radiomale);

		//radio button for gender
		radiofemale = new JRadioButton("Female");
		radiofemale.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radiofemale.setSelected(false);
		radiofemale.setBounds(762, 175, 90, 30);
		add(radiofemale);

		//button group for gender
		gender = new ButtonGroup();
		gender.add(radiomale);
		gender.add(radiofemale);

		//contact number label
		lblcontact = new JLabel("Contact Number");
		lblcontact.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcontact.setBounds(515, 245, 124, 22);
		lblcontact.setForeground(Color.YELLOW);
		add(lblcontact);

		//text feild for contact number
		txtcontact = new JTextField();
		txtcontact.setBounds(692, 243, 135, 31);
		add(txtcontact);
		txtcontact.setColumns(10);

		//credit card card number
		lblcard = new JLabel("Credit Card No");
		lblcard.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcard.setBounds(515, 319, 113, 22);
		lblcard.setForeground(Color.YELLOW);
		add(lblcard);

		//text feild for credit card number
		txtcard = new JTextField();
		txtcard.setBounds(692, 310, 141, 31);
		add(txtcard);
		txtcard.setColumns(10);

		//company name label
		lblcompany = new JLabel("Company Name");
		lblcompany.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcompany.setBounds(515, 384, 124, 22);
		lblcompany.setForeground(Color.YELLOW);
		add(lblcompany);

		//company name text feild
		txtcompany = new JTextField();
		txtcompany.setBounds(692, 375, 141, 31);
		add(txtcompany);
		txtcompany.setColumns(10);

		//registration number label
		lblregno = new JLabel("Registration Number");
		lblregno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblregno.setBounds(17, 391, 154, 22);
		lblregno.setForeground(Color.YELLOW);
		add(lblregno);

		//text feild for registration number
		txtregno = new JTextField();
		txtregno.setBounds(202, 382, 137, 31);
		add(txtregno);
		txtregno.setColumns(10);

		//register button
		btnregister = new JButton("Register");
		btnregister.setForeground(Color.CYAN);
		btnregister.setBackground(Color.GRAY);
		btnregister.setBounds(98, 536, 111, 48);
		btnregister.addActionListener(this);
		btnregister.setFocusable(false);
		add(btnregister);

		//login button
		btnlogin = new JButton("Login");
		btnlogin.setForeground(Color.CYAN);
		btnlogin.setBackground(Color.GRAY);
		btnlogin.setBounds(236, 536, 111, 48);
		btnlogin.addActionListener(this);
		btnlogin.setFocusable(false);
		add(btnlogin);

		//background image
		lblimg = new JLabel("New label");
		lblimg.setIcon(new ImageIcon(getClass().getResource("Registerimg.jpg")));
		lblimg.setBounds(0, 62, 886, 541);
		add(lblimg);

		getContentPane().setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnlogin) {
			Login Log = new Login();
			setVisible(false);

		}

		if (ae.getSource() == btnregister) {

			Registration reg = new Registration();
			reg.setName(txtName.getText());
			reg.setEmail(txtEmail.getText());
			reg.setPassword(pass1.getText());
			java.util.Date sqldate = date1.getDate();
			reg.setDate_Of_Birth(sqldate.toString());
			if (radiomale.isSelected()) {
				gen = "male";

			} else {
				gen = "female";
			}
			reg.setGender(gen);
			if (txtcontact.getText() != null) // checking for user entered value is null or not
			{
				reg.setContact_No(Long.parseLong(txtcontact.getText()));
			} else {
				reg.setContact_No(0);
			}
			reg.setCredit_Card_Information(txtcard.getText());
			reg.setCustomer_Type(cmbcustomer.getSelectedItem().toString());
			reg.setCompany_Name(txtcompany.getText());
			reg.setCompany_Registration_No(txtregno.getText());
			RegistrationJDBC jdbc = new RegistrationJDBC();
			boolean result = jdbc.insert(reg);
			if (result == true) {
				// to display message in dialog box
				JOptionPane.showMessageDialog(null, "Registered Succesfully");
			} else {

				JOptionPane.showMessageDialog(null, "Error");
			}
			result = false;
		}
	}

	public static void main(String[] args) {
		new Register();

	}

}