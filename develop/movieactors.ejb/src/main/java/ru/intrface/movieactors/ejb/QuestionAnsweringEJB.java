package ru.intrface.movieactors.ejb;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import ru.intrface.movieactors.model.question.AbstractQuestion;
import ru.intrface.movieactors.model.question.MovieActorsQuestion;
import ru.intrface.movieactors.question.IQuestionAnswerer;
import ru.intrface.movieactors.question.IQuestionParser;
import ru.intrface.movieactors.question.MovieActorsQuestionAnswerer;

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
				"question: "+ questionStr +" ]");
		IQuestionParser<T> parser = findProperlyParser(questionClass);
		return (T) parser.parseQuestion(questionStr);
	}
	
	/**
	 * Получения ответа по вопросу
	 * @param <T> - тип отвечаемого вопроса
	 * @param question - вопрос
	 * @return
	 */
	public <T extends AbstractQuestion> String answerQuestion(Class<T> questionClass,T question){
		IQuestionAnswerer<T> questionAnswerer = findProperlyAnswer(questionClass);
		return questionAnswerer.answerQuestion(question);
	}

	/**
	 * Подтсановка правильного парсера в зависимости от типа вопроса/
	 * @param <T>
	 * @param questionClass
	 * @return
	 */
	private <T extends AbstractQuestion> IQuestionParser<T> findProperlyParser(Class<?> questionClass){
		//TODO: 
		throw new UnsupportedOperationException();
	}
	
	@SuppressWarnings("unchecked")
	private <M extends AbstractQuestion> IQuestionAnswerer<M> findProperlyAnswer(Class<?> questionClass){
		if(questionClass.equals(MovieActorsQuestion.class)){
			return (IQuestionAnswerer<M>) new MovieActorsQuestionAnswerer();
		}
		return null;
		
	}
}
