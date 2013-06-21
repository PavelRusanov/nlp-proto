

/* First created by JCasGen Thu Jun 20 17:39:18 MSK 2013 */
package ru.intrface.moviesactors;

import java.util.List;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.StringList;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Jun 21 18:16:22 MSK 2013
 * XML source: C:/LacmusDev/git/nlp-proto/develop/movieactors.annotators/desc/QuestionTypeSystem.xml
 * @generated */
public class QuestionAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(QuestionAnnotation.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected QuestionAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public QuestionAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public QuestionAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public QuestionAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: actor

  /** getter for actor - gets 
   * @generated */
  public String getActor() {
    if (QuestionAnnotation_Type.featOkTst && ((QuestionAnnotation_Type)jcasType).casFeat_actor == null)
      jcasType.jcas.throwFeatMissing("actor", "ru.intrface.moviesactors.QuestionAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QuestionAnnotation_Type)jcasType).casFeatCode_actor);}
    
  /** setter for actor - sets  
   * @generated */
  public void setActor(String v) {
    if (QuestionAnnotation_Type.featOkTst && ((QuestionAnnotation_Type)jcasType).casFeat_actor == null)
      jcasType.jcas.throwFeatMissing("actor", "ru.intrface.moviesactors.QuestionAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((QuestionAnnotation_Type)jcasType).casFeatCode_actor, v);}    
   
    
  //*--------------*
  //* Feature: role

  /** getter for role - gets 
   * @generated */
  public String getRole() {
    if (QuestionAnnotation_Type.featOkTst && ((QuestionAnnotation_Type)jcasType).casFeat_role == null)
      jcasType.jcas.throwFeatMissing("role", "ru.intrface.moviesactors.QuestionAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QuestionAnnotation_Type)jcasType).casFeatCode_role);}
    
  /** setter for role - sets  
   * @generated */
  public void setRole(String v) {
    if (QuestionAnnotation_Type.featOkTst && ((QuestionAnnotation_Type)jcasType).casFeat_role == null)
      jcasType.jcas.throwFeatMissing("role", "ru.intrface.moviesactors.QuestionAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((QuestionAnnotation_Type)jcasType).casFeatCode_role, v);}    
   
    
  //*--------------*
  //* Feature: film

  /** getter for film - gets 
   * @generated */
  public String getFilm() {
    if (QuestionAnnotation_Type.featOkTst && ((QuestionAnnotation_Type)jcasType).casFeat_film == null)
      jcasType.jcas.throwFeatMissing("film", "ru.intrface.moviesactors.QuestionAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QuestionAnnotation_Type)jcasType).casFeatCode_film);}
    
  /** setter for film - sets  
   * @generated */
  public void setFilm(String v) {
    if (QuestionAnnotation_Type.featOkTst && ((QuestionAnnotation_Type)jcasType).casFeat_film == null)
      jcasType.jcas.throwFeatMissing("film", "ru.intrface.moviesactors.QuestionAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((QuestionAnnotation_Type)jcasType).casFeatCode_film, v);}    
   
    
  //*--------------*
  //* Feature: questionType

  /** getter for questionType - gets 
   * @generated */
  public String getQuestionType() {
    if (QuestionAnnotation_Type.featOkTst && ((QuestionAnnotation_Type)jcasType).casFeat_questionType == null)
      jcasType.jcas.throwFeatMissing("questionType", "ru.intrface.moviesactors.QuestionAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((QuestionAnnotation_Type)jcasType).casFeatCode_questionType);}
    
  /** setter for questionType - sets  
   * @generated */
  public void setQuestionType(String v) {
    if (QuestionAnnotation_Type.featOkTst && ((QuestionAnnotation_Type)jcasType).casFeat_questionType == null)
      jcasType.jcas.throwFeatMissing("questionType", "ru.intrface.moviesactors.QuestionAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((QuestionAnnotation_Type)jcasType).casFeatCode_questionType, v);}    
  }

    