package ru.intrface.movieactors.annotators;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.apache.uima.cas.CAS;

import ru.intrface.movieactors.ejb.DataManagerEJB;
import ru.intrface.moviesactors.util.AEExecuteHelper;
import ru.intrface.moviesactors.util.IAeExecuteHelper;

/**
 * 
 * @author rusanov
 *
 */
public class BasicAEExecuteHelper  extends AEExecuteHelper implements IAeExecuteHelper{
		
	private static final Logger logger = Logger.getLogger(BasicAEExecuteHelper.class
			.getName());
	private DataManagerEJB dm;
	
	public void init() throws NamingException{
		logger.info("BasicAEExecuteHelper initializing... inject EJBs");
		InitialContext ctx = new InitialContext();
		dm = (DataManagerEJB) ctx.lookup("java:global/movieactors.ejb/DataManagerEJB");
		logger.info("BasicAEExecuteHelper has been initialized");
	}
	
	@Override
	protected void annotationProcessing(CAS cas) {		
		logger.info("Processing annotations");
	}
	
	

}
