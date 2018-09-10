import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TuitionCalc extends JFrame {

	JCheckBox inState, outState, onCampus, offCampus, 
	mealPlan, international;
	JLabel majorLabel;
	JTextField major;
	
	JButton total;
	JLabel amount;
	
	private double cost = 0;;
	
	public TuitionCalc() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		inState = new JCheckBox("In-State");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		add(inState, c);
		
		outState = new JCheckBox("Out-Of-State");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		add(outState, c);
		
		onCampus = new JCheckBox("On-Campus");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		add(onCampus, c);
		
		offCampus = new JCheckBox("Off-Campus");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		add(offCampus, c);
		
		mealPlan = new JCheckBox("Meal Plan");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		add(mealPlan, c);
		
		international = new JCheckBox("International Student");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		add(international,c);
	
		
		majorLabel = new JLabel("Intended Major");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		add(majorLabel, c);
		
		major = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		add(major, c);
		
		total = new JButton("Total");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		add(total, c);
		
		amount = new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 1;
		add(amount, c);
		
		event e = new event();
		inState.addItemListener(e);
		outState.addItemListener(e);
		onCampus.addItemListener(e);
		offCampus.addItemListener(e);
		mealPlan.addItemListener(e);
		international.addItemListener(e);
		
		event2 e2 = new event2();
		total.addActionListener(e2);
		
		
		
		
			
		
	}

	
	
	public class event implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			
			if(inState.isSelected() && outState.isSelected()) {
				JOptionPane.showMessageDialog(null, "Please only check only inState or Out-of-State, don't check both");	
			}
			if(inState.isSelected()) {
				cost+=10595;
				
			 }else if(outState.isSelected()) {
				cost+=35216;	
			}
			 
			if(onCampus.isSelected() && offCampus.isSelected()) {
				JOptionPane.showMessageDialog(null, "Please check only onCampus or offCampus, don't check both");
			}else if(onCampus.isSelected()) {
				cost+=6944;
	
			}else if(offCampus.isSelected()) {
				cost+=0;		
			}
			if(mealPlan.isSelected()) {
				cost+=5004;
			}
			if(international.isSelected()) {
				cost+=250;
			}
			
			
		}
	}
	public class event2 implements ActionListener{
		public void actionPerformed(ActionEvent e2) {
			amount.setText(Double.toString(cost));
			
			
		}
	}
	
	
	public static void main(String[]args) {
		TuitionCalc gui = new TuitionCalc();
		gui.setSize(368,190);
		gui.setTitle("Cost To Attend UMD");
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	

}

