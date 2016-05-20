package org.epic.perl.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPerlLexer extends Lexer {
    public static final int RULE_HEX=4;
    public static final int T__50=50;
    public static final int RULE_OCT=6;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int RULE_BIN=5;
    public static final int T__54=54;
    public static final int RULE_ID=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=10;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=12;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_VAR_START=8;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators

    public InternalPerlLexer() {;} 
    public InternalPerlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalPerlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalPerl.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:11:7: ( '=' )
            // InternalPerl.g:11:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:12:7: ( '||' )
            // InternalPerl.g:12:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:13:7: ( '&&' )
            // InternalPerl.g:13:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:14:7: ( '+=' )
            // InternalPerl.g:14:9: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:15:7: ( '-=' )
            // InternalPerl.g:15:9: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:16:7: ( '*=' )
            // InternalPerl.g:16:9: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:17:7: ( '/=' )
            // InternalPerl.g:17:9: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:18:7: ( '%=' )
            // InternalPerl.g:18:9: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:19:7: ( '**=' )
            // InternalPerl.g:19:9: '**='
            {
            match("**="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:20:7: ( '==' )
            // InternalPerl.g:20:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:21:7: ( '!=' )
            // InternalPerl.g:21:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:22:7: ( 'eq' )
            // InternalPerl.g:22:9: 'eq'
            {
            match("eq"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:23:7: ( 'ne' )
            // InternalPerl.g:23:9: 'ne'
            {
            match("ne"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:24:7: ( '>=' )
            // InternalPerl.g:24:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:25:7: ( '>' )
            // InternalPerl.g:25:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:26:7: ( '<' )
            // InternalPerl.g:26:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:27:7: ( '<>' )
            // InternalPerl.g:27:9: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:28:7: ( '?:' )
            // InternalPerl.g:28:9: '?:'
            {
            match("?:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:29:7: ( '=>' )
            // InternalPerl.g:29:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:30:7: ( '+' )
            // InternalPerl.g:30:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:31:7: ( '-' )
            // InternalPerl.g:31:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:32:7: ( '*' )
            // InternalPerl.g:32:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:33:7: ( '**' )
            // InternalPerl.g:33:9: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:34:7: ( '/' )
            // InternalPerl.g:34:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:35:7: ( '%' )
            // InternalPerl.g:35:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:36:7: ( '!' )
            // InternalPerl.g:36:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:37:7: ( '++' )
            // InternalPerl.g:37:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:38:7: ( '--' )
            // InternalPerl.g:38:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:39:7: ( 'my' )
            // InternalPerl.g:39:9: 'my'
            {
            match("my"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:40:7: ( 'our' )
            // InternalPerl.g:40:9: 'our'
            {
            match("our"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:41:7: ( 'local' )
            // InternalPerl.g:41:9: 'local'
            {
            match("local"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:42:7: ( '}' )
            // InternalPerl.g:42:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:43:7: ( 'sub' )
            // InternalPerl.g:43:9: 'sub'
            {
            match("sub"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:44:7: ( '{' )
            // InternalPerl.g:44:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:45:7: ( ';' )
            // InternalPerl.g:45:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:46:7: ( '(' )
            // InternalPerl.g:46:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:47:7: ( ')' )
            // InternalPerl.g:47:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:48:7: ( 'if' )
            // InternalPerl.g:48:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:49:7: ( 'else' )
            // InternalPerl.g:49:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:50:7: ( 'undef' )
            // InternalPerl.g:50:9: 'undef'
            {
            match("undef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:51:7: ( 'return' )
            // InternalPerl.g:51:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:52:7: ( '::' )
            // InternalPerl.g:52:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "RULE_VAR_START"
    public final void mRULE_VAR_START() throws RecognitionException {
        try {
            int _type = RULE_VAR_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:5431:16: ( ( '@' | '$' | '%' ) ( '@' | '$' | '%' | '*' | '#' )* )
            // InternalPerl.g:5431:18: ( '@' | '$' | '%' ) ( '@' | '$' | '%' | '*' | '#' )*
            {
            if ( (input.LA(1)>='$' && input.LA(1)<='%')||input.LA(1)=='@' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalPerl.g:5431:32: ( '@' | '$' | '%' | '*' | '#' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='#' && LA1_0<='%')||LA1_0=='*'||LA1_0=='@') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPerl.g:
            	    {
            	    if ( (input.LA(1)>='#' && input.LA(1)<='%')||input.LA(1)=='*'||input.LA(1)=='@' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VAR_START"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:5433:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalPerl.g:5433:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalPerl.g:5433:35: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalPerl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:5435:10: ( '1' .. '9' ( '0' .. '9' | '_' )* )
            // InternalPerl.g:5435:12: '1' .. '9' ( '0' .. '9' | '_' )*
            {
            matchRange('1','9'); 
            // InternalPerl.g:5435:21: ( '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||LA3_0=='_') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPerl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='_' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_OCT"
    public final void mRULE_OCT() throws RecognitionException {
        try {
            int _type = RULE_OCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:5437:10: ( '0' ( '0' .. '7' | '_' )+ )
            // InternalPerl.g:5437:12: '0' ( '0' .. '7' | '_' )+
            {
            match('0'); 
            // InternalPerl.g:5437:16: ( '0' .. '7' | '_' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='7')||LA4_0=='_') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalPerl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='7')||input.LA(1)=='_' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OCT"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:5439:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ )
            // InternalPerl.g:5439:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            {
            // InternalPerl.g:5439:12: ( '0x' | '0X' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='0') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='x') ) {
                    alt5=1;
                }
                else if ( (LA5_1=='X') ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalPerl.g:5439:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // InternalPerl.g:5439:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // InternalPerl.g:5439:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='F')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='f')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalPerl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_BIN"
    public final void mRULE_BIN() throws RecognitionException {
        try {
            int _type = RULE_BIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:5441:10: ( '0b' ( '0' .. '1' | '_' )+ )
            // InternalPerl.g:5441:12: '0b' ( '0' .. '1' | '_' )+
            {
            match("0b"); 

            // InternalPerl.g:5441:17: ( '0' .. '1' | '_' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='1')||LA7_0=='_') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPerl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='1')||input.LA(1)=='_' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIN"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:5443:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalPerl.g:5443:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalPerl.g:5443:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalPerl.g:5443:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalPerl.g:5443:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalPerl.g:5443:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalPerl.g:5443:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:5443:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalPerl.g:5443:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalPerl.g:5443:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalPerl.g:5443:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:5445:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalPerl.g:5445:19: '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match('#'); 
            // InternalPerl.g:5445:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalPerl.g:5445:23: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalPerl.g:5445:39: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalPerl.g:5445:40: ( '\\r' )? '\\n'
                    {
                    // InternalPerl.g:5445:40: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalPerl.g:5445:40: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:5447:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalPerl.g:5447:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalPerl.g:5447:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalPerl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:5449:16: ( . )
            // InternalPerl.g:5449:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalPerl.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | RULE_VAR_START | RULE_ID | RULE_INT | RULE_OCT | RULE_HEX | RULE_BIN | RULE_STRING | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=52;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalPerl.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // InternalPerl.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // InternalPerl.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // InternalPerl.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // InternalPerl.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // InternalPerl.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // InternalPerl.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // InternalPerl.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // InternalPerl.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // InternalPerl.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // InternalPerl.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // InternalPerl.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // InternalPerl.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // InternalPerl.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // InternalPerl.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // InternalPerl.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // InternalPerl.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // InternalPerl.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // InternalPerl.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // InternalPerl.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // InternalPerl.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // InternalPerl.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // InternalPerl.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // InternalPerl.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // InternalPerl.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // InternalPerl.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // InternalPerl.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // InternalPerl.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // InternalPerl.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // InternalPerl.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // InternalPerl.g:1:190: T__44
                {
                mT__44(); 

                }
                break;
            case 32 :
                // InternalPerl.g:1:196: T__45
                {
                mT__45(); 

                }
                break;
            case 33 :
                // InternalPerl.g:1:202: T__46
                {
                mT__46(); 

                }
                break;
            case 34 :
                // InternalPerl.g:1:208: T__47
                {
                mT__47(); 

                }
                break;
            case 35 :
                // InternalPerl.g:1:214: T__48
                {
                mT__48(); 

                }
                break;
            case 36 :
                // InternalPerl.g:1:220: T__49
                {
                mT__49(); 

                }
                break;
            case 37 :
                // InternalPerl.g:1:226: T__50
                {
                mT__50(); 

                }
                break;
            case 38 :
                // InternalPerl.g:1:232: T__51
                {
                mT__51(); 

                }
                break;
            case 39 :
                // InternalPerl.g:1:238: T__52
                {
                mT__52(); 

                }
                break;
            case 40 :
                // InternalPerl.g:1:244: T__53
                {
                mT__53(); 

                }
                break;
            case 41 :
                // InternalPerl.g:1:250: T__54
                {
                mT__54(); 

                }
                break;
            case 42 :
                // InternalPerl.g:1:256: T__55
                {
                mT__55(); 

                }
                break;
            case 43 :
                // InternalPerl.g:1:262: RULE_VAR_START
                {
                mRULE_VAR_START(); 

                }
                break;
            case 44 :
                // InternalPerl.g:1:277: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 45 :
                // InternalPerl.g:1:285: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 46 :
                // InternalPerl.g:1:294: RULE_OCT
                {
                mRULE_OCT(); 

                }
                break;
            case 47 :
                // InternalPerl.g:1:303: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 48 :
                // InternalPerl.g:1:312: RULE_BIN
                {
                mRULE_BIN(); 

                }
                break;
            case 49 :
                // InternalPerl.g:1:321: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 50 :
                // InternalPerl.g:1:333: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 51 :
                // InternalPerl.g:1:349: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 52 :
                // InternalPerl.g:1:357: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\1\47\2\44\1\54\1\57\1\62\1\64\1\66\1\71\2\74\1\77\1\101\1\44\3\74\1\uffff\1\74\4\uffff\3\74\1\44\3\uffff\3\44\17\uffff\1\130\10\uffff\1\131\1\74\1\uffff\1\133\5\uffff\1\134\2\74\1\uffff\1\74\4\uffff\1\140\2\74\13\uffff\1\74\2\uffff\1\144\1\74\1\146\1\uffff\2\74\1\151\1\uffff\1\74\1\uffff\2\74\1\uffff\1\155\1\156\1\74\2\uffff\1\160\1\uffff";
    static final String DFA15_eofS =
        "\161\uffff";
    static final String DFA15_minS =
        "\1\0\1\75\1\174\1\46\1\53\1\55\1\52\1\75\1\43\1\75\1\154\1\145\1\75\1\76\1\72\1\171\1\165\1\157\1\uffff\1\165\4\uffff\1\146\1\156\1\145\1\72\3\uffff\1\60\2\0\17\uffff\1\75\10\uffff\1\60\1\163\1\uffff\1\60\5\uffff\1\60\1\162\1\143\1\uffff\1\142\4\uffff\1\60\1\144\1\164\13\uffff\1\145\2\uffff\1\60\1\141\1\60\1\uffff\1\145\1\165\1\60\1\uffff\1\154\1\uffff\1\146\1\162\1\uffff\2\60\1\156\2\uffff\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\uffff\1\76\1\174\1\46\4\75\1\100\1\75\1\161\1\145\1\75\1\76\1\72\1\171\1\165\1\157\1\uffff\1\165\4\uffff\1\146\1\156\1\145\1\72\3\uffff\1\170\2\uffff\17\uffff\1\75\10\uffff\1\172\1\163\1\uffff\1\172\5\uffff\1\172\1\162\1\143\1\uffff\1\142\4\uffff\1\172\1\144\1\164\13\uffff\1\145\2\uffff\1\172\1\141\1\172\1\uffff\1\145\1\165\1\172\1\uffff\1\154\1\uffff\1\146\1\162\1\uffff\2\172\1\156\2\uffff\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\22\uffff\1\40\1\uffff\1\42\1\43\1\44\1\45\4\uffff\1\53\1\54\1\55\3\uffff\1\62\1\63\1\64\1\12\1\23\1\1\1\2\1\3\1\4\1\33\1\24\1\5\1\34\1\25\1\6\1\uffff\1\26\1\7\1\30\1\10\1\31\1\53\1\13\1\32\2\uffff\1\54\1\uffff\1\16\1\17\1\21\1\20\1\22\3\uffff\1\40\1\uffff\1\42\1\43\1\44\1\45\3\uffff\1\52\1\55\1\57\1\60\1\56\1\61\1\62\1\63\1\11\1\27\1\14\1\uffff\1\15\1\35\3\uffff\1\46\3\uffff\1\36\1\uffff\1\41\2\uffff\1\47\3\uffff\1\37\1\50\1\uffff\1\51";
    static final String DFA15_specialS =
        "\1\1\37\uffff\1\2\1\0\117\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\44\2\43\2\44\1\43\22\44\1\43\1\11\1\40\1\42\1\34\1\10\1\3\1\41\1\26\1\27\1\6\1\4\1\44\1\5\1\44\1\7\1\37\11\36\1\33\1\25\1\15\1\1\1\14\1\16\1\34\32\35\4\44\1\35\1\44\4\35\1\12\3\35\1\30\2\35\1\21\1\17\1\13\1\20\2\35\1\32\1\23\1\35\1\31\5\35\1\24\1\2\1\22\uff82\44",
            "\1\45\1\46",
            "\1\50",
            "\1\51",
            "\1\53\21\uffff\1\52",
            "\1\56\17\uffff\1\55",
            "\1\61\22\uffff\1\60",
            "\1\63",
            "\3\67\4\uffff\1\67\22\uffff\1\65\2\uffff\1\67",
            "\1\70",
            "\1\73\4\uffff\1\72",
            "\1\75",
            "\1\76",
            "\1\100",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "",
            "\1\107",
            "",
            "",
            "",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "",
            "",
            "",
            "\10\123\40\uffff\1\121\6\uffff\1\123\2\uffff\1\122\25\uffff\1\121",
            "\0\124",
            "\0\124",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\127",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74",
            "\1\132",
            "",
            "\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74",
            "",
            "",
            "",
            "",
            "",
            "\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74",
            "\1\135",
            "\1\136",
            "",
            "\1\137",
            "",
            "",
            "",
            "",
            "\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74",
            "\1\141",
            "\1\142",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\143",
            "",
            "",
            "\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74",
            "\1\145",
            "\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74",
            "",
            "\1\147",
            "\1\150",
            "\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74",
            "",
            "\1\152",
            "",
            "\1\153",
            "\1\154",
            "",
            "\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74",
            "\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74",
            "\1\157",
            "",
            "",
            "\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | RULE_VAR_START | RULE_ID | RULE_INT | RULE_OCT | RULE_HEX | RULE_BIN | RULE_STRING | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_33 = input.LA(1);

                        s = -1;
                        if ( ((LA15_33>='\u0000' && LA15_33<='\uFFFF')) ) {s = 84;}

                        else s = 36;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='=') ) {s = 1;}

                        else if ( (LA15_0=='|') ) {s = 2;}

                        else if ( (LA15_0=='&') ) {s = 3;}

                        else if ( (LA15_0=='+') ) {s = 4;}

                        else if ( (LA15_0=='-') ) {s = 5;}

                        else if ( (LA15_0=='*') ) {s = 6;}

                        else if ( (LA15_0=='/') ) {s = 7;}

                        else if ( (LA15_0=='%') ) {s = 8;}

                        else if ( (LA15_0=='!') ) {s = 9;}

                        else if ( (LA15_0=='e') ) {s = 10;}

                        else if ( (LA15_0=='n') ) {s = 11;}

                        else if ( (LA15_0=='>') ) {s = 12;}

                        else if ( (LA15_0=='<') ) {s = 13;}

                        else if ( (LA15_0=='?') ) {s = 14;}

                        else if ( (LA15_0=='m') ) {s = 15;}

                        else if ( (LA15_0=='o') ) {s = 16;}

                        else if ( (LA15_0=='l') ) {s = 17;}

                        else if ( (LA15_0=='}') ) {s = 18;}

                        else if ( (LA15_0=='s') ) {s = 19;}

                        else if ( (LA15_0=='{') ) {s = 20;}

                        else if ( (LA15_0==';') ) {s = 21;}

                        else if ( (LA15_0=='(') ) {s = 22;}

                        else if ( (LA15_0==')') ) {s = 23;}

                        else if ( (LA15_0=='i') ) {s = 24;}

                        else if ( (LA15_0=='u') ) {s = 25;}

                        else if ( (LA15_0=='r') ) {s = 26;}

                        else if ( (LA15_0==':') ) {s = 27;}

                        else if ( (LA15_0=='$'||LA15_0=='@') ) {s = 28;}

                        else if ( ((LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='d')||(LA15_0>='f' && LA15_0<='h')||(LA15_0>='j' && LA15_0<='k')||(LA15_0>='p' && LA15_0<='q')||LA15_0=='t'||(LA15_0>='v' && LA15_0<='z')) ) {s = 29;}

                        else if ( ((LA15_0>='1' && LA15_0<='9')) ) {s = 30;}

                        else if ( (LA15_0=='0') ) {s = 31;}

                        else if ( (LA15_0=='\"') ) {s = 32;}

                        else if ( (LA15_0=='\'') ) {s = 33;}

                        else if ( (LA15_0=='#') ) {s = 34;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 35;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0==','||LA15_0=='.'||(LA15_0>='[' && LA15_0<='^')||LA15_0=='`'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {s = 36;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_32 = input.LA(1);

                        s = -1;
                        if ( ((LA15_32>='\u0000' && LA15_32<='\uFFFF')) ) {s = 84;}

                        else s = 36;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}