package ru.intrface.moviesactors.annotator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import ru.intrface.moviesactors.QuestionAnnotation;

public class QuestionAnnotator extends JCasAnnotator_ImplBase {

	private static Logger logger = Logger
			.getLogger(QuestionAnnotation.class);
	
	static final Pattern whoQuestionPattern = Pattern.compile("(Who) (played|performed) (((\\w+)\\b\\s*)*) in the (film|movie|motion picture) (((\\w+)\\b\\s*)*)");
	static final Pattern whereQuestionPattern = Pattern
			.compile("(Where) did (((\\w+)\\b\\s*)*) (played|performed) (role|part) of (((\\w+)\\b\\s*)*) ?");
	static final Pattern where2QuestionPattern = Pattern
			.compile("(Where) did (((\\w+)\\b\\s*)*) (took part) of (((\\w+)\\b\\s*)*) ?");
	static final Pattern whatQuestionPattern = Pattern
			.compile("In what (films|movies|motion pictures) has (((\\w+)\\b\\s*)*) (played|acted|performed)* ?");
	static final Pattern what2QuestionPattern = Pattern
			.compile("What actors (played|performed|appeared) in the (movie|film|motion picture) (((\\w+)\\b\\s*)*) ?");

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub

		aJCas.getDocumentLanguage();
		String content = aJCas.getDocumentText();

		makeDateAnnotation(aJCas, content, whoQuestionPattern,
				"ACTOR_AS_CHARACTER_IN_MOVIE");
		makeDateAnnotation(aJCas, content, whereQuestionPattern,
				"MOVIE_WHERE_ACTOR_PLAYS_ROLE");
		makeDateAnnotation(aJCas, content, where2QuestionPattern,
				"MOVIE_WHERE_ACTOR_PLAYS_ROLE");
		makeDateAnnotation(aJCas, content, whatQuestionPattern,
				"ACTOR_MOVIES_LIST");
		makeDateAnnotation(aJCas, content, what2QuestionPattern,
				"MOVIE_ACTORS_LIST");

	}

	private void makeDateAnnotation(JCas jcas, String content,
			Pattern datePattern, String questionType) {
		logger.info("questionType : " + questionType);
		Matcher matcher = datePattern.matcher(content);
		int pos = 0;

		while (matcher.find(pos)) {
			QuestionAnnotation questionAnnot = new QuestionAnnotation(jcas);

			questionAnnot.setBegin(matcher.start());

			questionAnnot.setEnd(matcher.end());		
			questionAnnot.setQuestionType(questionType);
			
			addinVariables(matcher, questionType, questionAnnot);
			logger.info("words : "+ questionAnnot.getRole()+ " & "+questionAnnot.getFilm());
			questionAnnot.addToIndexes();
			pos = matcher.end();
		}
	}

	private void addinVariables(Matcher matcher, String questionType,
			QuestionAnnotation questionAnnot) {
		switch (questionType) {
		case "ACTOR_AS_CHARACTER_IN_MOVIE":
			questionAnnot.setRole(matcher.group(3));
			questionAnnot.setFilm(matcher.group(7));
			break;
		case "MOVIE_WHERE_ACTOR_PLAYS_ROLE":
			if (matcher.group(5).equals("took part"))
				questionAnnot.setRole(matcher.group(6));
			else
				questionAnnot.setRole(matcher.group(7));
			questionAnnot.setActor(matcher.group(2));
			break;
		case "ACTOR_MOVIES_LIST":
			questionAnnot.setActor(matcher.group(2));
			System.out.println(matcher.group(2));
			break;
		case "MOVIE_ACTORS_LIST":
			questionAnnot.setFilm(matcher.group(3));
			System.out.println(matcher.group(3));
			break;
		default:
			break;
		}

	}

}
