package org.epic.perl.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.epic.perl.perl.PackageStatement
import org.epic.perl.perl.PerlDocument
import org.epic.perl.perl.SubStatement
import org.epic.perl.perl.UseInclude
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

    @Test
    def void useVersion() {
        val token = _parseDocument('''
            use v5.12.0;
        ''').elements.head as UseInclude
        Assert.assertEquals('v5.12.0', token.version)
    }

    @Test
    def void usePragma() {
        val token = _parseDocument('''
            use feature 'say';
        ''').elements.head as UseInclude
        Assert.assertEquals('feature', token.pragma)
        Assert.assertEquals('say', token.stringArgument.content)
    }

    @Test
    def void useModule() {
        val token = _parseDocument('''
            package URI::URL; # declare package (required for cross-ref)
            use URI::URL;
        ''').elements.get(1) as UseInclude
        Assert.assertEquals('URI::URL', token.package.name)
    }

    @Test
    def void useModuleWithQuoteWords() {
        val token = _parseDocument('''
            package URI::URL; # declare package (required for cross-ref)
            use URI::URL qw( test );
        ''').elements.get(1) as UseInclude
        Assert.assertEquals('URI::URL', token.package.name)
        Assert.assertEquals('qw( test )', token.qwArgument)
    }

    @Test
    def void emptySub() {
        val token = _parseDocument('''
            sub abc {}
        ''').elements.head as SubStatement
        Assert.assertEquals('abc', token.name)
        Assert.assertEquals(0, token.block.statements.size)
    }

    @Test
    def void subWithPrototype() {
        val token = _parseDocument('''
            sub someFunc($$;@) {}
        ''').elements.head as SubStatement
        Assert.assertEquals('someFunc', token.name)
        Assert.assertEquals('($$;@)', token.prototype)
    }

    @Test
    def void subForwardDeclaration() {
        val token = _parseDocument('''
            sub someFunc($$;@);
        ''').elements.head as SubStatement
        Assert.assertEquals('someFunc', token.name)
        Assert.assertNull(token.block)
    }

    private def PerlDocument _parseDocument(String str) {
        val result = parse(str)
        result.assertNoErrors
        println(result.dump)
        Assert.assertTrue(result.class.name, result instanceof PerlDocument)
        return result
    }
}
