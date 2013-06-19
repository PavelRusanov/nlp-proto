package ru.intrface.movieactors.ejb;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

public class DocumentManagerEJBTest extends TestCase {
	private static Logger logger = Logger.getLogger(DataManagerEJBTest.class);
	private EJBContainer container;

	@Override
	public void setUp() throws Exception {
		super.setUp();
//		logger.info("creating EJB container");
//		Map<String, Object> props = new HashMap<String, Object>();
//		props.put(EJBContainer.APP_NAME, "movieactors.ejb");
//		props.put("org.glassfish.ejb.embedded.glassfish.installation.root",
//				"./glassfish-install/glassfish");
//		container = EJBContainer.createEJBContainer(props);
//		logger.info("EJB container has been created");
	}

	@Override
	public void tearDown() throws Exception {
		logger.info("Shutdown EJB container");
		if(container!=null)
			container.close();
		container=null;
	}

	@Test
	public void testAddDocument() throws NamingException, FileNotFoundException {
//		DocumentManagerEJB docMngr = (DocumentManagerEJB) getBean(DocumentManagerEJB.class);
//		assertNotNull("Testing embedded container", docMngr);
//		
//		InputStream is = new FileInputStream("/home/user/test.png");
//		docMngr.addDocument("testDoc", is);
	}
	
	public Object getBean(Class<?> ejbClass) throws NamingException{
		return container.getContext().lookup("java:global/movieactors.ejb/"+ejbClass.getSimpleName());
	}

}
