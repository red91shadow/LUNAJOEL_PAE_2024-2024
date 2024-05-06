package controller;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Model.Ship;
import Model.Bullet;
import Model.Spacecraft;



public class Container {
	
	final int SCREEN_WIDTH = 700;
	final int SCREEN_HEIGHT = 200;
	
	Spacecraft player = new Spacecraft();

	List<Ship> aliens = new ArrayList();
	List<Bullet> bulets = new ArrayList();
	Random random = new Random();
	
	public Container() {
		aliens.add(new Ship(random.nextInt(SCREEN_WIDTH),random.nextInt(SCREEN_HEIGHT)));
		aliens.add(new Ship(random.nextInt(SCREEN_WIDTH),random.nextInt(SCREEN_HEIGHT)));
		aliens.add(new Ship(random.nextInt(SCREEN_WIDTH),random.nextInt(SCREEN_HEIGHT)));
		aliens.add(new Ship(random.nextInt(SCREEN_WIDTH),random.nextInt(SCREEN_HEIGHT)));
		aliens.add(new Ship(random.nextInt(SCREEN_WIDTH),random.nextInt(SCREEN_HEIGHT)));
	}
	
	public void draw(Graphics g) {
		player.draw(g);
	
		for(int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		
	}
	
	public void moveLeft(int distance) {
		player.moveLeft(distance);
	}
	
	public void moveRight(int distance) {
		player.moveRigth(distance);
	}
	
	public void moveDown(int distance) {
		for(int i = 0; i < aliens.size(); i++) {
			aliens.get(i).moveDown(distance);
		}
	}
	public void moveUp(int distance) {
		for(int i = 0; i < bulets.size(); i++) {
			bulets.get(i).moveUp(distance);
		}
	}
	
	public void drawShoot(Graphics g){
		Bullet bullet = new Bullet(player.getXPoints()-5, player.getYPoints()-5);
		bulets.add(bullet);
		bullet.draw(g);
		
	}
	

}
