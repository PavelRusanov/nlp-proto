package ru.intrface.movieactors.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="actor_character")
public class Actor2Character extends SystemObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5519496684427457139L;
	private Actor actor;
	private Character character;
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	
}
