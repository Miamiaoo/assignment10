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
	private JLabel desLabel1;
	private JLabel desLabel2;
	private JLabel desLabel3;
	private JButton calculateButton;
	private JTextField numberTextField1;
	private JTextField numberTextField2;
	private JTextField numberTextField3;
	private ButtonGroup buttonGroup;
	private JRadioButton addButton;
	private JRadioButton minusButton;
	private JRadioButton multipleButton;
	private JRadioButton divideButton;

	@Override
	public void createComponents() {

		desLabel = new JLabel("Please input two numbers then click a calculate button", JLabel.CENTER);
		desLabel1 = new JLabel("Please input the first number", JLabel.CENTER);
		desLabel2 = new JLabel("Please input the second number", JLabel.CENTER);
		desLabel3 = new JLabel("The result will show here", JLabel.CENTER);
		calculateButton = new JButton("CALCULATE");
		numberTextField1 = new JTextField(30);
		numberTextField2 = new JTextField(30);
		numberTextField3 = new JTextField(30);
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
		con.add(desLabel1);
		con.add(numberTextField1);
		con.add(desLabel2);
		con.add(numberTextField2);	
		con.add(addButton);
		con.add(minusButton);
		con.add(multipleButton);
		con.add(divideButton);
		con.add(calculateButton);
		con.add(desLabel3);
		con.add(numberTextField3);
	}

	@Override
	public void createLayout() {
		Container con = this.getContentPane();
		FlowLayout fl = new FlowLayout();
		con.setLayout(fl);
	}

	class CalculateBehavior implements ActionListener {
		public void calculate(JTextField numberTextField3) {

			int a;
			if (numberTextField1.getText().length() == 0)
				a = 0;
			else {
				a = Integer.parseInt(numberTextField1.getText());
			}

			int b;
			if (numberTextField2.getText().length() == 0)
				b = 0;
			else {
				b = Integer.parseInt(numberTextField2.getText());
			}

			if (addButton.isSelected()) {
				int c = a + b;
				String c2 = Integer.toString(c);
				numberTextField3.setText(c2);
			} else if (minusButton.isSelected()) {
				int c = a - b;
				String c2 = Integer.toString(c);
				numberTextField3.setText(c2);
			} else if (multipleButton.isSelected()) {
				int c = a * b;
				String c2 = Integer.toString(c);
				numberTextField3.setText(c2);
			} else if (divideButton.isSelected()) {
				int c = a / b;
				String c2 = Integer.toString(c);
				numberTextField3.setText(c2);
			}

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			calculate(numberTextField3);

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
