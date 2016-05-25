package org.epic.perl.tests;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.epic.perl.perl.BacktickQuoteLikeToken;
import org.epic.perl.perl.Element;
import org.epic.perl.perl.NumberToken;
import org.epic.perl.perl.PerlDocument;
import org.epic.perl.perl.PodToken;
import org.epic.perl.perl.QuoteToken;
import org.epic.perl.perl.ReadLineQuoteLikeToken;
import org.epic.perl.perl.RegexToken;
import org.epic.perl.perl.RegexpQuoteLikeToken;
import org.epic.perl.perl.SymbolToken;
import org.epic.perl.perl.WordToken;
import org.epic.perl.perl.WordsQuoteLikeToken;
import org.epic.perl.tests.DumpUtil;
import org.epic.perl.tests.PerlInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(PerlInjectorProvider.class)
@SuppressWarnings("all")
public class TokenParserTest {
  @Inject
  @Extension
  private ParseHelper<PerlDocument> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private DumpUtil _dumpUtil;
  
  @Test
  public void commentToken() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("# comment");
    _builder.newLine();
    this._parseDocument(_builder.toString());
  }
  
  @Test
  public void stringToken() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"10\"");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final QuoteToken token = ((QuoteToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("10", _content);
  }
  
  @Test
  public void singleQuoteStringToken() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\'test\'");
      _builder.newLine();
      final PerlDocument result = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(result);
      String _dump = this._dumpUtil.dump(result);
      InputOutput.<String>println(_dump);
      Class<? extends PerlDocument> _class = result.getClass();
      String _name = _class.getName();
      Assert.assertTrue(_name, (result instanceof PerlDocument));
      EList<Element> _elements = ((PerlDocument) result).getElements();
      final Element token = IterableExtensions.<Element>head(_elements);
      Class<? extends Element> _class_1 = token.getClass();
      String _name_1 = _class_1.getName();
      Assert.assertTrue(_name_1, (token instanceof QuoteToken));
      String _content = ((QuoteToken) token).getContent();
      Assert.assertEquals("test", _content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void undefToken() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("undef");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final WordToken token = ((WordToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("undef", _content);
  }
  
  @Test
  public void numberToken() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("123.45");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final NumberToken token = ((NumberToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("123.45", _content);
  }
  
  @Test
  public void hexNumberToken() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0x10");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final NumberToken token = ((NumberToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("0x10", _content);
  }
  
  @Test
  public void backtickQuoteLike() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("`abc`");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final BacktickQuoteLikeToken token = ((BacktickQuoteLikeToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("`abc`", _content);
  }
  
  @Test
  public void wordsQuoteLike() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("qw {a b c}");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final WordsQuoteLikeToken token = ((WordsQuoteLikeToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("qw {a b c}", _content);
  }
  
  @Test
  public void interpolateQuoteLike() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("qq{a b c}");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final QuoteToken token = ((QuoteToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("qq{a b c}", _content);
  }
  
  @Test
  public void regexQuoteLike() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("qr/a+b/");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final RegexpQuoteLikeToken token = ((RegexpQuoteLikeToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("qr/a+b/", _content);
  }
  
  @Test
  public void readlineQuoteLike() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<FILE>");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final ReadLineQuoteLikeToken token = ((ReadLineQuoteLikeToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("<FILE>", _content);
  }
  
  @Test
  public void readlineQuoteLikeWithVar() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<$FILE>");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final ReadLineQuoteLikeToken token = ((ReadLineQuoteLikeToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("<$FILE>", _content);
  }
  
  @Test
  public void pod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=pod");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Test POD");
    _builder.newLine();
    _builder.newLine();
    _builder.append("=cut");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final PodToken token = ((PodToken) _head);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("=pod");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Test POD");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("=cut");
    String _string = _builder_1.toString();
    String _content = token.getContent();
    Assert.assertEquals(_string, _content);
  }
  
  @Test
  public void simpleSymbol() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$file");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final SymbolToken token = ((SymbolToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("$file", _content);
  }
  
  @Test
  public void qualifiedSymbol() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$Some::Package::Var");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final SymbolToken token = ((SymbolToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("$Some::Package::Var", _content);
  }
  
  @Test
  public void regexSubstitute() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("s/a/b/");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final RegexToken token = ((RegexToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("s/a/b/", _content);
  }
  
  @Test
  public void regexMatch() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("m/.*?/");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final RegexToken token = ((RegexToken) _head);
    String _content = token.getContent();
    Assert.assertEquals("m/.*?/", _content);
  }
  
  private PerlDocument _parseDocument(final String str) {
    try {
      final PerlDocument result = this._parseHelper.parse(str);
      this._validationTestHelper.assertNoErrors(result);
      String _dump = this._dumpUtil.dump(result);
      InputOutput.<String>println(_dump);
      Class<? extends PerlDocument> _class = result.getClass();
      String _name = _class.getName();
      Assert.assertTrue(_name, (result instanceof PerlDocument));
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
