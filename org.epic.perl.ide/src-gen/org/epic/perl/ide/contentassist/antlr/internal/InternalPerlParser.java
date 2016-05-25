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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INTERPOLATE", "RULE_LITERAL", "RULE_REGEX_SUBSTITUTE", "RULE_REGEX_TRANSLITERATE", "RULE_REGEX_MATCH", "RULE_ID", "RULE_VERSION", "RULE_WORDS_QUOTE_LIKE", "RULE_POD", "RULE_NUMBER", "RULE_SYMBOL", "RULE_DATA", "RULE_END", "RULE_BACKTICK_STRING", "RULE_COMMAND_QUOTE_LIKE", "RULE_REGEX_QUOTE", "RULE_READLINE_QUOTE", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER", "RULE_SL_COMMENT", "'attributes'", "'autodie'", "'autouse'", "'base'", "'bigint'", "'bignum'", "'bigrat'", "'blib'", "'bytes'", "'charnames'", "'constant'", "'diagnostics'", "'encoding'", "'feature'", "'fields'", "'filetest'", "'if'", "'integer'", "'less'", "'lib'", "'locale'", "'mro'", "'open'", "'ops'", "'overload'", "'overloading'", "'parent'", "'re'", "'sigtrap'", "'sort'", "'strict'", "'subs'", "'threads::shared'", "'threads'", "'utf8'", "'vars'", "'vmsish'", "'warnings::register'", "'warnings'", "';'", "'$'", "'%'", "'@'", "'&'", "'abs'", "'accept'", "'alarm'", "'atan2'", "'bind'", "'binmode'", "'bless'", "'break'", "'caller'", "'chdir'", "'chmod'", "'chomp'", "'chop'", "'chown'", "'chr'", "'chroot'", "'close'", "'closedir'", "'connect'", "'continue'", "'cos'", "'crypt'", "'dbmclose'", "'dbmopen'", "'default'", "'defined'", "'delete'", "'die'", "'do'", "'dump'", "'each'", "'else'", "'elsif'", "'endgrent'", "'endhostent'", "'endnetent'", "'endprotoent'", "'endpwent'", "'endservent'", "'eof'", "'eval'", "'evalbytes'", "'exec'", "'exists'", "'exit'", "'exp'", "'fc'", "'fcntl'", "'fileno'", "'flock'", "'for'", "'foreach'", "'fork'", "'format'", "'formline'", "'getc'", "'getgrent'", "'getgrgid'", "'getgrnam'", "'gethostbyaddr'", "'gethostbyname'", "'gethostent'", "'getlogin'", "'getnetbyaddr'", "'getnetbyname'", "'getnetent'", "'getpeername'", "'getpgrp'", "'getppid'", "'getpriority'", "'getprotobyname'", "'getprotobynumber'", "'getprotoent'", "'getpwent'", "'getpwnam'", "'getpwuid'", "'getservbyname'", "'getservbyport'", "'getservent'", "'getsockname'", "'getsockopt'", "'given'", "'glob'", "'gmtime'", "'goto'", "'grep'", "'hex'", "'index'", "'int'", "'ioctl'", "'join'", "'keys'", "'kill'", "'last'", "'lc'", "'lcfirst'", "'length'", "'link'", "'listen'", "'local'", "'localtime'", "'lock'", "'log'", "'lstat'", "'map'", "'mkdir'", "'msgctl'", "'msgget'", "'msgrcv'", "'msgsnd'", "'my'", "'next'", "'no'", "'oct'", "'opendir'", "'ord'", "'our'", "'pack'", "'package'", "'pipe'", "'pop'", "'pos'", "'print'", "'printf'", "'prototype'", "'push'", "'quotemeta'", "'rand'", "'read'", "'readdir'", "'readline'", "'readlink'", "'readpipe'", "'recv'", "'redo'", "'ref'", "'rename'", "'require'", "'reset'", "'return'", "'reverse'", "'rewinddir'", "'rindex'", "'rmdir'", "'say'", "'scalar'", "'seek'", "'seekdir'", "'select'", "'semctl'", "'semget'", "'semop'", "'send'", "'setgrent'", "'sethostent'", "'setnetent'", "'setpgrp'", "'setpriority'", "'setprotoent'", "'setpwent'", "'setservent'", "'setsockopt'", "'shift'", "'shmctl'", "'shmget'", "'shmread'", "'shmwrite'", "'shutdown'", "'sin'", "'sleep'", "'socket'", "'socketpair'", "'splice'", "'split'", "'sprintf'", "'sqrt'", "'srand'", "'stat'", "'state'", "'study'", "'sub'", "'substr'", "'symlink'", "'syscall'", "'sysopen'", "'sysread'", "'sysseek'", "'system'", "'syswrite'", "'tell'", "'telldir'", "'tie'", "'tied'", "'time'", "'times'", "'tr'", "'truncate'", "'uc'", "'ucfirst'", "'umask'", "'undef'", "'unless'", "'unlink'", "'unpack'", "'unshift'", "'untie'", "'until'", "'use'", "'utime'", "'values'", "'vec'", "'wait'", "'waitpid'", "'wantarray'", "'warn'", "'when'", "'while'", "'write'", "'y'", "'++'", "'--'", "'**'", "'!'", "'~'", "'+'", "'-'", "'=~'", "'!~'", "'*'", "'/'", "'x'", "'<<'", "'>>'", "'lt'", "'gt'", "'le'", "'ge'", "'cmp'", "'~~'", "'=='", "'!='", "'..'", "'...'", "','", "'|'", "'^'", "'&&'", "'||'", "'//'", "'?'", "':'", "'**='", "'+='", "'-='", "'.='", "'*='", "'/='", "'%='", "'x='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'&&='", "'||='", "'//='", "'<'", "'>'", "'<='", "'>='", "'<>'", "'=>'", "'->'", "'and'", "'or'", "'xor'", "'not'", "'eq'", "'ne'", "'-r'", "'-w'", "'-x'", "'-o'", "'-R'", "'-W'", "'-X'", "'-O'", "'-e'", "'-z'", "'-s'", "'-f'", "'-d'", "'-l'", "'-p'", "'-S'", "'-b'", "'-c'", "'-t'", "'-u'", "'-g'", "'-k'", "'-T'", "'-B'", "'-M'", "'-A'", "'-C'", "'::'", "'\\''", "'{'", "'}'", "'('", "')'", "'<=>'", "'.'"
    };
    public static final int T__50=50;
    public static final int RULE_READLINE_QUOTE=21;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_DATA=16;
    public static final int RULE_INT=24;
    public static final int T__66=66;
    public static final int RULE_COMMAND_QUOTE_LIKE=19;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_REGEX_TRANSLITERATE=8;
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
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int RULE_END=17;
    public static final int EOF=-1;
    public static final int RULE_NUMBER=14;
    public static final int T__300=300;
    public static final int RULE_VERSION=11;
    public static final int RULE_BIN=23;
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
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_WORDS_QUOTE_LIKE=12;
    public static final int RULE_REGEX_QUOTE=20;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=25;
    public static final int RULE_BACKTICK_STRING=18;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int RULE_SYMBOL=15;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__144=144;
    public static final int T__265=265;
    public static final int T__386=386;
    public static final int T__143=143;
    public static final int T__264=264;
    public static final int T__385=385;
    public static final int T__146=146;
    public static final int T__267=267;
    public static final int T__145=145;
    public static final int T__266=266;
    public static final int T__140=140;
    public static final int T__261=261;
    public static final int T__382=382;
    public static final int T__260=260;
    public static final int T__381=381;
    public static final int T__142=142;
    public static final int T__263=263;
    public static final int T__384=384;
    public static final int T__141=141;
    public static final int T__262=262;
    public static final int T__383=383;
    public static final int T__380=380;
    public static final int T__137=137;
    public static final int T__258=258;
    public static final int T__379=379;
    public static final int T__136=136;
    public static final int T__257=257;
    public static final int T__378=378;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__259=259;
    public static final int T__133=133;
    public static final int T__254=254;
    public static final int T__375=375;
    public static final int T__132=132;
    public static final int T__253=253;
    public static final int T__374=374;
    public static final int T__135=135;
    public static final int T__256=256;
    public static final int T__377=377;
    public static final int T__134=134;
    public static final int T__255=255;
    public static final int T__376=376;
    public static final int T__250=250;
    public static final int T__371=371;
    public static final int RULE_ID=10;
    public static final int T__370=370;
    public static final int T__131=131;
    public static final int T__252=252;
    public static final int T__373=373;
    public static final int T__130=130;
    public static final int T__251=251;
    public static final int T__372=372;
    public static final int T__129=129;
    public static final int T__126=126;
    public static final int T__247=247;
    public static final int T__368=368;
    public static final int T__125=125;
    public static final int T__246=246;
    public static final int T__367=367;
    public static final int T__128=128;
    public static final int T__249=249;
    public static final int T__127=127;
    public static final int T__248=248;
    public static final int T__369=369;
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
    public static final int RULE_POD=13;
    public static final int T__159=159;
    public static final int T__158=158;
    public static final int T__279=279;
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
    public static final int T__148=148;
    public static final int T__269=269;
    public static final int T__147=147;
    public static final int T__268=268;
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
    public static final int T__364=364;
    public static final int T__121=121;
    public static final int T__242=242;
    public static final int T__363=363;
    public static final int T__124=124;
    public static final int T__245=245;
    public static final int T__366=366;
    public static final int T__123=123;
    public static final int T__244=244;
    public static final int T__365=365;
    public static final int T__360=360;
    public static final int T__120=120;
    public static final int T__241=241;
    public static final int T__362=362;
    public static final int T__240=240;
    public static final int T__361=361;
    public static final int RULE_SL_COMMENT=27;
    public static final int T__119=119;
    public static final int T__118=118;
    public static final int T__239=239;
    public static final int T__115=115;
    public static final int T__236=236;
    public static final int T__357=357;
    public static final int T__114=114;
    public static final int T__235=235;
    public static final int T__356=356;
    public static final int T__117=117;
    public static final int T__238=238;
    public static final int T__359=359;
    public static final int T__116=116;
    public static final int T__237=237;
    public static final int T__358=358;
    public static final int T__111=111;
    public static final int T__232=232;
    public static final int T__353=353;
    public static final int T__110=110;
    public static final int T__231=231;
    public static final int T__352=352;
    public static final int T__113=113;
    public static final int T__234=234;
    public static final int T__355=355;
    public static final int T__112=112;
    public static final int T__233=233;
    public static final int T__354=354;
    public static final int T__230=230;
    public static final int T__351=351;
    public static final int T__350=350;
    public static final int T__108=108;
    public static final int T__229=229;
    public static final int T__107=107;
    public static final int T__228=228;
    public static final int T__349=349;
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
    public static final int RULE_HEX=22;
    public static final int RULE_LITERAL=6;
    public static final int RULE_REGEX_MATCH=9;
    public static final int T__188=188;
    public static final int T__187=187;
    public static final int T__189=189;
    public static final int T__184=184;
    public static final int T__183=183;
    public static final int T__186=186;
    public static final int T__185=185;
    public static final int T__180=180;
    public static final int T__182=182;
    public static final int T__181=181;
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
    public static final int T__169=169;
    public static final int RULE_STRING=4;
    public static final int T__199=199;
    public static final int T__198=198;
    public static final int T__195=195;
    public static final int T__194=194;
    public static final int T__197=197;
    public static final int T__196=196;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=26;

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


    // $ANTLR start "entryRulePragma"
    // InternalPerl.g:328:1: entryRulePragma : rulePragma EOF ;
    public final void entryRulePragma() throws RecognitionException {
        try {
            // InternalPerl.g:329:1: ( rulePragma EOF )
            // InternalPerl.g:330:1: rulePragma EOF
            {
             before(grammarAccess.getPragmaRule()); 
            pushFollow(FOLLOW_1);
            rulePragma();

            state._fsp--;

             after(grammarAccess.getPragmaRule()); 
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
    // $ANTLR end "entryRulePragma"


    // $ANTLR start "rulePragma"
    // InternalPerl.g:337:1: rulePragma : ( ( rule__Pragma__Alternatives ) ) ;
    public final void rulePragma() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:341:2: ( ( ( rule__Pragma__Alternatives ) ) )
            // InternalPerl.g:342:2: ( ( rule__Pragma__Alternatives ) )
            {
            // InternalPerl.g:342:2: ( ( rule__Pragma__Alternatives ) )
            // InternalPerl.g:343:3: ( rule__Pragma__Alternatives )
            {
             before(grammarAccess.getPragmaAccess().getAlternatives()); 
            // InternalPerl.g:344:3: ( rule__Pragma__Alternatives )
            // InternalPerl.g:344:4: rule__Pragma__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Pragma__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPragmaAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePragma"


    // $ANTLR start "entryRuleSubStatement"
    // InternalPerl.g:353:1: entryRuleSubStatement : ruleSubStatement EOF ;
    public final void entryRuleSubStatement() throws RecognitionException {
        try {
            // InternalPerl.g:354:1: ( ruleSubStatement EOF )
            // InternalPerl.g:355:1: ruleSubStatement EOF
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
    // InternalPerl.g:362:1: ruleSubStatement : ( ( rule__SubStatement__Group__0 ) ) ;
    public final void ruleSubStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:366:2: ( ( ( rule__SubStatement__Group__0 ) ) )
            // InternalPerl.g:367:2: ( ( rule__SubStatement__Group__0 ) )
            {
            // InternalPerl.g:367:2: ( ( rule__SubStatement__Group__0 ) )
            // InternalPerl.g:368:3: ( rule__SubStatement__Group__0 )
            {
             before(grammarAccess.getSubStatementAccess().getGroup()); 
            // InternalPerl.g:369:3: ( rule__SubStatement__Group__0 )
            // InternalPerl.g:369:4: rule__SubStatement__Group__0
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
    // InternalPerl.g:378:1: entryRuleBlockStructure : ruleBlockStructure EOF ;
    public final void entryRuleBlockStructure() throws RecognitionException {
        try {
            // InternalPerl.g:379:1: ( ruleBlockStructure EOF )
            // InternalPerl.g:380:1: ruleBlockStructure EOF
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
    // InternalPerl.g:387:1: ruleBlockStructure : ( ( rule__BlockStructure__Group__0 ) ) ;
    public final void ruleBlockStructure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:391:2: ( ( ( rule__BlockStructure__Group__0 ) ) )
            // InternalPerl.g:392:2: ( ( rule__BlockStructure__Group__0 ) )
            {
            // InternalPerl.g:392:2: ( ( rule__BlockStructure__Group__0 ) )
            // InternalPerl.g:393:3: ( rule__BlockStructure__Group__0 )
            {
             before(grammarAccess.getBlockStructureAccess().getGroup()); 
            // InternalPerl.g:394:3: ( rule__BlockStructure__Group__0 )
            // InternalPerl.g:394:4: rule__BlockStructure__Group__0
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
    // InternalPerl.g:403:1: entryRulePrototype : rulePrototype EOF ;
    public final void entryRulePrototype() throws RecognitionException {
        try {
            // InternalPerl.g:404:1: ( rulePrototype EOF )
            // InternalPerl.g:405:1: rulePrototype EOF
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
    // InternalPerl.g:412:1: rulePrototype : ( ( rule__Prototype__Group__0 ) ) ;
    public final void rulePrototype() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:416:2: ( ( ( rule__Prototype__Group__0 ) ) )
            // InternalPerl.g:417:2: ( ( rule__Prototype__Group__0 ) )
            {
            // InternalPerl.g:417:2: ( ( rule__Prototype__Group__0 ) )
            // InternalPerl.g:418:3: ( rule__Prototype__Group__0 )
            {
             before(grammarAccess.getPrototypeAccess().getGroup()); 
            // InternalPerl.g:419:3: ( rule__Prototype__Group__0 )
            // InternalPerl.g:419:4: rule__Prototype__Group__0
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
    // InternalPerl.g:428:1: entryRuleToken : ruleToken EOF ;
    public final void entryRuleToken() throws RecognitionException {
        try {
            // InternalPerl.g:429:1: ( ruleToken EOF )
            // InternalPerl.g:430:1: ruleToken EOF
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
    // InternalPerl.g:437:1: ruleToken : ( ( rule__Token__Alternatives ) ) ;
    public final void ruleToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:441:2: ( ( ( rule__Token__Alternatives ) ) )
            // InternalPerl.g:442:2: ( ( rule__Token__Alternatives ) )
            {
            // InternalPerl.g:442:2: ( ( rule__Token__Alternatives ) )
            // InternalPerl.g:443:3: ( rule__Token__Alternatives )
            {
             before(grammarAccess.getTokenAccess().getAlternatives()); 
            // InternalPerl.g:444:3: ( rule__Token__Alternatives )
            // InternalPerl.g:444:4: rule__Token__Alternatives
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
    // InternalPerl.g:453:1: entryRuleQuoteToken : ruleQuoteToken EOF ;
    public final void entryRuleQuoteToken() throws RecognitionException {
        try {
            // InternalPerl.g:454:1: ( ruleQuoteToken EOF )
            // InternalPerl.g:455:1: ruleQuoteToken EOF
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
    // InternalPerl.g:462:1: ruleQuoteToken : ( ( rule__QuoteToken__Group__0 ) ) ;
    public final void ruleQuoteToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:466:2: ( ( ( rule__QuoteToken__Group__0 ) ) )
            // InternalPerl.g:467:2: ( ( rule__QuoteToken__Group__0 ) )
            {
            // InternalPerl.g:467:2: ( ( rule__QuoteToken__Group__0 ) )
            // InternalPerl.g:468:3: ( rule__QuoteToken__Group__0 )
            {
             before(grammarAccess.getQuoteTokenAccess().getGroup()); 
            // InternalPerl.g:469:3: ( rule__QuoteToken__Group__0 )
            // InternalPerl.g:469:4: rule__QuoteToken__Group__0
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
    // InternalPerl.g:478:1: entryRuleRegexToken : ruleRegexToken EOF ;
    public final void entryRuleRegexToken() throws RecognitionException {
        try {
            // InternalPerl.g:479:1: ( ruleRegexToken EOF )
            // InternalPerl.g:480:1: ruleRegexToken EOF
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
    // InternalPerl.g:487:1: ruleRegexToken : ( ( rule__RegexToken__Group__0 ) ) ;
    public final void ruleRegexToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:491:2: ( ( ( rule__RegexToken__Group__0 ) ) )
            // InternalPerl.g:492:2: ( ( rule__RegexToken__Group__0 ) )
            {
            // InternalPerl.g:492:2: ( ( rule__RegexToken__Group__0 ) )
            // InternalPerl.g:493:3: ( rule__RegexToken__Group__0 )
            {
             before(grammarAccess.getRegexTokenAccess().getGroup()); 
            // InternalPerl.g:494:3: ( rule__RegexToken__Group__0 )
            // InternalPerl.g:494:4: rule__RegexToken__Group__0
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
    // InternalPerl.g:503:1: entryRuleQuoteLikeToken : ruleQuoteLikeToken EOF ;
    public final void entryRuleQuoteLikeToken() throws RecognitionException {
        try {
            // InternalPerl.g:504:1: ( ruleQuoteLikeToken EOF )
            // InternalPerl.g:505:1: ruleQuoteLikeToken EOF
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
    // InternalPerl.g:512:1: ruleQuoteLikeToken : ( ( rule__QuoteLikeToken__Alternatives ) ) ;
    public final void ruleQuoteLikeToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:516:2: ( ( ( rule__QuoteLikeToken__Alternatives ) ) )
            // InternalPerl.g:517:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            {
            // InternalPerl.g:517:2: ( ( rule__QuoteLikeToken__Alternatives ) )
            // InternalPerl.g:518:3: ( rule__QuoteLikeToken__Alternatives )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getAlternatives()); 
            // InternalPerl.g:519:3: ( rule__QuoteLikeToken__Alternatives )
            // InternalPerl.g:519:4: rule__QuoteLikeToken__Alternatives
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
    // InternalPerl.g:528:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalPerl.g:529:1: ( ruleWord EOF )
            // InternalPerl.g:530:1: ruleWord EOF
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
    // InternalPerl.g:537:1: ruleWord : ( ruleKeyword ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:541:2: ( ( ruleKeyword ) )
            // InternalPerl.g:542:2: ( ruleKeyword )
            {
            // InternalPerl.g:542:2: ( ruleKeyword )
            // InternalPerl.g:543:3: ruleKeyword
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
    // InternalPerl.g:553:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalPerl.g:554:1: ( ruleKeyword EOF )
            // InternalPerl.g:555:1: ruleKeyword EOF
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
    // InternalPerl.g:562:1: ruleKeyword : ( ( rule__Keyword__Alternatives ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:566:2: ( ( ( rule__Keyword__Alternatives ) ) )
            // InternalPerl.g:567:2: ( ( rule__Keyword__Alternatives ) )
            {
            // InternalPerl.g:567:2: ( ( rule__Keyword__Alternatives ) )
            // InternalPerl.g:568:3: ( rule__Keyword__Alternatives )
            {
             before(grammarAccess.getKeywordAccess().getAlternatives()); 
            // InternalPerl.g:569:3: ( rule__Keyword__Alternatives )
            // InternalPerl.g:569:4: rule__Keyword__Alternatives
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
    // InternalPerl.g:578:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalPerl.g:579:1: ( ruleOperator EOF )
            // InternalPerl.g:580:1: ruleOperator EOF
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
    // InternalPerl.g:587:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:591:2: ( ( ( rule__Operator__Alternatives ) ) )
            // InternalPerl.g:592:2: ( ( rule__Operator__Alternatives ) )
            {
            // InternalPerl.g:592:2: ( ( rule__Operator__Alternatives ) )
            // InternalPerl.g:593:3: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // InternalPerl.g:594:3: ( rule__Operator__Alternatives )
            // InternalPerl.g:594:4: rule__Operator__Alternatives
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
    // InternalPerl.g:603:1: entryRuleFileTestOperator : ruleFileTestOperator EOF ;
    public final void entryRuleFileTestOperator() throws RecognitionException {
        try {
            // InternalPerl.g:604:1: ( ruleFileTestOperator EOF )
            // InternalPerl.g:605:1: ruleFileTestOperator EOF
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
    // InternalPerl.g:612:1: ruleFileTestOperator : ( ( rule__FileTestOperator__Alternatives ) ) ;
    public final void ruleFileTestOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:616:2: ( ( ( rule__FileTestOperator__Alternatives ) ) )
            // InternalPerl.g:617:2: ( ( rule__FileTestOperator__Alternatives ) )
            {
            // InternalPerl.g:617:2: ( ( rule__FileTestOperator__Alternatives ) )
            // InternalPerl.g:618:3: ( rule__FileTestOperator__Alternatives )
            {
             before(grammarAccess.getFileTestOperatorAccess().getAlternatives()); 
            // InternalPerl.g:619:3: ( rule__FileTestOperator__Alternatives )
            // InternalPerl.g:619:4: rule__FileTestOperator__Alternatives
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


    // $ANTLR start "entryRuleQUALIFIED_ID"
    // InternalPerl.g:628:1: entryRuleQUALIFIED_ID : ruleQUALIFIED_ID EOF ;
    public final void entryRuleQUALIFIED_ID() throws RecognitionException {
        try {
            // InternalPerl.g:629:1: ( ruleQUALIFIED_ID EOF )
            // InternalPerl.g:630:1: ruleQUALIFIED_ID EOF
            {
             before(grammarAccess.getQUALIFIED_IDRule()); 
            pushFollow(FOLLOW_1);
            ruleQUALIFIED_ID();

            state._fsp--;

             after(grammarAccess.getQUALIFIED_IDRule()); 
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
    // $ANTLR end "entryRuleQUALIFIED_ID"


    // $ANTLR start "ruleQUALIFIED_ID"
    // InternalPerl.g:637:1: ruleQUALIFIED_ID : ( ( rule__QUALIFIED_ID__Group__0 ) ) ;
    public final void ruleQUALIFIED_ID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:641:2: ( ( ( rule__QUALIFIED_ID__Group__0 ) ) )
            // InternalPerl.g:642:2: ( ( rule__QUALIFIED_ID__Group__0 ) )
            {
            // InternalPerl.g:642:2: ( ( rule__QUALIFIED_ID__Group__0 ) )
            // InternalPerl.g:643:3: ( rule__QUALIFIED_ID__Group__0 )
            {
             before(grammarAccess.getQUALIFIED_IDAccess().getGroup()); 
            // InternalPerl.g:644:3: ( rule__QUALIFIED_ID__Group__0 )
            // InternalPerl.g:644:4: rule__QUALIFIED_ID__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QUALIFIED_ID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQUALIFIED_IDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQUALIFIED_ID"


    // $ANTLR start "rule__Element__Alternatives"
    // InternalPerl.g:652:1: rule__Element__Alternatives : ( ( ruleNode ) | ( ruleToken ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:656:1: ( ( ruleNode ) | ( ruleToken ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalPerl.g:657:2: ( ruleNode )
                    {
                    // InternalPerl.g:657:2: ( ruleNode )
                    // InternalPerl.g:658:3: ruleNode
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
                    // InternalPerl.g:663:2: ( ruleToken )
                    {
                    // InternalPerl.g:663:2: ( ruleToken )
                    // InternalPerl.g:664:3: ruleToken
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
    // InternalPerl.g:673:1: rule__Node__Alternatives : ( ( ruleStatementNode ) | ( ruleStructureNode ) );
    public final void rule__Node__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:677:1: ( ( ruleStatementNode ) | ( ruleStructureNode ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==190||LA2_0==209||LA2_0==252||LA2_0==279) ) {
                alt2=1;
            }
            else if ( (LA2_0==381) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalPerl.g:678:2: ( ruleStatementNode )
                    {
                    // InternalPerl.g:678:2: ( ruleStatementNode )
                    // InternalPerl.g:679:3: ruleStatementNode
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
                    // InternalPerl.g:684:2: ( ruleStructureNode )
                    {
                    // InternalPerl.g:684:2: ( ruleStructureNode )
                    // InternalPerl.g:685:3: ruleStructureNode
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
    // InternalPerl.g:694:1: rule__StatementNode__Alternatives : ( ( ruleBlockStatement ) | ( ruleExpressionStatement ) );
    public final void rule__StatementNode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:698:1: ( ( ruleBlockStatement ) | ( ruleExpressionStatement ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==252) ) {
                alt3=1;
            }
            else if ( (LA3_0==190||LA3_0==209||LA3_0==279) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalPerl.g:699:2: ( ruleBlockStatement )
                    {
                    // InternalPerl.g:699:2: ( ruleBlockStatement )
                    // InternalPerl.g:700:3: ruleBlockStatement
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
                    // InternalPerl.g:705:2: ( ruleExpressionStatement )
                    {
                    // InternalPerl.g:705:2: ( ruleExpressionStatement )
                    // InternalPerl.g:706:3: ruleExpressionStatement
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
    // InternalPerl.g:715:1: rule__ExpressionStatement__Alternatives_0 : ( ( rulePackageStatement ) | ( ruleIncludeStatement ) );
    public final void rule__ExpressionStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:719:1: ( ( rulePackageStatement ) | ( ruleIncludeStatement ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==190) ) {
                alt4=1;
            }
            else if ( (LA4_0==209||LA4_0==279) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalPerl.g:720:2: ( rulePackageStatement )
                    {
                    // InternalPerl.g:720:2: ( rulePackageStatement )
                    // InternalPerl.g:721:3: rulePackageStatement
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
                    // InternalPerl.g:726:2: ( ruleIncludeStatement )
                    {
                    // InternalPerl.g:726:2: ( ruleIncludeStatement )
                    // InternalPerl.g:727:3: ruleIncludeStatement
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
    // InternalPerl.g:736:1: rule__IncludeStatement__Alternatives : ( ( ruleRequireInclude ) | ( ruleUseInclude ) );
    public final void rule__IncludeStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:740:1: ( ( ruleRequireInclude ) | ( ruleUseInclude ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==209) ) {
                alt5=1;
            }
            else if ( (LA5_0==279) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalPerl.g:741:2: ( ruleRequireInclude )
                    {
                    // InternalPerl.g:741:2: ( ruleRequireInclude )
                    // InternalPerl.g:742:3: ruleRequireInclude
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
                    // InternalPerl.g:747:2: ( ruleUseInclude )
                    {
                    // InternalPerl.g:747:2: ( ruleUseInclude )
                    // InternalPerl.g:748:3: ruleUseInclude
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
    // InternalPerl.g:757:1: rule__UseInclude__Alternatives_2 : ( ( ( rule__UseInclude__VersionAssignment_2_0 ) ) | ( ( rule__UseInclude__Group_2_1__0 ) ) );
    public final void rule__UseInclude__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:761:1: ( ( ( rule__UseInclude__VersionAssignment_2_0 ) ) | ( ( rule__UseInclude__Group_2_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_VERSION) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID||(LA6_0>=28 && LA6_0<=66)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalPerl.g:762:2: ( ( rule__UseInclude__VersionAssignment_2_0 ) )
                    {
                    // InternalPerl.g:762:2: ( ( rule__UseInclude__VersionAssignment_2_0 ) )
                    // InternalPerl.g:763:3: ( rule__UseInclude__VersionAssignment_2_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getVersionAssignment_2_0()); 
                    // InternalPerl.g:764:3: ( rule__UseInclude__VersionAssignment_2_0 )
                    // InternalPerl.g:764:4: rule__UseInclude__VersionAssignment_2_0
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
                    // InternalPerl.g:768:2: ( ( rule__UseInclude__Group_2_1__0 ) )
                    {
                    // InternalPerl.g:768:2: ( ( rule__UseInclude__Group_2_1__0 ) )
                    // InternalPerl.g:769:3: ( rule__UseInclude__Group_2_1__0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getGroup_2_1()); 
                    // InternalPerl.g:770:3: ( rule__UseInclude__Group_2_1__0 )
                    // InternalPerl.g:770:4: rule__UseInclude__Group_2_1__0
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


    // $ANTLR start "rule__UseInclude__Alternatives_2_1_0"
    // InternalPerl.g:778:1: rule__UseInclude__Alternatives_2_1_0 : ( ( ( rule__UseInclude__PragmaAssignment_2_1_0_0 ) ) | ( ( rule__UseInclude__PackageAssignment_2_1_0_1 ) ) );
    public final void rule__UseInclude__Alternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:782:1: ( ( ( rule__UseInclude__PragmaAssignment_2_1_0_0 ) ) | ( ( rule__UseInclude__PackageAssignment_2_1_0_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=28 && LA7_0<=66)) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalPerl.g:783:2: ( ( rule__UseInclude__PragmaAssignment_2_1_0_0 ) )
                    {
                    // InternalPerl.g:783:2: ( ( rule__UseInclude__PragmaAssignment_2_1_0_0 ) )
                    // InternalPerl.g:784:3: ( rule__UseInclude__PragmaAssignment_2_1_0_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getPragmaAssignment_2_1_0_0()); 
                    // InternalPerl.g:785:3: ( rule__UseInclude__PragmaAssignment_2_1_0_0 )
                    // InternalPerl.g:785:4: rule__UseInclude__PragmaAssignment_2_1_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UseInclude__PragmaAssignment_2_1_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUseIncludeAccess().getPragmaAssignment_2_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:789:2: ( ( rule__UseInclude__PackageAssignment_2_1_0_1 ) )
                    {
                    // InternalPerl.g:789:2: ( ( rule__UseInclude__PackageAssignment_2_1_0_1 ) )
                    // InternalPerl.g:790:3: ( rule__UseInclude__PackageAssignment_2_1_0_1 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getPackageAssignment_2_1_0_1()); 
                    // InternalPerl.g:791:3: ( rule__UseInclude__PackageAssignment_2_1_0_1 )
                    // InternalPerl.g:791:4: rule__UseInclude__PackageAssignment_2_1_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__UseInclude__PackageAssignment_2_1_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getUseIncludeAccess().getPackageAssignment_2_1_0_1()); 

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
    // $ANTLR end "rule__UseInclude__Alternatives_2_1_0"


    // $ANTLR start "rule__UseInclude__Alternatives_2_1_1"
    // InternalPerl.g:799:1: rule__UseInclude__Alternatives_2_1_1 : ( ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) ) | ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) ) );
    public final void rule__UseInclude__Alternatives_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:803:1: ( ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) ) | ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_LITERAL)) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_WORDS_QUOTE_LIKE) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalPerl.g:804:2: ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) )
                    {
                    // InternalPerl.g:804:2: ( ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 ) )
                    // InternalPerl.g:805:3: ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getStringArgumentAssignment_2_1_1_0()); 
                    // InternalPerl.g:806:3: ( rule__UseInclude__StringArgumentAssignment_2_1_1_0 )
                    // InternalPerl.g:806:4: rule__UseInclude__StringArgumentAssignment_2_1_1_0
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
                    // InternalPerl.g:810:2: ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) )
                    {
                    // InternalPerl.g:810:2: ( ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 ) )
                    // InternalPerl.g:811:3: ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 )
                    {
                     before(grammarAccess.getUseIncludeAccess().getQwArgumentAssignment_2_1_1_1()); 
                    // InternalPerl.g:812:3: ( rule__UseInclude__QwArgumentAssignment_2_1_1_1 )
                    // InternalPerl.g:812:4: rule__UseInclude__QwArgumentAssignment_2_1_1_1
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


    // $ANTLR start "rule__Pragma__Alternatives"
    // InternalPerl.g:820:1: rule__Pragma__Alternatives : ( ( 'attributes' ) | ( 'autodie' ) | ( 'autouse' ) | ( 'base' ) | ( 'bigint' ) | ( 'bignum' ) | ( 'bigrat' ) | ( 'blib' ) | ( 'bytes' ) | ( 'charnames' ) | ( 'constant' ) | ( 'diagnostics' ) | ( 'encoding' ) | ( 'feature' ) | ( 'fields' ) | ( 'filetest' ) | ( 'if' ) | ( 'integer' ) | ( 'less' ) | ( 'lib' ) | ( 'locale' ) | ( 'mro' ) | ( 'open' ) | ( 'ops' ) | ( 'overload' ) | ( 'overloading' ) | ( 'parent' ) | ( 're' ) | ( 'sigtrap' ) | ( 'sort' ) | ( 'strict' ) | ( 'subs' ) | ( 'threads::shared' ) | ( 'threads' ) | ( 'utf8' ) | ( 'vars' ) | ( 'vmsish' ) | ( 'warnings::register' ) | ( 'warnings' ) );
    public final void rule__Pragma__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:824:1: ( ( 'attributes' ) | ( 'autodie' ) | ( 'autouse' ) | ( 'base' ) | ( 'bigint' ) | ( 'bignum' ) | ( 'bigrat' ) | ( 'blib' ) | ( 'bytes' ) | ( 'charnames' ) | ( 'constant' ) | ( 'diagnostics' ) | ( 'encoding' ) | ( 'feature' ) | ( 'fields' ) | ( 'filetest' ) | ( 'if' ) | ( 'integer' ) | ( 'less' ) | ( 'lib' ) | ( 'locale' ) | ( 'mro' ) | ( 'open' ) | ( 'ops' ) | ( 'overload' ) | ( 'overloading' ) | ( 'parent' ) | ( 're' ) | ( 'sigtrap' ) | ( 'sort' ) | ( 'strict' ) | ( 'subs' ) | ( 'threads::shared' ) | ( 'threads' ) | ( 'utf8' ) | ( 'vars' ) | ( 'vmsish' ) | ( 'warnings::register' ) | ( 'warnings' ) )
            int alt9=39;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt9=1;
                }
                break;
            case 29:
                {
                alt9=2;
                }
                break;
            case 30:
                {
                alt9=3;
                }
                break;
            case 31:
                {
                alt9=4;
                }
                break;
            case 32:
                {
                alt9=5;
                }
                break;
            case 33:
                {
                alt9=6;
                }
                break;
            case 34:
                {
                alt9=7;
                }
                break;
            case 35:
                {
                alt9=8;
                }
                break;
            case 36:
                {
                alt9=9;
                }
                break;
            case 37:
                {
                alt9=10;
                }
                break;
            case 38:
                {
                alt9=11;
                }
                break;
            case 39:
                {
                alt9=12;
                }
                break;
            case 40:
                {
                alt9=13;
                }
                break;
            case 41:
                {
                alt9=14;
                }
                break;
            case 42:
                {
                alt9=15;
                }
                break;
            case 43:
                {
                alt9=16;
                }
                break;
            case 44:
                {
                alt9=17;
                }
                break;
            case 45:
                {
                alt9=18;
                }
                break;
            case 46:
                {
                alt9=19;
                }
                break;
            case 47:
                {
                alt9=20;
                }
                break;
            case 48:
                {
                alt9=21;
                }
                break;
            case 49:
                {
                alt9=22;
                }
                break;
            case 50:
                {
                alt9=23;
                }
                break;
            case 51:
                {
                alt9=24;
                }
                break;
            case 52:
                {
                alt9=25;
                }
                break;
            case 53:
                {
                alt9=26;
                }
                break;
            case 54:
                {
                alt9=27;
                }
                break;
            case 55:
                {
                alt9=28;
                }
                break;
            case 56:
                {
                alt9=29;
                }
                break;
            case 57:
                {
                alt9=30;
                }
                break;
            case 58:
                {
                alt9=31;
                }
                break;
            case 59:
                {
                alt9=32;
                }
                break;
            case 60:
                {
                alt9=33;
                }
                break;
            case 61:
                {
                alt9=34;
                }
                break;
            case 62:
                {
                alt9=35;
                }
                break;
            case 63:
                {
                alt9=36;
                }
                break;
            case 64:
                {
                alt9=37;
                }
                break;
            case 65:
                {
                alt9=38;
                }
                break;
            case 66:
                {
                alt9=39;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalPerl.g:825:2: ( 'attributes' )
                    {
                    // InternalPerl.g:825:2: ( 'attributes' )
                    // InternalPerl.g:826:3: 'attributes'
                    {
                     before(grammarAccess.getPragmaAccess().getAttributesKeyword_0()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getAttributesKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:831:2: ( 'autodie' )
                    {
                    // InternalPerl.g:831:2: ( 'autodie' )
                    // InternalPerl.g:832:3: 'autodie'
                    {
                     before(grammarAccess.getPragmaAccess().getAutodieKeyword_1()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getAutodieKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:837:2: ( 'autouse' )
                    {
                    // InternalPerl.g:837:2: ( 'autouse' )
                    // InternalPerl.g:838:3: 'autouse'
                    {
                     before(grammarAccess.getPragmaAccess().getAutouseKeyword_2()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getAutouseKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:843:2: ( 'base' )
                    {
                    // InternalPerl.g:843:2: ( 'base' )
                    // InternalPerl.g:844:3: 'base'
                    {
                     before(grammarAccess.getPragmaAccess().getBaseKeyword_3()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getBaseKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:849:2: ( 'bigint' )
                    {
                    // InternalPerl.g:849:2: ( 'bigint' )
                    // InternalPerl.g:850:3: 'bigint'
                    {
                     before(grammarAccess.getPragmaAccess().getBigintKeyword_4()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getBigintKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:855:2: ( 'bignum' )
                    {
                    // InternalPerl.g:855:2: ( 'bignum' )
                    // InternalPerl.g:856:3: 'bignum'
                    {
                     before(grammarAccess.getPragmaAccess().getBignumKeyword_5()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getBignumKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:861:2: ( 'bigrat' )
                    {
                    // InternalPerl.g:861:2: ( 'bigrat' )
                    // InternalPerl.g:862:3: 'bigrat'
                    {
                     before(grammarAccess.getPragmaAccess().getBigratKeyword_6()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getBigratKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:867:2: ( 'blib' )
                    {
                    // InternalPerl.g:867:2: ( 'blib' )
                    // InternalPerl.g:868:3: 'blib'
                    {
                     before(grammarAccess.getPragmaAccess().getBlibKeyword_7()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getBlibKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:873:2: ( 'bytes' )
                    {
                    // InternalPerl.g:873:2: ( 'bytes' )
                    // InternalPerl.g:874:3: 'bytes'
                    {
                     before(grammarAccess.getPragmaAccess().getBytesKeyword_8()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getBytesKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:879:2: ( 'charnames' )
                    {
                    // InternalPerl.g:879:2: ( 'charnames' )
                    // InternalPerl.g:880:3: 'charnames'
                    {
                     before(grammarAccess.getPragmaAccess().getCharnamesKeyword_9()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getCharnamesKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:885:2: ( 'constant' )
                    {
                    // InternalPerl.g:885:2: ( 'constant' )
                    // InternalPerl.g:886:3: 'constant'
                    {
                     before(grammarAccess.getPragmaAccess().getConstantKeyword_10()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getConstantKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:891:2: ( 'diagnostics' )
                    {
                    // InternalPerl.g:891:2: ( 'diagnostics' )
                    // InternalPerl.g:892:3: 'diagnostics'
                    {
                     before(grammarAccess.getPragmaAccess().getDiagnosticsKeyword_11()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getDiagnosticsKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:897:2: ( 'encoding' )
                    {
                    // InternalPerl.g:897:2: ( 'encoding' )
                    // InternalPerl.g:898:3: 'encoding'
                    {
                     before(grammarAccess.getPragmaAccess().getEncodingKeyword_12()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getEncodingKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:903:2: ( 'feature' )
                    {
                    // InternalPerl.g:903:2: ( 'feature' )
                    // InternalPerl.g:904:3: 'feature'
                    {
                     before(grammarAccess.getPragmaAccess().getFeatureKeyword_13()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getFeatureKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:909:2: ( 'fields' )
                    {
                    // InternalPerl.g:909:2: ( 'fields' )
                    // InternalPerl.g:910:3: 'fields'
                    {
                     before(grammarAccess.getPragmaAccess().getFieldsKeyword_14()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getFieldsKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:915:2: ( 'filetest' )
                    {
                    // InternalPerl.g:915:2: ( 'filetest' )
                    // InternalPerl.g:916:3: 'filetest'
                    {
                     before(grammarAccess.getPragmaAccess().getFiletestKeyword_15()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getFiletestKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:921:2: ( 'if' )
                    {
                    // InternalPerl.g:921:2: ( 'if' )
                    // InternalPerl.g:922:3: 'if'
                    {
                     before(grammarAccess.getPragmaAccess().getIfKeyword_16()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getIfKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:927:2: ( 'integer' )
                    {
                    // InternalPerl.g:927:2: ( 'integer' )
                    // InternalPerl.g:928:3: 'integer'
                    {
                     before(grammarAccess.getPragmaAccess().getIntegerKeyword_17()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getIntegerKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:933:2: ( 'less' )
                    {
                    // InternalPerl.g:933:2: ( 'less' )
                    // InternalPerl.g:934:3: 'less'
                    {
                     before(grammarAccess.getPragmaAccess().getLessKeyword_18()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getLessKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:939:2: ( 'lib' )
                    {
                    // InternalPerl.g:939:2: ( 'lib' )
                    // InternalPerl.g:940:3: 'lib'
                    {
                     before(grammarAccess.getPragmaAccess().getLibKeyword_19()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getLibKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:945:2: ( 'locale' )
                    {
                    // InternalPerl.g:945:2: ( 'locale' )
                    // InternalPerl.g:946:3: 'locale'
                    {
                     before(grammarAccess.getPragmaAccess().getLocaleKeyword_20()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getLocaleKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:951:2: ( 'mro' )
                    {
                    // InternalPerl.g:951:2: ( 'mro' )
                    // InternalPerl.g:952:3: 'mro'
                    {
                     before(grammarAccess.getPragmaAccess().getMroKeyword_21()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getMroKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:957:2: ( 'open' )
                    {
                    // InternalPerl.g:957:2: ( 'open' )
                    // InternalPerl.g:958:3: 'open'
                    {
                     before(grammarAccess.getPragmaAccess().getOpenKeyword_22()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getOpenKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:963:2: ( 'ops' )
                    {
                    // InternalPerl.g:963:2: ( 'ops' )
                    // InternalPerl.g:964:3: 'ops'
                    {
                     before(grammarAccess.getPragmaAccess().getOpsKeyword_23()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getOpsKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:969:2: ( 'overload' )
                    {
                    // InternalPerl.g:969:2: ( 'overload' )
                    // InternalPerl.g:970:3: 'overload'
                    {
                     before(grammarAccess.getPragmaAccess().getOverloadKeyword_24()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getOverloadKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:975:2: ( 'overloading' )
                    {
                    // InternalPerl.g:975:2: ( 'overloading' )
                    // InternalPerl.g:976:3: 'overloading'
                    {
                     before(grammarAccess.getPragmaAccess().getOverloadingKeyword_25()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getOverloadingKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:981:2: ( 'parent' )
                    {
                    // InternalPerl.g:981:2: ( 'parent' )
                    // InternalPerl.g:982:3: 'parent'
                    {
                     before(grammarAccess.getPragmaAccess().getParentKeyword_26()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getParentKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:987:2: ( 're' )
                    {
                    // InternalPerl.g:987:2: ( 're' )
                    // InternalPerl.g:988:3: 're'
                    {
                     before(grammarAccess.getPragmaAccess().getReKeyword_27()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getReKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:993:2: ( 'sigtrap' )
                    {
                    // InternalPerl.g:993:2: ( 'sigtrap' )
                    // InternalPerl.g:994:3: 'sigtrap'
                    {
                     before(grammarAccess.getPragmaAccess().getSigtrapKeyword_28()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getSigtrapKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:999:2: ( 'sort' )
                    {
                    // InternalPerl.g:999:2: ( 'sort' )
                    // InternalPerl.g:1000:3: 'sort'
                    {
                     before(grammarAccess.getPragmaAccess().getSortKeyword_29()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getSortKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:1005:2: ( 'strict' )
                    {
                    // InternalPerl.g:1005:2: ( 'strict' )
                    // InternalPerl.g:1006:3: 'strict'
                    {
                     before(grammarAccess.getPragmaAccess().getStrictKeyword_30()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getStrictKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:1011:2: ( 'subs' )
                    {
                    // InternalPerl.g:1011:2: ( 'subs' )
                    // InternalPerl.g:1012:3: 'subs'
                    {
                     before(grammarAccess.getPragmaAccess().getSubsKeyword_31()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getSubsKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:1017:2: ( 'threads::shared' )
                    {
                    // InternalPerl.g:1017:2: ( 'threads::shared' )
                    // InternalPerl.g:1018:3: 'threads::shared'
                    {
                     before(grammarAccess.getPragmaAccess().getThreadsSharedKeyword_32()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getThreadsSharedKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:1023:2: ( 'threads' )
                    {
                    // InternalPerl.g:1023:2: ( 'threads' )
                    // InternalPerl.g:1024:3: 'threads'
                    {
                     before(grammarAccess.getPragmaAccess().getThreadsKeyword_33()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getThreadsKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:1029:2: ( 'utf8' )
                    {
                    // InternalPerl.g:1029:2: ( 'utf8' )
                    // InternalPerl.g:1030:3: 'utf8'
                    {
                     before(grammarAccess.getPragmaAccess().getUtf8Keyword_34()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getUtf8Keyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:1035:2: ( 'vars' )
                    {
                    // InternalPerl.g:1035:2: ( 'vars' )
                    // InternalPerl.g:1036:3: 'vars'
                    {
                     before(grammarAccess.getPragmaAccess().getVarsKeyword_35()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getVarsKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:1041:2: ( 'vmsish' )
                    {
                    // InternalPerl.g:1041:2: ( 'vmsish' )
                    // InternalPerl.g:1042:3: 'vmsish'
                    {
                     before(grammarAccess.getPragmaAccess().getVmsishKeyword_36()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getVmsishKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:1047:2: ( 'warnings::register' )
                    {
                    // InternalPerl.g:1047:2: ( 'warnings::register' )
                    // InternalPerl.g:1048:3: 'warnings::register'
                    {
                     before(grammarAccess.getPragmaAccess().getWarningsRegisterKeyword_37()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getWarningsRegisterKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:1053:2: ( 'warnings' )
                    {
                    // InternalPerl.g:1053:2: ( 'warnings' )
                    // InternalPerl.g:1054:3: 'warnings'
                    {
                     before(grammarAccess.getPragmaAccess().getWarningsKeyword_38()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getPragmaAccess().getWarningsKeyword_38()); 

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
    // $ANTLR end "rule__Pragma__Alternatives"


    // $ANTLR start "rule__SubStatement__Alternatives_4"
    // InternalPerl.g:1063:1: rule__SubStatement__Alternatives_4 : ( ( ( rule__SubStatement__BlockAssignment_4_0 ) ) | ( ';' ) );
    public final void rule__SubStatement__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1067:1: ( ( ( rule__SubStatement__BlockAssignment_4_0 ) ) | ( ';' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==381) ) {
                alt10=1;
            }
            else if ( (LA10_0==67) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalPerl.g:1068:2: ( ( rule__SubStatement__BlockAssignment_4_0 ) )
                    {
                    // InternalPerl.g:1068:2: ( ( rule__SubStatement__BlockAssignment_4_0 ) )
                    // InternalPerl.g:1069:3: ( rule__SubStatement__BlockAssignment_4_0 )
                    {
                     before(grammarAccess.getSubStatementAccess().getBlockAssignment_4_0()); 
                    // InternalPerl.g:1070:3: ( rule__SubStatement__BlockAssignment_4_0 )
                    // InternalPerl.g:1070:4: rule__SubStatement__BlockAssignment_4_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SubStatement__BlockAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSubStatementAccess().getBlockAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1074:2: ( ';' )
                    {
                    // InternalPerl.g:1074:2: ( ';' )
                    // InternalPerl.g:1075:3: ';'
                    {
                     before(grammarAccess.getSubStatementAccess().getSemicolonKeyword_4_1()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getSubStatementAccess().getSemicolonKeyword_4_1()); 

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
    // InternalPerl.g:1084:1: rule__Prototype__Alternatives_1 : ( ( '$' ) | ( '%' ) | ( '@' ) | ( '&' ) | ( ';' ) );
    public final void rule__Prototype__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1088:1: ( ( '$' ) | ( '%' ) | ( '@' ) | ( '&' ) | ( ';' ) )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt11=1;
                }
                break;
            case 69:
                {
                alt11=2;
                }
                break;
            case 70:
                {
                alt11=3;
                }
                break;
            case 71:
                {
                alt11=4;
                }
                break;
            case 67:
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
                    // InternalPerl.g:1089:2: ( '$' )
                    {
                    // InternalPerl.g:1089:2: ( '$' )
                    // InternalPerl.g:1090:3: '$'
                    {
                     before(grammarAccess.getPrototypeAccess().getDollarSignKeyword_1_0()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getDollarSignKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1095:2: ( '%' )
                    {
                    // InternalPerl.g:1095:2: ( '%' )
                    // InternalPerl.g:1096:3: '%'
                    {
                     before(grammarAccess.getPrototypeAccess().getPercentSignKeyword_1_1()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getPercentSignKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1101:2: ( '@' )
                    {
                    // InternalPerl.g:1101:2: ( '@' )
                    // InternalPerl.g:1102:3: '@'
                    {
                     before(grammarAccess.getPrototypeAccess().getCommercialAtKeyword_1_2()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getCommercialAtKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1107:2: ( '&' )
                    {
                    // InternalPerl.g:1107:2: ( '&' )
                    // InternalPerl.g:1108:3: '&'
                    {
                     before(grammarAccess.getPrototypeAccess().getAmpersandKeyword_1_3()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getPrototypeAccess().getAmpersandKeyword_1_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:1113:2: ( ';' )
                    {
                    // InternalPerl.g:1113:2: ( ';' )
                    // InternalPerl.g:1114:3: ';'
                    {
                     before(grammarAccess.getPrototypeAccess().getSemicolonKeyword_1_4()); 
                    match(input,67,FOLLOW_2); 
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
    // InternalPerl.g:1123:1: rule__Token__Alternatives : ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ruleQuoteToken ) | ( ruleRegexToken ) | ( ( rule__Token__Group_9__0 ) ) | ( ( rule__Token__Group_10__0 ) ) );
    public final void rule__Token__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1127:1: ( ( ( rule__Token__Group_0__0 ) ) | ( ( rule__Token__Group_1__0 ) ) | ( ( rule__Token__Group_2__0 ) ) | ( ( rule__Token__Group_3__0 ) ) | ( ruleQuoteLikeToken ) | ( ( rule__Token__Group_5__0 ) ) | ( ( rule__Token__Group_6__0 ) ) | ( ruleQuoteToken ) | ( ruleRegexToken ) | ( ( rule__Token__Group_9__0 ) ) | ( ( rule__Token__Group_10__0 ) ) )
            int alt12=11;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_POD) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_NUMBER) ) {
                alt12=2;
            }
            else if ( (LA12_0==44||LA12_0==50||LA12_0==57||(LA12_0>=72 && LA12_0<=290)) ) {
                alt12=3;
            }
            else if ( (LA12_0==RULE_SYMBOL) ) {
                alt12=4;
            }
            else if ( (LA12_0==RULE_WORDS_QUOTE_LIKE||(LA12_0>=RULE_BACKTICK_STRING && LA12_0<=RULE_READLINE_QUOTE)) ) {
                alt12=5;
            }
            else if ( ((LA12_0>=352 && LA12_0<=378)) ) {
                alt12=6;
            }
            else if ( (LA12_0==69||LA12_0==71||(LA12_0>=291 && LA12_0<=351)||LA12_0==385) ) {
                alt12=7;
            }
            else if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_LITERAL)) ) {
                alt12=8;
            }
            else if ( ((LA12_0>=RULE_REGEX_SUBSTITUTE && LA12_0<=RULE_REGEX_MATCH)) ) {
                alt12=9;
            }
            else if ( (LA12_0==RULE_DATA) ) {
                alt12=10;
            }
            else if ( (LA12_0==RULE_END) ) {
                alt12=11;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalPerl.g:1128:2: ( ( rule__Token__Group_0__0 ) )
                    {
                    // InternalPerl.g:1128:2: ( ( rule__Token__Group_0__0 ) )
                    // InternalPerl.g:1129:3: ( rule__Token__Group_0__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_0()); 
                    // InternalPerl.g:1130:3: ( rule__Token__Group_0__0 )
                    // InternalPerl.g:1130:4: rule__Token__Group_0__0
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
                    // InternalPerl.g:1134:2: ( ( rule__Token__Group_1__0 ) )
                    {
                    // InternalPerl.g:1134:2: ( ( rule__Token__Group_1__0 ) )
                    // InternalPerl.g:1135:3: ( rule__Token__Group_1__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_1()); 
                    // InternalPerl.g:1136:3: ( rule__Token__Group_1__0 )
                    // InternalPerl.g:1136:4: rule__Token__Group_1__0
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
                    // InternalPerl.g:1140:2: ( ( rule__Token__Group_2__0 ) )
                    {
                    // InternalPerl.g:1140:2: ( ( rule__Token__Group_2__0 ) )
                    // InternalPerl.g:1141:3: ( rule__Token__Group_2__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_2()); 
                    // InternalPerl.g:1142:3: ( rule__Token__Group_2__0 )
                    // InternalPerl.g:1142:4: rule__Token__Group_2__0
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
                    // InternalPerl.g:1146:2: ( ( rule__Token__Group_3__0 ) )
                    {
                    // InternalPerl.g:1146:2: ( ( rule__Token__Group_3__0 ) )
                    // InternalPerl.g:1147:3: ( rule__Token__Group_3__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_3()); 
                    // InternalPerl.g:1148:3: ( rule__Token__Group_3__0 )
                    // InternalPerl.g:1148:4: rule__Token__Group_3__0
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
                    // InternalPerl.g:1152:2: ( ruleQuoteLikeToken )
                    {
                    // InternalPerl.g:1152:2: ( ruleQuoteLikeToken )
                    // InternalPerl.g:1153:3: ruleQuoteLikeToken
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
                    // InternalPerl.g:1158:2: ( ( rule__Token__Group_5__0 ) )
                    {
                    // InternalPerl.g:1158:2: ( ( rule__Token__Group_5__0 ) )
                    // InternalPerl.g:1159:3: ( rule__Token__Group_5__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_5()); 
                    // InternalPerl.g:1160:3: ( rule__Token__Group_5__0 )
                    // InternalPerl.g:1160:4: rule__Token__Group_5__0
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
                    // InternalPerl.g:1164:2: ( ( rule__Token__Group_6__0 ) )
                    {
                    // InternalPerl.g:1164:2: ( ( rule__Token__Group_6__0 ) )
                    // InternalPerl.g:1165:3: ( rule__Token__Group_6__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_6()); 
                    // InternalPerl.g:1166:3: ( rule__Token__Group_6__0 )
                    // InternalPerl.g:1166:4: rule__Token__Group_6__0
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
                    // InternalPerl.g:1170:2: ( ruleQuoteToken )
                    {
                    // InternalPerl.g:1170:2: ( ruleQuoteToken )
                    // InternalPerl.g:1171:3: ruleQuoteToken
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
                    // InternalPerl.g:1176:2: ( ruleRegexToken )
                    {
                    // InternalPerl.g:1176:2: ( ruleRegexToken )
                    // InternalPerl.g:1177:3: ruleRegexToken
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
                    // InternalPerl.g:1182:2: ( ( rule__Token__Group_9__0 ) )
                    {
                    // InternalPerl.g:1182:2: ( ( rule__Token__Group_9__0 ) )
                    // InternalPerl.g:1183:3: ( rule__Token__Group_9__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_9()); 
                    // InternalPerl.g:1184:3: ( rule__Token__Group_9__0 )
                    // InternalPerl.g:1184:4: rule__Token__Group_9__0
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
                    // InternalPerl.g:1188:2: ( ( rule__Token__Group_10__0 ) )
                    {
                    // InternalPerl.g:1188:2: ( ( rule__Token__Group_10__0 ) )
                    // InternalPerl.g:1189:3: ( rule__Token__Group_10__0 )
                    {
                     before(grammarAccess.getTokenAccess().getGroup_10()); 
                    // InternalPerl.g:1190:3: ( rule__Token__Group_10__0 )
                    // InternalPerl.g:1190:4: rule__Token__Group_10__0
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
    // InternalPerl.g:1198:1: rule__QuoteToken__ContentAlternatives_1_0 : ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) );
    public final void rule__QuoteToken__ContentAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1202:1: ( ( RULE_STRING ) | ( RULE_INTERPOLATE ) | ( RULE_LITERAL ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt13=1;
                }
                break;
            case RULE_INTERPOLATE:
                {
                alt13=2;
                }
                break;
            case RULE_LITERAL:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalPerl.g:1203:2: ( RULE_STRING )
                    {
                    // InternalPerl.g:1203:2: ( RULE_STRING )
                    // InternalPerl.g:1204:3: RULE_STRING
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1209:2: ( RULE_INTERPOLATE )
                    {
                    // InternalPerl.g:1209:2: ( RULE_INTERPOLATE )
                    // InternalPerl.g:1210:3: RULE_INTERPOLATE
                    {
                     before(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 
                    match(input,RULE_INTERPOLATE,FOLLOW_2); 
                     after(grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1215:2: ( RULE_LITERAL )
                    {
                    // InternalPerl.g:1215:2: ( RULE_LITERAL )
                    // InternalPerl.g:1216:3: RULE_LITERAL
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
    // InternalPerl.g:1225:1: rule__RegexToken__ContentAlternatives_1_0 : ( ( RULE_REGEX_SUBSTITUTE ) | ( RULE_REGEX_TRANSLITERATE ) | ( RULE_REGEX_MATCH ) );
    public final void rule__RegexToken__ContentAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1229:1: ( ( RULE_REGEX_SUBSTITUTE ) | ( RULE_REGEX_TRANSLITERATE ) | ( RULE_REGEX_MATCH ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case RULE_REGEX_SUBSTITUTE:
                {
                alt14=1;
                }
                break;
            case RULE_REGEX_TRANSLITERATE:
                {
                alt14=2;
                }
                break;
            case RULE_REGEX_MATCH:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalPerl.g:1230:2: ( RULE_REGEX_SUBSTITUTE )
                    {
                    // InternalPerl.g:1230:2: ( RULE_REGEX_SUBSTITUTE )
                    // InternalPerl.g:1231:3: RULE_REGEX_SUBSTITUTE
                    {
                     before(grammarAccess.getRegexTokenAccess().getContentREGEX_SUBSTITUTETerminalRuleCall_1_0_0()); 
                    match(input,RULE_REGEX_SUBSTITUTE,FOLLOW_2); 
                     after(grammarAccess.getRegexTokenAccess().getContentREGEX_SUBSTITUTETerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1236:2: ( RULE_REGEX_TRANSLITERATE )
                    {
                    // InternalPerl.g:1236:2: ( RULE_REGEX_TRANSLITERATE )
                    // InternalPerl.g:1237:3: RULE_REGEX_TRANSLITERATE
                    {
                     before(grammarAccess.getRegexTokenAccess().getContentREGEX_TRANSLITERATETerminalRuleCall_1_0_1()); 
                    match(input,RULE_REGEX_TRANSLITERATE,FOLLOW_2); 
                     after(grammarAccess.getRegexTokenAccess().getContentREGEX_TRANSLITERATETerminalRuleCall_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1242:2: ( RULE_REGEX_MATCH )
                    {
                    // InternalPerl.g:1242:2: ( RULE_REGEX_MATCH )
                    // InternalPerl.g:1243:3: RULE_REGEX_MATCH
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
    // InternalPerl.g:1252:1: rule__QuoteLikeToken__Alternatives : ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) );
    public final void rule__QuoteLikeToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1256:1: ( ( ( rule__QuoteLikeToken__Group_0__0 ) ) | ( ( rule__QuoteLikeToken__Group_1__0 ) ) | ( ( rule__QuoteLikeToken__Group_2__0 ) ) | ( ( rule__QuoteLikeToken__Group_3__0 ) ) | ( ( rule__QuoteLikeToken__Group_4__0 ) ) )
            int alt15=5;
            switch ( input.LA(1) ) {
            case RULE_BACKTICK_STRING:
                {
                alt15=1;
                }
                break;
            case RULE_WORDS_QUOTE_LIKE:
                {
                alt15=2;
                }
                break;
            case RULE_COMMAND_QUOTE_LIKE:
                {
                alt15=3;
                }
                break;
            case RULE_REGEX_QUOTE:
                {
                alt15=4;
                }
                break;
            case RULE_READLINE_QUOTE:
                {
                alt15=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalPerl.g:1257:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    {
                    // InternalPerl.g:1257:2: ( ( rule__QuoteLikeToken__Group_0__0 ) )
                    // InternalPerl.g:1258:3: ( rule__QuoteLikeToken__Group_0__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_0()); 
                    // InternalPerl.g:1259:3: ( rule__QuoteLikeToken__Group_0__0 )
                    // InternalPerl.g:1259:4: rule__QuoteLikeToken__Group_0__0
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
                    // InternalPerl.g:1263:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    {
                    // InternalPerl.g:1263:2: ( ( rule__QuoteLikeToken__Group_1__0 ) )
                    // InternalPerl.g:1264:3: ( rule__QuoteLikeToken__Group_1__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_1()); 
                    // InternalPerl.g:1265:3: ( rule__QuoteLikeToken__Group_1__0 )
                    // InternalPerl.g:1265:4: rule__QuoteLikeToken__Group_1__0
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
                    // InternalPerl.g:1269:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    {
                    // InternalPerl.g:1269:2: ( ( rule__QuoteLikeToken__Group_2__0 ) )
                    // InternalPerl.g:1270:3: ( rule__QuoteLikeToken__Group_2__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_2()); 
                    // InternalPerl.g:1271:3: ( rule__QuoteLikeToken__Group_2__0 )
                    // InternalPerl.g:1271:4: rule__QuoteLikeToken__Group_2__0
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
                    // InternalPerl.g:1275:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    {
                    // InternalPerl.g:1275:2: ( ( rule__QuoteLikeToken__Group_3__0 ) )
                    // InternalPerl.g:1276:3: ( rule__QuoteLikeToken__Group_3__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_3()); 
                    // InternalPerl.g:1277:3: ( rule__QuoteLikeToken__Group_3__0 )
                    // InternalPerl.g:1277:4: rule__QuoteLikeToken__Group_3__0
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
                    // InternalPerl.g:1281:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    {
                    // InternalPerl.g:1281:2: ( ( rule__QuoteLikeToken__Group_4__0 ) )
                    // InternalPerl.g:1282:3: ( rule__QuoteLikeToken__Group_4__0 )
                    {
                     before(grammarAccess.getQuoteLikeTokenAccess().getGroup_4()); 
                    // InternalPerl.g:1283:3: ( rule__QuoteLikeToken__Group_4__0 )
                    // InternalPerl.g:1283:4: rule__QuoteLikeToken__Group_4__0
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
    // InternalPerl.g:1291:1: rule__Keyword__Alternatives : ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) );
    public final void rule__Keyword__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1295:1: ( ( 'abs' ) | ( 'accept' ) | ( 'alarm' ) | ( 'atan2' ) | ( 'bind' ) | ( 'binmode' ) | ( 'bless' ) | ( 'break' ) | ( 'caller' ) | ( 'chdir' ) | ( 'chmod' ) | ( 'chomp' ) | ( 'chop' ) | ( 'chown' ) | ( 'chr' ) | ( 'chroot' ) | ( 'close' ) | ( 'closedir' ) | ( 'connect' ) | ( 'continue' ) | ( 'cos' ) | ( 'crypt' ) | ( 'dbmclose' ) | ( 'dbmopen' ) | ( 'default' ) | ( 'defined' ) | ( 'delete' ) | ( 'die' ) | ( 'do' ) | ( 'dump' ) | ( 'each' ) | ( 'else' ) | ( 'elsif' ) | ( 'endgrent' ) | ( 'endhostent' ) | ( 'endnetent' ) | ( 'endprotoent' ) | ( 'endpwent' ) | ( 'endservent' ) | ( 'eof' ) | ( 'eval' ) | ( 'evalbytes' ) | ( 'exec' ) | ( 'exists' ) | ( 'exit' ) | ( 'exp' ) | ( 'fc' ) | ( 'fcntl' ) | ( 'fileno' ) | ( 'flock' ) | ( 'for' ) | ( 'foreach' ) | ( 'fork' ) | ( 'format' ) | ( 'formline' ) | ( 'getc' ) | ( 'getgrent' ) | ( 'getgrgid' ) | ( 'getgrnam' ) | ( 'gethostbyaddr' ) | ( 'gethostbyname' ) | ( 'gethostent' ) | ( 'getlogin' ) | ( 'getnetbyaddr' ) | ( 'getnetbyname' ) | ( 'getnetent' ) | ( 'getpeername' ) | ( 'getpgrp' ) | ( 'getppid' ) | ( 'getpriority' ) | ( 'getprotobyname' ) | ( 'getprotobynumber' ) | ( 'getprotoent' ) | ( 'getpwent' ) | ( 'getpwnam' ) | ( 'getpwuid' ) | ( 'getservbyname' ) | ( 'getservbyport' ) | ( 'getservent' ) | ( 'getsockname' ) | ( 'getsockopt' ) | ( 'given' ) | ( 'glob' ) | ( 'gmtime' ) | ( 'goto' ) | ( 'grep' ) | ( 'hex' ) | ( 'if' ) | ( 'index' ) | ( 'int' ) | ( 'ioctl' ) | ( 'join' ) | ( 'keys' ) | ( 'kill' ) | ( 'last' ) | ( 'lc' ) | ( 'lcfirst' ) | ( 'length' ) | ( 'link' ) | ( 'listen' ) | ( 'local' ) | ( 'localtime' ) | ( 'lock' ) | ( 'log' ) | ( 'lstat' ) | ( 'map' ) | ( 'mkdir' ) | ( 'msgctl' ) | ( 'msgget' ) | ( 'msgrcv' ) | ( 'msgsnd' ) | ( 'my' ) | ( 'next' ) | ( 'no' ) | ( 'oct' ) | ( 'open' ) | ( 'opendir' ) | ( 'ord' ) | ( 'our' ) | ( 'pack' ) | ( 'package' ) | ( 'pipe' ) | ( 'pop' ) | ( 'pos' ) | ( 'print' ) | ( 'printf' ) | ( 'prototype' ) | ( 'push' ) | ( 'quotemeta' ) | ( 'rand' ) | ( 'read' ) | ( 'readdir' ) | ( 'readline' ) | ( 'readlink' ) | ( 'readpipe' ) | ( 'recv' ) | ( 'redo' ) | ( 'ref' ) | ( 'rename' ) | ( 'require' ) | ( 'reset' ) | ( 'return' ) | ( 'reverse' ) | ( 'rewinddir' ) | ( 'rindex' ) | ( 'rmdir' ) | ( 'say' ) | ( 'scalar' ) | ( 'seek' ) | ( 'seekdir' ) | ( 'select' ) | ( 'semctl' ) | ( 'semget' ) | ( 'semop' ) | ( 'send' ) | ( 'setgrent' ) | ( 'sethostent' ) | ( 'setnetent' ) | ( 'setpgrp' ) | ( 'setpriority' ) | ( 'setprotoent' ) | ( 'setpwent' ) | ( 'setservent' ) | ( 'setsockopt' ) | ( 'shift' ) | ( 'shmctl' ) | ( 'shmget' ) | ( 'shmread' ) | ( 'shmwrite' ) | ( 'shutdown' ) | ( 'sin' ) | ( 'sleep' ) | ( 'socket' ) | ( 'socketpair' ) | ( 'sort' ) | ( 'splice' ) | ( 'split' ) | ( 'sprintf' ) | ( 'sqrt' ) | ( 'srand' ) | ( 'stat' ) | ( 'state' ) | ( 'study' ) | ( 'sub' ) | ( 'substr' ) | ( 'symlink' ) | ( 'syscall' ) | ( 'sysopen' ) | ( 'sysread' ) | ( 'sysseek' ) | ( 'system' ) | ( 'syswrite' ) | ( 'tell' ) | ( 'telldir' ) | ( 'tie' ) | ( 'tied' ) | ( 'time' ) | ( 'times' ) | ( 'tr' ) | ( 'truncate' ) | ( 'uc' ) | ( 'ucfirst' ) | ( 'umask' ) | ( 'undef' ) | ( 'unless' ) | ( 'unlink' ) | ( 'unpack' ) | ( 'unshift' ) | ( 'untie' ) | ( 'until' ) | ( 'use' ) | ( 'utime' ) | ( 'values' ) | ( 'vec' ) | ( 'wait' ) | ( 'waitpid' ) | ( 'wantarray' ) | ( 'warn' ) | ( 'when' ) | ( 'while' ) | ( 'write' ) | ( 'y' ) )
            int alt16=222;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt16=1;
                }
                break;
            case 73:
                {
                alt16=2;
                }
                break;
            case 74:
                {
                alt16=3;
                }
                break;
            case 75:
                {
                alt16=4;
                }
                break;
            case 76:
                {
                alt16=5;
                }
                break;
            case 77:
                {
                alt16=6;
                }
                break;
            case 78:
                {
                alt16=7;
                }
                break;
            case 79:
                {
                alt16=8;
                }
                break;
            case 80:
                {
                alt16=9;
                }
                break;
            case 81:
                {
                alt16=10;
                }
                break;
            case 82:
                {
                alt16=11;
                }
                break;
            case 83:
                {
                alt16=12;
                }
                break;
            case 84:
                {
                alt16=13;
                }
                break;
            case 85:
                {
                alt16=14;
                }
                break;
            case 86:
                {
                alt16=15;
                }
                break;
            case 87:
                {
                alt16=16;
                }
                break;
            case 88:
                {
                alt16=17;
                }
                break;
            case 89:
                {
                alt16=18;
                }
                break;
            case 90:
                {
                alt16=19;
                }
                break;
            case 91:
                {
                alt16=20;
                }
                break;
            case 92:
                {
                alt16=21;
                }
                break;
            case 93:
                {
                alt16=22;
                }
                break;
            case 94:
                {
                alt16=23;
                }
                break;
            case 95:
                {
                alt16=24;
                }
                break;
            case 96:
                {
                alt16=25;
                }
                break;
            case 97:
                {
                alt16=26;
                }
                break;
            case 98:
                {
                alt16=27;
                }
                break;
            case 99:
                {
                alt16=28;
                }
                break;
            case 100:
                {
                alt16=29;
                }
                break;
            case 101:
                {
                alt16=30;
                }
                break;
            case 102:
                {
                alt16=31;
                }
                break;
            case 103:
                {
                alt16=32;
                }
                break;
            case 104:
                {
                alt16=33;
                }
                break;
            case 105:
                {
                alt16=34;
                }
                break;
            case 106:
                {
                alt16=35;
                }
                break;
            case 107:
                {
                alt16=36;
                }
                break;
            case 108:
                {
                alt16=37;
                }
                break;
            case 109:
                {
                alt16=38;
                }
                break;
            case 110:
                {
                alt16=39;
                }
                break;
            case 111:
                {
                alt16=40;
                }
                break;
            case 112:
                {
                alt16=41;
                }
                break;
            case 113:
                {
                alt16=42;
                }
                break;
            case 114:
                {
                alt16=43;
                }
                break;
            case 115:
                {
                alt16=44;
                }
                break;
            case 116:
                {
                alt16=45;
                }
                break;
            case 117:
                {
                alt16=46;
                }
                break;
            case 118:
                {
                alt16=47;
                }
                break;
            case 119:
                {
                alt16=48;
                }
                break;
            case 120:
                {
                alt16=49;
                }
                break;
            case 121:
                {
                alt16=50;
                }
                break;
            case 122:
                {
                alt16=51;
                }
                break;
            case 123:
                {
                alt16=52;
                }
                break;
            case 124:
                {
                alt16=53;
                }
                break;
            case 125:
                {
                alt16=54;
                }
                break;
            case 126:
                {
                alt16=55;
                }
                break;
            case 127:
                {
                alt16=56;
                }
                break;
            case 128:
                {
                alt16=57;
                }
                break;
            case 129:
                {
                alt16=58;
                }
                break;
            case 130:
                {
                alt16=59;
                }
                break;
            case 131:
                {
                alt16=60;
                }
                break;
            case 132:
                {
                alt16=61;
                }
                break;
            case 133:
                {
                alt16=62;
                }
                break;
            case 134:
                {
                alt16=63;
                }
                break;
            case 135:
                {
                alt16=64;
                }
                break;
            case 136:
                {
                alt16=65;
                }
                break;
            case 137:
                {
                alt16=66;
                }
                break;
            case 138:
                {
                alt16=67;
                }
                break;
            case 139:
                {
                alt16=68;
                }
                break;
            case 140:
                {
                alt16=69;
                }
                break;
            case 141:
                {
                alt16=70;
                }
                break;
            case 142:
                {
                alt16=71;
                }
                break;
            case 143:
                {
                alt16=72;
                }
                break;
            case 144:
                {
                alt16=73;
                }
                break;
            case 145:
                {
                alt16=74;
                }
                break;
            case 146:
                {
                alt16=75;
                }
                break;
            case 147:
                {
                alt16=76;
                }
                break;
            case 148:
                {
                alt16=77;
                }
                break;
            case 149:
                {
                alt16=78;
                }
                break;
            case 150:
                {
                alt16=79;
                }
                break;
            case 151:
                {
                alt16=80;
                }
                break;
            case 152:
                {
                alt16=81;
                }
                break;
            case 153:
                {
                alt16=82;
                }
                break;
            case 154:
                {
                alt16=83;
                }
                break;
            case 155:
                {
                alt16=84;
                }
                break;
            case 156:
                {
                alt16=85;
                }
                break;
            case 157:
                {
                alt16=86;
                }
                break;
            case 158:
                {
                alt16=87;
                }
                break;
            case 44:
                {
                alt16=88;
                }
                break;
            case 159:
                {
                alt16=89;
                }
                break;
            case 160:
                {
                alt16=90;
                }
                break;
            case 161:
                {
                alt16=91;
                }
                break;
            case 162:
                {
                alt16=92;
                }
                break;
            case 163:
                {
                alt16=93;
                }
                break;
            case 164:
                {
                alt16=94;
                }
                break;
            case 165:
                {
                alt16=95;
                }
                break;
            case 166:
                {
                alt16=96;
                }
                break;
            case 167:
                {
                alt16=97;
                }
                break;
            case 168:
                {
                alt16=98;
                }
                break;
            case 169:
                {
                alt16=99;
                }
                break;
            case 170:
                {
                alt16=100;
                }
                break;
            case 171:
                {
                alt16=101;
                }
                break;
            case 172:
                {
                alt16=102;
                }
                break;
            case 173:
                {
                alt16=103;
                }
                break;
            case 174:
                {
                alt16=104;
                }
                break;
            case 175:
                {
                alt16=105;
                }
                break;
            case 176:
                {
                alt16=106;
                }
                break;
            case 177:
                {
                alt16=107;
                }
                break;
            case 178:
                {
                alt16=108;
                }
                break;
            case 179:
                {
                alt16=109;
                }
                break;
            case 180:
                {
                alt16=110;
                }
                break;
            case 181:
                {
                alt16=111;
                }
                break;
            case 182:
                {
                alt16=112;
                }
                break;
            case 183:
                {
                alt16=113;
                }
                break;
            case 184:
                {
                alt16=114;
                }
                break;
            case 185:
                {
                alt16=115;
                }
                break;
            case 50:
                {
                alt16=116;
                }
                break;
            case 186:
                {
                alt16=117;
                }
                break;
            case 187:
                {
                alt16=118;
                }
                break;
            case 188:
                {
                alt16=119;
                }
                break;
            case 189:
                {
                alt16=120;
                }
                break;
            case 190:
                {
                alt16=121;
                }
                break;
            case 191:
                {
                alt16=122;
                }
                break;
            case 192:
                {
                alt16=123;
                }
                break;
            case 193:
                {
                alt16=124;
                }
                break;
            case 194:
                {
                alt16=125;
                }
                break;
            case 195:
                {
                alt16=126;
                }
                break;
            case 196:
                {
                alt16=127;
                }
                break;
            case 197:
                {
                alt16=128;
                }
                break;
            case 198:
                {
                alt16=129;
                }
                break;
            case 199:
                {
                alt16=130;
                }
                break;
            case 200:
                {
                alt16=131;
                }
                break;
            case 201:
                {
                alt16=132;
                }
                break;
            case 202:
                {
                alt16=133;
                }
                break;
            case 203:
                {
                alt16=134;
                }
                break;
            case 204:
                {
                alt16=135;
                }
                break;
            case 205:
                {
                alt16=136;
                }
                break;
            case 206:
                {
                alt16=137;
                }
                break;
            case 207:
                {
                alt16=138;
                }
                break;
            case 208:
                {
                alt16=139;
                }
                break;
            case 209:
                {
                alt16=140;
                }
                break;
            case 210:
                {
                alt16=141;
                }
                break;
            case 211:
                {
                alt16=142;
                }
                break;
            case 212:
                {
                alt16=143;
                }
                break;
            case 213:
                {
                alt16=144;
                }
                break;
            case 214:
                {
                alt16=145;
                }
                break;
            case 215:
                {
                alt16=146;
                }
                break;
            case 216:
                {
                alt16=147;
                }
                break;
            case 217:
                {
                alt16=148;
                }
                break;
            case 218:
                {
                alt16=149;
                }
                break;
            case 219:
                {
                alt16=150;
                }
                break;
            case 220:
                {
                alt16=151;
                }
                break;
            case 221:
                {
                alt16=152;
                }
                break;
            case 222:
                {
                alt16=153;
                }
                break;
            case 223:
                {
                alt16=154;
                }
                break;
            case 224:
                {
                alt16=155;
                }
                break;
            case 225:
                {
                alt16=156;
                }
                break;
            case 226:
                {
                alt16=157;
                }
                break;
            case 227:
                {
                alt16=158;
                }
                break;
            case 228:
                {
                alt16=159;
                }
                break;
            case 229:
                {
                alt16=160;
                }
                break;
            case 230:
                {
                alt16=161;
                }
                break;
            case 231:
                {
                alt16=162;
                }
                break;
            case 232:
                {
                alt16=163;
                }
                break;
            case 233:
                {
                alt16=164;
                }
                break;
            case 234:
                {
                alt16=165;
                }
                break;
            case 235:
                {
                alt16=166;
                }
                break;
            case 236:
                {
                alt16=167;
                }
                break;
            case 237:
                {
                alt16=168;
                }
                break;
            case 238:
                {
                alt16=169;
                }
                break;
            case 239:
                {
                alt16=170;
                }
                break;
            case 240:
                {
                alt16=171;
                }
                break;
            case 241:
                {
                alt16=172;
                }
                break;
            case 242:
                {
                alt16=173;
                }
                break;
            case 243:
                {
                alt16=174;
                }
                break;
            case 57:
                {
                alt16=175;
                }
                break;
            case 244:
                {
                alt16=176;
                }
                break;
            case 245:
                {
                alt16=177;
                }
                break;
            case 246:
                {
                alt16=178;
                }
                break;
            case 247:
                {
                alt16=179;
                }
                break;
            case 248:
                {
                alt16=180;
                }
                break;
            case 249:
                {
                alt16=181;
                }
                break;
            case 250:
                {
                alt16=182;
                }
                break;
            case 251:
                {
                alt16=183;
                }
                break;
            case 252:
                {
                alt16=184;
                }
                break;
            case 253:
                {
                alt16=185;
                }
                break;
            case 254:
                {
                alt16=186;
                }
                break;
            case 255:
                {
                alt16=187;
                }
                break;
            case 256:
                {
                alt16=188;
                }
                break;
            case 257:
                {
                alt16=189;
                }
                break;
            case 258:
                {
                alt16=190;
                }
                break;
            case 259:
                {
                alt16=191;
                }
                break;
            case 260:
                {
                alt16=192;
                }
                break;
            case 261:
                {
                alt16=193;
                }
                break;
            case 262:
                {
                alt16=194;
                }
                break;
            case 263:
                {
                alt16=195;
                }
                break;
            case 264:
                {
                alt16=196;
                }
                break;
            case 265:
                {
                alt16=197;
                }
                break;
            case 266:
                {
                alt16=198;
                }
                break;
            case 267:
                {
                alt16=199;
                }
                break;
            case 268:
                {
                alt16=200;
                }
                break;
            case 269:
                {
                alt16=201;
                }
                break;
            case 270:
                {
                alt16=202;
                }
                break;
            case 271:
                {
                alt16=203;
                }
                break;
            case 272:
                {
                alt16=204;
                }
                break;
            case 273:
                {
                alt16=205;
                }
                break;
            case 274:
                {
                alt16=206;
                }
                break;
            case 275:
                {
                alt16=207;
                }
                break;
            case 276:
                {
                alt16=208;
                }
                break;
            case 277:
                {
                alt16=209;
                }
                break;
            case 278:
                {
                alt16=210;
                }
                break;
            case 279:
                {
                alt16=211;
                }
                break;
            case 280:
                {
                alt16=212;
                }
                break;
            case 281:
                {
                alt16=213;
                }
                break;
            case 282:
                {
                alt16=214;
                }
                break;
            case 283:
                {
                alt16=215;
                }
                break;
            case 284:
                {
                alt16=216;
                }
                break;
            case 285:
                {
                alt16=217;
                }
                break;
            case 286:
                {
                alt16=218;
                }
                break;
            case 287:
                {
                alt16=219;
                }
                break;
            case 288:
                {
                alt16=220;
                }
                break;
            case 289:
                {
                alt16=221;
                }
                break;
            case 290:
                {
                alt16=222;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalPerl.g:1296:2: ( 'abs' )
                    {
                    // InternalPerl.g:1296:2: ( 'abs' )
                    // InternalPerl.g:1297:3: 'abs'
                    {
                     before(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAbsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1302:2: ( 'accept' )
                    {
                    // InternalPerl.g:1302:2: ( 'accept' )
                    // InternalPerl.g:1303:3: 'accept'
                    {
                     before(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAcceptKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1308:2: ( 'alarm' )
                    {
                    // InternalPerl.g:1308:2: ( 'alarm' )
                    // InternalPerl.g:1309:3: 'alarm'
                    {
                     before(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAlarmKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1314:2: ( 'atan2' )
                    {
                    // InternalPerl.g:1314:2: ( 'atan2' )
                    // InternalPerl.g:1315:3: 'atan2'
                    {
                     before(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 
                    match(input,75,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getAtan2Keyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:1320:2: ( 'bind' )
                    {
                    // InternalPerl.g:1320:2: ( 'bind' )
                    // InternalPerl.g:1321:3: 'bind'
                    {
                     before(grammarAccess.getKeywordAccess().getBindKeyword_4()); 
                    match(input,76,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBindKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:1326:2: ( 'binmode' )
                    {
                    // InternalPerl.g:1326:2: ( 'binmode' )
                    // InternalPerl.g:1327:3: 'binmode'
                    {
                     before(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 
                    match(input,77,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBinmodeKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:1332:2: ( 'bless' )
                    {
                    // InternalPerl.g:1332:2: ( 'bless' )
                    // InternalPerl.g:1333:3: 'bless'
                    {
                     before(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 
                    match(input,78,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBlessKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:1338:2: ( 'break' )
                    {
                    // InternalPerl.g:1338:2: ( 'break' )
                    // InternalPerl.g:1339:3: 'break'
                    {
                     before(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 
                    match(input,79,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getBreakKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:1344:2: ( 'caller' )
                    {
                    // InternalPerl.g:1344:2: ( 'caller' )
                    // InternalPerl.g:1345:3: 'caller'
                    {
                     before(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 
                    match(input,80,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCallerKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:1350:2: ( 'chdir' )
                    {
                    // InternalPerl.g:1350:2: ( 'chdir' )
                    // InternalPerl.g:1351:3: 'chdir'
                    {
                     before(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 
                    match(input,81,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChdirKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:1356:2: ( 'chmod' )
                    {
                    // InternalPerl.g:1356:2: ( 'chmod' )
                    // InternalPerl.g:1357:3: 'chmod'
                    {
                     before(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 
                    match(input,82,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChmodKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:1362:2: ( 'chomp' )
                    {
                    // InternalPerl.g:1362:2: ( 'chomp' )
                    // InternalPerl.g:1363:3: 'chomp'
                    {
                     before(grammarAccess.getKeywordAccess().getChompKeyword_11()); 
                    match(input,83,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChompKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:1368:2: ( 'chop' )
                    {
                    // InternalPerl.g:1368:2: ( 'chop' )
                    // InternalPerl.g:1369:3: 'chop'
                    {
                     before(grammarAccess.getKeywordAccess().getChopKeyword_12()); 
                    match(input,84,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChopKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:1374:2: ( 'chown' )
                    {
                    // InternalPerl.g:1374:2: ( 'chown' )
                    // InternalPerl.g:1375:3: 'chown'
                    {
                     before(grammarAccess.getKeywordAccess().getChownKeyword_13()); 
                    match(input,85,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChownKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:1380:2: ( 'chr' )
                    {
                    // InternalPerl.g:1380:2: ( 'chr' )
                    // InternalPerl.g:1381:3: 'chr'
                    {
                     before(grammarAccess.getKeywordAccess().getChrKeyword_14()); 
                    match(input,86,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:1386:2: ( 'chroot' )
                    {
                    // InternalPerl.g:1386:2: ( 'chroot' )
                    // InternalPerl.g:1387:3: 'chroot'
                    {
                     before(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 
                    match(input,87,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getChrootKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:1392:2: ( 'close' )
                    {
                    // InternalPerl.g:1392:2: ( 'close' )
                    // InternalPerl.g:1393:3: 'close'
                    {
                     before(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 
                    match(input,88,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCloseKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:1398:2: ( 'closedir' )
                    {
                    // InternalPerl.g:1398:2: ( 'closedir' )
                    // InternalPerl.g:1399:3: 'closedir'
                    {
                     before(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 
                    match(input,89,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getClosedirKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:1404:2: ( 'connect' )
                    {
                    // InternalPerl.g:1404:2: ( 'connect' )
                    // InternalPerl.g:1405:3: 'connect'
                    {
                     before(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 
                    match(input,90,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getConnectKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:1410:2: ( 'continue' )
                    {
                    // InternalPerl.g:1410:2: ( 'continue' )
                    // InternalPerl.g:1411:3: 'continue'
                    {
                     before(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 
                    match(input,91,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getContinueKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:1416:2: ( 'cos' )
                    {
                    // InternalPerl.g:1416:2: ( 'cos' )
                    // InternalPerl.g:1417:3: 'cos'
                    {
                     before(grammarAccess.getKeywordAccess().getCosKeyword_20()); 
                    match(input,92,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCosKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:1422:2: ( 'crypt' )
                    {
                    // InternalPerl.g:1422:2: ( 'crypt' )
                    // InternalPerl.g:1423:3: 'crypt'
                    {
                     before(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 
                    match(input,93,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getCryptKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:1428:2: ( 'dbmclose' )
                    {
                    // InternalPerl.g:1428:2: ( 'dbmclose' )
                    // InternalPerl.g:1429:3: 'dbmclose'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 
                    match(input,94,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmcloseKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:1434:2: ( 'dbmopen' )
                    {
                    // InternalPerl.g:1434:2: ( 'dbmopen' )
                    // InternalPerl.g:1435:3: 'dbmopen'
                    {
                     before(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 
                    match(input,95,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDbmopenKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:1440:2: ( 'default' )
                    {
                    // InternalPerl.g:1440:2: ( 'default' )
                    // InternalPerl.g:1441:3: 'default'
                    {
                     before(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 
                    match(input,96,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefaultKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:1446:2: ( 'defined' )
                    {
                    // InternalPerl.g:1446:2: ( 'defined' )
                    // InternalPerl.g:1447:3: 'defined'
                    {
                     before(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 
                    match(input,97,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDefinedKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:1452:2: ( 'delete' )
                    {
                    // InternalPerl.g:1452:2: ( 'delete' )
                    // InternalPerl.g:1453:3: 'delete'
                    {
                     before(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 
                    match(input,98,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDeleteKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:1458:2: ( 'die' )
                    {
                    // InternalPerl.g:1458:2: ( 'die' )
                    // InternalPerl.g:1459:3: 'die'
                    {
                     before(grammarAccess.getKeywordAccess().getDieKeyword_27()); 
                    match(input,99,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDieKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:1464:2: ( 'do' )
                    {
                    // InternalPerl.g:1464:2: ( 'do' )
                    // InternalPerl.g:1465:3: 'do'
                    {
                     before(grammarAccess.getKeywordAccess().getDoKeyword_28()); 
                    match(input,100,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDoKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:1470:2: ( 'dump' )
                    {
                    // InternalPerl.g:1470:2: ( 'dump' )
                    // InternalPerl.g:1471:3: 'dump'
                    {
                     before(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 
                    match(input,101,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getDumpKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:1476:2: ( 'each' )
                    {
                    // InternalPerl.g:1476:2: ( 'each' )
                    // InternalPerl.g:1477:3: 'each'
                    {
                     before(grammarAccess.getKeywordAccess().getEachKeyword_30()); 
                    match(input,102,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEachKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:1482:2: ( 'else' )
                    {
                    // InternalPerl.g:1482:2: ( 'else' )
                    // InternalPerl.g:1483:3: 'else'
                    {
                     before(grammarAccess.getKeywordAccess().getElseKeyword_31()); 
                    match(input,103,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElseKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:1488:2: ( 'elsif' )
                    {
                    // InternalPerl.g:1488:2: ( 'elsif' )
                    // InternalPerl.g:1489:3: 'elsif'
                    {
                     before(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 
                    match(input,104,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getElsifKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:1494:2: ( 'endgrent' )
                    {
                    // InternalPerl.g:1494:2: ( 'endgrent' )
                    // InternalPerl.g:1495:3: 'endgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 
                    match(input,105,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndgrentKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:1500:2: ( 'endhostent' )
                    {
                    // InternalPerl.g:1500:2: ( 'endhostent' )
                    // InternalPerl.g:1501:3: 'endhostent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 
                    match(input,106,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndhostentKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:1506:2: ( 'endnetent' )
                    {
                    // InternalPerl.g:1506:2: ( 'endnetent' )
                    // InternalPerl.g:1507:3: 'endnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 
                    match(input,107,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndnetentKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:1512:2: ( 'endprotoent' )
                    {
                    // InternalPerl.g:1512:2: ( 'endprotoent' )
                    // InternalPerl.g:1513:3: 'endprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 
                    match(input,108,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndprotoentKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:1518:2: ( 'endpwent' )
                    {
                    // InternalPerl.g:1518:2: ( 'endpwent' )
                    // InternalPerl.g:1519:3: 'endpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 
                    match(input,109,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndpwentKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:1524:2: ( 'endservent' )
                    {
                    // InternalPerl.g:1524:2: ( 'endservent' )
                    // InternalPerl.g:1525:3: 'endservent'
                    {
                     before(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 
                    match(input,110,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEndserventKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:1530:2: ( 'eof' )
                    {
                    // InternalPerl.g:1530:2: ( 'eof' )
                    // InternalPerl.g:1531:3: 'eof'
                    {
                     before(grammarAccess.getKeywordAccess().getEofKeyword_39()); 
                    match(input,111,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEofKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:1536:2: ( 'eval' )
                    {
                    // InternalPerl.g:1536:2: ( 'eval' )
                    // InternalPerl.g:1537:3: 'eval'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 
                    match(input,112,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:1542:2: ( 'evalbytes' )
                    {
                    // InternalPerl.g:1542:2: ( 'evalbytes' )
                    // InternalPerl.g:1543:3: 'evalbytes'
                    {
                     before(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 
                    match(input,113,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getEvalbytesKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:1548:2: ( 'exec' )
                    {
                    // InternalPerl.g:1548:2: ( 'exec' )
                    // InternalPerl.g:1549:3: 'exec'
                    {
                     before(grammarAccess.getKeywordAccess().getExecKeyword_42()); 
                    match(input,114,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExecKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:1554:2: ( 'exists' )
                    {
                    // InternalPerl.g:1554:2: ( 'exists' )
                    // InternalPerl.g:1555:3: 'exists'
                    {
                     before(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 
                    match(input,115,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExistsKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:1560:2: ( 'exit' )
                    {
                    // InternalPerl.g:1560:2: ( 'exit' )
                    // InternalPerl.g:1561:3: 'exit'
                    {
                     before(grammarAccess.getKeywordAccess().getExitKeyword_44()); 
                    match(input,116,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExitKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:1566:2: ( 'exp' )
                    {
                    // InternalPerl.g:1566:2: ( 'exp' )
                    // InternalPerl.g:1567:3: 'exp'
                    {
                     before(grammarAccess.getKeywordAccess().getExpKeyword_45()); 
                    match(input,117,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getExpKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:1572:2: ( 'fc' )
                    {
                    // InternalPerl.g:1572:2: ( 'fc' )
                    // InternalPerl.g:1573:3: 'fc'
                    {
                     before(grammarAccess.getKeywordAccess().getFcKeyword_46()); 
                    match(input,118,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:1578:2: ( 'fcntl' )
                    {
                    // InternalPerl.g:1578:2: ( 'fcntl' )
                    // InternalPerl.g:1579:3: 'fcntl'
                    {
                     before(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 
                    match(input,119,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFcntlKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:1584:2: ( 'fileno' )
                    {
                    // InternalPerl.g:1584:2: ( 'fileno' )
                    // InternalPerl.g:1585:3: 'fileno'
                    {
                     before(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 
                    match(input,120,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFilenoKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:1590:2: ( 'flock' )
                    {
                    // InternalPerl.g:1590:2: ( 'flock' )
                    // InternalPerl.g:1591:3: 'flock'
                    {
                     before(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 
                    match(input,121,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFlockKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:1596:2: ( 'for' )
                    {
                    // InternalPerl.g:1596:2: ( 'for' )
                    // InternalPerl.g:1597:3: 'for'
                    {
                     before(grammarAccess.getKeywordAccess().getForKeyword_50()); 
                    match(input,122,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:1602:2: ( 'foreach' )
                    {
                    // InternalPerl.g:1602:2: ( 'foreach' )
                    // InternalPerl.g:1603:3: 'foreach'
                    {
                     before(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 
                    match(input,123,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForeachKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:1608:2: ( 'fork' )
                    {
                    // InternalPerl.g:1608:2: ( 'fork' )
                    // InternalPerl.g:1609:3: 'fork'
                    {
                     before(grammarAccess.getKeywordAccess().getForkKeyword_52()); 
                    match(input,124,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getForkKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:1614:2: ( 'format' )
                    {
                    // InternalPerl.g:1614:2: ( 'format' )
                    // InternalPerl.g:1615:3: 'format'
                    {
                     before(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 
                    match(input,125,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormatKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:1620:2: ( 'formline' )
                    {
                    // InternalPerl.g:1620:2: ( 'formline' )
                    // InternalPerl.g:1621:3: 'formline'
                    {
                     before(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 
                    match(input,126,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getFormlineKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:1626:2: ( 'getc' )
                    {
                    // InternalPerl.g:1626:2: ( 'getc' )
                    // InternalPerl.g:1627:3: 'getc'
                    {
                     before(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 
                    match(input,127,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetcKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:1632:2: ( 'getgrent' )
                    {
                    // InternalPerl.g:1632:2: ( 'getgrent' )
                    // InternalPerl.g:1633:3: 'getgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 
                    match(input,128,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrentKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:1638:2: ( 'getgrgid' )
                    {
                    // InternalPerl.g:1638:2: ( 'getgrgid' )
                    // InternalPerl.g:1639:3: 'getgrgid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 
                    match(input,129,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrgidKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:1644:2: ( 'getgrnam' )
                    {
                    // InternalPerl.g:1644:2: ( 'getgrnam' )
                    // InternalPerl.g:1645:3: 'getgrnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 
                    match(input,130,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetgrnamKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:1650:2: ( 'gethostbyaddr' )
                    {
                    // InternalPerl.g:1650:2: ( 'gethostbyaddr' )
                    // InternalPerl.g:1651:3: 'gethostbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 
                    match(input,131,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:1656:2: ( 'gethostbyname' )
                    {
                    // InternalPerl.g:1656:2: ( 'gethostbyname' )
                    // InternalPerl.g:1657:3: 'gethostbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 
                    match(input,132,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostbynameKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:1662:2: ( 'gethostent' )
                    {
                    // InternalPerl.g:1662:2: ( 'gethostent' )
                    // InternalPerl.g:1663:3: 'gethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 
                    match(input,133,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGethostentKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:1668:2: ( 'getlogin' )
                    {
                    // InternalPerl.g:1668:2: ( 'getlogin' )
                    // InternalPerl.g:1669:3: 'getlogin'
                    {
                     before(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 
                    match(input,134,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetloginKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:1674:2: ( 'getnetbyaddr' )
                    {
                    // InternalPerl.g:1674:2: ( 'getnetbyaddr' )
                    // InternalPerl.g:1675:3: 'getnetbyaddr'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 
                    match(input,135,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63()); 

                    }


                    }
                    break;
                case 65 :
                    // InternalPerl.g:1680:2: ( 'getnetbyname' )
                    {
                    // InternalPerl.g:1680:2: ( 'getnetbyname' )
                    // InternalPerl.g:1681:3: 'getnetbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 
                    match(input,136,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64()); 

                    }


                    }
                    break;
                case 66 :
                    // InternalPerl.g:1686:2: ( 'getnetent' )
                    {
                    // InternalPerl.g:1686:2: ( 'getnetent' )
                    // InternalPerl.g:1687:3: 'getnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 
                    match(input,137,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetnetentKeyword_65()); 

                    }


                    }
                    break;
                case 67 :
                    // InternalPerl.g:1692:2: ( 'getpeername' )
                    {
                    // InternalPerl.g:1692:2: ( 'getpeername' )
                    // InternalPerl.g:1693:3: 'getpeername'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 
                    match(input,138,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpeernameKeyword_66()); 

                    }


                    }
                    break;
                case 68 :
                    // InternalPerl.g:1698:2: ( 'getpgrp' )
                    {
                    // InternalPerl.g:1698:2: ( 'getpgrp' )
                    // InternalPerl.g:1699:3: 'getpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 
                    match(input,139,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpgrpKeyword_67()); 

                    }


                    }
                    break;
                case 69 :
                    // InternalPerl.g:1704:2: ( 'getppid' )
                    {
                    // InternalPerl.g:1704:2: ( 'getppid' )
                    // InternalPerl.g:1705:3: 'getppid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 
                    match(input,140,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetppidKeyword_68()); 

                    }


                    }
                    break;
                case 70 :
                    // InternalPerl.g:1710:2: ( 'getpriority' )
                    {
                    // InternalPerl.g:1710:2: ( 'getpriority' )
                    // InternalPerl.g:1711:3: 'getpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 
                    match(input,141,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpriorityKeyword_69()); 

                    }


                    }
                    break;
                case 71 :
                    // InternalPerl.g:1716:2: ( 'getprotobyname' )
                    {
                    // InternalPerl.g:1716:2: ( 'getprotobyname' )
                    // InternalPerl.g:1717:3: 'getprotobyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 
                    match(input,142,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70()); 

                    }


                    }
                    break;
                case 72 :
                    // InternalPerl.g:1722:2: ( 'getprotobynumber' )
                    {
                    // InternalPerl.g:1722:2: ( 'getprotobynumber' )
                    // InternalPerl.g:1723:3: 'getprotobynumber'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 
                    match(input,143,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71()); 

                    }


                    }
                    break;
                case 73 :
                    // InternalPerl.g:1728:2: ( 'getprotoent' )
                    {
                    // InternalPerl.g:1728:2: ( 'getprotoent' )
                    // InternalPerl.g:1729:3: 'getprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 
                    match(input,144,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetprotoentKeyword_72()); 

                    }


                    }
                    break;
                case 74 :
                    // InternalPerl.g:1734:2: ( 'getpwent' )
                    {
                    // InternalPerl.g:1734:2: ( 'getpwent' )
                    // InternalPerl.g:1735:3: 'getpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 
                    match(input,145,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwentKeyword_73()); 

                    }


                    }
                    break;
                case 75 :
                    // InternalPerl.g:1740:2: ( 'getpwnam' )
                    {
                    // InternalPerl.g:1740:2: ( 'getpwnam' )
                    // InternalPerl.g:1741:3: 'getpwnam'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 
                    match(input,146,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwnamKeyword_74()); 

                    }


                    }
                    break;
                case 76 :
                    // InternalPerl.g:1746:2: ( 'getpwuid' )
                    {
                    // InternalPerl.g:1746:2: ( 'getpwuid' )
                    // InternalPerl.g:1747:3: 'getpwuid'
                    {
                     before(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 
                    match(input,147,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetpwuidKeyword_75()); 

                    }


                    }
                    break;
                case 77 :
                    // InternalPerl.g:1752:2: ( 'getservbyname' )
                    {
                    // InternalPerl.g:1752:2: ( 'getservbyname' )
                    // InternalPerl.g:1753:3: 'getservbyname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 
                    match(input,148,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbynameKeyword_76()); 

                    }


                    }
                    break;
                case 78 :
                    // InternalPerl.g:1758:2: ( 'getservbyport' )
                    {
                    // InternalPerl.g:1758:2: ( 'getservbyport' )
                    // InternalPerl.g:1759:3: 'getservbyport'
                    {
                     before(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 
                    match(input,149,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetservbyportKeyword_77()); 

                    }


                    }
                    break;
                case 79 :
                    // InternalPerl.g:1764:2: ( 'getservent' )
                    {
                    // InternalPerl.g:1764:2: ( 'getservent' )
                    // InternalPerl.g:1765:3: 'getservent'
                    {
                     before(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 
                    match(input,150,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetserventKeyword_78()); 

                    }


                    }
                    break;
                case 80 :
                    // InternalPerl.g:1770:2: ( 'getsockname' )
                    {
                    // InternalPerl.g:1770:2: ( 'getsockname' )
                    // InternalPerl.g:1771:3: 'getsockname'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 
                    match(input,151,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsocknameKeyword_79()); 

                    }


                    }
                    break;
                case 81 :
                    // InternalPerl.g:1776:2: ( 'getsockopt' )
                    {
                    // InternalPerl.g:1776:2: ( 'getsockopt' )
                    // InternalPerl.g:1777:3: 'getsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 
                    match(input,152,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGetsockoptKeyword_80()); 

                    }


                    }
                    break;
                case 82 :
                    // InternalPerl.g:1782:2: ( 'given' )
                    {
                    // InternalPerl.g:1782:2: ( 'given' )
                    // InternalPerl.g:1783:3: 'given'
                    {
                     before(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 
                    match(input,153,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGivenKeyword_81()); 

                    }


                    }
                    break;
                case 83 :
                    // InternalPerl.g:1788:2: ( 'glob' )
                    {
                    // InternalPerl.g:1788:2: ( 'glob' )
                    // InternalPerl.g:1789:3: 'glob'
                    {
                     before(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 
                    match(input,154,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGlobKeyword_82()); 

                    }


                    }
                    break;
                case 84 :
                    // InternalPerl.g:1794:2: ( 'gmtime' )
                    {
                    // InternalPerl.g:1794:2: ( 'gmtime' )
                    // InternalPerl.g:1795:3: 'gmtime'
                    {
                     before(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 
                    match(input,155,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGmtimeKeyword_83()); 

                    }


                    }
                    break;
                case 85 :
                    // InternalPerl.g:1800:2: ( 'goto' )
                    {
                    // InternalPerl.g:1800:2: ( 'goto' )
                    // InternalPerl.g:1801:3: 'goto'
                    {
                     before(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 
                    match(input,156,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGotoKeyword_84()); 

                    }


                    }
                    break;
                case 86 :
                    // InternalPerl.g:1806:2: ( 'grep' )
                    {
                    // InternalPerl.g:1806:2: ( 'grep' )
                    // InternalPerl.g:1807:3: 'grep'
                    {
                     before(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 
                    match(input,157,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getGrepKeyword_85()); 

                    }


                    }
                    break;
                case 87 :
                    // InternalPerl.g:1812:2: ( 'hex' )
                    {
                    // InternalPerl.g:1812:2: ( 'hex' )
                    // InternalPerl.g:1813:3: 'hex'
                    {
                     before(grammarAccess.getKeywordAccess().getHexKeyword_86()); 
                    match(input,158,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getHexKeyword_86()); 

                    }


                    }
                    break;
                case 88 :
                    // InternalPerl.g:1818:2: ( 'if' )
                    {
                    // InternalPerl.g:1818:2: ( 'if' )
                    // InternalPerl.g:1819:3: 'if'
                    {
                     before(grammarAccess.getKeywordAccess().getIfKeyword_87()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIfKeyword_87()); 

                    }


                    }
                    break;
                case 89 :
                    // InternalPerl.g:1824:2: ( 'index' )
                    {
                    // InternalPerl.g:1824:2: ( 'index' )
                    // InternalPerl.g:1825:3: 'index'
                    {
                     before(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 
                    match(input,159,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIndexKeyword_88()); 

                    }


                    }
                    break;
                case 90 :
                    // InternalPerl.g:1830:2: ( 'int' )
                    {
                    // InternalPerl.g:1830:2: ( 'int' )
                    // InternalPerl.g:1831:3: 'int'
                    {
                     before(grammarAccess.getKeywordAccess().getIntKeyword_89()); 
                    match(input,160,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIntKeyword_89()); 

                    }


                    }
                    break;
                case 91 :
                    // InternalPerl.g:1836:2: ( 'ioctl' )
                    {
                    // InternalPerl.g:1836:2: ( 'ioctl' )
                    // InternalPerl.g:1837:3: 'ioctl'
                    {
                     before(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 
                    match(input,161,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getIoctlKeyword_90()); 

                    }


                    }
                    break;
                case 92 :
                    // InternalPerl.g:1842:2: ( 'join' )
                    {
                    // InternalPerl.g:1842:2: ( 'join' )
                    // InternalPerl.g:1843:3: 'join'
                    {
                     before(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 
                    match(input,162,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getJoinKeyword_91()); 

                    }


                    }
                    break;
                case 93 :
                    // InternalPerl.g:1848:2: ( 'keys' )
                    {
                    // InternalPerl.g:1848:2: ( 'keys' )
                    // InternalPerl.g:1849:3: 'keys'
                    {
                     before(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 
                    match(input,163,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKeysKeyword_92()); 

                    }


                    }
                    break;
                case 94 :
                    // InternalPerl.g:1854:2: ( 'kill' )
                    {
                    // InternalPerl.g:1854:2: ( 'kill' )
                    // InternalPerl.g:1855:3: 'kill'
                    {
                     before(grammarAccess.getKeywordAccess().getKillKeyword_93()); 
                    match(input,164,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getKillKeyword_93()); 

                    }


                    }
                    break;
                case 95 :
                    // InternalPerl.g:1860:2: ( 'last' )
                    {
                    // InternalPerl.g:1860:2: ( 'last' )
                    // InternalPerl.g:1861:3: 'last'
                    {
                     before(grammarAccess.getKeywordAccess().getLastKeyword_94()); 
                    match(input,165,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLastKeyword_94()); 

                    }


                    }
                    break;
                case 96 :
                    // InternalPerl.g:1866:2: ( 'lc' )
                    {
                    // InternalPerl.g:1866:2: ( 'lc' )
                    // InternalPerl.g:1867:3: 'lc'
                    {
                     before(grammarAccess.getKeywordAccess().getLcKeyword_95()); 
                    match(input,166,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcKeyword_95()); 

                    }


                    }
                    break;
                case 97 :
                    // InternalPerl.g:1872:2: ( 'lcfirst' )
                    {
                    // InternalPerl.g:1872:2: ( 'lcfirst' )
                    // InternalPerl.g:1873:3: 'lcfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 
                    match(input,167,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLcfirstKeyword_96()); 

                    }


                    }
                    break;
                case 98 :
                    // InternalPerl.g:1878:2: ( 'length' )
                    {
                    // InternalPerl.g:1878:2: ( 'length' )
                    // InternalPerl.g:1879:3: 'length'
                    {
                     before(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 
                    match(input,168,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLengthKeyword_97()); 

                    }


                    }
                    break;
                case 99 :
                    // InternalPerl.g:1884:2: ( 'link' )
                    {
                    // InternalPerl.g:1884:2: ( 'link' )
                    // InternalPerl.g:1885:3: 'link'
                    {
                     before(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 
                    match(input,169,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLinkKeyword_98()); 

                    }


                    }
                    break;
                case 100 :
                    // InternalPerl.g:1890:2: ( 'listen' )
                    {
                    // InternalPerl.g:1890:2: ( 'listen' )
                    // InternalPerl.g:1891:3: 'listen'
                    {
                     before(grammarAccess.getKeywordAccess().getListenKeyword_99()); 
                    match(input,170,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getListenKeyword_99()); 

                    }


                    }
                    break;
                case 101 :
                    // InternalPerl.g:1896:2: ( 'local' )
                    {
                    // InternalPerl.g:1896:2: ( 'local' )
                    // InternalPerl.g:1897:3: 'local'
                    {
                     before(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 
                    match(input,171,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocalKeyword_100()); 

                    }


                    }
                    break;
                case 102 :
                    // InternalPerl.g:1902:2: ( 'localtime' )
                    {
                    // InternalPerl.g:1902:2: ( 'localtime' )
                    // InternalPerl.g:1903:3: 'localtime'
                    {
                     before(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 
                    match(input,172,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLocaltimeKeyword_101()); 

                    }


                    }
                    break;
                case 103 :
                    // InternalPerl.g:1908:2: ( 'lock' )
                    {
                    // InternalPerl.g:1908:2: ( 'lock' )
                    // InternalPerl.g:1909:3: 'lock'
                    {
                     before(grammarAccess.getKeywordAccess().getLockKeyword_102()); 
                    match(input,173,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLockKeyword_102()); 

                    }


                    }
                    break;
                case 104 :
                    // InternalPerl.g:1914:2: ( 'log' )
                    {
                    // InternalPerl.g:1914:2: ( 'log' )
                    // InternalPerl.g:1915:3: 'log'
                    {
                     before(grammarAccess.getKeywordAccess().getLogKeyword_103()); 
                    match(input,174,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLogKeyword_103()); 

                    }


                    }
                    break;
                case 105 :
                    // InternalPerl.g:1920:2: ( 'lstat' )
                    {
                    // InternalPerl.g:1920:2: ( 'lstat' )
                    // InternalPerl.g:1921:3: 'lstat'
                    {
                     before(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 
                    match(input,175,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getLstatKeyword_104()); 

                    }


                    }
                    break;
                case 106 :
                    // InternalPerl.g:1926:2: ( 'map' )
                    {
                    // InternalPerl.g:1926:2: ( 'map' )
                    // InternalPerl.g:1927:3: 'map'
                    {
                     before(grammarAccess.getKeywordAccess().getMapKeyword_105()); 
                    match(input,176,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMapKeyword_105()); 

                    }


                    }
                    break;
                case 107 :
                    // InternalPerl.g:1932:2: ( 'mkdir' )
                    {
                    // InternalPerl.g:1932:2: ( 'mkdir' )
                    // InternalPerl.g:1933:3: 'mkdir'
                    {
                     before(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 
                    match(input,177,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMkdirKeyword_106()); 

                    }


                    }
                    break;
                case 108 :
                    // InternalPerl.g:1938:2: ( 'msgctl' )
                    {
                    // InternalPerl.g:1938:2: ( 'msgctl' )
                    // InternalPerl.g:1939:3: 'msgctl'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 
                    match(input,178,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgctlKeyword_107()); 

                    }


                    }
                    break;
                case 109 :
                    // InternalPerl.g:1944:2: ( 'msgget' )
                    {
                    // InternalPerl.g:1944:2: ( 'msgget' )
                    // InternalPerl.g:1945:3: 'msgget'
                    {
                     before(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 
                    match(input,179,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsggetKeyword_108()); 

                    }


                    }
                    break;
                case 110 :
                    // InternalPerl.g:1950:2: ( 'msgrcv' )
                    {
                    // InternalPerl.g:1950:2: ( 'msgrcv' )
                    // InternalPerl.g:1951:3: 'msgrcv'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 
                    match(input,180,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgrcvKeyword_109()); 

                    }


                    }
                    break;
                case 111 :
                    // InternalPerl.g:1956:2: ( 'msgsnd' )
                    {
                    // InternalPerl.g:1956:2: ( 'msgsnd' )
                    // InternalPerl.g:1957:3: 'msgsnd'
                    {
                     before(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 
                    match(input,181,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMsgsndKeyword_110()); 

                    }


                    }
                    break;
                case 112 :
                    // InternalPerl.g:1962:2: ( 'my' )
                    {
                    // InternalPerl.g:1962:2: ( 'my' )
                    // InternalPerl.g:1963:3: 'my'
                    {
                     before(grammarAccess.getKeywordAccess().getMyKeyword_111()); 
                    match(input,182,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getMyKeyword_111()); 

                    }


                    }
                    break;
                case 113 :
                    // InternalPerl.g:1968:2: ( 'next' )
                    {
                    // InternalPerl.g:1968:2: ( 'next' )
                    // InternalPerl.g:1969:3: 'next'
                    {
                     before(grammarAccess.getKeywordAccess().getNextKeyword_112()); 
                    match(input,183,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNextKeyword_112()); 

                    }


                    }
                    break;
                case 114 :
                    // InternalPerl.g:1974:2: ( 'no' )
                    {
                    // InternalPerl.g:1974:2: ( 'no' )
                    // InternalPerl.g:1975:3: 'no'
                    {
                     before(grammarAccess.getKeywordAccess().getNoKeyword_113()); 
                    match(input,184,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getNoKeyword_113()); 

                    }


                    }
                    break;
                case 115 :
                    // InternalPerl.g:1980:2: ( 'oct' )
                    {
                    // InternalPerl.g:1980:2: ( 'oct' )
                    // InternalPerl.g:1981:3: 'oct'
                    {
                     before(grammarAccess.getKeywordAccess().getOctKeyword_114()); 
                    match(input,185,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOctKeyword_114()); 

                    }


                    }
                    break;
                case 116 :
                    // InternalPerl.g:1986:2: ( 'open' )
                    {
                    // InternalPerl.g:1986:2: ( 'open' )
                    // InternalPerl.g:1987:3: 'open'
                    {
                     before(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpenKeyword_115()); 

                    }


                    }
                    break;
                case 117 :
                    // InternalPerl.g:1992:2: ( 'opendir' )
                    {
                    // InternalPerl.g:1992:2: ( 'opendir' )
                    // InternalPerl.g:1993:3: 'opendir'
                    {
                     before(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 
                    match(input,186,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOpendirKeyword_116()); 

                    }


                    }
                    break;
                case 118 :
                    // InternalPerl.g:1998:2: ( 'ord' )
                    {
                    // InternalPerl.g:1998:2: ( 'ord' )
                    // InternalPerl.g:1999:3: 'ord'
                    {
                     before(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 
                    match(input,187,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOrdKeyword_117()); 

                    }


                    }
                    break;
                case 119 :
                    // InternalPerl.g:2004:2: ( 'our' )
                    {
                    // InternalPerl.g:2004:2: ( 'our' )
                    // InternalPerl.g:2005:3: 'our'
                    {
                     before(grammarAccess.getKeywordAccess().getOurKeyword_118()); 
                    match(input,188,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getOurKeyword_118()); 

                    }


                    }
                    break;
                case 120 :
                    // InternalPerl.g:2010:2: ( 'pack' )
                    {
                    // InternalPerl.g:2010:2: ( 'pack' )
                    // InternalPerl.g:2011:3: 'pack'
                    {
                     before(grammarAccess.getKeywordAccess().getPackKeyword_119()); 
                    match(input,189,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackKeyword_119()); 

                    }


                    }
                    break;
                case 121 :
                    // InternalPerl.g:2016:2: ( 'package' )
                    {
                    // InternalPerl.g:2016:2: ( 'package' )
                    // InternalPerl.g:2017:3: 'package'
                    {
                     before(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 
                    match(input,190,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPackageKeyword_120()); 

                    }


                    }
                    break;
                case 122 :
                    // InternalPerl.g:2022:2: ( 'pipe' )
                    {
                    // InternalPerl.g:2022:2: ( 'pipe' )
                    // InternalPerl.g:2023:3: 'pipe'
                    {
                     before(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 
                    match(input,191,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPipeKeyword_121()); 

                    }


                    }
                    break;
                case 123 :
                    // InternalPerl.g:2028:2: ( 'pop' )
                    {
                    // InternalPerl.g:2028:2: ( 'pop' )
                    // InternalPerl.g:2029:3: 'pop'
                    {
                     before(grammarAccess.getKeywordAccess().getPopKeyword_122()); 
                    match(input,192,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPopKeyword_122()); 

                    }


                    }
                    break;
                case 124 :
                    // InternalPerl.g:2034:2: ( 'pos' )
                    {
                    // InternalPerl.g:2034:2: ( 'pos' )
                    // InternalPerl.g:2035:3: 'pos'
                    {
                     before(grammarAccess.getKeywordAccess().getPosKeyword_123()); 
                    match(input,193,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPosKeyword_123()); 

                    }


                    }
                    break;
                case 125 :
                    // InternalPerl.g:2040:2: ( 'print' )
                    {
                    // InternalPerl.g:2040:2: ( 'print' )
                    // InternalPerl.g:2041:3: 'print'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 
                    match(input,194,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintKeyword_124()); 

                    }


                    }
                    break;
                case 126 :
                    // InternalPerl.g:2046:2: ( 'printf' )
                    {
                    // InternalPerl.g:2046:2: ( 'printf' )
                    // InternalPerl.g:2047:3: 'printf'
                    {
                     before(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 
                    match(input,195,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrintfKeyword_125()); 

                    }


                    }
                    break;
                case 127 :
                    // InternalPerl.g:2052:2: ( 'prototype' )
                    {
                    // InternalPerl.g:2052:2: ( 'prototype' )
                    // InternalPerl.g:2053:3: 'prototype'
                    {
                     before(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 
                    match(input,196,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPrototypeKeyword_126()); 

                    }


                    }
                    break;
                case 128 :
                    // InternalPerl.g:2058:2: ( 'push' )
                    {
                    // InternalPerl.g:2058:2: ( 'push' )
                    // InternalPerl.g:2059:3: 'push'
                    {
                     before(grammarAccess.getKeywordAccess().getPushKeyword_127()); 
                    match(input,197,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getPushKeyword_127()); 

                    }


                    }
                    break;
                case 129 :
                    // InternalPerl.g:2064:2: ( 'quotemeta' )
                    {
                    // InternalPerl.g:2064:2: ( 'quotemeta' )
                    // InternalPerl.g:2065:3: 'quotemeta'
                    {
                     before(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 
                    match(input,198,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getQuotemetaKeyword_128()); 

                    }


                    }
                    break;
                case 130 :
                    // InternalPerl.g:2070:2: ( 'rand' )
                    {
                    // InternalPerl.g:2070:2: ( 'rand' )
                    // InternalPerl.g:2071:3: 'rand'
                    {
                     before(grammarAccess.getKeywordAccess().getRandKeyword_129()); 
                    match(input,199,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRandKeyword_129()); 

                    }


                    }
                    break;
                case 131 :
                    // InternalPerl.g:2076:2: ( 'read' )
                    {
                    // InternalPerl.g:2076:2: ( 'read' )
                    // InternalPerl.g:2077:3: 'read'
                    {
                     before(grammarAccess.getKeywordAccess().getReadKeyword_130()); 
                    match(input,200,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadKeyword_130()); 

                    }


                    }
                    break;
                case 132 :
                    // InternalPerl.g:2082:2: ( 'readdir' )
                    {
                    // InternalPerl.g:2082:2: ( 'readdir' )
                    // InternalPerl.g:2083:3: 'readdir'
                    {
                     before(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 
                    match(input,201,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReaddirKeyword_131()); 

                    }


                    }
                    break;
                case 133 :
                    // InternalPerl.g:2088:2: ( 'readline' )
                    {
                    // InternalPerl.g:2088:2: ( 'readline' )
                    // InternalPerl.g:2089:3: 'readline'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 
                    match(input,202,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlineKeyword_132()); 

                    }


                    }
                    break;
                case 134 :
                    // InternalPerl.g:2094:2: ( 'readlink' )
                    {
                    // InternalPerl.g:2094:2: ( 'readlink' )
                    // InternalPerl.g:2095:3: 'readlink'
                    {
                     before(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 
                    match(input,203,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadlinkKeyword_133()); 

                    }


                    }
                    break;
                case 135 :
                    // InternalPerl.g:2100:2: ( 'readpipe' )
                    {
                    // InternalPerl.g:2100:2: ( 'readpipe' )
                    // InternalPerl.g:2101:3: 'readpipe'
                    {
                     before(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 
                    match(input,204,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReadpipeKeyword_134()); 

                    }


                    }
                    break;
                case 136 :
                    // InternalPerl.g:2106:2: ( 'recv' )
                    {
                    // InternalPerl.g:2106:2: ( 'recv' )
                    // InternalPerl.g:2107:3: 'recv'
                    {
                     before(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 
                    match(input,205,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRecvKeyword_135()); 

                    }


                    }
                    break;
                case 137 :
                    // InternalPerl.g:2112:2: ( 'redo' )
                    {
                    // InternalPerl.g:2112:2: ( 'redo' )
                    // InternalPerl.g:2113:3: 'redo'
                    {
                     before(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 
                    match(input,206,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRedoKeyword_136()); 

                    }


                    }
                    break;
                case 138 :
                    // InternalPerl.g:2118:2: ( 'ref' )
                    {
                    // InternalPerl.g:2118:2: ( 'ref' )
                    // InternalPerl.g:2119:3: 'ref'
                    {
                     before(grammarAccess.getKeywordAccess().getRefKeyword_137()); 
                    match(input,207,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRefKeyword_137()); 

                    }


                    }
                    break;
                case 139 :
                    // InternalPerl.g:2124:2: ( 'rename' )
                    {
                    // InternalPerl.g:2124:2: ( 'rename' )
                    // InternalPerl.g:2125:3: 'rename'
                    {
                     before(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 
                    match(input,208,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRenameKeyword_138()); 

                    }


                    }
                    break;
                case 140 :
                    // InternalPerl.g:2130:2: ( 'require' )
                    {
                    // InternalPerl.g:2130:2: ( 'require' )
                    // InternalPerl.g:2131:3: 'require'
                    {
                     before(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 
                    match(input,209,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRequireKeyword_139()); 

                    }


                    }
                    break;
                case 141 :
                    // InternalPerl.g:2136:2: ( 'reset' )
                    {
                    // InternalPerl.g:2136:2: ( 'reset' )
                    // InternalPerl.g:2137:3: 'reset'
                    {
                     before(grammarAccess.getKeywordAccess().getResetKeyword_140()); 
                    match(input,210,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getResetKeyword_140()); 

                    }


                    }
                    break;
                case 142 :
                    // InternalPerl.g:2142:2: ( 'return' )
                    {
                    // InternalPerl.g:2142:2: ( 'return' )
                    // InternalPerl.g:2143:3: 'return'
                    {
                     before(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 
                    match(input,211,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReturnKeyword_141()); 

                    }


                    }
                    break;
                case 143 :
                    // InternalPerl.g:2148:2: ( 'reverse' )
                    {
                    // InternalPerl.g:2148:2: ( 'reverse' )
                    // InternalPerl.g:2149:3: 'reverse'
                    {
                     before(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 
                    match(input,212,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getReverseKeyword_142()); 

                    }


                    }
                    break;
                case 144 :
                    // InternalPerl.g:2154:2: ( 'rewinddir' )
                    {
                    // InternalPerl.g:2154:2: ( 'rewinddir' )
                    // InternalPerl.g:2155:3: 'rewinddir'
                    {
                     before(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 
                    match(input,213,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRewinddirKeyword_143()); 

                    }


                    }
                    break;
                case 145 :
                    // InternalPerl.g:2160:2: ( 'rindex' )
                    {
                    // InternalPerl.g:2160:2: ( 'rindex' )
                    // InternalPerl.g:2161:3: 'rindex'
                    {
                     before(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 
                    match(input,214,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRindexKeyword_144()); 

                    }


                    }
                    break;
                case 146 :
                    // InternalPerl.g:2166:2: ( 'rmdir' )
                    {
                    // InternalPerl.g:2166:2: ( 'rmdir' )
                    // InternalPerl.g:2167:3: 'rmdir'
                    {
                     before(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 
                    match(input,215,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getRmdirKeyword_145()); 

                    }


                    }
                    break;
                case 147 :
                    // InternalPerl.g:2172:2: ( 'say' )
                    {
                    // InternalPerl.g:2172:2: ( 'say' )
                    // InternalPerl.g:2173:3: 'say'
                    {
                     before(grammarAccess.getKeywordAccess().getSayKeyword_146()); 
                    match(input,216,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSayKeyword_146()); 

                    }


                    }
                    break;
                case 148 :
                    // InternalPerl.g:2178:2: ( 'scalar' )
                    {
                    // InternalPerl.g:2178:2: ( 'scalar' )
                    // InternalPerl.g:2179:3: 'scalar'
                    {
                     before(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 
                    match(input,217,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getScalarKeyword_147()); 

                    }


                    }
                    break;
                case 149 :
                    // InternalPerl.g:2184:2: ( 'seek' )
                    {
                    // InternalPerl.g:2184:2: ( 'seek' )
                    // InternalPerl.g:2185:3: 'seek'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 
                    match(input,218,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekKeyword_148()); 

                    }


                    }
                    break;
                case 150 :
                    // InternalPerl.g:2190:2: ( 'seekdir' )
                    {
                    // InternalPerl.g:2190:2: ( 'seekdir' )
                    // InternalPerl.g:2191:3: 'seekdir'
                    {
                     before(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 
                    match(input,219,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSeekdirKeyword_149()); 

                    }


                    }
                    break;
                case 151 :
                    // InternalPerl.g:2196:2: ( 'select' )
                    {
                    // InternalPerl.g:2196:2: ( 'select' )
                    // InternalPerl.g:2197:3: 'select'
                    {
                     before(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 
                    match(input,220,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSelectKeyword_150()); 

                    }


                    }
                    break;
                case 152 :
                    // InternalPerl.g:2202:2: ( 'semctl' )
                    {
                    // InternalPerl.g:2202:2: ( 'semctl' )
                    // InternalPerl.g:2203:3: 'semctl'
                    {
                     before(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 
                    match(input,221,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemctlKeyword_151()); 

                    }


                    }
                    break;
                case 153 :
                    // InternalPerl.g:2208:2: ( 'semget' )
                    {
                    // InternalPerl.g:2208:2: ( 'semget' )
                    // InternalPerl.g:2209:3: 'semget'
                    {
                     before(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 
                    match(input,222,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemgetKeyword_152()); 

                    }


                    }
                    break;
                case 154 :
                    // InternalPerl.g:2214:2: ( 'semop' )
                    {
                    // InternalPerl.g:2214:2: ( 'semop' )
                    // InternalPerl.g:2215:3: 'semop'
                    {
                     before(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 
                    match(input,223,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSemopKeyword_153()); 

                    }


                    }
                    break;
                case 155 :
                    // InternalPerl.g:2220:2: ( 'send' )
                    {
                    // InternalPerl.g:2220:2: ( 'send' )
                    // InternalPerl.g:2221:3: 'send'
                    {
                     before(grammarAccess.getKeywordAccess().getSendKeyword_154()); 
                    match(input,224,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSendKeyword_154()); 

                    }


                    }
                    break;
                case 156 :
                    // InternalPerl.g:2226:2: ( 'setgrent' )
                    {
                    // InternalPerl.g:2226:2: ( 'setgrent' )
                    // InternalPerl.g:2227:3: 'setgrent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 
                    match(input,225,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetgrentKeyword_155()); 

                    }


                    }
                    break;
                case 157 :
                    // InternalPerl.g:2232:2: ( 'sethostent' )
                    {
                    // InternalPerl.g:2232:2: ( 'sethostent' )
                    // InternalPerl.g:2233:3: 'sethostent'
                    {
                     before(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 
                    match(input,226,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSethostentKeyword_156()); 

                    }


                    }
                    break;
                case 158 :
                    // InternalPerl.g:2238:2: ( 'setnetent' )
                    {
                    // InternalPerl.g:2238:2: ( 'setnetent' )
                    // InternalPerl.g:2239:3: 'setnetent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 
                    match(input,227,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetnetentKeyword_157()); 

                    }


                    }
                    break;
                case 159 :
                    // InternalPerl.g:2244:2: ( 'setpgrp' )
                    {
                    // InternalPerl.g:2244:2: ( 'setpgrp' )
                    // InternalPerl.g:2245:3: 'setpgrp'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 
                    match(input,228,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpgrpKeyword_158()); 

                    }


                    }
                    break;
                case 160 :
                    // InternalPerl.g:2250:2: ( 'setpriority' )
                    {
                    // InternalPerl.g:2250:2: ( 'setpriority' )
                    // InternalPerl.g:2251:3: 'setpriority'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 
                    match(input,229,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpriorityKeyword_159()); 

                    }


                    }
                    break;
                case 161 :
                    // InternalPerl.g:2256:2: ( 'setprotoent' )
                    {
                    // InternalPerl.g:2256:2: ( 'setprotoent' )
                    // InternalPerl.g:2257:3: 'setprotoent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 
                    match(input,230,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetprotoentKeyword_160()); 

                    }


                    }
                    break;
                case 162 :
                    // InternalPerl.g:2262:2: ( 'setpwent' )
                    {
                    // InternalPerl.g:2262:2: ( 'setpwent' )
                    // InternalPerl.g:2263:3: 'setpwent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 
                    match(input,231,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetpwentKeyword_161()); 

                    }


                    }
                    break;
                case 163 :
                    // InternalPerl.g:2268:2: ( 'setservent' )
                    {
                    // InternalPerl.g:2268:2: ( 'setservent' )
                    // InternalPerl.g:2269:3: 'setservent'
                    {
                     before(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 
                    match(input,232,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetserventKeyword_162()); 

                    }


                    }
                    break;
                case 164 :
                    // InternalPerl.g:2274:2: ( 'setsockopt' )
                    {
                    // InternalPerl.g:2274:2: ( 'setsockopt' )
                    // InternalPerl.g:2275:3: 'setsockopt'
                    {
                     before(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 
                    match(input,233,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSetsockoptKeyword_163()); 

                    }


                    }
                    break;
                case 165 :
                    // InternalPerl.g:2280:2: ( 'shift' )
                    {
                    // InternalPerl.g:2280:2: ( 'shift' )
                    // InternalPerl.g:2281:3: 'shift'
                    {
                     before(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 
                    match(input,234,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShiftKeyword_164()); 

                    }


                    }
                    break;
                case 166 :
                    // InternalPerl.g:2286:2: ( 'shmctl' )
                    {
                    // InternalPerl.g:2286:2: ( 'shmctl' )
                    // InternalPerl.g:2287:3: 'shmctl'
                    {
                     before(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 
                    match(input,235,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmctlKeyword_165()); 

                    }


                    }
                    break;
                case 167 :
                    // InternalPerl.g:2292:2: ( 'shmget' )
                    {
                    // InternalPerl.g:2292:2: ( 'shmget' )
                    // InternalPerl.g:2293:3: 'shmget'
                    {
                     before(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 
                    match(input,236,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmgetKeyword_166()); 

                    }


                    }
                    break;
                case 168 :
                    // InternalPerl.g:2298:2: ( 'shmread' )
                    {
                    // InternalPerl.g:2298:2: ( 'shmread' )
                    // InternalPerl.g:2299:3: 'shmread'
                    {
                     before(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 
                    match(input,237,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmreadKeyword_167()); 

                    }


                    }
                    break;
                case 169 :
                    // InternalPerl.g:2304:2: ( 'shmwrite' )
                    {
                    // InternalPerl.g:2304:2: ( 'shmwrite' )
                    // InternalPerl.g:2305:3: 'shmwrite'
                    {
                     before(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 
                    match(input,238,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShmwriteKeyword_168()); 

                    }


                    }
                    break;
                case 170 :
                    // InternalPerl.g:2310:2: ( 'shutdown' )
                    {
                    // InternalPerl.g:2310:2: ( 'shutdown' )
                    // InternalPerl.g:2311:3: 'shutdown'
                    {
                     before(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 
                    match(input,239,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getShutdownKeyword_169()); 

                    }


                    }
                    break;
                case 171 :
                    // InternalPerl.g:2316:2: ( 'sin' )
                    {
                    // InternalPerl.g:2316:2: ( 'sin' )
                    // InternalPerl.g:2317:3: 'sin'
                    {
                     before(grammarAccess.getKeywordAccess().getSinKeyword_170()); 
                    match(input,240,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSinKeyword_170()); 

                    }


                    }
                    break;
                case 172 :
                    // InternalPerl.g:2322:2: ( 'sleep' )
                    {
                    // InternalPerl.g:2322:2: ( 'sleep' )
                    // InternalPerl.g:2323:3: 'sleep'
                    {
                     before(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 
                    match(input,241,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSleepKeyword_171()); 

                    }


                    }
                    break;
                case 173 :
                    // InternalPerl.g:2328:2: ( 'socket' )
                    {
                    // InternalPerl.g:2328:2: ( 'socket' )
                    // InternalPerl.g:2329:3: 'socket'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 
                    match(input,242,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketKeyword_172()); 

                    }


                    }
                    break;
                case 174 :
                    // InternalPerl.g:2334:2: ( 'socketpair' )
                    {
                    // InternalPerl.g:2334:2: ( 'socketpair' )
                    // InternalPerl.g:2335:3: 'socketpair'
                    {
                     before(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 
                    match(input,243,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSocketpairKeyword_173()); 

                    }


                    }
                    break;
                case 175 :
                    // InternalPerl.g:2340:2: ( 'sort' )
                    {
                    // InternalPerl.g:2340:2: ( 'sort' )
                    // InternalPerl.g:2341:3: 'sort'
                    {
                     before(grammarAccess.getKeywordAccess().getSortKeyword_174()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSortKeyword_174()); 

                    }


                    }
                    break;
                case 176 :
                    // InternalPerl.g:2346:2: ( 'splice' )
                    {
                    // InternalPerl.g:2346:2: ( 'splice' )
                    // InternalPerl.g:2347:3: 'splice'
                    {
                     before(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 
                    match(input,244,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSpliceKeyword_175()); 

                    }


                    }
                    break;
                case 177 :
                    // InternalPerl.g:2352:2: ( 'split' )
                    {
                    // InternalPerl.g:2352:2: ( 'split' )
                    // InternalPerl.g:2353:3: 'split'
                    {
                     before(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 
                    match(input,245,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSplitKeyword_176()); 

                    }


                    }
                    break;
                case 178 :
                    // InternalPerl.g:2358:2: ( 'sprintf' )
                    {
                    // InternalPerl.g:2358:2: ( 'sprintf' )
                    // InternalPerl.g:2359:3: 'sprintf'
                    {
                     before(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 
                    match(input,246,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSprintfKeyword_177()); 

                    }


                    }
                    break;
                case 179 :
                    // InternalPerl.g:2364:2: ( 'sqrt' )
                    {
                    // InternalPerl.g:2364:2: ( 'sqrt' )
                    // InternalPerl.g:2365:3: 'sqrt'
                    {
                     before(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 
                    match(input,247,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSqrtKeyword_178()); 

                    }


                    }
                    break;
                case 180 :
                    // InternalPerl.g:2370:2: ( 'srand' )
                    {
                    // InternalPerl.g:2370:2: ( 'srand' )
                    // InternalPerl.g:2371:3: 'srand'
                    {
                     before(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 
                    match(input,248,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSrandKeyword_179()); 

                    }


                    }
                    break;
                case 181 :
                    // InternalPerl.g:2376:2: ( 'stat' )
                    {
                    // InternalPerl.g:2376:2: ( 'stat' )
                    // InternalPerl.g:2377:3: 'stat'
                    {
                     before(grammarAccess.getKeywordAccess().getStatKeyword_180()); 
                    match(input,249,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStatKeyword_180()); 

                    }


                    }
                    break;
                case 182 :
                    // InternalPerl.g:2382:2: ( 'state' )
                    {
                    // InternalPerl.g:2382:2: ( 'state' )
                    // InternalPerl.g:2383:3: 'state'
                    {
                     before(grammarAccess.getKeywordAccess().getStateKeyword_181()); 
                    match(input,250,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStateKeyword_181()); 

                    }


                    }
                    break;
                case 183 :
                    // InternalPerl.g:2388:2: ( 'study' )
                    {
                    // InternalPerl.g:2388:2: ( 'study' )
                    // InternalPerl.g:2389:3: 'study'
                    {
                     before(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 
                    match(input,251,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getStudyKeyword_182()); 

                    }


                    }
                    break;
                case 184 :
                    // InternalPerl.g:2394:2: ( 'sub' )
                    {
                    // InternalPerl.g:2394:2: ( 'sub' )
                    // InternalPerl.g:2395:3: 'sub'
                    {
                     before(grammarAccess.getKeywordAccess().getSubKeyword_183()); 
                    match(input,252,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubKeyword_183()); 

                    }


                    }
                    break;
                case 185 :
                    // InternalPerl.g:2400:2: ( 'substr' )
                    {
                    // InternalPerl.g:2400:2: ( 'substr' )
                    // InternalPerl.g:2401:3: 'substr'
                    {
                     before(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 
                    match(input,253,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSubstrKeyword_184()); 

                    }


                    }
                    break;
                case 186 :
                    // InternalPerl.g:2406:2: ( 'symlink' )
                    {
                    // InternalPerl.g:2406:2: ( 'symlink' )
                    // InternalPerl.g:2407:3: 'symlink'
                    {
                     before(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 
                    match(input,254,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSymlinkKeyword_185()); 

                    }


                    }
                    break;
                case 187 :
                    // InternalPerl.g:2412:2: ( 'syscall' )
                    {
                    // InternalPerl.g:2412:2: ( 'syscall' )
                    // InternalPerl.g:2413:3: 'syscall'
                    {
                     before(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 
                    match(input,255,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyscallKeyword_186()); 

                    }


                    }
                    break;
                case 188 :
                    // InternalPerl.g:2418:2: ( 'sysopen' )
                    {
                    // InternalPerl.g:2418:2: ( 'sysopen' )
                    // InternalPerl.g:2419:3: 'sysopen'
                    {
                     before(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 
                    match(input,256,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysopenKeyword_187()); 

                    }


                    }
                    break;
                case 189 :
                    // InternalPerl.g:2424:2: ( 'sysread' )
                    {
                    // InternalPerl.g:2424:2: ( 'sysread' )
                    // InternalPerl.g:2425:3: 'sysread'
                    {
                     before(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 
                    match(input,257,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysreadKeyword_188()); 

                    }


                    }
                    break;
                case 190 :
                    // InternalPerl.g:2430:2: ( 'sysseek' )
                    {
                    // InternalPerl.g:2430:2: ( 'sysseek' )
                    // InternalPerl.g:2431:3: 'sysseek'
                    {
                     before(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 
                    match(input,258,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSysseekKeyword_189()); 

                    }


                    }
                    break;
                case 191 :
                    // InternalPerl.g:2436:2: ( 'system' )
                    {
                    // InternalPerl.g:2436:2: ( 'system' )
                    // InternalPerl.g:2437:3: 'system'
                    {
                     before(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 
                    match(input,259,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSystemKeyword_190()); 

                    }


                    }
                    break;
                case 192 :
                    // InternalPerl.g:2442:2: ( 'syswrite' )
                    {
                    // InternalPerl.g:2442:2: ( 'syswrite' )
                    // InternalPerl.g:2443:3: 'syswrite'
                    {
                     before(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 
                    match(input,260,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getSyswriteKeyword_191()); 

                    }


                    }
                    break;
                case 193 :
                    // InternalPerl.g:2448:2: ( 'tell' )
                    {
                    // InternalPerl.g:2448:2: ( 'tell' )
                    // InternalPerl.g:2449:3: 'tell'
                    {
                     before(grammarAccess.getKeywordAccess().getTellKeyword_192()); 
                    match(input,261,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTellKeyword_192()); 

                    }


                    }
                    break;
                case 194 :
                    // InternalPerl.g:2454:2: ( 'telldir' )
                    {
                    // InternalPerl.g:2454:2: ( 'telldir' )
                    // InternalPerl.g:2455:3: 'telldir'
                    {
                     before(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 
                    match(input,262,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTelldirKeyword_193()); 

                    }


                    }
                    break;
                case 195 :
                    // InternalPerl.g:2460:2: ( 'tie' )
                    {
                    // InternalPerl.g:2460:2: ( 'tie' )
                    // InternalPerl.g:2461:3: 'tie'
                    {
                     before(grammarAccess.getKeywordAccess().getTieKeyword_194()); 
                    match(input,263,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTieKeyword_194()); 

                    }


                    }
                    break;
                case 196 :
                    // InternalPerl.g:2466:2: ( 'tied' )
                    {
                    // InternalPerl.g:2466:2: ( 'tied' )
                    // InternalPerl.g:2467:3: 'tied'
                    {
                     before(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 
                    match(input,264,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTiedKeyword_195()); 

                    }


                    }
                    break;
                case 197 :
                    // InternalPerl.g:2472:2: ( 'time' )
                    {
                    // InternalPerl.g:2472:2: ( 'time' )
                    // InternalPerl.g:2473:3: 'time'
                    {
                     before(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 
                    match(input,265,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimeKeyword_196()); 

                    }


                    }
                    break;
                case 198 :
                    // InternalPerl.g:2478:2: ( 'times' )
                    {
                    // InternalPerl.g:2478:2: ( 'times' )
                    // InternalPerl.g:2479:3: 'times'
                    {
                     before(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 
                    match(input,266,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTimesKeyword_197()); 

                    }


                    }
                    break;
                case 199 :
                    // InternalPerl.g:2484:2: ( 'tr' )
                    {
                    // InternalPerl.g:2484:2: ( 'tr' )
                    // InternalPerl.g:2485:3: 'tr'
                    {
                     before(grammarAccess.getKeywordAccess().getTrKeyword_198()); 
                    match(input,267,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTrKeyword_198()); 

                    }


                    }
                    break;
                case 200 :
                    // InternalPerl.g:2490:2: ( 'truncate' )
                    {
                    // InternalPerl.g:2490:2: ( 'truncate' )
                    // InternalPerl.g:2491:3: 'truncate'
                    {
                     before(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 
                    match(input,268,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getTruncateKeyword_199()); 

                    }


                    }
                    break;
                case 201 :
                    // InternalPerl.g:2496:2: ( 'uc' )
                    {
                    // InternalPerl.g:2496:2: ( 'uc' )
                    // InternalPerl.g:2497:3: 'uc'
                    {
                     before(grammarAccess.getKeywordAccess().getUcKeyword_200()); 
                    match(input,269,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcKeyword_200()); 

                    }


                    }
                    break;
                case 202 :
                    // InternalPerl.g:2502:2: ( 'ucfirst' )
                    {
                    // InternalPerl.g:2502:2: ( 'ucfirst' )
                    // InternalPerl.g:2503:3: 'ucfirst'
                    {
                     before(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 
                    match(input,270,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUcfirstKeyword_201()); 

                    }


                    }
                    break;
                case 203 :
                    // InternalPerl.g:2508:2: ( 'umask' )
                    {
                    // InternalPerl.g:2508:2: ( 'umask' )
                    // InternalPerl.g:2509:3: 'umask'
                    {
                     before(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 
                    match(input,271,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUmaskKeyword_202()); 

                    }


                    }
                    break;
                case 204 :
                    // InternalPerl.g:2514:2: ( 'undef' )
                    {
                    // InternalPerl.g:2514:2: ( 'undef' )
                    // InternalPerl.g:2515:3: 'undef'
                    {
                     before(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 
                    match(input,272,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUndefKeyword_203()); 

                    }


                    }
                    break;
                case 205 :
                    // InternalPerl.g:2520:2: ( 'unless' )
                    {
                    // InternalPerl.g:2520:2: ( 'unless' )
                    // InternalPerl.g:2521:3: 'unless'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 
                    match(input,273,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlessKeyword_204()); 

                    }


                    }
                    break;
                case 206 :
                    // InternalPerl.g:2526:2: ( 'unlink' )
                    {
                    // InternalPerl.g:2526:2: ( 'unlink' )
                    // InternalPerl.g:2527:3: 'unlink'
                    {
                     before(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 
                    match(input,274,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnlinkKeyword_205()); 

                    }


                    }
                    break;
                case 207 :
                    // InternalPerl.g:2532:2: ( 'unpack' )
                    {
                    // InternalPerl.g:2532:2: ( 'unpack' )
                    // InternalPerl.g:2533:3: 'unpack'
                    {
                     before(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 
                    match(input,275,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnpackKeyword_206()); 

                    }


                    }
                    break;
                case 208 :
                    // InternalPerl.g:2538:2: ( 'unshift' )
                    {
                    // InternalPerl.g:2538:2: ( 'unshift' )
                    // InternalPerl.g:2539:3: 'unshift'
                    {
                     before(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 
                    match(input,276,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUnshiftKeyword_207()); 

                    }


                    }
                    break;
                case 209 :
                    // InternalPerl.g:2544:2: ( 'untie' )
                    {
                    // InternalPerl.g:2544:2: ( 'untie' )
                    // InternalPerl.g:2545:3: 'untie'
                    {
                     before(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 
                    match(input,277,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntieKeyword_208()); 

                    }


                    }
                    break;
                case 210 :
                    // InternalPerl.g:2550:2: ( 'until' )
                    {
                    // InternalPerl.g:2550:2: ( 'until' )
                    // InternalPerl.g:2551:3: 'until'
                    {
                     before(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 
                    match(input,278,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUntilKeyword_209()); 

                    }


                    }
                    break;
                case 211 :
                    // InternalPerl.g:2556:2: ( 'use' )
                    {
                    // InternalPerl.g:2556:2: ( 'use' )
                    // InternalPerl.g:2557:3: 'use'
                    {
                     before(grammarAccess.getKeywordAccess().getUseKeyword_210()); 
                    match(input,279,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUseKeyword_210()); 

                    }


                    }
                    break;
                case 212 :
                    // InternalPerl.g:2562:2: ( 'utime' )
                    {
                    // InternalPerl.g:2562:2: ( 'utime' )
                    // InternalPerl.g:2563:3: 'utime'
                    {
                     before(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 
                    match(input,280,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getUtimeKeyword_211()); 

                    }


                    }
                    break;
                case 213 :
                    // InternalPerl.g:2568:2: ( 'values' )
                    {
                    // InternalPerl.g:2568:2: ( 'values' )
                    // InternalPerl.g:2569:3: 'values'
                    {
                     before(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 
                    match(input,281,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getValuesKeyword_212()); 

                    }


                    }
                    break;
                case 214 :
                    // InternalPerl.g:2574:2: ( 'vec' )
                    {
                    // InternalPerl.g:2574:2: ( 'vec' )
                    // InternalPerl.g:2575:3: 'vec'
                    {
                     before(grammarAccess.getKeywordAccess().getVecKeyword_213()); 
                    match(input,282,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getVecKeyword_213()); 

                    }


                    }
                    break;
                case 215 :
                    // InternalPerl.g:2580:2: ( 'wait' )
                    {
                    // InternalPerl.g:2580:2: ( 'wait' )
                    // InternalPerl.g:2581:3: 'wait'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 
                    match(input,283,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitKeyword_214()); 

                    }


                    }
                    break;
                case 216 :
                    // InternalPerl.g:2586:2: ( 'waitpid' )
                    {
                    // InternalPerl.g:2586:2: ( 'waitpid' )
                    // InternalPerl.g:2587:3: 'waitpid'
                    {
                     before(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 
                    match(input,284,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWaitpidKeyword_215()); 

                    }


                    }
                    break;
                case 217 :
                    // InternalPerl.g:2592:2: ( 'wantarray' )
                    {
                    // InternalPerl.g:2592:2: ( 'wantarray' )
                    // InternalPerl.g:2593:3: 'wantarray'
                    {
                     before(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 
                    match(input,285,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWantarrayKeyword_216()); 

                    }


                    }
                    break;
                case 218 :
                    // InternalPerl.g:2598:2: ( 'warn' )
                    {
                    // InternalPerl.g:2598:2: ( 'warn' )
                    // InternalPerl.g:2599:3: 'warn'
                    {
                     before(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 
                    match(input,286,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWarnKeyword_217()); 

                    }


                    }
                    break;
                case 219 :
                    // InternalPerl.g:2604:2: ( 'when' )
                    {
                    // InternalPerl.g:2604:2: ( 'when' )
                    // InternalPerl.g:2605:3: 'when'
                    {
                     before(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 
                    match(input,287,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhenKeyword_218()); 

                    }


                    }
                    break;
                case 220 :
                    // InternalPerl.g:2610:2: ( 'while' )
                    {
                    // InternalPerl.g:2610:2: ( 'while' )
                    // InternalPerl.g:2611:3: 'while'
                    {
                     before(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 
                    match(input,288,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWhileKeyword_219()); 

                    }


                    }
                    break;
                case 221 :
                    // InternalPerl.g:2616:2: ( 'write' )
                    {
                    // InternalPerl.g:2616:2: ( 'write' )
                    // InternalPerl.g:2617:3: 'write'
                    {
                     before(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 
                    match(input,289,FOLLOW_2); 
                     after(grammarAccess.getKeywordAccess().getWriteKeyword_220()); 

                    }


                    }
                    break;
                case 222 :
                    // InternalPerl.g:2622:2: ( 'y' )
                    {
                    // InternalPerl.g:2622:2: ( 'y' )
                    // InternalPerl.g:2623:3: 'y'
                    {
                     before(grammarAccess.getKeywordAccess().getYKeyword_221()); 
                    match(input,290,FOLLOW_2); 
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
    // InternalPerl.g:2632:1: rule__Operator__Alternatives : ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2636:1: ( ( '++' ) | ( '--' ) | ( '**' ) | ( '!' ) | ( '~' ) | ( '+' ) | ( '-' ) | ( '=~' ) | ( '!~' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( 'x' ) | ( '<<' ) | ( '>>' ) | ( 'lt' ) | ( 'gt' ) | ( 'le' ) | ( 'ge' ) | ( 'cmp' ) | ( '~~' ) | ( '==' ) | ( '!=' ) | ( ( rule__Operator__Group_23__0 ) ) | ( '..' ) | ( '...' ) | ( ',' ) | ( '&' ) | ( '|' ) | ( '^' ) | ( '&&' ) | ( '||' ) | ( '//' ) | ( '?' ) | ( ':' ) | ( '**=' ) | ( '+=' ) | ( '-=' ) | ( '.=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( 'x=' ) | ( '&=' ) | ( '|=' ) | ( '^=' ) | ( '<<=' ) | ( '>>=' ) | ( '&&=' ) | ( '||=' ) | ( '//=' ) | ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '<>' ) | ( '=>' ) | ( '->' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'not' ) | ( 'eq' ) | ( 'ne' ) )
            int alt17=64;
            switch ( input.LA(1) ) {
            case 291:
                {
                alt17=1;
                }
                break;
            case 292:
                {
                alt17=2;
                }
                break;
            case 293:
                {
                alt17=3;
                }
                break;
            case 294:
                {
                alt17=4;
                }
                break;
            case 295:
                {
                alt17=5;
                }
                break;
            case 296:
                {
                alt17=6;
                }
                break;
            case 297:
                {
                alt17=7;
                }
                break;
            case 298:
                {
                alt17=8;
                }
                break;
            case 299:
                {
                alt17=9;
                }
                break;
            case 300:
                {
                alt17=10;
                }
                break;
            case 301:
                {
                alt17=11;
                }
                break;
            case 69:
                {
                alt17=12;
                }
                break;
            case 302:
                {
                alt17=13;
                }
                break;
            case 303:
                {
                alt17=14;
                }
                break;
            case 304:
                {
                alt17=15;
                }
                break;
            case 305:
                {
                alt17=16;
                }
                break;
            case 306:
                {
                alt17=17;
                }
                break;
            case 307:
                {
                alt17=18;
                }
                break;
            case 308:
                {
                alt17=19;
                }
                break;
            case 309:
                {
                alt17=20;
                }
                break;
            case 310:
                {
                alt17=21;
                }
                break;
            case 311:
                {
                alt17=22;
                }
                break;
            case 312:
                {
                alt17=23;
                }
                break;
            case 385:
                {
                alt17=24;
                }
                break;
            case 313:
                {
                alt17=25;
                }
                break;
            case 314:
                {
                alt17=26;
                }
                break;
            case 315:
                {
                alt17=27;
                }
                break;
            case 71:
                {
                alt17=28;
                }
                break;
            case 316:
                {
                alt17=29;
                }
                break;
            case 317:
                {
                alt17=30;
                }
                break;
            case 318:
                {
                alt17=31;
                }
                break;
            case 319:
                {
                alt17=32;
                }
                break;
            case 320:
                {
                alt17=33;
                }
                break;
            case 321:
                {
                alt17=34;
                }
                break;
            case 322:
                {
                alt17=35;
                }
                break;
            case 323:
                {
                alt17=36;
                }
                break;
            case 324:
                {
                alt17=37;
                }
                break;
            case 325:
                {
                alt17=38;
                }
                break;
            case 326:
                {
                alt17=39;
                }
                break;
            case 327:
                {
                alt17=40;
                }
                break;
            case 328:
                {
                alt17=41;
                }
                break;
            case 329:
                {
                alt17=42;
                }
                break;
            case 330:
                {
                alt17=43;
                }
                break;
            case 331:
                {
                alt17=44;
                }
                break;
            case 332:
                {
                alt17=45;
                }
                break;
            case 333:
                {
                alt17=46;
                }
                break;
            case 334:
                {
                alt17=47;
                }
                break;
            case 335:
                {
                alt17=48;
                }
                break;
            case 336:
                {
                alt17=49;
                }
                break;
            case 337:
                {
                alt17=50;
                }
                break;
            case 338:
                {
                alt17=51;
                }
                break;
            case 339:
                {
                alt17=52;
                }
                break;
            case 340:
                {
                alt17=53;
                }
                break;
            case 341:
                {
                alt17=54;
                }
                break;
            case 342:
                {
                alt17=55;
                }
                break;
            case 343:
                {
                alt17=56;
                }
                break;
            case 344:
                {
                alt17=57;
                }
                break;
            case 345:
                {
                alt17=58;
                }
                break;
            case 346:
                {
                alt17=59;
                }
                break;
            case 347:
                {
                alt17=60;
                }
                break;
            case 348:
                {
                alt17=61;
                }
                break;
            case 349:
                {
                alt17=62;
                }
                break;
            case 350:
                {
                alt17=63;
                }
                break;
            case 351:
                {
                alt17=64;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalPerl.g:2637:2: ( '++' )
                    {
                    // InternalPerl.g:2637:2: ( '++' )
                    // InternalPerl.g:2638:3: '++'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 
                    match(input,291,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:2643:2: ( '--' )
                    {
                    // InternalPerl.g:2643:2: ( '--' )
                    // InternalPerl.g:2644:3: '--'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    match(input,292,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:2649:2: ( '**' )
                    {
                    // InternalPerl.g:2649:2: ( '**' )
                    // InternalPerl.g:2650:3: '**'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 
                    match(input,293,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:2655:2: ( '!' )
                    {
                    // InternalPerl.g:2655:2: ( '!' )
                    // InternalPerl.g:2656:3: '!'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 
                    match(input,294,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:2661:2: ( '~' )
                    {
                    // InternalPerl.g:2661:2: ( '~' )
                    // InternalPerl.g:2662:3: '~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 
                    match(input,295,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:2667:2: ( '+' )
                    {
                    // InternalPerl.g:2667:2: ( '+' )
                    // InternalPerl.g:2668:3: '+'
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 
                    match(input,296,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:2673:2: ( '-' )
                    {
                    // InternalPerl.g:2673:2: ( '-' )
                    // InternalPerl.g:2674:3: '-'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 
                    match(input,297,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:2679:2: ( '=~' )
                    {
                    // InternalPerl.g:2679:2: ( '=~' )
                    // InternalPerl.g:2680:3: '=~'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 
                    match(input,298,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:2685:2: ( '!~' )
                    {
                    // InternalPerl.g:2685:2: ( '!~' )
                    // InternalPerl.g:2686:3: '!~'
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 
                    match(input,299,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:2691:2: ( '*' )
                    {
                    // InternalPerl.g:2691:2: ( '*' )
                    // InternalPerl.g:2692:3: '*'
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 
                    match(input,300,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:2697:2: ( '/' )
                    {
                    // InternalPerl.g:2697:2: ( '/' )
                    // InternalPerl.g:2698:3: '/'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 
                    match(input,301,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:2703:2: ( '%' )
                    {
                    // InternalPerl.g:2703:2: ( '%' )
                    // InternalPerl.g:2704:3: '%'
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:2709:2: ( 'x' )
                    {
                    // InternalPerl.g:2709:2: ( 'x' )
                    // InternalPerl.g:2710:3: 'x'
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_12()); 
                    match(input,302,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:2715:2: ( '<<' )
                    {
                    // InternalPerl.g:2715:2: ( '<<' )
                    // InternalPerl.g:2716:3: '<<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 
                    match(input,303,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:2721:2: ( '>>' )
                    {
                    // InternalPerl.g:2721:2: ( '>>' )
                    // InternalPerl.g:2722:3: '>>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 
                    match(input,304,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:2727:2: ( 'lt' )
                    {
                    // InternalPerl.g:2727:2: ( 'lt' )
                    // InternalPerl.g:2728:3: 'lt'
                    {
                     before(grammarAccess.getOperatorAccess().getLtKeyword_15()); 
                    match(input,305,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLtKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:2733:2: ( 'gt' )
                    {
                    // InternalPerl.g:2733:2: ( 'gt' )
                    // InternalPerl.g:2734:3: 'gt'
                    {
                     before(grammarAccess.getOperatorAccess().getGtKeyword_16()); 
                    match(input,306,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGtKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:2739:2: ( 'le' )
                    {
                    // InternalPerl.g:2739:2: ( 'le' )
                    // InternalPerl.g:2740:3: 'le'
                    {
                     before(grammarAccess.getOperatorAccess().getLeKeyword_17()); 
                    match(input,307,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLeKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:2745:2: ( 'ge' )
                    {
                    // InternalPerl.g:2745:2: ( 'ge' )
                    // InternalPerl.g:2746:3: 'ge'
                    {
                     before(grammarAccess.getOperatorAccess().getGeKeyword_18()); 
                    match(input,308,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGeKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:2751:2: ( 'cmp' )
                    {
                    // InternalPerl.g:2751:2: ( 'cmp' )
                    // InternalPerl.g:2752:3: 'cmp'
                    {
                     before(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 
                    match(input,309,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCmpKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:2757:2: ( '~~' )
                    {
                    // InternalPerl.g:2757:2: ( '~~' )
                    // InternalPerl.g:2758:3: '~~'
                    {
                     before(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 
                    match(input,310,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getTildeTildeKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:2763:2: ( '==' )
                    {
                    // InternalPerl.g:2763:2: ( '==' )
                    // InternalPerl.g:2764:3: '=='
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 
                    match(input,311,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:2769:2: ( '!=' )
                    {
                    // InternalPerl.g:2769:2: ( '!=' )
                    // InternalPerl.g:2770:3: '!='
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 
                    match(input,312,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:2775:2: ( ( rule__Operator__Group_23__0 ) )
                    {
                    // InternalPerl.g:2775:2: ( ( rule__Operator__Group_23__0 ) )
                    // InternalPerl.g:2776:3: ( rule__Operator__Group_23__0 )
                    {
                     before(grammarAccess.getOperatorAccess().getGroup_23()); 
                    // InternalPerl.g:2777:3: ( rule__Operator__Group_23__0 )
                    // InternalPerl.g:2777:4: rule__Operator__Group_23__0
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
                    // InternalPerl.g:2781:2: ( '..' )
                    {
                    // InternalPerl.g:2781:2: ( '..' )
                    // InternalPerl.g:2782:3: '..'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 
                    match(input,313,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:2787:2: ( '...' )
                    {
                    // InternalPerl.g:2787:2: ( '...' )
                    // InternalPerl.g:2788:3: '...'
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 
                    match(input,314,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:2793:2: ( ',' )
                    {
                    // InternalPerl.g:2793:2: ( ',' )
                    // InternalPerl.g:2794:3: ','
                    {
                     before(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 
                    match(input,315,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCommaKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalPerl.g:2799:2: ( '&' )
                    {
                    // InternalPerl.g:2799:2: ( '&' )
                    // InternalPerl.g:2800:3: '&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalPerl.g:2805:2: ( '|' )
                    {
                    // InternalPerl.g:2805:2: ( '|' )
                    // InternalPerl.g:2806:3: '|'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 
                    match(input,316,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalPerl.g:2811:2: ( '^' )
                    {
                    // InternalPerl.g:2811:2: ( '^' )
                    // InternalPerl.g:2812:3: '^'
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 
                    match(input,317,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalPerl.g:2817:2: ( '&&' )
                    {
                    // InternalPerl.g:2817:2: ( '&&' )
                    // InternalPerl.g:2818:3: '&&'
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 
                    match(input,318,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalPerl.g:2823:2: ( '||' )
                    {
                    // InternalPerl.g:2823:2: ( '||' )
                    // InternalPerl.g:2824:3: '||'
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 
                    match(input,319,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalPerl.g:2829:2: ( '//' )
                    {
                    // InternalPerl.g:2829:2: ( '//' )
                    // InternalPerl.g:2830:3: '//'
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 
                    match(input,320,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalPerl.g:2835:2: ( '?' )
                    {
                    // InternalPerl.g:2835:2: ( '?' )
                    // InternalPerl.g:2836:3: '?'
                    {
                     before(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 
                    match(input,321,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalPerl.g:2841:2: ( ':' )
                    {
                    // InternalPerl.g:2841:2: ( ':' )
                    // InternalPerl.g:2842:3: ':'
                    {
                     before(grammarAccess.getOperatorAccess().getColonKeyword_34()); 
                    match(input,322,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getColonKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalPerl.g:2847:2: ( '**=' )
                    {
                    // InternalPerl.g:2847:2: ( '**=' )
                    // InternalPerl.g:2848:3: '**='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 
                    match(input,323,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalPerl.g:2853:2: ( '+=' )
                    {
                    // InternalPerl.g:2853:2: ( '+=' )
                    // InternalPerl.g:2854:3: '+='
                    {
                     before(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 
                    match(input,324,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalPerl.g:2859:2: ( '-=' )
                    {
                    // InternalPerl.g:2859:2: ( '-=' )
                    // InternalPerl.g:2860:3: '-='
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 
                    match(input,325,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalPerl.g:2865:2: ( '.=' )
                    {
                    // InternalPerl.g:2865:2: ( '.=' )
                    // InternalPerl.g:2866:3: '.='
                    {
                     before(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 
                    match(input,326,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalPerl.g:2871:2: ( '*=' )
                    {
                    // InternalPerl.g:2871:2: ( '*=' )
                    // InternalPerl.g:2872:3: '*='
                    {
                     before(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 
                    match(input,327,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalPerl.g:2877:2: ( '/=' )
                    {
                    // InternalPerl.g:2877:2: ( '/=' )
                    // InternalPerl.g:2878:3: '/='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 
                    match(input,328,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalPerl.g:2883:2: ( '%=' )
                    {
                    // InternalPerl.g:2883:2: ( '%=' )
                    // InternalPerl.g:2884:3: '%='
                    {
                     before(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 
                    match(input,329,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalPerl.g:2889:2: ( 'x=' )
                    {
                    // InternalPerl.g:2889:2: ( 'x=' )
                    // InternalPerl.g:2890:3: 'x='
                    {
                     before(grammarAccess.getOperatorAccess().getXKeyword_42()); 
                    match(input,330,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalPerl.g:2895:2: ( '&=' )
                    {
                    // InternalPerl.g:2895:2: ( '&=' )
                    // InternalPerl.g:2896:3: '&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 
                    match(input,331,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalPerl.g:2901:2: ( '|=' )
                    {
                    // InternalPerl.g:2901:2: ( '|=' )
                    // InternalPerl.g:2902:3: '|='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 
                    match(input,332,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalPerl.g:2907:2: ( '^=' )
                    {
                    // InternalPerl.g:2907:2: ( '^=' )
                    // InternalPerl.g:2908:3: '^='
                    {
                     before(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 
                    match(input,333,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalPerl.g:2913:2: ( '<<=' )
                    {
                    // InternalPerl.g:2913:2: ( '<<=' )
                    // InternalPerl.g:2914:3: '<<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 
                    match(input,334,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalPerl.g:2919:2: ( '>>=' )
                    {
                    // InternalPerl.g:2919:2: ( '>>=' )
                    // InternalPerl.g:2920:3: '>>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 
                    match(input,335,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalPerl.g:2925:2: ( '&&=' )
                    {
                    // InternalPerl.g:2925:2: ( '&&=' )
                    // InternalPerl.g:2926:3: '&&='
                    {
                     before(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 
                    match(input,336,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalPerl.g:2931:2: ( '||=' )
                    {
                    // InternalPerl.g:2931:2: ( '||=' )
                    // InternalPerl.g:2932:3: '||='
                    {
                     before(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 
                    match(input,337,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalPerl.g:2937:2: ( '//=' )
                    {
                    // InternalPerl.g:2937:2: ( '//=' )
                    // InternalPerl.g:2938:3: '//='
                    {
                     before(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 
                    match(input,338,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalPerl.g:2943:2: ( '<' )
                    {
                    // InternalPerl.g:2943:2: ( '<' )
                    // InternalPerl.g:2944:3: '<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 
                    match(input,339,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalPerl.g:2949:2: ( '>' )
                    {
                    // InternalPerl.g:2949:2: ( '>' )
                    // InternalPerl.g:2950:3: '>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 
                    match(input,340,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalPerl.g:2955:2: ( '<=' )
                    {
                    // InternalPerl.g:2955:2: ( '<=' )
                    // InternalPerl.g:2956:3: '<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 
                    match(input,341,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalPerl.g:2961:2: ( '>=' )
                    {
                    // InternalPerl.g:2961:2: ( '>=' )
                    // InternalPerl.g:2962:3: '>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 
                    match(input,342,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalPerl.g:2967:2: ( '<>' )
                    {
                    // InternalPerl.g:2967:2: ( '<>' )
                    // InternalPerl.g:2968:3: '<>'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 
                    match(input,343,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalPerl.g:2973:2: ( '=>' )
                    {
                    // InternalPerl.g:2973:2: ( '=>' )
                    // InternalPerl.g:2974:3: '=>'
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 
                    match(input,344,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalPerl.g:2979:2: ( '->' )
                    {
                    // InternalPerl.g:2979:2: ( '->' )
                    // InternalPerl.g:2980:3: '->'
                    {
                     before(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 
                    match(input,345,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalPerl.g:2985:2: ( 'and' )
                    {
                    // InternalPerl.g:2985:2: ( 'and' )
                    // InternalPerl.g:2986:3: 'and'
                    {
                     before(grammarAccess.getOperatorAccess().getAndKeyword_58()); 
                    match(input,346,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getAndKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalPerl.g:2991:2: ( 'or' )
                    {
                    // InternalPerl.g:2991:2: ( 'or' )
                    // InternalPerl.g:2992:3: 'or'
                    {
                     before(grammarAccess.getOperatorAccess().getOrKeyword_59()); 
                    match(input,347,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getOrKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalPerl.g:2997:2: ( 'xor' )
                    {
                    // InternalPerl.g:2997:2: ( 'xor' )
                    // InternalPerl.g:2998:3: 'xor'
                    {
                     before(grammarAccess.getOperatorAccess().getXorKeyword_60()); 
                    match(input,348,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getXorKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalPerl.g:3003:2: ( 'not' )
                    {
                    // InternalPerl.g:3003:2: ( 'not' )
                    // InternalPerl.g:3004:3: 'not'
                    {
                     before(grammarAccess.getOperatorAccess().getNotKeyword_61()); 
                    match(input,349,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getNotKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalPerl.g:3009:2: ( 'eq' )
                    {
                    // InternalPerl.g:3009:2: ( 'eq' )
                    // InternalPerl.g:3010:3: 'eq'
                    {
                     before(grammarAccess.getOperatorAccess().getEqKeyword_62()); 
                    match(input,350,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalPerl.g:3015:2: ( 'ne' )
                    {
                    // InternalPerl.g:3015:2: ( 'ne' )
                    // InternalPerl.g:3016:3: 'ne'
                    {
                     before(grammarAccess.getOperatorAccess().getNeKeyword_63()); 
                    match(input,351,FOLLOW_2); 
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
    // InternalPerl.g:3025:1: rule__FileTestOperator__Alternatives : ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) );
    public final void rule__FileTestOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3029:1: ( ( '-r' ) | ( '-w' ) | ( '-x' ) | ( '-o' ) | ( '-R' ) | ( '-W' ) | ( '-X' ) | ( '-O' ) | ( '-e' ) | ( '-z' ) | ( '-s' ) | ( '-f' ) | ( '-d' ) | ( '-l' ) | ( '-p' ) | ( '-S' ) | ( '-b' ) | ( '-c' ) | ( '-t' ) | ( '-u' ) | ( '-g' ) | ( '-k' ) | ( '-T' ) | ( '-B' ) | ( '-M' ) | ( '-A' ) | ( '-C' ) )
            int alt18=27;
            switch ( input.LA(1) ) {
            case 352:
                {
                alt18=1;
                }
                break;
            case 353:
                {
                alt18=2;
                }
                break;
            case 354:
                {
                alt18=3;
                }
                break;
            case 355:
                {
                alt18=4;
                }
                break;
            case 356:
                {
                alt18=5;
                }
                break;
            case 357:
                {
                alt18=6;
                }
                break;
            case 358:
                {
                alt18=7;
                }
                break;
            case 359:
                {
                alt18=8;
                }
                break;
            case 360:
                {
                alt18=9;
                }
                break;
            case 361:
                {
                alt18=10;
                }
                break;
            case 362:
                {
                alt18=11;
                }
                break;
            case 363:
                {
                alt18=12;
                }
                break;
            case 364:
                {
                alt18=13;
                }
                break;
            case 365:
                {
                alt18=14;
                }
                break;
            case 366:
                {
                alt18=15;
                }
                break;
            case 367:
                {
                alt18=16;
                }
                break;
            case 368:
                {
                alt18=17;
                }
                break;
            case 369:
                {
                alt18=18;
                }
                break;
            case 370:
                {
                alt18=19;
                }
                break;
            case 371:
                {
                alt18=20;
                }
                break;
            case 372:
                {
                alt18=21;
                }
                break;
            case 373:
                {
                alt18=22;
                }
                break;
            case 374:
                {
                alt18=23;
                }
                break;
            case 375:
                {
                alt18=24;
                }
                break;
            case 376:
                {
                alt18=25;
                }
                break;
            case 377:
                {
                alt18=26;
                }
                break;
            case 378:
                {
                alt18=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalPerl.g:3030:2: ( '-r' )
                    {
                    // InternalPerl.g:3030:2: ( '-r' )
                    // InternalPerl.g:3031:3: '-r'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 
                    match(input,352,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:3036:2: ( '-w' )
                    {
                    // InternalPerl.g:3036:2: ( '-w' )
                    // InternalPerl.g:3037:3: '-w'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 
                    match(input,353,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:3042:2: ( '-x' )
                    {
                    // InternalPerl.g:3042:2: ( '-x' )
                    // InternalPerl.g:3043:3: '-x'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 
                    match(input,354,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:3048:2: ( '-o' )
                    {
                    // InternalPerl.g:3048:2: ( '-o' )
                    // InternalPerl.g:3049:3: '-o'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 
                    match(input,355,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:3054:2: ( '-R' )
                    {
                    // InternalPerl.g:3054:2: ( '-R' )
                    // InternalPerl.g:3055:3: '-R'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 
                    match(input,356,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getRKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:3060:2: ( '-W' )
                    {
                    // InternalPerl.g:3060:2: ( '-W' )
                    // InternalPerl.g:3061:3: '-W'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 
                    match(input,357,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getWKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:3066:2: ( '-X' )
                    {
                    // InternalPerl.g:3066:2: ( '-X' )
                    // InternalPerl.g:3067:3: '-X'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 
                    match(input,358,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getXKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:3072:2: ( '-O' )
                    {
                    // InternalPerl.g:3072:2: ( '-O' )
                    // InternalPerl.g:3073:3: '-O'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 
                    match(input,359,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getOKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:3078:2: ( '-e' )
                    {
                    // InternalPerl.g:3078:2: ( '-e' )
                    // InternalPerl.g:3079:3: '-e'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 
                    match(input,360,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getEKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPerl.g:3084:2: ( '-z' )
                    {
                    // InternalPerl.g:3084:2: ( '-z' )
                    // InternalPerl.g:3085:3: '-z'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 
                    match(input,361,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getZKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:3090:2: ( '-s' )
                    {
                    // InternalPerl.g:3090:2: ( '-s' )
                    // InternalPerl.g:3091:3: '-s'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 
                    match(input,362,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPerl.g:3096:2: ( '-f' )
                    {
                    // InternalPerl.g:3096:2: ( '-f' )
                    // InternalPerl.g:3097:3: '-f'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 
                    match(input,363,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getFKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPerl.g:3102:2: ( '-d' )
                    {
                    // InternalPerl.g:3102:2: ( '-d' )
                    // InternalPerl.g:3103:3: '-d'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 
                    match(input,364,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getDKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPerl.g:3108:2: ( '-l' )
                    {
                    // InternalPerl.g:3108:2: ( '-l' )
                    // InternalPerl.g:3109:3: '-l'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 
                    match(input,365,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getLKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPerl.g:3114:2: ( '-p' )
                    {
                    // InternalPerl.g:3114:2: ( '-p' )
                    // InternalPerl.g:3115:3: '-p'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 
                    match(input,366,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getPKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalPerl.g:3120:2: ( '-S' )
                    {
                    // InternalPerl.g:3120:2: ( '-S' )
                    // InternalPerl.g:3121:3: '-S'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 
                    match(input,367,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getSKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalPerl.g:3126:2: ( '-b' )
                    {
                    // InternalPerl.g:3126:2: ( '-b' )
                    // InternalPerl.g:3127:3: '-b'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 
                    match(input,368,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalPerl.g:3132:2: ( '-c' )
                    {
                    // InternalPerl.g:3132:2: ( '-c' )
                    // InternalPerl.g:3133:3: '-c'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 
                    match(input,369,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getCKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalPerl.g:3138:2: ( '-t' )
                    {
                    // InternalPerl.g:3138:2: ( '-t' )
                    // InternalPerl.g:3139:3: '-t'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 
                    match(input,370,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalPerl.g:3144:2: ( '-u' )
                    {
                    // InternalPerl.g:3144:2: ( '-u' )
                    // InternalPerl.g:3145:3: '-u'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 
                    match(input,371,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getUKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalPerl.g:3150:2: ( '-g' )
                    {
                    // InternalPerl.g:3150:2: ( '-g' )
                    // InternalPerl.g:3151:3: '-g'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 
                    match(input,372,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getGKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalPerl.g:3156:2: ( '-k' )
                    {
                    // InternalPerl.g:3156:2: ( '-k' )
                    // InternalPerl.g:3157:3: '-k'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 
                    match(input,373,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getKKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalPerl.g:3162:2: ( '-T' )
                    {
                    // InternalPerl.g:3162:2: ( '-T' )
                    // InternalPerl.g:3163:3: '-T'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 
                    match(input,374,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getTKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalPerl.g:3168:2: ( '-B' )
                    {
                    // InternalPerl.g:3168:2: ( '-B' )
                    // InternalPerl.g:3169:3: '-B'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 
                    match(input,375,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getBKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:3174:2: ( '-M' )
                    {
                    // InternalPerl.g:3174:2: ( '-M' )
                    // InternalPerl.g:3175:3: '-M'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 
                    match(input,376,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getMKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalPerl.g:3180:2: ( '-A' )
                    {
                    // InternalPerl.g:3180:2: ( '-A' )
                    // InternalPerl.g:3181:3: '-A'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 
                    match(input,377,FOLLOW_2); 
                     after(grammarAccess.getFileTestOperatorAccess().getAKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalPerl.g:3186:2: ( '-C' )
                    {
                    // InternalPerl.g:3186:2: ( '-C' )
                    // InternalPerl.g:3187:3: '-C'
                    {
                     before(grammarAccess.getFileTestOperatorAccess().getCKeyword_26()); 
                    match(input,378,FOLLOW_2); 
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


    // $ANTLR start "rule__QUALIFIED_ID__Alternatives_1_0"
    // InternalPerl.g:3196:1: rule__QUALIFIED_ID__Alternatives_1_0 : ( ( '::' ) | ( '\\'' ) );
    public final void rule__QUALIFIED_ID__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3200:1: ( ( '::' ) | ( '\\'' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==379) ) {
                alt19=1;
            }
            else if ( (LA19_0==380) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalPerl.g:3201:2: ( '::' )
                    {
                    // InternalPerl.g:3201:2: ( '::' )
                    // InternalPerl.g:3202:3: '::'
                    {
                     before(grammarAccess.getQUALIFIED_IDAccess().getColonColonKeyword_1_0_0()); 
                    match(input,379,FOLLOW_2); 
                     after(grammarAccess.getQUALIFIED_IDAccess().getColonColonKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:3207:2: ( '\\'' )
                    {
                    // InternalPerl.g:3207:2: ( '\\'' )
                    // InternalPerl.g:3208:3: '\\''
                    {
                     before(grammarAccess.getQUALIFIED_IDAccess().getApostropheKeyword_1_0_1()); 
                    match(input,380,FOLLOW_2); 
                     after(grammarAccess.getQUALIFIED_IDAccess().getApostropheKeyword_1_0_1()); 

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
    // $ANTLR end "rule__QUALIFIED_ID__Alternatives_1_0"


    // $ANTLR start "rule__PerlDocument__Group__0"
    // InternalPerl.g:3217:1: rule__PerlDocument__Group__0 : rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 ;
    public final void rule__PerlDocument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3221:1: ( rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1 )
            // InternalPerl.g:3222:2: rule__PerlDocument__Group__0__Impl rule__PerlDocument__Group__1
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
    // InternalPerl.g:3229:1: rule__PerlDocument__Group__0__Impl : ( () ) ;
    public final void rule__PerlDocument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3233:1: ( ( () ) )
            // InternalPerl.g:3234:1: ( () )
            {
            // InternalPerl.g:3234:1: ( () )
            // InternalPerl.g:3235:2: ()
            {
             before(grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0()); 
            // InternalPerl.g:3236:2: ()
            // InternalPerl.g:3236:3: 
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
    // InternalPerl.g:3244:1: rule__PerlDocument__Group__1 : rule__PerlDocument__Group__1__Impl ;
    public final void rule__PerlDocument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3248:1: ( rule__PerlDocument__Group__1__Impl )
            // InternalPerl.g:3249:2: rule__PerlDocument__Group__1__Impl
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
    // InternalPerl.g:3255:1: rule__PerlDocument__Group__1__Impl : ( ( rule__PerlDocument__ElementsAssignment_1 )* ) ;
    public final void rule__PerlDocument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3259:1: ( ( ( rule__PerlDocument__ElementsAssignment_1 )* ) )
            // InternalPerl.g:3260:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            {
            // InternalPerl.g:3260:1: ( ( rule__PerlDocument__ElementsAssignment_1 )* )
            // InternalPerl.g:3261:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            {
             before(grammarAccess.getPerlDocumentAccess().getElementsAssignment_1()); 
            // InternalPerl.g:3262:2: ( rule__PerlDocument__ElementsAssignment_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_REGEX_MATCH)||(LA20_0>=RULE_WORDS_QUOTE_LIKE && LA20_0<=RULE_READLINE_QUOTE)||LA20_0==44||LA20_0==50||LA20_0==57||LA20_0==69||(LA20_0>=71 && LA20_0<=378)||LA20_0==381||LA20_0==385) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalPerl.g:3262:3: rule__PerlDocument__ElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__PerlDocument__ElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalPerl.g:3271:1: rule__ExpressionStatement__Group__0 : rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1 ;
    public final void rule__ExpressionStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3275:1: ( rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1 )
            // InternalPerl.g:3276:2: rule__ExpressionStatement__Group__0__Impl rule__ExpressionStatement__Group__1
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
    // InternalPerl.g:3283:1: rule__ExpressionStatement__Group__0__Impl : ( ( rule__ExpressionStatement__Alternatives_0 ) ) ;
    public final void rule__ExpressionStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3287:1: ( ( ( rule__ExpressionStatement__Alternatives_0 ) ) )
            // InternalPerl.g:3288:1: ( ( rule__ExpressionStatement__Alternatives_0 ) )
            {
            // InternalPerl.g:3288:1: ( ( rule__ExpressionStatement__Alternatives_0 ) )
            // InternalPerl.g:3289:2: ( rule__ExpressionStatement__Alternatives_0 )
            {
             before(grammarAccess.getExpressionStatementAccess().getAlternatives_0()); 
            // InternalPerl.g:3290:2: ( rule__ExpressionStatement__Alternatives_0 )
            // InternalPerl.g:3290:3: rule__ExpressionStatement__Alternatives_0
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
    // InternalPerl.g:3298:1: rule__ExpressionStatement__Group__1 : rule__ExpressionStatement__Group__1__Impl ;
    public final void rule__ExpressionStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3302:1: ( rule__ExpressionStatement__Group__1__Impl )
            // InternalPerl.g:3303:2: rule__ExpressionStatement__Group__1__Impl
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
    // InternalPerl.g:3309:1: rule__ExpressionStatement__Group__1__Impl : ( ';' ) ;
    public final void rule__ExpressionStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3313:1: ( ( ';' ) )
            // InternalPerl.g:3314:1: ( ';' )
            {
            // InternalPerl.g:3314:1: ( ';' )
            // InternalPerl.g:3315:2: ';'
            {
             before(grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1()); 
            match(input,67,FOLLOW_2); 
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
    // InternalPerl.g:3325:1: rule__PackageStatement__Group__0 : rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 ;
    public final void rule__PackageStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3329:1: ( rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1 )
            // InternalPerl.g:3330:2: rule__PackageStatement__Group__0__Impl rule__PackageStatement__Group__1
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
    // InternalPerl.g:3337:1: rule__PackageStatement__Group__0__Impl : ( () ) ;
    public final void rule__PackageStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3341:1: ( ( () ) )
            // InternalPerl.g:3342:1: ( () )
            {
            // InternalPerl.g:3342:1: ( () )
            // InternalPerl.g:3343:2: ()
            {
             before(grammarAccess.getPackageStatementAccess().getPackageStatementAction_0()); 
            // InternalPerl.g:3344:2: ()
            // InternalPerl.g:3344:3: 
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
    // InternalPerl.g:3352:1: rule__PackageStatement__Group__1 : rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 ;
    public final void rule__PackageStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3356:1: ( rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2 )
            // InternalPerl.g:3357:2: rule__PackageStatement__Group__1__Impl rule__PackageStatement__Group__2
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
    // InternalPerl.g:3364:1: rule__PackageStatement__Group__1__Impl : ( 'package' ) ;
    public final void rule__PackageStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3368:1: ( ( 'package' ) )
            // InternalPerl.g:3369:1: ( 'package' )
            {
            // InternalPerl.g:3369:1: ( 'package' )
            // InternalPerl.g:3370:2: 'package'
            {
             before(grammarAccess.getPackageStatementAccess().getPackageKeyword_1()); 
            match(input,190,FOLLOW_2); 
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
    // InternalPerl.g:3379:1: rule__PackageStatement__Group__2 : rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3 ;
    public final void rule__PackageStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3383:1: ( rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3 )
            // InternalPerl.g:3384:2: rule__PackageStatement__Group__2__Impl rule__PackageStatement__Group__3
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
    // InternalPerl.g:3391:1: rule__PackageStatement__Group__2__Impl : ( ( rule__PackageStatement__NameAssignment_2 ) ) ;
    public final void rule__PackageStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3395:1: ( ( ( rule__PackageStatement__NameAssignment_2 ) ) )
            // InternalPerl.g:3396:1: ( ( rule__PackageStatement__NameAssignment_2 ) )
            {
            // InternalPerl.g:3396:1: ( ( rule__PackageStatement__NameAssignment_2 ) )
            // InternalPerl.g:3397:2: ( rule__PackageStatement__NameAssignment_2 )
            {
             before(grammarAccess.getPackageStatementAccess().getNameAssignment_2()); 
            // InternalPerl.g:3398:2: ( rule__PackageStatement__NameAssignment_2 )
            // InternalPerl.g:3398:3: rule__PackageStatement__NameAssignment_2
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
    // InternalPerl.g:3406:1: rule__PackageStatement__Group__3 : rule__PackageStatement__Group__3__Impl ;
    public final void rule__PackageStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3410:1: ( rule__PackageStatement__Group__3__Impl )
            // InternalPerl.g:3411:2: rule__PackageStatement__Group__3__Impl
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
    // InternalPerl.g:3417:1: rule__PackageStatement__Group__3__Impl : ( ( rule__PackageStatement__VersionAssignment_3 )? ) ;
    public final void rule__PackageStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3421:1: ( ( ( rule__PackageStatement__VersionAssignment_3 )? ) )
            // InternalPerl.g:3422:1: ( ( rule__PackageStatement__VersionAssignment_3 )? )
            {
            // InternalPerl.g:3422:1: ( ( rule__PackageStatement__VersionAssignment_3 )? )
            // InternalPerl.g:3423:2: ( rule__PackageStatement__VersionAssignment_3 )?
            {
             before(grammarAccess.getPackageStatementAccess().getVersionAssignment_3()); 
            // InternalPerl.g:3424:2: ( rule__PackageStatement__VersionAssignment_3 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_VERSION) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalPerl.g:3424:3: rule__PackageStatement__VersionAssignment_3
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
    // InternalPerl.g:3433:1: rule__RequireInclude__Group__0 : rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1 ;
    public final void rule__RequireInclude__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3437:1: ( rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1 )
            // InternalPerl.g:3438:2: rule__RequireInclude__Group__0__Impl rule__RequireInclude__Group__1
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
    // InternalPerl.g:3445:1: rule__RequireInclude__Group__0__Impl : ( 'require' ) ;
    public final void rule__RequireInclude__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3449:1: ( ( 'require' ) )
            // InternalPerl.g:3450:1: ( 'require' )
            {
            // InternalPerl.g:3450:1: ( 'require' )
            // InternalPerl.g:3451:2: 'require'
            {
             before(grammarAccess.getRequireIncludeAccess().getRequireKeyword_0()); 
            match(input,209,FOLLOW_2); 
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
    // InternalPerl.g:3460:1: rule__RequireInclude__Group__1 : rule__RequireInclude__Group__1__Impl ;
    public final void rule__RequireInclude__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3464:1: ( rule__RequireInclude__Group__1__Impl )
            // InternalPerl.g:3465:2: rule__RequireInclude__Group__1__Impl
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
    // InternalPerl.g:3471:1: rule__RequireInclude__Group__1__Impl : ( ( rule__RequireInclude__VersionAssignment_1 ) ) ;
    public final void rule__RequireInclude__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3475:1: ( ( ( rule__RequireInclude__VersionAssignment_1 ) ) )
            // InternalPerl.g:3476:1: ( ( rule__RequireInclude__VersionAssignment_1 ) )
            {
            // InternalPerl.g:3476:1: ( ( rule__RequireInclude__VersionAssignment_1 ) )
            // InternalPerl.g:3477:2: ( rule__RequireInclude__VersionAssignment_1 )
            {
             before(grammarAccess.getRequireIncludeAccess().getVersionAssignment_1()); 
            // InternalPerl.g:3478:2: ( rule__RequireInclude__VersionAssignment_1 )
            // InternalPerl.g:3478:3: rule__RequireInclude__VersionAssignment_1
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
    // InternalPerl.g:3487:1: rule__UseInclude__Group__0 : rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1 ;
    public final void rule__UseInclude__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3491:1: ( rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1 )
            // InternalPerl.g:3492:2: rule__UseInclude__Group__0__Impl rule__UseInclude__Group__1
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
    // InternalPerl.g:3499:1: rule__UseInclude__Group__0__Impl : ( () ) ;
    public final void rule__UseInclude__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3503:1: ( ( () ) )
            // InternalPerl.g:3504:1: ( () )
            {
            // InternalPerl.g:3504:1: ( () )
            // InternalPerl.g:3505:2: ()
            {
             before(grammarAccess.getUseIncludeAccess().getUseIncludeAction_0()); 
            // InternalPerl.g:3506:2: ()
            // InternalPerl.g:3506:3: 
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
    // InternalPerl.g:3514:1: rule__UseInclude__Group__1 : rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2 ;
    public final void rule__UseInclude__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3518:1: ( rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2 )
            // InternalPerl.g:3519:2: rule__UseInclude__Group__1__Impl rule__UseInclude__Group__2
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
    // InternalPerl.g:3526:1: rule__UseInclude__Group__1__Impl : ( 'use' ) ;
    public final void rule__UseInclude__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3530:1: ( ( 'use' ) )
            // InternalPerl.g:3531:1: ( 'use' )
            {
            // InternalPerl.g:3531:1: ( 'use' )
            // InternalPerl.g:3532:2: 'use'
            {
             before(grammarAccess.getUseIncludeAccess().getUseKeyword_1()); 
            match(input,279,FOLLOW_2); 
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
    // InternalPerl.g:3541:1: rule__UseInclude__Group__2 : rule__UseInclude__Group__2__Impl ;
    public final void rule__UseInclude__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3545:1: ( rule__UseInclude__Group__2__Impl )
            // InternalPerl.g:3546:2: rule__UseInclude__Group__2__Impl
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
    // InternalPerl.g:3552:1: rule__UseInclude__Group__2__Impl : ( ( rule__UseInclude__Alternatives_2 ) ) ;
    public final void rule__UseInclude__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3556:1: ( ( ( rule__UseInclude__Alternatives_2 ) ) )
            // InternalPerl.g:3557:1: ( ( rule__UseInclude__Alternatives_2 ) )
            {
            // InternalPerl.g:3557:1: ( ( rule__UseInclude__Alternatives_2 ) )
            // InternalPerl.g:3558:2: ( rule__UseInclude__Alternatives_2 )
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2()); 
            // InternalPerl.g:3559:2: ( rule__UseInclude__Alternatives_2 )
            // InternalPerl.g:3559:3: rule__UseInclude__Alternatives_2
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
    // InternalPerl.g:3568:1: rule__UseInclude__Group_2_1__0 : rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1 ;
    public final void rule__UseInclude__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3572:1: ( rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1 )
            // InternalPerl.g:3573:2: rule__UseInclude__Group_2_1__0__Impl rule__UseInclude__Group_2_1__1
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
    // InternalPerl.g:3580:1: rule__UseInclude__Group_2_1__0__Impl : ( ( rule__UseInclude__Alternatives_2_1_0 ) ) ;
    public final void rule__UseInclude__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3584:1: ( ( ( rule__UseInclude__Alternatives_2_1_0 ) ) )
            // InternalPerl.g:3585:1: ( ( rule__UseInclude__Alternatives_2_1_0 ) )
            {
            // InternalPerl.g:3585:1: ( ( rule__UseInclude__Alternatives_2_1_0 ) )
            // InternalPerl.g:3586:2: ( rule__UseInclude__Alternatives_2_1_0 )
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2_1_0()); 
            // InternalPerl.g:3587:2: ( rule__UseInclude__Alternatives_2_1_0 )
            // InternalPerl.g:3587:3: rule__UseInclude__Alternatives_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__UseInclude__Alternatives_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getUseIncludeAccess().getAlternatives_2_1_0()); 

            }


            }

        }
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
    // InternalPerl.g:3595:1: rule__UseInclude__Group_2_1__1 : rule__UseInclude__Group_2_1__1__Impl ;
    public final void rule__UseInclude__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3599:1: ( rule__UseInclude__Group_2_1__1__Impl )
            // InternalPerl.g:3600:2: rule__UseInclude__Group_2_1__1__Impl
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
    // InternalPerl.g:3606:1: rule__UseInclude__Group_2_1__1__Impl : ( ( rule__UseInclude__Alternatives_2_1_1 )? ) ;
    public final void rule__UseInclude__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3610:1: ( ( ( rule__UseInclude__Alternatives_2_1_1 )? ) )
            // InternalPerl.g:3611:1: ( ( rule__UseInclude__Alternatives_2_1_1 )? )
            {
            // InternalPerl.g:3611:1: ( ( rule__UseInclude__Alternatives_2_1_1 )? )
            // InternalPerl.g:3612:2: ( rule__UseInclude__Alternatives_2_1_1 )?
            {
             before(grammarAccess.getUseIncludeAccess().getAlternatives_2_1_1()); 
            // InternalPerl.g:3613:2: ( rule__UseInclude__Alternatives_2_1_1 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_LITERAL)||LA22_0==RULE_WORDS_QUOTE_LIKE) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalPerl.g:3613:3: rule__UseInclude__Alternatives_2_1_1
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
    // InternalPerl.g:3622:1: rule__SubStatement__Group__0 : rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1 ;
    public final void rule__SubStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3626:1: ( rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1 )
            // InternalPerl.g:3627:2: rule__SubStatement__Group__0__Impl rule__SubStatement__Group__1
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
    // InternalPerl.g:3634:1: rule__SubStatement__Group__0__Impl : ( () ) ;
    public final void rule__SubStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3638:1: ( ( () ) )
            // InternalPerl.g:3639:1: ( () )
            {
            // InternalPerl.g:3639:1: ( () )
            // InternalPerl.g:3640:2: ()
            {
             before(grammarAccess.getSubStatementAccess().getSubStatementAction_0()); 
            // InternalPerl.g:3641:2: ()
            // InternalPerl.g:3641:3: 
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
    // InternalPerl.g:3649:1: rule__SubStatement__Group__1 : rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2 ;
    public final void rule__SubStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3653:1: ( rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2 )
            // InternalPerl.g:3654:2: rule__SubStatement__Group__1__Impl rule__SubStatement__Group__2
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
    // InternalPerl.g:3661:1: rule__SubStatement__Group__1__Impl : ( 'sub' ) ;
    public final void rule__SubStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3665:1: ( ( 'sub' ) )
            // InternalPerl.g:3666:1: ( 'sub' )
            {
            // InternalPerl.g:3666:1: ( 'sub' )
            // InternalPerl.g:3667:2: 'sub'
            {
             before(grammarAccess.getSubStatementAccess().getSubKeyword_1()); 
            match(input,252,FOLLOW_2); 
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
    // InternalPerl.g:3676:1: rule__SubStatement__Group__2 : rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3 ;
    public final void rule__SubStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3680:1: ( rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3 )
            // InternalPerl.g:3681:2: rule__SubStatement__Group__2__Impl rule__SubStatement__Group__3
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
    // InternalPerl.g:3688:1: rule__SubStatement__Group__2__Impl : ( ( rule__SubStatement__NameAssignment_2 ) ) ;
    public final void rule__SubStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3692:1: ( ( ( rule__SubStatement__NameAssignment_2 ) ) )
            // InternalPerl.g:3693:1: ( ( rule__SubStatement__NameAssignment_2 ) )
            {
            // InternalPerl.g:3693:1: ( ( rule__SubStatement__NameAssignment_2 ) )
            // InternalPerl.g:3694:2: ( rule__SubStatement__NameAssignment_2 )
            {
             before(grammarAccess.getSubStatementAccess().getNameAssignment_2()); 
            // InternalPerl.g:3695:2: ( rule__SubStatement__NameAssignment_2 )
            // InternalPerl.g:3695:3: rule__SubStatement__NameAssignment_2
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
    // InternalPerl.g:3703:1: rule__SubStatement__Group__3 : rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4 ;
    public final void rule__SubStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3707:1: ( rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4 )
            // InternalPerl.g:3708:2: rule__SubStatement__Group__3__Impl rule__SubStatement__Group__4
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
    // InternalPerl.g:3715:1: rule__SubStatement__Group__3__Impl : ( ( rule__SubStatement__PrototypeAssignment_3 )? ) ;
    public final void rule__SubStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3719:1: ( ( ( rule__SubStatement__PrototypeAssignment_3 )? ) )
            // InternalPerl.g:3720:1: ( ( rule__SubStatement__PrototypeAssignment_3 )? )
            {
            // InternalPerl.g:3720:1: ( ( rule__SubStatement__PrototypeAssignment_3 )? )
            // InternalPerl.g:3721:2: ( rule__SubStatement__PrototypeAssignment_3 )?
            {
             before(grammarAccess.getSubStatementAccess().getPrototypeAssignment_3()); 
            // InternalPerl.g:3722:2: ( rule__SubStatement__PrototypeAssignment_3 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==383) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalPerl.g:3722:3: rule__SubStatement__PrototypeAssignment_3
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
    // InternalPerl.g:3730:1: rule__SubStatement__Group__4 : rule__SubStatement__Group__4__Impl ;
    public final void rule__SubStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3734:1: ( rule__SubStatement__Group__4__Impl )
            // InternalPerl.g:3735:2: rule__SubStatement__Group__4__Impl
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
    // InternalPerl.g:3741:1: rule__SubStatement__Group__4__Impl : ( ( rule__SubStatement__Alternatives_4 ) ) ;
    public final void rule__SubStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3745:1: ( ( ( rule__SubStatement__Alternatives_4 ) ) )
            // InternalPerl.g:3746:1: ( ( rule__SubStatement__Alternatives_4 ) )
            {
            // InternalPerl.g:3746:1: ( ( rule__SubStatement__Alternatives_4 ) )
            // InternalPerl.g:3747:2: ( rule__SubStatement__Alternatives_4 )
            {
             before(grammarAccess.getSubStatementAccess().getAlternatives_4()); 
            // InternalPerl.g:3748:2: ( rule__SubStatement__Alternatives_4 )
            // InternalPerl.g:3748:3: rule__SubStatement__Alternatives_4
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
    // InternalPerl.g:3757:1: rule__BlockStructure__Group__0 : rule__BlockStructure__Group__0__Impl rule__BlockStructure__Group__1 ;
    public final void rule__BlockStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3761:1: ( rule__BlockStructure__Group__0__Impl rule__BlockStructure__Group__1 )
            // InternalPerl.g:3762:2: rule__BlockStructure__Group__0__Impl rule__BlockStructure__Group__1
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
    // InternalPerl.g:3769:1: rule__BlockStructure__Group__0__Impl : ( () ) ;
    public final void rule__BlockStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3773:1: ( ( () ) )
            // InternalPerl.g:3774:1: ( () )
            {
            // InternalPerl.g:3774:1: ( () )
            // InternalPerl.g:3775:2: ()
            {
             before(grammarAccess.getBlockStructureAccess().getBlockStructureAction_0()); 
            // InternalPerl.g:3776:2: ()
            // InternalPerl.g:3776:3: 
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
    // InternalPerl.g:3784:1: rule__BlockStructure__Group__1 : rule__BlockStructure__Group__1__Impl rule__BlockStructure__Group__2 ;
    public final void rule__BlockStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3788:1: ( rule__BlockStructure__Group__1__Impl rule__BlockStructure__Group__2 )
            // InternalPerl.g:3789:2: rule__BlockStructure__Group__1__Impl rule__BlockStructure__Group__2
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
    // InternalPerl.g:3796:1: rule__BlockStructure__Group__1__Impl : ( '{' ) ;
    public final void rule__BlockStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3800:1: ( ( '{' ) )
            // InternalPerl.g:3801:1: ( '{' )
            {
            // InternalPerl.g:3801:1: ( '{' )
            // InternalPerl.g:3802:2: '{'
            {
             before(grammarAccess.getBlockStructureAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,381,FOLLOW_2); 
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
    // InternalPerl.g:3811:1: rule__BlockStructure__Group__2 : rule__BlockStructure__Group__2__Impl rule__BlockStructure__Group__3 ;
    public final void rule__BlockStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3815:1: ( rule__BlockStructure__Group__2__Impl rule__BlockStructure__Group__3 )
            // InternalPerl.g:3816:2: rule__BlockStructure__Group__2__Impl rule__BlockStructure__Group__3
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
    // InternalPerl.g:3823:1: rule__BlockStructure__Group__2__Impl : ( ( rule__BlockStructure__StatementsAssignment_2 )* ) ;
    public final void rule__BlockStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3827:1: ( ( ( rule__BlockStructure__StatementsAssignment_2 )* ) )
            // InternalPerl.g:3828:1: ( ( rule__BlockStructure__StatementsAssignment_2 )* )
            {
            // InternalPerl.g:3828:1: ( ( rule__BlockStructure__StatementsAssignment_2 )* )
            // InternalPerl.g:3829:2: ( rule__BlockStructure__StatementsAssignment_2 )*
            {
             before(grammarAccess.getBlockStructureAccess().getStatementsAssignment_2()); 
            // InternalPerl.g:3830:2: ( rule__BlockStructure__StatementsAssignment_2 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==190||LA24_0==209||LA24_0==252||LA24_0==279) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalPerl.g:3830:3: rule__BlockStructure__StatementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__BlockStructure__StatementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalPerl.g:3838:1: rule__BlockStructure__Group__3 : rule__BlockStructure__Group__3__Impl ;
    public final void rule__BlockStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3842:1: ( rule__BlockStructure__Group__3__Impl )
            // InternalPerl.g:3843:2: rule__BlockStructure__Group__3__Impl
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
    // InternalPerl.g:3849:1: rule__BlockStructure__Group__3__Impl : ( '}' ) ;
    public final void rule__BlockStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3853:1: ( ( '}' ) )
            // InternalPerl.g:3854:1: ( '}' )
            {
            // InternalPerl.g:3854:1: ( '}' )
            // InternalPerl.g:3855:2: '}'
            {
             before(grammarAccess.getBlockStructureAccess().getRightCurlyBracketKeyword_3()); 
            match(input,382,FOLLOW_2); 
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
    // InternalPerl.g:3865:1: rule__Prototype__Group__0 : rule__Prototype__Group__0__Impl rule__Prototype__Group__1 ;
    public final void rule__Prototype__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3869:1: ( rule__Prototype__Group__0__Impl rule__Prototype__Group__1 )
            // InternalPerl.g:3870:2: rule__Prototype__Group__0__Impl rule__Prototype__Group__1
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
    // InternalPerl.g:3877:1: rule__Prototype__Group__0__Impl : ( '(' ) ;
    public final void rule__Prototype__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3881:1: ( ( '(' ) )
            // InternalPerl.g:3882:1: ( '(' )
            {
            // InternalPerl.g:3882:1: ( '(' )
            // InternalPerl.g:3883:2: '('
            {
             before(grammarAccess.getPrototypeAccess().getLeftParenthesisKeyword_0()); 
            match(input,383,FOLLOW_2); 
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
    // InternalPerl.g:3892:1: rule__Prototype__Group__1 : rule__Prototype__Group__1__Impl rule__Prototype__Group__2 ;
    public final void rule__Prototype__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3896:1: ( rule__Prototype__Group__1__Impl rule__Prototype__Group__2 )
            // InternalPerl.g:3897:2: rule__Prototype__Group__1__Impl rule__Prototype__Group__2
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
    // InternalPerl.g:3904:1: rule__Prototype__Group__1__Impl : ( ( rule__Prototype__Alternatives_1 )* ) ;
    public final void rule__Prototype__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3908:1: ( ( ( rule__Prototype__Alternatives_1 )* ) )
            // InternalPerl.g:3909:1: ( ( rule__Prototype__Alternatives_1 )* )
            {
            // InternalPerl.g:3909:1: ( ( rule__Prototype__Alternatives_1 )* )
            // InternalPerl.g:3910:2: ( rule__Prototype__Alternatives_1 )*
            {
             before(grammarAccess.getPrototypeAccess().getAlternatives_1()); 
            // InternalPerl.g:3911:2: ( rule__Prototype__Alternatives_1 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=67 && LA25_0<=71)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalPerl.g:3911:3: rule__Prototype__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Prototype__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalPerl.g:3919:1: rule__Prototype__Group__2 : rule__Prototype__Group__2__Impl ;
    public final void rule__Prototype__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3923:1: ( rule__Prototype__Group__2__Impl )
            // InternalPerl.g:3924:2: rule__Prototype__Group__2__Impl
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
    // InternalPerl.g:3930:1: rule__Prototype__Group__2__Impl : ( ')' ) ;
    public final void rule__Prototype__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3934:1: ( ( ')' ) )
            // InternalPerl.g:3935:1: ( ')' )
            {
            // InternalPerl.g:3935:1: ( ')' )
            // InternalPerl.g:3936:2: ')'
            {
             before(grammarAccess.getPrototypeAccess().getRightParenthesisKeyword_2()); 
            match(input,384,FOLLOW_2); 
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
    // InternalPerl.g:3946:1: rule__Token__Group_0__0 : rule__Token__Group_0__0__Impl rule__Token__Group_0__1 ;
    public final void rule__Token__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3950:1: ( rule__Token__Group_0__0__Impl rule__Token__Group_0__1 )
            // InternalPerl.g:3951:2: rule__Token__Group_0__0__Impl rule__Token__Group_0__1
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
    // InternalPerl.g:3958:1: rule__Token__Group_0__0__Impl : ( () ) ;
    public final void rule__Token__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3962:1: ( ( () ) )
            // InternalPerl.g:3963:1: ( () )
            {
            // InternalPerl.g:3963:1: ( () )
            // InternalPerl.g:3964:2: ()
            {
             before(grammarAccess.getTokenAccess().getPodTokenAction_0_0()); 
            // InternalPerl.g:3965:2: ()
            // InternalPerl.g:3965:3: 
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
    // InternalPerl.g:3973:1: rule__Token__Group_0__1 : rule__Token__Group_0__1__Impl ;
    public final void rule__Token__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3977:1: ( rule__Token__Group_0__1__Impl )
            // InternalPerl.g:3978:2: rule__Token__Group_0__1__Impl
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
    // InternalPerl.g:3984:1: rule__Token__Group_0__1__Impl : ( ( rule__Token__ContentAssignment_0_1 ) ) ;
    public final void rule__Token__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3988:1: ( ( ( rule__Token__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:3989:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:3989:1: ( ( rule__Token__ContentAssignment_0_1 ) )
            // InternalPerl.g:3990:2: ( rule__Token__ContentAssignment_0_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:3991:2: ( rule__Token__ContentAssignment_0_1 )
            // InternalPerl.g:3991:3: rule__Token__ContentAssignment_0_1
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
    // InternalPerl.g:4000:1: rule__Token__Group_1__0 : rule__Token__Group_1__0__Impl rule__Token__Group_1__1 ;
    public final void rule__Token__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4004:1: ( rule__Token__Group_1__0__Impl rule__Token__Group_1__1 )
            // InternalPerl.g:4005:2: rule__Token__Group_1__0__Impl rule__Token__Group_1__1
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
    // InternalPerl.g:4012:1: rule__Token__Group_1__0__Impl : ( () ) ;
    public final void rule__Token__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4016:1: ( ( () ) )
            // InternalPerl.g:4017:1: ( () )
            {
            // InternalPerl.g:4017:1: ( () )
            // InternalPerl.g:4018:2: ()
            {
             before(grammarAccess.getTokenAccess().getNumberTokenAction_1_0()); 
            // InternalPerl.g:4019:2: ()
            // InternalPerl.g:4019:3: 
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
    // InternalPerl.g:4027:1: rule__Token__Group_1__1 : rule__Token__Group_1__1__Impl ;
    public final void rule__Token__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4031:1: ( rule__Token__Group_1__1__Impl )
            // InternalPerl.g:4032:2: rule__Token__Group_1__1__Impl
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
    // InternalPerl.g:4038:1: rule__Token__Group_1__1__Impl : ( ( rule__Token__ContentAssignment_1_1 ) ) ;
    public final void rule__Token__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4042:1: ( ( ( rule__Token__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:4043:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:4043:1: ( ( rule__Token__ContentAssignment_1_1 ) )
            // InternalPerl.g:4044:2: ( rule__Token__ContentAssignment_1_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:4045:2: ( rule__Token__ContentAssignment_1_1 )
            // InternalPerl.g:4045:3: rule__Token__ContentAssignment_1_1
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
    // InternalPerl.g:4054:1: rule__Token__Group_2__0 : rule__Token__Group_2__0__Impl rule__Token__Group_2__1 ;
    public final void rule__Token__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4058:1: ( rule__Token__Group_2__0__Impl rule__Token__Group_2__1 )
            // InternalPerl.g:4059:2: rule__Token__Group_2__0__Impl rule__Token__Group_2__1
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
    // InternalPerl.g:4066:1: rule__Token__Group_2__0__Impl : ( () ) ;
    public final void rule__Token__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4070:1: ( ( () ) )
            // InternalPerl.g:4071:1: ( () )
            {
            // InternalPerl.g:4071:1: ( () )
            // InternalPerl.g:4072:2: ()
            {
             before(grammarAccess.getTokenAccess().getWordTokenAction_2_0()); 
            // InternalPerl.g:4073:2: ()
            // InternalPerl.g:4073:3: 
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
    // InternalPerl.g:4081:1: rule__Token__Group_2__1 : rule__Token__Group_2__1__Impl ;
    public final void rule__Token__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4085:1: ( rule__Token__Group_2__1__Impl )
            // InternalPerl.g:4086:2: rule__Token__Group_2__1__Impl
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
    // InternalPerl.g:4092:1: rule__Token__Group_2__1__Impl : ( ( rule__Token__ContentAssignment_2_1 ) ) ;
    public final void rule__Token__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4096:1: ( ( ( rule__Token__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:4097:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:4097:1: ( ( rule__Token__ContentAssignment_2_1 ) )
            // InternalPerl.g:4098:2: ( rule__Token__ContentAssignment_2_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:4099:2: ( rule__Token__ContentAssignment_2_1 )
            // InternalPerl.g:4099:3: rule__Token__ContentAssignment_2_1
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
    // InternalPerl.g:4108:1: rule__Token__Group_3__0 : rule__Token__Group_3__0__Impl rule__Token__Group_3__1 ;
    public final void rule__Token__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4112:1: ( rule__Token__Group_3__0__Impl rule__Token__Group_3__1 )
            // InternalPerl.g:4113:2: rule__Token__Group_3__0__Impl rule__Token__Group_3__1
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
    // InternalPerl.g:4120:1: rule__Token__Group_3__0__Impl : ( () ) ;
    public final void rule__Token__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4124:1: ( ( () ) )
            // InternalPerl.g:4125:1: ( () )
            {
            // InternalPerl.g:4125:1: ( () )
            // InternalPerl.g:4126:2: ()
            {
             before(grammarAccess.getTokenAccess().getSymbolTokenAction_3_0()); 
            // InternalPerl.g:4127:2: ()
            // InternalPerl.g:4127:3: 
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
    // InternalPerl.g:4135:1: rule__Token__Group_3__1 : rule__Token__Group_3__1__Impl ;
    public final void rule__Token__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4139:1: ( rule__Token__Group_3__1__Impl )
            // InternalPerl.g:4140:2: rule__Token__Group_3__1__Impl
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
    // InternalPerl.g:4146:1: rule__Token__Group_3__1__Impl : ( ( rule__Token__ContentAssignment_3_1 ) ) ;
    public final void rule__Token__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4150:1: ( ( ( rule__Token__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:4151:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:4151:1: ( ( rule__Token__ContentAssignment_3_1 ) )
            // InternalPerl.g:4152:2: ( rule__Token__ContentAssignment_3_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:4153:2: ( rule__Token__ContentAssignment_3_1 )
            // InternalPerl.g:4153:3: rule__Token__ContentAssignment_3_1
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
    // InternalPerl.g:4162:1: rule__Token__Group_5__0 : rule__Token__Group_5__0__Impl rule__Token__Group_5__1 ;
    public final void rule__Token__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4166:1: ( rule__Token__Group_5__0__Impl rule__Token__Group_5__1 )
            // InternalPerl.g:4167:2: rule__Token__Group_5__0__Impl rule__Token__Group_5__1
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
    // InternalPerl.g:4174:1: rule__Token__Group_5__0__Impl : ( () ) ;
    public final void rule__Token__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4178:1: ( ( () ) )
            // InternalPerl.g:4179:1: ( () )
            {
            // InternalPerl.g:4179:1: ( () )
            // InternalPerl.g:4180:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_5_0()); 
            // InternalPerl.g:4181:2: ()
            // InternalPerl.g:4181:3: 
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
    // InternalPerl.g:4189:1: rule__Token__Group_5__1 : rule__Token__Group_5__1__Impl ;
    public final void rule__Token__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4193:1: ( rule__Token__Group_5__1__Impl )
            // InternalPerl.g:4194:2: rule__Token__Group_5__1__Impl
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
    // InternalPerl.g:4200:1: rule__Token__Group_5__1__Impl : ( ( rule__Token__ContentAssignment_5_1 ) ) ;
    public final void rule__Token__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4204:1: ( ( ( rule__Token__ContentAssignment_5_1 ) ) )
            // InternalPerl.g:4205:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            {
            // InternalPerl.g:4205:1: ( ( rule__Token__ContentAssignment_5_1 ) )
            // InternalPerl.g:4206:2: ( rule__Token__ContentAssignment_5_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_5_1()); 
            // InternalPerl.g:4207:2: ( rule__Token__ContentAssignment_5_1 )
            // InternalPerl.g:4207:3: rule__Token__ContentAssignment_5_1
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
    // InternalPerl.g:4216:1: rule__Token__Group_6__0 : rule__Token__Group_6__0__Impl rule__Token__Group_6__1 ;
    public final void rule__Token__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4220:1: ( rule__Token__Group_6__0__Impl rule__Token__Group_6__1 )
            // InternalPerl.g:4221:2: rule__Token__Group_6__0__Impl rule__Token__Group_6__1
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
    // InternalPerl.g:4228:1: rule__Token__Group_6__0__Impl : ( () ) ;
    public final void rule__Token__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4232:1: ( ( () ) )
            // InternalPerl.g:4233:1: ( () )
            {
            // InternalPerl.g:4233:1: ( () )
            // InternalPerl.g:4234:2: ()
            {
             before(grammarAccess.getTokenAccess().getOperatorTokenAction_6_0()); 
            // InternalPerl.g:4235:2: ()
            // InternalPerl.g:4235:3: 
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
    // InternalPerl.g:4243:1: rule__Token__Group_6__1 : rule__Token__Group_6__1__Impl ;
    public final void rule__Token__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4247:1: ( rule__Token__Group_6__1__Impl )
            // InternalPerl.g:4248:2: rule__Token__Group_6__1__Impl
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
    // InternalPerl.g:4254:1: rule__Token__Group_6__1__Impl : ( ( rule__Token__ContentAssignment_6_1 ) ) ;
    public final void rule__Token__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4258:1: ( ( ( rule__Token__ContentAssignment_6_1 ) ) )
            // InternalPerl.g:4259:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            {
            // InternalPerl.g:4259:1: ( ( rule__Token__ContentAssignment_6_1 ) )
            // InternalPerl.g:4260:2: ( rule__Token__ContentAssignment_6_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_6_1()); 
            // InternalPerl.g:4261:2: ( rule__Token__ContentAssignment_6_1 )
            // InternalPerl.g:4261:3: rule__Token__ContentAssignment_6_1
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
    // InternalPerl.g:4270:1: rule__Token__Group_9__0 : rule__Token__Group_9__0__Impl rule__Token__Group_9__1 ;
    public final void rule__Token__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4274:1: ( rule__Token__Group_9__0__Impl rule__Token__Group_9__1 )
            // InternalPerl.g:4275:2: rule__Token__Group_9__0__Impl rule__Token__Group_9__1
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
    // InternalPerl.g:4282:1: rule__Token__Group_9__0__Impl : ( () ) ;
    public final void rule__Token__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4286:1: ( ( () ) )
            // InternalPerl.g:4287:1: ( () )
            {
            // InternalPerl.g:4287:1: ( () )
            // InternalPerl.g:4288:2: ()
            {
             before(grammarAccess.getTokenAccess().getDataTokenAction_9_0()); 
            // InternalPerl.g:4289:2: ()
            // InternalPerl.g:4289:3: 
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
    // InternalPerl.g:4297:1: rule__Token__Group_9__1 : rule__Token__Group_9__1__Impl ;
    public final void rule__Token__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4301:1: ( rule__Token__Group_9__1__Impl )
            // InternalPerl.g:4302:2: rule__Token__Group_9__1__Impl
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
    // InternalPerl.g:4308:1: rule__Token__Group_9__1__Impl : ( ( rule__Token__ContentAssignment_9_1 ) ) ;
    public final void rule__Token__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4312:1: ( ( ( rule__Token__ContentAssignment_9_1 ) ) )
            // InternalPerl.g:4313:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            {
            // InternalPerl.g:4313:1: ( ( rule__Token__ContentAssignment_9_1 ) )
            // InternalPerl.g:4314:2: ( rule__Token__ContentAssignment_9_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_9_1()); 
            // InternalPerl.g:4315:2: ( rule__Token__ContentAssignment_9_1 )
            // InternalPerl.g:4315:3: rule__Token__ContentAssignment_9_1
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
    // InternalPerl.g:4324:1: rule__Token__Group_10__0 : rule__Token__Group_10__0__Impl rule__Token__Group_10__1 ;
    public final void rule__Token__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4328:1: ( rule__Token__Group_10__0__Impl rule__Token__Group_10__1 )
            // InternalPerl.g:4329:2: rule__Token__Group_10__0__Impl rule__Token__Group_10__1
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
    // InternalPerl.g:4336:1: rule__Token__Group_10__0__Impl : ( () ) ;
    public final void rule__Token__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4340:1: ( ( () ) )
            // InternalPerl.g:4341:1: ( () )
            {
            // InternalPerl.g:4341:1: ( () )
            // InternalPerl.g:4342:2: ()
            {
             before(grammarAccess.getTokenAccess().getEndTokenAction_10_0()); 
            // InternalPerl.g:4343:2: ()
            // InternalPerl.g:4343:3: 
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
    // InternalPerl.g:4351:1: rule__Token__Group_10__1 : rule__Token__Group_10__1__Impl ;
    public final void rule__Token__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4355:1: ( rule__Token__Group_10__1__Impl )
            // InternalPerl.g:4356:2: rule__Token__Group_10__1__Impl
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
    // InternalPerl.g:4362:1: rule__Token__Group_10__1__Impl : ( ( rule__Token__ContentAssignment_10_1 ) ) ;
    public final void rule__Token__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4366:1: ( ( ( rule__Token__ContentAssignment_10_1 ) ) )
            // InternalPerl.g:4367:1: ( ( rule__Token__ContentAssignment_10_1 ) )
            {
            // InternalPerl.g:4367:1: ( ( rule__Token__ContentAssignment_10_1 ) )
            // InternalPerl.g:4368:2: ( rule__Token__ContentAssignment_10_1 )
            {
             before(grammarAccess.getTokenAccess().getContentAssignment_10_1()); 
            // InternalPerl.g:4369:2: ( rule__Token__ContentAssignment_10_1 )
            // InternalPerl.g:4369:3: rule__Token__ContentAssignment_10_1
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
    // InternalPerl.g:4378:1: rule__QuoteToken__Group__0 : rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 ;
    public final void rule__QuoteToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4382:1: ( rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1 )
            // InternalPerl.g:4383:2: rule__QuoteToken__Group__0__Impl rule__QuoteToken__Group__1
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
    // InternalPerl.g:4390:1: rule__QuoteToken__Group__0__Impl : ( () ) ;
    public final void rule__QuoteToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4394:1: ( ( () ) )
            // InternalPerl.g:4395:1: ( () )
            {
            // InternalPerl.g:4395:1: ( () )
            // InternalPerl.g:4396:2: ()
            {
             before(grammarAccess.getQuoteTokenAccess().getQuoteTokenAction_0()); 
            // InternalPerl.g:4397:2: ()
            // InternalPerl.g:4397:3: 
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
    // InternalPerl.g:4405:1: rule__QuoteToken__Group__1 : rule__QuoteToken__Group__1__Impl ;
    public final void rule__QuoteToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4409:1: ( rule__QuoteToken__Group__1__Impl )
            // InternalPerl.g:4410:2: rule__QuoteToken__Group__1__Impl
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
    // InternalPerl.g:4416:1: rule__QuoteToken__Group__1__Impl : ( ( rule__QuoteToken__ContentAssignment_1 ) ) ;
    public final void rule__QuoteToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4420:1: ( ( ( rule__QuoteToken__ContentAssignment_1 ) ) )
            // InternalPerl.g:4421:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            {
            // InternalPerl.g:4421:1: ( ( rule__QuoteToken__ContentAssignment_1 ) )
            // InternalPerl.g:4422:2: ( rule__QuoteToken__ContentAssignment_1 )
            {
             before(grammarAccess.getQuoteTokenAccess().getContentAssignment_1()); 
            // InternalPerl.g:4423:2: ( rule__QuoteToken__ContentAssignment_1 )
            // InternalPerl.g:4423:3: rule__QuoteToken__ContentAssignment_1
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
    // InternalPerl.g:4432:1: rule__RegexToken__Group__0 : rule__RegexToken__Group__0__Impl rule__RegexToken__Group__1 ;
    public final void rule__RegexToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4436:1: ( rule__RegexToken__Group__0__Impl rule__RegexToken__Group__1 )
            // InternalPerl.g:4437:2: rule__RegexToken__Group__0__Impl rule__RegexToken__Group__1
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
    // InternalPerl.g:4444:1: rule__RegexToken__Group__0__Impl : ( () ) ;
    public final void rule__RegexToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4448:1: ( ( () ) )
            // InternalPerl.g:4449:1: ( () )
            {
            // InternalPerl.g:4449:1: ( () )
            // InternalPerl.g:4450:2: ()
            {
             before(grammarAccess.getRegexTokenAccess().getRegexTokenAction_0()); 
            // InternalPerl.g:4451:2: ()
            // InternalPerl.g:4451:3: 
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
    // InternalPerl.g:4459:1: rule__RegexToken__Group__1 : rule__RegexToken__Group__1__Impl ;
    public final void rule__RegexToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4463:1: ( rule__RegexToken__Group__1__Impl )
            // InternalPerl.g:4464:2: rule__RegexToken__Group__1__Impl
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
    // InternalPerl.g:4470:1: rule__RegexToken__Group__1__Impl : ( ( rule__RegexToken__ContentAssignment_1 ) ) ;
    public final void rule__RegexToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4474:1: ( ( ( rule__RegexToken__ContentAssignment_1 ) ) )
            // InternalPerl.g:4475:1: ( ( rule__RegexToken__ContentAssignment_1 ) )
            {
            // InternalPerl.g:4475:1: ( ( rule__RegexToken__ContentAssignment_1 ) )
            // InternalPerl.g:4476:2: ( rule__RegexToken__ContentAssignment_1 )
            {
             before(grammarAccess.getRegexTokenAccess().getContentAssignment_1()); 
            // InternalPerl.g:4477:2: ( rule__RegexToken__ContentAssignment_1 )
            // InternalPerl.g:4477:3: rule__RegexToken__ContentAssignment_1
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
    // InternalPerl.g:4486:1: rule__QuoteLikeToken__Group_0__0 : rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 ;
    public final void rule__QuoteLikeToken__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4490:1: ( rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1 )
            // InternalPerl.g:4491:2: rule__QuoteLikeToken__Group_0__0__Impl rule__QuoteLikeToken__Group_0__1
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
    // InternalPerl.g:4498:1: rule__QuoteLikeToken__Group_0__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4502:1: ( ( () ) )
            // InternalPerl.g:4503:1: ( () )
            {
            // InternalPerl.g:4503:1: ( () )
            // InternalPerl.g:4504:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0()); 
            // InternalPerl.g:4505:2: ()
            // InternalPerl.g:4505:3: 
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
    // InternalPerl.g:4513:1: rule__QuoteLikeToken__Group_0__1 : rule__QuoteLikeToken__Group_0__1__Impl ;
    public final void rule__QuoteLikeToken__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4517:1: ( rule__QuoteLikeToken__Group_0__1__Impl )
            // InternalPerl.g:4518:2: rule__QuoteLikeToken__Group_0__1__Impl
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
    // InternalPerl.g:4524:1: rule__QuoteLikeToken__Group_0__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4528:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) ) )
            // InternalPerl.g:4529:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            {
            // InternalPerl.g:4529:1: ( ( rule__QuoteLikeToken__ContentAssignment_0_1 ) )
            // InternalPerl.g:4530:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_0_1()); 
            // InternalPerl.g:4531:2: ( rule__QuoteLikeToken__ContentAssignment_0_1 )
            // InternalPerl.g:4531:3: rule__QuoteLikeToken__ContentAssignment_0_1
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
    // InternalPerl.g:4540:1: rule__QuoteLikeToken__Group_1__0 : rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 ;
    public final void rule__QuoteLikeToken__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4544:1: ( rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1 )
            // InternalPerl.g:4545:2: rule__QuoteLikeToken__Group_1__0__Impl rule__QuoteLikeToken__Group_1__1
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
    // InternalPerl.g:4552:1: rule__QuoteLikeToken__Group_1__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4556:1: ( ( () ) )
            // InternalPerl.g:4557:1: ( () )
            {
            // InternalPerl.g:4557:1: ( () )
            // InternalPerl.g:4558:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0()); 
            // InternalPerl.g:4559:2: ()
            // InternalPerl.g:4559:3: 
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
    // InternalPerl.g:4567:1: rule__QuoteLikeToken__Group_1__1 : rule__QuoteLikeToken__Group_1__1__Impl ;
    public final void rule__QuoteLikeToken__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4571:1: ( rule__QuoteLikeToken__Group_1__1__Impl )
            // InternalPerl.g:4572:2: rule__QuoteLikeToken__Group_1__1__Impl
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
    // InternalPerl.g:4578:1: rule__QuoteLikeToken__Group_1__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4582:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) ) )
            // InternalPerl.g:4583:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            {
            // InternalPerl.g:4583:1: ( ( rule__QuoteLikeToken__ContentAssignment_1_1 ) )
            // InternalPerl.g:4584:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_1_1()); 
            // InternalPerl.g:4585:2: ( rule__QuoteLikeToken__ContentAssignment_1_1 )
            // InternalPerl.g:4585:3: rule__QuoteLikeToken__ContentAssignment_1_1
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
    // InternalPerl.g:4594:1: rule__QuoteLikeToken__Group_2__0 : rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 ;
    public final void rule__QuoteLikeToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4598:1: ( rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1 )
            // InternalPerl.g:4599:2: rule__QuoteLikeToken__Group_2__0__Impl rule__QuoteLikeToken__Group_2__1
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
    // InternalPerl.g:4606:1: rule__QuoteLikeToken__Group_2__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4610:1: ( ( () ) )
            // InternalPerl.g:4611:1: ( () )
            {
            // InternalPerl.g:4611:1: ( () )
            // InternalPerl.g:4612:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0()); 
            // InternalPerl.g:4613:2: ()
            // InternalPerl.g:4613:3: 
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
    // InternalPerl.g:4621:1: rule__QuoteLikeToken__Group_2__1 : rule__QuoteLikeToken__Group_2__1__Impl ;
    public final void rule__QuoteLikeToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4625:1: ( rule__QuoteLikeToken__Group_2__1__Impl )
            // InternalPerl.g:4626:2: rule__QuoteLikeToken__Group_2__1__Impl
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
    // InternalPerl.g:4632:1: rule__QuoteLikeToken__Group_2__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4636:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) ) )
            // InternalPerl.g:4637:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            {
            // InternalPerl.g:4637:1: ( ( rule__QuoteLikeToken__ContentAssignment_2_1 ) )
            // InternalPerl.g:4638:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_2_1()); 
            // InternalPerl.g:4639:2: ( rule__QuoteLikeToken__ContentAssignment_2_1 )
            // InternalPerl.g:4639:3: rule__QuoteLikeToken__ContentAssignment_2_1
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
    // InternalPerl.g:4648:1: rule__QuoteLikeToken__Group_3__0 : rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 ;
    public final void rule__QuoteLikeToken__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4652:1: ( rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1 )
            // InternalPerl.g:4653:2: rule__QuoteLikeToken__Group_3__0__Impl rule__QuoteLikeToken__Group_3__1
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
    // InternalPerl.g:4660:1: rule__QuoteLikeToken__Group_3__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4664:1: ( ( () ) )
            // InternalPerl.g:4665:1: ( () )
            {
            // InternalPerl.g:4665:1: ( () )
            // InternalPerl.g:4666:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0()); 
            // InternalPerl.g:4667:2: ()
            // InternalPerl.g:4667:3: 
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
    // InternalPerl.g:4675:1: rule__QuoteLikeToken__Group_3__1 : rule__QuoteLikeToken__Group_3__1__Impl ;
    public final void rule__QuoteLikeToken__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4679:1: ( rule__QuoteLikeToken__Group_3__1__Impl )
            // InternalPerl.g:4680:2: rule__QuoteLikeToken__Group_3__1__Impl
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
    // InternalPerl.g:4686:1: rule__QuoteLikeToken__Group_3__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4690:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) ) )
            // InternalPerl.g:4691:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            {
            // InternalPerl.g:4691:1: ( ( rule__QuoteLikeToken__ContentAssignment_3_1 ) )
            // InternalPerl.g:4692:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_3_1()); 
            // InternalPerl.g:4693:2: ( rule__QuoteLikeToken__ContentAssignment_3_1 )
            // InternalPerl.g:4693:3: rule__QuoteLikeToken__ContentAssignment_3_1
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
    // InternalPerl.g:4702:1: rule__QuoteLikeToken__Group_4__0 : rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 ;
    public final void rule__QuoteLikeToken__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4706:1: ( rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1 )
            // InternalPerl.g:4707:2: rule__QuoteLikeToken__Group_4__0__Impl rule__QuoteLikeToken__Group_4__1
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
    // InternalPerl.g:4714:1: rule__QuoteLikeToken__Group_4__0__Impl : ( () ) ;
    public final void rule__QuoteLikeToken__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4718:1: ( ( () ) )
            // InternalPerl.g:4719:1: ( () )
            {
            // InternalPerl.g:4719:1: ( () )
            // InternalPerl.g:4720:2: ()
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0()); 
            // InternalPerl.g:4721:2: ()
            // InternalPerl.g:4721:3: 
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
    // InternalPerl.g:4729:1: rule__QuoteLikeToken__Group_4__1 : rule__QuoteLikeToken__Group_4__1__Impl ;
    public final void rule__QuoteLikeToken__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4733:1: ( rule__QuoteLikeToken__Group_4__1__Impl )
            // InternalPerl.g:4734:2: rule__QuoteLikeToken__Group_4__1__Impl
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
    // InternalPerl.g:4740:1: rule__QuoteLikeToken__Group_4__1__Impl : ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) ;
    public final void rule__QuoteLikeToken__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4744:1: ( ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) ) )
            // InternalPerl.g:4745:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            {
            // InternalPerl.g:4745:1: ( ( rule__QuoteLikeToken__ContentAssignment_4_1 ) )
            // InternalPerl.g:4746:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            {
             before(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_4_1()); 
            // InternalPerl.g:4747:2: ( rule__QuoteLikeToken__ContentAssignment_4_1 )
            // InternalPerl.g:4747:3: rule__QuoteLikeToken__ContentAssignment_4_1
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
    // InternalPerl.g:4756:1: rule__Operator__Group_23__0 : rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 ;
    public final void rule__Operator__Group_23__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4760:1: ( rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1 )
            // InternalPerl.g:4761:2: rule__Operator__Group_23__0__Impl rule__Operator__Group_23__1
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
    // InternalPerl.g:4768:1: rule__Operator__Group_23__0__Impl : ( '<=>' ) ;
    public final void rule__Operator__Group_23__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4772:1: ( ( '<=>' ) )
            // InternalPerl.g:4773:1: ( '<=>' )
            {
            // InternalPerl.g:4773:1: ( '<=>' )
            // InternalPerl.g:4774:2: '<=>'
            {
             before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_23_0()); 
            match(input,385,FOLLOW_2); 
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
    // InternalPerl.g:4783:1: rule__Operator__Group_23__1 : rule__Operator__Group_23__1__Impl ;
    public final void rule__Operator__Group_23__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4787:1: ( rule__Operator__Group_23__1__Impl )
            // InternalPerl.g:4788:2: rule__Operator__Group_23__1__Impl
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
    // InternalPerl.g:4794:1: rule__Operator__Group_23__1__Impl : ( '.' ) ;
    public final void rule__Operator__Group_23__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4798:1: ( ( '.' ) )
            // InternalPerl.g:4799:1: ( '.' )
            {
            // InternalPerl.g:4799:1: ( '.' )
            // InternalPerl.g:4800:2: '.'
            {
             before(grammarAccess.getOperatorAccess().getFullStopKeyword_23_1()); 
            match(input,386,FOLLOW_2); 
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


    // $ANTLR start "rule__QUALIFIED_ID__Group__0"
    // InternalPerl.g:4810:1: rule__QUALIFIED_ID__Group__0 : rule__QUALIFIED_ID__Group__0__Impl rule__QUALIFIED_ID__Group__1 ;
    public final void rule__QUALIFIED_ID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4814:1: ( rule__QUALIFIED_ID__Group__0__Impl rule__QUALIFIED_ID__Group__1 )
            // InternalPerl.g:4815:2: rule__QUALIFIED_ID__Group__0__Impl rule__QUALIFIED_ID__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__QUALIFIED_ID__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QUALIFIED_ID__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QUALIFIED_ID__Group__0"


    // $ANTLR start "rule__QUALIFIED_ID__Group__0__Impl"
    // InternalPerl.g:4822:1: rule__QUALIFIED_ID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QUALIFIED_ID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4826:1: ( ( RULE_ID ) )
            // InternalPerl.g:4827:1: ( RULE_ID )
            {
            // InternalPerl.g:4827:1: ( RULE_ID )
            // InternalPerl.g:4828:2: RULE_ID
            {
             before(grammarAccess.getQUALIFIED_IDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQUALIFIED_IDAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QUALIFIED_ID__Group__0__Impl"


    // $ANTLR start "rule__QUALIFIED_ID__Group__1"
    // InternalPerl.g:4837:1: rule__QUALIFIED_ID__Group__1 : rule__QUALIFIED_ID__Group__1__Impl ;
    public final void rule__QUALIFIED_ID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4841:1: ( rule__QUALIFIED_ID__Group__1__Impl )
            // InternalPerl.g:4842:2: rule__QUALIFIED_ID__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QUALIFIED_ID__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QUALIFIED_ID__Group__1"


    // $ANTLR start "rule__QUALIFIED_ID__Group__1__Impl"
    // InternalPerl.g:4848:1: rule__QUALIFIED_ID__Group__1__Impl : ( ( rule__QUALIFIED_ID__Group_1__0 )* ) ;
    public final void rule__QUALIFIED_ID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4852:1: ( ( ( rule__QUALIFIED_ID__Group_1__0 )* ) )
            // InternalPerl.g:4853:1: ( ( rule__QUALIFIED_ID__Group_1__0 )* )
            {
            // InternalPerl.g:4853:1: ( ( rule__QUALIFIED_ID__Group_1__0 )* )
            // InternalPerl.g:4854:2: ( rule__QUALIFIED_ID__Group_1__0 )*
            {
             before(grammarAccess.getQUALIFIED_IDAccess().getGroup_1()); 
            // InternalPerl.g:4855:2: ( rule__QUALIFIED_ID__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=379 && LA26_0<=380)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalPerl.g:4855:3: rule__QUALIFIED_ID__Group_1__0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__QUALIFIED_ID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getQUALIFIED_IDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QUALIFIED_ID__Group__1__Impl"


    // $ANTLR start "rule__QUALIFIED_ID__Group_1__0"
    // InternalPerl.g:4864:1: rule__QUALIFIED_ID__Group_1__0 : rule__QUALIFIED_ID__Group_1__0__Impl rule__QUALIFIED_ID__Group_1__1 ;
    public final void rule__QUALIFIED_ID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4868:1: ( rule__QUALIFIED_ID__Group_1__0__Impl rule__QUALIFIED_ID__Group_1__1 )
            // InternalPerl.g:4869:2: rule__QUALIFIED_ID__Group_1__0__Impl rule__QUALIFIED_ID__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__QUALIFIED_ID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QUALIFIED_ID__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QUALIFIED_ID__Group_1__0"


    // $ANTLR start "rule__QUALIFIED_ID__Group_1__0__Impl"
    // InternalPerl.g:4876:1: rule__QUALIFIED_ID__Group_1__0__Impl : ( ( rule__QUALIFIED_ID__Alternatives_1_0 ) ) ;
    public final void rule__QUALIFIED_ID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4880:1: ( ( ( rule__QUALIFIED_ID__Alternatives_1_0 ) ) )
            // InternalPerl.g:4881:1: ( ( rule__QUALIFIED_ID__Alternatives_1_0 ) )
            {
            // InternalPerl.g:4881:1: ( ( rule__QUALIFIED_ID__Alternatives_1_0 ) )
            // InternalPerl.g:4882:2: ( rule__QUALIFIED_ID__Alternatives_1_0 )
            {
             before(grammarAccess.getQUALIFIED_IDAccess().getAlternatives_1_0()); 
            // InternalPerl.g:4883:2: ( rule__QUALIFIED_ID__Alternatives_1_0 )
            // InternalPerl.g:4883:3: rule__QUALIFIED_ID__Alternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__QUALIFIED_ID__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getQUALIFIED_IDAccess().getAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QUALIFIED_ID__Group_1__0__Impl"


    // $ANTLR start "rule__QUALIFIED_ID__Group_1__1"
    // InternalPerl.g:4891:1: rule__QUALIFIED_ID__Group_1__1 : rule__QUALIFIED_ID__Group_1__1__Impl ;
    public final void rule__QUALIFIED_ID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4895:1: ( rule__QUALIFIED_ID__Group_1__1__Impl )
            // InternalPerl.g:4896:2: rule__QUALIFIED_ID__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QUALIFIED_ID__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QUALIFIED_ID__Group_1__1"


    // $ANTLR start "rule__QUALIFIED_ID__Group_1__1__Impl"
    // InternalPerl.g:4902:1: rule__QUALIFIED_ID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QUALIFIED_ID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4906:1: ( ( RULE_ID ) )
            // InternalPerl.g:4907:1: ( RULE_ID )
            {
            // InternalPerl.g:4907:1: ( RULE_ID )
            // InternalPerl.g:4908:2: RULE_ID
            {
             before(grammarAccess.getQUALIFIED_IDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQUALIFIED_IDAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QUALIFIED_ID__Group_1__1__Impl"


    // $ANTLR start "rule__PerlDocument__ElementsAssignment_1"
    // InternalPerl.g:4918:1: rule__PerlDocument__ElementsAssignment_1 : ( ruleElement ) ;
    public final void rule__PerlDocument__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4922:1: ( ( ruleElement ) )
            // InternalPerl.g:4923:2: ( ruleElement )
            {
            // InternalPerl.g:4923:2: ( ruleElement )
            // InternalPerl.g:4924:3: ruleElement
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
    // InternalPerl.g:4933:1: rule__PackageStatement__NameAssignment_2 : ( ruleQUALIFIED_ID ) ;
    public final void rule__PackageStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4937:1: ( ( ruleQUALIFIED_ID ) )
            // InternalPerl.g:4938:2: ( ruleQUALIFIED_ID )
            {
            // InternalPerl.g:4938:2: ( ruleQUALIFIED_ID )
            // InternalPerl.g:4939:3: ruleQUALIFIED_ID
            {
             before(grammarAccess.getPackageStatementAccess().getNameQUALIFIED_IDParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleQUALIFIED_ID();

            state._fsp--;

             after(grammarAccess.getPackageStatementAccess().getNameQUALIFIED_IDParserRuleCall_2_0()); 

            }


            }

        }
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
    // InternalPerl.g:4948:1: rule__PackageStatement__VersionAssignment_3 : ( RULE_VERSION ) ;
    public final void rule__PackageStatement__VersionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4952:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4953:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4953:2: ( RULE_VERSION )
            // InternalPerl.g:4954:3: RULE_VERSION
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
    // InternalPerl.g:4963:1: rule__RequireInclude__VersionAssignment_1 : ( RULE_VERSION ) ;
    public final void rule__RequireInclude__VersionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4967:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4968:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4968:2: ( RULE_VERSION )
            // InternalPerl.g:4969:3: RULE_VERSION
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
    // InternalPerl.g:4978:1: rule__UseInclude__VersionAssignment_2_0 : ( RULE_VERSION ) ;
    public final void rule__UseInclude__VersionAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4982:1: ( ( RULE_VERSION ) )
            // InternalPerl.g:4983:2: ( RULE_VERSION )
            {
            // InternalPerl.g:4983:2: ( RULE_VERSION )
            // InternalPerl.g:4984:3: RULE_VERSION
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


    // $ANTLR start "rule__UseInclude__PragmaAssignment_2_1_0_0"
    // InternalPerl.g:4993:1: rule__UseInclude__PragmaAssignment_2_1_0_0 : ( rulePragma ) ;
    public final void rule__UseInclude__PragmaAssignment_2_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4997:1: ( ( rulePragma ) )
            // InternalPerl.g:4998:2: ( rulePragma )
            {
            // InternalPerl.g:4998:2: ( rulePragma )
            // InternalPerl.g:4999:3: rulePragma
            {
             before(grammarAccess.getUseIncludeAccess().getPragmaPragmaParserRuleCall_2_1_0_0_0()); 
            pushFollow(FOLLOW_2);
            rulePragma();

            state._fsp--;

             after(grammarAccess.getUseIncludeAccess().getPragmaPragmaParserRuleCall_2_1_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UseInclude__PragmaAssignment_2_1_0_0"


    // $ANTLR start "rule__UseInclude__PackageAssignment_2_1_0_1"
    // InternalPerl.g:5008:1: rule__UseInclude__PackageAssignment_2_1_0_1 : ( ( ruleQUALIFIED_ID ) ) ;
    public final void rule__UseInclude__PackageAssignment_2_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5012:1: ( ( ( ruleQUALIFIED_ID ) ) )
            // InternalPerl.g:5013:2: ( ( ruleQUALIFIED_ID ) )
            {
            // InternalPerl.g:5013:2: ( ( ruleQUALIFIED_ID ) )
            // InternalPerl.g:5014:3: ( ruleQUALIFIED_ID )
            {
             before(grammarAccess.getUseIncludeAccess().getPackagePackageStatementCrossReference_2_1_0_1_0()); 
            // InternalPerl.g:5015:3: ( ruleQUALIFIED_ID )
            // InternalPerl.g:5016:4: ruleQUALIFIED_ID
            {
             before(grammarAccess.getUseIncludeAccess().getPackagePackageStatementQUALIFIED_IDParserRuleCall_2_1_0_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQUALIFIED_ID();

            state._fsp--;

             after(grammarAccess.getUseIncludeAccess().getPackagePackageStatementQUALIFIED_IDParserRuleCall_2_1_0_1_0_1()); 

            }

             after(grammarAccess.getUseIncludeAccess().getPackagePackageStatementCrossReference_2_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UseInclude__PackageAssignment_2_1_0_1"


    // $ANTLR start "rule__UseInclude__StringArgumentAssignment_2_1_1_0"
    // InternalPerl.g:5027:1: rule__UseInclude__StringArgumentAssignment_2_1_1_0 : ( ruleQuoteToken ) ;
    public final void rule__UseInclude__StringArgumentAssignment_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5031:1: ( ( ruleQuoteToken ) )
            // InternalPerl.g:5032:2: ( ruleQuoteToken )
            {
            // InternalPerl.g:5032:2: ( ruleQuoteToken )
            // InternalPerl.g:5033:3: ruleQuoteToken
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
    // InternalPerl.g:5042:1: rule__UseInclude__QwArgumentAssignment_2_1_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__UseInclude__QwArgumentAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5046:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:5047:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:5047:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:5048:3: RULE_WORDS_QUOTE_LIKE
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
    // InternalPerl.g:5057:1: rule__SubStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SubStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5061:1: ( ( RULE_ID ) )
            // InternalPerl.g:5062:2: ( RULE_ID )
            {
            // InternalPerl.g:5062:2: ( RULE_ID )
            // InternalPerl.g:5063:3: RULE_ID
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
    // InternalPerl.g:5072:1: rule__SubStatement__PrototypeAssignment_3 : ( rulePrototype ) ;
    public final void rule__SubStatement__PrototypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5076:1: ( ( rulePrototype ) )
            // InternalPerl.g:5077:2: ( rulePrototype )
            {
            // InternalPerl.g:5077:2: ( rulePrototype )
            // InternalPerl.g:5078:3: rulePrototype
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


    // $ANTLR start "rule__SubStatement__BlockAssignment_4_0"
    // InternalPerl.g:5087:1: rule__SubStatement__BlockAssignment_4_0 : ( ruleBlockStructure ) ;
    public final void rule__SubStatement__BlockAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5091:1: ( ( ruleBlockStructure ) )
            // InternalPerl.g:5092:2: ( ruleBlockStructure )
            {
            // InternalPerl.g:5092:2: ( ruleBlockStructure )
            // InternalPerl.g:5093:3: ruleBlockStructure
            {
             before(grammarAccess.getSubStatementAccess().getBlockBlockStructureParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleBlockStructure();

            state._fsp--;

             after(grammarAccess.getSubStatementAccess().getBlockBlockStructureParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubStatement__BlockAssignment_4_0"


    // $ANTLR start "rule__BlockStructure__StatementsAssignment_2"
    // InternalPerl.g:5102:1: rule__BlockStructure__StatementsAssignment_2 : ( ruleStatementNode ) ;
    public final void rule__BlockStructure__StatementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5106:1: ( ( ruleStatementNode ) )
            // InternalPerl.g:5107:2: ( ruleStatementNode )
            {
            // InternalPerl.g:5107:2: ( ruleStatementNode )
            // InternalPerl.g:5108:3: ruleStatementNode
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
    // InternalPerl.g:5117:1: rule__Token__ContentAssignment_0_1 : ( RULE_POD ) ;
    public final void rule__Token__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5121:1: ( ( RULE_POD ) )
            // InternalPerl.g:5122:2: ( RULE_POD )
            {
            // InternalPerl.g:5122:2: ( RULE_POD )
            // InternalPerl.g:5123:3: RULE_POD
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
    // InternalPerl.g:5132:1: rule__Token__ContentAssignment_1_1 : ( RULE_NUMBER ) ;
    public final void rule__Token__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5136:1: ( ( RULE_NUMBER ) )
            // InternalPerl.g:5137:2: ( RULE_NUMBER )
            {
            // InternalPerl.g:5137:2: ( RULE_NUMBER )
            // InternalPerl.g:5138:3: RULE_NUMBER
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
    // InternalPerl.g:5147:1: rule__Token__ContentAssignment_2_1 : ( ruleWord ) ;
    public final void rule__Token__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5151:1: ( ( ruleWord ) )
            // InternalPerl.g:5152:2: ( ruleWord )
            {
            // InternalPerl.g:5152:2: ( ruleWord )
            // InternalPerl.g:5153:3: ruleWord
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
    // InternalPerl.g:5162:1: rule__Token__ContentAssignment_3_1 : ( RULE_SYMBOL ) ;
    public final void rule__Token__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5166:1: ( ( RULE_SYMBOL ) )
            // InternalPerl.g:5167:2: ( RULE_SYMBOL )
            {
            // InternalPerl.g:5167:2: ( RULE_SYMBOL )
            // InternalPerl.g:5168:3: RULE_SYMBOL
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
    // InternalPerl.g:5177:1: rule__Token__ContentAssignment_5_1 : ( ruleFileTestOperator ) ;
    public final void rule__Token__ContentAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5181:1: ( ( ruleFileTestOperator ) )
            // InternalPerl.g:5182:2: ( ruleFileTestOperator )
            {
            // InternalPerl.g:5182:2: ( ruleFileTestOperator )
            // InternalPerl.g:5183:3: ruleFileTestOperator
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
    // InternalPerl.g:5192:1: rule__Token__ContentAssignment_6_1 : ( ruleOperator ) ;
    public final void rule__Token__ContentAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5196:1: ( ( ruleOperator ) )
            // InternalPerl.g:5197:2: ( ruleOperator )
            {
            // InternalPerl.g:5197:2: ( ruleOperator )
            // InternalPerl.g:5198:3: ruleOperator
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
    // InternalPerl.g:5207:1: rule__Token__ContentAssignment_9_1 : ( RULE_DATA ) ;
    public final void rule__Token__ContentAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5211:1: ( ( RULE_DATA ) )
            // InternalPerl.g:5212:2: ( RULE_DATA )
            {
            // InternalPerl.g:5212:2: ( RULE_DATA )
            // InternalPerl.g:5213:3: RULE_DATA
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
    // InternalPerl.g:5222:1: rule__Token__ContentAssignment_10_1 : ( RULE_END ) ;
    public final void rule__Token__ContentAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5226:1: ( ( RULE_END ) )
            // InternalPerl.g:5227:2: ( RULE_END )
            {
            // InternalPerl.g:5227:2: ( RULE_END )
            // InternalPerl.g:5228:3: RULE_END
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
    // InternalPerl.g:5237:1: rule__QuoteToken__ContentAssignment_1 : ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) ;
    public final void rule__QuoteToken__ContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5241:1: ( ( ( rule__QuoteToken__ContentAlternatives_1_0 ) ) )
            // InternalPerl.g:5242:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            {
            // InternalPerl.g:5242:2: ( ( rule__QuoteToken__ContentAlternatives_1_0 ) )
            // InternalPerl.g:5243:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            {
             before(grammarAccess.getQuoteTokenAccess().getContentAlternatives_1_0()); 
            // InternalPerl.g:5244:3: ( rule__QuoteToken__ContentAlternatives_1_0 )
            // InternalPerl.g:5244:4: rule__QuoteToken__ContentAlternatives_1_0
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
    // InternalPerl.g:5252:1: rule__RegexToken__ContentAssignment_1 : ( ( rule__RegexToken__ContentAlternatives_1_0 ) ) ;
    public final void rule__RegexToken__ContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5256:1: ( ( ( rule__RegexToken__ContentAlternatives_1_0 ) ) )
            // InternalPerl.g:5257:2: ( ( rule__RegexToken__ContentAlternatives_1_0 ) )
            {
            // InternalPerl.g:5257:2: ( ( rule__RegexToken__ContentAlternatives_1_0 ) )
            // InternalPerl.g:5258:3: ( rule__RegexToken__ContentAlternatives_1_0 )
            {
             before(grammarAccess.getRegexTokenAccess().getContentAlternatives_1_0()); 
            // InternalPerl.g:5259:3: ( rule__RegexToken__ContentAlternatives_1_0 )
            // InternalPerl.g:5259:4: rule__RegexToken__ContentAlternatives_1_0
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
    // InternalPerl.g:5267:1: rule__QuoteLikeToken__ContentAssignment_0_1 : ( RULE_BACKTICK_STRING ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5271:1: ( ( RULE_BACKTICK_STRING ) )
            // InternalPerl.g:5272:2: ( RULE_BACKTICK_STRING )
            {
            // InternalPerl.g:5272:2: ( RULE_BACKTICK_STRING )
            // InternalPerl.g:5273:3: RULE_BACKTICK_STRING
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
    // InternalPerl.g:5282:1: rule__QuoteLikeToken__ContentAssignment_1_1 : ( RULE_WORDS_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5286:1: ( ( RULE_WORDS_QUOTE_LIKE ) )
            // InternalPerl.g:5287:2: ( RULE_WORDS_QUOTE_LIKE )
            {
            // InternalPerl.g:5287:2: ( RULE_WORDS_QUOTE_LIKE )
            // InternalPerl.g:5288:3: RULE_WORDS_QUOTE_LIKE
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
    // InternalPerl.g:5297:1: rule__QuoteLikeToken__ContentAssignment_2_1 : ( RULE_COMMAND_QUOTE_LIKE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5301:1: ( ( RULE_COMMAND_QUOTE_LIKE ) )
            // InternalPerl.g:5302:2: ( RULE_COMMAND_QUOTE_LIKE )
            {
            // InternalPerl.g:5302:2: ( RULE_COMMAND_QUOTE_LIKE )
            // InternalPerl.g:5303:3: RULE_COMMAND_QUOTE_LIKE
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
    // InternalPerl.g:5312:1: rule__QuoteLikeToken__ContentAssignment_3_1 : ( RULE_REGEX_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5316:1: ( ( RULE_REGEX_QUOTE ) )
            // InternalPerl.g:5317:2: ( RULE_REGEX_QUOTE )
            {
            // InternalPerl.g:5317:2: ( RULE_REGEX_QUOTE )
            // InternalPerl.g:5318:3: RULE_REGEX_QUOTE
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
    // InternalPerl.g:5327:1: rule__QuoteLikeToken__ContentAssignment_4_1 : ( RULE_READLINE_QUOTE ) ;
    public final void rule__QuoteLikeToken__ContentAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5331:1: ( ( RULE_READLINE_QUOTE ) )
            // InternalPerl.g:5332:2: ( RULE_READLINE_QUOTE )
            {
            // InternalPerl.g:5332:2: ( RULE_READLINE_QUOTE )
            // InternalPerl.g:5333:3: RULE_READLINE_QUOTE
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


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\1\uffff\4\6\2\uffff\7\6";
    static final String dfa_3s = "\5\4\2\uffff\7\4";
    static final String dfa_4s = "\5\u0181\2\uffff\7\u0181";
    static final String dfa_5s = "\5\uffff\1\1\1\2\7\uffff";
    static final String dfa_6s = "\16\uffff}>";
    static final String[] dfa_7s = {
            "\6\6\2\uffff\12\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\13\uffff\1\6\1\uffff\167\6\1\2\22\6\1\3\52\6\1\1\32\6\1\4\143\6\2\uffff\1\5\3\uffff\1\6",
            "\6\6\1\5\1\uffff\12\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\13\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6",
            "\6\6\1\5\1\uffff\12\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\13\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6",
            "\6\6\1\uffff\1\5\12\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\13\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6",
            "\6\6\2\5\12\6\6\uffff\20\5\1\7\5\5\1\10\6\5\1\11\11\5\2\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6",
            "",
            "",
            "\1\13\1\14\1\15\3\6\2\uffff\1\12\11\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\11\uffff\1\5\1\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6",
            "\1\13\1\14\1\15\3\6\2\uffff\1\12\11\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\11\uffff\1\5\1\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6",
            "\1\13\1\14\1\15\3\6\2\uffff\1\12\11\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\11\uffff\1\5\1\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6",
            "\6\6\2\uffff\12\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\11\uffff\1\5\1\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6",
            "\6\6\2\uffff\12\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\11\uffff\1\5\1\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6",
            "\6\6\2\uffff\12\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\11\uffff\1\5\1\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6",
            "\6\6\2\uffff\12\6\26\uffff\1\6\5\uffff\1\6\6\uffff\1\6\11\uffff\1\5\1\uffff\1\6\1\uffff\u0134\6\2\uffff\1\6\3\uffff\1\6"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "652:1: rule__Element__Alternatives : ( ( ruleNode ) | ( ruleToken ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x02041000003FF3F0L,0xFFFFFFFFFFFFFFA0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x27FFFFFFFFFFFFFFL,0x0000000000000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x02041000003FF3F2L,0xFFFFFFFFFFFFFFA0L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x27FFFFFFFFFFFFFFL,0x0000000000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x1000000000020000L,0x0000000000800000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0xFFFFFFFFF0000C00L,0x0000000000000007L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000001070L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x4000000000000000L,0x1000000000020000L,0x0000000000800000L,0xA000000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x1000000000020000L,0x0000000000800000L,0x2000000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x1000000000020000L,0x0000000000800000L,0x4000000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x4000000000000000L,0x1000000000020000L,0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000F8L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000F8L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0204100000000000L,0xFFFFFFFFFFFFFF00L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000007FFFFFFFFL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x07FFFFFF00000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000A0L,0x0000000000000000L,0x0000000000000000L,0xFFFFFFF800000000L,0x00000000FFFFFFFFL,0x0000000000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000000003C1000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x1800000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x1800000000000000L});

}