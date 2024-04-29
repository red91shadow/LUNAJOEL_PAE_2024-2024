package galaga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

import interfaces.Drawable;
import interfaces.Movable;
import interfaces.Destroyable;
import interfaces.Shootable;

public class SpaceCraft extends JPanel implements Drawable, Movable, Destroyable, Shootable {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private static final int[] X_COORDS = {WIDTH / 2, 0, WIDTH};
    private static final int[] Y_COORDS = {0, HEIGHT, HEIGHT};
    private static final int NUM_POINTS = 3;

    private int x, y;
    private int velocityX;
    private int health;
    private boolean canShoot;

    public SpaceCraft(int initialX, int initialY) {
        x = initialX - WIDTH / 2; // Centrar horizontalmente
        y = initialY - HEIGHT; // En la parte inferior de la ventana
        velocityX = 0;
        health = 100;
        canShoot = true;
        setSize(WIDTH, HEIGHT);
        setBackground(Color.WHITE);
    }

    @Override
    public void move() {
        x += velocityX;
        // Limitar el movimiento dentro de los límites de la ventana
        if (x < 0) {
            x = 0;
        } else if (x > 770) {
            x = 770;
        }
        repaint(); // Volver a dibujar la nave después de moverla
    }

    @Override
    public void draw(Graphics g) {
        Polygon shipShape = new Polygon(X_COORDS, Y_COORDS, NUM_POINTS);
        g.setColor(Color.WHITE);
        g.fillPolygon(shipShape);
    }

    @Override
    public void destroy() {
        health -= 20;
        if (health <= 0) {
            // La nave ha sido destruida
        }
    }

    @Override
    public void shoot() {
        if (canShoot) {
            // Crear un proyectil en forma de eclipse blanco
            // Código para disparar
            canShoot = false; // Evitar disparos rápidos
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

	
}
