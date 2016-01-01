/*  
 *  Efficiency.
 *  Calculations of indicators.
 *  :copyright: 2016 by Alexander Anishyn.
 *  :license: GPL, see LICENSE for more details.
 */
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;

 /**
 * This class contains the calculations of indicators:
 * efficiency of regulatory policy, 
 * average annual growth, 
 * absolute annual increase
 */
public class CalculationOfIndicators{
	
	/*  
	 *  Variable 'year_2020' retains overall production 
	 *  potential of RES technologies by 2020.
	 *  
	 *  Variable 'count' retains of each indicator is calculating:
	 *  efficiency of regulatory policy, 
	 *  average annual growth, 
	 *  absolute annual increase
	 */
	double count = 0, base_year, past_year, year_2020;
	
	/*  
	 *  Set text results through 'label_resul' for 
	 *  efficiency of regulatory policy and
	 *  through 'main_label_result' for 
	 *  average annual growth, absolute annual increase 
	 */
	String text_result; 
	
	 /**  
	 * Create method for calculation efficiency of regulatory policy 
	 */
	public void CalcPolicyEfficiency() {
		
		try {
			
			base_year = Double.parseDouble(PolicyEfficiency.text_base_year.getText());
			past_year = Double.parseDouble(PolicyEfficiency.text_past_year.getText());
			year_2020 = Double.parseDouble(PolicyEfficiency.text_potential_2020.getText());
			
			// Calculation of efficiency of regulatory policy
			
			count = (base_year - past_year) / 
					(year_2020 - past_year); 
			
			text_result = "Your overall production potential of RES technologies by 2020: " + 
					new BigDecimal(count).setScale(3, RoundingMode.HALF_UP).doubleValue();
			
			PolicyEfficiency.label_result.setText(text_result); 	
			
		} catch (Exception ex) {JOptionPane.showMessageDialog (null, "Enter in the field number");}
	}
	
	 /** 
	 * Create method for calculation average annual growth
	 */
	public void CalcAverageGrowth() {

		try {
			
			/*  
			 *  Put the indicator is calculated in the cycle to 
			 *  read and count each argument passed user 
			 *  'AverageGrowth.main_text_base_year[r]' and 'AverageGrowth.main_text_past_year[r]' 
			 */
			for (int i = 0; i<=AverageGrowth.years_count-1; i++) {
				
				base_year = Double.parseDouble(AverageGrowth.main_text_base_year[i].getText());
				past_year = Double.parseDouble(AverageGrowth.main_text_past_year[i].getText());
				
				// Calculation of average annual growth
				
				count = count + ( (base_year / past_year) - 1 ) / 
						AverageGrowth.years_count; 
			}
			
			text_result = "Your average annual growth for the all years: " + 
					new BigDecimal (count).setScale (3, RoundingMode.HALF_UP).doubleValue() + "%";
			
			AverageGrowth.main_label_result.setText(text_result);
			
		} catch (Exception ex) {JOptionPane.showMessageDialog (null, "Enter in the field number");}
	}
	
	 /**
	 * Create method for calculation absolute annual increase
	 */
	public void CalcAbsoluteIncrease() {
		
		try {
			
			/*  
			 *  Put the indicator is calculated in the cycle to 
			 *  read and count each argument passed user 
			 *  'AbsoluteIncrease.main_text_base_year[r]' and 'AbsoluteIncrease.main_text_past_year[r]' 
			 */
			for (int i = 0; i<=AbsoluteIncrease.years_count-1; i++) {
				
				base_year = Double.parseDouble(AbsoluteIncrease.main_text_base_year[i].getText());
				past_year = Double.parseDouble(AbsoluteIncrease.main_text_past_year[i].getText());
				
				//  Calculation of absolute annual increase
				
				count = count + ( (base_year - past_year) / 2) / 
						AbsoluteIncrease.years_count; 
			}
			
			text_result = "Your absolute annual increase for the all years: " + 
					new BigDecimal (count).setScale (3, RoundingMode.HALF_UP).doubleValue() + "%";
			
			AbsoluteIncrease.main_label_result.setText(text_result);
			
		} catch (Exception ex) {JOptionPane.showMessageDialog (null, "Enter in the field number");}
	}
}