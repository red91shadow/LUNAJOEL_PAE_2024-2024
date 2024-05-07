package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Int.IDAO;
import model.Estudiante;

public class DAOEstudiante implements IDAO<Estudiante> {
	
	//cambio

    private Connection connection;

    public DAOEstudiante(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Estudiante student) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Estudiantes (id, name, last_name, age) VALUES (?, ?, ?, ?)");
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getLastName());
            ps.setInt(4, student.getAge());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante read(int id) {
        Estudiante student = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Estudiantes WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Estudiante(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getInt("age"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void update(Estudiante student) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Estudiantes SET name = ?, last_name = ?, age = ? WHERE id = ?");
            ps.setString(1, student.getName());
            ps.setString(2, student.getLastName());
            ps.setInt(3, student.getAge());
            ps.setInt(4, student.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Estudiantes WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
