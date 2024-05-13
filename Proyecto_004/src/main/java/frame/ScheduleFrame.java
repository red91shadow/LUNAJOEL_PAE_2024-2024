package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import models.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ScheduleFrame extends JFrame {
    private JTextField txtIdMat, txtIdStudent, txtIdProfessor, txtStartTime, txtEndTime;
    private JButton btnSave;

    public ScheduleFrame() {
        setTitle("Manage Schedules");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel lblIdMat = new JLabel("Subject ID:");
        JLabel lblIdStudent = new JLabel("Student ID:");
        JLabel lblIdProfessor = new JLabel("Professor ID:");
        JLabel lblStartTime = new JLabel("Start Time:");
        JLabel lblEndTime = new JLabel("End Time:");

        txtIdMat = new JTextField(10);
        txtIdStudent = new JTextField(10);
        txtIdProfessor = new JTextField(10);
        txtStartTime = new JTextField(10);
        txtEndTime = new JTextField(10);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSchedule();
            }
        });

        panel.add(lblIdMat);
        panel.add(txtIdMat);
        panel.add(lblIdStudent);
        panel.add(txtIdStudent);
        panel.add(lblIdProfessor);
        panel.add(txtIdProfessor);
        panel.add(lblStartTime);
        panel.add(txtStartTime);
        panel.add(lblEndTime);
        panel.add(txtEndTime);
        panel.add(btnSave);

        add(panel);
    }

    private void saveSchedule() {
        int idMat = Integer.parseInt(txtIdMat.getText().trim());
        int idStudent = Integer.parseInt(txtIdStudent.getText().trim());
        int idProfessor = Integer.parseInt(txtIdProfessor.getText().trim());
        Time startTime = Time.valueOf(txtStartTime.getText().trim());
        Time endTime = Time.valueOf(txtEndTime.getText().trim());

        Schedule schedule = new Schedule();
        schedule.setId_mat(idMat);
        schedule.setId_alumno(idStudent);
        schedule.setId_profesor(idProfessor);
        schedule.setHora_inicio(startTime);
        schedule.setHora_fin(endTime);

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(schedule);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        clearFields();
    }

    private void clearFields() {
        txtIdMat.setText("");
        txtIdStudent.setText("");
        txtIdProfessor.setText("");
        txtStartTime.setText("");
        txtEndTime.setText("");
    }
}
