package ru.intrface.movieactors.model.question;

/**
 * Родительский класс для разбора вопросов в системе
 * @author user
 *
 */
public abstract class AbstractQuestion {
	/**  Текст вопроса*/
	private String text;
	/** 
	 * Флаг показывающий, является ли ответ списком
	 */
	private Boolean listAnswer;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(Boolean listAnswer) {
		this.listAnswer = listAnswer;
	}

}
