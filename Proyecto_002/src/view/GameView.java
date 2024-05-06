package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import javax.swing.*;

import Model.Ship;
import controller.Container;

public class GameView extends JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Ship> alins = new ArrayList<>();
    Container container;
    JPanel mainPanel;

    public GameView() {
        setTitle("Galaga");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        container = new Container();
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                container.draw(g);
            }
        };
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setFocusable(true);
        mainPanel.addKeyListener(new GameKeyListener());

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.moveDown(1);
                mainPanel.repaint();
            }
        });
        timer.start();

        setContentPane(mainPanel);
        setVisible(true);
    }

    private class GameKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE: {
                    container.drawShoot(mainPanel.getGraphics());
                    System.out.println("hi");
                    break;
                }
                case KeyEvent.VK_A: {
                    container.moveLeft(10);
                    break;
                }
                case KeyEvent.VK_D: {
                    container.moveRight(10);
                    break;
                }
                default:
                    break;
            }
            mainPanel.repaint();
        }
    }
}
