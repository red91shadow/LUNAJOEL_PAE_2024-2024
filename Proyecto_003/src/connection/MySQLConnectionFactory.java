package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Int.ConnectionFactory;

public class MySQLConnectionFactory implements ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/Instituto";
    private static final String USER = "root";
    private static final String PASSWORD = "10250178";

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
