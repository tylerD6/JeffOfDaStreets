import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class JeffBubble {

	private Image img;
	private double x,y;
	private AffineTransform tx;
	private boolean ready = true;
	private int duration = 0;
	
	
	
	
	public JeffBubble() {		//constructor sets background as it is
		img = getImage("/Images/defenseBubble.png");
		
		x = -200;
		y = -200;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	 
	
	
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);
		
	}




	private void update() {				//fits it on the screen
		tx.setToTranslation(x, y);
		tx.scale(1.5,1.5);
		
		
		
	}
	
	public void changePicture(String newFileName) {   // changes picture
		img = getImage(newFileName);
		init(x, y);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(9,5);
	}
	private Image getImage(String path) {
		 Image tempImage = null;
		 try {
			 URL imageURL = JeffAbilityUI.class.getResource(path);
			 tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return tempImage;
	 }
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public void setX(double newX) {
		x = newX;
	}
	public boolean getReady() {
		return ready;
	}
	public int getDuration() {
		return duration;
	}
	public void setReady(boolean newReady) {
		ready = newReady;
	}
	public void setY(double newY) {
		y = newY;
	}
	public void setDuration(int newDuration) {
		duration = newDuration;
	}
}
