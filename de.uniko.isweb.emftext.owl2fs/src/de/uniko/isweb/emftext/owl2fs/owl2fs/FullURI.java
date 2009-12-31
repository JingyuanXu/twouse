/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uniko.isweb.emftext.owl2fs.owl2fs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Full URI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uniko.isweb.emftext.owl2fs.owl2fs.FullURI#getIri <em>Iri</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uniko.isweb.emftext.owl2fs.owl2fs.Owl2fsPackage#getFullURI()
 * @model
 * @generated
 */
public interface FullURI extends EObject
{
  /**
   * Returns the value of the '<em><b>Iri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Iri</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Iri</em>' attribute.
   * @see #setIri(String)
   * @see de.uniko.isweb.emftext.owl2fs.owl2fs.Owl2fsPackage#getFullURI_Iri()
   * @model required="true" ordered="false"
   * @generated
   */
  String getIri();

  /**
   * Sets the value of the '{@link de.uniko.isweb.emftext.owl2fs.owl2fs.FullURI#getIri <em>Iri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Iri</em>' attribute.
   * @see #getIri()
   * @generated
   */
  void setIri(String value);

} // FullURI
