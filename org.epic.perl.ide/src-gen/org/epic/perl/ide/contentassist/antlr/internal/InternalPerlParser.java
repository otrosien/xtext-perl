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
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalPerlParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HEX", "RULE_BIN", "RULE_OCT", "RULE_INT", "RULE_VAR_START", "RULE_ID", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'||'", "'&&'", "'+='", "'-='", "'*='", "'/='", "'%='", "'**='", "'=='", "'!='", "'eq'", "'ne'", "'>='", "'>'", "'<'", "'<>'", "'?:'", "'=>'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'++'", "'--'", "'my'", "'our'", "'local'", "'}'", "'sub'", "'{'", "';'", "'('", "')'", "'if'", "'else'", "'undef'", "'return'", "'::'"
    };
    public static final int RULE_HEX=4;
    public static final int T__50=50;
    public static final int RULE_OCT=6;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int RULE_BIN=5;
    public static final int T__54=54;
    public static final int RULE_ID=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=10;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=12;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_VAR_START=8;
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



    // $ANTLR start "entryRulePExpression"
    // InternalPerl.g:54:1: entryRulePExpression : rulePExpression EOF ;
    public final void entryRulePExpression() throws RecognitionException {
        try {
            // InternalPerl.g:55:1: ( rulePExpression EOF )
            // InternalPerl.g:56:1: rulePExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePExpression"


    // $ANTLR start "rulePExpression"
    // InternalPerl.g:63:1: rulePExpression : ( rulePAssignment ) ;
    public final void rulePExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:67:2: ( ( rulePAssignment ) )
            // InternalPerl.g:68:2: ( rulePAssignment )
            {
            // InternalPerl.g:68:2: ( rulePAssignment )
            // InternalPerl.g:69:3: rulePAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionAccess().getPAssignmentParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            rulePAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionAccess().getPAssignmentParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePExpression"


    // $ANTLR start "entryRulePAssignment"
    // InternalPerl.g:79:1: entryRulePAssignment : rulePAssignment EOF ;
    public final void entryRulePAssignment() throws RecognitionException {
        try {
            // InternalPerl.g:80:1: ( rulePAssignment EOF )
            // InternalPerl.g:81:1: rulePAssignment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePAssignment"


    // $ANTLR start "rulePAssignment"
    // InternalPerl.g:88:1: rulePAssignment : ( ( rule__PAssignment__Alternatives ) ) ;
    public final void rulePAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:92:2: ( ( ( rule__PAssignment__Alternatives ) ) )
            // InternalPerl.g:93:2: ( ( rule__PAssignment__Alternatives ) )
            {
            // InternalPerl.g:93:2: ( ( rule__PAssignment__Alternatives ) )
            // InternalPerl.g:94:3: ( rule__PAssignment__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getAlternatives()); 
            }
            // InternalPerl.g:95:3: ( rule__PAssignment__Alternatives )
            // InternalPerl.g:95:4: rule__PAssignment__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // InternalPerl.g:104:1: entryRuleOpSingleAssign : ruleOpSingleAssign EOF ;
    public final void entryRuleOpSingleAssign() throws RecognitionException {
        try {
            // InternalPerl.g:105:1: ( ruleOpSingleAssign EOF )
            // InternalPerl.g:106:1: ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpSingleAssignRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:113:1: ruleOpSingleAssign : ( '=' ) ;
    public final void ruleOpSingleAssign() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:117:2: ( ( '=' ) )
            // InternalPerl.g:118:2: ( '=' )
            {
            // InternalPerl.g:118:2: ( '=' )
            // InternalPerl.g:119:3: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); 
            }
            match(input,14,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); 
            }

            }


            }

        }
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
    // InternalPerl.g:129:1: entryRuleOpMultiAssign : ruleOpMultiAssign EOF ;
    public final void entryRuleOpMultiAssign() throws RecognitionException {
        try {
            // InternalPerl.g:130:1: ( ruleOpMultiAssign EOF )
            // InternalPerl.g:131:1: ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiAssignRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:138:1: ruleOpMultiAssign : ( ( rule__OpMultiAssign__Alternatives ) ) ;
    public final void ruleOpMultiAssign() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:142:2: ( ( ( rule__OpMultiAssign__Alternatives ) ) )
            // InternalPerl.g:143:2: ( ( rule__OpMultiAssign__Alternatives ) )
            {
            // InternalPerl.g:143:2: ( ( rule__OpMultiAssign__Alternatives ) )
            // InternalPerl.g:144:3: ( rule__OpMultiAssign__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getAlternatives()); 
            }
            // InternalPerl.g:145:3: ( rule__OpMultiAssign__Alternatives )
            // InternalPerl.g:145:4: rule__OpMultiAssign__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiAssignAccess().getAlternatives()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRulePOrExpression"
    // InternalPerl.g:154:1: entryRulePOrExpression : rulePOrExpression EOF ;
    public final void entryRulePOrExpression() throws RecognitionException {
        try {
            // InternalPerl.g:155:1: ( rulePOrExpression EOF )
            // InternalPerl.g:156:1: rulePOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePOrExpression"


    // $ANTLR start "rulePOrExpression"
    // InternalPerl.g:163:1: rulePOrExpression : ( ( rule__POrExpression__Group__0 ) ) ;
    public final void rulePOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:167:2: ( ( ( rule__POrExpression__Group__0 ) ) )
            // InternalPerl.g:168:2: ( ( rule__POrExpression__Group__0 ) )
            {
            // InternalPerl.g:168:2: ( ( rule__POrExpression__Group__0 ) )
            // InternalPerl.g:169:3: ( rule__POrExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:170:3: ( rule__POrExpression__Group__0 )
            // InternalPerl.g:170:4: rule__POrExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__POrExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalPerl.g:179:1: entryRuleOpOr : ruleOpOr EOF ;
    public final void entryRuleOpOr() throws RecognitionException {
        try {
            // InternalPerl.g:180:1: ( ruleOpOr EOF )
            // InternalPerl.g:181:1: ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOrRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:188:1: ruleOpOr : ( '||' ) ;
    public final void ruleOpOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:192:2: ( ( '||' ) )
            // InternalPerl.g:193:2: ( '||' )
            {
            // InternalPerl.g:193:2: ( '||' )
            // InternalPerl.g:194:3: '||'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRulePAndExpression"
    // InternalPerl.g:204:1: entryRulePAndExpression : rulePAndExpression EOF ;
    public final void entryRulePAndExpression() throws RecognitionException {
        try {
            // InternalPerl.g:205:1: ( rulePAndExpression EOF )
            // InternalPerl.g:206:1: rulePAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePAndExpression"


    // $ANTLR start "rulePAndExpression"
    // InternalPerl.g:213:1: rulePAndExpression : ( ( rule__PAndExpression__Group__0 ) ) ;
    public final void rulePAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:217:2: ( ( ( rule__PAndExpression__Group__0 ) ) )
            // InternalPerl.g:218:2: ( ( rule__PAndExpression__Group__0 ) )
            {
            // InternalPerl.g:218:2: ( ( rule__PAndExpression__Group__0 ) )
            // InternalPerl.g:219:3: ( rule__PAndExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:220:3: ( rule__PAndExpression__Group__0 )
            // InternalPerl.g:220:4: rule__PAndExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PAndExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalPerl.g:229:1: entryRuleOpAnd : ruleOpAnd EOF ;
    public final void entryRuleOpAnd() throws RecognitionException {
        try {
            // InternalPerl.g:230:1: ( ruleOpAnd EOF )
            // InternalPerl.g:231:1: ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpAndRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:238:1: ruleOpAnd : ( '&&' ) ;
    public final void ruleOpAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:242:2: ( ( '&&' ) )
            // InternalPerl.g:243:2: ( '&&' )
            {
            // InternalPerl.g:243:2: ( '&&' )
            // InternalPerl.g:244:3: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
            }
            match(input,16,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRulePEqualityExpression"
    // InternalPerl.g:254:1: entryRulePEqualityExpression : rulePEqualityExpression EOF ;
    public final void entryRulePEqualityExpression() throws RecognitionException {
        try {
            // InternalPerl.g:255:1: ( rulePEqualityExpression EOF )
            // InternalPerl.g:256:1: rulePEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePEqualityExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePEqualityExpression"


    // $ANTLR start "rulePEqualityExpression"
    // InternalPerl.g:263:1: rulePEqualityExpression : ( ( rule__PEqualityExpression__Group__0 ) ) ;
    public final void rulePEqualityExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:267:2: ( ( ( rule__PEqualityExpression__Group__0 ) ) )
            // InternalPerl.g:268:2: ( ( rule__PEqualityExpression__Group__0 ) )
            {
            // InternalPerl.g:268:2: ( ( rule__PEqualityExpression__Group__0 ) )
            // InternalPerl.g:269:3: ( rule__PEqualityExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:270:3: ( rule__PEqualityExpression__Group__0 )
            // InternalPerl.g:270:4: rule__PEqualityExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalPerl.g:279:1: entryRuleOpEquality : ruleOpEquality EOF ;
    public final void entryRuleOpEquality() throws RecognitionException {
        try {
            // InternalPerl.g:280:1: ( ruleOpEquality EOF )
            // InternalPerl.g:281:1: ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpEquality();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpEqualityRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:288:1: ruleOpEquality : ( ( rule__OpEquality__Alternatives ) ) ;
    public final void ruleOpEquality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:292:2: ( ( ( rule__OpEquality__Alternatives ) ) )
            // InternalPerl.g:293:2: ( ( rule__OpEquality__Alternatives ) )
            {
            // InternalPerl.g:293:2: ( ( rule__OpEquality__Alternatives ) )
            // InternalPerl.g:294:3: ( rule__OpEquality__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpEqualityAccess().getAlternatives()); 
            }
            // InternalPerl.g:295:3: ( rule__OpEquality__Alternatives )
            // InternalPerl.g:295:4: rule__OpEquality__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpEquality__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpEqualityAccess().getAlternatives()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRulePRelationalExpression"
    // InternalPerl.g:304:1: entryRulePRelationalExpression : rulePRelationalExpression EOF ;
    public final void entryRulePRelationalExpression() throws RecognitionException {
        try {
            // InternalPerl.g:305:1: ( rulePRelationalExpression EOF )
            // InternalPerl.g:306:1: rulePRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePRelationalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePRelationalExpression"


    // $ANTLR start "rulePRelationalExpression"
    // InternalPerl.g:313:1: rulePRelationalExpression : ( ( rule__PRelationalExpression__Group__0 ) ) ;
    public final void rulePRelationalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:317:2: ( ( ( rule__PRelationalExpression__Group__0 ) ) )
            // InternalPerl.g:318:2: ( ( rule__PRelationalExpression__Group__0 ) )
            {
            // InternalPerl.g:318:2: ( ( rule__PRelationalExpression__Group__0 ) )
            // InternalPerl.g:319:3: ( rule__PRelationalExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:320:3: ( rule__PRelationalExpression__Group__0 )
            // InternalPerl.g:320:4: rule__PRelationalExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalPerl.g:329:1: entryRuleOpCompare : ruleOpCompare EOF ;
    public final void entryRuleOpCompare() throws RecognitionException {
        try {
            // InternalPerl.g:330:1: ( ruleOpCompare EOF )
            // InternalPerl.g:331:1: ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpCompare();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpCompareRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // InternalPerl.g:338:1: ruleOpCompare : ( ( rule__OpCompare__Alternatives ) ) ;
    public final void ruleOpCompare() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:342:2: ( ( ( rule__OpCompare__Alternatives ) ) )
            // InternalPerl.g:343:2: ( ( rule__OpCompare__Alternatives ) )
            {
            // InternalPerl.g:343:2: ( ( rule__OpCompare__Alternatives ) )
            // InternalPerl.g:344:3: ( rule__OpCompare__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpCompareAccess().getAlternatives()); 
            }
            // InternalPerl.g:345:3: ( rule__OpCompare__Alternatives )
            // InternalPerl.g:345:4: rule__OpCompare__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpCompare__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpCompareAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRulePOtherOperatorExpression"
    // InternalPerl.g:354:1: entryRulePOtherOperatorExpression : rulePOtherOperatorExpression EOF ;
    public final void entryRulePOtherOperatorExpression() throws RecognitionException {
        try {
            // InternalPerl.g:355:1: ( rulePOtherOperatorExpression EOF )
            // InternalPerl.g:356:1: rulePOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePOtherOperatorExpression"


    // $ANTLR start "rulePOtherOperatorExpression"
    // InternalPerl.g:363:1: rulePOtherOperatorExpression : ( ( rule__POtherOperatorExpression__Group__0 ) ) ;
    public final void rulePOtherOperatorExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:367:2: ( ( ( rule__POtherOperatorExpression__Group__0 ) ) )
            // InternalPerl.g:368:2: ( ( rule__POtherOperatorExpression__Group__0 ) )
            {
            // InternalPerl.g:368:2: ( ( rule__POtherOperatorExpression__Group__0 ) )
            // InternalPerl.g:369:3: ( rule__POtherOperatorExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:370:3: ( rule__POtherOperatorExpression__Group__0 )
            // InternalPerl.g:370:4: rule__POtherOperatorExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // InternalPerl.g:379:1: entryRuleOpOther : ruleOpOther EOF ;
    public final void entryRuleOpOther() throws RecognitionException {
        try {
            // InternalPerl.g:380:1: ( ruleOpOther EOF )
            // InternalPerl.g:381:1: ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpOther();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // InternalPerl.g:388:1: ruleOpOther : ( ( rule__OpOther__Alternatives ) ) ;
    public final void ruleOpOther() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:392:2: ( ( ( rule__OpOther__Alternatives ) ) )
            // InternalPerl.g:393:2: ( ( rule__OpOther__Alternatives ) )
            {
            // InternalPerl.g:393:2: ( ( rule__OpOther__Alternatives ) )
            // InternalPerl.g:394:3: ( rule__OpOther__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getAlternatives()); 
            }
            // InternalPerl.g:395:3: ( rule__OpOther__Alternatives )
            // InternalPerl.g:395:4: rule__OpOther__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRulePAdditiveExpression"
    // InternalPerl.g:404:1: entryRulePAdditiveExpression : rulePAdditiveExpression EOF ;
    public final void entryRulePAdditiveExpression() throws RecognitionException {
        try {
            // InternalPerl.g:405:1: ( rulePAdditiveExpression EOF )
            // InternalPerl.g:406:1: rulePAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePAdditiveExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePAdditiveExpression"


    // $ANTLR start "rulePAdditiveExpression"
    // InternalPerl.g:413:1: rulePAdditiveExpression : ( ( rule__PAdditiveExpression__Group__0 ) ) ;
    public final void rulePAdditiveExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:417:2: ( ( ( rule__PAdditiveExpression__Group__0 ) ) )
            // InternalPerl.g:418:2: ( ( rule__PAdditiveExpression__Group__0 ) )
            {
            // InternalPerl.g:418:2: ( ( rule__PAdditiveExpression__Group__0 ) )
            // InternalPerl.g:419:3: ( rule__PAdditiveExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:420:3: ( rule__PAdditiveExpression__Group__0 )
            // InternalPerl.g:420:4: rule__PAdditiveExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalPerl.g:429:1: entryRuleOpAdd : ruleOpAdd EOF ;
    public final void entryRuleOpAdd() throws RecognitionException {
        try {
            // InternalPerl.g:430:1: ( ruleOpAdd EOF )
            // InternalPerl.g:431:1: ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpAdd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpAddRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // InternalPerl.g:438:1: ruleOpAdd : ( ( rule__OpAdd__Alternatives ) ) ;
    public final void ruleOpAdd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:442:2: ( ( ( rule__OpAdd__Alternatives ) ) )
            // InternalPerl.g:443:2: ( ( rule__OpAdd__Alternatives ) )
            {
            // InternalPerl.g:443:2: ( ( rule__OpAdd__Alternatives ) )
            // InternalPerl.g:444:3: ( rule__OpAdd__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpAddAccess().getAlternatives()); 
            }
            // InternalPerl.g:445:3: ( rule__OpAdd__Alternatives )
            // InternalPerl.g:445:4: rule__OpAdd__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpAdd__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpAddAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRulePMultiplicativeExpression"
    // InternalPerl.g:454:1: entryRulePMultiplicativeExpression : rulePMultiplicativeExpression EOF ;
    public final void entryRulePMultiplicativeExpression() throws RecognitionException {
        try {
            // InternalPerl.g:455:1: ( rulePMultiplicativeExpression EOF )
            // InternalPerl.g:456:1: rulePMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePMultiplicativeExpression"


    // $ANTLR start "rulePMultiplicativeExpression"
    // InternalPerl.g:463:1: rulePMultiplicativeExpression : ( ( rule__PMultiplicativeExpression__Group__0 ) ) ;
    public final void rulePMultiplicativeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:467:2: ( ( ( rule__PMultiplicativeExpression__Group__0 ) ) )
            // InternalPerl.g:468:2: ( ( rule__PMultiplicativeExpression__Group__0 ) )
            {
            // InternalPerl.g:468:2: ( ( rule__PMultiplicativeExpression__Group__0 ) )
            // InternalPerl.g:469:3: ( rule__PMultiplicativeExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:470:3: ( rule__PMultiplicativeExpression__Group__0 )
            // InternalPerl.g:470:4: rule__PMultiplicativeExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalPerl.g:479:1: entryRuleOpMulti : ruleOpMulti EOF ;
    public final void entryRuleOpMulti() throws RecognitionException {
        try {
            // InternalPerl.g:480:1: ( ruleOpMulti EOF )
            // InternalPerl.g:481:1: ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpMulti();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // InternalPerl.g:488:1: ruleOpMulti : ( ( rule__OpMulti__Alternatives ) ) ;
    public final void ruleOpMulti() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:492:2: ( ( ( rule__OpMulti__Alternatives ) ) )
            // InternalPerl.g:493:2: ( ( rule__OpMulti__Alternatives ) )
            {
            // InternalPerl.g:493:2: ( ( rule__OpMulti__Alternatives ) )
            // InternalPerl.g:494:3: ( rule__OpMulti__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAccess().getAlternatives()); 
            }
            // InternalPerl.g:495:3: ( rule__OpMulti__Alternatives )
            // InternalPerl.g:495:4: rule__OpMulti__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpMulti__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRulePUnaryOperation"
    // InternalPerl.g:504:1: entryRulePUnaryOperation : rulePUnaryOperation EOF ;
    public final void entryRulePUnaryOperation() throws RecognitionException {
        try {
            // InternalPerl.g:505:1: ( rulePUnaryOperation EOF )
            // InternalPerl.g:506:1: rulePUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePUnaryOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPUnaryOperationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePUnaryOperation"


    // $ANTLR start "rulePUnaryOperation"
    // InternalPerl.g:513:1: rulePUnaryOperation : ( ( rule__PUnaryOperation__Group__0 ) ) ;
    public final void rulePUnaryOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:517:2: ( ( ( rule__PUnaryOperation__Group__0 ) ) )
            // InternalPerl.g:518:2: ( ( rule__PUnaryOperation__Group__0 ) )
            {
            // InternalPerl.g:518:2: ( ( rule__PUnaryOperation__Group__0 ) )
            // InternalPerl.g:519:3: ( rule__PUnaryOperation__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPUnaryOperationAccess().getGroup()); 
            }
            // InternalPerl.g:520:3: ( rule__PUnaryOperation__Group__0 )
            // InternalPerl.g:520:4: rule__PUnaryOperation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PUnaryOperation__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPUnaryOperationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalPerl.g:529:1: entryRuleOpUnary : ruleOpUnary EOF ;
    public final void entryRuleOpUnary() throws RecognitionException {
        try {
            // InternalPerl.g:530:1: ( ruleOpUnary EOF )
            // InternalPerl.g:531:1: ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpUnary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpUnaryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // InternalPerl.g:538:1: ruleOpUnary : ( ( rule__OpUnary__Alternatives ) ) ;
    public final void ruleOpUnary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:542:2: ( ( ( rule__OpUnary__Alternatives ) ) )
            // InternalPerl.g:543:2: ( ( rule__OpUnary__Alternatives ) )
            {
            // InternalPerl.g:543:2: ( ( rule__OpUnary__Alternatives ) )
            // InternalPerl.g:544:3: ( rule__OpUnary__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpUnaryAccess().getAlternatives()); 
            }
            // InternalPerl.g:545:3: ( rule__OpUnary__Alternatives )
            // InternalPerl.g:545:4: rule__OpUnary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpUnary__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpUnaryAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleOpPostfix"
    // InternalPerl.g:554:1: entryRuleOpPostfix : ruleOpPostfix EOF ;
    public final void entryRuleOpPostfix() throws RecognitionException {
        try {
            // InternalPerl.g:555:1: ( ruleOpPostfix EOF )
            // InternalPerl.g:556:1: ruleOpPostfix EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpPostfixRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpPostfix();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpPostfixRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleOpPostfix"


    // $ANTLR start "ruleOpPostfix"
    // InternalPerl.g:563:1: ruleOpPostfix : ( ( rule__OpPostfix__Alternatives ) ) ;
    public final void ruleOpPostfix() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:567:2: ( ( ( rule__OpPostfix__Alternatives ) ) )
            // InternalPerl.g:568:2: ( ( rule__OpPostfix__Alternatives ) )
            {
            // InternalPerl.g:568:2: ( ( rule__OpPostfix__Alternatives ) )
            // InternalPerl.g:569:3: ( rule__OpPostfix__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpPostfixAccess().getAlternatives()); 
            }
            // InternalPerl.g:570:3: ( rule__OpPostfix__Alternatives )
            // InternalPerl.g:570:4: rule__OpPostfix__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpPostfix__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpPostfixAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpPostfix"


    // $ANTLR start "entryRulePVar"
    // InternalPerl.g:579:1: entryRulePVar : rulePVar EOF ;
    public final void entryRulePVar() throws RecognitionException {
        try {
            // InternalPerl.g:580:1: ( rulePVar EOF )
            // InternalPerl.g:581:1: rulePVar EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVarRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePVar();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVarRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePVar"


    // $ANTLR start "rulePVar"
    // InternalPerl.g:588:1: rulePVar : ( ( rule__PVar__Group__0 ) ) ;
    public final void rulePVar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:592:2: ( ( ( rule__PVar__Group__0 ) ) )
            // InternalPerl.g:593:2: ( ( rule__PVar__Group__0 ) )
            {
            // InternalPerl.g:593:2: ( ( rule__PVar__Group__0 ) )
            // InternalPerl.g:594:3: ( rule__PVar__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVarAccess().getGroup()); 
            }
            // InternalPerl.g:595:3: ( rule__PVar__Group__0 )
            // InternalPerl.g:595:4: rule__PVar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PVar__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVarAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePVar"


    // $ANTLR start "entryRulePLiteral"
    // InternalPerl.g:604:1: entryRulePLiteral : rulePLiteral EOF ;
    public final void entryRulePLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:605:1: ( rulePLiteral EOF )
            // InternalPerl.g:606:1: rulePLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePLiteral"


    // $ANTLR start "rulePLiteral"
    // InternalPerl.g:613:1: rulePLiteral : ( ( rule__PLiteral__Alternatives ) ) ;
    public final void rulePLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:617:2: ( ( ( rule__PLiteral__Alternatives ) ) )
            // InternalPerl.g:618:2: ( ( rule__PLiteral__Alternatives ) )
            {
            // InternalPerl.g:618:2: ( ( rule__PLiteral__Alternatives ) )
            // InternalPerl.g:619:3: ( rule__PLiteral__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPLiteralAccess().getAlternatives()); 
            }
            // InternalPerl.g:620:3: ( rule__PLiteral__Alternatives )
            // InternalPerl.g:620:4: rule__PLiteral__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PLiteral__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPLiteralAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePLiteral"


    // $ANTLR start "entryRulePClosure"
    // InternalPerl.g:629:1: entryRulePClosure : rulePClosure EOF ;
    public final void entryRulePClosure() throws RecognitionException {
        try {
            // InternalPerl.g:630:1: ( rulePClosure EOF )
            // InternalPerl.g:631:1: rulePClosure EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePClosure();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPClosureRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePClosure"


    // $ANTLR start "rulePClosure"
    // InternalPerl.g:638:1: rulePClosure : ( ( rule__PClosure__Group__0 ) ) ;
    public final void rulePClosure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:642:2: ( ( ( rule__PClosure__Group__0 ) ) )
            // InternalPerl.g:643:2: ( ( rule__PClosure__Group__0 ) )
            {
            // InternalPerl.g:643:2: ( ( rule__PClosure__Group__0 ) )
            // InternalPerl.g:644:3: ( rule__PClosure__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getGroup()); 
            }
            // InternalPerl.g:645:3: ( rule__PClosure__Group__0 )
            // InternalPerl.g:645:4: rule__PClosure__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PClosure__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPClosureAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePClosure"


    // $ANTLR start "entryRulePExpressionInClosure"
    // InternalPerl.g:654:1: entryRulePExpressionInClosure : rulePExpressionInClosure EOF ;
    public final void entryRulePExpressionInClosure() throws RecognitionException {
        try {
            // InternalPerl.g:655:1: ( rulePExpressionInClosure EOF )
            // InternalPerl.g:656:1: rulePExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePExpressionInClosure();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionInClosureRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePExpressionInClosure"


    // $ANTLR start "rulePExpressionInClosure"
    // InternalPerl.g:663:1: rulePExpressionInClosure : ( ( rule__PExpressionInClosure__Group__0 ) ) ;
    public final void rulePExpressionInClosure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:667:2: ( ( ( rule__PExpressionInClosure__Group__0 ) ) )
            // InternalPerl.g:668:2: ( ( rule__PExpressionInClosure__Group__0 ) )
            {
            // InternalPerl.g:668:2: ( ( rule__PExpressionInClosure__Group__0 ) )
            // InternalPerl.g:669:3: ( rule__PExpressionInClosure__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getGroup()); 
            }
            // InternalPerl.g:670:3: ( rule__PExpressionInClosure__Group__0 )
            // InternalPerl.g:670:4: rule__PExpressionInClosure__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PExpressionInClosure__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionInClosureAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePExpressionInClosure"


    // $ANTLR start "entryRulePParenthesizedExpression"
    // InternalPerl.g:679:1: entryRulePParenthesizedExpression : rulePParenthesizedExpression EOF ;
    public final void entryRulePParenthesizedExpression() throws RecognitionException {
        try {
            // InternalPerl.g:680:1: ( rulePParenthesizedExpression EOF )
            // InternalPerl.g:681:1: rulePParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePParenthesizedExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPParenthesizedExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePParenthesizedExpression"


    // $ANTLR start "rulePParenthesizedExpression"
    // InternalPerl.g:688:1: rulePParenthesizedExpression : ( ( rule__PParenthesizedExpression__Group__0 ) ) ;
    public final void rulePParenthesizedExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:692:2: ( ( ( rule__PParenthesizedExpression__Group__0 ) ) )
            // InternalPerl.g:693:2: ( ( rule__PParenthesizedExpression__Group__0 ) )
            {
            // InternalPerl.g:693:2: ( ( rule__PParenthesizedExpression__Group__0 ) )
            // InternalPerl.g:694:3: ( rule__PParenthesizedExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPParenthesizedExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:695:3: ( rule__PParenthesizedExpression__Group__0 )
            // InternalPerl.g:695:4: rule__PParenthesizedExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PParenthesizedExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPParenthesizedExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePParenthesizedExpression"


    // $ANTLR start "entryRulePIfExpression"
    // InternalPerl.g:704:1: entryRulePIfExpression : rulePIfExpression EOF ;
    public final void entryRulePIfExpression() throws RecognitionException {
        try {
            // InternalPerl.g:705:1: ( rulePIfExpression EOF )
            // InternalPerl.g:706:1: rulePIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePIfExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePIfExpression"


    // $ANTLR start "rulePIfExpression"
    // InternalPerl.g:713:1: rulePIfExpression : ( ( rule__PIfExpression__Group__0 ) ) ;
    public final void rulePIfExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:717:2: ( ( ( rule__PIfExpression__Group__0 ) ) )
            // InternalPerl.g:718:2: ( ( rule__PIfExpression__Group__0 ) )
            {
            // InternalPerl.g:718:2: ( ( rule__PIfExpression__Group__0 ) )
            // InternalPerl.g:719:3: ( rule__PIfExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:720:3: ( rule__PIfExpression__Group__0 )
            // InternalPerl.g:720:4: rule__PIfExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PIfExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePIfExpression"


    // $ANTLR start "entryRulePBlockExpression"
    // InternalPerl.g:729:1: entryRulePBlockExpression : rulePBlockExpression EOF ;
    public final void entryRulePBlockExpression() throws RecognitionException {
        try {
            // InternalPerl.g:730:1: ( rulePBlockExpression EOF )
            // InternalPerl.g:731:1: rulePBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePBlockExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPBlockExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePBlockExpression"


    // $ANTLR start "rulePBlockExpression"
    // InternalPerl.g:738:1: rulePBlockExpression : ( ( rule__PBlockExpression__Group__0 ) ) ;
    public final void rulePBlockExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:742:2: ( ( ( rule__PBlockExpression__Group__0 ) ) )
            // InternalPerl.g:743:2: ( ( rule__PBlockExpression__Group__0 ) )
            {
            // InternalPerl.g:743:2: ( ( rule__PBlockExpression__Group__0 ) )
            // InternalPerl.g:744:3: ( rule__PBlockExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:745:3: ( rule__PBlockExpression__Group__0 )
            // InternalPerl.g:745:4: rule__PBlockExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PBlockExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPBlockExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePBlockExpression"


    // $ANTLR start "entryRulePExpressionOrVarDeclaration"
    // InternalPerl.g:754:1: entryRulePExpressionOrVarDeclaration : rulePExpressionOrVarDeclaration EOF ;
    public final void entryRulePExpressionOrVarDeclaration() throws RecognitionException {
        try {
            // InternalPerl.g:755:1: ( rulePExpressionOrVarDeclaration EOF )
            // InternalPerl.g:756:1: rulePExpressionOrVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionOrVarDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePExpressionOrVarDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionOrVarDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePExpressionOrVarDeclaration"


    // $ANTLR start "rulePExpressionOrVarDeclaration"
    // InternalPerl.g:763:1: rulePExpressionOrVarDeclaration : ( ( rule__PExpressionOrVarDeclaration__Alternatives ) ) ;
    public final void rulePExpressionOrVarDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:767:2: ( ( ( rule__PExpressionOrVarDeclaration__Alternatives ) ) )
            // InternalPerl.g:768:2: ( ( rule__PExpressionOrVarDeclaration__Alternatives ) )
            {
            // InternalPerl.g:768:2: ( ( rule__PExpressionOrVarDeclaration__Alternatives ) )
            // InternalPerl.g:769:3: ( rule__PExpressionOrVarDeclaration__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionOrVarDeclarationAccess().getAlternatives()); 
            }
            // InternalPerl.g:770:3: ( rule__PExpressionOrVarDeclaration__Alternatives )
            // InternalPerl.g:770:4: rule__PExpressionOrVarDeclaration__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PExpressionOrVarDeclaration__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionOrVarDeclarationAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePExpressionOrVarDeclaration"


    // $ANTLR start "entryRulePVariableDeclaration"
    // InternalPerl.g:779:1: entryRulePVariableDeclaration : rulePVariableDeclaration EOF ;
    public final void entryRulePVariableDeclaration() throws RecognitionException {
        try {
            // InternalPerl.g:780:1: ( rulePVariableDeclaration EOF )
            // InternalPerl.g:781:1: rulePVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePVariableDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePVariableDeclaration"


    // $ANTLR start "rulePVariableDeclaration"
    // InternalPerl.g:788:1: rulePVariableDeclaration : ( ( rule__PVariableDeclaration__Group__0 ) ) ;
    public final void rulePVariableDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:792:2: ( ( ( rule__PVariableDeclaration__Group__0 ) ) )
            // InternalPerl.g:793:2: ( ( rule__PVariableDeclaration__Group__0 ) )
            {
            // InternalPerl.g:793:2: ( ( rule__PVariableDeclaration__Group__0 ) )
            // InternalPerl.g:794:3: ( rule__PVariableDeclaration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getGroup()); 
            }
            // InternalPerl.g:795:3: ( rule__PVariableDeclaration__Group__0 )
            // InternalPerl.g:795:4: rule__PVariableDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePVariableDeclaration"


    // $ANTLR start "entryRulePNumberLiteral"
    // InternalPerl.g:804:1: entryRulePNumberLiteral : rulePNumberLiteral EOF ;
    public final void entryRulePNumberLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:805:1: ( rulePNumberLiteral EOF )
            // InternalPerl.g:806:1: rulePNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePNumberLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPNumberLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePNumberLiteral"


    // $ANTLR start "rulePNumberLiteral"
    // InternalPerl.g:813:1: rulePNumberLiteral : ( ( rule__PNumberLiteral__Group__0 ) ) ;
    public final void rulePNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:817:2: ( ( ( rule__PNumberLiteral__Group__0 ) ) )
            // InternalPerl.g:818:2: ( ( rule__PNumberLiteral__Group__0 ) )
            {
            // InternalPerl.g:818:2: ( ( rule__PNumberLiteral__Group__0 ) )
            // InternalPerl.g:819:3: ( rule__PNumberLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNumberLiteralAccess().getGroup()); 
            }
            // InternalPerl.g:820:3: ( rule__PNumberLiteral__Group__0 )
            // InternalPerl.g:820:4: rule__PNumberLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PNumberLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPNumberLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePNumberLiteral"


    // $ANTLR start "entryRulePNullLiteral"
    // InternalPerl.g:829:1: entryRulePNullLiteral : rulePNullLiteral EOF ;
    public final void entryRulePNullLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:830:1: ( rulePNullLiteral EOF )
            // InternalPerl.g:831:1: rulePNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNullLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePNullLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPNullLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePNullLiteral"


    // $ANTLR start "rulePNullLiteral"
    // InternalPerl.g:838:1: rulePNullLiteral : ( ( rule__PNullLiteral__Group__0 ) ) ;
    public final void rulePNullLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:842:2: ( ( ( rule__PNullLiteral__Group__0 ) ) )
            // InternalPerl.g:843:2: ( ( rule__PNullLiteral__Group__0 ) )
            {
            // InternalPerl.g:843:2: ( ( rule__PNullLiteral__Group__0 ) )
            // InternalPerl.g:844:3: ( rule__PNullLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNullLiteralAccess().getGroup()); 
            }
            // InternalPerl.g:845:3: ( rule__PNullLiteral__Group__0 )
            // InternalPerl.g:845:4: rule__PNullLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PNullLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPNullLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePNullLiteral"


    // $ANTLR start "entryRulePReturnExpression"
    // InternalPerl.g:854:1: entryRulePReturnExpression : rulePReturnExpression EOF ;
    public final void entryRulePReturnExpression() throws RecognitionException {
        try {
            // InternalPerl.g:855:1: ( rulePReturnExpression EOF )
            // InternalPerl.g:856:1: rulePReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePReturnExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPReturnExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePReturnExpression"


    // $ANTLR start "rulePReturnExpression"
    // InternalPerl.g:863:1: rulePReturnExpression : ( ( rule__PReturnExpression__Group__0 ) ) ;
    public final void rulePReturnExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:867:2: ( ( ( rule__PReturnExpression__Group__0 ) ) )
            // InternalPerl.g:868:2: ( ( rule__PReturnExpression__Group__0 ) )
            {
            // InternalPerl.g:868:2: ( ( rule__PReturnExpression__Group__0 ) )
            // InternalPerl.g:869:3: ( rule__PReturnExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPReturnExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:870:3: ( rule__PReturnExpression__Group__0 )
            // InternalPerl.g:870:4: rule__PReturnExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PReturnExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPReturnExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePReturnExpression"


    // $ANTLR start "entryRulePStringLiteral"
    // InternalPerl.g:879:1: entryRulePStringLiteral : rulePStringLiteral EOF ;
    public final void entryRulePStringLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:880:1: ( rulePStringLiteral EOF )
            // InternalPerl.g:881:1: rulePStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePStringLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPStringLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePStringLiteral"


    // $ANTLR start "rulePStringLiteral"
    // InternalPerl.g:888:1: rulePStringLiteral : ( ( rule__PStringLiteral__Group__0 ) ) ;
    public final void rulePStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:892:2: ( ( ( rule__PStringLiteral__Group__0 ) ) )
            // InternalPerl.g:893:2: ( ( rule__PStringLiteral__Group__0 ) )
            {
            // InternalPerl.g:893:2: ( ( rule__PStringLiteral__Group__0 ) )
            // InternalPerl.g:894:3: ( rule__PStringLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPStringLiteralAccess().getGroup()); 
            }
            // InternalPerl.g:895:3: ( rule__PStringLiteral__Group__0 )
            // InternalPerl.g:895:4: rule__PStringLiteral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PStringLiteral__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPStringLiteralAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePStringLiteral"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalPerl.g:904:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalPerl.g:905:1: ( ruleQualifiedName EOF )
            // InternalPerl.g:906:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalPerl.g:913:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:917:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalPerl.g:918:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalPerl.g:918:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalPerl.g:919:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalPerl.g:920:3: ( rule__QualifiedName__Group__0 )
            // InternalPerl.g:920:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNumber"
    // InternalPerl.g:929:1: entryRuleNumber : ruleNumber EOF ;
    public final void entryRuleNumber() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:933:1: ( ruleNumber EOF )
            // InternalPerl.g:934:1: ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNumber();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:944:1: ruleNumber : ( ( rule__Number__Alternatives ) ) ;
    public final void ruleNumber() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:949:2: ( ( ( rule__Number__Alternatives ) ) )
            // InternalPerl.g:950:2: ( ( rule__Number__Alternatives ) )
            {
            // InternalPerl.g:950:2: ( ( rule__Number__Alternatives ) )
            // InternalPerl.g:951:3: ( rule__Number__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberAccess().getAlternatives()); 
            }
            // InternalPerl.g:952:3: ( rule__Number__Alternatives )
            // InternalPerl.g:952:4: rule__Number__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Number__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberAccess().getAlternatives()); 
            }

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


    // $ANTLR start "rule__PAssignment__Alternatives"
    // InternalPerl.g:961:1: rule__PAssignment__Alternatives : ( ( ( rule__PAssignment__Group_0__0 ) ) | ( ( rule__PAssignment__Group_1__0 ) ) );
    public final void rule__PAssignment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:965:1: ( ( ( rule__PAssignment__Group_0__0 ) ) | ( ( rule__PAssignment__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_VAR_START) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=33 && LA1_0<=34)||LA1_0==39) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalPerl.g:966:2: ( ( rule__PAssignment__Group_0__0 ) )
                    {
                    // InternalPerl.g:966:2: ( ( rule__PAssignment__Group_0__0 ) )
                    // InternalPerl.g:967:3: ( rule__PAssignment__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPAssignmentAccess().getGroup_0()); 
                    }
                    // InternalPerl.g:968:3: ( rule__PAssignment__Group_0__0 )
                    // InternalPerl.g:968:4: rule__PAssignment__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PAssignment__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPAssignmentAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:972:2: ( ( rule__PAssignment__Group_1__0 ) )
                    {
                    // InternalPerl.g:972:2: ( ( rule__PAssignment__Group_1__0 ) )
                    // InternalPerl.g:973:3: ( rule__PAssignment__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPAssignmentAccess().getGroup_1()); 
                    }
                    // InternalPerl.g:974:3: ( rule__PAssignment__Group_1__0 )
                    // InternalPerl.g:974:4: rule__PAssignment__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PAssignment__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPAssignmentAccess().getGroup_1()); 
                    }

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
    // $ANTLR end "rule__PAssignment__Alternatives"


    // $ANTLR start "rule__OpMultiAssign__Alternatives"
    // InternalPerl.g:982:1: rule__OpMultiAssign__Alternatives : ( ( '+=' ) | ( '-=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '**=' ) | ( ( rule__OpMultiAssign__Group_6__0 ) ) | ( ( rule__OpMultiAssign__Group_7__0 ) ) );
    public final void rule__OpMultiAssign__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:986:1: ( ( '+=' ) | ( '-=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '**=' ) | ( ( rule__OpMultiAssign__Group_6__0 ) ) | ( ( rule__OpMultiAssign__Group_7__0 ) ) )
            int alt2=8;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 19:
                {
                alt2=3;
                }
                break;
            case 20:
                {
                alt2=4;
                }
                break;
            case 21:
                {
                alt2=5;
                }
                break;
            case 22:
                {
                alt2=6;
                }
                break;
            case 29:
                {
                alt2=7;
                }
                break;
            case 28:
                {
                alt2=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalPerl.g:987:2: ( '+=' )
                    {
                    // InternalPerl.g:987:2: ( '+=' )
                    // InternalPerl.g:988:3: '+='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0()); 
                    }
                    match(input,17,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:993:2: ( '-=' )
                    {
                    // InternalPerl.g:993:2: ( '-=' )
                    // InternalPerl.g:994:3: '-='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:999:2: ( '*=' )
                    {
                    // InternalPerl.g:999:2: ( '*=' )
                    // InternalPerl.g:1000:3: '*='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1005:2: ( '/=' )
                    {
                    // InternalPerl.g:1005:2: ( '/=' )
                    // InternalPerl.g:1006:3: '/='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3()); 
                    }
                    match(input,20,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:1011:2: ( '%=' )
                    {
                    // InternalPerl.g:1011:2: ( '%=' )
                    // InternalPerl.g:1012:3: '%='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4()); 
                    }
                    match(input,21,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:1017:2: ( '**=' )
                    {
                    // InternalPerl.g:1017:2: ( '**=' )
                    // InternalPerl.g:1018:3: '**='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getAsteriskAsteriskEqualsSignKeyword_5()); 
                    }
                    match(input,22,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getAsteriskAsteriskEqualsSignKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:1023:2: ( ( rule__OpMultiAssign__Group_6__0 ) )
                    {
                    // InternalPerl.g:1023:2: ( ( rule__OpMultiAssign__Group_6__0 ) )
                    // InternalPerl.g:1024:3: ( rule__OpMultiAssign__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getGroup_6()); 
                    }
                    // InternalPerl.g:1025:3: ( rule__OpMultiAssign__Group_6__0 )
                    // InternalPerl.g:1025:4: rule__OpMultiAssign__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpMultiAssign__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:1029:2: ( ( rule__OpMultiAssign__Group_7__0 ) )
                    {
                    // InternalPerl.g:1029:2: ( ( rule__OpMultiAssign__Group_7__0 ) )
                    // InternalPerl.g:1030:3: ( rule__OpMultiAssign__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getGroup_7()); 
                    }
                    // InternalPerl.g:1031:3: ( rule__OpMultiAssign__Group_7__0 )
                    // InternalPerl.g:1031:4: rule__OpMultiAssign__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpMultiAssign__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getGroup_7()); 
                    }

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
    // InternalPerl.g:1039:1: rule__OpEquality__Alternatives : ( ( '==' ) | ( '!=' ) | ( 'eq' ) | ( 'ne' ) );
    public final void rule__OpEquality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1043:1: ( ( '==' ) | ( '!=' ) | ( 'eq' ) | ( 'ne' ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt3=1;
                }
                break;
            case 24:
                {
                alt3=2;
                }
                break;
            case 25:
                {
                alt3=3;
                }
                break;
            case 26:
                {
                alt3=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalPerl.g:1044:2: ( '==' )
                    {
                    // InternalPerl.g:1044:2: ( '==' )
                    // InternalPerl.g:1045:3: '=='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                    }
                    match(input,23,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1050:2: ( '!=' )
                    {
                    // InternalPerl.g:1050:2: ( '!=' )
                    // InternalPerl.g:1051:3: '!='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                    }
                    match(input,24,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1056:2: ( 'eq' )
                    {
                    // InternalPerl.g:1056:2: ( 'eq' )
                    // InternalPerl.g:1057:3: 'eq'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpEqualityAccess().getEqKeyword_2()); 
                    }
                    match(input,25,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpEqualityAccess().getEqKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1062:2: ( 'ne' )
                    {
                    // InternalPerl.g:1062:2: ( 'ne' )
                    // InternalPerl.g:1063:3: 'ne'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpEqualityAccess().getNeKeyword_3()); 
                    }
                    match(input,26,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpEqualityAccess().getNeKeyword_3()); 
                    }

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


    // $ANTLR start "rule__OpCompare__Alternatives"
    // InternalPerl.g:1072:1: rule__OpCompare__Alternatives : ( ( '>=' ) | ( ( rule__OpCompare__Group_1__0 ) ) | ( '>' ) | ( '<' ) );
    public final void rule__OpCompare__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1076:1: ( ( '>=' ) | ( ( rule__OpCompare__Group_1__0 ) ) | ( '>' ) | ( '<' ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt4=1;
                }
                break;
            case 29:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==14) ) {
                    alt4=2;
                }
                else if ( (LA4_2==EOF||(LA4_2>=33 && LA4_2<=34)||LA4_2==39) ) {
                    alt4=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
                }
                break;
            case 28:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalPerl.g:1077:2: ( '>=' )
                    {
                    // InternalPerl.g:1077:2: ( '>=' )
                    // InternalPerl.g:1078:3: '>='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                    }
                    match(input,27,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1083:2: ( ( rule__OpCompare__Group_1__0 ) )
                    {
                    // InternalPerl.g:1083:2: ( ( rule__OpCompare__Group_1__0 ) )
                    // InternalPerl.g:1084:3: ( rule__OpCompare__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getGroup_1()); 
                    }
                    // InternalPerl.g:1085:3: ( rule__OpCompare__Group_1__0 )
                    // InternalPerl.g:1085:4: rule__OpCompare__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpCompare__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1089:2: ( '>' )
                    {
                    // InternalPerl.g:1089:2: ( '>' )
                    // InternalPerl.g:1090:3: '>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                    }
                    match(input,28,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1095:2: ( '<' )
                    {
                    // InternalPerl.g:1095:2: ( '<' )
                    // InternalPerl.g:1096:3: '<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                    }
                    match(input,29,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                    }

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
    // $ANTLR end "rule__OpCompare__Alternatives"


    // $ANTLR start "rule__OpOther__Alternatives"
    // InternalPerl.g:1105:1: rule__OpOther__Alternatives : ( ( ( rule__OpOther__Group_0__0 ) ) | ( ( rule__OpOther__Group_1__0 ) ) | ( '<>' ) | ( '?:' ) );
    public final void rule__OpOther__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1109:1: ( ( ( rule__OpOther__Group_0__0 ) ) | ( ( rule__OpOther__Group_1__0 ) ) | ( '<>' ) | ( '?:' ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt5=1;
                }
                break;
            case 29:
                {
                alt5=2;
                }
                break;
            case 30:
                {
                alt5=3;
                }
                break;
            case 31:
                {
                alt5=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalPerl.g:1110:2: ( ( rule__OpOther__Group_0__0 ) )
                    {
                    // InternalPerl.g:1110:2: ( ( rule__OpOther__Group_0__0 ) )
                    // InternalPerl.g:1111:3: ( rule__OpOther__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGroup_0()); 
                    }
                    // InternalPerl.g:1112:3: ( rule__OpOther__Group_0__0 )
                    // InternalPerl.g:1112:4: rule__OpOther__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpOther__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1116:2: ( ( rule__OpOther__Group_1__0 ) )
                    {
                    // InternalPerl.g:1116:2: ( ( rule__OpOther__Group_1__0 ) )
                    // InternalPerl.g:1117:3: ( rule__OpOther__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGroup_1()); 
                    }
                    // InternalPerl.g:1118:3: ( rule__OpOther__Group_1__0 )
                    // InternalPerl.g:1118:4: rule__OpOther__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpOther__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1122:2: ( '<>' )
                    {
                    // InternalPerl.g:1122:2: ( '<>' )
                    // InternalPerl.g:1123:3: '<>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_2()); 
                    }
                    match(input,30,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1128:2: ( '?:' )
                    {
                    // InternalPerl.g:1128:2: ( '?:' )
                    // InternalPerl.g:1129:3: '?:'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_3()); 
                    }
                    match(input,31,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_3()); 
                    }

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
    // $ANTLR end "rule__OpOther__Alternatives"


    // $ANTLR start "rule__OpOther__Alternatives_0_1"
    // InternalPerl.g:1138:1: rule__OpOther__Alternatives_0_1 : ( ( ( rule__OpOther__Group_0_1_0__0 ) ) | ( '>' ) );
    public final void rule__OpOther__Alternatives_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1142:1: ( ( ( rule__OpOther__Group_0_1_0__0 ) ) | ( '>' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==28) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==28) ) {
                    alt6=1;
                }
                else if ( (LA6_1==EOF||(LA6_1>=33 && LA6_1<=34)||LA6_1==39) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalPerl.g:1143:2: ( ( rule__OpOther__Group_0_1_0__0 ) )
                    {
                    // InternalPerl.g:1143:2: ( ( rule__OpOther__Group_0_1_0__0 ) )
                    // InternalPerl.g:1144:3: ( rule__OpOther__Group_0_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGroup_0_1_0()); 
                    }
                    // InternalPerl.g:1145:3: ( rule__OpOther__Group_0_1_0__0 )
                    // InternalPerl.g:1145:4: rule__OpOther__Group_0_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpOther__Group_0_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGroup_0_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1149:2: ( '>' )
                    {
                    // InternalPerl.g:1149:2: ( '>' )
                    // InternalPerl.g:1150:3: '>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_1()); 
                    }
                    match(input,28,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_1()); 
                    }

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
    // $ANTLR end "rule__OpOther__Alternatives_0_1"


    // $ANTLR start "rule__OpOther__Alternatives_1_1"
    // InternalPerl.g:1159:1: rule__OpOther__Alternatives_1_1 : ( ( ( rule__OpOther__Group_1_1_0__0 ) ) | ( '<' ) | ( '=>' ) );
    public final void rule__OpOther__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1163:1: ( ( ( rule__OpOther__Group_1_1_0__0 ) ) | ( '<' ) | ( '=>' ) )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==29) ) {
                    alt7=1;
                }
                else if ( (LA7_1==EOF||(LA7_1>=33 && LA7_1<=34)||LA7_1==39) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA7_0==32) ) {
                alt7=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalPerl.g:1164:2: ( ( rule__OpOther__Group_1_1_0__0 ) )
                    {
                    // InternalPerl.g:1164:2: ( ( rule__OpOther__Group_1_1_0__0 ) )
                    // InternalPerl.g:1165:3: ( rule__OpOther__Group_1_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGroup_1_1_0()); 
                    }
                    // InternalPerl.g:1166:3: ( rule__OpOther__Group_1_1_0__0 )
                    // InternalPerl.g:1166:4: rule__OpOther__Group_1_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpOther__Group_1_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGroup_1_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1170:2: ( '<' )
                    {
                    // InternalPerl.g:1170:2: ( '<' )
                    // InternalPerl.g:1171:3: '<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_1_1()); 
                    }
                    match(input,29,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1176:2: ( '=>' )
                    {
                    // InternalPerl.g:1176:2: ( '=>' )
                    // InternalPerl.g:1177:3: '=>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_1_1_2()); 
                    }
                    match(input,32,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_1_1_2()); 
                    }

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
    // $ANTLR end "rule__OpOther__Alternatives_1_1"


    // $ANTLR start "rule__OpAdd__Alternatives"
    // InternalPerl.g:1186:1: rule__OpAdd__Alternatives : ( ( '+' ) | ( '-' ) );
    public final void rule__OpAdd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1190:1: ( ( '+' ) | ( '-' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==33) ) {
                alt8=1;
            }
            else if ( (LA8_0==34) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalPerl.g:1191:2: ( '+' )
                    {
                    // InternalPerl.g:1191:2: ( '+' )
                    // InternalPerl.g:1192:3: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                    }
                    match(input,33,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1197:2: ( '-' )
                    {
                    // InternalPerl.g:1197:2: ( '-' )
                    // InternalPerl.g:1198:3: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                    }
                    match(input,34,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                    }

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
    // $ANTLR end "rule__OpAdd__Alternatives"


    // $ANTLR start "rule__OpMulti__Alternatives"
    // InternalPerl.g:1207:1: rule__OpMulti__Alternatives : ( ( '*' ) | ( '**' ) | ( '/' ) | ( '%' ) );
    public final void rule__OpMulti__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1211:1: ( ( '*' ) | ( '**' ) | ( '/' ) | ( '%' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt9=1;
                }
                break;
            case 36:
                {
                alt9=2;
                }
                break;
            case 37:
                {
                alt9=3;
                }
                break;
            case 38:
                {
                alt9=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalPerl.g:1212:2: ( '*' )
                    {
                    // InternalPerl.g:1212:2: ( '*' )
                    // InternalPerl.g:1213:3: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                    }
                    match(input,35,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1218:2: ( '**' )
                    {
                    // InternalPerl.g:1218:2: ( '**' )
                    // InternalPerl.g:1219:3: '**'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                    }
                    match(input,36,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1224:2: ( '/' )
                    {
                    // InternalPerl.g:1224:2: ( '/' )
                    // InternalPerl.g:1225:3: '/'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                    }
                    match(input,37,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1230:2: ( '%' )
                    {
                    // InternalPerl.g:1230:2: ( '%' )
                    // InternalPerl.g:1231:3: '%'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
                    }
                    match(input,38,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
                    }

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
    // $ANTLR end "rule__OpMulti__Alternatives"


    // $ANTLR start "rule__OpUnary__Alternatives"
    // InternalPerl.g:1240:1: rule__OpUnary__Alternatives : ( ( '!' ) | ( '-' ) | ( '+' ) );
    public final void rule__OpUnary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1244:1: ( ( '!' ) | ( '-' ) | ( '+' ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt10=1;
                }
                break;
            case 34:
                {
                alt10=2;
                }
                break;
            case 33:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalPerl.g:1245:2: ( '!' )
                    {
                    // InternalPerl.g:1245:2: ( '!' )
                    // InternalPerl.g:1246:3: '!'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                    }
                    match(input,39,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1251:2: ( '-' )
                    {
                    // InternalPerl.g:1251:2: ( '-' )
                    // InternalPerl.g:1252:3: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                    }
                    match(input,34,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1257:2: ( '+' )
                    {
                    // InternalPerl.g:1257:2: ( '+' )
                    // InternalPerl.g:1258:3: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                    }
                    match(input,33,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                    }

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
    // $ANTLR end "rule__OpUnary__Alternatives"


    // $ANTLR start "rule__OpPostfix__Alternatives"
    // InternalPerl.g:1267:1: rule__OpPostfix__Alternatives : ( ( '++' ) | ( '--' ) );
    public final void rule__OpPostfix__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1271:1: ( ( '++' ) | ( '--' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==40) ) {
                alt11=1;
            }
            else if ( (LA11_0==41) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalPerl.g:1272:2: ( '++' )
                    {
                    // InternalPerl.g:1272:2: ( '++' )
                    // InternalPerl.g:1273:3: '++'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0()); 
                    }
                    match(input,40,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1278:2: ( '--' )
                    {
                    // InternalPerl.g:1278:2: ( '--' )
                    // InternalPerl.g:1279:3: '--'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    }
                    match(input,41,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    }

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
    // $ANTLR end "rule__OpPostfix__Alternatives"


    // $ANTLR start "rule__PLiteral__Alternatives"
    // InternalPerl.g:1288:1: rule__PLiteral__Alternatives : ( ( ( rulePClosure ) ) | ( rulePNumberLiteral ) | ( rulePNullLiteral ) | ( rulePStringLiteral ) );
    public final void rule__PLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1292:1: ( ( ( rulePClosure ) ) | ( rulePNumberLiteral ) | ( rulePNullLiteral ) | ( rulePStringLiteral ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt12=1;
                }
                break;
            case RULE_HEX:
            case RULE_BIN:
            case RULE_OCT:
            case RULE_INT:
                {
                alt12=2;
                }
                break;
            case 53:
                {
                alt12=3;
                }
                break;
            case RULE_STRING:
                {
                alt12=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalPerl.g:1293:2: ( ( rulePClosure ) )
                    {
                    // InternalPerl.g:1293:2: ( ( rulePClosure ) )
                    // InternalPerl.g:1294:3: ( rulePClosure )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPLiteralAccess().getPClosureParserRuleCall_0()); 
                    }
                    // InternalPerl.g:1295:3: ( rulePClosure )
                    // InternalPerl.g:1295:4: rulePClosure
                    {
                    pushFollow(FOLLOW_2);
                    rulePClosure();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPLiteralAccess().getPClosureParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1299:2: ( rulePNumberLiteral )
                    {
                    // InternalPerl.g:1299:2: ( rulePNumberLiteral )
                    // InternalPerl.g:1300:3: rulePNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPLiteralAccess().getPNumberLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePNumberLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPLiteralAccess().getPNumberLiteralParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1305:2: ( rulePNullLiteral )
                    {
                    // InternalPerl.g:1305:2: ( rulePNullLiteral )
                    // InternalPerl.g:1306:3: rulePNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPLiteralAccess().getPNullLiteralParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePNullLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPLiteralAccess().getPNullLiteralParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1311:2: ( rulePStringLiteral )
                    {
                    // InternalPerl.g:1311:2: ( rulePStringLiteral )
                    // InternalPerl.g:1312:3: rulePStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPLiteralAccess().getPStringLiteralParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePStringLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPLiteralAccess().getPStringLiteralParserRuleCall_3()); 
                    }

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
    // $ANTLR end "rule__PLiteral__Alternatives"


    // $ANTLR start "rule__PExpressionOrVarDeclaration__Alternatives"
    // InternalPerl.g:1321:1: rule__PExpressionOrVarDeclaration__Alternatives : ( ( rulePVariableDeclaration ) | ( rulePExpression ) );
    public final void rule__PExpressionOrVarDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1325:1: ( ( rulePVariableDeclaration ) | ( rulePExpression ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=42 && LA13_0<=44)) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_VAR_START||(LA13_0>=33 && LA13_0<=34)||LA13_0==39) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalPerl.g:1326:2: ( rulePVariableDeclaration )
                    {
                    // InternalPerl.g:1326:2: ( rulePVariableDeclaration )
                    // InternalPerl.g:1327:3: rulePVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPExpressionOrVarDeclarationAccess().getPVariableDeclarationParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPExpressionOrVarDeclarationAccess().getPVariableDeclarationParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1332:2: ( rulePExpression )
                    {
                    // InternalPerl.g:1332:2: ( rulePExpression )
                    // InternalPerl.g:1333:3: rulePExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPExpressionOrVarDeclarationAccess().getPExpressionParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPExpressionOrVarDeclarationAccess().getPExpressionParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__PExpressionOrVarDeclaration__Alternatives"


    // $ANTLR start "rule__PVariableDeclaration__Alternatives_1"
    // InternalPerl.g:1342:1: rule__PVariableDeclaration__Alternatives_1 : ( ( 'my' ) | ( 'our' ) | ( 'local' ) );
    public final void rule__PVariableDeclaration__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1346:1: ( ( 'my' ) | ( 'our' ) | ( 'local' ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt14=1;
                }
                break;
            case 43:
                {
                alt14=2;
                }
                break;
            case 44:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalPerl.g:1347:2: ( 'my' )
                    {
                    // InternalPerl.g:1347:2: ( 'my' )
                    // InternalPerl.g:1348:3: 'my'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPVariableDeclarationAccess().getMyKeyword_1_0()); 
                    }
                    match(input,42,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPVariableDeclarationAccess().getMyKeyword_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1353:2: ( 'our' )
                    {
                    // InternalPerl.g:1353:2: ( 'our' )
                    // InternalPerl.g:1354:3: 'our'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPVariableDeclarationAccess().getOurKeyword_1_1()); 
                    }
                    match(input,43,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPVariableDeclarationAccess().getOurKeyword_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1359:2: ( 'local' )
                    {
                    // InternalPerl.g:1359:2: ( 'local' )
                    // InternalPerl.g:1360:3: 'local'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPVariableDeclarationAccess().getLocalKeyword_1_2()); 
                    }
                    match(input,44,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPVariableDeclarationAccess().getLocalKeyword_1_2()); 
                    }

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
    // $ANTLR end "rule__PVariableDeclaration__Alternatives_1"


    // $ANTLR start "rule__Number__Alternatives"
    // InternalPerl.g:1369:1: rule__Number__Alternatives : ( ( RULE_HEX ) | ( RULE_BIN ) | ( RULE_OCT ) | ( RULE_INT ) );
    public final void rule__Number__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1373:1: ( ( RULE_HEX ) | ( RULE_BIN ) | ( RULE_OCT ) | ( RULE_INT ) )
            int alt15=4;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt15=1;
                }
                break;
            case RULE_BIN:
                {
                alt15=2;
                }
                break;
            case RULE_OCT:
                {
                alt15=3;
                }
                break;
            case RULE_INT:
                {
                alt15=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalPerl.g:1374:2: ( RULE_HEX )
                    {
                    // InternalPerl.g:1374:2: ( RULE_HEX )
                    // InternalPerl.g:1375:3: RULE_HEX
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0()); 
                    }
                    match(input,RULE_HEX,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1380:2: ( RULE_BIN )
                    {
                    // InternalPerl.g:1380:2: ( RULE_BIN )
                    // InternalPerl.g:1381:3: RULE_BIN
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberAccess().getBINTerminalRuleCall_1()); 
                    }
                    match(input,RULE_BIN,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberAccess().getBINTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1386:2: ( RULE_OCT )
                    {
                    // InternalPerl.g:1386:2: ( RULE_OCT )
                    // InternalPerl.g:1387:3: RULE_OCT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberAccess().getOCTTerminalRuleCall_2()); 
                    }
                    match(input,RULE_OCT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberAccess().getOCTTerminalRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1392:2: ( RULE_INT )
                    {
                    // InternalPerl.g:1392:2: ( RULE_INT )
                    // InternalPerl.g:1393:3: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_3()); 
                    }
                    match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_3()); 
                    }

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
    // $ANTLR end "rule__Number__Alternatives"


    // $ANTLR start "rule__PAssignment__Group_0__0"
    // InternalPerl.g:1402:1: rule__PAssignment__Group_0__0 : rule__PAssignment__Group_0__0__Impl rule__PAssignment__Group_0__1 ;
    public final void rule__PAssignment__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1406:1: ( rule__PAssignment__Group_0__0__Impl rule__PAssignment__Group_0__1 )
            // InternalPerl.g:1407:2: rule__PAssignment__Group_0__0__Impl rule__PAssignment__Group_0__1
            {
            pushFollow(FOLLOW_3);
            rule__PAssignment__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_0__0"


    // $ANTLR start "rule__PAssignment__Group_0__0__Impl"
    // InternalPerl.g:1414:1: rule__PAssignment__Group_0__0__Impl : ( () ) ;
    public final void rule__PAssignment__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1418:1: ( ( () ) )
            // InternalPerl.g:1419:1: ( () )
            {
            // InternalPerl.g:1419:1: ( () )
            // InternalPerl.g:1420:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getPAssignmentAction_0_0()); 
            }
            // InternalPerl.g:1421:2: ()
            // InternalPerl.g:1421:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getPAssignmentAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_0__0__Impl"


    // $ANTLR start "rule__PAssignment__Group_0__1"
    // InternalPerl.g:1429:1: rule__PAssignment__Group_0__1 : rule__PAssignment__Group_0__1__Impl rule__PAssignment__Group_0__2 ;
    public final void rule__PAssignment__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1433:1: ( rule__PAssignment__Group_0__1__Impl rule__PAssignment__Group_0__2 )
            // InternalPerl.g:1434:2: rule__PAssignment__Group_0__1__Impl rule__PAssignment__Group_0__2
            {
            pushFollow(FOLLOW_4);
            rule__PAssignment__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_0__1"


    // $ANTLR start "rule__PAssignment__Group_0__1__Impl"
    // InternalPerl.g:1441:1: rule__PAssignment__Group_0__1__Impl : ( ( rule__PAssignment__VarAssignment_0_1 ) ) ;
    public final void rule__PAssignment__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1445:1: ( ( ( rule__PAssignment__VarAssignment_0_1 ) ) )
            // InternalPerl.g:1446:1: ( ( rule__PAssignment__VarAssignment_0_1 ) )
            {
            // InternalPerl.g:1446:1: ( ( rule__PAssignment__VarAssignment_0_1 ) )
            // InternalPerl.g:1447:2: ( rule__PAssignment__VarAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getVarAssignment_0_1()); 
            }
            // InternalPerl.g:1448:2: ( rule__PAssignment__VarAssignment_0_1 )
            // InternalPerl.g:1448:3: rule__PAssignment__VarAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__VarAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getVarAssignment_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_0__1__Impl"


    // $ANTLR start "rule__PAssignment__Group_0__2"
    // InternalPerl.g:1456:1: rule__PAssignment__Group_0__2 : rule__PAssignment__Group_0__2__Impl rule__PAssignment__Group_0__3 ;
    public final void rule__PAssignment__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1460:1: ( rule__PAssignment__Group_0__2__Impl rule__PAssignment__Group_0__3 )
            // InternalPerl.g:1461:2: rule__PAssignment__Group_0__2__Impl rule__PAssignment__Group_0__3
            {
            pushFollow(FOLLOW_5);
            rule__PAssignment__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_0__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_0__2"


    // $ANTLR start "rule__PAssignment__Group_0__2__Impl"
    // InternalPerl.g:1468:1: rule__PAssignment__Group_0__2__Impl : ( ruleOpSingleAssign ) ;
    public final void rule__PAssignment__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1472:1: ( ( ruleOpSingleAssign ) )
            // InternalPerl.g:1473:1: ( ruleOpSingleAssign )
            {
            // InternalPerl.g:1473:1: ( ruleOpSingleAssign )
            // InternalPerl.g:1474:2: ruleOpSingleAssign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_0__2__Impl"


    // $ANTLR start "rule__PAssignment__Group_0__3"
    // InternalPerl.g:1483:1: rule__PAssignment__Group_0__3 : rule__PAssignment__Group_0__3__Impl ;
    public final void rule__PAssignment__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1487:1: ( rule__PAssignment__Group_0__3__Impl )
            // InternalPerl.g:1488:2: rule__PAssignment__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_0__3"


    // $ANTLR start "rule__PAssignment__Group_0__3__Impl"
    // InternalPerl.g:1494:1: rule__PAssignment__Group_0__3__Impl : ( ( rule__PAssignment__ValueAssignment_0_3 ) ) ;
    public final void rule__PAssignment__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1498:1: ( ( ( rule__PAssignment__ValueAssignment_0_3 ) ) )
            // InternalPerl.g:1499:1: ( ( rule__PAssignment__ValueAssignment_0_3 ) )
            {
            // InternalPerl.g:1499:1: ( ( rule__PAssignment__ValueAssignment_0_3 ) )
            // InternalPerl.g:1500:2: ( rule__PAssignment__ValueAssignment_0_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getValueAssignment_0_3()); 
            }
            // InternalPerl.g:1501:2: ( rule__PAssignment__ValueAssignment_0_3 )
            // InternalPerl.g:1501:3: rule__PAssignment__ValueAssignment_0_3
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__ValueAssignment_0_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getValueAssignment_0_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_0__3__Impl"


    // $ANTLR start "rule__PAssignment__Group_1__0"
    // InternalPerl.g:1510:1: rule__PAssignment__Group_1__0 : rule__PAssignment__Group_1__0__Impl rule__PAssignment__Group_1__1 ;
    public final void rule__PAssignment__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1514:1: ( rule__PAssignment__Group_1__0__Impl rule__PAssignment__Group_1__1 )
            // InternalPerl.g:1515:2: rule__PAssignment__Group_1__0__Impl rule__PAssignment__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__PAssignment__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1__0"


    // $ANTLR start "rule__PAssignment__Group_1__0__Impl"
    // InternalPerl.g:1522:1: rule__PAssignment__Group_1__0__Impl : ( rulePOrExpression ) ;
    public final void rule__PAssignment__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1526:1: ( ( rulePOrExpression ) )
            // InternalPerl.g:1527:1: ( rulePOrExpression )
            {
            // InternalPerl.g:1527:1: ( rulePOrExpression )
            // InternalPerl.g:1528:2: rulePOrExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getPOrExpressionParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePOrExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getPOrExpressionParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1__0__Impl"


    // $ANTLR start "rule__PAssignment__Group_1__1"
    // InternalPerl.g:1537:1: rule__PAssignment__Group_1__1 : rule__PAssignment__Group_1__1__Impl ;
    public final void rule__PAssignment__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1541:1: ( rule__PAssignment__Group_1__1__Impl )
            // InternalPerl.g:1542:2: rule__PAssignment__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1__1"


    // $ANTLR start "rule__PAssignment__Group_1__1__Impl"
    // InternalPerl.g:1548:1: rule__PAssignment__Group_1__1__Impl : ( ( rule__PAssignment__Group_1_1__0 )? ) ;
    public final void rule__PAssignment__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1552:1: ( ( ( rule__PAssignment__Group_1_1__0 )? ) )
            // InternalPerl.g:1553:1: ( ( rule__PAssignment__Group_1_1__0 )? )
            {
            // InternalPerl.g:1553:1: ( ( rule__PAssignment__Group_1_1__0 )? )
            // InternalPerl.g:1554:2: ( rule__PAssignment__Group_1_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getGroup_1_1()); 
            }
            // InternalPerl.g:1555:2: ( rule__PAssignment__Group_1_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=17 && LA16_0<=22)||(LA16_0>=28 && LA16_0<=29)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalPerl.g:1555:3: rule__PAssignment__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PAssignment__Group_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getGroup_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1__1__Impl"


    // $ANTLR start "rule__PAssignment__Group_1_1__0"
    // InternalPerl.g:1564:1: rule__PAssignment__Group_1_1__0 : rule__PAssignment__Group_1_1__0__Impl rule__PAssignment__Group_1_1__1 ;
    public final void rule__PAssignment__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1568:1: ( rule__PAssignment__Group_1_1__0__Impl rule__PAssignment__Group_1_1__1 )
            // InternalPerl.g:1569:2: rule__PAssignment__Group_1_1__0__Impl rule__PAssignment__Group_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__PAssignment__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1_1__0"


    // $ANTLR start "rule__PAssignment__Group_1_1__0__Impl"
    // InternalPerl.g:1576:1: rule__PAssignment__Group_1_1__0__Impl : ( ( rule__PAssignment__Group_1_1_0__0 ) ) ;
    public final void rule__PAssignment__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1580:1: ( ( ( rule__PAssignment__Group_1_1_0__0 ) ) )
            // InternalPerl.g:1581:1: ( ( rule__PAssignment__Group_1_1_0__0 ) )
            {
            // InternalPerl.g:1581:1: ( ( rule__PAssignment__Group_1_1_0__0 ) )
            // InternalPerl.g:1582:2: ( rule__PAssignment__Group_1_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getGroup_1_1_0()); 
            }
            // InternalPerl.g:1583:2: ( rule__PAssignment__Group_1_1_0__0 )
            // InternalPerl.g:1583:3: rule__PAssignment__Group_1_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_1_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getGroup_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1_1__0__Impl"


    // $ANTLR start "rule__PAssignment__Group_1_1__1"
    // InternalPerl.g:1591:1: rule__PAssignment__Group_1_1__1 : rule__PAssignment__Group_1_1__1__Impl ;
    public final void rule__PAssignment__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1595:1: ( rule__PAssignment__Group_1_1__1__Impl )
            // InternalPerl.g:1596:2: rule__PAssignment__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1_1__1"


    // $ANTLR start "rule__PAssignment__Group_1_1__1__Impl"
    // InternalPerl.g:1602:1: rule__PAssignment__Group_1_1__1__Impl : ( ( rule__PAssignment__RightOperandAssignment_1_1_1 ) ) ;
    public final void rule__PAssignment__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1606:1: ( ( ( rule__PAssignment__RightOperandAssignment_1_1_1 ) ) )
            // InternalPerl.g:1607:1: ( ( rule__PAssignment__RightOperandAssignment_1_1_1 ) )
            {
            // InternalPerl.g:1607:1: ( ( rule__PAssignment__RightOperandAssignment_1_1_1 ) )
            // InternalPerl.g:1608:2: ( rule__PAssignment__RightOperandAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getRightOperandAssignment_1_1_1()); 
            }
            // InternalPerl.g:1609:2: ( rule__PAssignment__RightOperandAssignment_1_1_1 )
            // InternalPerl.g:1609:3: rule__PAssignment__RightOperandAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__RightOperandAssignment_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getRightOperandAssignment_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1_1__1__Impl"


    // $ANTLR start "rule__PAssignment__Group_1_1_0__0"
    // InternalPerl.g:1618:1: rule__PAssignment__Group_1_1_0__0 : rule__PAssignment__Group_1_1_0__0__Impl ;
    public final void rule__PAssignment__Group_1_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1622:1: ( rule__PAssignment__Group_1_1_0__0__Impl )
            // InternalPerl.g:1623:2: rule__PAssignment__Group_1_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_1_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1_1_0__0"


    // $ANTLR start "rule__PAssignment__Group_1_1_0__0__Impl"
    // InternalPerl.g:1629:1: rule__PAssignment__Group_1_1_0__0__Impl : ( ( rule__PAssignment__Group_1_1_0_0__0 ) ) ;
    public final void rule__PAssignment__Group_1_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1633:1: ( ( ( rule__PAssignment__Group_1_1_0_0__0 ) ) )
            // InternalPerl.g:1634:1: ( ( rule__PAssignment__Group_1_1_0_0__0 ) )
            {
            // InternalPerl.g:1634:1: ( ( rule__PAssignment__Group_1_1_0_0__0 ) )
            // InternalPerl.g:1635:2: ( rule__PAssignment__Group_1_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getGroup_1_1_0_0()); 
            }
            // InternalPerl.g:1636:2: ( rule__PAssignment__Group_1_1_0_0__0 )
            // InternalPerl.g:1636:3: rule__PAssignment__Group_1_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_1_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getGroup_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1_1_0__0__Impl"


    // $ANTLR start "rule__PAssignment__Group_1_1_0_0__0"
    // InternalPerl.g:1645:1: rule__PAssignment__Group_1_1_0_0__0 : rule__PAssignment__Group_1_1_0_0__0__Impl rule__PAssignment__Group_1_1_0_0__1 ;
    public final void rule__PAssignment__Group_1_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1649:1: ( rule__PAssignment__Group_1_1_0_0__0__Impl rule__PAssignment__Group_1_1_0_0__1 )
            // InternalPerl.g:1650:2: rule__PAssignment__Group_1_1_0_0__0__Impl rule__PAssignment__Group_1_1_0_0__1
            {
            pushFollow(FOLLOW_6);
            rule__PAssignment__Group_1_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_1_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1_1_0_0__0"


    // $ANTLR start "rule__PAssignment__Group_1_1_0_0__0__Impl"
    // InternalPerl.g:1657:1: rule__PAssignment__Group_1_1_0_0__0__Impl : ( () ) ;
    public final void rule__PAssignment__Group_1_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1661:1: ( ( () ) )
            // InternalPerl.g:1662:1: ( () )
            {
            // InternalPerl.g:1662:1: ( () )
            // InternalPerl.g:1663:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getPBinaryOperationLeftOperandAction_1_1_0_0_0()); 
            }
            // InternalPerl.g:1664:2: ()
            // InternalPerl.g:1664:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getPBinaryOperationLeftOperandAction_1_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1_1_0_0__0__Impl"


    // $ANTLR start "rule__PAssignment__Group_1_1_0_0__1"
    // InternalPerl.g:1672:1: rule__PAssignment__Group_1_1_0_0__1 : rule__PAssignment__Group_1_1_0_0__1__Impl ;
    public final void rule__PAssignment__Group_1_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1676:1: ( rule__PAssignment__Group_1_1_0_0__1__Impl )
            // InternalPerl.g:1677:2: rule__PAssignment__Group_1_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__Group_1_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1_1_0_0__1"


    // $ANTLR start "rule__PAssignment__Group_1_1_0_0__1__Impl"
    // InternalPerl.g:1683:1: rule__PAssignment__Group_1_1_0_0__1__Impl : ( ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 ) ) ;
    public final void rule__PAssignment__Group_1_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1687:1: ( ( ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 ) ) )
            // InternalPerl.g:1688:1: ( ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 ) )
            {
            // InternalPerl.g:1688:1: ( ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 ) )
            // InternalPerl.g:1689:2: ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getFeatureAssignment_1_1_0_0_1()); 
            }
            // InternalPerl.g:1690:2: ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 )
            // InternalPerl.g:1690:3: rule__PAssignment__FeatureAssignment_1_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__FeatureAssignment_1_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getFeatureAssignment_1_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__Group_1_1_0_0__1__Impl"


    // $ANTLR start "rule__OpMultiAssign__Group_6__0"
    // InternalPerl.g:1699:1: rule__OpMultiAssign__Group_6__0 : rule__OpMultiAssign__Group_6__0__Impl rule__OpMultiAssign__Group_6__1 ;
    public final void rule__OpMultiAssign__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1703:1: ( rule__OpMultiAssign__Group_6__0__Impl rule__OpMultiAssign__Group_6__1 )
            // InternalPerl.g:1704:2: rule__OpMultiAssign__Group_6__0__Impl rule__OpMultiAssign__Group_6__1
            {
            pushFollow(FOLLOW_7);
            rule__OpMultiAssign__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalPerl.g:1711:1: rule__OpMultiAssign__Group_6__0__Impl : ( '<' ) ;
    public final void rule__OpMultiAssign__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1715:1: ( ( '<' ) )
            // InternalPerl.g:1716:1: ( '<' )
            {
            // InternalPerl.g:1716:1: ( '<' )
            // InternalPerl.g:1717:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_0()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_0()); 
            }

            }


            }

        }
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
    // InternalPerl.g:1726:1: rule__OpMultiAssign__Group_6__1 : rule__OpMultiAssign__Group_6__1__Impl rule__OpMultiAssign__Group_6__2 ;
    public final void rule__OpMultiAssign__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1730:1: ( rule__OpMultiAssign__Group_6__1__Impl rule__OpMultiAssign__Group_6__2 )
            // InternalPerl.g:1731:2: rule__OpMultiAssign__Group_6__1__Impl rule__OpMultiAssign__Group_6__2
            {
            pushFollow(FOLLOW_4);
            rule__OpMultiAssign__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalPerl.g:1738:1: rule__OpMultiAssign__Group_6__1__Impl : ( '<' ) ;
    public final void rule__OpMultiAssign__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1742:1: ( ( '<' ) )
            // InternalPerl.g:1743:1: ( '<' )
            {
            // InternalPerl.g:1743:1: ( '<' )
            // InternalPerl.g:1744:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_1()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_1()); 
            }

            }


            }

        }
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
    // InternalPerl.g:1753:1: rule__OpMultiAssign__Group_6__2 : rule__OpMultiAssign__Group_6__2__Impl ;
    public final void rule__OpMultiAssign__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1757:1: ( rule__OpMultiAssign__Group_6__2__Impl )
            // InternalPerl.g:1758:2: rule__OpMultiAssign__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalPerl.g:1764:1: rule__OpMultiAssign__Group_6__2__Impl : ( '=' ) ;
    public final void rule__OpMultiAssign__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1768:1: ( ( '=' ) )
            // InternalPerl.g:1769:1: ( '=' )
            {
            // InternalPerl.g:1769:1: ( '=' )
            // InternalPerl.g:1770:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_6_2()); 
            }
            match(input,14,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_6_2()); 
            }

            }


            }

        }
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
    // InternalPerl.g:1780:1: rule__OpMultiAssign__Group_7__0 : rule__OpMultiAssign__Group_7__0__Impl rule__OpMultiAssign__Group_7__1 ;
    public final void rule__OpMultiAssign__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1784:1: ( rule__OpMultiAssign__Group_7__0__Impl rule__OpMultiAssign__Group_7__1 )
            // InternalPerl.g:1785:2: rule__OpMultiAssign__Group_7__0__Impl rule__OpMultiAssign__Group_7__1
            {
            pushFollow(FOLLOW_8);
            rule__OpMultiAssign__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalPerl.g:1792:1: rule__OpMultiAssign__Group_7__0__Impl : ( '>' ) ;
    public final void rule__OpMultiAssign__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1796:1: ( ( '>' ) )
            // InternalPerl.g:1797:1: ( '>' )
            {
            // InternalPerl.g:1797:1: ( '>' )
            // InternalPerl.g:1798:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_0()); 
            }

            }


            }

        }
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
    // InternalPerl.g:1807:1: rule__OpMultiAssign__Group_7__1 : rule__OpMultiAssign__Group_7__1__Impl rule__OpMultiAssign__Group_7__2 ;
    public final void rule__OpMultiAssign__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1811:1: ( rule__OpMultiAssign__Group_7__1__Impl rule__OpMultiAssign__Group_7__2 )
            // InternalPerl.g:1812:2: rule__OpMultiAssign__Group_7__1__Impl rule__OpMultiAssign__Group_7__2
            {
            pushFollow(FOLLOW_8);
            rule__OpMultiAssign__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_7__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalPerl.g:1819:1: rule__OpMultiAssign__Group_7__1__Impl : ( ( '>' )? ) ;
    public final void rule__OpMultiAssign__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1823:1: ( ( ( '>' )? ) )
            // InternalPerl.g:1824:1: ( ( '>' )? )
            {
            // InternalPerl.g:1824:1: ( ( '>' )? )
            // InternalPerl.g:1825:2: ( '>' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_1()); 
            }
            // InternalPerl.g:1826:2: ( '>' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalPerl.g:1826:3: '>'
                    {
                    match(input,28,FOLLOW_2); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_1()); 
            }

            }


            }

        }
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
    // InternalPerl.g:1834:1: rule__OpMultiAssign__Group_7__2 : rule__OpMultiAssign__Group_7__2__Impl ;
    public final void rule__OpMultiAssign__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1838:1: ( rule__OpMultiAssign__Group_7__2__Impl )
            // InternalPerl.g:1839:2: rule__OpMultiAssign__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpMultiAssign__Group_7__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalPerl.g:1845:1: rule__OpMultiAssign__Group_7__2__Impl : ( '>=' ) ;
    public final void rule__OpMultiAssign__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1849:1: ( ( '>=' ) )
            // InternalPerl.g:1850:1: ( '>=' )
            {
            // InternalPerl.g:1850:1: ( '>=' )
            // InternalPerl.g:1851:2: '>='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_7_2()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_7_2()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__POrExpression__Group__0"
    // InternalPerl.g:1861:1: rule__POrExpression__Group__0 : rule__POrExpression__Group__0__Impl rule__POrExpression__Group__1 ;
    public final void rule__POrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1865:1: ( rule__POrExpression__Group__0__Impl rule__POrExpression__Group__1 )
            // InternalPerl.g:1866:2: rule__POrExpression__Group__0__Impl rule__POrExpression__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__POrExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__POrExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group__0"


    // $ANTLR start "rule__POrExpression__Group__0__Impl"
    // InternalPerl.g:1873:1: rule__POrExpression__Group__0__Impl : ( rulePAndExpression ) ;
    public final void rule__POrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1877:1: ( ( rulePAndExpression ) )
            // InternalPerl.g:1878:1: ( rulePAndExpression )
            {
            // InternalPerl.g:1878:1: ( rulePAndExpression )
            // InternalPerl.g:1879:2: rulePAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getPAndExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionAccess().getPAndExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group__0__Impl"


    // $ANTLR start "rule__POrExpression__Group__1"
    // InternalPerl.g:1888:1: rule__POrExpression__Group__1 : rule__POrExpression__Group__1__Impl ;
    public final void rule__POrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1892:1: ( rule__POrExpression__Group__1__Impl )
            // InternalPerl.g:1893:2: rule__POrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__POrExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group__1"


    // $ANTLR start "rule__POrExpression__Group__1__Impl"
    // InternalPerl.g:1899:1: rule__POrExpression__Group__1__Impl : ( ( rule__POrExpression__Group_1__0 )* ) ;
    public final void rule__POrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1903:1: ( ( ( rule__POrExpression__Group_1__0 )* ) )
            // InternalPerl.g:1904:1: ( ( rule__POrExpression__Group_1__0 )* )
            {
            // InternalPerl.g:1904:1: ( ( rule__POrExpression__Group_1__0 )* )
            // InternalPerl.g:1905:2: ( rule__POrExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:1906:2: ( rule__POrExpression__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==15) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalPerl.g:1906:3: rule__POrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__POrExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group__1__Impl"


    // $ANTLR start "rule__POrExpression__Group_1__0"
    // InternalPerl.g:1915:1: rule__POrExpression__Group_1__0 : rule__POrExpression__Group_1__0__Impl rule__POrExpression__Group_1__1 ;
    public final void rule__POrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1919:1: ( rule__POrExpression__Group_1__0__Impl rule__POrExpression__Group_1__1 )
            // InternalPerl.g:1920:2: rule__POrExpression__Group_1__0__Impl rule__POrExpression__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__POrExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__POrExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group_1__0"


    // $ANTLR start "rule__POrExpression__Group_1__0__Impl"
    // InternalPerl.g:1927:1: rule__POrExpression__Group_1__0__Impl : ( ( rule__POrExpression__Group_1_0__0 ) ) ;
    public final void rule__POrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1931:1: ( ( ( rule__POrExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:1932:1: ( ( rule__POrExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:1932:1: ( ( rule__POrExpression__Group_1_0__0 ) )
            // InternalPerl.g:1933:2: ( rule__POrExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:1934:2: ( rule__POrExpression__Group_1_0__0 )
            // InternalPerl.g:1934:3: rule__POrExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__POrExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group_1__0__Impl"


    // $ANTLR start "rule__POrExpression__Group_1__1"
    // InternalPerl.g:1942:1: rule__POrExpression__Group_1__1 : rule__POrExpression__Group_1__1__Impl ;
    public final void rule__POrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1946:1: ( rule__POrExpression__Group_1__1__Impl )
            // InternalPerl.g:1947:2: rule__POrExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__POrExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group_1__1"


    // $ANTLR start "rule__POrExpression__Group_1__1__Impl"
    // InternalPerl.g:1953:1: rule__POrExpression__Group_1__1__Impl : ( ( rule__POrExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__POrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1957:1: ( ( ( rule__POrExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:1958:1: ( ( rule__POrExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:1958:1: ( ( rule__POrExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:1959:2: ( rule__POrExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:1960:2: ( rule__POrExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:1960:3: rule__POrExpression__RightOperandAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__POrExpression__RightOperandAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionAccess().getRightOperandAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group_1__1__Impl"


    // $ANTLR start "rule__POrExpression__Group_1_0__0"
    // InternalPerl.g:1969:1: rule__POrExpression__Group_1_0__0 : rule__POrExpression__Group_1_0__0__Impl ;
    public final void rule__POrExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1973:1: ( rule__POrExpression__Group_1_0__0__Impl )
            // InternalPerl.g:1974:2: rule__POrExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__POrExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group_1_0__0"


    // $ANTLR start "rule__POrExpression__Group_1_0__0__Impl"
    // InternalPerl.g:1980:1: rule__POrExpression__Group_1_0__0__Impl : ( ( rule__POrExpression__Group_1_0_0__0 ) ) ;
    public final void rule__POrExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1984:1: ( ( ( rule__POrExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:1985:1: ( ( rule__POrExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:1985:1: ( ( rule__POrExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:1986:2: ( rule__POrExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:1987:2: ( rule__POrExpression__Group_1_0_0__0 )
            // InternalPerl.g:1987:3: rule__POrExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__POrExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__POrExpression__Group_1_0_0__0"
    // InternalPerl.g:1996:1: rule__POrExpression__Group_1_0_0__0 : rule__POrExpression__Group_1_0_0__0__Impl rule__POrExpression__Group_1_0_0__1 ;
    public final void rule__POrExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2000:1: ( rule__POrExpression__Group_1_0_0__0__Impl rule__POrExpression__Group_1_0_0__1 )
            // InternalPerl.g:2001:2: rule__POrExpression__Group_1_0_0__0__Impl rule__POrExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_9);
            rule__POrExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__POrExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group_1_0_0__0"


    // $ANTLR start "rule__POrExpression__Group_1_0_0__0__Impl"
    // InternalPerl.g:2008:1: rule__POrExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__POrExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2012:1: ( ( () ) )
            // InternalPerl.g:2013:1: ( () )
            {
            // InternalPerl.g:2013:1: ( () )
            // InternalPerl.g:2014:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:2015:2: ()
            // InternalPerl.g:2015:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__POrExpression__Group_1_0_0__1"
    // InternalPerl.g:2023:1: rule__POrExpression__Group_1_0_0__1 : rule__POrExpression__Group_1_0_0__1__Impl ;
    public final void rule__POrExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2027:1: ( rule__POrExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:2028:2: rule__POrExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__POrExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group_1_0_0__1"


    // $ANTLR start "rule__POrExpression__Group_1_0_0__1__Impl"
    // InternalPerl.g:2034:1: rule__POrExpression__Group_1_0_0__1__Impl : ( ( rule__POrExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__POrExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2038:1: ( ( ( rule__POrExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:2039:1: ( ( rule__POrExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:2039:1: ( ( rule__POrExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:2040:2: ( rule__POrExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:2041:2: ( rule__POrExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:2041:3: rule__POrExpression__FeatureAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__POrExpression__FeatureAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__PAndExpression__Group__0"
    // InternalPerl.g:2050:1: rule__PAndExpression__Group__0 : rule__PAndExpression__Group__0__Impl rule__PAndExpression__Group__1 ;
    public final void rule__PAndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2054:1: ( rule__PAndExpression__Group__0__Impl rule__PAndExpression__Group__1 )
            // InternalPerl.g:2055:2: rule__PAndExpression__Group__0__Impl rule__PAndExpression__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__PAndExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAndExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group__0"


    // $ANTLR start "rule__PAndExpression__Group__0__Impl"
    // InternalPerl.g:2062:1: rule__PAndExpression__Group__0__Impl : ( rulePEqualityExpression ) ;
    public final void rule__PAndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2066:1: ( ( rulePEqualityExpression ) )
            // InternalPerl.g:2067:1: ( rulePEqualityExpression )
            {
            // InternalPerl.g:2067:1: ( rulePEqualityExpression )
            // InternalPerl.g:2068:2: rulePEqualityExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getPEqualityExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePEqualityExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionAccess().getPEqualityExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group__0__Impl"


    // $ANTLR start "rule__PAndExpression__Group__1"
    // InternalPerl.g:2077:1: rule__PAndExpression__Group__1 : rule__PAndExpression__Group__1__Impl ;
    public final void rule__PAndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2081:1: ( rule__PAndExpression__Group__1__Impl )
            // InternalPerl.g:2082:2: rule__PAndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAndExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group__1"


    // $ANTLR start "rule__PAndExpression__Group__1__Impl"
    // InternalPerl.g:2088:1: rule__PAndExpression__Group__1__Impl : ( ( rule__PAndExpression__Group_1__0 )* ) ;
    public final void rule__PAndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2092:1: ( ( ( rule__PAndExpression__Group_1__0 )* ) )
            // InternalPerl.g:2093:1: ( ( rule__PAndExpression__Group_1__0 )* )
            {
            // InternalPerl.g:2093:1: ( ( rule__PAndExpression__Group_1__0 )* )
            // InternalPerl.g:2094:2: ( rule__PAndExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:2095:2: ( rule__PAndExpression__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==16) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalPerl.g:2095:3: rule__PAndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__PAndExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group__1__Impl"


    // $ANTLR start "rule__PAndExpression__Group_1__0"
    // InternalPerl.g:2104:1: rule__PAndExpression__Group_1__0 : rule__PAndExpression__Group_1__0__Impl rule__PAndExpression__Group_1__1 ;
    public final void rule__PAndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2108:1: ( rule__PAndExpression__Group_1__0__Impl rule__PAndExpression__Group_1__1 )
            // InternalPerl.g:2109:2: rule__PAndExpression__Group_1__0__Impl rule__PAndExpression__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__PAndExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAndExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group_1__0"


    // $ANTLR start "rule__PAndExpression__Group_1__0__Impl"
    // InternalPerl.g:2116:1: rule__PAndExpression__Group_1__0__Impl : ( ( rule__PAndExpression__Group_1_0__0 ) ) ;
    public final void rule__PAndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2120:1: ( ( ( rule__PAndExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:2121:1: ( ( rule__PAndExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:2121:1: ( ( rule__PAndExpression__Group_1_0__0 ) )
            // InternalPerl.g:2122:2: ( rule__PAndExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:2123:2: ( rule__PAndExpression__Group_1_0__0 )
            // InternalPerl.g:2123:3: rule__PAndExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PAndExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PAndExpression__Group_1__1"
    // InternalPerl.g:2131:1: rule__PAndExpression__Group_1__1 : rule__PAndExpression__Group_1__1__Impl ;
    public final void rule__PAndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2135:1: ( rule__PAndExpression__Group_1__1__Impl )
            // InternalPerl.g:2136:2: rule__PAndExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAndExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group_1__1"


    // $ANTLR start "rule__PAndExpression__Group_1__1__Impl"
    // InternalPerl.g:2142:1: rule__PAndExpression__Group_1__1__Impl : ( ( rule__PAndExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PAndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2146:1: ( ( ( rule__PAndExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:2147:1: ( ( rule__PAndExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:2147:1: ( ( rule__PAndExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:2148:2: ( rule__PAndExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:2149:2: ( rule__PAndExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:2149:3: rule__PAndExpression__RightOperandAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PAndExpression__RightOperandAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionAccess().getRightOperandAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group_1__1__Impl"


    // $ANTLR start "rule__PAndExpression__Group_1_0__0"
    // InternalPerl.g:2158:1: rule__PAndExpression__Group_1_0__0 : rule__PAndExpression__Group_1_0__0__Impl ;
    public final void rule__PAndExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2162:1: ( rule__PAndExpression__Group_1_0__0__Impl )
            // InternalPerl.g:2163:2: rule__PAndExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAndExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group_1_0__0"


    // $ANTLR start "rule__PAndExpression__Group_1_0__0__Impl"
    // InternalPerl.g:2169:1: rule__PAndExpression__Group_1_0__0__Impl : ( ( rule__PAndExpression__Group_1_0_0__0 ) ) ;
    public final void rule__PAndExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2173:1: ( ( ( rule__PAndExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:2174:1: ( ( rule__PAndExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:2174:1: ( ( rule__PAndExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:2175:2: ( rule__PAndExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:2176:2: ( rule__PAndExpression__Group_1_0_0__0 )
            // InternalPerl.g:2176:3: rule__PAndExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PAndExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__PAndExpression__Group_1_0_0__0"
    // InternalPerl.g:2185:1: rule__PAndExpression__Group_1_0_0__0 : rule__PAndExpression__Group_1_0_0__0__Impl rule__PAndExpression__Group_1_0_0__1 ;
    public final void rule__PAndExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2189:1: ( rule__PAndExpression__Group_1_0_0__0__Impl rule__PAndExpression__Group_1_0_0__1 )
            // InternalPerl.g:2190:2: rule__PAndExpression__Group_1_0_0__0__Impl rule__PAndExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_11);
            rule__PAndExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAndExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group_1_0_0__0"


    // $ANTLR start "rule__PAndExpression__Group_1_0_0__0__Impl"
    // InternalPerl.g:2197:1: rule__PAndExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PAndExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2201:1: ( ( () ) )
            // InternalPerl.g:2202:1: ( () )
            {
            // InternalPerl.g:2202:1: ( () )
            // InternalPerl.g:2203:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:2204:2: ()
            // InternalPerl.g:2204:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__PAndExpression__Group_1_0_0__1"
    // InternalPerl.g:2212:1: rule__PAndExpression__Group_1_0_0__1 : rule__PAndExpression__Group_1_0_0__1__Impl ;
    public final void rule__PAndExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2216:1: ( rule__PAndExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:2217:2: rule__PAndExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAndExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group_1_0_0__1"


    // $ANTLR start "rule__PAndExpression__Group_1_0_0__1__Impl"
    // InternalPerl.g:2223:1: rule__PAndExpression__Group_1_0_0__1__Impl : ( ( rule__PAndExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PAndExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2227:1: ( ( ( rule__PAndExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:2228:1: ( ( rule__PAndExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:2228:1: ( ( rule__PAndExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:2229:2: ( rule__PAndExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:2230:2: ( rule__PAndExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:2230:3: rule__PAndExpression__FeatureAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PAndExpression__FeatureAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__PEqualityExpression__Group__0"
    // InternalPerl.g:2239:1: rule__PEqualityExpression__Group__0 : rule__PEqualityExpression__Group__0__Impl rule__PEqualityExpression__Group__1 ;
    public final void rule__PEqualityExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2243:1: ( rule__PEqualityExpression__Group__0__Impl rule__PEqualityExpression__Group__1 )
            // InternalPerl.g:2244:2: rule__PEqualityExpression__Group__0__Impl rule__PEqualityExpression__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__PEqualityExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group__0"


    // $ANTLR start "rule__PEqualityExpression__Group__0__Impl"
    // InternalPerl.g:2251:1: rule__PEqualityExpression__Group__0__Impl : ( rulePRelationalExpression ) ;
    public final void rule__PEqualityExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2255:1: ( ( rulePRelationalExpression ) )
            // InternalPerl.g:2256:1: ( rulePRelationalExpression )
            {
            // InternalPerl.g:2256:1: ( rulePRelationalExpression )
            // InternalPerl.g:2257:2: rulePRelationalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getPRelationalExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePRelationalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionAccess().getPRelationalExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group__0__Impl"


    // $ANTLR start "rule__PEqualityExpression__Group__1"
    // InternalPerl.g:2266:1: rule__PEqualityExpression__Group__1 : rule__PEqualityExpression__Group__1__Impl ;
    public final void rule__PEqualityExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2270:1: ( rule__PEqualityExpression__Group__1__Impl )
            // InternalPerl.g:2271:2: rule__PEqualityExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group__1"


    // $ANTLR start "rule__PEqualityExpression__Group__1__Impl"
    // InternalPerl.g:2277:1: rule__PEqualityExpression__Group__1__Impl : ( ( rule__PEqualityExpression__Group_1__0 )* ) ;
    public final void rule__PEqualityExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2281:1: ( ( ( rule__PEqualityExpression__Group_1__0 )* ) )
            // InternalPerl.g:2282:1: ( ( rule__PEqualityExpression__Group_1__0 )* )
            {
            // InternalPerl.g:2282:1: ( ( rule__PEqualityExpression__Group_1__0 )* )
            // InternalPerl.g:2283:2: ( rule__PEqualityExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:2284:2: ( rule__PEqualityExpression__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=23 && LA20_0<=26)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalPerl.g:2284:3: rule__PEqualityExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__PEqualityExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group__1__Impl"


    // $ANTLR start "rule__PEqualityExpression__Group_1__0"
    // InternalPerl.g:2293:1: rule__PEqualityExpression__Group_1__0 : rule__PEqualityExpression__Group_1__0__Impl rule__PEqualityExpression__Group_1__1 ;
    public final void rule__PEqualityExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2297:1: ( rule__PEqualityExpression__Group_1__0__Impl rule__PEqualityExpression__Group_1__1 )
            // InternalPerl.g:2298:2: rule__PEqualityExpression__Group_1__0__Impl rule__PEqualityExpression__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__PEqualityExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group_1__0"


    // $ANTLR start "rule__PEqualityExpression__Group_1__0__Impl"
    // InternalPerl.g:2305:1: rule__PEqualityExpression__Group_1__0__Impl : ( ( rule__PEqualityExpression__Group_1_0__0 ) ) ;
    public final void rule__PEqualityExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2309:1: ( ( ( rule__PEqualityExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:2310:1: ( ( rule__PEqualityExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:2310:1: ( ( rule__PEqualityExpression__Group_1_0__0 ) )
            // InternalPerl.g:2311:2: ( rule__PEqualityExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:2312:2: ( rule__PEqualityExpression__Group_1_0__0 )
            // InternalPerl.g:2312:3: rule__PEqualityExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PEqualityExpression__Group_1__1"
    // InternalPerl.g:2320:1: rule__PEqualityExpression__Group_1__1 : rule__PEqualityExpression__Group_1__1__Impl ;
    public final void rule__PEqualityExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2324:1: ( rule__PEqualityExpression__Group_1__1__Impl )
            // InternalPerl.g:2325:2: rule__PEqualityExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group_1__1"


    // $ANTLR start "rule__PEqualityExpression__Group_1__1__Impl"
    // InternalPerl.g:2331:1: rule__PEqualityExpression__Group_1__1__Impl : ( ( rule__PEqualityExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PEqualityExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2335:1: ( ( ( rule__PEqualityExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:2336:1: ( ( rule__PEqualityExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:2336:1: ( ( rule__PEqualityExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:2337:2: ( rule__PEqualityExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:2338:2: ( rule__PEqualityExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:2338:3: rule__PEqualityExpression__RightOperandAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__RightOperandAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionAccess().getRightOperandAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group_1__1__Impl"


    // $ANTLR start "rule__PEqualityExpression__Group_1_0__0"
    // InternalPerl.g:2347:1: rule__PEqualityExpression__Group_1_0__0 : rule__PEqualityExpression__Group_1_0__0__Impl ;
    public final void rule__PEqualityExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2351:1: ( rule__PEqualityExpression__Group_1_0__0__Impl )
            // InternalPerl.g:2352:2: rule__PEqualityExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group_1_0__0"


    // $ANTLR start "rule__PEqualityExpression__Group_1_0__0__Impl"
    // InternalPerl.g:2358:1: rule__PEqualityExpression__Group_1_0__0__Impl : ( ( rule__PEqualityExpression__Group_1_0_0__0 ) ) ;
    public final void rule__PEqualityExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2362:1: ( ( ( rule__PEqualityExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:2363:1: ( ( rule__PEqualityExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:2363:1: ( ( rule__PEqualityExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:2364:2: ( rule__PEqualityExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:2365:2: ( rule__PEqualityExpression__Group_1_0_0__0 )
            // InternalPerl.g:2365:3: rule__PEqualityExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__PEqualityExpression__Group_1_0_0__0"
    // InternalPerl.g:2374:1: rule__PEqualityExpression__Group_1_0_0__0 : rule__PEqualityExpression__Group_1_0_0__0__Impl rule__PEqualityExpression__Group_1_0_0__1 ;
    public final void rule__PEqualityExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2378:1: ( rule__PEqualityExpression__Group_1_0_0__0__Impl rule__PEqualityExpression__Group_1_0_0__1 )
            // InternalPerl.g:2379:2: rule__PEqualityExpression__Group_1_0_0__0__Impl rule__PEqualityExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_13);
            rule__PEqualityExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group_1_0_0__0"


    // $ANTLR start "rule__PEqualityExpression__Group_1_0_0__0__Impl"
    // InternalPerl.g:2386:1: rule__PEqualityExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PEqualityExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2390:1: ( ( () ) )
            // InternalPerl.g:2391:1: ( () )
            {
            // InternalPerl.g:2391:1: ( () )
            // InternalPerl.g:2392:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:2393:2: ()
            // InternalPerl.g:2393:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__PEqualityExpression__Group_1_0_0__1"
    // InternalPerl.g:2401:1: rule__PEqualityExpression__Group_1_0_0__1 : rule__PEqualityExpression__Group_1_0_0__1__Impl ;
    public final void rule__PEqualityExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2405:1: ( rule__PEqualityExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:2406:2: rule__PEqualityExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group_1_0_0__1"


    // $ANTLR start "rule__PEqualityExpression__Group_1_0_0__1__Impl"
    // InternalPerl.g:2412:1: rule__PEqualityExpression__Group_1_0_0__1__Impl : ( ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PEqualityExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2416:1: ( ( ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:2417:1: ( ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:2417:1: ( ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:2418:2: ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:2419:2: ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:2419:3: rule__PEqualityExpression__FeatureAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PEqualityExpression__FeatureAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__PRelationalExpression__Group__0"
    // InternalPerl.g:2428:1: rule__PRelationalExpression__Group__0 : rule__PRelationalExpression__Group__0__Impl rule__PRelationalExpression__Group__1 ;
    public final void rule__PRelationalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2432:1: ( rule__PRelationalExpression__Group__0__Impl rule__PRelationalExpression__Group__1 )
            // InternalPerl.g:2433:2: rule__PRelationalExpression__Group__0__Impl rule__PRelationalExpression__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__PRelationalExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group__0"


    // $ANTLR start "rule__PRelationalExpression__Group__0__Impl"
    // InternalPerl.g:2440:1: rule__PRelationalExpression__Group__0__Impl : ( rulePOtherOperatorExpression ) ;
    public final void rule__PRelationalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2444:1: ( ( rulePOtherOperatorExpression ) )
            // InternalPerl.g:2445:1: ( rulePOtherOperatorExpression )
            {
            // InternalPerl.g:2445:1: ( rulePOtherOperatorExpression )
            // InternalPerl.g:2446:2: rulePOtherOperatorExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getPOtherOperatorExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionAccess().getPOtherOperatorExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group__0__Impl"


    // $ANTLR start "rule__PRelationalExpression__Group__1"
    // InternalPerl.g:2455:1: rule__PRelationalExpression__Group__1 : rule__PRelationalExpression__Group__1__Impl ;
    public final void rule__PRelationalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2459:1: ( rule__PRelationalExpression__Group__1__Impl )
            // InternalPerl.g:2460:2: rule__PRelationalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group__1"


    // $ANTLR start "rule__PRelationalExpression__Group__1__Impl"
    // InternalPerl.g:2466:1: rule__PRelationalExpression__Group__1__Impl : ( ( rule__PRelationalExpression__Group_1__0 )* ) ;
    public final void rule__PRelationalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2470:1: ( ( ( rule__PRelationalExpression__Group_1__0 )* ) )
            // InternalPerl.g:2471:1: ( ( rule__PRelationalExpression__Group_1__0 )* )
            {
            // InternalPerl.g:2471:1: ( ( rule__PRelationalExpression__Group_1__0 )* )
            // InternalPerl.g:2472:2: ( rule__PRelationalExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:2473:2: ( rule__PRelationalExpression__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2==14||(LA21_2>=33 && LA21_2<=34)||LA21_2==39) ) {
                        alt21=1;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA21_3 = input.LA(2);

                    if ( ((LA21_3>=33 && LA21_3<=34)||LA21_3==39) ) {
                        alt21=1;
                    }


                    }
                    break;
                case 27:
                    {
                    alt21=1;
                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // InternalPerl.g:2473:3: rule__PRelationalExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__PRelationalExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group__1__Impl"


    // $ANTLR start "rule__PRelationalExpression__Group_1__0"
    // InternalPerl.g:2482:1: rule__PRelationalExpression__Group_1__0 : rule__PRelationalExpression__Group_1__0__Impl rule__PRelationalExpression__Group_1__1 ;
    public final void rule__PRelationalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2486:1: ( rule__PRelationalExpression__Group_1__0__Impl rule__PRelationalExpression__Group_1__1 )
            // InternalPerl.g:2487:2: rule__PRelationalExpression__Group_1__0__Impl rule__PRelationalExpression__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__PRelationalExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group_1__0"


    // $ANTLR start "rule__PRelationalExpression__Group_1__0__Impl"
    // InternalPerl.g:2494:1: rule__PRelationalExpression__Group_1__0__Impl : ( ( rule__PRelationalExpression__Group_1_0__0 ) ) ;
    public final void rule__PRelationalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2498:1: ( ( ( rule__PRelationalExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:2499:1: ( ( rule__PRelationalExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:2499:1: ( ( rule__PRelationalExpression__Group_1_0__0 ) )
            // InternalPerl.g:2500:2: ( rule__PRelationalExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:2501:2: ( rule__PRelationalExpression__Group_1_0__0 )
            // InternalPerl.g:2501:3: rule__PRelationalExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PRelationalExpression__Group_1__1"
    // InternalPerl.g:2509:1: rule__PRelationalExpression__Group_1__1 : rule__PRelationalExpression__Group_1__1__Impl ;
    public final void rule__PRelationalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2513:1: ( rule__PRelationalExpression__Group_1__1__Impl )
            // InternalPerl.g:2514:2: rule__PRelationalExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group_1__1"


    // $ANTLR start "rule__PRelationalExpression__Group_1__1__Impl"
    // InternalPerl.g:2520:1: rule__PRelationalExpression__Group_1__1__Impl : ( ( rule__PRelationalExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PRelationalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2524:1: ( ( ( rule__PRelationalExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:2525:1: ( ( rule__PRelationalExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:2525:1: ( ( rule__PRelationalExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:2526:2: ( rule__PRelationalExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:2527:2: ( rule__PRelationalExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:2527:3: rule__PRelationalExpression__RightOperandAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__RightOperandAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionAccess().getRightOperandAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group_1__1__Impl"


    // $ANTLR start "rule__PRelationalExpression__Group_1_0__0"
    // InternalPerl.g:2536:1: rule__PRelationalExpression__Group_1_0__0 : rule__PRelationalExpression__Group_1_0__0__Impl ;
    public final void rule__PRelationalExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2540:1: ( rule__PRelationalExpression__Group_1_0__0__Impl )
            // InternalPerl.g:2541:2: rule__PRelationalExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group_1_0__0"


    // $ANTLR start "rule__PRelationalExpression__Group_1_0__0__Impl"
    // InternalPerl.g:2547:1: rule__PRelationalExpression__Group_1_0__0__Impl : ( ( rule__PRelationalExpression__Group_1_0_0__0 ) ) ;
    public final void rule__PRelationalExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2551:1: ( ( ( rule__PRelationalExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:2552:1: ( ( rule__PRelationalExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:2552:1: ( ( rule__PRelationalExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:2553:2: ( rule__PRelationalExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:2554:2: ( rule__PRelationalExpression__Group_1_0_0__0 )
            // InternalPerl.g:2554:3: rule__PRelationalExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__PRelationalExpression__Group_1_0_0__0"
    // InternalPerl.g:2563:1: rule__PRelationalExpression__Group_1_0_0__0 : rule__PRelationalExpression__Group_1_0_0__0__Impl rule__PRelationalExpression__Group_1_0_0__1 ;
    public final void rule__PRelationalExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2567:1: ( rule__PRelationalExpression__Group_1_0_0__0__Impl rule__PRelationalExpression__Group_1_0_0__1 )
            // InternalPerl.g:2568:2: rule__PRelationalExpression__Group_1_0_0__0__Impl rule__PRelationalExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_15);
            rule__PRelationalExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group_1_0_0__0"


    // $ANTLR start "rule__PRelationalExpression__Group_1_0_0__0__Impl"
    // InternalPerl.g:2575:1: rule__PRelationalExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PRelationalExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2579:1: ( ( () ) )
            // InternalPerl.g:2580:1: ( () )
            {
            // InternalPerl.g:2580:1: ( () )
            // InternalPerl.g:2581:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:2582:2: ()
            // InternalPerl.g:2582:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__PRelationalExpression__Group_1_0_0__1"
    // InternalPerl.g:2590:1: rule__PRelationalExpression__Group_1_0_0__1 : rule__PRelationalExpression__Group_1_0_0__1__Impl ;
    public final void rule__PRelationalExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2594:1: ( rule__PRelationalExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:2595:2: rule__PRelationalExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group_1_0_0__1"


    // $ANTLR start "rule__PRelationalExpression__Group_1_0_0__1__Impl"
    // InternalPerl.g:2601:1: rule__PRelationalExpression__Group_1_0_0__1__Impl : ( ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PRelationalExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2605:1: ( ( ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:2606:1: ( ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:2606:1: ( ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:2607:2: ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:2608:2: ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:2608:3: rule__PRelationalExpression__FeatureAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PRelationalExpression__FeatureAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__OpCompare__Group_1__0"
    // InternalPerl.g:2617:1: rule__OpCompare__Group_1__0 : rule__OpCompare__Group_1__0__Impl rule__OpCompare__Group_1__1 ;
    public final void rule__OpCompare__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2621:1: ( rule__OpCompare__Group_1__0__Impl rule__OpCompare__Group_1__1 )
            // InternalPerl.g:2622:2: rule__OpCompare__Group_1__0__Impl rule__OpCompare__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__OpCompare__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpCompare__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpCompare__Group_1__0"


    // $ANTLR start "rule__OpCompare__Group_1__0__Impl"
    // InternalPerl.g:2629:1: rule__OpCompare__Group_1__0__Impl : ( '<' ) ;
    public final void rule__OpCompare__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2633:1: ( ( '<' ) )
            // InternalPerl.g:2634:1: ( '<' )
            {
            // InternalPerl.g:2634:1: ( '<' )
            // InternalPerl.g:2635:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpCompare__Group_1__0__Impl"


    // $ANTLR start "rule__OpCompare__Group_1__1"
    // InternalPerl.g:2644:1: rule__OpCompare__Group_1__1 : rule__OpCompare__Group_1__1__Impl ;
    public final void rule__OpCompare__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2648:1: ( rule__OpCompare__Group_1__1__Impl )
            // InternalPerl.g:2649:2: rule__OpCompare__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpCompare__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpCompare__Group_1__1"


    // $ANTLR start "rule__OpCompare__Group_1__1__Impl"
    // InternalPerl.g:2655:1: rule__OpCompare__Group_1__1__Impl : ( '=' ) ;
    public final void rule__OpCompare__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2659:1: ( ( '=' ) )
            // InternalPerl.g:2660:1: ( '=' )
            {
            // InternalPerl.g:2660:1: ( '=' )
            // InternalPerl.g:2661:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); 
            }
            match(input,14,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpCompare__Group_1__1__Impl"


    // $ANTLR start "rule__POtherOperatorExpression__Group__0"
    // InternalPerl.g:2671:1: rule__POtherOperatorExpression__Group__0 : rule__POtherOperatorExpression__Group__0__Impl rule__POtherOperatorExpression__Group__1 ;
    public final void rule__POtherOperatorExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2675:1: ( rule__POtherOperatorExpression__Group__0__Impl rule__POtherOperatorExpression__Group__1 )
            // InternalPerl.g:2676:2: rule__POtherOperatorExpression__Group__0__Impl rule__POtherOperatorExpression__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__POtherOperatorExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group__0"


    // $ANTLR start "rule__POtherOperatorExpression__Group__0__Impl"
    // InternalPerl.g:2683:1: rule__POtherOperatorExpression__Group__0__Impl : ( rulePAdditiveExpression ) ;
    public final void rule__POtherOperatorExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2687:1: ( ( rulePAdditiveExpression ) )
            // InternalPerl.g:2688:1: ( rulePAdditiveExpression )
            {
            // InternalPerl.g:2688:1: ( rulePAdditiveExpression )
            // InternalPerl.g:2689:2: rulePAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getPAdditiveExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePAdditiveExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionAccess().getPAdditiveExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group__0__Impl"


    // $ANTLR start "rule__POtherOperatorExpression__Group__1"
    // InternalPerl.g:2698:1: rule__POtherOperatorExpression__Group__1 : rule__POtherOperatorExpression__Group__1__Impl ;
    public final void rule__POtherOperatorExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2702:1: ( rule__POtherOperatorExpression__Group__1__Impl )
            // InternalPerl.g:2703:2: rule__POtherOperatorExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group__1"


    // $ANTLR start "rule__POtherOperatorExpression__Group__1__Impl"
    // InternalPerl.g:2709:1: rule__POtherOperatorExpression__Group__1__Impl : ( ( rule__POtherOperatorExpression__Group_1__0 )* ) ;
    public final void rule__POtherOperatorExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2713:1: ( ( ( rule__POtherOperatorExpression__Group_1__0 )* ) )
            // InternalPerl.g:2714:1: ( ( rule__POtherOperatorExpression__Group_1__0 )* )
            {
            // InternalPerl.g:2714:1: ( ( rule__POtherOperatorExpression__Group_1__0 )* )
            // InternalPerl.g:2715:2: ( rule__POtherOperatorExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:2716:2: ( rule__POtherOperatorExpression__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    int LA22_2 = input.LA(2);

                    if ( (LA22_2==29) ) {
                        int LA22_5 = input.LA(3);

                        if ( (LA22_5==29||(LA22_5>=33 && LA22_5<=34)||LA22_5==39) ) {
                            alt22=1;
                        }


                    }
                    else if ( (LA22_2==32) ) {
                        alt22=1;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA22_3 = input.LA(2);

                    if ( (LA22_3==28) ) {
                        int LA22_6 = input.LA(3);

                        if ( (LA22_6==28||(LA22_6>=33 && LA22_6<=34)||LA22_6==39) ) {
                            alt22=1;
                        }


                    }


                    }
                    break;
                case 30:
                case 31:
                    {
                    alt22=1;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // InternalPerl.g:2716:3: rule__POtherOperatorExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__POtherOperatorExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group__1__Impl"


    // $ANTLR start "rule__POtherOperatorExpression__Group_1__0"
    // InternalPerl.g:2725:1: rule__POtherOperatorExpression__Group_1__0 : rule__POtherOperatorExpression__Group_1__0__Impl rule__POtherOperatorExpression__Group_1__1 ;
    public final void rule__POtherOperatorExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2729:1: ( rule__POtherOperatorExpression__Group_1__0__Impl rule__POtherOperatorExpression__Group_1__1 )
            // InternalPerl.g:2730:2: rule__POtherOperatorExpression__Group_1__0__Impl rule__POtherOperatorExpression__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__POtherOperatorExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group_1__0"


    // $ANTLR start "rule__POtherOperatorExpression__Group_1__0__Impl"
    // InternalPerl.g:2737:1: rule__POtherOperatorExpression__Group_1__0__Impl : ( ( rule__POtherOperatorExpression__Group_1_0__0 ) ) ;
    public final void rule__POtherOperatorExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2741:1: ( ( ( rule__POtherOperatorExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:2742:1: ( ( rule__POtherOperatorExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:2742:1: ( ( rule__POtherOperatorExpression__Group_1_0__0 ) )
            // InternalPerl.g:2743:2: ( rule__POtherOperatorExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:2744:2: ( rule__POtherOperatorExpression__Group_1_0__0 )
            // InternalPerl.g:2744:3: rule__POtherOperatorExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group_1__0__Impl"


    // $ANTLR start "rule__POtherOperatorExpression__Group_1__1"
    // InternalPerl.g:2752:1: rule__POtherOperatorExpression__Group_1__1 : rule__POtherOperatorExpression__Group_1__1__Impl ;
    public final void rule__POtherOperatorExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2756:1: ( rule__POtherOperatorExpression__Group_1__1__Impl )
            // InternalPerl.g:2757:2: rule__POtherOperatorExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group_1__1"


    // $ANTLR start "rule__POtherOperatorExpression__Group_1__1__Impl"
    // InternalPerl.g:2763:1: rule__POtherOperatorExpression__Group_1__1__Impl : ( ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__POtherOperatorExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2767:1: ( ( ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:2768:1: ( ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:2768:1: ( ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:2769:2: ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:2770:2: ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:2770:3: rule__POtherOperatorExpression__RightOperandAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__RightOperandAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionAccess().getRightOperandAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group_1__1__Impl"


    // $ANTLR start "rule__POtherOperatorExpression__Group_1_0__0"
    // InternalPerl.g:2779:1: rule__POtherOperatorExpression__Group_1_0__0 : rule__POtherOperatorExpression__Group_1_0__0__Impl ;
    public final void rule__POtherOperatorExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2783:1: ( rule__POtherOperatorExpression__Group_1_0__0__Impl )
            // InternalPerl.g:2784:2: rule__POtherOperatorExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group_1_0__0"


    // $ANTLR start "rule__POtherOperatorExpression__Group_1_0__0__Impl"
    // InternalPerl.g:2790:1: rule__POtherOperatorExpression__Group_1_0__0__Impl : ( ( rule__POtherOperatorExpression__Group_1_0_0__0 ) ) ;
    public final void rule__POtherOperatorExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2794:1: ( ( ( rule__POtherOperatorExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:2795:1: ( ( rule__POtherOperatorExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:2795:1: ( ( rule__POtherOperatorExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:2796:2: ( rule__POtherOperatorExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:2797:2: ( rule__POtherOperatorExpression__Group_1_0_0__0 )
            // InternalPerl.g:2797:3: rule__POtherOperatorExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__POtherOperatorExpression__Group_1_0_0__0"
    // InternalPerl.g:2806:1: rule__POtherOperatorExpression__Group_1_0_0__0 : rule__POtherOperatorExpression__Group_1_0_0__0__Impl rule__POtherOperatorExpression__Group_1_0_0__1 ;
    public final void rule__POtherOperatorExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2810:1: ( rule__POtherOperatorExpression__Group_1_0_0__0__Impl rule__POtherOperatorExpression__Group_1_0_0__1 )
            // InternalPerl.g:2811:2: rule__POtherOperatorExpression__Group_1_0_0__0__Impl rule__POtherOperatorExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_17);
            rule__POtherOperatorExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group_1_0_0__0"


    // $ANTLR start "rule__POtherOperatorExpression__Group_1_0_0__0__Impl"
    // InternalPerl.g:2818:1: rule__POtherOperatorExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__POtherOperatorExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2822:1: ( ( () ) )
            // InternalPerl.g:2823:1: ( () )
            {
            // InternalPerl.g:2823:1: ( () )
            // InternalPerl.g:2824:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:2825:2: ()
            // InternalPerl.g:2825:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__POtherOperatorExpression__Group_1_0_0__1"
    // InternalPerl.g:2833:1: rule__POtherOperatorExpression__Group_1_0_0__1 : rule__POtherOperatorExpression__Group_1_0_0__1__Impl ;
    public final void rule__POtherOperatorExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2837:1: ( rule__POtherOperatorExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:2838:2: rule__POtherOperatorExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group_1_0_0__1"


    // $ANTLR start "rule__POtherOperatorExpression__Group_1_0_0__1__Impl"
    // InternalPerl.g:2844:1: rule__POtherOperatorExpression__Group_1_0_0__1__Impl : ( ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__POtherOperatorExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2848:1: ( ( ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:2849:1: ( ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:2849:1: ( ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:2850:2: ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:2851:2: ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:2851:3: rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__OpOther__Group_0__0"
    // InternalPerl.g:2860:1: rule__OpOther__Group_0__0 : rule__OpOther__Group_0__0__Impl rule__OpOther__Group_0__1 ;
    public final void rule__OpOther__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2864:1: ( rule__OpOther__Group_0__0__Impl rule__OpOther__Group_0__1 )
            // InternalPerl.g:2865:2: rule__OpOther__Group_0__0__Impl rule__OpOther__Group_0__1
            {
            pushFollow(FOLLOW_19);
            rule__OpOther__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_0__0"


    // $ANTLR start "rule__OpOther__Group_0__0__Impl"
    // InternalPerl.g:2872:1: rule__OpOther__Group_0__0__Impl : ( '>' ) ;
    public final void rule__OpOther__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2876:1: ( ( '>' ) )
            // InternalPerl.g:2877:1: ( '>' )
            {
            // InternalPerl.g:2877:1: ( '>' )
            // InternalPerl.g:2878:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_0__0__Impl"


    // $ANTLR start "rule__OpOther__Group_0__1"
    // InternalPerl.g:2887:1: rule__OpOther__Group_0__1 : rule__OpOther__Group_0__1__Impl ;
    public final void rule__OpOther__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2891:1: ( rule__OpOther__Group_0__1__Impl )
            // InternalPerl.g:2892:2: rule__OpOther__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_0__1"


    // $ANTLR start "rule__OpOther__Group_0__1__Impl"
    // InternalPerl.g:2898:1: rule__OpOther__Group_0__1__Impl : ( ( rule__OpOther__Alternatives_0_1 ) ) ;
    public final void rule__OpOther__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2902:1: ( ( ( rule__OpOther__Alternatives_0_1 ) ) )
            // InternalPerl.g:2903:1: ( ( rule__OpOther__Alternatives_0_1 ) )
            {
            // InternalPerl.g:2903:1: ( ( rule__OpOther__Alternatives_0_1 ) )
            // InternalPerl.g:2904:2: ( rule__OpOther__Alternatives_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getAlternatives_0_1()); 
            }
            // InternalPerl.g:2905:2: ( rule__OpOther__Alternatives_0_1 )
            // InternalPerl.g:2905:3: rule__OpOther__Alternatives_0_1
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Alternatives_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getAlternatives_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_0__1__Impl"


    // $ANTLR start "rule__OpOther__Group_0_1_0__0"
    // InternalPerl.g:2914:1: rule__OpOther__Group_0_1_0__0 : rule__OpOther__Group_0_1_0__0__Impl ;
    public final void rule__OpOther__Group_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2918:1: ( rule__OpOther__Group_0_1_0__0__Impl )
            // InternalPerl.g:2919:2: rule__OpOther__Group_0_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_0_1_0__0"


    // $ANTLR start "rule__OpOther__Group_0_1_0__0__Impl"
    // InternalPerl.g:2925:1: rule__OpOther__Group_0_1_0__0__Impl : ( ( rule__OpOther__Group_0_1_0_0__0 ) ) ;
    public final void rule__OpOther__Group_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2929:1: ( ( ( rule__OpOther__Group_0_1_0_0__0 ) ) )
            // InternalPerl.g:2930:1: ( ( rule__OpOther__Group_0_1_0_0__0 ) )
            {
            // InternalPerl.g:2930:1: ( ( rule__OpOther__Group_0_1_0_0__0 ) )
            // InternalPerl.g:2931:2: ( rule__OpOther__Group_0_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGroup_0_1_0_0()); 
            }
            // InternalPerl.g:2932:2: ( rule__OpOther__Group_0_1_0_0__0 )
            // InternalPerl.g:2932:3: rule__OpOther__Group_0_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_0_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGroup_0_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_0_1_0__0__Impl"


    // $ANTLR start "rule__OpOther__Group_0_1_0_0__0"
    // InternalPerl.g:2941:1: rule__OpOther__Group_0_1_0_0__0 : rule__OpOther__Group_0_1_0_0__0__Impl rule__OpOther__Group_0_1_0_0__1 ;
    public final void rule__OpOther__Group_0_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2945:1: ( rule__OpOther__Group_0_1_0_0__0__Impl rule__OpOther__Group_0_1_0_0__1 )
            // InternalPerl.g:2946:2: rule__OpOther__Group_0_1_0_0__0__Impl rule__OpOther__Group_0_1_0_0__1
            {
            pushFollow(FOLLOW_19);
            rule__OpOther__Group_0_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_0_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_0_1_0_0__0"


    // $ANTLR start "rule__OpOther__Group_0_1_0_0__0__Impl"
    // InternalPerl.g:2953:1: rule__OpOther__Group_0_1_0_0__0__Impl : ( '>' ) ;
    public final void rule__OpOther__Group_0_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2957:1: ( ( '>' ) )
            // InternalPerl.g:2958:1: ( '>' )
            {
            // InternalPerl.g:2958:1: ( '>' )
            // InternalPerl.g:2959:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_0_0_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_0_1_0_0__0__Impl"


    // $ANTLR start "rule__OpOther__Group_0_1_0_0__1"
    // InternalPerl.g:2968:1: rule__OpOther__Group_0_1_0_0__1 : rule__OpOther__Group_0_1_0_0__1__Impl ;
    public final void rule__OpOther__Group_0_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2972:1: ( rule__OpOther__Group_0_1_0_0__1__Impl )
            // InternalPerl.g:2973:2: rule__OpOther__Group_0_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_0_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_0_1_0_0__1"


    // $ANTLR start "rule__OpOther__Group_0_1_0_0__1__Impl"
    // InternalPerl.g:2979:1: rule__OpOther__Group_0_1_0_0__1__Impl : ( '>' ) ;
    public final void rule__OpOther__Group_0_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2983:1: ( ( '>' ) )
            // InternalPerl.g:2984:1: ( '>' )
            {
            // InternalPerl.g:2984:1: ( '>' )
            // InternalPerl.g:2985:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_0_0_1()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_0_1_0_0__1__Impl"


    // $ANTLR start "rule__OpOther__Group_1__0"
    // InternalPerl.g:2995:1: rule__OpOther__Group_1__0 : rule__OpOther__Group_1__0__Impl rule__OpOther__Group_1__1 ;
    public final void rule__OpOther__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2999:1: ( rule__OpOther__Group_1__0__Impl rule__OpOther__Group_1__1 )
            // InternalPerl.g:3000:2: rule__OpOther__Group_1__0__Impl rule__OpOther__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__OpOther__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_1__0"


    // $ANTLR start "rule__OpOther__Group_1__0__Impl"
    // InternalPerl.g:3007:1: rule__OpOther__Group_1__0__Impl : ( '<' ) ;
    public final void rule__OpOther__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3011:1: ( ( '<' ) )
            // InternalPerl.g:3012:1: ( '<' )
            {
            // InternalPerl.g:3012:1: ( '<' )
            // InternalPerl.g:3013:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_1__0__Impl"


    // $ANTLR start "rule__OpOther__Group_1__1"
    // InternalPerl.g:3022:1: rule__OpOther__Group_1__1 : rule__OpOther__Group_1__1__Impl ;
    public final void rule__OpOther__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3026:1: ( rule__OpOther__Group_1__1__Impl )
            // InternalPerl.g:3027:2: rule__OpOther__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_1__1"


    // $ANTLR start "rule__OpOther__Group_1__1__Impl"
    // InternalPerl.g:3033:1: rule__OpOther__Group_1__1__Impl : ( ( rule__OpOther__Alternatives_1_1 ) ) ;
    public final void rule__OpOther__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3037:1: ( ( ( rule__OpOther__Alternatives_1_1 ) ) )
            // InternalPerl.g:3038:1: ( ( rule__OpOther__Alternatives_1_1 ) )
            {
            // InternalPerl.g:3038:1: ( ( rule__OpOther__Alternatives_1_1 ) )
            // InternalPerl.g:3039:2: ( rule__OpOther__Alternatives_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getAlternatives_1_1()); 
            }
            // InternalPerl.g:3040:2: ( rule__OpOther__Alternatives_1_1 )
            // InternalPerl.g:3040:3: rule__OpOther__Alternatives_1_1
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Alternatives_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getAlternatives_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_1__1__Impl"


    // $ANTLR start "rule__OpOther__Group_1_1_0__0"
    // InternalPerl.g:3049:1: rule__OpOther__Group_1_1_0__0 : rule__OpOther__Group_1_1_0__0__Impl ;
    public final void rule__OpOther__Group_1_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3053:1: ( rule__OpOther__Group_1_1_0__0__Impl )
            // InternalPerl.g:3054:2: rule__OpOther__Group_1_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_1_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_1_1_0__0"


    // $ANTLR start "rule__OpOther__Group_1_1_0__0__Impl"
    // InternalPerl.g:3060:1: rule__OpOther__Group_1_1_0__0__Impl : ( ( rule__OpOther__Group_1_1_0_0__0 ) ) ;
    public final void rule__OpOther__Group_1_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3064:1: ( ( ( rule__OpOther__Group_1_1_0_0__0 ) ) )
            // InternalPerl.g:3065:1: ( ( rule__OpOther__Group_1_1_0_0__0 ) )
            {
            // InternalPerl.g:3065:1: ( ( rule__OpOther__Group_1_1_0_0__0 ) )
            // InternalPerl.g:3066:2: ( rule__OpOther__Group_1_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGroup_1_1_0_0()); 
            }
            // InternalPerl.g:3067:2: ( rule__OpOther__Group_1_1_0_0__0 )
            // InternalPerl.g:3067:3: rule__OpOther__Group_1_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_1_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGroup_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_1_1_0__0__Impl"


    // $ANTLR start "rule__OpOther__Group_1_1_0_0__0"
    // InternalPerl.g:3076:1: rule__OpOther__Group_1_1_0_0__0 : rule__OpOther__Group_1_1_0_0__0__Impl rule__OpOther__Group_1_1_0_0__1 ;
    public final void rule__OpOther__Group_1_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3080:1: ( rule__OpOther__Group_1_1_0_0__0__Impl rule__OpOther__Group_1_1_0_0__1 )
            // InternalPerl.g:3081:2: rule__OpOther__Group_1_1_0_0__0__Impl rule__OpOther__Group_1_1_0_0__1
            {
            pushFollow(FOLLOW_7);
            rule__OpOther__Group_1_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_1_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_1_1_0_0__0"


    // $ANTLR start "rule__OpOther__Group_1_1_0_0__0__Impl"
    // InternalPerl.g:3088:1: rule__OpOther__Group_1_1_0_0__0__Impl : ( '<' ) ;
    public final void rule__OpOther__Group_1_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3092:1: ( ( '<' ) )
            // InternalPerl.g:3093:1: ( '<' )
            {
            // InternalPerl.g:3093:1: ( '<' )
            // InternalPerl.g:3094:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_1_0_0_0()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_1_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_1_1_0_0__0__Impl"


    // $ANTLR start "rule__OpOther__Group_1_1_0_0__1"
    // InternalPerl.g:3103:1: rule__OpOther__Group_1_1_0_0__1 : rule__OpOther__Group_1_1_0_0__1__Impl ;
    public final void rule__OpOther__Group_1_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3107:1: ( rule__OpOther__Group_1_1_0_0__1__Impl )
            // InternalPerl.g:3108:2: rule__OpOther__Group_1_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_1_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_1_1_0_0__1"


    // $ANTLR start "rule__OpOther__Group_1_1_0_0__1__Impl"
    // InternalPerl.g:3114:1: rule__OpOther__Group_1_1_0_0__1__Impl : ( '<' ) ;
    public final void rule__OpOther__Group_1_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3118:1: ( ( '<' ) )
            // InternalPerl.g:3119:1: ( '<' )
            {
            // InternalPerl.g:3119:1: ( '<' )
            // InternalPerl.g:3120:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_1_0_0_1()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpOther__Group_1_1_0_0__1__Impl"


    // $ANTLR start "rule__PAdditiveExpression__Group__0"
    // InternalPerl.g:3130:1: rule__PAdditiveExpression__Group__0 : rule__PAdditiveExpression__Group__0__Impl rule__PAdditiveExpression__Group__1 ;
    public final void rule__PAdditiveExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3134:1: ( rule__PAdditiveExpression__Group__0__Impl rule__PAdditiveExpression__Group__1 )
            // InternalPerl.g:3135:2: rule__PAdditiveExpression__Group__0__Impl rule__PAdditiveExpression__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__PAdditiveExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group__0"


    // $ANTLR start "rule__PAdditiveExpression__Group__0__Impl"
    // InternalPerl.g:3142:1: rule__PAdditiveExpression__Group__0__Impl : ( rulePMultiplicativeExpression ) ;
    public final void rule__PAdditiveExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3146:1: ( ( rulePMultiplicativeExpression ) )
            // InternalPerl.g:3147:1: ( rulePMultiplicativeExpression )
            {
            // InternalPerl.g:3147:1: ( rulePMultiplicativeExpression )
            // InternalPerl.g:3148:2: rulePMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getPMultiplicativeExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionAccess().getPMultiplicativeExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group__0__Impl"


    // $ANTLR start "rule__PAdditiveExpression__Group__1"
    // InternalPerl.g:3157:1: rule__PAdditiveExpression__Group__1 : rule__PAdditiveExpression__Group__1__Impl ;
    public final void rule__PAdditiveExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3161:1: ( rule__PAdditiveExpression__Group__1__Impl )
            // InternalPerl.g:3162:2: rule__PAdditiveExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group__1"


    // $ANTLR start "rule__PAdditiveExpression__Group__1__Impl"
    // InternalPerl.g:3168:1: rule__PAdditiveExpression__Group__1__Impl : ( ( rule__PAdditiveExpression__Group_1__0 )* ) ;
    public final void rule__PAdditiveExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3172:1: ( ( ( rule__PAdditiveExpression__Group_1__0 )* ) )
            // InternalPerl.g:3173:1: ( ( rule__PAdditiveExpression__Group_1__0 )* )
            {
            // InternalPerl.g:3173:1: ( ( rule__PAdditiveExpression__Group_1__0 )* )
            // InternalPerl.g:3174:2: ( rule__PAdditiveExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:3175:2: ( rule__PAdditiveExpression__Group_1__0 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // InternalPerl.g:3175:3: rule__PAdditiveExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__PAdditiveExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group__1__Impl"


    // $ANTLR start "rule__PAdditiveExpression__Group_1__0"
    // InternalPerl.g:3184:1: rule__PAdditiveExpression__Group_1__0 : rule__PAdditiveExpression__Group_1__0__Impl rule__PAdditiveExpression__Group_1__1 ;
    public final void rule__PAdditiveExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3188:1: ( rule__PAdditiveExpression__Group_1__0__Impl rule__PAdditiveExpression__Group_1__1 )
            // InternalPerl.g:3189:2: rule__PAdditiveExpression__Group_1__0__Impl rule__PAdditiveExpression__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__PAdditiveExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group_1__0"


    // $ANTLR start "rule__PAdditiveExpression__Group_1__0__Impl"
    // InternalPerl.g:3196:1: rule__PAdditiveExpression__Group_1__0__Impl : ( ( rule__PAdditiveExpression__Group_1_0__0 ) ) ;
    public final void rule__PAdditiveExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3200:1: ( ( ( rule__PAdditiveExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:3201:1: ( ( rule__PAdditiveExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:3201:1: ( ( rule__PAdditiveExpression__Group_1_0__0 ) )
            // InternalPerl.g:3202:2: ( rule__PAdditiveExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:3203:2: ( rule__PAdditiveExpression__Group_1_0__0 )
            // InternalPerl.g:3203:3: rule__PAdditiveExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PAdditiveExpression__Group_1__1"
    // InternalPerl.g:3211:1: rule__PAdditiveExpression__Group_1__1 : rule__PAdditiveExpression__Group_1__1__Impl ;
    public final void rule__PAdditiveExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3215:1: ( rule__PAdditiveExpression__Group_1__1__Impl )
            // InternalPerl.g:3216:2: rule__PAdditiveExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group_1__1"


    // $ANTLR start "rule__PAdditiveExpression__Group_1__1__Impl"
    // InternalPerl.g:3222:1: rule__PAdditiveExpression__Group_1__1__Impl : ( ( rule__PAdditiveExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PAdditiveExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3226:1: ( ( ( rule__PAdditiveExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:3227:1: ( ( rule__PAdditiveExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:3227:1: ( ( rule__PAdditiveExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:3228:2: ( rule__PAdditiveExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:3229:2: ( rule__PAdditiveExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:3229:3: rule__PAdditiveExpression__RightOperandAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__RightOperandAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionAccess().getRightOperandAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group_1__1__Impl"


    // $ANTLR start "rule__PAdditiveExpression__Group_1_0__0"
    // InternalPerl.g:3238:1: rule__PAdditiveExpression__Group_1_0__0 : rule__PAdditiveExpression__Group_1_0__0__Impl ;
    public final void rule__PAdditiveExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3242:1: ( rule__PAdditiveExpression__Group_1_0__0__Impl )
            // InternalPerl.g:3243:2: rule__PAdditiveExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group_1_0__0"


    // $ANTLR start "rule__PAdditiveExpression__Group_1_0__0__Impl"
    // InternalPerl.g:3249:1: rule__PAdditiveExpression__Group_1_0__0__Impl : ( ( rule__PAdditiveExpression__Group_1_0_0__0 ) ) ;
    public final void rule__PAdditiveExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3253:1: ( ( ( rule__PAdditiveExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:3254:1: ( ( rule__PAdditiveExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:3254:1: ( ( rule__PAdditiveExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:3255:2: ( rule__PAdditiveExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:3256:2: ( rule__PAdditiveExpression__Group_1_0_0__0 )
            // InternalPerl.g:3256:3: rule__PAdditiveExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__PAdditiveExpression__Group_1_0_0__0"
    // InternalPerl.g:3265:1: rule__PAdditiveExpression__Group_1_0_0__0 : rule__PAdditiveExpression__Group_1_0_0__0__Impl rule__PAdditiveExpression__Group_1_0_0__1 ;
    public final void rule__PAdditiveExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3269:1: ( rule__PAdditiveExpression__Group_1_0_0__0__Impl rule__PAdditiveExpression__Group_1_0_0__1 )
            // InternalPerl.g:3270:2: rule__PAdditiveExpression__Group_1_0_0__0__Impl rule__PAdditiveExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_21);
            rule__PAdditiveExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group_1_0_0__0"


    // $ANTLR start "rule__PAdditiveExpression__Group_1_0_0__0__Impl"
    // InternalPerl.g:3277:1: rule__PAdditiveExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PAdditiveExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3281:1: ( ( () ) )
            // InternalPerl.g:3282:1: ( () )
            {
            // InternalPerl.g:3282:1: ( () )
            // InternalPerl.g:3283:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:3284:2: ()
            // InternalPerl.g:3284:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__PAdditiveExpression__Group_1_0_0__1"
    // InternalPerl.g:3292:1: rule__PAdditiveExpression__Group_1_0_0__1 : rule__PAdditiveExpression__Group_1_0_0__1__Impl ;
    public final void rule__PAdditiveExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3296:1: ( rule__PAdditiveExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:3297:2: rule__PAdditiveExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group_1_0_0__1"


    // $ANTLR start "rule__PAdditiveExpression__Group_1_0_0__1__Impl"
    // InternalPerl.g:3303:1: rule__PAdditiveExpression__Group_1_0_0__1__Impl : ( ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PAdditiveExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3307:1: ( ( ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:3308:1: ( ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:3308:1: ( ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:3309:2: ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:3310:2: ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:3310:3: rule__PAdditiveExpression__FeatureAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PAdditiveExpression__FeatureAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__PMultiplicativeExpression__Group__0"
    // InternalPerl.g:3319:1: rule__PMultiplicativeExpression__Group__0 : rule__PMultiplicativeExpression__Group__0__Impl rule__PMultiplicativeExpression__Group__1 ;
    public final void rule__PMultiplicativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3323:1: ( rule__PMultiplicativeExpression__Group__0__Impl rule__PMultiplicativeExpression__Group__1 )
            // InternalPerl.g:3324:2: rule__PMultiplicativeExpression__Group__0__Impl rule__PMultiplicativeExpression__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__PMultiplicativeExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group__0"


    // $ANTLR start "rule__PMultiplicativeExpression__Group__0__Impl"
    // InternalPerl.g:3331:1: rule__PMultiplicativeExpression__Group__0__Impl : ( rulePUnaryOperation ) ;
    public final void rule__PMultiplicativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3335:1: ( ( rulePUnaryOperation ) )
            // InternalPerl.g:3336:1: ( rulePUnaryOperation )
            {
            // InternalPerl.g:3336:1: ( rulePUnaryOperation )
            // InternalPerl.g:3337:2: rulePUnaryOperation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getPUnaryOperationParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePUnaryOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionAccess().getPUnaryOperationParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group__0__Impl"


    // $ANTLR start "rule__PMultiplicativeExpression__Group__1"
    // InternalPerl.g:3346:1: rule__PMultiplicativeExpression__Group__1 : rule__PMultiplicativeExpression__Group__1__Impl ;
    public final void rule__PMultiplicativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3350:1: ( rule__PMultiplicativeExpression__Group__1__Impl )
            // InternalPerl.g:3351:2: rule__PMultiplicativeExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group__1"


    // $ANTLR start "rule__PMultiplicativeExpression__Group__1__Impl"
    // InternalPerl.g:3357:1: rule__PMultiplicativeExpression__Group__1__Impl : ( ( rule__PMultiplicativeExpression__Group_1__0 )* ) ;
    public final void rule__PMultiplicativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3361:1: ( ( ( rule__PMultiplicativeExpression__Group_1__0 )* ) )
            // InternalPerl.g:3362:1: ( ( rule__PMultiplicativeExpression__Group_1__0 )* )
            {
            // InternalPerl.g:3362:1: ( ( rule__PMultiplicativeExpression__Group_1__0 )* )
            // InternalPerl.g:3363:2: ( rule__PMultiplicativeExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:3364:2: ( rule__PMultiplicativeExpression__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=35 && LA24_0<=38)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalPerl.g:3364:3: rule__PMultiplicativeExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__PMultiplicativeExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group__1__Impl"


    // $ANTLR start "rule__PMultiplicativeExpression__Group_1__0"
    // InternalPerl.g:3373:1: rule__PMultiplicativeExpression__Group_1__0 : rule__PMultiplicativeExpression__Group_1__0__Impl rule__PMultiplicativeExpression__Group_1__1 ;
    public final void rule__PMultiplicativeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3377:1: ( rule__PMultiplicativeExpression__Group_1__0__Impl rule__PMultiplicativeExpression__Group_1__1 )
            // InternalPerl.g:3378:2: rule__PMultiplicativeExpression__Group_1__0__Impl rule__PMultiplicativeExpression__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__PMultiplicativeExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group_1__0"


    // $ANTLR start "rule__PMultiplicativeExpression__Group_1__0__Impl"
    // InternalPerl.g:3385:1: rule__PMultiplicativeExpression__Group_1__0__Impl : ( ( rule__PMultiplicativeExpression__Group_1_0__0 ) ) ;
    public final void rule__PMultiplicativeExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3389:1: ( ( ( rule__PMultiplicativeExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:3390:1: ( ( rule__PMultiplicativeExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:3390:1: ( ( rule__PMultiplicativeExpression__Group_1_0__0 ) )
            // InternalPerl.g:3391:2: ( rule__PMultiplicativeExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:3392:2: ( rule__PMultiplicativeExpression__Group_1_0__0 )
            // InternalPerl.g:3392:3: rule__PMultiplicativeExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PMultiplicativeExpression__Group_1__1"
    // InternalPerl.g:3400:1: rule__PMultiplicativeExpression__Group_1__1 : rule__PMultiplicativeExpression__Group_1__1__Impl ;
    public final void rule__PMultiplicativeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3404:1: ( rule__PMultiplicativeExpression__Group_1__1__Impl )
            // InternalPerl.g:3405:2: rule__PMultiplicativeExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group_1__1"


    // $ANTLR start "rule__PMultiplicativeExpression__Group_1__1__Impl"
    // InternalPerl.g:3411:1: rule__PMultiplicativeExpression__Group_1__1__Impl : ( ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PMultiplicativeExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3415:1: ( ( ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:3416:1: ( ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:3416:1: ( ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:3417:2: ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:3418:2: ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:3418:3: rule__PMultiplicativeExpression__RightOperandAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__RightOperandAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionAccess().getRightOperandAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group_1__1__Impl"


    // $ANTLR start "rule__PMultiplicativeExpression__Group_1_0__0"
    // InternalPerl.g:3427:1: rule__PMultiplicativeExpression__Group_1_0__0 : rule__PMultiplicativeExpression__Group_1_0__0__Impl ;
    public final void rule__PMultiplicativeExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3431:1: ( rule__PMultiplicativeExpression__Group_1_0__0__Impl )
            // InternalPerl.g:3432:2: rule__PMultiplicativeExpression__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group_1_0__0"


    // $ANTLR start "rule__PMultiplicativeExpression__Group_1_0__0__Impl"
    // InternalPerl.g:3438:1: rule__PMultiplicativeExpression__Group_1_0__0__Impl : ( ( rule__PMultiplicativeExpression__Group_1_0_0__0 ) ) ;
    public final void rule__PMultiplicativeExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3442:1: ( ( ( rule__PMultiplicativeExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:3443:1: ( ( rule__PMultiplicativeExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:3443:1: ( ( rule__PMultiplicativeExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:3444:2: ( rule__PMultiplicativeExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:3445:2: ( rule__PMultiplicativeExpression__Group_1_0_0__0 )
            // InternalPerl.g:3445:3: rule__PMultiplicativeExpression__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionAccess().getGroup_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__PMultiplicativeExpression__Group_1_0_0__0"
    // InternalPerl.g:3454:1: rule__PMultiplicativeExpression__Group_1_0_0__0 : rule__PMultiplicativeExpression__Group_1_0_0__0__Impl rule__PMultiplicativeExpression__Group_1_0_0__1 ;
    public final void rule__PMultiplicativeExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3458:1: ( rule__PMultiplicativeExpression__Group_1_0_0__0__Impl rule__PMultiplicativeExpression__Group_1_0_0__1 )
            // InternalPerl.g:3459:2: rule__PMultiplicativeExpression__Group_1_0_0__0__Impl rule__PMultiplicativeExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_23);
            rule__PMultiplicativeExpression__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group_1_0_0__0"


    // $ANTLR start "rule__PMultiplicativeExpression__Group_1_0_0__0__Impl"
    // InternalPerl.g:3466:1: rule__PMultiplicativeExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PMultiplicativeExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3470:1: ( ( () ) )
            // InternalPerl.g:3471:1: ( () )
            {
            // InternalPerl.g:3471:1: ( () )
            // InternalPerl.g:3472:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:3473:2: ()
            // InternalPerl.g:3473:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__PMultiplicativeExpression__Group_1_0_0__1"
    // InternalPerl.g:3481:1: rule__PMultiplicativeExpression__Group_1_0_0__1 : rule__PMultiplicativeExpression__Group_1_0_0__1__Impl ;
    public final void rule__PMultiplicativeExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3485:1: ( rule__PMultiplicativeExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:3486:2: rule__PMultiplicativeExpression__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group_1_0_0__1"


    // $ANTLR start "rule__PMultiplicativeExpression__Group_1_0_0__1__Impl"
    // InternalPerl.g:3492:1: rule__PMultiplicativeExpression__Group_1_0_0__1__Impl : ( ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PMultiplicativeExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3496:1: ( ( ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:3497:1: ( ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:3497:1: ( ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:3498:2: ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:3499:2: ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:3499:3: rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__PUnaryOperation__Group__0"
    // InternalPerl.g:3508:1: rule__PUnaryOperation__Group__0 : rule__PUnaryOperation__Group__0__Impl rule__PUnaryOperation__Group__1 ;
    public final void rule__PUnaryOperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3512:1: ( rule__PUnaryOperation__Group__0__Impl rule__PUnaryOperation__Group__1 )
            // InternalPerl.g:3513:2: rule__PUnaryOperation__Group__0__Impl rule__PUnaryOperation__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__PUnaryOperation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PUnaryOperation__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PUnaryOperation__Group__0"


    // $ANTLR start "rule__PUnaryOperation__Group__0__Impl"
    // InternalPerl.g:3520:1: rule__PUnaryOperation__Group__0__Impl : ( () ) ;
    public final void rule__PUnaryOperation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3524:1: ( ( () ) )
            // InternalPerl.g:3525:1: ( () )
            {
            // InternalPerl.g:3525:1: ( () )
            // InternalPerl.g:3526:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPUnaryOperationAccess().getPUnaryOperationAction_0()); 
            }
            // InternalPerl.g:3527:2: ()
            // InternalPerl.g:3527:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPUnaryOperationAccess().getPUnaryOperationAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PUnaryOperation__Group__0__Impl"


    // $ANTLR start "rule__PUnaryOperation__Group__1"
    // InternalPerl.g:3535:1: rule__PUnaryOperation__Group__1 : rule__PUnaryOperation__Group__1__Impl rule__PUnaryOperation__Group__2 ;
    public final void rule__PUnaryOperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3539:1: ( rule__PUnaryOperation__Group__1__Impl rule__PUnaryOperation__Group__2 )
            // InternalPerl.g:3540:2: rule__PUnaryOperation__Group__1__Impl rule__PUnaryOperation__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__PUnaryOperation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PUnaryOperation__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PUnaryOperation__Group__1"


    // $ANTLR start "rule__PUnaryOperation__Group__1__Impl"
    // InternalPerl.g:3547:1: rule__PUnaryOperation__Group__1__Impl : ( ( rule__PUnaryOperation__FeatureAssignment_1 ) ) ;
    public final void rule__PUnaryOperation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3551:1: ( ( ( rule__PUnaryOperation__FeatureAssignment_1 ) ) )
            // InternalPerl.g:3552:1: ( ( rule__PUnaryOperation__FeatureAssignment_1 ) )
            {
            // InternalPerl.g:3552:1: ( ( rule__PUnaryOperation__FeatureAssignment_1 ) )
            // InternalPerl.g:3553:2: ( rule__PUnaryOperation__FeatureAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPUnaryOperationAccess().getFeatureAssignment_1()); 
            }
            // InternalPerl.g:3554:2: ( rule__PUnaryOperation__FeatureAssignment_1 )
            // InternalPerl.g:3554:3: rule__PUnaryOperation__FeatureAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PUnaryOperation__FeatureAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPUnaryOperationAccess().getFeatureAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PUnaryOperation__Group__1__Impl"


    // $ANTLR start "rule__PUnaryOperation__Group__2"
    // InternalPerl.g:3562:1: rule__PUnaryOperation__Group__2 : rule__PUnaryOperation__Group__2__Impl ;
    public final void rule__PUnaryOperation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3566:1: ( rule__PUnaryOperation__Group__2__Impl )
            // InternalPerl.g:3567:2: rule__PUnaryOperation__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PUnaryOperation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PUnaryOperation__Group__2"


    // $ANTLR start "rule__PUnaryOperation__Group__2__Impl"
    // InternalPerl.g:3573:1: rule__PUnaryOperation__Group__2__Impl : ( ( rule__PUnaryOperation__OperandAssignment_2 ) ) ;
    public final void rule__PUnaryOperation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3577:1: ( ( ( rule__PUnaryOperation__OperandAssignment_2 ) ) )
            // InternalPerl.g:3578:1: ( ( rule__PUnaryOperation__OperandAssignment_2 ) )
            {
            // InternalPerl.g:3578:1: ( ( rule__PUnaryOperation__OperandAssignment_2 ) )
            // InternalPerl.g:3579:2: ( rule__PUnaryOperation__OperandAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPUnaryOperationAccess().getOperandAssignment_2()); 
            }
            // InternalPerl.g:3580:2: ( rule__PUnaryOperation__OperandAssignment_2 )
            // InternalPerl.g:3580:3: rule__PUnaryOperation__OperandAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PUnaryOperation__OperandAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPUnaryOperationAccess().getOperandAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PUnaryOperation__Group__2__Impl"


    // $ANTLR start "rule__PVar__Group__0"
    // InternalPerl.g:3589:1: rule__PVar__Group__0 : rule__PVar__Group__0__Impl rule__PVar__Group__1 ;
    public final void rule__PVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3593:1: ( rule__PVar__Group__0__Impl rule__PVar__Group__1 )
            // InternalPerl.g:3594:2: rule__PVar__Group__0__Impl rule__PVar__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__PVar__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PVar__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVar__Group__0"


    // $ANTLR start "rule__PVar__Group__0__Impl"
    // InternalPerl.g:3601:1: rule__PVar__Group__0__Impl : ( RULE_VAR_START ) ;
    public final void rule__PVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3605:1: ( ( RULE_VAR_START ) )
            // InternalPerl.g:3606:1: ( RULE_VAR_START )
            {
            // InternalPerl.g:3606:1: ( RULE_VAR_START )
            // InternalPerl.g:3607:2: RULE_VAR_START
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVarAccess().getVAR_STARTTerminalRuleCall_0()); 
            }
            match(input,RULE_VAR_START,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVarAccess().getVAR_STARTTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVar__Group__0__Impl"


    // $ANTLR start "rule__PVar__Group__1"
    // InternalPerl.g:3616:1: rule__PVar__Group__1 : rule__PVar__Group__1__Impl ;
    public final void rule__PVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3620:1: ( rule__PVar__Group__1__Impl )
            // InternalPerl.g:3621:2: rule__PVar__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PVar__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVar__Group__1"


    // $ANTLR start "rule__PVar__Group__1__Impl"
    // InternalPerl.g:3627:1: rule__PVar__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__PVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3631:1: ( ( RULE_ID ) )
            // InternalPerl.g:3632:1: ( RULE_ID )
            {
            // InternalPerl.g:3632:1: ( RULE_ID )
            // InternalPerl.g:3633:2: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVarAccess().getIDTerminalRuleCall_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVarAccess().getIDTerminalRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVar__Group__1__Impl"


    // $ANTLR start "rule__PClosure__Group__0"
    // InternalPerl.g:3643:1: rule__PClosure__Group__0 : rule__PClosure__Group__0__Impl rule__PClosure__Group__1 ;
    public final void rule__PClosure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3647:1: ( rule__PClosure__Group__0__Impl rule__PClosure__Group__1 )
            // InternalPerl.g:3648:2: rule__PClosure__Group__0__Impl rule__PClosure__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__PClosure__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PClosure__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group__0"


    // $ANTLR start "rule__PClosure__Group__0__Impl"
    // InternalPerl.g:3655:1: rule__PClosure__Group__0__Impl : ( ( rule__PClosure__Group_0__0 ) ) ;
    public final void rule__PClosure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3659:1: ( ( ( rule__PClosure__Group_0__0 ) ) )
            // InternalPerl.g:3660:1: ( ( rule__PClosure__Group_0__0 ) )
            {
            // InternalPerl.g:3660:1: ( ( rule__PClosure__Group_0__0 ) )
            // InternalPerl.g:3661:2: ( rule__PClosure__Group_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getGroup_0()); 
            }
            // InternalPerl.g:3662:2: ( rule__PClosure__Group_0__0 )
            // InternalPerl.g:3662:3: rule__PClosure__Group_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PClosure__Group_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPClosureAccess().getGroup_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group__0__Impl"


    // $ANTLR start "rule__PClosure__Group__1"
    // InternalPerl.g:3670:1: rule__PClosure__Group__1 : rule__PClosure__Group__1__Impl rule__PClosure__Group__2 ;
    public final void rule__PClosure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3674:1: ( rule__PClosure__Group__1__Impl rule__PClosure__Group__2 )
            // InternalPerl.g:3675:2: rule__PClosure__Group__1__Impl rule__PClosure__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__PClosure__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PClosure__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group__1"


    // $ANTLR start "rule__PClosure__Group__1__Impl"
    // InternalPerl.g:3682:1: rule__PClosure__Group__1__Impl : ( ( rule__PClosure__ExpressionAssignment_1 ) ) ;
    public final void rule__PClosure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3686:1: ( ( ( rule__PClosure__ExpressionAssignment_1 ) ) )
            // InternalPerl.g:3687:1: ( ( rule__PClosure__ExpressionAssignment_1 ) )
            {
            // InternalPerl.g:3687:1: ( ( rule__PClosure__ExpressionAssignment_1 ) )
            // InternalPerl.g:3688:2: ( rule__PClosure__ExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getExpressionAssignment_1()); 
            }
            // InternalPerl.g:3689:2: ( rule__PClosure__ExpressionAssignment_1 )
            // InternalPerl.g:3689:3: rule__PClosure__ExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PClosure__ExpressionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPClosureAccess().getExpressionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group__1__Impl"


    // $ANTLR start "rule__PClosure__Group__2"
    // InternalPerl.g:3697:1: rule__PClosure__Group__2 : rule__PClosure__Group__2__Impl ;
    public final void rule__PClosure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3701:1: ( rule__PClosure__Group__2__Impl )
            // InternalPerl.g:3702:2: rule__PClosure__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PClosure__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group__2"


    // $ANTLR start "rule__PClosure__Group__2__Impl"
    // InternalPerl.g:3708:1: rule__PClosure__Group__2__Impl : ( '}' ) ;
    public final void rule__PClosure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3712:1: ( ( '}' ) )
            // InternalPerl.g:3713:1: ( '}' )
            {
            // InternalPerl.g:3713:1: ( '}' )
            // InternalPerl.g:3714:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getRightCurlyBracketKeyword_2()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPClosureAccess().getRightCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group__2__Impl"


    // $ANTLR start "rule__PClosure__Group_0__0"
    // InternalPerl.g:3724:1: rule__PClosure__Group_0__0 : rule__PClosure__Group_0__0__Impl ;
    public final void rule__PClosure__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3728:1: ( rule__PClosure__Group_0__0__Impl )
            // InternalPerl.g:3729:2: rule__PClosure__Group_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PClosure__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group_0__0"


    // $ANTLR start "rule__PClosure__Group_0__0__Impl"
    // InternalPerl.g:3735:1: rule__PClosure__Group_0__0__Impl : ( ( rule__PClosure__Group_0_0__0 ) ) ;
    public final void rule__PClosure__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3739:1: ( ( ( rule__PClosure__Group_0_0__0 ) ) )
            // InternalPerl.g:3740:1: ( ( rule__PClosure__Group_0_0__0 ) )
            {
            // InternalPerl.g:3740:1: ( ( rule__PClosure__Group_0_0__0 ) )
            // InternalPerl.g:3741:2: ( rule__PClosure__Group_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getGroup_0_0()); 
            }
            // InternalPerl.g:3742:2: ( rule__PClosure__Group_0_0__0 )
            // InternalPerl.g:3742:3: rule__PClosure__Group_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PClosure__Group_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPClosureAccess().getGroup_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group_0__0__Impl"


    // $ANTLR start "rule__PClosure__Group_0_0__0"
    // InternalPerl.g:3751:1: rule__PClosure__Group_0_0__0 : rule__PClosure__Group_0_0__0__Impl rule__PClosure__Group_0_0__1 ;
    public final void rule__PClosure__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3755:1: ( rule__PClosure__Group_0_0__0__Impl rule__PClosure__Group_0_0__1 )
            // InternalPerl.g:3756:2: rule__PClosure__Group_0_0__0__Impl rule__PClosure__Group_0_0__1
            {
            pushFollow(FOLLOW_28);
            rule__PClosure__Group_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PClosure__Group_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group_0_0__0"


    // $ANTLR start "rule__PClosure__Group_0_0__0__Impl"
    // InternalPerl.g:3763:1: rule__PClosure__Group_0_0__0__Impl : ( () ) ;
    public final void rule__PClosure__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3767:1: ( ( () ) )
            // InternalPerl.g:3768:1: ( () )
            {
            // InternalPerl.g:3768:1: ( () )
            // InternalPerl.g:3769:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getPClosureAction_0_0_0()); 
            }
            // InternalPerl.g:3770:2: ()
            // InternalPerl.g:3770:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPClosureAccess().getPClosureAction_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group_0_0__0__Impl"


    // $ANTLR start "rule__PClosure__Group_0_0__1"
    // InternalPerl.g:3778:1: rule__PClosure__Group_0_0__1 : rule__PClosure__Group_0_0__1__Impl rule__PClosure__Group_0_0__2 ;
    public final void rule__PClosure__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3782:1: ( rule__PClosure__Group_0_0__1__Impl rule__PClosure__Group_0_0__2 )
            // InternalPerl.g:3783:2: rule__PClosure__Group_0_0__1__Impl rule__PClosure__Group_0_0__2
            {
            pushFollow(FOLLOW_29);
            rule__PClosure__Group_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PClosure__Group_0_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group_0_0__1"


    // $ANTLR start "rule__PClosure__Group_0_0__1__Impl"
    // InternalPerl.g:3790:1: rule__PClosure__Group_0_0__1__Impl : ( 'sub' ) ;
    public final void rule__PClosure__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3794:1: ( ( 'sub' ) )
            // InternalPerl.g:3795:1: ( 'sub' )
            {
            // InternalPerl.g:3795:1: ( 'sub' )
            // InternalPerl.g:3796:2: 'sub'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getSubKeyword_0_0_1()); 
            }
            match(input,46,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPClosureAccess().getSubKeyword_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group_0_0__1__Impl"


    // $ANTLR start "rule__PClosure__Group_0_0__2"
    // InternalPerl.g:3805:1: rule__PClosure__Group_0_0__2 : rule__PClosure__Group_0_0__2__Impl ;
    public final void rule__PClosure__Group_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3809:1: ( rule__PClosure__Group_0_0__2__Impl )
            // InternalPerl.g:3810:2: rule__PClosure__Group_0_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PClosure__Group_0_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group_0_0__2"


    // $ANTLR start "rule__PClosure__Group_0_0__2__Impl"
    // InternalPerl.g:3816:1: rule__PClosure__Group_0_0__2__Impl : ( '{' ) ;
    public final void rule__PClosure__Group_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3820:1: ( ( '{' ) )
            // InternalPerl.g:3821:1: ( '{' )
            {
            // InternalPerl.g:3821:1: ( '{' )
            // InternalPerl.g:3822:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getLeftCurlyBracketKeyword_0_0_2()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPClosureAccess().getLeftCurlyBracketKeyword_0_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__Group_0_0__2__Impl"


    // $ANTLR start "rule__PExpressionInClosure__Group__0"
    // InternalPerl.g:3832:1: rule__PExpressionInClosure__Group__0 : rule__PExpressionInClosure__Group__0__Impl rule__PExpressionInClosure__Group__1 ;
    public final void rule__PExpressionInClosure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3836:1: ( rule__PExpressionInClosure__Group__0__Impl rule__PExpressionInClosure__Group__1 )
            // InternalPerl.g:3837:2: rule__PExpressionInClosure__Group__0__Impl rule__PExpressionInClosure__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__PExpressionInClosure__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PExpressionInClosure__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PExpressionInClosure__Group__0"


    // $ANTLR start "rule__PExpressionInClosure__Group__0__Impl"
    // InternalPerl.g:3844:1: rule__PExpressionInClosure__Group__0__Impl : ( () ) ;
    public final void rule__PExpressionInClosure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3848:1: ( ( () ) )
            // InternalPerl.g:3849:1: ( () )
            {
            // InternalPerl.g:3849:1: ( () )
            // InternalPerl.g:3850:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getPBlockExpressionAction_0()); 
            }
            // InternalPerl.g:3851:2: ()
            // InternalPerl.g:3851:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionInClosureAccess().getPBlockExpressionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PExpressionInClosure__Group__0__Impl"


    // $ANTLR start "rule__PExpressionInClosure__Group__1"
    // InternalPerl.g:3859:1: rule__PExpressionInClosure__Group__1 : rule__PExpressionInClosure__Group__1__Impl ;
    public final void rule__PExpressionInClosure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3863:1: ( rule__PExpressionInClosure__Group__1__Impl )
            // InternalPerl.g:3864:2: rule__PExpressionInClosure__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PExpressionInClosure__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PExpressionInClosure__Group__1"


    // $ANTLR start "rule__PExpressionInClosure__Group__1__Impl"
    // InternalPerl.g:3870:1: rule__PExpressionInClosure__Group__1__Impl : ( ( rule__PExpressionInClosure__Group_1__0 )* ) ;
    public final void rule__PExpressionInClosure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3874:1: ( ( ( rule__PExpressionInClosure__Group_1__0 )* ) )
            // InternalPerl.g:3875:1: ( ( rule__PExpressionInClosure__Group_1__0 )* )
            {
            // InternalPerl.g:3875:1: ( ( rule__PExpressionInClosure__Group_1__0 )* )
            // InternalPerl.g:3876:2: ( rule__PExpressionInClosure__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getGroup_1()); 
            }
            // InternalPerl.g:3877:2: ( rule__PExpressionInClosure__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_VAR_START||(LA25_0>=33 && LA25_0<=34)||LA25_0==39||(LA25_0>=42 && LA25_0<=44)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalPerl.g:3877:3: rule__PExpressionInClosure__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__PExpressionInClosure__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionInClosureAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PExpressionInClosure__Group__1__Impl"


    // $ANTLR start "rule__PExpressionInClosure__Group_1__0"
    // InternalPerl.g:3886:1: rule__PExpressionInClosure__Group_1__0 : rule__PExpressionInClosure__Group_1__0__Impl rule__PExpressionInClosure__Group_1__1 ;
    public final void rule__PExpressionInClosure__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3890:1: ( rule__PExpressionInClosure__Group_1__0__Impl rule__PExpressionInClosure__Group_1__1 )
            // InternalPerl.g:3891:2: rule__PExpressionInClosure__Group_1__0__Impl rule__PExpressionInClosure__Group_1__1
            {
            pushFollow(FOLLOW_31);
            rule__PExpressionInClosure__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PExpressionInClosure__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PExpressionInClosure__Group_1__0"


    // $ANTLR start "rule__PExpressionInClosure__Group_1__0__Impl"
    // InternalPerl.g:3898:1: rule__PExpressionInClosure__Group_1__0__Impl : ( ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 ) ) ;
    public final void rule__PExpressionInClosure__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3902:1: ( ( ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 ) ) )
            // InternalPerl.g:3903:1: ( ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 ) )
            {
            // InternalPerl.g:3903:1: ( ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 ) )
            // InternalPerl.g:3904:2: ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getExpressionsAssignment_1_0()); 
            }
            // InternalPerl.g:3905:2: ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 )
            // InternalPerl.g:3905:3: rule__PExpressionInClosure__ExpressionsAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__PExpressionInClosure__ExpressionsAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionInClosureAccess().getExpressionsAssignment_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PExpressionInClosure__Group_1__0__Impl"


    // $ANTLR start "rule__PExpressionInClosure__Group_1__1"
    // InternalPerl.g:3913:1: rule__PExpressionInClosure__Group_1__1 : rule__PExpressionInClosure__Group_1__1__Impl ;
    public final void rule__PExpressionInClosure__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3917:1: ( rule__PExpressionInClosure__Group_1__1__Impl )
            // InternalPerl.g:3918:2: rule__PExpressionInClosure__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PExpressionInClosure__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PExpressionInClosure__Group_1__1"


    // $ANTLR start "rule__PExpressionInClosure__Group_1__1__Impl"
    // InternalPerl.g:3924:1: rule__PExpressionInClosure__Group_1__1__Impl : ( ( ';' )? ) ;
    public final void rule__PExpressionInClosure__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3928:1: ( ( ( ';' )? ) )
            // InternalPerl.g:3929:1: ( ( ';' )? )
            {
            // InternalPerl.g:3929:1: ( ( ';' )? )
            // InternalPerl.g:3930:2: ( ';' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getSemicolonKeyword_1_1()); 
            }
            // InternalPerl.g:3931:2: ( ';' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==48) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalPerl.g:3931:3: ';'
                    {
                    match(input,48,FOLLOW_2); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionInClosureAccess().getSemicolonKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PExpressionInClosure__Group_1__1__Impl"


    // $ANTLR start "rule__PParenthesizedExpression__Group__0"
    // InternalPerl.g:3940:1: rule__PParenthesizedExpression__Group__0 : rule__PParenthesizedExpression__Group__0__Impl rule__PParenthesizedExpression__Group__1 ;
    public final void rule__PParenthesizedExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3944:1: ( rule__PParenthesizedExpression__Group__0__Impl rule__PParenthesizedExpression__Group__1 )
            // InternalPerl.g:3945:2: rule__PParenthesizedExpression__Group__0__Impl rule__PParenthesizedExpression__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__PParenthesizedExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PParenthesizedExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PParenthesizedExpression__Group__0"


    // $ANTLR start "rule__PParenthesizedExpression__Group__0__Impl"
    // InternalPerl.g:3952:1: rule__PParenthesizedExpression__Group__0__Impl : ( '(' ) ;
    public final void rule__PParenthesizedExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3956:1: ( ( '(' ) )
            // InternalPerl.g:3957:1: ( '(' )
            {
            // InternalPerl.g:3957:1: ( '(' )
            // InternalPerl.g:3958:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PParenthesizedExpression__Group__0__Impl"


    // $ANTLR start "rule__PParenthesizedExpression__Group__1"
    // InternalPerl.g:3967:1: rule__PParenthesizedExpression__Group__1 : rule__PParenthesizedExpression__Group__1__Impl rule__PParenthesizedExpression__Group__2 ;
    public final void rule__PParenthesizedExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3971:1: ( rule__PParenthesizedExpression__Group__1__Impl rule__PParenthesizedExpression__Group__2 )
            // InternalPerl.g:3972:2: rule__PParenthesizedExpression__Group__1__Impl rule__PParenthesizedExpression__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__PParenthesizedExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PParenthesizedExpression__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PParenthesizedExpression__Group__1"


    // $ANTLR start "rule__PParenthesizedExpression__Group__1__Impl"
    // InternalPerl.g:3979:1: rule__PParenthesizedExpression__Group__1__Impl : ( rulePExpression ) ;
    public final void rule__PParenthesizedExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3983:1: ( ( rulePExpression ) )
            // InternalPerl.g:3984:1: ( rulePExpression )
            {
            // InternalPerl.g:3984:1: ( rulePExpression )
            // InternalPerl.g:3985:2: rulePExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPParenthesizedExpressionAccess().getPExpressionParserRuleCall_1()); 
            }
            pushFollow(FOLLOW_2);
            rulePExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPParenthesizedExpressionAccess().getPExpressionParserRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PParenthesizedExpression__Group__1__Impl"


    // $ANTLR start "rule__PParenthesizedExpression__Group__2"
    // InternalPerl.g:3994:1: rule__PParenthesizedExpression__Group__2 : rule__PParenthesizedExpression__Group__2__Impl ;
    public final void rule__PParenthesizedExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3998:1: ( rule__PParenthesizedExpression__Group__2__Impl )
            // InternalPerl.g:3999:2: rule__PParenthesizedExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PParenthesizedExpression__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PParenthesizedExpression__Group__2"


    // $ANTLR start "rule__PParenthesizedExpression__Group__2__Impl"
    // InternalPerl.g:4005:1: rule__PParenthesizedExpression__Group__2__Impl : ( ')' ) ;
    public final void rule__PParenthesizedExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4009:1: ( ( ')' ) )
            // InternalPerl.g:4010:1: ( ')' )
            {
            // InternalPerl.g:4010:1: ( ')' )
            // InternalPerl.g:4011:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PParenthesizedExpression__Group__2__Impl"


    // $ANTLR start "rule__PIfExpression__Group__0"
    // InternalPerl.g:4021:1: rule__PIfExpression__Group__0 : rule__PIfExpression__Group__0__Impl rule__PIfExpression__Group__1 ;
    public final void rule__PIfExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4025:1: ( rule__PIfExpression__Group__0__Impl rule__PIfExpression__Group__1 )
            // InternalPerl.g:4026:2: rule__PIfExpression__Group__0__Impl rule__PIfExpression__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__PIfExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PIfExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__0"


    // $ANTLR start "rule__PIfExpression__Group__0__Impl"
    // InternalPerl.g:4033:1: rule__PIfExpression__Group__0__Impl : ( () ) ;
    public final void rule__PIfExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4037:1: ( ( () ) )
            // InternalPerl.g:4038:1: ( () )
            {
            // InternalPerl.g:4038:1: ( () )
            // InternalPerl.g:4039:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getPIfExpressionAction_0()); 
            }
            // InternalPerl.g:4040:2: ()
            // InternalPerl.g:4040:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getPIfExpressionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__0__Impl"


    // $ANTLR start "rule__PIfExpression__Group__1"
    // InternalPerl.g:4048:1: rule__PIfExpression__Group__1 : rule__PIfExpression__Group__1__Impl rule__PIfExpression__Group__2 ;
    public final void rule__PIfExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4052:1: ( rule__PIfExpression__Group__1__Impl rule__PIfExpression__Group__2 )
            // InternalPerl.g:4053:2: rule__PIfExpression__Group__1__Impl rule__PIfExpression__Group__2
            {
            pushFollow(FOLLOW_34);
            rule__PIfExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PIfExpression__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__1"


    // $ANTLR start "rule__PIfExpression__Group__1__Impl"
    // InternalPerl.g:4060:1: rule__PIfExpression__Group__1__Impl : ( 'if' ) ;
    public final void rule__PIfExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4064:1: ( ( 'if' ) )
            // InternalPerl.g:4065:1: ( 'if' )
            {
            // InternalPerl.g:4065:1: ( 'if' )
            // InternalPerl.g:4066:2: 'if'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getIfKeyword_1()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getIfKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__1__Impl"


    // $ANTLR start "rule__PIfExpression__Group__2"
    // InternalPerl.g:4075:1: rule__PIfExpression__Group__2 : rule__PIfExpression__Group__2__Impl rule__PIfExpression__Group__3 ;
    public final void rule__PIfExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4079:1: ( rule__PIfExpression__Group__2__Impl rule__PIfExpression__Group__3 )
            // InternalPerl.g:4080:2: rule__PIfExpression__Group__2__Impl rule__PIfExpression__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__PIfExpression__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PIfExpression__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__2"


    // $ANTLR start "rule__PIfExpression__Group__2__Impl"
    // InternalPerl.g:4087:1: rule__PIfExpression__Group__2__Impl : ( '(' ) ;
    public final void rule__PIfExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4091:1: ( ( '(' ) )
            // InternalPerl.g:4092:1: ( '(' )
            {
            // InternalPerl.g:4092:1: ( '(' )
            // InternalPerl.g:4093:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getLeftParenthesisKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__2__Impl"


    // $ANTLR start "rule__PIfExpression__Group__3"
    // InternalPerl.g:4102:1: rule__PIfExpression__Group__3 : rule__PIfExpression__Group__3__Impl rule__PIfExpression__Group__4 ;
    public final void rule__PIfExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4106:1: ( rule__PIfExpression__Group__3__Impl rule__PIfExpression__Group__4 )
            // InternalPerl.g:4107:2: rule__PIfExpression__Group__3__Impl rule__PIfExpression__Group__4
            {
            pushFollow(FOLLOW_32);
            rule__PIfExpression__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PIfExpression__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__3"


    // $ANTLR start "rule__PIfExpression__Group__3__Impl"
    // InternalPerl.g:4114:1: rule__PIfExpression__Group__3__Impl : ( ( rule__PIfExpression__IfAssignment_3 ) ) ;
    public final void rule__PIfExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4118:1: ( ( ( rule__PIfExpression__IfAssignment_3 ) ) )
            // InternalPerl.g:4119:1: ( ( rule__PIfExpression__IfAssignment_3 ) )
            {
            // InternalPerl.g:4119:1: ( ( rule__PIfExpression__IfAssignment_3 ) )
            // InternalPerl.g:4120:2: ( rule__PIfExpression__IfAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getIfAssignment_3()); 
            }
            // InternalPerl.g:4121:2: ( rule__PIfExpression__IfAssignment_3 )
            // InternalPerl.g:4121:3: rule__PIfExpression__IfAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__PIfExpression__IfAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getIfAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__3__Impl"


    // $ANTLR start "rule__PIfExpression__Group__4"
    // InternalPerl.g:4129:1: rule__PIfExpression__Group__4 : rule__PIfExpression__Group__4__Impl rule__PIfExpression__Group__5 ;
    public final void rule__PIfExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4133:1: ( rule__PIfExpression__Group__4__Impl rule__PIfExpression__Group__5 )
            // InternalPerl.g:4134:2: rule__PIfExpression__Group__4__Impl rule__PIfExpression__Group__5
            {
            pushFollow(FOLLOW_26);
            rule__PIfExpression__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PIfExpression__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__4"


    // $ANTLR start "rule__PIfExpression__Group__4__Impl"
    // InternalPerl.g:4141:1: rule__PIfExpression__Group__4__Impl : ( ')' ) ;
    public final void rule__PIfExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4145:1: ( ( ')' ) )
            // InternalPerl.g:4146:1: ( ')' )
            {
            // InternalPerl.g:4146:1: ( ')' )
            // InternalPerl.g:4147:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getRightParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__4__Impl"


    // $ANTLR start "rule__PIfExpression__Group__5"
    // InternalPerl.g:4156:1: rule__PIfExpression__Group__5 : rule__PIfExpression__Group__5__Impl rule__PIfExpression__Group__6 ;
    public final void rule__PIfExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4160:1: ( rule__PIfExpression__Group__5__Impl rule__PIfExpression__Group__6 )
            // InternalPerl.g:4161:2: rule__PIfExpression__Group__5__Impl rule__PIfExpression__Group__6
            {
            pushFollow(FOLLOW_35);
            rule__PIfExpression__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PIfExpression__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__5"


    // $ANTLR start "rule__PIfExpression__Group__5__Impl"
    // InternalPerl.g:4168:1: rule__PIfExpression__Group__5__Impl : ( ( rule__PIfExpression__ThenAssignment_5 ) ) ;
    public final void rule__PIfExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4172:1: ( ( ( rule__PIfExpression__ThenAssignment_5 ) ) )
            // InternalPerl.g:4173:1: ( ( rule__PIfExpression__ThenAssignment_5 ) )
            {
            // InternalPerl.g:4173:1: ( ( rule__PIfExpression__ThenAssignment_5 ) )
            // InternalPerl.g:4174:2: ( rule__PIfExpression__ThenAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getThenAssignment_5()); 
            }
            // InternalPerl.g:4175:2: ( rule__PIfExpression__ThenAssignment_5 )
            // InternalPerl.g:4175:3: rule__PIfExpression__ThenAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__PIfExpression__ThenAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getThenAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__5__Impl"


    // $ANTLR start "rule__PIfExpression__Group__6"
    // InternalPerl.g:4183:1: rule__PIfExpression__Group__6 : rule__PIfExpression__Group__6__Impl ;
    public final void rule__PIfExpression__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4187:1: ( rule__PIfExpression__Group__6__Impl )
            // InternalPerl.g:4188:2: rule__PIfExpression__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PIfExpression__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__6"


    // $ANTLR start "rule__PIfExpression__Group__6__Impl"
    // InternalPerl.g:4194:1: rule__PIfExpression__Group__6__Impl : ( ( rule__PIfExpression__Group_6__0 )? ) ;
    public final void rule__PIfExpression__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4198:1: ( ( ( rule__PIfExpression__Group_6__0 )? ) )
            // InternalPerl.g:4199:1: ( ( rule__PIfExpression__Group_6__0 )? )
            {
            // InternalPerl.g:4199:1: ( ( rule__PIfExpression__Group_6__0 )? )
            // InternalPerl.g:4200:2: ( rule__PIfExpression__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getGroup_6()); 
            }
            // InternalPerl.g:4201:2: ( rule__PIfExpression__Group_6__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==52) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalPerl.g:4201:3: rule__PIfExpression__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PIfExpression__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group__6__Impl"


    // $ANTLR start "rule__PIfExpression__Group_6__0"
    // InternalPerl.g:4210:1: rule__PIfExpression__Group_6__0 : rule__PIfExpression__Group_6__0__Impl rule__PIfExpression__Group_6__1 ;
    public final void rule__PIfExpression__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4214:1: ( rule__PIfExpression__Group_6__0__Impl rule__PIfExpression__Group_6__1 )
            // InternalPerl.g:4215:2: rule__PIfExpression__Group_6__0__Impl rule__PIfExpression__Group_6__1
            {
            pushFollow(FOLLOW_26);
            rule__PIfExpression__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PIfExpression__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group_6__0"


    // $ANTLR start "rule__PIfExpression__Group_6__0__Impl"
    // InternalPerl.g:4222:1: rule__PIfExpression__Group_6__0__Impl : ( ( 'else' ) ) ;
    public final void rule__PIfExpression__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4226:1: ( ( ( 'else' ) ) )
            // InternalPerl.g:4227:1: ( ( 'else' ) )
            {
            // InternalPerl.g:4227:1: ( ( 'else' ) )
            // InternalPerl.g:4228:2: ( 'else' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getElseKeyword_6_0()); 
            }
            // InternalPerl.g:4229:2: ( 'else' )
            // InternalPerl.g:4229:3: 'else'
            {
            match(input,52,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getElseKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group_6__0__Impl"


    // $ANTLR start "rule__PIfExpression__Group_6__1"
    // InternalPerl.g:4237:1: rule__PIfExpression__Group_6__1 : rule__PIfExpression__Group_6__1__Impl ;
    public final void rule__PIfExpression__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4241:1: ( rule__PIfExpression__Group_6__1__Impl )
            // InternalPerl.g:4242:2: rule__PIfExpression__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PIfExpression__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group_6__1"


    // $ANTLR start "rule__PIfExpression__Group_6__1__Impl"
    // InternalPerl.g:4248:1: rule__PIfExpression__Group_6__1__Impl : ( ( rule__PIfExpression__ElseAssignment_6_1 ) ) ;
    public final void rule__PIfExpression__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4252:1: ( ( ( rule__PIfExpression__ElseAssignment_6_1 ) ) )
            // InternalPerl.g:4253:1: ( ( rule__PIfExpression__ElseAssignment_6_1 ) )
            {
            // InternalPerl.g:4253:1: ( ( rule__PIfExpression__ElseAssignment_6_1 ) )
            // InternalPerl.g:4254:2: ( rule__PIfExpression__ElseAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getElseAssignment_6_1()); 
            }
            // InternalPerl.g:4255:2: ( rule__PIfExpression__ElseAssignment_6_1 )
            // InternalPerl.g:4255:3: rule__PIfExpression__ElseAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__PIfExpression__ElseAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getElseAssignment_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__Group_6__1__Impl"


    // $ANTLR start "rule__PBlockExpression__Group__0"
    // InternalPerl.g:4264:1: rule__PBlockExpression__Group__0 : rule__PBlockExpression__Group__0__Impl rule__PBlockExpression__Group__1 ;
    public final void rule__PBlockExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4268:1: ( rule__PBlockExpression__Group__0__Impl rule__PBlockExpression__Group__1 )
            // InternalPerl.g:4269:2: rule__PBlockExpression__Group__0__Impl rule__PBlockExpression__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__PBlockExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PBlockExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group__0"


    // $ANTLR start "rule__PBlockExpression__Group__0__Impl"
    // InternalPerl.g:4276:1: rule__PBlockExpression__Group__0__Impl : ( () ) ;
    public final void rule__PBlockExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4280:1: ( ( () ) )
            // InternalPerl.g:4281:1: ( () )
            {
            // InternalPerl.g:4281:1: ( () )
            // InternalPerl.g:4282:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getPBlockExpressionAction_0()); 
            }
            // InternalPerl.g:4283:2: ()
            // InternalPerl.g:4283:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPBlockExpressionAccess().getPBlockExpressionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group__0__Impl"


    // $ANTLR start "rule__PBlockExpression__Group__1"
    // InternalPerl.g:4291:1: rule__PBlockExpression__Group__1 : rule__PBlockExpression__Group__1__Impl rule__PBlockExpression__Group__2 ;
    public final void rule__PBlockExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4295:1: ( rule__PBlockExpression__Group__1__Impl rule__PBlockExpression__Group__2 )
            // InternalPerl.g:4296:2: rule__PBlockExpression__Group__1__Impl rule__PBlockExpression__Group__2
            {
            pushFollow(FOLLOW_36);
            rule__PBlockExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PBlockExpression__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group__1"


    // $ANTLR start "rule__PBlockExpression__Group__1__Impl"
    // InternalPerl.g:4303:1: rule__PBlockExpression__Group__1__Impl : ( '{' ) ;
    public final void rule__PBlockExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4307:1: ( ( '{' ) )
            // InternalPerl.g:4308:1: ( '{' )
            {
            // InternalPerl.g:4308:1: ( '{' )
            // InternalPerl.g:4309:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPBlockExpressionAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group__1__Impl"


    // $ANTLR start "rule__PBlockExpression__Group__2"
    // InternalPerl.g:4318:1: rule__PBlockExpression__Group__2 : rule__PBlockExpression__Group__2__Impl rule__PBlockExpression__Group__3 ;
    public final void rule__PBlockExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4322:1: ( rule__PBlockExpression__Group__2__Impl rule__PBlockExpression__Group__3 )
            // InternalPerl.g:4323:2: rule__PBlockExpression__Group__2__Impl rule__PBlockExpression__Group__3
            {
            pushFollow(FOLLOW_36);
            rule__PBlockExpression__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PBlockExpression__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group__2"


    // $ANTLR start "rule__PBlockExpression__Group__2__Impl"
    // InternalPerl.g:4330:1: rule__PBlockExpression__Group__2__Impl : ( ( rule__PBlockExpression__Group_2__0 )* ) ;
    public final void rule__PBlockExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4334:1: ( ( ( rule__PBlockExpression__Group_2__0 )* ) )
            // InternalPerl.g:4335:1: ( ( rule__PBlockExpression__Group_2__0 )* )
            {
            // InternalPerl.g:4335:1: ( ( rule__PBlockExpression__Group_2__0 )* )
            // InternalPerl.g:4336:2: ( rule__PBlockExpression__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getGroup_2()); 
            }
            // InternalPerl.g:4337:2: ( rule__PBlockExpression__Group_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_VAR_START||(LA28_0>=33 && LA28_0<=34)||LA28_0==39||(LA28_0>=42 && LA28_0<=44)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalPerl.g:4337:3: rule__PBlockExpression__Group_2__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__PBlockExpression__Group_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPBlockExpressionAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group__2__Impl"


    // $ANTLR start "rule__PBlockExpression__Group__3"
    // InternalPerl.g:4345:1: rule__PBlockExpression__Group__3 : rule__PBlockExpression__Group__3__Impl ;
    public final void rule__PBlockExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4349:1: ( rule__PBlockExpression__Group__3__Impl )
            // InternalPerl.g:4350:2: rule__PBlockExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PBlockExpression__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group__3"


    // $ANTLR start "rule__PBlockExpression__Group__3__Impl"
    // InternalPerl.g:4356:1: rule__PBlockExpression__Group__3__Impl : ( '}' ) ;
    public final void rule__PBlockExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4360:1: ( ( '}' ) )
            // InternalPerl.g:4361:1: ( '}' )
            {
            // InternalPerl.g:4361:1: ( '}' )
            // InternalPerl.g:4362:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPBlockExpressionAccess().getRightCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group__3__Impl"


    // $ANTLR start "rule__PBlockExpression__Group_2__0"
    // InternalPerl.g:4372:1: rule__PBlockExpression__Group_2__0 : rule__PBlockExpression__Group_2__0__Impl rule__PBlockExpression__Group_2__1 ;
    public final void rule__PBlockExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4376:1: ( rule__PBlockExpression__Group_2__0__Impl rule__PBlockExpression__Group_2__1 )
            // InternalPerl.g:4377:2: rule__PBlockExpression__Group_2__0__Impl rule__PBlockExpression__Group_2__1
            {
            pushFollow(FOLLOW_31);
            rule__PBlockExpression__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PBlockExpression__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group_2__0"


    // $ANTLR start "rule__PBlockExpression__Group_2__0__Impl"
    // InternalPerl.g:4384:1: rule__PBlockExpression__Group_2__0__Impl : ( ( rule__PBlockExpression__ExpressionsAssignment_2_0 ) ) ;
    public final void rule__PBlockExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4388:1: ( ( ( rule__PBlockExpression__ExpressionsAssignment_2_0 ) ) )
            // InternalPerl.g:4389:1: ( ( rule__PBlockExpression__ExpressionsAssignment_2_0 ) )
            {
            // InternalPerl.g:4389:1: ( ( rule__PBlockExpression__ExpressionsAssignment_2_0 ) )
            // InternalPerl.g:4390:2: ( rule__PBlockExpression__ExpressionsAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getExpressionsAssignment_2_0()); 
            }
            // InternalPerl.g:4391:2: ( rule__PBlockExpression__ExpressionsAssignment_2_0 )
            // InternalPerl.g:4391:3: rule__PBlockExpression__ExpressionsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__PBlockExpression__ExpressionsAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPBlockExpressionAccess().getExpressionsAssignment_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group_2__0__Impl"


    // $ANTLR start "rule__PBlockExpression__Group_2__1"
    // InternalPerl.g:4399:1: rule__PBlockExpression__Group_2__1 : rule__PBlockExpression__Group_2__1__Impl ;
    public final void rule__PBlockExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4403:1: ( rule__PBlockExpression__Group_2__1__Impl )
            // InternalPerl.g:4404:2: rule__PBlockExpression__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PBlockExpression__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group_2__1"


    // $ANTLR start "rule__PBlockExpression__Group_2__1__Impl"
    // InternalPerl.g:4410:1: rule__PBlockExpression__Group_2__1__Impl : ( ( ';' )? ) ;
    public final void rule__PBlockExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4414:1: ( ( ( ';' )? ) )
            // InternalPerl.g:4415:1: ( ( ';' )? )
            {
            // InternalPerl.g:4415:1: ( ( ';' )? )
            // InternalPerl.g:4416:2: ( ';' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getSemicolonKeyword_2_1()); 
            }
            // InternalPerl.g:4417:2: ( ';' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==48) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalPerl.g:4417:3: ';'
                    {
                    match(input,48,FOLLOW_2); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPBlockExpressionAccess().getSemicolonKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__Group_2__1__Impl"


    // $ANTLR start "rule__PVariableDeclaration__Group__0"
    // InternalPerl.g:4426:1: rule__PVariableDeclaration__Group__0 : rule__PVariableDeclaration__Group__0__Impl rule__PVariableDeclaration__Group__1 ;
    public final void rule__PVariableDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4430:1: ( rule__PVariableDeclaration__Group__0__Impl rule__PVariableDeclaration__Group__1 )
            // InternalPerl.g:4431:2: rule__PVariableDeclaration__Group__0__Impl rule__PVariableDeclaration__Group__1
            {
            pushFollow(FOLLOW_37);
            rule__PVariableDeclaration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group__0"


    // $ANTLR start "rule__PVariableDeclaration__Group__0__Impl"
    // InternalPerl.g:4438:1: rule__PVariableDeclaration__Group__0__Impl : ( () ) ;
    public final void rule__PVariableDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4442:1: ( ( () ) )
            // InternalPerl.g:4443:1: ( () )
            {
            // InternalPerl.g:4443:1: ( () )
            // InternalPerl.g:4444:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getPVariableDeclarationAction_0()); 
            }
            // InternalPerl.g:4445:2: ()
            // InternalPerl.g:4445:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getPVariableDeclarationAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group__0__Impl"


    // $ANTLR start "rule__PVariableDeclaration__Group__1"
    // InternalPerl.g:4453:1: rule__PVariableDeclaration__Group__1 : rule__PVariableDeclaration__Group__1__Impl rule__PVariableDeclaration__Group__2 ;
    public final void rule__PVariableDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4457:1: ( rule__PVariableDeclaration__Group__1__Impl rule__PVariableDeclaration__Group__2 )
            // InternalPerl.g:4458:2: rule__PVariableDeclaration__Group__1__Impl rule__PVariableDeclaration__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__PVariableDeclaration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group__1"


    // $ANTLR start "rule__PVariableDeclaration__Group__1__Impl"
    // InternalPerl.g:4465:1: rule__PVariableDeclaration__Group__1__Impl : ( ( rule__PVariableDeclaration__Alternatives_1 ) ) ;
    public final void rule__PVariableDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4469:1: ( ( ( rule__PVariableDeclaration__Alternatives_1 ) ) )
            // InternalPerl.g:4470:1: ( ( rule__PVariableDeclaration__Alternatives_1 ) )
            {
            // InternalPerl.g:4470:1: ( ( rule__PVariableDeclaration__Alternatives_1 ) )
            // InternalPerl.g:4471:2: ( rule__PVariableDeclaration__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getAlternatives_1()); 
            }
            // InternalPerl.g:4472:2: ( rule__PVariableDeclaration__Alternatives_1 )
            // InternalPerl.g:4472:3: rule__PVariableDeclaration__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group__1__Impl"


    // $ANTLR start "rule__PVariableDeclaration__Group__2"
    // InternalPerl.g:4480:1: rule__PVariableDeclaration__Group__2 : rule__PVariableDeclaration__Group__2__Impl rule__PVariableDeclaration__Group__3 ;
    public final void rule__PVariableDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4484:1: ( rule__PVariableDeclaration__Group__2__Impl rule__PVariableDeclaration__Group__3 )
            // InternalPerl.g:4485:2: rule__PVariableDeclaration__Group__2__Impl rule__PVariableDeclaration__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__PVariableDeclaration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group__2"


    // $ANTLR start "rule__PVariableDeclaration__Group__2__Impl"
    // InternalPerl.g:4492:1: rule__PVariableDeclaration__Group__2__Impl : ( ( rule__PVariableDeclaration__Group_2__0 ) ) ;
    public final void rule__PVariableDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4496:1: ( ( ( rule__PVariableDeclaration__Group_2__0 ) ) )
            // InternalPerl.g:4497:1: ( ( rule__PVariableDeclaration__Group_2__0 ) )
            {
            // InternalPerl.g:4497:1: ( ( rule__PVariableDeclaration__Group_2__0 ) )
            // InternalPerl.g:4498:2: ( rule__PVariableDeclaration__Group_2__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getGroup_2()); 
            }
            // InternalPerl.g:4499:2: ( rule__PVariableDeclaration__Group_2__0 )
            // InternalPerl.g:4499:3: rule__PVariableDeclaration__Group_2__0
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group_2__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group__2__Impl"


    // $ANTLR start "rule__PVariableDeclaration__Group__3"
    // InternalPerl.g:4507:1: rule__PVariableDeclaration__Group__3 : rule__PVariableDeclaration__Group__3__Impl ;
    public final void rule__PVariableDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4511:1: ( rule__PVariableDeclaration__Group__3__Impl )
            // InternalPerl.g:4512:2: rule__PVariableDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group__3"


    // $ANTLR start "rule__PVariableDeclaration__Group__3__Impl"
    // InternalPerl.g:4518:1: rule__PVariableDeclaration__Group__3__Impl : ( ( rule__PVariableDeclaration__Group_3__0 )? ) ;
    public final void rule__PVariableDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4522:1: ( ( ( rule__PVariableDeclaration__Group_3__0 )? ) )
            // InternalPerl.g:4523:1: ( ( rule__PVariableDeclaration__Group_3__0 )? )
            {
            // InternalPerl.g:4523:1: ( ( rule__PVariableDeclaration__Group_3__0 )? )
            // InternalPerl.g:4524:2: ( rule__PVariableDeclaration__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getGroup_3()); 
            }
            // InternalPerl.g:4525:2: ( rule__PVariableDeclaration__Group_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==14) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalPerl.g:4525:3: rule__PVariableDeclaration__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PVariableDeclaration__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group__3__Impl"


    // $ANTLR start "rule__PVariableDeclaration__Group_2__0"
    // InternalPerl.g:4534:1: rule__PVariableDeclaration__Group_2__0 : rule__PVariableDeclaration__Group_2__0__Impl ;
    public final void rule__PVariableDeclaration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4538:1: ( rule__PVariableDeclaration__Group_2__0__Impl )
            // InternalPerl.g:4539:2: rule__PVariableDeclaration__Group_2__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group_2__0"


    // $ANTLR start "rule__PVariableDeclaration__Group_2__0__Impl"
    // InternalPerl.g:4545:1: rule__PVariableDeclaration__Group_2__0__Impl : ( ( rule__PVariableDeclaration__NameAssignment_2_0 ) ) ;
    public final void rule__PVariableDeclaration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4549:1: ( ( ( rule__PVariableDeclaration__NameAssignment_2_0 ) ) )
            // InternalPerl.g:4550:1: ( ( rule__PVariableDeclaration__NameAssignment_2_0 ) )
            {
            // InternalPerl.g:4550:1: ( ( rule__PVariableDeclaration__NameAssignment_2_0 ) )
            // InternalPerl.g:4551:2: ( rule__PVariableDeclaration__NameAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getNameAssignment_2_0()); 
            }
            // InternalPerl.g:4552:2: ( rule__PVariableDeclaration__NameAssignment_2_0 )
            // InternalPerl.g:4552:3: rule__PVariableDeclaration__NameAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__NameAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getNameAssignment_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group_2__0__Impl"


    // $ANTLR start "rule__PVariableDeclaration__Group_3__0"
    // InternalPerl.g:4561:1: rule__PVariableDeclaration__Group_3__0 : rule__PVariableDeclaration__Group_3__0__Impl rule__PVariableDeclaration__Group_3__1 ;
    public final void rule__PVariableDeclaration__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4565:1: ( rule__PVariableDeclaration__Group_3__0__Impl rule__PVariableDeclaration__Group_3__1 )
            // InternalPerl.g:4566:2: rule__PVariableDeclaration__Group_3__0__Impl rule__PVariableDeclaration__Group_3__1
            {
            pushFollow(FOLLOW_26);
            rule__PVariableDeclaration__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group_3__0"


    // $ANTLR start "rule__PVariableDeclaration__Group_3__0__Impl"
    // InternalPerl.g:4573:1: rule__PVariableDeclaration__Group_3__0__Impl : ( '=' ) ;
    public final void rule__PVariableDeclaration__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4577:1: ( ( '=' ) )
            // InternalPerl.g:4578:1: ( '=' )
            {
            // InternalPerl.g:4578:1: ( '=' )
            // InternalPerl.g:4579:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getEqualsSignKeyword_3_0()); 
            }
            match(input,14,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getEqualsSignKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group_3__0__Impl"


    // $ANTLR start "rule__PVariableDeclaration__Group_3__1"
    // InternalPerl.g:4588:1: rule__PVariableDeclaration__Group_3__1 : rule__PVariableDeclaration__Group_3__1__Impl ;
    public final void rule__PVariableDeclaration__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4592:1: ( rule__PVariableDeclaration__Group_3__1__Impl )
            // InternalPerl.g:4593:2: rule__PVariableDeclaration__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group_3__1"


    // $ANTLR start "rule__PVariableDeclaration__Group_3__1__Impl"
    // InternalPerl.g:4599:1: rule__PVariableDeclaration__Group_3__1__Impl : ( ( rule__PVariableDeclaration__RightAssignment_3_1 ) ) ;
    public final void rule__PVariableDeclaration__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4603:1: ( ( ( rule__PVariableDeclaration__RightAssignment_3_1 ) ) )
            // InternalPerl.g:4604:1: ( ( rule__PVariableDeclaration__RightAssignment_3_1 ) )
            {
            // InternalPerl.g:4604:1: ( ( rule__PVariableDeclaration__RightAssignment_3_1 ) )
            // InternalPerl.g:4605:2: ( rule__PVariableDeclaration__RightAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getRightAssignment_3_1()); 
            }
            // InternalPerl.g:4606:2: ( rule__PVariableDeclaration__RightAssignment_3_1 )
            // InternalPerl.g:4606:3: rule__PVariableDeclaration__RightAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__RightAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getRightAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__Group_3__1__Impl"


    // $ANTLR start "rule__PNumberLiteral__Group__0"
    // InternalPerl.g:4615:1: rule__PNumberLiteral__Group__0 : rule__PNumberLiteral__Group__0__Impl rule__PNumberLiteral__Group__1 ;
    public final void rule__PNumberLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4619:1: ( rule__PNumberLiteral__Group__0__Impl rule__PNumberLiteral__Group__1 )
            // InternalPerl.g:4620:2: rule__PNumberLiteral__Group__0__Impl rule__PNumberLiteral__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__PNumberLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PNumberLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PNumberLiteral__Group__0"


    // $ANTLR start "rule__PNumberLiteral__Group__0__Impl"
    // InternalPerl.g:4627:1: rule__PNumberLiteral__Group__0__Impl : ( () ) ;
    public final void rule__PNumberLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4631:1: ( ( () ) )
            // InternalPerl.g:4632:1: ( () )
            {
            // InternalPerl.g:4632:1: ( () )
            // InternalPerl.g:4633:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNumberLiteralAccess().getPNumberLiteralAction_0()); 
            }
            // InternalPerl.g:4634:2: ()
            // InternalPerl.g:4634:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPNumberLiteralAccess().getPNumberLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PNumberLiteral__Group__0__Impl"


    // $ANTLR start "rule__PNumberLiteral__Group__1"
    // InternalPerl.g:4642:1: rule__PNumberLiteral__Group__1 : rule__PNumberLiteral__Group__1__Impl ;
    public final void rule__PNumberLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4646:1: ( rule__PNumberLiteral__Group__1__Impl )
            // InternalPerl.g:4647:2: rule__PNumberLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PNumberLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PNumberLiteral__Group__1"


    // $ANTLR start "rule__PNumberLiteral__Group__1__Impl"
    // InternalPerl.g:4653:1: rule__PNumberLiteral__Group__1__Impl : ( ( rule__PNumberLiteral__ValueAssignment_1 ) ) ;
    public final void rule__PNumberLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4657:1: ( ( ( rule__PNumberLiteral__ValueAssignment_1 ) ) )
            // InternalPerl.g:4658:1: ( ( rule__PNumberLiteral__ValueAssignment_1 ) )
            {
            // InternalPerl.g:4658:1: ( ( rule__PNumberLiteral__ValueAssignment_1 ) )
            // InternalPerl.g:4659:2: ( rule__PNumberLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNumberLiteralAccess().getValueAssignment_1()); 
            }
            // InternalPerl.g:4660:2: ( rule__PNumberLiteral__ValueAssignment_1 )
            // InternalPerl.g:4660:3: rule__PNumberLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PNumberLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPNumberLiteralAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PNumberLiteral__Group__1__Impl"


    // $ANTLR start "rule__PNullLiteral__Group__0"
    // InternalPerl.g:4669:1: rule__PNullLiteral__Group__0 : rule__PNullLiteral__Group__0__Impl rule__PNullLiteral__Group__1 ;
    public final void rule__PNullLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4673:1: ( rule__PNullLiteral__Group__0__Impl rule__PNullLiteral__Group__1 )
            // InternalPerl.g:4674:2: rule__PNullLiteral__Group__0__Impl rule__PNullLiteral__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__PNullLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PNullLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PNullLiteral__Group__0"


    // $ANTLR start "rule__PNullLiteral__Group__0__Impl"
    // InternalPerl.g:4681:1: rule__PNullLiteral__Group__0__Impl : ( () ) ;
    public final void rule__PNullLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4685:1: ( ( () ) )
            // InternalPerl.g:4686:1: ( () )
            {
            // InternalPerl.g:4686:1: ( () )
            // InternalPerl.g:4687:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNullLiteralAccess().getPNullLiteralAction_0()); 
            }
            // InternalPerl.g:4688:2: ()
            // InternalPerl.g:4688:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPNullLiteralAccess().getPNullLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PNullLiteral__Group__0__Impl"


    // $ANTLR start "rule__PNullLiteral__Group__1"
    // InternalPerl.g:4696:1: rule__PNullLiteral__Group__1 : rule__PNullLiteral__Group__1__Impl ;
    public final void rule__PNullLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4700:1: ( rule__PNullLiteral__Group__1__Impl )
            // InternalPerl.g:4701:2: rule__PNullLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PNullLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PNullLiteral__Group__1"


    // $ANTLR start "rule__PNullLiteral__Group__1__Impl"
    // InternalPerl.g:4707:1: rule__PNullLiteral__Group__1__Impl : ( 'undef' ) ;
    public final void rule__PNullLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4711:1: ( ( 'undef' ) )
            // InternalPerl.g:4712:1: ( 'undef' )
            {
            // InternalPerl.g:4712:1: ( 'undef' )
            // InternalPerl.g:4713:2: 'undef'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNullLiteralAccess().getUndefKeyword_1()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPNullLiteralAccess().getUndefKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PNullLiteral__Group__1__Impl"


    // $ANTLR start "rule__PReturnExpression__Group__0"
    // InternalPerl.g:4723:1: rule__PReturnExpression__Group__0 : rule__PReturnExpression__Group__0__Impl rule__PReturnExpression__Group__1 ;
    public final void rule__PReturnExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4727:1: ( rule__PReturnExpression__Group__0__Impl rule__PReturnExpression__Group__1 )
            // InternalPerl.g:4728:2: rule__PReturnExpression__Group__0__Impl rule__PReturnExpression__Group__1
            {
            pushFollow(FOLLOW_40);
            rule__PReturnExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PReturnExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PReturnExpression__Group__0"


    // $ANTLR start "rule__PReturnExpression__Group__0__Impl"
    // InternalPerl.g:4735:1: rule__PReturnExpression__Group__0__Impl : ( () ) ;
    public final void rule__PReturnExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4739:1: ( ( () ) )
            // InternalPerl.g:4740:1: ( () )
            {
            // InternalPerl.g:4740:1: ( () )
            // InternalPerl.g:4741:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPReturnExpressionAccess().getPReturnExpressionAction_0()); 
            }
            // InternalPerl.g:4742:2: ()
            // InternalPerl.g:4742:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPReturnExpressionAccess().getPReturnExpressionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PReturnExpression__Group__0__Impl"


    // $ANTLR start "rule__PReturnExpression__Group__1"
    // InternalPerl.g:4750:1: rule__PReturnExpression__Group__1 : rule__PReturnExpression__Group__1__Impl rule__PReturnExpression__Group__2 ;
    public final void rule__PReturnExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4754:1: ( rule__PReturnExpression__Group__1__Impl rule__PReturnExpression__Group__2 )
            // InternalPerl.g:4755:2: rule__PReturnExpression__Group__1__Impl rule__PReturnExpression__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__PReturnExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PReturnExpression__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PReturnExpression__Group__1"


    // $ANTLR start "rule__PReturnExpression__Group__1__Impl"
    // InternalPerl.g:4762:1: rule__PReturnExpression__Group__1__Impl : ( 'return' ) ;
    public final void rule__PReturnExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4766:1: ( ( 'return' ) )
            // InternalPerl.g:4767:1: ( 'return' )
            {
            // InternalPerl.g:4767:1: ( 'return' )
            // InternalPerl.g:4768:2: 'return'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPReturnExpressionAccess().getReturnKeyword_1()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPReturnExpressionAccess().getReturnKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PReturnExpression__Group__1__Impl"


    // $ANTLR start "rule__PReturnExpression__Group__2"
    // InternalPerl.g:4777:1: rule__PReturnExpression__Group__2 : rule__PReturnExpression__Group__2__Impl ;
    public final void rule__PReturnExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4781:1: ( rule__PReturnExpression__Group__2__Impl )
            // InternalPerl.g:4782:2: rule__PReturnExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PReturnExpression__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PReturnExpression__Group__2"


    // $ANTLR start "rule__PReturnExpression__Group__2__Impl"
    // InternalPerl.g:4788:1: rule__PReturnExpression__Group__2__Impl : ( ( rule__PReturnExpression__ExpressionAssignment_2 )? ) ;
    public final void rule__PReturnExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4792:1: ( ( ( rule__PReturnExpression__ExpressionAssignment_2 )? ) )
            // InternalPerl.g:4793:1: ( ( rule__PReturnExpression__ExpressionAssignment_2 )? )
            {
            // InternalPerl.g:4793:1: ( ( rule__PReturnExpression__ExpressionAssignment_2 )? )
            // InternalPerl.g:4794:2: ( rule__PReturnExpression__ExpressionAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPReturnExpressionAccess().getExpressionAssignment_2()); 
            }
            // InternalPerl.g:4795:2: ( rule__PReturnExpression__ExpressionAssignment_2 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_VAR_START||(LA31_0>=33 && LA31_0<=34)||LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalPerl.g:4795:3: rule__PReturnExpression__ExpressionAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__PReturnExpression__ExpressionAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPReturnExpressionAccess().getExpressionAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PReturnExpression__Group__2__Impl"


    // $ANTLR start "rule__PStringLiteral__Group__0"
    // InternalPerl.g:4804:1: rule__PStringLiteral__Group__0 : rule__PStringLiteral__Group__0__Impl rule__PStringLiteral__Group__1 ;
    public final void rule__PStringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4808:1: ( rule__PStringLiteral__Group__0__Impl rule__PStringLiteral__Group__1 )
            // InternalPerl.g:4809:2: rule__PStringLiteral__Group__0__Impl rule__PStringLiteral__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__PStringLiteral__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PStringLiteral__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PStringLiteral__Group__0"


    // $ANTLR start "rule__PStringLiteral__Group__0__Impl"
    // InternalPerl.g:4816:1: rule__PStringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__PStringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4820:1: ( ( () ) )
            // InternalPerl.g:4821:1: ( () )
            {
            // InternalPerl.g:4821:1: ( () )
            // InternalPerl.g:4822:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPStringLiteralAccess().getPStringLiteralAction_0()); 
            }
            // InternalPerl.g:4823:2: ()
            // InternalPerl.g:4823:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPStringLiteralAccess().getPStringLiteralAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PStringLiteral__Group__0__Impl"


    // $ANTLR start "rule__PStringLiteral__Group__1"
    // InternalPerl.g:4831:1: rule__PStringLiteral__Group__1 : rule__PStringLiteral__Group__1__Impl ;
    public final void rule__PStringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4835:1: ( rule__PStringLiteral__Group__1__Impl )
            // InternalPerl.g:4836:2: rule__PStringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PStringLiteral__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PStringLiteral__Group__1"


    // $ANTLR start "rule__PStringLiteral__Group__1__Impl"
    // InternalPerl.g:4842:1: rule__PStringLiteral__Group__1__Impl : ( ( rule__PStringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__PStringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4846:1: ( ( ( rule__PStringLiteral__ValueAssignment_1 ) ) )
            // InternalPerl.g:4847:1: ( ( rule__PStringLiteral__ValueAssignment_1 ) )
            {
            // InternalPerl.g:4847:1: ( ( rule__PStringLiteral__ValueAssignment_1 ) )
            // InternalPerl.g:4848:2: ( rule__PStringLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPStringLiteralAccess().getValueAssignment_1()); 
            }
            // InternalPerl.g:4849:2: ( rule__PStringLiteral__ValueAssignment_1 )
            // InternalPerl.g:4849:3: rule__PStringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PStringLiteral__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPStringLiteralAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PStringLiteral__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalPerl.g:4858:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4862:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalPerl.g:4863:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalPerl.g:4870:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4874:1: ( ( RULE_ID ) )
            // InternalPerl.g:4875:1: ( RULE_ID )
            {
            // InternalPerl.g:4875:1: ( RULE_ID )
            // InternalPerl.g:4876:2: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalPerl.g:4885:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4889:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalPerl.g:4890:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalPerl.g:4896:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4900:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalPerl.g:4901:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalPerl.g:4901:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalPerl.g:4902:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalPerl.g:4903:2: ( rule__QualifiedName__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==55) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalPerl.g:4903:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalPerl.g:4912:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4916:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalPerl.g:4917:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_25);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalPerl.g:4924:1: rule__QualifiedName__Group_1__0__Impl : ( ( '::' ) ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4928:1: ( ( ( '::' ) ) )
            // InternalPerl.g:4929:1: ( ( '::' ) )
            {
            // InternalPerl.g:4929:1: ( ( '::' ) )
            // InternalPerl.g:4930:2: ( '::' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0()); 
            }
            // InternalPerl.g:4931:2: ( '::' )
            // InternalPerl.g:4931:3: '::'
            {
            match(input,55,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalPerl.g:4939:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4943:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalPerl.g:4944:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalPerl.g:4950:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4954:1: ( ( RULE_ID ) )
            // InternalPerl.g:4955:1: ( RULE_ID )
            {
            // InternalPerl.g:4955:1: ( RULE_ID )
            // InternalPerl.g:4956:2: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__PAssignment__VarAssignment_0_1"
    // InternalPerl.g:4966:1: rule__PAssignment__VarAssignment_0_1 : ( rulePVar ) ;
    public final void rule__PAssignment__VarAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4970:1: ( ( rulePVar ) )
            // InternalPerl.g:4971:2: ( rulePVar )
            {
            // InternalPerl.g:4971:2: ( rulePVar )
            // InternalPerl.g:4972:3: rulePVar
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getVarPVarParserRuleCall_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePVar();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getVarPVarParserRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__VarAssignment_0_1"


    // $ANTLR start "rule__PAssignment__ValueAssignment_0_3"
    // InternalPerl.g:4981:1: rule__PAssignment__ValueAssignment_0_3 : ( rulePAssignment ) ;
    public final void rule__PAssignment__ValueAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4985:1: ( ( rulePAssignment ) )
            // InternalPerl.g:4986:2: ( rulePAssignment )
            {
            // InternalPerl.g:4986:2: ( rulePAssignment )
            // InternalPerl.g:4987:3: rulePAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getValuePAssignmentParserRuleCall_0_3_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getValuePAssignmentParserRuleCall_0_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__ValueAssignment_0_3"


    // $ANTLR start "rule__PAssignment__FeatureAssignment_1_1_0_0_1"
    // InternalPerl.g:4996:1: rule__PAssignment__FeatureAssignment_1_1_0_0_1 : ( ruleOpMultiAssign ) ;
    public final void rule__PAssignment__FeatureAssignment_1_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5000:1: ( ( ruleOpMultiAssign ) )
            // InternalPerl.g:5001:2: ( ruleOpMultiAssign )
            {
            // InternalPerl.g:5001:2: ( ruleOpMultiAssign )
            // InternalPerl.g:5002:3: ruleOpMultiAssign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getFeatureOpMultiAssignParserRuleCall_1_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getFeatureOpMultiAssignParserRuleCall_1_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__FeatureAssignment_1_1_0_0_1"


    // $ANTLR start "rule__PAssignment__RightOperandAssignment_1_1_1"
    // InternalPerl.g:5011:1: rule__PAssignment__RightOperandAssignment_1_1_1 : ( rulePAssignment ) ;
    public final void rule__PAssignment__RightOperandAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5015:1: ( ( rulePAssignment ) )
            // InternalPerl.g:5016:2: ( rulePAssignment )
            {
            // InternalPerl.g:5016:2: ( rulePAssignment )
            // InternalPerl.g:5017:3: rulePAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getRightOperandPAssignmentParserRuleCall_1_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getRightOperandPAssignmentParserRuleCall_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAssignment__RightOperandAssignment_1_1_1"


    // $ANTLR start "rule__POrExpression__FeatureAssignment_1_0_0_1"
    // InternalPerl.g:5026:1: rule__POrExpression__FeatureAssignment_1_0_0_1 : ( ruleOpOr ) ;
    public final void rule__POrExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5030:1: ( ( ruleOpOr ) )
            // InternalPerl.g:5031:2: ( ruleOpOr )
            {
            // InternalPerl.g:5031:2: ( ruleOpOr )
            // InternalPerl.g:5032:3: ruleOpOr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getFeatureOpOrParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpOr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionAccess().getFeatureOpOrParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__FeatureAssignment_1_0_0_1"


    // $ANTLR start "rule__POrExpression__RightOperandAssignment_1_1"
    // InternalPerl.g:5041:1: rule__POrExpression__RightOperandAssignment_1_1 : ( rulePAndExpression ) ;
    public final void rule__POrExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5045:1: ( ( rulePAndExpression ) )
            // InternalPerl.g:5046:2: ( rulePAndExpression )
            {
            // InternalPerl.g:5046:2: ( rulePAndExpression )
            // InternalPerl.g:5047:3: rulePAndExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getRightOperandPAndExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOrExpressionAccess().getRightOperandPAndExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POrExpression__RightOperandAssignment_1_1"


    // $ANTLR start "rule__PAndExpression__FeatureAssignment_1_0_0_1"
    // InternalPerl.g:5056:1: rule__PAndExpression__FeatureAssignment_1_0_0_1 : ( ruleOpAnd ) ;
    public final void rule__PAndExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5060:1: ( ( ruleOpAnd ) )
            // InternalPerl.g:5061:2: ( ruleOpAnd )
            {
            // InternalPerl.g:5061:2: ( ruleOpAnd )
            // InternalPerl.g:5062:3: ruleOpAnd
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getFeatureOpAndParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpAnd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionAccess().getFeatureOpAndParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__FeatureAssignment_1_0_0_1"


    // $ANTLR start "rule__PAndExpression__RightOperandAssignment_1_1"
    // InternalPerl.g:5071:1: rule__PAndExpression__RightOperandAssignment_1_1 : ( rulePEqualityExpression ) ;
    public final void rule__PAndExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5075:1: ( ( rulePEqualityExpression ) )
            // InternalPerl.g:5076:2: ( rulePEqualityExpression )
            {
            // InternalPerl.g:5076:2: ( rulePEqualityExpression )
            // InternalPerl.g:5077:3: rulePEqualityExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getRightOperandPEqualityExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePEqualityExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAndExpressionAccess().getRightOperandPEqualityExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAndExpression__RightOperandAssignment_1_1"


    // $ANTLR start "rule__PEqualityExpression__FeatureAssignment_1_0_0_1"
    // InternalPerl.g:5086:1: rule__PEqualityExpression__FeatureAssignment_1_0_0_1 : ( ruleOpEquality ) ;
    public final void rule__PEqualityExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5090:1: ( ( ruleOpEquality ) )
            // InternalPerl.g:5091:2: ( ruleOpEquality )
            {
            // InternalPerl.g:5091:2: ( ruleOpEquality )
            // InternalPerl.g:5092:3: ruleOpEquality
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getFeatureOpEqualityParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpEquality();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionAccess().getFeatureOpEqualityParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__FeatureAssignment_1_0_0_1"


    // $ANTLR start "rule__PEqualityExpression__RightOperandAssignment_1_1"
    // InternalPerl.g:5101:1: rule__PEqualityExpression__RightOperandAssignment_1_1 : ( rulePRelationalExpression ) ;
    public final void rule__PEqualityExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5105:1: ( ( rulePRelationalExpression ) )
            // InternalPerl.g:5106:2: ( rulePRelationalExpression )
            {
            // InternalPerl.g:5106:2: ( rulePRelationalExpression )
            // InternalPerl.g:5107:3: rulePRelationalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getRightOperandPRelationalExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePRelationalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPEqualityExpressionAccess().getRightOperandPRelationalExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEqualityExpression__RightOperandAssignment_1_1"


    // $ANTLR start "rule__PRelationalExpression__FeatureAssignment_1_0_0_1"
    // InternalPerl.g:5116:1: rule__PRelationalExpression__FeatureAssignment_1_0_0_1 : ( ruleOpCompare ) ;
    public final void rule__PRelationalExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5120:1: ( ( ruleOpCompare ) )
            // InternalPerl.g:5121:2: ( ruleOpCompare )
            {
            // InternalPerl.g:5121:2: ( ruleOpCompare )
            // InternalPerl.g:5122:3: ruleOpCompare
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getFeatureOpCompareParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpCompare();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionAccess().getFeatureOpCompareParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__FeatureAssignment_1_0_0_1"


    // $ANTLR start "rule__PRelationalExpression__RightOperandAssignment_1_1"
    // InternalPerl.g:5131:1: rule__PRelationalExpression__RightOperandAssignment_1_1 : ( rulePOtherOperatorExpression ) ;
    public final void rule__PRelationalExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5135:1: ( ( rulePOtherOperatorExpression ) )
            // InternalPerl.g:5136:2: ( rulePOtherOperatorExpression )
            {
            // InternalPerl.g:5136:2: ( rulePOtherOperatorExpression )
            // InternalPerl.g:5137:3: rulePOtherOperatorExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getRightOperandPOtherOperatorExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPRelationalExpressionAccess().getRightOperandPOtherOperatorExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRelationalExpression__RightOperandAssignment_1_1"


    // $ANTLR start "rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1"
    // InternalPerl.g:5146:1: rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 : ( ruleOpOther ) ;
    public final void rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5150:1: ( ( ruleOpOther ) )
            // InternalPerl.g:5151:2: ( ruleOpOther )
            {
            // InternalPerl.g:5151:2: ( ruleOpOther )
            // InternalPerl.g:5152:3: ruleOpOther
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getFeatureOpOtherParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpOther();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionAccess().getFeatureOpOtherParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1"


    // $ANTLR start "rule__POtherOperatorExpression__RightOperandAssignment_1_1"
    // InternalPerl.g:5161:1: rule__POtherOperatorExpression__RightOperandAssignment_1_1 : ( rulePAdditiveExpression ) ;
    public final void rule__POtherOperatorExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5165:1: ( ( rulePAdditiveExpression ) )
            // InternalPerl.g:5166:2: ( rulePAdditiveExpression )
            {
            // InternalPerl.g:5166:2: ( rulePAdditiveExpression )
            // InternalPerl.g:5167:3: rulePAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getRightOperandPAdditiveExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePAdditiveExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOtherOperatorExpressionAccess().getRightOperandPAdditiveExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__POtherOperatorExpression__RightOperandAssignment_1_1"


    // $ANTLR start "rule__PAdditiveExpression__FeatureAssignment_1_0_0_1"
    // InternalPerl.g:5176:1: rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 : ( ruleOpAdd ) ;
    public final void rule__PAdditiveExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5180:1: ( ( ruleOpAdd ) )
            // InternalPerl.g:5181:2: ( ruleOpAdd )
            {
            // InternalPerl.g:5181:2: ( ruleOpAdd )
            // InternalPerl.g:5182:3: ruleOpAdd
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getFeatureOpAddParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpAdd();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionAccess().getFeatureOpAddParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__FeatureAssignment_1_0_0_1"


    // $ANTLR start "rule__PAdditiveExpression__RightOperandAssignment_1_1"
    // InternalPerl.g:5191:1: rule__PAdditiveExpression__RightOperandAssignment_1_1 : ( rulePMultiplicativeExpression ) ;
    public final void rule__PAdditiveExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5195:1: ( ( rulePMultiplicativeExpression ) )
            // InternalPerl.g:5196:2: ( rulePMultiplicativeExpression )
            {
            // InternalPerl.g:5196:2: ( rulePMultiplicativeExpression )
            // InternalPerl.g:5197:3: rulePMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getRightOperandPMultiplicativeExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAdditiveExpressionAccess().getRightOperandPMultiplicativeExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PAdditiveExpression__RightOperandAssignment_1_1"


    // $ANTLR start "rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1"
    // InternalPerl.g:5206:1: rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 : ( ruleOpMulti ) ;
    public final void rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5210:1: ( ( ruleOpMulti ) )
            // InternalPerl.g:5211:2: ( ruleOpMulti )
            {
            // InternalPerl.g:5211:2: ( ruleOpMulti )
            // InternalPerl.g:5212:3: ruleOpMulti
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getFeatureOpMultiParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpMulti();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionAccess().getFeatureOpMultiParserRuleCall_1_0_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1"


    // $ANTLR start "rule__PMultiplicativeExpression__RightOperandAssignment_1_1"
    // InternalPerl.g:5221:1: rule__PMultiplicativeExpression__RightOperandAssignment_1_1 : ( rulePUnaryOperation ) ;
    public final void rule__PMultiplicativeExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5225:1: ( ( rulePUnaryOperation ) )
            // InternalPerl.g:5226:2: ( rulePUnaryOperation )
            {
            // InternalPerl.g:5226:2: ( rulePUnaryOperation )
            // InternalPerl.g:5227:3: rulePUnaryOperation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getRightOperandPUnaryOperationParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePUnaryOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMultiplicativeExpressionAccess().getRightOperandPUnaryOperationParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMultiplicativeExpression__RightOperandAssignment_1_1"


    // $ANTLR start "rule__PUnaryOperation__FeatureAssignment_1"
    // InternalPerl.g:5236:1: rule__PUnaryOperation__FeatureAssignment_1 : ( ruleOpUnary ) ;
    public final void rule__PUnaryOperation__FeatureAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5240:1: ( ( ruleOpUnary ) )
            // InternalPerl.g:5241:2: ( ruleOpUnary )
            {
            // InternalPerl.g:5241:2: ( ruleOpUnary )
            // InternalPerl.g:5242:3: ruleOpUnary
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPUnaryOperationAccess().getFeatureOpUnaryParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpUnary();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPUnaryOperationAccess().getFeatureOpUnaryParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PUnaryOperation__FeatureAssignment_1"


    // $ANTLR start "rule__PUnaryOperation__OperandAssignment_2"
    // InternalPerl.g:5251:1: rule__PUnaryOperation__OperandAssignment_2 : ( rulePUnaryOperation ) ;
    public final void rule__PUnaryOperation__OperandAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5255:1: ( ( rulePUnaryOperation ) )
            // InternalPerl.g:5256:2: ( rulePUnaryOperation )
            {
            // InternalPerl.g:5256:2: ( rulePUnaryOperation )
            // InternalPerl.g:5257:3: rulePUnaryOperation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPUnaryOperationAccess().getOperandPUnaryOperationParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePUnaryOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPUnaryOperationAccess().getOperandPUnaryOperationParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PUnaryOperation__OperandAssignment_2"


    // $ANTLR start "rule__PClosure__ExpressionAssignment_1"
    // InternalPerl.g:5266:1: rule__PClosure__ExpressionAssignment_1 : ( rulePExpressionInClosure ) ;
    public final void rule__PClosure__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5270:1: ( ( rulePExpressionInClosure ) )
            // InternalPerl.g:5271:2: ( rulePExpressionInClosure )
            {
            // InternalPerl.g:5271:2: ( rulePExpressionInClosure )
            // InternalPerl.g:5272:3: rulePExpressionInClosure
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getExpressionPExpressionInClosureParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePExpressionInClosure();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPClosureAccess().getExpressionPExpressionInClosureParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PClosure__ExpressionAssignment_1"


    // $ANTLR start "rule__PExpressionInClosure__ExpressionsAssignment_1_0"
    // InternalPerl.g:5281:1: rule__PExpressionInClosure__ExpressionsAssignment_1_0 : ( rulePExpressionOrVarDeclaration ) ;
    public final void rule__PExpressionInClosure__ExpressionsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5285:1: ( ( rulePExpressionOrVarDeclaration ) )
            // InternalPerl.g:5286:2: ( rulePExpressionOrVarDeclaration )
            {
            // InternalPerl.g:5286:2: ( rulePExpressionOrVarDeclaration )
            // InternalPerl.g:5287:3: rulePExpressionOrVarDeclaration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getExpressionsPExpressionOrVarDeclarationParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePExpressionOrVarDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPExpressionInClosureAccess().getExpressionsPExpressionOrVarDeclarationParserRuleCall_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PExpressionInClosure__ExpressionsAssignment_1_0"


    // $ANTLR start "rule__PIfExpression__IfAssignment_3"
    // InternalPerl.g:5296:1: rule__PIfExpression__IfAssignment_3 : ( rulePExpression ) ;
    public final void rule__PIfExpression__IfAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5300:1: ( ( rulePExpression ) )
            // InternalPerl.g:5301:2: ( rulePExpression )
            {
            // InternalPerl.g:5301:2: ( rulePExpression )
            // InternalPerl.g:5302:3: rulePExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getIfPExpressionParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getIfPExpressionParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__IfAssignment_3"


    // $ANTLR start "rule__PIfExpression__ThenAssignment_5"
    // InternalPerl.g:5311:1: rule__PIfExpression__ThenAssignment_5 : ( rulePExpression ) ;
    public final void rule__PIfExpression__ThenAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5315:1: ( ( rulePExpression ) )
            // InternalPerl.g:5316:2: ( rulePExpression )
            {
            // InternalPerl.g:5316:2: ( rulePExpression )
            // InternalPerl.g:5317:3: rulePExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getThenPExpressionParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getThenPExpressionParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__ThenAssignment_5"


    // $ANTLR start "rule__PIfExpression__ElseAssignment_6_1"
    // InternalPerl.g:5326:1: rule__PIfExpression__ElseAssignment_6_1 : ( rulePExpression ) ;
    public final void rule__PIfExpression__ElseAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5330:1: ( ( rulePExpression ) )
            // InternalPerl.g:5331:2: ( rulePExpression )
            {
            // InternalPerl.g:5331:2: ( rulePExpression )
            // InternalPerl.g:5332:3: rulePExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getElsePExpressionParserRuleCall_6_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPIfExpressionAccess().getElsePExpressionParserRuleCall_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PIfExpression__ElseAssignment_6_1"


    // $ANTLR start "rule__PBlockExpression__ExpressionsAssignment_2_0"
    // InternalPerl.g:5341:1: rule__PBlockExpression__ExpressionsAssignment_2_0 : ( rulePExpressionOrVarDeclaration ) ;
    public final void rule__PBlockExpression__ExpressionsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5345:1: ( ( rulePExpressionOrVarDeclaration ) )
            // InternalPerl.g:5346:2: ( rulePExpressionOrVarDeclaration )
            {
            // InternalPerl.g:5346:2: ( rulePExpressionOrVarDeclaration )
            // InternalPerl.g:5347:3: rulePExpressionOrVarDeclaration
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getExpressionsPExpressionOrVarDeclarationParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePExpressionOrVarDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPBlockExpressionAccess().getExpressionsPExpressionOrVarDeclarationParserRuleCall_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PBlockExpression__ExpressionsAssignment_2_0"


    // $ANTLR start "rule__PVariableDeclaration__NameAssignment_2_0"
    // InternalPerl.g:5356:1: rule__PVariableDeclaration__NameAssignment_2_0 : ( rulePVar ) ;
    public final void rule__PVariableDeclaration__NameAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5360:1: ( ( rulePVar ) )
            // InternalPerl.g:5361:2: ( rulePVar )
            {
            // InternalPerl.g:5361:2: ( rulePVar )
            // InternalPerl.g:5362:3: rulePVar
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getNamePVarParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePVar();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getNamePVarParserRuleCall_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__NameAssignment_2_0"


    // $ANTLR start "rule__PVariableDeclaration__RightAssignment_3_1"
    // InternalPerl.g:5371:1: rule__PVariableDeclaration__RightAssignment_3_1 : ( rulePExpression ) ;
    public final void rule__PVariableDeclaration__RightAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5375:1: ( ( rulePExpression ) )
            // InternalPerl.g:5376:2: ( rulePExpression )
            {
            // InternalPerl.g:5376:2: ( rulePExpression )
            // InternalPerl.g:5377:3: rulePExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getRightPExpressionParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getRightPExpressionParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PVariableDeclaration__RightAssignment_3_1"


    // $ANTLR start "rule__PNumberLiteral__ValueAssignment_1"
    // InternalPerl.g:5386:1: rule__PNumberLiteral__ValueAssignment_1 : ( ruleNumber ) ;
    public final void rule__PNumberLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5390:1: ( ( ruleNumber ) )
            // InternalPerl.g:5391:2: ( ruleNumber )
            {
            // InternalPerl.g:5391:2: ( ruleNumber )
            // InternalPerl.g:5392:3: ruleNumber
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleNumber();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PNumberLiteral__ValueAssignment_1"


    // $ANTLR start "rule__PReturnExpression__ExpressionAssignment_2"
    // InternalPerl.g:5401:1: rule__PReturnExpression__ExpressionAssignment_2 : ( rulePExpression ) ;
    public final void rule__PReturnExpression__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5405:1: ( ( rulePExpression ) )
            // InternalPerl.g:5406:2: ( rulePExpression )
            {
            // InternalPerl.g:5406:2: ( rulePExpression )
            // InternalPerl.g:5407:3: rulePExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPReturnExpressionAccess().getExpressionPExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPReturnExpressionAccess().getExpressionPExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PReturnExpression__ExpressionAssignment_2"


    // $ANTLR start "rule__PStringLiteral__ValueAssignment_1"
    // InternalPerl.g:5416:1: rule__PStringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__PStringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5420:1: ( ( RULE_STRING ) )
            // InternalPerl.g:5421:2: ( RULE_STRING )
            {
            // InternalPerl.g:5421:2: ( RULE_STRING )
            // InternalPerl.g:5422:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PStringLiteral__ValueAssignment_1"

    // $ANTLR start synpred44_InternalPerl
    public final void synpred44_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:3175:3: ( rule__PAdditiveExpression__Group_1__0 )
        // InternalPerl.g:3175:3: rule__PAdditiveExpression__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__PAdditiveExpression__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_InternalPerl

    // Delegated rules

    public final boolean synpred44_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA23 dfa23 = new DFA23(this);
    static final String dfa_1s = "\37\uffff";
    static final String dfa_2s = "\1\1\36\uffff";
    static final String dfa_3s = "\1\10\31\uffff\2\0\3\uffff";
    static final String dfa_4s = "\1\64\31\uffff\2\0\3\uffff";
    static final String dfa_5s = "\1\uffff\1\2\34\uffff\1\1";
    static final String dfa_6s = "\32\uffff\1\0\1\1\3\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\6\uffff\21\1\1\uffff\1\33\1\32\4\uffff\1\1\2\uffff\4\1\2\uffff\1\1\1\uffff\1\1\1\uffff\1\1",
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
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 3175:2: ( rule__PAdditiveExpression__Group_1__0 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_26 = input.LA(1);

                         
                        int index23_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_InternalPerl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index23_26);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_27 = input.LA(1);

                         
                        int index23_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_InternalPerl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index23_27);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000008600000100L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000307E0000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000007800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000007800002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000038000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000000F0000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000120000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000007800000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000007800000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00001C8600000100L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00001C8600000102L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00003C8600000100L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00001C0000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0080000000000002L});

}