/*
 * generated by Xtext 2.10.0-SNAPSHOT
 */
package org.epic.perl.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.epic.perl.ide.contentassist.antlr.internal.InternalPerlParser;
import org.epic.perl.services.PerlGrammarAccess;

public class PerlParser extends AbstractContentAssistParser {

	@Inject
	private PerlGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalPerlParser createParser() {
		InternalPerlParser result = new InternalPerlParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getElementAccess().getAlternatives(), "rule__Element__Alternatives");
					put(grammarAccess.getStatementNodeAccess().getAlternatives_0(), "rule__StatementNode__Alternatives_0");
					put(grammarAccess.getIncludeStatementAccess().getAlternatives(), "rule__IncludeStatement__Alternatives");
					put(grammarAccess.getUseIncludeAccess().getAlternatives_2(), "rule__UseInclude__Alternatives_2");
					put(grammarAccess.getUseIncludeAccess().getAlternatives_2_1_1(), "rule__UseInclude__Alternatives_2_1_1");
					put(grammarAccess.getTokenAccess().getAlternatives(), "rule__Token__Alternatives");
					put(grammarAccess.getQuoteTokenAccess().getContentAlternatives_1_0(), "rule__QuoteToken__ContentAlternatives_1_0");
					put(grammarAccess.getQuoteLikeTokenAccess().getAlternatives(), "rule__QuoteLikeToken__Alternatives");
					put(grammarAccess.getKeywordAccess().getAlternatives(), "rule__Keyword__Alternatives");
					put(grammarAccess.getOperatorAccess().getAlternatives(), "rule__Operator__Alternatives");
					put(grammarAccess.getFileTestOperatorAccess().getAlternatives(), "rule__FileTestOperator__Alternatives");
					put(grammarAccess.getPerlDocumentAccess().getGroup(), "rule__PerlDocument__Group__0");
					put(grammarAccess.getStatementNodeAccess().getGroup(), "rule__StatementNode__Group__0");
					put(grammarAccess.getPackageStatementAccess().getGroup(), "rule__PackageStatement__Group__0");
					put(grammarAccess.getRequireIncludeAccess().getGroup(), "rule__RequireInclude__Group__0");
					put(grammarAccess.getUseIncludeAccess().getGroup(), "rule__UseInclude__Group__0");
					put(grammarAccess.getUseIncludeAccess().getGroup_2_1(), "rule__UseInclude__Group_2_1__0");
					put(grammarAccess.getTokenAccess().getGroup_0(), "rule__Token__Group_0__0");
					put(grammarAccess.getTokenAccess().getGroup_1(), "rule__Token__Group_1__0");
					put(grammarAccess.getTokenAccess().getGroup_2(), "rule__Token__Group_2__0");
					put(grammarAccess.getTokenAccess().getGroup_3(), "rule__Token__Group_3__0");
					put(grammarAccess.getTokenAccess().getGroup_5(), "rule__Token__Group_5__0");
					put(grammarAccess.getTokenAccess().getGroup_6(), "rule__Token__Group_6__0");
					put(grammarAccess.getTokenAccess().getGroup_8(), "rule__Token__Group_8__0");
					put(grammarAccess.getTokenAccess().getGroup_9(), "rule__Token__Group_9__0");
					put(grammarAccess.getQuoteTokenAccess().getGroup(), "rule__QuoteToken__Group__0");
					put(grammarAccess.getQuoteLikeTokenAccess().getGroup_0(), "rule__QuoteLikeToken__Group_0__0");
					put(grammarAccess.getQuoteLikeTokenAccess().getGroup_1(), "rule__QuoteLikeToken__Group_1__0");
					put(grammarAccess.getQuoteLikeTokenAccess().getGroup_2(), "rule__QuoteLikeToken__Group_2__0");
					put(grammarAccess.getQuoteLikeTokenAccess().getGroup_3(), "rule__QuoteLikeToken__Group_3__0");
					put(grammarAccess.getQuoteLikeTokenAccess().getGroup_4(), "rule__QuoteLikeToken__Group_4__0");
					put(grammarAccess.getOperatorAccess().getGroup_23(), "rule__Operator__Group_23__0");
					put(grammarAccess.getPerlDocumentAccess().getElementsAssignment_1(), "rule__PerlDocument__ElementsAssignment_1");
					put(grammarAccess.getPackageStatementAccess().getNameAssignment_2(), "rule__PackageStatement__NameAssignment_2");
					put(grammarAccess.getPackageStatementAccess().getVersionAssignment_3(), "rule__PackageStatement__VersionAssignment_3");
					put(grammarAccess.getRequireIncludeAccess().getVersionAssignment_1(), "rule__RequireInclude__VersionAssignment_1");
					put(grammarAccess.getUseIncludeAccess().getVersionAssignment_2_0(), "rule__UseInclude__VersionAssignment_2_0");
					put(grammarAccess.getUseIncludeAccess().getPragmaOrPackageAssignment_2_1_0(), "rule__UseInclude__PragmaOrPackageAssignment_2_1_0");
					put(grammarAccess.getUseIncludeAccess().getStringArgumentAssignment_2_1_1_0(), "rule__UseInclude__StringArgumentAssignment_2_1_1_0");
					put(grammarAccess.getUseIncludeAccess().getQwArgumentAssignment_2_1_1_1(), "rule__UseInclude__QwArgumentAssignment_2_1_1_1");
					put(grammarAccess.getTokenAccess().getContentAssignment_0_1(), "rule__Token__ContentAssignment_0_1");
					put(grammarAccess.getTokenAccess().getContentAssignment_1_1(), "rule__Token__ContentAssignment_1_1");
					put(grammarAccess.getTokenAccess().getContentAssignment_2_1(), "rule__Token__ContentAssignment_2_1");
					put(grammarAccess.getTokenAccess().getContentAssignment_3_1(), "rule__Token__ContentAssignment_3_1");
					put(grammarAccess.getTokenAccess().getContentAssignment_5_1(), "rule__Token__ContentAssignment_5_1");
					put(grammarAccess.getTokenAccess().getContentAssignment_6_1(), "rule__Token__ContentAssignment_6_1");
					put(grammarAccess.getTokenAccess().getContentAssignment_8_1(), "rule__Token__ContentAssignment_8_1");
					put(grammarAccess.getTokenAccess().getContentAssignment_9_1(), "rule__Token__ContentAssignment_9_1");
					put(grammarAccess.getQuoteTokenAccess().getContentAssignment_1(), "rule__QuoteToken__ContentAssignment_1");
					put(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_0_1(), "rule__QuoteLikeToken__ContentAssignment_0_1");
					put(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_1_1(), "rule__QuoteLikeToken__ContentAssignment_1_1");
					put(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_2_1(), "rule__QuoteLikeToken__ContentAssignment_2_1");
					put(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_3_1(), "rule__QuoteLikeToken__ContentAssignment_3_1");
					put(grammarAccess.getQuoteLikeTokenAccess().getContentAssignment_4_1(), "rule__QuoteLikeToken__ContentAssignment_4_1");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalPerlParser typedParser = (InternalPerlParser) parser;
			typedParser.entryRulePerlDocument();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_SL_COMMENT" };
	}

	public PerlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(PerlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
