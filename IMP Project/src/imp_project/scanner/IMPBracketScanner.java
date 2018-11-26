package imp_project.scanner;

import org.eclipse.jface.text.*;
import org.eclipse.jface.text.rules.*;

import imp_project.editors.ColorManager;
import imp_project.editors.IIMPColorConstants;
import imp_project.editors.IMPWhitespaceDetector;


public class IMPBracketScanner extends RuleBasedScanner {

	public IMPBracketScanner(ColorManager manager) {

		IToken string = new Token(new TextAttribute(manager.getColor(IIMPColorConstants.STRING)));
		IToken character = new Token(new TextAttribute(manager.getColor(IIMPColorConstants.CHARACTER)));
		IToken comment = new Token(new TextAttribute(manager.getColor(IIMPColorConstants.IMP_COMMENT)));
		IToken tokens = new Token(new TextAttribute(manager.getColor(IIMPColorConstants.TOKEN)));
		
		IRule[] rules = new IRule[10];


		rules[0] = new SingleLineRule(":=", " ", tokens);
		rules[1] = new SingleLineRule("while", " ", tokens);
		rules[2] = new SingleLineRule("do", " ", tokens);
		rules[3] = new SingleLineRule(";", " ", tokens);
		rules[4] = new WordRule(new IdDetector(), string);
		rules[5] = new WordRule(new NumberDetector(), character);
		
		// Add rule for double quotes
		rules[6] = new SingleLineRule("\"", "\"", string);
		// Add a rule for single quotes
		rules[7] = new SingleLineRule("'", "'", character);
		// Add generic whitespace rule.
		rules[8] = new WhitespaceRule(new IMPWhitespaceDetector());
		
		rules[9] = new MultiLineRule("/*", "*/", comment);
		

		
		setRules(rules);
	}
}
