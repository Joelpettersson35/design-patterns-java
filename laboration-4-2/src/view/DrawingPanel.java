package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import model.DrawingComposite;

// TODO: Auto-generated Javadoc
/**
 * The Class DrawingPanel. This class contains the screen estate used for drawing. In previos version of the 
 * DrawingAPI this was direct part of the DrawingAPI, but to enable serialization in this version this is
 * moved to a separate class. 
 */
public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	
	/** The DrawingComposite attribute. This should reference the DrawingComposite we want to draw on the
	 * screen estate. */
	private DrawingComposite dc;
	
	private View view;
	
	private InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	
    private ActionMap am = getActionMap();
	
	/** Gets the DrawingComposite attributte currently drawing on the screen estate. */
	public DrawingComposite getDc() {
		return dc;
	}
	/** Sets the DrawingComposite attribute. This should reference the DrawingComposite we want to draw on the
	 * screen estate. */
	public void setDc(DrawingComposite dc) {
		this.dc = dc;
	}
	/**
	 * Instantiates a new drawing panel.
	 *
	 * @param dc the DrawingComposite to draw.
	 */
	public DrawingPanel (DrawingComposite dc, View v) {
		this.dc=dc;
		this.view = v;
		addMouseListener(this);
		addMouseMotionListener(this);
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "delete");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete");

	    am.put("delete", new AbstractAction() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            view.remove();
	        }
	    });
	}
	/**
	 * Is called everytime the GUI refreshes and calls the DrawingComposites draw method passing the
	 * Graphics instance holding the drawable screen estate to it.
	 *
	 * @param g the Graphics instance holding the screen estate to draw upon.
	 */
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		dc.draw(g);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		System.out.println("click " + x + " " + y);
		view.handlePress(x, y);
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//int x = e.getX();
		//int y = e.getY();
		
		//System.out.println("release " + x + " " + y);
		//view.handleRelease(x, y);
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		//System.out.println("dragging " + x + " " + y);
		view.handleDrag(x, y);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//if(e.getKeyCode())
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
}
