package ru.intrface.movieactors.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="character_tbl")
public class Role extends SystemObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1448100850307140880L;
	
	private String name;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String name) {
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
