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



public class FoodMenu extends JFrame implements ActionListener{
	JPanel pnltitle;
	JLabel lblfirstimg, lblscndimg, lblbackground1, lblbackground2,lblmainback,lblfood,lbllunch,lblbreakfast,lbldinner,lbldrinks,lblhard,lblsoft;
	JButton  btnexit; 	
	public FoodMenu() {
	
		
		setTitle("Menu");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,650);
		getContentPane().setLayout(null);
		
		//title panel
		pnltitle = new JPanel();
		pnltitle.setBounds(0, 0, 884, 91);
		getContentPane().add(pnltitle);
		pnltitle.setBackground(Color.WHITE);
		pnltitle.setLayout(null);
		
		//logo image first part
		lblfirstimg=new JLabel();
		lblfirstimg.setIcon( new ImageIcon(getClass().getResource("logofirst.jpg")));
		lblfirstimg.setBounds(0, 0, 289, 80);
		pnltitle.add(lblfirstimg);
		
		//exit button
		btnexit = new JButton("EXIT");
		btnexit.setBackground(Color.GRAY);
		btnexit.setForeground(Color.CYAN);
		btnexit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnexit.setBounds(793, 24, 66, 33);
		pnltitle.add(btnexit);
		btnexit.addActionListener(this);
		
		//logo image part 2
		lblscndimg = new JLabel("");
		lblscndimg.setBounds(289, 0, 595, 91);
		pnltitle.add(lblscndimg);
		lblscndimg.setIcon(new ImageIcon(getClass().getResource("ConfirmBooking.jpg")));
		
		//lblfood item
		lblfood = new JLabel("FOOD ITEMS");
		lblfood.setForeground(Color.LIGHT_GRAY);
		lblfood.setBounds(145, 164, 233, 55);
		lblfood.setFont(new Font("Tahoma", Font.BOLD, 30));
		getContentPane().add(lblfood);
		
		//lbl breakfast
		lblbreakfast = new JLabel("BREAKFAST");
		lblbreakfast.setForeground(Color.WHITE);
		lblbreakfast.setBounds(100, 243, 163, 25);
		lblbreakfast.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblbreakfast);
		
		//lbl lunch
		lbllunch = new JLabel("LUNCH");
		lbllunch.setForeground(Color.WHITE);
		lbllunch.setBounds(100, 299, 129, 25);
		lbllunch.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lbllunch);
		
		//lbl dinner
		lbldinner = new JLabel("DINNER");
		lbldinner.setForeground(Color.WHITE);
		lbldinner.setBounds(100, 352, 108, 25);
		lbldinner.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lbldinner);
		
		//lblbackground 1
		lblbackground1 = new JLabel("");
		lblbackground1.setIcon(new ImageIcon(getClass().getResource("room background1.jpg")));
		lblbackground1.setBounds(89, 159, 305, 247);
		getContentPane().add(lblbackground1);
		
		//lbl drinks item
		lbldrinks = new JLabel("DRINK ITEMS");
		lbldrinks.setForeground(Color.BLACK);
		lbldrinks.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbldrinks.setBounds(505, 164, 253, 55);
		getContentPane().add(lbldrinks);
		
		//lbl hard drinks
		lblhard = new JLabel("HARD DRINK");
		lblhard.setForeground(Color.WHITE);
		lblhard.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblhard.setBounds(509, 243, 163, 25);
		getContentPane().add(lblhard);
		
		//lbl soft drinks
		lblsoft= new JLabel("SOFT DRINK");
		lblsoft.setForeground(Color.WHITE);
		lblsoft.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblsoft.setBounds(505, 299, 153, 25);
		getContentPane().add(lblsoft);
		
		//lbl background 2
		lblbackground2 = new JLabel("New label");
		lblbackground2.setIcon(new ImageIcon(getClass().getResource("back 2 for restro.jpg")));
		lblbackground2.setBounds(489, 159, 295, 247);
		getContentPane().add(lblbackground2);
		
		//lbl background main
		lblmainback = new JLabel("New label");
		lblmainback.setIcon(new ImageIcon(getClass().getResource("menu image.jpg")));
		lblmainback.setBounds(0, 91, 884, 520);
		getContentPane().add(lblmainback);
		
		
		setVisible(true);
		}
	public static void main(String[] args) {
		new FoodMenu();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnexit) {
			dispose();
		}
		
	}
	
}