/*
 * generated by Xtext 2.10.0-SNAPSHOT
 */
grammar InternalPerl;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.epic.perl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
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

}

@parser::members {

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

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRulePerlModel
entryRulePerlModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPerlModelRule()); }
	iv_rulePerlModel=rulePerlModel
	{ $current=$iv_rulePerlModel.current; }
	EOF;

// Rule PerlModel
rulePerlModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getPerlModelAccess().getElementsAbstractElementParserRuleCall_0());
			}
			lv_elements_0_0=ruleAbstractElement
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getPerlModelRule());
				}
				add(
					$current,
					"elements",
					lv_elements_0_0,
					"org.epic.perl.Perl.AbstractElement");
				afterParserOrEnumRuleCall();
			}
		)
	)*
;

// Entry rule entryRuleAbstractElement
entryRuleAbstractElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAbstractElementRule()); }
	iv_ruleAbstractElement=ruleAbstractElement
	{ $current=$iv_ruleAbstractElement.current; }
	EOF;

// Rule AbstractElement
ruleAbstractElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAbstractElementAccess().getAssignmentParserRuleCall_0());
		}
		this_Assignment_0=ruleAssignment
		{
			$current = $this_Assignment_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAbstractElementAccess().getExpressionParserRuleCall_1());
		}
		this_Expression_1=ruleExpression
		{
			$current = $this_Expression_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAssignment
entryRuleAssignment returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAssignmentRule()); }
	iv_ruleAssignment=ruleAssignment
	{ $current=$iv_ruleAssignment.current; }
	EOF;

// Rule Assignment
ruleAssignment returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='my'
			{
				newLeafNode(otherlv_0, grammarAccess.getAssignmentAccess().getMyKeyword_0_0());
			}
			    |
			otherlv_1='our'
			{
				newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getOurKeyword_0_1());
			}
			    |
			otherlv_2='local'
			{
				newLeafNode(otherlv_2, grammarAccess.getAssignmentAccess().getLocalKeyword_0_2());
			}
		)?
		(
			(
				lv_variable_3_0=RULE_ID
				{
					newLeafNode(lv_variable_3_0, grammarAccess.getAssignmentAccess().getVariableIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAssignmentRule());
					}
					setWithLastConsumed(
						$current,
						"variable",
						lv_variable_3_0,
						"org.epic.perl.Perl.ID");
				}
			)
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getAssignmentAccess().getOpOpSingleAssignParserRuleCall_2_0_0());
					}
					lv_op_4_1=ruleOpSingleAssign
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAssignmentRule());
						}
						set(
							$current,
							"op",
							lv_op_4_1,
							"org.epic.perl.Perl.OpSingleAssign");
						afterParserOrEnumRuleCall();
					}
					    |
					{
						newCompositeNode(grammarAccess.getAssignmentAccess().getOpOpMultiAssignParserRuleCall_2_0_1());
					}
					lv_op_4_2=ruleOpMultiAssign
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAssignmentRule());
						}
						set(
							$current,
							"op",
							lv_op_4_2,
							"org.epic.perl.Perl.OpMultiAssign");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_3_0());
				}
				lv_expression_5_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssignmentRule());
					}
					set(
						$current,
						"expression",
						lv_expression_5_0,
						"org.epic.perl.Perl.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleOpSingleAssign
entryRuleOpSingleAssign returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpSingleAssignRule()); }
	iv_ruleOpSingleAssign=ruleOpSingleAssign
	{ $current=$iv_ruleOpSingleAssign.current.getText(); }
	EOF;

// Rule OpSingleAssign
ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw='='
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword());
	}
;

// Entry rule entryRuleOpMultiAssign
entryRuleOpMultiAssign returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpMultiAssignRule()); }
	iv_ruleOpMultiAssign=ruleOpMultiAssign
	{ $current=$iv_ruleOpMultiAssign.current.getText(); }
	EOF;

// Rule OpMultiAssign
ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='+='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
		}
		    |
		kw='-='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
		}
		    |
		kw='*='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
		}
		    |
		kw='/='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
		}
		    |
		kw='%='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
		}
		    |
		kw='**='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskAsteriskEqualsSignKeyword_5());
		}
		    |
		(
			kw='<'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_0());
			}
			kw='<'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_6_1());
			}
			kw='='
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_6_2());
			}
		)
		    |
		(
			kw='>'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_0());
			}
			(
				kw='>'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_7_1());
				}
			)?
			kw='>='
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_7_2());
			}
		)
	)
;

// Entry rule entryRuleExpression
entryRuleExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExpressionRule()); }
	iv_ruleExpression=ruleExpression
	{ $current=$iv_ruleExpression.current; }
	EOF;

// Rule Expression
ruleExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getExpressionAccess().getOrParserRuleCall());
	}
	this_Or_0=ruleOr
	{
		$current = $this_Or_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleOr
entryRuleOr returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOrRule()); }
	iv_ruleOr=ruleOr
	{ $current=$iv_ruleOr.current; }
	EOF;

// Rule Or
ruleOr returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
		}
		this_And_0=ruleAnd
		{
			$current = $this_And_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getOrAccess().getOpOpOrParserRuleCall_1_1_0());
					}
					lv_op_2_0=ruleOpOr
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOrRule());
						}
						set(
							$current,
							"op",
							lv_op_2_0,
							"org.epic.perl.Perl.OpOr");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleAnd
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOrRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.epic.perl.Perl.And");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpOr
entryRuleOpOr returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpOrRule()); }
	iv_ruleOpOr=ruleOpOr
	{ $current=$iv_ruleOpOr.current.getText(); }
	EOF;

// Rule OpOr
ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw='||'
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword());
	}
;

// Entry rule entryRuleAnd
entryRuleAnd returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAndRule()); }
	iv_ruleAnd=ruleAnd
	{ $current=$iv_ruleAnd.current; }
	EOF;

// Rule And
ruleAnd returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAndAccess().getEqualityParserRuleCall_0());
		}
		this_Equality_0=ruleEquality
		{
			$current = $this_Equality_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAndAccess().getOpOpAndParserRuleCall_1_1_0());
					}
					lv_op_2_0=ruleOpAnd
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAndRule());
						}
						set(
							$current,
							"op",
							lv_op_2_0,
							"org.epic.perl.Perl.OpAnd");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleEquality
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAndRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.epic.perl.Perl.Equality");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpAnd
entryRuleOpAnd returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpAndRule()); }
	iv_ruleOpAnd=ruleOpAnd
	{ $current=$iv_ruleOpAnd.current.getText(); }
	EOF;

// Rule OpAnd
ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw='&&'
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword());
	}
;

// Entry rule entryRuleEquality
entryRuleEquality returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEqualityRule()); }
	iv_ruleEquality=ruleEquality
	{ $current=$iv_ruleEquality.current; }
	EOF;

// Rule Equality
ruleEquality returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0());
		}
		this_Comparison_0=ruleComparison
		{
			$current = $this_Comparison_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getEqualityAccess().getOpOpEqualityParserRuleCall_1_1_0());
					}
					lv_op_2_0=ruleOpEquality
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEqualityRule());
						}
						set(
							$current,
							"op",
							lv_op_2_0,
							"org.epic.perl.Perl.OpEquality");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleComparison
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEqualityRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.epic.perl.Perl.Comparison");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpEquality
entryRuleOpEquality returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpEqualityRule()); }
	iv_ruleOpEquality=ruleOpEquality
	{ $current=$iv_ruleOpEquality.current.getText(); }
	EOF;

// Rule OpEquality
ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='=='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
		}
		    |
		kw='!='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
		}
		    |
		kw='eq'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqKeyword_2());
		}
		    |
		kw='ne'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getNeKeyword_3());
		}
	)
;

// Entry rule entryRuleComparison
entryRuleComparison returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComparisonRule()); }
	iv_ruleComparison=ruleComparison
	{ $current=$iv_ruleComparison.current; }
	EOF;

// Rule Comparison
ruleComparison returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getComparisonAccess().getPlusOrMinusParserRuleCall_0());
		}
		this_PlusOrMinus_0=rulePlusOrMinus
		{
			$current = $this_PlusOrMinus_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0(),
						$current);
				}
			)
			(
				(
					(
						lv_op_2_1='>='
						{
							newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getComparisonRule());
							}
							setWithLastConsumed($current, "op", lv_op_2_1, null);
						}
						    |
						lv_op_2_2='<='
						{
							newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getComparisonRule());
							}
							setWithLastConsumed($current, "op", lv_op_2_2, null);
						}
						    |
						lv_op_2_3='>'
						{
							newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getComparisonRule());
							}
							setWithLastConsumed($current, "op", lv_op_2_3, null);
						}
						    |
						lv_op_2_4='<'
						{
							newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getComparisonRule());
							}
							setWithLastConsumed($current, "op", lv_op_2_4, null);
						}
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getComparisonAccess().getRightPlusOrMinusParserRuleCall_1_2_0());
					}
					lv_right_3_0=rulePlusOrMinus
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getComparisonRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.epic.perl.Perl.PlusOrMinus");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRulePlusOrMinus
entryRulePlusOrMinus returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPlusOrMinusRule()); }
	iv_rulePlusOrMinus=rulePlusOrMinus
	{ $current=$iv_rulePlusOrMinus.current; }
	EOF;

// Rule PlusOrMinus
rulePlusOrMinus returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getPlusOrMinusAccess().getMulOrDivParserRuleCall_0());
		}
		this_MulOrDiv_0=ruleMulOrDiv
		{
			$current = $this_MulOrDiv_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getPlusOrMinusAccess().getPlusLeftAction_1_0_0_0(),
								$current);
						}
					)
					otherlv_2='+'
					{
						newLeafNode(otherlv_2, grammarAccess.getPlusOrMinusAccess().getPlusSignKeyword_1_0_0_1());
					}
				)
				    |
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getPlusOrMinusAccess().getMinusLeftAction_1_0_1_0(),
								$current);
						}
					)
					otherlv_4='-'
					{
						newLeafNode(otherlv_4, grammarAccess.getPlusOrMinusAccess().getHyphenMinusKeyword_1_0_1_1());
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getPlusOrMinusAccess().getRightMulOrDivParserRuleCall_1_1_0());
					}
					lv_right_5_0=ruleMulOrDiv
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPlusOrMinusRule());
						}
						set(
							$current,
							"right",
							lv_right_5_0,
							"org.epic.perl.Perl.MulOrDiv");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleMulOrDiv
entryRuleMulOrDiv returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMulOrDivRule()); }
	iv_ruleMulOrDiv=ruleMulOrDiv
	{ $current=$iv_ruleMulOrDiv.current; }
	EOF;

// Rule MulOrDiv
ruleMulOrDiv returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getMulOrDivAccess().getPrimaryParserRuleCall_0());
		}
		this_Primary_0=rulePrimary
		{
			$current = $this_Primary_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getMulOrDivAccess().getMulOrDivLeftAction_1_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getMulOrDivAccess().getOpOpMulOrDivParserRuleCall_1_1_0());
					}
					lv_op_2_0=ruleOpMulOrDiv
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMulOrDivRule());
						}
						set(
							$current,
							"op",
							lv_op_2_0,
							"org.epic.perl.Perl.OpMulOrDiv");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getMulOrDivAccess().getRightPrimaryParserRuleCall_1_2_0());
					}
					lv_right_3_0=rulePrimary
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMulOrDivRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.epic.perl.Perl.Primary");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpMulOrDiv
entryRuleOpMulOrDiv returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpMulOrDivRule()); }
	iv_ruleOpMulOrDiv=ruleOpMulOrDiv
	{ $current=$iv_ruleOpMulOrDiv.current.getText(); }
	EOF;

// Rule OpMulOrDiv
ruleOpMulOrDiv returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='*'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMulOrDivAccess().getAsteriskKeyword_0());
		}
		    |
		kw='**'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMulOrDivAccess().getAsteriskAsteriskKeyword_1());
		}
		    |
		kw='/'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMulOrDivAccess().getSolidusKeyword_2());
		}
		    |
		kw='%'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMulOrDivAccess().getPercentSignKeyword_3());
		}
	)
;

// Entry rule entryRulePrimary
entryRulePrimary returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimaryRule()); }
	iv_rulePrimary=rulePrimary
	{ $current=$iv_rulePrimary.current; }
	EOF;

// Rule Primary
rulePrimary returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='('
			{
				newLeafNode(otherlv_0, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0());
			}
			{
				newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionParserRuleCall_0_1());
			}
			this_Expression_1=ruleExpression
			{
				$current = $this_Expression_1.current;
				afterParserOrEnumRuleCall();
			}
			otherlv_2=')'
			{
				newLeafNode(otherlv_2, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2());
			}
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getPrimaryAccess().getNotAction_1_0(),
						$current);
				}
			)
			otherlv_4='!'
			{
				newLeafNode(otherlv_4, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_1_2_0());
					}
					lv_expression_5_0=rulePrimary
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPrimaryRule());
						}
						set(
							$current,
							"expression",
							lv_expression_5_0,
							"org.epic.perl.Perl.Primary");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getAtomicParserRuleCall_2());
		}
		this_Atomic_6=ruleAtomic
		{
			$current = $this_Atomic_6.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAtomic
entryRuleAtomic returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAtomicRule()); }
	iv_ruleAtomic=ruleAtomic
	{ $current=$iv_ruleAtomic.current; }
	EOF;

// Rule Atomic
ruleAtomic returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getNumberLiteralParserRuleCall_0());
		}
		this_NumberLiteral_0=ruleNumberLiteral
		{
			$current = $this_NumberLiteral_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getNullLiteralParserRuleCall_1());
		}
		this_NullLiteral_1=ruleNullLiteral
		{
			$current = $this_NullLiteral_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getStringLiteralParserRuleCall_2());
		}
		this_StringLiteral_2=ruleStringLiteral
		{
			$current = $this_StringLiteral_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAtomicAccess().getVariableRefParserRuleCall_3());
		}
		this_VariableRef_3=ruleVariableRef
		{
			$current = $this_VariableRef_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleVariableRef
entryRuleVariableRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariableRefRule()); }
	iv_ruleVariableRef=ruleVariableRef
	{ $current=$iv_ruleVariableRef.current; }
	EOF;

// Rule VariableRef
ruleVariableRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_name_0_0=RULE_ID
			{
				newLeafNode(lv_name_0_0, grammarAccess.getVariableRefAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getVariableRefRule());
				}
				setWithLastConsumed(
					$current,
					"name",
					lv_name_0_0,
					"org.epic.perl.Perl.ID");
			}
		)
	)
;

// Entry rule entryRuleNumberLiteral
entryRuleNumberLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumberLiteralRule()); }
	iv_ruleNumberLiteral=ruleNumberLiteral
	{ $current=$iv_ruleNumberLiteral.current; }
	EOF;

// Rule NumberLiteral
ruleNumberLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getNumberLiteralAccess().getValueNumberParserRuleCall_1_0());
				}
				lv_value_1_0=ruleNumber
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNumberLiteralRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.epic.perl.Perl.Number");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleNullLiteral
entryRuleNullLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNullLiteralRule()); }
	iv_ruleNullLiteral=ruleNullLiteral
	{ $current=$iv_ruleNullLiteral.current; }
	EOF;

// Rule NullLiteral
ruleNullLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getNullLiteralAccess().getNullLiteralAction_0(),
					$current);
			}
		)
		otherlv_1='undef'
		{
			newLeafNode(otherlv_1, grammarAccess.getNullLiteralAccess().getUndefKeyword_1());
		}
	)
;

// Entry rule entryRuleStringLiteral
entryRuleStringLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStringLiteralRule()); }
	iv_ruleStringLiteral=ruleStringLiteral
	{ $current=$iv_ruleStringLiteral.current; }
	EOF;

// Rule StringLiteral
ruleStringLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
					$current);
			}
		)
		(
			(
				lv_value_1_0=RULE_STRING
				{
					newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStringLiteralRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_1_0,
						"org.epic.perl.Perl.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleNumber
entryRuleNumber returns [String current=null]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ newCompositeNode(grammarAccess.getNumberRule()); }
	iv_ruleNumber=ruleNumber
	{ $current=$iv_ruleNumber.current.getText(); }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Number
ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
@after {
	leaveRule();
}:
	(
		(
			this_HEX_0=RULE_HEX
			{
				$current.merge(this_HEX_0);
			}
			{
				newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0_0());
			}
			    |
			this_BIN_1=RULE_BIN
			{
				$current.merge(this_BIN_1);
			}
			{
				newLeafNode(this_BIN_1, grammarAccess.getNumberAccess().getBINTerminalRuleCall_0_1());
			}
			    |
			this_INT_2=RULE_INT
			{
				$current.merge(this_INT_2);
			}
			{
				newLeafNode(this_INT_2, grammarAccess.getNumberAccess().getINTTerminalRuleCall_0_2());
			}
		)
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_0());
			}
			this_INT_4=RULE_INT
			{
				$current.merge(this_INT_4);
			}
			{
				newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1());
			}
		)?
	)
;
finally {
	myHiddenTokenState.restore();
}

fragment RULE_VAR_START : ('@'|'$'|'%') ('@'|'$'|'%'|'*'|'#')*;

RULE_ID : RULE_VAR_START ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+;

RULE_BIN : '0b' ('0'..'1'|'_')+;

RULE_INT : '0'..'9' ('0'..'9'|'_')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_SL_COMMENT : '#' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;
