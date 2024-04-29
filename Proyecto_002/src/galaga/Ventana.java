package galaga;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Ventana extends JFrame  {
   
	
	private JPanel panel;
   

    public Ventana() {
        setSize(800, 600);
        setTitle("Galaga");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.green);
        iniciarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

       
    }
    
    private void iniciarComponentes() {
        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(null);
        getContentPane().add(panel);

        
    }

}
