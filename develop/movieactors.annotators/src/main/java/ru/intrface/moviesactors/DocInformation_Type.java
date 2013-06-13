
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
public class DocInformation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DocInformation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DocInformation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DocInformation(addr, DocInformation_Type.this);
  			   DocInformation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DocInformation(addr, DocInformation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DocInformation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("ru.intrface.moviesactors.DocInformation");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "ru.intrface.moviesactors.DocInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "ru.intrface.moviesactors.DocInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_URL;
  /** @generated */
  final int     casFeatCode_URL;
  /** @generated */ 
  public String getURL(int addr) {
        if (featOkTst && casFeat_URL == null)
      jcas.throwFeatMissing("URL", "ru.intrface.moviesactors.DocInformation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_URL);
  }
  /** @generated */    
  public void setURL(int addr, String v) {
        if (featOkTst && casFeat_URL == null)
      jcas.throwFeatMissing("URL", "ru.intrface.moviesactors.DocInformation");
    ll_cas.ll_setStringValue(addr, casFeatCode_URL, v);}
    
  
 
  /** @generated */
  final Feature casFeat_size;
  /** @generated */
  final int     casFeatCode_size;
  /** @generated */ 
  public long getSize(int addr) {
        if (featOkTst && casFeat_size == null)
      jcas.throwFeatMissing("size", "ru.intrface.moviesactors.DocInformation");
    return ll_cas.ll_getLongValue(addr, casFeatCode_size);
  }
  /** @generated */    
  public void setSize(int addr, long v) {
        if (featOkTst && casFeat_size == null)
      jcas.throwFeatMissing("size", "ru.intrface.moviesactors.DocInformation");
    ll_cas.ll_setLongValue(addr, casFeatCode_size, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DocInformation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_URL = jcas.getRequiredFeatureDE(casType, "URL", "uima.cas.String", featOkTst);
    casFeatCode_URL  = (null == casFeat_URL) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_URL).getCode();

 
    casFeat_size = jcas.getRequiredFeatureDE(casType, "size", "uima.cas.Long", featOkTst);
    casFeatCode_size  = (null == casFeat_size) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_size).getCode();

  }
}



    