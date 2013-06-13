package ru.intrface.moviesactors.annotator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Span;
import opennlp.uima.namefind.NameFinder;
import opennlp.uima.util.AnnotationComboIterator;
import opennlp.uima.util.AnnotationIteratorPair;
import opennlp.uima.util.AnnotatorUtil;
import opennlp.uima.util.UimaUtil;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.CasAnnotator_ImplBase;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.TypeSystem;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import ru.intrface.moviesactors.Actor;

/**
 * Аннотатор, получающий связи между актером и его ролью
 * 
 * @author user
 * 
 */
public class NamedEntityAnnotator extends JCasAnnotator_ImplBase {
	/** Путь к каталогу с моделями*/
	private final String OPENNLP_MODEL_DIR = "ru.intrface.OpenNlpModelsDir";
	/** Модель для определения named entity */
	private final String NAMED_ENTITY_MODEL ="ru.intrface.NamedEntityModelName";
	
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

			mNameFinder = new NameFinderME(new TokenNameFinderModel(
					new File(modelsPath+"/"+NAMED_ENTITY_MODEL)));
			
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
		for (Span sentSpan : sentSpans) {
			String sentence = sentSpan.getCoveredText(text).toString();
			int start = sentSpan.getStart();
			Span[] tokSpans = tokenizer.tokenizePos(sentence);
			String[] tokens = new String[tokSpans.length];
			for (int i = 0; i < tokens.length; i++) {
				tokens[i] = tokSpans[i].getCoveredText(sentence).toString();
			}

			Span[] names = mNameFinder.find(tokens);

			// String[] tags = posTagger.tag(tokens);
			// Span[] chunks = chunker.chunkAsSpans(tokens, tags);

			for (Span name : names) {
				Actor annotation = new Actor(jCas);
				annotation.setBegin(start
						+ tokSpans[name.getStart()].getStart());
				annotation.setEnd(start + tokSpans[name.getEnd() - 1].getEnd());

				annotation.addToIndexes(jCas);
			}

			
		}

	}


}
