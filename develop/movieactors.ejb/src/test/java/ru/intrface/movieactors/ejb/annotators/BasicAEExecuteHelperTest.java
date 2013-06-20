package ru.intrface.movieactors.ejb.annotators;

import java.io.File;
import java.io.IOException;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.InvalidXMLException;
import org.junit.Test;

import ru.intrface.movieactors.annotators.BasicAEExHelperFactory;
import ru.intrface.movieactors.annotators.BasicAEExecuteHelper;
import ru.intrface.moviesactors.util.AEExecuteHelper;

import junit.framework.TestCase;

public class BasicAEExecuteHelperTest extends TestCase {
//	private BasicAEExecuteHelper helper;
	
	private File testFile;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
//		BasicAEExHelperFactory factory = new BasicAEExHelperFactory();
//		helper = factory.getAEHelper();
		
		testFile = new File("/home/user/git/nlp-proto/develop/movieactors.annotators/testData/shawshankRed.txt");

	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	@Test
	public void testAnalyseDocument() throws AnalysisEngineProcessException, ResourceInitializationException, IOException, InvalidXMLException{
//		helper.produceAnalysisEngine(AEExecuteHelper.ACTOR_CHAR_ANNOT_URI);
//		helper.analyseDocument(testFile);
	}

}
