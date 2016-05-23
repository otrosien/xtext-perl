/**
 * generated by Xtext 2.10.0-SNAPSHOT
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
      case PerlPackage.PERL_MODEL: return createPerlModel();
      case PerlPackage.ABSTRACT_ELEMENT: return createAbstractElement();
      case PerlPackage.TOKEN: return createToken();
      case PerlPackage.QUOTE_LIKE_TOKEN: return createQuoteLikeToken();
      case PerlPackage.COMMENT_TOKEN: return createCommentToken();
      case PerlPackage.POD_TOKEN: return createPodToken();
      case PerlPackage.NUMBER_TOKEN: return createNumberToken();
      case PerlPackage.WORD_TOKEN: return createWordToken();
      case PerlPackage.OPERATOR_TOKEN: return createOperatorToken();
      case PerlPackage.QUOTE_TOKEN: return createQuoteToken();
      case PerlPackage.DATA_TOKEN: return createDataToken();
      case PerlPackage.END_TOKEN: return createEndToken();
      case PerlPackage.BACKTICK_QUOTE_LIKE_TOKEN: return createBacktickQuoteLikeToken();
      case PerlPackage.WORDS_QUOTE_LIKE_TOKEN: return createWordsQuoteLikeToken();
      case PerlPackage.COMMAND_QUOTE_LIKE_TOKEN: return createCommandQuoteLikeToken();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PerlModel createPerlModel()
  {
    PerlModelImpl perlModel = new PerlModelImpl();
    return perlModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractElement createAbstractElement()
  {
    AbstractElementImpl abstractElement = new AbstractElementImpl();
    return abstractElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Token createToken()
  {
    TokenImpl token = new TokenImpl();
    return token;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuoteLikeToken createQuoteLikeToken()
  {
    QuoteLikeTokenImpl quoteLikeToken = new QuoteLikeTokenImpl();
    return quoteLikeToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommentToken createCommentToken()
  {
    CommentTokenImpl commentToken = new CommentTokenImpl();
    return commentToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PodToken createPodToken()
  {
    PodTokenImpl podToken = new PodTokenImpl();
    return podToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumberToken createNumberToken()
  {
    NumberTokenImpl numberToken = new NumberTokenImpl();
    return numberToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WordToken createWordToken()
  {
    WordTokenImpl wordToken = new WordTokenImpl();
    return wordToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperatorToken createOperatorToken()
  {
    OperatorTokenImpl operatorToken = new OperatorTokenImpl();
    return operatorToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuoteToken createQuoteToken()
  {
    QuoteTokenImpl quoteToken = new QuoteTokenImpl();
    return quoteToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataToken createDataToken()
  {
    DataTokenImpl dataToken = new DataTokenImpl();
    return dataToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EndToken createEndToken()
  {
    EndTokenImpl endToken = new EndTokenImpl();
    return endToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktickQuoteLikeToken createBacktickQuoteLikeToken()
  {
    BacktickQuoteLikeTokenImpl backtickQuoteLikeToken = new BacktickQuoteLikeTokenImpl();
    return backtickQuoteLikeToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WordsQuoteLikeToken createWordsQuoteLikeToken()
  {
    WordsQuoteLikeTokenImpl wordsQuoteLikeToken = new WordsQuoteLikeTokenImpl();
    return wordsQuoteLikeToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommandQuoteLikeToken createCommandQuoteLikeToken()
  {
    CommandQuoteLikeTokenImpl commandQuoteLikeToken = new CommandQuoteLikeTokenImpl();
    return commandQuoteLikeToken;
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
