package org.epic.perl.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.epic.perl.perl.PackageStatement
import org.epic.perl.perl.PerlDocument
import org.epic.perl.perl.SubBlock
import org.epic.perl.perl.UseInclude
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.epic.perl.perl.NoPragmaInclude
import org.epic.perl.perl.LabelBlock
import org.epic.perl.perl.BreakExpression
import org.epic.perl.perl.VariableExpression

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
    def void noPragma() {
        val token = _parseDocument('''
            no warnings;
        ''').elements.head as NoPragmaInclude
        Assert.assertEquals('warnings', token.pragma)
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
        ''').elements.head as SubBlock
        Assert.assertEquals('abc', token.name)
        Assert.assertEquals(0, token.block.elements.size)
    }

    @Test
    def void subWithPrototype() {
        val token = _parseDocument('''
            sub someFunc($$;@) {}
        ''').elements.head as SubBlock
        Assert.assertEquals('someFunc', token.name)
        Assert.assertEquals('($$;@)', token.prototype)
    }

    @Test
    def void subForwardDeclaration() {
        val token = _parseDocument('''
            sub someFunc($$;@);
        ''').elements.head as SubBlock
        Assert.assertEquals('someFunc', token.name)
        Assert.assertNull(token.block)
    }

    @Test
    def void labelDeclaration() {
        val token = _parseDocument('''
            SKIP: {
                last;
            }
        ''').elements.head as LabelBlock
        Assert.assertEquals('SKIP', token.label)
        Assert.assertNotNull(token.block)
        Assert.assertEquals('last', (token.block.elements.head as BreakExpression).statement)
    }

    @Test
    def void variableDeclaration() {
        val token = _parseDocument('''
            my $token;
        ''').elements.head as VariableExpression
        Assert.assertEquals('$token', token.variable.name)
        Assert.assertEquals('my', token.type)
    }

    @Test
    def void variableListDeclaration() {
        val token = _parseDocument('''
            our ($a,$b);
        ''').elements.head as VariableExpression
        Assert.assertEquals('$a', token.variables.get(0).name)
        Assert.assertEquals('$b', token.variables.get(1).name)
        Assert.assertEquals('our', token.type)
    }

    private def PerlDocument _parseDocument(String str) {
        val result = parse(str)
        result.assertNoErrors
        println(result.dump)
        return result
    }
}
