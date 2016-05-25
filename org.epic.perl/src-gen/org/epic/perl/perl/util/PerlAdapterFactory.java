/**
 * generated by Xtext 2.10.0-SNAPSHOT
 */
package org.epic.perl.perl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.epic.perl.perl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.epic.perl.perl.PerlPackage
 * @generated
 */
public class PerlAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PerlPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PerlAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PerlPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PerlSwitch<Adapter> modelSwitch =
    new PerlSwitch<Adapter>()
    {
      @Override
      public Adapter casePerlDocument(PerlDocument object)
      {
        return createPerlDocumentAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter caseNode(Node object)
      {
        return createNodeAdapter();
      }
      @Override
      public Adapter caseStatementNode(StatementNode object)
      {
        return createStatementNodeAdapter();
      }
      @Override
      public Adapter caseBlockStatement(BlockStatement object)
      {
        return createBlockStatementAdapter();
      }
      @Override
      public Adapter caseExpressionStatement(ExpressionStatement object)
      {
        return createExpressionStatementAdapter();
      }
      @Override
      public Adapter casePackageStatement(PackageStatement object)
      {
        return createPackageStatementAdapter();
      }
      @Override
      public Adapter caseIncludeStatement(IncludeStatement object)
      {
        return createIncludeStatementAdapter();
      }
      @Override
      public Adapter caseRequireInclude(RequireInclude object)
      {
        return createRequireIncludeAdapter();
      }
      @Override
      public Adapter caseUseInclude(UseInclude object)
      {
        return createUseIncludeAdapter();
      }
      @Override
      public Adapter caseSubStatement(SubStatement object)
      {
        return createSubStatementAdapter();
      }
      @Override
      public Adapter caseStatementBlock(StatementBlock object)
      {
        return createStatementBlockAdapter();
      }
      @Override
      public Adapter caseToken(Token object)
      {
        return createTokenAdapter();
      }
      @Override
      public Adapter caseRegexToken(RegexToken object)
      {
        return createRegexTokenAdapter();
      }
      @Override
      public Adapter caseQuoteToken(QuoteToken object)
      {
        return createQuoteTokenAdapter();
      }
      @Override
      public Adapter caseQuoteLikeToken(QuoteLikeToken object)
      {
        return createQuoteLikeTokenAdapter();
      }
      @Override
      public Adapter casePodToken(PodToken object)
      {
        return createPodTokenAdapter();
      }
      @Override
      public Adapter caseNumberToken(NumberToken object)
      {
        return createNumberTokenAdapter();
      }
      @Override
      public Adapter caseWordToken(WordToken object)
      {
        return createWordTokenAdapter();
      }
      @Override
      public Adapter caseSymbolToken(SymbolToken object)
      {
        return createSymbolTokenAdapter();
      }
      @Override
      public Adapter caseOperatorToken(OperatorToken object)
      {
        return createOperatorTokenAdapter();
      }
      @Override
      public Adapter caseDataToken(DataToken object)
      {
        return createDataTokenAdapter();
      }
      @Override
      public Adapter caseEndToken(EndToken object)
      {
        return createEndTokenAdapter();
      }
      @Override
      public Adapter caseBacktickQuoteLikeToken(BacktickQuoteLikeToken object)
      {
        return createBacktickQuoteLikeTokenAdapter();
      }
      @Override
      public Adapter caseWordsQuoteLikeToken(WordsQuoteLikeToken object)
      {
        return createWordsQuoteLikeTokenAdapter();
      }
      @Override
      public Adapter caseCommandQuoteLikeToken(CommandQuoteLikeToken object)
      {
        return createCommandQuoteLikeTokenAdapter();
      }
      @Override
      public Adapter caseRegexpQuoteLikeToken(RegexpQuoteLikeToken object)
      {
        return createRegexpQuoteLikeTokenAdapter();
      }
      @Override
      public Adapter caseReadLineQuoteLikeToken(ReadLineQuoteLikeToken object)
      {
        return createReadLineQuoteLikeTokenAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.PerlDocument <em>Document</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.PerlDocument
   * @generated
   */
  public Adapter createPerlDocumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.Node
   * @generated
   */
  public Adapter createNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.StatementNode <em>Statement Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.StatementNode
   * @generated
   */
  public Adapter createStatementNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.BlockStatement <em>Block Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.BlockStatement
   * @generated
   */
  public Adapter createBlockStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.ExpressionStatement
   * @generated
   */
  public Adapter createExpressionStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.PackageStatement <em>Package Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.PackageStatement
   * @generated
   */
  public Adapter createPackageStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.IncludeStatement <em>Include Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.IncludeStatement
   * @generated
   */
  public Adapter createIncludeStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.RequireInclude <em>Require Include</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.RequireInclude
   * @generated
   */
  public Adapter createRequireIncludeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.UseInclude <em>Use Include</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.UseInclude
   * @generated
   */
  public Adapter createUseIncludeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.SubStatement <em>Sub Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.SubStatement
   * @generated
   */
  public Adapter createSubStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.StatementBlock <em>Statement Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.StatementBlock
   * @generated
   */
  public Adapter createStatementBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.Token <em>Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.Token
   * @generated
   */
  public Adapter createTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.RegexToken <em>Regex Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.RegexToken
   * @generated
   */
  public Adapter createRegexTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.QuoteToken <em>Quote Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.QuoteToken
   * @generated
   */
  public Adapter createQuoteTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.QuoteLikeToken <em>Quote Like Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.QuoteLikeToken
   * @generated
   */
  public Adapter createQuoteLikeTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.PodToken <em>Pod Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.PodToken
   * @generated
   */
  public Adapter createPodTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.NumberToken <em>Number Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.NumberToken
   * @generated
   */
  public Adapter createNumberTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.WordToken <em>Word Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.WordToken
   * @generated
   */
  public Adapter createWordTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.SymbolToken <em>Symbol Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.SymbolToken
   * @generated
   */
  public Adapter createSymbolTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.OperatorToken <em>Operator Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.OperatorToken
   * @generated
   */
  public Adapter createOperatorTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.DataToken <em>Data Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.DataToken
   * @generated
   */
  public Adapter createDataTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.EndToken <em>End Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.EndToken
   * @generated
   */
  public Adapter createEndTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.BacktickQuoteLikeToken <em>Backtick Quote Like Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.BacktickQuoteLikeToken
   * @generated
   */
  public Adapter createBacktickQuoteLikeTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.WordsQuoteLikeToken <em>Words Quote Like Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.WordsQuoteLikeToken
   * @generated
   */
  public Adapter createWordsQuoteLikeTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.CommandQuoteLikeToken <em>Command Quote Like Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.CommandQuoteLikeToken
   * @generated
   */
  public Adapter createCommandQuoteLikeTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.RegexpQuoteLikeToken <em>Regexp Quote Like Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.RegexpQuoteLikeToken
   * @generated
   */
  public Adapter createRegexpQuoteLikeTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.epic.perl.perl.ReadLineQuoteLikeToken <em>Read Line Quote Like Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.epic.perl.perl.ReadLineQuoteLikeToken
   * @generated
   */
  public Adapter createReadLineQuoteLikeTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //PerlAdapterFactory
