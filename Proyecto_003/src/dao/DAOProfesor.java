package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Int.IDAO;
import model.Profesor;

public class DAOProfesor implements IDAO<Profesor> {

    private Connection connection;

    public DAOProfesor(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Profesor teacher) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Profesores (id, name, last_name, age) VALUES (?, ?, ?, ?)");
            ps.setInt(1, teacher.getId());
            ps.setString(2, teacher.getName());
            ps.setString(3, teacher.getLastName());
            ps.setInt(4, teacher.getAge());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Profesor read(int id) {
        Profesor teacher = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Profesores WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                teacher = new Profesor(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getInt("age"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public void update(Profesor teacher) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Profesores SET name = ?, last_name = ?, age = ? WHERE id = ?");
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getLastName());
            ps.setInt(3, teacher.getAge());
            ps.setInt(4, teacher.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Profesores WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
