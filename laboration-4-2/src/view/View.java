package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import controller.Controller;
import model.DrawingComposite;
import model.DrawingContainer;

public class View {
	
	public Controller controller;
	
	public DrawingContainer dc;
	
	public DrawingPanel dp;
	
	public InputPanel ip;
	
	private JFrame frame;
	
	public View(Controller c) {
		this.controller = c;
	}
	
	public void runUI() {
		frame = new JFrame("Drawing tool 2000");
		frame.setLayout(new BorderLayout());
		
		frame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        controller.closeApp();
		    }
		});
		
		ip = new InputPanel(this);
		dp = new DrawingPanel(dc, this);
		dp.setBackground(Color.WHITE);
		
		frame.add(ip, BorderLayout.NORTH);
		frame.add(dp, BorderLayout.CENTER);
		frame.setSize(1500, 900);
		frame.setVisible(true);
		
	}
	
	public void setContainer(DrawingContainer dc) {
		this.dc = dc;
	}
	
	public void repaint() {
		dp.repaint();
	}

	public void facilitateClick(int x, int y) {
		controller.handlePress(x, y);
	}
	
	public void addCircleFromUI(int x1, int y1, int width, int height, int lineWidth, Color lineColor, Color areaColor) {
		controller.addCircle(x1, y1, width, height, lineWidth, lineColor, areaColor);
	}
	
	public void addRectFromUI(int x1, int y1, int width, int height, int lineWidth, Color lineColor, Color areaColor) {
		controller.addRect(x1, y1, width, height, lineWidth, lineColor, areaColor);
	}
	
	public void addLineFromUI(int x1, int y1, int width, int height, int lineWidth, Color areaColor) {
		controller.addLine(x1, y1, width, height, lineWidth, areaColor);
	}
	
	public void handlePress(int x1, int y1) {
		controller.handlePress(x1, y1);
	}
	
	public void handleDrag(int x1, int y1) {
		controller.handleDrag(x1, y1);
	}
	
	public void remove() {
		controller.removeShape();
	}
}
