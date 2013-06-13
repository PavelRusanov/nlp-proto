package ru.intrface.movieactors.model.question;

import ru.intrface.movieactors.model.Actor;
import ru.intrface.movieactors.model.Movie;

/**
 * 
 * Разобранный вопрос по фильмам/актерам/ролям
 * @author rusanov
 *
 */
public class MovieActorsQuestion extends AbstractQuestion{
	private MovieActorQuestionType type;
	private Movie movie;
	private Actor actor;
	private Character character;
	
	public MovieActorQuestionType getType() {
		return type;
	}
	public void setType(MovieActorQuestionType type) {
		this.type = type;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
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
