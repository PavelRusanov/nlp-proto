package ru.intrface.movieactors.ejb;

import javax.ejb.Stateless;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import ru.intrface.movieactors.model.question.AbstractQuestion;
import ru.intrface.movieactors.model.question.MovieActorsQuestion;
import ru.intrface.movieactors.question.IQuestionAnswerer;
import ru.intrface.movieactors.question.IQuestionParser;
import ru.intrface.movieactors.question.MovieActorsQuestionAnswerer;
import ru.intrface.movieactors.question.MovieActorsQuestionParser;
import ru.intrface.movieactors.question.QuestionAnswererException;

/**
 * Ejb для ответа на вопросы
 * @author user
 *
 */
@Stateless
public class QuestionAnsweringEJB {
	private Logger logger = Logger.getLogger(QuestionAnsweringEJB.class);
	/**
	 * Обработка строки вопроса
	 * @param <T> тип обрабатываемого вопроса
	 * @param questionStr - текст вопроса
	 * @return
	 */
	public <T extends AbstractQuestion> T parseQuestion(String questionStr,
			Class<T> questionClass){
		logger.info("Parse question [ type:"+questionClass.getSimpleName()+
				" question: "+ questionStr +" ]");
		IQuestionParser<T> parser = findProperlyParser(questionClass);
		return (T) parser.parseQuestion(questionStr);
	}
	
	/**
	 * Получения ответа по вопросу
	 * @param <T> - тип отвечаемого вопроса
	 * @param question - вопрос
	 * @return
	 * @throws QuestionAnswererException 
	 */
	public <T extends AbstractQuestion> String answerQuestion(Class<T> questionClass,T question) throws QuestionAnswererException{
		IQuestionAnswerer<T> questionAnswerer = findProperlyAnswer(questionClass);
		return questionAnswerer.answerQuestion(question);
	}

	/**
	 * Подтсановка правильного парсера в зависимости от типа вопроса/
	 * @param <T>
	 * @param questionClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T extends AbstractQuestion> IQuestionParser<T> findProperlyParser(Class<?> questionClass){
		return ((IQuestionParser<T>) new MovieActorsQuestionParser());
	}
	
	@SuppressWarnings("unchecked")
	private <M extends AbstractQuestion> IQuestionAnswerer<M> findProperlyAnswer(Class<?> questionClass){
		if(questionClass.equals(MovieActorsQuestion.class)){
			try {
				return (IQuestionAnswerer<M>) new MovieActorsQuestionAnswerer();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}
}
