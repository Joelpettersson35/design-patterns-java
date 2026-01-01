package model;


import java.awt.Color;
import java.awt.Graphics;

import view.DrawingUtilInterface;



public class Circle extends DrawingShape {
	
	
	public void draw(Graphics g) {
		di.drawCircle(this,g);
	}
	
	@Override
	public DrawingShape handlePress(int x, int y) {
	    int centerX = x1 + width / 2;
	    int centerY = y1 + height / 2;
	    int radius  = width / 2;

	    double dx = x - centerX;
	    double dy = y - centerY;

	    double distance = Math.hypot(dx, dy);

	    if(distance <= radius) {
	    	System.out.println("träff");
	    	return this;
	    }
	    
	    return null;
	}
	
	@Override
	public String checkCorners(int x, int y) {
		 int centerX = x1 + width / 2;
		 int centerY = y1 + height / 2;
		 int radius  = width / 2;
		 
		 double dx = x - centerX;
		 double dy = y - centerY;
		 
		 double distance = Math.hypot(dx, dy);
		 
		 if(distance >= radius - 5 && distance <= radius) { //om klicket är 5 px från kanten och centrum av cirkeln
			 return "yes"; //hade vart bättre med en boolean men metoden är tvingad till en sträng
		 }

		return "";
	} 
	
	@Override
	public Boolean move(int x, int y) {
		setX1(x);
		setY1(y);
		return true;
	}
		
	@Override
	public Boolean resize(int x, int y, String corner) {
	    int centerX = x1 + width / 2;
	    int centerY = y1 + height / 2;

	    double dx = x - centerX;
	    double dy = y - centerY;

	    int radius = (int) Math.round(Math.hypot(dx, dy));

	    radius = Math.max(radius, 5);

	    width  = radius * 2;
	    height = radius * 2;

	    x1 = centerX - radius;
	    y1 = centerY - radius;

	    return true;
	}
	
	public Circle(DrawingUtilInterface di,int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
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
