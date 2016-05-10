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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'||'", "'&&'", "'+='", "'-='", "'*='", "'/='", "'%='", "'**='", "'=='", "'!='", "'eq'", "'ne'", "'>='", "'>'", "'<'", "'->'", "'..<'", "'..'", "'=>'", "'<>'", "'?:'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'++'", "'--'", "'my'", "'our'", "'local'", "'$'", "'@'", "'}'", "'sub'", "'{'", "';'", "'('", "')'", "'if'", "'else'", "'undef'", "'return'", "'::'"
    };
    public static final int RULE_HEX=4;
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int RULE_BIN=5;
    public static final int T__54=54;
    public static final int RULE_ID=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=9;
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
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
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
            match(input,12,FOLLOW_2); if (state.failed) return ;
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
            match(input,13,FOLLOW_2); if (state.failed) return ;
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
            match(input,14,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "entryRulePMemberFeatureCall"
    // InternalPerl.g:579:1: entryRulePMemberFeatureCall : rulePMemberFeatureCall EOF ;
    public final void entryRulePMemberFeatureCall() throws RecognitionException {
        try {
            // InternalPerl.g:580:1: ( rulePMemberFeatureCall EOF )
            // InternalPerl.g:581:1: rulePMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePMemberFeatureCall();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallRule()); 
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
    // $ANTLR end "entryRulePMemberFeatureCall"


    // $ANTLR start "rulePMemberFeatureCall"
    // InternalPerl.g:588:1: rulePMemberFeatureCall : ( ( rule__PMemberFeatureCall__Group__0 ) ) ;
    public final void rulePMemberFeatureCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:592:2: ( ( ( rule__PMemberFeatureCall__Group__0 ) ) )
            // InternalPerl.g:593:2: ( ( rule__PMemberFeatureCall__Group__0 ) )
            {
            // InternalPerl.g:593:2: ( ( rule__PMemberFeatureCall__Group__0 ) )
            // InternalPerl.g:594:3: ( rule__PMemberFeatureCall__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getGroup()); 
            }
            // InternalPerl.g:595:3: ( rule__PMemberFeatureCall__Group__0 )
            // InternalPerl.g:595:4: rule__PMemberFeatureCall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getGroup()); 
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
    // $ANTLR end "rulePMemberFeatureCall"


    // $ANTLR start "entryRulePPrimaryExpression"
    // InternalPerl.g:604:1: entryRulePPrimaryExpression : rulePPrimaryExpression EOF ;
    public final void entryRulePPrimaryExpression() throws RecognitionException {
        try {
            // InternalPerl.g:605:1: ( rulePPrimaryExpression EOF )
            // InternalPerl.g:606:1: rulePPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePPrimaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPPrimaryExpressionRule()); 
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
    // $ANTLR end "entryRulePPrimaryExpression"


    // $ANTLR start "rulePPrimaryExpression"
    // InternalPerl.g:613:1: rulePPrimaryExpression : ( ( rule__PPrimaryExpression__Alternatives ) ) ;
    public final void rulePPrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:617:2: ( ( ( rule__PPrimaryExpression__Alternatives ) ) )
            // InternalPerl.g:618:2: ( ( rule__PPrimaryExpression__Alternatives ) )
            {
            // InternalPerl.g:618:2: ( ( rule__PPrimaryExpression__Alternatives ) )
            // InternalPerl.g:619:3: ( rule__PPrimaryExpression__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPPrimaryExpressionAccess().getAlternatives()); 
            }
            // InternalPerl.g:620:3: ( rule__PPrimaryExpression__Alternatives )
            // InternalPerl.g:620:4: rule__PPrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PPrimaryExpression__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPPrimaryExpressionAccess().getAlternatives()); 
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
    // $ANTLR end "rulePPrimaryExpression"


    // $ANTLR start "entryRulePLiteral"
    // InternalPerl.g:629:1: entryRulePLiteral : rulePLiteral EOF ;
    public final void entryRulePLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:630:1: ( rulePLiteral EOF )
            // InternalPerl.g:631:1: rulePLiteral EOF
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
    // InternalPerl.g:638:1: rulePLiteral : ( ( rule__PLiteral__Alternatives ) ) ;
    public final void rulePLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:642:2: ( ( ( rule__PLiteral__Alternatives ) ) )
            // InternalPerl.g:643:2: ( ( rule__PLiteral__Alternatives ) )
            {
            // InternalPerl.g:643:2: ( ( rule__PLiteral__Alternatives ) )
            // InternalPerl.g:644:3: ( rule__PLiteral__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPLiteralAccess().getAlternatives()); 
            }
            // InternalPerl.g:645:3: ( rule__PLiteral__Alternatives )
            // InternalPerl.g:645:4: rule__PLiteral__Alternatives
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
    // InternalPerl.g:654:1: entryRulePClosure : rulePClosure EOF ;
    public final void entryRulePClosure() throws RecognitionException {
        try {
            // InternalPerl.g:655:1: ( rulePClosure EOF )
            // InternalPerl.g:656:1: rulePClosure EOF
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
    // InternalPerl.g:663:1: rulePClosure : ( ( rule__PClosure__Group__0 ) ) ;
    public final void rulePClosure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:667:2: ( ( ( rule__PClosure__Group__0 ) ) )
            // InternalPerl.g:668:2: ( ( rule__PClosure__Group__0 ) )
            {
            // InternalPerl.g:668:2: ( ( rule__PClosure__Group__0 ) )
            // InternalPerl.g:669:3: ( rule__PClosure__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getGroup()); 
            }
            // InternalPerl.g:670:3: ( rule__PClosure__Group__0 )
            // InternalPerl.g:670:4: rule__PClosure__Group__0
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
    // InternalPerl.g:679:1: entryRulePExpressionInClosure : rulePExpressionInClosure EOF ;
    public final void entryRulePExpressionInClosure() throws RecognitionException {
        try {
            // InternalPerl.g:680:1: ( rulePExpressionInClosure EOF )
            // InternalPerl.g:681:1: rulePExpressionInClosure EOF
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
    // InternalPerl.g:688:1: rulePExpressionInClosure : ( ( rule__PExpressionInClosure__Group__0 ) ) ;
    public final void rulePExpressionInClosure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:692:2: ( ( ( rule__PExpressionInClosure__Group__0 ) ) )
            // InternalPerl.g:693:2: ( ( rule__PExpressionInClosure__Group__0 ) )
            {
            // InternalPerl.g:693:2: ( ( rule__PExpressionInClosure__Group__0 ) )
            // InternalPerl.g:694:3: ( rule__PExpressionInClosure__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getGroup()); 
            }
            // InternalPerl.g:695:3: ( rule__PExpressionInClosure__Group__0 )
            // InternalPerl.g:695:4: rule__PExpressionInClosure__Group__0
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
    // InternalPerl.g:704:1: entryRulePParenthesizedExpression : rulePParenthesizedExpression EOF ;
    public final void entryRulePParenthesizedExpression() throws RecognitionException {
        try {
            // InternalPerl.g:705:1: ( rulePParenthesizedExpression EOF )
            // InternalPerl.g:706:1: rulePParenthesizedExpression EOF
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
    // InternalPerl.g:713:1: rulePParenthesizedExpression : ( ( rule__PParenthesizedExpression__Group__0 ) ) ;
    public final void rulePParenthesizedExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:717:2: ( ( ( rule__PParenthesizedExpression__Group__0 ) ) )
            // InternalPerl.g:718:2: ( ( rule__PParenthesizedExpression__Group__0 ) )
            {
            // InternalPerl.g:718:2: ( ( rule__PParenthesizedExpression__Group__0 ) )
            // InternalPerl.g:719:3: ( rule__PParenthesizedExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPParenthesizedExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:720:3: ( rule__PParenthesizedExpression__Group__0 )
            // InternalPerl.g:720:4: rule__PParenthesizedExpression__Group__0
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
    // InternalPerl.g:729:1: entryRulePIfExpression : rulePIfExpression EOF ;
    public final void entryRulePIfExpression() throws RecognitionException {
        try {
            // InternalPerl.g:730:1: ( rulePIfExpression EOF )
            // InternalPerl.g:731:1: rulePIfExpression EOF
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
    // InternalPerl.g:738:1: rulePIfExpression : ( ( rule__PIfExpression__Group__0 ) ) ;
    public final void rulePIfExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:742:2: ( ( ( rule__PIfExpression__Group__0 ) ) )
            // InternalPerl.g:743:2: ( ( rule__PIfExpression__Group__0 ) )
            {
            // InternalPerl.g:743:2: ( ( rule__PIfExpression__Group__0 ) )
            // InternalPerl.g:744:3: ( rule__PIfExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:745:3: ( rule__PIfExpression__Group__0 )
            // InternalPerl.g:745:4: rule__PIfExpression__Group__0
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
    // InternalPerl.g:754:1: entryRulePBlockExpression : rulePBlockExpression EOF ;
    public final void entryRulePBlockExpression() throws RecognitionException {
        try {
            // InternalPerl.g:755:1: ( rulePBlockExpression EOF )
            // InternalPerl.g:756:1: rulePBlockExpression EOF
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
    // InternalPerl.g:763:1: rulePBlockExpression : ( ( rule__PBlockExpression__Group__0 ) ) ;
    public final void rulePBlockExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:767:2: ( ( ( rule__PBlockExpression__Group__0 ) ) )
            // InternalPerl.g:768:2: ( ( rule__PBlockExpression__Group__0 ) )
            {
            // InternalPerl.g:768:2: ( ( rule__PBlockExpression__Group__0 ) )
            // InternalPerl.g:769:3: ( rule__PBlockExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:770:3: ( rule__PBlockExpression__Group__0 )
            // InternalPerl.g:770:4: rule__PBlockExpression__Group__0
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
    // InternalPerl.g:779:1: entryRulePExpressionOrVarDeclaration : rulePExpressionOrVarDeclaration EOF ;
    public final void entryRulePExpressionOrVarDeclaration() throws RecognitionException {
        try {
            // InternalPerl.g:780:1: ( rulePExpressionOrVarDeclaration EOF )
            // InternalPerl.g:781:1: rulePExpressionOrVarDeclaration EOF
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
    // InternalPerl.g:788:1: rulePExpressionOrVarDeclaration : ( ( rule__PExpressionOrVarDeclaration__Alternatives ) ) ;
    public final void rulePExpressionOrVarDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:792:2: ( ( ( rule__PExpressionOrVarDeclaration__Alternatives ) ) )
            // InternalPerl.g:793:2: ( ( rule__PExpressionOrVarDeclaration__Alternatives ) )
            {
            // InternalPerl.g:793:2: ( ( rule__PExpressionOrVarDeclaration__Alternatives ) )
            // InternalPerl.g:794:3: ( rule__PExpressionOrVarDeclaration__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionOrVarDeclarationAccess().getAlternatives()); 
            }
            // InternalPerl.g:795:3: ( rule__PExpressionOrVarDeclaration__Alternatives )
            // InternalPerl.g:795:4: rule__PExpressionOrVarDeclaration__Alternatives
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
    // InternalPerl.g:804:1: entryRulePVariableDeclaration : rulePVariableDeclaration EOF ;
    public final void entryRulePVariableDeclaration() throws RecognitionException {
        try {
            // InternalPerl.g:805:1: ( rulePVariableDeclaration EOF )
            // InternalPerl.g:806:1: rulePVariableDeclaration EOF
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
    // InternalPerl.g:813:1: rulePVariableDeclaration : ( ( rule__PVariableDeclaration__Group__0 ) ) ;
    public final void rulePVariableDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:817:2: ( ( ( rule__PVariableDeclaration__Group__0 ) ) )
            // InternalPerl.g:818:2: ( ( rule__PVariableDeclaration__Group__0 ) )
            {
            // InternalPerl.g:818:2: ( ( rule__PVariableDeclaration__Group__0 ) )
            // InternalPerl.g:819:3: ( rule__PVariableDeclaration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getGroup()); 
            }
            // InternalPerl.g:820:3: ( rule__PVariableDeclaration__Group__0 )
            // InternalPerl.g:820:4: rule__PVariableDeclaration__Group__0
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


    // $ANTLR start "entryRuleFeatureCallID"
    // InternalPerl.g:829:1: entryRuleFeatureCallID : ruleFeatureCallID EOF ;
    public final void entryRuleFeatureCallID() throws RecognitionException {
        try {
            // InternalPerl.g:830:1: ( ruleFeatureCallID EOF )
            // InternalPerl.g:831:1: ruleFeatureCallID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallIDRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallIDRule()); 
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
    // $ANTLR end "entryRuleFeatureCallID"


    // $ANTLR start "ruleFeatureCallID"
    // InternalPerl.g:838:1: ruleFeatureCallID : ( ( rule__FeatureCallID__Group__0 ) ) ;
    public final void ruleFeatureCallID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:842:2: ( ( ( rule__FeatureCallID__Group__0 ) ) )
            // InternalPerl.g:843:2: ( ( rule__FeatureCallID__Group__0 ) )
            {
            // InternalPerl.g:843:2: ( ( rule__FeatureCallID__Group__0 ) )
            // InternalPerl.g:844:3: ( rule__FeatureCallID__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallIDAccess().getGroup()); 
            }
            // InternalPerl.g:845:3: ( rule__FeatureCallID__Group__0 )
            // InternalPerl.g:845:4: rule__FeatureCallID__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FeatureCallID__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallIDAccess().getGroup()); 
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
    // $ANTLR end "ruleFeatureCallID"


    // $ANTLR start "entryRulePNumberLiteral"
    // InternalPerl.g:854:1: entryRulePNumberLiteral : rulePNumberLiteral EOF ;
    public final void entryRulePNumberLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:855:1: ( rulePNumberLiteral EOF )
            // InternalPerl.g:856:1: rulePNumberLiteral EOF
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
    // InternalPerl.g:863:1: rulePNumberLiteral : ( ( rule__PNumberLiteral__Group__0 ) ) ;
    public final void rulePNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:867:2: ( ( ( rule__PNumberLiteral__Group__0 ) ) )
            // InternalPerl.g:868:2: ( ( rule__PNumberLiteral__Group__0 ) )
            {
            // InternalPerl.g:868:2: ( ( rule__PNumberLiteral__Group__0 ) )
            // InternalPerl.g:869:3: ( rule__PNumberLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNumberLiteralAccess().getGroup()); 
            }
            // InternalPerl.g:870:3: ( rule__PNumberLiteral__Group__0 )
            // InternalPerl.g:870:4: rule__PNumberLiteral__Group__0
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
    // InternalPerl.g:879:1: entryRulePNullLiteral : rulePNullLiteral EOF ;
    public final void entryRulePNullLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:880:1: ( rulePNullLiteral EOF )
            // InternalPerl.g:881:1: rulePNullLiteral EOF
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
    // InternalPerl.g:888:1: rulePNullLiteral : ( ( rule__PNullLiteral__Group__0 ) ) ;
    public final void rulePNullLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:892:2: ( ( ( rule__PNullLiteral__Group__0 ) ) )
            // InternalPerl.g:893:2: ( ( rule__PNullLiteral__Group__0 ) )
            {
            // InternalPerl.g:893:2: ( ( rule__PNullLiteral__Group__0 ) )
            // InternalPerl.g:894:3: ( rule__PNullLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNullLiteralAccess().getGroup()); 
            }
            // InternalPerl.g:895:3: ( rule__PNullLiteral__Group__0 )
            // InternalPerl.g:895:4: rule__PNullLiteral__Group__0
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
    // InternalPerl.g:904:1: entryRulePReturnExpression : rulePReturnExpression EOF ;
    public final void entryRulePReturnExpression() throws RecognitionException {
        try {
            // InternalPerl.g:905:1: ( rulePReturnExpression EOF )
            // InternalPerl.g:906:1: rulePReturnExpression EOF
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
    // InternalPerl.g:913:1: rulePReturnExpression : ( ( rule__PReturnExpression__Group__0 ) ) ;
    public final void rulePReturnExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:917:2: ( ( ( rule__PReturnExpression__Group__0 ) ) )
            // InternalPerl.g:918:2: ( ( rule__PReturnExpression__Group__0 ) )
            {
            // InternalPerl.g:918:2: ( ( rule__PReturnExpression__Group__0 ) )
            // InternalPerl.g:919:3: ( rule__PReturnExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPReturnExpressionAccess().getGroup()); 
            }
            // InternalPerl.g:920:3: ( rule__PReturnExpression__Group__0 )
            // InternalPerl.g:920:4: rule__PReturnExpression__Group__0
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
    // InternalPerl.g:929:1: entryRulePStringLiteral : rulePStringLiteral EOF ;
    public final void entryRulePStringLiteral() throws RecognitionException {
        try {
            // InternalPerl.g:930:1: ( rulePStringLiteral EOF )
            // InternalPerl.g:931:1: rulePStringLiteral EOF
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
    // InternalPerl.g:938:1: rulePStringLiteral : ( ( rule__PStringLiteral__Group__0 ) ) ;
    public final void rulePStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:942:2: ( ( ( rule__PStringLiteral__Group__0 ) ) )
            // InternalPerl.g:943:2: ( ( rule__PStringLiteral__Group__0 ) )
            {
            // InternalPerl.g:943:2: ( ( rule__PStringLiteral__Group__0 ) )
            // InternalPerl.g:944:3: ( rule__PStringLiteral__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPStringLiteralAccess().getGroup()); 
            }
            // InternalPerl.g:945:3: ( rule__PStringLiteral__Group__0 )
            // InternalPerl.g:945:4: rule__PStringLiteral__Group__0
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
    // InternalPerl.g:954:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalPerl.g:955:1: ( ruleQualifiedName EOF )
            // InternalPerl.g:956:1: ruleQualifiedName EOF
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
    // InternalPerl.g:963:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:967:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalPerl.g:968:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalPerl.g:968:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalPerl.g:969:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalPerl.g:970:3: ( rule__QualifiedName__Group__0 )
            // InternalPerl.g:970:4: rule__QualifiedName__Group__0
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
    // InternalPerl.g:979:1: entryRuleNumber : ruleNumber EOF ;
    public final void entryRuleNumber() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:983:1: ( ruleNumber EOF )
            // InternalPerl.g:984:1: ruleNumber EOF
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
    // InternalPerl.g:994:1: ruleNumber : ( ( rule__Number__Alternatives ) ) ;
    public final void ruleNumber() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:999:2: ( ( ( rule__Number__Alternatives ) ) )
            // InternalPerl.g:1000:2: ( ( rule__Number__Alternatives ) )
            {
            // InternalPerl.g:1000:2: ( ( rule__Number__Alternatives ) )
            // InternalPerl.g:1001:3: ( rule__Number__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberAccess().getAlternatives()); 
            }
            // InternalPerl.g:1002:3: ( rule__Number__Alternatives )
            // InternalPerl.g:1002:4: rule__Number__Alternatives
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
    // InternalPerl.g:1011:1: rule__PAssignment__Alternatives : ( ( ( rule__PAssignment__Group_0__0 ) ) | ( ( rule__PAssignment__Group_1__0 ) ) );
    public final void rule__PAssignment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1015:1: ( ( ( rule__PAssignment__Group_0__0 ) ) | ( ( rule__PAssignment__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==39||(LA1_0>=46 && LA1_0<=47)) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=34 && LA1_0<=35)||LA1_0==40) ) {
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
                    // InternalPerl.g:1016:2: ( ( rule__PAssignment__Group_0__0 ) )
                    {
                    // InternalPerl.g:1016:2: ( ( rule__PAssignment__Group_0__0 ) )
                    // InternalPerl.g:1017:3: ( rule__PAssignment__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPAssignmentAccess().getGroup_0()); 
                    }
                    // InternalPerl.g:1018:3: ( rule__PAssignment__Group_0__0 )
                    // InternalPerl.g:1018:4: rule__PAssignment__Group_0__0
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
                    // InternalPerl.g:1022:2: ( ( rule__PAssignment__Group_1__0 ) )
                    {
                    // InternalPerl.g:1022:2: ( ( rule__PAssignment__Group_1__0 ) )
                    // InternalPerl.g:1023:3: ( rule__PAssignment__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPAssignmentAccess().getGroup_1()); 
                    }
                    // InternalPerl.g:1024:3: ( rule__PAssignment__Group_1__0 )
                    // InternalPerl.g:1024:4: rule__PAssignment__Group_1__0
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
    // InternalPerl.g:1032:1: rule__OpMultiAssign__Alternatives : ( ( '+=' ) | ( '-=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '**=' ) | ( ( rule__OpMultiAssign__Group_6__0 ) ) | ( ( rule__OpMultiAssign__Group_7__0 ) ) );
    public final void rule__OpMultiAssign__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1036:1: ( ( '+=' ) | ( '-=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '**=' ) | ( ( rule__OpMultiAssign__Group_6__0 ) ) | ( ( rule__OpMultiAssign__Group_7__0 ) ) )
            int alt2=8;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt2=1;
                }
                break;
            case 16:
                {
                alt2=2;
                }
                break;
            case 17:
                {
                alt2=3;
                }
                break;
            case 18:
                {
                alt2=4;
                }
                break;
            case 19:
                {
                alt2=5;
                }
                break;
            case 20:
                {
                alt2=6;
                }
                break;
            case 27:
                {
                alt2=7;
                }
                break;
            case 26:
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
                    // InternalPerl.g:1037:2: ( '+=' )
                    {
                    // InternalPerl.g:1037:2: ( '+=' )
                    // InternalPerl.g:1038:3: '+='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1043:2: ( '-=' )
                    {
                    // InternalPerl.g:1043:2: ( '-=' )
                    // InternalPerl.g:1044:3: '-='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1()); 
                    }
                    match(input,16,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1049:2: ( '*=' )
                    {
                    // InternalPerl.g:1049:2: ( '*=' )
                    // InternalPerl.g:1050:3: '*='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2()); 
                    }
                    match(input,17,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1055:2: ( '/=' )
                    {
                    // InternalPerl.g:1055:2: ( '/=' )
                    // InternalPerl.g:1056:3: '/='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:1061:2: ( '%=' )
                    {
                    // InternalPerl.g:1061:2: ( '%=' )
                    // InternalPerl.g:1062:3: '%='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:1067:2: ( '**=' )
                    {
                    // InternalPerl.g:1067:2: ( '**=' )
                    // InternalPerl.g:1068:3: '**='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getAsteriskAsteriskEqualsSignKeyword_5()); 
                    }
                    match(input,20,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAssignAccess().getAsteriskAsteriskEqualsSignKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:1073:2: ( ( rule__OpMultiAssign__Group_6__0 ) )
                    {
                    // InternalPerl.g:1073:2: ( ( rule__OpMultiAssign__Group_6__0 ) )
                    // InternalPerl.g:1074:3: ( rule__OpMultiAssign__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getGroup_6()); 
                    }
                    // InternalPerl.g:1075:3: ( rule__OpMultiAssign__Group_6__0 )
                    // InternalPerl.g:1075:4: rule__OpMultiAssign__Group_6__0
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
                    // InternalPerl.g:1079:2: ( ( rule__OpMultiAssign__Group_7__0 ) )
                    {
                    // InternalPerl.g:1079:2: ( ( rule__OpMultiAssign__Group_7__0 ) )
                    // InternalPerl.g:1080:3: ( rule__OpMultiAssign__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAssignAccess().getGroup_7()); 
                    }
                    // InternalPerl.g:1081:3: ( rule__OpMultiAssign__Group_7__0 )
                    // InternalPerl.g:1081:4: rule__OpMultiAssign__Group_7__0
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
    // InternalPerl.g:1089:1: rule__OpEquality__Alternatives : ( ( '==' ) | ( '!=' ) | ( 'eq' ) | ( 'ne' ) );
    public final void rule__OpEquality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1093:1: ( ( '==' ) | ( '!=' ) | ( 'eq' ) | ( 'ne' ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt3=1;
                }
                break;
            case 22:
                {
                alt3=2;
                }
                break;
            case 23:
                {
                alt3=3;
                }
                break;
            case 24:
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
                    // InternalPerl.g:1094:2: ( '==' )
                    {
                    // InternalPerl.g:1094:2: ( '==' )
                    // InternalPerl.g:1095:3: '=='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                    }
                    match(input,21,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1100:2: ( '!=' )
                    {
                    // InternalPerl.g:1100:2: ( '!=' )
                    // InternalPerl.g:1101:3: '!='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                    }
                    match(input,22,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1106:2: ( 'eq' )
                    {
                    // InternalPerl.g:1106:2: ( 'eq' )
                    // InternalPerl.g:1107:3: 'eq'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpEqualityAccess().getEqKeyword_2()); 
                    }
                    match(input,23,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpEqualityAccess().getEqKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1112:2: ( 'ne' )
                    {
                    // InternalPerl.g:1112:2: ( 'ne' )
                    // InternalPerl.g:1113:3: 'ne'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpEqualityAccess().getNeKeyword_3()); 
                    }
                    match(input,24,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:1122:1: rule__OpCompare__Alternatives : ( ( '>=' ) | ( ( rule__OpCompare__Group_1__0 ) ) | ( '>' ) | ( '<' ) );
    public final void rule__OpCompare__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1126:1: ( ( '>=' ) | ( ( rule__OpCompare__Group_1__0 ) ) | ( '>' ) | ( '<' ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt4=1;
                }
                break;
            case 27:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==12) ) {
                    alt4=2;
                }
                else if ( (LA4_2==EOF||(LA4_2>=34 && LA4_2<=35)||LA4_2==40) ) {
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
            case 26:
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
                    // InternalPerl.g:1127:2: ( '>=' )
                    {
                    // InternalPerl.g:1127:2: ( '>=' )
                    // InternalPerl.g:1128:3: '>='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                    }
                    match(input,25,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1133:2: ( ( rule__OpCompare__Group_1__0 ) )
                    {
                    // InternalPerl.g:1133:2: ( ( rule__OpCompare__Group_1__0 ) )
                    // InternalPerl.g:1134:3: ( rule__OpCompare__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getGroup_1()); 
                    }
                    // InternalPerl.g:1135:3: ( rule__OpCompare__Group_1__0 )
                    // InternalPerl.g:1135:4: rule__OpCompare__Group_1__0
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
                    // InternalPerl.g:1139:2: ( '>' )
                    {
                    // InternalPerl.g:1139:2: ( '>' )
                    // InternalPerl.g:1140:3: '>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                    }
                    match(input,26,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1145:2: ( '<' )
                    {
                    // InternalPerl.g:1145:2: ( '<' )
                    // InternalPerl.g:1146:3: '<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                    }
                    match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:1155:1: rule__OpOther__Alternatives : ( ( '->' ) | ( '..<' ) | ( ( rule__OpOther__Group_2__0 ) ) | ( '..' ) | ( '=>' ) | ( ( rule__OpOther__Group_5__0 ) ) | ( ( rule__OpOther__Group_6__0 ) ) | ( '<>' ) | ( '?:' ) );
    public final void rule__OpOther__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1159:1: ( ( '->' ) | ( '..<' ) | ( ( rule__OpOther__Group_2__0 ) ) | ( '..' ) | ( '=>' ) | ( ( rule__OpOther__Group_5__0 ) ) | ( ( rule__OpOther__Group_6__0 ) ) | ( '<>' ) | ( '?:' ) )
            int alt5=9;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalPerl.g:1160:2: ( '->' )
                    {
                    // InternalPerl.g:1160:2: ( '->' )
                    // InternalPerl.g:1161:3: '->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                    }
                    match(input,28,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1166:2: ( '..<' )
                    {
                    // InternalPerl.g:1166:2: ( '..<' )
                    // InternalPerl.g:1167:3: '..<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1()); 
                    }
                    match(input,29,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1172:2: ( ( rule__OpOther__Group_2__0 ) )
                    {
                    // InternalPerl.g:1172:2: ( ( rule__OpOther__Group_2__0 ) )
                    // InternalPerl.g:1173:3: ( rule__OpOther__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGroup_2()); 
                    }
                    // InternalPerl.g:1174:3: ( rule__OpOther__Group_2__0 )
                    // InternalPerl.g:1174:4: rule__OpOther__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpOther__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1178:2: ( '..' )
                    {
                    // InternalPerl.g:1178:2: ( '..' )
                    // InternalPerl.g:1179:3: '..'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3()); 
                    }
                    match(input,30,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:1184:2: ( '=>' )
                    {
                    // InternalPerl.g:1184:2: ( '=>' )
                    // InternalPerl.g:1185:3: '=>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4()); 
                    }
                    match(input,31,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalPerl.g:1190:2: ( ( rule__OpOther__Group_5__0 ) )
                    {
                    // InternalPerl.g:1190:2: ( ( rule__OpOther__Group_5__0 ) )
                    // InternalPerl.g:1191:3: ( rule__OpOther__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGroup_5()); 
                    }
                    // InternalPerl.g:1192:3: ( rule__OpOther__Group_5__0 )
                    // InternalPerl.g:1192:4: rule__OpOther__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpOther__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGroup_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:1196:2: ( ( rule__OpOther__Group_6__0 ) )
                    {
                    // InternalPerl.g:1196:2: ( ( rule__OpOther__Group_6__0 ) )
                    // InternalPerl.g:1197:3: ( rule__OpOther__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGroup_6()); 
                    }
                    // InternalPerl.g:1198:3: ( rule__OpOther__Group_6__0 )
                    // InternalPerl.g:1198:4: rule__OpOther__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpOther__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:1202:2: ( '<>' )
                    {
                    // InternalPerl.g:1202:2: ( '<>' )
                    // InternalPerl.g:1203:3: '<>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7()); 
                    }
                    match(input,32,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalPerl.g:1208:2: ( '?:' )
                    {
                    // InternalPerl.g:1208:2: ( '?:' )
                    // InternalPerl.g:1209:3: '?:'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8()); 
                    }
                    match(input,33,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8()); 
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


    // $ANTLR start "rule__OpOther__Alternatives_5_1"
    // InternalPerl.g:1218:1: rule__OpOther__Alternatives_5_1 : ( ( ( rule__OpOther__Group_5_1_0__0 ) ) | ( '>' ) );
    public final void rule__OpOther__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1222:1: ( ( ( rule__OpOther__Group_5_1_0__0 ) ) | ( '>' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==EOF||(LA6_1>=34 && LA6_1<=35)||LA6_1==40) ) {
                    alt6=2;
                }
                else if ( (LA6_1==26) ) {
                    alt6=1;
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
                    // InternalPerl.g:1223:2: ( ( rule__OpOther__Group_5_1_0__0 ) )
                    {
                    // InternalPerl.g:1223:2: ( ( rule__OpOther__Group_5_1_0__0 ) )
                    // InternalPerl.g:1224:3: ( rule__OpOther__Group_5_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGroup_5_1_0()); 
                    }
                    // InternalPerl.g:1225:3: ( rule__OpOther__Group_5_1_0__0 )
                    // InternalPerl.g:1225:4: rule__OpOther__Group_5_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpOther__Group_5_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGroup_5_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1229:2: ( '>' )
                    {
                    // InternalPerl.g:1229:2: ( '>' )
                    // InternalPerl.g:1230:3: '>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1()); 
                    }
                    match(input,26,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1()); 
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
    // $ANTLR end "rule__OpOther__Alternatives_5_1"


    // $ANTLR start "rule__OpOther__Alternatives_6_1"
    // InternalPerl.g:1239:1: rule__OpOther__Alternatives_6_1 : ( ( ( rule__OpOther__Group_6_1_0__0 ) ) | ( '<' ) | ( '=>' ) );
    public final void rule__OpOther__Alternatives_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1243:1: ( ( ( rule__OpOther__Group_6_1_0__0 ) ) | ( '<' ) | ( '=>' ) )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==27) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==27) ) {
                    alt7=1;
                }
                else if ( (LA7_1==EOF||(LA7_1>=34 && LA7_1<=35)||LA7_1==40) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA7_0==31) ) {
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
                    // InternalPerl.g:1244:2: ( ( rule__OpOther__Group_6_1_0__0 ) )
                    {
                    // InternalPerl.g:1244:2: ( ( rule__OpOther__Group_6_1_0__0 ) )
                    // InternalPerl.g:1245:3: ( rule__OpOther__Group_6_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getGroup_6_1_0()); 
                    }
                    // InternalPerl.g:1246:3: ( rule__OpOther__Group_6_1_0__0 )
                    // InternalPerl.g:1246:4: rule__OpOther__Group_6_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OpOther__Group_6_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getGroup_6_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1250:2: ( '<' )
                    {
                    // InternalPerl.g:1250:2: ( '<' )
                    // InternalPerl.g:1251:3: '<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1()); 
                    }
                    match(input,27,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1256:2: ( '=>' )
                    {
                    // InternalPerl.g:1256:2: ( '=>' )
                    // InternalPerl.g:1257:3: '=>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2()); 
                    }
                    match(input,31,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2()); 
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
    // $ANTLR end "rule__OpOther__Alternatives_6_1"


    // $ANTLR start "rule__OpAdd__Alternatives"
    // InternalPerl.g:1266:1: rule__OpAdd__Alternatives : ( ( '+' ) | ( '-' ) );
    public final void rule__OpAdd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1270:1: ( ( '+' ) | ( '-' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==34) ) {
                alt8=1;
            }
            else if ( (LA8_0==35) ) {
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
                    // InternalPerl.g:1271:2: ( '+' )
                    {
                    // InternalPerl.g:1271:2: ( '+' )
                    // InternalPerl.g:1272:3: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                    }
                    match(input,34,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1277:2: ( '-' )
                    {
                    // InternalPerl.g:1277:2: ( '-' )
                    // InternalPerl.g:1278:3: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                    }
                    match(input,35,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:1287:1: rule__OpMulti__Alternatives : ( ( '*' ) | ( '**' ) | ( '/' ) | ( '%' ) );
    public final void rule__OpMulti__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1291:1: ( ( '*' ) | ( '**' ) | ( '/' ) | ( '%' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt9=1;
                }
                break;
            case 37:
                {
                alt9=2;
                }
                break;
            case 38:
                {
                alt9=3;
                }
                break;
            case 39:
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
                    // InternalPerl.g:1292:2: ( '*' )
                    {
                    // InternalPerl.g:1292:2: ( '*' )
                    // InternalPerl.g:1293:3: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                    }
                    match(input,36,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1298:2: ( '**' )
                    {
                    // InternalPerl.g:1298:2: ( '**' )
                    // InternalPerl.g:1299:3: '**'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                    }
                    match(input,37,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1304:2: ( '/' )
                    {
                    // InternalPerl.g:1304:2: ( '/' )
                    // InternalPerl.g:1305:3: '/'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                    }
                    match(input,38,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1310:2: ( '%' )
                    {
                    // InternalPerl.g:1310:2: ( '%' )
                    // InternalPerl.g:1311:3: '%'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
                    }
                    match(input,39,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:1320:1: rule__OpUnary__Alternatives : ( ( '!' ) | ( '-' ) | ( '+' ) );
    public final void rule__OpUnary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1324:1: ( ( '!' ) | ( '-' ) | ( '+' ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt10=1;
                }
                break;
            case 35:
                {
                alt10=2;
                }
                break;
            case 34:
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
                    // InternalPerl.g:1325:2: ( '!' )
                    {
                    // InternalPerl.g:1325:2: ( '!' )
                    // InternalPerl.g:1326:3: '!'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                    }
                    match(input,40,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1331:2: ( '-' )
                    {
                    // InternalPerl.g:1331:2: ( '-' )
                    // InternalPerl.g:1332:3: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                    }
                    match(input,35,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1337:2: ( '+' )
                    {
                    // InternalPerl.g:1337:2: ( '+' )
                    // InternalPerl.g:1338:3: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                    }
                    match(input,34,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:1347:1: rule__OpPostfix__Alternatives : ( ( '++' ) | ( '--' ) );
    public final void rule__OpPostfix__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1351:1: ( ( '++' ) | ( '--' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==41) ) {
                alt11=1;
            }
            else if ( (LA11_0==42) ) {
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
                    // InternalPerl.g:1352:2: ( '++' )
                    {
                    // InternalPerl.g:1352:2: ( '++' )
                    // InternalPerl.g:1353:3: '++'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0()); 
                    }
                    match(input,41,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1358:2: ( '--' )
                    {
                    // InternalPerl.g:1358:2: ( '--' )
                    // InternalPerl.g:1359:3: '--'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1()); 
                    }
                    match(input,42,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__PPrimaryExpression__Alternatives"
    // InternalPerl.g:1368:1: rule__PPrimaryExpression__Alternatives : ( ( rulePBlockExpression ) | ( rulePLiteral ) | ( rulePIfExpression ) | ( rulePReturnExpression ) | ( rulePParenthesizedExpression ) );
    public final void rule__PPrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1372:1: ( ( rulePBlockExpression ) | ( rulePLiteral ) | ( rulePIfExpression ) | ( rulePReturnExpression ) | ( rulePParenthesizedExpression ) )
            int alt12=5;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt12=1;
                }
                break;
            case RULE_HEX:
            case RULE_BIN:
            case RULE_INT:
            case RULE_STRING:
            case 49:
            case 56:
                {
                alt12=2;
                }
                break;
            case 54:
                {
                alt12=3;
                }
                break;
            case 57:
                {
                alt12=4;
                }
                break;
            case 52:
                {
                alt12=5;
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
                    // InternalPerl.g:1373:2: ( rulePBlockExpression )
                    {
                    // InternalPerl.g:1373:2: ( rulePBlockExpression )
                    // InternalPerl.g:1374:3: rulePBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPPrimaryExpressionAccess().getPBlockExpressionParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePBlockExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPPrimaryExpressionAccess().getPBlockExpressionParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1379:2: ( rulePLiteral )
                    {
                    // InternalPerl.g:1379:2: ( rulePLiteral )
                    // InternalPerl.g:1380:3: rulePLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPPrimaryExpressionAccess().getPLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPPrimaryExpressionAccess().getPLiteralParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1385:2: ( rulePIfExpression )
                    {
                    // InternalPerl.g:1385:2: ( rulePIfExpression )
                    // InternalPerl.g:1386:3: rulePIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPPrimaryExpressionAccess().getPIfExpressionParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePIfExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPPrimaryExpressionAccess().getPIfExpressionParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:1391:2: ( rulePReturnExpression )
                    {
                    // InternalPerl.g:1391:2: ( rulePReturnExpression )
                    // InternalPerl.g:1392:3: rulePReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPPrimaryExpressionAccess().getPReturnExpressionParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePReturnExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPPrimaryExpressionAccess().getPReturnExpressionParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalPerl.g:1397:2: ( rulePParenthesizedExpression )
                    {
                    // InternalPerl.g:1397:2: ( rulePParenthesizedExpression )
                    // InternalPerl.g:1398:3: rulePParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPPrimaryExpressionAccess().getPParenthesizedExpressionParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulePParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPPrimaryExpressionAccess().getPParenthesizedExpressionParserRuleCall_4()); 
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
    // $ANTLR end "rule__PPrimaryExpression__Alternatives"


    // $ANTLR start "rule__PLiteral__Alternatives"
    // InternalPerl.g:1407:1: rule__PLiteral__Alternatives : ( ( ( rulePClosure ) ) | ( rulePNumberLiteral ) | ( rulePNullLiteral ) | ( rulePStringLiteral ) );
    public final void rule__PLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1411:1: ( ( ( rulePClosure ) ) | ( rulePNumberLiteral ) | ( rulePNullLiteral ) | ( rulePStringLiteral ) )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt13=1;
                }
                break;
            case RULE_HEX:
            case RULE_BIN:
            case RULE_INT:
                {
                alt13=2;
                }
                break;
            case 56:
                {
                alt13=3;
                }
                break;
            case RULE_STRING:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalPerl.g:1412:2: ( ( rulePClosure ) )
                    {
                    // InternalPerl.g:1412:2: ( ( rulePClosure ) )
                    // InternalPerl.g:1413:3: ( rulePClosure )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPLiteralAccess().getPClosureParserRuleCall_0()); 
                    }
                    // InternalPerl.g:1414:3: ( rulePClosure )
                    // InternalPerl.g:1414:4: rulePClosure
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
                    // InternalPerl.g:1418:2: ( rulePNumberLiteral )
                    {
                    // InternalPerl.g:1418:2: ( rulePNumberLiteral )
                    // InternalPerl.g:1419:3: rulePNumberLiteral
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
                    // InternalPerl.g:1424:2: ( rulePNullLiteral )
                    {
                    // InternalPerl.g:1424:2: ( rulePNullLiteral )
                    // InternalPerl.g:1425:3: rulePNullLiteral
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
                    // InternalPerl.g:1430:2: ( rulePStringLiteral )
                    {
                    // InternalPerl.g:1430:2: ( rulePStringLiteral )
                    // InternalPerl.g:1431:3: rulePStringLiteral
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
    // InternalPerl.g:1440:1: rule__PExpressionOrVarDeclaration__Alternatives : ( ( rulePVariableDeclaration ) | ( rulePExpression ) );
    public final void rule__PExpressionOrVarDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1444:1: ( ( rulePVariableDeclaration ) | ( rulePExpression ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=43 && LA14_0<=45)) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=34 && LA14_0<=35)||(LA14_0>=39 && LA14_0<=40)||(LA14_0>=46 && LA14_0<=47)) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalPerl.g:1445:2: ( rulePVariableDeclaration )
                    {
                    // InternalPerl.g:1445:2: ( rulePVariableDeclaration )
                    // InternalPerl.g:1446:3: rulePVariableDeclaration
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
                    // InternalPerl.g:1451:2: ( rulePExpression )
                    {
                    // InternalPerl.g:1451:2: ( rulePExpression )
                    // InternalPerl.g:1452:3: rulePExpression
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
    // InternalPerl.g:1461:1: rule__PVariableDeclaration__Alternatives_1 : ( ( 'my' ) | ( 'our' ) | ( 'local' ) );
    public final void rule__PVariableDeclaration__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1465:1: ( ( 'my' ) | ( 'our' ) | ( 'local' ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt15=1;
                }
                break;
            case 44:
                {
                alt15=2;
                }
                break;
            case 45:
                {
                alt15=3;
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
                    // InternalPerl.g:1466:2: ( 'my' )
                    {
                    // InternalPerl.g:1466:2: ( 'my' )
                    // InternalPerl.g:1467:3: 'my'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPVariableDeclarationAccess().getMyKeyword_1_0()); 
                    }
                    match(input,43,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPVariableDeclarationAccess().getMyKeyword_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1472:2: ( 'our' )
                    {
                    // InternalPerl.g:1472:2: ( 'our' )
                    // InternalPerl.g:1473:3: 'our'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPVariableDeclarationAccess().getOurKeyword_1_1()); 
                    }
                    match(input,44,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPVariableDeclarationAccess().getOurKeyword_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1478:2: ( 'local' )
                    {
                    // InternalPerl.g:1478:2: ( 'local' )
                    // InternalPerl.g:1479:3: 'local'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPVariableDeclarationAccess().getLocalKeyword_1_2()); 
                    }
                    match(input,45,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__PVariableDeclaration__Alternatives_2"
    // InternalPerl.g:1488:1: rule__PVariableDeclaration__Alternatives_2 : ( ( '$' ) | ( '%' ) | ( '@' ) );
    public final void rule__PVariableDeclaration__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1492:1: ( ( '$' ) | ( '%' ) | ( '@' ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt16=1;
                }
                break;
            case 39:
                {
                alt16=2;
                }
                break;
            case 47:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalPerl.g:1493:2: ( '$' )
                    {
                    // InternalPerl.g:1493:2: ( '$' )
                    // InternalPerl.g:1494:3: '$'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPVariableDeclarationAccess().getDollarSignKeyword_2_0()); 
                    }
                    match(input,46,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPVariableDeclarationAccess().getDollarSignKeyword_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1499:2: ( '%' )
                    {
                    // InternalPerl.g:1499:2: ( '%' )
                    // InternalPerl.g:1500:3: '%'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPVariableDeclarationAccess().getPercentSignKeyword_2_1()); 
                    }
                    match(input,39,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPVariableDeclarationAccess().getPercentSignKeyword_2_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1505:2: ( '@' )
                    {
                    // InternalPerl.g:1505:2: ( '@' )
                    // InternalPerl.g:1506:3: '@'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPVariableDeclarationAccess().getCommercialAtKeyword_2_2()); 
                    }
                    match(input,47,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPVariableDeclarationAccess().getCommercialAtKeyword_2_2()); 
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
    // $ANTLR end "rule__PVariableDeclaration__Alternatives_2"


    // $ANTLR start "rule__FeatureCallID__Alternatives_0"
    // InternalPerl.g:1515:1: rule__FeatureCallID__Alternatives_0 : ( ( '$' ) | ( '%' ) | ( '@' ) );
    public final void rule__FeatureCallID__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1519:1: ( ( '$' ) | ( '%' ) | ( '@' ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt17=1;
                }
                break;
            case 39:
                {
                alt17=2;
                }
                break;
            case 47:
                {
                alt17=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalPerl.g:1520:2: ( '$' )
                    {
                    // InternalPerl.g:1520:2: ( '$' )
                    // InternalPerl.g:1521:3: '$'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureCallIDAccess().getDollarSignKeyword_0_0()); 
                    }
                    match(input,46,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureCallIDAccess().getDollarSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1526:2: ( '%' )
                    {
                    // InternalPerl.g:1526:2: ( '%' )
                    // InternalPerl.g:1527:3: '%'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureCallIDAccess().getPercentSignKeyword_0_1()); 
                    }
                    match(input,39,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureCallIDAccess().getPercentSignKeyword_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1532:2: ( '@' )
                    {
                    // InternalPerl.g:1532:2: ( '@' )
                    // InternalPerl.g:1533:3: '@'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureCallIDAccess().getCommercialAtKeyword_0_2()); 
                    }
                    match(input,47,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureCallIDAccess().getCommercialAtKeyword_0_2()); 
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
    // $ANTLR end "rule__FeatureCallID__Alternatives_0"


    // $ANTLR start "rule__Number__Alternatives"
    // InternalPerl.g:1542:1: rule__Number__Alternatives : ( ( RULE_HEX ) | ( RULE_BIN ) | ( RULE_INT ) );
    public final void rule__Number__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1546:1: ( ( RULE_HEX ) | ( RULE_BIN ) | ( RULE_INT ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt18=1;
                }
                break;
            case RULE_BIN:
                {
                alt18=2;
                }
                break;
            case RULE_INT:
                {
                alt18=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalPerl.g:1547:2: ( RULE_HEX )
                    {
                    // InternalPerl.g:1547:2: ( RULE_HEX )
                    // InternalPerl.g:1548:3: RULE_HEX
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
                    // InternalPerl.g:1553:2: ( RULE_BIN )
                    {
                    // InternalPerl.g:1553:2: ( RULE_BIN )
                    // InternalPerl.g:1554:3: RULE_BIN
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
                    // InternalPerl.g:1559:2: ( RULE_INT )
                    {
                    // InternalPerl.g:1559:2: ( RULE_INT )
                    // InternalPerl.g:1560:3: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_2()); 
                    }
                    match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_2()); 
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
    // InternalPerl.g:1569:1: rule__PAssignment__Group_0__0 : rule__PAssignment__Group_0__0__Impl rule__PAssignment__Group_0__1 ;
    public final void rule__PAssignment__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1573:1: ( rule__PAssignment__Group_0__0__Impl rule__PAssignment__Group_0__1 )
            // InternalPerl.g:1574:2: rule__PAssignment__Group_0__0__Impl rule__PAssignment__Group_0__1
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
    // InternalPerl.g:1581:1: rule__PAssignment__Group_0__0__Impl : ( () ) ;
    public final void rule__PAssignment__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1585:1: ( ( () ) )
            // InternalPerl.g:1586:1: ( () )
            {
            // InternalPerl.g:1586:1: ( () )
            // InternalPerl.g:1587:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getPAssignmentAction_0_0()); 
            }
            // InternalPerl.g:1588:2: ()
            // InternalPerl.g:1588:3: 
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
    // InternalPerl.g:1596:1: rule__PAssignment__Group_0__1 : rule__PAssignment__Group_0__1__Impl rule__PAssignment__Group_0__2 ;
    public final void rule__PAssignment__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1600:1: ( rule__PAssignment__Group_0__1__Impl rule__PAssignment__Group_0__2 )
            // InternalPerl.g:1601:2: rule__PAssignment__Group_0__1__Impl rule__PAssignment__Group_0__2
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
    // InternalPerl.g:1608:1: rule__PAssignment__Group_0__1__Impl : ( ( rule__PAssignment__FeatureAssignment_0_1 ) ) ;
    public final void rule__PAssignment__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1612:1: ( ( ( rule__PAssignment__FeatureAssignment_0_1 ) ) )
            // InternalPerl.g:1613:1: ( ( rule__PAssignment__FeatureAssignment_0_1 ) )
            {
            // InternalPerl.g:1613:1: ( ( rule__PAssignment__FeatureAssignment_0_1 ) )
            // InternalPerl.g:1614:2: ( rule__PAssignment__FeatureAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getFeatureAssignment_0_1()); 
            }
            // InternalPerl.g:1615:2: ( rule__PAssignment__FeatureAssignment_0_1 )
            // InternalPerl.g:1615:3: rule__PAssignment__FeatureAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PAssignment__FeatureAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getFeatureAssignment_0_1()); 
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
    // InternalPerl.g:1623:1: rule__PAssignment__Group_0__2 : rule__PAssignment__Group_0__2__Impl rule__PAssignment__Group_0__3 ;
    public final void rule__PAssignment__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1627:1: ( rule__PAssignment__Group_0__2__Impl rule__PAssignment__Group_0__3 )
            // InternalPerl.g:1628:2: rule__PAssignment__Group_0__2__Impl rule__PAssignment__Group_0__3
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
    // InternalPerl.g:1635:1: rule__PAssignment__Group_0__2__Impl : ( ruleOpSingleAssign ) ;
    public final void rule__PAssignment__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1639:1: ( ( ruleOpSingleAssign ) )
            // InternalPerl.g:1640:1: ( ruleOpSingleAssign )
            {
            // InternalPerl.g:1640:1: ( ruleOpSingleAssign )
            // InternalPerl.g:1641:2: ruleOpSingleAssign
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
    // InternalPerl.g:1650:1: rule__PAssignment__Group_0__3 : rule__PAssignment__Group_0__3__Impl ;
    public final void rule__PAssignment__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1654:1: ( rule__PAssignment__Group_0__3__Impl )
            // InternalPerl.g:1655:2: rule__PAssignment__Group_0__3__Impl
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
    // InternalPerl.g:1661:1: rule__PAssignment__Group_0__3__Impl : ( ( rule__PAssignment__ValueAssignment_0_3 ) ) ;
    public final void rule__PAssignment__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1665:1: ( ( ( rule__PAssignment__ValueAssignment_0_3 ) ) )
            // InternalPerl.g:1666:1: ( ( rule__PAssignment__ValueAssignment_0_3 ) )
            {
            // InternalPerl.g:1666:1: ( ( rule__PAssignment__ValueAssignment_0_3 ) )
            // InternalPerl.g:1667:2: ( rule__PAssignment__ValueAssignment_0_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getValueAssignment_0_3()); 
            }
            // InternalPerl.g:1668:2: ( rule__PAssignment__ValueAssignment_0_3 )
            // InternalPerl.g:1668:3: rule__PAssignment__ValueAssignment_0_3
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
    // InternalPerl.g:1677:1: rule__PAssignment__Group_1__0 : rule__PAssignment__Group_1__0__Impl rule__PAssignment__Group_1__1 ;
    public final void rule__PAssignment__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1681:1: ( rule__PAssignment__Group_1__0__Impl rule__PAssignment__Group_1__1 )
            // InternalPerl.g:1682:2: rule__PAssignment__Group_1__0__Impl rule__PAssignment__Group_1__1
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
    // InternalPerl.g:1689:1: rule__PAssignment__Group_1__0__Impl : ( rulePOrExpression ) ;
    public final void rule__PAssignment__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1693:1: ( ( rulePOrExpression ) )
            // InternalPerl.g:1694:1: ( rulePOrExpression )
            {
            // InternalPerl.g:1694:1: ( rulePOrExpression )
            // InternalPerl.g:1695:2: rulePOrExpression
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
    // InternalPerl.g:1704:1: rule__PAssignment__Group_1__1 : rule__PAssignment__Group_1__1__Impl ;
    public final void rule__PAssignment__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1708:1: ( rule__PAssignment__Group_1__1__Impl )
            // InternalPerl.g:1709:2: rule__PAssignment__Group_1__1__Impl
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
    // InternalPerl.g:1715:1: rule__PAssignment__Group_1__1__Impl : ( ( rule__PAssignment__Group_1_1__0 )? ) ;
    public final void rule__PAssignment__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1719:1: ( ( ( rule__PAssignment__Group_1_1__0 )? ) )
            // InternalPerl.g:1720:1: ( ( rule__PAssignment__Group_1_1__0 )? )
            {
            // InternalPerl.g:1720:1: ( ( rule__PAssignment__Group_1_1__0 )? )
            // InternalPerl.g:1721:2: ( rule__PAssignment__Group_1_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getGroup_1_1()); 
            }
            // InternalPerl.g:1722:2: ( rule__PAssignment__Group_1_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=15 && LA19_0<=20)||(LA19_0>=26 && LA19_0<=27)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalPerl.g:1722:3: rule__PAssignment__Group_1_1__0
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
    // InternalPerl.g:1731:1: rule__PAssignment__Group_1_1__0 : rule__PAssignment__Group_1_1__0__Impl rule__PAssignment__Group_1_1__1 ;
    public final void rule__PAssignment__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1735:1: ( rule__PAssignment__Group_1_1__0__Impl rule__PAssignment__Group_1_1__1 )
            // InternalPerl.g:1736:2: rule__PAssignment__Group_1_1__0__Impl rule__PAssignment__Group_1_1__1
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
    // InternalPerl.g:1743:1: rule__PAssignment__Group_1_1__0__Impl : ( ( rule__PAssignment__Group_1_1_0__0 ) ) ;
    public final void rule__PAssignment__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1747:1: ( ( ( rule__PAssignment__Group_1_1_0__0 ) ) )
            // InternalPerl.g:1748:1: ( ( rule__PAssignment__Group_1_1_0__0 ) )
            {
            // InternalPerl.g:1748:1: ( ( rule__PAssignment__Group_1_1_0__0 ) )
            // InternalPerl.g:1749:2: ( rule__PAssignment__Group_1_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getGroup_1_1_0()); 
            }
            // InternalPerl.g:1750:2: ( rule__PAssignment__Group_1_1_0__0 )
            // InternalPerl.g:1750:3: rule__PAssignment__Group_1_1_0__0
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
    // InternalPerl.g:1758:1: rule__PAssignment__Group_1_1__1 : rule__PAssignment__Group_1_1__1__Impl ;
    public final void rule__PAssignment__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1762:1: ( rule__PAssignment__Group_1_1__1__Impl )
            // InternalPerl.g:1763:2: rule__PAssignment__Group_1_1__1__Impl
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
    // InternalPerl.g:1769:1: rule__PAssignment__Group_1_1__1__Impl : ( ( rule__PAssignment__RightOperandAssignment_1_1_1 ) ) ;
    public final void rule__PAssignment__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1773:1: ( ( ( rule__PAssignment__RightOperandAssignment_1_1_1 ) ) )
            // InternalPerl.g:1774:1: ( ( rule__PAssignment__RightOperandAssignment_1_1_1 ) )
            {
            // InternalPerl.g:1774:1: ( ( rule__PAssignment__RightOperandAssignment_1_1_1 ) )
            // InternalPerl.g:1775:2: ( rule__PAssignment__RightOperandAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getRightOperandAssignment_1_1_1()); 
            }
            // InternalPerl.g:1776:2: ( rule__PAssignment__RightOperandAssignment_1_1_1 )
            // InternalPerl.g:1776:3: rule__PAssignment__RightOperandAssignment_1_1_1
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
    // InternalPerl.g:1785:1: rule__PAssignment__Group_1_1_0__0 : rule__PAssignment__Group_1_1_0__0__Impl ;
    public final void rule__PAssignment__Group_1_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1789:1: ( rule__PAssignment__Group_1_1_0__0__Impl )
            // InternalPerl.g:1790:2: rule__PAssignment__Group_1_1_0__0__Impl
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
    // InternalPerl.g:1796:1: rule__PAssignment__Group_1_1_0__0__Impl : ( ( rule__PAssignment__Group_1_1_0_0__0 ) ) ;
    public final void rule__PAssignment__Group_1_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1800:1: ( ( ( rule__PAssignment__Group_1_1_0_0__0 ) ) )
            // InternalPerl.g:1801:1: ( ( rule__PAssignment__Group_1_1_0_0__0 ) )
            {
            // InternalPerl.g:1801:1: ( ( rule__PAssignment__Group_1_1_0_0__0 ) )
            // InternalPerl.g:1802:2: ( rule__PAssignment__Group_1_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getGroup_1_1_0_0()); 
            }
            // InternalPerl.g:1803:2: ( rule__PAssignment__Group_1_1_0_0__0 )
            // InternalPerl.g:1803:3: rule__PAssignment__Group_1_1_0_0__0
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
    // InternalPerl.g:1812:1: rule__PAssignment__Group_1_1_0_0__0 : rule__PAssignment__Group_1_1_0_0__0__Impl rule__PAssignment__Group_1_1_0_0__1 ;
    public final void rule__PAssignment__Group_1_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1816:1: ( rule__PAssignment__Group_1_1_0_0__0__Impl rule__PAssignment__Group_1_1_0_0__1 )
            // InternalPerl.g:1817:2: rule__PAssignment__Group_1_1_0_0__0__Impl rule__PAssignment__Group_1_1_0_0__1
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
    // InternalPerl.g:1824:1: rule__PAssignment__Group_1_1_0_0__0__Impl : ( () ) ;
    public final void rule__PAssignment__Group_1_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1828:1: ( ( () ) )
            // InternalPerl.g:1829:1: ( () )
            {
            // InternalPerl.g:1829:1: ( () )
            // InternalPerl.g:1830:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getPBinaryOperationLeftOperandAction_1_1_0_0_0()); 
            }
            // InternalPerl.g:1831:2: ()
            // InternalPerl.g:1831:3: 
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
    // InternalPerl.g:1839:1: rule__PAssignment__Group_1_1_0_0__1 : rule__PAssignment__Group_1_1_0_0__1__Impl ;
    public final void rule__PAssignment__Group_1_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1843:1: ( rule__PAssignment__Group_1_1_0_0__1__Impl )
            // InternalPerl.g:1844:2: rule__PAssignment__Group_1_1_0_0__1__Impl
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
    // InternalPerl.g:1850:1: rule__PAssignment__Group_1_1_0_0__1__Impl : ( ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 ) ) ;
    public final void rule__PAssignment__Group_1_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1854:1: ( ( ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 ) ) )
            // InternalPerl.g:1855:1: ( ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 ) )
            {
            // InternalPerl.g:1855:1: ( ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 ) )
            // InternalPerl.g:1856:2: ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getFeatureAssignment_1_1_0_0_1()); 
            }
            // InternalPerl.g:1857:2: ( rule__PAssignment__FeatureAssignment_1_1_0_0_1 )
            // InternalPerl.g:1857:3: rule__PAssignment__FeatureAssignment_1_1_0_0_1
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
    // InternalPerl.g:1866:1: rule__OpMultiAssign__Group_6__0 : rule__OpMultiAssign__Group_6__0__Impl rule__OpMultiAssign__Group_6__1 ;
    public final void rule__OpMultiAssign__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1870:1: ( rule__OpMultiAssign__Group_6__0__Impl rule__OpMultiAssign__Group_6__1 )
            // InternalPerl.g:1871:2: rule__OpMultiAssign__Group_6__0__Impl rule__OpMultiAssign__Group_6__1
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
    // InternalPerl.g:1878:1: rule__OpMultiAssign__Group_6__0__Impl : ( '<' ) ;
    public final void rule__OpMultiAssign__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1882:1: ( ( '<' ) )
            // InternalPerl.g:1883:1: ( '<' )
            {
            // InternalPerl.g:1883:1: ( '<' )
            // InternalPerl.g:1884:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:1893:1: rule__OpMultiAssign__Group_6__1 : rule__OpMultiAssign__Group_6__1__Impl rule__OpMultiAssign__Group_6__2 ;
    public final void rule__OpMultiAssign__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1897:1: ( rule__OpMultiAssign__Group_6__1__Impl rule__OpMultiAssign__Group_6__2 )
            // InternalPerl.g:1898:2: rule__OpMultiAssign__Group_6__1__Impl rule__OpMultiAssign__Group_6__2
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
    // InternalPerl.g:1905:1: rule__OpMultiAssign__Group_6__1__Impl : ( '<' ) ;
    public final void rule__OpMultiAssign__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1909:1: ( ( '<' ) )
            // InternalPerl.g:1910:1: ( '<' )
            {
            // InternalPerl.g:1910:1: ( '<' )
            // InternalPerl.g:1911:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_1()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:1920:1: rule__OpMultiAssign__Group_6__2 : rule__OpMultiAssign__Group_6__2__Impl ;
    public final void rule__OpMultiAssign__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1924:1: ( rule__OpMultiAssign__Group_6__2__Impl )
            // InternalPerl.g:1925:2: rule__OpMultiAssign__Group_6__2__Impl
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
    // InternalPerl.g:1931:1: rule__OpMultiAssign__Group_6__2__Impl : ( '=' ) ;
    public final void rule__OpMultiAssign__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1935:1: ( ( '=' ) )
            // InternalPerl.g:1936:1: ( '=' )
            {
            // InternalPerl.g:1936:1: ( '=' )
            // InternalPerl.g:1937:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_6_2()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:1947:1: rule__OpMultiAssign__Group_7__0 : rule__OpMultiAssign__Group_7__0__Impl rule__OpMultiAssign__Group_7__1 ;
    public final void rule__OpMultiAssign__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1951:1: ( rule__OpMultiAssign__Group_7__0__Impl rule__OpMultiAssign__Group_7__1 )
            // InternalPerl.g:1952:2: rule__OpMultiAssign__Group_7__0__Impl rule__OpMultiAssign__Group_7__1
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
    // InternalPerl.g:1959:1: rule__OpMultiAssign__Group_7__0__Impl : ( '>' ) ;
    public final void rule__OpMultiAssign__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1963:1: ( ( '>' ) )
            // InternalPerl.g:1964:1: ( '>' )
            {
            // InternalPerl.g:1964:1: ( '>' )
            // InternalPerl.g:1965:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:1974:1: rule__OpMultiAssign__Group_7__1 : rule__OpMultiAssign__Group_7__1__Impl rule__OpMultiAssign__Group_7__2 ;
    public final void rule__OpMultiAssign__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1978:1: ( rule__OpMultiAssign__Group_7__1__Impl rule__OpMultiAssign__Group_7__2 )
            // InternalPerl.g:1979:2: rule__OpMultiAssign__Group_7__1__Impl rule__OpMultiAssign__Group_7__2
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
    // InternalPerl.g:1986:1: rule__OpMultiAssign__Group_7__1__Impl : ( ( '>' )? ) ;
    public final void rule__OpMultiAssign__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:1990:1: ( ( ( '>' )? ) )
            // InternalPerl.g:1991:1: ( ( '>' )? )
            {
            // InternalPerl.g:1991:1: ( ( '>' )? )
            // InternalPerl.g:1992:2: ( '>' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_1()); 
            }
            // InternalPerl.g:1993:2: ( '>' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==26) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalPerl.g:1993:3: '>'
                    {
                    match(input,26,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:2001:1: rule__OpMultiAssign__Group_7__2 : rule__OpMultiAssign__Group_7__2__Impl ;
    public final void rule__OpMultiAssign__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2005:1: ( rule__OpMultiAssign__Group_7__2__Impl )
            // InternalPerl.g:2006:2: rule__OpMultiAssign__Group_7__2__Impl
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
    // InternalPerl.g:2012:1: rule__OpMultiAssign__Group_7__2__Impl : ( '>=' ) ;
    public final void rule__OpMultiAssign__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2016:1: ( ( '>=' ) )
            // InternalPerl.g:2017:1: ( '>=' )
            {
            // InternalPerl.g:2017:1: ( '>=' )
            // InternalPerl.g:2018:2: '>='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_7_2()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:2028:1: rule__POrExpression__Group__0 : rule__POrExpression__Group__0__Impl rule__POrExpression__Group__1 ;
    public final void rule__POrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2032:1: ( rule__POrExpression__Group__0__Impl rule__POrExpression__Group__1 )
            // InternalPerl.g:2033:2: rule__POrExpression__Group__0__Impl rule__POrExpression__Group__1
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
    // InternalPerl.g:2040:1: rule__POrExpression__Group__0__Impl : ( rulePAndExpression ) ;
    public final void rule__POrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2044:1: ( ( rulePAndExpression ) )
            // InternalPerl.g:2045:1: ( rulePAndExpression )
            {
            // InternalPerl.g:2045:1: ( rulePAndExpression )
            // InternalPerl.g:2046:2: rulePAndExpression
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
    // InternalPerl.g:2055:1: rule__POrExpression__Group__1 : rule__POrExpression__Group__1__Impl ;
    public final void rule__POrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2059:1: ( rule__POrExpression__Group__1__Impl )
            // InternalPerl.g:2060:2: rule__POrExpression__Group__1__Impl
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
    // InternalPerl.g:2066:1: rule__POrExpression__Group__1__Impl : ( ( rule__POrExpression__Group_1__0 )* ) ;
    public final void rule__POrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2070:1: ( ( ( rule__POrExpression__Group_1__0 )* ) )
            // InternalPerl.g:2071:1: ( ( rule__POrExpression__Group_1__0 )* )
            {
            // InternalPerl.g:2071:1: ( ( rule__POrExpression__Group_1__0 )* )
            // InternalPerl.g:2072:2: ( rule__POrExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:2073:2: ( rule__POrExpression__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==13) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalPerl.g:2073:3: rule__POrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__POrExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalPerl.g:2082:1: rule__POrExpression__Group_1__0 : rule__POrExpression__Group_1__0__Impl rule__POrExpression__Group_1__1 ;
    public final void rule__POrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2086:1: ( rule__POrExpression__Group_1__0__Impl rule__POrExpression__Group_1__1 )
            // InternalPerl.g:2087:2: rule__POrExpression__Group_1__0__Impl rule__POrExpression__Group_1__1
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
    // InternalPerl.g:2094:1: rule__POrExpression__Group_1__0__Impl : ( ( rule__POrExpression__Group_1_0__0 ) ) ;
    public final void rule__POrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2098:1: ( ( ( rule__POrExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:2099:1: ( ( rule__POrExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:2099:1: ( ( rule__POrExpression__Group_1_0__0 ) )
            // InternalPerl.g:2100:2: ( rule__POrExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:2101:2: ( rule__POrExpression__Group_1_0__0 )
            // InternalPerl.g:2101:3: rule__POrExpression__Group_1_0__0
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
    // InternalPerl.g:2109:1: rule__POrExpression__Group_1__1 : rule__POrExpression__Group_1__1__Impl ;
    public final void rule__POrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2113:1: ( rule__POrExpression__Group_1__1__Impl )
            // InternalPerl.g:2114:2: rule__POrExpression__Group_1__1__Impl
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
    // InternalPerl.g:2120:1: rule__POrExpression__Group_1__1__Impl : ( ( rule__POrExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__POrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2124:1: ( ( ( rule__POrExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:2125:1: ( ( rule__POrExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:2125:1: ( ( rule__POrExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:2126:2: ( rule__POrExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:2127:2: ( rule__POrExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:2127:3: rule__POrExpression__RightOperandAssignment_1_1
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
    // InternalPerl.g:2136:1: rule__POrExpression__Group_1_0__0 : rule__POrExpression__Group_1_0__0__Impl ;
    public final void rule__POrExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2140:1: ( rule__POrExpression__Group_1_0__0__Impl )
            // InternalPerl.g:2141:2: rule__POrExpression__Group_1_0__0__Impl
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
    // InternalPerl.g:2147:1: rule__POrExpression__Group_1_0__0__Impl : ( ( rule__POrExpression__Group_1_0_0__0 ) ) ;
    public final void rule__POrExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2151:1: ( ( ( rule__POrExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:2152:1: ( ( rule__POrExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:2152:1: ( ( rule__POrExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:2153:2: ( rule__POrExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:2154:2: ( rule__POrExpression__Group_1_0_0__0 )
            // InternalPerl.g:2154:3: rule__POrExpression__Group_1_0_0__0
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
    // InternalPerl.g:2163:1: rule__POrExpression__Group_1_0_0__0 : rule__POrExpression__Group_1_0_0__0__Impl rule__POrExpression__Group_1_0_0__1 ;
    public final void rule__POrExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2167:1: ( rule__POrExpression__Group_1_0_0__0__Impl rule__POrExpression__Group_1_0_0__1 )
            // InternalPerl.g:2168:2: rule__POrExpression__Group_1_0_0__0__Impl rule__POrExpression__Group_1_0_0__1
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
    // InternalPerl.g:2175:1: rule__POrExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__POrExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2179:1: ( ( () ) )
            // InternalPerl.g:2180:1: ( () )
            {
            // InternalPerl.g:2180:1: ( () )
            // InternalPerl.g:2181:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:2182:2: ()
            // InternalPerl.g:2182:3: 
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
    // InternalPerl.g:2190:1: rule__POrExpression__Group_1_0_0__1 : rule__POrExpression__Group_1_0_0__1__Impl ;
    public final void rule__POrExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2194:1: ( rule__POrExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:2195:2: rule__POrExpression__Group_1_0_0__1__Impl
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
    // InternalPerl.g:2201:1: rule__POrExpression__Group_1_0_0__1__Impl : ( ( rule__POrExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__POrExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2205:1: ( ( ( rule__POrExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:2206:1: ( ( rule__POrExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:2206:1: ( ( rule__POrExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:2207:2: ( rule__POrExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOrExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:2208:2: ( rule__POrExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:2208:3: rule__POrExpression__FeatureAssignment_1_0_0_1
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
    // InternalPerl.g:2217:1: rule__PAndExpression__Group__0 : rule__PAndExpression__Group__0__Impl rule__PAndExpression__Group__1 ;
    public final void rule__PAndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2221:1: ( rule__PAndExpression__Group__0__Impl rule__PAndExpression__Group__1 )
            // InternalPerl.g:2222:2: rule__PAndExpression__Group__0__Impl rule__PAndExpression__Group__1
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
    // InternalPerl.g:2229:1: rule__PAndExpression__Group__0__Impl : ( rulePEqualityExpression ) ;
    public final void rule__PAndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2233:1: ( ( rulePEqualityExpression ) )
            // InternalPerl.g:2234:1: ( rulePEqualityExpression )
            {
            // InternalPerl.g:2234:1: ( rulePEqualityExpression )
            // InternalPerl.g:2235:2: rulePEqualityExpression
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
    // InternalPerl.g:2244:1: rule__PAndExpression__Group__1 : rule__PAndExpression__Group__1__Impl ;
    public final void rule__PAndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2248:1: ( rule__PAndExpression__Group__1__Impl )
            // InternalPerl.g:2249:2: rule__PAndExpression__Group__1__Impl
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
    // InternalPerl.g:2255:1: rule__PAndExpression__Group__1__Impl : ( ( rule__PAndExpression__Group_1__0 )* ) ;
    public final void rule__PAndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2259:1: ( ( ( rule__PAndExpression__Group_1__0 )* ) )
            // InternalPerl.g:2260:1: ( ( rule__PAndExpression__Group_1__0 )* )
            {
            // InternalPerl.g:2260:1: ( ( rule__PAndExpression__Group_1__0 )* )
            // InternalPerl.g:2261:2: ( rule__PAndExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:2262:2: ( rule__PAndExpression__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==14) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPerl.g:2262:3: rule__PAndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__PAndExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalPerl.g:2271:1: rule__PAndExpression__Group_1__0 : rule__PAndExpression__Group_1__0__Impl rule__PAndExpression__Group_1__1 ;
    public final void rule__PAndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2275:1: ( rule__PAndExpression__Group_1__0__Impl rule__PAndExpression__Group_1__1 )
            // InternalPerl.g:2276:2: rule__PAndExpression__Group_1__0__Impl rule__PAndExpression__Group_1__1
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
    // InternalPerl.g:2283:1: rule__PAndExpression__Group_1__0__Impl : ( ( rule__PAndExpression__Group_1_0__0 ) ) ;
    public final void rule__PAndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2287:1: ( ( ( rule__PAndExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:2288:1: ( ( rule__PAndExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:2288:1: ( ( rule__PAndExpression__Group_1_0__0 ) )
            // InternalPerl.g:2289:2: ( rule__PAndExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:2290:2: ( rule__PAndExpression__Group_1_0__0 )
            // InternalPerl.g:2290:3: rule__PAndExpression__Group_1_0__0
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
    // InternalPerl.g:2298:1: rule__PAndExpression__Group_1__1 : rule__PAndExpression__Group_1__1__Impl ;
    public final void rule__PAndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2302:1: ( rule__PAndExpression__Group_1__1__Impl )
            // InternalPerl.g:2303:2: rule__PAndExpression__Group_1__1__Impl
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
    // InternalPerl.g:2309:1: rule__PAndExpression__Group_1__1__Impl : ( ( rule__PAndExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PAndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2313:1: ( ( ( rule__PAndExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:2314:1: ( ( rule__PAndExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:2314:1: ( ( rule__PAndExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:2315:2: ( rule__PAndExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:2316:2: ( rule__PAndExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:2316:3: rule__PAndExpression__RightOperandAssignment_1_1
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
    // InternalPerl.g:2325:1: rule__PAndExpression__Group_1_0__0 : rule__PAndExpression__Group_1_0__0__Impl ;
    public final void rule__PAndExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2329:1: ( rule__PAndExpression__Group_1_0__0__Impl )
            // InternalPerl.g:2330:2: rule__PAndExpression__Group_1_0__0__Impl
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
    // InternalPerl.g:2336:1: rule__PAndExpression__Group_1_0__0__Impl : ( ( rule__PAndExpression__Group_1_0_0__0 ) ) ;
    public final void rule__PAndExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2340:1: ( ( ( rule__PAndExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:2341:1: ( ( rule__PAndExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:2341:1: ( ( rule__PAndExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:2342:2: ( rule__PAndExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:2343:2: ( rule__PAndExpression__Group_1_0_0__0 )
            // InternalPerl.g:2343:3: rule__PAndExpression__Group_1_0_0__0
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
    // InternalPerl.g:2352:1: rule__PAndExpression__Group_1_0_0__0 : rule__PAndExpression__Group_1_0_0__0__Impl rule__PAndExpression__Group_1_0_0__1 ;
    public final void rule__PAndExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2356:1: ( rule__PAndExpression__Group_1_0_0__0__Impl rule__PAndExpression__Group_1_0_0__1 )
            // InternalPerl.g:2357:2: rule__PAndExpression__Group_1_0_0__0__Impl rule__PAndExpression__Group_1_0_0__1
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
    // InternalPerl.g:2364:1: rule__PAndExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PAndExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2368:1: ( ( () ) )
            // InternalPerl.g:2369:1: ( () )
            {
            // InternalPerl.g:2369:1: ( () )
            // InternalPerl.g:2370:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:2371:2: ()
            // InternalPerl.g:2371:3: 
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
    // InternalPerl.g:2379:1: rule__PAndExpression__Group_1_0_0__1 : rule__PAndExpression__Group_1_0_0__1__Impl ;
    public final void rule__PAndExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2383:1: ( rule__PAndExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:2384:2: rule__PAndExpression__Group_1_0_0__1__Impl
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
    // InternalPerl.g:2390:1: rule__PAndExpression__Group_1_0_0__1__Impl : ( ( rule__PAndExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PAndExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2394:1: ( ( ( rule__PAndExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:2395:1: ( ( rule__PAndExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:2395:1: ( ( rule__PAndExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:2396:2: ( rule__PAndExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAndExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:2397:2: ( rule__PAndExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:2397:3: rule__PAndExpression__FeatureAssignment_1_0_0_1
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
    // InternalPerl.g:2406:1: rule__PEqualityExpression__Group__0 : rule__PEqualityExpression__Group__0__Impl rule__PEqualityExpression__Group__1 ;
    public final void rule__PEqualityExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2410:1: ( rule__PEqualityExpression__Group__0__Impl rule__PEqualityExpression__Group__1 )
            // InternalPerl.g:2411:2: rule__PEqualityExpression__Group__0__Impl rule__PEqualityExpression__Group__1
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
    // InternalPerl.g:2418:1: rule__PEqualityExpression__Group__0__Impl : ( rulePRelationalExpression ) ;
    public final void rule__PEqualityExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2422:1: ( ( rulePRelationalExpression ) )
            // InternalPerl.g:2423:1: ( rulePRelationalExpression )
            {
            // InternalPerl.g:2423:1: ( rulePRelationalExpression )
            // InternalPerl.g:2424:2: rulePRelationalExpression
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
    // InternalPerl.g:2433:1: rule__PEqualityExpression__Group__1 : rule__PEqualityExpression__Group__1__Impl ;
    public final void rule__PEqualityExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2437:1: ( rule__PEqualityExpression__Group__1__Impl )
            // InternalPerl.g:2438:2: rule__PEqualityExpression__Group__1__Impl
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
    // InternalPerl.g:2444:1: rule__PEqualityExpression__Group__1__Impl : ( ( rule__PEqualityExpression__Group_1__0 )* ) ;
    public final void rule__PEqualityExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2448:1: ( ( ( rule__PEqualityExpression__Group_1__0 )* ) )
            // InternalPerl.g:2449:1: ( ( rule__PEqualityExpression__Group_1__0 )* )
            {
            // InternalPerl.g:2449:1: ( ( rule__PEqualityExpression__Group_1__0 )* )
            // InternalPerl.g:2450:2: ( rule__PEqualityExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:2451:2: ( rule__PEqualityExpression__Group_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=21 && LA23_0<=24)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalPerl.g:2451:3: rule__PEqualityExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__PEqualityExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalPerl.g:2460:1: rule__PEqualityExpression__Group_1__0 : rule__PEqualityExpression__Group_1__0__Impl rule__PEqualityExpression__Group_1__1 ;
    public final void rule__PEqualityExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2464:1: ( rule__PEqualityExpression__Group_1__0__Impl rule__PEqualityExpression__Group_1__1 )
            // InternalPerl.g:2465:2: rule__PEqualityExpression__Group_1__0__Impl rule__PEqualityExpression__Group_1__1
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
    // InternalPerl.g:2472:1: rule__PEqualityExpression__Group_1__0__Impl : ( ( rule__PEqualityExpression__Group_1_0__0 ) ) ;
    public final void rule__PEqualityExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2476:1: ( ( ( rule__PEqualityExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:2477:1: ( ( rule__PEqualityExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:2477:1: ( ( rule__PEqualityExpression__Group_1_0__0 ) )
            // InternalPerl.g:2478:2: ( rule__PEqualityExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:2479:2: ( rule__PEqualityExpression__Group_1_0__0 )
            // InternalPerl.g:2479:3: rule__PEqualityExpression__Group_1_0__0
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
    // InternalPerl.g:2487:1: rule__PEqualityExpression__Group_1__1 : rule__PEqualityExpression__Group_1__1__Impl ;
    public final void rule__PEqualityExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2491:1: ( rule__PEqualityExpression__Group_1__1__Impl )
            // InternalPerl.g:2492:2: rule__PEqualityExpression__Group_1__1__Impl
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
    // InternalPerl.g:2498:1: rule__PEqualityExpression__Group_1__1__Impl : ( ( rule__PEqualityExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PEqualityExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2502:1: ( ( ( rule__PEqualityExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:2503:1: ( ( rule__PEqualityExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:2503:1: ( ( rule__PEqualityExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:2504:2: ( rule__PEqualityExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:2505:2: ( rule__PEqualityExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:2505:3: rule__PEqualityExpression__RightOperandAssignment_1_1
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
    // InternalPerl.g:2514:1: rule__PEqualityExpression__Group_1_0__0 : rule__PEqualityExpression__Group_1_0__0__Impl ;
    public final void rule__PEqualityExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2518:1: ( rule__PEqualityExpression__Group_1_0__0__Impl )
            // InternalPerl.g:2519:2: rule__PEqualityExpression__Group_1_0__0__Impl
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
    // InternalPerl.g:2525:1: rule__PEqualityExpression__Group_1_0__0__Impl : ( ( rule__PEqualityExpression__Group_1_0_0__0 ) ) ;
    public final void rule__PEqualityExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2529:1: ( ( ( rule__PEqualityExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:2530:1: ( ( rule__PEqualityExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:2530:1: ( ( rule__PEqualityExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:2531:2: ( rule__PEqualityExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:2532:2: ( rule__PEqualityExpression__Group_1_0_0__0 )
            // InternalPerl.g:2532:3: rule__PEqualityExpression__Group_1_0_0__0
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
    // InternalPerl.g:2541:1: rule__PEqualityExpression__Group_1_0_0__0 : rule__PEqualityExpression__Group_1_0_0__0__Impl rule__PEqualityExpression__Group_1_0_0__1 ;
    public final void rule__PEqualityExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2545:1: ( rule__PEqualityExpression__Group_1_0_0__0__Impl rule__PEqualityExpression__Group_1_0_0__1 )
            // InternalPerl.g:2546:2: rule__PEqualityExpression__Group_1_0_0__0__Impl rule__PEqualityExpression__Group_1_0_0__1
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
    // InternalPerl.g:2553:1: rule__PEqualityExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PEqualityExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2557:1: ( ( () ) )
            // InternalPerl.g:2558:1: ( () )
            {
            // InternalPerl.g:2558:1: ( () )
            // InternalPerl.g:2559:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:2560:2: ()
            // InternalPerl.g:2560:3: 
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
    // InternalPerl.g:2568:1: rule__PEqualityExpression__Group_1_0_0__1 : rule__PEqualityExpression__Group_1_0_0__1__Impl ;
    public final void rule__PEqualityExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2572:1: ( rule__PEqualityExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:2573:2: rule__PEqualityExpression__Group_1_0_0__1__Impl
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
    // InternalPerl.g:2579:1: rule__PEqualityExpression__Group_1_0_0__1__Impl : ( ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PEqualityExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2583:1: ( ( ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:2584:1: ( ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:2584:1: ( ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:2585:2: ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPEqualityExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:2586:2: ( rule__PEqualityExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:2586:3: rule__PEqualityExpression__FeatureAssignment_1_0_0_1
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
    // InternalPerl.g:2595:1: rule__PRelationalExpression__Group__0 : rule__PRelationalExpression__Group__0__Impl rule__PRelationalExpression__Group__1 ;
    public final void rule__PRelationalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2599:1: ( rule__PRelationalExpression__Group__0__Impl rule__PRelationalExpression__Group__1 )
            // InternalPerl.g:2600:2: rule__PRelationalExpression__Group__0__Impl rule__PRelationalExpression__Group__1
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
    // InternalPerl.g:2607:1: rule__PRelationalExpression__Group__0__Impl : ( rulePOtherOperatorExpression ) ;
    public final void rule__PRelationalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2611:1: ( ( rulePOtherOperatorExpression ) )
            // InternalPerl.g:2612:1: ( rulePOtherOperatorExpression )
            {
            // InternalPerl.g:2612:1: ( rulePOtherOperatorExpression )
            // InternalPerl.g:2613:2: rulePOtherOperatorExpression
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
    // InternalPerl.g:2622:1: rule__PRelationalExpression__Group__1 : rule__PRelationalExpression__Group__1__Impl ;
    public final void rule__PRelationalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2626:1: ( rule__PRelationalExpression__Group__1__Impl )
            // InternalPerl.g:2627:2: rule__PRelationalExpression__Group__1__Impl
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
    // InternalPerl.g:2633:1: rule__PRelationalExpression__Group__1__Impl : ( ( rule__PRelationalExpression__Group_1__0 )* ) ;
    public final void rule__PRelationalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2637:1: ( ( ( rule__PRelationalExpression__Group_1__0 )* ) )
            // InternalPerl.g:2638:1: ( ( rule__PRelationalExpression__Group_1__0 )* )
            {
            // InternalPerl.g:2638:1: ( ( rule__PRelationalExpression__Group_1__0 )* )
            // InternalPerl.g:2639:2: ( rule__PRelationalExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:2640:2: ( rule__PRelationalExpression__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                switch ( input.LA(1) ) {
                case 27:
                    {
                    int LA24_2 = input.LA(2);

                    if ( (LA24_2==12||(LA24_2>=34 && LA24_2<=35)||LA24_2==40) ) {
                        alt24=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA24_3 = input.LA(2);

                    if ( ((LA24_3>=34 && LA24_3<=35)||LA24_3==40) ) {
                        alt24=1;
                    }


                    }
                    break;
                case 25:
                    {
                    alt24=1;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // InternalPerl.g:2640:3: rule__PRelationalExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__PRelationalExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalPerl.g:2649:1: rule__PRelationalExpression__Group_1__0 : rule__PRelationalExpression__Group_1__0__Impl rule__PRelationalExpression__Group_1__1 ;
    public final void rule__PRelationalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2653:1: ( rule__PRelationalExpression__Group_1__0__Impl rule__PRelationalExpression__Group_1__1 )
            // InternalPerl.g:2654:2: rule__PRelationalExpression__Group_1__0__Impl rule__PRelationalExpression__Group_1__1
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
    // InternalPerl.g:2661:1: rule__PRelationalExpression__Group_1__0__Impl : ( ( rule__PRelationalExpression__Group_1_0__0 ) ) ;
    public final void rule__PRelationalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2665:1: ( ( ( rule__PRelationalExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:2666:1: ( ( rule__PRelationalExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:2666:1: ( ( rule__PRelationalExpression__Group_1_0__0 ) )
            // InternalPerl.g:2667:2: ( rule__PRelationalExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:2668:2: ( rule__PRelationalExpression__Group_1_0__0 )
            // InternalPerl.g:2668:3: rule__PRelationalExpression__Group_1_0__0
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
    // InternalPerl.g:2676:1: rule__PRelationalExpression__Group_1__1 : rule__PRelationalExpression__Group_1__1__Impl ;
    public final void rule__PRelationalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2680:1: ( rule__PRelationalExpression__Group_1__1__Impl )
            // InternalPerl.g:2681:2: rule__PRelationalExpression__Group_1__1__Impl
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
    // InternalPerl.g:2687:1: rule__PRelationalExpression__Group_1__1__Impl : ( ( rule__PRelationalExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PRelationalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2691:1: ( ( ( rule__PRelationalExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:2692:1: ( ( rule__PRelationalExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:2692:1: ( ( rule__PRelationalExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:2693:2: ( rule__PRelationalExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:2694:2: ( rule__PRelationalExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:2694:3: rule__PRelationalExpression__RightOperandAssignment_1_1
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
    // InternalPerl.g:2703:1: rule__PRelationalExpression__Group_1_0__0 : rule__PRelationalExpression__Group_1_0__0__Impl ;
    public final void rule__PRelationalExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2707:1: ( rule__PRelationalExpression__Group_1_0__0__Impl )
            // InternalPerl.g:2708:2: rule__PRelationalExpression__Group_1_0__0__Impl
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
    // InternalPerl.g:2714:1: rule__PRelationalExpression__Group_1_0__0__Impl : ( ( rule__PRelationalExpression__Group_1_0_0__0 ) ) ;
    public final void rule__PRelationalExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2718:1: ( ( ( rule__PRelationalExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:2719:1: ( ( rule__PRelationalExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:2719:1: ( ( rule__PRelationalExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:2720:2: ( rule__PRelationalExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:2721:2: ( rule__PRelationalExpression__Group_1_0_0__0 )
            // InternalPerl.g:2721:3: rule__PRelationalExpression__Group_1_0_0__0
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
    // InternalPerl.g:2730:1: rule__PRelationalExpression__Group_1_0_0__0 : rule__PRelationalExpression__Group_1_0_0__0__Impl rule__PRelationalExpression__Group_1_0_0__1 ;
    public final void rule__PRelationalExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2734:1: ( rule__PRelationalExpression__Group_1_0_0__0__Impl rule__PRelationalExpression__Group_1_0_0__1 )
            // InternalPerl.g:2735:2: rule__PRelationalExpression__Group_1_0_0__0__Impl rule__PRelationalExpression__Group_1_0_0__1
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
    // InternalPerl.g:2742:1: rule__PRelationalExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PRelationalExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2746:1: ( ( () ) )
            // InternalPerl.g:2747:1: ( () )
            {
            // InternalPerl.g:2747:1: ( () )
            // InternalPerl.g:2748:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:2749:2: ()
            // InternalPerl.g:2749:3: 
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
    // InternalPerl.g:2757:1: rule__PRelationalExpression__Group_1_0_0__1 : rule__PRelationalExpression__Group_1_0_0__1__Impl ;
    public final void rule__PRelationalExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2761:1: ( rule__PRelationalExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:2762:2: rule__PRelationalExpression__Group_1_0_0__1__Impl
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
    // InternalPerl.g:2768:1: rule__PRelationalExpression__Group_1_0_0__1__Impl : ( ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PRelationalExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2772:1: ( ( ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:2773:1: ( ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:2773:1: ( ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:2774:2: ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPRelationalExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:2775:2: ( rule__PRelationalExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:2775:3: rule__PRelationalExpression__FeatureAssignment_1_0_0_1
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
    // InternalPerl.g:2784:1: rule__OpCompare__Group_1__0 : rule__OpCompare__Group_1__0__Impl rule__OpCompare__Group_1__1 ;
    public final void rule__OpCompare__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2788:1: ( rule__OpCompare__Group_1__0__Impl rule__OpCompare__Group_1__1 )
            // InternalPerl.g:2789:2: rule__OpCompare__Group_1__0__Impl rule__OpCompare__Group_1__1
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
    // InternalPerl.g:2796:1: rule__OpCompare__Group_1__0__Impl : ( '<' ) ;
    public final void rule__OpCompare__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2800:1: ( ( '<' ) )
            // InternalPerl.g:2801:1: ( '<' )
            {
            // InternalPerl.g:2801:1: ( '<' )
            // InternalPerl.g:2802:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:2811:1: rule__OpCompare__Group_1__1 : rule__OpCompare__Group_1__1__Impl ;
    public final void rule__OpCompare__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2815:1: ( rule__OpCompare__Group_1__1__Impl )
            // InternalPerl.g:2816:2: rule__OpCompare__Group_1__1__Impl
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
    // InternalPerl.g:2822:1: rule__OpCompare__Group_1__1__Impl : ( '=' ) ;
    public final void rule__OpCompare__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2826:1: ( ( '=' ) )
            // InternalPerl.g:2827:1: ( '=' )
            {
            // InternalPerl.g:2827:1: ( '=' )
            // InternalPerl.g:2828:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:2838:1: rule__POtherOperatorExpression__Group__0 : rule__POtherOperatorExpression__Group__0__Impl rule__POtherOperatorExpression__Group__1 ;
    public final void rule__POtherOperatorExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2842:1: ( rule__POtherOperatorExpression__Group__0__Impl rule__POtherOperatorExpression__Group__1 )
            // InternalPerl.g:2843:2: rule__POtherOperatorExpression__Group__0__Impl rule__POtherOperatorExpression__Group__1
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
    // InternalPerl.g:2850:1: rule__POtherOperatorExpression__Group__0__Impl : ( rulePAdditiveExpression ) ;
    public final void rule__POtherOperatorExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2854:1: ( ( rulePAdditiveExpression ) )
            // InternalPerl.g:2855:1: ( rulePAdditiveExpression )
            {
            // InternalPerl.g:2855:1: ( rulePAdditiveExpression )
            // InternalPerl.g:2856:2: rulePAdditiveExpression
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
    // InternalPerl.g:2865:1: rule__POtherOperatorExpression__Group__1 : rule__POtherOperatorExpression__Group__1__Impl ;
    public final void rule__POtherOperatorExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2869:1: ( rule__POtherOperatorExpression__Group__1__Impl )
            // InternalPerl.g:2870:2: rule__POtherOperatorExpression__Group__1__Impl
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
    // InternalPerl.g:2876:1: rule__POtherOperatorExpression__Group__1__Impl : ( ( rule__POtherOperatorExpression__Group_1__0 )* ) ;
    public final void rule__POtherOperatorExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2880:1: ( ( ( rule__POtherOperatorExpression__Group_1__0 )* ) )
            // InternalPerl.g:2881:1: ( ( rule__POtherOperatorExpression__Group_1__0 )* )
            {
            // InternalPerl.g:2881:1: ( ( rule__POtherOperatorExpression__Group_1__0 )* )
            // InternalPerl.g:2882:2: ( rule__POtherOperatorExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:2883:2: ( rule__POtherOperatorExpression__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                switch ( input.LA(1) ) {
                case 27:
                    {
                    int LA25_2 = input.LA(2);

                    if ( (LA25_2==27) ) {
                        int LA25_5 = input.LA(3);

                        if ( (LA25_5==27||(LA25_5>=34 && LA25_5<=35)||LA25_5==40) ) {
                            alt25=1;
                        }


                    }
                    else if ( (LA25_2==31) ) {
                        alt25=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA25_3 = input.LA(2);

                    if ( (LA25_3==26) ) {
                        int LA25_6 = input.LA(3);

                        if ( (LA25_6==26||(LA25_6>=34 && LA25_6<=35)||LA25_6==40) ) {
                            alt25=1;
                        }


                    }
                    else if ( (LA25_3==30) ) {
                        alt25=1;
                    }


                    }
                    break;
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                    {
                    alt25=1;
                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // InternalPerl.g:2883:3: rule__POtherOperatorExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__POtherOperatorExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalPerl.g:2892:1: rule__POtherOperatorExpression__Group_1__0 : rule__POtherOperatorExpression__Group_1__0__Impl rule__POtherOperatorExpression__Group_1__1 ;
    public final void rule__POtherOperatorExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2896:1: ( rule__POtherOperatorExpression__Group_1__0__Impl rule__POtherOperatorExpression__Group_1__1 )
            // InternalPerl.g:2897:2: rule__POtherOperatorExpression__Group_1__0__Impl rule__POtherOperatorExpression__Group_1__1
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
    // InternalPerl.g:2904:1: rule__POtherOperatorExpression__Group_1__0__Impl : ( ( rule__POtherOperatorExpression__Group_1_0__0 ) ) ;
    public final void rule__POtherOperatorExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2908:1: ( ( ( rule__POtherOperatorExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:2909:1: ( ( rule__POtherOperatorExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:2909:1: ( ( rule__POtherOperatorExpression__Group_1_0__0 ) )
            // InternalPerl.g:2910:2: ( rule__POtherOperatorExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:2911:2: ( rule__POtherOperatorExpression__Group_1_0__0 )
            // InternalPerl.g:2911:3: rule__POtherOperatorExpression__Group_1_0__0
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
    // InternalPerl.g:2919:1: rule__POtherOperatorExpression__Group_1__1 : rule__POtherOperatorExpression__Group_1__1__Impl ;
    public final void rule__POtherOperatorExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2923:1: ( rule__POtherOperatorExpression__Group_1__1__Impl )
            // InternalPerl.g:2924:2: rule__POtherOperatorExpression__Group_1__1__Impl
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
    // InternalPerl.g:2930:1: rule__POtherOperatorExpression__Group_1__1__Impl : ( ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__POtherOperatorExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2934:1: ( ( ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:2935:1: ( ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:2935:1: ( ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:2936:2: ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:2937:2: ( rule__POtherOperatorExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:2937:3: rule__POtherOperatorExpression__RightOperandAssignment_1_1
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
    // InternalPerl.g:2946:1: rule__POtherOperatorExpression__Group_1_0__0 : rule__POtherOperatorExpression__Group_1_0__0__Impl ;
    public final void rule__POtherOperatorExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2950:1: ( rule__POtherOperatorExpression__Group_1_0__0__Impl )
            // InternalPerl.g:2951:2: rule__POtherOperatorExpression__Group_1_0__0__Impl
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
    // InternalPerl.g:2957:1: rule__POtherOperatorExpression__Group_1_0__0__Impl : ( ( rule__POtherOperatorExpression__Group_1_0_0__0 ) ) ;
    public final void rule__POtherOperatorExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2961:1: ( ( ( rule__POtherOperatorExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:2962:1: ( ( rule__POtherOperatorExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:2962:1: ( ( rule__POtherOperatorExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:2963:2: ( rule__POtherOperatorExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:2964:2: ( rule__POtherOperatorExpression__Group_1_0_0__0 )
            // InternalPerl.g:2964:3: rule__POtherOperatorExpression__Group_1_0_0__0
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
    // InternalPerl.g:2973:1: rule__POtherOperatorExpression__Group_1_0_0__0 : rule__POtherOperatorExpression__Group_1_0_0__0__Impl rule__POtherOperatorExpression__Group_1_0_0__1 ;
    public final void rule__POtherOperatorExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2977:1: ( rule__POtherOperatorExpression__Group_1_0_0__0__Impl rule__POtherOperatorExpression__Group_1_0_0__1 )
            // InternalPerl.g:2978:2: rule__POtherOperatorExpression__Group_1_0_0__0__Impl rule__POtherOperatorExpression__Group_1_0_0__1
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
    // InternalPerl.g:2985:1: rule__POtherOperatorExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__POtherOperatorExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:2989:1: ( ( () ) )
            // InternalPerl.g:2990:1: ( () )
            {
            // InternalPerl.g:2990:1: ( () )
            // InternalPerl.g:2991:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:2992:2: ()
            // InternalPerl.g:2992:3: 
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
    // InternalPerl.g:3000:1: rule__POtherOperatorExpression__Group_1_0_0__1 : rule__POtherOperatorExpression__Group_1_0_0__1__Impl ;
    public final void rule__POtherOperatorExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3004:1: ( rule__POtherOperatorExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:3005:2: rule__POtherOperatorExpression__Group_1_0_0__1__Impl
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
    // InternalPerl.g:3011:1: rule__POtherOperatorExpression__Group_1_0_0__1__Impl : ( ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__POtherOperatorExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3015:1: ( ( ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:3016:1: ( ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:3016:1: ( ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:3017:2: ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:3018:2: ( rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:3018:3: rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1
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


    // $ANTLR start "rule__OpOther__Group_2__0"
    // InternalPerl.g:3027:1: rule__OpOther__Group_2__0 : rule__OpOther__Group_2__0__Impl rule__OpOther__Group_2__1 ;
    public final void rule__OpOther__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3031:1: ( rule__OpOther__Group_2__0__Impl rule__OpOther__Group_2__1 )
            // InternalPerl.g:3032:2: rule__OpOther__Group_2__0__Impl rule__OpOther__Group_2__1
            {
            pushFollow(FOLLOW_19);
            rule__OpOther__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_2__1();

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
    // $ANTLR end "rule__OpOther__Group_2__0"


    // $ANTLR start "rule__OpOther__Group_2__0__Impl"
    // InternalPerl.g:3039:1: rule__OpOther__Group_2__0__Impl : ( '>' ) ;
    public final void rule__OpOther__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3043:1: ( ( '>' ) )
            // InternalPerl.g:3044:1: ( '>' )
            {
            // InternalPerl.g:3044:1: ( '>' )
            // InternalPerl.g:3045:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0()); 
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
    // $ANTLR end "rule__OpOther__Group_2__0__Impl"


    // $ANTLR start "rule__OpOther__Group_2__1"
    // InternalPerl.g:3054:1: rule__OpOther__Group_2__1 : rule__OpOther__Group_2__1__Impl ;
    public final void rule__OpOther__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3058:1: ( rule__OpOther__Group_2__1__Impl )
            // InternalPerl.g:3059:2: rule__OpOther__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_2__1__Impl();

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
    // $ANTLR end "rule__OpOther__Group_2__1"


    // $ANTLR start "rule__OpOther__Group_2__1__Impl"
    // InternalPerl.g:3065:1: rule__OpOther__Group_2__1__Impl : ( '..' ) ;
    public final void rule__OpOther__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3069:1: ( ( '..' ) )
            // InternalPerl.g:3070:1: ( '..' )
            {
            // InternalPerl.g:3070:1: ( '..' )
            // InternalPerl.g:3071:2: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1()); 
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
    // $ANTLR end "rule__OpOther__Group_2__1__Impl"


    // $ANTLR start "rule__OpOther__Group_5__0"
    // InternalPerl.g:3081:1: rule__OpOther__Group_5__0 : rule__OpOther__Group_5__0__Impl rule__OpOther__Group_5__1 ;
    public final void rule__OpOther__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3085:1: ( rule__OpOther__Group_5__0__Impl rule__OpOther__Group_5__1 )
            // InternalPerl.g:3086:2: rule__OpOther__Group_5__0__Impl rule__OpOther__Group_5__1
            {
            pushFollow(FOLLOW_20);
            rule__OpOther__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_5__1();

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
    // $ANTLR end "rule__OpOther__Group_5__0"


    // $ANTLR start "rule__OpOther__Group_5__0__Impl"
    // InternalPerl.g:3093:1: rule__OpOther__Group_5__0__Impl : ( '>' ) ;
    public final void rule__OpOther__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3097:1: ( ( '>' ) )
            // InternalPerl.g:3098:1: ( '>' )
            {
            // InternalPerl.g:3098:1: ( '>' )
            // InternalPerl.g:3099:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0()); 
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
    // $ANTLR end "rule__OpOther__Group_5__0__Impl"


    // $ANTLR start "rule__OpOther__Group_5__1"
    // InternalPerl.g:3108:1: rule__OpOther__Group_5__1 : rule__OpOther__Group_5__1__Impl ;
    public final void rule__OpOther__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3112:1: ( rule__OpOther__Group_5__1__Impl )
            // InternalPerl.g:3113:2: rule__OpOther__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_5__1__Impl();

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
    // $ANTLR end "rule__OpOther__Group_5__1"


    // $ANTLR start "rule__OpOther__Group_5__1__Impl"
    // InternalPerl.g:3119:1: rule__OpOther__Group_5__1__Impl : ( ( rule__OpOther__Alternatives_5_1 ) ) ;
    public final void rule__OpOther__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3123:1: ( ( ( rule__OpOther__Alternatives_5_1 ) ) )
            // InternalPerl.g:3124:1: ( ( rule__OpOther__Alternatives_5_1 ) )
            {
            // InternalPerl.g:3124:1: ( ( rule__OpOther__Alternatives_5_1 ) )
            // InternalPerl.g:3125:2: ( rule__OpOther__Alternatives_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getAlternatives_5_1()); 
            }
            // InternalPerl.g:3126:2: ( rule__OpOther__Alternatives_5_1 )
            // InternalPerl.g:3126:3: rule__OpOther__Alternatives_5_1
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Alternatives_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getAlternatives_5_1()); 
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
    // $ANTLR end "rule__OpOther__Group_5__1__Impl"


    // $ANTLR start "rule__OpOther__Group_5_1_0__0"
    // InternalPerl.g:3135:1: rule__OpOther__Group_5_1_0__0 : rule__OpOther__Group_5_1_0__0__Impl ;
    public final void rule__OpOther__Group_5_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3139:1: ( rule__OpOther__Group_5_1_0__0__Impl )
            // InternalPerl.g:3140:2: rule__OpOther__Group_5_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_5_1_0__0__Impl();

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
    // $ANTLR end "rule__OpOther__Group_5_1_0__0"


    // $ANTLR start "rule__OpOther__Group_5_1_0__0__Impl"
    // InternalPerl.g:3146:1: rule__OpOther__Group_5_1_0__0__Impl : ( ( rule__OpOther__Group_5_1_0_0__0 ) ) ;
    public final void rule__OpOther__Group_5_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3150:1: ( ( ( rule__OpOther__Group_5_1_0_0__0 ) ) )
            // InternalPerl.g:3151:1: ( ( rule__OpOther__Group_5_1_0_0__0 ) )
            {
            // InternalPerl.g:3151:1: ( ( rule__OpOther__Group_5_1_0_0__0 ) )
            // InternalPerl.g:3152:2: ( rule__OpOther__Group_5_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGroup_5_1_0_0()); 
            }
            // InternalPerl.g:3153:2: ( rule__OpOther__Group_5_1_0_0__0 )
            // InternalPerl.g:3153:3: rule__OpOther__Group_5_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_5_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGroup_5_1_0_0()); 
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
    // $ANTLR end "rule__OpOther__Group_5_1_0__0__Impl"


    // $ANTLR start "rule__OpOther__Group_5_1_0_0__0"
    // InternalPerl.g:3162:1: rule__OpOther__Group_5_1_0_0__0 : rule__OpOther__Group_5_1_0_0__0__Impl rule__OpOther__Group_5_1_0_0__1 ;
    public final void rule__OpOther__Group_5_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3166:1: ( rule__OpOther__Group_5_1_0_0__0__Impl rule__OpOther__Group_5_1_0_0__1 )
            // InternalPerl.g:3167:2: rule__OpOther__Group_5_1_0_0__0__Impl rule__OpOther__Group_5_1_0_0__1
            {
            pushFollow(FOLLOW_20);
            rule__OpOther__Group_5_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_5_1_0_0__1();

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
    // $ANTLR end "rule__OpOther__Group_5_1_0_0__0"


    // $ANTLR start "rule__OpOther__Group_5_1_0_0__0__Impl"
    // InternalPerl.g:3174:1: rule__OpOther__Group_5_1_0_0__0__Impl : ( '>' ) ;
    public final void rule__OpOther__Group_5_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3178:1: ( ( '>' ) )
            // InternalPerl.g:3179:1: ( '>' )
            {
            // InternalPerl.g:3179:1: ( '>' )
            // InternalPerl.g:3180:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0()); 
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
    // $ANTLR end "rule__OpOther__Group_5_1_0_0__0__Impl"


    // $ANTLR start "rule__OpOther__Group_5_1_0_0__1"
    // InternalPerl.g:3189:1: rule__OpOther__Group_5_1_0_0__1 : rule__OpOther__Group_5_1_0_0__1__Impl ;
    public final void rule__OpOther__Group_5_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3193:1: ( rule__OpOther__Group_5_1_0_0__1__Impl )
            // InternalPerl.g:3194:2: rule__OpOther__Group_5_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_5_1_0_0__1__Impl();

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
    // $ANTLR end "rule__OpOther__Group_5_1_0_0__1"


    // $ANTLR start "rule__OpOther__Group_5_1_0_0__1__Impl"
    // InternalPerl.g:3200:1: rule__OpOther__Group_5_1_0_0__1__Impl : ( '>' ) ;
    public final void rule__OpOther__Group_5_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3204:1: ( ( '>' ) )
            // InternalPerl.g:3205:1: ( '>' )
            {
            // InternalPerl.g:3205:1: ( '>' )
            // InternalPerl.g:3206:2: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1()); 
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
    // $ANTLR end "rule__OpOther__Group_5_1_0_0__1__Impl"


    // $ANTLR start "rule__OpOther__Group_6__0"
    // InternalPerl.g:3216:1: rule__OpOther__Group_6__0 : rule__OpOther__Group_6__0__Impl rule__OpOther__Group_6__1 ;
    public final void rule__OpOther__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3220:1: ( rule__OpOther__Group_6__0__Impl rule__OpOther__Group_6__1 )
            // InternalPerl.g:3221:2: rule__OpOther__Group_6__0__Impl rule__OpOther__Group_6__1
            {
            pushFollow(FOLLOW_21);
            rule__OpOther__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_6__1();

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
    // $ANTLR end "rule__OpOther__Group_6__0"


    // $ANTLR start "rule__OpOther__Group_6__0__Impl"
    // InternalPerl.g:3228:1: rule__OpOther__Group_6__0__Impl : ( '<' ) ;
    public final void rule__OpOther__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3232:1: ( ( '<' ) )
            // InternalPerl.g:3233:1: ( '<' )
            {
            // InternalPerl.g:3233:1: ( '<' )
            // InternalPerl.g:3234:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0()); 
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
    // $ANTLR end "rule__OpOther__Group_6__0__Impl"


    // $ANTLR start "rule__OpOther__Group_6__1"
    // InternalPerl.g:3243:1: rule__OpOther__Group_6__1 : rule__OpOther__Group_6__1__Impl ;
    public final void rule__OpOther__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3247:1: ( rule__OpOther__Group_6__1__Impl )
            // InternalPerl.g:3248:2: rule__OpOther__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_6__1__Impl();

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
    // $ANTLR end "rule__OpOther__Group_6__1"


    // $ANTLR start "rule__OpOther__Group_6__1__Impl"
    // InternalPerl.g:3254:1: rule__OpOther__Group_6__1__Impl : ( ( rule__OpOther__Alternatives_6_1 ) ) ;
    public final void rule__OpOther__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3258:1: ( ( ( rule__OpOther__Alternatives_6_1 ) ) )
            // InternalPerl.g:3259:1: ( ( rule__OpOther__Alternatives_6_1 ) )
            {
            // InternalPerl.g:3259:1: ( ( rule__OpOther__Alternatives_6_1 ) )
            // InternalPerl.g:3260:2: ( rule__OpOther__Alternatives_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getAlternatives_6_1()); 
            }
            // InternalPerl.g:3261:2: ( rule__OpOther__Alternatives_6_1 )
            // InternalPerl.g:3261:3: rule__OpOther__Alternatives_6_1
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Alternatives_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getAlternatives_6_1()); 
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
    // $ANTLR end "rule__OpOther__Group_6__1__Impl"


    // $ANTLR start "rule__OpOther__Group_6_1_0__0"
    // InternalPerl.g:3270:1: rule__OpOther__Group_6_1_0__0 : rule__OpOther__Group_6_1_0__0__Impl ;
    public final void rule__OpOther__Group_6_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3274:1: ( rule__OpOther__Group_6_1_0__0__Impl )
            // InternalPerl.g:3275:2: rule__OpOther__Group_6_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_6_1_0__0__Impl();

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
    // $ANTLR end "rule__OpOther__Group_6_1_0__0"


    // $ANTLR start "rule__OpOther__Group_6_1_0__0__Impl"
    // InternalPerl.g:3281:1: rule__OpOther__Group_6_1_0__0__Impl : ( ( rule__OpOther__Group_6_1_0_0__0 ) ) ;
    public final void rule__OpOther__Group_6_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3285:1: ( ( ( rule__OpOther__Group_6_1_0_0__0 ) ) )
            // InternalPerl.g:3286:1: ( ( rule__OpOther__Group_6_1_0_0__0 ) )
            {
            // InternalPerl.g:3286:1: ( ( rule__OpOther__Group_6_1_0_0__0 ) )
            // InternalPerl.g:3287:2: ( rule__OpOther__Group_6_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getGroup_6_1_0_0()); 
            }
            // InternalPerl.g:3288:2: ( rule__OpOther__Group_6_1_0_0__0 )
            // InternalPerl.g:3288:3: rule__OpOther__Group_6_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_6_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getGroup_6_1_0_0()); 
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
    // $ANTLR end "rule__OpOther__Group_6_1_0__0__Impl"


    // $ANTLR start "rule__OpOther__Group_6_1_0_0__0"
    // InternalPerl.g:3297:1: rule__OpOther__Group_6_1_0_0__0 : rule__OpOther__Group_6_1_0_0__0__Impl rule__OpOther__Group_6_1_0_0__1 ;
    public final void rule__OpOther__Group_6_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3301:1: ( rule__OpOther__Group_6_1_0_0__0__Impl rule__OpOther__Group_6_1_0_0__1 )
            // InternalPerl.g:3302:2: rule__OpOther__Group_6_1_0_0__0__Impl rule__OpOther__Group_6_1_0_0__1
            {
            pushFollow(FOLLOW_7);
            rule__OpOther__Group_6_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_6_1_0_0__1();

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
    // $ANTLR end "rule__OpOther__Group_6_1_0_0__0"


    // $ANTLR start "rule__OpOther__Group_6_1_0_0__0__Impl"
    // InternalPerl.g:3309:1: rule__OpOther__Group_6_1_0_0__0__Impl : ( '<' ) ;
    public final void rule__OpOther__Group_6_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3313:1: ( ( '<' ) )
            // InternalPerl.g:3314:1: ( '<' )
            {
            // InternalPerl.g:3314:1: ( '<' )
            // InternalPerl.g:3315:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0()); 
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
    // $ANTLR end "rule__OpOther__Group_6_1_0_0__0__Impl"


    // $ANTLR start "rule__OpOther__Group_6_1_0_0__1"
    // InternalPerl.g:3324:1: rule__OpOther__Group_6_1_0_0__1 : rule__OpOther__Group_6_1_0_0__1__Impl ;
    public final void rule__OpOther__Group_6_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3328:1: ( rule__OpOther__Group_6_1_0_0__1__Impl )
            // InternalPerl.g:3329:2: rule__OpOther__Group_6_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OpOther__Group_6_1_0_0__1__Impl();

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
    // $ANTLR end "rule__OpOther__Group_6_1_0_0__1"


    // $ANTLR start "rule__OpOther__Group_6_1_0_0__1__Impl"
    // InternalPerl.g:3335:1: rule__OpOther__Group_6_1_0_0__1__Impl : ( '<' ) ;
    public final void rule__OpOther__Group_6_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3339:1: ( ( '<' ) )
            // InternalPerl.g:3340:1: ( '<' )
            {
            // InternalPerl.g:3340:1: ( '<' )
            // InternalPerl.g:3341:2: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1()); 
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
    // $ANTLR end "rule__OpOther__Group_6_1_0_0__1__Impl"


    // $ANTLR start "rule__PAdditiveExpression__Group__0"
    // InternalPerl.g:3351:1: rule__PAdditiveExpression__Group__0 : rule__PAdditiveExpression__Group__0__Impl rule__PAdditiveExpression__Group__1 ;
    public final void rule__PAdditiveExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3355:1: ( rule__PAdditiveExpression__Group__0__Impl rule__PAdditiveExpression__Group__1 )
            // InternalPerl.g:3356:2: rule__PAdditiveExpression__Group__0__Impl rule__PAdditiveExpression__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalPerl.g:3363:1: rule__PAdditiveExpression__Group__0__Impl : ( rulePMultiplicativeExpression ) ;
    public final void rule__PAdditiveExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3367:1: ( ( rulePMultiplicativeExpression ) )
            // InternalPerl.g:3368:1: ( rulePMultiplicativeExpression )
            {
            // InternalPerl.g:3368:1: ( rulePMultiplicativeExpression )
            // InternalPerl.g:3369:2: rulePMultiplicativeExpression
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
    // InternalPerl.g:3378:1: rule__PAdditiveExpression__Group__1 : rule__PAdditiveExpression__Group__1__Impl ;
    public final void rule__PAdditiveExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3382:1: ( rule__PAdditiveExpression__Group__1__Impl )
            // InternalPerl.g:3383:2: rule__PAdditiveExpression__Group__1__Impl
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
    // InternalPerl.g:3389:1: rule__PAdditiveExpression__Group__1__Impl : ( ( rule__PAdditiveExpression__Group_1__0 )* ) ;
    public final void rule__PAdditiveExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3393:1: ( ( ( rule__PAdditiveExpression__Group_1__0 )* ) )
            // InternalPerl.g:3394:1: ( ( rule__PAdditiveExpression__Group_1__0 )* )
            {
            // InternalPerl.g:3394:1: ( ( rule__PAdditiveExpression__Group_1__0 )* )
            // InternalPerl.g:3395:2: ( rule__PAdditiveExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:3396:2: ( rule__PAdditiveExpression__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // InternalPerl.g:3396:3: rule__PAdditiveExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__PAdditiveExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalPerl.g:3405:1: rule__PAdditiveExpression__Group_1__0 : rule__PAdditiveExpression__Group_1__0__Impl rule__PAdditiveExpression__Group_1__1 ;
    public final void rule__PAdditiveExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3409:1: ( rule__PAdditiveExpression__Group_1__0__Impl rule__PAdditiveExpression__Group_1__1 )
            // InternalPerl.g:3410:2: rule__PAdditiveExpression__Group_1__0__Impl rule__PAdditiveExpression__Group_1__1
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
    // InternalPerl.g:3417:1: rule__PAdditiveExpression__Group_1__0__Impl : ( ( rule__PAdditiveExpression__Group_1_0__0 ) ) ;
    public final void rule__PAdditiveExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3421:1: ( ( ( rule__PAdditiveExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:3422:1: ( ( rule__PAdditiveExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:3422:1: ( ( rule__PAdditiveExpression__Group_1_0__0 ) )
            // InternalPerl.g:3423:2: ( rule__PAdditiveExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:3424:2: ( rule__PAdditiveExpression__Group_1_0__0 )
            // InternalPerl.g:3424:3: rule__PAdditiveExpression__Group_1_0__0
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
    // InternalPerl.g:3432:1: rule__PAdditiveExpression__Group_1__1 : rule__PAdditiveExpression__Group_1__1__Impl ;
    public final void rule__PAdditiveExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3436:1: ( rule__PAdditiveExpression__Group_1__1__Impl )
            // InternalPerl.g:3437:2: rule__PAdditiveExpression__Group_1__1__Impl
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
    // InternalPerl.g:3443:1: rule__PAdditiveExpression__Group_1__1__Impl : ( ( rule__PAdditiveExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PAdditiveExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3447:1: ( ( ( rule__PAdditiveExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:3448:1: ( ( rule__PAdditiveExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:3448:1: ( ( rule__PAdditiveExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:3449:2: ( rule__PAdditiveExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:3450:2: ( rule__PAdditiveExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:3450:3: rule__PAdditiveExpression__RightOperandAssignment_1_1
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
    // InternalPerl.g:3459:1: rule__PAdditiveExpression__Group_1_0__0 : rule__PAdditiveExpression__Group_1_0__0__Impl ;
    public final void rule__PAdditiveExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3463:1: ( rule__PAdditiveExpression__Group_1_0__0__Impl )
            // InternalPerl.g:3464:2: rule__PAdditiveExpression__Group_1_0__0__Impl
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
    // InternalPerl.g:3470:1: rule__PAdditiveExpression__Group_1_0__0__Impl : ( ( rule__PAdditiveExpression__Group_1_0_0__0 ) ) ;
    public final void rule__PAdditiveExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3474:1: ( ( ( rule__PAdditiveExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:3475:1: ( ( rule__PAdditiveExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:3475:1: ( ( rule__PAdditiveExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:3476:2: ( rule__PAdditiveExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:3477:2: ( rule__PAdditiveExpression__Group_1_0_0__0 )
            // InternalPerl.g:3477:3: rule__PAdditiveExpression__Group_1_0_0__0
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
    // InternalPerl.g:3486:1: rule__PAdditiveExpression__Group_1_0_0__0 : rule__PAdditiveExpression__Group_1_0_0__0__Impl rule__PAdditiveExpression__Group_1_0_0__1 ;
    public final void rule__PAdditiveExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3490:1: ( rule__PAdditiveExpression__Group_1_0_0__0__Impl rule__PAdditiveExpression__Group_1_0_0__1 )
            // InternalPerl.g:3491:2: rule__PAdditiveExpression__Group_1_0_0__0__Impl rule__PAdditiveExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalPerl.g:3498:1: rule__PAdditiveExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PAdditiveExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3502:1: ( ( () ) )
            // InternalPerl.g:3503:1: ( () )
            {
            // InternalPerl.g:3503:1: ( () )
            // InternalPerl.g:3504:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:3505:2: ()
            // InternalPerl.g:3505:3: 
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
    // InternalPerl.g:3513:1: rule__PAdditiveExpression__Group_1_0_0__1 : rule__PAdditiveExpression__Group_1_0_0__1__Impl ;
    public final void rule__PAdditiveExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3517:1: ( rule__PAdditiveExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:3518:2: rule__PAdditiveExpression__Group_1_0_0__1__Impl
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
    // InternalPerl.g:3524:1: rule__PAdditiveExpression__Group_1_0_0__1__Impl : ( ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PAdditiveExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3528:1: ( ( ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:3529:1: ( ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:3529:1: ( ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:3530:2: ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:3531:2: ( rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:3531:3: rule__PAdditiveExpression__FeatureAssignment_1_0_0_1
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
    // InternalPerl.g:3540:1: rule__PMultiplicativeExpression__Group__0 : rule__PMultiplicativeExpression__Group__0__Impl rule__PMultiplicativeExpression__Group__1 ;
    public final void rule__PMultiplicativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3544:1: ( rule__PMultiplicativeExpression__Group__0__Impl rule__PMultiplicativeExpression__Group__1 )
            // InternalPerl.g:3545:2: rule__PMultiplicativeExpression__Group__0__Impl rule__PMultiplicativeExpression__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalPerl.g:3552:1: rule__PMultiplicativeExpression__Group__0__Impl : ( rulePUnaryOperation ) ;
    public final void rule__PMultiplicativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3556:1: ( ( rulePUnaryOperation ) )
            // InternalPerl.g:3557:1: ( rulePUnaryOperation )
            {
            // InternalPerl.g:3557:1: ( rulePUnaryOperation )
            // InternalPerl.g:3558:2: rulePUnaryOperation
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
    // InternalPerl.g:3567:1: rule__PMultiplicativeExpression__Group__1 : rule__PMultiplicativeExpression__Group__1__Impl ;
    public final void rule__PMultiplicativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3571:1: ( rule__PMultiplicativeExpression__Group__1__Impl )
            // InternalPerl.g:3572:2: rule__PMultiplicativeExpression__Group__1__Impl
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
    // InternalPerl.g:3578:1: rule__PMultiplicativeExpression__Group__1__Impl : ( ( rule__PMultiplicativeExpression__Group_1__0 )* ) ;
    public final void rule__PMultiplicativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3582:1: ( ( ( rule__PMultiplicativeExpression__Group_1__0 )* ) )
            // InternalPerl.g:3583:1: ( ( rule__PMultiplicativeExpression__Group_1__0 )* )
            {
            // InternalPerl.g:3583:1: ( ( rule__PMultiplicativeExpression__Group_1__0 )* )
            // InternalPerl.g:3584:2: ( rule__PMultiplicativeExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getGroup_1()); 
            }
            // InternalPerl.g:3585:2: ( rule__PMultiplicativeExpression__Group_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==39) ) {
                    int LA27_2 = input.LA(2);

                    if ( ((LA27_2>=34 && LA27_2<=35)||LA27_2==40) ) {
                        alt27=1;
                    }


                }
                else if ( ((LA27_0>=36 && LA27_0<=38)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalPerl.g:3585:3: rule__PMultiplicativeExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__PMultiplicativeExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalPerl.g:3594:1: rule__PMultiplicativeExpression__Group_1__0 : rule__PMultiplicativeExpression__Group_1__0__Impl rule__PMultiplicativeExpression__Group_1__1 ;
    public final void rule__PMultiplicativeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3598:1: ( rule__PMultiplicativeExpression__Group_1__0__Impl rule__PMultiplicativeExpression__Group_1__1 )
            // InternalPerl.g:3599:2: rule__PMultiplicativeExpression__Group_1__0__Impl rule__PMultiplicativeExpression__Group_1__1
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
    // InternalPerl.g:3606:1: rule__PMultiplicativeExpression__Group_1__0__Impl : ( ( rule__PMultiplicativeExpression__Group_1_0__0 ) ) ;
    public final void rule__PMultiplicativeExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3610:1: ( ( ( rule__PMultiplicativeExpression__Group_1_0__0 ) ) )
            // InternalPerl.g:3611:1: ( ( rule__PMultiplicativeExpression__Group_1_0__0 ) )
            {
            // InternalPerl.g:3611:1: ( ( rule__PMultiplicativeExpression__Group_1_0__0 ) )
            // InternalPerl.g:3612:2: ( rule__PMultiplicativeExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:3613:2: ( rule__PMultiplicativeExpression__Group_1_0__0 )
            // InternalPerl.g:3613:3: rule__PMultiplicativeExpression__Group_1_0__0
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
    // InternalPerl.g:3621:1: rule__PMultiplicativeExpression__Group_1__1 : rule__PMultiplicativeExpression__Group_1__1__Impl ;
    public final void rule__PMultiplicativeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3625:1: ( rule__PMultiplicativeExpression__Group_1__1__Impl )
            // InternalPerl.g:3626:2: rule__PMultiplicativeExpression__Group_1__1__Impl
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
    // InternalPerl.g:3632:1: rule__PMultiplicativeExpression__Group_1__1__Impl : ( ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 ) ) ;
    public final void rule__PMultiplicativeExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3636:1: ( ( ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 ) ) )
            // InternalPerl.g:3637:1: ( ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 ) )
            {
            // InternalPerl.g:3637:1: ( ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 ) )
            // InternalPerl.g:3638:2: ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getRightOperandAssignment_1_1()); 
            }
            // InternalPerl.g:3639:2: ( rule__PMultiplicativeExpression__RightOperandAssignment_1_1 )
            // InternalPerl.g:3639:3: rule__PMultiplicativeExpression__RightOperandAssignment_1_1
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
    // InternalPerl.g:3648:1: rule__PMultiplicativeExpression__Group_1_0__0 : rule__PMultiplicativeExpression__Group_1_0__0__Impl ;
    public final void rule__PMultiplicativeExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3652:1: ( rule__PMultiplicativeExpression__Group_1_0__0__Impl )
            // InternalPerl.g:3653:2: rule__PMultiplicativeExpression__Group_1_0__0__Impl
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
    // InternalPerl.g:3659:1: rule__PMultiplicativeExpression__Group_1_0__0__Impl : ( ( rule__PMultiplicativeExpression__Group_1_0_0__0 ) ) ;
    public final void rule__PMultiplicativeExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3663:1: ( ( ( rule__PMultiplicativeExpression__Group_1_0_0__0 ) ) )
            // InternalPerl.g:3664:1: ( ( rule__PMultiplicativeExpression__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:3664:1: ( ( rule__PMultiplicativeExpression__Group_1_0_0__0 ) )
            // InternalPerl.g:3665:2: ( rule__PMultiplicativeExpression__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:3666:2: ( rule__PMultiplicativeExpression__Group_1_0_0__0 )
            // InternalPerl.g:3666:3: rule__PMultiplicativeExpression__Group_1_0_0__0
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
    // InternalPerl.g:3675:1: rule__PMultiplicativeExpression__Group_1_0_0__0 : rule__PMultiplicativeExpression__Group_1_0_0__0__Impl rule__PMultiplicativeExpression__Group_1_0_0__1 ;
    public final void rule__PMultiplicativeExpression__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3679:1: ( rule__PMultiplicativeExpression__Group_1_0_0__0__Impl rule__PMultiplicativeExpression__Group_1_0_0__1 )
            // InternalPerl.g:3680:2: rule__PMultiplicativeExpression__Group_1_0_0__0__Impl rule__PMultiplicativeExpression__Group_1_0_0__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalPerl.g:3687:1: rule__PMultiplicativeExpression__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PMultiplicativeExpression__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3691:1: ( ( () ) )
            // InternalPerl.g:3692:1: ( () )
            {
            // InternalPerl.g:3692:1: ( () )
            // InternalPerl.g:3693:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0()); 
            }
            // InternalPerl.g:3694:2: ()
            // InternalPerl.g:3694:3: 
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
    // InternalPerl.g:3702:1: rule__PMultiplicativeExpression__Group_1_0_0__1 : rule__PMultiplicativeExpression__Group_1_0_0__1__Impl ;
    public final void rule__PMultiplicativeExpression__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3706:1: ( rule__PMultiplicativeExpression__Group_1_0_0__1__Impl )
            // InternalPerl.g:3707:2: rule__PMultiplicativeExpression__Group_1_0_0__1__Impl
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
    // InternalPerl.g:3713:1: rule__PMultiplicativeExpression__Group_1_0_0__1__Impl : ( ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PMultiplicativeExpression__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3717:1: ( ( ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:3718:1: ( ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:3718:1: ( ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:3719:2: ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:3720:2: ( rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:3720:3: rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1
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
    // InternalPerl.g:3729:1: rule__PUnaryOperation__Group__0 : rule__PUnaryOperation__Group__0__Impl rule__PUnaryOperation__Group__1 ;
    public final void rule__PUnaryOperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3733:1: ( rule__PUnaryOperation__Group__0__Impl rule__PUnaryOperation__Group__1 )
            // InternalPerl.g:3734:2: rule__PUnaryOperation__Group__0__Impl rule__PUnaryOperation__Group__1
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
    // InternalPerl.g:3741:1: rule__PUnaryOperation__Group__0__Impl : ( () ) ;
    public final void rule__PUnaryOperation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3745:1: ( ( () ) )
            // InternalPerl.g:3746:1: ( () )
            {
            // InternalPerl.g:3746:1: ( () )
            // InternalPerl.g:3747:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPUnaryOperationAccess().getPUnaryOperationAction_0()); 
            }
            // InternalPerl.g:3748:2: ()
            // InternalPerl.g:3748:3: 
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
    // InternalPerl.g:3756:1: rule__PUnaryOperation__Group__1 : rule__PUnaryOperation__Group__1__Impl rule__PUnaryOperation__Group__2 ;
    public final void rule__PUnaryOperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3760:1: ( rule__PUnaryOperation__Group__1__Impl rule__PUnaryOperation__Group__2 )
            // InternalPerl.g:3761:2: rule__PUnaryOperation__Group__1__Impl rule__PUnaryOperation__Group__2
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
    // InternalPerl.g:3768:1: rule__PUnaryOperation__Group__1__Impl : ( ( rule__PUnaryOperation__FeatureAssignment_1 ) ) ;
    public final void rule__PUnaryOperation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3772:1: ( ( ( rule__PUnaryOperation__FeatureAssignment_1 ) ) )
            // InternalPerl.g:3773:1: ( ( rule__PUnaryOperation__FeatureAssignment_1 ) )
            {
            // InternalPerl.g:3773:1: ( ( rule__PUnaryOperation__FeatureAssignment_1 ) )
            // InternalPerl.g:3774:2: ( rule__PUnaryOperation__FeatureAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPUnaryOperationAccess().getFeatureAssignment_1()); 
            }
            // InternalPerl.g:3775:2: ( rule__PUnaryOperation__FeatureAssignment_1 )
            // InternalPerl.g:3775:3: rule__PUnaryOperation__FeatureAssignment_1
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
    // InternalPerl.g:3783:1: rule__PUnaryOperation__Group__2 : rule__PUnaryOperation__Group__2__Impl ;
    public final void rule__PUnaryOperation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3787:1: ( rule__PUnaryOperation__Group__2__Impl )
            // InternalPerl.g:3788:2: rule__PUnaryOperation__Group__2__Impl
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
    // InternalPerl.g:3794:1: rule__PUnaryOperation__Group__2__Impl : ( ( rule__PUnaryOperation__OperandAssignment_2 ) ) ;
    public final void rule__PUnaryOperation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3798:1: ( ( ( rule__PUnaryOperation__OperandAssignment_2 ) ) )
            // InternalPerl.g:3799:1: ( ( rule__PUnaryOperation__OperandAssignment_2 ) )
            {
            // InternalPerl.g:3799:1: ( ( rule__PUnaryOperation__OperandAssignment_2 ) )
            // InternalPerl.g:3800:2: ( rule__PUnaryOperation__OperandAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPUnaryOperationAccess().getOperandAssignment_2()); 
            }
            // InternalPerl.g:3801:2: ( rule__PUnaryOperation__OperandAssignment_2 )
            // InternalPerl.g:3801:3: rule__PUnaryOperation__OperandAssignment_2
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


    // $ANTLR start "rule__PMemberFeatureCall__Group__0"
    // InternalPerl.g:3810:1: rule__PMemberFeatureCall__Group__0 : rule__PMemberFeatureCall__Group__0__Impl rule__PMemberFeatureCall__Group__1 ;
    public final void rule__PMemberFeatureCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3814:1: ( rule__PMemberFeatureCall__Group__0__Impl rule__PMemberFeatureCall__Group__1 )
            // InternalPerl.g:3815:2: rule__PMemberFeatureCall__Group__0__Impl rule__PMemberFeatureCall__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__PMemberFeatureCall__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group__1();

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
    // $ANTLR end "rule__PMemberFeatureCall__Group__0"


    // $ANTLR start "rule__PMemberFeatureCall__Group__0__Impl"
    // InternalPerl.g:3822:1: rule__PMemberFeatureCall__Group__0__Impl : ( rulePPrimaryExpression ) ;
    public final void rule__PMemberFeatureCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3826:1: ( ( rulePPrimaryExpression ) )
            // InternalPerl.g:3827:1: ( rulePPrimaryExpression )
            {
            // InternalPerl.g:3827:1: ( rulePPrimaryExpression )
            // InternalPerl.g:3828:2: rulePPrimaryExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getPPrimaryExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePPrimaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getPPrimaryExpressionParserRuleCall_0()); 
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
    // $ANTLR end "rule__PMemberFeatureCall__Group__0__Impl"


    // $ANTLR start "rule__PMemberFeatureCall__Group__1"
    // InternalPerl.g:3837:1: rule__PMemberFeatureCall__Group__1 : rule__PMemberFeatureCall__Group__1__Impl ;
    public final void rule__PMemberFeatureCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3841:1: ( rule__PMemberFeatureCall__Group__1__Impl )
            // InternalPerl.g:3842:2: rule__PMemberFeatureCall__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group__1__Impl();

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
    // $ANTLR end "rule__PMemberFeatureCall__Group__1"


    // $ANTLR start "rule__PMemberFeatureCall__Group__1__Impl"
    // InternalPerl.g:3848:1: rule__PMemberFeatureCall__Group__1__Impl : ( ( rule__PMemberFeatureCall__Group_1__0 ) ) ;
    public final void rule__PMemberFeatureCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3852:1: ( ( ( rule__PMemberFeatureCall__Group_1__0 ) ) )
            // InternalPerl.g:3853:1: ( ( rule__PMemberFeatureCall__Group_1__0 ) )
            {
            // InternalPerl.g:3853:1: ( ( rule__PMemberFeatureCall__Group_1__0 ) )
            // InternalPerl.g:3854:2: ( rule__PMemberFeatureCall__Group_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getGroup_1()); 
            }
            // InternalPerl.g:3855:2: ( rule__PMemberFeatureCall__Group_1__0 )
            // InternalPerl.g:3855:3: rule__PMemberFeatureCall__Group_1__0
            {
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getGroup_1()); 
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
    // $ANTLR end "rule__PMemberFeatureCall__Group__1__Impl"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1__0"
    // InternalPerl.g:3864:1: rule__PMemberFeatureCall__Group_1__0 : rule__PMemberFeatureCall__Group_1__0__Impl rule__PMemberFeatureCall__Group_1__1 ;
    public final void rule__PMemberFeatureCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3868:1: ( rule__PMemberFeatureCall__Group_1__0__Impl rule__PMemberFeatureCall__Group_1__1 )
            // InternalPerl.g:3869:2: rule__PMemberFeatureCall__Group_1__0__Impl rule__PMemberFeatureCall__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__PMemberFeatureCall__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group_1__1();

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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1__0"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1__0__Impl"
    // InternalPerl.g:3876:1: rule__PMemberFeatureCall__Group_1__0__Impl : ( ( rule__PMemberFeatureCall__Group_1_0__0 ) ) ;
    public final void rule__PMemberFeatureCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3880:1: ( ( ( rule__PMemberFeatureCall__Group_1_0__0 ) ) )
            // InternalPerl.g:3881:1: ( ( rule__PMemberFeatureCall__Group_1_0__0 ) )
            {
            // InternalPerl.g:3881:1: ( ( rule__PMemberFeatureCall__Group_1_0__0 ) )
            // InternalPerl.g:3882:2: ( rule__PMemberFeatureCall__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getGroup_1_0()); 
            }
            // InternalPerl.g:3883:2: ( rule__PMemberFeatureCall__Group_1_0__0 )
            // InternalPerl.g:3883:3: rule__PMemberFeatureCall__Group_1_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getGroup_1_0()); 
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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1__0__Impl"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1__1"
    // InternalPerl.g:3891:1: rule__PMemberFeatureCall__Group_1__1 : rule__PMemberFeatureCall__Group_1__1__Impl ;
    public final void rule__PMemberFeatureCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3895:1: ( rule__PMemberFeatureCall__Group_1__1__Impl )
            // InternalPerl.g:3896:2: rule__PMemberFeatureCall__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group_1__1__Impl();

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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1__1"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1__1__Impl"
    // InternalPerl.g:3902:1: rule__PMemberFeatureCall__Group_1__1__Impl : ( ( rule__PMemberFeatureCall__ValueAssignment_1_1 ) ) ;
    public final void rule__PMemberFeatureCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3906:1: ( ( ( rule__PMemberFeatureCall__ValueAssignment_1_1 ) ) )
            // InternalPerl.g:3907:1: ( ( rule__PMemberFeatureCall__ValueAssignment_1_1 ) )
            {
            // InternalPerl.g:3907:1: ( ( rule__PMemberFeatureCall__ValueAssignment_1_1 ) )
            // InternalPerl.g:3908:2: ( rule__PMemberFeatureCall__ValueAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getValueAssignment_1_1()); 
            }
            // InternalPerl.g:3909:2: ( rule__PMemberFeatureCall__ValueAssignment_1_1 )
            // InternalPerl.g:3909:3: rule__PMemberFeatureCall__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__ValueAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getValueAssignment_1_1()); 
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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1__1__Impl"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1_0__0"
    // InternalPerl.g:3918:1: rule__PMemberFeatureCall__Group_1_0__0 : rule__PMemberFeatureCall__Group_1_0__0__Impl ;
    public final void rule__PMemberFeatureCall__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3922:1: ( rule__PMemberFeatureCall__Group_1_0__0__Impl )
            // InternalPerl.g:3923:2: rule__PMemberFeatureCall__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group_1_0__0__Impl();

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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1_0__0"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1_0__0__Impl"
    // InternalPerl.g:3929:1: rule__PMemberFeatureCall__Group_1_0__0__Impl : ( ( rule__PMemberFeatureCall__Group_1_0_0__0 ) ) ;
    public final void rule__PMemberFeatureCall__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3933:1: ( ( ( rule__PMemberFeatureCall__Group_1_0_0__0 ) ) )
            // InternalPerl.g:3934:1: ( ( rule__PMemberFeatureCall__Group_1_0_0__0 ) )
            {
            // InternalPerl.g:3934:1: ( ( rule__PMemberFeatureCall__Group_1_0_0__0 ) )
            // InternalPerl.g:3935:2: ( rule__PMemberFeatureCall__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getGroup_1_0_0()); 
            }
            // InternalPerl.g:3936:2: ( rule__PMemberFeatureCall__Group_1_0_0__0 )
            // InternalPerl.g:3936:3: rule__PMemberFeatureCall__Group_1_0_0__0
            {
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getGroup_1_0_0()); 
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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1_0__0__Impl"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1_0_0__0"
    // InternalPerl.g:3945:1: rule__PMemberFeatureCall__Group_1_0_0__0 : rule__PMemberFeatureCall__Group_1_0_0__0__Impl rule__PMemberFeatureCall__Group_1_0_0__1 ;
    public final void rule__PMemberFeatureCall__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3949:1: ( rule__PMemberFeatureCall__Group_1_0_0__0__Impl rule__PMemberFeatureCall__Group_1_0_0__1 )
            // InternalPerl.g:3950:2: rule__PMemberFeatureCall__Group_1_0_0__0__Impl rule__PMemberFeatureCall__Group_1_0_0__1
            {
            pushFollow(FOLLOW_3);
            rule__PMemberFeatureCall__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group_1_0_0__1();

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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1_0_0__0"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1_0_0__0__Impl"
    // InternalPerl.g:3957:1: rule__PMemberFeatureCall__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__PMemberFeatureCall__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3961:1: ( ( () ) )
            // InternalPerl.g:3962:1: ( () )
            {
            // InternalPerl.g:3962:1: ( () )
            // InternalPerl.g:3963:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getPAssignmentAssignableAction_1_0_0_0()); 
            }
            // InternalPerl.g:3964:2: ()
            // InternalPerl.g:3964:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getPAssignmentAssignableAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PMemberFeatureCall__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1_0_0__1"
    // InternalPerl.g:3972:1: rule__PMemberFeatureCall__Group_1_0_0__1 : rule__PMemberFeatureCall__Group_1_0_0__1__Impl rule__PMemberFeatureCall__Group_1_0_0__2 ;
    public final void rule__PMemberFeatureCall__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3976:1: ( rule__PMemberFeatureCall__Group_1_0_0__1__Impl rule__PMemberFeatureCall__Group_1_0_0__2 )
            // InternalPerl.g:3977:2: rule__PMemberFeatureCall__Group_1_0_0__1__Impl rule__PMemberFeatureCall__Group_1_0_0__2
            {
            pushFollow(FOLLOW_4);
            rule__PMemberFeatureCall__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group_1_0_0__2();

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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1_0_0__1"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1_0_0__1__Impl"
    // InternalPerl.g:3984:1: rule__PMemberFeatureCall__Group_1_0_0__1__Impl : ( ( rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1 ) ) ;
    public final void rule__PMemberFeatureCall__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:3988:1: ( ( ( rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1 ) ) )
            // InternalPerl.g:3989:1: ( ( rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1 ) )
            {
            // InternalPerl.g:3989:1: ( ( rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1 ) )
            // InternalPerl.g:3990:2: ( rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getFeatureAssignment_1_0_0_1()); 
            }
            // InternalPerl.g:3991:2: ( rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1 )
            // InternalPerl.g:3991:3: rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getFeatureAssignment_1_0_0_1()); 
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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1_0_0__2"
    // InternalPerl.g:3999:1: rule__PMemberFeatureCall__Group_1_0_0__2 : rule__PMemberFeatureCall__Group_1_0_0__2__Impl ;
    public final void rule__PMemberFeatureCall__Group_1_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4003:1: ( rule__PMemberFeatureCall__Group_1_0_0__2__Impl )
            // InternalPerl.g:4004:2: rule__PMemberFeatureCall__Group_1_0_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PMemberFeatureCall__Group_1_0_0__2__Impl();

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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1_0_0__2"


    // $ANTLR start "rule__PMemberFeatureCall__Group_1_0_0__2__Impl"
    // InternalPerl.g:4010:1: rule__PMemberFeatureCall__Group_1_0_0__2__Impl : ( ruleOpSingleAssign ) ;
    public final void rule__PMemberFeatureCall__Group_1_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4014:1: ( ( ruleOpSingleAssign ) )
            // InternalPerl.g:4015:1: ( ruleOpSingleAssign )
            {
            // InternalPerl.g:4015:1: ( ruleOpSingleAssign )
            // InternalPerl.g:4016:2: ruleOpSingleAssign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_2()); 
            }
            pushFollow(FOLLOW_2);
            ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_2()); 
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
    // $ANTLR end "rule__PMemberFeatureCall__Group_1_0_0__2__Impl"


    // $ANTLR start "rule__PClosure__Group__0"
    // InternalPerl.g:4026:1: rule__PClosure__Group__0 : rule__PClosure__Group__0__Impl rule__PClosure__Group__1 ;
    public final void rule__PClosure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4030:1: ( rule__PClosure__Group__0__Impl rule__PClosure__Group__1 )
            // InternalPerl.g:4031:2: rule__PClosure__Group__0__Impl rule__PClosure__Group__1
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
    // InternalPerl.g:4038:1: rule__PClosure__Group__0__Impl : ( ( rule__PClosure__Group_0__0 ) ) ;
    public final void rule__PClosure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4042:1: ( ( ( rule__PClosure__Group_0__0 ) ) )
            // InternalPerl.g:4043:1: ( ( rule__PClosure__Group_0__0 ) )
            {
            // InternalPerl.g:4043:1: ( ( rule__PClosure__Group_0__0 ) )
            // InternalPerl.g:4044:2: ( rule__PClosure__Group_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getGroup_0()); 
            }
            // InternalPerl.g:4045:2: ( rule__PClosure__Group_0__0 )
            // InternalPerl.g:4045:3: rule__PClosure__Group_0__0
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
    // InternalPerl.g:4053:1: rule__PClosure__Group__1 : rule__PClosure__Group__1__Impl rule__PClosure__Group__2 ;
    public final void rule__PClosure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4057:1: ( rule__PClosure__Group__1__Impl rule__PClosure__Group__2 )
            // InternalPerl.g:4058:2: rule__PClosure__Group__1__Impl rule__PClosure__Group__2
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
    // InternalPerl.g:4065:1: rule__PClosure__Group__1__Impl : ( ( rule__PClosure__ExpressionAssignment_1 ) ) ;
    public final void rule__PClosure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4069:1: ( ( ( rule__PClosure__ExpressionAssignment_1 ) ) )
            // InternalPerl.g:4070:1: ( ( rule__PClosure__ExpressionAssignment_1 ) )
            {
            // InternalPerl.g:4070:1: ( ( rule__PClosure__ExpressionAssignment_1 ) )
            // InternalPerl.g:4071:2: ( rule__PClosure__ExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getExpressionAssignment_1()); 
            }
            // InternalPerl.g:4072:2: ( rule__PClosure__ExpressionAssignment_1 )
            // InternalPerl.g:4072:3: rule__PClosure__ExpressionAssignment_1
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
    // InternalPerl.g:4080:1: rule__PClosure__Group__2 : rule__PClosure__Group__2__Impl ;
    public final void rule__PClosure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4084:1: ( rule__PClosure__Group__2__Impl )
            // InternalPerl.g:4085:2: rule__PClosure__Group__2__Impl
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
    // InternalPerl.g:4091:1: rule__PClosure__Group__2__Impl : ( '}' ) ;
    public final void rule__PClosure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4095:1: ( ( '}' ) )
            // InternalPerl.g:4096:1: ( '}' )
            {
            // InternalPerl.g:4096:1: ( '}' )
            // InternalPerl.g:4097:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getRightCurlyBracketKeyword_2()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:4107:1: rule__PClosure__Group_0__0 : rule__PClosure__Group_0__0__Impl ;
    public final void rule__PClosure__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4111:1: ( rule__PClosure__Group_0__0__Impl )
            // InternalPerl.g:4112:2: rule__PClosure__Group_0__0__Impl
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
    // InternalPerl.g:4118:1: rule__PClosure__Group_0__0__Impl : ( ( rule__PClosure__Group_0_0__0 ) ) ;
    public final void rule__PClosure__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4122:1: ( ( ( rule__PClosure__Group_0_0__0 ) ) )
            // InternalPerl.g:4123:1: ( ( rule__PClosure__Group_0_0__0 ) )
            {
            // InternalPerl.g:4123:1: ( ( rule__PClosure__Group_0_0__0 ) )
            // InternalPerl.g:4124:2: ( rule__PClosure__Group_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getGroup_0_0()); 
            }
            // InternalPerl.g:4125:2: ( rule__PClosure__Group_0_0__0 )
            // InternalPerl.g:4125:3: rule__PClosure__Group_0_0__0
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
    // InternalPerl.g:4134:1: rule__PClosure__Group_0_0__0 : rule__PClosure__Group_0_0__0__Impl rule__PClosure__Group_0_0__1 ;
    public final void rule__PClosure__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4138:1: ( rule__PClosure__Group_0_0__0__Impl rule__PClosure__Group_0_0__1 )
            // InternalPerl.g:4139:2: rule__PClosure__Group_0_0__0__Impl rule__PClosure__Group_0_0__1
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
    // InternalPerl.g:4146:1: rule__PClosure__Group_0_0__0__Impl : ( () ) ;
    public final void rule__PClosure__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4150:1: ( ( () ) )
            // InternalPerl.g:4151:1: ( () )
            {
            // InternalPerl.g:4151:1: ( () )
            // InternalPerl.g:4152:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getPClosureAction_0_0_0()); 
            }
            // InternalPerl.g:4153:2: ()
            // InternalPerl.g:4153:3: 
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
    // InternalPerl.g:4161:1: rule__PClosure__Group_0_0__1 : rule__PClosure__Group_0_0__1__Impl rule__PClosure__Group_0_0__2 ;
    public final void rule__PClosure__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4165:1: ( rule__PClosure__Group_0_0__1__Impl rule__PClosure__Group_0_0__2 )
            // InternalPerl.g:4166:2: rule__PClosure__Group_0_0__1__Impl rule__PClosure__Group_0_0__2
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
    // InternalPerl.g:4173:1: rule__PClosure__Group_0_0__1__Impl : ( 'sub' ) ;
    public final void rule__PClosure__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4177:1: ( ( 'sub' ) )
            // InternalPerl.g:4178:1: ( 'sub' )
            {
            // InternalPerl.g:4178:1: ( 'sub' )
            // InternalPerl.g:4179:2: 'sub'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getSubKeyword_0_0_1()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:4188:1: rule__PClosure__Group_0_0__2 : rule__PClosure__Group_0_0__2__Impl ;
    public final void rule__PClosure__Group_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4192:1: ( rule__PClosure__Group_0_0__2__Impl )
            // InternalPerl.g:4193:2: rule__PClosure__Group_0_0__2__Impl
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
    // InternalPerl.g:4199:1: rule__PClosure__Group_0_0__2__Impl : ( '{' ) ;
    public final void rule__PClosure__Group_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4203:1: ( ( '{' ) )
            // InternalPerl.g:4204:1: ( '{' )
            {
            // InternalPerl.g:4204:1: ( '{' )
            // InternalPerl.g:4205:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPClosureAccess().getLeftCurlyBracketKeyword_0_0_2()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:4215:1: rule__PExpressionInClosure__Group__0 : rule__PExpressionInClosure__Group__0__Impl rule__PExpressionInClosure__Group__1 ;
    public final void rule__PExpressionInClosure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4219:1: ( rule__PExpressionInClosure__Group__0__Impl rule__PExpressionInClosure__Group__1 )
            // InternalPerl.g:4220:2: rule__PExpressionInClosure__Group__0__Impl rule__PExpressionInClosure__Group__1
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
    // InternalPerl.g:4227:1: rule__PExpressionInClosure__Group__0__Impl : ( () ) ;
    public final void rule__PExpressionInClosure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4231:1: ( ( () ) )
            // InternalPerl.g:4232:1: ( () )
            {
            // InternalPerl.g:4232:1: ( () )
            // InternalPerl.g:4233:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getPBlockExpressionAction_0()); 
            }
            // InternalPerl.g:4234:2: ()
            // InternalPerl.g:4234:3: 
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
    // InternalPerl.g:4242:1: rule__PExpressionInClosure__Group__1 : rule__PExpressionInClosure__Group__1__Impl ;
    public final void rule__PExpressionInClosure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4246:1: ( rule__PExpressionInClosure__Group__1__Impl )
            // InternalPerl.g:4247:2: rule__PExpressionInClosure__Group__1__Impl
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
    // InternalPerl.g:4253:1: rule__PExpressionInClosure__Group__1__Impl : ( ( rule__PExpressionInClosure__Group_1__0 )* ) ;
    public final void rule__PExpressionInClosure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4257:1: ( ( ( rule__PExpressionInClosure__Group_1__0 )* ) )
            // InternalPerl.g:4258:1: ( ( rule__PExpressionInClosure__Group_1__0 )* )
            {
            // InternalPerl.g:4258:1: ( ( rule__PExpressionInClosure__Group_1__0 )* )
            // InternalPerl.g:4259:2: ( rule__PExpressionInClosure__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getGroup_1()); 
            }
            // InternalPerl.g:4260:2: ( rule__PExpressionInClosure__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=34 && LA28_0<=35)||(LA28_0>=39 && LA28_0<=40)||(LA28_0>=43 && LA28_0<=47)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalPerl.g:4260:3: rule__PExpressionInClosure__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__PExpressionInClosure__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalPerl.g:4269:1: rule__PExpressionInClosure__Group_1__0 : rule__PExpressionInClosure__Group_1__0__Impl rule__PExpressionInClosure__Group_1__1 ;
    public final void rule__PExpressionInClosure__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4273:1: ( rule__PExpressionInClosure__Group_1__0__Impl rule__PExpressionInClosure__Group_1__1 )
            // InternalPerl.g:4274:2: rule__PExpressionInClosure__Group_1__0__Impl rule__PExpressionInClosure__Group_1__1
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
    // InternalPerl.g:4281:1: rule__PExpressionInClosure__Group_1__0__Impl : ( ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 ) ) ;
    public final void rule__PExpressionInClosure__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4285:1: ( ( ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 ) ) )
            // InternalPerl.g:4286:1: ( ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 ) )
            {
            // InternalPerl.g:4286:1: ( ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 ) )
            // InternalPerl.g:4287:2: ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getExpressionsAssignment_1_0()); 
            }
            // InternalPerl.g:4288:2: ( rule__PExpressionInClosure__ExpressionsAssignment_1_0 )
            // InternalPerl.g:4288:3: rule__PExpressionInClosure__ExpressionsAssignment_1_0
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
    // InternalPerl.g:4296:1: rule__PExpressionInClosure__Group_1__1 : rule__PExpressionInClosure__Group_1__1__Impl ;
    public final void rule__PExpressionInClosure__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4300:1: ( rule__PExpressionInClosure__Group_1__1__Impl )
            // InternalPerl.g:4301:2: rule__PExpressionInClosure__Group_1__1__Impl
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
    // InternalPerl.g:4307:1: rule__PExpressionInClosure__Group_1__1__Impl : ( ( ';' )? ) ;
    public final void rule__PExpressionInClosure__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4311:1: ( ( ( ';' )? ) )
            // InternalPerl.g:4312:1: ( ( ';' )? )
            {
            // InternalPerl.g:4312:1: ( ( ';' )? )
            // InternalPerl.g:4313:2: ( ';' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPExpressionInClosureAccess().getSemicolonKeyword_1_1()); 
            }
            // InternalPerl.g:4314:2: ( ';' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==51) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalPerl.g:4314:3: ';'
                    {
                    match(input,51,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:4323:1: rule__PParenthesizedExpression__Group__0 : rule__PParenthesizedExpression__Group__0__Impl rule__PParenthesizedExpression__Group__1 ;
    public final void rule__PParenthesizedExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4327:1: ( rule__PParenthesizedExpression__Group__0__Impl rule__PParenthesizedExpression__Group__1 )
            // InternalPerl.g:4328:2: rule__PParenthesizedExpression__Group__0__Impl rule__PParenthesizedExpression__Group__1
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
    // InternalPerl.g:4335:1: rule__PParenthesizedExpression__Group__0__Impl : ( '(' ) ;
    public final void rule__PParenthesizedExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4339:1: ( ( '(' ) )
            // InternalPerl.g:4340:1: ( '(' )
            {
            // InternalPerl.g:4340:1: ( '(' )
            // InternalPerl.g:4341:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:4350:1: rule__PParenthesizedExpression__Group__1 : rule__PParenthesizedExpression__Group__1__Impl rule__PParenthesizedExpression__Group__2 ;
    public final void rule__PParenthesizedExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4354:1: ( rule__PParenthesizedExpression__Group__1__Impl rule__PParenthesizedExpression__Group__2 )
            // InternalPerl.g:4355:2: rule__PParenthesizedExpression__Group__1__Impl rule__PParenthesizedExpression__Group__2
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
    // InternalPerl.g:4362:1: rule__PParenthesizedExpression__Group__1__Impl : ( rulePExpression ) ;
    public final void rule__PParenthesizedExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4366:1: ( ( rulePExpression ) )
            // InternalPerl.g:4367:1: ( rulePExpression )
            {
            // InternalPerl.g:4367:1: ( rulePExpression )
            // InternalPerl.g:4368:2: rulePExpression
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
    // InternalPerl.g:4377:1: rule__PParenthesizedExpression__Group__2 : rule__PParenthesizedExpression__Group__2__Impl ;
    public final void rule__PParenthesizedExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4381:1: ( rule__PParenthesizedExpression__Group__2__Impl )
            // InternalPerl.g:4382:2: rule__PParenthesizedExpression__Group__2__Impl
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
    // InternalPerl.g:4388:1: rule__PParenthesizedExpression__Group__2__Impl : ( ')' ) ;
    public final void rule__PParenthesizedExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4392:1: ( ( ')' ) )
            // InternalPerl.g:4393:1: ( ')' )
            {
            // InternalPerl.g:4393:1: ( ')' )
            // InternalPerl.g:4394:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:4404:1: rule__PIfExpression__Group__0 : rule__PIfExpression__Group__0__Impl rule__PIfExpression__Group__1 ;
    public final void rule__PIfExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4408:1: ( rule__PIfExpression__Group__0__Impl rule__PIfExpression__Group__1 )
            // InternalPerl.g:4409:2: rule__PIfExpression__Group__0__Impl rule__PIfExpression__Group__1
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
    // InternalPerl.g:4416:1: rule__PIfExpression__Group__0__Impl : ( () ) ;
    public final void rule__PIfExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4420:1: ( ( () ) )
            // InternalPerl.g:4421:1: ( () )
            {
            // InternalPerl.g:4421:1: ( () )
            // InternalPerl.g:4422:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getPIfExpressionAction_0()); 
            }
            // InternalPerl.g:4423:2: ()
            // InternalPerl.g:4423:3: 
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
    // InternalPerl.g:4431:1: rule__PIfExpression__Group__1 : rule__PIfExpression__Group__1__Impl rule__PIfExpression__Group__2 ;
    public final void rule__PIfExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4435:1: ( rule__PIfExpression__Group__1__Impl rule__PIfExpression__Group__2 )
            // InternalPerl.g:4436:2: rule__PIfExpression__Group__1__Impl rule__PIfExpression__Group__2
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
    // InternalPerl.g:4443:1: rule__PIfExpression__Group__1__Impl : ( 'if' ) ;
    public final void rule__PIfExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4447:1: ( ( 'if' ) )
            // InternalPerl.g:4448:1: ( 'if' )
            {
            // InternalPerl.g:4448:1: ( 'if' )
            // InternalPerl.g:4449:2: 'if'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getIfKeyword_1()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:4458:1: rule__PIfExpression__Group__2 : rule__PIfExpression__Group__2__Impl rule__PIfExpression__Group__3 ;
    public final void rule__PIfExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4462:1: ( rule__PIfExpression__Group__2__Impl rule__PIfExpression__Group__3 )
            // InternalPerl.g:4463:2: rule__PIfExpression__Group__2__Impl rule__PIfExpression__Group__3
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
    // InternalPerl.g:4470:1: rule__PIfExpression__Group__2__Impl : ( '(' ) ;
    public final void rule__PIfExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4474:1: ( ( '(' ) )
            // InternalPerl.g:4475:1: ( '(' )
            {
            // InternalPerl.g:4475:1: ( '(' )
            // InternalPerl.g:4476:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:4485:1: rule__PIfExpression__Group__3 : rule__PIfExpression__Group__3__Impl rule__PIfExpression__Group__4 ;
    public final void rule__PIfExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4489:1: ( rule__PIfExpression__Group__3__Impl rule__PIfExpression__Group__4 )
            // InternalPerl.g:4490:2: rule__PIfExpression__Group__3__Impl rule__PIfExpression__Group__4
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
    // InternalPerl.g:4497:1: rule__PIfExpression__Group__3__Impl : ( ( rule__PIfExpression__IfAssignment_3 ) ) ;
    public final void rule__PIfExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4501:1: ( ( ( rule__PIfExpression__IfAssignment_3 ) ) )
            // InternalPerl.g:4502:1: ( ( rule__PIfExpression__IfAssignment_3 ) )
            {
            // InternalPerl.g:4502:1: ( ( rule__PIfExpression__IfAssignment_3 ) )
            // InternalPerl.g:4503:2: ( rule__PIfExpression__IfAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getIfAssignment_3()); 
            }
            // InternalPerl.g:4504:2: ( rule__PIfExpression__IfAssignment_3 )
            // InternalPerl.g:4504:3: rule__PIfExpression__IfAssignment_3
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
    // InternalPerl.g:4512:1: rule__PIfExpression__Group__4 : rule__PIfExpression__Group__4__Impl rule__PIfExpression__Group__5 ;
    public final void rule__PIfExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4516:1: ( rule__PIfExpression__Group__4__Impl rule__PIfExpression__Group__5 )
            // InternalPerl.g:4517:2: rule__PIfExpression__Group__4__Impl rule__PIfExpression__Group__5
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
    // InternalPerl.g:4524:1: rule__PIfExpression__Group__4__Impl : ( ')' ) ;
    public final void rule__PIfExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4528:1: ( ( ')' ) )
            // InternalPerl.g:4529:1: ( ')' )
            {
            // InternalPerl.g:4529:1: ( ')' )
            // InternalPerl.g:4530:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:4539:1: rule__PIfExpression__Group__5 : rule__PIfExpression__Group__5__Impl rule__PIfExpression__Group__6 ;
    public final void rule__PIfExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4543:1: ( rule__PIfExpression__Group__5__Impl rule__PIfExpression__Group__6 )
            // InternalPerl.g:4544:2: rule__PIfExpression__Group__5__Impl rule__PIfExpression__Group__6
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
    // InternalPerl.g:4551:1: rule__PIfExpression__Group__5__Impl : ( ( rule__PIfExpression__ThenAssignment_5 ) ) ;
    public final void rule__PIfExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4555:1: ( ( ( rule__PIfExpression__ThenAssignment_5 ) ) )
            // InternalPerl.g:4556:1: ( ( rule__PIfExpression__ThenAssignment_5 ) )
            {
            // InternalPerl.g:4556:1: ( ( rule__PIfExpression__ThenAssignment_5 ) )
            // InternalPerl.g:4557:2: ( rule__PIfExpression__ThenAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getThenAssignment_5()); 
            }
            // InternalPerl.g:4558:2: ( rule__PIfExpression__ThenAssignment_5 )
            // InternalPerl.g:4558:3: rule__PIfExpression__ThenAssignment_5
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
    // InternalPerl.g:4566:1: rule__PIfExpression__Group__6 : rule__PIfExpression__Group__6__Impl ;
    public final void rule__PIfExpression__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4570:1: ( rule__PIfExpression__Group__6__Impl )
            // InternalPerl.g:4571:2: rule__PIfExpression__Group__6__Impl
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
    // InternalPerl.g:4577:1: rule__PIfExpression__Group__6__Impl : ( ( rule__PIfExpression__Group_6__0 )? ) ;
    public final void rule__PIfExpression__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4581:1: ( ( ( rule__PIfExpression__Group_6__0 )? ) )
            // InternalPerl.g:4582:1: ( ( rule__PIfExpression__Group_6__0 )? )
            {
            // InternalPerl.g:4582:1: ( ( rule__PIfExpression__Group_6__0 )? )
            // InternalPerl.g:4583:2: ( rule__PIfExpression__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getGroup_6()); 
            }
            // InternalPerl.g:4584:2: ( rule__PIfExpression__Group_6__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==55) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalPerl.g:4584:3: rule__PIfExpression__Group_6__0
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
    // InternalPerl.g:4593:1: rule__PIfExpression__Group_6__0 : rule__PIfExpression__Group_6__0__Impl rule__PIfExpression__Group_6__1 ;
    public final void rule__PIfExpression__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4597:1: ( rule__PIfExpression__Group_6__0__Impl rule__PIfExpression__Group_6__1 )
            // InternalPerl.g:4598:2: rule__PIfExpression__Group_6__0__Impl rule__PIfExpression__Group_6__1
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
    // InternalPerl.g:4605:1: rule__PIfExpression__Group_6__0__Impl : ( ( 'else' ) ) ;
    public final void rule__PIfExpression__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4609:1: ( ( ( 'else' ) ) )
            // InternalPerl.g:4610:1: ( ( 'else' ) )
            {
            // InternalPerl.g:4610:1: ( ( 'else' ) )
            // InternalPerl.g:4611:2: ( 'else' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getElseKeyword_6_0()); 
            }
            // InternalPerl.g:4612:2: ( 'else' )
            // InternalPerl.g:4612:3: 'else'
            {
            match(input,55,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:4620:1: rule__PIfExpression__Group_6__1 : rule__PIfExpression__Group_6__1__Impl ;
    public final void rule__PIfExpression__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4624:1: ( rule__PIfExpression__Group_6__1__Impl )
            // InternalPerl.g:4625:2: rule__PIfExpression__Group_6__1__Impl
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
    // InternalPerl.g:4631:1: rule__PIfExpression__Group_6__1__Impl : ( ( rule__PIfExpression__ElseAssignment_6_1 ) ) ;
    public final void rule__PIfExpression__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4635:1: ( ( ( rule__PIfExpression__ElseAssignment_6_1 ) ) )
            // InternalPerl.g:4636:1: ( ( rule__PIfExpression__ElseAssignment_6_1 ) )
            {
            // InternalPerl.g:4636:1: ( ( rule__PIfExpression__ElseAssignment_6_1 ) )
            // InternalPerl.g:4637:2: ( rule__PIfExpression__ElseAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPIfExpressionAccess().getElseAssignment_6_1()); 
            }
            // InternalPerl.g:4638:2: ( rule__PIfExpression__ElseAssignment_6_1 )
            // InternalPerl.g:4638:3: rule__PIfExpression__ElseAssignment_6_1
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
    // InternalPerl.g:4647:1: rule__PBlockExpression__Group__0 : rule__PBlockExpression__Group__0__Impl rule__PBlockExpression__Group__1 ;
    public final void rule__PBlockExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4651:1: ( rule__PBlockExpression__Group__0__Impl rule__PBlockExpression__Group__1 )
            // InternalPerl.g:4652:2: rule__PBlockExpression__Group__0__Impl rule__PBlockExpression__Group__1
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
    // InternalPerl.g:4659:1: rule__PBlockExpression__Group__0__Impl : ( () ) ;
    public final void rule__PBlockExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4663:1: ( ( () ) )
            // InternalPerl.g:4664:1: ( () )
            {
            // InternalPerl.g:4664:1: ( () )
            // InternalPerl.g:4665:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getPBlockExpressionAction_0()); 
            }
            // InternalPerl.g:4666:2: ()
            // InternalPerl.g:4666:3: 
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
    // InternalPerl.g:4674:1: rule__PBlockExpression__Group__1 : rule__PBlockExpression__Group__1__Impl rule__PBlockExpression__Group__2 ;
    public final void rule__PBlockExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4678:1: ( rule__PBlockExpression__Group__1__Impl rule__PBlockExpression__Group__2 )
            // InternalPerl.g:4679:2: rule__PBlockExpression__Group__1__Impl rule__PBlockExpression__Group__2
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
    // InternalPerl.g:4686:1: rule__PBlockExpression__Group__1__Impl : ( '{' ) ;
    public final void rule__PBlockExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4690:1: ( ( '{' ) )
            // InternalPerl.g:4691:1: ( '{' )
            {
            // InternalPerl.g:4691:1: ( '{' )
            // InternalPerl.g:4692:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:4701:1: rule__PBlockExpression__Group__2 : rule__PBlockExpression__Group__2__Impl rule__PBlockExpression__Group__3 ;
    public final void rule__PBlockExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4705:1: ( rule__PBlockExpression__Group__2__Impl rule__PBlockExpression__Group__3 )
            // InternalPerl.g:4706:2: rule__PBlockExpression__Group__2__Impl rule__PBlockExpression__Group__3
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
    // InternalPerl.g:4713:1: rule__PBlockExpression__Group__2__Impl : ( ( rule__PBlockExpression__Group_2__0 )* ) ;
    public final void rule__PBlockExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4717:1: ( ( ( rule__PBlockExpression__Group_2__0 )* ) )
            // InternalPerl.g:4718:1: ( ( rule__PBlockExpression__Group_2__0 )* )
            {
            // InternalPerl.g:4718:1: ( ( rule__PBlockExpression__Group_2__0 )* )
            // InternalPerl.g:4719:2: ( rule__PBlockExpression__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getGroup_2()); 
            }
            // InternalPerl.g:4720:2: ( rule__PBlockExpression__Group_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=34 && LA31_0<=35)||(LA31_0>=39 && LA31_0<=40)||(LA31_0>=43 && LA31_0<=47)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalPerl.g:4720:3: rule__PBlockExpression__Group_2__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__PBlockExpression__Group_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalPerl.g:4728:1: rule__PBlockExpression__Group__3 : rule__PBlockExpression__Group__3__Impl ;
    public final void rule__PBlockExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4732:1: ( rule__PBlockExpression__Group__3__Impl )
            // InternalPerl.g:4733:2: rule__PBlockExpression__Group__3__Impl
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
    // InternalPerl.g:4739:1: rule__PBlockExpression__Group__3__Impl : ( '}' ) ;
    public final void rule__PBlockExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4743:1: ( ( '}' ) )
            // InternalPerl.g:4744:1: ( '}' )
            {
            // InternalPerl.g:4744:1: ( '}' )
            // InternalPerl.g:4745:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:4755:1: rule__PBlockExpression__Group_2__0 : rule__PBlockExpression__Group_2__0__Impl rule__PBlockExpression__Group_2__1 ;
    public final void rule__PBlockExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4759:1: ( rule__PBlockExpression__Group_2__0__Impl rule__PBlockExpression__Group_2__1 )
            // InternalPerl.g:4760:2: rule__PBlockExpression__Group_2__0__Impl rule__PBlockExpression__Group_2__1
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
    // InternalPerl.g:4767:1: rule__PBlockExpression__Group_2__0__Impl : ( ( rule__PBlockExpression__ExpressionsAssignment_2_0 ) ) ;
    public final void rule__PBlockExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4771:1: ( ( ( rule__PBlockExpression__ExpressionsAssignment_2_0 ) ) )
            // InternalPerl.g:4772:1: ( ( rule__PBlockExpression__ExpressionsAssignment_2_0 ) )
            {
            // InternalPerl.g:4772:1: ( ( rule__PBlockExpression__ExpressionsAssignment_2_0 ) )
            // InternalPerl.g:4773:2: ( rule__PBlockExpression__ExpressionsAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getExpressionsAssignment_2_0()); 
            }
            // InternalPerl.g:4774:2: ( rule__PBlockExpression__ExpressionsAssignment_2_0 )
            // InternalPerl.g:4774:3: rule__PBlockExpression__ExpressionsAssignment_2_0
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
    // InternalPerl.g:4782:1: rule__PBlockExpression__Group_2__1 : rule__PBlockExpression__Group_2__1__Impl ;
    public final void rule__PBlockExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4786:1: ( rule__PBlockExpression__Group_2__1__Impl )
            // InternalPerl.g:4787:2: rule__PBlockExpression__Group_2__1__Impl
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
    // InternalPerl.g:4793:1: rule__PBlockExpression__Group_2__1__Impl : ( ( ';' )? ) ;
    public final void rule__PBlockExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4797:1: ( ( ( ';' )? ) )
            // InternalPerl.g:4798:1: ( ( ';' )? )
            {
            // InternalPerl.g:4798:1: ( ( ';' )? )
            // InternalPerl.g:4799:2: ( ';' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPBlockExpressionAccess().getSemicolonKeyword_2_1()); 
            }
            // InternalPerl.g:4800:2: ( ';' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==51) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalPerl.g:4800:3: ';'
                    {
                    match(input,51,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:4809:1: rule__PVariableDeclaration__Group__0 : rule__PVariableDeclaration__Group__0__Impl rule__PVariableDeclaration__Group__1 ;
    public final void rule__PVariableDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4813:1: ( rule__PVariableDeclaration__Group__0__Impl rule__PVariableDeclaration__Group__1 )
            // InternalPerl.g:4814:2: rule__PVariableDeclaration__Group__0__Impl rule__PVariableDeclaration__Group__1
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
    // InternalPerl.g:4821:1: rule__PVariableDeclaration__Group__0__Impl : ( () ) ;
    public final void rule__PVariableDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4825:1: ( ( () ) )
            // InternalPerl.g:4826:1: ( () )
            {
            // InternalPerl.g:4826:1: ( () )
            // InternalPerl.g:4827:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getPVariableDeclarationAction_0()); 
            }
            // InternalPerl.g:4828:2: ()
            // InternalPerl.g:4828:3: 
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
    // InternalPerl.g:4836:1: rule__PVariableDeclaration__Group__1 : rule__PVariableDeclaration__Group__1__Impl rule__PVariableDeclaration__Group__2 ;
    public final void rule__PVariableDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4840:1: ( rule__PVariableDeclaration__Group__1__Impl rule__PVariableDeclaration__Group__2 )
            // InternalPerl.g:4841:2: rule__PVariableDeclaration__Group__1__Impl rule__PVariableDeclaration__Group__2
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
    // InternalPerl.g:4848:1: rule__PVariableDeclaration__Group__1__Impl : ( ( rule__PVariableDeclaration__Alternatives_1 ) ) ;
    public final void rule__PVariableDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4852:1: ( ( ( rule__PVariableDeclaration__Alternatives_1 ) ) )
            // InternalPerl.g:4853:1: ( ( rule__PVariableDeclaration__Alternatives_1 ) )
            {
            // InternalPerl.g:4853:1: ( ( rule__PVariableDeclaration__Alternatives_1 ) )
            // InternalPerl.g:4854:2: ( rule__PVariableDeclaration__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getAlternatives_1()); 
            }
            // InternalPerl.g:4855:2: ( rule__PVariableDeclaration__Alternatives_1 )
            // InternalPerl.g:4855:3: rule__PVariableDeclaration__Alternatives_1
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
    // InternalPerl.g:4863:1: rule__PVariableDeclaration__Group__2 : rule__PVariableDeclaration__Group__2__Impl rule__PVariableDeclaration__Group__3 ;
    public final void rule__PVariableDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4867:1: ( rule__PVariableDeclaration__Group__2__Impl rule__PVariableDeclaration__Group__3 )
            // InternalPerl.g:4868:2: rule__PVariableDeclaration__Group__2__Impl rule__PVariableDeclaration__Group__3
            {
            pushFollow(FOLLOW_38);
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
    // InternalPerl.g:4875:1: rule__PVariableDeclaration__Group__2__Impl : ( ( rule__PVariableDeclaration__Alternatives_2 ) ) ;
    public final void rule__PVariableDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4879:1: ( ( ( rule__PVariableDeclaration__Alternatives_2 ) ) )
            // InternalPerl.g:4880:1: ( ( rule__PVariableDeclaration__Alternatives_2 ) )
            {
            // InternalPerl.g:4880:1: ( ( rule__PVariableDeclaration__Alternatives_2 ) )
            // InternalPerl.g:4881:2: ( rule__PVariableDeclaration__Alternatives_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getAlternatives_2()); 
            }
            // InternalPerl.g:4882:2: ( rule__PVariableDeclaration__Alternatives_2 )
            // InternalPerl.g:4882:3: rule__PVariableDeclaration__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Alternatives_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getAlternatives_2()); 
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
    // InternalPerl.g:4890:1: rule__PVariableDeclaration__Group__3 : rule__PVariableDeclaration__Group__3__Impl rule__PVariableDeclaration__Group__4 ;
    public final void rule__PVariableDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4894:1: ( rule__PVariableDeclaration__Group__3__Impl rule__PVariableDeclaration__Group__4 )
            // InternalPerl.g:4895:2: rule__PVariableDeclaration__Group__3__Impl rule__PVariableDeclaration__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__PVariableDeclaration__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group__4();

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
    // InternalPerl.g:4902:1: rule__PVariableDeclaration__Group__3__Impl : ( ( rule__PVariableDeclaration__Group_3__0 ) ) ;
    public final void rule__PVariableDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4906:1: ( ( ( rule__PVariableDeclaration__Group_3__0 ) ) )
            // InternalPerl.g:4907:1: ( ( rule__PVariableDeclaration__Group_3__0 ) )
            {
            // InternalPerl.g:4907:1: ( ( rule__PVariableDeclaration__Group_3__0 ) )
            // InternalPerl.g:4908:2: ( rule__PVariableDeclaration__Group_3__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getGroup_3()); 
            }
            // InternalPerl.g:4909:2: ( rule__PVariableDeclaration__Group_3__0 )
            // InternalPerl.g:4909:3: rule__PVariableDeclaration__Group_3__0
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group_3__0();

            state._fsp--;
            if (state.failed) return ;

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


    // $ANTLR start "rule__PVariableDeclaration__Group__4"
    // InternalPerl.g:4917:1: rule__PVariableDeclaration__Group__4 : rule__PVariableDeclaration__Group__4__Impl ;
    public final void rule__PVariableDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4921:1: ( rule__PVariableDeclaration__Group__4__Impl )
            // InternalPerl.g:4922:2: rule__PVariableDeclaration__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group__4__Impl();

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
    // $ANTLR end "rule__PVariableDeclaration__Group__4"


    // $ANTLR start "rule__PVariableDeclaration__Group__4__Impl"
    // InternalPerl.g:4928:1: rule__PVariableDeclaration__Group__4__Impl : ( ( rule__PVariableDeclaration__Group_4__0 )? ) ;
    public final void rule__PVariableDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4932:1: ( ( ( rule__PVariableDeclaration__Group_4__0 )? ) )
            // InternalPerl.g:4933:1: ( ( rule__PVariableDeclaration__Group_4__0 )? )
            {
            // InternalPerl.g:4933:1: ( ( rule__PVariableDeclaration__Group_4__0 )? )
            // InternalPerl.g:4934:2: ( rule__PVariableDeclaration__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getGroup_4()); 
            }
            // InternalPerl.g:4935:2: ( rule__PVariableDeclaration__Group_4__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==12) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalPerl.g:4935:3: rule__PVariableDeclaration__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PVariableDeclaration__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getGroup_4()); 
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
    // $ANTLR end "rule__PVariableDeclaration__Group__4__Impl"


    // $ANTLR start "rule__PVariableDeclaration__Group_3__0"
    // InternalPerl.g:4944:1: rule__PVariableDeclaration__Group_3__0 : rule__PVariableDeclaration__Group_3__0__Impl ;
    public final void rule__PVariableDeclaration__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4948:1: ( rule__PVariableDeclaration__Group_3__0__Impl )
            // InternalPerl.g:4949:2: rule__PVariableDeclaration__Group_3__0__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group_3__0__Impl();

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
    // InternalPerl.g:4955:1: rule__PVariableDeclaration__Group_3__0__Impl : ( ( rule__PVariableDeclaration__NameAssignment_3_0 ) ) ;
    public final void rule__PVariableDeclaration__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4959:1: ( ( ( rule__PVariableDeclaration__NameAssignment_3_0 ) ) )
            // InternalPerl.g:4960:1: ( ( rule__PVariableDeclaration__NameAssignment_3_0 ) )
            {
            // InternalPerl.g:4960:1: ( ( rule__PVariableDeclaration__NameAssignment_3_0 ) )
            // InternalPerl.g:4961:2: ( rule__PVariableDeclaration__NameAssignment_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getNameAssignment_3_0()); 
            }
            // InternalPerl.g:4962:2: ( rule__PVariableDeclaration__NameAssignment_3_0 )
            // InternalPerl.g:4962:3: rule__PVariableDeclaration__NameAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__NameAssignment_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getNameAssignment_3_0()); 
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


    // $ANTLR start "rule__PVariableDeclaration__Group_4__0"
    // InternalPerl.g:4971:1: rule__PVariableDeclaration__Group_4__0 : rule__PVariableDeclaration__Group_4__0__Impl rule__PVariableDeclaration__Group_4__1 ;
    public final void rule__PVariableDeclaration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4975:1: ( rule__PVariableDeclaration__Group_4__0__Impl rule__PVariableDeclaration__Group_4__1 )
            // InternalPerl.g:4976:2: rule__PVariableDeclaration__Group_4__0__Impl rule__PVariableDeclaration__Group_4__1
            {
            pushFollow(FOLLOW_26);
            rule__PVariableDeclaration__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group_4__1();

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
    // $ANTLR end "rule__PVariableDeclaration__Group_4__0"


    // $ANTLR start "rule__PVariableDeclaration__Group_4__0__Impl"
    // InternalPerl.g:4983:1: rule__PVariableDeclaration__Group_4__0__Impl : ( '=' ) ;
    public final void rule__PVariableDeclaration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:4987:1: ( ( '=' ) )
            // InternalPerl.g:4988:1: ( '=' )
            {
            // InternalPerl.g:4988:1: ( '=' )
            // InternalPerl.g:4989:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getEqualsSignKeyword_4_0()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getEqualsSignKeyword_4_0()); 
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
    // $ANTLR end "rule__PVariableDeclaration__Group_4__0__Impl"


    // $ANTLR start "rule__PVariableDeclaration__Group_4__1"
    // InternalPerl.g:4998:1: rule__PVariableDeclaration__Group_4__1 : rule__PVariableDeclaration__Group_4__1__Impl ;
    public final void rule__PVariableDeclaration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5002:1: ( rule__PVariableDeclaration__Group_4__1__Impl )
            // InternalPerl.g:5003:2: rule__PVariableDeclaration__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__Group_4__1__Impl();

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
    // $ANTLR end "rule__PVariableDeclaration__Group_4__1"


    // $ANTLR start "rule__PVariableDeclaration__Group_4__1__Impl"
    // InternalPerl.g:5009:1: rule__PVariableDeclaration__Group_4__1__Impl : ( ( rule__PVariableDeclaration__RightAssignment_4_1 ) ) ;
    public final void rule__PVariableDeclaration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5013:1: ( ( ( rule__PVariableDeclaration__RightAssignment_4_1 ) ) )
            // InternalPerl.g:5014:1: ( ( rule__PVariableDeclaration__RightAssignment_4_1 ) )
            {
            // InternalPerl.g:5014:1: ( ( rule__PVariableDeclaration__RightAssignment_4_1 ) )
            // InternalPerl.g:5015:2: ( rule__PVariableDeclaration__RightAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getRightAssignment_4_1()); 
            }
            // InternalPerl.g:5016:2: ( rule__PVariableDeclaration__RightAssignment_4_1 )
            // InternalPerl.g:5016:3: rule__PVariableDeclaration__RightAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__PVariableDeclaration__RightAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getRightAssignment_4_1()); 
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
    // $ANTLR end "rule__PVariableDeclaration__Group_4__1__Impl"


    // $ANTLR start "rule__FeatureCallID__Group__0"
    // InternalPerl.g:5025:1: rule__FeatureCallID__Group__0 : rule__FeatureCallID__Group__0__Impl rule__FeatureCallID__Group__1 ;
    public final void rule__FeatureCallID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5029:1: ( rule__FeatureCallID__Group__0__Impl rule__FeatureCallID__Group__1 )
            // InternalPerl.g:5030:2: rule__FeatureCallID__Group__0__Impl rule__FeatureCallID__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__FeatureCallID__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__FeatureCallID__Group__1();

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
    // $ANTLR end "rule__FeatureCallID__Group__0"


    // $ANTLR start "rule__FeatureCallID__Group__0__Impl"
    // InternalPerl.g:5037:1: rule__FeatureCallID__Group__0__Impl : ( ( rule__FeatureCallID__Alternatives_0 ) ) ;
    public final void rule__FeatureCallID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5041:1: ( ( ( rule__FeatureCallID__Alternatives_0 ) ) )
            // InternalPerl.g:5042:1: ( ( rule__FeatureCallID__Alternatives_0 ) )
            {
            // InternalPerl.g:5042:1: ( ( rule__FeatureCallID__Alternatives_0 ) )
            // InternalPerl.g:5043:2: ( rule__FeatureCallID__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallIDAccess().getAlternatives_0()); 
            }
            // InternalPerl.g:5044:2: ( rule__FeatureCallID__Alternatives_0 )
            // InternalPerl.g:5044:3: rule__FeatureCallID__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__FeatureCallID__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallIDAccess().getAlternatives_0()); 
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
    // $ANTLR end "rule__FeatureCallID__Group__0__Impl"


    // $ANTLR start "rule__FeatureCallID__Group__1"
    // InternalPerl.g:5052:1: rule__FeatureCallID__Group__1 : rule__FeatureCallID__Group__1__Impl ;
    public final void rule__FeatureCallID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5056:1: ( rule__FeatureCallID__Group__1__Impl )
            // InternalPerl.g:5057:2: rule__FeatureCallID__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FeatureCallID__Group__1__Impl();

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
    // $ANTLR end "rule__FeatureCallID__Group__1"


    // $ANTLR start "rule__FeatureCallID__Group__1__Impl"
    // InternalPerl.g:5063:1: rule__FeatureCallID__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__FeatureCallID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5067:1: ( ( RULE_ID ) )
            // InternalPerl.g:5068:1: ( RULE_ID )
            {
            // InternalPerl.g:5068:1: ( RULE_ID )
            // InternalPerl.g:5069:2: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureCallIDAccess().getIDTerminalRuleCall_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureCallIDAccess().getIDTerminalRuleCall_1()); 
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
    // $ANTLR end "rule__FeatureCallID__Group__1__Impl"


    // $ANTLR start "rule__PNumberLiteral__Group__0"
    // InternalPerl.g:5079:1: rule__PNumberLiteral__Group__0 : rule__PNumberLiteral__Group__0__Impl rule__PNumberLiteral__Group__1 ;
    public final void rule__PNumberLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5083:1: ( rule__PNumberLiteral__Group__0__Impl rule__PNumberLiteral__Group__1 )
            // InternalPerl.g:5084:2: rule__PNumberLiteral__Group__0__Impl rule__PNumberLiteral__Group__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalPerl.g:5091:1: rule__PNumberLiteral__Group__0__Impl : ( () ) ;
    public final void rule__PNumberLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5095:1: ( ( () ) )
            // InternalPerl.g:5096:1: ( () )
            {
            // InternalPerl.g:5096:1: ( () )
            // InternalPerl.g:5097:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNumberLiteralAccess().getPNumberLiteralAction_0()); 
            }
            // InternalPerl.g:5098:2: ()
            // InternalPerl.g:5098:3: 
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
    // InternalPerl.g:5106:1: rule__PNumberLiteral__Group__1 : rule__PNumberLiteral__Group__1__Impl ;
    public final void rule__PNumberLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5110:1: ( rule__PNumberLiteral__Group__1__Impl )
            // InternalPerl.g:5111:2: rule__PNumberLiteral__Group__1__Impl
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
    // InternalPerl.g:5117:1: rule__PNumberLiteral__Group__1__Impl : ( ( rule__PNumberLiteral__ValueAssignment_1 ) ) ;
    public final void rule__PNumberLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5121:1: ( ( ( rule__PNumberLiteral__ValueAssignment_1 ) ) )
            // InternalPerl.g:5122:1: ( ( rule__PNumberLiteral__ValueAssignment_1 ) )
            {
            // InternalPerl.g:5122:1: ( ( rule__PNumberLiteral__ValueAssignment_1 ) )
            // InternalPerl.g:5123:2: ( rule__PNumberLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNumberLiteralAccess().getValueAssignment_1()); 
            }
            // InternalPerl.g:5124:2: ( rule__PNumberLiteral__ValueAssignment_1 )
            // InternalPerl.g:5124:3: rule__PNumberLiteral__ValueAssignment_1
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
    // InternalPerl.g:5133:1: rule__PNullLiteral__Group__0 : rule__PNullLiteral__Group__0__Impl rule__PNullLiteral__Group__1 ;
    public final void rule__PNullLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5137:1: ( rule__PNullLiteral__Group__0__Impl rule__PNullLiteral__Group__1 )
            // InternalPerl.g:5138:2: rule__PNullLiteral__Group__0__Impl rule__PNullLiteral__Group__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalPerl.g:5145:1: rule__PNullLiteral__Group__0__Impl : ( () ) ;
    public final void rule__PNullLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5149:1: ( ( () ) )
            // InternalPerl.g:5150:1: ( () )
            {
            // InternalPerl.g:5150:1: ( () )
            // InternalPerl.g:5151:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNullLiteralAccess().getPNullLiteralAction_0()); 
            }
            // InternalPerl.g:5152:2: ()
            // InternalPerl.g:5152:3: 
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
    // InternalPerl.g:5160:1: rule__PNullLiteral__Group__1 : rule__PNullLiteral__Group__1__Impl ;
    public final void rule__PNullLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5164:1: ( rule__PNullLiteral__Group__1__Impl )
            // InternalPerl.g:5165:2: rule__PNullLiteral__Group__1__Impl
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
    // InternalPerl.g:5171:1: rule__PNullLiteral__Group__1__Impl : ( 'undef' ) ;
    public final void rule__PNullLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5175:1: ( ( 'undef' ) )
            // InternalPerl.g:5176:1: ( 'undef' )
            {
            // InternalPerl.g:5176:1: ( 'undef' )
            // InternalPerl.g:5177:2: 'undef'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPNullLiteralAccess().getUndefKeyword_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:5187:1: rule__PReturnExpression__Group__0 : rule__PReturnExpression__Group__0__Impl rule__PReturnExpression__Group__1 ;
    public final void rule__PReturnExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5191:1: ( rule__PReturnExpression__Group__0__Impl rule__PReturnExpression__Group__1 )
            // InternalPerl.g:5192:2: rule__PReturnExpression__Group__0__Impl rule__PReturnExpression__Group__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalPerl.g:5199:1: rule__PReturnExpression__Group__0__Impl : ( () ) ;
    public final void rule__PReturnExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5203:1: ( ( () ) )
            // InternalPerl.g:5204:1: ( () )
            {
            // InternalPerl.g:5204:1: ( () )
            // InternalPerl.g:5205:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPReturnExpressionAccess().getPReturnExpressionAction_0()); 
            }
            // InternalPerl.g:5206:2: ()
            // InternalPerl.g:5206:3: 
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
    // InternalPerl.g:5214:1: rule__PReturnExpression__Group__1 : rule__PReturnExpression__Group__1__Impl rule__PReturnExpression__Group__2 ;
    public final void rule__PReturnExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5218:1: ( rule__PReturnExpression__Group__1__Impl rule__PReturnExpression__Group__2 )
            // InternalPerl.g:5219:2: rule__PReturnExpression__Group__1__Impl rule__PReturnExpression__Group__2
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
    // InternalPerl.g:5226:1: rule__PReturnExpression__Group__1__Impl : ( 'return' ) ;
    public final void rule__PReturnExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5230:1: ( ( 'return' ) )
            // InternalPerl.g:5231:1: ( 'return' )
            {
            // InternalPerl.g:5231:1: ( 'return' )
            // InternalPerl.g:5232:2: 'return'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPReturnExpressionAccess().getReturnKeyword_1()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalPerl.g:5241:1: rule__PReturnExpression__Group__2 : rule__PReturnExpression__Group__2__Impl ;
    public final void rule__PReturnExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5245:1: ( rule__PReturnExpression__Group__2__Impl )
            // InternalPerl.g:5246:2: rule__PReturnExpression__Group__2__Impl
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
    // InternalPerl.g:5252:1: rule__PReturnExpression__Group__2__Impl : ( ( rule__PReturnExpression__ExpressionAssignment_2 )? ) ;
    public final void rule__PReturnExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5256:1: ( ( ( rule__PReturnExpression__ExpressionAssignment_2 )? ) )
            // InternalPerl.g:5257:1: ( ( rule__PReturnExpression__ExpressionAssignment_2 )? )
            {
            // InternalPerl.g:5257:1: ( ( rule__PReturnExpression__ExpressionAssignment_2 )? )
            // InternalPerl.g:5258:2: ( rule__PReturnExpression__ExpressionAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPReturnExpressionAccess().getExpressionAssignment_2()); 
            }
            // InternalPerl.g:5259:2: ( rule__PReturnExpression__ExpressionAssignment_2 )?
            int alt34=2;
            switch ( input.LA(1) ) {
                case 46:
                    {
                    int LA34_1 = input.LA(2);

                    if ( (synpred64_InternalPerl()) ) {
                        alt34=1;
                    }
                    }
                    break;
                case 39:
                    {
                    int LA34_2 = input.LA(2);

                    if ( (synpred64_InternalPerl()) ) {
                        alt34=1;
                    }
                    }
                    break;
                case 47:
                    {
                    int LA34_3 = input.LA(2);

                    if ( (synpred64_InternalPerl()) ) {
                        alt34=1;
                    }
                    }
                    break;
                case 34:
                case 35:
                case 40:
                    {
                    alt34=1;
                    }
                    break;
            }

            switch (alt34) {
                case 1 :
                    // InternalPerl.g:5259:3: rule__PReturnExpression__ExpressionAssignment_2
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
    // InternalPerl.g:5268:1: rule__PStringLiteral__Group__0 : rule__PStringLiteral__Group__0__Impl rule__PStringLiteral__Group__1 ;
    public final void rule__PStringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5272:1: ( rule__PStringLiteral__Group__0__Impl rule__PStringLiteral__Group__1 )
            // InternalPerl.g:5273:2: rule__PStringLiteral__Group__0__Impl rule__PStringLiteral__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalPerl.g:5280:1: rule__PStringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__PStringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5284:1: ( ( () ) )
            // InternalPerl.g:5285:1: ( () )
            {
            // InternalPerl.g:5285:1: ( () )
            // InternalPerl.g:5286:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPStringLiteralAccess().getPStringLiteralAction_0()); 
            }
            // InternalPerl.g:5287:2: ()
            // InternalPerl.g:5287:3: 
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
    // InternalPerl.g:5295:1: rule__PStringLiteral__Group__1 : rule__PStringLiteral__Group__1__Impl ;
    public final void rule__PStringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5299:1: ( rule__PStringLiteral__Group__1__Impl )
            // InternalPerl.g:5300:2: rule__PStringLiteral__Group__1__Impl
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
    // InternalPerl.g:5306:1: rule__PStringLiteral__Group__1__Impl : ( ( rule__PStringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__PStringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5310:1: ( ( ( rule__PStringLiteral__ValueAssignment_1 ) ) )
            // InternalPerl.g:5311:1: ( ( rule__PStringLiteral__ValueAssignment_1 ) )
            {
            // InternalPerl.g:5311:1: ( ( rule__PStringLiteral__ValueAssignment_1 ) )
            // InternalPerl.g:5312:2: ( rule__PStringLiteral__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPStringLiteralAccess().getValueAssignment_1()); 
            }
            // InternalPerl.g:5313:2: ( rule__PStringLiteral__ValueAssignment_1 )
            // InternalPerl.g:5313:3: rule__PStringLiteral__ValueAssignment_1
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
    // InternalPerl.g:5322:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5326:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalPerl.g:5327:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalPerl.g:5334:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5338:1: ( ( RULE_ID ) )
            // InternalPerl.g:5339:1: ( RULE_ID )
            {
            // InternalPerl.g:5339:1: ( RULE_ID )
            // InternalPerl.g:5340:2: RULE_ID
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
    // InternalPerl.g:5349:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5353:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalPerl.g:5354:2: rule__QualifiedName__Group__1__Impl
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
    // InternalPerl.g:5360:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5364:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalPerl.g:5365:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalPerl.g:5365:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalPerl.g:5366:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalPerl.g:5367:2: ( rule__QualifiedName__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==58) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalPerl.g:5367:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_44);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalPerl.g:5376:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5380:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalPerl.g:5381:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalPerl.g:5388:1: rule__QualifiedName__Group_1__0__Impl : ( ( '::' ) ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5392:1: ( ( ( '::' ) ) )
            // InternalPerl.g:5393:1: ( ( '::' ) )
            {
            // InternalPerl.g:5393:1: ( ( '::' ) )
            // InternalPerl.g:5394:2: ( '::' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0()); 
            }
            // InternalPerl.g:5395:2: ( '::' )
            // InternalPerl.g:5395:3: '::'
            {
            match(input,58,FOLLOW_2); if (state.failed) return ;

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
    // InternalPerl.g:5403:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5407:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalPerl.g:5408:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalPerl.g:5414:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5418:1: ( ( RULE_ID ) )
            // InternalPerl.g:5419:1: ( RULE_ID )
            {
            // InternalPerl.g:5419:1: ( RULE_ID )
            // InternalPerl.g:5420:2: RULE_ID
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


    // $ANTLR start "rule__PAssignment__FeatureAssignment_0_1"
    // InternalPerl.g:5430:1: rule__PAssignment__FeatureAssignment_0_1 : ( ruleFeatureCallID ) ;
    public final void rule__PAssignment__FeatureAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5434:1: ( ( ruleFeatureCallID ) )
            // InternalPerl.g:5435:2: ( ruleFeatureCallID )
            {
            // InternalPerl.g:5435:2: ( ruleFeatureCallID )
            // InternalPerl.g:5436:3: ruleFeatureCallID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPAssignmentAccess().getFeatureFeatureCallIDParserRuleCall_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPAssignmentAccess().getFeatureFeatureCallIDParserRuleCall_0_1_0()); 
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
    // $ANTLR end "rule__PAssignment__FeatureAssignment_0_1"


    // $ANTLR start "rule__PAssignment__ValueAssignment_0_3"
    // InternalPerl.g:5445:1: rule__PAssignment__ValueAssignment_0_3 : ( rulePAssignment ) ;
    public final void rule__PAssignment__ValueAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5449:1: ( ( rulePAssignment ) )
            // InternalPerl.g:5450:2: ( rulePAssignment )
            {
            // InternalPerl.g:5450:2: ( rulePAssignment )
            // InternalPerl.g:5451:3: rulePAssignment
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
    // InternalPerl.g:5460:1: rule__PAssignment__FeatureAssignment_1_1_0_0_1 : ( ruleOpMultiAssign ) ;
    public final void rule__PAssignment__FeatureAssignment_1_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5464:1: ( ( ruleOpMultiAssign ) )
            // InternalPerl.g:5465:2: ( ruleOpMultiAssign )
            {
            // InternalPerl.g:5465:2: ( ruleOpMultiAssign )
            // InternalPerl.g:5466:3: ruleOpMultiAssign
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
    // InternalPerl.g:5475:1: rule__PAssignment__RightOperandAssignment_1_1_1 : ( rulePAssignment ) ;
    public final void rule__PAssignment__RightOperandAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5479:1: ( ( rulePAssignment ) )
            // InternalPerl.g:5480:2: ( rulePAssignment )
            {
            // InternalPerl.g:5480:2: ( rulePAssignment )
            // InternalPerl.g:5481:3: rulePAssignment
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
    // InternalPerl.g:5490:1: rule__POrExpression__FeatureAssignment_1_0_0_1 : ( ruleOpOr ) ;
    public final void rule__POrExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5494:1: ( ( ruleOpOr ) )
            // InternalPerl.g:5495:2: ( ruleOpOr )
            {
            // InternalPerl.g:5495:2: ( ruleOpOr )
            // InternalPerl.g:5496:3: ruleOpOr
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
    // InternalPerl.g:5505:1: rule__POrExpression__RightOperandAssignment_1_1 : ( rulePAndExpression ) ;
    public final void rule__POrExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5509:1: ( ( rulePAndExpression ) )
            // InternalPerl.g:5510:2: ( rulePAndExpression )
            {
            // InternalPerl.g:5510:2: ( rulePAndExpression )
            // InternalPerl.g:5511:3: rulePAndExpression
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
    // InternalPerl.g:5520:1: rule__PAndExpression__FeatureAssignment_1_0_0_1 : ( ruleOpAnd ) ;
    public final void rule__PAndExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5524:1: ( ( ruleOpAnd ) )
            // InternalPerl.g:5525:2: ( ruleOpAnd )
            {
            // InternalPerl.g:5525:2: ( ruleOpAnd )
            // InternalPerl.g:5526:3: ruleOpAnd
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
    // InternalPerl.g:5535:1: rule__PAndExpression__RightOperandAssignment_1_1 : ( rulePEqualityExpression ) ;
    public final void rule__PAndExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5539:1: ( ( rulePEqualityExpression ) )
            // InternalPerl.g:5540:2: ( rulePEqualityExpression )
            {
            // InternalPerl.g:5540:2: ( rulePEqualityExpression )
            // InternalPerl.g:5541:3: rulePEqualityExpression
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
    // InternalPerl.g:5550:1: rule__PEqualityExpression__FeatureAssignment_1_0_0_1 : ( ruleOpEquality ) ;
    public final void rule__PEqualityExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5554:1: ( ( ruleOpEquality ) )
            // InternalPerl.g:5555:2: ( ruleOpEquality )
            {
            // InternalPerl.g:5555:2: ( ruleOpEquality )
            // InternalPerl.g:5556:3: ruleOpEquality
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
    // InternalPerl.g:5565:1: rule__PEqualityExpression__RightOperandAssignment_1_1 : ( rulePRelationalExpression ) ;
    public final void rule__PEqualityExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5569:1: ( ( rulePRelationalExpression ) )
            // InternalPerl.g:5570:2: ( rulePRelationalExpression )
            {
            // InternalPerl.g:5570:2: ( rulePRelationalExpression )
            // InternalPerl.g:5571:3: rulePRelationalExpression
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
    // InternalPerl.g:5580:1: rule__PRelationalExpression__FeatureAssignment_1_0_0_1 : ( ruleOpCompare ) ;
    public final void rule__PRelationalExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5584:1: ( ( ruleOpCompare ) )
            // InternalPerl.g:5585:2: ( ruleOpCompare )
            {
            // InternalPerl.g:5585:2: ( ruleOpCompare )
            // InternalPerl.g:5586:3: ruleOpCompare
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
    // InternalPerl.g:5595:1: rule__PRelationalExpression__RightOperandAssignment_1_1 : ( rulePOtherOperatorExpression ) ;
    public final void rule__PRelationalExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5599:1: ( ( rulePOtherOperatorExpression ) )
            // InternalPerl.g:5600:2: ( rulePOtherOperatorExpression )
            {
            // InternalPerl.g:5600:2: ( rulePOtherOperatorExpression )
            // InternalPerl.g:5601:3: rulePOtherOperatorExpression
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
    // InternalPerl.g:5610:1: rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1 : ( ruleOpOther ) ;
    public final void rule__POtherOperatorExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5614:1: ( ( ruleOpOther ) )
            // InternalPerl.g:5615:2: ( ruleOpOther )
            {
            // InternalPerl.g:5615:2: ( ruleOpOther )
            // InternalPerl.g:5616:3: ruleOpOther
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
    // InternalPerl.g:5625:1: rule__POtherOperatorExpression__RightOperandAssignment_1_1 : ( rulePAdditiveExpression ) ;
    public final void rule__POtherOperatorExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5629:1: ( ( rulePAdditiveExpression ) )
            // InternalPerl.g:5630:2: ( rulePAdditiveExpression )
            {
            // InternalPerl.g:5630:2: ( rulePAdditiveExpression )
            // InternalPerl.g:5631:3: rulePAdditiveExpression
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
    // InternalPerl.g:5640:1: rule__PAdditiveExpression__FeatureAssignment_1_0_0_1 : ( ruleOpAdd ) ;
    public final void rule__PAdditiveExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5644:1: ( ( ruleOpAdd ) )
            // InternalPerl.g:5645:2: ( ruleOpAdd )
            {
            // InternalPerl.g:5645:2: ( ruleOpAdd )
            // InternalPerl.g:5646:3: ruleOpAdd
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
    // InternalPerl.g:5655:1: rule__PAdditiveExpression__RightOperandAssignment_1_1 : ( rulePMultiplicativeExpression ) ;
    public final void rule__PAdditiveExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5659:1: ( ( rulePMultiplicativeExpression ) )
            // InternalPerl.g:5660:2: ( rulePMultiplicativeExpression )
            {
            // InternalPerl.g:5660:2: ( rulePMultiplicativeExpression )
            // InternalPerl.g:5661:3: rulePMultiplicativeExpression
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
    // InternalPerl.g:5670:1: rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1 : ( ruleOpMulti ) ;
    public final void rule__PMultiplicativeExpression__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5674:1: ( ( ruleOpMulti ) )
            // InternalPerl.g:5675:2: ( ruleOpMulti )
            {
            // InternalPerl.g:5675:2: ( ruleOpMulti )
            // InternalPerl.g:5676:3: ruleOpMulti
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
    // InternalPerl.g:5685:1: rule__PMultiplicativeExpression__RightOperandAssignment_1_1 : ( rulePUnaryOperation ) ;
    public final void rule__PMultiplicativeExpression__RightOperandAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5689:1: ( ( rulePUnaryOperation ) )
            // InternalPerl.g:5690:2: ( rulePUnaryOperation )
            {
            // InternalPerl.g:5690:2: ( rulePUnaryOperation )
            // InternalPerl.g:5691:3: rulePUnaryOperation
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
    // InternalPerl.g:5700:1: rule__PUnaryOperation__FeatureAssignment_1 : ( ruleOpUnary ) ;
    public final void rule__PUnaryOperation__FeatureAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5704:1: ( ( ruleOpUnary ) )
            // InternalPerl.g:5705:2: ( ruleOpUnary )
            {
            // InternalPerl.g:5705:2: ( ruleOpUnary )
            // InternalPerl.g:5706:3: ruleOpUnary
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
    // InternalPerl.g:5715:1: rule__PUnaryOperation__OperandAssignment_2 : ( rulePUnaryOperation ) ;
    public final void rule__PUnaryOperation__OperandAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5719:1: ( ( rulePUnaryOperation ) )
            // InternalPerl.g:5720:2: ( rulePUnaryOperation )
            {
            // InternalPerl.g:5720:2: ( rulePUnaryOperation )
            // InternalPerl.g:5721:3: rulePUnaryOperation
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


    // $ANTLR start "rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1"
    // InternalPerl.g:5730:1: rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1 : ( ruleFeatureCallID ) ;
    public final void rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5734:1: ( ( ruleFeatureCallID ) )
            // InternalPerl.g:5735:2: ( ruleFeatureCallID )
            {
            // InternalPerl.g:5735:2: ( ruleFeatureCallID )
            // InternalPerl.g:5736:3: ruleFeatureCallID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getFeatureFeatureCallIDParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getFeatureFeatureCallIDParserRuleCall_1_0_0_1_0()); 
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
    // $ANTLR end "rule__PMemberFeatureCall__FeatureAssignment_1_0_0_1"


    // $ANTLR start "rule__PMemberFeatureCall__ValueAssignment_1_1"
    // InternalPerl.g:5745:1: rule__PMemberFeatureCall__ValueAssignment_1_1 : ( rulePAssignment ) ;
    public final void rule__PMemberFeatureCall__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5749:1: ( ( rulePAssignment ) )
            // InternalPerl.g:5750:2: ( rulePAssignment )
            {
            // InternalPerl.g:5750:2: ( rulePAssignment )
            // InternalPerl.g:5751:3: rulePAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPMemberFeatureCallAccess().getValuePAssignmentParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPMemberFeatureCallAccess().getValuePAssignmentParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__PMemberFeatureCall__ValueAssignment_1_1"


    // $ANTLR start "rule__PClosure__ExpressionAssignment_1"
    // InternalPerl.g:5760:1: rule__PClosure__ExpressionAssignment_1 : ( rulePExpressionInClosure ) ;
    public final void rule__PClosure__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5764:1: ( ( rulePExpressionInClosure ) )
            // InternalPerl.g:5765:2: ( rulePExpressionInClosure )
            {
            // InternalPerl.g:5765:2: ( rulePExpressionInClosure )
            // InternalPerl.g:5766:3: rulePExpressionInClosure
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
    // InternalPerl.g:5775:1: rule__PExpressionInClosure__ExpressionsAssignment_1_0 : ( rulePExpressionOrVarDeclaration ) ;
    public final void rule__PExpressionInClosure__ExpressionsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5779:1: ( ( rulePExpressionOrVarDeclaration ) )
            // InternalPerl.g:5780:2: ( rulePExpressionOrVarDeclaration )
            {
            // InternalPerl.g:5780:2: ( rulePExpressionOrVarDeclaration )
            // InternalPerl.g:5781:3: rulePExpressionOrVarDeclaration
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
    // InternalPerl.g:5790:1: rule__PIfExpression__IfAssignment_3 : ( rulePExpression ) ;
    public final void rule__PIfExpression__IfAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5794:1: ( ( rulePExpression ) )
            // InternalPerl.g:5795:2: ( rulePExpression )
            {
            // InternalPerl.g:5795:2: ( rulePExpression )
            // InternalPerl.g:5796:3: rulePExpression
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
    // InternalPerl.g:5805:1: rule__PIfExpression__ThenAssignment_5 : ( rulePExpression ) ;
    public final void rule__PIfExpression__ThenAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5809:1: ( ( rulePExpression ) )
            // InternalPerl.g:5810:2: ( rulePExpression )
            {
            // InternalPerl.g:5810:2: ( rulePExpression )
            // InternalPerl.g:5811:3: rulePExpression
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
    // InternalPerl.g:5820:1: rule__PIfExpression__ElseAssignment_6_1 : ( rulePExpression ) ;
    public final void rule__PIfExpression__ElseAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5824:1: ( ( rulePExpression ) )
            // InternalPerl.g:5825:2: ( rulePExpression )
            {
            // InternalPerl.g:5825:2: ( rulePExpression )
            // InternalPerl.g:5826:3: rulePExpression
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
    // InternalPerl.g:5835:1: rule__PBlockExpression__ExpressionsAssignment_2_0 : ( rulePExpressionOrVarDeclaration ) ;
    public final void rule__PBlockExpression__ExpressionsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5839:1: ( ( rulePExpressionOrVarDeclaration ) )
            // InternalPerl.g:5840:2: ( rulePExpressionOrVarDeclaration )
            {
            // InternalPerl.g:5840:2: ( rulePExpressionOrVarDeclaration )
            // InternalPerl.g:5841:3: rulePExpressionOrVarDeclaration
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


    // $ANTLR start "rule__PVariableDeclaration__NameAssignment_3_0"
    // InternalPerl.g:5850:1: rule__PVariableDeclaration__NameAssignment_3_0 : ( RULE_ID ) ;
    public final void rule__PVariableDeclaration__NameAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5854:1: ( ( RULE_ID ) )
            // InternalPerl.g:5855:2: ( RULE_ID )
            {
            // InternalPerl.g:5855:2: ( RULE_ID )
            // InternalPerl.g:5856:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getNameIDTerminalRuleCall_3_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getNameIDTerminalRuleCall_3_0_0()); 
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
    // $ANTLR end "rule__PVariableDeclaration__NameAssignment_3_0"


    // $ANTLR start "rule__PVariableDeclaration__RightAssignment_4_1"
    // InternalPerl.g:5865:1: rule__PVariableDeclaration__RightAssignment_4_1 : ( rulePExpression ) ;
    public final void rule__PVariableDeclaration__RightAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5869:1: ( ( rulePExpression ) )
            // InternalPerl.g:5870:2: ( rulePExpression )
            {
            // InternalPerl.g:5870:2: ( rulePExpression )
            // InternalPerl.g:5871:3: rulePExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPVariableDeclarationAccess().getRightPExpressionParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPVariableDeclarationAccess().getRightPExpressionParserRuleCall_4_1_0()); 
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
    // $ANTLR end "rule__PVariableDeclaration__RightAssignment_4_1"


    // $ANTLR start "rule__PNumberLiteral__ValueAssignment_1"
    // InternalPerl.g:5880:1: rule__PNumberLiteral__ValueAssignment_1 : ( ruleNumber ) ;
    public final void rule__PNumberLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5884:1: ( ( ruleNumber ) )
            // InternalPerl.g:5885:2: ( ruleNumber )
            {
            // InternalPerl.g:5885:2: ( ruleNumber )
            // InternalPerl.g:5886:3: ruleNumber
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
    // InternalPerl.g:5895:1: rule__PReturnExpression__ExpressionAssignment_2 : ( rulePExpression ) ;
    public final void rule__PReturnExpression__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5899:1: ( ( rulePExpression ) )
            // InternalPerl.g:5900:2: ( rulePExpression )
            {
            // InternalPerl.g:5900:2: ( rulePExpression )
            // InternalPerl.g:5901:3: rulePExpression
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
    // InternalPerl.g:5910:1: rule__PStringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__PStringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPerl.g:5914:1: ( ( RULE_STRING ) )
            // InternalPerl.g:5915:2: ( RULE_STRING )
            {
            // InternalPerl.g:5915:2: ( RULE_STRING )
            // InternalPerl.g:5916:3: RULE_STRING
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

    // $ANTLR start synpred56_InternalPerl
    public final void synpred56_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:3396:3: ( rule__PAdditiveExpression__Group_1__0 )
        // InternalPerl.g:3396:3: rule__PAdditiveExpression__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__PAdditiveExpression__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_InternalPerl

    // $ANTLR start synpred64_InternalPerl
    public final void synpred64_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:5259:3: ( rule__PReturnExpression__ExpressionAssignment_2 )
        // InternalPerl.g:5259:3: rule__PReturnExpression__ExpressionAssignment_2
        {
        pushFollow(FOLLOW_2);
        rule__PReturnExpression__ExpressionAssignment_2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_InternalPerl

    // Delegated rules

    public final boolean synpred56_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA26 dfa26 = new DFA26(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\32\2\uffff\1\32\7\uffff";
    static final String dfa_3s = "\1\41\2\uffff\1\36\7\uffff";
    static final String dfa_4s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\3\1\6";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\3\1\6\1\1\1\2\1\4\1\5\1\7\1\10",
            "",
            "",
            "\1\12\3\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1155:1: rule__OpOther__Alternatives : ( ( '->' ) | ( '..<' ) | ( ( rule__OpOther__Group_2__0 ) ) | ( '..' ) | ( '=>' ) | ( ( rule__OpOther__Group_5__0 ) ) | ( ( rule__OpOther__Group_6__0 ) ) | ( '<>' ) | ( '?:' ) );";
        }
    }
    static final String dfa_7s = "\45\uffff";
    static final String dfa_8s = "\1\1\44\uffff";
    static final String dfa_9s = "\1\15\37\uffff\2\0\3\uffff";
    static final String dfa_10s = "\1\67\37\uffff\2\0\3\uffff";
    static final String dfa_11s = "\1\uffff\1\2\42\uffff\1\1";
    static final String dfa_12s = "\40\uffff\1\0\1\1\3\uffff}>";
    static final String[] dfa_13s = {
            "\25\1\1\41\1\40\3\uffff\2\1\2\uffff\6\1\2\uffff\1\1\1\uffff\1\1\1\uffff\1\1",
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
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 3396:2: ( rule__PAdditiveExpression__Group_1__0 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_32 = input.LA(1);

                         
                        int index26_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPerl()) ) {s = 36;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index26_32);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_33 = input.LA(1);

                         
                        int index26_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalPerl()) ) {s = 36;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index26_33);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000C08000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000C18C00000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000C1F8000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001E00000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000E000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000003FC000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000003FC000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000088000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000000F000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000F000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000F98C00000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000F98C00000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0001F98C00000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000380000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0400000000000002L});

}