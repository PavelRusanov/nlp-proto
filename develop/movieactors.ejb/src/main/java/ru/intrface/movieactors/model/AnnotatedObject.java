package ru.intrface.movieactors.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * Данные по UIMA аннотациям
 * 
 * @author rusanov
 * 
 */
@Entity
@Table(name = "annotated_object")
public class AnnotatedObject extends SystemObject {

	private static final long serialVersionUID = 6341223186592835839L;
	private SourceDocument srcDoc;
	private Long startPos;
	private Long endPos;

	/**
	 * Класс UIMA аннотаций
	 */
	private String uimaAnnotationClassName;

	// Связь с объектом системы
	private String sysObjId;
	private String sysObjClass;

	public String getSysObjId() {
		return sysObjId;
	}

	public void setSysObjId(String sysObjId) {
		this.sysObjId = sysObjId;
	}

	public String getSysObjClass() {
		return sysObjClass;
	}

	public void setSysObjClass(String sysObjClass) {
		this.sysObjClass = sysObjClass;
	}

	public SourceDocument getSrcDoc() {
		return srcDoc;
	}

	public void setSrcDoc(SourceDocument srcDoc) {
		this.srcDoc = srcDoc;
	}

	public Long getStartPos() {
		return startPos;
	}

	public void setStartPos(Long startPos) {
		this.startPos = startPos;
	}

	public Long getEndPos() {
		return endPos;
	}

	public void setEndPos(Long endPos) {
		this.endPos = endPos;
	}

	public String getUimaAnnotationClassName() {
		return uimaAnnotationClassName;
	}

	public void setUimaAnnotationClassName(String uimaAnnotationClassName) {
		this.uimaAnnotationClassName = uimaAnnotationClassName;
	}

}
