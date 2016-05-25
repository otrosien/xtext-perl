/**
 * generated by Xtext 2.10.0-SNAPSHOT
 */
package org.epic.perl.perl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.epic.perl.perl.ExpressionStatement#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see org.epic.perl.perl.PerlPackage#getExpressionStatement()
 * @model
 * @generated
 */
public interface ExpressionStatement extends StatementNode
{
  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(String)
   * @see org.epic.perl.perl.PerlPackage#getExpressionStatement_Version()
   * @model
   * @generated
   */
  String getVersion();

  /**
   * Sets the value of the '{@link org.epic.perl.perl.ExpressionStatement#getVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(String value);

} // ExpressionStatement
