/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package west.twouse.language.owl2fs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import west.twouse.language.owl2fs.Annotation;
import west.twouse.language.owl2fs.AnnotationAxiom;
import west.twouse.language.owl2fs.Owl2fsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link west.twouse.language.owl2fs.impl.AnnotationAxiomImpl#getAxiomAnnotations <em>Axiom Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AnnotationAxiomImpl extends AxiomImpl implements AnnotationAxiom
{
  /**
   * The cached value of the '{@link #getAxiomAnnotations() <em>Axiom Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAxiomAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> axiomAnnotations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnnotationAxiomImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Owl2fsPackage.Literals.ANNOTATION_AXIOM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getAxiomAnnotations()
  {
    if (axiomAnnotations == null)
    {
      axiomAnnotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, Owl2fsPackage.ANNOTATION_AXIOM__AXIOM_ANNOTATIONS);
    }
    return axiomAnnotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case Owl2fsPackage.ANNOTATION_AXIOM__AXIOM_ANNOTATIONS:
        return ((InternalEList<?>)getAxiomAnnotations()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case Owl2fsPackage.ANNOTATION_AXIOM__AXIOM_ANNOTATIONS:
        return getAxiomAnnotations();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Owl2fsPackage.ANNOTATION_AXIOM__AXIOM_ANNOTATIONS:
        getAxiomAnnotations().clear();
        getAxiomAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case Owl2fsPackage.ANNOTATION_AXIOM__AXIOM_ANNOTATIONS:
        getAxiomAnnotations().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case Owl2fsPackage.ANNOTATION_AXIOM__AXIOM_ANNOTATIONS:
        return axiomAnnotations != null && !axiomAnnotations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AnnotationAxiomImpl
