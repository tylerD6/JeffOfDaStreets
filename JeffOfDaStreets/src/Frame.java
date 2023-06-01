import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener{// Started: 5/30

	Background b = new Background();
	Jeff j = new Jeff();
	Bob j2 = new Bob();
	JeffHealthBar h1 = new JeffHealthBar();
	BobHealthBar h2 = new BobHealthBar();
	
	
	
public void paint(Graphics g) {
		
		super.paintComponents(g);
		b.paint(g);
		j.paint(g);
		j2.paint(g);
		h1.paint(g);
		h2.paint(g);
		
		Font jeffFont = new Font("Courier New", Font.BOLD, 30);
		
		g.setColor(Color.red);
		g.drawRect((int)j.getX()+15, (int)j.getY()+70, 120, 80);
		
		g.setColor(Color.red);
		g.drawRect((int)j2.getX()+15, (int)j2.getY()+70, 120, 80);
		
		g.setFont(jeffFont);
		if(j.getHealth() > 49) {
			g.setColor(Color.green);
			}
			if(j.getHealth() > 20 && j.getHealth() < 50) {
				g.setColor(Color.yellow);
			}
			if(j.getHealth() <=20) {
				g.setColor(Color.red);
			}
		g.drawString(":"+(Integer.toString(j.getHealth())+"%"), 210, 675);
		
		if(j2.getHealth() > 49) {
		g.setColor(Color.green);
		}
		if(j2.getHealth() > 20 && j2.getHealth() < 50) {
			g.setColor(Color.yellow);
		}
		if(j2.getHealth() <=20) {
			g.setColor(Color.red);
		}
		g.drawString(":"+(Integer.toString(j2.getHealth())+"%"), 900, 675);
		
		hit();
		
		
	}
	
	
	public static void main(String args[]) {
		
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("JeffOfDaStreets");
		f.setSize(new Dimension(1050, 750));
		f.add( this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(1, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public void hit() {
		
		Rectangle jeffHitBox = new Rectangle((int)j.getX()+15, (int)j.getY()+70, 120, 80);
		Rectangle bobHitBox = new Rectangle((int)j2.getX()+15, (int)j2.getY()+70, 120, 80);
		
		if(jeffHitBox.intersects(bobHitBox) || bobHitBox.intersects(jeffHitBox)) {
			if(j.getY() < j2.getY() && j.getVy() > 0 && j2.getIFrame() == 0) {
				
				System.out.println("bob hit");
				//j2.setX(700);
				j2.iFramesInitiate();
				j2.damageJump();
				
				j.setVx(-1*j.getVx());
				j.setVy(-1.5*j.getVy());
			}
			if(j2.getY() < j.getY() && j2.getVy() > 0 && j.getIFrame() == 0) {
				
				System.out.println("jeff hit");
				//j.setX(200);
				j.iFramesInitiate();
				j.damageJump();
				
				j2.setVx(-1*j2.getVx());
				j2.setVy(-1.5*j2.getVy());
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//don't write in here
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());
		//System.out.println(j.getDoubleJump());
		
		//JEFF:
		//RIGHT = 68
		//UP = 87
		//LEFT = 65
		//DOWN 83
		
		if(j.getDead() == false && j2.getDead() == false) {
		
		if(j.getIFrame() == 0 || j.getIFrame() > 140) {
		
		if(e.getKeyCode() == 68) { //JEFF MOVE
			j.setVx(10);
		}
		if(e.getKeyCode() == 65) {
			j.setVx(-10);
		}
		
		if(e.getKeyCode() == 87 && j.getDoubleJump() > 0) { //double jump
			j.setVy(-12.5);
			j.doubleJumpCount();
		}
		
		if(e.getKeyCode() == 83) {
			
			j.setVy(15);
		}
		
		}
		
		        //BOB:
				//LEFT = 37
				//UP = 38
				//LEFT = 39
		        //DOWN 40
		if(j2.getIFrame() == 0 || j2.getIFrame() > 140) {
		
		if(e.getKeyCode() == 39) { //BOB MOVE
			j2.setVx(10);
		}
		if(e.getKeyCode() == 37) {
			j2.setVx(-10);
		}
		
		if(e.getKeyCode() == 38 && j2.getDoubleJump() > 0) {
			j2.setVy(-12.5);
			j2.doubleJumpCount();
		}
        if(e.getKeyCode() == 40) {
			
			j2.setVy(15);
		    }
		  }
	   }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(j.getY() > 465) {
		if(e.getKeyCode() == 68) { //JEFF MOVE
			j.setVx(0);
		}
		if(e.getKeyCode() == 65) {
			j.setVx(0);
		   }
		}
		if(e.getKeyCode() == 87) {
			j.setVy(0);
		}
		if(j.getY() > 465) {
			j.setVy(0);
		}
		
		if(j2.getY() > 465) {
		if(e.getKeyCode() == 39) { //BOB MOVE
			j2.setVx(0);
		}
		if(e.getKeyCode() == 37) {
			j2.setVx(0);
		   }
		}
		
		if(e.getKeyCode() == 38) {
			j2.setVy(0);
		}
		if(j2.getY() > 465) {
			j2.setVy(0);
		   }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}
