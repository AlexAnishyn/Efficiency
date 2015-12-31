/*  
 *  Efficiency.
 *  Economics indicators in energy sector, and efficiency 
 *  state policy in renewable energy sources (RES)
 *  :copyright: 2016 by Alexander Anishyn.
 *  :license: GPL, see LICENSE for more details.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

/*  
 *  This program calculates economics indicators in energy sector,
 *  and efficiency state policy in renewable energy sources (RES)
 */
@SuppressWarnings("serial")
public class IndicatorsOfEfficiency extends JFrame {
				 
	public IndicatorsOfEfficiency () {
		
		JFrame  frame;
		JPanel  panel;
		JButton button_absolute_increase, button_average_growth, button_policy_efficiency;
		JLabel  content_absolute_increase, content_average_growth, content_policy_efficiency;
		
		frame = new JFrame();
		panel = new JPanel();
		
		/*  
		 *  Create a button to calculate absolute annual increase,
		 *  average annual growth and efficiency of regulatory policy in RES sector
		 */ 
		button_absolute_increase = new JButton("Absolute Annual Increase"); 
		button_average_growth = new JButton("Average Annual Growth"); 
		button_policy_efficiency = new JButton("Efficiency of Regulatory Policy"); 
		
		content_absolute_increase = new JLabel();
		content_average_growth = new JLabel();
		content_policy_efficiency = new JLabel();
			
		//  Write the text for the 'button_absolute_increase' and placed in the variable 'content_absolute_increase'
		
		String text_absolute_increase = "<html><h2>Absolute Annual Increase</h2>" +
                "<font face=’verdana’ size = 3>" +
                " This indicator reflects the extent to pre-defined targets at the national level for a <br>" +
                " certain period of time. This allows to evaluate cinsistency between agreed targets<br>" +
                " and measures to achieve them.";
		content_absolute_increase.setText(text_absolute_increase);
		
		//  Write the text for the 'button_average_growth' and placed in the variable 'content_average_growth'
		
		String text_average_growth = "<html><central><h2>Average Annual Growth</h2></central>" +
                "<font face=’verdana’ size = 3>" +
                " This indicator can determine the absolute increase additional capacity or generation<br>" +
                " for a certain period of time. This figure is the best of all, reflects the development<br>" +
                " impact of RES in countries with high levels industry development.";
 		content_average_growth.setText(text_average_growth);
		
 		//  Write the text for the 'button_policy_efficiency' and placed in the variable 'content_policy_efficiency'
 		
		String text_policy_efficiency = "<html><central><h2>Efficiency of Regulatory Policy</h2></central>" +
                "<font face=’verdana’ size = 3>" +
                " This indicator reflects annual growth rate of additional capacity or generation<br>" +
                " in countries with low levels industry development. Using this indicator allows<br>" +
                " to objectively assess the level of state policy from stimulating development RES,<br>"
                + "and compare it to other countries.";
		content_policy_efficiency.setText(text_policy_efficiency);
		
		panel.add(content_absolute_increase);
		panel.add(button_absolute_increase);
		panel.add(content_average_growth);
		panel.add(button_average_growth);
		panel.add(content_policy_efficiency);
		panel.add(button_policy_efficiency);
		
		frame.add(panel);		
		frame.setSize(600, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Indicators of Evaluation Efficiency of Regulatory Policy in RES");
		
		button_absolute_increase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//  Absolute annual increase
				
				new AbsoluteIncrease();
			}
		});
	
		button_average_growth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//  Average annual growth
				
				new AverageGrowth();
			}
		});
		
		button_policy_efficiency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				//  The efficiency of regulatory policy
				
				new PolicyEfficiency();
			}
		});
	}
	
	public static void main(String[]args) {
		
		new IndicatorsOfEfficiency();
	}
}