package org.epic.perl.tests

import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.epic.perl.perl.NumberLiteral
import org.epic.perl.perl.PerlModel
import org.epic.perl.perl.Plus
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.epic.perl.perl.VariableRef
import org.epic.perl.perl.Assignment

@RunWith(XtextRunner)
@InjectWith(PerlInjectorProvider)
class ExpressionParserTest {

	@Inject
	extension ParseHelper<PerlModel>

	@Inject
	extension ValidationTestHelper

	@Test
	def void numericExpression() {
		val result = parse('''
			1 + 2
		''')
		result.assertNoErrors
		Assert.assertTrue(result.class.name, result instanceof PerlModel)
		val expr = (result as PerlModel).elements.get(0)
		Assert.assertTrue(result.class.name, expr instanceof Plus)
		Assert.assertEquals("1", ((expr as Plus).left as NumberLiteral).value)
		Assert.assertEquals("2", ((expr as Plus).right as NumberLiteral).value)
	}

	@Test
	def void assignmentExpr() {
		val result = parse('''
			$a = 10
		''')
		result.assertNoErrors
		Assert.assertTrue(result.class.name, result instanceof PerlModel)
		val expr = (result as PerlModel).elements.get(0)
		Assert.assertTrue(expr.class.name, expr instanceof Assignment)
		Assert.assertEquals("$a", (expr as Assignment).variable);
	}

// @Test 
// def void simpleAssignment() {
// val result = parse('''
// $a = 10;
// ''')
// Assert.assertNotNull(result)
// }
//
// @Test 
// def void multiAssign() {
// val result = parse('''
// $a += 10;
// ''')
// Assert.assertNotNull(result)
// }
//
// @Test 
// def void equalityExpr() {
// val result = parse('''
// $a eq $b
// ''')
// Assert.assertNotNull(result)
// }
//
// @Test
// def void andExpr() {
// val result = parse('''
// $a && $b
// ''')
// Assert.assertNotNull(result)
// }
//
// @Test
// def void compareExpr() {
// val result = parse('''
// $a < $b
// ''')
// Assert.assertNotNull(result)
// }
}
