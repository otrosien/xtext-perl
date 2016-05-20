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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VAR_START", "RULE_ID", "RULE_STRING", "RULE_HEX", "RULE_BIN", "RULE_OCT", "RULE_INT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'**='", "'<'", "'>'", "'>='", "'||'", "'&&'", "'=='", "'!='", "'eq'", "'ne'", "'=>'", "'<>'", "'?:'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'++'", "'--'", "'sub'", "'{'", "'}'", "';'", "'('", "')'", "'if'", "'else'", "'my'", "'our'", "'local'", "'undef'", "'return'", "'::'"
    };
    public static final int RULE_HEX=7;
    public static final int T__50=50;
    public static final int RULE_OCT=9;
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
    public static final int RULE_BIN=8;
    public static final int T__54=54;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=10;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
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
    public static final int RULE_VAR_START=4;
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

        public InternalPerlParser(TokenStream input, PerlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "PExpression";
       	}

       	@Override
       	protected PerlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulePExpression"
    // InternalPerl.g:64:1: entryRulePExpression returns [EObject current=null] : iv_rulePExpression= rulePExpression EOF ;
    public final EObject entryRulePExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePExpression = null;


        try {
            // InternalPerl.g:64:52: (iv_rulePExpression= rulePExpression EOF )
            // InternalPerl.g:65:2: iv_rulePExpression= rulePExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePExpression=rulePExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePExpression; 
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
    // $ANTLR end "entryRulePExpression"


    // $ANTLR start "rulePExpression"
    // InternalPerl.g:71:1: rulePExpression returns [EObject current=null] : this_PAssignment_0= rulePAssignment ;
    public final EObject rulePExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PAssignment_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:77:2: (this_PAssignment_0= rulePAssignment )
            // InternalPerl.g:78:2: this_PAssignment_0= rulePAssignment
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getPExpressionAccess().getPAssignmentParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_PAssignment_0=rulePAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_PAssignment_0;
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
    // $ANTLR end "rulePExpression"


    // $ANTLR start "entryRulePAssignment"
    // InternalPerl.g:89:1: entryRulePAssignment returns [EObject current=null] : iv_rulePAssignment= rulePAssignment EOF ;
    public final EObject entryRulePAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAssignment = null;


        try {
            // InternalPerl.g:89:52: (iv_rulePAssignment= rulePAssignment EOF )
            // InternalPerl.g:90:2: iv_rulePAssignment= rulePAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePAssignment=rulePAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePAssignment; 
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
    // $ANTLR end "entryRulePAssignment"


    // $ANTLR start "rulePAssignment"
    // InternalPerl.g:96:1: rulePAssignment returns [EObject current=null] : ( ( () ( (lv_var_1_0= rulePVar ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) ) | (this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )? ) ) ;
    public final EObject rulePAssignment() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_var_1_0 = null;

        EObject lv_value_3_0 = null;

        EObject this_POrExpression_4 = null;

        AntlrDatatypeRuleToken lv_feature_6_0 = null;

        EObject lv_rightOperand_7_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:102:2: ( ( ( () ( (lv_var_1_0= rulePVar ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) ) | (this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )? ) ) )
            // InternalPerl.g:103:2: ( ( () ( (lv_var_1_0= rulePVar ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) ) | (this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )? ) )
            {
            // InternalPerl.g:103:2: ( ( () ( (lv_var_1_0= rulePVar ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) ) | (this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )? ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_VAR_START) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=33 && LA2_0<=34)||LA2_0==39) ) {
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
                    // InternalPerl.g:104:3: ( () ( (lv_var_1_0= rulePVar ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) )
                    {
                    // InternalPerl.g:104:3: ( () ( (lv_var_1_0= rulePVar ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) )
                    // InternalPerl.g:105:4: () ( (lv_var_1_0= rulePVar ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) )
                    {
                    // InternalPerl.g:105:4: ()
                    // InternalPerl.g:106:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPAssignmentAccess().getPAssignmentAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalPerl.g:112:4: ( (lv_var_1_0= rulePVar ) )
                    // InternalPerl.g:113:5: (lv_var_1_0= rulePVar )
                    {
                    // InternalPerl.g:113:5: (lv_var_1_0= rulePVar )
                    // InternalPerl.g:114:6: lv_var_1_0= rulePVar
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPAssignmentAccess().getVarPVarParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_3);
                    lv_var_1_0=rulePVar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"var",
                      							lv_var_1_0,
                      							"org.epic.perl.Perl.PVar");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPAssignmentAccess().getOpSingleAssignParserRuleCall_0_2());
                      			
                    }
                    pushFollow(FOLLOW_4);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalPerl.g:138:4: ( (lv_value_3_0= rulePAssignment ) )
                    // InternalPerl.g:139:5: (lv_value_3_0= rulePAssignment )
                    {
                    // InternalPerl.g:139:5: (lv_value_3_0= rulePAssignment )
                    // InternalPerl.g:140:6: lv_value_3_0= rulePAssignment
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPAssignmentAccess().getValuePAssignmentParserRuleCall_0_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=rulePAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"org.epic.perl.Perl.PAssignment");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:159:3: (this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )? )
                    {
                    // InternalPerl.g:159:3: (this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )? )
                    // InternalPerl.g:160:4: this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPAssignmentAccess().getPOrExpressionParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_5);
                    this_POrExpression_4=rulePOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_POrExpression_4;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalPerl.g:168:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )?
                    int alt1=2;
                    alt1 = dfa1.predict(input);
                    switch (alt1) {
                        case 1 :
                            // InternalPerl.g:169:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) )
                            {
                            // InternalPerl.g:169:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) )
                            // InternalPerl.g:170:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) )
                            {
                            // InternalPerl.g:180:6: ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) )
                            // InternalPerl.g:181:7: () ( (lv_feature_6_0= ruleOpMultiAssign ) )
                            {
                            // InternalPerl.g:181:7: ()
                            // InternalPerl.g:182:8: 
                            {
                            if ( state.backtracking==0 ) {

                              								current = forceCreateModelElementAndSet(
                              									grammarAccess.getPAssignmentAccess().getPBinaryOperationLeftOperandAction_1_1_0_0_0(),
                              									current);
                              							
                            }

                            }

                            // InternalPerl.g:188:7: ( (lv_feature_6_0= ruleOpMultiAssign ) )
                            // InternalPerl.g:189:8: (lv_feature_6_0= ruleOpMultiAssign )
                            {
                            // InternalPerl.g:189:8: (lv_feature_6_0= ruleOpMultiAssign )
                            // InternalPerl.g:190:9: lv_feature_6_0= ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPAssignmentAccess().getFeatureOpMultiAssignParserRuleCall_1_1_0_0_1_0());
                              								
                            }
                            pushFollow(FOLLOW_4);
                            lv_feature_6_0=ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPAssignmentRule());
                              									}
                              									set(
                              										current,
                              										"feature",
                              										lv_feature_6_0,
                              										"org.epic.perl.Perl.OpMultiAssign");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }


                            }

                            // InternalPerl.g:209:5: ( (lv_rightOperand_7_0= rulePAssignment ) )
                            // InternalPerl.g:210:6: (lv_rightOperand_7_0= rulePAssignment )
                            {
                            // InternalPerl.g:210:6: (lv_rightOperand_7_0= rulePAssignment )
                            // InternalPerl.g:211:7: lv_rightOperand_7_0= rulePAssignment
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPAssignmentAccess().getRightOperandPAssignmentParserRuleCall_1_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_rightOperand_7_0=rulePAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getPAssignmentRule());
                              							}
                              							set(
                              								current,
                              								"rightOperand",
                              								lv_rightOperand_7_0,
                              								"org.epic.perl.Perl.PAssignment");
                              							afterParserOrEnumRuleCall();
                              						
                            }

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
    // $ANTLR end "rulePAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // InternalPerl.g:234:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // InternalPerl.g:234:54: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // InternalPerl.g:235:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
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
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // InternalPerl.g:241:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:247:2: (kw= '=' )
            // InternalPerl.g:248:2: kw= '='
            {
            kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword());
              	
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
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // InternalPerl.g:256:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // InternalPerl.g:256:53: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // InternalPerl.g:257:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
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
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // InternalPerl.g:263:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= '**=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:269:2: ( (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= '**=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
            // InternalPerl.g:270:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= '**=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            {
            // InternalPerl.g:270:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= '**=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            int alt4=8;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt4=1;
                }
                break;
            case 16:
                {
                alt4=2;
                }
                break;
            case 17:
                {
                alt4=3;
                }
                break;
            case 18:
                {
                alt4=4;
                }
                break;
            case 19:
                {
                alt4=5;
                }
                break;
            case 20:
                {
                alt4=6;
                }
                break;
            case 21:
                {
                alt4=7;
                }
                break;
            case 22:
                {
                alt4=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalPerl.g:271:3: kw= '+='
                    {
                    kw=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:277:3: kw= '-='
                    {
                    kw=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:283:3: kw= '*='
                    {
                    kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:289:3: kw= '/='
                    {
                    kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalPerl.g:295:3: kw= '%='
                    {
                    kw=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalPerl.g:301:3: kw= '**='
                    {
                    kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskAsteriskEqualsSignKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalPerl.g:307:3: (kw= '<' kw= '<' kw= '=' )
                    {
                    // InternalPerl.g:307:3: (kw= '<' kw= '<' kw= '=' )
                    // InternalPerl.g:308:4: kw= '<' kw= '<' kw= '='
                    {
                    kw=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_0());
                      			
                    }
                    kw=(Token)match(input,21,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_1());
                      			
                    }
                    kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_6_2());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:325:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    {
                    // InternalPerl.g:325:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    // InternalPerl.g:326:4: kw= '>' (kw= '>' )? kw= '>='
                    {
                    kw=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_0());
                      			
                    }
                    // InternalPerl.g:331:4: (kw= '>' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==22) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalPerl.g:332:5: kw= '>'
                            {
                            kw=(Token)match(input,22,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_1());
                              				
                            }

                            }
                            break;

                    }

                    kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_7_2());
                      			
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
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRulePOrExpression"
    // InternalPerl.g:348:1: entryRulePOrExpression returns [EObject current=null] : iv_rulePOrExpression= rulePOrExpression EOF ;
    public final EObject entryRulePOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePOrExpression = null;


        try {
            // InternalPerl.g:348:54: (iv_rulePOrExpression= rulePOrExpression EOF )
            // InternalPerl.g:349:2: iv_rulePOrExpression= rulePOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePOrExpression=rulePOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePOrExpression; 
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
    // $ANTLR end "entryRulePOrExpression"


    // $ANTLR start "rulePOrExpression"
    // InternalPerl.g:355:1: rulePOrExpression returns [EObject current=null] : (this_PAndExpression_0= rulePAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= rulePAndExpression ) ) )* ) ;
    public final EObject rulePOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PAndExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:361:2: ( (this_PAndExpression_0= rulePAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= rulePAndExpression ) ) )* ) )
            // InternalPerl.g:362:2: (this_PAndExpression_0= rulePAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= rulePAndExpression ) ) )* )
            {
            // InternalPerl.g:362:2: (this_PAndExpression_0= rulePAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= rulePAndExpression ) ) )* )
            // InternalPerl.g:363:3: this_PAndExpression_0= rulePAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= rulePAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPOrExpressionAccess().getPAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_9);
            this_PAndExpression_0=rulePAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalPerl.g:371:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= rulePAndExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==24) && (synpred2_InternalPerl())) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalPerl.g:372:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= rulePAndExpression ) )
            	    {
            	    // InternalPerl.g:372:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) )
            	    // InternalPerl.g:373:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) )
            	    {
            	    // InternalPerl.g:383:5: ( () ( (lv_feature_2_0= ruleOpOr ) ) )
            	    // InternalPerl.g:384:6: () ( (lv_feature_2_0= ruleOpOr ) )
            	    {
            	    // InternalPerl.g:384:6: ()
            	    // InternalPerl.g:385:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPOrExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalPerl.g:391:6: ( (lv_feature_2_0= ruleOpOr ) )
            	    // InternalPerl.g:392:7: (lv_feature_2_0= ruleOpOr )
            	    {
            	    // InternalPerl.g:392:7: (lv_feature_2_0= ruleOpOr )
            	    // InternalPerl.g:393:8: lv_feature_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getPOrExpressionAccess().getFeatureOpOrParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_feature_2_0=ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getPOrExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.epic.perl.Perl.OpOr");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalPerl.g:412:4: ( (lv_rightOperand_3_0= rulePAndExpression ) )
            	    // InternalPerl.g:413:5: (lv_rightOperand_3_0= rulePAndExpression )
            	    {
            	    // InternalPerl.g:413:5: (lv_rightOperand_3_0= rulePAndExpression )
            	    // InternalPerl.g:414:6: lv_rightOperand_3_0= rulePAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPOrExpressionAccess().getRightOperandPAndExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_rightOperand_3_0=rulePAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.epic.perl.Perl.PAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "rulePOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalPerl.g:436:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalPerl.g:436:44: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalPerl.g:437:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
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
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalPerl.g:443:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:449:2: (kw= '||' )
            // InternalPerl.g:450:2: kw= '||'
            {
            kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword());
              	
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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRulePAndExpression"
    // InternalPerl.g:458:1: entryRulePAndExpression returns [EObject current=null] : iv_rulePAndExpression= rulePAndExpression EOF ;
    public final EObject entryRulePAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAndExpression = null;


        try {
            // InternalPerl.g:458:55: (iv_rulePAndExpression= rulePAndExpression EOF )
            // InternalPerl.g:459:2: iv_rulePAndExpression= rulePAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePAndExpression=rulePAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePAndExpression; 
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
    // $ANTLR end "entryRulePAndExpression"


    // $ANTLR start "rulePAndExpression"
    // InternalPerl.g:465:1: rulePAndExpression returns [EObject current=null] : (this_PEqualityExpression_0= rulePEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= rulePEqualityExpression ) ) )* ) ;
    public final EObject rulePAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PEqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:471:2: ( (this_PEqualityExpression_0= rulePEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= rulePEqualityExpression ) ) )* ) )
            // InternalPerl.g:472:2: (this_PEqualityExpression_0= rulePEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= rulePEqualityExpression ) ) )* )
            {
            // InternalPerl.g:472:2: (this_PEqualityExpression_0= rulePEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= rulePEqualityExpression ) ) )* )
            // InternalPerl.g:473:3: this_PEqualityExpression_0= rulePEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= rulePEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPAndExpressionAccess().getPEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_10);
            this_PEqualityExpression_0=rulePEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PEqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalPerl.g:481:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= rulePEqualityExpression ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) && (synpred3_InternalPerl())) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalPerl.g:482:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= rulePEqualityExpression ) )
            	    {
            	    // InternalPerl.g:482:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) )
            	    // InternalPerl.g:483:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) )
            	    {
            	    // InternalPerl.g:493:5: ( () ( (lv_feature_2_0= ruleOpAnd ) ) )
            	    // InternalPerl.g:494:6: () ( (lv_feature_2_0= ruleOpAnd ) )
            	    {
            	    // InternalPerl.g:494:6: ()
            	    // InternalPerl.g:495:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPAndExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalPerl.g:501:6: ( (lv_feature_2_0= ruleOpAnd ) )
            	    // InternalPerl.g:502:7: (lv_feature_2_0= ruleOpAnd )
            	    {
            	    // InternalPerl.g:502:7: (lv_feature_2_0= ruleOpAnd )
            	    // InternalPerl.g:503:8: lv_feature_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getPAndExpressionAccess().getFeatureOpAndParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_feature_2_0=ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getPAndExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.epic.perl.Perl.OpAnd");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalPerl.g:522:4: ( (lv_rightOperand_3_0= rulePEqualityExpression ) )
            	    // InternalPerl.g:523:5: (lv_rightOperand_3_0= rulePEqualityExpression )
            	    {
            	    // InternalPerl.g:523:5: (lv_rightOperand_3_0= rulePEqualityExpression )
            	    // InternalPerl.g:524:6: lv_rightOperand_3_0= rulePEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPAndExpressionAccess().getRightOperandPEqualityExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_rightOperand_3_0=rulePEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.epic.perl.Perl.PEqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "rulePAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalPerl.g:546:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalPerl.g:546:45: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalPerl.g:547:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
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
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalPerl.g:553:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:559:2: (kw= '&&' )
            // InternalPerl.g:560:2: kw= '&&'
            {
            kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword());
              	
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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRulePEqualityExpression"
    // InternalPerl.g:568:1: entryRulePEqualityExpression returns [EObject current=null] : iv_rulePEqualityExpression= rulePEqualityExpression EOF ;
    public final EObject entryRulePEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePEqualityExpression = null;


        try {
            // InternalPerl.g:568:60: (iv_rulePEqualityExpression= rulePEqualityExpression EOF )
            // InternalPerl.g:569:2: iv_rulePEqualityExpression= rulePEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePEqualityExpression=rulePEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePEqualityExpression; 
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
    // $ANTLR end "entryRulePEqualityExpression"


    // $ANTLR start "rulePEqualityExpression"
    // InternalPerl.g:575:1: rulePEqualityExpression returns [EObject current=null] : (this_PRelationalExpression_0= rulePRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= rulePRelationalExpression ) ) )* ) ;
    public final EObject rulePEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PRelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:581:2: ( (this_PRelationalExpression_0= rulePRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= rulePRelationalExpression ) ) )* ) )
            // InternalPerl.g:582:2: (this_PRelationalExpression_0= rulePRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= rulePRelationalExpression ) ) )* )
            {
            // InternalPerl.g:582:2: (this_PRelationalExpression_0= rulePRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= rulePRelationalExpression ) ) )* )
            // InternalPerl.g:583:3: this_PRelationalExpression_0= rulePRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= rulePRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPEqualityExpressionAccess().getPRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_11);
            this_PRelationalExpression_0=rulePRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PRelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalPerl.g:591:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= rulePRelationalExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==26) && (synpred4_InternalPerl())) {
                    alt7=1;
                }
                else if ( (LA7_0==27) && (synpred4_InternalPerl())) {
                    alt7=1;
                }
                else if ( (LA7_0==28) && (synpred4_InternalPerl())) {
                    alt7=1;
                }
                else if ( (LA7_0==29) && (synpred4_InternalPerl())) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPerl.g:592:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= rulePRelationalExpression ) )
            	    {
            	    // InternalPerl.g:592:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) )
            	    // InternalPerl.g:593:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) )
            	    {
            	    // InternalPerl.g:603:5: ( () ( (lv_feature_2_0= ruleOpEquality ) ) )
            	    // InternalPerl.g:604:6: () ( (lv_feature_2_0= ruleOpEquality ) )
            	    {
            	    // InternalPerl.g:604:6: ()
            	    // InternalPerl.g:605:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPEqualityExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalPerl.g:611:6: ( (lv_feature_2_0= ruleOpEquality ) )
            	    // InternalPerl.g:612:7: (lv_feature_2_0= ruleOpEquality )
            	    {
            	    // InternalPerl.g:612:7: (lv_feature_2_0= ruleOpEquality )
            	    // InternalPerl.g:613:8: lv_feature_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getPEqualityExpressionAccess().getFeatureOpEqualityParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_feature_2_0=ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getPEqualityExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.epic.perl.Perl.OpEquality");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalPerl.g:632:4: ( (lv_rightOperand_3_0= rulePRelationalExpression ) )
            	    // InternalPerl.g:633:5: (lv_rightOperand_3_0= rulePRelationalExpression )
            	    {
            	    // InternalPerl.g:633:5: (lv_rightOperand_3_0= rulePRelationalExpression )
            	    // InternalPerl.g:634:6: lv_rightOperand_3_0= rulePRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPEqualityExpressionAccess().getRightOperandPRelationalExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_rightOperand_3_0=rulePRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.epic.perl.Perl.PRelationalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "rulePEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalPerl.g:656:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalPerl.g:656:50: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalPerl.g:657:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
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
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalPerl.g:663:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' | kw= 'eq' | kw= 'ne' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:669:2: ( (kw= '==' | kw= '!=' | kw= 'eq' | kw= 'ne' ) )
            // InternalPerl.g:670:2: (kw= '==' | kw= '!=' | kw= 'eq' | kw= 'ne' )
            {
            // InternalPerl.g:670:2: (kw= '==' | kw= '!=' | kw= 'eq' | kw= 'ne' )
            int alt8=4;
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
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalPerl.g:671:3: kw= '=='
                    {
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:677:3: kw= '!='
                    {
                    kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:683:3: kw= 'eq'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:689:3: kw= 'ne'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getNeKeyword_3());
                      		
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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRulePRelationalExpression"
    // InternalPerl.g:698:1: entryRulePRelationalExpression returns [EObject current=null] : iv_rulePRelationalExpression= rulePRelationalExpression EOF ;
    public final EObject entryRulePRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePRelationalExpression = null;


        try {
            // InternalPerl.g:698:62: (iv_rulePRelationalExpression= rulePRelationalExpression EOF )
            // InternalPerl.g:699:2: iv_rulePRelationalExpression= rulePRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePRelationalExpression=rulePRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePRelationalExpression; 
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
    // $ANTLR end "entryRulePRelationalExpression"


    // $ANTLR start "rulePRelationalExpression"
    // InternalPerl.g:705:1: rulePRelationalExpression returns [EObject current=null] : (this_POtherOperatorExpression_0= rulePOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= rulePOtherOperatorExpression ) ) )* ) ;
    public final EObject rulePRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_POtherOperatorExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:711:2: ( (this_POtherOperatorExpression_0= rulePOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= rulePOtherOperatorExpression ) ) )* ) )
            // InternalPerl.g:712:2: (this_POtherOperatorExpression_0= rulePOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= rulePOtherOperatorExpression ) ) )* )
            {
            // InternalPerl.g:712:2: (this_POtherOperatorExpression_0= rulePOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= rulePOtherOperatorExpression ) ) )* )
            // InternalPerl.g:713:3: this_POtherOperatorExpression_0= rulePOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= rulePOtherOperatorExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPRelationalExpressionAccess().getPOtherOperatorExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_12);
            this_POtherOperatorExpression_0=rulePOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_POtherOperatorExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalPerl.g:721:3: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= rulePOtherOperatorExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2==39) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }
                    else if ( (LA9_2==34) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }
                    else if ( (LA9_2==33) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }
                    else if ( (LA9_2==14) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==22) ) {
                    int LA9_3 = input.LA(2);

                    if ( (LA9_3==39) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }
                    else if ( (LA9_3==34) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }
                    else if ( (LA9_3==33) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==23) && (synpred5_InternalPerl())) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalPerl.g:722:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= rulePOtherOperatorExpression ) )
            	    {
            	    // InternalPerl.g:722:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) )
            	    // InternalPerl.g:723:5: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) )
            	    {
            	    // InternalPerl.g:733:5: ( () ( (lv_feature_2_0= ruleOpCompare ) ) )
            	    // InternalPerl.g:734:6: () ( (lv_feature_2_0= ruleOpCompare ) )
            	    {
            	    // InternalPerl.g:734:6: ()
            	    // InternalPerl.g:735:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPRelationalExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalPerl.g:741:6: ( (lv_feature_2_0= ruleOpCompare ) )
            	    // InternalPerl.g:742:7: (lv_feature_2_0= ruleOpCompare )
            	    {
            	    // InternalPerl.g:742:7: (lv_feature_2_0= ruleOpCompare )
            	    // InternalPerl.g:743:8: lv_feature_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getPRelationalExpressionAccess().getFeatureOpCompareParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_feature_2_0=ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getPRelationalExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.epic.perl.Perl.OpCompare");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalPerl.g:762:4: ( (lv_rightOperand_3_0= rulePOtherOperatorExpression ) )
            	    // InternalPerl.g:763:5: (lv_rightOperand_3_0= rulePOtherOperatorExpression )
            	    {
            	    // InternalPerl.g:763:5: (lv_rightOperand_3_0= rulePOtherOperatorExpression )
            	    // InternalPerl.g:764:6: lv_rightOperand_3_0= rulePOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPRelationalExpressionAccess().getRightOperandPOtherOperatorExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_rightOperand_3_0=rulePOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPRelationalExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.epic.perl.Perl.POtherOperatorExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "rulePRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalPerl.g:786:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalPerl.g:786:49: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalPerl.g:787:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
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
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // InternalPerl.g:793:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:799:2: ( (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) )
            // InternalPerl.g:800:2: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            {
            // InternalPerl.g:800:2: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt10=1;
                }
                break;
            case 21:
                {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==EOF||(LA10_2>=33 && LA10_2<=34)||LA10_2==39) ) {
                    alt10=4;
                }
                else if ( (LA10_2==14) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                alt10=3;
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
                    // InternalPerl.g:801:3: kw= '>='
                    {
                    kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:807:3: (kw= '<' kw= '=' )
                    {
                    // InternalPerl.g:807:3: (kw= '<' kw= '=' )
                    // InternalPerl.g:808:4: kw= '<' kw= '='
                    {
                    kw=(Token)match(input,21,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:820:3: kw= '>'
                    {
                    kw=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:826:3: kw= '<'
                    {
                    kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3());
                      		
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
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRulePOtherOperatorExpression"
    // InternalPerl.g:835:1: entryRulePOtherOperatorExpression returns [EObject current=null] : iv_rulePOtherOperatorExpression= rulePOtherOperatorExpression EOF ;
    public final EObject entryRulePOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePOtherOperatorExpression = null;


        try {
            // InternalPerl.g:835:65: (iv_rulePOtherOperatorExpression= rulePOtherOperatorExpression EOF )
            // InternalPerl.g:836:2: iv_rulePOtherOperatorExpression= rulePOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePOtherOperatorExpression=rulePOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePOtherOperatorExpression; 
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
    // $ANTLR end "entryRulePOtherOperatorExpression"


    // $ANTLR start "rulePOtherOperatorExpression"
    // InternalPerl.g:842:1: rulePOtherOperatorExpression returns [EObject current=null] : (this_PAdditiveExpression_0= rulePAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= rulePAdditiveExpression ) ) )* ) ;
    public final EObject rulePOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PAdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:848:2: ( (this_PAdditiveExpression_0= rulePAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= rulePAdditiveExpression ) ) )* ) )
            // InternalPerl.g:849:2: (this_PAdditiveExpression_0= rulePAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= rulePAdditiveExpression ) ) )* )
            {
            // InternalPerl.g:849:2: (this_PAdditiveExpression_0= rulePAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= rulePAdditiveExpression ) ) )* )
            // InternalPerl.g:850:3: this_PAdditiveExpression_0= rulePAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= rulePAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPOtherOperatorExpressionAccess().getPAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_13);
            this_PAdditiveExpression_0=rulePAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PAdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalPerl.g:858:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= rulePAdditiveExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                alt11 = dfa11.predict(input);
                switch (alt11) {
            	case 1 :
            	    // InternalPerl.g:859:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= rulePAdditiveExpression ) )
            	    {
            	    // InternalPerl.g:859:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) )
            	    // InternalPerl.g:860:5: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) )
            	    {
            	    // InternalPerl.g:870:5: ( () ( (lv_feature_2_0= ruleOpOther ) ) )
            	    // InternalPerl.g:871:6: () ( (lv_feature_2_0= ruleOpOther ) )
            	    {
            	    // InternalPerl.g:871:6: ()
            	    // InternalPerl.g:872:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPOtherOperatorExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalPerl.g:878:6: ( (lv_feature_2_0= ruleOpOther ) )
            	    // InternalPerl.g:879:7: (lv_feature_2_0= ruleOpOther )
            	    {
            	    // InternalPerl.g:879:7: (lv_feature_2_0= ruleOpOther )
            	    // InternalPerl.g:880:8: lv_feature_2_0= ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getPOtherOperatorExpressionAccess().getFeatureOpOtherParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_feature_2_0=ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getPOtherOperatorExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.epic.perl.Perl.OpOther");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalPerl.g:899:4: ( (lv_rightOperand_3_0= rulePAdditiveExpression ) )
            	    // InternalPerl.g:900:5: (lv_rightOperand_3_0= rulePAdditiveExpression )
            	    {
            	    // InternalPerl.g:900:5: (lv_rightOperand_3_0= rulePAdditiveExpression )
            	    // InternalPerl.g:901:6: lv_rightOperand_3_0= rulePAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPOtherOperatorExpressionAccess().getRightOperandPAdditiveExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_rightOperand_3_0=rulePAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPOtherOperatorExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.epic.perl.Perl.PAdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // $ANTLR end "rulePOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // InternalPerl.g:923:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // InternalPerl.g:923:47: (iv_ruleOpOther= ruleOpOther EOF )
            // InternalPerl.g:924:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
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
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // InternalPerl.g:930:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:936:2: ( ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) )
            // InternalPerl.g:937:2: ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            {
            // InternalPerl.g:937:2: ( (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt14=1;
                }
                break;
            case 21:
                {
                alt14=2;
                }
                break;
            case 31:
                {
                alt14=3;
                }
                break;
            case 32:
                {
                alt14=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalPerl.g:938:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    {
                    // InternalPerl.g:938:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    // InternalPerl.g:939:4: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    {
                    kw=(Token)match(input,22,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_0());
                      			
                    }
                    // InternalPerl.g:944:4: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==22) ) {
                        int LA12_1 = input.LA(2);

                        if ( (LA12_1==EOF||(LA12_1>=33 && LA12_1<=34)||LA12_1==39) ) {
                            alt12=2;
                        }
                        else if ( (LA12_1==22) && (synpred7_InternalPerl())) {
                            alt12=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 12, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalPerl.g:945:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            {
                            // InternalPerl.g:945:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            // InternalPerl.g:946:6: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
                            {
                            // InternalPerl.g:951:6: (kw= '>' kw= '>' )
                            // InternalPerl.g:952:7: kw= '>' kw= '>'
                            {
                            kw=(Token)match(input,22,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_0_0_0());
                              						
                            }
                            kw=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_0_0_1());
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalPerl.g:965:5: kw= '>'
                            {
                            kw=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_0_1_1());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:973:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    {
                    // InternalPerl.g:973:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    // InternalPerl.g:974:4: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    {
                    kw=(Token)match(input,21,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalPerl.g:979:4: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    int alt13=3;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==21) ) {
                        int LA13_1 = input.LA(2);

                        if ( (LA13_1==EOF||(LA13_1>=33 && LA13_1<=34)||LA13_1==39) ) {
                            alt13=2;
                        }
                        else if ( (LA13_1==21) && (synpred8_InternalPerl())) {
                            alt13=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA13_0==30) ) {
                        alt13=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalPerl.g:980:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            {
                            // InternalPerl.g:980:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            // InternalPerl.g:981:6: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
                            {
                            // InternalPerl.g:986:6: (kw= '<' kw= '<' )
                            // InternalPerl.g:987:7: kw= '<' kw= '<'
                            {
                            kw=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_1_0_0_0());
                              						
                            }
                            kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_1_0_0_1());
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalPerl.g:1000:5: kw= '<'
                            {
                            kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_1_1_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalPerl.g:1006:5: kw= '=>'
                            {
                            kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_1_1_2());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1014:3: kw= '<>'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:1020:3: kw= '?:'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_3());
                      		
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
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRulePAdditiveExpression"
    // InternalPerl.g:1029:1: entryRulePAdditiveExpression returns [EObject current=null] : iv_rulePAdditiveExpression= rulePAdditiveExpression EOF ;
    public final EObject entryRulePAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAdditiveExpression = null;


        try {
            // InternalPerl.g:1029:60: (iv_rulePAdditiveExpression= rulePAdditiveExpression EOF )
            // InternalPerl.g:1030:2: iv_rulePAdditiveExpression= rulePAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePAdditiveExpression=rulePAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePAdditiveExpression; 
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
    // $ANTLR end "entryRulePAdditiveExpression"


    // $ANTLR start "rulePAdditiveExpression"
    // InternalPerl.g:1036:1: rulePAdditiveExpression returns [EObject current=null] : (this_PMultiplicativeExpression_0= rulePMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )* ) ;
    public final EObject rulePAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PMultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1042:2: ( (this_PMultiplicativeExpression_0= rulePMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )* ) )
            // InternalPerl.g:1043:2: (this_PMultiplicativeExpression_0= rulePMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )* )
            {
            // InternalPerl.g:1043:2: (this_PMultiplicativeExpression_0= rulePMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )* )
            // InternalPerl.g:1044:3: this_PMultiplicativeExpression_0= rulePMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPAdditiveExpressionAccess().getPMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_16);
            this_PMultiplicativeExpression_0=rulePMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PMultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalPerl.g:1052:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // InternalPerl.g:1053:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) )
            	    {
            	    // InternalPerl.g:1053:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) )
            	    // InternalPerl.g:1054:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    {
            	    // InternalPerl.g:1064:5: ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    // InternalPerl.g:1065:6: () ( (lv_feature_2_0= ruleOpAdd ) )
            	    {
            	    // InternalPerl.g:1065:6: ()
            	    // InternalPerl.g:1066:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPAdditiveExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalPerl.g:1072:6: ( (lv_feature_2_0= ruleOpAdd ) )
            	    // InternalPerl.g:1073:7: (lv_feature_2_0= ruleOpAdd )
            	    {
            	    // InternalPerl.g:1073:7: (lv_feature_2_0= ruleOpAdd )
            	    // InternalPerl.g:1074:8: lv_feature_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getPAdditiveExpressionAccess().getFeatureOpAddParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_feature_2_0=ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getPAdditiveExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.epic.perl.Perl.OpAdd");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalPerl.g:1093:4: ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) )
            	    // InternalPerl.g:1094:5: (lv_rightOperand_3_0= rulePMultiplicativeExpression )
            	    {
            	    // InternalPerl.g:1094:5: (lv_rightOperand_3_0= rulePMultiplicativeExpression )
            	    // InternalPerl.g:1095:6: lv_rightOperand_3_0= rulePMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPAdditiveExpressionAccess().getRightOperandPMultiplicativeExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_rightOperand_3_0=rulePMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.epic.perl.Perl.PMultiplicativeExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "rulePAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalPerl.g:1117:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalPerl.g:1117:45: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalPerl.g:1118:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
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
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // InternalPerl.g:1124:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:1130:2: ( (kw= '+' | kw= '-' ) )
            // InternalPerl.g:1131:2: (kw= '+' | kw= '-' )
            {
            // InternalPerl.g:1131:2: (kw= '+' | kw= '-' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==33) ) {
                alt16=1;
            }
            else if ( (LA16_0==34) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalPerl.g:1132:3: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1138:3: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1());
                      		
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
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRulePMultiplicativeExpression"
    // InternalPerl.g:1147:1: entryRulePMultiplicativeExpression returns [EObject current=null] : iv_rulePMultiplicativeExpression= rulePMultiplicativeExpression EOF ;
    public final EObject entryRulePMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePMultiplicativeExpression = null;


        try {
            // InternalPerl.g:1147:66: (iv_rulePMultiplicativeExpression= rulePMultiplicativeExpression EOF )
            // InternalPerl.g:1148:2: iv_rulePMultiplicativeExpression= rulePMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePMultiplicativeExpression=rulePMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePMultiplicativeExpression; 
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
    // $ANTLR end "entryRulePMultiplicativeExpression"


    // $ANTLR start "rulePMultiplicativeExpression"
    // InternalPerl.g:1154:1: rulePMultiplicativeExpression returns [EObject current=null] : (this_PUnaryOperation_0= rulePUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )* ) ;
    public final EObject rulePMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PUnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1160:2: ( (this_PUnaryOperation_0= rulePUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )* ) )
            // InternalPerl.g:1161:2: (this_PUnaryOperation_0= rulePUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )* )
            {
            // InternalPerl.g:1161:2: (this_PUnaryOperation_0= rulePUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )* )
            // InternalPerl.g:1162:3: this_PUnaryOperation_0= rulePUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPMultiplicativeExpressionAccess().getPUnaryOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_17);
            this_PUnaryOperation_0=rulePUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PUnaryOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalPerl.g:1170:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==35) && (synpred10_InternalPerl())) {
                    alt17=1;
                }
                else if ( (LA17_0==36) && (synpred10_InternalPerl())) {
                    alt17=1;
                }
                else if ( (LA17_0==37) && (synpred10_InternalPerl())) {
                    alt17=1;
                }
                else if ( (LA17_0==38) && (synpred10_InternalPerl())) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalPerl.g:1171:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) )
            	    {
            	    // InternalPerl.g:1171:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) )
            	    // InternalPerl.g:1172:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    {
            	    // InternalPerl.g:1182:5: ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    // InternalPerl.g:1183:6: () ( (lv_feature_2_0= ruleOpMulti ) )
            	    {
            	    // InternalPerl.g:1183:6: ()
            	    // InternalPerl.g:1184:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPMultiplicativeExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalPerl.g:1190:6: ( (lv_feature_2_0= ruleOpMulti ) )
            	    // InternalPerl.g:1191:7: (lv_feature_2_0= ruleOpMulti )
            	    {
            	    // InternalPerl.g:1191:7: (lv_feature_2_0= ruleOpMulti )
            	    // InternalPerl.g:1192:8: lv_feature_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getPMultiplicativeExpressionAccess().getFeatureOpMultiParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_feature_2_0=ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getPMultiplicativeExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"feature",
            	      									lv_feature_2_0,
            	      									"org.epic.perl.Perl.OpMulti");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalPerl.g:1211:4: ( (lv_rightOperand_3_0= rulePUnaryOperation ) )
            	    // InternalPerl.g:1212:5: (lv_rightOperand_3_0= rulePUnaryOperation )
            	    {
            	    // InternalPerl.g:1212:5: (lv_rightOperand_3_0= rulePUnaryOperation )
            	    // InternalPerl.g:1213:6: lv_rightOperand_3_0= rulePUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPMultiplicativeExpressionAccess().getRightOperandPUnaryOperationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
            	    lv_rightOperand_3_0=rulePUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.epic.perl.Perl.PUnaryOperation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // $ANTLR end "rulePMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalPerl.g:1235:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalPerl.g:1235:47: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalPerl.g:1236:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
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
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // InternalPerl.g:1242:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:1248:2: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // InternalPerl.g:1249:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // InternalPerl.g:1249:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt18=1;
                }
                break;
            case 36:
                {
                alt18=2;
                }
                break;
            case 37:
                {
                alt18=3;
                }
                break;
            case 38:
                {
                alt18=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalPerl.g:1250:3: kw= '*'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1256:3: kw= '**'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1262:3: kw= '/'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:1268:3: kw= '%'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3());
                      		
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
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRulePUnaryOperation"
    // InternalPerl.g:1277:1: entryRulePUnaryOperation returns [EObject current=null] : iv_rulePUnaryOperation= rulePUnaryOperation EOF ;
    public final EObject entryRulePUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePUnaryOperation = null;


        try {
            // InternalPerl.g:1277:56: (iv_rulePUnaryOperation= rulePUnaryOperation EOF )
            // InternalPerl.g:1278:2: iv_rulePUnaryOperation= rulePUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePUnaryOperation=rulePUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePUnaryOperation; 
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
    // $ANTLR end "entryRulePUnaryOperation"


    // $ANTLR start "rulePUnaryOperation"
    // InternalPerl.g:1284:1: rulePUnaryOperation returns [EObject current=null] : ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= rulePUnaryOperation ) ) ) ;
    public final EObject rulePUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_feature_1_0 = null;

        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1290:2: ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= rulePUnaryOperation ) ) ) )
            // InternalPerl.g:1291:2: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= rulePUnaryOperation ) ) )
            {
            // InternalPerl.g:1291:2: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= rulePUnaryOperation ) ) )
            // InternalPerl.g:1292:3: () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= rulePUnaryOperation ) )
            {
            // InternalPerl.g:1292:3: ()
            // InternalPerl.g:1293:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPUnaryOperationAccess().getPUnaryOperationAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:1299:3: ( (lv_feature_1_0= ruleOpUnary ) )
            // InternalPerl.g:1300:4: (lv_feature_1_0= ruleOpUnary )
            {
            // InternalPerl.g:1300:4: (lv_feature_1_0= ruleOpUnary )
            // InternalPerl.g:1301:5: lv_feature_1_0= ruleOpUnary
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPUnaryOperationAccess().getFeatureOpUnaryParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_feature_1_0=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPUnaryOperationRule());
              					}
              					set(
              						current,
              						"feature",
              						lv_feature_1_0,
              						"org.epic.perl.Perl.OpUnary");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalPerl.g:1318:3: ( (lv_operand_2_0= rulePUnaryOperation ) )
            // InternalPerl.g:1319:4: (lv_operand_2_0= rulePUnaryOperation )
            {
            // InternalPerl.g:1319:4: (lv_operand_2_0= rulePUnaryOperation )
            // InternalPerl.g:1320:5: lv_operand_2_0= rulePUnaryOperation
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPUnaryOperationAccess().getOperandPUnaryOperationParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_operand_2_0=rulePUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPUnaryOperationRule());
              					}
              					set(
              						current,
              						"operand",
              						lv_operand_2_0,
              						"org.epic.perl.Perl.PUnaryOperation");
              					afterParserOrEnumRuleCall();
              				
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
    // $ANTLR end "rulePUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalPerl.g:1341:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalPerl.g:1341:47: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalPerl.g:1342:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
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
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // InternalPerl.g:1348:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:1354:2: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // InternalPerl.g:1355:2: (kw= '!' | kw= '-' | kw= '+' )
            {
            // InternalPerl.g:1355:2: (kw= '!' | kw= '-' | kw= '+' )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt19=1;
                }
                break;
            case 34:
                {
                alt19=2;
                }
                break;
            case 33:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalPerl.g:1356:3: kw= '!'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1362:3: kw= '-'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1368:3: kw= '+'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
                      		
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
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleOpPostfix"
    // InternalPerl.g:1377:1: entryRuleOpPostfix returns [String current=null] : iv_ruleOpPostfix= ruleOpPostfix EOF ;
    public final String entryRuleOpPostfix() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpPostfix = null;


        try {
            // InternalPerl.g:1377:49: (iv_ruleOpPostfix= ruleOpPostfix EOF )
            // InternalPerl.g:1378:2: iv_ruleOpPostfix= ruleOpPostfix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpPostfixRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpPostfix=ruleOpPostfix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpPostfix.getText(); 
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
    // $ANTLR end "entryRuleOpPostfix"


    // $ANTLR start "ruleOpPostfix"
    // InternalPerl.g:1384:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' | kw= '--' ) ;
    public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:1390:2: ( (kw= '++' | kw= '--' ) )
            // InternalPerl.g:1391:2: (kw= '++' | kw= '--' )
            {
            // InternalPerl.g:1391:2: (kw= '++' | kw= '--' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==40) ) {
                alt20=1;
            }
            else if ( (LA20_0==41) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalPerl.g:1392:3: kw= '++'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1398:3: kw= '--'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1());
                      		
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
    // $ANTLR end "ruleOpPostfix"


    // $ANTLR start "entryRulePVar"
    // InternalPerl.g:1407:1: entryRulePVar returns [String current=null] : iv_rulePVar= rulePVar EOF ;
    public final String entryRulePVar() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePVar = null;


        try {
            // InternalPerl.g:1407:44: (iv_rulePVar= rulePVar EOF )
            // InternalPerl.g:1408:2: iv_rulePVar= rulePVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPVarRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePVar=rulePVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePVar.getText(); 
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
    // $ANTLR end "entryRulePVar"


    // $ANTLR start "rulePVar"
    // InternalPerl.g:1414:1: rulePVar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_VAR_START_0= RULE_VAR_START this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken rulePVar() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_VAR_START_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalPerl.g:1420:2: ( (this_VAR_START_0= RULE_VAR_START this_ID_1= RULE_ID ) )
            // InternalPerl.g:1421:2: (this_VAR_START_0= RULE_VAR_START this_ID_1= RULE_ID )
            {
            // InternalPerl.g:1421:2: (this_VAR_START_0= RULE_VAR_START this_ID_1= RULE_ID )
            // InternalPerl.g:1422:3: this_VAR_START_0= RULE_VAR_START this_ID_1= RULE_ID
            {
            this_VAR_START_0=(Token)match(input,RULE_VAR_START,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_VAR_START_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_VAR_START_0, grammarAccess.getPVarAccess().getVAR_STARTTerminalRuleCall_0());
              		
            }
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_1, grammarAccess.getPVarAccess().getIDTerminalRuleCall_1());
              		
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
    // $ANTLR end "rulePVar"


    // $ANTLR start "entryRulePLiteral"
    // InternalPerl.g:1440:1: entryRulePLiteral returns [EObject current=null] : iv_rulePLiteral= rulePLiteral EOF ;
    public final EObject entryRulePLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePLiteral = null;


        try {
            // InternalPerl.g:1440:49: (iv_rulePLiteral= rulePLiteral EOF )
            // InternalPerl.g:1441:2: iv_rulePLiteral= rulePLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePLiteral=rulePLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePLiteral; 
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
    // $ANTLR end "entryRulePLiteral"


    // $ANTLR start "rulePLiteral"
    // InternalPerl.g:1447:1: rulePLiteral returns [EObject current=null] : ( ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure ) | this_PNumberLiteral_1= rulePNumberLiteral | this_PNullLiteral_2= rulePNullLiteral | this_PStringLiteral_3= rulePStringLiteral ) ;
    public final EObject rulePLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_PClosure_0 = null;

        EObject this_PNumberLiteral_1 = null;

        EObject this_PNullLiteral_2 = null;

        EObject this_PStringLiteral_3 = null;



        	enterRule();

        try {
            // InternalPerl.g:1453:2: ( ( ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure ) | this_PNumberLiteral_1= rulePNumberLiteral | this_PNullLiteral_2= rulePNullLiteral | this_PStringLiteral_3= rulePStringLiteral ) )
            // InternalPerl.g:1454:2: ( ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure ) | this_PNumberLiteral_1= rulePNumberLiteral | this_PNullLiteral_2= rulePNullLiteral | this_PStringLiteral_3= rulePStringLiteral )
            {
            // InternalPerl.g:1454:2: ( ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure ) | this_PNumberLiteral_1= rulePNumberLiteral | this_PNullLiteral_2= rulePNullLiteral | this_PStringLiteral_3= rulePStringLiteral )
            int alt21=4;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==42) && (synpred11_InternalPerl())) {
                alt21=1;
            }
            else if ( ((LA21_0>=RULE_HEX && LA21_0<=RULE_INT)) ) {
                alt21=2;
            }
            else if ( (LA21_0==53) ) {
                alt21=3;
            }
            else if ( (LA21_0==RULE_STRING) ) {
                alt21=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalPerl.g:1455:3: ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure )
                    {
                    // InternalPerl.g:1455:3: ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure )
                    // InternalPerl.g:1456:4: ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPLiteralAccess().getPClosureParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_PClosure_0=rulePClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_PClosure_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1473:3: this_PNumberLiteral_1= rulePNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPLiteralAccess().getPNumberLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PNumberLiteral_1=rulePNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PNumberLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1482:3: this_PNullLiteral_2= rulePNullLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPLiteralAccess().getPNullLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PNullLiteral_2=rulePNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PNullLiteral_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:1491:3: this_PStringLiteral_3= rulePStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPLiteralAccess().getPStringLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PStringLiteral_3=rulePStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PStringLiteral_3;
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
    // $ANTLR end "rulePLiteral"


    // $ANTLR start "entryRulePClosure"
    // InternalPerl.g:1503:1: entryRulePClosure returns [EObject current=null] : iv_rulePClosure= rulePClosure EOF ;
    public final EObject entryRulePClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePClosure = null;


        try {
            // InternalPerl.g:1503:49: (iv_rulePClosure= rulePClosure EOF )
            // InternalPerl.g:1504:2: iv_rulePClosure= rulePClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePClosure=rulePClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePClosure; 
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
    // $ANTLR end "entryRulePClosure"


    // $ANTLR start "rulePClosure"
    // InternalPerl.g:1510:1: rulePClosure returns [EObject current=null] : ( ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) ) ( (lv_expression_3_0= rulePExpressionInClosure ) ) otherlv_4= '}' ) ;
    public final EObject rulePClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1516:2: ( ( ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) ) ( (lv_expression_3_0= rulePExpressionInClosure ) ) otherlv_4= '}' ) )
            // InternalPerl.g:1517:2: ( ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) ) ( (lv_expression_3_0= rulePExpressionInClosure ) ) otherlv_4= '}' )
            {
            // InternalPerl.g:1517:2: ( ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) ) ( (lv_expression_3_0= rulePExpressionInClosure ) ) otherlv_4= '}' )
            // InternalPerl.g:1518:3: ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) ) ( (lv_expression_3_0= rulePExpressionInClosure ) ) otherlv_4= '}'
            {
            // InternalPerl.g:1518:3: ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) )
            // InternalPerl.g:1519:4: ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' )
            {
            // InternalPerl.g:1526:4: ( () otherlv_1= 'sub' otherlv_2= '{' )
            // InternalPerl.g:1527:5: () otherlv_1= 'sub' otherlv_2= '{'
            {
            // InternalPerl.g:1527:5: ()
            // InternalPerl.g:1528:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getPClosureAccess().getPClosureAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,42,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getPClosureAccess().getSubKeyword_0_0_1());
              				
            }
            otherlv_2=(Token)match(input,43,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getPClosureAccess().getLeftCurlyBracketKeyword_0_0_2());
              				
            }

            }


            }

            // InternalPerl.g:1544:3: ( (lv_expression_3_0= rulePExpressionInClosure ) )
            // InternalPerl.g:1545:4: (lv_expression_3_0= rulePExpressionInClosure )
            {
            // InternalPerl.g:1545:4: (lv_expression_3_0= rulePExpressionInClosure )
            // InternalPerl.g:1546:5: lv_expression_3_0= rulePExpressionInClosure
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPClosureAccess().getExpressionPExpressionInClosureParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_expression_3_0=rulePExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPClosureRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_3_0,
              						"org.epic.perl.Perl.PExpressionInClosure");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPClosureAccess().getRightCurlyBracketKeyword_2());
              		
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
    // $ANTLR end "rulePClosure"


    // $ANTLR start "entryRulePExpressionInClosure"
    // InternalPerl.g:1571:1: entryRulePExpressionInClosure returns [EObject current=null] : iv_rulePExpressionInClosure= rulePExpressionInClosure EOF ;
    public final EObject entryRulePExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePExpressionInClosure = null;


        try {
            // InternalPerl.g:1571:61: (iv_rulePExpressionInClosure= rulePExpressionInClosure EOF )
            // InternalPerl.g:1572:2: iv_rulePExpressionInClosure= rulePExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePExpressionInClosure=rulePExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePExpressionInClosure; 
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
    // $ANTLR end "entryRulePExpressionInClosure"


    // $ANTLR start "rulePExpressionInClosure"
    // InternalPerl.g:1578:1: rulePExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject rulePExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1584:2: ( ( () ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
            // InternalPerl.g:1585:2: ( () ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            {
            // InternalPerl.g:1585:2: ( () ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            // InternalPerl.g:1586:3: () ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            {
            // InternalPerl.g:1586:3: ()
            // InternalPerl.g:1587:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPExpressionInClosureAccess().getPBlockExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:1593:3: ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_VAR_START||(LA23_0>=33 && LA23_0<=34)||LA23_0==39||(LA23_0>=50 && LA23_0<=52)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalPerl.g:1594:4: ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
            	    {
            	    // InternalPerl.g:1594:4: ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) )
            	    // InternalPerl.g:1595:5: (lv_expressions_1_0= rulePExpressionOrVarDeclaration )
            	    {
            	    // InternalPerl.g:1595:5: (lv_expressions_1_0= rulePExpressionOrVarDeclaration )
            	    // InternalPerl.g:1596:6: lv_expressions_1_0= rulePExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPExpressionInClosureAccess().getExpressionsPExpressionOrVarDeclarationParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_expressions_1_0=rulePExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPExpressionInClosureRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_1_0,
            	      							"org.epic.perl.Perl.PExpressionOrVarDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalPerl.g:1613:4: (otherlv_2= ';' )?
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0==45) ) {
            	        alt22=1;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // InternalPerl.g:1614:5: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,45,FOLLOW_23); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_2, grammarAccess.getPExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end "rulePExpressionInClosure"


    // $ANTLR start "entryRulePParenthesizedExpression"
    // InternalPerl.g:1624:1: entryRulePParenthesizedExpression returns [EObject current=null] : iv_rulePParenthesizedExpression= rulePParenthesizedExpression EOF ;
    public final EObject entryRulePParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePParenthesizedExpression = null;


        try {
            // InternalPerl.g:1624:65: (iv_rulePParenthesizedExpression= rulePParenthesizedExpression EOF )
            // InternalPerl.g:1625:2: iv_rulePParenthesizedExpression= rulePParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePParenthesizedExpression=rulePParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePParenthesizedExpression; 
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
    // $ANTLR end "entryRulePParenthesizedExpression"


    // $ANTLR start "rulePParenthesizedExpression"
    // InternalPerl.g:1631:1: rulePParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_PExpression_1= rulePExpression otherlv_2= ')' ) ;
    public final EObject rulePParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_PExpression_1 = null;



        	enterRule();

        try {
            // InternalPerl.g:1637:2: ( (otherlv_0= '(' this_PExpression_1= rulePExpression otherlv_2= ')' ) )
            // InternalPerl.g:1638:2: (otherlv_0= '(' this_PExpression_1= rulePExpression otherlv_2= ')' )
            {
            // InternalPerl.g:1638:2: (otherlv_0= '(' this_PExpression_1= rulePExpression otherlv_2= ')' )
            // InternalPerl.g:1639:3: otherlv_0= '(' this_PExpression_1= rulePExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPParenthesizedExpressionAccess().getPExpressionParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_25);
            this_PExpression_1=rulePExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PExpression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
              		
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
    // $ANTLR end "rulePParenthesizedExpression"


    // $ANTLR start "entryRulePIfExpression"
    // InternalPerl.g:1659:1: entryRulePIfExpression returns [EObject current=null] : iv_rulePIfExpression= rulePIfExpression EOF ;
    public final EObject entryRulePIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePIfExpression = null;


        try {
            // InternalPerl.g:1659:54: (iv_rulePIfExpression= rulePIfExpression EOF )
            // InternalPerl.g:1660:2: iv_rulePIfExpression= rulePIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePIfExpression=rulePIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePIfExpression; 
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
    // $ANTLR end "entryRulePIfExpression"


    // $ANTLR start "rulePIfExpression"
    // InternalPerl.g:1666:1: rulePIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= rulePExpression ) ) otherlv_4= ')' ( (lv_then_5_0= rulePExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )? ) ;
    public final EObject rulePIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_if_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1672:2: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= rulePExpression ) ) otherlv_4= ')' ( (lv_then_5_0= rulePExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )? ) )
            // InternalPerl.g:1673:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= rulePExpression ) ) otherlv_4= ')' ( (lv_then_5_0= rulePExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )? )
            {
            // InternalPerl.g:1673:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= rulePExpression ) ) otherlv_4= ')' ( (lv_then_5_0= rulePExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )? )
            // InternalPerl.g:1674:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= rulePExpression ) ) otherlv_4= ')' ( (lv_then_5_0= rulePExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )?
            {
            // InternalPerl.g:1674:3: ()
            // InternalPerl.g:1675:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPIfExpressionAccess().getPIfExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,48,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPIfExpressionAccess().getIfKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,46,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPIfExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalPerl.g:1689:3: ( (lv_if_3_0= rulePExpression ) )
            // InternalPerl.g:1690:4: (lv_if_3_0= rulePExpression )
            {
            // InternalPerl.g:1690:4: (lv_if_3_0= rulePExpression )
            // InternalPerl.g:1691:5: lv_if_3_0= rulePExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPIfExpressionAccess().getIfPExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_if_3_0=rulePExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPIfExpressionRule());
              					}
              					set(
              						current,
              						"if",
              						lv_if_3_0,
              						"org.epic.perl.Perl.PExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,47,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPIfExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalPerl.g:1712:3: ( (lv_then_5_0= rulePExpression ) )
            // InternalPerl.g:1713:4: (lv_then_5_0= rulePExpression )
            {
            // InternalPerl.g:1713:4: (lv_then_5_0= rulePExpression )
            // InternalPerl.g:1714:5: lv_then_5_0= rulePExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPIfExpressionAccess().getThenPExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_then_5_0=rulePExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPIfExpressionRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_5_0,
              						"org.epic.perl.Perl.PExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalPerl.g:1731:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==49) && (synpred13_InternalPerl())) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalPerl.g:1732:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) )
                    {
                    // InternalPerl.g:1732:4: ( ( 'else' )=>otherlv_6= 'else' )
                    // InternalPerl.g:1733:5: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,49,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getPIfExpressionAccess().getElseKeyword_6_0());
                      				
                    }

                    }

                    // InternalPerl.g:1739:4: ( (lv_else_7_0= rulePExpression ) )
                    // InternalPerl.g:1740:5: (lv_else_7_0= rulePExpression )
                    {
                    // InternalPerl.g:1740:5: (lv_else_7_0= rulePExpression )
                    // InternalPerl.g:1741:6: lv_else_7_0= rulePExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPIfExpressionAccess().getElsePExpressionParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_7_0=rulePExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPIfExpressionRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_7_0,
                      							"org.epic.perl.Perl.PExpression");
                      						afterParserOrEnumRuleCall();
                      					
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
    // $ANTLR end "rulePIfExpression"


    // $ANTLR start "entryRulePBlockExpression"
    // InternalPerl.g:1763:1: entryRulePBlockExpression returns [EObject current=null] : iv_rulePBlockExpression= rulePBlockExpression EOF ;
    public final EObject entryRulePBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePBlockExpression = null;


        try {
            // InternalPerl.g:1763:57: (iv_rulePBlockExpression= rulePBlockExpression EOF )
            // InternalPerl.g:1764:2: iv_rulePBlockExpression= rulePBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePBlockExpression=rulePBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePBlockExpression; 
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
    // $ANTLR end "entryRulePBlockExpression"


    // $ANTLR start "rulePBlockExpression"
    // InternalPerl.g:1770:1: rulePBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject rulePBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1776:2: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // InternalPerl.g:1777:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // InternalPerl.g:1777:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // InternalPerl.g:1778:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // InternalPerl.g:1778:3: ()
            // InternalPerl.g:1779:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPBlockExpressionAccess().getPBlockExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,43,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalPerl.g:1789:3: ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_VAR_START||(LA26_0>=33 && LA26_0<=34)||LA26_0==39||(LA26_0>=50 && LA26_0<=52)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalPerl.g:1790:4: ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )?
            	    {
            	    // InternalPerl.g:1790:4: ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) )
            	    // InternalPerl.g:1791:5: (lv_expressions_2_0= rulePExpressionOrVarDeclaration )
            	    {
            	    // InternalPerl.g:1791:5: (lv_expressions_2_0= rulePExpressionOrVarDeclaration )
            	    // InternalPerl.g:1792:6: lv_expressions_2_0= rulePExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPBlockExpressionAccess().getExpressionsPExpressionOrVarDeclarationParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_expressions_2_0=rulePExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPBlockExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_2_0,
            	      							"org.epic.perl.Perl.PExpressionOrVarDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalPerl.g:1809:4: (otherlv_3= ';' )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==45) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // InternalPerl.g:1810:5: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,45,FOLLOW_20); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_3, grammarAccess.getPBlockExpressionAccess().getSemicolonKeyword_2_1());
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            otherlv_4=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPBlockExpressionAccess().getRightCurlyBracketKeyword_3());
              		
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
    // $ANTLR end "rulePBlockExpression"


    // $ANTLR start "entryRulePExpressionOrVarDeclaration"
    // InternalPerl.g:1824:1: entryRulePExpressionOrVarDeclaration returns [EObject current=null] : iv_rulePExpressionOrVarDeclaration= rulePExpressionOrVarDeclaration EOF ;
    public final EObject entryRulePExpressionOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePExpressionOrVarDeclaration = null;


        try {
            // InternalPerl.g:1824:68: (iv_rulePExpressionOrVarDeclaration= rulePExpressionOrVarDeclaration EOF )
            // InternalPerl.g:1825:2: iv_rulePExpressionOrVarDeclaration= rulePExpressionOrVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPExpressionOrVarDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePExpressionOrVarDeclaration=rulePExpressionOrVarDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePExpressionOrVarDeclaration; 
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
    // $ANTLR end "entryRulePExpressionOrVarDeclaration"


    // $ANTLR start "rulePExpressionOrVarDeclaration"
    // InternalPerl.g:1831:1: rulePExpressionOrVarDeclaration returns [EObject current=null] : (this_PVariableDeclaration_0= rulePVariableDeclaration | this_PExpression_1= rulePExpression ) ;
    public final EObject rulePExpressionOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_PVariableDeclaration_0 = null;

        EObject this_PExpression_1 = null;



        	enterRule();

        try {
            // InternalPerl.g:1837:2: ( (this_PVariableDeclaration_0= rulePVariableDeclaration | this_PExpression_1= rulePExpression ) )
            // InternalPerl.g:1838:2: (this_PVariableDeclaration_0= rulePVariableDeclaration | this_PExpression_1= rulePExpression )
            {
            // InternalPerl.g:1838:2: (this_PVariableDeclaration_0= rulePVariableDeclaration | this_PExpression_1= rulePExpression )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=50 && LA27_0<=52)) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_VAR_START||(LA27_0>=33 && LA27_0<=34)||LA27_0==39) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalPerl.g:1839:3: this_PVariableDeclaration_0= rulePVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPExpressionOrVarDeclarationAccess().getPVariableDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PVariableDeclaration_0=rulePVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PVariableDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1848:3: this_PExpression_1= rulePExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPExpressionOrVarDeclarationAccess().getPExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PExpression_1=rulePExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PExpression_1;
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
    // $ANTLR end "rulePExpressionOrVarDeclaration"


    // $ANTLR start "entryRulePVariableDeclaration"
    // InternalPerl.g:1860:1: entryRulePVariableDeclaration returns [EObject current=null] : iv_rulePVariableDeclaration= rulePVariableDeclaration EOF ;
    public final EObject entryRulePVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePVariableDeclaration = null;


        try {
            // InternalPerl.g:1860:61: (iv_rulePVariableDeclaration= rulePVariableDeclaration EOF )
            // InternalPerl.g:1861:2: iv_rulePVariableDeclaration= rulePVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePVariableDeclaration=rulePVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePVariableDeclaration; 
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
    // $ANTLR end "entryRulePVariableDeclaration"


    // $ANTLR start "rulePVariableDeclaration"
    // InternalPerl.g:1867:1: rulePVariableDeclaration returns [EObject current=null] : ( () (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' ) ( ( ( ( rulePVar ) ) )=> ( (lv_name_4_0= rulePVar ) ) ) (otherlv_5= '=' ( (lv_right_6_0= rulePExpression ) ) )? ) ;
    public final EObject rulePVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_right_6_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1873:2: ( ( () (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' ) ( ( ( ( rulePVar ) ) )=> ( (lv_name_4_0= rulePVar ) ) ) (otherlv_5= '=' ( (lv_right_6_0= rulePExpression ) ) )? ) )
            // InternalPerl.g:1874:2: ( () (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' ) ( ( ( ( rulePVar ) ) )=> ( (lv_name_4_0= rulePVar ) ) ) (otherlv_5= '=' ( (lv_right_6_0= rulePExpression ) ) )? )
            {
            // InternalPerl.g:1874:2: ( () (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' ) ( ( ( ( rulePVar ) ) )=> ( (lv_name_4_0= rulePVar ) ) ) (otherlv_5= '=' ( (lv_right_6_0= rulePExpression ) ) )? )
            // InternalPerl.g:1875:3: () (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' ) ( ( ( ( rulePVar ) ) )=> ( (lv_name_4_0= rulePVar ) ) ) (otherlv_5= '=' ( (lv_right_6_0= rulePExpression ) ) )?
            {
            // InternalPerl.g:1875:3: ()
            // InternalPerl.g:1876:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPVariableDeclarationAccess().getPVariableDeclarationAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:1882:3: (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt28=1;
                }
                break;
            case 51:
                {
                alt28=2;
                }
                break;
            case 52:
                {
                alt28=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalPerl.g:1883:4: otherlv_1= 'my'
                    {
                    otherlv_1=(Token)match(input,50,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPVariableDeclarationAccess().getMyKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1888:4: otherlv_2= 'our'
                    {
                    otherlv_2=(Token)match(input,51,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPVariableDeclarationAccess().getOurKeyword_1_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1893:4: otherlv_3= 'local'
                    {
                    otherlv_3=(Token)match(input,52,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPVariableDeclarationAccess().getLocalKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalPerl.g:1898:3: ( ( ( ( rulePVar ) ) )=> ( (lv_name_4_0= rulePVar ) ) )
            // InternalPerl.g:1899:4: ( ( ( rulePVar ) ) )=> ( (lv_name_4_0= rulePVar ) )
            {
            // InternalPerl.g:1905:4: ( (lv_name_4_0= rulePVar ) )
            // InternalPerl.g:1906:5: (lv_name_4_0= rulePVar )
            {
            // InternalPerl.g:1906:5: (lv_name_4_0= rulePVar )
            // InternalPerl.g:1907:6: lv_name_4_0= rulePVar
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getPVariableDeclarationAccess().getNamePVarParserRuleCall_2_0_0());
              					
            }
            pushFollow(FOLLOW_30);
            lv_name_4_0=rulePVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getPVariableDeclarationRule());
              						}
              						set(
              							current,
              							"name",
              							lv_name_4_0,
              							"org.epic.perl.Perl.PVar");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }

            // InternalPerl.g:1925:3: (otherlv_5= '=' ( (lv_right_6_0= rulePExpression ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==14) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalPerl.g:1926:4: otherlv_5= '=' ( (lv_right_6_0= rulePExpression ) )
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalPerl.g:1930:4: ( (lv_right_6_0= rulePExpression ) )
                    // InternalPerl.g:1931:5: (lv_right_6_0= rulePExpression )
                    {
                    // InternalPerl.g:1931:5: (lv_right_6_0= rulePExpression )
                    // InternalPerl.g:1932:6: lv_right_6_0= rulePExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPVariableDeclarationAccess().getRightPExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_6_0=rulePExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPVariableDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_6_0,
                      							"org.epic.perl.Perl.PExpression");
                      						afterParserOrEnumRuleCall();
                      					
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
    // $ANTLR end "rulePVariableDeclaration"


    // $ANTLR start "entryRulePNumberLiteral"
    // InternalPerl.g:1954:1: entryRulePNumberLiteral returns [EObject current=null] : iv_rulePNumberLiteral= rulePNumberLiteral EOF ;
    public final EObject entryRulePNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePNumberLiteral = null;


        try {
            // InternalPerl.g:1954:55: (iv_rulePNumberLiteral= rulePNumberLiteral EOF )
            // InternalPerl.g:1955:2: iv_rulePNumberLiteral= rulePNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePNumberLiteral=rulePNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePNumberLiteral; 
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
    // $ANTLR end "entryRulePNumberLiteral"


    // $ANTLR start "rulePNumberLiteral"
    // InternalPerl.g:1961:1: rulePNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final EObject rulePNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1967:2: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // InternalPerl.g:1968:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // InternalPerl.g:1968:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // InternalPerl.g:1969:3: () ( (lv_value_1_0= ruleNumber ) )
            {
            // InternalPerl.g:1969:3: ()
            // InternalPerl.g:1970:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPNumberLiteralAccess().getPNumberLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:1976:3: ( (lv_value_1_0= ruleNumber ) )
            // InternalPerl.g:1977:4: (lv_value_1_0= ruleNumber )
            {
            // InternalPerl.g:1977:4: (lv_value_1_0= ruleNumber )
            // InternalPerl.g:1978:5: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPNumberLiteralAccess().getValueNumberParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPNumberLiteralRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.epic.perl.Perl.Number");
              					afterParserOrEnumRuleCall();
              				
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
    // $ANTLR end "rulePNumberLiteral"


    // $ANTLR start "entryRulePNullLiteral"
    // InternalPerl.g:1999:1: entryRulePNullLiteral returns [EObject current=null] : iv_rulePNullLiteral= rulePNullLiteral EOF ;
    public final EObject entryRulePNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePNullLiteral = null;


        try {
            // InternalPerl.g:1999:53: (iv_rulePNullLiteral= rulePNullLiteral EOF )
            // InternalPerl.g:2000:2: iv_rulePNullLiteral= rulePNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPNullLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePNullLiteral=rulePNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePNullLiteral; 
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
    // $ANTLR end "entryRulePNullLiteral"


    // $ANTLR start "rulePNullLiteral"
    // InternalPerl.g:2006:1: rulePNullLiteral returns [EObject current=null] : ( () otherlv_1= 'undef' ) ;
    public final EObject rulePNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPerl.g:2012:2: ( ( () otherlv_1= 'undef' ) )
            // InternalPerl.g:2013:2: ( () otherlv_1= 'undef' )
            {
            // InternalPerl.g:2013:2: ( () otherlv_1= 'undef' )
            // InternalPerl.g:2014:3: () otherlv_1= 'undef'
            {
            // InternalPerl.g:2014:3: ()
            // InternalPerl.g:2015:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPNullLiteralAccess().getPNullLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPNullLiteralAccess().getUndefKeyword_1());
              		
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
    // $ANTLR end "rulePNullLiteral"


    // $ANTLR start "entryRulePReturnExpression"
    // InternalPerl.g:2029:1: entryRulePReturnExpression returns [EObject current=null] : iv_rulePReturnExpression= rulePReturnExpression EOF ;
    public final EObject entryRulePReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePReturnExpression = null;


        try {
            // InternalPerl.g:2029:58: (iv_rulePReturnExpression= rulePReturnExpression EOF )
            // InternalPerl.g:2030:2: iv_rulePReturnExpression= rulePReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePReturnExpression=rulePReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePReturnExpression; 
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
    // $ANTLR end "entryRulePReturnExpression"


    // $ANTLR start "rulePReturnExpression"
    // InternalPerl.g:2036:1: rulePReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | RULE_VAR_START )=> (lv_expression_2_0= rulePExpression ) )? ) ;
    public final EObject rulePReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:2042:2: ( ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | RULE_VAR_START )=> (lv_expression_2_0= rulePExpression ) )? ) )
            // InternalPerl.g:2043:2: ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | RULE_VAR_START )=> (lv_expression_2_0= rulePExpression ) )? )
            {
            // InternalPerl.g:2043:2: ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | RULE_VAR_START )=> (lv_expression_2_0= rulePExpression ) )? )
            // InternalPerl.g:2044:3: () otherlv_1= 'return' ( ( '!' | '-' | '+' | RULE_VAR_START )=> (lv_expression_2_0= rulePExpression ) )?
            {
            // InternalPerl.g:2044:3: ()
            // InternalPerl.g:2045:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPReturnExpressionAccess().getPReturnExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,54,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPReturnExpressionAccess().getReturnKeyword_1());
              		
            }
            // InternalPerl.g:2055:3: ( ( '!' | '-' | '+' | RULE_VAR_START )=> (lv_expression_2_0= rulePExpression ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_VAR_START) && (synpred15_InternalPerl())) {
                alt30=1;
            }
            else if ( (LA30_0==39) && (synpred15_InternalPerl())) {
                alt30=1;
            }
            else if ( (LA30_0==34) && (synpred15_InternalPerl())) {
                alt30=1;
            }
            else if ( (LA30_0==33) && (synpred15_InternalPerl())) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalPerl.g:2056:4: ( '!' | '-' | '+' | RULE_VAR_START )=> (lv_expression_2_0= rulePExpression )
                    {
                    // InternalPerl.g:2057:4: (lv_expression_2_0= rulePExpression )
                    // InternalPerl.g:2058:5: lv_expression_2_0= rulePExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPReturnExpressionAccess().getExpressionPExpressionParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=rulePExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPReturnExpressionRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_2_0,
                      						"org.epic.perl.Perl.PExpression");
                      					afterParserOrEnumRuleCall();
                      				
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
    // $ANTLR end "rulePReturnExpression"


    // $ANTLR start "entryRulePStringLiteral"
    // InternalPerl.g:2079:1: entryRulePStringLiteral returns [EObject current=null] : iv_rulePStringLiteral= rulePStringLiteral EOF ;
    public final EObject entryRulePStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePStringLiteral = null;


        try {
            // InternalPerl.g:2079:55: (iv_rulePStringLiteral= rulePStringLiteral EOF )
            // InternalPerl.g:2080:2: iv_rulePStringLiteral= rulePStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePStringLiteral=rulePStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePStringLiteral; 
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
    // $ANTLR end "entryRulePStringLiteral"


    // $ANTLR start "rulePStringLiteral"
    // InternalPerl.g:2086:1: rulePStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject rulePStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalPerl.g:2092:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalPerl.g:2093:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalPerl.g:2093:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalPerl.g:2094:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalPerl.g:2094:3: ()
            // InternalPerl.g:2095:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPStringLiteralAccess().getPStringLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:2101:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalPerl.g:2102:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalPerl.g:2102:4: (lv_value_1_0= RULE_STRING )
            // InternalPerl.g:2103:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getPStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPStringLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.epic.perl.Perl.STRING");
              				
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
    // $ANTLR end "rulePStringLiteral"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalPerl.g:2123:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalPerl.g:2123:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalPerl.g:2124:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalPerl.g:2130:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalPerl.g:2136:2: ( (this_ID_0= RULE_ID ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )* ) )
            // InternalPerl.g:2137:2: (this_ID_0= RULE_ID ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )* )
            {
            // InternalPerl.g:2137:2: (this_ID_0= RULE_ID ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )* )
            // InternalPerl.g:2138:3: this_ID_0= RULE_ID ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalPerl.g:2145:3: ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==55) && (synpred16_InternalPerl())) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalPerl.g:2146:4: ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID
            	    {
            	    // InternalPerl.g:2146:4: ( ( '::' )=>kw= '::' )
            	    // InternalPerl.g:2147:5: ( '::' )=>kw= '::'
            	    {
            	    kw=(Token)match(input,55,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					current.merge(kw);
            	      					newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0());
            	      				
            	    }

            	    }

            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNumber"
    // InternalPerl.g:2166:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:2168:2: (iv_ruleNumber= ruleNumber EOF )
            // InternalPerl.g:2169:2: iv_ruleNumber= ruleNumber EOF
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
    // InternalPerl.g:2178:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_OCT_2= RULE_OCT | this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;
        Token this_BIN_1=null;
        Token this_OCT_2=null;
        Token this_INT_3=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:2185:2: ( (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_OCT_2= RULE_OCT | this_INT_3= RULE_INT ) )
            // InternalPerl.g:2186:2: (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_OCT_2= RULE_OCT | this_INT_3= RULE_INT )
            {
            // InternalPerl.g:2186:2: (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_OCT_2= RULE_OCT | this_INT_3= RULE_INT )
            int alt32=4;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt32=1;
                }
                break;
            case RULE_BIN:
                {
                alt32=2;
                }
                break;
            case RULE_OCT:
                {
                alt32=3;
                }
                break;
            case RULE_INT:
                {
                alt32=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalPerl.g:2187:3: this_HEX_0= RULE_HEX
                    {
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_HEX_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:2195:3: this_BIN_1= RULE_BIN
                    {
                    this_BIN_1=(Token)match(input,RULE_BIN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_BIN_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_BIN_1, grammarAccess.getNumberAccess().getBINTerminalRuleCall_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:2203:3: this_OCT_2= RULE_OCT
                    {
                    this_OCT_2=(Token)match(input,RULE_OCT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_OCT_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_OCT_2, grammarAccess.getNumberAccess().getOCTTerminalRuleCall_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:2211:3: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_INT_3);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_INT_3, grammarAccess.getNumberAccess().getINTTerminalRuleCall_3());
                      		
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"

    // $ANTLR start synpred1_InternalPerl
    public final void synpred1_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:170:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // InternalPerl.g:170:7: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // InternalPerl.g:170:7: ( () ( ( ruleOpMultiAssign ) ) )
        // InternalPerl.g:171:7: () ( ( ruleOpMultiAssign ) )
        {
        // InternalPerl.g:171:7: ()
        // InternalPerl.g:172:7: 
        {
        }

        // InternalPerl.g:173:7: ( ( ruleOpMultiAssign ) )
        // InternalPerl.g:174:8: ( ruleOpMultiAssign )
        {
        // InternalPerl.g:174:8: ( ruleOpMultiAssign )
        // InternalPerl.g:175:9: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_2);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalPerl

    // $ANTLR start synpred2_InternalPerl
    public final void synpred2_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:373:5: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalPerl.g:373:6: ( () ( ( ruleOpOr ) ) )
        {
        // InternalPerl.g:373:6: ( () ( ( ruleOpOr ) ) )
        // InternalPerl.g:374:6: () ( ( ruleOpOr ) )
        {
        // InternalPerl.g:374:6: ()
        // InternalPerl.g:375:6: 
        {
        }

        // InternalPerl.g:376:6: ( ( ruleOpOr ) )
        // InternalPerl.g:377:7: ( ruleOpOr )
        {
        // InternalPerl.g:377:7: ( ruleOpOr )
        // InternalPerl.g:378:8: ruleOpOr
        {
        pushFollow(FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalPerl

    // $ANTLR start synpred3_InternalPerl
    public final void synpred3_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:483:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalPerl.g:483:6: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalPerl.g:483:6: ( () ( ( ruleOpAnd ) ) )
        // InternalPerl.g:484:6: () ( ( ruleOpAnd ) )
        {
        // InternalPerl.g:484:6: ()
        // InternalPerl.g:485:6: 
        {
        }

        // InternalPerl.g:486:6: ( ( ruleOpAnd ) )
        // InternalPerl.g:487:7: ( ruleOpAnd )
        {
        // InternalPerl.g:487:7: ( ruleOpAnd )
        // InternalPerl.g:488:8: ruleOpAnd
        {
        pushFollow(FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalPerl

    // $ANTLR start synpred4_InternalPerl
    public final void synpred4_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:593:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalPerl.g:593:6: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalPerl.g:593:6: ( () ( ( ruleOpEquality ) ) )
        // InternalPerl.g:594:6: () ( ( ruleOpEquality ) )
        {
        // InternalPerl.g:594:6: ()
        // InternalPerl.g:595:6: 
        {
        }

        // InternalPerl.g:596:6: ( ( ruleOpEquality ) )
        // InternalPerl.g:597:7: ( ruleOpEquality )
        {
        // InternalPerl.g:597:7: ( ruleOpEquality )
        // InternalPerl.g:598:8: ruleOpEquality
        {
        pushFollow(FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalPerl

    // $ANTLR start synpred5_InternalPerl
    public final void synpred5_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:723:5: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalPerl.g:723:6: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalPerl.g:723:6: ( () ( ( ruleOpCompare ) ) )
        // InternalPerl.g:724:6: () ( ( ruleOpCompare ) )
        {
        // InternalPerl.g:724:6: ()
        // InternalPerl.g:725:6: 
        {
        }

        // InternalPerl.g:726:6: ( ( ruleOpCompare ) )
        // InternalPerl.g:727:7: ( ruleOpCompare )
        {
        // InternalPerl.g:727:7: ( ruleOpCompare )
        // InternalPerl.g:728:8: ruleOpCompare
        {
        pushFollow(FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalPerl

    // $ANTLR start synpred6_InternalPerl
    public final void synpred6_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:860:5: ( ( () ( ( ruleOpOther ) ) ) )
        // InternalPerl.g:860:6: ( () ( ( ruleOpOther ) ) )
        {
        // InternalPerl.g:860:6: ( () ( ( ruleOpOther ) ) )
        // InternalPerl.g:861:6: () ( ( ruleOpOther ) )
        {
        // InternalPerl.g:861:6: ()
        // InternalPerl.g:862:6: 
        {
        }

        // InternalPerl.g:863:6: ( ( ruleOpOther ) )
        // InternalPerl.g:864:7: ( ruleOpOther )
        {
        // InternalPerl.g:864:7: ( ruleOpOther )
        // InternalPerl.g:865:8: ruleOpOther
        {
        pushFollow(FOLLOW_2);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalPerl

    // $ANTLR start synpred7_InternalPerl
    public final void synpred7_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:946:6: ( ( '>' '>' ) )
        // InternalPerl.g:946:7: ( '>' '>' )
        {
        // InternalPerl.g:946:7: ( '>' '>' )
        // InternalPerl.g:947:7: '>' '>'
        {
        match(input,22,FOLLOW_14); if (state.failed) return ;
        match(input,22,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalPerl

    // $ANTLR start synpred8_InternalPerl
    public final void synpred8_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:981:6: ( ( '<' '<' ) )
        // InternalPerl.g:981:7: ( '<' '<' )
        {
        // InternalPerl.g:981:7: ( '<' '<' )
        // InternalPerl.g:982:7: '<' '<'
        {
        match(input,21,FOLLOW_6); if (state.failed) return ;
        match(input,21,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalPerl

    // $ANTLR start synpred9_InternalPerl
    public final void synpred9_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:1054:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalPerl.g:1054:6: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalPerl.g:1054:6: ( () ( ( ruleOpAdd ) ) )
        // InternalPerl.g:1055:6: () ( ( ruleOpAdd ) )
        {
        // InternalPerl.g:1055:6: ()
        // InternalPerl.g:1056:6: 
        {
        }

        // InternalPerl.g:1057:6: ( ( ruleOpAdd ) )
        // InternalPerl.g:1058:7: ( ruleOpAdd )
        {
        // InternalPerl.g:1058:7: ( ruleOpAdd )
        // InternalPerl.g:1059:8: ruleOpAdd
        {
        pushFollow(FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalPerl

    // $ANTLR start synpred10_InternalPerl
    public final void synpred10_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:1172:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalPerl.g:1172:6: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalPerl.g:1172:6: ( () ( ( ruleOpMulti ) ) )
        // InternalPerl.g:1173:6: () ( ( ruleOpMulti ) )
        {
        // InternalPerl.g:1173:6: ()
        // InternalPerl.g:1174:6: 
        {
        }

        // InternalPerl.g:1175:6: ( ( ruleOpMulti ) )
        // InternalPerl.g:1176:7: ( ruleOpMulti )
        {
        // InternalPerl.g:1176:7: ( ruleOpMulti )
        // InternalPerl.g:1177:8: ruleOpMulti
        {
        pushFollow(FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalPerl

    // $ANTLR start synpred11_InternalPerl
    public final void synpred11_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:1456:4: ( ( () 'sub' '{' ) )
        // InternalPerl.g:1456:5: ( () 'sub' '{' )
        {
        // InternalPerl.g:1456:5: ( () 'sub' '{' )
        // InternalPerl.g:1457:5: () 'sub' '{'
        {
        // InternalPerl.g:1457:5: ()
        // InternalPerl.g:1458:5: 
        {
        }

        match(input,42,FOLLOW_19); if (state.failed) return ;
        match(input,43,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalPerl

    // $ANTLR start synpred13_InternalPerl
    public final void synpred13_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:1733:5: ( 'else' )
        // InternalPerl.g:1733:6: 'else'
        {
        match(input,49,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalPerl

    // $ANTLR start synpred15_InternalPerl
    public final void synpred15_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:2056:4: ( '!' | '-' | '+' | RULE_VAR_START )
        // InternalPerl.g:
        {
        if ( input.LA(1)==RULE_VAR_START||(input.LA(1)>=33 && input.LA(1)<=34)||input.LA(1)==39 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred15_InternalPerl

    // $ANTLR start synpred16_InternalPerl
    public final void synpred16_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:2147:5: ( '::' )
        // InternalPerl.g:2147:6: '::'
        {
        match(input,55,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalPerl

    // Delegated rules

    public final boolean synpred10_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\11\11\uffff";
    static final String dfa_3s = "\1\4\11\uffff";
    static final String dfa_4s = "\1\64\11\uffff";
    static final String dfa_5s = "\1\uffff\10\1\1\2";
    static final String dfa_6s = "\1\0\11\uffff}>";
    static final String[] dfa_7s = {
            "\1\11\12\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\12\uffff\2\11\4\uffff\1\11\4\uffff\2\11\1\uffff\1\11\1\uffff\4\11",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "168:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_0 = input.LA(1);

                         
                        int index1_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA1_0==15) && (synpred1_InternalPerl())) {s = 1;}

                        else if ( (LA1_0==16) && (synpred1_InternalPerl())) {s = 2;}

                        else if ( (LA1_0==17) && (synpred1_InternalPerl())) {s = 3;}

                        else if ( (LA1_0==18) && (synpred1_InternalPerl())) {s = 4;}

                        else if ( (LA1_0==19) && (synpred1_InternalPerl())) {s = 5;}

                        else if ( (LA1_0==20) && (synpred1_InternalPerl())) {s = 6;}

                        else if ( (LA1_0==21) && (synpred1_InternalPerl())) {s = 7;}

                        else if ( (LA1_0==22) && (synpred1_InternalPerl())) {s = 8;}

                        else if ( (LA1_0==EOF||LA1_0==RULE_VAR_START||(LA1_0>=33 && LA1_0<=34)||LA1_0==39||(LA1_0>=44 && LA1_0<=45)||LA1_0==47||(LA1_0>=49 && LA1_0<=52)) ) {s = 9;}

                         
                        input.seek(index1_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\16\uffff";
    static final String dfa_9s = "\1\1\15\uffff";
    static final String dfa_10s = "\1\4\1\uffff\1\16\1\26\2\uffff\1\16\1\uffff\1\26\5\uffff";
    static final String dfa_11s = "\1\64\1\uffff\2\47\2\uffff\1\47\1\uffff\1\47\5\uffff";
    static final String dfa_12s = "\1\uffff\1\2\2\uffff\2\1\1\uffff\1\1\1\uffff\5\1";
    static final String dfa_13s = "\1\1\1\uffff\1\2\3\uffff\1\3\1\uffff\1\0\5\uffff}>";
    static final String[] dfa_14s = {
            "\1\1\12\uffff\6\1\1\2\1\3\7\1\1\uffff\1\4\1\5\2\1\4\uffff\1\1\4\uffff\2\1\1\uffff\1\1\1\uffff\4\1",
            "",
            "\1\1\6\uffff\1\6\10\uffff\1\7\2\uffff\2\1\4\uffff\1\1",
            "\1\10\1\1\11\uffff\2\1\4\uffff\1\1",
            "",
            "",
            "\1\1\6\uffff\1\14\13\uffff\1\13\1\12\4\uffff\1\11",
            "",
            "\1\15\1\1\11\uffff\1\13\1\12\4\uffff\1\11",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 858:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= rulePAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_8 = input.LA(1);

                         
                        int index11_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_8==23) ) {s = 1;}

                        else if ( (LA11_8==22) && (synpred6_InternalPerl())) {s = 13;}

                        else if ( (LA11_8==39) && (synpred6_InternalPerl())) {s = 9;}

                        else if ( (LA11_8==34) && (synpred6_InternalPerl())) {s = 10;}

                        else if ( (LA11_8==33) && (synpred6_InternalPerl())) {s = 11;}

                         
                        input.seek(index11_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_0 = input.LA(1);

                         
                        int index11_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_0==EOF||LA11_0==RULE_VAR_START||(LA11_0>=15 && LA11_0<=20)||(LA11_0>=23 && LA11_0<=29)||(LA11_0>=33 && LA11_0<=34)||LA11_0==39||(LA11_0>=44 && LA11_0<=45)||LA11_0==47||(LA11_0>=49 && LA11_0<=52)) ) {s = 1;}

                        else if ( (LA11_0==21) ) {s = 2;}

                        else if ( (LA11_0==22) ) {s = 3;}

                        else if ( (LA11_0==31) && (synpred6_InternalPerl())) {s = 4;}

                        else if ( (LA11_0==32) && (synpred6_InternalPerl())) {s = 5;}

                         
                        input.seek(index11_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_2 = input.LA(1);

                         
                        int index11_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_2==21) ) {s = 6;}

                        else if ( (LA11_2==30) && (synpred6_InternalPerl())) {s = 7;}

                        else if ( (LA11_2==14||(LA11_2>=33 && LA11_2<=34)||LA11_2==39) ) {s = 1;}

                         
                        input.seek(index11_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_6 = input.LA(1);

                         
                        int index11_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_6==14) ) {s = 1;}

                        else if ( (LA11_6==39) && (synpred6_InternalPerl())) {s = 9;}

                        else if ( (LA11_6==34) && (synpred6_InternalPerl())) {s = 10;}

                        else if ( (LA11_6==33) && (synpred6_InternalPerl())) {s = 11;}

                        else if ( (LA11_6==21) && (synpred6_InternalPerl())) {s = 12;}

                         
                        input.seek(index11_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\37\uffff";
    static final String dfa_16s = "\1\1\36\uffff";
    static final String dfa_17s = "\1\4\33\uffff\2\0\1\uffff";
    static final String dfa_18s = "\1\64\33\uffff\2\0\1\uffff";
    static final String dfa_19s = "\1\uffff\1\2\34\uffff\1\1";
    static final String dfa_20s = "\34\uffff\1\0\1\1\1\uffff}>";
    static final String[] dfa_21s = {
            "\1\1\12\uffff\17\1\1\uffff\2\1\1\35\1\34\4\uffff\1\1\4\uffff\2\1\1\uffff\1\1\1\uffff\4\1",
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
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "()* loopback of 1052:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_28 = input.LA(1);

                         
                        int index15_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalPerl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index15_28);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_29 = input.LA(1);

                         
                        int index15_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalPerl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index15_29);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000008600000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000007F8002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000003C000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000180600002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000040200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000007800000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x001C108600000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x001C208600000012L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x001C008600000012L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x001C008600000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x001C308600000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0080000000000002L});

}