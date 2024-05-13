package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SubjectFrame extends JFrame {
    private JTextField txtName, txtDescription, txtLevel;
    private JButton btnSave;

    public SubjectFrame() {
        setTitle("Manage Subjects");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel lblName = new JLabel("Name:");
        JLabel lblDescription = new JLabel("Description:");
        JLabel lblLevel = new JLabel("Level:");

        txtName = new JTextField(15);
        txtDescription = new JTextField(15);
        txtLevel = new JTextField(5);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSubject();
            }
        });

        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblDescription);
        panel.add(txtDescription);
        panel.add(lblLevel);
        panel.add(txtLevel);
        panel.add(btnSave);

        add(panel);
    }

    private void saveSubject() {
        String name = txtName.getText().trim();
        String description = txtDescription.getText().trim();
        int level = Integer.parseInt(txtLevel.getText().trim());

        Subject subject = new Subject();
        subject.setName(name);
        subject.setDescrition(description);
        subject.setLevel(level);

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(subject);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        clearFields();
    }

    private void clearFields() {
        txtName.setText("");
        txtDescription.setText("");
        txtLevel.setText("");
    }
}
