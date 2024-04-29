package galaga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Area;

import javax.swing.JFrame;

import interfaces.IObject;

public class villain implements IObject {
	
	JFrame frame;
	int x;
	int y;
	
	boolean end = false;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	int InicioX = 0, InicioY = 0;
	int FinX = 0, FinY = 0;

	public static int xVillano1 = 600, yVillano1 = 700;
	public static int xVillano2 = 600, yVillano2 = 700;
	public static int xVillano3 = 600, yVillano3 = 700;
	public static int xVillano4 = 600, yVillano4 = 700;

	Area r1, r2, r3, r4;

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(Color.green);
		int[] scaledXPoints = { x + 20, x + 60, x + 60, x + 30, x + 20 };
		int[] scaledYPoints = { y + 20, y + 20, y + 60, y + 30, y + 60 };
		g.fillPolygon(scaledXPoints, scaledYPoints, 5);
	    frame.setVisible(true);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		
			
			if(x>=650){
				end= true;
				y+=100;
			}
			if(x<=40) {
				end = false;
				y+=100;
			}
			if(end==false) {
				x += 10;
			}else if(end==true) {
				x -=10;
			}			

	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub

	}
	
	public boolean colision() {
		return true;
	}

}
