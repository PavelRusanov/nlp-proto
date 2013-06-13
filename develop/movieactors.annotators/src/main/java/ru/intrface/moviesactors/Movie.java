

/* First created by JCasGen Thu May 16 17:48:43 MSK 2013 */
package ru.intrface.moviesactors;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.jcas.tcas.Annotation;


import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Tue May 21 16:43:58 MSK 2013
 * XML source: /home/user/work/uima/wspaces/wspace1/movieactors.annotators/desc/ActorMoviesProjectTypeSystem.xml
 * @generated */
public class Movie extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Movie.class);
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
  protected Movie() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Movie(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Movie(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Movie(JCas jcas, int begin, int end) {
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
    if (Movie_Type.featOkTst && ((Movie_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "ru.intrface.moviesactors.Movie");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Movie_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (Movie_Type.featOkTst && ((Movie_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "ru.intrface.moviesactors.Movie");
    jcasType.ll_cas.ll_setStringValue(addr, ((Movie_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: actorRoles

  /** getter for actorRoles - gets 
   * @generated */
  public NonEmptyFSList getActorRoles() {
    if (Movie_Type.featOkTst && ((Movie_Type)jcasType).casFeat_actorRoles == null)
      jcasType.jcas.throwFeatMissing("actorRoles", "ru.intrface.moviesactors.Movie");
    return (NonEmptyFSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Movie_Type)jcasType).casFeatCode_actorRoles)));}
    
  /** setter for actorRoles - sets  
   * @generated */
  public void setActorRoles(NonEmptyFSList v) {
    if (Movie_Type.featOkTst && ((Movie_Type)jcasType).casFeat_actorRoles == null)
      jcasType.jcas.throwFeatMissing("actorRoles", "ru.intrface.moviesactors.Movie");
    jcasType.ll_cas.ll_setRefValue(addr, ((Movie_Type)jcasType).casFeatCode_actorRoles, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: array

  /** getter for array - gets 
   * @generated */
  public FSArray getArray() {
    if (Movie_Type.featOkTst && ((Movie_Type)jcasType).casFeat_array == null)
      jcasType.jcas.throwFeatMissing("array", "ru.intrface.moviesactors.Movie");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Movie_Type)jcasType).casFeatCode_array)));}
    
  /** setter for array - sets  
   * @generated */
  public void setArray(FSArray v) {
    if (Movie_Type.featOkTst && ((Movie_Type)jcasType).casFeat_array == null)
      jcasType.jcas.throwFeatMissing("array", "ru.intrface.moviesactors.Movie");
    jcasType.ll_cas.ll_setRefValue(addr, ((Movie_Type)jcasType).casFeatCode_array, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for array - gets an indexed value - 
   * @generated */
  public TOP getArray(int i) {
    if (Movie_Type.featOkTst && ((Movie_Type)jcasType).casFeat_array == null)
      jcasType.jcas.throwFeatMissing("array", "ru.intrface.moviesactors.Movie");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Movie_Type)jcasType).casFeatCode_array), i);
    return (TOP)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Movie_Type)jcasType).casFeatCode_array), i)));}

  /** indexed setter for array - sets an indexed value - 
   * @generated */
  public void setArray(int i, TOP v) { 
    if (Movie_Type.featOkTst && ((Movie_Type)jcasType).casFeat_array == null)
      jcasType.jcas.throwFeatMissing("array", "ru.intrface.moviesactors.Movie");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Movie_Type)jcasType).casFeatCode_array), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Movie_Type)jcasType).casFeatCode_array), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    