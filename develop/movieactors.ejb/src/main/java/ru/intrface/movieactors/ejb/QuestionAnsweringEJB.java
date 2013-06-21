package ru.intrface.movieactors.ejb;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import ru.intrface.movieactors.model.question.AbstractQuestion;
import ru.intrface.movieactors.question.IQuestionParser;
import ru.intrface.movieactors.question.MovieActorsQuestionParser;

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
	 */
	public <T extends AbstractQuestion> String answerQuestion(T question){
		throw new UnsupportedOperationException();
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
		//throw new UnsupportedOperationException();
	}
}
