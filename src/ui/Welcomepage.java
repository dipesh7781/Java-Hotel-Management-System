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

public class Welcomepage extends JFrame implements ActionListener {
	JPanel pnltitle;
	JLabel lblfirstimg, lblscndimg, lblbackground1, lblbackground2, lblsingle, lbltwin, lblpremium, lbldouble,
			lblsinglet, lbltwint, lblpremiumt, lbldoublet, lblwelcome;
	JButton btnsignin;

	public Welcomepage() {

		setTitle("WELCOME TO HOTEL LUTON");
		setBounds(100, 100, 531, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setLocationRelativeTo(null);
		setSize(1350,900);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);

		pnltitle = new JPanel();
		pnltitle.setBounds(0, 0, 1370, 86);
		pnltitle.setBackground(Color.WHITE);
		getContentPane().add(pnltitle);
		pnltitle.setLayout(null);

		lblfirstimg = new JLabel();
		lblfirstimg.setIcon(new ImageIcon(getClass().getResource("logofirst.jpg")));
		lblfirstimg.setBounds(0, 0, 289, 85);
		pnltitle.add(lblfirstimg);

		// btnsign in
		btnsignin = new JButton("SIGN IN");
		btnsignin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnsignin.setBackground(Color.GRAY);
		btnsignin.setForeground(Color.CYAN);
		btnsignin.setBounds(1249, 21, 89, 43);
		btnsignin.addActionListener(this);
		pnltitle.add(btnsignin);

		lblscndimg = new JLabel();
		lblscndimg.setIcon(new ImageIcon(getClass().getResource("ConfirmBooking.jpg")));
		lblscndimg.setBounds(531, 0, 839, 86);
		pnltitle.add(lblscndimg);

		// Single room image
		lblsingle = new JLabel();
		lblsingle.setIcon(new ImageIcon(getClass().getResource("singleroom.jpg")));
		lblsingle.setBounds(46, 297, 275, 184);
		getContentPane().add(lblsingle);

		// twin room image
		lbltwin = new JLabel();
		lbltwin.setIcon(new ImageIcon(getClass().getResource("TwinRoom.jpg")));
		lbltwin.setBounds(368, 297, 275, 184);
		getContentPane().add(lbltwin);

		// premium room image
		lblpremium = new JLabel();
		lblpremium.setIcon(new ImageIcon(getClass().getResource("premiumroom.jpg")));
		lblpremium.setBackground(Color.WHITE);
		lblpremium.setBounds(705, 297, 275, 184);
		getContentPane().add(lblpremium);

		// double room image
		lbldouble = new JLabel("");
		lbldouble.setIcon(new ImageIcon(getClass().getResource("Double room.jpg")));
		lbldouble.setBounds(1046, 297, 275, 184);
		getContentPane().add(lbldouble);

		// Single room text
		lblsinglet = new JLabel("Single Room");
		lblsinglet.setForeground(Color.BLACK);
		lblsinglet.setBounds(111, 492, 172, 22);
		lblsinglet.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		getContentPane().add(lblsinglet);

		// twin room text
		lbltwint = new JLabel("Twin Room");
		lbltwint.setForeground(Color.BLACK);
		lbltwint.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lbltwint.setBounds(450, 492, 135, 22);
		getContentPane().add(lbltwint);

		// premium room text
		lblpremiumt = new JLabel("Premium Room");
		lblpremiumt.setForeground(Color.BLACK);
		lblpremiumt.setBounds(752, 492, 191, 22);
		lblpremiumt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		getContentPane().add(lblpremiumt);

		// double room text
		lbldoublet = new JLabel("Double Room");
		lbldoublet.setForeground(Color.BLACK);
		lbldoublet.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lbldoublet.setBounds(1108, 492, 147, 22);
		getContentPane().add(lbldoublet);

		// image background lower part background2
		lblbackground2 = new JLabel();
		lblbackground2.setIcon(new ImageIcon(getClass().getResource("wel back 21.jpg")));
		lblbackground2.setBounds(0, 397, 1470, 352);
		getContentPane().add(lblbackground2);

		// welcome to hotel luton text
		lblwelcome = new JLabel("WELCOME TO HOTEL LUTON");
		lblwelcome.setForeground(Color.CYAN);
		lblwelcome.setBounds(475, 124, 461, 65);
		lblwelcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		getContentPane().add(lblwelcome);

		// background image upper part background1
		lblbackground1 = new JLabel("");
		lblbackground1.setIcon(new ImageIcon(getClass().getResource("wel back 12.jpg")));
		lblbackground1.setBounds(0, 85, 1370, 343);
		getContentPane().add(lblbackground1);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Welcomepage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnsignin) {
			new Login();
			setVisible(false);
		}
	}

}