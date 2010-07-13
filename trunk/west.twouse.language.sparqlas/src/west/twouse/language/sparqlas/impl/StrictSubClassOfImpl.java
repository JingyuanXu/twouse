/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package west.twouse.language.sparqlas.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import west.twouse.language.sparqlas.ClassExpression;
import west.twouse.language.sparqlas.SparqlmsPackage;
import west.twouse.language.sparqlas.SparqlasPackage;
import west.twouse.language.sparqlas.StrictSubClassOf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Strict Sub Class Of</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link west.twouse.language.sparqlas.impl.StrictSubClassOfImpl#getSubClassExpression <em>Sub Class Expression</em>}</li>
 *   <li>{@link west.twouse.language.sparqlas.impl.StrictSubClassOfImpl#getSuperClassExpression <em>Super Class Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StrictSubClassOfImpl extends ClassAtomImpl implements StrictSubClassOf
{
  /**
   * The cached value of the '{@link #getSubClassExpression() <em>Sub Class Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubClassExpression()
   * @generated
   * @ordered
   */
  protected ClassExpression subClassExpression;

  /**
   * The cached value of the '{@link #getSuperClassExpression() <em>Super Class Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperClassExpression()
   * @generated
   * @ordered
   */
  protected ClassExpression superClassExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StrictSubClassOfImpl()
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
    return SparqlasPackage.Literals.STRICT_SUB_CLASS_OF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassExpression getSubClassExpression()
  {
    return subClassExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubClassExpression(ClassExpression newSubClassExpression, NotificationChain msgs)
  {
    ClassExpression oldSubClassExpression = subClassExpression;
    subClassExpression = newSubClassExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparqlasPackage.STRICT_SUB_CLASS_OF__SUB_CLASS_EXPRESSION, oldSubClassExpression, newSubClassExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubClassExpression(ClassExpression newSubClassExpression)
  {
    if (newSubClassExpression != subClassExpression)
    {
      NotificationChain msgs = null;
      if (subClassExpression != null)
        msgs = ((InternalEObject)subClassExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparqlasPackage.STRICT_SUB_CLASS_OF__SUB_CLASS_EXPRESSION, null, msgs);
      if (newSubClassExpression != null)
        msgs = ((InternalEObject)newSubClassExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparqlasPackage.STRICT_SUB_CLASS_OF__SUB_CLASS_EXPRESSION, null, msgs);
      msgs = basicSetSubClassExpression(newSubClassExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparqlasPackage.STRICT_SUB_CLASS_OF__SUB_CLASS_EXPRESSION, newSubClassExpression, newSubClassExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassExpression getSuperClassExpression()
  {
    return superClassExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuperClassExpression(ClassExpression newSuperClassExpression, NotificationChain msgs)
  {
    ClassExpression oldSuperClassExpression = superClassExpression;
    superClassExpression = newSuperClassExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparqlasPackage.STRICT_SUB_CLASS_OF__SUPER_CLASS_EXPRESSION, oldSuperClassExpression, newSuperClassExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperClassExpression(ClassExpression newSuperClassExpression)
  {
    if (newSuperClassExpression != superClassExpression)
    {
      NotificationChain msgs = null;
      if (superClassExpression != null)
        msgs = ((InternalEObject)superClassExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparqlasPackage.STRICT_SUB_CLASS_OF__SUPER_CLASS_EXPRESSION, null, msgs);
      if (newSuperClassExpression != null)
        msgs = ((InternalEObject)newSuperClassExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparqlasPackage.STRICT_SUB_CLASS_OF__SUPER_CLASS_EXPRESSION, null, msgs);
      msgs = basicSetSuperClassExpression(newSuperClassExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparqlasPackage.STRICT_SUB_CLASS_OF__SUPER_CLASS_EXPRESSION, newSuperClassExpression, newSuperClassExpression));
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
      case SparqlasPackage.STRICT_SUB_CLASS_OF__SUB_CLASS_EXPRESSION:
        return basicSetSubClassExpression(null, msgs);
      case SparqlasPackage.STRICT_SUB_CLASS_OF__SUPER_CLASS_EXPRESSION:
        return basicSetSuperClassExpression(null, msgs);
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
      case SparqlasPackage.STRICT_SUB_CLASS_OF__SUB_CLASS_EXPRESSION:
        return getSubClassExpression();
      case SparqlasPackage.STRICT_SUB_CLASS_OF__SUPER_CLASS_EXPRESSION:
        return getSuperClassExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SparqlasPackage.STRICT_SUB_CLASS_OF__SUB_CLASS_EXPRESSION:
        setSubClassExpression((ClassExpression)newValue);
        return;
      case SparqlasPackage.STRICT_SUB_CLASS_OF__SUPER_CLASS_EXPRESSION:
        setSuperClassExpression((ClassExpression)newValue);
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
      case SparqlasPackage.STRICT_SUB_CLASS_OF__SUB_CLASS_EXPRESSION:
        setSubClassExpression((ClassExpression)null);
        return;
      case SparqlasPackage.STRICT_SUB_CLASS_OF__SUPER_CLASS_EXPRESSION:
        setSuperClassExpression((ClassExpression)null);
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
      case SparqlasPackage.STRICT_SUB_CLASS_OF__SUB_CLASS_EXPRESSION:
        return subClassExpression != null;
      case SparqlasPackage.STRICT_SUB_CLASS_OF__SUPER_CLASS_EXPRESSION:
        return superClassExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //StrictSubClassOfImpl
