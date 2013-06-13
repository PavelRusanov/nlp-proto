

/* First created by JCasGen Thu May 16 17:48:43 MSK 2013 */
package ru.intrface.moviesactors;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Tue May 21 16:43:58 MSK 2013
 * XML source: /home/user/work/uima/wspaces/wspace1/movieactors.annotators/desc/ActorMoviesProjectTypeSystem.xml
 * @generated */
public class Actor extends Person {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Actor.class);
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
  protected Actor() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Actor(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Actor(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Actor(JCas jcas, int begin, int end) {
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
     
 
    
}

    