

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
	
	
	
	public Background() {		//constructor sets background as it is
		img = getImage("/Images/ghetto.png");
		
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
		tx.scale(1.48,1.48);
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
	
}

