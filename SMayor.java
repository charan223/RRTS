import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SMayor extends JFrame {

	private JPanel contentPane;
	private String Name;

	private JLabel lblNewLabel;
	
	public JLabel getnamelbl(){
		
		
		return lblNewLabel;
	}
	
	
	public void setname(String h){
	Name=h;	
	}
	public String getname(){
		
		return Name;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SMayor frame = new SMayor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SMayor() { 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 658, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(27, 35, 52, 14);
		contentPane.add(lblName);
		
	 lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(123, 35, 261, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnViewStats = new JButton("View statistics");
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mayorviewstats mvs=new mayorviewstats();
				mvs.setVisible(true);
				
			}
		});
		btnViewStats.setBounds(111, 106, 181, 23);
		contentPane.add(btnViewStats);
	}
}
