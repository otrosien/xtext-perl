/**
 * generated by Xtext 2.10.0-SNAPSHOT
 */
package org.epic.perl.perl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.epic.perl.perl.StatementBlock#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see org.epic.perl.perl.PerlPackage#getStatementBlock()
 * @model
 * @generated
 */
public interface StatementBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link org.epic.perl.perl.StatementNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see org.epic.perl.perl.PerlPackage#getStatementBlock_Statements()
   * @model containment="true"
   * @generated
   */
  EList<StatementNode> getStatements();

} // StatementBlock