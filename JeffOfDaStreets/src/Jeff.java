import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Jeff {

	private double x, y;
	private double vx, vy;
	private Image img;
	private AffineTransform tx;
	private boolean faceRight;
	private double accelerate;
	
	public Jeff() {
		img = getImage("/Images/jeffIdleRight.gif");       //initial image and coordinates
		
		x = 200;
		y = 465; 
	
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
		
		gravity();
		x+=vx;
		
		if(y > 464) {
			vy = 0;
		}
		
	}
	
	
	public void gravity() {
		
		accelerate = 0.3;
		y+=vy;
		vy+=accelerate;
		
	}
	
	
	
	
	
	
	
	
	
	
	 private void init(double a, double b) {
			
		 tx.setToTranslation(a, b);
		 tx.scale(5,5);
	
	 }
	  
	 
	 
	 private Image getImage(String path) {
		
		 Image tempImage = null;
		
		 try {
			 URL imageURL = Jeff.class.getResource(path);
			 tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return tempImage;
	
	 }

	 
	 
	public void changePicture(String newFileName) {   // changes picture
		
		img = getImage(newFileName);
		init(x, y);
		
	
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getVx() {
		return vx;
	}
	public double getVy() {
		return vy;
	}
	public void setX(double newX) {
		x = newX;
	}
	public void setY(double newY) {
		y = newY;
	}
	public void setVx(double newVx) {
		vx = newVx;
		
		if(vx > 0) {
			faceRight = true;
			changePicture("/Images/jeffIdleRight.gif");
		}
		if(vx < 0) {
			faceRight = false;
			changePicture("/Images/jeffIdleLeft.gif");
		}
	}
	public void setVy(double newVy) {
		vy = newVy;
	}
}