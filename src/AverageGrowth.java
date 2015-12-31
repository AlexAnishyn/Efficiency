/*  
 *  Efficiency.
 *  Listener from calculates average annual growth.
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
import javax.swing.JScrollPane;

//  Create Listener from calculates average annual growth

public class AverageGrowth {
	
	/* 
	 *  Prefix 'helper' means create frame for the user 
	 *  selecting the required year number for analysis.
	 *  
	 *  Prefix 'main' means create frame for calculation of the indicator.
	 *  
	 *  Block 'base_year' in the names of variables (classes 'JLabel' and 
	 *  'JTextField') means data base year.
	 *  
	 *  Block 'past_year' in the names of variables (classes 'JLabel' and 
	 *  'JTextField') means data of the previous year from the base year
	 */ 
	JFrame helper_frame, main_frame;
	JPanel helper_panel, main_panel;
	JScrollPane scroll;
	JButton helper_button, main_button_calc, main_button_clean;
	JLabel  helper_label, main_label_base_year, main_label_past_year; 
	JTextField helper_text; 
	
	static JLabel main_label_result;
	static JTextField [] main_text_base_year = new JTextField [20]; 
	static JTextField [] main_text_past_year = new JTextField [20];
		
	static int years_count;
			
	public AverageGrowth() {
		
		helper_frame = new JFrame();
		helper_panel = new JPanel();
		
		helper_button = new JButton("OK");
		helper_text = new JTextField(10);
		helper_label = new JLabel("Please enter how much years you want analyse: ");
		
		helper_panel.add(helper_label);
		helper_panel.add(helper_button);
		helper_panel.add(helper_text);
	
		helper_text.setHorizontalAlignment(JTextField.CENTER);
		
		helper_frame.add(helper_panel);
		helper_frame.setVisible(true);
		helper_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		helper_frame.setSize(400, 100);
		helper_frame.setResizable(false);
		helper_frame.setLocationRelativeTo(null);
		helper_frame.setTitle("Average annual growth (years)");
	
		helper_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				try {
					main_panel = new JPanel();
					
					//  Replaced 'main_panel' in 'scroll'
					
					scroll = new JScrollPane(main_panel);
					scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);    
			        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
			        
			        // Establish the layout using class WrapLayout
			        
			        main_panel.setLayout(new WrapLayout());	
					
					main_label_result = new JLabel();
					
					main_button_calc = new JButton("Count UP");
					main_button_clean = new JButton("Clean ALL");
									
					main_panel.add(main_button_calc);
					main_panel.add(main_button_clean);
														
					years_count = Integer.parseInt(helper_text.getText());
					/*
					 *  According to 'years_count' created a custom number of 
					 *  fields JLabel and JTextfield in main frame. See cycle 'for'
					 */
					
					for (int i = 0; i<=years_count-1; i++) {
						/*
						 *  Save variable 'i' in final variable 'j' for use the 
						 *  passed arguments in 'main_button_clean.addActionListener'
						 */
						
						final int j = i; 
						
						main_label_base_year = new JLabel ("Please enter electricity production from RES for "+(i+1)+"  year: ");
						main_text_base_year [i] = new JTextField (12);
						main_label_past_year = new JLabel ("Please enter electricity production from RES from past year of the "+(i+1)+ " year : ");
						main_text_past_year [i] = new JTextField (12);
						
						main_text_base_year[i].setHorizontalAlignment(JTextField.CENTER);
						main_text_past_year[i].setHorizontalAlignment(JTextField.CENTER);
						
						main_panel.add(main_label_base_year);
						main_panel.add(main_text_base_year[i]);
						main_panel.add(main_label_past_year);
						main_panel.add(main_text_past_year[i]);
						
						//  Create a listener for button to clean the panel of user data
						
						main_button_clean.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								main_text_base_year[j].setText(null);
								main_text_past_year[j].setText(null);
								main_label_result.setText(null);
							}
						});
					}
					
						main_button_calc.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								//  Calling method of calculating the average annual growth
								
								CalculationOfIndicators b = new CalculationOfIndicators();
								b.CalcAverageGrowth(); 
							}
						});
						
					main_panel.add(main_label_result);
					
					main_frame = new JFrame();
					
					main_frame.add(scroll);
					main_frame.setVisible(true);
					main_frame.setResizable(false);
					main_frame.setLocationRelativeTo(null);
					main_frame.setTitle("Average annual growth");
					main_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					main_frame.setSize(450, 280); 
				
				} catch (Exception ex) {JOptionPane.showMessageDialog (null, "Enter in the field number");}
			}
		});
	}
}