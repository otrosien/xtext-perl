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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INTERPOLATE", "RULE_LITERAL", "RULE_ID", "RULE_VERSION", "RULE_WORDS_QUOTE_LIKE", "RULE_POD", "RULE_NUMBER", "RULE_SYMBOL", "RULE_DATA", "RULE_END", "RULE_BACKTICK_STRING", "RULE_COMMAND_QUOTE_LIKE", "RULE_REGEX_QUOTE", "RULE_READLINE_QUOTE", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_WS", "RULE_REGEX_SUBSTITUTE", "RULE_REGEX_TRANSLITERATE", "RULE_ANY_OTHER", "RULE_SL_COMMENT", "';'", "'$'", "'%'", "'@'", "'&'", "'abs'", "'accept'", "'alarm'", "'atan2'", "'bind'", "'binmode'", "'bless'", "'break'", "'caller'", "'chdir'", "'chmod'", "'chomp'", "'chop'", "'chown'", "'chr'", "'chroot'", "'close'", "'closedir'", "'connect'", "'continue'", "'cos'", "'crypt'", "'dbmclose'", "'dbmopen'", "'default'", "'defined'", "'delete'", "'die'", "'do'", "'dump'", "'each'", "'else'", "'elsif'", "'endgrent'", "'endhostent'", "'endnetent'", "'endprotoent'", "'endpwent'", "'endservent'", "'eof'", "'eval'", "'evalbytes'", "'exec'", "'exists'", "'exit'", "'exp'", "'fc'", "'fcntl'", "'fileno'", "'flock'", "'for'", "'foreach'", "'fork'", "'format'", "'formline'", "'getc'", "'getgrent'", "'getgrgid'", "'getgrnam'", "'gethostbyaddr'", "'gethostbyname'", "'gethostent'", "'getlogin'", "'getnetbyaddr'", "'getnetbyname'", "'getnetent'", "'getpeername'", "'getpgrp'", "'getppid'", "'getpriority'", "'getprotobyname'", "'getprotobynumber'", "'getprotoent'", "'getpwent'", "'getpwnam'", "'getpwuid'", "'getservbyname'", "'getservbyport'", "'getservent'", "'getsockname'", "'getsockopt'", "'given'", "'glob'", "'gmtime'", "'goto'", "'grep'", "'hex'", "'if'", "'index'", "'int'", "'ioctl'", "'join'", "'keys'", "'kill'", "'last'", "'lc'", "'lcfirst'", "'length'", "'link'", "'listen'", "'local'", "'localtime'", "'lock'", "'log'", "'lstat'", "'map'", "'mkdir'", "'msgctl'", "'msgget'", "'msgrcv'", "'msgsnd'", "'my'", "'next'", "'no'", "'oct'", "'open'", "'opendir'", "'ord'", "'our'", "'pack'", "'package'", "'pipe'", "'pop'", "'pos'", "'print'", "'printf'", "'prototype'", "'push'", "'quotemeta'", "'rand'", "'read'", "'readdir'", "'readline'", "'readlink'", "'readpipe'", "'recv'", "'redo'", "'ref'", "'rename'", "'require'", "'reset'", "'return'", "'reverse'", "'rewinddir'", "'rindex'", "'rmdir'", "'say'", "'scalar'", "'seek'", "'seekdir'", "'select'", "'semctl'", "'semget'", "'semop'", "'send'", "'setgrent'", "'sethostent'", "'setnetent'", "'setpgrp'", "'setpriority'", "'setprotoent'", "'setpwent'", "'setservent'", "'setsockopt'", "'shift'", "'shmctl'", "'shmget'", "'shmread'", "'shmwrite'", "'shutdown'", "'sin'", "'sleep'", "'socket'", "'socketpair'", "'sort'", "'splice'", "'split'", "'sprintf'", "'sqrt'", "'srand'", "'stat'", "'state'", "'study'", "'sub'", "'substr'", "'symlink'", "'syscall'", "'sysopen'", "'sysread'", "'sysseek'", "'system'", "'syswrite'", "'tell'", "'telldir'", "'tie'", "'tied'", "'time'", "'times'", "'tr'", "'truncate'", "'uc'", "'ucfirst'", "'umask'", "'undef'", "'unless'", "'unlink'", "'unpack'", "'unshift'", "'untie'", "'until'", "'use'", "'utime'", "'values'", "'vec'", "'wait'", "'waitpid'", "'wantarray'", "'warn'", "'when'", "'while'", "'write'", "'y'", "'++'", "'--'", "'**'", "'!'", "'~'", "'+'", "'-'", "'=~'", "'!~'", "'*'", "'/'", "'x'", "'<<'", "'>>'", "'lt'", "'gt'", "'le'", "'ge'", "'cmp'", "'~~'", "'=='", "'!='", "'..'", "'...'", "','", "'|'", "'^'", "'&&'", "'||'", "'//'", "'?'", "':'", "'**='", "'+='", "'-='", "'.='", "'*='", "'/='", "'%='", "'x='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'&&='", "'||='", "'//='", "'<'", "'>'", "'<='", "'>='", "'<>'", "'=>'", "'->'", "'and'", "'or'", "'xor'", "'not'", "'eq'", "'ne'", "'-r'", "'-w'", "'-x'", "'-o'", "'-R'", "'-W'", "'-X'", "'-O'", "'-e'", "'-z'", "'-s'", "'-f'", "'-d'", "'-l'", "'-p'", "'-S'", "'-b'", "'-c'", "'-t'", "'-u'", "'-g'", "'-k'", "'-T'", "'-B'", "'-M'", "'-A'", "'-C'", "'{'", "'}'", "'('", "')'", "'<=>'", "'.'"
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
    public static final int RULE_REGEX_TRANSLITERATE=24;
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
    public static final int RULE_REGEX_SUBSTITUTE=23;
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
    public static final int T__27=27;
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
    public static final int RULE_END=14;
    public static final int T__123=123;
    public static final int T__244=244;
    public static final int T__120=120;
    public static final int T__241=241;
    public static final int T__240=240;
    public static final int RULE_SL_COMMENT=26;
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
    public static final int T__346=346;
    public static final int T__103=103;
    public static final int T__224=224;
    public static final int T__345=345;
    public static final int T__106=106;
    public static final int T__227=227;
    public static final int T__105=105;
    public static final int T__226=226;
    public static final int T__347=347;
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
    public static final int RULE_ANY_OTHER=25;
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


    // $ANTLR start "entryRuleQuoteToken"
    // InternalPerl.g:403:1: entryRuleQuoteToken : ruleQuoteToken EOF ;
    public final void entryRuleQuoteToken() throws RecognitionException {
        try {
            // InternalPerl.g:404:1: ( ruleQuoteToken EOF )
            // InternalPerl.g:405:1: ruleQuoteToken EOF
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
    // InternalPerl.g:412:1: ruleQuoteToken : ( ( rule__QuoteToken__Group__0 ) ) ;
    public final void ruleQuoteToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:416:2: ( ( ( rule__QuoteToken__Group__0 ) ) )
            // InternalPerl.g:417:2: ( ( rule__QuoteToken__Group__0 ) )
            {
            // InternalPerl.g:417:2: ( ( rule__QuoteToken__Group__0 ) )
            // InternalPerl.g:418:3: ( rule__QuoteToken__Group__0 )
            {
             before(grammarAccess.getQuoteTokenAccess().getGroup()); 
            // InternalPerl.g:419:3: ( rule__QuoteToken__Group__0 )
            // InternalPerl.g:419:4: rule__QuoteToken__Group__0
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
    // InternalPerl.g:428:1: entryRuleQuoteLikeToken : ruleQuoteLikeToken EOF ;
    public final void entryRuleQuoteLikeToken() throws RecognitionException {
        try {
            // InternalPerl.g:429:1: ( ruleQuoteLikeToken EOF )
            // InternalPerl.g:430:1: ruleQuoteLikeToken EOF
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
    // InternalPerl.g:437:1: ruleQuoteLikeToken : ( ( rule__QuoteLikeToken__Alternatives ) ) ;
    public final void ruleQuoteLikeToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:441:2: ( ( ( rule__QuoteLikeToken__Alternatives ) ) )
            // InternalPerl.g:442:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            {
            // InternalPerl.g:442:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            // InternalPerl.g:443:3: ( rule__QuoteLikeToken__Alternatives )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getAlternatives()); 
            // InternalPerl.g:444:3: ( rule__QuoteLikeToken__Alternatives )
            // InternalPerl.g:444:4: rule__QuoteLikeToken__Alternatives
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
    // InternalPerl.g:453:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalPerl.g:454:1: ( ruleWord EOF )
            // InternalPerl.g:455:1: ruleWord EOF
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
    // InternalPerl.g:462:1: ruleWord : ( ruleKeyword ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:466:2: ( ( ruleKeyword ) )
            // InternalPerl.g:467:2: ( ruleKeyword )
            {
            // InternalPerl.g:467:2: ( ruleKeyword )
            // InternalPerl.g:468:3: ruleKeyword
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
    // InternalPerl.g:478:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalPerl.g:479:1: ( ruleKeyword EOF )
            // InternalPerl.g:480:1: ruleKeyword EOF
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
    // InternalPerl.g:487:1: ruleKeyword : ( ( rule__Keyword__Alternatives ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:491:2: ( ( ( rule__Keyword__Alternatives ) ) )
            // InternalPerl.g:492:2: ( ( rule__Keyword__Alternatives ) )
            {
            // InternalPerl.g:492:2: ( ( rule__Keyword__Alternatives ) )
            // InternalPerl.g:493:3: ( rule__Keyword__Alternatives )
            {
             before(grammarAccess.getKeywordAccess().getAlternatives()); 
            // InternalPerl.g:494:3: ( rule__Keyword__Alternatives )
            // InternalPerl.g:494:4: rule__Keyword__Alternatives
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
    // InternalPerl.g:503:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalPerl.g:504:1: ( ruleOperator EOF )
            // InternalPerl.g:505:1: ruleOperator EOF
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
    // InternalPerl.g:512:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:516:2: ( ( ( rule__Operator__Alternatives ) ) )
            // InternalPerl.g:517:2: ( ( rule__Operator__Alternatives ) )
            {
            // InternalPerl.g:517:2: ( ( rule__Operator__Alternatives ) )
            // InternalPerl.g:518:3: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // InternalPerl.g:519:3: ( rule__Operator__Alternatives )
            // InternalPerl.g:519:4: rule__Operator__Alternatives
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
    // InternalPerl.g:528:1: entryRuleFileTestOperator : ruleFileTestOperator EOF ;
    public final void entryRuleFileTestOperator() throws RecognitionException {
        try {
            // InternalPerl.g:529:1: ( ruleFileTestOperator EOF )
            // InternalPerl.g:530:1: ruleFileTestOperator EOF
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
    // InternalPerl.g:537:1: ruleFileTestOperator : ( ( rule__FileTestOperator__Alternatives ) ) ;
    public final void ruleFileTestOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:541:2: ( ( ( rule__FileTestOperator__Alternatives ) ) )
            // InternalPerl.g:542:2: ( ( rule__FileTestOperator__Alternatives ) )
            {
            // InternalPerl.g:542:2: ( ( rule__FileTestOperator__Alternatives ) )
            // InternalPerl.g:543:3: ( rule__FileTestOperator__Alternatives )
            {
             before(grammarAccess.getFileTestOperatorAccess().getAlternatives()); 
            // InternalPerl.g:544:3: ( rule__FileTestOperator__Alternatives )
            // InternalPerl.g:544:4: rule__FileTestOperator__Alternatives
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
    // InternalPerl.g:552:1: rule__Element__Alternatives : ( ( ruleNode ) | ( ruleToken ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:556:1: ( ( ruleNode ) | ( ruleToken ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==215) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==RULE_ID) ) {
                    alt1=1;
                }
                else if ( (LA1_1==EOF||(LA1_1>=RULE_STRING && LA1_1<=RULE_LITERAL)||(LA1_1>=RULE_WORDS_QUOTE_LIKE && LA1_1<=RULE_READLINE_QUOTE)||LA1_1==29||(LA1_1>=31 && LA1_1<=341)||LA1_1==346) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==152) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==EOF||(LA1_2>=RULE_STRING && LA1_2<=RULE_LITERAL)||(LA1_2>=RULE_WORDS_QUOTE_LIKE && LA1_2<=RULE_READLINE_QUOTE)||LA1_2==29||(LA1_2>=31 && LA1_2<=341)||LA1_2==346) ) {
                    alt1=2;
                }
                else if ( (LA1_2==RULE_ID) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==171) ) {
                int LA1_3 = input.LA(2);

                if ( (LA1_3==RULE_VERSION) ) {
                    alt1=1;
                }
                else if ( (LA1_3==EOF||(LA1_3>=RULE_STRING && LA1_3<=RULE_LITERAL)||(LA1_3>=RULE_WORDS_QUOTE_LIKE && LA1_3<=RULE_READLINE_QUOTE)||LA1_3==29||(LA1_3>=31 && LA1_3<=341)||LA1_3==346) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==242) ) {
                int LA1_4 = input.LA(2);

                if ( ((LA1_4>=RULE_ID && LA1_4<=RULE_VERSION)) ) {
                    alt1=1;
                }
                else if ( (LA1_4==EOF||(LA1_4>=RULE_STRING && LA1_4<=RULE_LITERAL)||(LA1_4>=RULE_WORDS_QUOTE_LIKE && LA1_4<=RULE_READLINE_QUOTE)||LA1_4==29||(LA1_4>=31 && LA1_4<=341)||LA1_4==346) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 4, input);

                    throw nvae;
                }
            }
            else if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_LITERAL)||(LA1_0>=RULE_WORDS_QUOTE_LIKE && LA1_0<=RULE_READLINE_QUOTE)||LA1_0==29||(LA1_0>=31 && LA1_0<=151)||(LA1_0>=153 && LA1_0<=170)||(LA1_0>=172 && LA1_0<=214)||(LA1_0>=216 && LA1_0<=241)||(LA1_0>=243 && LA1_0<=341)||LA1_0==346) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalPerl.g:557:2: ( ruleNode )
                    {
                    // InternalPerl.g:557:2: ( ruleNode )
                    // InternalPerl.g:558:3: ruleNode
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
                    // InternalPerl.g:563:2: ( ruleToken )
                    {
                    // InternalPerl.g:563:2: ( ruleToken )
                    // InternalPerl.g:564:3: ruleToken
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
    // InternalPerl.g:573:1: rule__StatementNode__Alternatives : ( ( ruleBlockStatement ) | ( ruleExpressionStatement ) );
    public final void rule__StatementNode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:577:1: ( ( ruleBlockStatement ) | ( ruleExpressionStatement ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==215) ) {
                alt2=1;
            }
            else if ( (LA2_0==152||LA2_0==171||LA2_0==242) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalPerl.g:578:2: ( ruleBlockStatement )
                    {
                    // InternalPerl.g:578:2: ( ruleBlockStatement )
                    // InternalPerl.g:579:3: ruleBlockStatement
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
                    // InternalPerl.g:584:2: ( ruleExpressionStatement )
                    {
                    // InternalPerl.g:584:2: ( ruleExpressionStatement )
                    // InternalPerl.g:585:3: ruleExpressionStatement
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
    // InternalPerl.g:594:1: rule__ExpressionStatement__Alternatives_0 : ( ( rulePackageStatement ) | ( ruleIncludeStatement ) );
    public final void rule__ExpressionStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:598:1: ( ( rulePackageStatement ) | ( ruleIncludeStatement ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==152) ) {
                alt3=1;
            }
            else if ( (LA3_0==171||LA3_0==242) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalPerl.g:599:2: ( rulePackageStatement )
                    {
                    // InternalPerl.g:599:2: ( rulePackageStatement )
                    // InternalPerl.g:600:3: rulePackageStatement
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
                    // InternalPerl.g:605:2: ( ruleIncludeStatement )
                    {
                    // InternalPerl.g:605:2: ( ruleIncludeStatement )
                    // InternalPerl.g:606:3: ruleIncludeStatement
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
    // InternalPerl.g:615:1: rule__IncludeStatement__Alternatives : ( ( ruleRequireInclude ) | ( ruleUseInclude ) );
    public final void rule__IncludeStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:619:1: ( ( ruleRequireInclude ) | ( ruleUseInclude ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==171) ) {
                alt4=1;
            }
            else if ( (LA4_0==242) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalPerl.g:620:2: ( ruleRequireInclude )
                    {
                    // InternalPerl.g:620:2: ( ruleRequireInclude )
                    // InternalPerl.g:621:3: ruleRequireInclude
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
                    // InternalPerl.g:626:2: ( ruleUseInclude )
                    {
                    // InternalPerl.g:626:2: ( ruleUseInclude )
                    // InternalPerl.g:627:3: ruleUseInclude
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
    // InternalPerl.g:636:1: rule__UseInclude__Alternatives_2 : ( ( ( rule__UseInclude__VersionAssignment_2_0 ) ) | ( ( rule__UseInclude__Group_2_1__0 ) ) );
    public final void rule__UseInclude__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:640:1: ( ( ( rule__UseInclude__VersionAssignment_2_0 ) ) | ( ( rule__UseInclude__Group_2_1__0 ) ) )
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
                    // InternalPerl.g:641:2: ( ( rule__UseInclude__VersionAssignment_2_0 ) )
                    {
                    // InternalPerl.g:641:2: ( ( rule__UseInclude__VersionAssignment_2_0 ) )
                    // InternalPerl.g:642:3: ( rule__UseInclude__VersionAssignment_2_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getVersionAssignment_2_0()); 
                    // InternalPerl.g:643:3: ( rule__UseInclude__VersionAssignment_2_0 )
                    // InternalPerl.g:643:4: rule__UseInclude__VersionAssignment_2_0
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
                    // InternalPerl.g:647:2: ( ( rule__UseInclude__Group_2_1__0 ) )
                    {
                    // InternalPerl.g:647:2: ( ( rule__UseInclude__Group_2_1__0 ) )
                    // InternalPerl.g:648:3: ( rule__UseInclude__Group_2_1__0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getGroup_2_1()); 
                    // InternalPerl.g:649:3: ( rule__UseInclude__Group_2_1__0 )
                    // InternalPerl.g:649:4: rule__UseInclude__Group_2_1__0
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
    // InternalPerl.g:657:1: rule__UseInclude__Alternatives_2_1_1 : ( ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) ) | ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) ) );
    public final void rule__UseInclude__Alternatives_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:661:1: ( ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) ) | ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) ) )
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
                    // InternalPerl.g:662:2: ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) )
                    {
                    // InternalPerl.g:662:2: ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) )
                    // InternalPerl.g:663:3: ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getStringArgumentAssignment_2_1_1_0()); 
                    // InternalPerl.g:664:3: ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 )
                    // InternalPerl.g:664:4: rule__UseInclude__StringArgumentAssignment_2_1_1_0
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
                    // InternalPerl.g:668:2: ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) )
                    {
                    // InternalPerl.g:668:2: ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) )
                    // InternalPerl.g:669:3: ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getQwArgumentAssignment_2_1_1_1()); 
                    // InternalPerl.g:670:3: ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 )
                    // InternalPerl.g:670:4: rule__UseInclude__QwArgumentAssignment_2_1_1_1
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
    // InternalPerl.g:678:1: rule__SubStatement__Alternatives_4 : ( ( ';' ) | ( ( rule__SubStatement__BlockAssignment_4_1 ) ) );
    public final void rule__SubStatement__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:682:1: ( ( ';' ) | ( ( rule__SubStatement__BlockAssignment_4_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==27) ) {
                alt7=1;
            }
            else if ( (LA7_0==342) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalPerl.g:683:2: ( ';' )
                    {
                    // InternalPerl.g:683:2: ( ';' )
                    // InternalPerl.g:684:3: ';'
                    {
                     before(grammarAccess.getSubStatementAccess().getSemicolonKeyword_4_0()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getSubStatementAccess().getSemicolonKeyword_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:689:2: ( ( rule__SubStatement__BlockAssignment_4_1 ) )
                    {
                    // InternalPerl.g:689:2: ( ( rule__SubStatement__BlockAssignment_4_1 ) )
                    // InternalPerl.g:690:3: ( rule__SubStatement__BlockAssignment_4_1 )
                    {
                     before(grammarAccess.getSubStatementAccess().getBlockAssignment_4_1()); 
                    // InternalPerl.g:691:3: ( rule__SubStatement__BlockAssignment_4_1 )
                    // InternalPerl.g:691:4: rule__SubStatement__BlockAssignment_4_1
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
    // InternalPerl.g:699:1: rule__Prototype__Alternatives_1 : ( ( '$' ) | ( '%' ) | ( '@' ) | ( '&' ) | ( ';' ) );
    public final void rule__Prototype__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:703:1: ( ( '$' ) | ( '%' ) | ( '@' ) | ( '&' ) | ( ';' ) )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt8=1;
                }
                break;
            case 29:
                {
                alt8=2;
                }
                break;
            case 30:
                {
                alt8=3;
                }
                break;
            case 31:
                {
                alt8=4;
                }
                break;
            case 27:
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
                    // InternalPerl.g:704:2: ( '$' )
                    {
                    // InternalPerl.g:704:2: ( '$' )
                    // InternalPerl.g:705:3: '$'
                    {
                     before(grammarAccess.getPrototypeAccess().getDollarSignKeyword_1_0()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getDollarSignKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:710:2: ( '%' )
                    {
                    // InternalPerl.g:710:2: ( '%' )
                    // InternalPerl.g:711:3: '%'
                    {
                     before(grammarAccess.getPrototypeAccess().getPercentSignKeyword_1_1()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getPercentSignKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:716:2: ( '@' )
                    {
                    // InternalPerl.g:716:2: ( '@' )
                    // InternalPerl.g:717:3: '@'
                    {
                     before(grammarAccess.getPrototypeAccess().getCommercialAtKeyword_1_2()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getCommercialAtKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:722:2: ( '&' )
                    {
                    // InternalPerl.g:722:2: ( '&' )
                    // InternalPerl.g:723:3: '&'
                    {
                     before(grammarAccess.getPrototypeAccess().getAmpersandKeyword_1_3()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getAmpersandKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:728:2: ( ';' )
                    {
                    // InternalPerl.g:728:2: ( ';' )
                    // InternalPerl.g:729:3: ';'
                    {
                     before(grammarAccess.getPrototypeAccess().getSemicolonKeyword_1_4()); 
                    match(input,27,FOLLOW_2); 
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
    // InternalPerl.g:738:1: rule__Token__Alternatives : ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ruleQuoteToken ) | ( ( rule__Token__Group_8__0 ) ) | ( ( rule__Token__Group_9__0 ) ) );
    public final void rule__Token__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:742:1: ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ruleQuoteToken ) | ( ( rule__Token__Group_8__0 ) ) | ( ( rule__Token__Group_9__0 ) ) )
            int alt9=10;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_POD) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_NUMBER) ) {
                alt9=2;
            }
            else if ( ((LA9_0>=32 && LA9_0<=253)) ) {
                alt9=3;
            }
            else if ( (LA9_0==RULE_SYMBOL) ) {
                alt9=4;
            }
            else if ( (LA9_0==RULE_WORDS_QUOTE_LIKE||(LA9_0>=RULE_BACKTICK_STRING && LA9_0<=RULE_READLINE_QUOTE)) ) {
                alt9=5;
            }
            else if ( ((LA9_0>=315 && LA9_0<=341)) ) {
                alt9=6;
            }
            else if ( (LA9_0==29||LA9_0==31||(LA9_0>=254 && LA9_0<=314)||LA9_0==346) ) {
                alt9=7;
            }
            else if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_LITERAL)) ) {
                alt9=8;
            }
            else if ( (LA9_0==RULE_DATA) ) {
                alt9=9;
            }
            else if ( (LA9_0==RULE_END) ) {
                alt9=10;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalPerl.g:743:2: ( ( rule__Token__Group_0__0 ) )
                    {
                    // InternalPerl.g:743:2: ( ( rule__Token__Group_0__0 ) )
                    // InternalPerl.g:744:3: ( rule__Token__Group_0__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_0()); 
                    // InternalPerl.g:745:3: ( rule__Token__Group_0__0 )
                    // InternalPerl.g:745:4: rule__Token__Group_0__0
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
                    // InternalPerl.g:749:2: ( ( rule__Token__Group_1__0 ) )
                    {
                    // InternalPerl.g:749:2: ( ( rule__Token__Group_1__0 ) )
                    // InternalPerl.g:750:3: ( rule__Token__Group_1__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_1()); 
                    // InternalPerl.g:751:3: ( rule__Token__Group_1__0 )
                    // InternalPerl.g:751:4: rule__Token__Group_1__0
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
                    // InternalPerl.g:755:2: ( ( rule__Token__Group_2__0 ) )
                    {
                    // InternalPerl.g:755:2: ( ( rule__Token__Group_2__0 ) )
                    // InternalPerl.g:756:3: ( rule__Token__Group_2__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_2()); 
                    // InternalPerl.g:757:3: ( rule__Token__Group_2__0 )
                    // InternalPerl.g:757:4: rule__Token__Group_2__0
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
                    // InternalPerl.g:761:2: ( ( rule__Token__Group_3__0 ) )
                    {
                    // InternalPerl.g:761:2: ( ( rule__Token__Group_3__0 ) )
                    // InternalPerl.g:762:3: ( rule__Token__Group_3__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_3()); 
                    // InternalPerl.g:763:3: ( rule__Token__Group_3__0 )
                    // InternalPerl.g:763:4: rule__Token__Group_3__0
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
                    // InternalPerl.g:767:2: ( ruleQuoteLikeToken )
                    {
                    // InternalPerl.g:767:2: ( ruleQuoteLikeToken )
                    // InternalPerl.g:768:3: ruleQuoteLikeToken
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
                    // InternalPerl.g:773:2: ( ( rule__Token__Group_5__0 ) )
                    {
                    // InternalPerl.g:773:2: ( ( rule__Token__Group_5__0 ) )
                    // InternalPerl.g:774:3: ( rule__Token__Group_5__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_5()); 
                    // InternalPerl.g:775:3: ( rule__Token__Group_5__0 )
                    // InternalPerl.g:775:4: rule__Token__Group_5__0
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
                    // InternalPerl.g:779:2: ( ( rule__Token__Group_6__0 ) )
                    {
                    // InternalPerl.g:779:2: ( ( rule__Token__Group_6__0 ) )
                    // InternalPerl.g:780:3: ( rule__Token__Group_6__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_6()); 
                    // InternalPerl.g:781:3: ( rule__Token__Group_6__0 )
                    // InternalPerl.g:781:4: rule__Token__Group_6__0
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
                    // InternalPerl.g:785:2: ( ruleQuoteToken )
                    {
                    // InternalPerl.g:785:2: ( ruleQuoteToken )
                    // InternalPerl.g:786:3: ruleQuoteToken
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
                    // InternalPerl.g:791:2: ( ( rule__Token__Group_8__0 ) )
                    {
                    // InternalPerl.g:791:2: ( ( rule__Token__Group_8__0 ) )
                    // InternalPerl.g:792:3: ( rule__Token__Group_8__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_8()); 
                    // InternalPerl.g:793:3: ( rule__Token__Group_8__0 )
                    // InternalPerl.g:793:4: rule__Token__Group_8__0
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
                    // InternalPerl.g:797:2: ( ( rule__Token__Group_9__0 ) )
                    {
                    // InternalPerl.g:797:2: ( ( rule__Token__Group_9__0 ) )
                    // InternalPerl.g:798:3: ( rule__Token__Group_9__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_9()); 
                    // InternalPerl.g:799:3: ( rule__Token__Group_9__0 )
                    // InternalPerl.g:799:4: rule__Token__Group_9__0
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
    // InternalPerl.g:807:1: rule__QuoteToken__ContentAlternatives_1_0 : ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) );
    public final void rule__QuoteToken__ContentAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:811:1: ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt10=1;
                }
                break;
            case RULE_INTERPOLATE:
                {
                alt10=2;
                }
                break;
            case RULE_LITERAL:
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
                    // InternalPerl.g:812:2: ( RULE_STRING )
                    {
                    // InternalPerl.g:812:2: ( RULE_STRING )
                    // InternalPerl.g:813:3: RULE_STRING
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:818:2: ( RULE_INTERPOLATE )
                    {
                    // InternalPerl.g:818:2: ( RULE_INTERPOLATE )
                    // InternalPerl.g:819:3: RULE_INTERPOLATE
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 
                    match(input,RULE_INTERPOLATE,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:824:2: ( RULE_LITERAL )
                    {
                    // InternalPerl.g:824:2: ( RULE_LITERAL )
                    // InternalPerl.g:825:3: RULE_LITERAL
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
    // InternalPerl.g:834:1: rule__QuoteLikeToken__Alternatives : ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) );
    public final void rule__QuoteLikeToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:838:1: ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) )
            int alt11=5;
            switch ( input.LA(1) ) {
            case RULE_BACKTICK_STRING:
                {
                alt11=1;
                }
                break;
            case RULE_WORDS_QUOTE_LIKE:
                {
                alt11=2;
                }
                break;
            case RULE_COMMAND_QUOTE_LIKE:
                {
                alt11=3;
                }
                break;
            case RULE_REGEX_QUOTE:
                {
                alt11=4;
                }
                break;
            case RULE_READLINE_QUOTE:
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalPerl.g:839:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    {
                    // InternalPerl.g:839:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    // InternalPerl.g:840:3: ( rule__QuoteLikeToken__Group_0__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_0()); 
                    // InternalPerl.g:841:3: ( rule__QuoteLikeToken__Group_0__0 )
                    // InternalPerl.g:841:4: rule__QuoteLikeToken__Group_0__0
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
                    // InternalPerl.g:845:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    {
                    // InternalPerl.g:845:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    // InternalPerl.g:846:3: ( rule__QuoteLikeToken__Group_1__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_1()); 
                    // InternalPerl.g:847:3: ( rule__QuoteLikeToken__Group_1__0 )
                    // InternalPerl.g:847:4: rule__QuoteLikeToken__Group_1__0
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
                    // InternalPerl.g:851:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    {
                    // InternalPerl.g:851:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    // InternalPerl.g:852:3: ( rule__QuoteLikeToken__Group_2__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_2()); 
                    // InternalPerl.g:853:3: ( rule__QuoteLikeToken__Group_2__0 )
                    // InternalPerl.g:853:4: rule__QuoteLikeToken__Group_2__0
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
                    // InternalPerl.g:857:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    {
                    // InternalPerl.g:857:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    // InternalPerl.g:858:3: ( rule__QuoteLikeToken__Group_3__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_3()); 
                    // InternalPerl.g:859:3: ( rule__QuoteLikeToken__Group_3__0 )
                    // InternalPerl.g:859:4: rule__QuoteLikeToken__Group_3__0
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
                    // InternalPerl.g:863:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    {
                    // InternalPerl.g:863:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    // InternalPerl.g:864:3: ( rule__QuoteLikeToken__Group_4__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_4()); 
                    // InternalPerl.g:865:3: ( rule__QuoteLikeToken__Group_4__0 )
                    // InternalPerl.g:865:4: rule__QuoteLikeToken__Group_4__0
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
    // InternalPerl.g:873:1: rule__Keyword__Alternatives : ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) );
    public final void rule__Keyword__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:877:1: ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) )
            int alt12=222;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt12=1;
                }
                break;
            case 33:
                {
                alt12=2;
                }
                break;
            case 34:
                {
                alt12=3;
                }
                break;
            case 35:
                {
                alt12=4;
                }
                break;
            case 36:
                {
                alt12=5;
                }
                break;
            case 37:
                {
                alt12=6;
                }
                break;
            case 38:
                {
                alt12=7;
                }
                break;
            case 39:
                {
                alt12=8;
                }
                break;
            case 40:
                {
                alt12=9;
                }
                break;
            case 41:
                {
                alt12=10;
                }
                break;
            case 42:
                {
                alt12=11;
                }
                break;
            case 43:
                {
                alt12=12;
                }
                break;
            case 44:
                {
                alt12=13;
                }
                break;
            case 45:
                {
                alt12=14;
                }
                break;
            case 46:
                {
                alt12=15;
                }
                break;
            case 47:
                {
                alt12=16;
                }
                break;
            case 48:
                {
                alt12=17;
                }
                break;
            case 49:
                {
                alt12=18;
                }
                break;
            case 50:
                {
                alt12=19;
                }
                break;
            case 51:
                {
                alt12=20;
                }
                break;
            case 52:
                {
                alt12=21;
                }
                break;
            case 53:
                {
                alt12=22;
                }
                break;
            case 54:
                {
                alt12=23;
                }
                break;
            case 55:
                {
                alt12=24;
                }
                break;
            case 56:
                {
                alt12=25;
                }
                break;
            case 57:
                {
                alt12=26;
                }
                break;
            case 58:
                {
                alt12=27;
                }
                break;
            case 59:
                {
                alt12=28;
                }
                break;
            case 60:
                {
                alt12=29;
                }
                break;
            case 61:
                {
                alt12=30;
                }
                break;
            case 62:
                {
                alt12=31;
                }
                break;
            case 63:
                {
                alt12=32;
                }
                break;
            case 64:
                {
                alt12=33;
                }
                break;
            case 65:
                {
                alt12=34;
                }
                break;
            case 66:
                {
                alt12=35;
                }
                break;
            case 67:
                {
                alt12=36;
                }
                break;
            case 68:
                {
                alt12=37;
                }
                break;
            case 69:
                {
                alt12=38;
                }
                break;
            case 70:
                {
                alt12=39;
                }
                break;
            case 71:
                {
                alt12=40;
                }
                break;
            case 72:
                {
                alt12=41;
                }
                break;
            case 73:
                {
                alt12=42;
                }
                break;
            case 74:
                {
                alt12=43;
                }
                break;
            case 75:
                {
                alt12=44;
                }
                break;
            case 76:
                {
                alt12=45;
                }
                break;
            case 77:
                {
                alt12=46;
                }
                break;
            case 78:
                {
                alt12=47;
                }
                break;
            case 79:
                {
                alt12=48;
                }
                break;
            case 80:
                {
                alt12=49;
                }
                break;
            case 81:
                {
                alt12=50;
                }
                break;
            case 82:
                {
                alt12=51;
                }
                break;
            case 83:
                {
                alt12=52;
                }
                break;
            case 84:
                {
                alt12=53;
                }
                break;
            case 85:
                {
                alt12=54;
                }
                break;
            case 86:
                {
                alt12=55;
                }
                break;
            case 87:
                {
                alt12=56;
                }
                break;
            case 88:
                {
                alt12=57;
                }
                break;
            case 89:
                {
                alt12=58;
                }
                break;
            case 90:
                {
                alt12=59;
                }
                break;
            case 91:
                {
                alt12=60;
                }
                break;
            case 92:
                {
                alt12=61;
                }
                break;
            case 93:
                {
                alt12=62;
                }
                break;
            case 94:
                {
                alt12=63;
                }
                break;
            case 95:
                {
                alt12=64;
                }
                break;
            case 96:
                {
                alt12=65;
                }
                break;
            case 97:
                {
                alt12=66;
                }
                break;
            case 98:
                {
                alt12=67;
                }
                break;
            case 99:
                {
                alt12=68;
                }
                break;
            case 100:
                {
                alt12=69;
                }
                break;
            case 101:
                {
                alt12=70;
                }
                break;
            case 102:
                {
                alt12=71;
                }
                break;
            case 103:
                {
                alt12=72;
                }
                break;
            case 104:
                {
                alt12=73;
                }
                break;
            case 105:
                {
                alt12=74;
                }
                break;
            case 106:
                {
                alt12=75;
                }
                break;
            case 107:
                {
                alt12=76;
                }
                break;
            case 108:
                {
                alt12=77;
                }
                break;
            case 109:
                {
                alt12=78;
                }
                break;
            case 110:
                {
                alt12=79;
                }
                break;
            case 111:
                {
                alt12=80;
                }
                break;
            case 112:
                {
                alt12=81;
                }
                break;
            case 113:
                {
                alt12=82;
                }
                break;
            case 114:
                {
                alt12=83;
                }
                break;
            case 115:
                {
                alt12=84;
                }
                break;
            case 116:
                {
                alt12=85;
                }
                break;
            case 117:
                {
                alt12=86;
                }
                break;
            case 118:
                {
                alt12=87;
                }
                break;
            case 119:
                {
                alt12=88;
                }
                break;
            case 120:
                {
                alt12=89;
                }
                break;
            case 121:
                {
                alt12=90;
                }
                break;
            case 122:
                {
                alt12=91;
                }
                break;
            case 123:
                {
                alt12=92;
                }
                break;
            case 124:
                {
                alt12=93;
                }
                break;
            case 125:
                {
                alt12=94;
                }
                break;
            case 126:
                {
                alt12=95;
                }
                break;
            case 127:
                {
                alt12=96;
                }
                break;
            case 128:
                {
                alt12=97;
                }
                break;
            case 129:
                {
                alt12=98;
                }
                break;
            case 130:
                {
                alt12=99;
                }
                break;
            case 131:
                {
                alt12=100;
                }
                break;
            case 132:
                {
                alt12=101;
                }
                break;
            case 133:
                {
                alt12=102;
                }
                break;
            case 134:
                {
                alt12=103;
                }
                break;
            case 135:
                {
                alt12=104;
                }
                break;
            case 136:
                {
                alt12=105;
                }
                break;
            case 137:
                {
                alt12=106;
                }
                break;
            case 138:
                {
                alt12=107;
                }
                break;
            case 139:
                {
                alt12=108;
                }
                break;
            case 140:
                {
                alt12=109;
                }
                break;
            case 141:
                {
                alt12=110;
                }
                break;
            case 142:
                {
                alt12=111;
                }
                break;
            case 143:
                {
                alt12=112;
                }
                break;
            case 144:
                {
                alt12=113;
                }
                break;
            case 145:
                {
                alt12=114;
                }
                break;
            case 146:
                {
                alt12=115;
                }
                break;
            case 147:
                {
                alt12=116;
                }
                break;
            case 148:
                {
                alt12=117;
                }
                break;
            case 149:
                {
                alt12=118;
                }
                break;
            case 150:
                {
                alt12=119;
                }
                break;
            case 151:
                {
                alt12=120;
                }
                break;
            case 152:
                {
                alt12=121;
                }
                break;
            case 153:
                {
                alt12=122;
                }
                break;
            case 154:
                {
                alt12=123;
                }
                break;
            case 155:
                {
                alt12=124;
                }
                break;
            case 156:
                {
                alt12=125;
                }
                break;
            case 157:
                {
                alt12=126;
                }
                break;
            case 158:
                {
                alt12=127;
                }
                break;
            case 159:
                {
                alt12=128;
                }
                break;
            case 160:
                {
                alt12=129;
                }
                break;
            case 161:
                {
                alt12=130;
                }
                break;
            case 162:
                {
                alt12=131;
                }
                break;
            case 163:
                {
                alt12=132;
                }
                break;
            case 164:
                {
                alt12=133;
                }
                break;
            case 165:
                {
                alt12=134;
                }
                break;
            case 166:
                {
                alt12=135;
                }
                break;
            case 167:
                {
                alt12=136;
                }
                break;
            case 168:
                {
                alt12=137;
                }
                break;
            case 169:
                {
                alt12=138;
                }
                break;
            case 170:
                {
                alt12=139;
                }
                break;
            case 171:
                {
                alt12=140;
                }
                break;
            case 172:
                {
                alt12=141;
                }
                break;
            case 173:
                {
                alt12=142;
                }
                break;
            case 174:
                {
                alt12=143;
                }
                break;
            case 175:
                {
                alt12=144;
                }
                break;
            case 176:
                {
                alt12=145;
                }
                break;
            case 177:
                {
                alt12=146;
                }
                break;
            case 178:
                {
                alt12=147;
                }
                break;
            case 179:
                {
                alt12=148;
                }
                break;
            case 180:
                {
                alt12=149;
                }
                break;
            case 181:
                {
                alt12=150;
                }
                break;
            case 182:
                {
                alt12=151;
                }
                break;
            case 183:
                {
                alt12=152;
                }
                break;
            case 184:
                {
                alt12=153;
                }
                break;
            case 185:
                {
                alt12=154;
                }
                break;
            case 186:
                {
                alt12=155;
                }
                break;
            case 187:
                {
                alt12=156;
                }
                break;
            case 188:
                {
                alt12=157;
                }
                break;
            case 189:
                {
                alt12=158;
                }
                break;
            case 190:
                {
                alt12=159;
                }
                break;
            case 191:
                {
                alt12=160;
                }
                break;
            case 192:
                {
                alt12=161;
                }
                break;
            case 193:
                {
                alt12=162;
                }
                break;
            case 194:
                {
                alt12=163;
                }
                break;
            case 195:
                {
                alt12=164;
                }
                break;
            case 196:
                {
                alt12=165;
                }
                break;
            case 197:
                {
                alt12=166;
                }
                break;
            case 198:
                {
                alt12=167;
                }
                break;
            case 199:
                {
                alt12=168;
                }
                break;
            case 200:
                {
                alt12=169;
                }
                break;
            case 201:
                {
                alt12=170;
                }
                break;
            case 202:
                {
                alt12=171;
                }
                break;
            case 203:
                {
                alt12=172;
                }
                break;
            case 204:
                {
                alt12=173;
                }
                break;
            case 205:
                {
                alt12=174;
                }
                break;
            case 206:
                {
                alt12=175;
                }
                break;
            case 207:
                {
                alt12=176;
                }
                break;
            case 208:
                {
                alt12=177;
                }
                break;
            case 209:
                {
                alt12=178;
                }
                break;
            case 210:
                {
                alt12=179;
                }
                break;
            case 211:
                {
                alt12=180;
                }
                break;
            case 212:
                {
                alt12=181;
                }
                break;
            case 213:
                {
                alt12=182;
                }
                break;
            case 214:
                {
                alt12=183;
                }
                break;
            case 215:
                {
                alt12=184;
                }
                break;
            case 216:
                {
                alt12=185;
                }
                break;
            case 217:
                {
                alt12=186;
                }
                break;
            case 218:
                {
                alt12=187;
                }
                break;
            case 219:
                {
                alt12=188;
                }
                break;
            case 220:
                {
                alt12=189;
                }
                break;
            case 221:
                {
                alt12=190;
                }
                break;
            case 222:
                {
                alt12=191;
                }
                break;
            case 223:
                {
                alt12=192;
                }
                break;
            case 224:
                {
                alt12=193;
                }
                break;
            case 225:
                {
                alt12=194;
                }
                break;
            case 226:
                {
                alt12=195;
                }
                break;
            case 227:
                {
                alt12=196;
                }
                break;
            case 228:
                {
                alt12=197;
                }
                break;
            case 229:
                {
                alt12=198;
                }
                break;
            case 230:
                {
                alt12=199;
                }
                break;
            case 231:
                {
                alt12=200;
                }
                break;
            case 232:
                {
                alt12=201;
                }
                break;
            case 233:
                {
                alt12=202;
                }
                break;
            case 234:
                {
                alt12=203;
                }
                break;
            case 235:
                {
                alt12=204;
                }
                break;
            case 236:
                {
                alt12=205;
                }
                break;
            case 237:
                {
                alt12=206;
                }
                break;
            case 238:
                {
                alt12=207;
                }
                break;
            case 239:
                {
                alt12=208;
                }
                break;
            case 240:
                {
                alt12=209;
                }
                break;
            case 241:
                {
                alt12=210;
                }
                break;
            case 242:
                {
                alt12=211;
                }
                break;
            case 243:
                {
                alt12=212;
                }
                break;
            case 244:
                {
                alt12=213;
                }
                break;
            case 245:
                {
                alt12=214;
                }
                break;
            case 246:
                {
                alt12=215;
                }
                break;
            case 247:
                {
                alt12=216;
                }
                break;
            case 248:
                {
                alt12=217;
                }
                break;
            case 249:
                {
                alt12=218;
                }
                break;
            case 250:
                {
                alt12=219;
                }
                break;
            case 251:
                {
                alt12=220;
                }
                break;
            case 252:
                {
                alt12=221;
                }
                break;
            case 253:
                {
                alt12=222;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalPerl.g:878:2: ( 'abs' )
                    {
                    // InternalPerl.g:878:2: ( 'abs' )
                    // InternalPerl.g:879:3: 'abs'
                    {
                     before(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:884:2: ( 'accept' )
                    {
                    // InternalPerl.g:884:2: ( 'accept' )
                    // InternalPerl.g:885:3: 'accept'
                    {
                     before(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:890:2: ( 'alarm' )
                    {
                    // InternalPerl.g:890:2: ( 'alarm' )
                    // InternalPerl.g:891:3: 'alarm'
                    {
                     before(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:896:2: ( 'atan2' )
                    {
                    // InternalPerl.g:896:2: ( 'atan2' )
                    // InternalPerl.g:897:3: 'atan2'
                    {
                     before(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:902:2: ( 'bind' )
                    {
                    // InternalPerl.g:902:2: ( 'bind' )
                    // InternalPerl.g:903:3: 'bind'
                    {
                     before(grammarAccess.getKeywordAccess().getBindKeyword_4()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBindKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:908:2: ( 'binmode' )
                    {
                    // InternalPerl.g:908:2: ( 'binmode' )
                    // InternalPerl.g:909:3: 'binmode'
                    {
                     before(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:914:2: ( 'bless' )
                    {
                    // InternalPerl.g:914:2: ( 'bless' )
                    // InternalPerl.g:915:3: 'bless'
                    {
                     before(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:920:2: ( 'break' )
                    {
                    // InternalPerl.g:920:2: ( 'break' )
                    // InternalPerl.g:921:3: 'break'
                    {
                     before(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:926:2: ( 'caller' )
                    {
                    // InternalPerl.g:926:2: ( 'caller' )
                    // InternalPerl.g:927:3: 'caller'
                    {
                     before(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:932:2: ( 'chdir' )
                    {
                    // InternalPerl.g:932:2: ( 'chdir' )
                    // InternalPerl.g:933:3: 'chdir'
                    {
                     before(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:938:2: ( 'chmod' )
                    {
                    // InternalPerl.g:938:2: ( 'chmod' )
                    // InternalPerl.g:939:3: 'chmod'
                    {
                     before(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:944:2: ( 'chomp' )
                    {
                    // InternalPerl.g:944:2: ( 'chomp' )
                    // InternalPerl.g:945:3: 'chomp'
                    {
                     before(grammarAccess.getKeywordAccess().getChompKeyword_11()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChompKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:950:2: ( 'chop' )
                    {
                    // InternalPerl.g:950:2: ( 'chop' )
                    // InternalPerl.g:951:3: 'chop'
                    {
                     before(grammarAccess.getKeywordAccess().getChopKeyword_12()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChopKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:956:2: ( 'chown' )
                    {
                    // InternalPerl.g:956:2: ( 'chown' )
                    // InternalPerl.g:957:3: 'chown'
                    {
                     before(grammarAccess.getKeywordAccess().getChownKeyword_13()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChownKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:962:2: ( 'chr' )
                    {
                    // InternalPerl.g:962:2: ( 'chr' )
                    // InternalPerl.g:963:3: 'chr'
                    {
                     before(grammarAccess.getKeywordAccess().getChrKeyword_14()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:968:2: ( 'chroot' )
                    {
                    // InternalPerl.g:968:2: ( 'chroot' )
                    // InternalPerl.g:969:3: 'chroot'
                    {
                     before(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:974:2: ( 'close' )
                    {
                    // InternalPerl.g:974:2: ( 'close' )
                    // InternalPerl.g:975:3: 'close'
                    {
                     before(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:980:2: ( 'closedir' )
                    {
                    // InternalPerl.g:980:2: ( 'closedir' )
                    // InternalPerl.g:981:3: 'closedir'
                    {
                     before(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:986:2: ( 'connect' )
                    {
                    // InternalPerl.g:986:2: ( 'connect' )
                    // InternalPerl.g:987:3: 'connect'
                    {
                     before(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:992:2: ( 'continue' )
                    {
                    // InternalPerl.g:992:2: ( 'continue' )
                    // InternalPerl.g:993:3: 'continue'
                    {
                     before(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:998:2: ( 'cos' )
                    {
                    // InternalPerl.g:998:2: ( 'cos' )
                    // InternalPerl.g:999:3: 'cos'
                    {
                     before(grammarAccess.getKeywordAccess().getCosKeyword_20()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCosKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:1004:2: ( 'crypt' )
                    {
                    // InternalPerl.g:1004:2: ( 'crypt' )
                    // InternalPerl.g:1005:3: 'crypt'
                    {
                     before(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:1010:2: ( 'dbmclose' )
                    {
                    // InternalPerl.g:1010:2: ( 'dbmclose' )
                    // InternalPerl.g:1011:3: 'dbmclose'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:1016:2: ( 'dbmopen' )
                    {
                    // InternalPerl.g:1016:2: ( 'dbmopen' )
                    // InternalPerl.g:1017:3: 'dbmopen'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:1022:2: ( 'default' )
                    {
                    // InternalPerl.g:1022:2: ( 'default' )
                    // InternalPerl.g:1023:3: 'default'
                    {
                     before(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:1028:2: ( 'defined' )
                    {
                    // InternalPerl.g:1028:2: ( 'defined' )
                    // InternalPerl.g:1029:3: 'defined'
                    {
                     before(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:1034:2: ( 'delete' )
                    {
                    // InternalPerl.g:1034:2: ( 'delete' )
                    // InternalPerl.g:1035:3: 'delete'
                    {
                     before(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:1040:2: ( 'die' )
                    {
                    // InternalPerl.g:1040:2: ( 'die' )
                    // InternalPerl.g:1041:3: 'die'
                    {
                     before(grammarAccess.getKeywordAccess().getDieKeyword_27()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDieKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:1046:2: ( 'do' )
                    {
                    // InternalPerl.g:1046:2: ( 'do' )
                    // InternalPerl.g:1047:3: 'do'
                    {
                     before(grammarAccess.getKeywordAccess().getDoKeyword_28()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDoKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:1052:2: ( 'dump' )
                    {
                    // InternalPerl.g:1052:2: ( 'dump' )
                    // InternalPerl.g:1053:3: 'dump'
                    {
                     before(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:1058:2: ( 'each' )
                    {
                    // InternalPerl.g:1058:2: ( 'each' )
                    // InternalPerl.g:1059:3: 'each'
                    {
                     before(grammarAccess.getKeywordAccess().getEachKeyword_30()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEachKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:1064:2: ( 'else' )
                    {
                    // InternalPerl.g:1064:2: ( 'else' )
                    // InternalPerl.g:1065:3: 'else'
                    {
                     before(grammarAccess.getKeywordAccess().getElseKeyword_31()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElseKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:1070:2: ( 'elsif' )
                    {
                    // InternalPerl.g:1070:2: ( 'elsif' )
                    // InternalPerl.g:1071:3: 'elsif'
                    {
                     before(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:1076:2: ( 'endgrent' )
                    {
                    // InternalPerl.g:1076:2: ( 'endgrent' )
                    // InternalPerl.g:1077:3: 'endgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:1082:2: ( 'endhostent' )
                    {
                    // InternalPerl.g:1082:2: ( 'endhostent' )
                    // InternalPerl.g:1083:3: 'endhostent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:1088:2: ( 'endnetent' )
                    {
                    // InternalPerl.g:1088:2: ( 'endnetent' )
                    // InternalPerl.g:1089:3: 'endnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:1094:2: ( 'endprotoent' )
                    {
                    // InternalPerl.g:1094:2: ( 'endprotoent' )
                    // InternalPerl.g:1095:3: 'endprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:1100:2: ( 'endpwent' )
                    {
                    // InternalPerl.g:1100:2: ( 'endpwent' )
                    // InternalPerl.g:1101:3: 'endpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:1106:2: ( 'endservent' )
                    {
                    // InternalPerl.g:1106:2: ( 'endservent' )
                    // InternalPerl.g:1107:3: 'endservent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:1112:2: ( 'eof' )
                    {
                    // InternalPerl.g:1112:2: ( 'eof' )
                    // InternalPerl.g:1113:3: 'eof'
                    {
                     before(grammarAccess.getKeywordAccess().getEofKeyword_39()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEofKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:1118:2: ( 'eval' )
                    {
                    // InternalPerl.g:1118:2: ( 'eval' )
                    // InternalPerl.g:1119:3: 'eval'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:1124:2: ( 'evalbytes' )
                    {
                    // InternalPerl.g:1124:2: ( 'evalbytes' )
                    // InternalPerl.g:1125:3: 'evalbytes'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:1130:2: ( 'exec' )
                    {
                    // InternalPerl.g:1130:2: ( 'exec' )
                    // InternalPerl.g:1131:3: 'exec'
                    {
                     before(grammarAccess.getKeywordAccess().getExecKeyword_42()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExecKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:1136:2: ( 'exists' )
                    {
                    // InternalPerl.g:1136:2: ( 'exists' )
                    // InternalPerl.g:1137:3: 'exists'
                    {
                     before(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 
                    match(input,75,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:1142:2: ( 'exit' )
                    {
                    // InternalPerl.g:1142:2: ( 'exit' )
                    // InternalPerl.g:1143:3: 'exit'
                    {
                     before(grammarAccess.getKeywordAccess().getExitKeyword_44()); 
                    match(input,76,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExitKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:1148:2: ( 'exp' )
                    {
                    // InternalPerl.g:1148:2: ( 'exp' )
                    // InternalPerl.g:1149:3: 'exp'
                    {
                     before(grammarAccess.getKeywordAccess().getExpKeyword_45()); 
                    match(input,77,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExpKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:1154:2: ( 'fc' )
                    {
                    // InternalPerl.g:1154:2: ( 'fc' )
                    // InternalPerl.g:1155:3: 'fc'
                    {
                     before(grammarAccess.getKeywordAccess().getFcKeyword_46()); 
                    match(input,78,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:1160:2: ( 'fcntl' )
                    {
                    // InternalPerl.g:1160:2: ( 'fcntl' )
                    // InternalPerl.g:1161:3: 'fcntl'
                    {
                     before(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 
                    match(input,79,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:1166:2: ( 'fileno' )
                    {
                    // InternalPerl.g:1166:2: ( 'fileno' )
                    // InternalPerl.g:1167:3: 'fileno'
                    {
                     before(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 
                    match(input,80,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:1172:2: ( 'flock' )
                    {
                    // InternalPerl.g:1172:2: ( 'flock' )
                    // InternalPerl.g:1173:3: 'flock'
                    {
                     before(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 
                    match(input,81,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:1178:2: ( 'for' )
                    {
                    // InternalPerl.g:1178:2: ( 'for' )
                    // InternalPerl.g:1179:3: 'for'
                    {
                     before(grammarAccess.getKeywordAccess().getForKeyword_50()); 
                    match(input,82,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:1184:2: ( 'foreach' )
                    {
                    // InternalPerl.g:1184:2: ( 'foreach' )
                    // InternalPerl.g:1185:3: 'foreach'
                    {
                     before(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 
                    match(input,83,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:1190:2: ( 'fork' )
                    {
                    // InternalPerl.g:1190:2: ( 'fork' )
                    // InternalPerl.g:1191:3: 'fork'
                    {
                     before(grammarAccess.getKeywordAccess().getForkKeyword_52()); 
                    match(input,84,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForkKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:1196:2: ( 'format' )
                    {
                    // InternalPerl.g:1196:2: ( 'format' )
                    // InternalPerl.g:1197:3: 'format'
                    {
                     before(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 
                    match(input,85,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:1202:2: ( 'formline' )
                    {
                    // InternalPerl.g:1202:2: ( 'formline' )
                    // InternalPerl.g:1203:3: 'formline'
                    {
                     before(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 
                    match(input,86,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:1208:2: ( 'getc' )
                    {
                    // InternalPerl.g:1208:2: ( 'getc' )
                    // InternalPerl.g:1209:3: 'getc'
                    {
                     before(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 
                    match(input,87,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:1214:2: ( 'getgrent' )
                    {
                    // InternalPerl.g:1214:2: ( 'getgrent' )
                    // InternalPerl.g:1215:3: 'getgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 
                    match(input,88,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:1220:2: ( 'getgrgid' )
                    {
                    // InternalPerl.g:1220:2: ( 'getgrgid' )
                    // InternalPerl.g:1221:3: 'getgrgid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 
                    match(input,89,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:1226:2: ( 'getgrnam' )
                    {
                    // InternalPerl.g:1226:2: ( 'getgrnam' )
                    // InternalPerl.g:1227:3: 'getgrnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 
                    match(input,90,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:1232:2: ( 'gethostbyaddr' )
                    {
                    // InternalPerl.g:1232:2: ( 'gethostbyaddr' )
                    // InternalPerl.g:1233:3: 'gethostbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 
                    match(input,91,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:1238:2: ( 'gethostbyname' )
                    {
                    // InternalPerl.g:1238:2: ( 'gethostbyname' )
                    // InternalPerl.g:1239:3: 'gethostbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 
                    match(input,92,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:1244:2: ( 'gethostent' )
                    {
                    // InternalPerl.g:1244:2: ( 'gethostent' )
                    // InternalPerl.g:1245:3: 'gethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 
                    match(input,93,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:1250:2: ( 'getlogin' )
                    {
                    // InternalPerl.g:1250:2: ( 'getlogin' )
                    // InternalPerl.g:1251:3: 'getlogin'
                    {
                     before(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 
                    match(input,94,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:1256:2: ( 'getnetbyaddr' )
                    {
                    // InternalPerl.g:1256:2: ( 'getnetbyaddr' )
                    // InternalPerl.g:1257:3: 'getnetbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 
                    match(input,95,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 

                    }


                    }
                    break;
                case 65 :
                    // InternalPerl.g:1262:2: ( 'getnetbyname' )
                    {
                    // InternalPerl.g:1262:2: ( 'getnetbyname' )
                    // InternalPerl.g:1263:3: 'getnetbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 
                    match(input,96,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 

                    }


                    }
                    break;
                case 66 :
                    // InternalPerl.g:1268:2: ( 'getnetent' )
                    {
                    // InternalPerl.g:1268:2: ( 'getnetent' )
                    // InternalPerl.g:1269:3: 'getnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 
                    match(input,97,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 

                    }


                    }
                    break;
                case 67 :
                    // InternalPerl.g:1274:2: ( 'getpeername' )
                    {
                    // InternalPerl.g:1274:2: ( 'getpeername' )
                    // InternalPerl.g:1275:3: 'getpeername'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 
                    match(input,98,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 

                    }


                    }
                    break;
                case 68 :
                    // InternalPerl.g:1280:2: ( 'getpgrp' )
                    {
                    // InternalPerl.g:1280:2: ( 'getpgrp' )
                    // InternalPerl.g:1281:3: 'getpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 
                    match(input,99,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 

                    }


                    }
                    break;
                case 69 :
                    // InternalPerl.g:1286:2: ( 'getppid' )
                    {
                    // InternalPerl.g:1286:2: ( 'getppid' )
                    // InternalPerl.g:1287:3: 'getppid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 
                    match(input,100,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 

                    }


                    }
                    break;
                case 70 :
                    // InternalPerl.g:1292:2: ( 'getpriority' )
                    {
                    // InternalPerl.g:1292:2: ( 'getpriority' )
                    // InternalPerl.g:1293:3: 'getpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 
                    match(input,101,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 

                    }


                    }
                    break;
                case 71 :
                    // InternalPerl.g:1298:2: ( 'getprotobyname' )
                    {
                    // InternalPerl.g:1298:2: ( 'getprotobyname' )
                    // InternalPerl.g:1299:3: 'getprotobyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 
                    match(input,102,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 

                    }


                    }
                    break;
                case 72 :
                    // InternalPerl.g:1304:2: ( 'getprotobynumber' )
                    {
                    // InternalPerl.g:1304:2: ( 'getprotobynumber' )
                    // InternalPerl.g:1305:3: 'getprotobynumber'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 
                    match(input,103,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 

                    }


                    }
                    break;
                case 73 :
                    // InternalPerl.g:1310:2: ( 'getprotoent' )
                    {
                    // InternalPerl.g:1310:2: ( 'getprotoent' )
                    // InternalPerl.g:1311:3: 'getprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 
                    match(input,104,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 

                    }


                    }
                    break;
                case 74 :
                    // InternalPerl.g:1316:2: ( 'getpwent' )
                    {
                    // InternalPerl.g:1316:2: ( 'getpwent' )
                    // InternalPerl.g:1317:3: 'getpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 
                    match(input,105,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 

                    }


                    }
                    break;
                case 75 :
                    // InternalPerl.g:1322:2: ( 'getpwnam' )
                    {
                    // InternalPerl.g:1322:2: ( 'getpwnam' )
                    // InternalPerl.g:1323:3: 'getpwnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 
                    match(input,106,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 

                    }


                    }
                    break;
                case 76 :
                    // InternalPerl.g:1328:2: ( 'getpwuid' )
                    {
                    // InternalPerl.g:1328:2: ( 'getpwuid' )
                    // InternalPerl.g:1329:3: 'getpwuid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 
                    match(input,107,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 

                    }


                    }
                    break;
                case 77 :
                    // InternalPerl.g:1334:2: ( 'getservbyname' )
                    {
                    // InternalPerl.g:1334:2: ( 'getservbyname' )
                    // InternalPerl.g:1335:3: 'getservbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 
                    match(input,108,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 

                    }


                    }
                    break;
                case 78 :
                    // InternalPerl.g:1340:2: ( 'getservbyport' )
                    {
                    // InternalPerl.g:1340:2: ( 'getservbyport' )
                    // InternalPerl.g:1341:3: 'getservbyport'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 
                    match(input,109,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 

                    }


                    }
                    break;
                case 79 :
                    // InternalPerl.g:1346:2: ( 'getservent' )
                    {
                    // InternalPerl.g:1346:2: ( 'getservent' )
                    // InternalPerl.g:1347:3: 'getservent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 
                    match(input,110,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 

                    }


                    }
                    break;
                case 80 :
                    // InternalPerl.g:1352:2: ( 'getsockname' )
                    {
                    // InternalPerl.g:1352:2: ( 'getsockname' )
                    // InternalPerl.g:1353:3: 'getsockname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 
                    match(input,111,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 

                    }


                    }
                    break;
                case 81 :
                    // InternalPerl.g:1358:2: ( 'getsockopt' )
                    {
                    // InternalPerl.g:1358:2: ( 'getsockopt' )
                    // InternalPerl.g:1359:3: 'getsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 
                    match(input,112,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 

                    }


                    }
                    break;
                case 82 :
                    // InternalPerl.g:1364:2: ( 'given' )
                    {
                    // InternalPerl.g:1364:2: ( 'given' )
                    // InternalPerl.g:1365:3: 'given'
                    {
                     before(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 
                    match(input,113,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 

                    }


                    }
                    break;
                case 83 :
                    // InternalPerl.g:1370:2: ( 'glob' )
                    {
                    // InternalPerl.g:1370:2: ( 'glob' )
                    // InternalPerl.g:1371:3: 'glob'
                    {
                     before(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 
                    match(input,114,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 

                    }


                    }
                    break;
                case 84 :
                    // InternalPerl.g:1376:2: ( 'gmtime' )
                    {
                    // InternalPerl.g:1376:2: ( 'gmtime' )
                    // InternalPerl.g:1377:3: 'gmtime'
                    {
                     before(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 
                    match(input,115,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 

                    }


                    }
                    break;
                case 85 :
                    // InternalPerl.g:1382:2: ( 'goto' )
                    {
                    // InternalPerl.g:1382:2: ( 'goto' )
                    // InternalPerl.g:1383:3: 'goto'
                    {
                     before(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 
                    match(input,116,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 

                    }


                    }
                    break;
                case 86 :
                    // InternalPerl.g:1388:2: ( 'grep' )
                    {
                    // InternalPerl.g:1388:2: ( 'grep' )
                    // InternalPerl.g:1389:3: 'grep'
                    {
                     before(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 
                    match(input,117,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 

                    }


                    }
                    break;
                case 87 :
                    // InternalPerl.g:1394:2: ( 'hex' )
                    {
                    // InternalPerl.g:1394:2: ( 'hex' )
                    // InternalPerl.g:1395:3: 'hex'
                    {
                     before(grammarAccess.getKeywordAccess().getHexKeyword_86()); 
                    match(input,118,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getHexKeyword_86()); 

                    }


                    }
                    break;
                case 88 :
                    // InternalPerl.g:1400:2: ( 'if' )
                    {
                    // InternalPerl.g:1400:2: ( 'if' )
                    // InternalPerl.g:1401:3: 'if'
                    {
                     before(grammarAccess.getKeywordAccess().getIfKeyword_87()); 
                    match(input,119,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIfKeyword_87()); 

                    }


                    }
                    break;
                case 89 :
                    // InternalPerl.g:1406:2: ( 'index' )
                    {
                    // InternalPerl.g:1406:2: ( 'index' )
                    // InternalPerl.g:1407:3: 'index'
                    {
                     before(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 
                    match(input,120,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 

                    }


                    }
                    break;
                case 90 :
                    // InternalPerl.g:1412:2: ( 'int' )
                    {
                    // InternalPerl.g:1412:2: ( 'int' )
                    // InternalPerl.g:1413:3: 'int'
                    {
                     before(grammarAccess.getKeywordAccess().getIntKeyword_89()); 
                    match(input,121,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIntKeyword_89()); 

                    }


                    }
                    break;
                case 91 :
                    // InternalPerl.g:1418:2: ( 'ioctl' )
                    {
                    // InternalPerl.g:1418:2: ( 'ioctl' )
                    // InternalPerl.g:1419:3: 'ioctl'
                    {
                     before(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 
                    match(input,122,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 

                    }


                    }
                    break;
                case 92 :
                    // InternalPerl.g:1424:2: ( 'join' )
                    {
                    // InternalPerl.g:1424:2: ( 'join' )
                    // InternalPerl.g:1425:3: 'join'
                    {
                     before(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 
                    match(input,123,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 

                    }


                    }
                    break;
                case 93 :
                    // InternalPerl.g:1430:2: ( 'keys' )
                    {
                    // InternalPerl.g:1430:2: ( 'keys' )
                    // InternalPerl.g:1431:3: 'keys'
                    {
                     before(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 
                    match(input,124,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 

                    }


                    }
                    break;
                case 94 :
                    // InternalPerl.g:1436:2: ( 'kill' )
                    {
                    // InternalPerl.g:1436:2: ( 'kill' )
                    // InternalPerl.g:1437:3: 'kill'
                    {
                     before(grammarAccess.getKeywordAccess().getKillKeyword_93()); 
                    match(input,125,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKillKeyword_93()); 

                    }


                    }
                    break;
                case 95 :
                    // InternalPerl.g:1442:2: ( 'last' )
                    {
                    // InternalPerl.g:1442:2: ( 'last' )
                    // InternalPerl.g:1443:3: 'last'
                    {
                     before(grammarAccess.getKeywordAccess().getLastKeyword_94()); 
                    match(input,126,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLastKeyword_94()); 

                    }


                    }
                    break;
                case 96 :
                    // InternalPerl.g:1448:2: ( 'lc' )
                    {
                    // InternalPerl.g:1448:2: ( 'lc' )
                    // InternalPerl.g:1449:3: 'lc'
                    {
                     before(grammarAccess.getKeywordAccess().getLcKeyword_95()); 
                    match(input,127,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcKeyword_95()); 

                    }


                    }
                    break;
                case 97 :
                    // InternalPerl.g:1454:2: ( 'lcfirst' )
                    {
                    // InternalPerl.g:1454:2: ( 'lcfirst' )
                    // InternalPerl.g:1455:3: 'lcfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 
                    match(input,128,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 

                    }


                    }
                    break;
                case 98 :
                    // InternalPerl.g:1460:2: ( 'length' )
                    {
                    // InternalPerl.g:1460:2: ( 'length' )
                    // InternalPerl.g:1461:3: 'length'
                    {
                     before(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 
                    match(input,129,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 

                    }


                    }
                    break;
                case 99 :
                    // InternalPerl.g:1466:2: ( 'link' )
                    {
                    // InternalPerl.g:1466:2: ( 'link' )
                    // InternalPerl.g:1467:3: 'link'
                    {
                     before(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 
                    match(input,130,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 

                    }


                    }
                    break;
                case 100 :
                    // InternalPerl.g:1472:2: ( 'listen' )
                    {
                    // InternalPerl.g:1472:2: ( 'listen' )
                    // InternalPerl.g:1473:3: 'listen'
                    {
                     before(grammarAccess.getKeywordAccess().getListenKeyword_99()); 
                    match(input,131,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getListenKeyword_99()); 

                    }


                    }
                    break;
                case 101 :
                    // InternalPerl.g:1478:2: ( 'local' )
                    {
                    // InternalPerl.g:1478:2: ( 'local' )
                    // InternalPerl.g:1479:3: 'local'
                    {
                     before(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 
                    match(input,132,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 

                    }


                    }
                    break;
                case 102 :
                    // InternalPerl.g:1484:2: ( 'localtime' )
                    {
                    // InternalPerl.g:1484:2: ( 'localtime' )
                    // InternalPerl.g:1485:3: 'localtime'
                    {
                     before(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 
                    match(input,133,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 

                    }


                    }
                    break;
                case 103 :
                    // InternalPerl.g:1490:2: ( 'lock' )
                    {
                    // InternalPerl.g:1490:2: ( 'lock' )
                    // InternalPerl.g:1491:3: 'lock'
                    {
                     before(grammarAccess.getKeywordAccess().getLockKeyword_102()); 
                    match(input,134,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLockKeyword_102()); 

                    }


                    }
                    break;
                case 104 :
                    // InternalPerl.g:1496:2: ( 'log' )
                    {
                    // InternalPerl.g:1496:2: ( 'log' )
                    // InternalPerl.g:1497:3: 'log'
                    {
                     before(grammarAccess.getKeywordAccess().getLogKeyword_103()); 
                    match(input,135,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLogKeyword_103()); 

                    }


                    }
                    break;
                case 105 :
                    // InternalPerl.g:1502:2: ( 'lstat' )
                    {
                    // InternalPerl.g:1502:2: ( 'lstat' )
                    // InternalPerl.g:1503:3: 'lstat'
                    {
                     before(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 
                    match(input,136,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 

                    }


                    }
                    break;
                case 106 :
                    // InternalPerl.g:1508:2: ( 'map' )
                    {
                    // InternalPerl.g:1508:2: ( 'map' )
                    // InternalPerl.g:1509:3: 'map'
                    {
                     before(grammarAccess.getKeywordAccess().getMapKeyword_105()); 
                    match(input,137,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMapKeyword_105()); 

                    }


                    }
                    break;
                case 107 :
                    // InternalPerl.g:1514:2: ( 'mkdir' )
                    {
                    // InternalPerl.g:1514:2: ( 'mkdir' )
                    // InternalPerl.g:1515:3: 'mkdir'
                    {
                     before(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 
                    match(input,138,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 

                    }


                    }
                    break;
                case 108 :
                    // InternalPerl.g:1520:2: ( 'msgctl' )
                    {
                    // InternalPerl.g:1520:2: ( 'msgctl' )
                    // InternalPerl.g:1521:3: 'msgctl'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 
                    match(input,139,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 

                    }


                    }
                    break;
                case 109 :
                    // InternalPerl.g:1526:2: ( 'msgget' )
                    {
                    // InternalPerl.g:1526:2: ( 'msgget' )
                    // InternalPerl.g:1527:3: 'msgget'
                    {
                     before(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 
                    match(input,140,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 

                    }


                    }
                    break;
                case 110 :
                    // InternalPerl.g:1532:2: ( 'msgrcv' )
                    {
                    // InternalPerl.g:1532:2: ( 'msgrcv' )
                    // InternalPerl.g:1533:3: 'msgrcv'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 
                    match(input,141,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 

                    }


                    }
                    break;
                case 111 :
                    // InternalPerl.g:1538:2: ( 'msgsnd' )
                    {
                    // InternalPerl.g:1538:2: ( 'msgsnd' )
                    // InternalPerl.g:1539:3: 'msgsnd'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 
                    match(input,142,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 

                    }


                    }
                    break;
                case 112 :
                    // InternalPerl.g:1544:2: ( 'my' )
                    {
                    // InternalPerl.g:1544:2: ( 'my' )
                    // InternalPerl.g:1545:3: 'my'
                    {
                     before(grammarAccess.getKeywordAccess().getMyKeyword_111()); 
                    match(input,143,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMyKeyword_111()); 

                    }


                    }
                    break;
                case 113 :
                    // InternalPerl.g:1550:2: ( 'next' )
                    {
                    // InternalPerl.g:1550:2: ( 'next' )
                    // InternalPerl.g:1551:3: 'next'
                    {
                     before(grammarAccess.getKeywordAccess().getNextKeyword_112()); 
                    match(input,144,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNextKeyword_112()); 

                    }


                    }
                    break;
                case 114 :
                    // InternalPerl.g:1556:2: ( 'no' )
                    {
                    // InternalPerl.g:1556:2: ( 'no' )
                    // InternalPerl.g:1557:3: 'no'
                    {
                     before(grammarAccess.getKeywordAccess().getNoKeyword_113()); 
                    match(input,145,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNoKeyword_113()); 

                    }


                    }
                    break;
                case 115 :
                    // InternalPerl.g:1562:2: ( 'oct' )
                    {
                    // InternalPerl.g:1562:2: ( 'oct' )
                    // InternalPerl.g:1563:3: 'oct'
                    {
                     before(grammarAccess.getKeywordAccess().getOctKeyword_114()); 
                    match(input,146,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOctKeyword_114()); 

                    }


                    }
                    break;
                case 116 :
                    // InternalPerl.g:1568:2: ( 'open' )
                    {
                    // InternalPerl.g:1568:2: ( 'open' )
                    // InternalPerl.g:1569:3: 'open'
                    {
                     before(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 
                    match(input,147,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 

                    }


                    }
                    break;
                case 117 :
                    // InternalPerl.g:1574:2: ( 'opendir' )
                    {
                    // InternalPerl.g:1574:2: ( 'opendir' )
                    // InternalPerl.g:1575:3: 'opendir'
                    {
                     before(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 
                    match(input,148,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 

                    }


                    }
                    break;
                case 118 :
                    // InternalPerl.g:1580:2: ( 'ord' )
                    {
                    // InternalPerl.g:1580:2: ( 'ord' )
                    // InternalPerl.g:1581:3: 'ord'
                    {
                     before(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 
                    match(input,149,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 

                    }


                    }
                    break;
                case 119 :
                    // InternalPerl.g:1586:2: ( 'our' )
                    {
                    // InternalPerl.g:1586:2: ( 'our' )
                    // InternalPerl.g:1587:3: 'our'
                    {
                     before(grammarAccess.getKeywordAccess().getOurKeyword_118()); 
                    match(input,150,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOurKeyword_118()); 

                    }


                    }
                    break;
                case 120 :
                    // InternalPerl.g:1592:2: ( 'pack' )
                    {
                    // InternalPerl.g:1592:2: ( 'pack' )
                    // InternalPerl.g:1593:3: 'pack'
                    {
                     before(grammarAccess.getKeywordAccess().getPackKeyword_119()); 
                    match(input,151,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackKeyword_119()); 

                    }


                    }
                    break;
                case 121 :
                    // InternalPerl.g:1598:2: ( 'package' )
                    {
                    // InternalPerl.g:1598:2: ( 'package' )
                    // InternalPerl.g:1599:3: 'package'
                    {
                     before(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 
                    match(input,152,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 

                    }


                    }
                    break;
                case 122 :
                    // InternalPerl.g:1604:2: ( 'pipe' )
                    {
                    // InternalPerl.g:1604:2: ( 'pipe' )
                    // InternalPerl.g:1605:3: 'pipe'
                    {
                     before(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 
                    match(input,153,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 

                    }


                    }
                    break;
                case 123 :
                    // InternalPerl.g:1610:2: ( 'pop' )
                    {
                    // InternalPerl.g:1610:2: ( 'pop' )
                    // InternalPerl.g:1611:3: 'pop'
                    {
                     before(grammarAccess.getKeywordAccess().getPopKeyword_122()); 
                    match(input,154,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPopKeyword_122()); 

                    }


                    }
                    break;
                case 124 :
                    // InternalPerl.g:1616:2: ( 'pos' )
                    {
                    // InternalPerl.g:1616:2: ( 'pos' )
                    // InternalPerl.g:1617:3: 'pos'
                    {
                     before(grammarAccess.getKeywordAccess().getPosKeyword_123()); 
                    match(input,155,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPosKeyword_123()); 

                    }


                    }
                    break;
                case 125 :
                    // InternalPerl.g:1622:2: ( 'print' )
                    {
                    // InternalPerl.g:1622:2: ( 'print' )
                    // InternalPerl.g:1623:3: 'print'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 
                    match(input,156,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 

                    }


                    }
                    break;
                case 126 :
                    // InternalPerl.g:1628:2: ( 'printf' )
                    {
                    // InternalPerl.g:1628:2: ( 'printf' )
                    // InternalPerl.g:1629:3: 'printf'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 
                    match(input,157,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 

                    }


                    }
                    break;
                case 127 :
                    // InternalPerl.g:1634:2: ( 'prototype' )
                    {
                    // InternalPerl.g:1634:2: ( 'prototype' )
                    // InternalPerl.g:1635:3: 'prototype'
                    {
                     before(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 
                    match(input,158,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 

                    }


                    }
                    break;
                case 128 :
                    // InternalPerl.g:1640:2: ( 'push' )
                    {
                    // InternalPerl.g:1640:2: ( 'push' )
                    // InternalPerl.g:1641:3: 'push'
                    {
                     before(grammarAccess.getKeywordAccess().getPushKeyword_127()); 
                    match(input,159,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPushKeyword_127()); 

                    }


                    }
                    break;
                case 129 :
                    // InternalPerl.g:1646:2: ( 'quotemeta' )
                    {
                    // InternalPerl.g:1646:2: ( 'quotemeta' )
                    // InternalPerl.g:1647:3: 'quotemeta'
                    {
                     before(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 
                    match(input,160,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 

                    }


                    }
                    break;
                case 130 :
                    // InternalPerl.g:1652:2: ( 'rand' )
                    {
                    // InternalPerl.g:1652:2: ( 'rand' )
                    // InternalPerl.g:1653:3: 'rand'
                    {
                     before(grammarAccess.getKeywordAccess().getRandKeyword_129()); 
                    match(input,161,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRandKeyword_129()); 

                    }


                    }
                    break;
                case 131 :
                    // InternalPerl.g:1658:2: ( 'read' )
                    {
                    // InternalPerl.g:1658:2: ( 'read' )
                    // InternalPerl.g:1659:3: 'read'
                    {
                     before(grammarAccess.getKeywordAccess().getReadKeyword_130()); 
                    match(input,162,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadKeyword_130()); 

                    }


                    }
                    break;
                case 132 :
                    // InternalPerl.g:1664:2: ( 'readdir' )
                    {
                    // InternalPerl.g:1664:2: ( 'readdir' )
                    // InternalPerl.g:1665:3: 'readdir'
                    {
                     before(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 
                    match(input,163,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 

                    }


                    }
                    break;
                case 133 :
                    // InternalPerl.g:1670:2: ( 'readline' )
                    {
                    // InternalPerl.g:1670:2: ( 'readline' )
                    // InternalPerl.g:1671:3: 'readline'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 
                    match(input,164,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 

                    }


                    }
                    break;
                case 134 :
                    // InternalPerl.g:1676:2: ( 'readlink' )
                    {
                    // InternalPerl.g:1676:2: ( 'readlink' )
                    // InternalPerl.g:1677:3: 'readlink'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 
                    match(input,165,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 

                    }


                    }
                    break;
                case 135 :
                    // InternalPerl.g:1682:2: ( 'readpipe' )
                    {
                    // InternalPerl.g:1682:2: ( 'readpipe' )
                    // InternalPerl.g:1683:3: 'readpipe'
                    {
                     before(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 
                    match(input,166,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 

                    }


                    }
                    break;
                case 136 :
                    // InternalPerl.g:1688:2: ( 'recv' )
                    {
                    // InternalPerl.g:1688:2: ( 'recv' )
                    // InternalPerl.g:1689:3: 'recv'
                    {
                     before(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 
                    match(input,167,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 

                    }


                    }
                    break;
                case 137 :
                    // InternalPerl.g:1694:2: ( 'redo' )
                    {
                    // InternalPerl.g:1694:2: ( 'redo' )
                    // InternalPerl.g:1695:3: 'redo'
                    {
                     before(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 
                    match(input,168,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 

                    }


                    }
                    break;
                case 138 :
                    // InternalPerl.g:1700:2: ( 'ref' )
                    {
                    // InternalPerl.g:1700:2: ( 'ref' )
                    // InternalPerl.g:1701:3: 'ref'
                    {
                     before(grammarAccess.getKeywordAccess().getRefKeyword_137()); 
                    match(input,169,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRefKeyword_137()); 

                    }


                    }
                    break;
                case 139 :
                    // InternalPerl.g:1706:2: ( 'rename' )
                    {
                    // InternalPerl.g:1706:2: ( 'rename' )
                    // InternalPerl.g:1707:3: 'rename'
                    {
                     before(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 
                    match(input,170,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 

                    }


                    }
                    break;
                case 140 :
                    // InternalPerl.g:1712:2: ( 'require' )
                    {
                    // InternalPerl.g:1712:2: ( 'require' )
                    // InternalPerl.g:1713:3: 'require'
                    {
                     before(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 
                    match(input,171,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 

                    }


                    }
                    break;
                case 141 :
                    // InternalPerl.g:1718:2: ( 'reset' )
                    {
                    // InternalPerl.g:1718:2: ( 'reset' )
                    // InternalPerl.g:1719:3: 'reset'
                    {
                     before(grammarAccess.getKeywordAccess().getResetKeyword_140()); 
                    match(input,172,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getResetKeyword_140()); 

                    }


                    }
                    break;
                case 142 :
                    // InternalPerl.g:1724:2: ( 'return' )
                    {
                    // InternalPerl.g:1724:2: ( 'return' )
                    // InternalPerl.g:1725:3: 'return'
                    {
                     before(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 
                    match(input,173,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 

                    }


                    }
                    break;
                case 143 :
                    // InternalPerl.g:1730:2: ( 'reverse' )
                    {
                    // InternalPerl.g:1730:2: ( 'reverse' )
                    // InternalPerl.g:1731:3: 'reverse'
                    {
                     before(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 
                    match(input,174,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 

                    }


                    }
                    break;
                case 144 :
                    // InternalPerl.g:1736:2: ( 'rewinddir' )
                    {
                    // InternalPerl.g:1736:2: ( 'rewinddir' )
                    // InternalPerl.g:1737:3: 'rewinddir'
                    {
                     before(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 
                    match(input,175,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 

                    }


                    }
                    break;
                case 145 :
                    // InternalPerl.g:1742:2: ( 'rindex' )
                    {
                    // InternalPerl.g:1742:2: ( 'rindex' )
                    // InternalPerl.g:1743:3: 'rindex'
                    {
                     before(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 
                    match(input,176,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 

                    }


                    }
                    break;
                case 146 :
                    // InternalPerl.g:1748:2: ( 'rmdir' )
                    {
                    // InternalPerl.g:1748:2: ( 'rmdir' )
                    // InternalPerl.g:1749:3: 'rmdir'
                    {
                     before(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 
                    match(input,177,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 

                    }


                    }
                    break;
                case 147 :
                    // InternalPerl.g:1754:2: ( 'say' )
                    {
                    // InternalPerl.g:1754:2: ( 'say' )
                    // InternalPerl.g:1755:3: 'say'
                    {
                     before(grammarAccess.getKeywordAccess().getSayKeyword_146()); 
                    match(input,178,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSayKeyword_146()); 

                    }


                    }
                    break;
                case 148 :
                    // InternalPerl.g:1760:2: ( 'scalar' )
                    {
                    // InternalPerl.g:1760:2: ( 'scalar' )
                    // InternalPerl.g:1761:3: 'scalar'
                    {
                     before(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 
                    match(input,179,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 

                    }


                    }
                    break;
                case 149 :
                    // InternalPerl.g:1766:2: ( 'seek' )
                    {
                    // InternalPerl.g:1766:2: ( 'seek' )
                    // InternalPerl.g:1767:3: 'seek'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 
                    match(input,180,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 

                    }


                    }
                    break;
                case 150 :
                    // InternalPerl.g:1772:2: ( 'seekdir' )
                    {
                    // InternalPerl.g:1772:2: ( 'seekdir' )
                    // InternalPerl.g:1773:3: 'seekdir'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 
                    match(input,181,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 

                    }


                    }
                    break;
                case 151 :
                    // InternalPerl.g:1778:2: ( 'select' )
                    {
                    // InternalPerl.g:1778:2: ( 'select' )
                    // InternalPerl.g:1779:3: 'select'
                    {
                     before(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 
                    match(input,182,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 

                    }


                    }
                    break;
                case 152 :
                    // InternalPerl.g:1784:2: ( 'semctl' )
                    {
                    // InternalPerl.g:1784:2: ( 'semctl' )
                    // InternalPerl.g:1785:3: 'semctl'
                    {
                     before(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 
                    match(input,183,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 

                    }


                    }
                    break;
                case 153 :
                    // InternalPerl.g:1790:2: ( 'semget' )
                    {
                    // InternalPerl.g:1790:2: ( 'semget' )
                    // InternalPerl.g:1791:3: 'semget'
                    {
                     before(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 
                    match(input,184,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 

                    }


                    }
                    break;
                case 154 :
                    // InternalPerl.g:1796:2: ( 'semop' )
                    {
                    // InternalPerl.g:1796:2: ( 'semop' )
                    // InternalPerl.g:1797:3: 'semop'
                    {
                     before(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 
                    match(input,185,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 

                    }


                    }
                    break;
                case 155 :
                    // InternalPerl.g:1802:2: ( 'send' )
                    {
                    // InternalPerl.g:1802:2: ( 'send' )
                    // InternalPerl.g:1803:3: 'send'
                    {
                     before(grammarAccess.getKeywordAccess().getSendKeyword_154()); 
                    match(input,186,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSendKeyword_154()); 

                    }


                    }
                    break;
                case 156 :
                    // InternalPerl.g:1808:2: ( 'setgrent' )
                    {
                    // InternalPerl.g:1808:2: ( 'setgrent' )
                    // InternalPerl.g:1809:3: 'setgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 
                    match(input,187,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 

                    }


                    }
                    break;
                case 157 :
                    // InternalPerl.g:1814:2: ( 'sethostent' )
                    {
                    // InternalPerl.g:1814:2: ( 'sethostent' )
                    // InternalPerl.g:1815:3: 'sethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 
                    match(input,188,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 

                    }


                    }
                    break;
                case 158 :
                    // InternalPerl.g:1820:2: ( 'setnetent' )
                    {
                    // InternalPerl.g:1820:2: ( 'setnetent' )
                    // InternalPerl.g:1821:3: 'setnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 
                    match(input,189,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 

                    }


                    }
                    break;
                case 159 :
                    // InternalPerl.g:1826:2: ( 'setpgrp' )
                    {
                    // InternalPerl.g:1826:2: ( 'setpgrp' )
                    // InternalPerl.g:1827:3: 'setpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 
                    match(input,190,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 

                    }


                    }
                    break;
                case 160 :
                    // InternalPerl.g:1832:2: ( 'setpriority' )
                    {
                    // InternalPerl.g:1832:2: ( 'setpriority' )
                    // InternalPerl.g:1833:3: 'setpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 
                    match(input,191,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 

                    }


                    }
                    break;
                case 161 :
                    // InternalPerl.g:1838:2: ( 'setprotoent' )
                    {
                    // InternalPerl.g:1838:2: ( 'setprotoent' )
                    // InternalPerl.g:1839:3: 'setprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 
                    match(input,192,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 

                    }


                    }
                    break;
                case 162 :
                    // InternalPerl.g:1844:2: ( 'setpwent' )
                    {
                    // InternalPerl.g:1844:2: ( 'setpwent' )
                    // InternalPerl.g:1845:3: 'setpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 
                    match(input,193,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 

                    }


                    }
                    break;
                case 163 :
                    // InternalPerl.g:1850:2: ( 'setservent' )
                    {
                    // InternalPerl.g:1850:2: ( 'setservent' )
                    // InternalPerl.g:1851:3: 'setservent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 
                    match(input,194,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 

                    }


                    }
                    break;
                case 164 :
                    // InternalPerl.g:1856:2: ( 'setsockopt' )
                    {
                    // InternalPerl.g:1856:2: ( 'setsockopt' )
                    // InternalPerl.g:1857:3: 'setsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 
                    match(input,195,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 

                    }


                    }
                    break;
                case 165 :
                    // InternalPerl.g:1862:2: ( 'shift' )
                    {
                    // InternalPerl.g:1862:2: ( 'shift' )
                    // InternalPerl.g:1863:3: 'shift'
                    {
                     before(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 
                    match(input,196,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 

                    }


                    }
                    break;
                case 166 :
                    // InternalPerl.g:1868:2: ( 'shmctl' )
                    {
                    // InternalPerl.g:1868:2: ( 'shmctl' )
                    // InternalPerl.g:1869:3: 'shmctl'
                    {
                     before(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 
                    match(input,197,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 

                    }


                    }
                    break;
                case 167 :
                    // InternalPerl.g:1874:2: ( 'shmget' )
                    {
                    // InternalPerl.g:1874:2: ( 'shmget' )
                    // InternalPerl.g:1875:3: 'shmget'
                    {
                     before(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 
                    match(input,198,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 

                    }


                    }
                    break;
                case 168 :
                    // InternalPerl.g:1880:2: ( 'shmread' )
                    {
                    // InternalPerl.g:1880:2: ( 'shmread' )
                    // InternalPerl.g:1881:3: 'shmread'
                    {
                     before(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 
                    match(input,199,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 

                    }


                    }
                    break;
                case 169 :
                    // InternalPerl.g:1886:2: ( 'shmwrite' )
                    {
                    // InternalPerl.g:1886:2: ( 'shmwrite' )
                    // InternalPerl.g:1887:3: 'shmwrite'
                    {
                     before(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 
                    match(input,200,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 

                    }


                    }
                    break;
                case 170 :
                    // InternalPerl.g:1892:2: ( 'shutdown' )
                    {
                    // InternalPerl.g:1892:2: ( 'shutdown' )
                    // InternalPerl.g:1893:3: 'shutdown'
                    {
                     before(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 
                    match(input,201,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 

                    }


                    }
                    break;
                case 171 :
                    // InternalPerl.g:1898:2: ( 'sin' )
                    {
                    // InternalPerl.g:1898:2: ( 'sin' )
                    // InternalPerl.g:1899:3: 'sin'
                    {
                     before(grammarAccess.getKeywordAccess().getSinKeyword_170()); 
                    match(input,202,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSinKeyword_170()); 

                    }


                    }
                    break;
                case 172 :
                    // InternalPerl.g:1904:2: ( 'sleep' )
                    {
                    // InternalPerl.g:1904:2: ( 'sleep' )
                    // InternalPerl.g:1905:3: 'sleep'
                    {
                     before(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 
                    match(input,203,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 

                    }


                    }
                    break;
                case 173 :
                    // InternalPerl.g:1910:2: ( 'socket' )
                    {
                    // InternalPerl.g:1910:2: ( 'socket' )
                    // InternalPerl.g:1911:3: 'socket'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 
                    match(input,204,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 

                    }


                    }
                    break;
                case 174 :
                    // InternalPerl.g:1916:2: ( 'socketpair' )
                    {
                    // InternalPerl.g:1916:2: ( 'socketpair' )
                    // InternalPerl.g:1917:3: 'socketpair'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 
                    match(input,205,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 

                    }


                    }
                    break;
                case 175 :
                    // InternalPerl.g:1922:2: ( 'sort' )
                    {
                    // InternalPerl.g:1922:2: ( 'sort' )
                    // InternalPerl.g:1923:3: 'sort'
                    {
                     before(grammarAccess.getKeywordAccess().getSortKeyword_174()); 
                    match(input,206,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSortKeyword_174()); 

                    }


                    }
                    break;
                case 176 :
                    // InternalPerl.g:1928:2: ( 'splice' )
                    {
                    // InternalPerl.g:1928:2: ( 'splice' )
                    // InternalPerl.g:1929:3: 'splice'
                    {
                     before(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 
                    match(input,207,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 

                    }


                    }
                    break;
                case 177 :
                    // InternalPerl.g:1934:2: ( 'split' )
                    {
                    // InternalPerl.g:1934:2: ( 'split' )
                    // InternalPerl.g:1935:3: 'split'
                    {
                     before(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 
                    match(input,208,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 

                    }


                    }
                    break;
                case 178 :
                    // InternalPerl.g:1940:2: ( 'sprintf' )
                    {
                    // InternalPerl.g:1940:2: ( 'sprintf' )
                    // InternalPerl.g:1941:3: 'sprintf'
                    {
                     before(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 
                    match(input,209,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 

                    }


                    }
                    break;
                case 179 :
                    // InternalPerl.g:1946:2: ( 'sqrt' )
                    {
                    // InternalPerl.g:1946:2: ( 'sqrt' )
                    // InternalPerl.g:1947:3: 'sqrt'
                    {
                     before(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 
                    match(input,210,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 

                    }


                    }
                    break;
                case 180 :
                    // InternalPerl.g:1952:2: ( 'srand' )
                    {
                    // InternalPerl.g:1952:2: ( 'srand' )
                    // InternalPerl.g:1953:3: 'srand'
                    {
                     before(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 
                    match(input,211,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 

                    }


                    }
                    break;
                case 181 :
                    // InternalPerl.g:1958:2: ( 'stat' )
                    {
                    // InternalPerl.g:1958:2: ( 'stat' )
                    // InternalPerl.g:1959:3: 'stat'
                    {
                     before(grammarAccess.getKeywordAccess().getStatKeyword_180()); 
                    match(input,212,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStatKeyword_180()); 

                    }


                    }
                    break;
                case 182 :
                    // InternalPerl.g:1964:2: ( 'state' )
                    {
                    // InternalPerl.g:1964:2: ( 'state' )
                    // InternalPerl.g:1965:3: 'state'
                    {
                     before(grammarAccess.getKeywordAccess().getStateKeyword_181()); 
                    match(input,213,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStateKeyword_181()); 

                    }


                    }
                    break;
                case 183 :
                    // InternalPerl.g:1970:2: ( 'study' )
                    {
                    // InternalPerl.g:1970:2: ( 'study' )
                    // InternalPerl.g:1971:3: 'study'
                    {
                     before(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 
                    match(input,214,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 

                    }


                    }
                    break;
                case 184 :
                    // InternalPerl.g:1976:2: ( 'sub' )
                    {
                    // InternalPerl.g:1976:2: ( 'sub' )
                    // InternalPerl.g:1977:3: 'sub'
                    {
                     before(grammarAccess.getKeywordAccess().getSubKeyword_183()); 
                    match(input,215,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubKeyword_183()); 

                    }


                    }
                    break;
                case 185 :
                    // InternalPerl.g:1982:2: ( 'substr' )
                    {
                    // InternalPerl.g:1982:2: ( 'substr' )
                    // InternalPerl.g:1983:3: 'substr'
                    {
                     before(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 
                    match(input,216,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 

                    }


                    }
                    break;
                case 186 :
                    // InternalPerl.g:1988:2: ( 'symlink' )
                    {
                    // InternalPerl.g:1988:2: ( 'symlink' )
                    // InternalPerl.g:1989:3: 'symlink'
                    {
                     before(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 
                    match(input,217,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 

                    }


                    }
                    break;
                case 187 :
                    // InternalPerl.g:1994:2: ( 'syscall' )
                    {
                    // InternalPerl.g:1994:2: ( 'syscall' )
                    // InternalPerl.g:1995:3: 'syscall'
                    {
                     before(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 
                    match(input,218,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 

                    }


                    }
                    break;
                case 188 :
                    // InternalPerl.g:2000:2: ( 'sysopen' )
                    {
                    // InternalPerl.g:2000:2: ( 'sysopen' )
                    // InternalPerl.g:2001:3: 'sysopen'
                    {
                     before(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 
                    match(input,219,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 

                    }


                    }
                    break;
                case 189 :
                    // InternalPerl.g:2006:2: ( 'sysread' )
                    {
                    // InternalPerl.g:2006:2: ( 'sysread' )
                    // InternalPerl.g:2007:3: 'sysread'
                    {
                     before(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 
                    match(input,220,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 

                    }


                    }
                    break;
                case 190 :
                    // InternalPerl.g:2012:2: ( 'sysseek' )
                    {
                    // InternalPerl.g:2012:2: ( 'sysseek' )
                    // InternalPerl.g:2013:3: 'sysseek'
                    {
                     before(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 
                    match(input,221,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 

                    }


                    }
                    break;
                case 191 :
                    // InternalPerl.g:2018:2: ( 'system' )
                    {
                    // InternalPerl.g:2018:2: ( 'system' )
                    // InternalPerl.g:2019:3: 'system'
                    {
                     before(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 
                    match(input,222,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 

                    }


                    }
                    break;
                case 192 :
                    // InternalPerl.g:2024:2: ( 'syswrite' )
                    {
                    // InternalPerl.g:2024:2: ( 'syswrite' )
                    // InternalPerl.g:2025:3: 'syswrite'
                    {
                     before(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 
                    match(input,223,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 

                    }


                    }
                    break;
                case 193 :
                    // InternalPerl.g:2030:2: ( 'tell' )
                    {
                    // InternalPerl.g:2030:2: ( 'tell' )
                    // InternalPerl.g:2031:3: 'tell'
                    {
                     before(grammarAccess.getKeywordAccess().getTellKeyword_192()); 
                    match(input,224,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTellKeyword_192()); 

                    }


                    }
                    break;
                case 194 :
                    // InternalPerl.g:2036:2: ( 'telldir' )
                    {
                    // InternalPerl.g:2036:2: ( 'telldir' )
                    // InternalPerl.g:2037:3: 'telldir'
                    {
                     before(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 
                    match(input,225,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 

                    }


                    }
                    break;
                case 195 :
                    // InternalPerl.g:2042:2: ( 'tie' )
                    {
                    // InternalPerl.g:2042:2: ( 'tie' )
                    // InternalPerl.g:2043:3: 'tie'
                    {
                     before(grammarAccess.getKeywordAccess().getTieKeyword_194()); 
                    match(input,226,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTieKeyword_194()); 

                    }


                    }
                    break;
                case 196 :
                    // InternalPerl.g:2048:2: ( 'tied' )
                    {
                    // InternalPerl.g:2048:2: ( 'tied' )
                    // InternalPerl.g:2049:3: 'tied'
                    {
                     before(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 
                    match(input,227,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 

                    }


                    }
                    break;
                case 197 :
                    // InternalPerl.g:2054:2: ( 'time' )
                    {
                    // InternalPerl.g:2054:2: ( 'time' )
                    // InternalPerl.g:2055:3: 'time'
                    {
                     before(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 
                    match(input,228,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 

                    }


                    }
                    break;
                case 198 :
                    // InternalPerl.g:2060:2: ( 'times' )
                    {
                    // InternalPerl.g:2060:2: ( 'times' )
                    // InternalPerl.g:2061:3: 'times'
                    {
                     before(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 
                    match(input,229,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 

                    }


                    }
                    break;
                case 199 :
                    // InternalPerl.g:2066:2: ( 'tr' )
                    {
                    // InternalPerl.g:2066:2: ( 'tr' )
                    // InternalPerl.g:2067:3: 'tr'
                    {
                     before(grammarAccess.getKeywordAccess().getTrKeyword_198()); 
                    match(input,230,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTrKeyword_198()); 

                    }


                    }
                    break;
                case 200 :
                    // InternalPerl.g:2072:2: ( 'truncate' )
                    {
                    // InternalPerl.g:2072:2: ( 'truncate' )
                    // InternalPerl.g:2073:3: 'truncate'
                    {
                     before(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 
                    match(input,231,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 

                    }


                    }
                    break;
                case 201 :
                    // InternalPerl.g:2078:2: ( 'uc' )
                    {
                    // InternalPerl.g:2078:2: ( 'uc' )
                    // InternalPerl.g:2079:3: 'uc'
                    {
                     before(grammarAccess.getKeywordAccess().getUcKeyword_200()); 
                    match(input,232,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcKeyword_200()); 

                    }


                    }
                    break;
                case 202 :
                    // InternalPerl.g:2084:2: ( 'ucfirst' )
                    {
                    // InternalPerl.g:2084:2: ( 'ucfirst' )
                    // InternalPerl.g:2085:3: 'ucfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 
                    match(input,233,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 

                    }


                    }
                    break;
                case 203 :
                    // InternalPerl.g:2090:2: ( 'umask' )
                    {
                    // InternalPerl.g:2090:2: ( 'umask' )
                    // InternalPerl.g:2091:3: 'umask'
                    {
                     before(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 
                    match(input,234,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 

                    }


                    }
                    break;
                case 204 :
                    // InternalPerl.g:2096:2: ( 'undef' )
                    {
                    // InternalPerl.g:2096:2: ( 'undef' )
                    // InternalPerl.g:2097:3: 'undef'
                    {
                     before(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 
                    match(input,235,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 

                    }


                    }
                    break;
                case 205 :
                    // InternalPerl.g:2102:2: ( 'unless' )
                    {
                    // InternalPerl.g:2102:2: ( 'unless' )
                    // InternalPerl.g:2103:3: 'unless'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 
                    match(input,236,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 

                    }


                    }
                    break;
                case 206 :
                    // InternalPerl.g:2108:2: ( 'unlink' )
                    {
                    // InternalPerl.g:2108:2: ( 'unlink' )
                    // InternalPerl.g:2109:3: 'unlink'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 
                    match(input,237,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 

                    }


                    }
                    break;
                case 207 :
                    // InternalPerl.g:2114:2: ( 'unpack' )
                    {
                    // InternalPerl.g:2114:2: ( 'unpack' )
                    // InternalPerl.g:2115:3: 'unpack'
                    {
                     before(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 
                    match(input,238,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 

                    }


                    }
                    break;
                case 208 :
                    // InternalPerl.g:2120:2: ( 'unshift' )
                    {
                    // InternalPerl.g:2120:2: ( 'unshift' )
                    // InternalPerl.g:2121:3: 'unshift'
                    {
                     before(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 
                    match(input,239,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 

                    }


                    }
                    break;
                case 209 :
                    // InternalPerl.g:2126:2: ( 'untie' )
                    {
                    // InternalPerl.g:2126:2: ( 'untie' )
                    // InternalPerl.g:2127:3: 'untie'
                    {
                     before(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 
                    match(input,240,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 

                    }


                    }
                    break;
                case 210 :
                    // InternalPerl.g:2132:2: ( 'until' )
                    {
                    // InternalPerl.g:2132:2: ( 'until' )
                    // InternalPerl.g:2133:3: 'until'
                    {
                     before(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 
                    match(input,241,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 

                    }


                    }
                    break;
                case 211 :
                    // InternalPerl.g:2138:2: ( 'use' )
                    {
                    // InternalPerl.g:2138:2: ( 'use' )
                    // InternalPerl.g:2139:3: 'use'
                    {
                     before(grammarAccess.getKeywordAccess().getUseKeyword_210()); 
                    match(input,242,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUseKeyword_210()); 

                    }


                    }
                    break;
                case 212 :
                    // InternalPerl.g:2144:2: ( 'utime' )
                    {
                    // InternalPerl.g:2144:2: ( 'utime' )
                    // InternalPerl.g:2145:3: 'utime'
                    {
                     before(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 
                    match(input,243,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 

                    }


                    }
                    break;
                case 213 :
                    // InternalPerl.g:2150:2: ( 'values' )
                    {
                    // InternalPerl.g:2150:2: ( 'values' )
                    // InternalPerl.g:2151:3: 'values'
                    {
                     before(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 
                    match(input,244,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 

                    }


                    }
                    break;
                case 214 :
                    // InternalPerl.g:2156:2: ( 'vec' )
                    {
                    // InternalPerl.g:2156:2: ( 'vec' )
                    // InternalPerl.g:2157:3: 'vec'
                    {
                     before(grammarAccess.getKeywordAccess().getVecKeyword_213()); 
                    match(input,245,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getVecKeyword_213()); 

                    }


                    }
                    break;
                case 215 :
                    // InternalPerl.g:2162:2: ( 'wait' )
                    {
                    // InternalPerl.g:2162:2: ( 'wait' )
                    // InternalPerl.g:2163:3: 'wait'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 
                    match(input,246,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 

                    }


                    }
                    break;
                case 216 :
                    // InternalPerl.g:2168:2: ( 'waitpid' )
                    {
                    // InternalPerl.g:2168:2: ( 'waitpid' )
                    // InternalPerl.g:2169:3: 'waitpid'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 
                    match(input,247,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 

                    }


                    }
                    break;
                case 217 :
                    // InternalPerl.g:2174:2: ( 'wantarray' )
                    {
                    // InternalPerl.g:2174:2: ( 'wantarray' )
                    // InternalPerl.g:2175:3: 'wantarray'
                    {
                     before(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 
                    match(input,248,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 

                    }


                    }
                    break;
                case 218 :
                    // InternalPerl.g:2180:2: ( 'warn' )
                    {
                    // InternalPerl.g:2180:2: ( 'warn' )
                    // InternalPerl.g:2181:3: 'warn'
                    {
                     before(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 
                    match(input,249,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 

                    }


                    }
                    break;
                case 219 :
                    // InternalPerl.g:2186:2: ( 'when' )
                    {
                    // InternalPerl.g:2186:2: ( 'when' )
                    // InternalPerl.g:2187:3: 'when'
                    {
                     before(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 
                    match(input,250,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 

                    }


                    }
                    break;
                case 220 :
                    // InternalPerl.g:2192:2: ( 'while' )
                    {
                    // InternalPerl.g:2192:2: ( 'while' )
                    // InternalPerl.g:2193:3: 'while'
                    {
                     before(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 
                    match(input,251,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 

                    }


                    }
                    break;
                case 221 :
                    // InternalPerl.g:2198:2: ( 'write' )
                    {
                    // InternalPerl.g:2198:2: ( 'write' )
                    // InternalPerl.g:2199:3: 'write'
                    {
                     before(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 
                    match(input,252,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 

                    }


                    }
                    break;
                case 222 :
                    // InternalPerl.g:2204:2: ( 'y' )
                    {
                    // InternalPerl.g:2204:2: ( 'y' )
                    // InternalPerl.g:2205:3: 'y'
                    {
                     before(grammarAccess.getKeywordAccess().getYKeyword_221()); 
                    match(input,253,FOLLOW_2); 
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
    // InternalPerl.g:2214:1: rule__Operator__Alternatives : ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2218:1: ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) )
            int alt13=64;
            switch ( input.LA(1) ) {
            case 254:
                {
                alt13=1;
                }
                break;
            case 255:
                {
                alt13=2;
                }
                break;
            case 256:
                {
                alt13=3;
                }
                break;
            case 257:
                {
                alt13=4;
                }
                break;
            case 258:
                {
                alt13=5;
                }
                break;
            case 259:
                {
                alt13=6;
                }
                break;
            case 260:
                {
                alt13=7;
                }
                break;
            case 261:
                {
                alt13=8;
                }
                break;
            case 262:
                {
                alt13=9;
                }
                break;
            case 263:
                {
                alt13=10;
                }
                break;
            case 264:
                {
                alt13=11;
                }
                break;
            case 29:
                {
                alt13=12;
                }
                break;
            case 265:
                {
                alt13=13;
                }
                break;
            case 266:
                {
                alt13=14;
                }
                break;
            case 267:
                {
                alt13=15;
                }
                break;
            case 268:
                {
                alt13=16;
                }
                break;
            case 269:
                {
                alt13=17;
                }
                break;
            case 270:
                {
                alt13=18;
                }
                break;
            case 271:
                {
                alt13=19;
                }
                break;
            case 272:
                {
                alt13=20;
                }
                break;
            case 273:
                {
                alt13=21;
                }
                break;
            case 274:
                {
                alt13=22;
                }
                break;
            case 275:
                {
                alt13=23;
                }
                break;
            case 346:
                {
                alt13=24;
                }
                break;
            case 276:
                {
                alt13=25;
                }
                break;
            case 277:
                {
                alt13=26;
                }
                break;
            case 278:
                {
                alt13=27;
                }
                break;
            case 31:
                {
                alt13=28;
                }
                break;
            case 279:
                {
                alt13=29;
                }
                break;
            case 280:
                {
                alt13=30;
                }
                break;
            case 281:
                {
                alt13=31;
                }
                break;
            case 282:
                {
                alt13=32;
                }
                break;
            case 283:
                {
                alt13=33;
                }
                break;
            case 284:
                {
                alt13=34;
                }
                break;
            case 285:
                {
                alt13=35;
                }
                break;
            case 286:
                {
                alt13=36;
                }
                break;
            case 287:
                {
                alt13=37;
                }
                break;
            case 288:
                {
                alt13=38;
                }
                break;
            case 289:
                {
                alt13=39;
                }
                break;
            case 290:
                {
                alt13=40;
                }
                break;
            case 291:
                {
                alt13=41;
                }
                break;
            case 292:
                {
                alt13=42;
                }
                break;
            case 293:
                {
                alt13=43;
                }
                break;
            case 294:
                {
                alt13=44;
                }
                break;
            case 295:
                {
                alt13=45;
                }
                break;
            case 296:
                {
                alt13=46;
                }
                break;
            case 297:
                {
                alt13=47;
                }
                break;
            case 298:
                {
                alt13=48;
                }
                break;
            case 299:
                {
                alt13=49;
                }
                break;
            case 300:
                {
                alt13=50;
                }
                break;
            case 301:
                {
                alt13=51;
                }
                break;
            case 302:
                {
                alt13=52;
                }
                break;
            case 303:
                {
                alt13=53;
                }
                break;
            case 304:
                {
                alt13=54;
                }
                break;
            case 305:
                {
                alt13=55;
                }
                break;
            case 306:
                {
                alt13=56;
                }
                break;
            case 307:
                {
                alt13=57;
                }
                break;
            case 308:
                {
                alt13=58;
                }
                break;
            case 309:
                {
                alt13=59;
                }
                break;
            case 310:
                {
                alt13=60;
                }
                break;
            case 311:
                {
                alt13=61;
                }
                break;
            case 312:
                {
                alt13=62;
                }
                break;
            case 313:
                {
                alt13=63;
                }
                break;
            case 314:
                {
                alt13=64;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalPerl.g:2219:2: ( '++' )
                    {
                    // InternalPerl.g:2219:2: ( '++' )
                    // InternalPerl.g:2220:3: '++'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 
                    match(input,254,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2225:2: ( '--' )
                    {
                    // InternalPerl.g:2225:2: ( '--' )
                    // InternalPerl.g:2226:3: '--'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    match(input,255,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2231:2: ( '**' )
                    {
                    // InternalPerl.g:2231:2: ( '**' )
                    // InternalPerl.g:2232:3: '**'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 
                    match(input,256,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2237:2: ( '!' )
                    {
                    // InternalPerl.g:2237:2: ( '!' )
                    // InternalPerl.g:2238:3: '!'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 
                    match(input,257,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2243:2: ( '~' )
                    {
                    // InternalPerl.g:2243:2: ( '~' )
                    // InternalPerl.g:2244:3: '~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 
                    match(input,258,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2249:2: ( '+' )
                    {
                    // InternalPerl.g:2249:2: ( '+' )
                    // InternalPerl.g:2250:3: '+'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 
                    match(input,259,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2255:2: ( '-' )
                    {
                    // InternalPerl.g:2255:2: ( '-' )
                    // InternalPerl.g:2256:3: '-'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 
                    match(input,260,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2261:2: ( '=~' )
                    {
                    // InternalPerl.g:2261:2: ( '=~' )
                    // InternalPerl.g:2262:3: '=~'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 
                    match(input,261,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2267:2: ( '!~' )
                    {
                    // InternalPerl.g:2267:2: ( '!~' )
                    // InternalPerl.g:2268:3: '!~'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 
                    match(input,262,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2273:2: ( '*' )
                    {
                    // InternalPerl.g:2273:2: ( '*' )
                    // InternalPerl.g:2274:3: '*'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 
                    match(input,263,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2279:2: ( '/' )
                    {
                    // InternalPerl.g:2279:2: ( '/' )
                    // InternalPerl.g:2280:3: '/'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 
                    match(input,264,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2285:2: ( '%' )
                    {
                    // InternalPerl.g:2285:2: ( '%' )
                    // InternalPerl.g:2286:3: '%'
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2291:2: ( 'x' )
                    {
                    // InternalPerl.g:2291:2: ( 'x' )
                    // InternalPerl.g:2292:3: 'x'
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_12()); 
                    match(input,265,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2297:2: ( '<<' )
                    {
                    // InternalPerl.g:2297:2: ( '<<' )
                    // InternalPerl.g:2298:3: '<<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 
                    match(input,266,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2303:2: ( '>>' )
                    {
                    // InternalPerl.g:2303:2: ( '>>' )
                    // InternalPerl.g:2304:3: '>>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 
                    match(input,267,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2309:2: ( 'lt' )
                    {
                    // InternalPerl.g:2309:2: ( 'lt' )
                    // InternalPerl.g:2310:3: 'lt'
                    {
                     before(grammarAccess.getOperatorAccess().getLtKeyword_15()); 
                    match(input,268,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLtKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2315:2: ( 'gt' )
                    {
                    // InternalPerl.g:2315:2: ( 'gt' )
                    // InternalPerl.g:2316:3: 'gt'
                    {
                     before(grammarAccess.getOperatorAccess().getGtKeyword_16()); 
                    match(input,269,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGtKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2321:2: ( 'le' )
                    {
                    // InternalPerl.g:2321:2: ( 'le' )
                    // InternalPerl.g:2322:3: 'le'
                    {
                     before(grammarAccess.getOperatorAccess().getLeKeyword_17()); 
                    match(input,270,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLeKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2327:2: ( 'ge' )
                    {
                    // InternalPerl.g:2327:2: ( 'ge' )
                    // InternalPerl.g:2328:3: 'ge'
                    {
                     before(grammarAccess.getOperatorAccess().getGeKeyword_18()); 
                    match(input,271,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGeKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2333:2: ( 'cmp' )
                    {
                    // InternalPerl.g:2333:2: ( 'cmp' )
                    // InternalPerl.g:2334:3: 'cmp'
                    {
                     before(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 
                    match(input,272,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2339:2: ( '~~' )
                    {
                    // InternalPerl.g:2339:2: ( '~~' )
                    // InternalPerl.g:2340:3: '~~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 
                    match(input,273,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2345:2: ( '==' )
                    {
                    // InternalPerl.g:2345:2: ( '==' )
                    // InternalPerl.g:2346:3: '=='
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 
                    match(input,274,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2351:2: ( '!=' )
                    {
                    // InternalPerl.g:2351:2: ( '!=' )
                    // InternalPerl.g:2352:3: '!='
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 
                    match(input,275,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2357:2: ( ( rule__Operator__Group_23__0 ) )
                    {
                    // InternalPerl.g:2357:2: ( ( rule__Operator__Group_23__0 ) )
                    // InternalPerl.g:2358:3: ( rule__Operator__Group_23__0 )
                    {
                     before(grammarAccess.getOperatorAccess().getGroup_23()); 
                    // InternalPerl.g:2359:3: ( rule__Operator__Group_23__0 )
                    // InternalPerl.g:2359:4: rule__Operator__Group_23__0
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
                    // InternalPerl.g:2363:2: ( '..' )
                    {
                    // InternalPerl.g:2363:2: ( '..' )
                    // InternalPerl.g:2364:3: '..'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 
                    match(input,276,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2369:2: ( '...' )
                    {
                    // InternalPerl.g:2369:2: ( '...' )
                    // InternalPerl.g:2370:3: '...'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 
                    match(input,277,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2375:2: ( ',' )
                    {
                    // InternalPerl.g:2375:2: ( ',' )
                    // InternalPerl.g:2376:3: ','
                    {
                     before(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 
                    match(input,278,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:2381:2: ( '&' )
                    {
                    // InternalPerl.g:2381:2: ( '&' )
                    // InternalPerl.g:2382:3: '&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:2387:2: ( '|' )
                    {
                    // InternalPerl.g:2387:2: ( '|' )
                    // InternalPerl.g:2388:3: '|'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 
                    match(input,279,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:2393:2: ( '^' )
                    {
                    // InternalPerl.g:2393:2: ( '^' )
                    // InternalPerl.g:2394:3: '^'
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 
                    match(input,280,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:2399:2: ( '&&' )
                    {
                    // InternalPerl.g:2399:2: ( '&&' )
                    // InternalPerl.g:2400:3: '&&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 
                    match(input,281,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:2405:2: ( '||' )
                    {
                    // InternalPerl.g:2405:2: ( '||' )
                    // InternalPerl.g:2406:3: '||'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 
                    match(input,282,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:2411:2: ( '//' )
                    {
                    // InternalPerl.g:2411:2: ( '//' )
                    // InternalPerl.g:2412:3: '//'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 
                    match(input,283,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:2417:2: ( '?' )
                    {
                    // InternalPerl.g:2417:2: ( '?' )
                    // InternalPerl.g:2418:3: '?'
                    {
                     before(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 
                    match(input,284,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:2423:2: ( ':' )
                    {
                    // InternalPerl.g:2423:2: ( ':' )
                    // InternalPerl.g:2424:3: ':'
                    {
                     before(grammarAccess.getOperatorAccess().getColonKeyword_34()); 
                    match(input,285,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getColonKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:2429:2: ( '**=' )
                    {
                    // InternalPerl.g:2429:2: ( '**=' )
                    // InternalPerl.g:2430:3: '**='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 
                    match(input,286,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:2435:2: ( '+=' )
                    {
                    // InternalPerl.g:2435:2: ( '+=' )
                    // InternalPerl.g:2436:3: '+='
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 
                    match(input,287,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:2441:2: ( '-=' )
                    {
                    // InternalPerl.g:2441:2: ( '-=' )
                    // InternalPerl.g:2442:3: '-='
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 
                    match(input,288,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:2447:2: ( '.=' )
                    {
                    // InternalPerl.g:2447:2: ( '.=' )
                    // InternalPerl.g:2448:3: '.='
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 
                    match(input,289,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:2453:2: ( '*=' )
                    {
                    // InternalPerl.g:2453:2: ( '*=' )
                    // InternalPerl.g:2454:3: '*='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 
                    match(input,290,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:2459:2: ( '/=' )
                    {
                    // InternalPerl.g:2459:2: ( '/=' )
                    // InternalPerl.g:2460:3: '/='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 
                    match(input,291,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:2465:2: ( '%=' )
                    {
                    // InternalPerl.g:2465:2: ( '%=' )
                    // InternalPerl.g:2466:3: '%='
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 
                    match(input,292,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:2471:2: ( 'x=' )
                    {
                    // InternalPerl.g:2471:2: ( 'x=' )
                    // InternalPerl.g:2472:3: 'x='
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_42()); 
                    match(input,293,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:2477:2: ( '&=' )
                    {
                    // InternalPerl.g:2477:2: ( '&=' )
                    // InternalPerl.g:2478:3: '&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 
                    match(input,294,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:2483:2: ( '|=' )
                    {
                    // InternalPerl.g:2483:2: ( '|=' )
                    // InternalPerl.g:2484:3: '|='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 
                    match(input,295,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:2489:2: ( '^=' )
                    {
                    // InternalPerl.g:2489:2: ( '^=' )
                    // InternalPerl.g:2490:3: '^='
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 
                    match(input,296,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:2495:2: ( '<<=' )
                    {
                    // InternalPerl.g:2495:2: ( '<<=' )
                    // InternalPerl.g:2496:3: '<<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 
                    match(input,297,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:2501:2: ( '>>=' )
                    {
                    // InternalPerl.g:2501:2: ( '>>=' )
                    // InternalPerl.g:2502:3: '>>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 
                    match(input,298,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:2507:2: ( '&&=' )
                    {
                    // InternalPerl.g:2507:2: ( '&&=' )
                    // InternalPerl.g:2508:3: '&&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 
                    match(input,299,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:2513:2: ( '||=' )
                    {
                    // InternalPerl.g:2513:2: ( '||=' )
                    // InternalPerl.g:2514:3: '||='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 
                    match(input,300,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:2519:2: ( '//=' )
                    {
                    // InternalPerl.g:2519:2: ( '//=' )
                    // InternalPerl.g:2520:3: '//='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 
                    match(input,301,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:2525:2: ( '<' )
                    {
                    // InternalPerl.g:2525:2: ( '<' )
                    // InternalPerl.g:2526:3: '<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 
                    match(input,302,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:2531:2: ( '>' )
                    {
                    // InternalPerl.g:2531:2: ( '>' )
                    // InternalPerl.g:2532:3: '>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 
                    match(input,303,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:2537:2: ( '<=' )
                    {
                    // InternalPerl.g:2537:2: ( '<=' )
                    // InternalPerl.g:2538:3: '<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 
                    match(input,304,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:2543:2: ( '>=' )
                    {
                    // InternalPerl.g:2543:2: ( '>=' )
                    // InternalPerl.g:2544:3: '>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 
                    match(input,305,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:2549:2: ( '<>' )
                    {
                    // InternalPerl.g:2549:2: ( '<>' )
                    // InternalPerl.g:2550:3: '<>'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 
                    match(input,306,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:2555:2: ( '=>' )
                    {
                    // InternalPerl.g:2555:2: ( '=>' )
                    // InternalPerl.g:2556:3: '=>'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 
                    match(input,307,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:2561:2: ( '->' )
                    {
                    // InternalPerl.g:2561:2: ( '->' )
                    // InternalPerl.g:2562:3: '->'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 
                    match(input,308,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:2567:2: ( 'and' )
                    {
                    // InternalPerl.g:2567:2: ( 'and' )
                    // InternalPerl.g:2568:3: 'and'
                    {
                     before(grammarAccess.getOperatorAccess().getAndKeyword_58()); 
                    match(input,309,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAndKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:2573:2: ( 'or' )
                    {
                    // InternalPerl.g:2573:2: ( 'or' )
                    // InternalPerl.g:2574:3: 'or'
                    {
                     before(grammarAccess.getOperatorAccess().getOrKeyword_59()); 
                    match(input,310,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getOrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:2579:2: ( 'xor' )
                    {
                    // InternalPerl.g:2579:2: ( 'xor' )
                    // InternalPerl.g:2580:3: 'xor'
                    {
                     before(grammarAccess.getOperatorAccess().getXorKeyword_60()); 
                    match(input,311,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXorKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:2585:2: ( 'not' )
                    {
                    // InternalPerl.g:2585:2: ( 'not' )
                    // InternalPerl.g:2586:3: 'not'
                    {
                     before(grammarAccess.getOperatorAccess().getNotKeyword_61()); 
                    match(input,312,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getNotKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:2591:2: ( 'eq' )
                    {
                    // InternalPerl.g:2591:2: ( 'eq' )
                    // InternalPerl.g:2592:3: 'eq'
                    {
                     before(grammarAccess.getOperatorAccess().getEqKeyword_62()); 
                    match(input,313,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:2597:2: ( 'ne' )
                    {
                    // InternalPerl.g:2597:2: ( 'ne' )
                    // InternalPerl.g:2598:3: 'ne'
                    {
                     before(grammarAccess.getOperatorAccess().getNeKeyword_63()); 
                    match(input,314,FOLLOW_2); 
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
    // InternalPerl.g:2607:1: rule__FileTestOperator__Alternatives : ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) );
    public final void rule__FileTestOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2611:1: ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) )
            int alt14=27;
            switch ( input.LA(1) ) {
            case 315:
                {
                alt14=1;
                }
                break;
            case 316:
                {
                alt14=2;
                }
                break;
            case 317:
                {
                alt14=3;
                }
                break;
            case 318:
                {
                alt14=4;
                }
                break;
            case 319:
                {
                alt14=5;
                }
                break;
            case 320:
                {
                alt14=6;
                }
                break;
            case 321:
                {
                alt14=7;
                }
                break;
            case 322:
                {
                alt14=8;
                }
                break;
            case 323:
                {
                alt14=9;
                }
                break;
            case 324:
                {
                alt14=10;
                }
                break;
            case 325:
                {
                alt14=11;
                }
                break;
            case 326:
                {
                alt14=12;
                }
                break;
            case 327:
                {
                alt14=13;
                }
                break;
            case 328:
                {
                alt14=14;
                }
                break;
            case 329:
                {
                alt14=15;
                }
                break;
            case 330:
                {
                alt14=16;
                }
                break;
            case 331:
                {
                alt14=17;
                }
                break;
            case 332:
                {
                alt14=18;
                }
                break;
            case 333:
                {
                alt14=19;
                }
                break;
            case 334:
                {
                alt14=20;
                }
                break;
            case 335:
                {
                alt14=21;
                }
                break;
            case 336:
                {
                alt14=22;
                }
                break;
            case 337:
                {
                alt14=23;
                }
                break;
            case 338:
                {
                alt14=24;
                }
                break;
            case 339:
                {
                alt14=25;
                }
                break;
            case 340:
                {
                alt14=26;
                }
                break;
            case 341:
                {
                alt14=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalPerl.g:2612:2: ( '-r' )
                    {
                    // InternalPerl.g:2612:2: ( '-r' )
                    // InternalPerl.g:2613:3: '-r'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 
                    match(input,315,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2618:2: ( '-w' )
                    {
                    // InternalPerl.g:2618:2: ( '-w' )
                    // InternalPerl.g:2619:3: '-w'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 
                    match(input,316,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2624:2: ( '-x' )
                    {
                    // InternalPerl.g:2624:2: ( '-x' )
                    // InternalPerl.g:2625:3: '-x'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 
                    match(input,317,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2630:2: ( '-o' )
                    {
                    // InternalPerl.g:2630:2: ( '-o' )
                    // InternalPerl.g:2631:3: '-o'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 
                    match(input,318,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2636:2: ( '-R' )
                    {
                    // InternalPerl.g:2636:2: ( '-R' )
                    // InternalPerl.g:2637:3: '-R'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 
                    match(input,319,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2642:2: ( '-W' )
                    {
                    // InternalPerl.g:2642:2: ( '-W' )
                    // InternalPerl.g:2643:3: '-W'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 
                    match(input,320,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2648:2: ( '-X' )
                    {
                    // InternalPerl.g:2648:2: ( '-X' )
                    // InternalPerl.g:2649:3: '-X'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 
                    match(input,321,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2654:2: ( '-O' )
                    {
                    // InternalPerl.g:2654:2: ( '-O' )
                    // InternalPerl.g:2655:3: '-O'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 
                    match(input,322,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2660:2: ( '-e' )
                    {
                    // InternalPerl.g:2660:2: ( '-e' )
                    // InternalPerl.g:2661:3: '-e'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 
                    match(input,323,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2666:2: ( '-z' )
                    {
                    // InternalPerl.g:2666:2: ( '-z' )
                    // InternalPerl.g:2667:3: '-z'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 
                    match(input,324,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2672:2: ( '-s' )
                    {
                    // InternalPerl.g:2672:2: ( '-s' )
                    // InternalPerl.g:2673:3: '-s'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 
                    match(input,325,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2678:2: ( '-f' )
                    {
                    // InternalPerl.g:2678:2: ( '-f' )
                    // InternalPerl.g:2679:3: '-f'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 
                    match(input,326,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2684:2: ( '-d' )
                    {
                    // InternalPerl.g:2684:2: ( '-d' )
                    // InternalPerl.g:2685:3: '-d'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 
                    match(input,327,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2690:2: ( '-l' )
                    {
                    // InternalPerl.g:2690:2: ( '-l' )
                    // InternalPerl.g:2691:3: '-l'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 
                    match(input,328,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2696:2: ( '-p' )
                    {
                    // InternalPerl.g:2696:2: ( '-p' )
                    // InternalPerl.g:2697:3: '-p'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 
                    match(input,329,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2702:2: ( '-S' )
                    {
                    // InternalPerl.g:2702:2: ( '-S' )
                    // InternalPerl.g:2703:3: '-S'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 
                    match(input,330,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2708:2: ( '-b' )
                    {
                    // InternalPerl.g:2708:2: ( '-b' )
                    // InternalPerl.g:2709:3: '-b'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 
                    match(input,331,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2714:2: ( '-c' )
                    {
                    // InternalPerl.g:2714:2: ( '-c' )
                    // InternalPerl.g:2715:3: '-c'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 
                    match(input,332,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2720:2: ( '-t' )
                    {
                    // InternalPerl.g:2720:2: ( '-t' )
                    // InternalPerl.g:2721:3: '-t'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 
                    match(input,333,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2726:2: ( '-u' )
                    {
                    // InternalPerl.g:2726:2: ( '-u' )
                    // InternalPerl.g:2727:3: '-u'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 
                    match(input,334,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2732:2: ( '-g' )
                    {
                    // InternalPerl.g:2732:2: ( '-g' )
                    // InternalPerl.g:2733:3: '-g'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 
                    match(input,335,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2738:2: ( '-k' )
                    {
                    // InternalPerl.g:2738:2: ( '-k' )
                    // InternalPerl.g:2739:3: '-k'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 
                    match(input,336,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2744:2: ( '-T' )
                    {
                    // InternalPerl.g:2744:2: ( '-T' )
                    // InternalPerl.g:2745:3: '-T'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 
                    match(input,337,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2750:2: ( '-B' )
                    {
                    // InternalPerl.g:2750:2: ( '-B' )
                    // InternalPerl.g:2751:3: '-B'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 
                    match(input,338,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:2756:2: ( '-M' )
                    {
                    // InternalPerl.g:2756:2: ( '-M' )
                    // InternalPerl.g:2757:3: '-M'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 
                    match(input,339,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2762:2: ( '-A' )
                    {
                    // InternalPerl.g:2762:2: ( '-A' )
                    // InternalPerl.g:2763:3: '-A'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 
                    match(input,340,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2768:2: ( '-C' )
                    {
                    // InternalPerl.g:2768:2: ( '-C' )
                    // InternalPerl.g:2769:3: '-C'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_26()); 
                    match(input,341,FOLLOW_2); 
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
    // InternalPerl.g:2778:1: rule__PerlDocument__Group__0 : rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 ;
    public final void rule__PerlDocument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2782:1: ( rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 )
            // InternalPerl.g:2783:2: rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1
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
    // InternalPerl.g:2790:1: rule__PerlDocument__Group__0__Impl : ( () ) ;
    public final void rule__PerlDocument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2794:1: ( ( () ) )
            // InternalPerl.g:2795:1: ( () )
            {
            // InternalPerl.g:2795:1: ( () )
            // InternalPerl.g:2796:2: ()
            {
             before(grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0()); 
            // InternalPerl.g:2797:2: ()
            // InternalPerl.g:2797:3: 
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
    // InternalPerl.g:2805:1: rule__PerlDocument__Group__1 : rule__PerlDocument__Group__1__Impl ;
    public final void rule__PerlDocument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2809:1: ( rule__PerlDocument__Group__1__Impl )
            // InternalPerl.g:2810:2: rule__PerlDocument__Group__1__Impl
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
    // InternalPerl.g:2816:1: rule__PerlDocument__Group__1__Impl : ( ( rule__PerlDocument__ElementsAssignment_1 )* ) ;
    public final void rule__PerlDocument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2820:1: ( ( ( rule__PerlDocument__ElementsAssignment_1 )* ) )
            // InternalPerl.g:2821:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            {
            // InternalPerl.g:2821:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            // InternalPerl.g:2822:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            {
             before(grammarAccess.getPerlDocumentAccess().getElementsAssignment_1()); 
            // InternalPerl.g:2823:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_LITERAL)||(LA15_0>=RULE_WORDS_QUOTE_LIKE && LA15_0<=RULE_READLINE_QUOTE)||LA15_0==29||(LA15_0>=31 && LA15_0<=341)||LA15_0==346) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPerl.g:2823:3: rule__PerlDocument__ElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__PerlDocument__ElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalPerl.g:2832:1: rule__ExpressionStatement__Group__0 : rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1 ;
    public final void rule__ExpressionStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2836:1: ( rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1 )
            // InternalPerl.g:2837:2: rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1
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
    // InternalPerl.g:2844:1: rule__ExpressionStatement__Group__0__Impl : ( ( rule__ExpressionStatement__Alternatives_0 ) ) ;
    public final void rule__ExpressionStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2848:1: ( ( ( rule__ExpressionStatement__Alternatives_0 ) ) )
            // InternalPerl.g:2849:1: ( ( rule__ExpressionStatement__Alternatives_0 ) )
            {
            // InternalPerl.g:2849:1: ( ( rule__ExpressionStatement__Alternatives_0 ) )
            // InternalPerl.g:2850:2: ( rule__ExpressionStatement__Alternatives_0 )
            {
             before(grammarAccess.getExpressionStatementAccess().getAlternatives_0()); 
            // InternalPerl.g:2851:2: ( rule__ExpressionStatement__Alternatives_0 )
            // InternalPerl.g:2851:3: rule__ExpressionStatement__Alternatives_0
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
    // InternalPerl.g:2859:1: rule__ExpressionStatement__Group__1 : rule__ExpressionStatement__Group__1__Impl ;
    public final void rule__ExpressionStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2863:1: ( rule__ExpressionStatement__Group__1__Impl )
            // InternalPerl.g:2864:2: rule__ExpressionStatement__Group__1__Impl
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
    // InternalPerl.g:2870:1: rule__ExpressionStatement__Group__1__Impl : ( ';' ) ;
    public final void rule__ExpressionStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2874:1: ( ( ';' ) )
            // InternalPerl.g:2875:1: ( ';' )
            {
            // InternalPerl.g:2875:1: ( ';' )
            // InternalPerl.g:2876:2: ';'
            {
             before(grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1()); 
            match(input,27,FOLLOW_2); 
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
    // InternalPerl.g:2886:1: rule__PackageStatement__Group__0 : rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 ;
    public final void rule__PackageStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2890:1: ( rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 )
            // InternalPerl.g:2891:2: rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1
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
    // InternalPerl.g:2898:1: rule__PackageStatement__Group__0__Impl : ( () ) ;
    public final void rule__PackageStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2902:1: ( ( () ) )
            // InternalPerl.g:2903:1: ( () )
            {
            // InternalPerl.g:2903:1: ( () )
            // InternalPerl.g:2904:2: ()
            {
             before(grammarAccess.getPackageStatementAccess().getPackageStatementAction_0()); 
            // InternalPerl.g:2905:2: ()
            // InternalPerl.g:2905:3: 
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
    // InternalPerl.g:2913:1: rule__PackageStatement__Group__1 : rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 ;
    public final void rule__PackageStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2917:1: ( rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 )
            // InternalPerl.g:2918:2: rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2
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
    // InternalPerl.g:2925:1: rule__PackageStatement__Group__1__Impl : ( 'package' ) ;
    public final void rule__PackageStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2929:1: ( ( 'package' ) )
            // InternalPerl.g:2930:1: ( 'package' )
            {
            // InternalPerl.g:2930:1: ( 'package' )
            // InternalPerl.g:2931:2: 'package'
            {
             before(grammarAccess.getPackageStatementAccess().getPackageKeyword_1()); 
            match(input,152,FOLLOW_2); 
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
    // InternalPerl.g:2940:1: rule__PackageStatement__Group__2 : rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3 ;
    public final void rule__PackageStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2944:1: ( rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3 )
            // InternalPerl.g:2945:2: rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3
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
    // InternalPerl.g:2952:1: rule__PackageStatement__Group__2__Impl : ( ( rule__PackageStatement__NameAssignment_2 ) ) ;
    public final void rule__PackageStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2956:1: ( ( ( rule__PackageStatement__NameAssignment_2 ) ) )
            // InternalPerl.g:2957:1: ( ( rule__PackageStatement__NameAssignment_2 ) )
            {
            // InternalPerl.g:2957:1: ( ( rule__PackageStatement__NameAssignment_2 ) )
            // InternalPerl.g:2958:2: ( rule__PackageStatement__NameAssignment_2 )
            {
             before(grammarAccess.getPackageStatementAccess().getNameAssignment_2()); 
            // InternalPerl.g:2959:2: ( rule__PackageStatement__NameAssignment_2 )
            // InternalPerl.g:2959:3: rule__PackageStatement__NameAssignment_2
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
    // InternalPerl.g:2967:1: rule__PackageStatement__Group__3 : rule__PackageStatement__Group__3__Impl ;
    public final void rule__PackageStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2971:1: ( rule__PackageStatement__Group__3__Impl )
            // InternalPerl.g:2972:2: rule__PackageStatement__Group__3__Impl
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
    // InternalPerl.g:2978:1: rule__PackageStatement__Group__3__Impl : ( ( rule__PackageStatement__VersionAssignment_3 )? ) ;
    public final void rule__PackageStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2982:1: ( ( ( rule__PackageStatement__VersionAssignment_3 )? ) )
            // InternalPerl.g:2983:1: ( ( rule__PackageStatement__VersionAssignment_3 )? )
            {
            // InternalPerl.g:2983:1: ( ( rule__PackageStatement__VersionAssignment_3 )? )
            // InternalPerl.g:2984:2: ( rule__PackageStatement__VersionAssignment_3 )?
            {
             before(grammarAccess.getPackageStatementAccess().getVersionAssignment_3()); 
            // InternalPerl.g:2985:2: ( rule__PackageStatement__VersionAssignment_3 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_VERSION) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalPerl.g:2985:3: rule__PackageStatement__VersionAssignment_3
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
    // InternalPerl.g:2994:1: rule__RequireInclude__Group__0 : rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1 ;
    public final void rule__RequireInclude__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2998:1: ( rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1 )
            // InternalPerl.g:2999:2: rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1
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
    // InternalPerl.g:3006:1: rule__RequireInclude__Group__0__Impl : ( 'require' ) ;
    public final void rule__RequireInclude__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3010:1: ( ( 'require' ) )
            // InternalPerl.g:3011:1: ( 'require' )
            {
            // InternalPerl.g:3011:1: ( 'require' )
            // InternalPerl.g:3012:2: 'require'
            {
             before(grammarAccess.getRequireIncludeAccess().getRequireKeyword_0()); 
            match(input,171,FOLLOW_2); 
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
    // InternalPerl.g:3021:1: rule__RequireInclude__Group__1 : rule__RequireInclude__Group__1__Impl ;
    public final void rule__RequireInclude__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3025:1: ( rule__RequireInclude__Group__1__Impl )
            // InternalPerl.g:3026:2: rule__RequireInclude__Group__1__Impl
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
    // InternalPerl.g:3032:1: rule__RequireInclude__Group__1__Impl : ( ( rule__RequireInclude__VersionAssignment_1 ) ) ;
    public final void rule__RequireInclude__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3036:1: ( ( ( rule__RequireInclude__VersionAssignment_1 ) ) )
            // InternalPerl.g:3037:1: ( ( rule__RequireInclude__VersionAssignment_1 ) )
            {
            // InternalPerl.g:3037:1: ( ( rule__RequireInclude__VersionAssignment_1 ) )
            // InternalPerl.g:3038:2: ( rule__RequireInclude__VersionAssignment_1 )
            {
             before(grammarAccess.getRequireIncludeAccess().getVersionAssignment_1()); 
            // InternalPerl.g:3039:2: ( rule__RequireInclude__VersionAssignment_1 )
            // InternalPerl.g:3039:3: rule__RequireInclude__VersionAssignment_1
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
    // InternalPerl.g:3048:1: rule__UseInclude__Group__0 : rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1 ;
    public final void rule__UseInclude__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3052:1: ( rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1 )
            // InternalPerl.g:3053:2: rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1
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
    // InternalPerl.g:3060:1: rule__UseInclude__Group__0__Impl : ( () ) ;
    public final void rule__UseInclude__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3064:1: ( ( () ) )
            // InternalPerl.g:3065:1: ( () )
            {
            // InternalPerl.g:3065:1: ( () )
            // InternalPerl.g:3066:2: ()
            {
             before(grammarAccess.getUseIncludeAccess().getUseIncludeAction_0()); 
            // InternalPerl.g:3067:2: ()
            // InternalPerl.g:3067:3: 
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
    // InternalPerl.g:3075:1: rule__UseInclude__Group__1 : rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2 ;
    public final void rule__UseInclude__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3079:1: ( rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2 )
            // InternalPerl.g:3080:2: rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2
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
    // InternalPerl.g:3087:1: rule__UseInclude__Group__1__Impl : ( 'use' ) ;
    public final void rule__UseInclude__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3091:1: ( ( 'use' ) )
            // InternalPerl.g:3092:1: ( 'use' )
            {
            // InternalPerl.g:3092:1: ( 'use' )
            // InternalPerl.g:3093:2: 'use'
            {
             before(grammarAccess.getUseIncludeAccess().getUseKeyword_1()); 
            match(input,242,FOLLOW_2); 
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
    // InternalPerl.g:3102:1: rule__UseInclude__Group__2 : rule__UseInclude__Group__2__Impl ;
    public final void rule__UseInclude__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3106:1: ( rule__UseInclude__Group__2__Impl )
            // InternalPerl.g:3107:2: rule__UseInclude__Group__2__Impl
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
    // InternalPerl.g:3113:1: rule__UseInclude__Group__2__Impl : ( ( rule__UseInclude__Alternatives_2 ) ) ;
    public final void rule__UseInclude__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3117:1: ( ( ( rule__UseInclude__Alternatives_2 ) ) )
            // InternalPerl.g:3118:1: ( ( rule__UseInclude__Alternatives_2 ) )
            {
            // InternalPerl.g:3118:1: ( ( rule__UseInclude__Alternatives_2 ) )
            // InternalPerl.g:3119:2: ( rule__UseInclude__Alternatives_2 )
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2()); 
            // InternalPerl.g:3120:2: ( rule__UseInclude__Alternatives_2 )
            // InternalPerl.g:3120:3: rule__UseInclude__Alternatives_2
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
    // InternalPerl.g:3129:1: rule__UseInclude__Group_2_1__0 : rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1 ;
    public final void rule__UseInclude__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3133:1: ( rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1 )
            // InternalPerl.g:3134:2: rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1
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
    // InternalPerl.g:3141:1: rule__UseInclude__Group_2_1__0__Impl : ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) ) ;
    public final void rule__UseInclude__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3145:1: ( ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) ) )
            // InternalPerl.g:3146:1: ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) )
            {
            // InternalPerl.g:3146:1: ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) )
            // InternalPerl.g:3147:2: ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 )
            {
             before(grammarAccess.getUseIncludeAccess().getPragmaOrPackageAssignment_2_1_0()); 
            // InternalPerl.g:3148:2: ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 )
            // InternalPerl.g:3148:3: rule__UseInclude__PragmaOrPackageAssignment_2_1_0
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
    // InternalPerl.g:3156:1: rule__UseInclude__Group_2_1__1 : rule__UseInclude__Group_2_1__1__Impl ;
    public final void rule__UseInclude__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3160:1: ( rule__UseInclude__Group_2_1__1__Impl )
            // InternalPerl.g:3161:2: rule__UseInclude__Group_2_1__1__Impl
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
    // InternalPerl.g:3167:1: rule__UseInclude__Group_2_1__1__Impl : ( ( rule__UseInclude__Alternatives_2_1_1 )? ) ;
    public final void rule__UseInclude__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3171:1: ( ( ( rule__UseInclude__Alternatives_2_1_1 )? ) )
            // InternalPerl.g:3172:1: ( ( rule__UseInclude__Alternatives_2_1_1 )? )
            {
            // InternalPerl.g:3172:1: ( ( rule__UseInclude__Alternatives_2_1_1 )? )
            // InternalPerl.g:3173:2: ( rule__UseInclude__Alternatives_2_1_1 )?
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2_1_1()); 
            // InternalPerl.g:3174:2: ( rule__UseInclude__Alternatives_2_1_1 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_STRING && LA17_0<=RULE_LITERAL)||LA17_0==RULE_WORDS_QUOTE_LIKE) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalPerl.g:3174:3: rule__UseInclude__Alternatives_2_1_1
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
    // InternalPerl.g:3183:1: rule__SubStatement__Group__0 : rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1 ;
    public final void rule__SubStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3187:1: ( rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1 )
            // InternalPerl.g:3188:2: rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1
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
    // InternalPerl.g:3195:1: rule__SubStatement__Group__0__Impl : ( () ) ;
    public final void rule__SubStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3199:1: ( ( () ) )
            // InternalPerl.g:3200:1: ( () )
            {
            // InternalPerl.g:3200:1: ( () )
            // InternalPerl.g:3201:2: ()
            {
             before(grammarAccess.getSubStatementAccess().getSubStatementAction_0()); 
            // InternalPerl.g:3202:2: ()
            // InternalPerl.g:3202:3: 
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
    // InternalPerl.g:3210:1: rule__SubStatement__Group__1 : rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2 ;
    public final void rule__SubStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3214:1: ( rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2 )
            // InternalPerl.g:3215:2: rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2
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
    // InternalPerl.g:3222:1: rule__SubStatement__Group__1__Impl : ( 'sub' ) ;
    public final void rule__SubStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3226:1: ( ( 'sub' ) )
            // InternalPerl.g:3227:1: ( 'sub' )
            {
            // InternalPerl.g:3227:1: ( 'sub' )
            // InternalPerl.g:3228:2: 'sub'
            {
             before(grammarAccess.getSubStatementAccess().getSubKeyword_1()); 
            match(input,215,FOLLOW_2); 
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
    // InternalPerl.g:3237:1: rule__SubStatement__Group__2 : rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3 ;
    public final void rule__SubStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3241:1: ( rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3 )
            // InternalPerl.g:3242:2: rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3
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
    // InternalPerl.g:3249:1: rule__SubStatement__Group__2__Impl : ( ( rule__SubStatement__NameAssignment_2 ) ) ;
    public final void rule__SubStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3253:1: ( ( ( rule__SubStatement__NameAssignment_2 ) ) )
            // InternalPerl.g:3254:1: ( ( rule__SubStatement__NameAssignment_2 ) )
            {
            // InternalPerl.g:3254:1: ( ( rule__SubStatement__NameAssignment_2 ) )
            // InternalPerl.g:3255:2: ( rule__SubStatement__NameAssignment_2 )
            {
             before(grammarAccess.getSubStatementAccess().getNameAssignment_2()); 
            // InternalPerl.g:3256:2: ( rule__SubStatement__NameAssignment_2 )
            // InternalPerl.g:3256:3: rule__SubStatement__NameAssignment_2
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
    // InternalPerl.g:3264:1: rule__SubStatement__Group__3 : rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4 ;
    public final void rule__SubStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3268:1: ( rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4 )
            // InternalPerl.g:3269:2: rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4
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
    // InternalPerl.g:3276:1: rule__SubStatement__Group__3__Impl : ( ( rule__SubStatement__PrototypeAssignment_3 )? ) ;
    public final void rule__SubStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3280:1: ( ( ( rule__SubStatement__PrototypeAssignment_3 )? ) )
            // InternalPerl.g:3281:1: ( ( rule__SubStatement__PrototypeAssignment_3 )? )
            {
            // InternalPerl.g:3281:1: ( ( rule__SubStatement__PrototypeAssignment_3 )? )
            // InternalPerl.g:3282:2: ( rule__SubStatement__PrototypeAssignment_3 )?
            {
             before(grammarAccess.getSubStatementAccess().getPrototypeAssignment_3()); 
            // InternalPerl.g:3283:2: ( rule__SubStatement__PrototypeAssignment_3 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==344) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalPerl.g:3283:3: rule__SubStatement__PrototypeAssignment_3
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
    // InternalPerl.g:3291:1: rule__SubStatement__Group__4 : rule__SubStatement__Group__4__Impl ;
    public final void rule__SubStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3295:1: ( rule__SubStatement__Group__4__Impl )
            // InternalPerl.g:3296:2: rule__SubStatement__Group__4__Impl
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
    // InternalPerl.g:3302:1: rule__SubStatement__Group__4__Impl : ( ( rule__SubStatement__Alternatives_4 ) ) ;
    public final void rule__SubStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3306:1: ( ( ( rule__SubStatement__Alternatives_4 ) ) )
            // InternalPerl.g:3307:1: ( ( rule__SubStatement__Alternatives_4 ) )
            {
            // InternalPerl.g:3307:1: ( ( rule__SubStatement__Alternatives_4 ) )
            // InternalPerl.g:3308:2: ( rule__SubStatement__Alternatives_4 )
            {
             before(grammarAccess.getSubStatementAccess().getAlternatives_4()); 
            // InternalPerl.g:3309:2: ( rule__SubStatement__Alternatives_4 )
            // InternalPerl.g:3309:3: rule__SubStatement__Alternatives_4
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
    // InternalPerl.g:3318:1: rule__StatementBlock__Group__0 : rule__StatementBlock__Group__0__Impl rule__StatementBlock__Group__1 ;
    public final void rule__StatementBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3322:1: ( rule__StatementBlock__Group__0__Impl rule__StatementBlock__Group__1 )
            // InternalPerl.g:3323:2: rule__StatementBlock__Group__0__Impl rule__StatementBlock__Group__1
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
    // InternalPerl.g:3330:1: rule__StatementBlock__Group__0__Impl : ( () ) ;
    public final void rule__StatementBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3334:1: ( ( () ) )
            // InternalPerl.g:3335:1: ( () )
            {
            // InternalPerl.g:3335:1: ( () )
            // InternalPerl.g:3336:2: ()
            {
             before(grammarAccess.getStatementBlockAccess().getStatementBlockAction_0()); 
            // InternalPerl.g:3337:2: ()
            // InternalPerl.g:3337:3: 
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
    // InternalPerl.g:3345:1: rule__StatementBlock__Group__1 : rule__StatementBlock__Group__1__Impl rule__StatementBlock__Group__2 ;
    public final void rule__StatementBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3349:1: ( rule__StatementBlock__Group__1__Impl rule__StatementBlock__Group__2 )
            // InternalPerl.g:3350:2: rule__StatementBlock__Group__1__Impl rule__StatementBlock__Group__2
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
    // InternalPerl.g:3357:1: rule__StatementBlock__Group__1__Impl : ( '{' ) ;
    public final void rule__StatementBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3361:1: ( ( '{' ) )
            // InternalPerl.g:3362:1: ( '{' )
            {
            // InternalPerl.g:3362:1: ( '{' )
            // InternalPerl.g:3363:2: '{'
            {
             before(grammarAccess.getStatementBlockAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,342,FOLLOW_2); 
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
    // InternalPerl.g:3372:1: rule__StatementBlock__Group__2 : rule__StatementBlock__Group__2__Impl rule__StatementBlock__Group__3 ;
    public final void rule__StatementBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3376:1: ( rule__StatementBlock__Group__2__Impl rule__StatementBlock__Group__3 )
            // InternalPerl.g:3377:2: rule__StatementBlock__Group__2__Impl rule__StatementBlock__Group__3
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
    // InternalPerl.g:3384:1: rule__StatementBlock__Group__2__Impl : ( ( rule__StatementBlock__StatementsAssignment_2 )* ) ;
    public final void rule__StatementBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3388:1: ( ( ( rule__StatementBlock__StatementsAssignment_2 )* ) )
            // InternalPerl.g:3389:1: ( ( rule__StatementBlock__StatementsAssignment_2 )* )
            {
            // InternalPerl.g:3389:1: ( ( rule__StatementBlock__StatementsAssignment_2 )* )
            // InternalPerl.g:3390:2: ( rule__StatementBlock__StatementsAssignment_2 )*
            {
             before(grammarAccess.getStatementBlockAccess().getStatementsAssignment_2()); 
            // InternalPerl.g:3391:2: ( rule__StatementBlock__StatementsAssignment_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==152||LA19_0==171||LA19_0==215||LA19_0==242) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalPerl.g:3391:3: rule__StatementBlock__StatementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__StatementBlock__StatementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalPerl.g:3399:1: rule__StatementBlock__Group__3 : rule__StatementBlock__Group__3__Impl ;
    public final void rule__StatementBlock__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3403:1: ( rule__StatementBlock__Group__3__Impl )
            // InternalPerl.g:3404:2: rule__StatementBlock__Group__3__Impl
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
    // InternalPerl.g:3410:1: rule__StatementBlock__Group__3__Impl : ( '}' ) ;
    public final void rule__StatementBlock__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3414:1: ( ( '}' ) )
            // InternalPerl.g:3415:1: ( '}' )
            {
            // InternalPerl.g:3415:1: ( '}' )
            // InternalPerl.g:3416:2: '}'
            {
             before(grammarAccess.getStatementBlockAccess().getRightCurlyBracketKeyword_3()); 
            match(input,343,FOLLOW_2); 
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
    // InternalPerl.g:3426:1: rule__Prototype__Group__0 : rule__Prototype__Group__0__Impl rule__Prototype__Group__1 ;
    public final void rule__Prototype__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3430:1: ( rule__Prototype__Group__0__Impl rule__Prototype__Group__1 )
            // InternalPerl.g:3431:2: rule__Prototype__Group__0__Impl rule__Prototype__Group__1
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
    // InternalPerl.g:3438:1: rule__Prototype__Group__0__Impl : ( '(' ) ;
    public final void rule__Prototype__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3442:1: ( ( '(' ) )
            // InternalPerl.g:3443:1: ( '(' )
            {
            // InternalPerl.g:3443:1: ( '(' )
            // InternalPerl.g:3444:2: '('
            {
             before(grammarAccess.getPrototypeAccess().getLeftParenthesisKeyword_0()); 
            match(input,344,FOLLOW_2); 
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
    // InternalPerl.g:3453:1: rule__Prototype__Group__1 : rule__Prototype__Group__1__Impl rule__Prototype__Group__2 ;
    public final void rule__Prototype__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3457:1: ( rule__Prototype__Group__1__Impl rule__Prototype__Group__2 )
            // InternalPerl.g:3458:2: rule__Prototype__Group__1__Impl rule__Prototype__Group__2
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
    // InternalPerl.g:3465:1: rule__Prototype__Group__1__Impl : ( ( rule__Prototype__Alternatives_1 )* ) ;
    public final void rule__Prototype__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3469:1: ( ( ( rule__Prototype__Alternatives_1 )* ) )
            // InternalPerl.g:3470:1: ( ( rule__Prototype__Alternatives_1 )* )
            {
            // InternalPerl.g:3470:1: ( ( rule__Prototype__Alternatives_1 )* )
            // InternalPerl.g:3471:2: ( rule__Prototype__Alternatives_1 )*
            {
             before(grammarAccess.getPrototypeAccess().getAlternatives_1()); 
            // InternalPerl.g:3472:2: ( rule__Prototype__Alternatives_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=27 && LA20_0<=31)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalPerl.g:3472:3: rule__Prototype__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Prototype__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalPerl.g:3480:1: rule__Prototype__Group__2 : rule__Prototype__Group__2__Impl ;
    public final void rule__Prototype__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3484:1: ( rule__Prototype__Group__2__Impl )
            // InternalPerl.g:3485:2: rule__Prototype__Group__2__Impl
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
    // InternalPerl.g:3491:1: rule__Prototype__Group__2__Impl : ( ')' ) ;
    public final void rule__Prototype__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3495:1: ( ( ')' ) )
            // InternalPerl.g:3496:1: ( ')' )
            {
            // InternalPerl.g:3496:1: ( ')' )
            // InternalPerl.g:3497:2: ')'
            {
             before(grammarAccess.getPrototypeAccess().getRightParenthesisKeyword_2()); 
            match(input,345,FOLLOW_2); 
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
    // InternalPerl.g:3507:1: rule__Token__Group_0__0 : rule__Token__Group_0__0__Impl rule__Token__Group_0__1 ;
    public final void rule__Token__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3511:1: ( rule__Token__Group_0__0__Impl rule__Token__Group_0__1 )
            // InternalPerl.g:3512:2: rule__Token__Group_0__0__Impl rule__Token__Group_0__1
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
    // InternalPerl.g:3519:1: rule__Token__Group_0__0__Impl : ( () ) ;
    public final void rule__Token__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3523:1: ( ( () ) )
            // InternalPerl.g:3524:1: ( () )
            {
            // InternalPerl.g:3524:1: ( () )
            // InternalPerl.g:3525:2: ()
            {
             before(grammarAccess.getTokenAccess().getPodTokenAction_0_0()); 
            // InternalPerl.g:3526:2: ()
            // InternalPerl.g:3526:3: 
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
    // InternalPerl.g:3534:1: rule__Token__Group_0__1 : rule__Token__Group_0__1__Impl ;
    public final void rule__Token__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3538:1: ( rule__Token__Group_0__1__Impl )
            // InternalPerl.g:3539:2: rule__Token__Group_0__1__Impl
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
    // InternalPerl.g:3545:1: rule__Token__Group_0__1__Impl : ( ( rule__Token__ContentAssignment_0_1 ) ) ;
    public final void rule__Token__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3549:1: ( ( ( rule__Token__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:3550:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:3550:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            // InternalPerl.g:3551:2: ( rule__Token__ContentAssignment_0_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:3552:2: ( rule__Token__ContentAssignment_0_1 )
            // InternalPerl.g:3552:3: rule__Token__ContentAssignment_0_1
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
    // InternalPerl.g:3561:1: rule__Token__Group_1__0 : rule__Token__Group_1__0__Impl rule__Token__Group_1__1 ;
    public final void rule__Token__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3565:1: ( rule__Token__Group_1__0__Impl rule__Token__Group_1__1 )
            // InternalPerl.g:3566:2: rule__Token__Group_1__0__Impl rule__Token__Group_1__1
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
    // InternalPerl.g:3573:1: rule__Token__Group_1__0__Impl : ( () ) ;
    public final void rule__Token__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3577:1: ( ( () ) )
            // InternalPerl.g:3578:1: ( () )
            {
            // InternalPerl.g:3578:1: ( () )
            // InternalPerl.g:3579:2: ()
            {
             before(grammarAccess.getTokenAccess().getNumberTokenAction_1_0()); 
            // InternalPerl.g:3580:2: ()
            // InternalPerl.g:3580:3: 
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
    // InternalPerl.g:3588:1: rule__Token__Group_1__1 : rule__Token__Group_1__1__Impl ;
    public final void rule__Token__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3592:1: ( rule__Token__Group_1__1__Impl )
            // InternalPerl.g:3593:2: rule__Token__Group_1__1__Impl
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
    // InternalPerl.g:3599:1: rule__Token__Group_1__1__Impl : ( ( rule__Token__ContentAssignment_1_1 ) ) ;
    public final void rule__Token__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3603:1: ( ( ( rule__Token__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:3604:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:3604:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            // InternalPerl.g:3605:2: ( rule__Token__ContentAssignment_1_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:3606:2: ( rule__Token__ContentAssignment_1_1 )
            // InternalPerl.g:3606:3: rule__Token__ContentAssignment_1_1
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
    // InternalPerl.g:3615:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3619:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // InternalPerl.g:3620:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
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
    // InternalPerl.g:3627:1: rule__Token__Group_2__0__Impl : ( () ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3631:1: ( ( () ) )
            // InternalPerl.g:3632:1: ( () )
            {
            // InternalPerl.g:3632:1: ( () )
            // InternalPerl.g:3633:2: ()
            {
             before(grammarAccess.getTokenAccess().getWordTokenAction_2_0()); 
            // InternalPerl.g:3634:2: ()
            // InternalPerl.g:3634:3: 
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
    // InternalPerl.g:3642:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3646:1: ( rule__Token__Group_2__1__Impl )
            // InternalPerl.g:3647:2: rule__Token__Group_2__1__Impl
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
    // InternalPerl.g:3653:1: rule__Token__Group_2__1__Impl : ( ( rule__Token__ContentAssignment_2_1 ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3657:1: ( ( ( rule__Token__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:3658:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:3658:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            // InternalPerl.g:3659:2: ( rule__Token__ContentAssignment_2_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:3660:2: ( rule__Token__ContentAssignment_2_1 )
            // InternalPerl.g:3660:3: rule__Token__ContentAssignment_2_1
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
    // InternalPerl.g:3669:1: rule__Token__Group_3__0 : rule__Token__Group_3__0__Impl rule__Token__Group_3__1 ;
    public final void rule__Token__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3673:1: ( rule__Token__Group_3__0__Impl rule__Token__Group_3__1 )
            // InternalPerl.g:3674:2: rule__Token__Group_3__0__Impl rule__Token__Group_3__1
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
    // InternalPerl.g:3681:1: rule__Token__Group_3__0__Impl : ( () ) ;
    public final void rule__Token__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3685:1: ( ( () ) )
            // InternalPerl.g:3686:1: ( () )
            {
            // InternalPerl.g:3686:1: ( () )
            // InternalPerl.g:3687:2: ()
            {
             before(grammarAccess.getTokenAccess().getSymbolTokenAction_3_0()); 
            // InternalPerl.g:3688:2: ()
            // InternalPerl.g:3688:3: 
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
    // InternalPerl.g:3696:1: rule__Token__Group_3__1 : rule__Token__Group_3__1__Impl ;
    public final void rule__Token__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3700:1: ( rule__Token__Group_3__1__Impl )
            // InternalPerl.g:3701:2: rule__Token__Group_3__1__Impl
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
    // InternalPerl.g:3707:1: rule__Token__Group_3__1__Impl : ( ( rule__Token__ContentAssignment_3_1 ) ) ;
    public final void rule__Token__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3711:1: ( ( ( rule__Token__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:3712:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:3712:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            // InternalPerl.g:3713:2: ( rule__Token__ContentAssignment_3_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:3714:2: ( rule__Token__ContentAssignment_3_1 )
            // InternalPerl.g:3714:3: rule__Token__ContentAssignment_3_1
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
    // InternalPerl.g:3723:1: rule__Token__Group_5__0 : rule__Token__Group_5__0__Impl rule__Token__Group_5__1 ;
    public final void rule__Token__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3727:1: ( rule__Token__Group_5__0__Impl rule__Token__Group_5__1 )
            // InternalPerl.g:3728:2: rule__Token__Group_5__0__Impl rule__Token__Group_5__1
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
    // InternalPerl.g:3735:1: rule__Token__Group_5__0__Impl : ( () ) ;
    public final void rule__Token__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3739:1: ( ( () ) )
            // InternalPerl.g:3740:1: ( () )
            {
            // InternalPerl.g:3740:1: ( () )
            // InternalPerl.g:3741:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_5_0()); 
            // InternalPerl.g:3742:2: ()
            // InternalPerl.g:3742:3: 
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
    // InternalPerl.g:3750:1: rule__Token__Group_5__1 : rule__Token__Group_5__1__Impl ;
    public final void rule__Token__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3754:1: ( rule__Token__Group_5__1__Impl )
            // InternalPerl.g:3755:2: rule__Token__Group_5__1__Impl
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
    // InternalPerl.g:3761:1: rule__Token__Group_5__1__Impl : ( ( rule__Token__ContentAssignment_5_1 ) ) ;
    public final void rule__Token__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3765:1: ( ( ( rule__Token__ContentAssignment_5_1 ) ) )
            // InternalPerl.g:3766:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            {
            // InternalPerl.g:3766:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            // InternalPerl.g:3767:2: ( rule__Token__ContentAssignment_5_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_5_1()); 
            // InternalPerl.g:3768:2: ( rule__Token__ContentAssignment_5_1 )
            // InternalPerl.g:3768:3: rule__Token__ContentAssignment_5_1
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
    // InternalPerl.g:3777:1: rule__Token__Group_6__0 : rule__Token__Group_6__0__Impl rule__Token__Group_6__1 ;
    public final void rule__Token__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3781:1: ( rule__Token__Group_6__0__Impl rule__Token__Group_6__1 )
            // InternalPerl.g:3782:2: rule__Token__Group_6__0__Impl rule__Token__Group_6__1
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
    // InternalPerl.g:3789:1: rule__Token__Group_6__0__Impl : ( () ) ;
    public final void rule__Token__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3793:1: ( ( () ) )
            // InternalPerl.g:3794:1: ( () )
            {
            // InternalPerl.g:3794:1: ( () )
            // InternalPerl.g:3795:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_6_0()); 
            // InternalPerl.g:3796:2: ()
            // InternalPerl.g:3796:3: 
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
    // InternalPerl.g:3804:1: rule__Token__Group_6__1 : rule__Token__Group_6__1__Impl ;
    public final void rule__Token__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3808:1: ( rule__Token__Group_6__1__Impl )
            // InternalPerl.g:3809:2: rule__Token__Group_6__1__Impl
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
    // InternalPerl.g:3815:1: rule__Token__Group_6__1__Impl : ( ( rule__Token__ContentAssignment_6_1 ) ) ;
    public final void rule__Token__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3819:1: ( ( ( rule__Token__ContentAssignment_6_1 ) ) )
            // InternalPerl.g:3820:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            {
            // InternalPerl.g:3820:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            // InternalPerl.g:3821:2: ( rule__Token__ContentAssignment_6_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_6_1()); 
            // InternalPerl.g:3822:2: ( rule__Token__ContentAssignment_6_1 )
            // InternalPerl.g:3822:3: rule__Token__ContentAssignment_6_1
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
    // InternalPerl.g:3831:1: rule__Token__Group_8__0 : rule__Token__Group_8__0__Impl rule__Token__Group_8__1 ;
    public final void rule__Token__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3835:1: ( rule__Token__Group_8__0__Impl rule__Token__Group_8__1 )
            // InternalPerl.g:3836:2: rule__Token__Group_8__0__Impl rule__Token__Group_8__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalPerl.g:3843:1: rule__Token__Group_8__0__Impl : ( () ) ;
    public final void rule__Token__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3847:1: ( ( () ) )
            // InternalPerl.g:3848:1: ( () )
            {
            // InternalPerl.g:3848:1: ( () )
            // InternalPerl.g:3849:2: ()
            {
             before(grammarAccess.getTokenAccess().getDataTokenAction_8_0()); 
            // InternalPerl.g:3850:2: ()
            // InternalPerl.g:3850:3: 
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
    // InternalPerl.g:3858:1: rule__Token__Group_8__1 : rule__Token__Group_8__1__Impl ;
    public final void rule__Token__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3862:1: ( rule__Token__Group_8__1__Impl )
            // InternalPerl.g:3863:2: rule__Token__Group_8__1__Impl
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
    // InternalPerl.g:3869:1: rule__Token__Group_8__1__Impl : ( ( rule__Token__ContentAssignment_8_1 ) ) ;
    public final void rule__Token__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3873:1: ( ( ( rule__Token__ContentAssignment_8_1 ) ) )
            // InternalPerl.g:3874:1: ( ( rule__Token__ContentAssignment_8_1 ) )
            {
            // InternalPerl.g:3874:1: ( ( rule__Token__ContentAssignment_8_1 ) )
            // InternalPerl.g:3875:2: ( rule__Token__ContentAssignment_8_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_8_1()); 
            // InternalPerl.g:3876:2: ( rule__Token__ContentAssignment_8_1 )
            // InternalPerl.g:3876:3: rule__Token__ContentAssignment_8_1
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
    // InternalPerl.g:3885:1: rule__Token__Group_9__0 : rule__Token__Group_9__0__Impl rule__Token__Group_9__1 ;
    public final void rule__Token__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3889:1: ( rule__Token__Group_9__0__Impl rule__Token__Group_9__1 )
            // InternalPerl.g:3890:2: rule__Token__Group_9__0__Impl rule__Token__Group_9__1
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
    // InternalPerl.g:3897:1: rule__Token__Group_9__0__Impl : ( () ) ;
    public final void rule__Token__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3901:1: ( ( () ) )
            // InternalPerl.g:3902:1: ( () )
            {
            // InternalPerl.g:3902:1: ( () )
            // InternalPerl.g:3903:2: ()
            {
             before(grammarAccess.getTokenAccess().getEndTokenAction_9_0()); 
            // InternalPerl.g:3904:2: ()
            // InternalPerl.g:3904:3: 
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
    // InternalPerl.g:3912:1: rule__Token__Group_9__1 : rule__Token__Group_9__1__Impl ;
    public final void rule__Token__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3916:1: ( rule__Token__Group_9__1__Impl )
            // InternalPerl.g:3917:2: rule__Token__Group_9__1__Impl
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
    // InternalPerl.g:3923:1: rule__Token__Group_9__1__Impl : ( ( rule__Token__ContentAssignment_9_1 ) ) ;
    public final void rule__Token__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3927:1: ( ( ( rule__Token__ContentAssignment_9_1 ) ) )
            // InternalPerl.g:3928:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            {
            // InternalPerl.g:3928:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            // InternalPerl.g:3929:2: ( rule__Token__ContentAssignment_9_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_9_1()); 
            // InternalPerl.g:3930:2: ( rule__Token__ContentAssignment_9_1 )
            // InternalPerl.g:3930:3: rule__Token__ContentAssignment_9_1
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
    // InternalPerl.g:3939:1: rule__QuoteToken__Group__0 : rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 ;
    public final void rule__QuoteToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3943:1: ( rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 )
            // InternalPerl.g:3944:2: rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalPerl.g:3951:1: rule__QuoteToken__Group__0__Impl : ( () ) ;
    public final void rule__QuoteToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3955:1: ( ( () ) )
            // InternalPerl.g:3956:1: ( () )
            {
            // InternalPerl.g:3956:1: ( () )
            // InternalPerl.g:3957:2: ()
            {
             before(grammarAccess.getQuoteTokenAccess().getQuoteTokenAction_0()); 
            // InternalPerl.g:3958:2: ()
            // InternalPerl.g:3958:3: 
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
    // InternalPerl.g:3966:1: rule__QuoteToken__Group__1 : rule__QuoteToken__Group__1__Impl ;
    public final void rule__QuoteToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3970:1: ( rule__QuoteToken__Group__1__Impl )
            // InternalPerl.g:3971:2: rule__QuoteToken__Group__1__Impl
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
    // InternalPerl.g:3977:1: rule__QuoteToken__Group__1__Impl : ( ( rule__QuoteToken__ContentAssignment_1 ) ) ;
    public final void rule__QuoteToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3981:1: ( ( ( rule__QuoteToken__ContentAssignment_1 ) ) )
            // InternalPerl.g:3982:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            {
            // InternalPerl.g:3982:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            // InternalPerl.g:3983:2: ( rule__QuoteToken__ContentAssignment_1 )
            {
             before(grammarAccess.getQuoteTokenAccess().getContentAssignment_1()); 
            // InternalPerl.g:3984:2: ( rule__QuoteToken__ContentAssignment_1 )
            // InternalPerl.g:3984:3: rule__QuoteToken__ContentAssignment_1
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
    // InternalPerl.g:3993:1: rule__QuoteLikeToken__Group_0__0 : rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 ;
    public final void rule__QuoteLikeToken__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3997:1: ( rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 )
            // InternalPerl.g:3998:2: rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalPerl.g:4005:1: rule__QuoteLikeToken__Group_0__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4009:1: ( ( () ) )
            // InternalPerl.g:4010:1: ( () )
            {
            // InternalPerl.g:4010:1: ( () )
            // InternalPerl.g:4011:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0()); 
            // InternalPerl.g:4012:2: ()
            // InternalPerl.g:4012:3: 
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
    // InternalPerl.g:4020:1: rule__QuoteLikeToken__Group_0__1 : rule__QuoteLikeToken__Group_0__1__Impl ;
    public final void rule__QuoteLikeToken__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4024:1: ( rule__QuoteLikeToken__Group_0__1__Impl )
            // InternalPerl.g:4025:2: rule__QuoteLikeToken__Group_0__1__Impl
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
    // InternalPerl.g:4031:1: rule__QuoteLikeToken__Group_0__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4035:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:4036:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:4036:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            // InternalPerl.g:4037:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:4038:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            // InternalPerl.g:4038:3: rule__QuoteLikeToken__ContentAssignment_0_1
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
    // InternalPerl.g:4047:1: rule__QuoteLikeToken__Group_1__0 : rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 ;
    public final void rule__QuoteLikeToken__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4051:1: ( rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 )
            // InternalPerl.g:4052:2: rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalPerl.g:4059:1: rule__QuoteLikeToken__Group_1__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4063:1: ( ( () ) )
            // InternalPerl.g:4064:1: ( () )
            {
            // InternalPerl.g:4064:1: ( () )
            // InternalPerl.g:4065:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0()); 
            // InternalPerl.g:4066:2: ()
            // InternalPerl.g:4066:3: 
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
    // InternalPerl.g:4074:1: rule__QuoteLikeToken__Group_1__1 : rule__QuoteLikeToken__Group_1__1__Impl ;
    public final void rule__QuoteLikeToken__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4078:1: ( rule__QuoteLikeToken__Group_1__1__Impl )
            // InternalPerl.g:4079:2: rule__QuoteLikeToken__Group_1__1__Impl
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
    // InternalPerl.g:4085:1: rule__QuoteLikeToken__Group_1__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4089:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:4090:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:4090:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            // InternalPerl.g:4091:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:4092:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            // InternalPerl.g:4092:3: rule__QuoteLikeToken__ContentAssignment_1_1
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
    // InternalPerl.g:4101:1: rule__QuoteLikeToken__Group_2__0 : rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 ;
    public final void rule__QuoteLikeToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4105:1: ( rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 )
            // InternalPerl.g:4106:2: rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalPerl.g:4113:1: rule__QuoteLikeToken__Group_2__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4117:1: ( ( () ) )
            // InternalPerl.g:4118:1: ( () )
            {
            // InternalPerl.g:4118:1: ( () )
            // InternalPerl.g:4119:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0()); 
            // InternalPerl.g:4120:2: ()
            // InternalPerl.g:4120:3: 
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
    // InternalPerl.g:4128:1: rule__QuoteLikeToken__Group_2__1 : rule__QuoteLikeToken__Group_2__1__Impl ;
    public final void rule__QuoteLikeToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4132:1: ( rule__QuoteLikeToken__Group_2__1__Impl )
            // InternalPerl.g:4133:2: rule__QuoteLikeToken__Group_2__1__Impl
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
    // InternalPerl.g:4139:1: rule__QuoteLikeToken__Group_2__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4143:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:4144:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:4144:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            // InternalPerl.g:4145:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:4146:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            // InternalPerl.g:4146:3: rule__QuoteLikeToken__ContentAssignment_2_1
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
    // InternalPerl.g:4155:1: rule__QuoteLikeToken__Group_3__0 : rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 ;
    public final void rule__QuoteLikeToken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4159:1: ( rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 )
            // InternalPerl.g:4160:2: rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalPerl.g:4167:1: rule__QuoteLikeToken__Group_3__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4171:1: ( ( () ) )
            // InternalPerl.g:4172:1: ( () )
            {
            // InternalPerl.g:4172:1: ( () )
            // InternalPerl.g:4173:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0()); 
            // InternalPerl.g:4174:2: ()
            // InternalPerl.g:4174:3: 
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
    // InternalPerl.g:4182:1: rule__QuoteLikeToken__Group_3__1 : rule__QuoteLikeToken__Group_3__1__Impl ;
    public final void rule__QuoteLikeToken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4186:1: ( rule__QuoteLikeToken__Group_3__1__Impl )
            // InternalPerl.g:4187:2: rule__QuoteLikeToken__Group_3__1__Impl
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
    // InternalPerl.g:4193:1: rule__QuoteLikeToken__Group_3__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4197:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:4198:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:4198:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            // InternalPerl.g:4199:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:4200:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            // InternalPerl.g:4200:3: rule__QuoteLikeToken__ContentAssignment_3_1
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
    // InternalPerl.g:4209:1: rule__QuoteLikeToken__Group_4__0 : rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 ;
    public final void rule__QuoteLikeToken__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4213:1: ( rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 )
            // InternalPerl.g:4214:2: rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalPerl.g:4221:1: rule__QuoteLikeToken__Group_4__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4225:1: ( ( () ) )
            // InternalPerl.g:4226:1: ( () )
            {
            // InternalPerl.g:4226:1: ( () )
            // InternalPerl.g:4227:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0()); 
            // InternalPerl.g:4228:2: ()
            // InternalPerl.g:4228:3: 
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
    // InternalPerl.g:4236:1: rule__QuoteLikeToken__Group_4__1 : rule__QuoteLikeToken__Group_4__1__Impl ;
    public final void rule__QuoteLikeToken__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4240:1: ( rule__QuoteLikeToken__Group_4__1__Impl )
            // InternalPerl.g:4241:2: rule__QuoteLikeToken__Group_4__1__Impl
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
    // InternalPerl.g:4247:1: rule__QuoteLikeToken__Group_4__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4251:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) )
            // InternalPerl.g:4252:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            {
            // InternalPerl.g:4252:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            // InternalPerl.g:4253:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_4_1()); 
            // InternalPerl.g:4254:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            // InternalPerl.g:4254:3: rule__QuoteLikeToken__ContentAssignment_4_1
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
    // InternalPerl.g:4263:1: rule__Operator__Group_23__0 : rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 ;
    public final void rule__Operator__Group_23__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4267:1: ( rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 )
            // InternalPerl.g:4268:2: rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalPerl.g:4275:1: rule__Operator__Group_23__0__Impl : ( '<=>' ) ;
    public final void rule__Operator__Group_23__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4279:1: ( ( '<=>' ) )
            // InternalPerl.g:4280:1: ( '<=>' )
            {
            // InternalPerl.g:4280:1: ( '<=>' )
            // InternalPerl.g:4281:2: '<=>'
            {
             before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_23_0()); 
            match(input,346,FOLLOW_2); 
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
    // InternalPerl.g:4290:1: rule__Operator__Group_23__1 : rule__Operator__Group_23__1__Impl ;
    public final void rule__Operator__Group_23__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4294:1: ( rule__Operator__Group_23__1__Impl )
            // InternalPerl.g:4295:2: rule__Operator__Group_23__1__Impl
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
    // InternalPerl.g:4301:1: rule__Operator__Group_23__1__Impl : ( '.' ) ;
    public final void rule__Operator__Group_23__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4305:1: ( ( '.' ) )
            // InternalPerl.g:4306:1: ( '.' )
            {
            // InternalPerl.g:4306:1: ( '.' )
            // InternalPerl.g:4307:2: '.'
            {
             before(grammarAccess.getOperatorAccess().getFullStopKeyword_23_1()); 
            match(input,347,FOLLOW_2); 
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
    // InternalPerl.g:4317:1: rule__PerlDocument__ElementsAssignment_1 : ( ruleElement ) ;
    public final void rule__PerlDocument__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4321:1: ( ( ruleElement ) )
            // InternalPerl.g:4322:2: ( ruleElement )
            {
            // InternalPerl.g:4322:2: ( ruleElement )
            // InternalPerl.g:4323:3: ruleElement
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
    // InternalPerl.g:4332:1: rule__PackageStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4336:1: ( ( RULE_ID ) )
            // InternalPerl.g:4337:2: ( RULE_ID )
            {
            // InternalPerl.g:4337:2: ( RULE_ID )
            // InternalPerl.g:4338:3: RULE_ID
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
    // InternalPerl.g:4347:1: rule__PackageStatement__VersionAssignment_3 : ( RULE_VERSION ) ;
    public final void rule__PackageStatement__VersionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4351:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4352:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4352:2: ( RULE_VERSION )
            // InternalPerl.g:4353:3: RULE_VERSION
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
    // InternalPerl.g:4362:1: rule__RequireInclude__VersionAssignment_1 : ( RULE_VERSION ) ;
    public final void rule__RequireInclude__VersionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4366:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4367:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4367:2: ( RULE_VERSION )
            // InternalPerl.g:4368:3: RULE_VERSION
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
    // InternalPerl.g:4377:1: rule__UseInclude__VersionAssignment_2_0 : ( RULE_VERSION ) ;
    public final void rule__UseInclude__VersionAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4381:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4382:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4382:2: ( RULE_VERSION )
            // InternalPerl.g:4383:3: RULE_VERSION
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
    // InternalPerl.g:4392:1: rule__UseInclude__PragmaOrPackageAssignment_2_1_0 : ( RULE_ID ) ;
    public final void rule__UseInclude__PragmaOrPackageAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4396:1: ( ( RULE_ID ) )
            // InternalPerl.g:4397:2: ( RULE_ID )
            {
            // InternalPerl.g:4397:2: ( RULE_ID )
            // InternalPerl.g:4398:3: RULE_ID
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
    // InternalPerl.g:4407:1: rule__UseInclude__StringArgumentAssignment_2_1_1_0 : ( ruleQuoteToken ) ;
    public final void rule__UseInclude__StringArgumentAssignment_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4411:1: ( ( ruleQuoteToken ) )
            // InternalPerl.g:4412:2: ( ruleQuoteToken )
            {
            // InternalPerl.g:4412:2: ( ruleQuoteToken )
            // InternalPerl.g:4413:3: ruleQuoteToken
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
    // InternalPerl.g:4422:1: rule__UseInclude__QwArgumentAssignment_2_1_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__UseInclude__QwArgumentAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4426:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:4427:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:4427:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:4428:3: RULE_WORDS_QUOTE_LIKE
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
    // InternalPerl.g:4437:1: rule__SubStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SubStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4441:1: ( ( RULE_ID ) )
            // InternalPerl.g:4442:2: ( RULE_ID )
            {
            // InternalPerl.g:4442:2: ( RULE_ID )
            // InternalPerl.g:4443:3: RULE_ID
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
    // InternalPerl.g:4452:1: rule__SubStatement__PrototypeAssignment_3 : ( rulePrototype ) ;
    public final void rule__SubStatement__PrototypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4456:1: ( ( rulePrototype ) )
            // InternalPerl.g:4457:2: ( rulePrototype )
            {
            // InternalPerl.g:4457:2: ( rulePrototype )
            // InternalPerl.g:4458:3: rulePrototype
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
    // InternalPerl.g:4467:1: rule__SubStatement__BlockAssignment_4_1 : ( ruleStatementBlock ) ;
    public final void rule__SubStatement__BlockAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4471:1: ( ( ruleStatementBlock ) )
            // InternalPerl.g:4472:2: ( ruleStatementBlock )
            {
            // InternalPerl.g:4472:2: ( ruleStatementBlock )
            // InternalPerl.g:4473:3: ruleStatementBlock
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
    // InternalPerl.g:4482:1: rule__StatementBlock__StatementsAssignment_2 : ( ruleStatementNode ) ;
    public final void rule__StatementBlock__StatementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4486:1: ( ( ruleStatementNode ) )
            // InternalPerl.g:4487:2: ( ruleStatementNode )
            {
            // InternalPerl.g:4487:2: ( ruleStatementNode )
            // InternalPerl.g:4488:3: ruleStatementNode
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
    // InternalPerl.g:4497:1: rule__Token__ContentAssignment_0_1 : ( RULE_POD ) ;
    public final void rule__Token__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4501:1: ( ( RULE_POD ) )
            // InternalPerl.g:4502:2: ( RULE_POD )
            {
            // InternalPerl.g:4502:2: ( RULE_POD )
            // InternalPerl.g:4503:3: RULE_POD
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
    // InternalPerl.g:4512:1: rule__Token__ContentAssignment_1_1 : ( RULE_NUMBER ) ;
    public final void rule__Token__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4516:1: ( ( RULE_NUMBER ) )
            // InternalPerl.g:4517:2: ( RULE_NUMBER )
            {
            // InternalPerl.g:4517:2: ( RULE_NUMBER )
            // InternalPerl.g:4518:3: RULE_NUMBER
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
    // InternalPerl.g:4527:1: rule__Token__ContentAssignment_2_1 : ( ruleWord ) ;
    public final void rule__Token__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4531:1: ( ( ruleWord ) )
            // InternalPerl.g:4532:2: ( ruleWord )
            {
            // InternalPerl.g:4532:2: ( ruleWord )
            // InternalPerl.g:4533:3: ruleWord
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
    // InternalPerl.g:4542:1: rule__Token__ContentAssignment_3_1 : ( RULE_SYMBOL ) ;
    public final void rule__Token__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4546:1: ( ( RULE_SYMBOL ) )
            // InternalPerl.g:4547:2: ( RULE_SYMBOL )
            {
            // InternalPerl.g:4547:2: ( RULE_SYMBOL )
            // InternalPerl.g:4548:3: RULE_SYMBOL
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
    // InternalPerl.g:4557:1: rule__Token__ContentAssignment_5_1 : ( ruleFileTestOperator ) ;
    public final void rule__Token__ContentAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4561:1: ( ( ruleFileTestOperator ) )
            // InternalPerl.g:4562:2: ( ruleFileTestOperator )
            {
            // InternalPerl.g:4562:2: ( ruleFileTestOperator )
            // InternalPerl.g:4563:3: ruleFileTestOperator
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
    // InternalPerl.g:4572:1: rule__Token__ContentAssignment_6_1 : ( ruleOperator ) ;
    public final void rule__Token__ContentAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4576:1: ( ( ruleOperator ) )
            // InternalPerl.g:4577:2: ( ruleOperator )
            {
            // InternalPerl.g:4577:2: ( ruleOperator )
            // InternalPerl.g:4578:3: ruleOperator
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
    // InternalPerl.g:4587:1: rule__Token__ContentAssignment_8_1 : ( RULE_DATA ) ;
    public final void rule__Token__ContentAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4591:1: ( ( RULE_DATA ) )
            // InternalPerl.g:4592:2: ( RULE_DATA )
            {
            // InternalPerl.g:4592:2: ( RULE_DATA )
            // InternalPerl.g:4593:3: RULE_DATA
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
    // InternalPerl.g:4602:1: rule__Token__ContentAssignment_9_1 : ( RULE_END ) ;
    public final void rule__Token__ContentAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4606:1: ( ( RULE_END ) )
            // InternalPerl.g:4607:2: ( RULE_END )
            {
            // InternalPerl.g:4607:2: ( RULE_END )
            // InternalPerl.g:4608:3: RULE_END
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
    // InternalPerl.g:4617:1: rule__QuoteToken__ContentAssignment_1 : ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) ;
    public final void rule__QuoteToken__ContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4621:1: ( ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) )
            // InternalPerl.g:4622:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            {
            // InternalPerl.g:4622:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            // InternalPerl.g:4623:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            {
             before(grammarAccess.getQuoteTokenAccess().getContentAlternatives_1_0()); 
            // InternalPerl.g:4624:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            // InternalPerl.g:4624:4: rule__QuoteToken__ContentAlternatives_1_0
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
    // InternalPerl.g:4632:1: rule__QuoteLikeToken__ContentAssignment_0_1 : ( RULE_BACKTICK_STRING ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4636:1: ( ( RULE_BACKTICK_STRING ) )
            // InternalPerl.g:4637:2: ( RULE_BACKTICK_STRING )
            {
            // InternalPerl.g:4637:2: ( RULE_BACKTICK_STRING )
            // InternalPerl.g:4638:3: RULE_BACKTICK_STRING
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
    // InternalPerl.g:4647:1: rule__QuoteLikeToken__ContentAssignment_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4651:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:4652:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:4652:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:4653:3: RULE_WORDS_QUOTE_LIKE
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
    // InternalPerl.g:4662:1: rule__QuoteLikeToken__ContentAssignment_2_1 : ( RULE_COMMAND_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4666:1: ( ( RULE_COMMAND_QUOTE_LIKE ) )
            // InternalPerl.g:4667:2: ( RULE_COMMAND_QUOTE_LIKE )
            {
            // InternalPerl.g:4667:2: ( RULE_COMMAND_QUOTE_LIKE )
            // InternalPerl.g:4668:3: RULE_COMMAND_QUOTE_LIKE
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
    // InternalPerl.g:4677:1: rule__QuoteLikeToken__ContentAssignment_3_1 : ( RULE_REGEX_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4681:1: ( ( RULE_REGEX_QUOTE ) )
            // InternalPerl.g:4682:2: ( RULE_REGEX_QUOTE )
            {
            // InternalPerl.g:4682:2: ( RULE_REGEX_QUOTE )
            // InternalPerl.g:4683:3: RULE_REGEX_QUOTE
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
    // InternalPerl.g:4692:1: rule__QuoteLikeToken__ContentAssignment_4_1 : ( RULE_READLINE_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4696:1: ( ( RULE_READLINE_QUOTE ) )
            // InternalPerl.g:4697:2: ( RULE_READLINE_QUOTE )
            {
            // InternalPerl.g:4697:2: ( RULE_READLINE_QUOTE )
            // InternalPerl.g:4698:3: RULE_READLINE_QUOTE
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFFFFFA007FE70L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000000043FFFFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFFA007FE72L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000000043FFFFFL});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000080001000000L,0x0004000000800000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000270L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000001400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000080001000000L,0x0004000000800000L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000080001000000L,0x0004000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000F8000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000F8000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xFFFFFFFF00000000L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x3FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xF800000000000000L,0x00000000003FFFFFL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000A0000000L,0x0000000000000000L,0x0000000000000000L,0xC000000000000000L,0x07FFFFFFFFFFFFFFL,0x0000000004000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000078200L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});

}