package ru.intrface.moviesactors.annotator;

import java.io.File;
import java.io.IOException;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.InvalidFormatException;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

public class MovieAnnotator extends JCasAnnotator_ImplBase{
	private final String OPENNLP_MODEL_DIR = "ru.intrface.OpenNlpModelsDir";
	private NameFinderME mNameFinder;
	
	@Override
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		String modelsPath = (String) aContext
				.getConfigParameterValue(OPENNLP_MODEL_DIR);
		try {
			mNameFinder = new NameFinderME(new TokenNameFinderModel(new File(
					modelsPath + "/en-ner-person.bin")));
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		
	}

}
