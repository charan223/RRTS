import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.sql.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SSupervisor extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	static int isupdated=0;
	private String Name;
	private int AllotAreaCode;
	private JLabel lblName,lblCode;
	 int[] rowid=new int[20];
	boolean isconnected=false;
	Connection con=null;
	
	int ac=0;

	public String getname(){
		
	return	Name;
		
	}
	

	public void setname(String name){
		
	Name=name;
		
	}
	

	public int getcode(){
		
		return AllotAreaCode;
		
	}
	
public void setcode(int h){
		
		 AllotAreaCode=h;
		
	}
	
	
	public JLabel getnamelbl(){
		
		return lblName;
		
	}
	
	public JLabel getAreaCodelbl(){
		
		return lblCode;
		
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SSupervisor frame = new SSupervisor();
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
	public SSupervisor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				
				
		        try {
					Class.forName("org.sqlite.JDBC");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try{
					
					con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bharath\\Documents\\Databasesqlite\\AdminData.sqlite");
			//		JOptionPane.showMessageDialog(null, "SUCCESSFUL CONNECTION");
					isconnected=true;
					
				}
				
				
				catch(Exception e){
					
					JOptionPane.showMessageDialog(null, "NOT SUCCESSFUL CONNECTION");
					
				}
				
				
				try {
					ac=AllotAreaCode;
					PreparedStatement pst=con.prepareStatement("select * from ComplaintData where AreaCode=?");
					pst.setInt(1, ac);
					ResultSet rs=pst.executeQuery();
					
					int c=0;
					while(rs.next()){
						rowid[c]=rs.getInt("Complaintid");
		                comboBox.addItem(rowid[c]);
						c++;
					}
					
					rs.close();
					pst.close();
					
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					
				
				
				
			}
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				
				try {
					
				//	if(comboBox.getItemCount()!=0){
				//	comboBox.removeAllItems();}
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_8478260268778");
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("View Complaint");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getItemCount()!=0){
				
				int i=comboBox.getSelectedIndex();
				int r=rowid[i];
				SComplaint.whatisid=r;
				
				try {
					PreparedStatement ps=con.prepareStatement("select *from ComplaintData where Complaintid=?");
					ps.setInt(1, r);
					ResultSet rst=ps.executeQuery();
					
					SComplaint cs=new SComplaint();
				if(rst.next()){
					String s=Integer.toString(rst.getInt("AreaCode"));
					cs.getareacodefield().setText(s);
					cs.gettypefield().setText(rst.getString("ComplaintType"));
					cs.getdetailsarea().setLineWrap(true);
					cs.getdetailsarea().setWrapStyleWord(true);
					cs.getdetailsarea().setText(rst.getString("ComplaintDetails"));
					SComplaint.Srsc=new SResources();
					if(rst.getBoolean("Filled")){
					cs.getspinner().setValue(rst.getInt("Priority"));
					SComplaint.Srsc.getmanpspin().setValue(rst.getInt("ManPower"));
					SComplaint.Srsc.getmachpspin().setValue(rst.getInt("MachinePower"));
					SComplaint.Srsc.getrawmspin().setValue(rst.getInt("RawMaterials"));
					}
					//s=Integer.toString(rs.getInt("Priority"));
				//cs.getspinner().setValue(Integer.valueOf(rst.getInt("Priority")));
					cs.setVisible(true);
					
					rst.close();
					ps.close();
				}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				}
				
				
				
			}
		});
		btnNewButton.setBounds(234, 201, 121, 31);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Print Schedule");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				PreparedStatement pstisadmin;
				try {
					pstisadmin = con.prepareStatement("select * from AdminData");
					ResultSet rsisadmin=pstisadmin.executeQuery();
					if(!rsisadmin.next()){JOptionPane.showMessageDialog(null, "AdminData is empty");}
					
					else{		
						boolean com=true;
						
						try{
							
						
						
						String sq=lblCode.getText();
						int it=Integer.parseInt(sq);
								PreparedStatement pst=con.prepareStatement("select * from ComplaintData where Complaintid='"+it+"' and boolschedule='"+0+"' ");
								ResultSet rs=pst.executeQuery();
								if(!rs.next()){com=false;JOptionPane.showMessageDialog(null, "Scheduling done already");}
								else{
									
								do
								{
									boolean isf=rs.getBoolean("Filled");
									if(!isf)
									{
										JOptionPane.showMessageDialog(null,"Fill all priorities");
										com=false;
										break; 
										
									}
									
									
								}while(rs.next());
								
						
						}
								rs.close();
								pst.close();
								
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						if(com){
							
							int i;

							int a=comboBox.getItemCount();
							ArrayList<SComplaint> cpl=new ArrayList<SComplaint>(a);
							
							int arr[]=new int[a];
							try {
								PreparedStatement pst=con.prepareStatement("select * from ComplaintData");
								ResultSet rs=pst.executeQuery();

								for(i=0;i<a;i++)
								{
									cpl.add(new SComplaint());
								while(rs.next())
								{ 
									
									cpl.get(i).setmanp(rs.getInt("ManPower"));
									cpl.get(i).setmachp(rs.getInt("MachinePower"));
									cpl.get(i).setpriority(rs.getInt("Priority"));
									cpl.get(i).setid(rs.getInt("Complaintid"));
									break;
									//arr[i]=cpl[i].getpriority();
								}   
									
								}
								cpl.sort(new Comparator<SComplaint>() {
								     
										@Override
										public int compare(SComplaint o1, SComplaint o2) {
											if(o1.getpriority()>o2.getpriority())
												return o1.getpriority();
											else
												return o2.getpriority();
											
											// TODO Auto-generated method stub
											
										}
								    });
						
								
								
							//	PreparedStatement pst1=con.prepareStatement("select * from AdminData");
							//	ResultSet rs1=pst1.executeQuery();
								
								PreparedStatement pst1=null;
								ResultSet rs1=null;
								for(int k=0;k<a;k++)
								{
									
									pst1=con.prepareStatement("select * from AdminData");
									rs1=pst1.executeQuery();
									
									int manp=cpl.get(k).getmanpower();
									int macp=cpl.get(k).getmachinepower();
									int prip=cpl.get(k).getpriority();
									int cid=cpl.get(k).getid();
									while(rs1.next())
									{
										if(manp<(rs1.getInt("ManPower")-rs1.getInt("CommittedMan")) &&macp<(rs1.getInt("MachinePower")-rs1.getInt("CommittedMachine")))
										{

											PreparedStatement pst2=con.prepareStatement("update ComplaintData set IsScheduled='"+rs1.getInt("Id")+"',boolschedule='"+1+"' where Complaintid='"+cid+"'");
										    pst2.execute();
										    pst2.close();
										    int j=rs1.getInt("CommittedMan")+manp;
										    int jq=rs1.getInt("CommittedMachine")+macp;
										    PreparedStatement pst3=con.prepareStatement("update AdminData set CommittedMan='"+j+"',CommittedMachine='"+jq+"' where Id='"+rs1.getInt("Id")+"'");
										    pst3.execute();
										    pst3.close();
										   
											break;
										}
											
								
										
									}
								}
								
								
								rs.close();
								pst.close();
								rs1.close();
								pst1.close();
								JOptionPane.showMessageDialog(null, "Scheduling Successful");
								
								
							
								
								}
								
								
					
							catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
					}//check if all priorities are filled
							
							}//check if admin data is empty
						
					rsisadmin.close();
					pstisadmin.close();
				
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error Scheduling!!");
				}
		
				
		
			
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(234, 275, 121, 31);
		panel.add(btnNewButton_1);
		
		JLabel lblName11 = new JLabel("Name");
		lblName11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName11.setBounds(39, 35, 65, 19);
		panel.add(lblName11);
		
		JLabel lblAreacode = new JLabel("AreaCode");
		lblAreacode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAreacode.setBounds(39, 91, 65, 25);
		panel.add(lblAreacode);
		
		lblName = new JLabel("name");
		lblName.setBounds(162, 39, 330, 15);
		panel.add(lblName);
		
		lblCode = new JLabel("New label");
		lblCode.setBounds(162, 98, 330, 18);
		panel.add(lblCode);
	
		//add array to comboBox
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(66, 206, 134, 20);
		panel.add(comboBox);
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "name_9398534409550");
		panel_1.setLayout(null);
	}

}
