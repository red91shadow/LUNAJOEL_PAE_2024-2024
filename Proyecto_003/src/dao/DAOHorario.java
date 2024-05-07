package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import Int.IDAO;
import model.Horario;

public class DAOHorario implements IDAO<Horario> {

    private Connection connection;

    public DAOHorario(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Horario horario) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO horarios (id_subject, id_student, id_teacher, start_time, end_time) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, horario.getIdMateria());
            ps.setInt(2, horario.getIdEstudiante());
            ps.setInt(3, horario.getIdProfesor());
            ps.setTime(4, horario.getHoraInicio());
            ps.setTime(5, horario.getHoraFinalizacion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Horario read(int id) {
        Horario horario = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM horarios WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                horario = new Horario(rs.getInt("id"), rs.getInt("id_subject"), rs.getInt("id_student"), rs.getInt("id_teacher"), rs.getTime("start_time"), rs.getTime("end_time"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horario;
    }

    @Override
    public void update(Horario horario) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE horarios SET id_subject = ?, id_student = ?, id_teacher = ?, start_time = ?, end_time = ? WHERE id = ?");
            ps.setInt(1, horario.getIdMateria());
            ps.setInt(2, horario.getIdEstudiante());
            ps.setInt(3, horario.getIdProfesor());
            ps.setTime(4, horario.getHoraInicio());
            ps.setTime(5, horario.getHoraFinalizacion());
            ps.setInt(6, horario.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM horarios WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
