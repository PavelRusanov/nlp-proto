package ru.intrface.moviesactors.annotator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Span;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import ru.intrface.moviesactors.Actor;
import ru.intrface.moviesactors.Actor2Character;
import ru.intrface.moviesactors.Character;
import ru.intrface.moviesactors.Movie;

/**
 * Аннотатор, получающий связи между актером и его ролью
 * 
 * @author user
 * 
 */
public class ActorCharacterAnnotator extends JCasAnnotator_ImplBase {
	private final String OPENNLP_MODEL_DIR = "ru.intrface.OpenNlpModelsDir";
	private NameFinderME mNameFinder;

	private SentenceDetectorME sentenceDetector;

	private TokenizerME tokenizer;

	@Override
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			String modelsPath = (String) aContext
					.getConfigParameterValue(OPENNLP_MODEL_DIR);
			InputStream modelIn = new FileInputStream(modelsPath
					+ "/en-sent.bin");
			SentenceModel model = new SentenceModel(modelIn);
			sentenceDetector = new SentenceDetectorME(model);

			InputStream tokenizeMdl = new FileInputStream(modelsPath
					+ "/en-token.bin");
			TokenizerModel tModel = new TokenizerModel(tokenizeMdl);
			tokenizer = new TokenizerME(tModel);

			mNameFinder = new NameFinderME(
					new TokenNameFinderModel(
							new File(modelsPath+
									"/en-ner-person.bin")));
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		String text = jCas.getDocumentText();
		Span[] sentSpans = sentenceDetector.sentPosDetect(jCas
				.getDocumentText());
		//аннотация для фильма
		Movie movieTitleAnnot = new Movie(jCas);
		movieTitleAnnot.setName(sentSpans[0].getCoveredText(text).toString());
		movieTitleAnnot.setBegin(sentSpans[0].getStart());
		movieTitleAnnot.setEnd(sentSpans[0].getEnd());
		movieTitleAnnot.addToIndexes(jCas);
		
		
		//аннотирования актеров и их ролей
		for (Span sentSpan : sentSpans) {
			String sentence = sentSpan.getCoveredText(text).toString();
			int start = sentSpan.getStart();
			Span[] tokSpans = tokenizer.tokenizePos(sentence);
			String[] tokens = new String[tokSpans.length];
			for (int i = 0; i < tokens.length; i++) {
				tokens[i] = tokSpans[i].getCoveredText(sentence).toString();
			}

			//находим имена в предложение через OpenNlp
			List<Span> names =  Arrays.asList(mNameFinder.find(tokens));
			for(Span name : names){
				String nameText = getEntityFullText(name.getStart(), 
						name.getEnd(), tokSpans, sentence);
				String newLine = System.getProperty("line.separator");
				if(nameText.contains(newLine)){
//					int index = 0;
					int index = nameText.indexOf(newLine);
					System.out.println("initial index: "+index);
					while(index>0){
						index = nameText.indexOf(newLine, index+1);
						System.out.println("index: "+index);
					}

				}
//				Span newSpan = new 
				System.out.println("name: "+nameText);
			}
			Iterator<Span> namesSpanIt = names.iterator();
			
			int i = 0;
			
			while(namesSpanIt.hasNext()){
				i++;
				
				Span name = namesSpanIt.next();
				if(tokens.length>name.getEnd() && tokens[name.getEnd()].toLowerCase().equals("as")&& 
						namesSpanIt.hasNext()){
					//берем следующее найденной имя и проверяем идет ли оно за союзом as
					Span nextName = names.get(i);
					
					if(nextName.getStart()==(name.getEnd()+1)){
						//создаем аннотацию для актера
						Actor actorAnnot = new Actor(jCas);
						actorAnnot.setBegin(start
								+ tokSpans[name.getStart()].getStart());
						actorAnnot.setEnd(start + tokSpans[name.getEnd() - 1].getEnd());	
						//получаем имя актера
						actorAnnot.setName(getEntityText(name.getStart(), name.getEnd(), tokens));
						
//						annotation.addToIndexes(jCas);
						
						//создаем аннотацию для роли актера
						Character charAnnot = new Character(jCas);
						charAnnot.setBegin(tokSpans[nextName.getStart()].getStart());
						charAnnot.setEnd(start + tokSpans[nextName.getEnd() - 1].getEnd());
						charAnnot.setName(getEntityText(nextName.getStart(), nextName.getEnd(), tokens));
//						charAnnot.addToIndexes(jCas);
						
						//аннотация для связок - актер/роль
						Actor2Character actor2CharacterAnnot = new Actor2Character(jCas);
						actor2CharacterAnnot.setActor(actorAnnot);
						actor2CharacterAnnot.setCharacter(charAnnot);
						actor2CharacterAnnot.setBegin(actorAnnot.getBegin());
						actor2CharacterAnnot.setEnd(charAnnot.getEnd());
						actor2CharacterAnnot.addToIndexes(jCas);
						
						System.out.println("Actor: "+ getEntityText(name.getStart(), name.getEnd(), tokens)+
								" plays "+getEntityText(nextName.getStart(), nextName.getEnd(), tokens));
						
						//
						namesSpanIt.next();
						i++;
					}
					
				}
					
			}
			
		}

	}

	private String getEntityText(int startSpan,int endSpan,String[] tokens){
		StringBuilder sb = new StringBuilder();
		for(int i= startSpan;i< endSpan;i++){
			sb.append(tokens[i]).append(" ");
		}
		
		return sb.substring(0, sb.length()-1);
	}
	
	private String getEntityFullText(int startSpan,int endSpan,
			Span[] tokSpans, String sentence){
		String text="";
		int begin = tokSpans[startSpan].getStart();
		int end = tokSpans[endSpan-1].getEnd();
		text = sentence.substring(begin, end);
		return text;
	}
	
	

//	private <T extends Person> T createPersonAnnotation(
//			int begin, int end, String name, JCas jCas,
//			Class<T> tClass) throws InstantiationException, IllegalAccessException{
//		T personAnnotation = tClass.
//		personAnnotation.set
//		
//		return personAnnotation;
//		
//	}

}
