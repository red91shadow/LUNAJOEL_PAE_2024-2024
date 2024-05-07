package model;

import java.sql.Time;

public class Horario {

    private int id;
    private int idMateria;
    private int idEstudiante;
    private int idProfesor;
    private Time horaInicio;
    private Time horaFinalizacion;
    
    public Horario(int id, int idMateria, int idEstudiante, int idProfesor, Time horaInicio, Time horaFinalizacion) {
        this.id = id;
        this.idMateria = idMateria;
        this.idEstudiante = idEstudiante;
        this.idProfesor = idProfesor;
        this.horaInicio = horaInicio;
        this.horaFinalizacion = horaFinalizacion;
    }



   

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFinalizacion() {
		return horaFinalizacion;
	}

	public void setHoraFinalizacion(Time horaFinalizacion) {
		this.horaFinalizacion = horaFinalizacion;
	}



    
}
