package controller;

import java.awt.Color;

import model.DrawingComposite;
import model.DrawingFacade;
import view.View;

public class Controller {
	
	public DrawingFacade df;
	
	public View view;
	
	public Controller() {
		df = new DrawingFacade();
		view = new View(this);
		
	}
	
	public void initialize() {
		df.loadDrawing();
		view.setContainer(df.getContainer());
		view.runUI();
	}
	
	public void addCircle(int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
		df.addCircle(x1, y1, w, h, width, lineColor, area);
		view.repaint();
	}
	
	public void addRect(int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
		df.addRect(x1, y1, w, h, width, lineColor, area);
		view.repaint();
	}
	
	public void addLine(int x1, int y1, int w, int h, int width, Color color) {
		df.addLine(x1, y1, w, h, width, color);
		view.repaint();
	}
	
	public void removeShape() {
		if(df.remove()) {
			view.repaint();
		}
	}

	public void closeApp() {
		df.saveDrawing();
		System.exit(0);
	}

	public void handlePress(int x, int y) {
		df.handlePress(x, y);
	}
	
	public void handleDrag(int x, int y) {
		if(df.handleDrag(x, y)) {
			view.repaint();
		}
			
	}

}
