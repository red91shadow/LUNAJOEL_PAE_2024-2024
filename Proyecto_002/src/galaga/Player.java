package galaga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

import interfaces.Movable;

public class Player extends JPanel implements Movable {
    private static final int ANCHO_NAVE = 30;
    private static final int ALTO_NAVE = 30;
    private static final int[] X_COORDS = {0, ANCHO_NAVE / 2, ANCHO_NAVE};
    private static final int[] Y_COORDS = {ALTO_NAVE, 0, ALTO_NAVE};
    private static final int NUM_POINTS = 3;

    private int x, y;
    private int velocidadX;

    public Player() {
        x = 385; // Posición inicial en x
        y = 550; // Posición inicial en y
        velocidadX = 0; // Inicialmente sin movimiento
        setSize(ANCHO_NAVE, ALTO_NAVE);
        setBackground(Color.WHITE);
    }

    @Override
    public void move() {
        x += velocidadX;
        // Limitar el movimiento dentro de los límites de la ventana
        if (x < 0) {
            x = 0;
        } else if (x > 770) {
            x = 770;
        }
        repaint(); // Volver a dibujar la nave después de moverla
    }

    public void dibujar(Graphics g) {
        Polygon nave = new Polygon(X_COORDS, Y_COORDS, NUM_POINTS);
        g.setColor(Color.WHITE);
        g.fillPolygon(nave);
    }

    public void setVelocidadX(int velocidadX) {
        this.velocidadX = velocidadX;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
