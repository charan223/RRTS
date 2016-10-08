import java.awt.BorderLayout;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SComplaint extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static int whocalled=0;
    static int Tcomp=0;
	Connection con;
	boolean isconnected=false;
private JTextArea textArea;
	private int AreaCode;
	private String ComplaintType;
	private Date DateofCompl;
	private String ComplaintDetails;
	private int priority;
	private JSpinner spinner;
	private int manpower;
	private int machinepower;
	private int rawmaterials;
	private int cid;
	static int whatisid=0;
	static SResources Srsc=new SResources();
	
	
	public int getid(){
		
		return cid;
	}
	public void setid(int j){
		
		cid=j;
		
	}
	
	
	public int getareacode()
	{
		return AreaCode;
	}
	
	public void setareacode(int k){
		
		AreaCode=k;
	}
	
	
	public String getcomplainttype()
	{
		return ComplaintType;
	}
public void settype(String k){
		
		ComplaintType=k;
	}
	
	public String getcomplaintdetails()
	{
		return ComplaintDetails;
	}
	
public void setdetails(String k){
		
		ComplaintDetails=k;
	}
	
	
	public int getmanpower()
	{
		return manpower;
	}
	
public void setmanp(int k){
		
		manpower=k;
	}
	public int getmachinepower()
	{
		return machinepower;
	}
public void setmachp(int k){
		
		machinepower=k;
	}
	public int getrawmaterials()
	{
		return rawmaterials;
	}
	
public void setrawmat(int k){
		
		rawmaterials=k;
	}
	public int getpriority()
	{
		return priority;
	}
public void setpriority(int k){
		
		priority=k;
	}
	
	public JTextField getareacodefield(){
		
		return textField;
		
	}
	
public JTextField gettypefield(){
		
		return textField_1;
		
	}
	
public JTextArea getdetailsarea(){
	
	return textArea;
	
}

public JSpinner getspinner(){
	
	return spinner;
	
}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SComplaint frame = new SComplaint();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param  
	 */
	public SComplaint() {
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
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				
				try {
					Class.forName("org.sqlite.JDBC");
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try{
					
					con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\CHARAN\\workspace1\\AdminData.sqlite");
					JOptionPane.showMessageDialog(null, "SUCCESSFUL CONNECTION");
					isconnected=true;
					
				}
				
				
				catch(Exception e){
					
					JOptionPane.showMessageDialog(null, "NOT SUCCESSFUL CONNECTION");
					
				}
				
				
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAreaCode = new JLabel("Area Code");
		lblAreaCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAreaCode.setBounds(10, 32, 94, 27);
		contentPane.add(lblAreaCode);
		
		JLabel lblComplaintType = new JLabel("Complaint Type");
		lblComplaintType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComplaintType.setBounds(10, 93, 117, 27);
		contentPane.add(lblComplaintType);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDetails.setBounds(10, 156, 65, 19);
		contentPane.add(lblDetails);
		
		textField = new JTextField();
		textField.setBounds(167, 37, 340, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 98, 340, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(167, 155, 340, 111);
		contentPane.add(textArea);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				    AreaCode=Integer.parseInt(textField.getText());
					
					ComplaintType=textField_1.getText();
					
					ComplaintDetails=textArea.getText();
					
					priority = (Integer) spinner.getValue();
					
					
					try
					{
				
						int tcomp=0;
						Statement ghs=con.createStatement();
						ResultSet rhs=ghs.executeQuery("select * from ComplaintData");
						while(rhs.next()){	
						tcomp++;	
						}
						rhs.close();
						ghs.close();
						
						
						//SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				     	//Date date=new Date();
						//java.sql.Date sqlDate = new java.sql.Date(date.getTime());
						//df.format(sqlDate);
		
					// java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());				
						java.util.Date now = new java.util.Date();
						  java.sql.Date sqlDate = new java.sql.Date(now.getTime());
						  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						  String text = df.format(sqlDate);
						  //java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
						  
						  
						  
						  
						tcomp++;
						
						if(whocalled==0){
					String query ="insert into ComplaintData (AreaCode,ComplaintType,ComplaintDetails,ComplaintDate,ManPower,MachinePower,RawMaterials,Priority,Complaintid) values(?,?,?,?,?,?,?,?,?)";	
						PreparedStatement pst=con.prepareStatement(query);
						pst.setInt(1, AreaCode);
						pst.setString(2, ComplaintType);
						pst.setString(3, ComplaintDetails);
						pst.setString(4, text);
						pst.setInt(9, tcomp);
						
						pst.execute();
						pst.close();
						
						
						}
						
						
						if(whocalled!=0){
							
						//	if(Srsc!=null){
								
								
						int bl=1;		
  PreparedStatement pst=con.prepareStatement("Update ComplaintData set ManPower='"+Srsc.getmanp()+"',MachinePower='"+Srsc.getmachp()+"',RawMaterials='"+Srsc.getrawmat()+"',Priority='"+priority+"',Filled='"+bl+"' where ComplaintDetails='"+ComplaintDetails+"'");
						//pst.setInt(5,Srsc.getmanp());
						//pst.setInt(6,Srsc.getmachp());
						//pst.setInt(7,Srsc.getrawmat());
						//pst.setInt(8, priority);
						pst.execute();
							pst.close();
							
							//}
						}
					/*	else{
							
							pst.setInt(4,0);
							pst.setInt(5,0);
							pst.setInt(6,0);
							pst.setInt(7,0);
							}*/
						
					//	ResultSet rs=pst.executeQuery();
						
					//	rs.close();
					
						
					
					}catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
						
					}
					
					dispose();
			
					
				
			}
		});
		btnSave.setBounds(203, 381, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(whocalled!=0){
					
					try {
						String query="delete from ComplaintData where Complaintid='"+whatisid+"' ";
						PreparedStatement fpk=con.prepareStatement(query);
						fpk.execute();
						fpk.close();
						dispose();
						JOptionPane.showMessageDialog(null, "Complaint with id = "+whatisid+" is deleted");
						
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
				}
				
			}
		});
		btnDelete.setBounds(308, 381, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPriority.setBounds(10, 311, 65, 19);
		contentPane.add(lblPriority);
		
		spinner = new JSpinner();
		spinner.setBounds(167, 306, 73, 43);
		contentPane.add(spinner);
		
		JButton btnEstimateResources = new JButton("Estimate Resources");
		btnEstimateResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(whocalled!=0){
				Srsc.setVisible(true);}
				
			}
		});
		btnEstimateResources.setBounds(290, 311, 141, 23);
		contentPane.add(btnEstimateResources);
	}
}
