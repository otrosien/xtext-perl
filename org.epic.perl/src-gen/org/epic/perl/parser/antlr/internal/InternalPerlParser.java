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
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalPerlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_VERSION", "RULE_POD", "RULE_SYMBOL", "RULE_DATA", "RULE_END", "RULE_STRING", "RULE_INTERPOLATE", "RULE_LITERAL", "RULE_BACKTICK_STRING", "RULE_WORDS_QUOTE_LIKE", "RULE_COMMAND_QUOTE_LIKE", "RULE_REGEX_QUOTE", "RULE_READLINE_QUOTE", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_ANY_OTHER", "RULE_SL_COMMENT", "RULE_WS", "';'", "'package'", "'abs'", "'accept'", "'alarm'", "'atan2'", "'bind'", "'binmode'", "'bless'", "'break'", "'caller'", "'chdir'", "'chmod'", "'chomp'", "'chop'", "'chown'", "'chr'", "'chroot'", "'close'", "'closedir'", "'connect'", "'continue'", "'cos'", "'crypt'", "'dbmclose'", "'dbmopen'", "'default'", "'defined'", "'delete'", "'die'", "'do'", "'dump'", "'each'", "'else'", "'elsif'", "'endgrent'", "'endhostent'", "'endnetent'", "'endprotoent'", "'endpwent'", "'endservent'", "'eof'", "'eval'", "'evalbytes'", "'exec'", "'exists'", "'exit'", "'exp'", "'fc'", "'fcntl'", "'fileno'", "'flock'", "'for'", "'foreach'", "'fork'", "'format'", "'formline'", "'getc'", "'getgrent'", "'getgrgid'", "'getgrnam'", "'gethostbyaddr'", "'gethostbyname'", "'gethostent'", "'getlogin'", "'getnetbyaddr'", "'getnetbyname'", "'getnetent'", "'getpeername'", "'getpgrp'", "'getppid'", "'getpriority'", "'getprotobyname'", "'getprotobynumber'", "'getprotoent'", "'getpwent'", "'getpwnam'", "'getpwuid'", "'getservbyname'", "'getservbyport'", "'getservent'", "'getsockname'", "'getsockopt'", "'given'", "'glob'", "'gmtime'", "'goto'", "'grep'", "'hex'", "'if'", "'index'", "'int'", "'ioctl'", "'join'", "'keys'", "'kill'", "'last'", "'lc'", "'lcfirst'", "'length'", "'link'", "'listen'", "'local'", "'localtime'", "'lock'", "'log'", "'lstat'", "'map'", "'mkdir'", "'msgctl'", "'msgget'", "'msgrcv'", "'msgsnd'", "'my'", "'next'", "'no'", "'oct'", "'open'", "'opendir'", "'ord'", "'our'", "'pack'", "'pipe'", "'pop'", "'pos'", "'print'", "'printf'", "'prototype'", "'push'", "'quotemeta'", "'rand'", "'read'", "'readdir'", "'readline'", "'readlink'", "'readpipe'", "'recv'", "'redo'", "'ref'", "'rename'", "'require'", "'reset'", "'return'", "'reverse'", "'rewinddir'", "'rindex'", "'rmdir'", "'say'", "'scalar'", "'seek'", "'seekdir'", "'select'", "'semctl'", "'semget'", "'semop'", "'send'", "'setgrent'", "'sethostent'", "'setnetent'", "'setpgrp'", "'setpriority'", "'setprotoent'", "'setpwent'", "'setservent'", "'setsockopt'", "'shift'", "'shmctl'", "'shmget'", "'shmread'", "'shmwrite'", "'shutdown'", "'sin'", "'sleep'", "'socket'", "'socketpair'", "'sort'", "'splice'", "'split'", "'sprintf'", "'sqrt'", "'srand'", "'stat'", "'state'", "'study'", "'sub'", "'substr'", "'symlink'", "'syscall'", "'sysopen'", "'sysread'", "'sysseek'", "'system'", "'syswrite'", "'tell'", "'telldir'", "'tie'", "'tied'", "'time'", "'times'", "'tr'", "'truncate'", "'uc'", "'ucfirst'", "'umask'", "'undef'", "'unless'", "'unlink'", "'unpack'", "'unshift'", "'untie'", "'until'", "'use'", "'utime'", "'values'", "'vec'", "'wait'", "'waitpid'", "'wantarray'", "'warn'", "'when'", "'while'", "'write'", "'y'", "'++'", "'--'", "'**'", "'!'", "'~'", "'+'", "'-'", "'=~'", "'!~'", "'*'", "'/'", "'%'", "'x'", "'<<'", "'>>'", "'lt'", "'gt'", "'le'", "'ge'", "'cmp'", "'~~'", "'=='", "'!='", "'<=>'", "'.'", "'..'", "'...'", "','", "'&'", "'|'", "'^'", "'&&'", "'||'", "'//'", "'?'", "':'", "'**='", "'+='", "'-='", "'.='", "'*='", "'/='", "'%='", "'x='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'&&='", "'||='", "'//='", "'<'", "'>'", "'<='", "'>='", "'<>'", "'=>'", "'->'", "'and'", "'or'", "'xor'", "'not'", "'eq'", "'ne'", "'-r'", "'-w'", "'-x'", "'-o'", "'-R'", "'-W'", "'-X'", "'-O'", "'-e'", "'-z'", "'-s'", "'-f'", "'-d'", "'-l'", "'-p'", "'-S'", "'-b'", "'-c'", "'-t'", "'-u'", "'-g'", "'-k'", "'-T'", "'-B'", "'-M'", "'-A'", "'-C'"
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
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__252=252;
    public static final int T__130=130;
    public static final int T__251=251;
    public static final int RULE_DATA=8;
    public static final int RULE_INT=20;
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
    public static final int RULE_POD=6;
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
    public static final int RULE_END=9;
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
    public static final int RULE_HEX=18;
    public static final int RULE_VERSION=5;
    public static final int RULE_LITERAL=12;
    public static final int RULE_BIN=19;
    public static final int RULE_INTERPOLATE=11;
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
    public static final int RULE_STRING=10;
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
    public static final int RULE_BACKTICK_STRING=13;
    public static final int T__196=196;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=21;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int RULE_SYMBOL=7;
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
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPerlDocumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePerlDocument=rulePerlDocument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePerlDocument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPerlDocumentAccess().getPerlDocumentAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:86:3: ( (lv_elements_1_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_VERSION && LA1_0<=RULE_INT)||(LA1_0>=24 && LA1_0<=270)||(LA1_0>=272 && LA1_0<=338)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPerl.g:87:4: (lv_elements_1_0= ruleElement )
            	    {
            	    // InternalPerl.g:87:4: (lv_elements_1_0= ruleElement )
            	    // InternalPerl.g:88:5: lv_elements_1_0= ruleElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getPerlDocumentAccess().getElementsElementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_elements_1_0=ruleElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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

            if ( (LA2_0==25) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_ID) ) {
                    alt2=1;
                }
                else if ( (LA2_1==EOF||(LA2_1>=RULE_VERSION && LA2_1<=RULE_INT)||(LA2_1>=24 && LA2_1<=270)||(LA2_1>=272 && LA2_1<=338)) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==24) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=RULE_VERSION && LA2_0<=RULE_INT)||(LA2_0>=26 && LA2_0<=270)||(LA2_0>=272 && LA2_0<=338)) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalPerl.g:124:3: this_Node_0= ruleNode
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementAccess().getNodeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Node_0=ruleNode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Node_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:133:3: this_Token_1= ruleToken
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementAccess().getTokenParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Token_1=ruleToken();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Token_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:152:1: ruleNode returns [EObject current=null] : (this_StatementNode_0= ruleStatementNode | ruleStructureNode ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        EObject this_StatementNode_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:158:2: ( (this_StatementNode_0= ruleStatementNode | ruleStructureNode ) )
            // InternalPerl.g:159:2: (this_StatementNode_0= ruleStatementNode | ruleStructureNode )
            {
            // InternalPerl.g:159:2: (this_StatementNode_0= ruleStatementNode | ruleStructureNode )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==25) ) {
                alt3=1;
            }
            else if ( (LA3_0==24) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalPerl.g:160:3: this_StatementNode_0= ruleStatementNode
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNodeAccess().getStatementNodeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StatementNode_0=ruleStatementNode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StatementNode_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:169:3: ruleStructureNode
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNodeAccess().getStructureNodeParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleStructureNode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleStatementNode"
    // InternalPerl.g:180:1: entryRuleStatementNode returns [EObject current=null] : iv_ruleStatementNode= ruleStatementNode EOF ;
    public final EObject entryRuleStatementNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementNode = null;


        try {
            // InternalPerl.g:180:54: (iv_ruleStatementNode= ruleStatementNode EOF )
            // InternalPerl.g:181:2: iv_ruleStatementNode= ruleStatementNode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatementNode=ruleStatementNode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatementNode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:187:1: ruleStatementNode returns [EObject current=null] : this_PackageStatement_0= rulePackageStatement ;
    public final EObject ruleStatementNode() throws RecognitionException {
        EObject current = null;

        EObject this_PackageStatement_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:193:2: (this_PackageStatement_0= rulePackageStatement )
            // InternalPerl.g:194:2: this_PackageStatement_0= rulePackageStatement
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getStatementNodeAccess().getPackageStatementParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_PackageStatement_0=rulePackageStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_PackageStatement_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleStatementNode"


    // $ANTLR start "entryRuleStructureNode"
    // InternalPerl.g:205:1: entryRuleStructureNode returns [String current=null] : iv_ruleStructureNode= ruleStructureNode EOF ;
    public final String entryRuleStructureNode() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStructureNode = null;


        try {
            // InternalPerl.g:205:53: (iv_ruleStructureNode= ruleStructureNode EOF )
            // InternalPerl.g:206:2: iv_ruleStructureNode= ruleStructureNode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStructureNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStructureNode=ruleStructureNode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStructureNode.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:212:1: ruleStructureNode returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= ';' ;
    public final AntlrDatatypeRuleToken ruleStructureNode() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:218:2: (kw= ';' )
            // InternalPerl.g:219:2: kw= ';'
            {
            kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getStructureNodeAccess().getSemicolonKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleStructureNode"


    // $ANTLR start "entryRulePackageStatement"
    // InternalPerl.g:227:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // InternalPerl.g:227:57: (iv_rulePackageStatement= rulePackageStatement EOF )
            // InternalPerl.g:228:2: iv_rulePackageStatement= rulePackageStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackageStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePackageStatement=rulePackageStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackageStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:234:1: rulePackageStatement returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( RULE_VERSION ) ) )=> ( (lv_version_2_0= RULE_VERSION ) ) )? ) ;
    public final EObject rulePackageStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_version_2_0=null;


        	enterRule();

        try {
            // InternalPerl.g:240:2: ( (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( RULE_VERSION ) ) )=> ( (lv_version_2_0= RULE_VERSION ) ) )? ) )
            // InternalPerl.g:241:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( RULE_VERSION ) ) )=> ( (lv_version_2_0= RULE_VERSION ) ) )? )
            {
            // InternalPerl.g:241:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( RULE_VERSION ) ) )=> ( (lv_version_2_0= RULE_VERSION ) ) )? )
            // InternalPerl.g:242:3: otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( RULE_VERSION ) ) )=> ( (lv_version_2_0= RULE_VERSION ) ) )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPackageStatementAccess().getPackageKeyword_0());
              		
            }
            // InternalPerl.g:246:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPerl.g:247:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPerl.g:247:4: (lv_name_1_0= RULE_ID )
            // InternalPerl.g:248:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPackageStatementAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPackageStatementRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.epic.perl.Perl.ID");
              				
            }

            }


            }

            // InternalPerl.g:264:3: ( ( ( ( RULE_VERSION ) ) )=> ( (lv_version_2_0= RULE_VERSION ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_VERSION) ) {
                int LA4_1 = input.LA(2);

                if ( (synpred1_InternalPerl()) ) {
                    alt4=1;
                }
            }
            switch (alt4) {
                case 1 :
                    // InternalPerl.g:265:4: ( ( ( RULE_VERSION ) ) )=> ( (lv_version_2_0= RULE_VERSION ) )
                    {
                    // InternalPerl.g:271:4: ( (lv_version_2_0= RULE_VERSION ) )
                    // InternalPerl.g:272:5: (lv_version_2_0= RULE_VERSION )
                    {
                    // InternalPerl.g:272:5: (lv_version_2_0= RULE_VERSION )
                    // InternalPerl.g:273:6: lv_version_2_0= RULE_VERSION
                    {
                    lv_version_2_0=(Token)match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_version_2_0, grammarAccess.getPackageStatementAccess().getVersionVERSIONTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPackageStatementRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"version",
                      							lv_version_2_0,
                      							"org.epic.perl.Perl.VERSION");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "rulePackageStatement"


    // $ANTLR start "entryRuleToken"
    // InternalPerl.g:294:1: entryRuleToken returns [EObject current=null] : iv_ruleToken= ruleToken EOF ;
    public final EObject entryRuleToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleToken = null;


        try {
            // InternalPerl.g:294:46: (iv_ruleToken= ruleToken EOF )
            // InternalPerl.g:295:2: iv_ruleToken= ruleToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokenRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleToken=ruleToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleToken; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:301:1: ruleToken returns [EObject current=null] : ( ( () ( (lv_content_1_0= RULE_POD ) ) ) | ( () ( (lv_content_3_0= ruleNumber ) ) ) | ( () ( (lv_content_5_0= RULE_VERSION ) ) ) | ( () ( (lv_content_7_0= ruleWord ) ) ) | ( () ( (lv_content_9_0= RULE_SYMBOL ) ) ) | this_QuoteLikeToken_10= ruleQuoteLikeToken | ( () ( (lv_content_12_0= ruleFileTestOperator ) ) ) | ( () ( (lv_content_14_0= ruleOperator ) ) ) | this_QuoteToken_15= ruleQuoteToken | ( () ( (lv_content_17_0= RULE_DATA ) ) ) | ( () ( (lv_content_19_0= RULE_END ) ) ) ) ;
    public final EObject ruleToken() throws RecognitionException {
        EObject current = null;

        Token lv_content_1_0=null;
        Token lv_content_5_0=null;
        Token lv_content_9_0=null;
        Token lv_content_17_0=null;
        Token lv_content_19_0=null;
        AntlrDatatypeRuleToken lv_content_3_0 = null;

        AntlrDatatypeRuleToken lv_content_7_0 = null;

        EObject this_QuoteLikeToken_10 = null;

        AntlrDatatypeRuleToken lv_content_12_0 = null;

        AntlrDatatypeRuleToken lv_content_14_0 = null;

        EObject this_QuoteToken_15 = null;



        	enterRule();

        try {
            // InternalPerl.g:307:2: ( ( ( () ( (lv_content_1_0= RULE_POD ) ) ) | ( () ( (lv_content_3_0= ruleNumber ) ) ) | ( () ( (lv_content_5_0= RULE_VERSION ) ) ) | ( () ( (lv_content_7_0= ruleWord ) ) ) | ( () ( (lv_content_9_0= RULE_SYMBOL ) ) ) | this_QuoteLikeToken_10= ruleQuoteLikeToken | ( () ( (lv_content_12_0= ruleFileTestOperator ) ) ) | ( () ( (lv_content_14_0= ruleOperator ) ) ) | this_QuoteToken_15= ruleQuoteToken | ( () ( (lv_content_17_0= RULE_DATA ) ) ) | ( () ( (lv_content_19_0= RULE_END ) ) ) ) )
            // InternalPerl.g:308:2: ( ( () ( (lv_content_1_0= RULE_POD ) ) ) | ( () ( (lv_content_3_0= ruleNumber ) ) ) | ( () ( (lv_content_5_0= RULE_VERSION ) ) ) | ( () ( (lv_content_7_0= ruleWord ) ) ) | ( () ( (lv_content_9_0= RULE_SYMBOL ) ) ) | this_QuoteLikeToken_10= ruleQuoteLikeToken | ( () ( (lv_content_12_0= ruleFileTestOperator ) ) ) | ( () ( (lv_content_14_0= ruleOperator ) ) ) | this_QuoteToken_15= ruleQuoteToken | ( () ( (lv_content_17_0= RULE_DATA ) ) ) | ( () ( (lv_content_19_0= RULE_END ) ) ) )
            {
            // InternalPerl.g:308:2: ( ( () ( (lv_content_1_0= RULE_POD ) ) ) | ( () ( (lv_content_3_0= ruleNumber ) ) ) | ( () ( (lv_content_5_0= RULE_VERSION ) ) ) | ( () ( (lv_content_7_0= ruleWord ) ) ) | ( () ( (lv_content_9_0= RULE_SYMBOL ) ) ) | this_QuoteLikeToken_10= ruleQuoteLikeToken | ( () ( (lv_content_12_0= ruleFileTestOperator ) ) ) | ( () ( (lv_content_14_0= ruleOperator ) ) ) | this_QuoteToken_15= ruleQuoteToken | ( () ( (lv_content_17_0= RULE_DATA ) ) ) | ( () ( (lv_content_19_0= RULE_END ) ) ) )
            int alt5=11;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_POD) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_HEX && LA5_0<=RULE_INT)) ) {
                alt5=2;
            }
            else if ( (LA5_0==RULE_VERSION) ) {
                alt5=3;
            }
            else if ( ((LA5_0>=25 && LA5_0<=246)) ) {
                alt5=4;
            }
            else if ( (LA5_0==RULE_SYMBOL) ) {
                alt5=5;
            }
            else if ( ((LA5_0>=RULE_BACKTICK_STRING && LA5_0<=RULE_READLINE_QUOTE)) ) {
                alt5=6;
            }
            else if ( ((LA5_0>=312 && LA5_0<=338)) ) {
                alt5=7;
            }
            else if ( ((LA5_0>=247 && LA5_0<=270)||(LA5_0>=272 && LA5_0<=311)) ) {
                alt5=8;
            }
            else if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_LITERAL)) ) {
                alt5=9;
            }
            else if ( (LA5_0==RULE_DATA) ) {
                alt5=10;
            }
            else if ( (LA5_0==RULE_END) ) {
                alt5=11;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalPerl.g:309:3: ( () ( (lv_content_1_0= RULE_POD ) ) )
                    {
                    // InternalPerl.g:309:3: ( () ( (lv_content_1_0= RULE_POD ) ) )
                    // InternalPerl.g:310:4: () ( (lv_content_1_0= RULE_POD ) )
                    {
                    // InternalPerl.g:310:4: ()
                    // InternalPerl.g:311:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTokenAccess().getPodTokenAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:317:4: ( (lv_content_1_0= RULE_POD ) )
                    // InternalPerl.g:318:5: (lv_content_1_0= RULE_POD )
                    {
                    // InternalPerl.g:318:5: (lv_content_1_0= RULE_POD )
                    // InternalPerl.g:319:6: lv_content_1_0= RULE_POD
                    {
                    lv_content_1_0=(Token)match(input,RULE_POD,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_1_0, grammarAccess.getTokenAccess().getContentPODTerminalRuleCall_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 2 :
                    // InternalPerl.g:337:3: ( () ( (lv_content_3_0= ruleNumber ) ) )
                    {
                    // InternalPerl.g:337:3: ( () ( (lv_content_3_0= ruleNumber ) ) )
                    // InternalPerl.g:338:4: () ( (lv_content_3_0= ruleNumber ) )
                    {
                    // InternalPerl.g:338:4: ()
                    // InternalPerl.g:339:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTokenAccess().getNumberTokenAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:345:4: ( (lv_content_3_0= ruleNumber ) )
                    // InternalPerl.g:346:5: (lv_content_3_0= ruleNumber )
                    {
                    // InternalPerl.g:346:5: (lv_content_3_0= ruleNumber )
                    // InternalPerl.g:347:6: lv_content_3_0= ruleNumber
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTokenAccess().getContentNumberParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_content_3_0=ruleNumber();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTokenRule());
                      						}
                      						set(
                      							current,
                      							"content",
                      							lv_content_3_0,
                      							"org.epic.perl.Perl.Number");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:366:3: ( () ( (lv_content_5_0= RULE_VERSION ) ) )
                    {
                    // InternalPerl.g:366:3: ( () ( (lv_content_5_0= RULE_VERSION ) ) )
                    // InternalPerl.g:367:4: () ( (lv_content_5_0= RULE_VERSION ) )
                    {
                    // InternalPerl.g:367:4: ()
                    // InternalPerl.g:368:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTokenAccess().getVersionTokenAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:374:4: ( (lv_content_5_0= RULE_VERSION ) )
                    // InternalPerl.g:375:5: (lv_content_5_0= RULE_VERSION )
                    {
                    // InternalPerl.g:375:5: (lv_content_5_0= RULE_VERSION )
                    // InternalPerl.g:376:6: lv_content_5_0= RULE_VERSION
                    {
                    lv_content_5_0=(Token)match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_5_0, grammarAccess.getTokenAccess().getContentVERSIONTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTokenRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"content",
                      							lv_content_5_0,
                      							"org.epic.perl.Perl.VERSION");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:394:3: ( () ( (lv_content_7_0= ruleWord ) ) )
                    {
                    // InternalPerl.g:394:3: ( () ( (lv_content_7_0= ruleWord ) ) )
                    // InternalPerl.g:395:4: () ( (lv_content_7_0= ruleWord ) )
                    {
                    // InternalPerl.g:395:4: ()
                    // InternalPerl.g:396:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTokenAccess().getWordTokenAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:402:4: ( (lv_content_7_0= ruleWord ) )
                    // InternalPerl.g:403:5: (lv_content_7_0= ruleWord )
                    {
                    // InternalPerl.g:403:5: (lv_content_7_0= ruleWord )
                    // InternalPerl.g:404:6: lv_content_7_0= ruleWord
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTokenAccess().getContentWordParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_content_7_0=ruleWord();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTokenRule());
                      						}
                      						set(
                      							current,
                      							"content",
                      							lv_content_7_0,
                      							"org.epic.perl.Perl.Word");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:423:3: ( () ( (lv_content_9_0= RULE_SYMBOL ) ) )
                    {
                    // InternalPerl.g:423:3: ( () ( (lv_content_9_0= RULE_SYMBOL ) ) )
                    // InternalPerl.g:424:4: () ( (lv_content_9_0= RULE_SYMBOL ) )
                    {
                    // InternalPerl.g:424:4: ()
                    // InternalPerl.g:425:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTokenAccess().getSymbolTokenAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:431:4: ( (lv_content_9_0= RULE_SYMBOL ) )
                    // InternalPerl.g:432:5: (lv_content_9_0= RULE_SYMBOL )
                    {
                    // InternalPerl.g:432:5: (lv_content_9_0= RULE_SYMBOL )
                    // InternalPerl.g:433:6: lv_content_9_0= RULE_SYMBOL
                    {
                    lv_content_9_0=(Token)match(input,RULE_SYMBOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_9_0, grammarAccess.getTokenAccess().getContentSYMBOLTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTokenRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"content",
                      							lv_content_9_0,
                      							"org.epic.perl.Perl.SYMBOL");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:451:3: this_QuoteLikeToken_10= ruleQuoteLikeToken
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTokenAccess().getQuoteLikeTokenParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_QuoteLikeToken_10=ruleQuoteLikeToken();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_QuoteLikeToken_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalPerl.g:460:3: ( () ( (lv_content_12_0= ruleFileTestOperator ) ) )
                    {
                    // InternalPerl.g:460:3: ( () ( (lv_content_12_0= ruleFileTestOperator ) ) )
                    // InternalPerl.g:461:4: () ( (lv_content_12_0= ruleFileTestOperator ) )
                    {
                    // InternalPerl.g:461:4: ()
                    // InternalPerl.g:462:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTokenAccess().getOperatorTokenAction_6_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:468:4: ( (lv_content_12_0= ruleFileTestOperator ) )
                    // InternalPerl.g:469:5: (lv_content_12_0= ruleFileTestOperator )
                    {
                    // InternalPerl.g:469:5: (lv_content_12_0= ruleFileTestOperator )
                    // InternalPerl.g:470:6: lv_content_12_0= ruleFileTestOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTokenAccess().getContentFileTestOperatorParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_content_12_0=ruleFileTestOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTokenRule());
                      						}
                      						set(
                      							current,
                      							"content",
                      							lv_content_12_0,
                      							"org.epic.perl.Perl.FileTestOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:489:3: ( () ( (lv_content_14_0= ruleOperator ) ) )
                    {
                    // InternalPerl.g:489:3: ( () ( (lv_content_14_0= ruleOperator ) ) )
                    // InternalPerl.g:490:4: () ( (lv_content_14_0= ruleOperator ) )
                    {
                    // InternalPerl.g:490:4: ()
                    // InternalPerl.g:491:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTokenAccess().getOperatorTokenAction_7_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:497:4: ( (lv_content_14_0= ruleOperator ) )
                    // InternalPerl.g:498:5: (lv_content_14_0= ruleOperator )
                    {
                    // InternalPerl.g:498:5: (lv_content_14_0= ruleOperator )
                    // InternalPerl.g:499:6: lv_content_14_0= ruleOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTokenAccess().getContentOperatorParserRuleCall_7_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_content_14_0=ruleOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTokenRule());
                      						}
                      						set(
                      							current,
                      							"content",
                      							lv_content_14_0,
                      							"org.epic.perl.Perl.Operator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:518:3: this_QuoteToken_15= ruleQuoteToken
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTokenAccess().getQuoteTokenParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_QuoteToken_15=ruleQuoteToken();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_QuoteToken_15;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalPerl.g:527:3: ( () ( (lv_content_17_0= RULE_DATA ) ) )
                    {
                    // InternalPerl.g:527:3: ( () ( (lv_content_17_0= RULE_DATA ) ) )
                    // InternalPerl.g:528:4: () ( (lv_content_17_0= RULE_DATA ) )
                    {
                    // InternalPerl.g:528:4: ()
                    // InternalPerl.g:529:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTokenAccess().getDataTokenAction_9_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:535:4: ( (lv_content_17_0= RULE_DATA ) )
                    // InternalPerl.g:536:5: (lv_content_17_0= RULE_DATA )
                    {
                    // InternalPerl.g:536:5: (lv_content_17_0= RULE_DATA )
                    // InternalPerl.g:537:6: lv_content_17_0= RULE_DATA
                    {
                    lv_content_17_0=(Token)match(input,RULE_DATA,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_17_0, grammarAccess.getTokenAccess().getContentDATATerminalRuleCall_9_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTokenRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"content",
                      							lv_content_17_0,
                      							"org.epic.perl.Perl.DATA");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalPerl.g:555:3: ( () ( (lv_content_19_0= RULE_END ) ) )
                    {
                    // InternalPerl.g:555:3: ( () ( (lv_content_19_0= RULE_END ) ) )
                    // InternalPerl.g:556:4: () ( (lv_content_19_0= RULE_END ) )
                    {
                    // InternalPerl.g:556:4: ()
                    // InternalPerl.g:557:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTokenAccess().getEndTokenAction_10_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:563:4: ( (lv_content_19_0= RULE_END ) )
                    // InternalPerl.g:564:5: (lv_content_19_0= RULE_END )
                    {
                    // InternalPerl.g:564:5: (lv_content_19_0= RULE_END )
                    // InternalPerl.g:565:6: lv_content_19_0= RULE_END
                    {
                    lv_content_19_0=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_19_0, grammarAccess.getTokenAccess().getContentENDTerminalRuleCall_10_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTokenRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"content",
                      							lv_content_19_0,
                      							"org.epic.perl.Perl.END");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleToken"


    // $ANTLR start "entryRuleQuoteToken"
    // InternalPerl.g:586:1: entryRuleQuoteToken returns [EObject current=null] : iv_ruleQuoteToken= ruleQuoteToken EOF ;
    public final EObject entryRuleQuoteToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuoteToken = null;


        try {
            // InternalPerl.g:586:51: (iv_ruleQuoteToken= ruleQuoteToken EOF )
            // InternalPerl.g:587:2: iv_ruleQuoteToken= ruleQuoteToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQuoteTokenRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQuoteToken=ruleQuoteToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQuoteToken; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:593:1: ruleQuoteToken returns [EObject current=null] : ( () ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) ) ) ;
    public final EObject ruleQuoteToken() throws RecognitionException {
        EObject current = null;

        Token lv_content_1_1=null;
        Token lv_content_1_2=null;
        Token lv_content_1_3=null;


        	enterRule();

        try {
            // InternalPerl.g:599:2: ( ( () ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) ) ) )
            // InternalPerl.g:600:2: ( () ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) ) )
            {
            // InternalPerl.g:600:2: ( () ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) ) )
            // InternalPerl.g:601:3: () ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) )
            {
            // InternalPerl.g:601:3: ()
            // InternalPerl.g:602:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getQuoteTokenAccess().getQuoteTokenAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:608:3: ( ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) ) )
            // InternalPerl.g:609:4: ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) )
            {
            // InternalPerl.g:609:4: ( (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL ) )
            // InternalPerl.g:610:5: (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL )
            {
            // InternalPerl.g:610:5: (lv_content_1_1= RULE_STRING | lv_content_1_2= RULE_INTERPOLATE | lv_content_1_3= RULE_LITERAL )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt6=1;
                }
                break;
            case RULE_INTERPOLATE:
                {
                alt6=2;
                }
                break;
            case RULE_LITERAL:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalPerl.g:611:6: lv_content_1_1= RULE_STRING
                    {
                    lv_content_1_1=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_1_1, grammarAccess.getQuoteTokenAccess().getContentSTRINGTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getQuoteTokenRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"content",
                      							lv_content_1_1,
                      							"org.epic.perl.Perl.STRING");
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:626:6: lv_content_1_2= RULE_INTERPOLATE
                    {
                    lv_content_1_2=(Token)match(input,RULE_INTERPOLATE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_1_2, grammarAccess.getQuoteTokenAccess().getContentINTERPOLATETerminalRuleCall_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getQuoteTokenRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"content",
                      							lv_content_1_2,
                      							"org.epic.perl.Perl.INTERPOLATE");
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:641:6: lv_content_1_3= RULE_LITERAL
                    {
                    lv_content_1_3=(Token)match(input,RULE_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_1_3, grammarAccess.getQuoteTokenAccess().getContentLITERALTerminalRuleCall_1_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getQuoteTokenRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"content",
                      							lv_content_1_3,
                      							"org.epic.perl.Perl.LITERAL");
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleQuoteToken"


    // $ANTLR start "entryRuleQuoteLikeToken"
    // InternalPerl.g:662:1: entryRuleQuoteLikeToken returns [EObject current=null] : iv_ruleQuoteLikeToken= ruleQuoteLikeToken EOF ;
    public final EObject entryRuleQuoteLikeToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuoteLikeToken = null;


        try {
            // InternalPerl.g:662:55: (iv_ruleQuoteLikeToken= ruleQuoteLikeToken EOF )
            // InternalPerl.g:663:2: iv_ruleQuoteLikeToken= ruleQuoteLikeToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQuoteLikeTokenRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQuoteLikeToken=ruleQuoteLikeToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQuoteLikeToken; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:669:1: ruleQuoteLikeToken returns [EObject current=null] : ( ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) ) | ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) ) | ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) ) | ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) ) | ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) ) ) ;
    public final EObject ruleQuoteLikeToken() throws RecognitionException {
        EObject current = null;

        Token lv_content_1_0=null;
        Token lv_content_3_0=null;
        Token lv_content_5_0=null;
        Token lv_content_7_0=null;
        Token lv_content_9_0=null;


        	enterRule();

        try {
            // InternalPerl.g:675:2: ( ( ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) ) | ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) ) | ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) ) | ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) ) | ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) ) ) )
            // InternalPerl.g:676:2: ( ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) ) | ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) ) | ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) ) | ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) ) | ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) ) )
            {
            // InternalPerl.g:676:2: ( ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) ) | ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) ) | ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) ) | ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) ) | ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case RULE_BACKTICK_STRING:
                {
                alt7=1;
                }
                break;
            case RULE_WORDS_QUOTE_LIKE:
                {
                alt7=2;
                }
                break;
            case RULE_COMMAND_QUOTE_LIKE:
                {
                alt7=3;
                }
                break;
            case RULE_REGEX_QUOTE:
                {
                alt7=4;
                }
                break;
            case RULE_READLINE_QUOTE:
                {
                alt7=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalPerl.g:677:3: ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) )
                    {
                    // InternalPerl.g:677:3: ( () ( (lv_content_1_0= RULE_BACKTICK_STRING ) ) )
                    // InternalPerl.g:678:4: () ( (lv_content_1_0= RULE_BACKTICK_STRING ) )
                    {
                    // InternalPerl.g:678:4: ()
                    // InternalPerl.g:679:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getQuoteLikeTokenAccess().getBacktickQuoteLikeTokenAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:685:4: ( (lv_content_1_0= RULE_BACKTICK_STRING ) )
                    // InternalPerl.g:686:5: (lv_content_1_0= RULE_BACKTICK_STRING )
                    {
                    // InternalPerl.g:686:5: (lv_content_1_0= RULE_BACKTICK_STRING )
                    // InternalPerl.g:687:6: lv_content_1_0= RULE_BACKTICK_STRING
                    {
                    lv_content_1_0=(Token)match(input,RULE_BACKTICK_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_1_0, grammarAccess.getQuoteLikeTokenAccess().getContentBACKTICK_STRINGTerminalRuleCall_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 2 :
                    // InternalPerl.g:705:3: ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) )
                    {
                    // InternalPerl.g:705:3: ( () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) ) )
                    // InternalPerl.g:706:4: () ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) )
                    {
                    // InternalPerl.g:706:4: ()
                    // InternalPerl.g:707:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getQuoteLikeTokenAccess().getWordsQuoteLikeTokenAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:713:4: ( (lv_content_3_0= RULE_WORDS_QUOTE_LIKE ) )
                    // InternalPerl.g:714:5: (lv_content_3_0= RULE_WORDS_QUOTE_LIKE )
                    {
                    // InternalPerl.g:714:5: (lv_content_3_0= RULE_WORDS_QUOTE_LIKE )
                    // InternalPerl.g:715:6: lv_content_3_0= RULE_WORDS_QUOTE_LIKE
                    {
                    lv_content_3_0=(Token)match(input,RULE_WORDS_QUOTE_LIKE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_3_0, grammarAccess.getQuoteLikeTokenAccess().getContentWORDS_QUOTE_LIKETerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 3 :
                    // InternalPerl.g:733:3: ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) )
                    {
                    // InternalPerl.g:733:3: ( () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) ) )
                    // InternalPerl.g:734:4: () ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) )
                    {
                    // InternalPerl.g:734:4: ()
                    // InternalPerl.g:735:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getQuoteLikeTokenAccess().getCommandQuoteLikeTokenAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:741:4: ( (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE ) )
                    // InternalPerl.g:742:5: (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE )
                    {
                    // InternalPerl.g:742:5: (lv_content_5_0= RULE_COMMAND_QUOTE_LIKE )
                    // InternalPerl.g:743:6: lv_content_5_0= RULE_COMMAND_QUOTE_LIKE
                    {
                    lv_content_5_0=(Token)match(input,RULE_COMMAND_QUOTE_LIKE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_5_0, grammarAccess.getQuoteLikeTokenAccess().getContentCOMMAND_QUOTE_LIKETerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 4 :
                    // InternalPerl.g:761:3: ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) )
                    {
                    // InternalPerl.g:761:3: ( () ( (lv_content_7_0= RULE_REGEX_QUOTE ) ) )
                    // InternalPerl.g:762:4: () ( (lv_content_7_0= RULE_REGEX_QUOTE ) )
                    {
                    // InternalPerl.g:762:4: ()
                    // InternalPerl.g:763:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getQuoteLikeTokenAccess().getRegexpQuoteLikeTokenAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:769:4: ( (lv_content_7_0= RULE_REGEX_QUOTE ) )
                    // InternalPerl.g:770:5: (lv_content_7_0= RULE_REGEX_QUOTE )
                    {
                    // InternalPerl.g:770:5: (lv_content_7_0= RULE_REGEX_QUOTE )
                    // InternalPerl.g:771:6: lv_content_7_0= RULE_REGEX_QUOTE
                    {
                    lv_content_7_0=(Token)match(input,RULE_REGEX_QUOTE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_7_0, grammarAccess.getQuoteLikeTokenAccess().getContentREGEX_QUOTETerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 5 :
                    // InternalPerl.g:789:3: ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) )
                    {
                    // InternalPerl.g:789:3: ( () ( (lv_content_9_0= RULE_READLINE_QUOTE ) ) )
                    // InternalPerl.g:790:4: () ( (lv_content_9_0= RULE_READLINE_QUOTE ) )
                    {
                    // InternalPerl.g:790:4: ()
                    // InternalPerl.g:791:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getQuoteLikeTokenAccess().getReadLineQuoteLikeTokenAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:797:4: ( (lv_content_9_0= RULE_READLINE_QUOTE ) )
                    // InternalPerl.g:798:5: (lv_content_9_0= RULE_READLINE_QUOTE )
                    {
                    // InternalPerl.g:798:5: (lv_content_9_0= RULE_READLINE_QUOTE )
                    // InternalPerl.g:799:6: lv_content_9_0= RULE_READLINE_QUOTE
                    {
                    lv_content_9_0=(Token)match(input,RULE_READLINE_QUOTE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_content_9_0, grammarAccess.getQuoteLikeTokenAccess().getContentREADLINE_QUOTETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

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


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleQuoteLikeToken"


    // $ANTLR start "entryRuleWord"
    // InternalPerl.g:820:1: entryRuleWord returns [String current=null] : iv_ruleWord= ruleWord EOF ;
    public final String entryRuleWord() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWord = null;


        try {
            // InternalPerl.g:820:44: (iv_ruleWord= ruleWord EOF )
            // InternalPerl.g:821:2: iv_ruleWord= ruleWord EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWordRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWord=ruleWord();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWord.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:827:1: ruleWord returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Keyword_0= ruleKeyword ;
    public final AntlrDatatypeRuleToken ruleWord() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Keyword_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:833:2: (this_Keyword_0= ruleKeyword )
            // InternalPerl.g:834:2: this_Keyword_0= ruleKeyword
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getWordAccess().getKeywordParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_Keyword_0=ruleKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_Keyword_0);
              	
            }
            if ( state.backtracking==0 ) {

              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleWord"


    // $ANTLR start "entryRuleKeyword"
    // InternalPerl.g:847:1: entryRuleKeyword returns [String current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final String entryRuleKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeyword = null;


        try {
            // InternalPerl.g:847:47: (iv_ruleKeyword= ruleKeyword EOF )
            // InternalPerl.g:848:2: iv_ruleKeyword= ruleKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeywordRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyword.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:854:1: ruleKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abs' | kw= 'accept' | kw= 'alarm' | kw= 'atan2' | kw= 'bind' | kw= 'binmode' | kw= 'bless' | kw= 'break' | kw= 'caller' | kw= 'chdir' | kw= 'chmod' | kw= 'chomp' | kw= 'chop' | kw= 'chown' | kw= 'chr' | kw= 'chroot' | kw= 'close' | kw= 'closedir' | kw= 'connect' | kw= 'continue' | kw= 'cos' | kw= 'crypt' | kw= 'dbmclose' | kw= 'dbmopen' | kw= 'default' | kw= 'defined' | kw= 'delete' | kw= 'die' | kw= 'do' | kw= 'dump' | kw= 'each' | kw= 'else' | kw= 'elsif' | kw= 'endgrent' | kw= 'endhostent' | kw= 'endnetent' | kw= 'endprotoent' | kw= 'endpwent' | kw= 'endservent' | kw= 'eof' | kw= 'eval' | kw= 'evalbytes' | kw= 'exec' | kw= 'exists' | kw= 'exit' | kw= 'exp' | kw= 'fc' | kw= 'fcntl' | kw= 'fileno' | kw= 'flock' | kw= 'for' | kw= 'foreach' | kw= 'fork' | kw= 'format' | kw= 'formline' | kw= 'getc' | kw= 'getgrent' | kw= 'getgrgid' | kw= 'getgrnam' | kw= 'gethostbyaddr' | kw= 'gethostbyname' | kw= 'gethostent' | kw= 'getlogin' | kw= 'getnetbyaddr' | kw= 'getnetbyname' | kw= 'getnetent' | kw= 'getpeername' | kw= 'getpgrp' | kw= 'getppid' | kw= 'getpriority' | kw= 'getprotobyname' | kw= 'getprotobynumber' | kw= 'getprotoent' | kw= 'getpwent' | kw= 'getpwnam' | kw= 'getpwuid' | kw= 'getservbyname' | kw= 'getservbyport' | kw= 'getservent' | kw= 'getsockname' | kw= 'getsockopt' | kw= 'given' | kw= 'glob' | kw= 'gmtime' | kw= 'goto' | kw= 'grep' | kw= 'hex' | kw= 'if' | kw= 'index' | kw= 'int' | kw= 'ioctl' | kw= 'join' | kw= 'keys' | kw= 'kill' | kw= 'last' | kw= 'lc' | kw= 'lcfirst' | kw= 'length' | kw= 'link' | kw= 'listen' | kw= 'local' | kw= 'localtime' | kw= 'lock' | kw= 'log' | kw= 'lstat' | kw= 'map' | kw= 'mkdir' | kw= 'msgctl' | kw= 'msgget' | kw= 'msgrcv' | kw= 'msgsnd' | kw= 'my' | kw= 'next' | kw= 'no' | kw= 'oct' | kw= 'open' | kw= 'opendir' | kw= 'ord' | kw= 'our' | kw= 'pack' | kw= 'package' | kw= 'pipe' | kw= 'pop' | kw= 'pos' | kw= 'print' | kw= 'printf' | kw= 'prototype' | kw= 'push' | kw= 'quotemeta' | kw= 'rand' | kw= 'read' | kw= 'readdir' | kw= 'readline' | kw= 'readlink' | kw= 'readpipe' | kw= 'recv' | kw= 'redo' | kw= 'ref' | kw= 'rename' | kw= 'require' | kw= 'reset' | kw= 'return' | kw= 'reverse' | kw= 'rewinddir' | kw= 'rindex' | kw= 'rmdir' | kw= 'say' | kw= 'scalar' | kw= 'seek' | kw= 'seekdir' | kw= 'select' | kw= 'semctl' | kw= 'semget' | kw= 'semop' | kw= 'send' | kw= 'setgrent' | kw= 'sethostent' | kw= 'setnetent' | kw= 'setpgrp' | kw= 'setpriority' | kw= 'setprotoent' | kw= 'setpwent' | kw= 'setservent' | kw= 'setsockopt' | kw= 'shift' | kw= 'shmctl' | kw= 'shmget' | kw= 'shmread' | kw= 'shmwrite' | kw= 'shutdown' | kw= 'sin' | kw= 'sleep' | kw= 'socket' | kw= 'socketpair' | kw= 'sort' | kw= 'splice' | kw= 'split' | kw= 'sprintf' | kw= 'sqrt' | kw= 'srand' | kw= 'stat' | kw= 'state' | kw= 'study' | kw= 'sub' | kw= 'substr' | kw= 'symlink' | kw= 'syscall' | kw= 'sysopen' | kw= 'sysread' | kw= 'sysseek' | kw= 'system' | kw= 'syswrite' | kw= 'tell' | kw= 'telldir' | kw= 'tie' | kw= 'tied' | kw= 'time' | kw= 'times' | kw= 'tr' | kw= 'truncate' | kw= 'uc' | kw= 'ucfirst' | kw= 'umask' | kw= 'undef' | kw= 'unless' | kw= 'unlink' | kw= 'unpack' | kw= 'unshift' | kw= 'untie' | kw= 'until' | kw= 'use' | kw= 'utime' | kw= 'values' | kw= 'vec' | kw= 'wait' | kw= 'waitpid' | kw= 'wantarray' | kw= 'warn' | kw= 'when' | kw= 'while' | kw= 'write' | kw= 'y' ) ;
    public final AntlrDatatypeRuleToken ruleKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:860:2: ( (kw= 'abs' | kw= 'accept' | kw= 'alarm' | kw= 'atan2' | kw= 'bind' | kw= 'binmode' | kw= 'bless' | kw= 'break' | kw= 'caller' | kw= 'chdir' | kw= 'chmod' | kw= 'chomp' | kw= 'chop' | kw= 'chown' | kw= 'chr' | kw= 'chroot' | kw= 'close' | kw= 'closedir' | kw= 'connect' | kw= 'continue' | kw= 'cos' | kw= 'crypt' | kw= 'dbmclose' | kw= 'dbmopen' | kw= 'default' | kw= 'defined' | kw= 'delete' | kw= 'die' | kw= 'do' | kw= 'dump' | kw= 'each' | kw= 'else' | kw= 'elsif' | kw= 'endgrent' | kw= 'endhostent' | kw= 'endnetent' | kw= 'endprotoent' | kw= 'endpwent' | kw= 'endservent' | kw= 'eof' | kw= 'eval' | kw= 'evalbytes' | kw= 'exec' | kw= 'exists' | kw= 'exit' | kw= 'exp' | kw= 'fc' | kw= 'fcntl' | kw= 'fileno' | kw= 'flock' | kw= 'for' | kw= 'foreach' | kw= 'fork' | kw= 'format' | kw= 'formline' | kw= 'getc' | kw= 'getgrent' | kw= 'getgrgid' | kw= 'getgrnam' | kw= 'gethostbyaddr' | kw= 'gethostbyname' | kw= 'gethostent' | kw= 'getlogin' | kw= 'getnetbyaddr' | kw= 'getnetbyname' | kw= 'getnetent' | kw= 'getpeername' | kw= 'getpgrp' | kw= 'getppid' | kw= 'getpriority' | kw= 'getprotobyname' | kw= 'getprotobynumber' | kw= 'getprotoent' | kw= 'getpwent' | kw= 'getpwnam' | kw= 'getpwuid' | kw= 'getservbyname' | kw= 'getservbyport' | kw= 'getservent' | kw= 'getsockname' | kw= 'getsockopt' | kw= 'given' | kw= 'glob' | kw= 'gmtime' | kw= 'goto' | kw= 'grep' | kw= 'hex' | kw= 'if' | kw= 'index' | kw= 'int' | kw= 'ioctl' | kw= 'join' | kw= 'keys' | kw= 'kill' | kw= 'last' | kw= 'lc' | kw= 'lcfirst' | kw= 'length' | kw= 'link' | kw= 'listen' | kw= 'local' | kw= 'localtime' | kw= 'lock' | kw= 'log' | kw= 'lstat' | kw= 'map' | kw= 'mkdir' | kw= 'msgctl' | kw= 'msgget' | kw= 'msgrcv' | kw= 'msgsnd' | kw= 'my' | kw= 'next' | kw= 'no' | kw= 'oct' | kw= 'open' | kw= 'opendir' | kw= 'ord' | kw= 'our' | kw= 'pack' | kw= 'package' | kw= 'pipe' | kw= 'pop' | kw= 'pos' | kw= 'print' | kw= 'printf' | kw= 'prototype' | kw= 'push' | kw= 'quotemeta' | kw= 'rand' | kw= 'read' | kw= 'readdir' | kw= 'readline' | kw= 'readlink' | kw= 'readpipe' | kw= 'recv' | kw= 'redo' | kw= 'ref' | kw= 'rename' | kw= 'require' | kw= 'reset' | kw= 'return' | kw= 'reverse' | kw= 'rewinddir' | kw= 'rindex' | kw= 'rmdir' | kw= 'say' | kw= 'scalar' | kw= 'seek' | kw= 'seekdir' | kw= 'select' | kw= 'semctl' | kw= 'semget' | kw= 'semop' | kw= 'send' | kw= 'setgrent' | kw= 'sethostent' | kw= 'setnetent' | kw= 'setpgrp' | kw= 'setpriority' | kw= 'setprotoent' | kw= 'setpwent' | kw= 'setservent' | kw= 'setsockopt' | kw= 'shift' | kw= 'shmctl' | kw= 'shmget' | kw= 'shmread' | kw= 'shmwrite' | kw= 'shutdown' | kw= 'sin' | kw= 'sleep' | kw= 'socket' | kw= 'socketpair' | kw= 'sort' | kw= 'splice' | kw= 'split' | kw= 'sprintf' | kw= 'sqrt' | kw= 'srand' | kw= 'stat' | kw= 'state' | kw= 'study' | kw= 'sub' | kw= 'substr' | kw= 'symlink' | kw= 'syscall' | kw= 'sysopen' | kw= 'sysread' | kw= 'sysseek' | kw= 'system' | kw= 'syswrite' | kw= 'tell' | kw= 'telldir' | kw= 'tie' | kw= 'tied' | kw= 'time' | kw= 'times' | kw= 'tr' | kw= 'truncate' | kw= 'uc' | kw= 'ucfirst' | kw= 'umask' | kw= 'undef' | kw= 'unless' | kw= 'unlink' | kw= 'unpack' | kw= 'unshift' | kw= 'untie' | kw= 'until' | kw= 'use' | kw= 'utime' | kw= 'values' | kw= 'vec' | kw= 'wait' | kw= 'waitpid' | kw= 'wantarray' | kw= 'warn' | kw= 'when' | kw= 'while' | kw= 'write' | kw= 'y' ) )
            // InternalPerl.g:861:2: (kw= 'abs' | kw= 'accept' | kw= 'alarm' | kw= 'atan2' | kw= 'bind' | kw= 'binmode' | kw= 'bless' | kw= 'break' | kw= 'caller' | kw= 'chdir' | kw= 'chmod' | kw= 'chomp' | kw= 'chop' | kw= 'chown' | kw= 'chr' | kw= 'chroot' | kw= 'close' | kw= 'closedir' | kw= 'connect' | kw= 'continue' | kw= 'cos' | kw= 'crypt' | kw= 'dbmclose' | kw= 'dbmopen' | kw= 'default' | kw= 'defined' | kw= 'delete' | kw= 'die' | kw= 'do' | kw= 'dump' | kw= 'each' | kw= 'else' | kw= 'elsif' | kw= 'endgrent' | kw= 'endhostent' | kw= 'endnetent' | kw= 'endprotoent' | kw= 'endpwent' | kw= 'endservent' | kw= 'eof' | kw= 'eval' | kw= 'evalbytes' | kw= 'exec' | kw= 'exists' | kw= 'exit' | kw= 'exp' | kw= 'fc' | kw= 'fcntl' | kw= 'fileno' | kw= 'flock' | kw= 'for' | kw= 'foreach' | kw= 'fork' | kw= 'format' | kw= 'formline' | kw= 'getc' | kw= 'getgrent' | kw= 'getgrgid' | kw= 'getgrnam' | kw= 'gethostbyaddr' | kw= 'gethostbyname' | kw= 'gethostent' | kw= 'getlogin' | kw= 'getnetbyaddr' | kw= 'getnetbyname' | kw= 'getnetent' | kw= 'getpeername' | kw= 'getpgrp' | kw= 'getppid' | kw= 'getpriority' | kw= 'getprotobyname' | kw= 'getprotobynumber' | kw= 'getprotoent' | kw= 'getpwent' | kw= 'getpwnam' | kw= 'getpwuid' | kw= 'getservbyname' | kw= 'getservbyport' | kw= 'getservent' | kw= 'getsockname' | kw= 'getsockopt' | kw= 'given' | kw= 'glob' | kw= 'gmtime' | kw= 'goto' | kw= 'grep' | kw= 'hex' | kw= 'if' | kw= 'index' | kw= 'int' | kw= 'ioctl' | kw= 'join' | kw= 'keys' | kw= 'kill' | kw= 'last' | kw= 'lc' | kw= 'lcfirst' | kw= 'length' | kw= 'link' | kw= 'listen' | kw= 'local' | kw= 'localtime' | kw= 'lock' | kw= 'log' | kw= 'lstat' | kw= 'map' | kw= 'mkdir' | kw= 'msgctl' | kw= 'msgget' | kw= 'msgrcv' | kw= 'msgsnd' | kw= 'my' | kw= 'next' | kw= 'no' | kw= 'oct' | kw= 'open' | kw= 'opendir' | kw= 'ord' | kw= 'our' | kw= 'pack' | kw= 'package' | kw= 'pipe' | kw= 'pop' | kw= 'pos' | kw= 'print' | kw= 'printf' | kw= 'prototype' | kw= 'push' | kw= 'quotemeta' | kw= 'rand' | kw= 'read' | kw= 'readdir' | kw= 'readline' | kw= 'readlink' | kw= 'readpipe' | kw= 'recv' | kw= 'redo' | kw= 'ref' | kw= 'rename' | kw= 'require' | kw= 'reset' | kw= 'return' | kw= 'reverse' | kw= 'rewinddir' | kw= 'rindex' | kw= 'rmdir' | kw= 'say' | kw= 'scalar' | kw= 'seek' | kw= 'seekdir' | kw= 'select' | kw= 'semctl' | kw= 'semget' | kw= 'semop' | kw= 'send' | kw= 'setgrent' | kw= 'sethostent' | kw= 'setnetent' | kw= 'setpgrp' | kw= 'setpriority' | kw= 'setprotoent' | kw= 'setpwent' | kw= 'setservent' | kw= 'setsockopt' | kw= 'shift' | kw= 'shmctl' | kw= 'shmget' | kw= 'shmread' | kw= 'shmwrite' | kw= 'shutdown' | kw= 'sin' | kw= 'sleep' | kw= 'socket' | kw= 'socketpair' | kw= 'sort' | kw= 'splice' | kw= 'split' | kw= 'sprintf' | kw= 'sqrt' | kw= 'srand' | kw= 'stat' | kw= 'state' | kw= 'study' | kw= 'sub' | kw= 'substr' | kw= 'symlink' | kw= 'syscall' | kw= 'sysopen' | kw= 'sysread' | kw= 'sysseek' | kw= 'system' | kw= 'syswrite' | kw= 'tell' | kw= 'telldir' | kw= 'tie' | kw= 'tied' | kw= 'time' | kw= 'times' | kw= 'tr' | kw= 'truncate' | kw= 'uc' | kw= 'ucfirst' | kw= 'umask' | kw= 'undef' | kw= 'unless' | kw= 'unlink' | kw= 'unpack' | kw= 'unshift' | kw= 'untie' | kw= 'until' | kw= 'use' | kw= 'utime' | kw= 'values' | kw= 'vec' | kw= 'wait' | kw= 'waitpid' | kw= 'wantarray' | kw= 'warn' | kw= 'when' | kw= 'while' | kw= 'write' | kw= 'y' )
            {
            // InternalPerl.g:861:2: (kw= 'abs' | kw= 'accept' | kw= 'alarm' | kw= 'atan2' | kw= 'bind' | kw= 'binmode' | kw= 'bless' | kw= 'break' | kw= 'caller' | kw= 'chdir' | kw= 'chmod' | kw= 'chomp' | kw= 'chop' | kw= 'chown' | kw= 'chr' | kw= 'chroot' | kw= 'close' | kw= 'closedir' | kw= 'connect' | kw= 'continue' | kw= 'cos' | kw= 'crypt' | kw= 'dbmclose' | kw= 'dbmopen' | kw= 'default' | kw= 'defined' | kw= 'delete' | kw= 'die' | kw= 'do' | kw= 'dump' | kw= 'each' | kw= 'else' | kw= 'elsif' | kw= 'endgrent' | kw= 'endhostent' | kw= 'endnetent' | kw= 'endprotoent' | kw= 'endpwent' | kw= 'endservent' | kw= 'eof' | kw= 'eval' | kw= 'evalbytes' | kw= 'exec' | kw= 'exists' | kw= 'exit' | kw= 'exp' | kw= 'fc' | kw= 'fcntl' | kw= 'fileno' | kw= 'flock' | kw= 'for' | kw= 'foreach' | kw= 'fork' | kw= 'format' | kw= 'formline' | kw= 'getc' | kw= 'getgrent' | kw= 'getgrgid' | kw= 'getgrnam' | kw= 'gethostbyaddr' | kw= 'gethostbyname' | kw= 'gethostent' | kw= 'getlogin' | kw= 'getnetbyaddr' | kw= 'getnetbyname' | kw= 'getnetent' | kw= 'getpeername' | kw= 'getpgrp' | kw= 'getppid' | kw= 'getpriority' | kw= 'getprotobyname' | kw= 'getprotobynumber' | kw= 'getprotoent' | kw= 'getpwent' | kw= 'getpwnam' | kw= 'getpwuid' | kw= 'getservbyname' | kw= 'getservbyport' | kw= 'getservent' | kw= 'getsockname' | kw= 'getsockopt' | kw= 'given' | kw= 'glob' | kw= 'gmtime' | kw= 'goto' | kw= 'grep' | kw= 'hex' | kw= 'if' | kw= 'index' | kw= 'int' | kw= 'ioctl' | kw= 'join' | kw= 'keys' | kw= 'kill' | kw= 'last' | kw= 'lc' | kw= 'lcfirst' | kw= 'length' | kw= 'link' | kw= 'listen' | kw= 'local' | kw= 'localtime' | kw= 'lock' | kw= 'log' | kw= 'lstat' | kw= 'map' | kw= 'mkdir' | kw= 'msgctl' | kw= 'msgget' | kw= 'msgrcv' | kw= 'msgsnd' | kw= 'my' | kw= 'next' | kw= 'no' | kw= 'oct' | kw= 'open' | kw= 'opendir' | kw= 'ord' | kw= 'our' | kw= 'pack' | kw= 'package' | kw= 'pipe' | kw= 'pop' | kw= 'pos' | kw= 'print' | kw= 'printf' | kw= 'prototype' | kw= 'push' | kw= 'quotemeta' | kw= 'rand' | kw= 'read' | kw= 'readdir' | kw= 'readline' | kw= 'readlink' | kw= 'readpipe' | kw= 'recv' | kw= 'redo' | kw= 'ref' | kw= 'rename' | kw= 'require' | kw= 'reset' | kw= 'return' | kw= 'reverse' | kw= 'rewinddir' | kw= 'rindex' | kw= 'rmdir' | kw= 'say' | kw= 'scalar' | kw= 'seek' | kw= 'seekdir' | kw= 'select' | kw= 'semctl' | kw= 'semget' | kw= 'semop' | kw= 'send' | kw= 'setgrent' | kw= 'sethostent' | kw= 'setnetent' | kw= 'setpgrp' | kw= 'setpriority' | kw= 'setprotoent' | kw= 'setpwent' | kw= 'setservent' | kw= 'setsockopt' | kw= 'shift' | kw= 'shmctl' | kw= 'shmget' | kw= 'shmread' | kw= 'shmwrite' | kw= 'shutdown' | kw= 'sin' | kw= 'sleep' | kw= 'socket' | kw= 'socketpair' | kw= 'sort' | kw= 'splice' | kw= 'split' | kw= 'sprintf' | kw= 'sqrt' | kw= 'srand' | kw= 'stat' | kw= 'state' | kw= 'study' | kw= 'sub' | kw= 'substr' | kw= 'symlink' | kw= 'syscall' | kw= 'sysopen' | kw= 'sysread' | kw= 'sysseek' | kw= 'system' | kw= 'syswrite' | kw= 'tell' | kw= 'telldir' | kw= 'tie' | kw= 'tied' | kw= 'time' | kw= 'times' | kw= 'tr' | kw= 'truncate' | kw= 'uc' | kw= 'ucfirst' | kw= 'umask' | kw= 'undef' | kw= 'unless' | kw= 'unlink' | kw= 'unpack' | kw= 'unshift' | kw= 'untie' | kw= 'until' | kw= 'use' | kw= 'utime' | kw= 'values' | kw= 'vec' | kw= 'wait' | kw= 'waitpid' | kw= 'wantarray' | kw= 'warn' | kw= 'when' | kw= 'while' | kw= 'write' | kw= 'y' )
            int alt8=222;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt8=1;
                }
                break;
            case 27:
                {
                alt8=2;
                }
                break;
            case 28:
                {
                alt8=3;
                }
                break;
            case 29:
                {
                alt8=4;
                }
                break;
            case 30:
                {
                alt8=5;
                }
                break;
            case 31:
                {
                alt8=6;
                }
                break;
            case 32:
                {
                alt8=7;
                }
                break;
            case 33:
                {
                alt8=8;
                }
                break;
            case 34:
                {
                alt8=9;
                }
                break;
            case 35:
                {
                alt8=10;
                }
                break;
            case 36:
                {
                alt8=11;
                }
                break;
            case 37:
                {
                alt8=12;
                }
                break;
            case 38:
                {
                alt8=13;
                }
                break;
            case 39:
                {
                alt8=14;
                }
                break;
            case 40:
                {
                alt8=15;
                }
                break;
            case 41:
                {
                alt8=16;
                }
                break;
            case 42:
                {
                alt8=17;
                }
                break;
            case 43:
                {
                alt8=18;
                }
                break;
            case 44:
                {
                alt8=19;
                }
                break;
            case 45:
                {
                alt8=20;
                }
                break;
            case 46:
                {
                alt8=21;
                }
                break;
            case 47:
                {
                alt8=22;
                }
                break;
            case 48:
                {
                alt8=23;
                }
                break;
            case 49:
                {
                alt8=24;
                }
                break;
            case 50:
                {
                alt8=25;
                }
                break;
            case 51:
                {
                alt8=26;
                }
                break;
            case 52:
                {
                alt8=27;
                }
                break;
            case 53:
                {
                alt8=28;
                }
                break;
            case 54:
                {
                alt8=29;
                }
                break;
            case 55:
                {
                alt8=30;
                }
                break;
            case 56:
                {
                alt8=31;
                }
                break;
            case 57:
                {
                alt8=32;
                }
                break;
            case 58:
                {
                alt8=33;
                }
                break;
            case 59:
                {
                alt8=34;
                }
                break;
            case 60:
                {
                alt8=35;
                }
                break;
            case 61:
                {
                alt8=36;
                }
                break;
            case 62:
                {
                alt8=37;
                }
                break;
            case 63:
                {
                alt8=38;
                }
                break;
            case 64:
                {
                alt8=39;
                }
                break;
            case 65:
                {
                alt8=40;
                }
                break;
            case 66:
                {
                alt8=41;
                }
                break;
            case 67:
                {
                alt8=42;
                }
                break;
            case 68:
                {
                alt8=43;
                }
                break;
            case 69:
                {
                alt8=44;
                }
                break;
            case 70:
                {
                alt8=45;
                }
                break;
            case 71:
                {
                alt8=46;
                }
                break;
            case 72:
                {
                alt8=47;
                }
                break;
            case 73:
                {
                alt8=48;
                }
                break;
            case 74:
                {
                alt8=49;
                }
                break;
            case 75:
                {
                alt8=50;
                }
                break;
            case 76:
                {
                alt8=51;
                }
                break;
            case 77:
                {
                alt8=52;
                }
                break;
            case 78:
                {
                alt8=53;
                }
                break;
            case 79:
                {
                alt8=54;
                }
                break;
            case 80:
                {
                alt8=55;
                }
                break;
            case 81:
                {
                alt8=56;
                }
                break;
            case 82:
                {
                alt8=57;
                }
                break;
            case 83:
                {
                alt8=58;
                }
                break;
            case 84:
                {
                alt8=59;
                }
                break;
            case 85:
                {
                alt8=60;
                }
                break;
            case 86:
                {
                alt8=61;
                }
                break;
            case 87:
                {
                alt8=62;
                }
                break;
            case 88:
                {
                alt8=63;
                }
                break;
            case 89:
                {
                alt8=64;
                }
                break;
            case 90:
                {
                alt8=65;
                }
                break;
            case 91:
                {
                alt8=66;
                }
                break;
            case 92:
                {
                alt8=67;
                }
                break;
            case 93:
                {
                alt8=68;
                }
                break;
            case 94:
                {
                alt8=69;
                }
                break;
            case 95:
                {
                alt8=70;
                }
                break;
            case 96:
                {
                alt8=71;
                }
                break;
            case 97:
                {
                alt8=72;
                }
                break;
            case 98:
                {
                alt8=73;
                }
                break;
            case 99:
                {
                alt8=74;
                }
                break;
            case 100:
                {
                alt8=75;
                }
                break;
            case 101:
                {
                alt8=76;
                }
                break;
            case 102:
                {
                alt8=77;
                }
                break;
            case 103:
                {
                alt8=78;
                }
                break;
            case 104:
                {
                alt8=79;
                }
                break;
            case 105:
                {
                alt8=80;
                }
                break;
            case 106:
                {
                alt8=81;
                }
                break;
            case 107:
                {
                alt8=82;
                }
                break;
            case 108:
                {
                alt8=83;
                }
                break;
            case 109:
                {
                alt8=84;
                }
                break;
            case 110:
                {
                alt8=85;
                }
                break;
            case 111:
                {
                alt8=86;
                }
                break;
            case 112:
                {
                alt8=87;
                }
                break;
            case 113:
                {
                alt8=88;
                }
                break;
            case 114:
                {
                alt8=89;
                }
                break;
            case 115:
                {
                alt8=90;
                }
                break;
            case 116:
                {
                alt8=91;
                }
                break;
            case 117:
                {
                alt8=92;
                }
                break;
            case 118:
                {
                alt8=93;
                }
                break;
            case 119:
                {
                alt8=94;
                }
                break;
            case 120:
                {
                alt8=95;
                }
                break;
            case 121:
                {
                alt8=96;
                }
                break;
            case 122:
                {
                alt8=97;
                }
                break;
            case 123:
                {
                alt8=98;
                }
                break;
            case 124:
                {
                alt8=99;
                }
                break;
            case 125:
                {
                alt8=100;
                }
                break;
            case 126:
                {
                alt8=101;
                }
                break;
            case 127:
                {
                alt8=102;
                }
                break;
            case 128:
                {
                alt8=103;
                }
                break;
            case 129:
                {
                alt8=104;
                }
                break;
            case 130:
                {
                alt8=105;
                }
                break;
            case 131:
                {
                alt8=106;
                }
                break;
            case 132:
                {
                alt8=107;
                }
                break;
            case 133:
                {
                alt8=108;
                }
                break;
            case 134:
                {
                alt8=109;
                }
                break;
            case 135:
                {
                alt8=110;
                }
                break;
            case 136:
                {
                alt8=111;
                }
                break;
            case 137:
                {
                alt8=112;
                }
                break;
            case 138:
                {
                alt8=113;
                }
                break;
            case 139:
                {
                alt8=114;
                }
                break;
            case 140:
                {
                alt8=115;
                }
                break;
            case 141:
                {
                alt8=116;
                }
                break;
            case 142:
                {
                alt8=117;
                }
                break;
            case 143:
                {
                alt8=118;
                }
                break;
            case 144:
                {
                alt8=119;
                }
                break;
            case 145:
                {
                alt8=120;
                }
                break;
            case 25:
                {
                alt8=121;
                }
                break;
            case 146:
                {
                alt8=122;
                }
                break;
            case 147:
                {
                alt8=123;
                }
                break;
            case 148:
                {
                alt8=124;
                }
                break;
            case 149:
                {
                alt8=125;
                }
                break;
            case 150:
                {
                alt8=126;
                }
                break;
            case 151:
                {
                alt8=127;
                }
                break;
            case 152:
                {
                alt8=128;
                }
                break;
            case 153:
                {
                alt8=129;
                }
                break;
            case 154:
                {
                alt8=130;
                }
                break;
            case 155:
                {
                alt8=131;
                }
                break;
            case 156:
                {
                alt8=132;
                }
                break;
            case 157:
                {
                alt8=133;
                }
                break;
            case 158:
                {
                alt8=134;
                }
                break;
            case 159:
                {
                alt8=135;
                }
                break;
            case 160:
                {
                alt8=136;
                }
                break;
            case 161:
                {
                alt8=137;
                }
                break;
            case 162:
                {
                alt8=138;
                }
                break;
            case 163:
                {
                alt8=139;
                }
                break;
            case 164:
                {
                alt8=140;
                }
                break;
            case 165:
                {
                alt8=141;
                }
                break;
            case 166:
                {
                alt8=142;
                }
                break;
            case 167:
                {
                alt8=143;
                }
                break;
            case 168:
                {
                alt8=144;
                }
                break;
            case 169:
                {
                alt8=145;
                }
                break;
            case 170:
                {
                alt8=146;
                }
                break;
            case 171:
                {
                alt8=147;
                }
                break;
            case 172:
                {
                alt8=148;
                }
                break;
            case 173:
                {
                alt8=149;
                }
                break;
            case 174:
                {
                alt8=150;
                }
                break;
            case 175:
                {
                alt8=151;
                }
                break;
            case 176:
                {
                alt8=152;
                }
                break;
            case 177:
                {
                alt8=153;
                }
                break;
            case 178:
                {
                alt8=154;
                }
                break;
            case 179:
                {
                alt8=155;
                }
                break;
            case 180:
                {
                alt8=156;
                }
                break;
            case 181:
                {
                alt8=157;
                }
                break;
            case 182:
                {
                alt8=158;
                }
                break;
            case 183:
                {
                alt8=159;
                }
                break;
            case 184:
                {
                alt8=160;
                }
                break;
            case 185:
                {
                alt8=161;
                }
                break;
            case 186:
                {
                alt8=162;
                }
                break;
            case 187:
                {
                alt8=163;
                }
                break;
            case 188:
                {
                alt8=164;
                }
                break;
            case 189:
                {
                alt8=165;
                }
                break;
            case 190:
                {
                alt8=166;
                }
                break;
            case 191:
                {
                alt8=167;
                }
                break;
            case 192:
                {
                alt8=168;
                }
                break;
            case 193:
                {
                alt8=169;
                }
                break;
            case 194:
                {
                alt8=170;
                }
                break;
            case 195:
                {
                alt8=171;
                }
                break;
            case 196:
                {
                alt8=172;
                }
                break;
            case 197:
                {
                alt8=173;
                }
                break;
            case 198:
                {
                alt8=174;
                }
                break;
            case 199:
                {
                alt8=175;
                }
                break;
            case 200:
                {
                alt8=176;
                }
                break;
            case 201:
                {
                alt8=177;
                }
                break;
            case 202:
                {
                alt8=178;
                }
                break;
            case 203:
                {
                alt8=179;
                }
                break;
            case 204:
                {
                alt8=180;
                }
                break;
            case 205:
                {
                alt8=181;
                }
                break;
            case 206:
                {
                alt8=182;
                }
                break;
            case 207:
                {
                alt8=183;
                }
                break;
            case 208:
                {
                alt8=184;
                }
                break;
            case 209:
                {
                alt8=185;
                }
                break;
            case 210:
                {
                alt8=186;
                }
                break;
            case 211:
                {
                alt8=187;
                }
                break;
            case 212:
                {
                alt8=188;
                }
                break;
            case 213:
                {
                alt8=189;
                }
                break;
            case 214:
                {
                alt8=190;
                }
                break;
            case 215:
                {
                alt8=191;
                }
                break;
            case 216:
                {
                alt8=192;
                }
                break;
            case 217:
                {
                alt8=193;
                }
                break;
            case 218:
                {
                alt8=194;
                }
                break;
            case 219:
                {
                alt8=195;
                }
                break;
            case 220:
                {
                alt8=196;
                }
                break;
            case 221:
                {
                alt8=197;
                }
                break;
            case 222:
                {
                alt8=198;
                }
                break;
            case 223:
                {
                alt8=199;
                }
                break;
            case 224:
                {
                alt8=200;
                }
                break;
            case 225:
                {
                alt8=201;
                }
                break;
            case 226:
                {
                alt8=202;
                }
                break;
            case 227:
                {
                alt8=203;
                }
                break;
            case 228:
                {
                alt8=204;
                }
                break;
            case 229:
                {
                alt8=205;
                }
                break;
            case 230:
                {
                alt8=206;
                }
                break;
            case 231:
                {
                alt8=207;
                }
                break;
            case 232:
                {
                alt8=208;
                }
                break;
            case 233:
                {
                alt8=209;
                }
                break;
            case 234:
                {
                alt8=210;
                }
                break;
            case 235:
                {
                alt8=211;
                }
                break;
            case 236:
                {
                alt8=212;
                }
                break;
            case 237:
                {
                alt8=213;
                }
                break;
            case 238:
                {
                alt8=214;
                }
                break;
            case 239:
                {
                alt8=215;
                }
                break;
            case 240:
                {
                alt8=216;
                }
                break;
            case 241:
                {
                alt8=217;
                }
                break;
            case 242:
                {
                alt8=218;
                }
                break;
            case 243:
                {
                alt8=219;
                }
                break;
            case 244:
                {
                alt8=220;
                }
                break;
            case 245:
                {
                alt8=221;
                }
                break;
            case 246:
                {
                alt8=222;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalPerl.g:862:3: kw= 'abs'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getAbsKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:868:3: kw= 'accept'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getAcceptKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:874:3: kw= 'alarm'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getAlarmKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:880:3: kw= 'atan2'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getAtan2Keyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalPerl.g:886:3: kw= 'bind'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getBindKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalPerl.g:892:3: kw= 'binmode'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getBinmodeKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalPerl.g:898:3: kw= 'bless'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getBlessKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalPerl.g:904:3: kw= 'break'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getBreakKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalPerl.g:910:3: kw= 'caller'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getCallerKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalPerl.g:916:3: kw= 'chdir'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getChdirKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalPerl.g:922:3: kw= 'chmod'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getChmodKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalPerl.g:928:3: kw= 'chomp'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getChompKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalPerl.g:934:3: kw= 'chop'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getChopKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalPerl.g:940:3: kw= 'chown'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getChownKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalPerl.g:946:3: kw= 'chr'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getChrKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalPerl.g:952:3: kw= 'chroot'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getChrootKeyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalPerl.g:958:3: kw= 'close'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getCloseKeyword_16());
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalPerl.g:964:3: kw= 'closedir'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getClosedirKeyword_17());
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalPerl.g:970:3: kw= 'connect'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getConnectKeyword_18());
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalPerl.g:976:3: kw= 'continue'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getContinueKeyword_19());
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalPerl.g:982:3: kw= 'cos'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getCosKeyword_20());
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalPerl.g:988:3: kw= 'crypt'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getCryptKeyword_21());
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalPerl.g:994:3: kw= 'dbmclose'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getDbmcloseKeyword_22());
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalPerl.g:1000:3: kw= 'dbmopen'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getDbmopenKeyword_23());
                      		
                    }

                    }
                    break;
                case 25 :
                    // InternalPerl.g:1006:3: kw= 'default'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getDefaultKeyword_24());
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalPerl.g:1012:3: kw= 'defined'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getDefinedKeyword_25());
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalPerl.g:1018:3: kw= 'delete'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getDeleteKeyword_26());
                      		
                    }

                    }
                    break;
                case 28 :
                    // InternalPerl.g:1024:3: kw= 'die'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getDieKeyword_27());
                      		
                    }

                    }
                    break;
                case 29 :
                    // InternalPerl.g:1030:3: kw= 'do'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getDoKeyword_28());
                      		
                    }

                    }
                    break;
                case 30 :
                    // InternalPerl.g:1036:3: kw= 'dump'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getDumpKeyword_29());
                      		
                    }

                    }
                    break;
                case 31 :
                    // InternalPerl.g:1042:3: kw= 'each'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getEachKeyword_30());
                      		
                    }

                    }
                    break;
                case 32 :
                    // InternalPerl.g:1048:3: kw= 'else'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getElseKeyword_31());
                      		
                    }

                    }
                    break;
                case 33 :
                    // InternalPerl.g:1054:3: kw= 'elsif'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getElsifKeyword_32());
                      		
                    }

                    }
                    break;
                case 34 :
                    // InternalPerl.g:1060:3: kw= 'endgrent'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndgrentKeyword_33());
                      		
                    }

                    }
                    break;
                case 35 :
                    // InternalPerl.g:1066:3: kw= 'endhostent'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndhostentKeyword_34());
                      		
                    }

                    }
                    break;
                case 36 :
                    // InternalPerl.g:1072:3: kw= 'endnetent'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndnetentKeyword_35());
                      		
                    }

                    }
                    break;
                case 37 :
                    // InternalPerl.g:1078:3: kw= 'endprotoent'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndprotoentKeyword_36());
                      		
                    }

                    }
                    break;
                case 38 :
                    // InternalPerl.g:1084:3: kw= 'endpwent'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndpwentKeyword_37());
                      		
                    }

                    }
                    break;
                case 39 :
                    // InternalPerl.g:1090:3: kw= 'endservent'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getEndserventKeyword_38());
                      		
                    }

                    }
                    break;
                case 40 :
                    // InternalPerl.g:1096:3: kw= 'eof'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getEofKeyword_39());
                      		
                    }

                    }
                    break;
                case 41 :
                    // InternalPerl.g:1102:3: kw= 'eval'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getEvalKeyword_40());
                      		
                    }

                    }
                    break;
                case 42 :
                    // InternalPerl.g:1108:3: kw= 'evalbytes'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getEvalbytesKeyword_41());
                      		
                    }

                    }
                    break;
                case 43 :
                    // InternalPerl.g:1114:3: kw= 'exec'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getExecKeyword_42());
                      		
                    }

                    }
                    break;
                case 44 :
                    // InternalPerl.g:1120:3: kw= 'exists'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getExistsKeyword_43());
                      		
                    }

                    }
                    break;
                case 45 :
                    // InternalPerl.g:1126:3: kw= 'exit'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getExitKeyword_44());
                      		
                    }

                    }
                    break;
                case 46 :
                    // InternalPerl.g:1132:3: kw= 'exp'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getExpKeyword_45());
                      		
                    }

                    }
                    break;
                case 47 :
                    // InternalPerl.g:1138:3: kw= 'fc'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getFcKeyword_46());
                      		
                    }

                    }
                    break;
                case 48 :
                    // InternalPerl.g:1144:3: kw= 'fcntl'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getFcntlKeyword_47());
                      		
                    }

                    }
                    break;
                case 49 :
                    // InternalPerl.g:1150:3: kw= 'fileno'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getFilenoKeyword_48());
                      		
                    }

                    }
                    break;
                case 50 :
                    // InternalPerl.g:1156:3: kw= 'flock'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getFlockKeyword_49());
                      		
                    }

                    }
                    break;
                case 51 :
                    // InternalPerl.g:1162:3: kw= 'for'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getForKeyword_50());
                      		
                    }

                    }
                    break;
                case 52 :
                    // InternalPerl.g:1168:3: kw= 'foreach'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getForeachKeyword_51());
                      		
                    }

                    }
                    break;
                case 53 :
                    // InternalPerl.g:1174:3: kw= 'fork'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getForkKeyword_52());
                      		
                    }

                    }
                    break;
                case 54 :
                    // InternalPerl.g:1180:3: kw= 'format'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getFormatKeyword_53());
                      		
                    }

                    }
                    break;
                case 55 :
                    // InternalPerl.g:1186:3: kw= 'formline'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getFormlineKeyword_54());
                      		
                    }

                    }
                    break;
                case 56 :
                    // InternalPerl.g:1192:3: kw= 'getc'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetcKeyword_55());
                      		
                    }

                    }
                    break;
                case 57 :
                    // InternalPerl.g:1198:3: kw= 'getgrent'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetgrentKeyword_56());
                      		
                    }

                    }
                    break;
                case 58 :
                    // InternalPerl.g:1204:3: kw= 'getgrgid'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetgrgidKeyword_57());
                      		
                    }

                    }
                    break;
                case 59 :
                    // InternalPerl.g:1210:3: kw= 'getgrnam'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetgrnamKeyword_58());
                      		
                    }

                    }
                    break;
                case 60 :
                    // InternalPerl.g:1216:3: kw= 'gethostbyaddr'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGethostbyaddrKeyword_59());
                      		
                    }

                    }
                    break;
                case 61 :
                    // InternalPerl.g:1222:3: kw= 'gethostbyname'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGethostbynameKeyword_60());
                      		
                    }

                    }
                    break;
                case 62 :
                    // InternalPerl.g:1228:3: kw= 'gethostent'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGethostentKeyword_61());
                      		
                    }

                    }
                    break;
                case 63 :
                    // InternalPerl.g:1234:3: kw= 'getlogin'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetloginKeyword_62());
                      		
                    }

                    }
                    break;
                case 64 :
                    // InternalPerl.g:1240:3: kw= 'getnetbyaddr'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetnetbyaddrKeyword_63());
                      		
                    }

                    }
                    break;
                case 65 :
                    // InternalPerl.g:1246:3: kw= 'getnetbyname'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetnetbynameKeyword_64());
                      		
                    }

                    }
                    break;
                case 66 :
                    // InternalPerl.g:1252:3: kw= 'getnetent'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetnetentKeyword_65());
                      		
                    }

                    }
                    break;
                case 67 :
                    // InternalPerl.g:1258:3: kw= 'getpeername'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpeernameKeyword_66());
                      		
                    }

                    }
                    break;
                case 68 :
                    // InternalPerl.g:1264:3: kw= 'getpgrp'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpgrpKeyword_67());
                      		
                    }

                    }
                    break;
                case 69 :
                    // InternalPerl.g:1270:3: kw= 'getppid'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetppidKeyword_68());
                      		
                    }

                    }
                    break;
                case 70 :
                    // InternalPerl.g:1276:3: kw= 'getpriority'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpriorityKeyword_69());
                      		
                    }

                    }
                    break;
                case 71 :
                    // InternalPerl.g:1282:3: kw= 'getprotobyname'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetprotobynameKeyword_70());
                      		
                    }

                    }
                    break;
                case 72 :
                    // InternalPerl.g:1288:3: kw= 'getprotobynumber'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetprotobynumberKeyword_71());
                      		
                    }

                    }
                    break;
                case 73 :
                    // InternalPerl.g:1294:3: kw= 'getprotoent'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetprotoentKeyword_72());
                      		
                    }

                    }
                    break;
                case 74 :
                    // InternalPerl.g:1300:3: kw= 'getpwent'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpwentKeyword_73());
                      		
                    }

                    }
                    break;
                case 75 :
                    // InternalPerl.g:1306:3: kw= 'getpwnam'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpwnamKeyword_74());
                      		
                    }

                    }
                    break;
                case 76 :
                    // InternalPerl.g:1312:3: kw= 'getpwuid'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetpwuidKeyword_75());
                      		
                    }

                    }
                    break;
                case 77 :
                    // InternalPerl.g:1318:3: kw= 'getservbyname'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetservbynameKeyword_76());
                      		
                    }

                    }
                    break;
                case 78 :
                    // InternalPerl.g:1324:3: kw= 'getservbyport'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetservbyportKeyword_77());
                      		
                    }

                    }
                    break;
                case 79 :
                    // InternalPerl.g:1330:3: kw= 'getservent'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetserventKeyword_78());
                      		
                    }

                    }
                    break;
                case 80 :
                    // InternalPerl.g:1336:3: kw= 'getsockname'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetsocknameKeyword_79());
                      		
                    }

                    }
                    break;
                case 81 :
                    // InternalPerl.g:1342:3: kw= 'getsockopt'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGetsockoptKeyword_80());
                      		
                    }

                    }
                    break;
                case 82 :
                    // InternalPerl.g:1348:3: kw= 'given'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGivenKeyword_81());
                      		
                    }

                    }
                    break;
                case 83 :
                    // InternalPerl.g:1354:3: kw= 'glob'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGlobKeyword_82());
                      		
                    }

                    }
                    break;
                case 84 :
                    // InternalPerl.g:1360:3: kw= 'gmtime'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGmtimeKeyword_83());
                      		
                    }

                    }
                    break;
                case 85 :
                    // InternalPerl.g:1366:3: kw= 'goto'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGotoKeyword_84());
                      		
                    }

                    }
                    break;
                case 86 :
                    // InternalPerl.g:1372:3: kw= 'grep'
                    {
                    kw=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getGrepKeyword_85());
                      		
                    }

                    }
                    break;
                case 87 :
                    // InternalPerl.g:1378:3: kw= 'hex'
                    {
                    kw=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getHexKeyword_86());
                      		
                    }

                    }
                    break;
                case 88 :
                    // InternalPerl.g:1384:3: kw= 'if'
                    {
                    kw=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getIfKeyword_87());
                      		
                    }

                    }
                    break;
                case 89 :
                    // InternalPerl.g:1390:3: kw= 'index'
                    {
                    kw=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getIndexKeyword_88());
                      		
                    }

                    }
                    break;
                case 90 :
                    // InternalPerl.g:1396:3: kw= 'int'
                    {
                    kw=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getIntKeyword_89());
                      		
                    }

                    }
                    break;
                case 91 :
                    // InternalPerl.g:1402:3: kw= 'ioctl'
                    {
                    kw=(Token)match(input,116,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getIoctlKeyword_90());
                      		
                    }

                    }
                    break;
                case 92 :
                    // InternalPerl.g:1408:3: kw= 'join'
                    {
                    kw=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getJoinKeyword_91());
                      		
                    }

                    }
                    break;
                case 93 :
                    // InternalPerl.g:1414:3: kw= 'keys'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getKeysKeyword_92());
                      		
                    }

                    }
                    break;
                case 94 :
                    // InternalPerl.g:1420:3: kw= 'kill'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getKillKeyword_93());
                      		
                    }

                    }
                    break;
                case 95 :
                    // InternalPerl.g:1426:3: kw= 'last'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getLastKeyword_94());
                      		
                    }

                    }
                    break;
                case 96 :
                    // InternalPerl.g:1432:3: kw= 'lc'
                    {
                    kw=(Token)match(input,121,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getLcKeyword_95());
                      		
                    }

                    }
                    break;
                case 97 :
                    // InternalPerl.g:1438:3: kw= 'lcfirst'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getLcfirstKeyword_96());
                      		
                    }

                    }
                    break;
                case 98 :
                    // InternalPerl.g:1444:3: kw= 'length'
                    {
                    kw=(Token)match(input,123,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getLengthKeyword_97());
                      		
                    }

                    }
                    break;
                case 99 :
                    // InternalPerl.g:1450:3: kw= 'link'
                    {
                    kw=(Token)match(input,124,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getLinkKeyword_98());
                      		
                    }

                    }
                    break;
                case 100 :
                    // InternalPerl.g:1456:3: kw= 'listen'
                    {
                    kw=(Token)match(input,125,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getListenKeyword_99());
                      		
                    }

                    }
                    break;
                case 101 :
                    // InternalPerl.g:1462:3: kw= 'local'
                    {
                    kw=(Token)match(input,126,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getLocalKeyword_100());
                      		
                    }

                    }
                    break;
                case 102 :
                    // InternalPerl.g:1468:3: kw= 'localtime'
                    {
                    kw=(Token)match(input,127,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getLocaltimeKeyword_101());
                      		
                    }

                    }
                    break;
                case 103 :
                    // InternalPerl.g:1474:3: kw= 'lock'
                    {
                    kw=(Token)match(input,128,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getLockKeyword_102());
                      		
                    }

                    }
                    break;
                case 104 :
                    // InternalPerl.g:1480:3: kw= 'log'
                    {
                    kw=(Token)match(input,129,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getLogKeyword_103());
                      		
                    }

                    }
                    break;
                case 105 :
                    // InternalPerl.g:1486:3: kw= 'lstat'
                    {
                    kw=(Token)match(input,130,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getLstatKeyword_104());
                      		
                    }

                    }
                    break;
                case 106 :
                    // InternalPerl.g:1492:3: kw= 'map'
                    {
                    kw=(Token)match(input,131,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getMapKeyword_105());
                      		
                    }

                    }
                    break;
                case 107 :
                    // InternalPerl.g:1498:3: kw= 'mkdir'
                    {
                    kw=(Token)match(input,132,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getMkdirKeyword_106());
                      		
                    }

                    }
                    break;
                case 108 :
                    // InternalPerl.g:1504:3: kw= 'msgctl'
                    {
                    kw=(Token)match(input,133,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getMsgctlKeyword_107());
                      		
                    }

                    }
                    break;
                case 109 :
                    // InternalPerl.g:1510:3: kw= 'msgget'
                    {
                    kw=(Token)match(input,134,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getMsggetKeyword_108());
                      		
                    }

                    }
                    break;
                case 110 :
                    // InternalPerl.g:1516:3: kw= 'msgrcv'
                    {
                    kw=(Token)match(input,135,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getMsgrcvKeyword_109());
                      		
                    }

                    }
                    break;
                case 111 :
                    // InternalPerl.g:1522:3: kw= 'msgsnd'
                    {
                    kw=(Token)match(input,136,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getMsgsndKeyword_110());
                      		
                    }

                    }
                    break;
                case 112 :
                    // InternalPerl.g:1528:3: kw= 'my'
                    {
                    kw=(Token)match(input,137,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getMyKeyword_111());
                      		
                    }

                    }
                    break;
                case 113 :
                    // InternalPerl.g:1534:3: kw= 'next'
                    {
                    kw=(Token)match(input,138,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getNextKeyword_112());
                      		
                    }

                    }
                    break;
                case 114 :
                    // InternalPerl.g:1540:3: kw= 'no'
                    {
                    kw=(Token)match(input,139,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getNoKeyword_113());
                      		
                    }

                    }
                    break;
                case 115 :
                    // InternalPerl.g:1546:3: kw= 'oct'
                    {
                    kw=(Token)match(input,140,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getOctKeyword_114());
                      		
                    }

                    }
                    break;
                case 116 :
                    // InternalPerl.g:1552:3: kw= 'open'
                    {
                    kw=(Token)match(input,141,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getOpenKeyword_115());
                      		
                    }

                    }
                    break;
                case 117 :
                    // InternalPerl.g:1558:3: kw= 'opendir'
                    {
                    kw=(Token)match(input,142,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getOpendirKeyword_116());
                      		
                    }

                    }
                    break;
                case 118 :
                    // InternalPerl.g:1564:3: kw= 'ord'
                    {
                    kw=(Token)match(input,143,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getOrdKeyword_117());
                      		
                    }

                    }
                    break;
                case 119 :
                    // InternalPerl.g:1570:3: kw= 'our'
                    {
                    kw=(Token)match(input,144,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getOurKeyword_118());
                      		
                    }

                    }
                    break;
                case 120 :
                    // InternalPerl.g:1576:3: kw= 'pack'
                    {
                    kw=(Token)match(input,145,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getPackKeyword_119());
                      		
                    }

                    }
                    break;
                case 121 :
                    // InternalPerl.g:1582:3: kw= 'package'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getPackageKeyword_120());
                      		
                    }

                    }
                    break;
                case 122 :
                    // InternalPerl.g:1588:3: kw= 'pipe'
                    {
                    kw=(Token)match(input,146,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getPipeKeyword_121());
                      		
                    }

                    }
                    break;
                case 123 :
                    // InternalPerl.g:1594:3: kw= 'pop'
                    {
                    kw=(Token)match(input,147,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getPopKeyword_122());
                      		
                    }

                    }
                    break;
                case 124 :
                    // InternalPerl.g:1600:3: kw= 'pos'
                    {
                    kw=(Token)match(input,148,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getPosKeyword_123());
                      		
                    }

                    }
                    break;
                case 125 :
                    // InternalPerl.g:1606:3: kw= 'print'
                    {
                    kw=(Token)match(input,149,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getPrintKeyword_124());
                      		
                    }

                    }
                    break;
                case 126 :
                    // InternalPerl.g:1612:3: kw= 'printf'
                    {
                    kw=(Token)match(input,150,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getPrintfKeyword_125());
                      		
                    }

                    }
                    break;
                case 127 :
                    // InternalPerl.g:1618:3: kw= 'prototype'
                    {
                    kw=(Token)match(input,151,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getPrototypeKeyword_126());
                      		
                    }

                    }
                    break;
                case 128 :
                    // InternalPerl.g:1624:3: kw= 'push'
                    {
                    kw=(Token)match(input,152,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getPushKeyword_127());
                      		
                    }

                    }
                    break;
                case 129 :
                    // InternalPerl.g:1630:3: kw= 'quotemeta'
                    {
                    kw=(Token)match(input,153,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getQuotemetaKeyword_128());
                      		
                    }

                    }
                    break;
                case 130 :
                    // InternalPerl.g:1636:3: kw= 'rand'
                    {
                    kw=(Token)match(input,154,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getRandKeyword_129());
                      		
                    }

                    }
                    break;
                case 131 :
                    // InternalPerl.g:1642:3: kw= 'read'
                    {
                    kw=(Token)match(input,155,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getReadKeyword_130());
                      		
                    }

                    }
                    break;
                case 132 :
                    // InternalPerl.g:1648:3: kw= 'readdir'
                    {
                    kw=(Token)match(input,156,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getReaddirKeyword_131());
                      		
                    }

                    }
                    break;
                case 133 :
                    // InternalPerl.g:1654:3: kw= 'readline'
                    {
                    kw=(Token)match(input,157,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getReadlineKeyword_132());
                      		
                    }

                    }
                    break;
                case 134 :
                    // InternalPerl.g:1660:3: kw= 'readlink'
                    {
                    kw=(Token)match(input,158,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getReadlinkKeyword_133());
                      		
                    }

                    }
                    break;
                case 135 :
                    // InternalPerl.g:1666:3: kw= 'readpipe'
                    {
                    kw=(Token)match(input,159,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getReadpipeKeyword_134());
                      		
                    }

                    }
                    break;
                case 136 :
                    // InternalPerl.g:1672:3: kw= 'recv'
                    {
                    kw=(Token)match(input,160,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getRecvKeyword_135());
                      		
                    }

                    }
                    break;
                case 137 :
                    // InternalPerl.g:1678:3: kw= 'redo'
                    {
                    kw=(Token)match(input,161,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getRedoKeyword_136());
                      		
                    }

                    }
                    break;
                case 138 :
                    // InternalPerl.g:1684:3: kw= 'ref'
                    {
                    kw=(Token)match(input,162,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getRefKeyword_137());
                      		
                    }

                    }
                    break;
                case 139 :
                    // InternalPerl.g:1690:3: kw= 'rename'
                    {
                    kw=(Token)match(input,163,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getRenameKeyword_138());
                      		
                    }

                    }
                    break;
                case 140 :
                    // InternalPerl.g:1696:3: kw= 'require'
                    {
                    kw=(Token)match(input,164,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getRequireKeyword_139());
                      		
                    }

                    }
                    break;
                case 141 :
                    // InternalPerl.g:1702:3: kw= 'reset'
                    {
                    kw=(Token)match(input,165,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getResetKeyword_140());
                      		
                    }

                    }
                    break;
                case 142 :
                    // InternalPerl.g:1708:3: kw= 'return'
                    {
                    kw=(Token)match(input,166,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getReturnKeyword_141());
                      		
                    }

                    }
                    break;
                case 143 :
                    // InternalPerl.g:1714:3: kw= 'reverse'
                    {
                    kw=(Token)match(input,167,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getReverseKeyword_142());
                      		
                    }

                    }
                    break;
                case 144 :
                    // InternalPerl.g:1720:3: kw= 'rewinddir'
                    {
                    kw=(Token)match(input,168,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getRewinddirKeyword_143());
                      		
                    }

                    }
                    break;
                case 145 :
                    // InternalPerl.g:1726:3: kw= 'rindex'
                    {
                    kw=(Token)match(input,169,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getRindexKeyword_144());
                      		
                    }

                    }
                    break;
                case 146 :
                    // InternalPerl.g:1732:3: kw= 'rmdir'
                    {
                    kw=(Token)match(input,170,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getRmdirKeyword_145());
                      		
                    }

                    }
                    break;
                case 147 :
                    // InternalPerl.g:1738:3: kw= 'say'
                    {
                    kw=(Token)match(input,171,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSayKeyword_146());
                      		
                    }

                    }
                    break;
                case 148 :
                    // InternalPerl.g:1744:3: kw= 'scalar'
                    {
                    kw=(Token)match(input,172,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getScalarKeyword_147());
                      		
                    }

                    }
                    break;
                case 149 :
                    // InternalPerl.g:1750:3: kw= 'seek'
                    {
                    kw=(Token)match(input,173,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSeekKeyword_148());
                      		
                    }

                    }
                    break;
                case 150 :
                    // InternalPerl.g:1756:3: kw= 'seekdir'
                    {
                    kw=(Token)match(input,174,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSeekdirKeyword_149());
                      		
                    }

                    }
                    break;
                case 151 :
                    // InternalPerl.g:1762:3: kw= 'select'
                    {
                    kw=(Token)match(input,175,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSelectKeyword_150());
                      		
                    }

                    }
                    break;
                case 152 :
                    // InternalPerl.g:1768:3: kw= 'semctl'
                    {
                    kw=(Token)match(input,176,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSemctlKeyword_151());
                      		
                    }

                    }
                    break;
                case 153 :
                    // InternalPerl.g:1774:3: kw= 'semget'
                    {
                    kw=(Token)match(input,177,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSemgetKeyword_152());
                      		
                    }

                    }
                    break;
                case 154 :
                    // InternalPerl.g:1780:3: kw= 'semop'
                    {
                    kw=(Token)match(input,178,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSemopKeyword_153());
                      		
                    }

                    }
                    break;
                case 155 :
                    // InternalPerl.g:1786:3: kw= 'send'
                    {
                    kw=(Token)match(input,179,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSendKeyword_154());
                      		
                    }

                    }
                    break;
                case 156 :
                    // InternalPerl.g:1792:3: kw= 'setgrent'
                    {
                    kw=(Token)match(input,180,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetgrentKeyword_155());
                      		
                    }

                    }
                    break;
                case 157 :
                    // InternalPerl.g:1798:3: kw= 'sethostent'
                    {
                    kw=(Token)match(input,181,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSethostentKeyword_156());
                      		
                    }

                    }
                    break;
                case 158 :
                    // InternalPerl.g:1804:3: kw= 'setnetent'
                    {
                    kw=(Token)match(input,182,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetnetentKeyword_157());
                      		
                    }

                    }
                    break;
                case 159 :
                    // InternalPerl.g:1810:3: kw= 'setpgrp'
                    {
                    kw=(Token)match(input,183,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetpgrpKeyword_158());
                      		
                    }

                    }
                    break;
                case 160 :
                    // InternalPerl.g:1816:3: kw= 'setpriority'
                    {
                    kw=(Token)match(input,184,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetpriorityKeyword_159());
                      		
                    }

                    }
                    break;
                case 161 :
                    // InternalPerl.g:1822:3: kw= 'setprotoent'
                    {
                    kw=(Token)match(input,185,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetprotoentKeyword_160());
                      		
                    }

                    }
                    break;
                case 162 :
                    // InternalPerl.g:1828:3: kw= 'setpwent'
                    {
                    kw=(Token)match(input,186,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetpwentKeyword_161());
                      		
                    }

                    }
                    break;
                case 163 :
                    // InternalPerl.g:1834:3: kw= 'setservent'
                    {
                    kw=(Token)match(input,187,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetserventKeyword_162());
                      		
                    }

                    }
                    break;
                case 164 :
                    // InternalPerl.g:1840:3: kw= 'setsockopt'
                    {
                    kw=(Token)match(input,188,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSetsockoptKeyword_163());
                      		
                    }

                    }
                    break;
                case 165 :
                    // InternalPerl.g:1846:3: kw= 'shift'
                    {
                    kw=(Token)match(input,189,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getShiftKeyword_164());
                      		
                    }

                    }
                    break;
                case 166 :
                    // InternalPerl.g:1852:3: kw= 'shmctl'
                    {
                    kw=(Token)match(input,190,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getShmctlKeyword_165());
                      		
                    }

                    }
                    break;
                case 167 :
                    // InternalPerl.g:1858:3: kw= 'shmget'
                    {
                    kw=(Token)match(input,191,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getShmgetKeyword_166());
                      		
                    }

                    }
                    break;
                case 168 :
                    // InternalPerl.g:1864:3: kw= 'shmread'
                    {
                    kw=(Token)match(input,192,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getShmreadKeyword_167());
                      		
                    }

                    }
                    break;
                case 169 :
                    // InternalPerl.g:1870:3: kw= 'shmwrite'
                    {
                    kw=(Token)match(input,193,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getShmwriteKeyword_168());
                      		
                    }

                    }
                    break;
                case 170 :
                    // InternalPerl.g:1876:3: kw= 'shutdown'
                    {
                    kw=(Token)match(input,194,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getShutdownKeyword_169());
                      		
                    }

                    }
                    break;
                case 171 :
                    // InternalPerl.g:1882:3: kw= 'sin'
                    {
                    kw=(Token)match(input,195,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSinKeyword_170());
                      		
                    }

                    }
                    break;
                case 172 :
                    // InternalPerl.g:1888:3: kw= 'sleep'
                    {
                    kw=(Token)match(input,196,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSleepKeyword_171());
                      		
                    }

                    }
                    break;
                case 173 :
                    // InternalPerl.g:1894:3: kw= 'socket'
                    {
                    kw=(Token)match(input,197,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSocketKeyword_172());
                      		
                    }

                    }
                    break;
                case 174 :
                    // InternalPerl.g:1900:3: kw= 'socketpair'
                    {
                    kw=(Token)match(input,198,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSocketpairKeyword_173());
                      		
                    }

                    }
                    break;
                case 175 :
                    // InternalPerl.g:1906:3: kw= 'sort'
                    {
                    kw=(Token)match(input,199,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSortKeyword_174());
                      		
                    }

                    }
                    break;
                case 176 :
                    // InternalPerl.g:1912:3: kw= 'splice'
                    {
                    kw=(Token)match(input,200,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSpliceKeyword_175());
                      		
                    }

                    }
                    break;
                case 177 :
                    // InternalPerl.g:1918:3: kw= 'split'
                    {
                    kw=(Token)match(input,201,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSplitKeyword_176());
                      		
                    }

                    }
                    break;
                case 178 :
                    // InternalPerl.g:1924:3: kw= 'sprintf'
                    {
                    kw=(Token)match(input,202,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSprintfKeyword_177());
                      		
                    }

                    }
                    break;
                case 179 :
                    // InternalPerl.g:1930:3: kw= 'sqrt'
                    {
                    kw=(Token)match(input,203,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSqrtKeyword_178());
                      		
                    }

                    }
                    break;
                case 180 :
                    // InternalPerl.g:1936:3: kw= 'srand'
                    {
                    kw=(Token)match(input,204,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSrandKeyword_179());
                      		
                    }

                    }
                    break;
                case 181 :
                    // InternalPerl.g:1942:3: kw= 'stat'
                    {
                    kw=(Token)match(input,205,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getStatKeyword_180());
                      		
                    }

                    }
                    break;
                case 182 :
                    // InternalPerl.g:1948:3: kw= 'state'
                    {
                    kw=(Token)match(input,206,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getStateKeyword_181());
                      		
                    }

                    }
                    break;
                case 183 :
                    // InternalPerl.g:1954:3: kw= 'study'
                    {
                    kw=(Token)match(input,207,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getStudyKeyword_182());
                      		
                    }

                    }
                    break;
                case 184 :
                    // InternalPerl.g:1960:3: kw= 'sub'
                    {
                    kw=(Token)match(input,208,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSubKeyword_183());
                      		
                    }

                    }
                    break;
                case 185 :
                    // InternalPerl.g:1966:3: kw= 'substr'
                    {
                    kw=(Token)match(input,209,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSubstrKeyword_184());
                      		
                    }

                    }
                    break;
                case 186 :
                    // InternalPerl.g:1972:3: kw= 'symlink'
                    {
                    kw=(Token)match(input,210,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSymlinkKeyword_185());
                      		
                    }

                    }
                    break;
                case 187 :
                    // InternalPerl.g:1978:3: kw= 'syscall'
                    {
                    kw=(Token)match(input,211,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSyscallKeyword_186());
                      		
                    }

                    }
                    break;
                case 188 :
                    // InternalPerl.g:1984:3: kw= 'sysopen'
                    {
                    kw=(Token)match(input,212,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSysopenKeyword_187());
                      		
                    }

                    }
                    break;
                case 189 :
                    // InternalPerl.g:1990:3: kw= 'sysread'
                    {
                    kw=(Token)match(input,213,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSysreadKeyword_188());
                      		
                    }

                    }
                    break;
                case 190 :
                    // InternalPerl.g:1996:3: kw= 'sysseek'
                    {
                    kw=(Token)match(input,214,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSysseekKeyword_189());
                      		
                    }

                    }
                    break;
                case 191 :
                    // InternalPerl.g:2002:3: kw= 'system'
                    {
                    kw=(Token)match(input,215,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSystemKeyword_190());
                      		
                    }

                    }
                    break;
                case 192 :
                    // InternalPerl.g:2008:3: kw= 'syswrite'
                    {
                    kw=(Token)match(input,216,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getSyswriteKeyword_191());
                      		
                    }

                    }
                    break;
                case 193 :
                    // InternalPerl.g:2014:3: kw= 'tell'
                    {
                    kw=(Token)match(input,217,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getTellKeyword_192());
                      		
                    }

                    }
                    break;
                case 194 :
                    // InternalPerl.g:2020:3: kw= 'telldir'
                    {
                    kw=(Token)match(input,218,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getTelldirKeyword_193());
                      		
                    }

                    }
                    break;
                case 195 :
                    // InternalPerl.g:2026:3: kw= 'tie'
                    {
                    kw=(Token)match(input,219,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getTieKeyword_194());
                      		
                    }

                    }
                    break;
                case 196 :
                    // InternalPerl.g:2032:3: kw= 'tied'
                    {
                    kw=(Token)match(input,220,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getTiedKeyword_195());
                      		
                    }

                    }
                    break;
                case 197 :
                    // InternalPerl.g:2038:3: kw= 'time'
                    {
                    kw=(Token)match(input,221,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getTimeKeyword_196());
                      		
                    }

                    }
                    break;
                case 198 :
                    // InternalPerl.g:2044:3: kw= 'times'
                    {
                    kw=(Token)match(input,222,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getTimesKeyword_197());
                      		
                    }

                    }
                    break;
                case 199 :
                    // InternalPerl.g:2050:3: kw= 'tr'
                    {
                    kw=(Token)match(input,223,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getTrKeyword_198());
                      		
                    }

                    }
                    break;
                case 200 :
                    // InternalPerl.g:2056:3: kw= 'truncate'
                    {
                    kw=(Token)match(input,224,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getTruncateKeyword_199());
                      		
                    }

                    }
                    break;
                case 201 :
                    // InternalPerl.g:2062:3: kw= 'uc'
                    {
                    kw=(Token)match(input,225,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUcKeyword_200());
                      		
                    }

                    }
                    break;
                case 202 :
                    // InternalPerl.g:2068:3: kw= 'ucfirst'
                    {
                    kw=(Token)match(input,226,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUcfirstKeyword_201());
                      		
                    }

                    }
                    break;
                case 203 :
                    // InternalPerl.g:2074:3: kw= 'umask'
                    {
                    kw=(Token)match(input,227,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUmaskKeyword_202());
                      		
                    }

                    }
                    break;
                case 204 :
                    // InternalPerl.g:2080:3: kw= 'undef'
                    {
                    kw=(Token)match(input,228,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUndefKeyword_203());
                      		
                    }

                    }
                    break;
                case 205 :
                    // InternalPerl.g:2086:3: kw= 'unless'
                    {
                    kw=(Token)match(input,229,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUnlessKeyword_204());
                      		
                    }

                    }
                    break;
                case 206 :
                    // InternalPerl.g:2092:3: kw= 'unlink'
                    {
                    kw=(Token)match(input,230,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUnlinkKeyword_205());
                      		
                    }

                    }
                    break;
                case 207 :
                    // InternalPerl.g:2098:3: kw= 'unpack'
                    {
                    kw=(Token)match(input,231,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUnpackKeyword_206());
                      		
                    }

                    }
                    break;
                case 208 :
                    // InternalPerl.g:2104:3: kw= 'unshift'
                    {
                    kw=(Token)match(input,232,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUnshiftKeyword_207());
                      		
                    }

                    }
                    break;
                case 209 :
                    // InternalPerl.g:2110:3: kw= 'untie'
                    {
                    kw=(Token)match(input,233,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUntieKeyword_208());
                      		
                    }

                    }
                    break;
                case 210 :
                    // InternalPerl.g:2116:3: kw= 'until'
                    {
                    kw=(Token)match(input,234,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUntilKeyword_209());
                      		
                    }

                    }
                    break;
                case 211 :
                    // InternalPerl.g:2122:3: kw= 'use'
                    {
                    kw=(Token)match(input,235,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUseKeyword_210());
                      		
                    }

                    }
                    break;
                case 212 :
                    // InternalPerl.g:2128:3: kw= 'utime'
                    {
                    kw=(Token)match(input,236,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getUtimeKeyword_211());
                      		
                    }

                    }
                    break;
                case 213 :
                    // InternalPerl.g:2134:3: kw= 'values'
                    {
                    kw=(Token)match(input,237,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getValuesKeyword_212());
                      		
                    }

                    }
                    break;
                case 214 :
                    // InternalPerl.g:2140:3: kw= 'vec'
                    {
                    kw=(Token)match(input,238,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getVecKeyword_213());
                      		
                    }

                    }
                    break;
                case 215 :
                    // InternalPerl.g:2146:3: kw= 'wait'
                    {
                    kw=(Token)match(input,239,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getWaitKeyword_214());
                      		
                    }

                    }
                    break;
                case 216 :
                    // InternalPerl.g:2152:3: kw= 'waitpid'
                    {
                    kw=(Token)match(input,240,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getWaitpidKeyword_215());
                      		
                    }

                    }
                    break;
                case 217 :
                    // InternalPerl.g:2158:3: kw= 'wantarray'
                    {
                    kw=(Token)match(input,241,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getWantarrayKeyword_216());
                      		
                    }

                    }
                    break;
                case 218 :
                    // InternalPerl.g:2164:3: kw= 'warn'
                    {
                    kw=(Token)match(input,242,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getWarnKeyword_217());
                      		
                    }

                    }
                    break;
                case 219 :
                    // InternalPerl.g:2170:3: kw= 'when'
                    {
                    kw=(Token)match(input,243,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getWhenKeyword_218());
                      		
                    }

                    }
                    break;
                case 220 :
                    // InternalPerl.g:2176:3: kw= 'while'
                    {
                    kw=(Token)match(input,244,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getWhileKeyword_219());
                      		
                    }

                    }
                    break;
                case 221 :
                    // InternalPerl.g:2182:3: kw= 'write'
                    {
                    kw=(Token)match(input,245,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getWriteKeyword_220());
                      		
                    }

                    }
                    break;
                case 222 :
                    // InternalPerl.g:2188:3: kw= 'y'
                    {
                    kw=(Token)match(input,246,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKeywordAccess().getYKeyword_221());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleOperator"
    // InternalPerl.g:2197:1: entryRuleOperator returns [String current=null] : iv_ruleOperator= ruleOperator EOF ;
    public final String entryRuleOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOperator = null;


        try {
            // InternalPerl.g:2197:48: (iv_ruleOperator= ruleOperator EOF )
            // InternalPerl.g:2198:2: iv_ruleOperator= ruleOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOperator=ruleOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:2204:1: ruleOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' | kw= '--' | kw= '**' | kw= '!' | kw= '~' | kw= '+' | kw= '-' | kw= '=~' | kw= '!~' | kw= '*' | kw= '/' | kw= '%' | kw= 'x' | kw= '<<' | kw= '>>' | kw= 'lt' | kw= 'gt' | kw= 'le' | kw= 'ge' | kw= 'cmp' | kw= '~~' | kw= '==' | kw= '!=' | (kw= '<=>' kw= '.' ) | kw= '..' | kw= '...' | kw= ',' | kw= '&' | kw= '|' | kw= '^' | kw= '&&' | kw= '||' | kw= '//' | kw= '?' | kw= ':' | kw= '**=' | kw= '+=' | kw= '-=' | kw= '.=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= 'x=' | kw= '&=' | kw= '|=' | kw= '^=' | kw= '<<=' | kw= '>>=' | kw= '&&=' | kw= '||=' | kw= '//=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '<>' | kw= '=>' | kw= '->' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'not' | kw= 'eq' | kw= 'ne' ) ;
    public final AntlrDatatypeRuleToken ruleOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:2210:2: ( (kw= '++' | kw= '--' | kw= '**' | kw= '!' | kw= '~' | kw= '+' | kw= '-' | kw= '=~' | kw= '!~' | kw= '*' | kw= '/' | kw= '%' | kw= 'x' | kw= '<<' | kw= '>>' | kw= 'lt' | kw= 'gt' | kw= 'le' | kw= 'ge' | kw= 'cmp' | kw= '~~' | kw= '==' | kw= '!=' | (kw= '<=>' kw= '.' ) | kw= '..' | kw= '...' | kw= ',' | kw= '&' | kw= '|' | kw= '^' | kw= '&&' | kw= '||' | kw= '//' | kw= '?' | kw= ':' | kw= '**=' | kw= '+=' | kw= '-=' | kw= '.=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= 'x=' | kw= '&=' | kw= '|=' | kw= '^=' | kw= '<<=' | kw= '>>=' | kw= '&&=' | kw= '||=' | kw= '//=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '<>' | kw= '=>' | kw= '->' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'not' | kw= 'eq' | kw= 'ne' ) )
            // InternalPerl.g:2211:2: (kw= '++' | kw= '--' | kw= '**' | kw= '!' | kw= '~' | kw= '+' | kw= '-' | kw= '=~' | kw= '!~' | kw= '*' | kw= '/' | kw= '%' | kw= 'x' | kw= '<<' | kw= '>>' | kw= 'lt' | kw= 'gt' | kw= 'le' | kw= 'ge' | kw= 'cmp' | kw= '~~' | kw= '==' | kw= '!=' | (kw= '<=>' kw= '.' ) | kw= '..' | kw= '...' | kw= ',' | kw= '&' | kw= '|' | kw= '^' | kw= '&&' | kw= '||' | kw= '//' | kw= '?' | kw= ':' | kw= '**=' | kw= '+=' | kw= '-=' | kw= '.=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= 'x=' | kw= '&=' | kw= '|=' | kw= '^=' | kw= '<<=' | kw= '>>=' | kw= '&&=' | kw= '||=' | kw= '//=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '<>' | kw= '=>' | kw= '->' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'not' | kw= 'eq' | kw= 'ne' )
            {
            // InternalPerl.g:2211:2: (kw= '++' | kw= '--' | kw= '**' | kw= '!' | kw= '~' | kw= '+' | kw= '-' | kw= '=~' | kw= '!~' | kw= '*' | kw= '/' | kw= '%' | kw= 'x' | kw= '<<' | kw= '>>' | kw= 'lt' | kw= 'gt' | kw= 'le' | kw= 'ge' | kw= 'cmp' | kw= '~~' | kw= '==' | kw= '!=' | (kw= '<=>' kw= '.' ) | kw= '..' | kw= '...' | kw= ',' | kw= '&' | kw= '|' | kw= '^' | kw= '&&' | kw= '||' | kw= '//' | kw= '?' | kw= ':' | kw= '**=' | kw= '+=' | kw= '-=' | kw= '.=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= 'x=' | kw= '&=' | kw= '|=' | kw= '^=' | kw= '<<=' | kw= '>>=' | kw= '&&=' | kw= '||=' | kw= '//=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '<>' | kw= '=>' | kw= '->' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'not' | kw= 'eq' | kw= 'ne' )
            int alt9=64;
            switch ( input.LA(1) ) {
            case 247:
                {
                alt9=1;
                }
                break;
            case 248:
                {
                alt9=2;
                }
                break;
            case 249:
                {
                alt9=3;
                }
                break;
            case 250:
                {
                alt9=4;
                }
                break;
            case 251:
                {
                alt9=5;
                }
                break;
            case 252:
                {
                alt9=6;
                }
                break;
            case 253:
                {
                alt9=7;
                }
                break;
            case 254:
                {
                alt9=8;
                }
                break;
            case 255:
                {
                alt9=9;
                }
                break;
            case 256:
                {
                alt9=10;
                }
                break;
            case 257:
                {
                alt9=11;
                }
                break;
            case 258:
                {
                alt9=12;
                }
                break;
            case 259:
                {
                alt9=13;
                }
                break;
            case 260:
                {
                alt9=14;
                }
                break;
            case 261:
                {
                alt9=15;
                }
                break;
            case 262:
                {
                alt9=16;
                }
                break;
            case 263:
                {
                alt9=17;
                }
                break;
            case 264:
                {
                alt9=18;
                }
                break;
            case 265:
                {
                alt9=19;
                }
                break;
            case 266:
                {
                alt9=20;
                }
                break;
            case 267:
                {
                alt9=21;
                }
                break;
            case 268:
                {
                alt9=22;
                }
                break;
            case 269:
                {
                alt9=23;
                }
                break;
            case 270:
                {
                alt9=24;
                }
                break;
            case 272:
                {
                alt9=25;
                }
                break;
            case 273:
                {
                alt9=26;
                }
                break;
            case 274:
                {
                alt9=27;
                }
                break;
            case 275:
                {
                alt9=28;
                }
                break;
            case 276:
                {
                alt9=29;
                }
                break;
            case 277:
                {
                alt9=30;
                }
                break;
            case 278:
                {
                alt9=31;
                }
                break;
            case 279:
                {
                alt9=32;
                }
                break;
            case 280:
                {
                alt9=33;
                }
                break;
            case 281:
                {
                alt9=34;
                }
                break;
            case 282:
                {
                alt9=35;
                }
                break;
            case 283:
                {
                alt9=36;
                }
                break;
            case 284:
                {
                alt9=37;
                }
                break;
            case 285:
                {
                alt9=38;
                }
                break;
            case 286:
                {
                alt9=39;
                }
                break;
            case 287:
                {
                alt9=40;
                }
                break;
            case 288:
                {
                alt9=41;
                }
                break;
            case 289:
                {
                alt9=42;
                }
                break;
            case 290:
                {
                alt9=43;
                }
                break;
            case 291:
                {
                alt9=44;
                }
                break;
            case 292:
                {
                alt9=45;
                }
                break;
            case 293:
                {
                alt9=46;
                }
                break;
            case 294:
                {
                alt9=47;
                }
                break;
            case 295:
                {
                alt9=48;
                }
                break;
            case 296:
                {
                alt9=49;
                }
                break;
            case 297:
                {
                alt9=50;
                }
                break;
            case 298:
                {
                alt9=51;
                }
                break;
            case 299:
                {
                alt9=52;
                }
                break;
            case 300:
                {
                alt9=53;
                }
                break;
            case 301:
                {
                alt9=54;
                }
                break;
            case 302:
                {
                alt9=55;
                }
                break;
            case 303:
                {
                alt9=56;
                }
                break;
            case 304:
                {
                alt9=57;
                }
                break;
            case 305:
                {
                alt9=58;
                }
                break;
            case 306:
                {
                alt9=59;
                }
                break;
            case 307:
                {
                alt9=60;
                }
                break;
            case 308:
                {
                alt9=61;
                }
                break;
            case 309:
                {
                alt9=62;
                }
                break;
            case 310:
                {
                alt9=63;
                }
                break;
            case 311:
                {
                alt9=64;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalPerl.g:2212:3: kw= '++'
                    {
                    kw=(Token)match(input,247,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getPlusSignPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:2218:3: kw= '--'
                    {
                    kw=(Token)match(input,248,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getHyphenMinusHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:2224:3: kw= '**'
                    {
                    kw=(Token)match(input,249,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getAsteriskAsteriskKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:2230:3: kw= '!'
                    {
                    kw=(Token)match(input,250,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getExclamationMarkKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalPerl.g:2236:3: kw= '~'
                    {
                    kw=(Token)match(input,251,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getTildeKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalPerl.g:2242:3: kw= '+'
                    {
                    kw=(Token)match(input,252,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getPlusSignKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalPerl.g:2248:3: kw= '-'
                    {
                    kw=(Token)match(input,253,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getHyphenMinusKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalPerl.g:2254:3: kw= '=~'
                    {
                    kw=(Token)match(input,254,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getEqualsSignTildeKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalPerl.g:2260:3: kw= '!~'
                    {
                    kw=(Token)match(input,255,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getExclamationMarkTildeKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalPerl.g:2266:3: kw= '*'
                    {
                    kw=(Token)match(input,256,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getAsteriskKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalPerl.g:2272:3: kw= '/'
                    {
                    kw=(Token)match(input,257,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getSolidusKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalPerl.g:2278:3: kw= '%'
                    {
                    kw=(Token)match(input,258,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getPercentSignKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalPerl.g:2284:3: kw= 'x'
                    {
                    kw=(Token)match(input,259,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getXKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalPerl.g:2290:3: kw= '<<'
                    {
                    kw=(Token)match(input,260,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignLessThanSignKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalPerl.g:2296:3: kw= '>>'
                    {
                    kw=(Token)match(input,261,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalPerl.g:2302:3: kw= 'lt'
                    {
                    kw=(Token)match(input,262,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getLtKeyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalPerl.g:2308:3: kw= 'gt'
                    {
                    kw=(Token)match(input,263,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getGtKeyword_16());
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalPerl.g:2314:3: kw= 'le'
                    {
                    kw=(Token)match(input,264,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getLeKeyword_17());
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalPerl.g:2320:3: kw= 'ge'
                    {
                    kw=(Token)match(input,265,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getGeKeyword_18());
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalPerl.g:2326:3: kw= 'cmp'
                    {
                    kw=(Token)match(input,266,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getCmpKeyword_19());
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalPerl.g:2332:3: kw= '~~'
                    {
                    kw=(Token)match(input,267,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getTildeTildeKeyword_20());
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalPerl.g:2338:3: kw= '=='
                    {
                    kw=(Token)match(input,268,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_21());
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalPerl.g:2344:3: kw= '!='
                    {
                    kw=(Token)match(input,269,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_22());
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalPerl.g:2350:3: (kw= '<=>' kw= '.' )
                    {
                    // InternalPerl.g:2350:3: (kw= '<=>' kw= '.' )
                    // InternalPerl.g:2351:4: kw= '<=>' kw= '.'
                    {
                    kw=(Token)match(input,270,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_23_0());
                      			
                    }
                    kw=(Token)match(input,271,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOperatorAccess().getFullStopKeyword_23_1());
                      			
                    }

                    }


                    }
                    break;
                case 25 :
                    // InternalPerl.g:2363:3: kw= '..'
                    {
                    kw=(Token)match(input,272,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getFullStopFullStopKeyword_24());
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalPerl.g:2369:3: kw= '...'
                    {
                    kw=(Token)match(input,273,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getFullStopFullStopFullStopKeyword_25());
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalPerl.g:2375:3: kw= ','
                    {
                    kw=(Token)match(input,274,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getCommaKeyword_26());
                      		
                    }

                    }
                    break;
                case 28 :
                    // InternalPerl.g:2381:3: kw= '&'
                    {
                    kw=(Token)match(input,275,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getAmpersandKeyword_27());
                      		
                    }

                    }
                    break;
                case 29 :
                    // InternalPerl.g:2387:3: kw= '|'
                    {
                    kw=(Token)match(input,276,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getVerticalLineKeyword_28());
                      		
                    }

                    }
                    break;
                case 30 :
                    // InternalPerl.g:2393:3: kw= '^'
                    {
                    kw=(Token)match(input,277,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_29());
                      		
                    }

                    }
                    break;
                case 31 :
                    // InternalPerl.g:2399:3: kw= '&&'
                    {
                    kw=(Token)match(input,278,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getAmpersandAmpersandKeyword_30());
                      		
                    }

                    }
                    break;
                case 32 :
                    // InternalPerl.g:2405:3: kw= '||'
                    {
                    kw=(Token)match(input,279,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getVerticalLineVerticalLineKeyword_31());
                      		
                    }

                    }
                    break;
                case 33 :
                    // InternalPerl.g:2411:3: kw= '//'
                    {
                    kw=(Token)match(input,280,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getSolidusSolidusKeyword_32());
                      		
                    }

                    }
                    break;
                case 34 :
                    // InternalPerl.g:2417:3: kw= '?'
                    {
                    kw=(Token)match(input,281,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getQuestionMarkKeyword_33());
                      		
                    }

                    }
                    break;
                case 35 :
                    // InternalPerl.g:2423:3: kw= ':'
                    {
                    kw=(Token)match(input,282,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getColonKeyword_34());
                      		
                    }

                    }
                    break;
                case 36 :
                    // InternalPerl.g:2429:3: kw= '**='
                    {
                    kw=(Token)match(input,283,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getAsteriskAsteriskEqualsSignKeyword_35());
                      		
                    }

                    }
                    break;
                case 37 :
                    // InternalPerl.g:2435:3: kw= '+='
                    {
                    kw=(Token)match(input,284,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getPlusSignEqualsSignKeyword_36());
                      		
                    }

                    }
                    break;
                case 38 :
                    // InternalPerl.g:2441:3: kw= '-='
                    {
                    kw=(Token)match(input,285,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getHyphenMinusEqualsSignKeyword_37());
                      		
                    }

                    }
                    break;
                case 39 :
                    // InternalPerl.g:2447:3: kw= '.='
                    {
                    kw=(Token)match(input,286,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getFullStopEqualsSignKeyword_38());
                      		
                    }

                    }
                    break;
                case 40 :
                    // InternalPerl.g:2453:3: kw= '*='
                    {
                    kw=(Token)match(input,287,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getAsteriskEqualsSignKeyword_39());
                      		
                    }

                    }
                    break;
                case 41 :
                    // InternalPerl.g:2459:3: kw= '/='
                    {
                    kw=(Token)match(input,288,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getSolidusEqualsSignKeyword_40());
                      		
                    }

                    }
                    break;
                case 42 :
                    // InternalPerl.g:2465:3: kw= '%='
                    {
                    kw=(Token)match(input,289,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getPercentSignEqualsSignKeyword_41());
                      		
                    }

                    }
                    break;
                case 43 :
                    // InternalPerl.g:2471:3: kw= 'x='
                    {
                    kw=(Token)match(input,290,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getXKeyword_42());
                      		
                    }

                    }
                    break;
                case 44 :
                    // InternalPerl.g:2477:3: kw= '&='
                    {
                    kw=(Token)match(input,291,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getAmpersandEqualsSignKeyword_43());
                      		
                    }

                    }
                    break;
                case 45 :
                    // InternalPerl.g:2483:3: kw= '|='
                    {
                    kw=(Token)match(input,292,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getVerticalLineEqualsSignKeyword_44());
                      		
                    }

                    }
                    break;
                case 46 :
                    // InternalPerl.g:2489:3: kw= '^='
                    {
                    kw=(Token)match(input,293,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getCircumflexAccentEqualsSignKeyword_45());
                      		
                    }

                    }
                    break;
                case 47 :
                    // InternalPerl.g:2495:3: kw= '<<='
                    {
                    kw=(Token)match(input,294,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignLessThanSignEqualsSignKeyword_46());
                      		
                    }

                    }
                    break;
                case 48 :
                    // InternalPerl.g:2501:3: kw= '>>='
                    {
                    kw=(Token)match(input,295,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getGreaterThanSignGreaterThanSignEqualsSignKeyword_47());
                      		
                    }

                    }
                    break;
                case 49 :
                    // InternalPerl.g:2507:3: kw= '&&='
                    {
                    kw=(Token)match(input,296,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getAmpersandAmpersandEqualsSignKeyword_48());
                      		
                    }

                    }
                    break;
                case 50 :
                    // InternalPerl.g:2513:3: kw= '||='
                    {
                    kw=(Token)match(input,297,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getVerticalLineVerticalLineEqualsSignKeyword_49());
                      		
                    }

                    }
                    break;
                case 51 :
                    // InternalPerl.g:2519:3: kw= '//='
                    {
                    kw=(Token)match(input,298,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getSolidusSolidusEqualsSignKeyword_50());
                      		
                    }

                    }
                    break;
                case 52 :
                    // InternalPerl.g:2525:3: kw= '<'
                    {
                    kw=(Token)match(input,299,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignKeyword_51());
                      		
                    }

                    }
                    break;
                case 53 :
                    // InternalPerl.g:2531:3: kw= '>'
                    {
                    kw=(Token)match(input,300,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_52());
                      		
                    }

                    }
                    break;
                case 54 :
                    // InternalPerl.g:2537:3: kw= '<='
                    {
                    kw=(Token)match(input,301,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_53());
                      		
                    }

                    }
                    break;
                case 55 :
                    // InternalPerl.g:2543:3: kw= '>='
                    {
                    kw=(Token)match(input,302,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_54());
                      		
                    }

                    }
                    break;
                case 56 :
                    // InternalPerl.g:2549:3: kw= '<>'
                    {
                    kw=(Token)match(input,303,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignGreaterThanSignKeyword_55());
                      		
                    }

                    }
                    break;
                case 57 :
                    // InternalPerl.g:2555:3: kw= '=>'
                    {
                    kw=(Token)match(input,304,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getEqualsSignGreaterThanSignKeyword_56());
                      		
                    }

                    }
                    break;
                case 58 :
                    // InternalPerl.g:2561:3: kw= '->'
                    {
                    kw=(Token)match(input,305,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getHyphenMinusGreaterThanSignKeyword_57());
                      		
                    }

                    }
                    break;
                case 59 :
                    // InternalPerl.g:2567:3: kw= 'and'
                    {
                    kw=(Token)match(input,306,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getAndKeyword_58());
                      		
                    }

                    }
                    break;
                case 60 :
                    // InternalPerl.g:2573:3: kw= 'or'
                    {
                    kw=(Token)match(input,307,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getOrKeyword_59());
                      		
                    }

                    }
                    break;
                case 61 :
                    // InternalPerl.g:2579:3: kw= 'xor'
                    {
                    kw=(Token)match(input,308,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getXorKeyword_60());
                      		
                    }

                    }
                    break;
                case 62 :
                    // InternalPerl.g:2585:3: kw= 'not'
                    {
                    kw=(Token)match(input,309,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getNotKeyword_61());
                      		
                    }

                    }
                    break;
                case 63 :
                    // InternalPerl.g:2591:3: kw= 'eq'
                    {
                    kw=(Token)match(input,310,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getEqKeyword_62());
                      		
                    }

                    }
                    break;
                case 64 :
                    // InternalPerl.g:2597:3: kw= 'ne'
                    {
                    kw=(Token)match(input,311,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOperatorAccess().getNeKeyword_63());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleFileTestOperator"
    // InternalPerl.g:2606:1: entryRuleFileTestOperator returns [String current=null] : iv_ruleFileTestOperator= ruleFileTestOperator EOF ;
    public final String entryRuleFileTestOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFileTestOperator = null;


        try {
            // InternalPerl.g:2606:56: (iv_ruleFileTestOperator= ruleFileTestOperator EOF )
            // InternalPerl.g:2607:2: iv_ruleFileTestOperator= ruleFileTestOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFileTestOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFileTestOperator=ruleFileTestOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFileTestOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalPerl.g:2613:1: ruleFileTestOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-r' | kw= '-w' | kw= '-x' | kw= '-o' | kw= '-R' | kw= '-W' | kw= '-X' | kw= '-O' | kw= '-e' | kw= '-z' | kw= '-s' | kw= '-f' | kw= '-d' | kw= '-l' | kw= '-p' | kw= '-S' | kw= '-b' | kw= '-c' | kw= '-t' | kw= '-u' | kw= '-g' | kw= '-k' | kw= '-T' | kw= '-B' | kw= '-M' | kw= '-A' | kw= '-C' ) ;
    public final AntlrDatatypeRuleToken ruleFileTestOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:2619:2: ( (kw= '-r' | kw= '-w' | kw= '-x' | kw= '-o' | kw= '-R' | kw= '-W' | kw= '-X' | kw= '-O' | kw= '-e' | kw= '-z' | kw= '-s' | kw= '-f' | kw= '-d' | kw= '-l' | kw= '-p' | kw= '-S' | kw= '-b' | kw= '-c' | kw= '-t' | kw= '-u' | kw= '-g' | kw= '-k' | kw= '-T' | kw= '-B' | kw= '-M' | kw= '-A' | kw= '-C' ) )
            // InternalPerl.g:2620:2: (kw= '-r' | kw= '-w' | kw= '-x' | kw= '-o' | kw= '-R' | kw= '-W' | kw= '-X' | kw= '-O' | kw= '-e' | kw= '-z' | kw= '-s' | kw= '-f' | kw= '-d' | kw= '-l' | kw= '-p' | kw= '-S' | kw= '-b' | kw= '-c' | kw= '-t' | kw= '-u' | kw= '-g' | kw= '-k' | kw= '-T' | kw= '-B' | kw= '-M' | kw= '-A' | kw= '-C' )
            {
            // InternalPerl.g:2620:2: (kw= '-r' | kw= '-w' | kw= '-x' | kw= '-o' | kw= '-R' | kw= '-W' | kw= '-X' | kw= '-O' | kw= '-e' | kw= '-z' | kw= '-s' | kw= '-f' | kw= '-d' | kw= '-l' | kw= '-p' | kw= '-S' | kw= '-b' | kw= '-c' | kw= '-t' | kw= '-u' | kw= '-g' | kw= '-k' | kw= '-T' | kw= '-B' | kw= '-M' | kw= '-A' | kw= '-C' )
            int alt10=27;
            switch ( input.LA(1) ) {
            case 312:
                {
                alt10=1;
                }
                break;
            case 313:
                {
                alt10=2;
                }
                break;
            case 314:
                {
                alt10=3;
                }
                break;
            case 315:
                {
                alt10=4;
                }
                break;
            case 316:
                {
                alt10=5;
                }
                break;
            case 317:
                {
                alt10=6;
                }
                break;
            case 318:
                {
                alt10=7;
                }
                break;
            case 319:
                {
                alt10=8;
                }
                break;
            case 320:
                {
                alt10=9;
                }
                break;
            case 321:
                {
                alt10=10;
                }
                break;
            case 322:
                {
                alt10=11;
                }
                break;
            case 323:
                {
                alt10=12;
                }
                break;
            case 324:
                {
                alt10=13;
                }
                break;
            case 325:
                {
                alt10=14;
                }
                break;
            case 326:
                {
                alt10=15;
                }
                break;
            case 327:
                {
                alt10=16;
                }
                break;
            case 328:
                {
                alt10=17;
                }
                break;
            case 329:
                {
                alt10=18;
                }
                break;
            case 330:
                {
                alt10=19;
                }
                break;
            case 331:
                {
                alt10=20;
                }
                break;
            case 332:
                {
                alt10=21;
                }
                break;
            case 333:
                {
                alt10=22;
                }
                break;
            case 334:
                {
                alt10=23;
                }
                break;
            case 335:
                {
                alt10=24;
                }
                break;
            case 336:
                {
                alt10=25;
                }
                break;
            case 337:
                {
                alt10=26;
                }
                break;
            case 338:
                {
                alt10=27;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalPerl.g:2621:3: kw= '-r'
                    {
                    kw=(Token)match(input,312,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getRKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:2627:3: kw= '-w'
                    {
                    kw=(Token)match(input,313,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getWKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:2633:3: kw= '-x'
                    {
                    kw=(Token)match(input,314,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getXKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:2639:3: kw= '-o'
                    {
                    kw=(Token)match(input,315,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getOKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalPerl.g:2645:3: kw= '-R'
                    {
                    kw=(Token)match(input,316,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getRKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalPerl.g:2651:3: kw= '-W'
                    {
                    kw=(Token)match(input,317,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getWKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalPerl.g:2657:3: kw= '-X'
                    {
                    kw=(Token)match(input,318,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getXKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalPerl.g:2663:3: kw= '-O'
                    {
                    kw=(Token)match(input,319,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getOKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalPerl.g:2669:3: kw= '-e'
                    {
                    kw=(Token)match(input,320,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getEKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalPerl.g:2675:3: kw= '-z'
                    {
                    kw=(Token)match(input,321,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getZKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalPerl.g:2681:3: kw= '-s'
                    {
                    kw=(Token)match(input,322,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getSKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalPerl.g:2687:3: kw= '-f'
                    {
                    kw=(Token)match(input,323,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getFKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalPerl.g:2693:3: kw= '-d'
                    {
                    kw=(Token)match(input,324,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getDKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalPerl.g:2699:3: kw= '-l'
                    {
                    kw=(Token)match(input,325,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getLKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalPerl.g:2705:3: kw= '-p'
                    {
                    kw=(Token)match(input,326,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getPKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalPerl.g:2711:3: kw= '-S'
                    {
                    kw=(Token)match(input,327,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getSKeyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalPerl.g:2717:3: kw= '-b'
                    {
                    kw=(Token)match(input,328,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getBKeyword_16());
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalPerl.g:2723:3: kw= '-c'
                    {
                    kw=(Token)match(input,329,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getCKeyword_17());
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalPerl.g:2729:3: kw= '-t'
                    {
                    kw=(Token)match(input,330,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getTKeyword_18());
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalPerl.g:2735:3: kw= '-u'
                    {
                    kw=(Token)match(input,331,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getUKeyword_19());
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalPerl.g:2741:3: kw= '-g'
                    {
                    kw=(Token)match(input,332,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getGKeyword_20());
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalPerl.g:2747:3: kw= '-k'
                    {
                    kw=(Token)match(input,333,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getKKeyword_21());
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalPerl.g:2753:3: kw= '-T'
                    {
                    kw=(Token)match(input,334,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getTKeyword_22());
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalPerl.g:2759:3: kw= '-B'
                    {
                    kw=(Token)match(input,335,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getBKeyword_23());
                      		
                    }

                    }
                    break;
                case 25 :
                    // InternalPerl.g:2765:3: kw= '-M'
                    {
                    kw=(Token)match(input,336,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getMKeyword_24());
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalPerl.g:2771:3: kw= '-A'
                    {
                    kw=(Token)match(input,337,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getAKeyword_25());
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalPerl.g:2777:3: kw= '-C'
                    {
                    kw=(Token)match(input,338,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFileTestOperatorAccess().getCKeyword_26());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFileTestOperator"


    // $ANTLR start "entryRuleNumber"
    // InternalPerl.g:2786:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:2788:2: (iv_ruleNumber= ruleNumber EOF )
            // InternalPerl.g:2789:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalPerl.g:2798:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) (kw= '.' this_INT_4= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;
        Token this_BIN_1=null;
        Token this_INT_2=null;
        Token kw=null;
        Token this_INT_4=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:2805:2: ( ( (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) (kw= '.' this_INT_4= RULE_INT )? ) )
            // InternalPerl.g:2806:2: ( (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) (kw= '.' this_INT_4= RULE_INT )? )
            {
            // InternalPerl.g:2806:2: ( (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) (kw= '.' this_INT_4= RULE_INT )? )
            // InternalPerl.g:2807:3: (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) (kw= '.' this_INT_4= RULE_INT )?
            {
            // InternalPerl.g:2807:3: (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT )
            int alt11=3;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt11=1;
                }
                break;
            case RULE_BIN:
                {
                alt11=2;
                }
                break;
            case RULE_INT:
                {
                alt11=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalPerl.g:2808:4: this_HEX_0= RULE_HEX
                    {
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_HEX_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:2816:4: this_BIN_1= RULE_BIN
                    {
                    this_BIN_1=(Token)match(input,RULE_BIN,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_BIN_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BIN_1, grammarAccess.getNumberAccess().getBINTerminalRuleCall_0_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:2824:4: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_2, grammarAccess.getNumberAccess().getINTTerminalRuleCall_0_2());
                      			
                    }

                    }
                    break;

            }

            // InternalPerl.g:2832:3: (kw= '.' this_INT_4= RULE_INT )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==271) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalPerl.g:2833:4: kw= '.' this_INT_4= RULE_INT
                    {
                    kw=(Token)match(input,271,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_0());
                      			
                    }
                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_4);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"

    // $ANTLR start synpred1_InternalPerl
    public final void synpred1_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:265:4: ( ( ( RULE_VERSION ) ) )
        // InternalPerl.g:265:5: ( ( RULE_VERSION ) )
        {
        // InternalPerl.g:265:5: ( ( RULE_VERSION ) )
        // InternalPerl.g:266:5: ( RULE_VERSION )
        {
        // InternalPerl.g:266:5: ( RULE_VERSION )
        // InternalPerl.g:267:6: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred1_InternalPerl

    // Delegated rules

    public final boolean synpred1_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalPerl_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFFFFFFF1FFFE2L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFF7FFFL,0x000000000007FFFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100000L});

}