package ru.intrface.movieactors.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.Test;

import ru.intrface.movieactors.ejb.exception.DataManagerException;
import ru.intrface.movieactors.model.Actor;
import ru.intrface.movieactors.model.Actor2Character;
import ru.intrface.movieactors.model.Movie;

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
		
		dataManager.save(actor);
		assertNotNull("Actor id", actor.getId());
		
		dataManager.delete(Actor.class, actor.getId());	
	}

	@Test
	public void testExecParamsQuery() throws NamingException, DataManagerException{
		DataManagerEJB dataManager = (DataManagerEJB) getBean(DataManagerEJB.class);

		String answer = "";
		//фильм
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("mName", "The Shawshank Redemption.");
		String qry = "SELECT m FROM Movie m WHERE m.name = :mName";
		List<Movie> movies = dataManager.execParamsQuery(Movie.class, qry, params);
		Movie mv = movies.get(0);
		//получение нужы id		
		List<String> performersId = new ArrayList<String>();
		for(Actor2Character performers : mv.getCast()){
			performersId.add(performers.getId());
		}
		//
		params = new HashMap<String, Object>();
		params.put("performers_ids",performersId);
		params.put("r_name", "Andy Dufresne");

		
		qry = 	"SELECT a2c.actor FROM Actor2Character a2c " +
				"WHERE" +
				"	a2c.role.name = :r_name " +
				"	AND a2c.id IN :performers_ids";
		List<Actor> actors = dataManager.execParamsQuery(Actor.class,qry,params);
		
		
	}
	@Override
	protected void tearDown() throws Exception {
		logger.info("Shutdown EJB container");
		if(container!=null)
			container.close();
		container=null;
	}
	
	public Object getBean(Class<?> ejbClass) throws NamingException{
		return container.getContext().lookup("java:global/movieactors.ejb/"+ejbClass.getSimpleName());
	}
	
	
	

}
