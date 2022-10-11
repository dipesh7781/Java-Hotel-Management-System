 package ui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.border.TitledBorder;
public class Bill extends JFrame {
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtArr;
	private JTextField txtDepDate;
	private JTextField txtInvoice;
	private JTextField txtBilldate;
	private JTextField dxtDate;
	private JTextField txtDesc;
	private JTextField txtRate;
	private JTextField txtSC;
	private JTextField txtVAt;
	private JTextField txtTotal;	
	// To get instance date
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	Date date = new Date();  
	String currentDate = dateFormat.format(date);
	// Default constructor to initialze the contents of the frame
	public Bill() {
		setTitle("Bill Invoice");
		setBackground(Color.WHITE);
		setBounds(100, 100, 977, 652);
		setResizable(false);
		// To get instance date
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = new Date();  
		String currentDate = dateFormat.format(date);
		// To set the center
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 936, 582);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("Hotel Luton Pvt. Ltd.");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(290, 38, 408, 47);
		panel.add(lblNewLabel);
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 175, 916, 9);
		panel.add(separator);
		JLabel lbl10 = new JLabel("Guest Name: ");
		lbl10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl10.setBounds(30, 190, 123, 33);
		panel.add(lbl10);
		JLabel lbl11 = new JLabel("Address: ");
		lbl11.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl11.setBounds(30, 233, 103, 33);
		panel.add(lbl11);
		JLabel lbl13 = new JLabel("Arr date:");
		lbl13.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl13.setBounds(30, 276, 103, 33);
		panel.add(lbl13);
		txtName = new JTextField("");
		txtName.setBorder(null);
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtName.setBounds(163, 190, 185, 33);
		panel.add(txtName);
		txtName.setColumns(10);
		txtAddress = new JTextField();
		txtAddress.setBorder(null);
		txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(163, 233, 185, 33);
		panel.add(txtAddress);
		txtArr = new JTextField();
		txtArr.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtArr.setColumns(10);
		txtArr.setBounds(163, 276, 185, 33);
		txtArr.setBorder(null);
		panel.add(txtArr);
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(22, 629, 70, 33);
		panel.add(txtArea);
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				PrinterJob job = PrinterJob.getPrinterJob();
	            job.setJobName("Print Data");
	            
	            job.setPrintable(new Printable(){
	            public int print(Graphics pg,PageFormat pf, int pageNum){
	                    pf.setOrientation(PageFormat.LANDSCAPE);
	                 if(pageNum > 0){
	                    return Printable.NO_SUCH_PAGE;
	                }
	                
	                Graphics2D g2 = (Graphics2D)pg;
	                g2.translate(pf.getImageableX(), pf.getImageableY());
	                g2.scale(0.47,0.47);
	                
	                panel.print(g2);
	         
	               
	                return Printable.PAGE_EXISTS;
	                         
	                
	            }
	    });
	            boolean ok = job.printDialog();
	        if(ok){
	        try{
	            
	        job.print();
	        }
	        catch (PrinterException ex){
		ex.printStackTrace();
	}
	        }
			
			
			}
			
			
			});
		btnPrint.setBounds(848, 34, 85, 21);
		panel.add(btnPrint);
		JLabel lbl1 = new JLabel("Dep date:");
		lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl1.setBounds(516, 276, 103, 33);
		panel.add(lbl1);

		txtDepDate = new JTextField();
		txtDepDate.setBorder(null);
		txtDepDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDepDate.setColumns(10);
		txtDepDate.setBounds(725, 276, 185, 33);
		panel.add(txtDepDate);
		txtDepDate.setText(currentDate);

		JLabel lbl2 = new JLabel("Invoice No:");
		lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl2.setBounds(516, 190, 123, 33);
		panel.add(lbl2);

		txtInvoice = new JTextField();
		txtInvoice.setBorder(null);
		txtInvoice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtInvoice.setColumns(10);
		txtInvoice.setBounds(725, 190, 185, 33);
		panel.add(txtInvoice);
		JLabel lbl3 = new JLabel("Payment Status:");
		lbl3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl3.setBounds(516, 233, 159, 33);
		panel.add(lbl3);

		txtBilldate = new JTextField();
		txtBilldate.setBorder(null);
		txtBilldate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtBilldate.setColumns(10);
		txtBilldate.setBounds(725, 233, 185, 33);
		panel.add(txtBilldate);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 319, 916, 9);
		panel.add(separator_1);

		JLabel lbl4 = new JLabel("Date");
		lbl4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl4.setBounds(32, 338, 85, 33);
		panel.add(lbl4);

		JLabel lbl5 = new JLabel("Description");
		lbl5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl5.setBounds(149, 339, 152, 33);
		panel.add(lbl5);

		JLabel lbl6 = new JLabel("SC (10%)");
		lbl6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl6.setBounds(468, 338, 85, 33);
		panel.add(lbl6);

		JLabel lbl7 = new JLabel("VAT(13%)");
		lbl7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl7.setBounds(622, 338, 110, 33);
		panel.add(lbl7);

		JLabel lbl8 = new JLabel("Total");
		lbl8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl8.setBounds(797, 338, 47, 33);
		panel.add(lbl8);

		JLabel lbl9 = new JLabel("Amount");
		lbl9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl9.setBounds(324, 338, 90, 33);
		panel.add(lbl9);

		dxtDate = new JTextField();
		dxtDate.setBorder(new EmptyBorder(0, 0, 1, 0));
		dxtDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dxtDate.setColumns(10);
		dxtDate.setBounds(30, 400, 103, 33);
		panel.add(dxtDate);
		dxtDate.setText(currentDate);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(20, 381, 916, 9);
		panel.add(separator_1_1);

		txtDesc = new JTextField();
		txtDesc.setBorder(new EmptyBorder(0, 0, 1, 0));
		txtDesc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDesc.setColumns(10);
		txtDesc.setBounds(151, 400, 135, 33);
		panel.add(txtDesc);


		txtRate = new JTextField();
		txtRate.setBorder(new EmptyBorder(0, 0, 1, 0));
		txtRate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtRate.setColumns(10);
		txtRate.setBounds(324, 400, 85, 33);
		panel.add(txtRate);
		//txtRate.setEditable(false);

		txtSC = new JTextField();
		txtSC.setBorder(new EmptyBorder(0, 0, 1, 0));
		txtSC.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSC.setColumns(10);
		txtSC.setBounds(468, 400, 70, 33);
		panel.add(txtSC);

		txtVAt = new JTextField();
		txtVAt.setBorder(new EmptyBorder(0, 0, 1, 0));
		txtVAt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtVAt.setColumns(10);
		txtVAt.setBounds(635, 400, 70, 33);
		panel.add(txtVAt);

		txtTotal = new JTextField();
		txtTotal.setBorder(new EmptyBorder(0, 0, 1, 0));
		txtTotal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTotal.setColumns(10);
		txtTotal.setBounds(798, 400, 85, 33);
		panel.add(txtTotal);

		JLabel hlbl = new JLabel("Kupondole , Lalitpur");
		hlbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hlbl.setBounds(327, 76, 314, 33);
		panel.add(hlbl);

		JLabel hlbl1 = new JLabel("Mob: +01 234254375");
		hlbl1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hlbl1.setBounds(375, 95, 223, 33);
		panel.add(hlbl1);

		JLabel hlbl2 = new JLabel("VAT No: 720720720");
		hlbl2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hlbl2.setBounds(378, 119, 223, 33);
		panel.add(hlbl2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Thank you visit again!");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.ITALIC, 15));
		lblNewLabel_1_4.setBounds(229, 519, 190, 33);
		panel.add(lblNewLabel_1_4);
		
		
		
		setVisible(true); }
	
	// Main method to run the application
public static void main(String[] args) {
	      new Bill();
		}

public List<Integer> getRoomNo(int i) {
	// TODO Auto-generated method stub
	return null;
}
}