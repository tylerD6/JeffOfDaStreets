import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class BobSpittle {

	private Image img;
	private double x,y;
	private AffineTransform tx;
	private double vx, vy;
	
	
	
	public BobSpittle() {		//constructor sets background as it is
		img = getImage("/Images/bobSpittleRight.gif");
		
		x = -400;
		y = -400;
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
		
		if(vx == 10) {
			
			changePicture("/Images/bobSpittleRight.gif");
			tx.scale(0.2,0.35);
		}
		if(vx == -10) {
			
			changePicture("/Images/bobSpittleLeft.gif");
			tx.scale(0.2,0.35);
		}
		
		x+=vx;
		
        if(x > 4000 || x < -3000) {
			
			x = -500;
			y = -500;
			vx = 0;
			
		}
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
			 URL imageURL = BobSpittle.class.getResource(path);
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
    }
    public void setVy(double newVy) {
	    vy = newVy;
    }
}
