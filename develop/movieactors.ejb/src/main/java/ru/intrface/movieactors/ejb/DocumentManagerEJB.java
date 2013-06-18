package ru.intrface.movieactors.ejb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.InvalidXMLException;


import ru.intrface.movieactors.annotators.BasicAEExHelperFactory;
import ru.intrface.movieactors.annotators.BasicAEExecuteHelper;
import ru.intrface.movieactors.ejb.exception.DataManagerException;
import ru.intrface.movieactors.ejb.util.PropertiesUtil;
import ru.intrface.movieactors.model.SourceDocument;
import ru.intrface.moviesactors.util.AEExecuteHelper;

/**
 * EJB для работами с документами системы
 * 
 * @author user
 * 
 */
@Stateless
public class DocumentManagerEJB {
	private static final Logger logger = Logger.getLogger(DataManagerEJB.class);
	
	@EJB
	DataManagerEJB dm;
	private String docsDir;

	@PostConstruct
	public void init() {
		docsDir = (String) PropertiesUtil.INSTANCE.getProps()
				.get("documentDir");
	}

	public void addDocument(String fileName, InputStream is) {
		logger.info("Adding file to system");
		SourceDocument doc = new SourceDocument();
		doc.setName(fileName);
		doc.setProcessed(false);
		doc.setHashName(fileName);
		doc.setUri(docsDir + "/" + doc.getHashName());

		File docFile = new File(doc.getUri());
		OutputStream os = null;
		try {
			os = new FileOutputStream(docFile);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = is.read(bytes)) != -1) {
				os.write(bytes, 0, read);
			}
			
			dm.save(doc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					// outputStream.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		logger.info("File has been saved on server. URI: " + doc.getUri());

	}

	public void removeDocument() {
		// TODO: реализовать метод
		throw new UnsupportedOperationException();
	}

	/**
	 * Статистика найденных данных по документу:<br>
	 * <ol>
	 * <li><b>тип named entity</b> : <i> количество</i></li>
	 * <li><b>тип named entity</b> : <i> количество найденных элементов</i></li>
	 * </ol>
	 * 
	 * @param doc
	 * @return
	 */
	public Object getDocumentStatistic(SourceDocument doc) {
		// TODO: реализовать метод
		throw new UnsupportedOperationException();
	}

	/**
	 * Получить статистику по всем документам заданного типа
	 * 
	 * @see DocumentManagerEJB#getDocumentsStatistic(Object)
	 * @param type
	 * @return
	 */
	public List<Object> getDocumentsStatistic(Object type) {
		// TODO: реализовать метод
		throw new UnsupportedOperationException();
	}

	/**
	 * Краткий отчет по документам, находящимся в системе
	 * 
	 * @return
	 */
	public Object getAllDocumentsShortReport() {
		// TODO: реализовать метод
		throw new UnsupportedOperationException();
	}

	/**
	 * Метод, вызываемый по таймеру для обработки документов, поступишвних в
	 * систему, но не прошедших через UIMA обработчик
	 * 
	 * @throws DataManagerException
	 * @throws IOException
	 * @throws ResourceInitializationException
	 * @throws InvalidXMLException
	 */
	public void processNewDocuments() throws DataManagerException,
			InvalidXMLException, ResourceInitializationException, IOException {
		// инициализаия аннтотаторов
		BasicAEExHelperFactory factory = new BasicAEExHelperFactory();
		BasicAEExecuteHelper aeHelper = factory.getAEHelper();
		aeHelper.produceAnalysisEngine(AEExecuteHelper.ACTOR_CHAR_ANNOT_URI);

		String qry = "SELECT sd " + "FROM " + "	SourceDocument " + "WHERE "
				+ "	sd.processed = false";
		List<SourceDocument> documents = dm
				.execQuery(SourceDocument.class, qry);

		for (SourceDocument doc : documents) {
			File docFile = new File(doc.getUri());
			try {
				aeHelper.analyseDocument(docFile);
			} catch (AnalysisEngineProcessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ResourceInitializationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		aeHelper.destroyAE();
		// TODO: реализовать метод

		// Получить новые документы

		// запустить аннотаторы
		throw new UnsupportedOperationException();
	}

	/**
	 * Принудительный вызов обработчика документов
	 */
	public void forceProcessNewDocuments() {
		// TODO: реализовать метод
		throw new UnsupportedOperationException();
	}

}
