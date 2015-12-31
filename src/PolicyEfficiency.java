/*  
 *  Efficiency.
 *  Listener from calculates efficiency of regulatory policy.
 *  :copyright: 2016 by Alexander Anishyn.
 *  :license: GPL, see LICENSE for more details.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

//  Create Listener from calculates efficiency of regulatory policy

public class PolicyEfficiency {
	
	/*
	 *  Block 'base_year' in the names of variables (classes 'JLabel' and 
	 *  'JTextField') means data base year.
	 *  
	 *  Block 'past_year' in the names of variables (classes 'JLabel' and 
	 *  'JTextField') means data of the previous year from the base year.
	 *  
	 *  Block 'potential_2020' in the names of variables (classes 'JLabel' and 
	 *  'JTextField') means data of overall production potential of RES 
	 *  technologies by 2020
	 */
	JFrame  frame;
	JPanel  panel;
	JButton button_count, button_clean;
	JLabel  label_base_year, label_past_year, label_potential_2020;
	
	static JLabel label_result;
	static JTextField text_base_year, text_past_year, text_potential_2020;
		
	public PolicyEfficiency() {
		
		try {
			
			frame = new JFrame();
			panel = new JPanel();
								
			button_count = new JButton("Count UP");
			button_clean = new JButton("Clean ALL");
			
			label_base_year = new JLabel("Please enter electricity production from RES for basic year: ");
			label_past_year = new JLabel("Please enter electricity production from RES for the past year: ");
			label_potential_2020 = new JLabel("Please enter overall production potential of RES technologies by 2020: ");
			label_result = new JLabel("");
			
			text_base_year = new JTextField(10);
			text_past_year = new JTextField(10);
			text_potential_2020 = new JTextField(10);
			
			text_base_year.setHorizontalAlignment(JTextField.CENTER);
			text_past_year.setHorizontalAlignment(JTextField.CENTER);
			text_potential_2020.setHorizontalAlignment(JTextField.CENTER);
			
			panel.add(button_count);
			panel.add(button_clean);
			panel.add(label_base_year);
			panel.add(text_base_year);
			panel.add(label_past_year);
			panel.add(text_past_year);
			panel.add(label_potential_2020);
			panel.add(text_potential_2020);
			panel.add(label_result);
			frame.add(panel);
			
			button_count.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//  Calling method of calculating the efficiency of regulatory policy
					
					CalculationOfIndicators a = new CalculationOfIndicators(); 
					a.CalcPolicyEfficiency(); 

				}
			});
			
			//  Create a listener for button to clean the panel of user data
			
			button_clean.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					text_base_year.setText(null);
					text_past_year.setText(null);
					text_potential_2020.setText(null);
					label_result.setText(null);
				}
			});
			
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setSize(420, 250);
			frame.setLocationRelativeTo(null);
			frame.setTitle("Efficiency of regulatory policy");
			
		} catch (Exception ex) {JOptionPane.showMessageDialog (null, "Enter in the field number");}
	}
}