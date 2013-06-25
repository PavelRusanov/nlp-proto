package ru.intrface.movieactors.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import ru.intrface.movieactors.ejb.DataManagerEJB;
import ru.intrface.movieactors.ejb.exception.DataManagerException;
import ru.intrface.movieactors.model.Actor;
import ru.intrface.movieactors.model.Actor2Character;
import ru.intrface.movieactors.model.Movie;
import ru.intrface.movieactors.model.question.MovieActorsQuestion;

/**
 * 
 * @author rusanov
 *
 */
public class MovieActorsQuestionAnswerer implements IQuestionAnswerer<MovieActorsQuestion> {
	private Logger logger = Logger.getLogger(MovieActorsQuestionAnswerer.class);
	
	DataManagerEJB dm;
	
	public MovieActorsQuestionAnswerer() throws NamingException{
		logger.info("BasicAEExecuteHelper initializing... inject EJBs");
		InitialContext ctx = new InitialContext();
		dm = (DataManagerEJB) ctx.lookup("java:global/movieactors.ear/movieactors.ejb-0.0.1-SNAPSHOT/DataManagerEJB");
	}
	@Override
	public String answerQuestion(MovieActorsQuestion question) throws QuestionAnswererException {
		logger.info("Answering question");
		logger.info("Question params : "+question);
		
		String answer = "";
		try{
			switch (question.getType()) {
			case ACTOR_AS_CHARACTER_IN_MOVIE:
				answer = answerActorAsCharInMovieQuestion(question.getCharacter().getName(),
						question.getMovie().getName());
				
				break;
			default:
				answer = "Sorry I can't determine type of your question.";
			}
		}catch (DataManagerException e){
			logger.info("Error while answering question. DB error");
			throw new QuestionAnswererException("Oшибка при ответе на вопрос. Ошибка при взаимодействие с БД", e);
		}
		return answer;
	}
	
	
	private String answerActorAsCharInMovieQuestion(String character, String movie) throws DataManagerException{
		logger.info("prepare answer:" + character +", "+ movie);
		String answer = "";
		//1.Находим фильм в БД
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("mName", movie);
		String qry = "SELECT m FROM Movie m WHERE m.name like :mName";
		List<Movie> movies = dm.execParamsQuery(Movie.class, qry, params);
		//XXX: обработка нескольких фильмов
		Movie mv = movies.get(0);
		
		//2.получение нужых  id из списка ролей актеров данног фильма		
		List<String> performersId = new ArrayList<String>();
		for(Actor2Character performers : mv.getCast()){
			performersId.add(performers.getId());
		}
		
		//3.Получаем актеров в заданном фильм в заданной роли
		params = new HashMap<String, Object>();
		params.put("performers_ids",performersId);
		params.put("r_name", character);

		
		qry = 	"SELECT a2c.actor FROM Actor2Character a2c " +
				"WHERE" +
				"	a2c.role.name = :r_name " +
				"	AND a2c.id IN :performers_ids";
		List<Actor> actors = dm.execParamsQuery(Actor.class,qry,params);
//		String answer = "";
//		Map<String,Object> params = new HashMap<String, Object>();
////		params.put("tstId", "18");
//		params.put("rName", character);
//		params.put("mName", movie);
//		String qry = 	"SELECT a2c.actor FROM Actor2Character a2c " +
//				"WHERE" +
////				"	a2c.id = :tstId"; //+
////				"WHERE " +
//				"	a2c.role.name = :rName " +
//				"	AND a2c IN (" +
//				"		SELECT m.cast FROM Movie m" +
//				"		WHERE " +
//				"			m.name = :mName)";
////				"IN (" +
////				"		SELECT r FROM Role r " +
////				"		WHERE" +
////				"			r.name = :rName)"; //+
////				"	AND a2c IN (" +
////				"		SELECT m.cast FROM Movie m" +
////				"		WHERE " +
////				"			m.name = :mName)";
//		List<Actor> actors = dm.execParamsQuery(Actor.class, qry, params);
		switch (actors.size()) {
		case 0:
			answer = "Sorry there is now data about who played "+character+" in movie "+ movie;
			break;
		case 1:
			
			answer = actors.get(0).getName() + " played role of "+ character + " in movie "+ movie;
			break;
		default:
			break;
		}
		return answer;
	}

	
	
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
