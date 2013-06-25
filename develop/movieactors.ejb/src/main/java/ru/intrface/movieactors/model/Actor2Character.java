package ru.intrface.movieactors.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="actor_character")
public class Actor2Character extends SystemObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5519496684427457139L;
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
	private Actor actor;
	

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "fk_character")
	private Role role;
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
