package manager;

import java.sql.Connection;
import dao.*;
import model.*;

public class CRUDManager {

    private Connection connection;

    public CRUDManager(Connection connection) {
        this.connection = connection;
    }

    public void createEstudiante(Estudiante estudiante) {
        DAOEstudiante daoEstudiante = new DAOEstudiante(connection);
        daoEstudiante.create(estudiante);
    }

    public Estudiante readEstudiante(int id) {
        DAOEstudiante daoEstudiante = new DAOEstudiante(connection);
        return daoEstudiante.read(id);
    }

    public void updateEstudiante(Estudiante estudiante) {
        DAOEstudiante daoEstudiante = new DAOEstudiante(connection);
        daoEstudiante.update(estudiante);
    }

    public void deleteEstudiante(int id) {
        DAOEstudiante daoEstudiante = new DAOEstudiante(connection);
        daoEstudiante.delete(id);
    }

    public void createProfesor(Profesor profesor) {
        DAOProfesor daoProfesor = new DAOProfesor(connection);
        daoProfesor.create(profesor);
    }

    public Profesor readProfesor(int id) {
        DAOProfesor daoProfesor = new DAOProfesor(connection);
        return daoProfesor.read(id);
    }

    public void updateProfesor(Profesor profesor) {
        DAOProfesor daoProfesor = new DAOProfesor(connection);
        daoProfesor.update(profesor);
    }

    public void deleteProfesor(int id) {
        DAOProfesor daoProfesor = new DAOProfesor(connection);
        daoProfesor.delete(id);
    }

    public void createMateria(Materia materia) {
        DAOMateria daoMateria = new DAOMateria(connection);
        daoMateria.create(materia);
    }

    public Materia readMateria(int id) {
        DAOMateria daoMateria = new DAOMateria(connection);
        return daoMateria.read(id);
    }

    public void updateMateria(Materia materia) {
        DAOMateria daoMateria = new DAOMateria(connection);
        daoMateria.update(materia);
    }

    public void deleteMateria(int id) {
        DAOMateria daoMateria = new DAOMateria(connection);
        daoMateria.delete(id);
    }

    public void createHorario(Horario horario) {
        DAOHorario daoHorario = new DAOHorario(connection);
        daoHorario.create(horario);
    }

    public Horario readHorario(int id) {
        DAOHorario daoHorario = new DAOHorario(connection);
        return daoHorario.read(id);
    }

    public void updateHorario(Horario horario) {
        DAOHorario daoHorario = new DAOHorario(connection);
        daoHorario.update(horario);
    }

    public void deleteHorario(int id) {
        DAOHorario daoHorario = new DAOHorario(connection);
        daoHorario.delete(id);
    }
}
