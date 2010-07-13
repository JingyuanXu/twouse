/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package west.twouse.language.owl2fs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import west.twouse.language.owl2fs.InverseObjectProperties;
import west.twouse.language.owl2fs.ObjectPropertyExpression;
import west.twouse.language.owl2fs.Owl2fsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inverse Object Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link west.twouse.language.owl2fs.impl.InverseObjectPropertiesImpl#getObjectPropertyExpression1 <em>Object Property Expression1</em>}</li>
 *   <li>{@link west.twouse.language.owl2fs.impl.InverseObjectPropertiesImpl#getObjectPropertyExpression2 <em>Object Property Expression2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InverseObjectPropertiesImpl extends ObjectPropertyAxiomImpl implements InverseObjectProperties
{
  /**
   * The cached value of the '{@link #getObjectPropertyExpression1() <em>Object Property Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectPropertyExpression1()
   * @generated
   * @ordered
   */
  protected ObjectPropertyExpression objectPropertyExpression1;

  /**
   * The cached value of the '{@link #getObjectPropertyExpression2() <em>Object Property Expression2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectPropertyExpression2()
   * @generated
   * @ordered
   */
  protected ObjectPropertyExpression objectPropertyExpression2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InverseObjectPropertiesImpl()
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
    return Owl2fsPackage.Literals.INVERSE_OBJECT_PROPERTIES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectPropertyExpression getObjectPropertyExpression1()
  {
    return objectPropertyExpression1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObjectPropertyExpression1(ObjectPropertyExpression newObjectPropertyExpression1, NotificationChain msgs)
  {
    ObjectPropertyExpression oldObjectPropertyExpression1 = objectPropertyExpression1;
    objectPropertyExpression1 = newObjectPropertyExpression1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION1, oldObjectPropertyExpression1, newObjectPropertyExpression1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObjectPropertyExpression1(ObjectPropertyExpression newObjectPropertyExpression1)
  {
    if (newObjectPropertyExpression1 != objectPropertyExpression1)
    {
      NotificationChain msgs = null;
      if (objectPropertyExpression1 != null)
        msgs = ((InternalEObject)objectPropertyExpression1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION1, null, msgs);
      if (newObjectPropertyExpression1 != null)
        msgs = ((InternalEObject)newObjectPropertyExpression1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION1, null, msgs);
      msgs = basicSetObjectPropertyExpression1(newObjectPropertyExpression1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION1, newObjectPropertyExpression1, newObjectPropertyExpression1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectPropertyExpression getObjectPropertyExpression2()
  {
    return objectPropertyExpression2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObjectPropertyExpression2(ObjectPropertyExpression newObjectPropertyExpression2, NotificationChain msgs)
  {
    ObjectPropertyExpression oldObjectPropertyExpression2 = objectPropertyExpression2;
    objectPropertyExpression2 = newObjectPropertyExpression2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION2, oldObjectPropertyExpression2, newObjectPropertyExpression2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObjectPropertyExpression2(ObjectPropertyExpression newObjectPropertyExpression2)
  {
    if (newObjectPropertyExpression2 != objectPropertyExpression2)
    {
      NotificationChain msgs = null;
      if (objectPropertyExpression2 != null)
        msgs = ((InternalEObject)objectPropertyExpression2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION2, null, msgs);
      if (newObjectPropertyExpression2 != null)
        msgs = ((InternalEObject)newObjectPropertyExpression2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION2, null, msgs);
      msgs = basicSetObjectPropertyExpression2(newObjectPropertyExpression2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION2, newObjectPropertyExpression2, newObjectPropertyExpression2));
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
      case Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION1:
        return basicSetObjectPropertyExpression1(null, msgs);
      case Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION2:
        return basicSetObjectPropertyExpression2(null, msgs);
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
      case Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION1:
        return getObjectPropertyExpression1();
      case Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION2:
        return getObjectPropertyExpression2();
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
      case Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION1:
        setObjectPropertyExpression1((ObjectPropertyExpression)newValue);
        return;
      case Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION2:
        setObjectPropertyExpression2((ObjectPropertyExpression)newValue);
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
      case Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION1:
        setObjectPropertyExpression1((ObjectPropertyExpression)null);
        return;
      case Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION2:
        setObjectPropertyExpression2((ObjectPropertyExpression)null);
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
      case Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION1:
        return objectPropertyExpression1 != null;
      case Owl2fsPackage.INVERSE_OBJECT_PROPERTIES__OBJECT_PROPERTY_EXPRESSION2:
        return objectPropertyExpression2 != null;
    }
    return super.eIsSet(featureID);
  }

} //InverseObjectPropertiesImpl
