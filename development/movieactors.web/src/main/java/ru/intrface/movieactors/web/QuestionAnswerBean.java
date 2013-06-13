package ru.intrface.movieactors.web;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.apache.log4j.Logger;

import ru.intrface.movieactors.ejb.QuestionAnsweringEJB;
import ru.intrface.movieactors.model.question.MovieActorsQuestion;

@ManagedBean(name="questionAnswer")
public class QuestionAnswerBean {
	private static Logger logger = Logger.getLogger(QuestionAnswerBean.class);
	
	@EJB
	private QuestionAnsweringEJB qaEJB;
	
	private String questionAnswer;
	private String questionText;

	
	@PostConstruct
	public void init(){
		logger.info("QuestionAnswerBean has been created");
		questionText = "Insert question text";
		questionAnswer = "Imagine answer text here";
	}
	
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public void answerQuestion(){
		logger.info("Answer the question : "+ questionText);
		String answer = qaEJB.answerQuestion(qaEJB.parseQuestion(questionText,MovieActorsQuestion.class));
		questionAnswer = "Answer for question "+questionText + answer;
	}
	

}
