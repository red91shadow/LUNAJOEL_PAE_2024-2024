package galaga;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorTeclado implements KeyListener {
    private SpaceCraft nave;

    public ControladorTeclado(SpaceCraft nave) {
        this.nave = nave;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            nave.setVelocityX(-1); // Mover hacia la izquierda
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            nave.setVelocityX(1); // Mover hacia la derecha
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
            nave.setVelocityX(0); // Detener el movimiento horizontal al soltar la tecla
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se necesita implementar para este caso
    }
}
