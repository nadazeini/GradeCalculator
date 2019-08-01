package gradeCalc;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class TestingGrade {

	static Double totalInput;
	static Double gradeInput;
	static Double percentageInput;
	static ArrayList<GradeInfo> gradesAdded ; //allGrades
	static FinalGrade fg;
	public static void main(String[] args) {
		gradesAdded = new ArrayList<>();
		JFrame frame = new JFrame("Grading");

		final JTextField grade = new JTextField();

		grade.setHorizontalAlignment(JTextField.CENTER);
		JLabel g = new JLabel("Enter grade here");

		 final JTextField totalPossible = new JTextField();
		totalPossible.setHorizontalAlignment(JTextField.CENTER);
		JLabel tp = new JLabel("Enter total here");

		final JTextField percentage = new JTextField();
		percentage.setHorizontalAlignment(JTextField.CENTER);
		JLabel p = new JLabel("Enter percentage here");

		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(0, 2));
		frame.add(g);
		frame.add(grade);
		frame.add(tp);
		frame.add(totalPossible);
		frame.add(p);
		frame.add(percentage);

		JButton reset = new JButton("Reset");
		frame.add(reset);
		

		JButton calc = new JButton("Calculate");
		frame.add(calc);

		JButton add = new JButton("Add another grade");
		frame.add(add);
		fg  = new FinalGrade(gradesAdded);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					totalInput = Double.parseDouble(totalPossible.getText());
					gradeInput = Double.parseDouble(grade.getText());
					percentageInput = Double.parseDouble(percentage.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JPanel(), "Cannot have empty box or entry not valid", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				GradeInfo added = new GradeInfo(gradeInput,totalInput,percentageInput);
				
				gradesAdded.add(added);
				fg.setAllGrades(gradesAdded);
				
				totalPossible.setText("");
				grade.setText("");
				percentage.setText("");
				
				
			}
		});
		JLabel empty = new JLabel();
		frame.add(empty);

		JLabel finalGrade = new JLabel("Final Grade:", JLabel.RIGHT);
		frame.add(finalGrade);

		final JLabel result = new JLabel();
		result.setHorizontalAlignment(JLabel.CENTER);
		result.setFont(new Font("Serif",Font.BOLD,30));
		result.setBorder(new LineBorder(Color.red,10));
		frame.add(result);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				totalPossible.setText("");
				grade.setText("");
				percentage.setText("");
				result.setText("");
				gradesAdded.clear();
				fg.setAllGrades(gradesAdded);
			}
		});
		calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					totalInput = Double.parseDouble(totalPossible.getText());
					gradeInput = Double.parseDouble(grade.getText());
					percentageInput = Double.parseDouble(percentage.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JPanel(), "Cannot have empty box or entry not valid", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				GradeInfo gradeObj = new GradeInfo(gradeInput, totalInput, percentageInput);
				gradesAdded.add(gradeObj);
				fg.setAllGrades(gradesAdded);
			for(GradeInfo g : gradesAdded ) {
				System.out.println(g.toString());
			}
				result.setText(Double.toString(fg.calcFinalGrade()) + " %");
			}
		});

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
