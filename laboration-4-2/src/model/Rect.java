package model;

import java.awt.Color;
import java.awt.Graphics;

import view.DrawingUtilInterface;




public class Rect extends DrawingShape {

	
	public void draw(Graphics g) {
		di.drawRect(this, g);
	}
	
	@Override
	public DrawingShape handlePress(int x, int y) {
		if(x >= x1 && x <= x1 + width && y >= y1 && y <= y1 + height) {
			//System.out.println("träff");
			return this;
		}
		return null;
	}
	
	
	@Override
	public String checkCorners(int x, int y) {
		
		if(x >= x1 && x <= x1 + 5 && y >= y1 && y <= y1 + 5) {
			return "topLeft";
		}
		
		else if(x >= x1 && x <= x1 + 5 && y <= y1 + height && y >= y1 + height - 5) {
			return "bottomLeft";
		}
		
		else if(x <= x1 + width && x >= x1 + width - 5 && y >= y1 && y <= y1 + 5) {
			return "topRight";
		}
		
		else if(x <= x1 + width && x >= x1 + width - 5 && y <= y1 + height && y >= y1 + height - 5) {
			return "bottomRight";
		}
		
		else {
			return "";
		}
		
	}
	
	@Override
	public Boolean move(int x, int y) {
		setX1(x);
		setY1(y);
		return true;
	}
	
	@Override
	public Boolean resize(int x, int y, String corner) {
		int anchorX;
		int anchorY;
		
		switch (corner) {
		
		case "topLeft":
			anchorX = x1 + width;
			anchorY = y1 + height;
			
			x1 = x;
			y1 = y;
			width = anchorX - x;
			height = anchorY - y;
			break;
		case "bottomLeft":
			anchorX = x1 + width;
			anchorY = y1;
			
			x1 = x;
			width = anchorX - x;
			height = y - anchorY;
			break;
		case "topRight":
			anchorX = x1;
			anchorY = y1 + height;
			
			y1 = y;
			width = x - anchorX;
			height = anchorY - y;
			break;
		case "bottomRight":
			anchorX = x1;
			anchorY = y1;
			
			width = x - anchorX;
			height = y - anchorY;
			break;
		default:
			return false;
		}
		
		if(width < 20) {
			width = 20;
		}
		
		if(height < 20) {
			height = 20;
		}
		
		return true;
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
