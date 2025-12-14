package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import view.DrawingUtil;


//fasad för model-skiktet
public class DrawingFacade {
	
	private DrawingContainer dc;
	private DrawingUtil du;

	public DrawingFacade() {
		dc = new DrawingContainer();
		du = new DrawingUtil();
	}
	
	public DrawingComposite getContainer() {
		return dc;
	}
	
	public void addCircle(int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
		Circle circle = new Circle(du, x1, y1, w, h, width, lineColor, area);
		dc.add(circle);
	}
	
	public void addRect(int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
		Rect rect = new Rect(du, x1, y1, w, h, width, lineColor, area);
		dc.add(rect);
	}
	
	public void addLine(int x1, int y1, int x2, int y2, int width, Color color) {
		Line line = new Line(du, x1, y1, x2, y2, width, color);
		dc.add(line);
	}
	
	public void draw(Graphics g) {
		dc.draw(g);
	}
	
	public void saveDrawing() {
		try {
			FileOutputStream fos = new FileOutputStream("test.drawing");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dc);
			oos.close();
			System.out.println("Object saved to file");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadDrawing() {
		try {
			FileInputStream fis = new FileInputStream("test.drawing");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			dc = (DrawingContainer) ois.readObject();
			System.out.println("Object loaded from file");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
