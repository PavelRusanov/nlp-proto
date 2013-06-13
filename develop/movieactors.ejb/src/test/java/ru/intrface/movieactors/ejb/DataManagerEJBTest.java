package ru.intrface.movieactors.ejb;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;

import ru.intrface.movieactors.model.Actor;

import junit.framework.TestCase;

public class DataManagerEJBTest extends TestCase {
	private static Logger logger = Logger.getLogger(DataManagerEJBTest.class);
	private EJBContainer container;
//	
//	private DataManagerEJB dataManager;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		logger.info("creating EJB container");
		Map<String,Object> props = new HashMap<String,Object>();
		props.put(EJBContainer.APP_NAME, "movieactors.ejb");
		props.put("org.glassfish.ejb.embedded.glassfish.installation.root", "./glassfish-install/glassfish");
		container = EJBContainer.createEJBContainer(props);
		logger.info("EJB container has been created");
//		
//		DataSource datasource = (DataSource) container.getContext().lookup("jdbc/movieactorsderby"); //You can lookup the datasource too, to confirm that your setup is successful.
		
	}
	@Test
	public void testSave() throws Exception{
		logger.info("Test saving entities in DB");
		Actor actor = new Actor();
		actor.setName("Dustin Hoffman");
		DataManagerEJB dataManager = (DataManagerEJB) getBean(DataManagerEJB.class);
		assertNotNull("Testing embedded container", dataManager);
//		
		dataManager.save(actor);
		assertNotNull("Actor id", actor.getId());
		
		dataManager.delete(Actor.class, actor.getId());
		
		
		
	}

	@Override
	protected void tearDown() throws Exception {
		logger.info("Shutdown EJB container");
		if(container!=null)
			container.close();
		container=null;
	}
	
	public Object getBean(Class<?> ejbClass) throws NamingException{
//		String appName = (String) container.getContext().lookup("java:app/AppName");
		return container.getContext().lookup("java:global/movieactors.ejb/"+ejbClass.getSimpleName());
//		return container.getContext().
//				lookup("java:global/"+appName+"/ru.intrface.movieactors.ejb/"
//				+ejbClass.getSimpleName()+"!"+ejbClass.getName());
	}
	
	
	

}
