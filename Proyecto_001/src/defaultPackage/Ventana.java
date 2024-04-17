package defaultPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	
    private JPanel panel, panel2, panel3, panel4;

    public Ventana() {
        setSize(750, 500);
        setTitle("Proyecto 001");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.green);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        panel = new JPanel();
        panel.setBackground(Color.pink);
        panel.setLayout(null);
        getContentPane().add(panel);

        colocarBotones();
        colocarBotones2();
        colocarBotones3();
    }

    private void colocarBotones() {
        JButton boton1 = new JButton("Cuadrado");
        boton1.setBounds(10, 50, 100, 40);
        panel.add(boton1);

        panel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(150, 150, 100, 100);
            }
        };
        panel2.setBackground(Color.BLACK);
        panel2.setBounds(200, 50, 400, 400);

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                panel.add(panel2);
                panel.setComponentZOrder(panel2, 0); // sirve para colocar los paneles 
                panel.revalidate();
                panel.repaint();
            }
        });
    }

    private void colocarBotones2() {
        JButton boton2 = new JButton("Triangulo");
        boton2.setBounds(10, 100, 100, 40);
        panel.add(boton2);

        panel3 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                int[] xPoints = {150, 200, 250};  
                int[] yPoints = {250, 150, 250};
                g.fillPolygon(xPoints, yPoints, 3);
            }
        };
        panel3.setBackground(Color.BLACK);
        panel3.setBounds(200, 50, 400, 400);

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                panel.add(panel3);
                panel.setComponentZOrder(panel3, 0); 
                panel.revalidate();
                panel.repaint();
            }
        });
    }

    private void colocarBotones3() {
        JButton boton3 = new JButton("Circulo");
        boton3.setBounds(10, 150, 100, 40);
        panel.add(boton3);

        panel4 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                int x = 200;
                int y = 200;
                int diameter = 100;
                g.fillOval(x - diameter / 2, y - diameter / 2, diameter, diameter);
            }
        };
        panel4.setBackground(Color.BLACK);
        panel4.setBounds(200, 50, 400, 400);

        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                panel.add(panel4);
                panel.setComponentZOrder(panel4, 0); 
                panel.revalidate();
                panel.repaint();
            }
        });
    }

 
}
