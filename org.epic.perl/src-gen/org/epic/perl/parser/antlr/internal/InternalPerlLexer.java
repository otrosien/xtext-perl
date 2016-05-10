package org.epic.perl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPerlLexer extends Lexer {
    public static final int RULE_HEX=6;
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int RULE_BIN=7;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
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
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
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

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:12:7: ( '+=' )
            // InternalPerl.g:12:9: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:13:7: ( '-=' )
            // InternalPerl.g:13:9: '-='
            {
            match("-="); 


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
            // InternalPerl.g:14:7: ( '*=' )
            // InternalPerl.g:14:9: '*='
            {
            match("*="); 


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
            // InternalPerl.g:15:7: ( '/=' )
            // InternalPerl.g:15:9: '/='
            {
            match("/="); 


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
            // InternalPerl.g:16:7: ( '%=' )
            // InternalPerl.g:16:9: '%='
            {
            match("%="); 


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
            // InternalPerl.g:17:7: ( '**=' )
            // InternalPerl.g:17:9: '**='
            {
            match("**="); 


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
            // InternalPerl.g:18:7: ( '<' )
            // InternalPerl.g:18:9: '<'
            {
            match('<'); 

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
            // InternalPerl.g:19:7: ( '>' )
            // InternalPerl.g:19:9: '>'
            {
            match('>'); 

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
            // InternalPerl.g:20:7: ( '>=' )
            // InternalPerl.g:20:9: '>='
            {
            match(">="); 


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
            // InternalPerl.g:21:7: ( '||' )
            // InternalPerl.g:21:9: '||'
            {
            match("||"); 


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
            // InternalPerl.g:22:7: ( '&&' )
            // InternalPerl.g:22:9: '&&'
            {
            match("&&"); 


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
            // InternalPerl.g:23:7: ( '==' )
            // InternalPerl.g:23:9: '=='
            {
            match("=="); 


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
            // InternalPerl.g:24:7: ( '!=' )
            // InternalPerl.g:24:9: '!='
            {
            match("!="); 


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
            // InternalPerl.g:25:7: ( 'eq' )
            // InternalPerl.g:25:9: 'eq'
            {
            match("eq"); 


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
            // InternalPerl.g:26:7: ( 'ne' )
            // InternalPerl.g:26:9: 'ne'
            {
            match("ne"); 


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
            // InternalPerl.g:27:7: ( '->' )
            // InternalPerl.g:27:9: '->'
            {
            match("->"); 


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
            // InternalPerl.g:28:7: ( '..<' )
            // InternalPerl.g:28:9: '..<'
            {
            match("..<"); 


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
            // InternalPerl.g:29:7: ( '..' )
            // InternalPerl.g:29:9: '..'
            {
            match(".."); 


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
            // InternalPerl.g:30:7: ( '=>' )
            // InternalPerl.g:30:9: '=>'
            {
            match("=>"); 


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
            // InternalPerl.g:31:7: ( '<>' )
            // InternalPerl.g:31:9: '<>'
            {
            match("<>"); 


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
            // InternalPerl.g:32:7: ( '?:' )
            // InternalPerl.g:32:9: '?:'
            {
            match("?:"); 


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
            // InternalPerl.g:33:7: ( '+' )
            // InternalPerl.g:33:9: '+'
            {
            match('+'); 

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
            // InternalPerl.g:34:7: ( '-' )
            // InternalPerl.g:34:9: '-'
            {
            match('-'); 

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
            // InternalPerl.g:35:7: ( '*' )
            // InternalPerl.g:35:9: '*'
            {
            match('*'); 

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
            // InternalPerl.g:36:7: ( '**' )
            // InternalPerl.g:36:9: '**'
            {
            match("**"); 


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
            // InternalPerl.g:37:7: ( '/' )
            // InternalPerl.g:37:9: '/'
            {
            match('/'); 

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
            // InternalPerl.g:38:7: ( '%' )
            // InternalPerl.g:38:9: '%'
            {
            match('%'); 

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
            // InternalPerl.g:39:7: ( '!' )
            // InternalPerl.g:39:9: '!'
            {
            match('!'); 

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
            // InternalPerl.g:40:7: ( '++' )
            // InternalPerl.g:40:9: '++'
            {
            match("++"); 


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
            // InternalPerl.g:41:7: ( '--' )
            // InternalPerl.g:41:9: '--'
            {
            match("--"); 


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
            // InternalPerl.g:42:7: ( 'sub' )
            // InternalPerl.g:42:9: 'sub'
            {
            match("sub"); 


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
            // InternalPerl.g:43:7: ( '{' )
            // InternalPerl.g:43:9: '{'
            {
            match('{'); 

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
            // InternalPerl.g:44:7: ( '}' )
            // InternalPerl.g:44:9: '}'
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
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
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
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
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
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
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
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
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
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:50:7: ( 'my' )
            // InternalPerl.g:50:9: 'my'
            {
            match("my"); 


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
            // InternalPerl.g:51:7: ( 'our' )
            // InternalPerl.g:51:9: 'our'
            {
            match("our"); 


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
            // InternalPerl.g:52:7: ( 'local' )
            // InternalPerl.g:52:9: 'local'
            {
            match("local"); 


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
            // InternalPerl.g:53:7: ( '$' )
            // InternalPerl.g:53:9: '$'
            {
            match('$'); 

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
            // InternalPerl.g:54:7: ( '@' )
            // InternalPerl.g:54:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:55:7: ( 'undef' )
            // InternalPerl.g:55:9: 'undef'
            {
            match("undef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:56:7: ( 'return' )
            // InternalPerl.g:56:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:57:7: ( '::' )
            // InternalPerl.g:57:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:2439:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalPerl.g:2439:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalPerl.g:2439:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalPerl.g:2439:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalPerl.g:2439:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // InternalPerl.g:2441:10: ( ( '0' .. '9' )+ )
            // InternalPerl.g:2441:12: ( '0' .. '9' )+
            {
            // InternalPerl.g:2441:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPerl.g:2441:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:2443:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ )
            // InternalPerl.g:2443:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            {
            // InternalPerl.g:2443:12: ( '0x' | '0X' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='0') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='x') ) {
                    alt4=1;
                }
                else if ( (LA4_1=='X') ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalPerl.g:2443:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2443:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // InternalPerl.g:2443:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='F')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='f')) ) {
                    alt5=1;
                }


                switch (alt5) {
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // InternalPerl.g:2445:10: ( '0b' ( '0' .. '1' | '_' )+ )
            // InternalPerl.g:2445:12: '0b' ( '0' .. '1' | '_' )+
            {
            match("0b"); 

            // InternalPerl.g:2445:17: ( '0' .. '1' | '_' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='1')||LA6_0=='_') ) {
                    alt6=1;
                }


                switch (alt6) {
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
    // $ANTLR end "RULE_BIN"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:2447:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalPerl.g:2447:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalPerl.g:2447:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\'') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalPerl.g:2447:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalPerl.g:2447:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalPerl.g:2447:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalPerl.g:2447:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop7;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:2447:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalPerl.g:2447:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalPerl.g:2447:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalPerl.g:2447:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop8;
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
            // InternalPerl.g:2449:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalPerl.g:2449:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalPerl.g:2449:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalPerl.g:2449:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop10;
                }
            } while (true);

            // InternalPerl.g:2449:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalPerl.g:2449:41: ( '\\r' )? '\\n'
                    {
                    // InternalPerl.g:2449:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalPerl.g:2449:41: '\\r'
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
            // InternalPerl.g:2451:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalPerl.g:2451:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalPerl.g:2451:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
            // InternalPerl.g:2453:16: ( . )
            // InternalPerl.g:2453:18: .
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
        // InternalPerl.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | RULE_ID | RULE_INT | RULE_HEX | RULE_BIN | RULE_STRING | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=55;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // InternalPerl.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // InternalPerl.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // InternalPerl.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // InternalPerl.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // InternalPerl.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // InternalPerl.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // InternalPerl.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // InternalPerl.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // InternalPerl.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // InternalPerl.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // InternalPerl.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // InternalPerl.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // InternalPerl.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // InternalPerl.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // InternalPerl.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // InternalPerl.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // InternalPerl.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // InternalPerl.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // InternalPerl.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // InternalPerl.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // InternalPerl.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // InternalPerl.g:1:136: T__33
                {
                mT__33(); 

                }
                break;
            case 23 :
                // InternalPerl.g:1:142: T__34
                {
                mT__34(); 

                }
                break;
            case 24 :
                // InternalPerl.g:1:148: T__35
                {
                mT__35(); 

                }
                break;
            case 25 :
                // InternalPerl.g:1:154: T__36
                {
                mT__36(); 

                }
                break;
            case 26 :
                // InternalPerl.g:1:160: T__37
                {
                mT__37(); 

                }
                break;
            case 27 :
                // InternalPerl.g:1:166: T__38
                {
                mT__38(); 

                }
                break;
            case 28 :
                // InternalPerl.g:1:172: T__39
                {
                mT__39(); 

                }
                break;
            case 29 :
                // InternalPerl.g:1:178: T__40
                {
                mT__40(); 

                }
                break;
            case 30 :
                // InternalPerl.g:1:184: T__41
                {
                mT__41(); 

                }
                break;
            case 31 :
                // InternalPerl.g:1:190: T__42
                {
                mT__42(); 

                }
                break;
            case 32 :
                // InternalPerl.g:1:196: T__43
                {
                mT__43(); 

                }
                break;
            case 33 :
                // InternalPerl.g:1:202: T__44
                {
                mT__44(); 

                }
                break;
            case 34 :
                // InternalPerl.g:1:208: T__45
                {
                mT__45(); 

                }
                break;
            case 35 :
                // InternalPerl.g:1:214: T__46
                {
                mT__46(); 

                }
                break;
            case 36 :
                // InternalPerl.g:1:220: T__47
                {
                mT__47(); 

                }
                break;
            case 37 :
                // InternalPerl.g:1:226: T__48
                {
                mT__48(); 

                }
                break;
            case 38 :
                // InternalPerl.g:1:232: T__49
                {
                mT__49(); 

                }
                break;
            case 39 :
                // InternalPerl.g:1:238: T__50
                {
                mT__50(); 

                }
                break;
            case 40 :
                // InternalPerl.g:1:244: T__51
                {
                mT__51(); 

                }
                break;
            case 41 :
                // InternalPerl.g:1:250: T__52
                {
                mT__52(); 

                }
                break;
            case 42 :
                // InternalPerl.g:1:256: T__53
                {
                mT__53(); 

                }
                break;
            case 43 :
                // InternalPerl.g:1:262: T__54
                {
                mT__54(); 

                }
                break;
            case 44 :
                // InternalPerl.g:1:268: T__55
                {
                mT__55(); 

                }
                break;
            case 45 :
                // InternalPerl.g:1:274: T__56
                {
                mT__56(); 

                }
                break;
            case 46 :
                // InternalPerl.g:1:280: T__57
                {
                mT__57(); 

                }
                break;
            case 47 :
                // InternalPerl.g:1:286: T__58
                {
                mT__58(); 

                }
                break;
            case 48 :
                // InternalPerl.g:1:292: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 49 :
                // InternalPerl.g:1:300: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 50 :
                // InternalPerl.g:1:309: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 51 :
                // InternalPerl.g:1:318: RULE_BIN
                {
                mRULE_BIN(); 

                }
                break;
            case 52 :
                // InternalPerl.g:1:327: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 53 :
                // InternalPerl.g:1:339: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 54 :
                // InternalPerl.g:1:355: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 55 :
                // InternalPerl.g:1:363: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\51\1\54\1\60\1\63\1\66\1\70\1\72\1\74\2\46\1\100\2\103\2\46\1\103\5\uffff\4\103\2\uffff\2\103\2\46\1\uffff\1\130\1\uffff\2\46\15\uffff\1\134\16\uffff\1\135\1\103\1\uffff\1\137\1\141\1\uffff\1\103\5\uffff\1\143\1\144\2\103\2\uffff\2\103\11\uffff\1\103\3\uffff\1\152\2\uffff\1\153\3\103\1\157\2\uffff\3\103\1\uffff\1\163\1\164\1\103\2\uffff\1\166\1\uffff";
    static final String DFA14_eofS =
        "\167\uffff";
    static final String DFA14_minS =
        "\1\0\1\75\1\53\1\55\1\52\1\57\1\75\1\76\1\75\1\174\1\46\1\75\1\154\1\145\1\56\1\72\1\165\5\uffff\1\146\1\171\1\165\1\157\2\uffff\1\156\1\145\1\72\1\101\1\uffff\1\130\1\uffff\2\0\15\uffff\1\75\16\uffff\1\60\1\163\1\uffff\1\60\1\74\1\uffff\1\142\5\uffff\2\60\1\162\1\143\2\uffff\1\144\1\164\11\uffff\1\145\3\uffff\1\60\2\uffff\1\60\1\141\1\145\1\165\1\60\2\uffff\1\154\1\146\1\162\1\uffff\2\60\1\156\2\uffff\1\60\1\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\76\1\75\1\76\3\75\1\76\1\75\1\174\1\46\1\75\1\161\1\145\1\56\1\72\1\165\5\uffff\1\146\1\171\1\165\1\157\2\uffff\1\156\1\145\1\72\1\172\1\uffff\1\170\1\uffff\2\uffff\15\uffff\1\75\16\uffff\1\172\1\163\1\uffff\1\172\1\74\1\uffff\1\142\5\uffff\2\172\1\162\1\143\2\uffff\1\144\1\164\11\uffff\1\145\3\uffff\1\172\2\uffff\1\172\1\141\1\145\1\165\1\172\2\uffff\1\154\1\146\1\162\1\uffff\2\172\1\156\2\uffff\1\172\1\uffff";
    static final String DFA14_acceptS =
        "\21\uffff\1\41\1\42\1\43\1\44\1\45\4\uffff\1\53\1\54\4\uffff\1\60\1\uffff\1\61\2\uffff\1\66\1\67\1\15\1\24\1\1\1\2\1\36\1\27\1\3\1\21\1\37\1\30\1\4\1\uffff\1\31\1\5\1\65\1\33\1\6\1\34\1\25\1\10\1\12\1\11\1\13\1\14\1\16\1\35\2\uffff\1\60\2\uffff\1\26\1\uffff\1\41\1\42\1\43\1\44\1\45\4\uffff\1\53\1\54\2\uffff\1\57\1\62\1\63\1\61\1\64\1\66\1\7\1\32\1\17\1\uffff\1\20\1\22\1\23\1\uffff\1\46\1\50\5\uffff\1\40\1\51\3\uffff\1\47\3\uffff\1\52\1\55\1\uffff\1\56";
    static final String DFA14_specialS =
        "\1\1\42\uffff\1\2\1\0\122\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\46\2\45\2\46\1\45\22\46\1\45\1\13\1\43\1\46\1\32\1\6\1\12\1\44\1\24\1\25\1\4\1\2\1\46\1\3\1\16\1\5\1\41\11\42\1\36\1\23\1\7\1\1\1\10\1\17\1\33\32\40\3\46\1\37\1\40\1\46\4\40\1\14\3\40\1\26\2\40\1\31\1\27\1\15\1\30\2\40\1\35\1\20\1\40\1\34\5\40\1\21\1\11\1\22\uff82\46",
            "\1\47\1\50",
            "\1\53\21\uffff\1\52",
            "\1\57\17\uffff\1\55\1\56",
            "\1\62\22\uffff\1\61",
            "\1\65\15\uffff\1\64",
            "\1\67",
            "\1\71",
            "\1\73",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\102\4\uffff\1\101",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "",
            "",
            "",
            "",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "",
            "",
            "\1\123",
            "\1\124",
            "\1\125",
            "\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            "\1\126\11\uffff\1\127\25\uffff\1\126",
            "",
            "\0\131",
            "\0\131",
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
            "\1\133",
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
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\136",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\140",
            "",
            "\1\142",
            "",
            "",
            "",
            "",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\145",
            "\1\146",
            "",
            "",
            "\1\147",
            "\1\150",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\151",
            "",
            "",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\154",
            "\1\155",
            "\1\156",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            "",
            "\1\160",
            "\1\161",
            "\1\162",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\165",
            "",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | RULE_ID | RULE_INT | RULE_HEX | RULE_BIN | RULE_STRING | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_36 = input.LA(1);

                        s = -1;
                        if ( ((LA14_36>='\u0000' && LA14_36<='\uFFFF')) ) {s = 89;}

                        else s = 38;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='=') ) {s = 1;}

                        else if ( (LA14_0=='+') ) {s = 2;}

                        else if ( (LA14_0=='-') ) {s = 3;}

                        else if ( (LA14_0=='*') ) {s = 4;}

                        else if ( (LA14_0=='/') ) {s = 5;}

                        else if ( (LA14_0=='%') ) {s = 6;}

                        else if ( (LA14_0=='<') ) {s = 7;}

                        else if ( (LA14_0=='>') ) {s = 8;}

                        else if ( (LA14_0=='|') ) {s = 9;}

                        else if ( (LA14_0=='&') ) {s = 10;}

                        else if ( (LA14_0=='!') ) {s = 11;}

                        else if ( (LA14_0=='e') ) {s = 12;}

                        else if ( (LA14_0=='n') ) {s = 13;}

                        else if ( (LA14_0=='.') ) {s = 14;}

                        else if ( (LA14_0=='?') ) {s = 15;}

                        else if ( (LA14_0=='s') ) {s = 16;}

                        else if ( (LA14_0=='{') ) {s = 17;}

                        else if ( (LA14_0=='}') ) {s = 18;}

                        else if ( (LA14_0==';') ) {s = 19;}

                        else if ( (LA14_0=='(') ) {s = 20;}

                        else if ( (LA14_0==')') ) {s = 21;}

                        else if ( (LA14_0=='i') ) {s = 22;}

                        else if ( (LA14_0=='m') ) {s = 23;}

                        else if ( (LA14_0=='o') ) {s = 24;}

                        else if ( (LA14_0=='l') ) {s = 25;}

                        else if ( (LA14_0=='$') ) {s = 26;}

                        else if ( (LA14_0=='@') ) {s = 27;}

                        else if ( (LA14_0=='u') ) {s = 28;}

                        else if ( (LA14_0=='r') ) {s = 29;}

                        else if ( (LA14_0==':') ) {s = 30;}

                        else if ( (LA14_0=='^') ) {s = 31;}

                        else if ( ((LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='d')||(LA14_0>='f' && LA14_0<='h')||(LA14_0>='j' && LA14_0<='k')||(LA14_0>='p' && LA14_0<='q')||LA14_0=='t'||(LA14_0>='v' && LA14_0<='z')) ) {s = 32;}

                        else if ( (LA14_0=='0') ) {s = 33;}

                        else if ( ((LA14_0>='1' && LA14_0<='9')) ) {s = 34;}

                        else if ( (LA14_0=='\"') ) {s = 35;}

                        else if ( (LA14_0=='\'') ) {s = 36;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 37;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='#'||LA14_0==','||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||(LA14_0>='~' && LA14_0<='\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_35 = input.LA(1);

                        s = -1;
                        if ( ((LA14_35>='\u0000' && LA14_35<='\uFFFF')) ) {s = 89;}

                        else s = 38;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}