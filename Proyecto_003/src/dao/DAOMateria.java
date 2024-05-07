package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Int.IDAO;
import model.Materia;

public class DAOMateria implements IDAO<Materia> {

    private Connection connection;

    public DAOMateria(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Materia materia) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO materias (id, name, description, credit) VALUES (?, ?, ?, ?)");
            ps.setInt(1, materia.getId());
            ps.setString(2, materia.getName());
            ps.setString(3, materia.getDescription());
            ps.setInt(4, materia.getCredit());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Materia read(int id) {
        Materia materia = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM materias WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getInt("credit"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materia;
    }

    @Override
    public void update(Materia materia) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE materias SET name = ?, description = ?, credit = ? WHERE id = ?");
            ps.setString(1, materia.getName());
            ps.setString(2, materia.getDescription());
            ps.setInt(3, materia.getCredit());
            ps.setInt(4, materia.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM materias WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
