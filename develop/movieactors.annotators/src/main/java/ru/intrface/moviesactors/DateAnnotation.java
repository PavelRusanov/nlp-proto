

/* First created by JCasGen Thu May 16 17:48:43 MSK 2013 */
package ru.intrface.moviesactors;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue May 21 16:43:58 MSK 2013
 * XML source: /home/user/work/uima/wspaces/wspace1/movieactors.annotators/desc/ActorMoviesProjectTypeSystem.xml
 * @generated */
public class DateAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DateAnnotation.class);
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
  protected DateAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DateAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DateAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public DateAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: dateRepresentation

  /** getter for dateRepresentation - gets date representation in dd/mm/yyyy
   * @generated */
  public String getDateRepresentation() {
    if (DateAnnotation_Type.featOkTst && ((DateAnnotation_Type)jcasType).casFeat_dateRepresentation == null)
      jcasType.jcas.throwFeatMissing("dateRepresentation", "ru.intrface.moviesactors.DateAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DateAnnotation_Type)jcasType).casFeatCode_dateRepresentation);}
    
  /** setter for dateRepresentation - sets date representation in dd/mm/yyyy 
   * @generated */
  public void setDateRepresentation(String v) {
    if (DateAnnotation_Type.featOkTst && ((DateAnnotation_Type)jcasType).casFeat_dateRepresentation == null)
      jcasType.jcas.throwFeatMissing("dateRepresentation", "ru.intrface.moviesactors.DateAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((DateAnnotation_Type)jcasType).casFeatCode_dateRepresentation, v);}    
  }

    