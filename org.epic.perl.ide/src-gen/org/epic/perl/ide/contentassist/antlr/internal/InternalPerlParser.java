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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_REGEX_SUBSTITUTE", "RULE_REGEX_TRANSLITERATE", "RULE_REGEX_MATCH", "RULE_STRING", "RULE_INTERPOLATE", "RULE_LITERAL", "RULE_ID", "RULE_VERSION", "RULE_WORDS_QUOTE_LIKE", "RULE_POD", "RULE_NUMBER", "RULE_SYMBOL", "RULE_DATA", "RULE_END", "RULE_BACKTICK_STRING", "RULE_COMMAND_QUOTE_LIKE", "RULE_REGEX_QUOTE", "RULE_READLINE_QUOTE", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER", "RULE_SL_COMMENT", "';'", "'$'", "'%'", "'@'", "'&'", "'abs'", "'accept'", "'alarm'", "'atan2'", "'bind'", "'binmode'", "'bless'", "'break'", "'caller'", "'chdir'", "'chmod'", "'chomp'", "'chop'", "'chown'", "'chr'", "'chroot'", "'close'", "'closedir'", "'connect'", "'continue'", "'cos'", "'crypt'", "'dbmclose'", "'dbmopen'", "'default'", "'defined'", "'delete'", "'die'", "'do'", "'dump'", "'each'", "'else'", "'elsif'", "'endgrent'", "'endhostent'", "'endnetent'", "'endprotoent'", "'endpwent'", "'endservent'", "'eof'", "'eval'", "'evalbytes'", "'exec'", "'exists'", "'exit'", "'exp'", "'fc'", "'fcntl'", "'fileno'", "'flock'", "'for'", "'foreach'", "'fork'", "'format'", "'formline'", "'getc'", "'getgrent'", "'getgrgid'", "'getgrnam'", "'gethostbyaddr'", "'gethostbyname'", "'gethostent'", "'getlogin'", "'getnetbyaddr'", "'getnetbyname'", "'getnetent'", "'getpeername'", "'getpgrp'", "'getppid'", "'getpriority'", "'getprotobyname'", "'getprotobynumber'", "'getprotoent'", "'getpwent'", "'getpwnam'", "'getpwuid'", "'getservbyname'", "'getservbyport'", "'getservent'", "'getsockname'", "'getsockopt'", "'given'", "'glob'", "'gmtime'", "'goto'", "'grep'", "'hex'", "'if'", "'index'", "'int'", "'ioctl'", "'join'", "'keys'", "'kill'", "'last'", "'lc'", "'lcfirst'", "'length'", "'link'", "'listen'", "'local'", "'localtime'", "'lock'", "'log'", "'lstat'", "'map'", "'mkdir'", "'msgctl'", "'msgget'", "'msgrcv'", "'msgsnd'", "'my'", "'next'", "'no'", "'oct'", "'open'", "'opendir'", "'ord'", "'our'", "'pack'", "'package'", "'pipe'", "'pop'", "'pos'", "'print'", "'printf'", "'prototype'", "'push'", "'quotemeta'", "'rand'", "'read'", "'readdir'", "'readline'", "'readlink'", "'readpipe'", "'recv'", "'redo'", "'ref'", "'rename'", "'require'", "'reset'", "'return'", "'reverse'", "'rewinddir'", "'rindex'", "'rmdir'", "'say'", "'scalar'", "'seek'", "'seekdir'", "'select'", "'semctl'", "'semget'", "'semop'", "'send'", "'setgrent'", "'sethostent'", "'setnetent'", "'setpgrp'", "'setpriority'", "'setprotoent'", "'setpwent'", "'setservent'", "'setsockopt'", "'shift'", "'shmctl'", "'shmget'", "'shmread'", "'shmwrite'", "'shutdown'", "'sin'", "'sleep'", "'socket'", "'socketpair'", "'sort'", "'splice'", "'split'", "'sprintf'", "'sqrt'", "'srand'", "'stat'", "'state'", "'study'", "'sub'", "'substr'", "'symlink'", "'syscall'", "'sysopen'", "'sysread'", "'sysseek'", "'system'", "'syswrite'", "'tell'", "'telldir'", "'tie'", "'tied'", "'time'", "'times'", "'tr'", "'truncate'", "'uc'", "'ucfirst'", "'umask'", "'undef'", "'unless'", "'unlink'", "'unpack'", "'unshift'", "'untie'", "'until'", "'use'", "'utime'", "'values'", "'vec'", "'wait'", "'waitpid'", "'wantarray'", "'warn'", "'when'", "'while'", "'write'", "'y'", "'++'", "'--'", "'**'", "'!'", "'~'", "'+'", "'-'", "'=~'", "'!~'", "'*'", "'/'", "'x'", "'<<'", "'>>'", "'lt'", "'gt'", "'le'", "'ge'", "'cmp'", "'~~'", "'=='", "'!='", "'..'", "'...'", "','", "'|'", "'^'", "'&&'", "'||'", "'//'", "'?'", "':'", "'**='", "'+='", "'-='", "'.='", "'*='", "'/='", "'%='", "'x='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'&&='", "'||='", "'//='", "'<'", "'>'", "'<='", "'>='", "'<>'", "'=>'", "'->'", "'and'", "'or'", "'xor'", "'not'", "'eq'", "'ne'", "'-r'", "'-w'", "'-x'", "'-o'", "'-R'", "'-W'", "'-X'", "'-O'", "'-e'", "'-z'", "'-s'", "'-f'", "'-d'", "'-l'", "'-p'", "'-S'", "'-b'", "'-c'", "'-t'", "'-u'", "'-g'", "'-k'", "'-T'", "'-B'", "'-M'", "'-A'", "'-C'", "'{'", "'}'", "'('", "')'", "'<=>'", "'.'"
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
    public static final int RULE_READLINE_QUOTE=21;
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
    public static final int RULE_DATA=16;
    public static final int RULE_INT=24;
    public static final int T__66=66;
    public static final int RULE_COMMAND_QUOTE_LIKE=19;
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
    public static final int RULE_POD=13;
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
    public static final int RULE_REGEX_TRANSLITERATE=5;
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
    public static final int T__342=342;
    public static final int T__220=220;
    public static final int T__341=341;
    public static final int T__102=102;
    public static final int T__223=223;
    public static final int T__344=344;
    public static final int T__101=101;
    public static final int T__222=222;
    public static final int T__343=343;
    public static final int T__340=340;
    public static final int T__218=218;
    public static final int T__339=339;
    public static final int T__217=217;
    public static final int T__338=338;
    public static final int T__219=219;
    public static final int T__214=214;
    public static final int T__335=335;
    public static final int RULE_REGEX_SUBSTITUTE=4;
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
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__207=207;
    public static final int T__328=328;
    public static final int T__206=206;
    public static final int T__327=327;
    public static final int T__209=209;
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
    public static final int RULE_END=17;
    public static final int T__123=123;
    public static final int T__244=244;
    public static final int T__120=120;
    public static final int T__241=241;
    public static final int T__240=240;
    public static final int RULE_SL_COMMENT=27;
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
    public static final int RULE_NUMBER=14;
    public static final int T__108=108;
    public static final int T__229=229;
    public static final int T__107=107;
    public static final int T__228=228;
    public static final int T__109=109;
    public static final int T__104=104;
    public static final int T__225=225;
    public static final int T__346=346;
    public static final int T__103=103;
    public static final int T__224=224;
    public static final int T__345=345;
    public static final int T__106=106;
    public static final int T__227=227;
    public static final int T__348=348;
    public static final int T__105=105;
    public static final int T__226=226;
    public static final int T__347=347;
    public static final int T__300=300;
    public static final int RULE_HEX=22;
    public static final int RULE_VERSION=11;
    public static final int RULE_LITERAL=9;
    public static final int RULE_BIN=23;
    public static final int RULE_REGEX_MATCH=6;
    public static final int RULE_INTERPOLATE=8;
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
    public static final int RULE_WORDS_QUOTE_LIKE=12;
    public static final int T__169=169;
    public static final int RULE_REGEX_QUOTE=20;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=7;
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
    public static final int RULE_WS=25;
    public static final int T__197=197;
    public static final int RULE_BACKTICK_STRING=18;
    public static final int T__196=196;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=26;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int RULE_SYMBOL=15;
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
    // InternalPerl.g:137:1: ruleStatementNode : ( ( rule__StatementNode__Alternatives ) ) ;
    public final void ruleStatementNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:141:2: ( ( ( rule__StatementNode__Alternatives ) ) )
            // InternalPerl.g:142:2: ( ( rule__StatementNode__Alternatives ) )
            {
            // InternalPerl.g:142:2: ( ( rule__StatementNode__Alternatives ) )
            // InternalPerl.g:143:3: ( rule__StatementNode__Alternatives )
            {
             before(grammarAccess.getStatementNodeAccess().getAlternatives()); 
            // InternalPerl.g:144:3: ( rule__StatementNode__Alternatives )
            // InternalPerl.g:144:4: rule__StatementNode__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__StatementNode__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStatementNodeAccess().getAlternatives()); 

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


    // $ANTLR start "entryRuleBlockStatement"
    // InternalPerl.g:153:1: entryRuleBlockStatement : ruleBlockStatement EOF ;
    public final void entryRuleBlockStatement() throws RecognitionException {
        try {
            // InternalPerl.g:154:1: ( ruleBlockStatement EOF )
            // InternalPerl.g:155:1: ruleBlockStatement EOF
            {
             before(grammarAccess.getBlockStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleBlockStatement();

            state._fsp--;

             after(grammarAccess.getBlockStatementRule()); 
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
    // $ANTLR end "entryRuleBlockStatement"


    // $ANTLR start "ruleBlockStatement"
    // InternalPerl.g:162:1: ruleBlockStatement : ( ruleSubStatement ) ;
    public final void ruleBlockStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:166:2: ( ( ruleSubStatement ) )
            // InternalPerl.g:167:2: ( ruleSubStatement )
            {
            // InternalPerl.g:167:2: ( ruleSubStatement )
            // InternalPerl.g:168:3: ruleSubStatement
            {
             before(grammarAccess.getBlockStatementAccess().getSubStatementParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleSubStatement();

            state._fsp--;

             after(grammarAccess.getBlockStatementAccess().getSubStatementParserRuleCall()); 

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
    // $ANTLR end "ruleBlockStatement"


    // $ANTLR start "entryRuleExpressionStatement"
    // InternalPerl.g:178:1: entryRuleExpressionStatement : ruleExpressionStatement EOF ;
    public final void entryRuleExpressionStatement() throws RecognitionException {
        try {
            // InternalPerl.g:179:1: ( ruleExpressionStatement EOF )
            // InternalPerl.g:180:1: ruleExpressionStatement EOF
            {
             before(grammarAccess.getExpressionStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleExpressionStatement();

            state._fsp--;

             after(grammarAccess.getExpressionStatementRule()); 
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
    // $ANTLR end "entryRuleExpressionStatement"


    // $ANTLR start "ruleExpressionStatement"
    // InternalPerl.g:187:1: ruleExpressionStatement : ( ( rule__ExpressionStatement__Group__0 ) ) ;
    public final void ruleExpressionStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:191:2: ( ( ( rule__ExpressionStatement__Group__0 ) ) )
            // InternalPerl.g:192:2: ( ( rule__ExpressionStatement__Group__0 ) )
            {
            // InternalPerl.g:192:2: ( ( rule__ExpressionStatement__Group__0 ) )
            // InternalPerl.g:193:3: ( rule__ExpressionStatement__Group__0 )
            {
             before(grammarAccess.getExpressionStatementAccess().getGroup()); 
            // InternalPerl.g:194:3: ( rule__ExpressionStatement__Group__0 )
            // InternalPerl.g:194:4: rule__ExpressionStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionStatementAccess().getGroup()); 

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
    // $ANTLR end "ruleExpressionStatement"


    // $ANTLR start "entryRulePackageStatement"
    // InternalPerl.g:203:1: entryRulePackageStatement : rulePackageStatement EOF ;
    public final void entryRulePackageStatement() throws RecognitionException {
        try {
            // InternalPerl.g:204:1: ( rulePackageStatement EOF )
            // InternalPerl.g:205:1: rulePackageStatement EOF
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
    // InternalPerl.g:212:1: rulePackageStatement : ( ( rule__PackageStatement__Group__0 ) ) ;
    public final void rulePackageStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:216:2: ( ( ( rule__PackageStatement__Group__0 ) ) )
            // InternalPerl.g:217:2: ( ( rule__PackageStatement__Group__0 ) )
            {
            // InternalPerl.g:217:2: ( ( rule__PackageStatement__Group__0 ) )
            // InternalPerl.g:218:3: ( rule__PackageStatement__Group__0 )
            {
             before(grammarAccess.getPackageStatementAccess().getGroup()); 
            // InternalPerl.g:219:3: ( rule__PackageStatement__Group__0 )
            // InternalPerl.g:219:4: rule__PackageStatement__Group__0
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
    // InternalPerl.g:228:1: entryRuleIncludeStatement : ruleIncludeStatement EOF ;
    public final void entryRuleIncludeStatement() throws RecognitionException {
        try {
            // InternalPerl.g:229:1: ( ruleIncludeStatement EOF )
            // InternalPerl.g:230:1: ruleIncludeStatement EOF
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
    // InternalPerl.g:237:1: ruleIncludeStatement : ( ( rule__IncludeStatement__Alternatives ) ) ;
    public final void ruleIncludeStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:241:2: ( ( ( rule__IncludeStatement__Alternatives ) ) )
            // InternalPerl.g:242:2: ( ( rule__IncludeStatement__Alternatives ) )
            {
            // InternalPerl.g:242:2: ( ( rule__IncludeStatement__Alternatives ) )
            // InternalPerl.g:243:3: ( rule__IncludeStatement__Alternatives )
            {
             before(grammarAccess.getIncludeStatementAccess().getAlternatives()); 
            // InternalPerl.g:244:3: ( rule__IncludeStatement__Alternatives )
            // InternalPerl.g:244:4: rule__IncludeStatement__Alternatives
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
    // InternalPerl.g:253:1: entryRuleRequireInclude : ruleRequireInclude EOF ;
    public final void entryRuleRequireInclude() throws RecognitionException {
        try {
            // InternalPerl.g:254:1: ( ruleRequireInclude EOF )
            // InternalPerl.g:255:1: ruleRequireInclude EOF
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
    // InternalPerl.g:262:1: ruleRequireInclude : ( ( rule__RequireInclude__Group__0 ) ) ;
    public final void ruleRequireInclude() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:266:2: ( ( ( rule__RequireInclude__Group__0 ) ) )
            // InternalPerl.g:267:2: ( ( rule__RequireInclude__Group__0 ) )
            {
            // InternalPerl.g:267:2: ( ( rule__RequireInclude__Group__0 ) )
            // InternalPerl.g:268:3: ( rule__RequireInclude__Group__0 )
            {
             before(grammarAccess.getRequireIncludeAccess().getGroup()); 
            // InternalPerl.g:269:3: ( rule__RequireInclude__Group__0 )
            // InternalPerl.g:269:4: rule__RequireInclude__Group__0
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
    // InternalPerl.g:278:1: entryRuleUseInclude : ruleUseInclude EOF ;
    public final void entryRuleUseInclude() throws RecognitionException {
        try {
            // InternalPerl.g:279:1: ( ruleUseInclude EOF )
            // InternalPerl.g:280:1: ruleUseInclude EOF
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
    // InternalPerl.g:287:1: ruleUseInclude : ( ( rule__UseInclude__Group__0 ) ) ;
    public final void ruleUseInclude() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:291:2: ( ( ( rule__UseInclude__Group__0 ) ) )
            // InternalPerl.g:292:2: ( ( rule__UseInclude__Group__0 ) )
            {
            // InternalPerl.g:292:2: ( ( rule__UseInclude__Group__0 ) )
            // InternalPerl.g:293:3: ( rule__UseInclude__Group__0 )
            {
             before(grammarAccess.getUseIncludeAccess().getGroup()); 
            // InternalPerl.g:294:3: ( rule__UseInclude__Group__0 )
            // InternalPerl.g:294:4: rule__UseInclude__Group__0
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


    // $ANTLR start "entryRuleSubStatement"
    // InternalPerl.g:303:1: entryRuleSubStatement : ruleSubStatement EOF ;
    public final void entryRuleSubStatement() throws RecognitionException {
        try {
            // InternalPerl.g:304:1: ( ruleSubStatement EOF )
            // InternalPerl.g:305:1: ruleSubStatement EOF
            {
             before(grammarAccess.getSubStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleSubStatement();

            state._fsp--;

             after(grammarAccess.getSubStatementRule()); 
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
    // $ANTLR end "entryRuleSubStatement"


    // $ANTLR start "ruleSubStatement"
    // InternalPerl.g:312:1: ruleSubStatement : ( ( rule__SubStatement__Group__0 ) ) ;
    public final void ruleSubStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:316:2: ( ( ( rule__SubStatement__Group__0 ) ) )
            // InternalPerl.g:317:2: ( ( rule__SubStatement__Group__0 ) )
            {
            // InternalPerl.g:317:2: ( ( rule__SubStatement__Group__0 ) )
            // InternalPerl.g:318:3: ( rule__SubStatement__Group__0 )
            {
             before(grammarAccess.getSubStatementAccess().getGroup()); 
            // InternalPerl.g:319:3: ( rule__SubStatement__Group__0 )
            // InternalPerl.g:319:4: rule__SubStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SubStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubStatementAccess().getGroup()); 

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
    // $ANTLR end "ruleSubStatement"


    // $ANTLR start "entryRuleStatementBlock"
    // InternalPerl.g:328:1: entryRuleStatementBlock : ruleStatementBlock EOF ;
    public final void entryRuleStatementBlock() throws RecognitionException {
        try {
            // InternalPerl.g:329:1: ( ruleStatementBlock EOF )
            // InternalPerl.g:330:1: ruleStatementBlock EOF
            {
             before(grammarAccess.getStatementBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleStatementBlock();

            state._fsp--;

             after(grammarAccess.getStatementBlockRule()); 
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
    // $ANTLR end "entryRuleStatementBlock"


    // $ANTLR start "ruleStatementBlock"
    // InternalPerl.g:337:1: ruleStatementBlock : ( ( rule__StatementBlock__Group__0 ) ) ;
    public final void ruleStatementBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:341:2: ( ( ( rule__StatementBlock__Group__0 ) ) )
            // InternalPerl.g:342:2: ( ( rule__StatementBlock__Group__0 ) )
            {
            // InternalPerl.g:342:2: ( ( rule__StatementBlock__Group__0 ) )
            // InternalPerl.g:343:3: ( rule__StatementBlock__Group__0 )
            {
             before(grammarAccess.getStatementBlockAccess().getGroup()); 
            // InternalPerl.g:344:3: ( rule__StatementBlock__Group__0 )
            // InternalPerl.g:344:4: rule__StatementBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StatementBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStatementBlockAccess().getGroup()); 

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
    // $ANTLR end "ruleStatementBlock"


    // $ANTLR start "entryRulePrototype"
    // InternalPerl.g:353:1: entryRulePrototype : rulePrototype EOF ;
    public final void entryRulePrototype() throws RecognitionException {
        try {
            // InternalPerl.g:354:1: ( rulePrototype EOF )
            // InternalPerl.g:355:1: rulePrototype EOF
            {
             before(grammarAccess.getPrototypeRule()); 
            pushFollow(FOLLOW_1);
            rulePrototype();

            state._fsp--;

             after(grammarAccess.getPrototypeRule()); 
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
    // $ANTLR end "entryRulePrototype"


    // $ANTLR start "rulePrototype"
    // InternalPerl.g:362:1: rulePrototype : ( ( rule__Prototype__Group__0 ) ) ;
    public final void rulePrototype() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:366:2: ( ( ( rule__Prototype__Group__0 ) ) )
            // InternalPerl.g:367:2: ( ( rule__Prototype__Group__0 ) )
            {
            // InternalPerl.g:367:2: ( ( rule__Prototype__Group__0 ) )
            // InternalPerl.g:368:3: ( rule__Prototype__Group__0 )
            {
             before(grammarAccess.getPrototypeAccess().getGroup()); 
            // InternalPerl.g:369:3: ( rule__Prototype__Group__0 )
            // InternalPerl.g:369:4: rule__Prototype__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Prototype__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPrototypeAccess().getGroup()); 

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
    // $ANTLR end "rulePrototype"


    // $ANTLR start "entryRuleToken"
    // InternalPerl.g:378:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // InternalPerl.g:379:1: ( ruleToken EOF )
            // InternalPerl.g:380:1: ruleToken EOF
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
    // InternalPerl.g:387:1: ruleToken : ( ( rule__Token__Alternatives ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:391:2: ( ( ( rule__Token__Alternatives ) ) )
            // InternalPerl.g:392:2: ( ( rule__Token__Alternatives ) )
            {
            // InternalPerl.g:392:2: ( ( rule__Token__Alternatives ) )
            // InternalPerl.g:393:3: ( rule__Token__Alternatives )
            {
             before(grammarAccess.getTokenAccess().getAlternatives()); 
            // InternalPerl.g:394:3: ( rule__Token__Alternatives )
            // InternalPerl.g:394:4: rule__Token__Alternatives
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


    // $ANTLR start "entryRuleRegexToken"
    // InternalPerl.g:403:1: entryRuleRegexToken : ruleRegexToken EOF ;
    public final void entryRuleRegexToken() throws RecognitionException {
        try {
            // InternalPerl.g:404:1: ( ruleRegexToken EOF )
            // InternalPerl.g:405:1: ruleRegexToken EOF
            {
             before(grammarAccess.getRegexTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleRegexToken();

            state._fsp--;

             after(grammarAccess.getRegexTokenRule()); 
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
    // $ANTLR end "entryRuleRegexToken"


    // $ANTLR start "ruleRegexToken"
    // InternalPerl.g:412:1: ruleRegexToken : ( ( rule__RegexToken__Group__0 ) ) ;
    public final void ruleRegexToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:416:2: ( ( ( rule__RegexToken__Group__0 ) ) )
            // InternalPerl.g:417:2: ( ( rule__RegexToken__Group__0 ) )
            {
            // InternalPerl.g:417:2: ( ( rule__RegexToken__Group__0 ) )
            // InternalPerl.g:418:3: ( rule__RegexToken__Group__0 )
            {
             before(grammarAccess.getRegexTokenAccess().getGroup()); 
            // InternalPerl.g:419:3: ( rule__RegexToken__Group__0 )
            // InternalPerl.g:419:4: rule__RegexToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RegexToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRegexTokenAccess().getGroup()); 

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
    // $ANTLR end "ruleRegexToken"


    // $ANTLR start "entryRuleQuoteToken"
    // InternalPerl.g:428:1: entryRuleQuoteToken : ruleQuoteToken EOF ;
    public final void entryRuleQuoteToken() throws RecognitionException {
        try {
            // InternalPerl.g:429:1: ( ruleQuoteToken EOF )
            // InternalPerl.g:430:1: ruleQuoteToken EOF
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
    // InternalPerl.g:437:1: ruleQuoteToken : ( ( rule__QuoteToken__Group__0 ) ) ;
    public final void ruleQuoteToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:441:2: ( ( ( rule__QuoteToken__Group__0 ) ) )
            // InternalPerl.g:442:2: ( ( rule__QuoteToken__Group__0 ) )
            {
            // InternalPerl.g:442:2: ( ( rule__QuoteToken__Group__0 ) )
            // InternalPerl.g:443:3: ( rule__QuoteToken__Group__0 )
            {
             before(grammarAccess.getQuoteTokenAccess().getGroup()); 
            // InternalPerl.g:444:3: ( rule__QuoteToken__Group__0 )
            // InternalPerl.g:444:4: rule__QuoteToken__Group__0
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
    // InternalPerl.g:453:1: entryRuleQuoteLikeToken : ruleQuoteLikeToken EOF ;
    public final void entryRuleQuoteLikeToken() throws RecognitionException {
        try {
            // InternalPerl.g:454:1: ( ruleQuoteLikeToken EOF )
            // InternalPerl.g:455:1: ruleQuoteLikeToken EOF
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
    // InternalPerl.g:462:1: ruleQuoteLikeToken : ( ( rule__QuoteLikeToken__Alternatives ) ) ;
    public final void ruleQuoteLikeToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:466:2: ( ( ( rule__QuoteLikeToken__Alternatives ) ) )
            // InternalPerl.g:467:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            {
            // InternalPerl.g:467:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            // InternalPerl.g:468:3: ( rule__QuoteLikeToken__Alternatives )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getAlternatives()); 
            // InternalPerl.g:469:3: ( rule__QuoteLikeToken__Alternatives )
            // InternalPerl.g:469:4: rule__QuoteLikeToken__Alternatives
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
    // InternalPerl.g:478:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalPerl.g:479:1: ( ruleWord EOF )
            // InternalPerl.g:480:1: ruleWord EOF
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
    // InternalPerl.g:487:1: ruleWord : ( ruleKeyword ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:491:2: ( ( ruleKeyword ) )
            // InternalPerl.g:492:2: ( ruleKeyword )
            {
            // InternalPerl.g:492:2: ( ruleKeyword )
            // InternalPerl.g:493:3: ruleKeyword
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
    // InternalPerl.g:503:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalPerl.g:504:1: ( ruleKeyword EOF )
            // InternalPerl.g:505:1: ruleKeyword EOF
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
    // InternalPerl.g:512:1: ruleKeyword : ( ( rule__Keyword__Alternatives ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:516:2: ( ( ( rule__Keyword__Alternatives ) ) )
            // InternalPerl.g:517:2: ( ( rule__Keyword__Alternatives ) )
            {
            // InternalPerl.g:517:2: ( ( rule__Keyword__Alternatives ) )
            // InternalPerl.g:518:3: ( rule__Keyword__Alternatives )
            {
             before(grammarAccess.getKeywordAccess().getAlternatives()); 
            // InternalPerl.g:519:3: ( rule__Keyword__Alternatives )
            // InternalPerl.g:519:4: rule__Keyword__Alternatives
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
    // InternalPerl.g:528:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalPerl.g:529:1: ( ruleOperator EOF )
            // InternalPerl.g:530:1: ruleOperator EOF
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
    // InternalPerl.g:537:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:541:2: ( ( ( rule__Operator__Alternatives ) ) )
            // InternalPerl.g:542:2: ( ( rule__Operator__Alternatives ) )
            {
            // InternalPerl.g:542:2: ( ( rule__Operator__Alternatives ) )
            // InternalPerl.g:543:3: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // InternalPerl.g:544:3: ( rule__Operator__Alternatives )
            // InternalPerl.g:544:4: rule__Operator__Alternatives
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
    // InternalPerl.g:553:1: entryRuleFileTestOperator : ruleFileTestOperator EOF ;
    public final void entryRuleFileTestOperator() throws RecognitionException {
        try {
            // InternalPerl.g:554:1: ( ruleFileTestOperator EOF )
            // InternalPerl.g:555:1: ruleFileTestOperator EOF
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
    // InternalPerl.g:562:1: ruleFileTestOperator : ( ( rule__FileTestOperator__Alternatives ) ) ;
    public final void ruleFileTestOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:566:2: ( ( ( rule__FileTestOperator__Alternatives ) ) )
            // InternalPerl.g:567:2: ( ( rule__FileTestOperator__Alternatives ) )
            {
            // InternalPerl.g:567:2: ( ( rule__FileTestOperator__Alternatives ) )
            // InternalPerl.g:568:3: ( rule__FileTestOperator__Alternatives )
            {
             before(grammarAccess.getFileTestOperatorAccess().getAlternatives()); 
            // InternalPerl.g:569:3: ( rule__FileTestOperator__Alternatives )
            // InternalPerl.g:569:4: rule__FileTestOperator__Alternatives
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
    // InternalPerl.g:577:1: rule__Element__Alternatives : ( ( ruleNode ) | ( ruleToken ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:581:1: ( ( ruleNode ) | ( ruleToken ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==216) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==RULE_ID) ) {
                    alt1=1;
                }
                else if ( (LA1_1==EOF||(LA1_1>=RULE_REGEX_SUBSTITUTE && LA1_1<=RULE_LITERAL)||(LA1_1>=RULE_WORDS_QUOTE_LIKE && LA1_1<=RULE_READLINE_QUOTE)||LA1_1==30||(LA1_1>=32 && LA1_1<=342)||LA1_1==347) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==153) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==RULE_ID) ) {
                    alt1=1;
                }
                else if ( (LA1_2==EOF||(LA1_2>=RULE_REGEX_SUBSTITUTE && LA1_2<=RULE_LITERAL)||(LA1_2>=RULE_WORDS_QUOTE_LIKE && LA1_2<=RULE_READLINE_QUOTE)||LA1_2==30||(LA1_2>=32 && LA1_2<=342)||LA1_2==347) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==172) ) {
                int LA1_3 = input.LA(2);

                if ( (LA1_3==RULE_VERSION) ) {
                    alt1=1;
                }
                else if ( (LA1_3==EOF||(LA1_3>=RULE_REGEX_SUBSTITUTE && LA1_3<=RULE_LITERAL)||(LA1_3>=RULE_WORDS_QUOTE_LIKE && LA1_3<=RULE_READLINE_QUOTE)||LA1_3==30||(LA1_3>=32 && LA1_3<=342)||LA1_3==347) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==243) ) {
                int LA1_4 = input.LA(2);

                if ( (LA1_4==EOF||(LA1_4>=RULE_REGEX_SUBSTITUTE && LA1_4<=RULE_LITERAL)||(LA1_4>=RULE_WORDS_QUOTE_LIKE && LA1_4<=RULE_READLINE_QUOTE)||LA1_4==30||(LA1_4>=32 && LA1_4<=342)||LA1_4==347) ) {
                    alt1=2;
                }
                else if ( ((LA1_4>=RULE_ID && LA1_4<=RULE_VERSION)) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 4, input);

                    throw nvae;
                }
            }
            else if ( ((LA1_0>=RULE_REGEX_SUBSTITUTE && LA1_0<=RULE_LITERAL)||(LA1_0>=RULE_WORDS_QUOTE_LIKE && LA1_0<=RULE_READLINE_QUOTE)||LA1_0==30||(LA1_0>=32 && LA1_0<=152)||(LA1_0>=154 && LA1_0<=171)||(LA1_0>=173 && LA1_0<=215)||(LA1_0>=217 && LA1_0<=242)||(LA1_0>=244 && LA1_0<=342)||LA1_0==347) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalPerl.g:582:2: ( ruleNode )
                    {
                    // InternalPerl.g:582:2: ( ruleNode )
                    // InternalPerl.g:583:3: ruleNode
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
                    // InternalPerl.g:588:2: ( ruleToken )
                    {
                    // InternalPerl.g:588:2: ( ruleToken )
                    // InternalPerl.g:589:3: ruleToken
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


    // $ANTLR start "rule__StatementNode__Alternatives"
    // InternalPerl.g:598:1: rule__StatementNode__Alternatives : ( ( ruleBlockStatement ) | ( ruleExpressionStatement ) );
    public final void rule__StatementNode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:602:1: ( ( ruleBlockStatement ) | ( ruleExpressionStatement ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==216) ) {
                alt2=1;
            }
            else if ( (LA2_0==153||LA2_0==172||LA2_0==243) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalPerl.g:603:2: ( ruleBlockStatement )
                    {
                    // InternalPerl.g:603:2: ( ruleBlockStatement )
                    // InternalPerl.g:604:3: ruleBlockStatement
                    {
                     before(grammarAccess.getStatementNodeAccess().getBlockStatementParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleBlockStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementNodeAccess().getBlockStatementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:609:2: ( ruleExpressionStatement )
                    {
                    // InternalPerl.g:609:2: ( ruleExpressionStatement )
                    // InternalPerl.g:610:3: ruleExpressionStatement
                    {
                     before(grammarAccess.getStatementNodeAccess().getExpressionStatementParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleExpressionStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementNodeAccess().getExpressionStatementParserRuleCall_1()); 

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
    // $ANTLR end "rule__StatementNode__Alternatives"


    // $ANTLR start "rule__ExpressionStatement__Alternatives_0"
    // InternalPerl.g:619:1: rule__ExpressionStatement__Alternatives_0 : ( ( rulePackageStatement ) | ( ruleIncludeStatement ) );
    public final void rule__ExpressionStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:623:1: ( ( rulePackageStatement ) | ( ruleIncludeStatement ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==153) ) {
                alt3=1;
            }
            else if ( (LA3_0==172||LA3_0==243) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalPerl.g:624:2: ( rulePackageStatement )
                    {
                    // InternalPerl.g:624:2: ( rulePackageStatement )
                    // InternalPerl.g:625:3: rulePackageStatement
                    {
                     before(grammarAccess.getExpressionStatementAccess().getPackageStatementParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    rulePackageStatement();

                    state._fsp--;

                     after(grammarAccess.getExpressionStatementAccess().getPackageStatementParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:630:2: ( ruleIncludeStatement )
                    {
                    // InternalPerl.g:630:2: ( ruleIncludeStatement )
                    // InternalPerl.g:631:3: ruleIncludeStatement
                    {
                     before(grammarAccess.getExpressionStatementAccess().getIncludeStatementParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleIncludeStatement();

                    state._fsp--;

                     after(grammarAccess.getExpressionStatementAccess().getIncludeStatementParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__ExpressionStatement__Alternatives_0"


    // $ANTLR start "rule__IncludeStatement__Alternatives"
    // InternalPerl.g:640:1: rule__IncludeStatement__Alternatives : ( ( ruleRequireInclude ) | ( ruleUseInclude ) );
    public final void rule__IncludeStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:644:1: ( ( ruleRequireInclude ) | ( ruleUseInclude ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==172) ) {
                alt4=1;
            }
            else if ( (LA4_0==243) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalPerl.g:645:2: ( ruleRequireInclude )
                    {
                    // InternalPerl.g:645:2: ( ruleRequireInclude )
                    // InternalPerl.g:646:3: ruleRequireInclude
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
                    // InternalPerl.g:651:2: ( ruleUseInclude )
                    {
                    // InternalPerl.g:651:2: ( ruleUseInclude )
                    // InternalPerl.g:652:3: ruleUseInclude
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
    // InternalPerl.g:661:1: rule__UseInclude__Alternatives_2 : ( ( ( rule__UseInclude__VersionAssignment_2_0 ) ) | ( ( rule__UseInclude__Group_2_1__0 ) ) );
    public final void rule__UseInclude__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:665:1: ( ( ( rule__UseInclude__VersionAssignment_2_0 ) ) | ( ( rule__UseInclude__Group_2_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_VERSION) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalPerl.g:666:2: ( ( rule__UseInclude__VersionAssignment_2_0 ) )
                    {
                    // InternalPerl.g:666:2: ( ( rule__UseInclude__VersionAssignment_2_0 ) )
                    // InternalPerl.g:667:3: ( rule__UseInclude__VersionAssignment_2_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getVersionAssignment_2_0()); 
                    // InternalPerl.g:668:3: ( rule__UseInclude__VersionAssignment_2_0 )
                    // InternalPerl.g:668:4: rule__UseInclude__VersionAssignment_2_0
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
                    // InternalPerl.g:672:2: ( ( rule__UseInclude__Group_2_1__0 ) )
                    {
                    // InternalPerl.g:672:2: ( ( rule__UseInclude__Group_2_1__0 ) )
                    // InternalPerl.g:673:3: ( rule__UseInclude__Group_2_1__0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getGroup_2_1()); 
                    // InternalPerl.g:674:3: ( rule__UseInclude__Group_2_1__0 )
                    // InternalPerl.g:674:4: rule__UseInclude__Group_2_1__0
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
    // InternalPerl.g:682:1: rule__UseInclude__Alternatives_2_1_1 : ( ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) ) | ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) ) );
    public final void rule__UseInclude__Alternatives_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:686:1: ( ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) ) | ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_LITERAL)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_WORDS_QUOTE_LIKE) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalPerl.g:687:2: ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) )
                    {
                    // InternalPerl.g:687:2: ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) )
                    // InternalPerl.g:688:3: ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getStringArgumentAssignment_2_1_1_0()); 
                    // InternalPerl.g:689:3: ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 )
                    // InternalPerl.g:689:4: rule__UseInclude__StringArgumentAssignment_2_1_1_0
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
                    // InternalPerl.g:693:2: ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) )
                    {
                    // InternalPerl.g:693:2: ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) )
                    // InternalPerl.g:694:3: ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getQwArgumentAssignment_2_1_1_1()); 
                    // InternalPerl.g:695:3: ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 )
                    // InternalPerl.g:695:4: rule__UseInclude__QwArgumentAssignment_2_1_1_1
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


    // $ANTLR start "rule__SubStatement__Alternatives_4"
    // InternalPerl.g:703:1: rule__SubStatement__Alternatives_4 : ( ( ';' ) | ( ( rule__SubStatement__BlockAssignment_4_1 ) ) );
    public final void rule__SubStatement__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:707:1: ( ( ';' ) | ( ( rule__SubStatement__BlockAssignment_4_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==28) ) {
                alt7=1;
            }
            else if ( (LA7_0==343) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalPerl.g:708:2: ( ';' )
                    {
                    // InternalPerl.g:708:2: ( ';' )
                    // InternalPerl.g:709:3: ';'
                    {
                     before(grammarAccess.getSubStatementAccess().getSemicolonKeyword_4_0()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getSubStatementAccess().getSemicolonKeyword_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:714:2: ( ( rule__SubStatement__BlockAssignment_4_1 ) )
                    {
                    // InternalPerl.g:714:2: ( ( rule__SubStatement__BlockAssignment_4_1 ) )
                    // InternalPerl.g:715:3: ( rule__SubStatement__BlockAssignment_4_1 )
                    {
                     before(grammarAccess.getSubStatementAccess().getBlockAssignment_4_1()); 
                    // InternalPerl.g:716:3: ( rule__SubStatement__BlockAssignment_4_1 )
                    // InternalPerl.g:716:4: rule__SubStatement__BlockAssignment_4_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SubStatement__BlockAssignment_4_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSubStatementAccess().getBlockAssignment_4_1()); 

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
    // $ANTLR end "rule__SubStatement__Alternatives_4"


    // $ANTLR start "rule__Prototype__Alternatives_1"
    // InternalPerl.g:724:1: rule__Prototype__Alternatives_1 : ( ( '$' ) | ( '%' ) | ( '@' ) | ( '&' ) | ( ';' ) );
    public final void rule__Prototype__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:728:1: ( ( '$' ) | ( '%' ) | ( '@' ) | ( '&' ) | ( ';' ) )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt8=1;
                }
                break;
            case 30:
                {
                alt8=2;
                }
                break;
            case 31:
                {
                alt8=3;
                }
                break;
            case 32:
                {
                alt8=4;
                }
                break;
            case 28:
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
                    // InternalPerl.g:729:2: ( '$' )
                    {
                    // InternalPerl.g:729:2: ( '$' )
                    // InternalPerl.g:730:3: '$'
                    {
                     before(grammarAccess.getPrototypeAccess().getDollarSignKeyword_1_0()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getDollarSignKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:735:2: ( '%' )
                    {
                    // InternalPerl.g:735:2: ( '%' )
                    // InternalPerl.g:736:3: '%'
                    {
                     before(grammarAccess.getPrototypeAccess().getPercentSignKeyword_1_1()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getPercentSignKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:741:2: ( '@' )
                    {
                    // InternalPerl.g:741:2: ( '@' )
                    // InternalPerl.g:742:3: '@'
                    {
                     before(grammarAccess.getPrototypeAccess().getCommercialAtKeyword_1_2()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getCommercialAtKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:747:2: ( '&' )
                    {
                    // InternalPerl.g:747:2: ( '&' )
                    // InternalPerl.g:748:3: '&'
                    {
                     before(grammarAccess.getPrototypeAccess().getAmpersandKeyword_1_3()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getAmpersandKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:753:2: ( ';' )
                    {
                    // InternalPerl.g:753:2: ( ';' )
                    // InternalPerl.g:754:3: ';'
                    {
                     before(grammarAccess.getPrototypeAccess().getSemicolonKeyword_1_4()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getSemicolonKeyword_1_4()); 

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
    // $ANTLR end "rule__Prototype__Alternatives_1"


    // $ANTLR start "rule__Token__Alternatives"
    // InternalPerl.g:763:1: rule__Token__Alternatives : ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ruleQuoteToken ) | ( ruleRegexToken ) | ( ( rule__Token__Group_9__0 ) ) | ( ( rule__Token__Group_10__0 ) ) );
    public final void rule__Token__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:767:1: ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ruleQuoteToken ) | ( ruleRegexToken ) | ( ( rule__Token__Group_9__0 ) ) | ( ( rule__Token__Group_10__0 ) ) )
            int alt9=11;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_POD) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_NUMBER) ) {
                alt9=2;
            }
            else if ( ((LA9_0>=33 && LA9_0<=254)) ) {
                alt9=3;
            }
            else if ( (LA9_0==RULE_SYMBOL) ) {
                alt9=4;
            }
            else if ( (LA9_0==RULE_WORDS_QUOTE_LIKE||(LA9_0>=RULE_BACKTICK_STRING && LA9_0<=RULE_READLINE_QUOTE)) ) {
                alt9=5;
            }
            else if ( ((LA9_0>=316 && LA9_0<=342)) ) {
                alt9=6;
            }
            else if ( (LA9_0==30||LA9_0==32||(LA9_0>=255 && LA9_0<=315)||LA9_0==347) ) {
                alt9=7;
            }
            else if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_LITERAL)) ) {
                alt9=8;
            }
            else if ( ((LA9_0>=RULE_REGEX_SUBSTITUTE && LA9_0<=RULE_REGEX_MATCH)) ) {
                alt9=9;
            }
            else if ( (LA9_0==RULE_DATA) ) {
                alt9=10;
            }
            else if ( (LA9_0==RULE_END) ) {
                alt9=11;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalPerl.g:768:2: ( ( rule__Token__Group_0__0 ) )
                    {
                    // InternalPerl.g:768:2: ( ( rule__Token__Group_0__0 ) )
                    // InternalPerl.g:769:3: ( rule__Token__Group_0__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_0()); 
                    // InternalPerl.g:770:3: ( rule__Token__Group_0__0 )
                    // InternalPerl.g:770:4: rule__Token__Group_0__0
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
                    // InternalPerl.g:774:2: ( ( rule__Token__Group_1__0 ) )
                    {
                    // InternalPerl.g:774:2: ( ( rule__Token__Group_1__0 ) )
                    // InternalPerl.g:775:3: ( rule__Token__Group_1__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_1()); 
                    // InternalPerl.g:776:3: ( rule__Token__Group_1__0 )
                    // InternalPerl.g:776:4: rule__Token__Group_1__0
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
                    // InternalPerl.g:780:2: ( ( rule__Token__Group_2__0 ) )
                    {
                    // InternalPerl.g:780:2: ( ( rule__Token__Group_2__0 ) )
                    // InternalPerl.g:781:3: ( rule__Token__Group_2__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_2()); 
                    // InternalPerl.g:782:3: ( rule__Token__Group_2__0 )
                    // InternalPerl.g:782:4: rule__Token__Group_2__0
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
                    // InternalPerl.g:786:2: ( ( rule__Token__Group_3__0 ) )
                    {
                    // InternalPerl.g:786:2: ( ( rule__Token__Group_3__0 ) )
                    // InternalPerl.g:787:3: ( rule__Token__Group_3__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_3()); 
                    // InternalPerl.g:788:3: ( rule__Token__Group_3__0 )
                    // InternalPerl.g:788:4: rule__Token__Group_3__0
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
                    // InternalPerl.g:792:2: ( ruleQuoteLikeToken )
                    {
                    // InternalPerl.g:792:2: ( ruleQuoteLikeToken )
                    // InternalPerl.g:793:3: ruleQuoteLikeToken
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
                    // InternalPerl.g:798:2: ( ( rule__Token__Group_5__0 ) )
                    {
                    // InternalPerl.g:798:2: ( ( rule__Token__Group_5__0 ) )
                    // InternalPerl.g:799:3: ( rule__Token__Group_5__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_5()); 
                    // InternalPerl.g:800:3: ( rule__Token__Group_5__0 )
                    // InternalPerl.g:800:4: rule__Token__Group_5__0
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
                    // InternalPerl.g:804:2: ( ( rule__Token__Group_6__0 ) )
                    {
                    // InternalPerl.g:804:2: ( ( rule__Token__Group_6__0 ) )
                    // InternalPerl.g:805:3: ( rule__Token__Group_6__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_6()); 
                    // InternalPerl.g:806:3: ( rule__Token__Group_6__0 )
                    // InternalPerl.g:806:4: rule__Token__Group_6__0
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
                    // InternalPerl.g:810:2: ( ruleQuoteToken )
                    {
                    // InternalPerl.g:810:2: ( ruleQuoteToken )
                    // InternalPerl.g:811:3: ruleQuoteToken
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
                    // InternalPerl.g:816:2: ( ruleRegexToken )
                    {
                    // InternalPerl.g:816:2: ( ruleRegexToken )
                    // InternalPerl.g:817:3: ruleRegexToken
                    {
                     before(grammarAccess.getTokenAccess().getRegexTokenParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    ruleRegexToken();

                    state._fsp--;

                     after(grammarAccess.getTokenAccess().getRegexTokenParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:822:2: ( ( rule__Token__Group_9__0 ) )
                    {
                    // InternalPerl.g:822:2: ( ( rule__Token__Group_9__0 ) )
                    // InternalPerl.g:823:3: ( rule__Token__Group_9__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_9()); 
                    // InternalPerl.g:824:3: ( rule__Token__Group_9__0 )
                    // InternalPerl.g:824:4: rule__Token__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:828:2: ( ( rule__Token__Group_10__0 ) )
                    {
                    // InternalPerl.g:828:2: ( ( rule__Token__Group_10__0 ) )
                    // InternalPerl.g:829:3: ( rule__Token__Group_10__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_10()); 
                    // InternalPerl.g:830:3: ( rule__Token__Group_10__0 )
                    // InternalPerl.g:830:4: rule__Token__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_10()); 

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


    // $ANTLR start "rule__RegexToken__ContentAlternatives_1_0"
    // InternalPerl.g:838:1: rule__RegexToken__ContentAlternatives_1_0 : ( ( RULE_REGEX_SUBSTITUTE ) | ( RULE_REGEX_TRANSLITERATE ) | ( RULE_REGEX_MATCH ) );
    public final void rule__RegexToken__ContentAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:842:1: ( ( RULE_REGEX_SUBSTITUTE ) | ( RULE_REGEX_TRANSLITERATE ) | ( RULE_REGEX_MATCH ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case RULE_REGEX_SUBSTITUTE:
                {
                alt10=1;
                }
                break;
            case RULE_REGEX_TRANSLITERATE:
                {
                alt10=2;
                }
                break;
            case RULE_REGEX_MATCH:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalPerl.g:843:2: ( RULE_REGEX_SUBSTITUTE )
                    {
                    // InternalPerl.g:843:2: ( RULE_REGEX_SUBSTITUTE )
                    // InternalPerl.g:844:3: RULE_REGEX_SUBSTITUTE
                    {
                     before(grammarAccess.getRegexTokenAccess().getContentREGEX_SUBSTITUTETerminalRuleCall_1_0_0()); 
                    match(input,RULE_REGEX_SUBSTITUTE,FOLLOW_2); 
                     after(grammarAccess.getRegexTokenAccess().getContentREGEX_SUBSTITUTETerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:849:2: ( RULE_REGEX_TRANSLITERATE )
                    {
                    // InternalPerl.g:849:2: ( RULE_REGEX_TRANSLITERATE )
                    // InternalPerl.g:850:3: RULE_REGEX_TRANSLITERATE
                    {
                     before(grammarAccess.getRegexTokenAccess().getContentREGEX_TRANSLITERATETerminalRuleCall_1_0_1()); 
                    match(input,RULE_REGEX_TRANSLITERATE,FOLLOW_2); 
                     after(grammarAccess.getRegexTokenAccess().getContentREGEX_TRANSLITERATETerminalRuleCall_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:855:2: ( RULE_REGEX_MATCH )
                    {
                    // InternalPerl.g:855:2: ( RULE_REGEX_MATCH )
                    // InternalPerl.g:856:3: RULE_REGEX_MATCH
                    {
                     before(grammarAccess.getRegexTokenAccess().getContentREGEX_MATCHTerminalRuleCall_1_0_2()); 
                    match(input,RULE_REGEX_MATCH,FOLLOW_2); 
                     after(grammarAccess.getRegexTokenAccess().getContentREGEX_MATCHTerminalRuleCall_1_0_2()); 

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
    // $ANTLR end "rule__RegexToken__ContentAlternatives_1_0"


    // $ANTLR start "rule__QuoteToken__ContentAlternatives_1_0"
    // InternalPerl.g:865:1: rule__QuoteToken__ContentAlternatives_1_0 : ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) );
    public final void rule__QuoteToken__ContentAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:869:1: ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt11=1;
                }
                break;
            case RULE_INTERPOLATE:
                {
                alt11=2;
                }
                break;
            case RULE_LITERAL:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalPerl.g:870:2: ( RULE_STRING )
                    {
                    // InternalPerl.g:870:2: ( RULE_STRING )
                    // InternalPerl.g:871:3: RULE_STRING
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:876:2: ( RULE_INTERPOLATE )
                    {
                    // InternalPerl.g:876:2: ( RULE_INTERPOLATE )
                    // InternalPerl.g:877:3: RULE_INTERPOLATE
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 
                    match(input,RULE_INTERPOLATE,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:882:2: ( RULE_LITERAL )
                    {
                    // InternalPerl.g:882:2: ( RULE_LITERAL )
                    // InternalPerl.g:883:3: RULE_LITERAL
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
    // InternalPerl.g:892:1: rule__QuoteLikeToken__Alternatives : ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) );
    public final void rule__QuoteLikeToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:896:1: ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) )
            int alt12=5;
            switch ( input.LA(1) ) {
            case RULE_BACKTICK_STRING:
                {
                alt12=1;
                }
                break;
            case RULE_WORDS_QUOTE_LIKE:
                {
                alt12=2;
                }
                break;
            case RULE_COMMAND_QUOTE_LIKE:
                {
                alt12=3;
                }
                break;
            case RULE_REGEX_QUOTE:
                {
                alt12=4;
                }
                break;
            case RULE_READLINE_QUOTE:
                {
                alt12=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalPerl.g:897:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    {
                    // InternalPerl.g:897:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    // InternalPerl.g:898:3: ( rule__QuoteLikeToken__Group_0__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_0()); 
                    // InternalPerl.g:899:3: ( rule__QuoteLikeToken__Group_0__0 )
                    // InternalPerl.g:899:4: rule__QuoteLikeToken__Group_0__0
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
                    // InternalPerl.g:903:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    {
                    // InternalPerl.g:903:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    // InternalPerl.g:904:3: ( rule__QuoteLikeToken__Group_1__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_1()); 
                    // InternalPerl.g:905:3: ( rule__QuoteLikeToken__Group_1__0 )
                    // InternalPerl.g:905:4: rule__QuoteLikeToken__Group_1__0
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
                    // InternalPerl.g:909:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    {
                    // InternalPerl.g:909:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    // InternalPerl.g:910:3: ( rule__QuoteLikeToken__Group_2__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_2()); 
                    // InternalPerl.g:911:3: ( rule__QuoteLikeToken__Group_2__0 )
                    // InternalPerl.g:911:4: rule__QuoteLikeToken__Group_2__0
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
                    // InternalPerl.g:915:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    {
                    // InternalPerl.g:915:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    // InternalPerl.g:916:3: ( rule__QuoteLikeToken__Group_3__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_3()); 
                    // InternalPerl.g:917:3: ( rule__QuoteLikeToken__Group_3__0 )
                    // InternalPerl.g:917:4: rule__QuoteLikeToken__Group_3__0
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
                    // InternalPerl.g:921:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    {
                    // InternalPerl.g:921:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    // InternalPerl.g:922:3: ( rule__QuoteLikeToken__Group_4__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_4()); 
                    // InternalPerl.g:923:3: ( rule__QuoteLikeToken__Group_4__0 )
                    // InternalPerl.g:923:4: rule__QuoteLikeToken__Group_4__0
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
    // InternalPerl.g:931:1: rule__Keyword__Alternatives : ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) );
    public final void rule__Keyword__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:935:1: ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) )
            int alt13=222;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt13=1;
                }
                break;
            case 34:
                {
                alt13=2;
                }
                break;
            case 35:
                {
                alt13=3;
                }
                break;
            case 36:
                {
                alt13=4;
                }
                break;
            case 37:
                {
                alt13=5;
                }
                break;
            case 38:
                {
                alt13=6;
                }
                break;
            case 39:
                {
                alt13=7;
                }
                break;
            case 40:
                {
                alt13=8;
                }
                break;
            case 41:
                {
                alt13=9;
                }
                break;
            case 42:
                {
                alt13=10;
                }
                break;
            case 43:
                {
                alt13=11;
                }
                break;
            case 44:
                {
                alt13=12;
                }
                break;
            case 45:
                {
                alt13=13;
                }
                break;
            case 46:
                {
                alt13=14;
                }
                break;
            case 47:
                {
                alt13=15;
                }
                break;
            case 48:
                {
                alt13=16;
                }
                break;
            case 49:
                {
                alt13=17;
                }
                break;
            case 50:
                {
                alt13=18;
                }
                break;
            case 51:
                {
                alt13=19;
                }
                break;
            case 52:
                {
                alt13=20;
                }
                break;
            case 53:
                {
                alt13=21;
                }
                break;
            case 54:
                {
                alt13=22;
                }
                break;
            case 55:
                {
                alt13=23;
                }
                break;
            case 56:
                {
                alt13=24;
                }
                break;
            case 57:
                {
                alt13=25;
                }
                break;
            case 58:
                {
                alt13=26;
                }
                break;
            case 59:
                {
                alt13=27;
                }
                break;
            case 60:
                {
                alt13=28;
                }
                break;
            case 61:
                {
                alt13=29;
                }
                break;
            case 62:
                {
                alt13=30;
                }
                break;
            case 63:
                {
                alt13=31;
                }
                break;
            case 64:
                {
                alt13=32;
                }
                break;
            case 65:
                {
                alt13=33;
                }
                break;
            case 66:
                {
                alt13=34;
                }
                break;
            case 67:
                {
                alt13=35;
                }
                break;
            case 68:
                {
                alt13=36;
                }
                break;
            case 69:
                {
                alt13=37;
                }
                break;
            case 70:
                {
                alt13=38;
                }
                break;
            case 71:
                {
                alt13=39;
                }
                break;
            case 72:
                {
                alt13=40;
                }
                break;
            case 73:
                {
                alt13=41;
                }
                break;
            case 74:
                {
                alt13=42;
                }
                break;
            case 75:
                {
                alt13=43;
                }
                break;
            case 76:
                {
                alt13=44;
                }
                break;
            case 77:
                {
                alt13=45;
                }
                break;
            case 78:
                {
                alt13=46;
                }
                break;
            case 79:
                {
                alt13=47;
                }
                break;
            case 80:
                {
                alt13=48;
                }
                break;
            case 81:
                {
                alt13=49;
                }
                break;
            case 82:
                {
                alt13=50;
                }
                break;
            case 83:
                {
                alt13=51;
                }
                break;
            case 84:
                {
                alt13=52;
                }
                break;
            case 85:
                {
                alt13=53;
                }
                break;
            case 86:
                {
                alt13=54;
                }
                break;
            case 87:
                {
                alt13=55;
                }
                break;
            case 88:
                {
                alt13=56;
                }
                break;
            case 89:
                {
                alt13=57;
                }
                break;
            case 90:
                {
                alt13=58;
                }
                break;
            case 91:
                {
                alt13=59;
                }
                break;
            case 92:
                {
                alt13=60;
                }
                break;
            case 93:
                {
                alt13=61;
                }
                break;
            case 94:
                {
                alt13=62;
                }
                break;
            case 95:
                {
                alt13=63;
                }
                break;
            case 96:
                {
                alt13=64;
                }
                break;
            case 97:
                {
                alt13=65;
                }
                break;
            case 98:
                {
                alt13=66;
                }
                break;
            case 99:
                {
                alt13=67;
                }
                break;
            case 100:
                {
                alt13=68;
                }
                break;
            case 101:
                {
                alt13=69;
                }
                break;
            case 102:
                {
                alt13=70;
                }
                break;
            case 103:
                {
                alt13=71;
                }
                break;
            case 104:
                {
                alt13=72;
                }
                break;
            case 105:
                {
                alt13=73;
                }
                break;
            case 106:
                {
                alt13=74;
                }
                break;
            case 107:
                {
                alt13=75;
                }
                break;
            case 108:
                {
                alt13=76;
                }
                break;
            case 109:
                {
                alt13=77;
                }
                break;
            case 110:
                {
                alt13=78;
                }
                break;
            case 111:
                {
                alt13=79;
                }
                break;
            case 112:
                {
                alt13=80;
                }
                break;
            case 113:
                {
                alt13=81;
                }
                break;
            case 114:
                {
                alt13=82;
                }
                break;
            case 115:
                {
                alt13=83;
                }
                break;
            case 116:
                {
                alt13=84;
                }
                break;
            case 117:
                {
                alt13=85;
                }
                break;
            case 118:
                {
                alt13=86;
                }
                break;
            case 119:
                {
                alt13=87;
                }
                break;
            case 120:
                {
                alt13=88;
                }
                break;
            case 121:
                {
                alt13=89;
                }
                break;
            case 122:
                {
                alt13=90;
                }
                break;
            case 123:
                {
                alt13=91;
                }
                break;
            case 124:
                {
                alt13=92;
                }
                break;
            case 125:
                {
                alt13=93;
                }
                break;
            case 126:
                {
                alt13=94;
                }
                break;
            case 127:
                {
                alt13=95;
                }
                break;
            case 128:
                {
                alt13=96;
                }
                break;
            case 129:
                {
                alt13=97;
                }
                break;
            case 130:
                {
                alt13=98;
                }
                break;
            case 131:
                {
                alt13=99;
                }
                break;
            case 132:
                {
                alt13=100;
                }
                break;
            case 133:
                {
                alt13=101;
                }
                break;
            case 134:
                {
                alt13=102;
                }
                break;
            case 135:
                {
                alt13=103;
                }
                break;
            case 136:
                {
                alt13=104;
                }
                break;
            case 137:
                {
                alt13=105;
                }
                break;
            case 138:
                {
                alt13=106;
                }
                break;
            case 139:
                {
                alt13=107;
                }
                break;
            case 140:
                {
                alt13=108;
                }
                break;
            case 141:
                {
                alt13=109;
                }
                break;
            case 142:
                {
                alt13=110;
                }
                break;
            case 143:
                {
                alt13=111;
                }
                break;
            case 144:
                {
                alt13=112;
                }
                break;
            case 145:
                {
                alt13=113;
                }
                break;
            case 146:
                {
                alt13=114;
                }
                break;
            case 147:
                {
                alt13=115;
                }
                break;
            case 148:
                {
                alt13=116;
                }
                break;
            case 149:
                {
                alt13=117;
                }
                break;
            case 150:
                {
                alt13=118;
                }
                break;
            case 151:
                {
                alt13=119;
                }
                break;
            case 152:
                {
                alt13=120;
                }
                break;
            case 153:
                {
                alt13=121;
                }
                break;
            case 154:
                {
                alt13=122;
                }
                break;
            case 155:
                {
                alt13=123;
                }
                break;
            case 156:
                {
                alt13=124;
                }
                break;
            case 157:
                {
                alt13=125;
                }
                break;
            case 158:
                {
                alt13=126;
                }
                break;
            case 159:
                {
                alt13=127;
                }
                break;
            case 160:
                {
                alt13=128;
                }
                break;
            case 161:
                {
                alt13=129;
                }
                break;
            case 162:
                {
                alt13=130;
                }
                break;
            case 163:
                {
                alt13=131;
                }
                break;
            case 164:
                {
                alt13=132;
                }
                break;
            case 165:
                {
                alt13=133;
                }
                break;
            case 166:
                {
                alt13=134;
                }
                break;
            case 167:
                {
                alt13=135;
                }
                break;
            case 168:
                {
                alt13=136;
                }
                break;
            case 169:
                {
                alt13=137;
                }
                break;
            case 170:
                {
                alt13=138;
                }
                break;
            case 171:
                {
                alt13=139;
                }
                break;
            case 172:
                {
                alt13=140;
                }
                break;
            case 173:
                {
                alt13=141;
                }
                break;
            case 174:
                {
                alt13=142;
                }
                break;
            case 175:
                {
                alt13=143;
                }
                break;
            case 176:
                {
                alt13=144;
                }
                break;
            case 177:
                {
                alt13=145;
                }
                break;
            case 178:
                {
                alt13=146;
                }
                break;
            case 179:
                {
                alt13=147;
                }
                break;
            case 180:
                {
                alt13=148;
                }
                break;
            case 181:
                {
                alt13=149;
                }
                break;
            case 182:
                {
                alt13=150;
                }
                break;
            case 183:
                {
                alt13=151;
                }
                break;
            case 184:
                {
                alt13=152;
                }
                break;
            case 185:
                {
                alt13=153;
                }
                break;
            case 186:
                {
                alt13=154;
                }
                break;
            case 187:
                {
                alt13=155;
                }
                break;
            case 188:
                {
                alt13=156;
                }
                break;
            case 189:
                {
                alt13=157;
                }
                break;
            case 190:
                {
                alt13=158;
                }
                break;
            case 191:
                {
                alt13=159;
                }
                break;
            case 192:
                {
                alt13=160;
                }
                break;
            case 193:
                {
                alt13=161;
                }
                break;
            case 194:
                {
                alt13=162;
                }
                break;
            case 195:
                {
                alt13=163;
                }
                break;
            case 196:
                {
                alt13=164;
                }
                break;
            case 197:
                {
                alt13=165;
                }
                break;
            case 198:
                {
                alt13=166;
                }
                break;
            case 199:
                {
                alt13=167;
                }
                break;
            case 200:
                {
                alt13=168;
                }
                break;
            case 201:
                {
                alt13=169;
                }
                break;
            case 202:
                {
                alt13=170;
                }
                break;
            case 203:
                {
                alt13=171;
                }
                break;
            case 204:
                {
                alt13=172;
                }
                break;
            case 205:
                {
                alt13=173;
                }
                break;
            case 206:
                {
                alt13=174;
                }
                break;
            case 207:
                {
                alt13=175;
                }
                break;
            case 208:
                {
                alt13=176;
                }
                break;
            case 209:
                {
                alt13=177;
                }
                break;
            case 210:
                {
                alt13=178;
                }
                break;
            case 211:
                {
                alt13=179;
                }
                break;
            case 212:
                {
                alt13=180;
                }
                break;
            case 213:
                {
                alt13=181;
                }
                break;
            case 214:
                {
                alt13=182;
                }
                break;
            case 215:
                {
                alt13=183;
                }
                break;
            case 216:
                {
                alt13=184;
                }
                break;
            case 217:
                {
                alt13=185;
                }
                break;
            case 218:
                {
                alt13=186;
                }
                break;
            case 219:
                {
                alt13=187;
                }
                break;
            case 220:
                {
                alt13=188;
                }
                break;
            case 221:
                {
                alt13=189;
                }
                break;
            case 222:
                {
                alt13=190;
                }
                break;
            case 223:
                {
                alt13=191;
                }
                break;
            case 224:
                {
                alt13=192;
                }
                break;
            case 225:
                {
                alt13=193;
                }
                break;
            case 226:
                {
                alt13=194;
                }
                break;
            case 227:
                {
                alt13=195;
                }
                break;
            case 228:
                {
                alt13=196;
                }
                break;
            case 229:
                {
                alt13=197;
                }
                break;
            case 230:
                {
                alt13=198;
                }
                break;
            case 231:
                {
                alt13=199;
                }
                break;
            case 232:
                {
                alt13=200;
                }
                break;
            case 233:
                {
                alt13=201;
                }
                break;
            case 234:
                {
                alt13=202;
                }
                break;
            case 235:
                {
                alt13=203;
                }
                break;
            case 236:
                {
                alt13=204;
                }
                break;
            case 237:
                {
                alt13=205;
                }
                break;
            case 238:
                {
                alt13=206;
                }
                break;
            case 239:
                {
                alt13=207;
                }
                break;
            case 240:
                {
                alt13=208;
                }
                break;
            case 241:
                {
                alt13=209;
                }
                break;
            case 242:
                {
                alt13=210;
                }
                break;
            case 243:
                {
                alt13=211;
                }
                break;
            case 244:
                {
                alt13=212;
                }
                break;
            case 245:
                {
                alt13=213;
                }
                break;
            case 246:
                {
                alt13=214;
                }
                break;
            case 247:
                {
                alt13=215;
                }
                break;
            case 248:
                {
                alt13=216;
                }
                break;
            case 249:
                {
                alt13=217;
                }
                break;
            case 250:
                {
                alt13=218;
                }
                break;
            case 251:
                {
                alt13=219;
                }
                break;
            case 252:
                {
                alt13=220;
                }
                break;
            case 253:
                {
                alt13=221;
                }
                break;
            case 254:
                {
                alt13=222;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalPerl.g:936:2: ( 'abs' )
                    {
                    // InternalPerl.g:936:2: ( 'abs' )
                    // InternalPerl.g:937:3: 'abs'
                    {
                     before(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:942:2: ( 'accept' )
                    {
                    // InternalPerl.g:942:2: ( 'accept' )
                    // InternalPerl.g:943:3: 'accept'
                    {
                     before(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:948:2: ( 'alarm' )
                    {
                    // InternalPerl.g:948:2: ( 'alarm' )
                    // InternalPerl.g:949:3: 'alarm'
                    {
                     before(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:954:2: ( 'atan2' )
                    {
                    // InternalPerl.g:954:2: ( 'atan2' )
                    // InternalPerl.g:955:3: 'atan2'
                    {
                     before(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:960:2: ( 'bind' )
                    {
                    // InternalPerl.g:960:2: ( 'bind' )
                    // InternalPerl.g:961:3: 'bind'
                    {
                     before(grammarAccess.getKeywordAccess().getBindKeyword_4()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBindKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:966:2: ( 'binmode' )
                    {
                    // InternalPerl.g:966:2: ( 'binmode' )
                    // InternalPerl.g:967:3: 'binmode'
                    {
                     before(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:972:2: ( 'bless' )
                    {
                    // InternalPerl.g:972:2: ( 'bless' )
                    // InternalPerl.g:973:3: 'bless'
                    {
                     before(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:978:2: ( 'break' )
                    {
                    // InternalPerl.g:978:2: ( 'break' )
                    // InternalPerl.g:979:3: 'break'
                    {
                     before(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:984:2: ( 'caller' )
                    {
                    // InternalPerl.g:984:2: ( 'caller' )
                    // InternalPerl.g:985:3: 'caller'
                    {
                     before(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:990:2: ( 'chdir' )
                    {
                    // InternalPerl.g:990:2: ( 'chdir' )
                    // InternalPerl.g:991:3: 'chdir'
                    {
                     before(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:996:2: ( 'chmod' )
                    {
                    // InternalPerl.g:996:2: ( 'chmod' )
                    // InternalPerl.g:997:3: 'chmod'
                    {
                     before(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:1002:2: ( 'chomp' )
                    {
                    // InternalPerl.g:1002:2: ( 'chomp' )
                    // InternalPerl.g:1003:3: 'chomp'
                    {
                     before(grammarAccess.getKeywordAccess().getChompKeyword_11()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChompKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:1008:2: ( 'chop' )
                    {
                    // InternalPerl.g:1008:2: ( 'chop' )
                    // InternalPerl.g:1009:3: 'chop'
                    {
                     before(grammarAccess.getKeywordAccess().getChopKeyword_12()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChopKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:1014:2: ( 'chown' )
                    {
                    // InternalPerl.g:1014:2: ( 'chown' )
                    // InternalPerl.g:1015:3: 'chown'
                    {
                     before(grammarAccess.getKeywordAccess().getChownKeyword_13()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChownKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:1020:2: ( 'chr' )
                    {
                    // InternalPerl.g:1020:2: ( 'chr' )
                    // InternalPerl.g:1021:3: 'chr'
                    {
                     before(grammarAccess.getKeywordAccess().getChrKeyword_14()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:1026:2: ( 'chroot' )
                    {
                    // InternalPerl.g:1026:2: ( 'chroot' )
                    // InternalPerl.g:1027:3: 'chroot'
                    {
                     before(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:1032:2: ( 'close' )
                    {
                    // InternalPerl.g:1032:2: ( 'close' )
                    // InternalPerl.g:1033:3: 'close'
                    {
                     before(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:1038:2: ( 'closedir' )
                    {
                    // InternalPerl.g:1038:2: ( 'closedir' )
                    // InternalPerl.g:1039:3: 'closedir'
                    {
                     before(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:1044:2: ( 'connect' )
                    {
                    // InternalPerl.g:1044:2: ( 'connect' )
                    // InternalPerl.g:1045:3: 'connect'
                    {
                     before(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:1050:2: ( 'continue' )
                    {
                    // InternalPerl.g:1050:2: ( 'continue' )
                    // InternalPerl.g:1051:3: 'continue'
                    {
                     before(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:1056:2: ( 'cos' )
                    {
                    // InternalPerl.g:1056:2: ( 'cos' )
                    // InternalPerl.g:1057:3: 'cos'
                    {
                     before(grammarAccess.getKeywordAccess().getCosKeyword_20()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCosKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:1062:2: ( 'crypt' )
                    {
                    // InternalPerl.g:1062:2: ( 'crypt' )
                    // InternalPerl.g:1063:3: 'crypt'
                    {
                     before(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:1068:2: ( 'dbmclose' )
                    {
                    // InternalPerl.g:1068:2: ( 'dbmclose' )
                    // InternalPerl.g:1069:3: 'dbmclose'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:1074:2: ( 'dbmopen' )
                    {
                    // InternalPerl.g:1074:2: ( 'dbmopen' )
                    // InternalPerl.g:1075:3: 'dbmopen'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:1080:2: ( 'default' )
                    {
                    // InternalPerl.g:1080:2: ( 'default' )
                    // InternalPerl.g:1081:3: 'default'
                    {
                     before(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:1086:2: ( 'defined' )
                    {
                    // InternalPerl.g:1086:2: ( 'defined' )
                    // InternalPerl.g:1087:3: 'defined'
                    {
                     before(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:1092:2: ( 'delete' )
                    {
                    // InternalPerl.g:1092:2: ( 'delete' )
                    // InternalPerl.g:1093:3: 'delete'
                    {
                     before(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:1098:2: ( 'die' )
                    {
                    // InternalPerl.g:1098:2: ( 'die' )
                    // InternalPerl.g:1099:3: 'die'
                    {
                     before(grammarAccess.getKeywordAccess().getDieKeyword_27()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDieKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:1104:2: ( 'do' )
                    {
                    // InternalPerl.g:1104:2: ( 'do' )
                    // InternalPerl.g:1105:3: 'do'
                    {
                     before(grammarAccess.getKeywordAccess().getDoKeyword_28()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDoKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:1110:2: ( 'dump' )
                    {
                    // InternalPerl.g:1110:2: ( 'dump' )
                    // InternalPerl.g:1111:3: 'dump'
                    {
                     before(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:1116:2: ( 'each' )
                    {
                    // InternalPerl.g:1116:2: ( 'each' )
                    // InternalPerl.g:1117:3: 'each'
                    {
                     before(grammarAccess.getKeywordAccess().getEachKeyword_30()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEachKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:1122:2: ( 'else' )
                    {
                    // InternalPerl.g:1122:2: ( 'else' )
                    // InternalPerl.g:1123:3: 'else'
                    {
                     before(grammarAccess.getKeywordAccess().getElseKeyword_31()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElseKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:1128:2: ( 'elsif' )
                    {
                    // InternalPerl.g:1128:2: ( 'elsif' )
                    // InternalPerl.g:1129:3: 'elsif'
                    {
                     before(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:1134:2: ( 'endgrent' )
                    {
                    // InternalPerl.g:1134:2: ( 'endgrent' )
                    // InternalPerl.g:1135:3: 'endgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:1140:2: ( 'endhostent' )
                    {
                    // InternalPerl.g:1140:2: ( 'endhostent' )
                    // InternalPerl.g:1141:3: 'endhostent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:1146:2: ( 'endnetent' )
                    {
                    // InternalPerl.g:1146:2: ( 'endnetent' )
                    // InternalPerl.g:1147:3: 'endnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:1152:2: ( 'endprotoent' )
                    {
                    // InternalPerl.g:1152:2: ( 'endprotoent' )
                    // InternalPerl.g:1153:3: 'endprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:1158:2: ( 'endpwent' )
                    {
                    // InternalPerl.g:1158:2: ( 'endpwent' )
                    // InternalPerl.g:1159:3: 'endpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:1164:2: ( 'endservent' )
                    {
                    // InternalPerl.g:1164:2: ( 'endservent' )
                    // InternalPerl.g:1165:3: 'endservent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:1170:2: ( 'eof' )
                    {
                    // InternalPerl.g:1170:2: ( 'eof' )
                    // InternalPerl.g:1171:3: 'eof'
                    {
                     before(grammarAccess.getKeywordAccess().getEofKeyword_39()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEofKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:1176:2: ( 'eval' )
                    {
                    // InternalPerl.g:1176:2: ( 'eval' )
                    // InternalPerl.g:1177:3: 'eval'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:1182:2: ( 'evalbytes' )
                    {
                    // InternalPerl.g:1182:2: ( 'evalbytes' )
                    // InternalPerl.g:1183:3: 'evalbytes'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:1188:2: ( 'exec' )
                    {
                    // InternalPerl.g:1188:2: ( 'exec' )
                    // InternalPerl.g:1189:3: 'exec'
                    {
                     before(grammarAccess.getKeywordAccess().getExecKeyword_42()); 
                    match(input,75,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExecKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:1194:2: ( 'exists' )
                    {
                    // InternalPerl.g:1194:2: ( 'exists' )
                    // InternalPerl.g:1195:3: 'exists'
                    {
                     before(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 
                    match(input,76,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:1200:2: ( 'exit' )
                    {
                    // InternalPerl.g:1200:2: ( 'exit' )
                    // InternalPerl.g:1201:3: 'exit'
                    {
                     before(grammarAccess.getKeywordAccess().getExitKeyword_44()); 
                    match(input,77,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExitKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:1206:2: ( 'exp' )
                    {
                    // InternalPerl.g:1206:2: ( 'exp' )
                    // InternalPerl.g:1207:3: 'exp'
                    {
                     before(grammarAccess.getKeywordAccess().getExpKeyword_45()); 
                    match(input,78,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExpKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:1212:2: ( 'fc' )
                    {
                    // InternalPerl.g:1212:2: ( 'fc' )
                    // InternalPerl.g:1213:3: 'fc'
                    {
                     before(grammarAccess.getKeywordAccess().getFcKeyword_46()); 
                    match(input,79,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:1218:2: ( 'fcntl' )
                    {
                    // InternalPerl.g:1218:2: ( 'fcntl' )
                    // InternalPerl.g:1219:3: 'fcntl'
                    {
                     before(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 
                    match(input,80,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:1224:2: ( 'fileno' )
                    {
                    // InternalPerl.g:1224:2: ( 'fileno' )
                    // InternalPerl.g:1225:3: 'fileno'
                    {
                     before(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 
                    match(input,81,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:1230:2: ( 'flock' )
                    {
                    // InternalPerl.g:1230:2: ( 'flock' )
                    // InternalPerl.g:1231:3: 'flock'
                    {
                     before(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 
                    match(input,82,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:1236:2: ( 'for' )
                    {
                    // InternalPerl.g:1236:2: ( 'for' )
                    // InternalPerl.g:1237:3: 'for'
                    {
                     before(grammarAccess.getKeywordAccess().getForKeyword_50()); 
                    match(input,83,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:1242:2: ( 'foreach' )
                    {
                    // InternalPerl.g:1242:2: ( 'foreach' )
                    // InternalPerl.g:1243:3: 'foreach'
                    {
                     before(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 
                    match(input,84,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:1248:2: ( 'fork' )
                    {
                    // InternalPerl.g:1248:2: ( 'fork' )
                    // InternalPerl.g:1249:3: 'fork'
                    {
                     before(grammarAccess.getKeywordAccess().getForkKeyword_52()); 
                    match(input,85,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForkKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:1254:2: ( 'format' )
                    {
                    // InternalPerl.g:1254:2: ( 'format' )
                    // InternalPerl.g:1255:3: 'format'
                    {
                     before(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 
                    match(input,86,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:1260:2: ( 'formline' )
                    {
                    // InternalPerl.g:1260:2: ( 'formline' )
                    // InternalPerl.g:1261:3: 'formline'
                    {
                     before(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 
                    match(input,87,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:1266:2: ( 'getc' )
                    {
                    // InternalPerl.g:1266:2: ( 'getc' )
                    // InternalPerl.g:1267:3: 'getc'
                    {
                     before(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 
                    match(input,88,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:1272:2: ( 'getgrent' )
                    {
                    // InternalPerl.g:1272:2: ( 'getgrent' )
                    // InternalPerl.g:1273:3: 'getgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 
                    match(input,89,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:1278:2: ( 'getgrgid' )
                    {
                    // InternalPerl.g:1278:2: ( 'getgrgid' )
                    // InternalPerl.g:1279:3: 'getgrgid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 
                    match(input,90,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:1284:2: ( 'getgrnam' )
                    {
                    // InternalPerl.g:1284:2: ( 'getgrnam' )
                    // InternalPerl.g:1285:3: 'getgrnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 
                    match(input,91,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:1290:2: ( 'gethostbyaddr' )
                    {
                    // InternalPerl.g:1290:2: ( 'gethostbyaddr' )
                    // InternalPerl.g:1291:3: 'gethostbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 
                    match(input,92,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:1296:2: ( 'gethostbyname' )
                    {
                    // InternalPerl.g:1296:2: ( 'gethostbyname' )
                    // InternalPerl.g:1297:3: 'gethostbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 
                    match(input,93,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:1302:2: ( 'gethostent' )
                    {
                    // InternalPerl.g:1302:2: ( 'gethostent' )
                    // InternalPerl.g:1303:3: 'gethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 
                    match(input,94,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:1308:2: ( 'getlogin' )
                    {
                    // InternalPerl.g:1308:2: ( 'getlogin' )
                    // InternalPerl.g:1309:3: 'getlogin'
                    {
                     before(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 
                    match(input,95,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:1314:2: ( 'getnetbyaddr' )
                    {
                    // InternalPerl.g:1314:2: ( 'getnetbyaddr' )
                    // InternalPerl.g:1315:3: 'getnetbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 
                    match(input,96,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 

                    }


                    }
                    break;
                case 65 :
                    // InternalPerl.g:1320:2: ( 'getnetbyname' )
                    {
                    // InternalPerl.g:1320:2: ( 'getnetbyname' )
                    // InternalPerl.g:1321:3: 'getnetbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 
                    match(input,97,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 

                    }


                    }
                    break;
                case 66 :
                    // InternalPerl.g:1326:2: ( 'getnetent' )
                    {
                    // InternalPerl.g:1326:2: ( 'getnetent' )
                    // InternalPerl.g:1327:3: 'getnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 
                    match(input,98,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 

                    }


                    }
                    break;
                case 67 :
                    // InternalPerl.g:1332:2: ( 'getpeername' )
                    {
                    // InternalPerl.g:1332:2: ( 'getpeername' )
                    // InternalPerl.g:1333:3: 'getpeername'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 
                    match(input,99,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 

                    }


                    }
                    break;
                case 68 :
                    // InternalPerl.g:1338:2: ( 'getpgrp' )
                    {
                    // InternalPerl.g:1338:2: ( 'getpgrp' )
                    // InternalPerl.g:1339:3: 'getpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 
                    match(input,100,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 

                    }


                    }
                    break;
                case 69 :
                    // InternalPerl.g:1344:2: ( 'getppid' )
                    {
                    // InternalPerl.g:1344:2: ( 'getppid' )
                    // InternalPerl.g:1345:3: 'getppid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 
                    match(input,101,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 

                    }


                    }
                    break;
                case 70 :
                    // InternalPerl.g:1350:2: ( 'getpriority' )
                    {
                    // InternalPerl.g:1350:2: ( 'getpriority' )
                    // InternalPerl.g:1351:3: 'getpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 
                    match(input,102,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 

                    }


                    }
                    break;
                case 71 :
                    // InternalPerl.g:1356:2: ( 'getprotobyname' )
                    {
                    // InternalPerl.g:1356:2: ( 'getprotobyname' )
                    // InternalPerl.g:1357:3: 'getprotobyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 
                    match(input,103,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 

                    }


                    }
                    break;
                case 72 :
                    // InternalPerl.g:1362:2: ( 'getprotobynumber' )
                    {
                    // InternalPerl.g:1362:2: ( 'getprotobynumber' )
                    // InternalPerl.g:1363:3: 'getprotobynumber'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 
                    match(input,104,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 

                    }


                    }
                    break;
                case 73 :
                    // InternalPerl.g:1368:2: ( 'getprotoent' )
                    {
                    // InternalPerl.g:1368:2: ( 'getprotoent' )
                    // InternalPerl.g:1369:3: 'getprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 
                    match(input,105,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 

                    }


                    }
                    break;
                case 74 :
                    // InternalPerl.g:1374:2: ( 'getpwent' )
                    {
                    // InternalPerl.g:1374:2: ( 'getpwent' )
                    // InternalPerl.g:1375:3: 'getpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 
                    match(input,106,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 

                    }


                    }
                    break;
                case 75 :
                    // InternalPerl.g:1380:2: ( 'getpwnam' )
                    {
                    // InternalPerl.g:1380:2: ( 'getpwnam' )
                    // InternalPerl.g:1381:3: 'getpwnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 
                    match(input,107,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 

                    }


                    }
                    break;
                case 76 :
                    // InternalPerl.g:1386:2: ( 'getpwuid' )
                    {
                    // InternalPerl.g:1386:2: ( 'getpwuid' )
                    // InternalPerl.g:1387:3: 'getpwuid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 
                    match(input,108,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 

                    }


                    }
                    break;
                case 77 :
                    // InternalPerl.g:1392:2: ( 'getservbyname' )
                    {
                    // InternalPerl.g:1392:2: ( 'getservbyname' )
                    // InternalPerl.g:1393:3: 'getservbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 
                    match(input,109,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 

                    }


                    }
                    break;
                case 78 :
                    // InternalPerl.g:1398:2: ( 'getservbyport' )
                    {
                    // InternalPerl.g:1398:2: ( 'getservbyport' )
                    // InternalPerl.g:1399:3: 'getservbyport'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 
                    match(input,110,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 

                    }


                    }
                    break;
                case 79 :
                    // InternalPerl.g:1404:2: ( 'getservent' )
                    {
                    // InternalPerl.g:1404:2: ( 'getservent' )
                    // InternalPerl.g:1405:3: 'getservent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 
                    match(input,111,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 

                    }


                    }
                    break;
                case 80 :
                    // InternalPerl.g:1410:2: ( 'getsockname' )
                    {
                    // InternalPerl.g:1410:2: ( 'getsockname' )
                    // InternalPerl.g:1411:3: 'getsockname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 
                    match(input,112,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 

                    }


                    }
                    break;
                case 81 :
                    // InternalPerl.g:1416:2: ( 'getsockopt' )
                    {
                    // InternalPerl.g:1416:2: ( 'getsockopt' )
                    // InternalPerl.g:1417:3: 'getsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 
                    match(input,113,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 

                    }


                    }
                    break;
                case 82 :
                    // InternalPerl.g:1422:2: ( 'given' )
                    {
                    // InternalPerl.g:1422:2: ( 'given' )
                    // InternalPerl.g:1423:3: 'given'
                    {
                     before(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 
                    match(input,114,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 

                    }


                    }
                    break;
                case 83 :
                    // InternalPerl.g:1428:2: ( 'glob' )
                    {
                    // InternalPerl.g:1428:2: ( 'glob' )
                    // InternalPerl.g:1429:3: 'glob'
                    {
                     before(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 
                    match(input,115,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 

                    }


                    }
                    break;
                case 84 :
                    // InternalPerl.g:1434:2: ( 'gmtime' )
                    {
                    // InternalPerl.g:1434:2: ( 'gmtime' )
                    // InternalPerl.g:1435:3: 'gmtime'
                    {
                     before(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 
                    match(input,116,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 

                    }


                    }
                    break;
                case 85 :
                    // InternalPerl.g:1440:2: ( 'goto' )
                    {
                    // InternalPerl.g:1440:2: ( 'goto' )
                    // InternalPerl.g:1441:3: 'goto'
                    {
                     before(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 
                    match(input,117,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 

                    }


                    }
                    break;
                case 86 :
                    // InternalPerl.g:1446:2: ( 'grep' )
                    {
                    // InternalPerl.g:1446:2: ( 'grep' )
                    // InternalPerl.g:1447:3: 'grep'
                    {
                     before(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 
                    match(input,118,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 

                    }


                    }
                    break;
                case 87 :
                    // InternalPerl.g:1452:2: ( 'hex' )
                    {
                    // InternalPerl.g:1452:2: ( 'hex' )
                    // InternalPerl.g:1453:3: 'hex'
                    {
                     before(grammarAccess.getKeywordAccess().getHexKeyword_86()); 
                    match(input,119,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getHexKeyword_86()); 

                    }


                    }
                    break;
                case 88 :
                    // InternalPerl.g:1458:2: ( 'if' )
                    {
                    // InternalPerl.g:1458:2: ( 'if' )
                    // InternalPerl.g:1459:3: 'if'
                    {
                     before(grammarAccess.getKeywordAccess().getIfKeyword_87()); 
                    match(input,120,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIfKeyword_87()); 

                    }


                    }
                    break;
                case 89 :
                    // InternalPerl.g:1464:2: ( 'index' )
                    {
                    // InternalPerl.g:1464:2: ( 'index' )
                    // InternalPerl.g:1465:3: 'index'
                    {
                     before(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 
                    match(input,121,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 

                    }


                    }
                    break;
                case 90 :
                    // InternalPerl.g:1470:2: ( 'int' )
                    {
                    // InternalPerl.g:1470:2: ( 'int' )
                    // InternalPerl.g:1471:3: 'int'
                    {
                     before(grammarAccess.getKeywordAccess().getIntKeyword_89()); 
                    match(input,122,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIntKeyword_89()); 

                    }


                    }
                    break;
                case 91 :
                    // InternalPerl.g:1476:2: ( 'ioctl' )
                    {
                    // InternalPerl.g:1476:2: ( 'ioctl' )
                    // InternalPerl.g:1477:3: 'ioctl'
                    {
                     before(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 
                    match(input,123,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 

                    }


                    }
                    break;
                case 92 :
                    // InternalPerl.g:1482:2: ( 'join' )
                    {
                    // InternalPerl.g:1482:2: ( 'join' )
                    // InternalPerl.g:1483:3: 'join'
                    {
                     before(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 
                    match(input,124,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 

                    }


                    }
                    break;
                case 93 :
                    // InternalPerl.g:1488:2: ( 'keys' )
                    {
                    // InternalPerl.g:1488:2: ( 'keys' )
                    // InternalPerl.g:1489:3: 'keys'
                    {
                     before(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 
                    match(input,125,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 

                    }


                    }
                    break;
                case 94 :
                    // InternalPerl.g:1494:2: ( 'kill' )
                    {
                    // InternalPerl.g:1494:2: ( 'kill' )
                    // InternalPerl.g:1495:3: 'kill'
                    {
                     before(grammarAccess.getKeywordAccess().getKillKeyword_93()); 
                    match(input,126,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKillKeyword_93()); 

                    }


                    }
                    break;
                case 95 :
                    // InternalPerl.g:1500:2: ( 'last' )
                    {
                    // InternalPerl.g:1500:2: ( 'last' )
                    // InternalPerl.g:1501:3: 'last'
                    {
                     before(grammarAccess.getKeywordAccess().getLastKeyword_94()); 
                    match(input,127,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLastKeyword_94()); 

                    }


                    }
                    break;
                case 96 :
                    // InternalPerl.g:1506:2: ( 'lc' )
                    {
                    // InternalPerl.g:1506:2: ( 'lc' )
                    // InternalPerl.g:1507:3: 'lc'
                    {
                     before(grammarAccess.getKeywordAccess().getLcKeyword_95()); 
                    match(input,128,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcKeyword_95()); 

                    }


                    }
                    break;
                case 97 :
                    // InternalPerl.g:1512:2: ( 'lcfirst' )
                    {
                    // InternalPerl.g:1512:2: ( 'lcfirst' )
                    // InternalPerl.g:1513:3: 'lcfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 
                    match(input,129,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 

                    }


                    }
                    break;
                case 98 :
                    // InternalPerl.g:1518:2: ( 'length' )
                    {
                    // InternalPerl.g:1518:2: ( 'length' )
                    // InternalPerl.g:1519:3: 'length'
                    {
                     before(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 
                    match(input,130,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 

                    }


                    }
                    break;
                case 99 :
                    // InternalPerl.g:1524:2: ( 'link' )
                    {
                    // InternalPerl.g:1524:2: ( 'link' )
                    // InternalPerl.g:1525:3: 'link'
                    {
                     before(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 
                    match(input,131,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 

                    }


                    }
                    break;
                case 100 :
                    // InternalPerl.g:1530:2: ( 'listen' )
                    {
                    // InternalPerl.g:1530:2: ( 'listen' )
                    // InternalPerl.g:1531:3: 'listen'
                    {
                     before(grammarAccess.getKeywordAccess().getListenKeyword_99()); 
                    match(input,132,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getListenKeyword_99()); 

                    }


                    }
                    break;
                case 101 :
                    // InternalPerl.g:1536:2: ( 'local' )
                    {
                    // InternalPerl.g:1536:2: ( 'local' )
                    // InternalPerl.g:1537:3: 'local'
                    {
                     before(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 
                    match(input,133,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 

                    }


                    }
                    break;
                case 102 :
                    // InternalPerl.g:1542:2: ( 'localtime' )
                    {
                    // InternalPerl.g:1542:2: ( 'localtime' )
                    // InternalPerl.g:1543:3: 'localtime'
                    {
                     before(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 
                    match(input,134,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 

                    }


                    }
                    break;
                case 103 :
                    // InternalPerl.g:1548:2: ( 'lock' )
                    {
                    // InternalPerl.g:1548:2: ( 'lock' )
                    // InternalPerl.g:1549:3: 'lock'
                    {
                     before(grammarAccess.getKeywordAccess().getLockKeyword_102()); 
                    match(input,135,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLockKeyword_102()); 

                    }


                    }
                    break;
                case 104 :
                    // InternalPerl.g:1554:2: ( 'log' )
                    {
                    // InternalPerl.g:1554:2: ( 'log' )
                    // InternalPerl.g:1555:3: 'log'
                    {
                     before(grammarAccess.getKeywordAccess().getLogKeyword_103()); 
                    match(input,136,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLogKeyword_103()); 

                    }


                    }
                    break;
                case 105 :
                    // InternalPerl.g:1560:2: ( 'lstat' )
                    {
                    // InternalPerl.g:1560:2: ( 'lstat' )
                    // InternalPerl.g:1561:3: 'lstat'
                    {
                     before(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 
                    match(input,137,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 

                    }


                    }
                    break;
                case 106 :
                    // InternalPerl.g:1566:2: ( 'map' )
                    {
                    // InternalPerl.g:1566:2: ( 'map' )
                    // InternalPerl.g:1567:3: 'map'
                    {
                     before(grammarAccess.getKeywordAccess().getMapKeyword_105()); 
                    match(input,138,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMapKeyword_105()); 

                    }


                    }
                    break;
                case 107 :
                    // InternalPerl.g:1572:2: ( 'mkdir' )
                    {
                    // InternalPerl.g:1572:2: ( 'mkdir' )
                    // InternalPerl.g:1573:3: 'mkdir'
                    {
                     before(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 
                    match(input,139,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 

                    }


                    }
                    break;
                case 108 :
                    // InternalPerl.g:1578:2: ( 'msgctl' )
                    {
                    // InternalPerl.g:1578:2: ( 'msgctl' )
                    // InternalPerl.g:1579:3: 'msgctl'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 
                    match(input,140,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 

                    }


                    }
                    break;
                case 109 :
                    // InternalPerl.g:1584:2: ( 'msgget' )
                    {
                    // InternalPerl.g:1584:2: ( 'msgget' )
                    // InternalPerl.g:1585:3: 'msgget'
                    {
                     before(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 
                    match(input,141,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 

                    }


                    }
                    break;
                case 110 :
                    // InternalPerl.g:1590:2: ( 'msgrcv' )
                    {
                    // InternalPerl.g:1590:2: ( 'msgrcv' )
                    // InternalPerl.g:1591:3: 'msgrcv'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 
                    match(input,142,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 

                    }


                    }
                    break;
                case 111 :
                    // InternalPerl.g:1596:2: ( 'msgsnd' )
                    {
                    // InternalPerl.g:1596:2: ( 'msgsnd' )
                    // InternalPerl.g:1597:3: 'msgsnd'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 
                    match(input,143,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 

                    }


                    }
                    break;
                case 112 :
                    // InternalPerl.g:1602:2: ( 'my' )
                    {
                    // InternalPerl.g:1602:2: ( 'my' )
                    // InternalPerl.g:1603:3: 'my'
                    {
                     before(grammarAccess.getKeywordAccess().getMyKeyword_111()); 
                    match(input,144,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMyKeyword_111()); 

                    }


                    }
                    break;
                case 113 :
                    // InternalPerl.g:1608:2: ( 'next' )
                    {
                    // InternalPerl.g:1608:2: ( 'next' )
                    // InternalPerl.g:1609:3: 'next'
                    {
                     before(grammarAccess.getKeywordAccess().getNextKeyword_112()); 
                    match(input,145,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNextKeyword_112()); 

                    }


                    }
                    break;
                case 114 :
                    // InternalPerl.g:1614:2: ( 'no' )
                    {
                    // InternalPerl.g:1614:2: ( 'no' )
                    // InternalPerl.g:1615:3: 'no'
                    {
                     before(grammarAccess.getKeywordAccess().getNoKeyword_113()); 
                    match(input,146,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNoKeyword_113()); 

                    }


                    }
                    break;
                case 115 :
                    // InternalPerl.g:1620:2: ( 'oct' )
                    {
                    // InternalPerl.g:1620:2: ( 'oct' )
                    // InternalPerl.g:1621:3: 'oct'
                    {
                     before(grammarAccess.getKeywordAccess().getOctKeyword_114()); 
                    match(input,147,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOctKeyword_114()); 

                    }


                    }
                    break;
                case 116 :
                    // InternalPerl.g:1626:2: ( 'open' )
                    {
                    // InternalPerl.g:1626:2: ( 'open' )
                    // InternalPerl.g:1627:3: 'open'
                    {
                     before(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 
                    match(input,148,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 

                    }


                    }
                    break;
                case 117 :
                    // InternalPerl.g:1632:2: ( 'opendir' )
                    {
                    // InternalPerl.g:1632:2: ( 'opendir' )
                    // InternalPerl.g:1633:3: 'opendir'
                    {
                     before(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 
                    match(input,149,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 

                    }


                    }
                    break;
                case 118 :
                    // InternalPerl.g:1638:2: ( 'ord' )
                    {
                    // InternalPerl.g:1638:2: ( 'ord' )
                    // InternalPerl.g:1639:3: 'ord'
                    {
                     before(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 
                    match(input,150,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 

                    }


                    }
                    break;
                case 119 :
                    // InternalPerl.g:1644:2: ( 'our' )
                    {
                    // InternalPerl.g:1644:2: ( 'our' )
                    // InternalPerl.g:1645:3: 'our'
                    {
                     before(grammarAccess.getKeywordAccess().getOurKeyword_118()); 
                    match(input,151,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOurKeyword_118()); 

                    }


                    }
                    break;
                case 120 :
                    // InternalPerl.g:1650:2: ( 'pack' )
                    {
                    // InternalPerl.g:1650:2: ( 'pack' )
                    // InternalPerl.g:1651:3: 'pack'
                    {
                     before(grammarAccess.getKeywordAccess().getPackKeyword_119()); 
                    match(input,152,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackKeyword_119()); 

                    }


                    }
                    break;
                case 121 :
                    // InternalPerl.g:1656:2: ( 'package' )
                    {
                    // InternalPerl.g:1656:2: ( 'package' )
                    // InternalPerl.g:1657:3: 'package'
                    {
                     before(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 
                    match(input,153,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 

                    }


                    }
                    break;
                case 122 :
                    // InternalPerl.g:1662:2: ( 'pipe' )
                    {
                    // InternalPerl.g:1662:2: ( 'pipe' )
                    // InternalPerl.g:1663:3: 'pipe'
                    {
                     before(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 
                    match(input,154,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 

                    }


                    }
                    break;
                case 123 :
                    // InternalPerl.g:1668:2: ( 'pop' )
                    {
                    // InternalPerl.g:1668:2: ( 'pop' )
                    // InternalPerl.g:1669:3: 'pop'
                    {
                     before(grammarAccess.getKeywordAccess().getPopKeyword_122()); 
                    match(input,155,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPopKeyword_122()); 

                    }


                    }
                    break;
                case 124 :
                    // InternalPerl.g:1674:2: ( 'pos' )
                    {
                    // InternalPerl.g:1674:2: ( 'pos' )
                    // InternalPerl.g:1675:3: 'pos'
                    {
                     before(grammarAccess.getKeywordAccess().getPosKeyword_123()); 
                    match(input,156,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPosKeyword_123()); 

                    }


                    }
                    break;
                case 125 :
                    // InternalPerl.g:1680:2: ( 'print' )
                    {
                    // InternalPerl.g:1680:2: ( 'print' )
                    // InternalPerl.g:1681:3: 'print'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 
                    match(input,157,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 

                    }


                    }
                    break;
                case 126 :
                    // InternalPerl.g:1686:2: ( 'printf' )
                    {
                    // InternalPerl.g:1686:2: ( 'printf' )
                    // InternalPerl.g:1687:3: 'printf'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 
                    match(input,158,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 

                    }


                    }
                    break;
                case 127 :
                    // InternalPerl.g:1692:2: ( 'prototype' )
                    {
                    // InternalPerl.g:1692:2: ( 'prototype' )
                    // InternalPerl.g:1693:3: 'prototype'
                    {
                     before(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 
                    match(input,159,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 

                    }


                    }
                    break;
                case 128 :
                    // InternalPerl.g:1698:2: ( 'push' )
                    {
                    // InternalPerl.g:1698:2: ( 'push' )
                    // InternalPerl.g:1699:3: 'push'
                    {
                     before(grammarAccess.getKeywordAccess().getPushKeyword_127()); 
                    match(input,160,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPushKeyword_127()); 

                    }


                    }
                    break;
                case 129 :
                    // InternalPerl.g:1704:2: ( 'quotemeta' )
                    {
                    // InternalPerl.g:1704:2: ( 'quotemeta' )
                    // InternalPerl.g:1705:3: 'quotemeta'
                    {
                     before(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 
                    match(input,161,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 

                    }


                    }
                    break;
                case 130 :
                    // InternalPerl.g:1710:2: ( 'rand' )
                    {
                    // InternalPerl.g:1710:2: ( 'rand' )
                    // InternalPerl.g:1711:3: 'rand'
                    {
                     before(grammarAccess.getKeywordAccess().getRandKeyword_129()); 
                    match(input,162,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRandKeyword_129()); 

                    }


                    }
                    break;
                case 131 :
                    // InternalPerl.g:1716:2: ( 'read' )
                    {
                    // InternalPerl.g:1716:2: ( 'read' )
                    // InternalPerl.g:1717:3: 'read'
                    {
                     before(grammarAccess.getKeywordAccess().getReadKeyword_130()); 
                    match(input,163,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadKeyword_130()); 

                    }


                    }
                    break;
                case 132 :
                    // InternalPerl.g:1722:2: ( 'readdir' )
                    {
                    // InternalPerl.g:1722:2: ( 'readdir' )
                    // InternalPerl.g:1723:3: 'readdir'
                    {
                     before(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 
                    match(input,164,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 

                    }


                    }
                    break;
                case 133 :
                    // InternalPerl.g:1728:2: ( 'readline' )
                    {
                    // InternalPerl.g:1728:2: ( 'readline' )
                    // InternalPerl.g:1729:3: 'readline'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 
                    match(input,165,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 

                    }


                    }
                    break;
                case 134 :
                    // InternalPerl.g:1734:2: ( 'readlink' )
                    {
                    // InternalPerl.g:1734:2: ( 'readlink' )
                    // InternalPerl.g:1735:3: 'readlink'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 
                    match(input,166,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 

                    }


                    }
                    break;
                case 135 :
                    // InternalPerl.g:1740:2: ( 'readpipe' )
                    {
                    // InternalPerl.g:1740:2: ( 'readpipe' )
                    // InternalPerl.g:1741:3: 'readpipe'
                    {
                     before(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 
                    match(input,167,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 

                    }


                    }
                    break;
                case 136 :
                    // InternalPerl.g:1746:2: ( 'recv' )
                    {
                    // InternalPerl.g:1746:2: ( 'recv' )
                    // InternalPerl.g:1747:3: 'recv'
                    {
                     before(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 
                    match(input,168,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 

                    }


                    }
                    break;
                case 137 :
                    // InternalPerl.g:1752:2: ( 'redo' )
                    {
                    // InternalPerl.g:1752:2: ( 'redo' )
                    // InternalPerl.g:1753:3: 'redo'
                    {
                     before(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 
                    match(input,169,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 

                    }


                    }
                    break;
                case 138 :
                    // InternalPerl.g:1758:2: ( 'ref' )
                    {
                    // InternalPerl.g:1758:2: ( 'ref' )
                    // InternalPerl.g:1759:3: 'ref'
                    {
                     before(grammarAccess.getKeywordAccess().getRefKeyword_137()); 
                    match(input,170,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRefKeyword_137()); 

                    }


                    }
                    break;
                case 139 :
                    // InternalPerl.g:1764:2: ( 'rename' )
                    {
                    // InternalPerl.g:1764:2: ( 'rename' )
                    // InternalPerl.g:1765:3: 'rename'
                    {
                     before(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 
                    match(input,171,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 

                    }


                    }
                    break;
                case 140 :
                    // InternalPerl.g:1770:2: ( 'require' )
                    {
                    // InternalPerl.g:1770:2: ( 'require' )
                    // InternalPerl.g:1771:3: 'require'
                    {
                     before(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 
                    match(input,172,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 

                    }


                    }
                    break;
                case 141 :
                    // InternalPerl.g:1776:2: ( 'reset' )
                    {
                    // InternalPerl.g:1776:2: ( 'reset' )
                    // InternalPerl.g:1777:3: 'reset'
                    {
                     before(grammarAccess.getKeywordAccess().getResetKeyword_140()); 
                    match(input,173,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getResetKeyword_140()); 

                    }


                    }
                    break;
                case 142 :
                    // InternalPerl.g:1782:2: ( 'return' )
                    {
                    // InternalPerl.g:1782:2: ( 'return' )
                    // InternalPerl.g:1783:3: 'return'
                    {
                     before(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 
                    match(input,174,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 

                    }


                    }
                    break;
                case 143 :
                    // InternalPerl.g:1788:2: ( 'reverse' )
                    {
                    // InternalPerl.g:1788:2: ( 'reverse' )
                    // InternalPerl.g:1789:3: 'reverse'
                    {
                     before(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 
                    match(input,175,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 

                    }


                    }
                    break;
                case 144 :
                    // InternalPerl.g:1794:2: ( 'rewinddir' )
                    {
                    // InternalPerl.g:1794:2: ( 'rewinddir' )
                    // InternalPerl.g:1795:3: 'rewinddir'
                    {
                     before(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 
                    match(input,176,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 

                    }


                    }
                    break;
                case 145 :
                    // InternalPerl.g:1800:2: ( 'rindex' )
                    {
                    // InternalPerl.g:1800:2: ( 'rindex' )
                    // InternalPerl.g:1801:3: 'rindex'
                    {
                     before(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 
                    match(input,177,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 

                    }


                    }
                    break;
                case 146 :
                    // InternalPerl.g:1806:2: ( 'rmdir' )
                    {
                    // InternalPerl.g:1806:2: ( 'rmdir' )
                    // InternalPerl.g:1807:3: 'rmdir'
                    {
                     before(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 
                    match(input,178,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 

                    }


                    }
                    break;
                case 147 :
                    // InternalPerl.g:1812:2: ( 'say' )
                    {
                    // InternalPerl.g:1812:2: ( 'say' )
                    // InternalPerl.g:1813:3: 'say'
                    {
                     before(grammarAccess.getKeywordAccess().getSayKeyword_146()); 
                    match(input,179,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSayKeyword_146()); 

                    }


                    }
                    break;
                case 148 :
                    // InternalPerl.g:1818:2: ( 'scalar' )
                    {
                    // InternalPerl.g:1818:2: ( 'scalar' )
                    // InternalPerl.g:1819:3: 'scalar'
                    {
                     before(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 
                    match(input,180,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 

                    }


                    }
                    break;
                case 149 :
                    // InternalPerl.g:1824:2: ( 'seek' )
                    {
                    // InternalPerl.g:1824:2: ( 'seek' )
                    // InternalPerl.g:1825:3: 'seek'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 
                    match(input,181,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 

                    }


                    }
                    break;
                case 150 :
                    // InternalPerl.g:1830:2: ( 'seekdir' )
                    {
                    // InternalPerl.g:1830:2: ( 'seekdir' )
                    // InternalPerl.g:1831:3: 'seekdir'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 
                    match(input,182,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 

                    }


                    }
                    break;
                case 151 :
                    // InternalPerl.g:1836:2: ( 'select' )
                    {
                    // InternalPerl.g:1836:2: ( 'select' )
                    // InternalPerl.g:1837:3: 'select'
                    {
                     before(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 
                    match(input,183,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 

                    }


                    }
                    break;
                case 152 :
                    // InternalPerl.g:1842:2: ( 'semctl' )
                    {
                    // InternalPerl.g:1842:2: ( 'semctl' )
                    // InternalPerl.g:1843:3: 'semctl'
                    {
                     before(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 
                    match(input,184,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 

                    }


                    }
                    break;
                case 153 :
                    // InternalPerl.g:1848:2: ( 'semget' )
                    {
                    // InternalPerl.g:1848:2: ( 'semget' )
                    // InternalPerl.g:1849:3: 'semget'
                    {
                     before(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 
                    match(input,185,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 

                    }


                    }
                    break;
                case 154 :
                    // InternalPerl.g:1854:2: ( 'semop' )
                    {
                    // InternalPerl.g:1854:2: ( 'semop' )
                    // InternalPerl.g:1855:3: 'semop'
                    {
                     before(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 
                    match(input,186,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 

                    }


                    }
                    break;
                case 155 :
                    // InternalPerl.g:1860:2: ( 'send' )
                    {
                    // InternalPerl.g:1860:2: ( 'send' )
                    // InternalPerl.g:1861:3: 'send'
                    {
                     before(grammarAccess.getKeywordAccess().getSendKeyword_154()); 
                    match(input,187,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSendKeyword_154()); 

                    }


                    }
                    break;
                case 156 :
                    // InternalPerl.g:1866:2: ( 'setgrent' )
                    {
                    // InternalPerl.g:1866:2: ( 'setgrent' )
                    // InternalPerl.g:1867:3: 'setgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 
                    match(input,188,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 

                    }


                    }
                    break;
                case 157 :
                    // InternalPerl.g:1872:2: ( 'sethostent' )
                    {
                    // InternalPerl.g:1872:2: ( 'sethostent' )
                    // InternalPerl.g:1873:3: 'sethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 
                    match(input,189,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 

                    }


                    }
                    break;
                case 158 :
                    // InternalPerl.g:1878:2: ( 'setnetent' )
                    {
                    // InternalPerl.g:1878:2: ( 'setnetent' )
                    // InternalPerl.g:1879:3: 'setnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 
                    match(input,190,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 

                    }


                    }
                    break;
                case 159 :
                    // InternalPerl.g:1884:2: ( 'setpgrp' )
                    {
                    // InternalPerl.g:1884:2: ( 'setpgrp' )
                    // InternalPerl.g:1885:3: 'setpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 
                    match(input,191,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 

                    }


                    }
                    break;
                case 160 :
                    // InternalPerl.g:1890:2: ( 'setpriority' )
                    {
                    // InternalPerl.g:1890:2: ( 'setpriority' )
                    // InternalPerl.g:1891:3: 'setpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 
                    match(input,192,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 

                    }


                    }
                    break;
                case 161 :
                    // InternalPerl.g:1896:2: ( 'setprotoent' )
                    {
                    // InternalPerl.g:1896:2: ( 'setprotoent' )
                    // InternalPerl.g:1897:3: 'setprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 
                    match(input,193,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 

                    }


                    }
                    break;
                case 162 :
                    // InternalPerl.g:1902:2: ( 'setpwent' )
                    {
                    // InternalPerl.g:1902:2: ( 'setpwent' )
                    // InternalPerl.g:1903:3: 'setpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 
                    match(input,194,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 

                    }


                    }
                    break;
                case 163 :
                    // InternalPerl.g:1908:2: ( 'setservent' )
                    {
                    // InternalPerl.g:1908:2: ( 'setservent' )
                    // InternalPerl.g:1909:3: 'setservent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 
                    match(input,195,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 

                    }


                    }
                    break;
                case 164 :
                    // InternalPerl.g:1914:2: ( 'setsockopt' )
                    {
                    // InternalPerl.g:1914:2: ( 'setsockopt' )
                    // InternalPerl.g:1915:3: 'setsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 
                    match(input,196,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 

                    }


                    }
                    break;
                case 165 :
                    // InternalPerl.g:1920:2: ( 'shift' )
                    {
                    // InternalPerl.g:1920:2: ( 'shift' )
                    // InternalPerl.g:1921:3: 'shift'
                    {
                     before(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 
                    match(input,197,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 

                    }


                    }
                    break;
                case 166 :
                    // InternalPerl.g:1926:2: ( 'shmctl' )
                    {
                    // InternalPerl.g:1926:2: ( 'shmctl' )
                    // InternalPerl.g:1927:3: 'shmctl'
                    {
                     before(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 
                    match(input,198,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 

                    }


                    }
                    break;
                case 167 :
                    // InternalPerl.g:1932:2: ( 'shmget' )
                    {
                    // InternalPerl.g:1932:2: ( 'shmget' )
                    // InternalPerl.g:1933:3: 'shmget'
                    {
                     before(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 
                    match(input,199,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 

                    }


                    }
                    break;
                case 168 :
                    // InternalPerl.g:1938:2: ( 'shmread' )
                    {
                    // InternalPerl.g:1938:2: ( 'shmread' )
                    // InternalPerl.g:1939:3: 'shmread'
                    {
                     before(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 
                    match(input,200,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 

                    }


                    }
                    break;
                case 169 :
                    // InternalPerl.g:1944:2: ( 'shmwrite' )
                    {
                    // InternalPerl.g:1944:2: ( 'shmwrite' )
                    // InternalPerl.g:1945:3: 'shmwrite'
                    {
                     before(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 
                    match(input,201,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 

                    }


                    }
                    break;
                case 170 :
                    // InternalPerl.g:1950:2: ( 'shutdown' )
                    {
                    // InternalPerl.g:1950:2: ( 'shutdown' )
                    // InternalPerl.g:1951:3: 'shutdown'
                    {
                     before(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 
                    match(input,202,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 

                    }


                    }
                    break;
                case 171 :
                    // InternalPerl.g:1956:2: ( 'sin' )
                    {
                    // InternalPerl.g:1956:2: ( 'sin' )
                    // InternalPerl.g:1957:3: 'sin'
                    {
                     before(grammarAccess.getKeywordAccess().getSinKeyword_170()); 
                    match(input,203,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSinKeyword_170()); 

                    }


                    }
                    break;
                case 172 :
                    // InternalPerl.g:1962:2: ( 'sleep' )
                    {
                    // InternalPerl.g:1962:2: ( 'sleep' )
                    // InternalPerl.g:1963:3: 'sleep'
                    {
                     before(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 
                    match(input,204,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 

                    }


                    }
                    break;
                case 173 :
                    // InternalPerl.g:1968:2: ( 'socket' )
                    {
                    // InternalPerl.g:1968:2: ( 'socket' )
                    // InternalPerl.g:1969:3: 'socket'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 
                    match(input,205,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 

                    }


                    }
                    break;
                case 174 :
                    // InternalPerl.g:1974:2: ( 'socketpair' )
                    {
                    // InternalPerl.g:1974:2: ( 'socketpair' )
                    // InternalPerl.g:1975:3: 'socketpair'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 
                    match(input,206,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 

                    }


                    }
                    break;
                case 175 :
                    // InternalPerl.g:1980:2: ( 'sort' )
                    {
                    // InternalPerl.g:1980:2: ( 'sort' )
                    // InternalPerl.g:1981:3: 'sort'
                    {
                     before(grammarAccess.getKeywordAccess().getSortKeyword_174()); 
                    match(input,207,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSortKeyword_174()); 

                    }


                    }
                    break;
                case 176 :
                    // InternalPerl.g:1986:2: ( 'splice' )
                    {
                    // InternalPerl.g:1986:2: ( 'splice' )
                    // InternalPerl.g:1987:3: 'splice'
                    {
                     before(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 
                    match(input,208,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 

                    }


                    }
                    break;
                case 177 :
                    // InternalPerl.g:1992:2: ( 'split' )
                    {
                    // InternalPerl.g:1992:2: ( 'split' )
                    // InternalPerl.g:1993:3: 'split'
                    {
                     before(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 
                    match(input,209,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 

                    }


                    }
                    break;
                case 178 :
                    // InternalPerl.g:1998:2: ( 'sprintf' )
                    {
                    // InternalPerl.g:1998:2: ( 'sprintf' )
                    // InternalPerl.g:1999:3: 'sprintf'
                    {
                     before(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 
                    match(input,210,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 

                    }


                    }
                    break;
                case 179 :
                    // InternalPerl.g:2004:2: ( 'sqrt' )
                    {
                    // InternalPerl.g:2004:2: ( 'sqrt' )
                    // InternalPerl.g:2005:3: 'sqrt'
                    {
                     before(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 
                    match(input,211,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 

                    }


                    }
                    break;
                case 180 :
                    // InternalPerl.g:2010:2: ( 'srand' )
                    {
                    // InternalPerl.g:2010:2: ( 'srand' )
                    // InternalPerl.g:2011:3: 'srand'
                    {
                     before(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 
                    match(input,212,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 

                    }


                    }
                    break;
                case 181 :
                    // InternalPerl.g:2016:2: ( 'stat' )
                    {
                    // InternalPerl.g:2016:2: ( 'stat' )
                    // InternalPerl.g:2017:3: 'stat'
                    {
                     before(grammarAccess.getKeywordAccess().getStatKeyword_180()); 
                    match(input,213,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStatKeyword_180()); 

                    }


                    }
                    break;
                case 182 :
                    // InternalPerl.g:2022:2: ( 'state' )
                    {
                    // InternalPerl.g:2022:2: ( 'state' )
                    // InternalPerl.g:2023:3: 'state'
                    {
                     before(grammarAccess.getKeywordAccess().getStateKeyword_181()); 
                    match(input,214,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStateKeyword_181()); 

                    }


                    }
                    break;
                case 183 :
                    // InternalPerl.g:2028:2: ( 'study' )
                    {
                    // InternalPerl.g:2028:2: ( 'study' )
                    // InternalPerl.g:2029:3: 'study'
                    {
                     before(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 
                    match(input,215,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 

                    }


                    }
                    break;
                case 184 :
                    // InternalPerl.g:2034:2: ( 'sub' )
                    {
                    // InternalPerl.g:2034:2: ( 'sub' )
                    // InternalPerl.g:2035:3: 'sub'
                    {
                     before(grammarAccess.getKeywordAccess().getSubKeyword_183()); 
                    match(input,216,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubKeyword_183()); 

                    }


                    }
                    break;
                case 185 :
                    // InternalPerl.g:2040:2: ( 'substr' )
                    {
                    // InternalPerl.g:2040:2: ( 'substr' )
                    // InternalPerl.g:2041:3: 'substr'
                    {
                     before(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 
                    match(input,217,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 

                    }


                    }
                    break;
                case 186 :
                    // InternalPerl.g:2046:2: ( 'symlink' )
                    {
                    // InternalPerl.g:2046:2: ( 'symlink' )
                    // InternalPerl.g:2047:3: 'symlink'
                    {
                     before(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 
                    match(input,218,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 

                    }


                    }
                    break;
                case 187 :
                    // InternalPerl.g:2052:2: ( 'syscall' )
                    {
                    // InternalPerl.g:2052:2: ( 'syscall' )
                    // InternalPerl.g:2053:3: 'syscall'
                    {
                     before(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 
                    match(input,219,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 

                    }


                    }
                    break;
                case 188 :
                    // InternalPerl.g:2058:2: ( 'sysopen' )
                    {
                    // InternalPerl.g:2058:2: ( 'sysopen' )
                    // InternalPerl.g:2059:3: 'sysopen'
                    {
                     before(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 
                    match(input,220,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 

                    }


                    }
                    break;
                case 189 :
                    // InternalPerl.g:2064:2: ( 'sysread' )
                    {
                    // InternalPerl.g:2064:2: ( 'sysread' )
                    // InternalPerl.g:2065:3: 'sysread'
                    {
                     before(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 
                    match(input,221,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 

                    }


                    }
                    break;
                case 190 :
                    // InternalPerl.g:2070:2: ( 'sysseek' )
                    {
                    // InternalPerl.g:2070:2: ( 'sysseek' )
                    // InternalPerl.g:2071:3: 'sysseek'
                    {
                     before(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 
                    match(input,222,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 

                    }


                    }
                    break;
                case 191 :
                    // InternalPerl.g:2076:2: ( 'system' )
                    {
                    // InternalPerl.g:2076:2: ( 'system' )
                    // InternalPerl.g:2077:3: 'system'
                    {
                     before(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 
                    match(input,223,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 

                    }


                    }
                    break;
                case 192 :
                    // InternalPerl.g:2082:2: ( 'syswrite' )
                    {
                    // InternalPerl.g:2082:2: ( 'syswrite' )
                    // InternalPerl.g:2083:3: 'syswrite'
                    {
                     before(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 
                    match(input,224,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 

                    }


                    }
                    break;
                case 193 :
                    // InternalPerl.g:2088:2: ( 'tell' )
                    {
                    // InternalPerl.g:2088:2: ( 'tell' )
                    // InternalPerl.g:2089:3: 'tell'
                    {
                     before(grammarAccess.getKeywordAccess().getTellKeyword_192()); 
                    match(input,225,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTellKeyword_192()); 

                    }


                    }
                    break;
                case 194 :
                    // InternalPerl.g:2094:2: ( 'telldir' )
                    {
                    // InternalPerl.g:2094:2: ( 'telldir' )
                    // InternalPerl.g:2095:3: 'telldir'
                    {
                     before(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 
                    match(input,226,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 

                    }


                    }
                    break;
                case 195 :
                    // InternalPerl.g:2100:2: ( 'tie' )
                    {
                    // InternalPerl.g:2100:2: ( 'tie' )
                    // InternalPerl.g:2101:3: 'tie'
                    {
                     before(grammarAccess.getKeywordAccess().getTieKeyword_194()); 
                    match(input,227,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTieKeyword_194()); 

                    }


                    }
                    break;
                case 196 :
                    // InternalPerl.g:2106:2: ( 'tied' )
                    {
                    // InternalPerl.g:2106:2: ( 'tied' )
                    // InternalPerl.g:2107:3: 'tied'
                    {
                     before(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 
                    match(input,228,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 

                    }


                    }
                    break;
                case 197 :
                    // InternalPerl.g:2112:2: ( 'time' )
                    {
                    // InternalPerl.g:2112:2: ( 'time' )
                    // InternalPerl.g:2113:3: 'time'
                    {
                     before(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 
                    match(input,229,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 

                    }


                    }
                    break;
                case 198 :
                    // InternalPerl.g:2118:2: ( 'times' )
                    {
                    // InternalPerl.g:2118:2: ( 'times' )
                    // InternalPerl.g:2119:3: 'times'
                    {
                     before(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 
                    match(input,230,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 

                    }


                    }
                    break;
                case 199 :
                    // InternalPerl.g:2124:2: ( 'tr' )
                    {
                    // InternalPerl.g:2124:2: ( 'tr' )
                    // InternalPerl.g:2125:3: 'tr'
                    {
                     before(grammarAccess.getKeywordAccess().getTrKeyword_198()); 
                    match(input,231,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTrKeyword_198()); 

                    }


                    }
                    break;
                case 200 :
                    // InternalPerl.g:2130:2: ( 'truncate' )
                    {
                    // InternalPerl.g:2130:2: ( 'truncate' )
                    // InternalPerl.g:2131:3: 'truncate'
                    {
                     before(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 
                    match(input,232,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 

                    }


                    }
                    break;
                case 201 :
                    // InternalPerl.g:2136:2: ( 'uc' )
                    {
                    // InternalPerl.g:2136:2: ( 'uc' )
                    // InternalPerl.g:2137:3: 'uc'
                    {
                     before(grammarAccess.getKeywordAccess().getUcKeyword_200()); 
                    match(input,233,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcKeyword_200()); 

                    }


                    }
                    break;
                case 202 :
                    // InternalPerl.g:2142:2: ( 'ucfirst' )
                    {
                    // InternalPerl.g:2142:2: ( 'ucfirst' )
                    // InternalPerl.g:2143:3: 'ucfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 
                    match(input,234,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 

                    }


                    }
                    break;
                case 203 :
                    // InternalPerl.g:2148:2: ( 'umask' )
                    {
                    // InternalPerl.g:2148:2: ( 'umask' )
                    // InternalPerl.g:2149:3: 'umask'
                    {
                     before(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 
                    match(input,235,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 

                    }


                    }
                    break;
                case 204 :
                    // InternalPerl.g:2154:2: ( 'undef' )
                    {
                    // InternalPerl.g:2154:2: ( 'undef' )
                    // InternalPerl.g:2155:3: 'undef'
                    {
                     before(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 
                    match(input,236,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 

                    }


                    }
                    break;
                case 205 :
                    // InternalPerl.g:2160:2: ( 'unless' )
                    {
                    // InternalPerl.g:2160:2: ( 'unless' )
                    // InternalPerl.g:2161:3: 'unless'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 
                    match(input,237,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 

                    }


                    }
                    break;
                case 206 :
                    // InternalPerl.g:2166:2: ( 'unlink' )
                    {
                    // InternalPerl.g:2166:2: ( 'unlink' )
                    // InternalPerl.g:2167:3: 'unlink'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 
                    match(input,238,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 

                    }


                    }
                    break;
                case 207 :
                    // InternalPerl.g:2172:2: ( 'unpack' )
                    {
                    // InternalPerl.g:2172:2: ( 'unpack' )
                    // InternalPerl.g:2173:3: 'unpack'
                    {
                     before(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 
                    match(input,239,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 

                    }


                    }
                    break;
                case 208 :
                    // InternalPerl.g:2178:2: ( 'unshift' )
                    {
                    // InternalPerl.g:2178:2: ( 'unshift' )
                    // InternalPerl.g:2179:3: 'unshift'
                    {
                     before(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 
                    match(input,240,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 

                    }


                    }
                    break;
                case 209 :
                    // InternalPerl.g:2184:2: ( 'untie' )
                    {
                    // InternalPerl.g:2184:2: ( 'untie' )
                    // InternalPerl.g:2185:3: 'untie'
                    {
                     before(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 
                    match(input,241,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 

                    }


                    }
                    break;
                case 210 :
                    // InternalPerl.g:2190:2: ( 'until' )
                    {
                    // InternalPerl.g:2190:2: ( 'until' )
                    // InternalPerl.g:2191:3: 'until'
                    {
                     before(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 
                    match(input,242,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 

                    }


                    }
                    break;
                case 211 :
                    // InternalPerl.g:2196:2: ( 'use' )
                    {
                    // InternalPerl.g:2196:2: ( 'use' )
                    // InternalPerl.g:2197:3: 'use'
                    {
                     before(grammarAccess.getKeywordAccess().getUseKeyword_210()); 
                    match(input,243,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUseKeyword_210()); 

                    }


                    }
                    break;
                case 212 :
                    // InternalPerl.g:2202:2: ( 'utime' )
                    {
                    // InternalPerl.g:2202:2: ( 'utime' )
                    // InternalPerl.g:2203:3: 'utime'
                    {
                     before(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 
                    match(input,244,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 

                    }


                    }
                    break;
                case 213 :
                    // InternalPerl.g:2208:2: ( 'values' )
                    {
                    // InternalPerl.g:2208:2: ( 'values' )
                    // InternalPerl.g:2209:3: 'values'
                    {
                     before(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 
                    match(input,245,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 

                    }


                    }
                    break;
                case 214 :
                    // InternalPerl.g:2214:2: ( 'vec' )
                    {
                    // InternalPerl.g:2214:2: ( 'vec' )
                    // InternalPerl.g:2215:3: 'vec'
                    {
                     before(grammarAccess.getKeywordAccess().getVecKeyword_213()); 
                    match(input,246,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getVecKeyword_213()); 

                    }


                    }
                    break;
                case 215 :
                    // InternalPerl.g:2220:2: ( 'wait' )
                    {
                    // InternalPerl.g:2220:2: ( 'wait' )
                    // InternalPerl.g:2221:3: 'wait'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 
                    match(input,247,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 

                    }


                    }
                    break;
                case 216 :
                    // InternalPerl.g:2226:2: ( 'waitpid' )
                    {
                    // InternalPerl.g:2226:2: ( 'waitpid' )
                    // InternalPerl.g:2227:3: 'waitpid'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 
                    match(input,248,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 

                    }


                    }
                    break;
                case 217 :
                    // InternalPerl.g:2232:2: ( 'wantarray' )
                    {
                    // InternalPerl.g:2232:2: ( 'wantarray' )
                    // InternalPerl.g:2233:3: 'wantarray'
                    {
                     before(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 
                    match(input,249,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 

                    }


                    }
                    break;
                case 218 :
                    // InternalPerl.g:2238:2: ( 'warn' )
                    {
                    // InternalPerl.g:2238:2: ( 'warn' )
                    // InternalPerl.g:2239:3: 'warn'
                    {
                     before(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 
                    match(input,250,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 

                    }


                    }
                    break;
                case 219 :
                    // InternalPerl.g:2244:2: ( 'when' )
                    {
                    // InternalPerl.g:2244:2: ( 'when' )
                    // InternalPerl.g:2245:3: 'when'
                    {
                     before(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 
                    match(input,251,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 

                    }


                    }
                    break;
                case 220 :
                    // InternalPerl.g:2250:2: ( 'while' )
                    {
                    // InternalPerl.g:2250:2: ( 'while' )
                    // InternalPerl.g:2251:3: 'while'
                    {
                     before(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 
                    match(input,252,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 

                    }


                    }
                    break;
                case 221 :
                    // InternalPerl.g:2256:2: ( 'write' )
                    {
                    // InternalPerl.g:2256:2: ( 'write' )
                    // InternalPerl.g:2257:3: 'write'
                    {
                     before(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 
                    match(input,253,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 

                    }


                    }
                    break;
                case 222 :
                    // InternalPerl.g:2262:2: ( 'y' )
                    {
                    // InternalPerl.g:2262:2: ( 'y' )
                    // InternalPerl.g:2263:3: 'y'
                    {
                     before(grammarAccess.getKeywordAccess().getYKeyword_221()); 
                    match(input,254,FOLLOW_2); 
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
    // InternalPerl.g:2272:1: rule__Operator__Alternatives : ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2276:1: ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) )
            int alt14=64;
            switch ( input.LA(1) ) {
            case 255:
                {
                alt14=1;
                }
                break;
            case 256:
                {
                alt14=2;
                }
                break;
            case 257:
                {
                alt14=3;
                }
                break;
            case 258:
                {
                alt14=4;
                }
                break;
            case 259:
                {
                alt14=5;
                }
                break;
            case 260:
                {
                alt14=6;
                }
                break;
            case 261:
                {
                alt14=7;
                }
                break;
            case 262:
                {
                alt14=8;
                }
                break;
            case 263:
                {
                alt14=9;
                }
                break;
            case 264:
                {
                alt14=10;
                }
                break;
            case 265:
                {
                alt14=11;
                }
                break;
            case 30:
                {
                alt14=12;
                }
                break;
            case 266:
                {
                alt14=13;
                }
                break;
            case 267:
                {
                alt14=14;
                }
                break;
            case 268:
                {
                alt14=15;
                }
                break;
            case 269:
                {
                alt14=16;
                }
                break;
            case 270:
                {
                alt14=17;
                }
                break;
            case 271:
                {
                alt14=18;
                }
                break;
            case 272:
                {
                alt14=19;
                }
                break;
            case 273:
                {
                alt14=20;
                }
                break;
            case 274:
                {
                alt14=21;
                }
                break;
            case 275:
                {
                alt14=22;
                }
                break;
            case 276:
                {
                alt14=23;
                }
                break;
            case 347:
                {
                alt14=24;
                }
                break;
            case 277:
                {
                alt14=25;
                }
                break;
            case 278:
                {
                alt14=26;
                }
                break;
            case 279:
                {
                alt14=27;
                }
                break;
            case 32:
                {
                alt14=28;
                }
                break;
            case 280:
                {
                alt14=29;
                }
                break;
            case 281:
                {
                alt14=30;
                }
                break;
            case 282:
                {
                alt14=31;
                }
                break;
            case 283:
                {
                alt14=32;
                }
                break;
            case 284:
                {
                alt14=33;
                }
                break;
            case 285:
                {
                alt14=34;
                }
                break;
            case 286:
                {
                alt14=35;
                }
                break;
            case 287:
                {
                alt14=36;
                }
                break;
            case 288:
                {
                alt14=37;
                }
                break;
            case 289:
                {
                alt14=38;
                }
                break;
            case 290:
                {
                alt14=39;
                }
                break;
            case 291:
                {
                alt14=40;
                }
                break;
            case 292:
                {
                alt14=41;
                }
                break;
            case 293:
                {
                alt14=42;
                }
                break;
            case 294:
                {
                alt14=43;
                }
                break;
            case 295:
                {
                alt14=44;
                }
                break;
            case 296:
                {
                alt14=45;
                }
                break;
            case 297:
                {
                alt14=46;
                }
                break;
            case 298:
                {
                alt14=47;
                }
                break;
            case 299:
                {
                alt14=48;
                }
                break;
            case 300:
                {
                alt14=49;
                }
                break;
            case 301:
                {
                alt14=50;
                }
                break;
            case 302:
                {
                alt14=51;
                }
                break;
            case 303:
                {
                alt14=52;
                }
                break;
            case 304:
                {
                alt14=53;
                }
                break;
            case 305:
                {
                alt14=54;
                }
                break;
            case 306:
                {
                alt14=55;
                }
                break;
            case 307:
                {
                alt14=56;
                }
                break;
            case 308:
                {
                alt14=57;
                }
                break;
            case 309:
                {
                alt14=58;
                }
                break;
            case 310:
                {
                alt14=59;
                }
                break;
            case 311:
                {
                alt14=60;
                }
                break;
            case 312:
                {
                alt14=61;
                }
                break;
            case 313:
                {
                alt14=62;
                }
                break;
            case 314:
                {
                alt14=63;
                }
                break;
            case 315:
                {
                alt14=64;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalPerl.g:2277:2: ( '++' )
                    {
                    // InternalPerl.g:2277:2: ( '++' )
                    // InternalPerl.g:2278:3: '++'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 
                    match(input,255,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2283:2: ( '--' )
                    {
                    // InternalPerl.g:2283:2: ( '--' )
                    // InternalPerl.g:2284:3: '--'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    match(input,256,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2289:2: ( '**' )
                    {
                    // InternalPerl.g:2289:2: ( '**' )
                    // InternalPerl.g:2290:3: '**'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 
                    match(input,257,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2295:2: ( '!' )
                    {
                    // InternalPerl.g:2295:2: ( '!' )
                    // InternalPerl.g:2296:3: '!'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 
                    match(input,258,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2301:2: ( '~' )
                    {
                    // InternalPerl.g:2301:2: ( '~' )
                    // InternalPerl.g:2302:3: '~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 
                    match(input,259,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2307:2: ( '+' )
                    {
                    // InternalPerl.g:2307:2: ( '+' )
                    // InternalPerl.g:2308:3: '+'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 
                    match(input,260,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2313:2: ( '-' )
                    {
                    // InternalPerl.g:2313:2: ( '-' )
                    // InternalPerl.g:2314:3: '-'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 
                    match(input,261,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2319:2: ( '=~' )
                    {
                    // InternalPerl.g:2319:2: ( '=~' )
                    // InternalPerl.g:2320:3: '=~'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 
                    match(input,262,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2325:2: ( '!~' )
                    {
                    // InternalPerl.g:2325:2: ( '!~' )
                    // InternalPerl.g:2326:3: '!~'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 
                    match(input,263,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2331:2: ( '*' )
                    {
                    // InternalPerl.g:2331:2: ( '*' )
                    // InternalPerl.g:2332:3: '*'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 
                    match(input,264,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2337:2: ( '/' )
                    {
                    // InternalPerl.g:2337:2: ( '/' )
                    // InternalPerl.g:2338:3: '/'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 
                    match(input,265,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2343:2: ( '%' )
                    {
                    // InternalPerl.g:2343:2: ( '%' )
                    // InternalPerl.g:2344:3: '%'
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2349:2: ( 'x' )
                    {
                    // InternalPerl.g:2349:2: ( 'x' )
                    // InternalPerl.g:2350:3: 'x'
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_12()); 
                    match(input,266,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2355:2: ( '<<' )
                    {
                    // InternalPerl.g:2355:2: ( '<<' )
                    // InternalPerl.g:2356:3: '<<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 
                    match(input,267,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2361:2: ( '>>' )
                    {
                    // InternalPerl.g:2361:2: ( '>>' )
                    // InternalPerl.g:2362:3: '>>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 
                    match(input,268,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2367:2: ( 'lt' )
                    {
                    // InternalPerl.g:2367:2: ( 'lt' )
                    // InternalPerl.g:2368:3: 'lt'
                    {
                     before(grammarAccess.getOperatorAccess().getLtKeyword_15()); 
                    match(input,269,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLtKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2373:2: ( 'gt' )
                    {
                    // InternalPerl.g:2373:2: ( 'gt' )
                    // InternalPerl.g:2374:3: 'gt'
                    {
                     before(grammarAccess.getOperatorAccess().getGtKeyword_16()); 
                    match(input,270,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGtKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2379:2: ( 'le' )
                    {
                    // InternalPerl.g:2379:2: ( 'le' )
                    // InternalPerl.g:2380:3: 'le'
                    {
                     before(grammarAccess.getOperatorAccess().getLeKeyword_17()); 
                    match(input,271,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLeKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2385:2: ( 'ge' )
                    {
                    // InternalPerl.g:2385:2: ( 'ge' )
                    // InternalPerl.g:2386:3: 'ge'
                    {
                     before(grammarAccess.getOperatorAccess().getGeKeyword_18()); 
                    match(input,272,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGeKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2391:2: ( 'cmp' )
                    {
                    // InternalPerl.g:2391:2: ( 'cmp' )
                    // InternalPerl.g:2392:3: 'cmp'
                    {
                     before(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 
                    match(input,273,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2397:2: ( '~~' )
                    {
                    // InternalPerl.g:2397:2: ( '~~' )
                    // InternalPerl.g:2398:3: '~~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 
                    match(input,274,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2403:2: ( '==' )
                    {
                    // InternalPerl.g:2403:2: ( '==' )
                    // InternalPerl.g:2404:3: '=='
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 
                    match(input,275,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2409:2: ( '!=' )
                    {
                    // InternalPerl.g:2409:2: ( '!=' )
                    // InternalPerl.g:2410:3: '!='
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 
                    match(input,276,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2415:2: ( ( rule__Operator__Group_23__0 ) )
                    {
                    // InternalPerl.g:2415:2: ( ( rule__Operator__Group_23__0 ) )
                    // InternalPerl.g:2416:3: ( rule__Operator__Group_23__0 )
                    {
                     before(grammarAccess.getOperatorAccess().getGroup_23()); 
                    // InternalPerl.g:2417:3: ( rule__Operator__Group_23__0 )
                    // InternalPerl.g:2417:4: rule__Operator__Group_23__0
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
                    // InternalPerl.g:2421:2: ( '..' )
                    {
                    // InternalPerl.g:2421:2: ( '..' )
                    // InternalPerl.g:2422:3: '..'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 
                    match(input,277,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2427:2: ( '...' )
                    {
                    // InternalPerl.g:2427:2: ( '...' )
                    // InternalPerl.g:2428:3: '...'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 
                    match(input,278,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2433:2: ( ',' )
                    {
                    // InternalPerl.g:2433:2: ( ',' )
                    // InternalPerl.g:2434:3: ','
                    {
                     before(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 
                    match(input,279,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:2439:2: ( '&' )
                    {
                    // InternalPerl.g:2439:2: ( '&' )
                    // InternalPerl.g:2440:3: '&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:2445:2: ( '|' )
                    {
                    // InternalPerl.g:2445:2: ( '|' )
                    // InternalPerl.g:2446:3: '|'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 
                    match(input,280,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:2451:2: ( '^' )
                    {
                    // InternalPerl.g:2451:2: ( '^' )
                    // InternalPerl.g:2452:3: '^'
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 
                    match(input,281,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:2457:2: ( '&&' )
                    {
                    // InternalPerl.g:2457:2: ( '&&' )
                    // InternalPerl.g:2458:3: '&&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 
                    match(input,282,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:2463:2: ( '||' )
                    {
                    // InternalPerl.g:2463:2: ( '||' )
                    // InternalPerl.g:2464:3: '||'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 
                    match(input,283,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:2469:2: ( '//' )
                    {
                    // InternalPerl.g:2469:2: ( '//' )
                    // InternalPerl.g:2470:3: '//'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 
                    match(input,284,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:2475:2: ( '?' )
                    {
                    // InternalPerl.g:2475:2: ( '?' )
                    // InternalPerl.g:2476:3: '?'
                    {
                     before(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 
                    match(input,285,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:2481:2: ( ':' )
                    {
                    // InternalPerl.g:2481:2: ( ':' )
                    // InternalPerl.g:2482:3: ':'
                    {
                     before(grammarAccess.getOperatorAccess().getColonKeyword_34()); 
                    match(input,286,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getColonKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:2487:2: ( '**=' )
                    {
                    // InternalPerl.g:2487:2: ( '**=' )
                    // InternalPerl.g:2488:3: '**='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 
                    match(input,287,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:2493:2: ( '+=' )
                    {
                    // InternalPerl.g:2493:2: ( '+=' )
                    // InternalPerl.g:2494:3: '+='
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 
                    match(input,288,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:2499:2: ( '-=' )
                    {
                    // InternalPerl.g:2499:2: ( '-=' )
                    // InternalPerl.g:2500:3: '-='
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 
                    match(input,289,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:2505:2: ( '.=' )
                    {
                    // InternalPerl.g:2505:2: ( '.=' )
                    // InternalPerl.g:2506:3: '.='
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 
                    match(input,290,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:2511:2: ( '*=' )
                    {
                    // InternalPerl.g:2511:2: ( '*=' )
                    // InternalPerl.g:2512:3: '*='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 
                    match(input,291,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:2517:2: ( '/=' )
                    {
                    // InternalPerl.g:2517:2: ( '/=' )
                    // InternalPerl.g:2518:3: '/='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 
                    match(input,292,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:2523:2: ( '%=' )
                    {
                    // InternalPerl.g:2523:2: ( '%=' )
                    // InternalPerl.g:2524:3: '%='
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 
                    match(input,293,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:2529:2: ( 'x=' )
                    {
                    // InternalPerl.g:2529:2: ( 'x=' )
                    // InternalPerl.g:2530:3: 'x='
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_42()); 
                    match(input,294,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:2535:2: ( '&=' )
                    {
                    // InternalPerl.g:2535:2: ( '&=' )
                    // InternalPerl.g:2536:3: '&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 
                    match(input,295,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:2541:2: ( '|=' )
                    {
                    // InternalPerl.g:2541:2: ( '|=' )
                    // InternalPerl.g:2542:3: '|='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 
                    match(input,296,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:2547:2: ( '^=' )
                    {
                    // InternalPerl.g:2547:2: ( '^=' )
                    // InternalPerl.g:2548:3: '^='
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 
                    match(input,297,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:2553:2: ( '<<=' )
                    {
                    // InternalPerl.g:2553:2: ( '<<=' )
                    // InternalPerl.g:2554:3: '<<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 
                    match(input,298,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:2559:2: ( '>>=' )
                    {
                    // InternalPerl.g:2559:2: ( '>>=' )
                    // InternalPerl.g:2560:3: '>>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 
                    match(input,299,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:2565:2: ( '&&=' )
                    {
                    // InternalPerl.g:2565:2: ( '&&=' )
                    // InternalPerl.g:2566:3: '&&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 
                    match(input,300,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:2571:2: ( '||=' )
                    {
                    // InternalPerl.g:2571:2: ( '||=' )
                    // InternalPerl.g:2572:3: '||='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 
                    match(input,301,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:2577:2: ( '//=' )
                    {
                    // InternalPerl.g:2577:2: ( '//=' )
                    // InternalPerl.g:2578:3: '//='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 
                    match(input,302,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:2583:2: ( '<' )
                    {
                    // InternalPerl.g:2583:2: ( '<' )
                    // InternalPerl.g:2584:3: '<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 
                    match(input,303,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:2589:2: ( '>' )
                    {
                    // InternalPerl.g:2589:2: ( '>' )
                    // InternalPerl.g:2590:3: '>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 
                    match(input,304,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:2595:2: ( '<=' )
                    {
                    // InternalPerl.g:2595:2: ( '<=' )
                    // InternalPerl.g:2596:3: '<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 
                    match(input,305,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:2601:2: ( '>=' )
                    {
                    // InternalPerl.g:2601:2: ( '>=' )
                    // InternalPerl.g:2602:3: '>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 
                    match(input,306,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:2607:2: ( '<>' )
                    {
                    // InternalPerl.g:2607:2: ( '<>' )
                    // InternalPerl.g:2608:3: '<>'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 
                    match(input,307,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:2613:2: ( '=>' )
                    {
                    // InternalPerl.g:2613:2: ( '=>' )
                    // InternalPerl.g:2614:3: '=>'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 
                    match(input,308,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:2619:2: ( '->' )
                    {
                    // InternalPerl.g:2619:2: ( '->' )
                    // InternalPerl.g:2620:3: '->'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 
                    match(input,309,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:2625:2: ( 'and' )
                    {
                    // InternalPerl.g:2625:2: ( 'and' )
                    // InternalPerl.g:2626:3: 'and'
                    {
                     before(grammarAccess.getOperatorAccess().getAndKeyword_58()); 
                    match(input,310,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAndKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:2631:2: ( 'or' )
                    {
                    // InternalPerl.g:2631:2: ( 'or' )
                    // InternalPerl.g:2632:3: 'or'
                    {
                     before(grammarAccess.getOperatorAccess().getOrKeyword_59()); 
                    match(input,311,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getOrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:2637:2: ( 'xor' )
                    {
                    // InternalPerl.g:2637:2: ( 'xor' )
                    // InternalPerl.g:2638:3: 'xor'
                    {
                     before(grammarAccess.getOperatorAccess().getXorKeyword_60()); 
                    match(input,312,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXorKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:2643:2: ( 'not' )
                    {
                    // InternalPerl.g:2643:2: ( 'not' )
                    // InternalPerl.g:2644:3: 'not'
                    {
                     before(grammarAccess.getOperatorAccess().getNotKeyword_61()); 
                    match(input,313,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getNotKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:2649:2: ( 'eq' )
                    {
                    // InternalPerl.g:2649:2: ( 'eq' )
                    // InternalPerl.g:2650:3: 'eq'
                    {
                     before(grammarAccess.getOperatorAccess().getEqKeyword_62()); 
                    match(input,314,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:2655:2: ( 'ne' )
                    {
                    // InternalPerl.g:2655:2: ( 'ne' )
                    // InternalPerl.g:2656:3: 'ne'
                    {
                     before(grammarAccess.getOperatorAccess().getNeKeyword_63()); 
                    match(input,315,FOLLOW_2); 
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
    // InternalPerl.g:2665:1: rule__FileTestOperator__Alternatives : ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) );
    public final void rule__FileTestOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2669:1: ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) )
            int alt15=27;
            switch ( input.LA(1) ) {
            case 316:
                {
                alt15=1;
                }
                break;
            case 317:
                {
                alt15=2;
                }
                break;
            case 318:
                {
                alt15=3;
                }
                break;
            case 319:
                {
                alt15=4;
                }
                break;
            case 320:
                {
                alt15=5;
                }
                break;
            case 321:
                {
                alt15=6;
                }
                break;
            case 322:
                {
                alt15=7;
                }
                break;
            case 323:
                {
                alt15=8;
                }
                break;
            case 324:
                {
                alt15=9;
                }
                break;
            case 325:
                {
                alt15=10;
                }
                break;
            case 326:
                {
                alt15=11;
                }
                break;
            case 327:
                {
                alt15=12;
                }
                break;
            case 328:
                {
                alt15=13;
                }
                break;
            case 329:
                {
                alt15=14;
                }
                break;
            case 330:
                {
                alt15=15;
                }
                break;
            case 331:
                {
                alt15=16;
                }
                break;
            case 332:
                {
                alt15=17;
                }
                break;
            case 333:
                {
                alt15=18;
                }
                break;
            case 334:
                {
                alt15=19;
                }
                break;
            case 335:
                {
                alt15=20;
                }
                break;
            case 336:
                {
                alt15=21;
                }
                break;
            case 337:
                {
                alt15=22;
                }
                break;
            case 338:
                {
                alt15=23;
                }
                break;
            case 339:
                {
                alt15=24;
                }
                break;
            case 340:
                {
                alt15=25;
                }
                break;
            case 341:
                {
                alt15=26;
                }
                break;
            case 342:
                {
                alt15=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalPerl.g:2670:2: ( '-r' )
                    {
                    // InternalPerl.g:2670:2: ( '-r' )
                    // InternalPerl.g:2671:3: '-r'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 
                    match(input,316,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2676:2: ( '-w' )
                    {
                    // InternalPerl.g:2676:2: ( '-w' )
                    // InternalPerl.g:2677:3: '-w'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 
                    match(input,317,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2682:2: ( '-x' )
                    {
                    // InternalPerl.g:2682:2: ( '-x' )
                    // InternalPerl.g:2683:3: '-x'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 
                    match(input,318,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2688:2: ( '-o' )
                    {
                    // InternalPerl.g:2688:2: ( '-o' )
                    // InternalPerl.g:2689:3: '-o'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 
                    match(input,319,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2694:2: ( '-R' )
                    {
                    // InternalPerl.g:2694:2: ( '-R' )
                    // InternalPerl.g:2695:3: '-R'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 
                    match(input,320,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2700:2: ( '-W' )
                    {
                    // InternalPerl.g:2700:2: ( '-W' )
                    // InternalPerl.g:2701:3: '-W'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 
                    match(input,321,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2706:2: ( '-X' )
                    {
                    // InternalPerl.g:2706:2: ( '-X' )
                    // InternalPerl.g:2707:3: '-X'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 
                    match(input,322,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2712:2: ( '-O' )
                    {
                    // InternalPerl.g:2712:2: ( '-O' )
                    // InternalPerl.g:2713:3: '-O'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 
                    match(input,323,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2718:2: ( '-e' )
                    {
                    // InternalPerl.g:2718:2: ( '-e' )
                    // InternalPerl.g:2719:3: '-e'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 
                    match(input,324,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2724:2: ( '-z' )
                    {
                    // InternalPerl.g:2724:2: ( '-z' )
                    // InternalPerl.g:2725:3: '-z'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 
                    match(input,325,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2730:2: ( '-s' )
                    {
                    // InternalPerl.g:2730:2: ( '-s' )
                    // InternalPerl.g:2731:3: '-s'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 
                    match(input,326,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2736:2: ( '-f' )
                    {
                    // InternalPerl.g:2736:2: ( '-f' )
                    // InternalPerl.g:2737:3: '-f'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 
                    match(input,327,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2742:2: ( '-d' )
                    {
                    // InternalPerl.g:2742:2: ( '-d' )
                    // InternalPerl.g:2743:3: '-d'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 
                    match(input,328,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2748:2: ( '-l' )
                    {
                    // InternalPerl.g:2748:2: ( '-l' )
                    // InternalPerl.g:2749:3: '-l'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 
                    match(input,329,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2754:2: ( '-p' )
                    {
                    // InternalPerl.g:2754:2: ( '-p' )
                    // InternalPerl.g:2755:3: '-p'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 
                    match(input,330,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2760:2: ( '-S' )
                    {
                    // InternalPerl.g:2760:2: ( '-S' )
                    // InternalPerl.g:2761:3: '-S'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 
                    match(input,331,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2766:2: ( '-b' )
                    {
                    // InternalPerl.g:2766:2: ( '-b' )
                    // InternalPerl.g:2767:3: '-b'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 
                    match(input,332,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2772:2: ( '-c' )
                    {
                    // InternalPerl.g:2772:2: ( '-c' )
                    // InternalPerl.g:2773:3: '-c'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 
                    match(input,333,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2778:2: ( '-t' )
                    {
                    // InternalPerl.g:2778:2: ( '-t' )
                    // InternalPerl.g:2779:3: '-t'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 
                    match(input,334,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2784:2: ( '-u' )
                    {
                    // InternalPerl.g:2784:2: ( '-u' )
                    // InternalPerl.g:2785:3: '-u'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 
                    match(input,335,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2790:2: ( '-g' )
                    {
                    // InternalPerl.g:2790:2: ( '-g' )
                    // InternalPerl.g:2791:3: '-g'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 
                    match(input,336,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2796:2: ( '-k' )
                    {
                    // InternalPerl.g:2796:2: ( '-k' )
                    // InternalPerl.g:2797:3: '-k'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 
                    match(input,337,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2802:2: ( '-T' )
                    {
                    // InternalPerl.g:2802:2: ( '-T' )
                    // InternalPerl.g:2803:3: '-T'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 
                    match(input,338,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2808:2: ( '-B' )
                    {
                    // InternalPerl.g:2808:2: ( '-B' )
                    // InternalPerl.g:2809:3: '-B'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 
                    match(input,339,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:2814:2: ( '-M' )
                    {
                    // InternalPerl.g:2814:2: ( '-M' )
                    // InternalPerl.g:2815:3: '-M'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 
                    match(input,340,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2820:2: ( '-A' )
                    {
                    // InternalPerl.g:2820:2: ( '-A' )
                    // InternalPerl.g:2821:3: '-A'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 
                    match(input,341,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2826:2: ( '-C' )
                    {
                    // InternalPerl.g:2826:2: ( '-C' )
                    // InternalPerl.g:2827:3: '-C'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_26()); 
                    match(input,342,FOLLOW_2); 
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
    // InternalPerl.g:2836:1: rule__PerlDocument__Group__0 : rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 ;
    public final void rule__PerlDocument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2840:1: ( rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 )
            // InternalPerl.g:2841:2: rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1
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
    // InternalPerl.g:2848:1: rule__PerlDocument__Group__0__Impl : ( () ) ;
    public final void rule__PerlDocument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2852:1: ( ( () ) )
            // InternalPerl.g:2853:1: ( () )
            {
            // InternalPerl.g:2853:1: ( () )
            // InternalPerl.g:2854:2: ()
            {
             before(grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0()); 
            // InternalPerl.g:2855:2: ()
            // InternalPerl.g:2855:3: 
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
    // InternalPerl.g:2863:1: rule__PerlDocument__Group__1 : rule__PerlDocument__Group__1__Impl ;
    public final void rule__PerlDocument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2867:1: ( rule__PerlDocument__Group__1__Impl )
            // InternalPerl.g:2868:2: rule__PerlDocument__Group__1__Impl
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
    // InternalPerl.g:2874:1: rule__PerlDocument__Group__1__Impl : ( ( rule__PerlDocument__ElementsAssignment_1 )* ) ;
    public final void rule__PerlDocument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2878:1: ( ( ( rule__PerlDocument__ElementsAssignment_1 )* ) )
            // InternalPerl.g:2879:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            {
            // InternalPerl.g:2879:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            // InternalPerl.g:2880:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            {
             before(grammarAccess.getPerlDocumentAccess().getElementsAssignment_1()); 
            // InternalPerl.g:2881:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_REGEX_SUBSTITUTE && LA16_0<=RULE_LITERAL)||(LA16_0>=RULE_WORDS_QUOTE_LIKE && LA16_0<=RULE_READLINE_QUOTE)||LA16_0==30||(LA16_0>=32 && LA16_0<=342)||LA16_0==347) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPerl.g:2881:3: rule__PerlDocument__ElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__PerlDocument__ElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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


    // $ANTLR start "rule__ExpressionStatement__Group__0"
    // InternalPerl.g:2890:1: rule__ExpressionStatement__Group__0 : rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1 ;
    public final void rule__ExpressionStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2894:1: ( rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1 )
            // InternalPerl.g:2895:2: rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ExpressionStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExpressionStatement__Group__1();

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
    // $ANTLR end "rule__ExpressionStatement__Group__0"


    // $ANTLR start "rule__ExpressionStatement__Group__0__Impl"
    // InternalPerl.g:2902:1: rule__ExpressionStatement__Group__0__Impl : ( ( rule__ExpressionStatement__Alternatives_0 ) ) ;
    public final void rule__ExpressionStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2906:1: ( ( ( rule__ExpressionStatement__Alternatives_0 ) ) )
            // InternalPerl.g:2907:1: ( ( rule__ExpressionStatement__Alternatives_0 ) )
            {
            // InternalPerl.g:2907:1: ( ( rule__ExpressionStatement__Alternatives_0 ) )
            // InternalPerl.g:2908:2: ( rule__ExpressionStatement__Alternatives_0 )
            {
             before(grammarAccess.getExpressionStatementAccess().getAlternatives_0()); 
            // InternalPerl.g:2909:2: ( rule__ExpressionStatement__Alternatives_0 )
            // InternalPerl.g:2909:3: rule__ExpressionStatement__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionStatement__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionStatementAccess().getAlternatives_0()); 

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
    // $ANTLR end "rule__ExpressionStatement__Group__0__Impl"


    // $ANTLR start "rule__ExpressionStatement__Group__1"
    // InternalPerl.g:2917:1: rule__ExpressionStatement__Group__1 : rule__ExpressionStatement__Group__1__Impl ;
    public final void rule__ExpressionStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2921:1: ( rule__ExpressionStatement__Group__1__Impl )
            // InternalPerl.g:2922:2: rule__ExpressionStatement__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionStatement__Group__1__Impl();

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
    // $ANTLR end "rule__ExpressionStatement__Group__1"


    // $ANTLR start "rule__ExpressionStatement__Group__1__Impl"
    // InternalPerl.g:2928:1: rule__ExpressionStatement__Group__1__Impl : ( ';' ) ;
    public final void rule__ExpressionStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2932:1: ( ( ';' ) )
            // InternalPerl.g:2933:1: ( ';' )
            {
            // InternalPerl.g:2933:1: ( ';' )
            // InternalPerl.g:2934:2: ';'
            {
             before(grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1()); 

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
    // $ANTLR end "rule__ExpressionStatement__Group__1__Impl"


    // $ANTLR start "rule__PackageStatement__Group__0"
    // InternalPerl.g:2944:1: rule__PackageStatement__Group__0 : rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 ;
    public final void rule__PackageStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2948:1: ( rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 )
            // InternalPerl.g:2949:2: rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1
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
    // InternalPerl.g:2956:1: rule__PackageStatement__Group__0__Impl : ( () ) ;
    public final void rule__PackageStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2960:1: ( ( () ) )
            // InternalPerl.g:2961:1: ( () )
            {
            // InternalPerl.g:2961:1: ( () )
            // InternalPerl.g:2962:2: ()
            {
             before(grammarAccess.getPackageStatementAccess().getPackageStatementAction_0()); 
            // InternalPerl.g:2963:2: ()
            // InternalPerl.g:2963:3: 
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
    // InternalPerl.g:2971:1: rule__PackageStatement__Group__1 : rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 ;
    public final void rule__PackageStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2975:1: ( rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 )
            // InternalPerl.g:2976:2: rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2
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
    // InternalPerl.g:2983:1: rule__PackageStatement__Group__1__Impl : ( 'package' ) ;
    public final void rule__PackageStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2987:1: ( ( 'package' ) )
            // InternalPerl.g:2988:1: ( 'package' )
            {
            // InternalPerl.g:2988:1: ( 'package' )
            // InternalPerl.g:2989:2: 'package'
            {
             before(grammarAccess.getPackageStatementAccess().getPackageKeyword_1()); 
            match(input,153,FOLLOW_2); 
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
    // InternalPerl.g:2998:1: rule__PackageStatement__Group__2 : rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3 ;
    public final void rule__PackageStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3002:1: ( rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3 )
            // InternalPerl.g:3003:2: rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3
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
    // InternalPerl.g:3010:1: rule__PackageStatement__Group__2__Impl : ( ( rule__PackageStatement__NameAssignment_2 ) ) ;
    public final void rule__PackageStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3014:1: ( ( ( rule__PackageStatement__NameAssignment_2 ) ) )
            // InternalPerl.g:3015:1: ( ( rule__PackageStatement__NameAssignment_2 ) )
            {
            // InternalPerl.g:3015:1: ( ( rule__PackageStatement__NameAssignment_2 ) )
            // InternalPerl.g:3016:2: ( rule__PackageStatement__NameAssignment_2 )
            {
             before(grammarAccess.getPackageStatementAccess().getNameAssignment_2()); 
            // InternalPerl.g:3017:2: ( rule__PackageStatement__NameAssignment_2 )
            // InternalPerl.g:3017:3: rule__PackageStatement__NameAssignment_2
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
    // InternalPerl.g:3025:1: rule__PackageStatement__Group__3 : rule__PackageStatement__Group__3__Impl ;
    public final void rule__PackageStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3029:1: ( rule__PackageStatement__Group__3__Impl )
            // InternalPerl.g:3030:2: rule__PackageStatement__Group__3__Impl
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
    // InternalPerl.g:3036:1: rule__PackageStatement__Group__3__Impl : ( ( rule__PackageStatement__VersionAssignment_3 )? ) ;
    public final void rule__PackageStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3040:1: ( ( ( rule__PackageStatement__VersionAssignment_3 )? ) )
            // InternalPerl.g:3041:1: ( ( rule__PackageStatement__VersionAssignment_3 )? )
            {
            // InternalPerl.g:3041:1: ( ( rule__PackageStatement__VersionAssignment_3 )? )
            // InternalPerl.g:3042:2: ( rule__PackageStatement__VersionAssignment_3 )?
            {
             before(grammarAccess.getPackageStatementAccess().getVersionAssignment_3()); 
            // InternalPerl.g:3043:2: ( rule__PackageStatement__VersionAssignment_3 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_VERSION) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalPerl.g:3043:3: rule__PackageStatement__VersionAssignment_3
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
    // InternalPerl.g:3052:1: rule__RequireInclude__Group__0 : rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1 ;
    public final void rule__RequireInclude__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3056:1: ( rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1 )
            // InternalPerl.g:3057:2: rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1
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
    // InternalPerl.g:3064:1: rule__RequireInclude__Group__0__Impl : ( 'require' ) ;
    public final void rule__RequireInclude__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3068:1: ( ( 'require' ) )
            // InternalPerl.g:3069:1: ( 'require' )
            {
            // InternalPerl.g:3069:1: ( 'require' )
            // InternalPerl.g:3070:2: 'require'
            {
             before(grammarAccess.getRequireIncludeAccess().getRequireKeyword_0()); 
            match(input,172,FOLLOW_2); 
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
    // InternalPerl.g:3079:1: rule__RequireInclude__Group__1 : rule__RequireInclude__Group__1__Impl ;
    public final void rule__RequireInclude__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3083:1: ( rule__RequireInclude__Group__1__Impl )
            // InternalPerl.g:3084:2: rule__RequireInclude__Group__1__Impl
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
    // InternalPerl.g:3090:1: rule__RequireInclude__Group__1__Impl : ( ( rule__RequireInclude__VersionAssignment_1 ) ) ;
    public final void rule__RequireInclude__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3094:1: ( ( ( rule__RequireInclude__VersionAssignment_1 ) ) )
            // InternalPerl.g:3095:1: ( ( rule__RequireInclude__VersionAssignment_1 ) )
            {
            // InternalPerl.g:3095:1: ( ( rule__RequireInclude__VersionAssignment_1 ) )
            // InternalPerl.g:3096:2: ( rule__RequireInclude__VersionAssignment_1 )
            {
             before(grammarAccess.getRequireIncludeAccess().getVersionAssignment_1()); 
            // InternalPerl.g:3097:2: ( rule__RequireInclude__VersionAssignment_1 )
            // InternalPerl.g:3097:3: rule__RequireInclude__VersionAssignment_1
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
    // InternalPerl.g:3106:1: rule__UseInclude__Group__0 : rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1 ;
    public final void rule__UseInclude__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3110:1: ( rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1 )
            // InternalPerl.g:3111:2: rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1
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
    // InternalPerl.g:3118:1: rule__UseInclude__Group__0__Impl : ( () ) ;
    public final void rule__UseInclude__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3122:1: ( ( () ) )
            // InternalPerl.g:3123:1: ( () )
            {
            // InternalPerl.g:3123:1: ( () )
            // InternalPerl.g:3124:2: ()
            {
             before(grammarAccess.getUseIncludeAccess().getUseIncludeAction_0()); 
            // InternalPerl.g:3125:2: ()
            // InternalPerl.g:3125:3: 
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
    // InternalPerl.g:3133:1: rule__UseInclude__Group__1 : rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2 ;
    public final void rule__UseInclude__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3137:1: ( rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2 )
            // InternalPerl.g:3138:2: rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2
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
    // InternalPerl.g:3145:1: rule__UseInclude__Group__1__Impl : ( 'use' ) ;
    public final void rule__UseInclude__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3149:1: ( ( 'use' ) )
            // InternalPerl.g:3150:1: ( 'use' )
            {
            // InternalPerl.g:3150:1: ( 'use' )
            // InternalPerl.g:3151:2: 'use'
            {
             before(grammarAccess.getUseIncludeAccess().getUseKeyword_1()); 
            match(input,243,FOLLOW_2); 
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
    // InternalPerl.g:3160:1: rule__UseInclude__Group__2 : rule__UseInclude__Group__2__Impl ;
    public final void rule__UseInclude__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3164:1: ( rule__UseInclude__Group__2__Impl )
            // InternalPerl.g:3165:2: rule__UseInclude__Group__2__Impl
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
    // InternalPerl.g:3171:1: rule__UseInclude__Group__2__Impl : ( ( rule__UseInclude__Alternatives_2 ) ) ;
    public final void rule__UseInclude__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3175:1: ( ( ( rule__UseInclude__Alternatives_2 ) ) )
            // InternalPerl.g:3176:1: ( ( rule__UseInclude__Alternatives_2 ) )
            {
            // InternalPerl.g:3176:1: ( ( rule__UseInclude__Alternatives_2 ) )
            // InternalPerl.g:3177:2: ( rule__UseInclude__Alternatives_2 )
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2()); 
            // InternalPerl.g:3178:2: ( rule__UseInclude__Alternatives_2 )
            // InternalPerl.g:3178:3: rule__UseInclude__Alternatives_2
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
    // InternalPerl.g:3187:1: rule__UseInclude__Group_2_1__0 : rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1 ;
    public final void rule__UseInclude__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3191:1: ( rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1 )
            // InternalPerl.g:3192:2: rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1
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
    // InternalPerl.g:3199:1: rule__UseInclude__Group_2_1__0__Impl : ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) ) ;
    public final void rule__UseInclude__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3203:1: ( ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) ) )
            // InternalPerl.g:3204:1: ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) )
            {
            // InternalPerl.g:3204:1: ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) )
            // InternalPerl.g:3205:2: ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 )
            {
             before(grammarAccess.getUseIncludeAccess().getPragmaOrPackageAssignment_2_1_0()); 
            // InternalPerl.g:3206:2: ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 )
            // InternalPerl.g:3206:3: rule__UseInclude__PragmaOrPackageAssignment_2_1_0
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
    // InternalPerl.g:3214:1: rule__UseInclude__Group_2_1__1 : rule__UseInclude__Group_2_1__1__Impl ;
    public final void rule__UseInclude__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3218:1: ( rule__UseInclude__Group_2_1__1__Impl )
            // InternalPerl.g:3219:2: rule__UseInclude__Group_2_1__1__Impl
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
    // InternalPerl.g:3225:1: rule__UseInclude__Group_2_1__1__Impl : ( ( rule__UseInclude__Alternatives_2_1_1 )? ) ;
    public final void rule__UseInclude__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3229:1: ( ( ( rule__UseInclude__Alternatives_2_1_1 )? ) )
            // InternalPerl.g:3230:1: ( ( rule__UseInclude__Alternatives_2_1_1 )? )
            {
            // InternalPerl.g:3230:1: ( ( rule__UseInclude__Alternatives_2_1_1 )? )
            // InternalPerl.g:3231:2: ( rule__UseInclude__Alternatives_2_1_1 )?
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2_1_1()); 
            // InternalPerl.g:3232:2: ( rule__UseInclude__Alternatives_2_1_1 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_LITERAL)||LA18_0==RULE_WORDS_QUOTE_LIKE) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalPerl.g:3232:3: rule__UseInclude__Alternatives_2_1_1
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


    // $ANTLR start "rule__SubStatement__Group__0"
    // InternalPerl.g:3241:1: rule__SubStatement__Group__0 : rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1 ;
    public final void rule__SubStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3245:1: ( rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1 )
            // InternalPerl.g:3246:2: rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__SubStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubStatement__Group__1();

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
    // $ANTLR end "rule__SubStatement__Group__0"


    // $ANTLR start "rule__SubStatement__Group__0__Impl"
    // InternalPerl.g:3253:1: rule__SubStatement__Group__0__Impl : ( () ) ;
    public final void rule__SubStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3257:1: ( ( () ) )
            // InternalPerl.g:3258:1: ( () )
            {
            // InternalPerl.g:3258:1: ( () )
            // InternalPerl.g:3259:2: ()
            {
             before(grammarAccess.getSubStatementAccess().getSubStatementAction_0()); 
            // InternalPerl.g:3260:2: ()
            // InternalPerl.g:3260:3: 
            {
            }

             after(grammarAccess.getSubStatementAccess().getSubStatementAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubStatement__Group__0__Impl"


    // $ANTLR start "rule__SubStatement__Group__1"
    // InternalPerl.g:3268:1: rule__SubStatement__Group__1 : rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2 ;
    public final void rule__SubStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3272:1: ( rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2 )
            // InternalPerl.g:3273:2: rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__SubStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubStatement__Group__2();

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
    // $ANTLR end "rule__SubStatement__Group__1"


    // $ANTLR start "rule__SubStatement__Group__1__Impl"
    // InternalPerl.g:3280:1: rule__SubStatement__Group__1__Impl : ( 'sub' ) ;
    public final void rule__SubStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3284:1: ( ( 'sub' ) )
            // InternalPerl.g:3285:1: ( 'sub' )
            {
            // InternalPerl.g:3285:1: ( 'sub' )
            // InternalPerl.g:3286:2: 'sub'
            {
             before(grammarAccess.getSubStatementAccess().getSubKeyword_1()); 
            match(input,216,FOLLOW_2); 
             after(grammarAccess.getSubStatementAccess().getSubKeyword_1()); 

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
    // $ANTLR end "rule__SubStatement__Group__1__Impl"


    // $ANTLR start "rule__SubStatement__Group__2"
    // InternalPerl.g:3295:1: rule__SubStatement__Group__2 : rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3 ;
    public final void rule__SubStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3299:1: ( rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3 )
            // InternalPerl.g:3300:2: rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__SubStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubStatement__Group__3();

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
    // $ANTLR end "rule__SubStatement__Group__2"


    // $ANTLR start "rule__SubStatement__Group__2__Impl"
    // InternalPerl.g:3307:1: rule__SubStatement__Group__2__Impl : ( ( rule__SubStatement__NameAssignment_2 ) ) ;
    public final void rule__SubStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3311:1: ( ( ( rule__SubStatement__NameAssignment_2 ) ) )
            // InternalPerl.g:3312:1: ( ( rule__SubStatement__NameAssignment_2 ) )
            {
            // InternalPerl.g:3312:1: ( ( rule__SubStatement__NameAssignment_2 ) )
            // InternalPerl.g:3313:2: ( rule__SubStatement__NameAssignment_2 )
            {
             before(grammarAccess.getSubStatementAccess().getNameAssignment_2()); 
            // InternalPerl.g:3314:2: ( rule__SubStatement__NameAssignment_2 )
            // InternalPerl.g:3314:3: rule__SubStatement__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SubStatement__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSubStatementAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__SubStatement__Group__2__Impl"


    // $ANTLR start "rule__SubStatement__Group__3"
    // InternalPerl.g:3322:1: rule__SubStatement__Group__3 : rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4 ;
    public final void rule__SubStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3326:1: ( rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4 )
            // InternalPerl.g:3327:2: rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__SubStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SubStatement__Group__4();

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
    // $ANTLR end "rule__SubStatement__Group__3"


    // $ANTLR start "rule__SubStatement__Group__3__Impl"
    // InternalPerl.g:3334:1: rule__SubStatement__Group__3__Impl : ( ( rule__SubStatement__PrototypeAssignment_3 )? ) ;
    public final void rule__SubStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3338:1: ( ( ( rule__SubStatement__PrototypeAssignment_3 )? ) )
            // InternalPerl.g:3339:1: ( ( rule__SubStatement__PrototypeAssignment_3 )? )
            {
            // InternalPerl.g:3339:1: ( ( rule__SubStatement__PrototypeAssignment_3 )? )
            // InternalPerl.g:3340:2: ( rule__SubStatement__PrototypeAssignment_3 )?
            {
             before(grammarAccess.getSubStatementAccess().getPrototypeAssignment_3()); 
            // InternalPerl.g:3341:2: ( rule__SubStatement__PrototypeAssignment_3 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==345) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalPerl.g:3341:3: rule__SubStatement__PrototypeAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__SubStatement__PrototypeAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubStatementAccess().getPrototypeAssignment_3()); 

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
    // $ANTLR end "rule__SubStatement__Group__3__Impl"


    // $ANTLR start "rule__SubStatement__Group__4"
    // InternalPerl.g:3349:1: rule__SubStatement__Group__4 : rule__SubStatement__Group__4__Impl ;
    public final void rule__SubStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3353:1: ( rule__SubStatement__Group__4__Impl )
            // InternalPerl.g:3354:2: rule__SubStatement__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SubStatement__Group__4__Impl();

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
    // $ANTLR end "rule__SubStatement__Group__4"


    // $ANTLR start "rule__SubStatement__Group__4__Impl"
    // InternalPerl.g:3360:1: rule__SubStatement__Group__4__Impl : ( ( rule__SubStatement__Alternatives_4 ) ) ;
    public final void rule__SubStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3364:1: ( ( ( rule__SubStatement__Alternatives_4 ) ) )
            // InternalPerl.g:3365:1: ( ( rule__SubStatement__Alternatives_4 ) )
            {
            // InternalPerl.g:3365:1: ( ( rule__SubStatement__Alternatives_4 ) )
            // InternalPerl.g:3366:2: ( rule__SubStatement__Alternatives_4 )
            {
             before(grammarAccess.getSubStatementAccess().getAlternatives_4()); 
            // InternalPerl.g:3367:2: ( rule__SubStatement__Alternatives_4 )
            // InternalPerl.g:3367:3: rule__SubStatement__Alternatives_4
            {
            pushFollow(FOLLOW_2);
            rule__SubStatement__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getSubStatementAccess().getAlternatives_4()); 

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
    // $ANTLR end "rule__SubStatement__Group__4__Impl"


    // $ANTLR start "rule__StatementBlock__Group__0"
    // InternalPerl.g:3376:1: rule__StatementBlock__Group__0 : rule__StatementBlock__Group__0__Impl rule__StatementBlock__Group__1 ;
    public final void rule__StatementBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3380:1: ( rule__StatementBlock__Group__0__Impl rule__StatementBlock__Group__1 )
            // InternalPerl.g:3381:2: rule__StatementBlock__Group__0__Impl rule__StatementBlock__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__StatementBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StatementBlock__Group__1();

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
    // $ANTLR end "rule__StatementBlock__Group__0"


    // $ANTLR start "rule__StatementBlock__Group__0__Impl"
    // InternalPerl.g:3388:1: rule__StatementBlock__Group__0__Impl : ( () ) ;
    public final void rule__StatementBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3392:1: ( ( () ) )
            // InternalPerl.g:3393:1: ( () )
            {
            // InternalPerl.g:3393:1: ( () )
            // InternalPerl.g:3394:2: ()
            {
             before(grammarAccess.getStatementBlockAccess().getStatementBlockAction_0()); 
            // InternalPerl.g:3395:2: ()
            // InternalPerl.g:3395:3: 
            {
            }

             after(grammarAccess.getStatementBlockAccess().getStatementBlockAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StatementBlock__Group__0__Impl"


    // $ANTLR start "rule__StatementBlock__Group__1"
    // InternalPerl.g:3403:1: rule__StatementBlock__Group__1 : rule__StatementBlock__Group__1__Impl rule__StatementBlock__Group__2 ;
    public final void rule__StatementBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3407:1: ( rule__StatementBlock__Group__1__Impl rule__StatementBlock__Group__2 )
            // InternalPerl.g:3408:2: rule__StatementBlock__Group__1__Impl rule__StatementBlock__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__StatementBlock__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StatementBlock__Group__2();

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
    // $ANTLR end "rule__StatementBlock__Group__1"


    // $ANTLR start "rule__StatementBlock__Group__1__Impl"
    // InternalPerl.g:3415:1: rule__StatementBlock__Group__1__Impl : ( '{' ) ;
    public final void rule__StatementBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3419:1: ( ( '{' ) )
            // InternalPerl.g:3420:1: ( '{' )
            {
            // InternalPerl.g:3420:1: ( '{' )
            // InternalPerl.g:3421:2: '{'
            {
             before(grammarAccess.getStatementBlockAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,343,FOLLOW_2); 
             after(grammarAccess.getStatementBlockAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__StatementBlock__Group__1__Impl"


    // $ANTLR start "rule__StatementBlock__Group__2"
    // InternalPerl.g:3430:1: rule__StatementBlock__Group__2 : rule__StatementBlock__Group__2__Impl rule__StatementBlock__Group__3 ;
    public final void rule__StatementBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3434:1: ( rule__StatementBlock__Group__2__Impl rule__StatementBlock__Group__3 )
            // InternalPerl.g:3435:2: rule__StatementBlock__Group__2__Impl rule__StatementBlock__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__StatementBlock__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StatementBlock__Group__3();

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
    // $ANTLR end "rule__StatementBlock__Group__2"


    // $ANTLR start "rule__StatementBlock__Group__2__Impl"
    // InternalPerl.g:3442:1: rule__StatementBlock__Group__2__Impl : ( ( rule__StatementBlock__StatementsAssignment_2 )* ) ;
    public final void rule__StatementBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3446:1: ( ( ( rule__StatementBlock__StatementsAssignment_2 )* ) )
            // InternalPerl.g:3447:1: ( ( rule__StatementBlock__StatementsAssignment_2 )* )
            {
            // InternalPerl.g:3447:1: ( ( rule__StatementBlock__StatementsAssignment_2 )* )
            // InternalPerl.g:3448:2: ( rule__StatementBlock__StatementsAssignment_2 )*
            {
             before(grammarAccess.getStatementBlockAccess().getStatementsAssignment_2()); 
            // InternalPerl.g:3449:2: ( rule__StatementBlock__StatementsAssignment_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==153||LA20_0==172||LA20_0==216||LA20_0==243) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalPerl.g:3449:3: rule__StatementBlock__StatementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__StatementBlock__StatementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getStatementBlockAccess().getStatementsAssignment_2()); 

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
    // $ANTLR end "rule__StatementBlock__Group__2__Impl"


    // $ANTLR start "rule__StatementBlock__Group__3"
    // InternalPerl.g:3457:1: rule__StatementBlock__Group__3 : rule__StatementBlock__Group__3__Impl ;
    public final void rule__StatementBlock__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3461:1: ( rule__StatementBlock__Group__3__Impl )
            // InternalPerl.g:3462:2: rule__StatementBlock__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StatementBlock__Group__3__Impl();

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
    // $ANTLR end "rule__StatementBlock__Group__3"


    // $ANTLR start "rule__StatementBlock__Group__3__Impl"
    // InternalPerl.g:3468:1: rule__StatementBlock__Group__3__Impl : ( '}' ) ;
    public final void rule__StatementBlock__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3472:1: ( ( '}' ) )
            // InternalPerl.g:3473:1: ( '}' )
            {
            // InternalPerl.g:3473:1: ( '}' )
            // InternalPerl.g:3474:2: '}'
            {
             before(grammarAccess.getStatementBlockAccess().getRightCurlyBracketKeyword_3()); 
            match(input,344,FOLLOW_2); 
             after(grammarAccess.getStatementBlockAccess().getRightCurlyBracketKeyword_3()); 

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
    // $ANTLR end "rule__StatementBlock__Group__3__Impl"


    // $ANTLR start "rule__Prototype__Group__0"
    // InternalPerl.g:3484:1: rule__Prototype__Group__0 : rule__Prototype__Group__0__Impl rule__Prototype__Group__1 ;
    public final void rule__Prototype__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3488:1: ( rule__Prototype__Group__0__Impl rule__Prototype__Group__1 )
            // InternalPerl.g:3489:2: rule__Prototype__Group__0__Impl rule__Prototype__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Prototype__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Prototype__Group__1();

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
    // $ANTLR end "rule__Prototype__Group__0"


    // $ANTLR start "rule__Prototype__Group__0__Impl"
    // InternalPerl.g:3496:1: rule__Prototype__Group__0__Impl : ( '(' ) ;
    public final void rule__Prototype__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3500:1: ( ( '(' ) )
            // InternalPerl.g:3501:1: ( '(' )
            {
            // InternalPerl.g:3501:1: ( '(' )
            // InternalPerl.g:3502:2: '('
            {
             before(grammarAccess.getPrototypeAccess().getLeftParenthesisKeyword_0()); 
            match(input,345,FOLLOW_2); 
             after(grammarAccess.getPrototypeAccess().getLeftParenthesisKeyword_0()); 

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
    // $ANTLR end "rule__Prototype__Group__0__Impl"


    // $ANTLR start "rule__Prototype__Group__1"
    // InternalPerl.g:3511:1: rule__Prototype__Group__1 : rule__Prototype__Group__1__Impl rule__Prototype__Group__2 ;
    public final void rule__Prototype__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3515:1: ( rule__Prototype__Group__1__Impl rule__Prototype__Group__2 )
            // InternalPerl.g:3516:2: rule__Prototype__Group__1__Impl rule__Prototype__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__Prototype__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Prototype__Group__2();

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
    // $ANTLR end "rule__Prototype__Group__1"


    // $ANTLR start "rule__Prototype__Group__1__Impl"
    // InternalPerl.g:3523:1: rule__Prototype__Group__1__Impl : ( ( rule__Prototype__Alternatives_1 )* ) ;
    public final void rule__Prototype__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3527:1: ( ( ( rule__Prototype__Alternatives_1 )* ) )
            // InternalPerl.g:3528:1: ( ( rule__Prototype__Alternatives_1 )* )
            {
            // InternalPerl.g:3528:1: ( ( rule__Prototype__Alternatives_1 )* )
            // InternalPerl.g:3529:2: ( rule__Prototype__Alternatives_1 )*
            {
             before(grammarAccess.getPrototypeAccess().getAlternatives_1()); 
            // InternalPerl.g:3530:2: ( rule__Prototype__Alternatives_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=28 && LA21_0<=32)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalPerl.g:3530:3: rule__Prototype__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Prototype__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getPrototypeAccess().getAlternatives_1()); 

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
    // $ANTLR end "rule__Prototype__Group__1__Impl"


    // $ANTLR start "rule__Prototype__Group__2"
    // InternalPerl.g:3538:1: rule__Prototype__Group__2 : rule__Prototype__Group__2__Impl ;
    public final void rule__Prototype__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3542:1: ( rule__Prototype__Group__2__Impl )
            // InternalPerl.g:3543:2: rule__Prototype__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Prototype__Group__2__Impl();

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
    // $ANTLR end "rule__Prototype__Group__2"


    // $ANTLR start "rule__Prototype__Group__2__Impl"
    // InternalPerl.g:3549:1: rule__Prototype__Group__2__Impl : ( ')' ) ;
    public final void rule__Prototype__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3553:1: ( ( ')' ) )
            // InternalPerl.g:3554:1: ( ')' )
            {
            // InternalPerl.g:3554:1: ( ')' )
            // InternalPerl.g:3555:2: ')'
            {
             before(grammarAccess.getPrototypeAccess().getRightParenthesisKeyword_2()); 
            match(input,346,FOLLOW_2); 
             after(grammarAccess.getPrototypeAccess().getRightParenthesisKeyword_2()); 

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
    // $ANTLR end "rule__Prototype__Group__2__Impl"


    // $ANTLR start "rule__Token__Group_0__0"
    // InternalPerl.g:3565:1: rule__Token__Group_0__0 : rule__Token__Group_0__0__Impl rule__Token__Group_0__1 ;
    public final void rule__Token__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3569:1: ( rule__Token__Group_0__0__Impl rule__Token__Group_0__1 )
            // InternalPerl.g:3570:2: rule__Token__Group_0__0__Impl rule__Token__Group_0__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalPerl.g:3577:1: rule__Token__Group_0__0__Impl : ( () ) ;
    public final void rule__Token__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3581:1: ( ( () ) )
            // InternalPerl.g:3582:1: ( () )
            {
            // InternalPerl.g:3582:1: ( () )
            // InternalPerl.g:3583:2: ()
            {
             before(grammarAccess.getTokenAccess().getPodTokenAction_0_0()); 
            // InternalPerl.g:3584:2: ()
            // InternalPerl.g:3584:3: 
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
    // InternalPerl.g:3592:1: rule__Token__Group_0__1 : rule__Token__Group_0__1__Impl ;
    public final void rule__Token__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3596:1: ( rule__Token__Group_0__1__Impl )
            // InternalPerl.g:3597:2: rule__Token__Group_0__1__Impl
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
    // InternalPerl.g:3603:1: rule__Token__Group_0__1__Impl : ( ( rule__Token__ContentAssignment_0_1 ) ) ;
    public final void rule__Token__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3607:1: ( ( ( rule__Token__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:3608:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:3608:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            // InternalPerl.g:3609:2: ( rule__Token__ContentAssignment_0_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:3610:2: ( rule__Token__ContentAssignment_0_1 )
            // InternalPerl.g:3610:3: rule__Token__ContentAssignment_0_1
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
    // InternalPerl.g:3619:1: rule__Token__Group_1__0 : rule__Token__Group_1__0__Impl rule__Token__Group_1__1 ;
    public final void rule__Token__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3623:1: ( rule__Token__Group_1__0__Impl rule__Token__Group_1__1 )
            // InternalPerl.g:3624:2: rule__Token__Group_1__0__Impl rule__Token__Group_1__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalPerl.g:3631:1: rule__Token__Group_1__0__Impl : ( () ) ;
    public final void rule__Token__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3635:1: ( ( () ) )
            // InternalPerl.g:3636:1: ( () )
            {
            // InternalPerl.g:3636:1: ( () )
            // InternalPerl.g:3637:2: ()
            {
             before(grammarAccess.getTokenAccess().getNumberTokenAction_1_0()); 
            // InternalPerl.g:3638:2: ()
            // InternalPerl.g:3638:3: 
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
    // InternalPerl.g:3646:1: rule__Token__Group_1__1 : rule__Token__Group_1__1__Impl ;
    public final void rule__Token__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3650:1: ( rule__Token__Group_1__1__Impl )
            // InternalPerl.g:3651:2: rule__Token__Group_1__1__Impl
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
    // InternalPerl.g:3657:1: rule__Token__Group_1__1__Impl : ( ( rule__Token__ContentAssignment_1_1 ) ) ;
    public final void rule__Token__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3661:1: ( ( ( rule__Token__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:3662:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:3662:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            // InternalPerl.g:3663:2: ( rule__Token__ContentAssignment_1_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:3664:2: ( rule__Token__ContentAssignment_1_1 )
            // InternalPerl.g:3664:3: rule__Token__ContentAssignment_1_1
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
    // InternalPerl.g:3673:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3677:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // InternalPerl.g:3678:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalPerl.g:3685:1: rule__Token__Group_2__0__Impl : ( () ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3689:1: ( ( () ) )
            // InternalPerl.g:3690:1: ( () )
            {
            // InternalPerl.g:3690:1: ( () )
            // InternalPerl.g:3691:2: ()
            {
             before(grammarAccess.getTokenAccess().getWordTokenAction_2_0()); 
            // InternalPerl.g:3692:2: ()
            // InternalPerl.g:3692:3: 
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
    // InternalPerl.g:3700:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3704:1: ( rule__Token__Group_2__1__Impl )
            // InternalPerl.g:3705:2: rule__Token__Group_2__1__Impl
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
    // InternalPerl.g:3711:1: rule__Token__Group_2__1__Impl : ( ( rule__Token__ContentAssignment_2_1 ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3715:1: ( ( ( rule__Token__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:3716:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:3716:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            // InternalPerl.g:3717:2: ( rule__Token__ContentAssignment_2_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:3718:2: ( rule__Token__ContentAssignment_2_1 )
            // InternalPerl.g:3718:3: rule__Token__ContentAssignment_2_1
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
    // InternalPerl.g:3727:1: rule__Token__Group_3__0 : rule__Token__Group_3__0__Impl rule__Token__Group_3__1 ;
    public final void rule__Token__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3731:1: ( rule__Token__Group_3__0__Impl rule__Token__Group_3__1 )
            // InternalPerl.g:3732:2: rule__Token__Group_3__0__Impl rule__Token__Group_3__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalPerl.g:3739:1: rule__Token__Group_3__0__Impl : ( () ) ;
    public final void rule__Token__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3743:1: ( ( () ) )
            // InternalPerl.g:3744:1: ( () )
            {
            // InternalPerl.g:3744:1: ( () )
            // InternalPerl.g:3745:2: ()
            {
             before(grammarAccess.getTokenAccess().getSymbolTokenAction_3_0()); 
            // InternalPerl.g:3746:2: ()
            // InternalPerl.g:3746:3: 
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
    // InternalPerl.g:3754:1: rule__Token__Group_3__1 : rule__Token__Group_3__1__Impl ;
    public final void rule__Token__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3758:1: ( rule__Token__Group_3__1__Impl )
            // InternalPerl.g:3759:2: rule__Token__Group_3__1__Impl
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
    // InternalPerl.g:3765:1: rule__Token__Group_3__1__Impl : ( ( rule__Token__ContentAssignment_3_1 ) ) ;
    public final void rule__Token__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3769:1: ( ( ( rule__Token__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:3770:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:3770:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            // InternalPerl.g:3771:2: ( rule__Token__ContentAssignment_3_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:3772:2: ( rule__Token__ContentAssignment_3_1 )
            // InternalPerl.g:3772:3: rule__Token__ContentAssignment_3_1
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
    // InternalPerl.g:3781:1: rule__Token__Group_5__0 : rule__Token__Group_5__0__Impl rule__Token__Group_5__1 ;
    public final void rule__Token__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3785:1: ( rule__Token__Group_5__0__Impl rule__Token__Group_5__1 )
            // InternalPerl.g:3786:2: rule__Token__Group_5__0__Impl rule__Token__Group_5__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalPerl.g:3793:1: rule__Token__Group_5__0__Impl : ( () ) ;
    public final void rule__Token__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3797:1: ( ( () ) )
            // InternalPerl.g:3798:1: ( () )
            {
            // InternalPerl.g:3798:1: ( () )
            // InternalPerl.g:3799:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_5_0()); 
            // InternalPerl.g:3800:2: ()
            // InternalPerl.g:3800:3: 
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
    // InternalPerl.g:3808:1: rule__Token__Group_5__1 : rule__Token__Group_5__1__Impl ;
    public final void rule__Token__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3812:1: ( rule__Token__Group_5__1__Impl )
            // InternalPerl.g:3813:2: rule__Token__Group_5__1__Impl
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
    // InternalPerl.g:3819:1: rule__Token__Group_5__1__Impl : ( ( rule__Token__ContentAssignment_5_1 ) ) ;
    public final void rule__Token__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3823:1: ( ( ( rule__Token__ContentAssignment_5_1 ) ) )
            // InternalPerl.g:3824:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            {
            // InternalPerl.g:3824:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            // InternalPerl.g:3825:2: ( rule__Token__ContentAssignment_5_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_5_1()); 
            // InternalPerl.g:3826:2: ( rule__Token__ContentAssignment_5_1 )
            // InternalPerl.g:3826:3: rule__Token__ContentAssignment_5_1
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
    // InternalPerl.g:3835:1: rule__Token__Group_6__0 : rule__Token__Group_6__0__Impl rule__Token__Group_6__1 ;
    public final void rule__Token__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3839:1: ( rule__Token__Group_6__0__Impl rule__Token__Group_6__1 )
            // InternalPerl.g:3840:2: rule__Token__Group_6__0__Impl rule__Token__Group_6__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalPerl.g:3847:1: rule__Token__Group_6__0__Impl : ( () ) ;
    public final void rule__Token__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3851:1: ( ( () ) )
            // InternalPerl.g:3852:1: ( () )
            {
            // InternalPerl.g:3852:1: ( () )
            // InternalPerl.g:3853:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_6_0()); 
            // InternalPerl.g:3854:2: ()
            // InternalPerl.g:3854:3: 
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
    // InternalPerl.g:3862:1: rule__Token__Group_6__1 : rule__Token__Group_6__1__Impl ;
    public final void rule__Token__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3866:1: ( rule__Token__Group_6__1__Impl )
            // InternalPerl.g:3867:2: rule__Token__Group_6__1__Impl
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
    // InternalPerl.g:3873:1: rule__Token__Group_6__1__Impl : ( ( rule__Token__ContentAssignment_6_1 ) ) ;
    public final void rule__Token__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3877:1: ( ( ( rule__Token__ContentAssignment_6_1 ) ) )
            // InternalPerl.g:3878:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            {
            // InternalPerl.g:3878:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            // InternalPerl.g:3879:2: ( rule__Token__ContentAssignment_6_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_6_1()); 
            // InternalPerl.g:3880:2: ( rule__Token__ContentAssignment_6_1 )
            // InternalPerl.g:3880:3: rule__Token__ContentAssignment_6_1
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


    // $ANTLR start "rule__Token__Group_9__0"
    // InternalPerl.g:3889:1: rule__Token__Group_9__0 : rule__Token__Group_9__0__Impl rule__Token__Group_9__1 ;
    public final void rule__Token__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3893:1: ( rule__Token__Group_9__0__Impl rule__Token__Group_9__1 )
            // InternalPerl.g:3894:2: rule__Token__Group_9__0__Impl rule__Token__Group_9__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalPerl.g:3901:1: rule__Token__Group_9__0__Impl : ( () ) ;
    public final void rule__Token__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3905:1: ( ( () ) )
            // InternalPerl.g:3906:1: ( () )
            {
            // InternalPerl.g:3906:1: ( () )
            // InternalPerl.g:3907:2: ()
            {
             before(grammarAccess.getTokenAccess().getDataTokenAction_9_0()); 
            // InternalPerl.g:3908:2: ()
            // InternalPerl.g:3908:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getDataTokenAction_9_0()); 

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
    // InternalPerl.g:3916:1: rule__Token__Group_9__1 : rule__Token__Group_9__1__Impl ;
    public final void rule__Token__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3920:1: ( rule__Token__Group_9__1__Impl )
            // InternalPerl.g:3921:2: rule__Token__Group_9__1__Impl
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
    // InternalPerl.g:3927:1: rule__Token__Group_9__1__Impl : ( ( rule__Token__ContentAssignment_9_1 ) ) ;
    public final void rule__Token__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3931:1: ( ( ( rule__Token__ContentAssignment_9_1 ) ) )
            // InternalPerl.g:3932:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            {
            // InternalPerl.g:3932:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            // InternalPerl.g:3933:2: ( rule__Token__ContentAssignment_9_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_9_1()); 
            // InternalPerl.g:3934:2: ( rule__Token__ContentAssignment_9_1 )
            // InternalPerl.g:3934:3: rule__Token__ContentAssignment_9_1
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


    // $ANTLR start "rule__Token__Group_10__0"
    // InternalPerl.g:3943:1: rule__Token__Group_10__0 : rule__Token__Group_10__0__Impl rule__Token__Group_10__1 ;
    public final void rule__Token__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3947:1: ( rule__Token__Group_10__0__Impl rule__Token__Group_10__1 )
            // InternalPerl.g:3948:2: rule__Token__Group_10__0__Impl rule__Token__Group_10__1
            {
            pushFollow(FOLLOW_3);
            rule__Token__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_10__1();

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
    // $ANTLR end "rule__Token__Group_10__0"


    // $ANTLR start "rule__Token__Group_10__0__Impl"
    // InternalPerl.g:3955:1: rule__Token__Group_10__0__Impl : ( () ) ;
    public final void rule__Token__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3959:1: ( ( () ) )
            // InternalPerl.g:3960:1: ( () )
            {
            // InternalPerl.g:3960:1: ( () )
            // InternalPerl.g:3961:2: ()
            {
             before(grammarAccess.getTokenAccess().getEndTokenAction_10_0()); 
            // InternalPerl.g:3962:2: ()
            // InternalPerl.g:3962:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getEndTokenAction_10_0()); 

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
    // InternalPerl.g:3970:1: rule__Token__Group_10__1 : rule__Token__Group_10__1__Impl ;
    public final void rule__Token__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3974:1: ( rule__Token__Group_10__1__Impl )
            // InternalPerl.g:3975:2: rule__Token__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_10__1__Impl();

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
    // $ANTLR end "rule__Token__Group_10__1"


    // $ANTLR start "rule__Token__Group_10__1__Impl"
    // InternalPerl.g:3981:1: rule__Token__Group_10__1__Impl : ( ( rule__Token__ContentAssignment_10_1 ) ) ;
    public final void rule__Token__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3985:1: ( ( ( rule__Token__ContentAssignment_10_1 ) ) )
            // InternalPerl.g:3986:1: ( ( rule__Token__ContentAssignment_10_1 ) )
            {
            // InternalPerl.g:3986:1: ( ( rule__Token__ContentAssignment_10_1 ) )
            // InternalPerl.g:3987:2: ( rule__Token__ContentAssignment_10_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_10_1()); 
            // InternalPerl.g:3988:2: ( rule__Token__ContentAssignment_10_1 )
            // InternalPerl.g:3988:3: rule__Token__ContentAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_10_1()); 

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


    // $ANTLR start "rule__RegexToken__Group__0"
    // InternalPerl.g:3997:1: rule__RegexToken__Group__0 : rule__RegexToken__Group__0__Impl rule__RegexToken__Group__1 ;
    public final void rule__RegexToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4001:1: ( rule__RegexToken__Group__0__Impl rule__RegexToken__Group__1 )
            // InternalPerl.g:4002:2: rule__RegexToken__Group__0__Impl rule__RegexToken__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__RegexToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RegexToken__Group__1();

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
    // $ANTLR end "rule__RegexToken__Group__0"


    // $ANTLR start "rule__RegexToken__Group__0__Impl"
    // InternalPerl.g:4009:1: rule__RegexToken__Group__0__Impl : ( () ) ;
    public final void rule__RegexToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4013:1: ( ( () ) )
            // InternalPerl.g:4014:1: ( () )
            {
            // InternalPerl.g:4014:1: ( () )
            // InternalPerl.g:4015:2: ()
            {
             before(grammarAccess.getRegexTokenAccess().getRegexTokenAction_0()); 
            // InternalPerl.g:4016:2: ()
            // InternalPerl.g:4016:3: 
            {
            }

             after(grammarAccess.getRegexTokenAccess().getRegexTokenAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexToken__Group__0__Impl"


    // $ANTLR start "rule__RegexToken__Group__1"
    // InternalPerl.g:4024:1: rule__RegexToken__Group__1 : rule__RegexToken__Group__1__Impl ;
    public final void rule__RegexToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4028:1: ( rule__RegexToken__Group__1__Impl )
            // InternalPerl.g:4029:2: rule__RegexToken__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RegexToken__Group__1__Impl();

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
    // $ANTLR end "rule__RegexToken__Group__1"


    // $ANTLR start "rule__RegexToken__Group__1__Impl"
    // InternalPerl.g:4035:1: rule__RegexToken__Group__1__Impl : ( ( rule__RegexToken__ContentAssignment_1 ) ) ;
    public final void rule__RegexToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4039:1: ( ( ( rule__RegexToken__ContentAssignment_1 ) ) )
            // InternalPerl.g:4040:1: ( ( rule__RegexToken__ContentAssignment_1 ) )
            {
            // InternalPerl.g:4040:1: ( ( rule__RegexToken__ContentAssignment_1 ) )
            // InternalPerl.g:4041:2: ( rule__RegexToken__ContentAssignment_1 )
            {
             before(grammarAccess.getRegexTokenAccess().getContentAssignment_1()); 
            // InternalPerl.g:4042:2: ( rule__RegexToken__ContentAssignment_1 )
            // InternalPerl.g:4042:3: rule__RegexToken__ContentAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RegexToken__ContentAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRegexTokenAccess().getContentAssignment_1()); 

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
    // $ANTLR end "rule__RegexToken__Group__1__Impl"


    // $ANTLR start "rule__QuoteToken__Group__0"
    // InternalPerl.g:4051:1: rule__QuoteToken__Group__0 : rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 ;
    public final void rule__QuoteToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4055:1: ( rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 )
            // InternalPerl.g:4056:2: rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalPerl.g:4063:1: rule__QuoteToken__Group__0__Impl : ( () ) ;
    public final void rule__QuoteToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4067:1: ( ( () ) )
            // InternalPerl.g:4068:1: ( () )
            {
            // InternalPerl.g:4068:1: ( () )
            // InternalPerl.g:4069:2: ()
            {
             before(grammarAccess.getQuoteTokenAccess().getQuoteTokenAction_0()); 
            // InternalPerl.g:4070:2: ()
            // InternalPerl.g:4070:3: 
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
    // InternalPerl.g:4078:1: rule__QuoteToken__Group__1 : rule__QuoteToken__Group__1__Impl ;
    public final void rule__QuoteToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4082:1: ( rule__QuoteToken__Group__1__Impl )
            // InternalPerl.g:4083:2: rule__QuoteToken__Group__1__Impl
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
    // InternalPerl.g:4089:1: rule__QuoteToken__Group__1__Impl : ( ( rule__QuoteToken__ContentAssignment_1 ) ) ;
    public final void rule__QuoteToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4093:1: ( ( ( rule__QuoteToken__ContentAssignment_1 ) ) )
            // InternalPerl.g:4094:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            {
            // InternalPerl.g:4094:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            // InternalPerl.g:4095:2: ( rule__QuoteToken__ContentAssignment_1 )
            {
             before(grammarAccess.getQuoteTokenAccess().getContentAssignment_1()); 
            // InternalPerl.g:4096:2: ( rule__QuoteToken__ContentAssignment_1 )
            // InternalPerl.g:4096:3: rule__QuoteToken__ContentAssignment_1
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
    // InternalPerl.g:4105:1: rule__QuoteLikeToken__Group_0__0 : rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 ;
    public final void rule__QuoteLikeToken__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4109:1: ( rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 )
            // InternalPerl.g:4110:2: rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalPerl.g:4117:1: rule__QuoteLikeToken__Group_0__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4121:1: ( ( () ) )
            // InternalPerl.g:4122:1: ( () )
            {
            // InternalPerl.g:4122:1: ( () )
            // InternalPerl.g:4123:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0()); 
            // InternalPerl.g:4124:2: ()
            // InternalPerl.g:4124:3: 
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
    // InternalPerl.g:4132:1: rule__QuoteLikeToken__Group_0__1 : rule__QuoteLikeToken__Group_0__1__Impl ;
    public final void rule__QuoteLikeToken__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4136:1: ( rule__QuoteLikeToken__Group_0__1__Impl )
            // InternalPerl.g:4137:2: rule__QuoteLikeToken__Group_0__1__Impl
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
    // InternalPerl.g:4143:1: rule__QuoteLikeToken__Group_0__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4147:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:4148:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:4148:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            // InternalPerl.g:4149:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:4150:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            // InternalPerl.g:4150:3: rule__QuoteLikeToken__ContentAssignment_0_1
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
    // InternalPerl.g:4159:1: rule__QuoteLikeToken__Group_1__0 : rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 ;
    public final void rule__QuoteLikeToken__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4163:1: ( rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 )
            // InternalPerl.g:4164:2: rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalPerl.g:4171:1: rule__QuoteLikeToken__Group_1__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4175:1: ( ( () ) )
            // InternalPerl.g:4176:1: ( () )
            {
            // InternalPerl.g:4176:1: ( () )
            // InternalPerl.g:4177:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0()); 
            // InternalPerl.g:4178:2: ()
            // InternalPerl.g:4178:3: 
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
    // InternalPerl.g:4186:1: rule__QuoteLikeToken__Group_1__1 : rule__QuoteLikeToken__Group_1__1__Impl ;
    public final void rule__QuoteLikeToken__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4190:1: ( rule__QuoteLikeToken__Group_1__1__Impl )
            // InternalPerl.g:4191:2: rule__QuoteLikeToken__Group_1__1__Impl
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
    // InternalPerl.g:4197:1: rule__QuoteLikeToken__Group_1__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4201:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:4202:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:4202:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            // InternalPerl.g:4203:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:4204:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            // InternalPerl.g:4204:3: rule__QuoteLikeToken__ContentAssignment_1_1
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
    // InternalPerl.g:4213:1: rule__QuoteLikeToken__Group_2__0 : rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 ;
    public final void rule__QuoteLikeToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4217:1: ( rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 )
            // InternalPerl.g:4218:2: rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalPerl.g:4225:1: rule__QuoteLikeToken__Group_2__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4229:1: ( ( () ) )
            // InternalPerl.g:4230:1: ( () )
            {
            // InternalPerl.g:4230:1: ( () )
            // InternalPerl.g:4231:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0()); 
            // InternalPerl.g:4232:2: ()
            // InternalPerl.g:4232:3: 
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
    // InternalPerl.g:4240:1: rule__QuoteLikeToken__Group_2__1 : rule__QuoteLikeToken__Group_2__1__Impl ;
    public final void rule__QuoteLikeToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4244:1: ( rule__QuoteLikeToken__Group_2__1__Impl )
            // InternalPerl.g:4245:2: rule__QuoteLikeToken__Group_2__1__Impl
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
    // InternalPerl.g:4251:1: rule__QuoteLikeToken__Group_2__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4255:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:4256:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:4256:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            // InternalPerl.g:4257:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:4258:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            // InternalPerl.g:4258:3: rule__QuoteLikeToken__ContentAssignment_2_1
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
    // InternalPerl.g:4267:1: rule__QuoteLikeToken__Group_3__0 : rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 ;
    public final void rule__QuoteLikeToken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4271:1: ( rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 )
            // InternalPerl.g:4272:2: rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalPerl.g:4279:1: rule__QuoteLikeToken__Group_3__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4283:1: ( ( () ) )
            // InternalPerl.g:4284:1: ( () )
            {
            // InternalPerl.g:4284:1: ( () )
            // InternalPerl.g:4285:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0()); 
            // InternalPerl.g:4286:2: ()
            // InternalPerl.g:4286:3: 
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
    // InternalPerl.g:4294:1: rule__QuoteLikeToken__Group_3__1 : rule__QuoteLikeToken__Group_3__1__Impl ;
    public final void rule__QuoteLikeToken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4298:1: ( rule__QuoteLikeToken__Group_3__1__Impl )
            // InternalPerl.g:4299:2: rule__QuoteLikeToken__Group_3__1__Impl
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
    // InternalPerl.g:4305:1: rule__QuoteLikeToken__Group_3__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4309:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:4310:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:4310:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            // InternalPerl.g:4311:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:4312:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            // InternalPerl.g:4312:3: rule__QuoteLikeToken__ContentAssignment_3_1
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
    // InternalPerl.g:4321:1: rule__QuoteLikeToken__Group_4__0 : rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 ;
    public final void rule__QuoteLikeToken__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4325:1: ( rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 )
            // InternalPerl.g:4326:2: rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalPerl.g:4333:1: rule__QuoteLikeToken__Group_4__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4337:1: ( ( () ) )
            // InternalPerl.g:4338:1: ( () )
            {
            // InternalPerl.g:4338:1: ( () )
            // InternalPerl.g:4339:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0()); 
            // InternalPerl.g:4340:2: ()
            // InternalPerl.g:4340:3: 
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
    // InternalPerl.g:4348:1: rule__QuoteLikeToken__Group_4__1 : rule__QuoteLikeToken__Group_4__1__Impl ;
    public final void rule__QuoteLikeToken__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4352:1: ( rule__QuoteLikeToken__Group_4__1__Impl )
            // InternalPerl.g:4353:2: rule__QuoteLikeToken__Group_4__1__Impl
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
    // InternalPerl.g:4359:1: rule__QuoteLikeToken__Group_4__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4363:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) )
            // InternalPerl.g:4364:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            {
            // InternalPerl.g:4364:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            // InternalPerl.g:4365:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_4_1()); 
            // InternalPerl.g:4366:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            // InternalPerl.g:4366:3: rule__QuoteLikeToken__ContentAssignment_4_1
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
    // InternalPerl.g:4375:1: rule__Operator__Group_23__0 : rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 ;
    public final void rule__Operator__Group_23__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4379:1: ( rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 )
            // InternalPerl.g:4380:2: rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalPerl.g:4387:1: rule__Operator__Group_23__0__Impl : ( '<=>' ) ;
    public final void rule__Operator__Group_23__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4391:1: ( ( '<=>' ) )
            // InternalPerl.g:4392:1: ( '<=>' )
            {
            // InternalPerl.g:4392:1: ( '<=>' )
            // InternalPerl.g:4393:2: '<=>'
            {
             before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_23_0()); 
            match(input,347,FOLLOW_2); 
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
    // InternalPerl.g:4402:1: rule__Operator__Group_23__1 : rule__Operator__Group_23__1__Impl ;
    public final void rule__Operator__Group_23__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4406:1: ( rule__Operator__Group_23__1__Impl )
            // InternalPerl.g:4407:2: rule__Operator__Group_23__1__Impl
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
    // InternalPerl.g:4413:1: rule__Operator__Group_23__1__Impl : ( '.' ) ;
    public final void rule__Operator__Group_23__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4417:1: ( ( '.' ) )
            // InternalPerl.g:4418:1: ( '.' )
            {
            // InternalPerl.g:4418:1: ( '.' )
            // InternalPerl.g:4419:2: '.'
            {
             before(grammarAccess.getOperatorAccess().getFullStopKeyword_23_1()); 
            match(input,348,FOLLOW_2); 
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
    // InternalPerl.g:4429:1: rule__PerlDocument__ElementsAssignment_1 : ( ruleElement ) ;
    public final void rule__PerlDocument__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4433:1: ( ( ruleElement ) )
            // InternalPerl.g:4434:2: ( ruleElement )
            {
            // InternalPerl.g:4434:2: ( ruleElement )
            // InternalPerl.g:4435:3: ruleElement
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
    // InternalPerl.g:4444:1: rule__PackageStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4448:1: ( ( RULE_ID ) )
            // InternalPerl.g:4449:2: ( RULE_ID )
            {
            // InternalPerl.g:4449:2: ( RULE_ID )
            // InternalPerl.g:4450:3: RULE_ID
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
    // InternalPerl.g:4459:1: rule__PackageStatement__VersionAssignment_3 : ( RULE_VERSION ) ;
    public final void rule__PackageStatement__VersionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4463:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4464:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4464:2: ( RULE_VERSION )
            // InternalPerl.g:4465:3: RULE_VERSION
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
    // InternalPerl.g:4474:1: rule__RequireInclude__VersionAssignment_1 : ( RULE_VERSION ) ;
    public final void rule__RequireInclude__VersionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4478:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4479:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4479:2: ( RULE_VERSION )
            // InternalPerl.g:4480:3: RULE_VERSION
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
    // InternalPerl.g:4489:1: rule__UseInclude__VersionAssignment_2_0 : ( RULE_VERSION ) ;
    public final void rule__UseInclude__VersionAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4493:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4494:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4494:2: ( RULE_VERSION )
            // InternalPerl.g:4495:3: RULE_VERSION
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
    // InternalPerl.g:4504:1: rule__UseInclude__PragmaOrPackageAssignment_2_1_0 : ( RULE_ID ) ;
    public final void rule__UseInclude__PragmaOrPackageAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4508:1: ( ( RULE_ID ) )
            // InternalPerl.g:4509:2: ( RULE_ID )
            {
            // InternalPerl.g:4509:2: ( RULE_ID )
            // InternalPerl.g:4510:3: RULE_ID
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
    // InternalPerl.g:4519:1: rule__UseInclude__StringArgumentAssignment_2_1_1_0 : ( ruleQuoteToken ) ;
    public final void rule__UseInclude__StringArgumentAssignment_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4523:1: ( ( ruleQuoteToken ) )
            // InternalPerl.g:4524:2: ( ruleQuoteToken )
            {
            // InternalPerl.g:4524:2: ( ruleQuoteToken )
            // InternalPerl.g:4525:3: ruleQuoteToken
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
    // InternalPerl.g:4534:1: rule__UseInclude__QwArgumentAssignment_2_1_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__UseInclude__QwArgumentAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4538:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:4539:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:4539:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:4540:3: RULE_WORDS_QUOTE_LIKE
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


    // $ANTLR start "rule__SubStatement__NameAssignment_2"
    // InternalPerl.g:4549:1: rule__SubStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SubStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4553:1: ( ( RULE_ID ) )
            // InternalPerl.g:4554:2: ( RULE_ID )
            {
            // InternalPerl.g:4554:2: ( RULE_ID )
            // InternalPerl.g:4555:3: RULE_ID
            {
             before(grammarAccess.getSubStatementAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSubStatementAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__SubStatement__NameAssignment_2"


    // $ANTLR start "rule__SubStatement__PrototypeAssignment_3"
    // InternalPerl.g:4564:1: rule__SubStatement__PrototypeAssignment_3 : ( rulePrototype ) ;
    public final void rule__SubStatement__PrototypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4568:1: ( ( rulePrototype ) )
            // InternalPerl.g:4569:2: ( rulePrototype )
            {
            // InternalPerl.g:4569:2: ( rulePrototype )
            // InternalPerl.g:4570:3: rulePrototype
            {
             before(grammarAccess.getSubStatementAccess().getPrototypePrototypeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulePrototype();

            state._fsp--;

             after(grammarAccess.getSubStatementAccess().getPrototypePrototypeParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__SubStatement__PrototypeAssignment_3"


    // $ANTLR start "rule__SubStatement__BlockAssignment_4_1"
    // InternalPerl.g:4579:1: rule__SubStatement__BlockAssignment_4_1 : ( ruleStatementBlock ) ;
    public final void rule__SubStatement__BlockAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4583:1: ( ( ruleStatementBlock ) )
            // InternalPerl.g:4584:2: ( ruleStatementBlock )
            {
            // InternalPerl.g:4584:2: ( ruleStatementBlock )
            // InternalPerl.g:4585:3: ruleStatementBlock
            {
             before(grammarAccess.getSubStatementAccess().getBlockStatementBlockParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStatementBlock();

            state._fsp--;

             after(grammarAccess.getSubStatementAccess().getBlockStatementBlockParserRuleCall_4_1_0()); 

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
    // $ANTLR end "rule__SubStatement__BlockAssignment_4_1"


    // $ANTLR start "rule__StatementBlock__StatementsAssignment_2"
    // InternalPerl.g:4594:1: rule__StatementBlock__StatementsAssignment_2 : ( ruleStatementNode ) ;
    public final void rule__StatementBlock__StatementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4598:1: ( ( ruleStatementNode ) )
            // InternalPerl.g:4599:2: ( ruleStatementNode )
            {
            // InternalPerl.g:4599:2: ( ruleStatementNode )
            // InternalPerl.g:4600:3: ruleStatementNode
            {
             before(grammarAccess.getStatementBlockAccess().getStatementsStatementNodeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStatementNode();

            state._fsp--;

             after(grammarAccess.getStatementBlockAccess().getStatementsStatementNodeParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__StatementBlock__StatementsAssignment_2"


    // $ANTLR start "rule__Token__ContentAssignment_0_1"
    // InternalPerl.g:4609:1: rule__Token__ContentAssignment_0_1 : ( RULE_POD ) ;
    public final void rule__Token__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4613:1: ( ( RULE_POD ) )
            // InternalPerl.g:4614:2: ( RULE_POD )
            {
            // InternalPerl.g:4614:2: ( RULE_POD )
            // InternalPerl.g:4615:3: RULE_POD
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
    // InternalPerl.g:4624:1: rule__Token__ContentAssignment_1_1 : ( RULE_NUMBER ) ;
    public final void rule__Token__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4628:1: ( ( RULE_NUMBER ) )
            // InternalPerl.g:4629:2: ( RULE_NUMBER )
            {
            // InternalPerl.g:4629:2: ( RULE_NUMBER )
            // InternalPerl.g:4630:3: RULE_NUMBER
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
    // InternalPerl.g:4639:1: rule__Token__ContentAssignment_2_1 : ( ruleWord ) ;
    public final void rule__Token__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4643:1: ( ( ruleWord ) )
            // InternalPerl.g:4644:2: ( ruleWord )
            {
            // InternalPerl.g:4644:2: ( ruleWord )
            // InternalPerl.g:4645:3: ruleWord
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
    // InternalPerl.g:4654:1: rule__Token__ContentAssignment_3_1 : ( RULE_SYMBOL ) ;
    public final void rule__Token__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4658:1: ( ( RULE_SYMBOL ) )
            // InternalPerl.g:4659:2: ( RULE_SYMBOL )
            {
            // InternalPerl.g:4659:2: ( RULE_SYMBOL )
            // InternalPerl.g:4660:3: RULE_SYMBOL
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
    // InternalPerl.g:4669:1: rule__Token__ContentAssignment_5_1 : ( ruleFileTestOperator ) ;
    public final void rule__Token__ContentAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4673:1: ( ( ruleFileTestOperator ) )
            // InternalPerl.g:4674:2: ( ruleFileTestOperator )
            {
            // InternalPerl.g:4674:2: ( ruleFileTestOperator )
            // InternalPerl.g:4675:3: ruleFileTestOperator
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
    // InternalPerl.g:4684:1: rule__Token__ContentAssignment_6_1 : ( ruleOperator ) ;
    public final void rule__Token__ContentAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4688:1: ( ( ruleOperator ) )
            // InternalPerl.g:4689:2: ( ruleOperator )
            {
            // InternalPerl.g:4689:2: ( ruleOperator )
            // InternalPerl.g:4690:3: ruleOperator
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


    // $ANTLR start "rule__Token__ContentAssignment_9_1"
    // InternalPerl.g:4699:1: rule__Token__ContentAssignment_9_1 : ( RULE_DATA ) ;
    public final void rule__Token__ContentAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4703:1: ( ( RULE_DATA ) )
            // InternalPerl.g:4704:2: ( RULE_DATA )
            {
            // InternalPerl.g:4704:2: ( RULE_DATA )
            // InternalPerl.g:4705:3: RULE_DATA
            {
             before(grammarAccess.getTokenAccess().getContentDATATerminalRuleCall_9_1_0()); 
            match(input,RULE_DATA,FOLLOW_2); 
             after(grammarAccess.getTokenAccess().getContentDATATerminalRuleCall_9_1_0()); 

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
    // InternalPerl.g:4714:1: rule__Token__ContentAssignment_10_1 : ( RULE_END ) ;
    public final void rule__Token__ContentAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4718:1: ( ( RULE_END ) )
            // InternalPerl.g:4719:2: ( RULE_END )
            {
            // InternalPerl.g:4719:2: ( RULE_END )
            // InternalPerl.g:4720:3: RULE_END
            {
             before(grammarAccess.getTokenAccess().getContentENDTerminalRuleCall_10_1_0()); 
            match(input,RULE_END,FOLLOW_2); 
             after(grammarAccess.getTokenAccess().getContentENDTerminalRuleCall_10_1_0()); 

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


    // $ANTLR start "rule__RegexToken__ContentAssignment_1"
    // InternalPerl.g:4729:1: rule__RegexToken__ContentAssignment_1 : ( ( rule__RegexToken__ContentAlternatives_1_0 ) ) ;
    public final void rule__RegexToken__ContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4733:1: ( ( ( rule__RegexToken__ContentAlternatives_1_0 ) ) )
            // InternalPerl.g:4734:2: ( ( rule__RegexToken__ContentAlternatives_1_0 ) )
            {
            // InternalPerl.g:4734:2: ( ( rule__RegexToken__ContentAlternatives_1_0 ) )
            // InternalPerl.g:4735:3: ( rule__RegexToken__ContentAlternatives_1_0 )
            {
             before(grammarAccess.getRegexTokenAccess().getContentAlternatives_1_0()); 
            // InternalPerl.g:4736:3: ( rule__RegexToken__ContentAlternatives_1_0 )
            // InternalPerl.g:4736:4: rule__RegexToken__ContentAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__RegexToken__ContentAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getRegexTokenAccess().getContentAlternatives_1_0()); 

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
    // $ANTLR end "rule__RegexToken__ContentAssignment_1"


    // $ANTLR start "rule__QuoteToken__ContentAssignment_1"
    // InternalPerl.g:4744:1: rule__QuoteToken__ContentAssignment_1 : ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) ;
    public final void rule__QuoteToken__ContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4748:1: ( ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) )
            // InternalPerl.g:4749:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            {
            // InternalPerl.g:4749:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            // InternalPerl.g:4750:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            {
             before(grammarAccess.getQuoteTokenAccess().getContentAlternatives_1_0()); 
            // InternalPerl.g:4751:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            // InternalPerl.g:4751:4: rule__QuoteToken__ContentAlternatives_1_0
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
    // InternalPerl.g:4759:1: rule__QuoteLikeToken__ContentAssignment_0_1 : ( RULE_BACKTICK_STRING ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4763:1: ( ( RULE_BACKTICK_STRING ) )
            // InternalPerl.g:4764:2: ( RULE_BACKTICK_STRING )
            {
            // InternalPerl.g:4764:2: ( RULE_BACKTICK_STRING )
            // InternalPerl.g:4765:3: RULE_BACKTICK_STRING
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
    // InternalPerl.g:4774:1: rule__QuoteLikeToken__ContentAssignment_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4778:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:4779:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:4779:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:4780:3: RULE_WORDS_QUOTE_LIKE
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
    // InternalPerl.g:4789:1: rule__QuoteLikeToken__ContentAssignment_2_1 : ( RULE_COMMAND_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4793:1: ( ( RULE_COMMAND_QUOTE_LIKE ) )
            // InternalPerl.g:4794:2: ( RULE_COMMAND_QUOTE_LIKE )
            {
            // InternalPerl.g:4794:2: ( RULE_COMMAND_QUOTE_LIKE )
            // InternalPerl.g:4795:3: RULE_COMMAND_QUOTE_LIKE
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
    // InternalPerl.g:4804:1: rule__QuoteLikeToken__ContentAssignment_3_1 : ( RULE_REGEX_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4808:1: ( ( RULE_REGEX_QUOTE ) )
            // InternalPerl.g:4809:2: ( RULE_REGEX_QUOTE )
            {
            // InternalPerl.g:4809:2: ( RULE_REGEX_QUOTE )
            // InternalPerl.g:4810:3: RULE_REGEX_QUOTE
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
    // InternalPerl.g:4819:1: rule__QuoteLikeToken__ContentAssignment_4_1 : ( RULE_READLINE_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4823:1: ( ( RULE_READLINE_QUOTE ) )
            // InternalPerl.g:4824:2: ( RULE_READLINE_QUOTE )
            {
            // InternalPerl.g:4824:2: ( RULE_READLINE_QUOTE )
            // InternalPerl.g:4825:3: RULE_READLINE_QUOTE
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFFFFF403FF3F0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000000087FFFFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFF403FF3F2L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000000087FFFFFL});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100002000000L,0x0008000001000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000001380L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100002000000L,0x0008000001000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000100002000000L,0x0008000001000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000001F0000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000001F0000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xFFFFFFFE00000000L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x7FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xF000000000000000L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000140000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L,0x0FFFFFFFFFFFFFFFL,0x0000000008000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00000000003C1000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000010000000L});

}