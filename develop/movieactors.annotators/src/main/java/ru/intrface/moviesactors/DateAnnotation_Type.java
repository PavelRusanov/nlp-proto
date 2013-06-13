
/* First created by JCasGen Thu May 16 17:48:43 MSK 2013 */
package ru.intrface.moviesactors;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue May 21 16:43:58 MSK 2013
 * @generated */
public class DateAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DateAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DateAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DateAnnotation(addr, DateAnnotation_Type.this);
  			   DateAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DateAnnotation(addr, DateAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DateAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("ru.intrface.moviesactors.DateAnnotation");
 
  /** @generated */
  final Feature casFeat_dateRepresentation;
  /** @generated */
  final int     casFeatCode_dateRepresentation;
  /** @generated */ 
  public String getDateRepresentation(int addr) {
        if (featOkTst && casFeat_dateRepresentation == null)
      jcas.throwFeatMissing("dateRepresentation", "ru.intrface.moviesactors.DateAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_dateRepresentation);
  }
  /** @generated */    
  public void setDateRepresentation(int addr, String v) {
        if (featOkTst && casFeat_dateRepresentation == null)
      jcas.throwFeatMissing("dateRepresentation", "ru.intrface.moviesactors.DateAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_dateRepresentation, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DateAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_dateRepresentation = jcas.getRequiredFeatureDE(casType, "dateRepresentation", "uima.cas.String", featOkTst);
    casFeatCode_dateRepresentation  = (null == casFeat_dateRepresentation) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dateRepresentation).getCode();

  }
}



    