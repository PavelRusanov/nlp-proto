

import java.io.File;
import java.io.IOException;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.XMLInputSource;

public class AnnotatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLInputSource in;
		try {
			in = new XMLInputSource(
					"file:///home/user/work/uima/wspaces/wspace1/movieactors.annotators/desc/ActorCharacterAnnotatorDescriptor.xml");

			ResourceSpecifier specifier = UIMAFramework.getXMLParser()
					.parseResourceSpecifier(in);

			AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(specifier);

			CAS cas = ae.newCAS();
			File document = new File("/home/user/work/uima/wspaces/wspace1/movieactors.annotators/testData/shawshankRed.txt");
			String text = FileUtils.file2String(document);
			cas.setDocumentText(text);
			
			System.out.println(cas.getDocumentLanguage());

			ae.process(cas);
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

	}

}
