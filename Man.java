import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Man extends JComponent implements Update {

	private Ellipse2D.Double head;
	private Rectangle2D.Double torso;
	private Rectangle2D.Double leftArm;
	private Rectangle2D.Double leftLeg;
	private Rectangle2D.Double rightArm;
	private Rectangle2D.Double rightLeg;
	
	private int dx;
	private int dy;
	
	private boolean status;
	
	public Man() {
		dx = 0;
		dy = 0;
		
		status = true;
		
		head = new Ellipse2D.Double(2, 2, 10, 10);
		torso = new Rectangle2D.Double(6, 12, 2, 16);
		leftArm = new Rectangle2D.Double(4, 13, 2, 10);
		leftLeg = new Rectangle2D.Double(4, 27, 2, 10);
		rightArm = new Rectangle2D.Double(8, 13, 2, 10);
		rightLeg = new Rectangle2D.Double(8, 27, 2, 10);
			
		setSize(15, 40);
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D)(g);
		graphics.setColor(Color.RED);
		graphics.fill(head);
		graphics.fill(torso);
		graphics.fill(leftArm);
		graphics.fill(leftLeg);
		graphics.fill(rightArm);
		graphics.fill(rightLeg);
		graphics.setColor(Color.BLACK);
		graphics.draw(head);
		graphics.draw(torso);
		graphics.draw(leftArm);
		graphics.draw(leftLeg);
		graphics.draw(rightArm);
		graphics.draw(rightLeg);
		
	}

	public void update() {

		if((getX()+dx < 0 || getX()+dx > 400-25) && (getY()+dy < 0 || getY()+dy > 350-75)) {
			setLocation(getX(), getY());
		}
		else if(getX()+dx < 0 || getX()+dx > 400-25) {
			setLocation(getX(), getY()+dy);
		}
		else if(getY()+dy < 0 || getY()+dy > 350-75) {
			setLocation(getX()+dx, getY());
		}
		else {
			setLocation(getX()+dx, getY()+dy);
		}
		
	}
	
	public void moveRight() {
		dx = 2;
	}
	
	public void moveUp() {
		dy = -2;
	}
	
	public void moveLeft() {
		dx = -2;
	}
	
	public void moveDown() {
		dy = 2;
	}
	
	public void stopHorizontal() {
		dx = 0;
	}

	public void stopVertical() {
		dy = 0;
	}
	
	public boolean getStatus() {
		return status;
	}
	
}
