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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_HEX", "RULE_BIN", "RULE_INT", "RULE_VAR_START", "RULE_SL_COMMENT", "RULE_WS", "'my'", "'our'", "'local'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'**='", "'<'", "'>'", "'>='", "'||'", "'&&'", "'=='", "'!='", "'eq'", "'ne'", "'<='", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'('", "')'", "'!'", "'undef'", "'.'"
    };
    public static final int RULE_HEX=6;
    public static final int RULE_STRING=5;
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
    public static final int RULE_BIN=7;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=11;
    public static final int RULE_VAR_START=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
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

        public InternalPerlParser(TokenStream input, PerlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "PerlModel";
       	}

       	@Override
       	protected PerlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulePerlModel"
    // InternalPerl.g:64:1: entryRulePerlModel returns [EObject current=null] : iv_rulePerlModel= rulePerlModel EOF ;
    public final EObject entryRulePerlModel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePerlModel = null;


        try {
            // InternalPerl.g:64:50: (iv_rulePerlModel= rulePerlModel EOF )
            // InternalPerl.g:65:2: iv_rulePerlModel= rulePerlModel EOF
            {
             newCompositeNode(grammarAccess.getPerlModelRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePerlModel=rulePerlModel();

            state._fsp--;

             current =iv_rulePerlModel; 
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
    // $ANTLR end "entryRulePerlModel"


    // $ANTLR start "rulePerlModel"
    // InternalPerl.g:71:1: rulePerlModel returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject rulePerlModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:77:2: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // InternalPerl.g:78:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // InternalPerl.g:78:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||(LA1_0>=12 && LA1_0<=14)||LA1_0==38||(LA1_0>=40 && LA1_0<=41)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPerl.g:79:3: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // InternalPerl.g:79:3: (lv_elements_0_0= ruleAbstractElement )
            	    // InternalPerl.g:80:4: lv_elements_0_0= ruleAbstractElement
            	    {

            	    				newCompositeNode(grammarAccess.getPerlModelAccess().getElementsAbstractElementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getPerlModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"org.epic.perl.Perl.AbstractElement");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "rulePerlModel"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalPerl.g:100:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // InternalPerl.g:100:56: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // InternalPerl.g:101:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
             newCompositeNode(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;

             current =iv_ruleAbstractElement; 
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
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalPerl.g:107:1: ruleAbstractElement returns [EObject current=null] : (this_Assignment_0= ruleAssignment | this_Expression_1= ruleExpression ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_Assignment_0 = null;

        EObject this_Expression_1 = null;



        	enterRule();

        try {
            // InternalPerl.g:113:2: ( (this_Assignment_0= ruleAssignment | this_Expression_1= ruleExpression ) )
            // InternalPerl.g:114:2: (this_Assignment_0= ruleAssignment | this_Expression_1= ruleExpression )
            {
            // InternalPerl.g:114:2: (this_Assignment_0= ruleAssignment | this_Expression_1= ruleExpression )
            int alt2=2;
            switch ( input.LA(1) ) {
            case 12:
            case 13:
            case 14:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    {
                    alt2=1;
                    }
                    break;
                case 22:
                    {
                    int LA2_4 = input.LA(3);

                    if ( ((LA2_4>=RULE_ID && LA2_4<=RULE_INT)||LA2_4==38||(LA2_4>=40 && LA2_4<=41)) ) {
                        alt2=2;
                    }
                    else if ( (LA2_4==22) ) {
                        alt2=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 23:
                    {
                    int LA2_5 = input.LA(3);

                    if ( ((LA2_5>=RULE_ID && LA2_5<=RULE_INT)||LA2_5==38||(LA2_5>=40 && LA2_5<=41)) ) {
                        alt2=2;
                    }
                    else if ( ((LA2_5>=23 && LA2_5<=24)) ) {
                        alt2=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case EOF:
                case RULE_ID:
                case RULE_STRING:
                case RULE_HEX:
                case RULE_BIN:
                case RULE_INT:
                case 12:
                case 13:
                case 14:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
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
            case RULE_STRING:
            case RULE_HEX:
            case RULE_BIN:
            case RULE_INT:
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
                    // InternalPerl.g:115:3: this_Assignment_0= ruleAssignment
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getAssignmentParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;


                    			current = this_Assignment_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:124:3: this_Expression_1= ruleExpression
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Expression_1=ruleExpression();

                    state._fsp--;


                    			current = this_Expression_1;
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
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleAssignment"
    // InternalPerl.g:136:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalPerl.g:136:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalPerl.g:137:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalPerl.g:143:1: ruleAssignment returns [EObject current=null] : ( (otherlv_0= 'my' | otherlv_1= 'our' | otherlv_2= 'local' )? ( (lv_variable_3_0= RULE_ID ) ) ( ( (lv_op_4_1= ruleOpSingleAssign | lv_op_4_2= ruleOpMultiAssign ) ) ) ( (lv_expression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_variable_3_0=null;
        AntlrDatatypeRuleToken lv_op_4_1 = null;

        AntlrDatatypeRuleToken lv_op_4_2 = null;

        EObject lv_expression_5_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:149:2: ( ( (otherlv_0= 'my' | otherlv_1= 'our' | otherlv_2= 'local' )? ( (lv_variable_3_0= RULE_ID ) ) ( ( (lv_op_4_1= ruleOpSingleAssign | lv_op_4_2= ruleOpMultiAssign ) ) ) ( (lv_expression_5_0= ruleExpression ) ) ) )
            // InternalPerl.g:150:2: ( (otherlv_0= 'my' | otherlv_1= 'our' | otherlv_2= 'local' )? ( (lv_variable_3_0= RULE_ID ) ) ( ( (lv_op_4_1= ruleOpSingleAssign | lv_op_4_2= ruleOpMultiAssign ) ) ) ( (lv_expression_5_0= ruleExpression ) ) )
            {
            // InternalPerl.g:150:2: ( (otherlv_0= 'my' | otherlv_1= 'our' | otherlv_2= 'local' )? ( (lv_variable_3_0= RULE_ID ) ) ( ( (lv_op_4_1= ruleOpSingleAssign | lv_op_4_2= ruleOpMultiAssign ) ) ) ( (lv_expression_5_0= ruleExpression ) ) )
            // InternalPerl.g:151:3: (otherlv_0= 'my' | otherlv_1= 'our' | otherlv_2= 'local' )? ( (lv_variable_3_0= RULE_ID ) ) ( ( (lv_op_4_1= ruleOpSingleAssign | lv_op_4_2= ruleOpMultiAssign ) ) ) ( (lv_expression_5_0= ruleExpression ) )
            {
            // InternalPerl.g:151:3: (otherlv_0= 'my' | otherlv_1= 'our' | otherlv_2= 'local' )?
            int alt3=4;
            switch ( input.LA(1) ) {
                case 12:
                    {
                    alt3=1;
                    }
                    break;
                case 13:
                    {
                    alt3=2;
                    }
                    break;
                case 14:
                    {
                    alt3=3;
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // InternalPerl.g:152:4: otherlv_0= 'my'
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_4); 

                    				newLeafNode(otherlv_0, grammarAccess.getAssignmentAccess().getMyKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalPerl.g:157:4: otherlv_1= 'our'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getOurKeyword_0_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalPerl.g:162:4: otherlv_2= 'local'
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getAssignmentAccess().getLocalKeyword_0_2());
                    			

                    }
                    break;

            }

            // InternalPerl.g:167:3: ( (lv_variable_3_0= RULE_ID ) )
            // InternalPerl.g:168:4: (lv_variable_3_0= RULE_ID )
            {
            // InternalPerl.g:168:4: (lv_variable_3_0= RULE_ID )
            // InternalPerl.g:169:5: lv_variable_3_0= RULE_ID
            {
            lv_variable_3_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_variable_3_0, grammarAccess.getAssignmentAccess().getVariableIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"variable",
            						lv_variable_3_0,
            						"org.epic.perl.Perl.ID");
            				

            }


            }

            // InternalPerl.g:185:3: ( ( (lv_op_4_1= ruleOpSingleAssign | lv_op_4_2= ruleOpMultiAssign ) ) )
            // InternalPerl.g:186:4: ( (lv_op_4_1= ruleOpSingleAssign | lv_op_4_2= ruleOpMultiAssign ) )
            {
            // InternalPerl.g:186:4: ( (lv_op_4_1= ruleOpSingleAssign | lv_op_4_2= ruleOpMultiAssign ) )
            // InternalPerl.g:187:5: (lv_op_4_1= ruleOpSingleAssign | lv_op_4_2= ruleOpMultiAssign )
            {
            // InternalPerl.g:187:5: (lv_op_4_1= ruleOpSingleAssign | lv_op_4_2= ruleOpMultiAssign )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=16 && LA4_0<=23)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalPerl.g:188:6: lv_op_4_1= ruleOpSingleAssign
                    {

                    						newCompositeNode(grammarAccess.getAssignmentAccess().getOpOpSingleAssignParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_op_4_1=ruleOpSingleAssign();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAssignmentRule());
                    						}
                    						set(
                    							current,
                    							"op",
                    							lv_op_4_1,
                    							"org.epic.perl.Perl.OpSingleAssign");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalPerl.g:204:6: lv_op_4_2= ruleOpMultiAssign
                    {

                    						newCompositeNode(grammarAccess.getAssignmentAccess().getOpOpMultiAssignParserRuleCall_2_0_1());
                    					
                    pushFollow(FOLLOW_6);
                    lv_op_4_2=ruleOpMultiAssign();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAssignmentRule());
                    						}
                    						set(
                    							current,
                    							"op",
                    							lv_op_4_2,
                    							"org.epic.perl.Perl.OpMultiAssign");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }

            // InternalPerl.g:222:3: ( (lv_expression_5_0= ruleExpression ) )
            // InternalPerl.g:223:4: (lv_expression_5_0= ruleExpression )
            {
            // InternalPerl.g:223:4: (lv_expression_5_0= ruleExpression )
            // InternalPerl.g:224:5: lv_expression_5_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_5_0,
            						"org.epic.perl.Perl.Expression");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // InternalPerl.g:245:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // InternalPerl.g:245:54: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // InternalPerl.g:246:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
             newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;

             current =iv_ruleOpSingleAssign.getText(); 
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
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // InternalPerl.g:252:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:258:2: (kw= '=' )
            // InternalPerl.g:259:2: kw= '='
            {
            kw=(Token)match(input,15,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword());
            	

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
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // InternalPerl.g:267:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // InternalPerl.g:267:53: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // InternalPerl.g:268:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
             newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;

             current =iv_ruleOpMultiAssign.getText(); 
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
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // InternalPerl.g:274:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= '**=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:280:2: ( (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= '**=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
            // InternalPerl.g:281:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= '**=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            {
            // InternalPerl.g:281:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | kw= '**=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            int alt6=8;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt6=1;
                }
                break;
            case 17:
                {
                alt6=2;
                }
                break;
            case 18:
                {
                alt6=3;
                }
                break;
            case 19:
                {
                alt6=4;
                }
                break;
            case 20:
                {
                alt6=5;
                }
                break;
            case 21:
                {
                alt6=6;
                }
                break;
            case 22:
                {
                alt6=7;
                }
                break;
            case 23:
                {
                alt6=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalPerl.g:282:3: kw= '+='
                    {
                    kw=(Token)match(input,16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:288:3: kw= '-='
                    {
                    kw=(Token)match(input,17,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalPerl.g:294:3: kw= '*='
                    {
                    kw=(Token)match(input,18,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalPerl.g:300:3: kw= '/='
                    {
                    kw=(Token)match(input,19,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalPerl.g:306:3: kw= '%='
                    {
                    kw=(Token)match(input,20,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalPerl.g:312:3: kw= '**='
                    {
                    kw=(Token)match(input,21,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskAsteriskEqualsSignKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalPerl.g:318:3: (kw= '<' kw= '<' kw= '=' )
                    {
                    // InternalPerl.g:318:3: (kw= '<' kw= '<' kw= '=' )
                    // InternalPerl.g:319:4: kw= '<' kw= '<' kw= '='
                    {
                    kw=(Token)match(input,22,FOLLOW_7); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_0());
                    			
                    kw=(Token)match(input,22,FOLLOW_8); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_1());
                    			
                    kw=(Token)match(input,15,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_6_2());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalPerl.g:336:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    {
                    // InternalPerl.g:336:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    // InternalPerl.g:337:4: kw= '>' (kw= '>' )? kw= '>='
                    {
                    kw=(Token)match(input,23,FOLLOW_9); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_0());
                    			
                    // InternalPerl.g:342:4: (kw= '>' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==23) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalPerl.g:343:5: kw= '>'
                            {
                            kw=(Token)match(input,23,FOLLOW_10); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_1());
                            				

                            }
                            break;

                    }

                    kw=(Token)match(input,24,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_7_2());
                    			

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
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleExpression"
    // InternalPerl.g:359:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalPerl.g:359:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalPerl.g:360:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalPerl.g:366:1: ruleExpression returns [EObject current=null] : this_Or_0= ruleOr ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Or_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:372:2: (this_Or_0= ruleOr )
            // InternalPerl.g:373:2: this_Or_0= ruleOr
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getOrParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Or_0=ruleOr();

            state._fsp--;


            		current = this_Or_0;
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOr"
    // InternalPerl.g:384:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalPerl.g:384:43: (iv_ruleOr= ruleOr EOF )
            // InternalPerl.g:385:2: iv_ruleOr= ruleOr EOF
            {
             newCompositeNode(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;

             current =iv_ruleOr; 
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
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalPerl.g:391:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () ( (lv_op_2_0= ruleOpOr ) ) ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        EObject this_And_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:397:2: ( (this_And_0= ruleAnd ( () ( (lv_op_2_0= ruleOpOr ) ) ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalPerl.g:398:2: (this_And_0= ruleAnd ( () ( (lv_op_2_0= ruleOpOr ) ) ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalPerl.g:398:2: (this_And_0= ruleAnd ( () ( (lv_op_2_0= ruleOpOr ) ) ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalPerl.g:399:3: this_And_0= ruleAnd ( () ( (lv_op_2_0= ruleOpOr ) ) ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_11);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPerl.g:407:3: ( () ( (lv_op_2_0= ruleOpOr ) ) ( (lv_right_3_0= ruleAnd ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPerl.g:408:4: () ( (lv_op_2_0= ruleOpOr ) ) ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalPerl.g:408:4: ()
            	    // InternalPerl.g:409:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPerl.g:415:4: ( (lv_op_2_0= ruleOpOr ) )
            	    // InternalPerl.g:416:5: (lv_op_2_0= ruleOpOr )
            	    {
            	    // InternalPerl.g:416:5: (lv_op_2_0= ruleOpOr )
            	    // InternalPerl.g:417:6: lv_op_2_0= ruleOpOr
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getOpOpOrParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_op_2_0=ruleOpOr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"op",
            	    							lv_op_2_0,
            	    							"org.epic.perl.Perl.OpOr");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalPerl.g:434:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalPerl.g:435:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalPerl.g:435:5: (lv_right_3_0= ruleAnd )
            	    // InternalPerl.g:436:6: lv_right_3_0= ruleAnd
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.epic.perl.Perl.And");
            	    						afterParserOrEnumRuleCall();
            	    					

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
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleOpOr"
    // InternalPerl.g:458:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalPerl.g:458:44: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalPerl.g:459:2: iv_ruleOpOr= ruleOpOr EOF
            {
             newCompositeNode(grammarAccess.getOpOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;

             current =iv_ruleOpOr.getText(); 
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
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalPerl.g:465:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:471:2: (kw= '||' )
            // InternalPerl.g:472:2: kw= '||'
            {
            kw=(Token)match(input,25,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword());
            	

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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleAnd"
    // InternalPerl.g:480:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalPerl.g:480:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalPerl.g:481:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
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
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalPerl.g:487:1: ruleAnd returns [EObject current=null] : (this_Equality_0= ruleEquality ( () ( (lv_op_2_0= ruleOpAnd ) ) ( (lv_right_3_0= ruleEquality ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        EObject this_Equality_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:493:2: ( (this_Equality_0= ruleEquality ( () ( (lv_op_2_0= ruleOpAnd ) ) ( (lv_right_3_0= ruleEquality ) ) )* ) )
            // InternalPerl.g:494:2: (this_Equality_0= ruleEquality ( () ( (lv_op_2_0= ruleOpAnd ) ) ( (lv_right_3_0= ruleEquality ) ) )* )
            {
            // InternalPerl.g:494:2: (this_Equality_0= ruleEquality ( () ( (lv_op_2_0= ruleOpAnd ) ) ( (lv_right_3_0= ruleEquality ) ) )* )
            // InternalPerl.g:495:3: this_Equality_0= ruleEquality ( () ( (lv_op_2_0= ruleOpAnd ) ) ( (lv_right_3_0= ruleEquality ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getEqualityParserRuleCall_0());
            		
            pushFollow(FOLLOW_13);
            this_Equality_0=ruleEquality();

            state._fsp--;


            			current = this_Equality_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPerl.g:503:3: ( () ( (lv_op_2_0= ruleOpAnd ) ) ( (lv_right_3_0= ruleEquality ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==26) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalPerl.g:504:4: () ( (lv_op_2_0= ruleOpAnd ) ) ( (lv_right_3_0= ruleEquality ) )
            	    {
            	    // InternalPerl.g:504:4: ()
            	    // InternalPerl.g:505:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPerl.g:511:4: ( (lv_op_2_0= ruleOpAnd ) )
            	    // InternalPerl.g:512:5: (lv_op_2_0= ruleOpAnd )
            	    {
            	    // InternalPerl.g:512:5: (lv_op_2_0= ruleOpAnd )
            	    // InternalPerl.g:513:6: lv_op_2_0= ruleOpAnd
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getOpOpAndParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    lv_op_2_0=ruleOpAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"op",
            	    							lv_op_2_0,
            	    							"org.epic.perl.Perl.OpAnd");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalPerl.g:530:4: ( (lv_right_3_0= ruleEquality ) )
            	    // InternalPerl.g:531:5: (lv_right_3_0= ruleEquality )
            	    {
            	    // InternalPerl.g:531:5: (lv_right_3_0= ruleEquality )
            	    // InternalPerl.g:532:6: lv_right_3_0= ruleEquality
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_right_3_0=ruleEquality();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.epic.perl.Perl.Equality");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleOpAnd"
    // InternalPerl.g:554:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalPerl.g:554:45: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalPerl.g:555:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
             newCompositeNode(grammarAccess.getOpAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;

             current =iv_ruleOpAnd.getText(); 
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
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalPerl.g:561:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:567:2: (kw= '&&' )
            // InternalPerl.g:568:2: kw= '&&'
            {
            kw=(Token)match(input,26,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword());
            	

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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleEquality"
    // InternalPerl.g:576:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // InternalPerl.g:576:49: (iv_ruleEquality= ruleEquality EOF )
            // InternalPerl.g:577:2: iv_ruleEquality= ruleEquality EOF
            {
             newCompositeNode(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEquality=ruleEquality();

            state._fsp--;

             current =iv_ruleEquality; 
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
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // InternalPerl.g:583:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( () ( (lv_op_2_0= ruleOpEquality ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        EObject this_Comparison_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:589:2: ( (this_Comparison_0= ruleComparison ( () ( (lv_op_2_0= ruleOpEquality ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalPerl.g:590:2: (this_Comparison_0= ruleComparison ( () ( (lv_op_2_0= ruleOpEquality ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalPerl.g:590:2: (this_Comparison_0= ruleComparison ( () ( (lv_op_2_0= ruleOpEquality ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalPerl.g:591:3: this_Comparison_0= ruleComparison ( () ( (lv_op_2_0= ruleOpEquality ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {

            			newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_Comparison_0=ruleComparison();

            state._fsp--;


            			current = this_Comparison_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPerl.g:599:3: ( () ( (lv_op_2_0= ruleOpEquality ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=27 && LA9_0<=30)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalPerl.g:600:4: () ( (lv_op_2_0= ruleOpEquality ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalPerl.g:600:4: ()
            	    // InternalPerl.g:601:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPerl.g:607:4: ( (lv_op_2_0= ruleOpEquality ) )
            	    // InternalPerl.g:608:5: (lv_op_2_0= ruleOpEquality )
            	    {
            	    // InternalPerl.g:608:5: (lv_op_2_0= ruleOpEquality )
            	    // InternalPerl.g:609:6: lv_op_2_0= ruleOpEquality
            	    {

            	    						newCompositeNode(grammarAccess.getEqualityAccess().getOpOpEqualityParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_op_2_0=ruleOpEquality();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEqualityRule());
            	    						}
            	    						set(
            	    							current,
            	    							"op",
            	    							lv_op_2_0,
            	    							"org.epic.perl.Perl.OpEquality");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalPerl.g:626:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalPerl.g:627:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalPerl.g:627:5: (lv_right_3_0= ruleComparison )
            	    // InternalPerl.g:628:6: lv_right_3_0= ruleComparison
            	    {

            	    						newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEqualityRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.epic.perl.Perl.Comparison");
            	    						afterParserOrEnumRuleCall();
            	    					

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
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleOpEquality"
    // InternalPerl.g:650:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalPerl.g:650:50: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalPerl.g:651:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
             newCompositeNode(grammarAccess.getOpEqualityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;

             current =iv_ruleOpEquality.getText(); 
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
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalPerl.g:657:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' | kw= 'eq' | kw= 'ne' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:663:2: ( (kw= '==' | kw= '!=' | kw= 'eq' | kw= 'ne' ) )
            // InternalPerl.g:664:2: (kw= '==' | kw= '!=' | kw= 'eq' | kw= 'ne' )
            {
            // InternalPerl.g:664:2: (kw= '==' | kw= '!=' | kw= 'eq' | kw= 'ne' )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt10=1;
                }
                break;
            case 28:
                {
                alt10=2;
                }
                break;
            case 29:
                {
                alt10=3;
                }
                break;
            case 30:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalPerl.g:665:3: kw= '=='
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:671:3: kw= '!='
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalPerl.g:677:3: kw= 'eq'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalPerl.g:683:3: kw= 'ne'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getNeKeyword_3());
                    		

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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleComparison"
    // InternalPerl.g:692:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalPerl.g:692:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalPerl.g:693:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
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
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalPerl.g:699:1: ruleComparison returns [EObject current=null] : (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_PlusOrMinus_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:705:2: ( (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* ) )
            // InternalPerl.g:706:2: (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* )
            {
            // InternalPerl.g:706:2: (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* )
            // InternalPerl.g:707:3: this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )*
            {

            			newCompositeNode(grammarAccess.getComparisonAccess().getPlusOrMinusParserRuleCall_0());
            		
            pushFollow(FOLLOW_17);
            this_PlusOrMinus_0=rulePlusOrMinus();

            state._fsp--;


            			current = this_PlusOrMinus_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPerl.g:715:3: ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=22 && LA12_0<=24)||LA12_0==31) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPerl.g:716:4: () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) )
            	    {
            	    // InternalPerl.g:716:4: ()
            	    // InternalPerl.g:717:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPerl.g:723:4: ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) )
            	    // InternalPerl.g:724:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    {
            	    // InternalPerl.g:724:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    // InternalPerl.g:725:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    {
            	    // InternalPerl.g:725:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    int alt11=4;
            	    switch ( input.LA(1) ) {
            	    case 24:
            	        {
            	        alt11=1;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt11=2;
            	        }
            	        break;
            	    case 23:
            	        {
            	        alt11=3;
            	        }
            	        break;
            	    case 22:
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
            	            // InternalPerl.g:726:7: lv_op_2_1= '>='
            	            {
            	            lv_op_2_1=(Token)match(input,24,FOLLOW_18); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalPerl.g:737:7: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,31,FOLLOW_18); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalPerl.g:748:7: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,23,FOLLOW_18); 

            	            							newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalPerl.g:759:7: lv_op_2_4= '<'
            	            {
            	            lv_op_2_4=(Token)match(input,22,FOLLOW_18); 

            	            							newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalPerl.g:772:4: ( (lv_right_3_0= rulePlusOrMinus ) )
            	    // InternalPerl.g:773:5: (lv_right_3_0= rulePlusOrMinus )
            	    {
            	    // InternalPerl.g:773:5: (lv_right_3_0= rulePlusOrMinus )
            	    // InternalPerl.g:774:6: lv_right_3_0= rulePlusOrMinus
            	    {

            	    						newCompositeNode(grammarAccess.getComparisonAccess().getRightPlusOrMinusParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_17);
            	    lv_right_3_0=rulePlusOrMinus();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getComparisonRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.epic.perl.Perl.PlusOrMinus");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRulePlusOrMinus"
    // InternalPerl.g:796:1: entryRulePlusOrMinus returns [EObject current=null] : iv_rulePlusOrMinus= rulePlusOrMinus EOF ;
    public final EObject entryRulePlusOrMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusOrMinus = null;


        try {
            // InternalPerl.g:796:52: (iv_rulePlusOrMinus= rulePlusOrMinus EOF )
            // InternalPerl.g:797:2: iv_rulePlusOrMinus= rulePlusOrMinus EOF
            {
             newCompositeNode(grammarAccess.getPlusOrMinusRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlusOrMinus=rulePlusOrMinus();

            state._fsp--;

             current =iv_rulePlusOrMinus; 
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
    // $ANTLR end "entryRulePlusOrMinus"


    // $ANTLR start "rulePlusOrMinus"
    // InternalPerl.g:803:1: rulePlusOrMinus returns [EObject current=null] : (this_MulOrDiv_0= ruleMulOrDiv ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMulOrDiv ) ) )* ) ;
    public final EObject rulePlusOrMinus() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_MulOrDiv_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:809:2: ( (this_MulOrDiv_0= ruleMulOrDiv ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMulOrDiv ) ) )* ) )
            // InternalPerl.g:810:2: (this_MulOrDiv_0= ruleMulOrDiv ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMulOrDiv ) ) )* )
            {
            // InternalPerl.g:810:2: (this_MulOrDiv_0= ruleMulOrDiv ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMulOrDiv ) ) )* )
            // InternalPerl.g:811:3: this_MulOrDiv_0= ruleMulOrDiv ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMulOrDiv ) ) )*
            {

            			newCompositeNode(grammarAccess.getPlusOrMinusAccess().getMulOrDivParserRuleCall_0());
            		
            pushFollow(FOLLOW_19);
            this_MulOrDiv_0=ruleMulOrDiv();

            state._fsp--;


            			current = this_MulOrDiv_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPerl.g:819:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMulOrDiv ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=32 && LA14_0<=33)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalPerl.g:820:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMulOrDiv ) )
            	    {
            	    // InternalPerl.g:820:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==32) ) {
            	        alt13=1;
            	    }
            	    else if ( (LA13_0==33) ) {
            	        alt13=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // InternalPerl.g:821:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalPerl.g:821:5: ( () otherlv_2= '+' )
            	            // InternalPerl.g:822:6: () otherlv_2= '+'
            	            {
            	            // InternalPerl.g:822:6: ()
            	            // InternalPerl.g:823:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getPlusOrMinusAccess().getPlusLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,32,FOLLOW_20); 

            	            						newLeafNode(otherlv_2, grammarAccess.getPlusOrMinusAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalPerl.g:835:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalPerl.g:835:5: ( () otherlv_4= '-' )
            	            // InternalPerl.g:836:6: () otherlv_4= '-'
            	            {
            	            // InternalPerl.g:836:6: ()
            	            // InternalPerl.g:837:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getPlusOrMinusAccess().getMinusLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,33,FOLLOW_20); 

            	            						newLeafNode(otherlv_4, grammarAccess.getPlusOrMinusAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalPerl.g:849:4: ( (lv_right_5_0= ruleMulOrDiv ) )
            	    // InternalPerl.g:850:5: (lv_right_5_0= ruleMulOrDiv )
            	    {
            	    // InternalPerl.g:850:5: (lv_right_5_0= ruleMulOrDiv )
            	    // InternalPerl.g:851:6: lv_right_5_0= ruleMulOrDiv
            	    {

            	    						newCompositeNode(grammarAccess.getPlusOrMinusAccess().getRightMulOrDivParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_right_5_0=ruleMulOrDiv();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPlusOrMinusRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"org.epic.perl.Perl.MulOrDiv");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "rulePlusOrMinus"


    // $ANTLR start "entryRuleMulOrDiv"
    // InternalPerl.g:873:1: entryRuleMulOrDiv returns [EObject current=null] : iv_ruleMulOrDiv= ruleMulOrDiv EOF ;
    public final EObject entryRuleMulOrDiv() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMulOrDiv = null;


        try {
            // InternalPerl.g:873:49: (iv_ruleMulOrDiv= ruleMulOrDiv EOF )
            // InternalPerl.g:874:2: iv_ruleMulOrDiv= ruleMulOrDiv EOF
            {
             newCompositeNode(grammarAccess.getMulOrDivRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMulOrDiv=ruleMulOrDiv();

            state._fsp--;

             current =iv_ruleMulOrDiv; 
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
    // $ANTLR end "entryRuleMulOrDiv"


    // $ANTLR start "ruleMulOrDiv"
    // InternalPerl.g:880:1: ruleMulOrDiv returns [EObject current=null] : (this_Primary_0= rulePrimary ( () ( (lv_op_2_0= ruleOpMulOrDiv ) ) ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleMulOrDiv() throws RecognitionException {
        EObject current = null;

        EObject this_Primary_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:886:2: ( (this_Primary_0= rulePrimary ( () ( (lv_op_2_0= ruleOpMulOrDiv ) ) ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalPerl.g:887:2: (this_Primary_0= rulePrimary ( () ( (lv_op_2_0= ruleOpMulOrDiv ) ) ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalPerl.g:887:2: (this_Primary_0= rulePrimary ( () ( (lv_op_2_0= ruleOpMulOrDiv ) ) ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalPerl.g:888:3: this_Primary_0= rulePrimary ( () ( (lv_op_2_0= ruleOpMulOrDiv ) ) ( (lv_right_3_0= rulePrimary ) ) )*
            {

            			newCompositeNode(grammarAccess.getMulOrDivAccess().getPrimaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_21);
            this_Primary_0=rulePrimary();

            state._fsp--;


            			current = this_Primary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPerl.g:896:3: ( () ( (lv_op_2_0= ruleOpMulOrDiv ) ) ( (lv_right_3_0= rulePrimary ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=34 && LA15_0<=37)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPerl.g:897:4: () ( (lv_op_2_0= ruleOpMulOrDiv ) ) ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalPerl.g:897:4: ()
            	    // InternalPerl.g:898:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getMulOrDivAccess().getMulOrDivLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPerl.g:904:4: ( (lv_op_2_0= ruleOpMulOrDiv ) )
            	    // InternalPerl.g:905:5: (lv_op_2_0= ruleOpMulOrDiv )
            	    {
            	    // InternalPerl.g:905:5: (lv_op_2_0= ruleOpMulOrDiv )
            	    // InternalPerl.g:906:6: lv_op_2_0= ruleOpMulOrDiv
            	    {

            	    						newCompositeNode(grammarAccess.getMulOrDivAccess().getOpOpMulOrDivParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_op_2_0=ruleOpMulOrDiv();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMulOrDivRule());
            	    						}
            	    						set(
            	    							current,
            	    							"op",
            	    							lv_op_2_0,
            	    							"org.epic.perl.Perl.OpMulOrDiv");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalPerl.g:923:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalPerl.g:924:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalPerl.g:924:5: (lv_right_3_0= rulePrimary )
            	    // InternalPerl.g:925:6: lv_right_3_0= rulePrimary
            	    {

            	    						newCompositeNode(grammarAccess.getMulOrDivAccess().getRightPrimaryParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMulOrDivRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.epic.perl.Perl.Primary");
            	    						afterParserOrEnumRuleCall();
            	    					

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
    // $ANTLR end "ruleMulOrDiv"


    // $ANTLR start "entryRuleOpMulOrDiv"
    // InternalPerl.g:947:1: entryRuleOpMulOrDiv returns [String current=null] : iv_ruleOpMulOrDiv= ruleOpMulOrDiv EOF ;
    public final String entryRuleOpMulOrDiv() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulOrDiv = null;


        try {
            // InternalPerl.g:947:50: (iv_ruleOpMulOrDiv= ruleOpMulOrDiv EOF )
            // InternalPerl.g:948:2: iv_ruleOpMulOrDiv= ruleOpMulOrDiv EOF
            {
             newCompositeNode(grammarAccess.getOpMulOrDivRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOpMulOrDiv=ruleOpMulOrDiv();

            state._fsp--;

             current =iv_ruleOpMulOrDiv.getText(); 
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
    // $ANTLR end "entryRuleOpMulOrDiv"


    // $ANTLR start "ruleOpMulOrDiv"
    // InternalPerl.g:954:1: ruleOpMulOrDiv returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulOrDiv() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalPerl.g:960:2: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // InternalPerl.g:961:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // InternalPerl.g:961:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt16=1;
                }
                break;
            case 35:
                {
                alt16=2;
                }
                break;
            case 36:
                {
                alt16=3;
                }
                break;
            case 37:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalPerl.g:962:3: kw= '*'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpMulOrDivAccess().getAsteriskKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:968:3: kw= '**'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpMulOrDivAccess().getAsteriskAsteriskKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalPerl.g:974:3: kw= '/'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpMulOrDivAccess().getSolidusKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalPerl.g:980:3: kw= '%'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOpMulOrDivAccess().getPercentSignKeyword_3());
                    		

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
    // $ANTLR end "ruleOpMulOrDiv"


    // $ANTLR start "entryRulePrimary"
    // InternalPerl.g:989:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalPerl.g:989:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalPerl.g:990:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
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
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalPerl.g:996:1: rulePrimary returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) ) | this_Atomic_6= ruleAtomic ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Expression_1 = null;

        EObject lv_expression_5_0 = null;

        EObject this_Atomic_6 = null;



        	enterRule();

        try {
            // InternalPerl.g:1002:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) ) | this_Atomic_6= ruleAtomic ) )
            // InternalPerl.g:1003:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) ) | this_Atomic_6= ruleAtomic )
            {
            // InternalPerl.g:1003:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) ) | this_Atomic_6= ruleAtomic )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt17=1;
                }
                break;
            case 40:
                {
                alt17=2;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case RULE_HEX:
            case RULE_BIN:
            case RULE_INT:
            case 41:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalPerl.g:1004:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalPerl.g:1004:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalPerl.g:1005:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,38,FOLLOW_23); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_24);
                    this_Expression_1=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,39,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPerl.g:1023:3: ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) )
                    {
                    // InternalPerl.g:1023:3: ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) )
                    // InternalPerl.g:1024:4: () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) )
                    {
                    // InternalPerl.g:1024:4: ()
                    // InternalPerl.g:1025:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryAccess().getNotAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_4=(Token)match(input,40,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_1_1());
                    			
                    // InternalPerl.g:1035:4: ( (lv_expression_5_0= rulePrimary ) )
                    // InternalPerl.g:1036:5: (lv_expression_5_0= rulePrimary )
                    {
                    // InternalPerl.g:1036:5: (lv_expression_5_0= rulePrimary )
                    // InternalPerl.g:1037:6: lv_expression_5_0= rulePrimary
                    {

                    						newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_expression_5_0=rulePrimary();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_5_0,
                    							"org.epic.perl.Perl.Primary");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPerl.g:1056:3: this_Atomic_6= ruleAtomic
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getAtomicParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Atomic_6=ruleAtomic();

                    state._fsp--;


                    			current = this_Atomic_6;
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
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleAtomic"
    // InternalPerl.g:1068:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // InternalPerl.g:1068:47: (iv_ruleAtomic= ruleAtomic EOF )
            // InternalPerl.g:1069:2: iv_ruleAtomic= ruleAtomic EOF
            {
             newCompositeNode(grammarAccess.getAtomicRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;

             current =iv_ruleAtomic; 
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
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // InternalPerl.g:1075:1: ruleAtomic returns [EObject current=null] : (this_NumberLiteral_0= ruleNumberLiteral | this_NullLiteral_1= ruleNullLiteral | this_StringLiteral_2= ruleStringLiteral | this_VariableRef_3= ruleVariableRef ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteral_0 = null;

        EObject this_NullLiteral_1 = null;

        EObject this_StringLiteral_2 = null;

        EObject this_VariableRef_3 = null;



        	enterRule();

        try {
            // InternalPerl.g:1081:2: ( (this_NumberLiteral_0= ruleNumberLiteral | this_NullLiteral_1= ruleNullLiteral | this_StringLiteral_2= ruleStringLiteral | this_VariableRef_3= ruleVariableRef ) )
            // InternalPerl.g:1082:2: (this_NumberLiteral_0= ruleNumberLiteral | this_NullLiteral_1= ruleNullLiteral | this_StringLiteral_2= ruleStringLiteral | this_VariableRef_3= ruleVariableRef )
            {
            // InternalPerl.g:1082:2: (this_NumberLiteral_0= ruleNumberLiteral | this_NullLiteral_1= ruleNullLiteral | this_StringLiteral_2= ruleStringLiteral | this_VariableRef_3= ruleVariableRef )
            int alt18=4;
            switch ( input.LA(1) ) {
            case RULE_HEX:
            case RULE_BIN:
            case RULE_INT:
                {
                alt18=1;
                }
                break;
            case 41:
                {
                alt18=2;
                }
                break;
            case RULE_STRING:
                {
                alt18=3;
                }
                break;
            case RULE_ID:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalPerl.g:1083:3: this_NumberLiteral_0= ruleNumberLiteral
                    {

                    			newCompositeNode(grammarAccess.getAtomicAccess().getNumberLiteralParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumberLiteral_0=ruleNumberLiteral();

                    state._fsp--;


                    			current = this_NumberLiteral_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1092:3: this_NullLiteral_1= ruleNullLiteral
                    {

                    			newCompositeNode(grammarAccess.getAtomicAccess().getNullLiteralParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NullLiteral_1=ruleNullLiteral();

                    state._fsp--;


                    			current = this_NullLiteral_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1101:3: this_StringLiteral_2= ruleStringLiteral
                    {

                    			newCompositeNode(grammarAccess.getAtomicAccess().getStringLiteralParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_2=ruleStringLiteral();

                    state._fsp--;


                    			current = this_StringLiteral_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalPerl.g:1110:3: this_VariableRef_3= ruleVariableRef
                    {

                    			newCompositeNode(grammarAccess.getAtomicAccess().getVariableRefParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableRef_3=ruleVariableRef();

                    state._fsp--;


                    			current = this_VariableRef_3;
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
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "entryRuleVariableRef"
    // InternalPerl.g:1122:1: entryRuleVariableRef returns [EObject current=null] : iv_ruleVariableRef= ruleVariableRef EOF ;
    public final EObject entryRuleVariableRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableRef = null;


        try {
            // InternalPerl.g:1122:52: (iv_ruleVariableRef= ruleVariableRef EOF )
            // InternalPerl.g:1123:2: iv_ruleVariableRef= ruleVariableRef EOF
            {
             newCompositeNode(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableRef=ruleVariableRef();

            state._fsp--;

             current =iv_ruleVariableRef; 
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
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalPerl.g:1129:1: ruleVariableRef returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleVariableRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPerl.g:1135:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPerl.g:1136:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPerl.g:1136:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPerl.g:1137:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPerl.g:1137:3: (lv_name_0_0= RULE_ID )
            // InternalPerl.g:1138:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getVariableRefAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVariableRefRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.epic.perl.Perl.ID");
            			

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
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleNumberLiteral"
    // InternalPerl.g:1157:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalPerl.g:1157:54: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalPerl.g:1158:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
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
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // InternalPerl.g:1164:1: ruleNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalPerl.g:1170:2: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // InternalPerl.g:1171:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // InternalPerl.g:1171:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // InternalPerl.g:1172:3: () ( (lv_value_1_0= ruleNumber ) )
            {
            // InternalPerl.g:1172:3: ()
            // InternalPerl.g:1173:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0(),
            					current);
            			

            }

            // InternalPerl.g:1179:3: ( (lv_value_1_0= ruleNumber ) )
            // InternalPerl.g:1180:4: (lv_value_1_0= ruleNumber )
            {
            // InternalPerl.g:1180:4: (lv_value_1_0= ruleNumber )
            // InternalPerl.g:1181:5: lv_value_1_0= ruleNumber
            {

            					newCompositeNode(grammarAccess.getNumberLiteralAccess().getValueNumberParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleNumber();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumberLiteralRule());
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
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleNullLiteral"
    // InternalPerl.g:1202:1: entryRuleNullLiteral returns [EObject current=null] : iv_ruleNullLiteral= ruleNullLiteral EOF ;
    public final EObject entryRuleNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteral = null;


        try {
            // InternalPerl.g:1202:52: (iv_ruleNullLiteral= ruleNullLiteral EOF )
            // InternalPerl.g:1203:2: iv_ruleNullLiteral= ruleNullLiteral EOF
            {
             newCompositeNode(grammarAccess.getNullLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNullLiteral=ruleNullLiteral();

            state._fsp--;

             current =iv_ruleNullLiteral; 
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
    // $ANTLR end "entryRuleNullLiteral"


    // $ANTLR start "ruleNullLiteral"
    // InternalPerl.g:1209:1: ruleNullLiteral returns [EObject current=null] : ( () otherlv_1= 'undef' ) ;
    public final EObject ruleNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPerl.g:1215:2: ( ( () otherlv_1= 'undef' ) )
            // InternalPerl.g:1216:2: ( () otherlv_1= 'undef' )
            {
            // InternalPerl.g:1216:2: ( () otherlv_1= 'undef' )
            // InternalPerl.g:1217:3: () otherlv_1= 'undef'
            {
            // InternalPerl.g:1217:3: ()
            // InternalPerl.g:1218:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNullLiteralAccess().getNullLiteralAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,41,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getNullLiteralAccess().getUndefKeyword_1());
            		

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
    // $ANTLR end "ruleNullLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalPerl.g:1232:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalPerl.g:1232:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalPerl.g:1233:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalPerl.g:1239:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalPerl.g:1245:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalPerl.g:1246:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalPerl.g:1246:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalPerl.g:1247:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalPerl.g:1247:3: ()
            // InternalPerl.g:1248:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
            					current);
            			

            }

            // InternalPerl.g:1254:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalPerl.g:1255:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalPerl.g:1255:4: (lv_value_1_0= RULE_STRING )
            // InternalPerl.g:1256:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringLiteralRule());
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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleNumber"
    // InternalPerl.g:1276:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalPerl.g:1278:2: (iv_ruleNumber= ruleNumber EOF )
            // InternalPerl.g:1279:2: iv_ruleNumber= ruleNumber EOF
            {
             newCompositeNode(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;

             current =iv_ruleNumber.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalPerl.g:1288:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) (kw= '.' this_INT_4= RULE_INT )? ) ;
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
            // InternalPerl.g:1295:2: ( ( (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) (kw= '.' this_INT_4= RULE_INT )? ) )
            // InternalPerl.g:1296:2: ( (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) (kw= '.' this_INT_4= RULE_INT )? )
            {
            // InternalPerl.g:1296:2: ( (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) (kw= '.' this_INT_4= RULE_INT )? )
            // InternalPerl.g:1297:3: (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT ) (kw= '.' this_INT_4= RULE_INT )?
            {
            // InternalPerl.g:1297:3: (this_HEX_0= RULE_HEX | this_BIN_1= RULE_BIN | this_INT_2= RULE_INT )
            int alt19=3;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt19=1;
                }
                break;
            case RULE_BIN:
                {
                alt19=2;
                }
                break;
            case RULE_INT:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalPerl.g:1298:4: this_HEX_0= RULE_HEX
                    {
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_25); 

                    				current.merge(this_HEX_0);
                    			

                    				newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalPerl.g:1306:4: this_BIN_1= RULE_BIN
                    {
                    this_BIN_1=(Token)match(input,RULE_BIN,FOLLOW_25); 

                    				current.merge(this_BIN_1);
                    			

                    				newLeafNode(this_BIN_1, grammarAccess.getNumberAccess().getBINTerminalRuleCall_0_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalPerl.g:1314:4: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_25); 

                    				current.merge(this_INT_2);
                    			

                    				newLeafNode(this_INT_2, grammarAccess.getNumberAccess().getINTTerminalRuleCall_0_2());
                    			

                    }
                    break;

            }

            // InternalPerl.g:1322:3: (kw= '.' this_INT_4= RULE_INT )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==42) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalPerl.g:1323:4: kw= '.' this_INT_4= RULE_INT
                    {
                    kw=(Token)match(input,42,FOLLOW_26); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_0());
                    			
                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_4);
                    			

                    				newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1());
                    			

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000340000071F2L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000FF8000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000340000071F0L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000340020071F0L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000340040071F0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000078000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000340780071F0L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000081C00002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000034081C071F0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000343000071F0L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000003C00000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000037C000071F0L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000003C0000071F0L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000100L});

}