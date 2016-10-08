import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.sql.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

;public class CentralLoginnew extends JFrame {

	private JPanel contentPane; 
	private JTextField textField;
	private JPasswordField passwordField;
	boolean isconnected=false;
	
//	static int Tclrk=0,Tsup=0;
	
	 private SSupervisor Ssup;
	 private SClerk Sclrk;
	 private SAdministrator Sadm=new SAdministrator();
     private SMayor Smay=new SMayor();	

	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CentralLoginnew frame = new CentralLoginnew();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** 
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public CentralLoginnew() throws ClassNotFoundException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				if(isconnected){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		});
		
		Class.forName("org.sqlite.JDBC");
		
		try{
			
			con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\CHARAN\\workspace1\\AdminData.sqlite");
			JOptionPane.showMessageDialog(null, "SUCCESSFUL CONNECTION");
			isconnected=true;
			
		}
		
		
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "NOT SUCCESSFUL CONNECTION");
			
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(83, 73, 84, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(83, 118, 84, 26);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(191, 78, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 123, 153, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				String name=textField.getText();
				
				String pass=passwordField.getText();
				
				
				try {
					
					PreparedStatement ps=con.prepareStatement("select *from LoginDetails where Username=? and Password=?");
					ps.setString(1,name);
					ps.setString(2,pass);
					
					ResultSet rs=ps.executeQuery();
			
					
			
	if(!rs.isBeforeFirst()){   	JOptionPane.showMessageDialog(null, "Invalid Login! Try Again!");   }				
			
	
	
	
	
	//	while(rs.next()){
	  if(rs.next()){
						
	 int i=rs.getInt("Employee Type");
	 
	 int e=0,y=0;
	 
						if(i==0){
						
						Sclrk=new SClerk();
						Sclrk.setName(name);
						Sclrk.getnamelbl().setText(name);
					    String p=Integer.toString(rs.getInt("AreaCode"));
						Sclrk.getcodelbl().setText(p);
						Sclrk.setBranch(rs.getInt("AreaCode"));
						Sclrk.setVisible(true);
						SComplaint.whocalled=0;
						//Tclrk++;
						
												
						//now update status to True
						
							
						}
						if(i==1){
				
						Ssup=new SSupervisor();
						Ssup.setname(name);
						Ssup.getnamelbl().setText(name);
						String p=Integer.toString(rs.getInt("AreaCode"));
						Ssup.getAreaCodelbl().setText(p);
						Ssup.setcode(rs.getInt("AreaCode"));
						Ssup.setVisible(true);
					    SComplaint.whocalled=1;	
						//Tsup++;		
						
						}
						
						if(i==2){
							
							
						Sadm.setname(name);
						Sadm.getnamelbl().setText(name);	
						Sadm.setVisible(true);
							
						}
						if(i==3){
								
						Smay.setname(name);
						Smay.getnamelbl().setText(name);
						Smay.setVisible(true);
						}
						
						
						
						if(i!=0&&i!=1&&i!=2&&i!=3){
								
							JOptionPane.showMessageDialog(null, "Invalid Login! Try Again!");
							
						}
	  }	
						
				//	}
         
					rs.close();
					ps.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(168, 196, 99, 26);
		contentPane.add(btnLogin);
	}
}
