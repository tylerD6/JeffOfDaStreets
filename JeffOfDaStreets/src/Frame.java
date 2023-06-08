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
	JeffSpittle s = new JeffSpittle();
	BobSpittle s2 = new BobSpittle();
	JeffAbilityUI a = new JeffAbilityUI();
	BobAbilityUI a2 = new BobAbilityUI();
	JeffDefendUI d = new JeffDefendUI();
	BobDefendUI d2 = new BobDefendUI();
	JeffBubble de = new JeffBubble();
	BobBubble de2 = new BobBubble();
	
	
	
public void paint(Graphics g) {
		
		super.paintComponents(g);
		b.paint(g);
		j.paint(g);
		j2.paint(g);
		h1.paint(g);
		h2.paint(g);
		s.paint(g);
		s2.paint(g);
		a.paint(g);
		a2.paint(g);
		d.paint(g);
		de.paint(g);
		d2.paint(g);
		de2.paint(g);
		
		
		
		Font jeffFont = new Font("Courier New", Font.BOLD, 30);
		Font charge = new Font("Courier New", Font.BOLD, 15);
		
		g.setColor(Color.red); //HITBOX FOR JEFF
		g.drawRect((int)j.getX()+15, (int)j.getY()+70, 120, 80);
		
		g.setColor(Color.red); //HITBOX FOR BOB
		g.drawRect((int)j2.getX()+15, (int)j2.getY()+70, 120, 80);
		
		g.setColor(Color.blue);
		g.drawRect((int)s.getX()+60,(int)s.getY()+10, 80, 60); //VISUAL HITBOX OF SPITTLE
		g.drawRect((int)s2.getX()+60,(int)s2.getY()+10, 80, 60);
		
		g.drawRect((int)de.getX()-10,(int)de.getY()-10, 165, 160); //VISUAL HITBOX FOR JEFF BLOCK
		g.drawRect((int)de2.getX()-10,(int)de2.getY()-10, 165, 160); //VISUAL HITBOX FOR BOB BLOCK
		
		
		
		g.setFont(jeffFont); //HEALTH BAR
		if(j.getHealth() > 100) { //over health
			g.setColor(Color.blue);
		}
		if(j.getHealth() > 49 && j.getHealth() <=100) {
			g.setColor(Color.green);
			}
			if(j.getHealth() > 20 && j.getHealth() < 50) {
				g.setColor(Color.yellow);
			}
			if(j.getHealth() <=20) {
				g.setColor(Color.red);
			}
		g.drawString(":"+(Integer.toString(j.getHealth())+"."+(Integer.toString(j.getPercentHealth()))+"%"), 145, 675);
		
		if(j2.getHealth() > 100) { //over health
			g.setColor(Color.blue);
		}
		if(j2.getHealth() > 49 && j2.getHealth() <=100) {
		g.setColor(Color.green);
		}
		if(j2.getHealth() > 20 && j2.getHealth() < 50) {
			g.setColor(Color.yellow);
		}
		if(j2.getHealth() <=20) {
			g.setColor(Color.red);
		}
		g.drawString(":"+(Integer.toString(j2.getHealth())+"."+(Integer.toString(j2.getPercentHealth()))+"%"), 800, 675);
		
		//CHARGE STATE
		
		g.setFont(charge);
		
		if(s.getY() == -500) {
			g.setColor(Color.green);
			g.drawString("E",298,640);
		}else {
			
			g.setColor(Color.red);
			g.drawString("WAIT",287,640);
		}
		
		if(s2.getY() == -400) {
			g.setColor(Color.green);
			g.drawString("ENTER",933,640);
		}else {
			
			g.setColor(Color.red);
			g.drawString("WAIT",935,640);
		}
		
		//DEFEND STATE
		
		if(d.getReady() == true) { //JEFF
			
			g.setColor(Color.green);
			g.drawString("Q",350,640);
		}else {
			
			g.setColor(Color.red);
			g.drawString("WAIT",336,640);
		}
        if(d2.getReady() == true) { //BOB
			
			g.setColor(Color.green);
			g.drawString("SHIFT",984,640);
		}else {
			
			g.setColor(Color.red);
			g.drawString("WAIT",985,640);
		}
		
		
		hit();
		rechargeJeff();
		jeffBubbleFollow();
		bobBubbleFollow();
}

    public void rechargeJeff() {
    	//System.out.println(a.getReady());
    	if(s.getY() == -500) {
    		//System.out.println("ready");
    		a.setReady(true);
    	}
    	if(s2.getY() == -400) {
    		a2.setReady(true);
    	}
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
		
		Rectangle jeffHitBox = new Rectangle((int)j.getX()+15, (int)j.getY()+70, 120, 80); //HITBOX OF JEFF
		Rectangle bobHitBox = new Rectangle((int)j2.getX()+15, (int)j2.getY()+70, 120, 80); //HITBOX OF BOB
		
		Rectangle jeffSpittle = new Rectangle((int)s.getX()+60,(int)s.getY()+10, 80, 60);
		Rectangle bobSpittle = new Rectangle((int)s2.getX()+60,(int)s2.getY()+10, 80, 60);
		
		Rectangle jeffBubble = new Rectangle((int)de.getX()-10,(int)de.getY()-10, 165, 160);
		Rectangle bobBubble = new Rectangle((int)de2.getX()-10,(int)de2.getY()-10, 165, 160);
		
		if(jeffHitBox.intersects(bobHitBox) || bobHitBox.intersects(jeffHitBox)) {
			if(j.getY() < j2.getY() && j.getVy() > 0 && j2.getIFrame() == 0 && j.getIFrame() == 0 && d.getDuration() == 0 && j.getDazed() == false) { //BOB HITS JEFF
				
				System.out.println("bob hit");
				//j2.setX(700); ///
				j2.iFramesInitiate();
				j2.damageJump();
				j2.setVy(20);
				
				j.setVx(-1*j.getVx());
				j.setVy(-1.5*j.getVy());
				
				if(j2.getY() < 200) {
					System.out.println("pummel bob");
					b.pummel();
					b.setPummel(true);
				}
			}
			if(j2.getY() < j.getY() && j2.getVy() > 0 && j.getIFrame() == 0 && j2.getIFrame() == 0 && j2.getDazed() == false) { //JEFF HITS BOB
				
				System.out.println("jeff hit");
				//j.setX(200);
				j.iFramesInitiate();
				j.damageJump();
				j.setVy(20);
				
				j2.setVx(-1*j2.getVx());
				j2.setVy(-1.5*j2.getVy());
				
				if(j.getY() < 200) {
					System.out.println("pummel jeff");
					b.pummel();
					b.setPummel(true);
				}
			}
		}
		
		if(jeffSpittle.intersects(bobHitBox) && j2.getIFrame() == 0) { //JEFF SPITS ON BOB
			
			j2.iFramesInitiate();
			j2.damageSpittle();
			s.setX(0);
			s.setY(1000);
		}
        if(bobSpittle.intersects(jeffHitBox) && j.getIFrame() == 0) { //BOB SPITS ON JEFF
			
			j.iFramesInitiate();
			j.damageSpittle();
			s2.setX(1200);
			s2.setY(1000);
		}
        if(jeffSpittle.intersects(bobSpittle)) { //SPITTLE COLLIDES
        	
        	s.setX(1100);
        	s.setY(-100);
        	s2.setX(1100);
        	s2.setY(1200);
        }
        
        //BUBBLE COLLISIONS
        
        if(bobHitBox.intersects(jeffBubble) && j2.getY() < j.getY()) { //JEFF BLOCKS BOB
        	
        	j2.setVx(-1.2*j2.getVx());
        	j2.setVy(-1.2*j2.getVy());
        	j2.setDazed(true);
        }
        if(jeffHitBox.intersects(bobBubble) && j.getY() < j2.getY()) { //BOB BLOCKS JEFF
        	
        	j.setVx(-1.2*j.getVx());
        	j.setVy(-1.2*j.getVy());
        	j.setDazed(true);
        }
        
        if(bobSpittle.intersects(jeffBubble)) { //JEFF ABSORBS SPITTLE
        	
        	s2.setX(1200);
			s2.setY(1000);
			j.absorb();
        }
        if(jeffSpittle.intersects(bobBubble)) { //BOB ABSORBS SPITTLE
        	
        	s.setX(1200);
			s.setY(1000);
			j2.absorb();
        }
        if(jeffBubble.intersects(bobBubble)) { //BUBBLES COLLIDE
        	
        	j.setVx(-2*j.getVx());
        
        }
        if(bobBubble.intersects(jeffBubble)) {
        	
        	j2.setVx(-2*j2.getVx());
        	
        }
	}
	
	
	public void jeffBubbleFollow() {
		
		if(d.getDuration() > 0) {
			
			 de.setX(j.getX());
        	 de.setY(j.getY()+40);
		}
		if(d.getDuration() == 0) {
			
			de.setX(-200);
			de.setY(-200);
		}
	}
    public void bobBubbleFollow() {
		
		if(d2.getDuration() > 0) {
			
			 de2.setX(j2.getX());
        	 de2.setY(j2.getY()+40);
		}
		if(d2.getDuration() == 0) {
			
			de2.setX(-200);
			de2.setY(-400);
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
		System.out.println(e.getKeyCode());
		//System.out.println(j.getDoubleJump());
		
		//JEFF:
		//RIGHT = 68
		//UP = 87
		//LEFT = 65
		//DOWN 83
		
		if(j.getDead() == false && j2.getDead() == false) { //BOTH CAN'T MOVE
		
		if((j.getIFrame() == 0 || j.getIFrame() > 140) && d.getDuration() == 0 && j.getDazed() == false) { //JEFF CAN'T MOVE
		
		if(e.getKeyCode() == 68) { //JEFF MOVE
			j.setVx(10);
		}
		if(e.getKeyCode() == 65) {
			j.setVx(-10);
		}
		
		if(e.getKeyCode() == 87 && j.getDoubleJump() > 0) { //double jump
			j.setVy(-12.5);
			j2.setStrongJump(false);
			j.doubleJumpCount();
		}
		
		if(e.getKeyCode() == 83) { //FAST FALL
			
			j2.setStrongJump(true);
			j.setVy(15);
		}
		if(e.getKeyCode() == 69 && s.getVx() == 0 && j.getIFrame() == 0) { //JEFF SHOOT PROJECTILE
			
			a.setReady(false);
			
			if(j.getFaceRight() == true) { 
			s.setX(j.getX()+50);
			s.setY(j.getY()+70);
			
			s.setVx(10);
			
			
			}else{
				s.setX(j.getX()-50);
				s.setY(j.getY()+70);
				
				s.setVx(-10);
				
			}
		   
		   }
         
         
         if(e.getKeyCode() == 81 && d.getDuration() == 0 && d.getReady() == true) { //JEFF BUBBLE
        	 
        	 d.setReady(false);
        	 d.setDuration(1);
        	 de.setX(j.getX());
        	 de.setY(j.getY());
        	 j.setVx(0);
        	 j.setVy(0);
           }
         
		}
		
		        //BOB:
				//LEFT = 37
				//UP = 38
				//LEFT = 39
		        //DOWN 40
		if((j2.getIFrame() == 0 || j2.getIFrame() > 140) && d2.getDuration() == 0 && j2.getDazed() == false) { //BOB CAN'T MOVE
		
		if(e.getKeyCode() == 39) { //BOB MOVE
			j2.setVx(10);
		}
		if(e.getKeyCode() == 37) {
			j2.setVx(-10);
		}
		
		if(e.getKeyCode() == 38 && j2.getDoubleJump() > 0) { //BOB DOUBLE JUMP
			j.setStrongJump(false);
			j2.setVy(-12.5);
			j2.doubleJumpCount();
		}
        if(e.getKeyCode() == 40) { //FAST FALL
			
        	j.setStrongJump(true);
			j2.setVy(15);
		    }
        if(e.getKeyCode() == 16 && d2.getDuration() == 0 && d2.getReady() == true) { //BOB BUBBLE
       	 
       	 d2.setReady(false);
       	 d2.setDuration(1);
       	 de2.setX(j2.getX());
       	 de2.setY(j2.getY()+40);
       	 j2.setVx(0);
       	 j2.setVy(0);
          }
        if(e.getKeyCode() == 10 && s2.getVx() == 0 && j2.getIFrame() == 0) { //BOB SHOOT PROJECTILE
			
       	 a2.setReady(false);
       	 
			if(j2.getFaceRight() == true) { 
			s2.setX(j2.getX()+50);
			s2.setY(j2.getY()+70);
			
			s2.setVx(10);
			
			
			}else{
				s2.setX(j2.getX()-50);
				s2.setY(j2.getY()+70);
				
				s2.setVx(-10);
			  }
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
