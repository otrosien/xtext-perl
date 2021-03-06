package org.epic.perl.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.epic.perl.perl.BacktickQuoteLikeToken
import org.epic.perl.perl.NumberToken
import org.epic.perl.perl.PerlDocument
import org.epic.perl.perl.PodToken
import org.epic.perl.perl.QuoteToken
import org.epic.perl.perl.ReadLineQuoteLikeToken
import org.epic.perl.perl.RegexpQuoteLikeToken
import org.epic.perl.perl.SymbolToken
import org.epic.perl.perl.WordToken
import org.epic.perl.perl.WordsQuoteLikeToken
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.epic.perl.perl.RegexToken
import org.epic.perl.perl.CastToken

@RunWith(XtextRunner)
@InjectWith(PerlInjectorProvider)
class TokenParserTest {

    @Inject
    extension ParseHelper<PerlDocument>

    @Inject
    extension ValidationTestHelper

    @Inject
    extension DumpUtil

    @Test
    def void commentToken() {
        _parseDocument('''
            # comment
        ''')
    }

    @Test
    def void stringToken() {
        val token = _parseDocument('''
            "10"
        ''').elements.head as QuoteToken
        Assert.assertEquals('10', token.content)
    }

    @Test
    def void singleQuoteStringToken() {
        val token = _parseDocument('''
            'test'
        ''').elements.head as QuoteToken
        Assert.assertEquals('test', token.content)
    }

    @Test
    def void undefToken() {
        val token = _parseDocument('''
            undef
        ''').elements.head as WordToken
        Assert.assertEquals('undef', token.content)
    }

    @Test
    def void numberToken() {
        val token = _parseDocument('''
            123.45
        ''').elements.head as NumberToken
        Assert.assertEquals('123.45', token.content)
    }

    @Test
    def void hexNumberToken() {
        val token = _parseDocument('''
            0x10
        ''').elements.head as NumberToken
        Assert.assertEquals('0x10', token.content)
    }

    @Test
    def void backtickQuoteLike() {
        val token = _parseDocument('''
            `abc`
        ''').elements.head as BacktickQuoteLikeToken
        Assert.assertEquals('`abc`', token.content)
    }

    @Test
    def void wordsQuoteLike() {
        val token = _parseDocument('''
            qw {a b c}
        ''').elements.head as WordsQuoteLikeToken
        Assert.assertEquals('qw {a b c}', token.content)
    }

    @Test
    def void interpolateQuoteLike() {
        val token = _parseDocument('''
            qq{a b c}
        ''').elements.head as QuoteToken
        Assert.assertEquals('qq{a b c}', token.content)
    }

    @Test
    def void regexQuoteLike() {
        val token = _parseDocument('''
            qr/a+b/
        ''').elements.head as RegexpQuoteLikeToken
        Assert.assertEquals('qr/a+b/', token.content)
    }

    @Test
    def void readlineQuoteLike() {
        val token = _parseDocument('''
            <FILE>
        ''').elements.head as ReadLineQuoteLikeToken
        Assert.assertEquals('<FILE>', token.content)
    }

    @Test
    def void readlineQuoteLikeWithVar() {
        val token = _parseDocument('''
            <$FILE>
        ''').elements.head as ReadLineQuoteLikeToken
        Assert.assertEquals('<$FILE>', token.content)
    }

    @Test
    def void pod() {
        val token = _parseDocument('''
            =pod
            
            Test POD
            
            =cut
           ''').elements.head as PodToken
        Assert.assertEquals('''
        =pod
        
        Test POD
        
        =cut'''.toString, token.content.trim)
    }

    @Test
    def void simpleSymbol() {
        val token = _parseDocument('''
            $file
        ''').elements.head as SymbolToken
        Assert.assertEquals('$file', token.content)
    }

    @Test
    def void qualifiedSymbol() {
        val token = _parseDocument('''
            $Some::Package::Var
        ''').elements.head as SymbolToken
        Assert.assertEquals('$Some::Package::Var', token.content)
    }

    @Test
    def void regexSubstitute() {
        val token = _parseDocument('''
            s/a/b/
        ''').elements.head as RegexToken
        Assert.assertEquals('s/a/b/', token.content)
    }

    @Test
    def void regexMatch() {
        val token = _parseDocument('''
            m/.*?/
        ''').elements.head as RegexToken
        Assert.assertEquals('m/.*?/', token.content)
    }

    @Test
    def void arrayDeref() {
        val token = _parseDocument('''
            @{$foo}
        ''').elements.head as CastToken
        Assert.assertEquals('$foo',token.symbol)
    }

    private def PerlDocument _parseDocument(String str) {
        val result = parse(str)
        result.assertNoErrors
        println(result.dump)
        return result
    }
}
