package interfaces;

import java.awt.Graphics;

public interface IObject {

	void draw(Graphics g);

	void destroy();

	void move();

	void shoot();

}
