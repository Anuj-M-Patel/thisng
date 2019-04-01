import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Window extends JFrame implements ActionListener {

	ArrayList<Update> components = new ArrayList<Update>();
	
	public Window() {
		setTitle("Walking Man");
		setLayout(null);
		setBounds(100, 100, 400, 350);
		
		Man man = new Man();
		add(man);
		components.add(man);
			
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent key) {

				if (key.getKeyCode() == KeyEvent.VK_W) {
					//man.setLocation((int)(man.getLocation().getX()), (int)(man.getLocation().getY()-1));
					man.moveUp();
				}
				else if (key.getKeyCode() == KeyEvent.VK_A) {
					//man.setLocation((int)(man.getLocation().getX()-1), (int)(man.getLocation().getY()));
					man.moveLeft();
				}
				else if (key.getKeyCode() == KeyEvent.VK_S) {
					//man.setLocation((int)(man.getLocation().getX()), (int)(man.getLocation().getY()+1));
					man.moveDown();
				}
				else if (key.getKeyCode() == KeyEvent.VK_D) {
					//man.setLocation((int)(man.getLocation().getX()+1), (int)(man.getLocation().getY()));
					man.moveRight();
				}
				else if (key.getKeyCode() == KeyEvent.VK_SPACE) {
					Ball ball = new Ball(man.getX(), man.getY());
					components.add(ball);
					add(ball);
				}
				
				repaint();
				
			}

			@Override
			public void keyReleased(KeyEvent key) {
				if (key.getKeyCode() == KeyEvent.VK_W) {
					man.stopVertical();
				}
				else if (key.getKeyCode() == KeyEvent.VK_A) {
					man.stopHorizontal();
				}
				else if (key.getKeyCode() == KeyEvent.VK_S) {
					man.stopVertical();
				}
				else if (key.getKeyCode() == KeyEvent.VK_D) {
					man.stopHorizontal();
				}
				else if (key.getKeyCode() == KeyEvent.VK_SPACE) {
					
				}
				
				repaint();
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		
		});
		
		Timer timer = new Timer(10, this);
		timer.start();
		
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public static void main(String[] args) {

		new Window();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < components.size(); i++) {
			components.get(i).update();
			if (components.get(i).getStatus() == false) {
				remove(components.get(i));
				components.remove(components.get(i));
			}
		}
	}

}
