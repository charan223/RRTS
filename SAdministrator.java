import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.lang.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.sql.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SAdministrator extends JFrame {

	
	
	private JPanel contentPane;
	private JPanel Display=new JPanel();
	private JPanel Main=new JPanel();
	private String Name;
	private JLabel lblNameOfAdmin;
	public void setname(String h){
		
		Name=h;
		
	}
	
	public String getname(){
		
		return Name;
	}

	public JLabel getnamelbl(){
		
		return lblNameOfAdmin;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SAdministrator frame = new SAdministrator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn=null;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public SAdministrator() {
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
						
						conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bharath\\Documents\\Databasesqlite\\AdminData.sqlite");
				//		JOptionPane.showMessageDialog(null, "SUCCESSFUL CONNECTION");
						//isconnected=true;
						
					}
					
					
					catch(Exception e){
						
						JOptionPane.showMessageDialog(null, "NOT SUCCESSFUL CONNECTION");
						
					}
					
				
				
				
			}
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1015, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(Main, "name_68921043881977");
		Main.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(67, 52, 86, 33);
		Main.add(lblName);
		
		lblNameOfAdmin = new JLabel("Name of admin");
		lblNameOfAdmin.setBounds(287, 60, 214, 16);
		Main.add(lblNameOfAdmin);
		
		//this button updates values if row
		JButton btnNewButton = new JButton("Update");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	String l="0";
				int k=Integer.parseInt(JOptionPane.showInputDialog("Give the value of row number to be updated"));
				while(l!="-1"){
				l=(JOptionPane.showInputDialog("Give the column name to be updated or give -1 if updation is completed"));
				if(l!="-1"){
				
				String i=JOptionPane.showInputDialog("Give new value of column");
				
				//doono y am getting wrror here
				//PreparedStatement pst=conn.prepareStatement("Update AdminData set ");
				
				ContentValues cv = new ContentValues();
				cv.put(l,i); 
				SQLiteDatabase db = this.getWritableDatabase();
				conn.update("RRTSData", cv, "_id="+k, null);
				//Mydb =dtabase name
				
				}}*/
				Programminglang pgl=new Programminglang();
				pgl.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(164, 182, 130, 25);
		Main.add(btnNewButton);
		
		contentPane.add(Display, "name_68921061377607");
		Display.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 31, 689, 392);
		Display.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(true);
				Display.setVisible(false);
				
			}
		});
		btnBack.setBounds(289, 443, 97, 25);
		Display.add(btnBack);
	}
}
