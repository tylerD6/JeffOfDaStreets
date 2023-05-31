import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
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
	
	
	
	
public void paint(Graphics g) {
		
		super.paintComponents(g);
		b.paint(g);
		j.paint(g);
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
	
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//don't write in here
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		//System.out.println(j.getY());
		
		//JEFF:
		//RIGHT = 68
		//UP = 87
		//LEFT = 65
		
		//BOB:
		//LEFT = 37
		//UP = 38
		//LEFT = 39
		
		if(e.getKeyCode() == 68) {
			j.setVx(10);
		}
		if(e.getKeyCode() == 65) {
			j.setVx(-10);
		}
		if(j.getY() > 460) {
		if(e.getKeyCode() == 87) {
			j.setVy(-15);
		   }
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 68) {
			j.setVx(0);
		}
		if(e.getKeyCode() == 65) {
			j.setVx(0);
		}
		if(e.getKeyCode() == 87) {
			j.setVy(0);
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
