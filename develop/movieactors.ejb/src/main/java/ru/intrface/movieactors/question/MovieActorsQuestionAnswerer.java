package ru.intrface.movieactors.question;

import ru.intrface.movieactors.ejb.DataManagerEJB;
import ru.intrface.movieactors.model.question.MovieActorsQuestion;

public class MovieActorsQuestionAnswerer implements IQuestionAnswerer<MovieActorsQuestion> {
	
	DataManagerEJB dm;
	
	public MovieActorsQuestionAnswerer(){
		
	}
	@Override
	public String answerQuestion(MovieActorsQuestion question) {
		String answer = "";
//		question.getType().
		switch (question.getType()) {
		case ACTOR_AS_CHARACTER_IN_MOVIE:
			
			break;

		default:
			answer = "Sorry I can't determine type of your question.";
		}
		return answer;
	}
	
//	"SELECT a2c FROM Actor2Character a2c " +
//	"WHERE " +
//	"	a2c.actor = (" +
//	"		SELECT a FROM Actor a" +
//	"		WHERE" +
//	"			a.name = :aName)" +
//	"	AND a2c.id IN (" +
//	"		SELECT	ma2c."
//	SELECT a2c.* from ACTOR_CHARACTER a2c
//	WHERE
//		a2c.ACTOR_ID = (
//			SELECT a.id FROM ACTOR a 
//			WHERE 
//				a.NAME like 'William Sadler') 
//		AND a2c.ID IN (
//			SELECT ma2c.ACTOR2CHAR_ID FROM MOVIE_ACTORCHARS ma2c 
//			WHERE 
//				ma2c.MOVIE_ID =(
//					SELECT m.id FROM Movie m 
//					WHERE 
//						m.name = 'The Shawshank Redemption.')
//			)

}
