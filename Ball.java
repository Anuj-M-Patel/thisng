import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent implements Update {
	
	private Ellipse2D.Double ball;
	private int dx;
	private int dy;
	
	private boolean status;
	
	public Ball(int x, int y) {
		status = true;
		dx = 2;
		dy = 0;
		ball = new Ellipse2D.Double(0, 0, 4, 4);
		setSize(5, 5);
		setLocation(x, y);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D)(g);
		graphics.fill(ball);
	}
	
	public void update() {

		if((getX()+dx < 0 || getX()+dx > 400-25) && (getY()+dy < 0 || getY()+dy > 350-75)) {
			status = false;
		}
		else if(getX()+dx < 0 || getX()+dx > 400-25) {
			status = false;
		}
		else if(getY()+dy < 0 || getY()+dy > 350-75) {
			setLocation(getX()+dx, getY());
		}
		else {
			setLocation(getX()+dx, getY()+dy);
		}
		
	}
	
	public boolean getStatus() {
		return status;
	}
	
}
