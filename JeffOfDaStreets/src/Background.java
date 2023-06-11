

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class Background {
	
	private Image img;
	private int x,y;
	private AffineTransform tx;
	private boolean pummel = false;
	private int pummelTimer = 0;
	private boolean startScreen = true;
	private int startScreenDuration = 0;
	private boolean changeScreen = false;
	
	
	
	public Background() {		//constructor sets background as it is
		img = getImage("/Images/startScreen.gif");
		
		x = 0;
		y = 0;
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
		tx.scale(1.48,1.43);
		
		pummel();
		startScreen();
		
		if(pummelTimer > 0 && pummelTimer < 5) {
			x = 50;
		}
		if(pummelTimer > 5 && pummelTimer < 10) {
			x = -50;
		}
		if(pummelTimer == 0) {
			x = 0;
		}
		if(startScreenDuration > 400) {
			changePicture("/Images/playScreen.png");
			tx.scale(0.165,0.285);
		}
		if(changeScreen == true) {
			changePicture("/Images/background.gif");
			tx.scale(0.0822,0.145);
		}
	}
	
	public void startScreen() {
		startScreenDuration++;
		//System.out.println(startScreenDuration);
	}
	public void changeScreen() {
		changeScreen = true;
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(9,5);
	}
	private Image getImage(String path) {
		 Image tempImage = null;
		 try {
			 URL imageURL = Background.class.getResource(path);
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
	public void pummel() {
		if(pummel == true) {
			pummelTimer++;
		}
		if(pummelTimer > 20) {
			pummel = false;
			pummelTimer = 0;
		}
	}
	public void setPummel(boolean newPummel) {
		pummel = newPummel;
	}
	public int getDuration() {
		return startScreenDuration;
	}
	
}

