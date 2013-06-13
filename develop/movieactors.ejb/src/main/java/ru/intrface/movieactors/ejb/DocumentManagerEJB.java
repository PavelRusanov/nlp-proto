package ru.intrface.movieactors.ejb;

import java.util.List;

import javax.ejb.Stateless;

import ru.intrface.movieactors.model.SourceDocument;

/**
 * EJB для работами с документами системы
 * @author user
 *
 */
@Stateless
public class DocumentManagerEJB {
	public void addDocument(){
		//TODO: реализовать метод
		throw new UnsupportedOperationException();
	}
	
	public void removeDocument(){
		//TODO: реализовать метод
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Статистика найденных данных по документу:<br>
	 * <ol>
	 * <li><b>тип named entity</b> : <i> количество</i></li>
	 * <li><b>тип named entity</b> : <i> количество найденных элементов</i></li>
	 * </ol>
	 * @param doc
	 * @return
	 */
	public Object getDocumentStatistic(SourceDocument doc){
		//TODO: реализовать метод
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Получить статистику по всем документам заданного типа 
	 * @see  DocumentManagerEJB#getDocumentsStatistic(Object)
	 * @param type
	 * @return
	 */
	public List<Object> getDocumentsStatistic(Object type){
		//TODO: реализовать метод
				throw new UnsupportedOperationException();
	}
	
	/**
	 * Краткий отчет по документам, находящимся в системе
	 * @return
	 */
	public Object getAllDocumentsShortReport(){
		//TODO: реализовать метод
		throw new UnsupportedOperationException();
	}
	
	
	
	/**
	 * Метод, вызываемый по таймеру для обработки документов, поступишвних
	 * в систему, но не прошедших через UIMA обработчик
	 */
	public void processNewDocuments(){
		//TODO: реализовать метод
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Принудительный вызов обработчика документов
	 */
	public void forceProcessNewDocuments(){
		//TODO: реализовать метод
		throw new UnsupportedOperationException();
	}
	
	
}
