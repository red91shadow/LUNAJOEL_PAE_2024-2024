package frame;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentFrame extends JFrame {
    private JTextField txtName, txtLastName, txtAge;
    private JButton btnSave;

    public StudentFrame() {
        setTitle("Manage Students");
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
                saveStudent();
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

    private void saveStudent() {
        String name = txtName.getText().trim();
        String lastName = txtLastName.getText().trim();
        int age = Integer.parseInt(txtAge.getText().trim());

        Student student = new Student();
        student.setName(name);
        student.setLastname(lastName);
        student.setAge(age);

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(student);
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
