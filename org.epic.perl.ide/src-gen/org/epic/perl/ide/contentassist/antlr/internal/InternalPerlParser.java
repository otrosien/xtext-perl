package org.epic.perl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.epic.perl.services.PerlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalPerlParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INTERPOLATE", "RULE_LITERAL", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_ID", "RULE_VERSION", "RULE_POD", "RULE_SYMBOL", "RULE_DATA", "RULE_END", "RULE_BACKTICK_STRING", "RULE_WORDS_QUOTE_LIKE", "RULE_COMMAND_QUOTE_LIKE", "RULE_REGEX_QUOTE", "RULE_READLINE_QUOTE", "RULE_ANY_OTHER", "RULE_SL_COMMENT", "RULE_WS", "';'", "'abs'", "'accept'", "'alarm'", "'atan2'", "'bind'", "'binmode'", "'bless'", "'break'", "'caller'", "'chdir'", "'chmod'", "'chomp'", "'chop'", "'chown'", "'chr'", "'chroot'", "'close'", "'closedir'", "'connect'", "'continue'", "'cos'", "'crypt'", "'dbmclose'", "'dbmopen'", "'default'", "'defined'", "'delete'", "'die'", "'do'", "'dump'", "'each'", "'else'", "'elsif'", "'endgrent'", "'endhostent'", "'endnetent'", "'endprotoent'", "'endpwent'", "'endservent'", "'eof'", "'eval'", "'evalbytes'", "'exec'", "'exists'", "'exit'", "'exp'", "'fc'", "'fcntl'", "'fileno'", "'flock'", "'for'", "'foreach'", "'fork'", "'format'", "'formline'", "'getc'", "'getgrent'", "'getgrgid'", "'getgrnam'", "'gethostbyaddr'", "'gethostbyname'", "'gethostent'", "'getlogin'", "'getnetbyaddr'", "'getnetbyname'", "'getnetent'", "'getpeername'", "'getpgrp'", "'getppid'", "'getpriority'", "'getprotobyname'", "'getprotobynumber'", "'getprotoent'", "'getpwent'", "'getpwnam'", "'getpwuid'", "'getservbyname'", "'getservbyport'", "'getservent'", "'getsockname'", "'getsockopt'", "'given'", "'glob'", "'gmtime'", "'goto'", "'grep'", "'hex'", "'if'", "'index'", "'int'", "'ioctl'", "'join'", "'keys'", "'kill'", "'last'", "'lc'", "'lcfirst'", "'length'", "'link'", "'listen'", "'local'", "'localtime'", "'lock'", "'log'", "'lstat'", "'map'", "'mkdir'", "'msgctl'", "'msgget'", "'msgrcv'", "'msgsnd'", "'my'", "'next'", "'no'", "'oct'", "'open'", "'opendir'", "'ord'", "'our'", "'pack'", "'package'", "'pipe'", "'pop'", "'pos'", "'print'", "'printf'", "'prototype'", "'push'", "'quotemeta'", "'rand'", "'read'", "'readdir'", "'readline'", "'readlink'", "'readpipe'", "'recv'", "'redo'", "'ref'", "'rename'", "'require'", "'reset'", "'return'", "'reverse'", "'rewinddir'", "'rindex'", "'rmdir'", "'say'", "'scalar'", "'seek'", "'seekdir'", "'select'", "'semctl'", "'semget'", "'semop'", "'send'", "'setgrent'", "'sethostent'", "'setnetent'", "'setpgrp'", "'setpriority'", "'setprotoent'", "'setpwent'", "'setservent'", "'setsockopt'", "'shift'", "'shmctl'", "'shmget'", "'shmread'", "'shmwrite'", "'shutdown'", "'sin'", "'sleep'", "'socket'", "'socketpair'", "'sort'", "'splice'", "'split'", "'sprintf'", "'sqrt'", "'srand'", "'stat'", "'state'", "'study'", "'sub'", "'substr'", "'symlink'", "'syscall'", "'sysopen'", "'sysread'", "'sysseek'", "'system'", "'syswrite'", "'tell'", "'telldir'", "'tie'", "'tied'", "'time'", "'times'", "'tr'", "'truncate'", "'uc'", "'ucfirst'", "'umask'", "'undef'", "'unless'", "'unlink'", "'unpack'", "'unshift'", "'untie'", "'until'", "'use'", "'utime'", "'values'", "'vec'", "'wait'", "'waitpid'", "'wantarray'", "'warn'", "'when'", "'while'", "'write'", "'y'", "'++'", "'--'", "'**'", "'!'", "'~'", "'+'", "'-'", "'=~'", "'!~'", "'*'", "'/'", "'%'", "'x'", "'<<'", "'>>'", "'lt'", "'gt'", "'le'", "'ge'", "'cmp'", "'~~'", "'=='", "'!='", "'..'", "'...'", "','", "'&'", "'|'", "'^'", "'&&'", "'||'", "'//'", "'?'", "':'", "'**='", "'+='", "'-='", "'.='", "'*='", "'/='", "'%='", "'x='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'&&='", "'||='", "'//='", "'<'", "'>'", "'<='", "'>='", "'<>'", "'=>'", "'->'", "'and'", "'or'", "'xor'", "'not'", "'eq'", "'ne'", "'-r'", "'-w'", "'-x'", "'-o'", "'-R'", "'-W'", "'-X'", "'-O'", "'-e'", "'-z'", "'-s'", "'-f'", "'-d'", "'-l'", "'-p'", "'-S'", "'-b'", "'-c'", "'-t'", "'-u'", "'-g'", "'-k'", "'-T'", "'-B'", "'-M'", "'-A'", "'-C'", "'<=>'", "'.'"
    };
    public static final int T__144=144;
    public static final int T__265=265;
    public static final int T__143=143;
    public static final int T__264=264;
    public static final int T__146=146;
    public static final int T__267=267;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__266=266;
    public static final int T__140=140;
    public static final int T__261=261;
    public static final int T__260=260;
    public static final int T__142=142;
    public static final int T__263=263;
    public static final int T__141=141;
    public static final int T__262=262;
    public static final int RULE_READLINE_QUOTE=20;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__258=258;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__257=257;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__259=259;
    public static final int T__133=133;
    public static final int T__254=254;
    public static final int T__132=132;
    public static final int T__253=253;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__256=256;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int T__255=255;
    public static final int T__250=250;
    public static final int RULE_ID=10;
    public static final int T__131=131;
    public static final int T__252=252;
    public static final int T__130=130;
    public static final int T__251=251;
    public static final int RULE_DATA=14;
    public static final int RULE_INT=9;
    public static final int T__66=66;
    public static final int RULE_COMMAND_QUOTE_LIKE=18;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__247=247;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__246=246;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__249=249;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__248=248;
    public static final int T__166=166;
    public static final int T__287=287;
    public static final int T__165=165;
    public static final int T__286=286;
    public static final int T__168=168;
    public static final int T__289=289;
    public static final int T__167=167;
    public static final int T__288=288;
    public static final int T__162=162;
    public static final int T__283=283;
    public static final int T__161=161;
    public static final int T__282=282;
    public static final int T__164=164;
    public static final int T__285=285;
    public static final int T__163=163;
    public static final int T__284=284;
    public static final int T__160=160;
    public static final int T__281=281;
    public static final int T__280=280;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int RULE_POD=12;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__159=159;
    public static final int T__30=30;
    public static final int T__158=158;
    public static final int T__279=279;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__155=155;
    public static final int T__276=276;
    public static final int T__154=154;
    public static final int T__275=275;
    public static final int T__157=157;
    public static final int T__278=278;
    public static final int T__156=156;
    public static final int T__277=277;
    public static final int T__151=151;
    public static final int T__272=272;
    public static final int T__150=150;
    public static final int T__271=271;
    public static final int T__153=153;
    public static final int T__274=274;
    public static final int T__152=152;
    public static final int T__273=273;
    public static final int T__270=270;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__148=148;
    public static final int T__269=269;
    public static final int T__41=41;
    public static final int T__147=147;
    public static final int T__268=268;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__149=149;
    public static final int T__100=100;
    public static final int T__221=221;
    public static final int T__220=220;
    public static final int T__102=102;
    public static final int T__223=223;
    public static final int T__101=101;
    public static final int T__222=222;
    public static final int T__218=218;
    public static final int T__217=217;
    public static final int T__338=338;
    public static final int T__219=219;
    public static final int T__214=214;
    public static final int T__335=335;
    public static final int T__213=213;
    public static final int T__334=334;
    public static final int T__216=216;
    public static final int T__337=337;
    public static final int T__215=215;
    public static final int T__336=336;
    public static final int T__210=210;
    public static final int T__331=331;
    public static final int T__330=330;
    public static final int T__212=212;
    public static final int T__333=333;
    public static final int T__211=211;
    public static final int T__332=332;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__207=207;
    public static final int T__328=328;
    public static final int T__206=206;
    public static final int T__327=327;
    public static final int T__24=24;
    public static final int T__209=209;
    public static final int T__25=25;
    public static final int T__208=208;
    public static final int T__329=329;
    public static final int T__203=203;
    public static final int T__324=324;
    public static final int T__202=202;
    public static final int T__323=323;
    public static final int T__205=205;
    public static final int T__326=326;
    public static final int T__204=204;
    public static final int T__325=325;
    public static final int T__122=122;
    public static final int T__243=243;
    public static final int T__121=121;
    public static final int T__242=242;
    public static final int T__124=124;
    public static final int T__245=245;
    public static final int RULE_END=15;
    public static final int T__123=123;
    public static final int T__244=244;
    public static final int T__120=120;
    public static final int T__241=241;
    public static final int T__240=240;
    public static final int RULE_SL_COMMENT=22;
    public static final int T__119=119;
    public static final int T__118=118;
    public static final int T__239=239;
    public static final int T__115=115;
    public static final int T__236=236;
    public static final int EOF=-1;
    public static final int T__114=114;
    public static final int T__235=235;
    public static final int T__117=117;
    public static final int T__238=238;
    public static final int T__116=116;
    public static final int T__237=237;
    public static final int T__111=111;
    public static final int T__232=232;
    public static final int T__110=110;
    public static final int T__231=231;
    public static final int T__113=113;
    public static final int T__234=234;
    public static final int T__112=112;
    public static final int T__233=233;
    public static final int T__230=230;
    public static final int T__108=108;
    public static final int T__229=229;
    public static final int T__107=107;
    public static final int T__228=228;
    public static final int T__109=109;
    public static final int T__104=104;
    public static final int T__225=225;
    public static final int T__103=103;
    public static final int T__224=224;
    public static final int T__106=106;
    public static final int T__227=227;
    public static final int T__105=105;
    public static final int T__226=226;
    public static final int T__300=300;
    public static final int RULE_HEX=7;
    public static final int RULE_VERSION=11;
    public static final int RULE_LITERAL=6;
    public static final int RULE_BIN=8;
    public static final int RULE_INTERPOLATE=5;
    public static final int T__320=320;
    public static final int T__201=201;
    public static final int T__322=322;
    public static final int T__200=200;
    public static final int T__321=321;
    public static final int T__317=317;
    public static final int T__316=316;
    public static final int T__319=319;
    public static final int T__318=318;
    public static final int T__313=313;
    public static final int T__312=312;
    public static final int T__315=315;
    public static final int T__314=314;
    public static final int T__311=311;
    public static final int T__310=310;
    public static final int T__309=309;
    public static final int T__306=306;
    public static final int T__305=305;
    public static final int T__308=308;
    public static final int T__307=307;
    public static final int T__302=302;
    public static final int T__301=301;
    public static final int T__304=304;
    public static final int T__303=303;
    public static final int T__91=91;
    public static final int T__188=188;
    public static final int T__92=92;
    public static final int T__187=187;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__189=189;
    public static final int T__184=184;
    public static final int T__183=183;
    public static final int T__186=186;
    public static final int T__90=90;
    public static final int T__185=185;
    public static final int T__180=180;
    public static final int T__182=182;
    public static final int T__181=181;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__177=177;
    public static final int T__298=298;
    public static final int T__176=176;
    public static final int T__297=297;
    public static final int T__179=179;
    public static final int T__178=178;
    public static final int T__299=299;
    public static final int T__173=173;
    public static final int T__294=294;
    public static final int T__172=172;
    public static final int T__293=293;
    public static final int T__175=175;
    public static final int T__296=296;
    public static final int T__174=174;
    public static final int T__295=295;
    public static final int T__290=290;
    public static final int T__171=171;
    public static final int T__292=292;
    public static final int T__170=170;
    public static final int T__291=291;
    public static final int RULE_WORDS_QUOTE_LIKE=17;
    public static final int T__169=169;
    public static final int RULE_REGEX_QUOTE=19;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__199=199;
    public static final int T__81=81;
    public static final int T__198=198;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__195=195;
    public static final int T__194=194;
    public static final int RULE_WS=23;
    public static final int T__197=197;
    public static final int RULE_BACKTICK_STRING=16;
    public static final int T__196=196;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=21;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int RULE_SYMBOL=13;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalPerlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPerlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPerlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPerl.g"; }


    	private PerlGrammarAccess grammarAccess;

    	public void setGrammarAccess(PerlGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRulePerlDocument"
    // InternalPerl.g:54:1: entryRulePerlDocument : rulePerlDocument EOF ;
    public final void entryRulePerlDocument() throws RecognitionException {
        try {
            // InternalPerl.g:55:1: ( rulePerlDocument EOF )
            // InternalPerl.g:56:1: rulePerlDocument EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPerlDocumentRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePerlDocument();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPerlDocumentRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePerlDocument"


    // $ANTLR start "rulePerlDocument"
    // InternalPerl.g:63:1: rulePerlDocument : ( ( rule__PerlDocument__Group__0 ) ) ;
    public final void rulePerlDocument() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:67:2: ( ( ( rule__PerlDocument__Group__0 ) ) )
            // InternalPerl.g:68:2: ( ( rule__PerlDocument__Group__0 ) )
            {
            // InternalPerl.g:68:2: ( ( rule__PerlDocument__Group__0 ) )
            // InternalPerl.g:69:3: ( rule__PerlDocument__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPerlDocumentAccess().getGroup()); 
            }
            // InternalPerl.g:70:3: ( rule__PerlDocument__Group__0 )
            // InternalPerl.g:70:4: rule__PerlDocument__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PerlDocument__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPerlDocumentAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePerlDocument"


    // $ANTLR start "entryRuleElement"
    // InternalPerl.g:79:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalPerl.g:80:1: ( ruleElement EOF )
            // InternalPerl.g:81:1: ruleElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalPerl.g:88:1: ruleElement : ( ( rule__Element__Alternatives ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:92:2: ( ( ( rule__Element__Alternatives ) ) )
            // InternalPerl.g:93:2: ( ( rule__Element__Alternatives ) )
            {
            // InternalPerl.g:93:2: ( ( rule__Element__Alternatives ) )
            // InternalPerl.g:94:3: ( rule__Element__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getElementAccess().getAlternatives()); 
            }
            // InternalPerl.g:95:3: ( rule__Element__Alternatives )
            // InternalPerl.g:95:4: rule__Element__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Element__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getElementAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleNode"
    // InternalPerl.g:104:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // InternalPerl.g:105:1: ( ruleNode EOF )
            // InternalPerl.g:106:1: ruleNode EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNode();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNodeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalPerl.g:113:1: ruleNode : ( ( rule__Node__Alternatives ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:117:2: ( ( ( rule__Node__Alternatives ) ) )
            // InternalPerl.g:118:2: ( ( rule__Node__Alternatives ) )
            {
            // InternalPerl.g:118:2: ( ( rule__Node__Alternatives ) )
            // InternalPerl.g:119:3: ( rule__Node__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNodeAccess().getAlternatives()); 
            }
            // InternalPerl.g:120:3: ( rule__Node__Alternatives )
            // InternalPerl.g:120:4: rule__Node__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Node__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNodeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleStatementNode"
    // InternalPerl.g:129:1: entryRuleStatementNode : ruleStatementNode EOF ;
    public final void entryRuleStatementNode() throws RecognitionException {
        try {
            // InternalPerl.g:130:1: ( ruleStatementNode EOF )
            // InternalPerl.g:131:1: ruleStatementNode EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStatementNode();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementNodeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStatementNode"


    // $ANTLR start "ruleStatementNode"
    // InternalPerl.g:138:1: ruleStatementNode : ( rulePackageStatement ) ;
    public final void ruleStatementNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:142:2: ( ( rulePackageStatement ) )
            // InternalPerl.g:143:2: ( rulePackageStatement )
            {
            // InternalPerl.g:143:2: ( rulePackageStatement )
            // InternalPerl.g:144:3: rulePackageStatement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementNodeAccess().getPackageStatementParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            rulePackageStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementNodeAccess().getPackageStatementParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatementNode"


    // $ANTLR start "entryRuleStructureNode"
    // InternalPerl.g:154:1: entryRuleStructureNode : ruleStructureNode EOF ;
    public final void entryRuleStructureNode() throws RecognitionException {
        try {
            // InternalPerl.g:155:1: ( ruleStructureNode EOF )
            // InternalPerl.g:156:1: ruleStructureNode EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructureNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStructureNode();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructureNodeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStructureNode"


    // $ANTLR start "ruleStructureNode"
    // InternalPerl.g:163:1: ruleStructureNode : ( ';' ) ;
    public final void ruleStructureNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:167:2: ( ( ';' ) )
            // InternalPerl.g:168:2: ( ';' )
            {
            // InternalPerl.g:168:2: ( ';' )
            // InternalPerl.g:169:3: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStructureNodeAccess().getSemicolonKeyword()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStructureNodeAccess().getSemicolonKeyword()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStructureNode"


    // $ANTLR start "entryRulePackageStatement"
    // InternalPerl.g:179:1: entryRulePackageStatement : rulePackageStatement EOF ;
    public final void entryRulePackageStatement() throws RecognitionException {
        try {
            // InternalPerl.g:180:1: ( rulePackageStatement EOF )
            // InternalPerl.g:181:1: rulePackageStatement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePackageStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageStatementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageStatement"


    // $ANTLR start "rulePackageStatement"
    // InternalPerl.g:188:1: rulePackageStatement : ( ( rule__PackageStatement__Group__0 ) ) ;
    public final void rulePackageStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:192:2: ( ( ( rule__PackageStatement__Group__0 ) ) )
            // InternalPerl.g:193:2: ( ( rule__PackageStatement__Group__0 ) )
            {
            // InternalPerl.g:193:2: ( ( rule__PackageStatement__Group__0 ) )
            // InternalPerl.g:194:3: ( rule__PackageStatement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageStatementAccess().getGroup()); 
            }
            // InternalPerl.g:195:3: ( rule__PackageStatement__Group__0 )
            // InternalPerl.g:195:4: rule__PackageStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PackageStatement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageStatementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageStatement"


    // $ANTLR start "entryRuleToken"
    // InternalPerl.g:204:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // InternalPerl.g:205:1: ( ruleToken EOF )
            // InternalPerl.g:206:1: ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleToken();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleToken"


    // $ANTLR start "ruleToken"
    // InternalPerl.g:213:1: ruleToken : ( ( rule__Token__Alternatives ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:217:2: ( ( ( rule__Token__Alternatives ) ) )
            // InternalPerl.g:218:2: ( ( rule__Token__Alternatives ) )
            {
            // InternalPerl.g:218:2: ( ( rule__Token__Alternatives ) )
            // InternalPerl.g:219:3: ( rule__Token__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getAlternatives()); 
            }
            // InternalPerl.g:220:3: ( rule__Token__Alternatives )
            // InternalPerl.g:220:4: rule__Token__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Token__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleToken"


    // $ANTLR start "entryRuleQuoteToken"
    // InternalPerl.g:229:1: entryRuleQuoteToken : ruleQuoteToken EOF ;
    public final void entryRuleQuoteToken() throws RecognitionException {
        try {
            // InternalPerl.g:230:1: ( ruleQuoteToken EOF )
            // InternalPerl.g:231:1: ruleQuoteToken EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteTokenRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQuoteToken();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteTokenRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuoteToken"


    // $ANTLR start "ruleQuoteToken"
    // InternalPerl.g:238:1: ruleQuoteToken : ( ( rule__QuoteToken__Group__0 ) ) ;
    public final void ruleQuoteToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:242:2: ( ( ( rule__QuoteToken__Group__0 ) ) )
            // InternalPerl.g:243:2: ( ( rule__QuoteToken__Group__0 ) )
            {
            // InternalPerl.g:243:2: ( ( rule__QuoteToken__Group__0 ) )
            // InternalPerl.g:244:3: ( rule__QuoteToken__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteTokenAccess().getGroup()); 
            }
            // InternalPerl.g:245:3: ( rule__QuoteToken__Group__0 )
            // InternalPerl.g:245:4: rule__QuoteToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QuoteToken__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteTokenAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuoteToken"


    // $ANTLR start "entryRuleQuoteLikeToken"
    // InternalPerl.g:254:1: entryRuleQuoteLikeToken : ruleQuoteLikeToken EOF ;
    public final void entryRuleQuoteLikeToken() throws RecognitionException {
        try {
            // InternalPerl.g:255:1: ( ruleQuoteLikeToken EOF )
            // InternalPerl.g:256:1: ruleQuoteLikeToken EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQuoteLikeToken();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuoteLikeToken"


    // $ANTLR start "ruleQuoteLikeToken"
    // InternalPerl.g:263:1: ruleQuoteLikeToken : ( ( rule__QuoteLikeToken__Alternatives ) ) ;
    public final void ruleQuoteLikeToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:267:2: ( ( ( rule__QuoteLikeToken__Alternatives ) ) )
            // InternalPerl.g:268:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            {
            // InternalPerl.g:268:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            // InternalPerl.g:269:3: ( rule__QuoteLikeToken__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getAlternatives()); 
            }
            // InternalPerl.g:270:3: ( rule__QuoteLikeToken__Alternatives )
            // InternalPerl.g:270:4: rule__QuoteLikeToken__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuoteLikeToken"


    // $ANTLR start "entryRuleWord"
    // InternalPerl.g:279:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalPerl.g:280:1: ( ruleWord EOF )
            // InternalPerl.g:281:1: ruleWord EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWordRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleWord();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWordRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWord"


    // $ANTLR start "ruleWord"
    // InternalPerl.g:288:1: ruleWord : ( ruleKeyword ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:292:2: ( ( ruleKeyword ) )
            // InternalPerl.g:293:2: ( ruleKeyword )
            {
            // InternalPerl.g:293:2: ( ruleKeyword )
            // InternalPerl.g:294:3: ruleKeyword
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWordAccess().getKeywordParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            ruleKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWordAccess().getKeywordParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWord"


    // $ANTLR start "entryRuleKeyword"
    // InternalPerl.g:304:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalPerl.g:305:1: ( ruleKeyword EOF )
            // InternalPerl.g:306:1: ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleKeyword();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // InternalPerl.g:313:1: ruleKeyword : ( ( rule__Keyword__Alternatives ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:317:2: ( ( ( rule__Keyword__Alternatives ) ) )
            // InternalPerl.g:318:2: ( ( rule__Keyword__Alternatives ) )
            {
            // InternalPerl.g:318:2: ( ( rule__Keyword__Alternatives ) )
            // InternalPerl.g:319:3: ( rule__Keyword__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getKeywordAccess().getAlternatives()); 
            }
            // InternalPerl.g:320:3: ( rule__Keyword__Alternatives )
            // InternalPerl.g:320:4: rule__Keyword__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Keyword__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getKeywordAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleOperator"
    // InternalPerl.g:329:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalPerl.g:330:1: ( ruleOperator EOF )
            // InternalPerl.g:331:1: ruleOperator EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperatorRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalPerl.g:338:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:342:2: ( ( ( rule__Operator__Alternatives ) ) )
            // InternalPerl.g:343:2: ( ( rule__Operator__Alternatives ) )
            {
            // InternalPerl.g:343:2: ( ( rule__Operator__Alternatives ) )
            // InternalPerl.g:344:3: ( rule__Operator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperatorAccess().getAlternatives()); 
            }
            // InternalPerl.g:345:3: ( rule__Operator__Alternatives )
            // InternalPerl.g:345:4: rule__Operator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Operator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperatorAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleFileTestOperator"
    // InternalPerl.g:354:1: entryRuleFileTestOperator : ruleFileTestOperator EOF ;
    public final void entryRuleFileTestOperator() throws RecognitionException {
        try {
            // InternalPerl.g:355:1: ( ruleFileTestOperator EOF )
            // InternalPerl.g:356:1: ruleFileTestOperator EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFileTestOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFileTestOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFileTestOperatorRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFileTestOperator"


    // $ANTLR start "ruleFileTestOperator"
    // InternalPerl.g:363:1: ruleFileTestOperator : ( ( rule__FileTestOperator__Alternatives ) ) ;
    public final void ruleFileTestOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:367:2: ( ( ( rule__FileTestOperator__Alternatives ) ) )
            // InternalPerl.g:368:2: ( ( rule__FileTestOperator__Alternatives ) )
            {
            // InternalPerl.g:368:2: ( ( rule__FileTestOperator__Alternatives ) )
            // InternalPerl.g:369:3: ( rule__FileTestOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFileTestOperatorAccess().getAlternatives()); 
            }
            // InternalPerl.g:370:3: ( rule__FileTestOperator__Alternatives )
            // InternalPerl.g:370:4: rule__FileTestOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FileTestOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFileTestOperatorAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFileTestOperator"


    // $ANTLR start "entryRuleNumber"
    // InternalPerl.g:379:1: entryRuleNumber : ruleNumber EOF ;
    public final void entryRuleNumber() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:383:1: ( ruleNumber EOF )
            // InternalPerl.g:384:1: ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNumber();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalPerl.g:394:1: ruleNumber : ( ( rule__Number__Group__0 ) ) ;
    public final void ruleNumber() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:399:2: ( ( ( rule__Number__Group__0 ) ) )
            // InternalPerl.g:400:2: ( ( rule__Number__Group__0 ) )
            {
            // InternalPerl.g:400:2: ( ( rule__Number__Group__0 ) )
            // InternalPerl.g:401:3: ( rule__Number__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberAccess().getGroup()); 
            }
            // InternalPerl.g:402:3: ( rule__Number__Group__0 )
            // InternalPerl.g:402:4: rule__Number__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Number__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "rule__Element__Alternatives"
    // InternalPerl.g:411:1: rule__Element__Alternatives : ( ( ruleNode ) | ( ruleToken ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:415:1: ( ( ruleNode ) | ( ruleToken ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==145) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==RULE_ID) ) {
                    alt1=1;
                }
                else if ( (LA1_1==EOF||(LA1_1>=RULE_STRING && LA1_1<=RULE_INT)||(LA1_1>=RULE_VERSION && LA1_1<=RULE_READLINE_QUOTE)||(LA1_1>=24 && LA1_1<=337)) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==24) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_INT)||(LA1_0>=RULE_VERSION && LA1_0<=RULE_READLINE_QUOTE)||(LA1_0>=25 && LA1_0<=144)||(LA1_0>=146 && LA1_0<=337)) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalPerl.g:416:2: ( ruleNode )
                    {
                    // InternalPerl.g:416:2: ( ruleNode )
                    // InternalPerl.g:417:3: ruleNode
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getElementAccess().getNodeParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleNode();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getElementAccess().getNodeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:422:2: ( ruleToken )
                    {
                    // InternalPerl.g:422:2: ( ruleToken )
                    // InternalPerl.g:423:3: ruleToken
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getElementAccess().getTokenParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleToken();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getElementAccess().getTokenParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Alternatives"


    // $ANTLR start "rule__Node__Alternatives"
    // InternalPerl.g:432:1: rule__Node__Alternatives : ( ( ruleStatementNode ) | ( ruleStructureNode ) );
    public final void rule__Node__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:436:1: ( ( ruleStatementNode ) | ( ruleStructureNode ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==145) ) {
                alt2=1;
            }
            else if ( (LA2_0==24) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalPerl.g:437:2: ( ruleStatementNode )
                    {
                    // InternalPerl.g:437:2: ( ruleStatementNode )
                    // InternalPerl.g:438:3: ruleStatementNode
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNodeAccess().getStatementNodeParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleStatementNode();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNodeAccess().getStatementNodeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:443:2: ( ruleStructureNode )
                    {
                    // InternalPerl.g:443:2: ( ruleStructureNode )
                    // InternalPerl.g:444:3: ruleStructureNode
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNodeAccess().getStructureNodeParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleStructureNode();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNodeAccess().getStructureNodeParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Alternatives"


    // $ANTLR start "rule__Token__Alternatives"
    // InternalPerl.g:453:1: rule__Token__Alternatives : ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ( rule__Token__Group_4__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_6__0 ) ) | ( ( rule__Token__Group_7__0 ) ) | ( ruleQuoteToken ) | ( ( rule__Token__Group_9__0 ) ) | ( ( rule__Token__Group_10__0 ) ) );
    public final void rule__Token__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:457:1: ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ( rule__Token__Group_4__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_6__0 ) ) | ( ( rule__Token__Group_7__0 ) ) | ( ruleQuoteToken ) | ( ( rule__Token__Group_9__0 ) ) | ( ( rule__Token__Group_10__0 ) ) )
            int alt3=11;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_POD) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=RULE_HEX && LA3_0<=RULE_INT)) ) {
                alt3=2;
            }
            else if ( (LA3_0==RULE_VERSION) ) {
                alt3=3;
            }
            else if ( ((LA3_0>=25 && LA3_0<=246)) ) {
                alt3=4;
            }
            else if ( (LA3_0==RULE_SYMBOL) ) {
                alt3=5;
            }
            else if ( ((LA3_0>=RULE_BACKTICK_STRING && LA3_0<=RULE_READLINE_QUOTE)) ) {
                alt3=6;
            }
            else if ( ((LA3_0>=310 && LA3_0<=336)) ) {
                alt3=7;
            }
            else if ( ((LA3_0>=247 && LA3_0<=309)||LA3_0==337) ) {
                alt3=8;
            }
            else if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_LITERAL)) ) {
                alt3=9;
            }
            else if ( (LA3_0==RULE_DATA) ) {
                alt3=10;
            }
            else if ( (LA3_0==RULE_END) ) {
                alt3=11;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalPerl.g:458:2: ( ( rule__Token__Group_0__0 ) )
                    {
                    // InternalPerl.g:458:2: ( ( rule__Token__Group_0__0 ) )
                    // InternalPerl.g:459:3: ( rule__Token__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getGroup_0()); 
                    }
                    // InternalPerl.g:460:3: ( rule__Token__Group_0__0 )
                    // InternalPerl.g:460:4: rule__Token__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:464:2: ( ( rule__Token__Group_1__0 ) )
                    {
                    // InternalPerl.g:464:2: ( ( rule__Token__Group_1__0 ) )
                    // InternalPerl.g:465:3: ( rule__Token__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getGroup_1()); 
                    }
                    // InternalPerl.g:466:3: ( rule__Token__Group_1__0 )
                    // InternalPerl.g:466:4: rule__Token__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:470:2: ( ( rule__Token__Group_2__0 ) )
                    {
                    // InternalPerl.g:470:2: ( ( rule__Token__Group_2__0 ) )
                    // InternalPerl.g:471:3: ( rule__Token__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getGroup_2()); 
                    }
                    // InternalPerl.g:472:3: ( rule__Token__Group_2__0 )
                    // InternalPerl.g:472:4: rule__Token__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:476:2: ( ( rule__Token__Group_3__0 ) )
                    {
                    // InternalPerl.g:476:2: ( ( rule__Token__Group_3__0 ) )
                    // InternalPerl.g:477:3: ( rule__Token__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getGroup_3()); 
                    }
                    // InternalPerl.g:478:3: ( rule__Token__Group_3__0 )
                    // InternalPerl.g:478:4: rule__Token__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:482:2: ( ( rule__Token__Group_4__0 ) )
                    {
                    // InternalPerl.g:482:2: ( ( rule__Token__Group_4__0 ) )
                    // InternalPerl.g:483:3: ( rule__Token__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getGroup_4()); 
                    }
                    // InternalPerl.g:484:3: ( rule__Token__Group_4__0 )
                    // InternalPerl.g:484:4: rule__Token__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getGroup_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:488:2: ( ruleQuoteLikeToken )
                    {
                    // InternalPerl.g:488:2: ( ruleQuoteLikeToken )
                    // InternalPerl.g:489:3: ruleQuoteLikeToken
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getQuoteLikeTokenParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleQuoteLikeToken();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getQuoteLikeTokenParserRuleCall_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:494:2: ( ( rule__Token__Group_6__0 ) )
                    {
                    // InternalPerl.g:494:2: ( ( rule__Token__Group_6__0 ) )
                    // InternalPerl.g:495:3: ( rule__Token__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getGroup_6()); 
                    }
                    // InternalPerl.g:496:3: ( rule__Token__Group_6__0 )
                    // InternalPerl.g:496:4: rule__Token__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:500:2: ( ( rule__Token__Group_7__0 ) )
                    {
                    // InternalPerl.g:500:2: ( ( rule__Token__Group_7__0 ) )
                    // InternalPerl.g:501:3: ( rule__Token__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getGroup_7()); 
                    }
                    // InternalPerl.g:502:3: ( rule__Token__Group_7__0 )
                    // InternalPerl.g:502:4: rule__Token__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getGroup_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:506:2: ( ruleQuoteToken )
                    {
                    // InternalPerl.g:506:2: ( ruleQuoteToken )
                    // InternalPerl.g:507:3: ruleQuoteToken
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getQuoteTokenParserRuleCall_8()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleQuoteToken();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getQuoteTokenParserRuleCall_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:512:2: ( ( rule__Token__Group_9__0 ) )
                    {
                    // InternalPerl.g:512:2: ( ( rule__Token__Group_9__0 ) )
                    // InternalPerl.g:513:3: ( rule__Token__Group_9__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getGroup_9()); 
                    }
                    // InternalPerl.g:514:3: ( rule__Token__Group_9__0 )
                    // InternalPerl.g:514:4: rule__Token__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_9__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getGroup_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:518:2: ( ( rule__Token__Group_10__0 ) )
                    {
                    // InternalPerl.g:518:2: ( ( rule__Token__Group_10__0 ) )
                    // InternalPerl.g:519:3: ( rule__Token__Group_10__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokenAccess().getGroup_10()); 
                    }
                    // InternalPerl.g:520:3: ( rule__Token__Group_10__0 )
                    // InternalPerl.g:520:4: rule__Token__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_10__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokenAccess().getGroup_10()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Alternatives"


    // $ANTLR start "rule__QuoteToken__ContentAlternatives_1_0"
    // InternalPerl.g:528:1: rule__QuoteToken__ContentAlternatives_1_0 : ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) );
    public final void rule__QuoteToken__ContentAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:532:1: ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt4=1;
                }
                break;
            case RULE_INTERPOLATE:
                {
                alt4=2;
                }
                break;
            case RULE_LITERAL:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalPerl.g:533:2: ( RULE_STRING )
                    {
                    // InternalPerl.g:533:2: ( RULE_STRING )
                    // InternalPerl.g:534:3: RULE_STRING
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 
                    }
                    match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:539:2: ( RULE_INTERPOLATE )
                    {
                    // InternalPerl.g:539:2: ( RULE_INTERPOLATE )
                    // InternalPerl.g:540:3: RULE_INTERPOLATE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 
                    }
                    match(input,RULE_INTERPOLATE,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:545:2: ( RULE_LITERAL )
                    {
                    // InternalPerl.g:545:2: ( RULE_LITERAL )
                    // InternalPerl.g:546:3: RULE_LITERAL
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getQuoteTokenAccess().getContentLITERALTerminalRuleCall_1_0_2()); 
                    }
                    match(input,RULE_LITERAL,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getQuoteTokenAccess().getContentLITERALTerminalRuleCall_1_0_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteToken__ContentAlternatives_1_0"


    // $ANTLR start "rule__QuoteLikeToken__Alternatives"
    // InternalPerl.g:555:1: rule__QuoteLikeToken__Alternatives : ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) );
    public final void rule__QuoteLikeToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:559:1: ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) )
            int alt5=5;
            switch ( input.LA(1) ) {
            case RULE_BACKTICK_STRING:
                {
                alt5=1;
                }
                break;
            case RULE_WORDS_QUOTE_LIKE:
                {
                alt5=2;
                }
                break;
            case RULE_COMMAND_QUOTE_LIKE:
                {
                alt5=3;
                }
                break;
            case RULE_REGEX_QUOTE:
                {
                alt5=4;
                }
                break;
            case RULE_READLINE_QUOTE:
                {
                alt5=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalPerl.g:560:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    {
                    // InternalPerl.g:560:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    // InternalPerl.g:561:3: ( rule__QuoteLikeToken__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getQuoteLikeTokenAccess().getGroup_0()); 
                    }
                    // InternalPerl.g:562:3: ( rule__QuoteLikeToken__Group_0__0 )
                    // InternalPerl.g:562:4: rule__QuoteLikeToken__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuoteLikeToken__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getQuoteLikeTokenAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:566:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    {
                    // InternalPerl.g:566:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    // InternalPerl.g:567:3: ( rule__QuoteLikeToken__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getQuoteLikeTokenAccess().getGroup_1()); 
                    }
                    // InternalPerl.g:568:3: ( rule__QuoteLikeToken__Group_1__0 )
                    // InternalPerl.g:568:4: rule__QuoteLikeToken__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuoteLikeToken__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getQuoteLikeTokenAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:572:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    {
                    // InternalPerl.g:572:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    // InternalPerl.g:573:3: ( rule__QuoteLikeToken__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getQuoteLikeTokenAccess().getGroup_2()); 
                    }
                    // InternalPerl.g:574:3: ( rule__QuoteLikeToken__Group_2__0 )
                    // InternalPerl.g:574:4: rule__QuoteLikeToken__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuoteLikeToken__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getQuoteLikeTokenAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:578:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    {
                    // InternalPerl.g:578:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    // InternalPerl.g:579:3: ( rule__QuoteLikeToken__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getQuoteLikeTokenAccess().getGroup_3()); 
                    }
                    // InternalPerl.g:580:3: ( rule__QuoteLikeToken__Group_3__0 )
                    // InternalPerl.g:580:4: rule__QuoteLikeToken__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuoteLikeToken__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getQuoteLikeTokenAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:584:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    {
                    // InternalPerl.g:584:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    // InternalPerl.g:585:3: ( rule__QuoteLikeToken__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getQuoteLikeTokenAccess().getGroup_4()); 
                    }
                    // InternalPerl.g:586:3: ( rule__QuoteLikeToken__Group_4__0 )
                    // InternalPerl.g:586:4: rule__QuoteLikeToken__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuoteLikeToken__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getQuoteLikeTokenAccess().getGroup_4()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Alternatives"


    // $ANTLR start "rule__Keyword__Alternatives"
    // InternalPerl.g:594:1: rule__Keyword__Alternatives : ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) );
    public final void rule__Keyword__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:598:1: ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) )
            int alt6=222;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt6=1;
                }
                break;
            case 26:
                {
                alt6=2;
                }
                break;
            case 27:
                {
                alt6=3;
                }
                break;
            case 28:
                {
                alt6=4;
                }
                break;
            case 29:
                {
                alt6=5;
                }
                break;
            case 30:
                {
                alt6=6;
                }
                break;
            case 31:
                {
                alt6=7;
                }
                break;
            case 32:
                {
                alt6=8;
                }
                break;
            case 33:
                {
                alt6=9;
                }
                break;
            case 34:
                {
                alt6=10;
                }
                break;
            case 35:
                {
                alt6=11;
                }
                break;
            case 36:
                {
                alt6=12;
                }
                break;
            case 37:
                {
                alt6=13;
                }
                break;
            case 38:
                {
                alt6=14;
                }
                break;
            case 39:
                {
                alt6=15;
                }
                break;
            case 40:
                {
                alt6=16;
                }
                break;
            case 41:
                {
                alt6=17;
                }
                break;
            case 42:
                {
                alt6=18;
                }
                break;
            case 43:
                {
                alt6=19;
                }
                break;
            case 44:
                {
                alt6=20;
                }
                break;
            case 45:
                {
                alt6=21;
                }
                break;
            case 46:
                {
                alt6=22;
                }
                break;
            case 47:
                {
                alt6=23;
                }
                break;
            case 48:
                {
                alt6=24;
                }
                break;
            case 49:
                {
                alt6=25;
                }
                break;
            case 50:
                {
                alt6=26;
                }
                break;
            case 51:
                {
                alt6=27;
                }
                break;
            case 52:
                {
                alt6=28;
                }
                break;
            case 53:
                {
                alt6=29;
                }
                break;
            case 54:
                {
                alt6=30;
                }
                break;
            case 55:
                {
                alt6=31;
                }
                break;
            case 56:
                {
                alt6=32;
                }
                break;
            case 57:
                {
                alt6=33;
                }
                break;
            case 58:
                {
                alt6=34;
                }
                break;
            case 59:
                {
                alt6=35;
                }
                break;
            case 60:
                {
                alt6=36;
                }
                break;
            case 61:
                {
                alt6=37;
                }
                break;
            case 62:
                {
                alt6=38;
                }
                break;
            case 63:
                {
                alt6=39;
                }
                break;
            case 64:
                {
                alt6=40;
                }
                break;
            case 65:
                {
                alt6=41;
                }
                break;
            case 66:
                {
                alt6=42;
                }
                break;
            case 67:
                {
                alt6=43;
                }
                break;
            case 68:
                {
                alt6=44;
                }
                break;
            case 69:
                {
                alt6=45;
                }
                break;
            case 70:
                {
                alt6=46;
                }
                break;
            case 71:
                {
                alt6=47;
                }
                break;
            case 72:
                {
                alt6=48;
                }
                break;
            case 73:
                {
                alt6=49;
                }
                break;
            case 74:
                {
                alt6=50;
                }
                break;
            case 75:
                {
                alt6=51;
                }
                break;
            case 76:
                {
                alt6=52;
                }
                break;
            case 77:
                {
                alt6=53;
                }
                break;
            case 78:
                {
                alt6=54;
                }
                break;
            case 79:
                {
                alt6=55;
                }
                break;
            case 80:
                {
                alt6=56;
                }
                break;
            case 81:
                {
                alt6=57;
                }
                break;
            case 82:
                {
                alt6=58;
                }
                break;
            case 83:
                {
                alt6=59;
                }
                break;
            case 84:
                {
                alt6=60;
                }
                break;
            case 85:
                {
                alt6=61;
                }
                break;
            case 86:
                {
                alt6=62;
                }
                break;
            case 87:
                {
                alt6=63;
                }
                break;
            case 88:
                {
                alt6=64;
                }
                break;
            case 89:
                {
                alt6=65;
                }
                break;
            case 90:
                {
                alt6=66;
                }
                break;
            case 91:
                {
                alt6=67;
                }
                break;
            case 92:
                {
                alt6=68;
                }
                break;
            case 93:
                {
                alt6=69;
                }
                break;
            case 94:
                {
                alt6=70;
                }
                break;
            case 95:
                {
                alt6=71;
                }
                break;
            case 96:
                {
                alt6=72;
                }
                break;
            case 97:
                {
                alt6=73;
                }
                break;
            case 98:
                {
                alt6=74;
                }
                break;
            case 99:
                {
                alt6=75;
                }
                break;
            case 100:
                {
                alt6=76;
                }
                break;
            case 101:
                {
                alt6=77;
                }
                break;
            case 102:
                {
                alt6=78;
                }
                break;
            case 103:
                {
                alt6=79;
                }
                break;
            case 104:
                {
                alt6=80;
                }
                break;
            case 105:
                {
                alt6=81;
                }
                break;
            case 106:
                {
                alt6=82;
                }
                break;
            case 107:
                {
                alt6=83;
                }
                break;
            case 108:
                {
                alt6=84;
                }
                break;
            case 109:
                {
                alt6=85;
                }
                break;
            case 110:
                {
                alt6=86;
                }
                break;
            case 111:
                {
                alt6=87;
                }
                break;
            case 112:
                {
                alt6=88;
                }
                break;
            case 113:
                {
                alt6=89;
                }
                break;
            case 114:
                {
                alt6=90;
                }
                break;
            case 115:
                {
                alt6=91;
                }
                break;
            case 116:
                {
                alt6=92;
                }
                break;
            case 117:
                {
                alt6=93;
                }
                break;
            case 118:
                {
                alt6=94;
                }
                break;
            case 119:
                {
                alt6=95;
                }
                break;
            case 120:
                {
                alt6=96;
                }
                break;
            case 121:
                {
                alt6=97;
                }
                break;
            case 122:
                {
                alt6=98;
                }
                break;
            case 123:
                {
                alt6=99;
                }
                break;
            case 124:
                {
                alt6=100;
                }
                break;
            case 125:
                {
                alt6=101;
                }
                break;
            case 126:
                {
                alt6=102;
                }
                break;
            case 127:
                {
                alt6=103;
                }
                break;
            case 128:
                {
                alt6=104;
                }
                break;
            case 129:
                {
                alt6=105;
                }
                break;
            case 130:
                {
                alt6=106;
                }
                break;
            case 131:
                {
                alt6=107;
                }
                break;
            case 132:
                {
                alt6=108;
                }
                break;
            case 133:
                {
                alt6=109;
                }
                break;
            case 134:
                {
                alt6=110;
                }
                break;
            case 135:
                {
                alt6=111;
                }
                break;
            case 136:
                {
                alt6=112;
                }
                break;
            case 137:
                {
                alt6=113;
                }
                break;
            case 138:
                {
                alt6=114;
                }
                break;
            case 139:
                {
                alt6=115;
                }
                break;
            case 140:
                {
                alt6=116;
                }
                break;
            case 141:
                {
                alt6=117;
                }
                break;
            case 142:
                {
                alt6=118;
                }
                break;
            case 143:
                {
                alt6=119;
                }
                break;
            case 144:
                {
                alt6=120;
                }
                break;
            case 145:
                {
                alt6=121;
                }
                break;
            case 146:
                {
                alt6=122;
                }
                break;
            case 147:
                {
                alt6=123;
                }
                break;
            case 148:
                {
                alt6=124;
                }
                break;
            case 149:
                {
                alt6=125;
                }
                break;
            case 150:
                {
                alt6=126;
                }
                break;
            case 151:
                {
                alt6=127;
                }
                break;
            case 152:
                {
                alt6=128;
                }
                break;
            case 153:
                {
                alt6=129;
                }
                break;
            case 154:
                {
                alt6=130;
                }
                break;
            case 155:
                {
                alt6=131;
                }
                break;
            case 156:
                {
                alt6=132;
                }
                break;
            case 157:
                {
                alt6=133;
                }
                break;
            case 158:
                {
                alt6=134;
                }
                break;
            case 159:
                {
                alt6=135;
                }
                break;
            case 160:
                {
                alt6=136;
                }
                break;
            case 161:
                {
                alt6=137;
                }
                break;
            case 162:
                {
                alt6=138;
                }
                break;
            case 163:
                {
                alt6=139;
                }
                break;
            case 164:
                {
                alt6=140;
                }
                break;
            case 165:
                {
                alt6=141;
                }
                break;
            case 166:
                {
                alt6=142;
                }
                break;
            case 167:
                {
                alt6=143;
                }
                break;
            case 168:
                {
                alt6=144;
                }
                break;
            case 169:
                {
                alt6=145;
                }
                break;
            case 170:
                {
                alt6=146;
                }
                break;
            case 171:
                {
                alt6=147;
                }
                break;
            case 172:
                {
                alt6=148;
                }
                break;
            case 173:
                {
                alt6=149;
                }
                break;
            case 174:
                {
                alt6=150;
                }
                break;
            case 175:
                {
                alt6=151;
                }
                break;
            case 176:
                {
                alt6=152;
                }
                break;
            case 177:
                {
                alt6=153;
                }
                break;
            case 178:
                {
                alt6=154;
                }
                break;
            case 179:
                {
                alt6=155;
                }
                break;
            case 180:
                {
                alt6=156;
                }
                break;
            case 181:
                {
                alt6=157;
                }
                break;
            case 182:
                {
                alt6=158;
                }
                break;
            case 183:
                {
                alt6=159;
                }
                break;
            case 184:
                {
                alt6=160;
                }
                break;
            case 185:
                {
                alt6=161;
                }
                break;
            case 186:
                {
                alt6=162;
                }
                break;
            case 187:
                {
                alt6=163;
                }
                break;
            case 188:
                {
                alt6=164;
                }
                break;
            case 189:
                {
                alt6=165;
                }
                break;
            case 190:
                {
                alt6=166;
                }
                break;
            case 191:
                {
                alt6=167;
                }
                break;
            case 192:
                {
                alt6=168;
                }
                break;
            case 193:
                {
                alt6=169;
                }
                break;
            case 194:
                {
                alt6=170;
                }
                break;
            case 195:
                {
                alt6=171;
                }
                break;
            case 196:
                {
                alt6=172;
                }
                break;
            case 197:
                {
                alt6=173;
                }
                break;
            case 198:
                {
                alt6=174;
                }
                break;
            case 199:
                {
                alt6=175;
                }
                break;
            case 200:
                {
                alt6=176;
                }
                break;
            case 201:
                {
                alt6=177;
                }
                break;
            case 202:
                {
                alt6=178;
                }
                break;
            case 203:
                {
                alt6=179;
                }
                break;
            case 204:
                {
                alt6=180;
                }
                break;
            case 205:
                {
                alt6=181;
                }
                break;
            case 206:
                {
                alt6=182;
                }
                break;
            case 207:
                {
                alt6=183;
                }
                break;
            case 208:
                {
                alt6=184;
                }
                break;
            case 209:
                {
                alt6=185;
                }
                break;
            case 210:
                {
                alt6=186;
                }
                break;
            case 211:
                {
                alt6=187;
                }
                break;
            case 212:
                {
                alt6=188;
                }
                break;
            case 213:
                {
                alt6=189;
                }
                break;
            case 214:
                {
                alt6=190;
                }
                break;
            case 215:
                {
                alt6=191;
                }
                break;
            case 216:
                {
                alt6=192;
                }
                break;
            case 217:
                {
                alt6=193;
                }
                break;
            case 218:
                {
                alt6=194;
                }
                break;
            case 219:
                {
                alt6=195;
                }
                break;
            case 220:
                {
                alt6=196;
                }
                break;
            case 221:
                {
                alt6=197;
                }
                break;
            case 222:
                {
                alt6=198;
                }
                break;
            case 223:
                {
                alt6=199;
                }
                break;
            case 224:
                {
                alt6=200;
                }
                break;
            case 225:
                {
                alt6=201;
                }
                break;
            case 226:
                {
                alt6=202;
                }
                break;
            case 227:
                {
                alt6=203;
                }
                break;
            case 228:
                {
                alt6=204;
                }
                break;
            case 229:
                {
                alt6=205;
                }
                break;
            case 230:
                {
                alt6=206;
                }
                break;
            case 231:
                {
                alt6=207;
                }
                break;
            case 232:
                {
                alt6=208;
                }
                break;
            case 233:
                {
                alt6=209;
                }
                break;
            case 234:
                {
                alt6=210;
                }
                break;
            case 235:
                {
                alt6=211;
                }
                break;
            case 236:
                {
                alt6=212;
                }
                break;
            case 237:
                {
                alt6=213;
                }
                break;
            case 238:
                {
                alt6=214;
                }
                break;
            case 239:
                {
                alt6=215;
                }
                break;
            case 240:
                {
                alt6=216;
                }
                break;
            case 241:
                {
                alt6=217;
                }
                break;
            case 242:
                {
                alt6=218;
                }
                break;
            case 243:
                {
                alt6=219;
                }
                break;
            case 244:
                {
                alt6=220;
                }
                break;
            case 245:
                {
                alt6=221;
                }
                break;
            case 246:
                {
                alt6=222;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalPerl.g:599:2: ( 'abs' )
                    {
                    // InternalPerl.g:599:2: ( 'abs' )
                    // InternalPerl.g:600:3: 'abs'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 
                    }
                    match(input,25,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:605:2: ( 'accept' )
                    {
                    // InternalPerl.g:605:2: ( 'accept' )
                    // InternalPerl.g:606:3: 'accept'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 
                    }
                    match(input,26,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:611:2: ( 'alarm' )
                    {
                    // InternalPerl.g:611:2: ( 'alarm' )
                    // InternalPerl.g:612:3: 'alarm'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 
                    }
                    match(input,27,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:617:2: ( 'atan2' )
                    {
                    // InternalPerl.g:617:2: ( 'atan2' )
                    // InternalPerl.g:618:3: 'atan2'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 
                    }
                    match(input,28,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:623:2: ( 'bind' )
                    {
                    // InternalPerl.g:623:2: ( 'bind' )
                    // InternalPerl.g:624:3: 'bind'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getBindKeyword_4()); 
                    }
                    match(input,29,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getBindKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:629:2: ( 'binmode' )
                    {
                    // InternalPerl.g:629:2: ( 'binmode' )
                    // InternalPerl.g:630:3: 'binmode'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 
                    }
                    match(input,30,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:635:2: ( 'bless' )
                    {
                    // InternalPerl.g:635:2: ( 'bless' )
                    // InternalPerl.g:636:3: 'bless'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 
                    }
                    match(input,31,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:641:2: ( 'break' )
                    {
                    // InternalPerl.g:641:2: ( 'break' )
                    // InternalPerl.g:642:3: 'break'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 
                    }
                    match(input,32,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:647:2: ( 'caller' )
                    {
                    // InternalPerl.g:647:2: ( 'caller' )
                    // InternalPerl.g:648:3: 'caller'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 
                    }
                    match(input,33,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:653:2: ( 'chdir' )
                    {
                    // InternalPerl.g:653:2: ( 'chdir' )
                    // InternalPerl.g:654:3: 'chdir'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 
                    }
                    match(input,34,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:659:2: ( 'chmod' )
                    {
                    // InternalPerl.g:659:2: ( 'chmod' )
                    // InternalPerl.g:660:3: 'chmod'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 
                    }
                    match(input,35,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:665:2: ( 'chomp' )
                    {
                    // InternalPerl.g:665:2: ( 'chomp' )
                    // InternalPerl.g:666:3: 'chomp'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getChompKeyword_11()); 
                    }
                    match(input,36,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getChompKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:671:2: ( 'chop' )
                    {
                    // InternalPerl.g:671:2: ( 'chop' )
                    // InternalPerl.g:672:3: 'chop'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getChopKeyword_12()); 
                    }
                    match(input,37,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getChopKeyword_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:677:2: ( 'chown' )
                    {
                    // InternalPerl.g:677:2: ( 'chown' )
                    // InternalPerl.g:678:3: 'chown'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getChownKeyword_13()); 
                    }
                    match(input,38,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getChownKeyword_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:683:2: ( 'chr' )
                    {
                    // InternalPerl.g:683:2: ( 'chr' )
                    // InternalPerl.g:684:3: 'chr'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getChrKeyword_14()); 
                    }
                    match(input,39,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getChrKeyword_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:689:2: ( 'chroot' )
                    {
                    // InternalPerl.g:689:2: ( 'chroot' )
                    // InternalPerl.g:690:3: 'chroot'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 
                    }
                    match(input,40,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:695:2: ( 'close' )
                    {
                    // InternalPerl.g:695:2: ( 'close' )
                    // InternalPerl.g:696:3: 'close'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 
                    }
                    match(input,41,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:701:2: ( 'closedir' )
                    {
                    // InternalPerl.g:701:2: ( 'closedir' )
                    // InternalPerl.g:702:3: 'closedir'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 
                    }
                    match(input,42,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:707:2: ( 'connect' )
                    {
                    // InternalPerl.g:707:2: ( 'connect' )
                    // InternalPerl.g:708:3: 'connect'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 
                    }
                    match(input,43,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:713:2: ( 'continue' )
                    {
                    // InternalPerl.g:713:2: ( 'continue' )
                    // InternalPerl.g:714:3: 'continue'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 
                    }
                    match(input,44,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:719:2: ( 'cos' )
                    {
                    // InternalPerl.g:719:2: ( 'cos' )
                    // InternalPerl.g:720:3: 'cos'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getCosKeyword_20()); 
                    }
                    match(input,45,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getCosKeyword_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:725:2: ( 'crypt' )
                    {
                    // InternalPerl.g:725:2: ( 'crypt' )
                    // InternalPerl.g:726:3: 'crypt'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 
                    }
                    match(input,46,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:731:2: ( 'dbmclose' )
                    {
                    // InternalPerl.g:731:2: ( 'dbmclose' )
                    // InternalPerl.g:732:3: 'dbmclose'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 
                    }
                    match(input,47,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:737:2: ( 'dbmopen' )
                    {
                    // InternalPerl.g:737:2: ( 'dbmopen' )
                    // InternalPerl.g:738:3: 'dbmopen'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 
                    }
                    match(input,48,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:743:2: ( 'default' )
                    {
                    // InternalPerl.g:743:2: ( 'default' )
                    // InternalPerl.g:744:3: 'default'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 
                    }
                    match(input,49,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:749:2: ( 'defined' )
                    {
                    // InternalPerl.g:749:2: ( 'defined' )
                    // InternalPerl.g:750:3: 'defined'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 
                    }
                    match(input,50,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:755:2: ( 'delete' )
                    {
                    // InternalPerl.g:755:2: ( 'delete' )
                    // InternalPerl.g:756:3: 'delete'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 
                    }
                    match(input,51,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 
                    }

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:761:2: ( 'die' )
                    {
                    // InternalPerl.g:761:2: ( 'die' )
                    // InternalPerl.g:762:3: 'die'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getDieKeyword_27()); 
                    }
                    match(input,52,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getDieKeyword_27()); 
                    }

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:767:2: ( 'do' )
                    {
                    // InternalPerl.g:767:2: ( 'do' )
                    // InternalPerl.g:768:3: 'do'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getDoKeyword_28()); 
                    }
                    match(input,53,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getDoKeyword_28()); 
                    }

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:773:2: ( 'dump' )
                    {
                    // InternalPerl.g:773:2: ( 'dump' )
                    // InternalPerl.g:774:3: 'dump'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 
                    }
                    match(input,54,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 
                    }

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:779:2: ( 'each' )
                    {
                    // InternalPerl.g:779:2: ( 'each' )
                    // InternalPerl.g:780:3: 'each'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getEachKeyword_30()); 
                    }
                    match(input,55,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getEachKeyword_30()); 
                    }

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:785:2: ( 'else' )
                    {
                    // InternalPerl.g:785:2: ( 'else' )
                    // InternalPerl.g:786:3: 'else'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getElseKeyword_31()); 
                    }
                    match(input,56,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getElseKeyword_31()); 
                    }

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:791:2: ( 'elsif' )
                    {
                    // InternalPerl.g:791:2: ( 'elsif' )
                    // InternalPerl.g:792:3: 'elsif'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 
                    }
                    match(input,57,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 
                    }

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:797:2: ( 'endgrent' )
                    {
                    // InternalPerl.g:797:2: ( 'endgrent' )
                    // InternalPerl.g:798:3: 'endgrent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 
                    }
                    match(input,58,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 
                    }

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:803:2: ( 'endhostent' )
                    {
                    // InternalPerl.g:803:2: ( 'endhostent' )
                    // InternalPerl.g:804:3: 'endhostent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 
                    }
                    match(input,59,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 
                    }

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:809:2: ( 'endnetent' )
                    {
                    // InternalPerl.g:809:2: ( 'endnetent' )
                    // InternalPerl.g:810:3: 'endnetent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 
                    }
                    match(input,60,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 
                    }

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:815:2: ( 'endprotoent' )
                    {
                    // InternalPerl.g:815:2: ( 'endprotoent' )
                    // InternalPerl.g:816:3: 'endprotoent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 
                    }
                    match(input,61,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 
                    }

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:821:2: ( 'endpwent' )
                    {
                    // InternalPerl.g:821:2: ( 'endpwent' )
                    // InternalPerl.g:822:3: 'endpwent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 
                    }
                    match(input,62,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 
                    }

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:827:2: ( 'endservent' )
                    {
                    // InternalPerl.g:827:2: ( 'endservent' )
                    // InternalPerl.g:828:3: 'endservent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 
                    }
                    match(input,63,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 
                    }

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:833:2: ( 'eof' )
                    {
                    // InternalPerl.g:833:2: ( 'eof' )
                    // InternalPerl.g:834:3: 'eof'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getEofKeyword_39()); 
                    }
                    match(input,64,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getEofKeyword_39()); 
                    }

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:839:2: ( 'eval' )
                    {
                    // InternalPerl.g:839:2: ( 'eval' )
                    // InternalPerl.g:840:3: 'eval'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 
                    }
                    match(input,65,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 
                    }

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:845:2: ( 'evalbytes' )
                    {
                    // InternalPerl.g:845:2: ( 'evalbytes' )
                    // InternalPerl.g:846:3: 'evalbytes'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 
                    }
                    match(input,66,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 
                    }

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:851:2: ( 'exec' )
                    {
                    // InternalPerl.g:851:2: ( 'exec' )
                    // InternalPerl.g:852:3: 'exec'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getExecKeyword_42()); 
                    }
                    match(input,67,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getExecKeyword_42()); 
                    }

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:857:2: ( 'exists' )
                    {
                    // InternalPerl.g:857:2: ( 'exists' )
                    // InternalPerl.g:858:3: 'exists'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 
                    }
                    match(input,68,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 
                    }

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:863:2: ( 'exit' )
                    {
                    // InternalPerl.g:863:2: ( 'exit' )
                    // InternalPerl.g:864:3: 'exit'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getExitKeyword_44()); 
                    }
                    match(input,69,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getExitKeyword_44()); 
                    }

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:869:2: ( 'exp' )
                    {
                    // InternalPerl.g:869:2: ( 'exp' )
                    // InternalPerl.g:870:3: 'exp'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getExpKeyword_45()); 
                    }
                    match(input,70,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getExpKeyword_45()); 
                    }

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:875:2: ( 'fc' )
                    {
                    // InternalPerl.g:875:2: ( 'fc' )
                    // InternalPerl.g:876:3: 'fc'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getFcKeyword_46()); 
                    }
                    match(input,71,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getFcKeyword_46()); 
                    }

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:881:2: ( 'fcntl' )
                    {
                    // InternalPerl.g:881:2: ( 'fcntl' )
                    // InternalPerl.g:882:3: 'fcntl'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 
                    }
                    match(input,72,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 
                    }

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:887:2: ( 'fileno' )
                    {
                    // InternalPerl.g:887:2: ( 'fileno' )
                    // InternalPerl.g:888:3: 'fileno'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 
                    }
                    match(input,73,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 
                    }

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:893:2: ( 'flock' )
                    {
                    // InternalPerl.g:893:2: ( 'flock' )
                    // InternalPerl.g:894:3: 'flock'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 
                    }
                    match(input,74,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 
                    }

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:899:2: ( 'for' )
                    {
                    // InternalPerl.g:899:2: ( 'for' )
                    // InternalPerl.g:900:3: 'for'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getForKeyword_50()); 
                    }
                    match(input,75,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getForKeyword_50()); 
                    }

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:905:2: ( 'foreach' )
                    {
                    // InternalPerl.g:905:2: ( 'foreach' )
                    // InternalPerl.g:906:3: 'foreach'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 
                    }
                    match(input,76,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 
                    }

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:911:2: ( 'fork' )
                    {
                    // InternalPerl.g:911:2: ( 'fork' )
                    // InternalPerl.g:912:3: 'fork'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getForkKeyword_52()); 
                    }
                    match(input,77,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getForkKeyword_52()); 
                    }

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:917:2: ( 'format' )
                    {
                    // InternalPerl.g:917:2: ( 'format' )
                    // InternalPerl.g:918:3: 'format'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 
                    }
                    match(input,78,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 
                    }

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:923:2: ( 'formline' )
                    {
                    // InternalPerl.g:923:2: ( 'formline' )
                    // InternalPerl.g:924:3: 'formline'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 
                    }
                    match(input,79,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 
                    }

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:929:2: ( 'getc' )
                    {
                    // InternalPerl.g:929:2: ( 'getc' )
                    // InternalPerl.g:930:3: 'getc'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 
                    }
                    match(input,80,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 
                    }

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:935:2: ( 'getgrent' )
                    {
                    // InternalPerl.g:935:2: ( 'getgrent' )
                    // InternalPerl.g:936:3: 'getgrent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 
                    }
                    match(input,81,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 
                    }

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:941:2: ( 'getgrgid' )
                    {
                    // InternalPerl.g:941:2: ( 'getgrgid' )
                    // InternalPerl.g:942:3: 'getgrgid'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 
                    }
                    match(input,82,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 
                    }

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:947:2: ( 'getgrnam' )
                    {
                    // InternalPerl.g:947:2: ( 'getgrnam' )
                    // InternalPerl.g:948:3: 'getgrnam'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 
                    }
                    match(input,83,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 
                    }

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:953:2: ( 'gethostbyaddr' )
                    {
                    // InternalPerl.g:953:2: ( 'gethostbyaddr' )
                    // InternalPerl.g:954:3: 'gethostbyaddr'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 
                    }
                    match(input,84,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 
                    }

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:959:2: ( 'gethostbyname' )
                    {
                    // InternalPerl.g:959:2: ( 'gethostbyname' )
                    // InternalPerl.g:960:3: 'gethostbyname'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 
                    }
                    match(input,85,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 
                    }

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:965:2: ( 'gethostent' )
                    {
                    // InternalPerl.g:965:2: ( 'gethostent' )
                    // InternalPerl.g:966:3: 'gethostent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 
                    }
                    match(input,86,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 
                    }

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:971:2: ( 'getlogin' )
                    {
                    // InternalPerl.g:971:2: ( 'getlogin' )
                    // InternalPerl.g:972:3: 'getlogin'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 
                    }
                    match(input,87,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 
                    }

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:977:2: ( 'getnetbyaddr' )
                    {
                    // InternalPerl.g:977:2: ( 'getnetbyaddr' )
                    // InternalPerl.g:978:3: 'getnetbyaddr'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 
                    }
                    match(input,88,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 
                    }

                    }


                    }
                    break;
                case 65 :
                    // InternalPerl.g:983:2: ( 'getnetbyname' )
                    {
                    // InternalPerl.g:983:2: ( 'getnetbyname' )
                    // InternalPerl.g:984:3: 'getnetbyname'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 
                    }
                    match(input,89,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 
                    }

                    }


                    }
                    break;
                case 66 :
                    // InternalPerl.g:989:2: ( 'getnetent' )
                    {
                    // InternalPerl.g:989:2: ( 'getnetent' )
                    // InternalPerl.g:990:3: 'getnetent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 
                    }
                    match(input,90,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 
                    }

                    }


                    }
                    break;
                case 67 :
                    // InternalPerl.g:995:2: ( 'getpeername' )
                    {
                    // InternalPerl.g:995:2: ( 'getpeername' )
                    // InternalPerl.g:996:3: 'getpeername'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 
                    }
                    match(input,91,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 
                    }

                    }


                    }
                    break;
                case 68 :
                    // InternalPerl.g:1001:2: ( 'getpgrp' )
                    {
                    // InternalPerl.g:1001:2: ( 'getpgrp' )
                    // InternalPerl.g:1002:3: 'getpgrp'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 
                    }
                    match(input,92,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 
                    }

                    }


                    }
                    break;
                case 69 :
                    // InternalPerl.g:1007:2: ( 'getppid' )
                    {
                    // InternalPerl.g:1007:2: ( 'getppid' )
                    // InternalPerl.g:1008:3: 'getppid'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 
                    }
                    match(input,93,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 
                    }

                    }


                    }
                    break;
                case 70 :
                    // InternalPerl.g:1013:2: ( 'getpriority' )
                    {
                    // InternalPerl.g:1013:2: ( 'getpriority' )
                    // InternalPerl.g:1014:3: 'getpriority'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 
                    }
                    match(input,94,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 
                    }

                    }


                    }
                    break;
                case 71 :
                    // InternalPerl.g:1019:2: ( 'getprotobyname' )
                    {
                    // InternalPerl.g:1019:2: ( 'getprotobyname' )
                    // InternalPerl.g:1020:3: 'getprotobyname'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 
                    }
                    match(input,95,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 
                    }

                    }


                    }
                    break;
                case 72 :
                    // InternalPerl.g:1025:2: ( 'getprotobynumber' )
                    {
                    // InternalPerl.g:1025:2: ( 'getprotobynumber' )
                    // InternalPerl.g:1026:3: 'getprotobynumber'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 
                    }
                    match(input,96,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 
                    }

                    }


                    }
                    break;
                case 73 :
                    // InternalPerl.g:1031:2: ( 'getprotoent' )
                    {
                    // InternalPerl.g:1031:2: ( 'getprotoent' )
                    // InternalPerl.g:1032:3: 'getprotoent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 
                    }
                    match(input,97,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 
                    }

                    }


                    }
                    break;
                case 74 :
                    // InternalPerl.g:1037:2: ( 'getpwent' )
                    {
                    // InternalPerl.g:1037:2: ( 'getpwent' )
                    // InternalPerl.g:1038:3: 'getpwent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 
                    }
                    match(input,98,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 
                    }

                    }


                    }
                    break;
                case 75 :
                    // InternalPerl.g:1043:2: ( 'getpwnam' )
                    {
                    // InternalPerl.g:1043:2: ( 'getpwnam' )
                    // InternalPerl.g:1044:3: 'getpwnam'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 
                    }
                    match(input,99,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 
                    }

                    }


                    }
                    break;
                case 76 :
                    // InternalPerl.g:1049:2: ( 'getpwuid' )
                    {
                    // InternalPerl.g:1049:2: ( 'getpwuid' )
                    // InternalPerl.g:1050:3: 'getpwuid'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 
                    }
                    match(input,100,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 
                    }

                    }


                    }
                    break;
                case 77 :
                    // InternalPerl.g:1055:2: ( 'getservbyname' )
                    {
                    // InternalPerl.g:1055:2: ( 'getservbyname' )
                    // InternalPerl.g:1056:3: 'getservbyname'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 
                    }
                    match(input,101,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 
                    }

                    }


                    }
                    break;
                case 78 :
                    // InternalPerl.g:1061:2: ( 'getservbyport' )
                    {
                    // InternalPerl.g:1061:2: ( 'getservbyport' )
                    // InternalPerl.g:1062:3: 'getservbyport'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 
                    }
                    match(input,102,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 
                    }

                    }


                    }
                    break;
                case 79 :
                    // InternalPerl.g:1067:2: ( 'getservent' )
                    {
                    // InternalPerl.g:1067:2: ( 'getservent' )
                    // InternalPerl.g:1068:3: 'getservent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 
                    }
                    match(input,103,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 
                    }

                    }


                    }
                    break;
                case 80 :
                    // InternalPerl.g:1073:2: ( 'getsockname' )
                    {
                    // InternalPerl.g:1073:2: ( 'getsockname' )
                    // InternalPerl.g:1074:3: 'getsockname'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 
                    }
                    match(input,104,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 
                    }

                    }


                    }
                    break;
                case 81 :
                    // InternalPerl.g:1079:2: ( 'getsockopt' )
                    {
                    // InternalPerl.g:1079:2: ( 'getsockopt' )
                    // InternalPerl.g:1080:3: 'getsockopt'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 
                    }
                    match(input,105,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 
                    }

                    }


                    }
                    break;
                case 82 :
                    // InternalPerl.g:1085:2: ( 'given' )
                    {
                    // InternalPerl.g:1085:2: ( 'given' )
                    // InternalPerl.g:1086:3: 'given'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 
                    }
                    match(input,106,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 
                    }

                    }


                    }
                    break;
                case 83 :
                    // InternalPerl.g:1091:2: ( 'glob' )
                    {
                    // InternalPerl.g:1091:2: ( 'glob' )
                    // InternalPerl.g:1092:3: 'glob'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 
                    }
                    match(input,107,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 
                    }

                    }


                    }
                    break;
                case 84 :
                    // InternalPerl.g:1097:2: ( 'gmtime' )
                    {
                    // InternalPerl.g:1097:2: ( 'gmtime' )
                    // InternalPerl.g:1098:3: 'gmtime'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 
                    }
                    match(input,108,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 
                    }

                    }


                    }
                    break;
                case 85 :
                    // InternalPerl.g:1103:2: ( 'goto' )
                    {
                    // InternalPerl.g:1103:2: ( 'goto' )
                    // InternalPerl.g:1104:3: 'goto'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 
                    }
                    match(input,109,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 
                    }

                    }


                    }
                    break;
                case 86 :
                    // InternalPerl.g:1109:2: ( 'grep' )
                    {
                    // InternalPerl.g:1109:2: ( 'grep' )
                    // InternalPerl.g:1110:3: 'grep'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 
                    }
                    match(input,110,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 
                    }

                    }


                    }
                    break;
                case 87 :
                    // InternalPerl.g:1115:2: ( 'hex' )
                    {
                    // InternalPerl.g:1115:2: ( 'hex' )
                    // InternalPerl.g:1116:3: 'hex'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getHexKeyword_86()); 
                    }
                    match(input,111,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getHexKeyword_86()); 
                    }

                    }


                    }
                    break;
                case 88 :
                    // InternalPerl.g:1121:2: ( 'if' )
                    {
                    // InternalPerl.g:1121:2: ( 'if' )
                    // InternalPerl.g:1122:3: 'if'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getIfKeyword_87()); 
                    }
                    match(input,112,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getIfKeyword_87()); 
                    }

                    }


                    }
                    break;
                case 89 :
                    // InternalPerl.g:1127:2: ( 'index' )
                    {
                    // InternalPerl.g:1127:2: ( 'index' )
                    // InternalPerl.g:1128:3: 'index'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 
                    }
                    match(input,113,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 
                    }

                    }


                    }
                    break;
                case 90 :
                    // InternalPerl.g:1133:2: ( 'int' )
                    {
                    // InternalPerl.g:1133:2: ( 'int' )
                    // InternalPerl.g:1134:3: 'int'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getIntKeyword_89()); 
                    }
                    match(input,114,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getIntKeyword_89()); 
                    }

                    }


                    }
                    break;
                case 91 :
                    // InternalPerl.g:1139:2: ( 'ioctl' )
                    {
                    // InternalPerl.g:1139:2: ( 'ioctl' )
                    // InternalPerl.g:1140:3: 'ioctl'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 
                    }
                    match(input,115,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 
                    }

                    }


                    }
                    break;
                case 92 :
                    // InternalPerl.g:1145:2: ( 'join' )
                    {
                    // InternalPerl.g:1145:2: ( 'join' )
                    // InternalPerl.g:1146:3: 'join'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 
                    }
                    match(input,116,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 
                    }

                    }


                    }
                    break;
                case 93 :
                    // InternalPerl.g:1151:2: ( 'keys' )
                    {
                    // InternalPerl.g:1151:2: ( 'keys' )
                    // InternalPerl.g:1152:3: 'keys'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 
                    }
                    match(input,117,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 
                    }

                    }


                    }
                    break;
                case 94 :
                    // InternalPerl.g:1157:2: ( 'kill' )
                    {
                    // InternalPerl.g:1157:2: ( 'kill' )
                    // InternalPerl.g:1158:3: 'kill'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getKillKeyword_93()); 
                    }
                    match(input,118,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getKillKeyword_93()); 
                    }

                    }


                    }
                    break;
                case 95 :
                    // InternalPerl.g:1163:2: ( 'last' )
                    {
                    // InternalPerl.g:1163:2: ( 'last' )
                    // InternalPerl.g:1164:3: 'last'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getLastKeyword_94()); 
                    }
                    match(input,119,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getLastKeyword_94()); 
                    }

                    }


                    }
                    break;
                case 96 :
                    // InternalPerl.g:1169:2: ( 'lc' )
                    {
                    // InternalPerl.g:1169:2: ( 'lc' )
                    // InternalPerl.g:1170:3: 'lc'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getLcKeyword_95()); 
                    }
                    match(input,120,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getLcKeyword_95()); 
                    }

                    }


                    }
                    break;
                case 97 :
                    // InternalPerl.g:1175:2: ( 'lcfirst' )
                    {
                    // InternalPerl.g:1175:2: ( 'lcfirst' )
                    // InternalPerl.g:1176:3: 'lcfirst'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 
                    }
                    match(input,121,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 
                    }

                    }


                    }
                    break;
                case 98 :
                    // InternalPerl.g:1181:2: ( 'length' )
                    {
                    // InternalPerl.g:1181:2: ( 'length' )
                    // InternalPerl.g:1182:3: 'length'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 
                    }
                    match(input,122,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 
                    }

                    }


                    }
                    break;
                case 99 :
                    // InternalPerl.g:1187:2: ( 'link' )
                    {
                    // InternalPerl.g:1187:2: ( 'link' )
                    // InternalPerl.g:1188:3: 'link'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 
                    }
                    match(input,123,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 
                    }

                    }


                    }
                    break;
                case 100 :
                    // InternalPerl.g:1193:2: ( 'listen' )
                    {
                    // InternalPerl.g:1193:2: ( 'listen' )
                    // InternalPerl.g:1194:3: 'listen'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getListenKeyword_99()); 
                    }
                    match(input,124,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getListenKeyword_99()); 
                    }

                    }


                    }
                    break;
                case 101 :
                    // InternalPerl.g:1199:2: ( 'local' )
                    {
                    // InternalPerl.g:1199:2: ( 'local' )
                    // InternalPerl.g:1200:3: 'local'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 
                    }
                    match(input,125,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 
                    }

                    }


                    }
                    break;
                case 102 :
                    // InternalPerl.g:1205:2: ( 'localtime' )
                    {
                    // InternalPerl.g:1205:2: ( 'localtime' )
                    // InternalPerl.g:1206:3: 'localtime'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 
                    }
                    match(input,126,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 
                    }

                    }


                    }
                    break;
                case 103 :
                    // InternalPerl.g:1211:2: ( 'lock' )
                    {
                    // InternalPerl.g:1211:2: ( 'lock' )
                    // InternalPerl.g:1212:3: 'lock'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getLockKeyword_102()); 
                    }
                    match(input,127,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getLockKeyword_102()); 
                    }

                    }


                    }
                    break;
                case 104 :
                    // InternalPerl.g:1217:2: ( 'log' )
                    {
                    // InternalPerl.g:1217:2: ( 'log' )
                    // InternalPerl.g:1218:3: 'log'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getLogKeyword_103()); 
                    }
                    match(input,128,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getLogKeyword_103()); 
                    }

                    }


                    }
                    break;
                case 105 :
                    // InternalPerl.g:1223:2: ( 'lstat' )
                    {
                    // InternalPerl.g:1223:2: ( 'lstat' )
                    // InternalPerl.g:1224:3: 'lstat'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 
                    }
                    match(input,129,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 
                    }

                    }


                    }
                    break;
                case 106 :
                    // InternalPerl.g:1229:2: ( 'map' )
                    {
                    // InternalPerl.g:1229:2: ( 'map' )
                    // InternalPerl.g:1230:3: 'map'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getMapKeyword_105()); 
                    }
                    match(input,130,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getMapKeyword_105()); 
                    }

                    }


                    }
                    break;
                case 107 :
                    // InternalPerl.g:1235:2: ( 'mkdir' )
                    {
                    // InternalPerl.g:1235:2: ( 'mkdir' )
                    // InternalPerl.g:1236:3: 'mkdir'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 
                    }
                    match(input,131,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 
                    }

                    }


                    }
                    break;
                case 108 :
                    // InternalPerl.g:1241:2: ( 'msgctl' )
                    {
                    // InternalPerl.g:1241:2: ( 'msgctl' )
                    // InternalPerl.g:1242:3: 'msgctl'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 
                    }
                    match(input,132,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 
                    }

                    }


                    }
                    break;
                case 109 :
                    // InternalPerl.g:1247:2: ( 'msgget' )
                    {
                    // InternalPerl.g:1247:2: ( 'msgget' )
                    // InternalPerl.g:1248:3: 'msgget'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 
                    }
                    match(input,133,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 
                    }

                    }


                    }
                    break;
                case 110 :
                    // InternalPerl.g:1253:2: ( 'msgrcv' )
                    {
                    // InternalPerl.g:1253:2: ( 'msgrcv' )
                    // InternalPerl.g:1254:3: 'msgrcv'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 
                    }
                    match(input,134,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 
                    }

                    }


                    }
                    break;
                case 111 :
                    // InternalPerl.g:1259:2: ( 'msgsnd' )
                    {
                    // InternalPerl.g:1259:2: ( 'msgsnd' )
                    // InternalPerl.g:1260:3: 'msgsnd'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 
                    }
                    match(input,135,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 
                    }

                    }


                    }
                    break;
                case 112 :
                    // InternalPerl.g:1265:2: ( 'my' )
                    {
                    // InternalPerl.g:1265:2: ( 'my' )
                    // InternalPerl.g:1266:3: 'my'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getMyKeyword_111()); 
                    }
                    match(input,136,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getMyKeyword_111()); 
                    }

                    }


                    }
                    break;
                case 113 :
                    // InternalPerl.g:1271:2: ( 'next' )
                    {
                    // InternalPerl.g:1271:2: ( 'next' )
                    // InternalPerl.g:1272:3: 'next'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getNextKeyword_112()); 
                    }
                    match(input,137,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getNextKeyword_112()); 
                    }

                    }


                    }
                    break;
                case 114 :
                    // InternalPerl.g:1277:2: ( 'no' )
                    {
                    // InternalPerl.g:1277:2: ( 'no' )
                    // InternalPerl.g:1278:3: 'no'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getNoKeyword_113()); 
                    }
                    match(input,138,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getNoKeyword_113()); 
                    }

                    }


                    }
                    break;
                case 115 :
                    // InternalPerl.g:1283:2: ( 'oct' )
                    {
                    // InternalPerl.g:1283:2: ( 'oct' )
                    // InternalPerl.g:1284:3: 'oct'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getOctKeyword_114()); 
                    }
                    match(input,139,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getOctKeyword_114()); 
                    }

                    }


                    }
                    break;
                case 116 :
                    // InternalPerl.g:1289:2: ( 'open' )
                    {
                    // InternalPerl.g:1289:2: ( 'open' )
                    // InternalPerl.g:1290:3: 'open'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 
                    }
                    match(input,140,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 
                    }

                    }


                    }
                    break;
                case 117 :
                    // InternalPerl.g:1295:2: ( 'opendir' )
                    {
                    // InternalPerl.g:1295:2: ( 'opendir' )
                    // InternalPerl.g:1296:3: 'opendir'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 
                    }
                    match(input,141,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 
                    }

                    }


                    }
                    break;
                case 118 :
                    // InternalPerl.g:1301:2: ( 'ord' )
                    {
                    // InternalPerl.g:1301:2: ( 'ord' )
                    // InternalPerl.g:1302:3: 'ord'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 
                    }
                    match(input,142,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 
                    }

                    }


                    }
                    break;
                case 119 :
                    // InternalPerl.g:1307:2: ( 'our' )
                    {
                    // InternalPerl.g:1307:2: ( 'our' )
                    // InternalPerl.g:1308:3: 'our'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getOurKeyword_118()); 
                    }
                    match(input,143,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getOurKeyword_118()); 
                    }

                    }


                    }
                    break;
                case 120 :
                    // InternalPerl.g:1313:2: ( 'pack' )
                    {
                    // InternalPerl.g:1313:2: ( 'pack' )
                    // InternalPerl.g:1314:3: 'pack'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getPackKeyword_119()); 
                    }
                    match(input,144,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getPackKeyword_119()); 
                    }

                    }


                    }
                    break;
                case 121 :
                    // InternalPerl.g:1319:2: ( 'package' )
                    {
                    // InternalPerl.g:1319:2: ( 'package' )
                    // InternalPerl.g:1320:3: 'package'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 
                    }
                    match(input,145,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 
                    }

                    }


                    }
                    break;
                case 122 :
                    // InternalPerl.g:1325:2: ( 'pipe' )
                    {
                    // InternalPerl.g:1325:2: ( 'pipe' )
                    // InternalPerl.g:1326:3: 'pipe'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 
                    }
                    match(input,146,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 
                    }

                    }


                    }
                    break;
                case 123 :
                    // InternalPerl.g:1331:2: ( 'pop' )
                    {
                    // InternalPerl.g:1331:2: ( 'pop' )
                    // InternalPerl.g:1332:3: 'pop'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getPopKeyword_122()); 
                    }
                    match(input,147,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getPopKeyword_122()); 
                    }

                    }


                    }
                    break;
                case 124 :
                    // InternalPerl.g:1337:2: ( 'pos' )
                    {
                    // InternalPerl.g:1337:2: ( 'pos' )
                    // InternalPerl.g:1338:3: 'pos'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getPosKeyword_123()); 
                    }
                    match(input,148,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getPosKeyword_123()); 
                    }

                    }


                    }
                    break;
                case 125 :
                    // InternalPerl.g:1343:2: ( 'print' )
                    {
                    // InternalPerl.g:1343:2: ( 'print' )
                    // InternalPerl.g:1344:3: 'print'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 
                    }
                    match(input,149,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 
                    }

                    }


                    }
                    break;
                case 126 :
                    // InternalPerl.g:1349:2: ( 'printf' )
                    {
                    // InternalPerl.g:1349:2: ( 'printf' )
                    // InternalPerl.g:1350:3: 'printf'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 
                    }
                    match(input,150,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 
                    }

                    }


                    }
                    break;
                case 127 :
                    // InternalPerl.g:1355:2: ( 'prototype' )
                    {
                    // InternalPerl.g:1355:2: ( 'prototype' )
                    // InternalPerl.g:1356:3: 'prototype'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 
                    }
                    match(input,151,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 
                    }

                    }


                    }
                    break;
                case 128 :
                    // InternalPerl.g:1361:2: ( 'push' )
                    {
                    // InternalPerl.g:1361:2: ( 'push' )
                    // InternalPerl.g:1362:3: 'push'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getPushKeyword_127()); 
                    }
                    match(input,152,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getPushKeyword_127()); 
                    }

                    }


                    }
                    break;
                case 129 :
                    // InternalPerl.g:1367:2: ( 'quotemeta' )
                    {
                    // InternalPerl.g:1367:2: ( 'quotemeta' )
                    // InternalPerl.g:1368:3: 'quotemeta'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 
                    }
                    match(input,153,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 
                    }

                    }


                    }
                    break;
                case 130 :
                    // InternalPerl.g:1373:2: ( 'rand' )
                    {
                    // InternalPerl.g:1373:2: ( 'rand' )
                    // InternalPerl.g:1374:3: 'rand'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getRandKeyword_129()); 
                    }
                    match(input,154,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getRandKeyword_129()); 
                    }

                    }


                    }
                    break;
                case 131 :
                    // InternalPerl.g:1379:2: ( 'read' )
                    {
                    // InternalPerl.g:1379:2: ( 'read' )
                    // InternalPerl.g:1380:3: 'read'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getReadKeyword_130()); 
                    }
                    match(input,155,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getReadKeyword_130()); 
                    }

                    }


                    }
                    break;
                case 132 :
                    // InternalPerl.g:1385:2: ( 'readdir' )
                    {
                    // InternalPerl.g:1385:2: ( 'readdir' )
                    // InternalPerl.g:1386:3: 'readdir'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 
                    }
                    match(input,156,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 
                    }

                    }


                    }
                    break;
                case 133 :
                    // InternalPerl.g:1391:2: ( 'readline' )
                    {
                    // InternalPerl.g:1391:2: ( 'readline' )
                    // InternalPerl.g:1392:3: 'readline'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 
                    }
                    match(input,157,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 
                    }

                    }


                    }
                    break;
                case 134 :
                    // InternalPerl.g:1397:2: ( 'readlink' )
                    {
                    // InternalPerl.g:1397:2: ( 'readlink' )
                    // InternalPerl.g:1398:3: 'readlink'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 
                    }
                    match(input,158,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 
                    }

                    }


                    }
                    break;
                case 135 :
                    // InternalPerl.g:1403:2: ( 'readpipe' )
                    {
                    // InternalPerl.g:1403:2: ( 'readpipe' )
                    // InternalPerl.g:1404:3: 'readpipe'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 
                    }
                    match(input,159,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 
                    }

                    }


                    }
                    break;
                case 136 :
                    // InternalPerl.g:1409:2: ( 'recv' )
                    {
                    // InternalPerl.g:1409:2: ( 'recv' )
                    // InternalPerl.g:1410:3: 'recv'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 
                    }
                    match(input,160,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 
                    }

                    }


                    }
                    break;
                case 137 :
                    // InternalPerl.g:1415:2: ( 'redo' )
                    {
                    // InternalPerl.g:1415:2: ( 'redo' )
                    // InternalPerl.g:1416:3: 'redo'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 
                    }
                    match(input,161,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 
                    }

                    }


                    }
                    break;
                case 138 :
                    // InternalPerl.g:1421:2: ( 'ref' )
                    {
                    // InternalPerl.g:1421:2: ( 'ref' )
                    // InternalPerl.g:1422:3: 'ref'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getRefKeyword_137()); 
                    }
                    match(input,162,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getRefKeyword_137()); 
                    }

                    }


                    }
                    break;
                case 139 :
                    // InternalPerl.g:1427:2: ( 'rename' )
                    {
                    // InternalPerl.g:1427:2: ( 'rename' )
                    // InternalPerl.g:1428:3: 'rename'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 
                    }
                    match(input,163,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 
                    }

                    }


                    }
                    break;
                case 140 :
                    // InternalPerl.g:1433:2: ( 'require' )
                    {
                    // InternalPerl.g:1433:2: ( 'require' )
                    // InternalPerl.g:1434:3: 'require'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 
                    }
                    match(input,164,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 
                    }

                    }


                    }
                    break;
                case 141 :
                    // InternalPerl.g:1439:2: ( 'reset' )
                    {
                    // InternalPerl.g:1439:2: ( 'reset' )
                    // InternalPerl.g:1440:3: 'reset'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getResetKeyword_140()); 
                    }
                    match(input,165,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getResetKeyword_140()); 
                    }

                    }


                    }
                    break;
                case 142 :
                    // InternalPerl.g:1445:2: ( 'return' )
                    {
                    // InternalPerl.g:1445:2: ( 'return' )
                    // InternalPerl.g:1446:3: 'return'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 
                    }
                    match(input,166,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 
                    }

                    }


                    }
                    break;
                case 143 :
                    // InternalPerl.g:1451:2: ( 'reverse' )
                    {
                    // InternalPerl.g:1451:2: ( 'reverse' )
                    // InternalPerl.g:1452:3: 'reverse'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 
                    }
                    match(input,167,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 
                    }

                    }


                    }
                    break;
                case 144 :
                    // InternalPerl.g:1457:2: ( 'rewinddir' )
                    {
                    // InternalPerl.g:1457:2: ( 'rewinddir' )
                    // InternalPerl.g:1458:3: 'rewinddir'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 
                    }
                    match(input,168,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 
                    }

                    }


                    }
                    break;
                case 145 :
                    // InternalPerl.g:1463:2: ( 'rindex' )
                    {
                    // InternalPerl.g:1463:2: ( 'rindex' )
                    // InternalPerl.g:1464:3: 'rindex'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 
                    }
                    match(input,169,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 
                    }

                    }


                    }
                    break;
                case 146 :
                    // InternalPerl.g:1469:2: ( 'rmdir' )
                    {
                    // InternalPerl.g:1469:2: ( 'rmdir' )
                    // InternalPerl.g:1470:3: 'rmdir'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 
                    }
                    match(input,170,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 
                    }

                    }


                    }
                    break;
                case 147 :
                    // InternalPerl.g:1475:2: ( 'say' )
                    {
                    // InternalPerl.g:1475:2: ( 'say' )
                    // InternalPerl.g:1476:3: 'say'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSayKeyword_146()); 
                    }
                    match(input,171,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSayKeyword_146()); 
                    }

                    }


                    }
                    break;
                case 148 :
                    // InternalPerl.g:1481:2: ( 'scalar' )
                    {
                    // InternalPerl.g:1481:2: ( 'scalar' )
                    // InternalPerl.g:1482:3: 'scalar'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 
                    }
                    match(input,172,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 
                    }

                    }


                    }
                    break;
                case 149 :
                    // InternalPerl.g:1487:2: ( 'seek' )
                    {
                    // InternalPerl.g:1487:2: ( 'seek' )
                    // InternalPerl.g:1488:3: 'seek'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 
                    }
                    match(input,173,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 
                    }

                    }


                    }
                    break;
                case 150 :
                    // InternalPerl.g:1493:2: ( 'seekdir' )
                    {
                    // InternalPerl.g:1493:2: ( 'seekdir' )
                    // InternalPerl.g:1494:3: 'seekdir'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 
                    }
                    match(input,174,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 
                    }

                    }


                    }
                    break;
                case 151 :
                    // InternalPerl.g:1499:2: ( 'select' )
                    {
                    // InternalPerl.g:1499:2: ( 'select' )
                    // InternalPerl.g:1500:3: 'select'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 
                    }
                    match(input,175,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 
                    }

                    }


                    }
                    break;
                case 152 :
                    // InternalPerl.g:1505:2: ( 'semctl' )
                    {
                    // InternalPerl.g:1505:2: ( 'semctl' )
                    // InternalPerl.g:1506:3: 'semctl'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 
                    }
                    match(input,176,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 
                    }

                    }


                    }
                    break;
                case 153 :
                    // InternalPerl.g:1511:2: ( 'semget' )
                    {
                    // InternalPerl.g:1511:2: ( 'semget' )
                    // InternalPerl.g:1512:3: 'semget'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 
                    }
                    match(input,177,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 
                    }

                    }


                    }
                    break;
                case 154 :
                    // InternalPerl.g:1517:2: ( 'semop' )
                    {
                    // InternalPerl.g:1517:2: ( 'semop' )
                    // InternalPerl.g:1518:3: 'semop'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 
                    }
                    match(input,178,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 
                    }

                    }


                    }
                    break;
                case 155 :
                    // InternalPerl.g:1523:2: ( 'send' )
                    {
                    // InternalPerl.g:1523:2: ( 'send' )
                    // InternalPerl.g:1524:3: 'send'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSendKeyword_154()); 
                    }
                    match(input,179,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSendKeyword_154()); 
                    }

                    }


                    }
                    break;
                case 156 :
                    // InternalPerl.g:1529:2: ( 'setgrent' )
                    {
                    // InternalPerl.g:1529:2: ( 'setgrent' )
                    // InternalPerl.g:1530:3: 'setgrent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 
                    }
                    match(input,180,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 
                    }

                    }


                    }
                    break;
                case 157 :
                    // InternalPerl.g:1535:2: ( 'sethostent' )
                    {
                    // InternalPerl.g:1535:2: ( 'sethostent' )
                    // InternalPerl.g:1536:3: 'sethostent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 
                    }
                    match(input,181,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 
                    }

                    }


                    }
                    break;
                case 158 :
                    // InternalPerl.g:1541:2: ( 'setnetent' )
                    {
                    // InternalPerl.g:1541:2: ( 'setnetent' )
                    // InternalPerl.g:1542:3: 'setnetent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 
                    }
                    match(input,182,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 
                    }

                    }


                    }
                    break;
                case 159 :
                    // InternalPerl.g:1547:2: ( 'setpgrp' )
                    {
                    // InternalPerl.g:1547:2: ( 'setpgrp' )
                    // InternalPerl.g:1548:3: 'setpgrp'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 
                    }
                    match(input,183,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 
                    }

                    }


                    }
                    break;
                case 160 :
                    // InternalPerl.g:1553:2: ( 'setpriority' )
                    {
                    // InternalPerl.g:1553:2: ( 'setpriority' )
                    // InternalPerl.g:1554:3: 'setpriority'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 
                    }
                    match(input,184,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 
                    }

                    }


                    }
                    break;
                case 161 :
                    // InternalPerl.g:1559:2: ( 'setprotoent' )
                    {
                    // InternalPerl.g:1559:2: ( 'setprotoent' )
                    // InternalPerl.g:1560:3: 'setprotoent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 
                    }
                    match(input,185,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 
                    }

                    }


                    }
                    break;
                case 162 :
                    // InternalPerl.g:1565:2: ( 'setpwent' )
                    {
                    // InternalPerl.g:1565:2: ( 'setpwent' )
                    // InternalPerl.g:1566:3: 'setpwent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 
                    }
                    match(input,186,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 
                    }

                    }


                    }
                    break;
                case 163 :
                    // InternalPerl.g:1571:2: ( 'setservent' )
                    {
                    // InternalPerl.g:1571:2: ( 'setservent' )
                    // InternalPerl.g:1572:3: 'setservent'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 
                    }
                    match(input,187,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 
                    }

                    }


                    }
                    break;
                case 164 :
                    // InternalPerl.g:1577:2: ( 'setsockopt' )
                    {
                    // InternalPerl.g:1577:2: ( 'setsockopt' )
                    // InternalPerl.g:1578:3: 'setsockopt'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 
                    }
                    match(input,188,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 
                    }

                    }


                    }
                    break;
                case 165 :
                    // InternalPerl.g:1583:2: ( 'shift' )
                    {
                    // InternalPerl.g:1583:2: ( 'shift' )
                    // InternalPerl.g:1584:3: 'shift'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 
                    }
                    match(input,189,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 
                    }

                    }


                    }
                    break;
                case 166 :
                    // InternalPerl.g:1589:2: ( 'shmctl' )
                    {
                    // InternalPerl.g:1589:2: ( 'shmctl' )
                    // InternalPerl.g:1590:3: 'shmctl'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 
                    }
                    match(input,190,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 
                    }

                    }


                    }
                    break;
                case 167 :
                    // InternalPerl.g:1595:2: ( 'shmget' )
                    {
                    // InternalPerl.g:1595:2: ( 'shmget' )
                    // InternalPerl.g:1596:3: 'shmget'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 
                    }
                    match(input,191,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 
                    }

                    }


                    }
                    break;
                case 168 :
                    // InternalPerl.g:1601:2: ( 'shmread' )
                    {
                    // InternalPerl.g:1601:2: ( 'shmread' )
                    // InternalPerl.g:1602:3: 'shmread'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 
                    }
                    match(input,192,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 
                    }

                    }


                    }
                    break;
                case 169 :
                    // InternalPerl.g:1607:2: ( 'shmwrite' )
                    {
                    // InternalPerl.g:1607:2: ( 'shmwrite' )
                    // InternalPerl.g:1608:3: 'shmwrite'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 
                    }
                    match(input,193,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 
                    }

                    }


                    }
                    break;
                case 170 :
                    // InternalPerl.g:1613:2: ( 'shutdown' )
                    {
                    // InternalPerl.g:1613:2: ( 'shutdown' )
                    // InternalPerl.g:1614:3: 'shutdown'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 
                    }
                    match(input,194,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 
                    }

                    }


                    }
                    break;
                case 171 :
                    // InternalPerl.g:1619:2: ( 'sin' )
                    {
                    // InternalPerl.g:1619:2: ( 'sin' )
                    // InternalPerl.g:1620:3: 'sin'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSinKeyword_170()); 
                    }
                    match(input,195,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSinKeyword_170()); 
                    }

                    }


                    }
                    break;
                case 172 :
                    // InternalPerl.g:1625:2: ( 'sleep' )
                    {
                    // InternalPerl.g:1625:2: ( 'sleep' )
                    // InternalPerl.g:1626:3: 'sleep'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 
                    }
                    match(input,196,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 
                    }

                    }


                    }
                    break;
                case 173 :
                    // InternalPerl.g:1631:2: ( 'socket' )
                    {
                    // InternalPerl.g:1631:2: ( 'socket' )
                    // InternalPerl.g:1632:3: 'socket'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 
                    }
                    match(input,197,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 
                    }

                    }


                    }
                    break;
                case 174 :
                    // InternalPerl.g:1637:2: ( 'socketpair' )
                    {
                    // InternalPerl.g:1637:2: ( 'socketpair' )
                    // InternalPerl.g:1638:3: 'socketpair'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 
                    }
                    match(input,198,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 
                    }

                    }


                    }
                    break;
                case 175 :
                    // InternalPerl.g:1643:2: ( 'sort' )
                    {
                    // InternalPerl.g:1643:2: ( 'sort' )
                    // InternalPerl.g:1644:3: 'sort'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSortKeyword_174()); 
                    }
                    match(input,199,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSortKeyword_174()); 
                    }

                    }


                    }
                    break;
                case 176 :
                    // InternalPerl.g:1649:2: ( 'splice' )
                    {
                    // InternalPerl.g:1649:2: ( 'splice' )
                    // InternalPerl.g:1650:3: 'splice'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 
                    }
                    match(input,200,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 
                    }

                    }


                    }
                    break;
                case 177 :
                    // InternalPerl.g:1655:2: ( 'split' )
                    {
                    // InternalPerl.g:1655:2: ( 'split' )
                    // InternalPerl.g:1656:3: 'split'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 
                    }
                    match(input,201,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 
                    }

                    }


                    }
                    break;
                case 178 :
                    // InternalPerl.g:1661:2: ( 'sprintf' )
                    {
                    // InternalPerl.g:1661:2: ( 'sprintf' )
                    // InternalPerl.g:1662:3: 'sprintf'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 
                    }
                    match(input,202,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 
                    }

                    }


                    }
                    break;
                case 179 :
                    // InternalPerl.g:1667:2: ( 'sqrt' )
                    {
                    // InternalPerl.g:1667:2: ( 'sqrt' )
                    // InternalPerl.g:1668:3: 'sqrt'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 
                    }
                    match(input,203,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 
                    }

                    }


                    }
                    break;
                case 180 :
                    // InternalPerl.g:1673:2: ( 'srand' )
                    {
                    // InternalPerl.g:1673:2: ( 'srand' )
                    // InternalPerl.g:1674:3: 'srand'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 
                    }
                    match(input,204,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 
                    }

                    }


                    }
                    break;
                case 181 :
                    // InternalPerl.g:1679:2: ( 'stat' )
                    {
                    // InternalPerl.g:1679:2: ( 'stat' )
                    // InternalPerl.g:1680:3: 'stat'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getStatKeyword_180()); 
                    }
                    match(input,205,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getStatKeyword_180()); 
                    }

                    }


                    }
                    break;
                case 182 :
                    // InternalPerl.g:1685:2: ( 'state' )
                    {
                    // InternalPerl.g:1685:2: ( 'state' )
                    // InternalPerl.g:1686:3: 'state'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getStateKeyword_181()); 
                    }
                    match(input,206,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getStateKeyword_181()); 
                    }

                    }


                    }
                    break;
                case 183 :
                    // InternalPerl.g:1691:2: ( 'study' )
                    {
                    // InternalPerl.g:1691:2: ( 'study' )
                    // InternalPerl.g:1692:3: 'study'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 
                    }
                    match(input,207,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 
                    }

                    }


                    }
                    break;
                case 184 :
                    // InternalPerl.g:1697:2: ( 'sub' )
                    {
                    // InternalPerl.g:1697:2: ( 'sub' )
                    // InternalPerl.g:1698:3: 'sub'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSubKeyword_183()); 
                    }
                    match(input,208,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSubKeyword_183()); 
                    }

                    }


                    }
                    break;
                case 185 :
                    // InternalPerl.g:1703:2: ( 'substr' )
                    {
                    // InternalPerl.g:1703:2: ( 'substr' )
                    // InternalPerl.g:1704:3: 'substr'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 
                    }
                    match(input,209,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 
                    }

                    }


                    }
                    break;
                case 186 :
                    // InternalPerl.g:1709:2: ( 'symlink' )
                    {
                    // InternalPerl.g:1709:2: ( 'symlink' )
                    // InternalPerl.g:1710:3: 'symlink'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 
                    }
                    match(input,210,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 
                    }

                    }


                    }
                    break;
                case 187 :
                    // InternalPerl.g:1715:2: ( 'syscall' )
                    {
                    // InternalPerl.g:1715:2: ( 'syscall' )
                    // InternalPerl.g:1716:3: 'syscall'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 
                    }
                    match(input,211,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 
                    }

                    }


                    }
                    break;
                case 188 :
                    // InternalPerl.g:1721:2: ( 'sysopen' )
                    {
                    // InternalPerl.g:1721:2: ( 'sysopen' )
                    // InternalPerl.g:1722:3: 'sysopen'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 
                    }
                    match(input,212,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 
                    }

                    }


                    }
                    break;
                case 189 :
                    // InternalPerl.g:1727:2: ( 'sysread' )
                    {
                    // InternalPerl.g:1727:2: ( 'sysread' )
                    // InternalPerl.g:1728:3: 'sysread'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 
                    }
                    match(input,213,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 
                    }

                    }


                    }
                    break;
                case 190 :
                    // InternalPerl.g:1733:2: ( 'sysseek' )
                    {
                    // InternalPerl.g:1733:2: ( 'sysseek' )
                    // InternalPerl.g:1734:3: 'sysseek'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 
                    }
                    match(input,214,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 
                    }

                    }


                    }
                    break;
                case 191 :
                    // InternalPerl.g:1739:2: ( 'system' )
                    {
                    // InternalPerl.g:1739:2: ( 'system' )
                    // InternalPerl.g:1740:3: 'system'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 
                    }
                    match(input,215,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 
                    }

                    }


                    }
                    break;
                case 192 :
                    // InternalPerl.g:1745:2: ( 'syswrite' )
                    {
                    // InternalPerl.g:1745:2: ( 'syswrite' )
                    // InternalPerl.g:1746:3: 'syswrite'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 
                    }
                    match(input,216,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 
                    }

                    }


                    }
                    break;
                case 193 :
                    // InternalPerl.g:1751:2: ( 'tell' )
                    {
                    // InternalPerl.g:1751:2: ( 'tell' )
                    // InternalPerl.g:1752:3: 'tell'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getTellKeyword_192()); 
                    }
                    match(input,217,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getTellKeyword_192()); 
                    }

                    }


                    }
                    break;
                case 194 :
                    // InternalPerl.g:1757:2: ( 'telldir' )
                    {
                    // InternalPerl.g:1757:2: ( 'telldir' )
                    // InternalPerl.g:1758:3: 'telldir'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 
                    }
                    match(input,218,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 
                    }

                    }


                    }
                    break;
                case 195 :
                    // InternalPerl.g:1763:2: ( 'tie' )
                    {
                    // InternalPerl.g:1763:2: ( 'tie' )
                    // InternalPerl.g:1764:3: 'tie'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getTieKeyword_194()); 
                    }
                    match(input,219,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getTieKeyword_194()); 
                    }

                    }


                    }
                    break;
                case 196 :
                    // InternalPerl.g:1769:2: ( 'tied' )
                    {
                    // InternalPerl.g:1769:2: ( 'tied' )
                    // InternalPerl.g:1770:3: 'tied'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 
                    }
                    match(input,220,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 
                    }

                    }


                    }
                    break;
                case 197 :
                    // InternalPerl.g:1775:2: ( 'time' )
                    {
                    // InternalPerl.g:1775:2: ( 'time' )
                    // InternalPerl.g:1776:3: 'time'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 
                    }
                    match(input,221,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 
                    }

                    }


                    }
                    break;
                case 198 :
                    // InternalPerl.g:1781:2: ( 'times' )
                    {
                    // InternalPerl.g:1781:2: ( 'times' )
                    // InternalPerl.g:1782:3: 'times'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 
                    }
                    match(input,222,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 
                    }

                    }


                    }
                    break;
                case 199 :
                    // InternalPerl.g:1787:2: ( 'tr' )
                    {
                    // InternalPerl.g:1787:2: ( 'tr' )
                    // InternalPerl.g:1788:3: 'tr'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getTrKeyword_198()); 
                    }
                    match(input,223,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getTrKeyword_198()); 
                    }

                    }


                    }
                    break;
                case 200 :
                    // InternalPerl.g:1793:2: ( 'truncate' )
                    {
                    // InternalPerl.g:1793:2: ( 'truncate' )
                    // InternalPerl.g:1794:3: 'truncate'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 
                    }
                    match(input,224,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 
                    }

                    }


                    }
                    break;
                case 201 :
                    // InternalPerl.g:1799:2: ( 'uc' )
                    {
                    // InternalPerl.g:1799:2: ( 'uc' )
                    // InternalPerl.g:1800:3: 'uc'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUcKeyword_200()); 
                    }
                    match(input,225,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUcKeyword_200()); 
                    }

                    }


                    }
                    break;
                case 202 :
                    // InternalPerl.g:1805:2: ( 'ucfirst' )
                    {
                    // InternalPerl.g:1805:2: ( 'ucfirst' )
                    // InternalPerl.g:1806:3: 'ucfirst'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 
                    }
                    match(input,226,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 
                    }

                    }


                    }
                    break;
                case 203 :
                    // InternalPerl.g:1811:2: ( 'umask' )
                    {
                    // InternalPerl.g:1811:2: ( 'umask' )
                    // InternalPerl.g:1812:3: 'umask'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 
                    }
                    match(input,227,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 
                    }

                    }


                    }
                    break;
                case 204 :
                    // InternalPerl.g:1817:2: ( 'undef' )
                    {
                    // InternalPerl.g:1817:2: ( 'undef' )
                    // InternalPerl.g:1818:3: 'undef'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 
                    }
                    match(input,228,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 
                    }

                    }


                    }
                    break;
                case 205 :
                    // InternalPerl.g:1823:2: ( 'unless' )
                    {
                    // InternalPerl.g:1823:2: ( 'unless' )
                    // InternalPerl.g:1824:3: 'unless'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 
                    }
                    match(input,229,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 
                    }

                    }


                    }
                    break;
                case 206 :
                    // InternalPerl.g:1829:2: ( 'unlink' )
                    {
                    // InternalPerl.g:1829:2: ( 'unlink' )
                    // InternalPerl.g:1830:3: 'unlink'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 
                    }
                    match(input,230,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 
                    }

                    }


                    }
                    break;
                case 207 :
                    // InternalPerl.g:1835:2: ( 'unpack' )
                    {
                    // InternalPerl.g:1835:2: ( 'unpack' )
                    // InternalPerl.g:1836:3: 'unpack'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 
                    }
                    match(input,231,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 
                    }

                    }


                    }
                    break;
                case 208 :
                    // InternalPerl.g:1841:2: ( 'unshift' )
                    {
                    // InternalPerl.g:1841:2: ( 'unshift' )
                    // InternalPerl.g:1842:3: 'unshift'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 
                    }
                    match(input,232,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 
                    }

                    }


                    }
                    break;
                case 209 :
                    // InternalPerl.g:1847:2: ( 'untie' )
                    {
                    // InternalPerl.g:1847:2: ( 'untie' )
                    // InternalPerl.g:1848:3: 'untie'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 
                    }
                    match(input,233,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 
                    }

                    }


                    }
                    break;
                case 210 :
                    // InternalPerl.g:1853:2: ( 'until' )
                    {
                    // InternalPerl.g:1853:2: ( 'until' )
                    // InternalPerl.g:1854:3: 'until'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 
                    }
                    match(input,234,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 
                    }

                    }


                    }
                    break;
                case 211 :
                    // InternalPerl.g:1859:2: ( 'use' )
                    {
                    // InternalPerl.g:1859:2: ( 'use' )
                    // InternalPerl.g:1860:3: 'use'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUseKeyword_210()); 
                    }
                    match(input,235,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUseKeyword_210()); 
                    }

                    }


                    }
                    break;
                case 212 :
                    // InternalPerl.g:1865:2: ( 'utime' )
                    {
                    // InternalPerl.g:1865:2: ( 'utime' )
                    // InternalPerl.g:1866:3: 'utime'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 
                    }
                    match(input,236,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 
                    }

                    }


                    }
                    break;
                case 213 :
                    // InternalPerl.g:1871:2: ( 'values' )
                    {
                    // InternalPerl.g:1871:2: ( 'values' )
                    // InternalPerl.g:1872:3: 'values'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 
                    }
                    match(input,237,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 
                    }

                    }


                    }
                    break;
                case 214 :
                    // InternalPerl.g:1877:2: ( 'vec' )
                    {
                    // InternalPerl.g:1877:2: ( 'vec' )
                    // InternalPerl.g:1878:3: 'vec'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getVecKeyword_213()); 
                    }
                    match(input,238,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getVecKeyword_213()); 
                    }

                    }


                    }
                    break;
                case 215 :
                    // InternalPerl.g:1883:2: ( 'wait' )
                    {
                    // InternalPerl.g:1883:2: ( 'wait' )
                    // InternalPerl.g:1884:3: 'wait'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 
                    }
                    match(input,239,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 
                    }

                    }


                    }
                    break;
                case 216 :
                    // InternalPerl.g:1889:2: ( 'waitpid' )
                    {
                    // InternalPerl.g:1889:2: ( 'waitpid' )
                    // InternalPerl.g:1890:3: 'waitpid'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 
                    }
                    match(input,240,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 
                    }

                    }


                    }
                    break;
                case 217 :
                    // InternalPerl.g:1895:2: ( 'wantarray' )
                    {
                    // InternalPerl.g:1895:2: ( 'wantarray' )
                    // InternalPerl.g:1896:3: 'wantarray'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 
                    }
                    match(input,241,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 
                    }

                    }


                    }
                    break;
                case 218 :
                    // InternalPerl.g:1901:2: ( 'warn' )
                    {
                    // InternalPerl.g:1901:2: ( 'warn' )
                    // InternalPerl.g:1902:3: 'warn'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 
                    }
                    match(input,242,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 
                    }

                    }


                    }
                    break;
                case 219 :
                    // InternalPerl.g:1907:2: ( 'when' )
                    {
                    // InternalPerl.g:1907:2: ( 'when' )
                    // InternalPerl.g:1908:3: 'when'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 
                    }
                    match(input,243,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 
                    }

                    }


                    }
                    break;
                case 220 :
                    // InternalPerl.g:1913:2: ( 'while' )
                    {
                    // InternalPerl.g:1913:2: ( 'while' )
                    // InternalPerl.g:1914:3: 'while'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 
                    }
                    match(input,244,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 
                    }

                    }


                    }
                    break;
                case 221 :
                    // InternalPerl.g:1919:2: ( 'write' )
                    {
                    // InternalPerl.g:1919:2: ( 'write' )
                    // InternalPerl.g:1920:3: 'write'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 
                    }
                    match(input,245,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 
                    }

                    }


                    }
                    break;
                case 222 :
                    // InternalPerl.g:1925:2: ( 'y' )
                    {
                    // InternalPerl.g:1925:2: ( 'y' )
                    // InternalPerl.g:1926:3: 'y'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getKeywordAccess().getYKeyword_221()); 
                    }
                    match(input,246,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getKeywordAccess().getYKeyword_221()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__Alternatives"


    // $ANTLR start "rule__Operator__Alternatives"
    // InternalPerl.g:1935:1: rule__Operator__Alternatives : ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1939:1: ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) )
            int alt7=64;
            switch ( input.LA(1) ) {
            case 247:
                {
                alt7=1;
                }
                break;
            case 248:
                {
                alt7=2;
                }
                break;
            case 249:
                {
                alt7=3;
                }
                break;
            case 250:
                {
                alt7=4;
                }
                break;
            case 251:
                {
                alt7=5;
                }
                break;
            case 252:
                {
                alt7=6;
                }
                break;
            case 253:
                {
                alt7=7;
                }
                break;
            case 254:
                {
                alt7=8;
                }
                break;
            case 255:
                {
                alt7=9;
                }
                break;
            case 256:
                {
                alt7=10;
                }
                break;
            case 257:
                {
                alt7=11;
                }
                break;
            case 258:
                {
                alt7=12;
                }
                break;
            case 259:
                {
                alt7=13;
                }
                break;
            case 260:
                {
                alt7=14;
                }
                break;
            case 261:
                {
                alt7=15;
                }
                break;
            case 262:
                {
                alt7=16;
                }
                break;
            case 263:
                {
                alt7=17;
                }
                break;
            case 264:
                {
                alt7=18;
                }
                break;
            case 265:
                {
                alt7=19;
                }
                break;
            case 266:
                {
                alt7=20;
                }
                break;
            case 267:
                {
                alt7=21;
                }
                break;
            case 268:
                {
                alt7=22;
                }
                break;
            case 269:
                {
                alt7=23;
                }
                break;
            case 337:
                {
                alt7=24;
                }
                break;
            case 270:
                {
                alt7=25;
                }
                break;
            case 271:
                {
                alt7=26;
                }
                break;
            case 272:
                {
                alt7=27;
                }
                break;
            case 273:
                {
                alt7=28;
                }
                break;
            case 274:
                {
                alt7=29;
                }
                break;
            case 275:
                {
                alt7=30;
                }
                break;
            case 276:
                {
                alt7=31;
                }
                break;
            case 277:
                {
                alt7=32;
                }
                break;
            case 278:
                {
                alt7=33;
                }
                break;
            case 279:
                {
                alt7=34;
                }
                break;
            case 280:
                {
                alt7=35;
                }
                break;
            case 281:
                {
                alt7=36;
                }
                break;
            case 282:
                {
                alt7=37;
                }
                break;
            case 283:
                {
                alt7=38;
                }
                break;
            case 284:
                {
                alt7=39;
                }
                break;
            case 285:
                {
                alt7=40;
                }
                break;
            case 286:
                {
                alt7=41;
                }
                break;
            case 287:
                {
                alt7=42;
                }
                break;
            case 288:
                {
                alt7=43;
                }
                break;
            case 289:
                {
                alt7=44;
                }
                break;
            case 290:
                {
                alt7=45;
                }
                break;
            case 291:
                {
                alt7=46;
                }
                break;
            case 292:
                {
                alt7=47;
                }
                break;
            case 293:
                {
                alt7=48;
                }
                break;
            case 294:
                {
                alt7=49;
                }
                break;
            case 295:
                {
                alt7=50;
                }
                break;
            case 296:
                {
                alt7=51;
                }
                break;
            case 297:
                {
                alt7=52;
                }
                break;
            case 298:
                {
                alt7=53;
                }
                break;
            case 299:
                {
                alt7=54;
                }
                break;
            case 300:
                {
                alt7=55;
                }
                break;
            case 301:
                {
                alt7=56;
                }
                break;
            case 302:
                {
                alt7=57;
                }
                break;
            case 303:
                {
                alt7=58;
                }
                break;
            case 304:
                {
                alt7=59;
                }
                break;
            case 305:
                {
                alt7=60;
                }
                break;
            case 306:
                {
                alt7=61;
                }
                break;
            case 307:
                {
                alt7=62;
                }
                break;
            case 308:
                {
                alt7=63;
                }
                break;
            case 309:
                {
                alt7=64;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalPerl.g:1940:2: ( '++' )
                    {
                    // InternalPerl.g:1940:2: ( '++' )
                    // InternalPerl.g:1941:3: '++'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 
                    }
                    match(input,247,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1946:2: ( '--' )
                    {
                    // InternalPerl.g:1946:2: ( '--' )
                    // InternalPerl.g:1947:3: '--'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    }
                    match(input,248,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1952:2: ( '**' )
                    {
                    // InternalPerl.g:1952:2: ( '**' )
                    // InternalPerl.g:1953:3: '**'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 
                    }
                    match(input,249,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1958:2: ( '!' )
                    {
                    // InternalPerl.g:1958:2: ( '!' )
                    // InternalPerl.g:1959:3: '!'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 
                    }
                    match(input,250,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:1964:2: ( '~' )
                    {
                    // InternalPerl.g:1964:2: ( '~' )
                    // InternalPerl.g:1965:3: '~'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 
                    }
                    match(input,251,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:1970:2: ( '+' )
                    {
                    // InternalPerl.g:1970:2: ( '+' )
                    // InternalPerl.g:1971:3: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 
                    }
                    match(input,252,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:1976:2: ( '-' )
                    {
                    // InternalPerl.g:1976:2: ( '-' )
                    // InternalPerl.g:1977:3: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 
                    }
                    match(input,253,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:1982:2: ( '=~' )
                    {
                    // InternalPerl.g:1982:2: ( '=~' )
                    // InternalPerl.g:1983:3: '=~'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 
                    }
                    match(input,254,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:1988:2: ( '!~' )
                    {
                    // InternalPerl.g:1988:2: ( '!~' )
                    // InternalPerl.g:1989:3: '!~'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 
                    }
                    match(input,255,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:1994:2: ( '*' )
                    {
                    // InternalPerl.g:1994:2: ( '*' )
                    // InternalPerl.g:1995:3: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 
                    }
                    match(input,256,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2000:2: ( '/' )
                    {
                    // InternalPerl.g:2000:2: ( '/' )
                    // InternalPerl.g:2001:3: '/'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 
                    }
                    match(input,257,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2006:2: ( '%' )
                    {
                    // InternalPerl.g:2006:2: ( '%' )
                    // InternalPerl.g:2007:3: '%'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 
                    }
                    match(input,258,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2012:2: ( 'x' )
                    {
                    // InternalPerl.g:2012:2: ( 'x' )
                    // InternalPerl.g:2013:3: 'x'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getXKeyword_12()); 
                    }
                    match(input,259,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getXKeyword_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2018:2: ( '<<' )
                    {
                    // InternalPerl.g:2018:2: ( '<<' )
                    // InternalPerl.g:2019:3: '<<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 
                    }
                    match(input,260,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2024:2: ( '>>' )
                    {
                    // InternalPerl.g:2024:2: ( '>>' )
                    // InternalPerl.g:2025:3: '>>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 
                    }
                    match(input,261,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2030:2: ( 'lt' )
                    {
                    // InternalPerl.g:2030:2: ( 'lt' )
                    // InternalPerl.g:2031:3: 'lt'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getLtKeyword_15()); 
                    }
                    match(input,262,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getLtKeyword_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2036:2: ( 'gt' )
                    {
                    // InternalPerl.g:2036:2: ( 'gt' )
                    // InternalPerl.g:2037:3: 'gt'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getGtKeyword_16()); 
                    }
                    match(input,263,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getGtKeyword_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2042:2: ( 'le' )
                    {
                    // InternalPerl.g:2042:2: ( 'le' )
                    // InternalPerl.g:2043:3: 'le'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getLeKeyword_17()); 
                    }
                    match(input,264,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getLeKeyword_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2048:2: ( 'ge' )
                    {
                    // InternalPerl.g:2048:2: ( 'ge' )
                    // InternalPerl.g:2049:3: 'ge'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getGeKeyword_18()); 
                    }
                    match(input,265,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getGeKeyword_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2054:2: ( 'cmp' )
                    {
                    // InternalPerl.g:2054:2: ( 'cmp' )
                    // InternalPerl.g:2055:3: 'cmp'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 
                    }
                    match(input,266,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2060:2: ( '~~' )
                    {
                    // InternalPerl.g:2060:2: ( '~~' )
                    // InternalPerl.g:2061:3: '~~'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 
                    }
                    match(input,267,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2066:2: ( '==' )
                    {
                    // InternalPerl.g:2066:2: ( '==' )
                    // InternalPerl.g:2067:3: '=='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 
                    }
                    match(input,268,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2072:2: ( '!=' )
                    {
                    // InternalPerl.g:2072:2: ( '!=' )
                    // InternalPerl.g:2073:3: '!='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 
                    }
                    match(input,269,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2078:2: ( ( rule__Operator__Group_23__0 ) )
                    {
                    // InternalPerl.g:2078:2: ( ( rule__Operator__Group_23__0 ) )
                    // InternalPerl.g:2079:3: ( rule__Operator__Group_23__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getGroup_23()); 
                    }
                    // InternalPerl.g:2080:3: ( rule__Operator__Group_23__0 )
                    // InternalPerl.g:2080:4: rule__Operator__Group_23__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operator__Group_23__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getGroup_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:2084:2: ( '..' )
                    {
                    // InternalPerl.g:2084:2: ( '..' )
                    // InternalPerl.g:2085:3: '..'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 
                    }
                    match(input,270,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2090:2: ( '...' )
                    {
                    // InternalPerl.g:2090:2: ( '...' )
                    // InternalPerl.g:2091:3: '...'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 
                    }
                    match(input,271,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2096:2: ( ',' )
                    {
                    // InternalPerl.g:2096:2: ( ',' )
                    // InternalPerl.g:2097:3: ','
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 
                    }
                    match(input,272,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 
                    }

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:2102:2: ( '&' )
                    {
                    // InternalPerl.g:2102:2: ( '&' )
                    // InternalPerl.g:2103:3: '&'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 
                    }
                    match(input,273,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 
                    }

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:2108:2: ( '|' )
                    {
                    // InternalPerl.g:2108:2: ( '|' )
                    // InternalPerl.g:2109:3: '|'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 
                    }
                    match(input,274,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 
                    }

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:2114:2: ( '^' )
                    {
                    // InternalPerl.g:2114:2: ( '^' )
                    // InternalPerl.g:2115:3: '^'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 
                    }
                    match(input,275,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 
                    }

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:2120:2: ( '&&' )
                    {
                    // InternalPerl.g:2120:2: ( '&&' )
                    // InternalPerl.g:2121:3: '&&'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 
                    }
                    match(input,276,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 
                    }

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:2126:2: ( '||' )
                    {
                    // InternalPerl.g:2126:2: ( '||' )
                    // InternalPerl.g:2127:3: '||'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 
                    }
                    match(input,277,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 
                    }

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:2132:2: ( '//' )
                    {
                    // InternalPerl.g:2132:2: ( '//' )
                    // InternalPerl.g:2133:3: '//'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 
                    }
                    match(input,278,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 
                    }

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:2138:2: ( '?' )
                    {
                    // InternalPerl.g:2138:2: ( '?' )
                    // InternalPerl.g:2139:3: '?'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 
                    }
                    match(input,279,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 
                    }

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:2144:2: ( ':' )
                    {
                    // InternalPerl.g:2144:2: ( ':' )
                    // InternalPerl.g:2145:3: ':'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getColonKeyword_34()); 
                    }
                    match(input,280,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getColonKeyword_34()); 
                    }

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:2150:2: ( '**=' )
                    {
                    // InternalPerl.g:2150:2: ( '**=' )
                    // InternalPerl.g:2151:3: '**='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 
                    }
                    match(input,281,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 
                    }

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:2156:2: ( '+=' )
                    {
                    // InternalPerl.g:2156:2: ( '+=' )
                    // InternalPerl.g:2157:3: '+='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 
                    }
                    match(input,282,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 
                    }

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:2162:2: ( '-=' )
                    {
                    // InternalPerl.g:2162:2: ( '-=' )
                    // InternalPerl.g:2163:3: '-='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 
                    }
                    match(input,283,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 
                    }

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:2168:2: ( '.=' )
                    {
                    // InternalPerl.g:2168:2: ( '.=' )
                    // InternalPerl.g:2169:3: '.='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 
                    }
                    match(input,284,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 
                    }

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:2174:2: ( '*=' )
                    {
                    // InternalPerl.g:2174:2: ( '*=' )
                    // InternalPerl.g:2175:3: '*='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 
                    }
                    match(input,285,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 
                    }

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:2180:2: ( '/=' )
                    {
                    // InternalPerl.g:2180:2: ( '/=' )
                    // InternalPerl.g:2181:3: '/='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 
                    }
                    match(input,286,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 
                    }

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:2186:2: ( '%=' )
                    {
                    // InternalPerl.g:2186:2: ( '%=' )
                    // InternalPerl.g:2187:3: '%='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 
                    }
                    match(input,287,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 
                    }

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:2192:2: ( 'x=' )
                    {
                    // InternalPerl.g:2192:2: ( 'x=' )
                    // InternalPerl.g:2193:3: 'x='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getXKeyword_42()); 
                    }
                    match(input,288,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getXKeyword_42()); 
                    }

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:2198:2: ( '&=' )
                    {
                    // InternalPerl.g:2198:2: ( '&=' )
                    // InternalPerl.g:2199:3: '&='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 
                    }
                    match(input,289,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 
                    }

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:2204:2: ( '|=' )
                    {
                    // InternalPerl.g:2204:2: ( '|=' )
                    // InternalPerl.g:2205:3: '|='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 
                    }
                    match(input,290,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 
                    }

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:2210:2: ( '^=' )
                    {
                    // InternalPerl.g:2210:2: ( '^=' )
                    // InternalPerl.g:2211:3: '^='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 
                    }
                    match(input,291,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 
                    }

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:2216:2: ( '<<=' )
                    {
                    // InternalPerl.g:2216:2: ( '<<=' )
                    // InternalPerl.g:2217:3: '<<='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 
                    }
                    match(input,292,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 
                    }

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:2222:2: ( '>>=' )
                    {
                    // InternalPerl.g:2222:2: ( '>>=' )
                    // InternalPerl.g:2223:3: '>>='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 
                    }
                    match(input,293,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 
                    }

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:2228:2: ( '&&=' )
                    {
                    // InternalPerl.g:2228:2: ( '&&=' )
                    // InternalPerl.g:2229:3: '&&='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 
                    }
                    match(input,294,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 
                    }

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:2234:2: ( '||=' )
                    {
                    // InternalPerl.g:2234:2: ( '||=' )
                    // InternalPerl.g:2235:3: '||='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 
                    }
                    match(input,295,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 
                    }

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:2240:2: ( '//=' )
                    {
                    // InternalPerl.g:2240:2: ( '//=' )
                    // InternalPerl.g:2241:3: '//='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 
                    }
                    match(input,296,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 
                    }

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:2246:2: ( '<' )
                    {
                    // InternalPerl.g:2246:2: ( '<' )
                    // InternalPerl.g:2247:3: '<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 
                    }
                    match(input,297,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 
                    }

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:2252:2: ( '>' )
                    {
                    // InternalPerl.g:2252:2: ( '>' )
                    // InternalPerl.g:2253:3: '>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 
                    }
                    match(input,298,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 
                    }

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:2258:2: ( '<=' )
                    {
                    // InternalPerl.g:2258:2: ( '<=' )
                    // InternalPerl.g:2259:3: '<='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 
                    }
                    match(input,299,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 
                    }

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:2264:2: ( '>=' )
                    {
                    // InternalPerl.g:2264:2: ( '>=' )
                    // InternalPerl.g:2265:3: '>='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 
                    }
                    match(input,300,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 
                    }

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:2270:2: ( '<>' )
                    {
                    // InternalPerl.g:2270:2: ( '<>' )
                    // InternalPerl.g:2271:3: '<>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 
                    }
                    match(input,301,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 
                    }

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:2276:2: ( '=>' )
                    {
                    // InternalPerl.g:2276:2: ( '=>' )
                    // InternalPerl.g:2277:3: '=>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 
                    }
                    match(input,302,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 
                    }

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:2282:2: ( '->' )
                    {
                    // InternalPerl.g:2282:2: ( '->' )
                    // InternalPerl.g:2283:3: '->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 
                    }
                    match(input,303,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 
                    }

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:2288:2: ( 'and' )
                    {
                    // InternalPerl.g:2288:2: ( 'and' )
                    // InternalPerl.g:2289:3: 'and'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getAndKeyword_58()); 
                    }
                    match(input,304,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getAndKeyword_58()); 
                    }

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:2294:2: ( 'or' )
                    {
                    // InternalPerl.g:2294:2: ( 'or' )
                    // InternalPerl.g:2295:3: 'or'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getOrKeyword_59()); 
                    }
                    match(input,305,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getOrKeyword_59()); 
                    }

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:2300:2: ( 'xor' )
                    {
                    // InternalPerl.g:2300:2: ( 'xor' )
                    // InternalPerl.g:2301:3: 'xor'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getXorKeyword_60()); 
                    }
                    match(input,306,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getXorKeyword_60()); 
                    }

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:2306:2: ( 'not' )
                    {
                    // InternalPerl.g:2306:2: ( 'not' )
                    // InternalPerl.g:2307:3: 'not'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getNotKeyword_61()); 
                    }
                    match(input,307,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getNotKeyword_61()); 
                    }

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:2312:2: ( 'eq' )
                    {
                    // InternalPerl.g:2312:2: ( 'eq' )
                    // InternalPerl.g:2313:3: 'eq'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getEqKeyword_62()); 
                    }
                    match(input,308,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getEqKeyword_62()); 
                    }

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:2318:2: ( 'ne' )
                    {
                    // InternalPerl.g:2318:2: ( 'ne' )
                    // InternalPerl.g:2319:3: 'ne'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOperatorAccess().getNeKeyword_63()); 
                    }
                    match(input,309,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOperatorAccess().getNeKeyword_63()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Alternatives"


    // $ANTLR start "rule__FileTestOperator__Alternatives"
    // InternalPerl.g:2328:1: rule__FileTestOperator__Alternatives : ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) );
    public final void rule__FileTestOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2332:1: ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) )
            int alt8=27;
            switch ( input.LA(1) ) {
            case 310:
                {
                alt8=1;
                }
                break;
            case 311:
                {
                alt8=2;
                }
                break;
            case 312:
                {
                alt8=3;
                }
                break;
            case 313:
                {
                alt8=4;
                }
                break;
            case 314:
                {
                alt8=5;
                }
                break;
            case 315:
                {
                alt8=6;
                }
                break;
            case 316:
                {
                alt8=7;
                }
                break;
            case 317:
                {
                alt8=8;
                }
                break;
            case 318:
                {
                alt8=9;
                }
                break;
            case 319:
                {
                alt8=10;
                }
                break;
            case 320:
                {
                alt8=11;
                }
                break;
            case 321:
                {
                alt8=12;
                }
                break;
            case 322:
                {
                alt8=13;
                }
                break;
            case 323:
                {
                alt8=14;
                }
                break;
            case 324:
                {
                alt8=15;
                }
                break;
            case 325:
                {
                alt8=16;
                }
                break;
            case 326:
                {
                alt8=17;
                }
                break;
            case 327:
                {
                alt8=18;
                }
                break;
            case 328:
                {
                alt8=19;
                }
                break;
            case 329:
                {
                alt8=20;
                }
                break;
            case 330:
                {
                alt8=21;
                }
                break;
            case 331:
                {
                alt8=22;
                }
                break;
            case 332:
                {
                alt8=23;
                }
                break;
            case 333:
                {
                alt8=24;
                }
                break;
            case 334:
                {
                alt8=25;
                }
                break;
            case 335:
                {
                alt8=26;
                }
                break;
            case 336:
                {
                alt8=27;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalPerl.g:2333:2: ( '-r' )
                    {
                    // InternalPerl.g:2333:2: ( '-r' )
                    // InternalPerl.g:2334:3: '-r'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 
                    }
                    match(input,310,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2339:2: ( '-w' )
                    {
                    // InternalPerl.g:2339:2: ( '-w' )
                    // InternalPerl.g:2340:3: '-w'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 
                    }
                    match(input,311,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2345:2: ( '-x' )
                    {
                    // InternalPerl.g:2345:2: ( '-x' )
                    // InternalPerl.g:2346:3: '-x'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 
                    }
                    match(input,312,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2351:2: ( '-o' )
                    {
                    // InternalPerl.g:2351:2: ( '-o' )
                    // InternalPerl.g:2352:3: '-o'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 
                    }
                    match(input,313,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2357:2: ( '-R' )
                    {
                    // InternalPerl.g:2357:2: ( '-R' )
                    // InternalPerl.g:2358:3: '-R'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 
                    }
                    match(input,314,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2363:2: ( '-W' )
                    {
                    // InternalPerl.g:2363:2: ( '-W' )
                    // InternalPerl.g:2364:3: '-W'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 
                    }
                    match(input,315,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2369:2: ( '-X' )
                    {
                    // InternalPerl.g:2369:2: ( '-X' )
                    // InternalPerl.g:2370:3: '-X'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 
                    }
                    match(input,316,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2375:2: ( '-O' )
                    {
                    // InternalPerl.g:2375:2: ( '-O' )
                    // InternalPerl.g:2376:3: '-O'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 
                    }
                    match(input,317,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2381:2: ( '-e' )
                    {
                    // InternalPerl.g:2381:2: ( '-e' )
                    // InternalPerl.g:2382:3: '-e'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 
                    }
                    match(input,318,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2387:2: ( '-z' )
                    {
                    // InternalPerl.g:2387:2: ( '-z' )
                    // InternalPerl.g:2388:3: '-z'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 
                    }
                    match(input,319,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2393:2: ( '-s' )
                    {
                    // InternalPerl.g:2393:2: ( '-s' )
                    // InternalPerl.g:2394:3: '-s'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 
                    }
                    match(input,320,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2399:2: ( '-f' )
                    {
                    // InternalPerl.g:2399:2: ( '-f' )
                    // InternalPerl.g:2400:3: '-f'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 
                    }
                    match(input,321,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2405:2: ( '-d' )
                    {
                    // InternalPerl.g:2405:2: ( '-d' )
                    // InternalPerl.g:2406:3: '-d'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 
                    }
                    match(input,322,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2411:2: ( '-l' )
                    {
                    // InternalPerl.g:2411:2: ( '-l' )
                    // InternalPerl.g:2412:3: '-l'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 
                    }
                    match(input,323,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2417:2: ( '-p' )
                    {
                    // InternalPerl.g:2417:2: ( '-p' )
                    // InternalPerl.g:2418:3: '-p'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 
                    }
                    match(input,324,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2423:2: ( '-S' )
                    {
                    // InternalPerl.g:2423:2: ( '-S' )
                    // InternalPerl.g:2424:3: '-S'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 
                    }
                    match(input,325,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2429:2: ( '-b' )
                    {
                    // InternalPerl.g:2429:2: ( '-b' )
                    // InternalPerl.g:2430:3: '-b'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 
                    }
                    match(input,326,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2435:2: ( '-c' )
                    {
                    // InternalPerl.g:2435:2: ( '-c' )
                    // InternalPerl.g:2436:3: '-c'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 
                    }
                    match(input,327,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2441:2: ( '-t' )
                    {
                    // InternalPerl.g:2441:2: ( '-t' )
                    // InternalPerl.g:2442:3: '-t'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 
                    }
                    match(input,328,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2447:2: ( '-u' )
                    {
                    // InternalPerl.g:2447:2: ( '-u' )
                    // InternalPerl.g:2448:3: '-u'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 
                    }
                    match(input,329,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2453:2: ( '-g' )
                    {
                    // InternalPerl.g:2453:2: ( '-g' )
                    // InternalPerl.g:2454:3: '-g'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 
                    }
                    match(input,330,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2459:2: ( '-k' )
                    {
                    // InternalPerl.g:2459:2: ( '-k' )
                    // InternalPerl.g:2460:3: '-k'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 
                    }
                    match(input,331,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2465:2: ( '-T' )
                    {
                    // InternalPerl.g:2465:2: ( '-T' )
                    // InternalPerl.g:2466:3: '-T'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 
                    }
                    match(input,332,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2471:2: ( '-B' )
                    {
                    // InternalPerl.g:2471:2: ( '-B' )
                    // InternalPerl.g:2472:3: '-B'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 
                    }
                    match(input,333,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:2477:2: ( '-M' )
                    {
                    // InternalPerl.g:2477:2: ( '-M' )
                    // InternalPerl.g:2478:3: '-M'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 
                    }
                    match(input,334,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2483:2: ( '-A' )
                    {
                    // InternalPerl.g:2483:2: ( '-A' )
                    // InternalPerl.g:2484:3: '-A'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 
                    }
                    match(input,335,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2489:2: ( '-C' )
                    {
                    // InternalPerl.g:2489:2: ( '-C' )
                    // InternalPerl.g:2490:3: '-C'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFileTestOperatorAccess().getCKeyword_26()); 
                    }
                    match(input,336,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFileTestOperatorAccess().getCKeyword_26()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FileTestOperator__Alternatives"


    // $ANTLR start "rule__Number__Alternatives_0"
    // InternalPerl.g:2499:1: rule__Number__Alternatives_0 : ( ( RULE_HEX ) | ( RULE_BIN ) | ( RULE_INT ) );
    public final void rule__Number__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2503:1: ( ( RULE_HEX ) | ( RULE_BIN ) | ( RULE_INT ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt9=1;
                }
                break;
            case RULE_BIN:
                {
                alt9=2;
                }
                break;
            case RULE_INT:
                {
                alt9=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalPerl.g:2504:2: ( RULE_HEX )
                    {
                    // InternalPerl.g:2504:2: ( RULE_HEX )
                    // InternalPerl.g:2505:3: RULE_HEX
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0_0()); 
                    }
                    match(input,RULE_HEX,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2510:2: ( RULE_BIN )
                    {
                    // InternalPerl.g:2510:2: ( RULE_BIN )
                    // InternalPerl.g:2511:3: RULE_BIN
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberAccess().getBINTerminalRuleCall_0_1()); 
                    }
                    match(input,RULE_BIN,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberAccess().getBINTerminalRuleCall_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2516:2: ( RULE_INT )
                    {
                    // InternalPerl.g:2516:2: ( RULE_INT )
                    // InternalPerl.g:2517:3: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_0_2()); 
                    }
                    match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_0_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Alternatives_0"


    // $ANTLR start "rule__PerlDocument__Group__0"
    // InternalPerl.g:2526:1: rule__PerlDocument__Group__0 : rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 ;
    public final void rule__PerlDocument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2530:1: ( rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 )
            // InternalPerl.g:2531:2: rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__PerlDocument__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PerlDocument__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PerlDocument__Group__0"


    // $ANTLR start "rule__PerlDocument__Group__0__Impl"
    // InternalPerl.g:2538:1: rule__PerlDocument__Group__0__Impl : ( () ) ;
    public final void rule__PerlDocument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2542:1: ( ( () ) )
            // InternalPerl.g:2543:1: ( () )
            {
            // InternalPerl.g:2543:1: ( () )
            // InternalPerl.g:2544:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0()); 
            }
            // InternalPerl.g:2545:2: ()
            // InternalPerl.g:2545:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PerlDocument__Group__0__Impl"


    // $ANTLR start "rule__PerlDocument__Group__1"
    // InternalPerl.g:2553:1: rule__PerlDocument__Group__1 : rule__PerlDocument__Group__1__Impl ;
    public final void rule__PerlDocument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2557:1: ( rule__PerlDocument__Group__1__Impl )
            // InternalPerl.g:2558:2: rule__PerlDocument__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PerlDocument__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PerlDocument__Group__1"


    // $ANTLR start "rule__PerlDocument__Group__1__Impl"
    // InternalPerl.g:2564:1: rule__PerlDocument__Group__1__Impl : ( ( rule__PerlDocument__ElementsAssignment_1 )* ) ;
    public final void rule__PerlDocument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2568:1: ( ( ( rule__PerlDocument__ElementsAssignment_1 )* ) )
            // InternalPerl.g:2569:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            {
            // InternalPerl.g:2569:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            // InternalPerl.g:2570:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPerlDocumentAccess().getElementsAssignment_1()); 
            }
            // InternalPerl.g:2571:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_INT)||(LA10_0>=RULE_VERSION && LA10_0<=RULE_READLINE_QUOTE)||(LA10_0>=24 && LA10_0<=337)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalPerl.g:2571:3: rule__PerlDocument__ElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__PerlDocument__ElementsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPerlDocumentAccess().getElementsAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PerlDocument__Group__1__Impl"


    // $ANTLR start "rule__PackageStatement__Group__0"
    // InternalPerl.g:2580:1: rule__PackageStatement__Group__0 : rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 ;
    public final void rule__PackageStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2584:1: ( rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 )
            // InternalPerl.g:2585:2: rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__PackageStatement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PackageStatement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__Group__0"


    // $ANTLR start "rule__PackageStatement__Group__0__Impl"
    // InternalPerl.g:2592:1: rule__PackageStatement__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2596:1: ( ( 'package' ) )
            // InternalPerl.g:2597:1: ( 'package' )
            {
            // InternalPerl.g:2597:1: ( 'package' )
            // InternalPerl.g:2598:2: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageStatementAccess().getPackageKeyword_0()); 
            }
            match(input,145,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageStatementAccess().getPackageKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__Group__0__Impl"


    // $ANTLR start "rule__PackageStatement__Group__1"
    // InternalPerl.g:2607:1: rule__PackageStatement__Group__1 : rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 ;
    public final void rule__PackageStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2611:1: ( rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 )
            // InternalPerl.g:2612:2: rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__PackageStatement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PackageStatement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__Group__1"


    // $ANTLR start "rule__PackageStatement__Group__1__Impl"
    // InternalPerl.g:2619:1: rule__PackageStatement__Group__1__Impl : ( ( rule__PackageStatement__NameAssignment_1 ) ) ;
    public final void rule__PackageStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2623:1: ( ( ( rule__PackageStatement__NameAssignment_1 ) ) )
            // InternalPerl.g:2624:1: ( ( rule__PackageStatement__NameAssignment_1 ) )
            {
            // InternalPerl.g:2624:1: ( ( rule__PackageStatement__NameAssignment_1 ) )
            // InternalPerl.g:2625:2: ( rule__PackageStatement__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageStatementAccess().getNameAssignment_1()); 
            }
            // InternalPerl.g:2626:2: ( rule__PackageStatement__NameAssignment_1 )
            // InternalPerl.g:2626:3: rule__PackageStatement__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PackageStatement__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageStatementAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__Group__1__Impl"


    // $ANTLR start "rule__PackageStatement__Group__2"
    // InternalPerl.g:2634:1: rule__PackageStatement__Group__2 : rule__PackageStatement__Group__2__Impl ;
    public final void rule__PackageStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2638:1: ( rule__PackageStatement__Group__2__Impl )
            // InternalPerl.g:2639:2: rule__PackageStatement__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PackageStatement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__Group__2"


    // $ANTLR start "rule__PackageStatement__Group__2__Impl"
    // InternalPerl.g:2645:1: rule__PackageStatement__Group__2__Impl : ( ( rule__PackageStatement__Group_2__0 )? ) ;
    public final void rule__PackageStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2649:1: ( ( ( rule__PackageStatement__Group_2__0 )? ) )
            // InternalPerl.g:2650:1: ( ( rule__PackageStatement__Group_2__0 )? )
            {
            // InternalPerl.g:2650:1: ( ( rule__PackageStatement__Group_2__0 )? )
            // InternalPerl.g:2651:2: ( rule__PackageStatement__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageStatementAccess().getGroup_2()); 
            }
            // InternalPerl.g:2652:2: ( rule__PackageStatement__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_VERSION) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred332_InternalPerl()) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // InternalPerl.g:2652:3: rule__PackageStatement__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PackageStatement__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageStatementAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__Group__2__Impl"


    // $ANTLR start "rule__PackageStatement__Group_2__0"
    // InternalPerl.g:2661:1: rule__PackageStatement__Group_2__0 : rule__PackageStatement__Group_2__0__Impl ;
    public final void rule__PackageStatement__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2665:1: ( rule__PackageStatement__Group_2__0__Impl )
            // InternalPerl.g:2666:2: rule__PackageStatement__Group_2__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PackageStatement__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__Group_2__0"


    // $ANTLR start "rule__PackageStatement__Group_2__0__Impl"
    // InternalPerl.g:2672:1: rule__PackageStatement__Group_2__0__Impl : ( ( rule__PackageStatement__VersionAssignment_2_0 ) ) ;
    public final void rule__PackageStatement__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2676:1: ( ( ( rule__PackageStatement__VersionAssignment_2_0 ) ) )
            // InternalPerl.g:2677:1: ( ( rule__PackageStatement__VersionAssignment_2_0 ) )
            {
            // InternalPerl.g:2677:1: ( ( rule__PackageStatement__VersionAssignment_2_0 ) )
            // InternalPerl.g:2678:2: ( rule__PackageStatement__VersionAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageStatementAccess().getVersionAssignment_2_0()); 
            }
            // InternalPerl.g:2679:2: ( rule__PackageStatement__VersionAssignment_2_0 )
            // InternalPerl.g:2679:3: rule__PackageStatement__VersionAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__PackageStatement__VersionAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageStatementAccess().getVersionAssignment_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__Group_2__0__Impl"


    // $ANTLR start "rule__Token__Group_0__0"
    // InternalPerl.g:2688:1: rule__Token__Group_0__0 : rule__Token__Group_0__0__Impl rule__Token__Group_0__1 ;
    public final void rule__Token__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2692:1: ( rule__Token__Group_0__0__Impl rule__Token__Group_0__1 )
            // InternalPerl.g:2693:2: rule__Token__Group_0__0__Impl rule__Token__Group_0__1
            {
            pushFollow(FOLLOW_7);
            rule__Token__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Token__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_0__0"


    // $ANTLR start "rule__Token__Group_0__0__Impl"
    // InternalPerl.g:2700:1: rule__Token__Group_0__0__Impl : ( () ) ;
    public final void rule__Token__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2704:1: ( ( () ) )
            // InternalPerl.g:2705:1: ( () )
            {
            // InternalPerl.g:2705:1: ( () )
            // InternalPerl.g:2706:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getPodTokenAction_0_0()); 
            }
            // InternalPerl.g:2707:2: ()
            // InternalPerl.g:2707:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getPodTokenAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_0__0__Impl"


    // $ANTLR start "rule__Token__Group_0__1"
    // InternalPerl.g:2715:1: rule__Token__Group_0__1 : rule__Token__Group_0__1__Impl ;
    public final void rule__Token__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2719:1: ( rule__Token__Group_0__1__Impl )
            // InternalPerl.g:2720:2: rule__Token__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_0__1"


    // $ANTLR start "rule__Token__Group_0__1__Impl"
    // InternalPerl.g:2726:1: rule__Token__Group_0__1__Impl : ( ( rule__Token__ContentAssignment_0_1 ) ) ;
    public final void rule__Token__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2730:1: ( ( ( rule__Token__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:2731:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:2731:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            // InternalPerl.g:2732:2: ( rule__Token__ContentAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentAssignment_0_1()); 
            }
            // InternalPerl.g:2733:2: ( rule__Token__ContentAssignment_0_1 )
            // InternalPerl.g:2733:3: rule__Token__ContentAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentAssignment_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_0__1__Impl"


    // $ANTLR start "rule__Token__Group_1__0"
    // InternalPerl.g:2742:1: rule__Token__Group_1__0 : rule__Token__Group_1__0__Impl rule__Token__Group_1__1 ;
    public final void rule__Token__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2746:1: ( rule__Token__Group_1__0__Impl rule__Token__Group_1__1 )
            // InternalPerl.g:2747:2: rule__Token__Group_1__0__Impl rule__Token__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__Token__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Token__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_1__0"


    // $ANTLR start "rule__Token__Group_1__0__Impl"
    // InternalPerl.g:2754:1: rule__Token__Group_1__0__Impl : ( () ) ;
    public final void rule__Token__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2758:1: ( ( () ) )
            // InternalPerl.g:2759:1: ( () )
            {
            // InternalPerl.g:2759:1: ( () )
            // InternalPerl.g:2760:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getNumberTokenAction_1_0()); 
            }
            // InternalPerl.g:2761:2: ()
            // InternalPerl.g:2761:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getNumberTokenAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_1__0__Impl"


    // $ANTLR start "rule__Token__Group_1__1"
    // InternalPerl.g:2769:1: rule__Token__Group_1__1 : rule__Token__Group_1__1__Impl ;
    public final void rule__Token__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2773:1: ( rule__Token__Group_1__1__Impl )
            // InternalPerl.g:2774:2: rule__Token__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_1__1"


    // $ANTLR start "rule__Token__Group_1__1__Impl"
    // InternalPerl.g:2780:1: rule__Token__Group_1__1__Impl : ( ( rule__Token__ContentAssignment_1_1 ) ) ;
    public final void rule__Token__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2784:1: ( ( ( rule__Token__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:2785:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:2785:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            // InternalPerl.g:2786:2: ( rule__Token__ContentAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentAssignment_1_1()); 
            }
            // InternalPerl.g:2787:2: ( rule__Token__ContentAssignment_1_1 )
            // InternalPerl.g:2787:3: rule__Token__ContentAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_1__1__Impl"


    // $ANTLR start "rule__Token__Group_2__0"
    // InternalPerl.g:2796:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2800:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // InternalPerl.g:2801:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
            {
            pushFollow(FOLLOW_6);
            rule__Token__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Token__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_2__0"


    // $ANTLR start "rule__Token__Group_2__0__Impl"
    // InternalPerl.g:2808:1: rule__Token__Group_2__0__Impl : ( () ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2812:1: ( ( () ) )
            // InternalPerl.g:2813:1: ( () )
            {
            // InternalPerl.g:2813:1: ( () )
            // InternalPerl.g:2814:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getVersionTokenAction_2_0()); 
            }
            // InternalPerl.g:2815:2: ()
            // InternalPerl.g:2815:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getVersionTokenAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_2__0__Impl"


    // $ANTLR start "rule__Token__Group_2__1"
    // InternalPerl.g:2823:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2827:1: ( rule__Token__Group_2__1__Impl )
            // InternalPerl.g:2828:2: rule__Token__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_2__1"


    // $ANTLR start "rule__Token__Group_2__1__Impl"
    // InternalPerl.g:2834:1: rule__Token__Group_2__1__Impl : ( ( rule__Token__ContentAssignment_2_1 ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2838:1: ( ( ( rule__Token__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:2839:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:2839:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            // InternalPerl.g:2840:2: ( rule__Token__ContentAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentAssignment_2_1()); 
            }
            // InternalPerl.g:2841:2: ( rule__Token__ContentAssignment_2_1 )
            // InternalPerl.g:2841:3: rule__Token__ContentAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_2__1__Impl"


    // $ANTLR start "rule__Token__Group_3__0"
    // InternalPerl.g:2850:1: rule__Token__Group_3__0 : rule__Token__Group_3__0__Impl rule__Token__Group_3__1 ;
    public final void rule__Token__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2854:1: ( rule__Token__Group_3__0__Impl rule__Token__Group_3__1 )
            // InternalPerl.g:2855:2: rule__Token__Group_3__0__Impl rule__Token__Group_3__1
            {
            pushFollow(FOLLOW_9);
            rule__Token__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Token__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_3__0"


    // $ANTLR start "rule__Token__Group_3__0__Impl"
    // InternalPerl.g:2862:1: rule__Token__Group_3__0__Impl : ( () ) ;
    public final void rule__Token__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2866:1: ( ( () ) )
            // InternalPerl.g:2867:1: ( () )
            {
            // InternalPerl.g:2867:1: ( () )
            // InternalPerl.g:2868:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getWordTokenAction_3_0()); 
            }
            // InternalPerl.g:2869:2: ()
            // InternalPerl.g:2869:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getWordTokenAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_3__0__Impl"


    // $ANTLR start "rule__Token__Group_3__1"
    // InternalPerl.g:2877:1: rule__Token__Group_3__1 : rule__Token__Group_3__1__Impl ;
    public final void rule__Token__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2881:1: ( rule__Token__Group_3__1__Impl )
            // InternalPerl.g:2882:2: rule__Token__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_3__1"


    // $ANTLR start "rule__Token__Group_3__1__Impl"
    // InternalPerl.g:2888:1: rule__Token__Group_3__1__Impl : ( ( rule__Token__ContentAssignment_3_1 ) ) ;
    public final void rule__Token__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2892:1: ( ( ( rule__Token__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:2893:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:2893:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            // InternalPerl.g:2894:2: ( rule__Token__ContentAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentAssignment_3_1()); 
            }
            // InternalPerl.g:2895:2: ( rule__Token__ContentAssignment_3_1 )
            // InternalPerl.g:2895:3: rule__Token__ContentAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_3__1__Impl"


    // $ANTLR start "rule__Token__Group_4__0"
    // InternalPerl.g:2904:1: rule__Token__Group_4__0 : rule__Token__Group_4__0__Impl rule__Token__Group_4__1 ;
    public final void rule__Token__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2908:1: ( rule__Token__Group_4__0__Impl rule__Token__Group_4__1 )
            // InternalPerl.g:2909:2: rule__Token__Group_4__0__Impl rule__Token__Group_4__1
            {
            pushFollow(FOLLOW_10);
            rule__Token__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Token__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_4__0"


    // $ANTLR start "rule__Token__Group_4__0__Impl"
    // InternalPerl.g:2916:1: rule__Token__Group_4__0__Impl : ( () ) ;
    public final void rule__Token__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2920:1: ( ( () ) )
            // InternalPerl.g:2921:1: ( () )
            {
            // InternalPerl.g:2921:1: ( () )
            // InternalPerl.g:2922:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getSymbolTokenAction_4_0()); 
            }
            // InternalPerl.g:2923:2: ()
            // InternalPerl.g:2923:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getSymbolTokenAction_4_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_4__0__Impl"


    // $ANTLR start "rule__Token__Group_4__1"
    // InternalPerl.g:2931:1: rule__Token__Group_4__1 : rule__Token__Group_4__1__Impl ;
    public final void rule__Token__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2935:1: ( rule__Token__Group_4__1__Impl )
            // InternalPerl.g:2936:2: rule__Token__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_4__1"


    // $ANTLR start "rule__Token__Group_4__1__Impl"
    // InternalPerl.g:2942:1: rule__Token__Group_4__1__Impl : ( ( rule__Token__ContentAssignment_4_1 ) ) ;
    public final void rule__Token__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2946:1: ( ( ( rule__Token__ContentAssignment_4_1 ) ) )
            // InternalPerl.g:2947:1: ( ( rule__Token__ContentAssignment_4_1 ) )
            {
            // InternalPerl.g:2947:1: ( ( rule__Token__ContentAssignment_4_1 ) )
            // InternalPerl.g:2948:2: ( rule__Token__ContentAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentAssignment_4_1()); 
            }
            // InternalPerl.g:2949:2: ( rule__Token__ContentAssignment_4_1 )
            // InternalPerl.g:2949:3: rule__Token__ContentAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_4__1__Impl"


    // $ANTLR start "rule__Token__Group_6__0"
    // InternalPerl.g:2958:1: rule__Token__Group_6__0 : rule__Token__Group_6__0__Impl rule__Token__Group_6__1 ;
    public final void rule__Token__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2962:1: ( rule__Token__Group_6__0__Impl rule__Token__Group_6__1 )
            // InternalPerl.g:2963:2: rule__Token__Group_6__0__Impl rule__Token__Group_6__1
            {
            pushFollow(FOLLOW_11);
            rule__Token__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Token__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_6__0"


    // $ANTLR start "rule__Token__Group_6__0__Impl"
    // InternalPerl.g:2970:1: rule__Token__Group_6__0__Impl : ( () ) ;
    public final void rule__Token__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2974:1: ( ( () ) )
            // InternalPerl.g:2975:1: ( () )
            {
            // InternalPerl.g:2975:1: ( () )
            // InternalPerl.g:2976:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getOperatorTokenAction_6_0()); 
            }
            // InternalPerl.g:2977:2: ()
            // InternalPerl.g:2977:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getOperatorTokenAction_6_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_6__0__Impl"


    // $ANTLR start "rule__Token__Group_6__1"
    // InternalPerl.g:2985:1: rule__Token__Group_6__1 : rule__Token__Group_6__1__Impl ;
    public final void rule__Token__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2989:1: ( rule__Token__Group_6__1__Impl )
            // InternalPerl.g:2990:2: rule__Token__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_6__1"


    // $ANTLR start "rule__Token__Group_6__1__Impl"
    // InternalPerl.g:2996:1: rule__Token__Group_6__1__Impl : ( ( rule__Token__ContentAssignment_6_1 ) ) ;
    public final void rule__Token__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3000:1: ( ( ( rule__Token__ContentAssignment_6_1 ) ) )
            // InternalPerl.g:3001:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            {
            // InternalPerl.g:3001:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            // InternalPerl.g:3002:2: ( rule__Token__ContentAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentAssignment_6_1()); 
            }
            // InternalPerl.g:3003:2: ( rule__Token__ContentAssignment_6_1 )
            // InternalPerl.g:3003:3: rule__Token__ContentAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentAssignment_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_6__1__Impl"


    // $ANTLR start "rule__Token__Group_7__0"
    // InternalPerl.g:3012:1: rule__Token__Group_7__0 : rule__Token__Group_7__0__Impl rule__Token__Group_7__1 ;
    public final void rule__Token__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3016:1: ( rule__Token__Group_7__0__Impl rule__Token__Group_7__1 )
            // InternalPerl.g:3017:2: rule__Token__Group_7__0__Impl rule__Token__Group_7__1
            {
            pushFollow(FOLLOW_12);
            rule__Token__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Token__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_7__0"


    // $ANTLR start "rule__Token__Group_7__0__Impl"
    // InternalPerl.g:3024:1: rule__Token__Group_7__0__Impl : ( () ) ;
    public final void rule__Token__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3028:1: ( ( () ) )
            // InternalPerl.g:3029:1: ( () )
            {
            // InternalPerl.g:3029:1: ( () )
            // InternalPerl.g:3030:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getOperatorTokenAction_7_0()); 
            }
            // InternalPerl.g:3031:2: ()
            // InternalPerl.g:3031:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getOperatorTokenAction_7_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_7__0__Impl"


    // $ANTLR start "rule__Token__Group_7__1"
    // InternalPerl.g:3039:1: rule__Token__Group_7__1 : rule__Token__Group_7__1__Impl ;
    public final void rule__Token__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3043:1: ( rule__Token__Group_7__1__Impl )
            // InternalPerl.g:3044:2: rule__Token__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_7__1"


    // $ANTLR start "rule__Token__Group_7__1__Impl"
    // InternalPerl.g:3050:1: rule__Token__Group_7__1__Impl : ( ( rule__Token__ContentAssignment_7_1 ) ) ;
    public final void rule__Token__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3054:1: ( ( ( rule__Token__ContentAssignment_7_1 ) ) )
            // InternalPerl.g:3055:1: ( ( rule__Token__ContentAssignment_7_1 ) )
            {
            // InternalPerl.g:3055:1: ( ( rule__Token__ContentAssignment_7_1 ) )
            // InternalPerl.g:3056:2: ( rule__Token__ContentAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentAssignment_7_1()); 
            }
            // InternalPerl.g:3057:2: ( rule__Token__ContentAssignment_7_1 )
            // InternalPerl.g:3057:3: rule__Token__ContentAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_7_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentAssignment_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_7__1__Impl"


    // $ANTLR start "rule__Token__Group_9__0"
    // InternalPerl.g:3066:1: rule__Token__Group_9__0 : rule__Token__Group_9__0__Impl rule__Token__Group_9__1 ;
    public final void rule__Token__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3070:1: ( rule__Token__Group_9__0__Impl rule__Token__Group_9__1 )
            // InternalPerl.g:3071:2: rule__Token__Group_9__0__Impl rule__Token__Group_9__1
            {
            pushFollow(FOLLOW_13);
            rule__Token__Group_9__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Token__Group_9__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_9__0"


    // $ANTLR start "rule__Token__Group_9__0__Impl"
    // InternalPerl.g:3078:1: rule__Token__Group_9__0__Impl : ( () ) ;
    public final void rule__Token__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3082:1: ( ( () ) )
            // InternalPerl.g:3083:1: ( () )
            {
            // InternalPerl.g:3083:1: ( () )
            // InternalPerl.g:3084:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getDataTokenAction_9_0()); 
            }
            // InternalPerl.g:3085:2: ()
            // InternalPerl.g:3085:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getDataTokenAction_9_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_9__0__Impl"


    // $ANTLR start "rule__Token__Group_9__1"
    // InternalPerl.g:3093:1: rule__Token__Group_9__1 : rule__Token__Group_9__1__Impl ;
    public final void rule__Token__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3097:1: ( rule__Token__Group_9__1__Impl )
            // InternalPerl.g:3098:2: rule__Token__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_9__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_9__1"


    // $ANTLR start "rule__Token__Group_9__1__Impl"
    // InternalPerl.g:3104:1: rule__Token__Group_9__1__Impl : ( ( rule__Token__ContentAssignment_9_1 ) ) ;
    public final void rule__Token__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3108:1: ( ( ( rule__Token__ContentAssignment_9_1 ) ) )
            // InternalPerl.g:3109:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            {
            // InternalPerl.g:3109:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            // InternalPerl.g:3110:2: ( rule__Token__ContentAssignment_9_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentAssignment_9_1()); 
            }
            // InternalPerl.g:3111:2: ( rule__Token__ContentAssignment_9_1 )
            // InternalPerl.g:3111:3: rule__Token__ContentAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_9_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentAssignment_9_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_9__1__Impl"


    // $ANTLR start "rule__Token__Group_10__0"
    // InternalPerl.g:3120:1: rule__Token__Group_10__0 : rule__Token__Group_10__0__Impl rule__Token__Group_10__1 ;
    public final void rule__Token__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3124:1: ( rule__Token__Group_10__0__Impl rule__Token__Group_10__1 )
            // InternalPerl.g:3125:2: rule__Token__Group_10__0__Impl rule__Token__Group_10__1
            {
            pushFollow(FOLLOW_3);
            rule__Token__Group_10__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Token__Group_10__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_10__0"


    // $ANTLR start "rule__Token__Group_10__0__Impl"
    // InternalPerl.g:3132:1: rule__Token__Group_10__0__Impl : ( () ) ;
    public final void rule__Token__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3136:1: ( ( () ) )
            // InternalPerl.g:3137:1: ( () )
            {
            // InternalPerl.g:3137:1: ( () )
            // InternalPerl.g:3138:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getEndTokenAction_10_0()); 
            }
            // InternalPerl.g:3139:2: ()
            // InternalPerl.g:3139:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getEndTokenAction_10_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_10__0__Impl"


    // $ANTLR start "rule__Token__Group_10__1"
    // InternalPerl.g:3147:1: rule__Token__Group_10__1 : rule__Token__Group_10__1__Impl ;
    public final void rule__Token__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3151:1: ( rule__Token__Group_10__1__Impl )
            // InternalPerl.g:3152:2: rule__Token__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_10__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_10__1"


    // $ANTLR start "rule__Token__Group_10__1__Impl"
    // InternalPerl.g:3158:1: rule__Token__Group_10__1__Impl : ( ( rule__Token__ContentAssignment_10_1 ) ) ;
    public final void rule__Token__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3162:1: ( ( ( rule__Token__ContentAssignment_10_1 ) ) )
            // InternalPerl.g:3163:1: ( ( rule__Token__ContentAssignment_10_1 ) )
            {
            // InternalPerl.g:3163:1: ( ( rule__Token__ContentAssignment_10_1 ) )
            // InternalPerl.g:3164:2: ( rule__Token__ContentAssignment_10_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentAssignment_10_1()); 
            }
            // InternalPerl.g:3165:2: ( rule__Token__ContentAssignment_10_1 )
            // InternalPerl.g:3165:3: rule__Token__ContentAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_10_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentAssignment_10_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_10__1__Impl"


    // $ANTLR start "rule__QuoteToken__Group__0"
    // InternalPerl.g:3174:1: rule__QuoteToken__Group__0 : rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 ;
    public final void rule__QuoteToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3178:1: ( rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 )
            // InternalPerl.g:3179:2: rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__QuoteToken__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QuoteToken__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteToken__Group__0"


    // $ANTLR start "rule__QuoteToken__Group__0__Impl"
    // InternalPerl.g:3186:1: rule__QuoteToken__Group__0__Impl : ( () ) ;
    public final void rule__QuoteToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3190:1: ( ( () ) )
            // InternalPerl.g:3191:1: ( () )
            {
            // InternalPerl.g:3191:1: ( () )
            // InternalPerl.g:3192:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteTokenAccess().getQuoteTokenAction_0()); 
            }
            // InternalPerl.g:3193:2: ()
            // InternalPerl.g:3193:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteTokenAccess().getQuoteTokenAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteToken__Group__0__Impl"


    // $ANTLR start "rule__QuoteToken__Group__1"
    // InternalPerl.g:3201:1: rule__QuoteToken__Group__1 : rule__QuoteToken__Group__1__Impl ;
    public final void rule__QuoteToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3205:1: ( rule__QuoteToken__Group__1__Impl )
            // InternalPerl.g:3206:2: rule__QuoteToken__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteToken__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteToken__Group__1"


    // $ANTLR start "rule__QuoteToken__Group__1__Impl"
    // InternalPerl.g:3212:1: rule__QuoteToken__Group__1__Impl : ( ( rule__QuoteToken__ContentAssignment_1 ) ) ;
    public final void rule__QuoteToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3216:1: ( ( ( rule__QuoteToken__ContentAssignment_1 ) ) )
            // InternalPerl.g:3217:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            {
            // InternalPerl.g:3217:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            // InternalPerl.g:3218:2: ( rule__QuoteToken__ContentAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteTokenAccess().getContentAssignment_1()); 
            }
            // InternalPerl.g:3219:2: ( rule__QuoteToken__ContentAssignment_1 )
            // InternalPerl.g:3219:3: rule__QuoteToken__ContentAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteToken__ContentAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteTokenAccess().getContentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteToken__Group__1__Impl"


    // $ANTLR start "rule__QuoteLikeToken__Group_0__0"
    // InternalPerl.g:3228:1: rule__QuoteLikeToken__Group_0__0 : rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 ;
    public final void rule__QuoteLikeToken__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3232:1: ( rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 )
            // InternalPerl.g:3233:2: rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1
            {
            pushFollow(FOLLOW_15);
            rule__QuoteLikeToken__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_0__0"


    // $ANTLR start "rule__QuoteLikeToken__Group_0__0__Impl"
    // InternalPerl.g:3240:1: rule__QuoteLikeToken__Group_0__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3244:1: ( ( () ) )
            // InternalPerl.g:3245:1: ( () )
            {
            // InternalPerl.g:3245:1: ( () )
            // InternalPerl.g:3246:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0()); 
            }
            // InternalPerl.g:3247:2: ()
            // InternalPerl.g:3247:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_0__0__Impl"


    // $ANTLR start "rule__QuoteLikeToken__Group_0__1"
    // InternalPerl.g:3255:1: rule__QuoteLikeToken__Group_0__1 : rule__QuoteLikeToken__Group_0__1__Impl ;
    public final void rule__QuoteLikeToken__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3259:1: ( rule__QuoteLikeToken__Group_0__1__Impl )
            // InternalPerl.g:3260:2: rule__QuoteLikeToken__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_0__1"


    // $ANTLR start "rule__QuoteLikeToken__Group_0__1__Impl"
    // InternalPerl.g:3266:1: rule__QuoteLikeToken__Group_0__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3270:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:3271:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:3271:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            // InternalPerl.g:3272:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_0_1()); 
            }
            // InternalPerl.g:3273:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            // InternalPerl.g:3273:3: rule__QuoteLikeToken__ContentAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__ContentAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_0__1__Impl"


    // $ANTLR start "rule__QuoteLikeToken__Group_1__0"
    // InternalPerl.g:3282:1: rule__QuoteLikeToken__Group_1__0 : rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 ;
    public final void rule__QuoteLikeToken__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3286:1: ( rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 )
            // InternalPerl.g:3287:2: rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1
            {
            pushFollow(FOLLOW_16);
            rule__QuoteLikeToken__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_1__0"


    // $ANTLR start "rule__QuoteLikeToken__Group_1__0__Impl"
    // InternalPerl.g:3294:1: rule__QuoteLikeToken__Group_1__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3298:1: ( ( () ) )
            // InternalPerl.g:3299:1: ( () )
            {
            // InternalPerl.g:3299:1: ( () )
            // InternalPerl.g:3300:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0()); 
            }
            // InternalPerl.g:3301:2: ()
            // InternalPerl.g:3301:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_1__0__Impl"


    // $ANTLR start "rule__QuoteLikeToken__Group_1__1"
    // InternalPerl.g:3309:1: rule__QuoteLikeToken__Group_1__1 : rule__QuoteLikeToken__Group_1__1__Impl ;
    public final void rule__QuoteLikeToken__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3313:1: ( rule__QuoteLikeToken__Group_1__1__Impl )
            // InternalPerl.g:3314:2: rule__QuoteLikeToken__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_1__1"


    // $ANTLR start "rule__QuoteLikeToken__Group_1__1__Impl"
    // InternalPerl.g:3320:1: rule__QuoteLikeToken__Group_1__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3324:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:3325:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:3325:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            // InternalPerl.g:3326:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_1_1()); 
            }
            // InternalPerl.g:3327:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            // InternalPerl.g:3327:3: rule__QuoteLikeToken__ContentAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__ContentAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_1__1__Impl"


    // $ANTLR start "rule__QuoteLikeToken__Group_2__0"
    // InternalPerl.g:3336:1: rule__QuoteLikeToken__Group_2__0 : rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 ;
    public final void rule__QuoteLikeToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3340:1: ( rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 )
            // InternalPerl.g:3341:2: rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1
            {
            pushFollow(FOLLOW_17);
            rule__QuoteLikeToken__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_2__0"


    // $ANTLR start "rule__QuoteLikeToken__Group_2__0__Impl"
    // InternalPerl.g:3348:1: rule__QuoteLikeToken__Group_2__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3352:1: ( ( () ) )
            // InternalPerl.g:3353:1: ( () )
            {
            // InternalPerl.g:3353:1: ( () )
            // InternalPerl.g:3354:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0()); 
            }
            // InternalPerl.g:3355:2: ()
            // InternalPerl.g:3355:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_2__0__Impl"


    // $ANTLR start "rule__QuoteLikeToken__Group_2__1"
    // InternalPerl.g:3363:1: rule__QuoteLikeToken__Group_2__1 : rule__QuoteLikeToken__Group_2__1__Impl ;
    public final void rule__QuoteLikeToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3367:1: ( rule__QuoteLikeToken__Group_2__1__Impl )
            // InternalPerl.g:3368:2: rule__QuoteLikeToken__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_2__1"


    // $ANTLR start "rule__QuoteLikeToken__Group_2__1__Impl"
    // InternalPerl.g:3374:1: rule__QuoteLikeToken__Group_2__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3378:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:3379:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:3379:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            // InternalPerl.g:3380:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_2_1()); 
            }
            // InternalPerl.g:3381:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            // InternalPerl.g:3381:3: rule__QuoteLikeToken__ContentAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__ContentAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_2__1__Impl"


    // $ANTLR start "rule__QuoteLikeToken__Group_3__0"
    // InternalPerl.g:3390:1: rule__QuoteLikeToken__Group_3__0 : rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 ;
    public final void rule__QuoteLikeToken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3394:1: ( rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 )
            // InternalPerl.g:3395:2: rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1
            {
            pushFollow(FOLLOW_18);
            rule__QuoteLikeToken__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_3__0"


    // $ANTLR start "rule__QuoteLikeToken__Group_3__0__Impl"
    // InternalPerl.g:3402:1: rule__QuoteLikeToken__Group_3__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3406:1: ( ( () ) )
            // InternalPerl.g:3407:1: ( () )
            {
            // InternalPerl.g:3407:1: ( () )
            // InternalPerl.g:3408:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0()); 
            }
            // InternalPerl.g:3409:2: ()
            // InternalPerl.g:3409:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_3__0__Impl"


    // $ANTLR start "rule__QuoteLikeToken__Group_3__1"
    // InternalPerl.g:3417:1: rule__QuoteLikeToken__Group_3__1 : rule__QuoteLikeToken__Group_3__1__Impl ;
    public final void rule__QuoteLikeToken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3421:1: ( rule__QuoteLikeToken__Group_3__1__Impl )
            // InternalPerl.g:3422:2: rule__QuoteLikeToken__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_3__1"


    // $ANTLR start "rule__QuoteLikeToken__Group_3__1__Impl"
    // InternalPerl.g:3428:1: rule__QuoteLikeToken__Group_3__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3432:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:3433:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:3433:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            // InternalPerl.g:3434:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_3_1()); 
            }
            // InternalPerl.g:3435:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            // InternalPerl.g:3435:3: rule__QuoteLikeToken__ContentAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__ContentAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_3__1__Impl"


    // $ANTLR start "rule__QuoteLikeToken__Group_4__0"
    // InternalPerl.g:3444:1: rule__QuoteLikeToken__Group_4__0 : rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 ;
    public final void rule__QuoteLikeToken__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3448:1: ( rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 )
            // InternalPerl.g:3449:2: rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1
            {
            pushFollow(FOLLOW_19);
            rule__QuoteLikeToken__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_4__0"


    // $ANTLR start "rule__QuoteLikeToken__Group_4__0__Impl"
    // InternalPerl.g:3456:1: rule__QuoteLikeToken__Group_4__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3460:1: ( ( () ) )
            // InternalPerl.g:3461:1: ( () )
            {
            // InternalPerl.g:3461:1: ( () )
            // InternalPerl.g:3462:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0()); 
            }
            // InternalPerl.g:3463:2: ()
            // InternalPerl.g:3463:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_4__0__Impl"


    // $ANTLR start "rule__QuoteLikeToken__Group_4__1"
    // InternalPerl.g:3471:1: rule__QuoteLikeToken__Group_4__1 : rule__QuoteLikeToken__Group_4__1__Impl ;
    public final void rule__QuoteLikeToken__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3475:1: ( rule__QuoteLikeToken__Group_4__1__Impl )
            // InternalPerl.g:3476:2: rule__QuoteLikeToken__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_4__1"


    // $ANTLR start "rule__QuoteLikeToken__Group_4__1__Impl"
    // InternalPerl.g:3482:1: rule__QuoteLikeToken__Group_4__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3486:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) )
            // InternalPerl.g:3487:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            {
            // InternalPerl.g:3487:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            // InternalPerl.g:3488:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_4_1()); 
            }
            // InternalPerl.g:3489:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            // InternalPerl.g:3489:3: rule__QuoteLikeToken__ContentAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__ContentAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__Group_4__1__Impl"


    // $ANTLR start "rule__Operator__Group_23__0"
    // InternalPerl.g:3498:1: rule__Operator__Group_23__0 : rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 ;
    public final void rule__Operator__Group_23__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3502:1: ( rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 )
            // InternalPerl.g:3503:2: rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1
            {
            pushFollow(FOLLOW_20);
            rule__Operator__Group_23__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Operator__Group_23__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group_23__0"


    // $ANTLR start "rule__Operator__Group_23__0__Impl"
    // InternalPerl.g:3510:1: rule__Operator__Group_23__0__Impl : ( '<=>' ) ;
    public final void rule__Operator__Group_23__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3514:1: ( ( '<=>' ) )
            // InternalPerl.g:3515:1: ( '<=>' )
            {
            // InternalPerl.g:3515:1: ( '<=>' )
            // InternalPerl.g:3516:2: '<=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_23_0()); 
            }
            match(input,337,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_23_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group_23__0__Impl"


    // $ANTLR start "rule__Operator__Group_23__1"
    // InternalPerl.g:3525:1: rule__Operator__Group_23__1 : rule__Operator__Group_23__1__Impl ;
    public final void rule__Operator__Group_23__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3529:1: ( rule__Operator__Group_23__1__Impl )
            // InternalPerl.g:3530:2: rule__Operator__Group_23__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Operator__Group_23__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group_23__1"


    // $ANTLR start "rule__Operator__Group_23__1__Impl"
    // InternalPerl.g:3536:1: rule__Operator__Group_23__1__Impl : ( '.' ) ;
    public final void rule__Operator__Group_23__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3540:1: ( ( '.' ) )
            // InternalPerl.g:3541:1: ( '.' )
            {
            // InternalPerl.g:3541:1: ( '.' )
            // InternalPerl.g:3542:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperatorAccess().getFullStopKeyword_23_1()); 
            }
            match(input,338,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperatorAccess().getFullStopKeyword_23_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Group_23__1__Impl"


    // $ANTLR start "rule__Number__Group__0"
    // InternalPerl.g:3552:1: rule__Number__Group__0 : rule__Number__Group__0__Impl rule__Number__Group__1 ;
    public final void rule__Number__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3556:1: ( rule__Number__Group__0__Impl rule__Number__Group__1 )
            // InternalPerl.g:3557:2: rule__Number__Group__0__Impl rule__Number__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Number__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Number__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group__0"


    // $ANTLR start "rule__Number__Group__0__Impl"
    // InternalPerl.g:3564:1: rule__Number__Group__0__Impl : ( ( rule__Number__Alternatives_0 ) ) ;
    public final void rule__Number__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3568:1: ( ( ( rule__Number__Alternatives_0 ) ) )
            // InternalPerl.g:3569:1: ( ( rule__Number__Alternatives_0 ) )
            {
            // InternalPerl.g:3569:1: ( ( rule__Number__Alternatives_0 ) )
            // InternalPerl.g:3570:2: ( rule__Number__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberAccess().getAlternatives_0()); 
            }
            // InternalPerl.g:3571:2: ( rule__Number__Alternatives_0 )
            // InternalPerl.g:3571:3: rule__Number__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Number__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberAccess().getAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group__0__Impl"


    // $ANTLR start "rule__Number__Group__1"
    // InternalPerl.g:3579:1: rule__Number__Group__1 : rule__Number__Group__1__Impl ;
    public final void rule__Number__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3583:1: ( rule__Number__Group__1__Impl )
            // InternalPerl.g:3584:2: rule__Number__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Number__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group__1"


    // $ANTLR start "rule__Number__Group__1__Impl"
    // InternalPerl.g:3590:1: rule__Number__Group__1__Impl : ( ( rule__Number__Group_1__0 )? ) ;
    public final void rule__Number__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3594:1: ( ( ( rule__Number__Group_1__0 )? ) )
            // InternalPerl.g:3595:1: ( ( rule__Number__Group_1__0 )? )
            {
            // InternalPerl.g:3595:1: ( ( rule__Number__Group_1__0 )? )
            // InternalPerl.g:3596:2: ( rule__Number__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberAccess().getGroup_1()); 
            }
            // InternalPerl.g:3597:2: ( rule__Number__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==338) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalPerl.g:3597:3: rule__Number__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Number__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group__1__Impl"


    // $ANTLR start "rule__Number__Group_1__0"
    // InternalPerl.g:3606:1: rule__Number__Group_1__0 : rule__Number__Group_1__0__Impl rule__Number__Group_1__1 ;
    public final void rule__Number__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3610:1: ( rule__Number__Group_1__0__Impl rule__Number__Group_1__1 )
            // InternalPerl.g:3611:2: rule__Number__Group_1__0__Impl rule__Number__Group_1__1
            {
            pushFollow(FOLLOW_21);
            rule__Number__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Number__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group_1__0"


    // $ANTLR start "rule__Number__Group_1__0__Impl"
    // InternalPerl.g:3618:1: rule__Number__Group_1__0__Impl : ( '.' ) ;
    public final void rule__Number__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3622:1: ( ( '.' ) )
            // InternalPerl.g:3623:1: ( '.' )
            {
            // InternalPerl.g:3623:1: ( '.' )
            // InternalPerl.g:3624:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberAccess().getFullStopKeyword_1_0()); 
            }
            match(input,338,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group_1__0__Impl"


    // $ANTLR start "rule__Number__Group_1__1"
    // InternalPerl.g:3633:1: rule__Number__Group_1__1 : rule__Number__Group_1__1__Impl ;
    public final void rule__Number__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3637:1: ( rule__Number__Group_1__1__Impl )
            // InternalPerl.g:3638:2: rule__Number__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Number__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group_1__1"


    // $ANTLR start "rule__Number__Group_1__1__Impl"
    // InternalPerl.g:3644:1: rule__Number__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Number__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3648:1: ( ( RULE_INT ) )
            // InternalPerl.g:3649:1: ( RULE_INT )
            {
            // InternalPerl.g:3649:1: ( RULE_INT )
            // InternalPerl.g:3650:2: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group_1__1__Impl"


    // $ANTLR start "rule__PerlDocument__ElementsAssignment_1"
    // InternalPerl.g:3660:1: rule__PerlDocument__ElementsAssignment_1 : ( ruleElement ) ;
    public final void rule__PerlDocument__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3664:1: ( ( ruleElement ) )
            // InternalPerl.g:3665:2: ( ruleElement )
            {
            // InternalPerl.g:3665:2: ( ruleElement )
            // InternalPerl.g:3666:3: ruleElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPerlDocumentAccess().getElementsElementParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPerlDocumentAccess().getElementsElementParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PerlDocument__ElementsAssignment_1"


    // $ANTLR start "rule__PackageStatement__NameAssignment_1"
    // InternalPerl.g:3675:1: rule__PackageStatement__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PackageStatement__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3679:1: ( ( RULE_ID ) )
            // InternalPerl.g:3680:2: ( RULE_ID )
            {
            // InternalPerl.g:3680:2: ( RULE_ID )
            // InternalPerl.g:3681:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageStatementAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageStatementAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__NameAssignment_1"


    // $ANTLR start "rule__PackageStatement__VersionAssignment_2_0"
    // InternalPerl.g:3690:1: rule__PackageStatement__VersionAssignment_2_0 : ( RULE_VERSION ) ;
    public final void rule__PackageStatement__VersionAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3694:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:3695:2: ( RULE_VERSION )
            {
            // InternalPerl.g:3695:2: ( RULE_VERSION )
            // InternalPerl.g:3696:3: RULE_VERSION
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageStatementAccess().getVersionVERSIONTerminalRuleCall_2_0_0()); 
            }
            match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageStatementAccess().getVersionVERSIONTerminalRuleCall_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__VersionAssignment_2_0"


    // $ANTLR start "rule__Token__ContentAssignment_0_1"
    // InternalPerl.g:3705:1: rule__Token__ContentAssignment_0_1 : ( RULE_POD ) ;
    public final void rule__Token__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3709:1: ( ( RULE_POD ) )
            // InternalPerl.g:3710:2: ( RULE_POD )
            {
            // InternalPerl.g:3710:2: ( RULE_POD )
            // InternalPerl.g:3711:3: RULE_POD
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentPODTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_POD,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentPODTerminalRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__ContentAssignment_0_1"


    // $ANTLR start "rule__Token__ContentAssignment_1_1"
    // InternalPerl.g:3720:1: rule__Token__ContentAssignment_1_1 : ( ruleNumber ) ;
    public final void rule__Token__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3724:1: ( ( ruleNumber ) )
            // InternalPerl.g:3725:2: ( ruleNumber )
            {
            // InternalPerl.g:3725:2: ( ruleNumber )
            // InternalPerl.g:3726:3: ruleNumber
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentNumberParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleNumber();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentNumberParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__ContentAssignment_1_1"


    // $ANTLR start "rule__Token__ContentAssignment_2_1"
    // InternalPerl.g:3735:1: rule__Token__ContentAssignment_2_1 : ( RULE_VERSION ) ;
    public final void rule__Token__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3739:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:3740:2: ( RULE_VERSION )
            {
            // InternalPerl.g:3740:2: ( RULE_VERSION )
            // InternalPerl.g:3741:3: RULE_VERSION
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentVERSIONTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentVERSIONTerminalRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__ContentAssignment_2_1"


    // $ANTLR start "rule__Token__ContentAssignment_3_1"
    // InternalPerl.g:3750:1: rule__Token__ContentAssignment_3_1 : ( ruleWord ) ;
    public final void rule__Token__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3754:1: ( ( ruleWord ) )
            // InternalPerl.g:3755:2: ( ruleWord )
            {
            // InternalPerl.g:3755:2: ( ruleWord )
            // InternalPerl.g:3756:3: ruleWord
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentWordParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleWord();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentWordParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__ContentAssignment_3_1"


    // $ANTLR start "rule__Token__ContentAssignment_4_1"
    // InternalPerl.g:3765:1: rule__Token__ContentAssignment_4_1 : ( RULE_SYMBOL ) ;
    public final void rule__Token__ContentAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3769:1: ( ( RULE_SYMBOL ) )
            // InternalPerl.g:3770:2: ( RULE_SYMBOL )
            {
            // InternalPerl.g:3770:2: ( RULE_SYMBOL )
            // InternalPerl.g:3771:3: RULE_SYMBOL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentSYMBOLTerminalRuleCall_4_1_0()); 
            }
            match(input,RULE_SYMBOL,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentSYMBOLTerminalRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__ContentAssignment_4_1"


    // $ANTLR start "rule__Token__ContentAssignment_6_1"
    // InternalPerl.g:3780:1: rule__Token__ContentAssignment_6_1 : ( ruleFileTestOperator ) ;
    public final void rule__Token__ContentAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3784:1: ( ( ruleFileTestOperator ) )
            // InternalPerl.g:3785:2: ( ruleFileTestOperator )
            {
            // InternalPerl.g:3785:2: ( ruleFileTestOperator )
            // InternalPerl.g:3786:3: ruleFileTestOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentFileTestOperatorParserRuleCall_6_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFileTestOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentFileTestOperatorParserRuleCall_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__ContentAssignment_6_1"


    // $ANTLR start "rule__Token__ContentAssignment_7_1"
    // InternalPerl.g:3795:1: rule__Token__ContentAssignment_7_1 : ( ruleOperator ) ;
    public final void rule__Token__ContentAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3799:1: ( ( ruleOperator ) )
            // InternalPerl.g:3800:2: ( ruleOperator )
            {
            // InternalPerl.g:3800:2: ( ruleOperator )
            // InternalPerl.g:3801:3: ruleOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentOperatorParserRuleCall_7_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentOperatorParserRuleCall_7_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__ContentAssignment_7_1"


    // $ANTLR start "rule__Token__ContentAssignment_9_1"
    // InternalPerl.g:3810:1: rule__Token__ContentAssignment_9_1 : ( RULE_DATA ) ;
    public final void rule__Token__ContentAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3814:1: ( ( RULE_DATA ) )
            // InternalPerl.g:3815:2: ( RULE_DATA )
            {
            // InternalPerl.g:3815:2: ( RULE_DATA )
            // InternalPerl.g:3816:3: RULE_DATA
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentDATATerminalRuleCall_9_1_0()); 
            }
            match(input,RULE_DATA,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentDATATerminalRuleCall_9_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__ContentAssignment_9_1"


    // $ANTLR start "rule__Token__ContentAssignment_10_1"
    // InternalPerl.g:3825:1: rule__Token__ContentAssignment_10_1 : ( RULE_END ) ;
    public final void rule__Token__ContentAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3829:1: ( ( RULE_END ) )
            // InternalPerl.g:3830:2: ( RULE_END )
            {
            // InternalPerl.g:3830:2: ( RULE_END )
            // InternalPerl.g:3831:3: RULE_END
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokenAccess().getContentENDTerminalRuleCall_10_1_0()); 
            }
            match(input,RULE_END,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokenAccess().getContentENDTerminalRuleCall_10_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__ContentAssignment_10_1"


    // $ANTLR start "rule__QuoteToken__ContentAssignment_1"
    // InternalPerl.g:3840:1: rule__QuoteToken__ContentAssignment_1 : ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) ;
    public final void rule__QuoteToken__ContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3844:1: ( ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) )
            // InternalPerl.g:3845:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            {
            // InternalPerl.g:3845:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            // InternalPerl.g:3846:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteTokenAccess().getContentAlternatives_1_0()); 
            }
            // InternalPerl.g:3847:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            // InternalPerl.g:3847:4: rule__QuoteToken__ContentAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__QuoteToken__ContentAlternatives_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteTokenAccess().getContentAlternatives_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteToken__ContentAssignment_1"


    // $ANTLR start "rule__QuoteLikeToken__ContentAssignment_0_1"
    // InternalPerl.g:3855:1: rule__QuoteLikeToken__ContentAssignment_0_1 : ( RULE_BACKTICK_STRING ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3859:1: ( ( RULE_BACKTICK_STRING ) )
            // InternalPerl.g:3860:2: ( RULE_BACKTICK_STRING )
            {
            // InternalPerl.g:3860:2: ( RULE_BACKTICK_STRING )
            // InternalPerl.g:3861:3: RULE_BACKTICK_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getContentBACKTICK_STRINGTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_BACKTICK_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getContentBACKTICK_STRINGTerminalRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__ContentAssignment_0_1"


    // $ANTLR start "rule__QuoteLikeToken__ContentAssignment_1_1"
    // InternalPerl.g:3870:1: rule__QuoteLikeToken__ContentAssignment_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3874:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:3875:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:3875:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:3876:3: RULE_WORDS_QUOTE_LIKE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getContentWORDS_QUOTE_LIKETerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_WORDS_QUOTE_LIKE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getContentWORDS_QUOTE_LIKETerminalRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__ContentAssignment_1_1"


    // $ANTLR start "rule__QuoteLikeToken__ContentAssignment_2_1"
    // InternalPerl.g:3885:1: rule__QuoteLikeToken__ContentAssignment_2_1 : ( RULE_COMMAND_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3889:1: ( ( RULE_COMMAND_QUOTE_LIKE ) )
            // InternalPerl.g:3890:2: ( RULE_COMMAND_QUOTE_LIKE )
            {
            // InternalPerl.g:3890:2: ( RULE_COMMAND_QUOTE_LIKE )
            // InternalPerl.g:3891:3: RULE_COMMAND_QUOTE_LIKE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getContentCOMMAND_QUOTE_LIKETerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_COMMAND_QUOTE_LIKE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getContentCOMMAND_QUOTE_LIKETerminalRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__ContentAssignment_2_1"


    // $ANTLR start "rule__QuoteLikeToken__ContentAssignment_3_1"
    // InternalPerl.g:3900:1: rule__QuoteLikeToken__ContentAssignment_3_1 : ( RULE_REGEX_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3904:1: ( ( RULE_REGEX_QUOTE ) )
            // InternalPerl.g:3905:2: ( RULE_REGEX_QUOTE )
            {
            // InternalPerl.g:3905:2: ( RULE_REGEX_QUOTE )
            // InternalPerl.g:3906:3: RULE_REGEX_QUOTE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getContentREGEX_QUOTETerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_REGEX_QUOTE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getContentREGEX_QUOTETerminalRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__ContentAssignment_3_1"


    // $ANTLR start "rule__QuoteLikeToken__ContentAssignment_4_1"
    // InternalPerl.g:3915:1: rule__QuoteLikeToken__ContentAssignment_4_1 : ( RULE_READLINE_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3919:1: ( ( RULE_READLINE_QUOTE ) )
            // InternalPerl.g:3920:2: ( RULE_READLINE_QUOTE )
            {
            // InternalPerl.g:3920:2: ( RULE_READLINE_QUOTE )
            // InternalPerl.g:3921:3: RULE_READLINE_QUOTE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuoteLikeTokenAccess().getContentREADLINE_QUOTETerminalRuleCall_4_1_0()); 
            }
            match(input,RULE_READLINE_QUOTE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuoteLikeTokenAccess().getContentREADLINE_QUOTETerminalRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuoteLikeToken__ContentAssignment_4_1"

    // $ANTLR start synpred332_InternalPerl
    public final void synpred332_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:2652:3: ( rule__PackageStatement__Group_2__0 )
        // InternalPerl.g:2652:3: rule__PackageStatement__Group_2__0
        {
        pushFollow(FOLLOW_2);
        rule__PackageStatement__Group_2__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred332_InternalPerl

    // Delegated rules

    public final boolean synpred332_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred332_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFFFFFFF1FFBF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x000000000003FFFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFFFF1FFBF2L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x000000000003FFFFL});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0xFFFFFFFFFE000000L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x007FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xFFC0000000000000L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xFF80000000000000L,0x003FFFFFFFFFFFFFL,0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000001F0000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000200L});

}