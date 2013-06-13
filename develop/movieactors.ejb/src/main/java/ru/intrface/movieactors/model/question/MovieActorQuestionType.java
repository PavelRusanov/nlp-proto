package ru.intrface.movieactors.model.question;

/**
 * Типы вопросов
 * @author rusanov
 *
 */
public enum MovieActorQuestionType {
	ACTOR_MOVIES_LIST, //список фильмов, в которых появился данный актер
	MOVIE_ACTORS_LIST, //Список актеоров, которые играли в заданном фильме
	ACTOR_AS_CHARACTER_IN_MOVIE,//актер играющий заданную роль в заданном фильме,
	MOVIE_WHERE_ACTOR_PLAYS_ROLE//фильм, в котором заданный актер играет заданную роль;
	
}
