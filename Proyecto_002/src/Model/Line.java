package Model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import interfaces.Drawable;



public class Line implements Drawable{
	
	JFrame frame;
	
	
	public Line(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void draw(Graphics g) {
		
        // Dibuja el triángulo en la posición actual (x, y)
        g.setColor(Color.BLUE);
        g.drawLine(0, 402, 800, 402);
        frame.setVisible(true);
       
		
	}
	

}
