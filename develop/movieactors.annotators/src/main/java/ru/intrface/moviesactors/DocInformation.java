

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
public class DocInformation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DocInformation.class);
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
  protected DocInformation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DocInformation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DocInformation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public DocInformation(JCas jcas, int begin, int end) {
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
  //* Feature: name

  /** getter for name - gets 
   * @generated */
  public String getName() {
    if (DocInformation_Type.featOkTst && ((DocInformation_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "ru.intrface.moviesactors.DocInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocInformation_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (DocInformation_Type.featOkTst && ((DocInformation_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "ru.intrface.moviesactors.DocInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocInformation_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: URL

  /** getter for URL - gets 
   * @generated */
  public String getURL() {
    if (DocInformation_Type.featOkTst && ((DocInformation_Type)jcasType).casFeat_URL == null)
      jcasType.jcas.throwFeatMissing("URL", "ru.intrface.moviesactors.DocInformation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocInformation_Type)jcasType).casFeatCode_URL);}
    
  /** setter for URL - sets  
   * @generated */
  public void setURL(String v) {
    if (DocInformation_Type.featOkTst && ((DocInformation_Type)jcasType).casFeat_URL == null)
      jcasType.jcas.throwFeatMissing("URL", "ru.intrface.moviesactors.DocInformation");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocInformation_Type)jcasType).casFeatCode_URL, v);}    
   
    
  //*--------------*
  //* Feature: size

  /** getter for size - gets 
   * @generated */
  public long getSize() {
    if (DocInformation_Type.featOkTst && ((DocInformation_Type)jcasType).casFeat_size == null)
      jcasType.jcas.throwFeatMissing("size", "ru.intrface.moviesactors.DocInformation");
    return jcasType.ll_cas.ll_getLongValue(addr, ((DocInformation_Type)jcasType).casFeatCode_size);}
    
  /** setter for size - sets  
   * @generated */
  public void setSize(long v) {
    if (DocInformation_Type.featOkTst && ((DocInformation_Type)jcasType).casFeat_size == null)
      jcasType.jcas.throwFeatMissing("size", "ru.intrface.moviesactors.DocInformation");
    jcasType.ll_cas.ll_setLongValue(addr, ((DocInformation_Type)jcasType).casFeatCode_size, v);}    
  }

    