package ru.intrface.movieactors.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Документ - источник данных для базы знаний
 * @author rusanov
 *
 */
@Entity
@Table(name = "source_document")
public class SourceDocument extends SystemObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1564687370619845738L;
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * URI докумнта
	 */
	private String uri;
	/**
	 * Наименование документа
	 */
	private String name;
	

}
