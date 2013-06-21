package ru.intrface.movieactors.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie extends SystemObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3242023784812701906L;

	private String name;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "movie_actorchars", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor2char_id"))
	private List<Actor2Character> cast;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String name) {
		super();
		this.name = name;
	}

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
