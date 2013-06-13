
/* First created by JCasGen Tue May 21 14:19:55 MSK 2013 */
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
public class Actor2Character_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Actor2Character_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Actor2Character_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Actor2Character(addr, Actor2Character_Type.this);
  			   Actor2Character_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Actor2Character(addr, Actor2Character_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Actor2Character.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("ru.intrface.moviesactors.Actor2Character");
 
  /** @generated */
  final Feature casFeat_actor;
  /** @generated */
  final int     casFeatCode_actor;
  /** @generated */ 
  public int getActor(int addr) {
        if (featOkTst && casFeat_actor == null)
      jcas.throwFeatMissing("actor", "ru.intrface.moviesactors.Actor2Character");
    return ll_cas.ll_getRefValue(addr, casFeatCode_actor);
  }
  /** @generated */    
  public void setActor(int addr, int v) {
        if (featOkTst && casFeat_actor == null)
      jcas.throwFeatMissing("actor", "ru.intrface.moviesactors.Actor2Character");
    ll_cas.ll_setRefValue(addr, casFeatCode_actor, v);}
    
  
 
  /** @generated */
  final Feature casFeat_character;
  /** @generated */
  final int     casFeatCode_character;
  /** @generated */ 
  public int getCharacter(int addr) {
        if (featOkTst && casFeat_character == null)
      jcas.throwFeatMissing("character", "ru.intrface.moviesactors.Actor2Character");
    return ll_cas.ll_getRefValue(addr, casFeatCode_character);
  }
  /** @generated */    
  public void setCharacter(int addr, int v) {
        if (featOkTst && casFeat_character == null)
      jcas.throwFeatMissing("character", "ru.intrface.moviesactors.Actor2Character");
    ll_cas.ll_setRefValue(addr, casFeatCode_character, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Actor2Character_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_actor = jcas.getRequiredFeatureDE(casType, "actor", "ru.intrface.moviesactors.Actor", featOkTst);
    casFeatCode_actor  = (null == casFeat_actor) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_actor).getCode();

 
    casFeat_character = jcas.getRequiredFeatureDE(casType, "character", "ru.intrface.moviesactors.Character", featOkTst);
    casFeatCode_character  = (null == casFeat_character) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_character).getCode();

  }
}



    