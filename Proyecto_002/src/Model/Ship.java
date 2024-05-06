package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import javax.swing.JFrame;

import interfaces.Drawable;
import interfaces.Mouble;


public class Ship implements Drawable, Mouble{
	int[] XPoints = new int[5];
	int[] YPoints = new int[5];
	
	public Ship(int randomX, int randomY) {
		XPoints[0]=  randomX;
		XPoints[1]=  randomX + 100;
		XPoints[2]=  randomX + 100;
		XPoints[3]=  randomX + 50;
		XPoints[4]=  randomX;
		
		YPoints[0]=  randomY;
		YPoints[1]=  randomY;
		YPoints[2]=  randomY + 50;
		YPoints[3]=  randomY + 25;
		YPoints[4]=  randomY + 50;
		
	}
	

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillPolygon(XPoints, YPoints, 5);
	}


	@Override
	public void moveUp(int distance) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moveDown(int distance) {
		for(int i = 0; i < YPoints.length; i++) {
			YPoints[i] = YPoints[i] + distance;
		}
		
	}
	
}
	

