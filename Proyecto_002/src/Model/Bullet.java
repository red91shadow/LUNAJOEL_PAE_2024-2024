package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import interfaces.Drawable;
import interfaces.Mouble;


public class Bullet implements Drawable, Mouble {

	int XPoint;
	int YPoint;
	
	public Bullet(int XPoint, int YPoint) {
		this.XPoint = XPoint;
		this.YPoint = YPoint;
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.white);
		g.fillOval(XPoint, YPoint, 10, 10);
	}



	@Override
	public void moveUp(int distance) {
		YPoint -= 10;
	}


	@Override
	public void moveDown(int distance) {
		// TODO Auto-generated method stub
		
	}
	
}
	
	
	