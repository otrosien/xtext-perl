package org.epic.perl.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPerlLexer extends Lexer {
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

    public InternalPerlLexer() {;} 
    public InternalPerlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalPerlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalPerl.g"; }

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:11:7: ( ';' )
            // InternalPerl.g:11:9: ';'
            {
            match(';'); 

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
            // InternalPerl.g:12:7: ( '$' )
            // InternalPerl.g:12:9: '$'
            {
            match('$'); 

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
            // InternalPerl.g:13:7: ( '%' )
            // InternalPerl.g:13:9: '%'
            {
            match('%'); 

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
            // InternalPerl.g:14:7: ( '@' )
            // InternalPerl.g:14:9: '@'
            {
            match('@'); 

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
            // InternalPerl.g:15:7: ( '&' )
            // InternalPerl.g:15:9: '&'
            {
            match('&'); 

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
            // InternalPerl.g:16:7: ( 'abs' )
            // InternalPerl.g:16:9: 'abs'
            {
            match("abs"); 


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
            // InternalPerl.g:17:7: ( 'accept' )
            // InternalPerl.g:17:9: 'accept'
            {
            match("accept"); 


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
            // InternalPerl.g:18:7: ( 'alarm' )
            // InternalPerl.g:18:9: 'alarm'
            {
            match("alarm"); 


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
            // InternalPerl.g:19:7: ( 'atan2' )
            // InternalPerl.g:19:9: 'atan2'
            {
            match("atan2"); 


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
            // InternalPerl.g:20:7: ( 'bind' )
            // InternalPerl.g:20:9: 'bind'
            {
            match("bind"); 


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
            // InternalPerl.g:21:7: ( 'binmode' )
            // InternalPerl.g:21:9: 'binmode'
            {
            match("binmode"); 


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
            // InternalPerl.g:22:7: ( 'bless' )
            // InternalPerl.g:22:9: 'bless'
            {
            match("bless"); 


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
            // InternalPerl.g:23:7: ( 'break' )
            // InternalPerl.g:23:9: 'break'
            {
            match("break"); 


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
            // InternalPerl.g:24:7: ( 'caller' )
            // InternalPerl.g:24:9: 'caller'
            {
            match("caller"); 


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
            // InternalPerl.g:25:7: ( 'chdir' )
            // InternalPerl.g:25:9: 'chdir'
            {
            match("chdir"); 


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
            // InternalPerl.g:26:7: ( 'chmod' )
            // InternalPerl.g:26:9: 'chmod'
            {
            match("chmod"); 


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
            // InternalPerl.g:27:7: ( 'chomp' )
            // InternalPerl.g:27:9: 'chomp'
            {
            match("chomp"); 


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
            // InternalPerl.g:28:7: ( 'chop' )
            // InternalPerl.g:28:9: 'chop'
            {
            match("chop"); 


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
            // InternalPerl.g:29:7: ( 'chown' )
            // InternalPerl.g:29:9: 'chown'
            {
            match("chown"); 


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
            // InternalPerl.g:30:7: ( 'chr' )
            // InternalPerl.g:30:9: 'chr'
            {
            match("chr"); 


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
            // InternalPerl.g:31:7: ( 'chroot' )
            // InternalPerl.g:31:9: 'chroot'
            {
            match("chroot"); 


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
            // InternalPerl.g:32:7: ( 'close' )
            // InternalPerl.g:32:9: 'close'
            {
            match("close"); 


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
            // InternalPerl.g:33:7: ( 'closedir' )
            // InternalPerl.g:33:9: 'closedir'
            {
            match("closedir"); 


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
            // InternalPerl.g:34:7: ( 'connect' )
            // InternalPerl.g:34:9: 'connect'
            {
            match("connect"); 


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
            // InternalPerl.g:35:7: ( 'continue' )
            // InternalPerl.g:35:9: 'continue'
            {
            match("continue"); 


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
            // InternalPerl.g:36:7: ( 'cos' )
            // InternalPerl.g:36:9: 'cos'
            {
            match("cos"); 


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
            // InternalPerl.g:37:7: ( 'crypt' )
            // InternalPerl.g:37:9: 'crypt'
            {
            match("crypt"); 


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
            // InternalPerl.g:38:7: ( 'dbmclose' )
            // InternalPerl.g:38:9: 'dbmclose'
            {
            match("dbmclose"); 


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
            // InternalPerl.g:39:7: ( 'dbmopen' )
            // InternalPerl.g:39:9: 'dbmopen'
            {
            match("dbmopen"); 


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
            // InternalPerl.g:40:7: ( 'default' )
            // InternalPerl.g:40:9: 'default'
            {
            match("default"); 


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
            // InternalPerl.g:41:7: ( 'defined' )
            // InternalPerl.g:41:9: 'defined'
            {
            match("defined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:42:7: ( 'delete' )
            // InternalPerl.g:42:9: 'delete'
            {
            match("delete"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:43:7: ( 'die' )
            // InternalPerl.g:43:9: 'die'
            {
            match("die"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:44:7: ( 'do' )
            // InternalPerl.g:44:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:45:7: ( 'dump' )
            // InternalPerl.g:45:9: 'dump'
            {
            match("dump"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:46:7: ( 'each' )
            // InternalPerl.g:46:9: 'each'
            {
            match("each"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:47:7: ( 'else' )
            // InternalPerl.g:47:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:48:7: ( 'elsif' )
            // InternalPerl.g:48:9: 'elsif'
            {
            match("elsif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:49:7: ( 'endgrent' )
            // InternalPerl.g:49:9: 'endgrent'
            {
            match("endgrent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:50:7: ( 'endhostent' )
            // InternalPerl.g:50:9: 'endhostent'
            {
            match("endhostent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:51:7: ( 'endnetent' )
            // InternalPerl.g:51:9: 'endnetent'
            {
            match("endnetent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:52:7: ( 'endprotoent' )
            // InternalPerl.g:52:9: 'endprotoent'
            {
            match("endprotoent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:53:7: ( 'endpwent' )
            // InternalPerl.g:53:9: 'endpwent'
            {
            match("endpwent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:54:7: ( 'endservent' )
            // InternalPerl.g:54:9: 'endservent'
            {
            match("endservent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:55:7: ( 'eof' )
            // InternalPerl.g:55:9: 'eof'
            {
            match("eof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:56:7: ( 'eval' )
            // InternalPerl.g:56:9: 'eval'
            {
            match("eval"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:57:7: ( 'evalbytes' )
            // InternalPerl.g:57:9: 'evalbytes'
            {
            match("evalbytes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:58:7: ( 'exec' )
            // InternalPerl.g:58:9: 'exec'
            {
            match("exec"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:59:7: ( 'exists' )
            // InternalPerl.g:59:9: 'exists'
            {
            match("exists"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:60:7: ( 'exit' )
            // InternalPerl.g:60:9: 'exit'
            {
            match("exit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:61:7: ( 'exp' )
            // InternalPerl.g:61:9: 'exp'
            {
            match("exp"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:62:7: ( 'fc' )
            // InternalPerl.g:62:9: 'fc'
            {
            match("fc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:63:7: ( 'fcntl' )
            // InternalPerl.g:63:9: 'fcntl'
            {
            match("fcntl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:64:7: ( 'fileno' )
            // InternalPerl.g:64:9: 'fileno'
            {
            match("fileno"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:65:7: ( 'flock' )
            // InternalPerl.g:65:9: 'flock'
            {
            match("flock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:66:7: ( 'for' )
            // InternalPerl.g:66:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:67:7: ( 'foreach' )
            // InternalPerl.g:67:9: 'foreach'
            {
            match("foreach"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:68:7: ( 'fork' )
            // InternalPerl.g:68:9: 'fork'
            {
            match("fork"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:69:7: ( 'format' )
            // InternalPerl.g:69:9: 'format'
            {
            match("format"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:70:7: ( 'formline' )
            // InternalPerl.g:70:9: 'formline'
            {
            match("formline"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:71:7: ( 'getc' )
            // InternalPerl.g:71:9: 'getc'
            {
            match("getc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:72:7: ( 'getgrent' )
            // InternalPerl.g:72:9: 'getgrent'
            {
            match("getgrent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:73:7: ( 'getgrgid' )
            // InternalPerl.g:73:9: 'getgrgid'
            {
            match("getgrgid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:74:7: ( 'getgrnam' )
            // InternalPerl.g:74:9: 'getgrnam'
            {
            match("getgrnam"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:75:7: ( 'gethostbyaddr' )
            // InternalPerl.g:75:9: 'gethostbyaddr'
            {
            match("gethostbyaddr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:76:7: ( 'gethostbyname' )
            // InternalPerl.g:76:9: 'gethostbyname'
            {
            match("gethostbyname"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:77:7: ( 'gethostent' )
            // InternalPerl.g:77:9: 'gethostent'
            {
            match("gethostent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:78:7: ( 'getlogin' )
            // InternalPerl.g:78:9: 'getlogin'
            {
            match("getlogin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:79:7: ( 'getnetbyaddr' )
            // InternalPerl.g:79:9: 'getnetbyaddr'
            {
            match("getnetbyaddr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:80:7: ( 'getnetbyname' )
            // InternalPerl.g:80:9: 'getnetbyname'
            {
            match("getnetbyname"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:81:7: ( 'getnetent' )
            // InternalPerl.g:81:9: 'getnetent'
            {
            match("getnetent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:82:7: ( 'getpeername' )
            // InternalPerl.g:82:9: 'getpeername'
            {
            match("getpeername"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:83:8: ( 'getpgrp' )
            // InternalPerl.g:83:10: 'getpgrp'
            {
            match("getpgrp"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:84:8: ( 'getppid' )
            // InternalPerl.g:84:10: 'getppid'
            {
            match("getppid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:85:8: ( 'getpriority' )
            // InternalPerl.g:85:10: 'getpriority'
            {
            match("getpriority"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:86:8: ( 'getprotobyname' )
            // InternalPerl.g:86:10: 'getprotobyname'
            {
            match("getprotobyname"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:87:8: ( 'getprotobynumber' )
            // InternalPerl.g:87:10: 'getprotobynumber'
            {
            match("getprotobynumber"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:88:8: ( 'getprotoent' )
            // InternalPerl.g:88:10: 'getprotoent'
            {
            match("getprotoent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:89:8: ( 'getpwent' )
            // InternalPerl.g:89:10: 'getpwent'
            {
            match("getpwent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:90:8: ( 'getpwnam' )
            // InternalPerl.g:90:10: 'getpwnam'
            {
            match("getpwnam"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:91:8: ( 'getpwuid' )
            // InternalPerl.g:91:10: 'getpwuid'
            {
            match("getpwuid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:92:8: ( 'getservbyname' )
            // InternalPerl.g:92:10: 'getservbyname'
            {
            match("getservbyname"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:93:8: ( 'getservbyport' )
            // InternalPerl.g:93:10: 'getservbyport'
            {
            match("getservbyport"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:94:8: ( 'getservent' )
            // InternalPerl.g:94:10: 'getservent'
            {
            match("getservent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:95:8: ( 'getsockname' )
            // InternalPerl.g:95:10: 'getsockname'
            {
            match("getsockname"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:96:8: ( 'getsockopt' )
            // InternalPerl.g:96:10: 'getsockopt'
            {
            match("getsockopt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:97:8: ( 'given' )
            // InternalPerl.g:97:10: 'given'
            {
            match("given"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:98:8: ( 'glob' )
            // InternalPerl.g:98:10: 'glob'
            {
            match("glob"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:99:8: ( 'gmtime' )
            // InternalPerl.g:99:10: 'gmtime'
            {
            match("gmtime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:100:8: ( 'goto' )
            // InternalPerl.g:100:10: 'goto'
            {
            match("goto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:101:8: ( 'grep' )
            // InternalPerl.g:101:10: 'grep'
            {
            match("grep"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:102:8: ( 'hex' )
            // InternalPerl.g:102:10: 'hex'
            {
            match("hex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:103:8: ( 'if' )
            // InternalPerl.g:103:10: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:104:8: ( 'index' )
            // InternalPerl.g:104:10: 'index'
            {
            match("index"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "T__122"
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:105:8: ( 'int' )
            // InternalPerl.g:105:10: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "T__123"
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:106:8: ( 'ioctl' )
            // InternalPerl.g:106:10: 'ioctl'
            {
            match("ioctl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "T__124"
    public final void mT__124() throws RecognitionException {
        try {
            int _type = T__124;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:107:8: ( 'join' )
            // InternalPerl.g:107:10: 'join'
            {
            match("join"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__124"

    // $ANTLR start "T__125"
    public final void mT__125() throws RecognitionException {
        try {
            int _type = T__125;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:108:8: ( 'keys' )
            // InternalPerl.g:108:10: 'keys'
            {
            match("keys"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__125"

    // $ANTLR start "T__126"
    public final void mT__126() throws RecognitionException {
        try {
            int _type = T__126;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:109:8: ( 'kill' )
            // InternalPerl.g:109:10: 'kill'
            {
            match("kill"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__126"

    // $ANTLR start "T__127"
    public final void mT__127() throws RecognitionException {
        try {
            int _type = T__127;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:110:8: ( 'last' )
            // InternalPerl.g:110:10: 'last'
            {
            match("last"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__127"

    // $ANTLR start "T__128"
    public final void mT__128() throws RecognitionException {
        try {
            int _type = T__128;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:111:8: ( 'lc' )
            // InternalPerl.g:111:10: 'lc'
            {
            match("lc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__128"

    // $ANTLR start "T__129"
    public final void mT__129() throws RecognitionException {
        try {
            int _type = T__129;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:112:8: ( 'lcfirst' )
            // InternalPerl.g:112:10: 'lcfirst'
            {
            match("lcfirst"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__129"

    // $ANTLR start "T__130"
    public final void mT__130() throws RecognitionException {
        try {
            int _type = T__130;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:113:8: ( 'length' )
            // InternalPerl.g:113:10: 'length'
            {
            match("length"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__130"

    // $ANTLR start "T__131"
    public final void mT__131() throws RecognitionException {
        try {
            int _type = T__131;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:114:8: ( 'link' )
            // InternalPerl.g:114:10: 'link'
            {
            match("link"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__131"

    // $ANTLR start "T__132"
    public final void mT__132() throws RecognitionException {
        try {
            int _type = T__132;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:115:8: ( 'listen' )
            // InternalPerl.g:115:10: 'listen'
            {
            match("listen"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__132"

    // $ANTLR start "T__133"
    public final void mT__133() throws RecognitionException {
        try {
            int _type = T__133;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:116:8: ( 'local' )
            // InternalPerl.g:116:10: 'local'
            {
            match("local"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__133"

    // $ANTLR start "T__134"
    public final void mT__134() throws RecognitionException {
        try {
            int _type = T__134;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:117:8: ( 'localtime' )
            // InternalPerl.g:117:10: 'localtime'
            {
            match("localtime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__134"

    // $ANTLR start "T__135"
    public final void mT__135() throws RecognitionException {
        try {
            int _type = T__135;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:118:8: ( 'lock' )
            // InternalPerl.g:118:10: 'lock'
            {
            match("lock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__135"

    // $ANTLR start "T__136"
    public final void mT__136() throws RecognitionException {
        try {
            int _type = T__136;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:119:8: ( 'log' )
            // InternalPerl.g:119:10: 'log'
            {
            match("log"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__136"

    // $ANTLR start "T__137"
    public final void mT__137() throws RecognitionException {
        try {
            int _type = T__137;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:120:8: ( 'lstat' )
            // InternalPerl.g:120:10: 'lstat'
            {
            match("lstat"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__137"

    // $ANTLR start "T__138"
    public final void mT__138() throws RecognitionException {
        try {
            int _type = T__138;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:121:8: ( 'map' )
            // InternalPerl.g:121:10: 'map'
            {
            match("map"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__138"

    // $ANTLR start "T__139"
    public final void mT__139() throws RecognitionException {
        try {
            int _type = T__139;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:122:8: ( 'mkdir' )
            // InternalPerl.g:122:10: 'mkdir'
            {
            match("mkdir"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__139"

    // $ANTLR start "T__140"
    public final void mT__140() throws RecognitionException {
        try {
            int _type = T__140;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:123:8: ( 'msgctl' )
            // InternalPerl.g:123:10: 'msgctl'
            {
            match("msgctl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__140"

    // $ANTLR start "T__141"
    public final void mT__141() throws RecognitionException {
        try {
            int _type = T__141;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:124:8: ( 'msgget' )
            // InternalPerl.g:124:10: 'msgget'
            {
            match("msgget"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__141"

    // $ANTLR start "T__142"
    public final void mT__142() throws RecognitionException {
        try {
            int _type = T__142;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:125:8: ( 'msgrcv' )
            // InternalPerl.g:125:10: 'msgrcv'
            {
            match("msgrcv"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__142"

    // $ANTLR start "T__143"
    public final void mT__143() throws RecognitionException {
        try {
            int _type = T__143;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:126:8: ( 'msgsnd' )
            // InternalPerl.g:126:10: 'msgsnd'
            {
            match("msgsnd"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__143"

    // $ANTLR start "T__144"
    public final void mT__144() throws RecognitionException {
        try {
            int _type = T__144;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:127:8: ( 'my' )
            // InternalPerl.g:127:10: 'my'
            {
            match("my"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__144"

    // $ANTLR start "T__145"
    public final void mT__145() throws RecognitionException {
        try {
            int _type = T__145;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:128:8: ( 'next' )
            // InternalPerl.g:128:10: 'next'
            {
            match("next"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__145"

    // $ANTLR start "T__146"
    public final void mT__146() throws RecognitionException {
        try {
            int _type = T__146;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:129:8: ( 'no' )
            // InternalPerl.g:129:10: 'no'
            {
            match("no"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__146"

    // $ANTLR start "T__147"
    public final void mT__147() throws RecognitionException {
        try {
            int _type = T__147;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:130:8: ( 'oct' )
            // InternalPerl.g:130:10: 'oct'
            {
            match("oct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__147"

    // $ANTLR start "T__148"
    public final void mT__148() throws RecognitionException {
        try {
            int _type = T__148;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:131:8: ( 'open' )
            // InternalPerl.g:131:10: 'open'
            {
            match("open"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__148"

    // $ANTLR start "T__149"
    public final void mT__149() throws RecognitionException {
        try {
            int _type = T__149;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:132:8: ( 'opendir' )
            // InternalPerl.g:132:10: 'opendir'
            {
            match("opendir"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__149"

    // $ANTLR start "T__150"
    public final void mT__150() throws RecognitionException {
        try {
            int _type = T__150;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:133:8: ( 'ord' )
            // InternalPerl.g:133:10: 'ord'
            {
            match("ord"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__150"

    // $ANTLR start "T__151"
    public final void mT__151() throws RecognitionException {
        try {
            int _type = T__151;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:134:8: ( 'our' )
            // InternalPerl.g:134:10: 'our'
            {
            match("our"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__151"

    // $ANTLR start "T__152"
    public final void mT__152() throws RecognitionException {
        try {
            int _type = T__152;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:135:8: ( 'pack' )
            // InternalPerl.g:135:10: 'pack'
            {
            match("pack"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__152"

    // $ANTLR start "T__153"
    public final void mT__153() throws RecognitionException {
        try {
            int _type = T__153;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:136:8: ( 'package' )
            // InternalPerl.g:136:10: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__153"

    // $ANTLR start "T__154"
    public final void mT__154() throws RecognitionException {
        try {
            int _type = T__154;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:137:8: ( 'pipe' )
            // InternalPerl.g:137:10: 'pipe'
            {
            match("pipe"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__154"

    // $ANTLR start "T__155"
    public final void mT__155() throws RecognitionException {
        try {
            int _type = T__155;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:138:8: ( 'pop' )
            // InternalPerl.g:138:10: 'pop'
            {
            match("pop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__155"

    // $ANTLR start "T__156"
    public final void mT__156() throws RecognitionException {
        try {
            int _type = T__156;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:139:8: ( 'pos' )
            // InternalPerl.g:139:10: 'pos'
            {
            match("pos"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__156"

    // $ANTLR start "T__157"
    public final void mT__157() throws RecognitionException {
        try {
            int _type = T__157;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:140:8: ( 'print' )
            // InternalPerl.g:140:10: 'print'
            {
            match("print"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__157"

    // $ANTLR start "T__158"
    public final void mT__158() throws RecognitionException {
        try {
            int _type = T__158;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:141:8: ( 'printf' )
            // InternalPerl.g:141:10: 'printf'
            {
            match("printf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__158"

    // $ANTLR start "T__159"
    public final void mT__159() throws RecognitionException {
        try {
            int _type = T__159;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:142:8: ( 'prototype' )
            // InternalPerl.g:142:10: 'prototype'
            {
            match("prototype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__159"

    // $ANTLR start "T__160"
    public final void mT__160() throws RecognitionException {
        try {
            int _type = T__160;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:143:8: ( 'push' )
            // InternalPerl.g:143:10: 'push'
            {
            match("push"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__160"

    // $ANTLR start "T__161"
    public final void mT__161() throws RecognitionException {
        try {
            int _type = T__161;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:144:8: ( 'quotemeta' )
            // InternalPerl.g:144:10: 'quotemeta'
            {
            match("quotemeta"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__161"

    // $ANTLR start "T__162"
    public final void mT__162() throws RecognitionException {
        try {
            int _type = T__162;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:145:8: ( 'rand' )
            // InternalPerl.g:145:10: 'rand'
            {
            match("rand"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__162"

    // $ANTLR start "T__163"
    public final void mT__163() throws RecognitionException {
        try {
            int _type = T__163;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:146:8: ( 'read' )
            // InternalPerl.g:146:10: 'read'
            {
            match("read"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__163"

    // $ANTLR start "T__164"
    public final void mT__164() throws RecognitionException {
        try {
            int _type = T__164;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:147:8: ( 'readdir' )
            // InternalPerl.g:147:10: 'readdir'
            {
            match("readdir"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__164"

    // $ANTLR start "T__165"
    public final void mT__165() throws RecognitionException {
        try {
            int _type = T__165;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:148:8: ( 'readline' )
            // InternalPerl.g:148:10: 'readline'
            {
            match("readline"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__165"

    // $ANTLR start "T__166"
    public final void mT__166() throws RecognitionException {
        try {
            int _type = T__166;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:149:8: ( 'readlink' )
            // InternalPerl.g:149:10: 'readlink'
            {
            match("readlink"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__166"

    // $ANTLR start "T__167"
    public final void mT__167() throws RecognitionException {
        try {
            int _type = T__167;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:150:8: ( 'readpipe' )
            // InternalPerl.g:150:10: 'readpipe'
            {
            match("readpipe"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__167"

    // $ANTLR start "T__168"
    public final void mT__168() throws RecognitionException {
        try {
            int _type = T__168;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:151:8: ( 'recv' )
            // InternalPerl.g:151:10: 'recv'
            {
            match("recv"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__168"

    // $ANTLR start "T__169"
    public final void mT__169() throws RecognitionException {
        try {
            int _type = T__169;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:152:8: ( 'redo' )
            // InternalPerl.g:152:10: 'redo'
            {
            match("redo"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__169"

    // $ANTLR start "T__170"
    public final void mT__170() throws RecognitionException {
        try {
            int _type = T__170;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:153:8: ( 'ref' )
            // InternalPerl.g:153:10: 'ref'
            {
            match("ref"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__170"

    // $ANTLR start "T__171"
    public final void mT__171() throws RecognitionException {
        try {
            int _type = T__171;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:154:8: ( 'rename' )
            // InternalPerl.g:154:10: 'rename'
            {
            match("rename"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__171"

    // $ANTLR start "T__172"
    public final void mT__172() throws RecognitionException {
        try {
            int _type = T__172;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:155:8: ( 'require' )
            // InternalPerl.g:155:10: 'require'
            {
            match("require"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__172"

    // $ANTLR start "T__173"
    public final void mT__173() throws RecognitionException {
        try {
            int _type = T__173;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:156:8: ( 'reset' )
            // InternalPerl.g:156:10: 'reset'
            {
            match("reset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__173"

    // $ANTLR start "T__174"
    public final void mT__174() throws RecognitionException {
        try {
            int _type = T__174;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:157:8: ( 'return' )
            // InternalPerl.g:157:10: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__174"

    // $ANTLR start "T__175"
    public final void mT__175() throws RecognitionException {
        try {
            int _type = T__175;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:158:8: ( 'reverse' )
            // InternalPerl.g:158:10: 'reverse'
            {
            match("reverse"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__175"

    // $ANTLR start "T__176"
    public final void mT__176() throws RecognitionException {
        try {
            int _type = T__176;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:159:8: ( 'rewinddir' )
            // InternalPerl.g:159:10: 'rewinddir'
            {
            match("rewinddir"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__176"

    // $ANTLR start "T__177"
    public final void mT__177() throws RecognitionException {
        try {
            int _type = T__177;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:160:8: ( 'rindex' )
            // InternalPerl.g:160:10: 'rindex'
            {
            match("rindex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__177"

    // $ANTLR start "T__178"
    public final void mT__178() throws RecognitionException {
        try {
            int _type = T__178;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:161:8: ( 'rmdir' )
            // InternalPerl.g:161:10: 'rmdir'
            {
            match("rmdir"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__178"

    // $ANTLR start "T__179"
    public final void mT__179() throws RecognitionException {
        try {
            int _type = T__179;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:162:8: ( 'say' )
            // InternalPerl.g:162:10: 'say'
            {
            match("say"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__179"

    // $ANTLR start "T__180"
    public final void mT__180() throws RecognitionException {
        try {
            int _type = T__180;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:163:8: ( 'scalar' )
            // InternalPerl.g:163:10: 'scalar'
            {
            match("scalar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__180"

    // $ANTLR start "T__181"
    public final void mT__181() throws RecognitionException {
        try {
            int _type = T__181;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:164:8: ( 'seek' )
            // InternalPerl.g:164:10: 'seek'
            {
            match("seek"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__181"

    // $ANTLR start "T__182"
    public final void mT__182() throws RecognitionException {
        try {
            int _type = T__182;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:165:8: ( 'seekdir' )
            // InternalPerl.g:165:10: 'seekdir'
            {
            match("seekdir"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__182"

    // $ANTLR start "T__183"
    public final void mT__183() throws RecognitionException {
        try {
            int _type = T__183;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:166:8: ( 'select' )
            // InternalPerl.g:166:10: 'select'
            {
            match("select"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__183"

    // $ANTLR start "T__184"
    public final void mT__184() throws RecognitionException {
        try {
            int _type = T__184;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:167:8: ( 'semctl' )
            // InternalPerl.g:167:10: 'semctl'
            {
            match("semctl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__184"

    // $ANTLR start "T__185"
    public final void mT__185() throws RecognitionException {
        try {
            int _type = T__185;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:168:8: ( 'semget' )
            // InternalPerl.g:168:10: 'semget'
            {
            match("semget"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__185"

    // $ANTLR start "T__186"
    public final void mT__186() throws RecognitionException {
        try {
            int _type = T__186;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:169:8: ( 'semop' )
            // InternalPerl.g:169:10: 'semop'
            {
            match("semop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__186"

    // $ANTLR start "T__187"
    public final void mT__187() throws RecognitionException {
        try {
            int _type = T__187;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:170:8: ( 'send' )
            // InternalPerl.g:170:10: 'send'
            {
            match("send"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__187"

    // $ANTLR start "T__188"
    public final void mT__188() throws RecognitionException {
        try {
            int _type = T__188;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:171:8: ( 'setgrent' )
            // InternalPerl.g:171:10: 'setgrent'
            {
            match("setgrent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__188"

    // $ANTLR start "T__189"
    public final void mT__189() throws RecognitionException {
        try {
            int _type = T__189;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:172:8: ( 'sethostent' )
            // InternalPerl.g:172:10: 'sethostent'
            {
            match("sethostent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__189"

    // $ANTLR start "T__190"
    public final void mT__190() throws RecognitionException {
        try {
            int _type = T__190;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:173:8: ( 'setnetent' )
            // InternalPerl.g:173:10: 'setnetent'
            {
            match("setnetent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__190"

    // $ANTLR start "T__191"
    public final void mT__191() throws RecognitionException {
        try {
            int _type = T__191;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:174:8: ( 'setpgrp' )
            // InternalPerl.g:174:10: 'setpgrp'
            {
            match("setpgrp"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__191"

    // $ANTLR start "T__192"
    public final void mT__192() throws RecognitionException {
        try {
            int _type = T__192;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:175:8: ( 'setpriority' )
            // InternalPerl.g:175:10: 'setpriority'
            {
            match("setpriority"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__192"

    // $ANTLR start "T__193"
    public final void mT__193() throws RecognitionException {
        try {
            int _type = T__193;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:176:8: ( 'setprotoent' )
            // InternalPerl.g:176:10: 'setprotoent'
            {
            match("setprotoent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__193"

    // $ANTLR start "T__194"
    public final void mT__194() throws RecognitionException {
        try {
            int _type = T__194;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:177:8: ( 'setpwent' )
            // InternalPerl.g:177:10: 'setpwent'
            {
            match("setpwent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__194"

    // $ANTLR start "T__195"
    public final void mT__195() throws RecognitionException {
        try {
            int _type = T__195;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:178:8: ( 'setservent' )
            // InternalPerl.g:178:10: 'setservent'
            {
            match("setservent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__195"

    // $ANTLR start "T__196"
    public final void mT__196() throws RecognitionException {
        try {
            int _type = T__196;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:179:8: ( 'setsockopt' )
            // InternalPerl.g:179:10: 'setsockopt'
            {
            match("setsockopt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__196"

    // $ANTLR start "T__197"
    public final void mT__197() throws RecognitionException {
        try {
            int _type = T__197;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:180:8: ( 'shift' )
            // InternalPerl.g:180:10: 'shift'
            {
            match("shift"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__197"

    // $ANTLR start "T__198"
    public final void mT__198() throws RecognitionException {
        try {
            int _type = T__198;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:181:8: ( 'shmctl' )
            // InternalPerl.g:181:10: 'shmctl'
            {
            match("shmctl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__198"

    // $ANTLR start "T__199"
    public final void mT__199() throws RecognitionException {
        try {
            int _type = T__199;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:182:8: ( 'shmget' )
            // InternalPerl.g:182:10: 'shmget'
            {
            match("shmget"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__199"

    // $ANTLR start "T__200"
    public final void mT__200() throws RecognitionException {
        try {
            int _type = T__200;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:183:8: ( 'shmread' )
            // InternalPerl.g:183:10: 'shmread'
            {
            match("shmread"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__200"

    // $ANTLR start "T__201"
    public final void mT__201() throws RecognitionException {
        try {
            int _type = T__201;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:184:8: ( 'shmwrite' )
            // InternalPerl.g:184:10: 'shmwrite'
            {
            match("shmwrite"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__201"

    // $ANTLR start "T__202"
    public final void mT__202() throws RecognitionException {
        try {
            int _type = T__202;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:185:8: ( 'shutdown' )
            // InternalPerl.g:185:10: 'shutdown'
            {
            match("shutdown"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__202"

    // $ANTLR start "T__203"
    public final void mT__203() throws RecognitionException {
        try {
            int _type = T__203;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:186:8: ( 'sin' )
            // InternalPerl.g:186:10: 'sin'
            {
            match("sin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__203"

    // $ANTLR start "T__204"
    public final void mT__204() throws RecognitionException {
        try {
            int _type = T__204;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:187:8: ( 'sleep' )
            // InternalPerl.g:187:10: 'sleep'
            {
            match("sleep"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__204"

    // $ANTLR start "T__205"
    public final void mT__205() throws RecognitionException {
        try {
            int _type = T__205;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:188:8: ( 'socket' )
            // InternalPerl.g:188:10: 'socket'
            {
            match("socket"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__205"

    // $ANTLR start "T__206"
    public final void mT__206() throws RecognitionException {
        try {
            int _type = T__206;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:189:8: ( 'socketpair' )
            // InternalPerl.g:189:10: 'socketpair'
            {
            match("socketpair"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__206"

    // $ANTLR start "T__207"
    public final void mT__207() throws RecognitionException {
        try {
            int _type = T__207;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:190:8: ( 'sort' )
            // InternalPerl.g:190:10: 'sort'
            {
            match("sort"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__207"

    // $ANTLR start "T__208"
    public final void mT__208() throws RecognitionException {
        try {
            int _type = T__208;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:191:8: ( 'splice' )
            // InternalPerl.g:191:10: 'splice'
            {
            match("splice"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__208"

    // $ANTLR start "T__209"
    public final void mT__209() throws RecognitionException {
        try {
            int _type = T__209;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:192:8: ( 'split' )
            // InternalPerl.g:192:10: 'split'
            {
            match("split"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__209"

    // $ANTLR start "T__210"
    public final void mT__210() throws RecognitionException {
        try {
            int _type = T__210;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:193:8: ( 'sprintf' )
            // InternalPerl.g:193:10: 'sprintf'
            {
            match("sprintf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__210"

    // $ANTLR start "T__211"
    public final void mT__211() throws RecognitionException {
        try {
            int _type = T__211;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:194:8: ( 'sqrt' )
            // InternalPerl.g:194:10: 'sqrt'
            {
            match("sqrt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__211"

    // $ANTLR start "T__212"
    public final void mT__212() throws RecognitionException {
        try {
            int _type = T__212;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:195:8: ( 'srand' )
            // InternalPerl.g:195:10: 'srand'
            {
            match("srand"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__212"

    // $ANTLR start "T__213"
    public final void mT__213() throws RecognitionException {
        try {
            int _type = T__213;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:196:8: ( 'stat' )
            // InternalPerl.g:196:10: 'stat'
            {
            match("stat"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__213"

    // $ANTLR start "T__214"
    public final void mT__214() throws RecognitionException {
        try {
            int _type = T__214;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:197:8: ( 'state' )
            // InternalPerl.g:197:10: 'state'
            {
            match("state"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__214"

    // $ANTLR start "T__215"
    public final void mT__215() throws RecognitionException {
        try {
            int _type = T__215;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:198:8: ( 'study' )
            // InternalPerl.g:198:10: 'study'
            {
            match("study"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__215"

    // $ANTLR start "T__216"
    public final void mT__216() throws RecognitionException {
        try {
            int _type = T__216;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:199:8: ( 'sub' )
            // InternalPerl.g:199:10: 'sub'
            {
            match("sub"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__216"

    // $ANTLR start "T__217"
    public final void mT__217() throws RecognitionException {
        try {
            int _type = T__217;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:200:8: ( 'substr' )
            // InternalPerl.g:200:10: 'substr'
            {
            match("substr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__217"

    // $ANTLR start "T__218"
    public final void mT__218() throws RecognitionException {
        try {
            int _type = T__218;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:201:8: ( 'symlink' )
            // InternalPerl.g:201:10: 'symlink'
            {
            match("symlink"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__218"

    // $ANTLR start "T__219"
    public final void mT__219() throws RecognitionException {
        try {
            int _type = T__219;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:202:8: ( 'syscall' )
            // InternalPerl.g:202:10: 'syscall'
            {
            match("syscall"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__219"

    // $ANTLR start "T__220"
    public final void mT__220() throws RecognitionException {
        try {
            int _type = T__220;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:203:8: ( 'sysopen' )
            // InternalPerl.g:203:10: 'sysopen'
            {
            match("sysopen"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__220"

    // $ANTLR start "T__221"
    public final void mT__221() throws RecognitionException {
        try {
            int _type = T__221;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:204:8: ( 'sysread' )
            // InternalPerl.g:204:10: 'sysread'
            {
            match("sysread"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__221"

    // $ANTLR start "T__222"
    public final void mT__222() throws RecognitionException {
        try {
            int _type = T__222;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:205:8: ( 'sysseek' )
            // InternalPerl.g:205:10: 'sysseek'
            {
            match("sysseek"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__222"

    // $ANTLR start "T__223"
    public final void mT__223() throws RecognitionException {
        try {
            int _type = T__223;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:206:8: ( 'system' )
            // InternalPerl.g:206:10: 'system'
            {
            match("system"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__223"

    // $ANTLR start "T__224"
    public final void mT__224() throws RecognitionException {
        try {
            int _type = T__224;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:207:8: ( 'syswrite' )
            // InternalPerl.g:207:10: 'syswrite'
            {
            match("syswrite"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__224"

    // $ANTLR start "T__225"
    public final void mT__225() throws RecognitionException {
        try {
            int _type = T__225;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:208:8: ( 'tell' )
            // InternalPerl.g:208:10: 'tell'
            {
            match("tell"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__225"

    // $ANTLR start "T__226"
    public final void mT__226() throws RecognitionException {
        try {
            int _type = T__226;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:209:8: ( 'telldir' )
            // InternalPerl.g:209:10: 'telldir'
            {
            match("telldir"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__226"

    // $ANTLR start "T__227"
    public final void mT__227() throws RecognitionException {
        try {
            int _type = T__227;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:210:8: ( 'tie' )
            // InternalPerl.g:210:10: 'tie'
            {
            match("tie"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__227"

    // $ANTLR start "T__228"
    public final void mT__228() throws RecognitionException {
        try {
            int _type = T__228;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:211:8: ( 'tied' )
            // InternalPerl.g:211:10: 'tied'
            {
            match("tied"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__228"

    // $ANTLR start "T__229"
    public final void mT__229() throws RecognitionException {
        try {
            int _type = T__229;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:212:8: ( 'time' )
            // InternalPerl.g:212:10: 'time'
            {
            match("time"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__229"

    // $ANTLR start "T__230"
    public final void mT__230() throws RecognitionException {
        try {
            int _type = T__230;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:213:8: ( 'times' )
            // InternalPerl.g:213:10: 'times'
            {
            match("times"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__230"

    // $ANTLR start "T__231"
    public final void mT__231() throws RecognitionException {
        try {
            int _type = T__231;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:214:8: ( 'tr' )
            // InternalPerl.g:214:10: 'tr'
            {
            match("tr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__231"

    // $ANTLR start "T__232"
    public final void mT__232() throws RecognitionException {
        try {
            int _type = T__232;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:215:8: ( 'truncate' )
            // InternalPerl.g:215:10: 'truncate'
            {
            match("truncate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__232"

    // $ANTLR start "T__233"
    public final void mT__233() throws RecognitionException {
        try {
            int _type = T__233;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:216:8: ( 'uc' )
            // InternalPerl.g:216:10: 'uc'
            {
            match("uc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__233"

    // $ANTLR start "T__234"
    public final void mT__234() throws RecognitionException {
        try {
            int _type = T__234;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:217:8: ( 'ucfirst' )
            // InternalPerl.g:217:10: 'ucfirst'
            {
            match("ucfirst"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__234"

    // $ANTLR start "T__235"
    public final void mT__235() throws RecognitionException {
        try {
            int _type = T__235;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:218:8: ( 'umask' )
            // InternalPerl.g:218:10: 'umask'
            {
            match("umask"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__235"

    // $ANTLR start "T__236"
    public final void mT__236() throws RecognitionException {
        try {
            int _type = T__236;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:219:8: ( 'undef' )
            // InternalPerl.g:219:10: 'undef'
            {
            match("undef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__236"

    // $ANTLR start "T__237"
    public final void mT__237() throws RecognitionException {
        try {
            int _type = T__237;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:220:8: ( 'unless' )
            // InternalPerl.g:220:10: 'unless'
            {
            match("unless"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__237"

    // $ANTLR start "T__238"
    public final void mT__238() throws RecognitionException {
        try {
            int _type = T__238;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:221:8: ( 'unlink' )
            // InternalPerl.g:221:10: 'unlink'
            {
            match("unlink"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__238"

    // $ANTLR start "T__239"
    public final void mT__239() throws RecognitionException {
        try {
            int _type = T__239;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:222:8: ( 'unpack' )
            // InternalPerl.g:222:10: 'unpack'
            {
            match("unpack"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__239"

    // $ANTLR start "T__240"
    public final void mT__240() throws RecognitionException {
        try {
            int _type = T__240;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:223:8: ( 'unshift' )
            // InternalPerl.g:223:10: 'unshift'
            {
            match("unshift"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__240"

    // $ANTLR start "T__241"
    public final void mT__241() throws RecognitionException {
        try {
            int _type = T__241;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:224:8: ( 'untie' )
            // InternalPerl.g:224:10: 'untie'
            {
            match("untie"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__241"

    // $ANTLR start "T__242"
    public final void mT__242() throws RecognitionException {
        try {
            int _type = T__242;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:225:8: ( 'until' )
            // InternalPerl.g:225:10: 'until'
            {
            match("until"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__242"

    // $ANTLR start "T__243"
    public final void mT__243() throws RecognitionException {
        try {
            int _type = T__243;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:226:8: ( 'use' )
            // InternalPerl.g:226:10: 'use'
            {
            match("use"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__243"

    // $ANTLR start "T__244"
    public final void mT__244() throws RecognitionException {
        try {
            int _type = T__244;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:227:8: ( 'utime' )
            // InternalPerl.g:227:10: 'utime'
            {
            match("utime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__244"

    // $ANTLR start "T__245"
    public final void mT__245() throws RecognitionException {
        try {
            int _type = T__245;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:228:8: ( 'values' )
            // InternalPerl.g:228:10: 'values'
            {
            match("values"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__245"

    // $ANTLR start "T__246"
    public final void mT__246() throws RecognitionException {
        try {
            int _type = T__246;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:229:8: ( 'vec' )
            // InternalPerl.g:229:10: 'vec'
            {
            match("vec"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__246"

    // $ANTLR start "T__247"
    public final void mT__247() throws RecognitionException {
        try {
            int _type = T__247;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:230:8: ( 'wait' )
            // InternalPerl.g:230:10: 'wait'
            {
            match("wait"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__247"

    // $ANTLR start "T__248"
    public final void mT__248() throws RecognitionException {
        try {
            int _type = T__248;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:231:8: ( 'waitpid' )
            // InternalPerl.g:231:10: 'waitpid'
            {
            match("waitpid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__248"

    // $ANTLR start "T__249"
    public final void mT__249() throws RecognitionException {
        try {
            int _type = T__249;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:232:8: ( 'wantarray' )
            // InternalPerl.g:232:10: 'wantarray'
            {
            match("wantarray"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__249"

    // $ANTLR start "T__250"
    public final void mT__250() throws RecognitionException {
        try {
            int _type = T__250;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:233:8: ( 'warn' )
            // InternalPerl.g:233:10: 'warn'
            {
            match("warn"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__250"

    // $ANTLR start "T__251"
    public final void mT__251() throws RecognitionException {
        try {
            int _type = T__251;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:234:8: ( 'when' )
            // InternalPerl.g:234:10: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__251"

    // $ANTLR start "T__252"
    public final void mT__252() throws RecognitionException {
        try {
            int _type = T__252;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:235:8: ( 'while' )
            // InternalPerl.g:235:10: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__252"

    // $ANTLR start "T__253"
    public final void mT__253() throws RecognitionException {
        try {
            int _type = T__253;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:236:8: ( 'write' )
            // InternalPerl.g:236:10: 'write'
            {
            match("write"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__253"

    // $ANTLR start "T__254"
    public final void mT__254() throws RecognitionException {
        try {
            int _type = T__254;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:237:8: ( 'y' )
            // InternalPerl.g:237:10: 'y'
            {
            match('y'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__254"

    // $ANTLR start "T__255"
    public final void mT__255() throws RecognitionException {
        try {
            int _type = T__255;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:238:8: ( '++' )
            // InternalPerl.g:238:10: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__255"

    // $ANTLR start "T__256"
    public final void mT__256() throws RecognitionException {
        try {
            int _type = T__256;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:239:8: ( '--' )
            // InternalPerl.g:239:10: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__256"

    // $ANTLR start "T__257"
    public final void mT__257() throws RecognitionException {
        try {
            int _type = T__257;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:240:8: ( '**' )
            // InternalPerl.g:240:10: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__257"

    // $ANTLR start "T__258"
    public final void mT__258() throws RecognitionException {
        try {
            int _type = T__258;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:241:8: ( '!' )
            // InternalPerl.g:241:10: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__258"

    // $ANTLR start "T__259"
    public final void mT__259() throws RecognitionException {
        try {
            int _type = T__259;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:242:8: ( '~' )
            // InternalPerl.g:242:10: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__259"

    // $ANTLR start "T__260"
    public final void mT__260() throws RecognitionException {
        try {
            int _type = T__260;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:243:8: ( '+' )
            // InternalPerl.g:243:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__260"

    // $ANTLR start "T__261"
    public final void mT__261() throws RecognitionException {
        try {
            int _type = T__261;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:244:8: ( '-' )
            // InternalPerl.g:244:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__261"

    // $ANTLR start "T__262"
    public final void mT__262() throws RecognitionException {
        try {
            int _type = T__262;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:245:8: ( '=~' )
            // InternalPerl.g:245:10: '=~'
            {
            match("=~"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__262"

    // $ANTLR start "T__263"
    public final void mT__263() throws RecognitionException {
        try {
            int _type = T__263;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:246:8: ( '!~' )
            // InternalPerl.g:246:10: '!~'
            {
            match("!~"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__263"

    // $ANTLR start "T__264"
    public final void mT__264() throws RecognitionException {
        try {
            int _type = T__264;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:247:8: ( '*' )
            // InternalPerl.g:247:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__264"

    // $ANTLR start "T__265"
    public final void mT__265() throws RecognitionException {
        try {
            int _type = T__265;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:248:8: ( '/' )
            // InternalPerl.g:248:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__265"

    // $ANTLR start "T__266"
    public final void mT__266() throws RecognitionException {
        try {
            int _type = T__266;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:249:8: ( 'x' )
            // InternalPerl.g:249:10: 'x'
            {
            match('x'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__266"

    // $ANTLR start "T__267"
    public final void mT__267() throws RecognitionException {
        try {
            int _type = T__267;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:250:8: ( '<<' )
            // InternalPerl.g:250:10: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__267"

    // $ANTLR start "T__268"
    public final void mT__268() throws RecognitionException {
        try {
            int _type = T__268;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:251:8: ( '>>' )
            // InternalPerl.g:251:10: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__268"

    // $ANTLR start "T__269"
    public final void mT__269() throws RecognitionException {
        try {
            int _type = T__269;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:252:8: ( 'lt' )
            // InternalPerl.g:252:10: 'lt'
            {
            match("lt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__269"

    // $ANTLR start "T__270"
    public final void mT__270() throws RecognitionException {
        try {
            int _type = T__270;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:253:8: ( 'gt' )
            // InternalPerl.g:253:10: 'gt'
            {
            match("gt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__270"

    // $ANTLR start "T__271"
    public final void mT__271() throws RecognitionException {
        try {
            int _type = T__271;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:254:8: ( 'le' )
            // InternalPerl.g:254:10: 'le'
            {
            match("le"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__271"

    // $ANTLR start "T__272"
    public final void mT__272() throws RecognitionException {
        try {
            int _type = T__272;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:255:8: ( 'ge' )
            // InternalPerl.g:255:10: 'ge'
            {
            match("ge"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__272"

    // $ANTLR start "T__273"
    public final void mT__273() throws RecognitionException {
        try {
            int _type = T__273;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:256:8: ( 'cmp' )
            // InternalPerl.g:256:10: 'cmp'
            {
            match("cmp"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__273"

    // $ANTLR start "T__274"
    public final void mT__274() throws RecognitionException {
        try {
            int _type = T__274;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:257:8: ( '~~' )
            // InternalPerl.g:257:10: '~~'
            {
            match("~~"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__274"

    // $ANTLR start "T__275"
    public final void mT__275() throws RecognitionException {
        try {
            int _type = T__275;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:258:8: ( '==' )
            // InternalPerl.g:258:10: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__275"

    // $ANTLR start "T__276"
    public final void mT__276() throws RecognitionException {
        try {
            int _type = T__276;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:259:8: ( '!=' )
            // InternalPerl.g:259:10: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__276"

    // $ANTLR start "T__277"
    public final void mT__277() throws RecognitionException {
        try {
            int _type = T__277;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:260:8: ( '..' )
            // InternalPerl.g:260:10: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__277"

    // $ANTLR start "T__278"
    public final void mT__278() throws RecognitionException {
        try {
            int _type = T__278;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:261:8: ( '...' )
            // InternalPerl.g:261:10: '...'
            {
            match("..."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__278"

    // $ANTLR start "T__279"
    public final void mT__279() throws RecognitionException {
        try {
            int _type = T__279;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:262:8: ( ',' )
            // InternalPerl.g:262:10: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__279"

    // $ANTLR start "T__280"
    public final void mT__280() throws RecognitionException {
        try {
            int _type = T__280;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:263:8: ( '|' )
            // InternalPerl.g:263:10: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__280"

    // $ANTLR start "T__281"
    public final void mT__281() throws RecognitionException {
        try {
            int _type = T__281;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:264:8: ( '^' )
            // InternalPerl.g:264:10: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__281"

    // $ANTLR start "T__282"
    public final void mT__282() throws RecognitionException {
        try {
            int _type = T__282;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:265:8: ( '&&' )
            // InternalPerl.g:265:10: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__282"

    // $ANTLR start "T__283"
    public final void mT__283() throws RecognitionException {
        try {
            int _type = T__283;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:266:8: ( '||' )
            // InternalPerl.g:266:10: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__283"

    // $ANTLR start "T__284"
    public final void mT__284() throws RecognitionException {
        try {
            int _type = T__284;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:267:8: ( '//' )
            // InternalPerl.g:267:10: '//'
            {
            match("//"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__284"

    // $ANTLR start "T__285"
    public final void mT__285() throws RecognitionException {
        try {
            int _type = T__285;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:268:8: ( '?' )
            // InternalPerl.g:268:10: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__285"

    // $ANTLR start "T__286"
    public final void mT__286() throws RecognitionException {
        try {
            int _type = T__286;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:269:8: ( ':' )
            // InternalPerl.g:269:10: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__286"

    // $ANTLR start "T__287"
    public final void mT__287() throws RecognitionException {
        try {
            int _type = T__287;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:270:8: ( '**=' )
            // InternalPerl.g:270:10: '**='
            {
            match("**="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__287"

    // $ANTLR start "T__288"
    public final void mT__288() throws RecognitionException {
        try {
            int _type = T__288;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:271:8: ( '+=' )
            // InternalPerl.g:271:10: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__288"

    // $ANTLR start "T__289"
    public final void mT__289() throws RecognitionException {
        try {
            int _type = T__289;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:272:8: ( '-=' )
            // InternalPerl.g:272:10: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__289"

    // $ANTLR start "T__290"
    public final void mT__290() throws RecognitionException {
        try {
            int _type = T__290;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:273:8: ( '.=' )
            // InternalPerl.g:273:10: '.='
            {
            match(".="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__290"

    // $ANTLR start "T__291"
    public final void mT__291() throws RecognitionException {
        try {
            int _type = T__291;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:274:8: ( '*=' )
            // InternalPerl.g:274:10: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__291"

    // $ANTLR start "T__292"
    public final void mT__292() throws RecognitionException {
        try {
            int _type = T__292;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:275:8: ( '/=' )
            // InternalPerl.g:275:10: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__292"

    // $ANTLR start "T__293"
    public final void mT__293() throws RecognitionException {
        try {
            int _type = T__293;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:276:8: ( '%=' )
            // InternalPerl.g:276:10: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__293"

    // $ANTLR start "T__294"
    public final void mT__294() throws RecognitionException {
        try {
            int _type = T__294;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:277:8: ( 'x=' )
            // InternalPerl.g:277:10: 'x='
            {
            match("x="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__294"

    // $ANTLR start "T__295"
    public final void mT__295() throws RecognitionException {
        try {
            int _type = T__295;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:278:8: ( '&=' )
            // InternalPerl.g:278:10: '&='
            {
            match("&="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__295"

    // $ANTLR start "T__296"
    public final void mT__296() throws RecognitionException {
        try {
            int _type = T__296;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:279:8: ( '|=' )
            // InternalPerl.g:279:10: '|='
            {
            match("|="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__296"

    // $ANTLR start "T__297"
    public final void mT__297() throws RecognitionException {
        try {
            int _type = T__297;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:280:8: ( '^=' )
            // InternalPerl.g:280:10: '^='
            {
            match("^="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__297"

    // $ANTLR start "T__298"
    public final void mT__298() throws RecognitionException {
        try {
            int _type = T__298;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:281:8: ( '<<=' )
            // InternalPerl.g:281:10: '<<='
            {
            match("<<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__298"

    // $ANTLR start "T__299"
    public final void mT__299() throws RecognitionException {
        try {
            int _type = T__299;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:282:8: ( '>>=' )
            // InternalPerl.g:282:10: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__299"

    // $ANTLR start "T__300"
    public final void mT__300() throws RecognitionException {
        try {
            int _type = T__300;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:283:8: ( '&&=' )
            // InternalPerl.g:283:10: '&&='
            {
            match("&&="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__300"

    // $ANTLR start "T__301"
    public final void mT__301() throws RecognitionException {
        try {
            int _type = T__301;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:284:8: ( '||=' )
            // InternalPerl.g:284:10: '||='
            {
            match("||="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__301"

    // $ANTLR start "T__302"
    public final void mT__302() throws RecognitionException {
        try {
            int _type = T__302;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:285:8: ( '//=' )
            // InternalPerl.g:285:10: '//='
            {
            match("//="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__302"

    // $ANTLR start "T__303"
    public final void mT__303() throws RecognitionException {
        try {
            int _type = T__303;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:286:8: ( '<' )
            // InternalPerl.g:286:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__303"

    // $ANTLR start "T__304"
    public final void mT__304() throws RecognitionException {
        try {
            int _type = T__304;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:287:8: ( '>' )
            // InternalPerl.g:287:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__304"

    // $ANTLR start "T__305"
    public final void mT__305() throws RecognitionException {
        try {
            int _type = T__305;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:288:8: ( '<=' )
            // InternalPerl.g:288:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__305"

    // $ANTLR start "T__306"
    public final void mT__306() throws RecognitionException {
        try {
            int _type = T__306;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:289:8: ( '>=' )
            // InternalPerl.g:289:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__306"

    // $ANTLR start "T__307"
    public final void mT__307() throws RecognitionException {
        try {
            int _type = T__307;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:290:8: ( '<>' )
            // InternalPerl.g:290:10: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__307"

    // $ANTLR start "T__308"
    public final void mT__308() throws RecognitionException {
        try {
            int _type = T__308;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:291:8: ( '=>' )
            // InternalPerl.g:291:10: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__308"

    // $ANTLR start "T__309"
    public final void mT__309() throws RecognitionException {
        try {
            int _type = T__309;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:292:8: ( '->' )
            // InternalPerl.g:292:10: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__309"

    // $ANTLR start "T__310"
    public final void mT__310() throws RecognitionException {
        try {
            int _type = T__310;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:293:8: ( 'and' )
            // InternalPerl.g:293:10: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__310"

    // $ANTLR start "T__311"
    public final void mT__311() throws RecognitionException {
        try {
            int _type = T__311;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:294:8: ( 'or' )
            // InternalPerl.g:294:10: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__311"

    // $ANTLR start "T__312"
    public final void mT__312() throws RecognitionException {
        try {
            int _type = T__312;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:295:8: ( 'xor' )
            // InternalPerl.g:295:10: 'xor'
            {
            match("xor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__312"

    // $ANTLR start "T__313"
    public final void mT__313() throws RecognitionException {
        try {
            int _type = T__313;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:296:8: ( 'not' )
            // InternalPerl.g:296:10: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__313"

    // $ANTLR start "T__314"
    public final void mT__314() throws RecognitionException {
        try {
            int _type = T__314;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:297:8: ( 'eq' )
            // InternalPerl.g:297:10: 'eq'
            {
            match("eq"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__314"

    // $ANTLR start "T__315"
    public final void mT__315() throws RecognitionException {
        try {
            int _type = T__315;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:298:8: ( 'ne' )
            // InternalPerl.g:298:10: 'ne'
            {
            match("ne"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__315"

    // $ANTLR start "T__316"
    public final void mT__316() throws RecognitionException {
        try {
            int _type = T__316;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:299:8: ( '-r' )
            // InternalPerl.g:299:10: '-r'
            {
            match("-r"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__316"

    // $ANTLR start "T__317"
    public final void mT__317() throws RecognitionException {
        try {
            int _type = T__317;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:300:8: ( '-w' )
            // InternalPerl.g:300:10: '-w'
            {
            match("-w"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__317"

    // $ANTLR start "T__318"
    public final void mT__318() throws RecognitionException {
        try {
            int _type = T__318;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:301:8: ( '-x' )
            // InternalPerl.g:301:10: '-x'
            {
            match("-x"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__318"

    // $ANTLR start "T__319"
    public final void mT__319() throws RecognitionException {
        try {
            int _type = T__319;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:302:8: ( '-o' )
            // InternalPerl.g:302:10: '-o'
            {
            match("-o"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__319"

    // $ANTLR start "T__320"
    public final void mT__320() throws RecognitionException {
        try {
            int _type = T__320;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:303:8: ( '-R' )
            // InternalPerl.g:303:10: '-R'
            {
            match("-R"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__320"

    // $ANTLR start "T__321"
    public final void mT__321() throws RecognitionException {
        try {
            int _type = T__321;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:304:8: ( '-W' )
            // InternalPerl.g:304:10: '-W'
            {
            match("-W"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__321"

    // $ANTLR start "T__322"
    public final void mT__322() throws RecognitionException {
        try {
            int _type = T__322;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:305:8: ( '-X' )
            // InternalPerl.g:305:10: '-X'
            {
            match("-X"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__322"

    // $ANTLR start "T__323"
    public final void mT__323() throws RecognitionException {
        try {
            int _type = T__323;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:306:8: ( '-O' )
            // InternalPerl.g:306:10: '-O'
            {
            match("-O"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__323"

    // $ANTLR start "T__324"
    public final void mT__324() throws RecognitionException {
        try {
            int _type = T__324;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:307:8: ( '-e' )
            // InternalPerl.g:307:10: '-e'
            {
            match("-e"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__324"

    // $ANTLR start "T__325"
    public final void mT__325() throws RecognitionException {
        try {
            int _type = T__325;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:308:8: ( '-z' )
            // InternalPerl.g:308:10: '-z'
            {
            match("-z"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__325"

    // $ANTLR start "T__326"
    public final void mT__326() throws RecognitionException {
        try {
            int _type = T__326;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:309:8: ( '-s' )
            // InternalPerl.g:309:10: '-s'
            {
            match("-s"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__326"

    // $ANTLR start "T__327"
    public final void mT__327() throws RecognitionException {
        try {
            int _type = T__327;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:310:8: ( '-f' )
            // InternalPerl.g:310:10: '-f'
            {
            match("-f"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__327"

    // $ANTLR start "T__328"
    public final void mT__328() throws RecognitionException {
        try {
            int _type = T__328;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:311:8: ( '-d' )
            // InternalPerl.g:311:10: '-d'
            {
            match("-d"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__328"

    // $ANTLR start "T__329"
    public final void mT__329() throws RecognitionException {
        try {
            int _type = T__329;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:312:8: ( '-l' )
            // InternalPerl.g:312:10: '-l'
            {
            match("-l"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__329"

    // $ANTLR start "T__330"
    public final void mT__330() throws RecognitionException {
        try {
            int _type = T__330;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:313:8: ( '-p' )
            // InternalPerl.g:313:10: '-p'
            {
            match("-p"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__330"

    // $ANTLR start "T__331"
    public final void mT__331() throws RecognitionException {
        try {
            int _type = T__331;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:314:8: ( '-S' )
            // InternalPerl.g:314:10: '-S'
            {
            match("-S"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__331"

    // $ANTLR start "T__332"
    public final void mT__332() throws RecognitionException {
        try {
            int _type = T__332;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:315:8: ( '-b' )
            // InternalPerl.g:315:10: '-b'
            {
            match("-b"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__332"

    // $ANTLR start "T__333"
    public final void mT__333() throws RecognitionException {
        try {
            int _type = T__333;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:316:8: ( '-c' )
            // InternalPerl.g:316:10: '-c'
            {
            match("-c"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__333"

    // $ANTLR start "T__334"
    public final void mT__334() throws RecognitionException {
        try {
            int _type = T__334;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:317:8: ( '-t' )
            // InternalPerl.g:317:10: '-t'
            {
            match("-t"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__334"

    // $ANTLR start "T__335"
    public final void mT__335() throws RecognitionException {
        try {
            int _type = T__335;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:318:8: ( '-u' )
            // InternalPerl.g:318:10: '-u'
            {
            match("-u"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__335"

    // $ANTLR start "T__336"
    public final void mT__336() throws RecognitionException {
        try {
            int _type = T__336;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:319:8: ( '-g' )
            // InternalPerl.g:319:10: '-g'
            {
            match("-g"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__336"

    // $ANTLR start "T__337"
    public final void mT__337() throws RecognitionException {
        try {
            int _type = T__337;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:320:8: ( '-k' )
            // InternalPerl.g:320:10: '-k'
            {
            match("-k"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__337"

    // $ANTLR start "T__338"
    public final void mT__338() throws RecognitionException {
        try {
            int _type = T__338;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:321:8: ( '-T' )
            // InternalPerl.g:321:10: '-T'
            {
            match("-T"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__338"

    // $ANTLR start "T__339"
    public final void mT__339() throws RecognitionException {
        try {
            int _type = T__339;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:322:8: ( '-B' )
            // InternalPerl.g:322:10: '-B'
            {
            match("-B"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__339"

    // $ANTLR start "T__340"
    public final void mT__340() throws RecognitionException {
        try {
            int _type = T__340;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:323:8: ( '-M' )
            // InternalPerl.g:323:10: '-M'
            {
            match("-M"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__340"

    // $ANTLR start "T__341"
    public final void mT__341() throws RecognitionException {
        try {
            int _type = T__341;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:324:8: ( '-A' )
            // InternalPerl.g:324:10: '-A'
            {
            match("-A"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__341"

    // $ANTLR start "T__342"
    public final void mT__342() throws RecognitionException {
        try {
            int _type = T__342;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:325:8: ( '-C' )
            // InternalPerl.g:325:10: '-C'
            {
            match("-C"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__342"

    // $ANTLR start "T__343"
    public final void mT__343() throws RecognitionException {
        try {
            int _type = T__343;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:326:8: ( '{' )
            // InternalPerl.g:326:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__343"

    // $ANTLR start "T__344"
    public final void mT__344() throws RecognitionException {
        try {
            int _type = T__344;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:327:8: ( '}' )
            // InternalPerl.g:327:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__344"

    // $ANTLR start "T__345"
    public final void mT__345() throws RecognitionException {
        try {
            int _type = T__345;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:328:8: ( '(' )
            // InternalPerl.g:328:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__345"

    // $ANTLR start "T__346"
    public final void mT__346() throws RecognitionException {
        try {
            int _type = T__346;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:329:8: ( ')' )
            // InternalPerl.g:329:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__346"

    // $ANTLR start "T__347"
    public final void mT__347() throws RecognitionException {
        try {
            int _type = T__347;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:330:8: ( '<=>' )
            // InternalPerl.g:330:10: '<=>'
            {
            match("<=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__347"

    // $ANTLR start "T__348"
    public final void mT__348() throws RecognitionException {
        try {
            int _type = T__348;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:331:8: ( '.' )
            // InternalPerl.g:331:10: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__348"

    // $ANTLR start "RULE_NUMBER"
    public final void mRULE_NUMBER() throws RecognitionException {
        try {
            int _type = RULE_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4834:13: ( ( RULE_HEX | RULE_BIN | RULE_INT ) ( '.' RULE_INT )? )
            // InternalPerl.g:4834:15: ( RULE_HEX | RULE_BIN | RULE_INT ) ( '.' RULE_INT )?
            {
            // InternalPerl.g:4834:15: ( RULE_HEX | RULE_BIN | RULE_INT )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'X':
                case 'x':
                    {
                    alt1=1;
                    }
                    break;
                case 'b':
                    {
                    alt1=2;
                    }
                    break;
                default:
                    alt1=3;}

            }
            else if ( ((LA1_0>='1' && LA1_0<='9')) ) {
                alt1=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalPerl.g:4834:16: RULE_HEX
                    {
                    mRULE_HEX(); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4834:25: RULE_BIN
                    {
                    mRULE_BIN(); 

                    }
                    break;
                case 3 :
                    // InternalPerl.g:4834:34: RULE_INT
                    {
                    mRULE_INT(); 

                    }
                    break;

            }

            // InternalPerl.g:4834:44: ( '.' RULE_INT )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='.') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalPerl.g:4834:45: '.' RULE_INT
                    {
                    match('.'); 
                    mRULE_INT(); 

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
    // $ANTLR end "RULE_NUMBER"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4836:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ ( ( '::' | '\\'' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ )* )
            // InternalPerl.g:4836:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ ( ( '::' | '\\'' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ )*
            {
            // InternalPerl.g:4836:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPerl.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            // InternalPerl.g:4836:36: ( ( '::' | '\\'' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\''||LA6_0==':') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalPerl.g:4836:37: ( '::' | '\\'' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+
            	    {
            	    // InternalPerl.g:4836:37: ( '::' | '\\'' )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==':') ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0=='\'') ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // InternalPerl.g:4836:38: '::'
            	            {
            	            match("::"); 


            	            }
            	            break;
            	        case 2 :
            	            // InternalPerl.g:4836:43: '\\''
            	            {
            	            match('\''); 

            	            }
            	            break;

            	    }

            	    // InternalPerl.g:4836:49: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( ((LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalPerl.g:
            	    	    {
            	    	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
            	    break;

            	default :
            	    break loop6;
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

    // $ANTLR start "RULE_SYMBOL"
    public final void mRULE_SYMBOL() throws RecognitionException {
        try {
            int _type = RULE_SYMBOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4838:13: ( ( '$' | '%' | '@' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ ( ( '::' | '\\'' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ )* )
            // InternalPerl.g:4838:15: ( '$' | '%' | '@' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ ( ( '::' | '\\'' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ )*
            {
            if ( (input.LA(1)>='$' && input.LA(1)<='%')||input.LA(1)=='@' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalPerl.g:4838:29: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPerl.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            // InternalPerl.g:4838:54: ( ( '::' | '\\'' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\''||LA10_0==':') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalPerl.g:4838:55: ( '::' | '\\'' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+
            	    {
            	    // InternalPerl.g:4838:55: ( '::' | '\\'' )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==':') ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0=='\'') ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // InternalPerl.g:4838:56: '::'
            	            {
            	            match("::"); 


            	            }
            	            break;
            	        case 2 :
            	            // InternalPerl.g:4838:61: '\\''
            	            {
            	            match('\''); 

            	            }
            	            break;

            	    }

            	    // InternalPerl.g:4838:67: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( ((LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalPerl.g:
            	    	    {
            	    	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;}


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SYMBOL"

    // $ANTLR start "RULE_VERSION"
    public final void mRULE_VERSION() throws RecognitionException {
        try {
            int _type = RULE_VERSION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4840:14: ( ( 'v' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )* )
            // InternalPerl.g:4840:16: ( 'v' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )*
            {
            // InternalPerl.g:4840:16: ( 'v' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='v') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalPerl.g:4840:16: 'v'
                    {
                    match('v'); 

                    }
                    break;

            }

            // InternalPerl.g:4840:21: ( '0' .. '9' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPerl.g:4840:22: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            // InternalPerl.g:4840:33: ( '.' ( '0' .. '9' )+ )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='.') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalPerl.g:4840:34: '.' ( '0' .. '9' )+
            	    {
            	    match('.'); 
            	    // InternalPerl.g:4840:38: ( '0' .. '9' )+
            	    int cnt13=0;
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
            	            alt13=1;
            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // InternalPerl.g:4840:39: '0' .. '9'
            	    	    {
            	    	    matchRange('0','9'); 

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
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VERSION"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            // InternalPerl.g:4842:19: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ )
            // InternalPerl.g:4842:21: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            {
            // InternalPerl.g:4842:21: ( '0x' | '0X' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='0') ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1=='x') ) {
                    alt15=1;
                }
                else if ( (LA15_1=='X') ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalPerl.g:4842:22: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // InternalPerl.g:4842:27: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // InternalPerl.g:4842:33: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='F')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='f')) ) {
                    alt16=1;
                }


                switch (alt16) {
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_BIN"
    public final void mRULE_BIN() throws RecognitionException {
        try {
            // InternalPerl.g:4844:19: ( '0b' ( '0' .. '1' | '_' )+ )
            // InternalPerl.g:4844:21: '0b' ( '0' .. '1' | '_' )+
            {
            match("0b"); 

            // InternalPerl.g:4844:26: ( '0' .. '1' | '_' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='0' && LA17_0<='1')||LA17_0=='_') ) {
                    alt17=1;
                }


                switch (alt17) {
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
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIN"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            // InternalPerl.g:4846:19: ( '0' .. '9' ( '0' .. '9' | '_' )* )
            // InternalPerl.g:4846:21: '0' .. '9' ( '0' .. '9' | '_' )*
            {
            matchRange('0','9'); 
            // InternalPerl.g:4846:30: ( '0' .. '9' | '_' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='9')||LA18_0=='_') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalPerl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='_' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4848:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalPerl.g:4848:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalPerl.g:4848:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\"') ) {
                alt21=1;
            }
            else if ( (LA21_0=='\'') ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalPerl.g:4848:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalPerl.g:4848:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop19:
                    do {
                        int alt19=3;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0=='\\') ) {
                            alt19=1;
                        }
                        else if ( ((LA19_0>='\u0000' && LA19_0<='!')||(LA19_0>='#' && LA19_0<='[')||(LA19_0>=']' && LA19_0<='\uFFFF')) ) {
                            alt19=2;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalPerl.g:4848:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalPerl.g:4848:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop19;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4848:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalPerl.g:4848:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop20:
                    do {
                        int alt20=3;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='\\') ) {
                            alt20=1;
                        }
                        else if ( ((LA20_0>='\u0000' && LA20_0<='&')||(LA20_0>='(' && LA20_0<='[')||(LA20_0>=']' && LA20_0<='\uFFFF')) ) {
                            alt20=2;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalPerl.g:4848:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalPerl.g:4848:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop20;
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

    // $ANTLR start "RULE_BACKTICK_STRING"
    public final void mRULE_BACKTICK_STRING() throws RecognitionException {
        try {
            int _type = RULE_BACKTICK_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4850:22: ( '`' (~ ( '`' ) )* '`' )
            // InternalPerl.g:4850:24: '`' (~ ( '`' ) )* '`'
            {
            match('`'); 
            // InternalPerl.g:4850:28: (~ ( '`' ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='\u0000' && LA22_0<='_')||(LA22_0>='a' && LA22_0<='\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPerl.g:4850:28: ~ ( '`' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='_')||(input.LA(1)>='a' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            match('`'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BACKTICK_STRING"

    // $ANTLR start "RULE_INTERPOLATE"
    public final void mRULE_INTERPOLATE() throws RecognitionException {
        try {
            int _type = RULE_INTERPOLATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4852:18: ( 'qq' ( RULE_WS )? ( '{' ( options {greedy=false; } : . )* '}' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' ) )
            // InternalPerl.g:4852:20: 'qq' ( RULE_WS )? ( '{' ( options {greedy=false; } : . )* '}' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' )
            {
            match("qq"); 

            // InternalPerl.g:4852:25: ( RULE_WS )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>='\t' && LA23_0<='\n')||LA23_0=='\r'||LA23_0==' ') ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalPerl.g:4852:25: RULE_WS
                    {
                    mRULE_WS(); 

                    }
                    break;

            }

            // InternalPerl.g:4852:34: ( '{' ( options {greedy=false; } : . )* '}' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' )
            int alt28=4;
            switch ( input.LA(1) ) {
            case '{':
                {
                alt28=1;
                }
                break;
            case '|':
                {
                alt28=2;
                }
                break;
            case '/':
                {
                alt28=3;
                }
                break;
            case '<':
                {
                alt28=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalPerl.g:4852:35: '{' ( options {greedy=false; } : . )* '}'
                    {
                    match('{'); 
                    // InternalPerl.g:4852:39: ( options {greedy=false; } : . )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0=='}') ) {
                            alt24=2;
                        }
                        else if ( ((LA24_0>='\u0000' && LA24_0<='|')||(LA24_0>='~' && LA24_0<='\uFFFF')) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalPerl.g:4852:67: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    match('}'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4852:75: '|' ( options {greedy=false; } : . )* '|'
                    {
                    match('|'); 
                    // InternalPerl.g:4852:79: ( options {greedy=false; } : . )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0=='|') ) {
                            alt25=2;
                        }
                        else if ( ((LA25_0>='\u0000' && LA25_0<='{')||(LA25_0>='}' && LA25_0<='\uFFFF')) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalPerl.g:4852:107: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    match('|'); 

                    }
                    break;
                case 3 :
                    // InternalPerl.g:4852:115: '/' ( options {greedy=false; } : . )* '/'
                    {
                    match('/'); 
                    // InternalPerl.g:4852:119: ( options {greedy=false; } : . )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0=='/') ) {
                            alt26=2;
                        }
                        else if ( ((LA26_0>='\u0000' && LA26_0<='.')||(LA26_0>='0' && LA26_0<='\uFFFF')) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalPerl.g:4852:147: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    match('/'); 

                    }
                    break;
                case 4 :
                    // InternalPerl.g:4852:155: '<' ( options {greedy=false; } : . )* '>'
                    {
                    match('<'); 
                    // InternalPerl.g:4852:159: ( options {greedy=false; } : . )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0=='>') ) {
                            alt27=2;
                        }
                        else if ( ((LA27_0>='\u0000' && LA27_0<='=')||(LA27_0>='?' && LA27_0<='\uFFFF')) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalPerl.g:4852:187: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    match('>'); 

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
    // $ANTLR end "RULE_INTERPOLATE"

    // $ANTLR start "RULE_LITERAL"
    public final void mRULE_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4854:14: ( 'q' ( RULE_WS )? ( '{' ( options {greedy=false; } : . )* '}' | '(' ( options {greedy=false; } : . )* ')' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' ) )
            // InternalPerl.g:4854:16: 'q' ( RULE_WS )? ( '{' ( options {greedy=false; } : . )* '}' | '(' ( options {greedy=false; } : . )* ')' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' )
            {
            match('q'); 
            // InternalPerl.g:4854:20: ( RULE_WS )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>='\t' && LA29_0<='\n')||LA29_0=='\r'||LA29_0==' ') ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalPerl.g:4854:20: RULE_WS
                    {
                    mRULE_WS(); 

                    }
                    break;

            }

            // InternalPerl.g:4854:29: ( '{' ( options {greedy=false; } : . )* '}' | '(' ( options {greedy=false; } : . )* ')' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' )
            int alt35=5;
            switch ( input.LA(1) ) {
            case '{':
                {
                alt35=1;
                }
                break;
            case '(':
                {
                alt35=2;
                }
                break;
            case '|':
                {
                alt35=3;
                }
                break;
            case '/':
                {
                alt35=4;
                }
                break;
            case '<':
                {
                alt35=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalPerl.g:4854:30: '{' ( options {greedy=false; } : . )* '}'
                    {
                    match('{'); 
                    // InternalPerl.g:4854:34: ( options {greedy=false; } : . )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0=='}') ) {
                            alt30=2;
                        }
                        else if ( ((LA30_0>='\u0000' && LA30_0<='|')||(LA30_0>='~' && LA30_0<='\uFFFF')) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalPerl.g:4854:62: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    match('}'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4854:70: '(' ( options {greedy=false; } : . )* ')'
                    {
                    match('('); 
                    // InternalPerl.g:4854:74: ( options {greedy=false; } : . )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==')') ) {
                            alt31=2;
                        }
                        else if ( ((LA31_0>='\u0000' && LA31_0<='(')||(LA31_0>='*' && LA31_0<='\uFFFF')) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalPerl.g:4854:102: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    match(')'); 

                    }
                    break;
                case 3 :
                    // InternalPerl.g:4854:110: '|' ( options {greedy=false; } : . )* '|'
                    {
                    match('|'); 
                    // InternalPerl.g:4854:114: ( options {greedy=false; } : . )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0=='|') ) {
                            alt32=2;
                        }
                        else if ( ((LA32_0>='\u0000' && LA32_0<='{')||(LA32_0>='}' && LA32_0<='\uFFFF')) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalPerl.g:4854:142: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    match('|'); 

                    }
                    break;
                case 4 :
                    // InternalPerl.g:4854:150: '/' ( options {greedy=false; } : . )* '/'
                    {
                    match('/'); 
                    // InternalPerl.g:4854:154: ( options {greedy=false; } : . )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0=='/') ) {
                            alt33=2;
                        }
                        else if ( ((LA33_0>='\u0000' && LA33_0<='.')||(LA33_0>='0' && LA33_0<='\uFFFF')) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalPerl.g:4854:182: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    match('/'); 

                    }
                    break;
                case 5 :
                    // InternalPerl.g:4854:190: '<' ( options {greedy=false; } : . )* '>'
                    {
                    match('<'); 
                    // InternalPerl.g:4854:194: ( options {greedy=false; } : . )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0=='>') ) {
                            alt34=2;
                        }
                        else if ( ((LA34_0>='\u0000' && LA34_0<='=')||(LA34_0>='?' && LA34_0<='\uFFFF')) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalPerl.g:4854:222: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    match('>'); 

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
    // $ANTLR end "RULE_LITERAL"

    // $ANTLR start "RULE_WORDS_QUOTE_LIKE"
    public final void mRULE_WORDS_QUOTE_LIKE() throws RecognitionException {
        try {
            int _type = RULE_WORDS_QUOTE_LIKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4856:23: ( 'qw' ( RULE_WS )? ( '{' ( options {greedy=false; } : . )* '}' | '(' ( options {greedy=false; } : . )* ')' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' ) )
            // InternalPerl.g:4856:25: 'qw' ( RULE_WS )? ( '{' ( options {greedy=false; } : . )* '}' | '(' ( options {greedy=false; } : . )* ')' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' )
            {
            match("qw"); 

            // InternalPerl.g:4856:30: ( RULE_WS )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>='\t' && LA36_0<='\n')||LA36_0=='\r'||LA36_0==' ') ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalPerl.g:4856:30: RULE_WS
                    {
                    mRULE_WS(); 

                    }
                    break;

            }

            // InternalPerl.g:4856:39: ( '{' ( options {greedy=false; } : . )* '}' | '(' ( options {greedy=false; } : . )* ')' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' )
            int alt42=5;
            switch ( input.LA(1) ) {
            case '{':
                {
                alt42=1;
                }
                break;
            case '(':
                {
                alt42=2;
                }
                break;
            case '|':
                {
                alt42=3;
                }
                break;
            case '/':
                {
                alt42=4;
                }
                break;
            case '<':
                {
                alt42=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalPerl.g:4856:40: '{' ( options {greedy=false; } : . )* '}'
                    {
                    match('{'); 
                    // InternalPerl.g:4856:44: ( options {greedy=false; } : . )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0=='}') ) {
                            alt37=2;
                        }
                        else if ( ((LA37_0>='\u0000' && LA37_0<='|')||(LA37_0>='~' && LA37_0<='\uFFFF')) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalPerl.g:4856:72: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    match('}'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4856:80: '(' ( options {greedy=false; } : . )* ')'
                    {
                    match('('); 
                    // InternalPerl.g:4856:84: ( options {greedy=false; } : . )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==')') ) {
                            alt38=2;
                        }
                        else if ( ((LA38_0>='\u0000' && LA38_0<='(')||(LA38_0>='*' && LA38_0<='\uFFFF')) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalPerl.g:4856:112: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    match(')'); 

                    }
                    break;
                case 3 :
                    // InternalPerl.g:4856:120: '|' ( options {greedy=false; } : . )* '|'
                    {
                    match('|'); 
                    // InternalPerl.g:4856:124: ( options {greedy=false; } : . )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0=='|') ) {
                            alt39=2;
                        }
                        else if ( ((LA39_0>='\u0000' && LA39_0<='{')||(LA39_0>='}' && LA39_0<='\uFFFF')) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalPerl.g:4856:152: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    match('|'); 

                    }
                    break;
                case 4 :
                    // InternalPerl.g:4856:160: '/' ( options {greedy=false; } : . )* '/'
                    {
                    match('/'); 
                    // InternalPerl.g:4856:164: ( options {greedy=false; } : . )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0=='/') ) {
                            alt40=2;
                        }
                        else if ( ((LA40_0>='\u0000' && LA40_0<='.')||(LA40_0>='0' && LA40_0<='\uFFFF')) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalPerl.g:4856:192: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    match('/'); 

                    }
                    break;
                case 5 :
                    // InternalPerl.g:4856:200: '<' ( options {greedy=false; } : . )* '>'
                    {
                    match('<'); 
                    // InternalPerl.g:4856:204: ( options {greedy=false; } : . )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0=='>') ) {
                            alt41=2;
                        }
                        else if ( ((LA41_0>='\u0000' && LA41_0<='=')||(LA41_0>='?' && LA41_0<='\uFFFF')) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalPerl.g:4856:232: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);

                    match('>'); 

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
    // $ANTLR end "RULE_WORDS_QUOTE_LIKE"

    // $ANTLR start "RULE_COMMAND_QUOTE_LIKE"
    public final void mRULE_COMMAND_QUOTE_LIKE() throws RecognitionException {
        try {
            int _type = RULE_COMMAND_QUOTE_LIKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4858:25: ( 'qx' ( RULE_WS )? ( '{' ( options {greedy=false; } : . )* '}' | '(' ( options {greedy=false; } : . )* ')' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' ) )
            // InternalPerl.g:4858:27: 'qx' ( RULE_WS )? ( '{' ( options {greedy=false; } : . )* '}' | '(' ( options {greedy=false; } : . )* ')' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' )
            {
            match("qx"); 

            // InternalPerl.g:4858:32: ( RULE_WS )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>='\t' && LA43_0<='\n')||LA43_0=='\r'||LA43_0==' ') ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalPerl.g:4858:32: RULE_WS
                    {
                    mRULE_WS(); 

                    }
                    break;

            }

            // InternalPerl.g:4858:41: ( '{' ( options {greedy=false; } : . )* '}' | '(' ( options {greedy=false; } : . )* ')' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' )
            int alt49=5;
            switch ( input.LA(1) ) {
            case '{':
                {
                alt49=1;
                }
                break;
            case '(':
                {
                alt49=2;
                }
                break;
            case '|':
                {
                alt49=3;
                }
                break;
            case '/':
                {
                alt49=4;
                }
                break;
            case '<':
                {
                alt49=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalPerl.g:4858:42: '{' ( options {greedy=false; } : . )* '}'
                    {
                    match('{'); 
                    // InternalPerl.g:4858:46: ( options {greedy=false; } : . )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0=='}') ) {
                            alt44=2;
                        }
                        else if ( ((LA44_0>='\u0000' && LA44_0<='|')||(LA44_0>='~' && LA44_0<='\uFFFF')) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalPerl.g:4858:74: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    match('}'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4858:82: '(' ( options {greedy=false; } : . )* ')'
                    {
                    match('('); 
                    // InternalPerl.g:4858:86: ( options {greedy=false; } : . )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==')') ) {
                            alt45=2;
                        }
                        else if ( ((LA45_0>='\u0000' && LA45_0<='(')||(LA45_0>='*' && LA45_0<='\uFFFF')) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalPerl.g:4858:114: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    match(')'); 

                    }
                    break;
                case 3 :
                    // InternalPerl.g:4858:122: '|' ( options {greedy=false; } : . )* '|'
                    {
                    match('|'); 
                    // InternalPerl.g:4858:126: ( options {greedy=false; } : . )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0=='|') ) {
                            alt46=2;
                        }
                        else if ( ((LA46_0>='\u0000' && LA46_0<='{')||(LA46_0>='}' && LA46_0<='\uFFFF')) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalPerl.g:4858:154: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);

                    match('|'); 

                    }
                    break;
                case 4 :
                    // InternalPerl.g:4858:162: '/' ( options {greedy=false; } : . )* '/'
                    {
                    match('/'); 
                    // InternalPerl.g:4858:166: ( options {greedy=false; } : . )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0=='/') ) {
                            alt47=2;
                        }
                        else if ( ((LA47_0>='\u0000' && LA47_0<='.')||(LA47_0>='0' && LA47_0<='\uFFFF')) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalPerl.g:4858:194: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    match('/'); 

                    }
                    break;
                case 5 :
                    // InternalPerl.g:4858:202: '<' ( options {greedy=false; } : . )* '>'
                    {
                    match('<'); 
                    // InternalPerl.g:4858:206: ( options {greedy=false; } : . )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0=='>') ) {
                            alt48=2;
                        }
                        else if ( ((LA48_0>='\u0000' && LA48_0<='=')||(LA48_0>='?' && LA48_0<='\uFFFF')) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalPerl.g:4858:234: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    match('>'); 

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
    // $ANTLR end "RULE_COMMAND_QUOTE_LIKE"

    // $ANTLR start "RULE_REGEX_QUOTE"
    public final void mRULE_REGEX_QUOTE() throws RecognitionException {
        try {
            int _type = RULE_REGEX_QUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4860:18: ( 'qr' ( RULE_WS )? ( '{' ( options {greedy=false; } : . )* '}' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' ) )
            // InternalPerl.g:4860:20: 'qr' ( RULE_WS )? ( '{' ( options {greedy=false; } : . )* '}' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' )
            {
            match("qr"); 

            // InternalPerl.g:4860:25: ( RULE_WS )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>='\t' && LA50_0<='\n')||LA50_0=='\r'||LA50_0==' ') ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalPerl.g:4860:25: RULE_WS
                    {
                    mRULE_WS(); 

                    }
                    break;

            }

            // InternalPerl.g:4860:34: ( '{' ( options {greedy=false; } : . )* '}' | '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' | '<' ( options {greedy=false; } : . )* '>' )
            int alt55=4;
            switch ( input.LA(1) ) {
            case '{':
                {
                alt55=1;
                }
                break;
            case '|':
                {
                alt55=2;
                }
                break;
            case '/':
                {
                alt55=3;
                }
                break;
            case '<':
                {
                alt55=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalPerl.g:4860:35: '{' ( options {greedy=false; } : . )* '}'
                    {
                    match('{'); 
                    // InternalPerl.g:4860:39: ( options {greedy=false; } : . )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0=='}') ) {
                            alt51=2;
                        }
                        else if ( ((LA51_0>='\u0000' && LA51_0<='|')||(LA51_0>='~' && LA51_0<='\uFFFF')) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalPerl.g:4860:67: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);

                    match('}'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4860:75: '|' ( options {greedy=false; } : . )* '|'
                    {
                    match('|'); 
                    // InternalPerl.g:4860:79: ( options {greedy=false; } : . )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0=='|') ) {
                            alt52=2;
                        }
                        else if ( ((LA52_0>='\u0000' && LA52_0<='{')||(LA52_0>='}' && LA52_0<='\uFFFF')) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalPerl.g:4860:107: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    match('|'); 

                    }
                    break;
                case 3 :
                    // InternalPerl.g:4860:115: '/' ( options {greedy=false; } : . )* '/'
                    {
                    match('/'); 
                    // InternalPerl.g:4860:119: ( options {greedy=false; } : . )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0=='/') ) {
                            alt53=2;
                        }
                        else if ( ((LA53_0>='\u0000' && LA53_0<='.')||(LA53_0>='0' && LA53_0<='\uFFFF')) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalPerl.g:4860:147: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    match('/'); 

                    }
                    break;
                case 4 :
                    // InternalPerl.g:4860:155: '<' ( options {greedy=false; } : . )* '>'
                    {
                    match('<'); 
                    // InternalPerl.g:4860:159: ( options {greedy=false; } : . )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0=='>') ) {
                            alt54=2;
                        }
                        else if ( ((LA54_0>='\u0000' && LA54_0<='=')||(LA54_0>='?' && LA54_0<='\uFFFF')) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalPerl.g:4860:187: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    match('>'); 

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
    // $ANTLR end "RULE_REGEX_QUOTE"

    // $ANTLR start "RULE_REGEX_SUBSTITUTE"
    public final void mRULE_REGEX_SUBSTITUTE() throws RecognitionException {
        try {
            int _type = RULE_REGEX_SUBSTITUTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4862:23: ( 's' ( '|' ( options {greedy=false; } : . )* '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' ( options {greedy=false; } : . )* '/' ) )
            // InternalPerl.g:4862:25: 's' ( '|' ( options {greedy=false; } : . )* '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' ( options {greedy=false; } : . )* '/' )
            {
            match('s'); 
            // InternalPerl.g:4862:29: ( '|' ( options {greedy=false; } : . )* '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' ( options {greedy=false; } : . )* '/' )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0=='|') ) {
                alt60=1;
            }
            else if ( (LA60_0=='/') ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalPerl.g:4862:30: '|' ( options {greedy=false; } : . )* '|' ( options {greedy=false; } : . )* '|'
                    {
                    match('|'); 
                    // InternalPerl.g:4862:34: ( options {greedy=false; } : . )*
                    loop56:
                    do {
                        int alt56=2;
                        alt56 = dfa56.predict(input);
                        switch (alt56) {
                    	case 1 :
                    	    // InternalPerl.g:4862:62: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    match('|'); 
                    // InternalPerl.g:4862:70: ( options {greedy=false; } : . )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0=='|') ) {
                            alt57=2;
                        }
                        else if ( ((LA57_0>='\u0000' && LA57_0<='{')||(LA57_0>='}' && LA57_0<='\uFFFF')) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalPerl.g:4862:98: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);

                    match('|'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4862:106: '/' ( options {greedy=false; } : . )* '/' ( options {greedy=false; } : . )* '/'
                    {
                    match('/'); 
                    // InternalPerl.g:4862:110: ( options {greedy=false; } : . )*
                    loop58:
                    do {
                        int alt58=2;
                        alt58 = dfa58.predict(input);
                        switch (alt58) {
                    	case 1 :
                    	    // InternalPerl.g:4862:138: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    match('/'); 
                    // InternalPerl.g:4862:146: ( options {greedy=false; } : . )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0=='/') ) {
                            alt59=2;
                        }
                        else if ( ((LA59_0>='\u0000' && LA59_0<='.')||(LA59_0>='0' && LA59_0<='\uFFFF')) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // InternalPerl.g:4862:174: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);

                    match('/'); 

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
    // $ANTLR end "RULE_REGEX_SUBSTITUTE"

    // $ANTLR start "RULE_REGEX_TRANSLITERATE"
    public final void mRULE_REGEX_TRANSLITERATE() throws RecognitionException {
        try {
            int _type = RULE_REGEX_TRANSLITERATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4864:26: ( 'tr' ( '|' ( options {greedy=false; } : . )* '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' ( options {greedy=false; } : . )* '/' ) )
            // InternalPerl.g:4864:28: 'tr' ( '|' ( options {greedy=false; } : . )* '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' ( options {greedy=false; } : . )* '/' )
            {
            match("tr"); 

            // InternalPerl.g:4864:33: ( '|' ( options {greedy=false; } : . )* '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' ( options {greedy=false; } : . )* '/' )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0=='|') ) {
                alt65=1;
            }
            else if ( (LA65_0=='/') ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalPerl.g:4864:34: '|' ( options {greedy=false; } : . )* '|' ( options {greedy=false; } : . )* '|'
                    {
                    match('|'); 
                    // InternalPerl.g:4864:38: ( options {greedy=false; } : . )*
                    loop61:
                    do {
                        int alt61=2;
                        alt61 = dfa61.predict(input);
                        switch (alt61) {
                    	case 1 :
                    	    // InternalPerl.g:4864:66: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);

                    match('|'); 
                    // InternalPerl.g:4864:74: ( options {greedy=false; } : . )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0=='|') ) {
                            alt62=2;
                        }
                        else if ( ((LA62_0>='\u0000' && LA62_0<='{')||(LA62_0>='}' && LA62_0<='\uFFFF')) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalPerl.g:4864:102: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);

                    match('|'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4864:110: '/' ( options {greedy=false; } : . )* '/' ( options {greedy=false; } : . )* '/'
                    {
                    match('/'); 
                    // InternalPerl.g:4864:114: ( options {greedy=false; } : . )*
                    loop63:
                    do {
                        int alt63=2;
                        alt63 = dfa63.predict(input);
                        switch (alt63) {
                    	case 1 :
                    	    // InternalPerl.g:4864:142: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);

                    match('/'); 
                    // InternalPerl.g:4864:150: ( options {greedy=false; } : . )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0=='/') ) {
                            alt64=2;
                        }
                        else if ( ((LA64_0>='\u0000' && LA64_0<='.')||(LA64_0>='0' && LA64_0<='\uFFFF')) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalPerl.g:4864:178: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);

                    match('/'); 

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
    // $ANTLR end "RULE_REGEX_TRANSLITERATE"

    // $ANTLR start "RULE_REGEX_MATCH"
    public final void mRULE_REGEX_MATCH() throws RecognitionException {
        try {
            int _type = RULE_REGEX_MATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4866:18: ( 'm' ( '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' ) )
            // InternalPerl.g:4866:20: 'm' ( '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' )
            {
            match('m'); 
            // InternalPerl.g:4866:24: ( '|' ( options {greedy=false; } : . )* '|' | '/' ( options {greedy=false; } : . )* '/' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0=='|') ) {
                alt68=1;
            }
            else if ( (LA68_0=='/') ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalPerl.g:4866:25: '|' ( options {greedy=false; } : . )* '|'
                    {
                    match('|'); 
                    // InternalPerl.g:4866:29: ( options {greedy=false; } : . )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0=='|') ) {
                            alt66=2;
                        }
                        else if ( ((LA66_0>='\u0000' && LA66_0<='{')||(LA66_0>='}' && LA66_0<='\uFFFF')) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalPerl.g:4866:57: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);

                    match('|'); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4866:65: '/' ( options {greedy=false; } : . )* '/'
                    {
                    match('/'); 
                    // InternalPerl.g:4866:69: ( options {greedy=false; } : . )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0=='/') ) {
                            alt67=2;
                        }
                        else if ( ((LA67_0>='\u0000' && LA67_0<='.')||(LA67_0>='0' && LA67_0<='\uFFFF')) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalPerl.g:4866:97: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);

                    match('/'); 

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
    // $ANTLR end "RULE_REGEX_MATCH"

    // $ANTLR start "RULE_READLINE_QUOTE"
    public final void mRULE_READLINE_QUOTE() throws RecognitionException {
        try {
            int _type = RULE_READLINE_QUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4868:21: ( '<' ( RULE_ID | RULE_SYMBOL ) '>' )
            // InternalPerl.g:4868:23: '<' ( RULE_ID | RULE_SYMBOL ) '>'
            {
            match('<'); 
            // InternalPerl.g:4868:27: ( RULE_ID | RULE_SYMBOL )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>='A' && LA69_0<='Z')||LA69_0=='_'||(LA69_0>='a' && LA69_0<='z')) ) {
                alt69=1;
            }
            else if ( ((LA69_0>='$' && LA69_0<='%')||LA69_0=='@') ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalPerl.g:4868:28: RULE_ID
                    {
                    mRULE_ID(); 

                    }
                    break;
                case 2 :
                    // InternalPerl.g:4868:36: RULE_SYMBOL
                    {
                    mRULE_SYMBOL(); 

                    }
                    break;

            }

            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_READLINE_QUOTE"

    // $ANTLR start "RULE_POD"
    public final void mRULE_POD() throws RecognitionException {
        try {
            int _type = RULE_POD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4870:10: ( '=pod' ( options {greedy=false; } : . )* '=cut' )
            // InternalPerl.g:4870:12: '=pod' ( options {greedy=false; } : . )* '=cut'
            {
            match("=pod"); 

            // InternalPerl.g:4870:19: ( options {greedy=false; } : . )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0=='=') ) {
                    int LA70_1 = input.LA(2);

                    if ( (LA70_1=='c') ) {
                        int LA70_3 = input.LA(3);

                        if ( (LA70_3=='u') ) {
                            int LA70_4 = input.LA(4);

                            if ( (LA70_4=='t') ) {
                                alt70=2;
                            }
                            else if ( ((LA70_4>='\u0000' && LA70_4<='s')||(LA70_4>='u' && LA70_4<='\uFFFF')) ) {
                                alt70=1;
                            }


                        }
                        else if ( ((LA70_3>='\u0000' && LA70_3<='t')||(LA70_3>='v' && LA70_3<='\uFFFF')) ) {
                            alt70=1;
                        }


                    }
                    else if ( ((LA70_1>='\u0000' && LA70_1<='b')||(LA70_1>='d' && LA70_1<='\uFFFF')) ) {
                        alt70=1;
                    }


                }
                else if ( ((LA70_0>='\u0000' && LA70_0<='<')||(LA70_0>='>' && LA70_0<='\uFFFF')) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalPerl.g:4870:47: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);

            match("=cut"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_POD"

    // $ANTLR start "RULE_DATA"
    public final void mRULE_DATA() throws RecognitionException {
        try {
            int _type = RULE_DATA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4872:11: ( '__DATA__' ( RULE_ANY_OTHER )* EOF )
            // InternalPerl.g:4872:13: '__DATA__' ( RULE_ANY_OTHER )* EOF
            {
            match("__DATA__"); 

            // InternalPerl.g:4872:24: ( RULE_ANY_OTHER )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( ((LA71_0>='\u0000' && LA71_0<='\uFFFF')) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalPerl.g:4872:24: RULE_ANY_OTHER
            	    {
            	    mRULE_ANY_OTHER(); 

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            match(EOF); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DATA"

    // $ANTLR start "RULE_END"
    public final void mRULE_END() throws RecognitionException {
        try {
            int _type = RULE_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4874:10: ( '__END__' ( RULE_ANY_OTHER )* EOF )
            // InternalPerl.g:4874:12: '__END__' ( RULE_ANY_OTHER )* EOF
            {
            match("__END__"); 

            // InternalPerl.g:4874:22: ( RULE_ANY_OTHER )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( ((LA72_0>='\u0000' && LA72_0<='\uFFFF')) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalPerl.g:4874:22: RULE_ANY_OTHER
            	    {
            	    mRULE_ANY_OTHER(); 

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            match(EOF); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_END"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPerl.g:4876:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalPerl.g:4876:19: '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match('#'); 
            // InternalPerl.g:4876:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( ((LA73_0>='\u0000' && LA73_0<='\t')||(LA73_0>='\u000B' && LA73_0<='\f')||(LA73_0>='\u000E' && LA73_0<='\uFFFF')) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalPerl.g:4876:23: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop73;
                }
            } while (true);

            // InternalPerl.g:4876:39: ( ( '\\r' )? '\\n' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0=='\n'||LA75_0=='\r') ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalPerl.g:4876:40: ( '\\r' )? '\\n'
                    {
                    // InternalPerl.g:4876:40: ( '\\r' )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0=='\r') ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalPerl.g:4876:40: '\\r'
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
            // InternalPerl.g:4878:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalPerl.g:4878:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalPerl.g:4878:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt76=0;
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( ((LA76_0>='\t' && LA76_0<='\n')||LA76_0=='\r'||LA76_0==' ') ) {
                    alt76=1;
                }


                switch (alt76) {
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
            	    if ( cnt76 >= 1 ) break loop76;
                        EarlyExitException eee =
                            new EarlyExitException(76, input);
                        throw eee;
                }
                cnt76++;
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
            // InternalPerl.g:4880:25: ( . )
            // InternalPerl.g:4880:27: .
            {
            matchAny(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalPerl.g:1:8: ( T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | T__148 | T__149 | T__150 | T__151 | T__152 | T__153 | T__154 | T__155 | T__156 | T__157 | T__158 | T__159 | T__160 | T__161 | T__162 | T__163 | T__164 | T__165 | T__166 | T__167 | T__168 | T__169 | T__170 | T__171 | T__172 | T__173 | T__174 | T__175 | T__176 | T__177 | T__178 | T__179 | T__180 | T__181 | T__182 | T__183 | T__184 | T__185 | T__186 | T__187 | T__188 | T__189 | T__190 | T__191 | T__192 | T__193 | T__194 | T__195 | T__196 | T__197 | T__198 | T__199 | T__200 | T__201 | T__202 | T__203 | T__204 | T__205 | T__206 | T__207 | T__208 | T__209 | T__210 | T__211 | T__212 | T__213 | T__214 | T__215 | T__216 | T__217 | T__218 | T__219 | T__220 | T__221 | T__222 | T__223 | T__224 | T__225 | T__226 | T__227 | T__228 | T__229 | T__230 | T__231 | T__232 | T__233 | T__234 | T__235 | T__236 | T__237 | T__238 | T__239 | T__240 | T__241 | T__242 | T__243 | T__244 | T__245 | T__246 | T__247 | T__248 | T__249 | T__250 | T__251 | T__252 | T__253 | T__254 | T__255 | T__256 | T__257 | T__258 | T__259 | T__260 | T__261 | T__262 | T__263 | T__264 | T__265 | T__266 | T__267 | T__268 | T__269 | T__270 | T__271 | T__272 | T__273 | T__274 | T__275 | T__276 | T__277 | T__278 | T__279 | T__280 | T__281 | T__282 | T__283 | T__284 | T__285 | T__286 | T__287 | T__288 | T__289 | T__290 | T__291 | T__292 | T__293 | T__294 | T__295 | T__296 | T__297 | T__298 | T__299 | T__300 | T__301 | T__302 | T__303 | T__304 | T__305 | T__306 | T__307 | T__308 | T__309 | T__310 | T__311 | T__312 | T__313 | T__314 | T__315 | T__316 | T__317 | T__318 | T__319 | T__320 | T__321 | T__322 | T__323 | T__324 | T__325 | T__326 | T__327 | T__328 | T__329 | T__330 | T__331 | T__332 | T__333 | T__334 | T__335 | T__336 | T__337 | T__338 | T__339 | T__340 | T__341 | T__342 | T__343 | T__344 | T__345 | T__346 | T__347 | T__348 | RULE_NUMBER | RULE_ID | RULE_SYMBOL | RULE_VERSION | RULE_STRING | RULE_BACKTICK_STRING | RULE_INTERPOLATE | RULE_LITERAL | RULE_WORDS_QUOTE_LIKE | RULE_COMMAND_QUOTE_LIKE | RULE_REGEX_QUOTE | RULE_REGEX_SUBSTITUTE | RULE_REGEX_TRANSLITERATE | RULE_REGEX_MATCH | RULE_READLINE_QUOTE | RULE_POD | RULE_DATA | RULE_END | RULE_SL_COMMENT | RULE_WS )
        int alt77=341;
        alt77 = dfa77.predict(input);
        switch (alt77) {
            case 1 :
                // InternalPerl.g:1:10: T__28
                {
                mT__28(); 

                }
                break;
            case 2 :
                // InternalPerl.g:1:16: T__29
                {
                mT__29(); 

                }
                break;
            case 3 :
                // InternalPerl.g:1:22: T__30
                {
                mT__30(); 

                }
                break;
            case 4 :
                // InternalPerl.g:1:28: T__31
                {
                mT__31(); 

                }
                break;
            case 5 :
                // InternalPerl.g:1:34: T__32
                {
                mT__32(); 

                }
                break;
            case 6 :
                // InternalPerl.g:1:40: T__33
                {
                mT__33(); 

                }
                break;
            case 7 :
                // InternalPerl.g:1:46: T__34
                {
                mT__34(); 

                }
                break;
            case 8 :
                // InternalPerl.g:1:52: T__35
                {
                mT__35(); 

                }
                break;
            case 9 :
                // InternalPerl.g:1:58: T__36
                {
                mT__36(); 

                }
                break;
            case 10 :
                // InternalPerl.g:1:64: T__37
                {
                mT__37(); 

                }
                break;
            case 11 :
                // InternalPerl.g:1:70: T__38
                {
                mT__38(); 

                }
                break;
            case 12 :
                // InternalPerl.g:1:76: T__39
                {
                mT__39(); 

                }
                break;
            case 13 :
                // InternalPerl.g:1:82: T__40
                {
                mT__40(); 

                }
                break;
            case 14 :
                // InternalPerl.g:1:88: T__41
                {
                mT__41(); 

                }
                break;
            case 15 :
                // InternalPerl.g:1:94: T__42
                {
                mT__42(); 

                }
                break;
            case 16 :
                // InternalPerl.g:1:100: T__43
                {
                mT__43(); 

                }
                break;
            case 17 :
                // InternalPerl.g:1:106: T__44
                {
                mT__44(); 

                }
                break;
            case 18 :
                // InternalPerl.g:1:112: T__45
                {
                mT__45(); 

                }
                break;
            case 19 :
                // InternalPerl.g:1:118: T__46
                {
                mT__46(); 

                }
                break;
            case 20 :
                // InternalPerl.g:1:124: T__47
                {
                mT__47(); 

                }
                break;
            case 21 :
                // InternalPerl.g:1:130: T__48
                {
                mT__48(); 

                }
                break;
            case 22 :
                // InternalPerl.g:1:136: T__49
                {
                mT__49(); 

                }
                break;
            case 23 :
                // InternalPerl.g:1:142: T__50
                {
                mT__50(); 

                }
                break;
            case 24 :
                // InternalPerl.g:1:148: T__51
                {
                mT__51(); 

                }
                break;
            case 25 :
                // InternalPerl.g:1:154: T__52
                {
                mT__52(); 

                }
                break;
            case 26 :
                // InternalPerl.g:1:160: T__53
                {
                mT__53(); 

                }
                break;
            case 27 :
                // InternalPerl.g:1:166: T__54
                {
                mT__54(); 

                }
                break;
            case 28 :
                // InternalPerl.g:1:172: T__55
                {
                mT__55(); 

                }
                break;
            case 29 :
                // InternalPerl.g:1:178: T__56
                {
                mT__56(); 

                }
                break;
            case 30 :
                // InternalPerl.g:1:184: T__57
                {
                mT__57(); 

                }
                break;
            case 31 :
                // InternalPerl.g:1:190: T__58
                {
                mT__58(); 

                }
                break;
            case 32 :
                // InternalPerl.g:1:196: T__59
                {
                mT__59(); 

                }
                break;
            case 33 :
                // InternalPerl.g:1:202: T__60
                {
                mT__60(); 

                }
                break;
            case 34 :
                // InternalPerl.g:1:208: T__61
                {
                mT__61(); 

                }
                break;
            case 35 :
                // InternalPerl.g:1:214: T__62
                {
                mT__62(); 

                }
                break;
            case 36 :
                // InternalPerl.g:1:220: T__63
                {
                mT__63(); 

                }
                break;
            case 37 :
                // InternalPerl.g:1:226: T__64
                {
                mT__64(); 

                }
                break;
            case 38 :
                // InternalPerl.g:1:232: T__65
                {
                mT__65(); 

                }
                break;
            case 39 :
                // InternalPerl.g:1:238: T__66
                {
                mT__66(); 

                }
                break;
            case 40 :
                // InternalPerl.g:1:244: T__67
                {
                mT__67(); 

                }
                break;
            case 41 :
                // InternalPerl.g:1:250: T__68
                {
                mT__68(); 

                }
                break;
            case 42 :
                // InternalPerl.g:1:256: T__69
                {
                mT__69(); 

                }
                break;
            case 43 :
                // InternalPerl.g:1:262: T__70
                {
                mT__70(); 

                }
                break;
            case 44 :
                // InternalPerl.g:1:268: T__71
                {
                mT__71(); 

                }
                break;
            case 45 :
                // InternalPerl.g:1:274: T__72
                {
                mT__72(); 

                }
                break;
            case 46 :
                // InternalPerl.g:1:280: T__73
                {
                mT__73(); 

                }
                break;
            case 47 :
                // InternalPerl.g:1:286: T__74
                {
                mT__74(); 

                }
                break;
            case 48 :
                // InternalPerl.g:1:292: T__75
                {
                mT__75(); 

                }
                break;
            case 49 :
                // InternalPerl.g:1:298: T__76
                {
                mT__76(); 

                }
                break;
            case 50 :
                // InternalPerl.g:1:304: T__77
                {
                mT__77(); 

                }
                break;
            case 51 :
                // InternalPerl.g:1:310: T__78
                {
                mT__78(); 

                }
                break;
            case 52 :
                // InternalPerl.g:1:316: T__79
                {
                mT__79(); 

                }
                break;
            case 53 :
                // InternalPerl.g:1:322: T__80
                {
                mT__80(); 

                }
                break;
            case 54 :
                // InternalPerl.g:1:328: T__81
                {
                mT__81(); 

                }
                break;
            case 55 :
                // InternalPerl.g:1:334: T__82
                {
                mT__82(); 

                }
                break;
            case 56 :
                // InternalPerl.g:1:340: T__83
                {
                mT__83(); 

                }
                break;
            case 57 :
                // InternalPerl.g:1:346: T__84
                {
                mT__84(); 

                }
                break;
            case 58 :
                // InternalPerl.g:1:352: T__85
                {
                mT__85(); 

                }
                break;
            case 59 :
                // InternalPerl.g:1:358: T__86
                {
                mT__86(); 

                }
                break;
            case 60 :
                // InternalPerl.g:1:364: T__87
                {
                mT__87(); 

                }
                break;
            case 61 :
                // InternalPerl.g:1:370: T__88
                {
                mT__88(); 

                }
                break;
            case 62 :
                // InternalPerl.g:1:376: T__89
                {
                mT__89(); 

                }
                break;
            case 63 :
                // InternalPerl.g:1:382: T__90
                {
                mT__90(); 

                }
                break;
            case 64 :
                // InternalPerl.g:1:388: T__91
                {
                mT__91(); 

                }
                break;
            case 65 :
                // InternalPerl.g:1:394: T__92
                {
                mT__92(); 

                }
                break;
            case 66 :
                // InternalPerl.g:1:400: T__93
                {
                mT__93(); 

                }
                break;
            case 67 :
                // InternalPerl.g:1:406: T__94
                {
                mT__94(); 

                }
                break;
            case 68 :
                // InternalPerl.g:1:412: T__95
                {
                mT__95(); 

                }
                break;
            case 69 :
                // InternalPerl.g:1:418: T__96
                {
                mT__96(); 

                }
                break;
            case 70 :
                // InternalPerl.g:1:424: T__97
                {
                mT__97(); 

                }
                break;
            case 71 :
                // InternalPerl.g:1:430: T__98
                {
                mT__98(); 

                }
                break;
            case 72 :
                // InternalPerl.g:1:436: T__99
                {
                mT__99(); 

                }
                break;
            case 73 :
                // InternalPerl.g:1:442: T__100
                {
                mT__100(); 

                }
                break;
            case 74 :
                // InternalPerl.g:1:449: T__101
                {
                mT__101(); 

                }
                break;
            case 75 :
                // InternalPerl.g:1:456: T__102
                {
                mT__102(); 

                }
                break;
            case 76 :
                // InternalPerl.g:1:463: T__103
                {
                mT__103(); 

                }
                break;
            case 77 :
                // InternalPerl.g:1:470: T__104
                {
                mT__104(); 

                }
                break;
            case 78 :
                // InternalPerl.g:1:477: T__105
                {
                mT__105(); 

                }
                break;
            case 79 :
                // InternalPerl.g:1:484: T__106
                {
                mT__106(); 

                }
                break;
            case 80 :
                // InternalPerl.g:1:491: T__107
                {
                mT__107(); 

                }
                break;
            case 81 :
                // InternalPerl.g:1:498: T__108
                {
                mT__108(); 

                }
                break;
            case 82 :
                // InternalPerl.g:1:505: T__109
                {
                mT__109(); 

                }
                break;
            case 83 :
                // InternalPerl.g:1:512: T__110
                {
                mT__110(); 

                }
                break;
            case 84 :
                // InternalPerl.g:1:519: T__111
                {
                mT__111(); 

                }
                break;
            case 85 :
                // InternalPerl.g:1:526: T__112
                {
                mT__112(); 

                }
                break;
            case 86 :
                // InternalPerl.g:1:533: T__113
                {
                mT__113(); 

                }
                break;
            case 87 :
                // InternalPerl.g:1:540: T__114
                {
                mT__114(); 

                }
                break;
            case 88 :
                // InternalPerl.g:1:547: T__115
                {
                mT__115(); 

                }
                break;
            case 89 :
                // InternalPerl.g:1:554: T__116
                {
                mT__116(); 

                }
                break;
            case 90 :
                // InternalPerl.g:1:561: T__117
                {
                mT__117(); 

                }
                break;
            case 91 :
                // InternalPerl.g:1:568: T__118
                {
                mT__118(); 

                }
                break;
            case 92 :
                // InternalPerl.g:1:575: T__119
                {
                mT__119(); 

                }
                break;
            case 93 :
                // InternalPerl.g:1:582: T__120
                {
                mT__120(); 

                }
                break;
            case 94 :
                // InternalPerl.g:1:589: T__121
                {
                mT__121(); 

                }
                break;
            case 95 :
                // InternalPerl.g:1:596: T__122
                {
                mT__122(); 

                }
                break;
            case 96 :
                // InternalPerl.g:1:603: T__123
                {
                mT__123(); 

                }
                break;
            case 97 :
                // InternalPerl.g:1:610: T__124
                {
                mT__124(); 

                }
                break;
            case 98 :
                // InternalPerl.g:1:617: T__125
                {
                mT__125(); 

                }
                break;
            case 99 :
                // InternalPerl.g:1:624: T__126
                {
                mT__126(); 

                }
                break;
            case 100 :
                // InternalPerl.g:1:631: T__127
                {
                mT__127(); 

                }
                break;
            case 101 :
                // InternalPerl.g:1:638: T__128
                {
                mT__128(); 

                }
                break;
            case 102 :
                // InternalPerl.g:1:645: T__129
                {
                mT__129(); 

                }
                break;
            case 103 :
                // InternalPerl.g:1:652: T__130
                {
                mT__130(); 

                }
                break;
            case 104 :
                // InternalPerl.g:1:659: T__131
                {
                mT__131(); 

                }
                break;
            case 105 :
                // InternalPerl.g:1:666: T__132
                {
                mT__132(); 

                }
                break;
            case 106 :
                // InternalPerl.g:1:673: T__133
                {
                mT__133(); 

                }
                break;
            case 107 :
                // InternalPerl.g:1:680: T__134
                {
                mT__134(); 

                }
                break;
            case 108 :
                // InternalPerl.g:1:687: T__135
                {
                mT__135(); 

                }
                break;
            case 109 :
                // InternalPerl.g:1:694: T__136
                {
                mT__136(); 

                }
                break;
            case 110 :
                // InternalPerl.g:1:701: T__137
                {
                mT__137(); 

                }
                break;
            case 111 :
                // InternalPerl.g:1:708: T__138
                {
                mT__138(); 

                }
                break;
            case 112 :
                // InternalPerl.g:1:715: T__139
                {
                mT__139(); 

                }
                break;
            case 113 :
                // InternalPerl.g:1:722: T__140
                {
                mT__140(); 

                }
                break;
            case 114 :
                // InternalPerl.g:1:729: T__141
                {
                mT__141(); 

                }
                break;
            case 115 :
                // InternalPerl.g:1:736: T__142
                {
                mT__142(); 

                }
                break;
            case 116 :
                // InternalPerl.g:1:743: T__143
                {
                mT__143(); 

                }
                break;
            case 117 :
                // InternalPerl.g:1:750: T__144
                {
                mT__144(); 

                }
                break;
            case 118 :
                // InternalPerl.g:1:757: T__145
                {
                mT__145(); 

                }
                break;
            case 119 :
                // InternalPerl.g:1:764: T__146
                {
                mT__146(); 

                }
                break;
            case 120 :
                // InternalPerl.g:1:771: T__147
                {
                mT__147(); 

                }
                break;
            case 121 :
                // InternalPerl.g:1:778: T__148
                {
                mT__148(); 

                }
                break;
            case 122 :
                // InternalPerl.g:1:785: T__149
                {
                mT__149(); 

                }
                break;
            case 123 :
                // InternalPerl.g:1:792: T__150
                {
                mT__150(); 

                }
                break;
            case 124 :
                // InternalPerl.g:1:799: T__151
                {
                mT__151(); 

                }
                break;
            case 125 :
                // InternalPerl.g:1:806: T__152
                {
                mT__152(); 

                }
                break;
            case 126 :
                // InternalPerl.g:1:813: T__153
                {
                mT__153(); 

                }
                break;
            case 127 :
                // InternalPerl.g:1:820: T__154
                {
                mT__154(); 

                }
                break;
            case 128 :
                // InternalPerl.g:1:827: T__155
                {
                mT__155(); 

                }
                break;
            case 129 :
                // InternalPerl.g:1:834: T__156
                {
                mT__156(); 

                }
                break;
            case 130 :
                // InternalPerl.g:1:841: T__157
                {
                mT__157(); 

                }
                break;
            case 131 :
                // InternalPerl.g:1:848: T__158
                {
                mT__158(); 

                }
                break;
            case 132 :
                // InternalPerl.g:1:855: T__159
                {
                mT__159(); 

                }
                break;
            case 133 :
                // InternalPerl.g:1:862: T__160
                {
                mT__160(); 

                }
                break;
            case 134 :
                // InternalPerl.g:1:869: T__161
                {
                mT__161(); 

                }
                break;
            case 135 :
                // InternalPerl.g:1:876: T__162
                {
                mT__162(); 

                }
                break;
            case 136 :
                // InternalPerl.g:1:883: T__163
                {
                mT__163(); 

                }
                break;
            case 137 :
                // InternalPerl.g:1:890: T__164
                {
                mT__164(); 

                }
                break;
            case 138 :
                // InternalPerl.g:1:897: T__165
                {
                mT__165(); 

                }
                break;
            case 139 :
                // InternalPerl.g:1:904: T__166
                {
                mT__166(); 

                }
                break;
            case 140 :
                // InternalPerl.g:1:911: T__167
                {
                mT__167(); 

                }
                break;
            case 141 :
                // InternalPerl.g:1:918: T__168
                {
                mT__168(); 

                }
                break;
            case 142 :
                // InternalPerl.g:1:925: T__169
                {
                mT__169(); 

                }
                break;
            case 143 :
                // InternalPerl.g:1:932: T__170
                {
                mT__170(); 

                }
                break;
            case 144 :
                // InternalPerl.g:1:939: T__171
                {
                mT__171(); 

                }
                break;
            case 145 :
                // InternalPerl.g:1:946: T__172
                {
                mT__172(); 

                }
                break;
            case 146 :
                // InternalPerl.g:1:953: T__173
                {
                mT__173(); 

                }
                break;
            case 147 :
                // InternalPerl.g:1:960: T__174
                {
                mT__174(); 

                }
                break;
            case 148 :
                // InternalPerl.g:1:967: T__175
                {
                mT__175(); 

                }
                break;
            case 149 :
                // InternalPerl.g:1:974: T__176
                {
                mT__176(); 

                }
                break;
            case 150 :
                // InternalPerl.g:1:981: T__177
                {
                mT__177(); 

                }
                break;
            case 151 :
                // InternalPerl.g:1:988: T__178
                {
                mT__178(); 

                }
                break;
            case 152 :
                // InternalPerl.g:1:995: T__179
                {
                mT__179(); 

                }
                break;
            case 153 :
                // InternalPerl.g:1:1002: T__180
                {
                mT__180(); 

                }
                break;
            case 154 :
                // InternalPerl.g:1:1009: T__181
                {
                mT__181(); 

                }
                break;
            case 155 :
                // InternalPerl.g:1:1016: T__182
                {
                mT__182(); 

                }
                break;
            case 156 :
                // InternalPerl.g:1:1023: T__183
                {
                mT__183(); 

                }
                break;
            case 157 :
                // InternalPerl.g:1:1030: T__184
                {
                mT__184(); 

                }
                break;
            case 158 :
                // InternalPerl.g:1:1037: T__185
                {
                mT__185(); 

                }
                break;
            case 159 :
                // InternalPerl.g:1:1044: T__186
                {
                mT__186(); 

                }
                break;
            case 160 :
                // InternalPerl.g:1:1051: T__187
                {
                mT__187(); 

                }
                break;
            case 161 :
                // InternalPerl.g:1:1058: T__188
                {
                mT__188(); 

                }
                break;
            case 162 :
                // InternalPerl.g:1:1065: T__189
                {
                mT__189(); 

                }
                break;
            case 163 :
                // InternalPerl.g:1:1072: T__190
                {
                mT__190(); 

                }
                break;
            case 164 :
                // InternalPerl.g:1:1079: T__191
                {
                mT__191(); 

                }
                break;
            case 165 :
                // InternalPerl.g:1:1086: T__192
                {
                mT__192(); 

                }
                break;
            case 166 :
                // InternalPerl.g:1:1093: T__193
                {
                mT__193(); 

                }
                break;
            case 167 :
                // InternalPerl.g:1:1100: T__194
                {
                mT__194(); 

                }
                break;
            case 168 :
                // InternalPerl.g:1:1107: T__195
                {
                mT__195(); 

                }
                break;
            case 169 :
                // InternalPerl.g:1:1114: T__196
                {
                mT__196(); 

                }
                break;
            case 170 :
                // InternalPerl.g:1:1121: T__197
                {
                mT__197(); 

                }
                break;
            case 171 :
                // InternalPerl.g:1:1128: T__198
                {
                mT__198(); 

                }
                break;
            case 172 :
                // InternalPerl.g:1:1135: T__199
                {
                mT__199(); 

                }
                break;
            case 173 :
                // InternalPerl.g:1:1142: T__200
                {
                mT__200(); 

                }
                break;
            case 174 :
                // InternalPerl.g:1:1149: T__201
                {
                mT__201(); 

                }
                break;
            case 175 :
                // InternalPerl.g:1:1156: T__202
                {
                mT__202(); 

                }
                break;
            case 176 :
                // InternalPerl.g:1:1163: T__203
                {
                mT__203(); 

                }
                break;
            case 177 :
                // InternalPerl.g:1:1170: T__204
                {
                mT__204(); 

                }
                break;
            case 178 :
                // InternalPerl.g:1:1177: T__205
                {
                mT__205(); 

                }
                break;
            case 179 :
                // InternalPerl.g:1:1184: T__206
                {
                mT__206(); 

                }
                break;
            case 180 :
                // InternalPerl.g:1:1191: T__207
                {
                mT__207(); 

                }
                break;
            case 181 :
                // InternalPerl.g:1:1198: T__208
                {
                mT__208(); 

                }
                break;
            case 182 :
                // InternalPerl.g:1:1205: T__209
                {
                mT__209(); 

                }
                break;
            case 183 :
                // InternalPerl.g:1:1212: T__210
                {
                mT__210(); 

                }
                break;
            case 184 :
                // InternalPerl.g:1:1219: T__211
                {
                mT__211(); 

                }
                break;
            case 185 :
                // InternalPerl.g:1:1226: T__212
                {
                mT__212(); 

                }
                break;
            case 186 :
                // InternalPerl.g:1:1233: T__213
                {
                mT__213(); 

                }
                break;
            case 187 :
                // InternalPerl.g:1:1240: T__214
                {
                mT__214(); 

                }
                break;
            case 188 :
                // InternalPerl.g:1:1247: T__215
                {
                mT__215(); 

                }
                break;
            case 189 :
                // InternalPerl.g:1:1254: T__216
                {
                mT__216(); 

                }
                break;
            case 190 :
                // InternalPerl.g:1:1261: T__217
                {
                mT__217(); 

                }
                break;
            case 191 :
                // InternalPerl.g:1:1268: T__218
                {
                mT__218(); 

                }
                break;
            case 192 :
                // InternalPerl.g:1:1275: T__219
                {
                mT__219(); 

                }
                break;
            case 193 :
                // InternalPerl.g:1:1282: T__220
                {
                mT__220(); 

                }
                break;
            case 194 :
                // InternalPerl.g:1:1289: T__221
                {
                mT__221(); 

                }
                break;
            case 195 :
                // InternalPerl.g:1:1296: T__222
                {
                mT__222(); 

                }
                break;
            case 196 :
                // InternalPerl.g:1:1303: T__223
                {
                mT__223(); 

                }
                break;
            case 197 :
                // InternalPerl.g:1:1310: T__224
                {
                mT__224(); 

                }
                break;
            case 198 :
                // InternalPerl.g:1:1317: T__225
                {
                mT__225(); 

                }
                break;
            case 199 :
                // InternalPerl.g:1:1324: T__226
                {
                mT__226(); 

                }
                break;
            case 200 :
                // InternalPerl.g:1:1331: T__227
                {
                mT__227(); 

                }
                break;
            case 201 :
                // InternalPerl.g:1:1338: T__228
                {
                mT__228(); 

                }
                break;
            case 202 :
                // InternalPerl.g:1:1345: T__229
                {
                mT__229(); 

                }
                break;
            case 203 :
                // InternalPerl.g:1:1352: T__230
                {
                mT__230(); 

                }
                break;
            case 204 :
                // InternalPerl.g:1:1359: T__231
                {
                mT__231(); 

                }
                break;
            case 205 :
                // InternalPerl.g:1:1366: T__232
                {
                mT__232(); 

                }
                break;
            case 206 :
                // InternalPerl.g:1:1373: T__233
                {
                mT__233(); 

                }
                break;
            case 207 :
                // InternalPerl.g:1:1380: T__234
                {
                mT__234(); 

                }
                break;
            case 208 :
                // InternalPerl.g:1:1387: T__235
                {
                mT__235(); 

                }
                break;
            case 209 :
                // InternalPerl.g:1:1394: T__236
                {
                mT__236(); 

                }
                break;
            case 210 :
                // InternalPerl.g:1:1401: T__237
                {
                mT__237(); 

                }
                break;
            case 211 :
                // InternalPerl.g:1:1408: T__238
                {
                mT__238(); 

                }
                break;
            case 212 :
                // InternalPerl.g:1:1415: T__239
                {
                mT__239(); 

                }
                break;
            case 213 :
                // InternalPerl.g:1:1422: T__240
                {
                mT__240(); 

                }
                break;
            case 214 :
                // InternalPerl.g:1:1429: T__241
                {
                mT__241(); 

                }
                break;
            case 215 :
                // InternalPerl.g:1:1436: T__242
                {
                mT__242(); 

                }
                break;
            case 216 :
                // InternalPerl.g:1:1443: T__243
                {
                mT__243(); 

                }
                break;
            case 217 :
                // InternalPerl.g:1:1450: T__244
                {
                mT__244(); 

                }
                break;
            case 218 :
                // InternalPerl.g:1:1457: T__245
                {
                mT__245(); 

                }
                break;
            case 219 :
                // InternalPerl.g:1:1464: T__246
                {
                mT__246(); 

                }
                break;
            case 220 :
                // InternalPerl.g:1:1471: T__247
                {
                mT__247(); 

                }
                break;
            case 221 :
                // InternalPerl.g:1:1478: T__248
                {
                mT__248(); 

                }
                break;
            case 222 :
                // InternalPerl.g:1:1485: T__249
                {
                mT__249(); 

                }
                break;
            case 223 :
                // InternalPerl.g:1:1492: T__250
                {
                mT__250(); 

                }
                break;
            case 224 :
                // InternalPerl.g:1:1499: T__251
                {
                mT__251(); 

                }
                break;
            case 225 :
                // InternalPerl.g:1:1506: T__252
                {
                mT__252(); 

                }
                break;
            case 226 :
                // InternalPerl.g:1:1513: T__253
                {
                mT__253(); 

                }
                break;
            case 227 :
                // InternalPerl.g:1:1520: T__254
                {
                mT__254(); 

                }
                break;
            case 228 :
                // InternalPerl.g:1:1527: T__255
                {
                mT__255(); 

                }
                break;
            case 229 :
                // InternalPerl.g:1:1534: T__256
                {
                mT__256(); 

                }
                break;
            case 230 :
                // InternalPerl.g:1:1541: T__257
                {
                mT__257(); 

                }
                break;
            case 231 :
                // InternalPerl.g:1:1548: T__258
                {
                mT__258(); 

                }
                break;
            case 232 :
                // InternalPerl.g:1:1555: T__259
                {
                mT__259(); 

                }
                break;
            case 233 :
                // InternalPerl.g:1:1562: T__260
                {
                mT__260(); 

                }
                break;
            case 234 :
                // InternalPerl.g:1:1569: T__261
                {
                mT__261(); 

                }
                break;
            case 235 :
                // InternalPerl.g:1:1576: T__262
                {
                mT__262(); 

                }
                break;
            case 236 :
                // InternalPerl.g:1:1583: T__263
                {
                mT__263(); 

                }
                break;
            case 237 :
                // InternalPerl.g:1:1590: T__264
                {
                mT__264(); 

                }
                break;
            case 238 :
                // InternalPerl.g:1:1597: T__265
                {
                mT__265(); 

                }
                break;
            case 239 :
                // InternalPerl.g:1:1604: T__266
                {
                mT__266(); 

                }
                break;
            case 240 :
                // InternalPerl.g:1:1611: T__267
                {
                mT__267(); 

                }
                break;
            case 241 :
                // InternalPerl.g:1:1618: T__268
                {
                mT__268(); 

                }
                break;
            case 242 :
                // InternalPerl.g:1:1625: T__269
                {
                mT__269(); 

                }
                break;
            case 243 :
                // InternalPerl.g:1:1632: T__270
                {
                mT__270(); 

                }
                break;
            case 244 :
                // InternalPerl.g:1:1639: T__271
                {
                mT__271(); 

                }
                break;
            case 245 :
                // InternalPerl.g:1:1646: T__272
                {
                mT__272(); 

                }
                break;
            case 246 :
                // InternalPerl.g:1:1653: T__273
                {
                mT__273(); 

                }
                break;
            case 247 :
                // InternalPerl.g:1:1660: T__274
                {
                mT__274(); 

                }
                break;
            case 248 :
                // InternalPerl.g:1:1667: T__275
                {
                mT__275(); 

                }
                break;
            case 249 :
                // InternalPerl.g:1:1674: T__276
                {
                mT__276(); 

                }
                break;
            case 250 :
                // InternalPerl.g:1:1681: T__277
                {
                mT__277(); 

                }
                break;
            case 251 :
                // InternalPerl.g:1:1688: T__278
                {
                mT__278(); 

                }
                break;
            case 252 :
                // InternalPerl.g:1:1695: T__279
                {
                mT__279(); 

                }
                break;
            case 253 :
                // InternalPerl.g:1:1702: T__280
                {
                mT__280(); 

                }
                break;
            case 254 :
                // InternalPerl.g:1:1709: T__281
                {
                mT__281(); 

                }
                break;
            case 255 :
                // InternalPerl.g:1:1716: T__282
                {
                mT__282(); 

                }
                break;
            case 256 :
                // InternalPerl.g:1:1723: T__283
                {
                mT__283(); 

                }
                break;
            case 257 :
                // InternalPerl.g:1:1730: T__284
                {
                mT__284(); 

                }
                break;
            case 258 :
                // InternalPerl.g:1:1737: T__285
                {
                mT__285(); 

                }
                break;
            case 259 :
                // InternalPerl.g:1:1744: T__286
                {
                mT__286(); 

                }
                break;
            case 260 :
                // InternalPerl.g:1:1751: T__287
                {
                mT__287(); 

                }
                break;
            case 261 :
                // InternalPerl.g:1:1758: T__288
                {
                mT__288(); 

                }
                break;
            case 262 :
                // InternalPerl.g:1:1765: T__289
                {
                mT__289(); 

                }
                break;
            case 263 :
                // InternalPerl.g:1:1772: T__290
                {
                mT__290(); 

                }
                break;
            case 264 :
                // InternalPerl.g:1:1779: T__291
                {
                mT__291(); 

                }
                break;
            case 265 :
                // InternalPerl.g:1:1786: T__292
                {
                mT__292(); 

                }
                break;
            case 266 :
                // InternalPerl.g:1:1793: T__293
                {
                mT__293(); 

                }
                break;
            case 267 :
                // InternalPerl.g:1:1800: T__294
                {
                mT__294(); 

                }
                break;
            case 268 :
                // InternalPerl.g:1:1807: T__295
                {
                mT__295(); 

                }
                break;
            case 269 :
                // InternalPerl.g:1:1814: T__296
                {
                mT__296(); 

                }
                break;
            case 270 :
                // InternalPerl.g:1:1821: T__297
                {
                mT__297(); 

                }
                break;
            case 271 :
                // InternalPerl.g:1:1828: T__298
                {
                mT__298(); 

                }
                break;
            case 272 :
                // InternalPerl.g:1:1835: T__299
                {
                mT__299(); 

                }
                break;
            case 273 :
                // InternalPerl.g:1:1842: T__300
                {
                mT__300(); 

                }
                break;
            case 274 :
                // InternalPerl.g:1:1849: T__301
                {
                mT__301(); 

                }
                break;
            case 275 :
                // InternalPerl.g:1:1856: T__302
                {
                mT__302(); 

                }
                break;
            case 276 :
                // InternalPerl.g:1:1863: T__303
                {
                mT__303(); 

                }
                break;
            case 277 :
                // InternalPerl.g:1:1870: T__304
                {
                mT__304(); 

                }
                break;
            case 278 :
                // InternalPerl.g:1:1877: T__305
                {
                mT__305(); 

                }
                break;
            case 279 :
                // InternalPerl.g:1:1884: T__306
                {
                mT__306(); 

                }
                break;
            case 280 :
                // InternalPerl.g:1:1891: T__307
                {
                mT__307(); 

                }
                break;
            case 281 :
                // InternalPerl.g:1:1898: T__308
                {
                mT__308(); 

                }
                break;
            case 282 :
                // InternalPerl.g:1:1905: T__309
                {
                mT__309(); 

                }
                break;
            case 283 :
                // InternalPerl.g:1:1912: T__310
                {
                mT__310(); 

                }
                break;
            case 284 :
                // InternalPerl.g:1:1919: T__311
                {
                mT__311(); 

                }
                break;
            case 285 :
                // InternalPerl.g:1:1926: T__312
                {
                mT__312(); 

                }
                break;
            case 286 :
                // InternalPerl.g:1:1933: T__313
                {
                mT__313(); 

                }
                break;
            case 287 :
                // InternalPerl.g:1:1940: T__314
                {
                mT__314(); 

                }
                break;
            case 288 :
                // InternalPerl.g:1:1947: T__315
                {
                mT__315(); 

                }
                break;
            case 289 :
                // InternalPerl.g:1:1954: T__316
                {
                mT__316(); 

                }
                break;
            case 290 :
                // InternalPerl.g:1:1961: T__317
                {
                mT__317(); 

                }
                break;
            case 291 :
                // InternalPerl.g:1:1968: T__318
                {
                mT__318(); 

                }
                break;
            case 292 :
                // InternalPerl.g:1:1975: T__319
                {
                mT__319(); 

                }
                break;
            case 293 :
                // InternalPerl.g:1:1982: T__320
                {
                mT__320(); 

                }
                break;
            case 294 :
                // InternalPerl.g:1:1989: T__321
                {
                mT__321(); 

                }
                break;
            case 295 :
                // InternalPerl.g:1:1996: T__322
                {
                mT__322(); 

                }
                break;
            case 296 :
                // InternalPerl.g:1:2003: T__323
                {
                mT__323(); 

                }
                break;
            case 297 :
                // InternalPerl.g:1:2010: T__324
                {
                mT__324(); 

                }
                break;
            case 298 :
                // InternalPerl.g:1:2017: T__325
                {
                mT__325(); 

                }
                break;
            case 299 :
                // InternalPerl.g:1:2024: T__326
                {
                mT__326(); 

                }
                break;
            case 300 :
                // InternalPerl.g:1:2031: T__327
                {
                mT__327(); 

                }
                break;
            case 301 :
                // InternalPerl.g:1:2038: T__328
                {
                mT__328(); 

                }
                break;
            case 302 :
                // InternalPerl.g:1:2045: T__329
                {
                mT__329(); 

                }
                break;
            case 303 :
                // InternalPerl.g:1:2052: T__330
                {
                mT__330(); 

                }
                break;
            case 304 :
                // InternalPerl.g:1:2059: T__331
                {
                mT__331(); 

                }
                break;
            case 305 :
                // InternalPerl.g:1:2066: T__332
                {
                mT__332(); 

                }
                break;
            case 306 :
                // InternalPerl.g:1:2073: T__333
                {
                mT__333(); 

                }
                break;
            case 307 :
                // InternalPerl.g:1:2080: T__334
                {
                mT__334(); 

                }
                break;
            case 308 :
                // InternalPerl.g:1:2087: T__335
                {
                mT__335(); 

                }
                break;
            case 309 :
                // InternalPerl.g:1:2094: T__336
                {
                mT__336(); 

                }
                break;
            case 310 :
                // InternalPerl.g:1:2101: T__337
                {
                mT__337(); 

                }
                break;
            case 311 :
                // InternalPerl.g:1:2108: T__338
                {
                mT__338(); 

                }
                break;
            case 312 :
                // InternalPerl.g:1:2115: T__339
                {
                mT__339(); 

                }
                break;
            case 313 :
                // InternalPerl.g:1:2122: T__340
                {
                mT__340(); 

                }
                break;
            case 314 :
                // InternalPerl.g:1:2129: T__341
                {
                mT__341(); 

                }
                break;
            case 315 :
                // InternalPerl.g:1:2136: T__342
                {
                mT__342(); 

                }
                break;
            case 316 :
                // InternalPerl.g:1:2143: T__343
                {
                mT__343(); 

                }
                break;
            case 317 :
                // InternalPerl.g:1:2150: T__344
                {
                mT__344(); 

                }
                break;
            case 318 :
                // InternalPerl.g:1:2157: T__345
                {
                mT__345(); 

                }
                break;
            case 319 :
                // InternalPerl.g:1:2164: T__346
                {
                mT__346(); 

                }
                break;
            case 320 :
                // InternalPerl.g:1:2171: T__347
                {
                mT__347(); 

                }
                break;
            case 321 :
                // InternalPerl.g:1:2178: T__348
                {
                mT__348(); 

                }
                break;
            case 322 :
                // InternalPerl.g:1:2185: RULE_NUMBER
                {
                mRULE_NUMBER(); 

                }
                break;
            case 323 :
                // InternalPerl.g:1:2197: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 324 :
                // InternalPerl.g:1:2205: RULE_SYMBOL
                {
                mRULE_SYMBOL(); 

                }
                break;
            case 325 :
                // InternalPerl.g:1:2217: RULE_VERSION
                {
                mRULE_VERSION(); 

                }
                break;
            case 326 :
                // InternalPerl.g:1:2230: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 327 :
                // InternalPerl.g:1:2242: RULE_BACKTICK_STRING
                {
                mRULE_BACKTICK_STRING(); 

                }
                break;
            case 328 :
                // InternalPerl.g:1:2263: RULE_INTERPOLATE
                {
                mRULE_INTERPOLATE(); 

                }
                break;
            case 329 :
                // InternalPerl.g:1:2280: RULE_LITERAL
                {
                mRULE_LITERAL(); 

                }
                break;
            case 330 :
                // InternalPerl.g:1:2293: RULE_WORDS_QUOTE_LIKE
                {
                mRULE_WORDS_QUOTE_LIKE(); 

                }
                break;
            case 331 :
                // InternalPerl.g:1:2315: RULE_COMMAND_QUOTE_LIKE
                {
                mRULE_COMMAND_QUOTE_LIKE(); 

                }
                break;
            case 332 :
                // InternalPerl.g:1:2339: RULE_REGEX_QUOTE
                {
                mRULE_REGEX_QUOTE(); 

                }
                break;
            case 333 :
                // InternalPerl.g:1:2356: RULE_REGEX_SUBSTITUTE
                {
                mRULE_REGEX_SUBSTITUTE(); 

                }
                break;
            case 334 :
                // InternalPerl.g:1:2378: RULE_REGEX_TRANSLITERATE
                {
                mRULE_REGEX_TRANSLITERATE(); 

                }
                break;
            case 335 :
                // InternalPerl.g:1:2403: RULE_REGEX_MATCH
                {
                mRULE_REGEX_MATCH(); 

                }
                break;
            case 336 :
                // InternalPerl.g:1:2420: RULE_READLINE_QUOTE
                {
                mRULE_READLINE_QUOTE(); 

                }
                break;
            case 337 :
                // InternalPerl.g:1:2440: RULE_POD
                {
                mRULE_POD(); 

                }
                break;
            case 338 :
                // InternalPerl.g:1:2449: RULE_DATA
                {
                mRULE_DATA(); 

                }
                break;
            case 339 :
                // InternalPerl.g:1:2459: RULE_END
                {
                mRULE_END(); 

                }
                break;
            case 340 :
                // InternalPerl.g:1:2468: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 341 :
                // InternalPerl.g:1:2484: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA56 dfa56 = new DFA56(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA77 dfa77 = new DFA77(this);
    static final String DFA56_eotS =
        "\5\uffff";
    static final String DFA56_eofS =
        "\5\uffff";
    static final String DFA56_minS =
        "\2\0\2\uffff\1\0";
    static final String DFA56_maxS =
        "\2\uffff\2\uffff\1\uffff";
    static final String DFA56_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA56_specialS =
        "\1\1\1\2\2\uffff\1\0}>";
    static final String[] DFA56_transitionS = {
            "\174\2\1\1\uff83\2",
            "\174\4\1\3\uff83\4",
            "",
            "",
            "\174\4\1\3\uff83\4"
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "()* loopback of 4862:34: ( options {greedy=false; } : . )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA56_4 = input.LA(1);

                        s = -1;
                        if ( (LA56_4=='|') ) {s = 3;}

                        else if ( ((LA56_4>='\u0000' && LA56_4<='{')||(LA56_4>='}' && LA56_4<='\uFFFF')) ) {s = 4;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA56_0 = input.LA(1);

                        s = -1;
                        if ( (LA56_0=='|') ) {s = 1;}

                        else if ( ((LA56_0>='\u0000' && LA56_0<='{')||(LA56_0>='}' && LA56_0<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA56_1 = input.LA(1);

                        s = -1;
                        if ( (LA56_1=='|') ) {s = 3;}

                        else if ( ((LA56_1>='\u0000' && LA56_1<='{')||(LA56_1>='}' && LA56_1<='\uFFFF')) ) {s = 4;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 56, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA58_eotS =
        "\5\uffff";
    static final String DFA58_eofS =
        "\5\uffff";
    static final String DFA58_minS =
        "\2\0\2\uffff\1\0";
    static final String DFA58_maxS =
        "\2\uffff\2\uffff\1\uffff";
    static final String DFA58_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA58_specialS =
        "\1\2\1\0\2\uffff\1\1}>";
    static final String[] DFA58_transitionS = {
            "\57\2\1\1\uffd0\2",
            "\57\4\1\3\uffd0\4",
            "",
            "",
            "\57\4\1\3\uffd0\4"
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "()* loopback of 4862:110: ( options {greedy=false; } : . )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_1 = input.LA(1);

                        s = -1;
                        if ( (LA58_1=='/') ) {s = 3;}

                        else if ( ((LA58_1>='\u0000' && LA58_1<='.')||(LA58_1>='0' && LA58_1<='\uFFFF')) ) {s = 4;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_4 = input.LA(1);

                        s = -1;
                        if ( (LA58_4=='/') ) {s = 3;}

                        else if ( ((LA58_4>='\u0000' && LA58_4<='.')||(LA58_4>='0' && LA58_4<='\uFFFF')) ) {s = 4;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_0 = input.LA(1);

                        s = -1;
                        if ( (LA58_0=='/') ) {s = 1;}

                        else if ( ((LA58_0>='\u0000' && LA58_0<='.')||(LA58_0>='0' && LA58_0<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 58, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA61_eotS =
        "\5\uffff";
    static final String DFA61_eofS =
        "\5\uffff";
    static final String DFA61_minS =
        "\2\0\2\uffff\1\0";
    static final String DFA61_maxS =
        "\2\uffff\2\uffff\1\uffff";
    static final String DFA61_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA61_specialS =
        "\1\0\1\2\2\uffff\1\1}>";
    static final String[] DFA61_transitionS = {
            "\174\2\1\1\uff83\2",
            "\174\4\1\3\uff83\4",
            "",
            "",
            "\174\4\1\3\uff83\4"
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "()* loopback of 4864:38: ( options {greedy=false; } : . )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_0 = input.LA(1);

                        s = -1;
                        if ( (LA61_0=='|') ) {s = 1;}

                        else if ( ((LA61_0>='\u0000' && LA61_0<='{')||(LA61_0>='}' && LA61_0<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_4 = input.LA(1);

                        s = -1;
                        if ( (LA61_4=='|') ) {s = 3;}

                        else if ( ((LA61_4>='\u0000' && LA61_4<='{')||(LA61_4>='}' && LA61_4<='\uFFFF')) ) {s = 4;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_1 = input.LA(1);

                        s = -1;
                        if ( (LA61_1=='|') ) {s = 3;}

                        else if ( ((LA61_1>='\u0000' && LA61_1<='{')||(LA61_1>='}' && LA61_1<='\uFFFF')) ) {s = 4;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA63_eotS =
        "\5\uffff";
    static final String DFA63_eofS =
        "\5\uffff";
    static final String DFA63_minS =
        "\2\0\2\uffff\1\0";
    static final String DFA63_maxS =
        "\2\uffff\2\uffff\1\uffff";
    static final String DFA63_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA63_specialS =
        "\1\1\1\0\2\uffff\1\2}>";
    static final String[] DFA63_transitionS = {
            "\57\2\1\1\uffd0\2",
            "\57\4\1\3\uffd0\4",
            "",
            "",
            "\57\4\1\3\uffd0\4"
    };

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "()* loopback of 4864:114: ( options {greedy=false; } : . )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_1 = input.LA(1);

                        s = -1;
                        if ( (LA63_1=='/') ) {s = 3;}

                        else if ( ((LA63_1>='\u0000' && LA63_1<='.')||(LA63_1>='0' && LA63_1<='\uFFFF')) ) {s = 4;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA63_0 = input.LA(1);

                        s = -1;
                        if ( (LA63_0=='/') ) {s = 1;}

                        else if ( ((LA63_0>='\u0000' && LA63_0<='.')||(LA63_0>='0' && LA63_0<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA63_4 = input.LA(1);

                        s = -1;
                        if ( (LA63_4=='/') ) {s = 3;}

                        else if ( ((LA63_4>='\u0000' && LA63_4<='.')||(LA63_4>='0' && LA63_4<='\uFFFF')) ) {s = 4;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 63, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA77_eotS =
        "\2\uffff\1\72\1\75\1\76\1\101\27\67\1\u00ab\1\u00ae\1\u00cd\1\u00d0\1\u00d3\1\u00d5\1\uffff\1\u00dc\1\u00df\1\u00e4\1\u00e7\1\u00ea\1\uffff\1\u00ed\1\u00ef\6\uffff\2\u00f0\1\67\12\uffff\1\u00f5\2\uffff\21\67\1\u010c\7\67\1\u0116\1\u0118\3\67\1\u011d\5\67\1\u0123\1\67\1\u0125\6\67\1\u012e\1\u0130\3\67\1\u0136\3\67\1\u013a\1\uffff\1\u013c\1\u013e\2\67\1\u0142\13\67\1\uffff\21\67\1\uffff\2\67\1\u0179\1\u017b\6\67\1\uffff\3\67\43\uffff\1\u018d\13\uffff\1\u018f\3\uffff\1\67\1\uffff\1\u0192\1\u0194\3\uffff\1\u0196\2\uffff\1\u0198\2\uffff\1\u019a\5\uffff\1\u00f0\1\uffff\1\67\2\uffff\1\u019e\3\67\1\u01a2\7\67\1\u01ae\2\67\1\u01b2\1\67\1\u01b4\3\67\1\u01ba\1\uffff\4\67\1\u01c4\3\67\1\u01c9\1\uffff\1\67\1\uffff\2\67\1\u01d0\1\67\1\uffff\5\67\1\uffff\1\u01dd\1\uffff\1\67\1\u01df\6\67\1\uffff\1\67\1\uffff\3\67\1\u01eb\1\67\1\uffff\1\u01ed\2\67\1\uffff\1\67\1\uffff\1\u01f4\1\uffff\1\u01f5\1\67\1\u01f7\1\uffff\1\u01f8\2\67\1\u01fb\1\u01fc\4\67\4\uffff\4\67\1\u0205\10\67\1\u020e\11\67\1\u0221\11\67\1\u022c\3\67\1\u0236\2\67\2\uffff\1\67\1\uffff\6\67\1\u0241\2\67\1\u0244\6\67\4\uffff\1\u024b\12\uffff\1\u00f0\2\67\1\uffff\3\67\1\uffff\1\u0252\7\67\1\u025a\2\67\1\uffff\3\67\1\uffff\1\67\1\uffff\5\67\1\uffff\1\u0266\1\u0267\1\u0268\6\67\1\uffff\1\u0271\1\u0272\1\67\1\u0274\1\uffff\4\67\1\u0279\1\67\1\uffff\1\u027c\7\67\1\u0289\1\67\1\u028b\1\u028c\1\uffff\1\67\1\uffff\1\67\1\u028f\1\u0290\1\u0291\1\u0292\2\67\1\u0295\2\67\1\u0298\1\uffff\1\67\1\uffff\5\67\1\u029f\2\uffff\1\u02a1\2\uffff\1\u02a3\1\u02a4\2\uffff\2\67\1\u02a7\1\67\1\u02a9\1\u02ad\1\u02ae\1\u02af\1\uffff\10\67\1\uffff\1\67\1\u02ba\4\67\1\u02bf\13\67\1\uffff\2\67\1\u02d0\2\67\1\u02d4\1\67\1\u02d7\2\67\1\uffff\7\67\1\u02e2\1\u02e3\1\uffff\1\u02e5\11\67\1\uffff\2\67\1\uffff\1\u02f3\1\67\1\u02f5\1\u02f6\2\67\1\uffff\1\u00f0\3\67\1\u02fc\2\uffff\1\67\1\u02fe\1\u02ff\1\67\1\u0301\1\u0302\1\u0303\1\uffff\1\u0304\1\67\1\u0307\2\67\1\u030a\5\67\3\uffff\1\u0310\7\67\2\uffff\1\67\1\uffff\1\u0319\1\67\1\u031b\1\67\1\uffff\2\67\1\uffff\13\67\1\u032f\1\uffff\1\67\2\uffff\1\u0331\1\u0332\4\uffff\2\67\1\uffff\1\67\1\u0337\1\uffff\1\u0338\1\u0339\4\67\1\uffff\1\67\1\uffff\1\67\2\uffff\1\u0341\1\67\1\uffff\1\67\1\uffff\3\67\3\uffff\2\67\1\u0349\4\67\1\u034e\2\67\1\uffff\3\67\1\u0354\1\uffff\10\67\1\u035e\5\67\1\u0364\1\67\1\uffff\1\67\1\u0367\1\67\1\uffff\1\u0369\1\u036a\1\uffff\1\u036b\11\67\2\uffff\1\u0375\1\uffff\2\67\1\u0378\1\u0379\4\67\1\u037e\1\u037f\1\u0380\2\67\1\uffff\1\67\2\uffff\1\u0384\1\u0385\2\67\1\u0388\1\uffff\1\67\2\uffff\1\u038a\4\uffff\1\u038b\1\67\1\uffff\2\67\1\uffff\4\67\1\u0393\1\uffff\7\67\1\u039b\1\uffff\1\u039c\1\uffff\1\67\1\u039e\21\67\1\uffff\1\u03b1\2\uffff\1\67\1\u03b3\1\u03b4\1\67\3\uffff\1\u03b6\1\u03b7\1\u03b8\1\u03b9\2\67\1\u03bc\1\uffff\5\67\1\u03c2\1\67\1\uffff\1\u03c4\2\67\1\u03c7\1\uffff\1\u03c8\1\67\1\u03ca\1\u03cb\1\u03cc\1\uffff\11\67\1\uffff\1\u03d6\1\u03d7\3\67\1\uffff\1\u03dc\1\u03dd\1\uffff\1\67\3\uffff\1\u03df\5\67\1\u03e5\2\67\1\uffff\2\67\2\uffff\1\u03ea\1\u03eb\1\u03ec\1\67\3\uffff\1\u03ee\2\67\2\uffff\2\67\1\uffff\1\u03f3\2\uffff\1\67\1\u03f5\2\67\1\u03f8\1\u03f9\1\u03fa\1\uffff\7\67\2\uffff\1\u0402\1\uffff\11\67\1\u040d\1\u040e\7\67\1\uffff\1\u0418\2\uffff\1\67\4\uffff\1\u041a\1\u041b\1\uffff\2\67\1\u041e\2\67\1\uffff\1\u0422\1\uffff\1\u0423\1\67\2\uffff\1\u0425\3\uffff\3\67\1\u0429\5\67\2\uffff\1\u042f\3\67\2\uffff\1\u0433\1\uffff\1\u0434\1\u0435\1\u0436\1\u0437\1\u0438\1\uffff\1\67\1\u043a\1\67\1\u043c\3\uffff\1\u043d\1\uffff\1\u043e\3\67\1\uffff\1\u0445\1\uffff\1\u0446\1\u0447\3\uffff\1\u0448\3\67\1\u044c\2\67\1\uffff\1\u044f\1\u0450\1\u0451\1\u0452\2\67\1\u0455\3\67\2\uffff\2\67\1\u045d\1\u045e\1\u045f\4\67\1\uffff\1\67\2\uffff\2\67\1\uffff\1\u0467\1\u0468\1\u0469\2\uffff\1\67\1\uffff\1\u046b\2\67\1\uffff\2\67\1\u0470\2\67\1\uffff\1\u0473\1\u0474\1\67\6\uffff\1\u0476\1\uffff\1\u0477\3\uffff\2\67\2\u0444\1\67\5\uffff\1\67\1\u0480\1\67\1\uffff\1\67\1\u0483\4\uffff\2\67\1\uffff\2\67\1\u0489\4\67\3\uffff\4\67\1\u0493\1\u0494\1\u0495\3\uffff\1\u0496\1\uffff\1\67\1\u0498\2\67\1\uffff\2\67\2\uffff\1\67\2\uffff\1\u049e\2\u047c\1\67\1\uffff\1\u0444\1\67\1\u04a1\1\uffff\1\67\1\u04a3\1\uffff\2\67\1\u04a6\2\67\1\uffff\6\67\1\u04af\1\67\1\u04b1\4\uffff\1\u04b2\1\uffff\2\67\1\u04b5\1\u04b6\1\u04b7\1\uffff\1\u047c\1\67\1\uffff\1\u04b8\1\uffff\2\67\1\uffff\2\67\1\u04bd\1\u04be\1\67\1\u04c1\2\67\1\uffff\1\u04c4\2\uffff\1\u04c5\1\u04c6\4\uffff\2\67\1\u04c9\1\u04ca\2\uffff\2\67\1\uffff\2\67\3\uffff\1\u04cf\1\u04d0\2\uffff\2\67\1\u04d3\1\u04d4\2\uffff\1\u04d5\1\67\3\uffff\1\67\1\u04d8\1\uffff";
    static final String DFA77_eofS =
        "\u04d9\uffff";
    static final String DFA77_minS =
        "\1\11\1\uffff\1\101\1\75\1\101\1\46\1\142\1\151\1\141\1\142\1\141\1\143\2\145\1\146\1\157\1\145\1\141\1\57\1\145\1\143\1\141\1\11\1\141\1\57\1\145\1\143\1\60\1\141\1\47\1\53\1\55\1\52\1\75\1\176\1\75\1\57\1\47\1\44\1\75\1\56\1\uffff\2\75\6\uffff\2\56\1\137\12\uffff\1\75\2\uffff\1\163\1\143\2\141\1\144\1\156\2\145\1\154\1\144\1\157\1\156\1\171\1\160\1\155\1\146\1\145\1\47\1\155\1\143\1\163\1\144\1\146\1\141\1\145\2\47\1\154\1\157\1\162\1\47\1\166\1\157\2\164\1\145\1\47\1\170\1\47\1\144\1\143\1\151\1\171\1\154\1\163\2\47\1\156\1\143\1\164\1\47\1\160\1\144\1\147\1\47\1\uffff\2\47\1\164\1\145\1\47\1\162\1\143\2\160\1\151\1\163\1\157\4\11\1\uffff\1\156\1\141\1\156\1\144\1\171\1\141\1\145\1\151\1\156\1\145\1\143\1\154\1\162\2\141\1\142\1\155\1\uffff\1\154\1\145\2\47\1\141\1\144\1\145\1\151\1\154\1\143\1\uffff\1\151\1\145\1\151\43\uffff\1\75\13\uffff\1\75\3\uffff\1\162\1\uffff\1\75\1\76\3\uffff\1\75\2\uffff\1\56\2\uffff\1\75\5\uffff\1\56\1\60\1\104\2\uffff\1\47\1\145\1\162\1\156\1\47\1\144\1\163\1\141\1\154\1\151\1\157\1\155\1\47\1\163\1\156\1\47\1\160\1\47\1\143\1\141\1\145\1\47\1\uffff\1\160\1\150\1\145\1\147\1\47\1\154\1\143\1\163\1\47\1\uffff\1\164\1\uffff\1\145\1\143\1\47\1\143\1\uffff\1\145\1\142\1\151\1\157\1\160\1\uffff\1\47\1\uffff\1\145\1\47\1\164\1\156\1\163\1\154\1\164\1\151\1\uffff\1\147\1\uffff\1\153\1\164\1\141\1\47\1\141\1\uffff\1\47\1\151\1\143\1\uffff\1\164\1\uffff\1\47\1\uffff\1\47\1\156\1\47\1\uffff\1\47\1\153\1\145\2\47\1\156\1\164\1\150\1\164\4\uffff\2\144\1\166\1\157\1\47\1\141\1\165\1\145\1\165\1\145\1\151\1\144\1\151\1\47\1\154\1\153\1\145\1\143\1\144\1\147\1\146\1\143\1\164\1\47\1\145\1\153\1\164\2\151\1\164\1\156\1\164\1\144\1\47\1\154\1\143\1\154\1\47\1\145\1\156\2\uffff\1\151\1\uffff\1\163\2\145\1\141\1\150\1\151\1\47\1\155\1\165\1\47\2\164\2\156\1\154\1\164\4\uffff\1\47\12\uffff\1\56\1\101\1\116\1\uffff\1\160\1\155\1\62\1\uffff\1\47\1\157\1\163\1\153\1\145\1\162\1\144\1\160\1\47\1\156\1\157\1\uffff\2\145\1\151\1\uffff\1\164\1\uffff\1\154\1\160\1\165\1\156\1\164\1\uffff\3\47\1\146\1\162\1\157\1\145\1\162\1\145\1\uffff\2\47\1\164\1\47\1\uffff\1\154\1\156\1\153\1\141\1\47\1\141\1\uffff\1\47\1\162\2\157\3\145\1\156\1\47\1\155\2\47\1\uffff\1\170\1\uffff\1\154\4\47\1\162\1\164\1\47\1\145\1\154\1\47\1\uffff\1\164\1\uffff\1\162\1\164\1\145\1\143\1\156\1\47\2\uffff\1\47\2\uffff\2\47\2\uffff\1\164\1\157\1\47\1\145\4\47\1\uffff\1\155\1\151\1\164\2\162\1\156\1\145\1\162\1\uffff\1\141\1\47\1\143\1\164\1\145\1\160\1\47\1\162\1\157\1\145\1\147\1\145\2\164\2\145\1\162\1\144\1\uffff\1\160\1\145\1\47\1\143\1\156\1\47\1\144\1\47\1\171\1\164\1\uffff\1\151\1\141\1\160\3\145\1\162\2\47\1\uffff\1\47\1\143\1\162\1\153\1\146\1\163\1\156\1\143\1\151\1\145\1\uffff\2\145\1\uffff\1\47\1\141\2\47\2\145\1\uffff\1\56\1\124\1\104\1\164\1\47\2\uffff\1\144\2\47\1\162\3\47\1\uffff\1\47\1\164\1\47\1\143\1\156\1\47\1\157\1\145\1\154\2\145\3\uffff\1\47\1\145\1\163\1\164\1\157\1\145\1\162\1\171\2\uffff\1\163\1\uffff\1\47\1\157\1\47\1\143\1\uffff\1\164\1\151\1\uffff\1\145\1\163\1\147\1\164\1\145\1\162\2\151\1\145\1\162\1\143\1\47\1\uffff\1\145\2\uffff\2\47\4\uffff\1\163\1\150\1\uffff\1\156\1\47\1\uffff\2\47\1\154\1\164\1\166\1\144\1\uffff\1\151\1\uffff\1\147\2\uffff\1\47\1\164\1\uffff\1\155\1\uffff\3\151\3\uffff\1\145\1\162\1\47\1\156\1\163\1\144\1\170\1\47\1\162\1\151\1\uffff\1\164\1\154\1\164\1\47\1\uffff\1\145\1\163\1\164\1\162\1\151\1\145\1\162\1\143\1\47\1\154\1\164\1\141\1\151\1\157\1\47\1\164\1\uffff\1\145\1\47\1\164\1\uffff\2\47\1\uffff\1\47\1\162\1\156\1\154\1\145\1\141\1\145\1\155\2\151\2\uffff\1\47\1\uffff\1\141\1\163\2\47\1\163\2\153\1\146\3\47\1\163\1\151\1\uffff\1\162\2\uffff\2\47\1\101\1\137\1\47\1\uffff\1\145\2\uffff\1\47\4\uffff\1\47\1\151\1\uffff\1\164\1\165\1\uffff\1\163\1\156\1\164\1\144\1\47\1\uffff\1\156\1\164\1\145\1\164\1\156\1\166\1\164\1\47\1\uffff\1\47\1\uffff\1\150\1\47\2\156\1\151\1\141\1\164\1\151\1\142\1\162\1\160\1\144\1\157\1\164\1\156\1\141\1\151\1\166\1\153\1\uffff\1\47\2\uffff\1\164\2\47\1\151\3\uffff\4\47\1\162\1\145\1\47\1\uffff\1\171\1\145\1\162\1\156\1\160\1\47\1\145\1\uffff\1\47\1\145\1\144\1\47\1\uffff\1\47\1\162\3\47\1\uffff\1\156\1\164\1\145\1\160\1\157\1\164\1\156\1\166\1\153\1\uffff\2\47\1\144\1\164\1\167\1\uffff\2\47\1\uffff\1\146\3\uffff\1\47\1\153\1\154\1\156\1\144\1\153\1\47\1\164\1\162\1\uffff\2\164\2\uffff\3\47\1\164\3\uffff\1\47\1\144\1\162\2\uffff\2\137\1\uffff\1\47\2\uffff\1\162\1\47\2\145\3\47\1\uffff\1\164\1\145\1\156\1\157\1\164\2\145\2\uffff\1\47\1\uffff\1\145\1\164\1\144\1\155\1\142\1\156\1\171\2\156\2\47\1\162\1\157\1\164\1\155\1\144\1\142\1\156\1\uffff\1\47\2\uffff\1\155\4\uffff\2\47\1\uffff\1\160\1\164\1\47\2\145\1\uffff\1\47\1\uffff\1\47\1\151\2\uffff\1\47\3\uffff\1\164\1\145\1\156\1\47\1\162\1\157\1\164\1\145\1\157\2\uffff\1\47\1\145\1\156\1\141\2\uffff\1\47\1\uffff\5\47\1\uffff\1\145\1\47\1\145\1\47\3\uffff\1\47\1\uffff\1\47\1\141\1\137\1\0\1\uffff\1\47\1\uffff\2\47\3\uffff\1\47\1\156\1\164\1\145\1\47\1\156\1\163\1\uffff\4\47\1\171\1\156\1\47\1\141\1\164\1\141\2\uffff\1\151\1\142\3\47\1\171\1\156\1\141\1\160\1\uffff\1\145\2\uffff\1\145\1\141\1\uffff\3\47\2\uffff\1\162\1\uffff\1\47\1\156\1\164\1\uffff\1\151\1\145\1\47\1\156\1\160\1\uffff\2\47\1\151\6\uffff\1\47\1\uffff\1\47\3\uffff\1\171\1\0\1\72\1\101\1\0\5\uffff\1\164\1\47\1\156\1\uffff\1\164\1\47\4\uffff\1\141\1\164\1\uffff\1\144\1\141\1\47\1\155\1\164\1\171\1\156\3\uffff\1\156\1\164\1\155\1\164\3\47\3\uffff\1\47\1\uffff\1\164\1\47\1\164\1\156\1\uffff\2\164\2\uffff\1\162\2\uffff\1\47\1\72\1\101\1\0\1\uffff\1\101\1\0\1\47\1\uffff\1\164\1\47\1\uffff\1\144\1\141\1\47\1\144\1\155\1\uffff\1\145\1\171\1\156\1\164\1\141\1\157\1\47\1\145\1\47\4\uffff\1\47\1\uffff\1\171\1\164\3\47\1\uffff\1\101\1\0\1\uffff\1\47\1\uffff\1\144\1\155\1\uffff\1\162\1\145\2\47\1\141\1\47\1\155\1\162\1\uffff\1\47\2\uffff\2\47\4\uffff\1\162\1\145\2\47\2\uffff\2\155\1\uffff\1\145\1\164\3\uffff\2\47\2\uffff\1\145\1\142\2\47\2\uffff\1\47\1\145\3\uffff\1\162\1\47\1\uffff";
    static final String DFA77_maxS =
        "\1\176\1\uffff\3\172\1\75\1\164\2\162\1\165\1\170\1\157\1\164\1\145\2\157\1\151\1\164\1\174\1\157\2\165\1\174\1\155\1\174\1\162\1\164\1\145\1\162\1\172\1\75\1\172\1\75\3\176\1\75\2\172\1\76\1\75\1\uffff\1\174\1\75\6\uffff\2\71\1\137\12\uffff\1\75\2\uffff\1\163\1\143\2\141\1\144\1\156\2\145\1\154\1\162\1\157\1\163\1\171\1\160\1\155\1\154\1\145\1\172\1\155\1\143\1\163\1\144\1\146\1\141\1\160\2\172\1\154\1\157\1\162\1\172\1\166\1\157\2\164\1\145\1\172\1\170\1\172\1\164\1\143\1\151\1\171\1\154\1\163\2\172\1\163\1\147\1\164\1\172\1\160\1\144\1\147\1\172\1\uffff\2\172\1\164\1\145\1\172\1\162\1\143\1\160\1\163\1\157\1\163\1\157\4\174\1\uffff\1\156\1\167\1\156\1\144\1\171\1\141\1\164\1\165\1\156\1\145\3\162\1\141\1\165\1\142\1\163\1\uffff\1\154\1\155\1\174\1\172\1\141\1\164\1\145\1\151\1\154\1\143\1\uffff\1\162\2\151\43\uffff\1\75\13\uffff\1\75\3\uffff\1\162\1\uffff\1\75\1\76\3\uffff\1\75\2\uffff\1\56\2\uffff\1\75\5\uffff\2\71\1\105\2\uffff\1\172\1\145\1\162\1\156\1\172\1\155\1\163\1\141\1\154\1\151\1\157\1\167\1\172\1\163\1\164\1\172\1\160\1\172\1\157\1\151\1\145\1\172\1\uffff\1\160\1\150\1\151\1\163\1\172\1\154\1\143\1\164\1\172\1\uffff\1\164\1\uffff\1\145\1\143\1\172\1\163\1\uffff\1\145\1\142\1\151\1\157\1\160\1\uffff\1\172\1\uffff\1\145\1\172\1\164\1\156\1\163\1\154\1\164\1\151\1\uffff\1\147\1\uffff\1\153\1\164\1\153\1\172\1\141\1\uffff\1\172\1\151\1\163\1\uffff\1\164\1\uffff\1\172\1\uffff\1\172\1\156\1\172\1\uffff\1\172\1\153\1\145\2\172\1\156\1\164\1\150\1\164\4\uffff\2\144\1\166\1\157\1\172\1\141\1\165\1\145\1\165\1\145\1\151\1\144\1\151\1\172\1\154\1\153\1\145\1\157\1\144\1\163\1\146\1\167\1\164\1\172\1\145\1\153\1\164\2\151\1\164\1\156\1\164\1\144\1\172\1\154\1\167\1\154\1\172\1\145\1\156\2\uffff\1\151\1\uffff\1\163\1\145\1\151\1\141\1\150\1\151\1\172\1\155\1\165\1\172\2\164\2\156\1\154\1\164\4\uffff\1\172\12\uffff\1\71\1\101\1\116\1\uffff\1\160\1\155\1\62\1\uffff\1\172\1\157\1\163\1\153\1\145\1\162\1\144\1\160\1\172\1\156\1\157\1\uffff\2\145\1\151\1\uffff\1\164\1\uffff\1\154\1\160\1\165\1\156\1\164\1\uffff\3\172\1\146\1\162\1\157\1\145\1\167\1\145\1\uffff\2\172\1\164\1\172\1\uffff\1\154\1\156\1\153\1\141\1\172\1\154\1\uffff\1\172\1\162\2\157\1\145\1\167\1\157\1\156\1\172\1\155\2\172\1\uffff\1\170\1\uffff\1\154\4\172\1\162\1\164\1\172\1\145\1\154\1\172\1\uffff\1\164\1\uffff\1\162\1\164\1\145\1\143\1\156\1\172\2\uffff\1\172\2\uffff\2\172\2\uffff\1\164\1\157\1\172\1\145\4\172\1\uffff\1\155\1\151\1\164\2\162\1\156\1\145\1\162\1\uffff\1\141\1\172\1\143\1\164\1\145\1\160\1\172\1\162\1\157\1\145\1\167\1\157\2\164\2\145\1\162\1\144\1\uffff\1\160\1\145\1\172\1\164\1\156\1\172\1\144\1\172\1\171\1\164\1\uffff\1\151\1\141\1\160\3\145\1\162\2\172\1\uffff\1\172\1\143\1\162\1\153\1\146\1\163\1\156\1\143\1\151\1\154\1\uffff\2\145\1\uffff\1\172\1\141\2\172\2\145\1\uffff\1\71\1\124\1\104\1\164\1\172\2\uffff\1\144\2\172\1\162\3\172\1\uffff\1\172\1\164\1\172\1\143\1\156\1\172\1\157\1\145\1\154\2\145\3\uffff\1\172\1\145\1\163\1\164\1\157\1\145\1\162\1\171\2\uffff\1\163\1\uffff\1\172\1\157\1\172\1\143\1\uffff\1\164\1\151\1\uffff\1\156\1\163\1\147\1\164\1\145\1\162\1\151\1\157\1\165\1\162\1\143\1\172\1\uffff\1\145\2\uffff\2\172\4\uffff\1\163\1\150\1\uffff\1\156\1\172\1\uffff\2\172\1\154\1\164\1\166\1\144\1\uffff\1\151\1\uffff\1\147\2\uffff\1\172\1\164\1\uffff\1\155\1\uffff\3\151\3\uffff\1\145\1\162\1\172\1\156\1\163\1\144\1\170\1\172\1\162\1\151\1\uffff\1\164\1\154\1\164\1\172\1\uffff\1\145\1\163\1\164\1\162\1\157\1\145\1\162\1\143\1\172\1\154\1\164\1\141\1\151\1\157\1\172\1\164\1\uffff\1\145\1\172\1\164\1\uffff\2\172\1\uffff\1\172\1\162\1\156\1\154\1\145\1\141\1\145\1\155\2\151\2\uffff\1\172\1\uffff\1\141\1\163\2\172\1\163\2\153\1\146\3\172\1\163\1\151\1\uffff\1\162\2\uffff\2\172\1\101\1\137\1\172\1\uffff\1\145\2\uffff\1\172\4\uffff\1\172\1\151\1\uffff\1\164\1\165\1\uffff\1\163\1\156\1\164\1\144\1\172\1\uffff\1\156\1\164\1\145\1\164\1\156\1\166\1\164\1\172\1\uffff\1\172\1\uffff\1\150\1\172\2\156\1\151\1\141\1\164\1\151\1\145\1\162\1\160\1\144\1\157\1\164\1\156\1\141\1\151\1\166\1\153\1\uffff\1\172\2\uffff\1\164\2\172\1\151\3\uffff\4\172\1\162\1\145\1\172\1\uffff\1\171\1\145\1\162\1\156\1\160\1\172\1\145\1\uffff\1\172\1\145\1\144\1\172\1\uffff\1\172\1\162\3\172\1\uffff\1\156\1\164\1\145\1\160\1\157\1\164\1\156\1\166\1\153\1\uffff\2\172\1\144\1\164\1\167\1\uffff\2\172\1\uffff\1\146\3\uffff\1\172\1\153\1\154\1\156\1\144\1\153\1\172\1\164\1\162\1\uffff\2\164\2\uffff\3\172\1\164\3\uffff\1\172\1\144\1\162\2\uffff\2\137\1\uffff\1\172\2\uffff\1\162\1\172\2\145\3\172\1\uffff\1\164\1\145\1\156\1\157\1\164\2\145\2\uffff\1\172\1\uffff\1\145\1\164\1\144\1\155\1\145\1\156\1\171\2\156\2\172\1\162\1\157\1\164\1\155\1\144\1\145\1\157\1\uffff\1\172\2\uffff\1\155\4\uffff\2\172\1\uffff\1\160\1\164\1\172\1\153\1\145\1\uffff\1\172\1\uffff\1\172\1\151\2\uffff\1\172\3\uffff\1\164\1\145\1\156\1\172\1\162\1\157\1\164\1\145\1\157\2\uffff\1\172\1\145\1\156\1\141\2\uffff\1\172\1\uffff\5\172\1\uffff\1\145\1\172\1\145\1\172\3\uffff\1\172\1\uffff\1\172\1\141\1\137\1\uffff\1\uffff\1\172\1\uffff\2\172\3\uffff\1\172\1\156\1\164\1\145\1\172\1\156\1\163\1\uffff\4\172\1\171\1\156\1\172\1\156\1\164\1\141\2\uffff\1\151\1\145\3\172\1\171\1\156\1\141\1\160\1\uffff\1\145\2\uffff\1\145\1\141\1\uffff\3\172\2\uffff\1\162\1\uffff\1\172\1\156\1\164\1\uffff\1\151\1\145\1\172\1\156\1\160\1\uffff\2\172\1\151\6\uffff\1\172\1\uffff\1\172\3\uffff\1\171\1\uffff\1\72\1\172\1\uffff\5\uffff\1\164\1\172\1\156\1\uffff\1\164\1\172\4\uffff\1\156\1\164\1\uffff\1\144\1\141\1\172\1\155\1\164\1\171\1\156\3\uffff\1\160\1\164\1\155\1\164\3\172\3\uffff\1\172\1\uffff\1\164\1\172\1\164\1\156\1\uffff\2\164\2\uffff\1\162\2\uffff\1\172\1\72\1\172\1\uffff\1\uffff\1\172\1\uffff\1\172\1\uffff\1\164\1\172\1\uffff\1\144\1\141\1\172\1\144\1\155\1\uffff\1\145\1\171\1\156\1\164\1\141\1\157\1\172\1\145\1\172\4\uffff\1\172\1\uffff\1\171\1\164\3\172\1\uffff\1\172\1\uffff\1\uffff\1\172\1\uffff\1\144\1\155\1\uffff\1\162\1\145\2\172\1\165\1\172\1\155\1\162\1\uffff\1\172\2\uffff\2\172\4\uffff\1\162\1\145\2\172\2\uffff\2\155\1\uffff\1\145\1\164\3\uffff\2\172\2\uffff\1\145\1\142\2\172\2\uffff\1\172\1\145\3\uffff\1\162\1\172\1\uffff";
    static final String DFA77_acceptS =
        "\1\uffff\1\1\47\uffff\1\u00fc\2\uffff\1\u0102\1\u0103\1\u013c\1\u013d\1\u013e\1\u013f\3\uffff\1\u0146\1\u0147\1\u0143\1\u0154\1\u0155\1\2\1\u0144\1\u010a\1\3\1\4\1\uffff\1\u010c\1\5\67\uffff\1\u014f\20\uffff\1\u0149\21\uffff\1\u014d\12\uffff\1\u0145\3\uffff\1\u00e3\1\u00e4\1\u0105\1\u00e9\1\u00e5\1\u0106\1\u011a\1\u0121\1\u0122\1\u0123\1\u0124\1\u0125\1\u0126\1\u0127\1\u0128\1\u0129\1\u012a\1\u012b\1\u012c\1\u012d\1\u012e\1\u012f\1\u0130\1\u0131\1\u0132\1\u0133\1\u0134\1\u0135\1\u0136\1\u0137\1\u0138\1\u0139\1\u013a\1\u013b\1\u00ea\1\uffff\1\u0108\1\u00ed\1\u00ec\1\u00f9\1\u00e7\1\u00f7\1\u00e8\1\u00eb\1\u00f8\1\u0119\1\u0151\1\uffff\1\u0109\1\u00ee\1\u010b\1\uffff\1\u00ef\2\uffff\1\u0118\1\u0150\1\u0114\1\uffff\1\u0117\1\u0115\1\uffff\1\u0107\1\u0141\1\uffff\1\u010d\1\u00fd\1\u010e\1\u00fe\1\u0142\3\uffff\1\u0111\1\u00ff\26\uffff\1\42\11\uffff\1\u011f\1\uffff\1\64\4\uffff\1\u00f5\5\uffff\1\u00f3\1\uffff\1\135\10\uffff\1\145\1\uffff\1\u00f4\5\uffff\1\u00f2\3\uffff\1\165\1\uffff\1\u0120\1\uffff\1\167\3\uffff\1\u011c\11\uffff\1\u0148\1\u014a\1\u014b\1\u014c\50\uffff\1\u014e\1\u00cc\1\uffff\1\u00ce\20\uffff\1\u0104\1\u00e6\1\u0113\1\u0101\1\uffff\1\u010f\1\u00f0\1\u0140\1\u0116\1\u0110\1\u00f1\1\u00fb\1\u00fa\1\u0112\1\u0100\3\uffff\1\6\3\uffff\1\u011b\13\uffff\1\24\3\uffff\1\32\1\uffff\1\u00f6\5\uffff\1\41\11\uffff\1\55\4\uffff\1\63\6\uffff\1\70\14\uffff\1\134\1\uffff\1\137\13\uffff\1\155\1\uffff\1\157\6\uffff\1\u011e\1\170\1\uffff\1\173\1\174\2\uffff\1\u0080\1\u0081\10\uffff\1\u008f\10\uffff\1\u0098\22\uffff\1\u00b0\12\uffff\1\u00bd\11\uffff\1\u00c8\12\uffff\1\u00d8\2\uffff\1\u00db\6\uffff\1\u011d\5\uffff\1\11\1\12\7\uffff\1\22\13\uffff\1\43\1\44\1\45\10\uffff\1\56\1\60\1\uffff\1\62\4\uffff\1\72\2\uffff\1\75\14\uffff\1\130\1\uffff\1\132\1\133\2\uffff\1\141\1\142\1\143\1\144\2\uffff\1\150\2\uffff\1\154\6\uffff\1\166\1\uffff\1\171\1\uffff\1\175\1\177\2\uffff\1\u0085\1\uffff\1\u0087\3\uffff\1\u0088\1\u008d\1\u008e\12\uffff\1\u009a\4\uffff\1\u00a0\20\uffff\1\u00b4\3\uffff\1\u00b8\2\uffff\1\u00ba\12\uffff\1\u00c6\1\u00c9\1\uffff\1\u00ca\15\uffff\1\u00dc\1\uffff\1\u00df\1\u00e0\5\uffff\1\10\1\uffff\1\14\1\15\1\uffff\1\17\1\20\1\21\1\23\2\uffff\1\26\2\uffff\1\33\5\uffff\1\46\10\uffff\1\65\1\uffff\1\67\23\uffff\1\127\1\uffff\1\136\1\140\4\uffff\1\152\1\156\1\160\7\uffff\1\u0082\7\uffff\1\u0092\4\uffff\1\u0097\5\uffff\1\u009f\11\uffff\1\u00aa\5\uffff\1\u00b1\2\uffff\1\u00b6\1\uffff\1\u00b9\1\u00bb\1\u00bc\11\uffff\1\u00cb\2\uffff\1\u00d0\1\u00d1\4\uffff\1\u00d6\1\u00d7\1\u00d9\3\uffff\1\u00e1\1\u00e2\2\uffff\1\7\1\uffff\1\16\1\25\7\uffff\1\40\7\uffff\1\61\1\66\1\uffff\1\73\22\uffff\1\131\1\uffff\1\147\1\151\1\uffff\1\161\1\162\1\163\1\164\2\uffff\1\u0083\5\uffff\1\u0090\1\uffff\1\u0093\2\uffff\1\u0096\1\u0099\1\uffff\1\u009c\1\u009d\1\u009e\11\uffff\1\u00ab\1\u00ac\4\uffff\1\u00b2\1\u00b5\1\uffff\1\u00be\5\uffff\1\u00c4\4\uffff\1\u00d2\1\u00d3\1\u00d4\1\uffff\1\u00da\4\uffff\1\13\1\uffff\1\30\2\uffff\1\35\1\36\1\37\7\uffff\1\71\12\uffff\1\111\1\112\11\uffff\1\146\1\uffff\1\172\1\176\2\uffff\1\u0089\3\uffff\1\u0091\1\u0094\1\uffff\1\u009b\3\uffff\1\u00a4\5\uffff\1\u00ad\3\uffff\1\u00b7\1\u00bf\1\u00c0\1\u00c1\1\u00c2\1\u00c3\1\uffff\1\u00c7\1\uffff\1\u00cf\1\u00d5\1\u00dd\5\uffff\1\u0153\1\27\1\31\1\34\1\47\3\uffff\1\53\2\uffff\1\74\1\76\1\77\1\100\2\uffff\1\104\7\uffff\1\117\1\120\1\121\7\uffff\1\u008a\1\u008b\1\u008c\1\uffff\1\u00a1\4\uffff\1\u00a7\2\uffff\1\u00ae\1\u00af\1\uffff\1\u00c5\1\u00cd\4\uffff\1\u0152\3\uffff\1\51\2\uffff\1\57\5\uffff\1\107\11\uffff\1\153\1\u0084\1\u0086\1\u0095\1\uffff\1\u00a3\5\uffff\1\u00de\2\uffff\1\50\1\uffff\1\54\2\uffff\1\103\10\uffff\1\124\1\uffff\1\126\1\u00a2\2\uffff\1\u00a8\1\u00a9\1\u00b3\1\52\4\uffff\1\110\1\113\2\uffff\1\116\2\uffff\1\125\1\u00a5\1\u00a6\2\uffff\1\105\1\106\4\uffff\1\101\1\102\2\uffff\1\122\1\123\1\114\2\uffff\1\115";
    static final String DFA77_specialS =
        "\u03f2\uffff\1\1\115\uffff\1\0\2\uffff\1\5\67\uffff\1\4\2\uffff\1\3\41\uffff\1\2\70\uffff}>";
    static final String[] DFA77_transitionS = {
            "\2\71\2\uffff\1\71\22\uffff\1\71\1\41\1\65\1\70\1\2\1\3\1\5\1\65\1\60\1\61\1\40\1\36\1\51\1\37\1\50\1\44\1\62\11\63\1\55\1\1\1\46\1\43\1\47\1\54\1\4\32\67\3\uffff\1\53\1\64\1\66\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\45\1\35\1\67\1\56\1\52\1\57\1\42",
            "",
            "\32\73\4\uffff\1\73\1\uffff\32\73",
            "\1\74\3\uffff\32\73\4\uffff\1\73\1\uffff\32\73",
            "\32\73\4\uffff\1\73\1\uffff\32\73",
            "\1\77\26\uffff\1\100",
            "\1\102\1\103\10\uffff\1\104\1\uffff\1\106\5\uffff\1\105",
            "\1\107\2\uffff\1\110\5\uffff\1\111",
            "\1\112\6\uffff\1\113\3\uffff\1\114\1\117\1\uffff\1\115\2\uffff\1\116",
            "\1\120\2\uffff\1\121\3\uffff\1\122\5\uffff\1\123\5\uffff\1\124",
            "\1\125\12\uffff\1\126\1\uffff\1\127\1\130\1\uffff\1\133\4\uffff\1\131\1\uffff\1\132",
            "\1\134\5\uffff\1\135\2\uffff\1\136\2\uffff\1\137",
            "\1\140\3\uffff\1\141\2\uffff\1\142\1\143\1\uffff\1\144\2\uffff\1\145\1\uffff\1\146",
            "\1\147",
            "\1\150\7\uffff\1\151\1\152",
            "\1\153",
            "\1\154\3\uffff\1\155",
            "\1\156\1\uffff\1\157\1\uffff\1\160\3\uffff\1\161\5\uffff\1\162\3\uffff\1\163\1\164",
            "\1\171\61\uffff\1\165\11\uffff\1\166\7\uffff\1\167\5\uffff\1\170\2\uffff\1\171",
            "\1\172\11\uffff\1\173",
            "\1\174\14\uffff\1\175\1\uffff\1\176\2\uffff\1\177",
            "\1\u0080\7\uffff\1\u0081\5\uffff\1\u0082\2\uffff\1\u0083\2\uffff\1\u0084",
            "\2\u008a\2\uffff\1\u008a\22\uffff\1\u008a\7\uffff\1\u008a\6\uffff\1\u008a\14\uffff\1\u008a\64\uffff\1\u0086\1\u0089\2\uffff\1\u0085\1\uffff\1\u0087\1\u0088\2\uffff\2\u008a",
            "\1\u008b\3\uffff\1\u008c\3\uffff\1\u008d\3\uffff\1\u008e",
            "\1\u009c\61\uffff\1\u008f\1\uffff\1\u0090\1\uffff\1\u0091\2\uffff\1\u0092\1\u0093\2\uffff\1\u0094\2\uffff\1\u0095\1\u0096\1\u0097\1\u0098\1\uffff\1\u0099\1\u009a\3\uffff\1\u009b\2\uffff\1\u009c",
            "\1\u009d\3\uffff\1\u009e\10\uffff\1\u009f",
            "\1\u00a0\11\uffff\1\u00a1\1\u00a2\4\uffff\1\u00a3\1\u00a4",
            "\12\u00a7\47\uffff\1\u00a5\3\uffff\1\u00a6",
            "\1\u00a8\6\uffff\1\u00a9\11\uffff\1\u00aa",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00ac\21\uffff\1\u00ad",
            "\1\u00af\17\uffff\1\u00b0\1\u00b1\2\uffff\1\u00cb\1\u00c9\1\u00cc\11\uffff\1\u00ca\1\uffff\1\u00b9\2\uffff\1\u00b6\1\u00c1\1\u00c8\2\uffff\1\u00b7\1\u00b8\11\uffff\1\u00c2\1\u00c3\1\u00be\1\u00ba\1\u00bd\1\u00c6\3\uffff\1\u00c7\1\u00bf\2\uffff\1\u00b5\1\u00c0\1\uffff\1\u00b2\1\u00bc\1\u00c4\1\u00c5\1\uffff\1\u00b3\1\u00b4\1\uffff\1\u00bb",
            "\1\u00ce\22\uffff\1\u00cf",
            "\1\u00d2\100\uffff\1\u00d1",
            "\1\u00d4",
            "\1\u00d7\1\u00d8\61\uffff\1\u00d9\15\uffff\1\u00d6",
            "\1\u00da\15\uffff\1\u00db",
            "\1\67\22\uffff\1\67\2\uffff\1\u00dd\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u00de\13\67",
            "\2\u00e3\26\uffff\1\u00e0\1\u00e1\1\u00e2\1\uffff\33\u00e3\4\uffff\1\u00e3\1\uffff\32\u00e3",
            "\1\u00e6\1\u00e5",
            "\1\u00e8\16\uffff\1\u00e9",
            "",
            "\1\u00ec\76\uffff\1\u00eb",
            "\1\u00ee",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00f2\1\uffff\12\u00f1",
            "\1\u00f2\1\uffff\12\u00f1",
            "\1\u00f3",
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
            "\1\u00f4",
            "",
            "",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff\10\uffff\1\u0100\1\uffff\1\u0101\2\uffff\1\u0102",
            "\1\u0103",
            "\1\u0104\4\uffff\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109\5\uffff\1\u010a",
            "\1\u010b",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113\3\uffff\1\u0114\6\uffff\1\u0115",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0117\14\67",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u011c\6\67",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0124",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0126\17\uffff\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67\1\u012d\24\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u012f\14\67",
            "\1\u0131\4\uffff\1\u0132",
            "\1\u0133\3\uffff\1\u0134",
            "\1\u0135",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\27\67\1\u013b\2\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u013d\6\67",
            "\1\u013f",
            "\1\u0140",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u0141\26\67",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146\2\uffff\1\u0147",
            "\1\u0148\5\uffff\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\2\u014c\2\uffff\1\u014c\22\uffff\1\u014c\16\uffff\1\u014c\14\uffff\1\u014c\76\uffff\2\u014c",
            "\2\u014d\2\uffff\1\u014d\22\uffff\1\u014d\7\uffff\1\u014d\6\uffff\1\u014d\14\uffff\1\u014d\76\uffff\2\u014d",
            "\2\u014e\2\uffff\1\u014e\22\uffff\1\u014e\7\uffff\1\u014e\6\uffff\1\u014e\14\uffff\1\u014e\76\uffff\2\u014e",
            "\2\u014f\2\uffff\1\u014f\22\uffff\1\u014f\16\uffff\1\u014f\14\uffff\1\u014f\76\uffff\2\u014f",
            "",
            "\1\u0150",
            "\1\u0151\1\uffff\1\u0152\1\u0153\1\uffff\1\u0154\7\uffff\1\u0155\2\uffff\1\u0156\1\uffff\1\u0157\1\u0158\1\uffff\1\u0159\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f\6\uffff\1\u0160\1\u0161\1\u0162\5\uffff\1\u0163",
            "\1\u0164\3\uffff\1\u0165\7\uffff\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169\16\uffff\1\u016a",
            "\1\u016b\5\uffff\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f\23\uffff\1\u0170",
            "\1\u0171",
            "\1\u0172\5\uffff\1\u0173",
            "",
            "\1\u0174",
            "\1\u0175\7\uffff\1\u0176",
            "\1\67\7\uffff\1\u0178\12\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\24\67\1\u0177\5\67\1\uffff\1\u0178",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67\1\u017a\24\67",
            "\1\u017c",
            "\1\u017d\7\uffff\1\u017e\3\uffff\1\u017f\2\uffff\1\u0180\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "",
            "\1\u0186\4\uffff\1\u0187\3\uffff\1\u0188",
            "\1\u0189\3\uffff\1\u018a",
            "\1\u018b",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u018c",
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
            "\1\u018e",
            "",
            "",
            "",
            "\1\u0190",
            "",
            "\1\u0191",
            "\1\u0193",
            "",
            "",
            "",
            "\1\u0195",
            "",
            "",
            "\1\u0197",
            "",
            "",
            "\1\u0199",
            "",
            "",
            "",
            "",
            "",
            "\1\u00f2\1\uffff\12\u00f1",
            "\12\u019b",
            "\1\u019c\1\u019d",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u019f",
            "\1\u01a0",
            "\1\u01a1",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01a3\10\uffff\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\1\u01a9",
            "\1\u01aa\2\uffff\1\u01ab\6\uffff\1\u01ac",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u01ad\13\67",
            "\1\u01af",
            "\1\u01b0\5\uffff\1\u01b1",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01b3",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01b5\13\uffff\1\u01b6",
            "\1\u01b7\7\uffff\1\u01b8",
            "\1\u01b9",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u01bb",
            "\1\u01bc",
            "\1\u01bd\3\uffff\1\u01be",
            "\1\u01bf\1\u01c0\5\uffff\1\u01c1\1\uffff\1\u01c2\2\uffff\1\u01c3",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7\1\u01c8",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u01ca",
            "",
            "\1\u01cb",
            "\1\u01cc",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01cd\5\67\1\u01ce\1\67\1\u01cf\15\67",
            "\1\u01d1\3\uffff\1\u01d2\1\u01d3\3\uffff\1\u01d4\1\uffff\1\u01d5\1\uffff\1\u01d6\2\uffff\1\u01d7",
            "",
            "\1\u01d8",
            "\1\u01d9",
            "\1\u01da",
            "\1\u01db",
            "\1\u01dc",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u01de",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01e0",
            "\1\u01e1",
            "\1\u01e2",
            "\1\u01e3",
            "\1\u01e4",
            "\1\u01e5",
            "",
            "\1\u01e6",
            "",
            "\1\u01e7",
            "\1\u01e8",
            "\1\u01e9\11\uffff\1\u01ea",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01ec",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01ee",
            "\1\u01ef\3\uffff\1\u01f0\12\uffff\1\u01f1\1\u01f2",
            "",
            "\1\u01f3",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01f6",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01f9",
            "\1\u01fa",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01fd",
            "\1\u01fe",
            "\1\u01ff",
            "\1\u0200",
            "",
            "",
            "",
            "",
            "\1\u0201",
            "\1\u0202",
            "\1\u0203",
            "\1\u0204",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0206",
            "\1\u0207",
            "\1\u0208",
            "\1\u0209",
            "\1\u020a",
            "\1\u020b",
            "\1\u020c",
            "\1\u020d",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u020f",
            "\1\u0210",
            "\1\u0211",
            "\1\u0212\3\uffff\1\u0213\7\uffff\1\u0214",
            "\1\u0215",
            "\1\u0216\1\u0217\5\uffff\1\u0218\1\uffff\1\u0219\2\uffff\1\u021a",
            "\1\u021b",
            "\1\u021c\3\uffff\1\u021d\12\uffff\1\u021e\4\uffff\1\u021f",
            "\1\u0220",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0222",
            "\1\u0223",
            "\1\u0224",
            "\1\u0225",
            "\1\u0226",
            "\1\u0227",
            "\1\u0228",
            "\1\u0229",
            "\1\u022a",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u022b\7\67",
            "\1\u022d",
            "\1\u022e\13\uffff\1\u022f\2\uffff\1\u0230\1\u0231\1\u0232\2\uffff\1\u0233",
            "\1\u0234",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u0235\26\67",
            "\1\u0237",
            "\1\u0238",
            "",
            "",
            "\1\u0239",
            "",
            "\1\u023a",
            "\1\u023b",
            "\1\u023c\3\uffff\1\u023d",
            "\1\u023e",
            "\1\u023f",
            "\1\u0240",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0242",
            "\1\u0243",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0245",
            "\1\u0246",
            "\1\u0247",
            "\1\u0248",
            "\1\u0249",
            "\1\u024a",
            "",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
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
            "\1\u00a7\1\uffff\12\u024c",
            "\1\u024d",
            "\1\u024e",
            "",
            "\1\u024f",
            "\1\u0250",
            "\1\u0251",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0253",
            "\1\u0254",
            "\1\u0255",
            "\1\u0256",
            "\1\u0257",
            "\1\u0258",
            "\1\u0259",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u025b",
            "\1\u025c",
            "",
            "\1\u025d",
            "\1\u025e",
            "\1\u025f",
            "",
            "\1\u0260",
            "",
            "\1\u0261",
            "\1\u0262",
            "\1\u0263",
            "\1\u0264",
            "\1\u0265",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0269",
            "\1\u026a",
            "\1\u026b",
            "\1\u026c",
            "\1\u026d\4\uffff\1\u026e",
            "\1\u026f",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\67\1\u0270\30\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0273",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0275",
            "\1\u0276",
            "\1\u0277",
            "\1\u0278",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u027a\12\uffff\1\u027b",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u027d",
            "\1\u027e",
            "\1\u027f",
            "\1\u0280",
            "\1\u0281\1\uffff\1\u0282\10\uffff\1\u0283\1\uffff\1\u0284\4\uffff\1\u0285",
            "\1\u0286\11\uffff\1\u0287",
            "\1\u0288",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u028a",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u028d",
            "",
            "\1\u028e",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0293",
            "\1\u0294",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0296",
            "\1\u0297",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0299",
            "",
            "\1\u029a",
            "\1\u029b",
            "\1\u029c",
            "\1\u029d",
            "\1\u029e",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u02a0\26\67",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\1\u02a2\31\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\u02a5",
            "\1\u02a6",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u02a8",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u02aa\7\67\1\u02ab\3\67\1\u02ac\12\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u02b0",
            "\1\u02b1",
            "\1\u02b2",
            "\1\u02b3",
            "\1\u02b4",
            "\1\u02b5",
            "\1\u02b6",
            "\1\u02b7",
            "",
            "\1\u02b8",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u02b9\26\67",
            "\1\u02bb",
            "\1\u02bc",
            "\1\u02bd",
            "\1\u02be",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u02c0",
            "\1\u02c1",
            "\1\u02c2",
            "\1\u02c3\12\uffff\1\u02c4\4\uffff\1\u02c5",
            "\1\u02c6\11\uffff\1\u02c7",
            "\1\u02c8",
            "\1\u02c9",
            "\1\u02ca",
            "\1\u02cb",
            "\1\u02cc",
            "\1\u02cd",
            "",
            "\1\u02ce",
            "\1\u02cf",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u02d1\20\uffff\1\u02d2",
            "\1\u02d3",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u02d5",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u02d6\25\67",
            "\1\u02d8",
            "\1\u02d9",
            "",
            "\1\u02da",
            "\1\u02db",
            "\1\u02dc",
            "\1\u02dd",
            "\1\u02de",
            "\1\u02df",
            "\1\u02e0",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u02e1\26\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u02e4\7\67",
            "\1\u02e6",
            "\1\u02e7",
            "\1\u02e8",
            "\1\u02e9",
            "\1\u02ea",
            "\1\u02eb",
            "\1\u02ec",
            "\1\u02ed",
            "\1\u02ee\6\uffff\1\u02ef",
            "",
            "\1\u02f0",
            "\1\u02f1",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u02f2\12\67",
            "\1\u02f4",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u02f7",
            "\1\u02f8",
            "",
            "\1\u00a7\1\uffff\12\u024c",
            "\1\u02f9",
            "\1\u02fa",
            "\1\u02fb",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\u02fd",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0300",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0305",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u0306\26\67",
            "\1\u0308",
            "\1\u0309",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u030b",
            "\1\u030c",
            "\1\u030d",
            "\1\u030e",
            "\1\u030f",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0311",
            "\1\u0312",
            "\1\u0313",
            "\1\u0314",
            "\1\u0315",
            "\1\u0316",
            "\1\u0317",
            "",
            "",
            "\1\u0318",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u031a",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u031c",
            "",
            "\1\u031d",
            "\1\u031e",
            "",
            "\1\u031f\1\uffff\1\u0320\6\uffff\1\u0321",
            "\1\u0322",
            "\1\u0323",
            "\1\u0324",
            "\1\u0325",
            "\1\u0326",
            "\1\u0327",
            "\1\u0328\5\uffff\1\u0329",
            "\1\u032a\10\uffff\1\u032b\6\uffff\1\u032c",
            "\1\u032d",
            "\1\u032e",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0330",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "\1\u0333",
            "\1\u0334",
            "",
            "\1\u0335",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0336\6\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u033a",
            "\1\u033b",
            "\1\u033c",
            "\1\u033d",
            "",
            "\1\u033e",
            "",
            "\1\u033f",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\5\67\1\u0340\24\67",
            "\1\u0342",
            "",
            "\1\u0343",
            "",
            "\1\u0344",
            "\1\u0345",
            "\1\u0346",
            "",
            "",
            "",
            "\1\u0347",
            "\1\u0348",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u034a",
            "\1\u034b",
            "\1\u034c",
            "\1\u034d",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u034f",
            "\1\u0350",
            "",
            "\1\u0351",
            "\1\u0352",
            "\1\u0353",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0355",
            "\1\u0356",
            "\1\u0357",
            "\1\u0358",
            "\1\u0359\5\uffff\1\u035a",
            "\1\u035b",
            "\1\u035c",
            "\1\u035d",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u035f",
            "\1\u0360",
            "\1\u0361",
            "\1\u0362",
            "\1\u0363",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0365",
            "",
            "\1\u0366",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0368",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u036c",
            "\1\u036d",
            "\1\u036e",
            "\1\u036f",
            "\1\u0370",
            "\1\u0371",
            "\1\u0372",
            "\1\u0373",
            "\1\u0374",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0376",
            "\1\u0377",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u037a",
            "\1\u037b",
            "\1\u037c",
            "\1\u037d",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0381",
            "\1\u0382",
            "",
            "\1\u0383",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0386",
            "\1\u0387",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0389",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u038c",
            "",
            "\1\u038d",
            "\1\u038e",
            "",
            "\1\u038f",
            "\1\u0390",
            "\1\u0391",
            "\1\u0392",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0394",
            "\1\u0395",
            "\1\u0396",
            "\1\u0397",
            "\1\u0398",
            "\1\u0399",
            "\1\u039a",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u039d",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u039f",
            "\1\u03a0",
            "\1\u03a1",
            "\1\u03a2",
            "\1\u03a3",
            "\1\u03a4",
            "\1\u03a5\2\uffff\1\u03a6",
            "\1\u03a7",
            "\1\u03a8",
            "\1\u03a9",
            "\1\u03aa",
            "\1\u03ab",
            "\1\u03ac",
            "\1\u03ad",
            "\1\u03ae",
            "\1\u03af",
            "\1\u03b0",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\u03b2",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03b5",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03ba",
            "\1\u03bb",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u03bd",
            "\1\u03be",
            "\1\u03bf",
            "\1\u03c0",
            "\1\u03c1",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03c3",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03c5",
            "\1\u03c6",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03c9",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u03cd",
            "\1\u03ce",
            "\1\u03cf",
            "\1\u03d0",
            "\1\u03d1",
            "\1\u03d2",
            "\1\u03d3",
            "\1\u03d4",
            "\1\u03d5",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03d8",
            "\1\u03d9",
            "\1\u03da",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u03db\12\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u03de",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03e0",
            "\1\u03e1",
            "\1\u03e2",
            "\1\u03e3",
            "\1\u03e4",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03e6",
            "\1\u03e7",
            "",
            "\1\u03e8",
            "\1\u03e9",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03ed",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03ef",
            "\1\u03f0",
            "",
            "",
            "\1\u03f1",
            "\1\u03f2",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\u03f4",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u03f6",
            "\1\u03f7",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u03fb",
            "\1\u03fc",
            "\1\u03fd",
            "\1\u03fe",
            "\1\u03ff",
            "\1\u0400",
            "\1\u0401",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0403",
            "\1\u0404",
            "\1\u0405",
            "\1\u0406",
            "\1\u0407\2\uffff\1\u0408",
            "\1\u0409",
            "\1\u040a",
            "\1\u040b",
            "\1\u040c",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u040f",
            "\1\u0410",
            "\1\u0411",
            "\1\u0412",
            "\1\u0413",
            "\1\u0414\2\uffff\1\u0415",
            "\1\u0416\1\u0417",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\u0419",
            "",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u041c",
            "\1\u041d",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u041f\5\uffff\1\u0420",
            "\1\u0421",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0424",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\u0426",
            "\1\u0427",
            "\1\u0428",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u042a",
            "\1\u042b",
            "\1\u042c",
            "\1\u042d",
            "\1\u042e",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0430",
            "\1\u0431",
            "\1\u0432",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0439",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u043b",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u043f",
            "\1\u0440",
            "\47\u0444\1\u0442\22\u0444\1\u0441\6\u0444\32\u0443\4\u0444\1\u0443\1\u0444\32\u0443\uff85\u0444",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0449",
            "\1\u044a",
            "\1\u044b",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u044d",
            "\1\u044e",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0453",
            "\1\u0454",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0456\14\uffff\1\u0457",
            "\1\u0458",
            "\1\u0459",
            "",
            "",
            "\1\u045a",
            "\1\u045b\2\uffff\1\u045c",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0460",
            "\1\u0461",
            "\1\u0462",
            "\1\u0463",
            "",
            "\1\u0464",
            "",
            "",
            "\1\u0465",
            "\1\u0466",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\u046a",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u046c",
            "\1\u046d",
            "",
            "\1\u046e",
            "\1\u046f",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0471",
            "\1\u0472",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0475",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\u0478",
            "\47\u047c\1\u047a\22\u047c\1\u0479\6\u047c\32\u047b\4\u047c\1\u047b\1\u047c\32\u047b\uff85\u047c",
            "\1\u047d",
            "\32\u047e\4\uffff\1\u047e\1\uffff\32\u047e",
            "\47\u0444\1\u0442\22\u0444\1\u0441\6\u0444\32\u0443\4\u0444\1\u0443\1\u0444\32\u0443\uff85\u0444",
            "",
            "",
            "",
            "",
            "",
            "\1\u047f",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0481",
            "",
            "\1\u0482",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "\1\u0484\14\uffff\1\u0485",
            "\1\u0486",
            "",
            "\1\u0487",
            "\1\u0488",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u048a",
            "\1\u048b",
            "\1\u048c",
            "\1\u048d",
            "",
            "",
            "",
            "\1\u048e\1\uffff\1\u048f",
            "\1\u0490",
            "\1\u0491",
            "\1\u0492",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0497",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0499",
            "\1\u049a",
            "",
            "\1\u049b",
            "\1\u049c",
            "",
            "",
            "\1\u049d",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u049f",
            "\32\u04a0\4\uffff\1\u04a0\1\uffff\32\u04a0",
            "\47\u047c\1\u047a\22\u047c\1\u0479\6\u047c\32\u047b\4\u047c\1\u047b\1\u047c\32\u047b\uff85\u047c",
            "",
            "\32\u047e\4\uffff\1\u047e\1\uffff\32\u047e",
            "\47\u0444\1\u0442\22\u0444\1\u0441\6\u0444\32\u047e\4\u0444\1\u047e\1\u0444\32\u047e\uff85\u0444",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u04a2",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u04a4",
            "\1\u04a5",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u04a7",
            "\1\u04a8",
            "",
            "\1\u04a9",
            "\1\u04aa",
            "\1\u04ab",
            "\1\u04ac",
            "\1\u04ad",
            "\1\u04ae",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u04b0",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u04b3",
            "\1\u04b4",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\32\u04a0\4\uffff\1\u04a0\1\uffff\32\u04a0",
            "\47\u047c\1\u047a\22\u047c\1\u0479\6\u047c\32\u04a0\4\u047c\1\u04a0\1\u047c\32\u04a0\uff85\u047c",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u04b9",
            "\1\u04ba",
            "",
            "\1\u04bb",
            "\1\u04bc",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u04bf\23\uffff\1\u04c0",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u04c2",
            "\1\u04c3",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "\1\u04c7",
            "\1\u04c8",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\u04cb",
            "\1\u04cc",
            "",
            "\1\u04cd",
            "\1\u04ce",
            "",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\u04d1",
            "\1\u04d2",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u04d6",
            "",
            "",
            "",
            "\1\u04d7",
            "\1\67\22\uffff\1\67\6\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            ""
    };

    static final short[] DFA77_eot = DFA.unpackEncodedString(DFA77_eotS);
    static final short[] DFA77_eof = DFA.unpackEncodedString(DFA77_eofS);
    static final char[] DFA77_min = DFA.unpackEncodedStringToUnsignedChars(DFA77_minS);
    static final char[] DFA77_max = DFA.unpackEncodedStringToUnsignedChars(DFA77_maxS);
    static final short[] DFA77_accept = DFA.unpackEncodedString(DFA77_acceptS);
    static final short[] DFA77_special = DFA.unpackEncodedString(DFA77_specialS);
    static final short[][] DFA77_transition;

    static {
        int numStates = DFA77_transitionS.length;
        DFA77_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA77_transition[i] = DFA.unpackEncodedString(DFA77_transitionS[i]);
        }
    }

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = DFA77_eot;
            this.eof = DFA77_eof;
            this.min = DFA77_min;
            this.max = DFA77_max;
            this.accept = DFA77_accept;
            this.special = DFA77_special;
            this.transition = DFA77_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | T__148 | T__149 | T__150 | T__151 | T__152 | T__153 | T__154 | T__155 | T__156 | T__157 | T__158 | T__159 | T__160 | T__161 | T__162 | T__163 | T__164 | T__165 | T__166 | T__167 | T__168 | T__169 | T__170 | T__171 | T__172 | T__173 | T__174 | T__175 | T__176 | T__177 | T__178 | T__179 | T__180 | T__181 | T__182 | T__183 | T__184 | T__185 | T__186 | T__187 | T__188 | T__189 | T__190 | T__191 | T__192 | T__193 | T__194 | T__195 | T__196 | T__197 | T__198 | T__199 | T__200 | T__201 | T__202 | T__203 | T__204 | T__205 | T__206 | T__207 | T__208 | T__209 | T__210 | T__211 | T__212 | T__213 | T__214 | T__215 | T__216 | T__217 | T__218 | T__219 | T__220 | T__221 | T__222 | T__223 | T__224 | T__225 | T__226 | T__227 | T__228 | T__229 | T__230 | T__231 | T__232 | T__233 | T__234 | T__235 | T__236 | T__237 | T__238 | T__239 | T__240 | T__241 | T__242 | T__243 | T__244 | T__245 | T__246 | T__247 | T__248 | T__249 | T__250 | T__251 | T__252 | T__253 | T__254 | T__255 | T__256 | T__257 | T__258 | T__259 | T__260 | T__261 | T__262 | T__263 | T__264 | T__265 | T__266 | T__267 | T__268 | T__269 | T__270 | T__271 | T__272 | T__273 | T__274 | T__275 | T__276 | T__277 | T__278 | T__279 | T__280 | T__281 | T__282 | T__283 | T__284 | T__285 | T__286 | T__287 | T__288 | T__289 | T__290 | T__291 | T__292 | T__293 | T__294 | T__295 | T__296 | T__297 | T__298 | T__299 | T__300 | T__301 | T__302 | T__303 | T__304 | T__305 | T__306 | T__307 | T__308 | T__309 | T__310 | T__311 | T__312 | T__313 | T__314 | T__315 | T__316 | T__317 | T__318 | T__319 | T__320 | T__321 | T__322 | T__323 | T__324 | T__325 | T__326 | T__327 | T__328 | T__329 | T__330 | T__331 | T__332 | T__333 | T__334 | T__335 | T__336 | T__337 | T__338 | T__339 | T__340 | T__341 | T__342 | T__343 | T__344 | T__345 | T__346 | T__347 | T__348 | RULE_NUMBER | RULE_ID | RULE_SYMBOL | RULE_VERSION | RULE_STRING | RULE_BACKTICK_STRING | RULE_INTERPOLATE | RULE_LITERAL | RULE_WORDS_QUOTE_LIKE | RULE_COMMAND_QUOTE_LIKE | RULE_REGEX_QUOTE | RULE_REGEX_SUBSTITUTE | RULE_REGEX_TRANSLITERATE | RULE_REGEX_MATCH | RULE_READLINE_QUOTE | RULE_POD | RULE_DATA | RULE_END | RULE_SL_COMMENT | RULE_WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA77_1088 = input.LA(1);

                        s = -1;
                        if ( (LA77_1088==':') ) {s = 1145;}

                        else if ( (LA77_1088=='\'') ) {s = 1146;}

                        else if ( ((LA77_1088>='A' && LA77_1088<='Z')||LA77_1088=='_'||(LA77_1088>='a' && LA77_1088<='z')) ) {s = 1147;}

                        else if ( ((LA77_1088>='\u0000' && LA77_1088<='&')||(LA77_1088>='(' && LA77_1088<='9')||(LA77_1088>=';' && LA77_1088<='@')||(LA77_1088>='[' && LA77_1088<='^')||LA77_1088=='`'||(LA77_1088>='{' && LA77_1088<='\uFFFF')) ) {s = 1148;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA77_1010 = input.LA(1);

                        s = -1;
                        if ( (LA77_1010==':') ) {s = 1089;}

                        else if ( (LA77_1010=='\'') ) {s = 1090;}

                        else if ( ((LA77_1010>='A' && LA77_1010<='Z')||LA77_1010=='_'||(LA77_1010>='a' && LA77_1010<='z')) ) {s = 1091;}

                        else if ( ((LA77_1010>='\u0000' && LA77_1010<='&')||(LA77_1010>='(' && LA77_1010<='9')||(LA77_1010>=';' && LA77_1010<='@')||(LA77_1010>='[' && LA77_1010<='^')||LA77_1010=='`'||(LA77_1010>='{' && LA77_1010<='\uFFFF')) ) {s = 1092;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA77_1184 = input.LA(1);

                        s = -1;
                        if ( (LA77_1184==':') ) {s = 1145;}

                        else if ( (LA77_1184=='\'') ) {s = 1146;}

                        else if ( ((LA77_1184>='A' && LA77_1184<='Z')||LA77_1184=='_'||(LA77_1184>='a' && LA77_1184<='z')) ) {s = 1184;}

                        else if ( ((LA77_1184>='\u0000' && LA77_1184<='&')||(LA77_1184>='(' && LA77_1184<='9')||(LA77_1184>=';' && LA77_1184<='@')||(LA77_1184>='[' && LA77_1184<='^')||LA77_1184=='`'||(LA77_1184>='{' && LA77_1184<='\uFFFF')) ) {s = 1148;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA77_1150 = input.LA(1);

                        s = -1;
                        if ( (LA77_1150==':') ) {s = 1089;}

                        else if ( (LA77_1150=='\'') ) {s = 1090;}

                        else if ( ((LA77_1150>='A' && LA77_1150<='Z')||LA77_1150=='_'||(LA77_1150>='a' && LA77_1150<='z')) ) {s = 1150;}

                        else if ( ((LA77_1150>='\u0000' && LA77_1150<='&')||(LA77_1150>='(' && LA77_1150<='9')||(LA77_1150>=';' && LA77_1150<='@')||(LA77_1150>='[' && LA77_1150<='^')||LA77_1150=='`'||(LA77_1150>='{' && LA77_1150<='\uFFFF')) ) {s = 1092;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA77_1147 = input.LA(1);

                        s = -1;
                        if ( (LA77_1147==':') ) {s = 1145;}

                        else if ( (LA77_1147=='\'') ) {s = 1146;}

                        else if ( ((LA77_1147>='A' && LA77_1147<='Z')||LA77_1147=='_'||(LA77_1147>='a' && LA77_1147<='z')) ) {s = 1147;}

                        else if ( ((LA77_1147>='\u0000' && LA77_1147<='&')||(LA77_1147>='(' && LA77_1147<='9')||(LA77_1147>=';' && LA77_1147<='@')||(LA77_1147>='[' && LA77_1147<='^')||LA77_1147=='`'||(LA77_1147>='{' && LA77_1147<='\uFFFF')) ) {s = 1148;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA77_1091 = input.LA(1);

                        s = -1;
                        if ( (LA77_1091==':') ) {s = 1089;}

                        else if ( (LA77_1091=='\'') ) {s = 1090;}

                        else if ( ((LA77_1091>='A' && LA77_1091<='Z')||LA77_1091=='_'||(LA77_1091>='a' && LA77_1091<='z')) ) {s = 1091;}

                        else if ( ((LA77_1091>='\u0000' && LA77_1091<='&')||(LA77_1091>='(' && LA77_1091<='9')||(LA77_1091>=';' && LA77_1091<='@')||(LA77_1091>='[' && LA77_1091<='^')||LA77_1091=='`'||(LA77_1091>='{' && LA77_1091<='\uFFFF')) ) {s = 1092;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 77, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}