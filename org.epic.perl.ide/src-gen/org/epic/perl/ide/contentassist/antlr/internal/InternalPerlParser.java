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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_VAR_START", "RULE_SL_COMMENT", "RULE_WS", "'='", "'||'", "'&&'", "'my'", "'our'", "'local'", "'+='", "'-='", "'*='", "'/='", "'%='", "'**='", "'=='", "'!='", "'eq'", "'ne'", "'>='", "'<='", "'>'", "'<'", "'*'", "'**'", "'/'", "'%'", "'+'", "'-'", "'('", "')'", "'!'", "'undef'", "'.'"
    };
    public static final int RULE_HEX=4;
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_BIN=5;
    public static final int T__32=32;
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_VAR_START=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__42=42;
    public static final int T__21=21;

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



    // $ANTLR start "entryRulePerlModel"
    // InternalPerl.g:53:1: entryRulePerlModel : rulePerlModel EOF ;
    public final void entryRulePerlModel() throws RecognitionException {
        try {
            // InternalPerl.g:54:1: ( rulePerlModel EOF )
            // InternalPerl.g:55:1: rulePerlModel EOF
            {
             before(grammarAccess.getPerlModelRule()); 
            pushFollow(FOLLOW_1);
            rulePerlModel();

            state._fsp--;

             after(grammarAccess.getPerlModelRule()); 
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
    // $ANTLR end "entryRulePerlModel"


    // $ANTLR start "rulePerlModel"
    // InternalPerl.g:62:1: rulePerlModel : ( ( rule__PerlModel__ElementsAssignment )* ) ;
    public final void rulePerlModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:66:2: ( ( ( rule__PerlModel__ElementsAssignment )* ) )
            // InternalPerl.g:67:2: ( ( rule__PerlModel__ElementsAssignment )* )
            {
            // InternalPerl.g:67:2: ( ( rule__PerlModel__ElementsAssignment )* )
            // InternalPerl.g:68:3: ( rule__PerlModel__ElementsAssignment )*
            {
             before(grammarAccess.getPerlModelAccess().getElementsAssignment()); 
            // InternalPerl.g:69:3: ( rule__PerlModel__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_HEX && LA1_0<=RULE_STRING)||(LA1_0>=15 && LA1_0<=17)||LA1_0==38||(LA1_0>=40 && LA1_0<=41)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPerl.g:69:4: rule__PerlModel__ElementsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__PerlModel__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getPerlModelAccess().getElementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePerlModel"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalPerl.g:78:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // InternalPerl.g:79:1: ( ruleAbstractElement EOF )
            // InternalPerl.g:80:1: ruleAbstractElement EOF
            {
             before(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getAbstractElementRule()); 
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
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalPerl.g:87:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:91:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // InternalPerl.g:92:2: ( ( rule__AbstractElement__Alternatives ) )
            {
            // InternalPerl.g:92:2: ( ( rule__AbstractElement__Alternatives ) )
            // InternalPerl.g:93:3: ( rule__AbstractElement__Alternatives )
            {
             before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            // InternalPerl.g:94:3: ( rule__AbstractElement__Alternatives )
            // InternalPerl.g:94:4: rule__AbstractElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AbstractElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleAssignment"
    // InternalPerl.g:103:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalPerl.g:104:1: ( ruleAssignment EOF )
            // InternalPerl.g:105:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            ruleAssignment();

            state._fsp--;

             after(grammarAccess.getAssignmentRule()); 
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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalPerl.g:112:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:116:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalPerl.g:117:2: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalPerl.g:117:2: ( ( rule__Assignment__Group__0 ) )
            // InternalPerl.g:118:3: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // InternalPerl.g:119:3: ( rule__Assignment__Group__0 )
            // InternalPerl.g:119:4: rule__Assignment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // InternalPerl.g:128:1: entryRuleOpSingleAssign : ruleOpSingleAssign EOF ;
    public final void entryRuleOpSingleAssign() throws RecognitionException {
        try {
            // InternalPerl.g:129:1: ( ruleOpSingleAssign EOF )
            // InternalPerl.g:130:1: ruleOpSingleAssign EOF
            {
             before(grammarAccess.getOpSingleAssignRule()); 
            pushFollow(FOLLOW_1);
            ruleOpSingleAssign();

            state._fsp--;

             after(grammarAccess.getOpSingleAssignRule()); 
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
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // InternalPerl.g:137:1: ruleOpSingleAssign : ( '=' ) ;
    public final void ruleOpSingleAssign() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:141:2: ( ( '=' ) )
            // InternalPerl.g:142:2: ( '=' )
            {
            // InternalPerl.g:142:2: ( '=' )
            // InternalPerl.g:143:3: '='
            {
             before(grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // InternalPerl.g:153:1: entryRuleOpMultiAssign : ruleOpMultiAssign EOF ;
    public final void entryRuleOpMultiAssign() throws RecognitionException {
        try {
            // InternalPerl.g:154:1: ( ruleOpMultiAssign EOF )
            // InternalPerl.g:155:1: ruleOpMultiAssign EOF
            {
             before(grammarAccess.getOpMultiAssignRule()); 
            pushFollow(FOLLOW_1);
            ruleOpMultiAssign();

            state._fsp--;

             after(grammarAccess.getOpMultiAssignRule()); 
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
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // InternalPerl.g:162:1: ruleOpMultiAssign : ( ( rule__OpMultiAssign__Alternatives ) ) ;
    public final void ruleOpMultiAssign() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:166:2: ( ( ( rule__OpMultiAssign__Alternatives ) ) )
            // InternalPerl.g:167:2: ( ( rule__OpMultiAssign__Alternatives ) )
            {
            // InternalPerl.g:167:2: ( ( rule__OpMultiAssign__Alternatives ) )
            // InternalPerl.g:168:3: ( rule__OpMultiAssign__Alternatives )
            {
             before(grammarAccess.getOpMultiAssignAccess().getAlternatives()); 
            // InternalPerl.g:169:3: ( rule__OpMultiAssign__Alternatives )
            // InternalPerl.g:169:4: rule__OpMultiAssign__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOpMultiAssignAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleExpression"
    // InternalPerl.g:178:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalPerl.g:179:1: ( ruleExpression EOF )
            // InternalPerl.g:180:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalPerl.g:187:1: ruleExpression : ( ruleOr ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:191:2: ( ( ruleOr ) )
            // InternalPerl.g:192:2: ( ruleOr )
            {
            // InternalPerl.g:192:2: ( ruleOr )
            // InternalPerl.g:193:3: ruleOr
            {
             before(grammarAccess.getExpressionAccess().getOrParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getOrParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOr"
    // InternalPerl.g:203:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // InternalPerl.g:204:1: ( ruleOr EOF )
            // InternalPerl.g:205:1: ruleOr EOF
            {
             before(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getOrRule()); 
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
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalPerl.g:212:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:216:2: ( ( ( rule__Or__Group__0 ) ) )
            // InternalPerl.g:217:2: ( ( rule__Or__Group__0 ) )
            {
            // InternalPerl.g:217:2: ( ( rule__Or__Group__0 ) )
            // InternalPerl.g:218:3: ( rule__Or__Group__0 )
            {
             before(grammarAccess.getOrAccess().getGroup()); 
            // InternalPerl.g:219:3: ( rule__Or__Group__0 )
            // InternalPerl.g:219:4: rule__Or__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleOpOr"
    // InternalPerl.g:228:1: entryRuleOpOr : ruleOpOr EOF ;
    public final void entryRuleOpOr() throws RecognitionException {
        try {
            // InternalPerl.g:229:1: ( ruleOpOr EOF )
            // InternalPerl.g:230:1: ruleOpOr EOF
            {
             before(grammarAccess.getOpOrRule()); 
            pushFollow(FOLLOW_1);
            ruleOpOr();

            state._fsp--;

             after(grammarAccess.getOpOrRule()); 
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
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalPerl.g:237:1: ruleOpOr : ( '||' ) ;
    public final void ruleOpOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:241:2: ( ( '||' ) )
            // InternalPerl.g:242:2: ( '||' )
            {
            // InternalPerl.g:242:2: ( '||' )
            // InternalPerl.g:243:3: '||'
            {
             before(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleAnd"
    // InternalPerl.g:253:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalPerl.g:254:1: ( ruleAnd EOF )
            // InternalPerl.g:255:1: ruleAnd EOF
            {
             before(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getAndRule()); 
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
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalPerl.g:262:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:266:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalPerl.g:267:2: ( ( rule__And__Group__0 ) )
            {
            // InternalPerl.g:267:2: ( ( rule__And__Group__0 ) )
            // InternalPerl.g:268:3: ( rule__And__Group__0 )
            {
             before(grammarAccess.getAndAccess().getGroup()); 
            // InternalPerl.g:269:3: ( rule__And__Group__0 )
            // InternalPerl.g:269:4: rule__And__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleOpAnd"
    // InternalPerl.g:278:1: entryRuleOpAnd : ruleOpAnd EOF ;
    public final void entryRuleOpAnd() throws RecognitionException {
        try {
            // InternalPerl.g:279:1: ( ruleOpAnd EOF )
            // InternalPerl.g:280:1: ruleOpAnd EOF
            {
             before(grammarAccess.getOpAndRule()); 
            pushFollow(FOLLOW_1);
            ruleOpAnd();

            state._fsp--;

             after(grammarAccess.getOpAndRule()); 
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
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalPerl.g:287:1: ruleOpAnd : ( '&&' ) ;
    public final void ruleOpAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:291:2: ( ( '&&' ) )
            // InternalPerl.g:292:2: ( '&&' )
            {
            // InternalPerl.g:292:2: ( '&&' )
            // InternalPerl.g:293:3: '&&'
            {
             before(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleEquality"
    // InternalPerl.g:303:1: entryRuleEquality : ruleEquality EOF ;
    public final void entryRuleEquality() throws RecognitionException {
        try {
            // InternalPerl.g:304:1: ( ruleEquality EOF )
            // InternalPerl.g:305:1: ruleEquality EOF
            {
             before(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_1);
            ruleEquality();

            state._fsp--;

             after(grammarAccess.getEqualityRule()); 
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
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // InternalPerl.g:312:1: ruleEquality : ( ( rule__Equality__Group__0 ) ) ;
    public final void ruleEquality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:316:2: ( ( ( rule__Equality__Group__0 ) ) )
            // InternalPerl.g:317:2: ( ( rule__Equality__Group__0 ) )
            {
            // InternalPerl.g:317:2: ( ( rule__Equality__Group__0 ) )
            // InternalPerl.g:318:3: ( rule__Equality__Group__0 )
            {
             before(grammarAccess.getEqualityAccess().getGroup()); 
            // InternalPerl.g:319:3: ( rule__Equality__Group__0 )
            // InternalPerl.g:319:4: rule__Equality__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEqualityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleOpEquality"
    // InternalPerl.g:328:1: entryRuleOpEquality : ruleOpEquality EOF ;
    public final void entryRuleOpEquality() throws RecognitionException {
        try {
            // InternalPerl.g:329:1: ( ruleOpEquality EOF )
            // InternalPerl.g:330:1: ruleOpEquality EOF
            {
             before(grammarAccess.getOpEqualityRule()); 
            pushFollow(FOLLOW_1);
            ruleOpEquality();

            state._fsp--;

             after(grammarAccess.getOpEqualityRule()); 
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
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalPerl.g:337:1: ruleOpEquality : ( ( rule__OpEquality__Alternatives ) ) ;
    public final void ruleOpEquality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:341:2: ( ( ( rule__OpEquality__Alternatives ) ) )
            // InternalPerl.g:342:2: ( ( rule__OpEquality__Alternatives ) )
            {
            // InternalPerl.g:342:2: ( ( rule__OpEquality__Alternatives ) )
            // InternalPerl.g:343:3: ( rule__OpEquality__Alternatives )
            {
             before(grammarAccess.getOpEqualityAccess().getAlternatives()); 
            // InternalPerl.g:344:3: ( rule__OpEquality__Alternatives )
            // InternalPerl.g:344:4: rule__OpEquality__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpEquality__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOpEqualityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleComparison"
    // InternalPerl.g:353:1: entryRuleComparison : ruleComparison EOF ;
    public final void entryRuleComparison() throws RecognitionException {
        try {
            // InternalPerl.g:354:1: ( ruleComparison EOF )
            // InternalPerl.g:355:1: ruleComparison EOF
            {
             before(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getComparisonRule()); 
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
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalPerl.g:362:1: ruleComparison : ( ( rule__Comparison__Group__0 ) ) ;
    public final void ruleComparison() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:366:2: ( ( ( rule__Comparison__Group__0 ) ) )
            // InternalPerl.g:367:2: ( ( rule__Comparison__Group__0 ) )
            {
            // InternalPerl.g:367:2: ( ( rule__Comparison__Group__0 ) )
            // InternalPerl.g:368:3: ( rule__Comparison__Group__0 )
            {
             before(grammarAccess.getComparisonAccess().getGroup()); 
            // InternalPerl.g:369:3: ( rule__Comparison__Group__0 )
            // InternalPerl.g:369:4: rule__Comparison__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRulePlusOrMinus"
    // InternalPerl.g:378:1: entryRulePlusOrMinus : rulePlusOrMinus EOF ;
    public final void entryRulePlusOrMinus() throws RecognitionException {
        try {
            // InternalPerl.g:379:1: ( rulePlusOrMinus EOF )
            // InternalPerl.g:380:1: rulePlusOrMinus EOF
            {
             before(grammarAccess.getPlusOrMinusRule()); 
            pushFollow(FOLLOW_1);
            rulePlusOrMinus();

            state._fsp--;

             after(grammarAccess.getPlusOrMinusRule()); 
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
    // $ANTLR end "entryRulePlusOrMinus"


    // $ANTLR start "rulePlusOrMinus"
    // InternalPerl.g:387:1: rulePlusOrMinus : ( ( rule__PlusOrMinus__Group__0 ) ) ;
    public final void rulePlusOrMinus() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:391:2: ( ( ( rule__PlusOrMinus__Group__0 ) ) )
            // InternalPerl.g:392:2: ( ( rule__PlusOrMinus__Group__0 ) )
            {
            // InternalPerl.g:392:2: ( ( rule__PlusOrMinus__Group__0 ) )
            // InternalPerl.g:393:3: ( rule__PlusOrMinus__Group__0 )
            {
             before(grammarAccess.getPlusOrMinusAccess().getGroup()); 
            // InternalPerl.g:394:3: ( rule__PlusOrMinus__Group__0 )
            // InternalPerl.g:394:4: rule__PlusOrMinus__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPlusOrMinusAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePlusOrMinus"


    // $ANTLR start "entryRuleMulOrDiv"
    // InternalPerl.g:403:1: entryRuleMulOrDiv : ruleMulOrDiv EOF ;
    public final void entryRuleMulOrDiv() throws RecognitionException {
        try {
            // InternalPerl.g:404:1: ( ruleMulOrDiv EOF )
            // InternalPerl.g:405:1: ruleMulOrDiv EOF
            {
             before(grammarAccess.getMulOrDivRule()); 
            pushFollow(FOLLOW_1);
            ruleMulOrDiv();

            state._fsp--;

             after(grammarAccess.getMulOrDivRule()); 
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
    // $ANTLR end "entryRuleMulOrDiv"


    // $ANTLR start "ruleMulOrDiv"
    // InternalPerl.g:412:1: ruleMulOrDiv : ( ( rule__MulOrDiv__Group__0 ) ) ;
    public final void ruleMulOrDiv() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:416:2: ( ( ( rule__MulOrDiv__Group__0 ) ) )
            // InternalPerl.g:417:2: ( ( rule__MulOrDiv__Group__0 ) )
            {
            // InternalPerl.g:417:2: ( ( rule__MulOrDiv__Group__0 ) )
            // InternalPerl.g:418:3: ( rule__MulOrDiv__Group__0 )
            {
             before(grammarAccess.getMulOrDivAccess().getGroup()); 
            // InternalPerl.g:419:3: ( rule__MulOrDiv__Group__0 )
            // InternalPerl.g:419:4: rule__MulOrDiv__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMulOrDivAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMulOrDiv"


    // $ANTLR start "entryRuleOpMulOrDiv"
    // InternalPerl.g:428:1: entryRuleOpMulOrDiv : ruleOpMulOrDiv EOF ;
    public final void entryRuleOpMulOrDiv() throws RecognitionException {
        try {
            // InternalPerl.g:429:1: ( ruleOpMulOrDiv EOF )
            // InternalPerl.g:430:1: ruleOpMulOrDiv EOF
            {
             before(grammarAccess.getOpMulOrDivRule()); 
            pushFollow(FOLLOW_1);
            ruleOpMulOrDiv();

            state._fsp--;

             after(grammarAccess.getOpMulOrDivRule()); 
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
    // $ANTLR end "entryRuleOpMulOrDiv"


    // $ANTLR start "ruleOpMulOrDiv"
    // InternalPerl.g:437:1: ruleOpMulOrDiv : ( ( rule__OpMulOrDiv__Alternatives ) ) ;
    public final void ruleOpMulOrDiv() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:441:2: ( ( ( rule__OpMulOrDiv__Alternatives ) ) )
            // InternalPerl.g:442:2: ( ( rule__OpMulOrDiv__Alternatives ) )
            {
            // InternalPerl.g:442:2: ( ( rule__OpMulOrDiv__Alternatives ) )
            // InternalPerl.g:443:3: ( rule__OpMulOrDiv__Alternatives )
            {
             before(grammarAccess.getOpMulOrDivAccess().getAlternatives()); 
            // InternalPerl.g:444:3: ( rule__OpMulOrDiv__Alternatives )
            // InternalPerl.g:444:4: rule__OpMulOrDiv__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpMulOrDiv__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOpMulOrDivAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpMulOrDiv"


    // $ANTLR start "entryRulePrimary"
    // InternalPerl.g:453:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // InternalPerl.g:454:1: ( rulePrimary EOF )
            // InternalPerl.g:455:1: rulePrimary EOF
            {
             before(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getPrimaryRule()); 
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
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalPerl.g:462:1: rulePrimary : ( ( rule__Primary__Alternatives ) ) ;
    public final void rulePrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:466:2: ( ( ( rule__Primary__Alternatives ) ) )
            // InternalPerl.g:467:2: ( ( rule__Primary__Alternatives ) )
            {
            // InternalPerl.g:467:2: ( ( rule__Primary__Alternatives ) )
            // InternalPerl.g:468:3: ( rule__Primary__Alternatives )
            {
             before(grammarAccess.getPrimaryAccess().getAlternatives()); 
            // InternalPerl.g:469:3: ( rule__Primary__Alternatives )
            // InternalPerl.g:469:4: rule__Primary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleAtomic"
    // InternalPerl.g:478:1: entryRuleAtomic : ruleAtomic EOF ;
    public final void entryRuleAtomic() throws RecognitionException {
        try {
            // InternalPerl.g:479:1: ( ruleAtomic EOF )
            // InternalPerl.g:480:1: ruleAtomic EOF
            {
             before(grammarAccess.getAtomicRule()); 
            pushFollow(FOLLOW_1);
            ruleAtomic();

            state._fsp--;

             after(grammarAccess.getAtomicRule()); 
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
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // InternalPerl.g:487:1: ruleAtomic : ( ( rule__Atomic__Alternatives ) ) ;
    public final void ruleAtomic() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:491:2: ( ( ( rule__Atomic__Alternatives ) ) )
            // InternalPerl.g:492:2: ( ( rule__Atomic__Alternatives ) )
            {
            // InternalPerl.g:492:2: ( ( rule__Atomic__Alternatives ) )
            // InternalPerl.g:493:3: ( rule__Atomic__Alternatives )
            {
             before(grammarAccess.getAtomicAccess().getAlternatives()); 
            // InternalPerl.g:494:3: ( rule__Atomic__Alternatives )
            // InternalPerl.g:494:4: rule__Atomic__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Atomic__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAtomicAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "entryRuleVariableRef"
    // InternalPerl.g:503:1: entryRuleVariableRef : ruleVariableRef EOF ;
    public final void entryRuleVariableRef() throws RecognitionException {
        try {
            // InternalPerl.g:504:1: ( ruleVariableRef EOF )
            // InternalPerl.g:505:1: ruleVariableRef EOF
            {
             before(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            ruleVariableRef();

            state._fsp--;

             after(grammarAccess.getVariableRefRule()); 
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
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalPerl.g:512:1: ruleVariableRef : ( ( rule__VariableRef__NameAssignment ) ) ;
    public final void ruleVariableRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:516:2: ( ( ( rule__VariableRef__NameAssignment ) ) )
            // InternalPerl.g:517:2: ( ( rule__VariableRef__NameAssignment ) )
            {
            // InternalPerl.g:517:2: ( ( rule__VariableRef__NameAssignment ) )
            // InternalPerl.g:518:3: ( rule__VariableRef__NameAssignment )
            {
             before(grammarAccess.getVariableRefAccess().getNameAssignment()); 
            // InternalPerl.g:519:3: ( rule__VariableRef__NameAssignment )
            // InternalPerl.g:519:4: rule__VariableRef__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__VariableRef__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVariableRefAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleNumberLiteral"
    // InternalPerl.g:528:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:529:1: ( ruleNumberLiteral EOF )
            // InternalPerl.g:530:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
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
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // InternalPerl.g:537:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Group__0 ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:541:2: ( ( ( rule__NumberLiteral__Group__0 ) ) )
            // InternalPerl.g:542:2: ( ( rule__NumberLiteral__Group__0 ) )
            {
            // InternalPerl.g:542:2: ( ( rule__NumberLiteral__Group__0 ) )
            // InternalPerl.g:543:3: ( rule__NumberLiteral__Group__0 )
            {
             before(grammarAccess.getNumberLiteralAccess().getGroup()); 
            // InternalPerl.g:544:3: ( rule__NumberLiteral__Group__0 )
            // InternalPerl.g:544:4: rule__NumberLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NumberLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNumberLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleNullLiteral"
    // InternalPerl.g:553:1: entryRuleNullLiteral : ruleNullLiteral EOF ;
    public final void entryRuleNullLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:554:1: ( ruleNullLiteral EOF )
            // InternalPerl.g:555:1: ruleNullLiteral EOF
            {
             before(grammarAccess.getNullLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleNullLiteral();

            state._fsp--;

             after(grammarAccess.getNullLiteralRule()); 
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
    // $ANTLR end "entryRuleNullLiteral"


    // $ANTLR start "ruleNullLiteral"
    // InternalPerl.g:562:1: ruleNullLiteral : ( ( rule__NullLiteral__Group__0 ) ) ;
    public final void ruleNullLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:566:2: ( ( ( rule__NullLiteral__Group__0 ) ) )
            // InternalPerl.g:567:2: ( ( rule__NullLiteral__Group__0 ) )
            {
            // InternalPerl.g:567:2: ( ( rule__NullLiteral__Group__0 ) )
            // InternalPerl.g:568:3: ( rule__NullLiteral__Group__0 )
            {
             before(grammarAccess.getNullLiteralAccess().getGroup()); 
            // InternalPerl.g:569:3: ( rule__NullLiteral__Group__0 )
            // InternalPerl.g:569:4: rule__NullLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NullLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNullLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNullLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalPerl.g:578:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:579:1: ( ruleStringLiteral EOF )
            // InternalPerl.g:580:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalPerl.g:587:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:591:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // InternalPerl.g:592:2: ( ( rule__StringLiteral__Group__0 ) )
            {
            // InternalPerl.g:592:2: ( ( rule__StringLiteral__Group__0 ) )
            // InternalPerl.g:593:3: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // InternalPerl.g:594:3: ( rule__StringLiteral__Group__0 )
            // InternalPerl.g:594:4: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStringLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleNumber"
    // InternalPerl.g:603:1: entryRuleNumber : ruleNumber EOF ;
    public final void entryRuleNumber() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:607:1: ( ruleNumber EOF )
            // InternalPerl.g:608:1: ruleNumber EOF
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
    // InternalPerl.g:618:1: ruleNumber : ( ( rule__Number__Group__0 ) ) ;
    public final void ruleNumber() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:623:2: ( ( ( rule__Number__Group__0 ) ) )
            // InternalPerl.g:624:2: ( ( rule__Number__Group__0 ) )
            {
            // InternalPerl.g:624:2: ( ( rule__Number__Group__0 ) )
            // InternalPerl.g:625:3: ( rule__Number__Group__0 )
            {
             before(grammarAccess.getNumberAccess().getGroup()); 
            // InternalPerl.g:626:3: ( rule__Number__Group__0 )
            // InternalPerl.g:626:4: rule__Number__Group__0
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


    // $ANTLR start "rule__AbstractElement__Alternatives"
    // InternalPerl.g:635:1: rule__AbstractElement__Alternatives : ( ( ruleAssignment ) | ( ruleExpression ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:639:1: ( ( ruleAssignment ) | ( ruleExpression ) )
            int alt2=2;
            switch ( input.LA(1) ) {
            case 15:
            case 16:
            case 17:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 12:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    {
                    alt2=1;
                    }
                    break;
                case 31:
                    {
                    int LA2_4 = input.LA(3);

                    if ( (LA2_4==31) ) {
                        alt2=1;
                    }
                    else if ( ((LA2_4>=RULE_HEX && LA2_4<=RULE_STRING)||LA2_4==38||(LA2_4>=40 && LA2_4<=41)) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 30:
                    {
                    int LA2_5 = input.LA(3);

                    if ( (LA2_5==28||LA2_5==30) ) {
                        alt2=1;
                    }
                    else if ( ((LA2_5>=RULE_HEX && LA2_5<=RULE_STRING)||LA2_5==38||(LA2_5>=40 && LA2_5<=41)) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case EOF:
                case RULE_HEX:
                case RULE_BIN:
                case RULE_INT:
                case RULE_ID:
                case RULE_STRING:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 40:
                case 41:
                    {
                    alt2=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_HEX:
            case RULE_BIN:
            case RULE_INT:
            case RULE_STRING:
            case 38:
            case 40:
            case 41:
                {
                alt2=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalPerl.g:640:2: ( ruleAssignment )
                    {
                    // InternalPerl.g:640:2: ( ruleAssignment )
                    // InternalPerl.g:641:3: ruleAssignment
                    {
                     before(grammarAccess.getAbstractElementAccess().getAssignmentParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleAssignment();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getAssignmentParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:646:2: ( ruleExpression )
                    {
                    // InternalPerl.g:646:2: ( ruleExpression )
                    // InternalPerl.g:647:3: ruleExpression
                    {
                     before(grammarAccess.getAbstractElementAccess().getExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleExpression();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getExpressionParserRuleCall_1()); 

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
    // $ANTLR end "rule__AbstractElement__Alternatives"


    // $ANTLR start "rule__Assignment__Alternatives_0"
    // InternalPerl.g:656:1: rule__Assignment__Alternatives_0 : ( ( 'my' ) | ( 'our' ) | ( 'local' ) );
    public final void rule__Assignment__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:660:1: ( ( 'my' ) | ( 'our' ) | ( 'local' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt3=1;
                }
                break;
            case 16:
                {
                alt3=2;
                }
                break;
            case 17:
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
                    // InternalPerl.g:661:2: ( 'my' )
                    {
                    // InternalPerl.g:661:2: ( 'my' )
                    // InternalPerl.g:662:3: 'my'
                    {
                     before(grammarAccess.getAssignmentAccess().getMyKeyword_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getMyKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:667:2: ( 'our' )
                    {
                    // InternalPerl.g:667:2: ( 'our' )
                    // InternalPerl.g:668:3: 'our'
                    {
                     before(grammarAccess.getAssignmentAccess().getOurKeyword_0_1()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOurKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:673:2: ( 'local' )
                    {
                    // InternalPerl.g:673:2: ( 'local' )
                    // InternalPerl.g:674:3: 'local'
                    {
                     before(grammarAccess.getAssignmentAccess().getLocalKeyword_0_2()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getLocalKeyword_0_2()); 

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
    // $ANTLR end "rule__Assignment__Alternatives_0"


    // $ANTLR start "rule__Assignment__OpAlternatives_2_0"
    // InternalPerl.g:683:1: rule__Assignment__OpAlternatives_2_0 : ( ( ruleOpSingleAssign ) | ( ruleOpMultiAssign ) );
    public final void rule__Assignment__OpAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:687:1: ( ( ruleOpSingleAssign ) | ( ruleOpMultiAssign ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=18 && LA4_0<=23)||(LA4_0>=30 && LA4_0<=31)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalPerl.g:688:2: ( ruleOpSingleAssign )
                    {
                    // InternalPerl.g:688:2: ( ruleOpSingleAssign )
                    // InternalPerl.g:689:3: ruleOpSingleAssign
                    {
                     before(grammarAccess.getAssignmentAccess().getOpOpSingleAssignParserRuleCall_2_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleOpSingleAssign();

                    state._fsp--;

                     after(grammarAccess.getAssignmentAccess().getOpOpSingleAssignParserRuleCall_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:694:2: ( ruleOpMultiAssign )
                    {
                    // InternalPerl.g:694:2: ( ruleOpMultiAssign )
                    // InternalPerl.g:695:3: ruleOpMultiAssign
                    {
                     before(grammarAccess.getAssignmentAccess().getOpOpMultiAssignParserRuleCall_2_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleOpMultiAssign();

                    state._fsp--;

                     after(grammarAccess.getAssignmentAccess().getOpOpMultiAssignParserRuleCall_2_0_1()); 

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
    // $ANTLR end "rule__Assignment__OpAlternatives_2_0"


    // $ANTLR start "rule__OpMultiAssign__Alternatives"
    // InternalPerl.g:704:1: rule__OpMultiAssign__Alternatives : ( ( '+=' ) | ( '-=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '**=' ) | ( ( rule__OpMultiAssign__Group_6__0 ) ) | ( ( rule__OpMultiAssign__Group_7__0 ) ) );
    public final void rule__OpMultiAssign__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:708:1: ( ( '+=' ) | ( '-=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '**=' ) | ( ( rule__OpMultiAssign__Group_6__0 ) ) | ( ( rule__OpMultiAssign__Group_7__0 ) ) )
            int alt5=8;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt5=1;
                }
                break;
            case 19:
                {
                alt5=2;
                }
                break;
            case 20:
                {
                alt5=3;
                }
                break;
            case 21:
                {
                alt5=4;
                }
                break;
            case 22:
                {
                alt5=5;
                }
                break;
            case 23:
                {
                alt5=6;
                }
                break;
            case 31:
                {
                alt5=7;
                }
                break;
            case 30:
                {
                alt5=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalPerl.g:709:2: ( '+=' )
                    {
                    // InternalPerl.g:709:2: ( '+=' )
                    // InternalPerl.g:710:3: '+='
                    {
                     before(grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:715:2: ( '-=' )
                    {
                    // InternalPerl.g:715:2: ( '-=' )
                    // InternalPerl.g:716:3: '-='
                    {
                     before(grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:721:2: ( '*=' )
                    {
                    // InternalPerl.g:721:2: ( '*=' )
                    // InternalPerl.g:722:3: '*='
                    {
                     before(grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:727:2: ( '/=' )
                    {
                    // InternalPerl.g:727:2: ( '/=' )
                    // InternalPerl.g:728:3: '/='
                    {
                     before(grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:733:2: ( '%=' )
                    {
                    // InternalPerl.g:733:2: ( '%=' )
                    // InternalPerl.g:734:3: '%='
                    {
                     before(grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:739:2: ( '**=' )
                    {
                    // InternalPerl.g:739:2: ( '**=' )
                    // InternalPerl.g:740:3: '**='
                    {
                     before(grammarAccess.getOpMultiAssignAccess().getAsteriskAsteriskEqualsSignKeyword_5()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getOpMultiAssignAccess().getAsteriskAsteriskEqualsSignKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:745:2: ( ( rule__OpMultiAssign__Group_6__0 ) )
                    {
                    // InternalPerl.g:745:2: ( ( rule__OpMultiAssign__Group_6__0 ) )
                    // InternalPerl.g:746:3: ( rule__OpMultiAssign__Group_6__0 )
                    {
                     before(grammarAccess.getOpMultiAssignAccess().getGroup_6()); 
                    // InternalPerl.g:747:3: ( rule__OpMultiAssign__Group_6__0 )
                    // InternalPerl.g:747:4: rule__OpMultiAssign__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpMultiAssign__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getOpMultiAssignAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:751:2: ( ( rule__OpMultiAssign__Group_7__0 ) )
                    {
                    // InternalPerl.g:751:2: ( ( rule__OpMultiAssign__Group_7__0 ) )
                    // InternalPerl.g:752:3: ( rule__OpMultiAssign__Group_7__0 )
                    {
                     before(grammarAccess.getOpMultiAssignAccess().getGroup_7()); 
                    // InternalPerl.g:753:3: ( rule__OpMultiAssign__Group_7__0 )
                    // InternalPerl.g:753:4: rule__OpMultiAssign__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpMultiAssign__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getOpMultiAssignAccess().getGroup_7()); 

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
    // $ANTLR end "rule__OpMultiAssign__Alternatives"


    // $ANTLR start "rule__OpEquality__Alternatives"
    // InternalPerl.g:761:1: rule__OpEquality__Alternatives : ( ( '==' ) | ( '!=' ) | ( 'eq' ) | ( 'ne' ) );
    public final void rule__OpEquality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:765:1: ( ( '==' ) | ( '!=' ) | ( 'eq' ) | ( 'ne' ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt6=1;
                }
                break;
            case 25:
                {
                alt6=2;
                }
                break;
            case 26:
                {
                alt6=3;
                }
                break;
            case 27:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalPerl.g:766:2: ( '==' )
                    {
                    // InternalPerl.g:766:2: ( '==' )
                    // InternalPerl.g:767:3: '=='
                    {
                     before(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:772:2: ( '!=' )
                    {
                    // InternalPerl.g:772:2: ( '!=' )
                    // InternalPerl.g:773:3: '!='
                    {
                     before(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:778:2: ( 'eq' )
                    {
                    // InternalPerl.g:778:2: ( 'eq' )
                    // InternalPerl.g:779:3: 'eq'
                    {
                     before(grammarAccess.getOpEqualityAccess().getEqKeyword_2()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getOpEqualityAccess().getEqKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:784:2: ( 'ne' )
                    {
                    // InternalPerl.g:784:2: ( 'ne' )
                    // InternalPerl.g:785:3: 'ne'
                    {
                     before(grammarAccess.getOpEqualityAccess().getNeKeyword_3()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getOpEqualityAccess().getNeKeyword_3()); 

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
    // $ANTLR end "rule__OpEquality__Alternatives"


    // $ANTLR start "rule__Comparison__OpAlternatives_1_1_0"
    // InternalPerl.g:794:1: rule__Comparison__OpAlternatives_1_1_0 : ( ( '>=' ) | ( '<=' ) | ( '>' ) | ( '<' ) );
    public final void rule__Comparison__OpAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:798:1: ( ( '>=' ) | ( '<=' ) | ( '>' ) | ( '<' ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt7=1;
                }
                break;
            case 29:
                {
                alt7=2;
                }
                break;
            case 30:
                {
                alt7=3;
                }
                break;
            case 31:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalPerl.g:799:2: ( '>=' )
                    {
                    // InternalPerl.g:799:2: ( '>=' )
                    // InternalPerl.g:800:3: '>='
                    {
                     before(grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:805:2: ( '<=' )
                    {
                    // InternalPerl.g:805:2: ( '<=' )
                    // InternalPerl.g:806:3: '<='
                    {
                     before(grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:811:2: ( '>' )
                    {
                    // InternalPerl.g:811:2: ( '>' )
                    // InternalPerl.g:812:3: '>'
                    {
                     before(grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:817:2: ( '<' )
                    {
                    // InternalPerl.g:817:2: ( '<' )
                    // InternalPerl.g:818:3: '<'
                    {
                     before(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3()); 

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
    // $ANTLR end "rule__Comparison__OpAlternatives_1_1_0"


    // $ANTLR start "rule__PlusOrMinus__Alternatives_1_0"
    // InternalPerl.g:827:1: rule__PlusOrMinus__Alternatives_1_0 : ( ( ( rule__PlusOrMinus__Group_1_0_0__0 ) ) | ( ( rule__PlusOrMinus__Group_1_0_1__0 ) ) );
    public final void rule__PlusOrMinus__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:831:1: ( ( ( rule__PlusOrMinus__Group_1_0_0__0 ) ) | ( ( rule__PlusOrMinus__Group_1_0_1__0 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==36) ) {
                alt8=1;
            }
            else if ( (LA8_0==37) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalPerl.g:832:2: ( ( rule__PlusOrMinus__Group_1_0_0__0 ) )
                    {
                    // InternalPerl.g:832:2: ( ( rule__PlusOrMinus__Group_1_0_0__0 ) )
                    // InternalPerl.g:833:3: ( rule__PlusOrMinus__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_0()); 
                    // InternalPerl.g:834:3: ( rule__PlusOrMinus__Group_1_0_0__0 )
                    // InternalPerl.g:834:4: rule__PlusOrMinus__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PlusOrMinus__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:838:2: ( ( rule__PlusOrMinus__Group_1_0_1__0 ) )
                    {
                    // InternalPerl.g:838:2: ( ( rule__PlusOrMinus__Group_1_0_1__0 ) )
                    // InternalPerl.g:839:3: ( rule__PlusOrMinus__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_1()); 
                    // InternalPerl.g:840:3: ( rule__PlusOrMinus__Group_1_0_1__0 )
                    // InternalPerl.g:840:4: rule__PlusOrMinus__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PlusOrMinus__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_1()); 

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
    // $ANTLR end "rule__PlusOrMinus__Alternatives_1_0"


    // $ANTLR start "rule__OpMulOrDiv__Alternatives"
    // InternalPerl.g:848:1: rule__OpMulOrDiv__Alternatives : ( ( '*' ) | ( '**' ) | ( '/' ) | ( '%' ) );
    public final void rule__OpMulOrDiv__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:852:1: ( ( '*' ) | ( '**' ) | ( '/' ) | ( '%' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt9=1;
                }
                break;
            case 33:
                {
                alt9=2;
                }
                break;
            case 34:
                {
                alt9=3;
                }
                break;
            case 35:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalPerl.g:853:2: ( '*' )
                    {
                    // InternalPerl.g:853:2: ( '*' )
                    // InternalPerl.g:854:3: '*'
                    {
                     before(grammarAccess.getOpMulOrDivAccess().getAsteriskKeyword_0()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getOpMulOrDivAccess().getAsteriskKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:859:2: ( '**' )
                    {
                    // InternalPerl.g:859:2: ( '**' )
                    // InternalPerl.g:860:3: '**'
                    {
                     before(grammarAccess.getOpMulOrDivAccess().getAsteriskAsteriskKeyword_1()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getOpMulOrDivAccess().getAsteriskAsteriskKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:865:2: ( '/' )
                    {
                    // InternalPerl.g:865:2: ( '/' )
                    // InternalPerl.g:866:3: '/'
                    {
                     before(grammarAccess.getOpMulOrDivAccess().getSolidusKeyword_2()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getOpMulOrDivAccess().getSolidusKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:871:2: ( '%' )
                    {
                    // InternalPerl.g:871:2: ( '%' )
                    // InternalPerl.g:872:3: '%'
                    {
                     before(grammarAccess.getOpMulOrDivAccess().getPercentSignKeyword_3()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getOpMulOrDivAccess().getPercentSignKeyword_3()); 

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
    // $ANTLR end "rule__OpMulOrDiv__Alternatives"


    // $ANTLR start "rule__Primary__Alternatives"
    // InternalPerl.g:881:1: rule__Primary__Alternatives : ( ( ( rule__Primary__Group_0__0 ) ) | ( ( rule__Primary__Group_1__0 ) ) | ( ruleAtomic ) );
    public final void rule__Primary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:885:1: ( ( ( rule__Primary__Group_0__0 ) ) | ( ( rule__Primary__Group_1__0 ) ) | ( ruleAtomic ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt10=1;
                }
                break;
            case 40:
                {
                alt10=2;
                }
                break;
            case RULE_HEX:
            case RULE_BIN:
            case RULE_INT:
            case RULE_ID:
            case RULE_STRING:
            case 41:
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
                    // InternalPerl.g:886:2: ( ( rule__Primary__Group_0__0 ) )
                    {
                    // InternalPerl.g:886:2: ( ( rule__Primary__Group_0__0 ) )
                    // InternalPerl.g:887:3: ( rule__Primary__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getGroup_0()); 
                    // InternalPerl.g:888:3: ( rule__Primary__Group_0__0 )
                    // InternalPerl.g:888:4: rule__Primary__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:892:2: ( ( rule__Primary__Group_1__0 ) )
                    {
                    // InternalPerl.g:892:2: ( ( rule__Primary__Group_1__0 ) )
                    // InternalPerl.g:893:3: ( rule__Primary__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getGroup_1()); 
                    // InternalPerl.g:894:3: ( rule__Primary__Group_1__0 )
                    // InternalPerl.g:894:4: rule__Primary__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:898:2: ( ruleAtomic )
                    {
                    // InternalPerl.g:898:2: ( ruleAtomic )
                    // InternalPerl.g:899:3: ruleAtomic
                    {
                     before(grammarAccess.getPrimaryAccess().getAtomicParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleAtomic();

                    state._fsp--;

                     after(grammarAccess.getPrimaryAccess().getAtomicParserRuleCall_2()); 

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
    // $ANTLR end "rule__Primary__Alternatives"


    // $ANTLR start "rule__Atomic__Alternatives"
    // InternalPerl.g:908:1: rule__Atomic__Alternatives : ( ( ruleNumberLiteral ) | ( ruleNullLiteral ) | ( ruleStringLiteral ) | ( ruleVariableRef ) );
    public final void rule__Atomic__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:912:1: ( ( ruleNumberLiteral ) | ( ruleNullLiteral ) | ( ruleStringLiteral ) | ( ruleVariableRef ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case RULE_HEX:
            case RULE_BIN:
            case RULE_INT:
                {
                alt11=1;
                }
                break;
            case 41:
                {
                alt11=2;
                }
                break;
            case RULE_STRING:
                {
                alt11=3;
                }
                break;
            case RULE_ID:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalPerl.g:913:2: ( ruleNumberLiteral )
                    {
                    // InternalPerl.g:913:2: ( ruleNumberLiteral )
                    // InternalPerl.g:914:3: ruleNumberLiteral
                    {
                     before(grammarAccess.getAtomicAccess().getNumberLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getAtomicAccess().getNumberLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:919:2: ( ruleNullLiteral )
                    {
                    // InternalPerl.g:919:2: ( ruleNullLiteral )
                    // InternalPerl.g:920:3: ruleNullLiteral
                    {
                     before(grammarAccess.getAtomicAccess().getNullLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleNullLiteral();

                    state._fsp--;

                     after(grammarAccess.getAtomicAccess().getNullLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:925:2: ( ruleStringLiteral )
                    {
                    // InternalPerl.g:925:2: ( ruleStringLiteral )
                    // InternalPerl.g:926:3: ruleStringLiteral
                    {
                     before(grammarAccess.getAtomicAccess().getStringLiteralParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleStringLiteral();

                    state._fsp--;

                     after(grammarAccess.getAtomicAccess().getStringLiteralParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:931:2: ( ruleVariableRef )
                    {
                    // InternalPerl.g:931:2: ( ruleVariableRef )
                    // InternalPerl.g:932:3: ruleVariableRef
                    {
                     before(grammarAccess.getAtomicAccess().getVariableRefParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleVariableRef();

                    state._fsp--;

                     after(grammarAccess.getAtomicAccess().getVariableRefParserRuleCall_3()); 

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
    // $ANTLR end "rule__Atomic__Alternatives"


    // $ANTLR start "rule__Number__Alternatives_0"
    // InternalPerl.g:941:1: rule__Number__Alternatives_0 : ( ( RULE_HEX ) | ( RULE_BIN ) | ( RULE_INT ) );
    public final void rule__Number__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:945:1: ( ( RULE_HEX ) | ( RULE_BIN ) | ( RULE_INT ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt12=1;
                }
                break;
            case RULE_BIN:
                {
                alt12=2;
                }
                break;
            case RULE_INT:
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
                    // InternalPerl.g:946:2: ( RULE_HEX )
                    {
                    // InternalPerl.g:946:2: ( RULE_HEX )
                    // InternalPerl.g:947:3: RULE_HEX
                    {
                     before(grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0_0()); 
                    match(input,RULE_HEX,FOLLOW_2); 
                     after(grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:952:2: ( RULE_BIN )
                    {
                    // InternalPerl.g:952:2: ( RULE_BIN )
                    // InternalPerl.g:953:3: RULE_BIN
                    {
                     before(grammarAccess.getNumberAccess().getBINTerminalRuleCall_0_1()); 
                    match(input,RULE_BIN,FOLLOW_2); 
                     after(grammarAccess.getNumberAccess().getBINTerminalRuleCall_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:958:2: ( RULE_INT )
                    {
                    // InternalPerl.g:958:2: ( RULE_INT )
                    // InternalPerl.g:959:3: RULE_INT
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


    // $ANTLR start "rule__Assignment__Group__0"
    // InternalPerl.g:968:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:972:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalPerl.g:973:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Assignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assignment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0"


    // $ANTLR start "rule__Assignment__Group__0__Impl"
    // InternalPerl.g:980:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__Alternatives_0 )? ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:984:1: ( ( ( rule__Assignment__Alternatives_0 )? ) )
            // InternalPerl.g:985:1: ( ( rule__Assignment__Alternatives_0 )? )
            {
            // InternalPerl.g:985:1: ( ( rule__Assignment__Alternatives_0 )? )
            // InternalPerl.g:986:2: ( rule__Assignment__Alternatives_0 )?
            {
             before(grammarAccess.getAssignmentAccess().getAlternatives_0()); 
            // InternalPerl.g:987:2: ( rule__Assignment__Alternatives_0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=15 && LA13_0<=17)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalPerl.g:987:3: rule__Assignment__Alternatives_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Assignment__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssignmentAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0__Impl"


    // $ANTLR start "rule__Assignment__Group__1"
    // InternalPerl.g:995:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:999:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // InternalPerl.g:1000:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Assignment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assignment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1"


    // $ANTLR start "rule__Assignment__Group__1__Impl"
    // InternalPerl.g:1007:1: rule__Assignment__Group__1__Impl : ( ( rule__Assignment__VariableAssignment_1 ) ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1011:1: ( ( ( rule__Assignment__VariableAssignment_1 ) ) )
            // InternalPerl.g:1012:1: ( ( rule__Assignment__VariableAssignment_1 ) )
            {
            // InternalPerl.g:1012:1: ( ( rule__Assignment__VariableAssignment_1 ) )
            // InternalPerl.g:1013:2: ( rule__Assignment__VariableAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getVariableAssignment_1()); 
            // InternalPerl.g:1014:2: ( rule__Assignment__VariableAssignment_1 )
            // InternalPerl.g:1014:3: rule__Assignment__VariableAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__VariableAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getVariableAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__2"
    // InternalPerl.g:1022:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl rule__Assignment__Group__3 ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1026:1: ( rule__Assignment__Group__2__Impl rule__Assignment__Group__3 )
            // InternalPerl.g:1027:2: rule__Assignment__Group__2__Impl rule__Assignment__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Assignment__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assignment__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2"


    // $ANTLR start "rule__Assignment__Group__2__Impl"
    // InternalPerl.g:1034:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__OpAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1038:1: ( ( ( rule__Assignment__OpAssignment_2 ) ) )
            // InternalPerl.g:1039:1: ( ( rule__Assignment__OpAssignment_2 ) )
            {
            // InternalPerl.g:1039:1: ( ( rule__Assignment__OpAssignment_2 ) )
            // InternalPerl.g:1040:2: ( rule__Assignment__OpAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getOpAssignment_2()); 
            // InternalPerl.g:1041:2: ( rule__Assignment__OpAssignment_2 )
            // InternalPerl.g:1041:3: rule__Assignment__OpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__OpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2__Impl"


    // $ANTLR start "rule__Assignment__Group__3"
    // InternalPerl.g:1049:1: rule__Assignment__Group__3 : rule__Assignment__Group__3__Impl ;
    public final void rule__Assignment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1053:1: ( rule__Assignment__Group__3__Impl )
            // InternalPerl.g:1054:2: rule__Assignment__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__3"


    // $ANTLR start "rule__Assignment__Group__3__Impl"
    // InternalPerl.g:1060:1: rule__Assignment__Group__3__Impl : ( ( rule__Assignment__ExpressionAssignment_3 ) ) ;
    public final void rule__Assignment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1064:1: ( ( ( rule__Assignment__ExpressionAssignment_3 ) ) )
            // InternalPerl.g:1065:1: ( ( rule__Assignment__ExpressionAssignment_3 ) )
            {
            // InternalPerl.g:1065:1: ( ( rule__Assignment__ExpressionAssignment_3 ) )
            // InternalPerl.g:1066:2: ( rule__Assignment__ExpressionAssignment_3 )
            {
             before(grammarAccess.getAssignmentAccess().getExpressionAssignment_3()); 
            // InternalPerl.g:1067:2: ( rule__Assignment__ExpressionAssignment_3 )
            // InternalPerl.g:1067:3: rule__Assignment__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__ExpressionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getExpressionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__3__Impl"


    // $ANTLR start "rule__OpMultiAssign__Group_6__0"
    // InternalPerl.g:1076:1: rule__OpMultiAssign__Group_6__0 : rule__OpMultiAssign__Group_6__0__Impl rule__OpMultiAssign__Group_6__1 ;
    public final void rule__OpMultiAssign__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1080:1: ( rule__OpMultiAssign__Group_6__0__Impl rule__OpMultiAssign__Group_6__1 )
            // InternalPerl.g:1081:2: rule__OpMultiAssign__Group_6__0__Impl rule__OpMultiAssign__Group_6__1
            {
            pushFollow(FOLLOW_7);
            rule__OpMultiAssign__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_6__0"


    // $ANTLR start "rule__OpMultiAssign__Group_6__0__Impl"
    // InternalPerl.g:1088:1: rule__OpMultiAssign__Group_6__0__Impl : ( '<' ) ;
    public final void rule__OpMultiAssign__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1092:1: ( ( '<' ) )
            // InternalPerl.g:1093:1: ( '<' )
            {
            // InternalPerl.g:1093:1: ( '<' )
            // InternalPerl.g:1094:2: '<'
            {
             before(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_6__0__Impl"


    // $ANTLR start "rule__OpMultiAssign__Group_6__1"
    // InternalPerl.g:1103:1: rule__OpMultiAssign__Group_6__1 : rule__OpMultiAssign__Group_6__1__Impl rule__OpMultiAssign__Group_6__2 ;
    public final void rule__OpMultiAssign__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1107:1: ( rule__OpMultiAssign__Group_6__1__Impl rule__OpMultiAssign__Group_6__2 )
            // InternalPerl.g:1108:2: rule__OpMultiAssign__Group_6__1__Impl rule__OpMultiAssign__Group_6__2
            {
            pushFollow(FOLLOW_8);
            rule__OpMultiAssign__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_6__1"


    // $ANTLR start "rule__OpMultiAssign__Group_6__1__Impl"
    // InternalPerl.g:1115:1: rule__OpMultiAssign__Group_6__1__Impl : ( '<' ) ;
    public final void rule__OpMultiAssign__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1119:1: ( ( '<' ) )
            // InternalPerl.g:1120:1: ( '<' )
            {
            // InternalPerl.g:1120:1: ( '<' )
            // InternalPerl.g:1121:2: '<'
            {
             before(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_1()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_6__1__Impl"


    // $ANTLR start "rule__OpMultiAssign__Group_6__2"
    // InternalPerl.g:1130:1: rule__OpMultiAssign__Group_6__2 : rule__OpMultiAssign__Group_6__2__Impl ;
    public final void rule__OpMultiAssign__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1134:1: ( rule__OpMultiAssign__Group_6__2__Impl )
            // InternalPerl.g:1135:2: rule__OpMultiAssign__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_6__2"


    // $ANTLR start "rule__OpMultiAssign__Group_6__2__Impl"
    // InternalPerl.g:1141:1: rule__OpMultiAssign__Group_6__2__Impl : ( '=' ) ;
    public final void rule__OpMultiAssign__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1145:1: ( ( '=' ) )
            // InternalPerl.g:1146:1: ( '=' )
            {
            // InternalPerl.g:1146:1: ( '=' )
            // InternalPerl.g:1147:2: '='
            {
             before(grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_6_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_6__2__Impl"


    // $ANTLR start "rule__OpMultiAssign__Group_7__0"
    // InternalPerl.g:1157:1: rule__OpMultiAssign__Group_7__0 : rule__OpMultiAssign__Group_7__0__Impl rule__OpMultiAssign__Group_7__1 ;
    public final void rule__OpMultiAssign__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1161:1: ( rule__OpMultiAssign__Group_7__0__Impl rule__OpMultiAssign__Group_7__1 )
            // InternalPerl.g:1162:2: rule__OpMultiAssign__Group_7__0__Impl rule__OpMultiAssign__Group_7__1
            {
            pushFollow(FOLLOW_9);
            rule__OpMultiAssign__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_7__0"


    // $ANTLR start "rule__OpMultiAssign__Group_7__0__Impl"
    // InternalPerl.g:1169:1: rule__OpMultiAssign__Group_7__0__Impl : ( '>' ) ;
    public final void rule__OpMultiAssign__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1173:1: ( ( '>' ) )
            // InternalPerl.g:1174:1: ( '>' )
            {
            // InternalPerl.g:1174:1: ( '>' )
            // InternalPerl.g:1175:2: '>'
            {
             before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_7__0__Impl"


    // $ANTLR start "rule__OpMultiAssign__Group_7__1"
    // InternalPerl.g:1184:1: rule__OpMultiAssign__Group_7__1 : rule__OpMultiAssign__Group_7__1__Impl rule__OpMultiAssign__Group_7__2 ;
    public final void rule__OpMultiAssign__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1188:1: ( rule__OpMultiAssign__Group_7__1__Impl rule__OpMultiAssign__Group_7__2 )
            // InternalPerl.g:1189:2: rule__OpMultiAssign__Group_7__1__Impl rule__OpMultiAssign__Group_7__2
            {
            pushFollow(FOLLOW_9);
            rule__OpMultiAssign__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_7__1"


    // $ANTLR start "rule__OpMultiAssign__Group_7__1__Impl"
    // InternalPerl.g:1196:1: rule__OpMultiAssign__Group_7__1__Impl : ( ( '>' )? ) ;
    public final void rule__OpMultiAssign__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1200:1: ( ( ( '>' )? ) )
            // InternalPerl.g:1201:1: ( ( '>' )? )
            {
            // InternalPerl.g:1201:1: ( ( '>' )? )
            // InternalPerl.g:1202:2: ( '>' )?
            {
             before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_1()); 
            // InternalPerl.g:1203:2: ( '>' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalPerl.g:1203:3: '>'
                    {
                    match(input,30,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_7__1__Impl"


    // $ANTLR start "rule__OpMultiAssign__Group_7__2"
    // InternalPerl.g:1211:1: rule__OpMultiAssign__Group_7__2 : rule__OpMultiAssign__Group_7__2__Impl ;
    public final void rule__OpMultiAssign__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1215:1: ( rule__OpMultiAssign__Group_7__2__Impl )
            // InternalPerl.g:1216:2: rule__OpMultiAssign__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_7__2"


    // $ANTLR start "rule__OpMultiAssign__Group_7__2__Impl"
    // InternalPerl.g:1222:1: rule__OpMultiAssign__Group_7__2__Impl : ( '>=' ) ;
    public final void rule__OpMultiAssign__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1226:1: ( ( '>=' ) )
            // InternalPerl.g:1227:1: ( '>=' )
            {
            // InternalPerl.g:1227:1: ( '>=' )
            // InternalPerl.g:1228:2: '>='
            {
             before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_7_2()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpMultiAssign__Group_7__2__Impl"


    // $ANTLR start "rule__Or__Group__0"
    // InternalPerl.g:1238:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1242:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalPerl.g:1243:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Or__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0"


    // $ANTLR start "rule__Or__Group__0__Impl"
    // InternalPerl.g:1250:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1254:1: ( ( ruleAnd ) )
            // InternalPerl.g:1255:1: ( ruleAnd )
            {
            // InternalPerl.g:1255:1: ( ruleAnd )
            // InternalPerl.g:1256:2: ruleAnd
            {
             before(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0__Impl"


    // $ANTLR start "rule__Or__Group__1"
    // InternalPerl.g:1265:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1269:1: ( rule__Or__Group__1__Impl )
            // InternalPerl.g:1270:2: rule__Or__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1"


    // $ANTLR start "rule__Or__Group__1__Impl"
    // InternalPerl.g:1276:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1280:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalPerl.g:1281:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalPerl.g:1281:1: ( ( rule__Or__Group_1__0 )* )
            // InternalPerl.g:1282:2: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // InternalPerl.g:1283:2: ( rule__Or__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==13) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPerl.g:1283:3: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Or__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getOrAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1__Impl"


    // $ANTLR start "rule__Or__Group_1__0"
    // InternalPerl.g:1292:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1296:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalPerl.g:1297:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Or__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0"


    // $ANTLR start "rule__Or__Group_1__0__Impl"
    // InternalPerl.g:1304:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1308:1: ( ( () ) )
            // InternalPerl.g:1309:1: ( () )
            {
            // InternalPerl.g:1309:1: ( () )
            // InternalPerl.g:1310:2: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            // InternalPerl.g:1311:2: ()
            // InternalPerl.g:1311:3: 
            {
            }

             after(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0__Impl"


    // $ANTLR start "rule__Or__Group_1__1"
    // InternalPerl.g:1319:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1323:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalPerl.g:1324:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__Or__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1"


    // $ANTLR start "rule__Or__Group_1__1__Impl"
    // InternalPerl.g:1331:1: rule__Or__Group_1__1__Impl : ( ( rule__Or__OpAssignment_1_1 ) ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1335:1: ( ( ( rule__Or__OpAssignment_1_1 ) ) )
            // InternalPerl.g:1336:1: ( ( rule__Or__OpAssignment_1_1 ) )
            {
            // InternalPerl.g:1336:1: ( ( rule__Or__OpAssignment_1_1 ) )
            // InternalPerl.g:1337:2: ( rule__Or__OpAssignment_1_1 )
            {
             before(grammarAccess.getOrAccess().getOpAssignment_1_1()); 
            // InternalPerl.g:1338:2: ( rule__Or__OpAssignment_1_1 )
            // InternalPerl.g:1338:3: rule__Or__OpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Or__OpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getOpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1__Impl"


    // $ANTLR start "rule__Or__Group_1__2"
    // InternalPerl.g:1346:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1350:1: ( rule__Or__Group_1__2__Impl )
            // InternalPerl.g:1351:2: rule__Or__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2"


    // $ANTLR start "rule__Or__Group_1__2__Impl"
    // InternalPerl.g:1357:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1361:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalPerl.g:1362:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalPerl.g:1362:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalPerl.g:1363:2: ( rule__Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            // InternalPerl.g:1364:2: ( rule__Or__RightAssignment_1_2 )
            // InternalPerl.g:1364:3: rule__Or__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Or__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2__Impl"


    // $ANTLR start "rule__And__Group__0"
    // InternalPerl.g:1373:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1377:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalPerl.g:1378:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__And__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0"


    // $ANTLR start "rule__And__Group__0__Impl"
    // InternalPerl.g:1385:1: rule__And__Group__0__Impl : ( ruleEquality ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1389:1: ( ( ruleEquality ) )
            // InternalPerl.g:1390:1: ( ruleEquality )
            {
            // InternalPerl.g:1390:1: ( ruleEquality )
            // InternalPerl.g:1391:2: ruleEquality
            {
             before(grammarAccess.getAndAccess().getEqualityParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleEquality();

            state._fsp--;

             after(grammarAccess.getAndAccess().getEqualityParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0__Impl"


    // $ANTLR start "rule__And__Group__1"
    // InternalPerl.g:1400:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1404:1: ( rule__And__Group__1__Impl )
            // InternalPerl.g:1405:2: rule__And__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1"


    // $ANTLR start "rule__And__Group__1__Impl"
    // InternalPerl.g:1411:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1415:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalPerl.g:1416:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalPerl.g:1416:1: ( ( rule__And__Group_1__0 )* )
            // InternalPerl.g:1417:2: ( rule__And__Group_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalPerl.g:1418:2: ( rule__And__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==14) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPerl.g:1418:3: rule__And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__And__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getAndAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1__Impl"


    // $ANTLR start "rule__And__Group_1__0"
    // InternalPerl.g:1427:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1431:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalPerl.g:1432:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__And__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0"


    // $ANTLR start "rule__And__Group_1__0__Impl"
    // InternalPerl.g:1439:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1443:1: ( ( () ) )
            // InternalPerl.g:1444:1: ( () )
            {
            // InternalPerl.g:1444:1: ( () )
            // InternalPerl.g:1445:2: ()
            {
             before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            // InternalPerl.g:1446:2: ()
            // InternalPerl.g:1446:3: 
            {
            }

             after(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0__Impl"


    // $ANTLR start "rule__And__Group_1__1"
    // InternalPerl.g:1454:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1458:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalPerl.g:1459:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__And__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1"


    // $ANTLR start "rule__And__Group_1__1__Impl"
    // InternalPerl.g:1466:1: rule__And__Group_1__1__Impl : ( ( rule__And__OpAssignment_1_1 ) ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1470:1: ( ( ( rule__And__OpAssignment_1_1 ) ) )
            // InternalPerl.g:1471:1: ( ( rule__And__OpAssignment_1_1 ) )
            {
            // InternalPerl.g:1471:1: ( ( rule__And__OpAssignment_1_1 ) )
            // InternalPerl.g:1472:2: ( rule__And__OpAssignment_1_1 )
            {
             before(grammarAccess.getAndAccess().getOpAssignment_1_1()); 
            // InternalPerl.g:1473:2: ( rule__And__OpAssignment_1_1 )
            // InternalPerl.g:1473:3: rule__And__OpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__And__OpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getOpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1__Impl"


    // $ANTLR start "rule__And__Group_1__2"
    // InternalPerl.g:1481:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1485:1: ( rule__And__Group_1__2__Impl )
            // InternalPerl.g:1486:2: rule__And__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2"


    // $ANTLR start "rule__And__Group_1__2__Impl"
    // InternalPerl.g:1492:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1496:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalPerl.g:1497:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalPerl.g:1497:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalPerl.g:1498:2: ( rule__And__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            // InternalPerl.g:1499:2: ( rule__And__RightAssignment_1_2 )
            // InternalPerl.g:1499:3: rule__And__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__And__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2__Impl"


    // $ANTLR start "rule__Equality__Group__0"
    // InternalPerl.g:1508:1: rule__Equality__Group__0 : rule__Equality__Group__0__Impl rule__Equality__Group__1 ;
    public final void rule__Equality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1512:1: ( rule__Equality__Group__0__Impl rule__Equality__Group__1 )
            // InternalPerl.g:1513:2: rule__Equality__Group__0__Impl rule__Equality__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Equality__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equality__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__0"


    // $ANTLR start "rule__Equality__Group__0__Impl"
    // InternalPerl.g:1520:1: rule__Equality__Group__0__Impl : ( ruleComparison ) ;
    public final void rule__Equality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1524:1: ( ( ruleComparison ) )
            // InternalPerl.g:1525:1: ( ruleComparison )
            {
            // InternalPerl.g:1525:1: ( ruleComparison )
            // InternalPerl.g:1526:2: ruleComparison
            {
             before(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__0__Impl"


    // $ANTLR start "rule__Equality__Group__1"
    // InternalPerl.g:1535:1: rule__Equality__Group__1 : rule__Equality__Group__1__Impl ;
    public final void rule__Equality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1539:1: ( rule__Equality__Group__1__Impl )
            // InternalPerl.g:1540:2: rule__Equality__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__1"


    // $ANTLR start "rule__Equality__Group__1__Impl"
    // InternalPerl.g:1546:1: rule__Equality__Group__1__Impl : ( ( rule__Equality__Group_1__0 )* ) ;
    public final void rule__Equality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1550:1: ( ( ( rule__Equality__Group_1__0 )* ) )
            // InternalPerl.g:1551:1: ( ( rule__Equality__Group_1__0 )* )
            {
            // InternalPerl.g:1551:1: ( ( rule__Equality__Group_1__0 )* )
            // InternalPerl.g:1552:2: ( rule__Equality__Group_1__0 )*
            {
             before(grammarAccess.getEqualityAccess().getGroup_1()); 
            // InternalPerl.g:1553:2: ( rule__Equality__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=24 && LA17_0<=27)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalPerl.g:1553:3: rule__Equality__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Equality__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getEqualityAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__1__Impl"


    // $ANTLR start "rule__Equality__Group_1__0"
    // InternalPerl.g:1562:1: rule__Equality__Group_1__0 : rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 ;
    public final void rule__Equality__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1566:1: ( rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 )
            // InternalPerl.g:1567:2: rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__Equality__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__0"


    // $ANTLR start "rule__Equality__Group_1__0__Impl"
    // InternalPerl.g:1574:1: rule__Equality__Group_1__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1578:1: ( ( () ) )
            // InternalPerl.g:1579:1: ( () )
            {
            // InternalPerl.g:1579:1: ( () )
            // InternalPerl.g:1580:2: ()
            {
             before(grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0()); 
            // InternalPerl.g:1581:2: ()
            // InternalPerl.g:1581:3: 
            {
            }

             after(grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__0__Impl"


    // $ANTLR start "rule__Equality__Group_1__1"
    // InternalPerl.g:1589:1: rule__Equality__Group_1__1 : rule__Equality__Group_1__1__Impl rule__Equality__Group_1__2 ;
    public final void rule__Equality__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1593:1: ( rule__Equality__Group_1__1__Impl rule__Equality__Group_1__2 )
            // InternalPerl.g:1594:2: rule__Equality__Group_1__1__Impl rule__Equality__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__Equality__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__1"


    // $ANTLR start "rule__Equality__Group_1__1__Impl"
    // InternalPerl.g:1601:1: rule__Equality__Group_1__1__Impl : ( ( rule__Equality__OpAssignment_1_1 ) ) ;
    public final void rule__Equality__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1605:1: ( ( ( rule__Equality__OpAssignment_1_1 ) ) )
            // InternalPerl.g:1606:1: ( ( rule__Equality__OpAssignment_1_1 ) )
            {
            // InternalPerl.g:1606:1: ( ( rule__Equality__OpAssignment_1_1 ) )
            // InternalPerl.g:1607:2: ( rule__Equality__OpAssignment_1_1 )
            {
             before(grammarAccess.getEqualityAccess().getOpAssignment_1_1()); 
            // InternalPerl.g:1608:2: ( rule__Equality__OpAssignment_1_1 )
            // InternalPerl.g:1608:3: rule__Equality__OpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Equality__OpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEqualityAccess().getOpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__1__Impl"


    // $ANTLR start "rule__Equality__Group_1__2"
    // InternalPerl.g:1616:1: rule__Equality__Group_1__2 : rule__Equality__Group_1__2__Impl ;
    public final void rule__Equality__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1620:1: ( rule__Equality__Group_1__2__Impl )
            // InternalPerl.g:1621:2: rule__Equality__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__2"


    // $ANTLR start "rule__Equality__Group_1__2__Impl"
    // InternalPerl.g:1627:1: rule__Equality__Group_1__2__Impl : ( ( rule__Equality__RightAssignment_1_2 ) ) ;
    public final void rule__Equality__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1631:1: ( ( ( rule__Equality__RightAssignment_1_2 ) ) )
            // InternalPerl.g:1632:1: ( ( rule__Equality__RightAssignment_1_2 ) )
            {
            // InternalPerl.g:1632:1: ( ( rule__Equality__RightAssignment_1_2 ) )
            // InternalPerl.g:1633:2: ( rule__Equality__RightAssignment_1_2 )
            {
             before(grammarAccess.getEqualityAccess().getRightAssignment_1_2()); 
            // InternalPerl.g:1634:2: ( rule__Equality__RightAssignment_1_2 )
            // InternalPerl.g:1634:3: rule__Equality__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Equality__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getEqualityAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__2__Impl"


    // $ANTLR start "rule__Comparison__Group__0"
    // InternalPerl.g:1643:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1647:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // InternalPerl.g:1648:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Comparison__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Comparison__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0"


    // $ANTLR start "rule__Comparison__Group__0__Impl"
    // InternalPerl.g:1655:1: rule__Comparison__Group__0__Impl : ( rulePlusOrMinus ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1659:1: ( ( rulePlusOrMinus ) )
            // InternalPerl.g:1660:1: ( rulePlusOrMinus )
            {
            // InternalPerl.g:1660:1: ( rulePlusOrMinus )
            // InternalPerl.g:1661:2: rulePlusOrMinus
            {
             before(grammarAccess.getComparisonAccess().getPlusOrMinusParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePlusOrMinus();

            state._fsp--;

             after(grammarAccess.getComparisonAccess().getPlusOrMinusParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0__Impl"


    // $ANTLR start "rule__Comparison__Group__1"
    // InternalPerl.g:1670:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1674:1: ( rule__Comparison__Group__1__Impl )
            // InternalPerl.g:1675:2: rule__Comparison__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1"


    // $ANTLR start "rule__Comparison__Group__1__Impl"
    // InternalPerl.g:1681:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__Group_1__0 )* ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1685:1: ( ( ( rule__Comparison__Group_1__0 )* ) )
            // InternalPerl.g:1686:1: ( ( rule__Comparison__Group_1__0 )* )
            {
            // InternalPerl.g:1686:1: ( ( rule__Comparison__Group_1__0 )* )
            // InternalPerl.g:1687:2: ( rule__Comparison__Group_1__0 )*
            {
             before(grammarAccess.getComparisonAccess().getGroup_1()); 
            // InternalPerl.g:1688:2: ( rule__Comparison__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=28 && LA18_0<=31)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalPerl.g:1688:3: rule__Comparison__Group_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Comparison__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getComparisonAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1__0"
    // InternalPerl.g:1697:1: rule__Comparison__Group_1__0 : rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 ;
    public final void rule__Comparison__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1701:1: ( rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 )
            // InternalPerl.g:1702:2: rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1
            {
            pushFollow(FOLLOW_16);
            rule__Comparison__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__0"


    // $ANTLR start "rule__Comparison__Group_1__0__Impl"
    // InternalPerl.g:1709:1: rule__Comparison__Group_1__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1713:1: ( ( () ) )
            // InternalPerl.g:1714:1: ( () )
            {
            // InternalPerl.g:1714:1: ( () )
            // InternalPerl.g:1715:2: ()
            {
             before(grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0()); 
            // InternalPerl.g:1716:2: ()
            // InternalPerl.g:1716:3: 
            {
            }

             after(grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1__1"
    // InternalPerl.g:1724:1: rule__Comparison__Group_1__1 : rule__Comparison__Group_1__1__Impl rule__Comparison__Group_1__2 ;
    public final void rule__Comparison__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1728:1: ( rule__Comparison__Group_1__1__Impl rule__Comparison__Group_1__2 )
            // InternalPerl.g:1729:2: rule__Comparison__Group_1__1__Impl rule__Comparison__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__Comparison__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__1"


    // $ANTLR start "rule__Comparison__Group_1__1__Impl"
    // InternalPerl.g:1736:1: rule__Comparison__Group_1__1__Impl : ( ( rule__Comparison__OpAssignment_1_1 ) ) ;
    public final void rule__Comparison__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1740:1: ( ( ( rule__Comparison__OpAssignment_1_1 ) ) )
            // InternalPerl.g:1741:1: ( ( rule__Comparison__OpAssignment_1_1 ) )
            {
            // InternalPerl.g:1741:1: ( ( rule__Comparison__OpAssignment_1_1 ) )
            // InternalPerl.g:1742:2: ( rule__Comparison__OpAssignment_1_1 )
            {
             before(grammarAccess.getComparisonAccess().getOpAssignment_1_1()); 
            // InternalPerl.g:1743:2: ( rule__Comparison__OpAssignment_1_1 )
            // InternalPerl.g:1743:3: rule__Comparison__OpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__OpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getOpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1__2"
    // InternalPerl.g:1751:1: rule__Comparison__Group_1__2 : rule__Comparison__Group_1__2__Impl ;
    public final void rule__Comparison__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1755:1: ( rule__Comparison__Group_1__2__Impl )
            // InternalPerl.g:1756:2: rule__Comparison__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__2"


    // $ANTLR start "rule__Comparison__Group_1__2__Impl"
    // InternalPerl.g:1762:1: rule__Comparison__Group_1__2__Impl : ( ( rule__Comparison__RightAssignment_1_2 ) ) ;
    public final void rule__Comparison__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1766:1: ( ( ( rule__Comparison__RightAssignment_1_2 ) ) )
            // InternalPerl.g:1767:1: ( ( rule__Comparison__RightAssignment_1_2 ) )
            {
            // InternalPerl.g:1767:1: ( ( rule__Comparison__RightAssignment_1_2 ) )
            // InternalPerl.g:1768:2: ( rule__Comparison__RightAssignment_1_2 )
            {
             before(grammarAccess.getComparisonAccess().getRightAssignment_1_2()); 
            // InternalPerl.g:1769:2: ( rule__Comparison__RightAssignment_1_2 )
            // InternalPerl.g:1769:3: rule__Comparison__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__2__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group__0"
    // InternalPerl.g:1778:1: rule__PlusOrMinus__Group__0 : rule__PlusOrMinus__Group__0__Impl rule__PlusOrMinus__Group__1 ;
    public final void rule__PlusOrMinus__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1782:1: ( rule__PlusOrMinus__Group__0__Impl rule__PlusOrMinus__Group__1 )
            // InternalPerl.g:1783:2: rule__PlusOrMinus__Group__0__Impl rule__PlusOrMinus__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__PlusOrMinus__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__0"


    // $ANTLR start "rule__PlusOrMinus__Group__0__Impl"
    // InternalPerl.g:1790:1: rule__PlusOrMinus__Group__0__Impl : ( ruleMulOrDiv ) ;
    public final void rule__PlusOrMinus__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1794:1: ( ( ruleMulOrDiv ) )
            // InternalPerl.g:1795:1: ( ruleMulOrDiv )
            {
            // InternalPerl.g:1795:1: ( ruleMulOrDiv )
            // InternalPerl.g:1796:2: ruleMulOrDiv
            {
             before(grammarAccess.getPlusOrMinusAccess().getMulOrDivParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMulOrDiv();

            state._fsp--;

             after(grammarAccess.getPlusOrMinusAccess().getMulOrDivParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group__1"
    // InternalPerl.g:1805:1: rule__PlusOrMinus__Group__1 : rule__PlusOrMinus__Group__1__Impl ;
    public final void rule__PlusOrMinus__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1809:1: ( rule__PlusOrMinus__Group__1__Impl )
            // InternalPerl.g:1810:2: rule__PlusOrMinus__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__1"


    // $ANTLR start "rule__PlusOrMinus__Group__1__Impl"
    // InternalPerl.g:1816:1: rule__PlusOrMinus__Group__1__Impl : ( ( rule__PlusOrMinus__Group_1__0 )* ) ;
    public final void rule__PlusOrMinus__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1820:1: ( ( ( rule__PlusOrMinus__Group_1__0 )* ) )
            // InternalPerl.g:1821:1: ( ( rule__PlusOrMinus__Group_1__0 )* )
            {
            // InternalPerl.g:1821:1: ( ( rule__PlusOrMinus__Group_1__0 )* )
            // InternalPerl.g:1822:2: ( rule__PlusOrMinus__Group_1__0 )*
            {
             before(grammarAccess.getPlusOrMinusAccess().getGroup_1()); 
            // InternalPerl.g:1823:2: ( rule__PlusOrMinus__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=36 && LA19_0<=37)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalPerl.g:1823:3: rule__PlusOrMinus__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__PlusOrMinus__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getPlusOrMinusAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group__1__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1__0"
    // InternalPerl.g:1832:1: rule__PlusOrMinus__Group_1__0 : rule__PlusOrMinus__Group_1__0__Impl rule__PlusOrMinus__Group_1__1 ;
    public final void rule__PlusOrMinus__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1836:1: ( rule__PlusOrMinus__Group_1__0__Impl rule__PlusOrMinus__Group_1__1 )
            // InternalPerl.g:1837:2: rule__PlusOrMinus__Group_1__0__Impl rule__PlusOrMinus__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__PlusOrMinus__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__0"


    // $ANTLR start "rule__PlusOrMinus__Group_1__0__Impl"
    // InternalPerl.g:1844:1: rule__PlusOrMinus__Group_1__0__Impl : ( ( rule__PlusOrMinus__Alternatives_1_0 ) ) ;
    public final void rule__PlusOrMinus__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1848:1: ( ( ( rule__PlusOrMinus__Alternatives_1_0 ) ) )
            // InternalPerl.g:1849:1: ( ( rule__PlusOrMinus__Alternatives_1_0 ) )
            {
            // InternalPerl.g:1849:1: ( ( rule__PlusOrMinus__Alternatives_1_0 ) )
            // InternalPerl.g:1850:2: ( rule__PlusOrMinus__Alternatives_1_0 )
            {
             before(grammarAccess.getPlusOrMinusAccess().getAlternatives_1_0()); 
            // InternalPerl.g:1851:2: ( rule__PlusOrMinus__Alternatives_1_0 )
            // InternalPerl.g:1851:3: rule__PlusOrMinus__Alternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getPlusOrMinusAccess().getAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1__1"
    // InternalPerl.g:1859:1: rule__PlusOrMinus__Group_1__1 : rule__PlusOrMinus__Group_1__1__Impl ;
    public final void rule__PlusOrMinus__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1863:1: ( rule__PlusOrMinus__Group_1__1__Impl )
            // InternalPerl.g:1864:2: rule__PlusOrMinus__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__1"


    // $ANTLR start "rule__PlusOrMinus__Group_1__1__Impl"
    // InternalPerl.g:1870:1: rule__PlusOrMinus__Group_1__1__Impl : ( ( rule__PlusOrMinus__RightAssignment_1_1 ) ) ;
    public final void rule__PlusOrMinus__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1874:1: ( ( ( rule__PlusOrMinus__RightAssignment_1_1 ) ) )
            // InternalPerl.g:1875:1: ( ( rule__PlusOrMinus__RightAssignment_1_1 ) )
            {
            // InternalPerl.g:1875:1: ( ( rule__PlusOrMinus__RightAssignment_1_1 ) )
            // InternalPerl.g:1876:2: ( rule__PlusOrMinus__RightAssignment_1_1 )
            {
             before(grammarAccess.getPlusOrMinusAccess().getRightAssignment_1_1()); 
            // InternalPerl.g:1877:2: ( rule__PlusOrMinus__RightAssignment_1_1 )
            // InternalPerl.g:1877:3: rule__PlusOrMinus__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__RightAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPlusOrMinusAccess().getRightAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1__1__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__0"
    // InternalPerl.g:1886:1: rule__PlusOrMinus__Group_1_0_0__0 : rule__PlusOrMinus__Group_1_0_0__0__Impl rule__PlusOrMinus__Group_1_0_0__1 ;
    public final void rule__PlusOrMinus__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1890:1: ( rule__PlusOrMinus__Group_1_0_0__0__Impl rule__PlusOrMinus__Group_1_0_0__1 )
            // InternalPerl.g:1891:2: rule__PlusOrMinus__Group_1_0_0__0__Impl rule__PlusOrMinus__Group_1_0_0__1
            {
            pushFollow(FOLLOW_20);
            rule__PlusOrMinus__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__0"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__0__Impl"
    // InternalPerl.g:1898:1: rule__PlusOrMinus__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PlusOrMinus__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1902:1: ( ( () ) )
            // InternalPerl.g:1903:1: ( () )
            {
            // InternalPerl.g:1903:1: ( () )
            // InternalPerl.g:1904:2: ()
            {
             before(grammarAccess.getPlusOrMinusAccess().getPlusLeftAction_1_0_0_0()); 
            // InternalPerl.g:1905:2: ()
            // InternalPerl.g:1905:3: 
            {
            }

             after(grammarAccess.getPlusOrMinusAccess().getPlusLeftAction_1_0_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__1"
    // InternalPerl.g:1913:1: rule__PlusOrMinus__Group_1_0_0__1 : rule__PlusOrMinus__Group_1_0_0__1__Impl ;
    public final void rule__PlusOrMinus__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1917:1: ( rule__PlusOrMinus__Group_1_0_0__1__Impl )
            // InternalPerl.g:1918:2: rule__PlusOrMinus__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__1"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_0__1__Impl"
    // InternalPerl.g:1924:1: rule__PlusOrMinus__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__PlusOrMinus__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1928:1: ( ( '+' ) )
            // InternalPerl.g:1929:1: ( '+' )
            {
            // InternalPerl.g:1929:1: ( '+' )
            // InternalPerl.g:1930:2: '+'
            {
             before(grammarAccess.getPlusOrMinusAccess().getPlusSignKeyword_1_0_0_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getPlusOrMinusAccess().getPlusSignKeyword_1_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__0"
    // InternalPerl.g:1940:1: rule__PlusOrMinus__Group_1_0_1__0 : rule__PlusOrMinus__Group_1_0_1__0__Impl rule__PlusOrMinus__Group_1_0_1__1 ;
    public final void rule__PlusOrMinus__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1944:1: ( rule__PlusOrMinus__Group_1_0_1__0__Impl rule__PlusOrMinus__Group_1_0_1__1 )
            // InternalPerl.g:1945:2: rule__PlusOrMinus__Group_1_0_1__0__Impl rule__PlusOrMinus__Group_1_0_1__1
            {
            pushFollow(FOLLOW_18);
            rule__PlusOrMinus__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__0"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__0__Impl"
    // InternalPerl.g:1952:1: rule__PlusOrMinus__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__PlusOrMinus__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1956:1: ( ( () ) )
            // InternalPerl.g:1957:1: ( () )
            {
            // InternalPerl.g:1957:1: ( () )
            // InternalPerl.g:1958:2: ()
            {
             before(grammarAccess.getPlusOrMinusAccess().getMinusLeftAction_1_0_1_0()); 
            // InternalPerl.g:1959:2: ()
            // InternalPerl.g:1959:3: 
            {
            }

             after(grammarAccess.getPlusOrMinusAccess().getMinusLeftAction_1_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__1"
    // InternalPerl.g:1967:1: rule__PlusOrMinus__Group_1_0_1__1 : rule__PlusOrMinus__Group_1_0_1__1__Impl ;
    public final void rule__PlusOrMinus__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1971:1: ( rule__PlusOrMinus__Group_1_0_1__1__Impl )
            // InternalPerl.g:1972:2: rule__PlusOrMinus__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlusOrMinus__Group_1_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__1"


    // $ANTLR start "rule__PlusOrMinus__Group_1_0_1__1__Impl"
    // InternalPerl.g:1978:1: rule__PlusOrMinus__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__PlusOrMinus__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1982:1: ( ( '-' ) )
            // InternalPerl.g:1983:1: ( '-' )
            {
            // InternalPerl.g:1983:1: ( '-' )
            // InternalPerl.g:1984:2: '-'
            {
             before(grammarAccess.getPlusOrMinusAccess().getHyphenMinusKeyword_1_0_1_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getPlusOrMinusAccess().getHyphenMinusKeyword_1_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__MulOrDiv__Group__0"
    // InternalPerl.g:1994:1: rule__MulOrDiv__Group__0 : rule__MulOrDiv__Group__0__Impl rule__MulOrDiv__Group__1 ;
    public final void rule__MulOrDiv__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1998:1: ( rule__MulOrDiv__Group__0__Impl rule__MulOrDiv__Group__1 )
            // InternalPerl.g:1999:2: rule__MulOrDiv__Group__0__Impl rule__MulOrDiv__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__MulOrDiv__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__0"


    // $ANTLR start "rule__MulOrDiv__Group__0__Impl"
    // InternalPerl.g:2006:1: rule__MulOrDiv__Group__0__Impl : ( rulePrimary ) ;
    public final void rule__MulOrDiv__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2010:1: ( ( rulePrimary ) )
            // InternalPerl.g:2011:1: ( rulePrimary )
            {
            // InternalPerl.g:2011:1: ( rulePrimary )
            // InternalPerl.g:2012:2: rulePrimary
            {
             before(grammarAccess.getMulOrDivAccess().getPrimaryParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getMulOrDivAccess().getPrimaryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__0__Impl"


    // $ANTLR start "rule__MulOrDiv__Group__1"
    // InternalPerl.g:2021:1: rule__MulOrDiv__Group__1 : rule__MulOrDiv__Group__1__Impl ;
    public final void rule__MulOrDiv__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2025:1: ( rule__MulOrDiv__Group__1__Impl )
            // InternalPerl.g:2026:2: rule__MulOrDiv__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__1"


    // $ANTLR start "rule__MulOrDiv__Group__1__Impl"
    // InternalPerl.g:2032:1: rule__MulOrDiv__Group__1__Impl : ( ( rule__MulOrDiv__Group_1__0 )* ) ;
    public final void rule__MulOrDiv__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2036:1: ( ( ( rule__MulOrDiv__Group_1__0 )* ) )
            // InternalPerl.g:2037:1: ( ( rule__MulOrDiv__Group_1__0 )* )
            {
            // InternalPerl.g:2037:1: ( ( rule__MulOrDiv__Group_1__0 )* )
            // InternalPerl.g:2038:2: ( rule__MulOrDiv__Group_1__0 )*
            {
             before(grammarAccess.getMulOrDivAccess().getGroup_1()); 
            // InternalPerl.g:2039:2: ( rule__MulOrDiv__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=32 && LA20_0<=35)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalPerl.g:2039:3: rule__MulOrDiv__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__MulOrDiv__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getMulOrDivAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group__1__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1__0"
    // InternalPerl.g:2048:1: rule__MulOrDiv__Group_1__0 : rule__MulOrDiv__Group_1__0__Impl rule__MulOrDiv__Group_1__1 ;
    public final void rule__MulOrDiv__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2052:1: ( rule__MulOrDiv__Group_1__0__Impl rule__MulOrDiv__Group_1__1 )
            // InternalPerl.g:2053:2: rule__MulOrDiv__Group_1__0__Impl rule__MulOrDiv__Group_1__1
            {
            pushFollow(FOLLOW_21);
            rule__MulOrDiv__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__0"


    // $ANTLR start "rule__MulOrDiv__Group_1__0__Impl"
    // InternalPerl.g:2060:1: rule__MulOrDiv__Group_1__0__Impl : ( () ) ;
    public final void rule__MulOrDiv__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2064:1: ( ( () ) )
            // InternalPerl.g:2065:1: ( () )
            {
            // InternalPerl.g:2065:1: ( () )
            // InternalPerl.g:2066:2: ()
            {
             before(grammarAccess.getMulOrDivAccess().getMulOrDivLeftAction_1_0()); 
            // InternalPerl.g:2067:2: ()
            // InternalPerl.g:2067:3: 
            {
            }

             after(grammarAccess.getMulOrDivAccess().getMulOrDivLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__0__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1__1"
    // InternalPerl.g:2075:1: rule__MulOrDiv__Group_1__1 : rule__MulOrDiv__Group_1__1__Impl rule__MulOrDiv__Group_1__2 ;
    public final void rule__MulOrDiv__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2079:1: ( rule__MulOrDiv__Group_1__1__Impl rule__MulOrDiv__Group_1__2 )
            // InternalPerl.g:2080:2: rule__MulOrDiv__Group_1__1__Impl rule__MulOrDiv__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__MulOrDiv__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__1"


    // $ANTLR start "rule__MulOrDiv__Group_1__1__Impl"
    // InternalPerl.g:2087:1: rule__MulOrDiv__Group_1__1__Impl : ( ( rule__MulOrDiv__OpAssignment_1_1 ) ) ;
    public final void rule__MulOrDiv__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2091:1: ( ( ( rule__MulOrDiv__OpAssignment_1_1 ) ) )
            // InternalPerl.g:2092:1: ( ( rule__MulOrDiv__OpAssignment_1_1 ) )
            {
            // InternalPerl.g:2092:1: ( ( rule__MulOrDiv__OpAssignment_1_1 ) )
            // InternalPerl.g:2093:2: ( rule__MulOrDiv__OpAssignment_1_1 )
            {
             before(grammarAccess.getMulOrDivAccess().getOpAssignment_1_1()); 
            // InternalPerl.g:2094:2: ( rule__MulOrDiv__OpAssignment_1_1 )
            // InternalPerl.g:2094:3: rule__MulOrDiv__OpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__OpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMulOrDivAccess().getOpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__1__Impl"


    // $ANTLR start "rule__MulOrDiv__Group_1__2"
    // InternalPerl.g:2102:1: rule__MulOrDiv__Group_1__2 : rule__MulOrDiv__Group_1__2__Impl ;
    public final void rule__MulOrDiv__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2106:1: ( rule__MulOrDiv__Group_1__2__Impl )
            // InternalPerl.g:2107:2: rule__MulOrDiv__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__2"


    // $ANTLR start "rule__MulOrDiv__Group_1__2__Impl"
    // InternalPerl.g:2113:1: rule__MulOrDiv__Group_1__2__Impl : ( ( rule__MulOrDiv__RightAssignment_1_2 ) ) ;
    public final void rule__MulOrDiv__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2117:1: ( ( ( rule__MulOrDiv__RightAssignment_1_2 ) ) )
            // InternalPerl.g:2118:1: ( ( rule__MulOrDiv__RightAssignment_1_2 ) )
            {
            // InternalPerl.g:2118:1: ( ( rule__MulOrDiv__RightAssignment_1_2 ) )
            // InternalPerl.g:2119:2: ( rule__MulOrDiv__RightAssignment_1_2 )
            {
             before(grammarAccess.getMulOrDivAccess().getRightAssignment_1_2()); 
            // InternalPerl.g:2120:2: ( rule__MulOrDiv__RightAssignment_1_2 )
            // InternalPerl.g:2120:3: rule__MulOrDiv__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__MulOrDiv__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getMulOrDivAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__Group_1__2__Impl"


    // $ANTLR start "rule__Primary__Group_0__0"
    // InternalPerl.g:2129:1: rule__Primary__Group_0__0 : rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1 ;
    public final void rule__Primary__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2133:1: ( rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1 )
            // InternalPerl.g:2134:2: rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1
            {
            pushFollow(FOLLOW_6);
            rule__Primary__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__0"


    // $ANTLR start "rule__Primary__Group_0__0__Impl"
    // InternalPerl.g:2141:1: rule__Primary__Group_0__0__Impl : ( '(' ) ;
    public final void rule__Primary__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2145:1: ( ( '(' ) )
            // InternalPerl.g:2146:1: ( '(' )
            {
            // InternalPerl.g:2146:1: ( '(' )
            // InternalPerl.g:2147:2: '('
            {
             before(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__0__Impl"


    // $ANTLR start "rule__Primary__Group_0__1"
    // InternalPerl.g:2156:1: rule__Primary__Group_0__1 : rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2 ;
    public final void rule__Primary__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2160:1: ( rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2 )
            // InternalPerl.g:2161:2: rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2
            {
            pushFollow(FOLLOW_23);
            rule__Primary__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__1"


    // $ANTLR start "rule__Primary__Group_0__1__Impl"
    // InternalPerl.g:2168:1: rule__Primary__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__Primary__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2172:1: ( ( ruleExpression ) )
            // InternalPerl.g:2173:1: ( ruleExpression )
            {
            // InternalPerl.g:2173:1: ( ruleExpression )
            // InternalPerl.g:2174:2: ruleExpression
            {
             before(grammarAccess.getPrimaryAccess().getExpressionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getExpressionParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__1__Impl"


    // $ANTLR start "rule__Primary__Group_0__2"
    // InternalPerl.g:2183:1: rule__Primary__Group_0__2 : rule__Primary__Group_0__2__Impl ;
    public final void rule__Primary__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2187:1: ( rule__Primary__Group_0__2__Impl )
            // InternalPerl.g:2188:2: rule__Primary__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__2"


    // $ANTLR start "rule__Primary__Group_0__2__Impl"
    // InternalPerl.g:2194:1: rule__Primary__Group_0__2__Impl : ( ')' ) ;
    public final void rule__Primary__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2198:1: ( ( ')' ) )
            // InternalPerl.g:2199:1: ( ')' )
            {
            // InternalPerl.g:2199:1: ( ')' )
            // InternalPerl.g:2200:2: ')'
            {
             before(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__2__Impl"


    // $ANTLR start "rule__Primary__Group_1__0"
    // InternalPerl.g:2210:1: rule__Primary__Group_1__0 : rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1 ;
    public final void rule__Primary__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2214:1: ( rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1 )
            // InternalPerl.g:2215:2: rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__Primary__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__0"


    // $ANTLR start "rule__Primary__Group_1__0__Impl"
    // InternalPerl.g:2222:1: rule__Primary__Group_1__0__Impl : ( () ) ;
    public final void rule__Primary__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2226:1: ( ( () ) )
            // InternalPerl.g:2227:1: ( () )
            {
            // InternalPerl.g:2227:1: ( () )
            // InternalPerl.g:2228:2: ()
            {
             before(grammarAccess.getPrimaryAccess().getNotAction_1_0()); 
            // InternalPerl.g:2229:2: ()
            // InternalPerl.g:2229:3: 
            {
            }

             after(grammarAccess.getPrimaryAccess().getNotAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__0__Impl"


    // $ANTLR start "rule__Primary__Group_1__1"
    // InternalPerl.g:2237:1: rule__Primary__Group_1__1 : rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2 ;
    public final void rule__Primary__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2241:1: ( rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2 )
            // InternalPerl.g:2242:2: rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2
            {
            pushFollow(FOLLOW_6);
            rule__Primary__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__1"


    // $ANTLR start "rule__Primary__Group_1__1__Impl"
    // InternalPerl.g:2249:1: rule__Primary__Group_1__1__Impl : ( '!' ) ;
    public final void rule__Primary__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2253:1: ( ( '!' ) )
            // InternalPerl.g:2254:1: ( '!' )
            {
            // InternalPerl.g:2254:1: ( '!' )
            // InternalPerl.g:2255:2: '!'
            {
             before(grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_1_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__1__Impl"


    // $ANTLR start "rule__Primary__Group_1__2"
    // InternalPerl.g:2264:1: rule__Primary__Group_1__2 : rule__Primary__Group_1__2__Impl ;
    public final void rule__Primary__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2268:1: ( rule__Primary__Group_1__2__Impl )
            // InternalPerl.g:2269:2: rule__Primary__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__2"


    // $ANTLR start "rule__Primary__Group_1__2__Impl"
    // InternalPerl.g:2275:1: rule__Primary__Group_1__2__Impl : ( ( rule__Primary__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Primary__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2279:1: ( ( ( rule__Primary__ExpressionAssignment_1_2 ) ) )
            // InternalPerl.g:2280:1: ( ( rule__Primary__ExpressionAssignment_1_2 ) )
            {
            // InternalPerl.g:2280:1: ( ( rule__Primary__ExpressionAssignment_1_2 ) )
            // InternalPerl.g:2281:2: ( rule__Primary__ExpressionAssignment_1_2 )
            {
             before(grammarAccess.getPrimaryAccess().getExpressionAssignment_1_2()); 
            // InternalPerl.g:2282:2: ( rule__Primary__ExpressionAssignment_1_2 )
            // InternalPerl.g:2282:3: rule__Primary__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Primary__ExpressionAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryAccess().getExpressionAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__2__Impl"


    // $ANTLR start "rule__NumberLiteral__Group__0"
    // InternalPerl.g:2291:1: rule__NumberLiteral__Group__0 : rule__NumberLiteral__Group__0__Impl rule__NumberLiteral__Group__1 ;
    public final void rule__NumberLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2295:1: ( rule__NumberLiteral__Group__0__Impl rule__NumberLiteral__Group__1 )
            // InternalPerl.g:2296:2: rule__NumberLiteral__Group__0__Impl rule__NumberLiteral__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__NumberLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NumberLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteral__Group__0"


    // $ANTLR start "rule__NumberLiteral__Group__0__Impl"
    // InternalPerl.g:2303:1: rule__NumberLiteral__Group__0__Impl : ( () ) ;
    public final void rule__NumberLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2307:1: ( ( () ) )
            // InternalPerl.g:2308:1: ( () )
            {
            // InternalPerl.g:2308:1: ( () )
            // InternalPerl.g:2309:2: ()
            {
             before(grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0()); 
            // InternalPerl.g:2310:2: ()
            // InternalPerl.g:2310:3: 
            {
            }

             after(grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteral__Group__0__Impl"


    // $ANTLR start "rule__NumberLiteral__Group__1"
    // InternalPerl.g:2318:1: rule__NumberLiteral__Group__1 : rule__NumberLiteral__Group__1__Impl ;
    public final void rule__NumberLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2322:1: ( rule__NumberLiteral__Group__1__Impl )
            // InternalPerl.g:2323:2: rule__NumberLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NumberLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteral__Group__1"


    // $ANTLR start "rule__NumberLiteral__Group__1__Impl"
    // InternalPerl.g:2329:1: rule__NumberLiteral__Group__1__Impl : ( ( rule__NumberLiteral__ValueAssignment_1 ) ) ;
    public final void rule__NumberLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2333:1: ( ( ( rule__NumberLiteral__ValueAssignment_1 ) ) )
            // InternalPerl.g:2334:1: ( ( rule__NumberLiteral__ValueAssignment_1 ) )
            {
            // InternalPerl.g:2334:1: ( ( rule__NumberLiteral__ValueAssignment_1 ) )
            // InternalPerl.g:2335:2: ( rule__NumberLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getNumberLiteralAccess().getValueAssignment_1()); 
            // InternalPerl.g:2336:2: ( rule__NumberLiteral__ValueAssignment_1 )
            // InternalPerl.g:2336:3: rule__NumberLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__NumberLiteral__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNumberLiteralAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteral__Group__1__Impl"


    // $ANTLR start "rule__NullLiteral__Group__0"
    // InternalPerl.g:2345:1: rule__NullLiteral__Group__0 : rule__NullLiteral__Group__0__Impl rule__NullLiteral__Group__1 ;
    public final void rule__NullLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2349:1: ( rule__NullLiteral__Group__0__Impl rule__NullLiteral__Group__1 )
            // InternalPerl.g:2350:2: rule__NullLiteral__Group__0__Impl rule__NullLiteral__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__NullLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NullLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullLiteral__Group__0"


    // $ANTLR start "rule__NullLiteral__Group__0__Impl"
    // InternalPerl.g:2357:1: rule__NullLiteral__Group__0__Impl : ( () ) ;
    public final void rule__NullLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2361:1: ( ( () ) )
            // InternalPerl.g:2362:1: ( () )
            {
            // InternalPerl.g:2362:1: ( () )
            // InternalPerl.g:2363:2: ()
            {
             before(grammarAccess.getNullLiteralAccess().getNullLiteralAction_0()); 
            // InternalPerl.g:2364:2: ()
            // InternalPerl.g:2364:3: 
            {
            }

             after(grammarAccess.getNullLiteralAccess().getNullLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullLiteral__Group__0__Impl"


    // $ANTLR start "rule__NullLiteral__Group__1"
    // InternalPerl.g:2372:1: rule__NullLiteral__Group__1 : rule__NullLiteral__Group__1__Impl ;
    public final void rule__NullLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2376:1: ( rule__NullLiteral__Group__1__Impl )
            // InternalPerl.g:2377:2: rule__NullLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NullLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullLiteral__Group__1"


    // $ANTLR start "rule__NullLiteral__Group__1__Impl"
    // InternalPerl.g:2383:1: rule__NullLiteral__Group__1__Impl : ( 'undef' ) ;
    public final void rule__NullLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2387:1: ( ( 'undef' ) )
            // InternalPerl.g:2388:1: ( 'undef' )
            {
            // InternalPerl.g:2388:1: ( 'undef' )
            // InternalPerl.g:2389:2: 'undef'
            {
             before(grammarAccess.getNullLiteralAccess().getUndefKeyword_1()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getNullLiteralAccess().getUndefKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullLiteral__Group__1__Impl"


    // $ANTLR start "rule__StringLiteral__Group__0"
    // InternalPerl.g:2399:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2403:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // InternalPerl.g:2404:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StringLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__0"


    // $ANTLR start "rule__StringLiteral__Group__0__Impl"
    // InternalPerl.g:2411:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2415:1: ( ( () ) )
            // InternalPerl.g:2416:1: ( () )
            {
            // InternalPerl.g:2416:1: ( () )
            // InternalPerl.g:2417:2: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // InternalPerl.g:2418:2: ()
            // InternalPerl.g:2418:3: 
            {
            }

             after(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__0__Impl"


    // $ANTLR start "rule__StringLiteral__Group__1"
    // InternalPerl.g:2426:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2430:1: ( rule__StringLiteral__Group__1__Impl )
            // InternalPerl.g:2431:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__1"


    // $ANTLR start "rule__StringLiteral__Group__1__Impl"
    // InternalPerl.g:2437:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2441:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // InternalPerl.g:2442:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // InternalPerl.g:2442:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // InternalPerl.g:2443:2: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // InternalPerl.g:2444:2: ( rule__StringLiteral__ValueAssignment_1 )
            // InternalPerl.g:2444:3: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteral__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__1__Impl"


    // $ANTLR start "rule__Number__Group__0"
    // InternalPerl.g:2453:1: rule__Number__Group__0 : rule__Number__Group__0__Impl rule__Number__Group__1 ;
    public final void rule__Number__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2457:1: ( rule__Number__Group__0__Impl rule__Number__Group__1 )
            // InternalPerl.g:2458:2: rule__Number__Group__0__Impl rule__Number__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalPerl.g:2465:1: rule__Number__Group__0__Impl : ( ( rule__Number__Alternatives_0 ) ) ;
    public final void rule__Number__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2469:1: ( ( ( rule__Number__Alternatives_0 ) ) )
            // InternalPerl.g:2470:1: ( ( rule__Number__Alternatives_0 ) )
            {
            // InternalPerl.g:2470:1: ( ( rule__Number__Alternatives_0 ) )
            // InternalPerl.g:2471:2: ( rule__Number__Alternatives_0 )
            {
             before(grammarAccess.getNumberAccess().getAlternatives_0()); 
            // InternalPerl.g:2472:2: ( rule__Number__Alternatives_0 )
            // InternalPerl.g:2472:3: rule__Number__Alternatives_0
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
    // InternalPerl.g:2480:1: rule__Number__Group__1 : rule__Number__Group__1__Impl ;
    public final void rule__Number__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2484:1: ( rule__Number__Group__1__Impl )
            // InternalPerl.g:2485:2: rule__Number__Group__1__Impl
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
    // InternalPerl.g:2491:1: rule__Number__Group__1__Impl : ( ( rule__Number__Group_1__0 )? ) ;
    public final void rule__Number__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2495:1: ( ( ( rule__Number__Group_1__0 )? ) )
            // InternalPerl.g:2496:1: ( ( rule__Number__Group_1__0 )? )
            {
            // InternalPerl.g:2496:1: ( ( rule__Number__Group_1__0 )? )
            // InternalPerl.g:2497:2: ( rule__Number__Group_1__0 )?
            {
             before(grammarAccess.getNumberAccess().getGroup_1()); 
            // InternalPerl.g:2498:2: ( rule__Number__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==42) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalPerl.g:2498:3: rule__Number__Group_1__0
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
    // InternalPerl.g:2507:1: rule__Number__Group_1__0 : rule__Number__Group_1__0__Impl rule__Number__Group_1__1 ;
    public final void rule__Number__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2511:1: ( rule__Number__Group_1__0__Impl rule__Number__Group_1__1 )
            // InternalPerl.g:2512:2: rule__Number__Group_1__0__Impl rule__Number__Group_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalPerl.g:2519:1: rule__Number__Group_1__0__Impl : ( '.' ) ;
    public final void rule__Number__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2523:1: ( ( '.' ) )
            // InternalPerl.g:2524:1: ( '.' )
            {
            // InternalPerl.g:2524:1: ( '.' )
            // InternalPerl.g:2525:2: '.'
            {
             before(grammarAccess.getNumberAccess().getFullStopKeyword_1_0()); 
            match(input,42,FOLLOW_2); 
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
    // InternalPerl.g:2534:1: rule__Number__Group_1__1 : rule__Number__Group_1__1__Impl ;
    public final void rule__Number__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2538:1: ( rule__Number__Group_1__1__Impl )
            // InternalPerl.g:2539:2: rule__Number__Group_1__1__Impl
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
    // InternalPerl.g:2545:1: rule__Number__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Number__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2549:1: ( ( RULE_INT ) )
            // InternalPerl.g:2550:1: ( RULE_INT )
            {
            // InternalPerl.g:2550:1: ( RULE_INT )
            // InternalPerl.g:2551:2: RULE_INT
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


    // $ANTLR start "rule__PerlModel__ElementsAssignment"
    // InternalPerl.g:2561:1: rule__PerlModel__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__PerlModel__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2565:1: ( ( ruleAbstractElement ) )
            // InternalPerl.g:2566:2: ( ruleAbstractElement )
            {
            // InternalPerl.g:2566:2: ( ruleAbstractElement )
            // InternalPerl.g:2567:3: ruleAbstractElement
            {
             before(grammarAccess.getPerlModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getPerlModelAccess().getElementsAbstractElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PerlModel__ElementsAssignment"


    // $ANTLR start "rule__Assignment__VariableAssignment_1"
    // InternalPerl.g:2576:1: rule__Assignment__VariableAssignment_1 : ( RULE_ID ) ;
    public final void rule__Assignment__VariableAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2580:1: ( ( RULE_ID ) )
            // InternalPerl.g:2581:2: ( RULE_ID )
            {
            // InternalPerl.g:2581:2: ( RULE_ID )
            // InternalPerl.g:2582:3: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getVariableIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAssignmentAccess().getVariableIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__VariableAssignment_1"


    // $ANTLR start "rule__Assignment__OpAssignment_2"
    // InternalPerl.g:2591:1: rule__Assignment__OpAssignment_2 : ( ( rule__Assignment__OpAlternatives_2_0 ) ) ;
    public final void rule__Assignment__OpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2595:1: ( ( ( rule__Assignment__OpAlternatives_2_0 ) ) )
            // InternalPerl.g:2596:2: ( ( rule__Assignment__OpAlternatives_2_0 ) )
            {
            // InternalPerl.g:2596:2: ( ( rule__Assignment__OpAlternatives_2_0 ) )
            // InternalPerl.g:2597:3: ( rule__Assignment__OpAlternatives_2_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOpAlternatives_2_0()); 
            // InternalPerl.g:2598:3: ( rule__Assignment__OpAlternatives_2_0 )
            // InternalPerl.g:2598:4: rule__Assignment__OpAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__OpAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOpAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__OpAssignment_2"


    // $ANTLR start "rule__Assignment__ExpressionAssignment_3"
    // InternalPerl.g:2606:1: rule__Assignment__ExpressionAssignment_3 : ( ruleExpression ) ;
    public final void rule__Assignment__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2610:1: ( ( ruleExpression ) )
            // InternalPerl.g:2611:2: ( ruleExpression )
            {
            // InternalPerl.g:2611:2: ( ruleExpression )
            // InternalPerl.g:2612:3: ruleExpression
            {
             before(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__ExpressionAssignment_3"


    // $ANTLR start "rule__Or__OpAssignment_1_1"
    // InternalPerl.g:2621:1: rule__Or__OpAssignment_1_1 : ( ruleOpOr ) ;
    public final void rule__Or__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2625:1: ( ( ruleOpOr ) )
            // InternalPerl.g:2626:2: ( ruleOpOr )
            {
            // InternalPerl.g:2626:2: ( ruleOpOr )
            // InternalPerl.g:2627:3: ruleOpOr
            {
             before(grammarAccess.getOrAccess().getOpOpOrParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOpOr();

            state._fsp--;

             after(grammarAccess.getOrAccess().getOpOpOrParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__OpAssignment_1_1"


    // $ANTLR start "rule__Or__RightAssignment_1_2"
    // InternalPerl.g:2636:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2640:1: ( ( ruleAnd ) )
            // InternalPerl.g:2641:2: ( ruleAnd )
            {
            // InternalPerl.g:2641:2: ( ruleAnd )
            // InternalPerl.g:2642:3: ruleAnd
            {
             before(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__RightAssignment_1_2"


    // $ANTLR start "rule__And__OpAssignment_1_1"
    // InternalPerl.g:2651:1: rule__And__OpAssignment_1_1 : ( ruleOpAnd ) ;
    public final void rule__And__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2655:1: ( ( ruleOpAnd ) )
            // InternalPerl.g:2656:2: ( ruleOpAnd )
            {
            // InternalPerl.g:2656:2: ( ruleOpAnd )
            // InternalPerl.g:2657:3: ruleOpAnd
            {
             before(grammarAccess.getAndAccess().getOpOpAndParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOpAnd();

            state._fsp--;

             after(grammarAccess.getAndAccess().getOpOpAndParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__OpAssignment_1_1"


    // $ANTLR start "rule__And__RightAssignment_1_2"
    // InternalPerl.g:2666:1: rule__And__RightAssignment_1_2 : ( ruleEquality ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2670:1: ( ( ruleEquality ) )
            // InternalPerl.g:2671:2: ( ruleEquality )
            {
            // InternalPerl.g:2671:2: ( ruleEquality )
            // InternalPerl.g:2672:3: ruleEquality
            {
             before(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEquality();

            state._fsp--;

             after(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__RightAssignment_1_2"


    // $ANTLR start "rule__Equality__OpAssignment_1_1"
    // InternalPerl.g:2681:1: rule__Equality__OpAssignment_1_1 : ( ruleOpEquality ) ;
    public final void rule__Equality__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2685:1: ( ( ruleOpEquality ) )
            // InternalPerl.g:2686:2: ( ruleOpEquality )
            {
            // InternalPerl.g:2686:2: ( ruleOpEquality )
            // InternalPerl.g:2687:3: ruleOpEquality
            {
             before(grammarAccess.getEqualityAccess().getOpOpEqualityParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOpEquality();

            state._fsp--;

             after(grammarAccess.getEqualityAccess().getOpOpEqualityParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__OpAssignment_1_1"


    // $ANTLR start "rule__Equality__RightAssignment_1_2"
    // InternalPerl.g:2696:1: rule__Equality__RightAssignment_1_2 : ( ruleComparison ) ;
    public final void rule__Equality__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2700:1: ( ( ruleComparison ) )
            // InternalPerl.g:2701:2: ( ruleComparison )
            {
            // InternalPerl.g:2701:2: ( ruleComparison )
            // InternalPerl.g:2702:3: ruleComparison
            {
             before(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__RightAssignment_1_2"


    // $ANTLR start "rule__Comparison__OpAssignment_1_1"
    // InternalPerl.g:2711:1: rule__Comparison__OpAssignment_1_1 : ( ( rule__Comparison__OpAlternatives_1_1_0 ) ) ;
    public final void rule__Comparison__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2715:1: ( ( ( rule__Comparison__OpAlternatives_1_1_0 ) ) )
            // InternalPerl.g:2716:2: ( ( rule__Comparison__OpAlternatives_1_1_0 ) )
            {
            // InternalPerl.g:2716:2: ( ( rule__Comparison__OpAlternatives_1_1_0 ) )
            // InternalPerl.g:2717:3: ( rule__Comparison__OpAlternatives_1_1_0 )
            {
             before(grammarAccess.getComparisonAccess().getOpAlternatives_1_1_0()); 
            // InternalPerl.g:2718:3: ( rule__Comparison__OpAlternatives_1_1_0 )
            // InternalPerl.g:2718:4: rule__Comparison__OpAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__OpAlternatives_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getOpAlternatives_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__OpAssignment_1_1"


    // $ANTLR start "rule__Comparison__RightAssignment_1_2"
    // InternalPerl.g:2726:1: rule__Comparison__RightAssignment_1_2 : ( rulePlusOrMinus ) ;
    public final void rule__Comparison__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2730:1: ( ( rulePlusOrMinus ) )
            // InternalPerl.g:2731:2: ( rulePlusOrMinus )
            {
            // InternalPerl.g:2731:2: ( rulePlusOrMinus )
            // InternalPerl.g:2732:3: rulePlusOrMinus
            {
             before(grammarAccess.getComparisonAccess().getRightPlusOrMinusParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePlusOrMinus();

            state._fsp--;

             after(grammarAccess.getComparisonAccess().getRightPlusOrMinusParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__RightAssignment_1_2"


    // $ANTLR start "rule__PlusOrMinus__RightAssignment_1_1"
    // InternalPerl.g:2741:1: rule__PlusOrMinus__RightAssignment_1_1 : ( ruleMulOrDiv ) ;
    public final void rule__PlusOrMinus__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2745:1: ( ( ruleMulOrDiv ) )
            // InternalPerl.g:2746:2: ( ruleMulOrDiv )
            {
            // InternalPerl.g:2746:2: ( ruleMulOrDiv )
            // InternalPerl.g:2747:3: ruleMulOrDiv
            {
             before(grammarAccess.getPlusOrMinusAccess().getRightMulOrDivParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMulOrDiv();

            state._fsp--;

             after(grammarAccess.getPlusOrMinusAccess().getRightMulOrDivParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlusOrMinus__RightAssignment_1_1"


    // $ANTLR start "rule__MulOrDiv__OpAssignment_1_1"
    // InternalPerl.g:2756:1: rule__MulOrDiv__OpAssignment_1_1 : ( ruleOpMulOrDiv ) ;
    public final void rule__MulOrDiv__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2760:1: ( ( ruleOpMulOrDiv ) )
            // InternalPerl.g:2761:2: ( ruleOpMulOrDiv )
            {
            // InternalPerl.g:2761:2: ( ruleOpMulOrDiv )
            // InternalPerl.g:2762:3: ruleOpMulOrDiv
            {
             before(grammarAccess.getMulOrDivAccess().getOpOpMulOrDivParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOpMulOrDiv();

            state._fsp--;

             after(grammarAccess.getMulOrDivAccess().getOpOpMulOrDivParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__OpAssignment_1_1"


    // $ANTLR start "rule__MulOrDiv__RightAssignment_1_2"
    // InternalPerl.g:2771:1: rule__MulOrDiv__RightAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__MulOrDiv__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2775:1: ( ( rulePrimary ) )
            // InternalPerl.g:2776:2: ( rulePrimary )
            {
            // InternalPerl.g:2776:2: ( rulePrimary )
            // InternalPerl.g:2777:3: rulePrimary
            {
             before(grammarAccess.getMulOrDivAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getMulOrDivAccess().getRightPrimaryParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MulOrDiv__RightAssignment_1_2"


    // $ANTLR start "rule__Primary__ExpressionAssignment_1_2"
    // InternalPerl.g:2786:1: rule__Primary__ExpressionAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__Primary__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2790:1: ( ( rulePrimary ) )
            // InternalPerl.g:2791:2: ( rulePrimary )
            {
            // InternalPerl.g:2791:2: ( rulePrimary )
            // InternalPerl.g:2792:3: rulePrimary
            {
             before(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__ExpressionAssignment_1_2"


    // $ANTLR start "rule__VariableRef__NameAssignment"
    // InternalPerl.g:2801:1: rule__VariableRef__NameAssignment : ( RULE_ID ) ;
    public final void rule__VariableRef__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2805:1: ( ( RULE_ID ) )
            // InternalPerl.g:2806:2: ( RULE_ID )
            {
            // InternalPerl.g:2806:2: ( RULE_ID )
            // InternalPerl.g:2807:3: RULE_ID
            {
             before(grammarAccess.getVariableRefAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableRefAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__NameAssignment"


    // $ANTLR start "rule__NumberLiteral__ValueAssignment_1"
    // InternalPerl.g:2816:1: rule__NumberLiteral__ValueAssignment_1 : ( ruleNumber ) ;
    public final void rule__NumberLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2820:1: ( ( ruleNumber ) )
            // InternalPerl.g:2821:2: ( ruleNumber )
            {
            // InternalPerl.g:2821:2: ( ruleNumber )
            // InternalPerl.g:2822:3: ruleNumber
            {
             before(grammarAccess.getNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleNumber();

            state._fsp--;

             after(grammarAccess.getNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteral__ValueAssignment_1"


    // $ANTLR start "rule__StringLiteral__ValueAssignment_1"
    // InternalPerl.g:2831:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2835:1: ( ( RULE_STRING ) )
            // InternalPerl.g:2836:2: ( RULE_STRING )
            {
            // InternalPerl.g:2836:2: ( RULE_STRING )
            // InternalPerl.g:2837:3: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__ValueAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000340000381F2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000038080L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000C0FC1000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000340000381F0L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000F000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000F000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000F0000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000F00000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000040L});

}