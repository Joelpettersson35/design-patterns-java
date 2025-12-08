

import java.awt.Color;
import javax.swing.JFrame;

import model.*;
import view.*;

public class MinimalDraw {
	public static void main(String[] args) {
		JFrame j=new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		DrawingContainer dc=new DrawingContainer(); 
		DrawingUtil da=new DrawingUtil();	
		Line l=new Line(da,3,3,50,50,1,Color.RED);  											
		Circle c=new Circle(da,20,20,80,80,1,Color.BLUE,null);
		Circle c2=new Circle(da,150,150,50,250,20,Color.BLUE, Color.CYAN); 
		Rect r=new Rect(da,320,200,80,80,5,Color.GREEN,Color.PINK); 
		dc.add(l);   
		dc.add(c);
		dc.add(c2);
		dc.add(r);
		DrawingPanel dp = new DrawingPanel(dc); 
		dp.setBackground(Color.WHITE);  
		j.add(dp);
		j.setSize(500, 500); 
		j.setVisible(true);
		Rect r2=new Rect(da,320,200,80,80,5,Color.BLACK,null); 
		dc.add(r2);
		dc.remove(r);
		j.repaint();
	}
}

