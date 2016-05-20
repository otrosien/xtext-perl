/*
 * generated by Xtext 2.9.1
 */
package org.epic.perl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.epic.perl.services.PerlGrammarAccess;

@SuppressWarnings("all")
public class PerlSyntacticSequencer extends AbstractSyntacticSequencer {

	protected PerlGrammarAccess grammarAccess;
	protected AbstractElementAlias match_PBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_PExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_PVariableDeclaration_LocalKeyword_1_2_or_MyKeyword_1_0_or_OurKeyword_1_1;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (PerlGrammarAccess) access;
		match_PBlockExpression_SemicolonKeyword_2_1_q = new TokenAlias(false, true, grammarAccess.getPBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_PExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getPExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_PVariableDeclaration_LocalKeyword_1_2_or_MyKeyword_1_0_or_OurKeyword_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getPVariableDeclarationAccess().getLocalKeyword_1_2()), new TokenAlias(false, false, grammarAccess.getPVariableDeclarationAccess().getMyKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getPVariableDeclarationAccess().getOurKeyword_1_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getPVarRule())
			return getPVarToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * OpSingleAssign:
	 * 	'='
	 * ;
	 */
	protected String getOpSingleAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	/**
	 * PVar:
	 * 	VAR_START ID
	 * ;
	 */
	protected String getPVarToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "@";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_PBlockExpression_SemicolonKeyword_2_1_q.equals(syntax))
				emit_PBlockExpression_SemicolonKeyword_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_PExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PVariableDeclaration_LocalKeyword_1_2_or_MyKeyword_1_0_or_OurKeyword_1_1.equals(syntax))
				emit_PVariableDeclaration_LocalKeyword_1_2_or_MyKeyword_1_0_or_OurKeyword_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     expressions+=PExpressionOrVarDeclaration (ambiguity) '}' (rule end)
	 *     expressions+=PExpressionOrVarDeclaration (ambiguity) expressions+=PExpressionOrVarDeclaration
	 */
	protected void emit_PBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     expressions+=PExpressionOrVarDeclaration (ambiguity) (rule end)
	 *     expressions+=PExpressionOrVarDeclaration (ambiguity) expressions+=PExpressionOrVarDeclaration
	 */
	protected void emit_PExpressionInClosure_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'my' | 'our' | 'local'
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) name=PVar
	 */
	protected void emit_PVariableDeclaration_LocalKeyword_1_2_or_MyKeyword_1_0_or_OurKeyword_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
