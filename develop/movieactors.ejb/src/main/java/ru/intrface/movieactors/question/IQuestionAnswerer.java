package ru.intrface.movieactors.question;

import ru.intrface.movieactors.model.question.AbstractQuestion;

public interface IQuestionAnswerer<T extends AbstractQuestion> {
	public String answerQuestion(T question);
}
