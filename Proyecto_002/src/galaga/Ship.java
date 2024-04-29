package galaga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

import interfaces.IObject;

public class Ship implements IObject {

	public static int x = 10, y = 10;
	KeyEvent e;
	
	//variables para creacion de nave
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	private static final int[] X_COORDS = { WIDTH / 2, 0, WIDTH };
	private static final int[] Y_COORDS = { 0, HEIGHT, HEIGHT };
	private static final int NUM_POINTS = 3;

	@Override
	public void draw(Graphics g ) {
		// TODO Auto-generated method stub
		Polygon shipShape = new Polygon(X_COORDS, Y_COORDS, NUM_POINTS);
        g.setColor(Color.WHITE);
        g.fillPolygon(shipShape);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==37) {
			if(x>0) {
				x= x - 20;
			}
		}
		
		if(e.getKeyCode()==38) {
			if(x>0) {
				x= x +20;
			}
		}

	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub

	}
	
	public  Ellipse2D getBoundsNave() {
		return new Ellipse2D.Double(x+10, y+30,80,50);
	}
	
	

}
