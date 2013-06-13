

/* First created by JCasGen Tue May 21 14:19:55 MSK 2013 */
package ru.intrface.moviesactors;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue May 21 16:43:58 MSK 2013
 * XML source: /home/user/work/uima/wspaces/wspace1/movieactors.annotators/desc/ActorMoviesProjectTypeSystem.xml
 * @generated */
public class Actor2Character extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Actor2Character.class);
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
  protected Actor2Character() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Actor2Character(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Actor2Character(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Actor2Character(JCas jcas, int begin, int end) {
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
  public Actor getActor() {
    if (Actor2Character_Type.featOkTst && ((Actor2Character_Type)jcasType).casFeat_actor == null)
      jcasType.jcas.throwFeatMissing("actor", "ru.intrface.moviesactors.Actor2Character");
    return (Actor)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Actor2Character_Type)jcasType).casFeatCode_actor)));}
    
  /** setter for actor - sets  
   * @generated */
  public void setActor(Actor v) {
    if (Actor2Character_Type.featOkTst && ((Actor2Character_Type)jcasType).casFeat_actor == null)
      jcasType.jcas.throwFeatMissing("actor", "ru.intrface.moviesactors.Actor2Character");
    jcasType.ll_cas.ll_setRefValue(addr, ((Actor2Character_Type)jcasType).casFeatCode_actor, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: character

  /** getter for character - gets 
   * @generated */
  public Character getCharacter() {
    if (Actor2Character_Type.featOkTst && ((Actor2Character_Type)jcasType).casFeat_character == null)
      jcasType.jcas.throwFeatMissing("character", "ru.intrface.moviesactors.Actor2Character");
    return (Character)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Actor2Character_Type)jcasType).casFeatCode_character)));}
    
  /** setter for character - sets  
   * @generated */
  public void setCharacter(Character v) {
    if (Actor2Character_Type.featOkTst && ((Actor2Character_Type)jcasType).casFeat_character == null)
      jcasType.jcas.throwFeatMissing("character", "ru.intrface.moviesactors.Actor2Character");
    jcasType.ll_cas.ll_setRefValue(addr, ((Actor2Character_Type)jcasType).casFeatCode_character, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    