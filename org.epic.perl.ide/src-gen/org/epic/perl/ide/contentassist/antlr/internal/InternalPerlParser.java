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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_POD", "RULE_STRING", "RULE_INTERPOLATE", "RULE_LITERAL", "RULE_DATA", "RULE_END", "RULE_BACKTICK_STRING", "RULE_WORDS_QUOTE_LIKE", "RULE_COMMAND_QUOTE_LIKE", "RULE_REGEX_QUOTE", "RULE_READLINE_QUOTE", "RULE_ANY_OTHER", "RULE_SL_COMMENT", "RULE_WS", "'abs'", "'accept'", "'alarm'", "'atan2'", "'bind'", "'binmode'", "'bless'", "'break'", "'caller'", "'chdir'", "'chmod'", "'chomp'", "'chop'", "'chown'", "'chr'", "'chroot'", "'close'", "'closedir'", "'connect'", "'continue'", "'cos'", "'crypt'", "'dbmclose'", "'dbmopen'", "'default'", "'defined'", "'delete'", "'die'", "'do'", "'dump'", "'each'", "'else'", "'elsif'", "'endgrent'", "'endhostent'", "'endnetent'", "'endprotoent'", "'endpwent'", "'endservent'", "'eof'", "'eval'", "'evalbytes'", "'exec'", "'exists'", "'exit'", "'exp'", "'fc'", "'fcntl'", "'fileno'", "'flock'", "'for'", "'foreach'", "'fork'", "'format'", "'formline'", "'getc'", "'getgrent'", "'getgrgid'", "'getgrnam'", "'gethostbyaddr'", "'gethostbyname'", "'gethostent'", "'getlogin'", "'getnetbyaddr'", "'getnetbyname'", "'getnetent'", "'getpeername'", "'getpgrp'", "'getppid'", "'getpriority'", "'getprotobyname'", "'getprotobynumber'", "'getprotoent'", "'getpwent'", "'getpwnam'", "'getpwuid'", "'getservbyname'", "'getservbyport'", "'getservent'", "'getsockname'", "'getsockopt'", "'given'", "'glob'", "'gmtime'", "'goto'", "'grep'", "'hex'", "'if'", "'index'", "'int'", "'ioctl'", "'join'", "'keys'", "'kill'", "'last'", "'lc'", "'lcfirst'", "'length'", "'link'", "'listen'", "'local'", "'localtime'", "'lock'", "'log'", "'lstat'", "'map'", "'mkdir'", "'msgctl'", "'msgget'", "'msgrcv'", "'msgsnd'", "'my'", "'next'", "'no'", "'oct'", "'open'", "'opendir'", "'ord'", "'our'", "'pack'", "'package'", "'pipe'", "'pop'", "'pos'", "'print'", "'printf'", "'prototype'", "'push'", "'quotemeta'", "'rand'", "'read'", "'readdir'", "'readline'", "'readlink'", "'readpipe'", "'recv'", "'redo'", "'ref'", "'rename'", "'require'", "'reset'", "'return'", "'reverse'", "'rewinddir'", "'rindex'", "'rmdir'", "'say'", "'scalar'", "'seek'", "'seekdir'", "'select'", "'semctl'", "'semget'", "'semop'", "'send'", "'setgrent'", "'sethostent'", "'setnetent'", "'setpgrp'", "'setpriority'", "'setprotoent'", "'setpwent'", "'setservent'", "'setsockopt'", "'shift'", "'shmctl'", "'shmget'", "'shmread'", "'shmwrite'", "'shutdown'", "'sin'", "'sleep'", "'socket'", "'socketpair'", "'sort'", "'splice'", "'split'", "'sprintf'", "'sqrt'", "'srand'", "'stat'", "'state'", "'study'", "'sub'", "'substr'", "'symlink'", "'syscall'", "'sysopen'", "'sysread'", "'sysseek'", "'system'", "'syswrite'", "'tell'", "'telldir'", "'tie'", "'tied'", "'time'", "'times'", "'tr'", "'truncate'", "'uc'", "'ucfirst'", "'umask'", "'undef'", "'unless'", "'unlink'", "'unpack'", "'unshift'", "'untie'", "'until'", "'use'", "'utime'", "'values'", "'vec'", "'wait'", "'waitpid'", "'wantarray'", "'warn'", "'when'", "'while'", "'write'", "'y'", "'++'", "'--'", "'**'", "'!'", "'~'", "'+'", "'-'", "'=~'", "'!~'", "'*'", "'/'", "'%'", "'x'", "'<<'", "'>>'", "'lt'", "'gt'", "'le'", "'ge'", "'cmp'", "'~~'", "'=='", "'!='", "'..'", "'...'", "','", "'&'", "'|'", "'^'", "'&&'", "'||'", "'//'", "'?'", "':'", "'**='", "'+='", "'-='", "'.='", "'*='", "'/='", "'%='", "'x='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'&&='", "'||='", "'//='", "'<'", "'>'", "'<='", "'>='", "'<>'", "'=>'", "'->'", "'and'", "'or'", "'xor'", "'not'", "'eq'", "'ne'", "'-r'", "'-w'", "'-x'", "'-o'", "'-R'", "'-W'", "'-X'", "'-O'", "'-e'", "'-z'", "'-s'", "'-f'", "'-d'", "'-l'", "'-p'", "'-S'", "'-b'", "'-c'", "'-t'", "'-u'", "'-g'", "'-k'", "'-T'", "'-B'", "'-M'", "'-A'", "'-C'", "'.'", "'<=>'"
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
    public static final int RULE_READLINE_QUOTE=17;
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
    public static final int T__131=131;
    public static final int T__252=252;
    public static final int T__130=130;
    public static final int T__251=251;
    public static final int RULE_DATA=11;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_COMMAND_QUOTE_LIKE=15;
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
    public static final int RULE_POD=7;
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
    public static final int T__219=219;
    public static final int T__214=214;
    public static final int T__213=213;
    public static final int T__334=334;
    public static final int T__216=216;
    public static final int T__215=215;
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
    public static final int T__22=22;
    public static final int T__207=207;
    public static final int T__328=328;
    public static final int T__23=23;
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
    public static final int T__21=21;
    public static final int T__204=204;
    public static final int T__325=325;
    public static final int T__122=122;
    public static final int T__243=243;
    public static final int T__121=121;
    public static final int T__242=242;
    public static final int T__124=124;
    public static final int T__245=245;
    public static final int RULE_END=12;
    public static final int T__123=123;
    public static final int T__244=244;
    public static final int T__120=120;
    public static final int T__241=241;
    public static final int T__240=240;
    public static final int RULE_SL_COMMENT=19;
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
    public static final int RULE_HEX=4;
    public static final int RULE_LITERAL=10;
    public static final int RULE_BIN=5;
    public static final int RULE_INTERPOLATE=9;
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
    public static final int RULE_WORDS_QUOTE_LIKE=14;
    public static final int T__169=169;
    public static final int RULE_REGEX_QUOTE=16;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=8;
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
    public static final int RULE_WS=20;
    public static final int T__197=197;
    public static final int RULE_BACKTICK_STRING=13;
    public static final int T__196=196;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=18;
    public static final int T__88=88;
    public static final int T__89=89;
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
    // InternalPerl.g:87:1: ruleElement : ( ruleToken ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:91:2: ( ( ruleToken ) )
            // InternalPerl.g:92:2: ( ruleToken )
            {
            // InternalPerl.g:92:2: ( ruleToken )
            // InternalPerl.g:93:3: ruleToken
            {
             before(grammarAccess.getElementAccess().getTokenParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleToken();

            state._fsp--;

             after(grammarAccess.getElementAccess().getTokenParserRuleCall()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleToken"
    // InternalPerl.g:103:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // InternalPerl.g:104:1: ( ruleToken EOF )
            // InternalPerl.g:105:1: ruleToken EOF
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
    // InternalPerl.g:112:1: ruleToken : ( ( rule__Token__Alternatives ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:116:2: ( ( ( rule__Token__Alternatives ) ) )
            // InternalPerl.g:117:2: ( ( rule__Token__Alternatives ) )
            {
            // InternalPerl.g:117:2: ( ( rule__Token__Alternatives ) )
            // InternalPerl.g:118:3: ( rule__Token__Alternatives )
            {
             before(grammarAccess.getTokenAccess().getAlternatives()); 
            // InternalPerl.g:119:3: ( rule__Token__Alternatives )
            // InternalPerl.g:119:4: rule__Token__Alternatives
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


    // $ANTLR start "entryRuleQuoteLikeToken"
    // InternalPerl.g:128:1: entryRuleQuoteLikeToken : ruleQuoteLikeToken EOF ;
    public final void entryRuleQuoteLikeToken() throws RecognitionException {
        try {
            // InternalPerl.g:129:1: ( ruleQuoteLikeToken EOF )
            // InternalPerl.g:130:1: ruleQuoteLikeToken EOF
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
    // InternalPerl.g:137:1: ruleQuoteLikeToken : ( ( rule__QuoteLikeToken__Alternatives ) ) ;
    public final void ruleQuoteLikeToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:141:2: ( ( ( rule__QuoteLikeToken__Alternatives ) ) )
            // InternalPerl.g:142:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            {
            // InternalPerl.g:142:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            // InternalPerl.g:143:3: ( rule__QuoteLikeToken__Alternatives )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getAlternatives()); 
            // InternalPerl.g:144:3: ( rule__QuoteLikeToken__Alternatives )
            // InternalPerl.g:144:4: rule__QuoteLikeToken__Alternatives
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


    // $ANTLR start "entryRuleNumber"
    // InternalPerl.g:153:1: entryRuleNumber : ruleNumber EOF ;
    public final void entryRuleNumber() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:157:1: ( ruleNumber EOF )
            // InternalPerl.g:158:1: ruleNumber EOF
            {
             before(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_1);
            ruleNumber();

            state._fsp--;

             after(grammarAccess.getNumberRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:168:1: ruleNumber : ( ( rule__Number__Group__0 ) ) ;
    public final void ruleNumber() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:173:2: ( ( ( rule__Number__Group__0 ) ) )
            // InternalPerl.g:174:2: ( ( rule__Number__Group__0 ) )
            {
            // InternalPerl.g:174:2: ( ( rule__Number__Group__0 ) )
            // InternalPerl.g:175:3: ( rule__Number__Group__0 )
            {
             before(grammarAccess.getNumberAccess().getGroup()); 
            // InternalPerl.g:176:3: ( rule__Number__Group__0 )
            // InternalPerl.g:176:4: rule__Number__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Number__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNumberAccess().getGroup()); 

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


    // $ANTLR start "entryRuleWord"
    // InternalPerl.g:186:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalPerl.g:187:1: ( ruleWord EOF )
            // InternalPerl.g:188:1: ruleWord EOF
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
    // InternalPerl.g:195:1: ruleWord : ( ruleKeyword ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:199:2: ( ( ruleKeyword ) )
            // InternalPerl.g:200:2: ( ruleKeyword )
            {
            // InternalPerl.g:200:2: ( ruleKeyword )
            // InternalPerl.g:201:3: ruleKeyword
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
    // InternalPerl.g:211:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalPerl.g:212:1: ( ruleKeyword EOF )
            // InternalPerl.g:213:1: ruleKeyword EOF
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
    // InternalPerl.g:220:1: ruleKeyword : ( ( rule__Keyword__Alternatives ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:224:2: ( ( ( rule__Keyword__Alternatives ) ) )
            // InternalPerl.g:225:2: ( ( rule__Keyword__Alternatives ) )
            {
            // InternalPerl.g:225:2: ( ( rule__Keyword__Alternatives ) )
            // InternalPerl.g:226:3: ( rule__Keyword__Alternatives )
            {
             before(grammarAccess.getKeywordAccess().getAlternatives()); 
            // InternalPerl.g:227:3: ( rule__Keyword__Alternatives )
            // InternalPerl.g:227:4: rule__Keyword__Alternatives
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
    // InternalPerl.g:236:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalPerl.g:237:1: ( ruleOperator EOF )
            // InternalPerl.g:238:1: ruleOperator EOF
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
    // InternalPerl.g:245:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:249:2: ( ( ( rule__Operator__Alternatives ) ) )
            // InternalPerl.g:250:2: ( ( rule__Operator__Alternatives ) )
            {
            // InternalPerl.g:250:2: ( ( rule__Operator__Alternatives ) )
            // InternalPerl.g:251:3: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // InternalPerl.g:252:3: ( rule__Operator__Alternatives )
            // InternalPerl.g:252:4: rule__Operator__Alternatives
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
    // InternalPerl.g:261:1: entryRuleFileTestOperator : ruleFileTestOperator EOF ;
    public final void entryRuleFileTestOperator() throws RecognitionException {
        try {
            // InternalPerl.g:262:1: ( ruleFileTestOperator EOF )
            // InternalPerl.g:263:1: ruleFileTestOperator EOF
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
    // InternalPerl.g:270:1: ruleFileTestOperator : ( ( rule__FileTestOperator__Alternatives ) ) ;
    public final void ruleFileTestOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:274:2: ( ( ( rule__FileTestOperator__Alternatives ) ) )
            // InternalPerl.g:275:2: ( ( rule__FileTestOperator__Alternatives ) )
            {
            // InternalPerl.g:275:2: ( ( rule__FileTestOperator__Alternatives ) )
            // InternalPerl.g:276:3: ( rule__FileTestOperator__Alternatives )
            {
             before(grammarAccess.getFileTestOperatorAccess().getAlternatives()); 
            // InternalPerl.g:277:3: ( rule__FileTestOperator__Alternatives )
            // InternalPerl.g:277:4: rule__FileTestOperator__Alternatives
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


    // $ANTLR start "rule__Token__Alternatives"
    // InternalPerl.g:285:1: rule__Token__Alternatives : ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_4__0 ) ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ( rule__Token__Group_7__0 ) ) | ( ( rule__Token__Group_8__0 ) ) | ( ( rule__Token__Group_9__0 ) ) | ( ( rule__Token__Group_10__0 ) ) );
    public final void rule__Token__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:289:1: ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_4__0 ) ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ( rule__Token__Group_7__0 ) ) | ( ( rule__Token__Group_8__0 ) ) | ( ( rule__Token__Group_9__0 ) ) | ( ( rule__Token__Group_10__0 ) ) )
            int alt1=11;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_POD) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=RULE_HEX && LA1_0<=RULE_INT)) ) {
                alt1=2;
            }
            else if ( ((LA1_0>=21 && LA1_0<=242)) ) {
                alt1=3;
            }
            else if ( ((LA1_0>=RULE_BACKTICK_STRING && LA1_0<=RULE_READLINE_QUOTE)) ) {
                alt1=4;
            }
            else if ( ((LA1_0>=306 && LA1_0<=332)) ) {
                alt1=5;
            }
            else if ( ((LA1_0>=243 && LA1_0<=305)||LA1_0==334) ) {
                alt1=6;
            }
            else if ( (LA1_0==RULE_STRING) ) {
                alt1=7;
            }
            else if ( (LA1_0==RULE_INTERPOLATE) ) {
                alt1=8;
            }
            else if ( (LA1_0==RULE_LITERAL) ) {
                alt1=9;
            }
            else if ( (LA1_0==RULE_DATA) ) {
                alt1=10;
            }
            else if ( (LA1_0==RULE_END) ) {
                alt1=11;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalPerl.g:290:2: ( ( rule__Token__Group_0__0 ) )
                    {
                    // InternalPerl.g:290:2: ( ( rule__Token__Group_0__0 ) )
                    // InternalPerl.g:291:3: ( rule__Token__Group_0__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_0()); 
                    // InternalPerl.g:292:3: ( rule__Token__Group_0__0 )
                    // InternalPerl.g:292:4: rule__Token__Group_0__0
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
                    // InternalPerl.g:296:2: ( ( rule__Token__Group_1__0 ) )
                    {
                    // InternalPerl.g:296:2: ( ( rule__Token__Group_1__0 ) )
                    // InternalPerl.g:297:3: ( rule__Token__Group_1__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_1()); 
                    // InternalPerl.g:298:3: ( rule__Token__Group_1__0 )
                    // InternalPerl.g:298:4: rule__Token__Group_1__0
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
                    // InternalPerl.g:302:2: ( ( rule__Token__Group_2__0 ) )
                    {
                    // InternalPerl.g:302:2: ( ( rule__Token__Group_2__0 ) )
                    // InternalPerl.g:303:3: ( rule__Token__Group_2__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_2()); 
                    // InternalPerl.g:304:3: ( rule__Token__Group_2__0 )
                    // InternalPerl.g:304:4: rule__Token__Group_2__0
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
                    // InternalPerl.g:308:2: ( ruleQuoteLikeToken )
                    {
                    // InternalPerl.g:308:2: ( ruleQuoteLikeToken )
                    // InternalPerl.g:309:3: ruleQuoteLikeToken
                    {
                     before(grammarAccess.getTokenAccess().getQuoteLikeTokenParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleQuoteLikeToken();

                    state._fsp--;

                     after(grammarAccess.getTokenAccess().getQuoteLikeTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:314:2: ( ( rule__Token__Group_4__0 ) )
                    {
                    // InternalPerl.g:314:2: ( ( rule__Token__Group_4__0 ) )
                    // InternalPerl.g:315:3: ( rule__Token__Group_4__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_4()); 
                    // InternalPerl.g:316:3: ( rule__Token__Group_4__0 )
                    // InternalPerl.g:316:4: rule__Token__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:320:2: ( ( rule__Token__Group_5__0 ) )
                    {
                    // InternalPerl.g:320:2: ( ( rule__Token__Group_5__0 ) )
                    // InternalPerl.g:321:3: ( rule__Token__Group_5__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_5()); 
                    // InternalPerl.g:322:3: ( rule__Token__Group_5__0 )
                    // InternalPerl.g:322:4: rule__Token__Group_5__0
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
                    // InternalPerl.g:326:2: ( ( rule__Token__Group_6__0 ) )
                    {
                    // InternalPerl.g:326:2: ( ( rule__Token__Group_6__0 ) )
                    // InternalPerl.g:327:3: ( rule__Token__Group_6__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_6()); 
                    // InternalPerl.g:328:3: ( rule__Token__Group_6__0 )
                    // InternalPerl.g:328:4: rule__Token__Group_6__0
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
                    // InternalPerl.g:332:2: ( ( rule__Token__Group_7__0 ) )
                    {
                    // InternalPerl.g:332:2: ( ( rule__Token__Group_7__0 ) )
                    // InternalPerl.g:333:3: ( rule__Token__Group_7__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_7()); 
                    // InternalPerl.g:334:3: ( rule__Token__Group_7__0 )
                    // InternalPerl.g:334:4: rule__Token__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Token__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTokenAccess().getGroup_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:338:2: ( ( rule__Token__Group_8__0 ) )
                    {
                    // InternalPerl.g:338:2: ( ( rule__Token__Group_8__0 ) )
                    // InternalPerl.g:339:3: ( rule__Token__Group_8__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_8()); 
                    // InternalPerl.g:340:3: ( rule__Token__Group_8__0 )
                    // InternalPerl.g:340:4: rule__Token__Group_8__0
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
                    // InternalPerl.g:344:2: ( ( rule__Token__Group_9__0 ) )
                    {
                    // InternalPerl.g:344:2: ( ( rule__Token__Group_9__0 ) )
                    // InternalPerl.g:345:3: ( rule__Token__Group_9__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_9()); 
                    // InternalPerl.g:346:3: ( rule__Token__Group_9__0 )
                    // InternalPerl.g:346:4: rule__Token__Group_9__0
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
                    // InternalPerl.g:350:2: ( ( rule__Token__Group_10__0 ) )
                    {
                    // InternalPerl.g:350:2: ( ( rule__Token__Group_10__0 ) )
                    // InternalPerl.g:351:3: ( rule__Token__Group_10__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_10()); 
                    // InternalPerl.g:352:3: ( rule__Token__Group_10__0 )
                    // InternalPerl.g:352:4: rule__Token__Group_10__0
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


    // $ANTLR start "rule__QuoteLikeToken__Alternatives"
    // InternalPerl.g:360:1: rule__QuoteLikeToken__Alternatives : ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) );
    public final void rule__QuoteLikeToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:364:1: ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case RULE_BACKTICK_STRING:
                {
                alt2=1;
                }
                break;
            case RULE_WORDS_QUOTE_LIKE:
                {
                alt2=2;
                }
                break;
            case RULE_COMMAND_QUOTE_LIKE:
                {
                alt2=3;
                }
                break;
            case RULE_REGEX_QUOTE:
                {
                alt2=4;
                }
                break;
            case RULE_READLINE_QUOTE:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalPerl.g:365:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    {
                    // InternalPerl.g:365:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    // InternalPerl.g:366:3: ( rule__QuoteLikeToken__Group_0__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_0()); 
                    // InternalPerl.g:367:3: ( rule__QuoteLikeToken__Group_0__0 )
                    // InternalPerl.g:367:4: rule__QuoteLikeToken__Group_0__0
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
                    // InternalPerl.g:371:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    {
                    // InternalPerl.g:371:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    // InternalPerl.g:372:3: ( rule__QuoteLikeToken__Group_1__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_1()); 
                    // InternalPerl.g:373:3: ( rule__QuoteLikeToken__Group_1__0 )
                    // InternalPerl.g:373:4: rule__QuoteLikeToken__Group_1__0
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
                    // InternalPerl.g:377:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    {
                    // InternalPerl.g:377:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    // InternalPerl.g:378:3: ( rule__QuoteLikeToken__Group_2__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_2()); 
                    // InternalPerl.g:379:3: ( rule__QuoteLikeToken__Group_2__0 )
                    // InternalPerl.g:379:4: rule__QuoteLikeToken__Group_2__0
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
                    // InternalPerl.g:383:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    {
                    // InternalPerl.g:383:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    // InternalPerl.g:384:3: ( rule__QuoteLikeToken__Group_3__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_3()); 
                    // InternalPerl.g:385:3: ( rule__QuoteLikeToken__Group_3__0 )
                    // InternalPerl.g:385:4: rule__QuoteLikeToken__Group_3__0
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
                    // InternalPerl.g:389:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    {
                    // InternalPerl.g:389:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    // InternalPerl.g:390:3: ( rule__QuoteLikeToken__Group_4__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_4()); 
                    // InternalPerl.g:391:3: ( rule__QuoteLikeToken__Group_4__0 )
                    // InternalPerl.g:391:4: rule__QuoteLikeToken__Group_4__0
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


    // $ANTLR start "rule__Number__Alternatives_0"
    // InternalPerl.g:399:1: rule__Number__Alternatives_0 : ( ( RULE_HEX ) | ( RULE_BIN ) | ( RULE_INT ) );
    public final void rule__Number__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:403:1: ( ( RULE_HEX ) | ( RULE_BIN ) | ( RULE_INT ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt3=1;
                }
                break;
            case RULE_BIN:
                {
                alt3=2;
                }
                break;
            case RULE_INT:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalPerl.g:404:2: ( RULE_HEX )
                    {
                    // InternalPerl.g:404:2: ( RULE_HEX )
                    // InternalPerl.g:405:3: RULE_HEX
                    {
                     before(grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0_0()); 
                    match(input,RULE_HEX,FOLLOW_2); 
                     after(grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:410:2: ( RULE_BIN )
                    {
                    // InternalPerl.g:410:2: ( RULE_BIN )
                    // InternalPerl.g:411:3: RULE_BIN
                    {
                     before(grammarAccess.getNumberAccess().getBINTerminalRuleCall_0_1()); 
                    match(input,RULE_BIN,FOLLOW_2); 
                     after(grammarAccess.getNumberAccess().getBINTerminalRuleCall_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:416:2: ( RULE_INT )
                    {
                    // InternalPerl.g:416:2: ( RULE_INT )
                    // InternalPerl.g:417:3: RULE_INT
                    {
                     before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_0_2()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_0_2()); 

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


    // $ANTLR start "rule__Keyword__Alternatives"
    // InternalPerl.g:426:1: rule__Keyword__Alternatives : ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) );
    public final void rule__Keyword__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:430:1: ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) )
            int alt4=222;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt4=1;
                }
                break;
            case 22:
                {
                alt4=2;
                }
                break;
            case 23:
                {
                alt4=3;
                }
                break;
            case 24:
                {
                alt4=4;
                }
                break;
            case 25:
                {
                alt4=5;
                }
                break;
            case 26:
                {
                alt4=6;
                }
                break;
            case 27:
                {
                alt4=7;
                }
                break;
            case 28:
                {
                alt4=8;
                }
                break;
            case 29:
                {
                alt4=9;
                }
                break;
            case 30:
                {
                alt4=10;
                }
                break;
            case 31:
                {
                alt4=11;
                }
                break;
            case 32:
                {
                alt4=12;
                }
                break;
            case 33:
                {
                alt4=13;
                }
                break;
            case 34:
                {
                alt4=14;
                }
                break;
            case 35:
                {
                alt4=15;
                }
                break;
            case 36:
                {
                alt4=16;
                }
                break;
            case 37:
                {
                alt4=17;
                }
                break;
            case 38:
                {
                alt4=18;
                }
                break;
            case 39:
                {
                alt4=19;
                }
                break;
            case 40:
                {
                alt4=20;
                }
                break;
            case 41:
                {
                alt4=21;
                }
                break;
            case 42:
                {
                alt4=22;
                }
                break;
            case 43:
                {
                alt4=23;
                }
                break;
            case 44:
                {
                alt4=24;
                }
                break;
            case 45:
                {
                alt4=25;
                }
                break;
            case 46:
                {
                alt4=26;
                }
                break;
            case 47:
                {
                alt4=27;
                }
                break;
            case 48:
                {
                alt4=28;
                }
                break;
            case 49:
                {
                alt4=29;
                }
                break;
            case 50:
                {
                alt4=30;
                }
                break;
            case 51:
                {
                alt4=31;
                }
                break;
            case 52:
                {
                alt4=32;
                }
                break;
            case 53:
                {
                alt4=33;
                }
                break;
            case 54:
                {
                alt4=34;
                }
                break;
            case 55:
                {
                alt4=35;
                }
                break;
            case 56:
                {
                alt4=36;
                }
                break;
            case 57:
                {
                alt4=37;
                }
                break;
            case 58:
                {
                alt4=38;
                }
                break;
            case 59:
                {
                alt4=39;
                }
                break;
            case 60:
                {
                alt4=40;
                }
                break;
            case 61:
                {
                alt4=41;
                }
                break;
            case 62:
                {
                alt4=42;
                }
                break;
            case 63:
                {
                alt4=43;
                }
                break;
            case 64:
                {
                alt4=44;
                }
                break;
            case 65:
                {
                alt4=45;
                }
                break;
            case 66:
                {
                alt4=46;
                }
                break;
            case 67:
                {
                alt4=47;
                }
                break;
            case 68:
                {
                alt4=48;
                }
                break;
            case 69:
                {
                alt4=49;
                }
                break;
            case 70:
                {
                alt4=50;
                }
                break;
            case 71:
                {
                alt4=51;
                }
                break;
            case 72:
                {
                alt4=52;
                }
                break;
            case 73:
                {
                alt4=53;
                }
                break;
            case 74:
                {
                alt4=54;
                }
                break;
            case 75:
                {
                alt4=55;
                }
                break;
            case 76:
                {
                alt4=56;
                }
                break;
            case 77:
                {
                alt4=57;
                }
                break;
            case 78:
                {
                alt4=58;
                }
                break;
            case 79:
                {
                alt4=59;
                }
                break;
            case 80:
                {
                alt4=60;
                }
                break;
            case 81:
                {
                alt4=61;
                }
                break;
            case 82:
                {
                alt4=62;
                }
                break;
            case 83:
                {
                alt4=63;
                }
                break;
            case 84:
                {
                alt4=64;
                }
                break;
            case 85:
                {
                alt4=65;
                }
                break;
            case 86:
                {
                alt4=66;
                }
                break;
            case 87:
                {
                alt4=67;
                }
                break;
            case 88:
                {
                alt4=68;
                }
                break;
            case 89:
                {
                alt4=69;
                }
                break;
            case 90:
                {
                alt4=70;
                }
                break;
            case 91:
                {
                alt4=71;
                }
                break;
            case 92:
                {
                alt4=72;
                }
                break;
            case 93:
                {
                alt4=73;
                }
                break;
            case 94:
                {
                alt4=74;
                }
                break;
            case 95:
                {
                alt4=75;
                }
                break;
            case 96:
                {
                alt4=76;
                }
                break;
            case 97:
                {
                alt4=77;
                }
                break;
            case 98:
                {
                alt4=78;
                }
                break;
            case 99:
                {
                alt4=79;
                }
                break;
            case 100:
                {
                alt4=80;
                }
                break;
            case 101:
                {
                alt4=81;
                }
                break;
            case 102:
                {
                alt4=82;
                }
                break;
            case 103:
                {
                alt4=83;
                }
                break;
            case 104:
                {
                alt4=84;
                }
                break;
            case 105:
                {
                alt4=85;
                }
                break;
            case 106:
                {
                alt4=86;
                }
                break;
            case 107:
                {
                alt4=87;
                }
                break;
            case 108:
                {
                alt4=88;
                }
                break;
            case 109:
                {
                alt4=89;
                }
                break;
            case 110:
                {
                alt4=90;
                }
                break;
            case 111:
                {
                alt4=91;
                }
                break;
            case 112:
                {
                alt4=92;
                }
                break;
            case 113:
                {
                alt4=93;
                }
                break;
            case 114:
                {
                alt4=94;
                }
                break;
            case 115:
                {
                alt4=95;
                }
                break;
            case 116:
                {
                alt4=96;
                }
                break;
            case 117:
                {
                alt4=97;
                }
                break;
            case 118:
                {
                alt4=98;
                }
                break;
            case 119:
                {
                alt4=99;
                }
                break;
            case 120:
                {
                alt4=100;
                }
                break;
            case 121:
                {
                alt4=101;
                }
                break;
            case 122:
                {
                alt4=102;
                }
                break;
            case 123:
                {
                alt4=103;
                }
                break;
            case 124:
                {
                alt4=104;
                }
                break;
            case 125:
                {
                alt4=105;
                }
                break;
            case 126:
                {
                alt4=106;
                }
                break;
            case 127:
                {
                alt4=107;
                }
                break;
            case 128:
                {
                alt4=108;
                }
                break;
            case 129:
                {
                alt4=109;
                }
                break;
            case 130:
                {
                alt4=110;
                }
                break;
            case 131:
                {
                alt4=111;
                }
                break;
            case 132:
                {
                alt4=112;
                }
                break;
            case 133:
                {
                alt4=113;
                }
                break;
            case 134:
                {
                alt4=114;
                }
                break;
            case 135:
                {
                alt4=115;
                }
                break;
            case 136:
                {
                alt4=116;
                }
                break;
            case 137:
                {
                alt4=117;
                }
                break;
            case 138:
                {
                alt4=118;
                }
                break;
            case 139:
                {
                alt4=119;
                }
                break;
            case 140:
                {
                alt4=120;
                }
                break;
            case 141:
                {
                alt4=121;
                }
                break;
            case 142:
                {
                alt4=122;
                }
                break;
            case 143:
                {
                alt4=123;
                }
                break;
            case 144:
                {
                alt4=124;
                }
                break;
            case 145:
                {
                alt4=125;
                }
                break;
            case 146:
                {
                alt4=126;
                }
                break;
            case 147:
                {
                alt4=127;
                }
                break;
            case 148:
                {
                alt4=128;
                }
                break;
            case 149:
                {
                alt4=129;
                }
                break;
            case 150:
                {
                alt4=130;
                }
                break;
            case 151:
                {
                alt4=131;
                }
                break;
            case 152:
                {
                alt4=132;
                }
                break;
            case 153:
                {
                alt4=133;
                }
                break;
            case 154:
                {
                alt4=134;
                }
                break;
            case 155:
                {
                alt4=135;
                }
                break;
            case 156:
                {
                alt4=136;
                }
                break;
            case 157:
                {
                alt4=137;
                }
                break;
            case 158:
                {
                alt4=138;
                }
                break;
            case 159:
                {
                alt4=139;
                }
                break;
            case 160:
                {
                alt4=140;
                }
                break;
            case 161:
                {
                alt4=141;
                }
                break;
            case 162:
                {
                alt4=142;
                }
                break;
            case 163:
                {
                alt4=143;
                }
                break;
            case 164:
                {
                alt4=144;
                }
                break;
            case 165:
                {
                alt4=145;
                }
                break;
            case 166:
                {
                alt4=146;
                }
                break;
            case 167:
                {
                alt4=147;
                }
                break;
            case 168:
                {
                alt4=148;
                }
                break;
            case 169:
                {
                alt4=149;
                }
                break;
            case 170:
                {
                alt4=150;
                }
                break;
            case 171:
                {
                alt4=151;
                }
                break;
            case 172:
                {
                alt4=152;
                }
                break;
            case 173:
                {
                alt4=153;
                }
                break;
            case 174:
                {
                alt4=154;
                }
                break;
            case 175:
                {
                alt4=155;
                }
                break;
            case 176:
                {
                alt4=156;
                }
                break;
            case 177:
                {
                alt4=157;
                }
                break;
            case 178:
                {
                alt4=158;
                }
                break;
            case 179:
                {
                alt4=159;
                }
                break;
            case 180:
                {
                alt4=160;
                }
                break;
            case 181:
                {
                alt4=161;
                }
                break;
            case 182:
                {
                alt4=162;
                }
                break;
            case 183:
                {
                alt4=163;
                }
                break;
            case 184:
                {
                alt4=164;
                }
                break;
            case 185:
                {
                alt4=165;
                }
                break;
            case 186:
                {
                alt4=166;
                }
                break;
            case 187:
                {
                alt4=167;
                }
                break;
            case 188:
                {
                alt4=168;
                }
                break;
            case 189:
                {
                alt4=169;
                }
                break;
            case 190:
                {
                alt4=170;
                }
                break;
            case 191:
                {
                alt4=171;
                }
                break;
            case 192:
                {
                alt4=172;
                }
                break;
            case 193:
                {
                alt4=173;
                }
                break;
            case 194:
                {
                alt4=174;
                }
                break;
            case 195:
                {
                alt4=175;
                }
                break;
            case 196:
                {
                alt4=176;
                }
                break;
            case 197:
                {
                alt4=177;
                }
                break;
            case 198:
                {
                alt4=178;
                }
                break;
            case 199:
                {
                alt4=179;
                }
                break;
            case 200:
                {
                alt4=180;
                }
                break;
            case 201:
                {
                alt4=181;
                }
                break;
            case 202:
                {
                alt4=182;
                }
                break;
            case 203:
                {
                alt4=183;
                }
                break;
            case 204:
                {
                alt4=184;
                }
                break;
            case 205:
                {
                alt4=185;
                }
                break;
            case 206:
                {
                alt4=186;
                }
                break;
            case 207:
                {
                alt4=187;
                }
                break;
            case 208:
                {
                alt4=188;
                }
                break;
            case 209:
                {
                alt4=189;
                }
                break;
            case 210:
                {
                alt4=190;
                }
                break;
            case 211:
                {
                alt4=191;
                }
                break;
            case 212:
                {
                alt4=192;
                }
                break;
            case 213:
                {
                alt4=193;
                }
                break;
            case 214:
                {
                alt4=194;
                }
                break;
            case 215:
                {
                alt4=195;
                }
                break;
            case 216:
                {
                alt4=196;
                }
                break;
            case 217:
                {
                alt4=197;
                }
                break;
            case 218:
                {
                alt4=198;
                }
                break;
            case 219:
                {
                alt4=199;
                }
                break;
            case 220:
                {
                alt4=200;
                }
                break;
            case 221:
                {
                alt4=201;
                }
                break;
            case 222:
                {
                alt4=202;
                }
                break;
            case 223:
                {
                alt4=203;
                }
                break;
            case 224:
                {
                alt4=204;
                }
                break;
            case 225:
                {
                alt4=205;
                }
                break;
            case 226:
                {
                alt4=206;
                }
                break;
            case 227:
                {
                alt4=207;
                }
                break;
            case 228:
                {
                alt4=208;
                }
                break;
            case 229:
                {
                alt4=209;
                }
                break;
            case 230:
                {
                alt4=210;
                }
                break;
            case 231:
                {
                alt4=211;
                }
                break;
            case 232:
                {
                alt4=212;
                }
                break;
            case 233:
                {
                alt4=213;
                }
                break;
            case 234:
                {
                alt4=214;
                }
                break;
            case 235:
                {
                alt4=215;
                }
                break;
            case 236:
                {
                alt4=216;
                }
                break;
            case 237:
                {
                alt4=217;
                }
                break;
            case 238:
                {
                alt4=218;
                }
                break;
            case 239:
                {
                alt4=219;
                }
                break;
            case 240:
                {
                alt4=220;
                }
                break;
            case 241:
                {
                alt4=221;
                }
                break;
            case 242:
                {
                alt4=222;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalPerl.g:431:2: ( 'abs' )
                    {
                    // InternalPerl.g:431:2: ( 'abs' )
                    // InternalPerl.g:432:3: 'abs'
                    {
                     before(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:437:2: ( 'accept' )
                    {
                    // InternalPerl.g:437:2: ( 'accept' )
                    // InternalPerl.g:438:3: 'accept'
                    {
                     before(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:443:2: ( 'alarm' )
                    {
                    // InternalPerl.g:443:2: ( 'alarm' )
                    // InternalPerl.g:444:3: 'alarm'
                    {
                     before(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:449:2: ( 'atan2' )
                    {
                    // InternalPerl.g:449:2: ( 'atan2' )
                    // InternalPerl.g:450:3: 'atan2'
                    {
                     before(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:455:2: ( 'bind' )
                    {
                    // InternalPerl.g:455:2: ( 'bind' )
                    // InternalPerl.g:456:3: 'bind'
                    {
                     before(grammarAccess.getKeywordAccess().getBindKeyword_4()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBindKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:461:2: ( 'binmode' )
                    {
                    // InternalPerl.g:461:2: ( 'binmode' )
                    // InternalPerl.g:462:3: 'binmode'
                    {
                     before(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:467:2: ( 'bless' )
                    {
                    // InternalPerl.g:467:2: ( 'bless' )
                    // InternalPerl.g:468:3: 'bless'
                    {
                     before(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:473:2: ( 'break' )
                    {
                    // InternalPerl.g:473:2: ( 'break' )
                    // InternalPerl.g:474:3: 'break'
                    {
                     before(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:479:2: ( 'caller' )
                    {
                    // InternalPerl.g:479:2: ( 'caller' )
                    // InternalPerl.g:480:3: 'caller'
                    {
                     before(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:485:2: ( 'chdir' )
                    {
                    // InternalPerl.g:485:2: ( 'chdir' )
                    // InternalPerl.g:486:3: 'chdir'
                    {
                     before(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:491:2: ( 'chmod' )
                    {
                    // InternalPerl.g:491:2: ( 'chmod' )
                    // InternalPerl.g:492:3: 'chmod'
                    {
                     before(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:497:2: ( 'chomp' )
                    {
                    // InternalPerl.g:497:2: ( 'chomp' )
                    // InternalPerl.g:498:3: 'chomp'
                    {
                     before(grammarAccess.getKeywordAccess().getChompKeyword_11()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChompKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:503:2: ( 'chop' )
                    {
                    // InternalPerl.g:503:2: ( 'chop' )
                    // InternalPerl.g:504:3: 'chop'
                    {
                     before(grammarAccess.getKeywordAccess().getChopKeyword_12()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChopKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:509:2: ( 'chown' )
                    {
                    // InternalPerl.g:509:2: ( 'chown' )
                    // InternalPerl.g:510:3: 'chown'
                    {
                     before(grammarAccess.getKeywordAccess().getChownKeyword_13()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChownKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:515:2: ( 'chr' )
                    {
                    // InternalPerl.g:515:2: ( 'chr' )
                    // InternalPerl.g:516:3: 'chr'
                    {
                     before(grammarAccess.getKeywordAccess().getChrKeyword_14()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:521:2: ( 'chroot' )
                    {
                    // InternalPerl.g:521:2: ( 'chroot' )
                    // InternalPerl.g:522:3: 'chroot'
                    {
                     before(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:527:2: ( 'close' )
                    {
                    // InternalPerl.g:527:2: ( 'close' )
                    // InternalPerl.g:528:3: 'close'
                    {
                     before(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:533:2: ( 'closedir' )
                    {
                    // InternalPerl.g:533:2: ( 'closedir' )
                    // InternalPerl.g:534:3: 'closedir'
                    {
                     before(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:539:2: ( 'connect' )
                    {
                    // InternalPerl.g:539:2: ( 'connect' )
                    // InternalPerl.g:540:3: 'connect'
                    {
                     before(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:545:2: ( 'continue' )
                    {
                    // InternalPerl.g:545:2: ( 'continue' )
                    // InternalPerl.g:546:3: 'continue'
                    {
                     before(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:551:2: ( 'cos' )
                    {
                    // InternalPerl.g:551:2: ( 'cos' )
                    // InternalPerl.g:552:3: 'cos'
                    {
                     before(grammarAccess.getKeywordAccess().getCosKeyword_20()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCosKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:557:2: ( 'crypt' )
                    {
                    // InternalPerl.g:557:2: ( 'crypt' )
                    // InternalPerl.g:558:3: 'crypt'
                    {
                     before(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:563:2: ( 'dbmclose' )
                    {
                    // InternalPerl.g:563:2: ( 'dbmclose' )
                    // InternalPerl.g:564:3: 'dbmclose'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:569:2: ( 'dbmopen' )
                    {
                    // InternalPerl.g:569:2: ( 'dbmopen' )
                    // InternalPerl.g:570:3: 'dbmopen'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:575:2: ( 'default' )
                    {
                    // InternalPerl.g:575:2: ( 'default' )
                    // InternalPerl.g:576:3: 'default'
                    {
                     before(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:581:2: ( 'defined' )
                    {
                    // InternalPerl.g:581:2: ( 'defined' )
                    // InternalPerl.g:582:3: 'defined'
                    {
                     before(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:587:2: ( 'delete' )
                    {
                    // InternalPerl.g:587:2: ( 'delete' )
                    // InternalPerl.g:588:3: 'delete'
                    {
                     before(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:593:2: ( 'die' )
                    {
                    // InternalPerl.g:593:2: ( 'die' )
                    // InternalPerl.g:594:3: 'die'
                    {
                     before(grammarAccess.getKeywordAccess().getDieKeyword_27()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDieKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:599:2: ( 'do' )
                    {
                    // InternalPerl.g:599:2: ( 'do' )
                    // InternalPerl.g:600:3: 'do'
                    {
                     before(grammarAccess.getKeywordAccess().getDoKeyword_28()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDoKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:605:2: ( 'dump' )
                    {
                    // InternalPerl.g:605:2: ( 'dump' )
                    // InternalPerl.g:606:3: 'dump'
                    {
                     before(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:611:2: ( 'each' )
                    {
                    // InternalPerl.g:611:2: ( 'each' )
                    // InternalPerl.g:612:3: 'each'
                    {
                     before(grammarAccess.getKeywordAccess().getEachKeyword_30()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEachKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:617:2: ( 'else' )
                    {
                    // InternalPerl.g:617:2: ( 'else' )
                    // InternalPerl.g:618:3: 'else'
                    {
                     before(grammarAccess.getKeywordAccess().getElseKeyword_31()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElseKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:623:2: ( 'elsif' )
                    {
                    // InternalPerl.g:623:2: ( 'elsif' )
                    // InternalPerl.g:624:3: 'elsif'
                    {
                     before(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:629:2: ( 'endgrent' )
                    {
                    // InternalPerl.g:629:2: ( 'endgrent' )
                    // InternalPerl.g:630:3: 'endgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:635:2: ( 'endhostent' )
                    {
                    // InternalPerl.g:635:2: ( 'endhostent' )
                    // InternalPerl.g:636:3: 'endhostent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:641:2: ( 'endnetent' )
                    {
                    // InternalPerl.g:641:2: ( 'endnetent' )
                    // InternalPerl.g:642:3: 'endnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:647:2: ( 'endprotoent' )
                    {
                    // InternalPerl.g:647:2: ( 'endprotoent' )
                    // InternalPerl.g:648:3: 'endprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:653:2: ( 'endpwent' )
                    {
                    // InternalPerl.g:653:2: ( 'endpwent' )
                    // InternalPerl.g:654:3: 'endpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:659:2: ( 'endservent' )
                    {
                    // InternalPerl.g:659:2: ( 'endservent' )
                    // InternalPerl.g:660:3: 'endservent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:665:2: ( 'eof' )
                    {
                    // InternalPerl.g:665:2: ( 'eof' )
                    // InternalPerl.g:666:3: 'eof'
                    {
                     before(grammarAccess.getKeywordAccess().getEofKeyword_39()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEofKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:671:2: ( 'eval' )
                    {
                    // InternalPerl.g:671:2: ( 'eval' )
                    // InternalPerl.g:672:3: 'eval'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:677:2: ( 'evalbytes' )
                    {
                    // InternalPerl.g:677:2: ( 'evalbytes' )
                    // InternalPerl.g:678:3: 'evalbytes'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:683:2: ( 'exec' )
                    {
                    // InternalPerl.g:683:2: ( 'exec' )
                    // InternalPerl.g:684:3: 'exec'
                    {
                     before(grammarAccess.getKeywordAccess().getExecKeyword_42()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExecKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:689:2: ( 'exists' )
                    {
                    // InternalPerl.g:689:2: ( 'exists' )
                    // InternalPerl.g:690:3: 'exists'
                    {
                     before(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:695:2: ( 'exit' )
                    {
                    // InternalPerl.g:695:2: ( 'exit' )
                    // InternalPerl.g:696:3: 'exit'
                    {
                     before(grammarAccess.getKeywordAccess().getExitKeyword_44()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExitKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:701:2: ( 'exp' )
                    {
                    // InternalPerl.g:701:2: ( 'exp' )
                    // InternalPerl.g:702:3: 'exp'
                    {
                     before(grammarAccess.getKeywordAccess().getExpKeyword_45()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExpKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:707:2: ( 'fc' )
                    {
                    // InternalPerl.g:707:2: ( 'fc' )
                    // InternalPerl.g:708:3: 'fc'
                    {
                     before(grammarAccess.getKeywordAccess().getFcKeyword_46()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:713:2: ( 'fcntl' )
                    {
                    // InternalPerl.g:713:2: ( 'fcntl' )
                    // InternalPerl.g:714:3: 'fcntl'
                    {
                     before(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:719:2: ( 'fileno' )
                    {
                    // InternalPerl.g:719:2: ( 'fileno' )
                    // InternalPerl.g:720:3: 'fileno'
                    {
                     before(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:725:2: ( 'flock' )
                    {
                    // InternalPerl.g:725:2: ( 'flock' )
                    // InternalPerl.g:726:3: 'flock'
                    {
                     before(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:731:2: ( 'for' )
                    {
                    // InternalPerl.g:731:2: ( 'for' )
                    // InternalPerl.g:732:3: 'for'
                    {
                     before(grammarAccess.getKeywordAccess().getForKeyword_50()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:737:2: ( 'foreach' )
                    {
                    // InternalPerl.g:737:2: ( 'foreach' )
                    // InternalPerl.g:738:3: 'foreach'
                    {
                     before(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:743:2: ( 'fork' )
                    {
                    // InternalPerl.g:743:2: ( 'fork' )
                    // InternalPerl.g:744:3: 'fork'
                    {
                     before(grammarAccess.getKeywordAccess().getForkKeyword_52()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForkKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:749:2: ( 'format' )
                    {
                    // InternalPerl.g:749:2: ( 'format' )
                    // InternalPerl.g:750:3: 'format'
                    {
                     before(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:755:2: ( 'formline' )
                    {
                    // InternalPerl.g:755:2: ( 'formline' )
                    // InternalPerl.g:756:3: 'formline'
                    {
                     before(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 
                    match(input,75,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:761:2: ( 'getc' )
                    {
                    // InternalPerl.g:761:2: ( 'getc' )
                    // InternalPerl.g:762:3: 'getc'
                    {
                     before(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 
                    match(input,76,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:767:2: ( 'getgrent' )
                    {
                    // InternalPerl.g:767:2: ( 'getgrent' )
                    // InternalPerl.g:768:3: 'getgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 
                    match(input,77,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:773:2: ( 'getgrgid' )
                    {
                    // InternalPerl.g:773:2: ( 'getgrgid' )
                    // InternalPerl.g:774:3: 'getgrgid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 
                    match(input,78,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:779:2: ( 'getgrnam' )
                    {
                    // InternalPerl.g:779:2: ( 'getgrnam' )
                    // InternalPerl.g:780:3: 'getgrnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 
                    match(input,79,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:785:2: ( 'gethostbyaddr' )
                    {
                    // InternalPerl.g:785:2: ( 'gethostbyaddr' )
                    // InternalPerl.g:786:3: 'gethostbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 
                    match(input,80,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:791:2: ( 'gethostbyname' )
                    {
                    // InternalPerl.g:791:2: ( 'gethostbyname' )
                    // InternalPerl.g:792:3: 'gethostbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 
                    match(input,81,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:797:2: ( 'gethostent' )
                    {
                    // InternalPerl.g:797:2: ( 'gethostent' )
                    // InternalPerl.g:798:3: 'gethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 
                    match(input,82,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:803:2: ( 'getlogin' )
                    {
                    // InternalPerl.g:803:2: ( 'getlogin' )
                    // InternalPerl.g:804:3: 'getlogin'
                    {
                     before(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 
                    match(input,83,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:809:2: ( 'getnetbyaddr' )
                    {
                    // InternalPerl.g:809:2: ( 'getnetbyaddr' )
                    // InternalPerl.g:810:3: 'getnetbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 
                    match(input,84,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 

                    }


                    }
                    break;
                case 65 :
                    // InternalPerl.g:815:2: ( 'getnetbyname' )
                    {
                    // InternalPerl.g:815:2: ( 'getnetbyname' )
                    // InternalPerl.g:816:3: 'getnetbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 
                    match(input,85,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 

                    }


                    }
                    break;
                case 66 :
                    // InternalPerl.g:821:2: ( 'getnetent' )
                    {
                    // InternalPerl.g:821:2: ( 'getnetent' )
                    // InternalPerl.g:822:3: 'getnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 
                    match(input,86,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 

                    }


                    }
                    break;
                case 67 :
                    // InternalPerl.g:827:2: ( 'getpeername' )
                    {
                    // InternalPerl.g:827:2: ( 'getpeername' )
                    // InternalPerl.g:828:3: 'getpeername'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 
                    match(input,87,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 

                    }


                    }
                    break;
                case 68 :
                    // InternalPerl.g:833:2: ( 'getpgrp' )
                    {
                    // InternalPerl.g:833:2: ( 'getpgrp' )
                    // InternalPerl.g:834:3: 'getpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 
                    match(input,88,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 

                    }


                    }
                    break;
                case 69 :
                    // InternalPerl.g:839:2: ( 'getppid' )
                    {
                    // InternalPerl.g:839:2: ( 'getppid' )
                    // InternalPerl.g:840:3: 'getppid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 
                    match(input,89,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 

                    }


                    }
                    break;
                case 70 :
                    // InternalPerl.g:845:2: ( 'getpriority' )
                    {
                    // InternalPerl.g:845:2: ( 'getpriority' )
                    // InternalPerl.g:846:3: 'getpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 
                    match(input,90,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 

                    }


                    }
                    break;
                case 71 :
                    // InternalPerl.g:851:2: ( 'getprotobyname' )
                    {
                    // InternalPerl.g:851:2: ( 'getprotobyname' )
                    // InternalPerl.g:852:3: 'getprotobyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 
                    match(input,91,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 

                    }


                    }
                    break;
                case 72 :
                    // InternalPerl.g:857:2: ( 'getprotobynumber' )
                    {
                    // InternalPerl.g:857:2: ( 'getprotobynumber' )
                    // InternalPerl.g:858:3: 'getprotobynumber'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 
                    match(input,92,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 

                    }


                    }
                    break;
                case 73 :
                    // InternalPerl.g:863:2: ( 'getprotoent' )
                    {
                    // InternalPerl.g:863:2: ( 'getprotoent' )
                    // InternalPerl.g:864:3: 'getprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 
                    match(input,93,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 

                    }


                    }
                    break;
                case 74 :
                    // InternalPerl.g:869:2: ( 'getpwent' )
                    {
                    // InternalPerl.g:869:2: ( 'getpwent' )
                    // InternalPerl.g:870:3: 'getpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 
                    match(input,94,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 

                    }


                    }
                    break;
                case 75 :
                    // InternalPerl.g:875:2: ( 'getpwnam' )
                    {
                    // InternalPerl.g:875:2: ( 'getpwnam' )
                    // InternalPerl.g:876:3: 'getpwnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 
                    match(input,95,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 

                    }


                    }
                    break;
                case 76 :
                    // InternalPerl.g:881:2: ( 'getpwuid' )
                    {
                    // InternalPerl.g:881:2: ( 'getpwuid' )
                    // InternalPerl.g:882:3: 'getpwuid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 
                    match(input,96,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 

                    }


                    }
                    break;
                case 77 :
                    // InternalPerl.g:887:2: ( 'getservbyname' )
                    {
                    // InternalPerl.g:887:2: ( 'getservbyname' )
                    // InternalPerl.g:888:3: 'getservbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 
                    match(input,97,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 

                    }


                    }
                    break;
                case 78 :
                    // InternalPerl.g:893:2: ( 'getservbyport' )
                    {
                    // InternalPerl.g:893:2: ( 'getservbyport' )
                    // InternalPerl.g:894:3: 'getservbyport'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 
                    match(input,98,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 

                    }


                    }
                    break;
                case 79 :
                    // InternalPerl.g:899:2: ( 'getservent' )
                    {
                    // InternalPerl.g:899:2: ( 'getservent' )
                    // InternalPerl.g:900:3: 'getservent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 
                    match(input,99,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 

                    }


                    }
                    break;
                case 80 :
                    // InternalPerl.g:905:2: ( 'getsockname' )
                    {
                    // InternalPerl.g:905:2: ( 'getsockname' )
                    // InternalPerl.g:906:3: 'getsockname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 
                    match(input,100,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 

                    }


                    }
                    break;
                case 81 :
                    // InternalPerl.g:911:2: ( 'getsockopt' )
                    {
                    // InternalPerl.g:911:2: ( 'getsockopt' )
                    // InternalPerl.g:912:3: 'getsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 
                    match(input,101,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 

                    }


                    }
                    break;
                case 82 :
                    // InternalPerl.g:917:2: ( 'given' )
                    {
                    // InternalPerl.g:917:2: ( 'given' )
                    // InternalPerl.g:918:3: 'given'
                    {
                     before(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 
                    match(input,102,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 

                    }


                    }
                    break;
                case 83 :
                    // InternalPerl.g:923:2: ( 'glob' )
                    {
                    // InternalPerl.g:923:2: ( 'glob' )
                    // InternalPerl.g:924:3: 'glob'
                    {
                     before(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 
                    match(input,103,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 

                    }


                    }
                    break;
                case 84 :
                    // InternalPerl.g:929:2: ( 'gmtime' )
                    {
                    // InternalPerl.g:929:2: ( 'gmtime' )
                    // InternalPerl.g:930:3: 'gmtime'
                    {
                     before(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 
                    match(input,104,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 

                    }


                    }
                    break;
                case 85 :
                    // InternalPerl.g:935:2: ( 'goto' )
                    {
                    // InternalPerl.g:935:2: ( 'goto' )
                    // InternalPerl.g:936:3: 'goto'
                    {
                     before(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 
                    match(input,105,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 

                    }


                    }
                    break;
                case 86 :
                    // InternalPerl.g:941:2: ( 'grep' )
                    {
                    // InternalPerl.g:941:2: ( 'grep' )
                    // InternalPerl.g:942:3: 'grep'
                    {
                     before(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 
                    match(input,106,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 

                    }


                    }
                    break;
                case 87 :
                    // InternalPerl.g:947:2: ( 'hex' )
                    {
                    // InternalPerl.g:947:2: ( 'hex' )
                    // InternalPerl.g:948:3: 'hex'
                    {
                     before(grammarAccess.getKeywordAccess().getHexKeyword_86()); 
                    match(input,107,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getHexKeyword_86()); 

                    }


                    }
                    break;
                case 88 :
                    // InternalPerl.g:953:2: ( 'if' )
                    {
                    // InternalPerl.g:953:2: ( 'if' )
                    // InternalPerl.g:954:3: 'if'
                    {
                     before(grammarAccess.getKeywordAccess().getIfKeyword_87()); 
                    match(input,108,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIfKeyword_87()); 

                    }


                    }
                    break;
                case 89 :
                    // InternalPerl.g:959:2: ( 'index' )
                    {
                    // InternalPerl.g:959:2: ( 'index' )
                    // InternalPerl.g:960:3: 'index'
                    {
                     before(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 
                    match(input,109,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 

                    }


                    }
                    break;
                case 90 :
                    // InternalPerl.g:965:2: ( 'int' )
                    {
                    // InternalPerl.g:965:2: ( 'int' )
                    // InternalPerl.g:966:3: 'int'
                    {
                     before(grammarAccess.getKeywordAccess().getIntKeyword_89()); 
                    match(input,110,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIntKeyword_89()); 

                    }


                    }
                    break;
                case 91 :
                    // InternalPerl.g:971:2: ( 'ioctl' )
                    {
                    // InternalPerl.g:971:2: ( 'ioctl' )
                    // InternalPerl.g:972:3: 'ioctl'
                    {
                     before(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 
                    match(input,111,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 

                    }


                    }
                    break;
                case 92 :
                    // InternalPerl.g:977:2: ( 'join' )
                    {
                    // InternalPerl.g:977:2: ( 'join' )
                    // InternalPerl.g:978:3: 'join'
                    {
                     before(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 
                    match(input,112,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 

                    }


                    }
                    break;
                case 93 :
                    // InternalPerl.g:983:2: ( 'keys' )
                    {
                    // InternalPerl.g:983:2: ( 'keys' )
                    // InternalPerl.g:984:3: 'keys'
                    {
                     before(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 
                    match(input,113,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 

                    }


                    }
                    break;
                case 94 :
                    // InternalPerl.g:989:2: ( 'kill' )
                    {
                    // InternalPerl.g:989:2: ( 'kill' )
                    // InternalPerl.g:990:3: 'kill'
                    {
                     before(grammarAccess.getKeywordAccess().getKillKeyword_93()); 
                    match(input,114,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKillKeyword_93()); 

                    }


                    }
                    break;
                case 95 :
                    // InternalPerl.g:995:2: ( 'last' )
                    {
                    // InternalPerl.g:995:2: ( 'last' )
                    // InternalPerl.g:996:3: 'last'
                    {
                     before(grammarAccess.getKeywordAccess().getLastKeyword_94()); 
                    match(input,115,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLastKeyword_94()); 

                    }


                    }
                    break;
                case 96 :
                    // InternalPerl.g:1001:2: ( 'lc' )
                    {
                    // InternalPerl.g:1001:2: ( 'lc' )
                    // InternalPerl.g:1002:3: 'lc'
                    {
                     before(grammarAccess.getKeywordAccess().getLcKeyword_95()); 
                    match(input,116,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcKeyword_95()); 

                    }


                    }
                    break;
                case 97 :
                    // InternalPerl.g:1007:2: ( 'lcfirst' )
                    {
                    // InternalPerl.g:1007:2: ( 'lcfirst' )
                    // InternalPerl.g:1008:3: 'lcfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 
                    match(input,117,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 

                    }


                    }
                    break;
                case 98 :
                    // InternalPerl.g:1013:2: ( 'length' )
                    {
                    // InternalPerl.g:1013:2: ( 'length' )
                    // InternalPerl.g:1014:3: 'length'
                    {
                     before(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 
                    match(input,118,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 

                    }


                    }
                    break;
                case 99 :
                    // InternalPerl.g:1019:2: ( 'link' )
                    {
                    // InternalPerl.g:1019:2: ( 'link' )
                    // InternalPerl.g:1020:3: 'link'
                    {
                     before(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 
                    match(input,119,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 

                    }


                    }
                    break;
                case 100 :
                    // InternalPerl.g:1025:2: ( 'listen' )
                    {
                    // InternalPerl.g:1025:2: ( 'listen' )
                    // InternalPerl.g:1026:3: 'listen'
                    {
                     before(grammarAccess.getKeywordAccess().getListenKeyword_99()); 
                    match(input,120,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getListenKeyword_99()); 

                    }


                    }
                    break;
                case 101 :
                    // InternalPerl.g:1031:2: ( 'local' )
                    {
                    // InternalPerl.g:1031:2: ( 'local' )
                    // InternalPerl.g:1032:3: 'local'
                    {
                     before(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 
                    match(input,121,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 

                    }


                    }
                    break;
                case 102 :
                    // InternalPerl.g:1037:2: ( 'localtime' )
                    {
                    // InternalPerl.g:1037:2: ( 'localtime' )
                    // InternalPerl.g:1038:3: 'localtime'
                    {
                     before(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 
                    match(input,122,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 

                    }


                    }
                    break;
                case 103 :
                    // InternalPerl.g:1043:2: ( 'lock' )
                    {
                    // InternalPerl.g:1043:2: ( 'lock' )
                    // InternalPerl.g:1044:3: 'lock'
                    {
                     before(grammarAccess.getKeywordAccess().getLockKeyword_102()); 
                    match(input,123,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLockKeyword_102()); 

                    }


                    }
                    break;
                case 104 :
                    // InternalPerl.g:1049:2: ( 'log' )
                    {
                    // InternalPerl.g:1049:2: ( 'log' )
                    // InternalPerl.g:1050:3: 'log'
                    {
                     before(grammarAccess.getKeywordAccess().getLogKeyword_103()); 
                    match(input,124,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLogKeyword_103()); 

                    }


                    }
                    break;
                case 105 :
                    // InternalPerl.g:1055:2: ( 'lstat' )
                    {
                    // InternalPerl.g:1055:2: ( 'lstat' )
                    // InternalPerl.g:1056:3: 'lstat'
                    {
                     before(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 
                    match(input,125,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 

                    }


                    }
                    break;
                case 106 :
                    // InternalPerl.g:1061:2: ( 'map' )
                    {
                    // InternalPerl.g:1061:2: ( 'map' )
                    // InternalPerl.g:1062:3: 'map'
                    {
                     before(grammarAccess.getKeywordAccess().getMapKeyword_105()); 
                    match(input,126,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMapKeyword_105()); 

                    }


                    }
                    break;
                case 107 :
                    // InternalPerl.g:1067:2: ( 'mkdir' )
                    {
                    // InternalPerl.g:1067:2: ( 'mkdir' )
                    // InternalPerl.g:1068:3: 'mkdir'
                    {
                     before(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 
                    match(input,127,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 

                    }


                    }
                    break;
                case 108 :
                    // InternalPerl.g:1073:2: ( 'msgctl' )
                    {
                    // InternalPerl.g:1073:2: ( 'msgctl' )
                    // InternalPerl.g:1074:3: 'msgctl'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 
                    match(input,128,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 

                    }


                    }
                    break;
                case 109 :
                    // InternalPerl.g:1079:2: ( 'msgget' )
                    {
                    // InternalPerl.g:1079:2: ( 'msgget' )
                    // InternalPerl.g:1080:3: 'msgget'
                    {
                     before(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 
                    match(input,129,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 

                    }


                    }
                    break;
                case 110 :
                    // InternalPerl.g:1085:2: ( 'msgrcv' )
                    {
                    // InternalPerl.g:1085:2: ( 'msgrcv' )
                    // InternalPerl.g:1086:3: 'msgrcv'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 
                    match(input,130,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 

                    }


                    }
                    break;
                case 111 :
                    // InternalPerl.g:1091:2: ( 'msgsnd' )
                    {
                    // InternalPerl.g:1091:2: ( 'msgsnd' )
                    // InternalPerl.g:1092:3: 'msgsnd'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 
                    match(input,131,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 

                    }


                    }
                    break;
                case 112 :
                    // InternalPerl.g:1097:2: ( 'my' )
                    {
                    // InternalPerl.g:1097:2: ( 'my' )
                    // InternalPerl.g:1098:3: 'my'
                    {
                     before(grammarAccess.getKeywordAccess().getMyKeyword_111()); 
                    match(input,132,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMyKeyword_111()); 

                    }


                    }
                    break;
                case 113 :
                    // InternalPerl.g:1103:2: ( 'next' )
                    {
                    // InternalPerl.g:1103:2: ( 'next' )
                    // InternalPerl.g:1104:3: 'next'
                    {
                     before(grammarAccess.getKeywordAccess().getNextKeyword_112()); 
                    match(input,133,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNextKeyword_112()); 

                    }


                    }
                    break;
                case 114 :
                    // InternalPerl.g:1109:2: ( 'no' )
                    {
                    // InternalPerl.g:1109:2: ( 'no' )
                    // InternalPerl.g:1110:3: 'no'
                    {
                     before(grammarAccess.getKeywordAccess().getNoKeyword_113()); 
                    match(input,134,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNoKeyword_113()); 

                    }


                    }
                    break;
                case 115 :
                    // InternalPerl.g:1115:2: ( 'oct' )
                    {
                    // InternalPerl.g:1115:2: ( 'oct' )
                    // InternalPerl.g:1116:3: 'oct'
                    {
                     before(grammarAccess.getKeywordAccess().getOctKeyword_114()); 
                    match(input,135,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOctKeyword_114()); 

                    }


                    }
                    break;
                case 116 :
                    // InternalPerl.g:1121:2: ( 'open' )
                    {
                    // InternalPerl.g:1121:2: ( 'open' )
                    // InternalPerl.g:1122:3: 'open'
                    {
                     before(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 
                    match(input,136,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 

                    }


                    }
                    break;
                case 117 :
                    // InternalPerl.g:1127:2: ( 'opendir' )
                    {
                    // InternalPerl.g:1127:2: ( 'opendir' )
                    // InternalPerl.g:1128:3: 'opendir'
                    {
                     before(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 
                    match(input,137,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 

                    }


                    }
                    break;
                case 118 :
                    // InternalPerl.g:1133:2: ( 'ord' )
                    {
                    // InternalPerl.g:1133:2: ( 'ord' )
                    // InternalPerl.g:1134:3: 'ord'
                    {
                     before(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 
                    match(input,138,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 

                    }


                    }
                    break;
                case 119 :
                    // InternalPerl.g:1139:2: ( 'our' )
                    {
                    // InternalPerl.g:1139:2: ( 'our' )
                    // InternalPerl.g:1140:3: 'our'
                    {
                     before(grammarAccess.getKeywordAccess().getOurKeyword_118()); 
                    match(input,139,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOurKeyword_118()); 

                    }


                    }
                    break;
                case 120 :
                    // InternalPerl.g:1145:2: ( 'pack' )
                    {
                    // InternalPerl.g:1145:2: ( 'pack' )
                    // InternalPerl.g:1146:3: 'pack'
                    {
                     before(grammarAccess.getKeywordAccess().getPackKeyword_119()); 
                    match(input,140,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackKeyword_119()); 

                    }


                    }
                    break;
                case 121 :
                    // InternalPerl.g:1151:2: ( 'package' )
                    {
                    // InternalPerl.g:1151:2: ( 'package' )
                    // InternalPerl.g:1152:3: 'package'
                    {
                     before(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 
                    match(input,141,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 

                    }


                    }
                    break;
                case 122 :
                    // InternalPerl.g:1157:2: ( 'pipe' )
                    {
                    // InternalPerl.g:1157:2: ( 'pipe' )
                    // InternalPerl.g:1158:3: 'pipe'
                    {
                     before(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 
                    match(input,142,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 

                    }


                    }
                    break;
                case 123 :
                    // InternalPerl.g:1163:2: ( 'pop' )
                    {
                    // InternalPerl.g:1163:2: ( 'pop' )
                    // InternalPerl.g:1164:3: 'pop'
                    {
                     before(grammarAccess.getKeywordAccess().getPopKeyword_122()); 
                    match(input,143,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPopKeyword_122()); 

                    }


                    }
                    break;
                case 124 :
                    // InternalPerl.g:1169:2: ( 'pos' )
                    {
                    // InternalPerl.g:1169:2: ( 'pos' )
                    // InternalPerl.g:1170:3: 'pos'
                    {
                     before(grammarAccess.getKeywordAccess().getPosKeyword_123()); 
                    match(input,144,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPosKeyword_123()); 

                    }


                    }
                    break;
                case 125 :
                    // InternalPerl.g:1175:2: ( 'print' )
                    {
                    // InternalPerl.g:1175:2: ( 'print' )
                    // InternalPerl.g:1176:3: 'print'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 
                    match(input,145,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 

                    }


                    }
                    break;
                case 126 :
                    // InternalPerl.g:1181:2: ( 'printf' )
                    {
                    // InternalPerl.g:1181:2: ( 'printf' )
                    // InternalPerl.g:1182:3: 'printf'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 
                    match(input,146,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 

                    }


                    }
                    break;
                case 127 :
                    // InternalPerl.g:1187:2: ( 'prototype' )
                    {
                    // InternalPerl.g:1187:2: ( 'prototype' )
                    // InternalPerl.g:1188:3: 'prototype'
                    {
                     before(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 
                    match(input,147,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 

                    }


                    }
                    break;
                case 128 :
                    // InternalPerl.g:1193:2: ( 'push' )
                    {
                    // InternalPerl.g:1193:2: ( 'push' )
                    // InternalPerl.g:1194:3: 'push'
                    {
                     before(grammarAccess.getKeywordAccess().getPushKeyword_127()); 
                    match(input,148,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPushKeyword_127()); 

                    }


                    }
                    break;
                case 129 :
                    // InternalPerl.g:1199:2: ( 'quotemeta' )
                    {
                    // InternalPerl.g:1199:2: ( 'quotemeta' )
                    // InternalPerl.g:1200:3: 'quotemeta'
                    {
                     before(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 
                    match(input,149,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 

                    }


                    }
                    break;
                case 130 :
                    // InternalPerl.g:1205:2: ( 'rand' )
                    {
                    // InternalPerl.g:1205:2: ( 'rand' )
                    // InternalPerl.g:1206:3: 'rand'
                    {
                     before(grammarAccess.getKeywordAccess().getRandKeyword_129()); 
                    match(input,150,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRandKeyword_129()); 

                    }


                    }
                    break;
                case 131 :
                    // InternalPerl.g:1211:2: ( 'read' )
                    {
                    // InternalPerl.g:1211:2: ( 'read' )
                    // InternalPerl.g:1212:3: 'read'
                    {
                     before(grammarAccess.getKeywordAccess().getReadKeyword_130()); 
                    match(input,151,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadKeyword_130()); 

                    }


                    }
                    break;
                case 132 :
                    // InternalPerl.g:1217:2: ( 'readdir' )
                    {
                    // InternalPerl.g:1217:2: ( 'readdir' )
                    // InternalPerl.g:1218:3: 'readdir'
                    {
                     before(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 
                    match(input,152,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 

                    }


                    }
                    break;
                case 133 :
                    // InternalPerl.g:1223:2: ( 'readline' )
                    {
                    // InternalPerl.g:1223:2: ( 'readline' )
                    // InternalPerl.g:1224:3: 'readline'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 
                    match(input,153,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 

                    }


                    }
                    break;
                case 134 :
                    // InternalPerl.g:1229:2: ( 'readlink' )
                    {
                    // InternalPerl.g:1229:2: ( 'readlink' )
                    // InternalPerl.g:1230:3: 'readlink'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 
                    match(input,154,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 

                    }


                    }
                    break;
                case 135 :
                    // InternalPerl.g:1235:2: ( 'readpipe' )
                    {
                    // InternalPerl.g:1235:2: ( 'readpipe' )
                    // InternalPerl.g:1236:3: 'readpipe'
                    {
                     before(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 
                    match(input,155,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 

                    }


                    }
                    break;
                case 136 :
                    // InternalPerl.g:1241:2: ( 'recv' )
                    {
                    // InternalPerl.g:1241:2: ( 'recv' )
                    // InternalPerl.g:1242:3: 'recv'
                    {
                     before(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 
                    match(input,156,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 

                    }


                    }
                    break;
                case 137 :
                    // InternalPerl.g:1247:2: ( 'redo' )
                    {
                    // InternalPerl.g:1247:2: ( 'redo' )
                    // InternalPerl.g:1248:3: 'redo'
                    {
                     before(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 
                    match(input,157,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 

                    }


                    }
                    break;
                case 138 :
                    // InternalPerl.g:1253:2: ( 'ref' )
                    {
                    // InternalPerl.g:1253:2: ( 'ref' )
                    // InternalPerl.g:1254:3: 'ref'
                    {
                     before(grammarAccess.getKeywordAccess().getRefKeyword_137()); 
                    match(input,158,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRefKeyword_137()); 

                    }


                    }
                    break;
                case 139 :
                    // InternalPerl.g:1259:2: ( 'rename' )
                    {
                    // InternalPerl.g:1259:2: ( 'rename' )
                    // InternalPerl.g:1260:3: 'rename'
                    {
                     before(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 
                    match(input,159,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 

                    }


                    }
                    break;
                case 140 :
                    // InternalPerl.g:1265:2: ( 'require' )
                    {
                    // InternalPerl.g:1265:2: ( 'require' )
                    // InternalPerl.g:1266:3: 'require'
                    {
                     before(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 
                    match(input,160,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 

                    }


                    }
                    break;
                case 141 :
                    // InternalPerl.g:1271:2: ( 'reset' )
                    {
                    // InternalPerl.g:1271:2: ( 'reset' )
                    // InternalPerl.g:1272:3: 'reset'
                    {
                     before(grammarAccess.getKeywordAccess().getResetKeyword_140()); 
                    match(input,161,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getResetKeyword_140()); 

                    }


                    }
                    break;
                case 142 :
                    // InternalPerl.g:1277:2: ( 'return' )
                    {
                    // InternalPerl.g:1277:2: ( 'return' )
                    // InternalPerl.g:1278:3: 'return'
                    {
                     before(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 
                    match(input,162,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 

                    }


                    }
                    break;
                case 143 :
                    // InternalPerl.g:1283:2: ( 'reverse' )
                    {
                    // InternalPerl.g:1283:2: ( 'reverse' )
                    // InternalPerl.g:1284:3: 'reverse'
                    {
                     before(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 
                    match(input,163,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 

                    }


                    }
                    break;
                case 144 :
                    // InternalPerl.g:1289:2: ( 'rewinddir' )
                    {
                    // InternalPerl.g:1289:2: ( 'rewinddir' )
                    // InternalPerl.g:1290:3: 'rewinddir'
                    {
                     before(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 
                    match(input,164,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 

                    }


                    }
                    break;
                case 145 :
                    // InternalPerl.g:1295:2: ( 'rindex' )
                    {
                    // InternalPerl.g:1295:2: ( 'rindex' )
                    // InternalPerl.g:1296:3: 'rindex'
                    {
                     before(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 
                    match(input,165,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 

                    }


                    }
                    break;
                case 146 :
                    // InternalPerl.g:1301:2: ( 'rmdir' )
                    {
                    // InternalPerl.g:1301:2: ( 'rmdir' )
                    // InternalPerl.g:1302:3: 'rmdir'
                    {
                     before(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 
                    match(input,166,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 

                    }


                    }
                    break;
                case 147 :
                    // InternalPerl.g:1307:2: ( 'say' )
                    {
                    // InternalPerl.g:1307:2: ( 'say' )
                    // InternalPerl.g:1308:3: 'say'
                    {
                     before(grammarAccess.getKeywordAccess().getSayKeyword_146()); 
                    match(input,167,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSayKeyword_146()); 

                    }


                    }
                    break;
                case 148 :
                    // InternalPerl.g:1313:2: ( 'scalar' )
                    {
                    // InternalPerl.g:1313:2: ( 'scalar' )
                    // InternalPerl.g:1314:3: 'scalar'
                    {
                     before(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 
                    match(input,168,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 

                    }


                    }
                    break;
                case 149 :
                    // InternalPerl.g:1319:2: ( 'seek' )
                    {
                    // InternalPerl.g:1319:2: ( 'seek' )
                    // InternalPerl.g:1320:3: 'seek'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 
                    match(input,169,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 

                    }


                    }
                    break;
                case 150 :
                    // InternalPerl.g:1325:2: ( 'seekdir' )
                    {
                    // InternalPerl.g:1325:2: ( 'seekdir' )
                    // InternalPerl.g:1326:3: 'seekdir'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 
                    match(input,170,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 

                    }


                    }
                    break;
                case 151 :
                    // InternalPerl.g:1331:2: ( 'select' )
                    {
                    // InternalPerl.g:1331:2: ( 'select' )
                    // InternalPerl.g:1332:3: 'select'
                    {
                     before(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 
                    match(input,171,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 

                    }


                    }
                    break;
                case 152 :
                    // InternalPerl.g:1337:2: ( 'semctl' )
                    {
                    // InternalPerl.g:1337:2: ( 'semctl' )
                    // InternalPerl.g:1338:3: 'semctl'
                    {
                     before(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 
                    match(input,172,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 

                    }


                    }
                    break;
                case 153 :
                    // InternalPerl.g:1343:2: ( 'semget' )
                    {
                    // InternalPerl.g:1343:2: ( 'semget' )
                    // InternalPerl.g:1344:3: 'semget'
                    {
                     before(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 
                    match(input,173,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 

                    }


                    }
                    break;
                case 154 :
                    // InternalPerl.g:1349:2: ( 'semop' )
                    {
                    // InternalPerl.g:1349:2: ( 'semop' )
                    // InternalPerl.g:1350:3: 'semop'
                    {
                     before(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 
                    match(input,174,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 

                    }


                    }
                    break;
                case 155 :
                    // InternalPerl.g:1355:2: ( 'send' )
                    {
                    // InternalPerl.g:1355:2: ( 'send' )
                    // InternalPerl.g:1356:3: 'send'
                    {
                     before(grammarAccess.getKeywordAccess().getSendKeyword_154()); 
                    match(input,175,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSendKeyword_154()); 

                    }


                    }
                    break;
                case 156 :
                    // InternalPerl.g:1361:2: ( 'setgrent' )
                    {
                    // InternalPerl.g:1361:2: ( 'setgrent' )
                    // InternalPerl.g:1362:3: 'setgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 
                    match(input,176,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 

                    }


                    }
                    break;
                case 157 :
                    // InternalPerl.g:1367:2: ( 'sethostent' )
                    {
                    // InternalPerl.g:1367:2: ( 'sethostent' )
                    // InternalPerl.g:1368:3: 'sethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 
                    match(input,177,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 

                    }


                    }
                    break;
                case 158 :
                    // InternalPerl.g:1373:2: ( 'setnetent' )
                    {
                    // InternalPerl.g:1373:2: ( 'setnetent' )
                    // InternalPerl.g:1374:3: 'setnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 
                    match(input,178,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 

                    }


                    }
                    break;
                case 159 :
                    // InternalPerl.g:1379:2: ( 'setpgrp' )
                    {
                    // InternalPerl.g:1379:2: ( 'setpgrp' )
                    // InternalPerl.g:1380:3: 'setpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 
                    match(input,179,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 

                    }


                    }
                    break;
                case 160 :
                    // InternalPerl.g:1385:2: ( 'setpriority' )
                    {
                    // InternalPerl.g:1385:2: ( 'setpriority' )
                    // InternalPerl.g:1386:3: 'setpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 
                    match(input,180,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 

                    }


                    }
                    break;
                case 161 :
                    // InternalPerl.g:1391:2: ( 'setprotoent' )
                    {
                    // InternalPerl.g:1391:2: ( 'setprotoent' )
                    // InternalPerl.g:1392:3: 'setprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 
                    match(input,181,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 

                    }


                    }
                    break;
                case 162 :
                    // InternalPerl.g:1397:2: ( 'setpwent' )
                    {
                    // InternalPerl.g:1397:2: ( 'setpwent' )
                    // InternalPerl.g:1398:3: 'setpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 
                    match(input,182,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 

                    }


                    }
                    break;
                case 163 :
                    // InternalPerl.g:1403:2: ( 'setservent' )
                    {
                    // InternalPerl.g:1403:2: ( 'setservent' )
                    // InternalPerl.g:1404:3: 'setservent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 
                    match(input,183,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 

                    }


                    }
                    break;
                case 164 :
                    // InternalPerl.g:1409:2: ( 'setsockopt' )
                    {
                    // InternalPerl.g:1409:2: ( 'setsockopt' )
                    // InternalPerl.g:1410:3: 'setsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 
                    match(input,184,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 

                    }


                    }
                    break;
                case 165 :
                    // InternalPerl.g:1415:2: ( 'shift' )
                    {
                    // InternalPerl.g:1415:2: ( 'shift' )
                    // InternalPerl.g:1416:3: 'shift'
                    {
                     before(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 
                    match(input,185,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 

                    }


                    }
                    break;
                case 166 :
                    // InternalPerl.g:1421:2: ( 'shmctl' )
                    {
                    // InternalPerl.g:1421:2: ( 'shmctl' )
                    // InternalPerl.g:1422:3: 'shmctl'
                    {
                     before(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 
                    match(input,186,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 

                    }


                    }
                    break;
                case 167 :
                    // InternalPerl.g:1427:2: ( 'shmget' )
                    {
                    // InternalPerl.g:1427:2: ( 'shmget' )
                    // InternalPerl.g:1428:3: 'shmget'
                    {
                     before(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 
                    match(input,187,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 

                    }


                    }
                    break;
                case 168 :
                    // InternalPerl.g:1433:2: ( 'shmread' )
                    {
                    // InternalPerl.g:1433:2: ( 'shmread' )
                    // InternalPerl.g:1434:3: 'shmread'
                    {
                     before(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 
                    match(input,188,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 

                    }


                    }
                    break;
                case 169 :
                    // InternalPerl.g:1439:2: ( 'shmwrite' )
                    {
                    // InternalPerl.g:1439:2: ( 'shmwrite' )
                    // InternalPerl.g:1440:3: 'shmwrite'
                    {
                     before(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 
                    match(input,189,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 

                    }


                    }
                    break;
                case 170 :
                    // InternalPerl.g:1445:2: ( 'shutdown' )
                    {
                    // InternalPerl.g:1445:2: ( 'shutdown' )
                    // InternalPerl.g:1446:3: 'shutdown'
                    {
                     before(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 
                    match(input,190,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 

                    }


                    }
                    break;
                case 171 :
                    // InternalPerl.g:1451:2: ( 'sin' )
                    {
                    // InternalPerl.g:1451:2: ( 'sin' )
                    // InternalPerl.g:1452:3: 'sin'
                    {
                     before(grammarAccess.getKeywordAccess().getSinKeyword_170()); 
                    match(input,191,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSinKeyword_170()); 

                    }


                    }
                    break;
                case 172 :
                    // InternalPerl.g:1457:2: ( 'sleep' )
                    {
                    // InternalPerl.g:1457:2: ( 'sleep' )
                    // InternalPerl.g:1458:3: 'sleep'
                    {
                     before(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 
                    match(input,192,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 

                    }


                    }
                    break;
                case 173 :
                    // InternalPerl.g:1463:2: ( 'socket' )
                    {
                    // InternalPerl.g:1463:2: ( 'socket' )
                    // InternalPerl.g:1464:3: 'socket'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 
                    match(input,193,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 

                    }


                    }
                    break;
                case 174 :
                    // InternalPerl.g:1469:2: ( 'socketpair' )
                    {
                    // InternalPerl.g:1469:2: ( 'socketpair' )
                    // InternalPerl.g:1470:3: 'socketpair'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 
                    match(input,194,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 

                    }


                    }
                    break;
                case 175 :
                    // InternalPerl.g:1475:2: ( 'sort' )
                    {
                    // InternalPerl.g:1475:2: ( 'sort' )
                    // InternalPerl.g:1476:3: 'sort'
                    {
                     before(grammarAccess.getKeywordAccess().getSortKeyword_174()); 
                    match(input,195,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSortKeyword_174()); 

                    }


                    }
                    break;
                case 176 :
                    // InternalPerl.g:1481:2: ( 'splice' )
                    {
                    // InternalPerl.g:1481:2: ( 'splice' )
                    // InternalPerl.g:1482:3: 'splice'
                    {
                     before(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 
                    match(input,196,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 

                    }


                    }
                    break;
                case 177 :
                    // InternalPerl.g:1487:2: ( 'split' )
                    {
                    // InternalPerl.g:1487:2: ( 'split' )
                    // InternalPerl.g:1488:3: 'split'
                    {
                     before(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 
                    match(input,197,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 

                    }


                    }
                    break;
                case 178 :
                    // InternalPerl.g:1493:2: ( 'sprintf' )
                    {
                    // InternalPerl.g:1493:2: ( 'sprintf' )
                    // InternalPerl.g:1494:3: 'sprintf'
                    {
                     before(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 
                    match(input,198,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 

                    }


                    }
                    break;
                case 179 :
                    // InternalPerl.g:1499:2: ( 'sqrt' )
                    {
                    // InternalPerl.g:1499:2: ( 'sqrt' )
                    // InternalPerl.g:1500:3: 'sqrt'
                    {
                     before(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 
                    match(input,199,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 

                    }


                    }
                    break;
                case 180 :
                    // InternalPerl.g:1505:2: ( 'srand' )
                    {
                    // InternalPerl.g:1505:2: ( 'srand' )
                    // InternalPerl.g:1506:3: 'srand'
                    {
                     before(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 
                    match(input,200,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 

                    }


                    }
                    break;
                case 181 :
                    // InternalPerl.g:1511:2: ( 'stat' )
                    {
                    // InternalPerl.g:1511:2: ( 'stat' )
                    // InternalPerl.g:1512:3: 'stat'
                    {
                     before(grammarAccess.getKeywordAccess().getStatKeyword_180()); 
                    match(input,201,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStatKeyword_180()); 

                    }


                    }
                    break;
                case 182 :
                    // InternalPerl.g:1517:2: ( 'state' )
                    {
                    // InternalPerl.g:1517:2: ( 'state' )
                    // InternalPerl.g:1518:3: 'state'
                    {
                     before(grammarAccess.getKeywordAccess().getStateKeyword_181()); 
                    match(input,202,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStateKeyword_181()); 

                    }


                    }
                    break;
                case 183 :
                    // InternalPerl.g:1523:2: ( 'study' )
                    {
                    // InternalPerl.g:1523:2: ( 'study' )
                    // InternalPerl.g:1524:3: 'study'
                    {
                     before(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 
                    match(input,203,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 

                    }


                    }
                    break;
                case 184 :
                    // InternalPerl.g:1529:2: ( 'sub' )
                    {
                    // InternalPerl.g:1529:2: ( 'sub' )
                    // InternalPerl.g:1530:3: 'sub'
                    {
                     before(grammarAccess.getKeywordAccess().getSubKeyword_183()); 
                    match(input,204,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubKeyword_183()); 

                    }


                    }
                    break;
                case 185 :
                    // InternalPerl.g:1535:2: ( 'substr' )
                    {
                    // InternalPerl.g:1535:2: ( 'substr' )
                    // InternalPerl.g:1536:3: 'substr'
                    {
                     before(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 
                    match(input,205,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 

                    }


                    }
                    break;
                case 186 :
                    // InternalPerl.g:1541:2: ( 'symlink' )
                    {
                    // InternalPerl.g:1541:2: ( 'symlink' )
                    // InternalPerl.g:1542:3: 'symlink'
                    {
                     before(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 
                    match(input,206,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 

                    }


                    }
                    break;
                case 187 :
                    // InternalPerl.g:1547:2: ( 'syscall' )
                    {
                    // InternalPerl.g:1547:2: ( 'syscall' )
                    // InternalPerl.g:1548:3: 'syscall'
                    {
                     before(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 
                    match(input,207,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 

                    }


                    }
                    break;
                case 188 :
                    // InternalPerl.g:1553:2: ( 'sysopen' )
                    {
                    // InternalPerl.g:1553:2: ( 'sysopen' )
                    // InternalPerl.g:1554:3: 'sysopen'
                    {
                     before(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 
                    match(input,208,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 

                    }


                    }
                    break;
                case 189 :
                    // InternalPerl.g:1559:2: ( 'sysread' )
                    {
                    // InternalPerl.g:1559:2: ( 'sysread' )
                    // InternalPerl.g:1560:3: 'sysread'
                    {
                     before(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 
                    match(input,209,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 

                    }


                    }
                    break;
                case 190 :
                    // InternalPerl.g:1565:2: ( 'sysseek' )
                    {
                    // InternalPerl.g:1565:2: ( 'sysseek' )
                    // InternalPerl.g:1566:3: 'sysseek'
                    {
                     before(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 
                    match(input,210,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 

                    }


                    }
                    break;
                case 191 :
                    // InternalPerl.g:1571:2: ( 'system' )
                    {
                    // InternalPerl.g:1571:2: ( 'system' )
                    // InternalPerl.g:1572:3: 'system'
                    {
                     before(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 
                    match(input,211,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 

                    }


                    }
                    break;
                case 192 :
                    // InternalPerl.g:1577:2: ( 'syswrite' )
                    {
                    // InternalPerl.g:1577:2: ( 'syswrite' )
                    // InternalPerl.g:1578:3: 'syswrite'
                    {
                     before(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 
                    match(input,212,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 

                    }


                    }
                    break;
                case 193 :
                    // InternalPerl.g:1583:2: ( 'tell' )
                    {
                    // InternalPerl.g:1583:2: ( 'tell' )
                    // InternalPerl.g:1584:3: 'tell'
                    {
                     before(grammarAccess.getKeywordAccess().getTellKeyword_192()); 
                    match(input,213,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTellKeyword_192()); 

                    }


                    }
                    break;
                case 194 :
                    // InternalPerl.g:1589:2: ( 'telldir' )
                    {
                    // InternalPerl.g:1589:2: ( 'telldir' )
                    // InternalPerl.g:1590:3: 'telldir'
                    {
                     before(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 
                    match(input,214,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 

                    }


                    }
                    break;
                case 195 :
                    // InternalPerl.g:1595:2: ( 'tie' )
                    {
                    // InternalPerl.g:1595:2: ( 'tie' )
                    // InternalPerl.g:1596:3: 'tie'
                    {
                     before(grammarAccess.getKeywordAccess().getTieKeyword_194()); 
                    match(input,215,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTieKeyword_194()); 

                    }


                    }
                    break;
                case 196 :
                    // InternalPerl.g:1601:2: ( 'tied' )
                    {
                    // InternalPerl.g:1601:2: ( 'tied' )
                    // InternalPerl.g:1602:3: 'tied'
                    {
                     before(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 
                    match(input,216,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 

                    }


                    }
                    break;
                case 197 :
                    // InternalPerl.g:1607:2: ( 'time' )
                    {
                    // InternalPerl.g:1607:2: ( 'time' )
                    // InternalPerl.g:1608:3: 'time'
                    {
                     before(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 
                    match(input,217,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 

                    }


                    }
                    break;
                case 198 :
                    // InternalPerl.g:1613:2: ( 'times' )
                    {
                    // InternalPerl.g:1613:2: ( 'times' )
                    // InternalPerl.g:1614:3: 'times'
                    {
                     before(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 
                    match(input,218,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 

                    }


                    }
                    break;
                case 199 :
                    // InternalPerl.g:1619:2: ( 'tr' )
                    {
                    // InternalPerl.g:1619:2: ( 'tr' )
                    // InternalPerl.g:1620:3: 'tr'
                    {
                     before(grammarAccess.getKeywordAccess().getTrKeyword_198()); 
                    match(input,219,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTrKeyword_198()); 

                    }


                    }
                    break;
                case 200 :
                    // InternalPerl.g:1625:2: ( 'truncate' )
                    {
                    // InternalPerl.g:1625:2: ( 'truncate' )
                    // InternalPerl.g:1626:3: 'truncate'
                    {
                     before(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 
                    match(input,220,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 

                    }


                    }
                    break;
                case 201 :
                    // InternalPerl.g:1631:2: ( 'uc' )
                    {
                    // InternalPerl.g:1631:2: ( 'uc' )
                    // InternalPerl.g:1632:3: 'uc'
                    {
                     before(grammarAccess.getKeywordAccess().getUcKeyword_200()); 
                    match(input,221,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcKeyword_200()); 

                    }


                    }
                    break;
                case 202 :
                    // InternalPerl.g:1637:2: ( 'ucfirst' )
                    {
                    // InternalPerl.g:1637:2: ( 'ucfirst' )
                    // InternalPerl.g:1638:3: 'ucfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 
                    match(input,222,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 

                    }


                    }
                    break;
                case 203 :
                    // InternalPerl.g:1643:2: ( 'umask' )
                    {
                    // InternalPerl.g:1643:2: ( 'umask' )
                    // InternalPerl.g:1644:3: 'umask'
                    {
                     before(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 
                    match(input,223,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 

                    }


                    }
                    break;
                case 204 :
                    // InternalPerl.g:1649:2: ( 'undef' )
                    {
                    // InternalPerl.g:1649:2: ( 'undef' )
                    // InternalPerl.g:1650:3: 'undef'
                    {
                     before(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 
                    match(input,224,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 

                    }


                    }
                    break;
                case 205 :
                    // InternalPerl.g:1655:2: ( 'unless' )
                    {
                    // InternalPerl.g:1655:2: ( 'unless' )
                    // InternalPerl.g:1656:3: 'unless'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 
                    match(input,225,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 

                    }


                    }
                    break;
                case 206 :
                    // InternalPerl.g:1661:2: ( 'unlink' )
                    {
                    // InternalPerl.g:1661:2: ( 'unlink' )
                    // InternalPerl.g:1662:3: 'unlink'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 
                    match(input,226,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 

                    }


                    }
                    break;
                case 207 :
                    // InternalPerl.g:1667:2: ( 'unpack' )
                    {
                    // InternalPerl.g:1667:2: ( 'unpack' )
                    // InternalPerl.g:1668:3: 'unpack'
                    {
                     before(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 
                    match(input,227,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 

                    }


                    }
                    break;
                case 208 :
                    // InternalPerl.g:1673:2: ( 'unshift' )
                    {
                    // InternalPerl.g:1673:2: ( 'unshift' )
                    // InternalPerl.g:1674:3: 'unshift'
                    {
                     before(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 
                    match(input,228,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 

                    }


                    }
                    break;
                case 209 :
                    // InternalPerl.g:1679:2: ( 'untie' )
                    {
                    // InternalPerl.g:1679:2: ( 'untie' )
                    // InternalPerl.g:1680:3: 'untie'
                    {
                     before(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 
                    match(input,229,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 

                    }


                    }
                    break;
                case 210 :
                    // InternalPerl.g:1685:2: ( 'until' )
                    {
                    // InternalPerl.g:1685:2: ( 'until' )
                    // InternalPerl.g:1686:3: 'until'
                    {
                     before(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 
                    match(input,230,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 

                    }


                    }
                    break;
                case 211 :
                    // InternalPerl.g:1691:2: ( 'use' )
                    {
                    // InternalPerl.g:1691:2: ( 'use' )
                    // InternalPerl.g:1692:3: 'use'
                    {
                     before(grammarAccess.getKeywordAccess().getUseKeyword_210()); 
                    match(input,231,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUseKeyword_210()); 

                    }


                    }
                    break;
                case 212 :
                    // InternalPerl.g:1697:2: ( 'utime' )
                    {
                    // InternalPerl.g:1697:2: ( 'utime' )
                    // InternalPerl.g:1698:3: 'utime'
                    {
                     before(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 
                    match(input,232,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 

                    }


                    }
                    break;
                case 213 :
                    // InternalPerl.g:1703:2: ( 'values' )
                    {
                    // InternalPerl.g:1703:2: ( 'values' )
                    // InternalPerl.g:1704:3: 'values'
                    {
                     before(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 
                    match(input,233,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 

                    }


                    }
                    break;
                case 214 :
                    // InternalPerl.g:1709:2: ( 'vec' )
                    {
                    // InternalPerl.g:1709:2: ( 'vec' )
                    // InternalPerl.g:1710:3: 'vec'
                    {
                     before(grammarAccess.getKeywordAccess().getVecKeyword_213()); 
                    match(input,234,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getVecKeyword_213()); 

                    }


                    }
                    break;
                case 215 :
                    // InternalPerl.g:1715:2: ( 'wait' )
                    {
                    // InternalPerl.g:1715:2: ( 'wait' )
                    // InternalPerl.g:1716:3: 'wait'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 
                    match(input,235,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 

                    }


                    }
                    break;
                case 216 :
                    // InternalPerl.g:1721:2: ( 'waitpid' )
                    {
                    // InternalPerl.g:1721:2: ( 'waitpid' )
                    // InternalPerl.g:1722:3: 'waitpid'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 
                    match(input,236,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 

                    }


                    }
                    break;
                case 217 :
                    // InternalPerl.g:1727:2: ( 'wantarray' )
                    {
                    // InternalPerl.g:1727:2: ( 'wantarray' )
                    // InternalPerl.g:1728:3: 'wantarray'
                    {
                     before(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 
                    match(input,237,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 

                    }


                    }
                    break;
                case 218 :
                    // InternalPerl.g:1733:2: ( 'warn' )
                    {
                    // InternalPerl.g:1733:2: ( 'warn' )
                    // InternalPerl.g:1734:3: 'warn'
                    {
                     before(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 
                    match(input,238,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 

                    }


                    }
                    break;
                case 219 :
                    // InternalPerl.g:1739:2: ( 'when' )
                    {
                    // InternalPerl.g:1739:2: ( 'when' )
                    // InternalPerl.g:1740:3: 'when'
                    {
                     before(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 
                    match(input,239,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 

                    }


                    }
                    break;
                case 220 :
                    // InternalPerl.g:1745:2: ( 'while' )
                    {
                    // InternalPerl.g:1745:2: ( 'while' )
                    // InternalPerl.g:1746:3: 'while'
                    {
                     before(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 
                    match(input,240,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 

                    }


                    }
                    break;
                case 221 :
                    // InternalPerl.g:1751:2: ( 'write' )
                    {
                    // InternalPerl.g:1751:2: ( 'write' )
                    // InternalPerl.g:1752:3: 'write'
                    {
                     before(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 
                    match(input,241,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 

                    }


                    }
                    break;
                case 222 :
                    // InternalPerl.g:1757:2: ( 'y' )
                    {
                    // InternalPerl.g:1757:2: ( 'y' )
                    // InternalPerl.g:1758:3: 'y'
                    {
                     before(grammarAccess.getKeywordAccess().getYKeyword_221()); 
                    match(input,242,FOLLOW_2); 
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
    // InternalPerl.g:1767:1: rule__Operator__Alternatives : ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1771:1: ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) )
            int alt5=64;
            switch ( input.LA(1) ) {
            case 243:
                {
                alt5=1;
                }
                break;
            case 244:
                {
                alt5=2;
                }
                break;
            case 245:
                {
                alt5=3;
                }
                break;
            case 246:
                {
                alt5=4;
                }
                break;
            case 247:
                {
                alt5=5;
                }
                break;
            case 248:
                {
                alt5=6;
                }
                break;
            case 249:
                {
                alt5=7;
                }
                break;
            case 250:
                {
                alt5=8;
                }
                break;
            case 251:
                {
                alt5=9;
                }
                break;
            case 252:
                {
                alt5=10;
                }
                break;
            case 253:
                {
                alt5=11;
                }
                break;
            case 254:
                {
                alt5=12;
                }
                break;
            case 255:
                {
                alt5=13;
                }
                break;
            case 256:
                {
                alt5=14;
                }
                break;
            case 257:
                {
                alt5=15;
                }
                break;
            case 258:
                {
                alt5=16;
                }
                break;
            case 259:
                {
                alt5=17;
                }
                break;
            case 260:
                {
                alt5=18;
                }
                break;
            case 261:
                {
                alt5=19;
                }
                break;
            case 262:
                {
                alt5=20;
                }
                break;
            case 263:
                {
                alt5=21;
                }
                break;
            case 264:
                {
                alt5=22;
                }
                break;
            case 265:
                {
                alt5=23;
                }
                break;
            case 334:
                {
                alt5=24;
                }
                break;
            case 266:
                {
                alt5=25;
                }
                break;
            case 267:
                {
                alt5=26;
                }
                break;
            case 268:
                {
                alt5=27;
                }
                break;
            case 269:
                {
                alt5=28;
                }
                break;
            case 270:
                {
                alt5=29;
                }
                break;
            case 271:
                {
                alt5=30;
                }
                break;
            case 272:
                {
                alt5=31;
                }
                break;
            case 273:
                {
                alt5=32;
                }
                break;
            case 274:
                {
                alt5=33;
                }
                break;
            case 275:
                {
                alt5=34;
                }
                break;
            case 276:
                {
                alt5=35;
                }
                break;
            case 277:
                {
                alt5=36;
                }
                break;
            case 278:
                {
                alt5=37;
                }
                break;
            case 279:
                {
                alt5=38;
                }
                break;
            case 280:
                {
                alt5=39;
                }
                break;
            case 281:
                {
                alt5=40;
                }
                break;
            case 282:
                {
                alt5=41;
                }
                break;
            case 283:
                {
                alt5=42;
                }
                break;
            case 284:
                {
                alt5=43;
                }
                break;
            case 285:
                {
                alt5=44;
                }
                break;
            case 286:
                {
                alt5=45;
                }
                break;
            case 287:
                {
                alt5=46;
                }
                break;
            case 288:
                {
                alt5=47;
                }
                break;
            case 289:
                {
                alt5=48;
                }
                break;
            case 290:
                {
                alt5=49;
                }
                break;
            case 291:
                {
                alt5=50;
                }
                break;
            case 292:
                {
                alt5=51;
                }
                break;
            case 293:
                {
                alt5=52;
                }
                break;
            case 294:
                {
                alt5=53;
                }
                break;
            case 295:
                {
                alt5=54;
                }
                break;
            case 296:
                {
                alt5=55;
                }
                break;
            case 297:
                {
                alt5=56;
                }
                break;
            case 298:
                {
                alt5=57;
                }
                break;
            case 299:
                {
                alt5=58;
                }
                break;
            case 300:
                {
                alt5=59;
                }
                break;
            case 301:
                {
                alt5=60;
                }
                break;
            case 302:
                {
                alt5=61;
                }
                break;
            case 303:
                {
                alt5=62;
                }
                break;
            case 304:
                {
                alt5=63;
                }
                break;
            case 305:
                {
                alt5=64;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalPerl.g:1772:2: ( '++' )
                    {
                    // InternalPerl.g:1772:2: ( '++' )
                    // InternalPerl.g:1773:3: '++'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 
                    match(input,243,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1778:2: ( '--' )
                    {
                    // InternalPerl.g:1778:2: ( '--' )
                    // InternalPerl.g:1779:3: '--'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    match(input,244,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1784:2: ( '**' )
                    {
                    // InternalPerl.g:1784:2: ( '**' )
                    // InternalPerl.g:1785:3: '**'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 
                    match(input,245,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1790:2: ( '!' )
                    {
                    // InternalPerl.g:1790:2: ( '!' )
                    // InternalPerl.g:1791:3: '!'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 
                    match(input,246,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:1796:2: ( '~' )
                    {
                    // InternalPerl.g:1796:2: ( '~' )
                    // InternalPerl.g:1797:3: '~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 
                    match(input,247,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:1802:2: ( '+' )
                    {
                    // InternalPerl.g:1802:2: ( '+' )
                    // InternalPerl.g:1803:3: '+'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 
                    match(input,248,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:1808:2: ( '-' )
                    {
                    // InternalPerl.g:1808:2: ( '-' )
                    // InternalPerl.g:1809:3: '-'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 
                    match(input,249,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:1814:2: ( '=~' )
                    {
                    // InternalPerl.g:1814:2: ( '=~' )
                    // InternalPerl.g:1815:3: '=~'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 
                    match(input,250,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:1820:2: ( '!~' )
                    {
                    // InternalPerl.g:1820:2: ( '!~' )
                    // InternalPerl.g:1821:3: '!~'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 
                    match(input,251,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:1826:2: ( '*' )
                    {
                    // InternalPerl.g:1826:2: ( '*' )
                    // InternalPerl.g:1827:3: '*'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 
                    match(input,252,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:1832:2: ( '/' )
                    {
                    // InternalPerl.g:1832:2: ( '/' )
                    // InternalPerl.g:1833:3: '/'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 
                    match(input,253,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:1838:2: ( '%' )
                    {
                    // InternalPerl.g:1838:2: ( '%' )
                    // InternalPerl.g:1839:3: '%'
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 
                    match(input,254,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:1844:2: ( 'x' )
                    {
                    // InternalPerl.g:1844:2: ( 'x' )
                    // InternalPerl.g:1845:3: 'x'
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_12()); 
                    match(input,255,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:1850:2: ( '<<' )
                    {
                    // InternalPerl.g:1850:2: ( '<<' )
                    // InternalPerl.g:1851:3: '<<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 
                    match(input,256,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:1856:2: ( '>>' )
                    {
                    // InternalPerl.g:1856:2: ( '>>' )
                    // InternalPerl.g:1857:3: '>>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 
                    match(input,257,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:1862:2: ( 'lt' )
                    {
                    // InternalPerl.g:1862:2: ( 'lt' )
                    // InternalPerl.g:1863:3: 'lt'
                    {
                     before(grammarAccess.getOperatorAccess().getLtKeyword_15()); 
                    match(input,258,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLtKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:1868:2: ( 'gt' )
                    {
                    // InternalPerl.g:1868:2: ( 'gt' )
                    // InternalPerl.g:1869:3: 'gt'
                    {
                     before(grammarAccess.getOperatorAccess().getGtKeyword_16()); 
                    match(input,259,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGtKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:1874:2: ( 'le' )
                    {
                    // InternalPerl.g:1874:2: ( 'le' )
                    // InternalPerl.g:1875:3: 'le'
                    {
                     before(grammarAccess.getOperatorAccess().getLeKeyword_17()); 
                    match(input,260,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLeKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:1880:2: ( 'ge' )
                    {
                    // InternalPerl.g:1880:2: ( 'ge' )
                    // InternalPerl.g:1881:3: 'ge'
                    {
                     before(grammarAccess.getOperatorAccess().getGeKeyword_18()); 
                    match(input,261,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGeKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:1886:2: ( 'cmp' )
                    {
                    // InternalPerl.g:1886:2: ( 'cmp' )
                    // InternalPerl.g:1887:3: 'cmp'
                    {
                     before(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 
                    match(input,262,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:1892:2: ( '~~' )
                    {
                    // InternalPerl.g:1892:2: ( '~~' )
                    // InternalPerl.g:1893:3: '~~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 
                    match(input,263,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:1898:2: ( '==' )
                    {
                    // InternalPerl.g:1898:2: ( '==' )
                    // InternalPerl.g:1899:3: '=='
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 
                    match(input,264,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:1904:2: ( '!=' )
                    {
                    // InternalPerl.g:1904:2: ( '!=' )
                    // InternalPerl.g:1905:3: '!='
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 
                    match(input,265,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:1910:2: ( ( rule__Operator__Group_23__0 ) )
                    {
                    // InternalPerl.g:1910:2: ( ( rule__Operator__Group_23__0 ) )
                    // InternalPerl.g:1911:3: ( rule__Operator__Group_23__0 )
                    {
                     before(grammarAccess.getOperatorAccess().getGroup_23()); 
                    // InternalPerl.g:1912:3: ( rule__Operator__Group_23__0 )
                    // InternalPerl.g:1912:4: rule__Operator__Group_23__0
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
                    // InternalPerl.g:1916:2: ( '..' )
                    {
                    // InternalPerl.g:1916:2: ( '..' )
                    // InternalPerl.g:1917:3: '..'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 
                    match(input,266,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:1922:2: ( '...' )
                    {
                    // InternalPerl.g:1922:2: ( '...' )
                    // InternalPerl.g:1923:3: '...'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 
                    match(input,267,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:1928:2: ( ',' )
                    {
                    // InternalPerl.g:1928:2: ( ',' )
                    // InternalPerl.g:1929:3: ','
                    {
                     before(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 
                    match(input,268,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:1934:2: ( '&' )
                    {
                    // InternalPerl.g:1934:2: ( '&' )
                    // InternalPerl.g:1935:3: '&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 
                    match(input,269,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:1940:2: ( '|' )
                    {
                    // InternalPerl.g:1940:2: ( '|' )
                    // InternalPerl.g:1941:3: '|'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 
                    match(input,270,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:1946:2: ( '^' )
                    {
                    // InternalPerl.g:1946:2: ( '^' )
                    // InternalPerl.g:1947:3: '^'
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 
                    match(input,271,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:1952:2: ( '&&' )
                    {
                    // InternalPerl.g:1952:2: ( '&&' )
                    // InternalPerl.g:1953:3: '&&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 
                    match(input,272,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:1958:2: ( '||' )
                    {
                    // InternalPerl.g:1958:2: ( '||' )
                    // InternalPerl.g:1959:3: '||'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 
                    match(input,273,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:1964:2: ( '//' )
                    {
                    // InternalPerl.g:1964:2: ( '//' )
                    // InternalPerl.g:1965:3: '//'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 
                    match(input,274,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:1970:2: ( '?' )
                    {
                    // InternalPerl.g:1970:2: ( '?' )
                    // InternalPerl.g:1971:3: '?'
                    {
                     before(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 
                    match(input,275,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:1976:2: ( ':' )
                    {
                    // InternalPerl.g:1976:2: ( ':' )
                    // InternalPerl.g:1977:3: ':'
                    {
                     before(grammarAccess.getOperatorAccess().getColonKeyword_34()); 
                    match(input,276,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getColonKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:1982:2: ( '**=' )
                    {
                    // InternalPerl.g:1982:2: ( '**=' )
                    // InternalPerl.g:1983:3: '**='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 
                    match(input,277,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:1988:2: ( '+=' )
                    {
                    // InternalPerl.g:1988:2: ( '+=' )
                    // InternalPerl.g:1989:3: '+='
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 
                    match(input,278,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:1994:2: ( '-=' )
                    {
                    // InternalPerl.g:1994:2: ( '-=' )
                    // InternalPerl.g:1995:3: '-='
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 
                    match(input,279,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:2000:2: ( '.=' )
                    {
                    // InternalPerl.g:2000:2: ( '.=' )
                    // InternalPerl.g:2001:3: '.='
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 
                    match(input,280,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:2006:2: ( '*=' )
                    {
                    // InternalPerl.g:2006:2: ( '*=' )
                    // InternalPerl.g:2007:3: '*='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 
                    match(input,281,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:2012:2: ( '/=' )
                    {
                    // InternalPerl.g:2012:2: ( '/=' )
                    // InternalPerl.g:2013:3: '/='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 
                    match(input,282,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:2018:2: ( '%=' )
                    {
                    // InternalPerl.g:2018:2: ( '%=' )
                    // InternalPerl.g:2019:3: '%='
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 
                    match(input,283,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:2024:2: ( 'x=' )
                    {
                    // InternalPerl.g:2024:2: ( 'x=' )
                    // InternalPerl.g:2025:3: 'x='
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_42()); 
                    match(input,284,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:2030:2: ( '&=' )
                    {
                    // InternalPerl.g:2030:2: ( '&=' )
                    // InternalPerl.g:2031:3: '&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 
                    match(input,285,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:2036:2: ( '|=' )
                    {
                    // InternalPerl.g:2036:2: ( '|=' )
                    // InternalPerl.g:2037:3: '|='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 
                    match(input,286,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:2042:2: ( '^=' )
                    {
                    // InternalPerl.g:2042:2: ( '^=' )
                    // InternalPerl.g:2043:3: '^='
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 
                    match(input,287,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:2048:2: ( '<<=' )
                    {
                    // InternalPerl.g:2048:2: ( '<<=' )
                    // InternalPerl.g:2049:3: '<<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 
                    match(input,288,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:2054:2: ( '>>=' )
                    {
                    // InternalPerl.g:2054:2: ( '>>=' )
                    // InternalPerl.g:2055:3: '>>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 
                    match(input,289,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:2060:2: ( '&&=' )
                    {
                    // InternalPerl.g:2060:2: ( '&&=' )
                    // InternalPerl.g:2061:3: '&&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 
                    match(input,290,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:2066:2: ( '||=' )
                    {
                    // InternalPerl.g:2066:2: ( '||=' )
                    // InternalPerl.g:2067:3: '||='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 
                    match(input,291,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:2072:2: ( '//=' )
                    {
                    // InternalPerl.g:2072:2: ( '//=' )
                    // InternalPerl.g:2073:3: '//='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 
                    match(input,292,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:2078:2: ( '<' )
                    {
                    // InternalPerl.g:2078:2: ( '<' )
                    // InternalPerl.g:2079:3: '<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 
                    match(input,293,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:2084:2: ( '>' )
                    {
                    // InternalPerl.g:2084:2: ( '>' )
                    // InternalPerl.g:2085:3: '>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 
                    match(input,294,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:2090:2: ( '<=' )
                    {
                    // InternalPerl.g:2090:2: ( '<=' )
                    // InternalPerl.g:2091:3: '<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 
                    match(input,295,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:2096:2: ( '>=' )
                    {
                    // InternalPerl.g:2096:2: ( '>=' )
                    // InternalPerl.g:2097:3: '>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 
                    match(input,296,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:2102:2: ( '<>' )
                    {
                    // InternalPerl.g:2102:2: ( '<>' )
                    // InternalPerl.g:2103:3: '<>'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 
                    match(input,297,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:2108:2: ( '=>' )
                    {
                    // InternalPerl.g:2108:2: ( '=>' )
                    // InternalPerl.g:2109:3: '=>'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 
                    match(input,298,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:2114:2: ( '->' )
                    {
                    // InternalPerl.g:2114:2: ( '->' )
                    // InternalPerl.g:2115:3: '->'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 
                    match(input,299,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:2120:2: ( 'and' )
                    {
                    // InternalPerl.g:2120:2: ( 'and' )
                    // InternalPerl.g:2121:3: 'and'
                    {
                     before(grammarAccess.getOperatorAccess().getAndKeyword_58()); 
                    match(input,300,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAndKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:2126:2: ( 'or' )
                    {
                    // InternalPerl.g:2126:2: ( 'or' )
                    // InternalPerl.g:2127:3: 'or'
                    {
                     before(grammarAccess.getOperatorAccess().getOrKeyword_59()); 
                    match(input,301,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getOrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:2132:2: ( 'xor' )
                    {
                    // InternalPerl.g:2132:2: ( 'xor' )
                    // InternalPerl.g:2133:3: 'xor'
                    {
                     before(grammarAccess.getOperatorAccess().getXorKeyword_60()); 
                    match(input,302,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXorKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:2138:2: ( 'not' )
                    {
                    // InternalPerl.g:2138:2: ( 'not' )
                    // InternalPerl.g:2139:3: 'not'
                    {
                     before(grammarAccess.getOperatorAccess().getNotKeyword_61()); 
                    match(input,303,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getNotKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:2144:2: ( 'eq' )
                    {
                    // InternalPerl.g:2144:2: ( 'eq' )
                    // InternalPerl.g:2145:3: 'eq'
                    {
                     before(grammarAccess.getOperatorAccess().getEqKeyword_62()); 
                    match(input,304,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:2150:2: ( 'ne' )
                    {
                    // InternalPerl.g:2150:2: ( 'ne' )
                    // InternalPerl.g:2151:3: 'ne'
                    {
                     before(grammarAccess.getOperatorAccess().getNeKeyword_63()); 
                    match(input,305,FOLLOW_2); 
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
    // InternalPerl.g:2160:1: rule__FileTestOperator__Alternatives : ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) );
    public final void rule__FileTestOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2164:1: ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) )
            int alt6=27;
            switch ( input.LA(1) ) {
            case 306:
                {
                alt6=1;
                }
                break;
            case 307:
                {
                alt6=2;
                }
                break;
            case 308:
                {
                alt6=3;
                }
                break;
            case 309:
                {
                alt6=4;
                }
                break;
            case 310:
                {
                alt6=5;
                }
                break;
            case 311:
                {
                alt6=6;
                }
                break;
            case 312:
                {
                alt6=7;
                }
                break;
            case 313:
                {
                alt6=8;
                }
                break;
            case 314:
                {
                alt6=9;
                }
                break;
            case 315:
                {
                alt6=10;
                }
                break;
            case 316:
                {
                alt6=11;
                }
                break;
            case 317:
                {
                alt6=12;
                }
                break;
            case 318:
                {
                alt6=13;
                }
                break;
            case 319:
                {
                alt6=14;
                }
                break;
            case 320:
                {
                alt6=15;
                }
                break;
            case 321:
                {
                alt6=16;
                }
                break;
            case 322:
                {
                alt6=17;
                }
                break;
            case 323:
                {
                alt6=18;
                }
                break;
            case 324:
                {
                alt6=19;
                }
                break;
            case 325:
                {
                alt6=20;
                }
                break;
            case 326:
                {
                alt6=21;
                }
                break;
            case 327:
                {
                alt6=22;
                }
                break;
            case 328:
                {
                alt6=23;
                }
                break;
            case 329:
                {
                alt6=24;
                }
                break;
            case 330:
                {
                alt6=25;
                }
                break;
            case 331:
                {
                alt6=26;
                }
                break;
            case 332:
                {
                alt6=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalPerl.g:2165:2: ( '-r' )
                    {
                    // InternalPerl.g:2165:2: ( '-r' )
                    // InternalPerl.g:2166:3: '-r'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 
                    match(input,306,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2171:2: ( '-w' )
                    {
                    // InternalPerl.g:2171:2: ( '-w' )
                    // InternalPerl.g:2172:3: '-w'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 
                    match(input,307,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2177:2: ( '-x' )
                    {
                    // InternalPerl.g:2177:2: ( '-x' )
                    // InternalPerl.g:2178:3: '-x'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 
                    match(input,308,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2183:2: ( '-o' )
                    {
                    // InternalPerl.g:2183:2: ( '-o' )
                    // InternalPerl.g:2184:3: '-o'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 
                    match(input,309,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2189:2: ( '-R' )
                    {
                    // InternalPerl.g:2189:2: ( '-R' )
                    // InternalPerl.g:2190:3: '-R'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 
                    match(input,310,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2195:2: ( '-W' )
                    {
                    // InternalPerl.g:2195:2: ( '-W' )
                    // InternalPerl.g:2196:3: '-W'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 
                    match(input,311,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2201:2: ( '-X' )
                    {
                    // InternalPerl.g:2201:2: ( '-X' )
                    // InternalPerl.g:2202:3: '-X'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 
                    match(input,312,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2207:2: ( '-O' )
                    {
                    // InternalPerl.g:2207:2: ( '-O' )
                    // InternalPerl.g:2208:3: '-O'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 
                    match(input,313,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2213:2: ( '-e' )
                    {
                    // InternalPerl.g:2213:2: ( '-e' )
                    // InternalPerl.g:2214:3: '-e'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 
                    match(input,314,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2219:2: ( '-z' )
                    {
                    // InternalPerl.g:2219:2: ( '-z' )
                    // InternalPerl.g:2220:3: '-z'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 
                    match(input,315,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2225:2: ( '-s' )
                    {
                    // InternalPerl.g:2225:2: ( '-s' )
                    // InternalPerl.g:2226:3: '-s'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 
                    match(input,316,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2231:2: ( '-f' )
                    {
                    // InternalPerl.g:2231:2: ( '-f' )
                    // InternalPerl.g:2232:3: '-f'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 
                    match(input,317,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2237:2: ( '-d' )
                    {
                    // InternalPerl.g:2237:2: ( '-d' )
                    // InternalPerl.g:2238:3: '-d'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 
                    match(input,318,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2243:2: ( '-l' )
                    {
                    // InternalPerl.g:2243:2: ( '-l' )
                    // InternalPerl.g:2244:3: '-l'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 
                    match(input,319,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2249:2: ( '-p' )
                    {
                    // InternalPerl.g:2249:2: ( '-p' )
                    // InternalPerl.g:2250:3: '-p'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 
                    match(input,320,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2255:2: ( '-S' )
                    {
                    // InternalPerl.g:2255:2: ( '-S' )
                    // InternalPerl.g:2256:3: '-S'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 
                    match(input,321,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2261:2: ( '-b' )
                    {
                    // InternalPerl.g:2261:2: ( '-b' )
                    // InternalPerl.g:2262:3: '-b'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 
                    match(input,322,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2267:2: ( '-c' )
                    {
                    // InternalPerl.g:2267:2: ( '-c' )
                    // InternalPerl.g:2268:3: '-c'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 
                    match(input,323,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2273:2: ( '-t' )
                    {
                    // InternalPerl.g:2273:2: ( '-t' )
                    // InternalPerl.g:2274:3: '-t'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 
                    match(input,324,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2279:2: ( '-u' )
                    {
                    // InternalPerl.g:2279:2: ( '-u' )
                    // InternalPerl.g:2280:3: '-u'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 
                    match(input,325,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2285:2: ( '-g' )
                    {
                    // InternalPerl.g:2285:2: ( '-g' )
                    // InternalPerl.g:2286:3: '-g'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 
                    match(input,326,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2291:2: ( '-k' )
                    {
                    // InternalPerl.g:2291:2: ( '-k' )
                    // InternalPerl.g:2292:3: '-k'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 
                    match(input,327,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2297:2: ( '-T' )
                    {
                    // InternalPerl.g:2297:2: ( '-T' )
                    // InternalPerl.g:2298:3: '-T'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 
                    match(input,328,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2303:2: ( '-B' )
                    {
                    // InternalPerl.g:2303:2: ( '-B' )
                    // InternalPerl.g:2304:3: '-B'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 
                    match(input,329,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:2309:2: ( '-M' )
                    {
                    // InternalPerl.g:2309:2: ( '-M' )
                    // InternalPerl.g:2310:3: '-M'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 
                    match(input,330,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2315:2: ( '-A' )
                    {
                    // InternalPerl.g:2315:2: ( '-A' )
                    // InternalPerl.g:2316:3: '-A'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 
                    match(input,331,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2321:2: ( '-C' )
                    {
                    // InternalPerl.g:2321:2: ( '-C' )
                    // InternalPerl.g:2322:3: '-C'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_26()); 
                    match(input,332,FOLLOW_2); 
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
    // InternalPerl.g:2331:1: rule__PerlDocument__Group__0 : rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 ;
    public final void rule__PerlDocument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2335:1: ( rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 )
            // InternalPerl.g:2336:2: rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1
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
    // InternalPerl.g:2343:1: rule__PerlDocument__Group__0__Impl : ( () ) ;
    public final void rule__PerlDocument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2347:1: ( ( () ) )
            // InternalPerl.g:2348:1: ( () )
            {
            // InternalPerl.g:2348:1: ( () )
            // InternalPerl.g:2349:2: ()
            {
             before(grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0()); 
            // InternalPerl.g:2350:2: ()
            // InternalPerl.g:2350:3: 
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
    // InternalPerl.g:2358:1: rule__PerlDocument__Group__1 : rule__PerlDocument__Group__1__Impl ;
    public final void rule__PerlDocument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2362:1: ( rule__PerlDocument__Group__1__Impl )
            // InternalPerl.g:2363:2: rule__PerlDocument__Group__1__Impl
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
    // InternalPerl.g:2369:1: rule__PerlDocument__Group__1__Impl : ( ( rule__PerlDocument__ElementsAssignment_1 )* ) ;
    public final void rule__PerlDocument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2373:1: ( ( ( rule__PerlDocument__ElementsAssignment_1 )* ) )
            // InternalPerl.g:2374:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            {
            // InternalPerl.g:2374:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            // InternalPerl.g:2375:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            {
             before(grammarAccess.getPerlDocumentAccess().getElementsAssignment_1()); 
            // InternalPerl.g:2376:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_HEX && LA7_0<=RULE_READLINE_QUOTE)||(LA7_0>=21 && LA7_0<=332)||LA7_0==334) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPerl.g:2376:3: rule__PerlDocument__ElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__PerlDocument__ElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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


    // $ANTLR start "rule__Token__Group_0__0"
    // InternalPerl.g:2385:1: rule__Token__Group_0__0 : rule__Token__Group_0__0__Impl rule__Token__Group_0__1 ;
    public final void rule__Token__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2389:1: ( rule__Token__Group_0__0__Impl rule__Token__Group_0__1 )
            // InternalPerl.g:2390:2: rule__Token__Group_0__0__Impl rule__Token__Group_0__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalPerl.g:2397:1: rule__Token__Group_0__0__Impl : ( () ) ;
    public final void rule__Token__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2401:1: ( ( () ) )
            // InternalPerl.g:2402:1: ( () )
            {
            // InternalPerl.g:2402:1: ( () )
            // InternalPerl.g:2403:2: ()
            {
             before(grammarAccess.getTokenAccess().getPodTokenAction_0_0()); 
            // InternalPerl.g:2404:2: ()
            // InternalPerl.g:2404:3: 
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
    // InternalPerl.g:2412:1: rule__Token__Group_0__1 : rule__Token__Group_0__1__Impl ;
    public final void rule__Token__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2416:1: ( rule__Token__Group_0__1__Impl )
            // InternalPerl.g:2417:2: rule__Token__Group_0__1__Impl
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
    // InternalPerl.g:2423:1: rule__Token__Group_0__1__Impl : ( ( rule__Token__ContentAssignment_0_1 ) ) ;
    public final void rule__Token__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2427:1: ( ( ( rule__Token__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:2428:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:2428:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            // InternalPerl.g:2429:2: ( rule__Token__ContentAssignment_0_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:2430:2: ( rule__Token__ContentAssignment_0_1 )
            // InternalPerl.g:2430:3: rule__Token__ContentAssignment_0_1
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
    // InternalPerl.g:2439:1: rule__Token__Group_1__0 : rule__Token__Group_1__0__Impl rule__Token__Group_1__1 ;
    public final void rule__Token__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2443:1: ( rule__Token__Group_1__0__Impl rule__Token__Group_1__1 )
            // InternalPerl.g:2444:2: rule__Token__Group_1__0__Impl rule__Token__Group_1__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalPerl.g:2451:1: rule__Token__Group_1__0__Impl : ( () ) ;
    public final void rule__Token__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2455:1: ( ( () ) )
            // InternalPerl.g:2456:1: ( () )
            {
            // InternalPerl.g:2456:1: ( () )
            // InternalPerl.g:2457:2: ()
            {
             before(grammarAccess.getTokenAccess().getNumberTokenAction_1_0()); 
            // InternalPerl.g:2458:2: ()
            // InternalPerl.g:2458:3: 
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
    // InternalPerl.g:2466:1: rule__Token__Group_1__1 : rule__Token__Group_1__1__Impl ;
    public final void rule__Token__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2470:1: ( rule__Token__Group_1__1__Impl )
            // InternalPerl.g:2471:2: rule__Token__Group_1__1__Impl
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
    // InternalPerl.g:2477:1: rule__Token__Group_1__1__Impl : ( ( rule__Token__ContentAssignment_1_1 ) ) ;
    public final void rule__Token__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2481:1: ( ( ( rule__Token__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:2482:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:2482:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            // InternalPerl.g:2483:2: ( rule__Token__ContentAssignment_1_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:2484:2: ( rule__Token__ContentAssignment_1_1 )
            // InternalPerl.g:2484:3: rule__Token__ContentAssignment_1_1
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
    // InternalPerl.g:2493:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2497:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // InternalPerl.g:2498:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalPerl.g:2505:1: rule__Token__Group_2__0__Impl : ( () ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2509:1: ( ( () ) )
            // InternalPerl.g:2510:1: ( () )
            {
            // InternalPerl.g:2510:1: ( () )
            // InternalPerl.g:2511:2: ()
            {
             before(grammarAccess.getTokenAccess().getWordTokenAction_2_0()); 
            // InternalPerl.g:2512:2: ()
            // InternalPerl.g:2512:3: 
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
    // InternalPerl.g:2520:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2524:1: ( rule__Token__Group_2__1__Impl )
            // InternalPerl.g:2525:2: rule__Token__Group_2__1__Impl
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
    // InternalPerl.g:2531:1: rule__Token__Group_2__1__Impl : ( ( rule__Token__ContentAssignment_2_1 ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2535:1: ( ( ( rule__Token__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:2536:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:2536:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            // InternalPerl.g:2537:2: ( rule__Token__ContentAssignment_2_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:2538:2: ( rule__Token__ContentAssignment_2_1 )
            // InternalPerl.g:2538:3: rule__Token__ContentAssignment_2_1
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


    // $ANTLR start "rule__Token__Group_4__0"
    // InternalPerl.g:2547:1: rule__Token__Group_4__0 : rule__Token__Group_4__0__Impl rule__Token__Group_4__1 ;
    public final void rule__Token__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2551:1: ( rule__Token__Group_4__0__Impl rule__Token__Group_4__1 )
            // InternalPerl.g:2552:2: rule__Token__Group_4__0__Impl rule__Token__Group_4__1
            {
            pushFollow(FOLLOW_8);
            rule__Token__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_4__1();

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
    // $ANTLR end "rule__Token__Group_4__0"


    // $ANTLR start "rule__Token__Group_4__0__Impl"
    // InternalPerl.g:2559:1: rule__Token__Group_4__0__Impl : ( () ) ;
    public final void rule__Token__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2563:1: ( ( () ) )
            // InternalPerl.g:2564:1: ( () )
            {
            // InternalPerl.g:2564:1: ( () )
            // InternalPerl.g:2565:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_4_0()); 
            // InternalPerl.g:2566:2: ()
            // InternalPerl.g:2566:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getOperatorTokenAction_4_0()); 

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
    // InternalPerl.g:2574:1: rule__Token__Group_4__1 : rule__Token__Group_4__1__Impl ;
    public final void rule__Token__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2578:1: ( rule__Token__Group_4__1__Impl )
            // InternalPerl.g:2579:2: rule__Token__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_4__1__Impl();

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
    // $ANTLR end "rule__Token__Group_4__1"


    // $ANTLR start "rule__Token__Group_4__1__Impl"
    // InternalPerl.g:2585:1: rule__Token__Group_4__1__Impl : ( ( rule__Token__ContentAssignment_4_1 ) ) ;
    public final void rule__Token__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2589:1: ( ( ( rule__Token__ContentAssignment_4_1 ) ) )
            // InternalPerl.g:2590:1: ( ( rule__Token__ContentAssignment_4_1 ) )
            {
            // InternalPerl.g:2590:1: ( ( rule__Token__ContentAssignment_4_1 ) )
            // InternalPerl.g:2591:2: ( rule__Token__ContentAssignment_4_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_4_1()); 
            // InternalPerl.g:2592:2: ( rule__Token__ContentAssignment_4_1 )
            // InternalPerl.g:2592:3: rule__Token__ContentAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_4_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Token__Group_5__0"
    // InternalPerl.g:2601:1: rule__Token__Group_5__0 : rule__Token__Group_5__0__Impl rule__Token__Group_5__1 ;
    public final void rule__Token__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2605:1: ( rule__Token__Group_5__0__Impl rule__Token__Group_5__1 )
            // InternalPerl.g:2606:2: rule__Token__Group_5__0__Impl rule__Token__Group_5__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalPerl.g:2613:1: rule__Token__Group_5__0__Impl : ( () ) ;
    public final void rule__Token__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2617:1: ( ( () ) )
            // InternalPerl.g:2618:1: ( () )
            {
            // InternalPerl.g:2618:1: ( () )
            // InternalPerl.g:2619:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_5_0()); 
            // InternalPerl.g:2620:2: ()
            // InternalPerl.g:2620:3: 
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
    // InternalPerl.g:2628:1: rule__Token__Group_5__1 : rule__Token__Group_5__1__Impl ;
    public final void rule__Token__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2632:1: ( rule__Token__Group_5__1__Impl )
            // InternalPerl.g:2633:2: rule__Token__Group_5__1__Impl
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
    // InternalPerl.g:2639:1: rule__Token__Group_5__1__Impl : ( ( rule__Token__ContentAssignment_5_1 ) ) ;
    public final void rule__Token__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2643:1: ( ( ( rule__Token__ContentAssignment_5_1 ) ) )
            // InternalPerl.g:2644:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            {
            // InternalPerl.g:2644:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            // InternalPerl.g:2645:2: ( rule__Token__ContentAssignment_5_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_5_1()); 
            // InternalPerl.g:2646:2: ( rule__Token__ContentAssignment_5_1 )
            // InternalPerl.g:2646:3: rule__Token__ContentAssignment_5_1
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
    // InternalPerl.g:2655:1: rule__Token__Group_6__0 : rule__Token__Group_6__0__Impl rule__Token__Group_6__1 ;
    public final void rule__Token__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2659:1: ( rule__Token__Group_6__0__Impl rule__Token__Group_6__1 )
            // InternalPerl.g:2660:2: rule__Token__Group_6__0__Impl rule__Token__Group_6__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalPerl.g:2667:1: rule__Token__Group_6__0__Impl : ( () ) ;
    public final void rule__Token__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2671:1: ( ( () ) )
            // InternalPerl.g:2672:1: ( () )
            {
            // InternalPerl.g:2672:1: ( () )
            // InternalPerl.g:2673:2: ()
            {
             before(grammarAccess.getTokenAccess().getQuoteTokenAction_6_0()); 
            // InternalPerl.g:2674:2: ()
            // InternalPerl.g:2674:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getQuoteTokenAction_6_0()); 

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
    // InternalPerl.g:2682:1: rule__Token__Group_6__1 : rule__Token__Group_6__1__Impl ;
    public final void rule__Token__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2686:1: ( rule__Token__Group_6__1__Impl )
            // InternalPerl.g:2687:2: rule__Token__Group_6__1__Impl
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
    // InternalPerl.g:2693:1: rule__Token__Group_6__1__Impl : ( ( rule__Token__ContentAssignment_6_1 ) ) ;
    public final void rule__Token__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2697:1: ( ( ( rule__Token__ContentAssignment_6_1 ) ) )
            // InternalPerl.g:2698:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            {
            // InternalPerl.g:2698:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            // InternalPerl.g:2699:2: ( rule__Token__ContentAssignment_6_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_6_1()); 
            // InternalPerl.g:2700:2: ( rule__Token__ContentAssignment_6_1 )
            // InternalPerl.g:2700:3: rule__Token__ContentAssignment_6_1
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


    // $ANTLR start "rule__Token__Group_7__0"
    // InternalPerl.g:2709:1: rule__Token__Group_7__0 : rule__Token__Group_7__0__Impl rule__Token__Group_7__1 ;
    public final void rule__Token__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2713:1: ( rule__Token__Group_7__0__Impl rule__Token__Group_7__1 )
            // InternalPerl.g:2714:2: rule__Token__Group_7__0__Impl rule__Token__Group_7__1
            {
            pushFollow(FOLLOW_11);
            rule__Token__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Token__Group_7__1();

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
    // $ANTLR end "rule__Token__Group_7__0"


    // $ANTLR start "rule__Token__Group_7__0__Impl"
    // InternalPerl.g:2721:1: rule__Token__Group_7__0__Impl : ( () ) ;
    public final void rule__Token__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2725:1: ( ( () ) )
            // InternalPerl.g:2726:1: ( () )
            {
            // InternalPerl.g:2726:1: ( () )
            // InternalPerl.g:2727:2: ()
            {
             before(grammarAccess.getTokenAccess().getQuoteTokenAction_7_0()); 
            // InternalPerl.g:2728:2: ()
            // InternalPerl.g:2728:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getQuoteTokenAction_7_0()); 

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
    // InternalPerl.g:2736:1: rule__Token__Group_7__1 : rule__Token__Group_7__1__Impl ;
    public final void rule__Token__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2740:1: ( rule__Token__Group_7__1__Impl )
            // InternalPerl.g:2741:2: rule__Token__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Token__Group_7__1__Impl();

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
    // $ANTLR end "rule__Token__Group_7__1"


    // $ANTLR start "rule__Token__Group_7__1__Impl"
    // InternalPerl.g:2747:1: rule__Token__Group_7__1__Impl : ( ( rule__Token__ContentAssignment_7_1 ) ) ;
    public final void rule__Token__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2751:1: ( ( ( rule__Token__ContentAssignment_7_1 ) ) )
            // InternalPerl.g:2752:1: ( ( rule__Token__ContentAssignment_7_1 ) )
            {
            // InternalPerl.g:2752:1: ( ( rule__Token__ContentAssignment_7_1 ) )
            // InternalPerl.g:2753:2: ( rule__Token__ContentAssignment_7_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_7_1()); 
            // InternalPerl.g:2754:2: ( rule__Token__ContentAssignment_7_1 )
            // InternalPerl.g:2754:3: rule__Token__ContentAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Token__ContentAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getTokenAccess().getContentAssignment_7_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Token__Group_8__0"
    // InternalPerl.g:2763:1: rule__Token__Group_8__0 : rule__Token__Group_8__0__Impl rule__Token__Group_8__1 ;
    public final void rule__Token__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2767:1: ( rule__Token__Group_8__0__Impl rule__Token__Group_8__1 )
            // InternalPerl.g:2768:2: rule__Token__Group_8__0__Impl rule__Token__Group_8__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalPerl.g:2775:1: rule__Token__Group_8__0__Impl : ( () ) ;
    public final void rule__Token__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2779:1: ( ( () ) )
            // InternalPerl.g:2780:1: ( () )
            {
            // InternalPerl.g:2780:1: ( () )
            // InternalPerl.g:2781:2: ()
            {
             before(grammarAccess.getTokenAccess().getQuoteTokenAction_8_0()); 
            // InternalPerl.g:2782:2: ()
            // InternalPerl.g:2782:3: 
            {
            }

             after(grammarAccess.getTokenAccess().getQuoteTokenAction_8_0()); 

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
    // InternalPerl.g:2790:1: rule__Token__Group_8__1 : rule__Token__Group_8__1__Impl ;
    public final void rule__Token__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2794:1: ( rule__Token__Group_8__1__Impl )
            // InternalPerl.g:2795:2: rule__Token__Group_8__1__Impl
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
    // InternalPerl.g:2801:1: rule__Token__Group_8__1__Impl : ( ( rule__Token__ContentAssignment_8_1 ) ) ;
    public final void rule__Token__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2805:1: ( ( ( rule__Token__ContentAssignment_8_1 ) ) )
            // InternalPerl.g:2806:1: ( ( rule__Token__ContentAssignment_8_1 ) )
            {
            // InternalPerl.g:2806:1: ( ( rule__Token__ContentAssignment_8_1 ) )
            // InternalPerl.g:2807:2: ( rule__Token__ContentAssignment_8_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_8_1()); 
            // InternalPerl.g:2808:2: ( rule__Token__ContentAssignment_8_1 )
            // InternalPerl.g:2808:3: rule__Token__ContentAssignment_8_1
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
    // InternalPerl.g:2817:1: rule__Token__Group_9__0 : rule__Token__Group_9__0__Impl rule__Token__Group_9__1 ;
    public final void rule__Token__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2821:1: ( rule__Token__Group_9__0__Impl rule__Token__Group_9__1 )
            // InternalPerl.g:2822:2: rule__Token__Group_9__0__Impl rule__Token__Group_9__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalPerl.g:2829:1: rule__Token__Group_9__0__Impl : ( () ) ;
    public final void rule__Token__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2833:1: ( ( () ) )
            // InternalPerl.g:2834:1: ( () )
            {
            // InternalPerl.g:2834:1: ( () )
            // InternalPerl.g:2835:2: ()
            {
             before(grammarAccess.getTokenAccess().getDataTokenAction_9_0()); 
            // InternalPerl.g:2836:2: ()
            // InternalPerl.g:2836:3: 
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
    // InternalPerl.g:2844:1: rule__Token__Group_9__1 : rule__Token__Group_9__1__Impl ;
    public final void rule__Token__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2848:1: ( rule__Token__Group_9__1__Impl )
            // InternalPerl.g:2849:2: rule__Token__Group_9__1__Impl
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
    // InternalPerl.g:2855:1: rule__Token__Group_9__1__Impl : ( ( rule__Token__ContentAssignment_9_1 ) ) ;
    public final void rule__Token__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2859:1: ( ( ( rule__Token__ContentAssignment_9_1 ) ) )
            // InternalPerl.g:2860:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            {
            // InternalPerl.g:2860:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            // InternalPerl.g:2861:2: ( rule__Token__ContentAssignment_9_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_9_1()); 
            // InternalPerl.g:2862:2: ( rule__Token__ContentAssignment_9_1 )
            // InternalPerl.g:2862:3: rule__Token__ContentAssignment_9_1
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
    // InternalPerl.g:2871:1: rule__Token__Group_10__0 : rule__Token__Group_10__0__Impl rule__Token__Group_10__1 ;
    public final void rule__Token__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2875:1: ( rule__Token__Group_10__0__Impl rule__Token__Group_10__1 )
            // InternalPerl.g:2876:2: rule__Token__Group_10__0__Impl rule__Token__Group_10__1
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
    // InternalPerl.g:2883:1: rule__Token__Group_10__0__Impl : ( () ) ;
    public final void rule__Token__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2887:1: ( ( () ) )
            // InternalPerl.g:2888:1: ( () )
            {
            // InternalPerl.g:2888:1: ( () )
            // InternalPerl.g:2889:2: ()
            {
             before(grammarAccess.getTokenAccess().getEndTokenAction_10_0()); 
            // InternalPerl.g:2890:2: ()
            // InternalPerl.g:2890:3: 
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
    // InternalPerl.g:2898:1: rule__Token__Group_10__1 : rule__Token__Group_10__1__Impl ;
    public final void rule__Token__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2902:1: ( rule__Token__Group_10__1__Impl )
            // InternalPerl.g:2903:2: rule__Token__Group_10__1__Impl
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
    // InternalPerl.g:2909:1: rule__Token__Group_10__1__Impl : ( ( rule__Token__ContentAssignment_10_1 ) ) ;
    public final void rule__Token__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2913:1: ( ( ( rule__Token__ContentAssignment_10_1 ) ) )
            // InternalPerl.g:2914:1: ( ( rule__Token__ContentAssignment_10_1 ) )
            {
            // InternalPerl.g:2914:1: ( ( rule__Token__ContentAssignment_10_1 ) )
            // InternalPerl.g:2915:2: ( rule__Token__ContentAssignment_10_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_10_1()); 
            // InternalPerl.g:2916:2: ( rule__Token__ContentAssignment_10_1 )
            // InternalPerl.g:2916:3: rule__Token__ContentAssignment_10_1
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


    // $ANTLR start "rule__QuoteLikeToken__Group_0__0"
    // InternalPerl.g:2925:1: rule__QuoteLikeToken__Group_0__0 : rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 ;
    public final void rule__QuoteLikeToken__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2929:1: ( rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 )
            // InternalPerl.g:2930:2: rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalPerl.g:2937:1: rule__QuoteLikeToken__Group_0__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2941:1: ( ( () ) )
            // InternalPerl.g:2942:1: ( () )
            {
            // InternalPerl.g:2942:1: ( () )
            // InternalPerl.g:2943:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0()); 
            // InternalPerl.g:2944:2: ()
            // InternalPerl.g:2944:3: 
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
    // InternalPerl.g:2952:1: rule__QuoteLikeToken__Group_0__1 : rule__QuoteLikeToken__Group_0__1__Impl ;
    public final void rule__QuoteLikeToken__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2956:1: ( rule__QuoteLikeToken__Group_0__1__Impl )
            // InternalPerl.g:2957:2: rule__QuoteLikeToken__Group_0__1__Impl
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
    // InternalPerl.g:2963:1: rule__QuoteLikeToken__Group_0__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2967:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:2968:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:2968:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            // InternalPerl.g:2969:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:2970:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            // InternalPerl.g:2970:3: rule__QuoteLikeToken__ContentAssignment_0_1
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
    // InternalPerl.g:2979:1: rule__QuoteLikeToken__Group_1__0 : rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 ;
    public final void rule__QuoteLikeToken__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2983:1: ( rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 )
            // InternalPerl.g:2984:2: rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalPerl.g:2991:1: rule__QuoteLikeToken__Group_1__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2995:1: ( ( () ) )
            // InternalPerl.g:2996:1: ( () )
            {
            // InternalPerl.g:2996:1: ( () )
            // InternalPerl.g:2997:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0()); 
            // InternalPerl.g:2998:2: ()
            // InternalPerl.g:2998:3: 
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
    // InternalPerl.g:3006:1: rule__QuoteLikeToken__Group_1__1 : rule__QuoteLikeToken__Group_1__1__Impl ;
    public final void rule__QuoteLikeToken__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3010:1: ( rule__QuoteLikeToken__Group_1__1__Impl )
            // InternalPerl.g:3011:2: rule__QuoteLikeToken__Group_1__1__Impl
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
    // InternalPerl.g:3017:1: rule__QuoteLikeToken__Group_1__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3021:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:3022:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:3022:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            // InternalPerl.g:3023:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:3024:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            // InternalPerl.g:3024:3: rule__QuoteLikeToken__ContentAssignment_1_1
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
    // InternalPerl.g:3033:1: rule__QuoteLikeToken__Group_2__0 : rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 ;
    public final void rule__QuoteLikeToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3037:1: ( rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 )
            // InternalPerl.g:3038:2: rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalPerl.g:3045:1: rule__QuoteLikeToken__Group_2__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3049:1: ( ( () ) )
            // InternalPerl.g:3050:1: ( () )
            {
            // InternalPerl.g:3050:1: ( () )
            // InternalPerl.g:3051:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0()); 
            // InternalPerl.g:3052:2: ()
            // InternalPerl.g:3052:3: 
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
    // InternalPerl.g:3060:1: rule__QuoteLikeToken__Group_2__1 : rule__QuoteLikeToken__Group_2__1__Impl ;
    public final void rule__QuoteLikeToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3064:1: ( rule__QuoteLikeToken__Group_2__1__Impl )
            // InternalPerl.g:3065:2: rule__QuoteLikeToken__Group_2__1__Impl
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
    // InternalPerl.g:3071:1: rule__QuoteLikeToken__Group_2__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3075:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:3076:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:3076:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            // InternalPerl.g:3077:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:3078:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            // InternalPerl.g:3078:3: rule__QuoteLikeToken__ContentAssignment_2_1
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
    // InternalPerl.g:3087:1: rule__QuoteLikeToken__Group_3__0 : rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 ;
    public final void rule__QuoteLikeToken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3091:1: ( rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 )
            // InternalPerl.g:3092:2: rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalPerl.g:3099:1: rule__QuoteLikeToken__Group_3__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3103:1: ( ( () ) )
            // InternalPerl.g:3104:1: ( () )
            {
            // InternalPerl.g:3104:1: ( () )
            // InternalPerl.g:3105:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0()); 
            // InternalPerl.g:3106:2: ()
            // InternalPerl.g:3106:3: 
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
    // InternalPerl.g:3114:1: rule__QuoteLikeToken__Group_3__1 : rule__QuoteLikeToken__Group_3__1__Impl ;
    public final void rule__QuoteLikeToken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3118:1: ( rule__QuoteLikeToken__Group_3__1__Impl )
            // InternalPerl.g:3119:2: rule__QuoteLikeToken__Group_3__1__Impl
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
    // InternalPerl.g:3125:1: rule__QuoteLikeToken__Group_3__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3129:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:3130:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:3130:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            // InternalPerl.g:3131:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:3132:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            // InternalPerl.g:3132:3: rule__QuoteLikeToken__ContentAssignment_3_1
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
    // InternalPerl.g:3141:1: rule__QuoteLikeToken__Group_4__0 : rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 ;
    public final void rule__QuoteLikeToken__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3145:1: ( rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 )
            // InternalPerl.g:3146:2: rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalPerl.g:3153:1: rule__QuoteLikeToken__Group_4__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3157:1: ( ( () ) )
            // InternalPerl.g:3158:1: ( () )
            {
            // InternalPerl.g:3158:1: ( () )
            // InternalPerl.g:3159:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0()); 
            // InternalPerl.g:3160:2: ()
            // InternalPerl.g:3160:3: 
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
    // InternalPerl.g:3168:1: rule__QuoteLikeToken__Group_4__1 : rule__QuoteLikeToken__Group_4__1__Impl ;
    public final void rule__QuoteLikeToken__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3172:1: ( rule__QuoteLikeToken__Group_4__1__Impl )
            // InternalPerl.g:3173:2: rule__QuoteLikeToken__Group_4__1__Impl
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
    // InternalPerl.g:3179:1: rule__QuoteLikeToken__Group_4__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3183:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) )
            // InternalPerl.g:3184:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            {
            // InternalPerl.g:3184:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            // InternalPerl.g:3185:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_4_1()); 
            // InternalPerl.g:3186:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            // InternalPerl.g:3186:3: rule__QuoteLikeToken__ContentAssignment_4_1
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


    // $ANTLR start "rule__Number__Group__0"
    // InternalPerl.g:3195:1: rule__Number__Group__0 : rule__Number__Group__0__Impl rule__Number__Group__1 ;
    public final void rule__Number__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3199:1: ( rule__Number__Group__0__Impl rule__Number__Group__1 )
            // InternalPerl.g:3200:2: rule__Number__Group__0__Impl rule__Number__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Number__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Number__Group__1();

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
    // $ANTLR end "rule__Number__Group__0"


    // $ANTLR start "rule__Number__Group__0__Impl"
    // InternalPerl.g:3207:1: rule__Number__Group__0__Impl : ( ( rule__Number__Alternatives_0 ) ) ;
    public final void rule__Number__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3211:1: ( ( ( rule__Number__Alternatives_0 ) ) )
            // InternalPerl.g:3212:1: ( ( rule__Number__Alternatives_0 ) )
            {
            // InternalPerl.g:3212:1: ( ( rule__Number__Alternatives_0 ) )
            // InternalPerl.g:3213:2: ( rule__Number__Alternatives_0 )
            {
             before(grammarAccess.getNumberAccess().getAlternatives_0()); 
            // InternalPerl.g:3214:2: ( rule__Number__Alternatives_0 )
            // InternalPerl.g:3214:3: rule__Number__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Number__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getNumberAccess().getAlternatives_0()); 

            }


            }

        }
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
    // InternalPerl.g:3222:1: rule__Number__Group__1 : rule__Number__Group__1__Impl ;
    public final void rule__Number__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3226:1: ( rule__Number__Group__1__Impl )
            // InternalPerl.g:3227:2: rule__Number__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Number__Group__1__Impl();

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
    // $ANTLR end "rule__Number__Group__1"


    // $ANTLR start "rule__Number__Group__1__Impl"
    // InternalPerl.g:3233:1: rule__Number__Group__1__Impl : ( ( rule__Number__Group_1__0 )? ) ;
    public final void rule__Number__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3237:1: ( ( ( rule__Number__Group_1__0 )? ) )
            // InternalPerl.g:3238:1: ( ( rule__Number__Group_1__0 )? )
            {
            // InternalPerl.g:3238:1: ( ( rule__Number__Group_1__0 )? )
            // InternalPerl.g:3239:2: ( rule__Number__Group_1__0 )?
            {
             before(grammarAccess.getNumberAccess().getGroup_1()); 
            // InternalPerl.g:3240:2: ( rule__Number__Group_1__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==333) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalPerl.g:3240:3: rule__Number__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Number__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNumberAccess().getGroup_1()); 

            }


            }

        }
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
    // InternalPerl.g:3249:1: rule__Number__Group_1__0 : rule__Number__Group_1__0__Impl rule__Number__Group_1__1 ;
    public final void rule__Number__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3253:1: ( rule__Number__Group_1__0__Impl rule__Number__Group_1__1 )
            // InternalPerl.g:3254:2: rule__Number__Group_1__0__Impl rule__Number__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__Number__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Number__Group_1__1();

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
    // $ANTLR end "rule__Number__Group_1__0"


    // $ANTLR start "rule__Number__Group_1__0__Impl"
    // InternalPerl.g:3261:1: rule__Number__Group_1__0__Impl : ( '.' ) ;
    public final void rule__Number__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3265:1: ( ( '.' ) )
            // InternalPerl.g:3266:1: ( '.' )
            {
            // InternalPerl.g:3266:1: ( '.' )
            // InternalPerl.g:3267:2: '.'
            {
             before(grammarAccess.getNumberAccess().getFullStopKeyword_1_0()); 
            match(input,333,FOLLOW_2); 
             after(grammarAccess.getNumberAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
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
    // InternalPerl.g:3276:1: rule__Number__Group_1__1 : rule__Number__Group_1__1__Impl ;
    public final void rule__Number__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3280:1: ( rule__Number__Group_1__1__Impl )
            // InternalPerl.g:3281:2: rule__Number__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Number__Group_1__1__Impl();

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
    // $ANTLR end "rule__Number__Group_1__1"


    // $ANTLR start "rule__Number__Group_1__1__Impl"
    // InternalPerl.g:3287:1: rule__Number__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Number__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3291:1: ( ( RULE_INT ) )
            // InternalPerl.g:3292:1: ( RULE_INT )
            {
            // InternalPerl.g:3292:1: ( RULE_INT )
            // InternalPerl.g:3293:2: RULE_INT
            {
             before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Operator__Group_23__0"
    // InternalPerl.g:3303:1: rule__Operator__Group_23__0 : rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 ;
    public final void rule__Operator__Group_23__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3307:1: ( rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 )
            // InternalPerl.g:3308:2: rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalPerl.g:3315:1: rule__Operator__Group_23__0__Impl : ( '<=>' ) ;
    public final void rule__Operator__Group_23__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3319:1: ( ( '<=>' ) )
            // InternalPerl.g:3320:1: ( '<=>' )
            {
            // InternalPerl.g:3320:1: ( '<=>' )
            // InternalPerl.g:3321:2: '<=>'
            {
             before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_23_0()); 
            match(input,334,FOLLOW_2); 
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
    // InternalPerl.g:3330:1: rule__Operator__Group_23__1 : rule__Operator__Group_23__1__Impl ;
    public final void rule__Operator__Group_23__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3334:1: ( rule__Operator__Group_23__1__Impl )
            // InternalPerl.g:3335:2: rule__Operator__Group_23__1__Impl
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
    // InternalPerl.g:3341:1: rule__Operator__Group_23__1__Impl : ( '.' ) ;
    public final void rule__Operator__Group_23__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3345:1: ( ( '.' ) )
            // InternalPerl.g:3346:1: ( '.' )
            {
            // InternalPerl.g:3346:1: ( '.' )
            // InternalPerl.g:3347:2: '.'
            {
             before(grammarAccess.getOperatorAccess().getFullStopKeyword_23_1()); 
            match(input,333,FOLLOW_2); 
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
    // InternalPerl.g:3357:1: rule__PerlDocument__ElementsAssignment_1 : ( ruleElement ) ;
    public final void rule__PerlDocument__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3361:1: ( ( ruleElement ) )
            // InternalPerl.g:3362:2: ( ruleElement )
            {
            // InternalPerl.g:3362:2: ( ruleElement )
            // InternalPerl.g:3363:3: ruleElement
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


    // $ANTLR start "rule__Token__ContentAssignment_0_1"
    // InternalPerl.g:3372:1: rule__Token__ContentAssignment_0_1 : ( RULE_POD ) ;
    public final void rule__Token__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3376:1: ( ( RULE_POD ) )
            // InternalPerl.g:3377:2: ( RULE_POD )
            {
            // InternalPerl.g:3377:2: ( RULE_POD )
            // InternalPerl.g:3378:3: RULE_POD
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
    // InternalPerl.g:3387:1: rule__Token__ContentAssignment_1_1 : ( ruleNumber ) ;
    public final void rule__Token__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3391:1: ( ( ruleNumber ) )
            // InternalPerl.g:3392:2: ( ruleNumber )
            {
            // InternalPerl.g:3392:2: ( ruleNumber )
            // InternalPerl.g:3393:3: ruleNumber
            {
             before(grammarAccess.getTokenAccess().getContentNumberParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleNumber();

            state._fsp--;

             after(grammarAccess.getTokenAccess().getContentNumberParserRuleCall_1_1_0()); 

            }


            }

        }
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
    // InternalPerl.g:3402:1: rule__Token__ContentAssignment_2_1 : ( ruleWord ) ;
    public final void rule__Token__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3406:1: ( ( ruleWord ) )
            // InternalPerl.g:3407:2: ( ruleWord )
            {
            // InternalPerl.g:3407:2: ( ruleWord )
            // InternalPerl.g:3408:3: ruleWord
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


    // $ANTLR start "rule__Token__ContentAssignment_4_1"
    // InternalPerl.g:3417:1: rule__Token__ContentAssignment_4_1 : ( ruleFileTestOperator ) ;
    public final void rule__Token__ContentAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3421:1: ( ( ruleFileTestOperator ) )
            // InternalPerl.g:3422:2: ( ruleFileTestOperator )
            {
            // InternalPerl.g:3422:2: ( ruleFileTestOperator )
            // InternalPerl.g:3423:3: ruleFileTestOperator
            {
             before(grammarAccess.getTokenAccess().getContentFileTestOperatorParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFileTestOperator();

            state._fsp--;

             after(grammarAccess.getTokenAccess().getContentFileTestOperatorParserRuleCall_4_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__Token__ContentAssignment_5_1"
    // InternalPerl.g:3432:1: rule__Token__ContentAssignment_5_1 : ( ruleOperator ) ;
    public final void rule__Token__ContentAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3436:1: ( ( ruleOperator ) )
            // InternalPerl.g:3437:2: ( ruleOperator )
            {
            // InternalPerl.g:3437:2: ( ruleOperator )
            // InternalPerl.g:3438:3: ruleOperator
            {
             before(grammarAccess.getTokenAccess().getContentOperatorParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getTokenAccess().getContentOperatorParserRuleCall_5_1_0()); 

            }


            }

        }
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
    // InternalPerl.g:3447:1: rule__Token__ContentAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__Token__ContentAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3451:1: ( ( RULE_STRING ) )
            // InternalPerl.g:3452:2: ( RULE_STRING )
            {
            // InternalPerl.g:3452:2: ( RULE_STRING )
            // InternalPerl.g:3453:3: RULE_STRING
            {
             before(grammarAccess.getTokenAccess().getContentSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTokenAccess().getContentSTRINGTerminalRuleCall_6_1_0()); 

            }


            }

        }
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
    // InternalPerl.g:3462:1: rule__Token__ContentAssignment_7_1 : ( RULE_INTERPOLATE ) ;
    public final void rule__Token__ContentAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3466:1: ( ( RULE_INTERPOLATE ) )
            // InternalPerl.g:3467:2: ( RULE_INTERPOLATE )
            {
            // InternalPerl.g:3467:2: ( RULE_INTERPOLATE )
            // InternalPerl.g:3468:3: RULE_INTERPOLATE
            {
             before(grammarAccess.getTokenAccess().getContentINTERPOLATETerminalRuleCall_7_1_0()); 
            match(input,RULE_INTERPOLATE,FOLLOW_2); 
             after(grammarAccess.getTokenAccess().getContentINTERPOLATETerminalRuleCall_7_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__Token__ContentAssignment_8_1"
    // InternalPerl.g:3477:1: rule__Token__ContentAssignment_8_1 : ( RULE_LITERAL ) ;
    public final void rule__Token__ContentAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3481:1: ( ( RULE_LITERAL ) )
            // InternalPerl.g:3482:2: ( RULE_LITERAL )
            {
            // InternalPerl.g:3482:2: ( RULE_LITERAL )
            // InternalPerl.g:3483:3: RULE_LITERAL
            {
             before(grammarAccess.getTokenAccess().getContentLITERALTerminalRuleCall_8_1_0()); 
            match(input,RULE_LITERAL,FOLLOW_2); 
             after(grammarAccess.getTokenAccess().getContentLITERALTerminalRuleCall_8_1_0()); 

            }


            }

        }
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
    // InternalPerl.g:3492:1: rule__Token__ContentAssignment_9_1 : ( RULE_DATA ) ;
    public final void rule__Token__ContentAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3496:1: ( ( RULE_DATA ) )
            // InternalPerl.g:3497:2: ( RULE_DATA )
            {
            // InternalPerl.g:3497:2: ( RULE_DATA )
            // InternalPerl.g:3498:3: RULE_DATA
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
    // InternalPerl.g:3507:1: rule__Token__ContentAssignment_10_1 : ( RULE_END ) ;
    public final void rule__Token__ContentAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3511:1: ( ( RULE_END ) )
            // InternalPerl.g:3512:2: ( RULE_END )
            {
            // InternalPerl.g:3512:2: ( RULE_END )
            // InternalPerl.g:3513:3: RULE_END
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


    // $ANTLR start "rule__QuoteLikeToken__ContentAssignment_0_1"
    // InternalPerl.g:3522:1: rule__QuoteLikeToken__ContentAssignment_0_1 : ( RULE_BACKTICK_STRING ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3526:1: ( ( RULE_BACKTICK_STRING ) )
            // InternalPerl.g:3527:2: ( RULE_BACKTICK_STRING )
            {
            // InternalPerl.g:3527:2: ( RULE_BACKTICK_STRING )
            // InternalPerl.g:3528:3: RULE_BACKTICK_STRING
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
    // InternalPerl.g:3537:1: rule__QuoteLikeToken__ContentAssignment_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3541:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:3542:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:3542:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:3543:3: RULE_WORDS_QUOTE_LIKE
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
    // InternalPerl.g:3552:1: rule__QuoteLikeToken__ContentAssignment_2_1 : ( RULE_COMMAND_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3556:1: ( ( RULE_COMMAND_QUOTE_LIKE ) )
            // InternalPerl.g:3557:2: ( RULE_COMMAND_QUOTE_LIKE )
            {
            // InternalPerl.g:3557:2: ( RULE_COMMAND_QUOTE_LIKE )
            // InternalPerl.g:3558:3: RULE_COMMAND_QUOTE_LIKE
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
    // InternalPerl.g:3567:1: rule__QuoteLikeToken__ContentAssignment_3_1 : ( RULE_REGEX_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3571:1: ( ( RULE_REGEX_QUOTE ) )
            // InternalPerl.g:3572:2: ( RULE_REGEX_QUOTE )
            {
            // InternalPerl.g:3572:2: ( RULE_REGEX_QUOTE )
            // InternalPerl.g:3573:3: RULE_REGEX_QUOTE
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
    // InternalPerl.g:3582:1: rule__QuoteLikeToken__ContentAssignment_4_1 : ( RULE_READLINE_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3586:1: ( ( RULE_READLINE_QUOTE ) )
            // InternalPerl.g:3587:2: ( RULE_READLINE_QUOTE )
            {
            // InternalPerl.g:3587:2: ( RULE_READLINE_QUOTE )
            // InternalPerl.g:3588:3: RULE_READLINE_QUOTE
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFFFFFFFE3FFF0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x0000000000005FFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xFFFFFFFFFFE3FFF2L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x0000000000005FFFL});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0xFFFFFFFFFFE00000L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x0007FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xFFFC000000000000L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xFFF8000000000000L,0x0003FFFFFFFFFFFFL,0x0000000000004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000000003E000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000040L});

}