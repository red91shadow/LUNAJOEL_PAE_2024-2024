package controller;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Model.Ship;
import Model.Bullet;
import Model.Spacecraft;

public class Container {
	private final int SCREEN_WIDTH = 700;
	private final int SCREEN_HEIGHT = 200;

	private Spacecraft player = new Spacecraft();
	private List<Ship> aliens = new ArrayList<>();
	private List<Bullet> bullets = new ArrayList<>();
	private Random random = new Random();

	public Container() {
		initializeAliens();
	}

	private void initializeAliens() {
		for (int i = 0; i < 5; i++) {
			aliens.add(new Ship(random.nextInt(SCREEN_WIDTH), random.nextInt(SCREEN_HEIGHT)));
		}
	}

	public void draw(Graphics g) {
		player.draw(g);
		for (Ship alien : aliens) {
			alien.draw(g);
		}
		for (Bullet bullet : bullets) {
			bullet.draw(g);
		}
	}

	public void moveLeft(int distance) {
		player.moveLeft(distance);
	}

	public void moveRight(int distance) {
		player.moveRigth(distance);
	}

	public void moveDown(int distance) {
		for (Ship alien : aliens) {
			alien.moveDown(distance);
		}
	}

	public void moveUp(int distance) {
		for (Bullet bullet : bullets) {
			bullet.moveUp(distance);
		}
	}

	public void drawShoot(Graphics g) {
		Bullet bullet = new Bullet(player.getXPoints() - 5, player.getYPoints() - 5);
		bullets.add(bullet);
		bullet.draw(g);
	}
}
