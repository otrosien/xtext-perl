package org.epic.perl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.epic.perl.services.PerlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPerlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_VERSION", "RULE_WORDS_QUOTE_LIKE", "RULE_POD", "RULE_NUMBER", "RULE_SYMBOL", "RULE_DATA", "RULE_END", "RULE_STRING", "RULE_INTERPOLATE", "RULE_LITERAL", "RULE_REGEX_SUBSTITUTE", "RULE_REGEX_TRANSLITERATE", "RULE_REGEX_MATCH", "RULE_BACKTICK_STRING", "RULE_COMMAND_QUOTE_LIKE", "RULE_REGEX_QUOTE", "RULE_READLINE_QUOTE", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER", "RULE_SL_COMMENT", "';'", "'package'", "'require'", "'use'", "'sub'", "'{'", "'}'", "'('", "'$'", "'%'", "'@'", "'&'", "')'", "'abs'", "'accept'", "'alarm'", "'atan2'", "'bind'", "'binmode'", "'bless'", "'break'", "'caller'", "'chdir'", "'chmod'", "'chomp'", "'chop'", "'chown'", "'chr'", "'chroot'", "'close'", "'closedir'", "'connect'", "'continue'", "'cos'", "'crypt'", "'dbmclose'", "'dbmopen'", "'default'", "'defined'", "'delete'", "'die'", "'do'", "'dump'", "'each'", "'else'", "'elsif'", "'endgrent'", "'endhostent'", "'endnetent'", "'endprotoent'", "'endpwent'", "'endservent'", "'eof'", "'eval'", "'evalbytes'", "'exec'", "'exists'", "'exit'", "'exp'", "'fc'", "'fcntl'", "'fileno'", "'flock'", "'for'", "'foreach'", "'fork'", "'format'", "'formline'", "'getc'", "'getgrent'", "'getgrgid'", "'getgrnam'", "'gethostbyaddr'", "'gethostbyname'", "'gethostent'", "'getlogin'", "'getnetbyaddr'", "'getnetbyname'", "'getnetent'", "'getpeername'", "'getpgrp'", "'getppid'", "'getpriority'", "'getprotobyname'", "'getprotobynumber'", "'getprotoent'", "'getpwent'", "'getpwnam'", "'getpwuid'", "'getservbyname'", "'getservbyport'", "'getservent'", "'getsockname'", "'getsockopt'", "'given'", "'glob'", "'gmtime'", "'goto'", "'grep'", "'hex'", "'if'", "'index'", "'int'", "'ioctl'", "'join'", "'keys'", "'kill'", "'last'", "'lc'", "'lcfirst'", "'length'", "'link'", "'listen'", "'local'", "'localtime'", "'lock'", "'log'", "'lstat'", "'map'", "'mkdir'", "'msgctl'", "'msgget'", "'msgrcv'", "'msgsnd'", "'my'", "'next'", "'no'", "'oct'", "'open'", "'opendir'", "'ord'", "'our'", "'pack'", "'pipe'", "'pop'", "'pos'", "'print'", "'printf'", "'prototype'", "'push'", "'quotemeta'", "'rand'", "'read'", "'readdir'", "'readline'", "'readlink'", "'readpipe'", "'recv'", "'redo'", "'ref'", "'rename'", "'reset'", "'return'", "'reverse'", "'rewinddir'", "'rindex'", "'rmdir'", "'say'", "'scalar'", "'seek'", "'seekdir'", "'select'", "'semctl'", "'semget'", "'semop'", "'send'", "'setgrent'", "'sethostent'", "'setnetent'", "'setpgrp'", "'setpriority'", "'setprotoent'", "'setpwent'", "'setservent'", "'setsockopt'", "'shift'", "'shmctl'", "'shmget'", "'shmread'", "'shmwrite'", "'shutdown'", "'sin'", "'sleep'", "'socket'", "'socketpair'", "'sort'", "'splice'", "'split'", "'sprintf'", "'sqrt'", "'srand'", "'stat'", "'state'", "'study'", "'substr'", "'symlink'", "'syscall'", "'sysopen'", "'sysread'", "'sysseek'", "'system'", "'syswrite'", "'tell'", "'telldir'", "'tie'", "'tied'", "'time'", "'times'", "'tr'", "'truncate'", "'uc'", "'ucfirst'", "'umask'", "'undef'", "'unless'", "'unlink'", "'unpack'", "'unshift'", "'untie'", "'until'", "'utime'", "'values'", "'vec'", "'wait'", "'waitpid'", "'wantarray'", "'warn'", "'when'", "'while'", "'write'", "'y'", "'++'", "'--'", "'**'", "'!'", "'~'", "'+'", "'-'", "'=~'", "'!~'", "'*'", "'/'", "'x'", "'<<'", "'>>'", "'lt'", "'gt'", "'le'", "'ge'", "'cmp'", "'~~'", "'=='", "'!='", "'<=>'", "'.'", "'..'", "'...'", "','", "'|'", "'^'", "'&&'", "'||'", "'//'", "'?'", "':'", "'**='", "'+='", "'-='", "'.='", "'*='", "'/='", "'%='", "'x='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'&&='", "'||='", "'//='", "'<'", "'>'", "'<='", "'>='", "'<>'", "'=>'", "'->'", "'and'", "'or'", "'xor'", "'not'", "'eq'", "'ne'", "'-r'", "'-w'", "'-x'", "'-o'", "'-R'", "'-W'", "'-X'", "'-O'", "'-e'", "'-z'", "'-s'", "'-f'", "'-d'", "'-l'", "'-p'", "'-S'", "'-b'", "'-c'", "'-t'", "'-u'", "'-g'", "'-k'", "'-T'", "'-B'", "'-M'", "'-A'", "'-C'"
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
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__252=252;
    public static final int T__130=130;
    public static final int T__251=251;
    public static final int RULE_DATA=10;
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
    public static final int RULE_REGEX_TRANSLITERATE=16;
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
    public static final int RULE_REGEX_SUBSTITUTE=15;
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
    public static final int RULE_END=11;
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
    public static final int RULE_NUMBER=8;
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
    public static final int RULE_VERSION=5;
    public static final int RULE_LITERAL=14;
    public static final int RULE_BIN=23;
    public static final int RULE_REGEX_MATCH=17;
    public static final int RULE_INTERPOLATE=13;
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
    public static final int RULE_WORDS_QUOTE_LIKE=6;
    public static final int T__169=169;
    public static final int RULE_REGEX_QUOTE=20;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=12;
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
    public static final int RULE_SYMBOL=9;
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

        public InternalPerlParser(TokenStream input, PerlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "PerlDocument";
       	}

       	@Override
       	protected PerlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulePerlDocument"
    // InternalPerl.g:64:1: entryRulePerlDocument returns [EObject current=null] : iv_rulePerlDocument= rulePerlDocument EOF ;
    public final EObject entryRulePerlDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePerlDocument = null;


        try {
            // InternalPerl.g:64:53: (iv_rulePerlDocument= rulePerlDocument EOF )
            // InternalPerl.g:65:2: iv_rulePerlDocument= rulePerlDocument EOF
            {
             newCompositeNode(grammarAccess.getPerlDocumentRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePerlDocument=rulePerlDocument();

            state._fsp--;

             current =iv_rulePerlDocument; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePerlDocument"


    // $ANTLR start "rulePerlDocument"
    // InternalPerl.g:71:1: rulePerlDocument returns [EObject current=null] : ( () ( (lv_elements_1_0= ruleElement ) )* ) ;
    public final EObject rulePerlDocument() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:77:2: ( ( () ( (lv_elements_1_0= ruleElement ) )* ) )
            // InternalPerl.g:78:2: ( () ( (lv_elements_1_0= ruleElement ) )* )
            {
            // InternalPerl.g:78:2: ( () ( (lv_elements_1_0= ruleElement ) )* )
            // InternalPerl.g:79:3: () ( (lv_elements_1_0= ruleElement ) )*
            {
            // InternalPerl.g:79:3: ()
            // InternalPerl.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0(),
            					current);
            			

            }

            // InternalPerl.g:86:3: ( (lv_elements_1_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_WORDS_QUOTE_LIKE && LA1_0<=RULE_READLINE_QUOTE)||(LA1_0>=29 && LA1_0<=33)||LA1_0==37||LA1_0==39||(LA1_0>=41 && LA1_0<=281)||(LA1_0>=283 && LA1_0<=348)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPerl.g:87:4: (lv_elements_1_0= ruleElement )
            	    {
            	    // InternalPerl.g:87:4: (lv_elements_1_0= ruleElement )
            	    // InternalPerl.g:88:5: lv_elements_1_0= ruleElement
            	    {

            	    					newCompositeNode(grammarAccess.getPerlDocumentAccess().getElementsElementParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_elements_1_0=ruleElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPerlDocumentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_1_0,
            	    						"org.epic.perl.Perl.Element");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePerlDocument"


    // $ANTLR start "entryRuleElement"
    // InternalPerl.g:109:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalPerl.g:109:48: (iv_ruleElement= ruleElement EOF )
            // InternalPerl.g:110:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalPerl.g:116:1: ruleElement returns [EObject current=null] : (this_Node_0= ruleNode | this_Token_1= ruleToken ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Node_0 = null;

        EObject this_Token_1 = null;



        	enterRule();

        try {
            // InternalPerl.g:122:2: ( (this_Node_0= ruleNode | this_Token_1= ruleToken ) )
            // InternalPerl.g:123:2: (this_Node_0= ruleNode | this_Token_1= ruleToken )
            {
            // InternalPerl.g:123:2: (this_Node_0= ruleNode | this_Token_1= ruleToken )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==32) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==EOF||(LA2_1>=RULE_WORDS_QUOTE_LIKE && LA2_1<=RULE_READLINE_QUOTE)||(LA2_1>=29 && LA2_1<=33)||LA2_1==37||LA2_1==39||(LA2_1>=41 && LA2_1<=281)||(LA2_1>=283 && LA2_1<=348)) ) {
                    alt2=2;
                }
                else if ( (LA2_1==RULE_ID) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==29) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==RULE_ID) ) {
                    alt2=1;
                }
                else if ( (LA2_2==EOF||(LA2_2>=RULE_WORDS_QUOTE_LIKE && LA2_2<=RULE_READLINE_QUOTE)||(LA2_2>=29 && LA2_2<=33)||LA2_2==37||LA2_2==39||(LA2_2>=41 && LA2_2<=281)||(LA2_2>=283 && LA2_2<=348)) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==30) ) {
                int LA2_3 = input.LA(2);

                if ( (LA2_3==RULE_VERSION) ) {
                    alt2=1;
                }
                else if ( (LA2_3==EOF||(LA2_3>=RULE_WORDS_QUOTE_LIKE && LA2_3<=RULE_READLINE_QUOTE)||(LA2_3>=29 && LA2_3<=33)||LA2_3==37||LA2_3==39||(LA2_3>=41 && LA2_3<=281)||(LA2_3>=283 && LA2_3<=348)) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 3, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==31) ) {
                int LA2_4 = input.LA(2);

                if ( ((LA2_4>=RULE_ID && LA2_4<=RULE_VERSION)) ) {
                    alt2=1;
                }
                else if ( (LA2_4==EOF||(LA2_4>=RULE_WORDS_QUOTE_LIKE && LA2_4<=RULE_READLINE_QUOTE)||(LA2_4>=29 && LA2_4<=33)||LA2_4==37||LA2_4==39||(LA2_4>=41 && LA2_4<=281)||(LA2_4>=283 && LA2_4<=348)) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 4, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==33) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=RULE_WORDS_QUOTE_LIKE && LA2_0<=RULE_READLINE_QUOTE)||LA2_0==37||LA2_0==39||(LA2_0>=41 && LA2_0<=281)||(LA2_0>=283 && LA2_0<=348)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalPerl.g:124:3: this_Node_0= ruleNode
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getNodeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Node_0=ruleNode();

                    state._fsp--;


                    			current = this_Node_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:133:3: this_Token_1= ruleToken
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getTokenParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Token_1=ruleToken();

                    state._fsp--;


                    			current = this_Token_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleNode"
    // InternalPerl.g:145:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalPerl.g:145:45: (iv_ruleNode= ruleNode EOF )
            // InternalPerl.g:146:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalPerl.g:152:1: ruleNode returns [EObject current=null] : (this_StatementNode_0= ruleStatementNode | this_StructureNode_1= ruleStructureNode ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        EObject this_StatementNode_0 = null;

        EObject this_StructureNode_1 = null;



        	enterRule();

        try {
            // InternalPerl.g:158:2: ( (this_StatementNode_0= ruleStatementNode | this_StructureNode_1= ruleStructureNode ) )
            // InternalPerl.g:159:2: (this_StatementNode_0= ruleStatementNode | this_StructureNode_1= ruleStructureNode )
            {
            // InternalPerl.g:159:2: (this_StatementNode_0= ruleStatementNode | this_StructureNode_1= ruleStructureNode )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=29 && LA3_0<=32)) ) {
                alt3=1;
            }
            else if ( (LA3_0==33) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalPerl.g:160:3: this_StatementNode_0= ruleStatementNode
                    {

                    			newCompositeNode(grammarAccess.getNodeAccess().getStatementNodeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StatementNode_0=ruleStatementNode();

                    state._fsp--;


                    			current = this_StatementNode_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:169:3: this_StructureNode_1= ruleStructureNode
                    {

                    			newCompositeNode(grammarAccess.getNodeAccess().getStructureNodeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StructureNode_1=ruleStructureNode();

                    state._fsp--;


                    			current = this_StructureNode_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleStatementNode"
    // InternalPerl.g:181:1: entryRuleStatementNode returns [EObject current=null] : iv_ruleStatementNode= ruleStatementNode EOF ;
    public final EObject entryRuleStatementNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementNode = null;


        try {
            // InternalPerl.g:181:54: (iv_ruleStatementNode= ruleStatementNode EOF )
            // InternalPerl.g:182:2: iv_ruleStatementNode= ruleStatementNode EOF
            {
             newCompositeNode(grammarAccess.getStatementNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatementNode=ruleStatementNode();

            state._fsp--;

             current =iv_ruleStatementNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatementNode"


    // $ANTLR start "ruleStatementNode"
    // InternalPerl.g:188:1: ruleStatementNode returns [EObject current=null] : (this_BlockStatement_0= ruleBlockStatement | this_ExpressionStatement_1= ruleExpressionStatement ) ;
    public final EObject ruleStatementNode() throws RecognitionException {
        EObject current = null;

        EObject this_BlockStatement_0 = null;

        EObject this_ExpressionStatement_1 = null;



        	enterRule();

        try {
            // InternalPerl.g:194:2: ( (this_BlockStatement_0= ruleBlockStatement | this_ExpressionStatement_1= ruleExpressionStatement ) )
            // InternalPerl.g:195:2: (this_BlockStatement_0= ruleBlockStatement | this_ExpressionStatement_1= ruleExpressionStatement )
            {
            // InternalPerl.g:195:2: (this_BlockStatement_0= ruleBlockStatement | this_ExpressionStatement_1= ruleExpressionStatement )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==32) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=29 && LA4_0<=31)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalPerl.g:196:3: this_BlockStatement_0= ruleBlockStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementNodeAccess().getBlockStatementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BlockStatement_0=ruleBlockStatement();

                    state._fsp--;


                    			current = this_BlockStatement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:205:3: this_ExpressionStatement_1= ruleExpressionStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementNodeAccess().getExpressionStatementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExpressionStatement_1=ruleExpressionStatement();

                    state._fsp--;


                    			current = this_ExpressionStatement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementNode"


    // $ANTLR start "entryRuleBlockStatement"
    // InternalPerl.g:217:1: entryRuleBlockStatement returns [EObject current=null] : iv_ruleBlockStatement= ruleBlockStatement EOF ;
    public final EObject entryRuleBlockStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockStatement = null;


        try {
            // InternalPerl.g:217:55: (iv_ruleBlockStatement= ruleBlockStatement EOF )
            // InternalPerl.g:218:2: iv_ruleBlockStatement= ruleBlockStatement EOF
            {
             newCompositeNode(grammarAccess.getBlockStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlockStatement=ruleBlockStatement();

            state._fsp--;

             current =iv_ruleBlockStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockStatement"


    // $ANTLR start "ruleBlockStatement"
    // InternalPerl.g:224:1: ruleBlockStatement returns [EObject current=null] : this_SubStatement_0= ruleSubStatement ;
    public final EObject ruleBlockStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SubStatement_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:230:2: (this_SubStatement_0= ruleSubStatement )
            // InternalPerl.g:231:2: this_SubStatement_0= ruleSubStatement
            {

            		newCompositeNode(grammarAccess.getBlockStatementAccess().getSubStatementParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_SubStatement_0=ruleSubStatement();

            state._fsp--;


            		current = this_SubStatement_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockStatement"


    // $ANTLR start "entryRuleExpressionStatement"
    // InternalPerl.g:242:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalPerl.g:242:60: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalPerl.g:243:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
             newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;

             current =iv_ruleExpressionStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionStatement"


    // $ANTLR start "ruleExpressionStatement"
    // InternalPerl.g:249:1: ruleExpressionStatement returns [EObject current=null] : ( (this_PackageStatement_0= rulePackageStatement | this_IncludeStatement_1= ruleIncludeStatement ) otherlv_2= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PackageStatement_0 = null;

        EObject this_IncludeStatement_1 = null;



        	enterRule();

        try {
            // InternalPerl.g:255:2: ( ( (this_PackageStatement_0= rulePackageStatement | this_IncludeStatement_1= ruleIncludeStatement ) otherlv_2= ';' ) )
            // InternalPerl.g:256:2: ( (this_PackageStatement_0= rulePackageStatement | this_IncludeStatement_1= ruleIncludeStatement ) otherlv_2= ';' )
            {
            // InternalPerl.g:256:2: ( (this_PackageStatement_0= rulePackageStatement | this_IncludeStatement_1= ruleIncludeStatement ) otherlv_2= ';' )
            // InternalPerl.g:257:3: (this_PackageStatement_0= rulePackageStatement | this_IncludeStatement_1= ruleIncludeStatement ) otherlv_2= ';'
            {
            // InternalPerl.g:257:3: (this_PackageStatement_0= rulePackageStatement | this_IncludeStatement_1= ruleIncludeStatement )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==29) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=30 && LA5_0<=31)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalPerl.g:258:4: this_PackageStatement_0= rulePackageStatement
                    {

                    				newCompositeNode(grammarAccess.getExpressionStatementAccess().getPackageStatementParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_4);
                    this_PackageStatement_0=rulePackageStatement();

                    state._fsp--;


                    				current = this_PackageStatement_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalPerl.g:267:4: this_IncludeStatement_1= ruleIncludeStatement
                    {

                    				newCompositeNode(grammarAccess.getExpressionStatementAccess().getIncludeStatementParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_4);
                    this_IncludeStatement_1=ruleIncludeStatement();

                    state._fsp--;


                    				current = this_IncludeStatement_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionStatement"


    // $ANTLR start "entryRuleStructureNode"
    // InternalPerl.g:284:1: entryRuleStructureNode returns [EObject current=null] : iv_ruleStructureNode= ruleStructureNode EOF ;
    public final EObject entryRuleStructureNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructureNode = null;


        try {
            // InternalPerl.g:284:54: (iv_ruleStructureNode= ruleStructureNode EOF )
            // InternalPerl.g:285:2: iv_ruleStructureNode= ruleStructureNode EOF
            {
             newCompositeNode(grammarAccess.getStructureNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStructureNode=ruleStructureNode();

            state._fsp--;

             current =iv_ruleStructureNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructureNode"


    // $ANTLR start "ruleStructureNode"
    // InternalPerl.g:291:1: ruleStructureNode returns [EObject current=null] : this_BlockStructure_0= ruleBlockStructure ;
    public final EObject ruleStructureNode() throws RecognitionException {
        EObject current = null;

        EObject this_BlockStructure_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:297:2: (this_BlockStructure_0= ruleBlockStructure )
            // InternalPerl.g:298:2: this_BlockStructure_0= ruleBlockStructure
            {

            		newCompositeNode(grammarAccess.getStructureNodeAccess().getBlockStructureParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_BlockStructure_0=ruleBlockStructure();

            state._fsp--;


            		current = this_BlockStructure_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructureNode"


    // $ANTLR start "entryRulePackageStatement"
    // InternalPerl.g:309:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // InternalPerl.g:309:57: (iv_rulePackageStatement= rulePackageStatement EOF )
            // InternalPerl.g:310:2: iv_rulePackageStatement= rulePackageStatement EOF
            {
             newCompositeNode(grammarAccess.getPackageStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageStatement=rulePackageStatement();

            state._fsp--;

             current =iv_rulePackageStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageStatement"


    // $ANTLR start "rulePackageStatement"
    // InternalPerl.g:316:1: rulePackageStatement returns [EObject current=null] : ( () otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) ( (lv_version_3_0= RULE_VERSION ) )? ) ;
    public final EObject rulePackageStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_version_3_0=null;


        	enterRule();

        try {
            // InternalPerl.g:322:2: ( ( () otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) ( (lv_version_3_0= RULE_VERSION ) )? ) )
            // InternalPerl.g:323:2: ( () otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) ( (lv_version_3_0= RULE_VERSION ) )? )
            {
            // InternalPerl.g:323:2: ( () otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) ( (lv_version_3_0= RULE_VERSION ) )? )
            // InternalPerl.g:324:3: () otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) ( (lv_version_3_0= RULE_VERSION ) )?
            {
            // InternalPerl.g:324:3: ()
            // InternalPerl.g:325:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPackageStatementAccess().getPackageStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,29,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getPackageStatementAccess().getPackageKeyword_1());
            		
            // InternalPerl.g:335:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalPerl.g:336:4: (lv_name_2_0= RULE_ID )
            {
            // InternalPerl.g:336:4: (lv_name_2_0= RULE_ID )
            // InternalPerl.g:337:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_2_0, grammarAccess.getPackageStatementAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPackageStatementRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.epic.perl.Perl.ID");
            				

            }


            }

            // InternalPerl.g:353:3: ( (lv_version_3_0= RULE_VERSION ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_VERSION) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalPerl.g:354:4: (lv_version_3_0= RULE_VERSION )
                    {
                    // InternalPerl.g:354:4: (lv_version_3_0= RULE_VERSION )
                    // InternalPerl.g:355:5: lv_version_3_0= RULE_VERSION
                    {
                    lv_version_3_0=(Token)match(input,RULE_VERSION,FOLLOW_2); 

                    					newLeafNode(lv_version_3_0, grammarAccess.getPackageStatementAccess().getVersionVERSIONTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPackageStatementRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"version",
                    						lv_version_3_0,
                    						"org.epic.perl.Perl.VERSION");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageStatement"


    // $ANTLR start "entryRuleIncludeStatement"
    // InternalPerl.g:375:1: entryRuleIncludeStatement returns [EObject current=null] : iv_ruleIncludeStatement= ruleIncludeStatement EOF ;
    public final EObject entryRuleIncludeStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeStatement = null;


        try {
            // InternalPerl.g:375:57: (iv_ruleIncludeStatement= ruleIncludeStatement EOF )
            // InternalPerl.g:376:2: iv_ruleIncludeStatement= ruleIncludeStatement EOF
            {
             newCompositeNode(grammarAccess.getIncludeStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIncludeStatement=ruleIncludeStatement();

            state._fsp--;

             current =iv_ruleIncludeStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIncludeStatement"


    // $ANTLR start "ruleIncludeStatement"
    // InternalPerl.g:382:1: ruleIncludeStatement returns [EObject current=null] : (this_RequireInclude_0= ruleRequireInclude | this_UseInclude_1= ruleUseInclude ) ;
    public final EObject ruleIncludeStatement() throws RecognitionException {
        EObject current = null;

        EObject this_RequireInclude_0 = null;

        EObject this_UseInclude_1 = null;



        	enterRule();

        try {
            // InternalPerl.g:388:2: ( (this_RequireInclude_0= ruleRequireInclude | this_UseInclude_1= ruleUseInclude ) )
            // InternalPerl.g:389:2: (this_RequireInclude_0= ruleRequireInclude | this_UseInclude_1= ruleUseInclude )
            {
            // InternalPerl.g:389:2: (this_RequireInclude_0= ruleRequireInclude | this_UseInclude_1= ruleUseInclude )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==30) ) {
                alt7=1;
            }
            else if ( (LA7_0==31) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalPerl.g:390:3: this_RequireInclude_0= ruleRequireInclude
                    {

                    			newCompositeNode(grammarAccess.getIncludeStatementAccess().getRequireIncludeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RequireInclude_0=ruleRequireInclude();

                    state._fsp--;


                    			current = this_RequireInclude_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:399:3: this_UseInclude_1= ruleUseInclude
                    {

                    			newCompositeNode(grammarAccess.getIncludeStatementAccess().getUseIncludeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UseInclude_1=ruleUseInclude();

                    state._fsp--;


                    			current = this_UseInclude_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIncludeStatement"


    // $ANTLR start "entryRuleRequireInclude"
    // InternalPerl.g:411:1: entryRuleRequireInclude returns [EObject current=null] : iv_ruleRequireInclude= ruleRequireInclude EOF ;
    public final EObject entryRuleRequireInclude() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequireInclude = null;


        try {
            // InternalPerl.g:411:55: (iv_ruleRequireInclude= ruleRequireInclude EOF )
            // InternalPerl.g:412:2: iv_ruleRequireInclude= ruleRequireInclude EOF
            {
             newCompositeNode(grammarAccess.getRequireIncludeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequireInclude=ruleRequireInclude();

            state._fsp--;

             current =iv_ruleRequireInclude; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequireInclude"


    // $ANTLR start "ruleRequireInclude"
    // InternalPerl.g:418:1: ruleRequireInclude returns [EObject current=null] : (otherlv_0= 'require' ( (lv_version_1_0= RULE_VERSION ) ) ) ;
    public final EObject ruleRequireInclude() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;


        	enterRule();

        try {
            // InternalPerl.g:424:2: ( (otherlv_0= 'require' ( (lv_version_1_0= RULE_VERSION ) ) ) )
            // InternalPerl.g:425:2: (otherlv_0= 'require' ( (lv_version_1_0= RULE_VERSION ) ) )
            {
            // InternalPerl.g:425:2: (otherlv_0= 'require' ( (lv_version_1_0= RULE_VERSION ) ) )
            // InternalPerl.g:426:3: otherlv_0= 'require' ( (lv_version_1_0= RULE_VERSION ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getRequireIncludeAccess().getRequireKeyword_0());
            		
            // InternalPerl.g:430:3: ( (lv_version_1_0= RULE_VERSION ) )
            // InternalPerl.g:431:4: (lv_version_1_0= RULE_VERSION )
            {
            // InternalPerl.g:431:4: (lv_version_1_0= RULE_VERSION )
            // InternalPerl.g:432:5: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_2); 

            					newLeafNode(lv_version_1_0, grammarAccess.getRequireIncludeAccess().getVersionVERSIONTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRequireIncludeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"version",
            						lv_version_1_0,
            						"org.epic.perl.Perl.VERSION");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequireInclude"


    // $ANTLR start "entryRuleUseInclude"
    // InternalPerl.g:452:1: entryRuleUseInclude returns [EObject current=null] : iv_ruleUseInclude= ruleUseInclude EOF ;
    public final EObject entryRuleUseInclude() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseInclude = null;


        try {
            // InternalPerl.g:452:51: (iv_ruleUseInclude= ruleUseInclude EOF )
            // InternalPerl.g:453:2: iv_ruleUseInclude= ruleUseInclude EOF
            {
             newCompositeNode(grammarAccess.getUseIncludeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUseInclude=ruleUseInclude();

            state._fsp--;

             current =iv_ruleUseInclude; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUseInclude"


    // $ANTLR start "ruleUseInclude"
    // InternalPerl.g:459:1: ruleUseInclude returns [EObject current=null] : ( () otherlv_1= 'use' ( ( (lv_version_2_0= RULE_VERSION ) ) | ( ( (lv_pragmaOrPackage_3_0= RULE_ID ) ) ( ( (lv_stringArgument_4_0= ruleQuoteToken ) ) | ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) ) )? ) ) ) ;
    public final EObject ruleUseInclude() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_version_2_0=null;
        Token lv_pragmaOrPackage_3_0=null;
        Token lv_qwArgument_5_0=null;
        EObject lv_stringArgument_4_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:465:2: ( ( () otherlv_1= 'use' ( ( (lv_version_2_0= RULE_VERSION ) ) | ( ( (lv_pragmaOrPackage_3_0= RULE_ID ) ) ( ( (lv_stringArgument_4_0= ruleQuoteToken ) ) | ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) ) )? ) ) ) )
            // InternalPerl.g:466:2: ( () otherlv_1= 'use' ( ( (lv_version_2_0= RULE_VERSION ) ) | ( ( (lv_pragmaOrPackage_3_0= RULE_ID ) ) ( ( (lv_stringArgument_4_0= ruleQuoteToken ) ) | ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) ) )? ) ) )
            {
            // InternalPerl.g:466:2: ( () otherlv_1= 'use' ( ( (lv_version_2_0= RULE_VERSION ) ) | ( ( (lv_pragmaOrPackage_3_0= RULE_ID ) ) ( ( (lv_stringArgument_4_0= ruleQuoteToken ) ) | ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) ) )? ) ) )
            // InternalPerl.g:467:3: () otherlv_1= 'use' ( ( (lv_version_2_0= RULE_VERSION ) ) | ( ( (lv_pragmaOrPackage_3_0= RULE_ID ) ) ( ( (lv_stringArgument_4_0= ruleQuoteToken ) ) | ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) ) )? ) )
            {
            // InternalPerl.g:467:3: ()
            // InternalPerl.g:468:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUseIncludeAccess().getUseIncludeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,31,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getUseIncludeAccess().getUseKeyword_1());
            		
            // InternalPerl.g:478:3: ( ( (lv_version_2_0= RULE_VERSION ) ) | ( ( (lv_pragmaOrPackage_3_0= RULE_ID ) ) ( ( (lv_stringArgument_4_0= ruleQuoteToken ) ) | ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) ) )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_VERSION) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalPerl.g:479:4: ( (lv_version_2_0= RULE_VERSION ) )
                    {
                    // InternalPerl.g:479:4: ( (lv_version_2_0= RULE_VERSION ) )
                    // InternalPerl.g:480:5: (lv_version_2_0= RULE_VERSION )
                    {
                    // InternalPerl.g:480:5: (lv_version_2_0= RULE_VERSION )
                    // InternalPerl.g:481:6: lv_version_2_0= RULE_VERSION
                    {
                    lv_version_2_0=(Token)match(input,RULE_VERSION,FOLLOW_2); 

                    						newLeafNode(lv_version_2_0, grammarAccess.getUseIncludeAccess().getVersionVERSIONTerminalRuleCall_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getUseIncludeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"version",
                    							lv_version_2_0,
                    							"org.epic.perl.Perl.VERSION");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:498:4: ( ( (lv_pragmaOrPackage_3_0= RULE_ID ) ) ( ( (lv_stringArgument_4_0= ruleQuoteToken ) ) | ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) ) )? )
                    {
                    // InternalPerl.g:498:4: ( ( (lv_pragmaOrPackage_3_0= RULE_ID ) ) ( ( (lv_stringArgument_4_0= ruleQuoteToken ) ) | ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) ) )? )
                    // InternalPerl.g:499:5: ( (lv_pragmaOrPackage_3_0= RULE_ID ) ) ( ( (lv_stringArgument_4_0= ruleQuoteToken ) ) | ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) ) )?
                    {
                    // InternalPerl.g:499:5: ( (lv_pragmaOrPackage_3_0= RULE_ID ) )
                    // InternalPerl.g:500:6: (lv_pragmaOrPackage_3_0= RULE_ID )
                    {
                    // InternalPerl.g:500:6: (lv_pragmaOrPackage_3_0= RULE_ID )
                    // InternalPerl.g:501:7: lv_pragmaOrPackage_3_0= RULE_ID
                    {
                    lv_pragmaOrPackage_3_0=(Token)match(input,RULE_ID,FOLLOW_9); 

                    							newLeafNode(lv_pragmaOrPackage_3_0, grammarAccess.getUseIncludeAccess().getPragmaOrPackageIDTerminalRuleCall_2_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getUseIncludeRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"pragmaOrPackage",
                    								lv_pragmaOrPackage_3_0,
                    								"org.epic.perl.Perl.ID");
                    						

                    }


                    }

                    // InternalPerl.g:517:5: ( ( (lv_stringArgument_4_0= ruleQuoteToken ) ) | ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) ) )?
                    int alt8=3;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_LITERAL)) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==RULE_WORDS_QUOTE_LIKE) ) {
                        alt8=2;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalPerl.g:518:6: ( (lv_stringArgument_4_0= ruleQuoteToken ) )
                            {
                            // InternalPerl.g:518:6: ( (lv_stringArgument_4_0= ruleQuoteToken ) )
                            // InternalPerl.g:519:7: (lv_stringArgument_4_0= ruleQuoteToken )
                            {
                            // InternalPerl.g:519:7: (lv_stringArgument_4_0= ruleQuoteToken )
                            // InternalPerl.g:520:8: lv_stringArgument_4_0= ruleQuoteToken
                            {

                            								newCompositeNode(grammarAccess.getUseIncludeAccess().getStringArgumentQuoteTokenParserRuleCall_2_1_1_0_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_stringArgument_4_0=ruleQuoteToken();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getUseIncludeRule());
                            								}
                            								set(
                            									current,
                            									"stringArgument",
                            									lv_stringArgument_4_0,
                            									"org.epic.perl.Perl.QuoteToken");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalPerl.g:538:6: ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) )
                            {
                            // InternalPerl.g:538:6: ( (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE ) )
                            // InternalPerl.g:539:7: (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE )
                            {
                            // InternalPerl.g:539:7: (lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE )
                            // InternalPerl.g:540:8: lv_qwArgument_5_0= RULE_WORDS_QUOTE_LIKE
                            {
                            lv_qwArgument_5_0=(Token)match(input,RULE_WORDS_QUOTE_LIKE,FOLLOW_2); 

                            								newLeafNode(lv_qwArgument_5_0, grammarAccess.getUseIncludeAccess().getQwArgumentWORDS_QUOTE_LIKETerminalRuleCall_2_1_1_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getUseIncludeRule());
                            								}
                            								setWithLastConsumed(
                            									current,
                            									"qwArgument",
                            									lv_qwArgument_5_0,
                            									"org.epic.perl.Perl.WORDS_QUOTE_LIKE");
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUseInclude"


    // $ANTLR start "entryRuleSubStatement"
    // InternalPerl.g:563:1: entryRuleSubStatement returns [EObject current=null] : iv_ruleSubStatement= ruleSubStatement EOF ;
    public final EObject entryRuleSubStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubStatement = null;


        try {
            // InternalPerl.g:563:53: (iv_ruleSubStatement= ruleSubStatement EOF )
            // InternalPerl.g:564:2: iv_ruleSubStatement= ruleSubStatement EOF
            {
             newCompositeNode(grammarAccess.getSubStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubStatement=ruleSubStatement();

            state._fsp--;

             current =iv_ruleSubStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubStatement"


    // $ANTLR start "ruleSubStatement"
    // InternalPerl.g:570:1: ruleSubStatement returns [EObject current=null] : ( () otherlv_1= 'sub' ( (lv_name_2_0= RULE_ID ) ) ( (lv_prototype_3_0= rulePrototype ) )? (otherlv_4= ';' | ( (lv_block_5_0= ruleBlockStructure ) ) ) ) ;
    public final EObject ruleSubStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_prototype_3_0 = null;

        EObject lv_block_5_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:576:2: ( ( () otherlv_1= 'sub' ( (lv_name_2_0= RULE_ID ) ) ( (lv_prototype_3_0= rulePrototype ) )? (otherlv_4= ';' | ( (lv_block_5_0= ruleBlockStructure ) ) ) ) )
            // InternalPerl.g:577:2: ( () otherlv_1= 'sub' ( (lv_name_2_0= RULE_ID ) ) ( (lv_prototype_3_0= rulePrototype ) )? (otherlv_4= ';' | ( (lv_block_5_0= ruleBlockStructure ) ) ) )
            {
            // InternalPerl.g:577:2: ( () otherlv_1= 'sub' ( (lv_name_2_0= RULE_ID ) ) ( (lv_prototype_3_0= rulePrototype ) )? (otherlv_4= ';' | ( (lv_block_5_0= ruleBlockStructure ) ) ) )
            // InternalPerl.g:578:3: () otherlv_1= 'sub' ( (lv_name_2_0= RULE_ID ) ) ( (lv_prototype_3_0= rulePrototype ) )? (otherlv_4= ';' | ( (lv_block_5_0= ruleBlockStructure ) ) )
            {
            // InternalPerl.g:578:3: ()
            // InternalPerl.g:579:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubStatementAccess().getSubStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,32,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getSubStatementAccess().getSubKeyword_1());
            		
            // InternalPerl.g:589:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalPerl.g:590:4: (lv_name_2_0= RULE_ID )
            {
            // InternalPerl.g:590:4: (lv_name_2_0= RULE_ID )
            // InternalPerl.g:591:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getSubStatementAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubStatementRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.epic.perl.Perl.ID");
            				

            }


            }

            // InternalPerl.g:607:3: ( (lv_prototype_3_0= rulePrototype ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==35) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalPerl.g:608:4: (lv_prototype_3_0= rulePrototype )
                    {
                    // InternalPerl.g:608:4: (lv_prototype_3_0= rulePrototype )
                    // InternalPerl.g:609:5: lv_prototype_3_0= rulePrototype
                    {

                    					newCompositeNode(grammarAccess.getSubStatementAccess().getPrototypePrototypeParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_11);
                    lv_prototype_3_0=rulePrototype();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSubStatementRule());
                    					}
                    					set(
                    						current,
                    						"prototype",
                    						lv_prototype_3_0,
                    						"org.epic.perl.Perl.Prototype");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalPerl.g:626:3: (otherlv_4= ';' | ( (lv_block_5_0= ruleBlockStructure ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            else if ( (LA11_0==33) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalPerl.g:627:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getSubStatementAccess().getSemicolonKeyword_4_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalPerl.g:632:4: ( (lv_block_5_0= ruleBlockStructure ) )
                    {
                    // InternalPerl.g:632:4: ( (lv_block_5_0= ruleBlockStructure ) )
                    // InternalPerl.g:633:5: (lv_block_5_0= ruleBlockStructure )
                    {
                    // InternalPerl.g:633:5: (lv_block_5_0= ruleBlockStructure )
                    // InternalPerl.g:634:6: lv_block_5_0= ruleBlockStructure
                    {

                    						newCompositeNode(grammarAccess.getSubStatementAccess().getBlockBlockStructureParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_block_5_0=ruleBlockStructure();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSubStatementRule());
                    						}
                    						set(
                    							current,
                    							"block",
                    							lv_block_5_0,
                    							"org.epic.perl.Perl.BlockStructure");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubStatement"


    // $ANTLR start "entryRuleBlockStructure"
    // InternalPerl.g:656:1: entryRuleBlockStructure returns [EObject current=null] : iv_ruleBlockStructure= ruleBlockStructure EOF ;
    public final EObject entryRuleBlockStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockStructure = null;


        try {
            // InternalPerl.g:656:55: (iv_ruleBlockStructure= ruleBlockStructure EOF )
            // InternalPerl.g:657:2: iv_ruleBlockStructure= ruleBlockStructure EOF
            {
             newCompositeNode(grammarAccess.getBlockStructureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlockStructure=ruleBlockStructure();

            state._fsp--;

             current =iv_ruleBlockStructure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockStructure"


    // $ANTLR start "ruleBlockStructure"
    // InternalPerl.g:663:1: ruleBlockStructure returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatementNode ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlockStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:669:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatementNode ) )* otherlv_3= '}' ) )
            // InternalPerl.g:670:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatementNode ) )* otherlv_3= '}' )
            {
            // InternalPerl.g:670:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatementNode ) )* otherlv_3= '}' )
            // InternalPerl.g:671:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatementNode ) )* otherlv_3= '}'
            {
            // InternalPerl.g:671:3: ()
            // InternalPerl.g:672:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBlockStructureAccess().getBlockStructureAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,33,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getBlockStructureAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalPerl.g:682:3: ( (lv_statements_2_0= ruleStatementNode ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=29 && LA12_0<=32)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPerl.g:683:4: (lv_statements_2_0= ruleStatementNode )
            	    {
            	    // InternalPerl.g:683:4: (lv_statements_2_0= ruleStatementNode )
            	    // InternalPerl.g:684:5: lv_statements_2_0= ruleStatementNode
            	    {

            	    					newCompositeNode(grammarAccess.getBlockStructureAccess().getStatementsStatementNodeParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_statements_2_0=ruleStatementNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBlockStructureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_2_0,
            	    						"org.epic.perl.Perl.StatementNode");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_3=(Token)match(input,34,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getBlockStructureAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockStructure"


    // $ANTLR start "entryRulePrototype"
    // InternalPerl.g:709:1: entryRulePrototype returns [String current=null] : iv_rulePrototype= rulePrototype EOF ;
    public final String entryRulePrototype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrototype = null;


        try {
            // InternalPerl.g:709:49: (iv_rulePrototype= rulePrototype EOF )
            // InternalPerl.g:710:2: iv_rulePrototype= rulePrototype EOF
            {
             newCompositeNode(grammarAccess.getPrototypeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrototype=rulePrototype();

            state._fsp--;

             current =iv_rulePrototype.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrototype"


    // $ANTLR start "rulePrototype"
    // InternalPerl.g:716:1: rulePrototype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' (kw= '$' | kw= '%' | kw= '@' | kw= '&' | kw= ';' )* kw= ')' ) ;
    public final AntlrDatatypeRuleToken rulePrototype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:722:2: ( (kw= '(' (kw= '$' | kw= '%' | kw= '@' | kw= '&' | kw= ';' )* kw= ')' ) )
            // InternalPerl.g:723:2: (kw= '(' (kw= '$' | kw= '%' | kw= '@' | kw= '&' | kw= ';' )* kw= ')' )
            {
            // InternalPerl.g:723:2: (kw= '(' (kw= '$' | kw= '%' | kw= '@' | kw= '&' | kw= ';' )* kw= ')' )
            // InternalPerl.g:724:3: kw= '(' (kw= '$' | kw= '%' | kw= '@' | kw= '&' | kw= ';' )* kw= ')'
            {
            kw=(Token)match(input,35,FOLLOW_13); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getPrototypeAccess().getLeftParenthesisKeyword_0());
            		
            // InternalPerl.g:729:3: (kw= '$' | kw= '%' | kw= '@' | kw= '&' | kw= ';' )*
            loop13:
            do {
                int alt13=6;
                switch ( input.LA(1) ) {
                case 36:
                    {
                    alt13=1;
                    }
                    break;
                case 37:
                    {
                    alt13=2;
                    }
                    break;
                case 38:
                    {
                    alt13=3;
                    }
                    break;
                case 39:
                    {
                    alt13=4;
                    }
                    break;
                case 28:
                    {
                    alt13=5;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // InternalPerl.g:730:4: kw= '$'
            	    {
            	    kw=(Token)match(input,36,FOLLOW_13); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getPrototypeAccess().getDollarSignKeyword_1_0());
            	    			

            	    }
            	    break;
            	case 2 :
            	    // InternalPerl.g:736:4: kw= '%'
            	    {
            	    kw=(Token)match(input,37,FOLLOW_13); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getPrototypeAccess().getPercentSignKeyword_1_1());
            	    			

            	    }
            	    break;
            	case 3 :
            	    // InternalPerl.g:742:4: kw= '@'
            	    {
            	    kw=(Token)match(input,38,FOLLOW_13); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getPrototypeAccess().getCommercialAtKeyword_1_2());
            	    			

            	    }
            	    break;
            	case 4 :
            	    // InternalPerl.g:748:4: kw= '&'
            	    {
            	    kw=(Token)match(input,39,FOLLOW_13); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getPrototypeAccess().getAmpersandKeyword_1_3());
            	    			

            	    }
            	    break;
            	case 5 :
            	    // InternalPerl.g:754:4: kw= ';'
            	    {
            	    kw=(Token)match(input,28,FOLLOW_13); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getPrototypeAccess().getSemicolonKeyword_1_4());
            	    			

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            kw=(Token)match(input,40,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getPrototypeAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrototype"


    // $ANTLR start "entryRuleToken"
    // InternalPerl.g:769:1: entryRuleToken returns [EObject current=null] : iv_ruleToken= ruleToken EOF ;
    public final EObject entryRuleToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleToken = null;


        try {
            // InternalPerl.g:769:46: (iv_ruleToken= ruleToken EOF )
            // InternalPerl.g:770:2: iv_ruleToken= ruleToken EOF
            {
             newCompositeNode(grammarAccess.getTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleToken=ruleToken();

            state._fsp--;

             current =iv_ruleToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleToken"


    // $ANTLR start "ruleToken"
    // InternalPerl.g:776:1: ruleToken returns [EObject current=null] : ( ( () ( (lv_content_1_0= RULE_POD ) ) ) | ( () ( (lv_content_3_0= RULE_NUMBER ) ) ) | ( () ( (lv_content_5_0= ruleWord ) ) ) | ( () ( (lv_content_7_0= RULE_SYMBOL ) ) ) | this_QuoteLikeToken_8= ruleQuoteLikeToken | ( () ( (lv_content_10_0= ruleFileTestOperator ) ) ) | ( () ( (lv_content_12_0= ruleOperator ) ) ) | this_QuoteToken_13= ruleQuoteToken | this_RegexToken_14= ruleRegexToken | ( () ( (lv_content_16_0= RULE_DATA ) ) ) | ( () ( (lv_content_18_0= RULE_END ) ) ) ) ;
    public final EObject ruleToken() throws RecognitionException {
        EObject current = null;

        Token lv_content_1_0=null;
        Token lv_content_3_0=null;
        Token lv_content_7_0=null;
        Token lv_content_16_0=null;
        Token lv_content_18_0=null;
        AntlrDatatypeRuleToken lv_content_5_0 = null;

        EObject this_QuoteLikeToken_8 = null;

        AntlrDatatypeRuleToken lv_content_10_0 = null;

        AntlrDatatypeRuleToken lv_content_12_0 = null;

        EObject this_QuoteToken_13 = null;

        EObject this_RegexToken_14 = null;



        	enterRule();

        try {
            // InternalPerl.g:782:2: ( ( ( () ( (lv_content_1_0= RULE_POD ) ) ) | ( () ( (lv_content_3_0= RULE_NUMBER ) ) ) | ( () ( (lv_content_5_0= ruleWord ) ) ) | ( () ( (lv_content_7_0= RULE_SYMBOL ) ) ) | this_QuoteLikeToken_8= ruleQuoteLikeToken | ( () ( (lv_content_10_0= ruleFileTestOperator ) ) ) | ( () ( (lv_content_12_0= ruleOperator ) ) ) | this_QuoteToken_13= ruleQuoteToken | this_RegexToken_14= ruleRegexToken | ( () ( (lv_content_16_0= RULE_DATA ) ) ) | ( () ( (lv_content_18_0= RULE_END ) ) ) ) )
            // InternalPerl.g:783:2: ( ( () ( (lv_content_1_0= RULE_POD ) ) ) | ( () ( (lv_content_3_0= RULE_NUMBER ) ) ) | ( () ( (lv_content_5_0= ruleWord ) ) ) | ( () ( (lv_content_7_0= RULE_SYMBOL ) ) ) | this_QuoteLikeToken_8= ruleQuoteLikeToken | ( () ( (lv_content_10_0= ruleFileTestOperator ) ) ) | ( () ( (lv_content_12_0= ruleOperator ) ) ) | this_QuoteToken_13= ruleQuoteToken | this_RegexToken_14= ruleRegexToken | ( () ( (lv_content_16_0= RULE_DATA ) ) ) | ( () ( (lv_content_18_0= RULE_END ) ) ) )
            {
            // InternalPerl.g:783:2: ( ( () ( (lv_content_1_0= RULE_POD ) ) ) | ( () ( (lv_content_3_0= RULE_NUMBER ) ) ) | ( () ( (lv_content_5_0= ruleWord ) ) ) | ( () ( (lv_content_7_0= RULE_SYMBOL ) ) ) | this_QuoteLikeToken_8= ruleQuoteLikeToken | ( () ( (lv_content_10_0= ruleFileTestOperator ) ) ) | ( () ( (lv_content_12_0= ruleOperator ) ) ) | this_QuoteToken_13= ruleQuoteToken | this_RegexToken_14= ruleRegexToken | ( () ( (lv_content_16_0= RULE_DATA ) ) ) | ( () ( (lv_content_18_0= RULE_END ) ) ) )
            int alt14=11;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_POD) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_NUMBER) ) {
                alt14=2;
            }
            else if ( ((LA14_0>=29 && LA14_0<=32)||(LA14_0>=41 && LA14_0<=258)) ) {
                alt14=3;
            }
            else if ( (LA14_0==RULE_SYMBOL) ) {
                alt14=4;
            }
            else if ( (LA14_0==RULE_WORDS_QUOTE_LIKE||(LA14_0>=RULE_BACKTICK_STRING && LA14_0<=RULE_READLINE_QUOTE)) ) {
                alt14=5;
            }
            else if ( ((LA14_0>=322 && LA14_0<=348)) ) {
                alt14=6;
            }
            else if ( (LA14_0==37||LA14_0==39||(LA14_0>=259 && LA14_0<=281)||(LA14_0>=283 && LA14_0<=321)) ) {
                alt14=7;
            }
            else if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_LITERAL)) ) {
                alt14=8;
            }
            else if ( ((LA14_0>=RULE_REGEX_SUBSTITUTE && LA14_0<=RULE_REGEX_MATCH)) ) {
                alt14=9;
            }
            else if ( (LA14_0==RULE_DATA) ) {
                alt14=10;
            }
            else if ( (LA14_0==RULE_END) ) {
                alt14=11;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalPerl.g:784:3: ( () ( (lv_content_1_0= RULE_POD ) ) )
                    {
                    // InternalPerl.g:784:3: ( () ( (lv_content_1_0= RULE_POD ) ) )
                    // InternalPerl.g:785:4: () ( (lv_content_1_0= RULE_POD ) )
                    {
                    // InternalPerl.g:785:4: ()
                    // InternalPerl.g:786:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTokenAccess().getPodTokenAction_0_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:792:4: ( (lv_content_1_0= RULE_POD ) )
                    // InternalPerl.g:793:5: (lv_content_1_0= RULE_POD )
                    {
                    // InternalPerl.g:793:5: (lv_content_1_0= RULE_POD )
                    // InternalPerl.g:794:6: lv_content_1_0= RULE_POD
                    {
                    lv_content_1_0=(Token)match(input,RULE_POD,FOLLOW_2); 

                    						newLeafNode(lv_content_1_0, grammarAccess.getTokenAccess().getContentPODTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_1_0,
                    							"org.epic.perl.Perl.POD");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:812:3: ( () ( (lv_content_3_0= RULE_NUMBER ) ) )
                    {
                    // InternalPerl.g:812:3: ( () ( (lv_content_3_0= RULE_NUMBER ) ) )
                    // InternalPerl.g:813:4: () ( (lv_content_3_0= RULE_NUMBER ) )
                    {
                    // InternalPerl.g:813:4: ()
                    // InternalPerl.g:814:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTokenAccess().getNumberTokenAction_1_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:820:4: ( (lv_content_3_0= RULE_NUMBER ) )
                    // InternalPerl.g:821:5: (lv_content_3_0= RULE_NUMBER )
                    {
                    // InternalPerl.g:821:5: (lv_content_3_0= RULE_NUMBER )
                    // InternalPerl.g:822:6: lv_content_3_0= RULE_NUMBER
                    {
                    lv_content_3_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); 

                    						newLeafNode(lv_content_3_0, grammarAccess.getTokenAccess().getContentNUMBERTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_3_0,
                    							"org.epic.perl.Perl.NUMBER");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:840:3: ( () ( (lv_content_5_0= ruleWord ) ) )
                    {
                    // InternalPerl.g:840:3: ( () ( (lv_content_5_0= ruleWord ) ) )
                    // InternalPerl.g:841:4: () ( (lv_content_5_0= ruleWord ) )
                    {
                    // InternalPerl.g:841:4: ()
                    // InternalPerl.g:842:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTokenAccess().getWordTokenAction_2_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:848:4: ( (lv_content_5_0= ruleWord ) )
                    // InternalPerl.g:849:5: (lv_content_5_0= ruleWord )
                    {
                    // InternalPerl.g:849:5: (lv_content_5_0= ruleWord )
                    // InternalPerl.g:850:6: lv_content_5_0= ruleWord
                    {

                    						newCompositeNode(grammarAccess.getTokenAccess().getContentWordParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_content_5_0=ruleWord();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTokenRule());
                    						}
                    						set(
                    							current,
                    							"content",
                    							lv_content_5_0,
                    							"org.epic.perl.Perl.Word");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:869:3: ( () ( (lv_content_7_0= RULE_SYMBOL ) ) )
                    {
                    // InternalPerl.g:869:3: ( () ( (lv_content_7_0= RULE_SYMBOL ) ) )
                    // InternalPerl.g:870:4: () ( (lv_content_7_0= RULE_SYMBOL ) )
                    {
                    // InternalPerl.g:870:4: ()
                    // InternalPerl.g:871:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTokenAccess().getSymbolTokenAction_3_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:877:4: ( (lv_content_7_0= RULE_SYMBOL ) )
                    // InternalPerl.g:878:5: (lv_content_7_0= RULE_SYMBOL )
                    {
                    // InternalPerl.g:878:5: (lv_content_7_0= RULE_SYMBOL )
                    // InternalPerl.g:879:6: lv_content_7_0= RULE_SYMBOL
                    {
                    lv_content_7_0=(Token)match(input,RULE_SYMBOL,FOLLOW_2); 

                    						newLeafNode(lv_content_7_0, grammarAccess.getTokenAccess().getContentSYMBOLTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_7_0,
                    							"org.epic.perl.Perl.SYMBOL");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:897:3: this_QuoteLikeToken_8= ruleQuoteLikeToken
                    {

                    			newCompositeNode(grammarAccess.getTokenAccess().getQuoteLikeTokenParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_QuoteLikeToken_8=ruleQuoteLikeToken();

                    state._fsp--;


                    			current = this_QuoteLikeToken_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalPerl.g:906:3: ( () ( (lv_content_10_0= ruleFileTestOperator ) ) )
                    {
                    // InternalPerl.g:906:3: ( () ( (lv_content_10_0= ruleFileTestOperator ) ) )
                    // InternalPerl.g:907:4: () ( (lv_content_10_0= ruleFileTestOperator ) )
                    {
                    // InternalPerl.g:907:4: ()
                    // InternalPerl.g:908:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTokenAccess().getOperatorTokenAction_5_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:914:4: ( (lv_content_10_0= ruleFileTestOperator ) )
                    // InternalPerl.g:915:5: (lv_content_10_0= ruleFileTestOperator )
                    {
                    // InternalPerl.g:915:5: (lv_content_10_0= ruleFileTestOperator )
                    // InternalPerl.g:916:6: lv_content_10_0= ruleFileTestOperator
                    {

                    						newCompositeNode(grammarAccess.getTokenAccess().getContentFileTestOperatorParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_content_10_0=ruleFileTestOperator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTokenRule());
                    						}
                    						set(
                    							current,
                    							"content",
                    							lv_content_10_0,
                    							"org.epic.perl.Perl.FileTestOperator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:935:3: ( () ( (lv_content_12_0= ruleOperator ) ) )
                    {
                    // InternalPerl.g:935:3: ( () ( (lv_content_12_0= ruleOperator ) ) )
                    // InternalPerl.g:936:4: () ( (lv_content_12_0= ruleOperator ) )
                    {
                    // InternalPerl.g:936:4: ()
                    // InternalPerl.g:937:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTokenAccess().getOperatorTokenAction_6_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:943:4: ( (lv_content_12_0= ruleOperator ) )
                    // InternalPerl.g:944:5: (lv_content_12_0= ruleOperator )
                    {
                    // InternalPerl.g:944:5: (lv_content_12_0= ruleOperator )
                    // InternalPerl.g:945:6: lv_content_12_0= ruleOperator
                    {

                    						newCompositeNode(grammarAccess.getTokenAccess().getContentOperatorParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_content_12_0=ruleOperator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTokenRule());
                    						}
                    						set(
                    							current,
                    							"content",
                    							lv_content_12_0,
                    							"org.epic.perl.Perl.Operator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:964:3: this_QuoteToken_13= ruleQuoteToken
                    {

                    			newCompositeNode(grammarAccess.getTokenAccess().getQuoteTokenParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_QuoteToken_13=ruleQuoteToken();

                    state._fsp--;


                    			current = this_QuoteToken_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalPerl.g:973:3: this_RegexToken_14= ruleRegexToken
                    {

                    			newCompositeNode(grammarAccess.getTokenAccess().getRegexTokenParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_RegexToken_14=ruleRegexToken();

                    state._fsp--;


                    			current = this_RegexToken_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalPerl.g:982:3: ( () ( (lv_content_16_0= RULE_DATA ) ) )
                    {
                    // InternalPerl.g:982:3: ( () ( (lv_content_16_0= RULE_DATA ) ) )
                    // InternalPerl.g:983:4: () ( (lv_content_16_0= RULE_DATA ) )
                    {
                    // InternalPerl.g:983:4: ()
                    // InternalPerl.g:984:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTokenAccess().getDataTokenAction_9_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:990:4: ( (lv_content_16_0= RULE_DATA ) )
                    // InternalPerl.g:991:5: (lv_content_16_0= RULE_DATA )
                    {
                    // InternalPerl.g:991:5: (lv_content_16_0= RULE_DATA )
                    // InternalPerl.g:992:6: lv_content_16_0= RULE_DATA
                    {
                    lv_content_16_0=(Token)match(input,RULE_DATA,FOLLOW_2); 

                    						newLeafNode(lv_content_16_0, grammarAccess.getTokenAccess().getContentDATATerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_16_0,
                    							"org.epic.perl.Perl.DATA");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:1010:3: ( () ( (lv_content_18_0= RULE_END ) ) )
                    {
                    // InternalPerl.g:1010:3: ( () ( (lv_content_18_0= RULE_END ) ) )
                    // InternalPerl.g:1011:4: () ( (lv_content_18_0= RULE_END ) )
                    {
                    // InternalPerl.g:1011:4: ()
                    // InternalPerl.g:1012:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTokenAccess().getEndTokenAction_10_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:1018:4: ( (lv_content_18_0= RULE_END ) )
                    // InternalPerl.g:1019:5: (lv_content_18_0= RULE_END )
                    {
                    // InternalPerl.g:1019:5: (lv_content_18_0= RULE_END )
                    // InternalPerl.g:1020:6: lv_content_18_0= RULE_END
                    {
                    lv_content_18_0=(Token)match(input,RULE_END,FOLLOW_2); 

                    						newLeafNode(lv_content_18_0, grammarAccess.getTokenAccess().getContentENDTerminalRuleCall_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_18_0,
                    							"org.epic.perl.Perl.END");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleToken"


    // $ANTLR start "entryRuleQuoteToken"
    // InternalPerl.g:1041:1: entryRuleQuoteToken returns [EObject current=null] : iv_ruleQuoteToken= ruleQuoteToken EOF ;
    public final EObject entryRuleQuoteToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuoteToken = null;


        try {
            // InternalPerl.g:1041:51: (iv_ruleQuoteToken= ruleQuoteToken EOF )
            // InternalPerl.g:1042:2: iv_ruleQuoteToken= ruleQuoteToken EOF
            {
             newCompositeNode(grammarAccess.getQuoteTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuoteToken=ruleQuoteToken();

            state._fsp--;

             current =iv_ruleQuoteToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuoteToken"


    // $ANTLR start "ruleQuoteToken"
    // InternalPerl.g:1048:1: ruleQuoteToken returns [EObject current=null] : ( () ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) ) ) ;
    public final EObject ruleQuoteToken() throws RecognitionException {
        EObject current = null;

        Token lv_content_1_1=null;
        Token lv_content_1_2=null;
        Token lv_content_1_3=null;


        	enterRule();

        try {
            // InternalPerl.g:1054:2: ( ( () ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) ) ) )
            // InternalPerl.g:1055:2: ( () ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) ) )
            {
            // InternalPerl.g:1055:2: ( () ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) ) )
            // InternalPerl.g:1056:3: () ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) )
            {
            // InternalPerl.g:1056:3: ()
            // InternalPerl.g:1057:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getQuoteTokenAccess().getQuoteTokenAction_0(),
            					current);
            			

            }

            // InternalPerl.g:1063:3: ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) )
            // InternalPerl.g:1064:4: ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) )
            {
            // InternalPerl.g:1064:4: ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) )
            // InternalPerl.g:1065:5: (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL )
            {
            // InternalPerl.g:1065:5: (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL )
            int alt15=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt15=1;
                }
                break;
            case RULE_INTERPOLATE:
                {
                alt15=2;
                }
                break;
            case RULE_LITERAL:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalPerl.g:1066:6: lv_content_1_1= RULE_STRING
                    {
                    lv_content_1_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_content_1_1, grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuoteTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_1_1,
                    							"org.epic.perl.Perl.STRING");
                    					

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1081:6: lv_content_1_2= RULE_INTERPOLATE
                    {
                    lv_content_1_2=(Token)match(input,RULE_INTERPOLATE,FOLLOW_2); 

                    						newLeafNode(lv_content_1_2, grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuoteTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_1_2,
                    							"org.epic.perl.Perl.INTERPOLATE");
                    					

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1096:6: lv_content_1_3= RULE_LITERAL
                    {
                    lv_content_1_3=(Token)match(input,RULE_LITERAL,FOLLOW_2); 

                    						newLeafNode(lv_content_1_3, grammarAccess.getQuoteTokenAccess().getContentLITERALTerminalRuleCall_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuoteTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_1_3,
                    							"org.epic.perl.Perl.LITERAL");
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuoteToken"


    // $ANTLR start "entryRuleRegexToken"
    // InternalPerl.g:1117:1: entryRuleRegexToken returns [EObject current=null] : iv_ruleRegexToken= ruleRegexToken EOF ;
    public final EObject entryRuleRegexToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexToken = null;


        try {
            // InternalPerl.g:1117:51: (iv_ruleRegexToken= ruleRegexToken EOF )
            // InternalPerl.g:1118:2: iv_ruleRegexToken= ruleRegexToken EOF
            {
             newCompositeNode(grammarAccess.getRegexTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegexToken=ruleRegexToken();

            state._fsp--;

             current =iv_ruleRegexToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegexToken"


    // $ANTLR start "ruleRegexToken"
    // InternalPerl.g:1124:1: ruleRegexToken returns [EObject current=null] : ( () ( ( (lv_content_1_1= RULE_REGEX_SUBSTITUTE | lv_content_1_2= RULE_REGEX_TRANSLITERATE | lv_content_1_3= RULE_REGEX_MATCH ) ) ) ) ;
    public final EObject ruleRegexToken() throws RecognitionException {
        EObject current = null;

        Token lv_content_1_1=null;
        Token lv_content_1_2=null;
        Token lv_content_1_3=null;


        	enterRule();

        try {
            // InternalPerl.g:1130:2: ( ( () ( ( (lv_content_1_1= RULE_REGEX_SUBSTITUTE | lv_content_1_2= RULE_REGEX_TRANSLITERATE | lv_content_1_3= RULE_REGEX_MATCH ) ) ) ) )
            // InternalPerl.g:1131:2: ( () ( ( (lv_content_1_1= RULE_REGEX_SUBSTITUTE | lv_content_1_2= RULE_REGEX_TRANSLITERATE | lv_content_1_3= RULE_REGEX_MATCH ) ) ) )
            {
            // InternalPerl.g:1131:2: ( () ( ( (lv_content_1_1= RULE_REGEX_SUBSTITUTE | lv_content_1_2= RULE_REGEX_TRANSLITERATE | lv_content_1_3= RULE_REGEX_MATCH ) ) ) )
            // InternalPerl.g:1132:3: () ( ( (lv_content_1_1= RULE_REGEX_SUBSTITUTE | lv_content_1_2= RULE_REGEX_TRANSLITERATE | lv_content_1_3= RULE_REGEX_MATCH ) ) )
            {
            // InternalPerl.g:1132:3: ()
            // InternalPerl.g:1133:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRegexTokenAccess().getRegexTokenAction_0(),
            					current);
            			

            }

            // InternalPerl.g:1139:3: ( ( (lv_content_1_1= RULE_REGEX_SUBSTITUTE | lv_content_1_2= RULE_REGEX_TRANSLITERATE | lv_content_1_3= RULE_REGEX_MATCH ) ) )
            // InternalPerl.g:1140:4: ( (lv_content_1_1= RULE_REGEX_SUBSTITUTE | lv_content_1_2= RULE_REGEX_TRANSLITERATE | lv_content_1_3= RULE_REGEX_MATCH ) )
            {
            // InternalPerl.g:1140:4: ( (lv_content_1_1= RULE_REGEX_SUBSTITUTE | lv_content_1_2= RULE_REGEX_TRANSLITERATE | lv_content_1_3= RULE_REGEX_MATCH ) )
            // InternalPerl.g:1141:5: (lv_content_1_1= RULE_REGEX_SUBSTITUTE | lv_content_1_2= RULE_REGEX_TRANSLITERATE | lv_content_1_3= RULE_REGEX_MATCH )
            {
            // InternalPerl.g:1141:5: (lv_content_1_1= RULE_REGEX_SUBSTITUTE | lv_content_1_2= RULE_REGEX_TRANSLITERATE | lv_content_1_3= RULE_REGEX_MATCH )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_REGEX_SUBSTITUTE:
                {
                alt16=1;
                }
                break;
            case RULE_REGEX_TRANSLITERATE:
                {
                alt16=2;
                }
                break;
            case RULE_REGEX_MATCH:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalPerl.g:1142:6: lv_content_1_1= RULE_REGEX_SUBSTITUTE
                    {
                    lv_content_1_1=(Token)match(input,RULE_REGEX_SUBSTITUTE,FOLLOW_2); 

                    						newLeafNode(lv_content_1_1, grammarAccess.getRegexTokenAccess().getContentREGEX_SUBSTITUTETerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegexTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_1_1,
                    							"org.epic.perl.Perl.REGEX_SUBSTITUTE");
                    					

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1157:6: lv_content_1_2= RULE_REGEX_TRANSLITERATE
                    {
                    lv_content_1_2=(Token)match(input,RULE_REGEX_TRANSLITERATE,FOLLOW_2); 

                    						newLeafNode(lv_content_1_2, grammarAccess.getRegexTokenAccess().getContentREGEX_TRANSLITERATETerminalRuleCall_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegexTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_1_2,
                    							"org.epic.perl.Perl.REGEX_TRANSLITERATE");
                    					

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1172:6: lv_content_1_3= RULE_REGEX_MATCH
                    {
                    lv_content_1_3=(Token)match(input,RULE_REGEX_MATCH,FOLLOW_2); 

                    						newLeafNode(lv_content_1_3, grammarAccess.getRegexTokenAccess().getContentREGEX_MATCHTerminalRuleCall_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegexTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_1_3,
                    							"org.epic.perl.Perl.REGEX_MATCH");
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegexToken"


    // $ANTLR start "entryRuleQuoteLikeToken"
    // InternalPerl.g:1193:1: entryRuleQuoteLikeToken returns [EObject current=null] : iv_ruleQuoteLikeToken= ruleQuoteLikeToken EOF ;
    public final EObject entryRuleQuoteLikeToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuoteLikeToken = null;


        try {
            // InternalPerl.g:1193:55: (iv_ruleQuoteLikeToken= ruleQuoteLikeToken EOF )
            // InternalPerl.g:1194:2: iv_ruleQuoteLikeToken= ruleQuoteLikeToken EOF
            {
             newCompositeNode(grammarAccess.getQuoteLikeTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuoteLikeToken=ruleQuoteLikeToken();

            state._fsp--;

             current =iv_ruleQuoteLikeToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuoteLikeToken"


    // $ANTLR start "ruleQuoteLikeToken"
    // InternalPerl.g:1200:1: ruleQuoteLikeToken returns [EObject current=null] : ( ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) ) | ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) ) | ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) ) | ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) ) | ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) ) ) ;
    public final EObject ruleQuoteLikeToken() throws RecognitionException {
        EObject current = null;

        Token lv_content_1_0=null;
        Token lv_content_3_0=null;
        Token lv_content_5_0=null;
        Token lv_content_7_0=null;
        Token lv_content_9_0=null;


        	enterRule();

        try {
            // InternalPerl.g:1206:2: ( ( ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) ) | ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) ) | ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) ) | ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) ) | ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) ) ) )
            // InternalPerl.g:1207:2: ( ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) ) | ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) ) | ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) ) | ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) ) | ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) ) )
            {
            // InternalPerl.g:1207:2: ( ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) ) | ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) ) | ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) ) | ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) ) | ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) ) )
            int alt17=5;
            switch ( input.LA(1) ) {
            case RULE_BACKTICK_STRING:
                {
                alt17=1;
                }
                break;
            case RULE_WORDS_QUOTE_LIKE:
                {
                alt17=2;
                }
                break;
            case RULE_COMMAND_QUOTE_LIKE:
                {
                alt17=3;
                }
                break;
            case RULE_REGEX_QUOTE:
                {
                alt17=4;
                }
                break;
            case RULE_READLINE_QUOTE:
                {
                alt17=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalPerl.g:1208:3: ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) )
                    {
                    // InternalPerl.g:1208:3: ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) )
                    // InternalPerl.g:1209:4: () ( (lv_content_1_0= RULE_BACKTICK_STRING ) )
                    {
                    // InternalPerl.g:1209:4: ()
                    // InternalPerl.g:1210:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:1216:4: ( (lv_content_1_0= RULE_BACKTICK_STRING ) )
                    // InternalPerl.g:1217:5: (lv_content_1_0= RULE_BACKTICK_STRING )
                    {
                    // InternalPerl.g:1217:5: (lv_content_1_0= RULE_BACKTICK_STRING )
                    // InternalPerl.g:1218:6: lv_content_1_0= RULE_BACKTICK_STRING
                    {
                    lv_content_1_0=(Token)match(input,RULE_BACKTICK_STRING,FOLLOW_2); 

                    						newLeafNode(lv_content_1_0, grammarAccess.getQuoteLikeTokenAccess().getContentBACKTICK_STRINGTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuoteLikeTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_1_0,
                    							"org.epic.perl.Perl.BACKTICK_STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1236:3: ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) )
                    {
                    // InternalPerl.g:1236:3: ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) )
                    // InternalPerl.g:1237:4: () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) )
                    {
                    // InternalPerl.g:1237:4: ()
                    // InternalPerl.g:1238:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:1244:4: ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) )
                    // InternalPerl.g:1245:5: (lv_content_3_0= RULE_WORDS_QUOTE_LIKE )
                    {
                    // InternalPerl.g:1245:5: (lv_content_3_0= RULE_WORDS_QUOTE_LIKE )
                    // InternalPerl.g:1246:6: lv_content_3_0= RULE_WORDS_QUOTE_LIKE
                    {
                    lv_content_3_0=(Token)match(input,RULE_WORDS_QUOTE_LIKE,FOLLOW_2); 

                    						newLeafNode(lv_content_3_0, grammarAccess.getQuoteLikeTokenAccess().getContentWORDS_QUOTE_LIKETerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuoteLikeTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_3_0,
                    							"org.epic.perl.Perl.WORDS_QUOTE_LIKE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1264:3: ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) )
                    {
                    // InternalPerl.g:1264:3: ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) )
                    // InternalPerl.g:1265:4: () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) )
                    {
                    // InternalPerl.g:1265:4: ()
                    // InternalPerl.g:1266:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:1272:4: ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) )
                    // InternalPerl.g:1273:5: (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE )
                    {
                    // InternalPerl.g:1273:5: (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE )
                    // InternalPerl.g:1274:6: lv_content_5_0= RULE_COMMAND_QUOTE_LIKE
                    {
                    lv_content_5_0=(Token)match(input,RULE_COMMAND_QUOTE_LIKE,FOLLOW_2); 

                    						newLeafNode(lv_content_5_0, grammarAccess.getQuoteLikeTokenAccess().getContentCOMMAND_QUOTE_LIKETerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuoteLikeTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_5_0,
                    							"org.epic.perl.Perl.COMMAND_QUOTE_LIKE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1292:3: ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) )
                    {
                    // InternalPerl.g:1292:3: ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) )
                    // InternalPerl.g:1293:4: () ( (lv_content_7_0= RULE_REGEX_QUOTE ) )
                    {
                    // InternalPerl.g:1293:4: ()
                    // InternalPerl.g:1294:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:1300:4: ( (lv_content_7_0= RULE_REGEX_QUOTE ) )
                    // InternalPerl.g:1301:5: (lv_content_7_0= RULE_REGEX_QUOTE )
                    {
                    // InternalPerl.g:1301:5: (lv_content_7_0= RULE_REGEX_QUOTE )
                    // InternalPerl.g:1302:6: lv_content_7_0= RULE_REGEX_QUOTE
                    {
                    lv_content_7_0=(Token)match(input,RULE_REGEX_QUOTE,FOLLOW_2); 

                    						newLeafNode(lv_content_7_0, grammarAccess.getQuoteLikeTokenAccess().getContentREGEX_QUOTETerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuoteLikeTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_7_0,
                    							"org.epic.perl.Perl.REGEX_QUOTE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:1320:3: ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) )
                    {
                    // InternalPerl.g:1320:3: ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) )
                    // InternalPerl.g:1321:4: () ( (lv_content_9_0= RULE_READLINE_QUOTE ) )
                    {
                    // InternalPerl.g:1321:4: ()
                    // InternalPerl.g:1322:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0(),
                    						current);
                    				

                    }

                    // InternalPerl.g:1328:4: ( (lv_content_9_0= RULE_READLINE_QUOTE ) )
                    // InternalPerl.g:1329:5: (lv_content_9_0= RULE_READLINE_QUOTE )
                    {
                    // InternalPerl.g:1329:5: (lv_content_9_0= RULE_READLINE_QUOTE )
                    // InternalPerl.g:1330:6: lv_content_9_0= RULE_READLINE_QUOTE
                    {
                    lv_content_9_0=(Token)match(input,RULE_READLINE_QUOTE,FOLLOW_2); 

                    						newLeafNode(lv_content_9_0, grammarAccess.getQuoteLikeTokenAccess().getContentREADLINE_QUOTETerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getQuoteLikeTokenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"content",
                    							lv_content_9_0,
                    							"org.epic.perl.Perl.READLINE_QUOTE");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuoteLikeToken"


    // $ANTLR start "entryRuleWord"
    // InternalPerl.g:1351:1: entryRuleWord returns [String current=null] : iv_ruleWord= ruleWord EOF ;
    public final String entryRuleWord() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWord = null;


        try {
            // InternalPerl.g:1351:44: (iv_ruleWord= ruleWord EOF )
            // InternalPerl.g:1352:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWord"


    // $ANTLR start "ruleWord"
    // InternalPerl.g:1358:1: ruleWord returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Keyword_0= ruleKeyword ;
    public final AntlrDatatypeRuleToken ruleWord() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Keyword_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1364:2: (this_Keyword_0= ruleKeyword )
            // InternalPerl.g:1365:2: this_Keyword_0= ruleKeyword
            {

            		newCompositeNode(grammarAccess.getWordAccess().getKeywordParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Keyword_0=ruleKeyword();

            state._fsp--;


            		current.merge(this_Keyword_0);
            	

            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWord"


    // $ANTLR start "entryRuleKeyword"
    // InternalPerl.g:1378:1: entryRuleKeyword returns [String current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final String entryRuleKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeyword = null;


        try {
            // InternalPerl.g:1378:47: (iv_ruleKeyword= ruleKeyword EOF )
            // InternalPerl.g:1379:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // InternalPerl.g:1385:1: ruleKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abs' | kw= 'accept' | kw= 'alarm' | kw= 'atan2' | kw= 'bind' | kw= 'binmode' | kw= 'bless' | kw= 'break' | kw= 'caller' | kw= 'chdir' | kw= 'chmod' | kw= 'chomp' | kw= 'chop' | kw= 'chown' | kw= 'chr' | kw= 'chroot' | kw= 'close' | kw= 'closedir' | kw= 'connect' | kw= 'continue' | kw= 'cos' | kw= 'crypt' | kw= 'dbmclose' | kw= 'dbmopen' | kw= 'default' | kw= 'defined' | kw= 'delete' | kw= 'die' | kw= 'do' | kw= 'dump' | kw= 'each' | kw= 'else' | kw= 'elsif' | kw= 'endgrent' | kw= 'endhostent' | kw= 'endnetent' | kw= 'endprotoent' | kw= 'endpwent' | kw= 'endservent' | kw= 'eof' | kw= 'eval' | kw= 'evalbytes' | kw= 'exec' | kw= 'exists' | kw= 'exit' | kw= 'exp' | kw= 'fc' | kw= 'fcntl' | kw= 'fileno' | kw= 'flock' | kw= 'for' | kw= 'foreach' | kw= 'fork' | kw= 'format' | kw= 'formline' | kw= 'getc' | kw= 'getgrent' | kw= 'getgrgid' | kw= 'getgrnam' | kw= 'gethostbyaddr' | kw= 'gethostbyname' | kw= 'gethostent' | kw= 'getlogin' | kw= 'getnetbyaddr' | kw= 'getnetbyname' | kw= 'getnetent' | kw= 'getpeername' | kw= 'getpgrp' | kw= 'getppid' | kw= 'getpriority' | kw= 'getprotobyname' | kw= 'getprotobynumber' | kw= 'getprotoent' | kw= 'getpwent' | kw= 'getpwnam' | kw= 'getpwuid' | kw= 'getservbyname' | kw= 'getservbyport' | kw= 'getservent' | kw= 'getsockname' | kw= 'getsockopt' | kw= 'given' | kw= 'glob' | kw= 'gmtime' | kw= 'goto' | kw= 'grep' | kw= 'hex' | kw= 'if' | kw= 'index' | kw= 'int' | kw= 'ioctl' | kw= 'join' | kw= 'keys' | kw= 'kill' | kw= 'last' | kw= 'lc' | kw= 'lcfirst' | kw= 'length' | kw= 'link' | kw= 'listen' | kw= 'local' | kw= 'localtime' | kw= 'lock' | kw= 'log' | kw= 'lstat' | kw= 'map' | kw= 'mkdir' | kw= 'msgctl' | kw= 'msgget' | kw= 'msgrcv' | kw= 'msgsnd' | kw= 'my' | kw= 'next' | kw= 'no' | kw= 'oct' | kw= 'open' | kw= 'opendir' | kw= 'ord' | kw= 'our' | kw= 'pack' | kw= 'package' | kw= 'pipe' | kw= 'pop' | kw= 'pos' | kw= 'print' | kw= 'printf' | kw= 'prototype' | kw= 'push' | kw= 'quotemeta' | kw= 'rand' | kw= 'read' | kw= 'readdir' | kw= 'readline' | kw= 'readlink' | kw= 'readpipe' | kw= 'recv' | kw= 'redo' | kw= 'ref' | kw= 'rename' | kw= 'require' | kw= 'reset' | kw= 'return' | kw= 'reverse' | kw= 'rewinddir' | kw= 'rindex' | kw= 'rmdir' | kw= 'say' | kw= 'scalar' | kw= 'seek' | kw= 'seekdir' | kw= 'select' | kw= 'semctl' | kw= 'semget' | kw= 'semop' | kw= 'send' | kw= 'setgrent' | kw= 'sethostent' | kw= 'setnetent' | kw= 'setpgrp' | kw= 'setpriority' | kw= 'setprotoent' | kw= 'setpwent' | kw= 'setservent' | kw= 'setsockopt' | kw= 'shift' | kw= 'shmctl' | kw= 'shmget' | kw= 'shmread' | kw= 'shmwrite' | kw= 'shutdown' | kw= 'sin' | kw= 'sleep' | kw= 'socket' | kw= 'socketpair' | kw= 'sort' | kw= 'splice' | kw= 'split' | kw= 'sprintf' | kw= 'sqrt' | kw= 'srand' | kw= 'stat' | kw= 'state' | kw= 'study' | kw= 'sub' | kw= 'substr' | kw= 'symlink' | kw= 'syscall' | kw= 'sysopen' | kw= 'sysread' | kw= 'sysseek' | kw= 'system' | kw= 'syswrite' | kw= 'tell' | kw= 'telldir' | kw= 'tie' | kw= 'tied' | kw= 'time' | kw= 'times' | kw= 'tr' | kw= 'truncate' | kw= 'uc' | kw= 'ucfirst' | kw= 'umask' | kw= 'undef' | kw= 'unless' | kw= 'unlink' | kw= 'unpack' | kw= 'unshift' | kw= 'untie' | kw= 'until' | kw= 'use' | kw= 'utime' | kw= 'values' | kw= 'vec' | kw= 'wait' | kw= 'waitpid' | kw= 'wantarray' | kw= 'warn' | kw= 'when' | kw= 'while' | kw= 'write' | kw= 'y' ) ;
    public final AntlrDatatypeRuleToken ruleKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:1391:2: ( (kw= 'abs' | kw= 'accept' | kw= 'alarm' | kw= 'atan2' | kw= 'bind' | kw= 'binmode' | kw= 'bless' | kw= 'break' | kw= 'caller' | kw= 'chdir' | kw= 'chmod' | kw= 'chomp' | kw= 'chop' | kw= 'chown' | kw= 'chr' | kw= 'chroot' | kw= 'close' | kw= 'closedir' | kw= 'connect' | kw= 'continue' | kw= 'cos' | kw= 'crypt' | kw= 'dbmclose' | kw= 'dbmopen' | kw= 'default' | kw= 'defined' | kw= 'delete' | kw= 'die' | kw= 'do' | kw= 'dump' | kw= 'each' | kw= 'else' | kw= 'elsif' | kw= 'endgrent' | kw= 'endhostent' | kw= 'endnetent' | kw= 'endprotoent' | kw= 'endpwent' | kw= 'endservent' | kw= 'eof' | kw= 'eval' | kw= 'evalbytes' | kw= 'exec' | kw= 'exists' | kw= 'exit' | kw= 'exp' | kw= 'fc' | kw= 'fcntl' | kw= 'fileno' | kw= 'flock' | kw= 'for' | kw= 'foreach' | kw= 'fork' | kw= 'format' | kw= 'formline' | kw= 'getc' | kw= 'getgrent' | kw= 'getgrgid' | kw= 'getgrnam' | kw= 'gethostbyaddr' | kw= 'gethostbyname' | kw= 'gethostent' | kw= 'getlogin' | kw= 'getnetbyaddr' | kw= 'getnetbyname' | kw= 'getnetent' | kw= 'getpeername' | kw= 'getpgrp' | kw= 'getppid' | kw= 'getpriority' | kw= 'getprotobyname' | kw= 'getprotobynumber' | kw= 'getprotoent' | kw= 'getpwent' | kw= 'getpwnam' | kw= 'getpwuid' | kw= 'getservbyname' | kw= 'getservbyport' | kw= 'getservent' | kw= 'getsockname' | kw= 'getsockopt' | kw= 'given' | kw= 'glob' | kw= 'gmtime' | kw= 'goto' | kw= 'grep' | kw= 'hex' | kw= 'if' | kw= 'index' | kw= 'int' | kw= 'ioctl' | kw= 'join' | kw= 'keys' | kw= 'kill' | kw= 'last' | kw= 'lc' | kw= 'lcfirst' | kw= 'length' | kw= 'link' | kw= 'listen' | kw= 'local' | kw= 'localtime' | kw= 'lock' | kw= 'log' | kw= 'lstat' | kw= 'map' | kw= 'mkdir' | kw= 'msgctl' | kw= 'msgget' | kw= 'msgrcv' | kw= 'msgsnd' | kw= 'my' | kw= 'next' | kw= 'no' | kw= 'oct' | kw= 'open' | kw= 'opendir' | kw= 'ord' | kw= 'our' | kw= 'pack' | kw= 'package' | kw= 'pipe' | kw= 'pop' | kw= 'pos' | kw= 'print' | kw= 'printf' | kw= 'prototype' | kw= 'push' | kw= 'quotemeta' | kw= 'rand' | kw= 'read' | kw= 'readdir' | kw= 'readline' | kw= 'readlink' | kw= 'readpipe' | kw= 'recv' | kw= 'redo' | kw= 'ref' | kw= 'rename' | kw= 'require' | kw= 'reset' | kw= 'return' | kw= 'reverse' | kw= 'rewinddir' | kw= 'rindex' | kw= 'rmdir' | kw= 'say' | kw= 'scalar' | kw= 'seek' | kw= 'seekdir' | kw= 'select' | kw= 'semctl' | kw= 'semget' | kw= 'semop' | kw= 'send' | kw= 'setgrent' | kw= 'sethostent' | kw= 'setnetent' | kw= 'setpgrp' | kw= 'setpriority' | kw= 'setprotoent' | kw= 'setpwent' | kw= 'setservent' | kw= 'setsockopt' | kw= 'shift' | kw= 'shmctl' | kw= 'shmget' | kw= 'shmread' | kw= 'shmwrite' | kw= 'shutdown' | kw= 'sin' | kw= 'sleep' | kw= 'socket' | kw= 'socketpair' | kw= 'sort' | kw= 'splice' | kw= 'split' | kw= 'sprintf' | kw= 'sqrt' | kw= 'srand' | kw= 'stat' | kw= 'state' | kw= 'study' | kw= 'sub' | kw= 'substr' | kw= 'symlink' | kw= 'syscall' | kw= 'sysopen' | kw= 'sysread' | kw= 'sysseek' | kw= 'system' | kw= 'syswrite' | kw= 'tell' | kw= 'telldir' | kw= 'tie' | kw= 'tied' | kw= 'time' | kw= 'times' | kw= 'tr' | kw= 'truncate' | kw= 'uc' | kw= 'ucfirst' | kw= 'umask' | kw= 'undef' | kw= 'unless' | kw= 'unlink' | kw= 'unpack' | kw= 'unshift' | kw= 'untie' | kw= 'until' | kw= 'use' | kw= 'utime' | kw= 'values' | kw= 'vec' | kw= 'wait' | kw= 'waitpid' | kw= 'wantarray' | kw= 'warn' | kw= 'when' | kw= 'while' | kw= 'write' | kw= 'y' ) )
            // InternalPerl.g:1392:2: (kw= 'abs' | kw= 'accept' | kw= 'alarm' | kw= 'atan2' | kw= 'bind' | kw= 'binmode' | kw= 'bless' | kw= 'break' | kw= 'caller' | kw= 'chdir' | kw= 'chmod' | kw= 'chomp' | kw= 'chop' | kw= 'chown' | kw= 'chr' | kw= 'chroot' | kw= 'close' | kw= 'closedir' | kw= 'connect' | kw= 'continue' | kw= 'cos' | kw= 'crypt' | kw= 'dbmclose' | kw= 'dbmopen' | kw= 'default' | kw= 'defined' | kw= 'delete' | kw= 'die' | kw= 'do' | kw= 'dump' | kw= 'each' | kw= 'else' | kw= 'elsif' | kw= 'endgrent' | kw= 'endhostent' | kw= 'endnetent' | kw= 'endprotoent' | kw= 'endpwent' | kw= 'endservent' | kw= 'eof' | kw= 'eval' | kw= 'evalbytes' | kw= 'exec' | kw= 'exists' | kw= 'exit' | kw= 'exp' | kw= 'fc' | kw= 'fcntl' | kw= 'fileno' | kw= 'flock' | kw= 'for' | kw= 'foreach' | kw= 'fork' | kw= 'format' | kw= 'formline' | kw= 'getc' | kw= 'getgrent' | kw= 'getgrgid' | kw= 'getgrnam' | kw= 'gethostbyaddr' | kw= 'gethostbyname' | kw= 'gethostent' | kw= 'getlogin' | kw= 'getnetbyaddr' | kw= 'getnetbyname' | kw= 'getnetent' | kw= 'getpeername' | kw= 'getpgrp' | kw= 'getppid' | kw= 'getpriority' | kw= 'getprotobyname' | kw= 'getprotobynumber' | kw= 'getprotoent' | kw= 'getpwent' | kw= 'getpwnam' | kw= 'getpwuid' | kw= 'getservbyname' | kw= 'getservbyport' | kw= 'getservent' | kw= 'getsockname' | kw= 'getsockopt' | kw= 'given' | kw= 'glob' | kw= 'gmtime' | kw= 'goto' | kw= 'grep' | kw= 'hex' | kw= 'if' | kw= 'index' | kw= 'int' | kw= 'ioctl' | kw= 'join' | kw= 'keys' | kw= 'kill' | kw= 'last' | kw= 'lc' | kw= 'lcfirst' | kw= 'length' | kw= 'link' | kw= 'listen' | kw= 'local' | kw= 'localtime' | kw= 'lock' | kw= 'log' | kw= 'lstat' | kw= 'map' | kw= 'mkdir' | kw= 'msgctl' | kw= 'msgget' | kw= 'msgrcv' | kw= 'msgsnd' | kw= 'my' | kw= 'next' | kw= 'no' | kw= 'oct' | kw= 'open' | kw= 'opendir' | kw= 'ord' | kw= 'our' | kw= 'pack' | kw= 'package' | kw= 'pipe' | kw= 'pop' | kw= 'pos' | kw= 'print' | kw= 'printf' | kw= 'prototype' | kw= 'push' | kw= 'quotemeta' | kw= 'rand' | kw= 'read' | kw= 'readdir' | kw= 'readline' | kw= 'readlink' | kw= 'readpipe' | kw= 'recv' | kw= 'redo' | kw= 'ref' | kw= 'rename' | kw= 'require' | kw= 'reset' | kw= 'return' | kw= 'reverse' | kw= 'rewinddir' | kw= 'rindex' | kw= 'rmdir' | kw= 'say' | kw= 'scalar' | kw= 'seek' | kw= 'seekdir' | kw= 'select' | kw= 'semctl' | kw= 'semget' | kw= 'semop' | kw= 'send' | kw= 'setgrent' | kw= 'sethostent' | kw= 'setnetent' | kw= 'setpgrp' | kw= 'setpriority' | kw= 'setprotoent' | kw= 'setpwent' | kw= 'setservent' | kw= 'setsockopt' | kw= 'shift' | kw= 'shmctl' | kw= 'shmget' | kw= 'shmread' | kw= 'shmwrite' | kw= 'shutdown' | kw= 'sin' | kw= 'sleep' | kw= 'socket' | kw= 'socketpair' | kw= 'sort' | kw= 'splice' | kw= 'split' | kw= 'sprintf' | kw= 'sqrt' | kw= 'srand' | kw= 'stat' | kw= 'state' | kw= 'study' | kw= 'sub' | kw= 'substr' | kw= 'symlink' | kw= 'syscall' | kw= 'sysopen' | kw= 'sysread' | kw= 'sysseek' | kw= 'system' | kw= 'syswrite' | kw= 'tell' | kw= 'telldir' | kw= 'tie' | kw= 'tied' | kw= 'time' | kw= 'times' | kw= 'tr' | kw= 'truncate' | kw= 'uc' | kw= 'ucfirst' | kw= 'umask' | kw= 'undef' | kw= 'unless' | kw= 'unlink' | kw= 'unpack' | kw= 'unshift' | kw= 'untie' | kw= 'until' | kw= 'use' | kw= 'utime' | kw= 'values' | kw= 'vec' | kw= 'wait' | kw= 'waitpid' | kw= 'wantarray' | kw= 'warn' | kw= 'when' | kw= 'while' | kw= 'write' | kw= 'y' )
            {
            // InternalPerl.g:1392:2: (kw= 'abs' | kw= 'accept' | kw= 'alarm' | kw= 'atan2' | kw= 'bind' | kw= 'binmode' | kw= 'bless' | kw= 'break' | kw= 'caller' | kw= 'chdir' | kw= 'chmod' | kw= 'chomp' | kw= 'chop' | kw= 'chown' | kw= 'chr' | kw= 'chroot' | kw= 'close' | kw= 'closedir' | kw= 'connect' | kw= 'continue' | kw= 'cos' | kw= 'crypt' | kw= 'dbmclose' | kw= 'dbmopen' | kw= 'default' | kw= 'defined' | kw= 'delete' | kw= 'die' | kw= 'do' | kw= 'dump' | kw= 'each' | kw= 'else' | kw= 'elsif' | kw= 'endgrent' | kw= 'endhostent' | kw= 'endnetent' | kw= 'endprotoent' | kw= 'endpwent' | kw= 'endservent' | kw= 'eof' | kw= 'eval' | kw= 'evalbytes' | kw= 'exec' | kw= 'exists' | kw= 'exit' | kw= 'exp' | kw= 'fc' | kw= 'fcntl' | kw= 'fileno' | kw= 'flock' | kw= 'for' | kw= 'foreach' | kw= 'fork' | kw= 'format' | kw= 'formline' | kw= 'getc' | kw= 'getgrent' | kw= 'getgrgid' | kw= 'getgrnam' | kw= 'gethostbyaddr' | kw= 'gethostbyname' | kw= 'gethostent' | kw= 'getlogin' | kw= 'getnetbyaddr' | kw= 'getnetbyname' | kw= 'getnetent' | kw= 'getpeername' | kw= 'getpgrp' | kw= 'getppid' | kw= 'getpriority' | kw= 'getprotobyname' | kw= 'getprotobynumber' | kw= 'getprotoent' | kw= 'getpwent' | kw= 'getpwnam' | kw= 'getpwuid' | kw= 'getservbyname' | kw= 'getservbyport' | kw= 'getservent' | kw= 'getsockname' | kw= 'getsockopt' | kw= 'given' | kw= 'glob' | kw= 'gmtime' | kw= 'goto' | kw= 'grep' | kw= 'hex' | kw= 'if' | kw= 'index' | kw= 'int' | kw= 'ioctl' | kw= 'join' | kw= 'keys' | kw= 'kill' | kw= 'last' | kw= 'lc' | kw= 'lcfirst' | kw= 'length' | kw= 'link' | kw= 'listen' | kw= 'local' | kw= 'localtime' | kw= 'lock' | kw= 'log' | kw= 'lstat' | kw= 'map' | kw= 'mkdir' | kw= 'msgctl' | kw= 'msgget' | kw= 'msgrcv' | kw= 'msgsnd' | kw= 'my' | kw= 'next' | kw= 'no' | kw= 'oct' | kw= 'open' | kw= 'opendir' | kw= 'ord' | kw= 'our' | kw= 'pack' | kw= 'package' | kw= 'pipe' | kw= 'pop' | kw= 'pos' | kw= 'print' | kw= 'printf' | kw= 'prototype' | kw= 'push' | kw= 'quotemeta' | kw= 'rand' | kw= 'read' | kw= 'readdir' | kw= 'readline' | kw= 'readlink' | kw= 'readpipe' | kw= 'recv' | kw= 'redo' | kw= 'ref' | kw= 'rename' | kw= 'require' | kw= 'reset' | kw= 'return' | kw= 'reverse' | kw= 'rewinddir' | kw= 'rindex' | kw= 'rmdir' | kw= 'say' | kw= 'scalar' | kw= 'seek' | kw= 'seekdir' | kw= 'select' | kw= 'semctl' | kw= 'semget' | kw= 'semop' | kw= 'send' | kw= 'setgrent' | kw= 'sethostent' | kw= 'setnetent' | kw= 'setpgrp' | kw= 'setpriority' | kw= 'setprotoent' | kw= 'setpwent' | kw= 'setservent' | kw= 'setsockopt' | kw= 'shift' | kw= 'shmctl' | kw= 'shmget' | kw= 'shmread' | kw= 'shmwrite' | kw= 'shutdown' | kw= 'sin' | kw= 'sleep' | kw= 'socket' | kw= 'socketpair' | kw= 'sort' | kw= 'splice' | kw= 'split' | kw= 'sprintf' | kw= 'sqrt' | kw= 'srand' | kw= 'stat' | kw= 'state' | kw= 'study' | kw= 'sub' | kw= 'substr' | kw= 'symlink' | kw= 'syscall' | kw= 'sysopen' | kw= 'sysread' | kw= 'sysseek' | kw= 'system' | kw= 'syswrite' | kw= 'tell' | kw= 'telldir' | kw= 'tie' | kw= 'tied' | kw= 'time' | kw= 'times' | kw= 'tr' | kw= 'truncate' | kw= 'uc' | kw= 'ucfirst' | kw= 'umask' | kw= 'undef' | kw= 'unless' | kw= 'unlink' | kw= 'unpack' | kw= 'unshift' | kw= 'untie' | kw= 'until' | kw= 'use' | kw= 'utime' | kw= 'values' | kw= 'vec' | kw= 'wait' | kw= 'waitpid' | kw= 'wantarray' | kw= 'warn' | kw= 'when' | kw= 'while' | kw= 'write' | kw= 'y' )
            int alt18=222;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt18=1;
                }
                break;
            case 42:
                {
                alt18=2;
                }
                break;
            case 43:
                {
                alt18=3;
                }
                break;
            case 44:
                {
                alt18=4;
                }
                break;
            case 45:
                {
                alt18=5;
                }
                break;
            case 46:
                {
                alt18=6;
                }
                break;
            case 47:
                {
                alt18=7;
                }
                break;
            case 48:
                {
                alt18=8;
                }
                break;
            case 49:
                {
                alt18=9;
                }
                break;
            case 50:
                {
                alt18=10;
                }
                break;
            case 51:
                {
                alt18=11;
                }
                break;
            case 52:
                {
                alt18=12;
                }
                break;
            case 53:
                {
                alt18=13;
                }
                break;
            case 54:
                {
                alt18=14;
                }
                break;
            case 55:
                {
                alt18=15;
                }
                break;
            case 56:
                {
                alt18=16;
                }
                break;
            case 57:
                {
                alt18=17;
                }
                break;
            case 58:
                {
                alt18=18;
                }
                break;
            case 59:
                {
                alt18=19;
                }
                break;
            case 60:
                {
                alt18=20;
                }
                break;
            case 61:
                {
                alt18=21;
                }
                break;
            case 62:
                {
                alt18=22;
                }
                break;
            case 63:
                {
                alt18=23;
                }
                break;
            case 64:
                {
                alt18=24;
                }
                break;
            case 65:
                {
                alt18=25;
                }
                break;
            case 66:
                {
                alt18=26;
                }
                break;
            case 67:
                {
                alt18=27;
                }
                break;
            case 68:
                {
                alt18=28;
                }
                break;
            case 69:
                {
                alt18=29;
                }
                break;
            case 70:
                {
                alt18=30;
                }
                break;
            case 71:
                {
                alt18=31;
                }
                break;
            case 72:
                {
                alt18=32;
                }
                break;
            case 73:
                {
                alt18=33;
                }
                break;
            case 74:
                {
                alt18=34;
                }
                break;
            case 75:
                {
                alt18=35;
                }
                break;
            case 76:
                {
                alt18=36;
                }
                break;
            case 77:
                {
                alt18=37;
                }
                break;
            case 78:
                {
                alt18=38;
                }
                break;
            case 79:
                {
                alt18=39;
                }
                break;
            case 80:
                {
                alt18=40;
                }
                break;
            case 81:
                {
                alt18=41;
                }
                break;
            case 82:
                {
                alt18=42;
                }
                break;
            case 83:
                {
                alt18=43;
                }
                break;
            case 84:
                {
                alt18=44;
                }
                break;
            case 85:
                {
                alt18=45;
                }
                break;
            case 86:
                {
                alt18=46;
                }
                break;
            case 87:
                {
                alt18=47;
                }
                break;
            case 88:
                {
                alt18=48;
                }
                break;
            case 89:
                {
                alt18=49;
                }
                break;
            case 90:
                {
                alt18=50;
                }
                break;
            case 91:
                {
                alt18=51;
                }
                break;
            case 92:
                {
                alt18=52;
                }
                break;
            case 93:
                {
                alt18=53;
                }
                break;
            case 94:
                {
                alt18=54;
                }
                break;
            case 95:
                {
                alt18=55;
                }
                break;
            case 96:
                {
                alt18=56;
                }
                break;
            case 97:
                {
                alt18=57;
                }
                break;
            case 98:
                {
                alt18=58;
                }
                break;
            case 99:
                {
                alt18=59;
                }
                break;
            case 100:
                {
                alt18=60;
                }
                break;
            case 101:
                {
                alt18=61;
                }
                break;
            case 102:
                {
                alt18=62;
                }
                break;
            case 103:
                {
                alt18=63;
                }
                break;
            case 104:
                {
                alt18=64;
                }
                break;
            case 105:
                {
                alt18=65;
                }
                break;
            case 106:
                {
                alt18=66;
                }
                break;
            case 107:
                {
                alt18=67;
                }
                break;
            case 108:
                {
                alt18=68;
                }
                break;
            case 109:
                {
                alt18=69;
                }
                break;
            case 110:
                {
                alt18=70;
                }
                break;
            case 111:
                {
                alt18=71;
                }
                break;
            case 112:
                {
                alt18=72;
                }
                break;
            case 113:
                {
                alt18=73;
                }
                break;
            case 114:
                {
                alt18=74;
                }
                break;
            case 115:
                {
                alt18=75;
                }
                break;
            case 116:
                {
                alt18=76;
                }
                break;
            case 117:
                {
                alt18=77;
                }
                break;
            case 118:
                {
                alt18=78;
                }
                break;
            case 119:
                {
                alt18=79;
                }
                break;
            case 120:
                {
                alt18=80;
                }
                break;
            case 121:
                {
                alt18=81;
                }
                break;
            case 122:
                {
                alt18=82;
                }
                break;
            case 123:
                {
                alt18=83;
                }
                break;
            case 124:
                {
                alt18=84;
                }
                break;
            case 125:
                {
                alt18=85;
                }
                break;
            case 126:
                {
                alt18=86;
                }
                break;
            case 127:
                {
                alt18=87;
                }
                break;
            case 128:
                {
                alt18=88;
                }
                break;
            case 129:
                {
                alt18=89;
                }
                break;
            case 130:
                {
                alt18=90;
                }
                break;
            case 131:
                {
                alt18=91;
                }
                break;
            case 132:
                {
                alt18=92;
                }
                break;
            case 133:
                {
                alt18=93;
                }
                break;
            case 134:
                {
                alt18=94;
                }
                break;
            case 135:
                {
                alt18=95;
                }
                break;
            case 136:
                {
                alt18=96;
                }
                break;
            case 137:
                {
                alt18=97;
                }
                break;
            case 138:
                {
                alt18=98;
                }
                break;
            case 139:
                {
                alt18=99;
                }
                break;
            case 140:
                {
                alt18=100;
                }
                break;
            case 141:
                {
                alt18=101;
                }
                break;
            case 142:
                {
                alt18=102;
                }
                break;
            case 143:
                {
                alt18=103;
                }
                break;
            case 144:
                {
                alt18=104;
                }
                break;
            case 145:
                {
                alt18=105;
                }
                break;
            case 146:
                {
                alt18=106;
                }
                break;
            case 147:
                {
                alt18=107;
                }
                break;
            case 148:
                {
                alt18=108;
                }
                break;
            case 149:
                {
                alt18=109;
                }
                break;
            case 150:
                {
                alt18=110;
                }
                break;
            case 151:
                {
                alt18=111;
                }
                break;
            case 152:
                {
                alt18=112;
                }
                break;
            case 153:
                {
                alt18=113;
                }
                break;
            case 154:
                {
                alt18=114;
                }
                break;
            case 155:
                {
                alt18=115;
                }
                break;
            case 156:
                {
                alt18=116;
                }
                break;
            case 157:
                {
                alt18=117;
                }
                break;
            case 158:
                {
                alt18=118;
                }
                break;
            case 159:
                {
                alt18=119;
                }
                break;
            case 160:
                {
                alt18=120;
                }
                break;
            case 29:
                {
                alt18=121;
                }
                break;
            case 161:
                {
                alt18=122;
                }
                break;
            case 162:
                {
                alt18=123;
                }
                break;
            case 163:
                {
                alt18=124;
                }
                break;
            case 164:
                {
                alt18=125;
                }
                break;
            case 165:
                {
                alt18=126;
                }
                break;
            case 166:
                {
                alt18=127;
                }
                break;
            case 167:
                {
                alt18=128;
                }
                break;
            case 168:
                {
                alt18=129;
                }
                break;
            case 169:
                {
                alt18=130;
                }
                break;
            case 170:
                {
                alt18=131;
                }
                break;
            case 171:
                {
                alt18=132;
                }
                break;
            case 172:
                {
                alt18=133;
                }
                break;
            case 173:
                {
                alt18=134;
                }
                break;
            case 174:
                {
                alt18=135;
                }
                break;
            case 175:
                {
                alt18=136;
                }
                break;
            case 176:
                {
                alt18=137;
                }
                break;
            case 177:
                {
                alt18=138;
                }
                break;
            case 178:
                {
                alt18=139;
                }
                break;
            case 30:
                {
                alt18=140;
                }
                break;
            case 179:
                {
                alt18=141;
                }
                break;
            case 180:
                {
                alt18=142;
                }
                break;
            case 181:
                {
                alt18=143;
                }
                break;
            case 182:
                {
                alt18=144;
                }
                break;
            case 183:
                {
                alt18=145;
                }
                break;
            case 184:
                {
                alt18=146;
                }
                break;
            case 185:
                {
                alt18=147;
                }
                break;
            case 186:
                {
                alt18=148;
                }
                break;
            case 187:
                {
                alt18=149;
                }
                break;
            case 188:
                {
                alt18=150;
                }
                break;
            case 189:
                {
                alt18=151;
                }
                break;
            case 190:
                {
                alt18=152;
                }
                break;
            case 191:
                {
                alt18=153;
                }
                break;
            case 192:
                {
                alt18=154;
                }
                break;
            case 193:
                {
                alt18=155;
                }
                break;
            case 194:
                {
                alt18=156;
                }
                break;
            case 195:
                {
                alt18=157;
                }
                break;
            case 196:
                {
                alt18=158;
                }
                break;
            case 197:
                {
                alt18=159;
                }
                break;
            case 198:
                {
                alt18=160;
                }
                break;
            case 199:
                {
                alt18=161;
                }
                break;
            case 200:
                {
                alt18=162;
                }
                break;
            case 201:
                {
                alt18=163;
                }
                break;
            case 202:
                {
                alt18=164;
                }
                break;
            case 203:
                {
                alt18=165;
                }
                break;
            case 204:
                {
                alt18=166;
                }
                break;
            case 205:
                {
                alt18=167;
                }
                break;
            case 206:
                {
                alt18=168;
                }
                break;
            case 207:
                {
                alt18=169;
                }
                break;
            case 208:
                {
                alt18=170;
                }
                break;
            case 209:
                {
                alt18=171;
                }
                break;
            case 210:
                {
                alt18=172;
                }
                break;
            case 211:
                {
                alt18=173;
                }
                break;
            case 212:
                {
                alt18=174;
                }
                break;
            case 213:
                {
                alt18=175;
                }
                break;
            case 214:
                {
                alt18=176;
                }
                break;
            case 215:
                {
                alt18=177;
                }
                break;
            case 216:
                {
                alt18=178;
                }
                break;
            case 217:
                {
                alt18=179;
                }
                break;
            case 218:
                {
                alt18=180;
                }
                break;
            case 219:
                {
                alt18=181;
                }
                break;
            case 220:
                {
                alt18=182;
                }
                break;
            case 221:
                {
                alt18=183;
                }
                break;
            case 32:
                {
                alt18=184;
                }
                break;
            case 222:
                {
                alt18=185;
                }
                break;
            case 223:
                {
                alt18=186;
                }
                break;
            case 224:
                {
                alt18=187;
                }
                break;
            case 225:
                {
                alt18=188;
                }
                break;
            case 226:
                {
                alt18=189;
                }
                break;
            case 227:
                {
                alt18=190;
                }
                break;
            case 228:
                {
                alt18=191;
                }
                break;
            case 229:
                {
                alt18=192;
                }
                break;
            case 230:
                {
                alt18=193;
                }
                break;
            case 231:
                {
                alt18=194;
                }
                break;
            case 232:
                {
                alt18=195;
                }
                break;
            case 233:
                {
                alt18=196;
                }
                break;
            case 234:
                {
                alt18=197;
                }
                break;
            case 235:
                {
                alt18=198;
                }
                break;
            case 236:
                {
                alt18=199;
                }
                break;
            case 237:
                {
                alt18=200;
                }
                break;
            case 238:
                {
                alt18=201;
                }
                break;
            case 239:
                {
                alt18=202;
                }
                break;
            case 240:
                {
                alt18=203;
                }
                break;
            case 241:
                {
                alt18=204;
                }
                break;
            case 242:
                {
                alt18=205;
                }
                break;
            case 243:
                {
                alt18=206;
                }
                break;
            case 244:
                {
                alt18=207;
                }
                break;
            case 245:
                {
                alt18=208;
                }
                break;
            case 246:
                {
                alt18=209;
                }
                break;
            case 247:
                {
                alt18=210;
                }
                break;
            case 31:
                {
                alt18=211;
                }
                break;
            case 248:
                {
                alt18=212;
                }
                break;
            case 249:
                {
                alt18=213;
                }
                break;
            case 250:
                {
                alt18=214;
                }
                break;
            case 251:
                {
                alt18=215;
                }
                break;
            case 252:
                {
                alt18=216;
                }
                break;
            case 253:
                {
                alt18=217;
                }
                break;
            case 254:
                {
                alt18=218;
                }
                break;
            case 255:
                {
                alt18=219;
                }
                break;
            case 256:
                {
                alt18=220;
                }
                break;
            case 257:
                {
                alt18=221;
                }
                break;
            case 258:
                {
                alt18=222;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalPerl.g:1393:3: kw= 'abs'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getAbsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1399:3: kw= 'accept'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getAcceptKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1405:3: kw= 'alarm'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getAlarmKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalPerl.g:1411:3: kw= 'atan2'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getAtan2Keyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalPerl.g:1417:3: kw= 'bind'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getBindKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalPerl.g:1423:3: kw= 'binmode'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getBinmodeKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalPerl.g:1429:3: kw= 'bless'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getBlessKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalPerl.g:1435:3: kw= 'break'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getBreakKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalPerl.g:1441:3: kw= 'caller'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getCallerKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalPerl.g:1447:3: kw= 'chdir'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getChdirKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalPerl.g:1453:3: kw= 'chmod'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getChmodKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalPerl.g:1459:3: kw= 'chomp'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getChompKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalPerl.g:1465:3: kw= 'chop'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getChopKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalPerl.g:1471:3: kw= 'chown'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getChownKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalPerl.g:1477:3: kw= 'chr'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getChrKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalPerl.g:1483:3: kw= 'chroot'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getChrootKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalPerl.g:1489:3: kw= 'close'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getCloseKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalPerl.g:1495:3: kw= 'closedir'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getClosedirKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalPerl.g:1501:3: kw= 'connect'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getConnectKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalPerl.g:1507:3: kw= 'continue'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getContinueKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalPerl.g:1513:3: kw= 'cos'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getCosKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalPerl.g:1519:3: kw= 'crypt'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getCryptKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalPerl.g:1525:3: kw= 'dbmclose'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getDbmcloseKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalPerl.g:1531:3: kw= 'dbmopen'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getDbmopenKeyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalPerl.g:1537:3: kw= 'default'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getDefaultKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalPerl.g:1543:3: kw= 'defined'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getDefinedKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalPerl.g:1549:3: kw= 'delete'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getDeleteKeyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalPerl.g:1555:3: kw= 'die'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getDieKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalPerl.g:1561:3: kw= 'do'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getDoKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalPerl.g:1567:3: kw= 'dump'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getDumpKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalPerl.g:1573:3: kw= 'each'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getEachKeyword_30());
                    		

                    }
                    break;
                case 32 :
                    // InternalPerl.g:1579:3: kw= 'else'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getElseKeyword_31());
                    		

                    }
                    break;
                case 33 :
                    // InternalPerl.g:1585:3: kw= 'elsif'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getElsifKeyword_32());
                    		

                    }
                    break;
                case 34 :
                    // InternalPerl.g:1591:3: kw= 'endgrent'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndgrentKeyword_33());
                    		

                    }
                    break;
                case 35 :
                    // InternalPerl.g:1597:3: kw= 'endhostent'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndhostentKeyword_34());
                    		

                    }
                    break;
                case 36 :
                    // InternalPerl.g:1603:3: kw= 'endnetent'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndnetentKeyword_35());
                    		

                    }
                    break;
                case 37 :
                    // InternalPerl.g:1609:3: kw= 'endprotoent'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndprotoentKeyword_36());
                    		

                    }
                    break;
                case 38 :
                    // InternalPerl.g:1615:3: kw= 'endpwent'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndpwentKeyword_37());
                    		

                    }
                    break;
                case 39 :
                    // InternalPerl.g:1621:3: kw= 'endservent'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndserventKeyword_38());
                    		

                    }
                    break;
                case 40 :
                    // InternalPerl.g:1627:3: kw= 'eof'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getEofKeyword_39());
                    		

                    }
                    break;
                case 41 :
                    // InternalPerl.g:1633:3: kw= 'eval'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getEvalKeyword_40());
                    		

                    }
                    break;
                case 42 :
                    // InternalPerl.g:1639:3: kw= 'evalbytes'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getEvalbytesKeyword_41());
                    		

                    }
                    break;
                case 43 :
                    // InternalPerl.g:1645:3: kw= 'exec'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getExecKeyword_42());
                    		

                    }
                    break;
                case 44 :
                    // InternalPerl.g:1651:3: kw= 'exists'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getExistsKeyword_43());
                    		

                    }
                    break;
                case 45 :
                    // InternalPerl.g:1657:3: kw= 'exit'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getExitKeyword_44());
                    		

                    }
                    break;
                case 46 :
                    // InternalPerl.g:1663:3: kw= 'exp'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getExpKeyword_45());
                    		

                    }
                    break;
                case 47 :
                    // InternalPerl.g:1669:3: kw= 'fc'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getFcKeyword_46());
                    		

                    }
                    break;
                case 48 :
                    // InternalPerl.g:1675:3: kw= 'fcntl'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getFcntlKeyword_47());
                    		

                    }
                    break;
                case 49 :
                    // InternalPerl.g:1681:3: kw= 'fileno'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getFilenoKeyword_48());
                    		

                    }
                    break;
                case 50 :
                    // InternalPerl.g:1687:3: kw= 'flock'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getFlockKeyword_49());
                    		

                    }
                    break;
                case 51 :
                    // InternalPerl.g:1693:3: kw= 'for'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getForKeyword_50());
                    		

                    }
                    break;
                case 52 :
                    // InternalPerl.g:1699:3: kw= 'foreach'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getForeachKeyword_51());
                    		

                    }
                    break;
                case 53 :
                    // InternalPerl.g:1705:3: kw= 'fork'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getForkKeyword_52());
                    		

                    }
                    break;
                case 54 :
                    // InternalPerl.g:1711:3: kw= 'format'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getFormatKeyword_53());
                    		

                    }
                    break;
                case 55 :
                    // InternalPerl.g:1717:3: kw= 'formline'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getFormlineKeyword_54());
                    		

                    }
                    break;
                case 56 :
                    // InternalPerl.g:1723:3: kw= 'getc'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetcKeyword_55());
                    		

                    }
                    break;
                case 57 :
                    // InternalPerl.g:1729:3: kw= 'getgrent'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetgrentKeyword_56());
                    		

                    }
                    break;
                case 58 :
                    // InternalPerl.g:1735:3: kw= 'getgrgid'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetgrgidKeyword_57());
                    		

                    }
                    break;
                case 59 :
                    // InternalPerl.g:1741:3: kw= 'getgrnam'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetgrnamKeyword_58());
                    		

                    }
                    break;
                case 60 :
                    // InternalPerl.g:1747:3: kw= 'gethostbyaddr'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59());
                    		

                    }
                    break;
                case 61 :
                    // InternalPerl.g:1753:3: kw= 'gethostbyname'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGethostbynameKeyword_60());
                    		

                    }
                    break;
                case 62 :
                    // InternalPerl.g:1759:3: kw= 'gethostent'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGethostentKeyword_61());
                    		

                    }
                    break;
                case 63 :
                    // InternalPerl.g:1765:3: kw= 'getlogin'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetloginKeyword_62());
                    		

                    }
                    break;
                case 64 :
                    // InternalPerl.g:1771:3: kw= 'getnetbyaddr'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63());
                    		

                    }
                    break;
                case 65 :
                    // InternalPerl.g:1777:3: kw= 'getnetbyname'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64());
                    		

                    }
                    break;
                case 66 :
                    // InternalPerl.g:1783:3: kw= 'getnetent'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetnetentKeyword_65());
                    		

                    }
                    break;
                case 67 :
                    // InternalPerl.g:1789:3: kw= 'getpeername'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpeernameKeyword_66());
                    		

                    }
                    break;
                case 68 :
                    // InternalPerl.g:1795:3: kw= 'getpgrp'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpgrpKeyword_67());
                    		

                    }
                    break;
                case 69 :
                    // InternalPerl.g:1801:3: kw= 'getppid'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetppidKeyword_68());
                    		

                    }
                    break;
                case 70 :
                    // InternalPerl.g:1807:3: kw= 'getpriority'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpriorityKeyword_69());
                    		

                    }
                    break;
                case 71 :
                    // InternalPerl.g:1813:3: kw= 'getprotobyname'
                    {
                    kw=(Token)match(input,111,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70());
                    		

                    }
                    break;
                case 72 :
                    // InternalPerl.g:1819:3: kw= 'getprotobynumber'
                    {
                    kw=(Token)match(input,112,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71());
                    		

                    }
                    break;
                case 73 :
                    // InternalPerl.g:1825:3: kw= 'getprotoent'
                    {
                    kw=(Token)match(input,113,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetprotoentKeyword_72());
                    		

                    }
                    break;
                case 74 :
                    // InternalPerl.g:1831:3: kw= 'getpwent'
                    {
                    kw=(Token)match(input,114,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpwentKeyword_73());
                    		

                    }
                    break;
                case 75 :
                    // InternalPerl.g:1837:3: kw= 'getpwnam'
                    {
                    kw=(Token)match(input,115,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpwnamKeyword_74());
                    		

                    }
                    break;
                case 76 :
                    // InternalPerl.g:1843:3: kw= 'getpwuid'
                    {
                    kw=(Token)match(input,116,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpwuidKeyword_75());
                    		

                    }
                    break;
                case 77 :
                    // InternalPerl.g:1849:3: kw= 'getservbyname'
                    {
                    kw=(Token)match(input,117,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetservbynameKeyword_76());
                    		

                    }
                    break;
                case 78 :
                    // InternalPerl.g:1855:3: kw= 'getservbyport'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetservbyportKeyword_77());
                    		

                    }
                    break;
                case 79 :
                    // InternalPerl.g:1861:3: kw= 'getservent'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetserventKeyword_78());
                    		

                    }
                    break;
                case 80 :
                    // InternalPerl.g:1867:3: kw= 'getsockname'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetsocknameKeyword_79());
                    		

                    }
                    break;
                case 81 :
                    // InternalPerl.g:1873:3: kw= 'getsockopt'
                    {
                    kw=(Token)match(input,121,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetsockoptKeyword_80());
                    		

                    }
                    break;
                case 82 :
                    // InternalPerl.g:1879:3: kw= 'given'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGivenKeyword_81());
                    		

                    }
                    break;
                case 83 :
                    // InternalPerl.g:1885:3: kw= 'glob'
                    {
                    kw=(Token)match(input,123,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGlobKeyword_82());
                    		

                    }
                    break;
                case 84 :
                    // InternalPerl.g:1891:3: kw= 'gmtime'
                    {
                    kw=(Token)match(input,124,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGmtimeKeyword_83());
                    		

                    }
                    break;
                case 85 :
                    // InternalPerl.g:1897:3: kw= 'goto'
                    {
                    kw=(Token)match(input,125,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGotoKeyword_84());
                    		

                    }
                    break;
                case 86 :
                    // InternalPerl.g:1903:3: kw= 'grep'
                    {
                    kw=(Token)match(input,126,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getGrepKeyword_85());
                    		

                    }
                    break;
                case 87 :
                    // InternalPerl.g:1909:3: kw= 'hex'
                    {
                    kw=(Token)match(input,127,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getHexKeyword_86());
                    		

                    }
                    break;
                case 88 :
                    // InternalPerl.g:1915:3: kw= 'if'
                    {
                    kw=(Token)match(input,128,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getIfKeyword_87());
                    		

                    }
                    break;
                case 89 :
                    // InternalPerl.g:1921:3: kw= 'index'
                    {
                    kw=(Token)match(input,129,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getIndexKeyword_88());
                    		

                    }
                    break;
                case 90 :
                    // InternalPerl.g:1927:3: kw= 'int'
                    {
                    kw=(Token)match(input,130,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getIntKeyword_89());
                    		

                    }
                    break;
                case 91 :
                    // InternalPerl.g:1933:3: kw= 'ioctl'
                    {
                    kw=(Token)match(input,131,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getIoctlKeyword_90());
                    		

                    }
                    break;
                case 92 :
                    // InternalPerl.g:1939:3: kw= 'join'
                    {
                    kw=(Token)match(input,132,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getJoinKeyword_91());
                    		

                    }
                    break;
                case 93 :
                    // InternalPerl.g:1945:3: kw= 'keys'
                    {
                    kw=(Token)match(input,133,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getKeysKeyword_92());
                    		

                    }
                    break;
                case 94 :
                    // InternalPerl.g:1951:3: kw= 'kill'
                    {
                    kw=(Token)match(input,134,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getKillKeyword_93());
                    		

                    }
                    break;
                case 95 :
                    // InternalPerl.g:1957:3: kw= 'last'
                    {
                    kw=(Token)match(input,135,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getLastKeyword_94());
                    		

                    }
                    break;
                case 96 :
                    // InternalPerl.g:1963:3: kw= 'lc'
                    {
                    kw=(Token)match(input,136,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getLcKeyword_95());
                    		

                    }
                    break;
                case 97 :
                    // InternalPerl.g:1969:3: kw= 'lcfirst'
                    {
                    kw=(Token)match(input,137,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getLcfirstKeyword_96());
                    		

                    }
                    break;
                case 98 :
                    // InternalPerl.g:1975:3: kw= 'length'
                    {
                    kw=(Token)match(input,138,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getLengthKeyword_97());
                    		

                    }
                    break;
                case 99 :
                    // InternalPerl.g:1981:3: kw= 'link'
                    {
                    kw=(Token)match(input,139,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getLinkKeyword_98());
                    		

                    }
                    break;
                case 100 :
                    // InternalPerl.g:1987:3: kw= 'listen'
                    {
                    kw=(Token)match(input,140,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getListenKeyword_99());
                    		

                    }
                    break;
                case 101 :
                    // InternalPerl.g:1993:3: kw= 'local'
                    {
                    kw=(Token)match(input,141,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getLocalKeyword_100());
                    		

                    }
                    break;
                case 102 :
                    // InternalPerl.g:1999:3: kw= 'localtime'
                    {
                    kw=(Token)match(input,142,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getLocaltimeKeyword_101());
                    		

                    }
                    break;
                case 103 :
                    // InternalPerl.g:2005:3: kw= 'lock'
                    {
                    kw=(Token)match(input,143,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getLockKeyword_102());
                    		

                    }
                    break;
                case 104 :
                    // InternalPerl.g:2011:3: kw= 'log'
                    {
                    kw=(Token)match(input,144,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getLogKeyword_103());
                    		

                    }
                    break;
                case 105 :
                    // InternalPerl.g:2017:3: kw= 'lstat'
                    {
                    kw=(Token)match(input,145,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getLstatKeyword_104());
                    		

                    }
                    break;
                case 106 :
                    // InternalPerl.g:2023:3: kw= 'map'
                    {
                    kw=(Token)match(input,146,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getMapKeyword_105());
                    		

                    }
                    break;
                case 107 :
                    // InternalPerl.g:2029:3: kw= 'mkdir'
                    {
                    kw=(Token)match(input,147,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getMkdirKeyword_106());
                    		

                    }
                    break;
                case 108 :
                    // InternalPerl.g:2035:3: kw= 'msgctl'
                    {
                    kw=(Token)match(input,148,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getMsgctlKeyword_107());
                    		

                    }
                    break;
                case 109 :
                    // InternalPerl.g:2041:3: kw= 'msgget'
                    {
                    kw=(Token)match(input,149,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getMsggetKeyword_108());
                    		

                    }
                    break;
                case 110 :
                    // InternalPerl.g:2047:3: kw= 'msgrcv'
                    {
                    kw=(Token)match(input,150,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getMsgrcvKeyword_109());
                    		

                    }
                    break;
                case 111 :
                    // InternalPerl.g:2053:3: kw= 'msgsnd'
                    {
                    kw=(Token)match(input,151,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getMsgsndKeyword_110());
                    		

                    }
                    break;
                case 112 :
                    // InternalPerl.g:2059:3: kw= 'my'
                    {
                    kw=(Token)match(input,152,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getMyKeyword_111());
                    		

                    }
                    break;
                case 113 :
                    // InternalPerl.g:2065:3: kw= 'next'
                    {
                    kw=(Token)match(input,153,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getNextKeyword_112());
                    		

                    }
                    break;
                case 114 :
                    // InternalPerl.g:2071:3: kw= 'no'
                    {
                    kw=(Token)match(input,154,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getNoKeyword_113());
                    		

                    }
                    break;
                case 115 :
                    // InternalPerl.g:2077:3: kw= 'oct'
                    {
                    kw=(Token)match(input,155,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getOctKeyword_114());
                    		

                    }
                    break;
                case 116 :
                    // InternalPerl.g:2083:3: kw= 'open'
                    {
                    kw=(Token)match(input,156,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getOpenKeyword_115());
                    		

                    }
                    break;
                case 117 :
                    // InternalPerl.g:2089:3: kw= 'opendir'
                    {
                    kw=(Token)match(input,157,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getOpendirKeyword_116());
                    		

                    }
                    break;
                case 118 :
                    // InternalPerl.g:2095:3: kw= 'ord'
                    {
                    kw=(Token)match(input,158,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getOrdKeyword_117());
                    		

                    }
                    break;
                case 119 :
                    // InternalPerl.g:2101:3: kw= 'our'
                    {
                    kw=(Token)match(input,159,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getOurKeyword_118());
                    		

                    }
                    break;
                case 120 :
                    // InternalPerl.g:2107:3: kw= 'pack'
                    {
                    kw=(Token)match(input,160,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getPackKeyword_119());
                    		

                    }
                    break;
                case 121 :
                    // InternalPerl.g:2113:3: kw= 'package'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getPackageKeyword_120());
                    		

                    }
                    break;
                case 122 :
                    // InternalPerl.g:2119:3: kw= 'pipe'
                    {
                    kw=(Token)match(input,161,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getPipeKeyword_121());
                    		

                    }
                    break;
                case 123 :
                    // InternalPerl.g:2125:3: kw= 'pop'
                    {
                    kw=(Token)match(input,162,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getPopKeyword_122());
                    		

                    }
                    break;
                case 124 :
                    // InternalPerl.g:2131:3: kw= 'pos'
                    {
                    kw=(Token)match(input,163,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getPosKeyword_123());
                    		

                    }
                    break;
                case 125 :
                    // InternalPerl.g:2137:3: kw= 'print'
                    {
                    kw=(Token)match(input,164,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getPrintKeyword_124());
                    		

                    }
                    break;
                case 126 :
                    // InternalPerl.g:2143:3: kw= 'printf'
                    {
                    kw=(Token)match(input,165,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getPrintfKeyword_125());
                    		

                    }
                    break;
                case 127 :
                    // InternalPerl.g:2149:3: kw= 'prototype'
                    {
                    kw=(Token)match(input,166,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getPrototypeKeyword_126());
                    		

                    }
                    break;
                case 128 :
                    // InternalPerl.g:2155:3: kw= 'push'
                    {
                    kw=(Token)match(input,167,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getPushKeyword_127());
                    		

                    }
                    break;
                case 129 :
                    // InternalPerl.g:2161:3: kw= 'quotemeta'
                    {
                    kw=(Token)match(input,168,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getQuotemetaKeyword_128());
                    		

                    }
                    break;
                case 130 :
                    // InternalPerl.g:2167:3: kw= 'rand'
                    {
                    kw=(Token)match(input,169,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getRandKeyword_129());
                    		

                    }
                    break;
                case 131 :
                    // InternalPerl.g:2173:3: kw= 'read'
                    {
                    kw=(Token)match(input,170,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getReadKeyword_130());
                    		

                    }
                    break;
                case 132 :
                    // InternalPerl.g:2179:3: kw= 'readdir'
                    {
                    kw=(Token)match(input,171,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getReaddirKeyword_131());
                    		

                    }
                    break;
                case 133 :
                    // InternalPerl.g:2185:3: kw= 'readline'
                    {
                    kw=(Token)match(input,172,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getReadlineKeyword_132());
                    		

                    }
                    break;
                case 134 :
                    // InternalPerl.g:2191:3: kw= 'readlink'
                    {
                    kw=(Token)match(input,173,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getReadlinkKeyword_133());
                    		

                    }
                    break;
                case 135 :
                    // InternalPerl.g:2197:3: kw= 'readpipe'
                    {
                    kw=(Token)match(input,174,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getReadpipeKeyword_134());
                    		

                    }
                    break;
                case 136 :
                    // InternalPerl.g:2203:3: kw= 'recv'
                    {
                    kw=(Token)match(input,175,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getRecvKeyword_135());
                    		

                    }
                    break;
                case 137 :
                    // InternalPerl.g:2209:3: kw= 'redo'
                    {
                    kw=(Token)match(input,176,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getRedoKeyword_136());
                    		

                    }
                    break;
                case 138 :
                    // InternalPerl.g:2215:3: kw= 'ref'
                    {
                    kw=(Token)match(input,177,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getRefKeyword_137());
                    		

                    }
                    break;
                case 139 :
                    // InternalPerl.g:2221:3: kw= 'rename'
                    {
                    kw=(Token)match(input,178,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getRenameKeyword_138());
                    		

                    }
                    break;
                case 140 :
                    // InternalPerl.g:2227:3: kw= 'require'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getRequireKeyword_139());
                    		

                    }
                    break;
                case 141 :
                    // InternalPerl.g:2233:3: kw= 'reset'
                    {
                    kw=(Token)match(input,179,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getResetKeyword_140());
                    		

                    }
                    break;
                case 142 :
                    // InternalPerl.g:2239:3: kw= 'return'
                    {
                    kw=(Token)match(input,180,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getReturnKeyword_141());
                    		

                    }
                    break;
                case 143 :
                    // InternalPerl.g:2245:3: kw= 'reverse'
                    {
                    kw=(Token)match(input,181,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getReverseKeyword_142());
                    		

                    }
                    break;
                case 144 :
                    // InternalPerl.g:2251:3: kw= 'rewinddir'
                    {
                    kw=(Token)match(input,182,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getRewinddirKeyword_143());
                    		

                    }
                    break;
                case 145 :
                    // InternalPerl.g:2257:3: kw= 'rindex'
                    {
                    kw=(Token)match(input,183,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getRindexKeyword_144());
                    		

                    }
                    break;
                case 146 :
                    // InternalPerl.g:2263:3: kw= 'rmdir'
                    {
                    kw=(Token)match(input,184,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getRmdirKeyword_145());
                    		

                    }
                    break;
                case 147 :
                    // InternalPerl.g:2269:3: kw= 'say'
                    {
                    kw=(Token)match(input,185,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSayKeyword_146());
                    		

                    }
                    break;
                case 148 :
                    // InternalPerl.g:2275:3: kw= 'scalar'
                    {
                    kw=(Token)match(input,186,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getScalarKeyword_147());
                    		

                    }
                    break;
                case 149 :
                    // InternalPerl.g:2281:3: kw= 'seek'
                    {
                    kw=(Token)match(input,187,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSeekKeyword_148());
                    		

                    }
                    break;
                case 150 :
                    // InternalPerl.g:2287:3: kw= 'seekdir'
                    {
                    kw=(Token)match(input,188,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSeekdirKeyword_149());
                    		

                    }
                    break;
                case 151 :
                    // InternalPerl.g:2293:3: kw= 'select'
                    {
                    kw=(Token)match(input,189,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSelectKeyword_150());
                    		

                    }
                    break;
                case 152 :
                    // InternalPerl.g:2299:3: kw= 'semctl'
                    {
                    kw=(Token)match(input,190,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSemctlKeyword_151());
                    		

                    }
                    break;
                case 153 :
                    // InternalPerl.g:2305:3: kw= 'semget'
                    {
                    kw=(Token)match(input,191,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSemgetKeyword_152());
                    		

                    }
                    break;
                case 154 :
                    // InternalPerl.g:2311:3: kw= 'semop'
                    {
                    kw=(Token)match(input,192,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSemopKeyword_153());
                    		

                    }
                    break;
                case 155 :
                    // InternalPerl.g:2317:3: kw= 'send'
                    {
                    kw=(Token)match(input,193,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSendKeyword_154());
                    		

                    }
                    break;
                case 156 :
                    // InternalPerl.g:2323:3: kw= 'setgrent'
                    {
                    kw=(Token)match(input,194,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetgrentKeyword_155());
                    		

                    }
                    break;
                case 157 :
                    // InternalPerl.g:2329:3: kw= 'sethostent'
                    {
                    kw=(Token)match(input,195,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSethostentKeyword_156());
                    		

                    }
                    break;
                case 158 :
                    // InternalPerl.g:2335:3: kw= 'setnetent'
                    {
                    kw=(Token)match(input,196,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetnetentKeyword_157());
                    		

                    }
                    break;
                case 159 :
                    // InternalPerl.g:2341:3: kw= 'setpgrp'
                    {
                    kw=(Token)match(input,197,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetpgrpKeyword_158());
                    		

                    }
                    break;
                case 160 :
                    // InternalPerl.g:2347:3: kw= 'setpriority'
                    {
                    kw=(Token)match(input,198,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetpriorityKeyword_159());
                    		

                    }
                    break;
                case 161 :
                    // InternalPerl.g:2353:3: kw= 'setprotoent'
                    {
                    kw=(Token)match(input,199,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetprotoentKeyword_160());
                    		

                    }
                    break;
                case 162 :
                    // InternalPerl.g:2359:3: kw= 'setpwent'
                    {
                    kw=(Token)match(input,200,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetpwentKeyword_161());
                    		

                    }
                    break;
                case 163 :
                    // InternalPerl.g:2365:3: kw= 'setservent'
                    {
                    kw=(Token)match(input,201,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetserventKeyword_162());
                    		

                    }
                    break;
                case 164 :
                    // InternalPerl.g:2371:3: kw= 'setsockopt'
                    {
                    kw=(Token)match(input,202,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetsockoptKeyword_163());
                    		

                    }
                    break;
                case 165 :
                    // InternalPerl.g:2377:3: kw= 'shift'
                    {
                    kw=(Token)match(input,203,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getShiftKeyword_164());
                    		

                    }
                    break;
                case 166 :
                    // InternalPerl.g:2383:3: kw= 'shmctl'
                    {
                    kw=(Token)match(input,204,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getShmctlKeyword_165());
                    		

                    }
                    break;
                case 167 :
                    // InternalPerl.g:2389:3: kw= 'shmget'
                    {
                    kw=(Token)match(input,205,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getShmgetKeyword_166());
                    		

                    }
                    break;
                case 168 :
                    // InternalPerl.g:2395:3: kw= 'shmread'
                    {
                    kw=(Token)match(input,206,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getShmreadKeyword_167());
                    		

                    }
                    break;
                case 169 :
                    // InternalPerl.g:2401:3: kw= 'shmwrite'
                    {
                    kw=(Token)match(input,207,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getShmwriteKeyword_168());
                    		

                    }
                    break;
                case 170 :
                    // InternalPerl.g:2407:3: kw= 'shutdown'
                    {
                    kw=(Token)match(input,208,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getShutdownKeyword_169());
                    		

                    }
                    break;
                case 171 :
                    // InternalPerl.g:2413:3: kw= 'sin'
                    {
                    kw=(Token)match(input,209,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSinKeyword_170());
                    		

                    }
                    break;
                case 172 :
                    // InternalPerl.g:2419:3: kw= 'sleep'
                    {
                    kw=(Token)match(input,210,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSleepKeyword_171());
                    		

                    }
                    break;
                case 173 :
                    // InternalPerl.g:2425:3: kw= 'socket'
                    {
                    kw=(Token)match(input,211,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSocketKeyword_172());
                    		

                    }
                    break;
                case 174 :
                    // InternalPerl.g:2431:3: kw= 'socketpair'
                    {
                    kw=(Token)match(input,212,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSocketpairKeyword_173());
                    		

                    }
                    break;
                case 175 :
                    // InternalPerl.g:2437:3: kw= 'sort'
                    {
                    kw=(Token)match(input,213,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSortKeyword_174());
                    		

                    }
                    break;
                case 176 :
                    // InternalPerl.g:2443:3: kw= 'splice'
                    {
                    kw=(Token)match(input,214,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSpliceKeyword_175());
                    		

                    }
                    break;
                case 177 :
                    // InternalPerl.g:2449:3: kw= 'split'
                    {
                    kw=(Token)match(input,215,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSplitKeyword_176());
                    		

                    }
                    break;
                case 178 :
                    // InternalPerl.g:2455:3: kw= 'sprintf'
                    {
                    kw=(Token)match(input,216,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSprintfKeyword_177());
                    		

                    }
                    break;
                case 179 :
                    // InternalPerl.g:2461:3: kw= 'sqrt'
                    {
                    kw=(Token)match(input,217,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSqrtKeyword_178());
                    		

                    }
                    break;
                case 180 :
                    // InternalPerl.g:2467:3: kw= 'srand'
                    {
                    kw=(Token)match(input,218,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSrandKeyword_179());
                    		

                    }
                    break;
                case 181 :
                    // InternalPerl.g:2473:3: kw= 'stat'
                    {
                    kw=(Token)match(input,219,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getStatKeyword_180());
                    		

                    }
                    break;
                case 182 :
                    // InternalPerl.g:2479:3: kw= 'state'
                    {
                    kw=(Token)match(input,220,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getStateKeyword_181());
                    		

                    }
                    break;
                case 183 :
                    // InternalPerl.g:2485:3: kw= 'study'
                    {
                    kw=(Token)match(input,221,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getStudyKeyword_182());
                    		

                    }
                    break;
                case 184 :
                    // InternalPerl.g:2491:3: kw= 'sub'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSubKeyword_183());
                    		

                    }
                    break;
                case 185 :
                    // InternalPerl.g:2497:3: kw= 'substr'
                    {
                    kw=(Token)match(input,222,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSubstrKeyword_184());
                    		

                    }
                    break;
                case 186 :
                    // InternalPerl.g:2503:3: kw= 'symlink'
                    {
                    kw=(Token)match(input,223,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSymlinkKeyword_185());
                    		

                    }
                    break;
                case 187 :
                    // InternalPerl.g:2509:3: kw= 'syscall'
                    {
                    kw=(Token)match(input,224,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSyscallKeyword_186());
                    		

                    }
                    break;
                case 188 :
                    // InternalPerl.g:2515:3: kw= 'sysopen'
                    {
                    kw=(Token)match(input,225,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSysopenKeyword_187());
                    		

                    }
                    break;
                case 189 :
                    // InternalPerl.g:2521:3: kw= 'sysread'
                    {
                    kw=(Token)match(input,226,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSysreadKeyword_188());
                    		

                    }
                    break;
                case 190 :
                    // InternalPerl.g:2527:3: kw= 'sysseek'
                    {
                    kw=(Token)match(input,227,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSysseekKeyword_189());
                    		

                    }
                    break;
                case 191 :
                    // InternalPerl.g:2533:3: kw= 'system'
                    {
                    kw=(Token)match(input,228,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSystemKeyword_190());
                    		

                    }
                    break;
                case 192 :
                    // InternalPerl.g:2539:3: kw= 'syswrite'
                    {
                    kw=(Token)match(input,229,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getSyswriteKeyword_191());
                    		

                    }
                    break;
                case 193 :
                    // InternalPerl.g:2545:3: kw= 'tell'
                    {
                    kw=(Token)match(input,230,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getTellKeyword_192());
                    		

                    }
                    break;
                case 194 :
                    // InternalPerl.g:2551:3: kw= 'telldir'
                    {
                    kw=(Token)match(input,231,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getTelldirKeyword_193());
                    		

                    }
                    break;
                case 195 :
                    // InternalPerl.g:2557:3: kw= 'tie'
                    {
                    kw=(Token)match(input,232,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getTieKeyword_194());
                    		

                    }
                    break;
                case 196 :
                    // InternalPerl.g:2563:3: kw= 'tied'
                    {
                    kw=(Token)match(input,233,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getTiedKeyword_195());
                    		

                    }
                    break;
                case 197 :
                    // InternalPerl.g:2569:3: kw= 'time'
                    {
                    kw=(Token)match(input,234,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getTimeKeyword_196());
                    		

                    }
                    break;
                case 198 :
                    // InternalPerl.g:2575:3: kw= 'times'
                    {
                    kw=(Token)match(input,235,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getTimesKeyword_197());
                    		

                    }
                    break;
                case 199 :
                    // InternalPerl.g:2581:3: kw= 'tr'
                    {
                    kw=(Token)match(input,236,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getTrKeyword_198());
                    		

                    }
                    break;
                case 200 :
                    // InternalPerl.g:2587:3: kw= 'truncate'
                    {
                    kw=(Token)match(input,237,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getTruncateKeyword_199());
                    		

                    }
                    break;
                case 201 :
                    // InternalPerl.g:2593:3: kw= 'uc'
                    {
                    kw=(Token)match(input,238,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUcKeyword_200());
                    		

                    }
                    break;
                case 202 :
                    // InternalPerl.g:2599:3: kw= 'ucfirst'
                    {
                    kw=(Token)match(input,239,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUcfirstKeyword_201());
                    		

                    }
                    break;
                case 203 :
                    // InternalPerl.g:2605:3: kw= 'umask'
                    {
                    kw=(Token)match(input,240,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUmaskKeyword_202());
                    		

                    }
                    break;
                case 204 :
                    // InternalPerl.g:2611:3: kw= 'undef'
                    {
                    kw=(Token)match(input,241,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUndefKeyword_203());
                    		

                    }
                    break;
                case 205 :
                    // InternalPerl.g:2617:3: kw= 'unless'
                    {
                    kw=(Token)match(input,242,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUnlessKeyword_204());
                    		

                    }
                    break;
                case 206 :
                    // InternalPerl.g:2623:3: kw= 'unlink'
                    {
                    kw=(Token)match(input,243,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUnlinkKeyword_205());
                    		

                    }
                    break;
                case 207 :
                    // InternalPerl.g:2629:3: kw= 'unpack'
                    {
                    kw=(Token)match(input,244,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUnpackKeyword_206());
                    		

                    }
                    break;
                case 208 :
                    // InternalPerl.g:2635:3: kw= 'unshift'
                    {
                    kw=(Token)match(input,245,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUnshiftKeyword_207());
                    		

                    }
                    break;
                case 209 :
                    // InternalPerl.g:2641:3: kw= 'untie'
                    {
                    kw=(Token)match(input,246,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUntieKeyword_208());
                    		

                    }
                    break;
                case 210 :
                    // InternalPerl.g:2647:3: kw= 'until'
                    {
                    kw=(Token)match(input,247,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUntilKeyword_209());
                    		

                    }
                    break;
                case 211 :
                    // InternalPerl.g:2653:3: kw= 'use'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUseKeyword_210());
                    		

                    }
                    break;
                case 212 :
                    // InternalPerl.g:2659:3: kw= 'utime'
                    {
                    kw=(Token)match(input,248,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getUtimeKeyword_211());
                    		

                    }
                    break;
                case 213 :
                    // InternalPerl.g:2665:3: kw= 'values'
                    {
                    kw=(Token)match(input,249,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getValuesKeyword_212());
                    		

                    }
                    break;
                case 214 :
                    // InternalPerl.g:2671:3: kw= 'vec'
                    {
                    kw=(Token)match(input,250,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getVecKeyword_213());
                    		

                    }
                    break;
                case 215 :
                    // InternalPerl.g:2677:3: kw= 'wait'
                    {
                    kw=(Token)match(input,251,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getWaitKeyword_214());
                    		

                    }
                    break;
                case 216 :
                    // InternalPerl.g:2683:3: kw= 'waitpid'
                    {
                    kw=(Token)match(input,252,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getWaitpidKeyword_215());
                    		

                    }
                    break;
                case 217 :
                    // InternalPerl.g:2689:3: kw= 'wantarray'
                    {
                    kw=(Token)match(input,253,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getWantarrayKeyword_216());
                    		

                    }
                    break;
                case 218 :
                    // InternalPerl.g:2695:3: kw= 'warn'
                    {
                    kw=(Token)match(input,254,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getWarnKeyword_217());
                    		

                    }
                    break;
                case 219 :
                    // InternalPerl.g:2701:3: kw= 'when'
                    {
                    kw=(Token)match(input,255,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getWhenKeyword_218());
                    		

                    }
                    break;
                case 220 :
                    // InternalPerl.g:2707:3: kw= 'while'
                    {
                    kw=(Token)match(input,256,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getWhileKeyword_219());
                    		

                    }
                    break;
                case 221 :
                    // InternalPerl.g:2713:3: kw= 'write'
                    {
                    kw=(Token)match(input,257,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getWriteKeyword_220());
                    		

                    }
                    break;
                case 222 :
                    // InternalPerl.g:2719:3: kw= 'y'
                    {
                    kw=(Token)match(input,258,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKeywordAccess().getYKeyword_221());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleOperator"
    // InternalPerl.g:2728:1: entryRuleOperator returns [String current=null] : iv_ruleOperator= ruleOperator EOF ;
    public final String entryRuleOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOperator = null;


        try {
            // InternalPerl.g:2728:48: (iv_ruleOperator= ruleOperator EOF )
            // InternalPerl.g:2729:2: iv_ruleOperator= ruleOperator EOF
            {
             newCompositeNode(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperator=ruleOperator();

            state._fsp--;

             current =iv_ruleOperator.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalPerl.g:2735:1: ruleOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' | kw= '--' | kw= '**' | kw= '!' | kw= '~' | kw= '+' | kw= '-' | kw= '=~' | kw= '!~' | kw= '*' | kw= '/' | kw= '%' | kw= 'x' | kw= '<<' | kw= '>>' | kw= 'lt' | kw= 'gt' | kw= 'le' | kw= 'ge' | kw= 'cmp' | kw= '~~' | kw= '==' | kw= '!=' | (kw= '<=>' kw= '.' ) | kw= '..' | kw= '...' | kw= ',' | kw= '&' | kw= '|' | kw= '^' | kw= '&&' | kw= '||' | kw= '//' | kw= '?' | kw= ':' | kw= '**=' | kw= '+=' | kw= '-=' | kw= '.=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= 'x=' | kw= '&=' | kw= '|=' | kw= '^=' | kw= '<<=' | kw= '>>=' | kw= '&&=' | kw= '||=' | kw= '//=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '<>' | kw= '=>' | kw= '->' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'not' | kw= 'eq' | kw= 'ne' ) ;
    public final AntlrDatatypeRuleToken ruleOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:2741:2: ( (kw= '++' | kw= '--' | kw= '**' | kw= '!' | kw= '~' | kw= '+' | kw= '-' | kw= '=~' | kw= '!~' | kw= '*' | kw= '/' | kw= '%' | kw= 'x' | kw= '<<' | kw= '>>' | kw= 'lt' | kw= 'gt' | kw= 'le' | kw= 'ge' | kw= 'cmp' | kw= '~~' | kw= '==' | kw= '!=' | (kw= '<=>' kw= '.' ) | kw= '..' | kw= '...' | kw= ',' | kw= '&' | kw= '|' | kw= '^' | kw= '&&' | kw= '||' | kw= '//' | kw= '?' | kw= ':' | kw= '**=' | kw= '+=' | kw= '-=' | kw= '.=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= 'x=' | kw= '&=' | kw= '|=' | kw= '^=' | kw= '<<=' | kw= '>>=' | kw= '&&=' | kw= '||=' | kw= '//=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '<>' | kw= '=>' | kw= '->' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'not' | kw= 'eq' | kw= 'ne' ) )
            // InternalPerl.g:2742:2: (kw= '++' | kw= '--' | kw= '**' | kw= '!' | kw= '~' | kw= '+' | kw= '-' | kw= '=~' | kw= '!~' | kw= '*' | kw= '/' | kw= '%' | kw= 'x' | kw= '<<' | kw= '>>' | kw= 'lt' | kw= 'gt' | kw= 'le' | kw= 'ge' | kw= 'cmp' | kw= '~~' | kw= '==' | kw= '!=' | (kw= '<=>' kw= '.' ) | kw= '..' | kw= '...' | kw= ',' | kw= '&' | kw= '|' | kw= '^' | kw= '&&' | kw= '||' | kw= '//' | kw= '?' | kw= ':' | kw= '**=' | kw= '+=' | kw= '-=' | kw= '.=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= 'x=' | kw= '&=' | kw= '|=' | kw= '^=' | kw= '<<=' | kw= '>>=' | kw= '&&=' | kw= '||=' | kw= '//=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '<>' | kw= '=>' | kw= '->' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'not' | kw= 'eq' | kw= 'ne' )
            {
            // InternalPerl.g:2742:2: (kw= '++' | kw= '--' | kw= '**' | kw= '!' | kw= '~' | kw= '+' | kw= '-' | kw= '=~' | kw= '!~' | kw= '*' | kw= '/' | kw= '%' | kw= 'x' | kw= '<<' | kw= '>>' | kw= 'lt' | kw= 'gt' | kw= 'le' | kw= 'ge' | kw= 'cmp' | kw= '~~' | kw= '==' | kw= '!=' | (kw= '<=>' kw= '.' ) | kw= '..' | kw= '...' | kw= ',' | kw= '&' | kw= '|' | kw= '^' | kw= '&&' | kw= '||' | kw= '//' | kw= '?' | kw= ':' | kw= '**=' | kw= '+=' | kw= '-=' | kw= '.=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= 'x=' | kw= '&=' | kw= '|=' | kw= '^=' | kw= '<<=' | kw= '>>=' | kw= '&&=' | kw= '||=' | kw= '//=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '<>' | kw= '=>' | kw= '->' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'not' | kw= 'eq' | kw= 'ne' )
            int alt19=64;
            switch ( input.LA(1) ) {
            case 259:
                {
                alt19=1;
                }
                break;
            case 260:
                {
                alt19=2;
                }
                break;
            case 261:
                {
                alt19=3;
                }
                break;
            case 262:
                {
                alt19=4;
                }
                break;
            case 263:
                {
                alt19=5;
                }
                break;
            case 264:
                {
                alt19=6;
                }
                break;
            case 265:
                {
                alt19=7;
                }
                break;
            case 266:
                {
                alt19=8;
                }
                break;
            case 267:
                {
                alt19=9;
                }
                break;
            case 268:
                {
                alt19=10;
                }
                break;
            case 269:
                {
                alt19=11;
                }
                break;
            case 37:
                {
                alt19=12;
                }
                break;
            case 270:
                {
                alt19=13;
                }
                break;
            case 271:
                {
                alt19=14;
                }
                break;
            case 272:
                {
                alt19=15;
                }
                break;
            case 273:
                {
                alt19=16;
                }
                break;
            case 274:
                {
                alt19=17;
                }
                break;
            case 275:
                {
                alt19=18;
                }
                break;
            case 276:
                {
                alt19=19;
                }
                break;
            case 277:
                {
                alt19=20;
                }
                break;
            case 278:
                {
                alt19=21;
                }
                break;
            case 279:
                {
                alt19=22;
                }
                break;
            case 280:
                {
                alt19=23;
                }
                break;
            case 281:
                {
                alt19=24;
                }
                break;
            case 283:
                {
                alt19=25;
                }
                break;
            case 284:
                {
                alt19=26;
                }
                break;
            case 285:
                {
                alt19=27;
                }
                break;
            case 39:
                {
                alt19=28;
                }
                break;
            case 286:
                {
                alt19=29;
                }
                break;
            case 287:
                {
                alt19=30;
                }
                break;
            case 288:
                {
                alt19=31;
                }
                break;
            case 289:
                {
                alt19=32;
                }
                break;
            case 290:
                {
                alt19=33;
                }
                break;
            case 291:
                {
                alt19=34;
                }
                break;
            case 292:
                {
                alt19=35;
                }
                break;
            case 293:
                {
                alt19=36;
                }
                break;
            case 294:
                {
                alt19=37;
                }
                break;
            case 295:
                {
                alt19=38;
                }
                break;
            case 296:
                {
                alt19=39;
                }
                break;
            case 297:
                {
                alt19=40;
                }
                break;
            case 298:
                {
                alt19=41;
                }
                break;
            case 299:
                {
                alt19=42;
                }
                break;
            case 300:
                {
                alt19=43;
                }
                break;
            case 301:
                {
                alt19=44;
                }
                break;
            case 302:
                {
                alt19=45;
                }
                break;
            case 303:
                {
                alt19=46;
                }
                break;
            case 304:
                {
                alt19=47;
                }
                break;
            case 305:
                {
                alt19=48;
                }
                break;
            case 306:
                {
                alt19=49;
                }
                break;
            case 307:
                {
                alt19=50;
                }
                break;
            case 308:
                {
                alt19=51;
                }
                break;
            case 309:
                {
                alt19=52;
                }
                break;
            case 310:
                {
                alt19=53;
                }
                break;
            case 311:
                {
                alt19=54;
                }
                break;
            case 312:
                {
                alt19=55;
                }
                break;
            case 313:
                {
                alt19=56;
                }
                break;
            case 314:
                {
                alt19=57;
                }
                break;
            case 315:
                {
                alt19=58;
                }
                break;
            case 316:
                {
                alt19=59;
                }
                break;
            case 317:
                {
                alt19=60;
                }
                break;
            case 318:
                {
                alt19=61;
                }
                break;
            case 319:
                {
                alt19=62;
                }
                break;
            case 320:
                {
                alt19=63;
                }
                break;
            case 321:
                {
                alt19=64;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalPerl.g:2743:3: kw= '++'
                    {
                    kw=(Token)match(input,259,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:2749:3: kw= '--'
                    {
                    kw=(Token)match(input,260,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalPerl.g:2755:3: kw= '**'
                    {
                    kw=(Token)match(input,261,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalPerl.g:2761:3: kw= '!'
                    {
                    kw=(Token)match(input,262,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalPerl.g:2767:3: kw= '~'
                    {
                    kw=(Token)match(input,263,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getTildeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalPerl.g:2773:3: kw= '+'
                    {
                    kw=(Token)match(input,264,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getPlusSignKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalPerl.g:2779:3: kw= '-'
                    {
                    kw=(Token)match(input,265,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalPerl.g:2785:3: kw= '=~'
                    {
                    kw=(Token)match(input,266,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalPerl.g:2791:3: kw= '!~'
                    {
                    kw=(Token)match(input,267,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalPerl.g:2797:3: kw= '*'
                    {
                    kw=(Token)match(input,268,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getAsteriskKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalPerl.g:2803:3: kw= '/'
                    {
                    kw=(Token)match(input,269,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getSolidusKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalPerl.g:2809:3: kw= '%'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getPercentSignKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalPerl.g:2815:3: kw= 'x'
                    {
                    kw=(Token)match(input,270,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getXKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalPerl.g:2821:3: kw= '<<'
                    {
                    kw=(Token)match(input,271,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalPerl.g:2827:3: kw= '>>'
                    {
                    kw=(Token)match(input,272,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalPerl.g:2833:3: kw= 'lt'
                    {
                    kw=(Token)match(input,273,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getLtKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalPerl.g:2839:3: kw= 'gt'
                    {
                    kw=(Token)match(input,274,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getGtKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalPerl.g:2845:3: kw= 'le'
                    {
                    kw=(Token)match(input,275,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getLeKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalPerl.g:2851:3: kw= 'ge'
                    {
                    kw=(Token)match(input,276,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getGeKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalPerl.g:2857:3: kw= 'cmp'
                    {
                    kw=(Token)match(input,277,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getCmpKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalPerl.g:2863:3: kw= '~~'
                    {
                    kw=(Token)match(input,278,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getTildeTildeKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalPerl.g:2869:3: kw= '=='
                    {
                    kw=(Token)match(input,279,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalPerl.g:2875:3: kw= '!='
                    {
                    kw=(Token)match(input,280,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalPerl.g:2881:3: (kw= '<=>' kw= '.' )
                    {
                    // InternalPerl.g:2881:3: (kw= '<=>' kw= '.' )
                    // InternalPerl.g:2882:4: kw= '<=>' kw= '.'
                    {
                    kw=(Token)match(input,281,FOLLOW_14); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_23_0());
                    			
                    kw=(Token)match(input,282,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getOperatorAccess().getFullStopKeyword_23_1());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:2894:3: kw= '..'
                    {
                    kw=(Token)match(input,283,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalPerl.g:2900:3: kw= '...'
                    {
                    kw=(Token)match(input,284,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalPerl.g:2906:3: kw= ','
                    {
                    kw=(Token)match(input,285,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getCommaKeyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalPerl.g:2912:3: kw= '&'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getAmpersandKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalPerl.g:2918:3: kw= '|'
                    {
                    kw=(Token)match(input,286,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getVerticalLineKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalPerl.g:2924:3: kw= '^'
                    {
                    kw=(Token)match(input,287,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalPerl.g:2930:3: kw= '&&'
                    {
                    kw=(Token)match(input,288,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30());
                    		

                    }
                    break;
                case 32 :
                    // InternalPerl.g:2936:3: kw= '||'
                    {
                    kw=(Token)match(input,289,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31());
                    		

                    }
                    break;
                case 33 :
                    // InternalPerl.g:2942:3: kw= '//'
                    {
                    kw=(Token)match(input,290,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32());
                    		

                    }
                    break;
                case 34 :
                    // InternalPerl.g:2948:3: kw= '?'
                    {
                    kw=(Token)match(input,291,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33());
                    		

                    }
                    break;
                case 35 :
                    // InternalPerl.g:2954:3: kw= ':'
                    {
                    kw=(Token)match(input,292,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getColonKeyword_34());
                    		

                    }
                    break;
                case 36 :
                    // InternalPerl.g:2960:3: kw= '**='
                    {
                    kw=(Token)match(input,293,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35());
                    		

                    }
                    break;
                case 37 :
                    // InternalPerl.g:2966:3: kw= '+='
                    {
                    kw=(Token)match(input,294,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36());
                    		

                    }
                    break;
                case 38 :
                    // InternalPerl.g:2972:3: kw= '-='
                    {
                    kw=(Token)match(input,295,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37());
                    		

                    }
                    break;
                case 39 :
                    // InternalPerl.g:2978:3: kw= '.='
                    {
                    kw=(Token)match(input,296,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38());
                    		

                    }
                    break;
                case 40 :
                    // InternalPerl.g:2984:3: kw= '*='
                    {
                    kw=(Token)match(input,297,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39());
                    		

                    }
                    break;
                case 41 :
                    // InternalPerl.g:2990:3: kw= '/='
                    {
                    kw=(Token)match(input,298,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40());
                    		

                    }
                    break;
                case 42 :
                    // InternalPerl.g:2996:3: kw= '%='
                    {
                    kw=(Token)match(input,299,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41());
                    		

                    }
                    break;
                case 43 :
                    // InternalPerl.g:3002:3: kw= 'x='
                    {
                    kw=(Token)match(input,300,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getXKeyword_42());
                    		

                    }
                    break;
                case 44 :
                    // InternalPerl.g:3008:3: kw= '&='
                    {
                    kw=(Token)match(input,301,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43());
                    		

                    }
                    break;
                case 45 :
                    // InternalPerl.g:3014:3: kw= '|='
                    {
                    kw=(Token)match(input,302,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44());
                    		

                    }
                    break;
                case 46 :
                    // InternalPerl.g:3020:3: kw= '^='
                    {
                    kw=(Token)match(input,303,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45());
                    		

                    }
                    break;
                case 47 :
                    // InternalPerl.g:3026:3: kw= '<<='
                    {
                    kw=(Token)match(input,304,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46());
                    		

                    }
                    break;
                case 48 :
                    // InternalPerl.g:3032:3: kw= '>>='
                    {
                    kw=(Token)match(input,305,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47());
                    		

                    }
                    break;
                case 49 :
                    // InternalPerl.g:3038:3: kw= '&&='
                    {
                    kw=(Token)match(input,306,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48());
                    		

                    }
                    break;
                case 50 :
                    // InternalPerl.g:3044:3: kw= '||='
                    {
                    kw=(Token)match(input,307,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49());
                    		

                    }
                    break;
                case 51 :
                    // InternalPerl.g:3050:3: kw= '//='
                    {
                    kw=(Token)match(input,308,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50());
                    		

                    }
                    break;
                case 52 :
                    // InternalPerl.g:3056:3: kw= '<'
                    {
                    kw=(Token)match(input,309,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignKeyword_51());
                    		

                    }
                    break;
                case 53 :
                    // InternalPerl.g:3062:3: kw= '>'
                    {
                    kw=(Token)match(input,310,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52());
                    		

                    }
                    break;
                case 54 :
                    // InternalPerl.g:3068:3: kw= '<='
                    {
                    kw=(Token)match(input,311,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53());
                    		

                    }
                    break;
                case 55 :
                    // InternalPerl.g:3074:3: kw= '>='
                    {
                    kw=(Token)match(input,312,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54());
                    		

                    }
                    break;
                case 56 :
                    // InternalPerl.g:3080:3: kw= '<>'
                    {
                    kw=(Token)match(input,313,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55());
                    		

                    }
                    break;
                case 57 :
                    // InternalPerl.g:3086:3: kw= '=>'
                    {
                    kw=(Token)match(input,314,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56());
                    		

                    }
                    break;
                case 58 :
                    // InternalPerl.g:3092:3: kw= '->'
                    {
                    kw=(Token)match(input,315,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57());
                    		

                    }
                    break;
                case 59 :
                    // InternalPerl.g:3098:3: kw= 'and'
                    {
                    kw=(Token)match(input,316,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getAndKeyword_58());
                    		

                    }
                    break;
                case 60 :
                    // InternalPerl.g:3104:3: kw= 'or'
                    {
                    kw=(Token)match(input,317,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getOrKeyword_59());
                    		

                    }
                    break;
                case 61 :
                    // InternalPerl.g:3110:3: kw= 'xor'
                    {
                    kw=(Token)match(input,318,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getXorKeyword_60());
                    		

                    }
                    break;
                case 62 :
                    // InternalPerl.g:3116:3: kw= 'not'
                    {
                    kw=(Token)match(input,319,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getNotKeyword_61());
                    		

                    }
                    break;
                case 63 :
                    // InternalPerl.g:3122:3: kw= 'eq'
                    {
                    kw=(Token)match(input,320,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getEqKeyword_62());
                    		

                    }
                    break;
                case 64 :
                    // InternalPerl.g:3128:3: kw= 'ne'
                    {
                    kw=(Token)match(input,321,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getNeKeyword_63());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleFileTestOperator"
    // InternalPerl.g:3137:1: entryRuleFileTestOperator returns [String current=null] : iv_ruleFileTestOperator= ruleFileTestOperator EOF ;
    public final String entryRuleFileTestOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFileTestOperator = null;


        try {
            // InternalPerl.g:3137:56: (iv_ruleFileTestOperator= ruleFileTestOperator EOF )
            // InternalPerl.g:3138:2: iv_ruleFileTestOperator= ruleFileTestOperator EOF
            {
             newCompositeNode(grammarAccess.getFileTestOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFileTestOperator=ruleFileTestOperator();

            state._fsp--;

             current =iv_ruleFileTestOperator.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFileTestOperator"


    // $ANTLR start "ruleFileTestOperator"
    // InternalPerl.g:3144:1: ruleFileTestOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-r' | kw= '-w' | kw= '-x' | kw= '-o' | kw= '-R' | kw= '-W' | kw= '-X' | kw= '-O' | kw= '-e' | kw= '-z' | kw= '-s' | kw= '-f' | kw= '-d' | kw= '-l' | kw= '-p' | kw= '-S' | kw= '-b' | kw= '-c' | kw= '-t' | kw= '-u' | kw= '-g' | kw= '-k' | kw= '-T' | kw= '-B' | kw= '-M' | kw= '-A' | kw= '-C' ) ;
    public final AntlrDatatypeRuleToken ruleFileTestOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:3150:2: ( (kw= '-r' | kw= '-w' | kw= '-x' | kw= '-o' | kw= '-R' | kw= '-W' | kw= '-X' | kw= '-O' | kw= '-e' | kw= '-z' | kw= '-s' | kw= '-f' | kw= '-d' | kw= '-l' | kw= '-p' | kw= '-S' | kw= '-b' | kw= '-c' | kw= '-t' | kw= '-u' | kw= '-g' | kw= '-k' | kw= '-T' | kw= '-B' | kw= '-M' | kw= '-A' | kw= '-C' ) )
            // InternalPerl.g:3151:2: (kw= '-r' | kw= '-w' | kw= '-x' | kw= '-o' | kw= '-R' | kw= '-W' | kw= '-X' | kw= '-O' | kw= '-e' | kw= '-z' | kw= '-s' | kw= '-f' | kw= '-d' | kw= '-l' | kw= '-p' | kw= '-S' | kw= '-b' | kw= '-c' | kw= '-t' | kw= '-u' | kw= '-g' | kw= '-k' | kw= '-T' | kw= '-B' | kw= '-M' | kw= '-A' | kw= '-C' )
            {
            // InternalPerl.g:3151:2: (kw= '-r' | kw= '-w' | kw= '-x' | kw= '-o' | kw= '-R' | kw= '-W' | kw= '-X' | kw= '-O' | kw= '-e' | kw= '-z' | kw= '-s' | kw= '-f' | kw= '-d' | kw= '-l' | kw= '-p' | kw= '-S' | kw= '-b' | kw= '-c' | kw= '-t' | kw= '-u' | kw= '-g' | kw= '-k' | kw= '-T' | kw= '-B' | kw= '-M' | kw= '-A' | kw= '-C' )
            int alt20=27;
            switch ( input.LA(1) ) {
            case 322:
                {
                alt20=1;
                }
                break;
            case 323:
                {
                alt20=2;
                }
                break;
            case 324:
                {
                alt20=3;
                }
                break;
            case 325:
                {
                alt20=4;
                }
                break;
            case 326:
                {
                alt20=5;
                }
                break;
            case 327:
                {
                alt20=6;
                }
                break;
            case 328:
                {
                alt20=7;
                }
                break;
            case 329:
                {
                alt20=8;
                }
                break;
            case 330:
                {
                alt20=9;
                }
                break;
            case 331:
                {
                alt20=10;
                }
                break;
            case 332:
                {
                alt20=11;
                }
                break;
            case 333:
                {
                alt20=12;
                }
                break;
            case 334:
                {
                alt20=13;
                }
                break;
            case 335:
                {
                alt20=14;
                }
                break;
            case 336:
                {
                alt20=15;
                }
                break;
            case 337:
                {
                alt20=16;
                }
                break;
            case 338:
                {
                alt20=17;
                }
                break;
            case 339:
                {
                alt20=18;
                }
                break;
            case 340:
                {
                alt20=19;
                }
                break;
            case 341:
                {
                alt20=20;
                }
                break;
            case 342:
                {
                alt20=21;
                }
                break;
            case 343:
                {
                alt20=22;
                }
                break;
            case 344:
                {
                alt20=23;
                }
                break;
            case 345:
                {
                alt20=24;
                }
                break;
            case 346:
                {
                alt20=25;
                }
                break;
            case 347:
                {
                alt20=26;
                }
                break;
            case 348:
                {
                alt20=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalPerl.g:3152:3: kw= '-r'
                    {
                    kw=(Token)match(input,322,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getRKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:3158:3: kw= '-w'
                    {
                    kw=(Token)match(input,323,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getWKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalPerl.g:3164:3: kw= '-x'
                    {
                    kw=(Token)match(input,324,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getXKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalPerl.g:3170:3: kw= '-o'
                    {
                    kw=(Token)match(input,325,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getOKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalPerl.g:3176:3: kw= '-R'
                    {
                    kw=(Token)match(input,326,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getRKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalPerl.g:3182:3: kw= '-W'
                    {
                    kw=(Token)match(input,327,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getWKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalPerl.g:3188:3: kw= '-X'
                    {
                    kw=(Token)match(input,328,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getXKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalPerl.g:3194:3: kw= '-O'
                    {
                    kw=(Token)match(input,329,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getOKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalPerl.g:3200:3: kw= '-e'
                    {
                    kw=(Token)match(input,330,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getEKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalPerl.g:3206:3: kw= '-z'
                    {
                    kw=(Token)match(input,331,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getZKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalPerl.g:3212:3: kw= '-s'
                    {
                    kw=(Token)match(input,332,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getSKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalPerl.g:3218:3: kw= '-f'
                    {
                    kw=(Token)match(input,333,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getFKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalPerl.g:3224:3: kw= '-d'
                    {
                    kw=(Token)match(input,334,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getDKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalPerl.g:3230:3: kw= '-l'
                    {
                    kw=(Token)match(input,335,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getLKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalPerl.g:3236:3: kw= '-p'
                    {
                    kw=(Token)match(input,336,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getPKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalPerl.g:3242:3: kw= '-S'
                    {
                    kw=(Token)match(input,337,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getSKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalPerl.g:3248:3: kw= '-b'
                    {
                    kw=(Token)match(input,338,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getBKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalPerl.g:3254:3: kw= '-c'
                    {
                    kw=(Token)match(input,339,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getCKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalPerl.g:3260:3: kw= '-t'
                    {
                    kw=(Token)match(input,340,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getTKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalPerl.g:3266:3: kw= '-u'
                    {
                    kw=(Token)match(input,341,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getUKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalPerl.g:3272:3: kw= '-g'
                    {
                    kw=(Token)match(input,342,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getGKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalPerl.g:3278:3: kw= '-k'
                    {
                    kw=(Token)match(input,343,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getKKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalPerl.g:3284:3: kw= '-T'
                    {
                    kw=(Token)match(input,344,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getTKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalPerl.g:3290:3: kw= '-B'
                    {
                    kw=(Token)match(input,345,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getBKeyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalPerl.g:3296:3: kw= '-M'
                    {
                    kw=(Token)match(input,346,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getMKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalPerl.g:3302:3: kw= '-A'
                    {
                    kw=(Token)match(input,347,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getAKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalPerl.g:3308:3: kw= '-C'
                    {
                    kw=(Token)match(input,348,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getCKeyword_26());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFileTestOperator"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFFEA3E03FFFC2L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFBFFFFFFL,0x000000001FFFFFFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000007042L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000BF0000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000003F0000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000005E0000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000001F010000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});

}