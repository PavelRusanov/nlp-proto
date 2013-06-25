package ru.intrface.movieactors.question;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.XMLInputSource;

import ru.intrface.movieactors.model.Actor;
import ru.intrface.movieactors.model.Character;
import ru.intrface.movieactors.model.Movie;
import ru.intrface.movieactors.model.question.MovieActorQuestionType;
import ru.intrface.movieactors.model.question.MovieActorsQuestion;
import ru.intrface.moviesactors.QuestionAnnotation;

/**
 * Р Р°Р·Р±РѕСЂС‰РёРє РІРѕРїСЂРѕСЃРѕРІ РґР»СЏ СЃРёСЃС‚РµРјС‹ С„РёР»СЊРјС‹-Р°РєС‚РµСЂС‹
 * 
 * @author rusanov, galitsky
 * 
 */
public class MovieActorsQuestionParser implements
		IQuestionParser<MovieActorsQuestion> {

	private static Logger logger = Logger
			.getLogger(MovieActorsQuestionParser.class);

	
	
	public MovieActorsQuestionParser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MovieActorsQuestion parseQuestion(String question) {
		
		XMLInputSource in;
		MovieActorsQuestion mva = new MovieActorsQuestion();
		
		try {
			in = new XMLInputSource(
					"file:C:/LacmusDev/git/nlp-proto/develop/movieactors.annotators/desc/QuestionDescriptor.xml");
			ResourceSpecifier specifier = UIMAFramework.getXMLParser()
					.parseResourceSpecifier(in);
		
			AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(specifier);
			
			CAS cas = ae.newCAS();
			cas.setDocumentText(question);
			
			ae.process(cas);
		
			FSIterator<AnnotationFS>iter = cas.getAnnotationIndex().iterator();
			while(iter.isValid()){
				AnnotationFS annot = (AnnotationFS)iter.get();
				 if(annot.getClass().equals(ru.intrface.moviesactors.QuestionAnnotation.class)){
					mva.setActor(new Actor(((QuestionAnnotation)annot).getActor()));
					mva.setCharacter(new Character(((QuestionAnnotation)annot).getRole()));
					mva.setMovie(new Movie(((QuestionAnnotation)annot).getFilm()));
					mva.setType(MovieActorQuestionType.valueOf(((QuestionAnnotation)annot).getQuestionType()));
				 }
				 iter.moveToNext();
			}
			cas.reset();
			ae.destroy();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AnalysisEngineProcessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidXMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
}
