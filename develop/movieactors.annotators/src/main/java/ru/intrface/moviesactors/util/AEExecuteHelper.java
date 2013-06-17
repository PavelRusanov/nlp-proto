package ru.intrface.moviesactors.util;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.XMLInputSource;

/**
 * 
 * @author user
 *
 */
public abstract class AEExecuteHelper implements IAeExecuteHelper{
	public static final String ACTOR_CHAR_ANNOT_URI = "file:///home/user/work/"
			+ "uima/wspaces/wspace1/movieactors.annotators/desc/ActorCharacterAnnotatorDescriptor.xml";
	
	private static final Logger logger = Logger.getLogger(AEExecuteHelper.class
			.getName());
	
	private AnalysisEngine ae;
	
	public final void produceAnalysisEngine(String aeDescriptorURI)
			throws IOException, InvalidXMLException,
			ResourceInitializationException {
		if(ae==null){
			XMLInputSource in = new XMLInputSource(aeDescriptorURI);
	
			ResourceSpecifier specifier = UIMAFramework.getXMLParser()
					.parseResourceSpecifier(in);
	
			ae = UIMAFramework.produceAnalysisEngine(specifier);
			logger.info("Analysis engine has been produced");
		}
	}

	public void analyseDocument(String documentText)
			throws ResourceInitializationException,
			AnalysisEngineProcessException {
//		AnalysisEngine ae = produceAnalysisEngine();
		CAS cas = ae.newCAS();
		cas.setDocumentText(documentText);

		System.out.println(cas.getDocumentLanguage());

		ae.process(cas);
		annotationProcessing(cas);

		cas.reset();
		ae.destroy();
	}
	
	public void destroyAE(){
		if(ae!=null){
			ae.destroy();
			ae=null;
		}
	}

	public void analyseDocument(File docFile)
			throws ResourceInitializationException,
			AnalysisEngineProcessException, IOException {
		logger.info("starting analysing file " + docFile.getName());
		CAS cas = ae.newCAS();
		String documentText = FileUtils.file2String(docFile);
		cas.setDocumentText(documentText);

		ae.process(cas);
		annotationProcessing(cas);

		cas.reset();
//		ae.destroy();
		logger.info("File has been analysed");
	}

	/**
	 * Метод содержащий код для обработки аннотаций(реализуется в классах
	 * наследниках)
	 * 
	 * @param cas
	 */
	protected abstract void annotationProcessing(CAS cas);

}
