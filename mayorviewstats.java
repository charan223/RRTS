
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;

public class mayorviewstats extends JFrame {

	private static JTable table;
	private static JTextField textField;
	private static JTextField textId;
	private static JTextField textFname;
	private static JTextField textLname;
	private static JTextField textAge;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	

	
static Connection conn;
private JTextField textField_4;
private JTextField textField_5;
	public mayorviewstats() {
		 // create JFrame and JTable
       
        DefaultTableModel model = new DefaultTableModel();
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosed(WindowEvent e) {
        	
     	try {
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        		
        	}
        	
        	Object[] row1=new Object[8];
        	@Override
        	public void windowOpened(WindowEvent e) {
        		
        		
        		PreparedStatement yt;
				try{
	
					try {
						Class.forName("org.sqlite.JDBC");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try{
						
						conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bharath\\Documents\\Databasesqlite\\AdminData.sqlite");
						JOptionPane.showMessageDialog(null, "SUCCESSFUL CONNECTION");
						
						
					}
					
					
					catch(Exception e3){
						
						JOptionPane.showMessageDialog(null, "NOT SUCCESSFUL CONNECTION");
						
					}
				
					yt = conn.prepareStatement("select * from ComplaintData");
					ResultSet rd=yt.executeQuery();
					
					 int i;
	                 int y=model.getRowCount();
	                 for(i=0;i<y;i++)
	                 model.removeRow(i);
	        		
					while(rd.next()){
						
	        		 row1[0] = rd.getString("AreaCode");
	                 row1[1] = rd.getString("ComplaintType");
	                 row1[2] = rd.getString("ComplaintDetails");
	                 row1[3] = rd.getString("ManPower");
	                 row1[4] = rd.getString("MachinePower");
	                 row1[5] = rd.getString("RawMaterials");
	                 row1[6] = rd.getString("ComplaintDate");
	                 row1[7] = rd.getString("IsScheduled");
	                 model.addRow(row1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

                 // add row to the model
                 
        	}
        });
        JTable table = new JTable(); 
        // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"Areacode","ComplaintType","ComplaintDetails","ManPower","MachinePower","RawMaterials","ComplaintDate","IsScheduled"};
        
        model.setColumnIdentifiers(columns);
       
         
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        table.setVisible(true);
        pane.setBounds(10, 11, 864, 535);
        
        getContentPane().setLayout(null);
       // pane.setSize(getWidth(), getHeight());
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       getContentPane().add(pane);
       
       JLabel lblNewLabel = new JLabel("View Number of Repairs over specific time");
       lblNewLabel.setBounds(83, 587, 434, 16);
       getContentPane().add(lblNewLabel);
       
       textField_4 = new JTextField();
       textField_4.setBounds(535, 584, 116, 22);
       getContentPane().add(textField_4);
       textField_4.setColumns(10);
       
       JLabel lblTo = new JLabel("To");
       lblTo.setBounds(678, 587, 21, 16);
       getContentPane().add(lblTo);
       
       textField_5 = new JTextField();
       textField_5.setBounds(729, 584, 116, 22);
       getContentPane().add(textField_5);
       textField_5.setColumns(10);
       
       JButton btnView = new JButton("View");
       
		
       btnView.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		String initial=textField_4.getText();
       		String finale=textField_5.getText();
       		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       		PreparedStatement yt;
/*			try{

				
				try {
					Class.forName("org.sqlite.JDBC");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				try{
					
					conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bharath\\Documents\\Databasesqlite\\AdminData.sqlite");
					JOptionPane.showMessageDialog(null, "SUCCESSFUL CONNECTION");
					
				}catch(Exception e3){
					
					JOptionPane.showMessageDialog(null, "NOT SUCCESSFUL CONNECTION");
					
				}
			
			}catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null, "NOT SUCCESSFUL CONNECTION");
			}
			*/
			Date date1 = null;
			Date date = null;
	
		
       		try {
       			
				date = (Date) df.parse(initial);
				date1 = (Date) df.parse(finale);
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       		
       		String new1;
       		int count=0;
       		try {
				yt = conn.prepareStatement("select * from ComplaintData");
				ResultSet rd = yt.executeQuery();
				
				
				while(rd.next())
				{
				    new1=rd.getString("ComplaintDate");
				    Date newdate = (Date) df.parse(new1);
					if(newdate.after(date) && newdate.before(date1))
					count++;
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   			
       		JOptionPane.showMessageDialog(null, "No of repairs in the given period ="+count);
       		
       	}
       });
       btnView.setBounds(377, 639, 97, 25);
       getContentPane().add(btnView);
       
       JButton btnNewButton = new JButton("Repair work outstanding");
       btnNewButton.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		
       		PreparedStatement yt;
       		ResultSet rd = null;
			try {
				yt = conn.prepareStatement("select * from ComplaintData");
				rd = yt.executeQuery();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int count=0;
			try {
				while(rd.next())
				{
					
				    if(rd.getInt("boolschedule")==0)
					count++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Outstanding works ="+count);
       	}
       });
       btnNewButton.setBounds(302, 729, 246, 25);
       getContentPane().add(btnNewButton);
        
        // create an array of objects to set the row data
        Object[] row = new Object[8];
        
       setSize(900,925);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        
    }
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mayorviewstats fr = new mayorviewstats();
					fr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}