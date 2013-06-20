package ru.intrface.movieactors.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie extends SystemObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3242023784812701906L;
	
	private String name;
	private List<Actor2Character> cast;

	public List<Actor2Character> getCast() {
		return cast;
	}

	public void setCast(List<Actor2Character> cast) {
		this.cast = cast;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
