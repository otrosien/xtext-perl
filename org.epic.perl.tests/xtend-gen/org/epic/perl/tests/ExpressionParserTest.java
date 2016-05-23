package org.epic.perl.tests;

import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.epic.perl.perl.AbstractElement;
import org.epic.perl.perl.Assignment;
import org.epic.perl.perl.Expression;
import org.epic.perl.perl.NumberLiteral;
import org.epic.perl.perl.PerlModel;
import org.epic.perl.perl.Plus;
import org.epic.perl.tests.PerlInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(PerlInjectorProvider.class)
@SuppressWarnings("all")
public class ExpressionParserTest {
  @Inject
  @Extension
  private ParseHelper<PerlModel> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void numericExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("1 + 2");
      _builder.newLine();
      final PerlModel result = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(result);
      Class<? extends PerlModel> _class = result.getClass();
      String _name = _class.getName();
      Assert.assertTrue(_name, (result instanceof PerlModel));
      EList<AbstractElement> _elements = ((PerlModel) result).getElements();
      final AbstractElement expr = _elements.get(0);
      Class<? extends PerlModel> _class_1 = result.getClass();
      String _name_1 = _class_1.getName();
      Assert.assertTrue(_name_1, (expr instanceof Plus));
      Expression _left = ((Plus) expr).getLeft();
      String _value = ((NumberLiteral) _left).getValue();
      Assert.assertEquals("1", _value);
      Expression _right = ((Plus) expr).getRight();
      String _value_1 = ((NumberLiteral) _right).getValue();
      Assert.assertEquals("2", _value_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void assignmentExpr() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("$a = 10");
      _builder.newLine();
      final PerlModel result = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(result);
      Class<? extends PerlModel> _class = result.getClass();
      String _name = _class.getName();
      Assert.assertTrue(_name, (result instanceof PerlModel));
      EList<AbstractElement> _elements = ((PerlModel) result).getElements();
      final AbstractElement expr = _elements.get(0);
      Class<? extends AbstractElement> _class_1 = expr.getClass();
      String _name_1 = _class_1.getName();
      Assert.assertTrue(_name_1, (expr instanceof Assignment));
      String _variable = ((Assignment) expr).getVariable();
      Assert.assertEquals("$a", _variable);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
