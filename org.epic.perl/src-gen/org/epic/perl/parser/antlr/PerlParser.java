/*
 * generated by Xtext 2.10.0-SNAPSHOT
 */
package org.epic.perl.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.epic.perl.parser.antlr.internal.InternalPerlParser;
import org.epic.perl.services.PerlGrammarAccess;

public class PerlParser extends AbstractAntlrParser {

	@Inject
	private PerlGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalPerlParser createParser(XtextTokenStream stream) {
		return new InternalPerlParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "PerlDocument";
	}

	public PerlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(PerlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
