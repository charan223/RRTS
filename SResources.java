import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SResources extends JFrame {

	private JPanel contentPane;
	private JSpinner spinner,spinner_1,spinner_2;
	private int ManPower;
	private int MachinePower;
	private int RawMaterial;
	private boolean isscheduled;
	private Date DateofRepair;

	
	
	public int getmanp(){
		
		return ManPower;
	}
	
public int getmachp(){
		
		return MachinePower;
	}
	
public int getrawmat(){
	
	return RawMaterial;
}

	
	
	
	public JSpinner getmanpspin(){
		
		return spinner;
		
	}
	

	public JSpinner getmachpspin(){
		
		return spinner_2;	
	}


	public JSpinner getrawmspin(){
	
	return spinner_1;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SResources frame = new SResources();
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
	public SResources() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ManPower");
		lblNewLabel.setBounds(34, 26, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MachinePower");
		lblNewLabel_1.setBounds(34, 66, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RawMaterials");
		lblNewLabel_2.setBounds(34, 108, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		spinner = new JSpinner();
		spinner.setBounds(125, 23, 55, 29);
		contentPane.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(125, 101, 55, 29);
		contentPane.add(spinner_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setBounds(125, 63, 55, 31);
		contentPane.add(spinner_2);
		
		JLabel lblRepairDate = new JLabel("Repair Date");
		lblRepairDate.setBounds(34, 167, 75, 14);
		contentPane.add(lblRepairDate);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(125, 167, 109, 14);
		contentPane.add(lblDate);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			int  i=(Integer)spinner.getValue();
			int  j=(Integer)spinner_1.getValue();
			int  k=(Integer)spinner_2.getValue();
			SComplaint.Srsc.ManPower=i;
			SComplaint.Srsc.MachinePower=j;
			SComplaint.Srsc.RawMaterial=k;
			dispose();
				
			}
		});
		btnSave.setBounds(170, 216, 89, 23);
		contentPane.add(btnSave);
	}
}
