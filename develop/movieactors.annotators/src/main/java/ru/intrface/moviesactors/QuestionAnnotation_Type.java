
/* First created by JCasGen Thu Jun 20 17:39:18 MSK 2013 */
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
 * Updated by JCasGen Fri Jun 21 18:16:22 MSK 2013
 * @generated */
public class QuestionAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (QuestionAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = QuestionAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new QuestionAnnotation(addr, QuestionAnnotation_Type.this);
  			   QuestionAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new QuestionAnnotation(addr, QuestionAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = QuestionAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("ru.intrface.moviesactors.QuestionAnnotation");
 
  /** @generated */
  final Feature casFeat_actor;
  /** @generated */
  final int     casFeatCode_actor;
  /** @generated */ 
  public String getActor(int addr) {
        if (featOkTst && casFeat_actor == null)
      jcas.throwFeatMissing("actor", "ru.intrface.moviesactors.QuestionAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_actor);
  }
  /** @generated */    
  public void setActor(int addr, String v) {
        if (featOkTst && casFeat_actor == null)
      jcas.throwFeatMissing("actor", "ru.intrface.moviesactors.QuestionAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_actor, v);}
    
  
 
  /** @generated */
  final Feature casFeat_role;
  /** @generated */
  final int     casFeatCode_role;
  /** @generated */ 
  public String getRole(int addr) {
        if (featOkTst && casFeat_role == null)
      jcas.throwFeatMissing("role", "ru.intrface.moviesactors.QuestionAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_role);
  }
  /** @generated */    
  public void setRole(int addr, String v) {
        if (featOkTst && casFeat_role == null)
      jcas.throwFeatMissing("role", "ru.intrface.moviesactors.QuestionAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_role, v);}
    
  
 
  /** @generated */
  final Feature casFeat_film;
  /** @generated */
  final int     casFeatCode_film;
  /** @generated */ 
  public String getFilm(int addr) {
        if (featOkTst && casFeat_film == null)
      jcas.throwFeatMissing("film", "ru.intrface.moviesactors.QuestionAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_film);
  }
  /** @generated */    
  public void setFilm(int addr, String v) {
        if (featOkTst && casFeat_film == null)
      jcas.throwFeatMissing("film", "ru.intrface.moviesactors.QuestionAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_film, v);}
    
  
 
  /** @generated */
  final Feature casFeat_questionType;
  /** @generated */
  final int     casFeatCode_questionType;
  /** @generated */ 
  public String getQuestionType(int addr) {
        if (featOkTst && casFeat_questionType == null)
      jcas.throwFeatMissing("questionType", "ru.intrface.moviesactors.QuestionAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_questionType);
  }
  /** @generated */    
  public void setQuestionType(int addr, String v) {
        if (featOkTst && casFeat_questionType == null)
      jcas.throwFeatMissing("questionType", "ru.intrface.moviesactors.QuestionAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_questionType, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public QuestionAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_actor = jcas.getRequiredFeatureDE(casType, "actor", "uima.cas.String", featOkTst);
    casFeatCode_actor  = (null == casFeat_actor) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_actor).getCode();

 
    casFeat_role = jcas.getRequiredFeatureDE(casType, "role", "uima.cas.String", featOkTst);
    casFeatCode_role  = (null == casFeat_role) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_role).getCode();

 
    casFeat_film = jcas.getRequiredFeatureDE(casType, "film", "uima.cas.String", featOkTst);
    casFeatCode_film  = (null == casFeat_film) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_film).getCode();

 
    casFeat_questionType = jcas.getRequiredFeatureDE(casType, "questionType", "uima.cas.String", featOkTst);
    casFeatCode_questionType  = (null == casFeat_questionType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_questionType).getCode();

  }
}



    