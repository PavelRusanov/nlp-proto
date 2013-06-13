
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
public class Movie_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Movie_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Movie_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Movie(addr, Movie_Type.this);
  			   Movie_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Movie(addr, Movie_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Movie.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("ru.intrface.moviesactors.Movie");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "ru.intrface.moviesactors.Movie");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "ru.intrface.moviesactors.Movie");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_actorRoles;
  /** @generated */
  final int     casFeatCode_actorRoles;
  /** @generated */ 
  public int getActorRoles(int addr) {
        if (featOkTst && casFeat_actorRoles == null)
      jcas.throwFeatMissing("actorRoles", "ru.intrface.moviesactors.Movie");
    return ll_cas.ll_getRefValue(addr, casFeatCode_actorRoles);
  }
  /** @generated */    
  public void setActorRoles(int addr, int v) {
        if (featOkTst && casFeat_actorRoles == null)
      jcas.throwFeatMissing("actorRoles", "ru.intrface.moviesactors.Movie");
    ll_cas.ll_setRefValue(addr, casFeatCode_actorRoles, v);}
    
  
 
  /** @generated */
  final Feature casFeat_array;
  /** @generated */
  final int     casFeatCode_array;
  /** @generated */ 
  public int getArray(int addr) {
        if (featOkTst && casFeat_array == null)
      jcas.throwFeatMissing("array", "ru.intrface.moviesactors.Movie");
    return ll_cas.ll_getRefValue(addr, casFeatCode_array);
  }
  /** @generated */    
  public void setArray(int addr, int v) {
        if (featOkTst && casFeat_array == null)
      jcas.throwFeatMissing("array", "ru.intrface.moviesactors.Movie");
    ll_cas.ll_setRefValue(addr, casFeatCode_array, v);}
    
   /** @generated */
  public int getArray(int addr, int i) {
        if (featOkTst && casFeat_array == null)
      jcas.throwFeatMissing("array", "ru.intrface.moviesactors.Movie");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_array), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_array), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_array), i);
  }
   
  /** @generated */ 
  public void setArray(int addr, int i, int v) {
        if (featOkTst && casFeat_array == null)
      jcas.throwFeatMissing("array", "ru.intrface.moviesactors.Movie");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_array), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_array), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_array), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Movie_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_actorRoles = jcas.getRequiredFeatureDE(casType, "actorRoles", "uima.cas.NonEmptyFSList", featOkTst);
    casFeatCode_actorRoles  = (null == casFeat_actorRoles) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_actorRoles).getCode();

 
    casFeat_array = jcas.getRequiredFeatureDE(casType, "array", "uima.cas.FSArray", featOkTst);
    casFeatCode_array  = (null == casFeat_array) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_array).getCode();

  }
}



    