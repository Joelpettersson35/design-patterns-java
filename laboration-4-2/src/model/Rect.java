package model;

import java.awt.Color;
import java.awt.Graphics;

import view.DrawingUtilInterface;




public class Rect extends DrawingShape {

	
	public void draw(Graphics g) {
		di.drawRect(this, g);
	}
	
	@Override
	public DrawingShape handle(int x, int y) {
		if(x >= x1 && x <= x1 + width && y >= y1 && y <= y1 + height) {
			System.out.println("träff");
			return this;
		}
		return null;
	}
	
	public Rect(DrawingUtilInterface di, int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
		super(di);
		setX1(x1);
		setWidth(w);
		setY1(y1);
		setHeight(h);
		setLineWidth(width);
		setLineColor(lineColor);
		setAreaColor(area);
		
	}

}
