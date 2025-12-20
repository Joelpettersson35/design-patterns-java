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
		
		ip = new InputPanel(controller);
		dp = new DrawingPanel(dc);
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

}
