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
	 * URI документа
	 */
	private String uri;
	/**
	 * Наименование документа
	 */
	private String name;
	
	/**
	 * документ обработан?
	 */
	private boolean processed;
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

	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	
	
	

}
