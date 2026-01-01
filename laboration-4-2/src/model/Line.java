package model;


import java.awt.Color;
import java.awt.Graphics;

import view.DrawingUtilInterface;




public class Line extends DrawingShape {
	
	
	public void draw(Graphics g) {
		di.drawLine(this, g);
	}
	
	
	@Override
	public DrawingShape handlePress(int px, int py) {
	    double dx = width - x1;
	    double dy = height - y1;

	    if (dx == 0 && dy == 0) {
	        if(Math.hypot(px - x1, py - y1) <= 5) { //5 piclar tolerans
	        	System.out.println("träff");
	        	return this;
	        }
	    }

	    double t = ((px - x1) * dx + (py - y1) * dy) / (dx * dx + dy * dy);

	    if (t < 0 || t > 1) {
	        return null; //utanför linjesegmentet
	    }

	    //närmaste punkt på linjen
	    double closestX = x1 + t * dx;
	    double closestY = y1 + t * dy;

	    //avstånd från muspunkt till linjen
	    double distance = Math.hypot(px - closestX, py - closestY);

	    if(distance <= 5) { //5 pixlar tolerans
	    	System.out.println("träff");
	    	return this;
	    }
	    
	    return null;
	}
	
	@Override
	public String checkCorners(int x, int y) {

	    if (distance(x, y, getX1(), getY1()) <= 5) {
	        return "left";
	    }

	    else if (distance(x, y, getWidth(), getHeight()) <= 5) {
	        return "right";
	    }

	    return "";
	}
	
	private double distance(int x1, int y1, int width, int height) {
	    int dx = width - x1;
	    int dy = height - y1;
	    return Math.sqrt(dx * dx + dy * dy);
	}


	@Override
	public Boolean resize(int x, int y, String corner) {
		
		if(corner.equals("left")) {
			setX1(x);
			setY1(y);
			return true;
		}
		
		else if(corner.equals("right")) {
			setWidth(x);
			setHeight(y);
			return true;
		}
		
		return false;
	}
	
	@Override
	public Boolean move(int x, int y) {
		int dx = x - getX1();
	    int dy = y - getY1();
	    
	    setX1(x);
	    setY1(y);
	    
	    setWidth(getWidth() + dx);
	    setHeight(getHeight() + dy);
	    
		return true;
	}
	
	public Line(DrawingUtilInterface di, int x1, int y1, int x2, int y2, int width, Color color) {
		super(di);
		setX1(x1);
		setWidth(x2);
		setY1(y1);
		setHeight(y2);
		setLineWidth(width);
		setLineColor(color);
		setAreaColor(Color.BLACK); 
		
	}


}
