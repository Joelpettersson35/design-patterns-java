package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

public class InputPanel extends JPanel {
	
	private Controller controller;

	private JMenu menu;

	private JLabel shapeLabel;

	private JComboBox<String> shapeChooser;

	private JLabel widthLabel;

	private JTextField widthField;
	
	private JPanel controlPanel;

	private JLabel heightLabel;

	private JTextField heightField;

	private JLabel x1Label;

	private JTextField x1Field;

	private JLabel y1Label;

	private JTextField y1Field;

	private JLabel lineWidthLabel;

	private JTextField lineWidthField;
	
	private Color lineColor;
	
	private Color areaColor;
	
	private JButton lineColorBtn;
	
	private JButton areaColorBtn;
	
	private JButton addBtn;
	
	public InputPanel(Controller controller) {
		this.controller = controller;
		setLayout(new GridLayout(1, 6, 0, 5));
		shapeChooser = new JComboBox<>(new String[]{"Circle", "Rectangle", "Line"});
		x1Field = new JTextField("10", 4);
		y1Field = new JTextField("10", 4);
		widthField = new JTextField("50", 4);
		heightField = new JTextField("50", 4);
		lineWidthField = new JTextField("2", 4);
		addBtn = new JButton("Add");
		addBtn.setBackground(Color.BLUE);
		
		lineColor = Color.BLACK; //förvald färg så att den alltid har ett värde
		lineColorBtn = new JButton("Line color");

		lineColorBtn.addActionListener(e -> {
		    Color c = JColorChooser.showDialog(
		        this,
		        "Choose line color",
		        lineColor
		    );
		    if (c != null) {
		        lineColor = c;
		    }
		});
		
		areaColor = Color.BLACK; //förvald färg så att den alltid har ett värde
		areaColorBtn = new JButton("Area color");

		areaColorBtn.addActionListener(e -> {
		    Color c = JColorChooser.showDialog(
		        this,
		        "Choose area color",
		        areaColor
		    );
		    if (c != null) {
		        areaColor = c;
		    }
		});
		
		addBtn.addActionListener(e -> {
			handleAdd();
		});
		
		add(new JLabel("Shape:"));
		add(shapeChooser);
		
		add(new JLabel("width:"));
		add(widthField);
		
		add(new JLabel("height:"));
		add(heightField);
		
		add(new JLabel("X-pos:"));
		add(x1Field);
		
		add(new JLabel("Y-pos:"));
		add(y1Field);
		
		add(new JLabel("Line width:"));
		add(lineWidthField);
		
		add(new JLabel("Line color:"));
		add(lineColorBtn);
		
		add(new JLabel("Area color:"));
		add(areaColorBtn);
		
		add(addBtn);

	}
	
	public void handleAdd() {
		String choice = (String) shapeChooser.getSelectedItem();
		System.out.println(choice);
		
		try {
			
			int x1 = Integer.parseInt(x1Field.getText());
			int y1 = Integer.parseInt(y1Field.getText());
			int width = Integer.parseInt(widthField.getText());
			int height = Integer.parseInt(heightField.getText());
			int lineWidth = Integer.parseInt(lineWidthField.getText());
			
			if(choice.equals("Circle")) {
				controller.addCircle(x1, y1, width, height, lineWidth, lineColor, areaColor);
			}
			
			else if(choice.equals("Rectangle")) {
				controller.addRect(x1, y1, width, height, lineWidth, lineColor, areaColor);
			}
			
			else {
				controller.addLine(x1, y1, width, height, lineWidth, areaColor);
			}
		}
		
		catch(Exception e) {
			//CALL CONTROLLER TO SHOW ERROR WINDOW
		}
		
	}
}
