package ru.intrface.movieactors.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="actor")
public class Actor extends SystemObject {

	private static final long serialVersionUID = 6768638259719894457L;
	
	private String name;

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actor(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
