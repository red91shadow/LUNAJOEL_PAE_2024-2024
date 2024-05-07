package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;

import connection.MySQLConnectionFactory;
import Int.ConnectionFactory;
import manager.CRUDManager;
import model.*;
/**
 * @author Joel Luna
 * Tema MySQL Connection
 */


public class Main {

    public static void main(String[] args) {
        
        ConnectionFactory connectionFactory = new MySQLConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        CRUDManager crudManager = new CRUDManager(connection);

        // Ejemplo de uso para crear un estudiante
        Estudiante nuevoEstudiante = new Estudiante(1, "Juan", "Pérez", 20);
        crudManager.createEstudiante(nuevoEstudiante);

        // Ejemplo de uso para leer un estudiante por su ID
        Estudiante estudianteLeido = crudManager.readEstudiante(1);
        System.out.println(estudianteLeido.getName());
        

        // Ejemplo de uso para actualizar un estudiante
        nuevoEstudiante.setAge(21);
        crudManager.updateEstudiante(nuevoEstudiante);

        // Ejemplo de uso para eliminar un estudiante
        crudManager.deleteEstudiante(1);

        

       

        // Cerrar la conexión a la base de datos cuando hayas terminado
        try {
            connection.close();
            System.out.println("Conexión cerrada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
