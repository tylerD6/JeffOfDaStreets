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
	private int doubleJump;
	private double physLeft;
	private double physRight;
	private int iFrame;
	private int health = 100;
	private boolean dead = false;
	
	public Jeff() {
		img = getImage("/Images/jeffIdleRight.gif");       //initial image and coordinates
		faceRight = true;
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
		physicLeft();
		physicRight();
		iFrames();
		
		x+=vx;

		if(y > 464) { //the ground
			vy = 0;
			doubleJump = 2;
			y = 470;
		}
		if(x < -20) {
			x = 0;
			vx = 0;
		}
		if(x > 930) {
			x = 910;
			vx = 0;
		}
		if(y < -80) {
			y = -70;
			vy = 15;
		}
		if(health < 0) {
			health = 0;
		}
        if(health == 0) {
			
			dead = true;
			y = 900;
			vy=0;
        }
		
		if(faceRight == true && vy != 0) {
			changePicture("/Images/jeffFlyRight.png");
			tx.scale(0.3,0.3);
		}
		if(faceRight == false && vy != 0) {
			changePicture("/Images/jeffFlyLeft.png");
			tx.scale(0.3,0.3);
		}
		
		if(vx > 0 && y > 465) {
			faceRight = true;
			changePicture("/Images/jeffIdleRight.gif");
			tx.scale(0.3,0.3);
		}
		if(vx < 0 && y > 465) {
			faceRight = false;
			changePicture("/Images/jeffIdleLeft.gif");
			tx.scale(0.3,0.3);
		}
		if(iFrame > 0) {
			changePicture("/Images/jeffSquashed.gif");
			tx.scale(0.3,0.3);
		}
	}
	
	
	public void gravity() {
		accelerate = 0.3;
		y+=vy;
		vy+=accelerate;
	}
	
	public void physicLeft() {
		
		if(vx < 0 ) {
		physLeft = 0.1;
		vx+=physLeft;
		}
	}
    public void physicRight() {
		
		if(vx > 0 ) {
		physRight = 0.1;
		vx-=physRight;
		}
	}
	
	public void doubleJumpCount() {
		
		doubleJump --;
	}
	
	public void iFramesInitiate() {
		
		iFrame=1;
	}
	public void iFrames() {
		
		if(iFrame > 0) {
			iFrame++;
			//System.out.println(iFrame);
		}
		if(iFrame > 180) {
			iFrame = 0;
			//System.out.println("off");
			vx = 0.001;
		}
	}
	public void damageJump() {
		
		health-=9;
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
	}
	public void setVy(double newVy) {
		vy = newVy;
	}
    public int getDoubleJump() {
		
		return doubleJump;
	}
	public void setDoubleJump(int newDoubleJump) {
		doubleJump = newDoubleJump;
	}
	public int getIFrame() {
		return iFrame;
	}
	public int getHealth() {
		return health;
	}
	public boolean getDead() {
		return dead;
	}
}
