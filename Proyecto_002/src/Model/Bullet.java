package Model;

import java.awt.Color;
import java.awt.Graphics;
import interfaces.Drawable;
import interfaces.Movable;

public class Bullet implements Drawable, Movable {
    private int x;
    private int y;
    
    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 10, 10);
    }

    @Override
    public void moveUp(int distance) {
        y -= distance;
    }

    @Override
    public void moveDown(int distance) {
        y += distance;
    }
}
