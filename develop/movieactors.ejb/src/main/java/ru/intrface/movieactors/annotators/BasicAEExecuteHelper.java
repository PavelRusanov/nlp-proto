package ru.intrface.movieactors.annotators;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationFS;

import ru.intrface.movieactors.ejb.DataManagerEJB;
import ru.intrface.movieactors.ejb.exception.DataManagerException;
import ru.intrface.movieactors.model.Actor;
import ru.intrface.movieactors.model.Actor2Character;
import ru.intrface.movieactors.model.Movie;
import ru.intrface.movieactors.model.Role;

import ru.intrface.moviesactors.util.AEExecuteHelper;
import ru.intrface.moviesactors.util.IAeExecuteHelper;

/**
 * 
 * @author rusanov
 *
 */
public class BasicAEExecuteHelper  extends AEExecuteHelper implements IAeExecuteHelper{
		
	private static final Logger logger = Logger.getLogger(BasicAEExecuteHelper.class);
	
	private DataManagerEJB dm;
	
	public void init() throws NamingException{
		logger.info("BasicAEExecuteHelper initializing... inject EJBs");
		InitialContext ctx = new InitialContext();
		//XXX: сделать нормальный лукап
		dm = (DataManagerEJB) ctx.lookup("java:global/movieactors.ear/movieactors.ejb-0.0.1-SNAPSHOT/DataManagerEJB");
		logger.info("BasicAEExecuteHelper has been initialized");
	}
	
	@Override
	protected void annotationProcessing(CAS cas) {	
		logger.info("Processing annotations");
		FSIterator<AnnotationFS> iter = cas.getAnnotationIndex().iterator();
		List<Actor2Character> actorsCharacters = new ArrayList<Actor2Character>();
		Movie movie = new Movie();
		
		while(iter.isValid()){
			
			AnnotationFS annot = (AnnotationFS) iter.get();
			logger.info("Annotation type:"+annot.getType());
			
			if(annot.getClass().equals(ru.intrface.moviesactors.Actor2Character.class)){
				ru.intrface.moviesactors.Actor2Character actor2CharAnnot = (ru.intrface.moviesactors.Actor2Character) annot;
				
				Actor actor = new Actor();
				actor.setName(actor2CharAnnot.getActor().getName());
				
				Role character = new Role();
				character.setName(actor2CharAnnot.getCharacter().getName());
				
				Actor2Character actor2Char = new Actor2Character();
				actor2Char.setActor(actor);
				actor2Char.setRole(character);
				
				actorsCharacters.add(actor2Char);
			}
			
			if(annot.getClass().equals(ru.intrface.moviesactors.Movie.class)){
				ru.intrface.moviesactors.Movie movieAnnot = (ru.intrface.moviesactors.Movie) annot;
				movie.setName(movieAnnot.getName());
			}
			
			iter.moveToNext();
		}
		
		movie.setCast(actorsCharacters);
		
		try {
			dm.save(movie);
		} catch (DataManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
