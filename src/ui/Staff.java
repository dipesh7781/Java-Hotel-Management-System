package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Staff extends JFrame implements ActionListener {
	JPanel pnltitle, pnlmain;
	JLabel lbllogo1, lbllogo2, lblbackg, lblmanage;
	JButton btnsign, btnbook, btnchecki, btnchecko, btnroom, btnext, btnrestro, btnbar, btnnonc, btnc;

	// global variable
	 		int id;
	 		String name, email;

	public Staff(int id, String email, String name) {
		// store value
		this.id = id;
		this.email = email;
		this.name = name;

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 650);
		getContentPane().setLayout(null);

		// Title panel
		pnltitle = new JPanel();
		pnltitle.setBounds(0, 0, 884, 85);
		getContentPane().add(pnltitle);
		pnltitle.setLayout(null);

		// sign out button of title panel
		btnsign = new JButton("SIGN OUT");
		btnsign.setBackground(Color.GRAY);
		btnsign.setForeground(Color.CYAN);
		btnsign.setBounds(767, 11, 95, 50);
		btnsign.addActionListener(this);
		pnltitle.add(btnsign);

		// logo image first part
		lbllogo1 = new JLabel();
		lbllogo1.setBounds(0, 0, 289, 85);
		lbllogo1.setForeground(Color.LIGHT_GRAY);
		lbllogo1.setBackground(Color.LIGHT_GRAY);
		lbllogo1.setIcon(new ImageIcon(getClass().getResource("logofirst.jpg")));
		pnltitle.add(lbllogo1);

		// logo image second part
		lbllogo2 = new JLabel("");
		lbllogo2.setIcon(new ImageIcon(getClass().getResource("whitebackground.jpg ")));
		lbllogo2.setBounds(288, 0, 596, 85);
		pnltitle.add(lbllogo2);

		// main panel
		pnlmain = new JPanel();
		pnlmain.setBounds(0, 85, 884, 526);
		getContentPane().add(pnlmain);
		pnlmain.setLayout(null);

		// booking button
		btnbook = new JButton("Booking");
		btnbook.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnbook.setForeground(Color.CYAN);
		btnbook.setBackground(Color.DARK_GRAY);
		btnbook.setBounds(288, 326, 105, 73);
		btnbook.addActionListener(this);
		pnlmain.add(btnbook);  

		// checkin button
		btnchecki = new JButton("Check in");
		btnchecki.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnchecki.setForeground(Color.CYAN);
		btnchecki.setBackground(Color.DARK_GRAY);
		btnchecki.setBounds(44, 292, 105, 105);
		btnchecki.addActionListener(this);
		pnlmain.add(btnchecki);

		// check out button
		btnchecko = new JButton("Check out");
		btnchecko.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnchecko.setForeground(Color.CYAN);
		btnchecko.setBackground(Color.DARK_GRAY);
		btnchecko.setBounds(288, 242, 105, 73);
		btnchecko.addActionListener(this);
		pnlmain.add(btnchecko);

		// bill button
		btnroom = new JButton("UpdateRoom");
		btnroom.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnroom.setForeground(Color.CYAN);
		btnroom.setBackground(Color.DARK_GRAY);
		btnroom.setBounds(44, 408, 196, 61);
		btnroom.addActionListener(this);
		pnlmain.add(btnroom);

		// extra charges button
		btnext = new JButton("Extra Services");
		btnext.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnext.setForeground(Color.YELLOW);
		btnext.setBackground(Color.DARK_GRAY);
		btnext.setBounds(159, 293, 119, 106);
		btnext.addActionListener(this);
		pnlmain.add(btnext);

		// resturent service button
		btnrestro = new JButton("Restaurant Service");
		btnrestro.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnrestro.setForeground(Color.YELLOW);
		btnrestro.setBackground(Color.DARK_GRAY);
		btnrestro.setBounds(44, 242, 234, 39);
		btnrestro.addActionListener(this);
		pnlmain.add(btnrestro);

		// bar button
		btnbar = new JButton("Bar Service");
		btnbar.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnbar.setBackground(Color.DARK_GRAY);
		btnbar.setForeground(Color.YELLOW);
		btnbar.setBounds(249, 410, 120, 61);
		btnbar.addActionListener(this);
		pnlmain.add(btnbar);

		// non-corperate customer button
		btnnonc = new JButton("Non Corporate Customer");
		btnnonc.setForeground(Color.CYAN);
		btnnonc.setBackground(Color.DARK_GRAY);
		btnnonc.setBounds(675, 75, 188, 44);
		btnnonc.addActionListener(this);
		pnlmain.add(btnnonc);

		// corperate customer button
		btnc = new JButton("Corporate Customer");
		btnc.setForeground(Color.CYAN);
		btnc.setBackground(Color.DARK_GRAY);
		btnc.setBounds(675, 130, 188, 44);
		btnc.addActionListener(this);
		pnlmain.add(btnc);

		// manage bboking level
		lblmanage = new JLabel("MANAGE BOOKINGS");
		lblmanage.setBounds(718, 39, 145, 14);
		pnlmain.add(lblmanage);

		// background image
		lblbackg = new JLabel("");
		lblbackg.setIcon(new ImageIcon(getClass().getResource("staff dashboard.jpg")));
		lblbackg.setBounds(0, 0, 884, 526);
		pnlmain.add(lblbackg);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnsign) {
			Login Log = new Login();
			setVisible(false);
		}
		if (ae.getSource() == btnbook) {
			new staffBooking();
			
		}
		
		if (ae.getSource() == btnrestro) {
			new Restro();
			
		}
		if (ae.getSource() == btnext) {
			new Servicess();
	}

	
	if (ae.getSource() == btnbar) {
		new Bar();
}
	
	if (ae.getSource() == btnchecki) {
		new CheckInn();  
} 
	if(ae.getSource()==btnroom) {
		new Room();
	}
	if(ae.getSource()==btnchecko) {
		new Checkout();
	}
	}
	
}