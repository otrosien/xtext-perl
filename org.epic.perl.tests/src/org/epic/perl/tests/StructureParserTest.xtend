package org.epic.perl.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.epic.perl.perl.PackageStatement
import org.epic.perl.perl.PerlDocument
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(PerlInjectorProvider)
class StructureParserTest {

	@Inject
	extension ParseHelper<PerlDocument>

	@Inject
	extension ValidationTestHelper

	@Inject
	extension DumpUtil

	@Test
	def void packageStruct() {
		val token = _parseDocument('''
			package My::Module::Test;
		''').elements.head as PackageStatement
		Assert.assertEquals('My::Module::Test', token.name)
	}

	@Test
	def void packageWithVersionStruct() {
		val token = _parseDocument('''
			package My::Module::Test v4.12.0;
		''').elements.head as PackageStatement
		Assert.assertEquals('v4.12.0', token.version)
	}
	
	private def PerlDocument _parseDocument(String str) {
		val result = parse(str)
		result.assertNoErrors
		println(result.dump)
		Assert.assertTrue(result.class.name, result instanceof PerlDocument)
		return result
	}
}