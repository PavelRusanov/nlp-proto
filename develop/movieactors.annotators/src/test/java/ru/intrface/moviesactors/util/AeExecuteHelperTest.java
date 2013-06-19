package ru.intrface.moviesactors.util;

import java.io.IOException;

import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.InvalidXMLException;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class AeExecuteHelperTest extends TestCase {
	private AEExecuteHelper helper;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		helper = Mockito.mock(AEExecuteHelper.class,Mockito.CALLS_REAL_METHODS);
		
	}

	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	@Test
	public void testProduceAnalysisEngine() throws Exception{
		System.out.println("hello world");
		helper.produceAnalysisEngine(AEExecuteHelper.ACTOR_CHAR_ANNOT_URI);
	}
}
