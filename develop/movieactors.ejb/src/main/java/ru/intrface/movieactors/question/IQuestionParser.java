package ru.intrface.movieactors.question;

import ru.intrface.movieactors.model.question.AbstractQuestion;

/**
 * Интерфейс для разборщика вопросов, любой разборщик должен его реализовать
 * 
 * @author rusanov
 * 
 * @param <T> - класс вопроса, который получается в результате разбора
 * строки
 */
public interface IQuestionParser<T extends AbstractQuestion> {
	/**
	 * Разбор текста вопроса
	 * 
	 * @param question - текст вопроса для разбора
	 * @return - Вопрос в разобранной форме
	 */
	public T parseQuestion(String question);
}
