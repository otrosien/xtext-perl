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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INTERPOLATE", "RULE_LITERAL", "RULE_REGEX_SUBSTITUTE", "RULE_REGEX_TRANSLITERATE", "RULE_REGEX_MATCH", "RULE_ID", "RULE_VERSION", "RULE_WORDS_QUOTE_LIKE", "RULE_POD", "RULE_NUMBER", "RULE_SYMBOL", "RULE_DATA", "RULE_END", "RULE_BACKTICK_STRING", "RULE_COMMAND_QUOTE_LIKE", "RULE_REGEX_QUOTE", "RULE_READLINE_QUOTE", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER", "RULE_SL_COMMENT", "';'", "'$'", "'%'", "'@'", "'&'", "'abs'", "'accept'", "'alarm'", "'atan2'", "'bind'", "'binmode'", "'bless'", "'break'", "'caller'", "'chdir'", "'chmod'", "'chomp'", "'chop'", "'chown'", "'chr'", "'chroot'", "'close'", "'closedir'", "'connect'", "'continue'", "'cos'", "'crypt'", "'dbmclose'", "'dbmopen'", "'default'", "'defined'", "'delete'", "'die'", "'do'", "'dump'", "'each'", "'else'", "'elsif'", "'endgrent'", "'endhostent'", "'endnetent'", "'endprotoent'", "'endpwent'", "'endservent'", "'eof'", "'eval'", "'evalbytes'", "'exec'", "'exists'", "'exit'", "'exp'", "'fc'", "'fcntl'", "'fileno'", "'flock'", "'for'", "'foreach'", "'fork'", "'format'", "'formline'", "'getc'", "'getgrent'", "'getgrgid'", "'getgrnam'", "'gethostbyaddr'", "'gethostbyname'", "'gethostent'", "'getlogin'", "'getnetbyaddr'", "'getnetbyname'", "'getnetent'", "'getpeername'", "'getpgrp'", "'getppid'", "'getpriority'", "'getprotobyname'", "'getprotobynumber'", "'getprotoent'", "'getpwent'", "'getpwnam'", "'getpwuid'", "'getservbyname'", "'getservbyport'", "'getservent'", "'getsockname'", "'getsockopt'", "'given'", "'glob'", "'gmtime'", "'goto'", "'grep'", "'hex'", "'if'", "'index'", "'int'", "'ioctl'", "'join'", "'keys'", "'kill'", "'last'", "'lc'", "'lcfirst'", "'length'", "'link'", "'listen'", "'local'", "'localtime'", "'lock'", "'log'", "'lstat'", "'map'", "'mkdir'", "'msgctl'", "'msgget'", "'msgrcv'", "'msgsnd'", "'my'", "'next'", "'no'", "'oct'", "'open'", "'opendir'", "'ord'", "'our'", "'pack'", "'package'", "'pipe'", "'pop'", "'pos'", "'print'", "'printf'", "'prototype'", "'push'", "'quotemeta'", "'rand'", "'read'", "'readdir'", "'readline'", "'readlink'", "'readpipe'", "'recv'", "'redo'", "'ref'", "'rename'", "'require'", "'reset'", "'return'", "'reverse'", "'rewinddir'", "'rindex'", "'rmdir'", "'say'", "'scalar'", "'seek'", "'seekdir'", "'select'", "'semctl'", "'semget'", "'semop'", "'send'", "'setgrent'", "'sethostent'", "'setnetent'", "'setpgrp'", "'setpriority'", "'setprotoent'", "'setpwent'", "'setservent'", "'setsockopt'", "'shift'", "'shmctl'", "'shmget'", "'shmread'", "'shmwrite'", "'shutdown'", "'sin'", "'sleep'", "'socket'", "'socketpair'", "'sort'", "'splice'", "'split'", "'sprintf'", "'sqrt'", "'srand'", "'stat'", "'state'", "'study'", "'sub'", "'substr'", "'symlink'", "'syscall'", "'sysopen'", "'sysread'", "'sysseek'", "'system'", "'syswrite'", "'tell'", "'telldir'", "'tie'", "'tied'", "'time'", "'times'", "'tr'", "'truncate'", "'uc'", "'ucfirst'", "'umask'", "'undef'", "'unless'", "'unlink'", "'unpack'", "'unshift'", "'untie'", "'until'", "'use'", "'utime'", "'values'", "'vec'", "'wait'", "'waitpid'", "'wantarray'", "'warn'", "'when'", "'while'", "'write'", "'y'", "'++'", "'--'", "'**'", "'!'", "'~'", "'+'", "'-'", "'=~'", "'!~'", "'*'", "'/'", "'x'", "'<<'", "'>>'", "'lt'", "'gt'", "'le'", "'ge'", "'cmp'", "'~~'", "'=='", "'!='", "'..'", "'...'", "','", "'|'", "'^'", "'&&'", "'||'", "'//'", "'?'", "':'", "'**='", "'+='", "'-='", "'.='", "'*='", "'/='", "'%='", "'x='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'&&='", "'||='", "'//='", "'<'", "'>'", "'<='", "'>='", "'<>'", "'=>'", "'->'", "'and'", "'or'", "'xor'", "'not'", "'eq'", "'ne'", "'-r'", "'-w'", "'-x'", "'-o'", "'-R'", "'-W'", "'-X'", "'-O'", "'-e'", "'-z'", "'-s'", "'-f'", "'-d'", "'-l'", "'-p'", "'-S'", "'-b'", "'-c'", "'-t'", "'-u'", "'-g'", "'-k'", "'-T'", "'-B'", "'-M'", "'-A'", "'-C'", "'{'", "'}'", "'('", "')'", "'<=>'", "'.'"
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
    public static final int RULE_REGEX_TRANSLITERATE=8;
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
    public static final int RULE_REGEX_SUBSTITUTE=7;
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
    public static final int RULE_LITERAL=6;
    public static final int RULE_BIN=23;
    public static final int RULE_REGEX_MATCH=9;
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
    public static final int RULE_WORDS_QUOTE_LIKE=12;
    public static final int T__169=169;
    public static final int RULE_REGEX_QUOTE=20;
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
    // InternalPerl.g:112:1: ruleNode : ( ( rule__Node__Alternatives ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:116:2: ( ( ( rule__Node__Alternatives ) ) )
            // InternalPerl.g:117:2: ( ( rule__Node__Alternatives ) )
            {
            // InternalPerl.g:117:2: ( ( rule__Node__Alternatives ) )
            // InternalPerl.g:118:3: ( rule__Node__Alternatives )
            {
             before(grammarAccess.getNodeAccess().getAlternatives()); 
            // InternalPerl.g:119:3: ( rule__Node__Alternatives )
            // InternalPerl.g:119:4: rule__Node__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Node__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleStructureNode"
    // InternalPerl.g:203:1: entryRuleStructureNode : ruleStructureNode EOF ;
    public final void entryRuleStructureNode() throws RecognitionException {
        try {
            // InternalPerl.g:204:1: ( ruleStructureNode EOF )
            // InternalPerl.g:205:1: ruleStructureNode EOF
            {
             before(grammarAccess.getStructureNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleStructureNode();

            state._fsp--;

             after(grammarAccess.getStructureNodeRule()); 
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
    // $ANTLR end "entryRuleStructureNode"


    // $ANTLR start "ruleStructureNode"
    // InternalPerl.g:212:1: ruleStructureNode : ( ruleBlockStructure ) ;
    public final void ruleStructureNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:216:2: ( ( ruleBlockStructure ) )
            // InternalPerl.g:217:2: ( ruleBlockStructure )
            {
            // InternalPerl.g:217:2: ( ruleBlockStructure )
            // InternalPerl.g:218:3: ruleBlockStructure
            {
             before(grammarAccess.getStructureNodeAccess().getBlockStructureParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleBlockStructure();

            state._fsp--;

             after(grammarAccess.getStructureNodeAccess().getBlockStructureParserRuleCall()); 

            }


            }

        }
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
    // InternalPerl.g:228:1: entryRulePackageStatement : rulePackageStatement EOF ;
    public final void entryRulePackageStatement() throws RecognitionException {
        try {
            // InternalPerl.g:229:1: ( rulePackageStatement EOF )
            // InternalPerl.g:230:1: rulePackageStatement EOF
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
    // InternalPerl.g:237:1: rulePackageStatement : ( ( rule__PackageStatement__Group__0 ) ) ;
    public final void rulePackageStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:241:2: ( ( ( rule__PackageStatement__Group__0 ) ) )
            // InternalPerl.g:242:2: ( ( rule__PackageStatement__Group__0 ) )
            {
            // InternalPerl.g:242:2: ( ( rule__PackageStatement__Group__0 ) )
            // InternalPerl.g:243:3: ( rule__PackageStatement__Group__0 )
            {
             before(grammarAccess.getPackageStatementAccess().getGroup()); 
            // InternalPerl.g:244:3: ( rule__PackageStatement__Group__0 )
            // InternalPerl.g:244:4: rule__PackageStatement__Group__0
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
    // InternalPerl.g:253:1: entryRuleIncludeStatement : ruleIncludeStatement EOF ;
    public final void entryRuleIncludeStatement() throws RecognitionException {
        try {
            // InternalPerl.g:254:1: ( ruleIncludeStatement EOF )
            // InternalPerl.g:255:1: ruleIncludeStatement EOF
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
    // InternalPerl.g:262:1: ruleIncludeStatement : ( ( rule__IncludeStatement__Alternatives ) ) ;
    public final void ruleIncludeStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:266:2: ( ( ( rule__IncludeStatement__Alternatives ) ) )
            // InternalPerl.g:267:2: ( ( rule__IncludeStatement__Alternatives ) )
            {
            // InternalPerl.g:267:2: ( ( rule__IncludeStatement__Alternatives ) )
            // InternalPerl.g:268:3: ( rule__IncludeStatement__Alternatives )
            {
             before(grammarAccess.getIncludeStatementAccess().getAlternatives()); 
            // InternalPerl.g:269:3: ( rule__IncludeStatement__Alternatives )
            // InternalPerl.g:269:4: rule__IncludeStatement__Alternatives
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
    // InternalPerl.g:278:1: entryRuleRequireInclude : ruleRequireInclude EOF ;
    public final void entryRuleRequireInclude() throws RecognitionException {
        try {
            // InternalPerl.g:279:1: ( ruleRequireInclude EOF )
            // InternalPerl.g:280:1: ruleRequireInclude EOF
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
    // InternalPerl.g:287:1: ruleRequireInclude : ( ( rule__RequireInclude__Group__0 ) ) ;
    public final void ruleRequireInclude() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:291:2: ( ( ( rule__RequireInclude__Group__0 ) ) )
            // InternalPerl.g:292:2: ( ( rule__RequireInclude__Group__0 ) )
            {
            // InternalPerl.g:292:2: ( ( rule__RequireInclude__Group__0 ) )
            // InternalPerl.g:293:3: ( rule__RequireInclude__Group__0 )
            {
             before(grammarAccess.getRequireIncludeAccess().getGroup()); 
            // InternalPerl.g:294:3: ( rule__RequireInclude__Group__0 )
            // InternalPerl.g:294:4: rule__RequireInclude__Group__0
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
    // InternalPerl.g:303:1: entryRuleUseInclude : ruleUseInclude EOF ;
    public final void entryRuleUseInclude() throws RecognitionException {
        try {
            // InternalPerl.g:304:1: ( ruleUseInclude EOF )
            // InternalPerl.g:305:1: ruleUseInclude EOF
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
    // InternalPerl.g:312:1: ruleUseInclude : ( ( rule__UseInclude__Group__0 ) ) ;
    public final void ruleUseInclude() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:316:2: ( ( ( rule__UseInclude__Group__0 ) ) )
            // InternalPerl.g:317:2: ( ( rule__UseInclude__Group__0 ) )
            {
            // InternalPerl.g:317:2: ( ( rule__UseInclude__Group__0 ) )
            // InternalPerl.g:318:3: ( rule__UseInclude__Group__0 )
            {
             before(grammarAccess.getUseIncludeAccess().getGroup()); 
            // InternalPerl.g:319:3: ( rule__UseInclude__Group__0 )
            // InternalPerl.g:319:4: rule__UseInclude__Group__0
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
    // InternalPerl.g:328:1: entryRuleSubStatement : ruleSubStatement EOF ;
    public final void entryRuleSubStatement() throws RecognitionException {
        try {
            // InternalPerl.g:329:1: ( ruleSubStatement EOF )
            // InternalPerl.g:330:1: ruleSubStatement EOF
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
    // InternalPerl.g:337:1: ruleSubStatement : ( ( rule__SubStatement__Group__0 ) ) ;
    public final void ruleSubStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:341:2: ( ( ( rule__SubStatement__Group__0 ) ) )
            // InternalPerl.g:342:2: ( ( rule__SubStatement__Group__0 ) )
            {
            // InternalPerl.g:342:2: ( ( rule__SubStatement__Group__0 ) )
            // InternalPerl.g:343:3: ( rule__SubStatement__Group__0 )
            {
             before(grammarAccess.getSubStatementAccess().getGroup()); 
            // InternalPerl.g:344:3: ( rule__SubStatement__Group__0 )
            // InternalPerl.g:344:4: rule__SubStatement__Group__0
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


    // $ANTLR start "entryRuleBlockStructure"
    // InternalPerl.g:353:1: entryRuleBlockStructure : ruleBlockStructure EOF ;
    public final void entryRuleBlockStructure() throws RecognitionException {
        try {
            // InternalPerl.g:354:1: ( ruleBlockStructure EOF )
            // InternalPerl.g:355:1: ruleBlockStructure EOF
            {
             before(grammarAccess.getBlockStructureRule()); 
            pushFollow(FOLLOW_1);
            ruleBlockStructure();

            state._fsp--;

             after(grammarAccess.getBlockStructureRule()); 
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
    // $ANTLR end "entryRuleBlockStructure"


    // $ANTLR start "ruleBlockStructure"
    // InternalPerl.g:362:1: ruleBlockStructure : ( ( rule__BlockStructure__Group__0 ) ) ;
    public final void ruleBlockStructure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:366:2: ( ( ( rule__BlockStructure__Group__0 ) ) )
            // InternalPerl.g:367:2: ( ( rule__BlockStructure__Group__0 ) )
            {
            // InternalPerl.g:367:2: ( ( rule__BlockStructure__Group__0 ) )
            // InternalPerl.g:368:3: ( rule__BlockStructure__Group__0 )
            {
             before(grammarAccess.getBlockStructureAccess().getGroup()); 
            // InternalPerl.g:369:3: ( rule__BlockStructure__Group__0 )
            // InternalPerl.g:369:4: rule__BlockStructure__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BlockStructure__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBlockStructureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBlockStructure"


    // $ANTLR start "entryRulePrototype"
    // InternalPerl.g:378:1: entryRulePrototype : rulePrototype EOF ;
    public final void entryRulePrototype() throws RecognitionException {
        try {
            // InternalPerl.g:379:1: ( rulePrototype EOF )
            // InternalPerl.g:380:1: rulePrototype EOF
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
    // InternalPerl.g:387:1: rulePrototype : ( ( rule__Prototype__Group__0 ) ) ;
    public final void rulePrototype() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:391:2: ( ( ( rule__Prototype__Group__0 ) ) )
            // InternalPerl.g:392:2: ( ( rule__Prototype__Group__0 ) )
            {
            // InternalPerl.g:392:2: ( ( rule__Prototype__Group__0 ) )
            // InternalPerl.g:393:3: ( rule__Prototype__Group__0 )
            {
             before(grammarAccess.getPrototypeAccess().getGroup()); 
            // InternalPerl.g:394:3: ( rule__Prototype__Group__0 )
            // InternalPerl.g:394:4: rule__Prototype__Group__0
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
    // InternalPerl.g:403:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // InternalPerl.g:404:1: ( ruleToken EOF )
            // InternalPerl.g:405:1: ruleToken EOF
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
    // InternalPerl.g:412:1: ruleToken : ( ( rule__Token__Alternatives ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:416:2: ( ( ( rule__Token__Alternatives ) ) )
            // InternalPerl.g:417:2: ( ( rule__Token__Alternatives ) )
            {
            // InternalPerl.g:417:2: ( ( rule__Token__Alternatives ) )
            // InternalPerl.g:418:3: ( rule__Token__Alternatives )
            {
             before(grammarAccess.getTokenAccess().getAlternatives()); 
            // InternalPerl.g:419:3: ( rule__Token__Alternatives )
            // InternalPerl.g:419:4: rule__Token__Alternatives
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


    // $ANTLR start "entryRuleRegexToken"
    // InternalPerl.g:453:1: entryRuleRegexToken : ruleRegexToken EOF ;
    public final void entryRuleRegexToken() throws RecognitionException {
        try {
            // InternalPerl.g:454:1: ( ruleRegexToken EOF )
            // InternalPerl.g:455:1: ruleRegexToken EOF
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
    // InternalPerl.g:462:1: ruleRegexToken : ( ( rule__RegexToken__Group__0 ) ) ;
    public final void ruleRegexToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:466:2: ( ( ( rule__RegexToken__Group__0 ) ) )
            // InternalPerl.g:467:2: ( ( rule__RegexToken__Group__0 ) )
            {
            // InternalPerl.g:467:2: ( ( rule__RegexToken__Group__0 ) )
            // InternalPerl.g:468:3: ( rule__RegexToken__Group__0 )
            {
             before(grammarAccess.getRegexTokenAccess().getGroup()); 
            // InternalPerl.g:469:3: ( rule__RegexToken__Group__0 )
            // InternalPerl.g:469:4: rule__RegexToken__Group__0
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


    // $ANTLR start "entryRuleQuoteLikeToken"
    // InternalPerl.g:478:1: entryRuleQuoteLikeToken : ruleQuoteLikeToken EOF ;
    public final void entryRuleQuoteLikeToken() throws RecognitionException {
        try {
            // InternalPerl.g:479:1: ( ruleQuoteLikeToken EOF )
            // InternalPerl.g:480:1: ruleQuoteLikeToken EOF
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
    // InternalPerl.g:487:1: ruleQuoteLikeToken : ( ( rule__QuoteLikeToken__Alternatives ) ) ;
    public final void ruleQuoteLikeToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:491:2: ( ( ( rule__QuoteLikeToken__Alternatives ) ) )
            // InternalPerl.g:492:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            {
            // InternalPerl.g:492:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            // InternalPerl.g:493:3: ( rule__QuoteLikeToken__Alternatives )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getAlternatives()); 
            // InternalPerl.g:494:3: ( rule__QuoteLikeToken__Alternatives )
            // InternalPerl.g:494:4: rule__QuoteLikeToken__Alternatives
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
    // InternalPerl.g:503:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalPerl.g:504:1: ( ruleWord EOF )
            // InternalPerl.g:505:1: ruleWord EOF
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
    // InternalPerl.g:512:1: ruleWord : ( ruleKeyword ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:516:2: ( ( ruleKeyword ) )
            // InternalPerl.g:517:2: ( ruleKeyword )
            {
            // InternalPerl.g:517:2: ( ruleKeyword )
            // InternalPerl.g:518:3: ruleKeyword
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
    // InternalPerl.g:528:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalPerl.g:529:1: ( ruleKeyword EOF )
            // InternalPerl.g:530:1: ruleKeyword EOF
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
    // InternalPerl.g:537:1: ruleKeyword : ( ( rule__Keyword__Alternatives ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:541:2: ( ( ( rule__Keyword__Alternatives ) ) )
            // InternalPerl.g:542:2: ( ( rule__Keyword__Alternatives ) )
            {
            // InternalPerl.g:542:2: ( ( rule__Keyword__Alternatives ) )
            // InternalPerl.g:543:3: ( rule__Keyword__Alternatives )
            {
             before(grammarAccess.getKeywordAccess().getAlternatives()); 
            // InternalPerl.g:544:3: ( rule__Keyword__Alternatives )
            // InternalPerl.g:544:4: rule__Keyword__Alternatives
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
    // InternalPerl.g:553:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalPerl.g:554:1: ( ruleOperator EOF )
            // InternalPerl.g:555:1: ruleOperator EOF
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
    // InternalPerl.g:562:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:566:2: ( ( ( rule__Operator__Alternatives ) ) )
            // InternalPerl.g:567:2: ( ( rule__Operator__Alternatives ) )
            {
            // InternalPerl.g:567:2: ( ( rule__Operator__Alternatives ) )
            // InternalPerl.g:568:3: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // InternalPerl.g:569:3: ( rule__Operator__Alternatives )
            // InternalPerl.g:569:4: rule__Operator__Alternatives
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
    // InternalPerl.g:578:1: entryRuleFileTestOperator : ruleFileTestOperator EOF ;
    public final void entryRuleFileTestOperator() throws RecognitionException {
        try {
            // InternalPerl.g:579:1: ( ruleFileTestOperator EOF )
            // InternalPerl.g:580:1: ruleFileTestOperator EOF
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
    // InternalPerl.g:587:1: ruleFileTestOperator : ( ( rule__FileTestOperator__Alternatives ) ) ;
    public final void ruleFileTestOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:591:2: ( ( ( rule__FileTestOperator__Alternatives ) ) )
            // InternalPerl.g:592:2: ( ( rule__FileTestOperator__Alternatives ) )
            {
            // InternalPerl.g:592:2: ( ( rule__FileTestOperator__Alternatives ) )
            // InternalPerl.g:593:3: ( rule__FileTestOperator__Alternatives )
            {
             before(grammarAccess.getFileTestOperatorAccess().getAlternatives()); 
            // InternalPerl.g:594:3: ( rule__FileTestOperator__Alternatives )
            // InternalPerl.g:594:4: rule__FileTestOperator__Alternatives
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
    // InternalPerl.g:602:1: rule__Element__Alternatives : ( ( ruleNode ) | ( ruleToken ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:606:1: ( ( ruleNode ) | ( ruleToken ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==216) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==RULE_ID) ) {
                    alt1=1;
                }
                else if ( (LA1_1==EOF||(LA1_1>=RULE_STRING && LA1_1<=RULE_REGEX_MATCH)||(LA1_1>=RULE_WORDS_QUOTE_LIKE && LA1_1<=RULE_READLINE_QUOTE)||LA1_1==30||(LA1_1>=32 && LA1_1<=343)||LA1_1==347) ) {
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

                if ( (LA1_2==EOF||(LA1_2>=RULE_STRING && LA1_2<=RULE_REGEX_MATCH)||(LA1_2>=RULE_WORDS_QUOTE_LIKE && LA1_2<=RULE_READLINE_QUOTE)||LA1_2==30||(LA1_2>=32 && LA1_2<=343)||LA1_2==347) ) {
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
            else if ( (LA1_0==172) ) {
                int LA1_3 = input.LA(2);

                if ( (LA1_3==RULE_VERSION) ) {
                    alt1=1;
                }
                else if ( (LA1_3==EOF||(LA1_3>=RULE_STRING && LA1_3<=RULE_REGEX_MATCH)||(LA1_3>=RULE_WORDS_QUOTE_LIKE && LA1_3<=RULE_READLINE_QUOTE)||LA1_3==30||(LA1_3>=32 && LA1_3<=343)||LA1_3==347) ) {
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

                if ( ((LA1_4>=RULE_ID && LA1_4<=RULE_VERSION)) ) {
                    alt1=1;
                }
                else if ( (LA1_4==EOF||(LA1_4>=RULE_STRING && LA1_4<=RULE_REGEX_MATCH)||(LA1_4>=RULE_WORDS_QUOTE_LIKE && LA1_4<=RULE_READLINE_QUOTE)||LA1_4==30||(LA1_4>=32 && LA1_4<=343)||LA1_4==347) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 4, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==343) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_REGEX_MATCH)||(LA1_0>=RULE_WORDS_QUOTE_LIKE && LA1_0<=RULE_READLINE_QUOTE)||LA1_0==30||(LA1_0>=32 && LA1_0<=152)||(LA1_0>=154 && LA1_0<=171)||(LA1_0>=173 && LA1_0<=215)||(LA1_0>=217 && LA1_0<=242)||(LA1_0>=244 && LA1_0<=342)||LA1_0==347) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalPerl.g:607:2: ( ruleNode )
                    {
                    // InternalPerl.g:607:2: ( ruleNode )
                    // InternalPerl.g:608:3: ruleNode
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
                    // InternalPerl.g:613:2: ( ruleToken )
                    {
                    // InternalPerl.g:613:2: ( ruleToken )
                    // InternalPerl.g:614:3: ruleToken
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


    // $ANTLR start "rule__Node__Alternatives"
    // InternalPerl.g:623:1: rule__Node__Alternatives : ( ( ruleStatementNode ) | ( ruleStructureNode ) );
    public final void rule__Node__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:627:1: ( ( ruleStatementNode ) | ( ruleStructureNode ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==153||LA2_0==172||LA2_0==216||LA2_0==243) ) {
                alt2=1;
            }
            else if ( (LA2_0==343) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalPerl.g:628:2: ( ruleStatementNode )
                    {
                    // InternalPerl.g:628:2: ( ruleStatementNode )
                    // InternalPerl.g:629:3: ruleStatementNode
                    {
                     before(grammarAccess.getNodeAccess().getStatementNodeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleStatementNode();

                    state._fsp--;

                     after(grammarAccess.getNodeAccess().getStatementNodeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:634:2: ( ruleStructureNode )
                    {
                    // InternalPerl.g:634:2: ( ruleStructureNode )
                    // InternalPerl.g:635:3: ruleStructureNode
                    {
                     before(grammarAccess.getNodeAccess().getStructureNodeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleStructureNode();

                    state._fsp--;

                     after(grammarAccess.getNodeAccess().getStructureNodeParserRuleCall_1()); 

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


    // $ANTLR start "rule__StatementNode__Alternatives"
    // InternalPerl.g:644:1: rule__StatementNode__Alternatives : ( ( ruleBlockStatement ) | ( ruleExpressionStatement ) );
    public final void rule__StatementNode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:648:1: ( ( ruleBlockStatement ) | ( ruleExpressionStatement ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==216) ) {
                alt3=1;
            }
            else if ( (LA3_0==153||LA3_0==172||LA3_0==243) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalPerl.g:649:2: ( ruleBlockStatement )
                    {
                    // InternalPerl.g:649:2: ( ruleBlockStatement )
                    // InternalPerl.g:650:3: ruleBlockStatement
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
                    // InternalPerl.g:655:2: ( ruleExpressionStatement )
                    {
                    // InternalPerl.g:655:2: ( ruleExpressionStatement )
                    // InternalPerl.g:656:3: ruleExpressionStatement
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
    // InternalPerl.g:665:1: rule__ExpressionStatement__Alternatives_0 : ( ( rulePackageStatement ) | ( ruleIncludeStatement ) );
    public final void rule__ExpressionStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:669:1: ( ( rulePackageStatement ) | ( ruleIncludeStatement ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==153) ) {
                alt4=1;
            }
            else if ( (LA4_0==172||LA4_0==243) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalPerl.g:670:2: ( rulePackageStatement )
                    {
                    // InternalPerl.g:670:2: ( rulePackageStatement )
                    // InternalPerl.g:671:3: rulePackageStatement
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
                    // InternalPerl.g:676:2: ( ruleIncludeStatement )
                    {
                    // InternalPerl.g:676:2: ( ruleIncludeStatement )
                    // InternalPerl.g:677:3: ruleIncludeStatement
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
    // InternalPerl.g:686:1: rule__IncludeStatement__Alternatives : ( ( ruleRequireInclude ) | ( ruleUseInclude ) );
    public final void rule__IncludeStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:690:1: ( ( ruleRequireInclude ) | ( ruleUseInclude ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==172) ) {
                alt5=1;
            }
            else if ( (LA5_0==243) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalPerl.g:691:2: ( ruleRequireInclude )
                    {
                    // InternalPerl.g:691:2: ( ruleRequireInclude )
                    // InternalPerl.g:692:3: ruleRequireInclude
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
                    // InternalPerl.g:697:2: ( ruleUseInclude )
                    {
                    // InternalPerl.g:697:2: ( ruleUseInclude )
                    // InternalPerl.g:698:3: ruleUseInclude
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
    // InternalPerl.g:707:1: rule__UseInclude__Alternatives_2 : ( ( ( rule__UseInclude__VersionAssignment_2_0 ) ) | ( ( rule__UseInclude__Group_2_1__0 ) ) );
    public final void rule__UseInclude__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:711:1: ( ( ( rule__UseInclude__VersionAssignment_2_0 ) ) | ( ( rule__UseInclude__Group_2_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_VERSION) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalPerl.g:712:2: ( ( rule__UseInclude__VersionAssignment_2_0 ) )
                    {
                    // InternalPerl.g:712:2: ( ( rule__UseInclude__VersionAssignment_2_0 ) )
                    // InternalPerl.g:713:3: ( rule__UseInclude__VersionAssignment_2_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getVersionAssignment_2_0()); 
                    // InternalPerl.g:714:3: ( rule__UseInclude__VersionAssignment_2_0 )
                    // InternalPerl.g:714:4: rule__UseInclude__VersionAssignment_2_0
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
                    // InternalPerl.g:718:2: ( ( rule__UseInclude__Group_2_1__0 ) )
                    {
                    // InternalPerl.g:718:2: ( ( rule__UseInclude__Group_2_1__0 ) )
                    // InternalPerl.g:719:3: ( rule__UseInclude__Group_2_1__0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getGroup_2_1()); 
                    // InternalPerl.g:720:3: ( rule__UseInclude__Group_2_1__0 )
                    // InternalPerl.g:720:4: rule__UseInclude__Group_2_1__0
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
    // InternalPerl.g:728:1: rule__UseInclude__Alternatives_2_1_1 : ( ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) ) | ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) ) );
    public final void rule__UseInclude__Alternatives_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:732:1: ( ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) ) | ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_LITERAL)) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_WORDS_QUOTE_LIKE) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalPerl.g:733:2: ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) )
                    {
                    // InternalPerl.g:733:2: ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) )
                    // InternalPerl.g:734:3: ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getStringArgumentAssignment_2_1_1_0()); 
                    // InternalPerl.g:735:3: ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 )
                    // InternalPerl.g:735:4: rule__UseInclude__StringArgumentAssignment_2_1_1_0
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
                    // InternalPerl.g:739:2: ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) )
                    {
                    // InternalPerl.g:739:2: ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) )
                    // InternalPerl.g:740:3: ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getQwArgumentAssignment_2_1_1_1()); 
                    // InternalPerl.g:741:3: ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 )
                    // InternalPerl.g:741:4: rule__UseInclude__QwArgumentAssignment_2_1_1_1
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
    // InternalPerl.g:749:1: rule__SubStatement__Alternatives_4 : ( ( ';' ) | ( ( rule__SubStatement__BlockAssignment_4_1 ) ) );
    public final void rule__SubStatement__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:753:1: ( ( ';' ) | ( ( rule__SubStatement__BlockAssignment_4_1 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==28) ) {
                alt8=1;
            }
            else if ( (LA8_0==343) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalPerl.g:754:2: ( ';' )
                    {
                    // InternalPerl.g:754:2: ( ';' )
                    // InternalPerl.g:755:3: ';'
                    {
                     before(grammarAccess.getSubStatementAccess().getSemicolonKeyword_4_0()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getSubStatementAccess().getSemicolonKeyword_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:760:2: ( ( rule__SubStatement__BlockAssignment_4_1 ) )
                    {
                    // InternalPerl.g:760:2: ( ( rule__SubStatement__BlockAssignment_4_1 ) )
                    // InternalPerl.g:761:3: ( rule__SubStatement__BlockAssignment_4_1 )
                    {
                     before(grammarAccess.getSubStatementAccess().getBlockAssignment_4_1()); 
                    // InternalPerl.g:762:3: ( rule__SubStatement__BlockAssignment_4_1 )
                    // InternalPerl.g:762:4: rule__SubStatement__BlockAssignment_4_1
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
    // InternalPerl.g:770:1: rule__Prototype__Alternatives_1 : ( ( '$' ) | ( '%' ) | ( '@' ) | ( '&' ) | ( ';' ) );
    public final void rule__Prototype__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:774:1: ( ( '$' ) | ( '%' ) | ( '@' ) | ( '&' ) | ( ';' ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt9=1;
                }
                break;
            case 30:
                {
                alt9=2;
                }
                break;
            case 31:
                {
                alt9=3;
                }
                break;
            case 32:
                {
                alt9=4;
                }
                break;
            case 28:
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalPerl.g:775:2: ( '$' )
                    {
                    // InternalPerl.g:775:2: ( '$' )
                    // InternalPerl.g:776:3: '$'
                    {
                     before(grammarAccess.getPrototypeAccess().getDollarSignKeyword_1_0()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getDollarSignKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:781:2: ( '%' )
                    {
                    // InternalPerl.g:781:2: ( '%' )
                    // InternalPerl.g:782:3: '%'
                    {
                     before(grammarAccess.getPrototypeAccess().getPercentSignKeyword_1_1()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getPercentSignKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:787:2: ( '@' )
                    {
                    // InternalPerl.g:787:2: ( '@' )
                    // InternalPerl.g:788:3: '@'
                    {
                     before(grammarAccess.getPrototypeAccess().getCommercialAtKeyword_1_2()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getCommercialAtKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:793:2: ( '&' )
                    {
                    // InternalPerl.g:793:2: ( '&' )
                    // InternalPerl.g:794:3: '&'
                    {
                     before(grammarAccess.getPrototypeAccess().getAmpersandKeyword_1_3()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getAmpersandKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:799:2: ( ';' )
                    {
                    // InternalPerl.g:799:2: ( ';' )
                    // InternalPerl.g:800:3: ';'
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
    // InternalPerl.g:809:1: rule__Token__Alternatives : ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ruleQuoteToken ) | ( ruleRegexToken ) | ( ( rule__Token__Group_9__0 ) ) | ( ( rule__Token__Group_10__0 ) ) );
    public final void rule__Token__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:813:1: ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ruleQuoteToken ) | ( ruleRegexToken ) | ( ( rule__Token__Group_9__0 ) ) | ( ( rule__Token__Group_10__0 ) ) )
            int alt10=11;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_POD) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_NUMBER) ) {
                alt10=2;
            }
            else if ( ((LA10_0>=33 && LA10_0<=254)) ) {
                alt10=3;
            }
            else if ( (LA10_0==RULE_SYMBOL) ) {
                alt10=4;
            }
            else if ( (LA10_0==RULE_WORDS_QUOTE_LIKE||(LA10_0>=RULE_BACKTICK_STRING && LA10_0<=RULE_READLINE_QUOTE)) ) {
                alt10=5;
            }
            else if ( ((LA10_0>=316 && LA10_0<=342)) ) {
                alt10=6;
            }
            else if ( (LA10_0==30||LA10_0==32||(LA10_0>=255 && LA10_0<=315)||LA10_0==347) ) {
                alt10=7;
            }
            else if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_LITERAL)) ) {
                alt10=8;
            }
            else if ( ((LA10_0>=RULE_REGEX_SUBSTITUTE && LA10_0<=RULE_REGEX_MATCH)) ) {
                alt10=9;
            }
            else if ( (LA10_0==RULE_DATA) ) {
                alt10=10;
            }
            else if ( (LA10_0==RULE_END) ) {
                alt10=11;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalPerl.g:814:2: ( ( rule__Token__Group_0__0 ) )
                    {
                    // InternalPerl.g:814:2: ( ( rule__Token__Group_0__0 ) )
                    // InternalPerl.g:815:3: ( rule__Token__Group_0__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_0()); 
                    // InternalPerl.g:816:3: ( rule__Token__Group_0__0 )
                    // InternalPerl.g:816:4: rule__Token__Group_0__0
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
                    // InternalPerl.g:820:2: ( ( rule__Token__Group_1__0 ) )
                    {
                    // InternalPerl.g:820:2: ( ( rule__Token__Group_1__0 ) )
                    // InternalPerl.g:821:3: ( rule__Token__Group_1__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_1()); 
                    // InternalPerl.g:822:3: ( rule__Token__Group_1__0 )
                    // InternalPerl.g:822:4: rule__Token__Group_1__0
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
                    // InternalPerl.g:826:2: ( ( rule__Token__Group_2__0 ) )
                    {
                    // InternalPerl.g:826:2: ( ( rule__Token__Group_2__0 ) )
                    // InternalPerl.g:827:3: ( rule__Token__Group_2__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_2()); 
                    // InternalPerl.g:828:3: ( rule__Token__Group_2__0 )
                    // InternalPerl.g:828:4: rule__Token__Group_2__0
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
                    // InternalPerl.g:832:2: ( ( rule__Token__Group_3__0 ) )
                    {
                    // InternalPerl.g:832:2: ( ( rule__Token__Group_3__0 ) )
                    // InternalPerl.g:833:3: ( rule__Token__Group_3__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_3()); 
                    // InternalPerl.g:834:3: ( rule__Token__Group_3__0 )
                    // InternalPerl.g:834:4: rule__Token__Group_3__0
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
                    // InternalPerl.g:838:2: ( ruleQuoteLikeToken )
                    {
                    // InternalPerl.g:838:2: ( ruleQuoteLikeToken )
                    // InternalPerl.g:839:3: ruleQuoteLikeToken
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
                    // InternalPerl.g:844:2: ( ( rule__Token__Group_5__0 ) )
                    {
                    // InternalPerl.g:844:2: ( ( rule__Token__Group_5__0 ) )
                    // InternalPerl.g:845:3: ( rule__Token__Group_5__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_5()); 
                    // InternalPerl.g:846:3: ( rule__Token__Group_5__0 )
                    // InternalPerl.g:846:4: rule__Token__Group_5__0
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
                    // InternalPerl.g:850:2: ( ( rule__Token__Group_6__0 ) )
                    {
                    // InternalPerl.g:850:2: ( ( rule__Token__Group_6__0 ) )
                    // InternalPerl.g:851:3: ( rule__Token__Group_6__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_6()); 
                    // InternalPerl.g:852:3: ( rule__Token__Group_6__0 )
                    // InternalPerl.g:852:4: rule__Token__Group_6__0
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
                    // InternalPerl.g:856:2: ( ruleQuoteToken )
                    {
                    // InternalPerl.g:856:2: ( ruleQuoteToken )
                    // InternalPerl.g:857:3: ruleQuoteToken
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
                    // InternalPerl.g:862:2: ( ruleRegexToken )
                    {
                    // InternalPerl.g:862:2: ( ruleRegexToken )
                    // InternalPerl.g:863:3: ruleRegexToken
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
                    // InternalPerl.g:868:2: ( ( rule__Token__Group_9__0 ) )
                    {
                    // InternalPerl.g:868:2: ( ( rule__Token__Group_9__0 ) )
                    // InternalPerl.g:869:3: ( rule__Token__Group_9__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_9()); 
                    // InternalPerl.g:870:3: ( rule__Token__Group_9__0 )
                    // InternalPerl.g:870:4: rule__Token__Group_9__0
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
                    // InternalPerl.g:874:2: ( ( rule__Token__Group_10__0 ) )
                    {
                    // InternalPerl.g:874:2: ( ( rule__Token__Group_10__0 ) )
                    // InternalPerl.g:875:3: ( rule__Token__Group_10__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_10()); 
                    // InternalPerl.g:876:3: ( rule__Token__Group_10__0 )
                    // InternalPerl.g:876:4: rule__Token__Group_10__0
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


    // $ANTLR start "rule__QuoteToken__ContentAlternatives_1_0"
    // InternalPerl.g:884:1: rule__QuoteToken__ContentAlternatives_1_0 : ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) );
    public final void rule__QuoteToken__ContentAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:888:1: ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) )
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
                    // InternalPerl.g:889:2: ( RULE_STRING )
                    {
                    // InternalPerl.g:889:2: ( RULE_STRING )
                    // InternalPerl.g:890:3: RULE_STRING
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:895:2: ( RULE_INTERPOLATE )
                    {
                    // InternalPerl.g:895:2: ( RULE_INTERPOLATE )
                    // InternalPerl.g:896:3: RULE_INTERPOLATE
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 
                    match(input,RULE_INTERPOLATE,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:901:2: ( RULE_LITERAL )
                    {
                    // InternalPerl.g:901:2: ( RULE_LITERAL )
                    // InternalPerl.g:902:3: RULE_LITERAL
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


    // $ANTLR start "rule__RegexToken__ContentAlternatives_1_0"
    // InternalPerl.g:911:1: rule__RegexToken__ContentAlternatives_1_0 : ( ( RULE_REGEX_SUBSTITUTE ) | ( RULE_REGEX_TRANSLITERATE ) | ( RULE_REGEX_MATCH ) );
    public final void rule__RegexToken__ContentAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:915:1: ( ( RULE_REGEX_SUBSTITUTE ) | ( RULE_REGEX_TRANSLITERATE ) | ( RULE_REGEX_MATCH ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case RULE_REGEX_SUBSTITUTE:
                {
                alt12=1;
                }
                break;
            case RULE_REGEX_TRANSLITERATE:
                {
                alt12=2;
                }
                break;
            case RULE_REGEX_MATCH:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalPerl.g:916:2: ( RULE_REGEX_SUBSTITUTE )
                    {
                    // InternalPerl.g:916:2: ( RULE_REGEX_SUBSTITUTE )
                    // InternalPerl.g:917:3: RULE_REGEX_SUBSTITUTE
                    {
                     before(grammarAccess.getRegexTokenAccess().getContentREGEX_SUBSTITUTETerminalRuleCall_1_0_0()); 
                    match(input,RULE_REGEX_SUBSTITUTE,FOLLOW_2); 
                     after(grammarAccess.getRegexTokenAccess().getContentREGEX_SUBSTITUTETerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:922:2: ( RULE_REGEX_TRANSLITERATE )
                    {
                    // InternalPerl.g:922:2: ( RULE_REGEX_TRANSLITERATE )
                    // InternalPerl.g:923:3: RULE_REGEX_TRANSLITERATE
                    {
                     before(grammarAccess.getRegexTokenAccess().getContentREGEX_TRANSLITERATETerminalRuleCall_1_0_1()); 
                    match(input,RULE_REGEX_TRANSLITERATE,FOLLOW_2); 
                     after(grammarAccess.getRegexTokenAccess().getContentREGEX_TRANSLITERATETerminalRuleCall_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:928:2: ( RULE_REGEX_MATCH )
                    {
                    // InternalPerl.g:928:2: ( RULE_REGEX_MATCH )
                    // InternalPerl.g:929:3: RULE_REGEX_MATCH
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


    // $ANTLR start "rule__QuoteLikeToken__Alternatives"
    // InternalPerl.g:938:1: rule__QuoteLikeToken__Alternatives : ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) );
    public final void rule__QuoteLikeToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:942:1: ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case RULE_BACKTICK_STRING:
                {
                alt13=1;
                }
                break;
            case RULE_WORDS_QUOTE_LIKE:
                {
                alt13=2;
                }
                break;
            case RULE_COMMAND_QUOTE_LIKE:
                {
                alt13=3;
                }
                break;
            case RULE_REGEX_QUOTE:
                {
                alt13=4;
                }
                break;
            case RULE_READLINE_QUOTE:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalPerl.g:943:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    {
                    // InternalPerl.g:943:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    // InternalPerl.g:944:3: ( rule__QuoteLikeToken__Group_0__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_0()); 
                    // InternalPerl.g:945:3: ( rule__QuoteLikeToken__Group_0__0 )
                    // InternalPerl.g:945:4: rule__QuoteLikeToken__Group_0__0
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
                    // InternalPerl.g:949:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    {
                    // InternalPerl.g:949:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    // InternalPerl.g:950:3: ( rule__QuoteLikeToken__Group_1__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_1()); 
                    // InternalPerl.g:951:3: ( rule__QuoteLikeToken__Group_1__0 )
                    // InternalPerl.g:951:4: rule__QuoteLikeToken__Group_1__0
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
                    // InternalPerl.g:955:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    {
                    // InternalPerl.g:955:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    // InternalPerl.g:956:3: ( rule__QuoteLikeToken__Group_2__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_2()); 
                    // InternalPerl.g:957:3: ( rule__QuoteLikeToken__Group_2__0 )
                    // InternalPerl.g:957:4: rule__QuoteLikeToken__Group_2__0
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
                    // InternalPerl.g:961:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    {
                    // InternalPerl.g:961:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    // InternalPerl.g:962:3: ( rule__QuoteLikeToken__Group_3__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_3()); 
                    // InternalPerl.g:963:3: ( rule__QuoteLikeToken__Group_3__0 )
                    // InternalPerl.g:963:4: rule__QuoteLikeToken__Group_3__0
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
                    // InternalPerl.g:967:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    {
                    // InternalPerl.g:967:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    // InternalPerl.g:968:3: ( rule__QuoteLikeToken__Group_4__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_4()); 
                    // InternalPerl.g:969:3: ( rule__QuoteLikeToken__Group_4__0 )
                    // InternalPerl.g:969:4: rule__QuoteLikeToken__Group_4__0
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
    // InternalPerl.g:977:1: rule__Keyword__Alternatives : ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) );
    public final void rule__Keyword__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:981:1: ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) )
            int alt14=222;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt14=1;
                }
                break;
            case 34:
                {
                alt14=2;
                }
                break;
            case 35:
                {
                alt14=3;
                }
                break;
            case 36:
                {
                alt14=4;
                }
                break;
            case 37:
                {
                alt14=5;
                }
                break;
            case 38:
                {
                alt14=6;
                }
                break;
            case 39:
                {
                alt14=7;
                }
                break;
            case 40:
                {
                alt14=8;
                }
                break;
            case 41:
                {
                alt14=9;
                }
                break;
            case 42:
                {
                alt14=10;
                }
                break;
            case 43:
                {
                alt14=11;
                }
                break;
            case 44:
                {
                alt14=12;
                }
                break;
            case 45:
                {
                alt14=13;
                }
                break;
            case 46:
                {
                alt14=14;
                }
                break;
            case 47:
                {
                alt14=15;
                }
                break;
            case 48:
                {
                alt14=16;
                }
                break;
            case 49:
                {
                alt14=17;
                }
                break;
            case 50:
                {
                alt14=18;
                }
                break;
            case 51:
                {
                alt14=19;
                }
                break;
            case 52:
                {
                alt14=20;
                }
                break;
            case 53:
                {
                alt14=21;
                }
                break;
            case 54:
                {
                alt14=22;
                }
                break;
            case 55:
                {
                alt14=23;
                }
                break;
            case 56:
                {
                alt14=24;
                }
                break;
            case 57:
                {
                alt14=25;
                }
                break;
            case 58:
                {
                alt14=26;
                }
                break;
            case 59:
                {
                alt14=27;
                }
                break;
            case 60:
                {
                alt14=28;
                }
                break;
            case 61:
                {
                alt14=29;
                }
                break;
            case 62:
                {
                alt14=30;
                }
                break;
            case 63:
                {
                alt14=31;
                }
                break;
            case 64:
                {
                alt14=32;
                }
                break;
            case 65:
                {
                alt14=33;
                }
                break;
            case 66:
                {
                alt14=34;
                }
                break;
            case 67:
                {
                alt14=35;
                }
                break;
            case 68:
                {
                alt14=36;
                }
                break;
            case 69:
                {
                alt14=37;
                }
                break;
            case 70:
                {
                alt14=38;
                }
                break;
            case 71:
                {
                alt14=39;
                }
                break;
            case 72:
                {
                alt14=40;
                }
                break;
            case 73:
                {
                alt14=41;
                }
                break;
            case 74:
                {
                alt14=42;
                }
                break;
            case 75:
                {
                alt14=43;
                }
                break;
            case 76:
                {
                alt14=44;
                }
                break;
            case 77:
                {
                alt14=45;
                }
                break;
            case 78:
                {
                alt14=46;
                }
                break;
            case 79:
                {
                alt14=47;
                }
                break;
            case 80:
                {
                alt14=48;
                }
                break;
            case 81:
                {
                alt14=49;
                }
                break;
            case 82:
                {
                alt14=50;
                }
                break;
            case 83:
                {
                alt14=51;
                }
                break;
            case 84:
                {
                alt14=52;
                }
                break;
            case 85:
                {
                alt14=53;
                }
                break;
            case 86:
                {
                alt14=54;
                }
                break;
            case 87:
                {
                alt14=55;
                }
                break;
            case 88:
                {
                alt14=56;
                }
                break;
            case 89:
                {
                alt14=57;
                }
                break;
            case 90:
                {
                alt14=58;
                }
                break;
            case 91:
                {
                alt14=59;
                }
                break;
            case 92:
                {
                alt14=60;
                }
                break;
            case 93:
                {
                alt14=61;
                }
                break;
            case 94:
                {
                alt14=62;
                }
                break;
            case 95:
                {
                alt14=63;
                }
                break;
            case 96:
                {
                alt14=64;
                }
                break;
            case 97:
                {
                alt14=65;
                }
                break;
            case 98:
                {
                alt14=66;
                }
                break;
            case 99:
                {
                alt14=67;
                }
                break;
            case 100:
                {
                alt14=68;
                }
                break;
            case 101:
                {
                alt14=69;
                }
                break;
            case 102:
                {
                alt14=70;
                }
                break;
            case 103:
                {
                alt14=71;
                }
                break;
            case 104:
                {
                alt14=72;
                }
                break;
            case 105:
                {
                alt14=73;
                }
                break;
            case 106:
                {
                alt14=74;
                }
                break;
            case 107:
                {
                alt14=75;
                }
                break;
            case 108:
                {
                alt14=76;
                }
                break;
            case 109:
                {
                alt14=77;
                }
                break;
            case 110:
                {
                alt14=78;
                }
                break;
            case 111:
                {
                alt14=79;
                }
                break;
            case 112:
                {
                alt14=80;
                }
                break;
            case 113:
                {
                alt14=81;
                }
                break;
            case 114:
                {
                alt14=82;
                }
                break;
            case 115:
                {
                alt14=83;
                }
                break;
            case 116:
                {
                alt14=84;
                }
                break;
            case 117:
                {
                alt14=85;
                }
                break;
            case 118:
                {
                alt14=86;
                }
                break;
            case 119:
                {
                alt14=87;
                }
                break;
            case 120:
                {
                alt14=88;
                }
                break;
            case 121:
                {
                alt14=89;
                }
                break;
            case 122:
                {
                alt14=90;
                }
                break;
            case 123:
                {
                alt14=91;
                }
                break;
            case 124:
                {
                alt14=92;
                }
                break;
            case 125:
                {
                alt14=93;
                }
                break;
            case 126:
                {
                alt14=94;
                }
                break;
            case 127:
                {
                alt14=95;
                }
                break;
            case 128:
                {
                alt14=96;
                }
                break;
            case 129:
                {
                alt14=97;
                }
                break;
            case 130:
                {
                alt14=98;
                }
                break;
            case 131:
                {
                alt14=99;
                }
                break;
            case 132:
                {
                alt14=100;
                }
                break;
            case 133:
                {
                alt14=101;
                }
                break;
            case 134:
                {
                alt14=102;
                }
                break;
            case 135:
                {
                alt14=103;
                }
                break;
            case 136:
                {
                alt14=104;
                }
                break;
            case 137:
                {
                alt14=105;
                }
                break;
            case 138:
                {
                alt14=106;
                }
                break;
            case 139:
                {
                alt14=107;
                }
                break;
            case 140:
                {
                alt14=108;
                }
                break;
            case 141:
                {
                alt14=109;
                }
                break;
            case 142:
                {
                alt14=110;
                }
                break;
            case 143:
                {
                alt14=111;
                }
                break;
            case 144:
                {
                alt14=112;
                }
                break;
            case 145:
                {
                alt14=113;
                }
                break;
            case 146:
                {
                alt14=114;
                }
                break;
            case 147:
                {
                alt14=115;
                }
                break;
            case 148:
                {
                alt14=116;
                }
                break;
            case 149:
                {
                alt14=117;
                }
                break;
            case 150:
                {
                alt14=118;
                }
                break;
            case 151:
                {
                alt14=119;
                }
                break;
            case 152:
                {
                alt14=120;
                }
                break;
            case 153:
                {
                alt14=121;
                }
                break;
            case 154:
                {
                alt14=122;
                }
                break;
            case 155:
                {
                alt14=123;
                }
                break;
            case 156:
                {
                alt14=124;
                }
                break;
            case 157:
                {
                alt14=125;
                }
                break;
            case 158:
                {
                alt14=126;
                }
                break;
            case 159:
                {
                alt14=127;
                }
                break;
            case 160:
                {
                alt14=128;
                }
                break;
            case 161:
                {
                alt14=129;
                }
                break;
            case 162:
                {
                alt14=130;
                }
                break;
            case 163:
                {
                alt14=131;
                }
                break;
            case 164:
                {
                alt14=132;
                }
                break;
            case 165:
                {
                alt14=133;
                }
                break;
            case 166:
                {
                alt14=134;
                }
                break;
            case 167:
                {
                alt14=135;
                }
                break;
            case 168:
                {
                alt14=136;
                }
                break;
            case 169:
                {
                alt14=137;
                }
                break;
            case 170:
                {
                alt14=138;
                }
                break;
            case 171:
                {
                alt14=139;
                }
                break;
            case 172:
                {
                alt14=140;
                }
                break;
            case 173:
                {
                alt14=141;
                }
                break;
            case 174:
                {
                alt14=142;
                }
                break;
            case 175:
                {
                alt14=143;
                }
                break;
            case 176:
                {
                alt14=144;
                }
                break;
            case 177:
                {
                alt14=145;
                }
                break;
            case 178:
                {
                alt14=146;
                }
                break;
            case 179:
                {
                alt14=147;
                }
                break;
            case 180:
                {
                alt14=148;
                }
                break;
            case 181:
                {
                alt14=149;
                }
                break;
            case 182:
                {
                alt14=150;
                }
                break;
            case 183:
                {
                alt14=151;
                }
                break;
            case 184:
                {
                alt14=152;
                }
                break;
            case 185:
                {
                alt14=153;
                }
                break;
            case 186:
                {
                alt14=154;
                }
                break;
            case 187:
                {
                alt14=155;
                }
                break;
            case 188:
                {
                alt14=156;
                }
                break;
            case 189:
                {
                alt14=157;
                }
                break;
            case 190:
                {
                alt14=158;
                }
                break;
            case 191:
                {
                alt14=159;
                }
                break;
            case 192:
                {
                alt14=160;
                }
                break;
            case 193:
                {
                alt14=161;
                }
                break;
            case 194:
                {
                alt14=162;
                }
                break;
            case 195:
                {
                alt14=163;
                }
                break;
            case 196:
                {
                alt14=164;
                }
                break;
            case 197:
                {
                alt14=165;
                }
                break;
            case 198:
                {
                alt14=166;
                }
                break;
            case 199:
                {
                alt14=167;
                }
                break;
            case 200:
                {
                alt14=168;
                }
                break;
            case 201:
                {
                alt14=169;
                }
                break;
            case 202:
                {
                alt14=170;
                }
                break;
            case 203:
                {
                alt14=171;
                }
                break;
            case 204:
                {
                alt14=172;
                }
                break;
            case 205:
                {
                alt14=173;
                }
                break;
            case 206:
                {
                alt14=174;
                }
                break;
            case 207:
                {
                alt14=175;
                }
                break;
            case 208:
                {
                alt14=176;
                }
                break;
            case 209:
                {
                alt14=177;
                }
                break;
            case 210:
                {
                alt14=178;
                }
                break;
            case 211:
                {
                alt14=179;
                }
                break;
            case 212:
                {
                alt14=180;
                }
                break;
            case 213:
                {
                alt14=181;
                }
                break;
            case 214:
                {
                alt14=182;
                }
                break;
            case 215:
                {
                alt14=183;
                }
                break;
            case 216:
                {
                alt14=184;
                }
                break;
            case 217:
                {
                alt14=185;
                }
                break;
            case 218:
                {
                alt14=186;
                }
                break;
            case 219:
                {
                alt14=187;
                }
                break;
            case 220:
                {
                alt14=188;
                }
                break;
            case 221:
                {
                alt14=189;
                }
                break;
            case 222:
                {
                alt14=190;
                }
                break;
            case 223:
                {
                alt14=191;
                }
                break;
            case 224:
                {
                alt14=192;
                }
                break;
            case 225:
                {
                alt14=193;
                }
                break;
            case 226:
                {
                alt14=194;
                }
                break;
            case 227:
                {
                alt14=195;
                }
                break;
            case 228:
                {
                alt14=196;
                }
                break;
            case 229:
                {
                alt14=197;
                }
                break;
            case 230:
                {
                alt14=198;
                }
                break;
            case 231:
                {
                alt14=199;
                }
                break;
            case 232:
                {
                alt14=200;
                }
                break;
            case 233:
                {
                alt14=201;
                }
                break;
            case 234:
                {
                alt14=202;
                }
                break;
            case 235:
                {
                alt14=203;
                }
                break;
            case 236:
                {
                alt14=204;
                }
                break;
            case 237:
                {
                alt14=205;
                }
                break;
            case 238:
                {
                alt14=206;
                }
                break;
            case 239:
                {
                alt14=207;
                }
                break;
            case 240:
                {
                alt14=208;
                }
                break;
            case 241:
                {
                alt14=209;
                }
                break;
            case 242:
                {
                alt14=210;
                }
                break;
            case 243:
                {
                alt14=211;
                }
                break;
            case 244:
                {
                alt14=212;
                }
                break;
            case 245:
                {
                alt14=213;
                }
                break;
            case 246:
                {
                alt14=214;
                }
                break;
            case 247:
                {
                alt14=215;
                }
                break;
            case 248:
                {
                alt14=216;
                }
                break;
            case 249:
                {
                alt14=217;
                }
                break;
            case 250:
                {
                alt14=218;
                }
                break;
            case 251:
                {
                alt14=219;
                }
                break;
            case 252:
                {
                alt14=220;
                }
                break;
            case 253:
                {
                alt14=221;
                }
                break;
            case 254:
                {
                alt14=222;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalPerl.g:982:2: ( 'abs' )
                    {
                    // InternalPerl.g:982:2: ( 'abs' )
                    // InternalPerl.g:983:3: 'abs'
                    {
                     before(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:988:2: ( 'accept' )
                    {
                    // InternalPerl.g:988:2: ( 'accept' )
                    // InternalPerl.g:989:3: 'accept'
                    {
                     before(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:994:2: ( 'alarm' )
                    {
                    // InternalPerl.g:994:2: ( 'alarm' )
                    // InternalPerl.g:995:3: 'alarm'
                    {
                     before(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1000:2: ( 'atan2' )
                    {
                    // InternalPerl.g:1000:2: ( 'atan2' )
                    // InternalPerl.g:1001:3: 'atan2'
                    {
                     before(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:1006:2: ( 'bind' )
                    {
                    // InternalPerl.g:1006:2: ( 'bind' )
                    // InternalPerl.g:1007:3: 'bind'
                    {
                     before(grammarAccess.getKeywordAccess().getBindKeyword_4()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBindKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:1012:2: ( 'binmode' )
                    {
                    // InternalPerl.g:1012:2: ( 'binmode' )
                    // InternalPerl.g:1013:3: 'binmode'
                    {
                     before(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:1018:2: ( 'bless' )
                    {
                    // InternalPerl.g:1018:2: ( 'bless' )
                    // InternalPerl.g:1019:3: 'bless'
                    {
                     before(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:1024:2: ( 'break' )
                    {
                    // InternalPerl.g:1024:2: ( 'break' )
                    // InternalPerl.g:1025:3: 'break'
                    {
                     before(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:1030:2: ( 'caller' )
                    {
                    // InternalPerl.g:1030:2: ( 'caller' )
                    // InternalPerl.g:1031:3: 'caller'
                    {
                     before(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:1036:2: ( 'chdir' )
                    {
                    // InternalPerl.g:1036:2: ( 'chdir' )
                    // InternalPerl.g:1037:3: 'chdir'
                    {
                     before(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:1042:2: ( 'chmod' )
                    {
                    // InternalPerl.g:1042:2: ( 'chmod' )
                    // InternalPerl.g:1043:3: 'chmod'
                    {
                     before(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:1048:2: ( 'chomp' )
                    {
                    // InternalPerl.g:1048:2: ( 'chomp' )
                    // InternalPerl.g:1049:3: 'chomp'
                    {
                     before(grammarAccess.getKeywordAccess().getChompKeyword_11()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChompKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:1054:2: ( 'chop' )
                    {
                    // InternalPerl.g:1054:2: ( 'chop' )
                    // InternalPerl.g:1055:3: 'chop'
                    {
                     before(grammarAccess.getKeywordAccess().getChopKeyword_12()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChopKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:1060:2: ( 'chown' )
                    {
                    // InternalPerl.g:1060:2: ( 'chown' )
                    // InternalPerl.g:1061:3: 'chown'
                    {
                     before(grammarAccess.getKeywordAccess().getChownKeyword_13()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChownKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:1066:2: ( 'chr' )
                    {
                    // InternalPerl.g:1066:2: ( 'chr' )
                    // InternalPerl.g:1067:3: 'chr'
                    {
                     before(grammarAccess.getKeywordAccess().getChrKeyword_14()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:1072:2: ( 'chroot' )
                    {
                    // InternalPerl.g:1072:2: ( 'chroot' )
                    // InternalPerl.g:1073:3: 'chroot'
                    {
                     before(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:1078:2: ( 'close' )
                    {
                    // InternalPerl.g:1078:2: ( 'close' )
                    // InternalPerl.g:1079:3: 'close'
                    {
                     before(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:1084:2: ( 'closedir' )
                    {
                    // InternalPerl.g:1084:2: ( 'closedir' )
                    // InternalPerl.g:1085:3: 'closedir'
                    {
                     before(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:1090:2: ( 'connect' )
                    {
                    // InternalPerl.g:1090:2: ( 'connect' )
                    // InternalPerl.g:1091:3: 'connect'
                    {
                     before(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:1096:2: ( 'continue' )
                    {
                    // InternalPerl.g:1096:2: ( 'continue' )
                    // InternalPerl.g:1097:3: 'continue'
                    {
                     before(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:1102:2: ( 'cos' )
                    {
                    // InternalPerl.g:1102:2: ( 'cos' )
                    // InternalPerl.g:1103:3: 'cos'
                    {
                     before(grammarAccess.getKeywordAccess().getCosKeyword_20()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCosKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:1108:2: ( 'crypt' )
                    {
                    // InternalPerl.g:1108:2: ( 'crypt' )
                    // InternalPerl.g:1109:3: 'crypt'
                    {
                     before(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:1114:2: ( 'dbmclose' )
                    {
                    // InternalPerl.g:1114:2: ( 'dbmclose' )
                    // InternalPerl.g:1115:3: 'dbmclose'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:1120:2: ( 'dbmopen' )
                    {
                    // InternalPerl.g:1120:2: ( 'dbmopen' )
                    // InternalPerl.g:1121:3: 'dbmopen'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:1126:2: ( 'default' )
                    {
                    // InternalPerl.g:1126:2: ( 'default' )
                    // InternalPerl.g:1127:3: 'default'
                    {
                     before(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:1132:2: ( 'defined' )
                    {
                    // InternalPerl.g:1132:2: ( 'defined' )
                    // InternalPerl.g:1133:3: 'defined'
                    {
                     before(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:1138:2: ( 'delete' )
                    {
                    // InternalPerl.g:1138:2: ( 'delete' )
                    // InternalPerl.g:1139:3: 'delete'
                    {
                     before(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:1144:2: ( 'die' )
                    {
                    // InternalPerl.g:1144:2: ( 'die' )
                    // InternalPerl.g:1145:3: 'die'
                    {
                     before(grammarAccess.getKeywordAccess().getDieKeyword_27()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDieKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:1150:2: ( 'do' )
                    {
                    // InternalPerl.g:1150:2: ( 'do' )
                    // InternalPerl.g:1151:3: 'do'
                    {
                     before(grammarAccess.getKeywordAccess().getDoKeyword_28()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDoKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:1156:2: ( 'dump' )
                    {
                    // InternalPerl.g:1156:2: ( 'dump' )
                    // InternalPerl.g:1157:3: 'dump'
                    {
                     before(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:1162:2: ( 'each' )
                    {
                    // InternalPerl.g:1162:2: ( 'each' )
                    // InternalPerl.g:1163:3: 'each'
                    {
                     before(grammarAccess.getKeywordAccess().getEachKeyword_30()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEachKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:1168:2: ( 'else' )
                    {
                    // InternalPerl.g:1168:2: ( 'else' )
                    // InternalPerl.g:1169:3: 'else'
                    {
                     before(grammarAccess.getKeywordAccess().getElseKeyword_31()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElseKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:1174:2: ( 'elsif' )
                    {
                    // InternalPerl.g:1174:2: ( 'elsif' )
                    // InternalPerl.g:1175:3: 'elsif'
                    {
                     before(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:1180:2: ( 'endgrent' )
                    {
                    // InternalPerl.g:1180:2: ( 'endgrent' )
                    // InternalPerl.g:1181:3: 'endgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:1186:2: ( 'endhostent' )
                    {
                    // InternalPerl.g:1186:2: ( 'endhostent' )
                    // InternalPerl.g:1187:3: 'endhostent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:1192:2: ( 'endnetent' )
                    {
                    // InternalPerl.g:1192:2: ( 'endnetent' )
                    // InternalPerl.g:1193:3: 'endnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:1198:2: ( 'endprotoent' )
                    {
                    // InternalPerl.g:1198:2: ( 'endprotoent' )
                    // InternalPerl.g:1199:3: 'endprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:1204:2: ( 'endpwent' )
                    {
                    // InternalPerl.g:1204:2: ( 'endpwent' )
                    // InternalPerl.g:1205:3: 'endpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:1210:2: ( 'endservent' )
                    {
                    // InternalPerl.g:1210:2: ( 'endservent' )
                    // InternalPerl.g:1211:3: 'endservent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:1216:2: ( 'eof' )
                    {
                    // InternalPerl.g:1216:2: ( 'eof' )
                    // InternalPerl.g:1217:3: 'eof'
                    {
                     before(grammarAccess.getKeywordAccess().getEofKeyword_39()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEofKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:1222:2: ( 'eval' )
                    {
                    // InternalPerl.g:1222:2: ( 'eval' )
                    // InternalPerl.g:1223:3: 'eval'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:1228:2: ( 'evalbytes' )
                    {
                    // InternalPerl.g:1228:2: ( 'evalbytes' )
                    // InternalPerl.g:1229:3: 'evalbytes'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:1234:2: ( 'exec' )
                    {
                    // InternalPerl.g:1234:2: ( 'exec' )
                    // InternalPerl.g:1235:3: 'exec'
                    {
                     before(grammarAccess.getKeywordAccess().getExecKeyword_42()); 
                    match(input,75,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExecKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:1240:2: ( 'exists' )
                    {
                    // InternalPerl.g:1240:2: ( 'exists' )
                    // InternalPerl.g:1241:3: 'exists'
                    {
                     before(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 
                    match(input,76,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:1246:2: ( 'exit' )
                    {
                    // InternalPerl.g:1246:2: ( 'exit' )
                    // InternalPerl.g:1247:3: 'exit'
                    {
                     before(grammarAccess.getKeywordAccess().getExitKeyword_44()); 
                    match(input,77,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExitKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:1252:2: ( 'exp' )
                    {
                    // InternalPerl.g:1252:2: ( 'exp' )
                    // InternalPerl.g:1253:3: 'exp'
                    {
                     before(grammarAccess.getKeywordAccess().getExpKeyword_45()); 
                    match(input,78,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExpKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:1258:2: ( 'fc' )
                    {
                    // InternalPerl.g:1258:2: ( 'fc' )
                    // InternalPerl.g:1259:3: 'fc'
                    {
                     before(grammarAccess.getKeywordAccess().getFcKeyword_46()); 
                    match(input,79,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:1264:2: ( 'fcntl' )
                    {
                    // InternalPerl.g:1264:2: ( 'fcntl' )
                    // InternalPerl.g:1265:3: 'fcntl'
                    {
                     before(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 
                    match(input,80,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:1270:2: ( 'fileno' )
                    {
                    // InternalPerl.g:1270:2: ( 'fileno' )
                    // InternalPerl.g:1271:3: 'fileno'
                    {
                     before(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 
                    match(input,81,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:1276:2: ( 'flock' )
                    {
                    // InternalPerl.g:1276:2: ( 'flock' )
                    // InternalPerl.g:1277:3: 'flock'
                    {
                     before(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 
                    match(input,82,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:1282:2: ( 'for' )
                    {
                    // InternalPerl.g:1282:2: ( 'for' )
                    // InternalPerl.g:1283:3: 'for'
                    {
                     before(grammarAccess.getKeywordAccess().getForKeyword_50()); 
                    match(input,83,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:1288:2: ( 'foreach' )
                    {
                    // InternalPerl.g:1288:2: ( 'foreach' )
                    // InternalPerl.g:1289:3: 'foreach'
                    {
                     before(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 
                    match(input,84,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:1294:2: ( 'fork' )
                    {
                    // InternalPerl.g:1294:2: ( 'fork' )
                    // InternalPerl.g:1295:3: 'fork'
                    {
                     before(grammarAccess.getKeywordAccess().getForkKeyword_52()); 
                    match(input,85,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForkKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:1300:2: ( 'format' )
                    {
                    // InternalPerl.g:1300:2: ( 'format' )
                    // InternalPerl.g:1301:3: 'format'
                    {
                     before(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 
                    match(input,86,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:1306:2: ( 'formline' )
                    {
                    // InternalPerl.g:1306:2: ( 'formline' )
                    // InternalPerl.g:1307:3: 'formline'
                    {
                     before(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 
                    match(input,87,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:1312:2: ( 'getc' )
                    {
                    // InternalPerl.g:1312:2: ( 'getc' )
                    // InternalPerl.g:1313:3: 'getc'
                    {
                     before(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 
                    match(input,88,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:1318:2: ( 'getgrent' )
                    {
                    // InternalPerl.g:1318:2: ( 'getgrent' )
                    // InternalPerl.g:1319:3: 'getgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 
                    match(input,89,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:1324:2: ( 'getgrgid' )
                    {
                    // InternalPerl.g:1324:2: ( 'getgrgid' )
                    // InternalPerl.g:1325:3: 'getgrgid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 
                    match(input,90,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:1330:2: ( 'getgrnam' )
                    {
                    // InternalPerl.g:1330:2: ( 'getgrnam' )
                    // InternalPerl.g:1331:3: 'getgrnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 
                    match(input,91,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:1336:2: ( 'gethostbyaddr' )
                    {
                    // InternalPerl.g:1336:2: ( 'gethostbyaddr' )
                    // InternalPerl.g:1337:3: 'gethostbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 
                    match(input,92,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:1342:2: ( 'gethostbyname' )
                    {
                    // InternalPerl.g:1342:2: ( 'gethostbyname' )
                    // InternalPerl.g:1343:3: 'gethostbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 
                    match(input,93,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:1348:2: ( 'gethostent' )
                    {
                    // InternalPerl.g:1348:2: ( 'gethostent' )
                    // InternalPerl.g:1349:3: 'gethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 
                    match(input,94,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:1354:2: ( 'getlogin' )
                    {
                    // InternalPerl.g:1354:2: ( 'getlogin' )
                    // InternalPerl.g:1355:3: 'getlogin'
                    {
                     before(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 
                    match(input,95,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:1360:2: ( 'getnetbyaddr' )
                    {
                    // InternalPerl.g:1360:2: ( 'getnetbyaddr' )
                    // InternalPerl.g:1361:3: 'getnetbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 
                    match(input,96,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 

                    }


                    }
                    break;
                case 65 :
                    // InternalPerl.g:1366:2: ( 'getnetbyname' )
                    {
                    // InternalPerl.g:1366:2: ( 'getnetbyname' )
                    // InternalPerl.g:1367:3: 'getnetbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 
                    match(input,97,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 

                    }


                    }
                    break;
                case 66 :
                    // InternalPerl.g:1372:2: ( 'getnetent' )
                    {
                    // InternalPerl.g:1372:2: ( 'getnetent' )
                    // InternalPerl.g:1373:3: 'getnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 
                    match(input,98,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 

                    }


                    }
                    break;
                case 67 :
                    // InternalPerl.g:1378:2: ( 'getpeername' )
                    {
                    // InternalPerl.g:1378:2: ( 'getpeername' )
                    // InternalPerl.g:1379:3: 'getpeername'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 
                    match(input,99,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 

                    }


                    }
                    break;
                case 68 :
                    // InternalPerl.g:1384:2: ( 'getpgrp' )
                    {
                    // InternalPerl.g:1384:2: ( 'getpgrp' )
                    // InternalPerl.g:1385:3: 'getpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 
                    match(input,100,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 

                    }


                    }
                    break;
                case 69 :
                    // InternalPerl.g:1390:2: ( 'getppid' )
                    {
                    // InternalPerl.g:1390:2: ( 'getppid' )
                    // InternalPerl.g:1391:3: 'getppid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 
                    match(input,101,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 

                    }


                    }
                    break;
                case 70 :
                    // InternalPerl.g:1396:2: ( 'getpriority' )
                    {
                    // InternalPerl.g:1396:2: ( 'getpriority' )
                    // InternalPerl.g:1397:3: 'getpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 
                    match(input,102,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 

                    }


                    }
                    break;
                case 71 :
                    // InternalPerl.g:1402:2: ( 'getprotobyname' )
                    {
                    // InternalPerl.g:1402:2: ( 'getprotobyname' )
                    // InternalPerl.g:1403:3: 'getprotobyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 
                    match(input,103,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 

                    }


                    }
                    break;
                case 72 :
                    // InternalPerl.g:1408:2: ( 'getprotobynumber' )
                    {
                    // InternalPerl.g:1408:2: ( 'getprotobynumber' )
                    // InternalPerl.g:1409:3: 'getprotobynumber'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 
                    match(input,104,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 

                    }


                    }
                    break;
                case 73 :
                    // InternalPerl.g:1414:2: ( 'getprotoent' )
                    {
                    // InternalPerl.g:1414:2: ( 'getprotoent' )
                    // InternalPerl.g:1415:3: 'getprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 
                    match(input,105,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 

                    }


                    }
                    break;
                case 74 :
                    // InternalPerl.g:1420:2: ( 'getpwent' )
                    {
                    // InternalPerl.g:1420:2: ( 'getpwent' )
                    // InternalPerl.g:1421:3: 'getpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 
                    match(input,106,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 

                    }


                    }
                    break;
                case 75 :
                    // InternalPerl.g:1426:2: ( 'getpwnam' )
                    {
                    // InternalPerl.g:1426:2: ( 'getpwnam' )
                    // InternalPerl.g:1427:3: 'getpwnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 
                    match(input,107,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 

                    }


                    }
                    break;
                case 76 :
                    // InternalPerl.g:1432:2: ( 'getpwuid' )
                    {
                    // InternalPerl.g:1432:2: ( 'getpwuid' )
                    // InternalPerl.g:1433:3: 'getpwuid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 
                    match(input,108,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 

                    }


                    }
                    break;
                case 77 :
                    // InternalPerl.g:1438:2: ( 'getservbyname' )
                    {
                    // InternalPerl.g:1438:2: ( 'getservbyname' )
                    // InternalPerl.g:1439:3: 'getservbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 
                    match(input,109,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 

                    }


                    }
                    break;
                case 78 :
                    // InternalPerl.g:1444:2: ( 'getservbyport' )
                    {
                    // InternalPerl.g:1444:2: ( 'getservbyport' )
                    // InternalPerl.g:1445:3: 'getservbyport'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 
                    match(input,110,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 

                    }


                    }
                    break;
                case 79 :
                    // InternalPerl.g:1450:2: ( 'getservent' )
                    {
                    // InternalPerl.g:1450:2: ( 'getservent' )
                    // InternalPerl.g:1451:3: 'getservent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 
                    match(input,111,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 

                    }


                    }
                    break;
                case 80 :
                    // InternalPerl.g:1456:2: ( 'getsockname' )
                    {
                    // InternalPerl.g:1456:2: ( 'getsockname' )
                    // InternalPerl.g:1457:3: 'getsockname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 
                    match(input,112,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 

                    }


                    }
                    break;
                case 81 :
                    // InternalPerl.g:1462:2: ( 'getsockopt' )
                    {
                    // InternalPerl.g:1462:2: ( 'getsockopt' )
                    // InternalPerl.g:1463:3: 'getsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 
                    match(input,113,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 

                    }


                    }
                    break;
                case 82 :
                    // InternalPerl.g:1468:2: ( 'given' )
                    {
                    // InternalPerl.g:1468:2: ( 'given' )
                    // InternalPerl.g:1469:3: 'given'
                    {
                     before(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 
                    match(input,114,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 

                    }


                    }
                    break;
                case 83 :
                    // InternalPerl.g:1474:2: ( 'glob' )
                    {
                    // InternalPerl.g:1474:2: ( 'glob' )
                    // InternalPerl.g:1475:3: 'glob'
                    {
                     before(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 
                    match(input,115,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 

                    }


                    }
                    break;
                case 84 :
                    // InternalPerl.g:1480:2: ( 'gmtime' )
                    {
                    // InternalPerl.g:1480:2: ( 'gmtime' )
                    // InternalPerl.g:1481:3: 'gmtime'
                    {
                     before(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 
                    match(input,116,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 

                    }


                    }
                    break;
                case 85 :
                    // InternalPerl.g:1486:2: ( 'goto' )
                    {
                    // InternalPerl.g:1486:2: ( 'goto' )
                    // InternalPerl.g:1487:3: 'goto'
                    {
                     before(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 
                    match(input,117,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 

                    }


                    }
                    break;
                case 86 :
                    // InternalPerl.g:1492:2: ( 'grep' )
                    {
                    // InternalPerl.g:1492:2: ( 'grep' )
                    // InternalPerl.g:1493:3: 'grep'
                    {
                     before(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 
                    match(input,118,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 

                    }


                    }
                    break;
                case 87 :
                    // InternalPerl.g:1498:2: ( 'hex' )
                    {
                    // InternalPerl.g:1498:2: ( 'hex' )
                    // InternalPerl.g:1499:3: 'hex'
                    {
                     before(grammarAccess.getKeywordAccess().getHexKeyword_86()); 
                    match(input,119,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getHexKeyword_86()); 

                    }


                    }
                    break;
                case 88 :
                    // InternalPerl.g:1504:2: ( 'if' )
                    {
                    // InternalPerl.g:1504:2: ( 'if' )
                    // InternalPerl.g:1505:3: 'if'
                    {
                     before(grammarAccess.getKeywordAccess().getIfKeyword_87()); 
                    match(input,120,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIfKeyword_87()); 

                    }


                    }
                    break;
                case 89 :
                    // InternalPerl.g:1510:2: ( 'index' )
                    {
                    // InternalPerl.g:1510:2: ( 'index' )
                    // InternalPerl.g:1511:3: 'index'
                    {
                     before(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 
                    match(input,121,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 

                    }


                    }
                    break;
                case 90 :
                    // InternalPerl.g:1516:2: ( 'int' )
                    {
                    // InternalPerl.g:1516:2: ( 'int' )
                    // InternalPerl.g:1517:3: 'int'
                    {
                     before(grammarAccess.getKeywordAccess().getIntKeyword_89()); 
                    match(input,122,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIntKeyword_89()); 

                    }


                    }
                    break;
                case 91 :
                    // InternalPerl.g:1522:2: ( 'ioctl' )
                    {
                    // InternalPerl.g:1522:2: ( 'ioctl' )
                    // InternalPerl.g:1523:3: 'ioctl'
                    {
                     before(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 
                    match(input,123,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 

                    }


                    }
                    break;
                case 92 :
                    // InternalPerl.g:1528:2: ( 'join' )
                    {
                    // InternalPerl.g:1528:2: ( 'join' )
                    // InternalPerl.g:1529:3: 'join'
                    {
                     before(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 
                    match(input,124,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 

                    }


                    }
                    break;
                case 93 :
                    // InternalPerl.g:1534:2: ( 'keys' )
                    {
                    // InternalPerl.g:1534:2: ( 'keys' )
                    // InternalPerl.g:1535:3: 'keys'
                    {
                     before(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 
                    match(input,125,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 

                    }


                    }
                    break;
                case 94 :
                    // InternalPerl.g:1540:2: ( 'kill' )
                    {
                    // InternalPerl.g:1540:2: ( 'kill' )
                    // InternalPerl.g:1541:3: 'kill'
                    {
                     before(grammarAccess.getKeywordAccess().getKillKeyword_93()); 
                    match(input,126,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKillKeyword_93()); 

                    }


                    }
                    break;
                case 95 :
                    // InternalPerl.g:1546:2: ( 'last' )
                    {
                    // InternalPerl.g:1546:2: ( 'last' )
                    // InternalPerl.g:1547:3: 'last'
                    {
                     before(grammarAccess.getKeywordAccess().getLastKeyword_94()); 
                    match(input,127,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLastKeyword_94()); 

                    }


                    }
                    break;
                case 96 :
                    // InternalPerl.g:1552:2: ( 'lc' )
                    {
                    // InternalPerl.g:1552:2: ( 'lc' )
                    // InternalPerl.g:1553:3: 'lc'
                    {
                     before(grammarAccess.getKeywordAccess().getLcKeyword_95()); 
                    match(input,128,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcKeyword_95()); 

                    }


                    }
                    break;
                case 97 :
                    // InternalPerl.g:1558:2: ( 'lcfirst' )
                    {
                    // InternalPerl.g:1558:2: ( 'lcfirst' )
                    // InternalPerl.g:1559:3: 'lcfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 
                    match(input,129,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 

                    }


                    }
                    break;
                case 98 :
                    // InternalPerl.g:1564:2: ( 'length' )
                    {
                    // InternalPerl.g:1564:2: ( 'length' )
                    // InternalPerl.g:1565:3: 'length'
                    {
                     before(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 
                    match(input,130,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 

                    }


                    }
                    break;
                case 99 :
                    // InternalPerl.g:1570:2: ( 'link' )
                    {
                    // InternalPerl.g:1570:2: ( 'link' )
                    // InternalPerl.g:1571:3: 'link'
                    {
                     before(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 
                    match(input,131,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 

                    }


                    }
                    break;
                case 100 :
                    // InternalPerl.g:1576:2: ( 'listen' )
                    {
                    // InternalPerl.g:1576:2: ( 'listen' )
                    // InternalPerl.g:1577:3: 'listen'
                    {
                     before(grammarAccess.getKeywordAccess().getListenKeyword_99()); 
                    match(input,132,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getListenKeyword_99()); 

                    }


                    }
                    break;
                case 101 :
                    // InternalPerl.g:1582:2: ( 'local' )
                    {
                    // InternalPerl.g:1582:2: ( 'local' )
                    // InternalPerl.g:1583:3: 'local'
                    {
                     before(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 
                    match(input,133,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 

                    }


                    }
                    break;
                case 102 :
                    // InternalPerl.g:1588:2: ( 'localtime' )
                    {
                    // InternalPerl.g:1588:2: ( 'localtime' )
                    // InternalPerl.g:1589:3: 'localtime'
                    {
                     before(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 
                    match(input,134,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 

                    }


                    }
                    break;
                case 103 :
                    // InternalPerl.g:1594:2: ( 'lock' )
                    {
                    // InternalPerl.g:1594:2: ( 'lock' )
                    // InternalPerl.g:1595:3: 'lock'
                    {
                     before(grammarAccess.getKeywordAccess().getLockKeyword_102()); 
                    match(input,135,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLockKeyword_102()); 

                    }


                    }
                    break;
                case 104 :
                    // InternalPerl.g:1600:2: ( 'log' )
                    {
                    // InternalPerl.g:1600:2: ( 'log' )
                    // InternalPerl.g:1601:3: 'log'
                    {
                     before(grammarAccess.getKeywordAccess().getLogKeyword_103()); 
                    match(input,136,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLogKeyword_103()); 

                    }


                    }
                    break;
                case 105 :
                    // InternalPerl.g:1606:2: ( 'lstat' )
                    {
                    // InternalPerl.g:1606:2: ( 'lstat' )
                    // InternalPerl.g:1607:3: 'lstat'
                    {
                     before(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 
                    match(input,137,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 

                    }


                    }
                    break;
                case 106 :
                    // InternalPerl.g:1612:2: ( 'map' )
                    {
                    // InternalPerl.g:1612:2: ( 'map' )
                    // InternalPerl.g:1613:3: 'map'
                    {
                     before(grammarAccess.getKeywordAccess().getMapKeyword_105()); 
                    match(input,138,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMapKeyword_105()); 

                    }


                    }
                    break;
                case 107 :
                    // InternalPerl.g:1618:2: ( 'mkdir' )
                    {
                    // InternalPerl.g:1618:2: ( 'mkdir' )
                    // InternalPerl.g:1619:3: 'mkdir'
                    {
                     before(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 
                    match(input,139,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 

                    }


                    }
                    break;
                case 108 :
                    // InternalPerl.g:1624:2: ( 'msgctl' )
                    {
                    // InternalPerl.g:1624:2: ( 'msgctl' )
                    // InternalPerl.g:1625:3: 'msgctl'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 
                    match(input,140,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 

                    }


                    }
                    break;
                case 109 :
                    // InternalPerl.g:1630:2: ( 'msgget' )
                    {
                    // InternalPerl.g:1630:2: ( 'msgget' )
                    // InternalPerl.g:1631:3: 'msgget'
                    {
                     before(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 
                    match(input,141,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 

                    }


                    }
                    break;
                case 110 :
                    // InternalPerl.g:1636:2: ( 'msgrcv' )
                    {
                    // InternalPerl.g:1636:2: ( 'msgrcv' )
                    // InternalPerl.g:1637:3: 'msgrcv'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 
                    match(input,142,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 

                    }


                    }
                    break;
                case 111 :
                    // InternalPerl.g:1642:2: ( 'msgsnd' )
                    {
                    // InternalPerl.g:1642:2: ( 'msgsnd' )
                    // InternalPerl.g:1643:3: 'msgsnd'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 
                    match(input,143,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 

                    }


                    }
                    break;
                case 112 :
                    // InternalPerl.g:1648:2: ( 'my' )
                    {
                    // InternalPerl.g:1648:2: ( 'my' )
                    // InternalPerl.g:1649:3: 'my'
                    {
                     before(grammarAccess.getKeywordAccess().getMyKeyword_111()); 
                    match(input,144,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMyKeyword_111()); 

                    }


                    }
                    break;
                case 113 :
                    // InternalPerl.g:1654:2: ( 'next' )
                    {
                    // InternalPerl.g:1654:2: ( 'next' )
                    // InternalPerl.g:1655:3: 'next'
                    {
                     before(grammarAccess.getKeywordAccess().getNextKeyword_112()); 
                    match(input,145,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNextKeyword_112()); 

                    }


                    }
                    break;
                case 114 :
                    // InternalPerl.g:1660:2: ( 'no' )
                    {
                    // InternalPerl.g:1660:2: ( 'no' )
                    // InternalPerl.g:1661:3: 'no'
                    {
                     before(grammarAccess.getKeywordAccess().getNoKeyword_113()); 
                    match(input,146,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNoKeyword_113()); 

                    }


                    }
                    break;
                case 115 :
                    // InternalPerl.g:1666:2: ( 'oct' )
                    {
                    // InternalPerl.g:1666:2: ( 'oct' )
                    // InternalPerl.g:1667:3: 'oct'
                    {
                     before(grammarAccess.getKeywordAccess().getOctKeyword_114()); 
                    match(input,147,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOctKeyword_114()); 

                    }


                    }
                    break;
                case 116 :
                    // InternalPerl.g:1672:2: ( 'open' )
                    {
                    // InternalPerl.g:1672:2: ( 'open' )
                    // InternalPerl.g:1673:3: 'open'
                    {
                     before(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 
                    match(input,148,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 

                    }


                    }
                    break;
                case 117 :
                    // InternalPerl.g:1678:2: ( 'opendir' )
                    {
                    // InternalPerl.g:1678:2: ( 'opendir' )
                    // InternalPerl.g:1679:3: 'opendir'
                    {
                     before(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 
                    match(input,149,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 

                    }


                    }
                    break;
                case 118 :
                    // InternalPerl.g:1684:2: ( 'ord' )
                    {
                    // InternalPerl.g:1684:2: ( 'ord' )
                    // InternalPerl.g:1685:3: 'ord'
                    {
                     before(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 
                    match(input,150,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 

                    }


                    }
                    break;
                case 119 :
                    // InternalPerl.g:1690:2: ( 'our' )
                    {
                    // InternalPerl.g:1690:2: ( 'our' )
                    // InternalPerl.g:1691:3: 'our'
                    {
                     before(grammarAccess.getKeywordAccess().getOurKeyword_118()); 
                    match(input,151,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOurKeyword_118()); 

                    }


                    }
                    break;
                case 120 :
                    // InternalPerl.g:1696:2: ( 'pack' )
                    {
                    // InternalPerl.g:1696:2: ( 'pack' )
                    // InternalPerl.g:1697:3: 'pack'
                    {
                     before(grammarAccess.getKeywordAccess().getPackKeyword_119()); 
                    match(input,152,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackKeyword_119()); 

                    }


                    }
                    break;
                case 121 :
                    // InternalPerl.g:1702:2: ( 'package' )
                    {
                    // InternalPerl.g:1702:2: ( 'package' )
                    // InternalPerl.g:1703:3: 'package'
                    {
                     before(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 
                    match(input,153,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 

                    }


                    }
                    break;
                case 122 :
                    // InternalPerl.g:1708:2: ( 'pipe' )
                    {
                    // InternalPerl.g:1708:2: ( 'pipe' )
                    // InternalPerl.g:1709:3: 'pipe'
                    {
                     before(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 
                    match(input,154,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 

                    }


                    }
                    break;
                case 123 :
                    // InternalPerl.g:1714:2: ( 'pop' )
                    {
                    // InternalPerl.g:1714:2: ( 'pop' )
                    // InternalPerl.g:1715:3: 'pop'
                    {
                     before(grammarAccess.getKeywordAccess().getPopKeyword_122()); 
                    match(input,155,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPopKeyword_122()); 

                    }


                    }
                    break;
                case 124 :
                    // InternalPerl.g:1720:2: ( 'pos' )
                    {
                    // InternalPerl.g:1720:2: ( 'pos' )
                    // InternalPerl.g:1721:3: 'pos'
                    {
                     before(grammarAccess.getKeywordAccess().getPosKeyword_123()); 
                    match(input,156,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPosKeyword_123()); 

                    }


                    }
                    break;
                case 125 :
                    // InternalPerl.g:1726:2: ( 'print' )
                    {
                    // InternalPerl.g:1726:2: ( 'print' )
                    // InternalPerl.g:1727:3: 'print'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 
                    match(input,157,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 

                    }


                    }
                    break;
                case 126 :
                    // InternalPerl.g:1732:2: ( 'printf' )
                    {
                    // InternalPerl.g:1732:2: ( 'printf' )
                    // InternalPerl.g:1733:3: 'printf'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 
                    match(input,158,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 

                    }


                    }
                    break;
                case 127 :
                    // InternalPerl.g:1738:2: ( 'prototype' )
                    {
                    // InternalPerl.g:1738:2: ( 'prototype' )
                    // InternalPerl.g:1739:3: 'prototype'
                    {
                     before(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 
                    match(input,159,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 

                    }


                    }
                    break;
                case 128 :
                    // InternalPerl.g:1744:2: ( 'push' )
                    {
                    // InternalPerl.g:1744:2: ( 'push' )
                    // InternalPerl.g:1745:3: 'push'
                    {
                     before(grammarAccess.getKeywordAccess().getPushKeyword_127()); 
                    match(input,160,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPushKeyword_127()); 

                    }


                    }
                    break;
                case 129 :
                    // InternalPerl.g:1750:2: ( 'quotemeta' )
                    {
                    // InternalPerl.g:1750:2: ( 'quotemeta' )
                    // InternalPerl.g:1751:3: 'quotemeta'
                    {
                     before(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 
                    match(input,161,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 

                    }


                    }
                    break;
                case 130 :
                    // InternalPerl.g:1756:2: ( 'rand' )
                    {
                    // InternalPerl.g:1756:2: ( 'rand' )
                    // InternalPerl.g:1757:3: 'rand'
                    {
                     before(grammarAccess.getKeywordAccess().getRandKeyword_129()); 
                    match(input,162,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRandKeyword_129()); 

                    }


                    }
                    break;
                case 131 :
                    // InternalPerl.g:1762:2: ( 'read' )
                    {
                    // InternalPerl.g:1762:2: ( 'read' )
                    // InternalPerl.g:1763:3: 'read'
                    {
                     before(grammarAccess.getKeywordAccess().getReadKeyword_130()); 
                    match(input,163,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadKeyword_130()); 

                    }


                    }
                    break;
                case 132 :
                    // InternalPerl.g:1768:2: ( 'readdir' )
                    {
                    // InternalPerl.g:1768:2: ( 'readdir' )
                    // InternalPerl.g:1769:3: 'readdir'
                    {
                     before(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 
                    match(input,164,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 

                    }


                    }
                    break;
                case 133 :
                    // InternalPerl.g:1774:2: ( 'readline' )
                    {
                    // InternalPerl.g:1774:2: ( 'readline' )
                    // InternalPerl.g:1775:3: 'readline'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 
                    match(input,165,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 

                    }


                    }
                    break;
                case 134 :
                    // InternalPerl.g:1780:2: ( 'readlink' )
                    {
                    // InternalPerl.g:1780:2: ( 'readlink' )
                    // InternalPerl.g:1781:3: 'readlink'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 
                    match(input,166,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 

                    }


                    }
                    break;
                case 135 :
                    // InternalPerl.g:1786:2: ( 'readpipe' )
                    {
                    // InternalPerl.g:1786:2: ( 'readpipe' )
                    // InternalPerl.g:1787:3: 'readpipe'
                    {
                     before(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 
                    match(input,167,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 

                    }


                    }
                    break;
                case 136 :
                    // InternalPerl.g:1792:2: ( 'recv' )
                    {
                    // InternalPerl.g:1792:2: ( 'recv' )
                    // InternalPerl.g:1793:3: 'recv'
                    {
                     before(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 
                    match(input,168,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 

                    }


                    }
                    break;
                case 137 :
                    // InternalPerl.g:1798:2: ( 'redo' )
                    {
                    // InternalPerl.g:1798:2: ( 'redo' )
                    // InternalPerl.g:1799:3: 'redo'
                    {
                     before(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 
                    match(input,169,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 

                    }


                    }
                    break;
                case 138 :
                    // InternalPerl.g:1804:2: ( 'ref' )
                    {
                    // InternalPerl.g:1804:2: ( 'ref' )
                    // InternalPerl.g:1805:3: 'ref'
                    {
                     before(grammarAccess.getKeywordAccess().getRefKeyword_137()); 
                    match(input,170,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRefKeyword_137()); 

                    }


                    }
                    break;
                case 139 :
                    // InternalPerl.g:1810:2: ( 'rename' )
                    {
                    // InternalPerl.g:1810:2: ( 'rename' )
                    // InternalPerl.g:1811:3: 'rename'
                    {
                     before(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 
                    match(input,171,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 

                    }


                    }
                    break;
                case 140 :
                    // InternalPerl.g:1816:2: ( 'require' )
                    {
                    // InternalPerl.g:1816:2: ( 'require' )
                    // InternalPerl.g:1817:3: 'require'
                    {
                     before(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 
                    match(input,172,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 

                    }


                    }
                    break;
                case 141 :
                    // InternalPerl.g:1822:2: ( 'reset' )
                    {
                    // InternalPerl.g:1822:2: ( 'reset' )
                    // InternalPerl.g:1823:3: 'reset'
                    {
                     before(grammarAccess.getKeywordAccess().getResetKeyword_140()); 
                    match(input,173,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getResetKeyword_140()); 

                    }


                    }
                    break;
                case 142 :
                    // InternalPerl.g:1828:2: ( 'return' )
                    {
                    // InternalPerl.g:1828:2: ( 'return' )
                    // InternalPerl.g:1829:3: 'return'
                    {
                     before(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 
                    match(input,174,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 

                    }


                    }
                    break;
                case 143 :
                    // InternalPerl.g:1834:2: ( 'reverse' )
                    {
                    // InternalPerl.g:1834:2: ( 'reverse' )
                    // InternalPerl.g:1835:3: 'reverse'
                    {
                     before(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 
                    match(input,175,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 

                    }


                    }
                    break;
                case 144 :
                    // InternalPerl.g:1840:2: ( 'rewinddir' )
                    {
                    // InternalPerl.g:1840:2: ( 'rewinddir' )
                    // InternalPerl.g:1841:3: 'rewinddir'
                    {
                     before(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 
                    match(input,176,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 

                    }


                    }
                    break;
                case 145 :
                    // InternalPerl.g:1846:2: ( 'rindex' )
                    {
                    // InternalPerl.g:1846:2: ( 'rindex' )
                    // InternalPerl.g:1847:3: 'rindex'
                    {
                     before(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 
                    match(input,177,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 

                    }


                    }
                    break;
                case 146 :
                    // InternalPerl.g:1852:2: ( 'rmdir' )
                    {
                    // InternalPerl.g:1852:2: ( 'rmdir' )
                    // InternalPerl.g:1853:3: 'rmdir'
                    {
                     before(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 
                    match(input,178,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 

                    }


                    }
                    break;
                case 147 :
                    // InternalPerl.g:1858:2: ( 'say' )
                    {
                    // InternalPerl.g:1858:2: ( 'say' )
                    // InternalPerl.g:1859:3: 'say'
                    {
                     before(grammarAccess.getKeywordAccess().getSayKeyword_146()); 
                    match(input,179,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSayKeyword_146()); 

                    }


                    }
                    break;
                case 148 :
                    // InternalPerl.g:1864:2: ( 'scalar' )
                    {
                    // InternalPerl.g:1864:2: ( 'scalar' )
                    // InternalPerl.g:1865:3: 'scalar'
                    {
                     before(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 
                    match(input,180,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 

                    }


                    }
                    break;
                case 149 :
                    // InternalPerl.g:1870:2: ( 'seek' )
                    {
                    // InternalPerl.g:1870:2: ( 'seek' )
                    // InternalPerl.g:1871:3: 'seek'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 
                    match(input,181,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 

                    }


                    }
                    break;
                case 150 :
                    // InternalPerl.g:1876:2: ( 'seekdir' )
                    {
                    // InternalPerl.g:1876:2: ( 'seekdir' )
                    // InternalPerl.g:1877:3: 'seekdir'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 
                    match(input,182,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 

                    }


                    }
                    break;
                case 151 :
                    // InternalPerl.g:1882:2: ( 'select' )
                    {
                    // InternalPerl.g:1882:2: ( 'select' )
                    // InternalPerl.g:1883:3: 'select'
                    {
                     before(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 
                    match(input,183,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 

                    }


                    }
                    break;
                case 152 :
                    // InternalPerl.g:1888:2: ( 'semctl' )
                    {
                    // InternalPerl.g:1888:2: ( 'semctl' )
                    // InternalPerl.g:1889:3: 'semctl'
                    {
                     before(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 
                    match(input,184,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 

                    }


                    }
                    break;
                case 153 :
                    // InternalPerl.g:1894:2: ( 'semget' )
                    {
                    // InternalPerl.g:1894:2: ( 'semget' )
                    // InternalPerl.g:1895:3: 'semget'
                    {
                     before(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 
                    match(input,185,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 

                    }


                    }
                    break;
                case 154 :
                    // InternalPerl.g:1900:2: ( 'semop' )
                    {
                    // InternalPerl.g:1900:2: ( 'semop' )
                    // InternalPerl.g:1901:3: 'semop'
                    {
                     before(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 
                    match(input,186,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 

                    }


                    }
                    break;
                case 155 :
                    // InternalPerl.g:1906:2: ( 'send' )
                    {
                    // InternalPerl.g:1906:2: ( 'send' )
                    // InternalPerl.g:1907:3: 'send'
                    {
                     before(grammarAccess.getKeywordAccess().getSendKeyword_154()); 
                    match(input,187,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSendKeyword_154()); 

                    }


                    }
                    break;
                case 156 :
                    // InternalPerl.g:1912:2: ( 'setgrent' )
                    {
                    // InternalPerl.g:1912:2: ( 'setgrent' )
                    // InternalPerl.g:1913:3: 'setgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 
                    match(input,188,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 

                    }


                    }
                    break;
                case 157 :
                    // InternalPerl.g:1918:2: ( 'sethostent' )
                    {
                    // InternalPerl.g:1918:2: ( 'sethostent' )
                    // InternalPerl.g:1919:3: 'sethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 
                    match(input,189,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 

                    }


                    }
                    break;
                case 158 :
                    // InternalPerl.g:1924:2: ( 'setnetent' )
                    {
                    // InternalPerl.g:1924:2: ( 'setnetent' )
                    // InternalPerl.g:1925:3: 'setnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 
                    match(input,190,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 

                    }


                    }
                    break;
                case 159 :
                    // InternalPerl.g:1930:2: ( 'setpgrp' )
                    {
                    // InternalPerl.g:1930:2: ( 'setpgrp' )
                    // InternalPerl.g:1931:3: 'setpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 
                    match(input,191,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 

                    }


                    }
                    break;
                case 160 :
                    // InternalPerl.g:1936:2: ( 'setpriority' )
                    {
                    // InternalPerl.g:1936:2: ( 'setpriority' )
                    // InternalPerl.g:1937:3: 'setpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 
                    match(input,192,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 

                    }


                    }
                    break;
                case 161 :
                    // InternalPerl.g:1942:2: ( 'setprotoent' )
                    {
                    // InternalPerl.g:1942:2: ( 'setprotoent' )
                    // InternalPerl.g:1943:3: 'setprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 
                    match(input,193,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 

                    }


                    }
                    break;
                case 162 :
                    // InternalPerl.g:1948:2: ( 'setpwent' )
                    {
                    // InternalPerl.g:1948:2: ( 'setpwent' )
                    // InternalPerl.g:1949:3: 'setpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 
                    match(input,194,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 

                    }


                    }
                    break;
                case 163 :
                    // InternalPerl.g:1954:2: ( 'setservent' )
                    {
                    // InternalPerl.g:1954:2: ( 'setservent' )
                    // InternalPerl.g:1955:3: 'setservent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 
                    match(input,195,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 

                    }


                    }
                    break;
                case 164 :
                    // InternalPerl.g:1960:2: ( 'setsockopt' )
                    {
                    // InternalPerl.g:1960:2: ( 'setsockopt' )
                    // InternalPerl.g:1961:3: 'setsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 
                    match(input,196,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 

                    }


                    }
                    break;
                case 165 :
                    // InternalPerl.g:1966:2: ( 'shift' )
                    {
                    // InternalPerl.g:1966:2: ( 'shift' )
                    // InternalPerl.g:1967:3: 'shift'
                    {
                     before(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 
                    match(input,197,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 

                    }


                    }
                    break;
                case 166 :
                    // InternalPerl.g:1972:2: ( 'shmctl' )
                    {
                    // InternalPerl.g:1972:2: ( 'shmctl' )
                    // InternalPerl.g:1973:3: 'shmctl'
                    {
                     before(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 
                    match(input,198,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 

                    }


                    }
                    break;
                case 167 :
                    // InternalPerl.g:1978:2: ( 'shmget' )
                    {
                    // InternalPerl.g:1978:2: ( 'shmget' )
                    // InternalPerl.g:1979:3: 'shmget'
                    {
                     before(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 
                    match(input,199,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 

                    }


                    }
                    break;
                case 168 :
                    // InternalPerl.g:1984:2: ( 'shmread' )
                    {
                    // InternalPerl.g:1984:2: ( 'shmread' )
                    // InternalPerl.g:1985:3: 'shmread'
                    {
                     before(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 
                    match(input,200,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 

                    }


                    }
                    break;
                case 169 :
                    // InternalPerl.g:1990:2: ( 'shmwrite' )
                    {
                    // InternalPerl.g:1990:2: ( 'shmwrite' )
                    // InternalPerl.g:1991:3: 'shmwrite'
                    {
                     before(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 
                    match(input,201,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 

                    }


                    }
                    break;
                case 170 :
                    // InternalPerl.g:1996:2: ( 'shutdown' )
                    {
                    // InternalPerl.g:1996:2: ( 'shutdown' )
                    // InternalPerl.g:1997:3: 'shutdown'
                    {
                     before(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 
                    match(input,202,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 

                    }


                    }
                    break;
                case 171 :
                    // InternalPerl.g:2002:2: ( 'sin' )
                    {
                    // InternalPerl.g:2002:2: ( 'sin' )
                    // InternalPerl.g:2003:3: 'sin'
                    {
                     before(grammarAccess.getKeywordAccess().getSinKeyword_170()); 
                    match(input,203,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSinKeyword_170()); 

                    }


                    }
                    break;
                case 172 :
                    // InternalPerl.g:2008:2: ( 'sleep' )
                    {
                    // InternalPerl.g:2008:2: ( 'sleep' )
                    // InternalPerl.g:2009:3: 'sleep'
                    {
                     before(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 
                    match(input,204,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 

                    }


                    }
                    break;
                case 173 :
                    // InternalPerl.g:2014:2: ( 'socket' )
                    {
                    // InternalPerl.g:2014:2: ( 'socket' )
                    // InternalPerl.g:2015:3: 'socket'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 
                    match(input,205,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 

                    }


                    }
                    break;
                case 174 :
                    // InternalPerl.g:2020:2: ( 'socketpair' )
                    {
                    // InternalPerl.g:2020:2: ( 'socketpair' )
                    // InternalPerl.g:2021:3: 'socketpair'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 
                    match(input,206,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 

                    }


                    }
                    break;
                case 175 :
                    // InternalPerl.g:2026:2: ( 'sort' )
                    {
                    // InternalPerl.g:2026:2: ( 'sort' )
                    // InternalPerl.g:2027:3: 'sort'
                    {
                     before(grammarAccess.getKeywordAccess().getSortKeyword_174()); 
                    match(input,207,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSortKeyword_174()); 

                    }


                    }
                    break;
                case 176 :
                    // InternalPerl.g:2032:2: ( 'splice' )
                    {
                    // InternalPerl.g:2032:2: ( 'splice' )
                    // InternalPerl.g:2033:3: 'splice'
                    {
                     before(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 
                    match(input,208,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 

                    }


                    }
                    break;
                case 177 :
                    // InternalPerl.g:2038:2: ( 'split' )
                    {
                    // InternalPerl.g:2038:2: ( 'split' )
                    // InternalPerl.g:2039:3: 'split'
                    {
                     before(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 
                    match(input,209,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 

                    }


                    }
                    break;
                case 178 :
                    // InternalPerl.g:2044:2: ( 'sprintf' )
                    {
                    // InternalPerl.g:2044:2: ( 'sprintf' )
                    // InternalPerl.g:2045:3: 'sprintf'
                    {
                     before(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 
                    match(input,210,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 

                    }


                    }
                    break;
                case 179 :
                    // InternalPerl.g:2050:2: ( 'sqrt' )
                    {
                    // InternalPerl.g:2050:2: ( 'sqrt' )
                    // InternalPerl.g:2051:3: 'sqrt'
                    {
                     before(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 
                    match(input,211,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 

                    }


                    }
                    break;
                case 180 :
                    // InternalPerl.g:2056:2: ( 'srand' )
                    {
                    // InternalPerl.g:2056:2: ( 'srand' )
                    // InternalPerl.g:2057:3: 'srand'
                    {
                     before(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 
                    match(input,212,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 

                    }


                    }
                    break;
                case 181 :
                    // InternalPerl.g:2062:2: ( 'stat' )
                    {
                    // InternalPerl.g:2062:2: ( 'stat' )
                    // InternalPerl.g:2063:3: 'stat'
                    {
                     before(grammarAccess.getKeywordAccess().getStatKeyword_180()); 
                    match(input,213,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStatKeyword_180()); 

                    }


                    }
                    break;
                case 182 :
                    // InternalPerl.g:2068:2: ( 'state' )
                    {
                    // InternalPerl.g:2068:2: ( 'state' )
                    // InternalPerl.g:2069:3: 'state'
                    {
                     before(grammarAccess.getKeywordAccess().getStateKeyword_181()); 
                    match(input,214,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStateKeyword_181()); 

                    }


                    }
                    break;
                case 183 :
                    // InternalPerl.g:2074:2: ( 'study' )
                    {
                    // InternalPerl.g:2074:2: ( 'study' )
                    // InternalPerl.g:2075:3: 'study'
                    {
                     before(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 
                    match(input,215,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 

                    }


                    }
                    break;
                case 184 :
                    // InternalPerl.g:2080:2: ( 'sub' )
                    {
                    // InternalPerl.g:2080:2: ( 'sub' )
                    // InternalPerl.g:2081:3: 'sub'
                    {
                     before(grammarAccess.getKeywordAccess().getSubKeyword_183()); 
                    match(input,216,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubKeyword_183()); 

                    }


                    }
                    break;
                case 185 :
                    // InternalPerl.g:2086:2: ( 'substr' )
                    {
                    // InternalPerl.g:2086:2: ( 'substr' )
                    // InternalPerl.g:2087:3: 'substr'
                    {
                     before(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 
                    match(input,217,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 

                    }


                    }
                    break;
                case 186 :
                    // InternalPerl.g:2092:2: ( 'symlink' )
                    {
                    // InternalPerl.g:2092:2: ( 'symlink' )
                    // InternalPerl.g:2093:3: 'symlink'
                    {
                     before(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 
                    match(input,218,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 

                    }


                    }
                    break;
                case 187 :
                    // InternalPerl.g:2098:2: ( 'syscall' )
                    {
                    // InternalPerl.g:2098:2: ( 'syscall' )
                    // InternalPerl.g:2099:3: 'syscall'
                    {
                     before(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 
                    match(input,219,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 

                    }


                    }
                    break;
                case 188 :
                    // InternalPerl.g:2104:2: ( 'sysopen' )
                    {
                    // InternalPerl.g:2104:2: ( 'sysopen' )
                    // InternalPerl.g:2105:3: 'sysopen'
                    {
                     before(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 
                    match(input,220,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 

                    }


                    }
                    break;
                case 189 :
                    // InternalPerl.g:2110:2: ( 'sysread' )
                    {
                    // InternalPerl.g:2110:2: ( 'sysread' )
                    // InternalPerl.g:2111:3: 'sysread'
                    {
                     before(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 
                    match(input,221,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 

                    }


                    }
                    break;
                case 190 :
                    // InternalPerl.g:2116:2: ( 'sysseek' )
                    {
                    // InternalPerl.g:2116:2: ( 'sysseek' )
                    // InternalPerl.g:2117:3: 'sysseek'
                    {
                     before(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 
                    match(input,222,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 

                    }


                    }
                    break;
                case 191 :
                    // InternalPerl.g:2122:2: ( 'system' )
                    {
                    // InternalPerl.g:2122:2: ( 'system' )
                    // InternalPerl.g:2123:3: 'system'
                    {
                     before(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 
                    match(input,223,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 

                    }


                    }
                    break;
                case 192 :
                    // InternalPerl.g:2128:2: ( 'syswrite' )
                    {
                    // InternalPerl.g:2128:2: ( 'syswrite' )
                    // InternalPerl.g:2129:3: 'syswrite'
                    {
                     before(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 
                    match(input,224,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 

                    }


                    }
                    break;
                case 193 :
                    // InternalPerl.g:2134:2: ( 'tell' )
                    {
                    // InternalPerl.g:2134:2: ( 'tell' )
                    // InternalPerl.g:2135:3: 'tell'
                    {
                     before(grammarAccess.getKeywordAccess().getTellKeyword_192()); 
                    match(input,225,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTellKeyword_192()); 

                    }


                    }
                    break;
                case 194 :
                    // InternalPerl.g:2140:2: ( 'telldir' )
                    {
                    // InternalPerl.g:2140:2: ( 'telldir' )
                    // InternalPerl.g:2141:3: 'telldir'
                    {
                     before(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 
                    match(input,226,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 

                    }


                    }
                    break;
                case 195 :
                    // InternalPerl.g:2146:2: ( 'tie' )
                    {
                    // InternalPerl.g:2146:2: ( 'tie' )
                    // InternalPerl.g:2147:3: 'tie'
                    {
                     before(grammarAccess.getKeywordAccess().getTieKeyword_194()); 
                    match(input,227,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTieKeyword_194()); 

                    }


                    }
                    break;
                case 196 :
                    // InternalPerl.g:2152:2: ( 'tied' )
                    {
                    // InternalPerl.g:2152:2: ( 'tied' )
                    // InternalPerl.g:2153:3: 'tied'
                    {
                     before(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 
                    match(input,228,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 

                    }


                    }
                    break;
                case 197 :
                    // InternalPerl.g:2158:2: ( 'time' )
                    {
                    // InternalPerl.g:2158:2: ( 'time' )
                    // InternalPerl.g:2159:3: 'time'
                    {
                     before(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 
                    match(input,229,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 

                    }


                    }
                    break;
                case 198 :
                    // InternalPerl.g:2164:2: ( 'times' )
                    {
                    // InternalPerl.g:2164:2: ( 'times' )
                    // InternalPerl.g:2165:3: 'times'
                    {
                     before(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 
                    match(input,230,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 

                    }


                    }
                    break;
                case 199 :
                    // InternalPerl.g:2170:2: ( 'tr' )
                    {
                    // InternalPerl.g:2170:2: ( 'tr' )
                    // InternalPerl.g:2171:3: 'tr'
                    {
                     before(grammarAccess.getKeywordAccess().getTrKeyword_198()); 
                    match(input,231,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTrKeyword_198()); 

                    }


                    }
                    break;
                case 200 :
                    // InternalPerl.g:2176:2: ( 'truncate' )
                    {
                    // InternalPerl.g:2176:2: ( 'truncate' )
                    // InternalPerl.g:2177:3: 'truncate'
                    {
                     before(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 
                    match(input,232,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 

                    }


                    }
                    break;
                case 201 :
                    // InternalPerl.g:2182:2: ( 'uc' )
                    {
                    // InternalPerl.g:2182:2: ( 'uc' )
                    // InternalPerl.g:2183:3: 'uc'
                    {
                     before(grammarAccess.getKeywordAccess().getUcKeyword_200()); 
                    match(input,233,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcKeyword_200()); 

                    }


                    }
                    break;
                case 202 :
                    // InternalPerl.g:2188:2: ( 'ucfirst' )
                    {
                    // InternalPerl.g:2188:2: ( 'ucfirst' )
                    // InternalPerl.g:2189:3: 'ucfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 
                    match(input,234,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 

                    }


                    }
                    break;
                case 203 :
                    // InternalPerl.g:2194:2: ( 'umask' )
                    {
                    // InternalPerl.g:2194:2: ( 'umask' )
                    // InternalPerl.g:2195:3: 'umask'
                    {
                     before(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 
                    match(input,235,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 

                    }


                    }
                    break;
                case 204 :
                    // InternalPerl.g:2200:2: ( 'undef' )
                    {
                    // InternalPerl.g:2200:2: ( 'undef' )
                    // InternalPerl.g:2201:3: 'undef'
                    {
                     before(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 
                    match(input,236,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 

                    }


                    }
                    break;
                case 205 :
                    // InternalPerl.g:2206:2: ( 'unless' )
                    {
                    // InternalPerl.g:2206:2: ( 'unless' )
                    // InternalPerl.g:2207:3: 'unless'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 
                    match(input,237,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 

                    }


                    }
                    break;
                case 206 :
                    // InternalPerl.g:2212:2: ( 'unlink' )
                    {
                    // InternalPerl.g:2212:2: ( 'unlink' )
                    // InternalPerl.g:2213:3: 'unlink'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 
                    match(input,238,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 

                    }


                    }
                    break;
                case 207 :
                    // InternalPerl.g:2218:2: ( 'unpack' )
                    {
                    // InternalPerl.g:2218:2: ( 'unpack' )
                    // InternalPerl.g:2219:3: 'unpack'
                    {
                     before(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 
                    match(input,239,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 

                    }


                    }
                    break;
                case 208 :
                    // InternalPerl.g:2224:2: ( 'unshift' )
                    {
                    // InternalPerl.g:2224:2: ( 'unshift' )
                    // InternalPerl.g:2225:3: 'unshift'
                    {
                     before(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 
                    match(input,240,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 

                    }


                    }
                    break;
                case 209 :
                    // InternalPerl.g:2230:2: ( 'untie' )
                    {
                    // InternalPerl.g:2230:2: ( 'untie' )
                    // InternalPerl.g:2231:3: 'untie'
                    {
                     before(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 
                    match(input,241,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 

                    }


                    }
                    break;
                case 210 :
                    // InternalPerl.g:2236:2: ( 'until' )
                    {
                    // InternalPerl.g:2236:2: ( 'until' )
                    // InternalPerl.g:2237:3: 'until'
                    {
                     before(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 
                    match(input,242,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 

                    }


                    }
                    break;
                case 211 :
                    // InternalPerl.g:2242:2: ( 'use' )
                    {
                    // InternalPerl.g:2242:2: ( 'use' )
                    // InternalPerl.g:2243:3: 'use'
                    {
                     before(grammarAccess.getKeywordAccess().getUseKeyword_210()); 
                    match(input,243,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUseKeyword_210()); 

                    }


                    }
                    break;
                case 212 :
                    // InternalPerl.g:2248:2: ( 'utime' )
                    {
                    // InternalPerl.g:2248:2: ( 'utime' )
                    // InternalPerl.g:2249:3: 'utime'
                    {
                     before(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 
                    match(input,244,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 

                    }


                    }
                    break;
                case 213 :
                    // InternalPerl.g:2254:2: ( 'values' )
                    {
                    // InternalPerl.g:2254:2: ( 'values' )
                    // InternalPerl.g:2255:3: 'values'
                    {
                     before(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 
                    match(input,245,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 

                    }


                    }
                    break;
                case 214 :
                    // InternalPerl.g:2260:2: ( 'vec' )
                    {
                    // InternalPerl.g:2260:2: ( 'vec' )
                    // InternalPerl.g:2261:3: 'vec'
                    {
                     before(grammarAccess.getKeywordAccess().getVecKeyword_213()); 
                    match(input,246,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getVecKeyword_213()); 

                    }


                    }
                    break;
                case 215 :
                    // InternalPerl.g:2266:2: ( 'wait' )
                    {
                    // InternalPerl.g:2266:2: ( 'wait' )
                    // InternalPerl.g:2267:3: 'wait'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 
                    match(input,247,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 

                    }


                    }
                    break;
                case 216 :
                    // InternalPerl.g:2272:2: ( 'waitpid' )
                    {
                    // InternalPerl.g:2272:2: ( 'waitpid' )
                    // InternalPerl.g:2273:3: 'waitpid'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 
                    match(input,248,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 

                    }


                    }
                    break;
                case 217 :
                    // InternalPerl.g:2278:2: ( 'wantarray' )
                    {
                    // InternalPerl.g:2278:2: ( 'wantarray' )
                    // InternalPerl.g:2279:3: 'wantarray'
                    {
                     before(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 
                    match(input,249,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 

                    }


                    }
                    break;
                case 218 :
                    // InternalPerl.g:2284:2: ( 'warn' )
                    {
                    // InternalPerl.g:2284:2: ( 'warn' )
                    // InternalPerl.g:2285:3: 'warn'
                    {
                     before(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 
                    match(input,250,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 

                    }


                    }
                    break;
                case 219 :
                    // InternalPerl.g:2290:2: ( 'when' )
                    {
                    // InternalPerl.g:2290:2: ( 'when' )
                    // InternalPerl.g:2291:3: 'when'
                    {
                     before(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 
                    match(input,251,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 

                    }


                    }
                    break;
                case 220 :
                    // InternalPerl.g:2296:2: ( 'while' )
                    {
                    // InternalPerl.g:2296:2: ( 'while' )
                    // InternalPerl.g:2297:3: 'while'
                    {
                     before(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 
                    match(input,252,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 

                    }


                    }
                    break;
                case 221 :
                    // InternalPerl.g:2302:2: ( 'write' )
                    {
                    // InternalPerl.g:2302:2: ( 'write' )
                    // InternalPerl.g:2303:3: 'write'
                    {
                     before(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 
                    match(input,253,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 

                    }


                    }
                    break;
                case 222 :
                    // InternalPerl.g:2308:2: ( 'y' )
                    {
                    // InternalPerl.g:2308:2: ( 'y' )
                    // InternalPerl.g:2309:3: 'y'
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
    // InternalPerl.g:2318:1: rule__Operator__Alternatives : ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2322:1: ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) )
            int alt15=64;
            switch ( input.LA(1) ) {
            case 255:
                {
                alt15=1;
                }
                break;
            case 256:
                {
                alt15=2;
                }
                break;
            case 257:
                {
                alt15=3;
                }
                break;
            case 258:
                {
                alt15=4;
                }
                break;
            case 259:
                {
                alt15=5;
                }
                break;
            case 260:
                {
                alt15=6;
                }
                break;
            case 261:
                {
                alt15=7;
                }
                break;
            case 262:
                {
                alt15=8;
                }
                break;
            case 263:
                {
                alt15=9;
                }
                break;
            case 264:
                {
                alt15=10;
                }
                break;
            case 265:
                {
                alt15=11;
                }
                break;
            case 30:
                {
                alt15=12;
                }
                break;
            case 266:
                {
                alt15=13;
                }
                break;
            case 267:
                {
                alt15=14;
                }
                break;
            case 268:
                {
                alt15=15;
                }
                break;
            case 269:
                {
                alt15=16;
                }
                break;
            case 270:
                {
                alt15=17;
                }
                break;
            case 271:
                {
                alt15=18;
                }
                break;
            case 272:
                {
                alt15=19;
                }
                break;
            case 273:
                {
                alt15=20;
                }
                break;
            case 274:
                {
                alt15=21;
                }
                break;
            case 275:
                {
                alt15=22;
                }
                break;
            case 276:
                {
                alt15=23;
                }
                break;
            case 347:
                {
                alt15=24;
                }
                break;
            case 277:
                {
                alt15=25;
                }
                break;
            case 278:
                {
                alt15=26;
                }
                break;
            case 279:
                {
                alt15=27;
                }
                break;
            case 32:
                {
                alt15=28;
                }
                break;
            case 280:
                {
                alt15=29;
                }
                break;
            case 281:
                {
                alt15=30;
                }
                break;
            case 282:
                {
                alt15=31;
                }
                break;
            case 283:
                {
                alt15=32;
                }
                break;
            case 284:
                {
                alt15=33;
                }
                break;
            case 285:
                {
                alt15=34;
                }
                break;
            case 286:
                {
                alt15=35;
                }
                break;
            case 287:
                {
                alt15=36;
                }
                break;
            case 288:
                {
                alt15=37;
                }
                break;
            case 289:
                {
                alt15=38;
                }
                break;
            case 290:
                {
                alt15=39;
                }
                break;
            case 291:
                {
                alt15=40;
                }
                break;
            case 292:
                {
                alt15=41;
                }
                break;
            case 293:
                {
                alt15=42;
                }
                break;
            case 294:
                {
                alt15=43;
                }
                break;
            case 295:
                {
                alt15=44;
                }
                break;
            case 296:
                {
                alt15=45;
                }
                break;
            case 297:
                {
                alt15=46;
                }
                break;
            case 298:
                {
                alt15=47;
                }
                break;
            case 299:
                {
                alt15=48;
                }
                break;
            case 300:
                {
                alt15=49;
                }
                break;
            case 301:
                {
                alt15=50;
                }
                break;
            case 302:
                {
                alt15=51;
                }
                break;
            case 303:
                {
                alt15=52;
                }
                break;
            case 304:
                {
                alt15=53;
                }
                break;
            case 305:
                {
                alt15=54;
                }
                break;
            case 306:
                {
                alt15=55;
                }
                break;
            case 307:
                {
                alt15=56;
                }
                break;
            case 308:
                {
                alt15=57;
                }
                break;
            case 309:
                {
                alt15=58;
                }
                break;
            case 310:
                {
                alt15=59;
                }
                break;
            case 311:
                {
                alt15=60;
                }
                break;
            case 312:
                {
                alt15=61;
                }
                break;
            case 313:
                {
                alt15=62;
                }
                break;
            case 314:
                {
                alt15=63;
                }
                break;
            case 315:
                {
                alt15=64;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalPerl.g:2323:2: ( '++' )
                    {
                    // InternalPerl.g:2323:2: ( '++' )
                    // InternalPerl.g:2324:3: '++'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 
                    match(input,255,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2329:2: ( '--' )
                    {
                    // InternalPerl.g:2329:2: ( '--' )
                    // InternalPerl.g:2330:3: '--'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    match(input,256,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2335:2: ( '**' )
                    {
                    // InternalPerl.g:2335:2: ( '**' )
                    // InternalPerl.g:2336:3: '**'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 
                    match(input,257,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2341:2: ( '!' )
                    {
                    // InternalPerl.g:2341:2: ( '!' )
                    // InternalPerl.g:2342:3: '!'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 
                    match(input,258,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2347:2: ( '~' )
                    {
                    // InternalPerl.g:2347:2: ( '~' )
                    // InternalPerl.g:2348:3: '~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 
                    match(input,259,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2353:2: ( '+' )
                    {
                    // InternalPerl.g:2353:2: ( '+' )
                    // InternalPerl.g:2354:3: '+'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 
                    match(input,260,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2359:2: ( '-' )
                    {
                    // InternalPerl.g:2359:2: ( '-' )
                    // InternalPerl.g:2360:3: '-'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 
                    match(input,261,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2365:2: ( '=~' )
                    {
                    // InternalPerl.g:2365:2: ( '=~' )
                    // InternalPerl.g:2366:3: '=~'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 
                    match(input,262,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2371:2: ( '!~' )
                    {
                    // InternalPerl.g:2371:2: ( '!~' )
                    // InternalPerl.g:2372:3: '!~'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 
                    match(input,263,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2377:2: ( '*' )
                    {
                    // InternalPerl.g:2377:2: ( '*' )
                    // InternalPerl.g:2378:3: '*'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 
                    match(input,264,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2383:2: ( '/' )
                    {
                    // InternalPerl.g:2383:2: ( '/' )
                    // InternalPerl.g:2384:3: '/'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 
                    match(input,265,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2389:2: ( '%' )
                    {
                    // InternalPerl.g:2389:2: ( '%' )
                    // InternalPerl.g:2390:3: '%'
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2395:2: ( 'x' )
                    {
                    // InternalPerl.g:2395:2: ( 'x' )
                    // InternalPerl.g:2396:3: 'x'
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_12()); 
                    match(input,266,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2401:2: ( '<<' )
                    {
                    // InternalPerl.g:2401:2: ( '<<' )
                    // InternalPerl.g:2402:3: '<<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 
                    match(input,267,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2407:2: ( '>>' )
                    {
                    // InternalPerl.g:2407:2: ( '>>' )
                    // InternalPerl.g:2408:3: '>>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 
                    match(input,268,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2413:2: ( 'lt' )
                    {
                    // InternalPerl.g:2413:2: ( 'lt' )
                    // InternalPerl.g:2414:3: 'lt'
                    {
                     before(grammarAccess.getOperatorAccess().getLtKeyword_15()); 
                    match(input,269,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLtKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2419:2: ( 'gt' )
                    {
                    // InternalPerl.g:2419:2: ( 'gt' )
                    // InternalPerl.g:2420:3: 'gt'
                    {
                     before(grammarAccess.getOperatorAccess().getGtKeyword_16()); 
                    match(input,270,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGtKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2425:2: ( 'le' )
                    {
                    // InternalPerl.g:2425:2: ( 'le' )
                    // InternalPerl.g:2426:3: 'le'
                    {
                     before(grammarAccess.getOperatorAccess().getLeKeyword_17()); 
                    match(input,271,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLeKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2431:2: ( 'ge' )
                    {
                    // InternalPerl.g:2431:2: ( 'ge' )
                    // InternalPerl.g:2432:3: 'ge'
                    {
                     before(grammarAccess.getOperatorAccess().getGeKeyword_18()); 
                    match(input,272,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGeKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2437:2: ( 'cmp' )
                    {
                    // InternalPerl.g:2437:2: ( 'cmp' )
                    // InternalPerl.g:2438:3: 'cmp'
                    {
                     before(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 
                    match(input,273,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2443:2: ( '~~' )
                    {
                    // InternalPerl.g:2443:2: ( '~~' )
                    // InternalPerl.g:2444:3: '~~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 
                    match(input,274,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2449:2: ( '==' )
                    {
                    // InternalPerl.g:2449:2: ( '==' )
                    // InternalPerl.g:2450:3: '=='
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 
                    match(input,275,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2455:2: ( '!=' )
                    {
                    // InternalPerl.g:2455:2: ( '!=' )
                    // InternalPerl.g:2456:3: '!='
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 
                    match(input,276,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2461:2: ( ( rule__Operator__Group_23__0 ) )
                    {
                    // InternalPerl.g:2461:2: ( ( rule__Operator__Group_23__0 ) )
                    // InternalPerl.g:2462:3: ( rule__Operator__Group_23__0 )
                    {
                     before(grammarAccess.getOperatorAccess().getGroup_23()); 
                    // InternalPerl.g:2463:3: ( rule__Operator__Group_23__0 )
                    // InternalPerl.g:2463:4: rule__Operator__Group_23__0
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
                    // InternalPerl.g:2467:2: ( '..' )
                    {
                    // InternalPerl.g:2467:2: ( '..' )
                    // InternalPerl.g:2468:3: '..'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 
                    match(input,277,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2473:2: ( '...' )
                    {
                    // InternalPerl.g:2473:2: ( '...' )
                    // InternalPerl.g:2474:3: '...'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 
                    match(input,278,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2479:2: ( ',' )
                    {
                    // InternalPerl.g:2479:2: ( ',' )
                    // InternalPerl.g:2480:3: ','
                    {
                     before(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 
                    match(input,279,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:2485:2: ( '&' )
                    {
                    // InternalPerl.g:2485:2: ( '&' )
                    // InternalPerl.g:2486:3: '&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:2491:2: ( '|' )
                    {
                    // InternalPerl.g:2491:2: ( '|' )
                    // InternalPerl.g:2492:3: '|'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 
                    match(input,280,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:2497:2: ( '^' )
                    {
                    // InternalPerl.g:2497:2: ( '^' )
                    // InternalPerl.g:2498:3: '^'
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 
                    match(input,281,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:2503:2: ( '&&' )
                    {
                    // InternalPerl.g:2503:2: ( '&&' )
                    // InternalPerl.g:2504:3: '&&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 
                    match(input,282,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:2509:2: ( '||' )
                    {
                    // InternalPerl.g:2509:2: ( '||' )
                    // InternalPerl.g:2510:3: '||'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 
                    match(input,283,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:2515:2: ( '//' )
                    {
                    // InternalPerl.g:2515:2: ( '//' )
                    // InternalPerl.g:2516:3: '//'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 
                    match(input,284,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:2521:2: ( '?' )
                    {
                    // InternalPerl.g:2521:2: ( '?' )
                    // InternalPerl.g:2522:3: '?'
                    {
                     before(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 
                    match(input,285,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:2527:2: ( ':' )
                    {
                    // InternalPerl.g:2527:2: ( ':' )
                    // InternalPerl.g:2528:3: ':'
                    {
                     before(grammarAccess.getOperatorAccess().getColonKeyword_34()); 
                    match(input,286,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getColonKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:2533:2: ( '**=' )
                    {
                    // InternalPerl.g:2533:2: ( '**=' )
                    // InternalPerl.g:2534:3: '**='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 
                    match(input,287,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:2539:2: ( '+=' )
                    {
                    // InternalPerl.g:2539:2: ( '+=' )
                    // InternalPerl.g:2540:3: '+='
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 
                    match(input,288,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:2545:2: ( '-=' )
                    {
                    // InternalPerl.g:2545:2: ( '-=' )
                    // InternalPerl.g:2546:3: '-='
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 
                    match(input,289,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:2551:2: ( '.=' )
                    {
                    // InternalPerl.g:2551:2: ( '.=' )
                    // InternalPerl.g:2552:3: '.='
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 
                    match(input,290,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:2557:2: ( '*=' )
                    {
                    // InternalPerl.g:2557:2: ( '*=' )
                    // InternalPerl.g:2558:3: '*='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 
                    match(input,291,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:2563:2: ( '/=' )
                    {
                    // InternalPerl.g:2563:2: ( '/=' )
                    // InternalPerl.g:2564:3: '/='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 
                    match(input,292,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:2569:2: ( '%=' )
                    {
                    // InternalPerl.g:2569:2: ( '%=' )
                    // InternalPerl.g:2570:3: '%='
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 
                    match(input,293,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:2575:2: ( 'x=' )
                    {
                    // InternalPerl.g:2575:2: ( 'x=' )
                    // InternalPerl.g:2576:3: 'x='
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_42()); 
                    match(input,294,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:2581:2: ( '&=' )
                    {
                    // InternalPerl.g:2581:2: ( '&=' )
                    // InternalPerl.g:2582:3: '&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 
                    match(input,295,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:2587:2: ( '|=' )
                    {
                    // InternalPerl.g:2587:2: ( '|=' )
                    // InternalPerl.g:2588:3: '|='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 
                    match(input,296,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:2593:2: ( '^=' )
                    {
                    // InternalPerl.g:2593:2: ( '^=' )
                    // InternalPerl.g:2594:3: '^='
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 
                    match(input,297,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:2599:2: ( '<<=' )
                    {
                    // InternalPerl.g:2599:2: ( '<<=' )
                    // InternalPerl.g:2600:3: '<<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 
                    match(input,298,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:2605:2: ( '>>=' )
                    {
                    // InternalPerl.g:2605:2: ( '>>=' )
                    // InternalPerl.g:2606:3: '>>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 
                    match(input,299,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:2611:2: ( '&&=' )
                    {
                    // InternalPerl.g:2611:2: ( '&&=' )
                    // InternalPerl.g:2612:3: '&&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 
                    match(input,300,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:2617:2: ( '||=' )
                    {
                    // InternalPerl.g:2617:2: ( '||=' )
                    // InternalPerl.g:2618:3: '||='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 
                    match(input,301,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:2623:2: ( '//=' )
                    {
                    // InternalPerl.g:2623:2: ( '//=' )
                    // InternalPerl.g:2624:3: '//='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 
                    match(input,302,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:2629:2: ( '<' )
                    {
                    // InternalPerl.g:2629:2: ( '<' )
                    // InternalPerl.g:2630:3: '<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 
                    match(input,303,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:2635:2: ( '>' )
                    {
                    // InternalPerl.g:2635:2: ( '>' )
                    // InternalPerl.g:2636:3: '>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 
                    match(input,304,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:2641:2: ( '<=' )
                    {
                    // InternalPerl.g:2641:2: ( '<=' )
                    // InternalPerl.g:2642:3: '<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 
                    match(input,305,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:2647:2: ( '>=' )
                    {
                    // InternalPerl.g:2647:2: ( '>=' )
                    // InternalPerl.g:2648:3: '>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 
                    match(input,306,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:2653:2: ( '<>' )
                    {
                    // InternalPerl.g:2653:2: ( '<>' )
                    // InternalPerl.g:2654:3: '<>'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 
                    match(input,307,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:2659:2: ( '=>' )
                    {
                    // InternalPerl.g:2659:2: ( '=>' )
                    // InternalPerl.g:2660:3: '=>'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 
                    match(input,308,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:2665:2: ( '->' )
                    {
                    // InternalPerl.g:2665:2: ( '->' )
                    // InternalPerl.g:2666:3: '->'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 
                    match(input,309,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:2671:2: ( 'and' )
                    {
                    // InternalPerl.g:2671:2: ( 'and' )
                    // InternalPerl.g:2672:3: 'and'
                    {
                     before(grammarAccess.getOperatorAccess().getAndKeyword_58()); 
                    match(input,310,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAndKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:2677:2: ( 'or' )
                    {
                    // InternalPerl.g:2677:2: ( 'or' )
                    // InternalPerl.g:2678:3: 'or'
                    {
                     before(grammarAccess.getOperatorAccess().getOrKeyword_59()); 
                    match(input,311,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getOrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:2683:2: ( 'xor' )
                    {
                    // InternalPerl.g:2683:2: ( 'xor' )
                    // InternalPerl.g:2684:3: 'xor'
                    {
                     before(grammarAccess.getOperatorAccess().getXorKeyword_60()); 
                    match(input,312,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXorKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:2689:2: ( 'not' )
                    {
                    // InternalPerl.g:2689:2: ( 'not' )
                    // InternalPerl.g:2690:3: 'not'
                    {
                     before(grammarAccess.getOperatorAccess().getNotKeyword_61()); 
                    match(input,313,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getNotKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:2695:2: ( 'eq' )
                    {
                    // InternalPerl.g:2695:2: ( 'eq' )
                    // InternalPerl.g:2696:3: 'eq'
                    {
                     before(grammarAccess.getOperatorAccess().getEqKeyword_62()); 
                    match(input,314,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:2701:2: ( 'ne' )
                    {
                    // InternalPerl.g:2701:2: ( 'ne' )
                    // InternalPerl.g:2702:3: 'ne'
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
    // InternalPerl.g:2711:1: rule__FileTestOperator__Alternatives : ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) );
    public final void rule__FileTestOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2715:1: ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) )
            int alt16=27;
            switch ( input.LA(1) ) {
            case 316:
                {
                alt16=1;
                }
                break;
            case 317:
                {
                alt16=2;
                }
                break;
            case 318:
                {
                alt16=3;
                }
                break;
            case 319:
                {
                alt16=4;
                }
                break;
            case 320:
                {
                alt16=5;
                }
                break;
            case 321:
                {
                alt16=6;
                }
                break;
            case 322:
                {
                alt16=7;
                }
                break;
            case 323:
                {
                alt16=8;
                }
                break;
            case 324:
                {
                alt16=9;
                }
                break;
            case 325:
                {
                alt16=10;
                }
                break;
            case 326:
                {
                alt16=11;
                }
                break;
            case 327:
                {
                alt16=12;
                }
                break;
            case 328:
                {
                alt16=13;
                }
                break;
            case 329:
                {
                alt16=14;
                }
                break;
            case 330:
                {
                alt16=15;
                }
                break;
            case 331:
                {
                alt16=16;
                }
                break;
            case 332:
                {
                alt16=17;
                }
                break;
            case 333:
                {
                alt16=18;
                }
                break;
            case 334:
                {
                alt16=19;
                }
                break;
            case 335:
                {
                alt16=20;
                }
                break;
            case 336:
                {
                alt16=21;
                }
                break;
            case 337:
                {
                alt16=22;
                }
                break;
            case 338:
                {
                alt16=23;
                }
                break;
            case 339:
                {
                alt16=24;
                }
                break;
            case 340:
                {
                alt16=25;
                }
                break;
            case 341:
                {
                alt16=26;
                }
                break;
            case 342:
                {
                alt16=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalPerl.g:2716:2: ( '-r' )
                    {
                    // InternalPerl.g:2716:2: ( '-r' )
                    // InternalPerl.g:2717:3: '-r'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 
                    match(input,316,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2722:2: ( '-w' )
                    {
                    // InternalPerl.g:2722:2: ( '-w' )
                    // InternalPerl.g:2723:3: '-w'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 
                    match(input,317,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2728:2: ( '-x' )
                    {
                    // InternalPerl.g:2728:2: ( '-x' )
                    // InternalPerl.g:2729:3: '-x'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 
                    match(input,318,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2734:2: ( '-o' )
                    {
                    // InternalPerl.g:2734:2: ( '-o' )
                    // InternalPerl.g:2735:3: '-o'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 
                    match(input,319,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2740:2: ( '-R' )
                    {
                    // InternalPerl.g:2740:2: ( '-R' )
                    // InternalPerl.g:2741:3: '-R'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 
                    match(input,320,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2746:2: ( '-W' )
                    {
                    // InternalPerl.g:2746:2: ( '-W' )
                    // InternalPerl.g:2747:3: '-W'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 
                    match(input,321,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2752:2: ( '-X' )
                    {
                    // InternalPerl.g:2752:2: ( '-X' )
                    // InternalPerl.g:2753:3: '-X'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 
                    match(input,322,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2758:2: ( '-O' )
                    {
                    // InternalPerl.g:2758:2: ( '-O' )
                    // InternalPerl.g:2759:3: '-O'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 
                    match(input,323,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2764:2: ( '-e' )
                    {
                    // InternalPerl.g:2764:2: ( '-e' )
                    // InternalPerl.g:2765:3: '-e'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 
                    match(input,324,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2770:2: ( '-z' )
                    {
                    // InternalPerl.g:2770:2: ( '-z' )
                    // InternalPerl.g:2771:3: '-z'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 
                    match(input,325,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2776:2: ( '-s' )
                    {
                    // InternalPerl.g:2776:2: ( '-s' )
                    // InternalPerl.g:2777:3: '-s'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 
                    match(input,326,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2782:2: ( '-f' )
                    {
                    // InternalPerl.g:2782:2: ( '-f' )
                    // InternalPerl.g:2783:3: '-f'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 
                    match(input,327,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2788:2: ( '-d' )
                    {
                    // InternalPerl.g:2788:2: ( '-d' )
                    // InternalPerl.g:2789:3: '-d'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 
                    match(input,328,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2794:2: ( '-l' )
                    {
                    // InternalPerl.g:2794:2: ( '-l' )
                    // InternalPerl.g:2795:3: '-l'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 
                    match(input,329,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2800:2: ( '-p' )
                    {
                    // InternalPerl.g:2800:2: ( '-p' )
                    // InternalPerl.g:2801:3: '-p'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 
                    match(input,330,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2806:2: ( '-S' )
                    {
                    // InternalPerl.g:2806:2: ( '-S' )
                    // InternalPerl.g:2807:3: '-S'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 
                    match(input,331,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2812:2: ( '-b' )
                    {
                    // InternalPerl.g:2812:2: ( '-b' )
                    // InternalPerl.g:2813:3: '-b'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 
                    match(input,332,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2818:2: ( '-c' )
                    {
                    // InternalPerl.g:2818:2: ( '-c' )
                    // InternalPerl.g:2819:3: '-c'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 
                    match(input,333,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2824:2: ( '-t' )
                    {
                    // InternalPerl.g:2824:2: ( '-t' )
                    // InternalPerl.g:2825:3: '-t'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 
                    match(input,334,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2830:2: ( '-u' )
                    {
                    // InternalPerl.g:2830:2: ( '-u' )
                    // InternalPerl.g:2831:3: '-u'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 
                    match(input,335,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2836:2: ( '-g' )
                    {
                    // InternalPerl.g:2836:2: ( '-g' )
                    // InternalPerl.g:2837:3: '-g'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 
                    match(input,336,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2842:2: ( '-k' )
                    {
                    // InternalPerl.g:2842:2: ( '-k' )
                    // InternalPerl.g:2843:3: '-k'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 
                    match(input,337,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2848:2: ( '-T' )
                    {
                    // InternalPerl.g:2848:2: ( '-T' )
                    // InternalPerl.g:2849:3: '-T'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 
                    match(input,338,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2854:2: ( '-B' )
                    {
                    // InternalPerl.g:2854:2: ( '-B' )
                    // InternalPerl.g:2855:3: '-B'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 
                    match(input,339,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:2860:2: ( '-M' )
                    {
                    // InternalPerl.g:2860:2: ( '-M' )
                    // InternalPerl.g:2861:3: '-M'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 
                    match(input,340,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2866:2: ( '-A' )
                    {
                    // InternalPerl.g:2866:2: ( '-A' )
                    // InternalPerl.g:2867:3: '-A'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 
                    match(input,341,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2872:2: ( '-C' )
                    {
                    // InternalPerl.g:2872:2: ( '-C' )
                    // InternalPerl.g:2873:3: '-C'
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
    // InternalPerl.g:2882:1: rule__PerlDocument__Group__0 : rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 ;
    public final void rule__PerlDocument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2886:1: ( rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 )
            // InternalPerl.g:2887:2: rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1
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
    // InternalPerl.g:2894:1: rule__PerlDocument__Group__0__Impl : ( () ) ;
    public final void rule__PerlDocument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2898:1: ( ( () ) )
            // InternalPerl.g:2899:1: ( () )
            {
            // InternalPerl.g:2899:1: ( () )
            // InternalPerl.g:2900:2: ()
            {
             before(grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0()); 
            // InternalPerl.g:2901:2: ()
            // InternalPerl.g:2901:3: 
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
    // InternalPerl.g:2909:1: rule__PerlDocument__Group__1 : rule__PerlDocument__Group__1__Impl ;
    public final void rule__PerlDocument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2913:1: ( rule__PerlDocument__Group__1__Impl )
            // InternalPerl.g:2914:2: rule__PerlDocument__Group__1__Impl
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
    // InternalPerl.g:2920:1: rule__PerlDocument__Group__1__Impl : ( ( rule__PerlDocument__ElementsAssignment_1 )* ) ;
    public final void rule__PerlDocument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2924:1: ( ( ( rule__PerlDocument__ElementsAssignment_1 )* ) )
            // InternalPerl.g:2925:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            {
            // InternalPerl.g:2925:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            // InternalPerl.g:2926:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            {
             before(grammarAccess.getPerlDocumentAccess().getElementsAssignment_1()); 
            // InternalPerl.g:2927:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_STRING && LA17_0<=RULE_REGEX_MATCH)||(LA17_0>=RULE_WORDS_QUOTE_LIKE && LA17_0<=RULE_READLINE_QUOTE)||LA17_0==30||(LA17_0>=32 && LA17_0<=343)||LA17_0==347) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalPerl.g:2927:3: rule__PerlDocument__ElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__PerlDocument__ElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalPerl.g:2936:1: rule__ExpressionStatement__Group__0 : rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1 ;
    public final void rule__ExpressionStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2940:1: ( rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1 )
            // InternalPerl.g:2941:2: rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1
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
    // InternalPerl.g:2948:1: rule__ExpressionStatement__Group__0__Impl : ( ( rule__ExpressionStatement__Alternatives_0 ) ) ;
    public final void rule__ExpressionStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2952:1: ( ( ( rule__ExpressionStatement__Alternatives_0 ) ) )
            // InternalPerl.g:2953:1: ( ( rule__ExpressionStatement__Alternatives_0 ) )
            {
            // InternalPerl.g:2953:1: ( ( rule__ExpressionStatement__Alternatives_0 ) )
            // InternalPerl.g:2954:2: ( rule__ExpressionStatement__Alternatives_0 )
            {
             before(grammarAccess.getExpressionStatementAccess().getAlternatives_0()); 
            // InternalPerl.g:2955:2: ( rule__ExpressionStatement__Alternatives_0 )
            // InternalPerl.g:2955:3: rule__ExpressionStatement__Alternatives_0
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
    // InternalPerl.g:2963:1: rule__ExpressionStatement__Group__1 : rule__ExpressionStatement__Group__1__Impl ;
    public final void rule__ExpressionStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2967:1: ( rule__ExpressionStatement__Group__1__Impl )
            // InternalPerl.g:2968:2: rule__ExpressionStatement__Group__1__Impl
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
    // InternalPerl.g:2974:1: rule__ExpressionStatement__Group__1__Impl : ( ';' ) ;
    public final void rule__ExpressionStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2978:1: ( ( ';' ) )
            // InternalPerl.g:2979:1: ( ';' )
            {
            // InternalPerl.g:2979:1: ( ';' )
            // InternalPerl.g:2980:2: ';'
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
    // InternalPerl.g:2990:1: rule__PackageStatement__Group__0 : rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 ;
    public final void rule__PackageStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2994:1: ( rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 )
            // InternalPerl.g:2995:2: rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1
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
    // InternalPerl.g:3002:1: rule__PackageStatement__Group__0__Impl : ( () ) ;
    public final void rule__PackageStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3006:1: ( ( () ) )
            // InternalPerl.g:3007:1: ( () )
            {
            // InternalPerl.g:3007:1: ( () )
            // InternalPerl.g:3008:2: ()
            {
             before(grammarAccess.getPackageStatementAccess().getPackageStatementAction_0()); 
            // InternalPerl.g:3009:2: ()
            // InternalPerl.g:3009:3: 
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
    // InternalPerl.g:3017:1: rule__PackageStatement__Group__1 : rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 ;
    public final void rule__PackageStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3021:1: ( rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 )
            // InternalPerl.g:3022:2: rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2
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
    // InternalPerl.g:3029:1: rule__PackageStatement__Group__1__Impl : ( 'package' ) ;
    public final void rule__PackageStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3033:1: ( ( 'package' ) )
            // InternalPerl.g:3034:1: ( 'package' )
            {
            // InternalPerl.g:3034:1: ( 'package' )
            // InternalPerl.g:3035:2: 'package'
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
    // InternalPerl.g:3044:1: rule__PackageStatement__Group__2 : rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3 ;
    public final void rule__PackageStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3048:1: ( rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3 )
            // InternalPerl.g:3049:2: rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3
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
    // InternalPerl.g:3056:1: rule__PackageStatement__Group__2__Impl : ( ( rule__PackageStatement__NameAssignment_2 ) ) ;
    public final void rule__PackageStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3060:1: ( ( ( rule__PackageStatement__NameAssignment_2 ) ) )
            // InternalPerl.g:3061:1: ( ( rule__PackageStatement__NameAssignment_2 ) )
            {
            // InternalPerl.g:3061:1: ( ( rule__PackageStatement__NameAssignment_2 ) )
            // InternalPerl.g:3062:2: ( rule__PackageStatement__NameAssignment_2 )
            {
             before(grammarAccess.getPackageStatementAccess().getNameAssignment_2()); 
            // InternalPerl.g:3063:2: ( rule__PackageStatement__NameAssignment_2 )
            // InternalPerl.g:3063:3: rule__PackageStatement__NameAssignment_2
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
    // InternalPerl.g:3071:1: rule__PackageStatement__Group__3 : rule__PackageStatement__Group__3__Impl ;
    public final void rule__PackageStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3075:1: ( rule__PackageStatement__Group__3__Impl )
            // InternalPerl.g:3076:2: rule__PackageStatement__Group__3__Impl
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
    // InternalPerl.g:3082:1: rule__PackageStatement__Group__3__Impl : ( ( rule__PackageStatement__VersionAssignment_3 )? ) ;
    public final void rule__PackageStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3086:1: ( ( ( rule__PackageStatement__VersionAssignment_3 )? ) )
            // InternalPerl.g:3087:1: ( ( rule__PackageStatement__VersionAssignment_3 )? )
            {
            // InternalPerl.g:3087:1: ( ( rule__PackageStatement__VersionAssignment_3 )? )
            // InternalPerl.g:3088:2: ( rule__PackageStatement__VersionAssignment_3 )?
            {
             before(grammarAccess.getPackageStatementAccess().getVersionAssignment_3()); 
            // InternalPerl.g:3089:2: ( rule__PackageStatement__VersionAssignment_3 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_VERSION) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalPerl.g:3089:3: rule__PackageStatement__VersionAssignment_3
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
    // InternalPerl.g:3098:1: rule__RequireInclude__Group__0 : rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1 ;
    public final void rule__RequireInclude__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3102:1: ( rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1 )
            // InternalPerl.g:3103:2: rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1
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
    // InternalPerl.g:3110:1: rule__RequireInclude__Group__0__Impl : ( 'require' ) ;
    public final void rule__RequireInclude__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3114:1: ( ( 'require' ) )
            // InternalPerl.g:3115:1: ( 'require' )
            {
            // InternalPerl.g:3115:1: ( 'require' )
            // InternalPerl.g:3116:2: 'require'
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
    // InternalPerl.g:3125:1: rule__RequireInclude__Group__1 : rule__RequireInclude__Group__1__Impl ;
    public final void rule__RequireInclude__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3129:1: ( rule__RequireInclude__Group__1__Impl )
            // InternalPerl.g:3130:2: rule__RequireInclude__Group__1__Impl
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
    // InternalPerl.g:3136:1: rule__RequireInclude__Group__1__Impl : ( ( rule__RequireInclude__VersionAssignment_1 ) ) ;
    public final void rule__RequireInclude__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3140:1: ( ( ( rule__RequireInclude__VersionAssignment_1 ) ) )
            // InternalPerl.g:3141:1: ( ( rule__RequireInclude__VersionAssignment_1 ) )
            {
            // InternalPerl.g:3141:1: ( ( rule__RequireInclude__VersionAssignment_1 ) )
            // InternalPerl.g:3142:2: ( rule__RequireInclude__VersionAssignment_1 )
            {
             before(grammarAccess.getRequireIncludeAccess().getVersionAssignment_1()); 
            // InternalPerl.g:3143:2: ( rule__RequireInclude__VersionAssignment_1 )
            // InternalPerl.g:3143:3: rule__RequireInclude__VersionAssignment_1
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
    // InternalPerl.g:3152:1: rule__UseInclude__Group__0 : rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1 ;
    public final void rule__UseInclude__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3156:1: ( rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1 )
            // InternalPerl.g:3157:2: rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1
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
    // InternalPerl.g:3164:1: rule__UseInclude__Group__0__Impl : ( () ) ;
    public final void rule__UseInclude__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3168:1: ( ( () ) )
            // InternalPerl.g:3169:1: ( () )
            {
            // InternalPerl.g:3169:1: ( () )
            // InternalPerl.g:3170:2: ()
            {
             before(grammarAccess.getUseIncludeAccess().getUseIncludeAction_0()); 
            // InternalPerl.g:3171:2: ()
            // InternalPerl.g:3171:3: 
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
    // InternalPerl.g:3179:1: rule__UseInclude__Group__1 : rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2 ;
    public final void rule__UseInclude__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3183:1: ( rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2 )
            // InternalPerl.g:3184:2: rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2
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
    // InternalPerl.g:3191:1: rule__UseInclude__Group__1__Impl : ( 'use' ) ;
    public final void rule__UseInclude__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3195:1: ( ( 'use' ) )
            // InternalPerl.g:3196:1: ( 'use' )
            {
            // InternalPerl.g:3196:1: ( 'use' )
            // InternalPerl.g:3197:2: 'use'
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
    // InternalPerl.g:3206:1: rule__UseInclude__Group__2 : rule__UseInclude__Group__2__Impl ;
    public final void rule__UseInclude__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3210:1: ( rule__UseInclude__Group__2__Impl )
            // InternalPerl.g:3211:2: rule__UseInclude__Group__2__Impl
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
    // InternalPerl.g:3217:1: rule__UseInclude__Group__2__Impl : ( ( rule__UseInclude__Alternatives_2 ) ) ;
    public final void rule__UseInclude__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3221:1: ( ( ( rule__UseInclude__Alternatives_2 ) ) )
            // InternalPerl.g:3222:1: ( ( rule__UseInclude__Alternatives_2 ) )
            {
            // InternalPerl.g:3222:1: ( ( rule__UseInclude__Alternatives_2 ) )
            // InternalPerl.g:3223:2: ( rule__UseInclude__Alternatives_2 )
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2()); 
            // InternalPerl.g:3224:2: ( rule__UseInclude__Alternatives_2 )
            // InternalPerl.g:3224:3: rule__UseInclude__Alternatives_2
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
    // InternalPerl.g:3233:1: rule__UseInclude__Group_2_1__0 : rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1 ;
    public final void rule__UseInclude__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3237:1: ( rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1 )
            // InternalPerl.g:3238:2: rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1
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
    // InternalPerl.g:3245:1: rule__UseInclude__Group_2_1__0__Impl : ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) ) ;
    public final void rule__UseInclude__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3249:1: ( ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) ) )
            // InternalPerl.g:3250:1: ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) )
            {
            // InternalPerl.g:3250:1: ( ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 ) )
            // InternalPerl.g:3251:2: ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 )
            {
             before(grammarAccess.getUseIncludeAccess().getPragmaOrPackageAssignment_2_1_0()); 
            // InternalPerl.g:3252:2: ( rule__UseInclude__PragmaOrPackageAssignment_2_1_0 )
            // InternalPerl.g:3252:3: rule__UseInclude__PragmaOrPackageAssignment_2_1_0
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
    // InternalPerl.g:3260:1: rule__UseInclude__Group_2_1__1 : rule__UseInclude__Group_2_1__1__Impl ;
    public final void rule__UseInclude__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3264:1: ( rule__UseInclude__Group_2_1__1__Impl )
            // InternalPerl.g:3265:2: rule__UseInclude__Group_2_1__1__Impl
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
    // InternalPerl.g:3271:1: rule__UseInclude__Group_2_1__1__Impl : ( ( rule__UseInclude__Alternatives_2_1_1 )? ) ;
    public final void rule__UseInclude__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3275:1: ( ( ( rule__UseInclude__Alternatives_2_1_1 )? ) )
            // InternalPerl.g:3276:1: ( ( rule__UseInclude__Alternatives_2_1_1 )? )
            {
            // InternalPerl.g:3276:1: ( ( rule__UseInclude__Alternatives_2_1_1 )? )
            // InternalPerl.g:3277:2: ( rule__UseInclude__Alternatives_2_1_1 )?
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2_1_1()); 
            // InternalPerl.g:3278:2: ( rule__UseInclude__Alternatives_2_1_1 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_LITERAL)||LA19_0==RULE_WORDS_QUOTE_LIKE) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalPerl.g:3278:3: rule__UseInclude__Alternatives_2_1_1
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
    // InternalPerl.g:3287:1: rule__SubStatement__Group__0 : rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1 ;
    public final void rule__SubStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3291:1: ( rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1 )
            // InternalPerl.g:3292:2: rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1
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
    // InternalPerl.g:3299:1: rule__SubStatement__Group__0__Impl : ( () ) ;
    public final void rule__SubStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3303:1: ( ( () ) )
            // InternalPerl.g:3304:1: ( () )
            {
            // InternalPerl.g:3304:1: ( () )
            // InternalPerl.g:3305:2: ()
            {
             before(grammarAccess.getSubStatementAccess().getSubStatementAction_0()); 
            // InternalPerl.g:3306:2: ()
            // InternalPerl.g:3306:3: 
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
    // InternalPerl.g:3314:1: rule__SubStatement__Group__1 : rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2 ;
    public final void rule__SubStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3318:1: ( rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2 )
            // InternalPerl.g:3319:2: rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2
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
    // InternalPerl.g:3326:1: rule__SubStatement__Group__1__Impl : ( 'sub' ) ;
    public final void rule__SubStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3330:1: ( ( 'sub' ) )
            // InternalPerl.g:3331:1: ( 'sub' )
            {
            // InternalPerl.g:3331:1: ( 'sub' )
            // InternalPerl.g:3332:2: 'sub'
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
    // InternalPerl.g:3341:1: rule__SubStatement__Group__2 : rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3 ;
    public final void rule__SubStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3345:1: ( rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3 )
            // InternalPerl.g:3346:2: rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3
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
    // InternalPerl.g:3353:1: rule__SubStatement__Group__2__Impl : ( ( rule__SubStatement__NameAssignment_2 ) ) ;
    public final void rule__SubStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3357:1: ( ( ( rule__SubStatement__NameAssignment_2 ) ) )
            // InternalPerl.g:3358:1: ( ( rule__SubStatement__NameAssignment_2 ) )
            {
            // InternalPerl.g:3358:1: ( ( rule__SubStatement__NameAssignment_2 ) )
            // InternalPerl.g:3359:2: ( rule__SubStatement__NameAssignment_2 )
            {
             before(grammarAccess.getSubStatementAccess().getNameAssignment_2()); 
            // InternalPerl.g:3360:2: ( rule__SubStatement__NameAssignment_2 )
            // InternalPerl.g:3360:3: rule__SubStatement__NameAssignment_2
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
    // InternalPerl.g:3368:1: rule__SubStatement__Group__3 : rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4 ;
    public final void rule__SubStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3372:1: ( rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4 )
            // InternalPerl.g:3373:2: rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4
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
    // InternalPerl.g:3380:1: rule__SubStatement__Group__3__Impl : ( ( rule__SubStatement__PrototypeAssignment_3 )? ) ;
    public final void rule__SubStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3384:1: ( ( ( rule__SubStatement__PrototypeAssignment_3 )? ) )
            // InternalPerl.g:3385:1: ( ( rule__SubStatement__PrototypeAssignment_3 )? )
            {
            // InternalPerl.g:3385:1: ( ( rule__SubStatement__PrototypeAssignment_3 )? )
            // InternalPerl.g:3386:2: ( rule__SubStatement__PrototypeAssignment_3 )?
            {
             before(grammarAccess.getSubStatementAccess().getPrototypeAssignment_3()); 
            // InternalPerl.g:3387:2: ( rule__SubStatement__PrototypeAssignment_3 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==345) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalPerl.g:3387:3: rule__SubStatement__PrototypeAssignment_3
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
    // InternalPerl.g:3395:1: rule__SubStatement__Group__4 : rule__SubStatement__Group__4__Impl ;
    public final void rule__SubStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3399:1: ( rule__SubStatement__Group__4__Impl )
            // InternalPerl.g:3400:2: rule__SubStatement__Group__4__Impl
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
    // InternalPerl.g:3406:1: rule__SubStatement__Group__4__Impl : ( ( rule__SubStatement__Alternatives_4 ) ) ;
    public final void rule__SubStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3410:1: ( ( ( rule__SubStatement__Alternatives_4 ) ) )
            // InternalPerl.g:3411:1: ( ( rule__SubStatement__Alternatives_4 ) )
            {
            // InternalPerl.g:3411:1: ( ( rule__SubStatement__Alternatives_4 ) )
            // InternalPerl.g:3412:2: ( rule__SubStatement__Alternatives_4 )
            {
             before(grammarAccess.getSubStatementAccess().getAlternatives_4()); 
            // InternalPerl.g:3413:2: ( rule__SubStatement__Alternatives_4 )
            // InternalPerl.g:3413:3: rule__SubStatement__Alternatives_4
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


    // $ANTLR start "rule__BlockStructure__Group__0"
    // InternalPerl.g:3422:1: rule__BlockStructure__Group__0 : rule__BlockStructure__Group__0__Impl rule__BlockStructure__Group__1 ;
    public final void rule__BlockStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3426:1: ( rule__BlockStructure__Group__0__Impl rule__BlockStructure__Group__1 )
            // InternalPerl.g:3427:2: rule__BlockStructure__Group__0__Impl rule__BlockStructure__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__BlockStructure__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BlockStructure__Group__1();

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
    // $ANTLR end "rule__BlockStructure__Group__0"


    // $ANTLR start "rule__BlockStructure__Group__0__Impl"
    // InternalPerl.g:3434:1: rule__BlockStructure__Group__0__Impl : ( () ) ;
    public final void rule__BlockStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3438:1: ( ( () ) )
            // InternalPerl.g:3439:1: ( () )
            {
            // InternalPerl.g:3439:1: ( () )
            // InternalPerl.g:3440:2: ()
            {
             before(grammarAccess.getBlockStructureAccess().getBlockStructureAction_0()); 
            // InternalPerl.g:3441:2: ()
            // InternalPerl.g:3441:3: 
            {
            }

             after(grammarAccess.getBlockStructureAccess().getBlockStructureAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlockStructure__Group__0__Impl"


    // $ANTLR start "rule__BlockStructure__Group__1"
    // InternalPerl.g:3449:1: rule__BlockStructure__Group__1 : rule__BlockStructure__Group__1__Impl rule__BlockStructure__Group__2 ;
    public final void rule__BlockStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3453:1: ( rule__BlockStructure__Group__1__Impl rule__BlockStructure__Group__2 )
            // InternalPerl.g:3454:2: rule__BlockStructure__Group__1__Impl rule__BlockStructure__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__BlockStructure__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BlockStructure__Group__2();

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
    // $ANTLR end "rule__BlockStructure__Group__1"


    // $ANTLR start "rule__BlockStructure__Group__1__Impl"
    // InternalPerl.g:3461:1: rule__BlockStructure__Group__1__Impl : ( '{' ) ;
    public final void rule__BlockStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3465:1: ( ( '{' ) )
            // InternalPerl.g:3466:1: ( '{' )
            {
            // InternalPerl.g:3466:1: ( '{' )
            // InternalPerl.g:3467:2: '{'
            {
             before(grammarAccess.getBlockStructureAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,343,FOLLOW_2); 
             after(grammarAccess.getBlockStructureAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlockStructure__Group__1__Impl"


    // $ANTLR start "rule__BlockStructure__Group__2"
    // InternalPerl.g:3476:1: rule__BlockStructure__Group__2 : rule__BlockStructure__Group__2__Impl rule__BlockStructure__Group__3 ;
    public final void rule__BlockStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3480:1: ( rule__BlockStructure__Group__2__Impl rule__BlockStructure__Group__3 )
            // InternalPerl.g:3481:2: rule__BlockStructure__Group__2__Impl rule__BlockStructure__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__BlockStructure__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BlockStructure__Group__3();

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
    // $ANTLR end "rule__BlockStructure__Group__2"


    // $ANTLR start "rule__BlockStructure__Group__2__Impl"
    // InternalPerl.g:3488:1: rule__BlockStructure__Group__2__Impl : ( ( rule__BlockStructure__StatementsAssignment_2 )* ) ;
    public final void rule__BlockStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3492:1: ( ( ( rule__BlockStructure__StatementsAssignment_2 )* ) )
            // InternalPerl.g:3493:1: ( ( rule__BlockStructure__StatementsAssignment_2 )* )
            {
            // InternalPerl.g:3493:1: ( ( rule__BlockStructure__StatementsAssignment_2 )* )
            // InternalPerl.g:3494:2: ( rule__BlockStructure__StatementsAssignment_2 )*
            {
             before(grammarAccess.getBlockStructureAccess().getStatementsAssignment_2()); 
            // InternalPerl.g:3495:2: ( rule__BlockStructure__StatementsAssignment_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==153||LA21_0==172||LA21_0==216||LA21_0==243) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalPerl.g:3495:3: rule__BlockStructure__StatementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__BlockStructure__StatementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getBlockStructureAccess().getStatementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlockStructure__Group__2__Impl"


    // $ANTLR start "rule__BlockStructure__Group__3"
    // InternalPerl.g:3503:1: rule__BlockStructure__Group__3 : rule__BlockStructure__Group__3__Impl ;
    public final void rule__BlockStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3507:1: ( rule__BlockStructure__Group__3__Impl )
            // InternalPerl.g:3508:2: rule__BlockStructure__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BlockStructure__Group__3__Impl();

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
    // $ANTLR end "rule__BlockStructure__Group__3"


    // $ANTLR start "rule__BlockStructure__Group__3__Impl"
    // InternalPerl.g:3514:1: rule__BlockStructure__Group__3__Impl : ( '}' ) ;
    public final void rule__BlockStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3518:1: ( ( '}' ) )
            // InternalPerl.g:3519:1: ( '}' )
            {
            // InternalPerl.g:3519:1: ( '}' )
            // InternalPerl.g:3520:2: '}'
            {
             before(grammarAccess.getBlockStructureAccess().getRightCurlyBracketKeyword_3()); 
            match(input,344,FOLLOW_2); 
             after(grammarAccess.getBlockStructureAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlockStructure__Group__3__Impl"


    // $ANTLR start "rule__Prototype__Group__0"
    // InternalPerl.g:3530:1: rule__Prototype__Group__0 : rule__Prototype__Group__0__Impl rule__Prototype__Group__1 ;
    public final void rule__Prototype__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3534:1: ( rule__Prototype__Group__0__Impl rule__Prototype__Group__1 )
            // InternalPerl.g:3535:2: rule__Prototype__Group__0__Impl rule__Prototype__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalPerl.g:3542:1: rule__Prototype__Group__0__Impl : ( '(' ) ;
    public final void rule__Prototype__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3546:1: ( ( '(' ) )
            // InternalPerl.g:3547:1: ( '(' )
            {
            // InternalPerl.g:3547:1: ( '(' )
            // InternalPerl.g:3548:2: '('
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
    // InternalPerl.g:3557:1: rule__Prototype__Group__1 : rule__Prototype__Group__1__Impl rule__Prototype__Group__2 ;
    public final void rule__Prototype__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3561:1: ( rule__Prototype__Group__1__Impl rule__Prototype__Group__2 )
            // InternalPerl.g:3562:2: rule__Prototype__Group__1__Impl rule__Prototype__Group__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalPerl.g:3569:1: rule__Prototype__Group__1__Impl : ( ( rule__Prototype__Alternatives_1 )* ) ;
    public final void rule__Prototype__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3573:1: ( ( ( rule__Prototype__Alternatives_1 )* ) )
            // InternalPerl.g:3574:1: ( ( rule__Prototype__Alternatives_1 )* )
            {
            // InternalPerl.g:3574:1: ( ( rule__Prototype__Alternatives_1 )* )
            // InternalPerl.g:3575:2: ( rule__Prototype__Alternatives_1 )*
            {
             before(grammarAccess.getPrototypeAccess().getAlternatives_1()); 
            // InternalPerl.g:3576:2: ( rule__Prototype__Alternatives_1 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=28 && LA22_0<=32)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPerl.g:3576:3: rule__Prototype__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Prototype__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalPerl.g:3584:1: rule__Prototype__Group__2 : rule__Prototype__Group__2__Impl ;
    public final void rule__Prototype__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3588:1: ( rule__Prototype__Group__2__Impl )
            // InternalPerl.g:3589:2: rule__Prototype__Group__2__Impl
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
    // InternalPerl.g:3595:1: rule__Prototype__Group__2__Impl : ( ')' ) ;
    public final void rule__Prototype__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3599:1: ( ( ')' ) )
            // InternalPerl.g:3600:1: ( ')' )
            {
            // InternalPerl.g:3600:1: ( ')' )
            // InternalPerl.g:3601:2: ')'
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
    // InternalPerl.g:3611:1: rule__Token__Group_0__0 : rule__Token__Group_0__0__Impl rule__Token__Group_0__1 ;
    public final void rule__Token__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3615:1: ( rule__Token__Group_0__0__Impl rule__Token__Group_0__1 )
            // InternalPerl.g:3616:2: rule__Token__Group_0__0__Impl rule__Token__Group_0__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalPerl.g:3623:1: rule__Token__Group_0__0__Impl : ( () ) ;
    public final void rule__Token__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3627:1: ( ( () ) )
            // InternalPerl.g:3628:1: ( () )
            {
            // InternalPerl.g:3628:1: ( () )
            // InternalPerl.g:3629:2: ()
            {
             before(grammarAccess.getTokenAccess().getPodTokenAction_0_0()); 
            // InternalPerl.g:3630:2: ()
            // InternalPerl.g:3630:3: 
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
    // InternalPerl.g:3638:1: rule__Token__Group_0__1 : rule__Token__Group_0__1__Impl ;
    public final void rule__Token__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3642:1: ( rule__Token__Group_0__1__Impl )
            // InternalPerl.g:3643:2: rule__Token__Group_0__1__Impl
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
    // InternalPerl.g:3649:1: rule__Token__Group_0__1__Impl : ( ( rule__Token__ContentAssignment_0_1 ) ) ;
    public final void rule__Token__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3653:1: ( ( ( rule__Token__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:3654:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:3654:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            // InternalPerl.g:3655:2: ( rule__Token__ContentAssignment_0_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:3656:2: ( rule__Token__ContentAssignment_0_1 )
            // InternalPerl.g:3656:3: rule__Token__ContentAssignment_0_1
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
    // InternalPerl.g:3665:1: rule__Token__Group_1__0 : rule__Token__Group_1__0__Impl rule__Token__Group_1__1 ;
    public final void rule__Token__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3669:1: ( rule__Token__Group_1__0__Impl rule__Token__Group_1__1 )
            // InternalPerl.g:3670:2: rule__Token__Group_1__0__Impl rule__Token__Group_1__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalPerl.g:3677:1: rule__Token__Group_1__0__Impl : ( () ) ;
    public final void rule__Token__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3681:1: ( ( () ) )
            // InternalPerl.g:3682:1: ( () )
            {
            // InternalPerl.g:3682:1: ( () )
            // InternalPerl.g:3683:2: ()
            {
             before(grammarAccess.getTokenAccess().getNumberTokenAction_1_0()); 
            // InternalPerl.g:3684:2: ()
            // InternalPerl.g:3684:3: 
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
    // InternalPerl.g:3692:1: rule__Token__Group_1__1 : rule__Token__Group_1__1__Impl ;
    public final void rule__Token__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3696:1: ( rule__Token__Group_1__1__Impl )
            // InternalPerl.g:3697:2: rule__Token__Group_1__1__Impl
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
    // InternalPerl.g:3703:1: rule__Token__Group_1__1__Impl : ( ( rule__Token__ContentAssignment_1_1 ) ) ;
    public final void rule__Token__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3707:1: ( ( ( rule__Token__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:3708:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:3708:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            // InternalPerl.g:3709:2: ( rule__Token__ContentAssignment_1_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:3710:2: ( rule__Token__ContentAssignment_1_1 )
            // InternalPerl.g:3710:3: rule__Token__ContentAssignment_1_1
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
    // InternalPerl.g:3719:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3723:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // InternalPerl.g:3724:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalPerl.g:3731:1: rule__Token__Group_2__0__Impl : ( () ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3735:1: ( ( () ) )
            // InternalPerl.g:3736:1: ( () )
            {
            // InternalPerl.g:3736:1: ( () )
            // InternalPerl.g:3737:2: ()
            {
             before(grammarAccess.getTokenAccess().getWordTokenAction_2_0()); 
            // InternalPerl.g:3738:2: ()
            // InternalPerl.g:3738:3: 
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
    // InternalPerl.g:3746:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3750:1: ( rule__Token__Group_2__1__Impl )
            // InternalPerl.g:3751:2: rule__Token__Group_2__1__Impl
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
    // InternalPerl.g:3757:1: rule__Token__Group_2__1__Impl : ( ( rule__Token__ContentAssignment_2_1 ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3761:1: ( ( ( rule__Token__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:3762:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:3762:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            // InternalPerl.g:3763:2: ( rule__Token__ContentAssignment_2_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:3764:2: ( rule__Token__ContentAssignment_2_1 )
            // InternalPerl.g:3764:3: rule__Token__ContentAssignment_2_1
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
    // InternalPerl.g:3773:1: rule__Token__Group_3__0 : rule__Token__Group_3__0__Impl rule__Token__Group_3__1 ;
    public final void rule__Token__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3777:1: ( rule__Token__Group_3__0__Impl rule__Token__Group_3__1 )
            // InternalPerl.g:3778:2: rule__Token__Group_3__0__Impl rule__Token__Group_3__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalPerl.g:3785:1: rule__Token__Group_3__0__Impl : ( () ) ;
    public final void rule__Token__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3789:1: ( ( () ) )
            // InternalPerl.g:3790:1: ( () )
            {
            // InternalPerl.g:3790:1: ( () )
            // InternalPerl.g:3791:2: ()
            {
             before(grammarAccess.getTokenAccess().getSymbolTokenAction_3_0()); 
            // InternalPerl.g:3792:2: ()
            // InternalPerl.g:3792:3: 
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
    // InternalPerl.g:3800:1: rule__Token__Group_3__1 : rule__Token__Group_3__1__Impl ;
    public final void rule__Token__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3804:1: ( rule__Token__Group_3__1__Impl )
            // InternalPerl.g:3805:2: rule__Token__Group_3__1__Impl
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
    // InternalPerl.g:3811:1: rule__Token__Group_3__1__Impl : ( ( rule__Token__ContentAssignment_3_1 ) ) ;
    public final void rule__Token__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3815:1: ( ( ( rule__Token__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:3816:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:3816:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            // InternalPerl.g:3817:2: ( rule__Token__ContentAssignment_3_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:3818:2: ( rule__Token__ContentAssignment_3_1 )
            // InternalPerl.g:3818:3: rule__Token__ContentAssignment_3_1
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
    // InternalPerl.g:3827:1: rule__Token__Group_5__0 : rule__Token__Group_5__0__Impl rule__Token__Group_5__1 ;
    public final void rule__Token__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3831:1: ( rule__Token__Group_5__0__Impl rule__Token__Group_5__1 )
            // InternalPerl.g:3832:2: rule__Token__Group_5__0__Impl rule__Token__Group_5__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalPerl.g:3839:1: rule__Token__Group_5__0__Impl : ( () ) ;
    public final void rule__Token__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3843:1: ( ( () ) )
            // InternalPerl.g:3844:1: ( () )
            {
            // InternalPerl.g:3844:1: ( () )
            // InternalPerl.g:3845:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_5_0()); 
            // InternalPerl.g:3846:2: ()
            // InternalPerl.g:3846:3: 
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
    // InternalPerl.g:3854:1: rule__Token__Group_5__1 : rule__Token__Group_5__1__Impl ;
    public final void rule__Token__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3858:1: ( rule__Token__Group_5__1__Impl )
            // InternalPerl.g:3859:2: rule__Token__Group_5__1__Impl
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
    // InternalPerl.g:3865:1: rule__Token__Group_5__1__Impl : ( ( rule__Token__ContentAssignment_5_1 ) ) ;
    public final void rule__Token__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3869:1: ( ( ( rule__Token__ContentAssignment_5_1 ) ) )
            // InternalPerl.g:3870:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            {
            // InternalPerl.g:3870:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            // InternalPerl.g:3871:2: ( rule__Token__ContentAssignment_5_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_5_1()); 
            // InternalPerl.g:3872:2: ( rule__Token__ContentAssignment_5_1 )
            // InternalPerl.g:3872:3: rule__Token__ContentAssignment_5_1
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
    // InternalPerl.g:3881:1: rule__Token__Group_6__0 : rule__Token__Group_6__0__Impl rule__Token__Group_6__1 ;
    public final void rule__Token__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3885:1: ( rule__Token__Group_6__0__Impl rule__Token__Group_6__1 )
            // InternalPerl.g:3886:2: rule__Token__Group_6__0__Impl rule__Token__Group_6__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalPerl.g:3893:1: rule__Token__Group_6__0__Impl : ( () ) ;
    public final void rule__Token__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3897:1: ( ( () ) )
            // InternalPerl.g:3898:1: ( () )
            {
            // InternalPerl.g:3898:1: ( () )
            // InternalPerl.g:3899:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_6_0()); 
            // InternalPerl.g:3900:2: ()
            // InternalPerl.g:3900:3: 
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
    // InternalPerl.g:3908:1: rule__Token__Group_6__1 : rule__Token__Group_6__1__Impl ;
    public final void rule__Token__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3912:1: ( rule__Token__Group_6__1__Impl )
            // InternalPerl.g:3913:2: rule__Token__Group_6__1__Impl
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
    // InternalPerl.g:3919:1: rule__Token__Group_6__1__Impl : ( ( rule__Token__ContentAssignment_6_1 ) ) ;
    public final void rule__Token__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3923:1: ( ( ( rule__Token__ContentAssignment_6_1 ) ) )
            // InternalPerl.g:3924:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            {
            // InternalPerl.g:3924:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            // InternalPerl.g:3925:2: ( rule__Token__ContentAssignment_6_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_6_1()); 
            // InternalPerl.g:3926:2: ( rule__Token__ContentAssignment_6_1 )
            // InternalPerl.g:3926:3: rule__Token__ContentAssignment_6_1
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
    // InternalPerl.g:3935:1: rule__Token__Group_9__0 : rule__Token__Group_9__0__Impl rule__Token__Group_9__1 ;
    public final void rule__Token__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3939:1: ( rule__Token__Group_9__0__Impl rule__Token__Group_9__1 )
            // InternalPerl.g:3940:2: rule__Token__Group_9__0__Impl rule__Token__Group_9__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalPerl.g:3947:1: rule__Token__Group_9__0__Impl : ( () ) ;
    public final void rule__Token__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3951:1: ( ( () ) )
            // InternalPerl.g:3952:1: ( () )
            {
            // InternalPerl.g:3952:1: ( () )
            // InternalPerl.g:3953:2: ()
            {
             before(grammarAccess.getTokenAccess().getDataTokenAction_9_0()); 
            // InternalPerl.g:3954:2: ()
            // InternalPerl.g:3954:3: 
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
    // InternalPerl.g:3962:1: rule__Token__Group_9__1 : rule__Token__Group_9__1__Impl ;
    public final void rule__Token__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3966:1: ( rule__Token__Group_9__1__Impl )
            // InternalPerl.g:3967:2: rule__Token__Group_9__1__Impl
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
    // InternalPerl.g:3973:1: rule__Token__Group_9__1__Impl : ( ( rule__Token__ContentAssignment_9_1 ) ) ;
    public final void rule__Token__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3977:1: ( ( ( rule__Token__ContentAssignment_9_1 ) ) )
            // InternalPerl.g:3978:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            {
            // InternalPerl.g:3978:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            // InternalPerl.g:3979:2: ( rule__Token__ContentAssignment_9_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_9_1()); 
            // InternalPerl.g:3980:2: ( rule__Token__ContentAssignment_9_1 )
            // InternalPerl.g:3980:3: rule__Token__ContentAssignment_9_1
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
    // InternalPerl.g:3989:1: rule__Token__Group_10__0 : rule__Token__Group_10__0__Impl rule__Token__Group_10__1 ;
    public final void rule__Token__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3993:1: ( rule__Token__Group_10__0__Impl rule__Token__Group_10__1 )
            // InternalPerl.g:3994:2: rule__Token__Group_10__0__Impl rule__Token__Group_10__1
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
    // InternalPerl.g:4001:1: rule__Token__Group_10__0__Impl : ( () ) ;
    public final void rule__Token__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4005:1: ( ( () ) )
            // InternalPerl.g:4006:1: ( () )
            {
            // InternalPerl.g:4006:1: ( () )
            // InternalPerl.g:4007:2: ()
            {
             before(grammarAccess.getTokenAccess().getEndTokenAction_10_0()); 
            // InternalPerl.g:4008:2: ()
            // InternalPerl.g:4008:3: 
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
    // InternalPerl.g:4016:1: rule__Token__Group_10__1 : rule__Token__Group_10__1__Impl ;
    public final void rule__Token__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4020:1: ( rule__Token__Group_10__1__Impl )
            // InternalPerl.g:4021:2: rule__Token__Group_10__1__Impl
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
    // InternalPerl.g:4027:1: rule__Token__Group_10__1__Impl : ( ( rule__Token__ContentAssignment_10_1 ) ) ;
    public final void rule__Token__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4031:1: ( ( ( rule__Token__ContentAssignment_10_1 ) ) )
            // InternalPerl.g:4032:1: ( ( rule__Token__ContentAssignment_10_1 ) )
            {
            // InternalPerl.g:4032:1: ( ( rule__Token__ContentAssignment_10_1 ) )
            // InternalPerl.g:4033:2: ( rule__Token__ContentAssignment_10_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_10_1()); 
            // InternalPerl.g:4034:2: ( rule__Token__ContentAssignment_10_1 )
            // InternalPerl.g:4034:3: rule__Token__ContentAssignment_10_1
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


    // $ANTLR start "rule__QuoteToken__Group__0"
    // InternalPerl.g:4043:1: rule__QuoteToken__Group__0 : rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 ;
    public final void rule__QuoteToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4047:1: ( rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 )
            // InternalPerl.g:4048:2: rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1
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
    // InternalPerl.g:4055:1: rule__QuoteToken__Group__0__Impl : ( () ) ;
    public final void rule__QuoteToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4059:1: ( ( () ) )
            // InternalPerl.g:4060:1: ( () )
            {
            // InternalPerl.g:4060:1: ( () )
            // InternalPerl.g:4061:2: ()
            {
             before(grammarAccess.getQuoteTokenAccess().getQuoteTokenAction_0()); 
            // InternalPerl.g:4062:2: ()
            // InternalPerl.g:4062:3: 
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
    // InternalPerl.g:4070:1: rule__QuoteToken__Group__1 : rule__QuoteToken__Group__1__Impl ;
    public final void rule__QuoteToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4074:1: ( rule__QuoteToken__Group__1__Impl )
            // InternalPerl.g:4075:2: rule__QuoteToken__Group__1__Impl
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
    // InternalPerl.g:4081:1: rule__QuoteToken__Group__1__Impl : ( ( rule__QuoteToken__ContentAssignment_1 ) ) ;
    public final void rule__QuoteToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4085:1: ( ( ( rule__QuoteToken__ContentAssignment_1 ) ) )
            // InternalPerl.g:4086:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            {
            // InternalPerl.g:4086:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            // InternalPerl.g:4087:2: ( rule__QuoteToken__ContentAssignment_1 )
            {
             before(grammarAccess.getQuoteTokenAccess().getContentAssignment_1()); 
            // InternalPerl.g:4088:2: ( rule__QuoteToken__ContentAssignment_1 )
            // InternalPerl.g:4088:3: rule__QuoteToken__ContentAssignment_1
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


    // $ANTLR start "rule__RegexToken__Group__0"
    // InternalPerl.g:4097:1: rule__RegexToken__Group__0 : rule__RegexToken__Group__0__Impl rule__RegexToken__Group__1 ;
    public final void rule__RegexToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4101:1: ( rule__RegexToken__Group__0__Impl rule__RegexToken__Group__1 )
            // InternalPerl.g:4102:2: rule__RegexToken__Group__0__Impl rule__RegexToken__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalPerl.g:4109:1: rule__RegexToken__Group__0__Impl : ( () ) ;
    public final void rule__RegexToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4113:1: ( ( () ) )
            // InternalPerl.g:4114:1: ( () )
            {
            // InternalPerl.g:4114:1: ( () )
            // InternalPerl.g:4115:2: ()
            {
             before(grammarAccess.getRegexTokenAccess().getRegexTokenAction_0()); 
            // InternalPerl.g:4116:2: ()
            // InternalPerl.g:4116:3: 
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
    // InternalPerl.g:4124:1: rule__RegexToken__Group__1 : rule__RegexToken__Group__1__Impl ;
    public final void rule__RegexToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4128:1: ( rule__RegexToken__Group__1__Impl )
            // InternalPerl.g:4129:2: rule__RegexToken__Group__1__Impl
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
    // InternalPerl.g:4135:1: rule__RegexToken__Group__1__Impl : ( ( rule__RegexToken__ContentAssignment_1 ) ) ;
    public final void rule__RegexToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4139:1: ( ( ( rule__RegexToken__ContentAssignment_1 ) ) )
            // InternalPerl.g:4140:1: ( ( rule__RegexToken__ContentAssignment_1 ) )
            {
            // InternalPerl.g:4140:1: ( ( rule__RegexToken__ContentAssignment_1 ) )
            // InternalPerl.g:4141:2: ( rule__RegexToken__ContentAssignment_1 )
            {
             before(grammarAccess.getRegexTokenAccess().getContentAssignment_1()); 
            // InternalPerl.g:4142:2: ( rule__RegexToken__ContentAssignment_1 )
            // InternalPerl.g:4142:3: rule__RegexToken__ContentAssignment_1
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


    // $ANTLR start "rule__QuoteLikeToken__Group_0__0"
    // InternalPerl.g:4151:1: rule__QuoteLikeToken__Group_0__0 : rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 ;
    public final void rule__QuoteLikeToken__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4155:1: ( rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 )
            // InternalPerl.g:4156:2: rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalPerl.g:4163:1: rule__QuoteLikeToken__Group_0__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4167:1: ( ( () ) )
            // InternalPerl.g:4168:1: ( () )
            {
            // InternalPerl.g:4168:1: ( () )
            // InternalPerl.g:4169:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0()); 
            // InternalPerl.g:4170:2: ()
            // InternalPerl.g:4170:3: 
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
    // InternalPerl.g:4178:1: rule__QuoteLikeToken__Group_0__1 : rule__QuoteLikeToken__Group_0__1__Impl ;
    public final void rule__QuoteLikeToken__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4182:1: ( rule__QuoteLikeToken__Group_0__1__Impl )
            // InternalPerl.g:4183:2: rule__QuoteLikeToken__Group_0__1__Impl
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
    // InternalPerl.g:4189:1: rule__QuoteLikeToken__Group_0__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4193:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:4194:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:4194:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            // InternalPerl.g:4195:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:4196:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            // InternalPerl.g:4196:3: rule__QuoteLikeToken__ContentAssignment_0_1
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
    // InternalPerl.g:4205:1: rule__QuoteLikeToken__Group_1__0 : rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 ;
    public final void rule__QuoteLikeToken__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4209:1: ( rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 )
            // InternalPerl.g:4210:2: rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalPerl.g:4217:1: rule__QuoteLikeToken__Group_1__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4221:1: ( ( () ) )
            // InternalPerl.g:4222:1: ( () )
            {
            // InternalPerl.g:4222:1: ( () )
            // InternalPerl.g:4223:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0()); 
            // InternalPerl.g:4224:2: ()
            // InternalPerl.g:4224:3: 
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
    // InternalPerl.g:4232:1: rule__QuoteLikeToken__Group_1__1 : rule__QuoteLikeToken__Group_1__1__Impl ;
    public final void rule__QuoteLikeToken__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4236:1: ( rule__QuoteLikeToken__Group_1__1__Impl )
            // InternalPerl.g:4237:2: rule__QuoteLikeToken__Group_1__1__Impl
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
    // InternalPerl.g:4243:1: rule__QuoteLikeToken__Group_1__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4247:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:4248:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:4248:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            // InternalPerl.g:4249:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:4250:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            // InternalPerl.g:4250:3: rule__QuoteLikeToken__ContentAssignment_1_1
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
    // InternalPerl.g:4259:1: rule__QuoteLikeToken__Group_2__0 : rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 ;
    public final void rule__QuoteLikeToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4263:1: ( rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 )
            // InternalPerl.g:4264:2: rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalPerl.g:4271:1: rule__QuoteLikeToken__Group_2__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4275:1: ( ( () ) )
            // InternalPerl.g:4276:1: ( () )
            {
            // InternalPerl.g:4276:1: ( () )
            // InternalPerl.g:4277:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0()); 
            // InternalPerl.g:4278:2: ()
            // InternalPerl.g:4278:3: 
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
    // InternalPerl.g:4286:1: rule__QuoteLikeToken__Group_2__1 : rule__QuoteLikeToken__Group_2__1__Impl ;
    public final void rule__QuoteLikeToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4290:1: ( rule__QuoteLikeToken__Group_2__1__Impl )
            // InternalPerl.g:4291:2: rule__QuoteLikeToken__Group_2__1__Impl
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
    // InternalPerl.g:4297:1: rule__QuoteLikeToken__Group_2__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4301:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:4302:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:4302:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            // InternalPerl.g:4303:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:4304:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            // InternalPerl.g:4304:3: rule__QuoteLikeToken__ContentAssignment_2_1
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
    // InternalPerl.g:4313:1: rule__QuoteLikeToken__Group_3__0 : rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 ;
    public final void rule__QuoteLikeToken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4317:1: ( rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 )
            // InternalPerl.g:4318:2: rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalPerl.g:4325:1: rule__QuoteLikeToken__Group_3__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4329:1: ( ( () ) )
            // InternalPerl.g:4330:1: ( () )
            {
            // InternalPerl.g:4330:1: ( () )
            // InternalPerl.g:4331:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0()); 
            // InternalPerl.g:4332:2: ()
            // InternalPerl.g:4332:3: 
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
    // InternalPerl.g:4340:1: rule__QuoteLikeToken__Group_3__1 : rule__QuoteLikeToken__Group_3__1__Impl ;
    public final void rule__QuoteLikeToken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4344:1: ( rule__QuoteLikeToken__Group_3__1__Impl )
            // InternalPerl.g:4345:2: rule__QuoteLikeToken__Group_3__1__Impl
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
    // InternalPerl.g:4351:1: rule__QuoteLikeToken__Group_3__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4355:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:4356:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:4356:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            // InternalPerl.g:4357:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:4358:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            // InternalPerl.g:4358:3: rule__QuoteLikeToken__ContentAssignment_3_1
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
    // InternalPerl.g:4367:1: rule__QuoteLikeToken__Group_4__0 : rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 ;
    public final void rule__QuoteLikeToken__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4371:1: ( rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 )
            // InternalPerl.g:4372:2: rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalPerl.g:4379:1: rule__QuoteLikeToken__Group_4__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4383:1: ( ( () ) )
            // InternalPerl.g:4384:1: ( () )
            {
            // InternalPerl.g:4384:1: ( () )
            // InternalPerl.g:4385:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0()); 
            // InternalPerl.g:4386:2: ()
            // InternalPerl.g:4386:3: 
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
    // InternalPerl.g:4394:1: rule__QuoteLikeToken__Group_4__1 : rule__QuoteLikeToken__Group_4__1__Impl ;
    public final void rule__QuoteLikeToken__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4398:1: ( rule__QuoteLikeToken__Group_4__1__Impl )
            // InternalPerl.g:4399:2: rule__QuoteLikeToken__Group_4__1__Impl
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
    // InternalPerl.g:4405:1: rule__QuoteLikeToken__Group_4__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4409:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) )
            // InternalPerl.g:4410:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            {
            // InternalPerl.g:4410:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            // InternalPerl.g:4411:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_4_1()); 
            // InternalPerl.g:4412:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            // InternalPerl.g:4412:3: rule__QuoteLikeToken__ContentAssignment_4_1
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
    // InternalPerl.g:4421:1: rule__Operator__Group_23__0 : rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 ;
    public final void rule__Operator__Group_23__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4425:1: ( rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 )
            // InternalPerl.g:4426:2: rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalPerl.g:4433:1: rule__Operator__Group_23__0__Impl : ( '<=>' ) ;
    public final void rule__Operator__Group_23__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4437:1: ( ( '<=>' ) )
            // InternalPerl.g:4438:1: ( '<=>' )
            {
            // InternalPerl.g:4438:1: ( '<=>' )
            // InternalPerl.g:4439:2: '<=>'
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
    // InternalPerl.g:4448:1: rule__Operator__Group_23__1 : rule__Operator__Group_23__1__Impl ;
    public final void rule__Operator__Group_23__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4452:1: ( rule__Operator__Group_23__1__Impl )
            // InternalPerl.g:4453:2: rule__Operator__Group_23__1__Impl
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
    // InternalPerl.g:4459:1: rule__Operator__Group_23__1__Impl : ( '.' ) ;
    public final void rule__Operator__Group_23__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4463:1: ( ( '.' ) )
            // InternalPerl.g:4464:1: ( '.' )
            {
            // InternalPerl.g:4464:1: ( '.' )
            // InternalPerl.g:4465:2: '.'
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
    // InternalPerl.g:4475:1: rule__PerlDocument__ElementsAssignment_1 : ( ruleElement ) ;
    public final void rule__PerlDocument__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4479:1: ( ( ruleElement ) )
            // InternalPerl.g:4480:2: ( ruleElement )
            {
            // InternalPerl.g:4480:2: ( ruleElement )
            // InternalPerl.g:4481:3: ruleElement
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
    // InternalPerl.g:4490:1: rule__PackageStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4494:1: ( ( RULE_ID ) )
            // InternalPerl.g:4495:2: ( RULE_ID )
            {
            // InternalPerl.g:4495:2: ( RULE_ID )
            // InternalPerl.g:4496:3: RULE_ID
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
    // InternalPerl.g:4505:1: rule__PackageStatement__VersionAssignment_3 : ( RULE_VERSION ) ;
    public final void rule__PackageStatement__VersionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4509:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4510:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4510:2: ( RULE_VERSION )
            // InternalPerl.g:4511:3: RULE_VERSION
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
    // InternalPerl.g:4520:1: rule__RequireInclude__VersionAssignment_1 : ( RULE_VERSION ) ;
    public final void rule__RequireInclude__VersionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4524:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4525:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4525:2: ( RULE_VERSION )
            // InternalPerl.g:4526:3: RULE_VERSION
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
    // InternalPerl.g:4535:1: rule__UseInclude__VersionAssignment_2_0 : ( RULE_VERSION ) ;
    public final void rule__UseInclude__VersionAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4539:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4540:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4540:2: ( RULE_VERSION )
            // InternalPerl.g:4541:3: RULE_VERSION
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
    // InternalPerl.g:4550:1: rule__UseInclude__PragmaOrPackageAssignment_2_1_0 : ( RULE_ID ) ;
    public final void rule__UseInclude__PragmaOrPackageAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4554:1: ( ( RULE_ID ) )
            // InternalPerl.g:4555:2: ( RULE_ID )
            {
            // InternalPerl.g:4555:2: ( RULE_ID )
            // InternalPerl.g:4556:3: RULE_ID
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
    // InternalPerl.g:4565:1: rule__UseInclude__StringArgumentAssignment_2_1_1_0 : ( ruleQuoteToken ) ;
    public final void rule__UseInclude__StringArgumentAssignment_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4569:1: ( ( ruleQuoteToken ) )
            // InternalPerl.g:4570:2: ( ruleQuoteToken )
            {
            // InternalPerl.g:4570:2: ( ruleQuoteToken )
            // InternalPerl.g:4571:3: ruleQuoteToken
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
    // InternalPerl.g:4580:1: rule__UseInclude__QwArgumentAssignment_2_1_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__UseInclude__QwArgumentAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4584:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:4585:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:4585:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:4586:3: RULE_WORDS_QUOTE_LIKE
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
    // InternalPerl.g:4595:1: rule__SubStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SubStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4599:1: ( ( RULE_ID ) )
            // InternalPerl.g:4600:2: ( RULE_ID )
            {
            // InternalPerl.g:4600:2: ( RULE_ID )
            // InternalPerl.g:4601:3: RULE_ID
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
    // InternalPerl.g:4610:1: rule__SubStatement__PrototypeAssignment_3 : ( rulePrototype ) ;
    public final void rule__SubStatement__PrototypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4614:1: ( ( rulePrototype ) )
            // InternalPerl.g:4615:2: ( rulePrototype )
            {
            // InternalPerl.g:4615:2: ( rulePrototype )
            // InternalPerl.g:4616:3: rulePrototype
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
    // InternalPerl.g:4625:1: rule__SubStatement__BlockAssignment_4_1 : ( ruleBlockStructure ) ;
    public final void rule__SubStatement__BlockAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4629:1: ( ( ruleBlockStructure ) )
            // InternalPerl.g:4630:2: ( ruleBlockStructure )
            {
            // InternalPerl.g:4630:2: ( ruleBlockStructure )
            // InternalPerl.g:4631:3: ruleBlockStructure
            {
             before(grammarAccess.getSubStatementAccess().getBlockBlockStructureParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBlockStructure();

            state._fsp--;

             after(grammarAccess.getSubStatementAccess().getBlockBlockStructureParserRuleCall_4_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__BlockStructure__StatementsAssignment_2"
    // InternalPerl.g:4640:1: rule__BlockStructure__StatementsAssignment_2 : ( ruleStatementNode ) ;
    public final void rule__BlockStructure__StatementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4644:1: ( ( ruleStatementNode ) )
            // InternalPerl.g:4645:2: ( ruleStatementNode )
            {
            // InternalPerl.g:4645:2: ( ruleStatementNode )
            // InternalPerl.g:4646:3: ruleStatementNode
            {
             before(grammarAccess.getBlockStructureAccess().getStatementsStatementNodeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStatementNode();

            state._fsp--;

             after(grammarAccess.getBlockStructureAccess().getStatementsStatementNodeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlockStructure__StatementsAssignment_2"


    // $ANTLR start "rule__Token__ContentAssignment_0_1"
    // InternalPerl.g:4655:1: rule__Token__ContentAssignment_0_1 : ( RULE_POD ) ;
    public final void rule__Token__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4659:1: ( ( RULE_POD ) )
            // InternalPerl.g:4660:2: ( RULE_POD )
            {
            // InternalPerl.g:4660:2: ( RULE_POD )
            // InternalPerl.g:4661:3: RULE_POD
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
    // InternalPerl.g:4670:1: rule__Token__ContentAssignment_1_1 : ( RULE_NUMBER ) ;
    public final void rule__Token__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4674:1: ( ( RULE_NUMBER ) )
            // InternalPerl.g:4675:2: ( RULE_NUMBER )
            {
            // InternalPerl.g:4675:2: ( RULE_NUMBER )
            // InternalPerl.g:4676:3: RULE_NUMBER
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
    // InternalPerl.g:4685:1: rule__Token__ContentAssignment_2_1 : ( ruleWord ) ;
    public final void rule__Token__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4689:1: ( ( ruleWord ) )
            // InternalPerl.g:4690:2: ( ruleWord )
            {
            // InternalPerl.g:4690:2: ( ruleWord )
            // InternalPerl.g:4691:3: ruleWord
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
    // InternalPerl.g:4700:1: rule__Token__ContentAssignment_3_1 : ( RULE_SYMBOL ) ;
    public final void rule__Token__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4704:1: ( ( RULE_SYMBOL ) )
            // InternalPerl.g:4705:2: ( RULE_SYMBOL )
            {
            // InternalPerl.g:4705:2: ( RULE_SYMBOL )
            // InternalPerl.g:4706:3: RULE_SYMBOL
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
    // InternalPerl.g:4715:1: rule__Token__ContentAssignment_5_1 : ( ruleFileTestOperator ) ;
    public final void rule__Token__ContentAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4719:1: ( ( ruleFileTestOperator ) )
            // InternalPerl.g:4720:2: ( ruleFileTestOperator )
            {
            // InternalPerl.g:4720:2: ( ruleFileTestOperator )
            // InternalPerl.g:4721:3: ruleFileTestOperator
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
    // InternalPerl.g:4730:1: rule__Token__ContentAssignment_6_1 : ( ruleOperator ) ;
    public final void rule__Token__ContentAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4734:1: ( ( ruleOperator ) )
            // InternalPerl.g:4735:2: ( ruleOperator )
            {
            // InternalPerl.g:4735:2: ( ruleOperator )
            // InternalPerl.g:4736:3: ruleOperator
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
    // InternalPerl.g:4745:1: rule__Token__ContentAssignment_9_1 : ( RULE_DATA ) ;
    public final void rule__Token__ContentAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4749:1: ( ( RULE_DATA ) )
            // InternalPerl.g:4750:2: ( RULE_DATA )
            {
            // InternalPerl.g:4750:2: ( RULE_DATA )
            // InternalPerl.g:4751:3: RULE_DATA
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
    // InternalPerl.g:4760:1: rule__Token__ContentAssignment_10_1 : ( RULE_END ) ;
    public final void rule__Token__ContentAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4764:1: ( ( RULE_END ) )
            // InternalPerl.g:4765:2: ( RULE_END )
            {
            // InternalPerl.g:4765:2: ( RULE_END )
            // InternalPerl.g:4766:3: RULE_END
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


    // $ANTLR start "rule__QuoteToken__ContentAssignment_1"
    // InternalPerl.g:4775:1: rule__QuoteToken__ContentAssignment_1 : ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) ;
    public final void rule__QuoteToken__ContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4779:1: ( ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) )
            // InternalPerl.g:4780:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            {
            // InternalPerl.g:4780:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            // InternalPerl.g:4781:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            {
             before(grammarAccess.getQuoteTokenAccess().getContentAlternatives_1_0()); 
            // InternalPerl.g:4782:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            // InternalPerl.g:4782:4: rule__QuoteToken__ContentAlternatives_1_0
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


    // $ANTLR start "rule__RegexToken__ContentAssignment_1"
    // InternalPerl.g:4790:1: rule__RegexToken__ContentAssignment_1 : ( ( rule__RegexToken__ContentAlternatives_1_0 ) ) ;
    public final void rule__RegexToken__ContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4794:1: ( ( ( rule__RegexToken__ContentAlternatives_1_0 ) ) )
            // InternalPerl.g:4795:2: ( ( rule__RegexToken__ContentAlternatives_1_0 ) )
            {
            // InternalPerl.g:4795:2: ( ( rule__RegexToken__ContentAlternatives_1_0 ) )
            // InternalPerl.g:4796:3: ( rule__RegexToken__ContentAlternatives_1_0 )
            {
             before(grammarAccess.getRegexTokenAccess().getContentAlternatives_1_0()); 
            // InternalPerl.g:4797:3: ( rule__RegexToken__ContentAlternatives_1_0 )
            // InternalPerl.g:4797:4: rule__RegexToken__ContentAlternatives_1_0
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


    // $ANTLR start "rule__QuoteLikeToken__ContentAssignment_0_1"
    // InternalPerl.g:4805:1: rule__QuoteLikeToken__ContentAssignment_0_1 : ( RULE_BACKTICK_STRING ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4809:1: ( ( RULE_BACKTICK_STRING ) )
            // InternalPerl.g:4810:2: ( RULE_BACKTICK_STRING )
            {
            // InternalPerl.g:4810:2: ( RULE_BACKTICK_STRING )
            // InternalPerl.g:4811:3: RULE_BACKTICK_STRING
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
    // InternalPerl.g:4820:1: rule__QuoteLikeToken__ContentAssignment_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4824:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:4825:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:4825:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:4826:3: RULE_WORDS_QUOTE_LIKE
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
    // InternalPerl.g:4835:1: rule__QuoteLikeToken__ContentAssignment_2_1 : ( RULE_COMMAND_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4839:1: ( ( RULE_COMMAND_QUOTE_LIKE ) )
            // InternalPerl.g:4840:2: ( RULE_COMMAND_QUOTE_LIKE )
            {
            // InternalPerl.g:4840:2: ( RULE_COMMAND_QUOTE_LIKE )
            // InternalPerl.g:4841:3: RULE_COMMAND_QUOTE_LIKE
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
    // InternalPerl.g:4850:1: rule__QuoteLikeToken__ContentAssignment_3_1 : ( RULE_REGEX_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4854:1: ( ( RULE_REGEX_QUOTE ) )
            // InternalPerl.g:4855:2: ( RULE_REGEX_QUOTE )
            {
            // InternalPerl.g:4855:2: ( RULE_REGEX_QUOTE )
            // InternalPerl.g:4856:3: RULE_REGEX_QUOTE
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
    // InternalPerl.g:4865:1: rule__QuoteLikeToken__ContentAssignment_4_1 : ( RULE_READLINE_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4869:1: ( ( RULE_READLINE_QUOTE ) )
            // InternalPerl.g:4870:2: ( RULE_READLINE_QUOTE )
            {
            // InternalPerl.g:4870:2: ( RULE_READLINE_QUOTE )
            // InternalPerl.g:4871:3: RULE_READLINE_QUOTE
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFFFFF403FF3F0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x0000000008FFFFFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFF403FF3F2L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x0000000008FFFFFFL});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100002000000L,0x0008000001000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000001070L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000000L,0x0000100002000000L,0x0008000001000000L,0x0000000000000000L,0x0000000002800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100002000000L,0x0008000001000000L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100002000000L,0x0008000001000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000100002000000L,0x0008000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000001F0000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000001F0000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xFFFFFFFE00000000L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x7FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xF000000000000000L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000140000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L,0x0FFFFFFFFFFFFFFFL,0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000000003C1000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000010000000L});

}