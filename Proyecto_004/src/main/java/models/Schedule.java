package models;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Schedule {
	@Id
	private int id_mat;
	
	@Column(name="id_alumno")
	private int id_alumno;

	@Column(name="id_profesor")
	private int id_profesor;

	@Column(name="hora_inicio")
	private Time hora_inicio;
	
	@Column(name="hora_fin")
	private Time hora_fin;
	
	public Schedule() {
		
	}

	public Schedule(int id_mat, int id_alumno, int id_profesor, Time hora_inicio, Time hora_fin) {
		super();
		this.id_mat = id_mat;
		this.id_alumno = id_alumno;
		this.id_profesor = id_profesor;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}

	public int getId_mat() {
		return id_mat;
	}

	public void setId_mat(int id_mat) {
		this.id_mat = id_mat;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public int getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}

	public Time getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Time getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Time hora_fin) {
		this.hora_fin = hora_fin;
	}

	public void setIdProfessor(int idProfessor) {
		// TODO Auto-generated method stub
		
	}
	
	

}
