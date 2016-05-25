/**
 * generated by Xtext 2.10.0-SNAPSHOT
 */
package org.epic.perl.perl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.epic.perl.perl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.epic.perl.perl.PerlPackage
 * @generated
 */
public class PerlSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PerlPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PerlSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = PerlPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case PerlPackage.PERL_DOCUMENT:
      {
        PerlDocument perlDocument = (PerlDocument)theEObject;
        T result = casePerlDocument(perlDocument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.ELEMENT:
      {
        Element element = (Element)theEObject;
        T result = caseElement(element);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.NODE:
      {
        Node node = (Node)theEObject;
        T result = caseNode(node);
        if (result == null) result = caseElement(node);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.STATEMENT_NODE:
      {
        StatementNode statementNode = (StatementNode)theEObject;
        T result = caseStatementNode(statementNode);
        if (result == null) result = caseNode(statementNode);
        if (result == null) result = caseElement(statementNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.BLOCK_STATEMENT:
      {
        BlockStatement blockStatement = (BlockStatement)theEObject;
        T result = caseBlockStatement(blockStatement);
        if (result == null) result = caseStatementNode(blockStatement);
        if (result == null) result = caseNode(blockStatement);
        if (result == null) result = caseElement(blockStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.EXPRESSION_STATEMENT:
      {
        ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
        T result = caseExpressionStatement(expressionStatement);
        if (result == null) result = caseStatementNode(expressionStatement);
        if (result == null) result = caseNode(expressionStatement);
        if (result == null) result = caseElement(expressionStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.STRUCTURE_NODE:
      {
        StructureNode structureNode = (StructureNode)theEObject;
        T result = caseStructureNode(structureNode);
        if (result == null) result = caseNode(structureNode);
        if (result == null) result = caseElement(structureNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.PACKAGE_STATEMENT:
      {
        PackageStatement packageStatement = (PackageStatement)theEObject;
        T result = casePackageStatement(packageStatement);
        if (result == null) result = caseExpressionStatement(packageStatement);
        if (result == null) result = caseStatementNode(packageStatement);
        if (result == null) result = caseNode(packageStatement);
        if (result == null) result = caseElement(packageStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.INCLUDE_STATEMENT:
      {
        IncludeStatement includeStatement = (IncludeStatement)theEObject;
        T result = caseIncludeStatement(includeStatement);
        if (result == null) result = caseExpressionStatement(includeStatement);
        if (result == null) result = caseStatementNode(includeStatement);
        if (result == null) result = caseNode(includeStatement);
        if (result == null) result = caseElement(includeStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.REQUIRE_INCLUDE:
      {
        RequireInclude requireInclude = (RequireInclude)theEObject;
        T result = caseRequireInclude(requireInclude);
        if (result == null) result = caseIncludeStatement(requireInclude);
        if (result == null) result = caseExpressionStatement(requireInclude);
        if (result == null) result = caseStatementNode(requireInclude);
        if (result == null) result = caseNode(requireInclude);
        if (result == null) result = caseElement(requireInclude);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.USE_INCLUDE:
      {
        UseInclude useInclude = (UseInclude)theEObject;
        T result = caseUseInclude(useInclude);
        if (result == null) result = caseIncludeStatement(useInclude);
        if (result == null) result = caseExpressionStatement(useInclude);
        if (result == null) result = caseStatementNode(useInclude);
        if (result == null) result = caseNode(useInclude);
        if (result == null) result = caseElement(useInclude);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.SUB_STATEMENT:
      {
        SubStatement subStatement = (SubStatement)theEObject;
        T result = caseSubStatement(subStatement);
        if (result == null) result = caseBlockStatement(subStatement);
        if (result == null) result = caseStatementNode(subStatement);
        if (result == null) result = caseNode(subStatement);
        if (result == null) result = caseElement(subStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.BLOCK_STRUCTURE:
      {
        BlockStructure blockStructure = (BlockStructure)theEObject;
        T result = caseBlockStructure(blockStructure);
        if (result == null) result = caseStructureNode(blockStructure);
        if (result == null) result = caseNode(blockStructure);
        if (result == null) result = caseElement(blockStructure);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.TOKEN:
      {
        Token token = (Token)theEObject;
        T result = caseToken(token);
        if (result == null) result = caseElement(token);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.QUOTE_TOKEN:
      {
        QuoteToken quoteToken = (QuoteToken)theEObject;
        T result = caseQuoteToken(quoteToken);
        if (result == null) result = caseToken(quoteToken);
        if (result == null) result = caseElement(quoteToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.REGEX_TOKEN:
      {
        RegexToken regexToken = (RegexToken)theEObject;
        T result = caseRegexToken(regexToken);
        if (result == null) result = caseToken(regexToken);
        if (result == null) result = caseElement(regexToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.QUOTE_LIKE_TOKEN:
      {
        QuoteLikeToken quoteLikeToken = (QuoteLikeToken)theEObject;
        T result = caseQuoteLikeToken(quoteLikeToken);
        if (result == null) result = caseToken(quoteLikeToken);
        if (result == null) result = caseElement(quoteLikeToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.POD_TOKEN:
      {
        PodToken podToken = (PodToken)theEObject;
        T result = casePodToken(podToken);
        if (result == null) result = caseToken(podToken);
        if (result == null) result = caseElement(podToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.NUMBER_TOKEN:
      {
        NumberToken numberToken = (NumberToken)theEObject;
        T result = caseNumberToken(numberToken);
        if (result == null) result = caseToken(numberToken);
        if (result == null) result = caseElement(numberToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.WORD_TOKEN:
      {
        WordToken wordToken = (WordToken)theEObject;
        T result = caseWordToken(wordToken);
        if (result == null) result = caseToken(wordToken);
        if (result == null) result = caseElement(wordToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.SYMBOL_TOKEN:
      {
        SymbolToken symbolToken = (SymbolToken)theEObject;
        T result = caseSymbolToken(symbolToken);
        if (result == null) result = caseToken(symbolToken);
        if (result == null) result = caseElement(symbolToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.OPERATOR_TOKEN:
      {
        OperatorToken operatorToken = (OperatorToken)theEObject;
        T result = caseOperatorToken(operatorToken);
        if (result == null) result = caseToken(operatorToken);
        if (result == null) result = caseElement(operatorToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.DATA_TOKEN:
      {
        DataToken dataToken = (DataToken)theEObject;
        T result = caseDataToken(dataToken);
        if (result == null) result = caseToken(dataToken);
        if (result == null) result = caseElement(dataToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.END_TOKEN:
      {
        EndToken endToken = (EndToken)theEObject;
        T result = caseEndToken(endToken);
        if (result == null) result = caseToken(endToken);
        if (result == null) result = caseElement(endToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.BACKTICK_QUOTE_LIKE_TOKEN:
      {
        BacktickQuoteLikeToken backtickQuoteLikeToken = (BacktickQuoteLikeToken)theEObject;
        T result = caseBacktickQuoteLikeToken(backtickQuoteLikeToken);
        if (result == null) result = caseQuoteLikeToken(backtickQuoteLikeToken);
        if (result == null) result = caseToken(backtickQuoteLikeToken);
        if (result == null) result = caseElement(backtickQuoteLikeToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.WORDS_QUOTE_LIKE_TOKEN:
      {
        WordsQuoteLikeToken wordsQuoteLikeToken = (WordsQuoteLikeToken)theEObject;
        T result = caseWordsQuoteLikeToken(wordsQuoteLikeToken);
        if (result == null) result = caseQuoteLikeToken(wordsQuoteLikeToken);
        if (result == null) result = caseToken(wordsQuoteLikeToken);
        if (result == null) result = caseElement(wordsQuoteLikeToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.COMMAND_QUOTE_LIKE_TOKEN:
      {
        CommandQuoteLikeToken commandQuoteLikeToken = (CommandQuoteLikeToken)theEObject;
        T result = caseCommandQuoteLikeToken(commandQuoteLikeToken);
        if (result == null) result = caseQuoteLikeToken(commandQuoteLikeToken);
        if (result == null) result = caseToken(commandQuoteLikeToken);
        if (result == null) result = caseElement(commandQuoteLikeToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.REGEXP_QUOTE_LIKE_TOKEN:
      {
        RegexpQuoteLikeToken regexpQuoteLikeToken = (RegexpQuoteLikeToken)theEObject;
        T result = caseRegexpQuoteLikeToken(regexpQuoteLikeToken);
        if (result == null) result = caseQuoteLikeToken(regexpQuoteLikeToken);
        if (result == null) result = caseToken(regexpQuoteLikeToken);
        if (result == null) result = caseElement(regexpQuoteLikeToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PerlPackage.READ_LINE_QUOTE_LIKE_TOKEN:
      {
        ReadLineQuoteLikeToken readLineQuoteLikeToken = (ReadLineQuoteLikeToken)theEObject;
        T result = caseReadLineQuoteLikeToken(readLineQuoteLikeToken);
        if (result == null) result = caseQuoteLikeToken(readLineQuoteLikeToken);
        if (result == null) result = caseToken(readLineQuoteLikeToken);
        if (result == null) result = caseElement(readLineQuoteLikeToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Document</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Document</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePerlDocument(PerlDocument object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNode(Node object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatementNode(StatementNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlockStatement(BlockStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionStatement(ExpressionStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Structure Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Structure Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructureNode(StructureNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageStatement(PackageStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Include Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Include Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIncludeStatement(IncludeStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Require Include</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Require Include</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequireInclude(RequireInclude object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Use Include</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Use Include</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUseInclude(UseInclude object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubStatement(SubStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block Structure</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block Structure</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlockStructure(BlockStructure object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseToken(Token object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Quote Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quote Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQuoteToken(QuoteToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Regex Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Regex Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRegexToken(RegexToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Quote Like Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quote Like Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQuoteLikeToken(QuoteLikeToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pod Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pod Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePodToken(PodToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberToken(NumberToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Word Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Word Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWordToken(WordToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Symbol Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Symbol Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSymbolToken(SymbolToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operator Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operator Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperatorToken(OperatorToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataToken(DataToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>End Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>End Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEndToken(EndToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Backtick Quote Like Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Backtick Quote Like Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBacktickQuoteLikeToken(BacktickQuoteLikeToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Words Quote Like Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Words Quote Like Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWordsQuoteLikeToken(WordsQuoteLikeToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command Quote Like Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command Quote Like Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommandQuoteLikeToken(CommandQuoteLikeToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Regexp Quote Like Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Regexp Quote Like Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRegexpQuoteLikeToken(RegexpQuoteLikeToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Read Line Quote Like Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Read Line Quote Like Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReadLineQuoteLikeToken(ReadLineQuoteLikeToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //PerlSwitch
