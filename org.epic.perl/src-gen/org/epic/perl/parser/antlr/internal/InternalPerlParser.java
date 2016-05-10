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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'**='", "'<'", "'>'", "'>='", "'||'", "'&&'", "'=='", "'!='", "'eq'", "'ne'", "'->'", "'..<'", "'..'", "'=>'", "'<>'", "'?:'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'++'", "'--'", "'sub'", "'{'", "'}'", "';'", "'('", "')'", "'if'", "'else'", "'my'", "'our'", "'local'", "'$'", "'@'", "'undef'", "'return'", "'::'"
    };
    public static final int RULE_HEX=6;
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
    public static final int RULE_BIN=7;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
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
    // InternalPerl.g:96:1: rulePAssignment returns [EObject current=null] : ( ( () ( (lv_feature_1_0= ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) ) | (this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )? ) ) ;
    public final EObject rulePAssignment() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_feature_1_0 = null;

        EObject lv_value_3_0 = null;

        EObject this_POrExpression_4 = null;

        AntlrDatatypeRuleToken lv_feature_6_0 = null;

        EObject lv_rightOperand_7_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:102:2: ( ( ( () ( (lv_feature_1_0= ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) ) | (this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )? ) ) )
            // InternalPerl.g:103:2: ( ( () ( (lv_feature_1_0= ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) ) | (this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )? ) )
            {
            // InternalPerl.g:103:2: ( ( () ( (lv_feature_1_0= ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) ) | (this_POrExpression_4= rulePOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( (lv_feature_6_0= ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= rulePAssignment ) ) )? ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==39||(LA2_0>=54 && LA2_0<=55)) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=34 && LA2_0<=35)||LA2_0==40) ) {
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
                    // InternalPerl.g:104:3: ( () ( (lv_feature_1_0= ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) )
                    {
                    // InternalPerl.g:104:3: ( () ( (lv_feature_1_0= ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) ) )
                    // InternalPerl.g:105:4: () ( (lv_feature_1_0= ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= rulePAssignment ) )
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

                    // InternalPerl.g:112:4: ( (lv_feature_1_0= ruleFeatureCallID ) )
                    // InternalPerl.g:113:5: (lv_feature_1_0= ruleFeatureCallID )
                    {
                    // InternalPerl.g:113:5: (lv_feature_1_0= ruleFeatureCallID )
                    // InternalPerl.g:114:6: lv_feature_1_0= ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPAssignmentAccess().getFeatureFeatureCallIDParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_3);
                    lv_feature_1_0=ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"feature",
                      							lv_feature_1_0,
                      							"org.epic.perl.Perl.FeatureCallID");
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
            kw=(Token)match(input,12,FOLLOW_2); if (state.failed) return current;
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
            case 13:
                {
                alt4=1;
                }
                break;
            case 14:
                {
                alt4=2;
                }
                break;
            case 15:
                {
                alt4=3;
                }
                break;
            case 16:
                {
                alt4=4;
                }
                break;
            case 17:
                {
                alt4=5;
                }
                break;
            case 18:
                {
                alt4=6;
                }
                break;
            case 19:
                {
                alt4=7;
                }
                break;
            case 20:
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
                    kw=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:277:3: kw= '-='
                    {
                    kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:283:3: kw= '*='
                    {
                    kw=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:289:3: kw= '/='
                    {
                    kw=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalPerl.g:295:3: kw= '%='
                    {
                    kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalPerl.g:301:3: kw= '**='
                    {
                    kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
                    kw=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_0());
                      			
                    }
                    kw=(Token)match(input,19,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_1());
                      			
                    }
                    kw=(Token)match(input,12,FOLLOW_2); if (state.failed) return current;
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
                    kw=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_0());
                      			
                    }
                    // InternalPerl.g:331:4: (kw= '>' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==20) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalPerl.g:332:5: kw= '>'
                            {
                            kw=(Token)match(input,20,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_1());
                              				
                            }

                            }
                            break;

                    }

                    kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
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

                if ( (LA5_0==22) && (synpred2_InternalPerl())) {
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
            kw=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
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

                if ( (LA6_0==23) && (synpred3_InternalPerl())) {
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
            kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
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

                if ( (LA7_0==24) && (synpred4_InternalPerl())) {
                    alt7=1;
                }
                else if ( (LA7_0==25) && (synpred4_InternalPerl())) {
                    alt7=1;
                }
                else if ( (LA7_0==26) && (synpred4_InternalPerl())) {
                    alt7=1;
                }
                else if ( (LA7_0==27) && (synpred4_InternalPerl())) {
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
            case 24:
                {
                alt8=1;
                }
                break;
            case 25:
                {
                alt8=2;
                }
                break;
            case 26:
                {
                alt8=3;
                }
                break;
            case 27:
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
                    kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:677:3: kw= '!='
                    {
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:683:3: kw= 'eq'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:689:3: kw= 'ne'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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

                if ( (LA9_0==19) ) {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2==40) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }
                    else if ( (LA9_2==35) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }
                    else if ( (LA9_2==34) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }
                    else if ( (LA9_2==12) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==20) ) {
                    int LA9_3 = input.LA(2);

                    if ( (LA9_3==40) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }
                    else if ( (LA9_3==35) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }
                    else if ( (LA9_3==34) && (synpred5_InternalPerl())) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==21) && (synpred5_InternalPerl())) {
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
            case 21:
                {
                alt10=1;
                }
                break;
            case 19:
                {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==EOF||(LA10_2>=34 && LA10_2<=35)||LA10_2==40) ) {
                    alt10=4;
                }
                else if ( (LA10_2==12) ) {
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
            case 20:
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
                    kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
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
                    kw=(Token)match(input,19,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    kw=(Token)match(input,12,FOLLOW_2); if (state.failed) return current;
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
                    kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:826:3: kw= '<'
                    {
                    kw=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
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
    // InternalPerl.g:930:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:936:2: ( (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) )
            // InternalPerl.g:937:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            {
            // InternalPerl.g:937:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            int alt14=9;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // InternalPerl.g:938:3: kw= '->'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:944:3: kw= '..<'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:950:3: (kw= '>' kw= '..' )
                    {
                    // InternalPerl.g:950:3: (kw= '>' kw= '..' )
                    // InternalPerl.g:951:4: kw= '>' kw= '..'
                    {
                    kw=(Token)match(input,20,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0());
                      			
                    }
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalPerl.g:963:3: kw= '..'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalPerl.g:969:3: kw= '=>'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalPerl.g:975:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    {
                    // InternalPerl.g:975:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    // InternalPerl.g:976:4: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    {
                    kw=(Token)match(input,20,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0());
                      			
                    }
                    // InternalPerl.g:981:4: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==20) ) {
                        int LA12_1 = input.LA(2);

                        if ( (LA12_1==20) && (synpred7_InternalPerl())) {
                            alt12=1;
                        }
                        else if ( (LA12_1==EOF||(LA12_1>=34 && LA12_1<=35)||LA12_1==40) ) {
                            alt12=2;
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
                            // InternalPerl.g:982:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            {
                            // InternalPerl.g:982:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            // InternalPerl.g:983:6: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
                            {
                            // InternalPerl.g:988:6: (kw= '>' kw= '>' )
                            // InternalPerl.g:989:7: kw= '>' kw= '>'
                            {
                            kw=(Token)match(input,20,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0());
                              						
                            }
                            kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1());
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalPerl.g:1002:5: kw= '>'
                            {
                            kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalPerl.g:1010:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    {
                    // InternalPerl.g:1010:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    // InternalPerl.g:1011:4: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    {
                    kw=(Token)match(input,19,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0());
                      			
                    }
                    // InternalPerl.g:1016:4: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    int alt13=3;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==19) ) {
                        int LA13_1 = input.LA(2);

                        if ( (LA13_1==EOF||(LA13_1>=34 && LA13_1<=35)||LA13_1==40) ) {
                            alt13=2;
                        }
                        else if ( (LA13_1==19) && (synpred8_InternalPerl())) {
                            alt13=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA13_0==31) ) {
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
                            // InternalPerl.g:1017:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            {
                            // InternalPerl.g:1017:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            // InternalPerl.g:1018:6: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
                            {
                            // InternalPerl.g:1023:6: (kw= '<' kw= '<' )
                            // InternalPerl.g:1024:7: kw= '<' kw= '<'
                            {
                            kw=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0());
                              						
                            }
                            kw=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1());
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalPerl.g:1037:5: kw= '<'
                            {
                            kw=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalPerl.g:1043:5: kw= '=>'
                            {
                            kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:1051:3: kw= '<>'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalPerl.g:1057:3: kw= '?:'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8());
                      		
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
    // InternalPerl.g:1066:1: entryRulePAdditiveExpression returns [EObject current=null] : iv_rulePAdditiveExpression= rulePAdditiveExpression EOF ;
    public final EObject entryRulePAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAdditiveExpression = null;


        try {
            // InternalPerl.g:1066:60: (iv_rulePAdditiveExpression= rulePAdditiveExpression EOF )
            // InternalPerl.g:1067:2: iv_rulePAdditiveExpression= rulePAdditiveExpression EOF
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
    // InternalPerl.g:1073:1: rulePAdditiveExpression returns [EObject current=null] : (this_PMultiplicativeExpression_0= rulePMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )* ) ;
    public final EObject rulePAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PMultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1079:2: ( (this_PMultiplicativeExpression_0= rulePMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )* ) )
            // InternalPerl.g:1080:2: (this_PMultiplicativeExpression_0= rulePMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )* )
            {
            // InternalPerl.g:1080:2: (this_PMultiplicativeExpression_0= rulePMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )* )
            // InternalPerl.g:1081:3: this_PMultiplicativeExpression_0= rulePMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPAdditiveExpressionAccess().getPMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_17);
            this_PMultiplicativeExpression_0=rulePMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PMultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalPerl.g:1089:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // InternalPerl.g:1090:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) )
            	    {
            	    // InternalPerl.g:1090:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) )
            	    // InternalPerl.g:1091:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    {
            	    // InternalPerl.g:1101:5: ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    // InternalPerl.g:1102:6: () ( (lv_feature_2_0= ruleOpAdd ) )
            	    {
            	    // InternalPerl.g:1102:6: ()
            	    // InternalPerl.g:1103:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPAdditiveExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalPerl.g:1109:6: ( (lv_feature_2_0= ruleOpAdd ) )
            	    // InternalPerl.g:1110:7: (lv_feature_2_0= ruleOpAdd )
            	    {
            	    // InternalPerl.g:1110:7: (lv_feature_2_0= ruleOpAdd )
            	    // InternalPerl.g:1111:8: lv_feature_2_0= ruleOpAdd
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

            	    // InternalPerl.g:1130:4: ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) )
            	    // InternalPerl.g:1131:5: (lv_rightOperand_3_0= rulePMultiplicativeExpression )
            	    {
            	    // InternalPerl.g:1131:5: (lv_rightOperand_3_0= rulePMultiplicativeExpression )
            	    // InternalPerl.g:1132:6: lv_rightOperand_3_0= rulePMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPAdditiveExpressionAccess().getRightOperandPMultiplicativeExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
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
    // InternalPerl.g:1154:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalPerl.g:1154:45: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalPerl.g:1155:2: iv_ruleOpAdd= ruleOpAdd EOF
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
    // InternalPerl.g:1161:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:1167:2: ( (kw= '+' | kw= '-' ) )
            // InternalPerl.g:1168:2: (kw= '+' | kw= '-' )
            {
            // InternalPerl.g:1168:2: (kw= '+' | kw= '-' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==34) ) {
                alt16=1;
            }
            else if ( (LA16_0==35) ) {
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
                    // InternalPerl.g:1169:3: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1175:3: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
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
    // InternalPerl.g:1184:1: entryRulePMultiplicativeExpression returns [EObject current=null] : iv_rulePMultiplicativeExpression= rulePMultiplicativeExpression EOF ;
    public final EObject entryRulePMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePMultiplicativeExpression = null;


        try {
            // InternalPerl.g:1184:66: (iv_rulePMultiplicativeExpression= rulePMultiplicativeExpression EOF )
            // InternalPerl.g:1185:2: iv_rulePMultiplicativeExpression= rulePMultiplicativeExpression EOF
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
    // InternalPerl.g:1191:1: rulePMultiplicativeExpression returns [EObject current=null] : (this_PUnaryOperation_0= rulePUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )* ) ;
    public final EObject rulePMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PUnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1197:2: ( (this_PUnaryOperation_0= rulePUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )* ) )
            // InternalPerl.g:1198:2: (this_PUnaryOperation_0= rulePUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )* )
            {
            // InternalPerl.g:1198:2: (this_PUnaryOperation_0= rulePUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )* )
            // InternalPerl.g:1199:3: this_PUnaryOperation_0= rulePUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPMultiplicativeExpressionAccess().getPUnaryOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_18);
            this_PUnaryOperation_0=rulePUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PUnaryOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalPerl.g:1207:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==39) ) {
                    int LA17_2 = input.LA(2);

                    if ( (LA17_2==40) && (synpred10_InternalPerl())) {
                        alt17=1;
                    }
                    else if ( (LA17_2==35) && (synpred10_InternalPerl())) {
                        alt17=1;
                    }
                    else if ( (LA17_2==34) && (synpred10_InternalPerl())) {
                        alt17=1;
                    }


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
            	    // InternalPerl.g:1208:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= rulePUnaryOperation ) )
            	    {
            	    // InternalPerl.g:1208:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) )
            	    // InternalPerl.g:1209:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    {
            	    // InternalPerl.g:1219:5: ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    // InternalPerl.g:1220:6: () ( (lv_feature_2_0= ruleOpMulti ) )
            	    {
            	    // InternalPerl.g:1220:6: ()
            	    // InternalPerl.g:1221:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPMultiplicativeExpressionAccess().getPBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalPerl.g:1227:6: ( (lv_feature_2_0= ruleOpMulti ) )
            	    // InternalPerl.g:1228:7: (lv_feature_2_0= ruleOpMulti )
            	    {
            	    // InternalPerl.g:1228:7: (lv_feature_2_0= ruleOpMulti )
            	    // InternalPerl.g:1229:8: lv_feature_2_0= ruleOpMulti
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

            	    // InternalPerl.g:1248:4: ( (lv_rightOperand_3_0= rulePUnaryOperation ) )
            	    // InternalPerl.g:1249:5: (lv_rightOperand_3_0= rulePUnaryOperation )
            	    {
            	    // InternalPerl.g:1249:5: (lv_rightOperand_3_0= rulePUnaryOperation )
            	    // InternalPerl.g:1250:6: lv_rightOperand_3_0= rulePUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPMultiplicativeExpressionAccess().getRightOperandPUnaryOperationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
    // InternalPerl.g:1272:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalPerl.g:1272:47: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalPerl.g:1273:2: iv_ruleOpMulti= ruleOpMulti EOF
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
    // InternalPerl.g:1279:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:1285:2: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // InternalPerl.g:1286:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // InternalPerl.g:1286:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt18=1;
                }
                break;
            case 37:
                {
                alt18=2;
                }
                break;
            case 38:
                {
                alt18=3;
                }
                break;
            case 39:
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
                    // InternalPerl.g:1287:3: kw= '*'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1293:3: kw= '**'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1299:3: kw= '/'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:1305:3: kw= '%'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
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
    // InternalPerl.g:1314:1: entryRulePUnaryOperation returns [EObject current=null] : iv_rulePUnaryOperation= rulePUnaryOperation EOF ;
    public final EObject entryRulePUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePUnaryOperation = null;


        try {
            // InternalPerl.g:1314:56: (iv_rulePUnaryOperation= rulePUnaryOperation EOF )
            // InternalPerl.g:1315:2: iv_rulePUnaryOperation= rulePUnaryOperation EOF
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
    // InternalPerl.g:1321:1: rulePUnaryOperation returns [EObject current=null] : ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= rulePUnaryOperation ) ) ) ;
    public final EObject rulePUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_feature_1_0 = null;

        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1327:2: ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= rulePUnaryOperation ) ) ) )
            // InternalPerl.g:1328:2: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= rulePUnaryOperation ) ) )
            {
            // InternalPerl.g:1328:2: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= rulePUnaryOperation ) ) )
            // InternalPerl.g:1329:3: () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= rulePUnaryOperation ) )
            {
            // InternalPerl.g:1329:3: ()
            // InternalPerl.g:1330:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPUnaryOperationAccess().getPUnaryOperationAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:1336:3: ( (lv_feature_1_0= ruleOpUnary ) )
            // InternalPerl.g:1337:4: (lv_feature_1_0= ruleOpUnary )
            {
            // InternalPerl.g:1337:4: (lv_feature_1_0= ruleOpUnary )
            // InternalPerl.g:1338:5: lv_feature_1_0= ruleOpUnary
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

            // InternalPerl.g:1355:3: ( (lv_operand_2_0= rulePUnaryOperation ) )
            // InternalPerl.g:1356:4: (lv_operand_2_0= rulePUnaryOperation )
            {
            // InternalPerl.g:1356:4: (lv_operand_2_0= rulePUnaryOperation )
            // InternalPerl.g:1357:5: lv_operand_2_0= rulePUnaryOperation
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
    // InternalPerl.g:1378:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalPerl.g:1378:47: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalPerl.g:1379:2: iv_ruleOpUnary= ruleOpUnary EOF
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
    // InternalPerl.g:1385:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:1391:2: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // InternalPerl.g:1392:2: (kw= '!' | kw= '-' | kw= '+' )
            {
            // InternalPerl.g:1392:2: (kw= '!' | kw= '-' | kw= '+' )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt19=1;
                }
                break;
            case 35:
                {
                alt19=2;
                }
                break;
            case 34:
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
                    // InternalPerl.g:1393:3: kw= '!'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1399:3: kw= '-'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1405:3: kw= '+'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
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
    // InternalPerl.g:1414:1: entryRuleOpPostfix returns [String current=null] : iv_ruleOpPostfix= ruleOpPostfix EOF ;
    public final String entryRuleOpPostfix() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpPostfix = null;


        try {
            // InternalPerl.g:1414:49: (iv_ruleOpPostfix= ruleOpPostfix EOF )
            // InternalPerl.g:1415:2: iv_ruleOpPostfix= ruleOpPostfix EOF
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
    // InternalPerl.g:1421:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' | kw= '--' ) ;
    public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:1427:2: ( (kw= '++' | kw= '--' ) )
            // InternalPerl.g:1428:2: (kw= '++' | kw= '--' )
            {
            // InternalPerl.g:1428:2: (kw= '++' | kw= '--' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==41) ) {
                alt20=1;
            }
            else if ( (LA20_0==42) ) {
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
                    // InternalPerl.g:1429:3: kw= '++'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1435:3: kw= '--'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRulePMemberFeatureCall"
    // InternalPerl.g:1444:1: entryRulePMemberFeatureCall returns [EObject current=null] : iv_rulePMemberFeatureCall= rulePMemberFeatureCall EOF ;
    public final EObject entryRulePMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePMemberFeatureCall = null;


        try {
            // InternalPerl.g:1444:59: (iv_rulePMemberFeatureCall= rulePMemberFeatureCall EOF )
            // InternalPerl.g:1445:2: iv_rulePMemberFeatureCall= rulePMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePMemberFeatureCall=rulePMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePMemberFeatureCall; 
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
    // $ANTLR end "entryRulePMemberFeatureCall"


    // $ANTLR start "rulePMemberFeatureCall"
    // InternalPerl.g:1451:1: rulePMemberFeatureCall returns [EObject current=null] : (this_PPrimaryExpression_0= rulePPrimaryExpression ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_4_0= rulePAssignment ) ) ) ) ;
    public final EObject rulePMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject this_PPrimaryExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1457:2: ( (this_PPrimaryExpression_0= rulePPrimaryExpression ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_4_0= rulePAssignment ) ) ) ) )
            // InternalPerl.g:1458:2: (this_PPrimaryExpression_0= rulePPrimaryExpression ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_4_0= rulePAssignment ) ) ) )
            {
            // InternalPerl.g:1458:2: (this_PPrimaryExpression_0= rulePPrimaryExpression ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_4_0= rulePAssignment ) ) ) )
            // InternalPerl.g:1459:3: this_PPrimaryExpression_0= rulePPrimaryExpression ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_4_0= rulePAssignment ) ) )
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPMemberFeatureCallAccess().getPPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_19);
            this_PPrimaryExpression_0=rulePPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PPrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalPerl.g:1467:3: ( ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_4_0= rulePAssignment ) ) )
            // InternalPerl.g:1468:4: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_4_0= rulePAssignment ) )
            {
            // InternalPerl.g:1468:4: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign ) )
            // InternalPerl.g:1469:5: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign )
            {
            // InternalPerl.g:1480:5: ( () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign )
            // InternalPerl.g:1481:6: () ( (lv_feature_2_0= ruleFeatureCallID ) ) ruleOpSingleAssign
            {
            // InternalPerl.g:1481:6: ()
            // InternalPerl.g:1482:7: 
            {
            if ( state.backtracking==0 ) {

              							current = forceCreateModelElementAndSet(
              								grammarAccess.getPMemberFeatureCallAccess().getPAssignmentAssignableAction_1_0_0_0(),
              								current);
              						
            }

            }

            // InternalPerl.g:1488:6: ( (lv_feature_2_0= ruleFeatureCallID ) )
            // InternalPerl.g:1489:7: (lv_feature_2_0= ruleFeatureCallID )
            {
            // InternalPerl.g:1489:7: (lv_feature_2_0= ruleFeatureCallID )
            // InternalPerl.g:1490:8: lv_feature_2_0= ruleFeatureCallID
            {
            if ( state.backtracking==0 ) {

              								newCompositeNode(grammarAccess.getPMemberFeatureCallAccess().getFeatureFeatureCallIDParserRuleCall_1_0_0_1_0());
              							
            }
            pushFollow(FOLLOW_3);
            lv_feature_2_0=ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              								if (current==null) {
              									current = createModelElementForParent(grammarAccess.getPMemberFeatureCallRule());
              								}
              								set(
              									current,
              									"feature",
              									lv_feature_2_0,
              									"org.epic.perl.Perl.FeatureCallID");
              								afterParserOrEnumRuleCall();
              							
            }

            }


            }

            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getPMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_2());
              					
            }
            pushFollow(FOLLOW_4);
            ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            // InternalPerl.g:1516:4: ( (lv_value_4_0= rulePAssignment ) )
            // InternalPerl.g:1517:5: (lv_value_4_0= rulePAssignment )
            {
            // InternalPerl.g:1517:5: (lv_value_4_0= rulePAssignment )
            // InternalPerl.g:1518:6: lv_value_4_0= rulePAssignment
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getPMemberFeatureCallAccess().getValuePAssignmentParserRuleCall_1_1_0());
              					
            }
            pushFollow(FOLLOW_2);
            lv_value_4_0=rulePAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getPMemberFeatureCallRule());
              						}
              						set(
              							current,
              							"value",
              							lv_value_4_0,
              							"org.epic.perl.Perl.PAssignment");
              						afterParserOrEnumRuleCall();
              					
            }

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
    // $ANTLR end "rulePMemberFeatureCall"


    // $ANTLR start "entryRulePPrimaryExpression"
    // InternalPerl.g:1540:1: entryRulePPrimaryExpression returns [EObject current=null] : iv_rulePPrimaryExpression= rulePPrimaryExpression EOF ;
    public final EObject entryRulePPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePPrimaryExpression = null;


        try {
            // InternalPerl.g:1540:59: (iv_rulePPrimaryExpression= rulePPrimaryExpression EOF )
            // InternalPerl.g:1541:2: iv_rulePPrimaryExpression= rulePPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePPrimaryExpression=rulePPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePPrimaryExpression; 
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
    // $ANTLR end "entryRulePPrimaryExpression"


    // $ANTLR start "rulePPrimaryExpression"
    // InternalPerl.g:1547:1: rulePPrimaryExpression returns [EObject current=null] : (this_PBlockExpression_0= rulePBlockExpression | this_PLiteral_1= rulePLiteral | this_PIfExpression_2= rulePIfExpression | this_PReturnExpression_3= rulePReturnExpression | this_PParenthesizedExpression_4= rulePParenthesizedExpression ) ;
    public final EObject rulePPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PBlockExpression_0 = null;

        EObject this_PLiteral_1 = null;

        EObject this_PIfExpression_2 = null;

        EObject this_PReturnExpression_3 = null;

        EObject this_PParenthesizedExpression_4 = null;



        	enterRule();

        try {
            // InternalPerl.g:1553:2: ( (this_PBlockExpression_0= rulePBlockExpression | this_PLiteral_1= rulePLiteral | this_PIfExpression_2= rulePIfExpression | this_PReturnExpression_3= rulePReturnExpression | this_PParenthesizedExpression_4= rulePParenthesizedExpression ) )
            // InternalPerl.g:1554:2: (this_PBlockExpression_0= rulePBlockExpression | this_PLiteral_1= rulePLiteral | this_PIfExpression_2= rulePIfExpression | this_PReturnExpression_3= rulePReturnExpression | this_PParenthesizedExpression_4= rulePParenthesizedExpression )
            {
            // InternalPerl.g:1554:2: (this_PBlockExpression_0= rulePBlockExpression | this_PLiteral_1= rulePLiteral | this_PIfExpression_2= rulePIfExpression | this_PReturnExpression_3= rulePReturnExpression | this_PParenthesizedExpression_4= rulePParenthesizedExpression )
            int alt21=5;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt21=1;
                }
                break;
            case RULE_STRING:
            case RULE_HEX:
            case RULE_BIN:
            case RULE_INT:
            case 43:
            case 56:
                {
                alt21=2;
                }
                break;
            case 49:
                {
                alt21=3;
                }
                break;
            case 57:
                {
                alt21=4;
                }
                break;
            case 47:
                {
                alt21=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalPerl.g:1555:3: this_PBlockExpression_0= rulePBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPPrimaryExpressionAccess().getPBlockExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PBlockExpression_0=rulePBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PBlockExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1564:3: this_PLiteral_1= rulePLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPPrimaryExpressionAccess().getPLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PLiteral_1=rulePLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1573:3: this_PIfExpression_2= rulePIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPPrimaryExpressionAccess().getPIfExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PIfExpression_2=rulePIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PIfExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalPerl.g:1582:3: this_PReturnExpression_3= rulePReturnExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPPrimaryExpressionAccess().getPReturnExpressionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PReturnExpression_3=rulePReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PReturnExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalPerl.g:1591:3: this_PParenthesizedExpression_4= rulePParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPPrimaryExpressionAccess().getPParenthesizedExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PParenthesizedExpression_4=rulePParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PParenthesizedExpression_4;
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
    // $ANTLR end "rulePPrimaryExpression"


    // $ANTLR start "entryRulePLiteral"
    // InternalPerl.g:1603:1: entryRulePLiteral returns [EObject current=null] : iv_rulePLiteral= rulePLiteral EOF ;
    public final EObject entryRulePLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePLiteral = null;


        try {
            // InternalPerl.g:1603:49: (iv_rulePLiteral= rulePLiteral EOF )
            // InternalPerl.g:1604:2: iv_rulePLiteral= rulePLiteral EOF
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
    // InternalPerl.g:1610:1: rulePLiteral returns [EObject current=null] : ( ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure ) | this_PNumberLiteral_1= rulePNumberLiteral | this_PNullLiteral_2= rulePNullLiteral | this_PStringLiteral_3= rulePStringLiteral ) ;
    public final EObject rulePLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_PClosure_0 = null;

        EObject this_PNumberLiteral_1 = null;

        EObject this_PNullLiteral_2 = null;

        EObject this_PStringLiteral_3 = null;



        	enterRule();

        try {
            // InternalPerl.g:1616:2: ( ( ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure ) | this_PNumberLiteral_1= rulePNumberLiteral | this_PNullLiteral_2= rulePNullLiteral | this_PStringLiteral_3= rulePStringLiteral ) )
            // InternalPerl.g:1617:2: ( ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure ) | this_PNumberLiteral_1= rulePNumberLiteral | this_PNullLiteral_2= rulePNullLiteral | this_PStringLiteral_3= rulePStringLiteral )
            {
            // InternalPerl.g:1617:2: ( ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure ) | this_PNumberLiteral_1= rulePNumberLiteral | this_PNullLiteral_2= rulePNullLiteral | this_PStringLiteral_3= rulePStringLiteral )
            int alt22=4;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==43) && (synpred12_InternalPerl())) {
                alt22=1;
            }
            else if ( ((LA22_0>=RULE_HEX && LA22_0<=RULE_INT)) ) {
                alt22=2;
            }
            else if ( (LA22_0==56) ) {
                alt22=3;
            }
            else if ( (LA22_0==RULE_STRING) ) {
                alt22=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalPerl.g:1618:3: ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure )
                    {
                    // InternalPerl.g:1618:3: ( ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure )
                    // InternalPerl.g:1619:4: ( ( () 'sub' '{' ) )=>this_PClosure_0= rulePClosure
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
                    // InternalPerl.g:1636:3: this_PNumberLiteral_1= rulePNumberLiteral
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
                    // InternalPerl.g:1645:3: this_PNullLiteral_2= rulePNullLiteral
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
                    // InternalPerl.g:1654:3: this_PStringLiteral_3= rulePStringLiteral
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
    // InternalPerl.g:1666:1: entryRulePClosure returns [EObject current=null] : iv_rulePClosure= rulePClosure EOF ;
    public final EObject entryRulePClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePClosure = null;


        try {
            // InternalPerl.g:1666:49: (iv_rulePClosure= rulePClosure EOF )
            // InternalPerl.g:1667:2: iv_rulePClosure= rulePClosure EOF
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
    // InternalPerl.g:1673:1: rulePClosure returns [EObject current=null] : ( ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) ) ( (lv_expression_3_0= rulePExpressionInClosure ) ) otherlv_4= '}' ) ;
    public final EObject rulePClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1679:2: ( ( ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) ) ( (lv_expression_3_0= rulePExpressionInClosure ) ) otherlv_4= '}' ) )
            // InternalPerl.g:1680:2: ( ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) ) ( (lv_expression_3_0= rulePExpressionInClosure ) ) otherlv_4= '}' )
            {
            // InternalPerl.g:1680:2: ( ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) ) ( (lv_expression_3_0= rulePExpressionInClosure ) ) otherlv_4= '}' )
            // InternalPerl.g:1681:3: ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) ) ( (lv_expression_3_0= rulePExpressionInClosure ) ) otherlv_4= '}'
            {
            // InternalPerl.g:1681:3: ( ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' ) )
            // InternalPerl.g:1682:4: ( ( () 'sub' '{' ) )=> ( () otherlv_1= 'sub' otherlv_2= '{' )
            {
            // InternalPerl.g:1689:4: ( () otherlv_1= 'sub' otherlv_2= '{' )
            // InternalPerl.g:1690:5: () otherlv_1= 'sub' otherlv_2= '{'
            {
            // InternalPerl.g:1690:5: ()
            // InternalPerl.g:1691:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getPClosureAccess().getPClosureAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,43,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getPClosureAccess().getSubKeyword_0_0_1());
              				
            }
            otherlv_2=(Token)match(input,44,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getPClosureAccess().getLeftCurlyBracketKeyword_0_0_2());
              				
            }

            }


            }

            // InternalPerl.g:1707:3: ( (lv_expression_3_0= rulePExpressionInClosure ) )
            // InternalPerl.g:1708:4: (lv_expression_3_0= rulePExpressionInClosure )
            {
            // InternalPerl.g:1708:4: (lv_expression_3_0= rulePExpressionInClosure )
            // InternalPerl.g:1709:5: lv_expression_3_0= rulePExpressionInClosure
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPClosureAccess().getExpressionPExpressionInClosureParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_22);
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

            otherlv_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalPerl.g:1734:1: entryRulePExpressionInClosure returns [EObject current=null] : iv_rulePExpressionInClosure= rulePExpressionInClosure EOF ;
    public final EObject entryRulePExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePExpressionInClosure = null;


        try {
            // InternalPerl.g:1734:61: (iv_rulePExpressionInClosure= rulePExpressionInClosure EOF )
            // InternalPerl.g:1735:2: iv_rulePExpressionInClosure= rulePExpressionInClosure EOF
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
    // InternalPerl.g:1741:1: rulePExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject rulePExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1747:2: ( ( () ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
            // InternalPerl.g:1748:2: ( () ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            {
            // InternalPerl.g:1748:2: ( () ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            // InternalPerl.g:1749:3: () ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            {
            // InternalPerl.g:1749:3: ()
            // InternalPerl.g:1750:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPExpressionInClosureAccess().getPBlockExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:1756:3: ( ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=34 && LA24_0<=35)||(LA24_0>=39 && LA24_0<=40)||(LA24_0>=51 && LA24_0<=55)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalPerl.g:1757:4: ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
            	    {
            	    // InternalPerl.g:1757:4: ( (lv_expressions_1_0= rulePExpressionOrVarDeclaration ) )
            	    // InternalPerl.g:1758:5: (lv_expressions_1_0= rulePExpressionOrVarDeclaration )
            	    {
            	    // InternalPerl.g:1758:5: (lv_expressions_1_0= rulePExpressionOrVarDeclaration )
            	    // InternalPerl.g:1759:6: lv_expressions_1_0= rulePExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPExpressionInClosureAccess().getExpressionsPExpressionOrVarDeclarationParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
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

            	    // InternalPerl.g:1776:4: (otherlv_2= ';' )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==46) ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // InternalPerl.g:1777:5: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,46,FOLLOW_24); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_2, grammarAccess.getPExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalPerl.g:1787:1: entryRulePParenthesizedExpression returns [EObject current=null] : iv_rulePParenthesizedExpression= rulePParenthesizedExpression EOF ;
    public final EObject entryRulePParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePParenthesizedExpression = null;


        try {
            // InternalPerl.g:1787:65: (iv_rulePParenthesizedExpression= rulePParenthesizedExpression EOF )
            // InternalPerl.g:1788:2: iv_rulePParenthesizedExpression= rulePParenthesizedExpression EOF
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
    // InternalPerl.g:1794:1: rulePParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_PExpression_1= rulePExpression otherlv_2= ')' ) ;
    public final EObject rulePParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_PExpression_1 = null;



        	enterRule();

        try {
            // InternalPerl.g:1800:2: ( (otherlv_0= '(' this_PExpression_1= rulePExpression otherlv_2= ')' ) )
            // InternalPerl.g:1801:2: (otherlv_0= '(' this_PExpression_1= rulePExpression otherlv_2= ')' )
            {
            // InternalPerl.g:1801:2: (otherlv_0= '(' this_PExpression_1= rulePExpression otherlv_2= ')' )
            // InternalPerl.g:1802:3: otherlv_0= '(' this_PExpression_1= rulePExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPParenthesizedExpressionAccess().getPExpressionParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_26);
            this_PExpression_1=rulePExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PExpression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalPerl.g:1822:1: entryRulePIfExpression returns [EObject current=null] : iv_rulePIfExpression= rulePIfExpression EOF ;
    public final EObject entryRulePIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePIfExpression = null;


        try {
            // InternalPerl.g:1822:54: (iv_rulePIfExpression= rulePIfExpression EOF )
            // InternalPerl.g:1823:2: iv_rulePIfExpression= rulePIfExpression EOF
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
    // InternalPerl.g:1829:1: rulePIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= rulePExpression ) ) otherlv_4= ')' ( (lv_then_5_0= rulePExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )? ) ;
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
            // InternalPerl.g:1835:2: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= rulePExpression ) ) otherlv_4= ')' ( (lv_then_5_0= rulePExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )? ) )
            // InternalPerl.g:1836:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= rulePExpression ) ) otherlv_4= ')' ( (lv_then_5_0= rulePExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )? )
            {
            // InternalPerl.g:1836:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= rulePExpression ) ) otherlv_4= ')' ( (lv_then_5_0= rulePExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )? )
            // InternalPerl.g:1837:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= rulePExpression ) ) otherlv_4= ')' ( (lv_then_5_0= rulePExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )?
            {
            // InternalPerl.g:1837:3: ()
            // InternalPerl.g:1838:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPIfExpressionAccess().getPIfExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,49,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPIfExpressionAccess().getIfKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,47,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPIfExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalPerl.g:1852:3: ( (lv_if_3_0= rulePExpression ) )
            // InternalPerl.g:1853:4: (lv_if_3_0= rulePExpression )
            {
            // InternalPerl.g:1853:4: (lv_if_3_0= rulePExpression )
            // InternalPerl.g:1854:5: lv_if_3_0= rulePExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPIfExpressionAccess().getIfPExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_26);
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

            otherlv_4=(Token)match(input,48,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPIfExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalPerl.g:1875:3: ( (lv_then_5_0= rulePExpression ) )
            // InternalPerl.g:1876:4: (lv_then_5_0= rulePExpression )
            {
            // InternalPerl.g:1876:4: (lv_then_5_0= rulePExpression )
            // InternalPerl.g:1877:5: lv_then_5_0= rulePExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPIfExpressionAccess().getThenPExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            // InternalPerl.g:1894:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==50) && (synpred14_InternalPerl())) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalPerl.g:1895:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= rulePExpression ) )
                    {
                    // InternalPerl.g:1895:4: ( ( 'else' )=>otherlv_6= 'else' )
                    // InternalPerl.g:1896:5: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,50,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getPIfExpressionAccess().getElseKeyword_6_0());
                      				
                    }

                    }

                    // InternalPerl.g:1902:4: ( (lv_else_7_0= rulePExpression ) )
                    // InternalPerl.g:1903:5: (lv_else_7_0= rulePExpression )
                    {
                    // InternalPerl.g:1903:5: (lv_else_7_0= rulePExpression )
                    // InternalPerl.g:1904:6: lv_else_7_0= rulePExpression
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
    // InternalPerl.g:1926:1: entryRulePBlockExpression returns [EObject current=null] : iv_rulePBlockExpression= rulePBlockExpression EOF ;
    public final EObject entryRulePBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePBlockExpression = null;


        try {
            // InternalPerl.g:1926:57: (iv_rulePBlockExpression= rulePBlockExpression EOF )
            // InternalPerl.g:1927:2: iv_rulePBlockExpression= rulePBlockExpression EOF
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
    // InternalPerl.g:1933:1: rulePBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject rulePBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1939:2: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // InternalPerl.g:1940:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // InternalPerl.g:1940:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // InternalPerl.g:1941:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // InternalPerl.g:1941:3: ()
            // InternalPerl.g:1942:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPBlockExpressionAccess().getPBlockExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,44,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalPerl.g:1952:3: ( ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=34 && LA27_0<=35)||(LA27_0>=39 && LA27_0<=40)||(LA27_0>=51 && LA27_0<=55)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalPerl.g:1953:4: ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) ) (otherlv_3= ';' )?
            	    {
            	    // InternalPerl.g:1953:4: ( (lv_expressions_2_0= rulePExpressionOrVarDeclaration ) )
            	    // InternalPerl.g:1954:5: (lv_expressions_2_0= rulePExpressionOrVarDeclaration )
            	    {
            	    // InternalPerl.g:1954:5: (lv_expressions_2_0= rulePExpressionOrVarDeclaration )
            	    // InternalPerl.g:1955:6: lv_expressions_2_0= rulePExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPBlockExpressionAccess().getExpressionsPExpressionOrVarDeclarationParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
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

            	    // InternalPerl.g:1972:4: (otherlv_3= ';' )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==46) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // InternalPerl.g:1973:5: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,46,FOLLOW_21); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_3, grammarAccess.getPBlockExpressionAccess().getSemicolonKeyword_2_1());
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
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
    // InternalPerl.g:1987:1: entryRulePExpressionOrVarDeclaration returns [EObject current=null] : iv_rulePExpressionOrVarDeclaration= rulePExpressionOrVarDeclaration EOF ;
    public final EObject entryRulePExpressionOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePExpressionOrVarDeclaration = null;


        try {
            // InternalPerl.g:1987:68: (iv_rulePExpressionOrVarDeclaration= rulePExpressionOrVarDeclaration EOF )
            // InternalPerl.g:1988:2: iv_rulePExpressionOrVarDeclaration= rulePExpressionOrVarDeclaration EOF
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
    // InternalPerl.g:1994:1: rulePExpressionOrVarDeclaration returns [EObject current=null] : (this_PVariableDeclaration_0= rulePVariableDeclaration | this_PExpression_1= rulePExpression ) ;
    public final EObject rulePExpressionOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_PVariableDeclaration_0 = null;

        EObject this_PExpression_1 = null;



        	enterRule();

        try {
            // InternalPerl.g:2000:2: ( (this_PVariableDeclaration_0= rulePVariableDeclaration | this_PExpression_1= rulePExpression ) )
            // InternalPerl.g:2001:2: (this_PVariableDeclaration_0= rulePVariableDeclaration | this_PExpression_1= rulePExpression )
            {
            // InternalPerl.g:2001:2: (this_PVariableDeclaration_0= rulePVariableDeclaration | this_PExpression_1= rulePExpression )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=51 && LA28_0<=53)) ) {
                alt28=1;
            }
            else if ( ((LA28_0>=34 && LA28_0<=35)||(LA28_0>=39 && LA28_0<=40)||(LA28_0>=54 && LA28_0<=55)) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalPerl.g:2002:3: this_PVariableDeclaration_0= rulePVariableDeclaration
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
                    // InternalPerl.g:2011:3: this_PExpression_1= rulePExpression
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
    // InternalPerl.g:2023:1: entryRulePVariableDeclaration returns [EObject current=null] : iv_rulePVariableDeclaration= rulePVariableDeclaration EOF ;
    public final EObject entryRulePVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePVariableDeclaration = null;


        try {
            // InternalPerl.g:2023:61: (iv_rulePVariableDeclaration= rulePVariableDeclaration EOF )
            // InternalPerl.g:2024:2: iv_rulePVariableDeclaration= rulePVariableDeclaration EOF
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
    // InternalPerl.g:2030:1: rulePVariableDeclaration returns [EObject current=null] : ( () (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' ) (otherlv_4= '$' | otherlv_5= '%' | otherlv_6= '@' ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_7_0= RULE_ID ) ) ) (otherlv_8= '=' ( (lv_right_9_0= rulePExpression ) ) )? ) ;
    public final EObject rulePVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        EObject lv_right_9_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:2036:2: ( ( () (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' ) (otherlv_4= '$' | otherlv_5= '%' | otherlv_6= '@' ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_7_0= RULE_ID ) ) ) (otherlv_8= '=' ( (lv_right_9_0= rulePExpression ) ) )? ) )
            // InternalPerl.g:2037:2: ( () (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' ) (otherlv_4= '$' | otherlv_5= '%' | otherlv_6= '@' ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_7_0= RULE_ID ) ) ) (otherlv_8= '=' ( (lv_right_9_0= rulePExpression ) ) )? )
            {
            // InternalPerl.g:2037:2: ( () (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' ) (otherlv_4= '$' | otherlv_5= '%' | otherlv_6= '@' ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_7_0= RULE_ID ) ) ) (otherlv_8= '=' ( (lv_right_9_0= rulePExpression ) ) )? )
            // InternalPerl.g:2038:3: () (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' ) (otherlv_4= '$' | otherlv_5= '%' | otherlv_6= '@' ) ( ( ( ( RULE_ID ) ) )=> ( (lv_name_7_0= RULE_ID ) ) ) (otherlv_8= '=' ( (lv_right_9_0= rulePExpression ) ) )?
            {
            // InternalPerl.g:2038:3: ()
            // InternalPerl.g:2039:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPVariableDeclarationAccess().getPVariableDeclarationAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:2045:3: (otherlv_1= 'my' | otherlv_2= 'our' | otherlv_3= 'local' )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt29=1;
                }
                break;
            case 52:
                {
                alt29=2;
                }
                break;
            case 53:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalPerl.g:2046:4: otherlv_1= 'my'
                    {
                    otherlv_1=(Token)match(input,51,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPVariableDeclarationAccess().getMyKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:2051:4: otherlv_2= 'our'
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPVariableDeclarationAccess().getOurKeyword_1_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:2056:4: otherlv_3= 'local'
                    {
                    otherlv_3=(Token)match(input,53,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPVariableDeclarationAccess().getLocalKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalPerl.g:2061:3: (otherlv_4= '$' | otherlv_5= '%' | otherlv_6= '@' )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt30=1;
                }
                break;
            case 39:
                {
                alt30=2;
                }
                break;
            case 55:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalPerl.g:2062:4: otherlv_4= '$'
                    {
                    otherlv_4=(Token)match(input,54,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPVariableDeclarationAccess().getDollarSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:2067:4: otherlv_5= '%'
                    {
                    otherlv_5=(Token)match(input,39,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPVariableDeclarationAccess().getPercentSignKeyword_2_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:2072:4: otherlv_6= '@'
                    {
                    otherlv_6=(Token)match(input,55,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getPVariableDeclarationAccess().getCommercialAtKeyword_2_2());
                      			
                    }

                    }
                    break;

            }

            // InternalPerl.g:2077:3: ( ( ( ( RULE_ID ) ) )=> ( (lv_name_7_0= RULE_ID ) ) )
            // InternalPerl.g:2078:4: ( ( ( RULE_ID ) ) )=> ( (lv_name_7_0= RULE_ID ) )
            {
            // InternalPerl.g:2084:4: ( (lv_name_7_0= RULE_ID ) )
            // InternalPerl.g:2085:5: (lv_name_7_0= RULE_ID )
            {
            // InternalPerl.g:2085:5: (lv_name_7_0= RULE_ID )
            // InternalPerl.g:2086:6: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(lv_name_7_0, grammarAccess.getPVariableDeclarationAccess().getNameIDTerminalRuleCall_3_0_0());
              					
            }
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getPVariableDeclarationRule());
              						}
              						setWithLastConsumed(
              							current,
              							"name",
              							lv_name_7_0,
              							"org.epic.perl.Perl.ID");
              					
            }

            }


            }


            }

            // InternalPerl.g:2103:3: (otherlv_8= '=' ( (lv_right_9_0= rulePExpression ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==12) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalPerl.g:2104:4: otherlv_8= '=' ( (lv_right_9_0= rulePExpression ) )
                    {
                    otherlv_8=(Token)match(input,12,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getPVariableDeclarationAccess().getEqualsSignKeyword_4_0());
                      			
                    }
                    // InternalPerl.g:2108:4: ( (lv_right_9_0= rulePExpression ) )
                    // InternalPerl.g:2109:5: (lv_right_9_0= rulePExpression )
                    {
                    // InternalPerl.g:2109:5: (lv_right_9_0= rulePExpression )
                    // InternalPerl.g:2110:6: lv_right_9_0= rulePExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPVariableDeclarationAccess().getRightPExpressionParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_9_0=rulePExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPVariableDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_9_0,
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


    // $ANTLR start "entryRuleFeatureCallID"
    // InternalPerl.g:2132:1: entryRuleFeatureCallID returns [String current=null] : iv_ruleFeatureCallID= ruleFeatureCallID EOF ;
    public final String entryRuleFeatureCallID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCallID = null;


        try {
            // InternalPerl.g:2132:53: (iv_ruleFeatureCallID= ruleFeatureCallID EOF )
            // InternalPerl.g:2133:2: iv_ruleFeatureCallID= ruleFeatureCallID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCallID=ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCallID.getText(); 
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
    // $ANTLR end "entryRuleFeatureCallID"


    // $ANTLR start "ruleFeatureCallID"
    // InternalPerl.g:2139:1: ruleFeatureCallID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '$' | kw= '%' | kw= '@' ) this_ID_3= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCallID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_3=null;


        	enterRule();

        try {
            // InternalPerl.g:2145:2: ( ( (kw= '$' | kw= '%' | kw= '@' ) this_ID_3= RULE_ID ) )
            // InternalPerl.g:2146:2: ( (kw= '$' | kw= '%' | kw= '@' ) this_ID_3= RULE_ID )
            {
            // InternalPerl.g:2146:2: ( (kw= '$' | kw= '%' | kw= '@' ) this_ID_3= RULE_ID )
            // InternalPerl.g:2147:3: (kw= '$' | kw= '%' | kw= '@' ) this_ID_3= RULE_ID
            {
            // InternalPerl.g:2147:3: (kw= '$' | kw= '%' | kw= '@' )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt32=1;
                }
                break;
            case 39:
                {
                alt32=2;
                }
                break;
            case 55:
                {
                alt32=3;
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
                    // InternalPerl.g:2148:4: kw= '$'
                    {
                    kw=(Token)match(input,54,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getDollarSignKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalPerl.g:2154:4: kw= '%'
                    {
                    kw=(Token)match(input,39,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getPercentSignKeyword_0_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalPerl.g:2160:4: kw= '@'
                    {
                    kw=(Token)match(input,55,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getCommercialAtKeyword_0_2());
                      			
                    }

                    }
                    break;

            }

            this_ID_3=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_3);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_3, grammarAccess.getFeatureCallIDAccess().getIDTerminalRuleCall_1());
              		
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
    // $ANTLR end "ruleFeatureCallID"


    // $ANTLR start "entryRulePNumberLiteral"
    // InternalPerl.g:2177:1: entryRulePNumberLiteral returns [EObject current=null] : iv_rulePNumberLiteral= rulePNumberLiteral EOF ;
    public final EObject entryRulePNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePNumberLiteral = null;


        try {
            // InternalPerl.g:2177:55: (iv_rulePNumberLiteral= rulePNumberLiteral EOF )
            // InternalPerl.g:2178:2: iv_rulePNumberLiteral= rulePNumberLiteral EOF
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
    // InternalPerl.g:2184:1: rulePNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final EObject rulePNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:2190:2: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // InternalPerl.g:2191:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // InternalPerl.g:2191:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // InternalPerl.g:2192:3: () ( (lv_value_1_0= ruleNumber ) )
            {
            // InternalPerl.g:2192:3: ()
            // InternalPerl.g:2193:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPNumberLiteralAccess().getPNumberLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:2199:3: ( (lv_value_1_0= ruleNumber ) )
            // InternalPerl.g:2200:4: (lv_value_1_0= ruleNumber )
            {
            // InternalPerl.g:2200:4: (lv_value_1_0= ruleNumber )
            // InternalPerl.g:2201:5: lv_value_1_0= ruleNumber
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
    // InternalPerl.g:2222:1: entryRulePNullLiteral returns [EObject current=null] : iv_rulePNullLiteral= rulePNullLiteral EOF ;
    public final EObject entryRulePNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePNullLiteral = null;


        try {
            // InternalPerl.g:2222:53: (iv_rulePNullLiteral= rulePNullLiteral EOF )
            // InternalPerl.g:2223:2: iv_rulePNullLiteral= rulePNullLiteral EOF
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
    // InternalPerl.g:2229:1: rulePNullLiteral returns [EObject current=null] : ( () otherlv_1= 'undef' ) ;
    public final EObject rulePNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPerl.g:2235:2: ( ( () otherlv_1= 'undef' ) )
            // InternalPerl.g:2236:2: ( () otherlv_1= 'undef' )
            {
            // InternalPerl.g:2236:2: ( () otherlv_1= 'undef' )
            // InternalPerl.g:2237:3: () otherlv_1= 'undef'
            {
            // InternalPerl.g:2237:3: ()
            // InternalPerl.g:2238:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPNullLiteralAccess().getPNullLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
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
    // InternalPerl.g:2252:1: entryRulePReturnExpression returns [EObject current=null] : iv_rulePReturnExpression= rulePReturnExpression EOF ;
    public final EObject entryRulePReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePReturnExpression = null;


        try {
            // InternalPerl.g:2252:58: (iv_rulePReturnExpression= rulePReturnExpression EOF )
            // InternalPerl.g:2253:2: iv_rulePReturnExpression= rulePReturnExpression EOF
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
    // InternalPerl.g:2259:1: rulePReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( '$' | '%' | '@' | '!' | '-' | '+' )=> (lv_expression_2_0= rulePExpression ) )? ) ;
    public final EObject rulePReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:2265:2: ( ( () otherlv_1= 'return' ( ( '$' | '%' | '@' | '!' | '-' | '+' )=> (lv_expression_2_0= rulePExpression ) )? ) )
            // InternalPerl.g:2266:2: ( () otherlv_1= 'return' ( ( '$' | '%' | '@' | '!' | '-' | '+' )=> (lv_expression_2_0= rulePExpression ) )? )
            {
            // InternalPerl.g:2266:2: ( () otherlv_1= 'return' ( ( '$' | '%' | '@' | '!' | '-' | '+' )=> (lv_expression_2_0= rulePExpression ) )? )
            // InternalPerl.g:2267:3: () otherlv_1= 'return' ( ( '$' | '%' | '@' | '!' | '-' | '+' )=> (lv_expression_2_0= rulePExpression ) )?
            {
            // InternalPerl.g:2267:3: ()
            // InternalPerl.g:2268:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPReturnExpressionAccess().getPReturnExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,57,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPReturnExpressionAccess().getReturnKeyword_1());
              		
            }
            // InternalPerl.g:2278:3: ( ( '$' | '%' | '@' | '!' | '-' | '+' )=> (lv_expression_2_0= rulePExpression ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==54) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred16_InternalPerl()) ) {
                    alt33=1;
                }
            }
            else if ( (LA33_0==39) ) {
                int LA33_2 = input.LA(2);

                if ( (synpred16_InternalPerl()) ) {
                    alt33=1;
                }
            }
            else if ( (LA33_0==55) ) {
                int LA33_3 = input.LA(2);

                if ( (synpred16_InternalPerl()) ) {
                    alt33=1;
                }
            }
            else if ( (LA33_0==40) && (synpred16_InternalPerl())) {
                alt33=1;
            }
            else if ( (LA33_0==35) && (synpred16_InternalPerl())) {
                alt33=1;
            }
            else if ( (LA33_0==34) && (synpred16_InternalPerl())) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalPerl.g:2279:4: ( '$' | '%' | '@' | '!' | '-' | '+' )=> (lv_expression_2_0= rulePExpression )
                    {
                    // InternalPerl.g:2280:4: (lv_expression_2_0= rulePExpression )
                    // InternalPerl.g:2281:5: lv_expression_2_0= rulePExpression
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
    // InternalPerl.g:2302:1: entryRulePStringLiteral returns [EObject current=null] : iv_rulePStringLiteral= rulePStringLiteral EOF ;
    public final EObject entryRulePStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePStringLiteral = null;


        try {
            // InternalPerl.g:2302:55: (iv_rulePStringLiteral= rulePStringLiteral EOF )
            // InternalPerl.g:2303:2: iv_rulePStringLiteral= rulePStringLiteral EOF
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
    // InternalPerl.g:2309:1: rulePStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject rulePStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalPerl.g:2315:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalPerl.g:2316:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalPerl.g:2316:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalPerl.g:2317:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalPerl.g:2317:3: ()
            // InternalPerl.g:2318:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPStringLiteralAccess().getPStringLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalPerl.g:2324:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalPerl.g:2325:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalPerl.g:2325:4: (lv_value_1_0= RULE_STRING )
            // InternalPerl.g:2326:5: lv_value_1_0= RULE_STRING
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
    // InternalPerl.g:2346:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalPerl.g:2346:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalPerl.g:2347:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalPerl.g:2353:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalPerl.g:2359:2: ( (this_ID_0= RULE_ID ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )* ) )
            // InternalPerl.g:2360:2: (this_ID_0= RULE_ID ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )* )
            {
            // InternalPerl.g:2360:2: (this_ID_0= RULE_ID ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )* )
            // InternalPerl.g:2361:3: this_ID_0= RULE_ID ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalPerl.g:2368:3: ( ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==58) && (synpred17_InternalPerl())) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalPerl.g:2369:4: ( ( '::' )=>kw= '::' ) this_ID_2= RULE_ID
            	    {
            	    // InternalPerl.g:2369:4: ( ( '::' )=>kw= '::' )
            	    // InternalPerl.g:2370:5: ( '::' )=>kw= '::'
            	    {
            	    kw=(Token)match(input,58,FOLLOW_30); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					current.merge(kw);
            	      					newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0());
            	      				
            	    }

            	    }

            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalPerl.g:2389:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:2391:2: (iv_ruleNumber= ruleNumber EOF )
            // InternalPerl.g:2392:2: iv_ruleNumber= ruleNumber EOF
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
    // InternalPerl.g:2401:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;
        Token this_BIN_1=null;
        Token this_INT_2=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:2408:2: ( (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) )
            // InternalPerl.g:2409:2: (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT )
            {
            // InternalPerl.g:2409:2: (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT )
            int alt35=3;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt35=1;
                }
                break;
            case RULE_BIN:
                {
                alt35=2;
                }
                break;
            case RULE_INT:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalPerl.g:2410:3: this_HEX_0= RULE_HEX
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
                    // InternalPerl.g:2418:3: this_BIN_1= RULE_BIN
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
                    // InternalPerl.g:2426:3: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_INT_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_INT_2, grammarAccess.getNumberAccess().getINTTerminalRuleCall_2());
                      		
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
        // InternalPerl.g:983:6: ( ( '>' '>' ) )
        // InternalPerl.g:983:7: ( '>' '>' )
        {
        // InternalPerl.g:983:7: ( '>' '>' )
        // InternalPerl.g:984:7: '>' '>'
        {
        match(input,20,FOLLOW_15); if (state.failed) return ;
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalPerl

    // $ANTLR start synpred8_InternalPerl
    public final void synpred8_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:1018:6: ( ( '<' '<' ) )
        // InternalPerl.g:1018:7: ( '<' '<' )
        {
        // InternalPerl.g:1018:7: ( '<' '<' )
        // InternalPerl.g:1019:7: '<' '<'
        {
        match(input,19,FOLLOW_6); if (state.failed) return ;
        match(input,19,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalPerl

    // $ANTLR start synpred9_InternalPerl
    public final void synpred9_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:1091:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalPerl.g:1091:6: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalPerl.g:1091:6: ( () ( ( ruleOpAdd ) ) )
        // InternalPerl.g:1092:6: () ( ( ruleOpAdd ) )
        {
        // InternalPerl.g:1092:6: ()
        // InternalPerl.g:1093:6: 
        {
        }

        // InternalPerl.g:1094:6: ( ( ruleOpAdd ) )
        // InternalPerl.g:1095:7: ( ruleOpAdd )
        {
        // InternalPerl.g:1095:7: ( ruleOpAdd )
        // InternalPerl.g:1096:8: ruleOpAdd
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
        // InternalPerl.g:1209:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalPerl.g:1209:6: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalPerl.g:1209:6: ( () ( ( ruleOpMulti ) ) )
        // InternalPerl.g:1210:6: () ( ( ruleOpMulti ) )
        {
        // InternalPerl.g:1210:6: ()
        // InternalPerl.g:1211:6: 
        {
        }

        // InternalPerl.g:1212:6: ( ( ruleOpMulti ) )
        // InternalPerl.g:1213:7: ( ruleOpMulti )
        {
        // InternalPerl.g:1213:7: ( ruleOpMulti )
        // InternalPerl.g:1214:8: ruleOpMulti
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

    // $ANTLR start synpred12_InternalPerl
    public final void synpred12_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:1619:4: ( ( () 'sub' '{' ) )
        // InternalPerl.g:1619:5: ( () 'sub' '{' )
        {
        // InternalPerl.g:1619:5: ( () 'sub' '{' )
        // InternalPerl.g:1620:5: () 'sub' '{'
        {
        // InternalPerl.g:1620:5: ()
        // InternalPerl.g:1621:5: 
        {
        }

        match(input,43,FOLLOW_20); if (state.failed) return ;
        match(input,44,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_InternalPerl

    // $ANTLR start synpred14_InternalPerl
    public final void synpred14_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:1896:5: ( 'else' )
        // InternalPerl.g:1896:6: 'else'
        {
        match(input,50,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalPerl

    // $ANTLR start synpred16_InternalPerl
    public final void synpred16_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:2279:4: ( '$' | '%' | '@' | '!' | '-' | '+' )
        // InternalPerl.g:
        {
        if ( (input.LA(1)>=34 && input.LA(1)<=35)||(input.LA(1)>=39 && input.LA(1)<=40)||(input.LA(1)>=54 && input.LA(1)<=55) ) {
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
    // $ANTLR end synpred16_InternalPerl

    // $ANTLR start synpred17_InternalPerl
    public final void synpred17_InternalPerl_fragment() throws RecognitionException {   
        // InternalPerl.g:2370:5: ( '::' )
        // InternalPerl.g:2370:6: '::'
        {
        match(input,58,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalPerl

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
    public final boolean synpred14_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalPerl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalPerl_fragment(); // can never throw exception
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
    public final boolean synpred12_InternalPerl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalPerl_fragment(); // can never throw exception
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
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\11\11\uffff";
    static final String dfa_3s = "\1\15\11\uffff";
    static final String dfa_4s = "\1\67\11\uffff";
    static final String dfa_5s = "\1\uffff\10\1\1\2";
    static final String dfa_6s = "\1\0\11\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\15\uffff\2\11\3\uffff\2\11\4\uffff\2\11\1\uffff\1\11\1\uffff\6\11",
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
                        if ( (LA1_0==13) && (synpred1_InternalPerl())) {s = 1;}

                        else if ( (LA1_0==14) && (synpred1_InternalPerl())) {s = 2;}

                        else if ( (LA1_0==15) && (synpred1_InternalPerl())) {s = 3;}

                        else if ( (LA1_0==16) && (synpred1_InternalPerl())) {s = 4;}

                        else if ( (LA1_0==17) && (synpred1_InternalPerl())) {s = 5;}

                        else if ( (LA1_0==18) && (synpred1_InternalPerl())) {s = 6;}

                        else if ( (LA1_0==19) && (synpred1_InternalPerl())) {s = 7;}

                        else if ( (LA1_0==20) && (synpred1_InternalPerl())) {s = 8;}

                        else if ( (LA1_0==EOF||(LA1_0>=34 && LA1_0<=35)||(LA1_0>=39 && LA1_0<=40)||(LA1_0>=45 && LA1_0<=46)||LA1_0==48||(LA1_0>=50 && LA1_0<=55)) ) {s = 9;}

                         
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
    static final String dfa_8s = "\23\uffff";
    static final String dfa_9s = "\1\1\22\uffff";
    static final String dfa_10s = "\1\15\1\uffff\1\14\1\24\6\uffff\1\14\1\uffff\1\24\6\uffff";
    static final String dfa_11s = "\1\67\1\uffff\2\50\6\uffff\1\50\1\uffff\1\50\6\uffff";
    static final String dfa_12s = "\1\uffff\1\2\2\uffff\6\1\1\uffff\1\1\1\uffff\6\1";
    static final String dfa_13s = "\1\3\1\uffff\1\4\1\2\6\uffff\1\1\1\uffff\1\0\6\uffff}>";
    static final String[] dfa_14s = {
            "\6\1\1\2\1\3\7\1\1\4\1\5\1\6\1\7\1\10\1\11\2\1\3\uffff\2\1\4\uffff\2\1\1\uffff\1\1\1\uffff\6\1",
            "",
            "\1\1\6\uffff\1\12\13\uffff\1\13\2\uffff\2\1\4\uffff\1\1",
            "\1\14\1\1\10\uffff\1\15\3\uffff\2\1\4\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\1\6\uffff\1\21\16\uffff\1\20\1\17\4\uffff\1\16",
            "",
            "\1\22\1\1\14\uffff\1\20\1\17\4\uffff\1\16",
            "",
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
                        int LA11_12 = input.LA(1);

                         
                        int index11_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_12==21) ) {s = 1;}

                        else if ( (LA11_12==40) && (synpred6_InternalPerl())) {s = 14;}

                        else if ( (LA11_12==35) && (synpred6_InternalPerl())) {s = 15;}

                        else if ( (LA11_12==34) && (synpred6_InternalPerl())) {s = 16;}

                        else if ( (LA11_12==20) && (synpred6_InternalPerl())) {s = 18;}

                         
                        input.seek(index11_12);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_10 = input.LA(1);

                         
                        int index11_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_10==40) && (synpred6_InternalPerl())) {s = 14;}

                        else if ( (LA11_10==35) && (synpred6_InternalPerl())) {s = 15;}

                        else if ( (LA11_10==34) && (synpred6_InternalPerl())) {s = 16;}

                        else if ( (LA11_10==19) && (synpred6_InternalPerl())) {s = 17;}

                        else if ( (LA11_10==12) ) {s = 1;}

                         
                        input.seek(index11_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_3 = input.LA(1);

                         
                        int index11_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_3==20) ) {s = 12;}

                        else if ( (LA11_3==21||(LA11_3>=34 && LA11_3<=35)||LA11_3==40) ) {s = 1;}

                        else if ( (LA11_3==30) && (synpred6_InternalPerl())) {s = 13;}

                         
                        input.seek(index11_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_0 = input.LA(1);

                         
                        int index11_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_0==EOF||(LA11_0>=13 && LA11_0<=18)||(LA11_0>=21 && LA11_0<=27)||(LA11_0>=34 && LA11_0<=35)||(LA11_0>=39 && LA11_0<=40)||(LA11_0>=45 && LA11_0<=46)||LA11_0==48||(LA11_0>=50 && LA11_0<=55)) ) {s = 1;}

                        else if ( (LA11_0==19) ) {s = 2;}

                        else if ( (LA11_0==20) ) {s = 3;}

                        else if ( (LA11_0==28) && (synpred6_InternalPerl())) {s = 4;}

                        else if ( (LA11_0==29) && (synpred6_InternalPerl())) {s = 5;}

                        else if ( (LA11_0==30) && (synpred6_InternalPerl())) {s = 6;}

                        else if ( (LA11_0==31) && (synpred6_InternalPerl())) {s = 7;}

                        else if ( (LA11_0==32) && (synpred6_InternalPerl())) {s = 8;}

                        else if ( (LA11_0==33) && (synpred6_InternalPerl())) {s = 9;}

                         
                        input.seek(index11_0);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_2 = input.LA(1);

                         
                        int index11_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_2==19) ) {s = 10;}

                        else if ( (LA11_2==31) && (synpred6_InternalPerl())) {s = 11;}

                        else if ( (LA11_2==12||(LA11_2>=34 && LA11_2<=35)||LA11_2==40) ) {s = 1;}

                         
                        input.seek(index11_2);
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
    static final String dfa_15s = "\13\uffff";
    static final String dfa_16s = "\1\23\2\uffff\1\24\7\uffff";
    static final String dfa_17s = "\1\41\2\uffff\1\36\7\uffff";
    static final String dfa_18s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\6\1\3";
    static final String dfa_19s = "\13\uffff}>";
    static final String[] dfa_20s = {
            "\1\6\1\3\7\uffff\1\1\1\2\1\4\1\5\1\7\1\10",
            "",
            "",
            "\1\11\11\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_15;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "937:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )";
        }
    }
    static final String dfa_21s = "\45\uffff";
    static final String dfa_22s = "\1\1\44\uffff";
    static final String dfa_23s = "\1\15\41\uffff\2\0\1\uffff";
    static final String dfa_24s = "\1\67\41\uffff\2\0\1\uffff";
    static final String dfa_25s = "\1\uffff\1\2\42\uffff\1\1";
    static final String dfa_26s = "\42\uffff\1\0\1\1\1\uffff}>";
    static final String[] dfa_27s = {
            "\25\1\1\43\1\42\3\uffff\2\1\4\uffff\2\1\1\uffff\1\1\1\uffff\6\1",
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
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[][] dfa_27 = unpackEncodedStringArray(dfa_27s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_21;
            this.eof = dfa_22;
            this.min = dfa_23;
            this.max = dfa_24;
            this.accept = dfa_25;
            this.special = dfa_26;
            this.transition = dfa_27;
        }
        public String getDescription() {
            return "()* loopback of 1089:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= rulePMultiplicativeExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_34 = input.LA(1);

                         
                        int index15_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalPerl()) ) {s = 36;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index15_34);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_35 = input.LA(1);

                         
                        int index15_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalPerl()) ) {s = 36;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index15_35);
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00C0018C00000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000001FE002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000000F000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000003F0180002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000080080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000F000000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00C0008000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00F8218C00000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00F8418C00000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00F8018C00000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00F8018C00000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00F8618C00000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0400000000000002L});

}