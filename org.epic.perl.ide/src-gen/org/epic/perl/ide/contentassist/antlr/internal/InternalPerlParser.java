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

@SuppressWarnings("all")
public class InternalPerlParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INTERPOLATE", "RULE_LITERAL", "RULE_ID", "RULE_VERSION", "RULE_WORDS_QUOTE_LIKE", "RULE_POD", "RULE_NUMBER", "RULE_SYMBOL", "RULE_DATA", "RULE_END", "RULE_BACKTICK_STRING", "RULE_COMMAND_QUOTE_LIKE", "RULE_REGEX_QUOTE", "RULE_READLINE_QUOTE", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER", "RULE_SL_COMMENT", "'abs'", "'accept'", "'alarm'", "'atan2'", "'bind'", "'binmode'", "'bless'", "'break'", "'caller'", "'chdir'", "'chmod'", "'chomp'", "'chop'", "'chown'", "'chr'", "'chroot'", "'close'", "'closedir'", "'connect'", "'continue'", "'cos'", "'crypt'", "'dbmclose'", "'dbmopen'", "'default'", "'defined'", "'delete'", "'die'", "'do'", "'dump'", "'each'", "'else'", "'elsif'", "'endgrent'", "'endhostent'", "'endnetent'", "'endprotoent'", "'endpwent'", "'endservent'", "'eof'", "'eval'", "'evalbytes'", "'exec'", "'exists'", "'exit'", "'exp'", "'fc'", "'fcntl'", "'fileno'", "'flock'", "'for'", "'foreach'", "'fork'", "'format'", "'formline'", "'getc'", "'getgrent'", "'getgrgid'", "'getgrnam'", "'gethostbyaddr'", "'gethostbyname'", "'gethostent'", "'getlogin'", "'getnetbyaddr'", "'getnetbyname'", "'getnetent'", "'getpeername'", "'getpgrp'", "'getppid'", "'getpriority'", "'getprotobyname'", "'getprotobynumber'", "'getprotoent'", "'getpwent'", "'getpwnam'", "'getpwuid'", "'getservbyname'", "'getservbyport'", "'getservent'", "'getsockname'", "'getsockopt'", "'given'", "'glob'", "'gmtime'", "'goto'", "'grep'", "'hex'", "'if'", "'index'", "'int'", "'ioctl'", "'join'", "'keys'", "'kill'", "'last'", "'lc'", "'lcfirst'", "'length'", "'link'", "'listen'", "'local'", "'localtime'", "'lock'", "'log'", "'lstat'", "'map'", "'mkdir'", "'msgctl'", "'msgget'", "'msgrcv'", "'msgsnd'", "'my'", "'next'", "'no'", "'oct'", "'open'", "'opendir'", "'ord'", "'our'", "'pack'", "'package'", "'pipe'", "'pop'", "'pos'", "'print'", "'printf'", "'prototype'", "'push'", "'quotemeta'", "'rand'", "'read'", "'readdir'", "'readline'", "'readlink'", "'readpipe'", "'recv'", "'redo'", "'ref'", "'rename'", "'require'", "'reset'", "'return'", "'reverse'", "'rewinddir'", "'rindex'", "'rmdir'", "'say'", "'scalar'", "'seek'", "'seekdir'", "'select'", "'semctl'", "'semget'", "'semop'", "'send'", "'setgrent'", "'sethostent'", "'setnetent'", "'setpgrp'", "'setpriority'", "'setprotoent'", "'setpwent'", "'setservent'", "'setsockopt'", "'shift'", "'shmctl'", "'shmget'", "'shmread'", "'shmwrite'", "'shutdown'", "'sin'", "'sleep'", "'socket'", "'socketpair'", "'sort'", "'splice'", "'split'", "'sprintf'", "'sqrt'", "'srand'", "'stat'", "'state'", "'study'", "'sub'", "'substr'", "'symlink'", "'syscall'", "'sysopen'", "'sysread'", "'sysseek'", "'system'", "'syswrite'", "'tell'", "'telldir'", "'tie'", "'tied'", "'time'", "'times'", "'tr'", "'truncate'", "'uc'", "'ucfirst'", "'umask'", "'undef'", "'unless'", "'unlink'", "'unpack'", "'unshift'", "'untie'", "'until'", "'use'", "'utime'", "'values'", "'vec'", "'wait'", "'waitpid'", "'wantarray'", "'warn'", "'when'", "'while'", "'write'", "'y'", "'++'", "'--'", "'**'", "'!'", "'~'", "'+'", "'-'", "'=~'", "'!~'", "'*'", "'/'", "'%'", "'x'", "'<<'", "'>>'", "'lt'", "'gt'", "'le'", "'ge'", "'cmp'", "'~~'", "'=='", "'!='", "'..'", "'...'", "','", "'&'", "'|'", "'^'", "'&&'", "'||'", "'//'", "'?'", "':'", "'**='", "'+='", "'-='", "'.='", "'*='", "'/='", "'%='", "'x='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'&&='", "'||='", "'//='", "'<'", "'>'", "'<='", "'>='", "'<>'", "'=>'", "'->'", "'and'", "'or'", "'xor'", "'not'", "'eq'", "'ne'", "'-r'", "'-w'", "'-x'", "'-o'", "'-R'", "'-W'", "'-X'", "'-O'", "'-e'", "'-z'", "'-s'", "'-f'", "'-d'", "'-l'", "'-p'", "'-S'", "'-b'", "'-c'", "'-t'", "'-u'", "'-g'", "'-k'", "'-T'", "'-B'", "'-M'", "'-A'", "'-C'", "';'", "'<=>'", "'.'"
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
    public static final int RULE_READLINE_QUOTE=18;
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
    public static final int RULE_ID=7;
    public static final int T__131=131;
    public static final int T__252=252;
    public static final int T__130=130;
    public static final int T__251=251;
    public static final int RULE_DATA=13;
    public static final int RULE_INT=21;
    public static final int T__66=66;
    public static final int RULE_COMMAND_QUOTE_LIKE=16;
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
    public static final int RULE_POD=10;
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
    public static final int T__339=339;
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
    public static final int RULE_END=14;
    public static final int T__123=123;
    public static final int T__244=244;
    public static final int T__120=120;
    public static final int T__241=241;
    public static final int T__240=240;
    public static final int RULE_SL_COMMENT=24;
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
    public static final int RULE_NUMBER=11;
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
    public static final int RULE_HEX=19;
    public static final int RULE_VERSION=8;
    public static final int RULE_LITERAL=6;
    public static final int RULE_BIN=20;
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
    public static final int RULE_WORDS_QUOTE_LIKE=9;
    public static final int T__169=169;
    public static final int RULE_REGEX_QUOTE=17;
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
    public static final int RULE_WS=22;
    public static final int T__197=197;
    public static final int RULE_BACKTICK_STRING=15;
    public static final int T__196=196;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=23;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int RULE_SYMBOL=12;
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
    // InternalPerl.g:53:1: entryRulePerlDocument : rulePerlDocument EOF ;
    public final void entryRulePerlDocument() throws RecognitionException {
        try {
            // InternalPerl.g:54:1: ( rulePerlDocument EOF )
            // InternalPerl.g:55:1: rulePerlDocument EOF
            {
             before(grammarAccess.getPerlDocumentRule()); 
            pushFollow(FOLLOW_1);
            rulePerlDocument();

            state._fsp--;

             after(grammarAccess.getPerlDocumentRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:62:1: rulePerlDocument : ( ( rule__PerlDocument__Group__0 ) ) ;
    public final void rulePerlDocument() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:66:2: ( ( ( rule__PerlDocument__Group__0 ) ) )
            // InternalPerl.g:67:2: ( ( rule__PerlDocument__Group__0 ) )
            {
            // InternalPerl.g:67:2: ( ( rule__PerlDocument__Group__0 ) )
            // InternalPerl.g:68:3: ( rule__PerlDocument__Group__0 )
            {
             before(grammarAccess.getPerlDocumentAccess().getGroup()); 
            // InternalPerl.g:69:3: ( rule__PerlDocument__Group__0 )
            // InternalPerl.g:69:4: rule__PerlDocument__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PerlDocument__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPerlDocumentAccess().getGroup()); 

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
    // InternalPerl.g:78:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalPerl.g:79:1: ( ruleElement EOF )
            // InternalPerl.g:80:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:87:1: ruleElement : ( ( rule__Element__Alternatives ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:91:2: ( ( ( rule__Element__Alternatives ) ) )
            // InternalPerl.g:92:2: ( ( rule__Element__Alternatives ) )
            {
            // InternalPerl.g:92:2: ( ( rule__Element__Alternatives ) )
            // InternalPerl.g:93:3: ( rule__Element__Alternatives )
            {
             before(grammarAccess.getElementAccess().getAlternatives()); 
            // InternalPerl.g:94:3: ( rule__Element__Alternatives )
            // InternalPerl.g:94:4: rule__Element__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Element__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getAlternatives()); 

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
    // InternalPerl.g:103:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // InternalPerl.g:104:1: ( ruleNode EOF )
            // InternalPerl.g:105:1: ruleNode EOF
            {
             before(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getNodeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:112:1: ruleNode : ( ruleStatementNode ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:116:2: ( ( ruleStatementNode ) )
            // InternalPerl.g:117:2: ( ruleStatementNode )
            {
            // InternalPerl.g:117:2: ( ruleStatementNode )
            // InternalPerl.g:118:3: ruleStatementNode
            {
             before(grammarAccess.getNodeAccess().getStatementNodeParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleStatementNode();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getStatementNodeParserRuleCall()); 

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
    // InternalPerl.g:128:1: entryRuleStatementNode : ruleStatementNode EOF ;
    public final void entryRuleStatementNode() throws RecognitionException {
        try {
            // InternalPerl.g:129:1: ( ruleStatementNode EOF )
            // InternalPerl.g:130:1: ruleStatementNode EOF
            {
             before(grammarAccess.getStatementNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleStatementNode();

            state._fsp--;

             after(grammarAccess.getStatementNodeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:137:1: ruleStatementNode : ( ( rule__StatementNode__Group__0 ) ) ;
    public final void ruleStatementNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:141:2: ( ( ( rule__StatementNode__Group__0 ) ) )
            // InternalPerl.g:142:2: ( ( rule__StatementNode__Group__0 ) )
            {
            // InternalPerl.g:142:2: ( ( rule__StatementNode__Group__0 ) )
            // InternalPerl.g:143:3: ( rule__StatementNode__Group__0 )
            {
             before(grammarAccess.getStatementNodeAccess().getGroup()); 
            // InternalPerl.g:144:3: ( rule__StatementNode__Group__0 )
            // InternalPerl.g:144:4: rule__StatementNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StatementNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStatementNodeAccess().getGroup()); 

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


    // $ANTLR start "entryRulePackageStatement"
    // InternalPerl.g:153:1: entryRulePackageStatement : rulePackageStatement EOF ;
    public final void entryRulePackageStatement() throws RecognitionException {
        try {
            // InternalPerl.g:154:1: ( rulePackageStatement EOF )
            // InternalPerl.g:155:1: rulePackageStatement EOF
            {
             before(grammarAccess.getPackageStatementRule()); 
            pushFollow(FOLLOW_1);
            rulePackageStatement();

            state._fsp--;

             after(grammarAccess.getPackageStatementRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:162:1: rulePackageStatement : ( ( rule__PackageStatement__Group__0 ) ) ;
    public final void rulePackageStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:166:2: ( ( ( rule__PackageStatement__Group__0 ) ) )
            // InternalPerl.g:167:2: ( ( rule__PackageStatement__Group__0 ) )
            {
            // InternalPerl.g:167:2: ( ( rule__PackageStatement__Group__0 ) )
            // InternalPerl.g:168:3: ( rule__PackageStatement__Group__0 )
            {
             before(grammarAccess.getPackageStatementAccess().getGroup()); 
            // InternalPerl.g:169:3: ( rule__PackageStatement__Group__0 )
            // InternalPerl.g:169:4: rule__PackageStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PackageStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPackageStatementAccess().getGroup()); 

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


    // $ANTLR start "entryRuleIncludeStatement"
    // InternalPerl.g:178:1: entryRuleIncludeStatement : ruleIncludeStatement EOF ;
    public final void entryRuleIncludeStatement() throws RecognitionException {
        try {
            // InternalPerl.g:179:1: ( ruleIncludeStatement EOF )
            // InternalPerl.g:180:1: ruleIncludeStatement EOF
            {
             before(grammarAccess.getIncludeStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleIncludeStatement();

            state._fsp--;

             after(grammarAccess.getIncludeStatementRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIncludeStatement"


    // $ANTLR start "ruleIncludeStatement"
    // InternalPerl.g:187:1: ruleIncludeStatement : ( ( rule__IncludeStatement__Alternatives ) ) ;
    public final void ruleIncludeStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:191:2: ( ( ( rule__IncludeStatement__Alternatives ) ) )
            // InternalPerl.g:192:2: ( ( rule__IncludeStatement__Alternatives ) )
            {
            // InternalPerl.g:192:2: ( ( rule__IncludeStatement__Alternatives ) )
            // InternalPerl.g:193:3: ( rule__IncludeStatement__Alternatives )
            {
             before(grammarAccess.getIncludeStatementAccess().getAlternatives()); 
            // InternalPerl.g:194:3: ( rule__IncludeStatement__Alternatives )
            // InternalPerl.g:194:4: rule__IncludeStatement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__IncludeStatement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIncludeStatementAccess().getAlternatives()); 

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
    // $ANTLR end "ruleIncludeStatement"


    // $ANTLR start "entryRuleRequireInclude"
    // InternalPerl.g:203:1: entryRuleRequireInclude : ruleRequireInclude EOF ;
    public final void entryRuleRequireInclude() throws RecognitionException {
        try {
            // InternalPerl.g:204:1: ( ruleRequireInclude EOF )
            // InternalPerl.g:205:1: ruleRequireInclude EOF
            {
             before(grammarAccess.getRequireIncludeRule()); 
            pushFollow(FOLLOW_1);
            ruleRequireInclude();

            state._fsp--;

             after(grammarAccess.getRequireIncludeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRequireInclude"


    // $ANTLR start "ruleRequireInclude"
    // InternalPerl.g:212:1: ruleRequireInclude : ( ( rule__RequireInclude__Group__0 ) ) ;
    public final void ruleRequireInclude() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:216:2: ( ( ( rule__RequireInclude__Group__0 ) ) )
            // InternalPerl.g:217:2: ( ( rule__RequireInclude__Group__0 ) )
            {
            // InternalPerl.g:217:2: ( ( rule__RequireInclude__Group__0 ) )
            // InternalPerl.g:218:3: ( rule__RequireInclude__Group__0 )
            {
             before(grammarAccess.getRequireIncludeAccess().getGroup()); 
            // InternalPerl.g:219:3: ( rule__RequireInclude__Group__0 )
            // InternalPerl.g:219:4: rule__RequireInclude__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RequireInclude__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRequireIncludeAccess().getGroup()); 

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
    // $ANTLR end "ruleRequireInclude"


    // $ANTLR start "entryRuleUseInclude"
    // InternalPerl.g:228:1: entryRuleUseInclude : ruleUseInclude EOF ;
    public final void entryRuleUseInclude() throws RecognitionException {
        try {
            // InternalPerl.g:229:1: ( ruleUseInclude EOF )
            // InternalPerl.g:230:1: ruleUseInclude EOF
            {
             before(grammarAccess.getUseIncludeRule()); 
            pushFollow(FOLLOW_1);
            ruleUseInclude();

            state._fsp--;

             after(grammarAccess.getUseIncludeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUseInclude"


    // $ANTLR start "ruleUseInclude"
    // InternalPerl.g:237:1: ruleUseInclude : ( ( rule__UseInclude__Group__0 ) ) ;
    public final void ruleUseInclude() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:241:2: ( ( ( rule__UseInclude__Group__0 ) ) )
            // InternalPerl.g:242:2: ( ( rule__UseInclude__Group__0 ) )
            {
            // InternalPerl.g:242:2: ( ( rule__UseInclude__Group__0 ) )
            // InternalPerl.g:243:3: ( rule__UseInclude__Group__0 )
            {
             before(grammarAccess.getUseIncludeAccess().getGroup()); 
            // InternalPerl.g:244:3: ( rule__UseInclude__Group__0 )
            // InternalPerl.g:244:4: rule__UseInclude__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UseInclude__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUseIncludeAccess().getGroup()); 

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
    // $ANTLR end "ruleUseInclude"


    // $ANTLR start "entryRuleToken"
    // InternalPerl.g:253:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // InternalPerl.g:254:1: ( ruleToken EOF )
            // InternalPerl.g:255:1: ruleToken EOF
            {
             before(grammarAccess.getTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleToken();

            state._fsp--;

             after(grammarAccess.getTokenRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:262:1: ruleToken : ( ( rule__Token__Alternatives ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:266:2: ( ( ( rule__Token__Alternatives ) ) )
            // InternalPerl.g:267:2: ( ( rule__Token__Alternatives ) )
            {
            // InternalPerl.g:267:2: ( ( rule__Token__Alternatives ) )
            // InternalPerl.g:268:3: ( rule__Token__Alternatives )
            {
             before(grammarAccess.getTokenAccess().getAlternatives()); 
            // InternalPerl.g:269:3: ( rule__Token__Alternatives )
            // InternalPerl.g:269:4: rule__Token__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Token__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getAlternatives()); 

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
    // InternalPerl.g:278:1: entryRuleQuoteToken : ruleQuoteToken EOF ;
    public final void entryRuleQuoteToken() throws RecognitionException {
        try {
            // InternalPerl.g:279:1: ( ruleQuoteToken EOF )
            // InternalPerl.g:280:1: ruleQuoteToken EOF
            {
             before(grammarAccess.getQuoteTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleQuoteToken();

            state._fsp--;

             after(grammarAccess.getQuoteTokenRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:287:1: ruleQuoteToken : ( ( rule__QuoteToken__Group__0 ) ) ;
    public final void ruleQuoteToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:291:2: ( ( ( rule__QuoteToken__Group__0 ) ) )
            // InternalPerl.g:292:2: ( ( rule__QuoteToken__Group__0 ) )
            {
            // InternalPerl.g:292:2: ( ( rule__QuoteToken__Group__0 ) )
            // InternalPerl.g:293:3: ( rule__QuoteToken__Group__0 )
            {
             before(grammarAccess.getQuoteTokenAccess().getGroup()); 
            // InternalPerl.g:294:3: ( rule__QuoteToken__Group__0 )
            // InternalPerl.g:294:4: rule__QuoteToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QuoteToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQuoteTokenAccess().getGroup()); 

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
    // InternalPerl.g:303:1: entryRuleQuoteLikeToken : ruleQuoteLikeToken EOF ;
    public final void entryRuleQuoteLikeToken() throws RecognitionException {
        try {
            // InternalPerl.g:304:1: ( ruleQuoteLikeToken EOF )
            // InternalPerl.g:305:1: ruleQuoteLikeToken EOF
            {
             before(grammarAccess.getQuoteLikeTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleQuoteLikeToken();

            state._fsp--;

             after(grammarAccess.getQuoteLikeTokenRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:312:1: ruleQuoteLikeToken : ( ( rule__QuoteLikeToken__Alternatives ) ) ;
    public final void ruleQuoteLikeToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:316:2: ( ( ( rule__QuoteLikeToken__Alternatives ) ) )
            // InternalPerl.g:317:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            {
            // InternalPerl.g:317:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            // InternalPerl.g:318:3: ( rule__QuoteLikeToken__Alternatives )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getAlternatives()); 
            // InternalPerl.g:319:3: ( rule__QuoteLikeToken__Alternatives )
            // InternalPerl.g:319:4: rule__QuoteLikeToken__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getQuoteLikeTokenAccess().getAlternatives()); 

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
    // InternalPerl.g:328:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalPerl.g:329:1: ( ruleWord EOF )
            // InternalPerl.g:330:1: ruleWord EOF
            {
             before(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_1);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getWordRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:337:1: ruleWord : ( ruleKeyword ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:341:2: ( ( ruleKeyword ) )
            // InternalPerl.g:342:2: ( ruleKeyword )
            {
            // InternalPerl.g:342:2: ( ruleKeyword )
            // InternalPerl.g:343:3: ruleKeyword
            {
             before(grammarAccess.getWordAccess().getKeywordParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getWordAccess().getKeywordParserRuleCall()); 

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
    // InternalPerl.g:353:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalPerl.g:354:1: ( ruleKeyword EOF )
            // InternalPerl.g:355:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_1);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:362:1: ruleKeyword : ( ( rule__Keyword__Alternatives ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:366:2: ( ( ( rule__Keyword__Alternatives ) ) )
            // InternalPerl.g:367:2: ( ( rule__Keyword__Alternatives ) )
            {
            // InternalPerl.g:367:2: ( ( rule__Keyword__Alternatives ) )
            // InternalPerl.g:368:3: ( rule__Keyword__Alternatives )
            {
             before(grammarAccess.getKeywordAccess().getAlternatives()); 
            // InternalPerl.g:369:3: ( rule__Keyword__Alternatives )
            // InternalPerl.g:369:4: rule__Keyword__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Keyword__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getKeywordAccess().getAlternatives()); 

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
    // InternalPerl.g:378:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalPerl.g:379:1: ( ruleOperator EOF )
            // InternalPerl.g:380:1: ruleOperator EOF
            {
             before(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:387:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:391:2: ( ( ( rule__Operator__Alternatives ) ) )
            // InternalPerl.g:392:2: ( ( rule__Operator__Alternatives ) )
            {
            // InternalPerl.g:392:2: ( ( rule__Operator__Alternatives ) )
            // InternalPerl.g:393:3: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // InternalPerl.g:394:3: ( rule__Operator__Alternatives )
            // InternalPerl.g:394:4: rule__Operator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Operator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getAlternatives()); 

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
    // InternalPerl.g:403:1: entryRuleFileTestOperator : ruleFileTestOperator EOF ;
    public final void entryRuleFileTestOperator() throws RecognitionException {
        try {
            // InternalPerl.g:404:1: ( ruleFileTestOperator EOF )
            // InternalPerl.g:405:1: ruleFileTestOperator EOF
            {
             before(grammarAccess.getFileTestOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleFileTestOperator();

            state._fsp--;

             after(grammarAccess.getFileTestOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:412:1: ruleFileTestOperator : ( ( rule__FileTestOperator__Alternatives ) ) ;
    public final void ruleFileTestOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:416:2: ( ( ( rule__FileTestOperator__Alternatives ) ) )
            // InternalPerl.g:417:2: ( ( rule__FileTestOperator__Alternatives ) )
            {
            // InternalPerl.g:417:2: ( ( rule__FileTestOperator__Alternatives ) )
            // InternalPerl.g:418:3: ( rule__FileTestOperator__Alternatives )
            {
             before(grammarAccess.getFileTestOperatorAccess().getAlternatives()); 
            // InternalPerl.g:419:3: ( rule__FileTestOperator__Alternatives )
            // InternalPerl.g:419:4: rule__FileTestOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FileTestOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFileTestOperatorAccess().getAlternatives()); 

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


    // $ANTLR start "rule__Element__Alternatives"
    // InternalPerl.g:427:1: rule__Element__Alternatives : ( ( ruleNode ) | ( ruleToken ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:431:1: ( ( ruleNode ) | ( ruleToken ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==145) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==RULE_ID) ) {
                    alt1=1;
                }
                else if ( (LA1_1==EOF||(LA1_1>=RULE_STRING && LA1_1<=RULE_LITERAL)||(LA1_1>=RULE_WORDS_QUOTE_LIKE && LA1_1<=RULE_READLINE_QUOTE)||(LA1_1>=25 && LA1_1<=336)||LA1_1==338) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==164) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==EOF||(LA1_2>=RULE_STRING && LA1_2<=RULE_LITERAL)||(LA1_2>=RULE_WORDS_QUOTE_LIKE && LA1_2<=RULE_READLINE_QUOTE)||(LA1_2>=25 && LA1_2<=336)||LA1_2==338) ) {
                    alt1=2;
                }
                else if ( (LA1_2==RULE_VERSION) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==235) ) {
                int LA1_3 = input.LA(2);

                if ( ((LA1_3>=RULE_ID && LA1_3<=RULE_VERSION)) ) {
                    alt1=1;
                }
                else if ( (LA1_3==EOF||(LA1_3>=RULE_STRING && LA1_3<=RULE_LITERAL)||(LA1_3>=RULE_WORDS_QUOTE_LIKE && LA1_3<=RULE_READLINE_QUOTE)||(LA1_3>=25 && LA1_3<=336)||LA1_3==338) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;
                }
            }
            else if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_LITERAL)||(LA1_0>=RULE_WORDS_QUOTE_LIKE && LA1_0<=RULE_READLINE_QUOTE)||(LA1_0>=25 && LA1_0<=144)||(LA1_0>=146 && LA1_0<=163)||(LA1_0>=165 && LA1_0<=234)||(LA1_0>=236 && LA1_0<=336)||LA1_0==338) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalPerl.g:432:2: ( ruleNode )
                    {
                    // InternalPerl.g:432:2: ( ruleNode )
                    // InternalPerl.g:433:3: ruleNode
                    {
                     before(grammarAccess.getElementAccess().getNodeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNode();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getNodeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:438:2: ( ruleToken )
                    {
                    // InternalPerl.g:438:2: ( ruleToken )
                    // InternalPerl.g:439:3: ruleToken
                    {
                     before(grammarAccess.getElementAccess().getTokenParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleToken();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getTokenParserRuleCall_1()); 

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


    // $ANTLR start "rule__StatementNode__Alternatives_0"
    // InternalPerl.g:448:1: rule__StatementNode__Alternatives_0 : ( ( rulePackageStatement ) | ( ruleIncludeStatement ) );
    public final void rule__StatementNode__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:452:1: ( ( rulePackageStatement ) | ( ruleIncludeStatement ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==145) ) {
                alt2=1;
            }
            else if ( (LA2_0==164||LA2_0==235) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalPerl.g:453:2: ( rulePackageStatement )
                    {
                    // InternalPerl.g:453:2: ( rulePackageStatement )
                    // InternalPerl.g:454:3: rulePackageStatement
                    {
                     before(grammarAccess.getStatementNodeAccess().getPackageStatementParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    rulePackageStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementNodeAccess().getPackageStatementParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:459:2: ( ruleIncludeStatement )
                    {
                    // InternalPerl.g:459:2: ( ruleIncludeStatement )
                    // InternalPerl.g:460:3: ruleIncludeStatement
                    {
                     before(grammarAccess.getStatementNodeAccess().getIncludeStatementParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleIncludeStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementNodeAccess().getIncludeStatementParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__StatementNode__Alternatives_0"


    // $ANTLR start "rule__IncludeStatement__Alternatives"
    // InternalPerl.g:469:1: rule__IncludeStatement__Alternatives : ( ( ruleRequireInclude ) | ( ruleUseInclude ) );
    public final void rule__IncludeStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:473:1: ( ( ruleRequireInclude ) | ( ruleUseInclude ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==164) ) {
                alt3=1;
            }
            else if ( (LA3_0==235) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalPerl.g:474:2: ( ruleRequireInclude )
                    {
                    // InternalPerl.g:474:2: ( ruleRequireInclude )
                    // InternalPerl.g:475:3: ruleRequireInclude
                    {
                     before(grammarAccess.getIncludeStatementAccess().getRequireIncludeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleRequireInclude();

                    state._fsp--;

                     after(grammarAccess.getIncludeStatementAccess().getRequireIncludeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:480:2: ( ruleUseInclude )
                    {
                    // InternalPerl.g:480:2: ( ruleUseInclude )
                    // InternalPerl.g:481:3: ruleUseInclude
                    {
                     before(grammarAccess.getIncludeStatementAccess().getUseIncludeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleUseInclude();

                    state._fsp--;

                     after(grammarAccess.getIncludeStatementAccess().getUseIncludeParserRuleCall_1()); 

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
    // $ANTLR end "rule__IncludeStatement__Alternatives"


    // $ANTLR start "rule__UseInclude__Alternatives_2"
    // InternalPerl.g:490:1: rule__UseInclude__Alternatives_2 : ( ( ( rule__UseInclude__VersionAssignment_2_0 ) ) | ( ( rule__UseInclude__Group_2_1__0 ) ) );
    public final void rule__UseInclude__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:494:1: ( ( ( rule__UseInclude__VersionAssignment_2_0 ) ) | ( ( rule__UseInclude__Group_2_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_VERSION) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalPerl.g:495:2: ( ( rule__UseInclude__VersionAssignment_2_0 ) )
                    {
                    // InternalPerl.g:495:2: ( ( rule__UseInclude__VersionAssignment_2_0 ) )
                    // InternalPerl.g:496:3: ( rule__UseInclude__VersionAssignment_2_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getVersionAssignment_2_0()); 
                    // InternalPerl.g:497:3: ( rule__UseInclude__VersionAssignment_2_0 )
                    // InternalPerl.g:497:4: rule__UseInclude__VersionAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UseInclude__VersionAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUseIncludeAccess().getVersionAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:501:2: ( ( rule__UseInclude__Group_2_1__0 ) )
                    {
                    // InternalPerl.g:501:2: ( ( rule__UseInclude__Group_2_1__0 ) )
                    // InternalPerl.g:502:3: ( rule__UseInclude__Group_2_1__0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getGroup_2_1()); 
                    // InternalPerl.g:503:3: ( rule__UseInclude__Group_2_1__0 )
                    // InternalPerl.g:503:4: rule__UseInclude__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UseInclude__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUseIncludeAccess().getGroup_2_1()); 

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
    // $ANTLR end "rule__UseInclude__Alternatives_2"


    // $ANTLR start "rule__UseInclude__Alternatives_2_1_1"
    // InternalPerl.g:511:1: rule__UseInclude__Alternatives_2_1_1 : ( ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) ) | ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) ) );
    public final void rule__UseInclude__Alternatives_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:515:1: ( ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) ) | ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_LITERAL)) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_WORDS_QUOTE_LIKE) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalPerl.g:516:2: ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) )
                    {
                    // InternalPerl.g:516:2: ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) )
                    // InternalPerl.g:517:3: ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getStringArgumentAssignment_2_1_1_0()); 
                    // InternalPerl.g:518:3: ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 )
                    // InternalPerl.g:518:4: rule__UseInclude__StringArgumentAssignment_2_1_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UseInclude__StringArgumentAssignment_2_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUseIncludeAccess().getStringArgumentAssignment_2_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:522:2: ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) )
                    {
                    // InternalPerl.g:522:2: ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) )
                    // InternalPerl.g:523:3: ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getQwArgumentAssignment_2_1_1_1()); 
                    // InternalPerl.g:524:3: ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 )
                    // InternalPerl.g:524:4: rule__UseInclude__QwArgumentAssignment_2_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__UseInclude__QwArgumentAssignment_2_1_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getUseIncludeAccess().getQwArgumentAssignment_2_1_1_1()); 

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
    // $ANTLR end "rule__UseInclude__Alternatives_2_1_1"


    // $ANTLR start "rule__Token__Alternatives"
    // InternalPerl.g:532:1: rule__Token__Alternatives : ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ruleQuoteToken ) | ( ( rule__Token__Group_8__0 ) ) | ( ( rule__Token__Group_9__0 ) ) );
    public final void rule__Token__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:536:1: ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ruleQuoteToken ) | ( ( rule__Token__Group_8__0 ) ) | ( ( rule__Token__Group_9__0 ) ) )
            int alt6=10;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_POD) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_NUMBER) ) {
                alt6=2;
            }
            else if ( ((LA6_0>=25 && LA6_0<=246)) ) {
                alt6=3;
            }
            else if ( (LA6_0==RULE_SYMBOL) ) {
                alt6=4;
            }
            else if ( (LA6_0==RULE_WORDS_QUOTE_LIKE||(LA6_0>=RULE_BACKTICK_STRING && LA6_0<=RULE_READLINE_QUOTE)) ) {
                alt6=5;
            }
            else if ( ((LA6_0>=310 && LA6_0<=336)) ) {
                alt6=6;
            }
            else if ( ((LA6_0>=247 && LA6_0<=309)||LA6_0==338) ) {
                alt6=7;
            }
            else if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_LITERAL)) ) {
                alt6=8;
            }
            else if ( (LA6_0==RULE_DATA) ) {
                alt6=9;
            }
            else if ( (LA6_0==RULE_END) ) {
                alt6=10;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalPerl.g:537:2: ( ( rule__Token__Group_0__0 ) )
                    {
                    // InternalPerl.g:537:2: ( ( rule__Token__Group_0__0 ) )
                    // InternalPerl.g:538:3: ( rule__Token__Group_0__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_0()); 
                    // InternalPerl.g:539:3: ( rule__Token__Group_0__0 )
                    // InternalPerl.g:539:4: rule__Token__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:543:2: ( ( rule__Token__Group_1__0 ) )
                    {
                    // InternalPerl.g:543:2: ( ( rule__Token__Group_1__0 ) )
                    // InternalPerl.g:544:3: ( rule__Token__Group_1__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_1()); 
                    // InternalPerl.g:545:3: ( rule__Token__Group_1__0 )
                    // InternalPerl.g:545:4: rule__Token__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:549:2: ( ( rule__Token__Group_2__0 ) )
                    {
                    // InternalPerl.g:549:2: ( ( rule__Token__Group_2__0 ) )
                    // InternalPerl.g:550:3: ( rule__Token__Group_2__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_2()); 
                    // InternalPerl.g:551:3: ( rule__Token__Group_2__0 )
                    // InternalPerl.g:551:4: rule__Token__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:555:2: ( ( rule__Token__Group_3__0 ) )
                    {
                    // InternalPerl.g:555:2: ( ( rule__Token__Group_3__0 ) )
                    // InternalPerl.g:556:3: ( rule__Token__Group_3__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_3()); 
                    // InternalPerl.g:557:3: ( rule__Token__Group_3__0 )
                    // InternalPerl.g:557:4: rule__Token__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:561:2: ( ruleQuoteLikeToken )
                    {
                    // InternalPerl.g:561:2: ( ruleQuoteLikeToken )
                    // InternalPerl.g:562:3: ruleQuoteLikeToken
                    {
                     before(grammarAccess.getTokenAccess().getQuoteLikeTokenParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleQuoteLikeToken();

                    state._fsp--;

                     after(grammarAccess.getTokenAccess().getQuoteLikeTokenParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:567:2: ( ( rule__Token__Group_5__0 ) )
                    {
                    // InternalPerl.g:567:2: ( ( rule__Token__Group_5__0 ) )
                    // InternalPerl.g:568:3: ( rule__Token__Group_5__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_5()); 
                    // InternalPerl.g:569:3: ( rule__Token__Group_5__0 )
                    // InternalPerl.g:569:4: rule__Token__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:573:2: ( ( rule__Token__Group_6__0 ) )
                    {
                    // InternalPerl.g:573:2: ( ( rule__Token__Group_6__0 ) )
                    // InternalPerl.g:574:3: ( rule__Token__Group_6__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_6()); 
                    // InternalPerl.g:575:3: ( rule__Token__Group_6__0 )
                    // InternalPerl.g:575:4: rule__Token__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:579:2: ( ruleQuoteToken )
                    {
                    // InternalPerl.g:579:2: ( ruleQuoteToken )
                    // InternalPerl.g:580:3: ruleQuoteToken
                    {
                     before(grammarAccess.getTokenAccess().getQuoteTokenParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleQuoteToken();

                    state._fsp--;

                     after(grammarAccess.getTokenAccess().getQuoteTokenParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:585:2: ( ( rule__Token__Group_8__0 ) )
                    {
                    // InternalPerl.g:585:2: ( ( rule__Token__Group_8__0 ) )
                    // InternalPerl.g:586:3: ( rule__Token__Group_8__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_8()); 
                    // InternalPerl.g:587:3: ( rule__Token__Group_8__0 )
                    // InternalPerl.g:587:4: rule__Token__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:591:2: ( ( rule__Token__Group_9__0 ) )
                    {
                    // InternalPerl.g:591:2: ( ( rule__Token__Group_9__0 ) )
                    // InternalPerl.g:592:3: ( rule__Token__Group_9__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_9()); 
                    // InternalPerl.g:593:3: ( rule__Token__Group_9__0 )
                    // InternalPerl.g:593:4: rule__Token__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_9()); 

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
    // InternalPerl.g:601:1: rule__QuoteToken__ContentAlternatives_1_0 : ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) );
    public final void rule__QuoteToken__ContentAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:605:1: ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt7=1;
                }
                break;
            case RULE_INTERPOLATE:
                {
                alt7=2;
                }
                break;
            case RULE_LITERAL:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalPerl.g:606:2: ( RULE_STRING )
                    {
                    // InternalPerl.g:606:2: ( RULE_STRING )
                    // InternalPerl.g:607:3: RULE_STRING
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:612:2: ( RULE_INTERPOLATE )
                    {
                    // InternalPerl.g:612:2: ( RULE_INTERPOLATE )
                    // InternalPerl.g:613:3: RULE_INTERPOLATE
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 
                    match(input,RULE_INTERPOLATE,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:618:2: ( RULE_LITERAL )
                    {
                    // InternalPerl.g:618:2: ( RULE_LITERAL )
                    // InternalPerl.g:619:3: RULE_LITERAL
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentLITERALTerminalRuleCall_1_0_2()); 
                    match(input,RULE_LITERAL,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentLITERALTerminalRuleCall_1_0_2()); 

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
    // InternalPerl.g:628:1: rule__QuoteLikeToken__Alternatives : ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) );
    public final void rule__QuoteLikeToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:632:1: ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) )
            int alt8=5;
            switch ( input.LA(1) ) {
            case RULE_BACKTICK_STRING:
                {
                alt8=1;
                }
                break;
            case RULE_WORDS_QUOTE_LIKE:
                {
                alt8=2;
                }
                break;
            case RULE_COMMAND_QUOTE_LIKE:
                {
                alt8=3;
                }
                break;
            case RULE_REGEX_QUOTE:
                {
                alt8=4;
                }
                break;
            case RULE_READLINE_QUOTE:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalPerl.g:633:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    {
                    // InternalPerl.g:633:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    // InternalPerl.g:634:3: ( rule__QuoteLikeToken__Group_0__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_0()); 
                    // InternalPerl.g:635:3: ( rule__QuoteLikeToken__Group_0__0 )
                    // InternalPerl.g:635:4: rule__QuoteLikeToken__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuoteLikeToken__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getQuoteLikeTokenAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:639:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    {
                    // InternalPerl.g:639:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    // InternalPerl.g:640:3: ( rule__QuoteLikeToken__Group_1__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_1()); 
                    // InternalPerl.g:641:3: ( rule__QuoteLikeToken__Group_1__0 )
                    // InternalPerl.g:641:4: rule__QuoteLikeToken__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuoteLikeToken__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getQuoteLikeTokenAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:645:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    {
                    // InternalPerl.g:645:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    // InternalPerl.g:646:3: ( rule__QuoteLikeToken__Group_2__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_2()); 
                    // InternalPerl.g:647:3: ( rule__QuoteLikeToken__Group_2__0 )
                    // InternalPerl.g:647:4: rule__QuoteLikeToken__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuoteLikeToken__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getQuoteLikeTokenAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:651:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    {
                    // InternalPerl.g:651:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    // InternalPerl.g:652:3: ( rule__QuoteLikeToken__Group_3__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_3()); 
                    // InternalPerl.g:653:3: ( rule__QuoteLikeToken__Group_3__0 )
                    // InternalPerl.g:653:4: rule__QuoteLikeToken__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuoteLikeToken__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getQuoteLikeTokenAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:657:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    {
                    // InternalPerl.g:657:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    // InternalPerl.g:658:3: ( rule__QuoteLikeToken__Group_4__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_4()); 
                    // InternalPerl.g:659:3: ( rule__QuoteLikeToken__Group_4__0 )
                    // InternalPerl.g:659:4: rule__QuoteLikeToken__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuoteLikeToken__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getQuoteLikeTokenAccess().getGroup_4()); 

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
    // InternalPerl.g:667:1: rule__Keyword__Alternatives : ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) );
    public final void rule__Keyword__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:671:1: ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) )
            int alt9=222;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt9=1;
                }
                break;
            case 26:
                {
                alt9=2;
                }
                break;
            case 27:
                {
                alt9=3;
                }
                break;
            case 28:
                {
                alt9=4;
                }
                break;
            case 29:
                {
                alt9=5;
                }
                break;
            case 30:
                {
                alt9=6;
                }
                break;
            case 31:
                {
                alt9=7;
                }
                break;
            case 32:
                {
                alt9=8;
                }
                break;
            case 33:
                {
                alt9=9;
                }
                break;
            case 34:
                {
                alt9=10;
                }
                break;
            case 35:
                {
                alt9=11;
                }
                break;
            case 36:
                {
                alt9=12;
                }
                break;
            case 37:
                {
                alt9=13;
                }
                break;
            case 38:
                {
                alt9=14;
                }
                break;
            case 39:
                {
                alt9=15;
                }
                break;
            case 40:
                {
                alt9=16;
                }
                break;
            case 41:
                {
                alt9=17;
                }
                break;
            case 42:
                {
                alt9=18;
                }
                break;
            case 43:
                {
                alt9=19;
                }
                break;
            case 44:
                {
                alt9=20;
                }
                break;
            case 45:
                {
                alt9=21;
                }
                break;
            case 46:
                {
                alt9=22;
                }
                break;
            case 47:
                {
                alt9=23;
                }
                break;
            case 48:
                {
                alt9=24;
                }
                break;
            case 49:
                {
                alt9=25;
                }
                break;
            case 50:
                {
                alt9=26;
                }
                break;
            case 51:
                {
                alt9=27;
                }
                break;
            case 52:
                {
                alt9=28;
                }
                break;
            case 53:
                {
                alt9=29;
                }
                break;
            case 54:
                {
                alt9=30;
                }
                break;
            case 55:
                {
                alt9=31;
                }
                break;
            case 56:
                {
                alt9=32;
                }
                break;
            case 57:
                {
                alt9=33;
                }
                break;
            case 58:
                {
                alt9=34;
                }
                break;
            case 59:
                {
                alt9=35;
                }
                break;
            case 60:
                {
                alt9=36;
                }
                break;
            case 61:
                {
                alt9=37;
                }
                break;
            case 62:
                {
                alt9=38;
                }
                break;
            case 63:
                {
                alt9=39;
                }
                break;
            case 64:
                {
                alt9=40;
                }
                break;
            case 65:
                {
                alt9=41;
                }
                break;
            case 66:
                {
                alt9=42;
                }
                break;
            case 67:
                {
                alt9=43;
                }
                break;
            case 68:
                {
                alt9=44;
                }
                break;
            case 69:
                {
                alt9=45;
                }
                break;
            case 70:
                {
                alt9=46;
                }
                break;
            case 71:
                {
                alt9=47;
                }
                break;
            case 72:
                {
                alt9=48;
                }
                break;
            case 73:
                {
                alt9=49;
                }
                break;
            case 74:
                {
                alt9=50;
                }
                break;
            case 75:
                {
                alt9=51;
                }
                break;
            case 76:
                {
                alt9=52;
                }
                break;
            case 77:
                {
                alt9=53;
                }
                break;
            case 78:
                {
                alt9=54;
                }
                break;
            case 79:
                {
                alt9=55;
                }
                break;
            case 80:
                {
                alt9=56;
                }
                break;
            case 81:
                {
                alt9=57;
                }
                break;
            case 82:
                {
                alt9=58;
                }
                break;
            case 83:
                {
                alt9=59;
                }
                break;
            case 84:
                {
                alt9=60;
                }
                break;
            case 85:
                {
                alt9=61;
                }
                break;
            case 86:
                {
                alt9=62;
                }
                break;
            case 87:
                {
                alt9=63;
                }
                break;
            case 88:
                {
                alt9=64;
                }
                break;
            case 89:
                {
                alt9=65;
                }
                break;
            case 90:
                {
                alt9=66;
                }
                break;
            case 91:
                {
                alt9=67;
                }
                break;
            case 92:
                {
                alt9=68;
                }
                break;
            case 93:
                {
                alt9=69;
                }
                break;
            case 94:
                {
                alt9=70;
                }
                break;
            case 95:
                {
                alt9=71;
                }
                break;
            case 96:
                {
                alt9=72;
                }
                break;
            case 97:
                {
                alt9=73;
                }
                break;
            case 98:
                {
                alt9=74;
                }
                break;
            case 99:
                {
                alt9=75;
                }
                break;
            case 100:
                {
                alt9=76;
                }
                break;
            case 101:
                {
                alt9=77;
                }
                break;
            case 102:
                {
                alt9=78;
                }
                break;
            case 103:
                {
                alt9=79;
                }
                break;
            case 104:
                {
                alt9=80;
                }
                break;
            case 105:
                {
                alt9=81;
                }
                break;
            case 106:
                {
                alt9=82;
                }
                break;
            case 107:
                {
                alt9=83;
                }
                break;
            case 108:
                {
                alt9=84;
                }
                break;
            case 109:
                {
                alt9=85;
                }
                break;
            case 110:
                {
                alt9=86;
                }
                break;
            case 111:
                {
                alt9=87;
                }
                break;
            case 112:
                {
                alt9=88;
                }
                break;
            case 113:
                {
                alt9=89;
                }
                break;
            case 114:
                {
                alt9=90;
                }
                break;
            case 115:
                {
                alt9=91;
                }
                break;
            case 116:
                {
                alt9=92;
                }
                break;
            case 117:
                {
                alt9=93;
                }
                break;
            case 118:
                {
                alt9=94;
                }
                break;
            case 119:
                {
                alt9=95;
                }
                break;
            case 120:
                {
                alt9=96;
                }
                break;
            case 121:
                {
                alt9=97;
                }
                break;
            case 122:
                {
                alt9=98;
                }
                break;
            case 123:
                {
                alt9=99;
                }
                break;
            case 124:
                {
                alt9=100;
                }
                break;
            case 125:
                {
                alt9=101;
                }
                break;
            case 126:
                {
                alt9=102;
                }
                break;
            case 127:
                {
                alt9=103;
                }
                break;
            case 128:
                {
                alt9=104;
                }
                break;
            case 129:
                {
                alt9=105;
                }
                break;
            case 130:
                {
                alt9=106;
                }
                break;
            case 131:
                {
                alt9=107;
                }
                break;
            case 132:
                {
                alt9=108;
                }
                break;
            case 133:
                {
                alt9=109;
                }
                break;
            case 134:
                {
                alt9=110;
                }
                break;
            case 135:
                {
                alt9=111;
                }
                break;
            case 136:
                {
                alt9=112;
                }
                break;
            case 137:
                {
                alt9=113;
                }
                break;
            case 138:
                {
                alt9=114;
                }
                break;
            case 139:
                {
                alt9=115;
                }
                break;
            case 140:
                {
                alt9=116;
                }
                break;
            case 141:
                {
                alt9=117;
                }
                break;
            case 142:
                {
                alt9=118;
                }
                break;
            case 143:
                {
                alt9=119;
                }
                break;
            case 144:
                {
                alt9=120;
                }
                break;
            case 145:
                {
                alt9=121;
                }
                break;
            case 146:
                {
                alt9=122;
                }
                break;
            case 147:
                {
                alt9=123;
                }
                break;
            case 148:
                {
                alt9=124;
                }
                break;
            case 149:
                {
                alt9=125;
                }
                break;
            case 150:
                {
                alt9=126;
                }
                break;
            case 151:
                {
                alt9=127;
                }
                break;
            case 152:
                {
                alt9=128;
                }
                break;
            case 153:
                {
                alt9=129;
                }
                break;
            case 154:
                {
                alt9=130;
                }
                break;
            case 155:
                {
                alt9=131;
                }
                break;
            case 156:
                {
                alt9=132;
                }
                break;
            case 157:
                {
                alt9=133;
                }
                break;
            case 158:
                {
                alt9=134;
                }
                break;
            case 159:
                {
                alt9=135;
                }
                break;
            case 160:
                {
                alt9=136;
                }
                break;
            case 161:
                {
                alt9=137;
                }
                break;
            case 162:
                {
                alt9=138;
                }
                break;
            case 163:
                {
                alt9=139;
                }
                break;
            case 164:
                {
                alt9=140;
                }
                break;
            case 165:
                {
                alt9=141;
                }
                break;
            case 166:
                {
                alt9=142;
                }
                break;
            case 167:
                {
                alt9=143;
                }
                break;
            case 168:
                {
                alt9=144;
                }
                break;
            case 169:
                {
                alt9=145;
                }
                break;
            case 170:
                {
                alt9=146;
                }
                break;
            case 171:
                {
                alt9=147;
                }
                break;
            case 172:
                {
                alt9=148;
                }
                break;
            case 173:
                {
                alt9=149;
                }
                break;
            case 174:
                {
                alt9=150;
                }
                break;
            case 175:
                {
                alt9=151;
                }
                break;
            case 176:
                {
                alt9=152;
                }
                break;
            case 177:
                {
                alt9=153;
                }
                break;
            case 178:
                {
                alt9=154;
                }
                break;
            case 179:
                {
                alt9=155;
                }
                break;
            case 180:
                {
                alt9=156;
                }
                break;
            case 181:
                {
                alt9=157;
                }
                break;
            case 182:
                {
                alt9=158;
                }
                break;
            case 183:
                {
                alt9=159;
                }
                break;
            case 184:
                {
                alt9=160;
                }
                break;
            case 185:
                {
                alt9=161;
                }
                break;
            case 186:
                {
                alt9=162;
                }
                break;
            case 187:
                {
                alt9=163;
                }
                break;
            case 188:
                {
                alt9=164;
                }
                break;
            case 189:
                {
                alt9=165;
                }
                break;
            case 190:
                {
                alt9=166;
                }
                break;
            case 191:
                {
                alt9=167;
                }
                break;
            case 192:
                {
                alt9=168;
                }
                break;
            case 193:
                {
                alt9=169;
                }
                break;
            case 194:
                {
                alt9=170;
                }
                break;
            case 195:
                {
                alt9=171;
                }
                break;
            case 196:
                {
                alt9=172;
                }
                break;
            case 197:
                {
                alt9=173;
                }
                break;
            case 198:
                {
                alt9=174;
                }
                break;
            case 199:
                {
                alt9=175;
                }
                break;
            case 200:
                {
                alt9=176;
                }
                break;
            case 201:
                {
                alt9=177;
                }
                break;
            case 202:
                {
                alt9=178;
                }
                break;
            case 203:
                {
                alt9=179;
                }
                break;
            case 204:
                {
                alt9=180;
                }
                break;
            case 205:
                {
                alt9=181;
                }
                break;
            case 206:
                {
                alt9=182;
                }
                break;
            case 207:
                {
                alt9=183;
                }
                break;
            case 208:
                {
                alt9=184;
                }
                break;
            case 209:
                {
                alt9=185;
                }
                break;
            case 210:
                {
                alt9=186;
                }
                break;
            case 211:
                {
                alt9=187;
                }
                break;
            case 212:
                {
                alt9=188;
                }
                break;
            case 213:
                {
                alt9=189;
                }
                break;
            case 214:
                {
                alt9=190;
                }
                break;
            case 215:
                {
                alt9=191;
                }
                break;
            case 216:
                {
                alt9=192;
                }
                break;
            case 217:
                {
                alt9=193;
                }
                break;
            case 218:
                {
                alt9=194;
                }
                break;
            case 219:
                {
                alt9=195;
                }
                break;
            case 220:
                {
                alt9=196;
                }
                break;
            case 221:
                {
                alt9=197;
                }
                break;
            case 222:
                {
                alt9=198;
                }
                break;
            case 223:
                {
                alt9=199;
                }
                break;
            case 224:
                {
                alt9=200;
                }
                break;
            case 225:
                {
                alt9=201;
                }
                break;
            case 226:
                {
                alt9=202;
                }
                break;
            case 227:
                {
                alt9=203;
                }
                break;
            case 228:
                {
                alt9=204;
                }
                break;
            case 229:
                {
                alt9=205;
                }
                break;
            case 230:
                {
                alt9=206;
                }
                break;
            case 231:
                {
                alt9=207;
                }
                break;
            case 232:
                {
                alt9=208;
                }
                break;
            case 233:
                {
                alt9=209;
                }
                break;
            case 234:
                {
                alt9=210;
                }
                break;
            case 235:
                {
                alt9=211;
                }
                break;
            case 236:
                {
                alt9=212;
                }
                break;
            case 237:
                {
                alt9=213;
                }
                break;
            case 238:
                {
                alt9=214;
                }
                break;
            case 239:
                {
                alt9=215;
                }
                break;
            case 240:
                {
                alt9=216;
                }
                break;
            case 241:
                {
                alt9=217;
                }
                break;
            case 242:
                {
                alt9=218;
                }
                break;
            case 243:
                {
                alt9=219;
                }
                break;
            case 244:
                {
                alt9=220;
                }
                break;
            case 245:
                {
                alt9=221;
                }
                break;
            case 246:
                {
                alt9=222;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalPerl.g:672:2: ( 'abs' )
                    {
                    // InternalPerl.g:672:2: ( 'abs' )
                    // InternalPerl.g:673:3: 'abs'
                    {
                     before(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:678:2: ( 'accept' )
                    {
                    // InternalPerl.g:678:2: ( 'accept' )
                    // InternalPerl.g:679:3: 'accept'
                    {
                     before(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:684:2: ( 'alarm' )
                    {
                    // InternalPerl.g:684:2: ( 'alarm' )
                    // InternalPerl.g:685:3: 'alarm'
                    {
                     before(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:690:2: ( 'atan2' )
                    {
                    // InternalPerl.g:690:2: ( 'atan2' )
                    // InternalPerl.g:691:3: 'atan2'
                    {
                     before(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:696:2: ( 'bind' )
                    {
                    // InternalPerl.g:696:2: ( 'bind' )
                    // InternalPerl.g:697:3: 'bind'
                    {
                     before(grammarAccess.getKeywordAccess().getBindKeyword_4()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBindKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:702:2: ( 'binmode' )
                    {
                    // InternalPerl.g:702:2: ( 'binmode' )
                    // InternalPerl.g:703:3: 'binmode'
                    {
                     before(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:708:2: ( 'bless' )
                    {
                    // InternalPerl.g:708:2: ( 'bless' )
                    // InternalPerl.g:709:3: 'bless'
                    {
                     before(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:714:2: ( 'break' )
                    {
                    // InternalPerl.g:714:2: ( 'break' )
                    // InternalPerl.g:715:3: 'break'
                    {
                     before(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:720:2: ( 'caller' )
                    {
                    // InternalPerl.g:720:2: ( 'caller' )
                    // InternalPerl.g:721:3: 'caller'
                    {
                     before(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:726:2: ( 'chdir' )
                    {
                    // InternalPerl.g:726:2: ( 'chdir' )
                    // InternalPerl.g:727:3: 'chdir'
                    {
                     before(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:732:2: ( 'chmod' )
                    {
                    // InternalPerl.g:732:2: ( 'chmod' )
                    // InternalPerl.g:733:3: 'chmod'
                    {
                     before(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:738:2: ( 'chomp' )
                    {
                    // InternalPerl.g:738:2: ( 'chomp' )
                    // InternalPerl.g:739:3: 'chomp'
                    {
                     before(grammarAccess.getKeywordAccess().getChompKeyword_11()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChompKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:744:2: ( 'chop' )
                    {
                    // InternalPerl.g:744:2: ( 'chop' )
                    // InternalPerl.g:745:3: 'chop'
                    {
                     before(grammarAccess.getKeywordAccess().getChopKeyword_12()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChopKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:750:2: ( 'chown' )
                    {
                    // InternalPerl.g:750:2: ( 'chown' )
                    // InternalPerl.g:751:3: 'chown'
                    {
                     before(grammarAccess.getKeywordAccess().getChownKeyword_13()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChownKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:756:2: ( 'chr' )
                    {
                    // InternalPerl.g:756:2: ( 'chr' )
                    // InternalPerl.g:757:3: 'chr'
                    {
                     before(grammarAccess.getKeywordAccess().getChrKeyword_14()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:762:2: ( 'chroot' )
                    {
                    // InternalPerl.g:762:2: ( 'chroot' )
                    // InternalPerl.g:763:3: 'chroot'
                    {
                     before(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:768:2: ( 'close' )
                    {
                    // InternalPerl.g:768:2: ( 'close' )
                    // InternalPerl.g:769:3: 'close'
                    {
                     before(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:774:2: ( 'closedir' )
                    {
                    // InternalPerl.g:774:2: ( 'closedir' )
                    // InternalPerl.g:775:3: 'closedir'
                    {
                     before(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:780:2: ( 'connect' )
                    {
                    // InternalPerl.g:780:2: ( 'connect' )
                    // InternalPerl.g:781:3: 'connect'
                    {
                     before(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:786:2: ( 'continue' )
                    {
                    // InternalPerl.g:786:2: ( 'continue' )
                    // InternalPerl.g:787:3: 'continue'
                    {
                     before(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:792:2: ( 'cos' )
                    {
                    // InternalPerl.g:792:2: ( 'cos' )
                    // InternalPerl.g:793:3: 'cos'
                    {
                     before(grammarAccess.getKeywordAccess().getCosKeyword_20()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCosKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:798:2: ( 'crypt' )
                    {
                    // InternalPerl.g:798:2: ( 'crypt' )
                    // InternalPerl.g:799:3: 'crypt'
                    {
                     before(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:804:2: ( 'dbmclose' )
                    {
                    // InternalPerl.g:804:2: ( 'dbmclose' )
                    // InternalPerl.g:805:3: 'dbmclose'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:810:2: ( 'dbmopen' )
                    {
                    // InternalPerl.g:810:2: ( 'dbmopen' )
                    // InternalPerl.g:811:3: 'dbmopen'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:816:2: ( 'default' )
                    {
                    // InternalPerl.g:816:2: ( 'default' )
                    // InternalPerl.g:817:3: 'default'
                    {
                     before(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:822:2: ( 'defined' )
                    {
                    // InternalPerl.g:822:2: ( 'defined' )
                    // InternalPerl.g:823:3: 'defined'
                    {
                     before(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:828:2: ( 'delete' )
                    {
                    // InternalPerl.g:828:2: ( 'delete' )
                    // InternalPerl.g:829:3: 'delete'
                    {
                     before(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:834:2: ( 'die' )
                    {
                    // InternalPerl.g:834:2: ( 'die' )
                    // InternalPerl.g:835:3: 'die'
                    {
                     before(grammarAccess.getKeywordAccess().getDieKeyword_27()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDieKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:840:2: ( 'do' )
                    {
                    // InternalPerl.g:840:2: ( 'do' )
                    // InternalPerl.g:841:3: 'do'
                    {
                     before(grammarAccess.getKeywordAccess().getDoKeyword_28()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDoKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:846:2: ( 'dump' )
                    {
                    // InternalPerl.g:846:2: ( 'dump' )
                    // InternalPerl.g:847:3: 'dump'
                    {
                     before(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:852:2: ( 'each' )
                    {
                    // InternalPerl.g:852:2: ( 'each' )
                    // InternalPerl.g:853:3: 'each'
                    {
                     before(grammarAccess.getKeywordAccess().getEachKeyword_30()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEachKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:858:2: ( 'else' )
                    {
                    // InternalPerl.g:858:2: ( 'else' )
                    // InternalPerl.g:859:3: 'else'
                    {
                     before(grammarAccess.getKeywordAccess().getElseKeyword_31()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElseKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:864:2: ( 'elsif' )
                    {
                    // InternalPerl.g:864:2: ( 'elsif' )
                    // InternalPerl.g:865:3: 'elsif'
                    {
                     before(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:870:2: ( 'endgrent' )
                    {
                    // InternalPerl.g:870:2: ( 'endgrent' )
                    // InternalPerl.g:871:3: 'endgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:876:2: ( 'endhostent' )
                    {
                    // InternalPerl.g:876:2: ( 'endhostent' )
                    // InternalPerl.g:877:3: 'endhostent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:882:2: ( 'endnetent' )
                    {
                    // InternalPerl.g:882:2: ( 'endnetent' )
                    // InternalPerl.g:883:3: 'endnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:888:2: ( 'endprotoent' )
                    {
                    // InternalPerl.g:888:2: ( 'endprotoent' )
                    // InternalPerl.g:889:3: 'endprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:894:2: ( 'endpwent' )
                    {
                    // InternalPerl.g:894:2: ( 'endpwent' )
                    // InternalPerl.g:895:3: 'endpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:900:2: ( 'endservent' )
                    {
                    // InternalPerl.g:900:2: ( 'endservent' )
                    // InternalPerl.g:901:3: 'endservent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:906:2: ( 'eof' )
                    {
                    // InternalPerl.g:906:2: ( 'eof' )
                    // InternalPerl.g:907:3: 'eof'
                    {
                     before(grammarAccess.getKeywordAccess().getEofKeyword_39()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEofKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:912:2: ( 'eval' )
                    {
                    // InternalPerl.g:912:2: ( 'eval' )
                    // InternalPerl.g:913:3: 'eval'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:918:2: ( 'evalbytes' )
                    {
                    // InternalPerl.g:918:2: ( 'evalbytes' )
                    // InternalPerl.g:919:3: 'evalbytes'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:924:2: ( 'exec' )
                    {
                    // InternalPerl.g:924:2: ( 'exec' )
                    // InternalPerl.g:925:3: 'exec'
                    {
                     before(grammarAccess.getKeywordAccess().getExecKeyword_42()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExecKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:930:2: ( 'exists' )
                    {
                    // InternalPerl.g:930:2: ( 'exists' )
                    // InternalPerl.g:931:3: 'exists'
                    {
                     before(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:936:2: ( 'exit' )
                    {
                    // InternalPerl.g:936:2: ( 'exit' )
                    // InternalPerl.g:937:3: 'exit'
                    {
                     before(grammarAccess.getKeywordAccess().getExitKeyword_44()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExitKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:942:2: ( 'exp' )
                    {
                    // InternalPerl.g:942:2: ( 'exp' )
                    // InternalPerl.g:943:3: 'exp'
                    {
                     before(grammarAccess.getKeywordAccess().getExpKeyword_45()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExpKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:948:2: ( 'fc' )
                    {
                    // InternalPerl.g:948:2: ( 'fc' )
                    // InternalPerl.g:949:3: 'fc'
                    {
                     before(grammarAccess.getKeywordAccess().getFcKeyword_46()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:954:2: ( 'fcntl' )
                    {
                    // InternalPerl.g:954:2: ( 'fcntl' )
                    // InternalPerl.g:955:3: 'fcntl'
                    {
                     before(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:960:2: ( 'fileno' )
                    {
                    // InternalPerl.g:960:2: ( 'fileno' )
                    // InternalPerl.g:961:3: 'fileno'
                    {
                     before(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:966:2: ( 'flock' )
                    {
                    // InternalPerl.g:966:2: ( 'flock' )
                    // InternalPerl.g:967:3: 'flock'
                    {
                     before(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:972:2: ( 'for' )
                    {
                    // InternalPerl.g:972:2: ( 'for' )
                    // InternalPerl.g:973:3: 'for'
                    {
                     before(grammarAccess.getKeywordAccess().getForKeyword_50()); 
                    match(input,75,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:978:2: ( 'foreach' )
                    {
                    // InternalPerl.g:978:2: ( 'foreach' )
                    // InternalPerl.g:979:3: 'foreach'
                    {
                     before(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 
                    match(input,76,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:984:2: ( 'fork' )
                    {
                    // InternalPerl.g:984:2: ( 'fork' )
                    // InternalPerl.g:985:3: 'fork'
                    {
                     before(grammarAccess.getKeywordAccess().getForkKeyword_52()); 
                    match(input,77,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForkKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:990:2: ( 'format' )
                    {
                    // InternalPerl.g:990:2: ( 'format' )
                    // InternalPerl.g:991:3: 'format'
                    {
                     before(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 
                    match(input,78,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:996:2: ( 'formline' )
                    {
                    // InternalPerl.g:996:2: ( 'formline' )
                    // InternalPerl.g:997:3: 'formline'
                    {
                     before(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 
                    match(input,79,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:1002:2: ( 'getc' )
                    {
                    // InternalPerl.g:1002:2: ( 'getc' )
                    // InternalPerl.g:1003:3: 'getc'
                    {
                     before(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 
                    match(input,80,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:1008:2: ( 'getgrent' )
                    {
                    // InternalPerl.g:1008:2: ( 'getgrent' )
                    // InternalPerl.g:1009:3: 'getgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 
                    match(input,81,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:1014:2: ( 'getgrgid' )
                    {
                    // InternalPerl.g:1014:2: ( 'getgrgid' )
                    // InternalPerl.g:1015:3: 'getgrgid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 
                    match(input,82,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:1020:2: ( 'getgrnam' )
                    {
                    // InternalPerl.g:1020:2: ( 'getgrnam' )
                    // InternalPerl.g:1021:3: 'getgrnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 
                    match(input,83,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:1026:2: ( 'gethostbyaddr' )
                    {
                    // InternalPerl.g:1026:2: ( 'gethostbyaddr' )
                    // InternalPerl.g:1027:3: 'gethostbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 
                    match(input,84,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:1032:2: ( 'gethostbyname' )
                    {
                    // InternalPerl.g:1032:2: ( 'gethostbyname' )
                    // InternalPerl.g:1033:3: 'gethostbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 
                    match(input,85,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:1038:2: ( 'gethostent' )
                    {
                    // InternalPerl.g:1038:2: ( 'gethostent' )
                    // InternalPerl.g:1039:3: 'gethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 
                    match(input,86,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:1044:2: ( 'getlogin' )
                    {
                    // InternalPerl.g:1044:2: ( 'getlogin' )
                    // InternalPerl.g:1045:3: 'getlogin'
                    {
                     before(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 
                    match(input,87,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:1050:2: ( 'getnetbyaddr' )
                    {
                    // InternalPerl.g:1050:2: ( 'getnetbyaddr' )
                    // InternalPerl.g:1051:3: 'getnetbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 
                    match(input,88,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 

                    }


                    }
                    break;
                case 65 :
                    // InternalPerl.g:1056:2: ( 'getnetbyname' )
                    {
                    // InternalPerl.g:1056:2: ( 'getnetbyname' )
                    // InternalPerl.g:1057:3: 'getnetbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 
                    match(input,89,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 

                    }


                    }
                    break;
                case 66 :
                    // InternalPerl.g:1062:2: ( 'getnetent' )
                    {
                    // InternalPerl.g:1062:2: ( 'getnetent' )
                    // InternalPerl.g:1063:3: 'getnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 
                    match(input,90,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 

                    }


                    }
                    break;
                case 67 :
                    // InternalPerl.g:1068:2: ( 'getpeername' )
                    {
                    // InternalPerl.g:1068:2: ( 'getpeername' )
                    // InternalPerl.g:1069:3: 'getpeername'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 
                    match(input,91,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 

                    }


                    }
                    break;
                case 68 :
                    // InternalPerl.g:1074:2: ( 'getpgrp' )
                    {
                    // InternalPerl.g:1074:2: ( 'getpgrp' )
                    // InternalPerl.g:1075:3: 'getpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 
                    match(input,92,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 

                    }


                    }
                    break;
                case 69 :
                    // InternalPerl.g:1080:2: ( 'getppid' )
                    {
                    // InternalPerl.g:1080:2: ( 'getppid' )
                    // InternalPerl.g:1081:3: 'getppid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 
                    match(input,93,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 

                    }


                    }
                    break;
                case 70 :
                    // InternalPerl.g:1086:2: ( 'getpriority' )
                    {
                    // InternalPerl.g:1086:2: ( 'getpriority' )
                    // InternalPerl.g:1087:3: 'getpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 
                    match(input,94,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 

                    }


                    }
                    break;
                case 71 :
                    // InternalPerl.g:1092:2: ( 'getprotobyname' )
                    {
                    // InternalPerl.g:1092:2: ( 'getprotobyname' )
                    // InternalPerl.g:1093:3: 'getprotobyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 
                    match(input,95,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 

                    }


                    }
                    break;
                case 72 :
                    // InternalPerl.g:1098:2: ( 'getprotobynumber' )
                    {
                    // InternalPerl.g:1098:2: ( 'getprotobynumber' )
                    // InternalPerl.g:1099:3: 'getprotobynumber'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 
                    match(input,96,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 

                    }


                    }
                    break;
                case 73 :
                    // InternalPerl.g:1104:2: ( 'getprotoent' )
                    {
                    // InternalPerl.g:1104:2: ( 'getprotoent' )
                    // InternalPerl.g:1105:3: 'getprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 
                    match(input,97,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 

                    }


                    }
                    break;
                case 74 :
                    // InternalPerl.g:1110:2: ( 'getpwent' )
                    {
                    // InternalPerl.g:1110:2: ( 'getpwent' )
                    // InternalPerl.g:1111:3: 'getpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 
                    match(input,98,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 

                    }


                    }
                    break;
                case 75 :
                    // InternalPerl.g:1116:2: ( 'getpwnam' )
                    {
                    // InternalPerl.g:1116:2: ( 'getpwnam' )
                    // InternalPerl.g:1117:3: 'getpwnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 
                    match(input,99,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 

                    }


                    }
                    break;
                case 76 :
                    // InternalPerl.g:1122:2: ( 'getpwuid' )
                    {
                    // InternalPerl.g:1122:2: ( 'getpwuid' )
                    // InternalPerl.g:1123:3: 'getpwuid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 
                    match(input,100,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 

                    }


                    }
                    break;
                case 77 :
                    // InternalPerl.g:1128:2: ( 'getservbyname' )
                    {
                    // InternalPerl.g:1128:2: ( 'getservbyname' )
                    // InternalPerl.g:1129:3: 'getservbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 
                    match(input,101,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 

                    }


                    }
                    break;
                case 78 :
                    // InternalPerl.g:1134:2: ( 'getservbyport' )
                    {
                    // InternalPerl.g:1134:2: ( 'getservbyport' )
                    // InternalPerl.g:1135:3: 'getservbyport'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 
                    match(input,102,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 

                    }


                    }
                    break;
                case 79 :
                    // InternalPerl.g:1140:2: ( 'getservent' )
                    {
                    // InternalPerl.g:1140:2: ( 'getservent' )
                    // InternalPerl.g:1141:3: 'getservent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 
                    match(input,103,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 

                    }


                    }
                    break;
                case 80 :
                    // InternalPerl.g:1146:2: ( 'getsockname' )
                    {
                    // InternalPerl.g:1146:2: ( 'getsockname' )
                    // InternalPerl.g:1147:3: 'getsockname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 
                    match(input,104,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 

                    }


                    }
                    break;
                case 81 :
                    // InternalPerl.g:1152:2: ( 'getsockopt' )
                    {
                    // InternalPerl.g:1152:2: ( 'getsockopt' )
                    // InternalPerl.g:1153:3: 'getsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 
                    match(input,105,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 

                    }


                    }
                    break;
                case 82 :
                    // InternalPerl.g:1158:2: ( 'given' )
                    {
                    // InternalPerl.g:1158:2: ( 'given' )
                    // InternalPerl.g:1159:3: 'given'
                    {
                     before(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 
                    match(input,106,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 

                    }


                    }
                    break;
                case 83 :
                    // InternalPerl.g:1164:2: ( 'glob' )
                    {
                    // InternalPerl.g:1164:2: ( 'glob' )
                    // InternalPerl.g:1165:3: 'glob'
                    {
                     before(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 
                    match(input,107,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 

                    }


                    }
                    break;
                case 84 :
                    // InternalPerl.g:1170:2: ( 'gmtime' )
                    {
                    // InternalPerl.g:1170:2: ( 'gmtime' )
                    // InternalPerl.g:1171:3: 'gmtime'
                    {
                     before(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 
                    match(input,108,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 

                    }


                    }
                    break;
                case 85 :
                    // InternalPerl.g:1176:2: ( 'goto' )
                    {
                    // InternalPerl.g:1176:2: ( 'goto' )
                    // InternalPerl.g:1177:3: 'goto'
                    {
                     before(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 
                    match(input,109,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 

                    }


                    }
                    break;
                case 86 :
                    // InternalPerl.g:1182:2: ( 'grep' )
                    {
                    // InternalPerl.g:1182:2: ( 'grep' )
                    // InternalPerl.g:1183:3: 'grep'
                    {
                     before(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 
                    match(input,110,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 

                    }


                    }
                    break;
                case 87 :
                    // InternalPerl.g:1188:2: ( 'hex' )
                    {
                    // InternalPerl.g:1188:2: ( 'hex' )
                    // InternalPerl.g:1189:3: 'hex'
                    {
                     before(grammarAccess.getKeywordAccess().getHexKeyword_86()); 
                    match(input,111,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getHexKeyword_86()); 

                    }


                    }
                    break;
                case 88 :
                    // InternalPerl.g:1194:2: ( 'if' )
                    {
                    // InternalPerl.g:1194:2: ( 'if' )
                    // InternalPerl.g:1195:3: 'if'
                    {
                     before(grammarAccess.getKeywordAccess().getIfKeyword_87()); 
                    match(input,112,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIfKeyword_87()); 

                    }


                    }
                    break;
                case 89 :
                    // InternalPerl.g:1200:2: ( 'index' )
                    {
                    // InternalPerl.g:1200:2: ( 'index' )
                    // InternalPerl.g:1201:3: 'index'
                    {
                     before(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 
                    match(input,113,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 

                    }


                    }
                    break;
                case 90 :
                    // InternalPerl.g:1206:2: ( 'int' )
                    {
                    // InternalPerl.g:1206:2: ( 'int' )
                    // InternalPerl.g:1207:3: 'int'
                    {
                     before(grammarAccess.getKeywordAccess().getIntKeyword_89()); 
                    match(input,114,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIntKeyword_89()); 

                    }


                    }
                    break;
                case 91 :
                    // InternalPerl.g:1212:2: ( 'ioctl' )
                    {
                    // InternalPerl.g:1212:2: ( 'ioctl' )
                    // InternalPerl.g:1213:3: 'ioctl'
                    {
                     before(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 
                    match(input,115,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 

                    }


                    }
                    break;
                case 92 :
                    // InternalPerl.g:1218:2: ( 'join' )
                    {
                    // InternalPerl.g:1218:2: ( 'join' )
                    // InternalPerl.g:1219:3: 'join'
                    {
                     before(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 
                    match(input,116,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 

                    }


                    }
                    break;
                case 93 :
                    // InternalPerl.g:1224:2: ( 'keys' )
                    {
                    // InternalPerl.g:1224:2: ( 'keys' )
                    // InternalPerl.g:1225:3: 'keys'
                    {
                     before(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 
                    match(input,117,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 

                    }


                    }
                    break;
                case 94 :
                    // InternalPerl.g:1230:2: ( 'kill' )
                    {
                    // InternalPerl.g:1230:2: ( 'kill' )
                    // InternalPerl.g:1231:3: 'kill'
                    {
                     before(grammarAccess.getKeywordAccess().getKillKeyword_93()); 
                    match(input,118,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKillKeyword_93()); 

                    }


                    }
                    break;
                case 95 :
                    // InternalPerl.g:1236:2: ( 'last' )
                    {
                    // InternalPerl.g:1236:2: ( 'last' )
                    // InternalPerl.g:1237:3: 'last'
                    {
                     before(grammarAccess.getKeywordAccess().getLastKeyword_94()); 
                    match(input,119,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLastKeyword_94()); 

                    }


                    }
                    break;
                case 96 :
                    // InternalPerl.g:1242:2: ( 'lc' )
                    {
                    // InternalPerl.g:1242:2: ( 'lc' )
                    // InternalPerl.g:1243:3: 'lc'
                    {
                     before(grammarAccess.getKeywordAccess().getLcKeyword_95()); 
                    match(input,120,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcKeyword_95()); 

                    }


                    }
                    break;
                case 97 :
                    // InternalPerl.g:1248:2: ( 'lcfirst' )
                    {
                    // InternalPerl.g:1248:2: ( 'lcfirst' )
                    // InternalPerl.g:1249:3: 'lcfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 
                    match(input,121,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 

                    }


                    }
                    break;
                case 98 :
                    // InternalPerl.g:1254:2: ( 'length' )
                    {
                    // InternalPerl.g:1254:2: ( 'length' )
                    // InternalPerl.g:1255:3: 'length'
                    {
                     before(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 
                    match(input,122,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 

                    }


                    }
                    break;
                case 99 :
                    // InternalPerl.g:1260:2: ( 'link' )
                    {
                    // InternalPerl.g:1260:2: ( 'link' )
                    // InternalPerl.g:1261:3: 'link'
                    {
                     before(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 
                    match(input,123,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 

                    }


                    }
                    break;
                case 100 :
                    // InternalPerl.g:1266:2: ( 'listen' )
                    {
                    // InternalPerl.g:1266:2: ( 'listen' )
                    // InternalPerl.g:1267:3: 'listen'
                    {
                     before(grammarAccess.getKeywordAccess().getListenKeyword_99()); 
                    match(input,124,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getListenKeyword_99()); 

                    }


                    }
                    break;
                case 101 :
                    // InternalPerl.g:1272:2: ( 'local' )
                    {
                    // InternalPerl.g:1272:2: ( 'local' )
                    // InternalPerl.g:1273:3: 'local'
                    {
                     before(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 
                    match(input,125,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 

                    }


                    }
                    break;
                case 102 :
                    // InternalPerl.g:1278:2: ( 'localtime' )
                    {
                    // InternalPerl.g:1278:2: ( 'localtime' )
                    // InternalPerl.g:1279:3: 'localtime'
                    {
                     before(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 
                    match(input,126,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 

                    }


                    }
                    break;
                case 103 :
                    // InternalPerl.g:1284:2: ( 'lock' )
                    {
                    // InternalPerl.g:1284:2: ( 'lock' )
                    // InternalPerl.g:1285:3: 'lock'
                    {
                     before(grammarAccess.getKeywordAccess().getLockKeyword_102()); 
                    match(input,127,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLockKeyword_102()); 

                    }


                    }
                    break;
                case 104 :
                    // InternalPerl.g:1290:2: ( 'log' )
                    {
                    // InternalPerl.g:1290:2: ( 'log' )
                    // InternalPerl.g:1291:3: 'log'
                    {
                     before(grammarAccess.getKeywordAccess().getLogKeyword_103()); 
                    match(input,128,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLogKeyword_103()); 

                    }


                    }
                    break;
                case 105 :
                    // InternalPerl.g:1296:2: ( 'lstat' )
                    {
                    // InternalPerl.g:1296:2: ( 'lstat' )
                    // InternalPerl.g:1297:3: 'lstat'
                    {
                     before(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 
                    match(input,129,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 

                    }


                    }
                    break;
                case 106 :
                    // InternalPerl.g:1302:2: ( 'map' )
                    {
                    // InternalPerl.g:1302:2: ( 'map' )
                    // InternalPerl.g:1303:3: 'map'
                    {
                     before(grammarAccess.getKeywordAccess().getMapKeyword_105()); 
                    match(input,130,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMapKeyword_105()); 

                    }


                    }
                    break;
                case 107 :
                    // InternalPerl.g:1308:2: ( 'mkdir' )
                    {
                    // InternalPerl.g:1308:2: ( 'mkdir' )
                    // InternalPerl.g:1309:3: 'mkdir'
                    {
                     before(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 
                    match(input,131,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 

                    }


                    }
                    break;
                case 108 :
                    // InternalPerl.g:1314:2: ( 'msgctl' )
                    {
                    // InternalPerl.g:1314:2: ( 'msgctl' )
                    // InternalPerl.g:1315:3: 'msgctl'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 
                    match(input,132,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 

                    }


                    }
                    break;
                case 109 :
                    // InternalPerl.g:1320:2: ( 'msgget' )
                    {
                    // InternalPerl.g:1320:2: ( 'msgget' )
                    // InternalPerl.g:1321:3: 'msgget'
                    {
                     before(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 
                    match(input,133,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 

                    }


                    }
                    break;
                case 110 :
                    // InternalPerl.g:1326:2: ( 'msgrcv' )
                    {
                    // InternalPerl.g:1326:2: ( 'msgrcv' )
                    // InternalPerl.g:1327:3: 'msgrcv'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 
                    match(input,134,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 

                    }


                    }
                    break;
                case 111 :
                    // InternalPerl.g:1332:2: ( 'msgsnd' )
                    {
                    // InternalPerl.g:1332:2: ( 'msgsnd' )
                    // InternalPerl.g:1333:3: 'msgsnd'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 
                    match(input,135,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 

                    }


                    }
                    break;
                case 112 :
                    // InternalPerl.g:1338:2: ( 'my' )
                    {
                    // InternalPerl.g:1338:2: ( 'my' )
                    // InternalPerl.g:1339:3: 'my'
                    {
                     before(grammarAccess.getKeywordAccess().getMyKeyword_111()); 
                    match(input,136,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMyKeyword_111()); 

                    }


                    }
                    break;
                case 113 :
                    // InternalPerl.g:1344:2: ( 'next' )
                    {
                    // InternalPerl.g:1344:2: ( 'next' )
                    // InternalPerl.g:1345:3: 'next'
                    {
                     before(grammarAccess.getKeywordAccess().getNextKeyword_112()); 
                    match(input,137,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNextKeyword_112()); 

                    }


                    }
                    break;
                case 114 :
                    // InternalPerl.g:1350:2: ( 'no' )
                    {
                    // InternalPerl.g:1350:2: ( 'no' )
                    // InternalPerl.g:1351:3: 'no'
                    {
                     before(grammarAccess.getKeywordAccess().getNoKeyword_113()); 
                    match(input,138,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNoKeyword_113()); 

                    }


                    }
                    break;
                case 115 :
                    // InternalPerl.g:1356:2: ( 'oct' )
                    {
                    // InternalPerl.g:1356:2: ( 'oct' )
                    // InternalPerl.g:1357:3: 'oct'
                    {
                     before(grammarAccess.getKeywordAccess().getOctKeyword_114()); 
                    match(input,139,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOctKeyword_114()); 

                    }


                    }
                    break;
                case 116 :
                    // InternalPerl.g:1362:2: ( 'open' )
                    {
                    // InternalPerl.g:1362:2: ( 'open' )
                    // InternalPerl.g:1363:3: 'open'
                    {
                     before(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 
                    match(input,140,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 

                    }


                    }
                    break;
                case 117 :
                    // InternalPerl.g:1368:2: ( 'opendir' )
                    {
                    // InternalPerl.g:1368:2: ( 'opendir' )
                    // InternalPerl.g:1369:3: 'opendir'
                    {
                     before(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 
                    match(input,141,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 

                    }


                    }
                    break;
                case 118 :
                    // InternalPerl.g:1374:2: ( 'ord' )
                    {
                    // InternalPerl.g:1374:2: ( 'ord' )
                    // InternalPerl.g:1375:3: 'ord'
                    {
                     before(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 
                    match(input,142,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 

                    }


                    }
                    break;
                case 119 :
                    // InternalPerl.g:1380:2: ( 'our' )
                    {
                    // InternalPerl.g:1380:2: ( 'our' )
                    // InternalPerl.g:1381:3: 'our'
                    {
                     before(grammarAccess.getKeywordAccess().getOurKeyword_118()); 
                    match(input,143,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOurKeyword_118()); 

                    }


                    }
                    break;
                case 120 :
                    // InternalPerl.g:1386:2: ( 'pack' )
                    {
                    // InternalPerl.g:1386:2: ( 'pack' )
                    // InternalPerl.g:1387:3: 'pack'
                    {
                     before(grammarAccess.getKeywordAccess().getPackKeyword_119()); 
                    match(input,144,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackKeyword_119()); 

                    }


                    }
                    break;
                case 121 :
                    // InternalPerl.g:1392:2: ( 'package' )
                    {
                    // InternalPerl.g:1392:2: ( 'package' )
                    // InternalPerl.g:1393:3: 'package'
                    {
                     before(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 
                    match(input,145,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 

                    }


                    }
                    break;
                case 122 :
                    // InternalPerl.g:1398:2: ( 'pipe' )
                    {
                    // InternalPerl.g:1398:2: ( 'pipe' )
                    // InternalPerl.g:1399:3: 'pipe'
                    {
                     before(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 
                    match(input,146,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 

                    }


                    }
                    break;
                case 123 :
                    // InternalPerl.g:1404:2: ( 'pop' )
                    {
                    // InternalPerl.g:1404:2: ( 'pop' )
                    // InternalPerl.g:1405:3: 'pop'
                    {
                     before(grammarAccess.getKeywordAccess().getPopKeyword_122()); 
                    match(input,147,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPopKeyword_122()); 

                    }


                    }
                    break;
                case 124 :
                    // InternalPerl.g:1410:2: ( 'pos' )
                    {
                    // InternalPerl.g:1410:2: ( 'pos' )
                    // InternalPerl.g:1411:3: 'pos'
                    {
                     before(grammarAccess.getKeywordAccess().getPosKeyword_123()); 
                    match(input,148,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPosKeyword_123()); 

                    }


                    }
                    break;
                case 125 :
                    // InternalPerl.g:1416:2: ( 'print' )
                    {
                    // InternalPerl.g:1416:2: ( 'print' )
                    // InternalPerl.g:1417:3: 'print'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 
                    match(input,149,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 

                    }


                    }
                    break;
                case 126 :
                    // InternalPerl.g:1422:2: ( 'printf' )
                    {
                    // InternalPerl.g:1422:2: ( 'printf' )
                    // InternalPerl.g:1423:3: 'printf'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 
                    match(input,150,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 

                    }


                    }
                    break;
                case 127 :
                    // InternalPerl.g:1428:2: ( 'prototype' )
                    {
                    // InternalPerl.g:1428:2: ( 'prototype' )
                    // InternalPerl.g:1429:3: 'prototype'
                    {
                     before(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 
                    match(input,151,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 

                    }


                    }
                    break;
                case 128 :
                    // InternalPerl.g:1434:2: ( 'push' )
                    {
                    // InternalPerl.g:1434:2: ( 'push' )
                    // InternalPerl.g:1435:3: 'push'
                    {
                     before(grammarAccess.getKeywordAccess().getPushKeyword_127()); 
                    match(input,152,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPushKeyword_127()); 

                    }


                    }
                    break;
                case 129 :
                    // InternalPerl.g:1440:2: ( 'quotemeta' )
                    {
                    // InternalPerl.g:1440:2: ( 'quotemeta' )
                    // InternalPerl.g:1441:3: 'quotemeta'
                    {
                     before(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 
                    match(input,153,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 

                    }


                    }
                    break;
                case 130 :
                    // InternalPerl.g:1446:2: ( 'rand' )
                    {
                    // InternalPerl.g:1446:2: ( 'rand' )
                    // InternalPerl.g:1447:3: 'rand'
                    {
                     before(grammarAccess.getKeywordAccess().getRandKeyword_129()); 
                    match(input,154,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRandKeyword_129()); 

                    }


                    }
                    break;
                case 131 :
                    // InternalPerl.g:1452:2: ( 'read' )
                    {
                    // InternalPerl.g:1452:2: ( 'read' )
                    // InternalPerl.g:1453:3: 'read'
                    {
                     before(grammarAccess.getKeywordAccess().getReadKeyword_130()); 
                    match(input,155,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadKeyword_130()); 

                    }


                    }
                    break;
                case 132 :
                    // InternalPerl.g:1458:2: ( 'readdir' )
                    {
                    // InternalPerl.g:1458:2: ( 'readdir' )
                    // InternalPerl.g:1459:3: 'readdir'
                    {
                     before(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 
                    match(input,156,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 

                    }


                    }
                    break;
                case 133 :
                    // InternalPerl.g:1464:2: ( 'readline' )
                    {
                    // InternalPerl.g:1464:2: ( 'readline' )
                    // InternalPerl.g:1465:3: 'readline'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 
                    match(input,157,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 

                    }


                    }
                    break;
                case 134 :
                    // InternalPerl.g:1470:2: ( 'readlink' )
                    {
                    // InternalPerl.g:1470:2: ( 'readlink' )
                    // InternalPerl.g:1471:3: 'readlink'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 
                    match(input,158,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 

                    }


                    }
                    break;
                case 135 :
                    // InternalPerl.g:1476:2: ( 'readpipe' )
                    {
                    // InternalPerl.g:1476:2: ( 'readpipe' )
                    // InternalPerl.g:1477:3: 'readpipe'
                    {
                     before(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 
                    match(input,159,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 

                    }


                    }
                    break;
                case 136 :
                    // InternalPerl.g:1482:2: ( 'recv' )
                    {
                    // InternalPerl.g:1482:2: ( 'recv' )
                    // InternalPerl.g:1483:3: 'recv'
                    {
                     before(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 
                    match(input,160,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 

                    }


                    }
                    break;
                case 137 :
                    // InternalPerl.g:1488:2: ( 'redo' )
                    {
                    // InternalPerl.g:1488:2: ( 'redo' )
                    // InternalPerl.g:1489:3: 'redo'
                    {
                     before(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 
                    match(input,161,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 

                    }


                    }
                    break;
                case 138 :
                    // InternalPerl.g:1494:2: ( 'ref' )
                    {
                    // InternalPerl.g:1494:2: ( 'ref' )
                    // InternalPerl.g:1495:3: 'ref'
                    {
                     before(grammarAccess.getKeywordAccess().getRefKeyword_137()); 
                    match(input,162,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRefKeyword_137()); 

                    }


                    }
                    break;
                case 139 :
                    // InternalPerl.g:1500:2: ( 'rename' )
                    {
                    // InternalPerl.g:1500:2: ( 'rename' )
                    // InternalPerl.g:1501:3: 'rename'
                    {
                     before(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 
                    match(input,163,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 

                    }


                    }
                    break;
                case 140 :
                    // InternalPerl.g:1506:2: ( 'require' )
                    {
                    // InternalPerl.g:1506:2: ( 'require' )
                    // InternalPerl.g:1507:3: 'require'
                    {
                     before(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 
                    match(input,164,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 

                    }


                    }
                    break;
                case 141 :
                    // InternalPerl.g:1512:2: ( 'reset' )
                    {
                    // InternalPerl.g:1512:2: ( 'reset' )
                    // InternalPerl.g:1513:3: 'reset'
                    {
                     before(grammarAccess.getKeywordAccess().getResetKeyword_140()); 
                    match(input,165,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getResetKeyword_140()); 

                    }


                    }
                    break;
                case 142 :
                    // InternalPerl.g:1518:2: ( 'return' )
                    {
                    // InternalPerl.g:1518:2: ( 'return' )
                    // InternalPerl.g:1519:3: 'return'
                    {
                     before(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 
                    match(input,166,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 

                    }


                    }
                    break;
                case 143 :
                    // InternalPerl.g:1524:2: ( 'reverse' )
                    {
                    // InternalPerl.g:1524:2: ( 'reverse' )
                    // InternalPerl.g:1525:3: 'reverse'
                    {
                     before(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 
                    match(input,167,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 

                    }


                    }
                    break;
                case 144 :
                    // InternalPerl.g:1530:2: ( 'rewinddir' )
                    {
                    // InternalPerl.g:1530:2: ( 'rewinddir' )
                    // InternalPerl.g:1531:3: 'rewinddir'
                    {
                     before(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 
                    match(input,168,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 

                    }


                    }
                    break;
                case 145 :
                    // InternalPerl.g:1536:2: ( 'rindex' )
                    {
                    // InternalPerl.g:1536:2: ( 'rindex' )
                    // InternalPerl.g:1537:3: 'rindex'
                    {
                     before(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 
                    match(input,169,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 

                    }


                    }
                    break;
                case 146 :
                    // InternalPerl.g:1542:2: ( 'rmdir' )
                    {
                    // InternalPerl.g:1542:2: ( 'rmdir' )
                    // InternalPerl.g:1543:3: 'rmdir'
                    {
                     before(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 
                    match(input,170,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 

                    }


                    }
                    break;
                case 147 :
                    // InternalPerl.g:1548:2: ( 'say' )
                    {
                    // InternalPerl.g:1548:2: ( 'say' )
                    // InternalPerl.g:1549:3: 'say'
                    {
                     before(grammarAccess.getKeywordAccess().getSayKeyword_146()); 
                    match(input,171,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSayKeyword_146()); 

                    }


                    }
                    break;
                case 148 :
                    // InternalPerl.g:1554:2: ( 'scalar' )
                    {
                    // InternalPerl.g:1554:2: ( 'scalar' )
                    // InternalPerl.g:1555:3: 'scalar'
                    {
                     before(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 
                    match(input,172,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 

                    }


                    }
                    break;
                case 149 :
                    // InternalPerl.g:1560:2: ( 'seek' )
                    {
                    // InternalPerl.g:1560:2: ( 'seek' )
                    // InternalPerl.g:1561:3: 'seek'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 
                    match(input,173,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 

                    }


                    }
                    break;
                case 150 :
                    // InternalPerl.g:1566:2: ( 'seekdir' )
                    {
                    // InternalPerl.g:1566:2: ( 'seekdir' )
                    // InternalPerl.g:1567:3: 'seekdir'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 
                    match(input,174,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 

                    }


                    }
                    break;
                case 151 :
                    // InternalPerl.g:1572:2: ( 'select' )
                    {
                    // InternalPerl.g:1572:2: ( 'select' )
                    // InternalPerl.g:1573:3: 'select'
                    {
                     before(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 
                    match(input,175,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 

                    }


                    }
                    break;
                case 152 :
                    // InternalPerl.g:1578:2: ( 'semctl' )
                    {
                    // InternalPerl.g:1578:2: ( 'semctl' )
                    // InternalPerl.g:1579:3: 'semctl'
                    {
                     before(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 
                    match(input,176,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 

                    }


                    }
                    break;
                case 153 :
                    // InternalPerl.g:1584:2: ( 'semget' )
                    {
                    // InternalPerl.g:1584:2: ( 'semget' )
                    // InternalPerl.g:1585:3: 'semget'
                    {
                     before(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 
                    match(input,177,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 

                    }


                    }
                    break;
                case 154 :
                    // InternalPerl.g:1590:2: ( 'semop' )
                    {
                    // InternalPerl.g:1590:2: ( 'semop' )
                    // InternalPerl.g:1591:3: 'semop'
                    {
                     before(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 
                    match(input,178,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 

                    }


                    }
                    break;
                case 155 :
                    // InternalPerl.g:1596:2: ( 'send' )
                    {
                    // InternalPerl.g:1596:2: ( 'send' )
                    // InternalPerl.g:1597:3: 'send'
                    {
                     before(grammarAccess.getKeywordAccess().getSendKeyword_154()); 
                    match(input,179,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSendKeyword_154()); 

                    }


                    }
                    break;
                case 156 :
                    // InternalPerl.g:1602:2: ( 'setgrent' )
                    {
                    // InternalPerl.g:1602:2: ( 'setgrent' )
                    // InternalPerl.g:1603:3: 'setgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 
                    match(input,180,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 

                    }


                    }
                    break;
                case 157 :
                    // InternalPerl.g:1608:2: ( 'sethostent' )
                    {
                    // InternalPerl.g:1608:2: ( 'sethostent' )
                    // InternalPerl.g:1609:3: 'sethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 
                    match(input,181,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 

                    }


                    }
                    break;
                case 158 :
                    // InternalPerl.g:1614:2: ( 'setnetent' )
                    {
                    // InternalPerl.g:1614:2: ( 'setnetent' )
                    // InternalPerl.g:1615:3: 'setnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 
                    match(input,182,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 

                    }


                    }
                    break;
                case 159 :
                    // InternalPerl.g:1620:2: ( 'setpgrp' )
                    {
                    // InternalPerl.g:1620:2: ( 'setpgrp' )
                    // InternalPerl.g:1621:3: 'setpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 
                    match(input,183,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 

                    }


                    }
                    break;
                case 160 :
                    // InternalPerl.g:1626:2: ( 'setpriority' )
                    {
                    // InternalPerl.g:1626:2: ( 'setpriority' )
                    // InternalPerl.g:1627:3: 'setpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 
                    match(input,184,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 

                    }


                    }
                    break;
                case 161 :
                    // InternalPerl.g:1632:2: ( 'setprotoent' )
                    {
                    // InternalPerl.g:1632:2: ( 'setprotoent' )
                    // InternalPerl.g:1633:3: 'setprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 
                    match(input,185,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 

                    }


                    }
                    break;
                case 162 :
                    // InternalPerl.g:1638:2: ( 'setpwent' )
                    {
                    // InternalPerl.g:1638:2: ( 'setpwent' )
                    // InternalPerl.g:1639:3: 'setpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 
                    match(input,186,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 

                    }


                    }
                    break;
                case 163 :
                    // InternalPerl.g:1644:2: ( 'setservent' )
                    {
                    // InternalPerl.g:1644:2: ( 'setservent' )
                    // InternalPerl.g:1645:3: 'setservent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 
                    match(input,187,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 

                    }


                    }
                    break;
                case 164 :
                    // InternalPerl.g:1650:2: ( 'setsockopt' )
                    {
                    // InternalPerl.g:1650:2: ( 'setsockopt' )
                    // InternalPerl.g:1651:3: 'setsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 
                    match(input,188,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 

                    }


                    }
                    break;
                case 165 :
                    // InternalPerl.g:1656:2: ( 'shift' )
                    {
                    // InternalPerl.g:1656:2: ( 'shift' )
                    // InternalPerl.g:1657:3: 'shift'
                    {
                     before(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 
                    match(input,189,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 

                    }


                    }
                    break;
                case 166 :
                    // InternalPerl.g:1662:2: ( 'shmctl' )
                    {
                    // InternalPerl.g:1662:2: ( 'shmctl' )
                    // InternalPerl.g:1663:3: 'shmctl'
                    {
                     before(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 
                    match(input,190,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 

                    }


                    }
                    break;
                case 167 :
                    // InternalPerl.g:1668:2: ( 'shmget' )
                    {
                    // InternalPerl.g:1668:2: ( 'shmget' )
                    // InternalPerl.g:1669:3: 'shmget'
                    {
                     before(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 
                    match(input,191,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 

                    }


                    }
                    break;
                case 168 :
                    // InternalPerl.g:1674:2: ( 'shmread' )
                    {
                    // InternalPerl.g:1674:2: ( 'shmread' )
                    // InternalPerl.g:1675:3: 'shmread'
                    {
                     before(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 
                    match(input,192,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 

                    }


                    }
                    break;
                case 169 :
                    // InternalPerl.g:1680:2: ( 'shmwrite' )
                    {
                    // InternalPerl.g:1680:2: ( 'shmwrite' )
                    // InternalPerl.g:1681:3: 'shmwrite'
                    {
                     before(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 
                    match(input,193,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 

                    }


                    }
                    break;
                case 170 :
                    // InternalPerl.g:1686:2: ( 'shutdown' )
                    {
                    // InternalPerl.g:1686:2: ( 'shutdown' )
                    // InternalPerl.g:1687:3: 'shutdown'
                    {
                     before(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 
                    match(input,194,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 

                    }


                    }
                    break;
                case 171 :
                    // InternalPerl.g:1692:2: ( 'sin' )
                    {
                    // InternalPerl.g:1692:2: ( 'sin' )
                    // InternalPerl.g:1693:3: 'sin'
                    {
                     before(grammarAccess.getKeywordAccess().getSinKeyword_170()); 
                    match(input,195,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSinKeyword_170()); 

                    }


                    }
                    break;
                case 172 :
                    // InternalPerl.g:1698:2: ( 'sleep' )
                    {
                    // InternalPerl.g:1698:2: ( 'sleep' )
                    // InternalPerl.g:1699:3: 'sleep'
                    {
                     before(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 
                    match(input,196,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 

                    }


                    }
                    break;
                case 173 :
                    // InternalPerl.g:1704:2: ( 'socket' )
                    {
                    // InternalPerl.g:1704:2: ( 'socket' )
                    // InternalPerl.g:1705:3: 'socket'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 
                    match(input,197,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 

                    }


                    }
                    break;
                case 174 :
                    // InternalPerl.g:1710:2: ( 'socketpair' )
                    {
                    // InternalPerl.g:1710:2: ( 'socketpair' )
                    // InternalPerl.g:1711:3: 'socketpair'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 
                    match(input,198,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 

                    }


                    }
                    break;
                case 175 :
                    // InternalPerl.g:1716:2: ( 'sort' )
                    {
                    // InternalPerl.g:1716:2: ( 'sort' )
                    // InternalPerl.g:1717:3: 'sort'
                    {
                     before(grammarAccess.getKeywordAccess().getSortKeyword_174()); 
                    match(input,199,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSortKeyword_174()); 

                    }


                    }
                    break;
                case 176 :
                    // InternalPerl.g:1722:2: ( 'splice' )
                    {
                    // InternalPerl.g:1722:2: ( 'splice' )
                    // InternalPerl.g:1723:3: 'splice'
                    {
                     before(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 
                    match(input,200,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 

                    }


                    }
                    break;
                case 177 :
                    // InternalPerl.g:1728:2: ( 'split' )
                    {
                    // InternalPerl.g:1728:2: ( 'split' )
                    // InternalPerl.g:1729:3: 'split'
                    {
                     before(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 
                    match(input,201,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 

                    }


                    }
                    break;
                case 178 :
                    // InternalPerl.g:1734:2: ( 'sprintf' )
                    {
                    // InternalPerl.g:1734:2: ( 'sprintf' )
                    // InternalPerl.g:1735:3: 'sprintf'
                    {
                     before(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 
                    match(input,202,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 

                    }


                    }
                    break;
                case 179 :
                    // InternalPerl.g:1740:2: ( 'sqrt' )
                    {
                    // InternalPerl.g:1740:2: ( 'sqrt' )
                    // InternalPerl.g:1741:3: 'sqrt'
                    {
                     before(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 
                    match(input,203,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 

                    }


                    }
                    break;
                case 180 :
                    // InternalPerl.g:1746:2: ( 'srand' )
                    {
                    // InternalPerl.g:1746:2: ( 'srand' )
                    // InternalPerl.g:1747:3: 'srand'
                    {
                     before(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 
                    match(input,204,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 

                    }


                    }
                    break;
                case 181 :
                    // InternalPerl.g:1752:2: ( 'stat' )
                    {
                    // InternalPerl.g:1752:2: ( 'stat' )
                    // InternalPerl.g:1753:3: 'stat'
                    {
                     before(grammarAccess.getKeywordAccess().getStatKeyword_180()); 
                    match(input,205,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStatKeyword_180()); 

                    }


                    }
                    break;
                case 182 :
                    // InternalPerl.g:1758:2: ( 'state' )
                    {
                    // InternalPerl.g:1758:2: ( 'state' )
                    // InternalPerl.g:1759:3: 'state'
                    {
                     before(grammarAccess.getKeywordAccess().getStateKeyword_181()); 
                    match(input,206,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStateKeyword_181()); 

                    }


                    }
                    break;
                case 183 :
                    // InternalPerl.g:1764:2: ( 'study' )
                    {
                    // InternalPerl.g:1764:2: ( 'study' )
                    // InternalPerl.g:1765:3: 'study'
                    {
                     before(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 
                    match(input,207,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 

                    }


                    }
                    break;
                case 184 :
                    // InternalPerl.g:1770:2: ( 'sub' )
                    {
                    // InternalPerl.g:1770:2: ( 'sub' )
                    // InternalPerl.g:1771:3: 'sub'
                    {
                     before(grammarAccess.getKeywordAccess().getSubKeyword_183()); 
                    match(input,208,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubKeyword_183()); 

                    }


                    }
                    break;
                case 185 :
                    // InternalPerl.g:1776:2: ( 'substr' )
                    {
                    // InternalPerl.g:1776:2: ( 'substr' )
                    // InternalPerl.g:1777:3: 'substr'
                    {
                     before(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 
                    match(input,209,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 

                    }


                    }
                    break;
                case 186 :
                    // InternalPerl.g:1782:2: ( 'symlink' )
                    {
                    // InternalPerl.g:1782:2: ( 'symlink' )
                    // InternalPerl.g:1783:3: 'symlink'
                    {
                     before(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 
                    match(input,210,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 

                    }


                    }
                    break;
                case 187 :
                    // InternalPerl.g:1788:2: ( 'syscall' )
                    {
                    // InternalPerl.g:1788:2: ( 'syscall' )
                    // InternalPerl.g:1789:3: 'syscall'
                    {
                     before(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 
                    match(input,211,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 

                    }


                    }
                    break;
                case 188 :
                    // InternalPerl.g:1794:2: ( 'sysopen' )
                    {
                    // InternalPerl.g:1794:2: ( 'sysopen' )
                    // InternalPerl.g:1795:3: 'sysopen'
                    {
                     before(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 
                    match(input,212,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 

                    }


                    }
                    break;
                case 189 :
                    // InternalPerl.g:1800:2: ( 'sysread' )
                    {
                    // InternalPerl.g:1800:2: ( 'sysread' )
                    // InternalPerl.g:1801:3: 'sysread'
                    {
                     before(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 
                    match(input,213,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 

                    }


                    }
                    break;
                case 190 :
                    // InternalPerl.g:1806:2: ( 'sysseek' )
                    {
                    // InternalPerl.g:1806:2: ( 'sysseek' )
                    // InternalPerl.g:1807:3: 'sysseek'
                    {
                     before(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 
                    match(input,214,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 

                    }


                    }
                    break;
                case 191 :
                    // InternalPerl.g:1812:2: ( 'system' )
                    {
                    // InternalPerl.g:1812:2: ( 'system' )
                    // InternalPerl.g:1813:3: 'system'
                    {
                     before(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 
                    match(input,215,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 

                    }


                    }
                    break;
                case 192 :
                    // InternalPerl.g:1818:2: ( 'syswrite' )
                    {
                    // InternalPerl.g:1818:2: ( 'syswrite' )
                    // InternalPerl.g:1819:3: 'syswrite'
                    {
                     before(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 
                    match(input,216,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 

                    }


                    }
                    break;
                case 193 :
                    // InternalPerl.g:1824:2: ( 'tell' )
                    {
                    // InternalPerl.g:1824:2: ( 'tell' )
                    // InternalPerl.g:1825:3: 'tell'
                    {
                     before(grammarAccess.getKeywordAccess().getTellKeyword_192()); 
                    match(input,217,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTellKeyword_192()); 

                    }


                    }
                    break;
                case 194 :
                    // InternalPerl.g:1830:2: ( 'telldir' )
                    {
                    // InternalPerl.g:1830:2: ( 'telldir' )
                    // InternalPerl.g:1831:3: 'telldir'
                    {
                     before(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 
                    match(input,218,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 

                    }


                    }
                    break;
                case 195 :
                    // InternalPerl.g:1836:2: ( 'tie' )
                    {
                    // InternalPerl.g:1836:2: ( 'tie' )
                    // InternalPerl.g:1837:3: 'tie'
                    {
                     before(grammarAccess.getKeywordAccess().getTieKeyword_194()); 
                    match(input,219,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTieKeyword_194()); 

                    }


                    }
                    break;
                case 196 :
                    // InternalPerl.g:1842:2: ( 'tied' )
                    {
                    // InternalPerl.g:1842:2: ( 'tied' )
                    // InternalPerl.g:1843:3: 'tied'
                    {
                     before(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 
                    match(input,220,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 

                    }


                    }
                    break;
                case 197 :
                    // InternalPerl.g:1848:2: ( 'time' )
                    {
                    // InternalPerl.g:1848:2: ( 'time' )
                    // InternalPerl.g:1849:3: 'time'
                    {
                     before(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 
                    match(input,221,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 

                    }


                    }
                    break;
                case 198 :
                    // InternalPerl.g:1854:2: ( 'times' )
                    {
                    // InternalPerl.g:1854:2: ( 'times' )
                    // InternalPerl.g:1855:3: 'times'
                    {
                     before(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 
                    match(input,222,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 

                    }


                    }
                    break;
                case 199 :
                    // InternalPerl.g:1860:2: ( 'tr' )
                    {
                    // InternalPerl.g:1860:2: ( 'tr' )
                    // InternalPerl.g:1861:3: 'tr'
                    {
                     before(grammarAccess.getKeywordAccess().getTrKeyword_198()); 
                    match(input,223,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTrKeyword_198()); 

                    }


                    }
                    break;
                case 200 :
                    // InternalPerl.g:1866:2: ( 'truncate' )
                    {
                    // InternalPerl.g:1866:2: ( 'truncate' )
                    // InternalPerl.g:1867:3: 'truncate'
                    {
                     before(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 
                    match(input,224,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 

                    }


                    }
                    break;
                case 201 :
                    // InternalPerl.g:1872:2: ( 'uc' )
                    {
                    // InternalPerl.g:1872:2: ( 'uc' )
                    // InternalPerl.g:1873:3: 'uc'
                    {
                     before(grammarAccess.getKeywordAccess().getUcKeyword_200()); 
                    match(input,225,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcKeyword_200()); 

                    }


                    }
                    break;
                case 202 :
                    // InternalPerl.g:1878:2: ( 'ucfirst' )
                    {
                    // InternalPerl.g:1878:2: ( 'ucfirst' )
                    // InternalPerl.g:1879:3: 'ucfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 
                    match(input,226,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 

                    }


                    }
                    break;
                case 203 :
                    // InternalPerl.g:1884:2: ( 'umask' )
                    {
                    // InternalPerl.g:1884:2: ( 'umask' )
                    // InternalPerl.g:1885:3: 'umask'
                    {
                     before(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 
                    match(input,227,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 

                    }


                    }
                    break;
                case 204 :
                    // InternalPerl.g:1890:2: ( 'undef' )
                    {
                    // InternalPerl.g:1890:2: ( 'undef' )
                    // InternalPerl.g:1891:3: 'undef'
                    {
                     before(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 
                    match(input,228,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 

                    }


                    }
                    break;
                case 205 :
                    // InternalPerl.g:1896:2: ( 'unless' )
                    {
                    // InternalPerl.g:1896:2: ( 'unless' )
                    // InternalPerl.g:1897:3: 'unless'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 
                    match(input,229,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 

                    }


                    }
                    break;
                case 206 :
                    // InternalPerl.g:1902:2: ( 'unlink' )
                    {
                    // InternalPerl.g:1902:2: ( 'unlink' )
                    // InternalPerl.g:1903:3: 'unlink'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 
                    match(input,230,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 

                    }


                    }
                    break;
                case 207 :
                    // InternalPerl.g:1908:2: ( 'unpack' )
                    {
                    // InternalPerl.g:1908:2: ( 'unpack' )
                    // InternalPerl.g:1909:3: 'unpack'
                    {
                     before(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 
                    match(input,231,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 

                    }


                    }
                    break;
                case 208 :
                    // InternalPerl.g:1914:2: ( 'unshift' )
                    {
                    // InternalPerl.g:1914:2: ( 'unshift' )
                    // InternalPerl.g:1915:3: 'unshift'
                    {
                     before(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 
                    match(input,232,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 

                    }


                    }
                    break;
                case 209 :
                    // InternalPerl.g:1920:2: ( 'untie' )
                    {
                    // InternalPerl.g:1920:2: ( 'untie' )
                    // InternalPerl.g:1921:3: 'untie'
                    {
                     before(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 
                    match(input,233,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 

                    }


                    }
                    break;
                case 210 :
                    // InternalPerl.g:1926:2: ( 'until' )
                    {
                    // InternalPerl.g:1926:2: ( 'until' )
                    // InternalPerl.g:1927:3: 'until'
                    {
                     before(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 
                    match(input,234,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 

                    }


                    }
                    break;
                case 211 :
                    // InternalPerl.g:1932:2: ( 'use' )
                    {
                    // InternalPerl.g:1932:2: ( 'use' )
                    // InternalPerl.g:1933:3: 'use'
                    {
                     before(grammarAccess.getKeywordAccess().getUseKeyword_210()); 
                    match(input,235,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUseKeyword_210()); 

                    }


                    }
                    break;
                case 212 :
                    // InternalPerl.g:1938:2: ( 'utime' )
                    {
                    // InternalPerl.g:1938:2: ( 'utime' )
                    // InternalPerl.g:1939:3: 'utime'
                    {
                     before(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 
                    match(input,236,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 

                    }


                    }
                    break;
                case 213 :
                    // InternalPerl.g:1944:2: ( 'values' )
                    {
                    // InternalPerl.g:1944:2: ( 'values' )
                    // InternalPerl.g:1945:3: 'values'
                    {
                     before(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 
                    match(input,237,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 

                    }


                    }
                    break;
                case 214 :
                    // InternalPerl.g:1950:2: ( 'vec' )
                    {
                    // InternalPerl.g:1950:2: ( 'vec' )
                    // InternalPerl.g:1951:3: 'vec'
                    {
                     before(grammarAccess.getKeywordAccess().getVecKeyword_213()); 
                    match(input,238,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getVecKeyword_213()); 

                    }


                    }
                    break;
                case 215 :
                    // InternalPerl.g:1956:2: ( 'wait' )
                    {
                    // InternalPerl.g:1956:2: ( 'wait' )
                    // InternalPerl.g:1957:3: 'wait'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 
                    match(input,239,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 

                    }


                    }
                    break;
                case 216 :
                    // InternalPerl.g:1962:2: ( 'waitpid' )
                    {
                    // InternalPerl.g:1962:2: ( 'waitpid' )
                    // InternalPerl.g:1963:3: 'waitpid'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 
                    match(input,240,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 

                    }


                    }
                    break;
                case 217 :
                    // InternalPerl.g:1968:2: ( 'wantarray' )
                    {
                    // InternalPerl.g:1968:2: ( 'wantarray' )
                    // InternalPerl.g:1969:3: 'wantarray'
                    {
                     before(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 
                    match(input,241,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 

                    }


                    }
                    break;
                case 218 :
                    // InternalPerl.g:1974:2: ( 'warn' )
                    {
                    // InternalPerl.g:1974:2: ( 'warn' )
                    // InternalPerl.g:1975:3: 'warn'
                    {
                     before(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 
                    match(input,242,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 

                    }


                    }
                    break;
                case 219 :
                    // InternalPerl.g:1980:2: ( 'when' )
                    {
                    // InternalPerl.g:1980:2: ( 'when' )
                    // InternalPerl.g:1981:3: 'when'
                    {
                     before(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 
                    match(input,243,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 

                    }


                    }
                    break;
                case 220 :
                    // InternalPerl.g:1986:2: ( 'while' )
                    {
                    // InternalPerl.g:1986:2: ( 'while' )
                    // InternalPerl.g:1987:3: 'while'
                    {
                     before(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 
                    match(input,244,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 

                    }


                    }
                    break;
                case 221 :
                    // InternalPerl.g:1992:2: ( 'write' )
                    {
                    // InternalPerl.g:1992:2: ( 'write' )
                    // InternalPerl.g:1993:3: 'write'
                    {
                     before(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 
                    match(input,245,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 

                    }


                    }
                    break;
                case 222 :
                    // InternalPerl.g:1998:2: ( 'y' )
                    {
                    // InternalPerl.g:1998:2: ( 'y' )
                    // InternalPerl.g:1999:3: 'y'
                    {
                     before(grammarAccess.getKeywordAccess().getYKeyword_221()); 
                    match(input,246,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getYKeyword_221()); 

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
    // InternalPerl.g:2008:1: rule__Operator__Alternatives : ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2012:1: ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) )
            int alt10=64;
            switch ( input.LA(1) ) {
            case 247:
                {
                alt10=1;
                }
                break;
            case 248:
                {
                alt10=2;
                }
                break;
            case 249:
                {
                alt10=3;
                }
                break;
            case 250:
                {
                alt10=4;
                }
                break;
            case 251:
                {
                alt10=5;
                }
                break;
            case 252:
                {
                alt10=6;
                }
                break;
            case 253:
                {
                alt10=7;
                }
                break;
            case 254:
                {
                alt10=8;
                }
                break;
            case 255:
                {
                alt10=9;
                }
                break;
            case 256:
                {
                alt10=10;
                }
                break;
            case 257:
                {
                alt10=11;
                }
                break;
            case 258:
                {
                alt10=12;
                }
                break;
            case 259:
                {
                alt10=13;
                }
                break;
            case 260:
                {
                alt10=14;
                }
                break;
            case 261:
                {
                alt10=15;
                }
                break;
            case 262:
                {
                alt10=16;
                }
                break;
            case 263:
                {
                alt10=17;
                }
                break;
            case 264:
                {
                alt10=18;
                }
                break;
            case 265:
                {
                alt10=19;
                }
                break;
            case 266:
                {
                alt10=20;
                }
                break;
            case 267:
                {
                alt10=21;
                }
                break;
            case 268:
                {
                alt10=22;
                }
                break;
            case 269:
                {
                alt10=23;
                }
                break;
            case 338:
                {
                alt10=24;
                }
                break;
            case 270:
                {
                alt10=25;
                }
                break;
            case 271:
                {
                alt10=26;
                }
                break;
            case 272:
                {
                alt10=27;
                }
                break;
            case 273:
                {
                alt10=28;
                }
                break;
            case 274:
                {
                alt10=29;
                }
                break;
            case 275:
                {
                alt10=30;
                }
                break;
            case 276:
                {
                alt10=31;
                }
                break;
            case 277:
                {
                alt10=32;
                }
                break;
            case 278:
                {
                alt10=33;
                }
                break;
            case 279:
                {
                alt10=34;
                }
                break;
            case 280:
                {
                alt10=35;
                }
                break;
            case 281:
                {
                alt10=36;
                }
                break;
            case 282:
                {
                alt10=37;
                }
                break;
            case 283:
                {
                alt10=38;
                }
                break;
            case 284:
                {
                alt10=39;
                }
                break;
            case 285:
                {
                alt10=40;
                }
                break;
            case 286:
                {
                alt10=41;
                }
                break;
            case 287:
                {
                alt10=42;
                }
                break;
            case 288:
                {
                alt10=43;
                }
                break;
            case 289:
                {
                alt10=44;
                }
                break;
            case 290:
                {
                alt10=45;
                }
                break;
            case 291:
                {
                alt10=46;
                }
                break;
            case 292:
                {
                alt10=47;
                }
                break;
            case 293:
                {
                alt10=48;
                }
                break;
            case 294:
                {
                alt10=49;
                }
                break;
            case 295:
                {
                alt10=50;
                }
                break;
            case 296:
                {
                alt10=51;
                }
                break;
            case 297:
                {
                alt10=52;
                }
                break;
            case 298:
                {
                alt10=53;
                }
                break;
            case 299:
                {
                alt10=54;
                }
                break;
            case 300:
                {
                alt10=55;
                }
                break;
            case 301:
                {
                alt10=56;
                }
                break;
            case 302:
                {
                alt10=57;
                }
                break;
            case 303:
                {
                alt10=58;
                }
                break;
            case 304:
                {
                alt10=59;
                }
                break;
            case 305:
                {
                alt10=60;
                }
                break;
            case 306:
                {
                alt10=61;
                }
                break;
            case 307:
                {
                alt10=62;
                }
                break;
            case 308:
                {
                alt10=63;
                }
                break;
            case 309:
                {
                alt10=64;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalPerl.g:2013:2: ( '++' )
                    {
                    // InternalPerl.g:2013:2: ( '++' )
                    // InternalPerl.g:2014:3: '++'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 
                    match(input,247,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2019:2: ( '--' )
                    {
                    // InternalPerl.g:2019:2: ( '--' )
                    // InternalPerl.g:2020:3: '--'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    match(input,248,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2025:2: ( '**' )
                    {
                    // InternalPerl.g:2025:2: ( '**' )
                    // InternalPerl.g:2026:3: '**'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 
                    match(input,249,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2031:2: ( '!' )
                    {
                    // InternalPerl.g:2031:2: ( '!' )
                    // InternalPerl.g:2032:3: '!'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 
                    match(input,250,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2037:2: ( '~' )
                    {
                    // InternalPerl.g:2037:2: ( '~' )
                    // InternalPerl.g:2038:3: '~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 
                    match(input,251,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2043:2: ( '+' )
                    {
                    // InternalPerl.g:2043:2: ( '+' )
                    // InternalPerl.g:2044:3: '+'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 
                    match(input,252,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2049:2: ( '-' )
                    {
                    // InternalPerl.g:2049:2: ( '-' )
                    // InternalPerl.g:2050:3: '-'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 
                    match(input,253,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2055:2: ( '=~' )
                    {
                    // InternalPerl.g:2055:2: ( '=~' )
                    // InternalPerl.g:2056:3: '=~'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 
                    match(input,254,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2061:2: ( '!~' )
                    {
                    // InternalPerl.g:2061:2: ( '!~' )
                    // InternalPerl.g:2062:3: '!~'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 
                    match(input,255,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2067:2: ( '*' )
                    {
                    // InternalPerl.g:2067:2: ( '*' )
                    // InternalPerl.g:2068:3: '*'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 
                    match(input,256,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2073:2: ( '/' )
                    {
                    // InternalPerl.g:2073:2: ( '/' )
                    // InternalPerl.g:2074:3: '/'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 
                    match(input,257,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2079:2: ( '%' )
                    {
                    // InternalPerl.g:2079:2: ( '%' )
                    // InternalPerl.g:2080:3: '%'
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 
                    match(input,258,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2085:2: ( 'x' )
                    {
                    // InternalPerl.g:2085:2: ( 'x' )
                    // InternalPerl.g:2086:3: 'x'
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_12()); 
                    match(input,259,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2091:2: ( '<<' )
                    {
                    // InternalPerl.g:2091:2: ( '<<' )
                    // InternalPerl.g:2092:3: '<<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 
                    match(input,260,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2097:2: ( '>>' )
                    {
                    // InternalPerl.g:2097:2: ( '>>' )
                    // InternalPerl.g:2098:3: '>>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 
                    match(input,261,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2103:2: ( 'lt' )
                    {
                    // InternalPerl.g:2103:2: ( 'lt' )
                    // InternalPerl.g:2104:3: 'lt'
                    {
                     before(grammarAccess.getOperatorAccess().getLtKeyword_15()); 
                    match(input,262,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLtKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2109:2: ( 'gt' )
                    {
                    // InternalPerl.g:2109:2: ( 'gt' )
                    // InternalPerl.g:2110:3: 'gt'
                    {
                     before(grammarAccess.getOperatorAccess().getGtKeyword_16()); 
                    match(input,263,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGtKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2115:2: ( 'le' )
                    {
                    // InternalPerl.g:2115:2: ( 'le' )
                    // InternalPerl.g:2116:3: 'le'
                    {
                     before(grammarAccess.getOperatorAccess().getLeKeyword_17()); 
                    match(input,264,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLeKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2121:2: ( 'ge' )
                    {
                    // InternalPerl.g:2121:2: ( 'ge' )
                    // InternalPerl.g:2122:3: 'ge'
                    {
                     before(grammarAccess.getOperatorAccess().getGeKeyword_18()); 
                    match(input,265,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGeKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2127:2: ( 'cmp' )
                    {
                    // InternalPerl.g:2127:2: ( 'cmp' )
                    // InternalPerl.g:2128:3: 'cmp'
                    {
                     before(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 
                    match(input,266,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2133:2: ( '~~' )
                    {
                    // InternalPerl.g:2133:2: ( '~~' )
                    // InternalPerl.g:2134:3: '~~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 
                    match(input,267,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2139:2: ( '==' )
                    {
                    // InternalPerl.g:2139:2: ( '==' )
                    // InternalPerl.g:2140:3: '=='
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 
                    match(input,268,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2145:2: ( '!=' )
                    {
                    // InternalPerl.g:2145:2: ( '!=' )
                    // InternalPerl.g:2146:3: '!='
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 
                    match(input,269,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2151:2: ( ( rule__Operator__Group_23__0 ) )
                    {
                    // InternalPerl.g:2151:2: ( ( rule__Operator__Group_23__0 ) )
                    // InternalPerl.g:2152:3: ( rule__Operator__Group_23__0 )
                    {
                     before(grammarAccess.getOperatorAccess().getGroup_23()); 
                    // InternalPerl.g:2153:3: ( rule__Operator__Group_23__0 )
                    // InternalPerl.g:2153:4: rule__Operator__Group_23__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operator__Group_23__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getOperatorAccess().getGroup_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:2157:2: ( '..' )
                    {
                    // InternalPerl.g:2157:2: ( '..' )
                    // InternalPerl.g:2158:3: '..'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 
                    match(input,270,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2163:2: ( '...' )
                    {
                    // InternalPerl.g:2163:2: ( '...' )
                    // InternalPerl.g:2164:3: '...'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 
                    match(input,271,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2169:2: ( ',' )
                    {
                    // InternalPerl.g:2169:2: ( ',' )
                    // InternalPerl.g:2170:3: ','
                    {
                     before(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 
                    match(input,272,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:2175:2: ( '&' )
                    {
                    // InternalPerl.g:2175:2: ( '&' )
                    // InternalPerl.g:2176:3: '&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 
                    match(input,273,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:2181:2: ( '|' )
                    {
                    // InternalPerl.g:2181:2: ( '|' )
                    // InternalPerl.g:2182:3: '|'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 
                    match(input,274,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:2187:2: ( '^' )
                    {
                    // InternalPerl.g:2187:2: ( '^' )
                    // InternalPerl.g:2188:3: '^'
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 
                    match(input,275,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:2193:2: ( '&&' )
                    {
                    // InternalPerl.g:2193:2: ( '&&' )
                    // InternalPerl.g:2194:3: '&&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 
                    match(input,276,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:2199:2: ( '||' )
                    {
                    // InternalPerl.g:2199:2: ( '||' )
                    // InternalPerl.g:2200:3: '||'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 
                    match(input,277,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:2205:2: ( '//' )
                    {
                    // InternalPerl.g:2205:2: ( '//' )
                    // InternalPerl.g:2206:3: '//'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 
                    match(input,278,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:2211:2: ( '?' )
                    {
                    // InternalPerl.g:2211:2: ( '?' )
                    // InternalPerl.g:2212:3: '?'
                    {
                     before(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 
                    match(input,279,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:2217:2: ( ':' )
                    {
                    // InternalPerl.g:2217:2: ( ':' )
                    // InternalPerl.g:2218:3: ':'
                    {
                     before(grammarAccess.getOperatorAccess().getColonKeyword_34()); 
                    match(input,280,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getColonKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:2223:2: ( '**=' )
                    {
                    // InternalPerl.g:2223:2: ( '**=' )
                    // InternalPerl.g:2224:3: '**='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 
                    match(input,281,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:2229:2: ( '+=' )
                    {
                    // InternalPerl.g:2229:2: ( '+=' )
                    // InternalPerl.g:2230:3: '+='
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 
                    match(input,282,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:2235:2: ( '-=' )
                    {
                    // InternalPerl.g:2235:2: ( '-=' )
                    // InternalPerl.g:2236:3: '-='
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 
                    match(input,283,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:2241:2: ( '.=' )
                    {
                    // InternalPerl.g:2241:2: ( '.=' )
                    // InternalPerl.g:2242:3: '.='
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 
                    match(input,284,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:2247:2: ( '*=' )
                    {
                    // InternalPerl.g:2247:2: ( '*=' )
                    // InternalPerl.g:2248:3: '*='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 
                    match(input,285,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:2253:2: ( '/=' )
                    {
                    // InternalPerl.g:2253:2: ( '/=' )
                    // InternalPerl.g:2254:3: '/='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 
                    match(input,286,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:2259:2: ( '%=' )
                    {
                    // InternalPerl.g:2259:2: ( '%=' )
                    // InternalPerl.g:2260:3: '%='
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 
                    match(input,287,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:2265:2: ( 'x=' )
                    {
                    // InternalPerl.g:2265:2: ( 'x=' )
                    // InternalPerl.g:2266:3: 'x='
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_42()); 
                    match(input,288,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:2271:2: ( '&=' )
                    {
                    // InternalPerl.g:2271:2: ( '&=' )
                    // InternalPerl.g:2272:3: '&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 
                    match(input,289,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:2277:2: ( '|=' )
                    {
                    // InternalPerl.g:2277:2: ( '|=' )
                    // InternalPerl.g:2278:3: '|='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 
                    match(input,290,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:2283:2: ( '^=' )
                    {
                    // InternalPerl.g:2283:2: ( '^=' )
                    // InternalPerl.g:2284:3: '^='
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 
                    match(input,291,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:2289:2: ( '<<=' )
                    {
                    // InternalPerl.g:2289:2: ( '<<=' )
                    // InternalPerl.g:2290:3: '<<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 
                    match(input,292,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:2295:2: ( '>>=' )
                    {
                    // InternalPerl.g:2295:2: ( '>>=' )
                    // InternalPerl.g:2296:3: '>>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 
                    match(input,293,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:2301:2: ( '&&=' )
                    {
                    // InternalPerl.g:2301:2: ( '&&=' )
                    // InternalPerl.g:2302:3: '&&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 
                    match(input,294,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:2307:2: ( '||=' )
                    {
                    // InternalPerl.g:2307:2: ( '||=' )
                    // InternalPerl.g:2308:3: '||='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 
                    match(input,295,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:2313:2: ( '//=' )
                    {
                    // InternalPerl.g:2313:2: ( '//=' )
                    // InternalPerl.g:2314:3: '//='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 
                    match(input,296,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:2319:2: ( '<' )
                    {
                    // InternalPerl.g:2319:2: ( '<' )
                    // InternalPerl.g:2320:3: '<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 
                    match(input,297,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:2325:2: ( '>' )
                    {
                    // InternalPerl.g:2325:2: ( '>' )
                    // InternalPerl.g:2326:3: '>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 
                    match(input,298,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:2331:2: ( '<=' )
                    {
                    // InternalPerl.g:2331:2: ( '<=' )
                    // InternalPerl.g:2332:3: '<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 
                    match(input,299,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:2337:2: ( '>=' )
                    {
                    // InternalPerl.g:2337:2: ( '>=' )
                    // InternalPerl.g:2338:3: '>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 
                    match(input,300,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:2343:2: ( '<>' )
                    {
                    // InternalPerl.g:2343:2: ( '<>' )
                    // InternalPerl.g:2344:3: '<>'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 
                    match(input,301,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:2349:2: ( '=>' )
                    {
                    // InternalPerl.g:2349:2: ( '=>' )
                    // InternalPerl.g:2350:3: '=>'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 
                    match(input,302,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:2355:2: ( '->' )
                    {
                    // InternalPerl.g:2355:2: ( '->' )
                    // InternalPerl.g:2356:3: '->'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 
                    match(input,303,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:2361:2: ( 'and' )
                    {
                    // InternalPerl.g:2361:2: ( 'and' )
                    // InternalPerl.g:2362:3: 'and'
                    {
                     before(grammarAccess.getOperatorAccess().getAndKeyword_58()); 
                    match(input,304,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAndKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:2367:2: ( 'or' )
                    {
                    // InternalPerl.g:2367:2: ( 'or' )
                    // InternalPerl.g:2368:3: 'or'
                    {
                     before(grammarAccess.getOperatorAccess().getOrKeyword_59()); 
                    match(input,305,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getOrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:2373:2: ( 'xor' )
                    {
                    // InternalPerl.g:2373:2: ( 'xor' )
                    // InternalPerl.g:2374:3: 'xor'
                    {
                     before(grammarAccess.getOperatorAccess().getXorKeyword_60()); 
                    match(input,306,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXorKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:2379:2: ( 'not' )
                    {
                    // InternalPerl.g:2379:2: ( 'not' )
                    // InternalPerl.g:2380:3: 'not'
                    {
                     before(grammarAccess.getOperatorAccess().getNotKeyword_61()); 
                    match(input,307,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getNotKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:2385:2: ( 'eq' )
                    {
                    // InternalPerl.g:2385:2: ( 'eq' )
                    // InternalPerl.g:2386:3: 'eq'
                    {
                     before(grammarAccess.getOperatorAccess().getEqKeyword_62()); 
                    match(input,308,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:2391:2: ( 'ne' )
                    {
                    // InternalPerl.g:2391:2: ( 'ne' )
                    // InternalPerl.g:2392:3: 'ne'
                    {
                     before(grammarAccess.getOperatorAccess().getNeKeyword_63()); 
                    match(input,309,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getNeKeyword_63()); 

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
    // InternalPerl.g:2401:1: rule__FileTestOperator__Alternatives : ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) );
    public final void rule__FileTestOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2405:1: ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) )
            int alt11=27;
            switch ( input.LA(1) ) {
            case 310:
                {
                alt11=1;
                }
                break;
            case 311:
                {
                alt11=2;
                }
                break;
            case 312:
                {
                alt11=3;
                }
                break;
            case 313:
                {
                alt11=4;
                }
                break;
            case 314:
                {
                alt11=5;
                }
                break;
            case 315:
                {
                alt11=6;
                }
                break;
            case 316:
                {
                alt11=7;
                }
                break;
            case 317:
                {
                alt11=8;
                }
                break;
            case 318:
                {
                alt11=9;
                }
                break;
            case 319:
                {
                alt11=10;
                }
                break;
            case 320:
                {
                alt11=11;
                }
                break;
            case 321:
                {
                alt11=12;
                }
                break;
            case 322:
                {
                alt11=13;
                }
                break;
            case 323:
                {
                alt11=14;
                }
                break;
            case 324:
                {
                alt11=15;
                }
                break;
            case 325:
                {
                alt11=16;
                }
                break;
            case 326:
                {
                alt11=17;
                }
                break;
            case 327:
                {
                alt11=18;
                }
                break;
            case 328:
                {
                alt11=19;
                }
                break;
            case 329:
                {
                alt11=20;
                }
                break;
            case 330:
                {
                alt11=21;
                }
                break;
            case 331:
                {
                alt11=22;
                }
                break;
            case 332:
                {
                alt11=23;
                }
                break;
            case 333:
                {
                alt11=24;
                }
                break;
            case 334:
                {
                alt11=25;
                }
                break;
            case 335:
                {
                alt11=26;
                }
                break;
            case 336:
                {
                alt11=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalPerl.g:2406:2: ( '-r' )
                    {
                    // InternalPerl.g:2406:2: ( '-r' )
                    // InternalPerl.g:2407:3: '-r'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 
                    match(input,310,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2412:2: ( '-w' )
                    {
                    // InternalPerl.g:2412:2: ( '-w' )
                    // InternalPerl.g:2413:3: '-w'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 
                    match(input,311,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2418:2: ( '-x' )
                    {
                    // InternalPerl.g:2418:2: ( '-x' )
                    // InternalPerl.g:2419:3: '-x'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 
                    match(input,312,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2424:2: ( '-o' )
                    {
                    // InternalPerl.g:2424:2: ( '-o' )
                    // InternalPerl.g:2425:3: '-o'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 
                    match(input,313,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2430:2: ( '-R' )
                    {
                    // InternalPerl.g:2430:2: ( '-R' )
                    // InternalPerl.g:2431:3: '-R'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 
                    match(input,314,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2436:2: ( '-W' )
                    {
                    // InternalPerl.g:2436:2: ( '-W' )
                    // InternalPerl.g:2437:3: '-W'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 
                    match(input,315,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2442:2: ( '-X' )
                    {
                    // InternalPerl.g:2442:2: ( '-X' )
                    // InternalPerl.g:2443:3: '-X'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 
                    match(input,316,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2448:2: ( '-O' )
                    {
                    // InternalPerl.g:2448:2: ( '-O' )
                    // InternalPerl.g:2449:3: '-O'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 
                    match(input,317,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2454:2: ( '-e' )
                    {
                    // InternalPerl.g:2454:2: ( '-e' )
                    // InternalPerl.g:2455:3: '-e'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 
                    match(input,318,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2460:2: ( '-z' )
                    {
                    // InternalPerl.g:2460:2: ( '-z' )
                    // InternalPerl.g:2461:3: '-z'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 
                    match(input,319,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2466:2: ( '-s' )
                    {
                    // InternalPerl.g:2466:2: ( '-s' )
                    // InternalPerl.g:2467:3: '-s'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 
                    match(input,320,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2472:2: ( '-f' )
                    {
                    // InternalPerl.g:2472:2: ( '-f' )
                    // InternalPerl.g:2473:3: '-f'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 
                    match(input,321,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2478:2: ( '-d' )
                    {
                    // InternalPerl.g:2478:2: ( '-d' )
                    // InternalPerl.g:2479:3: '-d'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 
                    match(input,322,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2484:2: ( '-l' )
                    {
                    // InternalPerl.g:2484:2: ( '-l' )
                    // InternalPerl.g:2485:3: '-l'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 
                    match(input,323,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2490:2: ( '-p' )
                    {
                    // InternalPerl.g:2490:2: ( '-p' )
                    // InternalPerl.g:2491:3: '-p'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 
                    match(input,324,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2496:2: ( '-S' )
                    {
                    // InternalPerl.g:2496:2: ( '-S' )
                    // InternalPerl.g:2497:3: '-S'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 
                    match(input,325,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2502:2: ( '-b' )
                    {
                    // InternalPerl.g:2502:2: ( '-b' )
                    // InternalPerl.g:2503:3: '-b'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 
                    match(input,326,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2508:2: ( '-c' )
                    {
                    // InternalPerl.g:2508:2: ( '-c' )
                    // InternalPerl.g:2509:3: '-c'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 
                    match(input,327,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2514:2: ( '-t' )
                    {
                    // InternalPerl.g:2514:2: ( '-t' )
                    // InternalPerl.g:2515:3: '-t'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 
                    match(input,328,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2520:2: ( '-u' )
                    {
                    // InternalPerl.g:2520:2: ( '-u' )
                    // InternalPerl.g:2521:3: '-u'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 
                    match(input,329,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2526:2: ( '-g' )
                    {
                    // InternalPerl.g:2526:2: ( '-g' )
                    // InternalPerl.g:2527:3: '-g'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 
                    match(input,330,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2532:2: ( '-k' )
                    {
                    // InternalPerl.g:2532:2: ( '-k' )
                    // InternalPerl.g:2533:3: '-k'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 
                    match(input,331,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2538:2: ( '-T' )
                    {
                    // InternalPerl.g:2538:2: ( '-T' )
                    // InternalPerl.g:2539:3: '-T'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 
                    match(input,332,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2544:2: ( '-B' )
                    {
                    // InternalPerl.g:2544:2: ( '-B' )
                    // InternalPerl.g:2545:3: '-B'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 
                    match(input,333,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:2550:2: ( '-M' )
                    {
                    // InternalPerl.g:2550:2: ( '-M' )
                    // InternalPerl.g:2551:3: '-M'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 
                    match(input,334,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2556:2: ( '-A' )
                    {
                    // InternalPerl.g:2556:2: ( '-A' )
                    // InternalPerl.g:2557:3: '-A'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 
                    match(input,335,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2562:2: ( '-C' )
                    {
                    // InternalPerl.g:2562:2: ( '-C' )
                    // InternalPerl.g:2563:3: '-C'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_26()); 
                    match(input,336,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getCKeyword_26()); 

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


    // $ANTLR start "rule__PerlDocument__Group__0"
    // InternalPerl.g:2572:1: rule__PerlDocument__Group__0 : rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 ;
    public final void rule__PerlDocument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2576:1: ( rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 )
            // InternalPerl.g:2577:2: rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__PerlDocument__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PerlDocument__Group__1();

            state._fsp--;


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
    // InternalPerl.g:2584:1: rule__PerlDocument__Group__0__Impl : ( () ) ;
    public final void rule__PerlDocument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2588:1: ( ( () ) )
            // InternalPerl.g:2589:1: ( () )
            {
            // InternalPerl.g:2589:1: ( () )
            // InternalPerl.g:2590:2: ()
            {
             before(grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0()); 
            // InternalPerl.g:2591:2: ()
            // InternalPerl.g:2591:3: 
            {
            }

             after(grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0()); 

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
    // InternalPerl.g:2599:1: rule__PerlDocument__Group__1 : rule__PerlDocument__Group__1__Impl ;
    public final void rule__PerlDocument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2603:1: ( rule__PerlDocument__Group__1__Impl )
            // InternalPerl.g:2604:2: rule__PerlDocument__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PerlDocument__Group__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:2610:1: rule__PerlDocument__Group__1__Impl : ( ( rule__PerlDocument__ElementsAssignment_1 )* ) ;
    public final void rule__PerlDocument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2614:1: ( ( ( rule__PerlDocument__ElementsAssignment_1 )* ) )
            // InternalPerl.g:2615:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            {
            // InternalPerl.g:2615:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            // InternalPerl.g:2616:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            {
             before(grammarAccess.getPerlDocumentAccess().getElementsAssignment_1()); 
            // InternalPerl.g:2617:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_LITERAL)||(LA12_0>=RULE_WORDS_QUOTE_LIKE && LA12_0<=RULE_READLINE_QUOTE)||(LA12_0>=25 && LA12_0<=336)||LA12_0==338) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPerl.g:2617:3: rule__PerlDocument__ElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__PerlDocument__ElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getPerlDocumentAccess().getElementsAssignment_1()); 

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


    // $ANTLR start "rule__StatementNode__Group__0"
    // InternalPerl.g:2626:1: rule__StatementNode__Group__0 : rule__StatementNode__Group__0__Impl rule__StatementNode__Group__1 ;
    public final void rule__StatementNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2630:1: ( rule__StatementNode__Group__0__Impl rule__StatementNode__Group__1 )
            // InternalPerl.g:2631:2: rule__StatementNode__Group__0__Impl rule__StatementNode__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__StatementNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StatementNode__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__StatementNode__Group__0"


    // $ANTLR start "rule__StatementNode__Group__0__Impl"
    // InternalPerl.g:2638:1: rule__StatementNode__Group__0__Impl : ( ( rule__StatementNode__Alternatives_0 ) ) ;
    public final void rule__StatementNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2642:1: ( ( ( rule__StatementNode__Alternatives_0 ) ) )
            // InternalPerl.g:2643:1: ( ( rule__StatementNode__Alternatives_0 ) )
            {
            // InternalPerl.g:2643:1: ( ( rule__StatementNode__Alternatives_0 ) )
            // InternalPerl.g:2644:2: ( rule__StatementNode__Alternatives_0 )
            {
             before(grammarAccess.getStatementNodeAccess().getAlternatives_0()); 
            // InternalPerl.g:2645:2: ( rule__StatementNode__Alternatives_0 )
            // InternalPerl.g:2645:3: rule__StatementNode__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__StatementNode__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getStatementNodeAccess().getAlternatives_0()); 

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
    // $ANTLR end "rule__StatementNode__Group__0__Impl"


    // $ANTLR start "rule__StatementNode__Group__1"
    // InternalPerl.g:2653:1: rule__StatementNode__Group__1 : rule__StatementNode__Group__1__Impl ;
    public final void rule__StatementNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2657:1: ( rule__StatementNode__Group__1__Impl )
            // InternalPerl.g:2658:2: rule__StatementNode__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StatementNode__Group__1__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__StatementNode__Group__1"


    // $ANTLR start "rule__StatementNode__Group__1__Impl"
    // InternalPerl.g:2664:1: rule__StatementNode__Group__1__Impl : ( ';' ) ;
    public final void rule__StatementNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2668:1: ( ( ';' ) )
            // InternalPerl.g:2669:1: ( ';' )
            {
            // InternalPerl.g:2669:1: ( ';' )
            // InternalPerl.g:2670:2: ';'
            {
             before(grammarAccess.getStatementNodeAccess().getSemicolonKeyword_1()); 
            match(input,337,FOLLOW_2); 
             after(grammarAccess.getStatementNodeAccess().getSemicolonKeyword_1()); 

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
    // $ANTLR end "rule__StatementNode__Group__1__Impl"


    // $ANTLR start "rule__PackageStatement__Group__0"
    // InternalPerl.g:2680:1: rule__PackageStatement__Group__0 : rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 ;
    public final void rule__PackageStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2684:1: ( rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 )
            // InternalPerl.g:2685:2: rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__PackageStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageStatement__Group__1();

            state._fsp--;


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
    // InternalPerl.g:2692:1: rule__PackageStatement__Group__0__Impl : ( () ) ;
    public final void rule__PackageStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2696:1: ( ( () ) )
            // InternalPerl.g:2697:1: ( () )
            {
            // InternalPerl.g:2697:1: ( () )
            // InternalPerl.g:2698:2: ()
            {
             before(grammarAccess.getPackageStatementAccess().getPackageStatementAction_0()); 
            // InternalPerl.g:2699:2: ()
            // InternalPerl.g:2699:3: 
            {
            }

             after(grammarAccess.getPackageStatementAccess().getPackageStatementAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__Group__0__Impl"


    // $ANTLR start "rule__PackageStatement__Group__1"
    // InternalPerl.g:2707:1: rule__PackageStatement__Group__1 : rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 ;
    public final void rule__PackageStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2711:1: ( rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 )
            // InternalPerl.g:2712:2: rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__PackageStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageStatement__Group__2();

            state._fsp--;


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
    // InternalPerl.g:2719:1: rule__PackageStatement__Group__1__Impl : ( 'package' ) ;
    public final void rule__PackageStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2723:1: ( ( 'package' ) )
            // InternalPerl.g:2724:1: ( 'package' )
            {
            // InternalPerl.g:2724:1: ( 'package' )
            // InternalPerl.g:2725:2: 'package'
            {
             before(grammarAccess.getPackageStatementAccess().getPackageKeyword_1()); 
            match(input,145,FOLLOW_2); 
             after(grammarAccess.getPackageStatementAccess().getPackageKeyword_1()); 

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
    // InternalPerl.g:2734:1: rule__PackageStatement__Group__2 : rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3 ;
    public final void rule__PackageStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2738:1: ( rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3 )
            // InternalPerl.g:2739:2: rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__PackageStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageStatement__Group__3();

            state._fsp--;


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
    // InternalPerl.g:2746:1: rule__PackageStatement__Group__2__Impl : ( ( rule__PackageStatement__NameAssignment_2 ) ) ;
    public final void rule__PackageStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2750:1: ( ( ( rule__PackageStatement__NameAssignment_2 ) ) )
            // InternalPerl.g:2751:1: ( ( rule__PackageStatement__NameAssignment_2 ) )
            {
            // InternalPerl.g:2751:1: ( ( rule__PackageStatement__NameAssignment_2 ) )
            // InternalPerl.g:2752:2: ( rule__PackageStatement__NameAssignment_2 )
            {
             before(grammarAccess.getPackageStatementAccess().getNameAssignment_2()); 
            // InternalPerl.g:2753:2: ( rule__PackageStatement__NameAssignment_2 )
            // InternalPerl.g:2753:3: rule__PackageStatement__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PackageStatement__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPackageStatementAccess().getNameAssignment_2()); 

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


    // $ANTLR start "rule__PackageStatement__Group__3"
    // InternalPerl.g:2761:1: rule__PackageStatement__Group__3 : rule__PackageStatement__Group__3__Impl ;
    public final void rule__PackageStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2765:1: ( rule__PackageStatement__Group__3__Impl )
            // InternalPerl.g:2766:2: rule__PackageStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PackageStatement__Group__3__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__PackageStatement__Group__3"


    // $ANTLR start "rule__PackageStatement__Group__3__Impl"
    // InternalPerl.g:2772:1: rule__PackageStatement__Group__3__Impl : ( ( rule__PackageStatement__VersionAssignment_3 )? ) ;
    public final void rule__PackageStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2776:1: ( ( ( rule__PackageStatement__VersionAssignment_3 )? ) )
            // InternalPerl.g:2777:1: ( ( rule__PackageStatement__VersionAssignment_3 )? )
            {
            // InternalPerl.g:2777:1: ( ( rule__PackageStatement__VersionAssignment_3 )? )
            // InternalPerl.g:2778:2: ( rule__PackageStatement__VersionAssignment_3 )?
            {
             before(grammarAccess.getPackageStatementAccess().getVersionAssignment_3()); 
            // InternalPerl.g:2779:2: ( rule__PackageStatement__VersionAssignment_3 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_VERSION) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalPerl.g:2779:3: rule__PackageStatement__VersionAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__PackageStatement__VersionAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPackageStatementAccess().getVersionAssignment_3()); 

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
    // $ANTLR end "rule__PackageStatement__Group__3__Impl"


    // $ANTLR start "rule__RequireInclude__Group__0"
    // InternalPerl.g:2788:1: rule__RequireInclude__Group__0 : rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1 ;
    public final void rule__RequireInclude__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2792:1: ( rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1 )
            // InternalPerl.g:2793:2: rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__RequireInclude__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RequireInclude__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__RequireInclude__Group__0"


    // $ANTLR start "rule__RequireInclude__Group__0__Impl"
    // InternalPerl.g:2800:1: rule__RequireInclude__Group__0__Impl : ( 'require' ) ;
    public final void rule__RequireInclude__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2804:1: ( ( 'require' ) )
            // InternalPerl.g:2805:1: ( 'require' )
            {
            // InternalPerl.g:2805:1: ( 'require' )
            // InternalPerl.g:2806:2: 'require'
            {
             before(grammarAccess.getRequireIncludeAccess().getRequireKeyword_0()); 
            match(input,164,FOLLOW_2); 
             after(grammarAccess.getRequireIncludeAccess().getRequireKeyword_0()); 

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
    // $ANTLR end "rule__RequireInclude__Group__0__Impl"


    // $ANTLR start "rule__RequireInclude__Group__1"
    // InternalPerl.g:2815:1: rule__RequireInclude__Group__1 : rule__RequireInclude__Group__1__Impl ;
    public final void rule__RequireInclude__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2819:1: ( rule__RequireInclude__Group__1__Impl )
            // InternalPerl.g:2820:2: rule__RequireInclude__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RequireInclude__Group__1__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__RequireInclude__Group__1"


    // $ANTLR start "rule__RequireInclude__Group__1__Impl"
    // InternalPerl.g:2826:1: rule__RequireInclude__Group__1__Impl : ( ( rule__RequireInclude__VersionAssignment_1 ) ) ;
    public final void rule__RequireInclude__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2830:1: ( ( ( rule__RequireInclude__VersionAssignment_1 ) ) )
            // InternalPerl.g:2831:1: ( ( rule__RequireInclude__VersionAssignment_1 ) )
            {
            // InternalPerl.g:2831:1: ( ( rule__RequireInclude__VersionAssignment_1 ) )
            // InternalPerl.g:2832:2: ( rule__RequireInclude__VersionAssignment_1 )
            {
             before(grammarAccess.getRequireIncludeAccess().getVersionAssignment_1()); 
            // InternalPerl.g:2833:2: ( rule__RequireInclude__VersionAssignment_1 )
            // InternalPerl.g:2833:3: rule__RequireInclude__VersionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RequireInclude__VersionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRequireIncludeAccess().getVersionAssignment_1()); 

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
    // $ANTLR end "rule__RequireInclude__Group__1__Impl"


    // $ANTLR start "rule__UseInclude__Group__0"
    // InternalPerl.g:2842:1: rule__UseInclude__Group__0 : rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1 ;
    public final void rule__UseInclude__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2846:1: ( rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1 )
            // InternalPerl.g:2847:2: rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__UseInclude__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UseInclude__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__UseInclude__Group__0"


    // $ANTLR start "rule__UseInclude__Group__0__Impl"
    // InternalPerl.g:2854:1: rule__UseInclude__Group__0__Impl : ( () ) ;
    public final void rule__UseInclude__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2858:1: ( ( () ) )
            // InternalPerl.g:2859:1: ( () )
            {
            // InternalPerl.g:2859:1: ( () )
            // InternalPerl.g:2860:2: ()
            {
             before(grammarAccess.getUseIncludeAccess().getUseIncludeAction_0()); 
            // InternalPerl.g:2861:2: ()
            // InternalPerl.g:2861:3: 
            {
            }

             after(grammarAccess.getUseIncludeAccess().getUseIncludeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UseInclude__Group__0__Impl"


    // $ANTLR start "rule__UseInclude__Group__1"
    // InternalPerl.g:2869:1: rule__UseInclude__Group__1 : rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2 ;
    public final void rule__UseInclude__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2873:1: ( rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2 )
            // InternalPerl.g:2874:2: rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__UseInclude__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UseInclude__Group__2();

            state._fsp--;


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
    // $ANTLR end "rule__UseInclude__Group__1"


    // $ANTLR start "rule__UseInclude__Group__1__Impl"
    // InternalPerl.g:2881:1: rule__UseInclude__Group__1__Impl : ( 'use' ) ;
    public final void rule__UseInclude__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2885:1: ( ( 'use' ) )
            // InternalPerl.g:2886:1: ( 'use' )
            {
            // InternalPerl.g:2886:1: ( 'use' )
            // InternalPerl.g:2887:2: 'use'
            {
             before(grammarAccess.getUseIncludeAccess().getUseKeyword_1()); 
            match(input,235,FOLLOW_2); 
             after(grammarAccess.getUseIncludeAccess().getUseKeyword_1()); 

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
    // $ANTLR end "rule__UseInclude__Group__1__Impl"


    // $ANTLR start "rule__UseInclude__Group__2"
    // InternalPerl.g:2896:1: rule__UseInclude__Group__2 : rule__UseInclude__Group__2__Impl ;
    public final void rule__UseInclude__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2900:1: ( rule__UseInclude__Group__2__Impl )
            // InternalPerl.g:2901:2: rule__UseInclude__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UseInclude__Group__2__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__UseInclude__Group__2"


    // $ANTLR start "rule__UseInclude__Group__2__Impl"
    // InternalPerl.g:2907:1: rule__UseInclude__Group__2__Impl : ( ( rule__UseInclude__Alternatives_2 ) ) ;
    public final void rule__UseInclude__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2911:1: ( ( ( rule__UseInclude__Alternatives_2 ) ) )
            // InternalPerl.g:2912:1: ( ( rule__UseInclude__Alternatives_2 ) )
            {
            // InternalPerl.g:2912:1: ( ( rule__UseInclude__Alternatives_2 ) )
            // InternalPerl.g:2913:2: ( rule__UseInclude__Alternatives_2 )
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2()); 
            // InternalPerl.g:2914:2: ( rule__UseInclude__Alternatives_2 )
            // InternalPerl.g:2914:3: rule__UseInclude__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__UseInclude__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getUseIncludeAccess().getAlternatives_2()); 

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
    // $ANTLR end "rule__UseInclude__Group__2__Impl"


    // $ANTLR start "rule__UseInclude__Group_2_1__0"
    // InternalPerl.g:2923:1: rule__UseInclude__Group_2_1__0 : rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1 ;
    public final void rule__UseInclude__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2927:1: ( rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1 )
            // InternalPerl.g:2928:2: rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1
            {
            pushFollow(FOLLOW_11);
            rule__UseInclude__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UseInclude__Group_2_1__1();

            state._fsp--;


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
    // $ANTLR end "rule__UseInclude__Group_2_1__0"


    // $ANTLR start "rule__UseInclude__Group_2_1__0__Impl"
    // InternalPerl.g:2935:1: rule__UseInclude__Group_2_1__0__Impl : ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) ) ;
    public final void rule__UseInclude__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2939:1: ( ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) ) )
            // InternalPerl.g:2940:1: ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) )
            {
            // InternalPerl.g:2940:1: ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) )
            // InternalPerl.g:2941:2: ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 )
            {
             before(grammarAccess.getUseIncludeAccess().getPragmaOrPackageAssignment_2_1_0()); 
            // InternalPerl.g:2942:2: ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 )
            // InternalPerl.g:2942:3: rule__UseInclude__PragmaOrPackageAssignment_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__UseInclude__PragmaOrPackageAssignment_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getUseIncludeAccess().getPragmaOrPackageAssignment_2_1_0()); 

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
    // $ANTLR end "rule__UseInclude__Group_2_1__0__Impl"


    // $ANTLR start "rule__UseInclude__Group_2_1__1"
    // InternalPerl.g:2950:1: rule__UseInclude__Group_2_1__1 : rule__UseInclude__Group_2_1__1__Impl ;
    public final void rule__UseInclude__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2954:1: ( rule__UseInclude__Group_2_1__1__Impl )
            // InternalPerl.g:2955:2: rule__UseInclude__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UseInclude__Group_2_1__1__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__UseInclude__Group_2_1__1"


    // $ANTLR start "rule__UseInclude__Group_2_1__1__Impl"
    // InternalPerl.g:2961:1: rule__UseInclude__Group_2_1__1__Impl : ( ( rule__UseInclude__Alternatives_2_1_1 )? ) ;
    public final void rule__UseInclude__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2965:1: ( ( ( rule__UseInclude__Alternatives_2_1_1 )? ) )
            // InternalPerl.g:2966:1: ( ( rule__UseInclude__Alternatives_2_1_1 )? )
            {
            // InternalPerl.g:2966:1: ( ( rule__UseInclude__Alternatives_2_1_1 )? )
            // InternalPerl.g:2967:2: ( rule__UseInclude__Alternatives_2_1_1 )?
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2_1_1()); 
            // InternalPerl.g:2968:2: ( rule__UseInclude__Alternatives_2_1_1 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_LITERAL)||LA14_0==RULE_WORDS_QUOTE_LIKE) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalPerl.g:2968:3: rule__UseInclude__Alternatives_2_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__UseInclude__Alternatives_2_1_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getUseIncludeAccess().getAlternatives_2_1_1()); 

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
    // $ANTLR end "rule__UseInclude__Group_2_1__1__Impl"


    // $ANTLR start "rule__Token__Group_0__0"
    // InternalPerl.g:2977:1: rule__Token__Group_0__0 : rule__Token__Group_0__0__Impl rule__Token__Group_0__1 ;
    public final void rule__Token__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2981:1: ( rule__Token__Group_0__0__Impl rule__Token__Group_0__1 )
            // InternalPerl.g:2982:2: rule__Token__Group_0__0__Impl rule__Token__Group_0__1
            {
            pushFollow(FOLLOW_12);
            rule__Token__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_0__1();

            state._fsp--;


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
    // InternalPerl.g:2989:1: rule__Token__Group_0__0__Impl : ( () ) ;
    public final void rule__Token__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2993:1: ( ( () ) )
            // InternalPerl.g:2994:1: ( () )
            {
            // InternalPerl.g:2994:1: ( () )
            // InternalPerl.g:2995:2: ()
            {
             before(grammarAccess.getTokenAccess().getPodTokenAction_0_0()); 
            // InternalPerl.g:2996:2: ()
            // InternalPerl.g:2996:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getPodTokenAction_0_0()); 

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
    // InternalPerl.g:3004:1: rule__Token__Group_0__1 : rule__Token__Group_0__1__Impl ;
    public final void rule__Token__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3008:1: ( rule__Token__Group_0__1__Impl )
            // InternalPerl.g:3009:2: rule__Token__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_0__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3015:1: rule__Token__Group_0__1__Impl : ( ( rule__Token__ContentAssignment_0_1 ) ) ;
    public final void rule__Token__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3019:1: ( ( ( rule__Token__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:3020:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:3020:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            // InternalPerl.g:3021:2: ( rule__Token__ContentAssignment_0_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:3022:2: ( rule__Token__ContentAssignment_0_1 )
            // InternalPerl.g:3022:3: rule__Token__ContentAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_0_1()); 

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
    // InternalPerl.g:3031:1: rule__Token__Group_1__0 : rule__Token__Group_1__0__Impl rule__Token__Group_1__1 ;
    public final void rule__Token__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3035:1: ( rule__Token__Group_1__0__Impl rule__Token__Group_1__1 )
            // InternalPerl.g:3036:2: rule__Token__Group_1__0__Impl rule__Token__Group_1__1
            {
            pushFollow(FOLLOW_13);
            rule__Token__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_1__1();

            state._fsp--;


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
    // InternalPerl.g:3043:1: rule__Token__Group_1__0__Impl : ( () ) ;
    public final void rule__Token__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3047:1: ( ( () ) )
            // InternalPerl.g:3048:1: ( () )
            {
            // InternalPerl.g:3048:1: ( () )
            // InternalPerl.g:3049:2: ()
            {
             before(grammarAccess.getTokenAccess().getNumberTokenAction_1_0()); 
            // InternalPerl.g:3050:2: ()
            // InternalPerl.g:3050:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getNumberTokenAction_1_0()); 

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
    // InternalPerl.g:3058:1: rule__Token__Group_1__1 : rule__Token__Group_1__1__Impl ;
    public final void rule__Token__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3062:1: ( rule__Token__Group_1__1__Impl )
            // InternalPerl.g:3063:2: rule__Token__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_1__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3069:1: rule__Token__Group_1__1__Impl : ( ( rule__Token__ContentAssignment_1_1 ) ) ;
    public final void rule__Token__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3073:1: ( ( ( rule__Token__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:3074:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:3074:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            // InternalPerl.g:3075:2: ( rule__Token__ContentAssignment_1_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:3076:2: ( rule__Token__ContentAssignment_1_1 )
            // InternalPerl.g:3076:3: rule__Token__ContentAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_1_1()); 

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
    // InternalPerl.g:3085:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3089:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // InternalPerl.g:3090:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
            {
            pushFollow(FOLLOW_14);
            rule__Token__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_2__1();

            state._fsp--;


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
    // InternalPerl.g:3097:1: rule__Token__Group_2__0__Impl : ( () ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3101:1: ( ( () ) )
            // InternalPerl.g:3102:1: ( () )
            {
            // InternalPerl.g:3102:1: ( () )
            // InternalPerl.g:3103:2: ()
            {
             before(grammarAccess.getTokenAccess().getWordTokenAction_2_0()); 
            // InternalPerl.g:3104:2: ()
            // InternalPerl.g:3104:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getWordTokenAction_2_0()); 

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
    // InternalPerl.g:3112:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3116:1: ( rule__Token__Group_2__1__Impl )
            // InternalPerl.g:3117:2: rule__Token__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_2__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3123:1: rule__Token__Group_2__1__Impl : ( ( rule__Token__ContentAssignment_2_1 ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3127:1: ( ( ( rule__Token__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:3128:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:3128:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            // InternalPerl.g:3129:2: ( rule__Token__ContentAssignment_2_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:3130:2: ( rule__Token__ContentAssignment_2_1 )
            // InternalPerl.g:3130:3: rule__Token__ContentAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_2_1()); 

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
    // InternalPerl.g:3139:1: rule__Token__Group_3__0 : rule__Token__Group_3__0__Impl rule__Token__Group_3__1 ;
    public final void rule__Token__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3143:1: ( rule__Token__Group_3__0__Impl rule__Token__Group_3__1 )
            // InternalPerl.g:3144:2: rule__Token__Group_3__0__Impl rule__Token__Group_3__1
            {
            pushFollow(FOLLOW_15);
            rule__Token__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_3__1();

            state._fsp--;


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
    // InternalPerl.g:3151:1: rule__Token__Group_3__0__Impl : ( () ) ;
    public final void rule__Token__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3155:1: ( ( () ) )
            // InternalPerl.g:3156:1: ( () )
            {
            // InternalPerl.g:3156:1: ( () )
            // InternalPerl.g:3157:2: ()
            {
             before(grammarAccess.getTokenAccess().getSymbolTokenAction_3_0()); 
            // InternalPerl.g:3158:2: ()
            // InternalPerl.g:3158:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getSymbolTokenAction_3_0()); 

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
    // InternalPerl.g:3166:1: rule__Token__Group_3__1 : rule__Token__Group_3__1__Impl ;
    public final void rule__Token__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3170:1: ( rule__Token__Group_3__1__Impl )
            // InternalPerl.g:3171:2: rule__Token__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_3__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3177:1: rule__Token__Group_3__1__Impl : ( ( rule__Token__ContentAssignment_3_1 ) ) ;
    public final void rule__Token__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3181:1: ( ( ( rule__Token__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:3182:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:3182:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            // InternalPerl.g:3183:2: ( rule__Token__ContentAssignment_3_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:3184:2: ( rule__Token__ContentAssignment_3_1 )
            // InternalPerl.g:3184:3: rule__Token__ContentAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_3_1()); 

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


    // $ANTLR start "rule__Token__Group_5__0"
    // InternalPerl.g:3193:1: rule__Token__Group_5__0 : rule__Token__Group_5__0__Impl rule__Token__Group_5__1 ;
    public final void rule__Token__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3197:1: ( rule__Token__Group_5__0__Impl rule__Token__Group_5__1 )
            // InternalPerl.g:3198:2: rule__Token__Group_5__0__Impl rule__Token__Group_5__1
            {
            pushFollow(FOLLOW_16);
            rule__Token__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_5__1();

            state._fsp--;


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
    // $ANTLR end "rule__Token__Group_5__0"


    // $ANTLR start "rule__Token__Group_5__0__Impl"
    // InternalPerl.g:3205:1: rule__Token__Group_5__0__Impl : ( () ) ;
    public final void rule__Token__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3209:1: ( ( () ) )
            // InternalPerl.g:3210:1: ( () )
            {
            // InternalPerl.g:3210:1: ( () )
            // InternalPerl.g:3211:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_5_0()); 
            // InternalPerl.g:3212:2: ()
            // InternalPerl.g:3212:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getOperatorTokenAction_5_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_5__0__Impl"


    // $ANTLR start "rule__Token__Group_5__1"
    // InternalPerl.g:3220:1: rule__Token__Group_5__1 : rule__Token__Group_5__1__Impl ;
    public final void rule__Token__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3224:1: ( rule__Token__Group_5__1__Impl )
            // InternalPerl.g:3225:2: rule__Token__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_5__1__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__Token__Group_5__1"


    // $ANTLR start "rule__Token__Group_5__1__Impl"
    // InternalPerl.g:3231:1: rule__Token__Group_5__1__Impl : ( ( rule__Token__ContentAssignment_5_1 ) ) ;
    public final void rule__Token__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3235:1: ( ( ( rule__Token__ContentAssignment_5_1 ) ) )
            // InternalPerl.g:3236:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            {
            // InternalPerl.g:3236:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            // InternalPerl.g:3237:2: ( rule__Token__ContentAssignment_5_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_5_1()); 
            // InternalPerl.g:3238:2: ( rule__Token__ContentAssignment_5_1 )
            // InternalPerl.g:3238:3: rule__Token__ContentAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_5_1()); 

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
    // $ANTLR end "rule__Token__Group_5__1__Impl"


    // $ANTLR start "rule__Token__Group_6__0"
    // InternalPerl.g:3247:1: rule__Token__Group_6__0 : rule__Token__Group_6__0__Impl rule__Token__Group_6__1 ;
    public final void rule__Token__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3251:1: ( rule__Token__Group_6__0__Impl rule__Token__Group_6__1 )
            // InternalPerl.g:3252:2: rule__Token__Group_6__0__Impl rule__Token__Group_6__1
            {
            pushFollow(FOLLOW_17);
            rule__Token__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_6__1();

            state._fsp--;


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
    // InternalPerl.g:3259:1: rule__Token__Group_6__0__Impl : ( () ) ;
    public final void rule__Token__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3263:1: ( ( () ) )
            // InternalPerl.g:3264:1: ( () )
            {
            // InternalPerl.g:3264:1: ( () )
            // InternalPerl.g:3265:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_6_0()); 
            // InternalPerl.g:3266:2: ()
            // InternalPerl.g:3266:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getOperatorTokenAction_6_0()); 

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
    // InternalPerl.g:3274:1: rule__Token__Group_6__1 : rule__Token__Group_6__1__Impl ;
    public final void rule__Token__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3278:1: ( rule__Token__Group_6__1__Impl )
            // InternalPerl.g:3279:2: rule__Token__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_6__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3285:1: rule__Token__Group_6__1__Impl : ( ( rule__Token__ContentAssignment_6_1 ) ) ;
    public final void rule__Token__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3289:1: ( ( ( rule__Token__ContentAssignment_6_1 ) ) )
            // InternalPerl.g:3290:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            {
            // InternalPerl.g:3290:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            // InternalPerl.g:3291:2: ( rule__Token__ContentAssignment_6_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_6_1()); 
            // InternalPerl.g:3292:2: ( rule__Token__ContentAssignment_6_1 )
            // InternalPerl.g:3292:3: rule__Token__ContentAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_6_1()); 

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


    // $ANTLR start "rule__Token__Group_8__0"
    // InternalPerl.g:3301:1: rule__Token__Group_8__0 : rule__Token__Group_8__0__Impl rule__Token__Group_8__1 ;
    public final void rule__Token__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3305:1: ( rule__Token__Group_8__0__Impl rule__Token__Group_8__1 )
            // InternalPerl.g:3306:2: rule__Token__Group_8__0__Impl rule__Token__Group_8__1
            {
            pushFollow(FOLLOW_18);
            rule__Token__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_8__1();

            state._fsp--;


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
    // $ANTLR end "rule__Token__Group_8__0"


    // $ANTLR start "rule__Token__Group_8__0__Impl"
    // InternalPerl.g:3313:1: rule__Token__Group_8__0__Impl : ( () ) ;
    public final void rule__Token__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3317:1: ( ( () ) )
            // InternalPerl.g:3318:1: ( () )
            {
            // InternalPerl.g:3318:1: ( () )
            // InternalPerl.g:3319:2: ()
            {
             before(grammarAccess.getTokenAccess().getDataTokenAction_8_0()); 
            // InternalPerl.g:3320:2: ()
            // InternalPerl.g:3320:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getDataTokenAction_8_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Token__Group_8__0__Impl"


    // $ANTLR start "rule__Token__Group_8__1"
    // InternalPerl.g:3328:1: rule__Token__Group_8__1 : rule__Token__Group_8__1__Impl ;
    public final void rule__Token__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3332:1: ( rule__Token__Group_8__1__Impl )
            // InternalPerl.g:3333:2: rule__Token__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_8__1__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__Token__Group_8__1"


    // $ANTLR start "rule__Token__Group_8__1__Impl"
    // InternalPerl.g:3339:1: rule__Token__Group_8__1__Impl : ( ( rule__Token__ContentAssignment_8_1 ) ) ;
    public final void rule__Token__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3343:1: ( ( ( rule__Token__ContentAssignment_8_1 ) ) )
            // InternalPerl.g:3344:1: ( ( rule__Token__ContentAssignment_8_1 ) )
            {
            // InternalPerl.g:3344:1: ( ( rule__Token__ContentAssignment_8_1 ) )
            // InternalPerl.g:3345:2: ( rule__Token__ContentAssignment_8_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_8_1()); 
            // InternalPerl.g:3346:2: ( rule__Token__ContentAssignment_8_1 )
            // InternalPerl.g:3346:3: rule__Token__ContentAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_8_1()); 

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
    // $ANTLR end "rule__Token__Group_8__1__Impl"


    // $ANTLR start "rule__Token__Group_9__0"
    // InternalPerl.g:3355:1: rule__Token__Group_9__0 : rule__Token__Group_9__0__Impl rule__Token__Group_9__1 ;
    public final void rule__Token__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3359:1: ( rule__Token__Group_9__0__Impl rule__Token__Group_9__1 )
            // InternalPerl.g:3360:2: rule__Token__Group_9__0__Impl rule__Token__Group_9__1
            {
            pushFollow(FOLLOW_3);
            rule__Token__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_9__1();

            state._fsp--;


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
    // InternalPerl.g:3367:1: rule__Token__Group_9__0__Impl : ( () ) ;
    public final void rule__Token__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3371:1: ( ( () ) )
            // InternalPerl.g:3372:1: ( () )
            {
            // InternalPerl.g:3372:1: ( () )
            // InternalPerl.g:3373:2: ()
            {
             before(grammarAccess.getTokenAccess().getEndTokenAction_9_0()); 
            // InternalPerl.g:3374:2: ()
            // InternalPerl.g:3374:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getEndTokenAction_9_0()); 

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
    // InternalPerl.g:3382:1: rule__Token__Group_9__1 : rule__Token__Group_9__1__Impl ;
    public final void rule__Token__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3386:1: ( rule__Token__Group_9__1__Impl )
            // InternalPerl.g:3387:2: rule__Token__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_9__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3393:1: rule__Token__Group_9__1__Impl : ( ( rule__Token__ContentAssignment_9_1 ) ) ;
    public final void rule__Token__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3397:1: ( ( ( rule__Token__ContentAssignment_9_1 ) ) )
            // InternalPerl.g:3398:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            {
            // InternalPerl.g:3398:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            // InternalPerl.g:3399:2: ( rule__Token__ContentAssignment_9_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_9_1()); 
            // InternalPerl.g:3400:2: ( rule__Token__ContentAssignment_9_1 )
            // InternalPerl.g:3400:3: rule__Token__ContentAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_9_1()); 

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


    // $ANTLR start "rule__QuoteToken__Group__0"
    // InternalPerl.g:3409:1: rule__QuoteToken__Group__0 : rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 ;
    public final void rule__QuoteToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3413:1: ( rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 )
            // InternalPerl.g:3414:2: rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__QuoteToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuoteToken__Group__1();

            state._fsp--;


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
    // InternalPerl.g:3421:1: rule__QuoteToken__Group__0__Impl : ( () ) ;
    public final void rule__QuoteToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3425:1: ( ( () ) )
            // InternalPerl.g:3426:1: ( () )
            {
            // InternalPerl.g:3426:1: ( () )
            // InternalPerl.g:3427:2: ()
            {
             before(grammarAccess.getQuoteTokenAccess().getQuoteTokenAction_0()); 
            // InternalPerl.g:3428:2: ()
            // InternalPerl.g:3428:3: 
            {
            }

             after(grammarAccess.getQuoteTokenAccess().getQuoteTokenAction_0()); 

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
    // InternalPerl.g:3436:1: rule__QuoteToken__Group__1 : rule__QuoteToken__Group__1__Impl ;
    public final void rule__QuoteToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3440:1: ( rule__QuoteToken__Group__1__Impl )
            // InternalPerl.g:3441:2: rule__QuoteToken__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteToken__Group__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3447:1: rule__QuoteToken__Group__1__Impl : ( ( rule__QuoteToken__ContentAssignment_1 ) ) ;
    public final void rule__QuoteToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3451:1: ( ( ( rule__QuoteToken__ContentAssignment_1 ) ) )
            // InternalPerl.g:3452:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            {
            // InternalPerl.g:3452:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            // InternalPerl.g:3453:2: ( rule__QuoteToken__ContentAssignment_1 )
            {
             before(grammarAccess.getQuoteTokenAccess().getContentAssignment_1()); 
            // InternalPerl.g:3454:2: ( rule__QuoteToken__ContentAssignment_1 )
            // InternalPerl.g:3454:3: rule__QuoteToken__ContentAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteToken__ContentAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQuoteTokenAccess().getContentAssignment_1()); 

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
    // InternalPerl.g:3463:1: rule__QuoteLikeToken__Group_0__0 : rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 ;
    public final void rule__QuoteLikeToken__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3467:1: ( rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 )
            // InternalPerl.g:3468:2: rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1
            {
            pushFollow(FOLLOW_20);
            rule__QuoteLikeToken__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_0__1();

            state._fsp--;


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
    // InternalPerl.g:3475:1: rule__QuoteLikeToken__Group_0__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3479:1: ( ( () ) )
            // InternalPerl.g:3480:1: ( () )
            {
            // InternalPerl.g:3480:1: ( () )
            // InternalPerl.g:3481:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0()); 
            // InternalPerl.g:3482:2: ()
            // InternalPerl.g:3482:3: 
            {
            }

             after(grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0()); 

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
    // InternalPerl.g:3490:1: rule__QuoteLikeToken__Group_0__1 : rule__QuoteLikeToken__Group_0__1__Impl ;
    public final void rule__QuoteLikeToken__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3494:1: ( rule__QuoteLikeToken__Group_0__1__Impl )
            // InternalPerl.g:3495:2: rule__QuoteLikeToken__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_0__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3501:1: rule__QuoteLikeToken__Group_0__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3505:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:3506:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:3506:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            // InternalPerl.g:3507:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:3508:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            // InternalPerl.g:3508:3: rule__QuoteLikeToken__ContentAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__ContentAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_0_1()); 

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
    // InternalPerl.g:3517:1: rule__QuoteLikeToken__Group_1__0 : rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 ;
    public final void rule__QuoteLikeToken__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3521:1: ( rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 )
            // InternalPerl.g:3522:2: rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1
            {
            pushFollow(FOLLOW_21);
            rule__QuoteLikeToken__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_1__1();

            state._fsp--;


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
    // InternalPerl.g:3529:1: rule__QuoteLikeToken__Group_1__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3533:1: ( ( () ) )
            // InternalPerl.g:3534:1: ( () )
            {
            // InternalPerl.g:3534:1: ( () )
            // InternalPerl.g:3535:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0()); 
            // InternalPerl.g:3536:2: ()
            // InternalPerl.g:3536:3: 
            {
            }

             after(grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0()); 

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
    // InternalPerl.g:3544:1: rule__QuoteLikeToken__Group_1__1 : rule__QuoteLikeToken__Group_1__1__Impl ;
    public final void rule__QuoteLikeToken__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3548:1: ( rule__QuoteLikeToken__Group_1__1__Impl )
            // InternalPerl.g:3549:2: rule__QuoteLikeToken__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_1__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3555:1: rule__QuoteLikeToken__Group_1__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3559:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:3560:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:3560:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            // InternalPerl.g:3561:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:3562:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            // InternalPerl.g:3562:3: rule__QuoteLikeToken__ContentAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__ContentAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_1_1()); 

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
    // InternalPerl.g:3571:1: rule__QuoteLikeToken__Group_2__0 : rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 ;
    public final void rule__QuoteLikeToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3575:1: ( rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 )
            // InternalPerl.g:3576:2: rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1
            {
            pushFollow(FOLLOW_22);
            rule__QuoteLikeToken__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_2__1();

            state._fsp--;


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
    // InternalPerl.g:3583:1: rule__QuoteLikeToken__Group_2__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3587:1: ( ( () ) )
            // InternalPerl.g:3588:1: ( () )
            {
            // InternalPerl.g:3588:1: ( () )
            // InternalPerl.g:3589:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0()); 
            // InternalPerl.g:3590:2: ()
            // InternalPerl.g:3590:3: 
            {
            }

             after(grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0()); 

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
    // InternalPerl.g:3598:1: rule__QuoteLikeToken__Group_2__1 : rule__QuoteLikeToken__Group_2__1__Impl ;
    public final void rule__QuoteLikeToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3602:1: ( rule__QuoteLikeToken__Group_2__1__Impl )
            // InternalPerl.g:3603:2: rule__QuoteLikeToken__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_2__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3609:1: rule__QuoteLikeToken__Group_2__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3613:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:3614:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:3614:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            // InternalPerl.g:3615:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:3616:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            // InternalPerl.g:3616:3: rule__QuoteLikeToken__ContentAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__ContentAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_2_1()); 

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
    // InternalPerl.g:3625:1: rule__QuoteLikeToken__Group_3__0 : rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 ;
    public final void rule__QuoteLikeToken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3629:1: ( rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 )
            // InternalPerl.g:3630:2: rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1
            {
            pushFollow(FOLLOW_23);
            rule__QuoteLikeToken__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_3__1();

            state._fsp--;


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
    // InternalPerl.g:3637:1: rule__QuoteLikeToken__Group_3__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3641:1: ( ( () ) )
            // InternalPerl.g:3642:1: ( () )
            {
            // InternalPerl.g:3642:1: ( () )
            // InternalPerl.g:3643:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0()); 
            // InternalPerl.g:3644:2: ()
            // InternalPerl.g:3644:3: 
            {
            }

             after(grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0()); 

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
    // InternalPerl.g:3652:1: rule__QuoteLikeToken__Group_3__1 : rule__QuoteLikeToken__Group_3__1__Impl ;
    public final void rule__QuoteLikeToken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3656:1: ( rule__QuoteLikeToken__Group_3__1__Impl )
            // InternalPerl.g:3657:2: rule__QuoteLikeToken__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_3__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3663:1: rule__QuoteLikeToken__Group_3__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3667:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:3668:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:3668:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            // InternalPerl.g:3669:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:3670:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            // InternalPerl.g:3670:3: rule__QuoteLikeToken__ContentAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__ContentAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_3_1()); 

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
    // InternalPerl.g:3679:1: rule__QuoteLikeToken__Group_4__0 : rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 ;
    public final void rule__QuoteLikeToken__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3683:1: ( rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 )
            // InternalPerl.g:3684:2: rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1
            {
            pushFollow(FOLLOW_24);
            rule__QuoteLikeToken__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_4__1();

            state._fsp--;


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
    // InternalPerl.g:3691:1: rule__QuoteLikeToken__Group_4__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3695:1: ( ( () ) )
            // InternalPerl.g:3696:1: ( () )
            {
            // InternalPerl.g:3696:1: ( () )
            // InternalPerl.g:3697:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0()); 
            // InternalPerl.g:3698:2: ()
            // InternalPerl.g:3698:3: 
            {
            }

             after(grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0()); 

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
    // InternalPerl.g:3706:1: rule__QuoteLikeToken__Group_4__1 : rule__QuoteLikeToken__Group_4__1__Impl ;
    public final void rule__QuoteLikeToken__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3710:1: ( rule__QuoteLikeToken__Group_4__1__Impl )
            // InternalPerl.g:3711:2: rule__QuoteLikeToken__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__Group_4__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3717:1: rule__QuoteLikeToken__Group_4__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3721:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) )
            // InternalPerl.g:3722:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            {
            // InternalPerl.g:3722:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            // InternalPerl.g:3723:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_4_1()); 
            // InternalPerl.g:3724:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            // InternalPerl.g:3724:3: rule__QuoteLikeToken__ContentAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__QuoteLikeToken__ContentAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_4_1()); 

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
    // InternalPerl.g:3733:1: rule__Operator__Group_23__0 : rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 ;
    public final void rule__Operator__Group_23__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3737:1: ( rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 )
            // InternalPerl.g:3738:2: rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1
            {
            pushFollow(FOLLOW_25);
            rule__Operator__Group_23__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operator__Group_23__1();

            state._fsp--;


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
    // InternalPerl.g:3745:1: rule__Operator__Group_23__0__Impl : ( '<=>' ) ;
    public final void rule__Operator__Group_23__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3749:1: ( ( '<=>' ) )
            // InternalPerl.g:3750:1: ( '<=>' )
            {
            // InternalPerl.g:3750:1: ( '<=>' )
            // InternalPerl.g:3751:2: '<=>'
            {
             before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_23_0()); 
            match(input,338,FOLLOW_2); 
             after(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_23_0()); 

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
    // InternalPerl.g:3760:1: rule__Operator__Group_23__1 : rule__Operator__Group_23__1__Impl ;
    public final void rule__Operator__Group_23__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3764:1: ( rule__Operator__Group_23__1__Impl )
            // InternalPerl.g:3765:2: rule__Operator__Group_23__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Operator__Group_23__1__Impl();

            state._fsp--;


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
    // InternalPerl.g:3771:1: rule__Operator__Group_23__1__Impl : ( '.' ) ;
    public final void rule__Operator__Group_23__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3775:1: ( ( '.' ) )
            // InternalPerl.g:3776:1: ( '.' )
            {
            // InternalPerl.g:3776:1: ( '.' )
            // InternalPerl.g:3777:2: '.'
            {
             before(grammarAccess.getOperatorAccess().getFullStopKeyword_23_1()); 
            match(input,339,FOLLOW_2); 
             after(grammarAccess.getOperatorAccess().getFullStopKeyword_23_1()); 

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


    // $ANTLR start "rule__PerlDocument__ElementsAssignment_1"
    // InternalPerl.g:3787:1: rule__PerlDocument__ElementsAssignment_1 : ( ruleElement ) ;
    public final void rule__PerlDocument__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3791:1: ( ( ruleElement ) )
            // InternalPerl.g:3792:2: ( ruleElement )
            {
            // InternalPerl.g:3792:2: ( ruleElement )
            // InternalPerl.g:3793:3: ruleElement
            {
             before(grammarAccess.getPerlDocumentAccess().getElementsElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getPerlDocumentAccess().getElementsElementParserRuleCall_1_0()); 

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


    // $ANTLR start "rule__PackageStatement__NameAssignment_2"
    // InternalPerl.g:3802:1: rule__PackageStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3806:1: ( ( RULE_ID ) )
            // InternalPerl.g:3807:2: ( RULE_ID )
            {
            // InternalPerl.g:3807:2: ( RULE_ID )
            // InternalPerl.g:3808:3: RULE_ID
            {
             before(grammarAccess.getPackageStatementAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPackageStatementAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__PackageStatement__NameAssignment_2"


    // $ANTLR start "rule__PackageStatement__VersionAssignment_3"
    // InternalPerl.g:3817:1: rule__PackageStatement__VersionAssignment_3 : ( RULE_VERSION ) ;
    public final void rule__PackageStatement__VersionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3821:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:3822:2: ( RULE_VERSION )
            {
            // InternalPerl.g:3822:2: ( RULE_VERSION )
            // InternalPerl.g:3823:3: RULE_VERSION
            {
             before(grammarAccess.getPackageStatementAccess().getVersionVERSIONTerminalRuleCall_3_0()); 
            match(input,RULE_VERSION,FOLLOW_2); 
             after(grammarAccess.getPackageStatementAccess().getVersionVERSIONTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__PackageStatement__VersionAssignment_3"


    // $ANTLR start "rule__RequireInclude__VersionAssignment_1"
    // InternalPerl.g:3832:1: rule__RequireInclude__VersionAssignment_1 : ( RULE_VERSION ) ;
    public final void rule__RequireInclude__VersionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3836:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:3837:2: ( RULE_VERSION )
            {
            // InternalPerl.g:3837:2: ( RULE_VERSION )
            // InternalPerl.g:3838:3: RULE_VERSION
            {
             before(grammarAccess.getRequireIncludeAccess().getVersionVERSIONTerminalRuleCall_1_0()); 
            match(input,RULE_VERSION,FOLLOW_2); 
             after(grammarAccess.getRequireIncludeAccess().getVersionVERSIONTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__RequireInclude__VersionAssignment_1"


    // $ANTLR start "rule__UseInclude__VersionAssignment_2_0"
    // InternalPerl.g:3847:1: rule__UseInclude__VersionAssignment_2_0 : ( RULE_VERSION ) ;
    public final void rule__UseInclude__VersionAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3851:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:3852:2: ( RULE_VERSION )
            {
            // InternalPerl.g:3852:2: ( RULE_VERSION )
            // InternalPerl.g:3853:3: RULE_VERSION
            {
             before(grammarAccess.getUseIncludeAccess().getVersionVERSIONTerminalRuleCall_2_0_0()); 
            match(input,RULE_VERSION,FOLLOW_2); 
             after(grammarAccess.getUseIncludeAccess().getVersionVERSIONTerminalRuleCall_2_0_0()); 

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
    // $ANTLR end "rule__UseInclude__VersionAssignment_2_0"


    // $ANTLR start "rule__UseInclude__PragmaOrPackageAssignment_2_1_0"
    // InternalPerl.g:3862:1: rule__UseInclude__PragmaOrPackageAssignment_2_1_0 : ( RULE_ID ) ;
    public final void rule__UseInclude__PragmaOrPackageAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3866:1: ( ( RULE_ID ) )
            // InternalPerl.g:3867:2: ( RULE_ID )
            {
            // InternalPerl.g:3867:2: ( RULE_ID )
            // InternalPerl.g:3868:3: RULE_ID
            {
             before(grammarAccess.getUseIncludeAccess().getPragmaOrPackageIDTerminalRuleCall_2_1_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getUseIncludeAccess().getPragmaOrPackageIDTerminalRuleCall_2_1_0_0()); 

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
    // $ANTLR end "rule__UseInclude__PragmaOrPackageAssignment_2_1_0"


    // $ANTLR start "rule__UseInclude__StringArgumentAssignment_2_1_1_0"
    // InternalPerl.g:3877:1: rule__UseInclude__StringArgumentAssignment_2_1_1_0 : ( ruleQuoteToken ) ;
    public final void rule__UseInclude__StringArgumentAssignment_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3881:1: ( ( ruleQuoteToken ) )
            // InternalPerl.g:3882:2: ( ruleQuoteToken )
            {
            // InternalPerl.g:3882:2: ( ruleQuoteToken )
            // InternalPerl.g:3883:3: ruleQuoteToken
            {
             before(grammarAccess.getUseIncludeAccess().getStringArgumentQuoteTokenParserRuleCall_2_1_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleQuoteToken();

            state._fsp--;

             after(grammarAccess.getUseIncludeAccess().getStringArgumentQuoteTokenParserRuleCall_2_1_1_0_0()); 

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
    // $ANTLR end "rule__UseInclude__StringArgumentAssignment_2_1_1_0"


    // $ANTLR start "rule__UseInclude__QwArgumentAssignment_2_1_1_1"
    // InternalPerl.g:3892:1: rule__UseInclude__QwArgumentAssignment_2_1_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__UseInclude__QwArgumentAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3896:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:3897:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:3897:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:3898:3: RULE_WORDS_QUOTE_LIKE
            {
             before(grammarAccess.getUseIncludeAccess().getQwArgumentWORDS_QUOTE_LIKETerminalRuleCall_2_1_1_1_0()); 
            match(input,RULE_WORDS_QUOTE_LIKE,FOLLOW_2); 
             after(grammarAccess.getUseIncludeAccess().getQwArgumentWORDS_QUOTE_LIKETerminalRuleCall_2_1_1_1_0()); 

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
    // $ANTLR end "rule__UseInclude__QwArgumentAssignment_2_1_1_1"


    // $ANTLR start "rule__Token__ContentAssignment_0_1"
    // InternalPerl.g:3907:1: rule__Token__ContentAssignment_0_1 : ( RULE_POD ) ;
    public final void rule__Token__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3911:1: ( ( RULE_POD ) )
            // InternalPerl.g:3912:2: ( RULE_POD )
            {
            // InternalPerl.g:3912:2: ( RULE_POD )
            // InternalPerl.g:3913:3: RULE_POD
            {
             before(grammarAccess.getTokenAccess().getContentPODTerminalRuleCall_0_1_0()); 
            match(input,RULE_POD,FOLLOW_2); 
             after(grammarAccess.getTokenAccess().getContentPODTerminalRuleCall_0_1_0()); 

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
    // InternalPerl.g:3922:1: rule__Token__ContentAssignment_1_1 : ( RULE_NUMBER ) ;
    public final void rule__Token__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3926:1: ( ( RULE_NUMBER ) )
            // InternalPerl.g:3927:2: ( RULE_NUMBER )
            {
            // InternalPerl.g:3927:2: ( RULE_NUMBER )
            // InternalPerl.g:3928:3: RULE_NUMBER
            {
             before(grammarAccess.getTokenAccess().getContentNUMBERTerminalRuleCall_1_1_0()); 
            match(input,RULE_NUMBER,FOLLOW_2); 
             after(grammarAccess.getTokenAccess().getContentNUMBERTerminalRuleCall_1_1_0()); 

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
    // InternalPerl.g:3937:1: rule__Token__ContentAssignment_2_1 : ( ruleWord ) ;
    public final void rule__Token__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3941:1: ( ( ruleWord ) )
            // InternalPerl.g:3942:2: ( ruleWord )
            {
            // InternalPerl.g:3942:2: ( ruleWord )
            // InternalPerl.g:3943:3: ruleWord
            {
             before(grammarAccess.getTokenAccess().getContentWordParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getTokenAccess().getContentWordParserRuleCall_2_1_0()); 

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
    // InternalPerl.g:3952:1: rule__Token__ContentAssignment_3_1 : ( RULE_SYMBOL ) ;
    public final void rule__Token__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3956:1: ( ( RULE_SYMBOL ) )
            // InternalPerl.g:3957:2: ( RULE_SYMBOL )
            {
            // InternalPerl.g:3957:2: ( RULE_SYMBOL )
            // InternalPerl.g:3958:3: RULE_SYMBOL
            {
             before(grammarAccess.getTokenAccess().getContentSYMBOLTerminalRuleCall_3_1_0()); 
            match(input,RULE_SYMBOL,FOLLOW_2); 
             after(grammarAccess.getTokenAccess().getContentSYMBOLTerminalRuleCall_3_1_0()); 

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


    // $ANTLR start "rule__Token__ContentAssignment_5_1"
    // InternalPerl.g:3967:1: rule__Token__ContentAssignment_5_1 : ( ruleFileTestOperator ) ;
    public final void rule__Token__ContentAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3971:1: ( ( ruleFileTestOperator ) )
            // InternalPerl.g:3972:2: ( ruleFileTestOperator )
            {
            // InternalPerl.g:3972:2: ( ruleFileTestOperator )
            // InternalPerl.g:3973:3: ruleFileTestOperator
            {
             before(grammarAccess.getTokenAccess().getContentFileTestOperatorParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFileTestOperator();

            state._fsp--;

             after(grammarAccess.getTokenAccess().getContentFileTestOperatorParserRuleCall_5_1_0()); 

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
    // $ANTLR end "rule__Token__ContentAssignment_5_1"


    // $ANTLR start "rule__Token__ContentAssignment_6_1"
    // InternalPerl.g:3982:1: rule__Token__ContentAssignment_6_1 : ( ruleOperator ) ;
    public final void rule__Token__ContentAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3986:1: ( ( ruleOperator ) )
            // InternalPerl.g:3987:2: ( ruleOperator )
            {
            // InternalPerl.g:3987:2: ( ruleOperator )
            // InternalPerl.g:3988:3: ruleOperator
            {
             before(grammarAccess.getTokenAccess().getContentOperatorParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getTokenAccess().getContentOperatorParserRuleCall_6_1_0()); 

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


    // $ANTLR start "rule__Token__ContentAssignment_8_1"
    // InternalPerl.g:3997:1: rule__Token__ContentAssignment_8_1 : ( RULE_DATA ) ;
    public final void rule__Token__ContentAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4001:1: ( ( RULE_DATA ) )
            // InternalPerl.g:4002:2: ( RULE_DATA )
            {
            // InternalPerl.g:4002:2: ( RULE_DATA )
            // InternalPerl.g:4003:3: RULE_DATA
            {
             before(grammarAccess.getTokenAccess().getContentDATATerminalRuleCall_8_1_0()); 
            match(input,RULE_DATA,FOLLOW_2); 
             after(grammarAccess.getTokenAccess().getContentDATATerminalRuleCall_8_1_0()); 

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
    // $ANTLR end "rule__Token__ContentAssignment_8_1"


    // $ANTLR start "rule__Token__ContentAssignment_9_1"
    // InternalPerl.g:4012:1: rule__Token__ContentAssignment_9_1 : ( RULE_END ) ;
    public final void rule__Token__ContentAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4016:1: ( ( RULE_END ) )
            // InternalPerl.g:4017:2: ( RULE_END )
            {
            // InternalPerl.g:4017:2: ( RULE_END )
            // InternalPerl.g:4018:3: RULE_END
            {
             before(grammarAccess.getTokenAccess().getContentENDTerminalRuleCall_9_1_0()); 
            match(input,RULE_END,FOLLOW_2); 
             after(grammarAccess.getTokenAccess().getContentENDTerminalRuleCall_9_1_0()); 

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


    // $ANTLR start "rule__QuoteToken__ContentAssignment_1"
    // InternalPerl.g:4027:1: rule__QuoteToken__ContentAssignment_1 : ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) ;
    public final void rule__QuoteToken__ContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4031:1: ( ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) )
            // InternalPerl.g:4032:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            {
            // InternalPerl.g:4032:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            // InternalPerl.g:4033:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            {
             before(grammarAccess.getQuoteTokenAccess().getContentAlternatives_1_0()); 
            // InternalPerl.g:4034:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            // InternalPerl.g:4034:4: rule__QuoteToken__ContentAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__QuoteToken__ContentAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getQuoteTokenAccess().getContentAlternatives_1_0()); 

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
    // InternalPerl.g:4042:1: rule__QuoteLikeToken__ContentAssignment_0_1 : ( RULE_BACKTICK_STRING ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4046:1: ( ( RULE_BACKTICK_STRING ) )
            // InternalPerl.g:4047:2: ( RULE_BACKTICK_STRING )
            {
            // InternalPerl.g:4047:2: ( RULE_BACKTICK_STRING )
            // InternalPerl.g:4048:3: RULE_BACKTICK_STRING
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentBACKTICK_STRINGTerminalRuleCall_0_1_0()); 
            match(input,RULE_BACKTICK_STRING,FOLLOW_2); 
             after(grammarAccess.getQuoteLikeTokenAccess().getContentBACKTICK_STRINGTerminalRuleCall_0_1_0()); 

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
    // InternalPerl.g:4057:1: rule__QuoteLikeToken__ContentAssignment_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4061:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:4062:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:4062:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:4063:3: RULE_WORDS_QUOTE_LIKE
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentWORDS_QUOTE_LIKETerminalRuleCall_1_1_0()); 
            match(input,RULE_WORDS_QUOTE_LIKE,FOLLOW_2); 
             after(grammarAccess.getQuoteLikeTokenAccess().getContentWORDS_QUOTE_LIKETerminalRuleCall_1_1_0()); 

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
    // InternalPerl.g:4072:1: rule__QuoteLikeToken__ContentAssignment_2_1 : ( RULE_COMMAND_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4076:1: ( ( RULE_COMMAND_QUOTE_LIKE ) )
            // InternalPerl.g:4077:2: ( RULE_COMMAND_QUOTE_LIKE )
            {
            // InternalPerl.g:4077:2: ( RULE_COMMAND_QUOTE_LIKE )
            // InternalPerl.g:4078:3: RULE_COMMAND_QUOTE_LIKE
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentCOMMAND_QUOTE_LIKETerminalRuleCall_2_1_0()); 
            match(input,RULE_COMMAND_QUOTE_LIKE,FOLLOW_2); 
             after(grammarAccess.getQuoteLikeTokenAccess().getContentCOMMAND_QUOTE_LIKETerminalRuleCall_2_1_0()); 

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
    // InternalPerl.g:4087:1: rule__QuoteLikeToken__ContentAssignment_3_1 : ( RULE_REGEX_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4091:1: ( ( RULE_REGEX_QUOTE ) )
            // InternalPerl.g:4092:2: ( RULE_REGEX_QUOTE )
            {
            // InternalPerl.g:4092:2: ( RULE_REGEX_QUOTE )
            // InternalPerl.g:4093:3: RULE_REGEX_QUOTE
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentREGEX_QUOTETerminalRuleCall_3_1_0()); 
            match(input,RULE_REGEX_QUOTE,FOLLOW_2); 
             after(grammarAccess.getQuoteLikeTokenAccess().getContentREGEX_QUOTETerminalRuleCall_3_1_0()); 

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
    // InternalPerl.g:4102:1: rule__QuoteLikeToken__ContentAssignment_4_1 : ( RULE_READLINE_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4106:1: ( ( RULE_READLINE_QUOTE ) )
            // InternalPerl.g:4107:2: ( RULE_READLINE_QUOTE )
            {
            // InternalPerl.g:4107:2: ( RULE_READLINE_QUOTE )
            // InternalPerl.g:4108:3: RULE_READLINE_QUOTE
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentREADLINE_QUOTETerminalRuleCall_4_1_0()); 
            match(input,RULE_READLINE_QUOTE,FOLLOW_2); 
             after(grammarAccess.getQuoteLikeTokenAccess().getContentREADLINE_QUOTETerminalRuleCall_4_1_0()); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFFFFFFE07FE70L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x000000000005FFFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFFFE07FE72L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x000000000005FFFFL});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000020000L,0x0000080000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000270L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0xFFFFFFFFFE000000L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x007FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xFFC0000000000000L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xFF80000000000000L,0x003FFFFFFFFFFFFFL,0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000078200L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});

}