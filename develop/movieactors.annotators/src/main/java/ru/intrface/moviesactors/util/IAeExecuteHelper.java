package ru.intrface.moviesactors.util;

import java.io.File;
import java.io.IOException;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.InvalidXMLException;

/**
 * 
 * @author rusanov
 *
 */
public interface IAeExecuteHelper {
	public void analyseDocument(File docFile)
			throws ResourceInitializationException,
			AnalysisEngineProcessException, IOException;
	
	public void destroyAE();
	
	public void produceAnalysisEngine(String aeDescriptorURI) throws IOException, InvalidXMLException, ResourceInitializationException;
}
