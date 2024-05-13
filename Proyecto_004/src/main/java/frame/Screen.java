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
import models.Subject;
import models.Professor;
import models.Schedule;

public class Screen extends JFrame {
    private JButton btnStudents, btnProfessors, btnSubjects, btnSchedules;

    public Screen() {
        setTitle("Instituto Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        btnStudents = new JButton("Manage Students");
        btnProfessors = new JButton("Manage Professors");
        btnSubjects = new JButton("Manage Subjects");
        btnSchedules = new JButton("Manage Schedules");

        btnStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentFrame().setVisible(true);
            }
        });

        btnProfessors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfessorFrame().setVisible(true);
            }
        });

        btnSubjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SubjectFrame().setVisible(true);
            }
        });

        btnSchedules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScheduleFrame().setVisible(true);
            }
        });

        panel.add(btnStudents);
        panel.add(btnProfessors);
        panel.add(btnSubjects);
        panel.add(btnSchedules);

        add(panel);
    }

    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setVisible(true);
    }
}
