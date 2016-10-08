import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SClerk extends JFrame {

	private JPanel contentPane;
	private JLabel lblName,lblCode;
	
	
	private String Name;
	private int Branch;


	/**
	 * 
	 * @param branch
	 */
	
	
	
	
	public JLabel getnamelbl(){
		
		return lblName;
	}
	
	
public JLabel getcodelbl(){
	
	return lblCode;
}
	
	
	
	public void setName(String n){
		
		Name=n;
		
	}
	public String getName(){
		
		return Name;
		
	}
	
	public void setBranch(int branch) {
		
		Branch=branch;
		
	}
	public int getBranch(){
		
		return Branch;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SClerk frame = new SClerk();
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
	public SClerk() {
		setTitle("ClerkName");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegisterComplaint = new JButton("Register Complaint");
		btnRegisterComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SComplaint cp=new SComplaint();
				cp.setVisible(true);
				
			}
		});
		btnRegisterComplaint.setBounds(27, 189, 140, 39);
		contentPane.add(btnRegisterComplaint);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(27, 29, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblName = new JLabel("hshdbs");
		lblName.setBounds(121, 26, 293, 21);
		contentPane.add(lblName);
		
		JLabel lblBranchCode1 = new JLabel("Branch Code");
		lblBranchCode1.setBounds(27, 82, 66, 14);
		contentPane.add(lblBranchCode1);
		
		lblCode = new JLabel("Code");
		lblCode.setBounds(121, 79, 299, 21);
		contentPane.add(lblCode);
	}

}
