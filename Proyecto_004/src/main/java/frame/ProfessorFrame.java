package frame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProfessorFrame extends JFrame {
    private JTextField txtName, txtLastName, txtAge;
    private JButton btnSave;

    public ProfessorFrame() {
        setTitle("Manage Professors");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel lblName = new JLabel("Name:");
        JLabel lblLastName = new JLabel("Last Name:");
        JLabel lblAge = new JLabel("Age:");

        txtName = new JTextField(15);
        txtLastName = new JTextField(15);
        txtAge = new JTextField(5);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProfessor();
            }
        });

        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblLastName);
        panel.add(txtLastName);
        panel.add(lblAge);
        panel.add(txtAge);
        panel.add(btnSave);

        add(panel);
    }

    private void saveProfessor() {
        String name = txtName.getText().trim();
        String lastName = txtLastName.getText().trim();
        int age = Integer.parseInt(txtAge.getText().trim());

        Professor professor = new Professor();
        professor.setName(name);
        professor.setLastname(lastName);
        professor.setAge(age);

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(professor);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        clearFields();
    }

    private void clearFields() {
        txtName.setText("");
        txtLastName.setText("");
        txtAge.setText("");
    }
}
