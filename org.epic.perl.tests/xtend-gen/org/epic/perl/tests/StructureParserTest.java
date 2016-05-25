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
import org.epic.perl.perl.Element;
import org.epic.perl.perl.PackageStatement;
import org.epic.perl.perl.PerlDocument;
import org.epic.perl.perl.QuoteToken;
import org.epic.perl.perl.StatementBlock;
import org.epic.perl.perl.StatementNode;
import org.epic.perl.perl.SubStatement;
import org.epic.perl.perl.UseInclude;
import org.epic.perl.tests.DumpUtil;
import org.epic.perl.tests.PerlInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(PerlInjectorProvider.class)
@SuppressWarnings("all")
public class StructureParserTest {
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
  public void packageStruct() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package My::Module::Test;");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final PackageStatement token = ((PackageStatement) _head);
    String _name = token.getName();
    Assert.assertEquals("My::Module::Test", _name);
  }
  
  @Test
  public void packageWithVersionStruct() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package My::Module::Test v4.12.0;");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final PackageStatement token = ((PackageStatement) _head);
    String _version = token.getVersion();
    Assert.assertEquals("v4.12.0", _version);
  }
  
  @Test
  public void useVersion() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("use v5.12.0;");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final UseInclude token = ((UseInclude) _head);
    String _version = token.getVersion();
    Assert.assertEquals("v5.12.0", _version);
  }
  
  @Test
  public void usePragma() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("use feature \'say\';");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final UseInclude token = ((UseInclude) _head);
    String _pragmaOrPackage = token.getPragmaOrPackage();
    Assert.assertEquals("feature", _pragmaOrPackage);
    QuoteToken _stringArgument = token.getStringArgument();
    String _content = _stringArgument.getContent();
    Assert.assertEquals("say", _content);
  }
  
  @Test
  public void useModule() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("use URI::URL;");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final UseInclude token = ((UseInclude) _head);
    String _pragmaOrPackage = token.getPragmaOrPackage();
    Assert.assertEquals("URI::URL", _pragmaOrPackage);
  }
  
  @Test
  public void useModuleWithQuoteWords() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("use URI::URL qw( test );");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final UseInclude token = ((UseInclude) _head);
    String _pragmaOrPackage = token.getPragmaOrPackage();
    Assert.assertEquals("URI::URL", _pragmaOrPackage);
    String _qwArgument = token.getQwArgument();
    Assert.assertEquals("qw( test )", _qwArgument);
  }
  
  @Test
  public void emptySub() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sub abc {}");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final SubStatement token = ((SubStatement) _head);
    String _name = token.getName();
    Assert.assertEquals("abc", _name);
    StatementBlock _block = token.getBlock();
    EList<StatementNode> _statements = _block.getStatements();
    int _size = _statements.size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void subWithPrototype() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sub someFunc($$;@) {}");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final SubStatement token = ((SubStatement) _head);
    String _name = token.getName();
    Assert.assertEquals("someFunc", _name);
    String _prototype = token.getPrototype();
    Assert.assertEquals("($$;@)", _prototype);
  }
  
  @Test
  public void subForwardDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sub someFunc($$;@);");
    _builder.newLine();
    PerlDocument __parseDocument = this._parseDocument(_builder.toString());
    EList<Element> _elements = __parseDocument.getElements();
    Element _head = IterableExtensions.<Element>head(_elements);
    final SubStatement token = ((SubStatement) _head);
    String _name = token.getName();
    Assert.assertEquals("someFunc", _name);
    StatementBlock _block = token.getBlock();
    Assert.assertNull(_block);
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
