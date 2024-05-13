package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="materia")
public class Subject {
	@Id
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="level")
	private int level;
	
	public Subject() {
		
	}

	public Subject(int id, String name, String descrition, int level) {
		super();
		this.id = id;
		this.name = name;
		this.description = descrition;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrition() {
		return description;
	}

	public void setDescrition(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
