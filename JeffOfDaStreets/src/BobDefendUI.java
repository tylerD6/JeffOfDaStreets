import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class BobDefendUI {

	private Image img;
	private double x,y;
	private AffineTransform tx;
	private boolean ready = true;
	private int duration = 0;
	private int blockCooldown = 0;
	
	
	
	
	public BobDefendUI() {		//constructor sets background as it is
		img = getImage("/Images/defendAbilityReady.png");
		
		x = 980;
		y = 643;
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
		tx.scale(1,1);
		
		if(ready == false) {
			changePicture("/Images/defendAbilityUsed.png");
			tx.scale(0.18,0.3);
			//System.out.println("no");
		}else {
		
			changePicture("/Images/defendAbilityReady.png");
			tx.scale(0.18,0.3);
			//System.out.println("correct");
		}
		if(duration > 0) {
			duration++;
			System.out.println(duration);
		}
		if(duration > 40) { //DURATION OF BLOCK
			duration = 0;
			blockCooldown++;
		}
		if(blockCooldown > 0) {
			blockCooldown++;
			
		}
		if(blockCooldown > 360) { //COOLDOWN OF BLOCK
			blockCooldown = 0;
			ready = true;
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
			 URL imageURL = BobDefendUI.class.getResource(path);
			 tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return tempImage;
	 }
	public double getX() {
		return x;
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
	public int getBlockCooldown() {
		return blockCooldown;
	}
	public void setReady(boolean newReady) {
		ready = newReady;
	}
	public void setDuration(int newDuration) {
		duration = newDuration;
	}
}
