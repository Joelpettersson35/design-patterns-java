

import java.awt.Color;
import javax.swing.JFrame;

import controller.Controller;
import model.*;
import view.*;

public class Main {
	public static void main(String[] args) {
		/* JFrame j=new JFrame();
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
		*/
		
		/*JFrame j=new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		DrawingFacade df = new DrawingFacade(); //referens till fasaden för model-skiktet
		df.addRect(320,200,80,80,5,Color.GREEN,Color.PINK);
		df.addCircle(150,150,50,250,20,Color.BLUE, Color.CYAN);
		df.saveDrawing(); //sparar figurer
		df.addLine(3,3,50,50,1,Color.RED); //denna rad tydliggör att det är data från filen som laddas, eftersom denna linje inte kommer med
		
		df.loadDrawing(); //laddar figurerna från fil
		DrawingPanel dp = new DrawingPanel(df.getContainer()); 
		dp.setBackground(Color.WHITE); 
		
		j.add(dp);
		j.setSize(500, 500); 
		j.setVisible(true); */
		
		Controller controller = new Controller();
		controller.initialize();
		//controller.drawRect();
		
	}
}

