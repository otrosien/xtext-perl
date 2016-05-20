/**
 * generated by Xtext 2.9.1
 */
package org.epic.perl.perl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.epic.perl.perl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PerlFactoryImpl extends EFactoryImpl implements PerlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PerlFactory init()
  {
    try
    {
      PerlFactory thePerlFactory = (PerlFactory)EPackage.Registry.INSTANCE.getEFactory(PerlPackage.eNS_URI);
      if (thePerlFactory != null)
      {
        return thePerlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PerlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PerlFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case PerlPackage.PEXPRESSION: return createPExpression();
      case PerlPackage.PASSIGNMENT: return createPAssignment();
      case PerlPackage.PBINARY_OPERATION: return createPBinaryOperation();
      case PerlPackage.PUNARY_OPERATION: return createPUnaryOperation();
      case PerlPackage.PPOSTFIX_OPERATION: return createPPostfixOperation();
      case PerlPackage.PCLOSURE: return createPClosure();
      case PerlPackage.PBLOCK_EXPRESSION: return createPBlockExpression();
      case PerlPackage.PIF_EXPRESSION: return createPIfExpression();
      case PerlPackage.PVARIABLE_DECLARATION: return createPVariableDeclaration();
      case PerlPackage.PCONSTRUCTOR_CALL: return createPConstructorCall();
      case PerlPackage.PNUMBER_LITERAL: return createPNumberLiteral();
      case PerlPackage.PNULL_LITERAL: return createPNullLiteral();
      case PerlPackage.PRETURN_EXPRESSION: return createPReturnExpression();
      case PerlPackage.PSTRING_LITERAL: return createPStringLiteral();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PExpression createPExpression()
  {
    PExpressionImpl pExpression = new PExpressionImpl();
    return pExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PAssignment createPAssignment()
  {
    PAssignmentImpl pAssignment = new PAssignmentImpl();
    return pAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PBinaryOperation createPBinaryOperation()
  {
    PBinaryOperationImpl pBinaryOperation = new PBinaryOperationImpl();
    return pBinaryOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PUnaryOperation createPUnaryOperation()
  {
    PUnaryOperationImpl pUnaryOperation = new PUnaryOperationImpl();
    return pUnaryOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PPostfixOperation createPPostfixOperation()
  {
    PPostfixOperationImpl pPostfixOperation = new PPostfixOperationImpl();
    return pPostfixOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PClosure createPClosure()
  {
    PClosureImpl pClosure = new PClosureImpl();
    return pClosure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PBlockExpression createPBlockExpression()
  {
    PBlockExpressionImpl pBlockExpression = new PBlockExpressionImpl();
    return pBlockExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PIfExpression createPIfExpression()
  {
    PIfExpressionImpl pIfExpression = new PIfExpressionImpl();
    return pIfExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PVariableDeclaration createPVariableDeclaration()
  {
    PVariableDeclarationImpl pVariableDeclaration = new PVariableDeclarationImpl();
    return pVariableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PConstructorCall createPConstructorCall()
  {
    PConstructorCallImpl pConstructorCall = new PConstructorCallImpl();
    return pConstructorCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PNumberLiteral createPNumberLiteral()
  {
    PNumberLiteralImpl pNumberLiteral = new PNumberLiteralImpl();
    return pNumberLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PNullLiteral createPNullLiteral()
  {
    PNullLiteralImpl pNullLiteral = new PNullLiteralImpl();
    return pNullLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PReturnExpression createPReturnExpression()
  {
    PReturnExpressionImpl pReturnExpression = new PReturnExpressionImpl();
    return pReturnExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PStringLiteral createPStringLiteral()
  {
    PStringLiteralImpl pStringLiteral = new PStringLiteralImpl();
    return pStringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PerlPackage getPerlPackage()
  {
    return (PerlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PerlPackage getPackage()
  {
    return PerlPackage.eINSTANCE;
  }

} //PerlFactoryImpl
