package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mylibs.LoginJDBC;
import mylibs.Loginclass;  

public class Login extends JFrame implements ActionListener {
	JLabel lbl1, lblEmail, lblPass, lblacc, lblimg;
	JTextField txtEmail, txtName;
	JPasswordField pass;
	JComboBox cmbrole;
	JButton btnLogin, btncreate;

	public Login() {
		setTitle("Loginwindow");
		setSize(350, 450);
		setResizable(false);
		getContentPane().setBackground(new Color(192, 192, 192));
		setLocationRelativeTo(null);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(44, 178, 76, 38);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblEmail);

		lblPass = new JLabel("Password:");
		lblPass.setBounds(44, 242, 76, 38);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblPass);

		lblacc = new JLabel("Don't have an acccount?");
		lblacc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblacc.setBounds(20, 361, 153, 25);
		add(lblacc);

		txtEmail = new JTextField();
		txtEmail.setBounds(120, 184, 124, 28);
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(txtEmail);
		txtEmail.setColumns(10);

		pass = new JPasswordField();
		pass.setBounds(120, 248, 126, 28);
		pass.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(pass);

		btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(111, 308, 95, 28);
		btnLogin.addActionListener(this);
		add(btnLogin);

		btncreate = new JButton("Create new");
		btncreate.setForeground(Color.WHITE);
		btncreate.setBackground(Color.BLACK);
		btncreate.setBounds(183, 360, 110, 28);
		btncreate.addActionListener(this);
		add(btncreate);

		lblimg = new JLabel();
		lblimg.setIcon(new ImageIcon("C:\\Users\\dipesh\\Desktop\\loginimage.png"));
		lblimg.setBounds(88, 10, 153, 150);
		add(lblimg);

		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnLogin) {
			Loginclass login = new Loginclass();
			login.setEmail(txtEmail.getText());
			login.setPassword(pass.getText());
			LoginJDBC jdbc = new LoginJDBC();

			boolean result = jdbc.select(login);
			if (result == true) {
				System.out.println(login.getId());
				if (login.getId() > 0) {
					if (login.getUserType().equals("Bar and RestroStaff")) {
						new Staff(login.getId(), login.getEmail(), login.getName());
						dispose();
					} else if (login.getUserType().equals("Customer")) {
						new Corporate(login.getId(), login.getEmail(), login.getName());
						dispose();
					} else if (login.getUserType().equals("Receptionist")) {
						new Staff(login.getId(), login.getEmail(), login.getName());
						dispose();
					} else if (login.getUserType().equals("corporatecustomer")) {
						new Corporate(login.getId(), login.getEmail(), login.getName());
						dispose();
					}
				}  
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect Email or Password");
			} 

		} else if (ae.getSource() == btncreate) {
			Register reg = new Register();
			this.setVisible(false);
		}
	
	}

	
}
