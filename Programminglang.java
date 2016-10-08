
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;
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

public class Programminglang extends JFrame{

	
	private static JTable table;
	private static JTextField textField;
	private static JTextField textId;
	private static JTextField textFname;
	private static JTextField textLname;
	private static JTextField textAge;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
    
    DefaultTableModel model = new DefaultTableModel();
	
     static Connection conn=null;
	
	
	public Programminglang() {
		  addWindowListener(new WindowAdapter() {
	        	@Override
	        	public void windowClosing(WindowEvent e) {
	        	
	     		
	     	
				
				
				
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
	       
	        		
	        		try {
						Class.forName("org.sqlite.JDBC");
					} catch (ClassNotFoundException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
	        		
	        		try{
	        			
	        			conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bharath\\Documents\\Databasesqlite\\AdminData.sqlite");
	        			JOptionPane.showMessageDialog(null, "SUCCESSFUL CONNECTION");
	        		
	        			
	        		}
	        		
	        		
	        		catch(Exception e2){
	        			
	        			JOptionPane.showMessageDialog(null, "NOT SUCCESSFUL CONNECTION");
	        			
	        		}
	        		
	        		
	        			
	        		PreparedStatement yt;
					try {
						yt = conn.prepareStatement("select * from AdminData");
						ResultSet rd=yt.executeQuery();
		        
						   int i;
			                 int y=model.getRowCount();
			                 for(i=0;i<y;i++)
			                 model.removeRow(i);
						
						while(rd.next()){
							
		        		 row1[0] = rd.getInt("Id");
		                 row1[1] = rd.getInt("Date");
		                 row1[2] = rd.getInt("ManPower");
		                 row1[3] = rd.getInt("MachinePower");
		                 row1[4] = rd.getInt("CommittedMan");
		                 row1[5] = rd.getInt("CommittedMachine");
		                 row1[6] = rd.getInt("RemainingMan");
		                 row1[7] = rd.getInt("RemainingMachine");
		                
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
	        Object[] columns = {"Id","Date","ManPower","MachinePower","CommittedMan","CommittedMachine","RemainingMan","RemainingMachine"};
	        
	        model.setColumnIdentifiers(columns);
	     
	         
	        // set the model to the table
	        table.setModel(model);
	        
	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	        table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        Font font = new Font("",1,22);
	        table.setFont(font);
	        table.setRowHeight(30);
	        
	        // create JTextFields
	        JTextField textId = new JTextField();
	        JTextField textFname = new JTextField();
	        JTextField textLname = new JTextField();
	        JTextField textAge = new JTextField();
	        JTextField textField = new JTextField();
	        JTextField textField_1 = new JTextField();
	        JTextField textField_2 = new JTextField();
	        JTextField textField_3 = new JTextField();
	        
	        
	        // create JButtons
	        JButton btnAdd = new JButton("Add");
	        JButton btnUpdate = new JButton("Update");     
	        
	        textId.setBounds(280, 384, 100, 25);
	        textFname.setBounds(280, 430, 100, 25);
	        textLname.setBounds(280, 474, 100, 25);
	        textAge.setBounds(280, 517, 100, 25);
	        
	        btnAdd.setBounds(419, 430, 100, 25);
	        btnUpdate.setBounds(419, 488, 100, 25);
	        
	        // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(10, 11, 1038, 352);
	        
	        getContentPane().setLayout(null);
	        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	      getContentPane().add(pane);
	        
	        // add JTextFields to the jframe
	        getContentPane().add(textId);
	        getContentPane().add(textFname);
	        getContentPane().add(textLname);
	       getContentPane().add(textAge);
	     
	        // add JButtons to the jframe
	       getContentPane().add(btnAdd);
	       getContentPane().add(btnUpdate);
	        
	        
	        textField.setBounds(280, 553, 100, 22);
	       getContentPane().add(textField);
	        textField.setColumns(10);
	        
	        textField_1.setBounds(280, 595, 100, 22);
	      getContentPane().add(textField_1);
	        textField_1.setColumns(10);
	        
	        textField_2.setBounds(351, 765, 100, 22);
	     getContentPane().add(textField_2);
	        textField_2.setColumns(10);
	        
	        textField_3.setBounds(351, 803, 100, 22);
	      getContentPane().add(textField_3);
	        textField_3.setColumns(10);
	        
	        JLabel lblNewLabel = new JLabel("Id");
	        lblNewLabel.setBounds(106, 388, 118, 16);
	        getContentPane().add(lblNewLabel);
	       
	        JLabel lblNewLabel_1 = new JLabel("Date");
	        lblNewLabel_1.setBounds(106, 430, 118, 16);
	        getContentPane().add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("ManPower");
	        lblNewLabel_2.setBounds(106, 474, 118, 16);
	      getContentPane().add(lblNewLabel_2);
	        
	        JLabel lblNewLabel_3 = new JLabel("MachinePower");
	        lblNewLabel_3.setBounds(106, 521, 118, 16);
	       getContentPane().add(lblNewLabel_3);
	        
	        JLabel lblNewLabel_4 = new JLabel("CommittedMan");
	        lblNewLabel_4.setBounds(106, 559, 118, 16);
	      getContentPane().add(lblNewLabel_4);
	       
	        JLabel lblNewLabel_5 = new JLabel("CommittedMachine");
	        lblNewLabel_5.setBounds(106, 598, 118, 16);
	      getContentPane().add(lblNewLabel_5);
	        
	        JLabel lblNewLabel_6 = new JLabel("RemainingMan");
	        lblNewLabel_6.setBounds(135, 768, 118, 16);
	       getContentPane().add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_7 = new JLabel("RemainingMachine");
	        lblNewLabel_7.setBounds(135, 806, 118, 16);
	      getContentPane().add(lblNewLabel_7);
	      
	      JButton btnSaveData = new JButton("SAVE DATA");
	      btnSaveData.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      		
	      		try
				{
				String query ="select * from AdminData";	
					PreparedStatement pst=conn.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
		     		{
						PreparedStatement pstdel=conn.prepareStatement("delete from AdminData where Id='"+rs.getInt("Id")+"'");
						pstdel.execute();
		     			//rs.deleteRow();
						pstdel.close();
		     		}
					
					rs.close();
					pst.close();
					boolean isit=false;
					String[] q=new String[8];
					int[] ew=new int[8];
					int row = table.getRowCount();
					int column = table.getColumnCount();
					for (int j = 0; j  < row; j++) {
						
						String query1 ="insert into AdminData (Id,Date,ManPower,MachinePower,CommittedMan,CommittedMachine,RemainingMan,RemainingMachine) values(?,?,?,?,?,?,?,?)";	
						PreparedStatement pst1=conn.prepareStatement(query1);
					
						
					    for (int i = 0; i  < column; i++) {
					    
							q[i]= (String) table.getValueAt(j,i);
							//ew[i]=Integer.parseInt(q[i]);
					     }
					    pst1.setString(1, q[0]);
					    pst1.setString(2, q[1]);
					    pst1.setString(3, q[2]);
					    pst1.setString(4, q[3]);
					    pst1.setString(5, q[4]);
					    pst1.setString(6, q[5]);
					  //  pst1.setInt(7, ew[6]);
					  //  pst1.setInt(8, ew[7]);
					    pst1.execute();
					    pst1.close();
					
					}
					
				//	pst1.close();
				
			if(isit){
				
				JOptionPane.showMessageDialog(null, "DATA SAVED");
			}
	      		
	     	
	      		
				}
	      		
	      		catch(Exception e)
	      		{
	      			
	      			JOptionPane.showMessageDialog(null, "Error");
	      			
	      		}
	      	}
	      });
	      btnSaveData.setBounds(419, 553, 100, 23);
	      getContentPane().add(btnSaveData);
	        
	        // create an array of objects to set the row data
	        Object[] row = new Object[8];
	        
	        // button add row
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                row[0] = textId.getText();
	                row[1] = textFname.getText();
	                row[2] = textLname.getText();
	                row[3] = textAge.getText();
	                row[4] = textField.getText();
	                row[5] = textField_1.getText();
	                row[6] = textField_2.getText();
	                row[7] = textField_3.getText();
	                
	                textId.setText(null);;
	                textFname.setText(null);
	                textLname.setText(null);
	                textAge.setText(null);
	                textField.setText(null);
	                textField_1.setText(null);
	                textField_2.setText(null);
	                textField_3.setText(null);
	                
	                // add row to the model
	                model.addRow(row);
	            }
	        });
	        
	        // get selected row data From table to textfields 
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	            textId.setText(model.getValueAt(i, 0).toString());
	            textFname.setText(model.getValueAt(i, 1).toString());
	            textLname.setText(model.getValueAt(i, 2).toString());
	            textAge.setText(model.getValueAt(i, 3).toString());
	            textField.setText(model.getValueAt(i, 4).toString());
	            textField_1.setText(model.getValueAt(i, 5).toString());
	            textField_2.setText(model.getValueAt(i, 6).toString());
	            textField_3.setText(model.getValueAt(i, 7).toString());
	       
	        }
	        });
	        
	        // button update row
	        btnUpdate.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(textId.getText(), i, 0);
	                   model.setValueAt(textFname.getText(), i, 1);
	                   model.setValueAt(textLname.getText(), i, 2);
	                   model.setValueAt(textAge.getText(), i, 3);
	                   model.setValueAt(textField.getText(), i, 4);
	                   model.setValueAt(textField_1.getText(), i, 5);
	                   model.setValueAt(textField_2.getText(), i, 6);
	                   model.setValueAt(textField_3.getText(), i, 7);
	                   
	                }
	                else{
	                    System.out.println("Update Error");
	                }
	            }
	        });
	        
	        setSize(1108,885);
	       setLocationRelativeTo(null);
	       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     
        
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programminglang pg = new Programminglang();
					pg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}