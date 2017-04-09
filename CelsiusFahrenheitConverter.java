package assignment;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CelsiusFahrenheitConverter extends BaseFrame {
	private JButton convertButton;
	private JTextField convertTextField;
	private JLabel convertLabel;

	@Override
	public void createComponents() {
		convertButton = new JButton("CONVERT");
		convertTextField = new JTextField(30);
		convertLabel = new JLabel("Please input a number and a blank, then 'Celsius' or 'Fahrenheit'", JLabel.RIGHT);
	}

	@Override
	public void addComponents() {
		Container con = getContentPane();
		con.add(convertButton);
		con.add(convertTextField);
		con.add(convertLabel);
	}

	@Override
	public void createLayout() {
		Container con = this.getContentPane();
		FlowLayout fl = new FlowLayout();
		con.setLayout(fl);
	}

	class ConvertBehavior implements ActionListener {
		public void convert(JTextField tf) {
			String x = tf.getText();
			Integer x2 = 0;
			if (x.indexOf("Celsius") > 0) {
				x2 = Integer.parseInt(x.split(" ")[0]);
				int y = x2 * 9 / 5 + 32;
				String y2 = Integer.toString(y) + " Fahrenheit";
				tf.setText(y2);
			}
			else if (x.indexOf("Fahrenheit") > 0) {
				x2 = Integer.parseInt(x.split(" ")[0]);
				int y = (x2 - 32) * 5 / 9;
				String y2 = Integer.toString(y) + " Celsius";
				tf.setText(y2);
				
			}
			else  if (x.indexOf("Celsius") == -1 || x.indexOf("Fahrenheit") == -1){
				convertLabel.setText("The input must contain 'Celsius' or 'Fahrenheit'");
			}
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			convert(convertTextField);
		}
	}


	@Override
	public void addListeners() {
		ConvertBehavior behavior = new ConvertBehavior();
		convertButton.addActionListener((ActionListener) behavior);


	}

	public static void main(String[] args) {
		new CelsiusFahrenheitConverter();

	}

}
