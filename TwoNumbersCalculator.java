package assignment;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TwoNumbersCalculator extends BaseFrame {

	private JLabel desLabel;
	private JLabel num1Label;
	private JLabel num2Label;
	private JLabel resLabel;
	private JButton calculateButton;
	private JTextField numberTextField1;
	private JTextField numberTextField2;
	private JTextField numberTextFieldRes;
	private ButtonGroup buttonGroup;
	private JRadioButton addButton;
	private JRadioButton minusButton;
	private JRadioButton multipleButton;
	private JRadioButton divideButton;

	@Override
	public void createComponents() {

		desLabel = new JLabel("Please input two numbers then click the calculate button", JLabel.CENTER);
		num1Label = new JLabel("Please input the first number", JLabel.CENTER);
		num2Label = new JLabel("Please input the second number", JLabel.CENTER);
		resLabel = new JLabel("The result will show here", JLabel.CENTER);
		calculateButton = new JButton("CALCULATE");
		numberTextField1 = new JTextField(30);
		numberTextField2 = new JTextField(30);
		numberTextFieldRes = new JTextField(30);
		addButton = new JRadioButton("+");
		minusButton = new JRadioButton("-");
		multipleButton = new JRadioButton("*");
		divideButton = new JRadioButton("/");
		buttonGroup = new ButtonGroup();
		buttonGroup.add(addButton);
		buttonGroup.add(minusButton);
		buttonGroup.add(multipleButton);
		buttonGroup.add(divideButton);
	}

	@Override
	public void addComponents() {
		Container con = getContentPane();
		con.add(desLabel);
		con.add(num1Label);
		con.add(numberTextField1);
		con.add(num2Label);
		con.add(numberTextField2);
		con.add(addButton);
		con.add(minusButton);
		con.add(multipleButton);
		con.add(divideButton);
		con.add(calculateButton);
		con.add(resLabel);
		con.add(numberTextFieldRes);
	}

	@Override
	public void createLayout() {
		Container con = this.getContentPane();
		FlowLayout fl = new FlowLayout();
		con.setLayout(fl);
	}

	class CalculateBehavior implements ActionListener {
		public void calculate(JTextField numberTextField3) {

			double num1;
			if (numberTextField1.getText().length() == 0)
				num1 = 0;
			else {
				num1 = Double.parseDouble(numberTextField1.getText());
			}

			double num2;
			if (numberTextField2.getText().length() == 0)
				num2 = 0;
			else {
				num2 = Double.parseDouble(numberTextField2.getText());
			}

			double res = 0.0;
			String resString = "";

			if (addButton.isSelected()) {
				res = num1 + num2;
			} else if (minusButton.isSelected()) {
				res = num1 - num2;
			} else if (multipleButton.isSelected()) {
				res = num1 * num2;
			} else if (divideButton.isSelected()) {
				res = num1 / num2;
			}

			if (res == (int) res) {
				int resInt = (int) res;
				resString = Integer.toString(resInt);
			} else {
				resString = Double.toString(res);			
			}
			numberTextFieldRes.setText(resString);
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			calculate(numberTextFieldRes);

		}

	}

	@Override
	public void addListeners() {
		CalculateBehavior behavior = new CalculateBehavior();
		calculateButton.addActionListener((ActionListener) behavior);

	}

	static class AnotherBehavior implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}

	public static void main(String[] args) {
		new TwoNumbersCalculator();

	}

}
